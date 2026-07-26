package androidx.navigation;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.emoji2.text.flatbuffer.Table;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavContext;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.startup.StartupException;
import androidx.transition.ViewGroupUtils$Api29Impl;
import androidx.viewpager2.widget.FakeDrag;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.FilteringSequence$iterator$1;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TakeWhileSequence;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public abstract class Navigation {
    public static boolean sTryHiddenSuppressLayout = true;
    public static Boolean zze;
    public static Boolean zzf;
    public static Boolean zzh;
    public static Boolean zzj;

    public static NavType checkNavType$navigation_runtime_release(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) {
        if (navType != null && navType != navType2) {
            throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
        } else if (navType == null) {
            return navType2;
        } else {
            return navType;
        }
    }

    public static int computeScrollExtent(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
    }

    public static int computeScrollOffset(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        int i;
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z2) {
            i = Math.max(0, (state.getItemCount() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((i * (Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) + (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view)));
    }

    public static int computeScrollRange(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.getItemCount();
        }
        return (int) (((orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)) * state.getItemCount());
    }

    public static final boolean contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj != obj2 && !Intrinsics.areEqual(obj, obj2)) {
                if (!(obj == null || obj2 == null)) {
                    if (!(obj instanceof Bundle) || !(obj2 instanceof Bundle)) {
                        if (!(obj instanceof Object[]) || !(obj2 instanceof Object[])) {
                            if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
                                if (!(obj instanceof short[]) || !(obj2 instanceof short[])) {
                                    if (!(obj instanceof int[]) || !(obj2 instanceof int[])) {
                                        if (!(obj instanceof long[]) || !(obj2 instanceof long[])) {
                                            if (!(obj instanceof float[]) || !(obj2 instanceof float[])) {
                                                if (!(obj instanceof double[]) || !(obj2 instanceof double[])) {
                                                    if (!(obj instanceof char[]) || !(obj2 instanceof char[])) {
                                                        if (!(obj instanceof boolean[]) || !(obj2 instanceof boolean[])) {
                                                            if (!obj.equals(obj2)) {
                                                            }
                                                        } else if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                                                            return false;
                                                        }
                                                    } else if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                                return false;
                            }
                        } else if (!ArraysKt.contentDeepEquals((Object[]) obj, (Object[]) obj2)) {
                            return false;
                        }
                    } else if (!contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt((Bundle) obj, (Bundle) obj2)) {
                        return false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static final int contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(Bundle bundle) {
        int i;
        int i2 = 1;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                i = contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt((Bundle) obj);
            } else if (obj instanceof Object[]) {
                i = Arrays.deepHashCode((Object[]) obj);
            } else if (obj instanceof byte[]) {
                i = Arrays.hashCode((byte[]) obj);
            } else if (obj instanceof short[]) {
                i = Arrays.hashCode((short[]) obj);
            } else if (obj instanceof int[]) {
                i = Arrays.hashCode((int[]) obj);
            } else if (obj instanceof long[]) {
                i = Arrays.hashCode((long[]) obj);
            } else if (obj instanceof float[]) {
                i = Arrays.hashCode((float[]) obj);
            } else if (obj instanceof double[]) {
                i = Arrays.hashCode((double[]) obj);
            } else if (obj instanceof char[]) {
                i = Arrays.hashCode((char[]) obj);
            } else if (obj instanceof boolean[]) {
                i = Arrays.hashCode((boolean[]) obj);
            } else if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i2 = (i2 * 31) + i;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.emoji2.text.FontRequestEmojiCompatConfig create(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Ld
            androidx.emoji2.text.DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28 r0 = new androidx.emoji2.text.DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28
            r1 = 5
            r0.<init>(r1)
            goto L13
        Ld:
            androidx.transition.Transition$1 r0 = new androidx.transition.Transition$1
            r1 = 5
            r0.<init>(r1)
        L13:
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            androidx.core.util.TimeUtils.checkNotNull(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2c:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L48
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L2c
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L2c
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L2c
            goto L49
        L48:
            r4 = r5
        L49:
            if (r4 != 0) goto L4d
        L4b:
            r1 = r5
            goto L7c
        L4d:
            java.lang.String r2 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            android.content.pm.Signature[] r0 = r0.getSigningSignatures(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            int r6 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
        L5b:
            if (r3 >= r6) goto L69
            r7 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            r1.add(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            int r3 = r3 + 1
            goto L5b
        L69:
            java.util.List r0 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            androidx.core.provider.FontRequest r1 = new androidx.core.provider.FontRequest     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            java.lang.String r3 = "emojicompat-emoji-font"
            r1.<init>(r2, r4, r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            goto L7c
        L75:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
            goto L4b
        L7c:
            if (r1 != 0) goto L7f
            goto L89
        L7f:
            androidx.emoji2.text.FontRequestEmojiCompatConfig r5 = new androidx.emoji2.text.FontRequestEmojiCompatConfig
            androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader r0 = new androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader
            r0.<init>(r8, r1)
            r5.<init>(r0)
        L89:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.Navigation.create(android.content.Context):androidx.emoji2.text.FontRequestEmojiCompatConfig");
    }

    public static Parcelable createParcelable(Parcel parcel, int i, Parcelable.Creator creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + readSize);
        return parcelable;
    }

    public static String createString(Parcel parcel, int i) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + readSize);
        return readString;
    }

    public static Object[] createTypedArray(Parcel parcel, int i, Parcelable.Creator creator) {
        int readSize = readSize(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (readSize == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + readSize);
        return createTypedArray;
    }

    public static ViewModel createViewModel(Class cls) {
        try {
            Object newInstance = cls.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(newInstance);
            return (ViewModel) newInstance;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        }
    }

    public static void d(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, obj));
        }
    }

    public static void e(String str, String str2, Exception exc) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            Log.e(tag, str2, exc);
        }
    }

    public static void ensureAtEnd(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new StartupException(ViewModelProvider.Factory.CC.m(i, "Overread allowed size end="), parcel);
        }
    }

    public static final NavController findNavController(View view) {
        Object obj;
        Intrinsics.checkNotNullParameter(view, "view");
        FilteringSequence$iterator$1 filteringSequence$iterator$1 = new FilteringSequence$iterator$1(new FilteringSequence(0, new TakeWhileSequence(SequencesKt.generateSequence(view, new Navigation$$ExternalSyntheticLambda0(0)), new Navigation$$ExternalSyntheticLambda0(6), 1)));
        if (!filteringSequence$iterator$1.hasNext()) {
            obj = null;
        } else {
            obj = filteringSequence$iterator$1.next();
        }
        NavController navController = (NavController) obj;
        if (navController != null) {
            return navController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static NavType fromArgType(String str, String str2) {
        NavType navType;
        String str3;
        boolean equals = "integer".equals(str);
        IntNavType intNavType = NavType.StringType;
        if (equals) {
            navType = NavType.IntType;
        } else if ("integer[]".equals(str)) {
            navType = NavType.IntArrayType;
        } else if ("List<Int>".equals(str)) {
            navType = NavType.IntListType;
        } else if ("long".equals(str)) {
            navType = NavType.LongType;
        } else if ("long[]".equals(str)) {
            navType = NavType.LongArrayType;
        } else if ("List<Long>".equals(str)) {
            navType = NavType.LongListType;
        } else if ("boolean".equals(str)) {
            navType = NavType.BoolType;
        } else if ("boolean[]".equals(str)) {
            navType = NavType.BoolArrayType;
        } else if ("List<Boolean>".equals(str)) {
            navType = NavType.BoolListType;
        } else if ("string".equals(str)) {
            navType = intNavType;
        } else if ("string[]".equals(str)) {
            navType = NavType.StringArrayType;
        } else if ("List<String>".equals(str)) {
            navType = NavType.StringListType;
        } else if ("float".equals(str)) {
            navType = NavType.FloatType;
        } else if ("float[]".equals(str)) {
            navType = NavType.FloatArrayType;
        } else if ("List<Float>".equals(str)) {
            navType = NavType.FloatListType;
        } else {
            navType = null;
        }
        if (navType != null) {
            return navType;
        }
        if ("reference".equals(str)) {
            return NavType.ReferenceType;
        }
        if (str == null || str.length() == 0) {
            return intNavType;
        }
        try {
            if (!str.startsWith(".") || str2 == null) {
                str3 = str;
            } else {
                str3 = str2.concat(str);
            }
            boolean endsWith = str.endsWith("[]");
            if (endsWith) {
                str3 = str3.substring(0, str3.length() - 2);
                Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
            }
            NavType parseSerializableOrParcelableType$navigation_common_release = parseSerializableOrParcelableType$navigation_common_release(Class.forName(str3), endsWith);
            if (parseSerializableOrParcelableType$navigation_common_release != null) {
                return parseSerializableOrParcelableType$navigation_common_release;
            }
            throw new IllegalArgumentException((str3 + " is not Serializable or Parcelable.").toString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String getCanonicalName(ClassReference classReference) {
        String str;
        HashMap hashMap = ClassReference.classFqNames;
        Class jClass = classReference.jClass;
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        String str2 = null;
        if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
            return null;
        }
        if (jClass.isArray()) {
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) hashMap.get(componentType.getName())) != null) {
                str2 = str.concat("Array");
            }
            if (str2 == null) {
                return "kotlin.Array";
            }
            return str2;
        }
        String str3 = (String) hashMap.get(jClass.getName());
        if (str3 == null) {
            return jClass.getCanonicalName();
        }
        return str3;
    }

    public static String getDisplayName(NavContext context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i <= 16777215) {
            return String.valueOf(i);
        }
        try {
            String resourceName = context.context.getResources().getResourceName(i);
            Intrinsics.checkNotNull(resourceName);
            return resourceName;
        } catch (Resources.NotFoundException unused) {
            return String.valueOf(i);
        }
    }

    public static Set getExclusions() {
        try {
            Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (invoke == null) {
                return Collections.EMPTY_SET;
            }
            Set<Object> set = (Set) invoke;
            for (Object obj : set) {
                if (!(obj instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static NavControllerViewModel getInstance(ViewModelStore viewModelStore) {
        FakeDrag factory = NavControllerViewModelKt.FACTORY;
        CreationExtras.Empty extras = CreationExtras.Empty.INSTANCE;
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(extras, "extras");
        MetadataRepo metadataRepo = new MetadataRepo(viewModelStore, factory, extras);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NavControllerViewModel.class);
        String canonicalName = getCanonicalName(orCreateKotlinClass);
        if (canonicalName != null) {
            return (NavControllerViewModel) metadataRepo.getViewModel$lifecycle_viewmodel_release(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* renamed from: getInt-impl  reason: not valid java name */
    public static final int m20getIntimpl(Bundle bundle, String str) {
        int i = bundle.getInt(str, Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE || bundle.getInt(str, Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i;
        }
        keyOrValueNotFoundError(str);
        throw null;
    }

    public static String getNameForNavigator$navigation_common_release(Class cls) {
        LinkedHashMap linkedHashMap = NavigatorProvider.annotationNames;
        String str = (String) linkedHashMap.get(cls);
        if (str == null) {
            Navigator.Name name = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
            if (name != null) {
                str = name.value();
            } else {
                str = null;
            }
            if (str == null || str.length() <= 0) {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for ".concat(cls.getSimpleName()).toString());
            }
            linkedHashMap.put(cls, str);
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    /* renamed from: getSavedStateList-impl  reason: not valid java name */
    public static final ArrayList m21getSavedStateListimpl(Bundle bundle, String key) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(key, "key");
        Class javaClass = RangesKt.getJavaClass(Reflection.getOrCreateKotlinClass(Bundle.class));
        if (Build.VERSION.SDK_INT >= 34) {
            arrayList = BundleCompat$Api33Impl.getParcelableArrayList(bundle, key, javaClass);
        } else {
            arrayList = bundle.getParcelableArrayList(key);
        }
        if (arrayList != null) {
            return arrayList;
        }
        keyOrValueNotFoundError(key);
        throw null;
    }

    public static String getTag(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String concat = "TRuntime.".concat(str);
        if (concat.length() > 23) {
            return concat.substring(0, 23);
        }
        return concat;
    }

    /* renamed from: isNull-impl  reason: not valid java name */
    public static final boolean m22isNullimpl(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!bundle.containsKey(key) || bundle.get(key) != null) {
            return false;
        }
        return true;
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zze == null) {
            zze = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (zze.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (zzf == null) {
            zzf = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (!zzf.booleanValue()) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 26 || i >= 30) {
            return true;
        }
        return false;
    }

    public static final void keyOrValueNotFoundError(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m("No valid saved state was found for the key '", key, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
    }

    public static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static final ArrayList missingRequiredArguments(Map map, Function1 function1) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            NavArgument navArgument = (NavArgument) entry.getValue();
            if (navArgument != null) {
                bool = Boolean.valueOf(navArgument.isNullable);
            } else {
                bool = null;
            }
            Intrinsics.checkNotNull(bool);
            if (!bool.booleanValue() && !navArgument.isDefaultValuePresent) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : keySet) {
            if (((Boolean) function1.invoke((String) obj)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static NavType parseSerializableOrParcelableType$navigation_common_release(Class cls, boolean z) {
        if (Parcelable.class.isAssignableFrom(cls)) {
            if (z) {
                return new NavType.ParcelableArrayType(cls);
            }
            return new NavType.ParcelableType(cls);
        } else if (Enum.class.isAssignableFrom(cls) && !z) {
            return new NavType.EnumType(cls);
        } else {
            if (!Serializable.class.isAssignableFrom(cls)) {
                return null;
            }
            if (z) {
                return new NavType.SerializableArrayType(cls);
            }
            return new NavType.SerializableType(cls);
        }
    }

    /* renamed from: putNull-impl  reason: not valid java name */
    public static final void m23putNullimpl(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putString(key, null);
    }

    /* renamed from: putSavedState-impl  reason: not valid java name */
    public static final void m24putSavedStateimpl(Bundle bundle, String key, Bundle value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putBundle(key, value);
    }

    /* renamed from: putString-impl  reason: not valid java name */
    public static final void m25putStringimpl(Bundle bundle, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        bundle.putString(key, value);
    }

    /* renamed from: putStringList-impl  reason: not valid java name */
    public static final void m26putStringListimpl(Bundle bundle, String str, List list) {
        ArrayList<String> arrayList;
        if (list instanceof ArrayList) {
            arrayList = (ArrayList) list;
        } else {
            arrayList = new ArrayList<>(list);
        }
        bundle.putStringArrayList(str, arrayList);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.emoji2.text.flatbuffer.MetadataList, androidx.emoji2.text.flatbuffer.Table] */
    public static MetadataList read(MappedByteBuffer mappedByteBuffer) {
        long j;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        duplicate.position(duplicate.position() + 4);
        int i = duplicate.getShort() & 65535;
        if (i <= 100) {
            duplicate.position(duplicate.position() + 6);
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    j = -1;
                    break;
                }
                int i3 = duplicate.getInt();
                duplicate.position(duplicate.position() + 4);
                j = duplicate.getInt() & 4294967295L;
                duplicate.position(duplicate.position() + 4);
                if (1835365473 == i3) {
                    break;
                }
                i2++;
            }
            if (j != -1) {
                duplicate.position(duplicate.position() + ((int) (j - duplicate.position())));
                duplicate.position(duplicate.position() + 12);
                long j2 = duplicate.getInt() & 4294967295L;
                for (int i4 = 0; i4 < j2; i4++) {
                    int i5 = duplicate.getInt();
                    long j3 = duplicate.getInt() & 4294967295L;
                    duplicate.getInt();
                    if (1164798569 == i5 || 1701669481 == i5) {
                        duplicate.position((int) (j3 + j));
                        ?? table = new Table();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        int position = duplicate.position() + duplicate.getInt(duplicate.position());
                        table.bb = duplicate;
                        table.bb_pos = position;
                        int i6 = position - duplicate.getInt(position);
                        table.vtable_start = i6;
                        table.vtable_size = ((ByteBuffer) table.bb).getShort(i6);
                        return table;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    public static boolean readBoolean(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static int readInt(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        return parcel.readInt();
    }

    public static int readSize(Parcel parcel, int i) {
        if ((i & (-65536)) != -65536) {
            return (char) (i >> 16);
        }
        return parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i));
    }

    public static void suppressLayout(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            ViewGroupUtils$Api29Impl.suppressLayout(viewGroup, z);
        } else if (sTryHiddenSuppressLayout) {
            try {
                ViewGroupUtils$Api29Impl.suppressLayout(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    public static int toActivityTransitResId(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int validateObjectHeader(Parcel parcel) {
        int readInt = parcel.readInt();
        int readSize = readSize(parcel, readInt);
        char c = (char) readInt;
        int dataPosition = parcel.dataPosition();
        if (c == 20293) {
            int i = readSize + dataPosition;
            if (i >= dataPosition && i <= parcel.dataSize()) {
                return i;
            }
            throw new StartupException(ViewModelProvider.Factory.CC.m(dataPosition, i, "Size read is invalid start=", " end="), parcel);
        }
        throw new StartupException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(readInt))), parcel);
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable != null) {
            int zza = zza(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            zzb(parcel, zza);
        }
    }

    public static void writeString(Parcel parcel, int i, String str) {
        if (str != null) {
            int zza = zza(parcel, i);
            parcel.writeString(str);
            zzb(parcel, zza);
        }
    }

    public static void writeTypedArray(Parcel parcel, int i, Parcelable[] parcelableArr, int i2) {
        if (parcelableArr != null) {
            int zza = zza(parcel, i);
            parcel.writeInt(parcelableArr.length);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    int dataPosition = parcel.dataPosition();
                    parcel.writeInt(1);
                    int dataPosition2 = parcel.dataPosition();
                    parcelable.writeToParcel(parcel, i2);
                    int dataPosition3 = parcel.dataPosition();
                    parcel.setDataPosition(dataPosition);
                    parcel.writeInt(dataPosition3 - dataPosition2);
                    parcel.setDataPosition(dataPosition3);
                }
            }
            zzb(parcel, zza);
        }
    }

    public static int zza(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void zzb(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzf(i, i2, "index"));
        }
    }

    public static void zzc(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    public static void zzd(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = zzf(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = zzf(i2, i3, "end index");
            } else {
                str = LazyKt__LazyJVMKt.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static String zzf(int i, int i2, String str) {
        if (i < 0) {
            return LazyKt__LazyJVMKt.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return LazyKt__LazyJVMKt.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(i2, "negative size: "));
    }

    public abstract InputFilter[] getFilters(InputFilter[] inputFilterArr);

    public abstract boolean isEnabled();

    public abstract void onFailed(Throwable th);

    public abstract void onLoaded(MetadataRepo metadataRepo);

    public abstract void setAllCaps(boolean z);

    public abstract void setEnabled(boolean z);

    public abstract TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod);

    public static void zzb(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static void zza(int i, int i2) {
        String str;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                str = LazyKt__LazyJVMKt.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else if (i2 < 0) {
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(i2, "negative size: "));
            } else {
                str = LazyKt__LazyJVMKt.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void zzb(Parcel parcel, int i, int i2) {
        int readSize = readSize(parcel, i);
        if (readSize != i2) {
            String hexString = Integer.toHexString(readSize);
            StringBuilder sb = new StringBuilder("Expected size ");
            sb.append(i2);
            sb.append(" got ");
            sb.append(readSize);
            sb.append(" (0x");
            throw new StartupException(ViewModelProvider.Factory.CC.m(sb, hexString, ")"), parcel);
        }
    }
}
