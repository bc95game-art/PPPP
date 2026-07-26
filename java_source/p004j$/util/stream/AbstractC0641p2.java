package p004j$.util.stream;

import java.util.function.IntFunction;
/* renamed from: j$.util.stream.p2 */
/* loaded from: classes2.dex */
public abstract class AbstractC0641p2 extends AbstractC0561h2 implements AbstractC0521d2 {
    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: m */
    public final /* synthetic */ Object[] mo59m(IntFunction intFunction) {
        return AbstractC0692u3.m132M(this, intFunction);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: g */
    public final void mo153g(Object obj) {
        ((AbstractC0521d2) this.f577a).mo153g(obj);
        ((AbstractC0521d2) this.f578b).mo153g(obj);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: f */
    public final void mo154f(int i, Object obj) {
        AbstractC0531e2 e2Var = this.f577a;
        ((AbstractC0521d2) e2Var).mo154f(i, obj);
        ((AbstractC0521d2) this.f578b).mo154f(i + ((int) ((AbstractC0521d2) e2Var).count()), obj);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: b */
    public final Object mo79b() {
        long j = this.f579c;
        if (j < 2147483639) {
            Object newArray = newArray((int) j);
            mo154f(0, newArray);
            return newArray;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final String toString() {
        long j = this.f579c;
        return j < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.f577a, this.f578b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(j));
    }
}
