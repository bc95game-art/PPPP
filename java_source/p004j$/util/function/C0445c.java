package p004j$.util.function;

import java.util.function.Function;
import p004j$.util.Objects;
/* renamed from: j$.util.function.c */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0445c implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f406a;

    /* renamed from: b */
    public final /* synthetic */ Function f407b;

    /* renamed from: c */
    public final /* synthetic */ Function f408c;

    public /* synthetic */ C0445c(Function function, Function function2, int i) {
        this.f406a = i;
        this.f407b = function;
        this.f408c = function2;
    }

    public final Function compose(Function function) {
        switch (this.f406a) {
            case 0:
                Objects.requireNonNull(function);
                return new C0445c(this, function, 1);
            default:
                Objects.requireNonNull(function);
                return new C0445c(this, function, 1);
        }
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f406a) {
            case 0:
                return this.f408c.apply(this.f407b.apply(obj));
            default:
                return this.f407b.apply(this.f408c.apply(obj));
        }
    }

    public final Function andThen(Function function) {
        switch (this.f406a) {
            case 0:
                Objects.requireNonNull(function);
                return new C0445c(this, function, 0);
            default:
                Objects.requireNonNull(function);
                return new C0445c(this, function, 0);
        }
    }
}
