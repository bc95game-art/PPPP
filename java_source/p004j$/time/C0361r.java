package p004j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
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
/* renamed from: j$.time.r */
/* loaded from: classes2.dex */
public final class C0361r implements AbstractC0376m, AbstractC0378o, Comparable, Serializable {

    /* renamed from: c */
    public static final /* synthetic */ int f202c = 0;
    private static final long serialVersionUID = 7264499704384272492L;

    /* renamed from: a */
    public final C0354k f203a;

    /* renamed from: b */
    public final C0390z f204b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0361r rVar = (C0361r) obj;
        if (this.f204b.equals(rVar.f204b)) {
            return this.f203a.compareTo(rVar.f203a);
        }
        int compare = Long.compare(this.f203a.m358N() - (this.f204b.f256a * 1000000000), rVar.f203a.m358N() - (rVar.f204b.f256a * 1000000000));
        return compare == 0 ? this.f203a.compareTo(rVar.f203a) : compare;
    }

    static {
        C0354k kVar = C0354k.f183e;
        C0390z zVar = C0390z.f255g;
        kVar.getClass();
        new C0361r(kVar, zVar);
        C0354k kVar2 = C0354k.f184f;
        C0390z zVar2 = C0390z.f254f;
        kVar2.getClass();
        new C0361r(kVar2, zVar2);
    }

    public C0361r(C0354k kVar, C0390z zVar) {
        this.f203a = (C0354k) Objects.requireNonNull(kVar, "time");
        this.f204b = (C0390z) Objects.requireNonNull(zVar, "offset");
    }

    /* renamed from: D */
    public final C0361r m346D(C0354k kVar, C0390z zVar) {
        return (this.f203a != kVar || !this.f204b.equals(zVar)) ? new C0361r(kVar, zVar) : this;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? ((EnumC0364a) qVar).m343w() || qVar == EnumC0364a.OFFSET_SECONDS : qVar != null && qVar.mo339i(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo338j(this);
        }
        if (qVar == EnumC0364a.OFFSET_SECONDS) {
            return ((EnumC0364a) qVar).f213b;
        }
        C0354k kVar = this.f203a;
        kVar.getClass();
        return AbstractC0381r.m331d(kVar, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final int mo297i(AbstractC0380q qVar) {
        return AbstractC0381r.m334a(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        if (qVar == EnumC0364a.OFFSET_SECONDS) {
            return this.f204b.f256a;
        }
        return this.f203a.mo293w(qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: c */
    public final AbstractC0376m mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0361r) qVar.mo335o(this, j);
        }
        if (qVar != EnumC0364a.OFFSET_SECONDS) {
            return m346D(this.f203a.mo313c(j, qVar), this.f204b);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        return m346D(this.f203a, C0390z.m303I(aVar.f213b.m329a(j, aVar)));
    }

    /* renamed from: C */
    public final C0361r mo886d(long j, AbstractC0382s sVar) {
        if (sVar instanceof EnumC0365b) {
            return m346D(this.f203a.mo886d(j, sVar), this.f204b);
        }
        return (C0361r) sVar.mo330i(this, j);
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
            return this.f204b;
        }
        boolean z = false;
        boolean z2 = bVar == AbstractC0381r.f231a;
        if (bVar == AbstractC0381r.f232b) {
            z = true;
        }
        if ((z2 || z) || bVar == AbstractC0381r.f236f) {
            return null;
        }
        if (bVar == AbstractC0381r.f237g) {
            return this.f203a;
        }
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.NANOS;
        }
        return bVar.m428a(this);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(this.f203a.m358N(), EnumC0364a.NANO_OF_DAY).mo313c(this.f204b.f256a, EnumC0364a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0361r) {
            C0361r rVar = (C0361r) obj;
            if (this.f203a.equals(rVar.f203a) && this.f204b.equals(rVar.f204b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f203a.hashCode() ^ this.f204b.f256a;
    }

    public final String toString() {
        String kVar = this.f203a.toString();
        String str = this.f204b.f257b;
        return kVar + str;
    }

    private Object writeReplace() {
        return new C0363t((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0361r) AbstractC0279a.m538a(gVar, this);
    }
}
