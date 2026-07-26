package p004j$.util.stream;

import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.w7 */
/* loaded from: classes2.dex */
public abstract class AbstractC0716w7 extends AbstractC0745z7 implements AbstractC0405b1 {
    /* renamed from: g */
    public abstract void mo75g(Object obj);

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    /* renamed from: j */
    public abstract AbstractC0526d7 mo74j(int i);

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        while (m15f() != EnumC0736y7.NO_MORE && ((AbstractC0405b1) this.f871a).tryAdvance(this)) {
            if (m17a(1L) == 1) {
                mo75g(obj);
                return true;
            }
        }
        return false;
    }

    @Override // p004j$.util.AbstractC0405b1
    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        AbstractC0526d7 d7Var = null;
        while (true) {
            EnumC0736y7 f = m15f();
            if (f != EnumC0736y7.NO_MORE) {
                EnumC0736y7 y7Var = EnumC0736y7.MAYBE_MORE;
                Spliterator spliterator = this.f871a;
                if (f == y7Var) {
                    int i = this.f873c;
                    if (d7Var == null) {
                        d7Var = mo74j(i);
                    } else {
                        d7Var.f538b = 0;
                    }
                    long j = 0;
                    while (((AbstractC0405b1) spliterator).tryAdvance(d7Var)) {
                        j++;
                        if (j >= i) {
                            break;
                        }
                    }
                    if (j != 0) {
                        d7Var.mo211a(obj, m17a(j));
                    } else {
                        return;
                    }
                } else {
                    ((AbstractC0405b1) spliterator).forEachRemaining(obj);
                    return;
                }
            } else {
                return;
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
