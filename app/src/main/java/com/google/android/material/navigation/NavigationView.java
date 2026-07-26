package com.google.android.material.navigation;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
import androidx.activity.BackEventCompat;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleKt;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator$Api33BackCallbackDelegate;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int[] DISABLED_STATE_SET = {-16842910};
    public final AnonymousClass1 backDrawerListener;
    public final MatcherMatchResult backOrchestrator;
    public int drawerLayoutCornerSize;
    public final boolean drawerLayoutCornerSizeBackAnimationEnabled;
    public final int drawerLayoutCornerSizeBackAnimationMax;
    public OnNavigationItemSelectedListener listener;
    public final int maxWidth;
    public final NavigationMenu menu;
    public SupportMenuInflater menuInflater;
    public final AppCompatSpinner.AnonymousClass2 onGlobalLayoutListener;
    public final NavigationMenuPresenter presenter;
    public final ShapeableDelegate shapeableDelegate;
    public final MaterialSideContainerBackHelper sideContainerBackHelper;
    public final int[] tmpLocation = new int[2];
    public boolean topInsetScrimEnabled = true;
    public boolean bottomInsetScrimEnabled = true;
    public boolean startInsetScrimEnabled = true;
    public boolean endInsetScrimEnabled = true;

    /* renamed from: com.google.android.material.navigation.NavigationView$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 implements OnApplyWindowInsetsListener, MenuBuilder.Callback {
        public /* synthetic */ AnonymousClass2() {
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
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(13);
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
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationView(android.content.Context r19, android.util.AttributeSet r20) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet):void");
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
        if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
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
        materialSideContainerBackHelper.finishBackProgress(backEventCompat, i, new Transition.AnonymousClass2(this, 2, drawerLayout), new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(2, drawerLayout));
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
                AnonymousClass1 r2 = this.backDrawerListener;
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
            AnonymousClass1 r1 = this.backDrawerListener;
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
