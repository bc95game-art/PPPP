package p004j$.util;
/* renamed from: j$.util.b0 */
/* loaded from: classes2.dex */
public final class C0404b0 {

    /* renamed from: c */
    public static final C0404b0 f304c = new C0404b0();

    /* renamed from: a */
    public final boolean f305a;

    /* renamed from: b */
    public final long f306b;

    public C0404b0() {
        this.f305a = false;
        this.f306b = 0L;
    }

    public C0404b0(long j) {
        this.f305a = true;
        this.f306b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0404b0)) {
            return false;
        }
        C0404b0 b0Var = (C0404b0) obj;
        boolean z = b0Var.f305a;
        boolean z2 = this.f305a;
        return (!z2 || !z) ? z2 == z : this.f306b == b0Var.f306b;
    }

    public final int hashCode() {
        if (!this.f305a) {
            return 0;
        }
        long j = this.f306b;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        if (!this.f305a) {
            return "OptionalLong.empty";
        }
        return "OptionalLong[" + this.f306b + "]";
    }
}
