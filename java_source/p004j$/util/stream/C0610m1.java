package p004j$.util.stream;

import java.util.function.Predicate;
/* renamed from: j$.util.stream.m1 */
/* loaded from: classes2.dex */
public final class C0610m1 extends AbstractC0650q1 {

    /* renamed from: c */
    public final /* synthetic */ EnumC0660r1 f655c;

    /* renamed from: d */
    public final /* synthetic */ Predicate f656d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0610m1(EnumC0660r1 r1Var, Predicate predicate) {
        super(r1Var);
        this.f655c = r1Var;
        this.f656d = predicate;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (!this.f700a) {
            boolean test = this.f656d.test(obj);
            EnumC0660r1 r1Var = this.f655c;
            if (test == r1Var.f724a) {
                this.f700a = true;
                this.f701b = r1Var.f725b;
            }
        }
    }
}
