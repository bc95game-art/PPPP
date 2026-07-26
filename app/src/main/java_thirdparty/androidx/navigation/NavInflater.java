package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.NavType;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class NavInflater {
    public static final ThreadLocal sTmpValue = new ThreadLocal();
    public final Context context;
    public final NavigatorProvider navigatorProvider;

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.context = context;
        this.navigatorProvider = navigatorProvider;
    }

    public static NavArgument inflateArgument(TypedArray typedArray, Resources resources, int i) {
        NavType navType;
        Object[] objArr;
        boolean z;
        NavType navType2;
        boolean z2;
        boolean z3 = typedArray.getBoolean(3, false);
        ThreadLocal threadLocal = sTmpValue;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(2);
        if (string != null) {
            String resourcePackageName = resources.getResourcePackageName(i);
            if (string.startsWith("java")) {
                try {
                    navType = Navigation.fromArgType("j$" + string.substring(4), resourcePackageName);
                } catch (RuntimeException e) {
                    if (!(e.getCause() instanceof ClassNotFoundException)) {
                        throw e;
                    }
                }
            }
            navType = Navigation.fromArgType(string, resourcePackageName);
        } else {
            navType = null;
        }
        boolean value = typedArray.getValue(1, typedValue);
        IntNavType intNavType = NavType.LongType;
        IntNavType intNavType2 = NavType.BoolType;
        IntNavType intNavType3 = NavType.StringType;
        IntNavType intNavType4 = NavType.IntType;
        IntNavType intNavType5 = NavType.FloatType;
        if (value) {
            IntNavType intNavType6 = NavType.ReferenceType;
            if (navType == intNavType6) {
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    objArr = Integer.valueOf(i2);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    objArr = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + navType.getName() + ". Must be a reference to a resource.");
                }
            } else {
                int i3 = typedValue.resourceId;
                if (i3 != 0) {
                    if (navType == null) {
                        objArr = Integer.valueOf(i3);
                        navType = intNavType6;
                    } else {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + navType.getName() + ". You must use a \"reference\" type to reference other resources.");
                    }
                } else if (navType == intNavType3) {
                    objArr = typedArray.getString(1);
                } else {
                    int i4 = typedValue.type;
                    if (i4 == 3) {
                        String value2 = typedValue.string.toString();
                        if (navType == null) {
                            Intrinsics.checkNotNullParameter(value2, "value");
                            try {
                                try {
                                    try {
                                        try {
                                            intNavType4.mo19parseValue(value2);
                                            navType = intNavType4;
                                        } catch (IllegalArgumentException unused) {
                                            navType = intNavType3;
                                        }
                                    } catch (IllegalArgumentException unused2) {
                                        intNavType2.mo19parseValue(value2);
                                        navType = intNavType2;
                                    }
                                } catch (IllegalArgumentException unused3) {
                                    intNavType5.mo19parseValue(value2);
                                    navType = intNavType5;
                                }
                            } catch (IllegalArgumentException unused4) {
                                intNavType.mo19parseValue(value2);
                                navType = intNavType;
                            }
                        }
                        objArr = navType.mo19parseValue(value2);
                    } else if (i4 == 4) {
                        navType = Navigation.checkNavType$navigation_runtime_release(typedValue, navType, intNavType5, string, "float");
                        objArr = Float.valueOf(typedValue.getFloat());
                    } else if (i4 == 5) {
                        navType = Navigation.checkNavType$navigation_runtime_release(typedValue, navType, intNavType4, string, "dimension");
                        objArr = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i4 == 18) {
                        navType = Navigation.checkNavType$navigation_runtime_release(typedValue, navType, intNavType2, string, "boolean");
                        if (typedValue.data != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr = Boolean.valueOf(z2);
                    } else if (i4 < 16 || i4 > 31) {
                        throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                    } else if (navType == intNavType5) {
                        navType = Navigation.checkNavType$navigation_runtime_release(typedValue, navType, intNavType5, string, "float");
                        objArr = Float.valueOf(typedValue.data);
                    } else {
                        navType = Navigation.checkNavType$navigation_runtime_release(typedValue, navType, intNavType4, string, "integer");
                        objArr = Integer.valueOf(typedValue.data);
                    }
                }
            }
        } else {
            objArr = null;
        }
        if (objArr != null) {
            z = true;
        } else {
            objArr = null;
            z = false;
        }
        if (navType == null) {
            navType = null;
        }
        if (navType == null) {
            if (objArr instanceof Integer) {
                navType2 = intNavType4;
            } else if (objArr instanceof int[]) {
                navType2 = NavType.IntArrayType;
            } else if (objArr instanceof Long) {
                navType2 = intNavType;
            } else if (objArr instanceof long[]) {
                navType2 = NavType.LongArrayType;
            } else if (objArr instanceof Float) {
                navType2 = intNavType5;
            } else if (objArr instanceof float[]) {
                navType2 = NavType.FloatArrayType;
            } else if (objArr instanceof Boolean) {
                navType2 = intNavType2;
            } else if (objArr instanceof boolean[]) {
                navType2 = NavType.BoolArrayType;
            } else if ((objArr instanceof String) || objArr == null) {
                navType2 = intNavType3;
            } else {
                navType2 = null;
            }
            if (navType2 != null) {
                navType = navType2;
            } else if (!(objArr instanceof Object[]) || !(objArr instanceof String[])) {
                Intrinsics.checkNotNull(objArr);
                if (objArr.getClass().isArray()) {
                    Class<?> componentType = objArr.getClass().getComponentType();
                    Intrinsics.checkNotNull(componentType);
                    if (Parcelable.class.isAssignableFrom(componentType)) {
                        Class<?> componentType2 = objArr.getClass().getComponentType();
                        Intrinsics.checkNotNull(componentType2, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                        navType = new NavType.ParcelableArrayType(componentType2);
                    }
                }
                if (objArr.getClass().isArray()) {
                    Class<?> componentType3 = objArr.getClass().getComponentType();
                    Intrinsics.checkNotNull(componentType3);
                    if (Serializable.class.isAssignableFrom(componentType3)) {
                        Class<?> componentType4 = objArr.getClass().getComponentType();
                        Intrinsics.checkNotNull(componentType4, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                        navType = new NavType.SerializableArrayType(componentType4);
                    }
                }
                if (objArr instanceof Parcelable) {
                    navType = new NavType.ParcelableType(objArr.getClass());
                } else if (objArr instanceof Enum) {
                    navType = new NavType.EnumType(objArr.getClass());
                } else if (objArr instanceof Serializable) {
                    navType = new NavType.SerializableType(objArr.getClass());
                } else {
                    throw new IllegalArgumentException("Object of type " + objArr.getClass().getName() + " is not supported for navigation arguments.");
                }
            } else {
                navType = NavType.StringArrayType;
            }
        }
        return new NavArgument(navType, z3, objArr, z);
    }

    public final NavGraph inflate(int i) {
        int next;
        Resources resources = this.context.getResources();
        XmlResourceParser xml = resources.getXml(i);
        Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            Intrinsics.checkNotNull(asAttributeSet);
            NavDestination inflate = inflate(resources, xml, asAttributeSet, i);
            if (inflate instanceof NavGraph) {
                return (NavGraph) inflate;
            }
            throw new IllegalArgumentException(("Root element <" + name + "> did not inflate into a NavGraph").toString());
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0293, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0147, code lost:
        throw new org.xmlpull.v1.XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.navigation.NavDestination inflate(android.content.res.Resources r29, android.content.res.XmlResourceParser r30, android.util.AttributeSet r31, int r32) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflate(android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, int):androidx.navigation.NavDestination");
    }
}
