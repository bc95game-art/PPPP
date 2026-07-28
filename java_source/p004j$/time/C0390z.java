package p004j$.time;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.zone.C0396f;
import p004j$.util.Objects;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: j$.time.z */
/* loaded from: classes2.dex */
public final class C0390z extends AbstractC0389y implements AbstractC0377n, AbstractC0378o, Comparable {

    /* renamed from: c */
    public static final ConcurrentHashMap f251c = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: d */
    public static final ConcurrentHashMap f252d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e */
    public static final C0390z f253e = m303I(0);

    /* renamed from: f */
    public static final C0390z f254f = m303I(-64800);

    /* renamed from: g */
    public static final C0390z f255g = m303I(64800);
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: a */
    public final int f256a;

    /* renamed from: b */
    public final transient String f257b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return ((C0390z) obj).f256a - this.f256a;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0390z m305G(String str) {
        int i;
        int i2;
        int i3;
        char charAt;
        Objects.requireNonNull(str, "offsetId");
        C0390z zVar = (C0390z) f252d.get(str);
        if (zVar != null) {
            return zVar;
        }
        int length = str.length();
        if (length == 2) {
            str = str.charAt(0) + "0" + str.charAt(1);
        } else if (length != 3) {
            if (length == 5) {
                i3 = m302J(str, 1, false);
                i2 = m302J(str, 3, false);
            } else if (length != 6) {
                if (length == 7) {
                    i3 = m302J(str, 1, false);
                    i2 = m302J(str, 3, false);
                    i = m302J(str, 5, false);
                } else if (length == 9) {
                    i3 = m302J(str, 1, false);
                    i2 = m302J(str, 4, true);
                    i = m302J(str, 7, true);
                } else {
                    throw new RuntimeException("Invalid ID for ZoneOffset, invalid format: ".concat(str));
                }
                charAt = str.charAt(0);
                if (charAt == '+' && charAt != '-') {
                    throw new RuntimeException("Invalid ID for ZoneOffset, plus/minus not found when expected: ".concat(str));
                } else if (charAt == '-') {
                    return m304H(-i3, -i2, -i);
                } else {
                    return m304H(i3, i2, i);
                }
            } else {
                i3 = m302J(str, 1, false);
                i2 = m302J(str, 4, true);
            }
            i = 0;
            charAt = str.charAt(0);
            if (charAt == '+') {
            }
            if (charAt == '-') {
            }
        }
        i3 = m302J(str, 1, false);
        i2 = 0;
        i = 0;
        charAt = str.charAt(0);
        if (charAt == '+') {
        }
        if (charAt == '-') {
        }
    }

    @Override // p004j$.time.AbstractC0389y
    /* renamed from: C */
    public final C0396f mo307C() {
        Objects.requireNonNull(this, "offset");
        return new C0396f(this);
    }

    /* renamed from: J */
    public static int m302J(CharSequence charSequence, int i, boolean z) {
        if (z) {
            String str = (String) charSequence;
            if (str.charAt(i - 1) != ':') {
                throw new RuntimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) str));
            }
        }
        String str2 = (String) charSequence;
        char charAt = str2.charAt(i);
        char charAt2 = str2.charAt(i + 1);
        if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
            throw new RuntimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) str2));
        }
        return (charAt2 - '0') + ((charAt - '0') * 10);
    }

    /* renamed from: H */
    public static C0390z m304H(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            throw new RuntimeException("Zone offset hours not in valid range: value " + i + " is not in the range -18 to 18");
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new RuntimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i2 < -59 || i2 > 59) {
            throw new RuntimeException("Zone offset minutes not in valid range: value " + i2 + " is not in the range -59 to 59");
        } else if (i3 < -59 || i3 > 59) {
            throw new RuntimeException("Zone offset seconds not in valid range: value " + i3 + " is not in the range -59 to 59");
        } else if (Math.abs(i) != 18 || (i2 | i3) == 0) {
            return m303I((i2 * 60) + (i * 3600) + i3);
        } else {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    /* renamed from: I */
    public static C0390z m303I(int i) {
        if (i < -64800 || i > 64800) {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i % 900 != 0) {
            return new C0390z(i);
        } else {
            Integer valueOf = Integer.valueOf(i);
            ConcurrentHashMap concurrentHashMap = f251c;
            C0390z zVar = (C0390z) concurrentHashMap.get(valueOf);
            if (zVar != null) {
                return zVar;
            }
            concurrentHashMap.putIfAbsent(valueOf, new C0390z(i));
            C0390z zVar2 = (C0390z) concurrentHashMap.get(valueOf);
            f252d.putIfAbsent(zVar2.f257b, zVar2);
            return zVar2;
        }
    }

    public C0390z(int i) {
        String str;
        this.f256a = i;
        if (i == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i);
            StringBuilder sb = new StringBuilder();
            int i2 = abs / 3600;
            int i3 = (abs / 60) % 60;
            sb.append(i < 0 ? "-" : "+");
            sb.append(i2 < 10 ? "0" : "");
            sb.append(i2);
            String str2 = ":";
            sb.append(i3 < 10 ? ":0" : str2);
            sb.append(i3);
            int i4 = abs % 60;
            if (i4 != 0) {
                sb.append(i4 < 10 ? ":0" : str2);
                sb.append(i4);
            }
            str = sb.toString();
        }
        this.f257b = str;
    }

    @Override // p004j$.time.AbstractC0389y
    /* renamed from: h */
    public final String mo298h() {
        return this.f257b;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? qVar == EnumC0364a.OFFSET_SECONDS : qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        return AbstractC0381r.m331d(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.OFFSET_SECONDS) {
            return this.f256a;
        }
        if (!AbstractC0283b.m494b(qVar)) {
            return AbstractC0381r.m331d(this, qVar).m329a(mo293w(qVar), qVar);
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.OFFSET_SECONDS) {
            return this.f256a;
        }
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        return (bVar == AbstractC0381r.f234d || bVar == AbstractC0381r.f235e) ? this : AbstractC0381r.m332c(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(this.f256a, EnumC0364a.OFFSET_SECONDS);
    }

    @Override // p004j$.time.AbstractC0389y
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0390z) && this.f256a == ((C0390z) obj).f256a;
    }

    @Override // p004j$.time.AbstractC0389y
    public final int hashCode() {
        return this.f256a;
    }

    @Override // p004j$.time.AbstractC0389y
    public final String toString() {
        return this.f257b;
    }

    private Object writeReplace() {
        return new C0363t((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // p004j$.time.AbstractC0389y
    /* renamed from: F */
    public final void mo306F(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        m300L(dataOutput);
    }

    /* renamed from: L */
    public final void m300L(DataOutput dataOutput) {
        int i = this.f256a;
        int i2 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }

    /* renamed from: K */
    public static C0390z m301K(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? m303I(dataInput.readInt()) : m303I(readByte * 900);
    }
}
