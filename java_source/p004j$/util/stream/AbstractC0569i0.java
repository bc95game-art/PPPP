package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.i0 */
/* loaded from: classes2.dex */
public abstract class AbstractC0569i0 implements AbstractC0537e8 {

    /* renamed from: a */
    public boolean f592a;

    /* renamed from: b */
    public Object f593b;

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final /* synthetic */ void mo23c(long j) {
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void m197n(Object obj) {
        if (!this.f592a) {
            this.f592a = true;
            this.f593b = obj;
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return this.f592a;
    }
}
