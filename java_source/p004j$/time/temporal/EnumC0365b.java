package p004j$.time.temporal;

import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.Duration;
/* renamed from: j$.time.temporal.b */
/* loaded from: classes2.dex */
public enum EnumC0365b implements AbstractC0382s {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");
    

    /* renamed from: a */
    public final String f215a;

    static {
        Duration.m497j(1L);
        Duration.m497j(1000L);
        Duration.m497j(1000000L);
        Duration.m498i(1L, 0);
        Duration.m498i(60L, 0);
        Duration.m498i(3600L, 0);
        Duration.m498i(43200L, 0);
        Duration.m498i(86400L, 0);
        Duration.m498i(604800L, 0);
        Duration.m498i(2629746L, 0);
        Duration.m498i(31556952L, 0);
        Duration.m498i(315569520L, 0);
        Duration.m498i(3155695200L, 0);
        Duration.m498i(31556952000L, 0);
        Duration.m498i(31556952000000000L, 0);
        Duration.m498i(AbstractC0279a.m547R(Long.MAX_VALUE, AbstractC0279a.m543V(999999999L, 1000000000L)), (int) AbstractC0279a.m544U(999999999L, 1000000000L));
    }

    EnumC0365b(String str) {
        this.f215a = str;
    }

    @Override // p004j$.time.temporal.AbstractC0382s
    /* renamed from: i */
    public final AbstractC0376m mo330i(AbstractC0376m mVar, long j) {
        return mVar.mo886d(j, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f215a;
    }
}
