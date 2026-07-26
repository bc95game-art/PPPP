package p004j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.p1 */
/* loaded from: classes2.dex */
public final class C0479p1 implements AbstractC0757y0 {

    /* renamed from: a */
    public final long[] f461a;

    /* renamed from: b */
    public int f462b;

    /* renamed from: c */
    public final int f463c;

    /* renamed from: d */
    public final int f464d;

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m522m(this, consumer);
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
        return AbstractC0279a.m562C(this, consumer);
    }

    public C0479p1(long[] jArr, int i, int i2, int i3) {
        this.f461a = jArr;
        this.f462b = i;
        this.f463c = i2;
        this.f464d = i3 | 16448;
    }

    @Override // p004j$.util.AbstractC0757y0, p004j$.util.AbstractC0405b1, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final AbstractC0757y0 mo899trySplit() {
        int i = this.f462b;
        int i2 = (this.f463c + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        this.f462b = i2;
        return new C0479p1(this.f461a, i, i2, this.f464d);
    }

    @Override // p004j$.util.AbstractC0757y0
    public final void forEachRemaining(LongConsumer longConsumer) {
        int i;
        longConsumer.getClass();
        long[] jArr = this.f461a;
        int length = jArr.length;
        int i2 = this.f463c;
        if (length >= i2 && (i = this.f462b) >= 0) {
            this.f462b = i2;
            if (i < i2) {
                do {
                    longConsumer.accept(jArr[i]);
                    i++;
                } while (i < i2);
            }
        }
    }

    @Override // p004j$.util.AbstractC0757y0
    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        int i = this.f462b;
        if (i < 0 || i >= this.f463c) {
            return false;
        }
        this.f462b = i + 1;
        longConsumer.accept(this.f461a[i]);
        return true;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f463c - this.f462b;
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return this.f464d;
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        if (AbstractC0279a.m517r(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
