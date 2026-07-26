package p004j$.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
/* renamed from: j$.util.c */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0406c implements Comparator, Serializable {

    /* renamed from: a */
    public final /* synthetic */ int f307a;

    /* renamed from: b */
    public final /* synthetic */ Object f308b;

    public /* synthetic */ C0406c(int i, Object obj) {
        this.f307a = i;
        this.f308b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f307a) {
            case 0:
                ToIntFunction toIntFunction = (ToIntFunction) this.f308b;
                return Integer.compare(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
            case 1:
                ToDoubleFunction toDoubleFunction = (ToDoubleFunction) this.f308b;
                return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
            case 2:
                Function function = (Function) this.f308b;
                return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
            default:
                ToLongFunction toLongFunction = (ToLongFunction) this.f308b;
                return Long.compare(toLongFunction.applyAsLong(obj), toLongFunction.applyAsLong(obj2));
        }
    }
}
