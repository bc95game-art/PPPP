package p004j$.time.format;

import p004j$.time.AbstractC0389y;
import p004j$.time.C0325e;
import p004j$.time.chrono.AbstractC0289b;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.chrono.C0317t;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.EnumC0364a;
import p004j$.util.Objects;
/* renamed from: j$.time.format.q */
/* loaded from: classes2.dex */
public final class C0343q {

    /* renamed from: a */
    public final AbstractC0377n f163a;

    /* renamed from: b */
    public final C0327a f164b;

    /* renamed from: c */
    public int f165c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [j$.time.format.p] */
    public C0343q(C0325e eVar, C0327a aVar) {
        EnumC0364a[] values;
        AbstractC0310m mVar = aVar.f126d;
        if (mVar != null) {
            AbstractC0310m mVar2 = (AbstractC0310m) eVar.mo295l(AbstractC0381r.f232b);
            AbstractC0389y yVar = (AbstractC0389y) eVar.mo295l(AbstractC0381r.f231a);
            AbstractC0289b bVar = null;
            mVar = Objects.equals(mVar, mVar2) ? null : mVar;
            Objects.equals(null, yVar);
            if (mVar != null) {
                AbstractC0310m mVar3 = mVar != null ? mVar : mVar2;
                if (mVar != null) {
                    if (eVar.mo299e(EnumC0364a.EPOCH_DAY)) {
                        bVar = mVar3.mo445t(eVar);
                    } else if (!(mVar == C0317t.f100c && mVar2 == null)) {
                        for (EnumC0364a aVar2 : EnumC0364a.values()) {
                            if (aVar2.isDateBased() && eVar.mo299e(aVar2)) {
                                throw new RuntimeException("Unable to apply override chronology '" + mVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + eVar);
                            }
                        }
                    }
                }
                eVar = new C0342p(bVar, eVar, mVar3, yVar);
            }
        }
        this.f163a = eVar;
        this.f164b = aVar;
    }

    /* renamed from: a */
    public final Long m410a(AbstractC0380q qVar) {
        int i = this.f165c;
        AbstractC0377n nVar = this.f163a;
        if (i <= 0 || nVar.mo299e(qVar)) {
            return Long.valueOf(nVar.mo293w(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.f163a.toString();
    }
}
