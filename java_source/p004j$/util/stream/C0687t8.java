package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0751v0;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.t8 */
/* loaded from: classes2.dex */
public final class C0687t8 extends AbstractC0717w8 implements IntConsumer, AbstractC0751v0 {

    /* renamed from: e */
    public int f769e;

    /* renamed from: f */
    public final /* synthetic */ int f770f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0687t8(Spliterator spliterator, int i) {
        super(spliterator);
        this.f770f = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0687t8(Spliterator spliterator, AbstractC0717w8 w8Var, int i) {
        super(spliterator, w8Var);
        this.f770f = i;
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0717w8, p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m523l(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m563B(this, consumer);
    }

    @Override // p004j$.util.AbstractC0751v0
    public final void forEachRemaining(IntConsumer intConsumer) {
        do {
        } while (tryAdvance(intConsumer));
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        this.f814d = (this.f814d + 1) & 63;
        this.f769e = i;
    }

    @Override // p004j$.util.stream.AbstractC0717w8
    /* renamed from: b */
    public final Spliterator mo72b(Spliterator spliterator) {
        switch (this.f770f) {
            case 0:
                return new C0687t8((AbstractC0751v0) spliterator, this, 0);
            default:
                return new C0687t8((AbstractC0751v0) spliterator, this, 1);
        }
    }

    @Override // p004j$.util.AbstractC0751v0
    public final boolean tryAdvance(IntConsumer intConsumer) {
        switch (this.f770f) {
            case 0:
                boolean z = this.f813c;
                Spliterator spliterator = this.f811a;
                if (!z) {
                    return ((AbstractC0751v0) spliterator).tryAdvance(intConsumer);
                }
                this.f813c = false;
                boolean tryAdvance = ((AbstractC0751v0) spliterator).tryAdvance((IntConsumer) this);
                if (tryAdvance && m73a()) {
                    IntPredicate intPredicate = null;
                    intPredicate.test(this.f769e);
                    throw null;
                } else if (!tryAdvance) {
                    return tryAdvance;
                } else {
                    intConsumer.accept(this.f769e);
                    return tryAdvance;
                }
            default:
                if (!this.f813c || !m73a() || !((AbstractC0751v0) this.f811a).tryAdvance((IntConsumer) this)) {
                    this.f813c = false;
                    return false;
                }
                IntPredicate intPredicate2 = null;
                intPredicate2.test(this.f769e);
                throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0717w8, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public AbstractC0751v0 mo899trySplit() {
        switch (this.f770f) {
            case 1:
                if (this.f812b.get()) {
                    return null;
                }
                return (AbstractC0751v0) super.mo899trySplit();
            default:
                return super.mo899trySplit();
        }
    }

    @Override // p004j$.util.AbstractC0405b1
    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f770f) {
            case 1:
                tryAdvance((IntConsumer) obj);
                return false;
            default:
                return tryAdvance((IntConsumer) obj);
        }
    }
}
