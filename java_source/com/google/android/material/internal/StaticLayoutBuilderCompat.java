package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Constructor;
/* loaded from: classes.dex */
public final class StaticLayoutBuilderCompat {
    public static final int DEFAULT_HYPHENATION_FREQUENCY;
    public static Constructor constructor;
    public static boolean initialized;
    public static TextDirectionHeuristic textDirection;
    public int end;
    public boolean isRtl;
    public final TextPaint paint;
    public CharSequence source;
    public InputConnectionCompat$$ExternalSyntheticLambda0 staticLayoutBuilderConfigurer;
    public final int width;
    public Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
    public int maxLines = Integer.MAX_VALUE;
    public float lineSpacingAdd = 0.0f;
    public float lineSpacingMultiplier = 1.0f;
    public int hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
    public boolean includePad = true;
    public TextUtils.TruncateAt ellipsize = null;

    /* loaded from: classes.dex */
    public final class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Exception exc) {
            super("Error thrown initializing StaticLayout " + exc.getMessage(), exc);
        }
    }

    static {
        int i;
        if (Build.VERSION.SDK_INT >= 23) {
            i = 1;
        } else {
            i = 0;
        }
        DEFAULT_HYPHENATION_FREQUENCY = i;
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i;
        this.end = charSequence.length();
    }

    public final StaticLayout build() {
        boolean z;
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2;
        if (this.source == null) {
            this.source = "";
        }
        int max = Math.max(0, this.width);
        CharSequence charSequence = this.source;
        int i = this.maxLines;
        TextPaint textPaint = this.paint;
        if (i == 1) {
            charSequence = TextUtils.ellipsize(charSequence, textPaint, max, this.ellipsize);
        }
        int min = Math.min(charSequence.length(), this.end);
        this.end = min;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (this.isRtl && this.maxLines == 1) {
                this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
            obtain.setAlignment(this.alignment);
            obtain.setIncludePad(this.includePad);
            if (this.isRtl) {
                textDirectionHeuristic2 = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic2 = TextDirectionHeuristics.LTR;
            }
            obtain.setTextDirection(textDirectionHeuristic2);
            TextUtils.TruncateAt truncateAt = this.ellipsize;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.maxLines);
            float f = this.lineSpacingAdd;
            if (!(f == 0.0f && this.lineSpacingMultiplier == 1.0f)) {
                obtain.setLineSpacing(f, this.lineSpacingMultiplier);
            }
            if (this.maxLines > 1) {
                obtain.setHyphenationFrequency(this.hyphenationFrequency);
            }
            InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = this.staticLayoutBuilderConfigurer;
            if (inputConnectionCompat$$ExternalSyntheticLambda0 != null) {
                TextInputLayout textInputLayout = (TextInputLayout) inputConnectionCompat$$ExternalSyntheticLambda0.f$0;
                if (i2 >= 23) {
                    obtain.setBreakStrategy(textInputLayout.placeholderTextView.getBreakStrategy());
                } else {
                    int[][] iArr = TextInputLayout.EDIT_TEXT_BACKGROUND_RIPPLE_STATE;
                }
            }
            return obtain.build();
        }
        if (!initialized) {
            try {
                if (!this.isRtl || i2 < 23) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                } else {
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                }
                textDirection = textDirectionHeuristic;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                constructor = declaredConstructor;
                declaredConstructor.setAccessible(true);
                initialized = true;
            } catch (Exception e) {
                throw new StaticLayoutBuilderCompatException(e);
            }
        }
        try {
            Constructor constructor2 = constructor;
            constructor2.getClass();
            Integer valueOf = Integer.valueOf(this.end);
            Integer valueOf2 = Integer.valueOf(max);
            Layout.Alignment alignment = this.alignment;
            TextDirectionHeuristic textDirectionHeuristic3 = textDirection;
            textDirectionHeuristic3.getClass();
            return (StaticLayout) constructor2.newInstance(charSequence, 0, valueOf, textPaint, valueOf2, alignment, textDirectionHeuristic3, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.includePad), null, Integer.valueOf(max), Integer.valueOf(this.maxLines));
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }
}
