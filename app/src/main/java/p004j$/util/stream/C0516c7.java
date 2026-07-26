package p004j$.util.stream;

import java.util.function.LongConsumer;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.c7 */
/* loaded from: classes2.dex */
public final class C0516c7 extends AbstractC0526d7 implements LongConsumer {

    /* renamed from: c */
    public final long[] f520c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    public C0516c7(int i) {
        this.f520c = new long[i];
    }

    @Override // p004j$.util.stream.AbstractC0526d7
    /* renamed from: a */
    public final void mo211a(Object obj, long j) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i = 0; i < j; i++) {
            longConsumer.accept(this.f520c[i]);
        }
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        int i = this.f538b;
        this.f538b = i + 1;
        this.f520c[i] = j;
    }
}
