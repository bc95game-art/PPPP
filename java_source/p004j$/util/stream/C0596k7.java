package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.AbstractC0751v0;
import p004j$.util.C0471n;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.k7 */
/* loaded from: classes2.dex */
public final class C0596k7 extends AbstractC0744z6 implements AbstractC0751v0 {
    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m523l(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m563B(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0744z6
    /* renamed from: e */
    public final AbstractC0744z6 mo18e(Spliterator spliterator) {
        return new AbstractC0744z6(this.f863b, spliterator, this.f862a);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.t6, java.util.function.IntConsumer, java.lang.Object, j$.util.stream.c] */
    @Override // p004j$.util.stream.AbstractC0744z6
    /* renamed from: d */
    public final void mo19d() {
        ?? t6Var = new AbstractC0685t6();
        this.f869h = t6Var;
        Objects.requireNonNull(t6Var);
        this.f866e = this.f863b.mo140F0(new C0586j7(t6Var, 1));
        this.f867f = new C0471n(10, this);
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        return (AbstractC0751v0) super.mo899trySplit();
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit  reason: collision with other method in class */
    public final AbstractC0405b1 mo899trySplit() {
        return (AbstractC0751v0) super.mo899trySplit();
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final AbstractC0751v0 mo899trySplit() {
        return (AbstractC0751v0) super.mo899trySplit();
    }

    @Override // p004j$.util.AbstractC0751v0
    public final boolean tryAdvance(IntConsumer intConsumer) {
        int i;
        Objects.requireNonNull(intConsumer);
        boolean a = m22a();
        if (a) {
            C0645p6 p6Var = (C0645p6) this.f869h;
            long j = this.f868g;
            int r = p6Var.m150r(j);
            if (p6Var.f507c == 0 && r == 0) {
                i = ((int[]) p6Var.f766e)[(int) j];
            } else {
                i = ((int[][]) p6Var.f767f)[r][(int) (j - p6Var.f508d[r])];
            }
            intConsumer.accept(i);
        }
        return a;
    }

    @Override // p004j$.util.AbstractC0751v0
    public final void forEachRemaining(IntConsumer intConsumer) {
        if (this.f869h != null || this.f870i) {
            do {
            } while (tryAdvance(intConsumer));
            return;
        }
        Objects.requireNonNull(intConsumer);
        m20c();
        Objects.requireNonNull(intConsumer);
        C0586j7 j7Var = new C0586j7(intConsumer, 0);
        this.f863b.mo142E0(this.f865d, j7Var);
        this.f870i = true;
    }
}
