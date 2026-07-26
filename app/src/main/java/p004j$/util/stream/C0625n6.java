package p004j$.util.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0487s0;
import p004j$.util.C0452g1;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.n6 */
/* loaded from: classes2.dex */
public class C0625n6 extends AbstractC0685t6 implements DoubleConsumer {
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: p */
    public final void mo152p(Object obj, int i, int i2, Object obj2) {
        double[] dArr = (double[]) obj;
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj2;
        while (i < i2) {
            doubleConsumer.accept(dArr[i]);
            i++;
        }
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: q */
    public final int mo151q(Object obj) {
        return ((double[]) obj).length;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            mo153g((DoubleConsumer) consumer);
        } else if (!AbstractC0547f8.f558a) {
            AbstractC0279a.m524k((C0615m6) mo904spliterator(), consumer);
        } else {
            AbstractC0547f8.m205a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
            throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: t */
    public final Object[] mo148t() {
        return new double[8];
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    public final Object newArray(int i) {
        return new double[i];
    }

    @Override // java.util.function.DoubleConsumer
    public void accept(double d) {
        m147u();
        int i = this.f506b;
        this.f506b = i + 1;
        ((double[]) this.f766e)[i] = d;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        AbstractC0487s0 v = mo904spliterator();
        Objects.requireNonNull(v);
        return new C0452g1(v);
    }

    /* renamed from: v */
    public AbstractC0487s0 mo904spliterator() {
        return new C0615m6(this, 0, this.f507c, 0, this.f506b);
    }

    public final String toString() {
        double[] dArr = (double[]) mo79b();
        if (dArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f507c), Arrays.toString(dArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f507c), Arrays.toString(Arrays.copyOf(dArr, 200)));
    }
}
