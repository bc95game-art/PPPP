package p004j$.util.stream;

import java.util.ArrayList;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0471n;
import p004j$.util.List;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.g6 */
/* loaded from: classes2.dex */
public final class C0555g6 extends AbstractC0734y5 {

    /* renamed from: d */
    public ArrayList f567d;

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        if (j < 2147483639) {
            this.f567d = j >= 0 ? new ArrayList((int) j) : new ArrayList();
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    public final void end() {
        List.EL.sort(this.f567d, this.f851b);
        AbstractC0594k5 k5Var = this.f566a;
        k5Var.mo23c(this.f567d.size());
        if (!this.f852c) {
            ArrayList arrayList = this.f567d;
            Objects.requireNonNull(k5Var);
            AbstractC0279a.m553L(arrayList, new C0471n(7, k5Var));
        } else {
            ArrayList arrayList2 = this.f567d;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                if (k5Var.mo27e()) {
                    break;
                }
                k5Var.accept((AbstractC0594k5) obj);
            }
        }
        k5Var.end();
        this.f567d = null;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f567d.add(obj);
    }
}
