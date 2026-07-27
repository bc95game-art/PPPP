package p004j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0756y;
/* renamed from: j$.util.stream.f4 */
/* loaded from: classes2.dex */
public final class C0543f4 implements AbstractC0643p4 {

    /* renamed from: a */
    public boolean f551a;

    /* renamed from: b */
    public Object f552b;

    /* renamed from: c */
    public final /* synthetic */ BinaryOperator f553c;

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

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    public C0543f4(BinaryOperator binaryOperator) {
        this.f553c = binaryOperator;
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        C0543f4 f4Var = (C0543f4) p4Var;
        if (!f4Var.f551a) {
            accept(f4Var.f552b);
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f551a = true;
        this.f552b = null;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (this.f551a) {
            this.f551a = false;
            this.f552b = obj;
            return;
        }
        this.f552b = this.f553c.apply(this.f552b, obj);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f551a ? C0756y.f882b : new C0756y(this.f552b);
    }
}
