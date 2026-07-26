package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.collection.SparseArrayCompat;
import androidx.core.os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.common.R$styleable;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes.dex */
public abstract class NavDestination {
    public static final /* synthetic */ int $r8$clinit = 0;
    public CharSequence label;
    public final String navigatorName;
    public NavGraph parent;
    public final NavDestinationImpl impl = new NavDestinationImpl(this);
    public final SparseArrayCompat actions = new SparseArrayCompat(0);

    /* loaded from: classes.dex */
    public final class DeepLinkMatch implements Comparable {
        public final NavDestination destination;
        public final boolean hasMatchingAction;
        public final boolean isExactDeepLink;
        public final Bundle matchingArgs;
        public final int matchingPathSegments;
        public final int mimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z, int i, boolean z2, int i2) {
            this.destination = navDestination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
            this.mimeTypeMatchLevel = i2;
        }

        public final int compareTo(DeepLinkMatch other) {
            Intrinsics.checkNotNullParameter(other, "other");
            boolean z = other.hasMatchingAction;
            boolean z2 = other.isExactDeepLink;
            Bundle bundle = other.matchingArgs;
            boolean z3 = this.isExactDeepLink;
            if (z3 && !z2) {
                return 1;
            }
            if (!z3 && z2) {
                return -1;
            }
            int i = this.matchingPathSegments - other.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle source = this.matchingArgs;
            if (source != null && bundle == null) {
                return 1;
            }
            if (source == null && bundle != null) {
                return -1;
            }
            if (source != null) {
                Intrinsics.checkNotNullParameter(source, "source");
                int size = source.size();
                Intrinsics.checkNotNull(bundle);
                int size2 = size - bundle.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z4 = this.hasMatchingAction;
            if (z4 && !z) {
                return 1;
            }
            if (z4 || !z) {
                return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
            }
            return -1;
        }
    }

    static {
        new LinkedHashMap();
    }

    public NavDestination(Navigator navigator) {
        LinkedHashMap linkedHashMap = NavigatorProvider.annotationNames;
        this.navigatorName = Navigation.getNameForNavigator$navigation_common_release(navigator.getClass());
    }

