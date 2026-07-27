package p004j$.util;

import java.util.Map;
/* renamed from: j$.util.o */
/* loaded from: classes2.dex */
public final class C0474o implements Map.Entry {

    /* renamed from: a */
    public final Map.Entry f453a;

    public C0474o(Map.Entry entry) {
        this.f453a = (Map.Entry) Objects.requireNonNull(entry);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f453a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f453a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f453a.hashCode();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this != obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = this.f453a.getKey();
                Object key2 = entry.getKey();
                if (key == null) {
                    z = key2 == null;
                } else {
                    z = key.equals(key2);
                }
                if (z) {
                    Object value = this.f453a.getValue();
                    Object value2 = entry.getValue();
                    if (value == null) {
                        z2 = value2 == null;
                    } else {
                        z2 = value.equals(value2);
                    }
                    if (z2) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final String toString() {
        return this.f453a.toString();
    }
}
