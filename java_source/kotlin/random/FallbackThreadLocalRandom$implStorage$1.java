package kotlin.random;

import java.util.Random;
/* loaded from: classes.dex */
public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new Random();
    }
}
