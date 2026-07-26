package p004j$.time;

import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.chrono.C0317t;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.m */
/* loaded from: classes2.dex */
public final class EnumC0356m extends Enum implements AbstractC0377n, AbstractC0378o {
    public static final EnumC0356m APRIL;
    public static final EnumC0356m AUGUST;
    public static final EnumC0356m DECEMBER;
    public static final EnumC0356m FEBRUARY;
    public static final EnumC0356m JANUARY;
    public static final EnumC0356m JULY;
    public static final EnumC0356m JUNE;
    public static final EnumC0356m MARCH;
    public static final EnumC0356m MAY;
    public static final EnumC0356m NOVEMBER;
    public static final EnumC0356m OCTOBER;
    public static final EnumC0356m SEPTEMBER;

    /* renamed from: a */
    public static final EnumC0356m[] f192a = values();

    /* renamed from: b */
    public static final /* synthetic */ EnumC0356m[] f193b;

    public static EnumC0356m valueOf(String str) {
        return (EnumC0356m) Enum.valueOf(EnumC0356m.class, str);
    }

    public static EnumC0356m[] values() {
        return (EnumC0356m[]) f193b.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, j$.time.m] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, j$.time.m] */
    static {
        ?? r0 = new Enum("JANUARY", 0);
        JANUARY = r0;
        ?? r1 = new Enum("FEBRUARY", 1);
        FEBRUARY = r1;
        ?? r3 = new Enum("MARCH", 2);
        MARCH = r3;
        ?? r5 = new Enum("APRIL", 3);
        APRIL = r5;
        ?? r7 = new Enum("MAY", 4);
        MAY = r7;
        ?? r9 = new Enum("JUNE", 5);
        JUNE = r9;
        ?? r11 = new Enum("JULY", 6);
        JULY = r11;
        ?? r13 = new Enum("AUGUST", 7);
        AUGUST = r13;
        ?? r15 = new Enum("SEPTEMBER", 8);
        SEPTEMBER = r15;
        ?? r2 = new Enum("OCTOBER", 9);
        OCTOBER = r2;
        ?? r4 = new Enum("NOVEMBER", 10);
        NOVEMBER = r4;
        ?? r6 = new Enum("DECEMBER", 11);
        DECEMBER = r6;
        f193b = new EnumC0356m[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r2, r4, r6};
    }

    /* renamed from: F */
    public static EnumC0356m m350F(int i) {
        if (i >= 1 && i <= 12) {
            return f192a[i - 1];
        }
        throw new RuntimeException("Invalid value for MonthOfYear: " + i);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? qVar == EnumC0364a.MONTH_OF_YEAR : qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.MONTH_OF_YEAR) {
            return qVar.mo337k();
        }
        return AbstractC0381r.m331d(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.MONTH_OF_YEAR) {
            return getValue();
        }
        return AbstractC0381r.m334a(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.MONTH_OF_YEAR) {
            return getValue();
        }
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    /* renamed from: D */
    public final int m352D(boolean z) {
        int i = AbstractC0355l.f191a[ordinal()];
        return i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : z ? 29 : 28;
    }

    /* renamed from: E */
    public final int m351E() {
        int i = AbstractC0355l.f191a[ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31;
        }
        return 29;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C */
    public final int m353C(boolean z) {
        switch (AbstractC0355l.f191a[ordinal()]) {
            case 1:
                return 32;
            case 2:
                return (z ? 1 : 0) + 91;
            case 3:
                return z + 152;
            case 4:
                return z + 244;
            case 5:
                return z + 305;
            case 6:
                return 1;
            case 7:
                return z + 60;
            case 8:
                return z + 121;
            case 9:
                return z + 182;
            case 10:
                return z + 213;
            case 11:
                return z + 274;
            default:
                return z + 335;
        }
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
            return mVar.mo313c(getValue(), EnumC0364a.MONTH_OF_YEAR);
        }
        throw new RuntimeException("Adjustment only supported on ISO date-time");
    }
}
