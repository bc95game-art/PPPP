package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0757y0;
import p004j$.util.Spliterator;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.u8 */
/* loaded from: classes2.dex */
public final class C0697u8 extends AbstractC0717w8 implements LongConsumer, AbstractC0757y0 {

    /* renamed from: e */
    public long f790e;

    /* renamed from: f */
    public final /* synthetic */ int f791f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0697u8(Spliterator spliterator, int i) {
        super(spliterator);
        this.f791f = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0697u8(Spliterator spliterator, AbstractC0717w8 w8Var, int i) {
        super(spliterator, w8Var);
        this.f791f = i;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0717w8, p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m522m(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m562C(this, consumer);
    }

    @Override // p004j$.util.AbstractC0757y0
    public final void forEachRemaining(LongConsumer longConsumer) {
        do {
        } while (tryAdvance(longConsumer));
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.f814d = (this.f814d + 1) & 63;
        this.f790e = j;
    }

    @Override // p004j$.util.stream.AbstractC0717w8
    /* renamed from: b */
    public final Spliterator mo72b(Spliterator spliterator) {
        switch (this.f791f) {
            case 0:
                return new C0697u8((AbstractC0757y0) spliterator, this, 0);
            default:
                return new C0697u8((AbstractC0757y0) spliterator, this, 1);
        }
    }

    @Override // p004j$.util.AbstractC0757y0
    public final boolean tryAdvance(LongConsumer longConsumer) {
        switch (this.f791f) {
            case 0:
                boolean z = this.f813c;
                Spliterator spliterator = this.f811a;
                if (!z) {
                    return ((AbstractC0757y0) spliterator).tryAdvance(longConsumer);
                }
                this.f813c = false;
                boolean tryAdvance = ((AbstractC0757y0) spliterator).tryAdvance((LongConsumer) this);
                if (tryAdvance && m73a()) {
                    LongPredicate longPredicate = null;
                    longPredicate.test(this.f790e);
                    throw null;
                } else if (!tryAdvance) {
                    return tryAdvance;
                } else {
                    longConsumer.accept(this.f790e);
                    return tryAdvance;
                }
            default:
                if (!this.f813c || !m73a() || !((AbstractC0757y0) this.f811a).tryAdvance((LongConsumer) this)) {
                    this.f813c = false;
                    return false;
                }
                LongPredicate longPredicate2 = null;
                longPredicate2.test(this.f790e);
                throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0717w8, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public AbstractC0757y0 mo899trySplit() {
        switch (this.f791f) {
            case 1:
                if (this.f812b.get()) {
                    return null;
                }
                return (AbstractC0757y0) super.mo899trySplit();
            default:
                return super.mo899trySplit();
        }
    }

    @Override // p004j$.util.AbstractC0405b1
    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f791f) {
            case 1:
                tryAdvance((LongConsumer) obj);
                return false;
            default:
                return tryAdvance((LongConsumer) obj);
        }
    }
}
