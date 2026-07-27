package p004j$.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.e1 */
/* loaded from: classes2.dex */
public final class C0439e1 implements AbstractC0460j0, IntConsumer, AbstractC0752w {

    /* renamed from: a */
    public boolean f396a = false;

    /* renamed from: b */
    public int f397b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC0751v0 f398c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.AbstractC0460j0
    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        while (hasNext()) {
            intConsumer.accept(nextInt());
        }
    }

    @Override // p004j$.util.AbstractC0460j0, java.util.Iterator
    public final Integer next() {
        if (!AbstractC0485r1.f472a) {
            return Integer.valueOf(nextInt());
        }
        AbstractC0485r1.m227a(C0439e1.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
        throw null;
    }

    @Override // p004j$.util.AbstractC0460j0, java.util.Iterator, p004j$.util.AbstractC0752w
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            forEachRemaining((IntConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((IntConsumer) new C0451g0(consumer, 0));
            return;
        }
        AbstractC0485r1.m227a(C0439e1.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
        throw null;
    }

    public C0439e1(AbstractC0751v0 v0Var) {
        this.f398c = v0Var;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        this.f396a = true;
        this.f397b = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f396a) {
            this.f398c.tryAdvance((IntConsumer) this);
        }
        return this.f396a;
    }

    @Override // p004j$.util.AbstractC0460j0
    public final int nextInt() {
        if (this.f396a || hasNext()) {
            this.f396a = false;
            return this.f397b;
        }
        throw new NoSuchElementException();
    }
}
