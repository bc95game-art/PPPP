package p004j$.time.temporal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
/* renamed from: j$.time.temporal.u */
/* loaded from: classes2.dex */
public final class C0384u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a */
    public final long f238a;

    /* renamed from: b */
    public final long f239b;

    /* renamed from: c */
    public final long f240c;

    /* renamed from: d */
    public final long f241d;

    /* renamed from: e */
    public static C0384u m325e(long j, long j2) {
        if (j <= j2) {
            return new C0384u(j, j, j2, j2);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    /* renamed from: f */
    public static C0384u m324f(long j, long j2) {
        if (j > j2) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (1 <= j2) {
            return new C0384u(1L, 1L, j, j2);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public C0384u(long j, long j2, long j3, long j4) {
        this.f238a = j;
        this.f239b = j2;
        this.f240c = j3;
        this.f241d = j4;
    }

    /* renamed from: a */
    public final int m329a(long j, AbstractC0380q qVar) {
        if (this.f238a >= -2147483648L && this.f241d <= 2147483647L && m326d(j)) {
            return (int) j;
        }
        throw new RuntimeException(m327c(j, qVar));
    }

    /* renamed from: d */
    public final boolean m326d(long j) {
        return j >= this.f238a && j <= this.f241d;
    }

    /* renamed from: b */
    public final void m328b(long j, AbstractC0380q qVar) {
        if (!m326d(j)) {
            throw new RuntimeException(m327c(j, qVar));
        }
    }

    /* renamed from: c */
    public final String m327c(long j, AbstractC0380q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j;
        }
        return "Invalid value (valid values " + this + "): " + j;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        long j = this.f238a;
        long j2 = this.f239b;
        if (j <= j2) {
            long j3 = this.f240c;
            long j4 = this.f241d;
            if (j3 > j4) {
                throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
            } else if (j2 > j4) {
                throw new InvalidObjectException("Minimum value must be less than maximum value");
            }
        } else {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0384u) {
            C0384u uVar = (C0384u) obj;
            if (this.f238a == uVar.f238a && this.f239b == uVar.f239b && this.f240c == uVar.f240c && this.f241d == uVar.f241d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f238a;
        long j2 = this.f239b;
        long j3 = j + (j2 << 16) + (j2 >> 48);
        long j4 = this.f240c;
        long j5 = j3 + (j4 << 32) + (j4 >> 32);
        long j6 = this.f241d;
        long j7 = j5 + (j6 << 48) + (j6 >> 16);
        return (int) (j7 ^ (j7 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f238a);
        if (this.f238a != this.f239b) {
            sb.append('/');
            sb.append(this.f239b);
        }
        sb.append(" - ");
        sb.append(this.f240c);
        if (this.f240c != this.f241d) {
            sb.append('/');
            sb.append(this.f241d);
        }
        return sb.toString();
    }
}
