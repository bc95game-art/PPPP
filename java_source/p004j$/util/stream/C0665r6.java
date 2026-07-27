package p004j$.util.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0442f1;
import p004j$.util.Objects;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.r6 */
/* loaded from: classes2.dex */
public class C0665r6 extends AbstractC0685t6 implements LongConsumer {
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: p */
    public final void mo152p(Object obj, int i, int i2, Object obj2) {
        long[] jArr = (long[]) obj;
        LongConsumer longConsumer = (LongConsumer) obj2;
        while (i < i2) {
            longConsumer.accept(jArr[i]);
            i++;
        }
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: q */
    public final int mo151q(Object obj) {
        return ((long[]) obj).length;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            mo153g((LongConsumer) consumer);
        } else if (!AbstractC0547f8.f558a) {
            AbstractC0279a.m522m((C0655q6) mo904spliterator(), consumer);
        } else {
            AbstractC0547f8.m205a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
            throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: t */
    public final Object[] mo148t() {
        return new long[8];
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    public final Object newArray(int i) {
        return new long[i];
    }

    @Override // java.util.function.LongConsumer
    public void accept(long j) {
        m147u();
        int i = this.f506b;
        this.f506b = i + 1;
        ((long[]) this.f766e)[i] = j;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        AbstractC0757y0 v = mo904spliterator();
        Objects.requireNonNull(v);
        return new C0442f1(v);
    }

    /* renamed from: v */
    public AbstractC0757y0 mo904spliterator() {
        return new C0655q6(this, 0, this.f507c, 0, this.f506b);
    }

    public final String toString() {
        long[] jArr = (long[]) mo79b();
        if (jArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f507c), Arrays.toString(jArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f507c), Arrays.toString(Arrays.copyOf(jArr, 200)));
    }
}
