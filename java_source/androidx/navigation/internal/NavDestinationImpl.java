package androidx.navigation.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.core.view.ViewCompat;
import androidx.navigation.NavDestination;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class NavDestinationImpl {
    public Object arguments;
    public Object deepLinks;
    public final Object destination;

    /* renamed from: id */
    public int f12id;
    public Object idName;
    public Object route;

    public NavDestinationImpl(NavDestination navDestination) {
        this.destination = navDestination;
        this.deepLinks = new ArrayList();
        this.arguments = new LinkedHashMap();
    }

    public void applySupportBackgroundTint() {
        View view = (View) this.destination;
        Drawable background = view.getBackground();
        if (background != null) {
            int i = Build.VERSION.SDK_INT;
            if (i <= 21 ? i == 21 : ((TintInfo) this.route) != null) {
                if (((TintInfo) this.arguments) == null) {
                    this.arguments = new Object();
                }
                TintInfo tintInfo = (TintInfo) this.arguments;
                tintInfo.mTintList = null;
                tintInfo.mHasTintList = false;
                tintInfo.mTintMode = null;
                tintInfo.mHasTintMode = false;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ColorStateList backgroundTintList = ViewCompat.Api21Impl.getBackgroundTintList(view);
                if (backgroundTintList != null) {
                    tintInfo.mHasTintList = true;
                    tintInfo.mTintList = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = ViewCompat.Api21Impl.getBackgroundTintMode(view);
                if (backgroundTintMode != null) {
                    tintInfo.mHasTintMode = true;
                    tintInfo.mTintMode = backgroundTintMode;
                }
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    AppCompatDrawableManager.tintDrawable(background, tintInfo, view.getDrawableState());
                    return;
                }
            }
            TintInfo tintInfo2 = (TintInfo) this.deepLinks;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.tintDrawable(background, tintInfo2, view.getDrawableState());
                return;
            }
            TintInfo tintInfo3 = (TintInfo) this.route;
            if (tintInfo3 != null) {
                AppCompatDrawableManager.tintDrawable(background, tintInfo3, view.getDrawableState());
            }
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        TintInfo tintInfo = (TintInfo) this.deepLinks;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo tintInfo = (TintInfo) this.deepLinks;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        ColorStateList tintList;
        View view = (View) this.destination;
        Context context = view.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes.input;
        View view2 = (View) this.destination;
        ViewCompat.saveAttributeDataForStyleable(view2, view2.getContext(), iArr, attributeSet, (TypedArray) obtainStyledAttributes.input, i);
        boolean z = false;
        try {
            if (typedArray.hasValue(0)) {
                this.f12id = typedArray.getResourceId(0, -1);
                AppCompatDrawableManager appCompatDrawableManager = (AppCompatDrawableManager) this.idName;
                Context context2 = view.getContext();
                int i2 = this.f12id;
                synchronized (appCompatDrawableManager) {
                    tintList = appCompatDrawableManager.mResourceManager.getTintList(context2, i2);
                }
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            if (typedArray.hasValue(1)) {
                ViewCompat.setBackgroundTintList(view, obtainStyledAttributes.getColorStateList(1));
            }
            if (typedArray.hasValue(2)) {
                PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(typedArray.getInt(2, -1), null);
                int i3 = Build.VERSION.SDK_INT;
                ViewCompat.Api21Impl.setBackgroundTintMode(view, parseTintMode);
                if (i3 == 21) {
                    Drawable background = view.getBackground();
                    if (!(ViewCompat.Api21Impl.getBackgroundTintList(view) == null && ViewCompat.Api21Impl.getBackgroundTintMode(view) == null)) {
                        z = true;
                    }
                    if (background != null && z) {
                        if (background.isStateful()) {
                            background.setState(view.getDrawableState());
                        }
                        view.setBackground(background);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void onSetBackgroundDrawable() {
        this.f12id = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public void onSetBackgroundResource(int i) {
        ColorStateList colorStateList;
        this.f12id = i;
        AppCompatDrawableManager appCompatDrawableManager = (AppCompatDrawableManager) this.idName;
        if (appCompatDrawableManager != null) {
            Context context = ((View) this.destination).getContext();
            synchronized (appCompatDrawableManager) {
                colorStateList = appCompatDrawableManager.mResourceManager.getTintList(context, i);
            }
        } else {
            colorStateList = null;
        }
        setInternalBackgroundTint(colorStateList);
        applySupportBackgroundTint();
    }

    public void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((TintInfo) this.route) == null) {
                this.route = new Object();
            }
            TintInfo tintInfo = (TintInfo) this.route;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.route = null;
        }
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (((TintInfo) this.deepLinks) == null) {
            this.deepLinks = new Object();
        }
        TintInfo tintInfo = (TintInfo) this.deepLinks;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (((TintInfo) this.deepLinks) == null) {
            this.deepLinks = new Object();
        }
        TintInfo tintInfo = (TintInfo) this.deepLinks;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportBackgroundTint();
    }

    public NavDestinationImpl(View view) {
        this.f12id = -1;
        this.destination = view;
        this.idName = AppCompatDrawableManager.get();
    }
}
