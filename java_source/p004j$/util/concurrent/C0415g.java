package p004j$.util.concurrent;
/* renamed from: j$.util.concurrent.g */
/* loaded from: classes2.dex */
public final class C0415g extends C0420l {

    /* renamed from: e */
    public final C0420l[] f339e;

    public C0415g(C0420l[] lVarArr) {
        super(-1, null, null);
        this.f339e = lVarArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
        if ((r0 instanceof p004j$.util.concurrent.C0415g) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
        return r0.mo240a(r4, r5);
     */
    @Override // p004j$.util.concurrent.C0420l
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0420l mo240a(int i, Object obj) {
        C0420l k;
        Object obj2;
        C0420l[] lVarArr = this.f339e;
        loop0: while (true) {
            int length = lVarArr.length;
            if (length == 0 || (k = ConcurrentHashMap.m262k(lVarArr, (length - 1) & i)) == null) {
                return null;
            }
            while (true) {
                int i2 = k.f346a;
                if (i2 != i || ((obj2 = k.f347b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                    if (i2 < 0) {
                        break;
                    }
                    k = k.f349d;
                    if (k == null) {
                        return null;
                    }
                }
            }
            lVarArr = ((C0415g) k).f339e;
        }
        return k;
    }
}
