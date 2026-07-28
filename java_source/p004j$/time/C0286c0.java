package p004j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.chrono.AbstractC0289b;
import p004j$.time.chrono.AbstractC0295e;
import p004j$.time.chrono.AbstractC0305j;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
import p004j$.time.zone.C0392b;
import p004j$.time.zone.C0396f;
import p004j$.util.Objects;
/* renamed from: j$.time.c0 */
/* loaded from: classes2.dex */
public final class C0286c0 implements AbstractC0376m, AbstractC0305j, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a */
    public final C0352i f50a;

    /* renamed from: b */
    public final C0390z f51b;

    /* renamed from: c */
    public final AbstractC0389y f52c;

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: B */
    public final /* synthetic */ long mo474B() {
        return AbstractC0279a.m509z(this);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return AbstractC0279a.m526i(this, (AbstractC0305j) obj);
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: a */
    public final AbstractC0310m mo471a() {
        return ((C0350g) mo469f()).mo387a();
    }

    /* renamed from: C */
    public static C0286c0 m492C(C0352i iVar, AbstractC0389y yVar, C0390z zVar) {
        Objects.requireNonNull(iVar, "localDateTime");
        Objects.requireNonNull(yVar, "zone");
        if (yVar instanceof C0390z) {
            return new C0286c0(iVar, yVar, (C0390z) yVar);
        }
        C0396f C = yVar.mo307C();
        List f = C.m280f(iVar);
        if (f.size() == 1) {
            zVar = (C0390z) f.get(0);
        } else if (f.size() == 0) {
            Object e = C.m281e(iVar);
            C0392b bVar = e instanceof C0392b ? (C0392b) e : null;
            iVar = iVar.m378I(Duration.m498i(bVar.f264d.f256a - bVar.f263c.f256a, 0).f42a);
            zVar = bVar.f264d;
        } else if (zVar == null || !f.contains(zVar)) {
            zVar = (C0390z) Objects.requireNonNull((C0390z) f.get(0), "offset");
        }
        return new C0286c0(iVar, yVar, zVar);
    }

    /* renamed from: o */
    public static C0286c0 m490o(long j, int i, AbstractC0389y yVar) {
        C0390z d = yVar.mo307C().m282d(C0325e.m431D(j, i));
        return new C0286c0(C0352i.m380G(j, i, d), yVar, d);
    }

    public C0286c0(C0352i iVar, AbstractC0389y yVar, C0390z zVar) {
        this.f50a = iVar;
        this.f51b = zVar;
        this.f52c = yVar;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar != null && qVar.mo339i(this);
        }
        return true;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo338j(this);
        }
        if (qVar == EnumC0364a.INSTANT_SECONDS || qVar == EnumC0364a.OFFSET_SECONDS) {
            return ((EnumC0364a) qVar).f213b;
        }
        return this.f50a.mo296k(qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return AbstractC0279a.m521n(this, qVar);
        }
        int i = AbstractC0284b0.f47a[((EnumC0364a) qVar).ordinal()];
        if (i == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i != 2) {
            return this.f50a.mo297i(qVar);
        } else {
            return this.f51b.f256a;
        }
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        int i = AbstractC0284b0.f47a[((EnumC0364a) qVar).ordinal()];
        if (i == 1) {
            return AbstractC0279a.m509z(this);
        }
        if (i != 2) {
            return this.f50a.mo293w(qVar);
        }
        return this.f51b.f256a;
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: g */
    public final C0390z mo468g() {
        return this.f51b;
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: v */
    public final AbstractC0389y mo464v() {
        return this.f52c;
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: r */
    public final AbstractC0305j mo465r(AbstractC0389y yVar) {
        Objects.requireNonNull(yVar, "zone");
        return this.f52c.equals(yVar) ? this : m492C(this.f50a, yVar, this.f51b);
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: p */
    public final AbstractC0295e mo466p() {
        return this.f50a;
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: f */
    public final AbstractC0289b mo469f() {
        return this.f50a.f179a;
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: b */
    public final C0354k mo470b() {
        return this.f50a.f180b;
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return m492C(C0352i.m381F(gVar, this.f50a.f180b), this.f52c, this.f51b);
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: c */
    public final AbstractC0376m mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0286c0) qVar.mo335o(this, j);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        int i = AbstractC0284b0.f47a[aVar.ordinal()];
        if (i == 1) {
            return m490o(j, this.f50a.f180b.f190d, this.f52c);
        }
        if (i != 2) {
            return m492C(this.f50a.mo313c(j, qVar), this.f52c, this.f51b);
        }
        C0390z I = C0390z.m303I(aVar.f213b.m329a(j, aVar));
        return (I.equals(this.f51b) || !this.f52c.mo307C().m280f(this.f50a).contains(I)) ? this : new C0286c0(this.f50a, this.f52c, I);
    }

    /* renamed from: D */
    public final C0286c0 mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return (C0286c0) sVar.mo330i(this, j);
        }
        EnumC0365b bVar = (EnumC0365b) sVar;
        if (bVar.compareTo(EnumC0365b.DAYS) >= 0 && bVar != EnumC0365b.FOREVER) {
            return m492C(this.f50a.mo886d(j, sVar), this.f52c, this.f51b);
        }
        C0352i H = this.f50a.mo886d(j, sVar);
        C0390z zVar = this.f51b;
        AbstractC0389y yVar = this.f52c;
        Objects.requireNonNull(H, "localDateTime");
        Objects.requireNonNull(zVar, "offset");
        Objects.requireNonNull(yVar, "zone");
        if (yVar.mo307C().m280f(H).contains(zVar)) {
            return new C0286c0(H, yVar, zVar);
        }
        H.getClass();
        return m490o(AbstractC0279a.m510y(H, zVar), H.f180b.f190d, yVar);
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return j == Long.MIN_VALUE ? mo886d(Long.MAX_VALUE, bVar).mo886d(1L, bVar) : mo886d(-j, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f236f) {
            return this.f50a.f179a;
        }
        return AbstractC0279a.m512w(this, bVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0286c0) {
            C0286c0 c0Var = (C0286c0) obj;
            if (this.f50a.equals(c0Var.f50a) && this.f51b.equals(c0Var.f51b) && this.f52c.equals(c0Var.f52c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f50a.hashCode() ^ this.f51b.f256a) ^ Integer.rotateLeft(this.f52c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f50a.toString() + this.f51b.f257b;
        C0390z zVar = this.f51b;
        AbstractC0389y yVar = this.f52c;
        if (zVar == yVar) {
            return str;
        }
        return str + "[" + yVar.toString() + "]";
    }

    private Object writeReplace() {
        return new C0363t((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
