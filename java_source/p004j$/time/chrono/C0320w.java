package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.time.C0350g;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.w */
/* loaded from: classes2.dex */
public final class C0320w extends AbstractC0287a implements Serializable {

    /* renamed from: c */
    public static final C0320w f104c = new C0320w();
    private static final long serialVersionUID = 459996390165777884L;

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: h */
    public final String mo449h() {
        return "Japanese";
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: n */
    public final String mo447n() {
        return "japanese";
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: t */
    public final AbstractC0289b mo445t(AbstractC0377n nVar) {
        if (nVar instanceof C0322y) {
            return (C0322y) nVar;
        }
        return new C0322y(C0350g.m404E(nVar));
    }

    private C0320w() {
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: q */
    public final AbstractC0311n mo446q(int i) {
        return C0323z.m433q(i);
    }

    /* renamed from: j */
    public final C0384u m448j(EnumC0364a aVar) {
        C0323z[] zVarArr;
        switch (AbstractC0319v.f103a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new RuntimeException("Unsupported field: " + aVar);
            case 5:
                C0323z[] zVarArr2 = C0323z.f111e;
                int i = zVarArr2[zVarArr2.length - 1].f113b.f173a;
                int i2 = 1000000000 - zVarArr2[zVarArr2.length - 1].f113b.f173a;
                int i3 = zVarArr2[0].f113b.f173a;
                int i4 = 1;
                while (true) {
                    C0323z[] zVarArr3 = C0323z.f111e;
                    if (i4 >= zVarArr3.length) {
                        return C0384u.m324f(i2, 999999999 - i);
                    }
                    C0323z zVar = zVarArr3[i4];
                    i2 = Math.min(i2, (zVar.f113b.f173a - i3) + 1);
                    i3 = zVar.f113b.f173a;
                    i4++;
                }
            case 6:
                C0323z zVar2 = C0323z.f110d;
                long j = EnumC0364a.DAY_OF_YEAR.f213b.f240c;
                for (C0323z zVar3 : C0323z.f111e) {
                    j = Math.min(j, ((zVar3.f113b.m400I() ? 366 : 365) - zVar3.f113b.m401H()) + 1);
                    if (zVar3.m434n() != null) {
                        j = Math.min(j, zVar3.m434n().f113b.m401H() - 1);
                    }
                }
                return C0384u.m324f(j, EnumC0364a.DAY_OF_YEAR.f213b.f241d);
            case 7:
                return C0384u.m325e(C0322y.f106d.f173a, 999999999L);
            case 8:
                long j2 = C0323z.f110d.f112a;
                C0323z[] zVarArr4 = C0323z.f111e;
                return C0384u.m325e(j2, zVarArr4[zVarArr4.length - 1].f112a);
            default:
                return aVar.f213b;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new C0298f0((byte) 1, this);
    }
}
