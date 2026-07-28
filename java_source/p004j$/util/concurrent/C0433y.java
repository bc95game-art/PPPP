package p004j$.util.concurrent;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0757y0;
/* renamed from: j$.util.concurrent.y */
/* loaded from: classes2.dex */
public final class C0433y implements AbstractC0757y0 {

    /* renamed from: a */
    public long f383a;

    /* renamed from: b */
    public final long f384b;

    /* renamed from: c */
    public final long f385c;

    /* renamed from: d */
    public final long f386d;

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m522m(this, consumer);
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
        return AbstractC0279a.m562C(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public C0433y(long j, long j2, long j3, long j4) {
        this.f383a = j;
        this.f384b = j2;
        this.f385c = j3;
        this.f386d = j4;
    }

    /* renamed from: a */
    public final C0433y mo899trySplit() {
        long j = this.f383a;
        long j2 = (this.f384b + j) >>> 1;
        if (j2 <= j) {
            return null;
        }
        this.f383a = j2;
        return new C0433y(j, j2, this.f385c, this.f386d);
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f384b - this.f383a;
    }

    @Override // p004j$.util.AbstractC0757y0
    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j = this.f383a;
        if (j >= this.f384b) {
            return false;
        }
        longConsumer.accept(ThreadLocalRandom.current().m254c(this.f385c, this.f386d));
        this.f383a = j + 1;
        return true;
    }

    @Override // p004j$.util.AbstractC0757y0
    public final void forEachRemaining(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j = this.f383a;
        long j2 = this.f384b;
        if (j < j2) {
            this.f383a = j2;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                longConsumer.accept(current.m254c(this.f385c, this.f386d));
                j++;
            } while (j < j2);
        }
    }
}
