package p004j$.util.stream;

import java.util.function.LongConsumer;
import p004j$.util.Spliterator;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.o3 */
/* loaded from: classes2.dex */
public final class C0632o3 extends AbstractC0652q3 implements AbstractC0584j5 {

    /* renamed from: h */
    public final long[] f678h;

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo78l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0584j5
    /* renamed from: l */
    public final /* synthetic */ void mo78l(Long l) {
        AbstractC0692u3.m136I(this, l);
    }

    public C0632o3(Spliterator spliterator, AbstractC0692u3 u3Var, long[] jArr) {
        super(spliterator, u3Var, jArr.length);
        this.f678h = jArr;
    }

    public C0632o3(C0632o3 o3Var, Spliterator spliterator, long j, long j2) {
        super(o3Var, spliterator, j, j2, o3Var.f678h.length);
        this.f678h = o3Var.f678h;
    }

    @Override // p004j$.util.stream.AbstractC0652q3
    /* renamed from: a */
    public final AbstractC0652q3 mo165a(Spliterator spliterator, long j, long j2) {
        return new C0632o3(this, spliterator, j, j2);
    }

    @Override // p004j$.util.stream.AbstractC0652q3, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        int i = this.f707f;
        if (i < this.f708g) {
            long[] jArr = this.f678h;
            this.f707f = i + 1;
            jArr[i] = j;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f707f));
    }
}
