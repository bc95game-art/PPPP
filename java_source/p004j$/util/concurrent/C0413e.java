package p004j$.util.concurrent;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import p004j$.util.Spliterator;
/* renamed from: j$.util.concurrent.e */
/* loaded from: classes2.dex */
public final class C0413e extends AbstractC0410b implements Set, p004j$.util.Set {
    private static final long serialVersionUID = 2249069246763182397L;

    @Override // p004j$.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        Object[] array;
        array = toArray((Object[]) intFunction.apply(0));
        return array;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.f336a.m267f(entry.getKey(), entry.getValue(), false) == null;
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection
    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        Object obj2;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = this.f336a.get(key)) == null || (value = entry.getValue()) == null) {
            return false;
        }
        return value == obj2 || value.equals(obj2);
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection
    public final boolean remove(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.f336a.remove(key, value);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [j$.util.concurrent.a, java.util.Iterator] */
    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f336a;
        C0420l[] lVarArr = concurrentHashMap.f321a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new AbstractC0409a(lVarArr, length, length, concurrentHashMap);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f336a.m267f(entry.getKey(), entry.getValue(), false) == null) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, p004j$.util.Collection
    public final boolean removeIf(Predicate predicate) {
        ConcurrentHashMap concurrentHashMap = this.f336a;
        predicate.getClass();
        C0420l[] lVarArr = concurrentHashMap.f321a;
        boolean z = false;
        if (lVarArr != null) {
            C0424p pVar = new C0424p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                C0420l a = pVar.m249a();
                if (a == null) {
                    break;
                }
                Object obj = a.f347b;
                Object obj2 = a.f348c;
                if (predicate.test(new AbstractMap.SimpleImmutableEntry(obj, obj2)) && concurrentHashMap.m266g(obj, null, obj2) != null) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        C0420l[] lVarArr = this.f336a.f321a;
        int i = 0;
        if (lVarArr != null) {
            C0424p pVar = new C0424p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                C0420l a = pVar.m249a();
                if (a == null) {
                    break;
                }
                i += a.hashCode();
            }
        }
        return i;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set != this) {
            return containsAll(set) && set.containsAll(this);
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set, p004j$.util.Collection
    /* renamed from: spliterator */
    public final Spliterator mo888spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f336a;
        long j = concurrentHashMap.m263j();
        C0420l[] lVarArr = concurrentHashMap.f321a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        long j2 = 0;
        if (j >= 0) {
            j2 = j;
        }
        int i = length;
        return new C0414f(lVarArr, i, 0, i, j2, concurrentHashMap);
    }

    @Override // java.lang.Iterable, p004j$.util.Collection
    public final void forEach(Consumer consumer) {
        consumer.getClass();
        C0420l[] lVarArr = this.f336a.f321a;
        if (lVarArr != null) {
            C0424p pVar = new C0424p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                C0420l a = pVar.m249a();
                if (a != null) {
                    consumer.accept(new C0419k(a.f347b, a.f348c, this.f336a));
                } else {
                    return;
                }
            }
        }
    }
}
