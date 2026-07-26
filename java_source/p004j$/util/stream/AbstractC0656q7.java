package p004j$.util.stream;

import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.q7 */
/* loaded from: classes2.dex */
public abstract class AbstractC0656q7 extends AbstractC0676s7 implements AbstractC0405b1 {
    /* renamed from: b */
    public abstract Object mo164b();

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

    public AbstractC0656q7(AbstractC0405b1 b1Var, long j, long j2) {
        super(b1Var, j, j2, 0L, Math.min(b1Var.estimateSize(), j2));
    }

    @Override // p004j$.util.AbstractC0405b1
    public final boolean tryAdvance(Object obj) {
        long j;
        Objects.requireNonNull(obj);
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
            ((AbstractC0405b1) this.f751c).tryAdvance(mo164b());
            this.f752d++;
        }
        if (j >= this.f753e) {
            return false;
        }
        this.f752d = j + 1;
        return ((AbstractC0405b1) this.f751c).tryAdvance(obj);
    }

    @Override // p004j$.util.AbstractC0405b1
    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        long j = this.f753e;
        long j2 = this.f749a;
        if (j2 < j) {
            long j3 = this.f752d;
            if (j3 < j) {
                if (j3 < j2 || ((AbstractC0405b1) this.f751c).estimateSize() + j3 > this.f750b) {
                    while (j2 > this.f752d) {
                        ((AbstractC0405b1) this.f751c).tryAdvance(mo164b());
                        this.f752d++;
                    }
                    while (this.f752d < this.f753e) {
                        ((AbstractC0405b1) this.f751c).tryAdvance(obj);
                        this.f752d++;
                    }
                    return;
                }
                ((AbstractC0405b1) this.f751c).forEachRemaining(obj);
                this.f752d = this.f753e;
            }
        }
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }
}
