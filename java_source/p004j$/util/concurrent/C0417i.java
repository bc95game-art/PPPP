package p004j$.util.concurrent;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import p004j$.util.Collection;
import p004j$.util.Spliterator;
/* renamed from: j$.util.concurrent.i */
/* loaded from: classes2.dex */
public final class C0417i extends AbstractC0410b implements Set, p004j$.util.Set {
    private static final long serialVersionUID = 7249069246763182397L;

    @Override // java.util.Collection, p004j$.util.Collection
    public final /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // p004j$.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        Object[] array;
        array = toArray((Object[]) intFunction.apply(0));
        return array;
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f336a.containsKey(obj);
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f336a.remove(obj) != null;
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f336a;
        C0420l[] lVarArr = concurrentHashMap.f321a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new C0416h(lVarArr, length, length, concurrentHashMap, 0);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (((AbstractC0409a) it).hasNext()) {
            i += ((C0416h) it).next().hashCode();
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
        return new C0418j(lVarArr, length, 0, length, j < 0 ? 0L : j, 0);
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
                    consumer.accept(a.f347b);
                } else {
                    return;
                }
            }
        }
    }
}
