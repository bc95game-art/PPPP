package kotlin;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.p002os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.gms.internal.play_billing.zzcj$zzd;
import com.google.android.gms.internal.play_billing.zzck;
import com.google.android.gms.internal.play_billing.zzde;
import com.google.android.gms.internal.play_billing.zzdw;
import com.google.android.gms.internal.play_billing.zzeg;
import com.google.android.gms.internal.play_billing.zzfi;
import com.google.android.gms.internal.play_billing.zzfj;
import com.google.android.gms.internal.play_billing.zzfn;
import com.google.android.gms.internal.play_billing.zzgo;
import com.google.android.gms.internal.play_billing.zzgv;
import com.google.android.gms.internal.play_billing.zzh;
import com.google.android.gms.internal.play_billing.zzhi;
import com.google.android.gms.internal.play_billing.zzm;
import com.google.android.gms.internal.play_billing.zzo;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapePath;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public abstract class LazyKt__LazyJVMKt {
    public static void applyIconTint(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = BundleKt.wrap(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static void checkRangeIndexes$kotlin_stdlib(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
        } else if (i > i2) {
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m605m(i, i2, "fromIndex: ", " > toIndex: "));
        }
    }

    public static ImageView.ScaleType convertScaleType(int i) {
        if (i == 0) {
            return ImageView.ScaleType.FIT_XY;
        }
        if (i == 1) {
            return ImageView.ScaleType.FIT_START;
        }
        if (i == 2) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (i == 3) {
            return ImageView.ScaleType.FIT_END;
        }
        if (i == 5) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if (i != 6) {
            return ImageView.ScaleType.CENTER;
        }
        return ImageView.ScaleType.CENTER_INSIDE;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.LazyKt__LazyJVMKt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.LazyKt__LazyJVMKt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.LazyKt__LazyJVMKt, java.lang.Object] */
    public static LazyKt__LazyJVMKt createCornerTreatment(int i) {
        if (i == 0) {
            return new Object();
        }
        if (i != 1) {
            return new Object();
        }
        return new Object();
    }

    public static int getColor(int i, View view) {
        Context context = view.getContext();
        TypedValue resolveTypedValueOrThrow = resolveTypedValueOrThrow(i, view.getContext(), view.getClass().getCanonicalName());
        int i2 = resolveTypedValueOrThrow.resourceId;
        if (i2 != 0) {
            return BundleKt.getColor(context, i2);
        }
        return resolveTypedValueOrThrow.data;
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = BundleKt.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawable;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawable = BundleKt.getDrawable(context, resourceId)) == null) {
            return typedArray.getDrawable(i);
        }
        return drawable;
    }

    public static float getLegacyControlPoint(String[] strArr, int i) {
        float parseFloat = Float.parseFloat(strArr[i]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static boolean isColorLight(int i) {
        double d;
        double pow;
        double d2;
        if (i == 0) {
            return false;
        }
        ThreadLocal threadLocal = ColorUtils.TEMP_ARRAY;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        if (dArr.length == 3) {
            double d3 = red / 255.0d;
            if (d3 < 0.04045d) {
                d = d3 / 12.92d;
            } else {
                d = Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            }
            double d4 = green / 255.0d;
            if (d4 < 0.04045d) {
                pow = d4 / 12.92d;
            } else {
                pow = Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
            }
            double d5 = blue / 255.0d;
            if (d5 < 0.04045d) {
                d2 = d5 / 12.92d;
            } else {
                d2 = Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            }
            dArr[0] = ((0.1805d * d2) + (0.3576d * pow) + (0.4124d * d)) * 100.0d;
            double d6 = ((0.0722d * d2) + (0.7152d * pow) + (0.2126d * d)) * 100.0d;
            dArr[1] = d6;
            double d7 = d2 * 0.9505d;
            dArr[2] = (d7 + (pow * 0.1192d) + (d * 0.0193d)) * 100.0d;
            if (d6 / 100.0d > 0.5d) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static boolean isFontScaleAtLeast1_3(Context context) {
        if (context.getResources().getConfiguration().fontScale >= 1.3f) {
            return true;
        }
        return false;
    }

    public static boolean isLegacyEasingType(String str, String str2) {
        if (!str.startsWith(str2.concat("(")) || !str.endsWith(")")) {
            return false;
        }
        return true;
    }

    public static int layer(int i, float f, int i2) {
        return ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.SafePublicationLazyImpl, java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, kotlin.UnsafeLazyImpl, kotlin.Lazy] */
    public static Lazy lazy(LazyThreadSafetyMode lazyThreadSafetyMode, Function0 function0) {
        Unit unit = Unit.INSTANCE$1;
        int ordinal = lazyThreadSafetyMode.ordinal();
        if (ordinal == 0) {
            return new SynchronizedLazyImpl(function0);
        }
        if (ordinal == 1) {
            ?? obj = new Object();
            obj.initializer = function0;
            obj._value = unit;
            return obj;
        } else if (ordinal == 2) {
            ?? obj2 = new Object();
            obj2.initializer = function0;
            obj2._value = unit;
            return obj2;
        } else {
            throw new RuntimeException();
        }
    }

    public static List listOf(Object obj) {
        List singletonList = Collections.singletonList(obj);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static JsonElement parseReader(JsonReader jsonReader) {
        int i = jsonReader.strictness;
        if (i == 2) {
            jsonReader.strictness = 1;
        }
        try {
            try {
                return Streams.parse(jsonReader);
            } finally {
                jsonReader.setStrictness(i);
            }
        } catch (OutOfMemoryError | StackOverflowError e) {
            throw new RuntimeException("Failed parsing JSON source: " + jsonReader + " to Json", e);
        }
    }

    public static JsonElement parseString(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            JsonElement parseReader = parseReader(jsonReader);
            parseReader.getClass();
            if (!(parseReader instanceof JsonNull) && jsonReader.peek() != 10) {
                throw new RuntimeException("Did not consume the entire document.");
            }
            return parseReader;
        } catch (MalformedJsonException | NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void playTogether(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = (Animator) arrayList.get(i);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j);
        arrayList.add(0, ofInt);
        animatorSet.playTogether(arrayList);
    }

    public static void refreshIconDrawableState(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int[] drawableState = textInputLayout.getDrawableState();
            int[] drawableState2 = checkableImageButton.getDrawableState();
            int length = drawableState.length;
            int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
            System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
            int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
            Drawable mutate = BundleKt.wrap(drawable).mutate();
            mutate.setTintList(ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public static TypedValue resolve(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(Context context, int i, boolean z) {
        TypedValue resolve = resolve(context, i);
        if (resolve == null || resolve.type != 18) {
            return z;
        }
        if (resolve.data != 0) {
            return true;
        }
        return false;
    }

    public static int resolveMinimumAccessibleTouchTarget(Context context) {
        float dimension;
        TypedValue resolve = resolve(context, C0130R.attr.minTouchTargetSize);
        if (resolve == null || resolve.type != 5) {
            dimension = context.getResources().getDimension(C0130R.dimen.mtrl_min_touch_target_size);
        } else {
            dimension = resolve.getDimension(context.getResources().getDisplayMetrics());
        }
        return (int) dimension;
    }

    public static int resolveThemeDuration(Context context, int i, int i2) {
        TypedValue resolve = resolve(context, i);
        if (resolve == null || resolve.type != 16) {
            return i2;
        }
        return resolve.data;
    }

    public static TimeInterpolator resolveThemeInterpolator(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (!isLegacyEasingType(valueOf, "cubic-bezier") && !isLegacyEasingType(valueOf, "path")) {
                return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
            }
            if (isLegacyEasingType(valueOf, "cubic-bezier")) {
                String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
                if (split.length == 4) {
                    return new PathInterpolator(getLegacyControlPoint(split, 0), getLegacyControlPoint(split, 1), getLegacyControlPoint(split, 2), getLegacyControlPoint(split, 3));
                }
                throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
            } else if (isLegacyEasingType(valueOf, "path")) {
                return new PathInterpolator(BundleKt.createPathFromPathData(valueOf.substring(5, valueOf.length() - 1)));
            } else {
                throw new IllegalArgumentException("Invalid motion easing type: ".concat(valueOf));
            }
        } else {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
    }

    public static TypedValue resolveTypedValueOrThrow(int i, Context context, String str) {
        TypedValue resolve = resolve(context, i);
        if (resolve != null) {
            return resolve;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static void setElevation(ViewGroup viewGroup, float f) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f);
        }
    }

    public static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean z;
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z2 = false;
        int i = 1;
        if (onLongClickListener != null) {
            z = true;
        } else {
            z = false;
        }
        if (hasOnClickListeners || z) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        if (!z2) {
            i = 2;
        }
        checkableImageButton.setImportantForAccessibility(i);
    }

    public static void setParentAbsoluteElevation(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            setParentAbsoluteElevation(viewGroup, (MaterialShapeDrawable) background);
        }
    }

    public static /* synthetic */ boolean zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, zzck zzckVar, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(zzckVar, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(zzckVar) != obj && atomicReferenceFieldUpdater.get(zzckVar) != obj) {
                return false;
            }
        }
        return true;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << 24) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16);
    }

    public static boolean zze(byte b) {
        return b > -65;
    }

    public static int zzf(byte[] bArr, int i, zzfn zzfnVar, zzdw zzdwVar) {
        zzfj zzfjVar = (zzfj) zzfnVar;
        int zzi = zzi(bArr, i, zzdwVar);
        int i2 = zzdwVar.zza + zzi;
        while (zzi < i2) {
            zzi = zzi(bArr, zzi, zzdwVar);
            zzfjVar.zzg(zzdwVar.zza);
        }
        if (zzi == i2) {
            return zzi;
        }
        throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzh(int i, byte[] bArr, int i2, int i3, zzhi zzhiVar, zzdw zzdwVar) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzl = zzl(bArr, i2, zzdwVar);
                zzhiVar.zzj(i, Long.valueOf(zzdwVar.zzb));
                return zzl;
            } else if (i4 == 1) {
                zzhiVar.zzj(i, Long.valueOf(zzo(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzi = zzi(bArr, i2, zzdwVar);
                int i5 = zzdwVar.zza;
                if (i5 < 0) {
                    throw new IOException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                } else if (i5 <= bArr.length - zzi) {
                    if (i5 == 0) {
                        zzhiVar.zzj(i, zzeg.zzb);
                    } else {
                        zzhiVar.zzj(i, zzeg.zzj(bArr, zzi, i5));
                    }
                    return zzi + i5;
                } else {
                    throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
            } else if (i4 == 3) {
                int i6 = (i & (-8)) | 4;
                zzhi zzf = zzhi.zzf();
                int i7 = zzdwVar.zze + 1;
                zzdwVar.zze = i7;
                if (i7 < 100) {
                    int i8 = 0;
                    while (true) {
                        if (i2 >= i3) {
                            break;
                        }
                        int zzi2 = zzi(bArr, i2, zzdwVar);
                        int i9 = zzdwVar.zza;
                        if (i9 == i6) {
                            i8 = i9;
                            i2 = zzi2;
                            break;
                        }
                        i2 = zzh(i9, bArr, zzi2, i3, zzf, zzdwVar);
                        i8 = i9;
                    }
                    zzdwVar.zze--;
                    if (i2 > i3 || i8 != i6) {
                        throw new IOException("Failed to parse the message.");
                    }
                    zzhiVar.zzj(i, zzf);
                    return i2;
                }
                throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            } else if (i4 == 5) {
                zzhiVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw new IOException("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new IOException("Protocol message contained an invalid tag (zero).");
        }
    }

    public static int zzi(byte[] bArr, int i, zzdw zzdwVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzj(b, bArr, i2, zzdwVar);
        }
        zzdwVar.zza = b;
        return i2;
    }

    public static int zzj(int i, byte[] bArr, int i2, zzdw zzdwVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzdwVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzdwVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdwVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdwVar.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzdwVar.zza = i11;
                return i12;
            }
        }
    }

    public static int zzk(int i, byte[] bArr, int i2, int i3, zzfn zzfnVar, zzdw zzdwVar) {
        zzfj zzfjVar = (zzfj) zzfnVar;
        int zzi = zzi(bArr, i2, zzdwVar);
        zzfjVar.zzg(zzdwVar.zza);
        while (zzi < i3) {
            int zzi2 = zzi(bArr, zzi, zzdwVar);
            if (i != zzdwVar.zza) {
                break;
            }
            zzi = zzi(bArr, zzi2, zzdwVar);
            zzfjVar.zzg(zzdwVar.zza);
        }
        return zzi;
    }

    public static int zzl(byte[] bArr, int i, zzdw zzdwVar) {
        byte b;
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzdwVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (b & Byte.MAX_VALUE) << i4;
            b2 = bArr[i3];
            i3 = i5;
        }
        zzdwVar.zzb = j2;
        return i3;
    }

    public static int zzm(Object obj, zzgv zzgvVar, byte[] bArr, int i, int i2, int i3, zzdw zzdwVar) {
        zzgo zzgoVar = (zzgo) zzgvVar;
        int i4 = zzdwVar.zze + 1;
        zzdwVar.zze = i4;
        if (i4 < 100) {
            int zzc = zzgoVar.zzc(obj, bArr, i, i2, i3, zzdwVar);
            zzdwVar.zze--;
            zzdwVar.zzc = obj;
            return zzc;
        }
        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static int zzn(Object obj, zzgv zzgvVar, byte[] bArr, int i, int i2, zzdw zzdwVar) {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzj(i4, bArr, i3, zzdwVar);
            i4 = zzdwVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzdwVar.zze + 1;
        zzdwVar.zze = i6;
        if (i6 < 100) {
            int i7 = i5 + i4;
            zzgvVar.zzh(obj, bArr, i5, i7, zzdwVar);
            zzdwVar.zze--;
            zzdwVar.zzc = obj;
            return i7;
        }
        throw new IOException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static long zzo(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    public abstract int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float calculateSlideOffset(int i);

    public abstract Method getAccessor(Class cls, Field field);

    public abstract Constructor getCanonicalRecordConstructor(Class cls);

    public abstract int getCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract void getCornerPath(ShapePath shapePath, float f, float f2);

    public abstract int getExpandedOffset();

    public abstract int getHiddenOffset();

    public abstract int getMaxViewPositionHorizontal();

    public abstract int getMinViewPositionHorizontal();

    public abstract int getOuterEdge(View view);

    public abstract int getParentInnerEdge(CoordinatorLayout coordinatorLayout);

    public abstract String[] getRecordComponentNames(Class cls);

    public abstract int getSheetEdge();

    public abstract int getSize(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int getViewEdge();

    public abstract ViewPropertyAnimator getViewTranslationAnimator(int i, View view);

    public abstract boolean isExpandingOutwards(float f);

    public abstract boolean isRecord(Class cls);

    public abstract boolean isReleasedCloseToInnerEdge(View view);

    public abstract boolean isSwipeSignificant(float f, float f2);

    public abstract void onFontRetrievalFailed(int i);

    public abstract void onFontRetrieved(Typeface typeface, boolean z);

    public abstract boolean shouldHide(View view, float f);

    public abstract void updateCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i);

    public abstract void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2);

    public abstract long zza();

    public abstract zzcj$zzd zza(zzde zzdeVar);

    public abstract void zza(zzm zzmVar, zzm zzmVar2);

    public abstract zzck.zze zzb(zzde zzdeVar);

    public abstract void zzb(zzm zzmVar, Thread thread);

    public abstract void zzc(zzck.zze zzeVar, zzck.zze zzeVar2);

    public abstract boolean zzc(zzo zzoVar, zzh zzhVar, zzh zzhVar2);

    public abstract void zzd(zzck.zze zzeVar, Thread thread);

    public abstract boolean zzd(zzo zzoVar, Object obj, Object obj2);

    public abstract boolean zze(zzde zzdeVar, zzcj$zzd zzcj_zzd, zzcj$zzd zzcj_zzd2);

    public abstract boolean zze(zzo zzoVar, zzm zzmVar, zzm zzmVar2);

    public abstract boolean zzf(zzck zzckVar, Object obj, Object obj2);

    public abstract boolean zzg(zzck zzckVar, zzck.zze zzeVar, zzck.zze zzeVar2);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    public static int zze(zzgv zzgvVar, int i, byte[] bArr, int i2, int i3, zzfn zzfnVar, zzdw zzdwVar) {
        zzfi zze = zzgvVar.zze();
        zzgv zzgvVar2 = zzgvVar;
        byte[] bArr2 = bArr;
        int i4 = i3;
        zzdw zzdwVar2 = zzdwVar;
        int zzn = zzn(zze, zzgvVar2, bArr2, i2, i4, zzdwVar2);
        zzgvVar2.zzf(zze);
        zzdwVar2.zzc = zze;
        zzfnVar.add(zze);
        while (zzn < i4) {
            zzdw zzdwVar3 = zzdwVar2;
            int i5 = i4;
            int zzi = zzi(bArr2, zzn, zzdwVar3);
            if (i != zzdwVar3.zza) {
                break;
            }
            byte[] bArr3 = bArr2;
            zzgv zzgvVar3 = zzgvVar2;
            zzfi zze2 = zzgvVar3.zze();
            zzn = zzn(zze2, zzgvVar3, bArr3, zzi, i5, zzdwVar3);
            zzgvVar2 = zzgvVar3;
            bArr2 = bArr3;
            i4 = i5;
            zzdwVar2 = zzdwVar3;
            zzgvVar2.zzf(zze2);
            zzdwVar2.zzc = zze2;
            zzfnVar.add(zze2);
        }
        return zzn;
    }

    public static /* synthetic */ boolean zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, zzo zzoVar, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(zzoVar, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(zzoVar) != obj && atomicReferenceFieldUpdater.get(zzoVar) != obj) {
                return false;
            }
        }
        return true;
    }

    public static void setParentAbsoluteElevation(View view, MaterialShapeDrawable materialShapeDrawable) {
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawable.drawableState.elevationOverlayProvider;
        if (elevationOverlayProvider != null && elevationOverlayProvider.elevationOverlayEnabled) {
            float f = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                f += ((View) parent).getElevation();
            }
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.parentAbsoluteElevation != f) {
                materialShapeDrawableState.parentAbsoluteElevation = f;
                materialShapeDrawable.updateZ();
            }
        }
    }

    public static ColorStateList getColorStateList(Context context, MatcherMatchResult matcherMatchResult, int i) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = (TypedArray) matcherMatchResult.input;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = BundleKt.getColorStateList(context, resourceId)) == null) ? matcherMatchResult.getColorStateList(i) : colorStateList;
    }

    public static int zza(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static int zza(byte[] bArr, int i, zzdw zzdwVar) {
        int zzi = zzi(bArr, i, zzdwVar);
        int i2 = zzdwVar.zza;
        if (i2 < 0) {
            throw new IOException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i2 > bArr.length - zzi) {
            throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } else if (i2 == 0) {
            zzdwVar.zzc = zzeg.zzb;
            return zzi;
        } else {
            zzdwVar.zzc = zzeg.zzj(bArr, zzi, i2);
            return zzi + i2;
        }
    }

    public static int getColor(Context context, int i, int i2) {
        Integer num;
        int i3;
        TypedValue resolve = resolve(context, i);
        if (resolve != null) {
            int i4 = resolve.resourceId;
            if (i4 != 0) {
                i3 = BundleKt.getColor(context, i4);
            } else {
                i3 = resolve.data;
            }
            num = Integer.valueOf(i3);
        } else {
            num = null;
        }
        return num != null ? num.intValue() : i2;
    }

    public static String zza(zzeg zzegVar) {
        StringBuilder sb = new StringBuilder(zzegVar.zzd());
        for (int i = 0; i < zzegVar.zzd(); i++) {
            byte zza = zzegVar.zza(i);
            if (zza == 34) {
                sb.append("\\\"");
            } else if (zza == 39) {
                sb.append("\\'");
            } else if (zza != 92) {
                switch (zza) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (zza < 32 || zza > 126) {
                            sb.append('\\');
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            sb.append((char) ((zza & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zza);
                            continue;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String zza(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e) {
                    String str3 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), (Throwable) e);
                    str2 = "<" + str3 + " threw " + e.getClass().getName() + ">";
                }
            }
            objArr[i2] = str2;
            i2++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (indexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i3, indexOf);
            i++;
            sb.append(objArr[i]);
            i3 = indexOf + 2;
        }
        sb.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb.append(" [");
            int i4 = i + 1;
            sb.append(objArr[i]);
            while (i4 < objArr.length) {
                sb.append(", ");
                i4++;
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void zza(int i, Object[] objArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                throw new NullPointerException(ViewModelProvider.Factory.CC.m604m(i2, "at index "));
            }
        }
    }
}
