package p004j$.time.temporal;

import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.time.temporal.k */
/* loaded from: classes2.dex */
public enum EnumC0374k implements AbstractC0380q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);
    
    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a */
    public final transient String f225a;

    /* renamed from: b */
    public final transient C0384u f226b;

    /* renamed from: c */
    public final transient long f227c;

    @Override // p004j$.time.temporal.AbstractC0380q
    public final boolean isDateBased() {
        return true;
    }

    static {
        EnumC0365b bVar = EnumC0365b.NANOS;
    }

    EnumC0374k(String str, long j) {
        this.f225a = str;
        this.f226b = C0384u.m325e((-365243219162L) + j, 365241780471L + j);
        this.f227c = j;
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: k */
    public final C0384u mo337k() {
        return this.f226b;
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: o */
    public final AbstractC0376m mo335o(AbstractC0376m mVar, long j) {
        if (this.f226b.m326d(j)) {
            return mVar.mo313c(AbstractC0279a.m542W(j, this.f227c), EnumC0364a.EPOCH_DAY);
        }
        throw new RuntimeException("Invalid value: " + this.f225a + " " + j);
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: i */
    public final boolean mo339i(AbstractC0377n nVar) {
        return nVar.mo299e(EnumC0364a.EPOCH_DAY);
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: j */
    public final C0384u mo338j(AbstractC0377n nVar) {
        if (nVar.mo299e(EnumC0364a.EPOCH_DAY)) {
            return this.f226b;
        }
        throw new RuntimeException("Unsupported field: " + this);
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: l */
    public final long mo336l(AbstractC0377n nVar) {
        return nVar.mo293w(EnumC0364a.EPOCH_DAY) + this.f227c;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f225a;
    }
}
