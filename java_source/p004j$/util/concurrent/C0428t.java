package p004j$.util.concurrent;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
import p004j$.util.stream.AbstractC0488a;
import p004j$.util.stream.AbstractC0527d8;
import p004j$.util.stream.AbstractC0650q1;
import p004j$.util.stream.AbstractC0692u3;
import p004j$.util.stream.C0556g7;
import p004j$.util.stream.C0610m1;
import p004j$.util.stream.C0670s1;
import p004j$.util.stream.EnumC0660r1;
import p004j$.util.stream.EnumC0725x6;
import p004j$.util.stream.EnumC0735y6;
/* renamed from: j$.util.concurrent.t */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0428t implements BiConsumer, BiFunction, Consumer, Supplier, AbstractC0527d8 {

    /* renamed from: a */
    public final /* synthetic */ int f372a;

    /* renamed from: b */
    public final Object f373b;

    /* renamed from: c */
    public final Object f374c;

    public /* synthetic */ C0428t(int i, Object obj, Object obj2) {
        this.f372a = i;
        this.f373b = obj;
        this.f374c = obj2;
    }

    public /* synthetic */ C0428t(BiFunction biFunction, Function function) {
        this.f372a = 2;
        this.f374c = biFunction;
        this.f373b = function;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f372a) {
            case 0:
                return AbstractC0279a.m536b(this, biConsumer);
            default:
                return AbstractC0279a.m536b(this, biConsumer);
        }
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return AbstractC0279a.m534c(this, function);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f372a) {
            case 3:
                return AbstractC0279a.m532d(this, consumer);
            case 4:
                return AbstractC0279a.m532d(this, consumer);
            case 5:
            case 6:
            default:
                return AbstractC0279a.m532d(this, consumer);
            case 7:
                return AbstractC0279a.m532d(this, consumer);
        }
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        return ((Function) this.f373b).apply(((BiFunction) this.f374c).apply(obj, obj2));
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.f372a) {
            case 0:
                ConcurrentMap concurrentMap = (ConcurrentMap) this.f373b;
                BiFunction biFunction = (BiFunction) this.f374c;
                while (!concurrentMap.replace(obj, obj2, biFunction.apply(obj, obj2)) && (obj2 = concurrentMap.get(obj)) != null) {
                }
                return;
            default:
                ((BiConsumer) this.f373b).accept(obj, obj2);
                ((BiConsumer) this.f374c).accept(obj, obj2);
                return;
        }
    }

    @Override // java.util.function.Supplier
    public Object get() {
        return new C0610m1((EnumC0660r1) this.f373b, (Predicate) this.f374c);
    }

    public C0428t(EnumC0735y6 y6Var, EnumC0660r1 r1Var, Supplier supplier) {
        this.f372a = 6;
        this.f373b = r1Var;
        this.f374c = supplier;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: w */
    public int mo94w() {
        return EnumC0725x6.f838u | EnumC0725x6.f835r;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: f */
    public Object mo113f(AbstractC0488a aVar, Spliterator spliterator) {
        AbstractC0650q1 q1Var = (AbstractC0650q1) ((Supplier) this.f374c).get();
        aVar.mo142E0(spliterator, q1Var);
        return Boolean.valueOf(q1Var.f701b);
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: j */
    public Object mo108j(AbstractC0692u3 u3Var, Spliterator spliterator) {
        return (Boolean) new C0670s1(this, (AbstractC0488a) u3Var, spliterator).invoke();
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
        switch (this.f372a) {
            case 3:
                ((Consumer) this.f373b).accept(obj);
                ((Consumer) this.f374c).accept(obj);
                return;
            case 4:
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f373b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f374c;
                if (obj == null) {
                    atomicBoolean.set(true);
                    return;
                } else {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    return;
                }
            case 5:
            case 6:
            default:
                Consumer consumer = (Consumer) this.f374c;
                if (((C0556g7) this.f373b).f570b.putIfAbsent(obj != null ? obj : C0556g7.f568d, Boolean.TRUE) == null) {
                    consumer.accept(obj);
                    return;
                }
                return;
            case 7:
                ((BiConsumer) this.f373b).accept(this.f374c, obj);
                return;
        }
    }
}
