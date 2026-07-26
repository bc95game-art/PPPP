package kotlin.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class MapsKt__MapsKt extends LazyKt__LazyJVMKt {
    public static int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map toMap(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(arrayList.size()));
            int size2 = arrayList.size();
            int i = 0;
            while (i < size2) {
                Object obj = arrayList.get(i);
                i++;
                Pair pair = (Pair) obj;
                linkedHashMap.put(pair.first, pair.second);
            }
            return linkedHashMap;
        }
        Pair pair2 = (Pair) arrayList.get(0);
        Intrinsics.checkNotNullParameter(pair2, "pair");
        Map singletonMap = Collections.singletonMap(pair2.first, pair2.second);
        Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static Map toMap(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "with(...)");
        return singletonMap;
    }
}
