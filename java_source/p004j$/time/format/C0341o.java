package p004j$.time.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.temporal.AbstractC0373j;
import p004j$.time.temporal.AbstractC0375l;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0371h;
import p004j$.util.Objects;
/* renamed from: j$.time.format.o */
/* loaded from: classes2.dex */
public final class C0341o {

    /* renamed from: f */
    public static final C0328b f153f = new C0328b(0);

    /* renamed from: a */
    public C0341o f154a;

    /* renamed from: b */
    public final C0341o f155b;

    /* renamed from: c */
    public final List f156c;

    /* renamed from: d */
    public final boolean f157d;

    /* renamed from: e */
    public int f158e;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', EnumC0364a.ERA);
        hashMap.put('y', EnumC0364a.YEAR_OF_ERA);
        hashMap.put('u', EnumC0364a.YEAR);
        EnumC0371h hVar = AbstractC0373j.f221a;
        hashMap.put('Q', hVar);
        hashMap.put('q', hVar);
        EnumC0364a aVar = EnumC0364a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', EnumC0364a.DAY_OF_YEAR);
        hashMap.put('d', EnumC0364a.DAY_OF_MONTH);
        hashMap.put('F', EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        EnumC0364a aVar2 = EnumC0364a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', EnumC0364a.AMPM_OF_DAY);
        hashMap.put('H', EnumC0364a.HOUR_OF_DAY);
        hashMap.put('k', EnumC0364a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', EnumC0364a.HOUR_OF_AMPM);
        hashMap.put('h', EnumC0364a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', EnumC0364a.MINUTE_OF_HOUR);
        hashMap.put('s', EnumC0364a.SECOND_OF_MINUTE);
        EnumC0364a aVar3 = EnumC0364a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', EnumC0364a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', EnumC0364a.NANO_OF_DAY);
        hashMap.put('g', AbstractC0375l.f228a);
    }

    public C0341o() {
        this.f154a = this;
        this.f156c = new ArrayList();
        this.f158e = -1;
        this.f155b = null;
        this.f157d = false;
    }

    public C0341o(C0341o oVar) {
        this.f154a = this;
        this.f156c = new ArrayList();
        this.f158e = -1;
        this.f155b = oVar;
        this.f157d = true;
    }

    /* renamed from: g */
    public final void m416g(AbstractC0380q qVar, int i) {
        Objects.requireNonNull(qVar, "field");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i);
        }
        m417f(new C0336j(qVar, i, i, EnumC0348v.NOT_NEGATIVE));
    }

    /* renamed from: h */
    public final void m415h(AbstractC0380q qVar, int i, int i2, EnumC0348v vVar) {
        if (i == i2 && vVar == EnumC0348v.NOT_NEGATIVE) {
            m416g(qVar, i2);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(vVar, "signStyle");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i);
        } else if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i2);
        } else if (i2 >= i) {
            m417f(new C0336j(qVar, i, i2, vVar));
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
        }
    }

    /* renamed from: f */
    public final void m417f(C0336j jVar) {
        C0336j jVar2;
        C0341o oVar = this.f154a;
        int i = oVar.f158e;
        if (i >= 0) {
            C0336j jVar3 = (C0336j) ((ArrayList) oVar.f156c).get(i);
            int i2 = jVar.f138b;
            int i3 = jVar.f139c;
            if (i2 == i3 && jVar.f140d == EnumC0348v.NOT_NEGATIVE) {
                jVar2 = jVar3.mo425b(i3);
                m421b(jVar.mo426a());
                this.f154a.f158e = i;
            } else {
                jVar2 = jVar3.mo426a();
                this.f154a.f158e = m421b(jVar);
            }
            ((ArrayList) this.f154a.f156c).set(i, jVar2);
            return;
        }
        oVar.f158e = m421b(jVar);
    }

    /* renamed from: e */
    public final void m418e(EnumC0364a aVar, Map map) {
        Objects.requireNonNull(aVar, "field");
        Objects.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        EnumC0349w wVar = EnumC0349w.FULL;
        m421b(new C0340n(aVar, wVar, new C0329c(new C0345s(0, Collections.singletonMap(wVar, linkedHashMap)))));
    }

    /* renamed from: c */
    public final void m420c(char c) {
        m421b(new C0331e(c));
    }

    /* renamed from: d */
    public final void m419d(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            m421b(new C0331e(str.charAt(0)));
        } else {
            m421b(new C0339m(str));
        }
    }

    /* renamed from: a */
    public final void m422a(C0327a aVar) {
        Objects.requireNonNull(aVar, "formatter");
        C0332f fVar = aVar.f123a;
        if (fVar.f133b) {
            fVar = new C0332f(fVar.f132a, false);
        }
        m421b(fVar);
    }

    /* renamed from: j */
    public final void m413j() {
        C0341o oVar = this.f154a;
        oVar.f158e = -1;
        this.f154a = new C0341o(oVar);
    }

    /* renamed from: i */
    public final void m414i() {
        C0341o oVar = this.f154a;
        if (oVar.f155b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        } else if (((ArrayList) oVar.f156c).size() > 0) {
            C0341o oVar2 = this.f154a;
            C0332f fVar = new C0332f(oVar2.f156c, oVar2.f157d);
            this.f154a = this.f154a.f155b;
            m421b(fVar);
        } else {
            this.f154a = this.f154a.f155b;
        }
    }

    /* renamed from: b */
    public final int m421b(AbstractC0333g gVar) {
        Objects.requireNonNull(gVar, "pp");
        C0341o oVar = this.f154a;
        oVar.getClass();
        ((ArrayList) oVar.f156c).add(gVar);
        C0341o oVar2 = this.f154a;
        oVar2.f158e = -1;
        return ((ArrayList) oVar2.f156c).size() - 1;
    }

    /* renamed from: k */
    public final C0327a m412k(EnumC0347u uVar, AbstractC0310m mVar) {
        return m411l(Locale.getDefault(), uVar, mVar);
    }

    /* renamed from: l */
    public final C0327a m411l(Locale locale, EnumC0347u uVar, AbstractC0310m mVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f154a.f155b != null) {
            m414i();
        }
        C0332f fVar = new C0332f(this.f156c, false);
        C0346t tVar = C0346t.f167a;
        return new C0327a(fVar, locale, uVar, mVar);
    }
}
