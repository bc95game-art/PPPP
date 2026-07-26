package p004j$.util.stream;

import java.util.concurrent.atomic.AtomicLong;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.z7 */
/* loaded from: classes2.dex */
public abstract class AbstractC0745z7 {

    /* renamed from: a */
    public final Spliterator f871a;

    /* renamed from: b */
    public final boolean f872b;

    /* renamed from: c */
    public final int f873c;

    /* renamed from: d */
    public final long f874d;

    /* renamed from: e */
    public final AtomicLong f875e;

    /* renamed from: b */
    public abstract Spliterator mo16b(Spliterator spliterator);

    public AbstractC0745z7(Spliterator spliterator, long j, long j2) {
        this.f871a = spliterator;
        long j3 = 0;
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        this.f872b = i < 0;
        this.f874d = i >= 0 ? j2 : j3;
        this.f873c = 128;
        this.f875e = new AtomicLong(i >= 0 ? j + j2 : j);
    }

    public AbstractC0745z7(Spliterator spliterator, AbstractC0745z7 z7Var) {
        this.f871a = spliterator;
        this.f872b = z7Var.f872b;
        this.f875e = z7Var.f875e;
        this.f874d = z7Var.f874d;
        this.f873c = z7Var.f873c;
    }

    /* renamed from: a */
    public final long m17a(long j) {
        long j2;
        boolean z;
        long min;
        do {
            j2 = this.f875e.get();
            z = this.f872b;
            if (j2 != 0) {
                min = Math.min(j2, j);
                if (min <= 0) {
                    break;
                }
            } else if (z) {
                return j;
            } else {
                return 0L;
            }
        } while (!this.f875e.compareAndSet(j2, j2 - min));
        if (z) {
            return Math.max(j - min, 0L);
        }
        long j3 = this.f874d;
        return j2 > j3 ? Math.max(min - (j2 - j3), 0L) : min;
    }

    /* renamed from: f */
    public final EnumC0736y7 m15f() {
        if (this.f875e.get() > 0) {
            return EnumC0736y7.MAYBE_MORE;
        }
        return this.f872b ? EnumC0736y7.UNLIMITED : EnumC0736y7.NO_MORE;
    }

    public final Spliterator trySplit() {
        Spliterator trySplit;
        if (this.f875e.get() == 0 || (trySplit = this.f871a.mo899trySplit()) == null) {
            return null;
        }
        return mo16b(trySplit);
    }

    public final long estimateSize() {
        return this.f871a.estimateSize();
    }

    public final int characteristics() {
        return this.f871a.characteristics() & (-16465);
    }
}
