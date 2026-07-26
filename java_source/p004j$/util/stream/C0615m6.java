package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.AbstractC0487s0;
import p004j$.util.C0458i1;
import p004j$.util.Objects;
import p004j$.util.Spliterators;
/* renamed from: j$.util.stream.m6 */
/* loaded from: classes2.dex */
public final class C0615m6 extends AbstractC0675s6 implements AbstractC0487s0 {

    /* renamed from: g */
    public final /* synthetic */ C0625n6 f663g;

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m524k(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m564A(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: a */
    public final void mo159a(int i, Object obj, Object obj2) {
        ((DoubleConsumer) obj2).accept(((double[]) obj)[i]);
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: b */
    public final AbstractC0405b1 mo158b(Object obj, int i, int i2) {
        double[] dArr = (double[]) obj;
        int i3 = i2 + i;
        Spliterators.m276a(((double[]) Objects.requireNonNull(dArr)).length, i, i3);
        return new C0458i1(dArr, i, i3, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0615m6(C0625n6 n6Var, int i, int i2, int i3, int i4) {
        super(n6Var, i, i2, i3, i4);
        this.f663g = n6Var;
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: c */
    public final AbstractC0405b1 mo157c(int i, int i2, int i3, int i4) {
        return new C0615m6(this.f663g, i, i2, i3, i4);
    }
}
