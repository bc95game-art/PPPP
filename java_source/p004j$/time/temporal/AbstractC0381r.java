package p004j$.time.temporal;

import p004j$.time.AbstractC0283b;
import p004j$.time.format.C0328b;
import p004j$.util.Objects;
/* renamed from: j$.time.temporal.r */
/* loaded from: classes2.dex */
public abstract class AbstractC0381r {

    /* renamed from: a */
    public static final C0328b f231a = new C0328b(1);

    /* renamed from: b */
    public static final C0328b f232b = new C0328b(2);

    /* renamed from: c */
    public static final C0328b f233c = new C0328b(3);

    /* renamed from: d */
    public static final C0328b f234d = new C0328b(4);

    /* renamed from: e */
    public static final C0328b f235e = new C0328b(5);

    /* renamed from: f */
    public static final C0328b f236f = new C0328b(6);

    /* renamed from: g */
    public static final C0328b f237g = new C0328b(7);

    /* renamed from: d */
    public static C0384u m331d(AbstractC0377n nVar, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            Objects.requireNonNull(qVar, "field");
            return qVar.mo338j(nVar);
        } else if (nVar.mo299e(qVar)) {
            return ((EnumC0364a) qVar).f213b;
        } else {
            throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: a */
    public static int m334a(AbstractC0377n nVar, AbstractC0380q qVar) {
        C0384u k = nVar.mo296k(qVar);
        if (k.f238a < -2147483648L || k.f241d > 2147483647L) {
            throw new RuntimeException("Invalid field " + qVar + " for get() method, use getLong() instead");
        }
        long w = nVar.mo293w(qVar);
        if (k.m326d(w)) {
            return (int) w;
        }
        throw new RuntimeException("Invalid value for " + qVar + " (valid values " + k + "): " + w);
    }

    /* renamed from: c */
    public static Object m332c(AbstractC0377n nVar, C0328b bVar) {
        if (bVar == f231a || bVar == f232b || bVar == f233c) {
            return null;
        }
        return bVar.m428a(nVar);
    }

    /* renamed from: b */
    public static AbstractC0376m m333b(AbstractC0376m mVar, long j, AbstractC0382s sVar) {
        long j2;
        if (j == Long.MIN_VALUE) {
            mVar = mVar.mo886d(Long.MAX_VALUE, sVar);
            j2 = 1;
        } else {
            j2 = -j;
        }
        return mVar.mo886d(j2, sVar);
    }
}
