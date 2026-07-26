package p004j$.util;
/* renamed from: j$.util.a0 */
/* loaded from: classes2.dex */
public final class C0401a0 {

    /* renamed from: c */
    public static final C0401a0 f300c = new C0401a0();

    /* renamed from: a */
    public final boolean f301a;

    /* renamed from: b */
    public final int f302b;

    public C0401a0() {
        this.f301a = false;
        this.f302b = 0;
    }

    public C0401a0(int i) {
        this.f301a = true;
        this.f302b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0401a0)) {
            return false;
        }
        C0401a0 a0Var = (C0401a0) obj;
        boolean z = a0Var.f301a;
        boolean z2 = this.f301a;
        return (!z2 || !z) ? z2 == z : this.f302b == a0Var.f302b;
    }

    public final int hashCode() {
        if (this.f301a) {
            return this.f302b;
        }
        return 0;
    }

    public final String toString() {
        if (!this.f301a) {
            return "OptionalInt.empty";
        }
        return "OptionalInt[" + this.f302b + "]";
    }
}
