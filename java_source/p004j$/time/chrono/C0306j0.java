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
/* renamed from: j$.time.chrono.j0 */
/* loaded from: classes2.dex */
public final class C0306j0 extends AbstractC0293d {
    private static final long serialVersionUID = -8722293800195731463L;

    /* renamed from: a */
    public final transient C0350g f75a;

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    /* renamed from: y */
    public final AbstractC0295e mo385y(C0354k kVar) {
        return new C0299g(this, kVar);
    }

    public C0306j0(C0350g gVar) {
        Objects.requireNonNull(gVar, "isoDate");
        this.f75a = gVar;
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: a */
    public final AbstractC0310m mo387a() {
        return C0302h0.f72c;
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    public final int hashCode() {
        C0302h0.f72c.getClass();
        return this.f75a.hashCode() ^ 146118545;
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: D */
    public final AbstractC0311n mo444D() {
        return m477J() >= 1 ? EnumC0308k0.f77BE : EnumC0308k0.BEFORE_BE;
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
            int i = AbstractC0304i0.f74a[aVar.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                return this.f75a.mo296k(qVar);
            }
            if (i != 4) {
                return C0302h0.f72c.m478j(aVar);
            }
            C0384u uVar = EnumC0364a.YEAR.f213b;
            if (m477J() <= 0) {
                j = (-(uVar.f238a + 543)) + 1;
            } else {
                j = 543 + uVar.f241d;
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
        int i = AbstractC0304i0.f74a[((EnumC0364a) qVar).ordinal()];
        int i2 = 1;
        if (i == 4) {
            int J = m477J();
            if (J < 1) {
                J = 1 - J;
            }
            return J;
        } else if (i == 5) {
            return ((m477J() * 12) + this.f75a.f174b) - 1;
        } else {
            if (i == 6) {
                return m477J();
            }
            if (i != 7) {
                return this.f75a.mo293w(qVar);
            }
            if (m477J() < 1) {
                i2 = 0;
            }
            return i2;
        }
    }

    /* renamed from: J */
    public final int m477J() {
        return this.f75a.f173a + 543;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r2 != 7) goto L19;
     */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0306j0 mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0306j0) super.mo313c(j, qVar);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        if (mo293w(aVar) == j) {
            return this;
        }
        int[] iArr = AbstractC0304i0.f74a;
        int i = iArr[aVar.ordinal()];
        if (i != 4) {
            if (i == 5) {
                C0302h0.f72c.m478j(aVar).m328b(j, aVar);
                C0350g gVar = this.f75a;
                return m475L(gVar.m394O(j - (((m477J() * 12) + gVar.f174b) - 1)));
            } else if (i != 6) {
            }
        }
        int a = C0302h0.f72c.m478j(aVar).m329a(j, aVar);
        int i2 = iArr[aVar.ordinal()];
        if (i2 == 4) {
            C0350g gVar2 = this.f75a;
            if (m477J() < 1) {
                a = 1 - a;
            }
            return m475L(gVar2.m388U(a - 543));
        } else if (i2 == 6) {
            return m475L(this.f75a.m388U(a - 543));
        } else {
            if (i2 == 7) {
                return m475L(this.f75a.m388U((-542) - m477J()));
            }
            return m475L(this.f75a.mo313c(j, qVar));
        }
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: I */
    public final AbstractC0289b mo439I(AbstractC0378o oVar) {
        return (C0306j0) super.mo311j(oVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0306j0) super.mo311j(gVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: H */
    public final AbstractC0289b mo440H(long j) {
        return m475L(this.f75a.m393P(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: G */
    public final AbstractC0289b mo441G(long j) {
        return m475L(this.f75a.m394O(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: F */
    public final AbstractC0289b mo442F(long j) {
        return m475L(this.f75a.m395N(j));
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d */
    public final AbstractC0289b mo886d(long j, AbstractC0382s sVar) {
        return (C0306j0) super.mo886d(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d  reason: collision with other method in class */
    public final AbstractC0376m mo886d(long j, AbstractC0382s sVar) {
        return (C0306j0) super.mo886d(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: E */
    public final AbstractC0289b mo443E(long j, AbstractC0382s sVar) {
        return (C0306j0) super.mo310s(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return (C0306j0) super.mo310s(j, bVar);
    }

    /* renamed from: L */
    public final C0306j0 m475L(C0350g gVar) {
        return gVar.equals(this.f75a) ? this : new C0306j0(gVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    /* renamed from: x */
    public final long mo386x() {
        return this.f75a.mo386x();
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0306j0) {
            return this.f75a.equals(((C0306j0) obj).f75a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new C0298f0((byte) 8, this);
    }
}
