package p004j$.util.stream;

import java.util.Comparator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.r7 */
/* loaded from: classes2.dex */
public final class C0666r7 extends AbstractC0676s7 implements Spliterator {
    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public C0666r7(Spliterator spliterator, long j, long j2) {
        super(spliterator, j, j2, 0L, Math.min(spliterator.estimateSize(), j2));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.s7, j$.util.Spliterator] */
    @Override // p004j$.util.stream.AbstractC0676s7
    /* renamed from: a */
    public final Spliterator mo156a(Spliterator spliterator, long j, long j2, long j3, long j4) {
        return new AbstractC0676s7(spliterator, j, j2, j3, j4);
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        long j;
        Objects.requireNonNull(consumer);
        long j2 = this.f753e;
        long j3 = this.f749a;
        if (j3 >= j2) {
            return false;
        }
        while (true) {
            j = this.f752d;
            if (j3 <= j) {
                break;
            }
            this.f751c.tryAdvance(new C0541f2(12));
            this.f752d++;
        }
        if (j >= this.f753e) {
            return false;
        }
        this.f752d = j + 1;
        return this.f751c.tryAdvance(consumer);
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        long j = this.f753e;
        long j2 = this.f749a;
        if (j2 < j) {
            long j3 = this.f752d;
            if (j3 < j) {
                if (j3 < j2 || this.f751c.estimateSize() + j3 > this.f750b) {
                    while (j2 > this.f752d) {
                        this.f751c.tryAdvance(new C0541f2(13));
                        this.f752d++;
                    }
                    while (this.f752d < this.f753e) {
                        this.f751c.tryAdvance(consumer);
                        this.f752d++;
                    }
                    return;
                }
                this.f751c.forEachRemaining(consumer);
                this.f752d = this.f753e;
            }
        }
    }
}
