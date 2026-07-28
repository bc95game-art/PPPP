package p004j$.util.stream;

import java.util.function.LongConsumer;
import p004j$.util.C0404b0;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.g0 */
/* loaded from: classes2.dex */
public final class C0549g0 extends AbstractC0569i0 implements AbstractC0584j5 {

    /* renamed from: c */
    public static final C0509c0 f559c;

    /* renamed from: d */
    public static final C0509c0 f560d;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0569i0, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        m197n(Long.valueOf(j));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f592a) {
            return new C0404b0(((Long) this.f593b).longValue());
        }
        return null;
    }

    static {
        EnumC0735y6 y6Var = EnumC0735y6.LONG_VALUE;
        C0529e0 e0Var = new C0529e0(2);
        C0529e0 e0Var2 = new C0529e0(3);
        C0404b0 b0Var = C0404b0.f304c;
        f559c = new C0509c0(true, y6Var, b0Var, e0Var, e0Var2);
        f560d = new C0509c0(false, y6Var, b0Var, new C0529e0(2), new C0529e0(3));
    }
}
