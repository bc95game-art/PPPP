package p004j$.util.stream;

import java.util.Arrays;
/* renamed from: j$.util.stream.a6 */
/* loaded from: classes2.dex */
public final class C0495a6 extends AbstractC0714w5 {

    /* renamed from: c */
    public C0645p6 f495c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [j$.util.stream.t6] */
    /* JADX WARN: Type inference failed for: r0v5, types: [j$.util.stream.t6] */
    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        C0645p6 p6Var;
        if (j < 2147483639) {
            if (j > 0) {
                p6Var = new AbstractC0685t6((int) j);
            } else {
                p6Var = new AbstractC0685t6();
            }
            this.f495c = p6Var;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    public final void end() {
        int[] iArr = (int[]) this.f495c.mo79b();
        Arrays.sort(iArr);
        AbstractC0594k5 k5Var = this.f544a;
        k5Var.mo23c(iArr.length);
        int i = 0;
        if (!this.f808b) {
            int length = iArr.length;
            while (i < length) {
                k5Var.accept(iArr[i]);
                i++;
            }
        } else {
            int length2 = iArr.length;
            while (i < length2) {
                int i2 = iArr[i];
                if (k5Var.mo27e()) {
                    break;
                }
                k5Var.accept(i2);
                i++;
            }
        }
        k5Var.end();
    }

    @Override // p004j$.util.stream.AbstractC0574i5, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        this.f495c.accept(i);
    }
}
