package p004j$.util.stream;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.w8 */
/* loaded from: classes2.dex */
public abstract class AbstractC0717w8 implements Spliterator {

    /* renamed from: a */
    public final Spliterator f811a;

    /* renamed from: b */
    public final AtomicBoolean f812b;

    /* renamed from: c */
    public boolean f813c;

    /* renamed from: d */
    public int f814d;

    /* renamed from: b */
    public abstract Spliterator mo72b(Spliterator spliterator);

    @Override // p004j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        return -1L;
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    @Override // p004j$.util.Spliterator
    public void forEachRemaining(Consumer consumer) {
        do {
        } while (tryAdvance(consumer));
    }

    public AbstractC0717w8(Spliterator spliterator) {
        this.f813c = true;
        this.f811a = spliterator;
        this.f812b = new AtomicBoolean();
    }

    public AbstractC0717w8(Spliterator spliterator, AbstractC0717w8 w8Var) {
        this.f813c = true;
        this.f811a = spliterator;
        w8Var.getClass();
        this.f812b = w8Var.f812b;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f811a.estimateSize();
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return this.f811a.characteristics() & (-16449);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f811a.getComparator();
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public Spliterator mo899trySplit() {
        Spliterator trySplit = this.f811a.mo899trySplit();
        if (trySplit != null) {
            return mo72b(trySplit);
        }
        return null;
    }

    /* renamed from: a */
    public final boolean m73a() {
        return this.f814d != 0 || !this.f812b.get();
    }
}
