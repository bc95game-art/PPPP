package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDeepLink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatcherMatchResult;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes.dex */
public final class NavDeepLink {
    public final String action;
    public final Object fragArgs$delegate;
    public final Object fragArgsAndRegex$delegate;
    public final Object fragRegex$delegate;
    public final boolean isExactDeepLink;
    public boolean isSingleQueryParamValueOnly;
    public final String mimeType;
    public final String mimeTypeRegex;
    public final ArrayList pathArgs;
    public final String pathRegex;
    public final Object queryArgsMap$delegate;
    public final String uriPattern;
    public static final Regex SCHEME_PATTERN = new Regex("^[a-zA-Z]+[+\\w\\-.]*:");
    public static final Regex FILL_IN_PATTERN = new Regex("\\{(.+?)\\}");
    public static final Regex SCHEME_REGEX = new Regex("http[s]?://");
    public static final Regex WILDCARD_REGEX = new Regex(".*");
    public static final Regex PATH_REGEX = new Regex("([^/]*?|)");
    public static final Regex QUERY_PATTERN = new Regex("^[^?#]+\\?([^#]*).*");
    public final SynchronizedLazyImpl pathPattern$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
        public final /* synthetic */ NavDeepLink f$0;

        {
            this.f$0 = this;
        }

        /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object, kotlin.Lazy] */
        /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object, kotlin.Lazy] */
        /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object, kotlin.Lazy] */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean z;
            List list;
            switch (r2) {
                case 0:
                    String str = this.f$0.pathRegex;
                    if (str != null) {
                        return new Regex(str, 0);
                    }
                    return null;
                case 1:
                    String str2 = this.f$0.uriPattern;
                    if (str2 == null || !NavDeepLink.QUERY_PATTERN.matches(str2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                case 2:
                    NavDeepLink navDeepLink = this.f$0;
                    String str3 = navDeepLink.uriPattern;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                        Intrinsics.checkNotNull(str3);
                        Uri parse = Uri.parse(str3);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                        for (String str4 : parse.getQueryParameterNames()) {
                            StringBuilder sb = new StringBuilder();
                            List<String> queryParameters = parse.getQueryParameters(str4);
                            int i = 1;
                            if (queryParameters.size() <= 1) {
                                String str5 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                MatcherMatchResult find$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i2 = 0;
                                while (find$default != null) {
                                    MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(i);
                                    Intrinsics.checkNotNull(matchGroup);
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (find$default.getRange().first > i2) {
                                        String substring = str5.substring(i2, find$default.getRange().first);
                                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                        String quote = Pattern.quote(substring);
                                        Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                                        sb.append(quote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i2 = find$default.getRange().last + 1;
                                    find$default = find$default.next();
                                    i = 1;
                                }
                                if (i2 < str5.length()) {
                                    String substring2 = str5.substring(i2);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                    String quote2 = Pattern.quote(substring2);
                                    Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
                                    sb.append(quote2);
                                }
                                sb.append("$");
                                String sb2 = sb.toString();
                                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb2);
                                linkedHashMap.put(str4, paramQuery);
                            } else {
                                throw new IllegalArgumentException(("Query parameter " + str4 + " must only be present once in " + str3 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                            }
                        }
                    }
                    return linkedHashMap;
                case 3:
                    String str6 = this.f$0.uriPattern;
                    if (str6 != null) {
                        Uri parse2 = Uri.parse(str6);
                        Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                        if (parse2.getFragment() != null) {
                            ArrayList arrayList = new ArrayList();
                            Uri parse3 = Uri.parse(str6);
                            Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                            String fragment = parse3.getFragment();
                            StringBuilder sb3 = new StringBuilder();
                            Intrinsics.checkNotNull(fragment);
                            NavDeepLink.buildRegex(fragment, arrayList, sb3);
                            return new Pair(arrayList, sb3.toString());
                        }
                    }
                    return null;
                case 4:
                    Pair pair = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                    if (pair == null || (list = (List) pair.first) == null) {
                        return new ArrayList();
                    }
                    return list;
                case 5:
                    Pair pair2 = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                    if (pair2 != null) {
                        return (String) pair2.second;
                    }
                    return null;
                case 6:
                    String str7 = (String) this.f$0.fragRegex$delegate.getValue();
                    if (str7 != null) {
                        return new Regex(str7, 0);
                    }
                    return null;
                default:
                    String str8 = this.f$0.mimeTypeRegex;
                    if (str8 != null) {
                        return new Regex(str8);
                    }
                    return null;
            }
        }
    });
    public final SynchronizedLazyImpl isParameterizedQuery$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
        public final /* synthetic */ NavDeepLink f$0;

        {
            this.f$0 = this;
        }

        /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object, kotlin.Lazy] */
        /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object, kotlin.Lazy] */
        /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object, kotlin.Lazy] */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean z;
            List list;
            switch (r2) {
                case 0:
                    String str = this.f$0.pathRegex;
                    if (str != null) {
                        return new Regex(str, 0);
                    }
                    return null;
                case 1:
                    String str2 = this.f$0.uriPattern;
                    if (str2 == null || !NavDeepLink.QUERY_PATTERN.matches(str2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                case 2:
                    NavDeepLink navDeepLink = this.f$0;
                    String str3 = navDeepLink.uriPattern;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                        Intrinsics.checkNotNull(str3);
                        Uri parse = Uri.parse(str3);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                        for (String str4 : parse.getQueryParameterNames()) {
                            StringBuilder sb = new StringBuilder();
                            List<String> queryParameters = parse.getQueryParameters(str4);
                            int i = 1;
                            if (queryParameters.size() <= 1) {
                                String str5 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                MatcherMatchResult find$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i2 = 0;
                                while (find$default != null) {
                                    MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(i);
                                    Intrinsics.checkNotNull(matchGroup);
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (find$default.getRange().first > i2) {
                                        String substring = str5.substring(i2, find$default.getRange().first);
                                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                        String quote = Pattern.quote(substring);
                                        Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                                        sb.append(quote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i2 = find$default.getRange().last + 1;
                                    find$default = find$default.next();
                                    i = 1;
                                }
                                if (i2 < str5.length()) {
                                    String substring2 = str5.substring(i2);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                    String quote2 = Pattern.quote(substring2);
                                    Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
                                    sb.append(quote2);
                                }
                                sb.append("$");
                                String sb2 = sb.toString();
                                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb2);
                                linkedHashMap.put(str4, paramQuery);
                            } else {
                                throw new IllegalArgumentException(("Query parameter " + str4 + " must only be present once in " + str3 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                            }
                        }
                    }
                    return linkedHashMap;
                case 3:
                    String str6 = this.f$0.uriPattern;
                    if (str6 != null) {
                        Uri parse2 = Uri.parse(str6);
                        Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                        if (parse2.getFragment() != null) {
                            ArrayList arrayList = new ArrayList();
                            Uri parse3 = Uri.parse(str6);
                            Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                            String fragment = parse3.getFragment();
                            StringBuilder sb3 = new StringBuilder();
                            Intrinsics.checkNotNull(fragment);
                            NavDeepLink.buildRegex(fragment, arrayList, sb3);
                            return new Pair(arrayList, sb3.toString());
                        }
                    }
                    return null;
                case 4:
                    Pair pair = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                    if (pair == null || (list = (List) pair.first) == null) {
                        return new ArrayList();
                    }
                    return list;
                case 5:
                    Pair pair2 = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                    if (pair2 != null) {
                        return (String) pair2.second;
                    }
                    return null;
                case 6:
                    String str7 = (String) this.f$0.fragRegex$delegate.getValue();
                    if (str7 != null) {
                        return new Regex(str7, 0);
                    }
                    return null;
                default:
                    String str8 = this.f$0.mimeTypeRegex;
                    if (str8 != null) {
                        return new Regex(str8);
                    }
                    return null;
            }
        }
    });
    public final SynchronizedLazyImpl fragPattern$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
        public final /* synthetic */ NavDeepLink f$0;

        {
            this.f$0 = this;
        }

        /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object, kotlin.Lazy] */
        /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object, kotlin.Lazy] */
        /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object, kotlin.Lazy] */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean z;
            List list;
            switch (r2) {
                case 0:
                    String str = this.f$0.pathRegex;
                    if (str != null) {
                        return new Regex(str, 0);
                    }
                    return null;
                case 1:
                    String str2 = this.f$0.uriPattern;
                    if (str2 == null || !NavDeepLink.QUERY_PATTERN.matches(str2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                case 2:
                    NavDeepLink navDeepLink = this.f$0;
                    String str3 = navDeepLink.uriPattern;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                        Intrinsics.checkNotNull(str3);
                        Uri parse = Uri.parse(str3);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                        for (String str4 : parse.getQueryParameterNames()) {
                            StringBuilder sb = new StringBuilder();
                            List<String> queryParameters = parse.getQueryParameters(str4);
                            int i = 1;
                            if (queryParameters.size() <= 1) {
                                String str5 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                MatcherMatchResult find$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i2 = 0;
                                while (find$default != null) {
                                    MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(i);
                                    Intrinsics.checkNotNull(matchGroup);
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (find$default.getRange().first > i2) {
                                        String substring = str5.substring(i2, find$default.getRange().first);
                                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                        String quote = Pattern.quote(substring);
                                        Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                                        sb.append(quote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i2 = find$default.getRange().last + 1;
                                    find$default = find$default.next();
                                    i = 1;
                                }
                                if (i2 < str5.length()) {
                                    String substring2 = str5.substring(i2);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                    String quote2 = Pattern.quote(substring2);
                                    Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
                                    sb.append(quote2);
                                }
                                sb.append("$");
                                String sb2 = sb.toString();
                                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb2);
                                linkedHashMap.put(str4, paramQuery);
                            } else {
                                throw new IllegalArgumentException(("Query parameter " + str4 + " must only be present once in " + str3 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                            }
                        }
                    }
                    return linkedHashMap;
                case 3:
                    String str6 = this.f$0.uriPattern;
                    if (str6 != null) {
                        Uri parse2 = Uri.parse(str6);
                        Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                        if (parse2.getFragment() != null) {
                            ArrayList arrayList = new ArrayList();
                            Uri parse3 = Uri.parse(str6);
                            Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                            String fragment = parse3.getFragment();
                            StringBuilder sb3 = new StringBuilder();
                            Intrinsics.checkNotNull(fragment);
                            NavDeepLink.buildRegex(fragment, arrayList, sb3);
                            return new Pair(arrayList, sb3.toString());
                        }
                    }
                    return null;
                case 4:
                    Pair pair = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                    if (pair == null || (list = (List) pair.first) == null) {
                        return new ArrayList();
                    }
                    return list;
                case 5:
                    Pair pair2 = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                    if (pair2 != null) {
                        return (String) pair2.second;
                    }
                    return null;
                case 6:
                    String str7 = (String) this.f$0.fragRegex$delegate.getValue();
                    if (str7 != null) {
                        return new Regex(str7, 0);
                    }
                    return null;
                default:
                    String str8 = this.f$0.mimeTypeRegex;
                    if (str8 != null) {
                        return new Regex(str8);
                    }
                    return null;
            }
        }
    });
    public final SynchronizedLazyImpl mimeTypePattern$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
        public final /* synthetic */ NavDeepLink f$0;

        {
            this.f$0 = this;
        }

        /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object, kotlin.Lazy] */
        /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object, kotlin.Lazy] */
        /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object, kotlin.Lazy] */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean z;
            List list;
            switch (r2) {
                case 0:
                    String str = this.f$0.pathRegex;
                    if (str != null) {
                        return new Regex(str, 0);
                    }
                    return null;
                case 1:
                    String str2 = this.f$0.uriPattern;
                    if (str2 == null || !NavDeepLink.QUERY_PATTERN.matches(str2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                case 2:
                    NavDeepLink navDeepLink = this.f$0;
                    String str3 = navDeepLink.uriPattern;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                        Intrinsics.checkNotNull(str3);
                        Uri parse = Uri.parse(str3);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                        for (String str4 : parse.getQueryParameterNames()) {
                            StringBuilder sb = new StringBuilder();
                            List<String> queryParameters = parse.getQueryParameters(str4);
                            int i = 1;
                            if (queryParameters.size() <= 1) {
                                String str5 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                MatcherMatchResult find$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i2 = 0;
                                while (find$default != null) {
                                    MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(i);
                                    Intrinsics.checkNotNull(matchGroup);
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (find$default.getRange().first > i2) {
                                        String substring = str5.substring(i2, find$default.getRange().first);
                                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                        String quote = Pattern.quote(substring);
                                        Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                                        sb.append(quote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i2 = find$default.getRange().last + 1;
                                    find$default = find$default.next();
                                    i = 1;
                                }
                                if (i2 < str5.length()) {
                                    String substring2 = str5.substring(i2);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                    String quote2 = Pattern.quote(substring2);
                                    Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
                                    sb.append(quote2);
                                }
                                sb.append("$");
                                String sb2 = sb.toString();
                                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb2);
                                linkedHashMap.put(str4, paramQuery);
                            } else {
                                throw new IllegalArgumentException(("Query parameter " + str4 + " must only be present once in " + str3 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                            }
                        }
                    }
                    return linkedHashMap;
                case 3:
                    String str6 = this.f$0.uriPattern;
                    if (str6 != null) {
                        Uri parse2 = Uri.parse(str6);
                        Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                        if (parse2.getFragment() != null) {
                            ArrayList arrayList = new ArrayList();
                            Uri parse3 = Uri.parse(str6);
                            Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                            String fragment = parse3.getFragment();
                            StringBuilder sb3 = new StringBuilder();
                            Intrinsics.checkNotNull(fragment);
                            NavDeepLink.buildRegex(fragment, arrayList, sb3);
                            return new Pair(arrayList, sb3.toString());
                        }
                    }
                    return null;
                case 4:
                    Pair pair = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                    if (pair == null || (list = (List) pair.first) == null) {
                        return new ArrayList();
                    }
                    return list;
                case 5:
                    Pair pair2 = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                    if (pair2 != null) {
                        return (String) pair2.second;
                    }
                    return null;
                case 6:
                    String str7 = (String) this.f$0.fragRegex$delegate.getValue();
                    if (str7 != null) {
                        return new Regex(str7, 0);
                    }
                    return null;
                default:
                    String str8 = this.f$0.mimeTypeRegex;
                    if (str8 != null) {
                        return new Regex(str8);
                    }
                    return null;
            }
        }
    });

    /* loaded from: classes.dex */
    public final class ParamQuery {
        public final ArrayList arguments = new ArrayList();
        public String paramRegex;
    }

    public NavDeepLink(String str, String str2, String str3) {
        List<Object> list;
        boolean z;
        this.uriPattern = str;
        this.action = str2;
        this.mimeType = str3;
        ArrayList arrayList = new ArrayList();
        this.pathArgs = arrayList;
        Function0 navDeepLink$$ExternalSyntheticLambda0 = new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean z2;
                List list2;
                switch (r2) {
                    case 0:
                        String str4 = this.f$0.pathRegex;
                        if (str4 != null) {
                            return new Regex(str4, 0);
                        }
                        return null;
                    case 1:
                        String str22 = this.f$0.uriPattern;
                        if (str22 == null || !NavDeepLink.QUERY_PATTERN.matches(str22)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    case 2:
                        NavDeepLink navDeepLink = this.f$0;
                        String str32 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Intrinsics.checkNotNull(str32);
                            Uri parse = Uri.parse(str32);
                            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                            for (String str42 : parse.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = parse.getQueryParameters(str42);
                                int i = 1;
                                if (queryParameters.size() <= 1) {
                                    String str5 = (String) CollectionsKt.firstOrNull(queryParameters);
                                    if (str5 == null) {
                                        navDeepLink.isSingleQueryParamValueOnly = true;
                                        str5 = str42;
                                    }
                                    MatcherMatchResult find$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5);
                                    NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                    int i2 = 0;
                                    while (find$default != null) {
                                        MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(i);
                                        Intrinsics.checkNotNull(matchGroup);
                                        paramQuery.arguments.add(matchGroup.value);
                                        if (find$default.getRange().first > i2) {
                                            String substring = str5.substring(i2, find$default.getRange().first);
                                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                            String quote = Pattern.quote(substring);
                                            Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                                            sb.append(quote);
                                        }
                                        sb.append("([\\s\\S]+?)?");
                                        i2 = find$default.getRange().last + 1;
                                        find$default = find$default.next();
                                        i = 1;
                                    }
                                    if (i2 < str5.length()) {
                                        String substring2 = str5.substring(i2);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                        String quote2 = Pattern.quote(substring2);
                                        Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
                                        sb.append(quote2);
                                    }
                                    sb.append("$");
                                    String sb2 = sb.toString();
                                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                    paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb2);
                                    linkedHashMap.put(str42, paramQuery);
                                } else {
                                    throw new IllegalArgumentException(("Query parameter " + str42 + " must only be present once in " + str32 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = this.f$0.uriPattern;
                        if (str6 != null) {
                            Uri parse2 = Uri.parse(str6);
                            Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                            if (parse2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri parse3 = Uri.parse(str6);
                                Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                                String fragment = parse3.getFragment();
                                StringBuilder sb3 = new StringBuilder();
                                Intrinsics.checkNotNull(fragment);
                                NavDeepLink.buildRegex(fragment, arrayList2, sb3);
                                return new Pair(arrayList2, sb3.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pair = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                        if (pair == null || (list2 = (List) pair.first) == null) {
                            return new ArrayList();
                        }
                        return list2;
                    case 5:
                        Pair pair2 = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) this.f$0.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        String str8 = this.f$0.mimeTypeRegex;
                        if (str8 != null) {
                            return new Regex(str8);
                        }
                        return null;
                }
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.queryArgsMap$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, navDeepLink$$ExternalSyntheticLambda0);
        this.fragArgsAndRegex$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean z2;
                List list2;
                switch (r2) {
                    case 0:
                        String str4 = this.f$0.pathRegex;
                        if (str4 != null) {
                            return new Regex(str4, 0);
                        }
                        return null;
                    case 1:
                        String str22 = this.f$0.uriPattern;
                        if (str22 == null || !NavDeepLink.QUERY_PATTERN.matches(str22)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    case 2:
                        NavDeepLink navDeepLink = this.f$0;
                        String str32 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Intrinsics.checkNotNull(str32);
                            Uri parse = Uri.parse(str32);
                            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                            for (String str42 : parse.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = parse.getQueryParameters(str42);
                                int i = 1;
                                if (queryParameters.size() <= 1) {
                                    String str5 = (String) CollectionsKt.firstOrNull(queryParameters);
                                    if (str5 == null) {
                                        navDeepLink.isSingleQueryParamValueOnly = true;
                                        str5 = str42;
                                    }
                                    MatcherMatchResult find$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5);
                                    NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                    int i2 = 0;
                                    while (find$default != null) {
                                        MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(i);
                                        Intrinsics.checkNotNull(matchGroup);
                                        paramQuery.arguments.add(matchGroup.value);
                                        if (find$default.getRange().first > i2) {
                                            String substring = str5.substring(i2, find$default.getRange().first);
                                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                            String quote = Pattern.quote(substring);
                                            Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                                            sb.append(quote);
                                        }
                                        sb.append("([\\s\\S]+?)?");
                                        i2 = find$default.getRange().last + 1;
                                        find$default = find$default.next();
                                        i = 1;
                                    }
                                    if (i2 < str5.length()) {
                                        String substring2 = str5.substring(i2);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                        String quote2 = Pattern.quote(substring2);
                                        Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
                                        sb.append(quote2);
                                    }
                                    sb.append("$");
                                    String sb2 = sb.toString();
                                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                    paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb2);
                                    linkedHashMap.put(str42, paramQuery);
                                } else {
                                    throw new IllegalArgumentException(("Query parameter " + str42 + " must only be present once in " + str32 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = this.f$0.uriPattern;
                        if (str6 != null) {
                            Uri parse2 = Uri.parse(str6);
                            Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                            if (parse2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri parse3 = Uri.parse(str6);
                                Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                                String fragment = parse3.getFragment();
                                StringBuilder sb3 = new StringBuilder();
                                Intrinsics.checkNotNull(fragment);
                                NavDeepLink.buildRegex(fragment, arrayList2, sb3);
                                return new Pair(arrayList2, sb3.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pair = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                        if (pair == null || (list2 = (List) pair.first) == null) {
                            return new ArrayList();
                        }
                        return list2;
                    case 5:
                        Pair pair2 = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) this.f$0.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        String str8 = this.f$0.mimeTypeRegex;
                        if (str8 != null) {
                            return new Regex(str8);
                        }
                        return null;
                }
            }
        });
        this.fragArgs$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean z2;
                List list2;
                switch (r2) {
                    case 0:
                        String str4 = this.f$0.pathRegex;
                        if (str4 != null) {
                            return new Regex(str4, 0);
                        }
                        return null;
                    case 1:
                        String str22 = this.f$0.uriPattern;
                        if (str22 == null || !NavDeepLink.QUERY_PATTERN.matches(str22)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    case 2:
                        NavDeepLink navDeepLink = this.f$0;
                        String str32 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Intrinsics.checkNotNull(str32);
                            Uri parse = Uri.parse(str32);
                            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                            for (String str42 : parse.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = parse.getQueryParameters(str42);
                                int i = 1;
                                if (queryParameters.size() <= 1) {
                                    String str5 = (String) CollectionsKt.firstOrNull(queryParameters);
                                    if (str5 == null) {
                                        navDeepLink.isSingleQueryParamValueOnly = true;
                                        str5 = str42;
                                    }
                                    MatcherMatchResult find$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5);
                                    NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                    int i2 = 0;
                                    while (find$default != null) {
                                        MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(i);
                                        Intrinsics.checkNotNull(matchGroup);
                                        paramQuery.arguments.add(matchGroup.value);
                                        if (find$default.getRange().first > i2) {
                                            String substring = str5.substring(i2, find$default.getRange().first);
                                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                            String quote = Pattern.quote(substring);
                                            Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                                            sb.append(quote);
                                        }
                                        sb.append("([\\s\\S]+?)?");
                                        i2 = find$default.getRange().last + 1;
                                        find$default = find$default.next();
                                        i = 1;
                                    }
                                    if (i2 < str5.length()) {
                                        String substring2 = str5.substring(i2);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                        String quote2 = Pattern.quote(substring2);
                                        Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
                                        sb.append(quote2);
                                    }
                                    sb.append("$");
                                    String sb2 = sb.toString();
                                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                    paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb2);
                                    linkedHashMap.put(str42, paramQuery);
                                } else {
                                    throw new IllegalArgumentException(("Query parameter " + str42 + " must only be present once in " + str32 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = this.f$0.uriPattern;
                        if (str6 != null) {
                            Uri parse2 = Uri.parse(str6);
                            Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                            if (parse2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri parse3 = Uri.parse(str6);
                                Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                                String fragment = parse3.getFragment();
                                StringBuilder sb3 = new StringBuilder();
                                Intrinsics.checkNotNull(fragment);
                                NavDeepLink.buildRegex(fragment, arrayList2, sb3);
                                return new Pair(arrayList2, sb3.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pair = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                        if (pair == null || (list2 = (List) pair.first) == null) {
                            return new ArrayList();
                        }
                        return list2;
                    case 5:
                        Pair pair2 = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) this.f$0.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        String str8 = this.f$0.mimeTypeRegex;
                        if (str8 != null) {
                            return new Regex(str8);
                        }
                        return null;
                }
            }
        });
        this.fragRegex$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r1v34, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean z2;
                List list2;
                switch (r2) {
                    case 0:
                        String str4 = this.f$0.pathRegex;
                        if (str4 != null) {
                            return new Regex(str4, 0);
                        }
                        return null;
                    case 1:
                        String str22 = this.f$0.uriPattern;
                        if (str22 == null || !NavDeepLink.QUERY_PATTERN.matches(str22)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    case 2:
                        NavDeepLink navDeepLink = this.f$0;
                        String str32 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Intrinsics.checkNotNull(str32);
                            Uri parse = Uri.parse(str32);
                            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                            for (String str42 : parse.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = parse.getQueryParameters(str42);
                                int i = 1;
                                if (queryParameters.size() <= 1) {
                                    String str5 = (String) CollectionsKt.firstOrNull(queryParameters);
                                    if (str5 == null) {
                                        navDeepLink.isSingleQueryParamValueOnly = true;
                                        str5 = str42;
                                    }
                                    MatcherMatchResult find$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5);
                                    NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                    int i2 = 0;
                                    while (find$default != null) {
                                        MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(i);
                                        Intrinsics.checkNotNull(matchGroup);
                                        paramQuery.arguments.add(matchGroup.value);
                                        if (find$default.getRange().first > i2) {
                                            String substring = str5.substring(i2, find$default.getRange().first);
                                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                            String quote = Pattern.quote(substring);
                                            Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                                            sb.append(quote);
                                        }
                                        sb.append("([\\s\\S]+?)?");
                                        i2 = find$default.getRange().last + 1;
                                        find$default = find$default.next();
                                        i = 1;
                                    }
                                    if (i2 < str5.length()) {
                                        String substring2 = str5.substring(i2);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                        String quote2 = Pattern.quote(substring2);
                                        Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
                                        sb.append(quote2);
                                    }
                                    sb.append("$");
                                    String sb2 = sb.toString();
                                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                                    paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb2);
                                    linkedHashMap.put(str42, paramQuery);
                                } else {
                                    throw new IllegalArgumentException(("Query parameter " + str42 + " must only be present once in " + str32 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = this.f$0.uriPattern;
                        if (str6 != null) {
                            Uri parse2 = Uri.parse(str6);
                            Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
                            if (parse2.getFragment() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                Uri parse3 = Uri.parse(str6);
                                Intrinsics.checkNotNullExpressionValue(parse3, "parse(...)");
                                String fragment = parse3.getFragment();
                                StringBuilder sb3 = new StringBuilder();
                                Intrinsics.checkNotNull(fragment);
                                NavDeepLink.buildRegex(fragment, arrayList2, sb3);
                                return new Pair(arrayList2, sb3.toString());
                            }
                        }
                        return null;
                    case 4:
                        Pair pair = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                        if (pair == null || (list2 = (List) pair.first) == null) {
                            return new ArrayList();
                        }
                        return list2;
                    case 5:
                        Pair pair2 = (Pair) this.f$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) this.f$0.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        String str8 = this.f$0.mimeTypeRegex;
                        if (str8 != null) {
                            return new Regex(str8);
                        }
                        return null;
                }
            }
        });
        if (str != null) {
            StringBuilder sb = new StringBuilder("^");
            Regex regex = SCHEME_PATTERN;
            regex.getClass();
            if (!regex.nativePattern.matcher(str).find()) {
                String pattern = SCHEME_REGEX.nativePattern.pattern();
                Intrinsics.checkNotNullExpressionValue(pattern, "pattern(...)");
                sb.append(pattern);
            }
            MatcherMatchResult find$default = Regex.find$default(new Regex("(\\?|#|$)"), str);
            if (find$default != null) {
                String substring = str.substring(0, find$default.getRange().first);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                buildRegex(substring, arrayList, sb);
                Regex regex2 = WILDCARD_REGEX;
                regex2.getClass();
                if (!regex2.nativePattern.matcher(sb).find()) {
                    Regex regex3 = PATH_REGEX;
                    regex3.getClass();
                    if (!regex3.nativePattern.matcher(sb).find()) {
                        z = true;
                        this.isExactDeepLink = z;
                        sb.append("($|(\\?(.)*)|(#(.)*))");
                    }
                }
                z = false;
                this.isExactDeepLink = z;
                sb.append("($|(\\?(.)*)|(#(.)*))");
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            this.pathRegex = saveWildcardInRegex(sb2);
        }
        if (str3 != null) {
            Pattern compile = Pattern.compile("^[\\s\\S]+/[\\s\\S]+$");
            Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
            if (compile.matcher(str3).matches()) {
                Pattern compile2 = Pattern.compile("/");
                Intrinsics.checkNotNullExpressionValue(compile2, "compile(...)");
                Matcher matcher = compile2.matcher(str3);
                if (!matcher.find()) {
                    list = LazyKt__LazyJVMKt.listOf(str3.toString());
                } else {
                    ArrayList arrayList2 = new ArrayList(10);
                    int i = 0;
                    do {
                        arrayList2.add(str3.subSequence(i, matcher.start()).toString());
                        i = matcher.end();
                    } while (matcher.find());
                    arrayList2.add(str3.subSequence(i, str3.length()).toString());
                    list = arrayList2;
                }
                boolean isEmpty = list.isEmpty();
                List list2 = EmptyList.INSTANCE;
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
                                    ArrayList arrayList3 = new ArrayList(nextIndex);
                                    int i2 = 0;
                                    for (Object obj : list) {
                                        arrayList3.add(obj);
                                        i2++;
                                        if (i2 == nextIndex) {
                                            break;
                                        }
                                    }
                                    list2 = CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList3);
                                }
                            }
                        }
                    }
                }
                this.mimeTypeRegex = StringsKt__StringsKt.replace$default("^(" + ((String) list2.get(0)) + "|[*]+)/(" + ((String) list2.get(1)) + "|[*]+)$", "*|[*]", "[\\s\\S]");
                return;
            }
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m("The given mimeType ", str3, " does not match to required \"type/subtype\" format").toString());
        }
    }

    public static void buildRegex(String str, ArrayList arrayList, StringBuilder sb) {
        int i = 0;
        for (MatcherMatchResult find$default = Regex.find$default(FILL_IN_PATTERN, str); find$default != null; find$default = find$default.next()) {
            MatchGroup matchGroup = ((MatcherMatchResult$groups$1) find$default.groups).get(1);
            Intrinsics.checkNotNull(matchGroup);
            arrayList.add(matchGroup.value);
            if (find$default.getRange().first > i) {
                String substring = str.substring(i, find$default.getRange().first);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String quote = Pattern.quote(substring);
                Intrinsics.checkNotNullExpressionValue(quote, "quote(...)");
                sb.append(quote);
            }
            String pattern = PATH_REGEX.nativePattern.pattern();
            Intrinsics.checkNotNullExpressionValue(pattern, "pattern(...)");
            sb.append(pattern);
            i = find$default.getRange().last + 1;
        }
        if (i < str.length()) {
            String substring2 = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            String quote2 = Pattern.quote(substring2);
            Intrinsics.checkNotNullExpressionValue(quote2, "quote(...)");
            sb.append(quote2);
        }
    }

    public static void parseArgument(Bundle bundle, String key, String str, NavArgument navArgument) {
        if (navArgument != null) {
            NavType navType = navArgument.type;
            Intrinsics.checkNotNullParameter(key, "key");
            navType.put(bundle, key, navType.mo19parseValue(str));
            return;
        }
        Navigation.m25putStringimpl(bundle, key, str);
    }

    public static String saveWildcardInRegex(String str) {
        if (StringsKt__StringsKt.contains$default(str, "\\Q") && StringsKt__StringsKt.contains$default(str, "\\E")) {
            return StringsKt__StringsKt.replace$default(str, ".*", "\\E.*\\Q");
        }
        if (StringsKt__StringsKt.contains$default(str, "\\.\\*")) {
            return StringsKt__StringsKt.replace$default(str, "\\.\\*", ".*");
        }
        return str;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof NavDeepLink)) {
            NavDeepLink navDeepLink = (NavDeepLink) obj;
            if (Intrinsics.areEqual(this.uriPattern, navDeepLink.uriPattern) && Intrinsics.areEqual(this.action, navDeepLink.action) && Intrinsics.areEqual(this.mimeType, navDeepLink.mimeType)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.Lazy] */
    public final ArrayList getArgumentsNames$navigation_common_release() {
        Collection<ParamQuery> values = ((Map) this.queryArgsMap$delegate.getValue()).values();
        ArrayList arrayList = new ArrayList();
        for (ParamQuery paramQuery : values) {
            CollectionsKt__MutableCollectionsKt.addAll(paramQuery.arguments, arrayList);
        }
        return CollectionsKt.plus(CollectionsKt.plus(this.pathArgs, arrayList), (List) this.fragArgs$delegate.getValue());
    }

    public final boolean getMatchingPathArguments(MatcherMatchResult matcherMatchResult, Bundle bundle, Map map) {
        ArrayList arrayList = this.pathArgs;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            int i3 = i + 1;
            String str = null;
            if (i >= 0) {
                String str2 = (String) obj;
                MatchGroup matchGroup = ((MatcherMatchResult$groups$1) matcherMatchResult.groups).get(i3);
                if (matchGroup != null) {
                    str = Uri.decode(matchGroup.value);
                    Intrinsics.checkNotNullExpressionValue(str, "decode(...)");
                }
                if (str == null) {
                    str = "";
                }
                try {
                    parseArgument(bundle, str2, str, (NavArgument) map.get(str2));
                    arrayList2.add(Unit.INSTANCE);
                    i = i3;
                } catch (IllegalArgumentException unused) {
                    return false;
                }
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.Lazy] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean getMatchingQueryArguments(android.net.Uri r20, android.os.Bundle r21, java.util.Map r22) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDeepLink.getMatchingQueryArguments(android.net.Uri, android.os.Bundle, java.util.Map):boolean");
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        String str = this.uriPattern;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        String str2 = this.action;
        if (str2 != null) {
            i2 = str2.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i4 + i2) * 31;
        String str3 = this.mimeType;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i5 + i3;
    }
}
