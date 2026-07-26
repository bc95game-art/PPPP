package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.format.C0328b;
import p004j$.util.C0758z;
/* renamed from: j$.util.stream.d0 */
/* loaded from: classes2.dex */
public final class C0519d0 extends AbstractC0569i0 implements AbstractC0564h5 {

    /* renamed from: c */
    public static final C0509c0 f530c;

    /* renamed from: d */
    public static final C0509c0 f531d;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0569i0, p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        m197n(Double.valueOf(d));
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f592a) {
            return new C0758z(((Double) this.f593b).doubleValue());
        }
        return null;
    }

    static {
        EnumC0735y6 y6Var = EnumC0735y6.DOUBLE_VALUE;
        C0328b bVar = new C0328b(28);
        C0328b bVar2 = new C0328b(29);
        C0758z zVar = C0758z.f884c;
        f530c = new C0509c0(true, y6Var, zVar, bVar, bVar2);
        f531d = new C0509c0(false, y6Var, zVar, new C0328b(28), new C0328b(29));
    }
}
