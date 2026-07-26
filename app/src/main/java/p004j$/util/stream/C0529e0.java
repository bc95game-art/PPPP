package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0401a0;
import p004j$.util.C0404b0;
import p004j$.util.C0471n;
import p004j$.util.C0750v;
import p004j$.util.C0754x;
import p004j$.util.C0756y;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.e0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0529e0 implements Predicate, Supplier, IntFunction, ToIntFunction, IntBinaryOperator, ObjIntConsumer, BiConsumer, ObjLongConsumer, LongBinaryOperator, ToLongFunction, LongFunction, Consumer {

    /* renamed from: a */
    public final /* synthetic */ int f540a;

    public /* synthetic */ C0529e0(int i) {
        this.f540a = i;
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f540a) {
            case 0:
                return AbstractC0449g.m233a(this, predicate);
            case 1:
            default:
                return AbstractC0449g.m233a(this, predicate);
            case 2:
                return AbstractC0449g.m233a(this, predicate);
        }
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f540a) {
            case 12:
                return AbstractC0279a.m536b(this, biConsumer);
            case 17:
                return AbstractC0279a.m536b(this, biConsumer);
            case 21:
                return AbstractC0279a.m536b(this, biConsumer);
            default:
                return AbstractC0279a.m536b(this, biConsumer);
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        return Long.valueOf(j);
    }

    @Override // java.util.function.IntBinaryOperator
    public int applyAsInt(int i, int i2) {
        switch (this.f540a) {
            case 10:
                return Math.min(i, i2);
            case 13:
                return i + i2;
            default:
                return Math.max(i, i2);
        }
    }

    @Override // java.util.function.LongBinaryOperator
    public long applyAsLong(long j, long j2) {
        switch (this.f540a) {
            case 19:
                return Math.min(j, j2);
            case 27:
                return Math.max(j, j2);
            default:
                return j + j2;
        }
    }

    /* renamed from: or */
    public /* synthetic */ Predicate m209or(Predicate predicate) {
        switch (this.f540a) {
            case 0:
                return AbstractC0449g.m231c(this, predicate);
            case 1:
            default:
                return AbstractC0449g.m231c(this, predicate);
            case 2:
                return AbstractC0449g.m231c(this, predicate);
        }
    }

    public Predicate negate() {
        switch (this.f540a) {
            case 0:
                return new C0471n(1, this);
            case 1:
            default:
                return new C0471n(1, this);
            case 2:
                return new C0471n(1, this);
        }
    }

    @Override // java.util.function.Predicate
    public boolean test(Object obj) {
        switch (this.f540a) {
            case 0:
                return ((C0401a0) obj).f301a;
            case 1:
            default:
                return ((C0756y) obj).f883a != null;
            case 2:
                return ((C0404b0) obj).f305a;
        }
    }

    @Override // java.util.function.ToLongFunction
    public long applyAsLong(Object obj) {
        return ((Long) obj).longValue();
    }

    @Override // java.util.function.ToIntFunction
    public int applyAsInt(Object obj) {
        return ((Integer) obj).intValue();
    }

    @Override // java.util.function.Supplier
    public Object get() {
        switch (this.f540a) {
            case 1:
                return new Object();
            case 3:
                return new Object();
            case 5:
                return new Object();
            case 15:
                return new long[2];
            default:
                return new long[2];
        }
    }

    @Override // java.util.function.ObjLongConsumer
    public void accept(Object obj, long j) {
        switch (this.f540a) {
            case 18:
                ((C0754x) obj).accept(j);
                return;
            default:
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + j;
                return;
        }
    }

    @Override // java.util.function.BiConsumer
    public void accept(Object obj, Object obj2) {
        switch (this.f540a) {
            case 12:
                ((C0750v) obj).m10a((C0750v) obj2);
                return;
            case 17:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                return;
            case 21:
                ((C0754x) obj).m8a((C0754x) obj2);
                return;
            default:
                long[] jArr3 = (long[]) obj;
                long[] jArr4 = (long[]) obj2;
                jArr3[0] = jArr3[0] + jArr4[0];
                jArr3[1] = jArr3[1] + jArr4[1];
                return;
        }
    }

    @Override // java.util.function.ObjIntConsumer
    public void accept(Object obj, int i) {
        switch (this.f540a) {
            case 11:
                ((C0750v) obj).accept(i);
                return;
            default:
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + i;
                return;
        }
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        switch (this.f540a) {
            case 6:
                return new Object[i];
            case 7:
                return new Integer[i];
            case 8:
            default:
                return new Long[i];
            case 9:
                return Integer.valueOf(i);
        }
    }
}
