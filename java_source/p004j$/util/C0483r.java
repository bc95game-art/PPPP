package p004j$.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.r */
/* loaded from: classes2.dex */
public final class C0483r implements Map, Serializable, Map {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: a */
    public final Map f467a;

    /* renamed from: b */
    public transient Set f468b;

    /* renamed from: c */
    public transient C0480q f469c;

    /* renamed from: d */
    public transient C0462k f470d;

    public C0483r(Map map) {
        map.getClass();
        this.f467a = map;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f467a.size();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f467a.isEmpty();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f467a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f467a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f467a.get(obj);
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f468b == null) {
            this.f468b = DesugarCollections.unmodifiableSet(this.f467a.keySet());
        }
        return this.f468b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.q, j$.util.k] */
    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f469c == null) {
            this.f469c = new C0462k(this.f467a.entrySet());
        }
        return this.f469c;
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f470d == null) {
            this.f470d = new C0462k(this.f467a.values());
        }
        return this.f470d;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj == this || this.f467a.equals(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f467a.hashCode();
    }

    public final String toString() {
        return this.f467a.toString();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        return AbstractC0279a.m549P(this.f467a, obj, obj2);
    }

    @Override // java.util.Map, p004j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        AbstractC0279a.m552M(this.f467a, biConsumer);
    }

    @Override // java.util.Map, p004j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }
}
