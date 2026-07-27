package p004j$.util.stream;

import java.util.Comparator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0455h1;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.Spliterators;
/* renamed from: j$.util.stream.l6 */
/* loaded from: classes2.dex */
public final class C0605l6 implements Spliterator {

    /* renamed from: a */
    public int f646a;

    /* renamed from: b */
    public final int f647b;

    /* renamed from: c */
    public int f648c;

    /* renamed from: d */
    public final int f649d;

    /* renamed from: e */
    public Object[] f650e;

    /* renamed from: f */
    public final /* synthetic */ C0695u6 f651f;

    @Override // p004j$.util.Spliterator
    public final int characteristics() {
        return 16464;
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    public C0605l6(C0695u6 u6Var, int i, int i2, int i3, int i4) {
        this.f651f = u6Var;
        this.f646a = i;
        this.f647b = i2;
        this.f648c = i3;
        this.f649d = i4;
        Object[][] objArr = u6Var.f788f;
        this.f650e = objArr == null ? u6Var.f787e : objArr[i];
    }

    @Override // p004j$.util.Spliterator
    public final long estimateSize() {
        int i = this.f646a;
        int i2 = this.f649d;
        int i3 = this.f647b;
        if (i == i3) {
            return i2 - this.f648c;
        }
        long[] jArr = this.f651f.f508d;
        return ((jArr[i3] + i2) - jArr[i]) - this.f648c;
    }

    @Override // p004j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int i = this.f646a;
        int i2 = this.f647b;
        if (i >= i2 && (i != i2 || this.f648c >= this.f649d)) {
            return false;
        }
        Object[] objArr = this.f650e;
        int i3 = this.f648c;
        this.f648c = i3 + 1;
        consumer.accept(objArr[i3]);
        if (this.f648c == this.f650e.length) {
            this.f648c = 0;
            int i4 = this.f646a + 1;
            this.f646a = i4;
            Object[][] objArr2 = this.f651f.f788f;
            if (objArr2 != null && i4 <= i2) {
                this.f650e = objArr2[i4];
            }
        }
        return true;
    }

    @Override // p004j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        C0695u6 u6Var;
        Objects.requireNonNull(consumer);
        int i = this.f646a;
        int i2 = this.f649d;
        int i3 = this.f647b;
        if (i < i3 || (i == i3 && this.f648c < i2)) {
            int i4 = this.f648c;
            while (true) {
                u6Var = this.f651f;
                if (i >= i3) {
                    break;
                }
                Object[] objArr = u6Var.f788f[i];
                while (i4 < objArr.length) {
                    consumer.accept(objArr[i4]);
                    i4++;
                }
                i++;
                i4 = 0;
            }
            Object[] objArr2 = this.f646a == i3 ? this.f650e : u6Var.f788f[i3];
            while (i4 < i2) {
                consumer.accept(objArr2[i4]);
                i4++;
            }
            this.f646a = i3;
            this.f648c = i2;
        }
    }

    @Override // p004j$.util.Spliterator
    /* renamed from: trySplit */
    public final Spliterator mo899trySplit() {
        int i = this.f646a;
        int i2 = this.f647b;
        if (i < i2) {
            int i3 = i2 - 1;
            int i4 = this.f648c;
            C0695u6 u6Var = this.f651f;
            C0605l6 l6Var = new C0605l6(u6Var, i, i3, i4, u6Var.f788f[i3].length);
            this.f646a = i2;
            this.f648c = 0;
            this.f650e = u6Var.f788f[i2];
            return l6Var;
        } else if (i != i2) {
            return null;
        } else {
            int i5 = this.f648c;
            int i6 = (this.f649d - i5) / 2;
            if (i6 == 0) {
                return null;
            }
            Object[] objArr = this.f650e;
            int i7 = i5 + i6;
            Spliterators.m276a(((Object[]) Objects.requireNonNull(objArr)).length, i5, i7);
            C0455h1 h1Var = new C0455h1(objArr, i5, i7, 1040);
            this.f648c += i6;
            return h1Var;
        }
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }
}
