package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.time.C0350g;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.b0 */
/* loaded from: classes2.dex */
public final class C0290b0 extends AbstractC0287a implements Serializable {

    /* renamed from: c */
    public static final C0290b0 f56c = new C0290b0();
    private static final long serialVersionUID = 1039765215346859963L;

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: h */
    public final String mo449h() {
        return "Minguo";
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: q */
    public final AbstractC0311n mo446q(int i) {
        if (i == 0) {
            return EnumC0296e0.BEFORE_ROC;
        }
        if (i == 1) {
            return EnumC0296e0.ROC;
        }
        throw new RuntimeException("Invalid era: " + i);
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: n */
    public final String mo447n() {
        return "roc";
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: t */
    public final AbstractC0289b mo445t(AbstractC0377n nVar) {
        if (nVar instanceof C0294d0) {
            return (C0294d0) nVar;
        }
        return new C0294d0(C0350g.m404E(nVar));
    }

    /* renamed from: j */
    public final C0384u m488j(EnumC0364a aVar) {
        int i = AbstractC0288a0.f55a[aVar.ordinal()];
        if (i == 1) {
            C0384u uVar = EnumC0364a.PROLEPTIC_MONTH.f213b;
            return C0384u.m325e(uVar.f238a - 22932, uVar.f241d - 22932);
        } else if (i == 2) {
            C0384u uVar2 = EnumC0364a.YEAR.f213b;
            return C0384u.m324f(uVar2.f241d - 1911, (-uVar2.f238a) + 1912);
        } else if (i != 3) {
            return aVar.f213b;
        } else {
            C0384u uVar3 = EnumC0364a.YEAR.f213b;
            return C0384u.m325e(uVar3.f238a - 1911, uVar3.f241d - 1911);
        }
    }

    private C0290b0() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new C0298f0((byte) 1, this);
    }
}
