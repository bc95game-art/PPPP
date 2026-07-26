package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
/* renamed from: j$.util.stream.z3 */
/* loaded from: classes2.dex */
public final class C0741z3 extends AbstractC0692u3 {

    /* renamed from: h */
    public final /* synthetic */ int f857h;

    /* renamed from: i */
    public final /* synthetic */ Object f858i;

    /* renamed from: j */
    public final /* synthetic */ Object f859j;

    /* renamed from: k */
    public final /* synthetic */ Object f860k;

    public /* synthetic */ C0741z3(EnumC0735y6 y6Var, Object obj, Object obj2, Object obj3, int i) {
        this.f857h = i;
        this.f859j = obj;
        this.f860k = obj2;
        this.f858i = obj3;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: D0 */
    public final AbstractC0643p4 mo26D0() {
        switch (this.f857h) {
            case 0:
                return new C0712w3((Supplier) this.f858i, (ObjLongConsumer) this.f860k, (C0618n) this.f859j);
            case 1:
                return new C0513c4((Supplier) this.f858i, (ObjDoubleConsumer) this.f860k, (C0618n) this.f859j);
            case 2:
                return new C0533e4(this.f858i, (BiFunction) this.f860k, (BinaryOperator) this.f859j);
            case 3:
                return new C0573i4((Supplier) this.f858i, (BiConsumer) this.f860k, (BiConsumer) this.f859j);
            default:
                return new C0613m4((Supplier) this.f858i, (ObjIntConsumer) this.f860k, (C0618n) this.f859j);
        }
    }
}
