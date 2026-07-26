package p004j$.util.stream;

import p004j$.util.C0756y;
/* renamed from: j$.util.stream.h0 */
/* loaded from: classes2.dex */
public final class C0559h0 extends AbstractC0569i0 {

    /* renamed from: c */
    public static final C0509c0 f575c;

    /* renamed from: d */
    public static final C0509c0 f576d;

    @Override // java.util.function.Supplier
    public final Object get() {
        if (this.f592a) {
            return new C0756y(this.f593b);
        }
        return null;
    }

    static {
        EnumC0735y6 y6Var = EnumC0735y6.REFERENCE;
        C0529e0 e0Var = new C0529e0(4);
        C0529e0 e0Var2 = new C0529e0(5);
        C0756y yVar = C0756y.f882b;
        f575c = new C0509c0(true, y6Var, yVar, e0Var, e0Var2);
        f576d = new C0509c0(false, y6Var, yVar, new C0529e0(4), new C0529e0(5));
    }
}
