package p004j$.util.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import p004j$.util.AbstractC0405b1;
import p004j$.util.C0479p1;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.Spliterators;
/* renamed from: j$.util.stream.j3 */
/* loaded from: classes2.dex */
public class C0582j3 implements AbstractC0511c2 {

    /* renamed from: a */
    public final long[] f613a;

    /* renamed from: b */
    public int f614b;

    @Override // p004j$.util.stream.AbstractC0531e2
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0692u3.m126S(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m123V(this, j, j2);
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
        AbstractC0692u3.m129P(this, (Long[]) objArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: f */
    public final void mo154f(int i, Object obj) {
        int i2 = this.f614b;
        System.arraycopy(this.f613a, 0, (long[]) obj, i, i2);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: g */
    public final void mo153g(Object obj) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i = 0; i < this.f614b; i++) {
            longConsumer.accept(this.f613a[i]);
        }
    }

    public C0582j3(long j) {
        if (j < 2147483639) {
            this.f613a = new long[(int) j];
            this.f614b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public C0582j3(long[] jArr) {
        this.f613a = jArr;
        this.f614b = jArr.length;
    }

    @Override // p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator */
    public final Spliterator mo904spliterator() {
        int i = this.f614b;
        long[] jArr = this.f613a;
        Spliterators.m276a(((long[]) Objects.requireNonNull(jArr)).length, 0, i);
        return new C0479p1(jArr, 0, i, 1040);
    }

    @Override // p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator  reason: collision with other method in class */
    public final AbstractC0405b1 mo904spliterator() {
        int i = this.f614b;
        long[] jArr = this.f613a;
        Spliterators.m276a(((long[]) Objects.requireNonNull(jArr)).length, 0, i);
        return new C0479p1(jArr, 0, i, 1040);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: b */
    public final Object mo79b() {
        long[] jArr = this.f613a;
        int length = jArr.length;
        int i = this.f614b;
        return length == i ? jArr : Arrays.copyOf(jArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final long count() {
        return this.f614b;
    }

    public String toString() {
        long[] jArr = this.f613a;
        return String.format("LongArrayNode[%d][%s]", Integer.valueOf(jArr.length - this.f614b), Arrays.toString(jArr));
    }
}
