package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class UnsafeLazyImpl implements Lazy, Serializable {
    public Object _value;
    public Function0 initializer;

    @Override // kotlin.Lazy
    public final Object getValue() {
        if (this._value == Unit.INSTANCE$1) {
            Function0 function0 = this.initializer;
            Intrinsics.checkNotNull(function0);
            this._value = function0.invoke();
            this.initializer = null;
        }
        return this._value;
    }

    public final String toString() {
        if (this._value != Unit.INSTANCE$1) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
