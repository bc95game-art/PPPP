package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.n */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0618n implements BinaryOperator {

    /* renamed from: a */
    public final /* synthetic */ int f665a;

    /* renamed from: b */
    public final /* synthetic */ BiConsumer f666b;

    public /* synthetic */ C0618n(BiConsumer biConsumer, int i) {
        this.f665a = i;
        this.f666b = biConsumer;
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f665a) {
            case 0:
                return AbstractC0279a.m534c(this, function);
            case 1:
                return AbstractC0279a.m534c(this, function);
            default:
                return AbstractC0279a.m534c(this, function);
        }
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f665a) {
            case 0:
                this.f666b.accept(obj, obj2);
                return obj;
            case 1:
                this.f666b.accept(obj, obj2);
                return obj;
            default:
                this.f666b.accept(obj, obj2);
                return obj;
        }
    }
}
