package p004j$.util.stream;

import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.b7 */
/* loaded from: classes2.dex */
public final class C0506b7 extends AbstractC0526d7 implements IntConsumer {

    /* renamed from: c */
    public final int[] f504c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    public C0506b7(int i) {
        this.f504c = new int[i];
    }

    @Override // p004j$.util.stream.AbstractC0526d7
    /* renamed from: a */
    public final void mo211a(Object obj, long j) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i = 0; i < j; i++) {
            intConsumer.accept(this.f504c[i]);
        }
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        int i2 = this.f538b;
        this.f538b = i2 + 1;
        this.f504c[i2] = i;
    }
}
