package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0471n;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.m7 */
/* loaded from: classes2.dex */
public final class C0616m7 extends AbstractC0744z6 implements AbstractC0757y0 {
    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m522m(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m562C(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0744z6
    /* renamed from: e */
    public final AbstractC0744z6 mo18e(Spliterator spliterator) {
        return new AbstractC0744z6(this.f863b, spliterator, this.f862a);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.t6, java.lang.Object, j$.util.stream.c, java.util.function.LongConsumer] */
    @Override // p004j$.util.stream.AbstractC0744z6
    /* renamed from: d */
    public final void mo19d() {
        ?? t6Var = new AbstractC0685t6();
        this.f869h = t6Var;
        Objects.requireNonNull(t6Var);
        this.f866e = this.f863b.mo140F0(new C0606l7(t6Var, 1));
        this.f867f = new C0471n(11, this);
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        return (AbstractC0757y0) super.mo899trySplit();
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit  reason: collision with other method in class */
    public final AbstractC0405b1 mo899trySplit() {
        return (AbstractC0757y0) super.mo899trySplit();
    }

    @Override // p004j$.util.stream.AbstractC0744z6, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final AbstractC0757y0 mo899trySplit() {
        return (AbstractC0757y0) super.mo899trySplit();
    }

    @Override // p004j$.util.AbstractC0757y0
    public final boolean tryAdvance(LongConsumer longConsumer) {
        long j;
        Objects.requireNonNull(longConsumer);
        boolean a = m22a();
        if (a) {
            C0665r6 r6Var = (C0665r6) this.f869h;
            long j2 = this.f868g;
            int r = r6Var.m150r(j2);
            if (r6Var.f507c == 0 && r == 0) {
                j = ((long[]) r6Var.f766e)[(int) j2];
            } else {
                j = ((long[][]) r6Var.f767f)[r][(int) (j2 - r6Var.f508d[r])];
            }
            longConsumer.accept(j);
        }
        return a;
    }

    @Override // p004j$.util.AbstractC0757y0
    public final void forEachRemaining(LongConsumer longConsumer) {
        if (this.f869h != null || this.f870i) {
            do {
            } while (tryAdvance(longConsumer));
            return;
        }
        Objects.requireNonNull(longConsumer);
        m20c();
        Objects.requireNonNull(longConsumer);
        C0606l7 l7Var = new C0606l7(longConsumer, 0);
        this.f863b.mo142E0(this.f865d, l7Var);
        this.f870i = true;
    }
}
