package com.emanuelef.remote_capture.activities;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.ConnectionOverview;
import com.emanuelef.remote_capture.fragments.ConnectionPayload;
import com.emanuelef.remote_capture.interfaces.ConnectionsListener;
import com.emanuelef.remote_capture.interfaces.PayloadHostActivity;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.PayloadChunk;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConnectionDetailsActivity extends PayloadExportActivity implements ConnectionsListener, PayloadHostActivity {
    public static final String CONN_ID_KEY = "conn_id";
    public static final String FILTERED_IDS_KEY = "filtered_ids";
    private static final int MAX_CHUNKS_TO_CHECK = 10;
    private static final int POS_HTTP = 2;
    private static final int POS_OVERVIEW = 0;
    private static final int POS_RAW_PAYLOAD = 3;
    private static final int POS_WEBSOCKET = 1;
    private static final String TAG = "ConnectionDetails";
    private ConnectionDescriptor mConn;
    private int mConnId;
    private int mCurChunks;
    private Boolean mDisplayMode;
    private ArrayList<Integer> mFilteredIds;
    private int mFilteredIndex;
    private Handler mHandler;
    private boolean mHasHttpTab;
    private boolean mHasPayload;
    private boolean mHasWsTab;
    private boolean mListenerSet;
    private final ArrayList<PayloadHostActivity.ConnUpdateListener> mListeners = new ArrayList<>();
    private MenuItem mMenuCopy;
    private MenuItem mMenuDisplayAs;
    private MenuItem mMenuNext;
    private MenuItem mMenuPrev;
    private MenuItem mMenuShare;
    private ViewPager2 mPager;
    private StateAdapter mPagerAdapter;

    /* loaded from: classes.dex */
    public class StateAdapter extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            ConnectionDetailsActivity.this = r1;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            int i2 = getVisibleTabsPositions()[i];
            int i3 = ConnectionDetailsActivity.this.mConn.incr_id;
            if (i2 == 1) {
                return ConnectionPayload.newInstance(PayloadChunk.ChunkType.WEBSOCKET, i3);
            }
            if (i2 == 2) {
                return ConnectionPayload.newInstance(PayloadChunk.ChunkType.HTTP, i3);
            }
            if (i2 != 3) {
                return ConnectionOverview.newInstance(i3);
            }
            return ConnectionPayload.newInstance(PayloadChunk.ChunkType.RAW, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return (ConnectionDetailsActivity.this.mHasWsTab ? 1 : 0) + (ConnectionDetailsActivity.this.mHasHttpTab ? 1 : 0) + (ConnectionDetailsActivity.this.mHasPayload ? 1 : 0) + 1;
        }

        public int getPageTitle(int i) {
            int i2 = getVisibleTabsPositions()[i];
            if (i2 == 1) {
                return C0130R.string.websocket;
            }
            if (i2 == 2) {
                return C0130R.string.http;
            }
            if (i2 != 3) {
                return C0130R.string.overview;
            }
            return C0130R.string.payload;
        }

        public int[] getVisibleTabsPositions() {
            int[] iArr = new int[getItemCount()];
            iArr[0] = 0;
            int i = 1;
            if (ConnectionDetailsActivity.this.mHasWsTab) {
                iArr[1] = 1;
                i = 2;
            }
            if (ConnectionDetailsActivity.this.mHasHttpTab) {
                iArr[i] = 2;
                i++;
            }
            if (ConnectionDetailsActivity.this.mHasPayload) {
                iArr[i] = 3;
            }
            return iArr;
        }
    }

    public void dispatchConnUpdate() {
        ArrayList<PayloadHostActivity.ConnUpdateListener> arrayList = this.mListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PayloadHostActivity.ConnUpdateListener connUpdateListener = arrayList.get(i);
            i++;
            connUpdateListener.connectionUpdated();
        }
        if (this.mCurChunks < 10 && this.mConn.getNumPayloadChunks() > this.mCurChunks) {
            recheckTabs();
        }
        if (this.mConn.status >= 3) {
            unregisterConnsListener();
        }
    }

    private ArrayList<Integer> getAllConnectionIds() {
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        synchronized (connsRegister) {
            for (int i = 0; i < connsRegister.getConnCount(); i++) {
                try {
                    ConnectionDescriptor conn = connsRegister.getConn(i);
                    if (conn != null) {
                        arrayList.add(Integer.valueOf(conn.incr_id));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    private Fragment getCurrentFragment() {
        int currentItem = this.mPager.getCurrentItem();
        return getSupportFragmentManager().findFragmentByTag("f" + this.mPagerAdapter.getItemId(currentItem));
    }

    public /* synthetic */ void lambda$setupTabs$0(TabLayout.Tab tab, int i) {
        tab.setText(getString(this.mPagerAdapter.getPageTitle(i)));
    }

    private void loadConnection() {
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null) {
            ConnectionDescriptor connById = connsRegister.getConnById(this.mConnId);
            this.mConn = connById;
            if (connById != null) {
                setTitle(String.format(getString(C0130R.string.connection_number), Integer.valueOf(this.mConnId + 1)));
                unregisterConnsListener();
                int currentItem = this.mPager.getCurrentItem();
                this.mHasPayload = false;
                this.mHasHttpTab = false;
                this.mHasWsTab = false;
                this.mCurChunks = 0;
                setupTabs();
                if (currentItem < this.mPagerAdapter.getItemCount()) {
                    this.mPager.setCurrentItem(currentItem, false);
                } else {
                    this.mPager.setCurrentItem(0, false);
                }
                if (this.mConn.status < 3) {
                    registerConnsListener();
                }
                updateNavigationButtons();
                updateMenuVisibility();
                return;
            }
            Log.m581w(TAG, "Connection with ID " + this.mConnId + " not found");
        }
    }

    private void navigateToNext() {
        int indexOf;
        ArrayList<Integer> arrayList = this.mFilteredIds;
        if (arrayList == null) {
            arrayList = getAllConnectionIds();
        }
        if (arrayList != null && (indexOf = arrayList.indexOf(Integer.valueOf(this.mConnId))) >= 0 && indexOf < arrayList.size() - 1) {
            int i = indexOf + 1;
            this.mConnId = arrayList.get(i).intValue();
            if (this.mFilteredIds != null) {
                this.mFilteredIndex = i;
            }
            loadConnection();
        }
    }

    private void navigateToPrevious() {
        int indexOf;
        ArrayList<Integer> arrayList = this.mFilteredIds;
        if (arrayList == null) {
            arrayList = getAllConnectionIds();
        }
        if (arrayList != null && (indexOf = arrayList.indexOf(Integer.valueOf(this.mConnId))) > 0) {
            int i = indexOf - 1;
            this.mConnId = arrayList.get(i).intValue();
            if (this.mFilteredIds != null) {
                this.mFilteredIndex = i;
            }
            loadConnection();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private void recheckTabs() {
        boolean z;
        if (!this.mHasHttpTab || !this.mHasWsTab) {
            int min = Math.min(this.mConn.getNumPayloadChunks(), 10);
            if (this.mHasPayload || min <= 0) {
                z = false;
            } else {
                this.mHasPayload = true;
                z = true;
            }
            for (int i = this.mCurChunks; i < min; i++) {
                PayloadChunk payloadChunk = this.mConn.getPayloadChunk(i);
                if (payloadChunk != null) {
                    if (!this.mHasHttpTab && payloadChunk.type == PayloadChunk.ChunkType.HTTP) {
                        this.mHasHttpTab = true;
                    } else if (!this.mHasWsTab && payloadChunk.type == PayloadChunk.ChunkType.WEBSOCKET) {
                        this.mHasWsTab = true;
                    }
                    z = true;
                }
            }
            if (z) {
                this.mPagerAdapter.notifyDataSetChanged();
            }
            this.mCurChunks = min;
        }
    }

    private void registerConnsListener() {
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null && !this.mListenerSet && this.mConn.status < 3) {
            Log.m587d(TAG, "Adding connections listener");
            connsRegister.addListener(this);
            this.mListenerSet = true;
        }
        dispatchConnUpdate();
    }

    private void setupTabs() {
        StateAdapter stateAdapter = new StateAdapter(this);
        this.mPagerAdapter = stateAdapter;
        this.mPager.setAdapter(stateAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(C0130R.C0132id.tablayout);
        Utils.fixScrollableTabLayoutInsets(tabLayout);
        new zzw(tabLayout, this.mPager, new InputConnectionCompat$$ExternalSyntheticLambda0(2, this)).attach();
        ViewPager2 viewPager2 = this.mPager;
        ((ArrayList) viewPager2.mExternalPageChangeCallbacks.mCallbacks).add(new ViewPager2.OnPageChangeCallback() { // from class: com.emanuelef.remote_capture.activities.ConnectionDetailsActivity.1
            {
                ConnectionDetailsActivity.this = this;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                ConnectionDetailsActivity.this.updateMenuVisibility();
            }
        });
        this.mCurChunks = 0;
        recheckTabs();
    }

    private void unregisterConnsListener() {
        if (this.mListenerSet) {
            ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
            if (connsRegister != null) {
                Log.m587d(TAG, "Removing connections listener");
                connsRegister.removeListener(this);
            }
            this.mListenerSet = false;
        }
    }

    private void updateNavigationButtons() {
        boolean z;
        int i;
        int indexOf;
        boolean z2;
        if (this.mMenuPrev != null && this.mMenuNext != null) {
            ArrayList<Integer> arrayList = this.mFilteredIds;
            if (arrayList == null) {
                arrayList = getAllConnectionIds();
            }
            boolean z3 = false;
            if (arrayList == null || (indexOf = arrayList.indexOf(Integer.valueOf(this.mConnId))) < 0) {
                z = false;
            } else {
                if (indexOf > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (indexOf < arrayList.size() - 1) {
                    z3 = true;
                }
                z = z3;
                z3 = z2;
            }
            this.mMenuPrev.setEnabled(z3);
            int i2 = 80;
            if (this.mMenuPrev.getIcon() != null) {
                Drawable icon = this.mMenuPrev.getIcon();
                if (z3) {
                    i = 255;
                } else {
                    i = 80;
                }
                icon.setAlpha(i);
            }
            this.mMenuNext.setEnabled(z);
            if (this.mMenuNext.getIcon() != null) {
                Drawable icon2 = this.mMenuNext.getIcon();
                if (z) {
                    i2 = 255;
                }
                icon2.setAlpha(i2);
            }
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.PayloadHostActivity
    public void addConnUpdateListener(PayloadHostActivity.ConnUpdateListener connUpdateListener) {
        this.mListeners.add(connUpdateListener);
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsAdded(int i, ConnectionDescriptor[] connectionDescriptorArr) {
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsChanges(int i) {
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsRemoved(int i, ConnectionDescriptor[] connectionDescriptorArr) {
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsUpdated(int[] iArr) {
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null) {
            for (int i : iArr) {
                ConnectionDescriptor conn = connsRegister.getConn(i);
                if (conn != null && conn.incr_id == this.mConn.incr_id) {
                    this.mHandler.post(new ActivityCompat$$ExternalSyntheticLambda0(8, this));
                    return;
                }
            }
        }
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        displayBackAction();
        setContentView(C0130R.layout.tabs_activity_fixed);
        this.mConnId = getIntent().getIntExtra(CONN_ID_KEY, -1);
        ArrayList<Integer> integerArrayListExtra = getIntent().getIntegerArrayListExtra(FILTERED_IDS_KEY);
        this.mFilteredIds = integerArrayListExtra;
        this.mFilteredIndex = -1;
        if (integerArrayListExtra != null) {
            int i = 0;
            while (true) {
                if (i >= this.mFilteredIds.size()) {
                    break;
                } else if (this.mFilteredIds.get(i).intValue() == this.mConnId) {
                    this.mFilteredIndex = i;
                    break;
                } else {
                    i++;
                }
            }
            Log.m587d(TAG, "Using filtered navigation: " + this.mFilteredIds.size() + " items, index=" + this.mFilteredIndex);
        }
        if (this.mConnId != -1) {
            ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
            if (connsRegister != null) {
                this.mConn = connsRegister.getConnById(this.mConnId);
                setTitle(String.format(getString(C0130R.string.connection_number), Integer.valueOf(this.mConnId + 1)));
            }
        } else {
            setTitle(C0130R.string.connection_details);
        }
        if (this.mConn == null) {
            Log.m581w(TAG, "Connection with ID " + this.mConnId + " not found");
            finish();
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager2 = (ViewPager2) findViewById(C0130R.C0132id.pager);
        this.mPager = viewPager2;
        Utils.fixViewPager2Insets(viewPager2);
        setupTabs();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0130R.C0134menu.connection_details_menu, menu);
        this.mMenuPrev = menu.findItem(C0130R.C0132id.navigate_before);
        this.mMenuNext = menu.findItem(C0130R.C0132id.navigate_next);
        this.mMenuCopy = menu.findItem(C0130R.C0132id.copy_to_clipboard);
        this.mMenuShare = menu.findItem(C0130R.C0132id.share);
        this.mMenuDisplayAs = menu.findItem(C0130R.C0132id.display_as);
        updateNavigationButtons();
        updateMenuVisibility();
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        View view;
        if (i == 20) {
            View currentFocus = getCurrentFocus();
            Log.m587d(TAG, "onKeyDown focus ".concat(currentFocus.getClass().getName()));
            if (currentFocus instanceof TabLayout.TabView) {
                int currentItem = this.mPager.getCurrentItem();
                Log.m587d(TAG, "TabLayout.TabView focus pos " + currentItem);
                if (currentItem == 0) {
                    view = findViewById(C0130R.C0132id.connection_overview);
                } else {
                    view = findViewById(C0130R.C0132id.payload);
                }
                if (view != null) {
                    view.requestFocus();
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C0130R.C0132id.navigate_before) {
            navigateToPrevious();
            return true;
        } else if (itemId == C0130R.C0132id.navigate_next) {
            navigateToNext();
            return true;
        } else if (itemId != C0130R.C0132id.display_as) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            Boolean bool = this.mDisplayMode;
            if (bool != null) {
                this.mDisplayMode = Boolean.valueOf(!bool.booleanValue());
                updateMenuVisibility();
            }
            return true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        unregisterConnsListener();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerConnsListener();
    }

    @Override // com.emanuelef.remote_capture.interfaces.PayloadHostActivity
    public void removeConnUpdateListener(PayloadHostActivity.ConnUpdateListener connUpdateListener) {
        this.mListeners.remove(connUpdateListener);
    }

    @Override // com.emanuelef.remote_capture.interfaces.PayloadHostActivity
    public void updateMenuVisibility() {
        int i;
        boolean z;
        if (this.mMenuCopy != null && this.mMenuShare != null && this.mMenuDisplayAs != null) {
            int currentItem = this.mPager.getCurrentItem();
            int[] visibleTabsPositions = this.mPagerAdapter.getVisibleTabsPositions();
            boolean z2 = false;
            if (currentItem < visibleTabsPositions.length) {
                i = visibleTabsPositions[currentItem];
            } else {
                i = 0;
            }
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            this.mMenuCopy.setVisible(z);
            this.mMenuShare.setVisible(z);
            if (i == 1 || i == 2 || i == 3) {
                z2 = true;
            }
            this.mMenuDisplayAs.setVisible(z2);
            if (z2) {
                Fragment currentFragment = getCurrentFragment();
                if (currentFragment instanceof ConnectionPayload) {
                    ConnectionPayload connectionPayload = (ConnectionPayload) currentFragment;
                    if (this.mDisplayMode == null) {
                        this.mDisplayMode = Boolean.valueOf(connectionPayload.guessDisplayAsPrintable());
                    }
                    connectionPayload.setDisplayMode(this.mDisplayMode.booleanValue());
                    if (this.mDisplayMode.booleanValue()) {
                        this.mMenuDisplayAs.setTitle(C0130R.string.display_as_hexdump);
                    } else {
                        this.mMenuDisplayAs.setTitle(C0130R.string.display_as_text);
                    }
                }
            }
        }
    }
}
