package p004j$.util;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.util.function.AbstractC0449g;
import p004j$.util.stream.AbstractC0594k5;
/* renamed from: j$.util.k0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0463k0 implements LongConsumer {

    /* renamed from: a */
    public final /* synthetic */ int f441a;

    /* renamed from: b */
    public final /* synthetic */ Consumer f442b;

    public /* synthetic */ C0463k0(Consumer consumer, int i) {
        this.f441a = i;
        this.f442b = consumer;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        switch (this.f441a) {
            case 0:
                this.f442b.accept(Long.valueOf(j));
                return;
            default:
                ((AbstractC0594k5) this.f442b).accept(j);
                return;
        }
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f441a) {
            case 0:
                return AbstractC0449g.m232b(this, longConsumer);
            default:
                return AbstractC0449g.m232b(this, longConsumer);
        }
    }
}
