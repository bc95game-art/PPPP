package p004j$.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.d1 */
/* loaded from: classes2.dex */
public final class C0436d1 implements Iterator, Consumer {

    /* renamed from: a */
    public boolean f391a = false;

    /* renamed from: b */
    public Object f392b;

    /* renamed from: c */
    public final /* synthetic */ Spliterator f393c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    public C0436d1(Spliterator spliterator) {
        this.f393c = spliterator;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f391a = true;
        this.f392b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f391a) {
            this.f393c.tryAdvance(this);
        }
        return this.f391a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f391a || hasNext()) {
            this.f391a = false;
            return this.f392b;
        }
        throw new NoSuchElementException();
    }
}
