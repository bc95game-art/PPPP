package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.internal.NullSurrogateKt;
/* loaded from: classes.dex */
public final class SharedFlowImpl extends NullSurrogateKt {
    public Object[] buffer;
    public int bufferSize;
    public long minCollectorIndex;
    public long replayIndex;

    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    public final Object[] growBuffer(Object[] objArr, int i, int i2) {
        if (i2 > 0) {
            Object[] objArr2 = new Object[i2];
            this.buffer = objArr2;
            if (objArr != null) {
                long head = getHead();
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = (int) (i3 + head);
                    objArr2[i4 & (i2 - 1)] = objArr[(objArr.length - 1) & i4];
                }
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow");
    }
}
