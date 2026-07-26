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
/* renamed from: j$.time.v */
/* loaded from: classes2.dex */
public final class C0386v implements AbstractC0376m, AbstractC0378o, Comparable, Serializable {

    /* renamed from: b */
    public static final /* synthetic */ int f244b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a */
    public final int f245a;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f245a - ((C0386v) obj).f245a;
    }

    static {
        C0341o oVar = new C0341o();
        oVar.m415h(EnumC0364a.YEAR, 4, 10, EnumC0348v.EXCEEDS_PAD);
        oVar.m411l(Locale.getDefault(), EnumC0347u.SMART, null);
    }

    /* renamed from: C */
    public static C0386v m323C(int i) {
        EnumC0364a.YEAR.m344s(i);
        return new C0386v(i);
    }

    public C0386v(int i) {
        this.f245a = i;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? qVar == EnumC0364a.YEAR || qVar == EnumC0364a.YEAR_OF_ERA || qVar == EnumC0364a.ERA : qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (qVar != EnumC0364a.YEAR_OF_ERA) {
            return AbstractC0381r.m331d(this, qVar);
        }
        return C0384u.m325e(1L, this.f245a <= 0 ? 1000000000L : 999999999L);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        return mo296k(qVar).m329a(mo293w(qVar), qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        int i = AbstractC0385u.f242a[((EnumC0364a) qVar).ordinal()];
        int i2 = 1;
        if (i == 1) {
            int i3 = this.f245a;
            if (i3 < 1) {
                i3 = 1 - i3;
            }
            return i3;
        } else if (i == 2) {
            return this.f245a;
        } else {
            if (i == 3) {
                if (this.f245a < 1) {
                    i2 = 0;
                }
                return i2;
            }
            throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: F */
    public final C0386v mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0386v) qVar.mo335o(this, j);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        aVar.m344s(j);
        int i = AbstractC0385u.f242a[aVar.ordinal()];
        if (i == 1) {
            if (this.f245a < 1) {
                j = 1 - j;
            }
            return m323C((int) j);
        } else if (i == 2) {
            return m323C((int) j);
        } else {
            if (i == 3) {
                return mo293w(EnumC0364a.ERA) == j ? this : m323C(1 - this.f245a);
            }
            throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: D */
    public final C0386v mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return (C0386v) sVar.mo330i(this, j);
        }
        int i = AbstractC0385u.f243b[((EnumC0365b) sVar).ordinal()];
        if (i == 1) {
            return m321E(j);
        }
        if (i == 2) {
            return m321E(AbstractC0279a.m548Q(j, 10));
        }
        if (i == 3) {
            return m321E(AbstractC0279a.m548Q(j, 100));
        }
        if (i == 4) {
            return m321E(AbstractC0279a.m548Q(j, 1000));
        }
        if (i == 5) {
            EnumC0364a aVar = EnumC0364a.ERA;
            return mo313c(AbstractC0279a.m547R(mo293w(aVar), j), aVar);
        }
        throw new RuntimeException("Unsupported unit: " + sVar);
    }

    /* renamed from: E */
    public final C0386v m321E(long j) {
        if (j == 0) {
            return this;
        }
        EnumC0364a aVar = EnumC0364a.YEAR;
        return m323C(aVar.f213b.m329a(this.f245a + j, aVar));
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
            return EnumC0365b.YEARS;
        }
        return AbstractC0381r.m332c(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        if (AbstractC0279a.m550O(mVar).equals(C0317t.f100c)) {
            return mVar.mo313c(this.f245a, EnumC0364a.YEAR);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0386v) && this.f245a == ((C0386v) obj).f245a;
    }

    public final int hashCode() {
        return this.f245a;
    }

    public final String toString() {
        return Integer.toString(this.f245a);
    }

    private Object writeReplace() {
        return new C0363t((byte) 11, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0386v) AbstractC0279a.m538a(gVar, this);
    }
}
