package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public final class SafePublicationLazyImpl implements Lazy, Serializable {
    public static final AtomicReferenceFieldUpdater valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    public volatile Object _value;
    public volatile Function0 initializer;

    @Override // kotlin.Lazy
    public final Object getValue() {
        Object obj = this._value;
        Unit unit = Unit.INSTANCE$1;
        if (obj != unit) {
            return obj;
        }
        Function0 function0 = this.initializer;
        if (function0 == null) {
            return this._value;
        }
        Object invoke = function0.invoke();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = valueUpdater;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, unit, invoke)) {
            if (atomicReferenceFieldUpdater.get(this) != unit) {
                return this._value;
            }
        }
        this.initializer = null;
        return invoke;
    }

    public final String toString() {
        if (this._value != Unit.INSTANCE$1) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
