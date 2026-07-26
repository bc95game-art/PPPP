package com.android.billingclient.api;

import android.os.SystemClock;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper$ClampedScroller;
import androidx.core.widget.ListViewAutoScrollHelper;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda15;
import com.github.appintro.internal.AppIntroViewPager;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final /* synthetic */ class zzab implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;

    public /* synthetic */ zzab(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        MenuBuilder menuBuilder;
        boolean z;
        int i;
        View view;
        int i2;
        int i3 = this.$r8$classId;
        int i4 = 3;
        Object obj = this.zza;
        switch (i3) {
            case 0:
                BillingResult billingResult = zzcj.zzk;
                ((BillingClientImpl) obj).zzbd(24, 3, billingResult);
                PlayBilling.lambda$processPurchases$6(billingResult);
                return;
            case 1:
                ToolbarActionBar toolbarActionBar = (ToolbarActionBar) obj;
                Window.Callback callback = toolbarActionBar.mWindowCallback;
                Menu menu = toolbarActionBar.getMenu();
                if (menu instanceof MenuBuilder) {
                    menuBuilder = (MenuBuilder) menu;
                } else {
                    menuBuilder = null;
                }
                if (menuBuilder != null) {
                    menuBuilder.stopDispatchingItemsChanged();
                }
                try {
                    menu.clear();
                    if (callback.onCreatePanelMenu(0, menu)) {
                        if (!callback.onPreparePanel(0, null, menu)) {
                        }
                        if (menuBuilder == null) {
                            menuBuilder.startDispatchingItemsChanged();
                            return;
                        }
                        return;
                    }
                    menu.clear();
                    if (menuBuilder == null) {
                    }
                } catch (Throwable th) {
                    if (menuBuilder != null) {
                        menuBuilder.startDispatchingItemsChanged();
                    }
                    throw th;
                }
            case 2:
                AnimatedStateListDrawableCompat animatedStateListDrawableCompat = (AnimatedStateListDrawableCompat) obj;
                animatedStateListDrawableCompat.animate(true);
                animatedStateListDrawableCompat.invalidateSelf();
                return;
            case 3:
                DropDownListView dropDownListView = (DropDownListView) obj;
                dropDownListView.mResolveHoverRunnable = null;
                dropDownListView.drawableStateChanged();
                return;
            case 4:
                ((Toolbar) obj).showOverflowMenu();
                return;
            case 5:
                ListViewAutoScrollHelper listViewAutoScrollHelper = (ListViewAutoScrollHelper) obj;
                DropDownListView dropDownListView2 = listViewAutoScrollHelper.mTarget$1;
                AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = listViewAutoScrollHelper.mScroller;
                if (listViewAutoScrollHelper.mAnimating) {
                    if (listViewAutoScrollHelper.mNeedsReset) {
                        listViewAutoScrollHelper.mNeedsReset = false;
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        autoScrollHelper$ClampedScroller.mStartTime = currentAnimationTimeMillis;
                        autoScrollHelper$ClampedScroller.mStopTime = -1L;
                        autoScrollHelper$ClampedScroller.mDeltaTime = currentAnimationTimeMillis;
                        autoScrollHelper$ClampedScroller.mStopValue = 0.5f;
                    }
                    if ((autoScrollHelper$ClampedScroller.mStopTime <= 0 || AnimationUtils.currentAnimationTimeMillis() <= autoScrollHelper$ClampedScroller.mStopTime + autoScrollHelper$ClampedScroller.mEffectiveRampDown) && listViewAutoScrollHelper.shouldAnimate()) {
                        if (listViewAutoScrollHelper.mNeedsCancel) {
                            listViewAutoScrollHelper.mNeedsCancel = false;
                            long uptimeMillis = SystemClock.uptimeMillis();
                            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                            dropDownListView2.onTouchEvent(obtain);
                            obtain.recycle();
                        }
                        if (autoScrollHelper$ClampedScroller.mDeltaTime != 0) {
                            long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                            float valueAt = autoScrollHelper$ClampedScroller.getValueAt(currentAnimationTimeMillis2);
                            autoScrollHelper$ClampedScroller.mDeltaTime = currentAnimationTimeMillis2;
                            listViewAutoScrollHelper.mTarget.scrollListBy((int) (((float) (currentAnimationTimeMillis2 - autoScrollHelper$ClampedScroller.mDeltaTime)) * ((valueAt * 4.0f) + ((-4.0f) * valueAt * valueAt)) * autoScrollHelper$ClampedScroller.mTargetVelocityY));
                            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            dropDownListView2.postOnAnimation(this);
                            return;
                        }
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    listViewAutoScrollHelper.mAnimating = false;
                    return;
                }
                return;
            case 6:
                ((ViewDragHelper) obj).setDragState(0);
                return;
            case 7:
                DrawerLayout.ViewDragCallback viewDragCallback = (DrawerLayout.ViewDragCallback) obj;
                DrawerLayout drawerLayout = DrawerLayout.this;
                int i5 = viewDragCallback.mDragger.mEdgeSize;
                int i6 = viewDragCallback.mAbsGravity;
                if (i6 == 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    view = drawerLayout.findDrawerWithGravity(3);
                    if (view != null) {
                        i2 = -view.getWidth();
                    } else {
                        i2 = 0;
                    }
                    i = i2 + i5;
                } else {
                    view = drawerLayout.findDrawerWithGravity(5);
                    i = drawerLayout.getWidth() - i5;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && drawerLayout.getDrawerLockMode(view) == 0) {
                    viewDragCallback.mDragger.smoothSlideViewTo(view, i, view.getTop());
                    ((DrawerLayout.LayoutParams) view.getLayoutParams()).isPeeking = true;
                    drawerLayout.invalidate();
                    if (i6 == 3) {
                        i4 = 5;
                    }
                    View findDrawerWithGravity = drawerLayout.findDrawerWithGravity(i4);
                    if (findDrawerWithGravity != null) {
                        drawerLayout.closeDrawer(findDrawerWithGravity, true);
                    }
                    if (!drawerLayout.mChildrenCanceledTouch) {
                        long uptimeMillis2 = SystemClock.uptimeMillis();
                        MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        for (int i7 = 0; i7 < childCount; i7++) {
                            drawerLayout.getChildAt(i7).dispatchTouchEvent(obtain2);
                        }
                        obtain2.recycle();
                        drawerLayout.mChildrenCanceledTouch = true;
                        return;
                    }
                    return;
                }
                return;
            case 8:
                AppIntroViewPager appIntroViewPager = (AppIntroViewPager) obj;
                appIntroViewPager.setScrollState(0);
                appIntroViewPager.populate();
                return;
            case 9:
                zzbf zzbfVar = (zzbf) obj;
                BillingClientImpl billingClientImpl = zzbfVar.zza;
                billingClientImpl.zzaS(0);
                BillingResult billingResult2 = zzcj.zzk;
                billingClientImpl.zzaR(24, billingResult2);
                zzbfVar.zzg(billingResult2);
                return;
            case 10:
                try {
                    ((Runnable) obj).run();
                    return;
                } catch (Exception e) {
                    Navigation.m589e("Executor", "Background execution failure.", e);
                    return;
                }
            case 11:
                ((zabq) obj).zaH();
                return;
            case 12:
                Api$Client api$Client = ((zabq) ((FakeDrag) obj).mScrollEventAdapter).zac;
                api$Client.disconnect(api$Client.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 13:
                throw null;
            case 14:
                SideSheetBehavior.StateSettlingTracker stateSettlingTracker = (SideSheetBehavior.StateSettlingTracker) obj;
                stateSettlingTracker.isContinueSettlingRunnablePosted = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) stateSettlingTracker.this$0;
                ViewDragHelper viewDragHelper = bottomSheetBehavior.viewDragHelper;
                if (viewDragHelper != null && viewDragHelper.continueSettling()) {
                    stateSettlingTracker.continueSettlingToState(stateSettlingTracker.targetState);
                    return;
                } else if (bottomSheetBehavior.state == 2) {
                    bottomSheetBehavior.setStateInternal(stateSettlingTracker.targetState);
                    return;
                } else {
                    return;
                }
            default:
                CheckableImageButton checkableImageButton = ((TextInputLayout) obj).endLayout.endIconView;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
        }
    }

    public /* synthetic */ zzab(BillingClientImpl billingClientImpl, PlayBilling$$ExternalSyntheticLambda15 playBilling$$ExternalSyntheticLambda15) {
        this.$r8$classId = 0;
        this.zza = billingClientImpl;
    }

    public zzab(zaae zaaeVar, zzbv zzbvVar) {
        this.$r8$classId = 13;
        this.zza = zzbvVar;
    }
}
