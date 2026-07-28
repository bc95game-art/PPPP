package p004j$.util.stream;

import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.s7 */
/* loaded from: classes2.dex */
public abstract class AbstractC0676s7 {

    /* renamed from: a */
    public final long f749a;

    /* renamed from: b */
    public final long f750b;

    /* renamed from: c */
    public Spliterator f751c;

    /* renamed from: d */
    public long f752d;

    /* renamed from: e */
    public long f753e;

    /* renamed from: a */
    public abstract Spliterator mo156a(Spliterator spliterator, long j, long j2, long j3, long j4);

    public AbstractC0676s7(Spliterator spliterator, long j, long j2, long j3, long j4) {
        this.f751c = spliterator;
        this.f749a = j;
        this.f750b = j2;
        this.f752d = j3;
        this.f753e = j4;
    }

    public final Spliterator trySplit() {
        long j = this.f753e;
        if (this.f749a >= j || this.f752d >= j) {
            return null;
        }
        while (true) {
            Spliterator trySplit = this.f751c.mo899trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.f752d;
            long min = Math.min(estimateSize, this.f750b);
            long j2 = this.f749a;
            if (j2 >= min) {
                this.f752d = min;
            } else {
                long j3 = this.f750b;
                if (min >= j3) {
                    this.f751c = trySplit;
                    this.f753e = min;
                } else {
                    long j4 = this.f752d;
                    if (j4 < j2 || estimateSize > j3) {
                        this.f752d = min;
                        return mo156a(trySplit, j2, j3, j4, min);
                    }
                    this.f752d = min;
                    return trySplit;
                }
            }
        }
    }

    public final long estimateSize() {
        long j = this.f753e;
        long j2 = this.f749a;
        if (j2 < j) {
            return j - Math.max(j2, this.f752d);
        }
        return 0L;
    }

    public final int characteristics() {
        return this.f751c.characteristics();
    }
}
