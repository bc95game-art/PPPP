package p004j$.util.concurrent;

import java.util.Map;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.concurrent.l */
/* loaded from: classes2.dex */
public class C0420l implements Map.Entry {

    /* renamed from: a */
    public final int f346a;

    /* renamed from: b */
    public final Object f347b;

    /* renamed from: c */
    public volatile Object f348c;

    /* renamed from: d */
    public volatile C0420l f349d;

    public C0420l(int i, Object obj, Object obj2) {
        this.f346a = i;
        this.f347b = obj;
        this.f348c = obj2;
    }

    public C0420l(int i, Object obj, Object obj2, C0420l lVar) {
        this(i, obj, obj2);
        this.f349d = lVar;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f347b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f348c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f347b.hashCode() ^ this.f348c.hashCode();
    }

    public final String toString() {
        return AbstractC0279a.m541X(this.f347b, this.f348c);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f347b;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f348c;
        return value == obj3 || value.equals(obj3);
    }

    /* renamed from: a */
    public C0420l mo240a(int i, Object obj) {
        Object obj2;
        C0420l lVar = this;
        do {
            if (lVar.f346a == i && ((obj2 = lVar.f347b) == obj || (obj2 != null && obj.equals(obj2)))) {
                return lVar;
            }
            lVar = lVar.f349d;
        } while (lVar != null);
        return null;
    }
}
