package androidx.preference;

import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.R;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class PreferenceFragmentCompat extends Fragment {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private boolean mHavePrefs;
    private boolean mInitDone;
    RecyclerView mList;
    private PreferenceManager mPreferenceManager;
    private Runnable mSelectPreferenceRunnable;
    private final DividerDecoration mDividerDecoration = new DividerDecoration();
    private int mLayoutResId = R.layout.preference_list_fragment;
    private final Handler mHandler = new AnonymousClass1(this, Looper.getMainLooper());
    private final Runnable mRequestFocus = new PreferenceGroup.AnonymousClass1(1, this);

    /* renamed from: androidx.preference.PreferenceFragmentCompat$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends Handler {
        public final /* synthetic */ int $r8$classId = 1;
        public Object this$0;

        public /* synthetic */ AnonymousClass1() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (this.$r8$classId) {
                case 0:
                    if (message.what == 1) {
                        ((PreferenceFragmentCompat) this.this$0).bindPreferences();
                        return;
                    }
                    return;
                default:
                    int i = message.what;
                    if (i == -3 || i == -2 || i == -1) {
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.this$0).get(), message.what);
                        return;
                    } else if (i == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        return;
                    } else {
                        return;
                    }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PreferenceFragmentCompat preferenceFragmentCompat, Looper looper) {
            super(looper);
            this.this$0 = preferenceFragmentCompat;
        }
    }

    /* renamed from: androidx.preference.PreferenceFragmentCompat$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass3 implements Runnable {
        public final /* synthetic */ String val$key;
        public final /* synthetic */ Preference val$preference;

        public AnonymousClass3(Preference preference, String str) {
            this.val$preference = preference;
            this.val$key = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            PreferenceFragmentCompat preferenceFragmentCompat = PreferenceFragmentCompat.this;
            RecyclerView.Adapter adapter = preferenceFragmentCompat.mList.getAdapter();
            if (adapter instanceof PreferenceGroupAdapter) {
                String str = this.val$key;
                Preference preference = this.val$preference;
                if (preference != null) {
                    i = ((PreferenceGroupAdapter) adapter).getPreferenceAdapterPosition(preference);
                } else {
                    i = ((PreferenceGroupAdapter) adapter).getPreferenceAdapterPosition(str);
                }
                if (i != -1) {
                    preferenceFragmentCompat.mList.scrollToPosition(i);
                    return;
                }
                adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver((PreferenceGroupAdapter) adapter, preferenceFragmentCompat.mList, preference, str));
            } else if (adapter != null) {
                throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
            }
        }
    }

    /* loaded from: classes.dex */
    public final class DividerDecoration extends RecyclerView.ItemDecoration {
        public boolean mAllowDividerAfterLastItem = true;
        public Drawable mDivider;
        public int mDividerHeight;

        public DividerDecoration() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView) {
            if (shouldDrawDividerBelow(recyclerView, view)) {
                rect.bottom = this.mDividerHeight;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
            if (this.mDivider != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (shouldDrawDividerBelow(recyclerView, childAt)) {
                        int height = childAt.getHeight() + ((int) childAt.getY());
                        this.mDivider.setBounds(0, height, width, this.mDividerHeight + height);
                        this.mDivider.draw(canvas);
                    }
                }
            }
        }

        public final boolean shouldDrawDividerBelow(RecyclerView recyclerView, View view) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            if (!(childViewHolder instanceof PreferenceViewHolder) || !((PreferenceViewHolder) childViewHolder).mDividerAllowedBelow) {
                return false;
            }
            boolean z = this.mAllowDividerAfterLastItem;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild >= recyclerView.getChildCount() - 1) {
                return z;
            }
            RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
            if (!(childViewHolder2 instanceof PreferenceViewHolder) || !((PreferenceViewHolder) childViewHolder2).mDividerAllowedAbove) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference);
    }

    /* loaded from: classes.dex */
    public final class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {
        public final PreferenceGroupAdapter mAdapter;
        public final String mKey;
        public final RecyclerView mList;
        public final Preference mPreference;

        public ScrollToPreferenceObserver(PreferenceGroupAdapter preferenceGroupAdapter, RecyclerView recyclerView, Preference preference, String str) {
            this.mAdapter = preferenceGroupAdapter;
            this.mList = recyclerView;
            this.mPreference = preference;
            this.mKey = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            scrollToPreference();
        }

        public final void scrollToPreference() {
            int i;
            PreferenceGroupAdapter preferenceGroupAdapter = this.mAdapter;
            preferenceGroupAdapter.unregisterAdapterDataObserver(this);
            Preference preference = this.mPreference;
            if (preference != null) {
                i = preferenceGroupAdapter.getPreferenceAdapterPosition(preference);
            } else {
                i = preferenceGroupAdapter.getPreferenceAdapterPosition(this.mKey);
            }
            if (i != -1) {
                this.mList.scrollToPosition(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            scrollToPreference();
        }
    }

    public void addPreferencesFromResource(int i) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager != null) {
            setPreferenceScreen(preferenceManager.inflateFromResource(requireContext(), i, getPreferenceScreen()));
            return;
        }
        throw new RuntimeException("This should be called after super.onCreate.");
    }

    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.onAttached();
        }
        onBindPreferences();
    }

    public <T extends Preference> T findPreference(CharSequence charSequence) {
        PreferenceScreen preferenceScreen;
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager == null || (preferenceScreen = preferenceManager.mPreferenceScreen) == null) {
            return null;
        }
        return (T) preferenceScreen.findPreference(charSequence);
    }

    public Fragment getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.mPreferenceScreen;
    }

    public void onBindPreferences() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = R.style.PreferenceThemeOverlay;
        }
        requireContext().getTheme().applyStyle(i, false);
        PreferenceManager preferenceManager = new PreferenceManager(requireContext());
        this.mPreferenceManager = preferenceManager;
        preferenceManager.mOnNavigateToScreenListener = this;
        if (getArguments() != null) {
            str = getArguments().getString(ARG_PREFERENCE_ROOT);
        } else {
            str = null;
        }
        onCreatePreferences(bundle, str);
    }

    public RecyclerView.Adapter onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    public RecyclerView.LayoutManager onCreateLayoutManager() {
        requireContext();
        return new LinearLayoutManager(1);
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = requireContext().obtainStyledAttributes(null, R$styleable.PreferenceFragmentCompat, R.attr.preferenceFragmentCompatStyle, 0);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(0, this.mLayoutResId);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        boolean z = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(requireContext());
        View inflate = cloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView onCreateRecyclerView = onCreateRecyclerView(cloneInContext, viewGroup2, bundle);
            if (onCreateRecyclerView != null) {
                this.mList = onCreateRecyclerView;
                onCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
                setDivider(drawable);
                if (dimensionPixelSize != -1) {
                    setDividerHeight(dimensionPixelSize);
                }
                this.mDividerDecoration.mAllowDividerAfterLastItem = z;
                if (this.mList.getParent() == null) {
                    viewGroup2.addView(this.mList);
                }
                this.mHandler.post(this.mRequestFocus);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            getListView().setAdapter(null);
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceScreen != null) {
                preferenceScreen.onDetached();
            }
            onUnbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    public void onDisplayPreferenceDialog(Preference preference) {
        DialogFragment dialogFragment;
        getCallbackFragment();
        for (Fragment fragment = this; fragment != null; fragment = fragment.getParentFragment()) {
        }
        getContext();
        getActivity();
        if (getParentFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                String str = preference.mKey;
                dialogFragment = new EditTextPreferenceDialogFragmentCompat();
                Bundle bundle = new Bundle(1);
                bundle.putString("key", str);
                dialogFragment.setArguments(bundle);
            } else if (preference instanceof ListPreference) {
                String str2 = preference.mKey;
                dialogFragment = new ListPreferenceDialogFragmentCompat();
                Bundle bundle2 = new Bundle(1);
                bundle2.putString("key", str2);
                dialogFragment.setArguments(bundle2);
            } else if (preference instanceof MultiSelectListPreference) {
                String str3 = preference.mKey;
                dialogFragment = new MultiSelectListPreferenceDialogFragmentCompat();
                Bundle bundle3 = new Bundle(1);
                bundle3.putString("key", str3);
                dialogFragment.setArguments(bundle3);
            } else {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(getParentFragmentManager(), DIALOG_FRAGMENT_TAG);
        }
    }

    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        getCallbackFragment();
        for (Fragment fragment = this; fragment != null; fragment = fragment.getParentFragment()) {
        }
        getContext();
        getActivity();
    }

    public boolean onPreferenceTreeClick(Preference preference) {
        boolean z;
        if (preference.mFragment == null) {
            return false;
        }
        if (getCallbackFragment() instanceof OnPreferenceStartFragmentCallback) {
            z = ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, preference);
        } else {
            z = false;
        }
        for (Fragment fragment = this; !z && fragment != null; fragment = fragment.getParentFragment()) {
            if (fragment instanceof OnPreferenceStartFragmentCallback) {
                z = ((OnPreferenceStartFragmentCallback) fragment).onPreferenceStartFragment(this, preference);
            }
        }
        if (!z && (getContext() instanceof OnPreferenceStartFragmentCallback)) {
            z = ((OnPreferenceStartFragmentCallback) getContext()).onPreferenceStartFragment(this, preference);
        }
        if (!z && (getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            z = ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
        }
        if (z) {
            return true;
        }
        Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        if (preference.mExtras == null) {
            preference.mExtras = new Bundle();
        }
        Bundle bundle = preference.mExtras;
        FragmentManager.AnonymousClass3 fragmentFactory = parentFragmentManager.getFragmentFactory();
        requireActivity().getClassLoader();
        Fragment instantiate = fragmentFactory.instantiate(preference.mFragment);
        instantiate.setArguments(bundle);
        instantiate.setTargetFragment(this, 0);
        BackStackRecord backStackRecord = new BackStackRecord(parentFragmentManager);
        backStackRecord.replace(((View) requireView().getParent()).getId(), instantiate, null);
        backStackRecord.addToBackStack(null);
        backStackRecord.commit();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.dispatchSaveInstanceState(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        PreferenceManager preferenceManager = this.mPreferenceManager;
        preferenceManager.mOnPreferenceTreeClickListener = this;
        preferenceManager.mOnDisplayPreferenceDialogListener = this;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        PreferenceManager preferenceManager = this.mPreferenceManager;
        preferenceManager.mOnPreferenceTreeClickListener = null;
        preferenceManager.mOnDisplayPreferenceDialogListener = null;
    }

    public void onUnbindPreferences() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle(PREFERENCES_TAG)) == null || (preferenceScreen = getPreferenceScreen()) == null)) {
            preferenceScreen.dispatchRestoreInstanceState(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(Preference preference) {
        AnonymousClass3 r0 = new AnonymousClass3(preference, null);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = r0;
        } else {
            r0.run();
        }
    }

    public void setDivider(Drawable drawable) {
        DividerDecoration dividerDecoration = this.mDividerDecoration;
        if (drawable != null) {
            dividerDecoration.getClass();
            dividerDecoration.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            dividerDecoration.mDividerHeight = 0;
        }
        dividerDecoration.mDivider = drawable;
        PreferenceFragmentCompat.this.mList.invalidateItemDecorations();
    }

    public void setDividerHeight(int i) {
        DividerDecoration dividerDecoration = this.mDividerDecoration;
        dividerDecoration.mDividerHeight = i;
        PreferenceFragmentCompat.this.mList.invalidateItemDecorations();
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        PreferenceScreen preferenceScreen2 = preferenceManager.mPreferenceScreen;
        if (preferenceScreen != preferenceScreen2) {
            if (preferenceScreen2 != null) {
                preferenceScreen2.onDetached();
            }
            preferenceManager.mPreferenceScreen = preferenceScreen;
            if (preferenceScreen != null) {
                onUnbindPreferences();
                this.mHavePrefs = true;
                if (this.mInitDone && !this.mHandler.hasMessages(1)) {
                    this.mHandler.obtainMessage(1).sendToTarget();
                }
            }
        }
    }

    public void setPreferencesFromResource(int i, String str) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager != null) {
            PreferenceScreen inflateFromResource = preferenceManager.inflateFromResource(requireContext(), i, null);
            PreferenceScreen preferenceScreen = inflateFromResource;
            if (str != null) {
                Preference findPreference = inflateFromResource.findPreference(str);
                boolean z = findPreference instanceof PreferenceScreen;
                preferenceScreen = findPreference;
                if (!z) {
                    throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m("Preference object with key ", str, " is not a PreferenceScreen"));
                }
            }
            setPreferenceScreen((PreferenceScreen) preferenceScreen);
            return;
        }
        throw new RuntimeException("This should be called after super.onCreate.");
    }

    public void scrollToPreference(String str) {
        AnonymousClass3 r0 = new AnonymousClass3(null, str);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = r0;
        } else {
            r0.run();
        }
    }
}
