package p004j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.n1 */
/* loaded from: classes2.dex */
public final class C0473n1 implements AbstractC0751v0 {

    /* renamed from: a */
    public final int[] f449a;

    /* renamed from: b */
    public int f450b;

    /* renamed from: c */
    public final int f451c;

    /* renamed from: d */
    public final int f452d;

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m523l(this, consumer);
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
        return AbstractC0279a.m563B(this, consumer);
    }

    public C0473n1(int[] iArr, int i, int i2, int i3) {
        this.f449a = iArr;
        this.f450b = i;
        this.f451c = i2;
        this.f452d = i3 | 16448;
    }

    @Override // p004j$.util.AbstractC0751v0, p004j$.util.AbstractC0405b1, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final AbstractC0751v0 mo899trySplit() {
        int i = this.f450b;
        int i2 = (this.f451c + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        this.f450b = i2;
        return new C0473n1(this.f449a, i, i2, this.f452d);
    }

    @Override // p004j$.util.AbstractC0751v0
    public final void forEachRemaining(IntConsumer intConsumer) {
        int i;
        intConsumer.getClass();
        int[] iArr = this.f449a;
        int length = iArr.length;
        int i2 = this.f451c;
        if (length >= i2 && (i = this.f450b) >= 0) {
            this.f450b = i2;
            if (i < i2) {
                do {
                    intConsumer.accept(iArr[i]);
                    i++;
                } while (i < i2);
            }
        }
    }

    @Override // p004j$.util.AbstractC0751v0
    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        int i = this.f450b;
        if (i < 0 || i >= this.f451c) {
            return false;
        }
        this.f450b = i + 1;
        intConsumer.accept(this.f449a[i]);
        return true;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f451c - this.f450b;
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return this.f452d;
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        if (AbstractC0279a.m517r(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
