package p004j$.util.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0751v0;
import p004j$.util.C0439e1;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.p6 */
/* loaded from: classes2.dex */
public class C0645p6 extends AbstractC0685t6 implements IntConsumer {
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: p */
    public final void mo152p(Object obj, int i, int i2, Object obj2) {
        int[] iArr = (int[]) obj;
        IntConsumer intConsumer = (IntConsumer) obj2;
        while (i < i2) {
            intConsumer.accept(iArr[i]);
            i++;
        }
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: q */
    public final int mo151q(Object obj) {
        return ((int[]) obj).length;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            mo153g((IntConsumer) consumer);
        } else if (!AbstractC0547f8.f558a) {
            AbstractC0279a.m523l((C0635o6) mo904spliterator(), consumer);
        } else {
            AbstractC0547f8.m205a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
            throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    /* renamed from: t */
    public final Object[] mo148t() {
        return new int[8];
    }

    @Override // p004j$.util.stream.AbstractC0685t6
    public final Object newArray(int i) {
        return new int[i];
    }

    @Override // java.util.function.IntConsumer
    public void accept(int i) {
        m147u();
        int i2 = this.f506b;
        this.f506b = i2 + 1;
        ((int[]) this.f766e)[i2] = i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        AbstractC0751v0 v = mo904spliterator();
        Objects.requireNonNull(v);
        return new C0439e1(v);
    }

    /* renamed from: v */
    public AbstractC0751v0 mo904spliterator() {
        return new C0635o6(this, 0, this.f507c, 0, this.f506b);
    }

    public final String toString() {
        int[] iArr = (int[]) mo79b();
        if (iArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f507c), Arrays.toString(iArr));
        }
        return String.format("%s[length=%d, chunks=%d]%s...", getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f507c), Arrays.toString(Arrays.copyOf(iArr, 200)));
    }
}
