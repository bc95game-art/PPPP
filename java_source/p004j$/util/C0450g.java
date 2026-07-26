package p004j$.util;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Collection;
import p004j$.util.Spliterator;
import p004j$.util.stream.Stream;
/* renamed from: j$.util.g */
/* loaded from: classes2.dex */
public class C0450g implements Collection, Serializable, Collection {
    private static final long serialVersionUID = 3053995032091335093L;

    /* renamed from: a */
    public final Collection f416a;

    /* renamed from: b */
    public final Object f417b;

    @Override // p004j$.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        Object[] array;
        array = toArray((Object[]) intFunction.apply(0));
        return array;
    }

    public C0450g(Collection collection, C0453h hVar) {
        this.f416a = (Collection) Objects.requireNonNull(collection);
        this.f417b = Objects.requireNonNull(hVar);
    }

    @Override // java.util.Collection
    public final int size() {
        int size;
        synchronized (this.f417b) {
            size = this.f416a.size();
        }
        return size;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f417b) {
            isEmpty = this.f416a.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        boolean contains;
        synchronized (this.f417b) {
            contains = this.f416a.contains(obj);
        }
        return contains;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] array;
        synchronized (this.f417b) {
            array = this.f416a.toArray();
        }
        return array;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.f417b) {
            array = this.f416a.toArray(objArr);
        }
        return array;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f416a.iterator();
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        boolean add;
        synchronized (this.f417b) {
            add = this.f416a.add(obj);
        }
        return add;
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        boolean remove;
        synchronized (this.f417b) {
            remove = this.f416a.remove(obj);
        }
        return remove;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        boolean containsAll;
        synchronized (this.f417b) {
            containsAll = this.f416a.containsAll(collection);
        }
        return containsAll;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        boolean addAll;
        synchronized (this.f417b) {
            addAll = this.f416a.addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        boolean removeAll;
        synchronized (this.f417b) {
            removeAll = this.f416a.removeAll(collection);
        }
        return removeAll;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        boolean retainAll;
        synchronized (this.f417b) {
            retainAll = this.f416a.retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection
    public final void clear() {
        synchronized (this.f417b) {
            this.f416a.clear();
        }
    }

    public final String toString() {
        String obj;
        synchronized (this.f417b) {
            obj = this.f416a.toString();
        }
        return obj;
    }

    @Override // java.lang.Iterable, p004j$.util.Collection
    public final void forEach(Consumer consumer) {
        synchronized (this.f417b) {
            AbstractC0279a.m553L(this.f416a, consumer);
        }
    }

    @Override // java.util.Collection, p004j$.util.Collection
    public final boolean removeIf(Predicate predicate) {
        boolean removeIf;
        synchronized (this.f417b) {
            Collection collection = this.f416a;
            removeIf = collection instanceof Collection ? ((Collection) collection).removeIf(predicate) : Collection.CC.$default$removeIf(collection, predicate);
        }
        return removeIf;
    }

    @Override // java.util.Collection, java.lang.Iterable, p004j$.util.Collection
    /* renamed from: spliterator */
    public final Spliterator mo888spliterator() {
        return AbstractC0279a.m535b0(this.f416a);
    }

    @Override // java.util.Collection, java.lang.Iterable, p004j$.util.Collection
    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator mo888spliterator() {
        return Spliterator.Wrapper.convert(AbstractC0279a.m535b0(this.f416a));
    }

    @Override // java.util.Collection, p004j$.util.Collection
    /* renamed from: stream */
    public final Stream mo889stream() {
        return AbstractC0279a.m533c0(this.f416a);
    }

    @Override // java.util.Collection, p004j$.util.Collection
    /* renamed from: stream  reason: collision with other method in class */
    public final java.util.stream.Stream mo889stream() {
        return Stream.Wrapper.convert(AbstractC0279a.m533c0(this.f416a));
    }

    @Override // java.util.Collection, p004j$.util.Collection
    /* renamed from: parallelStream */
    public final Stream mo887parallelStream() {
        return AbstractC0279a.m539Z(this.f416a);
    }

    @Override // java.util.Collection, p004j$.util.Collection
    /* renamed from: parallelStream  reason: collision with other method in class */
    public final java.util.stream.Stream mo887parallelStream() {
        return Stream.Wrapper.convert(AbstractC0279a.m539Z(this.f416a));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f417b) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
