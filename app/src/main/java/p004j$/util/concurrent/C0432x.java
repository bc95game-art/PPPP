package p004j$.util.concurrent;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0751v0;
/* renamed from: j$.util.concurrent.x */
/* loaded from: classes2.dex */
public final class C0432x implements AbstractC0751v0 {

    /* renamed from: a */
    public long f379a;

    /* renamed from: b */
    public final long f380b;

    /* renamed from: c */
    public final int f381c;

    /* renamed from: d */
    public final int f382d;

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m523l(this, consumer);
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
        return AbstractC0279a.m563B(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public C0432x(long j, long j2, int i, int i2) {
        this.f379a = j;
        this.f380b = j2;
        this.f381c = i;
        this.f382d = i2;
    }

    /* renamed from: a */
    public final C0432x mo899trySplit() {
        long j = this.f379a;
        long j2 = (this.f380b + j) >>> 1;
        if (j2 <= j) {
            return null;
        }
        this.f379a = j2;
        return new C0432x(j, j2, this.f381c, this.f382d);
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f380b - this.f379a;
    }

    @Override // p004j$.util.AbstractC0751v0
    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j = this.f379a;
        if (j >= this.f380b) {
            return false;
        }
        intConsumer.accept(ThreadLocalRandom.current().m255b(this.f381c, this.f382d));
        this.f379a = j + 1;
        return true;
    }

    @Override // p004j$.util.AbstractC0751v0
    public final void forEachRemaining(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j = this.f379a;
        long j2 = this.f380b;
        if (j < j2) {
            this.f379a = j2;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                intConsumer.accept(current.m255b(this.f381c, this.f382d));
                j++;
            } while (j < j2);
        }
    }
}
