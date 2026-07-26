package p004j$.time.temporal;

import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.C0350g;
import p004j$.time.EnumC0285c;
import p004j$.time.chrono.C0317t;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.temporal.h */
/* loaded from: classes2.dex */
public abstract class EnumC0371h extends Enum implements AbstractC0380q {
    public static final EnumC0371h DAY_OF_QUARTER;
    public static final EnumC0371h QUARTER_OF_YEAR;
    public static final EnumC0371h WEEK_BASED_YEAR;
    public static final EnumC0371h WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: a */
    public static final int[] f217a = {0, 90, 181, 273, 0, 91, 182, 274};

    /* renamed from: b */
    public static final /* synthetic */ EnumC0371h[] f218b;

    @Override // p004j$.time.temporal.AbstractC0380q
    public final boolean isDateBased() {
        return true;
    }

    public static EnumC0371h valueOf(String str) {
        return (EnumC0371h) Enum.valueOf(EnumC0371h.class, str);
    }

    public static EnumC0371h[] values() {
        return (EnumC0371h[]) f218b.clone();
    }

    static {
        EnumC0371h dVar = new EnumC0371h() { // from class: j$.time.temporal.d
            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: k */
            public final C0384u mo337k() {
                return C0384u.m324f(90L, 92L);
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: i */
            public final boolean mo339i(AbstractC0377n nVar) {
                if (!nVar.mo299e(EnumC0364a.DAY_OF_YEAR) || !nVar.mo299e(EnumC0364a.MONTH_OF_YEAR) || !nVar.mo299e(EnumC0364a.YEAR)) {
                    return false;
                }
                EnumC0371h hVar = AbstractC0373j.f221a;
                return AbstractC0279a.m550O(nVar).equals(C0317t.f100c);
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: j */
            public final C0384u mo338j(AbstractC0377n nVar) {
                if (mo339i(nVar)) {
                    long w = nVar.mo293w(EnumC0371h.QUARTER_OF_YEAR);
                    if (w == 1) {
                        long w2 = nVar.mo293w(EnumC0364a.YEAR);
                        C0317t.f100c.getClass();
                        return C0317t.m451j(w2) ? C0384u.m325e(1L, 91L) : C0384u.m325e(1L, 90L);
                    } else if (w == 2) {
                        return C0384u.m325e(1L, 91L);
                    } else {
                        if (w == 3 || w == 4) {
                            return C0384u.m325e(1L, 92L);
                        }
                        return mo337k();
                    }
                } else {
                    throw new RuntimeException("Unsupported field: DayOfQuarter");
                }
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: l */
            public final long mo336l(AbstractC0377n nVar) {
                if (mo339i(nVar)) {
                    int i = nVar.mo297i(EnumC0364a.DAY_OF_YEAR);
                    int i2 = nVar.mo297i(EnumC0364a.MONTH_OF_YEAR);
                    long w = nVar.mo293w(EnumC0364a.YEAR);
                    int i3 = (i2 - 1) / 3;
                    C0317t.f100c.getClass();
                    return i - EnumC0371h.f217a[i3 + (C0317t.m451j(w) ? 4 : 0)];
                }
                throw new RuntimeException("Unsupported field: DayOfQuarter");
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: o */
            public final AbstractC0376m mo335o(AbstractC0376m mVar, long j) {
                long l = mo336l(mVar);
                mo337k().m328b(j, this);
                EnumC0364a aVar = EnumC0364a.DAY_OF_YEAR;
                return mVar.mo313c((j - l) + mVar.mo293w(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = dVar;
        EnumC0371h eVar = new EnumC0371h() { // from class: j$.time.temporal.e
            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: k */
            public final C0384u mo337k() {
                return C0384u.m325e(1L, 4L);
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: i */
            public final boolean mo339i(AbstractC0377n nVar) {
                if (!nVar.mo299e(EnumC0364a.MONTH_OF_YEAR)) {
                    return false;
                }
                EnumC0371h hVar = AbstractC0373j.f221a;
                return AbstractC0279a.m550O(nVar).equals(C0317t.f100c);
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: l */
            public final long mo336l(AbstractC0377n nVar) {
                if (mo339i(nVar)) {
                    return (nVar.mo293w(EnumC0364a.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new RuntimeException("Unsupported field: QuarterOfYear");
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: j */
            public final C0384u mo338j(AbstractC0377n nVar) {
                if (mo339i(nVar)) {
                    return mo337k();
                }
                throw new RuntimeException("Unsupported field: QuarterOfYear");
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: o */
            public final AbstractC0376m mo335o(AbstractC0376m mVar, long j) {
                long l = mo336l(mVar);
                mo337k().m328b(j, this);
                EnumC0364a aVar = EnumC0364a.MONTH_OF_YEAR;
                return mVar.mo313c(((j - l) * 3) + mVar.mo293w(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = eVar;
        EnumC0371h fVar = new EnumC0371h() { // from class: j$.time.temporal.f
            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: k */
            public final C0384u mo337k() {
                return C0384u.m324f(52L, 53L);
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: i */
            public final boolean mo339i(AbstractC0377n nVar) {
                if (!nVar.mo299e(EnumC0364a.EPOCH_DAY)) {
                    return false;
                }
                EnumC0371h hVar = AbstractC0373j.f221a;
                return AbstractC0279a.m550O(nVar).equals(C0317t.f100c);
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: j */
            public final C0384u mo338j(AbstractC0377n nVar) {
                if (mo339i(nVar)) {
                    return C0384u.m325e(1L, EnumC0371h.m342C(EnumC0371h.m340w(C0350g.m404E(nVar))));
                }
                throw new RuntimeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: l */
            public final long mo336l(AbstractC0377n nVar) {
                if (mo339i(nVar)) {
                    return EnumC0371h.m341s(C0350g.m404E(nVar));
                }
                throw new RuntimeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: o */
            public final AbstractC0376m mo335o(AbstractC0376m mVar, long j) {
                mo337k().m328b(j, this);
                return mVar.mo886d(AbstractC0279a.m542W(j, mo336l(mVar)), EnumC0365b.WEEKS);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = fVar;
        EnumC0371h gVar = new EnumC0371h() { // from class: j$.time.temporal.g
            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: k */
            public final C0384u mo337k() {
                return EnumC0364a.YEAR.f213b;
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: i */
            public final boolean mo339i(AbstractC0377n nVar) {
                if (!nVar.mo299e(EnumC0364a.EPOCH_DAY)) {
                    return false;
                }
                EnumC0371h hVar = AbstractC0373j.f221a;
                return AbstractC0279a.m550O(nVar).equals(C0317t.f100c);
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: l */
            public final long mo336l(AbstractC0377n nVar) {
                if (mo339i(nVar)) {
                    return EnumC0371h.m340w(C0350g.m404E(nVar));
                }
                throw new RuntimeException("Unsupported field: WeekBasedYear");
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: j */
            public final C0384u mo338j(AbstractC0377n nVar) {
                if (mo339i(nVar)) {
                    return mo337k();
                }
                throw new RuntimeException("Unsupported field: WeekBasedYear");
            }

            @Override // p004j$.time.temporal.AbstractC0380q
            /* renamed from: o */
            public final AbstractC0376m mo335o(AbstractC0376m mVar, long j) {
                if (mo339i(mVar)) {
                    int a = EnumC0364a.YEAR.f213b.m329a(j, EnumC0371h.WEEK_BASED_YEAR);
                    C0350g E = C0350g.m404E(mVar);
                    EnumC0364a aVar = EnumC0364a.DAY_OF_WEEK;
                    int i = E.mo297i(aVar);
                    int s = EnumC0371h.m341s(E);
                    if (s == 53 && EnumC0371h.m342C(a) == 52) {
                        s = 52;
                    }
                    C0350g K = C0350g.m398K(a, 1, 4);
                    return mVar.mo311j(K.m395N(((s - 1) * 7) + (i - K.mo297i(aVar))));
                }
                throw new RuntimeException("Unsupported field: WeekBasedYear");
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = gVar;
        f218b = new EnumC0371h[]{dVar, eVar, fVar, gVar};
    }

    /* renamed from: C */
    public static int m342C(int i) {
        C0350g K = C0350g.m398K(i, 1, 1);
        if (K.m402G() != EnumC0285c.THURSDAY) {
            return (K.m402G() != EnumC0285c.WEDNESDAY || !K.m400I()) ? 52 : 53;
        }
        return 53;
    }

    /* renamed from: s */
    public static int m341s(C0350g gVar) {
        int ordinal = gVar.m402G().ordinal();
        int H = gVar.m401H() - 1;
        int i = (3 - ordinal) + H;
        int i2 = i - ((i / 7) * 7);
        int i3 = i2 - 3;
        if (i3 < -3) {
            i3 = i2 + 4;
        }
        if (H < i3) {
            return (int) C0384u.m325e(1L, m342C(m340w(gVar.m389T(180).m393P(-1L)))).f241d;
        }
        int i4 = ((H - i3) / 7) + 1;
        if (i4 != 53 || i3 == -3 || (i3 == -2 && gVar.m400I())) {
            return i4;
        }
        return 1;
    }

    /* renamed from: w */
    public static int m340w(C0350g gVar) {
        int i = gVar.f173a;
        int H = gVar.m401H();
        if (H <= 3) {
            return H - gVar.m402G().ordinal() < -2 ? i - 1 : i;
        }
        if (H < 363) {
            return i;
        }
        return ((H - 363) - (gVar.m400I() ? 1 : 0)) - gVar.m402G().ordinal() >= 0 ? i + 1 : i;
    }
}
