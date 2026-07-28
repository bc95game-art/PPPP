package p004j$.time.temporal;

import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.Duration;
/* renamed from: j$.time.temporal.i */
/* loaded from: classes2.dex */
public enum EnumC0372i implements AbstractC0382s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");
    

    /* renamed from: a */
    public final String f220a;

    static {
        Duration.m498i(31556952L, 0);
        Duration.m498i(7889238L, 0);
    }

    EnumC0372i(String str) {
        this.f220a = str;
    }

    @Override // p004j$.time.temporal.AbstractC0382s
    /* renamed from: i */
    public final AbstractC0376m mo330i(AbstractC0376m mVar, long j) {
        int i = AbstractC0366c.f216a[ordinal()];
        if (i == 1) {
            EnumC0371h hVar = AbstractC0373j.f223c;
            return mVar.mo313c(AbstractC0279a.m547R(mVar.mo297i(hVar), j), hVar);
        } else if (i == 2) {
            return mVar.mo886d(j / 4, EnumC0365b.YEARS).mo886d((j % 4) * 3, EnumC0365b.MONTHS);
        } else {
            throw new IllegalStateException("Unreachable");
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f220a;
    }
}
