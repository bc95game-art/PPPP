package p004j$.util.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import p004j$.util.C0455h1;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.Spliterators;
/* renamed from: j$.util.stream.i2 */
/* loaded from: classes2.dex */
public class C0571i2 implements AbstractC0531e2 {

    /* renamed from: a */
    public final Object[] f595a;

    /* renamed from: b */
    public int f596b;

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

    public C0571i2(long j, IntFunction intFunction) {
        if (j < 2147483639) {
            this.f595a = (Object[]) intFunction.apply((int) j);
            this.f596b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public C0571i2(Object[] objArr) {
        this.f595a = objArr;
        this.f596b = objArr.length;
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator */
    public final Spliterator mo904spliterator() {
        int i = this.f596b;
        Object[] objArr = this.f595a;
        Spliterators.m276a(((Object[]) Objects.requireNonNull(objArr)).length, 0, i);
        return new C0455h1(objArr, 0, i, 1040);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: k */
    public final void mo70k(Object[] objArr, int i) {
        System.arraycopy(this.f595a, 0, objArr, i, this.f596b);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: m */
    public final Object[] mo59m(IntFunction intFunction) {
        Object[] objArr = this.f595a;
        if (objArr.length == this.f596b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final long count() {
        return this.f596b;
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final void forEach(Consumer consumer) {
        for (int i = 0; i < this.f596b; i++) {
            consumer.accept(this.f595a[i]);
        }
    }

    public String toString() {
        Object[] objArr = this.f595a;
        return String.format("ArrayNode[%d][%s]", Integer.valueOf(objArr.length - this.f596b), Arrays.toString(objArr));
    }
}
