package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentAnim$AnimationOrAnimator;
import androidx.fragment.app.FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserverAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositeOnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayoutMediator$PagerAdapterObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    FragmentEventDispatcher mFragmentEventDispatcher;
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final Lifecycle mLifecycle;
    final LongSparseArray mFragments = new LongSparseArray();
    private final LongSparseArray mSavedStates = new LongSparseArray();
    private final LongSparseArray mItemIdToViewHolder = new LongSparseArray();
    boolean mIsInGracePeriod = false;
    private boolean mHasStaleFragments = false;

    /* loaded from: classes.dex */
    public final class FragmentEventDispatcher {
        public CopyOnWriteArrayList mCallbacks;

        public static void dispatchPostEvents(List list) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                throw ViewModelProvider.Factory.CC.m(it);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class FragmentMaxLifecycleEnforcer {
        public TabLayoutMediator$PagerAdapterObserver mDataObserver;
        public AnonymousClass3 mLifecycleObserver;
        public CompositeOnPageChangeCallback mPageChangeCallback;
        public long mPrimaryItemId = -1;
        public ViewPager2 mViewPager;

        public FragmentMaxLifecycleEnforcer() {
        }

        public static ViewPager2 inferViewPager(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public final void updateFragmentMaxLifecycle(boolean z) {
            int currentItem;
            Fragment fragment;
            boolean z2;
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            if (!fragmentStateAdapter.shouldDelayFragmentTransactions() && this.mViewPager.getScrollState() == 0 && fragmentStateAdapter.mFragments.size() != 0 && fragmentStateAdapter.getItemCount() != 0 && (currentItem = this.mViewPager.getCurrentItem()) < fragmentStateAdapter.getItemCount()) {
                long itemId = fragmentStateAdapter.getItemId(currentItem);
                if ((itemId != this.mPrimaryItemId || z) && (fragment = (Fragment) fragmentStateAdapter.mFragments.get(itemId)) != null && fragment.isAdded()) {
                    this.mPrimaryItemId = itemId;
                    FragmentManager fragmentManager = fragmentStateAdapter.mFragmentManager;
                    fragmentManager.getClass();
                    BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    Fragment fragment2 = null;
                    for (int i2 = 0; i2 < fragmentStateAdapter.mFragments.size(); i2++) {
                        long keyAt = fragmentStateAdapter.mFragments.keyAt(i2);
                        Fragment fragment3 = (Fragment) fragmentStateAdapter.mFragments.valueAt(i2);
                        if (fragment3.isAdded()) {
                            if (keyAt != this.mPrimaryItemId) {
                                backStackRecord.setMaxLifecycle(fragment3, Lifecycle.State.STARTED);
                                FragmentEventDispatcher fragmentEventDispatcher = fragmentStateAdapter.mFragmentEventDispatcher;
                                fragmentEventDispatcher.getClass();
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it = fragmentEventDispatcher.mCallbacks.iterator();
                                if (!it.hasNext()) {
                                    arrayList.add(arrayList2);
                                } else {
                                    throw ViewModelProvider.Factory.CC.m(it);
                                }
                            } else {
                                fragment2 = fragment3;
                            }
                            if (keyAt == this.mPrimaryItemId) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            fragment3.setMenuVisibility(z2);
                        }
                    }
                    if (fragment2 != null) {
                        backStackRecord.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                        FragmentEventDispatcher fragmentEventDispatcher2 = fragmentStateAdapter.mFragmentEventDispatcher;
                        fragmentEventDispatcher2.getClass();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it2 = fragmentEventDispatcher2.mCallbacks.iterator();
                        if (!it2.hasNext()) {
                            arrayList.add(arrayList3);
                        } else {
                            throw ViewModelProvider.Factory.CC.m(it2);
                        }
                    }
                    if (backStackRecord.mOps.isEmpty()) {
                        return;
                    }
                    if (!backStackRecord.mAddToBackStack) {
                        backStackRecord.mAllowAddToBackStack = false;
                        backStackRecord.mManager.execSingleAction(backStackRecord, false);
                        Collections.reverse(arrayList);
                        int size = arrayList.size();
                        while (i < size) {
                            Object obj = arrayList.get(i);
                            i++;
                            fragmentStateAdapter.mFragmentEventDispatcher.getClass();
                            FragmentEventDispatcher.dispatchPostEvents((List) obj);
                        }
                        return;
                    }
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class FragmentTransactionCallback {
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.viewpager2.adapter.FragmentStateAdapter$FragmentEventDispatcher, java.lang.Object] */
    public FragmentStateAdapter(FragmentActivity fragmentActivity) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Lifecycle lifecycle = fragmentActivity.getLifecycle();
        ?? obj = new Object();
        obj.mCallbacks = new CopyOnWriteArrayList();
        this.mFragmentEventDispatcher = obj;
        this.mFragmentManager = supportFragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }

    public void addViewToContainer(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean containsItem(long j) {
        if (j < 0 || j >= getItemCount()) {
            return false;
        }
        return true;
    }

    public abstract Fragment createFragment(int i);

    public void gcFragments() {
        Fragment fragment;
        View view;
        if (this.mHasStaleFragments && !shouldDelayFragmentTransactions()) {
            ArraySet arraySet = new ArraySet(0);
            for (int i = 0; i < this.mFragments.size(); i++) {
                long keyAt = this.mFragments.keyAt(i);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.mItemIdToViewHolder.remove(keyAt);
                }
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (int i2 = 0; i2 < this.mFragments.size(); i2++) {
                    long keyAt2 = this.mFragments.keyAt(i2);
                    if (this.mItemIdToViewHolder.indexOfKey(keyAt2) < 0 && ((fragment = (Fragment) this.mFragments.get(keyAt2)) == null || (view = fragment.getView()) == null || view.getParent() == null)) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
            while (keyIterator.hasNext()) {
                removeFragment(((Long) keyIterator.next()).longValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public final Long itemForViewHolder(int i) {
        Long l = null;
        for (int i2 = 0; i2 < this.mItemIdToViewHolder.size(); i2++) {
            if (((Integer) this.mItemIdToViewHolder.valueAt(i2)).intValue() == i) {
                if (l == null) {
                    l = Long.valueOf(this.mItemIdToViewHolder.keyAt(i2));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.lifecycle.LifecycleObserver, androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.mFragmentMaxLifecycleEnforcer == null) {
            final FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
            this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
            ViewPager2 inferViewPager = FragmentMaxLifecycleEnforcer.inferViewPager(recyclerView);
            fragmentMaxLifecycleEnforcer.mViewPager = inferViewPager;
            CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(fragmentMaxLifecycleEnforcer);
            fragmentMaxLifecycleEnforcer.mPageChangeCallback = compositeOnPageChangeCallback;
            ((ArrayList) inferViewPager.mExternalPageChangeCallbacks.mCallbacks).add(compositeOnPageChangeCallback);
            TabLayoutMediator$PagerAdapterObserver tabLayoutMediator$PagerAdapterObserver = new TabLayoutMediator$PagerAdapterObserver(1, fragmentMaxLifecycleEnforcer);
            fragmentMaxLifecycleEnforcer.mDataObserver = tabLayoutMediator$PagerAdapterObserver;
            registerAdapterDataObserver(tabLayoutMediator$PagerAdapterObserver);
            ?? r3 = new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            fragmentMaxLifecycleEnforcer.mLifecycleObserver = r3;
            this.mLifecycle.addObserver(r3);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = this.mFragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.getClass();
        ViewPager2 inferViewPager = FragmentMaxLifecycleEnforcer.inferViewPager(recyclerView);
        ((ArrayList) inferViewPager.mExternalPageChangeCallbacks.mCallbacks).remove(fragmentMaxLifecycleEnforcer.mPageChangeCallback);
        FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
        fragmentStateAdapter.unregisterAdapterDataObserver(fragmentMaxLifecycleEnforcer.mDataObserver);
        fragmentStateAdapter.mLifecycle.removeObserver(fragmentMaxLifecycleEnforcer.mLifecycleObserver);
        fragmentMaxLifecycleEnforcer.mViewPager = null;
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(((FrameLayout) fragmentViewHolder.itemView).getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
    }

    public void placeFragmentInViewHolder(FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = (Fragment) this.mFragments.get(fragmentViewHolder.getItemId());
        if (fragment != null) {
            FrameLayout frameLayout = (FrameLayout) fragmentViewHolder.itemView;
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (fragment.isAdded() && view == null) {
                FragmentManager fragmentManager = this.mFragmentManager;
                MatcherMatchResult matcherMatchResult = new MatcherMatchResult(this, fragment, frameLayout);
                FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator = fragmentManager.mLifecycleCallbacksDispatcher;
                fragmentAnim$AnimationOrAnimator.getClass();
                ((CopyOnWriteArrayList) fragmentAnim$AnimationOrAnimator.animator).add(new FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder(matcherMatchResult));
            } else if (!fragment.isAdded() || view.getParent() == null) {
                if (fragment.isAdded()) {
                    addViewToContainer(view, frameLayout);
                } else if (!shouldDelayFragmentTransactions()) {
                    FragmentManager fragmentManager2 = this.mFragmentManager;
                    MatcherMatchResult matcherMatchResult2 = new MatcherMatchResult(this, fragment, frameLayout);
                    FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator2 = fragmentManager2.mLifecycleCallbacksDispatcher;
                    fragmentAnim$AnimationOrAnimator2.getClass();
                    ((CopyOnWriteArrayList) fragmentAnim$AnimationOrAnimator2.animator).add(new FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder(matcherMatchResult2));
                    FragmentEventDispatcher fragmentEventDispatcher = this.mFragmentEventDispatcher;
                    fragmentEventDispatcher.getClass();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = fragmentEventDispatcher.mCallbacks.iterator();
                    if (!it.hasNext()) {
                        try {
                            fragment.setMenuVisibility(false);
                            FragmentManager fragmentManager3 = this.mFragmentManager;
                            fragmentManager3.getClass();
                            BackStackRecord backStackRecord = new BackStackRecord(fragmentManager3);
                            backStackRecord.doAddOp(0, fragment, "f" + fragmentViewHolder.getItemId(), 1);
                            backStackRecord.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
                            if (!backStackRecord.mAddToBackStack) {
                                backStackRecord.mAllowAddToBackStack = false;
                                backStackRecord.mManager.execSingleAction(backStackRecord, false);
                                this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
                                return;
                            }
                            throw new IllegalStateException("This transaction is already being added to the back stack");
                        } finally {
                            this.mFragmentEventDispatcher.getClass();
                            FragmentEventDispatcher.dispatchPostEvents(arrayList);
                        }
                    } else {
                        throw ViewModelProvider.Factory.CC.m(it);
                    }
                } else if (!this.mFragmentManager.mDestroyed) {
                    this.mLifecycle.addObserver(new DefaultLifecycleObserverAdapter(this, fragmentViewHolder));
                }
            } else if (view.getParent() != frameLayout) {
                addViewToContainer(view, frameLayout);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public void registerFragmentTransactionCallback(FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.mCallbacks.add(fragmentTransactionCallback);
    }

    public final void removeFragment(long j) {
        ViewParent parent;
        Fragment fragment = (Fragment) this.mFragments.get(j);
        if (fragment != null) {
            if (!(fragment.getView() == null || (parent = fragment.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!containsItem(j)) {
                this.mSavedStates.remove(j);
            }
            if (!fragment.isAdded()) {
                this.mFragments.remove(j);
            } else if (shouldDelayFragmentTransactions()) {
                this.mHasStaleFragments = true;
            } else {
                if (fragment.isAdded() && containsItem(j)) {
                    FragmentEventDispatcher fragmentEventDispatcher = this.mFragmentEventDispatcher;
                    fragmentEventDispatcher.getClass();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = fragmentEventDispatcher.mCallbacks.iterator();
                    if (!it.hasNext()) {
                        Fragment.SavedState saveFragmentInstanceState = this.mFragmentManager.saveFragmentInstanceState(fragment);
                        this.mFragmentEventDispatcher.getClass();
                        FragmentEventDispatcher.dispatchPostEvents(arrayList);
                        this.mSavedStates.put(j, saveFragmentInstanceState);
                    } else {
                        throw ViewModelProvider.Factory.CC.m(it);
                    }
                }
                FragmentEventDispatcher fragmentEventDispatcher2 = this.mFragmentEventDispatcher;
                fragmentEventDispatcher2.getClass();
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = fragmentEventDispatcher2.mCallbacks.iterator();
                if (!it2.hasNext()) {
                    try {
                        FragmentManager fragmentManager = this.mFragmentManager;
                        fragmentManager.getClass();
                        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
                        backStackRecord.remove(fragment);
                        if (!backStackRecord.mAddToBackStack) {
                            backStackRecord.mAllowAddToBackStack = false;
                            backStackRecord.mManager.execSingleAction(backStackRecord, false);
                            this.mFragments.remove(j);
                            return;
                        }
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    } finally {
                        this.mFragmentEventDispatcher.getClass();
                        FragmentEventDispatcher.dispatchPostEvents(arrayList2);
                    }
                } else {
                    throw ViewModelProvider.Factory.CC.m(it2);
                }
            }
        }
    }

    public final void restoreState(Parcelable parcelable) {
        if (this.mSavedStates.size() == 0 && this.mFragments.size() == 0) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.getClassLoader() == null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith(KEY_PREFIX_FRAGMENT) && str.length() > 2) {
                    this.mFragments.put(Long.parseLong(str.substring(2)), this.mFragmentManager.getFragment(bundle, str));
                } else if (!str.startsWith(KEY_PREFIX_STATE) || str.length() <= 2) {
                    throw new IllegalArgumentException("Unexpected key in savedState: ".concat(str));
                } else {
                    long parseLong = Long.parseLong(str.substring(2));
                    Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                    if (containsItem(parseLong)) {
                        this.mSavedStates.put(parseLong, savedState);
                    }
                }
            }
            if (this.mFragments.size() != 0) {
                this.mHasStaleFragments = true;
                this.mIsInGracePeriod = true;
                gcFragments();
                Handler handler = new Handler(Looper.getMainLooper());
                Runnable runnable = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                        fragmentStateAdapter.mIsInGracePeriod = false;
                        fragmentStateAdapter.gcFragments();
                    }
                };
                this.mLifecycle.addObserver(new DefaultLifecycleObserverAdapter(handler, 4, runnable));
                handler.postDelayed(runnable, GRACE_WINDOW_TIME_MS);
                return;
            }
            return;
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mSavedStates.size() + this.mFragments.size());
        for (int i = 0; i < this.mFragments.size(); i++) {
            long keyAt = this.mFragments.keyAt(i);
            Fragment fragment = (Fragment) this.mFragments.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.putFragment(bundle, KEY_PREFIX_FRAGMENT + keyAt, fragment);
            }
        }
        for (int i2 = 0; i2 < this.mSavedStates.size(); i2++) {
            long keyAt2 = this.mSavedStates.keyAt(i2);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(KEY_PREFIX_STATE + keyAt2, (Parcelable) this.mSavedStates.get(keyAt2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public void unregisterFragmentTransactionCallback(FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.mCallbacks.remove(fragmentTransactionCallback);
    }

    public final void onBindViewHolder(FragmentViewHolder fragmentViewHolder, int i) {
        long itemId = fragmentViewHolder.getItemId();
        int id = ((FrameLayout) fragmentViewHolder.itemView).getId();
        Long itemForViewHolder = itemForViewHolder(id);
        if (!(itemForViewHolder == null || itemForViewHolder.longValue() == itemId)) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.put(itemId, Integer.valueOf(id));
        long itemId2 = getItemId(i);
        if (this.mFragments.indexOfKey(itemId2) < 0) {
            Fragment createFragment = createFragment(i);
            createFragment.setInitialSavedState((Fragment.SavedState) this.mSavedStates.get(itemId2));
            this.mFragments.put(itemId2, createFragment);
        }
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (((FrameLayout) fragmentViewHolder.itemView).isAttachedToWindow()) {
            placeFragmentInViewHolder(fragmentViewHolder);
        }
        gcFragments();
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.viewpager2.adapter.FragmentViewHolder] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2 = FragmentViewHolder.$r8$clinit;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new RecyclerView.ViewHolder(frameLayout);
    }

    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }
}
