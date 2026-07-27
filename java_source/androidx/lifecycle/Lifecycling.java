package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes.dex */
public abstract class Lifecycling {
    public static final HashMap callbackCache = new HashMap();
    public static final HashMap classToAdapters = new HashMap();

    public static void createGeneratedAdapter(Constructor constructor, LifecycleObserver lifecycleObserver) {
        try {
            Intrinsics.checkNotNull(constructor.newInstance(lifecycleObserver));
            throw new ClassCastException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getObserverConstructorType(Class cls) {
        Constructor constructor;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        HashMap hashMap = callbackCache;
        Integer num = (Integer) hashMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r4 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                if (r4 != null) {
                    str = r4.getName();
                } else {
                    str = "";
                }
                Intrinsics.checkNotNull(str);
                if (str.length() != 0) {
                    Intrinsics.checkNotNull(canonicalName);
                    canonicalName = canonicalName.substring(str.length() + 1);
                    Intrinsics.checkNotNullExpressionValue(canonicalName, "substring(...)");
                }
                Intrinsics.checkNotNull(canonicalName);
                String concat = StringsKt__StringsKt.replace$default(canonicalName, ".", "_").concat("_LifecycleAdapter");
                if (str.length() != 0) {
                    concat = str + '.' + concat;
                }
                constructor = Class.forName(concat).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            HashMap hashMap2 = classToAdapters;
            if (constructor != null) {
                hashMap2.put(cls, LazyKt__LazyJVMKt.listOf(constructor));
            } else {
                ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
                HashMap hashMap3 = classesInfoCache.mHasLifecycleMethods;
                Boolean bool = (Boolean) hashMap3.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                hashMap3.put(cls, Boolean.FALSE);
                                z = false;
                                break;
                            } else if (((OnLifecycleEvent) declaredMethods[i2].getAnnotation(OnLifecycleEvent.class)) != null) {
                                classesInfoCache.createInfo(cls, declaredMethods);
                                z = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!z) {
                    Class superclass = cls.getSuperclass();
                    if (superclass == null || !LifecycleObserver.class.isAssignableFrom(superclass)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        Intrinsics.checkNotNull(superclass);
                        if (getObserverConstructorType(superclass) != 1) {
                            Object obj = hashMap2.get(superclass);
                            Intrinsics.checkNotNull(obj);
                            arrayList = new ArrayList((Collection) obj);
                        }
                    }
                    Class<?>[] array = cls.getInterfaces();
                    Intrinsics.checkNotNullParameter(array, "array");
                    int i3 = 0;
                    while (true) {
                        if (i3 < array.length) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            int i4 = i3 + 1;
                            try {
                                Class<?> cls2 = array[i3];
                                if (cls2 == null || !LifecycleObserver.class.isAssignableFrom(cls2)) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (z4) {
                                    Intrinsics.checkNotNull(cls2);
                                    if (getObserverConstructorType(cls2) == 1) {
                                        break;
                                    }
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    Object obj2 = hashMap2.get(cls2);
                                    Intrinsics.checkNotNull(obj2);
                                    arrayList.addAll((Collection) obj2);
                                }
                                i3 = i4;
                            } catch (ArrayIndexOutOfBoundsException e3) {
                                throw new NoSuchElementException(e3.getMessage());
                            }
                        } else if (arrayList != null) {
                            hashMap2.put(cls, arrayList);
                        }
                    }
                }
            }
            i = 2;
        }
        hashMap.put(cls, Integer.valueOf(i));
        return i;
    }
}
