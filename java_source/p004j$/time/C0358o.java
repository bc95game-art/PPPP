package p004j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.chrono.C0317t;
import p004j$.time.format.C0328b;
import p004j$.time.format.C0341o;
import p004j$.time.format.EnumC0347u;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.o */
/* loaded from: classes2.dex */
public final class C0358o implements AbstractC0377n, AbstractC0378o, Comparable, Serializable {

    /* renamed from: c */
    public static final /* synthetic */ int f195c = 0;
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a */
    public final int f196a;

    /* renamed from: b */
    public final int f197b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0358o oVar = (C0358o) obj;
        int i = this.f196a - oVar.f196a;
        return i == 0 ? this.f197b - oVar.f197b : i;
    }

    static {
        C0341o oVar = new C0341o();
        oVar.m419d("--");
        oVar.m416g(EnumC0364a.MONTH_OF_YEAR, 2);
        oVar.m420c('-');
        oVar.m416g(EnumC0364a.DAY_OF_MONTH, 2);
        oVar.m411l(Locale.getDefault(), EnumC0347u.SMART, null);
    }

    public C0358o(int i, int i2) {
        this.f196a = i;
        this.f197b = i2;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? qVar == EnumC0364a.MONTH_OF_YEAR || qVar == EnumC0364a.DAY_OF_MONTH : qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.MONTH_OF_YEAR) {
            return qVar.mo337k();
        }
        if (qVar != EnumC0364a.DAY_OF_MONTH) {
            return AbstractC0381r.m331d(this, qVar);
        }
        EnumC0356m F = EnumC0356m.m350F(this.f196a);
        F.getClass();
        int i = AbstractC0355l.f191a[F.ordinal()];
        return C0384u.m324f(i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : 28, EnumC0356m.m350F(this.f196a).m351E());
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        return mo296k(qVar).m329a(mo293w(qVar), qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        int i;
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        int i2 = AbstractC0357n.f194a[((EnumC0364a) qVar).ordinal()];
        if (i2 == 1) {
            i = this.f197b;
        } else if (i2 == 2) {
            i = this.f196a;
        } else {
            throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
        return i;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f232b) {
            return C0317t.f100c;
        }
        return AbstractC0381r.m332c(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        if (AbstractC0279a.m550O(mVar).equals(C0317t.f100c)) {
            AbstractC0376m c = mVar.mo313c(this.f196a, EnumC0364a.MONTH_OF_YEAR);
            EnumC0364a aVar = EnumC0364a.DAY_OF_MONTH;
            return c.mo313c(Math.min(c.mo296k(aVar).f241d, this.f197b), aVar);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0358o) {
            C0358o oVar = (C0358o) obj;
            if (this.f196a == oVar.f196a && this.f197b == oVar.f197b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f196a << 6) + this.f197b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f196a < 10 ? "0" : "");
        sb.append(this.f196a);
        sb.append(this.f197b < 10 ? "-0" : "-");
        sb.append(this.f197b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new C0363t((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
