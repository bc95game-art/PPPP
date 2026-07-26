package p004j$.time.format;

import java.util.LinkedHashSet;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.AbstractC0389y;
import p004j$.time.C0350g;
import p004j$.time.C0354k;
import p004j$.time.C0390z;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.EnumC0364a;
import p004j$.util.C0471n;
import p004j$.util.C0748u;
import p004j$.util.C0750v;
import p004j$.util.C0754x;
import p004j$.util.C0758z;
import p004j$.util.function.AbstractC0449g;
import p004j$.util.stream.AbstractC0578j;
/* renamed from: j$.time.format.b */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0328b implements IntFunction, Supplier, BiConsumer, DoubleBinaryOperator, ObjDoubleConsumer, DoubleFunction, ToDoubleFunction, Predicate {

    /* renamed from: a */
    public final /* synthetic */ int f127a;

    public /* synthetic */ C0328b(int i) {
        this.f127a = i;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return AbstractC0449g.m233a(this, predicate);
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f127a) {
            case 13:
                return AbstractC0279a.m536b(this, biConsumer);
            case 14:
                return AbstractC0279a.m536b(this, biConsumer);
            case 15:
                return AbstractC0279a.m536b(this, biConsumer);
            case 16:
            case 17:
            case 18:
            default:
                return AbstractC0279a.m536b(this, biConsumer);
            case 19:
                return AbstractC0279a.m536b(this, biConsumer);
        }
    }

    @Override // java.util.function.DoubleFunction
    public Object apply(double d) {
        return Double.valueOf(d);
    }

    @Override // java.util.function.DoubleBinaryOperator
    public double applyAsDouble(double d, double d2) {
        switch (this.f127a) {
            case 16:
                return Math.min(d, d2);
            default:
                return Math.max(d, d2);
        }
    }

    /* renamed from: or */
    public /* synthetic */ Predicate m427or(Predicate predicate) {
        return AbstractC0449g.m231c(this, predicate);
    }

    public Predicate negate() {
        return new C0471n(1, this);
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        return ((C0758z) obj).f885a;
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.f127a) {
            case 9:
                return new C0748u();
            case 10:
                return new C0750v();
            case 11:
                return new C0754x();
            case 12:
                return new LinkedHashSet();
            case 17:
                return new double[4];
            case 26:
                return new double[3];
            default:
                return new Object();
        }
    }

    @Override // java.util.function.ToDoubleFunction
    public double applyAsDouble(Object obj) {
        return ((Double) obj).doubleValue();
    }

    @Override // java.util.function.ObjDoubleConsumer
    public void accept(Object obj, double d) {
        switch (this.f127a) {
            case 18:
                double[] dArr = (double[]) obj;
                dArr[2] = dArr[2] + 1.0d;
                AbstractC0578j.m192a(dArr, d);
                dArr[3] = dArr[3] + d;
                return;
            case 19:
            default:
                double[] dArr2 = (double[]) obj;
                AbstractC0578j.m192a(dArr2, d);
                dArr2[2] = dArr2[2] + d;
                return;
            case 20:
                ((C0748u) obj).accept(d);
                return;
        }
    }

    /* renamed from: a */
    public Object m428a(AbstractC0377n nVar) {
        switch (this.f127a) {
            case 0:
                AbstractC0389y yVar = (AbstractC0389y) nVar.mo295l(AbstractC0381r.f231a);
                if (yVar == null || (yVar instanceof C0390z)) {
                    return null;
                }
                return yVar;
            case 1:
                return (AbstractC0389y) nVar.mo295l(AbstractC0381r.f231a);
            case 2:
                return (AbstractC0310m) nVar.mo295l(AbstractC0381r.f232b);
            case 3:
                return (AbstractC0382s) nVar.mo295l(AbstractC0381r.f233c);
            case 4:
                EnumC0364a aVar = EnumC0364a.OFFSET_SECONDS;
                if (nVar.mo299e(aVar)) {
                    return C0390z.m303I(nVar.mo297i(aVar));
                }
                return null;
            case 5:
                AbstractC0389y yVar2 = (AbstractC0389y) nVar.mo295l(AbstractC0381r.f231a);
                return yVar2 != null ? yVar2 : (AbstractC0389y) nVar.mo295l(AbstractC0381r.f234d);
            case 6:
                EnumC0364a aVar2 = EnumC0364a.EPOCH_DAY;
                if (nVar.mo299e(aVar2)) {
                    return C0350g.m397L(nVar.mo293w(aVar2));
                }
                return null;
            default:
                EnumC0364a aVar3 = EnumC0364a.NANO_OF_DAY;
                if (nVar.mo299e(aVar3)) {
                    return C0354k.m365G(nVar.mo293w(aVar3));
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f127a) {
            case 1:
                return "ZoneId";
            case 2:
                return "Chronology";
            case 3:
                return "Precision";
            case 4:
                return "ZoneOffset";
            case 5:
                return "Zone";
            case 6:
                return "LocalDate";
            case 7:
                return "LocalTime";
            default:
                return super.toString();
        }
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.f127a) {
            case 13:
                ((LinkedHashSet) obj).add(obj2);
                return;
            case 14:
                ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                return;
            case 15:
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                AbstractC0578j.m192a(dArr, dArr2[0]);
                AbstractC0578j.m192a(dArr, dArr2[1]);
                dArr[2] = dArr[2] + dArr2[2];
                return;
            case 16:
            case 17:
            case 18:
            default:
                ((C0748u) obj).m13a((C0748u) obj2);
                return;
            case 19:
                double[] dArr3 = (double[]) obj;
                double[] dArr4 = (double[]) obj2;
                AbstractC0578j.m192a(dArr3, dArr4[0]);
                AbstractC0578j.m192a(dArr3, dArr4[1]);
                dArr3[2] = dArr3[2] + dArr4[2];
                dArr3[3] = dArr3[3] + dArr4[3];
                return;
        }
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        switch (this.f127a) {
            case 8:
                return new Object[i];
            default:
                return new Double[i];
        }
    }
}
