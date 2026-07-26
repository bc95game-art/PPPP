package p004j$.util.function;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.function.a */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0443a implements BinaryOperator {

    /* renamed from: a */
    public final /* synthetic */ int f402a;

    /* renamed from: b */
    public final /* synthetic */ Comparator f403b;

    public /* synthetic */ C0443a(Comparator comparator, int i) {
        this.f402a = i;
        this.f403b = comparator;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f402a) {
            case 0:
                return AbstractC0279a.m534c(this, function);
            default:
                return AbstractC0279a.m534c(this, function);
        }
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f402a) {
            case 0:
                return this.f403b.compare(obj, obj2) >= 0 ? obj : obj2;
            default:
                return this.f403b.compare(obj, obj2) <= 0 ? obj : obj2;
        }
    }
}
