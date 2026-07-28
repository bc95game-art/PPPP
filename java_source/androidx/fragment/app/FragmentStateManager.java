package androidx.fragment.app;

import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.emanuelef.remote_capture.C0130R;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class FragmentStateManager {
    public final FragmentAnim$AnimationOrAnimator mDispatcher;
    public final Fragment mFragment;
    public final FragmentStore mFragmentStore;
    public boolean mMovingToState = false;
    public int mFragmentManagerState = -1;

    public FragmentStateManager(FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator, FragmentStore fragmentStore, Fragment fragment) {
        this.mDispatcher = fragmentAnim$AnimationOrAnimator;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    public final void activityCreated() {
        Bundle bundle;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
        }
        Bundle bundle2 = fragment.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        fragment.performActivityCreated(bundle);
        this.mDispatcher.dispatchOnFragmentActivityCreated(fragment, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0099, code lost:
        if (r4 >= r1.size()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
        r5 = (androidx.fragment.app.Fragment) r1.get(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a3, code lost:
        if (r5.mContainer != r2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a5, code lost:
        r5 = r5.mView;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a7, code lost:
        if (r5 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
        r3 = r2.indexOfChild(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void addViewToContainer() {
        Fragment fragment;
        View view;
        Fragment fragment2;
        Fragment fragment3 = this.mFragment;
        View view2 = fragment3.mContainer;
        while (true) {
            fragment = null;
            if (view2 == null) {
                break;
            }
            Object tag = view2.getTag(C0130R.C0132id.fragment_container_view_tag);
            if (tag instanceof Fragment) {
                fragment2 = (Fragment) tag;
            } else {
                fragment2 = null;
            }
            if (fragment2 != null) {
                fragment = fragment2;
                break;
            }
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
        }
        Fragment parentFragment = fragment3.getParentFragment();
        if (fragment != null && !fragment.equals(parentFragment)) {
            int i = fragment3.mContainerId;
            FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
            FragmentStrictMode.logIfDebuggingEnabled(new Violation(fragment3, "Attempting to nest fragment " + fragment3 + " within the view of parent fragment " + fragment + " via container with ID " + i + " without using parent's childFragmentManager"));
            FragmentStrictMode.getNearestPolicy(fragment3).getClass();
        }
        ArrayList arrayList = this.mFragmentStore.mAdded;
        ViewGroup viewGroup = fragment3.mContainer;
        int i2 = -1;
        if (viewGroup != null) {
            int indexOf = arrayList.indexOf(fragment3);
            int i3 = indexOf - 1;
            while (true) {
                if (i3 >= 0) {
                    Fragment fragment4 = (Fragment) arrayList.get(i3);
                    if (fragment4.mContainer == viewGroup && (view = fragment4.mView) != null) {
                        i2 = viewGroup.indexOfChild(view) + 1;
                        break;
                    }
                    i3--;
                }
            }
        }
        fragment3.mContainer.addView(fragment3.mView, i2);
    }

    public final void attach() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        FragmentStore fragmentStore = this.mFragmentStore;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManager2 = (FragmentStateManager) fragmentStore.mActive.get(fragment2.mWho);
            if (fragmentStateManager2 != null) {
                fragment.mTargetWho = fragment.mTarget.mWho;
                fragment.mTarget = null;
                fragmentStateManager = fragmentStateManager2;
            } else {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = (FragmentStateManager) fragmentStore.mActive.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m593m(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.moveToExpectedState();
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        fragment.mHost = fragmentManager.mHost;
        fragment.mParentFragment = fragmentManager.mParent;
        FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator = this.mDispatcher;
        fragmentAnim$AnimationOrAnimator.dispatchOnFragmentPreAttached(fragment, false);
        fragment.performAttach();
        fragmentAnim$AnimationOrAnimator.dispatchOnFragmentAttached(fragment, false);
    }

    public final int computeExpectedState() {
        int i;
        int i2;
        Fragment fragment = this.mFragment;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i3 = this.mFragmentManagerState;
        int ordinal = fragment.mMaxState.ordinal();
        int i4 = 0;
        if (ordinal == 1) {
            i3 = Math.min(i3, 0);
        } else if (ordinal == 2) {
            i3 = Math.min(i3, 1);
        } else if (ordinal == 3) {
            i3 = Math.min(i3, 5);
        } else if (ordinal != 4) {
            i3 = Math.min(i3, -1);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                i3 = Math.max(this.mFragmentManagerState, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    i3 = Math.min(i3, 2);
                }
            } else {
                i3 = this.mFragmentManagerState < 4 ? Math.min(i3, fragment.mState) : Math.min(i3, 1);
            }
        }
        if (fragment.mInDynamicContainer && fragment.mContainer == null) {
            i3 = Math.min(i3, 4);
        }
        if (!fragment.mAdded) {
            i3 = Math.min(i3, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
            SpecialEffectsController$FragmentStateManagerOperation findPendingOperation = orCreateController.findPendingOperation(fragment);
            if (findPendingOperation != null) {
                i = findPendingOperation.lifecycleImpact;
            } else {
                i = 0;
            }
            SpecialEffectsController$FragmentStateManagerOperation findRunningOperation = orCreateController.findRunningOperation(fragment);
            if (findRunningOperation != null) {
                i4 = findRunningOperation.lifecycleImpact;
            }
            if (i == 0) {
                i2 = -1;
            } else {
                i2 = SpecialEffectsController$WhenMappings.$EnumSwitchMapping$0[SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i)];
            }
            if (!(i2 == -1 || i2 == 1)) {
                i4 = i;
            }
        }
        if (i4 == 2) {
            i3 = Math.min(i3, 6);
        } else if (i4 == 3) {
            i3 = Math.max(i3, 3);
        } else if (fragment.mRemoving) {
            if (fragment.isInBackStack()) {
                i3 = Math.min(i3, 1);
            } else {
                i3 = Math.min(i3, -1);
            }
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            i3 = Math.min(i3, 4);
        }
        if (fragment.mTransitioning) {
            i3 = Math.max(i3, 3);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i3 + " for " + fragment);
        }
        return i3;
    }

    public final void create() {
        Bundle bundle;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        Bundle bundle2 = fragment.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        } else {
            bundle = null;
        }
        if (!fragment.mIsCreated) {
            FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator = this.mDispatcher;
            fragmentAnim$AnimationOrAnimator.dispatchOnFragmentPreCreated(fragment, false);
            fragment.performCreate(bundle);
            fragmentAnim$AnimationOrAnimator.dispatchOnFragmentCreated(fragment, false);
            return;
        }
        fragment.mState = 1;
        fragment.restoreChildFragmentState();
    }

    public final void createView() {
        Bundle bundle;
        String str;
        Fragment fragment = this.mFragment;
        if (!fragment.mFromLayout) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            Bundle bundle2 = fragment.mSavedFragmentState;
            ViewGroup viewGroup = null;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("savedInstanceState");
            } else {
                bundle = null;
            }
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(bundle);
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i = fragment.mContainerId;
                if (i != 0) {
                    if (i != -1) {
                        viewGroup = (ViewGroup) fragment.mFragmentManager.mContainer.onFindViewById(i);
                        if (viewGroup == null) {
                            if (!fragment.mRestored && !fragment.mInDynamicContainer) {
                                try {
                                    str = fragment.getResources().getResourceName(fragment.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + str + ") for fragment " + fragment);
                            }
                        } else if (!(viewGroup instanceof FragmentContainerView)) {
                            FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
                            FragmentStrictMode.logIfDebuggingEnabled(new Violation(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView"));
                            FragmentStrictMode.getNearestPolicy(fragment).getClass();
                        }
                    } else {
                        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m597m("Cannot create fragment ", fragment, " for a container view with no id"));
                    }
                }
            }
            fragment.mContainer = viewGroup;
            fragment.performCreateView(performGetLayoutInflater, viewGroup, bundle);
            if (fragment.mView != null) {
                if (FragmentManager.isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "moveto VIEW_CREATED: " + fragment);
                }
                fragment.mView.setSaveFromParentEnabled(false);
                fragment.mView.setTag(C0130R.C0132id.fragment_container_view_tag, fragment);
                if (viewGroup != null) {
                    addViewToContainer();
                }
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                if (fragment.mView.isAttachedToWindow()) {
                    View view = fragment.mView;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api20Impl.requestApplyInsets(view);
                } else {
                    final View view2 = fragment.mView;
                    view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentStateManager.1
                        @Override // android.view.View.OnAttachStateChangeListener
                        public final void onViewAttachedToWindow(View view3) {
                            View view4 = view2;
                            view4.removeOnAttachStateChangeListener(this);
                            WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                            ViewCompat.Api20Impl.requestApplyInsets(view4);
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public final void onViewDetachedFromWindow(View view3) {
                        }
                    });
                }
                fragment.performViewCreated();
                this.mDispatcher.dispatchOnFragmentViewCreated(fragment, fragment.mView, false);
                int visibility = fragment.mView.getVisibility();
                fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
                if (fragment.mContainer != null && visibility == 0) {
                    View findFocus = fragment.mView.findFocus();
                    if (findFocus != null) {
                        fragment.setFocusedView(findFocus);
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                        }
                    }
                    fragment.mView.setAlpha(0.0f);
                }
            }
            fragment.mState = 2;
        }
    }

    public final void destroy() {
        boolean z;
        boolean z2;
        Fragment findActiveFragment;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "movefrom CREATED: " + fragment);
        }
        boolean z3 = true;
        int i = 0;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            z = false;
        } else {
            z = true;
        }
        FragmentStore fragmentStore = this.mFragmentStore;
        if (z && !fragment.mBeingSaved) {
            fragmentStore.setSavedState(null, fragment.mWho);
        }
        if (!z) {
            FragmentManagerViewModel fragmentManagerViewModel = fragmentStore.mNonConfig;
            if (fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) {
                z2 = fragmentManagerViewModel.mHasBeenCleared;
            } else {
                z2 = true;
            }
            if (!z2) {
                String str = fragment.mTargetWho;
                if (!(str == null || (findActiveFragment = fragmentStore.findActiveFragment(str)) == null || !findActiveFragment.mRetainInstance)) {
                    fragment.mTarget = findActiveFragment;
                }
                fragment.mState = 0;
                return;
            }
        }
        FragmentHostCallback fragmentHostCallback = fragment.mHost;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            z3 = fragmentStore.mNonConfig.mHasBeenCleared;
        } else {
            AppCompatActivity appCompatActivity = fragmentHostCallback.context;
            if (ViewModelProvider.Factory.CC.m599m((Object) appCompatActivity)) {
                z3 = true ^ appCompatActivity.isChangingConfigurations();
            }
        }
        if ((z && !fragment.mBeingSaved) || z3) {
            fragmentStore.mNonConfig.clearNonConfigState(fragment, false);
        }
        fragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(fragment, false);
        ArrayList activeFragmentStateManagers = fragmentStore.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (fragment.mWho.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str2 = fragment.mTargetWho;
        if (str2 != null) {
            fragment.mTarget = fragmentStore.findActiveFragment(str2);
        }
        fragmentStore.makeInactive(this);
    }

    public final void destroyFragmentView() {
        View view;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public final void detach() {
        boolean z;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.performDetach();
        this.mDispatcher.dispatchOnFragmentDetached(fragment, false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            FragmentManagerViewModel fragmentManagerViewModel = this.mFragmentStore.mNonConfig;
            if (fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) {
                z = fragmentManagerViewModel.mHasBeenCleared;
            } else {
                z = true;
            }
            if (!z) {
                return;
            }
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void ensureInflatedView() {
        Bundle bundle;
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            Bundle bundle2 = fragment.mSavedFragmentState;
            if (bundle2 != null) {
                bundle = bundle2.getBundle("savedInstanceState");
            } else {
                bundle = null;
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(bundle), null, bundle);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(C0130R.C0132id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.mDispatcher.dispatchOnFragmentViewCreated(fragment, fragment.mView, false);
                fragment.mState = 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x01ae, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void moveToExpectedState() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.mMovingToState;
        Fragment fragment = this.mFragment;
        if (!z) {
            try {
                this.mMovingToState = true;
                boolean z2 = false;
                while (true) {
                    int computeExpectedState = computeExpectedState();
                    int i = fragment.mState;
                    int i2 = 3;
                    FragmentStore fragmentStore = this.mFragmentStore;
                    if (computeExpectedState != i) {
                        FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator = this.mDispatcher;
                        if (computeExpectedState > i) {
                            switch (i + 1) {
                                case 0:
                                    attach();
                                    continue;
                                case 1:
                                    create();
                                    continue;
                                case 2:
                                    ensureInflatedView();
                                    createView();
                                    continue;
                                case 3:
                                    activityCreated();
                                    continue;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup3, fragment.getParentFragmentManager());
                                        int visibility = fragment.mView.getVisibility();
                                        if (visibility == 0) {
                                            i2 = 2;
                                        } else if (visibility == 4) {
                                            i2 = 4;
                                        } else if (visibility != 8) {
                                            throw new IllegalArgumentException("Unknown visibility " + visibility);
                                        }
                                        ViewModelProvider.Factory.CC.m603m(i2, "finalState");
                                        if (FragmentManager.isLoggingEnabled(2)) {
                                            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                        }
                                        orCreateController.enqueue(i2, 2, this);
                                    }
                                    fragment.mState = 4;
                                    continue;
                                case 5:
                                    if (FragmentManager.isLoggingEnabled(3)) {
                                        Log.d("FragmentManager", "moveto STARTED: " + fragment);
                                    }
                                    fragment.performStart();
                                    fragmentAnim$AnimationOrAnimator.dispatchOnFragmentStarted(fragment, false);
                                    continue;
                                case 6:
                                    fragment.mState = 6;
                                    continue;
                                case 7:
                                    resume();
                                    continue;
                            }
                        } else {
                            switch (i - 1) {
                                case -1:
                                    detach();
                                    continue;
                                case 0:
                                    if (fragment.mBeingSaved) {
                                        if (((Bundle) fragmentStore.mSavedState.get(fragment.mWho)) == null) {
                                            fragmentStore.setSavedState(saveState(), fragment.mWho);
                                        }
                                    }
                                    destroy();
                                    continue;
                                case 1:
                                    destroyFragmentView();
                                    fragment.mState = 1;
                                    continue;
                                case 2:
                                    fragment.mInLayout = false;
                                    fragment.mState = 2;
                                    continue;
                                case 3:
                                    if (FragmentManager.isLoggingEnabled(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                                    }
                                    if (fragment.mBeingSaved) {
                                        fragmentStore.setSavedState(saveState(), fragment.mWho);
                                    } else if (fragment.mView != null && fragment.mSavedViewState == null) {
                                        saveViewState();
                                    }
                                    if (!(fragment.mView == null || (viewGroup2 = fragment.mContainer) == null)) {
                                        DefaultSpecialEffectsController orCreateController2 = DefaultSpecialEffectsController.getOrCreateController(viewGroup2, fragment.getParentFragmentManager());
                                        if (FragmentManager.isLoggingEnabled(2)) {
                                            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                        }
                                        orCreateController2.enqueue(1, 3, this);
                                    }
                                    fragment.mState = 3;
                                    continue;
                                case 4:
                                    if (FragmentManager.isLoggingEnabled(3)) {
                                        Log.d("FragmentManager", "movefrom STARTED: " + fragment);
                                    }
                                    fragment.performStop();
                                    fragmentAnim$AnimationOrAnimator.dispatchOnFragmentStopped(fragment, false);
                                    continue;
                                case 5:
                                    fragment.mState = 5;
                                    continue;
                                case 6:
                                    if (FragmentManager.isLoggingEnabled(3)) {
                                        Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
                                    }
                                    fragment.performPause();
                                    fragmentAnim$AnimationOrAnimator.dispatchOnFragmentPaused(fragment, false);
                                    continue;
                                default:
                                    continue;
                            }
                        }
                        z2 = true;
                    } else {
                        if (!z2 && i == -1 && fragment.mRemoving && !fragment.isInBackStack() && !fragment.mBeingSaved) {
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + fragment);
                            }
                            fragmentStore.mNonConfig.clearNonConfigState(fragment, true);
                            fragmentStore.makeInactive(this);
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Log.d("FragmentManager", "initState called for fragment: " + fragment);
                            }
                            fragment.initState();
                        }
                        if (fragment.mHiddenChanged) {
                            if (!(fragment.mView == null || (viewGroup = fragment.mContainer) == null)) {
                                DefaultSpecialEffectsController orCreateController3 = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
                                if (fragment.mHidden) {
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                    }
                                    orCreateController3.enqueue(3, 1, this);
                                } else {
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                    }
                                    orCreateController3.enqueue(2, 1, this);
                                }
                            }
                            FragmentManager fragmentManager = fragment.mFragmentManager;
                            if (fragmentManager != null && fragment.mAdded && FragmentManager.isMenuAvailable(fragment)) {
                                fragmentManager.mNeedMenuInvalidate = true;
                            }
                            fragment.mHiddenChanged = false;
                            fragment.onHiddenChanged(fragment.mHidden);
                            fragment.mChildFragmentManager.dispatchOnHiddenChanged();
                        }
                        this.mMovingToState = false;
                        return;
                    }
                }
            } catch (Throwable th) {
                this.mMovingToState = false;
                throw th;
            }
        } else if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
        }
    }

    public final void restoreState(ClassLoader classLoader) {
        Fragment fragment = this.mFragment;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            if (fragment.mSavedFragmentState.getBundle("savedInstanceState") == null) {
                fragment.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
            }
            try {
                fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("viewState");
                fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("viewRegistryState");
                FragmentState fragmentState = (FragmentState) fragment.mSavedFragmentState.getParcelable("state");
                if (fragmentState != null) {
                    fragment.mTargetWho = fragmentState.mTargetWho;
                    fragment.mTargetRequestCode = fragmentState.mTargetRequestCode;
                    Boolean bool = fragment.mSavedUserVisibleHint;
                    if (bool != null) {
                        fragment.mUserVisibleHint = bool.booleanValue();
                        fragment.mSavedUserVisibleHint = null;
                    } else {
                        fragment.mUserVisibleHint = fragmentState.mUserVisibleHint;
                    }
                }
                if (!fragment.mUserVisibleHint) {
                    fragment.mDeferStart = true;
                }
            } catch (BadParcelableException e) {
                throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + fragment, e);
            }
        }
    }

    public final void resume() {
        String str;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "moveto RESUMED: " + fragment);
        }
        View focusedView = fragment.getFocusedView();
        if (focusedView != null) {
            if (focusedView != fragment.mView) {
                for (ViewParent parent = focusedView.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != fragment.mView) {
                    }
                }
            }
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb.append(str);
                sb.append(" on Fragment ");
                sb.append(fragment);
                sb.append(" resulting in focused view ");
                sb.append(fragment.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        fragment.setFocusedView(null);
        fragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(fragment, false);
        this.mFragmentStore.setSavedState(null, fragment.mWho);
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle saveState() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.mFragment;
        if (fragment.mState == -1 && (bundle = fragment.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new FragmentState(fragment));
        if (fragment.mState > 0) {
            Bundle bundle3 = new Bundle();
            fragment.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.mDispatcher.dispatchOnFragmentSaveInstanceState(fragment, bundle3, false);
            Bundle bundle4 = new Bundle();
            fragment.mSavedStateRegistryController.performSave(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle saveAllStateInternal = fragment.mChildFragmentManager.saveAllStateInternal();
            if (!saveAllStateInternal.isEmpty()) {
                bundle2.putBundle("childFragmentManager", saveAllStateInternal);
            }
            if (fragment.mView != null) {
                saveViewState();
            }
            SparseArray<Parcelable> sparseArray = fragment.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = fragment.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = fragment.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void saveViewState() {
        Fragment fragment = this.mFragment;
        if (fragment.mView != null) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Saving view state for fragment " + fragment + " with view " + fragment.mView);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            fragment.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                fragment.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            fragment.mViewLifecycleOwner.mSavedStateRegistryController.performSave(bundle);
            if (!bundle.isEmpty()) {
                fragment.mSavedViewRegistryState = bundle;
            }
        }
    }

    public FragmentStateManager(FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator, FragmentStore fragmentStore, ClassLoader classLoader, FragmentManager.C00753 r5, Bundle bundle) {
        this.mDispatcher = fragmentAnim$AnimationOrAnimator;
        this.mFragmentStore = fragmentStore;
        Fragment instantiate = ((FragmentState) bundle.getParcelable("state")).instantiate(r5);
        this.mFragment = instantiate;
        instantiate.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle2);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    public FragmentStateManager(FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator, FragmentStore fragmentStore, Fragment fragment, Bundle bundle) {
        this.mDispatcher = fragmentAnim$AnimationOrAnimator;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        fragment.mSavedFragmentState = bundle;
        fragment.mArguments = bundle.getBundle("arguments");
    }
}
