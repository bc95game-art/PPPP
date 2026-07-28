package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import androidx.lifecycle.ViewModelProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class AppCompatTextHelper {
    public boolean mAsyncFontPending;
    public final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    public TintInfo mDrawableBottomTint;
    public TintInfo mDrawableEndTint;
    public TintInfo mDrawableLeftTint;
    public TintInfo mDrawableRightTint;
    public TintInfo mDrawableStartTint;
    public TintInfo mDrawableTint;
    public TintInfo mDrawableTopTint;
    public Typeface mFontTypeface;
    public final TextView mView;
    public int mStyle = 0;
    public int mFontWeight = -1;

    /* loaded from: classes.dex */
    public abstract class Api21Impl {
        public static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api24Impl {
        public static LocaleList forLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void setTextLocales(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api26Impl {
        public static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        public static boolean setFontVariationSettings(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api28Impl {
        public static Typeface create(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, androidx.appcompat.widget.TintInfo] */
    public static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList;
        synchronized (appCompatDrawableManager) {
            tintList = appCompatDrawableManager.mResourceManager.getTintList(context, i);
        }
        if (tintList == null) {
            return null;
        }
        ?? obj = new Object();
        obj.mHasTintList = true;
        obj.mTintList = tintList;
        return obj;
    }

    public static void populateSurroundingTextIfNeeded(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i;
        int i2;
        CharSequence charSequence;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i3 >= 30) {
                EditorInfoCompat.Api30Impl.setInitialSurroundingSubText(editorInfo, text);
                return;
            }
            text.getClass();
            if (i3 >= 30) {
                EditorInfoCompat.Api30Impl.setInitialSurroundingSubText(editorInfo, text);
                return;
            }
            int i4 = editorInfo.initialSelStart;
            int i5 = editorInfo.initialSelEnd;
            if (i4 > i5) {
                i = i5;
            } else {
                i = i4;
            }
            if (i4 <= i5) {
                i4 = i5;
            }
            int length = text.length();
            if (i < 0 || i4 > length) {
                EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
                return;
            }
            int i6 = editorInfo.inputType & 4095;
            if (i6 == 129 || i6 == 225 || i6 == 18) {
                EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
            } else if (length <= 2048) {
                EditorInfoCompat.setSurroundingText(editorInfo, text, i, i4);
            } else {
                int i7 = i4 - i;
                if (i7 > 1024) {
                    i2 = 0;
                } else {
                    i2 = i7;
                }
                int i8 = 2048 - i2;
                int min = Math.min(text.length() - i4, i8 - Math.min(i, (int) (i8 * 0.8d)));
                int min2 = Math.min(i, i8 - min);
                int i9 = i - min2;
                if (Character.isLowSurrogate(text.charAt(i9))) {
                    i9++;
                    min2--;
                }
                if (Character.isHighSurrogate(text.charAt((i4 + min) - 1))) {
                    min--;
                }
                int i10 = min2 + i2;
                int i11 = i10 + min;
                if (i2 != i7) {
                    charSequence = TextUtils.concat(text.subSequence(i9, i9 + min2), text.subSequence(i4, min + i4));
                } else {
                    charSequence = text.subSequence(i9, i11 + i9);
                }
                EditorInfoCompat.setSurroundingText(editorInfo, charSequence, min2, i10);
            }
        }
    }

    public final void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    public final void applyCompoundDrawablesTints() {
        TintInfo tintInfo = this.mDrawableLeftTint;
        TextView textView = this.mView;
        if (!(tintInfo == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null)) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }

    public final ColorStateList getCompoundDrawableTintList() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    public final PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:282:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        String str;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        boolean z;
        boolean z2;
        String str2;
        AppCompatDrawableManager appCompatDrawableManager;
        int i2;
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper;
        TypedArray obtainStyledAttributes;
        float f;
        float f2;
        float f3;
        TypedArray obtainStyledAttributes2;
        int resourceId;
        Drawable drawable;
        int resourceId2;
        Drawable drawable2;
        int resourceId3;
        Drawable drawable3;
        int resourceId4;
        Drawable drawable4;
        int resourceId5;
        Drawable drawable5;
        int resourceId6;
        Drawable drawable6;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int i3;
        int i4;
        float f4;
        ColorStateList colorStateList4;
        int resourceId7;
        int[] iArr;
        int resourceId8;
        int length;
        int i5;
        TextView textView = this.mView;
        Context context = textView.getContext();
        AppCompatDrawableManager appCompatDrawableManager2 = AppCompatDrawableManager.get();
        int[] iArr2 = R$styleable.AppCompatTextHelper;
        MatcherMatchResult obtainStyledAttributes3 = MatcherMatchResult.obtainStyledAttributes(context, attributeSet, iArr2, i);
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr2, attributeSet, (TypedArray) obtainStyledAttributes3.input, i);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes3.input;
        int resourceId9 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager2, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager2, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager2, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager2, typedArray.getResourceId(2, 0));
        }
        if (typedArray.hasValue(5)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager2, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager2, typedArray.getResourceId(6, 0));
        }
        obtainStyledAttributes3.recycle();
        boolean z3 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr3 = R$styleable.TextAppearance;
        if (resourceId9 != -1) {
            TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(resourceId9, iArr3);
            MatcherMatchResult matcherMatchResult = new MatcherMatchResult(context, obtainStyledAttributes4);
            if (z3 || !obtainStyledAttributes4.hasValue(14)) {
                z2 = false;
                z = false;
            } else {
                z = obtainStyledAttributes4.getBoolean(14, false);
                z2 = true;
            }
            updateTypefaceAndStyle(context, matcherMatchResult);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 < 23) {
                if (obtainStyledAttributes4.hasValue(3)) {
                    colorStateList3 = matcherMatchResult.getColorStateList(3);
                } else {
                    colorStateList3 = null;
                }
                if (obtainStyledAttributes4.hasValue(4)) {
                    colorStateList2 = matcherMatchResult.getColorStateList(4);
                } else {
                    colorStateList2 = null;
                }
                if (obtainStyledAttributes4.hasValue(5)) {
                    colorStateList = matcherMatchResult.getColorStateList(5);
                    i5 = 15;
                    if (!obtainStyledAttributes4.hasValue(i5)) {
                        str = obtainStyledAttributes4.getString(i5);
                    } else {
                        str = null;
                    }
                    if (i6 >= 26 || !obtainStyledAttributes4.hasValue(13)) {
                        str2 = null;
                    } else {
                        str2 = obtainStyledAttributes4.getString(13);
                    }
                    matcherMatchResult.recycle();
                } else {
                    i5 = 15;
                }
            } else {
                i5 = 15;
                colorStateList3 = null;
                colorStateList2 = null;
            }
            colorStateList = null;
            if (!obtainStyledAttributes4.hasValue(i5)) {
            }
            if (i6 >= 26) {
            }
            str2 = null;
            matcherMatchResult.recycle();
        } else {
            str2 = null;
            z2 = false;
            z = false;
            colorStateList3 = null;
            colorStateList2 = null;
            colorStateList = null;
            str = null;
        }
        TypedArray obtainStyledAttributes5 = context.obtainStyledAttributes(attributeSet, iArr3, i, 0);
        MatcherMatchResult matcherMatchResult2 = new MatcherMatchResult(context, obtainStyledAttributes5);
        if (!z3 && obtainStyledAttributes5.hasValue(14)) {
            z = obtainStyledAttributes5.getBoolean(14, false);
            z2 = true;
        }
        boolean z4 = z;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 23) {
            if (obtainStyledAttributes5.hasValue(3)) {
                colorStateList3 = matcherMatchResult2.getColorStateList(3);
            }
            if (obtainStyledAttributes5.hasValue(4)) {
                colorStateList2 = matcherMatchResult2.getColorStateList(4);
            }
            if (obtainStyledAttributes5.hasValue(5)) {
                colorStateList = matcherMatchResult2.getColorStateList(5);
            }
        }
        ColorStateList colorStateList5 = colorStateList3;
        ColorStateList colorStateList6 = colorStateList2;
        ColorStateList colorStateList7 = colorStateList;
        if (obtainStyledAttributes5.hasValue(15)) {
            str = obtainStyledAttributes5.getString(15);
        }
        String str3 = str;
        if (i7 >= 26 && obtainStyledAttributes5.hasValue(13)) {
            str2 = obtainStyledAttributes5.getString(13);
        }
        if (i7 < 28 || !obtainStyledAttributes5.hasValue(0)) {
            appCompatDrawableManager = appCompatDrawableManager2;
        } else {
            appCompatDrawableManager = appCompatDrawableManager2;
            if (obtainStyledAttributes5.getDimensionPixelSize(0, -1) == 0) {
                textView.setTextSize(0, 0.0f);
            }
        }
        updateTypefaceAndStyle(context, matcherMatchResult2);
        matcherMatchResult2.recycle();
        if (colorStateList5 != null) {
            textView.setTextColor(colorStateList5);
        }
        if (colorStateList6 != null) {
            textView.setHintTextColor(colorStateList6);
        }
        if (colorStateList7 != null) {
            textView.setLinkTextColor(colorStateList7);
        }
        if (!z3 && z2) {
            textView.setAllCaps(z4);
        }
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            if (this.mFontWeight == -1) {
                textView.setTypeface(typeface, this.mStyle);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (str2 != null) {
            Api26Impl.setFontVariationSettings(textView, str2);
        }
        if (str3 != null) {
            if (i7 >= 24) {
                Api24Impl.setTextLocales(textView, Api24Impl.forLanguageTags(str3));
            } else {
                i2 = 0;
                textView.setTextLocale(Api21Impl.forLanguageTag(str3.split(",")[0]));
                appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
                Context context2 = appCompatTextViewAutoSizeHelper.mContext;
                int[] iArr4 = R$styleable.AppCompatTextView;
                obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr4, i, i2);
                TextView textView2 = appCompatTextViewAutoSizeHelper.mTextView;
                ViewCompat.saveAttributeDataForStyleable(textView2, textView2.getContext(), iArr4, attributeSet, obtainStyledAttributes, i);
                if (obtainStyledAttributes.hasValue(5)) {
                    appCompatTextViewAutoSizeHelper.mAutoSizeTextType = obtainStyledAttributes.getInt(5, i2);
                }
                if (!obtainStyledAttributes.hasValue(4)) {
                    f = obtainStyledAttributes.getDimension(4, -1.0f);
                } else {
                    f = -1.0f;
                }
                if (!obtainStyledAttributes.hasValue(2)) {
                    f2 = obtainStyledAttributes.getDimension(2, -1.0f);
                } else {
                    f2 = -1.0f;
                }
                if (!obtainStyledAttributes.hasValue(1)) {
                    f3 = obtainStyledAttributes.getDimension(1, -1.0f);
                } else {
                    f3 = -1.0f;
                }
                if (obtainStyledAttributes.hasValue(3) && (resourceId8 = obtainStyledAttributes.getResourceId(3, 0)) > 0) {
                    TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId8);
                    length = obtainTypedArray.length();
                    int[] iArr5 = new int[length];
                    if (length > 0) {
                        for (int i8 = 0; i8 < length; i8++) {
                            iArr5[i8] = obtainTypedArray.getDimensionPixelSize(i8, -1);
                        }
                        appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArr5);
                        appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration();
                    }
                    obtainTypedArray.recycle();
                }
                obtainStyledAttributes.recycle();
                if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
                    appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
                } else if (appCompatTextViewAutoSizeHelper.mAutoSizeTextType == 1) {
                    if (!appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues) {
                        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                        if (f2 == -1.0f) {
                            f2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                        }
                        if (f3 == -1.0f) {
                            f3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                        }
                        float f5 = f3;
                        if (f == -1.0f) {
                            f = 1.0f;
                        }
                        appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(f2, f5, f);
                    }
                    appCompatTextViewAutoSizeHelper.setupAutoSizeText();
                }
                if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && appCompatTextViewAutoSizeHelper.mAutoSizeTextType != 0) {
                    iArr = appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx;
                    if (iArr.length > 0) {
                        if (Api26Impl.getAutoSizeStepGranularity(textView) != -1.0f) {
                            Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(textView, Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx), 0);
                        } else {
                            Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(textView, iArr, 0);
                        }
                    }
                }
                obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr4);
                resourceId = obtainStyledAttributes2.getResourceId(8, -1);
                AppCompatDrawableManager appCompatDrawableManager3 = appCompatDrawableManager;
                if (resourceId == -1) {
                    drawable = appCompatDrawableManager3.getDrawable(context, resourceId);
                } else {
                    drawable = null;
                }
                resourceId2 = obtainStyledAttributes2.getResourceId(13, -1);
                if (resourceId2 == -1) {
                    drawable2 = appCompatDrawableManager3.getDrawable(context, resourceId2);
                } else {
                    drawable2 = null;
                }
                resourceId3 = obtainStyledAttributes2.getResourceId(9, -1);
                if (resourceId3 == -1) {
                    drawable3 = appCompatDrawableManager3.getDrawable(context, resourceId3);
                } else {
                    drawable3 = null;
                }
                resourceId4 = obtainStyledAttributes2.getResourceId(6, -1);
                if (resourceId4 == -1) {
                    drawable4 = appCompatDrawableManager3.getDrawable(context, resourceId4);
                } else {
                    drawable4 = null;
                }
                resourceId5 = obtainStyledAttributes2.getResourceId(10, -1);
                if (resourceId5 == -1) {
                    drawable5 = appCompatDrawableManager3.getDrawable(context, resourceId5);
                } else {
                    drawable5 = null;
                }
                resourceId6 = obtainStyledAttributes2.getResourceId(7, -1);
                if (resourceId6 == -1) {
                    drawable6 = appCompatDrawableManager3.getDrawable(context, resourceId6);
                } else {
                    drawable6 = null;
                }
                if (drawable5 == null || drawable6 != null) {
                    Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
                    if (drawable5 == null) {
                        drawable5 = compoundDrawablesRelative[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative[1];
                    }
                    if (drawable6 == null) {
                        drawable6 = compoundDrawablesRelative[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative[3];
                    }
                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
                } else if (!(drawable == null && drawable2 == null && drawable3 == null && drawable4 == null)) {
                    Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                        Drawable[] compoundDrawables = textView.getCompoundDrawables();
                        if (drawable == null) {
                            drawable = compoundDrawables[0];
                        }
                        if (drawable2 == null) {
                            drawable2 = compoundDrawables[1];
                        }
                        if (drawable3 == null) {
                            drawable3 = compoundDrawables[2];
                        }
                        if (drawable4 == null) {
                            drawable4 = compoundDrawables[3];
                        }
                        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                    } else {
                        if (drawable2 == null) {
                            drawable2 = compoundDrawablesRelative2[1];
                        }
                        if (drawable4 == null) {
                            drawable4 = compoundDrawablesRelative2[3];
                        }
                        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
                    }
                }
                if (obtainStyledAttributes2.hasValue(11)) {
                    if (!obtainStyledAttributes2.hasValue(11) || (resourceId7 = obtainStyledAttributes2.getResourceId(11, 0)) == 0 || (colorStateList4 = BundleKt.getColorStateList(context, resourceId7)) == null) {
                        colorStateList4 = obtainStyledAttributes2.getColorStateList(11);
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        TextViewCompat.Api23Impl.setCompoundDrawableTintList(textView, colorStateList4);
                    } else if (textView instanceof TintableCompoundDrawablesView) {
                        ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList4);
                    }
                }
                if (obtainStyledAttributes2.hasValue(12)) {
                    PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes2.getInt(12, -1), null);
                    if (Build.VERSION.SDK_INT >= 24) {
                        TextViewCompat.Api23Impl.setCompoundDrawableTintMode(textView, parseTintMode);
                    } else if (textView instanceof TintableCompoundDrawablesView) {
                        ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(parseTintMode);
                    }
                }
                dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(15, -1);
                dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(18, -1);
                if (!obtainStyledAttributes2.hasValue(19)) {
                    TypedValue peekValue = obtainStyledAttributes2.peekValue(19);
                    if (peekValue == null || peekValue.type != 5) {
                        i3 = -1;
                        f4 = obtainStyledAttributes2.getDimensionPixelSize(19, -1);
                    } else {
                        int i9 = peekValue.data;
                        int i10 = i9 & 15;
                        f4 = TypedValue.complexToFloat(i9);
                        i4 = i10;
                        i3 = -1;
                        obtainStyledAttributes2.recycle();
                        if (dimensionPixelSize != i3) {
                            TextViewCompat.setFirstBaselineToTopHeight(textView, dimensionPixelSize);
                        }
                        if (dimensionPixelSize2 != i3) {
                            TextViewCompat.setLastBaselineToBottomHeight(textView, dimensionPixelSize2);
                        }
                        if (f4 == -1.0f) {
                            return;
                        }
                        if (i4 == i3) {
                            TextViewCompat.setLineHeight(textView, (int) f4);
                            return;
                        } else if (Build.VERSION.SDK_INT >= 34) {
                            TextViewCompat.Api34Impl.setLineHeight(textView, i4, f4);
                            return;
                        } else {
                            TextViewCompat.setLineHeight(textView, Math.round(TypedValue.applyDimension(i4, f4, textView.getResources().getDisplayMetrics())));
                            return;
                        }
                    }
                } else {
                    i3 = -1;
                    f4 = -1.0f;
                }
                i4 = -1;
                obtainStyledAttributes2.recycle();
                if (dimensionPixelSize != i3) {
                }
                if (dimensionPixelSize2 != i3) {
                }
                if (f4 == -1.0f) {
                }
            }
        }
        i2 = 0;
        appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        Context context22 = appCompatTextViewAutoSizeHelper.mContext;
        int[] iArr42 = R$styleable.AppCompatTextView;
        obtainStyledAttributes = context22.obtainStyledAttributes(attributeSet, iArr42, i, i2);
        TextView textView22 = appCompatTextViewAutoSizeHelper.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView22, textView22.getContext(), iArr42, attributeSet, obtainStyledAttributes, i);
        if (obtainStyledAttributes.hasValue(5)) {
        }
        if (!obtainStyledAttributes.hasValue(4)) {
        }
        if (!obtainStyledAttributes.hasValue(2)) {
        }
        if (!obtainStyledAttributes.hasValue(1)) {
        }
        if (obtainStyledAttributes.hasValue(3)) {
            TypedArray obtainTypedArray2 = obtainStyledAttributes.getResources().obtainTypedArray(resourceId8);
            length = obtainTypedArray2.length();
            int[] iArr52 = new int[length];
            if (length > 0) {
            }
            obtainTypedArray2.recycle();
        }
        obtainStyledAttributes.recycle();
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
        }
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            iArr = appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx;
            if (iArr.length > 0) {
            }
        }
        obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr42);
        resourceId = obtainStyledAttributes2.getResourceId(8, -1);
        AppCompatDrawableManager appCompatDrawableManager32 = appCompatDrawableManager;
        if (resourceId == -1) {
        }
        resourceId2 = obtainStyledAttributes2.getResourceId(13, -1);
        if (resourceId2 == -1) {
        }
        resourceId3 = obtainStyledAttributes2.getResourceId(9, -1);
        if (resourceId3 == -1) {
        }
        resourceId4 = obtainStyledAttributes2.getResourceId(6, -1);
        if (resourceId4 == -1) {
        }
        resourceId5 = obtainStyledAttributes2.getResourceId(10, -1);
        if (resourceId5 == -1) {
        }
        resourceId6 = obtainStyledAttributes2.getResourceId(7, -1);
        if (resourceId6 == -1) {
        }
        if (drawable5 == null) {
        }
        Drawable[] compoundDrawablesRelative3 = textView.getCompoundDrawablesRelative();
        if (drawable5 == null) {
        }
        if (drawable2 == null) {
        }
        if (drawable6 == null) {
        }
        if (drawable4 == null) {
        }
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        if (obtainStyledAttributes2.hasValue(11)) {
        }
        if (obtainStyledAttributes2.hasValue(12)) {
        }
        dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(15, -1);
        dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(18, -1);
        if (!obtainStyledAttributes2.hasValue(19)) {
        }
        i4 = -1;
        obtainStyledAttributes2.recycle();
        if (dimensionPixelSize != i3) {
        }
        if (dimensionPixelSize2 != i3) {
        }
        if (f4 == -1.0f) {
        }
    }

    public final void onSetTextAppearance(Context context, int i) {
        String string;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        MatcherMatchResult matcherMatchResult = new MatcherMatchResult(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(14);
        TextView textView = this.mView;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            if (obtainStyledAttributes.hasValue(3) && (colorStateList3 = matcherMatchResult.getColorStateList(3)) != null) {
                textView.setTextColor(colorStateList3);
            }
            if (obtainStyledAttributes.hasValue(5) && (colorStateList2 = matcherMatchResult.getColorStateList(5)) != null) {
                textView.setLinkTextColor(colorStateList2);
            }
            if (obtainStyledAttributes.hasValue(4) && (colorStateList = matcherMatchResult.getColorStateList(4)) != null) {
                textView.setHintTextColor(colorStateList);
            }
        }
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, matcherMatchResult);
        if (i2 >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
            Api26Impl.setFontVariationSettings(textView, string);
        }
        matcherMatchResult.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            textView.setTypeface(typeface, this.mStyle);
        }
    }

    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArr2);
                if (!appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues = false;
            }
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setAutoSizeTextTypeWithDefaults(int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (!appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            return;
        }
        if (i == 0) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
            appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx = -1.0f;
            appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = new int[0];
            appCompatTextViewAutoSizeHelper.mNeedsAutoSizeText = false;
        } else if (i == 1) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        } else {
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(i, "Unknown auto-size text type: "));
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.appcompat.widget.TintInfo] */
    public final void setCompoundDrawableTintList(ColorStateList colorStateList) {
        boolean z;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new Object();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        if (colorStateList != null) {
            z = true;
        } else {
            z = false;
        }
        tintInfo.mHasTintList = z;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.appcompat.widget.TintInfo] */
    public final void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        boolean z;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new Object();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        if (mode != null) {
            z = true;
        } else {
            z = false;
        }
        tintInfo.mHasTintMode = z;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [androidx.appcompat.widget.AppCompatTextHelper$1] */
    public final void updateTypefaceAndStyle(Context context, MatcherMatchResult matcherMatchResult) {
        String string;
        boolean z;
        boolean z2;
        int i = this.mStyle;
        TypedArray typedArray = (TypedArray) matcherMatchResult.input;
        this.mStyle = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.mFontWeight = i3;
            if (i3 != -1) {
                this.mStyle &= 2;
            }
        }
        int i4 = 10;
        boolean z3 = false;
        if (typedArray.hasValue(10) || typedArray.hasValue(12)) {
            this.mFontTypeface = null;
            if (typedArray.hasValue(12)) {
                i4 = 12;
            }
            final int i5 = this.mFontWeight;
            final int i6 = this.mStyle;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.mView);
                try {
                    Typeface font = matcherMatchResult.getFont(i4, this.mStyle, new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                        public final void onFontRetrievalFailed(int i7) {
                        }

                        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                        public final void onFontRetrieved(Typeface typeface) {
                            int i7;
                            boolean z4;
                            if (Build.VERSION.SDK_INT >= 28 && (i7 = i5) != -1) {
                                if ((i6 & 2) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                typeface = Api28Impl.create(typeface, i7, z4);
                            }
                            AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
                            if (appCompatTextHelper.mAsyncFontPending) {
                                appCompatTextHelper.mFontTypeface = typeface;
                                TextView textView = (TextView) weakReference.get();
                                if (textView == null) {
                                    return;
                                }
                                if (textView.isAttachedToWindow()) {
                                    textView.post(new ActivityCompat.RunnableC00421(appCompatTextHelper.mStyle, 3, textView, typeface));
                                } else {
                                    textView.setTypeface(typeface, appCompatTextHelper.mStyle);
                                }
                            }
                        }
                    });
                    if (font != null) {
                        if (i2 < 28 || this.mFontWeight == -1) {
                            this.mFontTypeface = font;
                        } else {
                            Typeface create = Typeface.create(font, 0);
                            int i7 = this.mFontWeight;
                            if ((this.mStyle & 2) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            this.mFontTypeface = Api28Impl.create(create, i7, z2);
                        }
                    }
                    if (this.mFontTypeface == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.mAsyncFontPending = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null && (string = typedArray.getString(i4)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                    this.mFontTypeface = Typeface.create(string, this.mStyle);
                    return;
                }
                Typeface create2 = Typeface.create(string, 0);
                int i8 = this.mFontWeight;
                if ((this.mStyle & 2) != 0) {
                    z3 = true;
                }
                this.mFontTypeface = Api28Impl.create(create2, i8, z3);
            }
        } else if (typedArray.hasValue(1)) {
            this.mAsyncFontPending = false;
            int i9 = typedArray.getInt(1, 1);
            if (i9 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
            } else if (i9 == 2) {
                this.mFontTypeface = Typeface.SERIF;
            } else if (i9 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
            }
        }
    }
}
