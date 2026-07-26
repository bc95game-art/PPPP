package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.p0 */
/* loaded from: classes2.dex */
public abstract class AbstractC0639p0 implements AbstractC0527d8, AbstractC0537e8 {

    /* renamed from: a */
    public final boolean f687a;

    public /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

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
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    public AbstractC0639p0(boolean z) {
        this.f687a = z;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: w */
    public final int mo94w() {
        if (this.f687a) {
            return 0;
        }
        return EnumC0725x6.f835r;
    }

    /* renamed from: a */
    public final void m168a(AbstractC0692u3 u3Var, Spliterator spliterator) {
        if (this.f687a) {
            new C0649q0(u3Var, spliterator, this).invoke();
        } else {
            new C0659r0(u3Var, spliterator, u3Var.mo140F0(this)).invoke();
        }
    }
}
