package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import androidx.core.p002os.BundleKt;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.android.billingclient.api.zzcn;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TypefaceUtils;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public final class CollapsingTextHelper {
    public boolean alignBaselineAtBottom;
    public boolean boundsChanged;
    public float collapsedDrawX;
    public float collapsedDrawY;
    public CancelableFontCallback collapsedFontCallback;
    public float collapsedLetterSpacing;
    public ColorStateList collapsedShadowColor;
    public float collapsedShadowDx;
    public float collapsedShadowDy;
    public float collapsedShadowRadius;
    public float collapsedTextBlend;
    public ColorStateList collapsedTextColor;
    public float collapsedTextWidth;
    public Typeface collapsedTypeface;
    public Typeface collapsedTypefaceBold;
    public Typeface collapsedTypefaceDefault;
    public float currentDrawX;
    public float currentDrawY;
    public float currentLetterSpacing;
    public int currentMaxLines;
    public int currentShadowColor;
    public float currentShadowDx;
    public float currentShadowDy;
    public float currentShadowRadius;
    public float currentTextSize;
    public Typeface currentTypeface;
    public float expandedDrawX;
    public float expandedDrawY;
    public float expandedFraction;
    public float expandedLetterSpacing;
    public int expandedLineCount;
    public float expandedTextBlend;
    public ColorStateList expandedTextColor;
    public Typeface expandedTypeface;
    public Typeface expandedTypefaceBold;
    public Typeface expandedTypefaceDefault;
    public boolean isRtl;
    public TimeInterpolator positionInterpolator;
    public float scale;
    public int[] state;
    public CharSequence text;
    public StaticLayout textLayout;
    public final TextPaint textPaint;
    public TimeInterpolator textSizeInterpolator;
    public CharSequence textToDraw;
    public CharSequence textToDrawCollapsed;
    public final TextPaint tmpPaint;
    public final TextInputLayout view;
    public int expandedTextGravity = 16;
    public int collapsedTextGravity = 16;
    public float expandedTextSize = 15.0f;
    public float collapsedTextSize = 15.0f;
    public final TextUtils.TruncateAt titleTextEllipsize = TextUtils.TruncateAt.END;
    public final boolean isRtlTextDirectionHeuristicsEnabled = true;
    public int expandedMaxLines = 1;
    public int collapsedMaxLines = 1;
    public final float lineSpacingMultiplier = 1.0f;
    public final int hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
    public int collapsedHeight = -1;
    public int expandedHeight = -1;
    public final Rect collapsedBounds = new Rect();
    public final Rect expandedBounds = new Rect();
    public final RectF currentBounds = new RectF();

    public CollapsingTextHelper(TextInputLayout textInputLayout) {
        this.view = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.textPaint = textPaint;
        this.tmpPaint = new TextPaint(textPaint);
        maybeUpdateFontWeightAdjustment(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int blendARGB(int i, float f, int i2) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), Math.round((Color.red(i2) * f) + (Color.red(i) * f2)), Math.round((Color.green(i2) * f) + (Color.green(i) * f2)), Math.round((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static float lerp(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return AnimationUtils.lerp(f, f2, f3);
    }

    public final void calculateCurrentOffsets() {
        float f = this.expandedFraction;
        Rect rect = this.expandedBounds;
        Rect rect2 = this.collapsedBounds;
        float lerp = lerp(rect.left, rect2.left, f, this.positionInterpolator);
        RectF rectF = this.currentBounds;
        rectF.left = lerp;
        rectF.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        rectF.right = lerp(rect.right, rect2.right, f, this.positionInterpolator);
        rectF.bottom = lerp(rect.bottom, rect2.bottom, f, this.positionInterpolator);
        this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
        this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        calculateUsingTextSize(f, false);
        TextInputLayout textInputLayout = this.view;
        textInputLayout.postInvalidateOnAnimation();
        FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        this.collapsedTextBlend = 1.0f - lerp(0.0f, 1.0f, 1.0f - f, fastOutSlowInInterpolator);
        textInputLayout.postInvalidateOnAnimation();
        this.expandedTextBlend = lerp(1.0f, 0.0f, f, fastOutSlowInInterpolator);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.collapsedTextColor;
        ColorStateList colorStateList2 = this.expandedTextColor;
        TextPaint textPaint = this.textPaint;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(blendARGB(getCurrentColor(colorStateList2), f, getCurrentColor(this.collapsedTextColor)));
        } else {
            textPaint.setColor(getCurrentColor(colorStateList));
        }
        float f2 = this.collapsedLetterSpacing;
        float f3 = this.expandedLetterSpacing;
        if (f2 != f3) {
            textPaint.setLetterSpacing(lerp(f3, f2, f, fastOutSlowInInterpolator));
        } else {
            textPaint.setLetterSpacing(f2);
        }
        this.currentShadowRadius = AnimationUtils.lerp(0.0f, this.collapsedShadowRadius, f);
        this.currentShadowDx = AnimationUtils.lerp(0.0f, this.collapsedShadowDx, f);
        this.currentShadowDy = AnimationUtils.lerp(0.0f, this.collapsedShadowDy, f);
        int blendARGB = blendARGB(0, f, getCurrentColor(this.collapsedShadowColor));
        this.currentShadowColor = blendARGB;
        textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final boolean calculateIsRtl(CharSequence charSequence) {
        zzcn zzcnVar;
        boolean z = true;
        if (this.view.getLayoutDirection() != 1) {
            z = false;
        }
        if (!this.isRtlTextDirectionHeuristicsEnabled) {
            return z;
        }
        if (z) {
            zzcnVar = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            zzcnVar = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return zzcnVar.isRtl(charSequence, charSequence.length());
    }

    public final void calculateUsingTextSize(float f, boolean z) {
        Typeface typeface;
        float f2;
        float f3;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        StaticLayout staticLayout;
        boolean z5;
        boolean z6;
        boolean z7;
        float f4;
        if (this.text != null) {
            float width = this.collapsedBounds.width();
            float width2 = this.expandedBounds.width();
            float f5 = 1.0f;
            if (Math.abs(f - 1.0f) < 1.0E-5f) {
                if (shouldTruncateCollapsedToSingleLine()) {
                    f3 = this.collapsedTextSize;
                } else {
                    f3 = this.expandedTextSize;
                }
                if (shouldTruncateCollapsedToSingleLine()) {
                    f2 = this.collapsedLetterSpacing;
                } else {
                    f2 = this.expandedLetterSpacing;
                }
                if (shouldTruncateCollapsedToSingleLine()) {
                    f4 = 1.0f;
                } else {
                    f4 = lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator) / this.expandedTextSize;
                }
                this.scale = f4;
                if (!shouldTruncateCollapsedToSingleLine()) {
                    width = width2;
                }
                typeface = this.collapsedTypeface;
                width2 = width;
            } else {
                f3 = this.expandedTextSize;
                float f6 = this.expandedLetterSpacing;
                typeface = this.expandedTypeface;
                if (Math.abs(f - 0.0f) < 1.0E-5f) {
                    this.scale = 1.0f;
                } else {
                    this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator) / this.expandedTextSize;
                }
                float f7 = this.collapsedTextSize / this.expandedTextSize;
                float f8 = width2 * f7;
                if (!z && f8 > width && shouldTruncateCollapsedToSingleLine()) {
                    width2 = Math.min(width / f7, width2);
                }
                f2 = f6;
            }
            if (f < 0.5f) {
                i = this.expandedMaxLines;
            } else {
                i = this.collapsedMaxLines;
            }
            TextPaint textPaint = this.textPaint;
            boolean z8 = false;
            if (width2 > 0.0f) {
                if (this.currentTextSize != f3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.currentLetterSpacing != f2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.currentTypeface != typeface) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (this.textLayout == null || width2 == staticLayout.getWidth()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (this.currentMaxLines != i) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z2 || z3 || z5 || z4 || z6 || this.boundsChanged) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.currentTextSize = f3;
                this.currentLetterSpacing = f2;
                this.currentTypeface = typeface;
                this.boundsChanged = false;
                this.currentMaxLines = i;
                if (this.scale != 1.0f) {
                    z8 = true;
                }
                textPaint.setLinearText(z8);
                z8 = z7;
            }
            if (this.textToDraw == null || z8) {
                textPaint.setTextSize(this.currentTextSize);
                textPaint.setTypeface(this.currentTypeface);
                textPaint.setLetterSpacing(this.currentLetterSpacing);
                boolean calculateIsRtl = calculateIsRtl(this.text);
                this.isRtl = calculateIsRtl;
                if ((this.expandedMaxLines > 1 || this.collapsedMaxLines > 1) && !calculateIsRtl) {
                    i2 = i;
                } else {
                    i2 = 1;
                }
                CharSequence charSequence = this.text;
                if (!shouldTruncateCollapsedToSingleLine()) {
                    f5 = this.scale;
                }
                StaticLayout createStaticLayout = createStaticLayout(i2, textPaint, charSequence, width2 * f5, this.isRtl);
                this.textLayout = createStaticLayout;
                this.textToDraw = createStaticLayout.getText();
            }
        }
    }

    public final StaticLayout createStaticLayout(int i, TextPaint textPaint, CharSequence charSequence, float f, boolean z) {
        Layout.Alignment alignment;
        StaticLayout staticLayout = null;
        try {
            if (i == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0) & 7;
                if (absoluteGravity == 1) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (absoluteGravity != 5) {
                    if (this.isRtl) {
                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    } else {
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                    }
                } else if (this.isRtl) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                }
            }
            StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(charSequence, textPaint, (int) f);
            staticLayoutBuilderCompat.ellipsize = this.titleTextEllipsize;
            staticLayoutBuilderCompat.isRtl = z;
            staticLayoutBuilderCompat.alignment = alignment;
            staticLayoutBuilderCompat.includePad = false;
            staticLayoutBuilderCompat.maxLines = i;
            float f2 = this.lineSpacingMultiplier;
            staticLayoutBuilderCompat.lineSpacingAdd = 0.0f;
            staticLayoutBuilderCompat.lineSpacingMultiplier = f2;
            staticLayoutBuilderCompat.hyphenationFrequency = this.hyphenationFrequency;
            staticLayoutBuilderCompat.staticLayoutBuilderConfigurer = null;
            staticLayout = staticLayoutBuilderCompat.build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
            Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
        }
        staticLayout.getClass();
        return staticLayout;
    }

    public final float getCollapsedTextHeight() {
        int i = this.collapsedHeight;
        if (i != -1) {
            return i;
        }
        float f = this.collapsedTextSize;
        TextPaint textPaint = this.tmpPaint;
        textPaint.setTextSize(f);
        textPaint.setTypeface(this.collapsedTypeface);
        textPaint.setLetterSpacing(this.collapsedLetterSpacing);
        return -textPaint.ascent();
    }

    public final int getCurrentColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public final void maybeUpdateFontWeightAdjustment(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.collapsedTypefaceDefault;
            if (typeface != null) {
                this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface);
            }
            Typeface typeface2 = this.expandedTypefaceDefault;
            if (typeface2 != null) {
                this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface2);
            }
            Typeface typeface3 = this.collapsedTypefaceBold;
            if (typeface3 == null) {
                typeface3 = this.collapsedTypefaceDefault;
            }
            this.collapsedTypeface = typeface3;
            Typeface typeface4 = this.expandedTypefaceBold;
            if (typeface4 == null) {
                typeface4 = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = typeface4;
            recalculate(true);
        }
    }

    public final void recalculate(boolean z) {
        float f;
        float f2;
        int i;
        CharSequence charSequence;
        TextInputLayout textInputLayout = this.view;
        if ((textInputLayout.getHeight() > 0 && textInputLayout.getWidth() > 0) || z) {
            calculateUsingTextSize(1.0f, z);
            CharSequence charSequence2 = this.textToDraw;
            TextPaint textPaint = this.textPaint;
            if (!(charSequence2 == null || this.textLayout == null)) {
                if (shouldTruncateCollapsedToSingleLine()) {
                    charSequence = TextUtils.ellipsize(this.textToDraw, textPaint, this.textLayout.getWidth(), this.titleTextEllipsize);
                } else {
                    charSequence = this.textToDraw;
                }
                this.textToDrawCollapsed = charSequence;
            }
            CharSequence charSequence3 = this.textToDrawCollapsed;
            float f3 = 0.0f;
            if (charSequence3 != null) {
                this.collapsedTextWidth = textPaint.measureText(charSequence3, 0, charSequence3.length());
            } else {
                this.collapsedTextWidth = 0.0f;
            }
            int absoluteGravity = Gravity.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
            int i2 = absoluteGravity & 112;
            Rect rect = this.collapsedBounds;
            if (i2 == 48) {
                this.collapsedDrawY = rect.top;
            } else if (i2 != 80) {
                this.collapsedDrawY = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
            } else {
                this.collapsedDrawY = textPaint.ascent() + rect.bottom;
            }
            int i3 = absoluteGravity & 8388615;
            if (i3 == 1) {
                this.collapsedDrawX = rect.centerX() - (this.collapsedTextWidth / 2.0f);
            } else if (i3 != 5) {
                this.collapsedDrawX = rect.left;
            } else {
                this.collapsedDrawX = rect.right - this.collapsedTextWidth;
            }
            if (this.collapsedTextWidth <= rect.width()) {
                float f4 = this.collapsedDrawX;
                float max = Math.max(0.0f, rect.left - f4) + f4;
                this.collapsedDrawX = max;
                this.collapsedDrawX = Math.min(0.0f, rect.right - (this.collapsedTextWidth + max)) + max;
            }
            float f5 = this.collapsedTextSize;
            TextPaint textPaint2 = this.tmpPaint;
            textPaint2.setTextSize(f5);
            textPaint2.setTypeface(this.collapsedTypeface);
            textPaint2.setLetterSpacing(this.collapsedLetterSpacing);
            if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
                float f6 = this.collapsedDrawY;
                float max2 = Math.max(0.0f, rect.top - f6) + f6;
                this.collapsedDrawY = max2;
                this.collapsedDrawY = Math.min(0.0f, rect.bottom - (getCollapsedTextHeight() + max2)) + max2;
            }
            calculateUsingTextSize(0.0f, z);
            StaticLayout staticLayout = this.textLayout;
            if (staticLayout != null) {
                f = staticLayout.getHeight();
            } else {
                f = 0.0f;
            }
            StaticLayout staticLayout2 = this.textLayout;
            if (staticLayout2 == null || this.expandedMaxLines <= 1) {
                CharSequence charSequence4 = this.textToDraw;
                if (charSequence4 != null) {
                    f2 = textPaint.measureText(charSequence4, 0, charSequence4.length());
                } else {
                    f2 = 0.0f;
                }
            } else {
                f2 = staticLayout2.getWidth();
            }
            StaticLayout staticLayout3 = this.textLayout;
            if (staticLayout3 != null) {
                i = staticLayout3.getLineCount();
            } else {
                i = 0;
            }
            this.expandedLineCount = i;
            int absoluteGravity2 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
            int i4 = absoluteGravity2 & 112;
            Rect rect2 = this.expandedBounds;
            if (i4 == 48) {
                this.expandedDrawY = rect2.top;
            } else if (i4 != 80) {
                this.expandedDrawY = rect2.centerY() - (f / 2.0f);
            } else {
                float f7 = rect2.bottom - f;
                if (this.alignBaselineAtBottom) {
                    f3 = textPaint.descent();
                }
                this.expandedDrawY = f7 + f3;
            }
            int i5 = absoluteGravity2 & 8388615;
            if (i5 == 1) {
                this.expandedDrawX = rect2.centerX() - (f2 / 2.0f);
            } else if (i5 != 5) {
                this.expandedDrawX = rect2.left;
            } else {
                this.expandedDrawX = rect2.right - f2;
            }
            calculateUsingTextSize(this.expandedFraction, false);
            textInputLayout.postInvalidateOnAnimation();
            calculateCurrentOffsets();
        }
    }

    public final void setCollapsedAndExpandedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList || this.expandedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            this.expandedTextColor = colorStateList;
            recalculate(false);
        }
    }

    public final boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        if (this.collapsedTypefaceDefault == typeface) {
            return false;
        }
        this.collapsedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.collapsedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.collapsedTypefaceDefault;
        }
        this.collapsedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    public final void setExpansionFraction(float f) {
        float clamp = BundleKt.clamp(f, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    public final void setTypefaces(Typeface typeface) {
        boolean z;
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        if (this.expandedTypefaceDefault != typeface) {
            this.expandedTypefaceDefault = typeface;
            Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
            this.expandedTypefaceBold = maybeCopyWithFontWeightAdjustment;
            if (maybeCopyWithFontWeightAdjustment == null) {
                maybeCopyWithFontWeightAdjustment = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = maybeCopyWithFontWeightAdjustment;
            z = true;
        } else {
            z = false;
        }
        if (collapsedTypefaceInternal || z) {
            recalculate(false);
        }
    }

    public final boolean shouldTruncateCollapsedToSingleLine() {
        if (this.collapsedMaxLines == 1) {
            return true;
        }
        return false;
    }
}
