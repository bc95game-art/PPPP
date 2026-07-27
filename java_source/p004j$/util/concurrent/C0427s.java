package p004j$.util.concurrent;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import p004j$.util.Collection;
import p004j$.util.Spliterator;
/* renamed from: j$.util.concurrent.s */
/* loaded from: classes2.dex */
public final class C0427s extends AbstractC0410b implements Collection {
    private static final long serialVersionUID = 2249069246763182397L;

    @Override // p004j$.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        Object[] array;
        array = toArray((Object[]) intFunction.apply(0));
        return array;
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f336a.containsValue(obj);
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection
    public final boolean remove(Object obj) {
        AbstractC0409a aVar;
        if (obj == null) {
            return false;
        }
        Iterator it = iterator();
        do {
            aVar = (AbstractC0409a) it;
            if (!aVar.hasNext()) {
                return false;
            }
        } while (!obj.equals(((C0416h) it).next()));
        aVar.remove();
        return true;
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f336a;
        C0420l[] lVarArr = concurrentHashMap.f321a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new C0416h(lVarArr, length, length, concurrentHashMap, 1);
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // p004j$.util.concurrent.AbstractC0410b, java.util.Collection
    public final boolean removeAll(java.util.Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z = false;
        while (true) {
            AbstractC0409a aVar = (AbstractC0409a) it;
            if (!aVar.hasNext()) {
                return z;
            }
            if (collection.contains(((C0416h) it).next())) {
                aVar.remove();
                z = true;
            }
        }
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
                if (predicate.test(obj2) && concurrentHashMap.m266g(obj, null, obj2) != null) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.lang.Iterable, p004j$.util.Collection
    /* renamed from: spliterator */
    public final Spliterator mo888spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f336a;
        long j = concurrentHashMap.m263j();
        C0420l[] lVarArr = concurrentHashMap.f321a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new C0418j(lVarArr, length, 0, length, j < 0 ? 0L : j, 1);
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
                    consumer.accept(a.f348c);
                } else {
                    return;
                }
            }
        }
    }
}
