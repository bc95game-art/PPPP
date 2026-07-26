package p004j$.util.stream;

import java.util.Arrays;
/* renamed from: j$.util.stream.h6 */
/* loaded from: classes2.dex */
public final class C0565h6 extends AbstractC0704v5 {

    /* renamed from: c */
    public double[] f583c;

    /* renamed from: d */
    public int f584d;

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        if (j < 2147483639) {
            this.f583c = new double[(int) j];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    public final void end() {
        int i = 0;
        Arrays.sort(this.f583c, 0, this.f584d);
        AbstractC0594k5 k5Var = this.f536a;
        k5Var.mo23c(this.f584d);
        if (!this.f798b) {
            while (i < this.f584d) {
                k5Var.accept(this.f583c[i]);
                i++;
            }
        } else {
            while (i < this.f584d && !k5Var.mo27e()) {
                k5Var.accept(this.f583c[i]);
                i++;
            }
        }
        k5Var.end();
        this.f583c = null;
    }

    @Override // p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        double[] dArr = this.f583c;
        int i = this.f584d;
        this.f584d = i + 1;
        dArr[i] = d;
    }
}
