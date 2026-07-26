package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import p004j$.time.C0350g;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.h0 */
/* loaded from: classes2.dex */
public final class C0302h0 extends AbstractC0287a implements Serializable {

    /* renamed from: c */
    public static final C0302h0 f72c = new C0302h0();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap.put("en", new String[]{"BB", "BE"});
        hashMap.put("th", new String[]{"BB", "BE"});
        hashMap2.put("en", new String[]{"B.B.", "B.E."});
        hashMap2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        hashMap3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        hashMap3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: q */
    public final AbstractC0311n mo446q(int i) {
        if (i == 0) {
            return EnumC0308k0.BEFORE_BE;
        }
        if (i == 1) {
            return EnumC0308k0.f77BE;
        }
        throw new RuntimeException("Invalid era: " + i);
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: h */
    public final String mo449h() {
        return "ThaiBuddhist";
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: n */
    public final String mo447n() {
        return "buddhist";
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: t */
    public final AbstractC0289b mo445t(AbstractC0377n nVar) {
        if (nVar instanceof C0306j0) {
            return (C0306j0) nVar;
        }
        return new C0306j0(C0350g.m404E(nVar));
    }

    private C0302h0() {
    }

    /* renamed from: j */
    public final C0384u m478j(EnumC0364a aVar) {
        int i = AbstractC0300g0.f66a[aVar.ordinal()];
        if (i == 1) {
            C0384u uVar = EnumC0364a.PROLEPTIC_MONTH.f213b;
            return C0384u.m325e(uVar.f238a + 6516, uVar.f241d + 6516);
        } else if (i == 2) {
            C0384u uVar2 = EnumC0364a.YEAR.f213b;
            return C0384u.m324f((-(uVar2.f238a + 543)) + 1, uVar2.f241d + 543);
        } else if (i != 3) {
            return aVar.f213b;
        } else {
            C0384u uVar3 = EnumC0364a.YEAR.f213b;
            return C0384u.m325e(uVar3.f238a + 543, uVar3.f241d + 543);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new C0298f0((byte) 1, this);
    }
}
