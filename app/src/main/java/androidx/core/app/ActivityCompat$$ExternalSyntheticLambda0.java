package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ComponentActivity;
import androidx.collection.SimpleArrayMap;
import androidx.collection.internal.Lock;
import androidx.core.app.ActivityRecreator;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.p002os.BundleKt;
import androidx.core.p002os.TraceCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.customview.widget.ViewDragHelper;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation$MassState;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.emoji2.text.MetadataRepo;
import androidx.fragment.app.RunnableC0058xf804c657;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.navigation.Navigation;
import androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda0;
import androidx.transition.Transition;
import androidx.transition.Transition$SeekController$$ExternalSyntheticLambda0;
import androidx.transition.TransitionSet;
import com.emanuelef.remote_capture.activities.CaptureCtrl;
import com.emanuelef.remote_capture.activities.ConnectionDetailsActivity;
import com.emanuelef.remote_capture.activities.HttpDetailsActivity;
import com.emanuelef.remote_capture.fragments.AppsFragment;
import com.emanuelef.remote_capture.fragments.BlacklistsFragment;
import com.emanuelef.remote_capture.fragments.FirewallStatus;
import com.emanuelef.remote_capture.fragments.MalwareStatusFragment;
import com.github.appintro.AppIntroBase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.zzi;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.motion.MaterialBackOrchestrator$Api33BackCallbackDelegate;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.ClearTextEndIconDelegate;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final /* synthetic */ class ActivityCompat$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ActivityCompat$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x0305  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object obj;
        boolean z;
        long j;
        long j2;
        int i;
        long j3;
        boolean z2;
        long j4;
        int i2;
        SpringAnimation springAnimation;
        int i3;
        float min;
        boolean z3 = false;
        switch (this.$r8$classId) {
            case 0:
                Activity activity = (Activity) this.f$0;
                if (!activity.isFinishing()) {
                    Handler handler = ActivityRecreator.mainHandler;
                    Method method = ActivityRecreator.requestRelaunchActivityMethod;
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 28) {
                        activity.recreate();
                        return;
                    }
                    if (!(((i4 == 26 || i4 == 27) && method == null) || (ActivityRecreator.performStopActivity2ParamsMethod == null && ActivityRecreator.performStopActivity3ParamsMethod == null))) {
                        try {
                            Object obj2 = ActivityRecreator.tokenField.get(activity);
                            if (!(obj2 == null || (obj = ActivityRecreator.mainThreadField.get(activity)) == null)) {
                                Application application = activity.getApplication();
                                ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks = new ActivityRecreator.LifecycleCheckCallbacks(activity);
                                application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                                handler.post(new zzi(lifecycleCheckCallbacks, 1, obj2));
                                if (i4 == 26 || i4 == 27) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new zzi(application, 2, lifecycleCheckCallbacks));
                                return;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    activity.recreate();
                    return;
                }
                return;
            case 1:
                ((ComponentActivity) this.f$0).invalidateMenu();
                return;
            case 2:
                ComponentActivity.ReportFullyDrawnExecutorApi16Impl reportFullyDrawnExecutorApi16Impl = (ComponentActivity.ReportFullyDrawnExecutorApi16Impl) this.f$0;
                Runnable runnable = reportFullyDrawnExecutorApi16Impl.mRunnable;
                if (runnable != null) {
                    runnable.run();
                    reportFullyDrawnExecutorApi16Impl.mRunnable = null;
                    return;
                }
                return;
            case 3:
                ActivityCompat$$ExternalSyntheticLambda0.super.onBackPressed();
                return;
            case 4:
                AnimationHandler animationHandler = (AnimationHandler) ((AnimationHandler) this.f$0).mCallbackDispatcher.mScrollEventAdapter;
                long uptimeMillis = SystemClock.uptimeMillis();
                ArrayList arrayList = animationHandler.mAnimationCallbacks;
                long uptimeMillis2 = SystemClock.uptimeMillis();
                int i5 = 0;
                while (i5 < arrayList.size()) {
                    SpringAnimation springAnimation2 = (SpringAnimation) arrayList.get(i5);
                    if (springAnimation2 != null) {
                        SimpleArrayMap simpleArrayMap = animationHandler.mDelayedCallbackStartTime;
                        Long l = (Long) simpleArrayMap.get(springAnimation2);
                        if (l != null) {
                            if (l.longValue() < uptimeMillis2) {
                                simpleArrayMap.remove(springAnimation2);
                            }
                        }
                        long j5 = springAnimation2.mLastFrameTime;
                        if (j5 == 0) {
                            springAnimation2.mLastFrameTime = uptimeMillis;
                            springAnimation2.setPropertyValue(springAnimation2.mValue);
                        } else {
                            long j6 = uptimeMillis - j5;
                            springAnimation2.mLastFrameTime = uptimeMillis;
                            float f = SpringAnimation.getAnimationHandler().mDurationScale;
                            if (f == 0.0f) {
                                j3 = 2147483647L;
                            } else {
                                j3 = ((float) j6) / f;
                            }
                            long j7 = j3;
                            if (springAnimation2.mEndRequested) {
                                float f2 = springAnimation2.mPendingPosition;
                                if (f2 != Float.MAX_VALUE) {
                                    j = uptimeMillis;
                                    springAnimation2.mSpring.mFinalPosition = f2;
                                    springAnimation2.mPendingPosition = Float.MAX_VALUE;
                                } else {
                                    j = uptimeMillis;
                                }
                                springAnimation2.mValue = (float) springAnimation2.mSpring.mFinalPosition;
                                springAnimation2.mVelocity = 0.0f;
                                springAnimation2.mEndRequested = z3;
                            } else {
                                j = uptimeMillis;
                                if (springAnimation2.mPendingPosition != Float.MAX_VALUE) {
                                    long j8 = j7 / 2;
                                    DynamicAnimation$MassState updateValues = springAnimation2.mSpring.updateValues(springAnimation2.mValue, springAnimation2.mVelocity, j8);
                                    SpringForce springForce = springAnimation2.mSpring;
                                    springForce.mFinalPosition = springAnimation2.mPendingPosition;
                                    springAnimation2.mPendingPosition = Float.MAX_VALUE;
                                    DynamicAnimation$MassState updateValues2 = springForce.updateValues(updateValues.mValue, updateValues.mVelocity, j8);
                                    springAnimation2.mValue = updateValues2.mValue;
                                    springAnimation2.mVelocity = updateValues2.mVelocity;
                                } else {
                                    DynamicAnimation$MassState updateValues3 = springAnimation2.mSpring.updateValues(springAnimation2.mValue, springAnimation2.mVelocity, j7);
                                    springAnimation2.mValue = updateValues3.mValue;
                                    springAnimation2.mVelocity = updateValues3.mVelocity;
                                }
                                float max = Math.max(springAnimation2.mValue, springAnimation2.mMinValue);
                                springAnimation2.mValue = max;
                                springAnimation2.mValue = Math.min(max, springAnimation2.mMaxValue);
                                float f3 = springAnimation2.mVelocity;
                                SpringForce springForce2 = springAnimation2.mSpring;
                                springForce2.getClass();
                                if (Math.abs(f3) >= springForce2.mVelocityThreshold || Math.abs(min - ((float) springForce2.mFinalPosition)) >= springForce2.mValueThreshold) {
                                    z2 = false;
                                    float min2 = Math.min(springAnimation2.mValue, springAnimation2.mMaxValue);
                                    springAnimation2.mValue = min2;
                                    float max2 = Math.max(min2, springAnimation2.mMinValue);
                                    springAnimation2.mValue = max2;
                                    springAnimation2.setPropertyValue(max2);
                                    if (z2) {
                                        ArrayList arrayList2 = springAnimation2.mEndListeners;
                                        springAnimation2.mRunning = false;
                                        AnimationHandler animationHandler2 = SpringAnimation.getAnimationHandler();
                                        animationHandler2.mDelayedCallbackStartTime.remove(springAnimation2);
                                        ArrayList arrayList3 = animationHandler2.mAnimationCallbacks;
                                        int indexOf = arrayList3.indexOf(springAnimation2);
                                        if (indexOf >= 0) {
                                            arrayList3.set(indexOf, null);
                                            animationHandler2.mListDirty = true;
                                        }
                                        springAnimation2.mLastFrameTime = 0L;
                                        springAnimation2.mStartValueIsSet = false;
                                        int i6 = 0;
                                        while (i6 < arrayList2.size()) {
                                            if (arrayList2.get(i6) != null) {
                                                float f4 = springAnimation2.mValue;
                                                Transition.SeekController seekController = ((Transition$SeekController$$ExternalSyntheticLambda0) arrayList2.get(i6)).f$0;
                                                Transition.TransitionNotification transitionNotification = Transition.TransitionNotification.ON_END;
                                                TransitionSet transitionSet = seekController.this$0;
                                                if (f4 < 1.0f) {
                                                    long j9 = transitionSet.mTotalDuration;
                                                    Transition transitionAt = transitionSet.getTransitionAt(0);
                                                    Transition transition = transitionAt.mCloneParent;
                                                    i2 = i6;
                                                    transitionAt.mCloneParent = null;
                                                    j4 = uptimeMillis2;
                                                    i3 = i5;
                                                    springAnimation = springAnimation2;
                                                    transitionSet.setCurrentPlayTimeMillis(-1L, seekController.mCurrentPlayTime);
                                                    transitionSet.setCurrentPlayTimeMillis(j9, -1L);
                                                    seekController.mCurrentPlayTime = j9;
                                                    RunnableC0058xf804c657 defaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4 = seekController.mResetToStartState;
                                                    if (defaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4 != null) {
                                                        defaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4.run();
                                                    }
                                                    transitionSet.mAnimators.clear();
                                                    if (transition != null) {
                                                        transition.notifyFromTransition(transition, transitionNotification, true);
                                                    }
                                                } else {
                                                    i2 = i6;
                                                    j4 = uptimeMillis2;
                                                    i3 = i5;
                                                    springAnimation = springAnimation2;
                                                    transitionSet.notifyFromTransition(transitionSet, transitionNotification, false);
                                                }
                                                i5 = i3;
                                                springAnimation2 = springAnimation;
                                                i6 = i2 + 1;
                                                uptimeMillis2 = j4;
                                            } else {
                                                i2 = i6;
                                                j4 = uptimeMillis2;
                                                i3 = i5;
                                                springAnimation = springAnimation2;
                                            }
                                            i5 = i3;
                                            springAnimation2 = springAnimation;
                                            i6 = i2 + 1;
                                            uptimeMillis2 = j4;
                                        }
                                        j2 = uptimeMillis2;
                                        i = i5;
                                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                                            if (arrayList2.get(size) == null) {
                                                arrayList2.remove(size);
                                            }
                                        }
                                        i5 = i + 1;
                                        uptimeMillis2 = j2;
                                        uptimeMillis = j;
                                        z3 = false;
                                    }
                                    j2 = uptimeMillis2;
                                    i = i5;
                                    i5 = i + 1;
                                    uptimeMillis2 = j2;
                                    uptimeMillis = j;
                                    z3 = false;
                                } else {
                                    springAnimation2.mValue = (float) springAnimation2.mSpring.mFinalPosition;
                                    springAnimation2.mVelocity = 0.0f;
                                }
                            }
                            z2 = true;
                            float min22 = Math.min(springAnimation2.mValue, springAnimation2.mMaxValue);
                            springAnimation2.mValue = min22;
                            float max22 = Math.max(min22, springAnimation2.mMinValue);
                            springAnimation2.mValue = max22;
                            springAnimation2.setPropertyValue(max22);
                            if (z2) {
                            }
                            j2 = uptimeMillis2;
                            i = i5;
                            i5 = i + 1;
                            uptimeMillis2 = j2;
                            uptimeMillis = j;
                            z3 = false;
                        }
                    }
                    j = uptimeMillis;
                    j2 = uptimeMillis2;
                    i = i5;
                    i5 = i + 1;
                    uptimeMillis2 = j2;
                    uptimeMillis = j;
                    z3 = false;
                }
                if (animationHandler.mListDirty) {
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        if (arrayList.get(size2) == null) {
                            arrayList.remove(size2);
                        }
                    }
                    if (arrayList.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                        animationHandler.mDurationScaleChangeListener.unregister();
                    }
                    animationHandler.mListDirty = false;
                }
                if (arrayList.size() > 0) {
                    ((Choreographer) animationHandler.mScheduler.zzb).postFrameCallback(new ProfileInstallerInitializer$$ExternalSyntheticLambda0(animationHandler.mRunnable));
                    return;
                }
                return;
            case 5:
                FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) this.f$0;
                synchronized (fontRequestMetadataLoader.mLock) {
                    try {
                        if (fontRequestMetadataLoader.mCallback != null) {
                            try {
                                FontsContractCompat$FontInfo retrieveFontInfo = fontRequestMetadataLoader.retrieveFontInfo();
                                int i7 = retrieveFontInfo.mResultCode;
                                if (i7 == 2) {
                                    synchronized (fontRequestMetadataLoader.mLock) {
                                    }
                                }
                                if (i7 == 0) {
                                    Method method2 = TraceCompat.sIsTagEnabledMethod;
                                    Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                    Lock lock = fontRequestMetadataLoader.mFontProviderHelper;
                                    Context context = fontRequestMetadataLoader.mContext;
                                    lock.getClass();
                                    Typeface createFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, new FontsContractCompat$FontInfo[]{retrieveFontInfo}, 0);
                                    MappedByteBuffer mmap = BundleKt.mmap(fontRequestMetadataLoader.mContext, retrieveFontInfo.mUri);
                                    if (mmap == null || createFromFontInfo == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                    MetadataRepo metadataRepo = new MetadataRepo(createFromFontInfo, Navigation.read(mmap));
                                    Trace.endSection();
                                    Trace.endSection();
                                    synchronized (fontRequestMetadataLoader.mLock) {
                                        Navigation navigation = fontRequestMetadataLoader.mCallback;
                                        if (navigation != null) {
                                            navigation.onLoaded(metadataRepo);
                                        }
                                    }
                                    fontRequestMetadataLoader.cleanUp();
                                    return;
                                }
                                throw new RuntimeException("fetchFonts result is not OK. (" + i7 + ")");
                            } catch (Throwable th) {
                                synchronized (fontRequestMetadataLoader.mLock) {
                                    try {
                                        Navigation navigation2 = fontRequestMetadataLoader.mCallback;
                                        if (navigation2 != null) {
                                            navigation2.onFailed(th);
                                        }
                                        fontRequestMetadataLoader.cleanUp();
                                        return;
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            return;
                        }
                    } finally {
                    }
                }
            case 6:
                ProcessLifecycleOwner processLifecycleOwner = (ProcessLifecycleOwner) this.f$0;
                LifecycleRegistry lifecycleRegistry = processLifecycleOwner.registry;
                if (processLifecycleOwner.resumedCounter == 0) {
                    processLifecycleOwner.pauseSent = true;
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
                }
                if (processLifecycleOwner.startedCounter == 0 && processLifecycleOwner.pauseSent) {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                    processLifecycleOwner.stopSent = true;
                    return;
                }
                return;
            case 7:
                CaptureCtrl.m724$r8$lambda$Hp4QKpslLPieWupMSGtnwdUsIQ((CaptureCtrl) this.f$0);
                return;
            case 8:
                ConnectionDetailsActivity.m725$r8$lambda$XGrxTP5yO4dgE73kd8jV2eXI3c((ConnectionDetailsActivity) this.f$0);
                return;
            case 9:
                ((HttpDetailsActivity) this.f$0).dispatchConnUpdate();
                return;
            case 10:
                ((AppsFragment) this.f$0).doRefreshApps();
                return;
            case 11:
                BlacklistsFragment.$r8$lambda$HNhlldnUBTxEBZuMVq0Wg3tzuQs((BlacklistsFragment) this.f$0);
                return;
            case 12:
                ((FirewallStatus) this.f$0).updateStatus();
                return;
            case 13:
                ((MalwareStatusFragment) this.f$0).updateStatus();
                return;
            case 14:
                AppIntroBase.m874$r8$lambda$NWNhR1g9TmE6D3q_J_pOxL4MlU((AppIntroBase) this.f$0);
                return;
            case 15:
                MetadataRepo metadataRepo2 = (MetadataRepo) this.f$0;
                ((SQLiteEventStore) ((SynchronizationGuard) metadataRepo2.mTypeface)).runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(15, metadataRepo2));
                return;
            case 16:
                MaterialButton.m880$r8$lambda$sTDU5mTMHdVAgylGXPenYNnUDs((MaterialButton) this.f$0);
                return;
            case 17:
                ((CarouselLayoutManager) this.f$0).requestLayout();
                return;
            case 18:
                View view = (View) this.f$0;
                ((InputMethodManager) BundleKt.getSystemService(view.getContext(), InputMethodManager.class)).showSoftInput(view, 1);
                return;
            case 19:
                MatcherMatchResult matcherMatchResult = (MatcherMatchResult) this.f$0;
                MaterialBackOrchestrator$Api33BackCallbackDelegate materialBackOrchestrator$Api33BackCallbackDelegate = (MaterialBackOrchestrator$Api33BackCallbackDelegate) matcherMatchResult.matcher;
                if (materialBackOrchestrator$Api33BackCallbackDelegate != null) {
                    materialBackOrchestrator$Api33BackCallbackDelegate.startListeningForBackCallbacks((NavigationView) matcherMatchResult.input, (NavigationView) matcherMatchResult.groups, true);
                    return;
                }
                return;
            case 20:
                SideSheetBehavior.StateSettlingTracker stateSettlingTracker = (SideSheetBehavior.StateSettlingTracker) this.f$0;
                stateSettlingTracker.isContinueSettlingRunnablePosted = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) stateSettlingTracker.this$0;
                ViewDragHelper viewDragHelper = sideSheetBehavior.viewDragHelper;
                if (viewDragHelper != null && viewDragHelper.continueSettling()) {
                    stateSettlingTracker.continueSettlingToState(stateSettlingTracker.targetState);
                    return;
                } else if (sideSheetBehavior.state == 2) {
                    sideSheetBehavior.setStateInternal(stateSettlingTracker.targetState);
                    return;
                } else {
                    return;
                }
            case 21:
                Slider slider = (Slider) this.f$0;
                slider.setActiveThumbIndex(-1);
                slider.invalidate();
                return;
            case 22:
                ((ClearTextEndIconDelegate) this.f$0).animateIcon(true);
                return;
            case 23:
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.f$0;
                boolean isPopupShowing = dropdownMenuEndIconDelegate.autoCompleteTextView.isPopupShowing();
                dropdownMenuEndIconDelegate.setEndIconChecked(isPopupShowing);
                dropdownMenuEndIconDelegate.dropdownPopupDirty = isPopupShowing;
                return;
            default:
                ((TextInputLayout) this.f$0).editText.requestLayout();
                return;
        }
    }
}
