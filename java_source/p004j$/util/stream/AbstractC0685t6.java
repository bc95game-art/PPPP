package p004j$.util.stream;

import java.util.Arrays;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.t6 */
/* loaded from: classes2.dex */
public abstract class AbstractC0685t6 extends AbstractC0508c implements Iterable {

    /* renamed from: e */
    public Object f766e = newArray(16);

    /* renamed from: f */
    public Object[] f767f;

    public abstract Object newArray(int i);

    /* renamed from: p */
    public abstract void mo152p(Object obj, int i, int i2, Object obj2);

    /* renamed from: q */
    public abstract int mo151q(Object obj);

    /* renamed from: spliterator */
    public abstract Spliterator mo904spliterator();

    /* renamed from: t */
    public abstract Object[] mo148t();

    public AbstractC0685t6(int i) {
        super(i);
    }

    public AbstractC0685t6() {
    }

    /* renamed from: s */
    public final void m149s(long j) {
        long j2;
        int i;
        int i2 = this.f507c;
        if (i2 == 0) {
            j2 = mo151q(this.f766e);
        } else {
            j2 = mo151q(this.f767f[i2]) + this.f508d[i2];
        }
        if (j > j2) {
            if (this.f767f == null) {
                Object[] t = mo148t();
                this.f767f = t;
                this.f508d = new long[8];
                t[0] = this.f766e;
            }
            int i3 = this.f507c + 1;
            while (j > j2) {
                Object[] objArr = this.f767f;
                if (i3 >= objArr.length) {
                    int length = objArr.length * 2;
                    this.f767f = Arrays.copyOf(objArr, length);
                    this.f508d = Arrays.copyOf(this.f508d, length);
                }
                int i4 = this.f505a;
                if (!(i3 == 0 || i3 == 1)) {
                    i4 = Math.min((i4 + i3) - 1, 30);
                }
                int i5 = 1 << i4;
                this.f767f[i3] = newArray(i5);
                long[] jArr = this.f508d;
                jArr[i3] = jArr[i3 - 1] + mo151q(this.f767f[i]);
                j2 += i5;
                i3++;
            }
        }
    }

    /* renamed from: r */
    public final int m150r(long j) {
        if (this.f507c == 0) {
            if (j < this.f506b) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        } else if (j < count()) {
            for (int i = 0; i <= this.f507c; i++) {
                if (j < this.f508d[i] + mo151q(this.f767f[i])) {
                    return i;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j));
        }
    }

    /* renamed from: f */
    public void mo154f(int i, Object obj) {
        long j = i;
        long count = count() + j;
        if (count > mo151q(obj) || count < j) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.f507c == 0) {
            System.arraycopy(this.f766e, 0, obj, i, this.f506b);
        } else {
            for (int i2 = 0; i2 < this.f507c; i2++) {
                Object obj2 = this.f767f[i2];
                System.arraycopy(obj2, 0, obj, i, mo151q(obj2));
                i += mo151q(this.f767f[i2]);
            }
            int i3 = this.f506b;
            if (i3 > 0) {
                System.arraycopy(this.f766e, 0, obj, i, i3);
            }
        }
    }

    /* renamed from: b */
    public Object mo79b() {
        long count = count();
        if (count < 2147483639) {
            Object newArray = newArray((int) count);
            mo154f(0, newArray);
            return newArray;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    /* renamed from: u */
    public final void m147u() {
        long j;
        if (this.f506b == mo151q(this.f766e)) {
            if (this.f767f == null) {
                Object[] t = mo148t();
                this.f767f = t;
                this.f508d = new long[8];
                t[0] = this.f766e;
            }
            int i = this.f507c;
            int i2 = i + 1;
            Object[] objArr = this.f767f;
            if (i2 >= objArr.length || objArr[i2] == null) {
                if (i == 0) {
                    j = mo151q(this.f766e);
                } else {
                    j = mo151q(objArr[i]) + this.f508d[i];
                }
                m149s(j + 1);
            }
            this.f506b = 0;
            int i3 = this.f507c + 1;
            this.f507c = i3;
            this.f766e = this.f767f[i3];
        }
    }

    @Override // p004j$.util.stream.AbstractC0508c
    public final void clear() {
        Object[] objArr = this.f767f;
        if (objArr != null) {
            this.f766e = objArr[0];
            this.f767f = null;
            this.f508d = null;
        }
        this.f506b = 0;
        this.f507c = 0;
    }

    /* renamed from: g */
    public void mo153g(Object obj) {
        for (int i = 0; i < this.f507c; i++) {
            Object obj2 = this.f767f[i];
            mo152p(obj2, 0, mo151q(obj2), obj);
        }
        mo152p(this.f766e, 0, this.f506b, obj);
    }
}
