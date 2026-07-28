package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.q1 */
/* loaded from: classes2.dex */
public abstract class AbstractC0650q1 implements AbstractC0594k5 {

    /* renamed from: a */
    public boolean f700a;

    /* renamed from: b */
    public boolean f701b;

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final /* synthetic */ void mo23c(long j) {
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    public AbstractC0650q1(EnumC0660r1 r1Var) {
        this.f701b = !r1Var.f725b;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return this.f700a;
    }
}
