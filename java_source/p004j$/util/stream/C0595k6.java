package p004j$.util.stream;

import java.util.Arrays;
/* renamed from: j$.util.stream.k6 */
/* loaded from: classes2.dex */
public final class C0595k6 extends AbstractC0734y5 {

    /* renamed from: d */
    public Object[] f629d;

    /* renamed from: e */
    public int f630e;

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        if (j < 2147483639) {
            this.f629d = new Object[(int) j];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    public final void end() {
        int i = 0;
        Arrays.sort(this.f629d, 0, this.f630e, this.f851b);
        AbstractC0594k5 k5Var = this.f566a;
        k5Var.mo23c(this.f630e);
        if (!this.f852c) {
            while (i < this.f630e) {
                k5Var.accept((AbstractC0594k5) this.f629d[i]);
                i++;
            }
        } else {
            while (i < this.f630e && !k5Var.mo27e()) {
                k5Var.accept((AbstractC0594k5) this.f629d[i]);
                i++;
            }
        }
        k5Var.end();
        this.f629d = null;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Object[] objArr = this.f629d;
        int i = this.f630e;
        this.f630e = i + 1;
        objArr[i] = obj;
    }
}
