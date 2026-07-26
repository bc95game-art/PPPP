package p004j$.time.format;

import java.util.HashMap;
import java.util.Locale;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.chrono.C0317t;
import p004j$.time.temporal.AbstractC0373j;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.util.Objects;
/* renamed from: j$.time.format.a */
/* loaded from: classes2.dex */
public final class C0327a {

    /* renamed from: e */
    public static final C0327a f122e;

    /* renamed from: a */
    public final C0332f f123a;

    /* renamed from: b */
    public final Locale f124b;

    /* renamed from: c */
    public final C0346t f125c;

    /* renamed from: d */
    public final AbstractC0310m f126d;

    static {
        C0341o oVar = new C0341o();
        EnumC0364a aVar = EnumC0364a.YEAR;
        EnumC0348v vVar = EnumC0348v.EXCEEDS_PAD;
        oVar.m415h(aVar, 4, 10, vVar);
        oVar.m420c('-');
        EnumC0364a aVar2 = EnumC0364a.MONTH_OF_YEAR;
        oVar.m416g(aVar2, 2);
        oVar.m420c('-');
        EnumC0364a aVar3 = EnumC0364a.DAY_OF_MONTH;
        oVar.m416g(aVar3, 2);
        EnumC0347u uVar = EnumC0347u.STRICT;
        C0317t tVar = C0317t.f100c;
        C0327a k = oVar.m412k(uVar, tVar);
        C0341o oVar2 = new C0341o();
        EnumC0338l lVar = EnumC0338l.INSENSITIVE;
        oVar2.m421b(lVar);
        oVar2.m422a(k);
        C0337k kVar = C0337k.f143e;
        oVar2.m421b(kVar);
        oVar2.m412k(uVar, tVar);
        C0341o oVar3 = new C0341o();
        oVar3.m421b(lVar);
        oVar3.m422a(k);
        oVar3.m413j();
        oVar3.m421b(kVar);
        oVar3.m412k(uVar, tVar);
        C0341o oVar4 = new C0341o();
        EnumC0364a aVar4 = EnumC0364a.HOUR_OF_DAY;
        oVar4.m416g(aVar4, 2);
        oVar4.m420c(':');
        EnumC0364a aVar5 = EnumC0364a.MINUTE_OF_HOUR;
        oVar4.m416g(aVar5, 2);
        oVar4.m413j();
        oVar4.m420c(':');
        EnumC0364a aVar6 = EnumC0364a.SECOND_OF_MINUTE;
        oVar4.m416g(aVar6, 2);
        oVar4.m413j();
        EnumC0364a aVar7 = EnumC0364a.NANO_OF_SECOND;
        C0334h hVar = new C0334h(aVar7, 0, 9, true, 0);
        Objects.requireNonNull(aVar7, "field");
        C0384u uVar2 = aVar7.f213b;
        if (uVar2.f238a == uVar2.f239b && uVar2.f240c == uVar2.f241d) {
            oVar4.m421b(hVar);
            C0327a k2 = oVar4.m412k(uVar, null);
            C0341o oVar5 = new C0341o();
            oVar5.m421b(lVar);
            oVar5.m422a(k2);
            oVar5.m421b(kVar);
            oVar5.m412k(uVar, null);
            C0341o oVar6 = new C0341o();
            oVar6.m421b(lVar);
            oVar6.m422a(k2);
            oVar6.m413j();
            oVar6.m421b(kVar);
            oVar6.m412k(uVar, null);
            C0341o oVar7 = new C0341o();
            oVar7.m421b(lVar);
            oVar7.m422a(k);
            oVar7.m420c('T');
            oVar7.m422a(k2);
            C0327a k3 = oVar7.m412k(uVar, tVar);
            C0341o oVar8 = new C0341o();
            oVar8.m421b(lVar);
            oVar8.m422a(k3);
            EnumC0338l lVar2 = EnumC0338l.LENIENT;
            oVar8.m421b(lVar2);
            oVar8.m421b(kVar);
            EnumC0338l lVar3 = EnumC0338l.STRICT;
            oVar8.m421b(lVar3);
            C0327a k4 = oVar8.m412k(uVar, tVar);
            C0341o oVar9 = new C0341o();
            oVar9.m422a(k4);
            oVar9.m413j();
            oVar9.m420c('[');
            EnumC0338l lVar4 = EnumC0338l.SENSITIVE;
            oVar9.m421b(lVar4);
            oVar9.m421b(new C0335i(1));
            oVar9.m420c(']');
            oVar9.m412k(uVar, tVar);
            C0341o oVar10 = new C0341o();
            oVar10.m422a(k3);
            oVar10.m413j();
            oVar10.m421b(kVar);
            oVar10.m413j();
            oVar10.m420c('[');
            oVar10.m421b(lVar4);
            oVar10.m421b(new C0335i(1));
            oVar10.m420c(']');
            oVar10.m412k(uVar, tVar);
            C0341o oVar11 = new C0341o();
            oVar11.m421b(lVar);
            oVar11.m415h(aVar, 4, 10, vVar);
            oVar11.m420c('-');
            oVar11.m416g(EnumC0364a.DAY_OF_YEAR, 3);
            oVar11.m413j();
            oVar11.m421b(kVar);
            oVar11.m412k(uVar, tVar);
            C0341o oVar12 = new C0341o();
            oVar12.m421b(lVar);
            oVar12.m415h(AbstractC0373j.f223c, 4, 10, vVar);
            oVar12.m419d("-W");
            oVar12.m416g(AbstractC0373j.f222b, 2);
            oVar12.m420c('-');
            EnumC0364a aVar8 = EnumC0364a.DAY_OF_WEEK;
            oVar12.m416g(aVar8, 1);
            oVar12.m413j();
            oVar12.m421b(kVar);
            oVar12.m412k(uVar, tVar);
            C0341o oVar13 = new C0341o();
            oVar13.m421b(lVar);
            oVar13.m421b(new C0335i(0));
            f122e = oVar13.m412k(uVar, null);
            C0341o oVar14 = new C0341o();
            oVar14.m421b(lVar);
            oVar14.m416g(aVar, 4);
            oVar14.m416g(aVar2, 2);
            oVar14.m416g(aVar3, 2);
            oVar14.m413j();
            oVar14.m421b(lVar2);
            oVar14.m421b(new C0337k("+HHMMss", "Z"));
            oVar14.m421b(lVar3);
            oVar14.m412k(uVar, tVar);
            HashMap hashMap = new HashMap();
            hashMap.put(1L, "Mon");
            hashMap.put(2L, "Tue");
            hashMap.put(3L, "Wed");
            hashMap.put(4L, "Thu");
            hashMap.put(5L, "Fri");
            hashMap.put(6L, "Sat");
            hashMap.put(7L, "Sun");
            HashMap hashMap2 = new HashMap();
            hashMap2.put(1L, "Jan");
            hashMap2.put(2L, "Feb");
            hashMap2.put(3L, "Mar");
            hashMap2.put(4L, "Apr");
            hashMap2.put(5L, "May");
            hashMap2.put(6L, "Jun");
            hashMap2.put(7L, "Jul");
            hashMap2.put(8L, "Aug");
            hashMap2.put(9L, "Sep");
            hashMap2.put(10L, "Oct");
            hashMap2.put(11L, "Nov");
            hashMap2.put(12L, "Dec");
            C0341o oVar15 = new C0341o();
            oVar15.m421b(lVar);
            oVar15.m421b(lVar2);
            oVar15.m413j();
            oVar15.m418e(aVar8, hashMap);
            oVar15.m419d(", ");
            oVar15.m414i();
            oVar15.m415h(aVar3, 1, 2, EnumC0348v.NOT_NEGATIVE);
            oVar15.m420c(' ');
            oVar15.m418e(aVar2, hashMap2);
            oVar15.m420c(' ');
            oVar15.m416g(aVar, 4);
            oVar15.m420c(' ');
            oVar15.m416g(aVar4, 2);
            oVar15.m420c(':');
            oVar15.m416g(aVar5, 2);
            oVar15.m413j();
            oVar15.m420c(':');
            oVar15.m416g(aVar6, 2);
            oVar15.m414i();
            oVar15.m420c(' ');
            oVar15.m421b(new C0337k("+HHMM", "GMT"));
            oVar15.m412k(EnumC0347u.SMART, tVar);
            return;
        }
        throw new IllegalArgumentException("Field must have a fixed set of values: " + aVar7);
    }

    public C0327a(C0332f fVar, Locale locale, EnumC0347u uVar, AbstractC0310m mVar) {
        C0346t tVar = C0346t.f167a;
        this.f123a = (C0332f) Objects.requireNonNull(fVar, "printerParser");
        this.f124b = (Locale) Objects.requireNonNull(locale, "locale");
        this.f125c = (C0346t) Objects.requireNonNull(tVar, "decimalStyle");
        EnumC0347u uVar2 = (EnumC0347u) Objects.requireNonNull(uVar, "resolverStyle");
        this.f126d = mVar;
    }

    public final String toString() {
        String fVar = this.f123a.toString();
        return fVar.startsWith("[") ? fVar : fVar.substring(1, fVar.length() - 1);
    }
}
