package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0487s0;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.s8 */
/* loaded from: classes2.dex */
public final class C0677s8 extends AbstractC0717w8 implements DoubleConsumer, AbstractC0487s0 {

    /* renamed from: e */
    public double f754e;

    /* renamed from: f */
    public final /* synthetic */ int f755f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0677s8(Spliterator spliterator, int i) {
        super(spliterator);
        this.f755f = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0677s8(Spliterator spliterator, AbstractC0717w8 w8Var, int i) {
        super(spliterator, w8Var);
        this.f755f = i;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0717w8, p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m524k(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m564A(this, consumer);
    }

    @Override // p004j$.util.AbstractC0487s0
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        do {
        } while (tryAdvance(doubleConsumer));
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f814d = (this.f814d + 1) & 63;
        this.f754e = d;
    }

    @Override // p004j$.util.stream.AbstractC0717w8
    /* renamed from: b */
    public final Spliterator mo72b(Spliterator spliterator) {
        switch (this.f755f) {
            case 0:
                return new C0677s8((AbstractC0487s0) spliterator, this, 0);
            default:
                return new C0677s8((AbstractC0487s0) spliterator, this, 1);
        }
    }

    @Override // p004j$.util.AbstractC0487s0
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        switch (this.f755f) {
            case 0:
                boolean z = this.f813c;
                Spliterator spliterator = this.f811a;
                if (!z) {
                    return ((AbstractC0487s0) spliterator).tryAdvance(doubleConsumer);
                }
                this.f813c = false;
                boolean tryAdvance = ((AbstractC0487s0) spliterator).tryAdvance((DoubleConsumer) this);
                if (tryAdvance && m73a()) {
                    DoublePredicate doublePredicate = null;
                    doublePredicate.test(this.f754e);
                    throw null;
                } else if (!tryAdvance) {
                    return tryAdvance;
                } else {
                    doubleConsumer.accept(this.f754e);
                    return tryAdvance;
                }
            default:
                if (!this.f813c || !m73a() || !((AbstractC0487s0) this.f811a).tryAdvance((DoubleConsumer) this)) {
                    this.f813c = false;
                    return false;
                }
                DoublePredicate doublePredicate2 = null;
                doublePredicate2.test(this.f754e);
                throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0717w8, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public AbstractC0487s0 mo899trySplit() {
        switch (this.f755f) {
            case 1:
                if (this.f812b.get()) {
                    return null;
                }
                return (AbstractC0487s0) super.mo899trySplit();
            default:
                return super.mo899trySplit();
        }
    }

    @Override // p004j$.util.AbstractC0405b1
    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f755f) {
            case 1:
                tryAdvance((DoubleConsumer) obj);
                return false;
            default:
                return tryAdvance((DoubleConsumer) obj);
        }
    }
}
