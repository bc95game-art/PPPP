package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.AbstractC0283b;
import p004j$.time.C0350g;
import p004j$.time.C0354k;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0382s;
import p004j$.time.temporal.C0384u;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.chrono.r */
/* loaded from: classes2.dex */
public final class C0315r extends AbstractC0293d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a */
    public final transient C0313p f94a;

    /* renamed from: b */
    public final transient int f95b;

    /* renamed from: c */
    public final transient int f96c;

    /* renamed from: d */
    public final transient int f97d;

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    /* renamed from: y */
    public final AbstractC0295e mo385y(C0354k kVar) {
        return new C0299g(this, kVar);
    }

    public C0315r(C0313p pVar, int i, int i2, int i3) {
        pVar.m460l(i, i2, i3);
        this.f94a = pVar;
        this.f95b = i;
        this.f96c = i2;
        this.f97d = i3;
    }

    public C0315r(C0313p pVar, long j) {
        int i = (int) j;
        pVar.m462j();
        if (i < pVar.f86e || i >= pVar.f87f) {
            throw new RuntimeException("Hijrah date out of range");
        }
        int binarySearch = Arrays.binarySearch(pVar.f85d, i);
        binarySearch = binarySearch < 0 ? (-binarySearch) - 2 : binarySearch;
        int i2 = pVar.f88g;
        int[] iArr = {(binarySearch + i2) / 12, ((i2 + binarySearch) % 12) + 1, (i - pVar.f85d[binarySearch]) + 1};
        this.f94a = pVar;
        this.f95b = iArr[0];
        this.f96c = iArr[1];
        this.f97d = iArr[2];
    }

    @Override // p004j$.time.chrono.AbstractC0289b
    /* renamed from: a */
    public final AbstractC0310m mo387a() {
        return this.f94a;
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: D */
    public final AbstractC0311n mo444D() {
        return EnumC0316s.f98AH;
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0377n
    /* renamed from: k */
    public final C0384u mo296k(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo338j(this);
        }
        if (AbstractC0279a.m516s(this, qVar)) {
            EnumC0364a aVar = (EnumC0364a) qVar;
            int i = AbstractC0314q.f93a[aVar.ordinal()];
            if (i == 1) {
                return C0384u.m325e(1L, this.f94a.m459o(this.f95b, this.f96c));
            }
            if (i == 2) {
                return C0384u.m325e(1L, this.f94a.m463C(this.f95b, 12));
            }
            if (i != 3) {
                return this.f94a.m457w(aVar);
            }
            return C0384u.m325e(1L, 5L);
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: w */
    public final long mo293w(AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(this);
        }
        int i = 1;
        switch (AbstractC0314q.f93a[((EnumC0364a) qVar).ordinal()]) {
            case 1:
                return this.f97d;
            case 2:
                return m456J();
            case 3:
                return ((this.f97d - 1) / 7) + 1;
            case 4:
                return ((int) AbstractC0279a.m544U(mo386x() + 3, 7)) + 1;
            case 5:
                return ((this.f97d - 1) % 7) + 1;
            case 6:
                return ((m456J() - 1) % 7) + 1;
            case 7:
                return mo386x();
            case 8:
                return ((m456J() - 1) / 7) + 1;
            case 9:
                return this.f96c;
            case 10:
                return ((this.f95b * 12) + this.f96c) - 1;
            case 11:
                return this.f95b;
            case 12:
                return this.f95b;
            case 13:
                if (this.f95b <= 1) {
                    i = 0;
                }
                return i;
            default:
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: N */
    public final C0315r mo313c(long j, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return (C0315r) super.mo313c(j, qVar);
        }
        EnumC0364a aVar = (EnumC0364a) qVar;
        this.f94a.m457w(aVar).m328b(j, aVar);
        int i = (int) j;
        switch (AbstractC0314q.f93a[aVar.ordinal()]) {
            case 1:
                return m453M(this.f95b, this.f96c, i);
            case 2:
                return mo442F(Math.min(i, this.f94a.m463C(this.f95b, 12)) - m456J());
            case 3:
                return mo442F((j - mo293w(EnumC0364a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return mo442F(j - (((int) AbstractC0279a.m544U(mo386x() + 3, 7)) + 1));
            case 5:
                return mo442F(j - mo293w(EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return mo442F(j - mo293w(EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new C0315r(this.f94a, j);
            case 8:
                return mo442F((j - mo293w(EnumC0364a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return m453M(this.f95b, i, this.f97d);
            case 10:
                return mo441G(j - (((this.f95b * 12) + this.f96c) - 1));
            case 11:
                if (this.f95b < 1) {
                    i = 1 - i;
                }
                return m453M(i, this.f96c, this.f97d);
            case 12:
                return m453M(i, this.f96c, this.f97d);
            case 13:
                return m453M(1 - this.f95b, this.f96c, this.f97d);
            default:
                throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
        }
    }

    /* renamed from: M */
    public final C0315r m453M(int i, int i2, int i3) {
        int o = this.f94a.m459o(i, i2);
        if (i3 > o) {
            i3 = o;
        }
        return new C0315r(this.f94a, i, i2, i3);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: I */
    public final AbstractC0289b mo439I(AbstractC0378o oVar) {
        return (C0315r) super.mo311j(oVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0376m
    /* renamed from: j */
    public final AbstractC0376m mo311j(C0350g gVar) {
        return (C0315r) super.mo311j(gVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    /* renamed from: x */
    public final long mo386x() {
        return this.f94a.m460l(this.f95b, this.f96c, this.f97d);
    }

    /* renamed from: J */
    public final int m456J() {
        return this.f94a.m463C(this.f95b, this.f96c - 1) + this.f97d;
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: H */
    public final AbstractC0289b mo440H(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = this.f95b + ((int) j);
        int i = (int) j2;
        if (j2 == i) {
            return m453M(i, this.f96c, this.f97d);
        }
        throw new ArithmeticException();
    }

    /* renamed from: L */
    public final C0315r mo441G(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.f95b * 12) + (this.f96c - 1) + j;
        C0313p pVar = this.f94a;
        long V = AbstractC0279a.m543V(j2, 12L);
        int i = pVar.f88g;
        if (V >= i / 12 && V <= (((pVar.f85d.length - 1) + i) / 12) - 1) {
            return m453M((int) V, ((int) AbstractC0279a.m544U(j2, 12L)) + 1, this.f97d);
        }
        throw new RuntimeException("Invalid Hijrah year: " + V);
    }

    /* renamed from: K */
    public final C0315r mo442F(long j) {
        return new C0315r(this.f94a, mo386x() + j);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d */
    public final AbstractC0289b mo886d(long j, AbstractC0382s sVar) {
        return (C0315r) super.mo886d(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b, p004j$.time.temporal.AbstractC0376m
    /* renamed from: d  reason: collision with other method in class */
    public final AbstractC0376m mo886d(long j, AbstractC0382s sVar) {
        return (C0315r) super.mo886d(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    /* renamed from: E */
    public final AbstractC0289b mo443E(long j, AbstractC0382s sVar) {
        return (C0315r) super.mo310s(j, sVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.temporal.AbstractC0376m
    /* renamed from: s */
    public final AbstractC0376m mo310s(long j, EnumC0365b bVar) {
        return (C0315r) super.mo310s(j, bVar);
    }

    @Override // p004j$.time.chrono.AbstractC0293d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0315r) {
            C0315r rVar = (C0315r) obj;
            if (this.f95b == rVar.f95b && this.f96c == rVar.f96c && this.f97d == rVar.f97d && this.f94a.equals(rVar.f94a)) {
                return true;
            }
        }
        return false;
    }

    @Override // p004j$.time.chrono.AbstractC0293d, p004j$.time.chrono.AbstractC0289b
    public final int hashCode() {
        int i = this.f95b;
        int i2 = this.f96c;
        int i3 = this.f97d;
        this.f94a.getClass();
        return (((i << 11) + (i2 << 6)) + i3) ^ ((i & (-2048)) ^ 2100100019);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new C0298f0((byte) 6, this);
    }
}
