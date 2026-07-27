package p004j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.chrono.C0317t;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
import p004j$.util.Objects;
/* renamed from: j$.time.q */
/* loaded from: classes2.dex */
public final class C0360q implements AbstractC0376m, AbstractC0378o, Comparable, Serializable {

    /* renamed from: c */
    public static final /* synthetic */ int f199c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a */
    public final C0352i f200a;

    /* renamed from: b */
    public final C0390z f201b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        int i;
        C0360q qVar = (C0360q) obj;
        if (this.f201b.equals(qVar.f201b)) {
            i = this.f200a.compareTo(qVar.f200a);
        } else {
            C0352i iVar = this.f200a;
            C0390z zVar = this.f201b;
            iVar.getClass();
            long y = AbstractC0279a.m510y(iVar, zVar);
            C0352i iVar2 = qVar.f200a;
            C0390z zVar2 = qVar.f201b;
            iVar2.getClass();
            i = Long.compare(y, AbstractC0279a.m510y(iVar2, zVar2));
            if (i == 0) {
                i = this.f200a.f180b.f190d - qVar.f200a.f180b.f190d;
            }
        }
        return i == 0 ? this.f200a.compareTo(qVar.f200a) : i;
    }

    static {
        C0352i iVar = C0352i.f177c;
        C0390z zVar = C0390z.f255g;
        iVar.getClass();
        new C0360q(iVar, zVar);
        C0352i iVar2 = C0352i.f178d;
        C0390z zVar2 = C0390z.f254f;
        iVar2.getClass();
        new C0360q(iVar2, zVar2);
    }

    public C0360q(C0352i iVar, C0390z zVar) {
        this.f200a = (C0352i) Objects.requireNonNull(iVar, "dateTime");
        this.f201b = (C0390z) Objects.requireNonNull(zVar, "offset");
    }

    /* renamed from: D */
    public final C0360q m348D(C0352i iVar, C0390z zVar) {
        return (this.f200a != iVar || !this.f201b.equals(zVar)) ? new C0360q(iVar, zVar) : this;
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
        return this.f200a.mo296k(qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return AbstractC0381r.m334a(this, qVar);
        }
        int i = AbstractC0359p.f198a[((EnumC0364a) qVar).ordinal()];
        if (i == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i != 2) {
            return this.f200a.mo297i(qVar);
        } else {
            return this.f201b.f256a;
        }
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        int i = AbstractC0359p.f198a[((EnumC0364a) qVar).ordinal()];
        if (i == 1) {
            C0352i iVar = this.f200a;
            C0390z zVar = this.f201b;
            iVar.getClass();
            return AbstractC0279a.m510y(iVar, zVar);
        } else if (i != 2) {
            return this.f200a.mo293w(qVar);
        } else {
            return this.f201b.f256a;
        }
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        C0352i iVar = this.f200a;
        return m348D(iVar.m375L(gVar, iVar.f180b), this.f201b);
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: c */
    public final AbstractC0376m mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0360q) qVar.mo335o(this, j);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        int i = AbstractC0359p.f198a[aVar.ordinal()];
        if (i == 1) {
            C0325e D = C0325e.m431D(j, this.f200a.f180b.f190d);
            C0390z zVar = this.f201b;
            Objects.requireNonNull(D, "instant");
            Objects.requireNonNull(zVar, "zone");
            C0390z d = zVar.mo307C().m282d(D);
            return new C0360q(C0352i.m380G(D.f118a, D.f119b, d), d);
        } else if (i != 2) {
            return m348D(this.f200a.mo313c(j, qVar), this.f201b);
        } else {
            return m348D(this.f200a, C0390z.m303I(aVar.f213b.m329a(j, aVar)));
        }
    }

    /* renamed from: C */
    public final C0360q mo886d(long j, AbstractC0382s sVar) {
        if (sVar instanceof EnumC0365b) {
            return m348D(this.f200a.mo886d(j, sVar), this.f201b);
        }
        return (C0360q) sVar.mo330i(this, j);
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return j == Long.MIN_VALUE ? mo886d(Long.MAX_VALUE, bVar).mo886d(1L, bVar) : mo886d(-j, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f234d || bVar == AbstractC0381r.f235e) {
            return this.f201b;
        }
        if (bVar == AbstractC0381r.f231a) {
            return null;
        }
        if (bVar == AbstractC0381r.f236f) {
            return this.f200a.f179a;
        }
        if (bVar == AbstractC0381r.f237g) {
            return this.f200a.f180b;
        }
        if (bVar == AbstractC0381r.f232b) {
            return C0317t.f100c;
        }
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.NANOS;
        }
        return bVar.m428a(this);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(this.f200a.f179a.mo386x(), EnumC0364a.EPOCH_DAY).mo313c(this.f200a.f180b.m358N(), EnumC0364a.NANO_OF_DAY).mo313c(this.f201b.f256a, EnumC0364a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0360q) {
            C0360q qVar = (C0360q) obj;
            if (this.f200a.equals(qVar.f200a) && this.f201b.equals(qVar.f201b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f200a.hashCode() ^ this.f201b.f256a;
    }

    public final String toString() {
        String iVar = this.f200a.toString();
        String str = this.f201b.f257b;
        return iVar + str;
    }

    private Object writeReplace() {
        return new C0363t((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
