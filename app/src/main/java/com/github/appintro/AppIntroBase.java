package com.github.appintro;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.github.appintro.indicator.DotIndicatorController;
import com.github.appintro.indicator.IndicatorController;
import com.github.appintro.indicator.ProgressIndicatorController;
import com.github.appintro.internal.AppIntroViewPager;
import com.github.appintro.internal.LayoutUtil;
import com.github.appintro.internal.LogHelper;
import com.github.appintro.internal.PermissionWrapper;
import com.github.appintro.internal.viewpager.PagerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class AppIntroBase extends AppCompatActivity implements AppIntroViewPagerListener {
    @Deprecated
    private static final String ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED = "colorTransitionEnabled";
    @Deprecated
    private static final String ARG_BUNDLE_CURRENT_ITEM = "currentItem";
    @Deprecated
    private static final String ARG_BUNDLE_IS_BUTTONS_ENABLED = "isButtonsEnabled";
    @Deprecated
    private static final String ARG_BUNDLE_IS_FULL_PAGING_ENABLED = "isFullPagingEnabled";
    @Deprecated
    private static final String ARG_BUNDLE_IS_INDICATOR_ENABLED = "isIndicatorEnabled";
    @Deprecated
    private static final String ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED = "isSkipButtonsEnabled";
    @Deprecated
    private static final String ARG_BUNDLE_PERMISSION_MAP = "permissionMap";
    @Deprecated
    private static final String ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED = "retainIsButtonsEnabled";
    @Deprecated
    private static final String ARG_BUNDLE_SLIDES_NUMBER = "slidesNumber";
    @Deprecated
    private static final int DEFAULT_SCROLL_DURATION_FACTOR = 1;
    @Deprecated
    private static final long DEFAULT_VIBRATE_DURATION = 20;
    @Deprecated
    private static final int PERMISSIONS_REQUEST_ALL_PERMISSIONS = 1;
    private View backButton;
    private View doneButton;
    private ViewGroup indicatorContainer;
    private IndicatorController indicatorController;
    private boolean isColorTransitionsEnabled;
    private boolean isSystemBackButtonLocked;
    private boolean isVibrate;
    private boolean isWizardMode;
    private View nextButton;
    private AppIntroViewPager pager;
    private PagerAdapter pagerAdapter;
    private int savedCurrentItem;
    private View skipButton;
    private int slidesNumber;
    private Vibrator vibrator;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final String TAG = LogHelper.makeLogTag(AppIntroBase.class);
    private boolean isButtonsEnabled = true;
    private boolean isSkipButtonEnabled = true;
    private boolean isIndicatorEnabled = true;
    private long vibrateDuration = DEFAULT_VIBRATE_DURATION;
    private int currentlySelectedItem = -1;
    private final List<Fragment> fragments = new ArrayList();
    private HashMap<Integer, PermissionWrapper> permissionsMap = new HashMap<>();
    private boolean retainIsButtonsEnabled = true;
    private final ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public final class NextSlideOnClickListener implements View.OnClickListener {
        private boolean isLastSlide;
        final /* synthetic */ AppIntroBase this$0;

        public NextSlideOnClickListener(AppIntroBase this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.isLastSlide = z;
        }

        public final boolean isLastSlide() {
            return this.isLastSlide;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0.dispatchVibration();
            if (!this.this$0.onCanRequestNextPage()) {
                this.this$0.onIllegallyRequestedNextPage();
            } else if (this.this$0.shouldRequestPermission()) {
                this.this$0.requestPermissions();
            } else {
                PagerAdapter pagerAdapter = this.this$0.pagerAdapter;
                if (pagerAdapter != null) {
                    AppIntroViewPager appIntroViewPager = this.this$0.pager;
                    if (appIntroViewPager != null) {
                        Fragment item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
                        if (this.isLastSlide) {
                            this.this$0.onDonePressed(item);
                        } else {
                            this.this$0.onNextPressed(item);
                        }
                        this.this$0.goToNextSlide(this.isLastSlide);
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("pager");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                throw null;
            }
        }

        public final void setLastSlide(boolean z) {
            this.isLastSlide = z;
        }
    }

    /* loaded from: classes.dex */
    public final class OnPageChangeListener implements ViewPager.OnPageChangeListener {
        final /* synthetic */ AppIntroBase this$0;

        public OnPageChangeListener(AppIntroBase this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (this.this$0.isColorTransitionsEnabled()) {
                PagerAdapter pagerAdapter = this.this$0.pagerAdapter;
                if (pagerAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                    throw null;
                } else if (i < pagerAdapter.getCount() - 1) {
                    PagerAdapter pagerAdapter2 = this.this$0.pagerAdapter;
                    if (pagerAdapter2 != null) {
                        Fragment item = pagerAdapter2.getItem(i);
                        PagerAdapter pagerAdapter3 = this.this$0.pagerAdapter;
                        if (pagerAdapter3 != null) {
                            this.this$0.performColorTransition(item, pagerAdapter3.getItem(i + 1), f);
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                    throw null;
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IndicatorController indicatorController;
            if (this.this$0.slidesNumber >= 1 && (indicatorController = this.this$0.getIndicatorController()) != null) {
                indicatorController.selectPosition(i);
            }
            this.this$0.updateButtonsVisibility();
            AppIntroViewPager appIntroViewPager = this.this$0.pager;
            if (appIntroViewPager != null) {
                appIntroViewPager.setPermissionSlide(this.this$0.isPermissionSlide());
                this.this$0.onPageSelected(i);
                if (this.this$0.slidesNumber > 0) {
                    if (this.this$0.currentlySelectedItem == -1) {
                        AppIntroBase appIntroBase = this.this$0;
                        PagerAdapter pagerAdapter = appIntroBase.pagerAdapter;
                        if (pagerAdapter != null) {
                            appIntroBase.dispatchSlideChangedCallbacks(null, pagerAdapter.getItem(i));
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                            throw null;
                        }
                    } else {
                        AppIntroBase appIntroBase2 = this.this$0;
                        PagerAdapter pagerAdapter2 = appIntroBase2.pagerAdapter;
                        if (pagerAdapter2 != null) {
                            Fragment item = pagerAdapter2.getItem(this.this$0.currentlySelectedItem);
                            PagerAdapter pagerAdapter3 = this.this$0.pagerAdapter;
                            if (pagerAdapter3 != null) {
                                AppIntroViewPager appIntroViewPager2 = this.this$0.pager;
                                if (appIntroViewPager2 != null) {
                                    appIntroBase2.dispatchSlideChangedCallbacks(item, pagerAdapter3.getItem(appIntroViewPager2.getCurrentItem()));
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("pager");
                                    throw null;
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                            throw null;
                        }
                    }
                }
                this.this$0.currentlySelectedItem = i;
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
    }

    /* renamed from: $r8$lambda$NWNhR1g9TmE6D3q_-J_pOxL4MlU */
    public static /* synthetic */ void m244$r8$lambda$NWNhR1g9TmE6D3q_J_pOxL4MlU(AppIntroBase appIntroBase) {
        m248onPostCreate$lambda2(appIntroBase);
    }

    public static /* synthetic */ void askForPermissions$default(AppIntroBase appIntroBase, String[] strArr, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z = true;
            }
            appIntroBase.askForPermissions(strArr, i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: askForPermissions");
    }

    public final void dispatchSlideChangedCallbacks(Fragment fragment, Fragment fragment2) {
        if (fragment instanceof SlideSelectionListener) {
            ((SlideSelectionListener) fragment).onSlideDeselected();
        }
        if (fragment2 instanceof SlideSelectionListener) {
            ((SlideSelectionListener) fragment2).onSlideSelected();
        }
        onSlideChanged(fragment, fragment2);
    }

    @SuppressLint({"MissingPermission"})
    public final void dispatchVibration() {
        if (this.isVibrate) {
            Vibrator vibrator = this.vibrator;
            if (vibrator != null) {
                vibrator.vibrate(this.vibrateDuration);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("vibrator");
                throw null;
            }
        }
    }

    private final int getCurrentSlideNumber() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            return appIntroViewPager.getCurrentSlideNumber(this.fragments.size());
        }
        Intrinsics.throwUninitializedPropertyAccessException("pager");
        throw null;
    }

    private final int getSlideColor(SlideBackgroundColorHolder slideBackgroundColorHolder) {
        if (slideBackgroundColorHolder.getDefaultBackgroundColorRes() != 0) {
            return BundleKt.getColor(this, slideBackgroundColorHolder.getDefaultBackgroundColorRes());
        }
        return slideBackgroundColorHolder.getDefaultBackgroundColor();
    }

    public static /* synthetic */ void goToNextSlide$default(AppIntroBase appIntroBase, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                AppIntroViewPager appIntroViewPager = appIntroBase.pager;
                if (appIntroViewPager != null) {
                    z = appIntroViewPager.isLastSlide(appIntroBase.fragments.size());
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("pager");
                    throw null;
                }
            }
            appIntroBase.goToNextSlide(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goToNextSlide");
    }

    private final void handleDeniedPermission(String str) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
            onUserDeniedPermission(str);
            PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
            if (permissionWrapper != null && !permissionWrapper.getRequired()) {
                this.permissionsMap.remove(Integer.valueOf(permissionWrapper.getPosition()));
                goToNextSlide$default(this, false, 1, null);
                return;
            }
            return;
        }
        onUserDisabledPermission(str);
    }

    private final void initializeIndicator() {
        ViewGroup viewGroup = this.indicatorContainer;
        View view = null;
        if (viewGroup != null) {
            IndicatorController indicatorController = this.indicatorController;
            if (indicatorController != null) {
                view = indicatorController.newInstance(this);
            }
            viewGroup.addView(view);
            IndicatorController indicatorController2 = this.indicatorController;
            if (indicatorController2 != null) {
                indicatorController2.initialize(this.slidesNumber);
            }
            IndicatorController indicatorController3 = this.indicatorController;
            if (indicatorController3 != null) {
                indicatorController3.selectPosition(this.currentlySelectedItem);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("indicatorContainer");
        throw null;
    }

    public final boolean isPermissionSlide() {
        HashMap<Integer, PermissionWrapper> hashMap = this.permissionsMap;
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            return hashMap.containsKey(Integer.valueOf(appIntroViewPager.getCurrentSlideNumber(this.fragments.size())));
        }
        Intrinsics.throwUninitializedPropertyAccessException("pager");
        throw null;
    }

    /* renamed from: onCreate$lambda-0 */
    public static final void m246onCreate$lambda0(AppIntroBase this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppIntroViewPager appIntroViewPager = this$0.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.goToPreviousSlide();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
    }

    /* renamed from: onCreate$lambda-1 */
    public static final void m247onCreate$lambda1(AppIntroBase this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dispatchVibration();
        PagerAdapter pagerAdapter = this$0.pagerAdapter;
        if (pagerAdapter != null) {
            AppIntroViewPager appIntroViewPager = this$0.pager;
            if (appIntroViewPager != null) {
                this$0.onSkipPressed(pagerAdapter.getItem(appIntroViewPager.getCurrentItem()));
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            throw null;
        }
    }

    /* renamed from: onPostCreate$lambda-2 */
    public static final void m248onPostCreate$lambda2(AppIntroBase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PagerAdapter pagerAdapter = this$0.pagerAdapter;
        if (pagerAdapter != null) {
            AppIntroViewPager appIntroViewPager = this$0.pager;
            if (appIntroViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            } else if (pagerAdapter.getItem(appIntroViewPager.getCurrentItem()) != null) {
                PagerAdapter pagerAdapter2 = this$0.pagerAdapter;
                if (pagerAdapter2 != null) {
                    AppIntroViewPager appIntroViewPager2 = this$0.pager;
                    if (appIntroViewPager2 != null) {
                        this$0.dispatchSlideChangedCallbacks(null, pagerAdapter2.getItem(appIntroViewPager2.getCurrentItem()));
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("pager");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                    throw null;
                }
            } else {
                this$0.finish();
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            throw null;
        }
    }

    public final void performColorTransition(Fragment fragment, Fragment fragment2, float f) {
        if (!(fragment instanceof SlideBackgroundColorHolder) || !(fragment2 instanceof SlideBackgroundColorHolder)) {
            throw new IllegalStateException("Color transitions are only available if all slides implement SlideBackgroundColorHolder.");
        } else if (fragment.isAdded() && fragment2.isAdded()) {
            SlideBackgroundColorHolder slideBackgroundColorHolder = (SlideBackgroundColorHolder) fragment;
            SlideBackgroundColorHolder slideBackgroundColorHolder2 = (SlideBackgroundColorHolder) fragment2;
            Object evaluate = this.argbEvaluator.evaluate(f, Integer.valueOf(getSlideColor(slideBackgroundColorHolder)), Integer.valueOf(getSlideColor(slideBackgroundColorHolder2)));
            if (evaluate != null) {
                int intValue = ((Integer) evaluate).intValue();
                slideBackgroundColorHolder.setBackgroundColor(intValue);
                slideBackgroundColorHolder2.setBackgroundColor(intValue);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public final void requestPermissions() {
        setSwipeLock(true);
        PermissionWrapper permissionWrapper = this.permissionsMap.get(Integer.valueOf(getCurrentSlideNumber()));
        if (permissionWrapper != null) {
            ActivityCompat.requestPermissions(this, permissionWrapper.getPermissions(), 1);
        }
    }

    public final boolean shouldRequestPermission() {
        return this.permissionsMap.containsKey(Integer.valueOf(getCurrentSlideNumber()));
    }

    public final void updateButtonsVisibility() {
        boolean z;
        boolean z2 = false;
        if (this.isButtonsEnabled) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager != null) {
                boolean isLastSlide = appIntroViewPager.isLastSlide(this.fragments.size());
                AppIntroViewPager appIntroViewPager2 = this.pager;
                if (appIntroViewPager2 != null) {
                    boolean isFirstSlide = appIntroViewPager2.isFirstSlide(this.fragments.size());
                    View view = this.nextButton;
                    if (view != null) {
                        AppIntroBaseKt.setVisible(view, !isLastSlide);
                        View view2 = this.doneButton;
                        if (view2 != null) {
                            AppIntroBaseKt.setVisible(view2, isLastSlide);
                            View view3 = this.skipButton;
                            if (view3 != null) {
                                if (!this.isSkipButtonEnabled || isLastSlide) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                AppIntroBaseKt.setVisible(view3, z);
                                View view4 = this.backButton;
                                if (view4 != null) {
                                    if (this.isWizardMode && !isFirstSlide) {
                                        z2 = true;
                                    }
                                    AppIntroBaseKt.setVisible(view4, z2);
                                    return;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("backButton");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("doneButton");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("nextButton");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
        View view5 = this.nextButton;
        if (view5 != null) {
            AppIntroBaseKt.setVisible(view5, false);
            View view6 = this.doneButton;
            if (view6 != null) {
                AppIntroBaseKt.setVisible(view6, false);
                View view7 = this.backButton;
                if (view7 != null) {
                    AppIntroBaseKt.setVisible(view7, false);
                    View view8 = this.skipButton;
                    if (view8 != null) {
                        AppIntroBaseKt.setVisible(view8, false);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("skipButton");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("backButton");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("doneButton");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            throw null;
        }
    }

    public final void addSlide(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (isRtl$appintro_release()) {
            this.fragments.add(0, fragment);
        } else {
            this.fragments.add(fragment);
        }
        if (this.isWizardMode) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager != null) {
                appIntroViewPager.setOffscreenPageLimit(this.fragments.size());
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            }
        }
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.notifyDataSetChanged();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            throw null;
        }
    }

    public final void askForPermissions(String[] permissions, int i) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        askForPermissions$default(this, permissions, i, false, 4, null);
    }

    public final IndicatorController getIndicatorController() {
        return this.indicatorController;
    }

    public abstract int getLayoutId();

    public final int getTotalSlidesNumber() {
        return this.slidesNumber;
    }

    public final long getVibrateDuration() {
        return this.vibrateDuration;
    }

    public final void goToNextSlide() {
        goToNextSlide$default(this, false, 1, null);
    }

    public final void goToPreviousSlide() {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.goToPreviousSlide();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
    }

    public final boolean isButtonsEnabled() {
        return this.isButtonsEnabled;
    }

    public final boolean isColorTransitionsEnabled() {
        return this.isColorTransitionsEnabled;
    }

    public final boolean isIndicatorEnabled() {
        return this.isIndicatorEnabled;
    }

    public final boolean isRtl$appintro_release() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        return LayoutUtil.isRtl(applicationContext);
    }

    public final boolean isSkipButtonEnabled() {
        return this.isSkipButtonEnabled;
    }

    public final boolean isSystemBackButtonLocked() {
        return this.isSystemBackButtonLocked;
    }

    public final boolean isVibrate() {
        return this.isVibrate;
    }

    public final boolean isWizardMode() {
        return this.isWizardMode;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.isSystemBackButtonLocked) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            } else if (appIntroViewPager.isFirstSlide(this.fragments.size())) {
                super.onBackPressed();
            } else {
                AppIntroViewPager appIntroViewPager2 = this.pager;
                if (appIntroViewPager2 != null) {
                    appIntroViewPager2.goToPreviousSlide();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("pager");
                    throw null;
                }
            }
        }
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public boolean onCanRequestNextPage() {
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager != null) {
                Fragment item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
                if (!(item instanceof SlidePolicy) || ((SlidePolicy) item).isPolicyRespected()) {
                    LogHelper.d(TAG, "Change request will be allowed.");
                    return true;
                }
                LogHelper.d(TAG, "Slide policy not respected, denying change request.");
                return false;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        throw null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        AppCompatDelegate.SerialExecutor serialExecutor = AppCompatDelegate.sSerialExecutorForLocalesStorage;
        int i = VectorEnabledTintResources.$r8$clinit;
        super.onCreate(bundle);
        this.indicatorController = new DotIndicatorController(this);
        showStatusBar(false);
        setContentView(getLayoutId());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.indicator_container);
        if (viewGroup != null) {
            this.indicatorContainer = viewGroup;
            View findViewById = findViewById(R.id.next);
            if (findViewById != null) {
                this.nextButton = findViewById;
                View findViewById2 = findViewById(R.id.done);
                if (findViewById2 != null) {
                    this.doneButton = findViewById2;
                    View findViewById3 = findViewById(R.id.skip);
                    if (findViewById3 != null) {
                        this.skipButton = findViewById3;
                        View findViewById4 = findViewById(R.id.back);
                        if (findViewById4 != null) {
                            this.backButton = findViewById4;
                            View view = this.nextButton;
                            if (view != null) {
                                BundleKt.setTooltipText(view, getString(R.string.app_intro_next_button));
                                View view2 = this.skipButton;
                                if (view2 != null) {
                                    if (view2 instanceof ImageButton) {
                                        BundleKt.setTooltipText(view2, getString(R.string.app_intro_skip_button));
                                    }
                                    View view3 = this.doneButton;
                                    if (view3 != null) {
                                        if (view3 instanceof ImageButton) {
                                            BundleKt.setTooltipText(view3, getString(R.string.app_intro_done_button));
                                        }
                                        View view4 = this.backButton;
                                        if (view4 != null) {
                                            if (view4 instanceof ImageButton) {
                                                BundleKt.setTooltipText(view4, getString(R.string.app_intro_back_button));
                                            }
                                            if (isRtl$appintro_release()) {
                                                View view5 = this.nextButton;
                                                if (view5 != null) {
                                                    view5.setScaleX(-1.0f);
                                                    View view6 = this.backButton;
                                                    if (view6 != null) {
                                                        view6.setScaleX(-1.0f);
                                                    } else {
                                                        Intrinsics.throwUninitializedPropertyAccessException("backButton");
                                                        throw null;
                                                    }
                                                } else {
                                                    Intrinsics.throwUninitializedPropertyAccessException("nextButton");
                                                    throw null;
                                                }
                                            }
                                            Object systemService = getSystemService("vibrator");
                                            if (systemService != null) {
                                                this.vibrator = (Vibrator) systemService;
                                                FragmentManager supportFragmentManager = getSupportFragmentManager();
                                                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                                                this.pagerAdapter = new PagerAdapter(supportFragmentManager, this.fragments);
                                                View findViewById5 = findViewById(R.id.view_pager);
                                                Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.view_pager)");
                                                this.pager = (AppIntroViewPager) findViewById5;
                                                View view7 = this.doneButton;
                                                if (view7 != null) {
                                                    view7.setOnClickListener(new NextSlideOnClickListener(this, true));
                                                    View view8 = this.nextButton;
                                                    if (view8 != null) {
                                                        view8.setOnClickListener(new NextSlideOnClickListener(this, false));
                                                        View view9 = this.backButton;
                                                        if (view9 != null) {
                                                            view9.setOnClickListener(new View.OnClickListener(this) { // from class: com.github.appintro.AppIntroBase$$ExternalSyntheticLambda0
                                                                public final /* synthetic */ AppIntroBase f$0;

                                                                {
                                                                    this.f$0 = this;
                                                                }

                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view10) {
                                                                    switch (r2) {
                                                                        case 0:
                                                                            AppIntroBase.m246onCreate$lambda0(this.f$0, view10);
                                                                            return;
                                                                        default:
                                                                            AppIntroBase.m247onCreate$lambda1(this.f$0, view10);
                                                                            return;
                                                                    }
                                                                }
                                                            });
                                                            View view10 = this.skipButton;
                                                            if (view10 != null) {
                                                                view10.setOnClickListener(new View.OnClickListener(this) { // from class: com.github.appintro.AppIntroBase$$ExternalSyntheticLambda0
                                                                    public final /* synthetic */ AppIntroBase f$0;

                                                                    {
                                                                        this.f$0 = this;
                                                                    }

                                                                    @Override // android.view.View.OnClickListener
                                                                    public final void onClick(View view102) {
                                                                        switch (r2) {
                                                                            case 0:
                                                                                AppIntroBase.m246onCreate$lambda0(this.f$0, view102);
                                                                                return;
                                                                            default:
                                                                                AppIntroBase.m247onCreate$lambda1(this.f$0, view102);
                                                                                return;
                                                                        }
                                                                    }
                                                                });
                                                                AppIntroViewPager appIntroViewPager = this.pager;
                                                                if (appIntroViewPager != null) {
                                                                    PagerAdapter pagerAdapter = this.pagerAdapter;
                                                                    if (pagerAdapter != null) {
                                                                        appIntroViewPager.setAdapter(pagerAdapter);
                                                                        AppIntroViewPager appIntroViewPager2 = this.pager;
                                                                        if (appIntroViewPager2 != null) {
                                                                            appIntroViewPager2.addOnPageChangeListener$appintro_release(new OnPageChangeListener(this));
                                                                            AppIntroViewPager appIntroViewPager3 = this.pager;
                                                                            if (appIntroViewPager3 != null) {
                                                                                appIntroViewPager3.setOnNextPageRequestedListener(this);
                                                                                setScrollDurationFactor(1);
                                                                                return;
                                                                            }
                                                                            Intrinsics.throwUninitializedPropertyAccessException("pager");
                                                                            throw null;
                                                                        }
                                                                        Intrinsics.throwUninitializedPropertyAccessException("pager");
                                                                        throw null;
                                                                    }
                                                                    Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                                                                    throw null;
                                                                }
                                                                Intrinsics.throwUninitializedPropertyAccessException("pager");
                                                                throw null;
                                                            }
                                                            Intrinsics.throwUninitializedPropertyAccessException("skipButton");
                                                            throw null;
                                                        }
                                                        Intrinsics.throwUninitializedPropertyAccessException("backButton");
                                                        throw null;
                                                    }
                                                    Intrinsics.throwUninitializedPropertyAccessException("nextButton");
                                                    throw null;
                                                }
                                                Intrinsics.throwUninitializedPropertyAccessException("doneButton");
                                                throw null;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException("backButton");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("doneButton");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("skipButton");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
                            throw null;
                        }
                        throw new IllegalStateException("Missing Back button: R.id.back");
                    }
                    throw new IllegalStateException("Missing Skip button: R.id.skip");
                }
                throw new IllegalStateException("Missing Done button: R.id.done");
            }
            throw new IllegalStateException("Missing Next button: R.id.next");
        }
        throw new IllegalStateException("Missing Indicator Container: R.id.indicator_container");
    }

    public void onDonePressed(Fragment fragment) {
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public void onIllegallyRequestedNextPage() {
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager != null) {
                Fragment item = pagerAdapter.getItem(appIntroViewPager.getCurrentItem());
                if (item instanceof SlidePolicy) {
                    SlidePolicy slidePolicy = (SlidePolicy) item;
                    if (!slidePolicy.isPolicyRespected()) {
                        slidePolicy.onUserIllegallyRequestedNextPage();
                        return;
                    }
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        throw null;
    }

    public void onIntroFinished() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (i != 23 && i != 66 && i != 96) {
            return super.onKeyDown(i, event);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            boolean isLastSlide = appIntroViewPager.isLastSlide(this.fragments.size());
            goToNextSlide(isLastSlide);
            if (!isLastSlide) {
                return false;
            }
            PagerAdapter pagerAdapter = this.pagerAdapter;
            if (pagerAdapter != null) {
                AppIntroViewPager appIntroViewPager2 = this.pager;
                if (appIntroViewPager2 != null) {
                    onDonePressed(pagerAdapter.getItem(appIntroViewPager2.getCurrentItem()));
                    return false;
                }
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pager");
        throw null;
    }

    public void onNextPressed(Fragment fragment) {
    }

    public void onNextSlide() {
    }

    public void onPageSelected(int i) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.slidesNumber = this.fragments.size();
        initializeIndicator();
        this.retainIsButtonsEnabled = this.isButtonsEnabled;
        if (isRtl$appintro_release()) {
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager != null) {
                appIntroViewPager.setCurrentItem(this.fragments.size() - this.savedCurrentItem);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            }
        } else {
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 != null) {
                appIntroViewPager2.setCurrentItem(this.savedCurrentItem);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            }
        }
        AppIntroViewPager appIntroViewPager3 = this.pager;
        if (appIntroViewPager3 != null) {
            appIntroViewPager3.post(new ActivityCompat$$ExternalSyntheticLambda0(14, this));
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i, permissions, grantResults);
        int i2 = 0;
        setSwipeLock(false);
        if (i == 1) {
            ArrayList arrayList = new ArrayList(grantResults.length);
            int length = grantResults.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5 = grantResults[i3];
                i3++;
                arrayList.add(new Pair(permissions[i4], Integer.valueOf(i5)));
                i4++;
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                if (((Number) ((Pair) obj).second).intValue() == -1) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            int size2 = arrayList2.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj2 = arrayList2.get(i7);
                i7++;
                arrayList3.add((String) ((Pair) obj2).first);
            }
            if (arrayList3.isEmpty()) {
                this.permissionsMap.remove(Integer.valueOf(getCurrentSlideNumber()));
                goToNextSlide$default(this, false, 1, null);
                return;
            }
            int size3 = arrayList3.size();
            while (i2 < size3) {
                Object obj3 = arrayList3.get(i2);
                i2++;
                handleDeniedPermission((String) obj3);
            }
            AppIntroViewPager appIntroViewPager = this.pager;
            if (appIntroViewPager != null) {
                appIntroViewPager.reCenterCurrentSlide$appintro_release();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
                throw null;
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        this.slidesNumber = savedInstanceState.getInt(ARG_BUNDLE_SLIDES_NUMBER);
        this.retainIsButtonsEnabled = savedInstanceState.getBoolean(ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED);
        setButtonsEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_BUTTONS_ENABLED));
        setSkipButtonEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED));
        setIndicatorEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED));
        this.savedCurrentItem = savedInstanceState.getInt(ARG_BUNDLE_CURRENT_ITEM);
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setFullPagingEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED));
            HashMap<Integer, PermissionWrapper> hashMap = (HashMap) savedInstanceState.getSerializable(ARG_BUNDLE_PERMISSION_MAP);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            this.permissionsMap = hashMap;
            setColorTransitionsEnabled(savedInstanceState.getBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED));
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pager");
        throw null;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_BUNDLE_SLIDES_NUMBER, this.slidesNumber);
        outState.putBoolean(ARG_BUNDLE_RETAIN_IS_BUTTONS_ENABLED, this.retainIsButtonsEnabled);
        outState.putBoolean(ARG_BUNDLE_IS_BUTTONS_ENABLED, isButtonsEnabled());
        outState.putBoolean(ARG_BUNDLE_IS_SKIP_BUTTON_ENABLED, isSkipButtonEnabled());
        outState.putBoolean(ARG_BUNDLE_IS_INDICATOR_ENABLED, isIndicatorEnabled());
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            outState.putInt(ARG_BUNDLE_CURRENT_ITEM, appIntroViewPager.getCurrentItem());
            AppIntroViewPager appIntroViewPager2 = this.pager;
            if (appIntroViewPager2 != null) {
                outState.putBoolean(ARG_BUNDLE_IS_FULL_PAGING_ENABLED, appIntroViewPager2.isFullPagingEnabled());
                outState.putSerializable(ARG_BUNDLE_PERMISSION_MAP, this.permissionsMap);
                outState.putBoolean(ARG_BUNDLE_COLOR_TRANSITIONS_ENABLED, isColorTransitionsEnabled());
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pager");
        throw null;
    }

    public void onSkipPressed(Fragment fragment) {
    }

    public void onSlideChanged(Fragment fragment, Fragment fragment2) {
    }

    public void onUserDeniedPermission(String permissionName) {
        Intrinsics.checkNotNullParameter(permissionName, "permissionName");
    }

    public void onUserDisabledPermission(String permissionName) {
        Intrinsics.checkNotNullParameter(permissionName, "permissionName");
    }

    @Override // com.github.appintro.AppIntroViewPagerListener
    public void onUserRequestedPermissionsDialog() {
        LogHelper.d(TAG, Intrinsics.stringPlus(Integer.valueOf(getCurrentSlideNumber()), "Requesting Permissions on "));
        requestPermissions();
    }

    public final void setButtonsEnabled(boolean z) {
        this.isButtonsEnabled = z;
        updateButtonsVisibility();
    }

    public final void setColorTransitionsEnabled(boolean z) {
        this.isColorTransitionsEnabled = z;
    }

    public final void setCustomTransformer(ViewPager.PageTransformer pageTransformer) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setPageTransformer(true, pageTransformer);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
    }

    public final void setImmersiveMode() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final void setIndicatorColor(int i, int i2) {
        IndicatorController indicatorController = this.indicatorController;
        if (indicatorController != null) {
            indicatorController.setSelectedIndicatorColor(i);
        }
        IndicatorController indicatorController2 = this.indicatorController;
        if (indicatorController2 != null) {
            indicatorController2.setUnselectedIndicatorColor(i2);
        }
    }

    public final void setIndicatorController(IndicatorController indicatorController) {
        this.indicatorController = indicatorController;
    }

    public final void setIndicatorEnabled(boolean z) {
        this.isIndicatorEnabled = z;
        ViewGroup viewGroup = this.indicatorContainer;
        if (viewGroup != null) {
            AppIntroBaseKt.setVisible(viewGroup, z);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorContainer");
            throw null;
        }
    }

    public final void setNavBarColor(int i) {
        getWindow().setNavigationBarColor(i);
    }

    public final void setNavBarColorRes(int i) {
        getWindow().setNavigationBarColor(BundleKt.getColor(this, i));
    }

    public final void setNextPageSwipeLock(boolean z) {
        LogHelper.w$default(TAG, "Calling setNextPageSwipeLock has not effect here. Please switch to setSwipeLock or SlidePolicy", null, 4, null);
    }

    public final void setProgressIndicator() {
        this.indicatorController = new ProgressIndicatorController(this, null, 0, 6, null);
    }

    public final void setScrollDurationFactor(int i) {
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setScrollDurationFactor(i);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
    }

    public final void setSkipButtonEnabled(boolean z) {
        this.isSkipButtonEnabled = z;
        updateButtonsVisibility();
    }

    public final void setStatusBarColor(int i) {
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(i);
    }

    public final void setStatusBarColorRes(int i) {
        setStatusBarColor(BundleKt.getColor(this, i));
    }

    public final void setSwipeLock(boolean z) {
        if (z) {
            this.retainIsButtonsEnabled = this.isButtonsEnabled;
            setButtonsEnabled(true);
        } else {
            setButtonsEnabled(this.retainIsButtonsEnabled);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setFullPagingEnabled(!z);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
    }

    public final void setSystemBackButtonLocked(boolean z) {
        this.isSystemBackButtonLocked = z;
    }

    public final void setTransformer(AppIntroPageTransformerType appIntroTransformer) {
        Intrinsics.checkNotNullParameter(appIntroTransformer, "appIntroTransformer");
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.setAppIntroPageTransformer(appIntroTransformer);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
            throw null;
        }
    }

    public final void setVibrate(boolean z) {
        this.isVibrate = z;
    }

    public final void setVibrateDuration(long j) {
        this.vibrateDuration = j;
    }

    public final void setWizardMode(boolean z) {
        this.isWizardMode = z;
        setSkipButtonEnabled(!z);
        updateButtonsVisibility();
    }

    public final void showStatusBar(boolean z) {
        if (z) {
            getWindow().clearFlags(1024);
        } else {
            getWindow().setFlags(1024, 1024);
        }
    }

    public final void askForPermissions(String[] permissions, int i, boolean z) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (i > 0) {
            this.permissionsMap.put(Integer.valueOf(i), new PermissionWrapper(permissions, i, z));
            return;
        }
        throw new IllegalStateException(Intrinsics.stringPlus(Integer.valueOf(i), "Invalid Slide Number: ").toString());
    }

    public final void goToNextSlide(boolean z) {
        if (z) {
            onIntroFinished();
            return;
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (appIntroViewPager != null) {
            appIntroViewPager.goToNextSlide();
            onNextSlide();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pager");
        throw null;
    }
}
