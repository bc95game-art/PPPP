package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0401a0;
/* renamed from: j$.util.stream.l4 */
/* loaded from: classes2.dex */
public final class C0603l4 implements AbstractC0643p4, AbstractC0574i5 {

    /* renamed from: a */
    public boolean f640a;

    /* renamed from: b */
    public int f641b;

    /* renamed from: c */
    public final /* synthetic */ IntBinaryOperator f642c;

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo162d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0574i5
    /* renamed from: d */
    public final /* synthetic */ void mo162d(Integer num) {
        AbstractC0692u3.m139G(this, num);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    public C0603l4(IntBinaryOperator intBinaryOperator) {
        this.f642c = intBinaryOperator;
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        C0603l4 l4Var = (C0603l4) p4Var;
        if (!l4Var.f640a) {
            accept(l4Var.f641b);
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f640a = true;
        this.f641b = 0;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        if (this.f640a) {
            this.f640a = false;
            this.f641b = i;
            return;
        }
        this.f641b = this.f642c.applyAsInt(this.f641b, i);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f640a ? C0401a0.f300c : new C0401a0(this.f641b);
    }
}