    public final Bundle addInDefaultArgs(Bundle bundle) {
        Object obj;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.impl.arguments;
        if (bundle == null && linkedHashMap.isEmpty()) {
            return null;
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String name = (String) entry.getKey();
            NavArgument navArgument = (NavArgument) entry.getValue();
            navArgument.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            if (navArgument.isDefaultValuePresent && (obj = navArgument.defaultValue) != null) {
                navArgument.type.put(bundleOf, name, obj);
            }
        }
        if (bundle != null) {
            bundleOf.putAll(bundle);
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                String name2 = (String) entry2.getKey();
                NavArgument navArgument2 = (NavArgument) entry2.getValue();
                navArgument2.getClass();
                NavType navType = navArgument2.type;
                Intrinsics.checkNotNullParameter(name2, "name");
                if (navArgument2.isNullable || !bundleOf.containsKey(name2) || !Navigation.m22isNullimpl(bundleOf, name2)) {
                    try {
                        navType.get(bundleOf, name2);
                    } catch (IllegalStateException unused) {
                    }
                }
                StringBuilder m = ViewModelProvider.Factory.CC.m15m("Wrong argument type for '", name2, "' in argument savedState. ");
                m.append(navType.getName());
                m.append(" expected.");
                throw new IllegalArgumentException(m.toString().toString());
            }
        }
        return bundleOf;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this != obj) {
            if (obj != null && (obj instanceof NavDestination)) {
                NavDestinationImpl navDestinationImpl = this.impl;
                NavDestination navDestination = (NavDestination) obj;
                SparseArrayCompat sparseArrayCompat = navDestination.actions;
                NavDestinationImpl navDestinationImpl2 = navDestination.impl;
                boolean areEqual = Intrinsics.areEqual((ArrayList) navDestinationImpl.deepLinks, (ArrayList) navDestinationImpl2.deepLinks);
                final SparseArrayCompat sparseArrayCompat2 = this.actions;
                if (sparseArrayCompat2.size() != sparseArrayCompat.size()) {
                    z = false;
                    break;
                }
                for (Number number : SequencesKt.asSequence(new IntIterator() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
                    public int index;

                    @Override // java.util.Iterator
                    public final boolean hasNext() {
                        if (this.index < SparseArrayCompat.this.size()) {
                            return true;
                        }
                        return false;
                    }

                    @Override // kotlin.collections.IntIterator
                    public final int nextInt() {
                        int i = this.index;
                        this.index = i + 1;
                        return SparseArrayCompat.this.keyAt(i);
                    }
                })) {
                    int intValue = number.intValue();
                    if (!Intrinsics.areEqual(sparseArrayCompat2.get(intValue), sparseArrayCompat.get(intValue))) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (getArguments().size() == navDestination.getArguments().size()) {
                    Set<Map.Entry> entrySet = getArguments().entrySet();
                    Intrinsics.checkNotNullParameter(entrySet, "<this>");
                    for (Map.Entry entry : entrySet) {
                        if (navDestination.getArguments().containsKey(entry.getKey())) {
                            if (!Intrinsics.areEqual(navDestination.getArguments().get(entry.getKey()), entry.getValue())) {
                            }
                        }
                    }
                    z2 = true;
                    if (navDestinationImpl.id == navDestinationImpl2.id || !Intrinsics.areEqual((String) navDestinationImpl.route, (String) navDestinationImpl2.route) || !areEqual || !z || !z2) {
                    }
                }
                z2 = false;
                if (navDestinationImpl.id == navDestinationImpl2.id) {
                }
            }
            return false;
        }
        return true;
    }

    public final NavAction getAction(int i) {
        NavAction navAction;
        SparseArrayCompat sparseArrayCompat = this.actions;
        if (sparseArrayCompat.size() == 0) {
            navAction = null;
        } else {
            navAction = (NavAction) sparseArrayCompat.get(i);
        }
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.parent;
        if (navGraph != null) {
            return navGraph.getAction(i);
        }
        return null;
    }

    public final Map getArguments() {
        return MapsKt__MapsKt.toMap((LinkedHashMap) this.impl.arguments);
    }

    public int hashCode() {
        int i;
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        NavDestinationImpl navDestinationImpl = this.impl;
        int i7 = navDestinationImpl.id * 31;
        String str = (String) navDestinationImpl.route;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i8 = i7 + i;
        ArrayList arrayList = (ArrayList) navDestinationImpl.deepLinks;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            NavDeepLink navDeepLink = (NavDeepLink) obj;
            int i10 = i8 * 31;
            String str2 = navDeepLink.uriPattern;
            if (str2 != null) {
                i4 = str2.hashCode();
            } else {
                i4 = 0;
            }
            int i11 = (i10 + i4) * 31;
            String str3 = navDeepLink.action;
            if (str3 != null) {
                i5 = str3.hashCode();
            } else {
                i5 = 0;
            }
            int i12 = (i11 + i5) * 31;
            String str4 = navDeepLink.mimeType;
            if (str4 != null) {
                i6 = str4.hashCode();
            } else {
                i6 = 0;
            }
            i8 = i12 + i6;
        }
        SparseArrayCompat sparseArrayCompat = this.actions;
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int i13 = 0;
        while (true) {
            if (i13 < sparseArrayCompat.size()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                break;
            }
            int i14 = i13 + 1;
            NavAction navAction = (NavAction) sparseArrayCompat.valueAt(i13);
            int i15 = ((i8 * 31) + navAction.destinationId) * 31;
            NavOptions navOptions = navAction.navOptions;
            if (navOptions != null) {
                i3 = navOptions.hashCode();
            } else {
                i3 = 0;
            }
            i8 = i15 + i3;
            Bundle bundle = navAction.defaultArguments;
            if (bundle != null) {
                i8 = Navigation.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(bundle) + (i8 * 31);
            }
            i13 = i14;
        }
        for (String str5 : getArguments().keySet()) {
            int hashCode = (str5.hashCode() + (i8 * 31)) * 31;
            Object obj2 = getArguments().get(str5);
            if (obj2 != null) {
                i2 = obj2.hashCode();
            } else {
                i2 = 0;
            }
            i8 = i2 + hashCode;
        }
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:175:0x0427, code lost:
        if (androidx.navigation.Navigation.missingRequiredArguments(r3, new androidx.navigation.NavDeepLink$$ExternalSyntheticLambda8(1, r6)).isEmpty() != false) goto L177;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object, kotlin.Lazy] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.navigation.NavDestination.DeepLinkMatch matchDeepLink(kotlin.text.MatcherMatchResult r31) {
        /*
            Method dump skipped, instructions count: 1117
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.matchDeepLink(kotlin.text.MatcherMatchResult):androidx.navigation.NavDestination$DeepLinkMatch");
    }

    public void onInflate(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.Navigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
        String string = obtainAttributes.getString(2);
        NavDestinationImpl navDestinationImpl = this.impl;
        if (string == null) {
            navDestinationImpl.id = 0;
            navDestinationImpl.idName = null;
        } else {
            navDestinationImpl.getClass();
            if (!StringsKt__StringsKt.isBlank(string)) {
                String uriPattern = "android-app://androidx.navigation/".concat(string);
                Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
                ArrayList missingRequiredArguments = Navigation.missingRequiredArguments((LinkedHashMap) navDestinationImpl.arguments, new NavDestinationImpl$$ExternalSyntheticLambda0(new NavDeepLink(uriPattern, null, null), 1));
                if (missingRequiredArguments.isEmpty()) {
                    new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda1(3, uriPattern));
                    navDestinationImpl.id = uriPattern.hashCode();
                    navDestinationImpl.idName = null;
                } else {
                    StringBuilder m = ViewModelProvider.Factory.CC.m15m("Cannot set route \"", string, "\" for destination ");
                    m.append((NavDestination) navDestinationImpl.destination);
                    m.append(". Following required arguments are missing: ");
                    m.append(missingRequiredArguments);
                    throw new IllegalArgumentException(m.toString().toString());
                }
            } else {
                throw new IllegalArgumentException("Cannot have an empty route");
            }
        }
        navDestinationImpl.route = string;
        if (obtainAttributes.hasValue(1)) {
            int resourceId = obtainAttributes.getResourceId(1, 0);
            navDestinationImpl.id = resourceId;
            navDestinationImpl.idName = null;
            navDestinationImpl.idName = Navigation.getDisplayName(new NavContext(context, false), resourceId);
        }
        this.label = obtainAttributes.getText(0);
        obtainAttributes.recycle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        NavDestinationImpl navDestinationImpl = this.impl;
        String str = (String) navDestinationImpl.idName;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(navDestinationImpl.id));
        } else {
            sb.append(str);
        }
        sb.append(")");
        String str2 = (String) navDestinationImpl.route;
        if (str2 != null && !StringsKt__StringsKt.isBlank(str2)) {
            sb.append(" route=");
            sb.append((String) navDestinationImpl.route);
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
