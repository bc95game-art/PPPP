package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.ResourcesCompat;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class TextAppearance {
    public Typeface font;
    public final String fontFamily;
    public final int fontFamilyResourceId;
    public final String fontVariationSettings;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public ColorStateList textColor;
    public float textSize;
    public final int textStyle;
    public final int typeface;
    public boolean fontResolved = false;
    public boolean systemFontLoadAttempted = false;

    public TextAppearance(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(0, 0.0f);
        int i2 = 3;
        this.textColor = LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 3);
        LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 4);
        LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 5);
        this.textStyle = obtainStyledAttributes.getInt(2, 0);
        this.typeface = obtainStyledAttributes.getInt(1, 1);
        int i3 = !obtainStyledAttributes.hasValue(12) ? 10 : 12;
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(i3, 0);
        this.fontFamily = obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getBoolean(14, false);
        this.shadowColor = LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 6);
        this.shadowDx = obtainStyledAttributes.getFloat(7, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(8, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.MaterialTextAppearance);
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(0);
        this.letterSpacing = obtainStyledAttributes2.getFloat(0, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.fontVariationSettings = obtainStyledAttributes2.getString(!obtainStyledAttributes2.hasValue(3) ? 1 : i2);
        }
        obtainStyledAttributes2.recycle();
    }

    public final void createFallbackFont() {
        String str;
        Typeface typeface = this.font;
        int i = this.textStyle;
        if (typeface == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, i);
        }
        if (this.font == null) {
            int i2 = this.typeface;
            if (i2 == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.font = Typeface.SERIF;
            } else if (i2 != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            this.font = Typeface.create(this.font, i);
        }
    }

    public final void getFontAsync(Context context, final LazyKt__LazyJVMKt lazyKt__LazyJVMKt) {
        if (!maybeLoadFontSynchronously(context)) {
            createFallbackFont();
        }
        int i = this.fontFamilyResourceId;
        if (i == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            lazyKt__LazyJVMKt.onFontRetrieved(this.font, true);
            return;
        }
        try {
            ResourcesCompat.FontCallback fontCallback = new ResourcesCompat.FontCallback() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public final void onFontRetrievalFailed(int i2) {
                    TextAppearance.this.fontResolved = true;
                    lazyKt__LazyJVMKt.onFontRetrievalFailed(i2);
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public final void onFontRetrieved(Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                    textAppearance.fontResolved = true;
                    lazyKt__LazyJVMKt.onFontRetrieved(textAppearance.font, false);
                }
            };
            ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
            if (context.isRestricted()) {
                fontCallback.callbackFailAsync(-4, null);
            } else {
                ResourcesCompat.loadFont(context, i, new TypedValue(), 0, fontCallback, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            lazyKt__LazyJVMKt.onFontRetrievalFailed(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.fontFamily, e);
            this.fontResolved = true;
            lazyKt__LazyJVMKt.onFontRetrievalFailed(-3);
        }
    }

    public final boolean maybeLoadFontSynchronously(Context context) {
        Typeface typeface;
        Context context2;
        String str;
        Typeface create;
        if (this.fontResolved) {
            return true;
        }
        int i = this.fontFamilyResourceId;
        if (i != 0) {
            ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
            Typeface typeface2 = null;
            if (context.isRestricted()) {
                context2 = context;
                typeface = null;
            } else {
                context2 = context;
                typeface = ResourcesCompat.loadFont(context2, i, new TypedValue(), 0, null, false, true);
            }
            if (typeface != null) {
                this.font = typeface;
                this.fontResolved = true;
                return true;
            }
            if (!this.systemFontLoadAttempted) {
                this.systemFontLoadAttempted = true;
                Resources resources = context2.getResources();
                int i2 = this.fontFamilyResourceId;
                if (i2 != 0 && resources.getResourceTypeName(i2).equals("font")) {
                    try {
                        XmlResourceParser xml = resources.getXml(i2);
                        while (xml.getEventType() != 1) {
                            if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R$styleable.FontFamily);
                                str = obtainAttributes.getString(6);
                                obtainAttributes.recycle();
                                break;
                            }
                            xml.next();
                        }
                    } catch (Throwable unused) {
                    }
                }
                str = null;
                if (!(str == null || (create = Typeface.create(str, 0)) == Typeface.DEFAULT)) {
                    typeface2 = Typeface.create(create, this.textStyle);
                }
            }
            if (typeface2 != null) {
                this.font = typeface2;
                this.fontResolved = true;
                return true;
            }
        }
        return false;
    }

    public final void updateDrawState(Context context, TextPaint textPaint, LazyKt__LazyJVMKt lazyKt__LazyJVMKt) {
        int i;
        int i2;
        updateMeasureState(context, textPaint, lazyKt__LazyJVMKt);
        ColorStateList colorStateList = this.textColor;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor());
        } else {
            i = -16777216;
        }
        textPaint.setColor(i);
        ColorStateList colorStateList2 = this.shadowColor;
        if (colorStateList2 != null) {
            i2 = colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor());
        } else {
            i2 = 0;
        }
        textPaint.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, i2);
    }

    public final void updateMeasureState(final Context context, final TextPaint textPaint, final LazyKt__LazyJVMKt lazyKt__LazyJVMKt) {
        Typeface typeface;
        if (!maybeLoadFontSynchronously(context) || !this.fontResolved || (typeface = this.font) == null) {
            createFallbackFont();
            updateTextPaintMeasureState(context, textPaint, this.font);
            getFontAsync(context, new LazyKt__LazyJVMKt() { // from class: com.google.android.material.resources.TextAppearance.2
                @Override // kotlin.LazyKt__LazyJVMKt
                public final void onFontRetrievalFailed(int i) {
                    lazyKt__LazyJVMKt.onFontRetrievalFailed(i);
                }

                @Override // kotlin.LazyKt__LazyJVMKt
                public final void onFontRetrieved(Typeface typeface2, boolean z) {
                    TextAppearance.this.updateTextPaintMeasureState(context, textPaint, typeface2);
                    lazyKt__LazyJVMKt.onFontRetrieved(typeface2, z);
                }
            });
            return;
        }
        updateTextPaintMeasureState(context, textPaint, typeface);
    }

    public final void updateTextPaintMeasureState(Context context, TextPaint textPaint, Typeface typeface) {
        boolean z;
        float f;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(context.getResources().getConfiguration(), typeface);
        if (maybeCopyWithFontWeightAdjustment != null) {
            typeface = maybeCopyWithFontWeightAdjustment;
        }
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.textStyle;
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        textPaint.setFakeBoldText(z);
        if ((i & 2) != 0) {
            f = -0.25f;
        } else {
            f = 0.0f;
        }
        textPaint.setTextSkewX(f);
        textPaint.setTextSize(this.textSize);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(this.fontVariationSettings);
        }
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }
}
