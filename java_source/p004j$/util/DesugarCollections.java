package p004j$.util;

import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
/* renamed from: j$.util.DesugarCollections */
/* loaded from: classes2.dex */
public class DesugarCollections {
    public static <T> Set<T> unmodifiableSet(Set<? extends T> set) {
        return (Set<T>) new C0462k(set);
    }

    public static <T> List<T> unmodifiableList(List<? extends T> list) {
        if (list instanceof RandomAccess) {
            return new C0468m(list);
        }
        return new C0468m(list);
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        return new C0483r(map);
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return new C0453h(map);
    }
}
