package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.BackEventCompat;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.graphics.Insets;
import androidx.core.p002os.BundleKt;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.tracing.Trace;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator$Api33BackCallbackDelegate;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;
import com.google.android.material.shape.ShapeableDelegateV22;
import com.google.android.material.shape.ShapeableDelegateV33;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.text.MatcherMatchResult;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public final C01921 backDrawerListener;
    public final MatcherMatchResult backOrchestrator;
    public int drawerLayoutCornerSize;
    public final boolean drawerLayoutCornerSizeBackAnimationEnabled;
    public final int drawerLayoutCornerSizeBackAnimationMax;
    public OnNavigationItemSelectedListener listener;
    public final int maxWidth;
    public final NavigationMenu menu;
    public SupportMenuInflater menuInflater;
    public final AppCompatSpinner.ViewTreeObserver$OnGlobalLayoutListenerC00252 onGlobalLayoutListener;
    public final NavigationMenuPresenter presenter;
    public final ShapeableDelegate shapeableDelegate;
    public final MaterialSideContainerBackHelper sideContainerBackHelper;
    public final int[] tmpLocation = new int[2];
    public boolean topInsetScrimEnabled = true;
    public boolean bottomInsetScrimEnabled = true;
    public boolean startInsetScrimEnabled = true;
    public boolean endInsetScrimEnabled = true;

    /* renamed from: com.google.android.material.navigation.NavigationView$2 */
    /* loaded from: classes.dex */
    public final class C01932 implements OnApplyWindowInsetsListener, MenuBuilder.Callback {
        public /* synthetic */ C01932() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int i;
            NavigationView navigationView = NavigationView.this;
            if (navigationView.insets == null) {
                navigationView.insets = new Rect();
            }
            Rect rect = navigationView.insets;
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
            rect.set(systemWindowInsetLeft, windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            NavigationMenuPresenter navigationMenuPresenter = navigationView.presenter;
            navigationMenuPresenter.getClass();
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            boolean z = false;
            if (navigationMenuPresenter.paddingTopDefault != systemWindowInsetTop) {
                navigationMenuPresenter.paddingTopDefault = systemWindowInsetTop;
                if (navigationMenuPresenter.headerLayout.getChildCount() <= 0 && navigationMenuPresenter.isBehindStatusBar) {
                    i = navigationMenuPresenter.paddingTopDefault;
                } else {
                    i = 0;
                }
                NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
                navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
            }
            NavigationMenuView navigationMenuView2 = navigationMenuPresenter.menuView;
            navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
            ViewCompat.dispatchApplyWindowInsets(navigationMenuPresenter.headerLayout, windowInsetsCompat);
            if (impl.getSystemWindowInsets().equals(Insets.NONE) || navigationView.insetForeground == null) {
                z = true;
            }
            navigationView.setWillNotDraw(z);
            navigationView.postInvalidateOnAnimation();
            return impl.consumeSystemWindowInsets();
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnNavigationItemSelectedListener onNavigationItemSelectedListener = NavigationView.this.listener;
            if (onNavigationItemSelectedListener == null || !onNavigationItemSelectedListener.onNavigationItemSelected(menuItem)) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    /* loaded from: classes.dex */
    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.C00522(13);
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02f7  */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.google.android.material.internal.NavigationMenu, androidx.appcompat.view.menu.MenuBuilder, android.view.Menu] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.google.android.material.navigation.NavigationView$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NavigationView(Context context, AttributeSet attributeSet) {
        super(r1, attributeSet, C0130R.attr.navigationViewStyle);
        ShapeableDelegate shapeableDelegate;
        boolean z;
        ColorStateList colorStateList;
        int i;
        ColorStateList colorStateList2;
        int i2;
        ColorStateList colorStateList3;
        MatcherMatchResult matcherMatchResult;
        int i3;
        NavigationMenuView navigationMenuView;
        Context wrap = MaterialThemeOverlay.wrap(context, attributeSet, C0130R.attr.navigationViewStyle, C0130R.style.Widget_Design_NavigationView);
        this.tempRect = new Rect();
        this.drawTopInsetForeground = true;
        this.drawBottomInsetForeground = true;
        this.drawLeftInsetForeground = true;
        this.drawRightInsetForeground = true;
        TypedArray obtainStyledAttributes = ViewUtils.obtainStyledAttributes(wrap, attributeSet, R$styleable.ScrimInsetsFrameLayout, C0130R.attr.navigationViewStyle, C0130R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.insetForeground = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        C01932 r1 = new C01932();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, r1);
        NavigationMenuPresenter navigationMenuPresenter = new NavigationMenuPresenter();
        this.presenter = navigationMenuPresenter;
        this.drawerLayoutCornerSize = 0;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            shapeableDelegate = new ShapeableDelegateV33(this);
        } else if (i4 >= 22) {
            shapeableDelegate = new ShapeableDelegateV22(this);
        } else {
            shapeableDelegate = new ShapeableDelegate();
        }
        this.shapeableDelegate = shapeableDelegate;
        this.sideContainerBackHelper = new MaterialSideContainerBackHelper(this);
        this.backOrchestrator = new MatcherMatchResult(this);
        this.backDrawerListener = new DrawerLayout.DrawerListener() { // from class: com.google.android.material.navigation.NavigationView.1
            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public final void onDrawerClosed(View view) {
                NavigationView navigationView = NavigationView.this;
                if (view == navigationView) {
                    MatcherMatchResult matcherMatchResult2 = navigationView.backOrchestrator;
                    MaterialBackOrchestrator$Api33BackCallbackDelegate materialBackOrchestrator$Api33BackCallbackDelegate = (MaterialBackOrchestrator$Api33BackCallbackDelegate) matcherMatchResult2.matcher;
                    if (materialBackOrchestrator$Api33BackCallbackDelegate != null) {
                        materialBackOrchestrator$Api33BackCallbackDelegate.stopListeningForBackCallbacks((NavigationView) matcherMatchResult2.groups);
                    }
                    if (navigationView.drawerLayoutCornerSizeBackAnimationEnabled && navigationView.drawerLayoutCornerSize != 0) {
                        navigationView.drawerLayoutCornerSize = 0;
                        navigationView.maybeUpdateCornerSizeForDrawerLayout(navigationView.getWidth(), navigationView.getHeight());
                    }
                }
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public final void onDrawerOpened(View view) {
                NavigationView navigationView = NavigationView.this;
                if (view == navigationView) {
                    MatcherMatchResult matcherMatchResult2 = navigationView.backOrchestrator;
                    Objects.requireNonNull(matcherMatchResult2);
                    view.post(new ActivityCompat$$ExternalSyntheticLambda0(19, matcherMatchResult2));
                }
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
            public final void onDrawerSlide(float f) {
            }
        };
        Context context2 = getContext();
        ?? menuBuilder = new MenuBuilder(context2);
        this.menu = menuBuilder;
        ViewUtils.checkCompatibleTheme(context2, attributeSet, C0130R.attr.navigationViewStyle, C0130R.style.Widget_Design_NavigationView);
        int[] iArr = R$styleable.NavigationView;
        ViewUtils.checkTextAppearance(context2, attributeSet, iArr, C0130R.attr.navigationViewStyle, C0130R.style.Widget_Design_NavigationView, new int[0]);
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, C0130R.attr.navigationViewStyle, C0130R.style.Widget_Design_NavigationView);
        MatcherMatchResult matcherMatchResult2 = new MatcherMatchResult(context2, obtainStyledAttributes2);
        if (obtainStyledAttributes2.hasValue(1)) {
            setBackground(matcherMatchResult2.getDrawable(1));
        }
        int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(7, 0);
        this.drawerLayoutCornerSize = dimensionPixelSize;
        if (dimensionPixelSize == 0) {
            z = true;
        } else {
            z = false;
        }
        this.drawerLayoutCornerSizeBackAnimationEnabled = z;
        this.drawerLayoutCornerSizeBackAnimationMax = getResources().getDimensionPixelSize(C0130R.dimen.m3_navigation_drawer_layout_corner_size);
        Drawable background = getBackground();
        ColorStateList colorStateListOrNull = Trace.getColorStateListOrNull(background);
        if (background == null || colorStateListOrNull != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, attributeSet, (int) C0130R.attr.navigationViewStyle, (int) C0130R.style.Widget_Design_NavigationView).build());
            if (colorStateListOrNull != null) {
                materialShapeDrawable.setFillColor(colorStateListOrNull);
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            setBackground(materialShapeDrawable);
        }
        if (obtainStyledAttributes2.hasValue(8)) {
            setElevation(obtainStyledAttributes2.getDimensionPixelSize(8, 0));
        }
        setFitsSystemWindows(obtainStyledAttributes2.getBoolean(2, false));
        this.maxWidth = obtainStyledAttributes2.getDimensionPixelSize(3, 0);
        if (obtainStyledAttributes2.hasValue(33)) {
            colorStateList = matcherMatchResult2.getColorStateList(33);
        } else {
            colorStateList = null;
        }
        if (obtainStyledAttributes2.hasValue(36)) {
            i = obtainStyledAttributes2.getResourceId(36, 0);
        } else {
            i = 0;
        }
        if (i == 0 && colorStateList == null) {
            colorStateList = createDefaultColorStateList(16842808);
        }
        if (obtainStyledAttributes2.hasValue(15)) {
            colorStateList2 = matcherMatchResult2.getColorStateList(15);
        } else {
            colorStateList2 = createDefaultColorStateList(16842808);
        }
        if (obtainStyledAttributes2.hasValue(25)) {
            i2 = obtainStyledAttributes2.getResourceId(25, 0);
        } else {
            i2 = 0;
        }
        boolean z2 = obtainStyledAttributes2.getBoolean(26, true);
        if (obtainStyledAttributes2.hasValue(14)) {
            setItemIconSize(obtainStyledAttributes2.getDimensionPixelSize(14, 0));
        }
        if (obtainStyledAttributes2.hasValue(27)) {
            colorStateList3 = matcherMatchResult2.getColorStateList(27);
        } else {
            colorStateList3 = null;
        }
        if (i2 == 0 && colorStateList3 == null) {
            colorStateList3 = createDefaultColorStateList(16842806);
        }
        Drawable drawable = matcherMatchResult2.getDrawable(11);
        if (drawable == null && (obtainStyledAttributes2.hasValue(18) || obtainStyledAttributes2.hasValue(19))) {
            drawable = createDefaultItemDrawable(matcherMatchResult2, LazyKt__LazyJVMKt.getColorStateList(getContext(), matcherMatchResult2, 20));
            ColorStateList colorStateList4 = LazyKt__LazyJVMKt.getColorStateList(context2, matcherMatchResult2, 17);
            if (colorStateList4 != null) {
                matcherMatchResult = matcherMatchResult2;
                navigationMenuPresenter.itemForeground = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList4), null, createDefaultItemDrawable(matcherMatchResult2, null));
                navigationMenuPresenter.updateAllTextMenuItems();
                if (!obtainStyledAttributes2.hasValue(12)) {
                    i3 = 0;
                    setItemHorizontalPadding(obtainStyledAttributes2.getDimensionPixelSize(12, 0));
                } else {
                    i3 = 0;
                }
                if (obtainStyledAttributes2.hasValue(28)) {
                    setItemVerticalPadding(obtainStyledAttributes2.getDimensionPixelSize(28, i3));
                }
                setDividerInsetStart(obtainStyledAttributes2.getDimensionPixelSize(6, i3));
                setDividerInsetEnd(obtainStyledAttributes2.getDimensionPixelSize(5, i3));
                setSubheaderInsetStart(obtainStyledAttributes2.getDimensionPixelSize(35, i3));
                setSubheaderInsetEnd(obtainStyledAttributes2.getDimensionPixelSize(34, i3));
                setTopInsetScrimEnabled(obtainStyledAttributes2.getBoolean(37, this.topInsetScrimEnabled));
                setBottomInsetScrimEnabled(obtainStyledAttributes2.getBoolean(4, this.bottomInsetScrimEnabled));
                setStartInsetScrimEnabled(obtainStyledAttributes2.getBoolean(32, this.startInsetScrimEnabled));
                setEndInsetScrimEnabled(obtainStyledAttributes2.getBoolean(9, this.endInsetScrimEnabled));
                int dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(13, 0);
                setItemMaxLines(obtainStyledAttributes2.getInt(16, 1));
                menuBuilder.mCallback = new C01932();
                navigationMenuPresenter.f35id = 1;
                navigationMenuPresenter.initForMenu(context2, menuBuilder);
                if (i != 0) {
                    navigationMenuPresenter.subheaderTextAppearance = i;
                    navigationMenuPresenter.updateAllSubHeaderMenuItems();
                }
                navigationMenuPresenter.subheaderColor = colorStateList;
                navigationMenuPresenter.updateAllSubHeaderMenuItems();
                navigationMenuPresenter.iconTintList = colorStateList2;
                navigationMenuPresenter.updateAllTextMenuItems();
                int overScrollMode = getOverScrollMode();
                navigationMenuPresenter.overScrollMode = overScrollMode;
                navigationMenuView = navigationMenuPresenter.menuView;
                if (navigationMenuView != null) {
                    navigationMenuView.setOverScrollMode(overScrollMode);
                }
                if (i2 != 0) {
                    navigationMenuPresenter.textAppearance = i2;
                    navigationMenuPresenter.updateAllTextMenuItems();
                }
                navigationMenuPresenter.textAppearanceActiveBoldEnabled = z2;
                navigationMenuPresenter.updateAllTextMenuItems();
                navigationMenuPresenter.textColor = colorStateList3;
                navigationMenuPresenter.updateAllTextMenuItems();
                navigationMenuPresenter.itemBackground = drawable;
                navigationMenuPresenter.updateAllTextMenuItems();
                navigationMenuPresenter.itemIconPadding = dimensionPixelSize2;
                navigationMenuPresenter.updateAllTextMenuItems();
                menuBuilder.addMenuPresenter(navigationMenuPresenter, menuBuilder.mContext);
                if (navigationMenuPresenter.menuView == null) {
                    NavigationMenuView navigationMenuView2 = (NavigationMenuView) navigationMenuPresenter.layoutInflater.inflate(C0130R.layout.design_navigation_menu, (ViewGroup) this, false);
                    navigationMenuPresenter.menuView = navigationMenuView2;
                    navigationMenuView2.setAccessibilityDelegateCompat(new NavigationMenuPresenter.NavigationMenuViewAccessibilityDelegate(navigationMenuPresenter.menuView));
                    if (navigationMenuPresenter.adapter == null) {
                        NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter = new NavigationMenuPresenter.NavigationMenuAdapter();
                        navigationMenuPresenter.adapter = navigationMenuAdapter;
                        navigationMenuAdapter.setHasStableIds(true);
                    }
                    int i5 = navigationMenuPresenter.overScrollMode;
                    if (i5 != -1) {
                        navigationMenuPresenter.menuView.setOverScrollMode(i5);
                    }
                    LinearLayout linearLayout = (LinearLayout) navigationMenuPresenter.layoutInflater.inflate(C0130R.layout.design_navigation_item_header, (ViewGroup) navigationMenuPresenter.menuView, false);
                    navigationMenuPresenter.headerLayout = linearLayout;
                    linearLayout.setImportantForAccessibility(2);
                    navigationMenuPresenter.menuView.setAdapter(navigationMenuPresenter.adapter);
                }
                addView(navigationMenuPresenter.menuView);
                if (obtainStyledAttributes2.hasValue(29)) {
                    int resourceId = obtainStyledAttributes2.getResourceId(29, 0);
                    NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter2 = navigationMenuPresenter.adapter;
                    if (navigationMenuAdapter2 != null) {
                        navigationMenuAdapter2.updateSuspended = true;
                    }
                    getMenuInflater().inflate(resourceId, menuBuilder);
                    NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter3 = navigationMenuPresenter.adapter;
                    if (navigationMenuAdapter3 != null) {
                        navigationMenuAdapter3.updateSuspended = false;
                    }
                    navigationMenuPresenter.updateMenuView();
                }
                if (obtainStyledAttributes2.hasValue(10)) {
                    navigationMenuPresenter.headerLayout.addView(navigationMenuPresenter.layoutInflater.inflate(obtainStyledAttributes2.getResourceId(10, 0), (ViewGroup) navigationMenuPresenter.headerLayout, false));
                    NavigationMenuView navigationMenuView3 = navigationMenuPresenter.menuView;
                    navigationMenuView3.setPadding(0, 0, 0, navigationMenuView3.getPaddingBottom());
                }
                matcherMatchResult.recycle();
                this.onGlobalLayoutListener = new AppCompatSpinner.ViewTreeObserver$OnGlobalLayoutListenerC00252(4, this);
                getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
            }
        }
        matcherMatchResult = matcherMatchResult2;
        if (!obtainStyledAttributes2.hasValue(12)) {
        }
        if (obtainStyledAttributes2.hasValue(28)) {
        }
        setDividerInsetStart(obtainStyledAttributes2.getDimensionPixelSize(6, i3));
        setDividerInsetEnd(obtainStyledAttributes2.getDimensionPixelSize(5, i3));
        setSubheaderInsetStart(obtainStyledAttributes2.getDimensionPixelSize(35, i3));
        setSubheaderInsetEnd(obtainStyledAttributes2.getDimensionPixelSize(34, i3));
        setTopInsetScrimEnabled(obtainStyledAttributes2.getBoolean(37, this.topInsetScrimEnabled));
        setBottomInsetScrimEnabled(obtainStyledAttributes2.getBoolean(4, this.bottomInsetScrimEnabled));
        setStartInsetScrimEnabled(obtainStyledAttributes2.getBoolean(32, this.startInsetScrimEnabled));
        setEndInsetScrimEnabled(obtainStyledAttributes2.getBoolean(9, this.endInsetScrimEnabled));
        int dimensionPixelSize22 = obtainStyledAttributes2.getDimensionPixelSize(13, 0);
        setItemMaxLines(obtainStyledAttributes2.getInt(16, 1));
        menuBuilder.mCallback = new C01932();
        navigationMenuPresenter.f35id = 1;
        navigationMenuPresenter.initForMenu(context2, menuBuilder);
        if (i != 0) {
        }
        navigationMenuPresenter.subheaderColor = colorStateList;
        navigationMenuPresenter.updateAllSubHeaderMenuItems();
        navigationMenuPresenter.iconTintList = colorStateList2;
        navigationMenuPresenter.updateAllTextMenuItems();
        int overScrollMode2 = getOverScrollMode();
        navigationMenuPresenter.overScrollMode = overScrollMode2;
        navigationMenuView = navigationMenuPresenter.menuView;
        if (navigationMenuView != null) {
        }
        if (i2 != 0) {
        }
        navigationMenuPresenter.textAppearanceActiveBoldEnabled = z2;
        navigationMenuPresenter.updateAllTextMenuItems();
        navigationMenuPresenter.textColor = colorStateList3;
        navigationMenuPresenter.updateAllTextMenuItems();
        navigationMenuPresenter.itemBackground = drawable;
        navigationMenuPresenter.updateAllTextMenuItems();
        navigationMenuPresenter.itemIconPadding = dimensionPixelSize22;
        navigationMenuPresenter.updateAllTextMenuItems();
        menuBuilder.addMenuPresenter(navigationMenuPresenter, menuBuilder.mContext);
        if (navigationMenuPresenter.menuView == null) {
        }
        addView(navigationMenuPresenter.menuView);
        if (obtainStyledAttributes2.hasValue(29)) {
        }
        if (obtainStyledAttributes2.hasValue(10)) {
        }
        matcherMatchResult.recycle();
        this.onGlobalLayoutListener = new AppCompatSpinner.ViewTreeObserver$OnGlobalLayoutListenerC00252(4, this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void cancelBackProgress() {
        requireDrawerLayoutParent();
        this.sideContainerBackHelper.cancelBackProgress();
        if (this.drawerLayoutCornerSizeBackAnimationEnabled && this.drawerLayoutCornerSize != 0) {
            this.drawerLayoutCornerSize = 0;
            maybeUpdateCornerSizeForDrawerLayout(getWidth(), getHeight());
        }
    }

    public final ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = BundleKt.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0130R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    public final InsetDrawable createDefaultItemDrawable(MatcherMatchResult matcherMatchResult, ColorStateList colorStateList) {
        TypedArray typedArray = (TypedArray) matcherMatchResult.input;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), typedArray.getResourceId(18, 0), typedArray.getResourceId(19, 0)).build());
        materialShapeDrawable.setFillColor(colorStateList);
        return new InsetDrawable((Drawable) materialShapeDrawable, typedArray.getDimensionPixelSize(23, 0), typedArray.getDimensionPixelSize(24, 0), typedArray.getDimensionPixelSize(22, 0), typedArray.getDimensionPixelSize(21, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        ShapeableDelegate shapeableDelegate = this.shapeableDelegate;
        Path path = shapeableDelegate.shapePath;
        if (!shapeableDelegate.shouldUseCompatClipping() || path.isEmpty()) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    public MenuItem getCheckedItem() {
        return this.presenter.adapter.checkedItem;
    }

    public int getDividerInsetEnd() {
        return this.presenter.dividerInsetEnd;
    }

    public int getDividerInsetStart() {
        return this.presenter.dividerInsetStart;
    }

    public int getHeaderCount() {
        return this.presenter.headerLayout.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.presenter.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.presenter.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.presenter.itemIconPadding;
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.iconTintList;
    }

    public int getItemMaxLines() {
        return this.presenter.itemMaxLines;
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.textColor;
    }

    public int getItemVerticalPadding() {
        return this.presenter.itemVerticalPadding;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public int getSubheaderInsetEnd() {
        return this.presenter.subheaderInsetEnd;
    }

    public int getSubheaderInsetStart() {
        return this.presenter.subheaderInsetStart;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void handleBackInvoked() {
        Pair requireDrawerLayoutParent = requireDrawerLayoutParent();
        DrawerLayout drawerLayout = (DrawerLayout) requireDrawerLayoutParent.first;
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        BackEventCompat backEventCompat = materialSideContainerBackHelper.backEvent;
        materialSideContainerBackHelper.backEvent = null;
        if (backEventCompat == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.closeDrawer(this, true);
            return;
        }
        int i = ((DrawerLayout.LayoutParams) requireDrawerLayoutParent.second).gravity;
        int i2 = DrawerLayoutUtils.DEFAULT_SCRIM_ALPHA;
        materialSideContainerBackHelper.finishBackProgress(backEventCompat, i, new Transition.C01112(this, 2, drawerLayout), new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(2, drawerLayout));
    }

    public final void maybeUpdateCornerSizeForDrawerLayout(int i, int i2) {
        boolean z;
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.LayoutParams)) {
            if ((this.drawerLayoutCornerSize > 0 || this.drawerLayoutCornerSizeBackAnimationEnabled) && (getBackground() instanceof MaterialShapeDrawable)) {
                if (Gravity.getAbsoluteGravity(((DrawerLayout.LayoutParams) getLayoutParams()).gravity, getLayoutDirection()) == 3) {
                    z = true;
                } else {
                    z = false;
                }
                MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
                ShapeAppearanceModel.Builder builder = materialShapeDrawable.drawableState.shapeAppearanceModel.toBuilder();
                builder.setAllCornerSizes(this.drawerLayoutCornerSize);
                if (z) {
                    builder.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
                    builder.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
                } else {
                    builder.topRightCornerSize = new AbsoluteCornerSize(0.0f);
                    builder.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
                }
                ShapeAppearanceModel build = builder.build();
                materialShapeDrawable.setShapeAppearanceModel(build);
                ShapeableDelegate shapeableDelegate = this.shapeableDelegate;
                shapeableDelegate.shapeAppearanceModel = build;
                shapeableDelegate.updateShapePath();
                shapeableDelegate.invalidateClippingMethod(this);
                shapeableDelegate.maskBounds = new RectF(0.0f, 0.0f, i, i2);
                shapeableDelegate.updateShapePath();
                shapeableDelegate.invalidateClippingMethod(this);
                shapeableDelegate.offsetZeroCornerEdgeBoundsEnabled = true;
                shapeableDelegate.invalidateClippingMethod(this);
            }
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        MaterialBackOrchestrator$Api33BackCallbackDelegate materialBackOrchestrator$Api33BackCallbackDelegate;
        ArrayList arrayList;
        super.onAttachedToWindow();
        LazyKt__LazyJVMKt.setParentAbsoluteElevation(this);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            MatcherMatchResult matcherMatchResult = this.backOrchestrator;
            if (((MaterialBackOrchestrator$Api33BackCallbackDelegate) matcherMatchResult.matcher) != null) {
                DrawerLayout drawerLayout = (DrawerLayout) parent;
                C01921 r2 = this.backDrawerListener;
                if (!(r2 == null || (arrayList = drawerLayout.mListeners) == null)) {
                    arrayList.remove(r2);
                }
                drawerLayout.addDrawerListener(r2);
                if (DrawerLayout.isDrawerOpen(this) && (materialBackOrchestrator$Api33BackCallbackDelegate = (MaterialBackOrchestrator$Api33BackCallbackDelegate) matcherMatchResult.matcher) != null) {
                    materialBackOrchestrator$Api33BackCallbackDelegate.startListeningForBackCallbacks((NavigationView) matcherMatchResult.input, (NavigationView) matcherMatchResult.groups, true);
                }
            }
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            C01921 r1 = this.backDrawerListener;
            if (!(r1 == null || (arrayList = drawerLayout.mListeners) == null)) {
                arrayList.remove(r1);
            }
        }
        MatcherMatchResult matcherMatchResult = this.backOrchestrator;
        MaterialBackOrchestrator$Api33BackCallbackDelegate materialBackOrchestrator$Api33BackCallbackDelegate = (MaterialBackOrchestrator$Api33BackCallbackDelegate) matcherMatchResult.matcher;
        if (materialBackOrchestrator$Api33BackCallbackDelegate != null) {
            materialBackOrchestrator$Api33BackCallbackDelegate.stopListeningForBackCallbacks((NavigationView) matcherMatchResult.groups);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int i3 = this.maxWidth;
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), i3), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        Bundle bundle = savedState.menuState;
        CopyOnWriteArrayList copyOnWriteArrayList = this.menu.mPresenters;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable2 = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.onRestoreInstanceState(parcelable2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, com.google.android.material.navigation.NavigationView$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        absSavedState.menuState = bundle;
        CopyOnWriteArrayList copyOnWriteArrayList = this.menu.mPresenters;
        if (copyOnWriteArrayList.isEmpty()) {
            return absSavedState;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                    sparseArray.put(id, onSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        return absSavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        maybeUpdateCornerSizeForDrawerLayout(i, i2);
    }

    public final Pair requireDrawerLayoutParent() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.LayoutParams)) {
            return new Pair((DrawerLayout) parent, (DrawerLayout.LayoutParams) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    public void setBottomInsetScrimEnabled(boolean z) {
        this.bottomInsetScrimEnabled = z;
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.menu.findItem(i);
        if (findItem != null) {
            this.presenter.adapter.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setDividerInsetEnd(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.dividerInsetEnd = i;
        navigationMenuPresenter.updateAllDividerMenuItems();
    }

    public void setDividerInsetStart(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.dividerInsetStart = i;
        navigationMenuPresenter.updateAllDividerMenuItems();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        LazyKt__LazyJVMKt.setElevation(this, f);
    }

    public void setEndInsetScrimEnabled(boolean z) {
        this.endInsetScrimEnabled = z;
    }

    public void setForceCompatClippingEnabled(boolean z) {
        ShapeableDelegate shapeableDelegate = this.shapeableDelegate;
        if (z != shapeableDelegate.forceCompatClippingEnabled) {
            shapeableDelegate.forceCompatClippingEnabled = z;
            shapeableDelegate.invalidateClippingMethod(this);
        }
    }

    public void setItemBackground(Drawable drawable) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemBackground = drawable;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(getContext().getDrawable(i));
    }

    public void setItemHorizontalPadding(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemHorizontalPadding = i;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemHorizontalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemHorizontalPadding = dimensionPixelSize;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemIconPadding(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemIconPadding = i;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemIconPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemIconPadding = dimensionPixelSize;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemIconSize(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter.itemIconSize != i) {
            navigationMenuPresenter.itemIconSize = i;
            navigationMenuPresenter.hasCustomItemIconSize = true;
            navigationMenuPresenter.updateAllTextMenuItems();
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.iconTintList = colorStateList;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemMaxLines(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemMaxLines = i;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemTextAppearance(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.textAppearance = i;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.textAppearanceActiveBoldEnabled = z;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.textColor = colorStateList;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemVerticalPadding(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemVerticalPadding = i;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setItemVerticalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.itemVerticalPadding = dimensionPixelSize;
        navigationMenuPresenter.updateAllTextMenuItems();
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.overScrollMode = i;
            NavigationMenuView navigationMenuView = navigationMenuPresenter.menuView;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    public void setStartInsetScrimEnabled(boolean z) {
        this.startInsetScrimEnabled = z;
    }

    public void setSubheaderInsetEnd(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.subheaderInsetEnd = i;
        navigationMenuPresenter.updateAllSubHeaderMenuItems();
    }

    public void setSubheaderInsetStart(int i) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        navigationMenuPresenter.subheaderInsetStart = i;
        navigationMenuPresenter.updateAllSubHeaderMenuItems();
    }

    public void setTopInsetScrimEnabled(boolean z) {
        this.topInsetScrimEnabled = z;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void startBackProgress(BackEventCompat backEventCompat) {
        requireDrawerLayoutParent();
        this.sideContainerBackHelper.backEvent = backEventCompat;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void updateBackProgress(BackEventCompat backEventCompat) {
        boolean z;
        float f = backEventCompat.progress;
        int i = ((DrawerLayout.LayoutParams) requireDrawerLayoutParent().second).gravity;
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper.backEvent == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = materialSideContainerBackHelper.backEvent;
        materialSideContainerBackHelper.backEvent = backEventCompat;
        if (backEventCompat2 != null) {
            if (backEventCompat.swipeEdge == 0) {
                z = true;
            } else {
                z = false;
            }
            materialSideContainerBackHelper.updateBackProgress(f, z, i);
        }
        if (this.drawerLayoutCornerSizeBackAnimationEnabled) {
            this.drawerLayoutCornerSize = AnimationUtils.lerp(0, materialSideContainerBackHelper.progressInterpolator.getInterpolation(f), this.drawerLayoutCornerSizeBackAnimationMax);
            maybeUpdateCornerSizeForDrawerLayout(getWidth(), getHeight());
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.adapter.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
