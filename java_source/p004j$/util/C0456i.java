package p004j$.util;

import java.util.Set;
/* renamed from: j$.util.i */
/* loaded from: classes2.dex */
public final class C0456i extends C0450g implements Set, Set {
    private static final long serialVersionUID = 487447009682186044L;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f417b) {
            equals = this.f416a.equals(obj);
        }
        return equals;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int hashCode;
        synchronized (this.f417b) {
            hashCode = this.f416a.hashCode();
        }
        return hashCode;
    }
}
