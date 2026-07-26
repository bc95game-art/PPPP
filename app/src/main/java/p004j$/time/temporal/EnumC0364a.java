package p004j$.time.temporal;
/* renamed from: j$.time.temporal.a */
/* loaded from: classes2.dex */
public enum EnumC0364a implements AbstractC0380q {
    NANO_OF_SECOND("NanoOfSecond", C0384u.m325e(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", C0384u.m325e(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", C0384u.m325e(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", C0384u.m325e(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", C0384u.m325e(0, 999)),
    MILLI_OF_DAY("MilliOfDay", C0384u.m325e(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", C0384u.m325e(0, 59), 0),
    SECOND_OF_DAY("SecondOfDay", C0384u.m325e(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", C0384u.m325e(0, 59), 0),
    MINUTE_OF_DAY("MinuteOfDay", C0384u.m325e(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", C0384u.m325e(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", C0384u.m325e(1, 12)),
    HOUR_OF_DAY("HourOfDay", C0384u.m325e(0, 23), 0),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", C0384u.m325e(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", C0384u.m325e(0, 1), 0),
    DAY_OF_WEEK("DayOfWeek", C0384u.m325e(1, 7), 0),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", C0384u.m325e(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", C0384u.m325e(1, 7)),
    DAY_OF_MONTH("DayOfMonth", C0384u.m324f(28, 31), 0),
    DAY_OF_YEAR("DayOfYear", C0384u.m324f(365, 366)),
    EPOCH_DAY("EpochDay", C0384u.m325e(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", C0384u.m324f(4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", C0384u.m325e(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", C0384u.m325e(1, 12), 0),
    PROLEPTIC_MONTH("ProlepticMonth", C0384u.m325e(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", C0384u.m324f(999999999, 1000000000)),
    YEAR("Year", C0384u.m325e(-999999999, 999999999), 0),
    ERA("Era", C0384u.m325e(0, 1), 0),
    INSTANT_SECONDS("InstantSeconds", C0384u.m325e(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", C0384u.m325e(-64800, 64800));
    

    /* renamed from: a */
    public final String f212a;

    /* renamed from: b */
    public final C0384u f213b;

    static {
        EnumC0365b bVar = EnumC0365b.NANOS;
    }

    EnumC0364a(String str, C0384u uVar) {
        this.f212a = str;
        this.f213b = uVar;
    }

    EnumC0364a(String str, C0384u uVar, int i) {
        this.f212a = str;
        this.f213b = uVar;
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: k */
    public final C0384u mo337k() {
        return this.f213b;
    }

    /* renamed from: s */
    public final void m344s(long j) {
        this.f213b.m328b(j, this);
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    public final boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    /* renamed from: w */
    public final boolean m343w() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: i */
    public final boolean mo339i(AbstractC0377n nVar) {
        return nVar.mo299e(this);
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: j */
    public final C0384u mo338j(AbstractC0377n nVar) {
        return nVar.mo296k(this);
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: l */
    public final long mo336l(AbstractC0377n nVar) {
        return nVar.mo293w(this);
    }

    @Override // p004j$.time.temporal.AbstractC0380q
    /* renamed from: o */
    public final AbstractC0376m mo335o(AbstractC0376m mVar, long j) {
        return mVar.mo313c(j, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f212a;
    }
}
