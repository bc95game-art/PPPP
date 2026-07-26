package p004j$.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0436d1;
import p004j$.util.C0471n;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.u6 */
/* loaded from: classes2.dex */
public class C0695u6 extends AbstractC0508c implements Consumer, Iterable {

    /* renamed from: e */
    public Object[] f787e = new Object[1 << 4];

    /* renamed from: f */
    public Object[][] f788f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    /* renamed from: p */
    public final void m86p(long j) {
        long j2;
        Object[][] objArr;
        int i;
        int i2 = this.f507c;
        if (i2 == 0) {
            j2 = this.f787e.length;
        } else {
            j2 = this.f508d[i2] + this.f788f[i2].length;
        }
        if (j > j2) {
            if (this.f788f == null) {
                Object[][] objArr2 = new Object[8];
                this.f788f = objArr2;
                this.f508d = new long[8];
                objArr2[0] = this.f787e;
            }
            int i3 = i2 + 1;
            while (j > j2) {
                Object[][] objArr3 = this.f788f;
                if (i3 >= objArr3.length) {
                    int length = objArr3.length * 2;
                    this.f788f = (Object[][]) Arrays.copyOf(objArr3, length);
                    this.f508d = Arrays.copyOf(this.f508d, length);
                }
                int i4 = this.f505a;
                if (!(i3 == 0 || i3 == 1)) {
                    i4 = Math.min((i4 + i3) - 1, 30);
                }
                int i5 = 1 << i4;
                this.f788f[i3] = new Object[i5];
                long[] jArr = this.f508d;
                jArr[i3] = jArr[i3 - 1] + objArr[i].length;
                j2 += i5;
                i3++;
            }
        }
    }

    @Override // p004j$.util.stream.AbstractC0508c
    public final void clear() {
        Object[][] objArr = this.f788f;
        if (objArr != null) {
            this.f787e = objArr[0];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.f787e;
                if (i >= objArr2.length) {
                    break;
                }
                objArr2[i] = null;
                i++;
            }
            this.f788f = null;
            this.f508d = null;
        } else {
            for (int i2 = 0; i2 < this.f506b; i2++) {
                this.f787e[i2] = null;
            }
        }
        this.f506b = 0;
        this.f507c = 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new C0436d1(spliterator);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer consumer) {
        for (int i = 0; i < this.f507c; i++) {
            for (Object obj : this.f788f[i]) {
                consumer.accept(obj);
            }
        }
        for (int i2 = 0; i2 < this.f506b; i2++) {
            consumer.accept(this.f787e[i2]);
        }
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
        long j;
        int i = this.f506b;
        Object[] objArr = this.f787e;
        if (i == objArr.length) {
            if (this.f788f == null) {
                Object[][] objArr2 = new Object[8];
                this.f788f = objArr2;
                this.f508d = new long[8];
                objArr2[0] = objArr;
            }
            int i2 = this.f507c;
            int i3 = i2 + 1;
            Object[][] objArr3 = this.f788f;
            if (i3 >= objArr3.length || objArr3[i3] == null) {
                if (i2 == 0) {
                    j = objArr.length;
                } else {
                    j = objArr3[i2].length + this.f508d[i2];
                }
                m86p(j + 1);
            }
            this.f506b = 0;
            int i4 = this.f507c + 1;
            this.f507c = i4;
            this.f787e = this.f788f[i4];
        }
        Object[] objArr4 = this.f787e;
        int i5 = this.f506b;
        this.f506b = i5 + 1;
        objArr4[i5] = obj;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(arrayList);
        forEach(new C0471n(8, arrayList));
        String obj = arrayList.toString();
        return "SpinedBuffer:" + obj;
    }

    @Override // java.lang.Iterable
    public Spliterator spliterator() {
        return new C0605l6(this, 0, this.f507c, 0, this.f506b);
    }
}
