package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final FallbackThreadLocalRandom$implStorage$1 implStorage = new ThreadLocal();

    @Override // kotlin.random.AbstractPlatformRandom
    public final Random getImpl() {
        Object obj = this.implStorage.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (Random) obj;
    }
}
