package p004j$.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.stream.AbstractC0488a;
import p004j$.util.stream.EnumC0725x6;
import p004j$.util.stream.Stream;
/* renamed from: j$.util.q */
/* loaded from: classes2.dex */
public final class C0480q extends C0746t {
    private static final long serialVersionUID = 7854390611657943733L;

    @Override // p004j$.util.C0462k, java.lang.Iterable, p004j$.util.Collection
    public final void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        AbstractC0279a.m553L(this.f440a, new C0471n(0, consumer));
    }

    @Override // p004j$.util.C0462k, java.util.Collection, java.lang.Iterable, p004j$.util.Collection
    /* renamed from: spliterator */
    public final Spliterator mo888spliterator() {
        return new C0477p(AbstractC0279a.m535b0(this.f440a));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.stream.Stream, j$.util.stream.a] */
    @Override // p004j$.util.C0462k, java.util.Collection, p004j$.util.Collection
    /* renamed from: stream */
    public final Stream mo889stream() {
        Spliterator spliterator = mo888spliterator();
        Objects.requireNonNull(spliterator);
        return new AbstractC0488a(spliterator, EnumC0725x6.m67k(spliterator), false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.stream.Stream, j$.util.stream.a] */
    @Override // p004j$.util.C0462k, java.util.Collection, p004j$.util.Collection
    /* renamed from: parallelStream */
    public final Stream mo887parallelStream() {
        Spliterator spliterator = mo888spliterator();
        Objects.requireNonNull(spliterator);
        return new AbstractC0488a(spliterator, EnumC0725x6.m67k(spliterator), true);
    }

    @Override // p004j$.util.C0462k, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0459j(this);
    }

    @Override // p004j$.util.C0462k, java.util.Collection
    public final Object[] toArray() {
        Object[] array = this.f440a.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = new C0474o((Map.Entry) array[i]);
        }
        return array;
    }

    @Override // p004j$.util.C0462k, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array = this.f440a.toArray(objArr.length == 0 ? objArr : Arrays.copyOf(objArr, 0));
        for (int i = 0; i < array.length; i++) {
            array[i] = new C0474o((Map.Entry) array[i]);
        }
        if (array.length > objArr.length) {
            return array;
        }
        System.arraycopy(array, 0, objArr, 0, array.length);
        if (objArr.length > array.length) {
            objArr[array.length] = null;
        }
        return objArr;
    }

    @Override // p004j$.util.C0462k, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return this.f440a.contains(new C0474o((Map.Entry) obj));
    }

    @Override // p004j$.util.C0462k, java.util.Collection
    public final boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // p004j$.util.C0746t, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != this.f440a.size()) {
            return false;
        }
        return containsAll(set);
    }
}
