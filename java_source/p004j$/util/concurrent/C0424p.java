package p004j$.util.concurrent;
/* renamed from: j$.util.concurrent.p */
/* loaded from: classes2.dex */
public class C0424p {

    /* renamed from: a */
    public C0420l[] f354a;

    /* renamed from: b */
    public C0420l f355b = null;

    /* renamed from: c */
    public C0423o f356c;

    /* renamed from: d */
    public C0423o f357d;

    /* renamed from: e */
    public int f358e;

    /* renamed from: f */
    public int f359f;

    /* renamed from: g */
    public int f360g;

    /* renamed from: h */
    public final int f361h;

    public C0424p(C0420l[] lVarArr, int i, int i2, int i3) {
        this.f354a = lVarArr;
        this.f361h = i;
        this.f358e = i2;
        this.f359f = i2;
        this.f360g = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final C0420l m249a() {
        C0420l[] lVarArr;
        int length;
        int i;
        C0423o oVar;
        C0423o oVar2;
        C0420l lVar = this.f355b;
        if (lVar != null) {
            lVar = lVar.f349d;
        }
        while (lVar == null) {
            if (this.f359f >= this.f360g || (lVarArr = this.f354a) == null || (length = lVarArr.length) <= (i = this.f358e) || i < 0) {
                this.f355b = null;
                return null;
            }
            C0420l k = ConcurrentHashMap.m262k(lVarArr, i);
            if (k == null || k.f346a >= 0) {
                lVar = k;
            } else if (k instanceof C0415g) {
                this.f354a = ((C0415g) k).f339e;
                C0423o oVar3 = this.f357d;
                if (oVar3 != null) {
                    this.f357d = oVar3.f353d;
                    oVar2 = oVar3;
                } else {
                    oVar2 = new Object();
                }
                oVar2.f352c = lVarArr;
                oVar2.f350a = length;
                oVar2.f351b = i;
                oVar2.f353d = this.f356c;
                this.f356c = oVar2;
                lVar = null;
            } else {
                lVar = k instanceof C0425q ? ((C0425q) k).f365f : null;
            }
            if (this.f356c != null) {
                while (true) {
                    oVar = this.f356c;
                    if (oVar == null) {
                        break;
                    }
                    int i2 = this.f358e;
                    int i3 = oVar.f350a;
                    int i4 = i2 + i3;
                    this.f358e = i4;
                    if (i4 < length) {
                        break;
                    }
                    this.f358e = oVar.f351b;
                    this.f354a = oVar.f352c;
                    oVar.f352c = null;
                    C0423o oVar4 = oVar.f353d;
                    oVar.f353d = this.f357d;
                    this.f356c = oVar4;
                    this.f357d = oVar;
                    length = i3;
                }
                if (oVar == null) {
                    int i5 = this.f358e + this.f361h;
                    this.f358e = i5;
                    if (i5 >= length) {
                        int i6 = this.f359f + 1;
                        this.f359f = i6;
                        this.f358e = i6;
                    }
                }
            } else {
                int i7 = i + this.f361h;
                this.f358e = i7;
                if (i7 >= length) {
                    int i8 = this.f359f + 1;
                    this.f359f = i8;
                    this.f358e = i8;
                }
            }
        }
        this.f355b = lVar;
        return lVar;
    }
}
