package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ViewCompat;
import com.emanuelef.remote_capture.C0130R;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    public Drawable mTickMark;
    public final AppCompatSeekBar mView;
    public ColorStateList mTickMarkTintList = null;
    public PorterDuff.Mode mTickMarkTintMode = null;
    public boolean mHasTickMarkTint = false;
    public boolean mHasTickMarkTintMode = false;

    public AppCompatSeekBarHelper(AppCompatSeekBar appCompatSeekBar) {
        super(appCompatSeekBar);
        this.mView = appCompatSeekBar;
    }

    public final void applyTickMarkTint() {
        Drawable drawable = this.mTickMark;
        if (drawable == null) {
            return;
        }
        if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
            Drawable wrap = BundleKt.wrap(drawable.mutate());
            this.mTickMark = wrap;
            if (this.mHasTickMarkTint) {
                DrawableCompat$Api21Impl.setTintList(wrap, this.mTickMarkTintList);
            }
            if (this.mHasTickMarkTintMode) {
                DrawableCompat$Api21Impl.setTintMode(this.mTickMark, this.mTickMarkTintMode);
            }
            if (this.mTickMark.isStateful()) {
                this.mTickMark.setState(this.mView.getDrawableState());
            }
        }
    }

    public final void drawTickMarks(Canvas canvas) {
        int i;
        if (this.mTickMark != null) {
            AppCompatSeekBar appCompatSeekBar = this.mView;
            int max = appCompatSeekBar.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i = intrinsicWidth / 2;
                } else {
                    i = 1;
                }
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.mTickMark.setBounds(-i, -i2, i, i2);
                float width = ((appCompatSeekBar.getWidth() - appCompatSeekBar.getPaddingLeft()) - appCompatSeekBar.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(appCompatSeekBar.getPaddingLeft(), appCompatSeekBar.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        super.loadFromAttributes(attributeSet, C0130R.attr.seekBarStyle);
        AppCompatSeekBar appCompatSeekBar = this.mView;
        Context context = appCompatSeekBar.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(context, attributeSet, iArr, C0130R.attr.seekBarStyle);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes.input;
        ViewCompat.saveAttributeDataForStyleable(appCompatSeekBar, appCompatSeekBar.getContext(), iArr, attributeSet, (TypedArray) obtainStyledAttributes.input, C0130R.attr.seekBarStyle);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            appCompatSeekBar.setThumb(drawableIfKnown);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(appCompatSeekBar);
            BundleKt.setLayoutDirection(drawable, appCompatSeekBar.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(appCompatSeekBar.getDrawableState());
            }
            applyTickMarkTint();
        }
        appCompatSeekBar.invalidate();
        if (typedArray.hasValue(3)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(typedArray.getInt(3, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        if (typedArray.hasValue(2)) {
            this.mTickMarkTintList = obtainStyledAttributes.getColorStateList(2);
            this.mHasTickMarkTint = true;
        }
        obtainStyledAttributes.recycle();
        applyTickMarkTint();
    }
}
