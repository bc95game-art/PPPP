package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
/* loaded from: classes.dex */
public final class StateFlowImpl extends NullSurrogateKt implements MutableStateFlow {
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    private volatile Object _state;
    public int sequence;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    public final Object getValue() {
        Object obj = _state$FU.get(this);
        if (obj == NullSurrogateKt.NULL) {
            return null;
        }
        return obj;
    }

    public final void setValue(Object obj) {
        int i;
        if (obj == null) {
            obj = NullSurrogateKt.NULL;
        }
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            if (!Intrinsics.areEqual(atomicReferenceFieldUpdater.get(this), obj)) {
                atomicReferenceFieldUpdater.set(this, obj);
                int i2 = this.sequence;
                if ((i2 & 1) == 0) {
                    int i3 = i2 + 1;
                    this.sequence = i3;
                    while (true) {
                        synchronized (this) {
                            i = this.sequence;
                            if (i == i3) {
                                this.sequence = i3 + 1;
                                return;
                            }
                        }
                        i3 = i;
                    }
                } else {
                    this.sequence = i2 + 2;
                }
            }
        }
    }
}
