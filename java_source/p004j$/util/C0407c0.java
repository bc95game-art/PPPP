package p004j$.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.stream.AbstractC0594k5;
/* renamed from: j$.util.c0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0407c0 implements DoubleConsumer {

    /* renamed from: a */
    public final /* synthetic */ int f309a;

    /* renamed from: b */
    public final /* synthetic */ Consumer f310b;

    public /* synthetic */ C0407c0(Consumer consumer, int i) {
        this.f309a = i;
        this.f310b = consumer;
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        switch (this.f309a) {
            case 0:
                this.f310b.accept(Double.valueOf(d));
                return;
            default:
                ((AbstractC0594k5) this.f310b).accept(d);
                return;
        }
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f309a) {
            case 0:
                return AbstractC0279a.m530e(this, doubleConsumer);
            default:
                return AbstractC0279a.m530e(this, doubleConsumer);
        }
    }
}
