package p004j$.time.chrono;

import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.chrono.e0 */
/* loaded from: classes2.dex */
public final class EnumC0296e0 extends Enum implements AbstractC0311n {
    public static final EnumC0296e0 BEFORE_ROC;
    public static final EnumC0296e0 ROC;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0296e0[] f60a;

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final /* synthetic */ boolean mo299e(AbstractC0380q qVar) {
        return AbstractC0279a.m515t(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final /* synthetic */ int mo297i(AbstractC0380q qVar) {
        return AbstractC0279a.m520o(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final /* synthetic */ Object mo295l(C0328b bVar) {
        return AbstractC0279a.m511x(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final /* synthetic */ long mo293w(AbstractC0380q qVar) {
        return AbstractC0279a.m518q(this, qVar);
    }

    public static EnumC0296e0 valueOf(String str) {
        return (EnumC0296e0) Enum.valueOf(EnumC0296e0.class, str);
    }

    public static EnumC0296e0[] values() {
        return (EnumC0296e0[]) f60a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.chrono.e0] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.chrono.e0] */
    static {
        ?? r0 = new Enum("BEFORE_ROC", 0);
        BEFORE_ROC = r0;
        ?? r1 = new Enum("ROC", 1);
        ROC = r1;
        f60a = new EnumC0296e0[]{r0, r1};
    }

    @Override // p004j$.time.chrono.AbstractC0311n
    public final int getValue() {
        return ordinal();
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        return AbstractC0381r.m331d(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(getValue(), EnumC0364a.ERA);
    }
}
