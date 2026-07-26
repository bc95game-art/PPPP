package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntFunction;
import p004j$.util.AbstractC0405b1;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.m2 */
/* loaded from: classes2.dex */
public final class C0611m2 extends AbstractC0641p2 implements AbstractC0730y1 {
    @Override // p004j$.util.stream.AbstractC0531e2
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0692u3.m128Q(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m125T(this, j, j2);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: k */
    public final /* synthetic */ void mo70k(Object[] objArr, int i) {
        AbstractC0692u3.m131N(this, (Double[]) objArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    public final Object newArray(int i) {
        return new double[i];
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator */
    public final Spliterator mo904spliterator() {
        return new AbstractC0572i3(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.b1, j$.util.stream.i3] */
    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator  reason: collision with other method in class */
    public final AbstractC0405b1 mo904spliterator() {
        return new AbstractC0572i3(this);
    }
}
