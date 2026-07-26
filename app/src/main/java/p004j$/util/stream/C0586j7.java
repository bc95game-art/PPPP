package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.j7 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0586j7 implements AbstractC0574i5 {

    /* renamed from: a */
    public final /* synthetic */ int f620a;

    /* renamed from: b */
    public final /* synthetic */ IntConsumer f621b;

    public /* synthetic */ C0586j7(IntConsumer intConsumer, int i) {
        this.f620a = i;
        this.f621b = intConsumer;
    }

    /* renamed from: a */
    private final /* synthetic */ void m190a(long j) {
    }

    /* renamed from: b */
    private final /* synthetic */ void m189b(long j) {
    }

    /* renamed from: f */
    private final /* synthetic */ void m188f() {
    }

    /* renamed from: g */
    private final /* synthetic */ void m187g() {
    }

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        switch (this.f620a) {
            case 0:
                AbstractC0692u3.m144D();
                throw null;
            default:
                AbstractC0692u3.m144D();
                throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0574i5, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        switch (this.f620a) {
            case 0:
                this.f621b.accept(i);
                return;
            default:
                ((C0645p6) this.f621b).accept(i);
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        switch (this.f620a) {
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
        switch (this.f620a) {
            case 0:
                mo162d((Integer) obj);
                return;
            default:
                mo162d((Integer) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f620a) {
            case 0:
                return AbstractC0279a.m532d(this, consumer);
            default:
                return AbstractC0279a.m532d(this, consumer);
        }
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f620a) {
            case 0:
                return AbstractC0279a.m529f(this, intConsumer);
            default:
                return AbstractC0279a.m529f(this, intConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final /* synthetic */ void mo23c(long j) {
        int i = this.f620a;
    }

    @Override // p004j$.util.stream.AbstractC0574i5
    /* renamed from: d */
    public final /* synthetic */ void mo162d(Integer num) {
        switch (this.f620a) {
            case 0:
                AbstractC0692u3.m139G(this, num);
                return;
            default:
                AbstractC0692u3.m139G(this, num);
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        switch (this.f620a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
        int i = this.f620a;
    }
}
