package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.l7 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0606l7 implements AbstractC0584j5 {

    /* renamed from: a */
    public final /* synthetic */ int f652a;

    /* renamed from: b */
    public final /* synthetic */ LongConsumer f653b;

    public /* synthetic */ C0606l7(LongConsumer longConsumer, int i) {
        this.f652a = i;
        this.f653b = longConsumer;
    }

    /* renamed from: a */
    private final /* synthetic */ void m175a(long j) {
    }

    /* renamed from: b */
    private final /* synthetic */ void m174b(long j) {
    }

    /* renamed from: f */
    private final /* synthetic */ void m173f() {
    }

    /* renamed from: g */
    private final /* synthetic */ void m172g() {
    }

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        switch (this.f652a) {
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
        switch (this.f652a) {
            case 0:
                AbstractC0692u3.m134K();
                throw null;
            default:
                AbstractC0692u3.m134K();
                throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0584j5, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        switch (this.f652a) {
            case 0:
                this.f653b.accept(j);
                return;
            default:
                ((C0665r6) this.f653b).accept(j);
                return;
        }
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f652a) {
            case 0:
                mo78l((Long) obj);
                return;
            default:
                mo78l((Long) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f652a) {
            case 0:
                return AbstractC0279a.m532d(this, consumer);
            default:
                return AbstractC0279a.m532d(this, consumer);
        }
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f652a) {
            case 0:
                return AbstractC0449g.m232b(this, longConsumer);
            default:
                return AbstractC0449g.m232b(this, longConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final /* synthetic */ void mo23c(long j) {
        int i = this.f652a;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        switch (this.f652a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
        int i = this.f652a;
    }

    @Override // p004j$.util.stream.AbstractC0584j5
    /* renamed from: l */
    public final /* synthetic */ void mo78l(Long l) {
        switch (this.f652a) {
            case 0:
                AbstractC0692u3.m136I(this, l);
                return;
            default:
                AbstractC0692u3.m136I(this, l);
                return;
        }
    }
}
