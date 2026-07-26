package p004j$.time.chrono;

import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.AbstractC0283b;
import p004j$.time.C0354k;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.chrono.d */
/* loaded from: classes2.dex */
public abstract class AbstractC0293d implements AbstractC0289b, AbstractC0376m, AbstractC0378o, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: A */
    public final /* synthetic */ int compareTo(AbstractC0289b bVar) {
        return AbstractC0279a.m528g(this, bVar);
    }

    /* renamed from: F */
    public abstract AbstractC0289b mo442F(long j);

    /* renamed from: G */
    public abstract AbstractC0289b mo441G(long j);

    /* renamed from: H */
    public abstract AbstractC0289b mo440H(long j);

    @Override // p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public /* synthetic */ boolean mo299e(AbstractC0380q qVar) {
        return AbstractC0279a.m516s(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final /* synthetic */ int mo297i(AbstractC0380q qVar) {
        return AbstractC0381r.m334a(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public /* synthetic */ C0384u mo296k(AbstractC0380q qVar) {
        return AbstractC0381r.m331d(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final /* synthetic */ Object mo295l(C0328b bVar) {
        return AbstractC0279a.m514u(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final /* synthetic */ AbstractC0376m mo294o(AbstractC0376m mVar) {
        return AbstractC0279a.m538a(this, mVar);
    }

    /* renamed from: C */
    public static AbstractC0289b m487C(AbstractC0310m mVar, AbstractC0376m mVar2) {
        AbstractC0289b bVar = (AbstractC0289b) mVar2;
        if (mVar.equals(bVar.mo387a())) {
            return bVar;
        }
        String h = mVar.mo449h();
        String h2 = bVar.mo387a().mo449h();
        throw new ClassCastException("Chronology mismatch, expected: " + h + ", actual: " + h2);
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: y */
    public AbstractC0295e mo385y(C0354k kVar) {
        return new C0299g(this, kVar);
    }

    @Override // p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d */
    public AbstractC0289b mo886d(long j, AbstractC0382s sVar) {
        boolean z = sVar instanceof EnumC0365b;
        if (z) {
            switch (AbstractC0291c.f57a[((EnumC0365b) sVar).ordinal()]) {
                case 1:
                    return mo442F(j);
                case 2:
                    return mo442F(AbstractC0279a.m548Q(j, 7));
                case 3:
                    return mo441G(j);
                case 4:
                    return mo440H(j);
                case 5:
                    return mo440H(AbstractC0279a.m548Q(j, 10));
                case 6:
                    return mo440H(AbstractC0279a.m548Q(j, 100));
                case 7:
                    return mo440H(AbstractC0279a.m548Q(j, 1000));
                case 8:
                    EnumC0364a aVar = EnumC0364a.ERA;
                    return mo313c(AbstractC0279a.m547R(mo293w(aVar), j), (AbstractC0380q) aVar);
                default:
                    throw new RuntimeException("Unsupported unit: " + sVar);
            }
        } else if (!z) {
            return m487C(mo387a(), sVar.mo330i(this, j));
        } else {
            throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    /* renamed from: D */
    public AbstractC0311n mo444D() {
        return mo387a().mo446q(AbstractC0381r.m334a(this, EnumC0364a.ERA));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC0289b) && AbstractC0279a.m528g(this, (AbstractC0289b) obj) == 0;
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    public int hashCode() {
        long x = mo386x();
        return mo387a().hashCode() ^ ((int) (x ^ (x >>> 32)));
    }

    /* renamed from: I */
    public AbstractC0289b mo311j(AbstractC0378o oVar) {
        return m487C(mo387a(), oVar.mo294o(this));
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    public final String toString() {
        long w = mo293w(EnumC0364a.YEAR_OF_ERA);
        long w2 = mo293w(EnumC0364a.MONTH_OF_YEAR);
        long w3 = mo293w(EnumC0364a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(mo387a().toString());
        sb.append(" ");
        sb.append(mo444D());
        sb.append(" ");
        sb.append(w);
        String str = "-";
        sb.append(w2 < 10 ? "-0" : str);
        sb.append(w2);
        if (w3 < 10) {
            str = "-0";
        }
        sb.append(str);
        sb.append(w3);
        return sb.toString();
    }

    @Override // p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: c */
    public AbstractC0289b mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return m487C(mo387a(), qVar.mo335o(this, j));
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    /* renamed from: E */
    public AbstractC0289b mo310s(long j, AbstractC0382s sVar) {
        return m487C(mo387a(), AbstractC0381r.m333b(this, j, sVar));
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: x */
    public long mo386x() {
        return mo293w(EnumC0364a.EPOCH_DAY);
    }
}
