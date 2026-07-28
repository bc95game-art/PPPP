package p004j$.util.concurrent;

import java.util.Comparator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.concurrent.f */
/* loaded from: classes2.dex */
public final class C0414f extends C0424p implements Spliterator {

    /* renamed from: i */
    public final ConcurrentHashMap f337i;

    /* renamed from: j */
    public long f338j;

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return 4353;
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

    public C0414f(C0420l[] lVarArr, int i, int i2, int i3, long j, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i, i2, i3);
        this.f337i = concurrentHashMap;
        this.f338j = j;
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        int i = this.f359f;
        int i2 = this.f360g;
        int i3 = (i + i2) >>> 1;
        if (i3 <= i) {
            return null;
        }
        C0420l[] lVarArr = this.f354a;
        this.f360g = i3;
        long j = this.f338j >>> 1;
        this.f338j = j;
        return new C0414f(lVarArr, this.f361h, i3, i2, j, this.f337i);
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        while (true) {
            C0420l a = m249a();
            if (a != null) {
                consumer.accept(new C0419k(a.f347b, a.f348c, this.f337i));
            } else {
                return;
            }
        }
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        C0420l a = m249a();
        if (a == null) {
            return false;
        }
        consumer.accept(new C0419k(a.f347b, a.f348c, this.f337i));
        return true;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f338j;
    }
}
