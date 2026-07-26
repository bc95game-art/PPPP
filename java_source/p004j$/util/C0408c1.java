package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import p004j$.util.Spliterator;
/* renamed from: j$.util.c1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0408c1 implements Spliterator {

    /* renamed from: a */
    public final /* synthetic */ Spliterator f311a;

    public /* synthetic */ C0408c1(Spliterator spliterator) {
        this.f311a = spliterator;
    }

    /* renamed from: a */
    public static /* synthetic */ Spliterator m273a(Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof Spliterator.Wrapper ? Spliterator.this : spliterator instanceof Spliterator.OfPrimitive ? C0759z0.m6a((Spliterator.OfPrimitive) spliterator) : new C0408c1(spliterator);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f311a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.Spliterator spliterator = this.f311a;
        if (obj instanceof C0408c1) {
            obj = ((C0408c1) obj).f311a;
        }
        return spliterator.equals(obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f311a.estimateSize();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f311a.forEachRemaining(consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f311a.getComparator();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f311a.getExactSizeIfKnown();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f311a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f311a.hashCode();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f311a.tryAdvance(consumer);
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final /* synthetic */ Spliterator mo899trySplit() {
        return m273a(this.f311a.trySplit());
    }
}
