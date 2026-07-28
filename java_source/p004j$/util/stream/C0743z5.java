package p004j$.util.stream;

import java.util.Arrays;
/* renamed from: j$.util.stream.z5 */
/* loaded from: classes2.dex */
public final class C0743z5 extends AbstractC0704v5 {

    /* renamed from: c */
    public C0625n6 f861c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [j$.util.stream.t6] */
    /* JADX WARN: Type inference failed for: r0v5, types: [j$.util.stream.t6] */
    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        C0625n6 n6Var;
        if (j < 2147483639) {
            if (j > 0) {
                n6Var = new AbstractC0685t6((int) j);
            } else {
                n6Var = new AbstractC0685t6();
            }
            this.f861c = n6Var;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    public final void end() {
        double[] dArr = (double[]) this.f861c.mo79b();
        Arrays.sort(dArr);
        AbstractC0594k5 k5Var = this.f536a;
        k5Var.mo23c(dArr.length);
        int i = 0;
        if (!this.f798b) {
            int length = dArr.length;
            while (i < length) {
                k5Var.accept(dArr[i]);
                i++;
            }
        } else {
            int length2 = dArr.length;
            while (i < length2) {
                double d = dArr[i];
                if (k5Var.mo27e()) {
                    break;
                }
                k5Var.accept(d);
                i++;
            }
        }
        k5Var.end();
    }

    @Override // p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f861c.accept(d);
    }
}
