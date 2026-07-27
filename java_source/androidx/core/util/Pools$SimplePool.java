package androidx.core.util;

import androidx.constraintlayout.core.ArrayRow;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public class Pools$SimplePool {
    public final Object[] pool;
    public int poolSize;

    public Pools$SimplePool(int i) {
        if (i > 0) {
            this.pool = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public Object acquire() {
        int i = this.poolSize;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.pool;
        Object obj = objArr[i2];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i2] = null;
        this.poolSize--;
        return obj;
    }

    public boolean release(Object instance) {
        Object[] objArr;
        boolean z;
        Intrinsics.checkNotNullParameter(instance, "instance");
        int i = this.poolSize;
        int i2 = 0;
        while (true) {
            objArr = this.pool;
            if (i2 >= i) {
                z = false;
                break;
            } else if (objArr[i2] == instance) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            int i3 = this.poolSize;
            if (i3 >= objArr.length) {
                return false;
            }
            objArr[i3] = instance;
            this.poolSize = i3 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    public Pools$SimplePool() {
        this.pool = new Object[256];
    }

    public void release(ArrayRow arrayRow) {
        int i = this.poolSize;
        Object[] objArr = this.pool;
        if (i < objArr.length) {
            objArr[i] = arrayRow;
            this.poolSize = i + 1;
        }
    }
}
