package p004j$.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.g1 */
/* loaded from: classes2.dex */
public final class C0452g1 implements AbstractC0441f0, DoubleConsumer, AbstractC0752w {

    /* renamed from: a */
    public boolean f420a = false;

    /* renamed from: b */
    public double f421b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC0487s0 f422c;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // p004j$.util.AbstractC0441f0
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        while (hasNext()) {
            doubleConsumer.accept(nextDouble());
        }
    }

    @Override // p004j$.util.AbstractC0441f0, java.util.Iterator
    public final Double next() {
        if (!AbstractC0485r1.f472a) {
            return Double.valueOf(nextDouble());
        }
        AbstractC0485r1.m227a(C0452g1.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
        throw null;
    }

    @Override // p004j$.util.AbstractC0441f0, java.util.Iterator, p004j$.util.AbstractC0752w
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            forEachRemaining((DoubleConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((DoubleConsumer) new C0407c0(consumer, 0));
            return;
        }
        AbstractC0485r1.m227a(C0452g1.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
        throw null;
    }

    public C0452g1(AbstractC0487s0 s0Var) {
        this.f422c = s0Var;
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f420a = true;
        this.f421b = d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f420a) {
            this.f422c.tryAdvance((DoubleConsumer) this);
        }
        return this.f420a;
    }

    @Override // p004j$.util.AbstractC0441f0
    public final double nextDouble() {
        if (this.f420a || hasNext()) {
            this.f420a = false;
            return this.f421b;
        }
        throw new NoSuchElementException();
    }
}
