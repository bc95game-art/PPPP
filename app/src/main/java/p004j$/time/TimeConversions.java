package p004j$.time;

import java.time.Duration;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.time.TimeConversions */
/* loaded from: classes2.dex */
public class TimeConversions {
    public static Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        long seconds = duration.getSeconds();
        long nano = duration.getNano();
        Duration duration2 = Duration.f41c;
        return Duration.m498i(AbstractC0279a.m547R(seconds, AbstractC0279a.m543V(nano, 1000000000L)), (int) AbstractC0279a.m544U(nano, 1000000000L));
    }

    public static Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        return Duration.ofSeconds(duration.f42a, duration.f43b);
    }
}
