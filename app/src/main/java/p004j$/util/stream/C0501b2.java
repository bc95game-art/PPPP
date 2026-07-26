package p004j$.util.stream;

import java.util.function.LongConsumer;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.b2 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0501b2 implements LongConsumer {

    /* renamed from: a */
    public final /* synthetic */ int f501a;

    public /* synthetic */ C0501b2(int i) {
        this.f501a = i;
    }

    private final void accept$j$$util$stream$Node$OfLong$$ExternalSyntheticLambda0(long j) {
    }

    /* renamed from: accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfLong$$ExternalSyntheticLambda0 */
    private final void m215x5441c8bd(long j) {
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        int i = this.f501a;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f501a) {
            case 0:
                return AbstractC0449g.m232b(this, longConsumer);
            default:
                return AbstractC0449g.m232b(this, longConsumer);
        }
    }
}
