package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.collection.SparseArrayCompat;
import androidx.core.p002os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.common.R$styleable;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavDestinationImpl;
import androidx.navigation.internal.NavDestinationImpl$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatcherMatchResult;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.Regex;
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
                if (navArgument2.isNullable || !bundleOf.containsKey(name2) || !Navigation.m652isNullimpl(bundleOf, name2)) {
                    try {
                        navType.get(bundleOf, name2);
                    } catch (IllegalStateException unused) {
                    }
                }
                StringBuilder m = ViewModelProvider.Factory.CC.m594m("Wrong argument type for '", name2, "' in argument savedState. ");
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
                    if (navDestinationImpl.f12id == navDestinationImpl2.f12id || !Intrinsics.areEqual((String) navDestinationImpl.route, (String) navDestinationImpl2.route) || !areEqual || !z || !z2) {
                    }
                }
                z2 = false;
                if (navDestinationImpl.f12id == navDestinationImpl2.f12id) {
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
        int i7 = navDestinationImpl.f12id * 31;
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
                i8 = Navigation.m591x4f1a1420(bundle) + (i8 * 31);
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
    */
    public DeepLinkMatch matchDeepLink(MatcherMatchResult matcherMatchResult) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        ArrayList arrayList;
        Bundle bundle;
        SynchronizedLazyImpl synchronizedLazyImpl;
        int i3;
        boolean z3;
        int i4;
        DeepLinkMatch deepLinkMatch;
        Regex regex;
        MatcherMatchResult matchEntire;
        List<Object> list;
        List list2;
        List<Object> list3;
        Bundle bundle2;
        Bundle bundle3;
        MatcherMatchResult matchEntire2;
        MatcherMatchResult matcherMatchResult2;
        String str;
        boolean z4;
        boolean z5;
        NavDestinationImpl navDestinationImpl = this.impl;
        LinkedHashMap arguments = (LinkedHashMap) navDestinationImpl.arguments;
        String str2 = (String) matcherMatchResult.groups;
        Object obj = (String) matcherMatchResult.input;
        Uri deepLink = (Uri) matcherMatchResult.matcher;
        ArrayList arrayList2 = (ArrayList) navDestinationImpl.deepLinks;
        if (arrayList2.isEmpty()) {
            return null;
        }
        int size = arrayList2.size();
        DeepLinkMatch deepLinkMatch2 = null;
        for (int i5 = 0; i5 < size; i5 = i) {
            Object obj2 = arrayList2.get(i5);
            int i6 = i5 + 1;
            NavDeepLink navDeepLink = (NavDeepLink) obj2;
            navDeepLink.getClass();
            SynchronizedLazyImpl synchronizedLazyImpl2 = navDeepLink.mimeTypePattern$delegate;
            SynchronizedLazyImpl synchronizedLazyImpl3 = navDeepLink.pathPattern$delegate;
            String str3 = navDeepLink.mimeType;
            String str4 = navDeepLink.action;
            if (((Regex) synchronizedLazyImpl3.getValue()) == null) {
                z = true;
            } else if (deepLink == null) {
                z = false;
            } else {
                Regex regex2 = (Regex) synchronizedLazyImpl3.getValue();
                Intrinsics.checkNotNull(regex2);
                z = regex2.matches(deepLink.toString());
                if (z) {
                    if (str4 == null) {
                        z4 = true;
                    } else if (obj == null) {
                        z4 = false;
                    } else {
                        z4 = str4.equals(obj);
                    }
                    if (z4) {
                        if (str3 == null) {
                            z5 = true;
                        } else if (str2 == null) {
                            z5 = false;
                        } else {
                            Regex regex3 = (Regex) synchronizedLazyImpl2.getValue();
                            Intrinsics.checkNotNull(regex3);
                            z5 = regex3.matches(str2);
                        }
                        if (z5) {
                            z2 = true;
                            if (z2) {
                                if (deepLink != null) {
                                    navDeepLink.getClass();
                                    Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                                    Intrinsics.checkNotNullParameter(arguments, "arguments");
                                    Regex regex4 = (Regex) navDeepLink.pathPattern$delegate.getValue();
                                    if (regex4 != null) {
                                        bundle3 = null;
                                        MatcherMatchResult matchEntire3 = regex4.matchEntire(deepLink.toString());
                                        if (matchEntire3 == null) {
                                            arrayList = arrayList2;
                                        } else {
                                            arrayList = arrayList2;
                                            Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                                            if (navDeepLink.getMatchingPathArguments(matchEntire3, bundleOf, arguments) && (!((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue() || navDeepLink.getMatchingQueryArguments(deepLink, bundleOf, arguments))) {
                                                String fragment = deepLink.getFragment();
                                                Regex regex5 = (Regex) navDeepLink.fragPattern$delegate.getValue();
                                                if (regex5 == null || (matchEntire2 = regex5.matchEntire(String.valueOf(fragment))) == null) {
                                                    i2 = size;
                                                    i = i6;
                                                } else {
                                                    List list4 = (List) navDeepLink.fragArgs$delegate.getValue();
                                                    i2 = size;
                                                    i = i6;
                                                    ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                                                    Iterator it = list4.iterator();
                                                    int i7 = 0;
                                                    while (it.hasNext()) {
                                                        Object next = it.next();
                                                        Iterator it2 = it;
                                                        int i8 = i7 + 1;
                                                        if (i7 >= 0) {
                                                            String str5 = (String) next;
                                                            synchronizedLazyImpl = synchronizedLazyImpl2;
                                                            MatchGroup matchGroup = ((MatcherMatchResult$groups$1) matchEntire2.groups).get(i8);
                                                            if (matchGroup != null) {
                                                                str = Uri.decode(matchGroup.value);
                                                                matcherMatchResult2 = matchEntire2;
                                                                Intrinsics.checkNotNullExpressionValue(str, "decode(...)");
                                                            } else {
                                                                matcherMatchResult2 = matchEntire2;
                                                                str = null;
                                                            }
                                                            if (str == null) {
                                                                str = "";
                                                            }
                                                            try {
                                                                NavDeepLink.parseArgument(bundleOf, str5, str, (NavArgument) arguments.get(str5));
                                                                arrayList3.add(Unit.INSTANCE);
                                                                synchronizedLazyImpl2 = synchronizedLazyImpl;
                                                                matchEntire2 = matcherMatchResult2;
                                                                i7 = i8;
                                                                it = it2;
                                                            } catch (IllegalArgumentException unused) {
                                                            }
                                                        } else {
                                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                            throw null;
                                                        }
                                                    }
                                                }
                                                synchronizedLazyImpl = synchronizedLazyImpl2;
                                                if (Navigation.missingRequiredArguments(arguments, new NavDeepLink$$ExternalSyntheticLambda8(0, bundleOf)).isEmpty()) {
                                                    bundle2 = bundleOf;
                                                    bundle = bundle2;
                                                }
                                            }
                                        }
                                        i2 = size;
                                        i = i6;
                                        synchronizedLazyImpl = synchronizedLazyImpl2;
                                    } else {
                                        arrayList = arrayList2;
                                        i2 = size;
                                        i = i6;
                                        synchronizedLazyImpl = synchronizedLazyImpl2;
                                        bundle3 = null;
                                    }
                                    bundle2 = bundle3;
                                    bundle = bundle2;
                                } else {
                                    arrayList = arrayList2;
                                    i2 = size;
                                    i = i6;
                                    synchronizedLazyImpl = synchronizedLazyImpl2;
                                    bundle = null;
                                }
                                String uriString = navDeepLink.uriPattern;
                                if (deepLink == null || uriString == null) {
                                    i3 = 0;
                                } else {
                                    List<String> pathSegments = deepLink.getPathSegments();
                                    Intrinsics.checkNotNullParameter(uriString, "uriString");
                                    Uri parse = Uri.parse(uriString);
                                    Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                                    List<String> other = parse.getPathSegments();
                                    Intrinsics.checkNotNullParameter(pathSegments, "<this>");
                                    Intrinsics.checkNotNullParameter(other, "other");
                                    LinkedHashSet linkedHashSet = new LinkedHashSet(pathSegments);
                                    linkedHashSet.retainAll(other);
                                    i3 = linkedHashSet.size();
                                }
                                if (obj == null || !obj.equals(str4)) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (!(str2 == null || str3 == null)) {
                                    Regex regex6 = (Regex) synchronizedLazyImpl.getValue();
                                    Intrinsics.checkNotNull(regex6);
                                    if (regex6.matches(str2)) {
                                        Pattern compile = Pattern.compile("/");
                                        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
                                        Matcher matcher = compile.matcher(str3);
                                        if (!matcher.find()) {
                                            list = LazyKt__LazyJVMKt.listOf(str3.toString());
                                        } else {
                                            ArrayList arrayList4 = new ArrayList(10);
                                            int i9 = 0;
                                            do {
                                                arrayList4.add(str3.subSequence(i9, matcher.start()).toString());
                                                i9 = matcher.end();
                                            } while (matcher.find());
                                            arrayList4.add(str3.subSequence(i9, str3.length()).toString());
                                            list = arrayList4;
                                        }
                                        boolean isEmpty = list.isEmpty();
                                        List list5 = EmptyList.INSTANCE;
                                        if (!isEmpty) {
                                            ListIterator listIterator = list.listIterator(list.size());
                                            while (true) {
                                                if (!listIterator.hasPrevious()) {
                                                    break;
                                                } else if (((String) listIterator.previous()).length() != 0) {
                                                    int nextIndex = listIterator.nextIndex() + 1;
                                                    if (nextIndex < 0) {
                                                        throw new IllegalArgumentException(("Requested element count " + nextIndex + " is less than zero.").toString());
                                                    } else if (nextIndex != 0) {
                                                        if (nextIndex >= list.size()) {
                                                            list2 = CollectionsKt.toList(list);
                                                        } else if (nextIndex == 1) {
                                                            list2 = LazyKt__LazyJVMKt.listOf(CollectionsKt.first(list));
                                                        } else {
                                                            ArrayList arrayList5 = new ArrayList(nextIndex);
                                                            int i10 = 0;
                                                            for (Object obj3 : list) {
                                                                arrayList5.add(obj3);
                                                                int i11 = i10 + 1;
                                                                if (i11 == nextIndex) {
                                                                    break;
                                                                }
                                                                i10 = i11;
                                                            }
                                                            list2 = CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList5);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        list2 = list5;
                                        String str6 = (String) list2.get(0);
                                        String str7 = (String) list2.get(1);
                                        Pattern compile2 = Pattern.compile("/");
                                        Intrinsics.checkNotNullExpressionValue(compile2, "compile(...)");
                                        Matcher matcher2 = compile2.matcher(str2);
                                        if (!matcher2.find()) {
                                            list3 = LazyKt__LazyJVMKt.listOf(str2.toString());
                                        } else {
                                            ArrayList arrayList6 = new ArrayList(10);
                                            int i12 = 0;
                                            do {
                                                arrayList6.add(str2.subSequence(i12, matcher2.start()).toString());
                                                i12 = matcher2.end();
                                            } while (matcher2.find());
                                            arrayList6.add(str2.subSequence(i12, str2.length()).toString());
                                            list3 = arrayList6;
                                        }
                                        if (!list3.isEmpty()) {
                                            ListIterator listIterator2 = list3.listIterator(list3.size());
                                            while (true) {
                                                if (!listIterator2.hasPrevious()) {
                                                    break;
                                                } else if (((String) listIterator2.previous()).length() != 0) {
                                                    int nextIndex2 = listIterator2.nextIndex() + 1;
                                                    if (nextIndex2 < 0) {
                                                        throw new IllegalArgumentException(("Requested element count " + nextIndex2 + " is less than zero.").toString());
                                                    } else if (nextIndex2 != 0) {
                                                        if (nextIndex2 >= list3.size()) {
                                                            list5 = CollectionsKt.toList(list3);
                                                        } else if (nextIndex2 == 1) {
                                                            list5 = LazyKt__LazyJVMKt.listOf(CollectionsKt.first(list3));
                                                        } else {
                                                            ArrayList arrayList7 = new ArrayList(nextIndex2);
                                                            int i13 = 0;
                                                            for (Object obj4 : list3) {
                                                                arrayList7.add(obj4);
                                                                i13++;
                                                                if (i13 == nextIndex2) {
                                                                    break;
                                                                }
                                                            }
                                                            list5 = CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList7);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        List list6 = list5;
                                        String str8 = (String) list6.get(1);
                                        if (Intrinsics.areEqual(str6, (String) list6.get(0))) {
                                            i4 = 2;
                                        } else {
                                            i4 = 0;
                                        }
                                        if (Intrinsics.areEqual(str7, str8)) {
                                            i4++;
                                        }
                                        if (bundle == null) {
                                            if (z3 || i4 > -1) {
                                                Intrinsics.checkNotNullParameter(arguments, "arguments");
                                                Bundle bundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                                                if (!(deepLink == null || (regex = (Regex) synchronizedLazyImpl3.getValue()) == null || (matchEntire = regex.matchEntire(deepLink.toString())) == null)) {
                                                    navDeepLink.getMatchingPathArguments(matchEntire, bundleOf2, arguments);
                                                    if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                                                        navDeepLink.getMatchingQueryArguments(deepLink, bundleOf2, arguments);
                                                    }
                                                }
                                            }
                                        }
                                        deepLinkMatch = new DeepLinkMatch((NavDestination) navDestinationImpl.destination, bundle, navDeepLink.isExactDeepLink, i3, z3, i4);
                                        if (deepLinkMatch2 != null || deepLinkMatch.compareTo(deepLinkMatch2) > 0) {
                                            deepLinkMatch2 = deepLinkMatch;
                                            arrayList2 = arrayList;
                                            size = i2;
                                        }
                                        arrayList2 = arrayList;
                                        size = i2;
                                    }
                                }
                                i4 = -1;
                                if (bundle == null) {
                                }
                                deepLinkMatch = new DeepLinkMatch((NavDestination) navDestinationImpl.destination, bundle, navDeepLink.isExactDeepLink, i3, z3, i4);
                                if (deepLinkMatch2 != null) {
                                }
                                deepLinkMatch2 = deepLinkMatch;
                                arrayList2 = arrayList;
                                size = i2;
                            } else {
                                arrayList = arrayList2;
                                i2 = size;
                                i = i6;
                            }
                            arrayList2 = arrayList;
                            size = i2;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                }
                arrayList2 = arrayList;
                size = i2;
            }
            if (z) {
            }
            z2 = false;
            if (z2) {
            }
            arrayList2 = arrayList;
            size = i2;
        }
        return deepLinkMatch2;
    }

    public void onInflate(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.Navigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
        String string = obtainAttributes.getString(2);
        NavDestinationImpl navDestinationImpl = this.impl;
        if (string == null) {
            navDestinationImpl.f12id = 0;
            navDestinationImpl.idName = null;
        } else {
            navDestinationImpl.getClass();
            if (!StringsKt__StringsKt.isBlank(string)) {
                String uriPattern = "android-app://androidx.navigation/".concat(string);
                Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
                ArrayList missingRequiredArguments = Navigation.missingRequiredArguments((LinkedHashMap) navDestinationImpl.arguments, new NavDestinationImpl$$ExternalSyntheticLambda0(new NavDeepLink(uriPattern, null, null), 1));
                if (missingRequiredArguments.isEmpty()) {
                    new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda1(3, uriPattern));
                    navDestinationImpl.f12id = uriPattern.hashCode();
                    navDestinationImpl.idName = null;
                } else {
                    StringBuilder m = ViewModelProvider.Factory.CC.m594m("Cannot set route \"", string, "\" for destination ");
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
            navDestinationImpl.f12id = resourceId;
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
            sb.append(Integer.toHexString(navDestinationImpl.f12id));
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
