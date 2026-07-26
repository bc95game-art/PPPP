package p004j$.time;

import com.emanuelef.remote_capture.Blacklists;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.chrono.AbstractC0289b;
import p004j$.time.chrono.AbstractC0295e;
import p004j$.time.chrono.AbstractC0305j;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
import p004j$.util.Objects;
/* renamed from: j$.time.i */
/* loaded from: classes2.dex */
public final class C0352i implements AbstractC0376m, AbstractC0378o, AbstractC0295e, Serializable {

    /* renamed from: c */
    public static final C0352i f177c = m381F(C0350g.f171d, C0354k.f183e);

    /* renamed from: d */
    public static final C0352i f178d = m381F(C0350g.f172e, C0354k.f184f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a */
    public final C0350g f179a;

    /* renamed from: b */
    public final C0354k f180b;

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: a */
    public final AbstractC0310m mo374a() {
        return ((C0350g) mo372f()).mo387a();
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: m */
    public final AbstractC0305j mo371m(C0390z zVar) {
        return C0286c0.m492C(this, zVar, null);
    }

    /* renamed from: F */
    public static C0352i m381F(C0350g gVar, C0354k kVar) {
        Objects.requireNonNull(gVar, "date");
        Objects.requireNonNull(kVar, "time");
        return new C0352i(gVar, kVar);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(((C0350g) mo372f()).mo386x(), EnumC0364a.EPOCH_DAY).mo313c(mo373b().m358N(), EnumC0364a.NANO_OF_DAY);
    }

    /* renamed from: G */
    public static C0352i m380G(long j, int i, C0390z zVar) {
        long j2;
        long j3;
        Objects.requireNonNull(zVar, "offset");
        long j4 = i;
        EnumC0364a.NANO_OF_SECOND.m344s(j4);
        return new C0352i(C0350g.m397L(AbstractC0279a.m543V(j + zVar.f256a, 86400)), C0354k.m365G((((int) AbstractC0279a.m544U(j2, j3)) * 1000000000) + j4));
    }

    /* renamed from: D */
    public static C0352i m383D(AbstractC0377n nVar) {
        if (nVar instanceof C0352i) {
            return (C0352i) nVar;
        }
        if (nVar instanceof C0286c0) {
            return ((C0286c0) nVar).f50a;
        }
        if (nVar instanceof C0360q) {
            return ((C0360q) nVar).f200a;
        }
        try {
            return new C0352i(C0350g.m404E(nVar), C0354k.m367E(nVar));
        } catch (C0281a e) {
            String name = nVar.getClass().getName();
            throw new RuntimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + nVar + " of type " + name, e);
        }
    }

    public C0352i(C0350g gVar, C0354k kVar) {
        this.f179a = gVar;
        this.f180b = kVar;
    }

    /* renamed from: L */
    public final C0352i m375L(C0350g gVar, C0354k kVar) {
        return (this.f179a == gVar && this.f180b == kVar) ? this : new C0352i(gVar, kVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar != null && qVar.mo339i(this);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        return aVar.isDateBased() || aVar.m343w();
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo338j(this);
        }
        if (!((EnumC0364a) qVar).m343w()) {
            return this.f179a.mo296k(qVar);
        }
        C0354k kVar = this.f180b;
        kVar.getClass();
        return AbstractC0381r.m331d(kVar, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (qVar instanceof EnumC0364a) {
            return ((EnumC0364a) qVar).m343w() ? this.f180b.mo297i(qVar) : this.f179a.mo297i(qVar);
        }
        return AbstractC0381r.m334a(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (qVar instanceof EnumC0364a) {
            return ((EnumC0364a) qVar).m343w() ? this.f180b.mo293w(qVar) : this.f179a.mo293w(qVar);
        }
        return qVar.mo336l(this);
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: f */
    public final AbstractC0289b mo372f() {
        return this.f179a;
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: b */
    public final C0354k mo373b() {
        return this.f180b;
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return m375L(gVar, this.f180b);
    }

    /* renamed from: K */
    public final C0352i mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0352i) qVar.mo335o(this, j);
        }
        if (((EnumC0364a) qVar).m343w()) {
            return m375L(this.f179a, this.f180b.mo313c(j, qVar));
        }
        return m375L(this.f179a.mo313c(j, qVar), this.f180b);
    }

    /* renamed from: H */
    public final C0352i mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return (C0352i) sVar.mo330i(this, j);
        }
        switch (AbstractC0351h.f176a[((EnumC0365b) sVar).ordinal()]) {
            case 1:
                return m377J(this.f179a, 0L, 0L, 0L, j);
            case 2:
                C0352i L = m375L(this.f179a.m395N(j / 86400000000L), this.f180b);
                return L.m377J(L.f179a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                C0352i L2 = m375L(this.f179a.m395N(j / Blacklists.BLACKLISTS_UPDATE_MILLIS), this.f180b);
                return L2.m377J(L2.f179a, 0L, 0L, 0L, (j % Blacklists.BLACKLISTS_UPDATE_MILLIS) * 1000000);
            case 4:
                return m378I(j);
            case 5:
                return m377J(this.f179a, 0L, j, 0L, 0L);
            case 6:
                return m377J(this.f179a, j, 0L, 0L, 0L);
            case 7:
                C0352i L3 = m375L(this.f179a.m395N(j / 256), this.f180b);
                return L3.m377J(L3.f179a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return m375L(this.f179a.mo886d(j, sVar), this.f180b);
        }
    }

    /* renamed from: I */
    public final C0352i m378I(long j) {
        return m377J(this.f179a, 0L, 0L, j, 0L);
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return j == Long.MIN_VALUE ? mo886d(Long.MAX_VALUE, bVar).mo886d(1L, bVar) : mo886d(-j, bVar);
    }

    /* renamed from: J */
    public final C0352i m377J(C0350g gVar, long j, long j2, long j3, long j4) {
        if ((j | j2 | j3 | j4) == 0) {
            return m375L(gVar, this.f180b);
        }
        long j5 = 1;
        long N = this.f180b.m358N();
        long j6 = ((((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L)) * j5) + N;
        long V = AbstractC0279a.m543V(j6, 86400000000000L) + (((j / 24) + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L)) * j5);
        long U = AbstractC0279a.m544U(j6, 86400000000000L);
        return m375L(gVar.m395N(V), U == N ? this.f180b : C0354k.m365G(U));
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f236f) {
            return this.f179a;
        }
        return AbstractC0279a.m513v(this, bVar);
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: z */
    public final int compareTo(AbstractC0295e eVar) {
        if (eVar instanceof C0352i) {
            return m384C((C0352i) eVar);
        }
        return AbstractC0279a.m527h(this, eVar);
    }

    /* renamed from: C */
    public final int m384C(C0352i iVar) {
        int C = this.f179a.m406C(iVar.f179a);
        return C == 0 ? this.f180b.compareTo(iVar.f180b) : C;
    }

    /* renamed from: E */
    public final boolean m382E(AbstractC0295e eVar) {
        if (eVar instanceof C0352i) {
            return m384C((C0352i) eVar) < 0;
        }
        int i = (this.f179a.mo386x() > eVar.mo372f().mo386x() ? 1 : (this.f179a.mo386x() == eVar.mo372f().mo386x() ? 0 : -1));
        if (i >= 0) {
            return i == 0 && this.f180b.m358N() < eVar.mo373b().m358N();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0352i) {
            C0352i iVar = (C0352i) obj;
            if (this.f179a.equals(iVar.f179a) && this.f180b.equals(iVar.f180b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f179a.hashCode() ^ this.f180b.hashCode();
    }

    public final String toString() {
        String gVar = this.f179a.toString();
        String kVar = this.f180b.toString();
        return gVar + "T" + kVar;
    }

    private Object writeReplace() {
        return new C0363t((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
