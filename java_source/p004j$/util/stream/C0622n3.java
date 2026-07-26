package p004j$.util.stream;

import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.n3 */
/* loaded from: classes2.dex */
public final class C0622n3 extends AbstractC0652q3 implements AbstractC0574i5 {

    /* renamed from: h */
    public final int[] f668h;

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo162d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0574i5
    /* renamed from: d */
    public final /* synthetic */ void mo162d(Integer num) {
        AbstractC0692u3.m139G(this, num);
    }

    public C0622n3(Spliterator spliterator, AbstractC0692u3 u3Var, int[] iArr) {
        super(spliterator, u3Var, iArr.length);
        this.f668h = iArr;
    }

    public C0622n3(C0622n3 n3Var, Spliterator spliterator, long j, long j2) {
        super(n3Var, spliterator, j, j2, n3Var.f668h.length);
        this.f668h = n3Var.f668h;
    }

    @Override // p004j$.util.stream.AbstractC0652q3
    /* renamed from: a */
    public final AbstractC0652q3 mo165a(Spliterator spliterator, long j, long j2) {
        return new C0622n3(this, spliterator, j, j2);
    }

    @Override // p004j$.util.stream.AbstractC0652q3, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        int i2 = this.f707f;
        if (i2 < this.f708g) {
            int[] iArr = this.f668h;
            this.f707f = i2 + 1;
            iArr[i2] = i;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f707f));
    }
}
