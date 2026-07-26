package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.collection.internal.Lock;
import androidx.core.util.TimeUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.emoji2.text.MetadataRepo;
import androidx.fragment.app.RunnableC0058xf804c657;
import androidx.lifecycle.SavedStateHandlesVM;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManagerImpl;
import androidx.navigation.Navigation;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.emanuelef.remote_capture.Blacklists;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.activities.BaseActivity$$ExternalSyntheticLambda0;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import com.google.android.material.tooltip.TooltipDrawable;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.google.gson.JsonSerializationContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.ranges.RangesKt;
import org.brotli.dec.HuffmanTreeGroup;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    public ArrayList mEndValuesList;
    public Navigation mEpicenterCallback;
    public TransitionListener[] mListenersCache;
    public SeekController mSeekController;
    public long mSeekOffsetInParent;
    public ArrayList mStartValuesList;
    public long mTotalDuration;
    public static final Animator[] EMPTY_ANIMATOR_ARRAY = new Animator[0];
    public static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    public static final C01101 STRAIGHT_PATH_MOTION = new C01101(0);
    public static final ThreadLocal sRunningAnimators = new ThreadLocal();
    public final String mName = getClass().getName();
    public long mStartDelay = -1;
    public long mDuration = -1;
    public TimeInterpolator mInterpolator = null;
    public final ArrayList mTargetIds = new ArrayList();
    public final ArrayList mTargets = new ArrayList();
    public MetadataRepo mStartValues = new MetadataRepo(4);
    public MetadataRepo mEndValues = new MetadataRepo(4);
    public TransitionSet mParent = null;
    public final int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    public final ArrayList mCurrentAnimators = new ArrayList();
    public Animator[] mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
    public int mNumInstances = 0;
    public boolean mPaused = false;
    public boolean mEnded = false;
    public Transition mCloneParent = null;
    public ArrayList mListeners = null;
    public ArrayList mAnimators = new ArrayList();
    public C01101 mPathMotion = STRAIGHT_PATH_MOTION;

    /* renamed from: androidx.transition.Transition$1 */
    /* loaded from: classes.dex */
    public class C01101 implements MenuPresenter.Callback, ViewModelProvider.Factory, CreationExtras.Key, Preference.SummaryProvider, Factory, JsonSerializationContext {
        public static C01101 _instance;
        public static C01101 sSimpleSummaryProvider;
        public static C01101 zza;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ C01101(int i) {
            this.$r8$classId = i;
        }

        public static C01101 create(Context context, int i) {
            TimeUtils.checkArgument("Cannot create a CalendarItemStyle with a styleResId of 0", i != 0);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.MaterialCalendarItem);
            Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
            LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 4);
            LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 9);
            LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 7);
            obtainStyledAttributes.getDimensionPixelSize(8, 0);
            ShapeAppearanceModel.builder(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0)).build();
            obtainStyledAttributes.recycle();
            C01101 r6 = new C01101(18);
            TimeUtils.checkArgumentNonnegative(rect.left);
            TimeUtils.checkArgumentNonnegative(rect.top);
            TimeUtils.checkArgumentNonnegative(rect.right);
            TimeUtils.checkArgumentNonnegative(rect.bottom);
            return r6;
        }

        public static Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.datatransport.runtime.time.Clock, java.lang.Object] */
        @Override // javax.inject.Provider
        public Object get() {
            ?? obj = new Object();
            HashMap hashMap = new HashMap();
            Set set = Collections.EMPTY_SET;
            if (set != null) {
                hashMap.put(Priority.DEFAULT, new AutoValue_SchedulerConfig_ConfigValue(30000L, Blacklists.BLACKLISTS_UPDATE_MILLIS, set));
                if (set != null) {
                    hashMap.put(Priority.HIGHEST, new AutoValue_SchedulerConfig_ConfigValue(1000L, Blacklists.BLACKLISTS_UPDATE_MILLIS, set));
                    if (set != null) {
                        Set unmodifiableSet = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(SchedulerConfig$Flag.DEVICE_IDLE)));
                        if (unmodifiableSet != null) {
                            hashMap.put(Priority.VERY_LOW, new AutoValue_SchedulerConfig_ConfigValue(Blacklists.BLACKLISTS_UPDATE_MILLIS, Blacklists.BLACKLISTS_UPDATE_MILLIS, unmodifiableSet));
                            if (hashMap.keySet().size() >= Priority.values().length) {
                                new HashMap();
                                return new AutoValue_SchedulerConfig(obj, hashMap);
                            }
                            throw new IllegalStateException("Not all priorities have been configured");
                        }
                        throw new NullPointerException("Null flags");
                    }
                    throw new NullPointerException("Null flags");
                }
                throw new NullPointerException("Null flags");
            }
            throw new NullPointerException("Null flags");
        }

        public Signature[] getSigningSignatures(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public boolean isPrecomputedText(CharSequence charSequence) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }

        @Override // androidx.preference.Preference.SummaryProvider
        public CharSequence provideSummary(Preference preference) {
            CharSequence charSequence;
            CharSequence[] charSequenceArr;
            CharSequence[] charSequenceArr2;
            ListPreference listPreference = (ListPreference) preference;
            int findIndexOfValue = listPreference.findIndexOfValue(listPreference.mValue);
            if (findIndexOfValue < 0 || (charSequenceArr2 = listPreference.mEntries) == null) {
                charSequence = null;
            } else {
                charSequence = charSequenceArr2[findIndexOfValue];
            }
            if (TextUtils.isEmpty(charSequence)) {
                return listPreference.mContext.getString(C0130R.string.not_set);
            }
            int findIndexOfValue2 = listPreference.findIndexOfValue(listPreference.mValue);
            if (findIndexOfValue2 < 0 || (charSequenceArr = listPreference.mEntries) == null) {
                return null;
            }
            return charSequenceArr[findIndexOfValue2];
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 20:
                    return "<NULL>";
                default:
                    return super.toString();
            }
        }

        public C01101(View view) {
            this.$r8$classId = 4;
            if (Build.VERSION.SDK_INT >= 30) {
                new Lock(view);
            } else {
                new Lock(view);
            }
        }

        public ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
            switch (this.$r8$classId) {
                case 8:
                    create(cls);
                    throw null;
                case 9:
                default:
                    return create(cls);
                case 10:
                    return create(cls);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
            ViewModel create;
            switch (this.$r8$classId) {
                case 8:
                    return new SavedStateHandlesVM();
                case 9:
                default:
                    create = create(RangesKt.getJavaClass(classReference), mutableCreationExtras);
                    return create;
                case 10:
                    return create(RangesKt.getJavaClass(classReference), mutableCreationExtras);
            }
        }

        public ViewModel create(Class cls) {
            switch (this.$r8$classId) {
                case 8:
                    throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
                case 9:
                default:
                    return new LoaderManagerImpl.LoaderViewModel();
                case 10:
                    return Navigation.createViewModel(cls);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }
    }

    /* renamed from: androidx.transition.Transition$2 */
    /* loaded from: classes.dex */
    public final class C01112 extends AnimatorListenerAdapter {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;
        public final /* synthetic */ Object val$runningAnimators;

        public /* synthetic */ C01112(View view, int i, Object obj) {
            this.$r8$classId = i;
            this.val$runningAnimators = obj;
            this.this$0 = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            switch (this.$r8$classId) {
                case 0:
                    ((ArrayMap) this.val$runningAnimators).remove(animator);
                    ((Transition) this.this$0).mCurrentAnimators.remove(animator);
                    return;
                case 1:
                    ((WindowInsetsAnimationCompat) this.val$runningAnimators).mImpl.setFraction(1.0f);
                    WindowInsetsAnimationCompat.Impl21.dispatchOnEnd((View) this.this$0);
                    return;
                default:
                    DrawerLayout drawerLayout = (DrawerLayout) this.val$runningAnimators;
                    drawerLayout.closeDrawer((NavigationView) this.this$0, false);
                    drawerLayout.setScrimColor(-1728053248);
                    return;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            switch (this.$r8$classId) {
                case 0:
                    ((Transition) this.this$0).mCurrentAnimators.add(animator);
                    return;
                default:
                    super.onAnimationStart(animator);
                    return;
            }
        }

        public C01112(Transition transition, ArrayMap arrayMap) {
            this.$r8$classId = 0;
            this.this$0 = transition;
            this.val$runningAnimators = arrayMap;
        }
    }

    /* renamed from: androidx.transition.Transition$3 */
    /* loaded from: classes.dex */
    public final class C01123 extends AnimatorListenerAdapter {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ C01123(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            switch (this.$r8$classId) {
                case 1:
                    ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.this$0;
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                    actionBarOverlayLayout.mAnimatingForFling = false;
                    return;
                case 2:
                    ((ViewPropertyAnimatorListener) this.this$0).onAnimationCancel();
                    return;
                default:
                    super.onAnimationCancel(animator);
                    return;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ViewOverlay viewOverlay;
            switch (this.$r8$classId) {
                case 0:
                    ((Transition) this.this$0).end();
                    animator.removeListener(this);
                    return;
                case 1:
                    ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.this$0;
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                    actionBarOverlayLayout.mAnimatingForFling = false;
                    return;
                case 2:
                    ((ViewPropertyAnimatorListener) this.this$0).onAnimationEnd();
                    return;
                case 3:
                    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = (AnimatedVectorDrawableCompat) this.this$0;
                    ArrayList arrayList = new ArrayList(animatedVectorDrawableCompat.mAnimationCallbacks);
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        ColorStateList colorStateList = MaterialCheckBox.this.buttonTintList;
                        if (colorStateList != null) {
                            animatedVectorDrawableCompat.setTintList(colorStateList);
                        }
                    }
                    return;
                case 4:
                    ((HideBottomViewOnScrollBehavior) this.this$0).currentAnimator = null;
                    return;
                case 5:
                    ((HideViewOnScrollBehavior) this.this$0).currentAnimator = null;
                    return;
                case 6:
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.this$0;
                    bottomSheetBehavior.setStateInternal(5);
                    WeakReference weakReference = bottomSheetBehavior.viewRef;
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((View) bottomSheetBehavior.viewRef.get()).requestLayout();
                        return;
                    }
                    return;
                case 7:
                    MaterialBottomContainerBackHelper materialBottomContainerBackHelper = (MaterialBottomContainerBackHelper) this.this$0;
                    materialBottomContainerBackHelper.view.setTranslationY(0.0f);
                    materialBottomContainerBackHelper.updateBackProgress(0.0f);
                    return;
                case 8:
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.this$0;
                    sideSheetBehavior.setStateInternal(5);
                    WeakReference weakReference2 = sideSheetBehavior.viewRef;
                    if (!(weakReference2 == null || weakReference2.get() == null)) {
                        ((View) sideSheetBehavior.viewRef.get()).requestLayout();
                        return;
                    }
                    return;
                case 9:
                    super.onAnimationEnd(animator);
                    BaseSlider baseSlider = (BaseSlider) this.this$0;
                    ViewGroup contentView = ViewUtils.getContentView(baseSlider);
                    if (contentView == null) {
                        viewOverlay = null;
                    } else {
                        viewOverlay = contentView.getOverlay();
                    }
                    if (viewOverlay != null) {
                        ArrayList arrayList2 = baseSlider.labels;
                        int size2 = arrayList2.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            Object obj = arrayList2.get(i2);
                            i2++;
                            viewOverlay.remove((TooltipDrawable) obj);
                        }
                        return;
                    }
                    return;
                case 10:
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.this$0;
                    dropdownMenuEndIconDelegate.refreshIconState();
                    dropdownMenuEndIconDelegate.fadeInAnim.start();
                    return;
                default:
                    ((ExpandableTransformationBehavior) this.this$0).currentAnimation = null;
                    return;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            switch (this.$r8$classId) {
                case 2:
                    ((ViewPropertyAnimatorListener) this.this$0).onAnimationStart();
                    return;
                case 3:
                    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = (AnimatedVectorDrawableCompat) this.this$0;
                    ArrayList arrayList = new ArrayList(animatedVectorDrawableCompat.mAnimationCallbacks);
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
                        ColorStateList colorStateList = materialCheckBox.buttonTintList;
                        if (colorStateList != null) {
                            animatedVectorDrawableCompat.setTint(colorStateList.getColorForState(materialCheckBox.currentStateChecked, colorStateList.getDefaultColor()));
                        }
                    }
                    return;
                default:
                    super.onAnimationStart(animator);
                    return;
            }
        }

        public C01123(ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            this.$r8$classId = 2;
            this.this$0 = viewPropertyAnimatorListener;
        }
    }

    /* loaded from: classes.dex */
    public final class AnimationInfo {
        public Animator mAnimator;
        public String mName;
        public Transition mTransition;
        public TransitionValues mValues;
        public View mView;
        public WindowId mWindowId;
    }

    /* loaded from: classes.dex */
    public abstract class Impl26 {
        public static long getTotalDuration(Animator animator) {
            return animator.getTotalDuration();
        }

        public static void setCurrentPlayTime(Animator animator, long j) {
            ((AnimatorSet) animator).setCurrentPlayTime(j);
        }
    }

    /* loaded from: classes.dex */
    public final class SeekController extends TransitionListenerAdapter {
        public long mCurrentPlayTime = -1;
        public boolean mIsCanceled;
        public boolean mIsReady;
        public RunnableC0058xf804c657 mResetToStartState;
        public SpringAnimation mSpringAnimation;
        public final HuffmanTreeGroup mVelocityTracker;
        public final /* synthetic */ TransitionSet this$0;

        /* JADX WARN: Type inference failed for: r5v1, types: [org.brotli.dec.HuffmanTreeGroup, java.lang.Object] */
        public SeekController(TransitionSet transitionSet) {
            this.this$0 = transitionSet;
            ?? obj = new Object();
            long[] jArr = new long[20];
            obj.codes = jArr;
            obj.trees = new float[20];
            obj.alphabetSize = 0;
            Arrays.fill(jArr, Long.MIN_VALUE);
            this.mVelocityTracker = obj;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [androidx.dynamicanimation.animation.FloatValueHolder, java.lang.Object] */
        public final void ensureAnimation() {
            int i;
            int i2;
            if (this.mSpringAnimation == null) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                HuffmanTreeGroup huffmanTreeGroup = this.mVelocityTracker;
                int i3 = huffmanTreeGroup.alphabetSize;
                float[] fArr = (float[]) huffmanTreeGroup.trees;
                long[] jArr = (long[]) huffmanTreeGroup.codes;
                int i4 = (i3 + 1) % 20;
                huffmanTreeGroup.alphabetSize = i4;
                jArr[i4] = currentAnimationTimeMillis;
                fArr[i4] = (float) this.mCurrentPlayTime;
                ?? obj = new Object();
                float f = 0.0f;
                obj.mValue = 0.0f;
                this.mSpringAnimation = new SpringAnimation(obj);
                SpringForce springForce = new SpringForce();
                springForce.setDampingRatio(1.0f);
                springForce.setStiffness(200.0f);
                SpringAnimation springAnimation = this.mSpringAnimation;
                springAnimation.mSpring = springForce;
                springAnimation.mValue = (float) this.mCurrentPlayTime;
                springAnimation.mStartValueIsSet = true;
                ArrayList arrayList = springAnimation.mUpdateListeners;
                if (!springAnimation.mRunning) {
                    if (!arrayList.contains(this)) {
                        arrayList.add(this);
                    }
                    SpringAnimation springAnimation2 = this.mSpringAnimation;
                    int i5 = huffmanTreeGroup.alphabetSize;
                    long j = Long.MIN_VALUE;
                    if (!(i5 == 0 && jArr[i5] == Long.MIN_VALUE)) {
                        long j2 = jArr[i5];
                        int i6 = 0;
                        long j3 = j2;
                        while (true) {
                            long j4 = jArr[i5];
                            if (j4 != j) {
                                float abs = (float) Math.abs(j4 - j3);
                                if (((float) (j2 - j4)) > 100.0f || abs > 40.0f) {
                                    break;
                                }
                                if (i5 == 0) {
                                    i5 = 20;
                                }
                                i5--;
                                i6++;
                                if (i6 >= 20) {
                                    break;
                                }
                                j3 = j4;
                                j = Long.MIN_VALUE;
                            } else {
                                break;
                            }
                        }
                        if (i6 >= 2) {
                            if (i6 == 2) {
                                int i7 = huffmanTreeGroup.alphabetSize;
                                if (i7 == 0) {
                                    i2 = 19;
                                } else {
                                    i2 = i7 - 1;
                                }
                                float f2 = (float) (jArr[i7] - jArr[i2]);
                                if (f2 != 0.0f) {
                                    f = ((fArr[i7] - fArr[i2]) / f2) * 1000.0f;
                                }
                            } else {
                                int i8 = huffmanTreeGroup.alphabetSize;
                                int i9 = ((i8 - i6) + 21) % 20;
                                int i10 = (i8 + 21) % 20;
                                long j5 = jArr[i9];
                                float f3 = fArr[i9];
                                int i11 = i9 + 1;
                                int i12 = i11 % 20;
                                float f4 = 0.0f;
                                while (i12 != i10) {
                                    long j6 = jArr[i12];
                                    float f5 = (float) (j6 - j5);
                                    if (f5 == f) {
                                        i = i11;
                                    } else {
                                        float f6 = fArr[i12];
                                        int i13 = i11;
                                        float f7 = (f6 - f3) / f5;
                                        float abs2 = (Math.abs(f7) * (f7 - ((float) (Math.sqrt(2.0f * Math.abs(f4)) * Math.signum(f4))))) + f4;
                                        i = i13;
                                        if (i12 == i) {
                                            abs2 *= 0.5f;
                                        }
                                        f4 = abs2;
                                        f3 = f6;
                                        j5 = j6;
                                    }
                                    i12 = (i12 + 1) % 20;
                                    i11 = i;
                                    f = 0.0f;
                                }
                                f = ((float) (Math.sqrt(Math.abs(f4) * 2.0f) * Math.signum(f4))) * 1000.0f;
                            }
                        }
                    }
                    springAnimation2.mVelocity = f;
                    SpringAnimation springAnimation3 = this.mSpringAnimation;
                    springAnimation3.mMaxValue = (float) (this.this$0.mTotalDuration + 1);
                    springAnimation3.mMinValue = -1.0f;
                    springAnimation3.mMinVisibleChange = 4.0f;
                    Transition$SeekController$$ExternalSyntheticLambda0 transition$SeekController$$ExternalSyntheticLambda0 = new Transition$SeekController$$ExternalSyntheticLambda0(this);
                    ArrayList arrayList2 = springAnimation3.mEndListeners;
                    if (!arrayList2.contains(transition$SeekController$$ExternalSyntheticLambda0)) {
                        arrayList2.add(transition$SeekController$$ExternalSyntheticLambda0);
                        return;
                    }
                    return;
                }
                throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionCancel(Transition transition) {
            this.mIsCanceled = true;
        }
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionEnd$1(Transition transition);

        void onTransitionPause();

        void onTransitionResume();

        void onTransitionStart(Transition transition);

        void onTransitionStart$1(Transition transition);
    }

    /* loaded from: classes.dex */
    public interface TransitionNotification {
        public static final BaseActivity$$ExternalSyntheticLambda0 ON_START = new BaseActivity$$ExternalSyntheticLambda0(15);
        public static final BaseActivity$$ExternalSyntheticLambda0 ON_END = new BaseActivity$$ExternalSyntheticLambda0(16);
        public static final BaseActivity$$ExternalSyntheticLambda0 ON_CANCEL = new BaseActivity$$ExternalSyntheticLambda0(17);
        public static final BaseActivity$$ExternalSyntheticLambda0 ON_PAUSE = new BaseActivity$$ExternalSyntheticLambda0(18);
        public static final BaseActivity$$ExternalSyntheticLambda0 ON_RESUME = new BaseActivity$$ExternalSyntheticLambda0(19);

        void notifyListener(TransitionListener transitionListener, Transition transition, boolean z);
    }

    public static void addViewValues(MetadataRepo metadataRepo, View view, TransitionValues transitionValues) {
        ArrayMap arrayMap = (ArrayMap) metadataRepo.mTypeface;
        SparseArray sparseArray = (SparseArray) metadataRepo.mEmojiCharArray;
        LongSparseArray longSparseArray = (LongSparseArray) metadataRepo.mRootNode;
        ((ArrayMap) metadataRepo.mMetadataList).put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        String transitionName = ViewCompat.Api21Impl.getTransitionName(view);
        if (transitionName != null) {
            if (arrayMap.containsKey(transitionName)) {
                arrayMap.put(transitionName, null);
            } else {
                arrayMap.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (longSparseArray.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = (View) longSparseArray.get(itemIdAtPosition);
                    if (view2 != null) {
                        view2.setHasTransientState(false);
                        longSparseArray.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                longSparseArray.put(itemIdAtPosition, view);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, androidx.collection.SimpleArrayMap, androidx.collection.ArrayMap] */
    public static ArrayMap getRunningAnimators() {
        ThreadLocal threadLocal = sRunningAnimators;
        ArrayMap arrayMap = (ArrayMap) threadLocal.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ?? simpleArrayMap = new SimpleArrayMap(0);
        threadLocal.set(simpleArrayMap);
        return simpleArrayMap;
    }

    public static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(transitionListener);
    }

    public void addTarget(View view) {
        this.mTargets.add(view);
    }

    public void cancel() {
        ArrayList arrayList = this.mCurrentAnimators;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.mAnimatorCache = animatorArr;
        notifyFromTransition(this, TransitionNotification.ON_CANCEL, false);
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public final void captureHierarchy(View view, boolean z) {
        if (view != null) {
            view.getId();
            if (view.getParent() instanceof ViewGroup) {
                TransitionValues transitionValues = new TransitionValues(view);
                if (z) {
                    captureStartValues(transitionValues);
                } else {
                    captureEndValues(transitionValues);
                }
                transitionValues.mTargetedTransitions.add(this);
                capturePropagationValues(transitionValues);
                if (z) {
                    addViewValues(this.mStartValues, view, transitionValues);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    captureHierarchy(viewGroup.getChildAt(i), z);
                }
            }
        }
    }

    public void capturePropagationValues(TransitionValues transitionValues) {
    }

    public abstract void captureStartValues(TransitionValues transitionValues);

    public final void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        ArrayList arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList arrayList2 = this.mTargets;
        if (size > 0 || arrayList2.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                View view = (View) arrayList2.get(i2);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.mTargetedTransitions.add(this);
                capturePropagationValues(transitionValues2);
                if (z) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
            return;
        }
        captureHierarchy(viewGroup, z);
    }

    public final void clearValues(boolean z) {
        if (z) {
            ((ArrayMap) this.mStartValues.mMetadataList).clear();
            ((SparseArray) this.mStartValues.mEmojiCharArray).clear();
            ((LongSparseArray) this.mStartValues.mRootNode).clear();
            return;
        }
        ((ArrayMap) this.mEndValues.mMetadataList).clear();
        ((SparseArray) this.mEndValues.mEmojiCharArray).clear();
        ((LongSparseArray) this.mEndValues.mRootNode).clear();
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [androidx.transition.Transition$AnimationInfo, java.lang.Object] */
    public void createAnimators(ViewGroup viewGroup, MetadataRepo metadataRepo, MetadataRepo metadataRepo2, ArrayList arrayList, ArrayList arrayList2) {
        boolean z;
        boolean z2;
        int i;
        TransitionValues transitionValues;
        View view;
        TransitionValues transitionValues2;
        Animator animator;
        ArrayMap runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        if (getRootTransition().mSeekController != null) {
            z = true;
        } else {
            z = false;
        }
        int i2 = 0;
        while (i2 < size) {
            TransitionValues transitionValues3 = (TransitionValues) arrayList.get(i2);
            TransitionValues transitionValues4 = (TransitionValues) arrayList2.get(i2);
            if (transitionValues3 != null && !transitionValues3.mTargetedTransitions.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.mTargetedTransitions.contains(this)) {
                transitionValues4 = null;
            }
            if (!(transitionValues3 == null && transitionValues4 == null) && (transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4))) {
                Animator createAnimator = createAnimator(viewGroup, transitionValues3, transitionValues4);
                if (createAnimator != null) {
                    String str = this.mName;
                    if (transitionValues4 != null) {
                        view = transitionValues4.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues2 = new TransitionValues(view);
                            TransitionValues transitionValues5 = (TransitionValues) ((ArrayMap) metadataRepo2.mMetadataList).get(view);
                            i = size;
                            z2 = z;
                            if (transitionValues5 != null) {
                                int i3 = 0;
                                while (i3 < transitionProperties.length) {
                                    String str2 = transitionProperties[i3];
                                    int i4 = i3;
                                    transitionValues2.values.put(str2, transitionValues5.values.get(str2));
                                    i3 = i4 + 1;
                                }
                            }
                            int i5 = runningAnimators.size;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= i5) {
                                    animator = createAnimator;
                                    break;
                                }
                                AnimationInfo animationInfo = (AnimationInfo) runningAnimators.get((Animator) runningAnimators.keyAt(i6));
                                if (animationInfo.mValues != null && animationInfo.mView == view && animationInfo.mName.equals(str) && animationInfo.mValues.equals(transitionValues2)) {
                                    animator = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i = size;
                            z2 = z;
                            animator = createAnimator;
                            transitionValues2 = null;
                        }
                        createAnimator = animator;
                        transitionValues = transitionValues2;
                    } else {
                        i = size;
                        z2 = z;
                        view = transitionValues3.view;
                        transitionValues = null;
                    }
                    if (createAnimator != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        ?? obj = new Object();
                        obj.mView = view;
                        obj.mName = str;
                        obj.mValues = transitionValues;
                        obj.mWindowId = windowId;
                        obj.mTransition = this;
                        obj.mAnimator = createAnimator;
                        AnimatorSet animatorSet = createAnimator;
                        if (z2) {
                            AnimatorSet animatorSet2 = new AnimatorSet();
                            animatorSet2.play(createAnimator);
                            animatorSet = animatorSet2;
                        }
                        runningAnimators.put(animatorSet, obj);
                        this.mAnimators.add(animatorSet);
                    }
                    i2++;
                    size = i;
                    z = z2;
                }
            }
            i = size;
            z2 = z;
            i2++;
            size = i;
            z = z2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                AnimationInfo animationInfo2 = (AnimationInfo) runningAnimators.get((Animator) this.mAnimators.get(sparseIntArray.keyAt(i7)));
                long startDelay = animationInfo2.mAnimator.getStartDelay();
                animationInfo2.mAnimator.setStartDelay(startDelay + (sparseIntArray.valueAt(i7) - Long.MAX_VALUE));
            }
        }
    }

    public final void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i == 0) {
            notifyFromTransition(this, TransitionNotification.ON_END, false);
            for (int i2 = 0; i2 < ((LongSparseArray) this.mStartValues.mRootNode).size(); i2++) {
                View view = (View) ((LongSparseArray) this.mStartValues.mRootNode).valueAt(i2);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < ((LongSparseArray) this.mEndValues.mRootNode).size(); i3++) {
                View view2 = (View) ((LongSparseArray) this.mEndValues.mRootNode).valueAt(i3);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.mEnded = true;
        }
    }

    public final TransitionValues getMatchedTransitionValues(View view, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
        if (z) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            TransitionValues transitionValues = (TransitionValues) arrayList.get(i);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == view) {
                break;
            }
            i++;
        }
        if (i < 0) {
            return null;
        }
        if (z) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return (TransitionValues) arrayList2.get(i);
    }

    public final Transition getRootTransition() {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getRootTransition();
        }
        return this;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public final TransitionValues getTransitionValues(View view, boolean z) {
        MetadataRepo metadataRepo;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        if (z) {
            metadataRepo = this.mStartValues;
        } else {
            metadataRepo = this.mEndValues;
        }
        return (TransitionValues) ((ArrayMap) metadataRepo.mMetadataList).get(view);
    }

    public boolean hasAnimators() {
        return !this.mCurrentAnimators.isEmpty();
    }

    public abstract boolean isSeekingSupported();

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (!(transitionValues == null || transitionValues2 == null)) {
            String[] transitionProperties = getTransitionProperties();
            if (transitionProperties != null) {
                for (String str : transitionProperties) {
                    if (isValueChanged(transitionValues, transitionValues2, str)) {
                        return true;
                    }
                }
            } else {
                for (String str2 : transitionValues.values.keySet()) {
                    if (isValueChanged(transitionValues, transitionValues2, str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean isValidTarget(View view) {
        int id = view.getId();
        ArrayList arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList arrayList2 = this.mTargets;
        if ((size != 0 || arrayList2.size() != 0) && !arrayList.contains(Integer.valueOf(id)) && !arrayList2.contains(view)) {
            return false;
        }
        return true;
    }

    public final void notifyFromTransition(Transition transition, TransitionNotification transitionNotification, boolean z) {
        Transition transition2 = this.mCloneParent;
        if (transition2 != null) {
            transition2.notifyFromTransition(transition, transitionNotification, z);
        }
        ArrayList arrayList = this.mListeners;
        if (!(arrayList == null || arrayList.isEmpty())) {
            int size = this.mListeners.size();
            TransitionListener[] transitionListenerArr = this.mListenersCache;
            if (transitionListenerArr == null) {
                transitionListenerArr = new TransitionListener[size];
            }
            this.mListenersCache = null;
            TransitionListener[] transitionListenerArr2 = (TransitionListener[]) this.mListeners.toArray(transitionListenerArr);
            for (int i = 0; i < size; i++) {
                transitionNotification.notifyListener(transitionListenerArr2[i], transition, z);
                transitionListenerArr2[i] = null;
            }
            this.mListenersCache = transitionListenerArr2;
        }
    }

    public void pause(View view) {
        if (!this.mEnded) {
            ArrayList arrayList = this.mCurrentAnimators;
            int size = arrayList.size();
            Animator[] animatorArr = (Animator[]) arrayList.toArray(this.mAnimatorCache);
            this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
            for (int i = size - 1; i >= 0; i--) {
                Animator animator = animatorArr[i];
                animatorArr[i] = null;
                animator.pause();
            }
            this.mAnimatorCache = animatorArr;
            notifyFromTransition(this, TransitionNotification.ON_PAUSE, false);
            this.mPaused = true;
        }
    }

    public void prepareAnimatorsForSeeking() {
        ArrayMap runningAnimators = getRunningAnimators();
        this.mTotalDuration = 0L;
        for (int i = 0; i < this.mAnimators.size(); i++) {
            Animator animator = (Animator) this.mAnimators.get(i);
            AnimationInfo animationInfo = (AnimationInfo) runningAnimators.get(animator);
            if (!(animator == null || animationInfo == null)) {
                Animator animator2 = animationInfo.mAnimator;
                long j = this.mDuration;
                if (j >= 0) {
                    animator2.setDuration(j);
                }
                long j2 = this.mStartDelay;
                if (j2 >= 0) {
                    animator2.setStartDelay(animator2.getStartDelay() + j2);
                }
                TimeInterpolator timeInterpolator = this.mInterpolator;
                if (timeInterpolator != null) {
                    animator2.setInterpolator(timeInterpolator);
                }
                this.mCurrentAnimators.add(animator);
                this.mTotalDuration = Math.max(this.mTotalDuration, Impl26.getTotalDuration(animator));
            }
        }
        this.mAnimators.clear();
    }

    public Transition removeListener(TransitionListener transitionListener) {
        Transition transition;
        ArrayList arrayList = this.mListeners;
        if (arrayList != null) {
            if (!arrayList.remove(transitionListener) && (transition = this.mCloneParent) != null) {
                transition.removeListener(transitionListener);
            }
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
        }
        return this;
    }

    public void removeTarget(View view) {
        this.mTargets.remove(view);
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayList arrayList = this.mCurrentAnimators;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.mAnimatorCache);
                this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.mAnimatorCache = animatorArr;
                notifyFromTransition(this, TransitionNotification.ON_RESUME, false);
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        ArrayMap runningAnimators = getRunningAnimators();
        ArrayList arrayList = this.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Animator animator = (Animator) obj;
            if (runningAnimators.containsKey(animator)) {
                start();
                if (animator != null) {
                    animator.addListener(new C01112(this, runningAnimators));
                    long j = this.mDuration;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.mStartDelay;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.mInterpolator;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new C01123(0, this));
                    animator.start();
                }
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCurrentPlayTimeMillis(long j, long j2) {
        boolean z;
        long j3 = this.mTotalDuration;
        int i = 0;
        if (j < j2) {
            z = true;
        } else {
            z = false;
        }
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if ((i2 < 0 && j >= 0) || (j2 > j3 && j <= j3)) {
            this.mEnded = false;
            notifyFromTransition(this, TransitionNotification.ON_START, z);
        }
        ArrayList arrayList = this.mCurrentAnimators;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        while (i < size) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            Impl26.setCurrentPlayTime(animator, Math.min(Math.max(0L, j), Impl26.getTotalDuration(animator)));
            i++;
            z = z;
        }
        boolean z2 = z;
        this.mAnimatorCache = animatorArr;
        int i3 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
        if ((i3 > 0 && j2 <= j3) || (j < 0 && i2 >= 0)) {
            if (i3 > 0) {
                this.mEnded = true;
            }
            notifyFromTransition(this, TransitionNotification.ON_END, z2);
        }
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setEpicenterCallback(Navigation navigation) {
        this.mEpicenterCallback = navigation;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
    }

    public void setPathMotion(C01101 r1) {
        if (r1 == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = r1;
        }
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public final void start() {
        if (this.mNumInstances == 0) {
            notifyFromTransition(this, TransitionNotification.ON_START, false);
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public final String toString() {
        return toString("");
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList();
            transition.mStartValues = new MetadataRepo(4);
            transition.mEndValues = new MetadataRepo(4);
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            transition.mSeekController = null;
            transition.mCloneParent = this;
            transition.mListeners = null;
            return transition;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.mDuration != -1) {
            sb.append("dur(");
            sb.append(this.mDuration);
            sb.append(") ");
        }
        if (this.mStartDelay != -1) {
            sb.append("dly(");
            sb.append(this.mStartDelay);
            sb.append(") ");
        }
        if (this.mInterpolator != null) {
            sb.append("interp(");
            sb.append(this.mInterpolator);
            sb.append(") ");
        }
        ArrayList arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList arrayList2 = this.mTargets;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void setPropagation() {
    }
}
