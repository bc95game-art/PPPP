package p004j$.util.stream;

import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.s6 */
/* loaded from: classes2.dex */
public abstract class AbstractC0675s6 implements AbstractC0405b1 {

    /* renamed from: a */
    public int f743a;

    /* renamed from: b */
    public final int f744b;

    /* renamed from: c */
    public int f745c;

    /* renamed from: d */
    public final int f746d;

    /* renamed from: e */
    public Object f747e;

    /* renamed from: f */
    public final /* synthetic */ AbstractC0685t6 f748f;

    /* renamed from: a */
    public abstract void mo159a(int i, Object obj, Object obj2);

    /* renamed from: b */
    public abstract AbstractC0405b1 mo158b(Object obj, int i, int i2);

    /* renamed from: c */
    public abstract AbstractC0405b1 mo157c(int i, int i2, int i3, int i4);

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return 16464;
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public AbstractC0675s6(AbstractC0685t6 t6Var, int i, int i2, int i3, int i4) {
        this.f748f = t6Var;
        this.f743a = i;
        this.f744b = i2;
        this.f745c = i3;
        this.f746d = i4;
        Object[] objArr = t6Var.f767f;
        this.f747e = objArr == null ? t6Var.f766e : objArr[i];
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        int i = this.f743a;
        int i2 = this.f746d;
        int i3 = this.f744b;
        if (i == i3) {
            return i2 - this.f745c;
        }
        long[] jArr = this.f748f.f508d;
        return ((jArr[i3] + i2) - jArr[i]) - this.f745c;
    }

    @Override // p004j$.util.AbstractC0405b1
    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        int i = this.f743a;
        int i2 = this.f744b;
        if (i >= i2 && (i != i2 || this.f745c >= this.f746d)) {
            return false;
        }
        Object obj2 = this.f747e;
        int i3 = this.f745c;
        this.f745c = i3 + 1;
        mo159a(i3, obj2, obj);
        int i4 = this.f745c;
        Object obj3 = this.f747e;
        AbstractC0685t6 t6Var = this.f748f;
        if (i4 == t6Var.mo151q(obj3)) {
            this.f745c = 0;
            int i5 = this.f743a + 1;
            this.f743a = i5;
            Object[] objArr = t6Var.f767f;
            if (objArr != null && i5 <= i2) {
                this.f747e = objArr[i5];
            }
        }
        return true;
    }

    @Override // p004j$.util.AbstractC0405b1
    public final void forEachRemaining(Object obj) {
        AbstractC0685t6 t6Var;
        Objects.requireNonNull(obj);
        int i = this.f743a;
        int i2 = this.f746d;
        int i3 = this.f744b;
        if (i < i3 || (i == i3 && this.f745c < i2)) {
            int i4 = this.f745c;
            while (true) {
                t6Var = this.f748f;
                if (i >= i3) {
                    break;
                }
                Object obj2 = t6Var.f767f[i];
                t6Var.mo152p(obj2, i4, t6Var.mo151q(obj2), obj);
                i++;
                i4 = 0;
            }
            t6Var.mo152p(this.f743a == i3 ? this.f747e : t6Var.f767f[i3], i4, i2, obj);
            this.f743a = i3;
            this.f745c = i2;
        }
    }

    @Override // p004j$.util.AbstractC0405b1, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final AbstractC0405b1 mo899trySplit() {
        int i = this.f743a;
        int i2 = this.f744b;
        if (i < i2) {
            int i3 = i2 - 1;
            int i4 = this.f745c;
            AbstractC0685t6 t6Var = this.f748f;
            AbstractC0405b1 c = mo157c(i, i3, i4, t6Var.mo151q(t6Var.f767f[i3]));
            this.f743a = i2;
            this.f745c = 0;
            this.f747e = t6Var.f767f[i2];
            return c;
        } else if (i != i2) {
            return null;
        } else {
            int i5 = this.f745c;
            int i6 = (this.f746d - i5) / 2;
            if (i6 == 0) {
                return null;
            }
            AbstractC0405b1 b = mo158b(this.f747e, i5, i6);
            this.f745c += i6;
            return b;
        }
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }
}
