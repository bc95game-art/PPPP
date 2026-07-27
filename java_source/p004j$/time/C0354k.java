package p004j$.time;

import com.emanuelef.remote_capture.Blacklists;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
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
/* renamed from: j$.time.k */
/* loaded from: classes2.dex */
public final class C0354k implements AbstractC0376m, AbstractC0378o, Comparable, Serializable {

    /* renamed from: e */
    public static final C0354k f183e;

    /* renamed from: f */
    public static final C0354k f184f;

    /* renamed from: g */
    public static final C0354k f185g;

    /* renamed from: h */
    public static final C0354k[] f186h = new C0354k[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a */
    public final byte f187a;

    /* renamed from: b */
    public final byte f188b;

    /* renamed from: c */
    public final byte f189c;

    /* renamed from: d */
    public final int f190d;

    static {
        int i = 0;
        while (true) {
            C0354k[] kVarArr = f186h;
            if (i < kVarArr.length) {
                kVarArr[i] = new C0354k(i, 0, 0, 0);
                i++;
            } else {
                C0354k kVar = kVarArr[0];
                f185g = kVar;
                C0354k kVar2 = kVarArr[12];
                f183e = kVar;
                f184f = new C0354k(23, 59, 59, 999999999);
                return;
            }
        }
    }

    /* renamed from: G */
    public static C0354k m365G(long j) {
        EnumC0364a.NANO_OF_DAY.m344s(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (i * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (i2 * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return m368D(i, i2, i3, (int) (j3 - (i3 * 1000000000)));
    }

    /* renamed from: E */
    public static C0354k m367E(AbstractC0377n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        C0354k kVar = (C0354k) nVar.mo295l(AbstractC0381r.f237g);
        if (kVar != null) {
            return kVar;
        }
        String name = nVar.getClass().getName();
        throw new RuntimeException("Unable to obtain LocalTime from TemporalAccessor: " + nVar + " of type " + name);
    }

    /* renamed from: D */
    public static C0354k m368D(int i, int i2, int i3, int i4) {
        if ((i2 | i3 | i4) == 0) {
            return f186h[i];
        }
        return new C0354k(i, i2, i3, i4);
    }

    public C0354k(int i, int i2, int i3, int i4) {
        this.f187a = (byte) i;
        this.f188b = (byte) i2;
        this.f189c = (byte) i3;
        this.f190d = i4;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        if (qVar instanceof EnumC0364a) {
            return ((EnumC0364a) qVar).m343w();
        }
        return qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        return AbstractC0381r.m331d(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (qVar instanceof EnumC0364a) {
            return m366F(qVar);
        }
        return AbstractC0381r.m334a(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        if (qVar == EnumC0364a.NANO_OF_DAY) {
            return m358N();
        }
        if (qVar == EnumC0364a.MICRO_OF_DAY) {
            return m358N() / 1000;
        }
        return m366F(qVar);
    }

    /* renamed from: F */
    public final int m366F(AbstractC0380q qVar) {
        switch (AbstractC0353j.f181a[((EnumC0364a) qVar).ordinal()]) {
            case 1:
                return this.f190d;
            case 2:
                throw new RuntimeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f190d / 1000;
            case 4:
                throw new RuntimeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f190d / 1000000;
            case 6:
                return (int) (m358N() / 1000000);
            case 7:
                return this.f189c;
            case 8:
                return m357O();
            case 9:
                return this.f188b;
            case 10:
                return (this.f187a * 60) + this.f188b;
            case 11:
                return this.f187a % 12;
            case 12:
                int i = this.f187a % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 13:
                return this.f187a;
            case 14:
                byte b = this.f187a;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 15:
                return this.f187a / 12;
            default:
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: P */
    public final C0354k mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0354k) qVar.mo335o(this, j);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        aVar.m344s(j);
        switch (AbstractC0353j.f181a[aVar.ordinal()]) {
            case 1:
                return m355Q((int) j);
            case 2:
                return m365G(j);
            case 3:
                return m355Q(((int) j) * 1000);
            case 4:
                return m365G(j * 1000);
            case 5:
                return m355Q(((int) j) * 1000000);
            case 6:
                return m365G(j * 1000000);
            case 7:
                int i = (int) j;
                if (this.f189c != i) {
                    EnumC0364a.SECOND_OF_MINUTE.m344s(i);
                    return m368D(this.f187a, this.f188b, i, this.f190d);
                }
                break;
            case 8:
                return m360L(j - m357O());
            case 9:
                int i2 = (int) j;
                if (this.f188b != i2) {
                    EnumC0364a.MINUTE_OF_HOUR.m344s(i2);
                    return m368D(this.f187a, i2, this.f189c, this.f190d);
                }
                break;
            case 10:
                return m362J(j - ((this.f187a * 60) + this.f188b));
            case 11:
                return m363I(j - (this.f187a % 12));
            case 12:
                if (j == 12) {
                    j = 0;
                }
                return m363I(j - (this.f187a % 12));
            case 13:
                int i3 = (int) j;
                if (this.f187a != i3) {
                    EnumC0364a.HOUR_OF_DAY.m344s(i3);
                    return m368D(i3, this.f188b, this.f189c, this.f190d);
                }
                break;
            case 14:
                if (j == 24) {
                    j = 0;
                }
                int i4 = (int) j;
                if (this.f187a != i4) {
                    EnumC0364a.HOUR_OF_DAY.m344s(i4);
                    return m368D(i4, this.f188b, this.f189c, this.f190d);
                }
                break;
            case 15:
                return m363I((j - (this.f187a / 12)) * 12);
            default:
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
        return this;
    }

    /* renamed from: Q */
    public final C0354k m355Q(int i) {
        if (this.f190d == i) {
            return this;
        }
        EnumC0364a.NANO_OF_SECOND.m344s(i);
        return m368D(this.f187a, this.f188b, this.f189c, i);
    }

    /* renamed from: H */
    public final C0354k mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return (C0354k) sVar.mo330i(this, j);
        }
        switch (AbstractC0353j.f182b[((EnumC0365b) sVar).ordinal()]) {
            case 1:
                return m361K(j);
            case 2:
                return m361K((j % 86400000000L) * 1000);
            case 3:
                return m361K((j % Blacklists.BLACKLISTS_UPDATE_MILLIS) * 1000000);
            case 4:
                return m360L(j);
            case 5:
                return m362J(j);
            case 6:
                return m363I(j);
            case 7:
                return m363I((j % 2) * 12);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    /* renamed from: I */
    public final C0354k m363I(long j) {
        return j == 0 ? this : m368D(((((int) (j % 24)) + this.f187a) + 24) % 24, this.f188b, this.f189c, this.f190d);
    }

    /* renamed from: J */
    public final C0354k m362J(long j) {
        if (j != 0) {
            int i = (this.f187a * 60) + this.f188b;
            int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
            if (i != i2) {
                return m368D(i2 / 60, i2 % 60, this.f189c, this.f190d);
            }
        }
        return this;
    }

    /* renamed from: L */
    public final C0354k m360L(long j) {
        if (j != 0) {
            int i = (this.f188b * 60) + (this.f187a * 3600) + this.f189c;
            int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
            if (i != i2) {
                return m368D(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.f190d);
            }
        }
        return this;
    }

    /* renamed from: K */
    public final C0354k m361K(long j) {
        if (j != 0) {
            long N = m358N();
            long j2 = (((j % 86400000000000L) + N) + 86400000000000L) % 86400000000000L;
            if (N != j2) {
                return m368D((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
            }
        }
        return this;
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return j == Long.MIN_VALUE ? mo886d(Long.MAX_VALUE, bVar).mo886d(1L, bVar) : mo886d(-j, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f232b || bVar == AbstractC0381r.f231a || bVar == AbstractC0381r.f235e || bVar == AbstractC0381r.f234d) {
            return null;
        }
        if (bVar == AbstractC0381r.f237g) {
            return this;
        }
        if (bVar == AbstractC0381r.f236f) {
            return null;
        }
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.NANOS;
        }
        return bVar.m428a(this);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(m358N(), EnumC0364a.NANO_OF_DAY);
    }

    /* renamed from: O */
    public final int m357O() {
        return (this.f188b * 60) + (this.f187a * 3600) + this.f189c;
    }

    /* renamed from: N */
    public final long m358N() {
        return (this.f189c * 1000000000) + (this.f188b * 60000000000L) + (this.f187a * 3600000000000L) + this.f190d;
    }

    /* renamed from: C */
    public final int compareTo(C0354k kVar) {
        int compare = Integer.compare(this.f187a, kVar.f187a);
        return (compare == 0 && (compare = Integer.compare(this.f188b, kVar.f188b)) == 0 && (compare = Integer.compare(this.f189c, kVar.f189c)) == 0) ? Integer.compare(this.f190d, kVar.f190d) : compare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0354k) {
            C0354k kVar = (C0354k) obj;
            if (this.f187a == kVar.f187a && this.f188b == kVar.f188b && this.f189c == kVar.f189c && this.f190d == kVar.f190d) {
                return true;
            }
        }
        return false;
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0354k) AbstractC0279a.m538a(gVar, this);
    }

    public final int hashCode() {
        long N = m358N();
        return (int) (N ^ (N >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b = this.f187a;
        byte b2 = this.f188b;
        byte b3 = this.f189c;
        int i = this.f190d;
        sb.append(b < 10 ? "0" : "");
        sb.append((int) b);
        String str = ":";
        sb.append(b2 < 10 ? ":0" : str);
        sb.append((int) b2);
        if (b3 > 0 || i > 0) {
            if (b3 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append((int) b3);
            if (i > 0) {
                sb.append('.');
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new C0363t((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* renamed from: R */
    public final void m354R(DataOutput dataOutput) {
        if (this.f190d != 0) {
            dataOutput.writeByte(this.f187a);
            dataOutput.writeByte(this.f188b);
            dataOutput.writeByte(this.f189c);
            dataOutput.writeInt(this.f190d);
        } else if (this.f189c != 0) {
            dataOutput.writeByte(this.f187a);
            dataOutput.writeByte(this.f188b);
            dataOutput.writeByte(~this.f189c);
        } else if (this.f188b == 0) {
            dataOutput.writeByte(~this.f187a);
        } else {
            dataOutput.writeByte(this.f187a);
            dataOutput.writeByte(~this.f188b);
        }
    }

    /* renamed from: M */
    public static C0354k m359M(DataInput dataInput) {
        int i;
        int i2;
        int i3;
        int i4;
        int readByte = dataInput.readByte();
        int i5 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i4 = 0;
        } else {
            int readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i6 = ~readByte2;
                i2 = 0;
                i = 0;
                i3 = i6;
            } else {
                int readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i5 = readByte2;
                    i4 = ~readByte3;
                } else {
                    i2 = dataInput.readInt();
                    i3 = readByte2;
                    i = readByte3;
                }
            }
            EnumC0364a.HOUR_OF_DAY.m344s(readByte);
            EnumC0364a.MINUTE_OF_HOUR.m344s(i3);
            EnumC0364a.SECOND_OF_MINUTE.m344s(i == 1 ? 1L : 0L);
            EnumC0364a.NANO_OF_SECOND.m344s(i2);
            return m368D(readByte, i3, i, i2);
        }
        i2 = 0;
        i3 = i5;
        i = i4;
        EnumC0364a.HOUR_OF_DAY.m344s(readByte);
        EnumC0364a.MINUTE_OF_HOUR.m344s(i3);
        EnumC0364a.SECOND_OF_MINUTE.m344s(i == 1 ? 1L : 0L);
        EnumC0364a.NANO_OF_SECOND.m344s(i2);
        return m368D(readByte, i3, i, i2);
    }
}
