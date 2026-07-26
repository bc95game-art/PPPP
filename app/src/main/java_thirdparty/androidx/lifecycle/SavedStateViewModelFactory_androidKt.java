package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class SavedStateViewModelFactory_androidKt {
    public static final List ANDROID_VIEWMODEL_SIGNATURE;
    public static final List VIEWMODEL_SIGNATURE = LazyKt__LazyJVMKt.listOf(SavedStateHandle.class);

    static {
        List asList = Arrays.asList(Application.class, SavedStateHandle.class);
        Intrinsics.checkNotNullExpressionValue(asList, "asList(...)");
        ANDROID_VIEWMODEL_SIGNATURE = asList;
    }

    public static final Constructor findMatchingConstructor(Class cls, List signature) {
        boolean z;
        Intrinsics.checkNotNullParameter(signature, "signature");
        Constructor<?>[] array = cls.getConstructors();
        Intrinsics.checkNotNullParameter(array, "array");
        int i = 0;
        while (true) {
            if (i < array.length) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return null;
            }
            int i2 = i + 1;
            try {
                Constructor<?> constructor = array[i];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
                List list = ArraysKt.toList(parameterTypes);
                if (signature.equals(list)) {
                    return constructor;
                }
                if (signature.size() != list.size() || !list.containsAll(signature)) {
                    i = i2;
                } else {
                    throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + signature);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }
    }

    public static final ViewModel newInstance(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
