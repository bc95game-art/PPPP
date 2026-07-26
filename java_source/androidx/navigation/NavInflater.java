package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.p002os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavType;
import androidx.navigation.common.R$styleable;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
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
                                            intNavType4.mo649parseValue(value2);
                                            navType = intNavType4;
                                        } catch (IllegalArgumentException unused) {
                                            navType = intNavType3;
                                        }
                                    } catch (IllegalArgumentException unused2) {
                                        intNavType2.mo649parseValue(value2);
                                        navType = intNavType2;
                                    }
                                } catch (IllegalArgumentException unused3) {
                                    intNavType5.mo649parseValue(value2);
                                    navType = intNavType5;
                                }
                            } catch (IllegalArgumentException unused4) {
                                intNavType.mo649parseValue(value2);
                                navType = intNavType;
                            }
                        }
                        objArr = navType.mo649parseValue(value2);
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
    */
    public final NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) {
        int depth;
        Context context;
        NavDestinationImpl navDestinationImpl;
        int i2;
        TypedArray typedArray;
        Object obj;
        String str;
        String str2;
        int i3 = i;
        String name = xmlResourceParser.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        NavDestination createDestination = this.navigatorProvider.getNavigator(name).createDestination();
        Context context2 = this.context;
        createDestination.onInflate(context2, attributeSet);
        NavDestinationImpl navDestinationImpl2 = createDestination.impl;
        int i4 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == i4 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                boolean equals = "argument".equals(name2);
                int[] iArr = R$styleable.NavArgument;
                if (equals) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, iArr);
                    Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
                    String string = obtainAttributes.getString(0);
                    if (string != null) {
                        NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i3);
                        navDestinationImpl2.getClass();
                        ((LinkedHashMap) navDestinationImpl2.arguments).put(string, inflateArgument);
                        obtainAttributes.recycle();
                    } else {
                        throw new XmlPullParserException("Arguments must have a name");
                    }
                } else if ("deepLink".equals(name2)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R$styleable.NavDeepLink);
                    Intrinsics.checkNotNullExpressionValue(obtainAttributes2, "obtainAttributes(...)");
                    String string2 = obtainAttributes2.getString(3);
                    String string3 = obtainAttributes2.getString(1);
                    String string4 = obtainAttributes2.getString(2);
                    if ((string2 == null || string2.length() == 0) && ((string3 == null || string3.length() == 0) && (string4 == null || string4.length() == 0))) {
                        break;
                    }
                    String str3 = null;
                    if (string2 != null) {
                        String packageName = context2.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                        str = StringsKt__StringsKt.replace$default(string2, "${applicationId}", packageName);
                    } else {
                        str = null;
                    }
                    if (string3 == null || string3.length() == 0) {
                        str2 = null;
                    } else {
                        String packageName2 = context2.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
                        str2 = StringsKt__StringsKt.replace$default(string3, "${applicationId}", packageName2);
                        if (str2.length() <= 0) {
                            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
                        }
                    }
                    if (string4 != null) {
                        String packageName3 = context2.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName3, "getPackageName(...)");
                        str3 = StringsKt__StringsKt.replace$default(string4, "${applicationId}", packageName3);
                    }
                    NavDeepLink navDeepLink = new NavDeepLink(str, str2, str3);
                    navDestinationImpl2.getClass();
                    ArrayList missingRequiredArguments = Navigation.missingRequiredArguments((LinkedHashMap) navDestinationImpl2.arguments, new NavDestinationImpl$$ExternalSyntheticLambda0(navDeepLink, 0));
                    if (missingRequiredArguments.isEmpty()) {
                        ((ArrayList) navDestinationImpl2.deepLinks).add(navDeepLink);
                        obtainAttributes2.recycle();
                    } else {
                        StringBuilder m = ViewModelProvider.Factory.CC.m594m("Deep link ", str, " can't be used to open destination ");
                        m.append((NavDestination) navDestinationImpl2.destination);
                        m.append(".\nFollowing required arguments are missing: ");
                        m.append(missingRequiredArguments);
                        throw new IllegalArgumentException(m.toString().toString());
                    }
                } else {
                    if ("action".equals(name2)) {
                        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.NavAction, 0, 0);
                        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                        context = context2;
                        NavAction navAction = new NavAction(obtainStyledAttributes.getResourceId(1, 0));
                        navAction.navOptions = new NavOptions(obtainStyledAttributes.getBoolean(4, false), obtainStyledAttributes.getBoolean(10, false), obtainStyledAttributes.getResourceId(7, -1), obtainStyledAttributes.getBoolean(8, false), obtainStyledAttributes.getBoolean(9, false), obtainStyledAttributes.getResourceId(2, -1), obtainStyledAttributes.getResourceId(3, -1), obtainStyledAttributes.getResourceId(5, -1), obtainStyledAttributes.getResourceId(6, -1));
                        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                        navDestinationImpl = navDestinationImpl2;
                        int i5 = 1;
                        int depth3 = xmlResourceParser.getDepth() + 1;
                        i2 = depth2;
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == i5) {
                                typedArray = obtainStyledAttributes;
                                break;
                            }
                            int depth4 = xmlResourceParser.getDepth();
                            typedArray = obtainStyledAttributes;
                            if (depth4 < depth3 && next2 == 3) {
                                break;
                            }
                            if (next2 == 2 && depth4 <= depth3) {
                                if ("argument".equals(xmlResourceParser.getName())) {
                                    TypedArray obtainAttributes3 = resources.obtainAttributes(attributeSet, iArr);
                                    Intrinsics.checkNotNullExpressionValue(obtainAttributes3, "obtainAttributes(...)");
                                    String string5 = obtainAttributes3.getString(0);
                                    if (string5 != null) {
                                        NavArgument inflateArgument2 = inflateArgument(obtainAttributes3, resources, i3);
                                        boolean z = inflateArgument2.isDefaultValuePresent;
                                        if (z && z && (obj = inflateArgument2.defaultValue) != null) {
                                            inflateArgument2.type.put(bundleOf, string5, obj);
                                        }
                                        obtainAttributes3.recycle();
                                    } else {
                                        throw new XmlPullParserException("Arguments must have a name");
                                    }
                                }
                                i3 = i;
                            }
                            obtainStyledAttributes = typedArray;
                            i5 = 1;
                        }
                        if (!bundleOf.isEmpty()) {
                            navAction.defaultArguments = bundleOf;
                        }
                        if (createDestination instanceof ActivityNavigator.Destination) {
                            throw new UnsupportedOperationException("Cannot add action " + resourceId + " to " + createDestination + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
                        } else if (resourceId != 0) {
                            createDestination.actions.put(resourceId, navAction);
                            typedArray.recycle();
                        } else {
                            throw new IllegalArgumentException("Cannot have an action with actionId 0");
                        }
                    } else {
                        context = context2;
                        navDestinationImpl = navDestinationImpl2;
                        i2 = depth2;
                        if ("include".equals(name2) && (createDestination instanceof NavGraph)) {
                            TypedArray obtainAttributes4 = resources.obtainAttributes(attributeSet, R$styleable.NavInclude);
                            Intrinsics.checkNotNullExpressionValue(obtainAttributes4, "obtainAttributes(...)");
                            ((NavGraph) createDestination).addDestination(inflate(obtainAttributes4.getResourceId(0, 0)));
                            obtainAttributes4.recycle();
                        } else if (createDestination instanceof NavGraph) {
                            ((NavGraph) createDestination).addDestination(inflate(resources, xmlResourceParser, attributeSet, i));
                        }
                    }
                    i3 = i;
                    depth2 = i2;
                    context2 = context;
                    navDestinationImpl2 = navDestinationImpl;
                }
                i4 = 1;
            }
        }
    }
}
