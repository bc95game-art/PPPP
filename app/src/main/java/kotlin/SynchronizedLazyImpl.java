package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class SynchronizedLazyImpl implements Lazy, Serializable {
    public Function0 initializer;
    public volatile Object _value = Unit.INSTANCE$1;
    public final Object lock = this;

    public SynchronizedLazyImpl(Function0 function0) {
        this.initializer = function0;
    }

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object obj;
        Object obj2 = this._value;
        Unit unit = Unit.INSTANCE$1;
        if (obj2 != unit) {
            return obj2;
        }
        synchronized (this.lock) {
            obj = this._value;
            if (obj == unit) {
                Function0 function0 = this.initializer;
                Intrinsics.checkNotNull(function0);
                obj = function0.invoke();
                this._value = obj;
                this.initializer = null;
            }
        }
        return obj;
    }

    public final String toString() {
        if (this._value != Unit.INSTANCE$1) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
