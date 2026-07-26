package p004j$.util;

import java.util.ListIterator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.l */
/* loaded from: classes2.dex */
public final class C0465l implements ListIterator, AbstractC0752w {

    /* renamed from: a */
    public final ListIterator f443a;

    public C0465l(C0468m mVar, int i) {
        this.f443a = mVar.f445b.listIterator(i);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f443a.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.f443a.next();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f443a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.f443a.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f443a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f443a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, p004j$.util.AbstractC0752w
    public final void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m551N(this.f443a, consumer);
    }
}
