package p004j$.time.format;

import java.util.Locale;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.chrono.C0317t;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
/* renamed from: j$.time.format.n */
/* loaded from: classes2.dex */
public final class C0340n implements AbstractC0333g {

    /* renamed from: a */
    public final AbstractC0380q f149a;

    /* renamed from: b */
    public final EnumC0349w f150b;

    /* renamed from: c */
    public final C0329c f151c;

    /* renamed from: d */
    public volatile C0336j f152d;

    public C0340n(AbstractC0380q qVar, EnumC0349w wVar, C0329c cVar) {
        this.f149a = qVar;
        this.f150b = wVar;
        this.f151c = cVar;
    }

    @Override // p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    public final boolean mo423i(C0343q qVar, StringBuilder sb) {
        String str;
        Long a = qVar.m410a(this.f149a);
        if (a == null) {
            return false;
        }
        AbstractC0310m mVar = (AbstractC0310m) qVar.f163a.mo295l(AbstractC0381r.f232b);
        if (mVar == null || mVar == C0317t.f100c) {
            C0329c cVar = this.f151c;
            long longValue = a.longValue();
            EnumC0349w wVar = this.f150b;
            Locale locale = qVar.f164b.f124b;
            str = cVar.f129a.m409a(longValue, wVar);
        } else {
            C0329c cVar2 = this.f151c;
            long longValue2 = a.longValue();
            EnumC0349w wVar2 = this.f150b;
            Locale locale2 = qVar.f164b.f124b;
            str = cVar2.f129a.m409a(longValue2, wVar2);
        }
        if (str == null) {
            if (this.f152d == null) {
                this.f152d = new C0336j(this.f149a, 1, 19, EnumC0348v.NORMAL);
            }
            return this.f152d.mo423i(qVar, sb);
        }
        sb.append(str);
        return true;
    }

    public final String toString() {
        EnumC0349w wVar = EnumC0349w.FULL;
        AbstractC0380q qVar = this.f149a;
        EnumC0349w wVar2 = this.f150b;
        if (wVar2 == wVar) {
            return "Text(" + qVar + ")";
        }
        return "Text(" + qVar + "," + wVar2 + ")";
    }
}
