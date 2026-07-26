package p004j$.time.chrono;

import com.emanuelef.remote_capture.Blacklists;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.C0350g;
import p004j$.time.C0354k;
import p004j$.time.C0390z;
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
/* renamed from: j$.time.chrono.g */
/* loaded from: classes2.dex */
public final class C0299g implements AbstractC0295e, AbstractC0376m, AbstractC0378o, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a */
    public final transient AbstractC0289b f64a;

    /* renamed from: b */
    public final transient C0354k f65b;

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final /* synthetic */ Object mo295l(C0328b bVar) {
        return AbstractC0279a.m513v(this, bVar);
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: z */
    public final /* synthetic */ int compareTo(AbstractC0295e eVar) {
        return AbstractC0279a.m527h(this, eVar);
    }

    /* renamed from: C */
    public static C0299g m483C(AbstractC0310m mVar, AbstractC0376m mVar2) {
        C0299g gVar = (C0299g) mVar2;
        if (mVar.equals(gVar.f64a.mo387a())) {
            return gVar;
        }
        String h = mVar.mo449h();
        String h2 = gVar.f64a.mo387a().mo449h();
        throw new ClassCastException("Chronology mismatch, required: " + h + ", actual: " + h2);
    }

    public C0299g(AbstractC0289b bVar, C0354k kVar) {
        Objects.requireNonNull(bVar, "date");
        Objects.requireNonNull(kVar, "time");
        this.f64a = bVar;
        this.f65b = kVar;
    }

    /* renamed from: G */
    public final C0299g m479G(AbstractC0376m mVar, C0354k kVar) {
        AbstractC0289b bVar = this.f64a;
        return (bVar == mVar && this.f65b == kVar) ? this : new C0299g(AbstractC0293d.m487C(bVar.mo387a(), mVar), kVar);
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: a */
    public final AbstractC0310m mo374a() {
        return this.f64a.mo387a();
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: f */
    public final AbstractC0289b mo372f() {
        return this.f64a;
    }

    public final int hashCode() {
        return this.f64a.hashCode() ^ this.f65b.hashCode();
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return m483C(this.f64a.mo387a(), AbstractC0381r.m333b(this, j, bVar));
    }

    public final String toString() {
        String bVar = this.f64a.toString();
        String kVar = this.f65b.toString();
        return bVar + "T" + kVar;
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: b */
    public final C0354k mo373b() {
        return this.f65b;
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
            return this.f64a.mo296k(qVar);
        }
        C0354k kVar = this.f65b;
        kVar.getClass();
        return AbstractC0381r.m331d(kVar, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        if (qVar instanceof EnumC0364a) {
            return ((EnumC0364a) qVar).m343w() ? this.f65b.mo297i(qVar) : this.f64a.mo297i(qVar);
        }
        return mo296k(qVar).m329a(mo293w(qVar), qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (qVar instanceof EnumC0364a) {
            return ((EnumC0364a) qVar).m343w() ? this.f65b.mo293w(qVar) : this.f64a.mo293w(qVar);
        }
        return qVar.mo336l(this);
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return m479G(gVar, this.f65b);
    }

    /* renamed from: F */
    public final C0299g mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return m483C(this.f64a.mo387a(), qVar.mo335o(this, j));
        }
        if (((EnumC0364a) qVar).m343w()) {
            return m479G(this.f64a, this.f65b.mo313c(j, qVar));
        }
        return m479G(this.f64a.mo313c(j, qVar), this.f65b);
    }

    /* renamed from: D */
    public final C0299g mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return m483C(this.f64a.mo387a(), sVar.mo330i(this, j));
        }
        switch (AbstractC0297f.f61a[((EnumC0365b) sVar).ordinal()]) {
            case 1:
                return m481E(this.f64a, 0L, 0L, 0L, j);
            case 2:
                C0299g G = m479G(this.f64a.mo886d(j / 86400000000L, (AbstractC0382s) EnumC0365b.DAYS), this.f65b);
                return G.m481E(G.f64a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                C0299g G2 = m479G(this.f64a.mo886d(j / Blacklists.BLACKLISTS_UPDATE_MILLIS, (AbstractC0382s) EnumC0365b.DAYS), this.f65b);
                return G2.m481E(G2.f64a, 0L, 0L, 0L, (j % Blacklists.BLACKLISTS_UPDATE_MILLIS) * 1000000);
            case 4:
                return m481E(this.f64a, 0L, 0L, j, 0L);
            case 5:
                return m481E(this.f64a, 0L, j, 0L, 0L);
            case 6:
                return m481E(this.f64a, j, 0L, 0L, 0L);
            case 7:
                C0299g G3 = m479G(this.f64a.mo886d(j / 256, (AbstractC0382s) EnumC0365b.DAYS), this.f65b);
                return G3.m481E(G3.f64a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return m479G(this.f64a.mo886d(j, sVar), this.f65b);
        }
    }

    /* renamed from: E */
    public final C0299g m481E(AbstractC0289b bVar, long j, long j2, long j3, long j4) {
        if ((j | j2 | j3 | j4) == 0) {
            return m479G(bVar, this.f65b);
        }
        long j5 = j / 24;
        long j6 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
        long N = this.f65b.m358N();
        long j7 = j6 + N;
        long V = AbstractC0279a.m543V(j7, 86400000000000L) + j5 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long U = AbstractC0279a.m544U(j7, 86400000000000L);
        return m479G(bVar.mo886d(V, (AbstractC0382s) EnumC0365b.DAYS), U == N ? this.f65b : C0354k.m365G(U));
    }

    @Override // p004j$.time.chrono.AbstractC0295e
    /* renamed from: m */
    public final AbstractC0305j mo371m(C0390z zVar) {
        return C0309l.m473C(zVar, null, this);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(mo372f().mo386x(), EnumC0364a.EPOCH_DAY).mo313c(mo373b().m358N(), EnumC0364a.NANO_OF_DAY);
    }

    private Object writeReplace() {
        return new C0298f0((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC0295e) && AbstractC0279a.m527h(this, (AbstractC0295e) obj) == 0;
    }
}
