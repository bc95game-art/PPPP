package p004j$.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.sun.misc.C0280a;
/* renamed from: j$.util.concurrent.ConcurrentHashMap */
/* loaded from: classes2.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, AbstractC0429u {

    /* renamed from: g */
    public static final int f312g = Runtime.getRuntime().availableProcessors();

    /* renamed from: h */
    public static final C0280a f313h;

    /* renamed from: i */
    public static final long f314i;

    /* renamed from: j */
    public static final long f315j;

    /* renamed from: k */
    public static final long f316k;

    /* renamed from: l */
    public static final long f317l;

    /* renamed from: m */
    public static final long f318m;

    /* renamed from: n */
    public static final int f319n;

    /* renamed from: o */
    public static final int f320o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a */
    public volatile transient C0420l[] f321a;

    /* renamed from: b */
    public volatile transient C0420l[] f322b;
    private volatile transient long baseCount;

    /* renamed from: c */
    public volatile transient C0411c[] f323c;
    private volatile transient int cellsBusy;

    /* renamed from: d */
    public transient C0417i f324d;

    /* renamed from: e */
    public transient C0427s f325e;

    /* renamed from: f */
    public transient C0413e f326f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    /* renamed from: i */
    public static final int m264i(int i) {
        return (i ^ (i >>> 16)) & Integer.MAX_VALUE;
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", C0422n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        C0280a aVar = C0280a.f39b;
        f313h = aVar;
        f314i = aVar.m501h(ConcurrentHashMap.class, "sizeCtl");
        f315j = aVar.m501h(ConcurrentHashMap.class, "transferIndex");
        f316k = aVar.m501h(ConcurrentHashMap.class, "baseCount");
        f317l = aVar.m501h(ConcurrentHashMap.class, "cellsBusy");
        f318m = aVar.m501h(C0411c.class, "value");
        f319n = aVar.m508a(C0420l[].class);
        int b = aVar.m507b(C0420l[].class);
        if (((b - 1) & b) == 0) {
            f320o = 31 - Integer.numberOfLeadingZeros(b);
            return;
        }
        throw new ExceptionInInitializerError("array index scale not a power of two");
    }

    /* renamed from: l */
    public static final int m261l(int i) {
        int numberOfLeadingZeros = (-1) >>> Integer.numberOfLeadingZeros(i - 1);
        if (numberOfLeadingZeros < 0) {
            return 1;
        }
        if (numberOfLeadingZeros >= 1073741824) {
            return 1073741824;
        }
        return numberOfLeadingZeros + 1;
    }

    /* renamed from: c */
    public static Class m270c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls != String.class) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces == null) {
                return null;
            }
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    }
                }
            }
            return null;
        }
        return cls;
    }

    /* renamed from: k */
    public static final C0420l m262k(C0420l[] lVarArr, int i) {
        return (C0420l) f313h.m503f(lVarArr, (i << f320o) + f319n);
    }

    /* renamed from: b */
    public static final boolean m271b(C0420l[] lVarArr, int i, C0420l lVar) {
        return AbstractC0279a.m545T(f313h.f40a, lVarArr, (i << f320o) + f319n, lVar);
    }

    /* renamed from: h */
    public static final void m265h(C0420l[] lVarArr, int i, C0420l lVar) {
        f313h.m499j(lVarArr, (i << f320o) + f319n, lVar);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i) {
        this(i, 0.75f, 1);
    }

    public ConcurrentHashMap(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        long j = (long) (((i < i2 ? i2 : i) / f) + 1.0d);
        this.sizeCtl = j >= 1073741824 ? 1073741824 : m261l((int) j);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j = m263j();
        if (j < 0) {
            return 0;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return m263j() <= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
        return (V) r1.f348c;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V get(Object obj) {
        int length;
        C0420l k;
        Object obj2;
        int i = m264i(obj.hashCode());
        C0420l[] lVarArr = this.f321a;
        if (lVarArr == null || (length = lVarArr.length) <= 0 || (k = m262k(lVarArr, (length - 1) & i)) == null) {
            return null;
        }
        int i2 = k.f346a;
        if (i2 == i) {
            Object obj3 = k.f347b;
            if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                return (V) k.f348c;
            }
        } else if (i2 < 0) {
            C0420l a = k.mo240a(i, obj);
            if (a != null) {
                return (V) a.f348c;
            }
            return null;
        }
        while (true) {
            k = k.f349d;
            if (k == null) {
                return null;
            }
            if (k.f346a != i || ((obj2 = k.f347b) != obj && (obj2 == null || !obj.equals(obj2)))) {
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        obj.getClass();
        C0420l[] lVarArr = this.f321a;
        if (lVarArr != null) {
            C0424p pVar = new C0424p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                C0420l a = pVar.m249a();
                if (a == null) {
                    break;
                }
                Object obj2 = a.f348c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return (V) m267f(k, v, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b4, code lost:
        m272a(1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00b9, code lost:
        return null;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m267f(Object obj, Object obj2, boolean z) {
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        if (obj == null || obj2 == null) {
            throw null;
        }
        int i = m264i(obj.hashCode());
        C0420l[] lVarArr = this.f321a;
        int i2 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i3 = (length - 1) & i;
                    C0420l k = m262k(lVarArr, i3);
                    if (k != null) {
                        int i4 = k.f346a;
                        if (i4 == -1) {
                            lVarArr = m269d(lVarArr, k);
                        } else if (z && i4 == i && (((obj5 = k.f347b) == obj || (obj5 != null && obj.equals(obj5))) && (obj6 = k.f348c) != null)) {
                            return obj6;
                        } else {
                            synchronized (k) {
                                try {
                                    if (m262k(lVarArr, i3) == k) {
                                        if (i4 < 0) {
                                            if (!(k instanceof C0425q)) {
                                                if (k instanceof C0421m) {
                                                    break;
                                                }
                                            } else {
                                                C0426r e = ((C0425q) k).m245e(i, obj, obj2);
                                                if (e != null) {
                                                    Object obj7 = e.f348c;
                                                    if (!z) {
                                                        e.f348c = obj2;
                                                    }
                                                    obj3 = obj7;
                                                } else {
                                                    obj3 = null;
                                                }
                                                i2 = 2;
                                            }
                                        } else {
                                            i2 = 1;
                                            C0420l lVar = k;
                                            while (true) {
                                                if (lVar.f346a == i && ((obj4 = lVar.f347b) == obj || (obj4 != null && obj.equals(obj4)))) {
                                                    break;
                                                }
                                                C0420l lVar2 = lVar.f349d;
                                                if (lVar2 == null) {
                                                    lVar.f349d = new C0420l(i, obj, obj2);
                                                    break;
                                                }
                                                i2++;
                                                lVar = lVar2;
                                            }
                                            obj3 = lVar.f348c;
                                            if (!z) {
                                                lVar.f348c = obj2;
                                            }
                                        }
                                    }
                                    obj3 = null;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    m259n(lVarArr, i3);
                                }
                                if (obj3 != null) {
                                    return obj3;
                                }
                            }
                        }
                    } else if (m271b(lVarArr, i3, new C0420l(i, obj, obj2))) {
                        break;
                    }
                }
            }
            lVarArr = m268e();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m258o(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            m267f(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) m266g(obj, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m266g(Object obj, Object obj2, Object obj3) {
        int length;
        int i;
        C0420l k;
        Object obj4;
        boolean z;
        C0426r b;
        Object obj5;
        int i2 = m264i(obj.hashCode());
        C0420l[] lVarArr = this.f321a;
        while (true) {
            if (lVarArr == null || (length = lVarArr.length) == 0 || (k = m262k(lVarArr, (i = (length - 1) & i2))) == null) {
                break;
            }
            int i3 = k.f346a;
            if (i3 == -1) {
                lVarArr = m269d(lVarArr, k);
            } else {
                synchronized (k) {
                    try {
                        if (m262k(lVarArr, i) == k) {
                            z = true;
                            if (i3 < 0) {
                                if (!(k instanceof C0425q)) {
                                    if (k instanceof C0421m) {
                                        break;
                                    }
                                } else {
                                    C0425q qVar = (C0425q) k;
                                    C0426r rVar = qVar.f364e;
                                    if (rVar != null && (b = rVar.m239b(i2, obj, null)) != null) {
                                        obj4 = b.f348c;
                                        if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                            if (obj2 != null) {
                                                b.f348c = obj2;
                                            } else if (qVar.m244f(b)) {
                                                m265h(lVarArr, i, m257p(qVar.f365f));
                                            }
                                        }
                                    }
                                    obj4 = null;
                                }
                            } else {
                                C0420l lVar = null;
                                C0420l lVar2 = k;
                                while (true) {
                                    if (lVar2.f346a == i2 && ((obj5 = lVar2.f347b) == obj || (obj5 != null && obj.equals(obj5)))) {
                                        break;
                                    }
                                    C0420l lVar3 = lVar2.f349d;
                                    if (lVar3 == null) {
                                        break;
                                    }
                                    lVar = lVar2;
                                    lVar2 = lVar3;
                                }
                                obj4 = lVar2.f348c;
                                if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                    if (obj2 != null) {
                                        lVar2.f348c = obj2;
                                    } else if (lVar != null) {
                                        lVar.f349d = lVar2.f349d;
                                    } else {
                                        m265h(lVarArr, i, lVar2.f349d);
                                    }
                                }
                                obj4 = null;
                            }
                        }
                        z = false;
                        obj4 = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            m272a(-1L, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        C0420l k;
        C0420l lVar;
        C0420l[] lVarArr = this.f321a;
        long j = 0;
        loop0: while (true) {
            int i = 0;
            while (lVarArr != null && i < lVarArr.length) {
                k = m262k(lVarArr, i);
                if (k == null) {
                    i++;
                } else {
                    int i2 = k.f346a;
                    if (i2 == -1) {
                        break;
                    }
                    synchronized (k) {
                        try {
                            if (m262k(lVarArr, i) == k) {
                                if (i2 >= 0) {
                                    lVar = k;
                                } else {
                                    lVar = k instanceof C0425q ? ((C0425q) k).f365f : null;
                                }
                                while (lVar != null) {
                                    j--;
                                    lVar = lVar.f349d;
                                }
                                i++;
                                m265h(lVarArr, i, null);
                            }
                        } finally {
                        }
                    }
                }
            }
            lVarArr = m269d(lVarArr, k);
        }
        if (j != 0) {
            m272a(j, -1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.concurrent.b, java.util.Set<K>, j$.util.concurrent.i] */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        C0417i iVar = this.f324d;
        if (iVar != null) {
            return iVar;
        }
        ?? r0 = (Set<K>) new AbstractC0410b(this);
        this.f324d = r0;
        return r0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Collection<V>, j$.util.concurrent.b, j$.util.concurrent.s] */
    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        C0427s sVar = this.f325e;
        if (sVar != null) {
            return sVar;
        }
        AbstractC0410b bVar = new AbstractC0410b(this);
        this.f325e = bVar;
        return bVar;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.concurrent.b, j$.util.concurrent.e, java.util.Set] */
    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        C0413e eVar = this.f326f;
        if (eVar != null) {
            return eVar;
        }
        ?? bVar = new AbstractC0410b(this);
        this.f326f = bVar;
        return bVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        C0420l[] lVarArr = this.f321a;
        int i = 0;
        if (lVarArr != null) {
            C0424p pVar = new C0424p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                C0420l a = pVar.m249a();
                if (a == null) {
                    break;
                }
                i += a.f348c.hashCode() ^ a.f347b.hashCode();
            }
        }
        return i;
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        C0420l[] lVarArr = this.f321a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        C0424p pVar = new C0424p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        C0420l a = pVar.m249a();
        if (a != null) {
            while (true) {
                Object obj = a.f347b;
                Object obj2 = a.f348c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                a = pVar.m249a();
                if (a == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        V value;
        V v;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        C0420l[] lVarArr = this.f321a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        C0424p pVar = new C0424p(lVarArr, length, 0, length);
        while (true) {
            C0420l a = pVar.m249a();
            if (a != null) {
                Object obj2 = a.f348c;
                Object obj3 = map.get(a.f347b);
                if (obj3 == null || (obj3 != obj2 && !obj3.equals(obj2))) {
                    break;
                }
            } else {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null || (value != v && !value.equals(v))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i = 1;
        int i2 = 0;
        while (i < 16) {
            i2++;
            i <<= 1;
        }
        int i3 = 32 - i2;
        int i4 = i - 1;
        C0422n[] nVarArr = new C0422n[16];
        for (int i5 = 0; i5 < 16; i5++) {
            nVarArr[i5] = new ReentrantLock();
        }
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("segments", nVarArr);
        putFields.put("segmentShift", i3);
        putFields.put("segmentMask", i4);
        objectOutputStream.writeFields();
        C0420l[] lVarArr = this.f321a;
        if (lVarArr != null) {
            C0424p pVar = new C0424p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                C0420l a = pVar.m249a();
                if (a == null) {
                    break;
                }
                objectOutputStream.writeObject(a.f347b);
                objectOutputStream.writeObject(a.f348c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j;
        long j2;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j3 = 0;
        long j4 = 0;
        C0420l lVar = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j = 1;
            if (readObject == null || readObject2 == null) {
                break;
            }
            j4++;
            lVar = new C0420l(m264i(readObject.hashCode()), readObject, readObject2, lVar);
        }
        if (j4 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j5 = (long) ((((float) j4) / 0.75f) + 1.0d);
        int l = j5 >= 1073741824 ? 1073741824 : m261l((int) j5);
        C0420l[] lVarArr = new C0420l[l];
        int i = l - 1;
        while (lVar != null) {
            C0420l lVar2 = lVar.f349d;
            int i2 = lVar.f346a;
            int i3 = i2 & i;
            C0420l k = m262k(lVarArr, i3);
            boolean z = true;
            if (k == null) {
                j2 = j;
            } else {
                Object obj2 = lVar.f347b;
                if (k.f346a < 0) {
                    if (((C0425q) k).m245e(i2, obj2, lVar.f348c) == null) {
                        j3 += j;
                    }
                    j2 = j;
                } else {
                    j2 = j;
                    int i4 = 0;
                    for (C0420l lVar3 = k; lVar3 != null; lVar3 = lVar3.f349d) {
                        if (lVar3.f346a == i2 && ((obj = lVar3.f347b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z = false;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (z && i4 >= 8) {
                        j3 += j2;
                        lVar.f349d = k;
                        C0420l lVar4 = lVar;
                        C0426r rVar = null;
                        C0426r rVar2 = null;
                        while (lVar4 != null) {
                            C0426r rVar3 = new C0426r(lVar4.f346a, lVar4.f347b, lVar4.f348c, null, null);
                            rVar3.f370h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.f349d = rVar3;
                            }
                            lVar4 = lVar4.f349d;
                            rVar2 = rVar3;
                        }
                        m265h(lVarArr, i3, new C0425q(rVar));
                    }
                }
                z = false;
            }
            if (z) {
                j3 += j2;
                lVar.f349d = k;
                m265h(lVarArr, i3, lVar);
            }
            lVar = lVar2;
            j = j2;
        }
        this.f321a = lVarArr;
        this.sizeCtl = l - (l >>> 2);
        this.baseCount = j3;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    public V putIfAbsent(K k, V v) {
        return (V) m267f(k, v, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || m266g(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj != null && obj2 != null && obj3 != null) {
            return m266g(obj, obj3, obj2) != null;
        }
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return m266g(obj, obj2, null);
        }
        throw null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        V v = get(obj);
        return v == null ? obj2 : v;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        C0420l[] lVarArr = this.f321a;
        if (lVarArr != null) {
            C0424p pVar = new C0424p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                C0420l a = pVar.m249a();
                if (a != null) {
                    biConsumer.accept(a.f347b, a.f348c);
                } else {
                    return;
                }
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        C0420l[] lVarArr = this.f321a;
        if (lVarArr != null) {
            C0424p pVar = new C0424p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                C0420l a = pVar.m249a();
                if (a != null) {
                    Object obj = a.f348c;
                    Object obj2 = a.f347b;
                    do {
                        Object apply = biFunction.apply(obj2, obj);
                        apply.getClass();
                        if (m266g(obj2, apply, obj) == null) {
                            obj = get(obj2);
                        }
                    } while (obj != null);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x00f0, code lost:
        if (r5 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00f2, code lost:
        m272a(1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00f7, code lost:
        return r5;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object computeIfAbsent(Object obj, Function function) {
        C0420l lVar;
        C0426r b;
        Object obj2;
        Object obj3;
        Object obj4;
        if (obj == null || function == null) {
            throw null;
        }
        int i = m264i(obj.hashCode());
        C0420l[] lVarArr = this.f321a;
        Object obj5 = null;
        int i2 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i3 = (length - 1) & i;
                    C0420l k = m262k(lVarArr, i3);
                    boolean z = true;
                    if (k == null) {
                        C0421m mVar = new C0421m();
                        synchronized (mVar) {
                            try {
                                if (m271b(lVarArr, i3, mVar)) {
                                    obj5 = function.apply(obj);
                                    if (obj5 != null) {
                                        lVar = new C0420l(i, obj, obj5);
                                    } else {
                                        lVar = null;
                                    }
                                    m265h(lVarArr, i3, lVar);
                                    i2 = 1;
                                }
                            } finally {
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    } else {
                        int i4 = k.f346a;
                        if (i4 == -1) {
                            lVarArr = m269d(lVarArr, k);
                        } else if (i4 == i && (((obj3 = k.f347b) == obj || (obj3 != null && obj.equals(obj3))) && (obj4 = k.f348c) != null)) {
                            return obj4;
                        } else {
                            synchronized (k) {
                                try {
                                    if (m262k(lVarArr, i3) == k) {
                                        if (i4 >= 0) {
                                            C0420l lVar2 = k;
                                            i2 = 1;
                                            while (true) {
                                                if (lVar2.f346a == i && ((obj2 = lVar2.f347b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                    break;
                                                }
                                                C0420l lVar3 = lVar2.f349d;
                                                if (lVar3 == null) {
                                                    Object apply = function.apply(obj);
                                                    if (apply == null) {
                                                        obj5 = apply;
                                                    } else if (lVar2.f349d == null) {
                                                        lVar2.f349d = new C0420l(i, obj, apply);
                                                        obj5 = apply;
                                                    } else {
                                                        throw new IllegalStateException("Recursive update");
                                                    }
                                                } else {
                                                    i2++;
                                                    lVar2 = lVar3;
                                                }
                                            }
                                            obj5 = lVar2.f348c;
                                        } else if (k instanceof C0425q) {
                                            C0425q qVar = (C0425q) k;
                                            C0426r rVar = qVar.f364e;
                                            if (rVar == null || (b = rVar.m239b(i, obj, null)) == null) {
                                                obj5 = function.apply(obj);
                                                if (obj5 != null) {
                                                    qVar.m245e(i, obj, obj5);
                                                    i2 = 2;
                                                }
                                            } else {
                                                obj5 = b.f348c;
                                            }
                                            z = false;
                                            i2 = 2;
                                        } else if (k instanceof C0421m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                    z = false;
                                } finally {
                                }
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    m259n(lVarArr, i3);
                                }
                                if (!z) {
                                    return obj5;
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = m268e();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        C0426r b;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i = m264i(obj.hashCode());
        C0420l[] lVarArr = this.f321a;
        int i2 = 0;
        Object obj3 = null;
        int i3 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i4 = (length - 1) & i;
                    C0420l k = m262k(lVarArr, i4);
                    if (k == null) {
                        break;
                    }
                    int i5 = k.f346a;
                    if (i5 == -1) {
                        lVarArr = m269d(lVarArr, k);
                    } else {
                        synchronized (k) {
                            try {
                                if (m262k(lVarArr, i4) == k) {
                                    if (i5 < 0) {
                                        if (!(k instanceof C0425q)) {
                                            if (k instanceof C0421m) {
                                                break;
                                            }
                                        } else {
                                            C0425q qVar = (C0425q) k;
                                            C0426r rVar = qVar.f364e;
                                            if (!(rVar == null || (b = rVar.m239b(i, obj, null)) == null)) {
                                                obj3 = biFunction.apply(obj, b.f348c);
                                                if (obj3 != null) {
                                                    b.f348c = obj3;
                                                } else {
                                                    if (qVar.m244f(b)) {
                                                        m265h(lVarArr, i4, m257p(qVar.f365f));
                                                    }
                                                    i2 = -1;
                                                }
                                            }
                                            i3 = 2;
                                        }
                                    } else {
                                        i3 = 1;
                                        C0420l lVar = null;
                                        C0420l lVar2 = k;
                                        while (true) {
                                            if (lVar2.f346a == i && ((obj2 = lVar2.f347b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                break;
                                            }
                                            C0420l lVar3 = lVar2.f349d;
                                            if (lVar3 == null) {
                                                break;
                                            }
                                            i3++;
                                            lVar = lVar2;
                                            lVar2 = lVar3;
                                        }
                                        obj3 = biFunction.apply(obj, lVar2.f348c);
                                        if (obj3 != null) {
                                            lVar2.f348c = obj3;
                                        } else {
                                            C0420l lVar4 = lVar2.f349d;
                                            if (lVar != null) {
                                                lVar.f349d = lVar4;
                                            } else {
                                                m265h(lVarArr, i4, lVar4);
                                            }
                                            i2 = -1;
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (i3 != 0) {
                            break;
                        }
                    }
                }
            }
            lVarArr = m268e();
        }
        if (i2 != 0) {
            m272a(i2, i3);
        }
        return obj3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0112, code lost:
        if (r4 == 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0114, code lost:
        m272a(r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0118, code lost:
        return r5;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object compute(Object obj, BiFunction biFunction) {
        C0420l lVar;
        C0426r rVar;
        Object obj2;
        Object obj3;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i = m264i(obj.hashCode());
        C0420l[] lVarArr = this.f321a;
        int i2 = 0;
        Object obj4 = null;
        int i3 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i4 = (length - 1) & i;
                    C0420l k = m262k(lVarArr, i4);
                    if (k == null) {
                        C0421m mVar = new C0421m();
                        synchronized (mVar) {
                            try {
                                if (m271b(lVarArr, i4, mVar)) {
                                    obj4 = biFunction.apply(obj, null);
                                    if (obj4 != null) {
                                        lVar = new C0420l(i, obj, obj4);
                                        i3 = 1;
                                    } else {
                                        lVar = null;
                                    }
                                    m265h(lVarArr, i4, lVar);
                                    i2 = 1;
                                }
                            } finally {
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    } else {
                        int i5 = k.f346a;
                        if (i5 == -1) {
                            lVarArr = m269d(lVarArr, k);
                        } else {
                            synchronized (k) {
                                try {
                                    if (m262k(lVarArr, i4) == k) {
                                        if (i5 >= 0) {
                                            C0420l lVar2 = null;
                                            C0420l lVar3 = k;
                                            i2 = 1;
                                            while (true) {
                                                if (lVar3.f346a == i && ((obj3 = lVar3.f347b) == obj || (obj3 != null && obj.equals(obj3)))) {
                                                    break;
                                                }
                                                C0420l lVar4 = lVar3.f349d;
                                                if (lVar4 == null) {
                                                    Object apply = biFunction.apply(obj, null);
                                                    if (apply == null) {
                                                        obj4 = apply;
                                                    } else if (lVar3.f349d == null) {
                                                        lVar3.f349d = new C0420l(i, obj, apply);
                                                        obj4 = apply;
                                                        i3 = 1;
                                                    } else {
                                                        throw new IllegalStateException("Recursive update");
                                                    }
                                                } else {
                                                    i2++;
                                                    lVar2 = lVar3;
                                                    lVar3 = lVar4;
                                                }
                                            }
                                            Object apply2 = biFunction.apply(obj, lVar3.f348c);
                                            if (apply2 != null) {
                                                lVar3.f348c = apply2;
                                                obj4 = apply2;
                                            } else {
                                                C0420l lVar5 = lVar3.f349d;
                                                if (lVar2 != null) {
                                                    lVar2.f349d = lVar5;
                                                } else {
                                                    m265h(lVarArr, i4, lVar5);
                                                }
                                                obj4 = apply2;
                                                i3 = -1;
                                            }
                                        } else if (k instanceof C0425q) {
                                            C0425q qVar = (C0425q) k;
                                            C0426r rVar2 = qVar.f364e;
                                            if (rVar2 != null) {
                                                rVar = rVar2.m239b(i, obj, null);
                                            } else {
                                                rVar = null;
                                            }
                                            if (rVar == null) {
                                                obj2 = null;
                                            } else {
                                                obj2 = rVar.f348c;
                                            }
                                            Object apply3 = biFunction.apply(obj, obj2);
                                            if (apply3 != null) {
                                                if (rVar != null) {
                                                    rVar.f348c = apply3;
                                                } else {
                                                    qVar.m245e(i, obj, apply3);
                                                    i3 = 1;
                                                }
                                            } else if (rVar != null) {
                                                if (qVar.m244f(rVar)) {
                                                    m265h(lVarArr, i4, m257p(qVar.f365f));
                                                }
                                                i3 = -1;
                                            }
                                            obj4 = apply3;
                                            i2 = 1;
                                        } else if (k instanceof C0421m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                } finally {
                                }
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    m259n(lVarArr, i4);
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = m268e();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00dd, code lost:
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, p004j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i;
        Object obj3;
        Object obj4 = obj2;
        if (obj == null || obj4 == null || biFunction == null) {
            throw null;
        }
        int i2 = m264i(obj.hashCode());
        C0420l[] lVarArr = this.f321a;
        int i3 = 0;
        Object obj5 = null;
        int i4 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i5 = (length - 1) & i2;
                    C0420l k = m262k(lVarArr, i5);
                    i = 1;
                    if (k != null) {
                        int i6 = k.f346a;
                        if (i6 == -1) {
                            lVarArr = m269d(lVarArr, k);
                        } else {
                            synchronized (k) {
                                try {
                                    if (m262k(lVarArr, i5) == k) {
                                        if (i6 < 0) {
                                            if (!(k instanceof C0425q)) {
                                                if (k instanceof C0421m) {
                                                    break;
                                                }
                                            } else {
                                                C0425q qVar = (C0425q) k;
                                                C0426r rVar = qVar.f364e;
                                                C0426r b = rVar == null ? null : rVar.m239b(i2, obj, null);
                                                Object apply = b == null ? obj4 : biFunction.apply(b.f348c, obj4);
                                                if (apply != null) {
                                                    if (b != null) {
                                                        b.f348c = apply;
                                                    } else {
                                                        qVar.m245e(i2, obj, apply);
                                                        i4 = 1;
                                                    }
                                                } else if (b != null) {
                                                    if (qVar.m244f(b)) {
                                                        m265h(lVarArr, i5, m257p(qVar.f365f));
                                                    }
                                                    i4 = -1;
                                                }
                                                i3 = 2;
                                                obj5 = apply;
                                            }
                                        } else {
                                            C0420l lVar = null;
                                            C0420l lVar2 = k;
                                            i3 = 1;
                                            while (true) {
                                                if (lVar2.f346a == i2 && ((obj3 = lVar2.f347b) == obj || (obj3 != null && obj.equals(obj3)))) {
                                                    break;
                                                }
                                                C0420l lVar3 = lVar2.f349d;
                                                if (lVar3 == null) {
                                                    lVar2.f349d = new C0420l(i2, obj, obj4);
                                                    obj5 = obj4;
                                                    i4 = 1;
                                                    break;
                                                }
                                                i3++;
                                                lVar = lVar2;
                                                lVar2 = lVar3;
                                            }
                                            Object apply2 = biFunction.apply(lVar2.f348c, obj4);
                                            if (apply2 != null) {
                                                lVar2.f348c = apply2;
                                                obj5 = apply2;
                                            } else {
                                                C0420l lVar4 = lVar2.f349d;
                                                if (lVar != null) {
                                                    lVar.f349d = lVar4;
                                                } else {
                                                    m265h(lVarArr, i5, lVar4);
                                                }
                                                obj5 = apply2;
                                                i4 = -1;
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    m259n(lVarArr, i5);
                                }
                                i = i4;
                                obj4 = obj5;
                            }
                        }
                    } else if (m271b(lVarArr, i5, new C0420l(i2, obj, obj4))) {
                        break;
                    }
                }
            }
            lVarArr = m268e();
        }
        if (i != 0) {
            m272a(i, i3);
        }
        return obj4;
    }

    /* renamed from: e */
    public final C0420l[] m268e() {
        while (true) {
            C0420l[] lVarArr = this.f321a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i = this.sizeCtl;
            if (i < 0) {
                Thread.yield();
            } else if (f313h.m506c(this, f314i, i, -1)) {
                try {
                    C0420l[] lVarArr2 = this.f321a;
                    if (lVarArr2 != null) {
                        if (lVarArr2.length == 0) {
                        }
                        this.sizeCtl = i;
                        return lVarArr2;
                    }
                    int i2 = i > 0 ? i : 16;
                    C0420l[] lVarArr3 = new C0420l[i2];
                    this.f321a = lVarArr3;
                    i = i2 - (i2 >>> 2);
                    lVarArr2 = lVarArr3;
                    this.sizeCtl = i;
                    return lVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i;
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0.m505d(r1, r2, r4, r6) == false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x013f, code lost:
        if (r1.f323c != r6) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0141, code lost:
        r1.f323c = (p004j$.util.concurrent.C0411c[]) java.util.Arrays.copyOf(r6, r7 << 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00c1 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m272a(long j, int i) {
        long j2;
        C0420l[] lVarArr;
        int length;
        C0420l[] lVarArr2;
        boolean z;
        boolean z2;
        int length2;
        boolean z3;
        int length3;
        int length4;
        C0411c cVar;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        C0411c[] cVarArr = concurrentHashMap.f323c;
        if (cVarArr == null) {
            C0280a aVar = f313h;
            long j3 = f316k;
            long j4 = concurrentHashMap.baseCount;
            j2 = j4 + j;
        }
        if (cVarArr == null || (length4 = cVarArr.length - 1) < 0 || (cVar = cVarArr[length4 & ((ThreadLocalRandom) ThreadLocalRandom.f329f.get()).f332b]) == null) {
            z = true;
        } else {
            C0280a aVar2 = f313h;
            long j5 = f318m;
            long j6 = cVar.value;
            z = aVar2.m505d(cVar, j5, j6, j6 + j);
            if (z) {
                if (i > 1) {
                    j2 = concurrentHashMap.m263j();
                    if (i >= 0) {
                        while (true) {
                            int i2 = concurrentHashMap.sizeCtl;
                            if (j2 >= i2 && (lVarArr = concurrentHashMap.f321a) != null && (length = lVarArr.length) < 1073741824) {
                                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(length) | 32768;
                                if (i2 < 0) {
                                    if ((i2 >>> 16) == numberOfLeadingZeros && i2 != numberOfLeadingZeros + 1 && i2 != numberOfLeadingZeros + 65535 && (lVarArr2 = concurrentHashMap.f322b) != null && concurrentHashMap.transferIndex > 0) {
                                        if (f313h.m506c(concurrentHashMap, f314i, i2, i2 + 1)) {
                                            concurrentHashMap.m260m(lVarArr, lVarArr2);
                                        }
                                    } else {
                                        return;
                                    }
                                } else if (f313h.m506c(concurrentHashMap, f314i, i2, (numberOfLeadingZeros << 16) + 2)) {
                                    concurrentHashMap.m260m(lVarArr, null);
                                }
                                j2 = concurrentHashMap.m263j();
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        C0430v vVar = ThreadLocalRandom.f329f;
        int i3 = ((ThreadLocalRandom) vVar.get()).f332b;
        if (i3 == 0) {
            ThreadLocalRandom.m253d();
            i3 = ((ThreadLocalRandom) vVar.get()).f332b;
            z = true;
        }
        boolean z4 = z;
        int i4 = i3;
        while (true) {
            boolean z5 = false;
            while (true) {
                C0411c[] cVarArr2 = concurrentHashMap.f323c;
                if (cVarArr2 != null && (length2 = cVarArr2.length) > 0) {
                    C0411c cVar2 = cVarArr2[(length2 - 1) & i4];
                    if (cVar2 != null) {
                        if (!z4) {
                            z4 = true;
                        } else {
                            C0280a aVar3 = f313h;
                            long j7 = f318m;
                            long j8 = cVar2.value;
                            if (!aVar3.m505d(cVar2, j7, j8, j8 + j)) {
                                if (concurrentHashMap.f323c == cVarArr2 && length2 < f312g) {
                                    if (!z5) {
                                        z5 = true;
                                    } else if (concurrentHashMap.cellsBusy == 0 && aVar3.m506c(concurrentHashMap, f317l, 0, 1)) {
                                        try {
                                            break;
                                        } finally {
                                        }
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                        int i5 = (i4 << 13) ^ i4;
                        int i6 = i5 ^ (i5 >>> 17);
                        int i7 = i6 ^ (i6 << 5);
                        ((ThreadLocalRandom) ThreadLocalRandom.f329f.get()).f332b = i7;
                        i4 = i7;
                    } else if (concurrentHashMap.cellsBusy == 0) {
                        C0411c cVar3 = new C0411c(j);
                        if (concurrentHashMap.cellsBusy == 0 && f313h.m506c(concurrentHashMap, f317l, 0, 1)) {
                            try {
                                C0411c[] cVarArr3 = concurrentHashMap.f323c;
                                if (cVarArr3 != null && (length3 = cVarArr3.length) > 0) {
                                    int i8 = (length3 - 1) & i4;
                                    if (cVarArr3[i8] == null) {
                                        cVarArr3[i8] = cVar3;
                                        z3 = true;
                                        if (!z3) {
                                            return;
                                        }
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                }
                            } finally {
                            }
                        }
                    }
                    z5 = false;
                    int i52 = (i4 << 13) ^ i4;
                    int i62 = i52 ^ (i52 >>> 17);
                    int i72 = i62 ^ (i62 << 5);
                    ((ThreadLocalRandom) ThreadLocalRandom.f329f.get()).f332b = i72;
                    i4 = i72;
                } else if (concurrentHashMap.cellsBusy == 0 && concurrentHashMap.f323c == cVarArr2 && f313h.m506c(concurrentHashMap, f317l, 0, 1)) {
                    try {
                        if (concurrentHashMap.f323c == cVarArr2) {
                            C0411c[] cVarArr4 = new C0411c[2];
                            cVarArr4[i4 & 1] = new C0411c(j);
                            concurrentHashMap.f323c = cVarArr4;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            return;
                        }
                    } finally {
                    }
                } else {
                    C0280a aVar4 = f313h;
                    long j9 = f316k;
                    long j10 = concurrentHashMap.baseCount;
                    if (aVar4.m505d(concurrentHashMap, j9, j10, j10 + j)) {
                        return;
                    }
                }
                concurrentHashMap = this;
            }
        }
    }

    /* renamed from: d */
    public final C0420l[] m269d(C0420l[] lVarArr, C0420l lVar) {
        int i;
        if (!(lVar instanceof C0415g)) {
            return this.f321a;
        }
        C0420l[] lVarArr2 = ((C0415g) lVar).f339e;
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
        while (lVarArr2 == this.f322b && this.f321a == lVarArr && (i = this.sizeCtl) < 0 && (i >>> 16) == numberOfLeadingZeros && i != numberOfLeadingZeros + 1 && i != 65535 + numberOfLeadingZeros && this.transferIndex > 0) {
            if (f313h.m506c(this, f314i, i, i + 1)) {
                m260m(lVarArr, lVarArr2);
                break;
            }
        }
        return lVarArr2;
    }

    /* renamed from: o */
    public final void m258o(int i) {
        int length;
        int l = i >= 536870912 ? 1073741824 : m261l(i + (i >>> 1) + 1);
        while (true) {
            int i2 = this.sizeCtl;
            if (i2 >= 0) {
                C0420l[] lVarArr = this.f321a;
                if (lVarArr != null && (length = lVarArr.length) != 0) {
                    if (l <= i2 || length >= 1073741824) {
                        break;
                    } else if (lVarArr == this.f321a) {
                        if (f313h.m506c(this, f314i, i2, ((Integer.numberOfLeadingZeros(length) | 32768) << 16) + 2)) {
                            m260m(lVarArr, null);
                        }
                    }
                } else {
                    int i3 = i2 > l ? i2 : l;
                    if (f313h.m506c(this, f314i, i2, -1)) {
                        try {
                            if (this.f321a == lVarArr) {
                                this.f321a = new C0420l[i3];
                                i2 = i3 - (i3 >>> 2);
                            }
                        } finally {
                            this.sizeCtl = i2;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                break;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r10v9, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r8v13, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r8v8, types: [j$.util.concurrent.l] */
    /* renamed from: m */
    public final void m260m(C0420l[] lVarArr, C0420l[] lVarArr2) {
        C0420l[] lVarArr3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        C0420l lVar;
        C0420l lVar2;
        C0426r rVar;
        int i7;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        int length = lVarArr.length;
        int i8 = f312g;
        int i9 = i8 > 1 ? (length >>> 3) / i8 : length;
        int i10 = i9 < 16 ? 16 : i9;
        if (lVarArr2 == null) {
            try {
                C0420l[] lVarArr4 = new C0420l[length << 1];
                concurrentHashMap.f322b = lVarArr4;
                concurrentHashMap.transferIndex = length;
                lVarArr3 = lVarArr4;
            } catch (Throwable unused) {
                concurrentHashMap.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        C0415g gVar = new C0415g(lVarArr3);
        int i11 = 0;
        int i12 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            if (z) {
                int i13 = i11 - 1;
                if (i13 >= i12 || z2) {
                    i12 = i12;
                    i11 = i13;
                } else {
                    int i14 = concurrentHashMap.transferIndex;
                    if (i14 <= 0) {
                        i11 = -1;
                    } else {
                        C0280a aVar = f313h;
                        int i15 = i12;
                        long j = f315j;
                        if (i14 > i10) {
                            i3 = i14 - i10;
                            i2 = i15;
                            i = i13;
                        } else {
                            i = i13;
                            i2 = i15;
                            i3 = 0;
                        }
                        boolean c = aVar.m506c(concurrentHashMap, j, i14, i3);
                        i12 = i3;
                        if (c) {
                            i11 = i14 - 1;
                        } else {
                            i12 = i2;
                            i11 = i;
                        }
                    }
                }
                z = false;
            } else {
                i12 = i12;
                C0426r rVar2 = null;
                if (i11 < 0 || i11 >= length || (i6 = i11 + length) >= length2) {
                    i5 = length;
                    i4 = i10;
                    if (z2) {
                        concurrentHashMap.f322b = null;
                        concurrentHashMap.f321a = lVarArr3;
                        concurrentHashMap.sizeCtl = (i5 << 1) - (i5 >>> 1);
                        return;
                    }
                    i11 = i11;
                    C0280a aVar2 = f313h;
                    long j2 = f314i;
                    int i16 = concurrentHashMap.sizeCtl;
                    if (aVar2.m506c(concurrentHashMap, j2, i16, i16 - 1)) {
                        if (i16 - 2 == ((Integer.numberOfLeadingZeros(i5) | 32768) << 16)) {
                            i11 = i5;
                            z = true;
                            z2 = true;
                        } else {
                            return;
                        }
                    }
                } else {
                    C0420l k = m262k(lVarArr, i11);
                    if (k == null) {
                        z = m271b(lVarArr, i11, gVar);
                        i5 = length;
                        i4 = i10;
                    } else {
                        int i17 = k.f346a;
                        if (i17 == -1) {
                            i5 = length;
                            i4 = i10;
                            z = true;
                        } else {
                            synchronized (k) {
                                try {
                                    if (m262k(lVarArr, i11) == k) {
                                        if (i17 >= 0) {
                                            int i18 = i17 & length;
                                            C0426r rVar3 = k;
                                            for (C0426r rVar4 = k.f349d; rVar4 != null; rVar4 = rVar4.f349d) {
                                                int i19 = rVar4.f346a & length;
                                                if (i19 != i18) {
                                                    rVar3 = rVar4;
                                                    i18 = i19;
                                                }
                                            }
                                            if (i18 == 0) {
                                                rVar = null;
                                                rVar2 = rVar3;
                                            } else {
                                                rVar = rVar3;
                                            }
                                            C0420l lVar3 = k;
                                            while (lVar3 != rVar3) {
                                                int i20 = lVar3.f346a;
                                                Object obj = lVar3.f347b;
                                                int i21 = length;
                                                Object obj2 = lVar3.f348c;
                                                if ((i20 & i21) == 0) {
                                                    i7 = i10;
                                                    rVar2 = new C0420l(i20, obj, obj2, rVar2);
                                                } else {
                                                    i7 = i10;
                                                    rVar = new C0420l(i20, obj, obj2, rVar);
                                                }
                                                lVar3 = lVar3.f349d;
                                                length = i21;
                                                i10 = i7;
                                            }
                                            i5 = length;
                                            i4 = i10;
                                            m265h(lVarArr3, i11, rVar2);
                                            m265h(lVarArr3, i6, rVar);
                                            m265h(lVarArr, i11, gVar);
                                        } else {
                                            i5 = length;
                                            i4 = i10;
                                            if (k instanceof C0425q) {
                                                C0425q qVar = (C0425q) k;
                                                C0426r rVar5 = null;
                                                C0426r rVar6 = null;
                                                int i22 = 0;
                                                int i23 = 0;
                                                C0426r rVar7 = null;
                                                for (C0420l lVar4 = qVar.f365f; lVar4 != null; lVar4 = lVar4.f349d) {
                                                    qVar = qVar;
                                                    int i24 = lVar4.f346a;
                                                    C0426r rVar8 = new C0426r(i24, lVar4.f347b, lVar4.f348c, null, null);
                                                    if ((i24 & i5) == 0) {
                                                        rVar8.f370h = rVar6;
                                                        if (rVar6 == null) {
                                                            rVar2 = rVar8;
                                                        } else {
                                                            rVar6.f349d = rVar8;
                                                        }
                                                        i22++;
                                                        rVar6 = rVar8;
                                                    } else {
                                                        rVar8.f370h = rVar5;
                                                        if (rVar5 == null) {
                                                            rVar7 = rVar8;
                                                        } else {
                                                            rVar5.f349d = rVar8;
                                                        }
                                                        i23++;
                                                        rVar5 = rVar8;
                                                    }
                                                }
                                                C0425q qVar2 = qVar;
                                                if (i22 <= 6) {
                                                    lVar = m257p(rVar2);
                                                } else {
                                                    lVar = i23 != 0 ? new C0425q(rVar2) : qVar2;
                                                }
                                                if (i23 <= 6) {
                                                    lVar2 = m257p(rVar7);
                                                } else {
                                                    lVar2 = i22 != 0 ? new C0425q(rVar7) : qVar2;
                                                }
                                                m265h(lVarArr3, i11, lVar);
                                                m265h(lVarArr3, i6, lVar2);
                                                m265h(lVarArr, i11, gVar);
                                            }
                                        }
                                        z = true;
                                    } else {
                                        i5 = length;
                                        i4 = i10;
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                }
                concurrentHashMap = this;
                length = i5;
                i10 = i4;
            }
        }
    }

    /* renamed from: j */
    public final long m263j() {
        C0411c[] cVarArr = this.f323c;
        long j = this.baseCount;
        if (cVarArr != null) {
            for (C0411c cVar : cVarArr) {
                if (cVar != null) {
                    j += cVar.value;
                }
            }
        }
        return j;
    }

    /* renamed from: n */
    public final void m259n(C0420l[] lVarArr, int i) {
        int length = lVarArr.length;
        if (length < 64) {
            m258o(length << 1);
            return;
        }
        C0420l k = m262k(lVarArr, i);
        if (k != null && k.f346a >= 0) {
            synchronized (k) {
                try {
                    if (m262k(lVarArr, i) == k) {
                        C0426r rVar = null;
                        C0426r rVar2 = null;
                        C0420l lVar = k;
                        while (lVar != null) {
                            C0426r rVar3 = new C0426r(lVar.f346a, lVar.f347b, lVar.f348c, null, null);
                            rVar3.f370h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.f349d = rVar3;
                            }
                            lVar = lVar.f349d;
                            rVar2 = rVar3;
                        }
                        m265h(lVarArr, i, new C0425q(rVar));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [j$.util.concurrent.l] */
    /* renamed from: p */
    public static C0420l m257p(C0426r rVar) {
        C0420l lVar = null;
        C0420l lVar2 = null;
        for (C0426r rVar2 = rVar; rVar2 != null; rVar2 = rVar2.f349d) {
            C0420l lVar3 = new C0420l(rVar2.f346a, rVar2.f347b, rVar2.f348c);
            if (lVar2 == null) {
                lVar = lVar3;
            } else {
                lVar2.f349d = lVar3;
            }
            lVar2 = lVar3;
        }
        return lVar;
    }
}
