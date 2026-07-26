package p004j$.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Collection;
import p004j$.util.stream.Stream;
/* renamed from: j$.util.k */
/* loaded from: classes2.dex */
public class C0462k implements Collection, Serializable, Collection {
    private static final long serialVersionUID = 1820017752578914078L;

    /* renamed from: a */
    public final Collection f440a;

    @Override // p004j$.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public C0462k(java.util.Collection collection) {
        collection.getClass();
        this.f440a = collection;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f440a.size();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f440a.isEmpty();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.f440a.contains(obj);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.f440a.toArray();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f440a.toArray(objArr);
    }

    public final String toString() {
        return this.f440a.toString();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new C0459j(this);
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(java.util.Collection collection) {
        return this.f440a.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean removeAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Iterable, p004j$.util.Collection
    public void forEach(Consumer consumer) {
        AbstractC0279a.m553L(this.f440a, consumer);
    }

    @Override // java.util.Collection, p004j$.util.Collection
    public final boolean removeIf(Predicate predicate) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable, p004j$.util.Collection
    /* renamed from: spliterator */
    public Spliterator mo888spliterator() {
        return AbstractC0279a.m535b0(this.f440a);
    }

    @Override // java.util.Collection, p004j$.util.Collection
    /* renamed from: stream */
    public Stream mo889stream() {
        return AbstractC0279a.m533c0(this.f440a);
    }

    @Override // java.util.Collection, p004j$.util.Collection
    /* renamed from: parallelStream */
    public Stream mo887parallelStream() {
        return AbstractC0279a.m539Z(this.f440a);
    }
}
