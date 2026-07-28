package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
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
import p004j$.util.Objects;
/* renamed from: j$.time.chrono.d0 */
/* loaded from: classes2.dex */
public final class C0294d0 extends AbstractC0293d {
    private static final long serialVersionUID = 1300372329181994526L;

    /* renamed from: a */
    public final transient C0350g f59a;

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    /* renamed from: y */
    public final AbstractC0295e mo385y(C0354k kVar) {
        return new C0299g(this, kVar);
    }

    public C0294d0(C0350g gVar) {
        Objects.requireNonNull(gVar, "isoDate");
        this.f59a = gVar;
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: a */
    public final AbstractC0310m mo387a() {
        return C0290b0.f56c;
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    public final int hashCode() {
        C0290b0.f56c.getClass();
        return this.f59a.hashCode() ^ (-1990173233);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: D */
    public final AbstractC0311n mo444D() {
        return m486J() >= 1 ? EnumC0296e0.ROC : EnumC0296e0.BEFORE_ROC;
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        long j;
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo338j(this);
        }
        if (AbstractC0279a.m516s(this, qVar)) {
            EnumC0364a aVar = (EnumC0364a) qVar;
            int i = AbstractC0292c0.f58a[aVar.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                return this.f59a.mo296k(qVar);
            }
            if (i != 4) {
                return C0290b0.f56c.m488j(aVar);
            }
            C0384u uVar = EnumC0364a.YEAR.f213b;
            if (m486J() <= 0) {
                j = (-uVar.f238a) + 1912;
            } else {
                j = uVar.f241d - 1911;
            }
            return C0384u.m325e(1L, j);
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        int i = AbstractC0292c0.f58a[((EnumC0364a) qVar).ordinal()];
        int i2 = 1;
        if (i == 4) {
            int J = m486J();
            if (J < 1) {
                J = 1 - J;
            }
            return J;
        } else if (i == 5) {
            return ((m486J() * 12) + this.f59a.f174b) - 1;
        } else {
            if (i == 6) {
                return m486J();
            }
            if (i != 7) {
                return this.f59a.mo293w(qVar);
            }
            if (m486J() < 1) {
                i2 = 0;
            }
            return i2;
        }
    }

    /* renamed from: J */
    public final int m486J() {
        return this.f59a.f173a - 1911;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r2 != 7) goto L19;
     */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0294d0 mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0294d0) super.mo313c(j, qVar);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        if (mo293w(aVar) == j) {
            return this;
        }
        int[] iArr = AbstractC0292c0.f58a;
        int i = iArr[aVar.ordinal()];
        if (i != 4) {
            if (i == 5) {
                C0290b0.f56c.m488j(aVar).m328b(j, aVar);
                C0350g gVar = this.f59a;
                return m484L(gVar.m394O(j - (((m486J() * 12) + gVar.f174b) - 1)));
            } else if (i != 6) {
            }
        }
        int a = C0290b0.f56c.m488j(aVar).m329a(j, aVar);
        int i2 = iArr[aVar.ordinal()];
        if (i2 == 4) {
            return m484L(this.f59a.m388U(m486J() >= 1 ? a + 1911 : 1912 - a));
        } else if (i2 == 6) {
            return m484L(this.f59a.m388U(a + 1911));
        } else {
            if (i2 == 7) {
                return m484L(this.f59a.m388U(1912 - m486J()));
            }
            return m484L(this.f59a.mo313c(j, qVar));
        }
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: I */
    public final AbstractC0289b mo439I(AbstractC0378o oVar) {
        return (C0294d0) super.mo311j(oVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0294d0) super.mo311j(gVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: H */
    public final AbstractC0289b mo440H(long j) {
        return m484L(this.f59a.m393P(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: G */
    public final AbstractC0289b mo441G(long j) {
        return m484L(this.f59a.m394O(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: F */
    public final AbstractC0289b mo442F(long j) {
        return m484L(this.f59a.m395N(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d */
    public final AbstractC0289b mo886d(long j, AbstractC0382s sVar) {
        return (C0294d0) super.mo886d(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d  reason: collision with other method in class */
    public final AbstractC0376m mo886d(long j, AbstractC0382s sVar) {
        return (C0294d0) super.mo886d(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: E */
    public final AbstractC0289b mo443E(long j, AbstractC0382s sVar) {
        return (C0294d0) super.mo310s(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return (C0294d0) super.mo310s(j, bVar);
    }

    /* renamed from: L */
    public final C0294d0 m484L(C0350g gVar) {
        return gVar.equals(this.f59a) ? this : new C0294d0(gVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    /* renamed from: x */
    public final long mo386x() {
        return this.f59a.mo386x();
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0294d0) {
            return this.f59a.equals(((C0294d0) obj).f59a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new C0298f0((byte) 7, this);
    }
}
