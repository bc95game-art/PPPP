package p004j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.h1 */
/* loaded from: classes2.dex */
public final class C0455h1 implements Spliterator {

    /* renamed from: a */
    public final Object[] f429a;

    /* renamed from: b */
    public int f430b;

    /* renamed from: c */
    public final int f431c;

    /* renamed from: d */
    public final int f432d;

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    public C0455h1(Object[] objArr, int i, int i2, int i3) {
        this.f429a = objArr;
        this.f430b = i;
        this.f431c = i2;
        this.f432d = i3 | 16448;
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        int i = this.f430b;
        int i2 = (this.f431c + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        this.f430b = i2;
        return new C0455h1(this.f429a, i, i2, this.f432d);
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int i;
        consumer.getClass();
        Object[] objArr = this.f429a;
        int length = objArr.length;
        int i2 = this.f431c;
        if (length >= i2 && (i = this.f430b) >= 0) {
            this.f430b = i2;
            if (i < i2) {
                do {
                    consumer.accept(objArr[i]);
                    i++;
                } while (i < i2);
            }
        }
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int i = this.f430b;
        if (i < 0 || i >= this.f431c) {
            return false;
        }
        this.f430b = i + 1;
        consumer.accept(this.f429a[i]);
        return true;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f431c - this.f430b;
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return this.f432d;
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        if (AbstractC0279a.m517r(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
