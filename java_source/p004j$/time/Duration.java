package p004j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.time.Duration */
/* loaded from: classes2.dex */
public final class Duration implements Comparable<Duration>, Serializable {

    /* renamed from: c */
    public static final Duration f41c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a */
    public final long f42a;

    /* renamed from: b */
    public final int f43b;

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int compare = Long.compare(this.f42a, duration2.f42a);
        return compare != 0 ? compare : this.f43b - duration2.f43b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static Duration ofMillis(long j) {
        long j2 = j / 1000;
        int i = (int) (j % 1000);
        if (i < 0) {
            i += 1000;
            j2--;
        }
        return m498i(j2, i * 1000000);
    }

    /* renamed from: j */
    public static Duration m497j(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i = (int) (i + 1000000000);
            j2--;
        }
        return m498i(j2, i);
    }

    /* renamed from: i */
    public static Duration m498i(long j, int i) {
        if ((i | j) == 0) {
            return f41c;
        }
        return new Duration(j, i);
    }

    public Duration(long j, int i) {
        this.f42a = j;
        this.f43b = i;
    }

    public long toMillis() {
        long j = this.f42a;
        long j2 = this.f43b;
        if (j < 0) {
            j++;
            j2 -= 1000000000;
        }
        return AbstractC0279a.m547R(AbstractC0279a.m548Q(j, 1000), j2 / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.f42a == duration.f42a && this.f43b == duration.f43b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f42a;
        return (this.f43b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        if (this == f41c) {
            return "PT0S";
        }
        long j = this.f42a;
        if (j < 0 && this.f43b > 0) {
            j++;
        }
        long j2 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i2 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i2 == 0 && this.f43b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.f42a >= 0 || this.f43b <= 0) {
            sb.append(i2);
        } else if (i2 == 0) {
            sb.append("-0");
        } else {
            sb.append(i2);
        }
        if (this.f43b > 0) {
            int length = sb.length();
            if (this.f42a < 0) {
                sb.append(2000000000 - this.f43b);
            } else {
                sb.append(this.f43b + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new C0363t((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
