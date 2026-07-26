package p004j$.time;

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
/* renamed from: j$.time.c */
/* loaded from: classes2.dex */
public final class EnumC0285c extends Enum implements AbstractC0377n, AbstractC0378o {
    public static final EnumC0285c FRIDAY;
    public static final EnumC0285c MONDAY;
    public static final EnumC0285c SATURDAY;
    public static final EnumC0285c SUNDAY;
    public static final EnumC0285c THURSDAY;
    public static final EnumC0285c TUESDAY;
    public static final EnumC0285c WEDNESDAY;

    /* renamed from: a */
    public static final EnumC0285c[] f48a = values();

    /* renamed from: b */
    public static final /* synthetic */ EnumC0285c[] f49b;

    public static EnumC0285c valueOf(String str) {
        return (EnumC0285c) Enum.valueOf(EnumC0285c.class, str);
    }

    public static EnumC0285c[] values() {
        return (EnumC0285c[]) f49b.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.c] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, j$.time.c] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.c] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, j$.time.c] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, j$.time.c] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, j$.time.c] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, j$.time.c] */
    static {
        ?? r0 = new Enum("MONDAY", 0);
        MONDAY = r0;
        ?? r1 = new Enum("TUESDAY", 1);
        TUESDAY = r1;
        ?? r3 = new Enum("WEDNESDAY", 2);
        WEDNESDAY = r3;
        ?? r5 = new Enum("THURSDAY", 3);
        THURSDAY = r5;
        ?? r7 = new Enum("FRIDAY", 4);
        FRIDAY = r7;
        ?? r9 = new Enum("SATURDAY", 5);
        SATURDAY = r9;
        ?? r11 = new Enum("SUNDAY", 6);
        SUNDAY = r11;
        f49b = new EnumC0285c[]{r0, r1, r3, r5, r7, r9, r11};
    }

    /* renamed from: C */
    public static EnumC0285c m493C(int i) {
        if (i >= 1 && i <= 7) {
            return f48a[i - 1];
        }
        throw new RuntimeException("Invalid value for DayOfWeek: " + i);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? qVar == EnumC0364a.DAY_OF_WEEK : qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.DAY_OF_WEEK) {
            return qVar.mo337k();
        }
        return AbstractC0381r.m331d(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.DAY_OF_WEEK) {
            return getValue();
        }
        return AbstractC0381r.m334a(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.DAY_OF_WEEK) {
            return getValue();
        }
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.DAYS;
        }
        return AbstractC0381r.m332c(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(getValue(), EnumC0364a.DAY_OF_WEEK);
    }
}
