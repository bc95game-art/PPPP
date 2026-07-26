package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.internal.Lock;
import androidx.core.os.BundleKt;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.PointerIconCompat$Api24Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.tracing.Trace;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.FakeDrag;
import androidx.viewpager2.widget.ViewPager2;
import com.emanuelef.remote_capture.R;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.LazyKt__LazyJVMKt;
@ViewPager.DecorView
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final Pools$SynchronizedPool tabPool = new Pools$SynchronizedPool(16);
    public AdapterChangeListener adapterChangeListener;
    public final int contentInsetStart;
    public ViewPagerOnTabSelectedListener currentVpSelectedListener;
    public final int defaultTabTextAppearance;
    public boolean inlineLabel;
    public int mode;
    public TabLayoutOnPageChangeListener pageChangeListener;
    public PagerAdapter pagerAdapter;
    public CursorAdapter.MyDataSetObserver pagerAdapterObserver;
    public final int requestedTabMaxWidth;
    public final int requestedTabMinWidth;
    public ValueAnimator scrollAnimator;
    public final int scrollableTabMinWidth;
    public BaseOnTabSelectedListener selectedListener;
    public Tab selectedTab;
    public final int selectedTabTextAppearance;
    public final float selectedTabTextSize;
    public boolean setupViewPagerImplicitly;
    public final SlidingTabIndicator slidingTabIndicator;
    public final int tabBackgroundResId;
    public int tabGravity;
    public ColorStateList tabIconTint;
    public final int tabIndicatorAnimationDuration;
    public int tabIndicatorAnimationMode;
    public boolean tabIndicatorFullWidth;
    public int tabIndicatorGravity;
    public Lock tabIndicatorInterpolator;
    public final TimeInterpolator tabIndicatorTimeInterpolator;
    public final int tabPaddingBottom;
    public final int tabPaddingEnd;
    public final int tabPaddingStart;
    public final int tabPaddingTop;
    public ColorStateList tabRippleColorStateList;
    public Drawable tabSelectedIndicator;
    public final int tabTextAppearance;
    public ColorStateList tabTextColors;
    public final float tabTextMultiLineSize;
    public final float tabTextSize;
    public boolean unboundedRipple;
    public ViewPager viewPager;
    public int viewPagerScrollState;
    public int indicatorPosition = -1;
    public final ArrayList tabs = new ArrayList();
    public int tabSelectedIndicatorColor = 0;
    public int tabMaxWidth = Integer.MAX_VALUE;
    public int tabIndicatorHeight = -1;
    public final ArrayList selectedListeners = new ArrayList();
    public final Pools$SimplePool tabViewPool = new Pools$SimplePool(12);

    /* renamed from: com.google.android.material.tabs.TabLayout$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            switch (this.$r8$classId) {
                case 0:
                    ((TabLayout) this.this$0).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                    return;
                case 1:
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MaterialShapeDrawable materialShapeDrawable = ((BottomSheetBehavior) this.this$0).materialShapeDrawable;
                    if (materialShapeDrawable != null) {
                        materialShapeDrawable.setInterpolation(floatValue);
                        return;
                    }
                    return;
                default:
                    ((TextInputLayout) this.this$0).collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        public boolean autoRefresh;

        public AdapterChangeListener() {
        }
    }

    /* loaded from: classes.dex */
    public interface BaseOnTabSelectedListener {
        void onTabSelected(Tab tab);
    }

    /* loaded from: classes.dex */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener {
    }

    /* loaded from: classes.dex */
    public final class SlidingTabIndicator extends LinearLayout {
        public static final /* synthetic */ int $r8$clinit = 0;
        public ValueAnimator indicatorAnimator;
        public int layoutDirection = -1;

        public SlidingTabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        public final void draw(Canvas canvas) {
            int i;
            TabLayout tabLayout = TabLayout.this;
            int height = tabLayout.tabSelectedIndicator.getBounds().height();
            if (height < 0) {
                height = tabLayout.tabSelectedIndicator.getIntrinsicHeight();
            }
            int i2 = tabLayout.tabIndicatorGravity;
            if (i2 == 0) {
                i = getHeight() - height;
                height = getHeight();
            } else if (i2 != 1) {
                i = 0;
                if (i2 != 2) {
                    if (i2 != 3) {
                        height = 0;
                    } else {
                        height = getHeight();
                    }
                }
            } else {
                i = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            }
            if (tabLayout.tabSelectedIndicator.getBounds().width() > 0) {
                Rect bounds = tabLayout.tabSelectedIndicator.getBounds();
                tabLayout.tabSelectedIndicator.setBounds(bounds.left, i, bounds.right, height);
                tabLayout.tabSelectedIndicator.draw(canvas);
            }
            super.draw(canvas);
        }

        public final void jumpIndicatorToPosition(int i) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.viewPagerScrollState == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i);
                Lock lock = tabLayout.tabIndicatorInterpolator;
                Drawable drawable = tabLayout.tabSelectedIndicator;
                lock.getClass();
                RectF calculateIndicatorWidthForTab = Lock.calculateIndicatorWidthForTab(tabLayout, childAt);
                drawable.setBounds((int) calculateIndicatorWidthForTab.left, drawable.getBounds().top, (int) calculateIndicatorWidthForTab.right, drawable.getBounds().bottom);
                tabLayout.indicatorPosition = i;
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.indicatorAnimator;
            TabLayout tabLayout = TabLayout.this;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                if (tabLayout.indicatorPosition == -1) {
                    tabLayout.indicatorPosition = tabLayout.getSelectedTabPosition();
                }
                jumpIndicatorToPosition(tabLayout.indicatorPosition);
                return;
            }
            updateOrRecreateIndicatorAnimation(tabLayout.getSelectedTabPosition(), -1, false);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.tabGravity == 1 || tabLayout.mode == 2) {
                    int childCount = getChildCount();
                    int i3 = 0;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 0) {
                            i3 = Math.max(i3, childAt.getMeasuredWidth());
                        }
                    }
                    if (i3 > 0) {
                        if (i3 * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                            boolean z2 = false;
                            for (int i5 = 0; i5 < childCount; i5++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                                if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i3;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            tabLayout.tabGravity = 0;
                            tabLayout.updateTabViews(false);
                        }
                        if (z) {
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.layoutDirection != i) {
                requestLayout();
                this.layoutDirection = i;
            }
        }

        public final void setSelectedIndicatorHeight(int i) {
            TabLayout tabLayout = TabLayout.this;
            Rect bounds = tabLayout.tabSelectedIndicator.getBounds();
            tabLayout.tabSelectedIndicator.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        public final void tweenIndicatorPosition(View view, View view2, float f) {
            TabLayout tabLayout = TabLayout.this;
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = tabLayout.tabSelectedIndicator;
                drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.tabSelectedIndicator.getBounds().bottom);
            } else {
                tabLayout.tabIndicatorInterpolator.updateIndicatorForOffset(tabLayout, view, view2, f, tabLayout.tabSelectedIndicator);
            }
            postInvalidateOnAnimation();
        }

        public final void updateOrRecreateIndicatorAnimation(int i, int i2, boolean z) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.indicatorPosition != i) {
                final View childAt = getChildAt(tabLayout.getSelectedTabPosition());
                final View childAt2 = getChildAt(i);
                if (childAt2 == null) {
                    jumpIndicatorToPosition(tabLayout.getSelectedTabPosition());
                    return;
                }
                tabLayout.indicatorPosition = i;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SlidingTabIndicator.this.tweenIndicatorPosition(childAt, childAt2, valueAnimator.getAnimatedFraction());
                    }
                };
                if (z) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.indicatorAnimator = valueAnimator;
                    valueAnimator.setInterpolator(tabLayout.tabIndicatorTimeInterpolator);
                    valueAnimator.setDuration(i2);
                    valueAnimator.setFloatValues(0.0f, 1.0f);
                    valueAnimator.addUpdateListener(animatorUpdateListener);
                    valueAnimator.start();
                    return;
                }
                this.indicatorAnimator.removeAllUpdateListeners();
                this.indicatorAnimator.addUpdateListener(animatorUpdateListener);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Tab {
        public View customView;
        public TabLayout parent;
        public int position;
        public CharSequence text;
        public TabView view;

        public final void setText(CharSequence charSequence) {
            if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(charSequence)) {
                this.view.setContentDescription(charSequence);
            }
            this.text = charSequence;
            TabView tabView = this.view;
            if (tabView != null) {
                tabView.update();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public int previousScrollState;
        public int scrollState;
        public final WeakReference tabLayoutRef;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i;
            TabLayout tabLayout = (TabLayout) this.tabLayoutRef.get();
            if (tabLayout != null) {
                tabLayout.viewPagerScrollState = this.scrollState;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i3 = this.scrollState;
                boolean z = true;
                if (i3 == 2 && this.previousScrollState != 1) {
                    z = false;
                }
                boolean z2 = true;
                if (i3 == 2 && this.previousScrollState == 0) {
                    z2 = false;
                }
                tabLayout.setScrollPosition(i, f, z, z2, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            boolean z;
            TabLayout tabLayout = (TabLayout) this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.scrollState;
                if (i2 == 0 || (i2 == 2 && this.previousScrollState == 0)) {
                    z = true;
                } else {
                    z = false;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i), z);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class TabView extends LinearLayout {
        public static final /* synthetic */ int $r8$clinit = 0;
        public View badgeAnchorView;
        public BadgeDrawable badgeDrawable;
        public Drawable baseBackgroundDrawable;
        public ImageView customIconView;
        public TextView customTextView;
        public View customView;
        public int defaultMaxLines = 2;
        public ImageView iconView;
        public Tab tab;
        public TextView textView;

        public TabView(Context context) {
            super(context);
            FakeDrag fakeDrag;
            updateBackgroundDrawable(context);
            setPaddingRelative(TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
            setGravity(17);
            setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
            setClickable(true);
            Context context2 = getContext();
            if (Build.VERSION.SDK_INT >= 24) {
                fakeDrag = new FakeDrag(10, PointerIconCompat$Api24Impl.getSystemIcon(context2, 1002));
            } else {
                fakeDrag = new FakeDrag(10, null);
            }
            ViewCompat.setPointerIcon(this, fakeDrag);
        }

        private BadgeDrawable getBadge() {
            return this.badgeDrawable;
        }

        private BadgeDrawable getOrCreateBadge() {
            if (this.badgeDrawable == null) {
                this.badgeDrawable = new BadgeDrawable(getContext());
            }
            tryUpdateBadgeAnchor();
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void drawableStateChanged() {
            boolean z;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.baseBackgroundDrawable;
            if (drawable == null || !drawable.isStateful()) {
                z = false;
            } else {
                z = this.baseBackgroundDrawable.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    if (z) {
                        i2 = Math.min(i2, view.getTop());
                    } else {
                        i2 = view.getTop();
                    }
                    if (z) {
                        i = Math.max(i, view.getBottom());
                    } else {
                        i = view.getBottom();
                    }
                    z = true;
                }
            }
            return i - i2;
        }

        public int getContentWidth() {
            View[] viewArr = {this.textView, this.iconView, this.customView};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    if (z) {
                        i2 = Math.min(i2, view.getLeft());
                    } else {
                        i2 = view.getLeft();
                    }
                    if (z) {
                        i = Math.max(i, view.getRight());
                    } else {
                        i = view.getRight();
                    }
                    z = true;
                }
            }
            return i - i2;
        }

        public Tab getTab() {
            return this.tab;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            boolean z;
            Context context;
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                BadgeDrawable badgeDrawable2 = this.badgeDrawable;
                BadgeState badgeState = badgeDrawable2.state;
                CharSequence charSequence = null;
                if (badgeDrawable2.isVisible()) {
                    BadgeState.State state = badgeState.currentState;
                    if (state.text != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        charSequence = state.contentDescriptionForText;
                        if (charSequence == null) {
                            charSequence = badgeDrawable2.state.currentState.text;
                        }
                    } else if (!badgeDrawable2.hasNumber()) {
                        charSequence = state.contentDescriptionNumberless;
                    } else if (!(state.contentDescriptionQuantityStrings == 0 || (context = (Context) badgeDrawable2.contextRef.get()) == null)) {
                        if (badgeDrawable2.maxBadgeNumber != -2) {
                            int number = badgeDrawable2.getNumber();
                            int i = badgeDrawable2.maxBadgeNumber;
                            if (number > i) {
                                charSequence = context.getString(state.contentDescriptionExceedsMaxBadgeNumberRes, Integer.valueOf(i));
                            }
                        }
                        charSequence = context.getResources().getQuantityString(state.contentDescriptionQuantityStrings, badgeDrawable2.getNumber(), Integer.valueOf(badgeDrawable2.getNumber()));
                    }
                }
                accessibilityNodeInfo.setContentDescription(charSequence);
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.tab.position, 1, false, isSelected()).mInfo);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK.mAction);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            TabLayout tabLayout = TabLayout.this;
            int tabMaxWidth = tabLayout.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(tabLayout.tabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.textView != null) {
                float f = tabLayout.tabTextSize;
                if (isSelected() && tabLayout.selectedTabTextAppearance != -1) {
                    f = tabLayout.selectedTabTextSize;
                }
                int i3 = this.defaultMaxLines;
                ImageView imageView = this.iconView;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.textView;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = tabLayout.tabTextMultiLineSize;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.textView.getTextSize();
                int lineCount = this.textView.getLineCount();
                int maxLines = this.textView.getMaxLines();
                int i4 = (f > textSize ? 1 : (f == textSize ? 0 : -1));
                if (i4 != 0 || (maxLines >= 0 && i3 != maxLines)) {
                    if (tabLayout.mode == 1 && i4 > 0 && lineCount == 1) {
                        Layout layout = this.textView.getLayout();
                        if (layout != null) {
                            if ((f / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.textView.setTextSize(0, f);
                    this.textView.setMaxLines(i3);
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.tab == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            Tab tab = this.tab;
            TabLayout tabLayout = tab.parent;
            if (tabLayout != null) {
                tabLayout.selectTab(tab, true);
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            isSelected();
            super.setSelected(z);
            TextView textView = this.textView;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.iconView;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.customView;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(Tab tab) {
            if (tab != this.tab) {
                this.tab = tab;
                update();
            }
        }

        public final void tryRemoveBadgeFromAnchor() {
            if (this.badgeDrawable != null) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.badgeAnchorView;
                if (view != null) {
                    BadgeDrawable badgeDrawable = this.badgeDrawable;
                    if (badgeDrawable != null) {
                        if (badgeDrawable.getCustomBadgeParent() != null) {
                            badgeDrawable.getCustomBadgeParent().setForeground(null);
                        } else {
                            view.getOverlay().remove(badgeDrawable);
                        }
                    }
                    this.badgeAnchorView = null;
                }
            }
        }

        public final void tryUpdateBadgeAnchor() {
            if (this.badgeDrawable == null) {
                return;
            }
            if (this.customView != null) {
                tryRemoveBadgeFromAnchor();
                return;
            }
            TextView textView = this.textView;
            if (textView == null || this.tab == null) {
                tryRemoveBadgeFromAnchor();
            } else if (this.badgeAnchorView != textView) {
                tryRemoveBadgeFromAnchor();
                TextView textView2 = this.textView;
                if (this.badgeDrawable != null && textView2 != null) {
                    setClipChildren(false);
                    setClipToPadding(false);
                    ViewGroup viewGroup = (ViewGroup) getParent();
                    if (viewGroup != null) {
                        viewGroup.setClipChildren(false);
                        viewGroup.setClipToPadding(false);
                    }
                    BadgeDrawable badgeDrawable = this.badgeDrawable;
                    Rect rect = new Rect();
                    textView2.getDrawingRect(rect);
                    badgeDrawable.setBounds(rect);
                    badgeDrawable.updateBadgeCoordinates(textView2, null);
                    if (badgeDrawable.getCustomBadgeParent() != null) {
                        badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
                    } else {
                        textView2.getOverlay().add(badgeDrawable);
                    }
                    this.badgeAnchorView = textView2;
                }
            } else {
                tryUpdateBadgeDrawableBounds(textView);
            }
        }

        public final void tryUpdateBadgeDrawableBounds(View view) {
            BadgeDrawable badgeDrawable = this.badgeDrawable;
            if (badgeDrawable != null && view == this.badgeAnchorView) {
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                badgeDrawable.setBounds(rect);
                badgeDrawable.updateBadgeCoordinates(view, null);
            }
        }

        public final void update() {
            boolean z;
            updateTab();
            Tab tab = this.tab;
            if (tab != null) {
                TabLayout tabLayout = tab.parent;
                if (tabLayout != null) {
                    int selectedTabPosition = tabLayout.getSelectedTabPosition();
                    if (selectedTabPosition != -1 && selectedTabPosition == tab.position) {
                        z = true;
                        setSelected(z);
                    }
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            z = false;
            setSelected(z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [android.view.View, com.google.android.material.tabs.TabLayout$TabView] */
        /* JADX WARN: Type inference failed for: r1v7, types: [android.graphics.drawable.RippleDrawable] */
        public final void updateBackgroundDrawable(Context context) {
            TabLayout tabLayout = TabLayout.this;
            int i = tabLayout.tabBackgroundResId;
            GradientDrawable gradientDrawable = null;
            if (i != 0) {
                Drawable drawable = BundleKt.getDrawable(context, i);
                this.baseBackgroundDrawable = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.baseBackgroundDrawable.setState(getDrawableState());
                }
            } else {
                this.baseBackgroundDrawable = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (tabLayout.tabRippleColorStateList != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateList = tabLayout.tabRippleColorStateList;
                int colorForState = RippleUtils.getColorForState(colorStateList, RippleUtils.SELECTED_PRESSED_STATE_SET);
                int[] iArr = RippleUtils.FOCUSED_STATE_SET;
                ColorStateList colorStateList2 = new ColorStateList(new int[][]{RippleUtils.SELECTED_STATE_SET, iArr, StateSet.NOTHING}, new int[]{colorForState, RippleUtils.getColorForState(colorStateList, iArr), RippleUtils.getColorForState(colorStateList, RippleUtils.PRESSED_STATE_SET)});
                boolean z = tabLayout.unboundedRipple;
                if (z) {
                    gradientDrawable2 = null;
                }
                if (!z) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(colorStateList2, gradientDrawable2, gradientDrawable);
            }
            setBackground(gradientDrawable2);
            tabLayout.invalidate();
        }

        public final void updateTab() {
            View view;
            int i;
            ViewParent parent;
            Tab tab = this.tab;
            if (tab != null) {
                view = tab.customView;
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.customView;
                    if (!(view2 == null || (parent = view2.getParent()) == null)) {
                        ((ViewGroup) parent).removeView(this.customView);
                    }
                    addView(view);
                }
                this.customView = view;
                TextView textView = this.textView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.iconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iconView.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.customTextView = textView2;
                if (textView2 != null) {
                    this.defaultMaxLines = textView2.getMaxLines();
                }
                this.customIconView = (ImageView) view.findViewById(16908294);
            } else {
                View view3 = this.customView;
                if (view3 != null) {
                    removeView(view3);
                    this.customView = null;
                }
                this.customTextView = null;
                this.customIconView = null;
            }
            if (this.customView == null) {
                if (this.iconView == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.iconView = imageView2;
                    addView(imageView2, 0);
                }
                if (this.textView == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.textView = textView3;
                    addView(textView3);
                    this.defaultMaxLines = this.textView.getMaxLines();
                }
                TextView textView4 = this.textView;
                TabLayout tabLayout = TabLayout.this;
                TextViewCompat.setTextAppearance(textView4, tabLayout.defaultTabTextAppearance);
                if (!isSelected() || (i = tabLayout.selectedTabTextAppearance) == -1) {
                    TextViewCompat.setTextAppearance(this.textView, tabLayout.tabTextAppearance);
                } else {
                    TextViewCompat.setTextAppearance(this.textView, i);
                }
                ColorStateList colorStateList = tabLayout.tabTextColors;
                if (colorStateList != null) {
                    this.textView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.textView, this.iconView, true);
                tryUpdateBadgeAnchor();
                final ImageView imageView3 = this.iconView;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                            View view5 = imageView3;
                            if (view5.getVisibility() == 0) {
                                TabView.this.tryUpdateBadgeDrawableBounds(view5);
                            }
                        }
                    });
                }
                final TextView textView5 = this.textView;
                if (textView5 != null) {
                    textView5.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public final void onLayoutChange(View view4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                            View view5 = textView5;
                            if (view5.getVisibility() == 0) {
                                TabView.this.tryUpdateBadgeDrawableBounds(view5);
                            }
                        }
                    });
                }
            } else {
                TextView textView6 = this.customTextView;
                if (!(textView6 == null && this.customIconView == null)) {
                    updateTextAndIcon(textView6, this.customIconView, false);
                }
            }
            if (tab != null && !TextUtils.isEmpty(null)) {
                setContentDescription(null);
            }
        }

        public final void updateTextAndIcon(TextView textView, ImageView imageView, boolean z) {
            CharSequence charSequence;
            boolean z2;
            int i;
            CharSequence charSequence2;
            int i2;
            Tab tab = this.tab;
            CharSequence charSequence3 = null;
            if (tab != null) {
                charSequence = tab.text;
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (!isEmpty) {
                    this.tab.getClass();
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!isEmpty) {
                    charSequence2 = charSequence;
                } else {
                    charSequence2 = null;
                }
                textView.setText(charSequence2);
                if (z2) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                textView.setVisibility(i2);
                if (!isEmpty) {
                    setVisibility(0);
                }
            } else {
                z2 = false;
            }
            if (z && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (!z2 || imageView.getVisibility() != 0) {
                    i = 0;
                } else {
                    i = (int) ViewUtils.dpToPx(getContext(), 8);
                }
                if (TabLayout.this.inlineLabel) {
                    if (i != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(i);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    marginLayoutParams.setMarginEnd(0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            if (Build.VERSION.SDK_INT > 23) {
                if (!isEmpty) {
                    charSequence3 = charSequence;
                }
                BundleKt.setTooltipText(this, charSequence3);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        public final /* synthetic */ int $r8$classId;
        public final ViewGroup viewPager;

        public /* synthetic */ ViewPagerOnTabSelectedListener(ViewGroup viewGroup, int i) {
            this.$r8$classId = i;
            this.viewPager = viewGroup;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(Tab tab) {
            switch (this.$r8$classId) {
                case 0:
                    ((ViewPager) this.viewPager).setCurrentItem(tab.position);
                    return;
                default:
                    ((ViewPager2) this.viewPager).setCurrentItem(tab.position, true);
                    return;
            }
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.tabStyle, R.style.Widget_Design_TabLayout), attributeSet, R.attr.tabStyle);
        float f;
        this.selectedTabTextAppearance = -1;
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context2);
        this.slidingTabIndicator = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = ViewUtils.obtainStyledAttributes(context2, attributeSet, R$styleable.TabLayout, R.attr.tabStyle, R.style.Widget_Design_TabLayout, 24);
        ColorStateList colorStateListOrNull = Trace.getColorStateListOrNull(getBackground());
        if (colorStateListOrNull != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(colorStateListOrNull);
            materialShapeDrawable.initializeElevationOverlay(context2);
            materialShapeDrawable.setElevation(getElevation());
            setBackground(materialShapeDrawable);
        }
        setSelectedTabIndicator(LazyKt__LazyJVMKt.getDrawable(context2, obtainStyledAttributes, 5));
        setSelectedTabIndicatorColor(obtainStyledAttributes.getColor(8, 0));
        slidingTabIndicator.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(obtainStyledAttributes.getInt(10, 0));
        setTabIndicatorAnimationMode(obtainStyledAttributes.getInt(7, 0));
        setTabIndicatorFullWidth(obtainStyledAttributes.getBoolean(9, true));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(16, 0);
        this.tabPaddingBottom = dimensionPixelSize;
        this.tabPaddingEnd = dimensionPixelSize;
        this.tabPaddingTop = dimensionPixelSize;
        this.tabPaddingStart = dimensionPixelSize;
        this.tabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(19, dimensionPixelSize);
        this.tabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(20, dimensionPixelSize);
        this.tabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(18, dimensionPixelSize);
        this.tabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(17, dimensionPixelSize);
        if (LazyKt__LazyJVMKt.resolveBoolean(context2, R.attr.isMaterial3Theme, false)) {
            this.defaultTabTextAppearance = R.attr.textAppearanceTitleSmall;
        } else {
            this.defaultTabTextAppearance = R.attr.textAppearanceButton;
        }
        int resourceId = obtainStyledAttributes.getResourceId(24, R.style.TextAppearance_Design_Tab);
        this.tabTextAppearance = resourceId;
        int[] iArr = androidx.appcompat.R$styleable.TextAppearance;
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(resourceId, iArr);
        try {
            this.tabTextSize = obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            this.tabTextColors = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes2, 3);
            obtainStyledAttributes2.recycle();
            if (obtainStyledAttributes.hasValue(22)) {
                this.selectedTabTextAppearance = obtainStyledAttributes.getResourceId(22, resourceId);
            }
            int i = this.selectedTabTextAppearance;
            int[] iArr2 = HorizontalScrollView.EMPTY_STATE_SET;
            int[] iArr3 = HorizontalScrollView.SELECTED_STATE_SET;
            if (i != -1) {
                obtainStyledAttributes2 = context2.obtainStyledAttributes(i, iArr);
                try {
                    this.selectedTabTextSize = obtainStyledAttributes2.getDimensionPixelSize(0, (int) f);
                    ColorStateList colorStateList = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes2, 3);
                    if (colorStateList != null) {
                        this.tabTextColors = new ColorStateList(new int[][]{iArr3, iArr2}, new int[]{colorStateList.getColorForState(new int[]{16842913}, colorStateList.getDefaultColor()), this.tabTextColors.getDefaultColor()});
                    }
                } finally {
                }
            }
            if (obtainStyledAttributes.hasValue(25)) {
                this.tabTextColors = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 25);
            }
            if (obtainStyledAttributes.hasValue(23)) {
                this.tabTextColors = new ColorStateList(new int[][]{iArr3, iArr2}, new int[]{obtainStyledAttributes.getColor(23, 0), this.tabTextColors.getDefaultColor()});
            }
            this.tabIconTint = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 3);
            ViewUtils.parseTintMode(obtainStyledAttributes.getInt(4, -1), null);
            this.tabRippleColorStateList = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 21);
            this.tabIndicatorAnimationDuration = obtainStyledAttributes.getInt(6, 300);
            this.tabIndicatorTimeInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(context2, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.requestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(14, -1);
            this.requestedTabMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, -1);
            this.tabBackgroundResId = obtainStyledAttributes.getResourceId(0, 0);
            this.contentInsetStart = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.mode = obtainStyledAttributes.getInt(15, 1);
            this.tabGravity = obtainStyledAttributes.getInt(2, 0);
            this.inlineLabel = obtainStyledAttributes.getBoolean(12, false);
            this.unboundedRipple = obtainStyledAttributes.getBoolean(26, false);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.tabTextMultiLineSize = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.scrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            applyModeAndGravity();
        } finally {
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.tabs;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Tab tab = (Tab) arrayList.get(i);
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.requestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        int i2 = this.mode;
        if (i2 == 0 || i2 == 2) {
            return this.scrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        boolean z;
        boolean z2;
        SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
        int childCount = slidingTabIndicator.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = slidingTabIndicator.getChildAt(i2);
                boolean z3 = true;
                if ((i2 != i || childAt.isSelected()) && (i2 == i || !childAt.isSelected())) {
                    if (i2 == i) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    childAt.setSelected(z2);
                    if (i2 != i) {
                        z3 = false;
                    }
                    childAt.setActivated(z3);
                } else {
                    if (i2 == i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    childAt.setSelected(z);
                    if (i2 != i) {
                        z3 = false;
                    }
                    childAt.setActivated(z3);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).updateTab();
                    }
                }
            }
        }
    }

    public final void addTab(Tab tab, boolean z) {
        ArrayList arrayList = this.tabs;
        int size = arrayList.size();
        if (tab.parent == this) {
            tab.position = size;
            arrayList.add(size, tab);
            int size2 = arrayList.size();
            int i = -1;
            for (int i2 = size + 1; i2 < size2; i2++) {
                if (((Tab) arrayList.get(i2)).position == this.indicatorPosition) {
                    i = i2;
                }
                ((Tab) arrayList.get(i2)).position = i2;
            }
            this.indicatorPosition = i;
            TabView tabView = tab.view;
            tabView.setSelected(false);
            tabView.setActivated(false);
            int i3 = tab.position;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            if (this.mode == 1 && this.tabGravity == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            this.slidingTabIndicator.addView(tabView, i3, layoutParams);
            if (z) {
                TabLayout tabLayout = tab.parent;
                if (tabLayout != null) {
                    tabLayout.selectTab(tab, true);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void animateToTab(int i) {
        if (i != -1) {
            if (getWindowToken() != null && isLaidOut()) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                int childCount = slidingTabIndicator.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (slidingTabIndicator.getChildAt(i2).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int calculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
                if (scrollX != calculateScrollXForTab) {
                    ensureScrollAnimator();
                    this.scrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                    this.scrollAnimator.start();
                }
                ValueAnimator valueAnimator = slidingTabIndicator.indicatorAnimator;
                if (!(valueAnimator == null || !valueAnimator.isRunning() || TabLayout.this.indicatorPosition == i)) {
                    slidingTabIndicator.indicatorAnimator.cancel();
                }
                slidingTabIndicator.updateOrRecreateIndicatorAnimation(i, this.tabIndicatorAnimationDuration, true);
                return;
            }
            setScrollPosition(i, 0.0f, true, true, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (r0 != 2) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void applyModeAndGravity() {
        /*
            r5 = this;
            int r0 = r5.mode
            r1 = 2
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r0 = 0
            goto L14
        Lb:
            int r0 = r5.contentInsetStart
            int r3 = r5.tabPaddingStart
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L14:
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator r3 = r5.slidingTabIndicator
            r3.setPaddingRelative(r0, r2, r2, r2)
            int r0 = r5.mode
            java.lang.String r2 = "TabLayout"
            r4 = 1
            if (r0 == 0) goto L32
            if (r0 == r4) goto L25
            if (r0 == r1) goto L25
            goto L4a
        L25:
            int r0 = r5.tabGravity
            if (r0 != r1) goto L2e
            java.lang.String r0 = "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead"
            android.util.Log.w(r2, r0)
        L2e:
            r3.setGravity(r4)
            goto L4a
        L32:
            int r0 = r5.tabGravity
            if (r0 == 0) goto L3f
            if (r0 == r4) goto L3b
            if (r0 == r1) goto L44
            goto L4a
        L3b:
            r3.setGravity(r4)
            goto L4a
        L3f:
            java.lang.String r0 = "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead"
            android.util.Log.w(r2, r0)
        L44:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r0)
        L4a:
            r5.updateTabViews(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.applyModeAndGravity():void");
    }

    public final int calculateScrollXForTab(int i, float f) {
        SlidingTabIndicator slidingTabIndicator;
        View childAt;
        View view;
        int i2 = this.mode;
        int i3 = 0;
        if ((i2 != 0 && i2 != 2) || (childAt = (slidingTabIndicator = this.slidingTabIndicator).getChildAt(i)) == null) {
            return 0;
        }
        int i4 = i + 1;
        if (i4 < slidingTabIndicator.getChildCount()) {
            view = slidingTabIndicator.getChildAt(i4);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i3 = view.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i5 = (int) ((width + i3) * 0.5f * f);
        if (getLayoutDirection() == 0) {
            return left + i5;
        }
        return left - i5;
    }

    public final void ensureScrollAnimator() {
        if (this.scrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.scrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(this.tabIndicatorTimeInterpolator);
            this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
            this.scrollAnimator.addUpdateListener(new AnonymousClass1(0, this));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        Tab tab = this.selectedTab;
        if (tab != null) {
            return tab.position;
        }
        return -1;
    }

    public final Tab getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return (Tab) this.tabs.get(i);
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorAnimationMode() {
        return this.tabIndicatorAnimationMode;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.material.tabs.TabLayout$Tab, java.lang.Object] */
    public final Tab newTab() {
        TabView tabView;
        Tab tab = (Tab) tabPool.acquire();
        Tab tab2 = tab;
        if (tab == null) {
            ?? obj = new Object();
            obj.position = -1;
            tab2 = obj;
        }
        tab2.parent = this;
        Pools$SimplePool pools$SimplePool = this.tabViewPool;
        if (pools$SimplePool != null) {
            tabView = (TabView) pools$SimplePool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab2);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(null)) {
            tabView.setContentDescription(tab2.text);
        } else {
            tabView.setContentDescription(null);
        }
        tab2.view = tabView;
        return tab2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LazyKt__LazyJVMKt.setParentAbsoluteElevation(this);
        if (this.viewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.setupViewPagerImplicitly = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        int i = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (i < slidingTabIndicator.getChildCount()) {
                View childAt = slidingTabIndicator.getChildAt(i);
                if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).baseBackgroundDrawable) != null) {
                    drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                    tabView.baseBackgroundDrawable.draw(canvas);
                }
                i++;
            } else {
                super.onDraw(canvas);
                return;
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) SnackbarManager.obtain(1, getTabCount(), 1, false).lock);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int round = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + round, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i2) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int i3 = this.requestedTabMaxWidth;
            if (i3 <= 0) {
                i3 = (int) (size - ViewUtils.dpToPx(getContext(), 56));
            }
            this.tabMaxWidth = i3;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i4 = this.mode;
            if (i4 != 0) {
                if (i4 == 1) {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                } else if (i4 != 2) {
                    return;
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.pagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                Tab newTab = newTab();
                newTab.setText(this.pagerAdapter.getPageTitle(i));
                addTab(newTab, false);
            }
            ViewPager viewPager = this.viewPager;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem), true);
            }
        }
    }

    public final void removeAllTabs() {
        SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
        int childCount = slidingTabIndicator.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            TabView tabView = (TabView) slidingTabIndicator.getChildAt(childCount);
            slidingTabIndicator.removeViewAt(childCount);
            if (tabView != null) {
                tabView.setTab(null);
                tabView.setSelected(false);
                this.tabViewPool.release(tabView);
            }
            requestLayout();
        }
        Iterator it = this.tabs.iterator();
        while (it.hasNext()) {
            Tab tab = (Tab) it.next();
            it.remove();
            tab.parent = null;
            tab.view = null;
            tab.text = null;
            tab.position = -1;
            tab.customView = null;
            tabPool.release(tab);
        }
        this.selectedTab = null;
    }

    public final void selectTab(Tab tab, boolean z) {
        int i;
        TabLayout tabLayout;
        Tab tab2 = this.selectedTab;
        ArrayList arrayList = this.selectedListeners;
        if (tab2 != tab) {
            if (tab != null) {
                i = tab.position;
            } else {
                i = -1;
            }
            if (z) {
                if ((tab2 == null || tab2.position == -1) && i != -1) {
                    tabLayout = this;
                    tabLayout.setScrollPosition(i, 0.0f, true, true, true);
                } else {
                    tabLayout = this;
                    animateToTab(i);
                }
                if (i != -1) {
                    setSelectedTabView(i);
                }
            } else {
                tabLayout = this;
            }
            tabLayout.selectedTab = tab;
            if (!(tab2 == null || tab2.parent == null)) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((BaseOnTabSelectedListener) arrayList.get(size)).getClass();
                }
            }
            if (tab != null) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    ((BaseOnTabSelectedListener) arrayList.get(size2)).onTabSelected(tab);
                }
            }
        } else if (tab2 != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((BaseOnTabSelectedListener) arrayList.get(size3)).getClass();
            }
            animateToTab(tab.position);
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        LazyKt__LazyJVMKt.setElevation(this, f);
    }

    public void setInlineLabel(boolean z) {
        if (this.inlineLabel != z) {
            this.inlineLabel = z;
            int i = 0;
            while (true) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                if (i < slidingTabIndicator.getChildCount()) {
                    View childAt = slidingTabIndicator.getChildAt(i);
                    if (childAt instanceof TabView) {
                        TabView tabView = (TabView) childAt;
                        tabView.setOrientation(!TabLayout.this.inlineLabel ? 1 : 0);
                        TextView textView = tabView.customTextView;
                        if (textView == null && tabView.customIconView == null) {
                            tabView.updateTextAndIcon(tabView.textView, tabView.iconView, true);
                        } else {
                            tabView.updateTextAndIcon(textView, tabView.customIconView, false);
                        }
                    }
                    i++;
                } else {
                    applyModeAndGravity();
                    return;
                }
            }
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public final void setPagerAdapter(PagerAdapter pagerAdapter, boolean z) {
        CursorAdapter.MyDataSetObserver myDataSetObserver;
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (!(pagerAdapter2 == null || (myDataSetObserver = this.pagerAdapterObserver) == null)) {
            pagerAdapter2.unregisterDataSetObserver(myDataSetObserver);
        }
        this.pagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.pagerAdapterObserver == null) {
                this.pagerAdapterObserver = new CursorAdapter.MyDataSetObserver(2, this);
            }
            pagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public final void setScrollPosition(int i, float f, boolean z, boolean z2, boolean z3) {
        boolean z4;
        float f2 = i + f;
        int round = Math.round(f2);
        if (round >= 0) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (round < slidingTabIndicator.getChildCount()) {
                if (z2) {
                    TabLayout.this.indicatorPosition = Math.round(f2);
                    ValueAnimator valueAnimator = slidingTabIndicator.indicatorAnimator;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        slidingTabIndicator.indicatorAnimator.cancel();
                    }
                    slidingTabIndicator.tweenIndicatorPosition(slidingTabIndicator.getChildAt(i), slidingTabIndicator.getChildAt(i + 1), f);
                }
                ValueAnimator valueAnimator2 = this.scrollAnimator;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.scrollAnimator.cancel();
                }
                int calculateScrollXForTab = calculateScrollXForTab(i, f);
                int scrollX = getScrollX();
                if ((i >= getSelectedTabPosition() || calculateScrollXForTab < scrollX) && ((i <= getSelectedTabPosition() || calculateScrollXForTab > scrollX) && i != getSelectedTabPosition())) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (getLayoutDirection() == 1) {
                    if ((i >= getSelectedTabPosition() || calculateScrollXForTab > scrollX) && ((i <= getSelectedTabPosition() || calculateScrollXForTab < scrollX) && i != getSelectedTabPosition())) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                }
                if (z4 || this.viewPagerScrollState == 1 || z3) {
                    if (i < 0) {
                        calculateScrollXForTab = 0;
                    }
                    scrollTo(calculateScrollXForTab, 0);
                }
                if (z) {
                    setSelectedTabView(round);
                }
            }
        }
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = BundleKt.wrap(drawable).mutate();
        this.tabSelectedIndicator = mutate;
        Trace.setTint(mutate, this.tabSelectedIndicatorColor);
        int i = this.tabIndicatorHeight;
        if (i == -1) {
            i = this.tabSelectedIndicator.getIntrinsicHeight();
        }
        this.slidingTabIndicator.setSelectedIndicatorHeight(i);
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.tabSelectedIndicatorColor = i;
        Trace.setTint(this.tabSelectedIndicator, i);
        updateTabViews(false);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.tabIndicatorGravity != i) {
            this.tabIndicatorGravity = i;
            this.slidingTabIndicator.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.tabIndicatorHeight = i;
        this.slidingTabIndicator.setSelectedIndicatorHeight(i);
    }

    public void setTabGravity(int i) {
        if (this.tabGravity != i) {
            this.tabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.tabIconTint != colorStateList) {
            this.tabIconTint = colorStateList;
            ArrayList arrayList = this.tabs;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TabView tabView = ((Tab) arrayList.get(i)).view;
                if (tabView != null) {
                    tabView.update();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(BundleKt.getColorStateList(getContext(), i));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.collection.internal.Lock, java.lang.Object] */
    public void setTabIndicatorAnimationMode(int i) {
        this.tabIndicatorAnimationMode = i;
        if (i == 0) {
            this.tabIndicatorInterpolator = new Object();
        } else if (i == 1) {
            this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator(1);
        } else if (i == 2) {
            this.tabIndicatorInterpolator = new FadeTabIndicatorInterpolator(0);
        } else {
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.tabIndicatorFullWidth = z;
        int i = SlidingTabIndicator.$r8$clinit;
        SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
        slidingTabIndicator.jumpIndicatorToPosition(TabLayout.this.getSelectedTabPosition());
        slidingTabIndicator.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.mode) {
            this.mode = i;
            applyModeAndGravity();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.tabRippleColorStateList != colorStateList) {
            this.tabRippleColorStateList = colorStateList;
            int i = 0;
            while (true) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                if (i < slidingTabIndicator.getChildCount()) {
                    View childAt = slidingTabIndicator.getChildAt(i);
                    if (childAt instanceof TabView) {
                        Context context = getContext();
                        int i2 = TabView.$r8$clinit;
                        ((TabView) childAt).updateBackgroundDrawable(context);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(BundleKt.getColorStateList(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.tabTextColors != colorStateList) {
            this.tabTextColors = colorStateList;
            ArrayList arrayList = this.tabs;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                TabView tabView = ((Tab) arrayList.get(i)).view;
                if (tabView != null) {
                    tabView.update();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.unboundedRipple != z) {
            this.unboundedRipple = z;
            int i = 0;
            while (true) {
                SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
                if (i < slidingTabIndicator.getChildCount()) {
                    View childAt = slidingTabIndicator.getChildAt(i);
                    if (childAt instanceof TabView) {
                        Context context = getContext();
                        int i2 = TabView.$r8$clinit;
                        ((TabView) childAt).updateBackgroundDrawable(context);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    public final void updateTabViews(boolean z) {
        int i = 0;
        while (true) {
            SlidingTabIndicator slidingTabIndicator = this.slidingTabIndicator;
            if (i < slidingTabIndicator.getChildCount()) {
                View childAt = slidingTabIndicator.getChildAt(i);
                childAt.setMinimumWidth(getTabMinWidth());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                if (this.mode == 1 && this.tabGravity == 0) {
                    layoutParams.width = 0;
                    layoutParams.weight = 1.0f;
                } else {
                    layoutParams.width = -2;
                    layoutParams.weight = 0.0f;
                }
                if (z) {
                    childAt.requestLayout();
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public final FrameLayout.LayoutParams mo252generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.selectedListener;
        ArrayList arrayList = this.selectedListeners;
        if (baseOnTabSelectedListener2 != null) {
            arrayList.remove(baseOnTabSelectedListener2);
        }
        this.selectedListener = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null && !arrayList.contains(baseOnTabSelectedListener)) {
            arrayList.add(baseOnTabSelectedListener);
        }
    }

    public final void setupWithViewPager(ViewPager viewPager, boolean z) {
        TabLayout tabLayout;
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.pageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.adapterChangeListener;
            if (adapterChangeListener != null) {
                this.viewPager.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = this.currentVpSelectedListener;
        ArrayList arrayList = this.selectedListeners;
        if (viewPagerOnTabSelectedListener != null) {
            arrayList.remove(viewPagerOnTabSelectedListener);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            if (this.pageChangeListener == null) {
                this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.pageChangeListener;
            tabLayoutOnPageChangeListener2.scrollState = 0;
            tabLayoutOnPageChangeListener2.previousScrollState = 0;
            viewPager.addOnPageChangeListener(tabLayoutOnPageChangeListener2);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener2 = new ViewPagerOnTabSelectedListener(viewPager, 0);
            this.currentVpSelectedListener = viewPagerOnTabSelectedListener2;
            if (!arrayList.contains(viewPagerOnTabSelectedListener2)) {
                arrayList.add(viewPagerOnTabSelectedListener2);
            }
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, true);
            }
            if (this.adapterChangeListener == null) {
                this.adapterChangeListener = new AdapterChangeListener();
            }
            AdapterChangeListener adapterChangeListener2 = this.adapterChangeListener;
            adapterChangeListener2.autoRefresh = true;
            viewPager.addOnAdapterChangeListener(adapterChangeListener2);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true, true, true);
            tabLayout = this;
        } else {
            tabLayout = this;
            tabLayout.viewPager = null;
            setPagerAdapter(null, false);
        }
        tabLayout.setupViewPagerImplicitly = z;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(BundleKt.getDrawable(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
