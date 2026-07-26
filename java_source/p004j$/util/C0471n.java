package p004j$.util;

import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.function.AbstractC0449g;
import p004j$.util.function.C0445c;
import p004j$.util.stream.AbstractC0488a;
import p004j$.util.stream.AbstractC0499b0;
import p004j$.util.stream.AbstractC0590k1;
import p004j$.util.stream.AbstractC0594k5;
import p004j$.util.stream.C0489a0;
import p004j$.util.stream.C0507b8;
import p004j$.util.stream.C0570i1;
import p004j$.util.stream.C0576i7;
import p004j$.util.stream.C0580j1;
import p004j$.util.stream.C0596k7;
import p004j$.util.stream.C0616m7;
import p004j$.util.stream.C0705v6;
import p004j$.util.stream.C0737z;
import p004j$.util.stream.IntStream;
import p004j$.util.stream.Stream;
/* renamed from: j$.util.n */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0471n implements Consumer, Predicate, Supplier, DoubleFunction, Function, LongFunction, BooleanSupplier {

    /* renamed from: a */
    public final /* synthetic */ int f447a;

    /* renamed from: b */
    public Object f448b;

    public /* synthetic */ C0471n(int i) {
        this.f447a = i;
    }

    public /* synthetic */ C0471n(int i, Object obj) {
        this.f447a = i;
        this.f448b = obj;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return AbstractC0449g.m233a(this, predicate);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f447a) {
            case 0:
                return AbstractC0279a.m532d(this, consumer);
            case 7:
                return AbstractC0279a.m532d(this, consumer);
            default:
                return AbstractC0279a.m532d(this, consumer);
        }
    }

    /* renamed from: or */
    public /* synthetic */ Predicate m230or(Predicate predicate) {
        return AbstractC0449g.m231c(this, predicate);
    }

    public Function compose(Function function) {
        Objects.requireNonNull(function);
        return new C0445c(this, function, 1);
    }

    public Predicate negate() {
        return new C0471n(1, this);
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        return !((Predicate) this.f448b).test(obj);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Object apply = ((Function) this.f448b).apply(obj);
        if (apply == null) {
            return null;
        }
        if (apply instanceof Stream) {
            return Stream.Wrapper.convert((Stream) apply);
        }
        if (apply instanceof java.util.stream.Stream) {
            return C0705v6.m84f((java.util.stream.Stream) apply);
        }
        if (apply instanceof IntStream) {
            return IntStream.Wrapper.convert((IntStream) apply);
        }
        if (apply instanceof java.util.stream.IntStream) {
            return IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) apply);
        }
        if (apply instanceof AbstractC0499b0) {
            return C0489a0.m222f((AbstractC0499b0) apply);
        }
        if (apply instanceof DoubleStream) {
            return C0737z.m48f((DoubleStream) apply);
        }
        if (apply instanceof AbstractC0590k1) {
            return C0580j1.m191f((AbstractC0590k1) apply);
        }
        if (apply instanceof LongStream) {
            return C0570i1.m196f((LongStream) apply);
        }
        C0440f.m235a(apply.getClass(), "java.util.stream.*Stream");
        throw null;
    }

    public Function andThen(Function function) {
        Objects.requireNonNull(function);
        return new C0445c(this, function, 0);
    }

    @Override // java.util.function.DoubleFunction
    public Object apply(double d) {
        Object apply = ((DoubleFunction) this.f448b).apply(d);
        if (apply == null) {
            return null;
        }
        if (apply instanceof AbstractC0499b0) {
            return C0489a0.m222f((AbstractC0499b0) apply);
        }
        if (apply instanceof DoubleStream) {
            return C0737z.m48f((DoubleStream) apply);
        }
        C0440f.m235a(apply.getClass(), "java.util.stream.DoubleStream");
        throw null;
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        Object apply = ((LongFunction) this.f448b).apply(j);
        if (apply == null) {
            return null;
        }
        if (apply instanceof AbstractC0590k1) {
            return C0580j1.m191f((AbstractC0590k1) apply);
        }
        if (apply instanceof LongStream) {
            return C0570i1.m196f((LongStream) apply);
        }
        C0440f.m235a(apply.getClass(), "java.util.stream.LongStream");
        throw null;
    }

    @Override // java.util.function.BooleanSupplier
    public boolean getAsBoolean() {
        switch (this.f447a) {
            case 9:
                C0576i7 i7Var = (C0576i7) this.f448b;
                return i7Var.f865d.tryAdvance(i7Var.f866e);
            case 10:
                C0596k7 k7Var = (C0596k7) this.f448b;
                return k7Var.f865d.tryAdvance(k7Var.f866e);
            case 11:
                C0616m7 m7Var = (C0616m7) this.f448b;
                return m7Var.f865d.tryAdvance(m7Var.f866e);
            default:
                C0507b8 b8Var = (C0507b8) this.f448b;
                return b8Var.f865d.tryAdvance(b8Var.f866e);
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.f447a) {
            case 2:
                return ((AbstractC0488a) this.f448b).m224Q0(0);
            default:
                return (Spliterator) this.f448b;
        }
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
        switch (this.f447a) {
            case 0:
                ((Consumer) this.f448b).accept(new C0474o((Map.Entry) obj));
                return;
            case 7:
                ((AbstractC0594k5) this.f448b).accept((AbstractC0594k5) obj);
                return;
            default:
                ((List) this.f448b).add(obj);
                return;
        }
    }
}
