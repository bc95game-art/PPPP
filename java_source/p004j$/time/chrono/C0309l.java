package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.AbstractC0389y;
import p004j$.time.C0325e;
import p004j$.time.C0350g;
import p004j$.time.C0352i;
import p004j$.time.C0354k;
import p004j$.time.C0390z;
import p004j$.time.Duration;
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
/* renamed from: j$.time.chrono.l */
/* loaded from: classes2.dex */
public final class C0309l implements AbstractC0305j, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* renamed from: a */
    public final transient C0299g f79a;

    /* renamed from: b */
    public final transient C0390z f80b;

    /* renamed from: c */
    public final transient AbstractC0389y f81c;

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: B */
    public final /* synthetic */ long mo474B() {
        return AbstractC0279a.m509z(this);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final /* synthetic */ int mo297i(AbstractC0380q qVar) {
        return AbstractC0279a.m521n(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final /* synthetic */ Object mo295l(C0328b bVar) {
        return AbstractC0279a.m512w(this, bVar);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return AbstractC0279a.m526i(this, (AbstractC0305j) obj);
    }

    /* renamed from: C */
    public static C0309l m473C(AbstractC0389y yVar, C0390z zVar, C0299g gVar) {
        Objects.requireNonNull(gVar, "localDateTime");
        Objects.requireNonNull(yVar, "zone");
        if (yVar instanceof C0390z) {
            return new C0309l(yVar, (C0390z) yVar, gVar);
        }
        C0396f C = yVar.mo307C();
        C0352i D = C0352i.m383D(gVar);
        List f = C.m280f(D);
        if (f.size() == 1) {
            zVar = (C0390z) f.get(0);
        } else if (f.size() == 0) {
            Object e = C.m281e(D);
            C0392b bVar = e instanceof C0392b ? (C0392b) e : null;
            gVar = gVar.m481E(gVar.f64a, 0L, 0L, Duration.m498i(bVar.f264d.f256a - bVar.f263c.f256a, 0).f42a, 0L);
            zVar = bVar.f264d;
        } else {
            if (zVar == null || !f.contains(zVar)) {
                zVar = (C0390z) f.get(0);
            }
            gVar = gVar;
        }
        Objects.requireNonNull(zVar, "offset");
        return new C0309l(yVar, zVar, gVar);
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
        return ((C0299g) mo466p()).mo296k(qVar);
    }

    /* renamed from: o */
    public static C0309l m467o(AbstractC0310m mVar, AbstractC0376m mVar2) {
        C0309l lVar = (C0309l) mVar2;
        if (mVar.equals(lVar.mo471a())) {
            return lVar;
        }
        String h = mVar.mo449h();
        String h2 = lVar.mo471a().mo449h();
        throw new ClassCastException("Chronology mismatch, required: " + h + ", actual: " + h2);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        int i = AbstractC0303i.f73a[((EnumC0364a) qVar).ordinal()];
        if (i == 1) {
            return mo474B();
        }
        if (i != 2) {
            return ((C0299g) mo466p()).mo293w(qVar);
        }
        return mo468g().f256a;
    }

    public C0309l(AbstractC0389y yVar, C0390z zVar, C0299g gVar) {
        this.f79a = (C0299g) Objects.requireNonNull(gVar, "dateTime");
        this.f80b = (C0390z) Objects.requireNonNull(zVar, "offset");
        this.f81c = (AbstractC0389y) Objects.requireNonNull(yVar, "zone");
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: g */
    public final C0390z mo468g() {
        return this.f80b;
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: f */
    public final AbstractC0289b mo469f() {
        return ((C0299g) mo466p()).mo372f();
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: b */
    public final C0354k mo470b() {
        return ((C0299g) mo466p()).mo373b();
    }

    public final int hashCode() {
        return (this.f79a.hashCode() ^ this.f80b.f256a) ^ Integer.rotateLeft(this.f81c.hashCode(), 3);
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: p */
    public final AbstractC0295e mo466p() {
        return this.f79a;
    }

    public final String toString() {
        String str = this.f79a.toString() + this.f80b.f257b;
        C0390z zVar = this.f80b;
        AbstractC0389y yVar = this.f81c;
        if (zVar == yVar) {
            return str;
        }
        return str + "[" + yVar.toString() + "]";
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: v */
    public final AbstractC0389y mo464v() {
        return this.f81c;
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: a */
    public final AbstractC0310m mo471a() {
        return mo469f().mo387a();
    }

    @Override // p004j$.time.chrono.AbstractC0305j
    /* renamed from: r */
    public final AbstractC0305j mo465r(AbstractC0389y yVar) {
        return m473C(yVar, this.f80b, this.f79a);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar != null && qVar.mo339i(this);
        }
        return true;
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: c */
    public final AbstractC0376m mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return m467o(mo471a(), qVar.mo335o(this, j));
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        int i = AbstractC0307k.f76a[aVar.ordinal()];
        if (i == 1) {
            return mo886d(j - AbstractC0279a.m509z(this), EnumC0365b.SECONDS);
        }
        if (i != 2) {
            return m473C(this.f81c, this.f80b, this.f79a.mo313c(j, qVar));
        }
        C0390z I = C0390z.m303I(aVar.f213b.m329a(j, aVar));
        C0299g gVar = this.f79a;
        gVar.getClass();
        C0325e D = C0325e.m431D(AbstractC0279a.m510y(gVar, I), gVar.f65b.f190d);
        AbstractC0389y yVar = this.f81c;
        AbstractC0310m a = mo471a();
        C0390z d = yVar.mo307C().m282d(D);
        Objects.requireNonNull(d, "offset");
        return new C0309l(yVar, d, (C0299g) a.mo450u(C0352i.m380G(D.f118a, D.f119b, d)));
    }

    /* renamed from: D */
    public final C0309l mo886d(long j, AbstractC0382s sVar) {
        if (!(sVar instanceof EnumC0365b)) {
            return m467o(mo471a(), sVar.mo330i(this, j));
        }
        return m467o(mo471a(), this.f79a.mo886d(j, sVar).mo294o(this));
    }

    private Object writeReplace() {
        return new C0298f0((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC0305j) && AbstractC0279a.m526i(this, (AbstractC0305j) obj) == 0;
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return m467o(mo471a(), gVar.mo294o(this));
    }

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return m467o(mo471a(), AbstractC0381r.m333b(this, j, bVar));
    }
}
