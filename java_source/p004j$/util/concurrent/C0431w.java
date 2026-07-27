package p004j$.util.concurrent;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0487s0;
/* renamed from: j$.util.concurrent.w */
/* loaded from: classes2.dex */
public final class C0431w implements AbstractC0487s0 {

    /* renamed from: a */
    public long f375a;

    /* renamed from: b */
    public final long f376b;

    /* renamed from: c */
    public final double f377c;

    /* renamed from: d */
    public final double f378d;

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m524k(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m564A(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public C0431w(long j, long j2, double d, double d2) {
        this.f375a = j;
        this.f376b = j2;
        this.f377c = d;
        this.f378d = d2;
    }

    /* renamed from: a */
    public final C0431w mo899trySplit() {
        long j = this.f375a;
        long j2 = (this.f376b + j) >>> 1;
        if (j2 <= j) {
            return null;
        }
        this.f375a = j2;
        return new C0431w(j, j2, this.f377c, this.f378d);
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f376b - this.f375a;
    }

    @Override // p004j$.util.AbstractC0487s0
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j = this.f375a;
        if (j >= this.f376b) {
            return false;
        }
        doubleConsumer.accept(ThreadLocalRandom.current().m256a(this.f377c, this.f378d));
        this.f375a = j + 1;
        return true;
    }

    @Override // p004j$.util.AbstractC0487s0
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j = this.f375a;
        long j2 = this.f376b;
        if (j < j2) {
            this.f375a = j2;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                doubleConsumer.accept(current.m256a(this.f377c, this.f378d));
                j++;
            } while (j < j2);
        }
    }
}
