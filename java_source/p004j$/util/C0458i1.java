package p004j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.i1 */
/* loaded from: classes2.dex */
public final class C0458i1 implements AbstractC0487s0 {

    /* renamed from: a */
    public final double[] f434a;

    /* renamed from: b */
    public int f435b;

    /* renamed from: c */
    public final int f436c;

    /* renamed from: d */
    public final int f437d;

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m524k(this, consumer);
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
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m564A(this, consumer);
    }

    public C0458i1(double[] dArr, int i, int i2, int i3) {
        this.f434a = dArr;
        this.f435b = i;
        this.f436c = i2;
        this.f437d = i3 | 16448;
    }

    @Override // p004j$.util.AbstractC0487s0, p004j$.util.AbstractC0405b1, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final AbstractC0487s0 mo899trySplit() {
        int i = this.f435b;
        int i2 = (this.f436c + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        this.f435b = i2;
        return new C0458i1(this.f434a, i, i2, this.f437d);
    }

    @Override // p004j$.util.AbstractC0487s0
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        int i;
        doubleConsumer.getClass();
        double[] dArr = this.f434a;
        int length = dArr.length;
        int i2 = this.f436c;
        if (length >= i2 && (i = this.f435b) >= 0) {
            this.f435b = i2;
            if (i < i2) {
                do {
                    doubleConsumer.accept(dArr[i]);
                    i++;
                } while (i < i2);
            }
        }
    }

    @Override // p004j$.util.AbstractC0487s0
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        int i = this.f435b;
        if (i < 0 || i >= this.f436c) {
            return false;
        }
        this.f435b = i + 1;
        doubleConsumer.accept(this.f434a[i]);
        return true;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f436c - this.f435b;
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return this.f437d;
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        if (AbstractC0279a.m517r(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
