package kotlin.random;

import java.io.Serializable;
import kotlin.internal.jdk8.JDK8PlatformImplementations$ReflectSdkVersion;
/* loaded from: classes.dex */
public abstract class Random {
    public static final AbstractPlatformRandom defaultRandom;

    /* loaded from: classes.dex */
    public final class Default extends Random implements Serializable {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        FallbackThreadLocalRandom fallbackThreadLocalRandom;
        Integer num = JDK8PlatformImplementations$ReflectSdkVersion.sdkVersion;
        if (num == null || num.intValue() >= 34) {
            fallbackThreadLocalRandom = new Object();
        } else {
            fallbackThreadLocalRandom = new FallbackThreadLocalRandom();
        }
        defaultRandom = fallbackThreadLocalRandom;
    }
}
