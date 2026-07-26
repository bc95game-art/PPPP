package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntFunction;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.q2 */
/* loaded from: classes2.dex */
public final class C0651q2 extends AbstractC0561h2 {
    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        if (j == 0 && j2 == this.f579c) {
            return this;
        }
        long count = this.f577a.count();
        if (j >= count) {
            return this.f578b.mo60j(j - count, j2 - count, intFunction);
        } else if (j2 <= count) {
            return this.f577a.mo60j(j, j2, intFunction);
        } else {
            return AbstractC0692u3.m112f0(EnumC0735y6.REFERENCE, this.f577a.mo60j(j, count, intFunction), this.f578b.mo60j(0L, j2 - count, intFunction));
        }
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator */
    public final Spliterator mo904spliterator() {
        return new AbstractC0572i3(this);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: k */
    public final void mo70k(Object[] objArr, int i) {
        Objects.requireNonNull(objArr);
        AbstractC0531e2 e2Var = this.f577a;
        e2Var.mo70k(objArr, i);
        this.f578b.mo70k(objArr, i + ((int) e2Var.count()));
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: m */
    public final Object[] mo59m(IntFunction intFunction) {
        long j = this.f579c;
        if (j < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) j);
            mo70k(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final void forEach(Consumer consumer) {
        this.f577a.forEach(consumer);
        this.f578b.forEach(consumer);
    }

    public final String toString() {
        long j = this.f579c;
        return j < 32 ? String.format("ConcNode[%s.%s]", this.f577a, this.f578b) : String.format("ConcNode[size=%d]", Long.valueOf(j));
    }
}
