package p004j$.util;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.stream.AbstractC0594k5;
/* renamed from: j$.util.g0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0451g0 implements IntConsumer {

    /* renamed from: a */
    public final /* synthetic */ int f418a;

    /* renamed from: b */
    public final /* synthetic */ Consumer f419b;

    public /* synthetic */ C0451g0(Consumer consumer, int i) {
        this.f418a = i;
        this.f419b = consumer;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        switch (this.f418a) {
            case 0:
                this.f419b.accept(Integer.valueOf(i));
                return;
            default:
                ((AbstractC0594k5) this.f419b).accept(i);
                return;
        }
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f418a) {
            case 0:
                return AbstractC0279a.m529f(this, intConsumer);
            default:
                return AbstractC0279a.m529f(this, intConsumer);
        }
    }
}
