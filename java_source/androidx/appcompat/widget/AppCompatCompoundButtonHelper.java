package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat$Api21Impl;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class AppCompatCompoundButtonHelper {
    public ColorStateList mButtonTintList = null;
    public PorterDuff.Mode mButtonTintMode = null;
    public boolean mHasButtonTint = false;
    public boolean mHasButtonTintMode = false;
    public boolean mSkipNextApply;
    public final TextView mView;

    public /* synthetic */ AppCompatCompoundButtonHelper(TextView textView) {
        this.mView = textView;
    }

    public void applyButtonTint() {
        CompoundButton compoundButton = (CompoundButton) this.mView;
        Drawable buttonDrawable = BundleKt.getButtonDrawable(compoundButton);
        if (buttonDrawable == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            Drawable mutate = BundleKt.wrap(buttonDrawable).mutate();
            if (this.mHasButtonTint) {
                DrawableCompat$Api21Impl.setTintList(mutate, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                DrawableCompat$Api21Impl.setTintMode(mutate, this.mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(compoundButton.getDrawableState());
            }
            compoundButton.setButtonDrawable(mutate);
        }
    }

    public void applyCheckMarkTint() {
        AppCompatCheckedTextView appCompatCheckedTextView = (AppCompatCheckedTextView) this.mView;
        Drawable checkMarkDrawable = appCompatCheckedTextView.getCheckMarkDrawable();
        if (checkMarkDrawable == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            Drawable mutate = BundleKt.wrap(checkMarkDrawable).mutate();
            if (this.mHasButtonTint) {
                DrawableCompat$Api21Impl.setTintList(mutate, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                DrawableCompat$Api21Impl.setTintMode(mutate, this.mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(appCompatCheckedTextView.getDrawableState());
            }
            appCompatCheckedTextView.setCheckMarkDrawable(mutate);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:7:0x002f, B:10:0x003e, B:12:0x0044, B:14:0x004a, B:15:0x0055, B:17:0x005c, B:18:0x0063, B:20:0x006a), top: B:28:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {all -> 0x003b, blocks: (B:3:0x0022, B:5:0x0029, B:7:0x002f, B:10:0x003e, B:12:0x0044, B:14:0x004a, B:15:0x0055, B:17:0x005c, B:18:0x0063, B:20:0x006a), top: B:28:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.mView;
        Context context = compoundButton.getContext();
        int[] iArr = R$styleable.CompoundButton;
        MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes.input;
        ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) obtainStyledAttributes.input, i);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(BundleKt.getDrawable(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
                if (typedArray.hasValue(2)) {
                    CompoundButtonCompat$Api21Impl.setButtonTintList(compoundButton, obtainStyledAttributes.getColorStateList(2));
                }
                if (typedArray.hasValue(3)) {
                    CompoundButtonCompat$Api21Impl.setButtonTintMode(compoundButton, DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null));
                }
                obtainStyledAttributes.recycle();
            }
            if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(BundleKt.getDrawable(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
            }
            if (typedArray.hasValue(3)) {
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
