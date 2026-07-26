package p004j$.util.stream;

import java.util.Arrays;
/* renamed from: j$.util.stream.i6 */
/* loaded from: classes2.dex */
public final class C0575i6 extends AbstractC0714w5 {

    /* renamed from: c */
    public int[] f605c;

    /* renamed from: d */
    public int f606d;

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        if (j < 2147483639) {
            this.f605c = new int[(int) j];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    public final void end() {
        int i = 0;
        Arrays.sort(this.f605c, 0, this.f606d);
        AbstractC0594k5 k5Var = this.f544a;
        k5Var.mo23c(this.f606d);
        if (!this.f808b) {
            while (i < this.f606d) {
                k5Var.accept(this.f605c[i]);
                i++;
            }
        } else {
            while (i < this.f606d && !k5Var.mo27e()) {
                k5Var.accept(this.f605c[i]);
                i++;
            }
        }
        k5Var.end();
        this.f605c = null;
    }

    @Override // p004j$.util.stream.AbstractC0574i5, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        int[] iArr = this.f605c;
        int i2 = this.f606d;
        this.f606d = i2 + 1;
        iArr[i2] = i;
    }
}
