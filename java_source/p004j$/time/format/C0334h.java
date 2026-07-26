package p004j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.C0384u;
/* renamed from: j$.time.format.h */
/* loaded from: classes2.dex */
public final class C0334h extends C0336j {

    /* renamed from: g */
    public final boolean f134g;

    public C0334h(AbstractC0380q qVar, int i, int i2, boolean z, int i3) {
        super(qVar, i, i2, EnumC0348v.NOT_NEGATIVE, i3);
        this.f134g = z;
    }

    @Override // p004j$.time.format.C0336j
    /* renamed from: a */
    public final C0336j mo426a() {
        if (this.f141e == -1) {
            return this;
        }
        return new C0334h(this.f137a, this.f138b, this.f139c, this.f134g, -1);
    }

    @Override // p004j$.time.format.C0336j
    /* renamed from: b */
    public final C0336j mo425b(int i) {
        return new C0334h(this.f137a, this.f138b, this.f139c, this.f134g, this.f141e + i);
    }

    @Override // p004j$.time.format.C0336j, p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    public final boolean mo423i(C0343q qVar, StringBuilder sb) {
        AbstractC0380q qVar2 = this.f137a;
        Long a = qVar.m410a(qVar2);
        if (a == null) {
            return false;
        }
        C0346t tVar = qVar.f164b.f125c;
        long longValue = a.longValue();
        C0384u k = qVar2.mo337k();
        k.m328b(longValue, qVar2);
        BigDecimal valueOf = BigDecimal.valueOf(k.f238a);
        BigDecimal add = BigDecimal.valueOf(k.f241d).subtract(valueOf).add(BigDecimal.ONE);
        BigDecimal subtract = BigDecimal.valueOf(longValue).subtract(valueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal divide = subtract.divide(add, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (divide.compareTo(bigDecimal) != 0) {
            bigDecimal = divide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : divide.stripTrailingZeros();
        }
        int scale = bigDecimal.scale();
        boolean z = this.f134g;
        int i = this.f138b;
        if (scale == 0) {
            if (i > 0) {
                if (z) {
                    tVar.getClass();
                    sb.append('.');
                }
                for (int i2 = 0; i2 < i; i2++) {
                    tVar.getClass();
                    sb.append('0');
                }
            }
            return true;
        }
        String substring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i), this.f139c), roundingMode).toPlainString().substring(2);
        tVar.getClass();
        if (z) {
            sb.append('.');
        }
        sb.append(substring);
        return true;
    }

    @Override // p004j$.time.format.C0336j
    public final String toString() {
        String str = this.f134g ? ",DecimalPoint" : "";
        return "Fraction(" + this.f137a + "," + this.f138b + "," + this.f139c + str + ")";
    }
}
