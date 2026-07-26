package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.g5 */
/* loaded from: classes2.dex */
public abstract class AbstractC0554g5 implements AbstractC0594k5 {

    /* renamed from: a */
    public final AbstractC0594k5 f566a;

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

    public AbstractC0554g5(AbstractC0594k5 k5Var) {
        this.f566a = (AbstractC0594k5) Objects.requireNonNull(k5Var);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public void mo23c(long j) {
        this.f566a.mo23c(j);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public void end() {
        this.f566a.end();
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public boolean mo27e() {
        return this.f566a.mo27e();
    }
}
