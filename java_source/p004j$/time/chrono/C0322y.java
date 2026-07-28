package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import p004j$.time.AbstractC0283b;
import p004j$.time.C0350g;
import p004j$.time.C0354k;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.chrono.y */
/* loaded from: classes2.dex */
public final class C0322y extends AbstractC0293d {

    /* renamed from: d */
    public static final C0350g f106d = C0350g.m398K(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a */
    public final transient C0350g f107a;

    /* renamed from: b */
    public final transient C0323z f108b;

    /* renamed from: c */
    public final transient int f109c;

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    /* renamed from: y */
    public final AbstractC0295e mo385y(C0354k kVar) {
        return new C0299g(this, kVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r7.m406C(r0) < 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r7.mo386x() < r0.mo386x()) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0322y(C0350g gVar) {
        boolean z;
        C0350g gVar2 = f106d;
        if (AbstractC0283b.m494b(gVar2)) {
            gVar.getClass();
        }
        if (!z) {
            C0323z h = C0323z.m435h(gVar);
            this.f108b = h;
            this.f109c = (gVar.f173a - h.f113b.f173a) + 1;
            this.f107a = gVar;
            return;
        }
        throw new RuntimeException("JapaneseDate before Meiji 6 is not supported");
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: a */
    public final AbstractC0310m mo387a() {
        return C0320w.f104c;
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    public final int hashCode() {
        C0320w.f104c.getClass();
        return this.f107a.hashCode() ^ (-688086063);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: D */
    public final AbstractC0311n mo444D() {
        return this.f108b;
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        if (qVar == EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == EnumC0364a.ALIGNED_WEEK_OF_MONTH || qVar == EnumC0364a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (qVar instanceof EnumC0364a) {
            return ((EnumC0364a) qVar).isDateBased();
        }
        return qVar != null && qVar.mo339i(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0384u mo296k(AbstractC0380q qVar) {
        int i;
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo338j(this);
        }
        if (mo299e(qVar)) {
            EnumC0364a aVar = (EnumC0364a) qVar;
            int i2 = AbstractC0321x.f105a[aVar.ordinal()];
            if (i2 == 1) {
                return C0384u.m325e(1L, this.f107a.m399J());
            }
            if (i2 == 2) {
                C0323z n = this.f108b.m434n();
                if (n != null) {
                    C0350g gVar = n.f113b;
                    if (gVar.f173a == this.f107a.f173a) {
                        i = gVar.m401H() - 1;
                        if (this.f109c == 1) {
                            i -= this.f108b.f113b.m401H() - 1;
                        }
                        return C0384u.m325e(1L, i);
                    }
                }
                i = this.f107a.m400I() ? 366 : 365;
                if (this.f109c == 1) {
                }
                return C0384u.m325e(1L, i);
            } else if (i2 != 3) {
                return C0320w.f104c.m448j(aVar);
            } else {
                C0323z zVar = this.f108b;
                int i3 = zVar.f113b.f173a;
                C0323z n2 = zVar.m434n();
                if (n2 != null) {
                    return C0384u.m325e(1L, (n2.f113b.f173a - i3) + 1);
                }
                return C0384u.m325e(1L, 999999999 - i3);
            }
        } else {
            throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        switch (AbstractC0321x.f105a[((EnumC0364a) qVar).ordinal()]) {
            case 2:
                if (this.f109c == 1) {
                    return (this.f107a.m401H() - this.f108b.f113b.m401H()) + 1;
                }
                return this.f107a.m401H();
            case 3:
                return this.f109c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
            case 8:
                return this.f108b.f112a;
            default:
                return this.f107a.mo293w(qVar);
        }
    }

    /* renamed from: J */
    public final C0322y mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0322y) super.mo313c(j, qVar);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        if (mo293w(aVar) == j) {
            return this;
        }
        int[] iArr = AbstractC0321x.f105a;
        int i = iArr[aVar.ordinal()];
        if (i == 3 || i == 8 || i == 9) {
            int a = C0320w.f104c.m448j(aVar).m329a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 3) {
                return m436L(this.f108b, a);
            }
            if (i2 == 8) {
                return m436L(C0323z.m433q(a), this.f109c);
            }
            if (i2 == 9) {
                return m437K(this.f107a.m388U(a));
            }
        }
        return m437K(this.f107a.mo313c(j, qVar));
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: I */
    public final AbstractC0289b mo439I(AbstractC0378o oVar) {
        return (C0322y) super.mo311j(oVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0322y) super.mo311j(gVar);
    }

    /* renamed from: L */
    public final C0322y m436L(C0323z zVar, int i) {
        C0320w.f104c.getClass();
        if (zVar != null) {
            int i2 = zVar.f113b.f173a;
            int i3 = (i2 + i) - 1;
            if (i == 1 || (i3 >= -999999999 && i3 <= 999999999 && i3 >= i2 && zVar == C0323z.m435h(C0350g.m398K(i3, 1, 1)))) {
                return m437K(this.f107a.m388U(i3));
            }
            throw new RuntimeException("Invalid yearOfEra value");
        }
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: H */
    public final AbstractC0289b mo440H(long j) {
        return m437K(this.f107a.m393P(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: G */
    public final AbstractC0289b mo441G(long j) {
        return m437K(this.f107a.m394O(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: F */
    public final AbstractC0289b mo442F(long j) {
        return m437K(this.f107a.m395N(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d */
    public final AbstractC0289b mo886d(long j, AbstractC0382s sVar) {
        return (C0322y) super.mo886d(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d  reason: collision with other method in class */
    public final AbstractC0376m mo886d(long j, AbstractC0382s sVar) {
        return (C0322y) super.mo886d(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: E */
    public final AbstractC0289b mo443E(long j, AbstractC0382s sVar) {
        return (C0322y) super.mo310s(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return (C0322y) super.mo310s(j, bVar);
    }

    /* renamed from: K */
    public final C0322y m437K(C0350g gVar) {
        return gVar.equals(this.f107a) ? this : new C0322y(gVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    /* renamed from: x */
    public final long mo386x() {
        return this.f107a.mo386x();
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0322y) {
            return this.f107a.equals(((C0322y) obj).f107a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new C0298f0((byte) 4, this);
    }
}
