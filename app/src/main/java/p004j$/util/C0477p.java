package p004j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
/* renamed from: j$.util.p */
/* loaded from: classes2.dex */
public final class C0477p implements Spliterator {

    /* renamed from: a */
    public final Spliterator f459a;

    public C0477p(Spliterator spliterator) {
        this.f459a = spliterator;
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return this.f459a.tryAdvance(new C0471n(0, consumer));
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        this.f459a.forEachRemaining(new C0471n(0, consumer));
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        Spliterator trySplit = this.f459a.mo899trySplit();
        if (trySplit == null) {
            return null;
        }
        return new C0477p(trySplit);
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f459a.estimateSize();
    }

    @Override // p004j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        return this.f459a.getExactSizeIfKnown();
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return this.f459a.characteristics();
    }

    @Override // p004j$.util.Spliterator
    public final boolean hasCharacteristics(int i) {
        return this.f459a.hasCharacteristics(i);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f459a.getComparator();
    }
}
