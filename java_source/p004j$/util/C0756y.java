package p004j$.util;
/* renamed from: j$.util.y */
/* loaded from: classes2.dex */
public final class C0756y {

    /* renamed from: b */
    public static final C0756y f882b = new C0756y();

    /* renamed from: a */
    public final Object f883a;

    public C0756y() {
        this.f883a = null;
    }

    public C0756y(Object obj) {
        this.f883a = Objects.requireNonNull(obj);
    }

    public final int hashCode() {
        Object obj = this.f883a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0756y)) {
            return false;
        }
        return Objects.equals(this.f883a, ((C0756y) obj).f883a);
    }

    public final String toString() {
        Object obj = this.f883a;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }
}
