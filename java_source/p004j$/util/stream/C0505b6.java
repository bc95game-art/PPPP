package p004j$.util.stream;

import java.util.Arrays;
/* renamed from: j$.util.stream.b6 */
/* loaded from: classes2.dex */
public final class C0505b6 extends AbstractC0724x5 {

    /* renamed from: c */
    public C0665r6 f503c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [j$.util.stream.t6] */
    /* JADX WARN: Type inference failed for: r0v5, types: [j$.util.stream.t6] */
    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        C0665r6 r6Var;
        if (j < 2147483639) {
            if (j > 0) {
                r6Var = new AbstractC0685t6((int) j);
            } else {
                r6Var = new AbstractC0685t6();
            }
            this.f503c = r6Var;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    public final void end() {
        long[] jArr = (long[]) this.f503c.mo79b();
        Arrays.sort(jArr);
        AbstractC0594k5 k5Var = this.f554a;
        k5Var.mo23c(jArr.length);
        int i = 0;
        if (!this.f822b) {
            int length = jArr.length;
            while (i < length) {
                k5Var.accept(jArr[i]);
                i++;
            }
        } else {
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                if (k5Var.mo27e()) {
                    break;
                }
                k5Var.accept(j);
                i++;
            }
        }
        k5Var.end();
    }

    @Override // p004j$.util.stream.AbstractC0584j5, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        this.f503c.accept(j);
    }
}
