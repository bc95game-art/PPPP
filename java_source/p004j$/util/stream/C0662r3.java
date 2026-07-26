package p004j$.util.stream;

import java.util.function.IntFunction;
/* renamed from: j$.util.stream.r3 */
/* loaded from: classes2.dex */
public final class C0662r3 extends C0695u6 implements AbstractC0531e2, AbstractC0710w1 {
    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0710w1
    /* renamed from: build */
    public final AbstractC0531e2 mo903build() {
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final void end() {
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m122W(this, j, j2, intFunction);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: o */
    public final /* synthetic */ int mo58o() {
        return 0;
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: a */
    public final AbstractC0531e2 mo63a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: k */
    public final void mo70k(Object[] objArr, int i) {
        long j = i;
        long count = count() + j;
        if (count > objArr.length || count < j) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.f507c == 0) {
            System.arraycopy(this.f787e, 0, objArr, i, this.f506b);
        } else {
            for (int i2 = 0; i2 < this.f507c; i2++) {
                Object[] objArr2 = this.f788f[i2];
                System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
                i += this.f788f[i2].length;
            }
            int i3 = this.f506b;
            if (i3 > 0) {
                System.arraycopy(this.f787e, 0, objArr, i, i3);
            }
        }
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: m */
    public final Object[] mo59m(IntFunction intFunction) {
        long count = count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            mo70k(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        clear();
        m86p(j);
    }
}
