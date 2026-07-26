package p004j$.time.format;

import p004j$.time.AbstractC0389y;
import p004j$.time.C0325e;
import p004j$.time.chrono.AbstractC0289b;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.C0384u;
/* renamed from: j$.time.format.p */
/* loaded from: classes2.dex */
public final class C0342p implements AbstractC0377n {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0289b f159a;

    /* renamed from: b */
    public final /* synthetic */ C0325e f160b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC0310m f161c;

    /* renamed from: d */
    public final /* synthetic */ AbstractC0389y f162d;

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final /* synthetic */ int mo297i(AbstractC0380q qVar) {
        return AbstractC0381r.m334a(this, qVar);
    }

    public C0342p(AbstractC0289b bVar, C0325e eVar, AbstractC0310m mVar, AbstractC0389y yVar) {
        this.f159a = bVar;
        this.f160b = eVar;
        this.f161c = mVar;
        this.f162d = yVar;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final boolean mo299e(AbstractC0380q qVar) {
        AbstractC0289b bVar = this.f159a;
        if (bVar == null || !qVar.isDateBased()) {
            return this.f160b.mo299e(qVar);
        }
        return bVar.mo299e(qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        AbstractC0289b bVar = this.f159a;
        if (bVar == null || !qVar.isDateBased()) {
            return AbstractC0381r.m331d(this.f160b, qVar);
        }
        return bVar.mo296k(qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        AbstractC0289b bVar = this.f159a;
        if (bVar == null || !qVar.isDateBased()) {
            return this.f160b.mo293w(qVar);
        }
        return bVar.mo293w(qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final Object mo295l(C0328b bVar) {
        if (bVar == AbstractC0381r.f232b) {
            return this.f161c;
        }
        if (bVar == AbstractC0381r.f231a) {
            return this.f162d;
        }
        if (bVar == AbstractC0381r.f233c) {
            return this.f160b.mo295l(bVar);
        }
        return bVar.m428a(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        AbstractC0310m mVar = this.f161c;
        if (mVar != null) {
            str = " with chronology " + mVar;
        } else {
            str = str2;
        }
        AbstractC0389y yVar = this.f162d;
        if (yVar != null) {
            str2 = " with zone " + yVar;
        }
        return this.f160b + str + str2;
    }
}
