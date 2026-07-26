package p004j$.util.stream;

import java.util.Arrays;
/* renamed from: j$.util.stream.j6 */
/* loaded from: classes2.dex */
public final class C0585j6 extends AbstractC0724x5 {

    /* renamed from: c */
    public long[] f618c;

    /* renamed from: d */
    public int f619d;

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        if (j < 2147483639) {
            this.f618c = new long[(int) j];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    public final void end() {
        int i = 0;
        Arrays.sort(this.f618c, 0, this.f619d);
        AbstractC0594k5 k5Var = this.f554a;
        k5Var.mo23c(this.f619d);
        if (!this.f822b) {
            while (i < this.f619d) {
                k5Var.accept(this.f618c[i]);
                i++;
            }
        } else {
            while (i < this.f619d && !k5Var.mo27e()) {
                k5Var.accept(this.f618c[i]);
                i++;
            }
        }
        k5Var.end();
        this.f618c = null;
    }

    @Override // p004j$.util.stream.AbstractC0584j5, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        long[] jArr = this.f618c;
        int i = this.f619d;
        this.f619d = i + 1;
        jArr[i] = j;
    }
}
