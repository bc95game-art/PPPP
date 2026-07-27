package p004j$.util;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Map;
import p004j$.util.concurrent.AbstractC0429u;
import p004j$.util.concurrent.C0428t;
/* renamed from: j$.util.h */
/* loaded from: classes2.dex */
public final class C0453h implements Map, Serializable, Map {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: a */
    public final Map f423a;

    /* renamed from: b */
    public final C0453h f424b = this;

    /* renamed from: c */
    public transient C0456i f425c;

    /* renamed from: d */
    public transient C0456i f426d;

    /* renamed from: e */
    public transient C0450g f427e;

    public C0453h(Map map) {
        this.f423a = (Map) Objects.requireNonNull(map);
    }

    @Override // java.util.Map
    public final int size() {
        int size;
        synchronized (this.f424b) {
            size = this.f423a.size();
        }
        return size;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f424b) {
            isEmpty = this.f423a.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.f424b) {
            containsKey = this.f423a.containsKey(obj);
        }
        return containsKey;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.f424b) {
            containsValue = this.f423a.containsValue(obj);
        }
        return containsValue;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        synchronized (this.f424b) {
            obj2 = this.f423a.get(obj);
        }
        return obj2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        Object put;
        synchronized (this.f424b) {
            put = this.f423a.put(obj, obj2);
        }
        return put;
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        Object remove;
        synchronized (this.f424b) {
            remove = this.f423a.remove(obj);
        }
        return remove;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        synchronized (this.f424b) {
            this.f423a.putAll(map);
        }
    }

    @Override // java.util.Map
    public final void clear() {
        synchronized (this.f424b) {
            this.f423a.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [j$.util.g, j$.util.i] */
    @Override // java.util.Map
    public final Set keySet() {
        C0456i iVar;
        synchronized (this.f424b) {
            try {
                if (this.f425c == null) {
                    this.f425c = new C0450g(this.f423a.keySet(), this.f424b);
                }
                iVar = this.f425c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [j$.util.g, j$.util.i] */
    @Override // java.util.Map
    public final Set entrySet() {
        C0456i iVar;
        synchronized (this.f424b) {
            try {
                if (this.f426d == null) {
                    this.f426d = new C0450g(this.f423a.entrySet(), this.f424b);
                }
                iVar = this.f426d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    @Override // java.util.Map
    public final Collection values() {
        C0450g gVar;
        synchronized (this.f424b) {
            try {
                if (this.f427e == null) {
                    this.f427e = new C0450g(this.f423a.values(), this.f424b);
                }
                gVar = this.f427e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f424b) {
            equals = this.f423a.equals(obj);
        }
        return equals;
    }

    @Override // java.util.Map
    public final int hashCode() {
        int hashCode;
        synchronized (this.f424b) {
            hashCode = this.f423a.hashCode();
        }
        return hashCode;
    }

    public final String toString() {
        String obj;
        synchronized (this.f424b) {
            obj = this.f423a.toString();
        }
        return obj;
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object P;
        synchronized (this.f424b) {
            P = AbstractC0279a.m549P(this.f423a, obj, obj2);
        }
        return P;
    }

    @Override // java.util.Map, p004j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        synchronized (this.f424b) {
            AbstractC0279a.m552M(this.f423a, biConsumer);
        }
    }

    @Override // java.util.Map, p004j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        synchronized (this.f424b) {
            Map map = this.f423a;
            if (map instanceof Map) {
                ((Map) map).replaceAll(biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(biFunction);
                C0428t tVar = new C0428t(0, concurrentMap, biFunction);
                if (concurrentMap instanceof AbstractC0429u) {
                    ((AbstractC0429u) concurrentMap).forEach(tVar);
                } else {
                    AbstractC0279a.m525j(concurrentMap, tVar);
                }
            } else {
                Map.CC.$default$replaceAll(map, biFunction);
            }
        }
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        Object a0;
        synchronized (this.f424b) {
            a0 = AbstractC0279a.m537a0(this.f423a, obj, obj2);
        }
        return a0;
    }

    @Override // java.util.Map, p004j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        boolean remove;
        synchronized (this.f424b) {
            java.util.Map map = this.f423a;
            remove = map instanceof Map ? ((Map) map).remove(obj, obj2) : Map.CC.$default$remove(map, obj, obj2);
        }
        return remove;
    }

    @Override // java.util.Map, p004j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        boolean replace;
        synchronized (this.f424b) {
            java.util.Map map = this.f423a;
            replace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
        }
        return replace;
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        Object replace;
        synchronized (this.f424b) {
            java.util.Map map = this.f423a;
            replace = map instanceof Map ? ((Map) map).replace(obj, obj2) : map.get(obj);
        }
        return replace;
    }

    @Override // java.util.Map, p004j$.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        Object obj2;
        Object apply;
        synchronized (this.f424b) {
            java.util.Map map = this.f423a;
            if (map instanceof Map) {
                obj2 = ((Map) map).computeIfAbsent(obj, function);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(function);
                Object obj3 = concurrentMap.get(obj);
                if (obj3 != null || (apply = function.apply(obj)) == null) {
                    obj2 = obj3;
                } else {
                    obj2 = concurrentMap.putIfAbsent(obj, apply);
                    if (obj2 == null) {
                        obj2 = apply;
                    }
                }
            } else {
                obj2 = Map.CC.$default$computeIfAbsent(map, obj, function);
            }
        }
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        r5 = r3;
     */
    @Override // java.util.Map, p004j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        Object obj2;
        synchronized (this.f424b) {
            java.util.Map map = this.f423a;
            if (map instanceof Map) {
                obj2 = ((Map) map).computeIfPresent(obj, biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(biFunction);
                while (true) {
                    Object obj3 = concurrentMap.get(obj);
                    if (obj3 == null) {
                        obj2 = null;
                        break;
                    }
                    Object apply = biFunction.apply(obj, obj3);
                    if (apply == null) {
                        if (concurrentMap.remove(obj, obj3)) {
                            break;
                        }
                    } else if (concurrentMap.replace(obj, obj3, apply)) {
                        break;
                    }
                }
            } else {
                obj2 = Map.CC.$default$computeIfPresent(map, obj, biFunction);
            }
        }
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        r5 = r3;
     */
    @Override // java.util.Map, p004j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object compute(Object obj, BiFunction biFunction) {
        Object obj2;
        synchronized (this.f424b) {
            java.util.Map map = this.f423a;
            if (map instanceof Map) {
                obj2 = ((Map) map).compute(obj, biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                loop0: while (true) {
                    Object obj3 = concurrentMap.get(obj);
                    while (true) {
                        Object apply = biFunction.apply(obj, obj3);
                        if (apply != null) {
                            if (obj3 == null) {
                                obj3 = concurrentMap.putIfAbsent(obj, apply);
                                if (obj3 == null) {
                                    break loop0;
                                }
                            } else if (concurrentMap.replace(obj, obj3, apply)) {
                                break;
                            }
                        } else if (obj3 == null || concurrentMap.remove(obj, obj3)) {
                            break;
                        }
                    }
                }
                obj2 = null;
            } else {
                obj2 = Map.CC.$default$compute(map, obj, biFunction);
            }
        }
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        r3 = r7.apply(r2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r3 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r1.replace(r5, r2, r3) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r1.remove(r5, r2) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
        r6 = null;
     */
    @Override // java.util.Map, p004j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        synchronized (this.f424b) {
            java.util.Map map = this.f423a;
            if (map instanceof Map) {
                obj2 = ((Map) map).merge(obj, obj2, biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(biFunction);
                Objects.requireNonNull(obj2);
                loop0: while (true) {
                    Object obj3 = concurrentMap.get(obj);
                    while (true) {
                        if (obj3 != null) {
                            break;
                        }
                        obj3 = concurrentMap.putIfAbsent(obj, obj2);
                        if (obj3 == null) {
                            break loop0;
                        }
                    }
                }
            } else {
                obj2 = Map.CC.$default$merge(map, obj, obj2, biFunction);
            }
        }
        return obj2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f424b) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
