package kotlin.coroutines.jvm.internal;

import android.os.Build;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class ModuleNameRetriever {
    public static Cache cache;
    public static final Cache notOnJava9 = new Cache(null, null, null);

    /* loaded from: classes.dex */
    public final class Cache {
        public Method getDescriptorMethod;
        public Method getModuleMethod;
        public Method nameMethod;

        public Cache(Method method, Method method2, Method method3) {
            this.getModuleMethod = method;
            this.getDescriptorMethod = method2;
            this.nameMethod = method3;
        }

        public static void preApi29Check() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }
}
