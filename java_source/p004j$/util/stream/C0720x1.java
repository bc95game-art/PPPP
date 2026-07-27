package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.x1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0720x1 implements DoubleConsumer {

    /* renamed from: a */
    public final /* synthetic */ int f815a;

    public /* synthetic */ C0720x1(int i) {
        this.f815a = i;
    }

    private final void accept$j$$util$stream$Node$OfDouble$$ExternalSyntheticLambda0(double d) {
    }

    /* renamed from: accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfDouble$$ExternalSyntheticLambda0 */
    private final void m71xf5fb7952(double d) {
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        int i = this.f815a;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f815a) {
            case 0:
                return AbstractC0279a.m530e(this, doubleConsumer);
            default:
                return AbstractC0279a.m530e(this, doubleConsumer);
        }
    }
}
