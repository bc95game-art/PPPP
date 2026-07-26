package p004j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;
/* renamed from: j$.util.m */
/* loaded from: classes2.dex */
public class C0468m extends C0462k implements List, List {
    private static final long serialVersionUID = -283967356065247728L;

    /* renamed from: b */
    public final List f445b;

    public C0468m(List list) {
        super(list);
        this.f445b = list;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        return obj == this || this.f445b.equals(obj);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        return this.f445b.hashCode();
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.f445b.get(i);
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f445b.indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f445b.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, p004j$.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, p004j$.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new C0465l(this, 0);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new C0465l(this, i);
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new C0468m(this.f445b.subList(i, i2));
    }

    private Object readResolve() {
        List list = this.f445b;
        return list instanceof RandomAccess ? new C0468m(list) : this;
    }
}
