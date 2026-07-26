package p004j$.util;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.a */
/* loaded from: classes2.dex */
public final class C0400a implements Spliterator {

    /* renamed from: a */
    public final List f297a;

    /* renamed from: b */
    public int f298b;

    /* renamed from: c */
    public int f299c;

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

    public C0400a(List list) {
        this.f297a = list;
        this.f298b = 0;
        this.f299c = -1;
    }

    public C0400a(C0400a aVar, int i, int i2) {
        this.f297a = aVar.f297a;
        this.f298b = i;
        this.f299c = i2;
    }

    /* renamed from: a */
    public final int m275a() {
        List list = this.f297a;
        int i = this.f299c;
        if (i >= 0) {
            return i;
        }
        int size = list.size();
        this.f299c = size;
        return size;
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        int a = m275a();
        int i = this.f298b;
        int i2 = (a + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        this.f298b = i2;
        return new C0400a(this, i, i2);
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int a = m275a();
        int i = this.f298b;
        if (i >= a) {
            return false;
        }
        this.f298b = i + 1;
        try {
            consumer.accept(this.f297a.get(i));
            return true;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        List list = this.f297a;
        int a = m275a();
        this.f298b = a;
        for (int i = this.f298b; i < a; i++) {
            try {
                consumer.accept(list.get(i));
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return m275a() - this.f298b;
    }
}
