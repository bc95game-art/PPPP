package p004j$.util.stream;

import java.util.function.Supplier;
/* renamed from: j$.util.stream.l1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0600l1 implements Supplier {

    /* renamed from: a */
    public final /* synthetic */ int f635a;

    /* renamed from: b */
    public final /* synthetic */ EnumC0660r1 f636b;

    public /* synthetic */ C0600l1(EnumC0660r1 r1Var, int i) {
        this.f635a = i;
        this.f636b = r1Var;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f635a) {
            case 0:
                return new AbstractC0650q1(this.f636b);
            case 1:
                return new AbstractC0650q1(this.f636b);
            default:
                return new AbstractC0650q1(this.f636b);
        }
    }
}
