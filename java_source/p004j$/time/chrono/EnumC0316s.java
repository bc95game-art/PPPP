package p004j$.time.chrono;

import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.chrono.s */
/* loaded from: classes2.dex */
public final class EnumC0316s extends Enum implements AbstractC0311n {

    /* renamed from: AH */
    public static final EnumC0316s f98AH;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0316s[] f99a;

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final /* synthetic */ boolean mo299e(AbstractC0380q qVar) {
        return AbstractC0279a.m515t(this, qVar);
    }

    @Override // p004j$.time.chrono.AbstractC0311n
    public final int getValue() {
        return 1;
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

    public static EnumC0316s valueOf(String str) {
        return (EnumC0316s) Enum.valueOf(EnumC0316s.class, str);
    }

    public static EnumC0316s[] values() {
        return (EnumC0316s[]) f99a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.chrono.s] */
    static {
        ?? r0 = new Enum("AH", 0);
        f98AH = r0;
        f99a = new EnumC0316s[]{r0};
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.ERA) {
            return C0384u.m325e(1L, 1L);
        }
        return AbstractC0381r.m331d(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(1, EnumC0364a.ERA);
    }
}
