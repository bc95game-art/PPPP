package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.util.C0471n;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.b8 */
/* loaded from: classes2.dex */
public final class C0507b8 extends AbstractC0744z6 {
    @Override // p004j$.util.stream.AbstractC0744z6
    /* renamed from: e */
    public final AbstractC0744z6 mo18e(Spliterator spliterator) {
        return new AbstractC0744z6(this.f863b, spliterator, this.f862a);
    }

    @Override // p004j$.util.stream.AbstractC0744z6
    /* renamed from: d */
    public final void mo19d() {
        C0695u6 u6Var = new C0695u6();
        this.f869h = u6Var;
        Objects.requireNonNull(u6Var);
        this.f866e = this.f863b.mo140F0(new C0497a8(u6Var, 0));
        this.f867f = new C0471n(12, this);
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean a = m22a();
        if (!a) {
            return a;
        }
        C0695u6 u6Var = (C0695u6) this.f869h;
        long j = this.f868g;
        if (u6Var.f507c == 0) {
            if (j < u6Var.f506b) {
                obj = u6Var.f787e[(int) j];
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
        } else if (j < u6Var.count()) {
            for (int i = 0; i <= u6Var.f507c; i++) {
                long j2 = u6Var.f508d[i];
                Object[] objArr = u6Var.f788f[i];
                if (j < objArr.length + j2) {
                    obj = objArr[(int) (j - j2)];
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
        consumer.accept(obj);
        return a;
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.f869h != null || this.f870i) {
            do {
            } while (tryAdvance(consumer));
            return;
        }
        Objects.requireNonNull(consumer);
        m20c();
        Objects.requireNonNull(consumer);
        C0497a8 a8Var = new C0497a8(consumer, 1);
        this.f863b.mo142E0(this.f865d, a8Var);
        this.f870i = true;
    }
}
