package p004j$.time.format;

import p004j$.time.temporal.AbstractC0380q;
/* renamed from: j$.time.format.j */
/* loaded from: classes2.dex */
public class C0336j implements AbstractC0333g {

    /* renamed from: f */
    public static final long[] f136f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* renamed from: a */
    public final AbstractC0380q f137a;

    /* renamed from: b */
    public final int f138b;

    /* renamed from: c */
    public final int f139c;

    /* renamed from: d */
    public final EnumC0348v f140d;

    /* renamed from: e */
    public final int f141e;

    public C0336j(AbstractC0380q qVar, int i, int i2, EnumC0348v vVar) {
        this.f137a = qVar;
        this.f138b = i;
        this.f139c = i2;
        this.f140d = vVar;
        this.f141e = 0;
    }

    public C0336j(AbstractC0380q qVar, int i, int i2, EnumC0348v vVar, int i3) {
        this.f137a = qVar;
        this.f138b = i;
        this.f139c = i2;
        this.f140d = vVar;
        this.f141e = i3;
    }

    /* renamed from: a */
    public C0336j mo426a() {
        if (this.f141e == -1) {
            return this;
        }
        return new C0336j(this.f137a, this.f138b, this.f139c, this.f140d, -1);
    }

    /* renamed from: b */
    public C0336j mo425b(int i) {
        return new C0336j(this.f137a, this.f138b, this.f139c, this.f140d, this.f141e + i);
    }

    @Override // p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    public boolean mo423i(C0343q qVar, StringBuilder sb) {
        AbstractC0380q qVar2 = this.f137a;
        Long a = qVar.m410a(qVar2);
        if (a == null) {
            return false;
        }
        long longValue = a.longValue();
        C0346t tVar = qVar.f164b.f125c;
        String l = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        int length = l.length();
        int i = this.f139c;
        if (length <= i) {
            tVar.getClass();
            int i2 = this.f138b;
            EnumC0348v vVar = this.f140d;
            if (longValue >= 0) {
                int i3 = AbstractC0330d.f130a[vVar.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        sb.append('+');
                    }
                } else if (i2 < 19 && longValue >= f136f[i2]) {
                    sb.append('+');
                }
            } else {
                int i4 = AbstractC0330d.f130a[vVar.ordinal()];
                if (i4 == 1 || i4 == 2 || i4 == 3) {
                    sb.append('-');
                } else if (i4 == 4) {
                    throw new RuntimeException("Field " + qVar2 + " cannot be printed as the value " + longValue + " cannot be negative according to the SignStyle");
                }
            }
            for (int i5 = 0; i5 < i2 - l.length(); i5++) {
                sb.append('0');
            }
            sb.append(l);
            return true;
        }
        throw new RuntimeException("Field " + qVar2 + " cannot be printed as the value " + longValue + " exceeds the maximum print width of " + i);
    }

    public String toString() {
        int i = this.f139c;
        AbstractC0380q qVar = this.f137a;
        EnumC0348v vVar = this.f140d;
        int i2 = this.f138b;
        if (i2 == 1 && i == 19 && vVar == EnumC0348v.NORMAL) {
            return "Value(" + qVar + ")";
        } else if (i2 == i && vVar == EnumC0348v.NOT_NEGATIVE) {
            return "Value(" + qVar + "," + i2 + ")";
        } else {
            return "Value(" + qVar + "," + i2 + "," + i + "," + vVar + ")";
        }
    }
}
