package com.google.gson.internal;

import com.google.android.gms.tasks.zzr;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE;

    /* renamed from: com.google.gson.internal.UnsafeAllocator$4 */
    /* loaded from: classes.dex */
    public final class C02384 extends UnsafeAllocator {
        @Override // com.google.gson.internal.UnsafeAllocator
        public final Object newInstance(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        UnsafeAllocator unsafeAllocator;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            unsafeAllocator = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.1
                @Override // com.google.gson.internal.UnsafeAllocator
                public final Object newInstance(Class cls2) {
                    String checkInstantiable = zzr.checkInstantiable(cls2);
                    if (checkInstantiable == null) {
                        return method.invoke(obj, cls2);
                    }
                    throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(checkInstantiable));
                }
            };
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    final int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    unsafeAllocator = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.2
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public final Object newInstance(Class cls2) {
                            String checkInstantiable = zzr.checkInstantiable(cls2);
                            if (checkInstantiable == null) {
                                return declaredMethod2.invoke(null, cls2, Integer.valueOf(intValue));
                            }
                            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(checkInstantiable));
                        }
                    };
                } catch (Exception unused2) {
                    final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    unsafeAllocator = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.3
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public final Object newInstance(Class cls2) {
                            String checkInstantiable = zzr.checkInstantiable(cls2);
                            if (checkInstantiable == null) {
                                return declaredMethod3.invoke(null, cls2, Object.class);
                            }
                            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(checkInstantiable));
                        }
                    };
                }
            } catch (Exception unused3) {
                unsafeAllocator = new Object();
            }
        }
        INSTANCE = unsafeAllocator;
    }

    public abstract Object newInstance(Class cls);
}
