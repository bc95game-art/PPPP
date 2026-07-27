package com.emanuelef.remote_capture.activities;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.HarWriter;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.ConnectionPayload;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment$$ExternalSyntheticLambda6;
import com.emanuelef.remote_capture.fragments.HttpPayloadFragment;
import com.emanuelef.remote_capture.interfaces.ConnectionsListener;
import com.emanuelef.remote_capture.interfaces.PayloadHostActivity;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.PayloadChunk;
import com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda3;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.tabs.TabLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class HttpDetailsActivity extends PayloadExportActivity implements ConnectionsListener, PayloadHostActivity {
    public static final String FILTERED_POSITIONS_KEY = "filtered_positions";
    public static final String HTTP_REQ_POS_KEY = "req_pos";
    private static final int POS_REPLY = 1;
    private static final int POS_REQUEST = 0;
    private static final int POS_WEBSOCKET = 2;
    private static final String TAG = "HttpRequestDetailsActivity";
    private AlertDialog mAlertDialog;
    private Boolean mDisplayMode;
    private int mFilteredIndex;
    private ArrayList<Integer> mFilteredPositions;
    private Handler mHandler;
    private Uri mHarFname;
    private HttpLog.HttpRequest mHttpReq;
    private boolean mListenerSet;
    private MenuItem mMenuDisplayAs;
    private MenuItem mMenuNext;
    private MenuItem mMenuPrev;
    private ViewPager2 mPager;
    private StateAdapter mPagerAdapter;
    private int mReqPos;
    private final ActivityResultLauncher harFileLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new HttpDetailsActivity$$ExternalSyntheticLambda0(this));
    private boolean mHasWebsocket = false;
    private final ArrayList<PayloadHostActivity.ConnUpdateListener> mListeners = new ArrayList<>();

    /* loaded from: classes.dex */
    public class StateAdapter extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            HttpDetailsActivity.this = r1;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            int position = HttpDetailsActivity.this.mHttpReq.getPosition();
            int i2 = getVisibleTabsPositions()[i];
            if (i2 == 1) {
                return HttpPayloadFragment.newInstance(position, true);
            }
            if (i2 != 2) {
                return HttpPayloadFragment.newInstance(position, false);
            }
            return ConnectionPayload.newInstance(PayloadChunk.ChunkType.WEBSOCKET, HttpDetailsActivity.this.mHttpReq.conn.incr_id);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i;
            if (HttpDetailsActivity.this.mHttpReq.reply != null) {
                i = 2;
            } else {
                i = 1;
            }
            if (HttpDetailsActivity.this.mHasWebsocket) {
                return i + 1;
            }
            return i;
        }

        public int getPageTitle(int i) {
            int i2 = getVisibleTabsPositions()[i];
            if (i2 == 1) {
                return C0130R.string.response;
            }
            if (i2 != 2) {
                return C0130R.string.request;
            }
            return C0130R.string.websocket;
        }

        public int[] getVisibleTabsPositions() {
            int[] iArr = new int[getItemCount()];
            iArr[0] = 0;
            char c = 1;
            if (HttpDetailsActivity.this.mHttpReq.reply != null) {
                iArr[1] = 1;
                c = 2;
            }
            if (HttpDetailsActivity.this.mHasWebsocket) {
                iArr[c] = 2;
            }
            return iArr;
        }
    }

    public void dispatchConnUpdate() {
        HttpLog.HttpRequest httpRequest;
        ArrayList<PayloadHostActivity.ConnUpdateListener> arrayList = this.mListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PayloadHostActivity.ConnUpdateListener connUpdateListener = arrayList.get(i);
            i++;
            connUpdateListener.connectionUpdated();
        }
        if (!this.mHasWebsocket && (httpRequest = this.mHttpReq) != null && httpRequest.hasWebsocketData()) {
            this.mHasWebsocket = true;
            this.mPagerAdapter.notifyDataSetChanged();
        }
        HttpLog.HttpRequest httpRequest2 = this.mHttpReq;
        if (httpRequest2 != null && httpRequest2.conn.status >= 3) {
            unregisterConnsListener();
        }
    }

    private void exportHar() {
        if (this.mHarFname != null && this.mHttpReq != null) {
            Log.m587d(TAG, "Writing HAR file: " + this.mHarFname);
            final ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            final boolean[] zArr = {false};
            zzbv zzbvVar = new zzbv(this);
            zzbvVar.setTitle(C0130R.string.exporting);
            zzbvVar.setMessage(C0130R.string.export_in_progress);
            zzbvVar.setNegativeButton(17039360, new AboutActivity$$ExternalSyntheticLambda2(zArr, 1, newSingleThreadExecutor));
            AlertDialog create = zzbvVar.create();
            this.mAlertDialog = create;
            create.setCanceledOnTouchOutside(false);
            this.mAlertDialog.show();
            this.mAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.emanuelef.remote_capture.activities.HttpDetailsActivity$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    HttpDetailsActivity.lambda$exportHar$2(zArr, newSingleThreadExecutor, dialogInterface);
                }
            });
            this.mAlertDialog.setOnDismissListener(new AppSelectDialog$$ExternalSyntheticLambda3(2, this));
            Uri uri = this.mHarFname;
            HttpLog.HttpRequest httpRequest = this.mHttpReq;
            this.mHarFname = null;
            newSingleThreadExecutor.execute(new MainActivity$$ExternalSyntheticLambda8(this, uri, httpRequest, zArr, handler));
        }
    }

    private Fragment getCurrentFragment() {
        int currentItem = this.mPager.getCurrentItem();
        return getSupportFragmentManager().findFragmentByTag("f" + this.mPagerAdapter.getItemId(currentItem));
    }

    public void harFileResult(ActivityResult activityResult) {
        Intent intent;
        if (activityResult.mResultCode != -1 || (intent = activityResult.mData) == null) {
            this.mHarFname = null;
            return;
        }
        this.mHarFname = intent.getData();
        exportHar();
    }

    public static /* synthetic */ void lambda$exportHar$1(boolean[] zArr, ExecutorService executorService, DialogInterface dialogInterface, int i) {
        Log.m583i(TAG, "Abort HAR export");
        zArr[0] = true;
        executorService.shutdownNow();
    }

    public static /* synthetic */ void lambda$exportHar$2(boolean[] zArr, ExecutorService executorService, DialogInterface dialogInterface) {
        Log.m583i(TAG, "Abort HAR export (back button)");
        zArr[0] = true;
        executorService.shutdownNow();
    }

    public /* synthetic */ void lambda$exportHar$3(DialogInterface dialogInterface) {
        this.mAlertDialog = null;
    }

    public /* synthetic */ void lambda$exportHar$4(boolean z, Utils.UriStat uriStat) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!z) {
            Utils.showToast(this, C0130R.string.cannot_write_file, new Object[0]);
        } else if (uriStat != null) {
            Utils.showToast(this, C0130R.string.file_saved_with_name, uriStat.name);
        } else {
            Utils.showToast(this, C0130R.string.save_ok, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$exportHar$5(Uri uri, HttpLog.HttpRequest httpRequest, boolean[] zArr, Handler handler) {
        boolean z;
        Utils.UriStat uriStat;
        OutputStream openOutputStream;
        try {
            openOutputStream = getContentResolver().openOutputStream(uri, "rwt");
        } catch (IOException e) {
            if (!zArr[0]) {
                e.printStackTrace();
            }
        }
        if (openOutputStream != null) {
            new HarWriter(this, httpRequest).write(openOutputStream);
            openOutputStream.close();
            z = true;
            if (zArr[0]) {
                if (z) {
                    uriStat = Utils.getUriStat(this, uri);
                } else {
                    uriStat = null;
                }
                handler.post(new ConnectionsFragment$$ExternalSyntheticLambda6(1, this, uriStat, z));
                return;
            }
            return;
        }
        z = false;
        if (zArr[0]) {
        }
    }

    public /* synthetic */ void lambda$setupTabs$0(TabLayout.Tab tab, int i) {
        tab.setText(getString(this.mPagerAdapter.getPageTitle(i)));
    }

    private void loadHttpRequest() {
        HttpLog httpLog = CaptureService.getHttpLog();
        if (httpLog != null) {
            HttpLog.HttpRequest request = httpLog.getRequest(this.mReqPos);
            this.mHttpReq = request;
            if (request != null) {
                setTitle(String.format(getString(C0130R.string.http_request_number), Integer.valueOf(this.mReqPos + 1)));
                this.mHasWebsocket = this.mHttpReq.hasWebsocketData();
                int currentItem = this.mPager.getCurrentItem();
                setupTabs();
                if (currentItem < this.mPagerAdapter.getItemCount()) {
                    this.mPager.setCurrentItem(currentItem, false);
                } else {
                    this.mPager.setCurrentItem(0, false);
                }
                updateNavigationButtons();
                updateMenuVisibility();
                return;
            }
            Log.m581w(TAG, "HTTP request with position " + this.mReqPos + " not found");
        }
    }

    private void navigateToNext() {
        int i;
        ArrayList<Integer> arrayList = this.mFilteredPositions;
        if (arrayList == null) {
            HttpLog httpLog = CaptureService.getHttpLog();
            if (httpLog != null) {
                i = httpLog.getSize();
            } else {
                i = 0;
            }
            int i2 = this.mReqPos;
            if (i2 < i - 1) {
                this.mReqPos = i2 + 1;
                loadHttpRequest();
            }
        } else if (this.mFilteredIndex < arrayList.size() - 1) {
            int i3 = this.mFilteredIndex + 1;
            this.mFilteredIndex = i3;
            this.mReqPos = this.mFilteredPositions.get(i3).intValue();
            loadHttpRequest();
        }
    }

    private void navigateToPrevious() {
        ArrayList<Integer> arrayList = this.mFilteredPositions;
        if (arrayList != null) {
            int i = this.mFilteredIndex;
            if (i > 0) {
                int i2 = i - 1;
                this.mFilteredIndex = i2;
                this.mReqPos = arrayList.get(i2).intValue();
                loadHttpRequest();
                return;
            }
            return;
        }
        int i3 = this.mReqPos;
        if (i3 > 0) {
            this.mReqPos = i3 - 1;
            loadHttpRequest();
        }
    }

    private void openHarFileSelector() {
        if (this.mHttpReq != null) {
            String exportFileName = Utils.getExportFileName(this, "har");
            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.TITLE", exportFileName);
            if (Utils.supportsFileDialog(this, intent)) {
                try {
                    this.harFileLauncher.launch(intent);
                    return;
                } catch (ActivityNotFoundException unused) {
                }
            }
            Log.m587d(TAG, "No app found to handle file selection");
            Uri downloadsUri = Utils.getDownloadsUri(this, exportFileName);
            if (downloadsUri != null) {
                this.mHarFname = downloadsUri;
                exportHar();
                return;
            }
            Utils.showToastLong(this, C0130R.string.no_activity_file_selection, new Object[0]);
        }
    }

    private void registerConnsListener() {
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null && !this.mListenerSet && this.mHttpReq.conn.status < 3) {
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
        new zzw(tabLayout, this.mPager, new HttpDetailsActivity$$ExternalSyntheticLambda0(this)).attach();
        ViewPager2 viewPager2 = this.mPager;
        ((ArrayList) viewPager2.mExternalPageChangeCallbacks.mCallbacks).add(new ViewPager2.OnPageChangeCallback() { // from class: com.emanuelef.remote_capture.activities.HttpDetailsActivity.1
            {
                HttpDetailsActivity.this = this;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                HttpDetailsActivity.this.updateMenuVisibility();
            }
        });
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r3 < (r0.size() - 1)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
        if (r3 < (r0 - 1)) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0037, code lost:
        r5.mMenuPrev.setEnabled(r4);
        r2 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
        if (r5.mMenuPrev.getIcon() == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        r0 = r5.mMenuPrev.getIcon();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        if (r4 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
        r4 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
        r4 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
        r0.setAlpha(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
        r5.mMenuNext.setEnabled(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
        if (r5.mMenuNext.getIcon() == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        r0 = r5.mMenuNext.getIcon();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
        if (r1 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
        r2 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
        r0.setAlpha(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0072, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateNavigationButtons() {
        boolean z;
        int i;
        if (this.mMenuPrev != null && this.mMenuNext != null) {
            ArrayList<Integer> arrayList = this.mFilteredPositions;
            boolean z2 = false;
            if (arrayList != null) {
                int i2 = this.mFilteredIndex;
                if (i2 > 0) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                HttpLog httpLog = CaptureService.getHttpLog();
                if (httpLog != null) {
                    i = httpLog.getSize();
                } else {
                    i = 0;
                }
                int i3 = this.mReqPos;
                if (i3 > 0) {
                    z = true;
                } else {
                    z = false;
                }
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
        if (!(connsRegister == null || this.mHttpReq == null)) {
            for (int i : iArr) {
                ConnectionDescriptor conn = connsRegister.getConn(i);
                if (conn != null && conn.incr_id == this.mHttpReq.conn.incr_id) {
                    this.mHandler.post(new ActivityCompat$$ExternalSyntheticLambda0(9, this));
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
        this.mReqPos = getIntent().getIntExtra(HTTP_REQ_POS_KEY, -1);
        ArrayList<Integer> integerArrayListExtra = getIntent().getIntegerArrayListExtra(FILTERED_POSITIONS_KEY);
        this.mFilteredPositions = integerArrayListExtra;
        this.mFilteredIndex = -1;
        if (integerArrayListExtra != null) {
            int i = 0;
            while (true) {
                if (i >= this.mFilteredPositions.size()) {
                    break;
                } else if (this.mFilteredPositions.get(i).intValue() == this.mReqPos) {
                    this.mFilteredIndex = i;
                    break;
                } else {
                    i++;
                }
            }
            Log.m587d(TAG, "Using filtered navigation: " + this.mFilteredPositions.size() + " items, index=" + this.mFilteredIndex);
        }
        if (this.mReqPos != -1) {
            setTitle(String.format(getString(C0130R.string.http_request_number), Integer.valueOf(this.mReqPos + 1)));
            HttpLog httpLog = CaptureService.getHttpLog();
            if (httpLog != null) {
                this.mHttpReq = httpLog.getRequest(this.mReqPos);
            }
        } else {
            setTitle(C0130R.string.http_requests);
        }
        HttpLog.HttpRequest httpRequest = this.mHttpReq;
        if (httpRequest == null) {
            Log.m581w(TAG, "HTTP request with position " + this.mReqPos + " not found");
            finish();
            return;
        }
        this.mHasWebsocket = httpRequest.hasWebsocketData();
        this.mHandler = new Handler(Looper.getMainLooper());
        ViewPager2 viewPager2 = (ViewPager2) findViewById(C0130R.C0132id.pager);
        this.mPager = viewPager2;
        Utils.fixViewPager2Insets(viewPager2);
        setupTabs();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0130R.C0134menu.http_details_menu, menu);
        this.mMenuPrev = menu.findItem(C0130R.C0132id.navigate_before);
        this.mMenuNext = menu.findItem(C0130R.C0132id.navigate_next);
        this.mMenuDisplayAs = menu.findItem(C0130R.C0132id.display_as);
        updateNavigationButtons();
        updateMenuVisibility();
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        super.onDestroy();
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
        } else if (itemId == C0130R.C0132id.display_as) {
            Boolean bool = this.mDisplayMode;
            if (bool != null) {
                this.mDisplayMode = Boolean.valueOf(!bool.booleanValue());
                updateMenuVisibility();
            }
            return true;
        } else if (itemId != C0130R.C0132id.save_as_har) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            openHarFileSelector();
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
        MenuItem menuItem = this.mMenuDisplayAs;
        if (menuItem != null) {
            menuItem.setVisible(true);
            Fragment currentFragment = getCurrentFragment();
            if (currentFragment instanceof HttpPayloadFragment) {
                HttpPayloadFragment httpPayloadFragment = (HttpPayloadFragment) currentFragment;
                if (this.mDisplayMode == null) {
                    this.mDisplayMode = Boolean.TRUE;
                }
                httpPayloadFragment.setDisplayMode(this.mDisplayMode.booleanValue());
                if (this.mDisplayMode.booleanValue()) {
                    this.mMenuDisplayAs.setTitle(C0130R.string.display_as_hexdump);
                } else {
                    this.mMenuDisplayAs.setTitle(C0130R.string.display_as_text);
                }
            } else if (currentFragment instanceof ConnectionPayload) {
                ConnectionPayload connectionPayload = (ConnectionPayload) currentFragment;
                if (this.mDisplayMode == null) {
                    this.mDisplayMode = Boolean.TRUE;
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
