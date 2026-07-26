package kotlin.collections;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class CollectionsKt extends CollectionsKt__MutableCollectionsKt {
    public static boolean contains(Iterable iterable, Object obj) {
        int i;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                } else if (Intrinsics.areEqual(obj, next)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            i = ((List) iterable).indexOf(obj);
        }
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static Object first(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object firstOrNull(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object getOrNull(int i, List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static Object last(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object lastOrNull(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Comparable maxOrNull(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static ArrayList plus(Collection collection, Iterable elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        CollectionsKt__MutableCollectionsKt.addAll(elements, arrayList2);
        return arrayList2;
    }

    public static List reversed(Iterable iterable) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        if (z && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        if (z) {
            arrayList = toMutableList((Collection) iterable);
        } else {
            ArrayList arrayList2 = new ArrayList();
            toCollection(iterable, arrayList2);
            arrayList = arrayList2;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static final void toCollection(Iterable iterable, AbstractCollection abstractCollection) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        for (Object obj : iterable) {
            abstractCollection.add(obj);
        }
    }

    public static int[] toIntArray(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int[] iArr = new int[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List toList(Iterable iterable) {
        ArrayList arrayList;
        Object obj;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return EmptyList.INSTANCE;
            }
            if (size != 1) {
                return toMutableList(collection);
            }
            if (iterable instanceof List) {
                obj = ((List) iterable).get(0);
            } else {
                obj = iterable.iterator().next();
            }
            return LazyKt__LazyJVMKt.listOf(obj);
        }
        if (z) {
            arrayList = toMutableList((Collection) iterable);
        } else {
            ArrayList arrayList2 = new ArrayList();
            toCollection(iterable, arrayList2);
            arrayList = arrayList2;
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public static ArrayList toMutableList(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set toSet(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return EmptySet.INSTANCE;
        }
        if (size != 1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(arrayList.size()));
            toCollection(arrayList, linkedHashSet);
            return linkedHashSet;
        }
        Set singleton = Collections.singleton(arrayList.get(0));
        Intrinsics.checkNotNullExpressionValue(singleton, "singleton(...)");
        return singleton;
    }
}
