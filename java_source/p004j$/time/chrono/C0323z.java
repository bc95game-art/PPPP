package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.AbstractC0283b;
import p004j$.time.C0350g;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.z */
/* loaded from: classes2.dex */
public final class C0323z implements AbstractC0311n, Serializable {

    /* renamed from: d */
    public static final C0323z f110d;

    /* renamed from: e */
    public static final C0323z[] f111e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* renamed from: a */
    public final transient int f112a;

    /* renamed from: b */
    public final transient C0350g f113b;

    /* renamed from: c */
    public final transient String f114c;

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    public final /* synthetic */ boolean mo299e(AbstractC0380q qVar) {
        return AbstractC0279a.m515t(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: i */
    public final /* synthetic */ int mo297i(AbstractC0380q qVar) {
        return AbstractC0279a.m520o(this, qVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: l */
    public final /* synthetic */ Object mo295l(C0328b bVar) {
        return AbstractC0279a.m511x(this, bVar);
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final /* synthetic */ long mo293w(AbstractC0380q qVar) {
        return AbstractC0279a.m518q(this, qVar);
    }

    static {
        C0323z zVar = new C0323z(-1, C0350g.m398K(1868, 1, 1), "Meiji");
        f110d = zVar;
        C0323z zVar2 = new C0323z(0, C0350g.m398K(1912, 7, 30), "Taisho");
        C0323z zVar3 = new C0323z(1, C0350g.m398K(1926, 12, 25), "Showa");
        C0323z zVar4 = new C0323z(2, C0350g.m398K(1989, 1, 8), "Heisei");
        C0323z zVar5 = new C0323z(3, C0350g.m398K(2019, 5, 1), "Reiwa");
        f111e = r7;
        C0323z[] zVarArr = {zVar, zVar2, zVar3, zVar4, zVar5};
    }

    /* renamed from: n */
    public final C0323z m434n() {
        C0323z[] zVarArr = f111e;
        if (this == zVarArr[zVarArr.length - 1]) {
            return null;
        }
        return m433q(this.f112a + 1);
    }

    public C0323z(int i, C0350g gVar, String str) {
        this.f112a = i;
        this.f113b = gVar;
        this.f114c = str;
    }

    /* renamed from: q */
    public static C0323z m433q(int i) {
        int i2 = i + 1;
        if (i2 >= 0) {
            C0323z[] zVarArr = f111e;
            if (i2 < zVarArr.length) {
                return zVarArr[i2];
            }
        }
        throw new RuntimeException("Invalid era: " + i);
    }

    @Override // p004j$.time.temporal.AbstractC0378o
    /* renamed from: o */
    public final AbstractC0376m mo294o(AbstractC0376m mVar) {
        return mVar.mo313c(getValue(), EnumC0364a.ERA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r6.m406C(r0) < 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r6.mo386x() < r0.mo386x()) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        r0 = false;
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0323z m435h(C0350g gVar) {
        boolean z;
        C0350g gVar2 = C0322y.f106d;
        if (AbstractC0283b.m494b(gVar2)) {
            gVar.getClass();
        }
        if (!z) {
            for (int length = f111e.length - 1; length >= 0; length--) {
                C0323z zVar = f111e[length];
                if (gVar.compareTo(zVar.f113b) >= 0) {
                    return zVar;
                }
            }
            return null;
        }
        throw new RuntimeException("JapaneseDate before Meiji 6 are not supported");
    }

    @Override // p004j$.time.chrono.AbstractC0311n
    public final int getValue() {
        return this.f112a;
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        EnumC0364a aVar = EnumC0364a.ERA;
        if (qVar == aVar) {
            return C0320w.f104c.m448j(aVar);
        }
        return AbstractC0381r.m331d(this, qVar);
    }

    public final String toString() {
        return this.f114c;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new C0298f0((byte) 5, this);
    }
}
