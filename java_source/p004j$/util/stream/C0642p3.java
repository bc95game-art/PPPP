package p004j$.util.stream;

import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.p3 */
/* loaded from: classes2.dex */
public final class C0642p3 extends AbstractC0652q3 {

    /* renamed from: h */
    public final Object[] f688h;

    public C0642p3(Spliterator spliterator, AbstractC0692u3 u3Var, Object[] objArr) {
        super(spliterator, u3Var, objArr.length);
        this.f688h = objArr;
    }

    public C0642p3(C0642p3 p3Var, Spliterator spliterator, long j, long j2) {
        super(p3Var, spliterator, j, j2, p3Var.f688h.length);
        this.f688h = p3Var.f688h;
    }

    @Override // p004j$.util.stream.AbstractC0652q3
    /* renamed from: a */
    public final AbstractC0652q3 mo165a(Spliterator spliterator, long j, long j2) {
        return new C0642p3(this, spliterator, j, j2);
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.f707f;
        if (i < this.f708g) {
            Object[] objArr = this.f688h;
            this.f707f = i + 1;
            objArr[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f707f));
    }
}
