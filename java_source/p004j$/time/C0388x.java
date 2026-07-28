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
import p004j$.time.format.EnumC0348v;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.x */
/* loaded from: classes2.dex */
public final class C0388x implements AbstractC0376m, AbstractC0378o, Comparable, Serializable {

    /* renamed from: c */
    public static final /* synthetic */ int f248c = 0;
    private static final long serialVersionUID = 4183400860270640070L;

    /* renamed from: a */
    public final int f249a;

    /* renamed from: b */
    public final int f250b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0388x xVar = (C0388x) obj;
        int i = this.f249a - xVar.f249a;
        return i == 0 ? this.f250b - xVar.f250b : i;
    }

    static {
        C0341o oVar = new C0341o();
        oVar.m415h(EnumC0364a.YEAR, 4, 10, EnumC0348v.EXCEEDS_PAD);
        oVar.m420c('-');
        oVar.m416g(EnumC0364a.MONTH_OF_YEAR, 2);
        oVar.m411l(Locale.getDefault(), EnumC0347u.SMART, null);
    }

    public C0388x(int i, int i2) {
        this.f249a = i;
        this.f250b = i2;
    }

    /* renamed from: G */
    public final C0388x m315G(int i, int i2) {
        return (this.f249a == i && this.f250b == i2) ? this : new C0388x(i, i2);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? qVar == EnumC0364a.YEAR || qVar == EnumC0364a.MONTH_OF_YEAR || qVar == EnumC0364a.PROLEPTIC_MONTH || qVar == EnumC0364a.YEAR_OF_ERA || qVar == EnumC0364a.ERA : qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (qVar != EnumC0364a.YEAR_OF_ERA) {
            return AbstractC0381r.m331d(this, qVar);
        }
        return C0384u.m325e(1L, this.f249a <= 0 ? 1000000000L : 999999999L);
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
        int i2 = AbstractC0387w.f246a[((EnumC0364a) qVar).ordinal()];
        int i3 = 1;
        if (i2 == 1) {
            i = this.f250b;
        } else if (i2 == 2) {
            return m319C();
        } else {
            if (i2 == 3) {
                int i4 = this.f249a;
                if (i4 < 1) {
                    i4 = 1 - i4;
                }
                return i4;
            } else if (i2 == 4) {
                i = this.f249a;
            } else if (i2 == 5) {
                if (this.f249a < 1) {
                    i3 = 0;
                }
                return i3;
            } else {
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
            }
        }
        return i;
    }

    /* renamed from: C */
    public final long m319C() {
        return ((this.f249a * 12) + this.f250b) - 1;
    }

    /* renamed from: H */
    public final C0388x mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0388x) qVar.mo335o(this, j);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        aVar.m344s(j);
        int i = AbstractC0387w.f246a[aVar.ordinal()];
        if (i == 1) {
            int i2 = (int) j;
            EnumC0364a.MONTH_OF_YEAR.m344s(i2);
            return m315G(this.f249a, i2);
        } else if (i == 2) {
            return m317E(j - m319C());
        } else {
            if (i == 3) {
                if (this.f249a < 1) {
                    j = 1 - j;
                }
                int i3 = (int) j;
                EnumC0364a.YEAR.m344s(i3);
                return m315G(i3, this.f250b);
            } else if (i == 4) {
                int i4 = (int) j;
                EnumC0364a.YEAR.m344s(i4);
                return m315G(i4, this.f250b);
            } else if (i != 5) {
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
            } else if (mo293w(EnumC0364a.ERA) == j) {
                return this;
            } else {
                int i5 = 1 - this.f249a;
                EnumC0364a.YEAR.m344s(i5);
                return m315G(i5, this.f250b);
            }
        }
    }

    /* renamed from: D */
    public final C0388x mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return (C0388x) sVar.mo330i(this, j);
        }
        switch (AbstractC0387w.f247b[((EnumC0365b) sVar).ordinal()]) {
            case 1:
                return m317E(j);
            case 2:
                return m316F(j);
            case 3:
                return m316F(AbstractC0279a.m548Q(j, 10));
            case 4:
                return m316F(AbstractC0279a.m548Q(j, 100));
            case 5:
                return m316F(AbstractC0279a.m548Q(j, 1000));
            case 6:
                EnumC0364a aVar = EnumC0364a.ERA;
                return mo313c(AbstractC0279a.m547R(mo293w(aVar), j), aVar);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    /* renamed from: F */
    public final C0388x m316F(long j) {
        if (j == 0) {
            return this;
        }
        EnumC0364a aVar = EnumC0364a.YEAR;
        return m315G(aVar.f213b.m329a(this.f249a + j, aVar), this.f250b);
    }

    /* renamed from: E */
    public final C0388x m317E(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.f249a * 12) + (this.f250b - 1) + j;
        EnumC0364a aVar = EnumC0364a.YEAR;
        long j3 = 12;
        return m315G(aVar.f213b.m329a(AbstractC0279a.m543V(j2, j3), aVar), ((int) AbstractC0279a.m544U(j2, j3)) + 1);
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return j == Long.MIN_VALUE ? mo886d(Long.MAX_VALUE, bVar).mo886d(1L, bVar) : mo886d(-j, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f232b) {
            return C0317t.f100c;
        }
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.MONTHS;
        }
        return AbstractC0381r.m332c(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        if (AbstractC0279a.m550O(mVar).equals(C0317t.f100c)) {
            return mVar.mo313c(m319C(), EnumC0364a.PROLEPTIC_MONTH);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0388x) {
            C0388x xVar = (C0388x) obj;
            if (this.f249a == xVar.f249a && this.f250b == xVar.f250b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f249a ^ (this.f250b << 27);
    }

    public final String toString() {
        int abs = Math.abs(this.f249a);
        StringBuilder sb = new StringBuilder(9);
        if (abs < 1000) {
            int i = this.f249a;
            if (i < 0) {
                sb.append(i - 10000);
                sb.deleteCharAt(1);
            } else {
                sb.append(i + 10000);
                sb.deleteCharAt(0);
            }
        } else {
            sb.append(this.f249a);
        }
        sb.append(this.f250b < 10 ? "-0" : "-");
        sb.append(this.f250b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new C0363t((byte) 12, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0388x) AbstractC0279a.m538a(gVar, this);
    }
}
