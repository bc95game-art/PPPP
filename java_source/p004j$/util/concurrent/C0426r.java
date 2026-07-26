package p004j$.util.concurrent;
/* renamed from: j$.util.concurrent.r */
/* loaded from: classes2.dex */
public final class C0426r extends C0420l {

    /* renamed from: e */
    public C0426r f367e;

    /* renamed from: f */
    public C0426r f368f;

    /* renamed from: g */
    public C0426r f369g;

    /* renamed from: h */
    public C0426r f370h;

    /* renamed from: i */
    public boolean f371i;

    public C0426r(int i, Object obj, Object obj2, C0420l lVar, C0426r rVar) {
        super(i, obj, obj2, lVar);
        this.f367e = rVar;
    }

    @Override // p004j$.util.concurrent.C0420l
    /* renamed from: a */
    public final C0420l mo240a(int i, Object obj) {
        return m239b(i, obj, null);
    }

    /* renamed from: b */
    public final C0426r m239b(int i, Object obj, Class cls) {
        if (obj == null) {
            return null;
        }
        C0426r rVar = this;
        do {
            C0426r rVar2 = rVar.f368f;
            C0426r rVar3 = rVar.f369g;
            int i2 = rVar.f346a;
            if (i2 <= i) {
                if (i2 >= i) {
                    Object obj2 = rVar.f347b;
                    if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                        return rVar;
                    }
                    if (rVar2 != null) {
                        if (rVar3 != null) {
                            if (!(cls == null && (cls = ConcurrentHashMap.m270c(obj)) == null)) {
                                int i3 = ConcurrentHashMap.f312g;
                                int compareTo = (obj2 == null || obj2.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj2);
                                if (compareTo != 0) {
                                    if (compareTo >= 0) {
                                        rVar2 = rVar3;
                                    }
                                }
                            }
                            C0426r b = rVar3.m239b(i, obj, cls);
                            if (b != null) {
                                return b;
                            }
                        }
                    }
                }
                rVar = rVar3;
                continue;
            }
            rVar = rVar2;
            continue;
        } while (rVar != null);
        return null;
    }
}
