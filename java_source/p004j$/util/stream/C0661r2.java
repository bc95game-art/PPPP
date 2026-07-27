package p004j$.util.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;
import p004j$.util.AbstractC0405b1;
import p004j$.util.C0458i1;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.Spliterators;
/* renamed from: j$.util.stream.r2 */
/* loaded from: classes2.dex */
public class C0661r2 implements AbstractC0730y1 {

    /* renamed from: a */
    public final double[] f726a;

    /* renamed from: b */
    public int f727b;

    @Override // p004j$.util.stream.AbstractC0531e2
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0692u3.m128Q(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m125T(this, j, j2);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: m */
    public final /* synthetic */ Object[] mo59m(IntFunction intFunction) {
        return AbstractC0692u3.m132M(this, intFunction);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: o */
    public final /* synthetic */ int mo58o() {
        return 0;
    }

    @Override // p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: a */
    public final AbstractC0521d2 mo63a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: k */
    public final /* synthetic */ void mo70k(Object[] objArr, int i) {
        AbstractC0692u3.m131N(this, (Double[]) objArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: f */
    public final void mo154f(int i, Object obj) {
        int i2 = this.f727b;
        System.arraycopy(this.f726a, 0, (double[]) obj, i, i2);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: g */
    public final void mo153g(Object obj) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i = 0; i < this.f727b; i++) {
            doubleConsumer.accept(this.f726a[i]);
        }
    }

    public C0661r2(long j) {
        if (j < 2147483639) {
            this.f726a = new double[(int) j];
            this.f727b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public C0661r2(double[] dArr) {
        this.f726a = dArr;
        this.f727b = dArr.length;
    }

    @Override // p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator */
    public final Spliterator mo904spliterator() {
        int i = this.f727b;
        double[] dArr = this.f726a;
        Spliterators.m276a(((double[]) Objects.requireNonNull(dArr)).length, 0, i);
        return new C0458i1(dArr, 0, i, 1040);
    }

    @Override // p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator  reason: collision with other method in class */
    public final AbstractC0405b1 mo904spliterator() {
        int i = this.f727b;
        double[] dArr = this.f726a;
        Spliterators.m276a(((double[]) Objects.requireNonNull(dArr)).length, 0, i);
        return new C0458i1(dArr, 0, i, 1040);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: b */
    public final Object mo79b() {
        double[] dArr = this.f726a;
        int length = dArr.length;
        int i = this.f727b;
        return length == i ? dArr : Arrays.copyOf(dArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final long count() {
        return this.f727b;
    }

    public String toString() {
        double[] dArr = this.f726a;
        return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(dArr.length - this.f727b), Arrays.toString(dArr));
    }
}
