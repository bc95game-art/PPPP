package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.AbstractC0487s0;
import p004j$.util.C0471n;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.i7 */
/* loaded from: classes2.dex */
public final class C0576i7 extends AbstractC0744z6 implements AbstractC0487s0 {
    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m524k(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m564A(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0744z6
    /* renamed from: e */
    public final AbstractC0744z6 mo18e(Spliterator spliterator) {
        return new AbstractC0744z6(this.f863b, spliterator, this.f862a);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.t6, java.lang.Object, j$.util.stream.c, java.util.function.DoubleConsumer] */
    @Override // p004j$.util.stream.AbstractC0744z6
    /* renamed from: d */
    public final void mo19d() {
        ?? t6Var = new AbstractC0685t6();
        this.f869h = t6Var;
        Objects.requireNonNull(t6Var);
        this.f866e = this.f863b.mo140F0(new C0566h7(t6Var, 1));
        this.f867f = new C0471n(9, this);
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        return (AbstractC0487s0) super.mo899trySplit();
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit  reason: collision with other method in class */
    public final AbstractC0405b1 mo899trySplit() {
        return (AbstractC0487s0) super.mo899trySplit();
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final AbstractC0487s0 mo899trySplit() {
        return (AbstractC0487s0) super.mo899trySplit();
    }

    @Override // p004j$.util.AbstractC0487s0
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        double d;
        Objects.requireNonNull(doubleConsumer);
        boolean a = m22a();
        if (a) {
            C0625n6 n6Var = (C0625n6) this.f869h;
            long j = this.f868g;
            int r = n6Var.m150r(j);
            if (n6Var.f507c == 0 && r == 0) {
                d = ((double[]) n6Var.f766e)[(int) j];
            } else {
                d = ((double[][]) n6Var.f767f)[r][(int) (j - n6Var.f508d[r])];
            }
            doubleConsumer.accept(d);
        }
        return a;
    }

    @Override // p004j$.util.AbstractC0487s0
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.f869h != null || this.f870i) {
            do {
            } while (tryAdvance(doubleConsumer));
            return;
        }
        Objects.requireNonNull(doubleConsumer);
        m20c();
        Objects.requireNonNull(doubleConsumer);
        C0566h7 h7Var = new C0566h7(doubleConsumer, 0);
        this.f863b.mo142E0(this.f865d, h7Var);
        this.f870i = true;
    }
}
