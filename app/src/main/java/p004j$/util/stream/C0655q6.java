package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0479p1;
import p004j$.util.Objects;
import p004j$.util.Spliterators;
/* renamed from: j$.util.stream.q6 */
/* loaded from: classes2.dex */
public final class C0655q6 extends AbstractC0675s6 implements AbstractC0757y0 {

    /* renamed from: g */
    public final /* synthetic */ C0665r6 f712g;

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m522m(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m562C(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: a */
    public final void mo159a(int i, Object obj, Object obj2) {
        ((LongConsumer) obj2).accept(((long[]) obj)[i]);
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: b */
    public final AbstractC0405b1 mo158b(Object obj, int i, int i2) {
        long[] jArr = (long[]) obj;
        int i3 = i2 + i;
        Spliterators.m276a(((long[]) Objects.requireNonNull(jArr)).length, i, i3);
        return new C0479p1(jArr, i, i3, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0655q6(C0665r6 r6Var, int i, int i2, int i3, int i4) {
        super(r6Var, i, i2, i3, i4);
        this.f712g = r6Var;
    }

    @Override // p004j$.util.stream.AbstractC0675s6
    /* renamed from: c */
    public final AbstractC0405b1 mo157c(int i, int i2, int i3, int i4) {
        return new C0655q6(this.f712g, i, i2, i3, i4);
    }
}
