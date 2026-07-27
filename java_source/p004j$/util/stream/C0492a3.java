package p004j$.util.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import p004j$.util.AbstractC0405b1;
import p004j$.util.C0473n1;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.Spliterators;
/* renamed from: j$.util.stream.a3 */
/* loaded from: classes2.dex */
public class C0492a3 implements AbstractC0491a2 {

    /* renamed from: a */
    public final int[] f490a;

    /* renamed from: b */
    public int f491b;

    @Override // p004j$.util.stream.AbstractC0531e2
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0692u3.m127R(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m124U(this, j, j2);
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
        AbstractC0692u3.m130O(this, (Integer[]) objArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: f */
    public final void mo154f(int i, Object obj) {
        int i2 = this.f491b;
        System.arraycopy(this.f490a, 0, (int[]) obj, i, i2);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: g */
    public final void mo153g(Object obj) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i = 0; i < this.f491b; i++) {
            intConsumer.accept(this.f490a[i]);
        }
    }

    public C0492a3(long j) {
        if (j < 2147483639) {
            this.f490a = new int[(int) j];
            this.f491b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public C0492a3(int[] iArr) {
        this.f490a = iArr;
        this.f491b = iArr.length;
    }

    @Override // p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator */
    public final Spliterator mo904spliterator() {
        int i = this.f491b;
        int[] iArr = this.f490a;
        Spliterators.m276a(((int[]) Objects.requireNonNull(iArr)).length, 0, i);
        return new C0473n1(iArr, 0, i, 1040);
    }

    @Override // p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator  reason: collision with other method in class */
    public final AbstractC0405b1 mo904spliterator() {
        int i = this.f491b;
        int[] iArr = this.f490a;
        Spliterators.m276a(((int[]) Objects.requireNonNull(iArr)).length, 0, i);
        return new C0473n1(iArr, 0, i, 1040);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: b */
    public final Object mo79b() {
        int[] iArr = this.f490a;
        int length = iArr.length;
        int i = this.f491b;
        return length == i ? iArr : Arrays.copyOf(iArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final long count() {
        return this.f491b;
    }

    public String toString() {
        int[] iArr = this.f490a;
        return String.format("IntArrayNode[%d][%s]", Integer.valueOf(iArr.length - this.f491b), Arrays.toString(iArr));
    }
}
