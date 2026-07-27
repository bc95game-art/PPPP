package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0404b0;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.o4 */
/* loaded from: classes2.dex */
public final class C0633o4 implements AbstractC0643p4, AbstractC0584j5 {

    /* renamed from: a */
    public boolean f679a;

    /* renamed from: b */
    public long f680b;

    /* renamed from: c */
    public final /* synthetic */ LongBinaryOperator f681c;

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo78l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    @Override // p004j$.util.stream.AbstractC0584j5
    /* renamed from: l */
    public final /* synthetic */ void mo78l(Long l) {
        AbstractC0692u3.m136I(this, l);
    }

    public C0633o4(LongBinaryOperator longBinaryOperator) {
        this.f681c = longBinaryOperator;
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        C0633o4 o4Var = (C0633o4) p4Var;
        if (!o4Var.f679a) {
            accept(o4Var.f680b);
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f679a = true;
        this.f680b = 0L;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        if (this.f679a) {
            this.f679a = false;
            this.f680b = j;
            return;
        }
        this.f680b = this.f681c.applyAsLong(this.f680b, j);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f679a ? C0404b0.f304c : new C0404b0(this.f680b);
    }
}
