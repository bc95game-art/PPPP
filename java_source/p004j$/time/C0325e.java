package p004j$.time;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.format.C0327a;
import p004j$.time.format.C0328b;
import p004j$.time.format.C0332f;
import p004j$.time.format.C0343q;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
import p004j$.util.Objects;
/* renamed from: j$.time.e */
/* loaded from: classes2.dex */
public final class C0325e implements AbstractC0376m, AbstractC0378o, Comparable, Serializable {

    /* renamed from: c */
    public static final C0325e f117c = new C0325e(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a */
    public final long f118a;

    /* renamed from: b */
    public final int f119b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0325e eVar = (C0325e) obj;
        int compare = Long.compare(this.f118a, eVar.f118a);
        return compare != 0 ? compare : this.f119b - eVar.f119b;
    }

    static {
        m431D(-31557014167219200L, 0L);
        m431D(31556889864403199L, 999999999L);
    }

    /* renamed from: D */
    public static C0325e m431D(long j, long j2) {
        return m432C(AbstractC0279a.m547R(j, AbstractC0279a.m543V(j2, 1000000000L)), (int) AbstractC0279a.m544U(j2, 1000000000L));
    }

    /* renamed from: C */
    public static C0325e m432C(long j, int i) {
        if ((i | j) == 0) {
            return f117c;
        }
        if (j >= -31557014167219200L && j <= 31556889864403199L) {
            return new C0325e(j, i);
        }
        throw new RuntimeException("Instant exceeds minimum or maximum instant");
    }

    public C0325e(long j, int i) {
        this.f118a = j;
        this.f119b = i;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? qVar == EnumC0364a.INSTANT_SECONDS || qVar == EnumC0364a.NANO_OF_SECOND || qVar == EnumC0364a.MICRO_OF_SECOND || qVar == EnumC0364a.MILLI_OF_SECOND : qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        return AbstractC0381r.m331d(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return AbstractC0381r.m331d(this, qVar).m329a(qVar.mo336l(this), qVar);
        }
        int i = AbstractC0324d.f115a[((EnumC0364a) qVar).ordinal()];
        if (i == 1) {
            return this.f119b;
        }
        if (i == 2) {
            return this.f119b / 1000;
        }
        if (i == 3) {
            return this.f119b / 1000000;
        }
        if (i == 4) {
            EnumC0364a aVar = EnumC0364a.INSTANT_SECONDS;
            aVar.f213b.m329a(this.f118a, aVar);
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        int i;
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        int i2 = AbstractC0324d.f115a[((EnumC0364a) qVar).ordinal()];
        if (i2 == 1) {
            i = this.f119b;
        } else if (i2 == 2) {
            i = this.f119b / 1000;
        } else if (i2 == 3) {
            i = this.f119b / 1000000;
        } else if (i2 == 4) {
            return this.f118a;
        } else {
            throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
        return i;
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: c */
    public final AbstractC0376m mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0325e) qVar.mo335o(this, j);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        aVar.m344s(j);
        int i = AbstractC0324d.f115a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                int i2 = ((int) j) * 1000;
                if (i2 != this.f119b) {
                    return m432C(this.f118a, i2);
                }
            } else if (i == 3) {
                int i3 = ((int) j) * 1000000;
                if (i3 != this.f119b) {
                    return m432C(this.f118a, i3);
                }
            } else if (i != 4) {
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
            } else if (j != this.f118a) {
                return m432C(j, this.f119b);
            }
        } else if (j != this.f119b) {
            return m432C(this.f118a, (int) j);
        }
        return this;
    }

    /* renamed from: F */
    public final C0325e mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return (C0325e) sVar.mo330i(this, j);
        }
        switch (AbstractC0324d.f116b[((EnumC0365b) sVar).ordinal()]) {
            case 1:
                return m430E(0L, j);
            case 2:
                return m430E(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return m430E(j / 1000, (j % 1000) * 1000000);
            case 4:
                return m430E(j, 0L);
            case 5:
                return m430E(AbstractC0279a.m548Q(j, 60), 0L);
            case 6:
                return m430E(AbstractC0279a.m548Q(j, 3600), 0L);
            case 7:
                return m430E(AbstractC0279a.m548Q(j, 43200), 0L);
            case 8:
                return m430E(AbstractC0279a.m548Q(j, 86400), 0L);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    /* renamed from: E */
    public final C0325e m430E(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return m431D(AbstractC0279a.m547R(AbstractC0279a.m547R(this.f118a, j), j2 / 1000000000), this.f119b + (j2 % 1000000000));
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return j == Long.MIN_VALUE ? mo886d(Long.MAX_VALUE, bVar).mo886d(1L, bVar) : mo886d(-j, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.NANOS;
        }
        if (bVar == AbstractC0381r.f232b || bVar == AbstractC0381r.f231a || bVar == AbstractC0381r.f235e || bVar == AbstractC0381r.f234d || bVar == AbstractC0381r.f236f || bVar == AbstractC0381r.f237g) {
            return null;
        }
        return bVar.m428a(this);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(this.f118a, EnumC0364a.INSTANT_SECONDS).mo313c(this.f119b, EnumC0364a.NANO_OF_SECOND);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0325e) {
            C0325e eVar = (C0325e) obj;
            if (this.f118a == eVar.f118a && this.f119b == eVar.f119b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f118a;
        return (this.f119b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        C0327a aVar = C0327a.f122e;
        StringBuilder sb = new StringBuilder(32);
        C0332f fVar = aVar.f123a;
        Objects.requireNonNull(this, "temporal");
        Objects.requireNonNull(sb, "appendable");
        try {
            fVar.mo423i(new C0343q(this, aVar), sb);
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private Object writeReplace() {
        return new C0363t((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0325e) AbstractC0279a.m538a(gVar, this);
    }
}
