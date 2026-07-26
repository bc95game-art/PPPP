package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.widget.TintableCompoundDrawablesView;
import androidx.navigation.internal.NavDestinationImpl;
/* loaded from: classes.dex */
public final class AppCompatToggleButton extends ToggleButton implements TintableCompoundDrawablesView {
    public AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    public final NavDestinationImpl mBackgroundTintHelper;
    public final AppCompatTextHelper mTextHelper;

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842827);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        NavDestinationImpl navDestinationImpl = new NavDestinationImpl(this);
        this.mBackgroundTintHelper = navDestinationImpl;
        navDestinationImpl.loadFromAttributes(attributeSet, 16842827);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, 16842827);
        getEmojiTextViewHelper().loadFromAttributes(attributeSet, 16842827);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            return navDestinationImpl.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            return navDestinationImpl.getSupportBackgroundTintMode();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().setEnabled(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().getFilters(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintList(colorStateList);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        appCompatTextHelper.setCompoundDrawableTintMode(mode);
        appCompatTextHelper.applyCompoundDrawablesTints();
    }
}
