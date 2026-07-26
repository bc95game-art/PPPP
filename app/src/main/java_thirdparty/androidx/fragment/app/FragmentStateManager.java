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
import com.emanuelef.remote_capture.R;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void addViewToContainer() {
        /*
            r8 = this;
            androidx.fragment.app.Fragment r0 = r8.mFragment
            android.view.ViewGroup r1 = r0.mContainer
        L4:
            r2 = 0
            if (r1 == 0) goto L27
            r3 = 2131362163(0x7f0a0173, float:1.8344099E38)
            java.lang.Object r3 = r1.getTag(r3)
            boolean r4 = r3 instanceof androidx.fragment.app.Fragment
            if (r4 == 0) goto L15
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            goto L16
        L15:
            r3 = r2
        L16:
            if (r3 == 0) goto L1a
            r2 = r3
            goto L27
        L1a:
            android.view.ViewParent r1 = r1.getParent()
            boolean r3 = r1 instanceof android.view.View
            if (r3 == 0) goto L25
            android.view.View r1 = (android.view.View) r1
            goto L4
        L25:
            r1 = r2
            goto L4
        L27:
            androidx.fragment.app.Fragment r1 = r0.getParentFragment()
            if (r2 == 0) goto L69
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L69
            int r1 = r0.mContainerId
            androidx.fragment.app.strictmode.FragmentStrictMode$Policy r3 = androidx.fragment.app.strictmode.FragmentStrictMode.defaultPolicy
            androidx.fragment.app.strictmode.FragmentReuseViolation r3 = new androidx.fragment.app.strictmode.FragmentReuseViolation
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Attempting to nest fragment "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r5 = " within the view of parent fragment "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " via container with ID "
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = " without using parent's childFragmentManager"
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r0, r1)
            androidx.fragment.app.strictmode.FragmentStrictMode.logIfDebuggingEnabled(r3)
            androidx.fragment.app.strictmode.FragmentStrictMode$Policy r1 = androidx.fragment.app.strictmode.FragmentStrictMode.getNearestPolicy(r0)
            r1.getClass()
        L69:
            androidx.fragment.app.FragmentStore r1 = r8.mFragmentStore
            java.util.ArrayList r1 = r1.mAdded
            android.view.ViewGroup r2 = r0.mContainer
            r3 = -1
            if (r2 != 0) goto L73
            goto Laf
        L73:
            int r4 = r1.indexOf(r0)
            int r5 = r4 + (-1)
        L79:
            if (r5 < 0) goto L93
            java.lang.Object r6 = r1.get(r5)
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            android.view.ViewGroup r7 = r6.mContainer
            if (r7 != r2) goto L90
            android.view.View r6 = r6.mView
            if (r6 == 0) goto L90
            int r1 = r2.indexOfChild(r6)
            int r3 = r1 + 1
            goto Laf
        L90:
            int r5 = r5 + (-1)
            goto L79
        L93:
            int r4 = r4 + 1
            int r5 = r1.size()
            if (r4 >= r5) goto Laf
            java.lang.Object r5 = r1.get(r4)
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            android.view.ViewGroup r6 = r5.mContainer
            if (r6 != r2) goto Lae
            android.view.View r5 = r5.mView
            if (r5 == 0) goto Lae
            int r3 = r2.indexOfChild(r5)
            goto Laf
        Lae:
            goto L93
        Laf:
            android.view.ViewGroup r1 = r0.mContainer
            android.view.View r0 = r0.mView
            r1.addView(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.addViewToContainer():void");
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
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
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
                        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m("Cannot create fragment ", fragment, " for a container view with no id"));
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
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
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
            if (ViewModelProvider.Factory.CC.m((Object) appCompatActivity)) {
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
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void moveToExpectedState() {
        /*
            Method dump skipped, instructions count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.moveToExpectedState():void");
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

    public FragmentStateManager(FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator, FragmentStore fragmentStore, ClassLoader classLoader, FragmentManager.AnonymousClass3 r5, Bundle bundle) {
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
