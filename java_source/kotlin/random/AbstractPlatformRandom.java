package kotlin.random;

import java.util.Random;
/* loaded from: classes.dex */
public abstract class AbstractPlatformRandom extends Random {
    public abstract Random getImpl();
}
