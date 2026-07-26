package p004j$.util.stream;

import java.util.Deque;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p004j$.util.AbstractC0405b1;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.g3 */
/* loaded from: classes2.dex */
public abstract class AbstractC0552g3 extends AbstractC0572i3 implements AbstractC0405b1 {
    @Override // p004j$.util.AbstractC0405b1
    public final boolean tryAdvance(Object obj) {
        AbstractC0521d2 d2Var;
        if (!m193c()) {
            return false;
        }
        boolean tryAdvance = ((AbstractC0405b1) this.f600d).tryAdvance(obj);
        if (!tryAdvance) {
            if (this.f599c != null || (d2Var = (AbstractC0521d2) AbstractC0572i3.m195a(this.f601e)) == null) {
                this.f597a = null;
            } else {
                AbstractC0405b1 spliterator = d2Var.mo904spliterator();
                this.f600d = spliterator;
                return spliterator.tryAdvance(obj);
            }
        }
        return tryAdvance;
    }

    @Override // p004j$.util.AbstractC0405b1
    public final void forEachRemaining(Object obj) {
        if (this.f597a != null) {
            if (this.f600d == null) {
                Spliterator spliterator = this.f599c;
                if (spliterator == null) {
                    Deque b = m194b();
                    while (true) {
                        AbstractC0521d2 d2Var = (AbstractC0521d2) AbstractC0572i3.m195a(b);
                        if (d2Var != null) {
                            d2Var.mo153g(obj);
                        } else {
                            this.f597a = null;
                            return;
                        }
                    }
                } else {
                    ((AbstractC0405b1) spliterator).forEachRemaining(obj);
                }
            } else {
                do {
                } while (tryAdvance(obj));
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
