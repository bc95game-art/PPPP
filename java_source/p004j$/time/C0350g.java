package p004j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.chrono.AbstractC0289b;
import p004j$.time.chrono.AbstractC0295e;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.chrono.C0317t;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
import p004j$.util.Objects;
/* renamed from: j$.time.g */
/* loaded from: classes2.dex */
public final class C0350g implements AbstractC0376m, AbstractC0378o, AbstractC0289b, Serializable {

    /* renamed from: d */
    public static final C0350g f171d = m398K(-999999999, 1, 1);

    /* renamed from: e */
    public static final C0350g f172e = m398K(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a */
    public final int f173a;

    /* renamed from: b */
    public final short f174b;

    /* renamed from: c */
    public final short f175c;

    static {
        m398K(1970, 1, 1);
    }

    /* renamed from: K */
    public static C0350g m398K(int i, int i2, int i3) {
        EnumC0364a.YEAR.m344s(i);
        EnumC0364a.MONTH_OF_YEAR.m344s(i2);
        EnumC0364a.DAY_OF_MONTH.m344s(i3);
        return m405D(i, i2, i3);
    }

    /* renamed from: L */
    public static C0350g m397L(long j) {
        long j2;
        EnumC0364a.EPOCH_DAY.m344s(j);
        long j3 = 719468 + j;
        if (j3 < 0) {
            long j4 = ((j + 719469) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        long j7 = j5 + j2 + (i2 / 10);
        EnumC0364a aVar = EnumC0364a.YEAR;
        return new C0350g(aVar.f213b.m329a(j7, aVar), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    /* renamed from: E */
    public static C0350g m404E(AbstractC0377n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        C0350g gVar = (C0350g) nVar.mo295l(AbstractC0381r.f236f);
        if (gVar != null) {
            return gVar;
        }
        String name = nVar.getClass().getName();
        throw new RuntimeException("Unable to obtain LocalDate from TemporalAccessor: " + nVar + " of type " + name);
    }

    /* renamed from: D */
    public static C0350g m405D(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else {
                C0317t.f100c.getClass();
                if (C0317t.m451j(i)) {
                    i4 = 29;
                }
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    throw new RuntimeException("Invalid date 'February 29' as '" + i + "' is not a leap year");
                }
                String name = EnumC0356m.m350F(i2).name();
                throw new RuntimeException("Invalid date '" + name + " " + i3 + "'");
            }
        }
        return new C0350g(i, i2, i3);
    }

    /* renamed from: Q */
    public static C0350g m392Q(int i, int i2, int i3) {
        if (i2 == 2) {
            C0317t.f100c.getClass();
            i3 = Math.min(i3, C0317t.m451j((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return new C0350g(i, i2, i3);
    }

    public C0350g(int i, int i2, int i3) {
        this.f173a = i;
        this.f174b = (short) i2;
        this.f175c = (short) i3;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return AbstractC0279a.m516s(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo338j(this);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        if (aVar.isDateBased()) {
            int i = AbstractC0326f.f120a[aVar.ordinal()];
            if (i == 1) {
                return C0384u.m325e(1L, m399J());
            }
            if (i == 2) {
                return C0384u.m325e(1L, m400I() ? 366 : 365);
            } else if (i == 3) {
                return C0384u.m325e(1L, (EnumC0356m.m350F(this.f174b) != EnumC0356m.FEBRUARY || m400I()) ? 5L : 4L);
            } else if (i != 4) {
                return aVar.f213b;
            } else {
                return this.f173a <= 0 ? C0384u.m325e(1L, 1000000000L) : C0384u.m325e(1L, 999999999L);
            }
        } else {
            throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (qVar instanceof EnumC0364a) {
            return m403F(qVar);
        }
        return AbstractC0381r.m334a(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        if (qVar == EnumC0364a.EPOCH_DAY) {
            return mo386x();
        }
        if (qVar == EnumC0364a.PROLEPTIC_MONTH) {
            return ((this.f173a * 12) + this.f174b) - 1;
        }
        return m403F(qVar);
    }

    /* renamed from: F */
    public final int m403F(AbstractC0380q qVar) {
        switch (AbstractC0326f.f120a[((EnumC0364a) qVar).ordinal()]) {
            case 1:
                return this.f175c;
            case 2:
                return m401H();
            case 3:
                return ((this.f175c - 1) / 7) + 1;
            case 4:
                int i = this.f173a;
                return i >= 1 ? i : 1 - i;
            case 5:
                return m402G().getValue();
            case 6:
                return ((this.f175c - 1) % 7) + 1;
            case 7:
                return ((m401H() - 1) % 7) + 1;
            case 8:
                throw new RuntimeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((m401H() - 1) / 7) + 1;
            case 10:
                return this.f174b;
            case 11:
                throw new RuntimeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f173a;
            case 13:
                return this.f173a >= 1 ? 1 : 0;
            default:
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: a */
    public final AbstractC0310m mo387a() {
        return C0317t.f100c;
    }

    /* renamed from: H */
    public final int m401H() {
        return (EnumC0356m.m350F(this.f174b).m353C(m400I()) + this.f175c) - 1;
    }

    /* renamed from: G */
    public final EnumC0285c m402G() {
        return EnumC0285c.m493C(((int) AbstractC0279a.m544U(mo386x() + 3, 7)) + 1);
    }

    /* renamed from: I */
    public final boolean m400I() {
        C0317t.f100c.getClass();
        return C0317t.m451j(this.f173a);
    }

    /* renamed from: J */
    public final int m399J() {
        short s = this.f174b;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : m400I() ? 29 : 28;
    }

    /* renamed from: S */
    public final C0350g mo311j(AbstractC0378o oVar) {
        if (oVar instanceof C0350g) {
            return (C0350g) oVar;
        }
        return (C0350g) oVar.mo294o(this);
    }

    /* renamed from: R */
    public final C0350g mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0350g) qVar.mo335o(this, j);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        aVar.m344s(j);
        switch (AbstractC0326f.f120a[aVar.ordinal()]) {
            case 1:
                int i = (int) j;
                if (this.f175c != i) {
                    return m398K(this.f173a, this.f174b, i);
                }
                break;
            case 2:
                return m389T((int) j);
            case 3:
                return m395N(AbstractC0279a.m548Q(j - mo293w(EnumC0364a.ALIGNED_WEEK_OF_MONTH), 7));
            case 4:
                if (this.f173a < 1) {
                    j = 1 - j;
                }
                return m388U((int) j);
            case 5:
                return m395N(j - m402G().getValue());
            case 6:
                return m395N(j - mo293w(EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return m395N(j - mo293w(EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return m397L(j);
            case 9:
                return m395N(AbstractC0279a.m548Q(j - mo293w(EnumC0364a.ALIGNED_WEEK_OF_YEAR), 7));
            case 10:
                int i2 = (int) j;
                if (this.f174b != i2) {
                    EnumC0364a.MONTH_OF_YEAR.m344s(i2);
                    return m392Q(this.f173a, i2, this.f175c);
                }
                break;
            case 11:
                return m394O(j - (((this.f173a * 12) + this.f174b) - 1));
            case 12:
                return m388U((int) j);
            case 13:
                if (mo293w(EnumC0364a.ERA) != j) {
                    return m388U(1 - this.f173a);
                }
                break;
            default:
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
        return this;
    }

    /* renamed from: U */
    public final C0350g m388U(int i) {
        if (this.f173a == i) {
            return this;
        }
        EnumC0364a.YEAR.m344s(i);
        return m392Q(i, this.f174b, this.f175c);
    }

    /* renamed from: T */
    public final C0350g m389T(int i) {
        if (m401H() == i) {
            return this;
        }
        int i2 = this.f173a;
        long j = i2;
        EnumC0364a.YEAR.m344s(j);
        EnumC0364a.DAY_OF_YEAR.m344s(i);
        C0317t.f100c.getClass();
        boolean j2 = C0317t.m451j(j);
        if (i != 366 || j2) {
            EnumC0356m F = EnumC0356m.m350F(((i - 1) / 31) + 1);
            if (i > (F.m352D(j2) + F.m353C(j2)) - 1) {
                F = EnumC0356m.f192a[((((int) 1) + 12) + F.ordinal()) % 12];
            }
            return new C0350g(i2, F.getValue(), (i - F.m353C(j2)) + 1);
        }
        throw new RuntimeException("Invalid date 'DayOfYear 366' as '" + i2 + "' is not a leap year");
    }

    /* renamed from: M */
    public final C0350g mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return (C0350g) sVar.mo330i(this, j);
        }
        switch (AbstractC0326f.f121b[((EnumC0365b) sVar).ordinal()]) {
            case 1:
                return m395N(j);
            case 2:
                return m395N(AbstractC0279a.m548Q(j, 7));
            case 3:
                return m394O(j);
            case 4:
                return m393P(j);
            case 5:
                return m393P(AbstractC0279a.m548Q(j, 10));
            case 6:
                return m393P(AbstractC0279a.m548Q(j, 100));
            case 7:
                return m393P(AbstractC0279a.m548Q(j, 1000));
            case 8:
                EnumC0364a aVar = EnumC0364a.ERA;
                return mo313c(AbstractC0279a.m547R(mo293w(aVar), j), aVar);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    /* renamed from: P */
    public final C0350g m393P(long j) {
        if (j == 0) {
            return this;
        }
        EnumC0364a aVar = EnumC0364a.YEAR;
        return m392Q(aVar.f213b.m329a(this.f173a + j, aVar), this.f174b, this.f175c);
    }

    /* renamed from: O */
    public final C0350g m394O(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.f173a * 12) + (this.f174b - 1) + j;
        EnumC0364a aVar = EnumC0364a.YEAR;
        long j3 = 12;
        return m392Q(aVar.f213b.m329a(AbstractC0279a.m543V(j2, j3), aVar), ((int) AbstractC0279a.m544U(j2, j3)) + 1, this.f175c);
    }

    /* renamed from: N */
    public final C0350g m395N(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = this.f175c + j;
        if (j2 > 0) {
            if (j2 <= 28) {
                return new C0350g(this.f173a, this.f174b, (int) j2);
            }
            if (j2 <= 59) {
                long J = m399J();
                if (j2 <= J) {
                    return new C0350g(this.f173a, this.f174b, (int) j2);
                }
                short s = this.f174b;
                if (s < 12) {
                    return new C0350g(this.f173a, s + 1, (int) (j2 - J));
                }
                EnumC0364a.YEAR.m344s(this.f173a + 1);
                return new C0350g(this.f173a + 1, 1, (int) (j2 - J));
            }
        }
        return m397L(AbstractC0279a.m547R(mo386x(), j));
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return j == Long.MIN_VALUE ? mo886d(Long.MAX_VALUE, bVar).mo886d(1L, bVar) : mo886d(-j, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        return bVar == AbstractC0381r.f236f ? this : AbstractC0279a.m514u(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return AbstractC0279a.m538a(this, mVar);
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: y */
    public final AbstractC0295e mo385y(C0354k kVar) {
        return C0352i.m381F(this, kVar);
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: x */
    public final long mo386x() {
        long j;
        long j2 = this.f173a;
        long j3 = this.f174b;
        long j4 = 365 * j2;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / (-400)) + ((j2 / (-4)) - (j2 / (-100))));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + (this.f175c - 1);
        if (j3 > 2) {
            j5--;
            if (!m400I()) {
                j5 -= 2;
            }
        }
        return j5 - 719528;
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: A */
    public final int compareTo(AbstractC0289b bVar) {
        if (bVar instanceof C0350g) {
            return m406C((C0350g) bVar);
        }
        return AbstractC0279a.m528g(this, bVar);
    }

    /* renamed from: C */
    public final int m406C(C0350g gVar) {
        int i = this.f173a - gVar.f173a;
        if (i != 0) {
            return i;
        }
        int i2 = this.f174b - gVar.f174b;
        return i2 == 0 ? this.f175c - gVar.f175c : i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0350g) && m406C((C0350g) obj) == 0;
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    public final int hashCode() {
        int i = this.f173a;
        return (((i << 11) + (this.f174b << 6)) + this.f175c) ^ (i & (-2048));
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    public final String toString() {
        int i = this.f173a;
        short s = this.f174b;
        short s2 = this.f175c;
        int abs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + 10000);
            sb.deleteCharAt(0);
        }
        String str = "-";
        sb.append(s < 10 ? "-0" : str);
        sb.append((int) s);
        if (s2 < 10) {
            str = "-0";
        }
        sb.append(str);
        sb.append((int) s2);
        return sb.toString();
    }

    private Object writeReplace() {
        return new C0363t((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
