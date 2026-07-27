package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R$styleable;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import androidx.navigation.internal.NavDestinationImpl;
import com.emanuelef.remote_capture.C0130R;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class AppCompatCheckedTextView extends CheckedTextView implements TintableCompoundDrawablesView {
    public AppCompatEmojiTextHelper mAppCompatEmojiTextHelper;
    public final NavDestinationImpl mBackgroundTintHelper;
    public final AppCompatCompoundButtonHelper mCheckedHelper = new AppCompatCompoundButtonHelper(this);
    public final AppCompatTextHelper mTextHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085 A[Catch: all -> 0x0064, TryCatch #1 {all -> 0x0064, blocks: (B:3:0x004b, B:5:0x0052, B:7:0x0058, B:10:0x0067, B:12:0x006d, B:14:0x0073, B:15:0x007e, B:17:0x0085, B:18:0x008c, B:20:0x0093), top: B:28:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #1 {all -> 0x0064, blocks: (B:3:0x004b, B:5:0x0052, B:7:0x0058, B:10:0x0067, B:12:0x006d, B:14:0x0073, B:15:0x007e, B:17:0x0085, B:18:0x008c, B:20:0x0093), top: B:28:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0130R.attr.checkedTextViewStyle);
        int resourceId;
        int resourceId2;
        TintContextWrapper.wrap(context);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, C0130R.attr.checkedTextViewStyle);
        appCompatTextHelper.applyCompoundDrawablesTints();
        NavDestinationImpl navDestinationImpl = new NavDestinationImpl(this);
        this.mBackgroundTintHelper = navDestinationImpl;
        navDestinationImpl.loadFromAttributes(attributeSet, C0130R.attr.checkedTextViewStyle);
        Context context2 = getContext();
        int[] iArr = R$styleable.CheckedTextView;
        MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(context2, attributeSet, iArr, C0130R.attr.checkedTextViewStyle);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes.input;
        ViewCompat.saveAttributeDataForStyleable(this, getContext(), iArr, attributeSet, (TypedArray) obtainStyledAttributes.input, C0130R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(BundleKt.getDrawable(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
                if (typedArray.hasValue(2)) {
                    setCheckMarkTintList(obtainStyledAttributes.getColorStateList(2));
                }
                if (typedArray.hasValue(3)) {
                    setCheckMarkTintMode(DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
                }
                obtainStyledAttributes.recycle();
                getEmojiTextViewHelper().loadFromAttributes(attributeSet, C0130R.attr.checkedTextViewStyle);
            }
            if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(BundleKt.getDrawable(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
            }
            if (typedArray.hasValue(3)) {
            }
            obtainStyledAttributes.recycle();
            getEmojiTextViewHelper().loadFromAttributes(attributeSet, C0130R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mAppCompatEmojiTextHelper;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.applySupportBackgroundTint();
        }
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.applyCheckMarkTint();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
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

    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.mButtonTintList;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.mButtonTintMode;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        BundleKt.onCreateInputConnection(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().setAllCaps(z);
    }

    @Override // android.view.View
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

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper == null) {
            return;
        }
        if (appCompatCompoundButtonHelper.mSkipNextApply) {
            appCompatCompoundButtonHelper.mSkipNextApply = false;
            return;
        }
        appCompatCompoundButtonHelper.mSkipNextApply = true;
        appCompatCompoundButtonHelper.applyCheckMarkTint();
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().setEnabled(z);
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

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.mButtonTintList = colorStateList;
            appCompatCompoundButtonHelper.mHasButtonTint = true;
            appCompatCompoundButtonHelper.applyCheckMarkTint();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.mCheckedHelper;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.mButtonTintMode = mode;
            appCompatCompoundButtonHelper.mHasButtonTintMode = true;
            appCompatCompoundButtonHelper.applyCheckMarkTint();
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

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(BundleKt.getDrawable(getContext(), i));
    }
}
