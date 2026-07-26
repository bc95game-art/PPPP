package p004j$.util;
/* renamed from: j$.util.z */
/* loaded from: classes2.dex */
public final class C0758z {

    /* renamed from: c */
    public static final C0758z f884c = new C0758z();

    /* renamed from: a */
    public final boolean f885a;

    /* renamed from: b */
    public final double f886b;

    public C0758z() {
        this.f885a = false;
        this.f886b = Double.NaN;
    }

    public C0758z(double d) {
        this.f885a = true;
        this.f886b = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0758z)) {
            return false;
        }
        C0758z zVar = (C0758z) obj;
        boolean z = zVar.f885a;
        boolean z2 = this.f885a;
        return (!z2 || !z) ? z2 == z : Double.compare(this.f886b, zVar.f886b) == 0;
    }

    public final int hashCode() {
        if (!this.f885a) {
            return 0;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.f886b);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public final String toString() {
        if (!this.f885a) {
            return "OptionalDouble.empty";
        }
        return "OptionalDouble[" + this.f886b + "]";
    }
}
