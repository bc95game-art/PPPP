package p004j$.util.stream;

import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0401a0;
/* renamed from: j$.util.stream.f0 */
/* loaded from: classes2.dex */
public final class C0539f0 extends AbstractC0569i0 implements AbstractC0574i5 {

    /* renamed from: c */
    public static final C0509c0 f548c;

    /* renamed from: d */
    public static final C0509c0 f549d;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0569i0, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        m197n(Integer.valueOf(i));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f592a) {
            return new C0401a0(((Integer) this.f593b).intValue());
        }
        return null;
    }

    static {
        EnumC0735y6 y6Var = EnumC0735y6.INT_VALUE;
        C0529e0 e0Var = new C0529e0(0);
        C0529e0 e0Var2 = new C0529e0(1);
        C0401a0 a0Var = C0401a0.f300c;
        f548c = new C0509c0(true, y6Var, a0Var, e0Var, e0Var2);
        f549d = new C0509c0(false, y6Var, a0Var, new C0529e0(0), new C0529e0(1));
    }
}
