package androidx.core.p002os;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CompoundButton;
import android.widget.EdgeEffect;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.TooltipCompat$Api26Impl;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.core.app.AppOpsManagerCompat$Api23Impl;
import androidx.core.app.AppOpsManagerCompat$Api29Impl;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat$Api23Impl;
import androidx.core.content.ContextCompat$LegacyServiceMapHolder;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api23Impl;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.graphics.drawable.WrappedDrawableApi21;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt$allViews$1;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.WindowCompat$Api30Impl;
import androidx.core.widget.CompoundButtonCompat$Api23Impl;
import androidx.core.widget.EdgeEffectCompat$Api21Impl;
import androidx.core.widget.EdgeEffectCompat$Api31Impl;
import androidx.core.widget.PopupWindowCompat$Api23Impl;
import androidx.customview.poolingcontainer.PoolingContainerListenerHolder;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.gms.internal.play_billing.zzem;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.material.shape.Shapeable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ServiceConfigurationError;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p004j$.util.Objects;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: androidx.core.os.BundleKt */
/* loaded from: classes.dex */
public abstract class BundleKt implements ViewPropertyAnimatorListener {
    public static boolean sActionBarFieldsFetched = false;
    public static Method sActionBarOnMenuKeyMethod = null;
    public static Field sButtonDrawableField = null;
    public static boolean sButtonDrawableFieldFetched = false;
    public static boolean sDialogFieldsFetched = false;
    public static Field sDialogKeyListenerField;
    public static Field sDrawableCacheField;
    public static boolean sDrawableCacheFieldFetched;
    public static Method sGetLayoutDirectionMethod;
    public static boolean sGetLayoutDirectionMethodFetched;
    public static Field sOverlapAnchorField;
    public static boolean sOverlapAnchorFieldAttempted;
    public static Field sResourcesImplField;
    public static boolean sResourcesImplFieldFetched;
    public static Method sSetLayoutDirectionMethod;
    public static boolean sSetLayoutDirectionMethodFetched;
    public static Method sSetWindowLayoutTypeMethod;
    public static boolean sSetWindowLayoutTypeMethodAttempted;
    public static Class sThemedResourceCacheClazz;
    public static boolean sThemedResourceCacheClazzFetched;
    public static Field sThemedResourceCache_mUnthemedEntriesField;
    public static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    public BundleKt() {
        new ConcurrentHashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r9.bottom <= r11.top) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r9.right <= r11.left) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r9.top >= r11.bottom) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
        if (r9.left >= r11.right) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r8 == 17) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r8 != 66) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        r10 = majorAxisDistance(r8, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r8 == 17) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        if (r8 == 33) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        if (r8 == 66) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r8 != 130) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        r8 = r11.bottom;
        r9 = r9.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
        throw new java.lang.IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
        r8 = r11.right;
        r9 = r9.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
        r8 = r9.top;
        r9 = r11.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
        r8 = r9.left;
        r9 = r11.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
        if (r10 >= java.lang.Math.max(1, r8 - r9)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0074, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean beamBeats(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i, rect, rect2);
        if (beamsOverlap(i, rect, rect3) || !beamsOverlap) {
            return false;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
        }
    }

    public static boolean beamsOverlap(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static final Bundle bundleOf(Pair... pairArr) {
        Bundle bundle = new Bundle(pairArr.length);
        for (Pair pair : pairArr) {
            String str = (String) pair.first;
            Object obj = pair.second;
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else if (obj instanceof Object[]) {
                Class<?> componentType = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(str, (Parcelable[]) obj);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(str, (String[]) obj);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(str, (CharSequence[]) obj);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(str, (Serializable) obj);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                }
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof IBinder) {
                bundle.putBinder(str, (IBinder) obj);
            } else if (obj instanceof Size) {
                BundleApi21ImplKt.putSize(bundle, str, (Size) obj);
            } else if (obj instanceof SizeF) {
                BundleApi21ImplKt.putSizeF(bundle, str, (SizeF) obj);
            } else {
                throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return bundle;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.sequences.SequenceBuilderIterator, java.lang.Object] */
    public static final void callPoolingContainerOnRelease(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ?? obj = new Object();
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(view, obj);
        viewKt$allViews$1.L$0 = obj;
        obj.nextStep = viewKt$allViews$1;
        while (obj.hasNext()) {
            View view2 = (View) obj.next();
            PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view2.getTag(C0130R.C0132id.pooling_container_listener_holder_tag);
            if (poolingContainerListenerHolder == null) {
                poolingContainerListenerHolder = new PoolingContainerListenerHolder();
                view2.setTag(C0130R.C0132id.pooling_container_listener_holder_tag, poolingContainerListenerHolder);
            }
            ArrayList arrayList = poolingContainerListenerHolder.listeners;
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (-1 < lastIndex) {
                arrayList.get(lastIndex).getClass();
                throw new ClassCastException();
            }
        }
    }

    public static boolean canMorph(PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
        if (pathParser$PathDataNodeArr == null || pathParser$PathDataNodeArr2 == null || pathParser$PathDataNodeArr.length != pathParser$PathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            PathParser$PathDataNode pathParser$PathDataNode = pathParser$PathDataNodeArr[i];
            char c = pathParser$PathDataNode.mType;
            PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArr2[i];
            if (!(c == pathParser$PathDataNode2.mType && pathParser$PathDataNode.mParams.length == pathParser$PathDataNode2.mParams.length)) {
                return false;
            }
        }
        return true;
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        } else if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } else {
            if (new NotificationManagerCompat(context).areNotificationsEnabled()) {
                return 0;
            }
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0084 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int checkSelfPermission$1(Context context, String str) {
        String str2;
        int i;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) != -1) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                str2 = AppOpsManagerCompat$Api23Impl.permissionToOp(str);
            } else {
                str2 = null;
            }
            if (str2 != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int myUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                int i3 = 1;
                if (myUid2 != myUid || !Objects.equals(packageName2, packageName)) {
                    if (i2 >= 23) {
                        i3 = AppOpsManagerCompat$Api23Impl.noteProxyOpNoThrow((AppOpsManager) AppOpsManagerCompat$Api23Impl.getSystemService(context, AppOpsManager.class), str2, packageName);
                    }
                } else if (i2 >= 29) {
                    AppOpsManager systemService = AppOpsManagerCompat$Api29Impl.getSystemService(context);
                    i = AppOpsManagerCompat$Api29Impl.checkOpNoThrow(systemService, str2, Binder.getCallingUid(), packageName);
                    if (i == 0) {
                        i = AppOpsManagerCompat$Api29Impl.checkOpNoThrow(systemService, str2, myUid, AppOpsManagerCompat$Api29Impl.getOpPackageName(context));
                    }
                    if (i == 0) {
                        return -2;
                    }
                } else if (i2 >= 23) {
                    i3 = AppOpsManagerCompat$Api23Impl.noteProxyOpNoThrow((AppOpsManager) AppOpsManagerCompat$Api23Impl.getSystemService(context, AppOpsManager.class), str2, packageName);
                }
                i = i3;
                if (i == 0) {
                }
            }
            return 0;
        }
        return -1;
    }

    public static float clamp(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static void clearColorFilter(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            clearColorFilter(((InsetDrawable) drawable).getDrawable());
        } else if (drawable instanceof WrappedDrawable) {
            clearColorFilter(((WrappedDrawableApi21) ((WrappedDrawable) drawable)).mDrawable);
        } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
            int childCount = drawableContainerState.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Drawable child = drawableContainerState.getChild(i);
                if (child != null) {
                    clearColorFilter(child);
                }
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static float[] copyOfRange(float[] fArr, int i) {
        if (i >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int min = Math.min(i, length);
                float[] fArr2 = new float[i];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static boolean copyToFile(InputStream inputStream, File file) {
        Throwable th;
        IOException e;
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    closeQuietly(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            closeQuietly(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            closeQuietly(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098 A[Catch: NumberFormatException -> 0x00ac, LOOP:3: B:23:0x006a->B:42:0x0098, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:20:0x0056, B:23:0x006a, B:25:0x0070, B:29:0x007c, B:42:0x0098, B:44:0x009e, B:50:0x00b3, B:51:0x00b6), top: B:66:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e A[Catch: NumberFormatException -> 0x00ac, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:20:0x0056, B:23:0x006a, B:25:0x0070, B:29:0x007c, B:42:0x0098, B:44:0x009e, B:50:0x00b3, B:51:0x00b6), top: B:66:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3 A[Catch: NumberFormatException -> 0x00ac, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:20:0x0056, B:23:0x006a, B:25:0x0070, B:29:0x007c, B:42:0x0098, B:44:0x009e, B:50:0x00b3, B:51:0x00b6), top: B:66:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0097 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PathParser$PathDataNode[] createNodesFromPathData(String str) {
        int i;
        String trim;
        float[] fArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i3 < str.length()) {
            while (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if ((charAt - 'Z') * (charAt - 'A') > 0) {
                    if ((charAt - 'z') * (charAt - 'a') > 0) {
                        continue;
                        i3++;
                    }
                }
                if (!(charAt == 'e' || charAt == 'E')) {
                    trim = str.substring(i4, i3).trim();
                    if (!trim.isEmpty()) {
                        if (trim.charAt(i2) == 'z' || trim.charAt(i2) == 'Z') {
                            fArr = new float[i2];
                        } else {
                            try {
                                float[] fArr2 = new float[trim.length()];
                                int length = trim.length();
                                int i5 = 1;
                                int i6 = 0;
                                while (i5 < length) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    boolean z4 = false;
                                    for (int i7 = i5; i7 < trim.length(); i7++) {
                                        char charAt2 = trim.charAt(i7);
                                        if (charAt2 != ' ') {
                                            if (charAt2 != 'E' && charAt2 != 'e') {
                                                switch (charAt2) {
                                                    case ',':
                                                        break;
                                                    case '-':
                                                        if (i7 != i5 && !z) {
                                                            z = false;
                                                            z3 = true;
                                                            z4 = true;
                                                            break;
                                                        }
                                                        z = false;
                                                        break;
                                                    case '.':
                                                        if (!z2) {
                                                            z = false;
                                                            z2 = true;
                                                            break;
                                                        }
                                                        z = false;
                                                        z3 = true;
                                                        z4 = true;
                                                        break;
                                                    default:
                                                        z = false;
                                                        break;
                                                }
                                            } else {
                                                z = true;
                                            }
                                            if (!z3) {
                                                if (i5 < i7) {
                                                    fArr2[i6] = Float.parseFloat(trim.substring(i5, i7));
                                                    i6++;
                                                }
                                                if (!z4) {
                                                    i5 = i7;
                                                } else {
                                                    i5 = i7 + 1;
                                                }
                                            }
                                        }
                                        z = false;
                                        z3 = true;
                                        if (!z3) {
                                        }
                                    }
                                    if (i5 < i7) {
                                    }
                                    if (!z4) {
                                    }
                                }
                                fArr = copyOfRange(fArr2, i6);
                                i2 = 0;
                            } catch (NumberFormatException e) {
                                throw new RuntimeException(ViewModelProvider.Factory.CC.m595m("error in parsing \"", trim, "\""), e);
                            }
                        }
                        arrayList.add(new PathParser$PathDataNode(trim.charAt(i2), fArr));
                    }
                    i4 = i3;
                    i3++;
                    i2 = 0;
                }
                i3++;
            }
            trim = str.substring(i4, i3).trim();
            if (!trim.isEmpty()) {
            }
            i4 = i3;
            i3++;
            i2 = 0;
        }
        if (i3 - i4 != 1 || i4 >= str.length()) {
            i = 0;
        } else {
            i = 0;
            arrayList.add(new PathParser$PathDataNode(str.charAt(i4), new float[0]));
        }
        return (PathParser$PathDataNode[]) arrayList.toArray(new PathParser$PathDataNode[i]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        try {
            PathParser$PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing ".concat(str), e);
        }
    }

    public static PathParser$PathDataNode[] deepCopyNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = new PathParser$PathDataNode[pathParser$PathDataNodeArr.length];
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            pathParser$PathDataNodeArr2[i] = new PathParser$PathDataNode(pathParser$PathDataNodeArr[i]);
        }
        return pathParser$PathDataNodeArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.core.view.ViewCompat$UnhandledKeyEventManager, java.lang.Object] */
    public static boolean dispatchBeforeHierarchy(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int indexOfKey;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
        ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager = (ViewCompat.UnhandledKeyEventManager) view.getTag(C0130R.C0132id.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager2 = unhandledKeyEventManager;
        if (unhandledKeyEventManager == null) {
            ?? obj = new Object();
            obj.mViewsContainingListeners = null;
            obj.mCapturedKeys = null;
            obj.mLastDispatchedPreViewKeyEvent = null;
            view.setTag(C0130R.C0132id.tag_unhandled_key_event_manager, obj);
            unhandledKeyEventManager2 = obj;
        }
        WeakReference weakReference2 = unhandledKeyEventManager2.mLastDispatchedPreViewKeyEvent;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        unhandledKeyEventManager2.mLastDispatchedPreViewKeyEvent = new WeakReference(keyEvent);
        if (unhandledKeyEventManager2.mCapturedKeys == null) {
            unhandledKeyEventManager2.mCapturedKeys = new SparseArray();
        }
        SparseArray sparseArray = unhandledKeyEventManager2.mCapturedKeys;
        if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
            sparseArray.removeAt(indexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(C0130R.C0132id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean dispatchKeyEvent(KeyEventDispatcher$Component keyEventDispatcher$Component, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        Window window;
        boolean z = false;
        if (keyEventDispatcher$Component != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return keyEventDispatcher$Component.superDispatchKeyEvent(keyEvent);
            }
            KeyEvent.DispatcherState dispatcherState = null;
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window2 = activity.getWindow();
                if (window2.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!sActionBarFieldsFetched) {
                            try {
                                sActionBarOnMenuKeyMethod = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            sActionBarFieldsFetched = true;
                        }
                        Method method = sActionBarOnMenuKeyMethod;
                        if (method != null) {
                            try {
                                Object invoke = method.invoke(actionBar, keyEvent);
                                if (invoke != null) {
                                    z = ((Boolean) invoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (z) {
                            return true;
                        }
                    }
                }
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window2.getDecorView();
                if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView, keyEvent)) {
                    return true;
                }
                if (decorView != null) {
                    dispatcherState = decorView.getKeyDispatcherState();
                }
                return keyEvent.dispatch(activity, dispatcherState, activity);
            } else if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!sDialogFieldsFetched) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        sDialogKeyListenerField = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    sDialogFieldsFetched = true;
                }
                Field field = sDialogKeyListenerField;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                    }
                    if (onKeyListener == null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                        return true;
                    }
                    window = dialog.getWindow();
                    if (!window.superDispatchKeyEvent(keyEvent)) {
                        return true;
                    }
                    View decorView2 = window.getDecorView();
                    if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(decorView2, keyEvent)) {
                        return true;
                    }
                    if (decorView2 != null) {
                        dispatcherState = decorView2.getKeyDispatcherState();
                    }
                    return keyEvent.dispatch(dialog, dispatcherState, dialog);
                }
                onKeyListener = null;
                if (onKeyListener == null) {
                }
                window = dialog.getWindow();
                if (!window.superDispatchKeyEvent(keyEvent)) {
                }
            } else if ((view != null && ViewCompat.dispatchUnhandledKeyEventBeforeCallback(view, keyEvent)) || keyEventDispatcher$Component.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static void flushThemedResourcesCache(Object obj) {
        LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        Class cls = sThemedResourceCacheClazz;
        if (cls != null) {
            if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    sThemedResourceCache_mUnthemedEntriesField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
            }
            Field field = sThemedResourceCache_mUnthemedEntriesField;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    public static Drawable getButtonDrawable(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return CompoundButtonCompat$Api23Impl.getButtonDrawable(compoundButton);
        }
        if (!sButtonDrawableFieldFetched) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                sButtonDrawableField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            sButtonDrawableFieldFetched = true;
        }
        Field field = sButtonDrawableField;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                sButtonDrawableField = null;
            }
        }
        return null;
    }

    public static int getColor(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ContextCompat$Api23Impl.getColor(context, i);
        }
        return context.getResources().getColor(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r5.mThemeHash == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStateList getColorStateList(Context context, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ResourcesCompat.ColorStateListCacheEntry colorStateListCacheEntry;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        ResourcesCompat.ColorStateListCacheKey colorStateListCacheKey = new ResourcesCompat.ColorStateListCacheKey(resources, theme);
        synchronized (ResourcesCompat.sColorStateCacheLock) {
            try {
                SparseArray sparseArray = (SparseArray) ResourcesCompat.sColorStateCaches.get(colorStateListCacheKey);
                colorStateList = null;
                if (!(sparseArray == null || sparseArray.size() <= 0 || (colorStateListCacheEntry = (ResourcesCompat.ColorStateListCacheEntry) sparseArray.get(i)) == null)) {
                    if (colorStateListCacheEntry.mConfiguration.equals(resources.getConfiguration())) {
                        if (theme == null) {
                            if (colorStateListCacheEntry.mThemeHash != 0) {
                            }
                            colorStateList2 = colorStateListCacheEntry.mValue;
                        }
                        if (theme != null) {
                        }
                    }
                    sparseArray.remove(i);
                }
                colorStateList2 = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            try {
                colorStateList = ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), theme);
            } catch (Exception e) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateList != null) {
            ResourcesCompat.addColorStateListToCache(colorStateListCacheKey, i, colorStateList, theme);
            return colorStateList;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return ResourcesCompat.Api23Impl.getColorStateList(resources, i, theme);
        } else {
            return resources.getColorStateList(i);
        }
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return EdgeEffectCompat$Api31Impl.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public static Drawable getDrawable(Context context, int i) {
        return ResourceManagerInternal.get().getDrawable(context, i);
    }

    public static int getLayoutDirection(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return DrawableCompat$Api23Impl.getLayoutDirection(drawable);
        }
        if (!sGetLayoutDirectionMethodFetched) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", null);
                sGetLayoutDirectionMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
            }
            sGetLayoutDirectionMethodFetched = true;
        }
        Method method = sGetLayoutDirectionMethod;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(drawable, null)).intValue();
        } catch (Exception e2) {
            Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
            sGetLayoutDirectionMethod = null;
            return 0;
        }
    }

    public static Object getSystemService(Context context, Class cls) {
        String str;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return ContextCompat$Api23Impl.getSystemService(context, cls);
        }
        if (i >= 23) {
            str = ContextCompat$Api23Impl.getSystemServiceName(context, cls);
        } else {
            str = (String) ContextCompat$LegacyServiceMapHolder.SERVICES.get(cls);
        }
        if (str != null) {
            return context.getSystemService(str);
        }
        return null;
    }

    public static File getTempFile(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static int indexOf(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(i, "type needs to be >= FIRST and <= LAST, type="));
    }

    public static boolean isCandidate(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            int i2 = rect.right;
            int i3 = rect2.right;
            if ((i2 > i3 || rect.left >= i3) && rect.left > rect2.left) {
                return true;
            }
            return false;
        } else if (i == 33) {
            int i4 = rect.bottom;
            int i5 = rect2.bottom;
            if ((i4 > i5 || rect.top >= i5) && rect.top > rect2.top) {
                return true;
            }
            return false;
        } else if (i == 66) {
            int i6 = rect.left;
            int i7 = rect2.left;
            if ((i6 < i7 || rect.right <= i7) && rect.right < rect2.right) {
                return true;
            }
            return false;
        } else if (i == 130) {
            int i8 = rect.top;
            int i9 = rect2.top;
            if ((i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom) {
                return true;
            }
            return false;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static boolean isFromSource(MotionEvent motionEvent, int i) {
        if ((motionEvent.getSource() & i) == i) {
            return true;
        }
        return false;
    }

    public static int majorAxisDistance(int i, Rect rect, Rect rect2) {
        int i2;
        int i3;
        if (i == 17) {
            i2 = rect.left;
            i3 = rect2.right;
        } else if (i == 33) {
            i2 = rect.top;
            i3 = rect2.bottom;
        } else if (i == 66) {
            i2 = rect2.left;
            i3 = rect.right;
        } else if (i == 130) {
            i2 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return Math.max(0, i2 - i3);
    }

    public static int minorAxisDistance(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static MappedByteBuffer mmap(Context context, Uri uri) {
        ParcelFileDescriptor openFileDescriptor;
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (openFileDescriptor == null) {
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
                return null;
            }
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
        FileChannel channel = fileInputStream.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
        fileInputStream.close();
        openFileDescriptor.close();
        return map;
    }

    public static void onCreateInputConnection(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
            }
        }
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return EdgeEffectCompat$Api31Impl.onPullDistance(edgeEffect, f, f2);
        }
        EdgeEffectCompat$Api21Impl.onPull(edgeEffect, f, f2);
        return f;
    }

    public static void setDecorFitsSystemWindows(Window window, boolean z) {
        int i;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowCompat$Api30Impl.setDecorFitsSystemWindows(window, z);
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z) {
            i = systemUiVisibility & (-1793);
        } else {
            i = systemUiVisibility | 1792;
        }
        decorView.setSystemUiVisibility(i);
    }

    public static boolean setLayoutDirection(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return DrawableCompat$Api23Impl.setLayoutDirection(drawable, i);
        }
        if (!sSetLayoutDirectionMethodFetched) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                sSetLayoutDirectionMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            sSetLayoutDirectionMethodFetched = true;
        }
        Method method = sSetLayoutDirectionMethod;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i));
                return true;
            } catch (Exception e2) {
                Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                sSetLayoutDirectionMethod = null;
            }
        }
        return false;
    }

    public static void setOverlapAnchor(AppCompatPopupWindow appCompatPopupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            PopupWindowCompat$Api23Impl.setOverlapAnchor(appCompatPopupWindow, z);
            return;
        }
        if (!sOverlapAnchorFieldAttempted) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                sOverlapAnchorField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
            sOverlapAnchorFieldAttempted = true;
        }
        Field field = sOverlapAnchorField;
        if (field != null) {
            try {
                field.set(appCompatPopupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e2) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
            }
        }
    }

    public static void setTint(Drawable drawable, int i) {
        DrawableCompat$Api21Impl.setTint(drawable, i);
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            TooltipCompat$Api26Impl.setTooltipText(view, charSequence);
            return;
        }
        TooltipCompatHandler tooltipCompatHandler = TooltipCompatHandler.sPendingHandler;
        if (tooltipCompatHandler != null && tooltipCompatHandler.mAnchor == view) {
            TooltipCompatHandler.setPendingHandler(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler tooltipCompatHandler2 = TooltipCompatHandler.sActiveHandler;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.mAnchor == view) {
                tooltipCompatHandler2.hide();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            PopupWindowCompat$Api23Impl.setWindowLayoutType(popupWindow, i);
            return;
        }
        if (!sSetWindowLayoutTypeMethodAttempted) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                sSetWindowLayoutTypeMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            sSetWindowLayoutTypeMethodAttempted = true;
        }
        Method method = sSetWindowLayoutTypeMethod;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i));
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.core.graphics.drawable.WrappedDrawableApi21, android.graphics.drawable.Drawable] */
    public static Drawable wrap(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 || (drawable instanceof TintAwareDrawable)) {
            return drawable;
        }
        ?? drawable2 = new Drawable();
        drawable2.mState = drawable2.mutateConstantState();
        drawable2.setWrappedDrawable(drawable);
        WrappedDrawableApi21.findAndCacheIsProjectedDrawableMethod();
        return drawable2;
    }

    public static zzeu zzb() {
        String str;
        ClassLoader classLoader = BundleKt.class.getClassLoader();
        if (zzeu.class.equals(zzeu.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else if (!zzeu.class.getPackage().equals(BundleKt.class.getPackage())) {
            throw new IllegalArgumentException(zzeu.class.getName());
        } else {
            str = ViewModelProvider.Factory.CC.m596m(zzeu.class.getPackage().getName(), ".BlazeGeneratedzzeuLoader");
        }
        try {
            try {
                try {
                    try {
                        ViewModelProvider.Factory.CC.m600m(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                        throw null;
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (InstantiationException e3) {
                throw new IllegalStateException(e3);
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Object obj : Arrays.asList(new BundleKt[0])) {
                    try {
                        if (obj != null) {
                            throw new ClassCastException();
                            break;
                        }
                        throw null;
                    } catch (ServiceConfigurationError e5) {
                        Logger.getLogger(zzem.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat("zzeu"), (Throwable) e5);
                    }
                }
                if (arrayList.size() == 1) {
                    return (zzeu) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (zzeu) zzeu.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(e6);
                } catch (NoSuchMethodException e7) {
                    throw new IllegalStateException(e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(e8);
                }
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public boolean canReverse() {
        return false;
    }

    public abstract boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture.Listener listener);

    public abstract boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

    public abstract boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2);

    public abstract int clampViewPositionHorizontal(int i, View view);

    public abstract int clampViewPositionVertical(int i, View view);

    public abstract Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i);

    public abstract Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i);

    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!copyToFile(inputStream, tempFile)) {
                return null;
            }
            return Typeface.createFromFile(tempFile.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        File tempFile = getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!copyToFile(tempFile, resources, i)) {
                return null;
            }
            return Typeface.createFromFile(tempFile.getPath());
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public FontsContractCompat$FontInfo findBestInfo(int i, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr) {
        int i2;
        boolean z;
        int i3;
        if ((i & 1) == 0) {
            i2 = 400;
        } else {
            i2 = 700;
        }
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        FontsContractCompat$FontInfo fontsContractCompat$FontInfo = null;
        int i4 = Integer.MAX_VALUE;
        for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo2 : fontsContractCompat$FontInfoArr) {
            int abs = Math.abs(fontsContractCompat$FontInfo2.mWeight - i2) * 2;
            if (fontsContractCompat$FontInfo2.mItalic == z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            int i5 = abs + i3;
            if (fontsContractCompat$FontInfo == null || i4 > i5) {
                fontsContractCompat$FontInfo = fontsContractCompat$FontInfo2;
                i4 = i5;
            }
        }
        return fontsContractCompat$FontInfo;
    }

    public abstract float getValue(Shapeable shapeable);

    public int getViewHorizontalDragRange(View view) {
        return 0;
    }

    public int getViewVerticalDragRange() {
        return 0;
    }

    public abstract void onViewDragStateChanged(int i);

    public abstract void onViewPositionChanged(View view, int i, int i2);

    public abstract void onViewReleased(View view, float f, float f2);

    public abstract void putNext(AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2);

    public abstract void putThread(AbstractResolvableFuture.Waiter waiter, Thread thread);

    public abstract void setValue(Shapeable shapeable, float f);

    public abstract void start();

    public abstract void stop();

    public abstract boolean tryCaptureView(int i, View view);

    public static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static boolean copyToFile(File file, Resources resources, int i) {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = resources.openRawResource(i);
            try {
                boolean copyToFile = copyToFile(inputStream, file);
                closeQuietly(inputStream);
                return copyToFile;
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public void setAppearanceLightNavigationBars(boolean z) {
    }

    public void setAppearanceLightStatusBars(boolean z) {
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel() {
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart() {
    }

    public void onEdgeTouched() {
    }

    public void reverse() {
    }

    public void onEdgeDragStarted(int i, int i2) {
    }

    public void onViewCaptured(int i, View view) {
    }
}
