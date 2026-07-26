package p004j$.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.f1 */
/* loaded from: classes2.dex */
public final class C0442f1 implements AbstractC0472n0, LongConsumer, AbstractC0752w {

    /* renamed from: a */
    public boolean f399a = false;

    /* renamed from: b */
    public long f400b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC0757y0 f401c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.AbstractC0472n0
    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        while (hasNext()) {
            longConsumer.accept(nextLong());
        }
    }

    @Override // p004j$.util.AbstractC0472n0, java.util.Iterator
    public final Long next() {
        if (!AbstractC0485r1.f472a) {
            return Long.valueOf(nextLong());
        }
        AbstractC0485r1.m227a(C0442f1.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
        throw null;
    }

    @Override // p004j$.util.AbstractC0472n0, java.util.Iterator, p004j$.util.AbstractC0752w
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            forEachRemaining((LongConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((LongConsumer) new C0463k0(consumer, 0));
            return;
        }
        AbstractC0485r1.m227a(C0442f1.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
        throw null;
    }

    public C0442f1(AbstractC0757y0 y0Var) {
        this.f401c = y0Var;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.f399a = true;
        this.f400b = j;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f399a) {
            this.f401c.tryAdvance((LongConsumer) this);
        }
        return this.f399a;
    }

    @Override // p004j$.util.AbstractC0472n0
    public final long nextLong() {
        if (this.f399a || hasNext()) {
            this.f399a = false;
            return this.f400b;
        }
        throw new NoSuchElementException();
    }
}
