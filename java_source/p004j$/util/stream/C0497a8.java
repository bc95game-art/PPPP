package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.a8 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0497a8 implements AbstractC0594k5 {

    /* renamed from: a */
    public final /* synthetic */ int f497a;

    /* renamed from: b */
    public final /* synthetic */ Consumer f498b;

    public /* synthetic */ C0497a8(Consumer consumer, int i) {
        this.f497a = i;
        this.f498b = consumer;
    }

    /* renamed from: a */
    private final /* synthetic */ void m221a(long j) {
    }

    /* renamed from: b */
    private final /* synthetic */ void m220b(long j) {
    }

    /* renamed from: f */
    private final /* synthetic */ void m219f() {
    }

    /* renamed from: g */
    private final /* synthetic */ void m218g() {
    }

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        switch (this.f497a) {
            case 0:
                AbstractC0692u3.m144D();
                throw null;
            default:
                AbstractC0692u3.m144D();
                throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        switch (this.f497a) {
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
        switch (this.f497a) {
            case 0:
                AbstractC0692u3.m133L();
                throw null;
            default:
                AbstractC0692u3.m133L();
                throw null;
        }
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f497a) {
            case 0:
                ((C0695u6) this.f498b).accept(obj);
                return;
            default:
                this.f498b.accept(obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f497a) {
            case 0:
                return AbstractC0279a.m532d(this, consumer);
            default:
                return AbstractC0279a.m532d(this, consumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final /* synthetic */ void mo23c(long j) {
        int i = this.f497a;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        switch (this.f497a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
        int i = this.f497a;
    }
}
