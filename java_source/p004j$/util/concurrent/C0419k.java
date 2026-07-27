package p004j$.util.concurrent;

import java.util.Map;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.concurrent.k */
/* loaded from: classes2.dex */
public final class C0419k implements Map.Entry {

    /* renamed from: a */
    public final Object f343a;

    /* renamed from: b */
    public Object f344b;

    /* renamed from: c */
    public final ConcurrentHashMap f345c;

    public C0419k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
        this.f343a = obj;
        this.f344b = obj2;
        this.f345c = concurrentHashMap;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f343a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f344b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f343a.hashCode() ^ this.f344b.hashCode();
    }

    public final String toString() {
        return AbstractC0279a.m541X(this.f343a, this.f344b);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f343a;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f344b;
        return value == obj3 || value.equals(obj3);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        obj.getClass();
        Object obj2 = this.f344b;
        this.f344b = obj;
        this.f345c.put(this.f343a, obj);
        return obj2;
    }
}
