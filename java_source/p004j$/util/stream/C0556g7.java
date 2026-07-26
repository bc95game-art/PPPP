package p004j$.util.stream;

import java.util.Comparator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
import p004j$.util.concurrent.C0428t;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: j$.util.stream.g7 */
/* loaded from: classes2.dex */
public final class C0556g7 implements Spliterator, Consumer {

    /* renamed from: d */
    public static final Object f568d = new Object();

    /* renamed from: a */
    public final Spliterator f569a;

    /* renamed from: b */
    public final ConcurrentHashMap f570b;

    /* renamed from: c */
    public Object f571c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    public C0556g7(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.f569a = spliterator;
        this.f570b = concurrentHashMap;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f571c = obj;
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        while (this.f569a.tryAdvance(this)) {
            Object obj = this.f571c;
            if (obj == null) {
                obj = f568d;
            }
            if (this.f570b.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.f571c);
                this.f571c = null;
                return true;
            }
        }
        return false;
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        this.f569a.forEachRemaining(new C0428t(8, this, consumer));
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        Spliterator trySplit = this.f569a.mo899trySplit();
        if (trySplit != null) {
            return new C0556g7(trySplit, this.f570b);
        }
        return null;
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        return this.f569a.estimateSize();
    }

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return (this.f569a.characteristics() & (-16469)) | 1;
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f569a.getComparator();
    }
}
