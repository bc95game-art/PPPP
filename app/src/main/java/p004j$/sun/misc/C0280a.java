package p004j$.sun.misc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import p004j$.util.concurrent.C0420l;
import p004j$.util.concurrent.C0425q;
import sun.misc.Unsafe;
/* renamed from: j$.sun.misc.a */
/* loaded from: classes2.dex */
public final class C0280a {

    /* renamed from: b */
    public static final C0280a f39b;

    /* renamed from: a */
    public final Unsafe f40a;

    static {
        Field g = m502g();
        g.setAccessible(true);
        try {
            f39b = new C0280a((Unsafe) g.get(null));
        } catch (IllegalAccessException e) {
            throw new AssertionError("Couldn't get the Unsafe", e);
        }
    }

    public C0280a(Unsafe unsafe) {
        this.f40a = unsafe;
    }

    /* renamed from: g */
    public static Field m502g() {
        Field[] declaredFields;
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new AssertionError("Couldn't find the Unsafe", e);
        }
    }

    /* renamed from: e */
    public final int m504e(C0425q qVar, long j) {
        while (true) {
            int intVolatile = this.f40a.getIntVolatile(qVar, j);
            C0425q qVar2 = qVar;
            long j2 = j;
            if (this.f40a.compareAndSwapInt(qVar2, j2, intVolatile, intVolatile - 4)) {
                return intVolatile;
            }
            qVar = qVar2;
            j = j2;
        }
    }

    /* renamed from: i */
    public final long m500i(Field field) {
        return this.f40a.objectFieldOffset(field);
    }

    /* renamed from: h */
    public final long m501h(Class cls, String str) {
        try {
            return m500i(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError("Cannot find field:", e);
        }
    }

    /* renamed from: a */
    public final int m508a(Class cls) {
        return this.f40a.arrayBaseOffset(cls);
    }

    /* renamed from: b */
    public final int m507b(Class cls) {
        return this.f40a.arrayIndexScale(cls);
    }

    /* renamed from: f */
    public final Object m503f(Object obj, long j) {
        return this.f40a.getObjectVolatile(obj, j);
    }

    /* renamed from: j */
    public final void m499j(Object obj, long j, C0420l lVar) {
        this.f40a.putObjectVolatile(obj, j, lVar);
    }

    /* renamed from: c */
    public final boolean m506c(Object obj, long j, int i, int i2) {
        return this.f40a.compareAndSwapInt(obj, j, i, i2);
    }

    /* renamed from: d */
    public final boolean m505d(Object obj, long j, long j2, long j3) {
        return this.f40a.compareAndSwapLong(obj, j, j2, j3);
    }
}
