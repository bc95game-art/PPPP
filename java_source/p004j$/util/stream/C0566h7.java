package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.h7 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0566h7 implements AbstractC0564h5 {

    /* renamed from: a */
    public final /* synthetic */ int f585a;

    /* renamed from: b */
    public final /* synthetic */ DoubleConsumer f586b;

    public /* synthetic */ C0566h7(DoubleConsumer doubleConsumer, int i) {
        this.f585a = i;
        this.f586b = doubleConsumer;
    }

    /* renamed from: a */
    private final /* synthetic */ void m203a(long j) {
    }

    /* renamed from: b */
    private final /* synthetic */ void m202b(long j) {
    }

    /* renamed from: f */
    private final /* synthetic */ void m201f() {
    }

    /* renamed from: g */
    private final /* synthetic */ void m200g() {
    }

    @Override // p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        switch (this.f585a) {
            case 0:
                this.f586b.accept(d);
                return;
            default:
                ((C0625n6) this.f586b).accept(d);
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        switch (this.f585a) {
            case 0:
                AbstractC0692u3.m134K();
                throw null;
            default:
                AbstractC0692u3.m134K();
                throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        switch (this.f585a) {
            case 0:
                AbstractC0692u3.m133L();
                throw null;
            default:
                AbstractC0692u3.m133L();
                throw null;
        }
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f585a) {
            case 0:
                mo56n((Double) obj);
                return;
            default:
                mo56n((Double) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f585a) {
            case 0:
                return AbstractC0279a.m532d(this, consumer);
            default:
                return AbstractC0279a.m532d(this, consumer);
        }
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f585a) {
            case 0:
                return AbstractC0279a.m530e(this, doubleConsumer);
            default:
                return AbstractC0279a.m530e(this, doubleConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final /* synthetic */ void mo23c(long j) {
        int i = this.f585a;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        switch (this.f585a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
        int i = this.f585a;
    }

    @Override // p004j$.util.stream.AbstractC0564h5
    /* renamed from: n */
    public final /* synthetic */ void mo56n(Double d) {
        switch (this.f585a) {
            case 0:
                AbstractC0692u3.m143E(this, d);
                return;
            default:
                AbstractC0692u3.m143E(this, d);
                return;
        }
    }
}
