package p004j$.time.zone;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.C0325e;
import p004j$.time.C0350g;
import p004j$.time.C0352i;
import p004j$.time.C0354k;
import p004j$.time.C0390z;
import p004j$.time.EnumC0285c;
import p004j$.time.EnumC0356m;
import p004j$.time.chrono.C0317t;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.EnumC0364a;
import p004j$.util.Objects;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: j$.time.zone.f */
/* loaded from: classes2.dex */
public final class C0396f implements Serializable {

    /* renamed from: i */
    public static final long[] f276i = new long[0];

    /* renamed from: j */
    public static final C0395e[] f277j = new C0395e[0];

    /* renamed from: k */
    public static final C0352i[] f278k = new C0352i[0];

    /* renamed from: l */
    public static final C0392b[] f279l = new C0392b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a */
    public final long[] f280a;

    /* renamed from: b */
    public final C0390z[] f281b;

    /* renamed from: c */
    public final long[] f282c;

    /* renamed from: d */
    public final C0352i[] f283d;

    /* renamed from: e */
    public final C0390z[] f284e;

    /* renamed from: f */
    public final C0395e[] f285f;

    /* renamed from: g */
    public final TimeZone f286g;

    /* renamed from: h */
    public final transient ConcurrentHashMap f287h;

    /* renamed from: a */
    public static Object m285a(C0352i iVar, C0392b bVar) {
        C0352i iVar2 = bVar.f262b;
        if (bVar.m288i()) {
            if (iVar.m382E(iVar2)) {
                return bVar.f263c;
            }
            if (!iVar.m382E(bVar.f262b.m378I(bVar.f264d.f256a - bVar.f263c.f256a))) {
                return bVar.f264d;
            }
        } else if (!iVar.m382E(iVar2)) {
            return bVar.f264d;
        } else {
            if (iVar.m382E(bVar.f262b.m378I(bVar.f264d.f256a - bVar.f263c.f256a))) {
                return bVar.f263c;
            }
        }
        return bVar;
    }

    public C0396f(long[] jArr, C0390z[] zVarArr, long[] jArr2, C0390z[] zVarArr2, C0395e[] eVarArr) {
        this.f287h = new ConcurrentHashMap();
        this.f280a = jArr;
        this.f281b = zVarArr;
        this.f282c = jArr2;
        this.f284e = zVarArr2;
        this.f285f = eVarArr;
        if (jArr2.length == 0) {
            this.f283d = f278k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < jArr2.length) {
                int i2 = i + 1;
                C0392b bVar = new C0392b(jArr2[i], zVarArr2[i], zVarArr2[i2]);
                if (bVar.m288i()) {
                    arrayList.add(bVar.f262b);
                    arrayList.add(bVar.f262b.m378I(bVar.f264d.f256a - bVar.f263c.f256a));
                } else {
                    arrayList.add(bVar.f262b.m378I(bVar.f264d.f256a - bVar.f263c.f256a));
                    arrayList.add(bVar.f262b);
                }
                i = i2;
            }
            this.f283d = (C0352i[]) arrayList.toArray(new C0352i[arrayList.size()]);
        }
        this.f286g = null;
    }

    public C0396f(C0390z zVar) {
        this.f287h = new ConcurrentHashMap();
        this.f281b = r0;
        C0390z[] zVarArr = {zVar};
        long[] jArr = f276i;
        this.f280a = jArr;
        this.f282c = jArr;
        this.f283d = f278k;
        this.f284e = zVarArr;
        this.f285f = f277j;
        this.f286g = null;
    }

    public C0396f(TimeZone timeZone) {
        this.f287h = new ConcurrentHashMap();
        this.f281b = r0;
        C0390z[] zVarArr = {m279g(timeZone.getRawOffset())};
        long[] jArr = f276i;
        this.f280a = jArr;
        this.f282c = jArr;
        this.f283d = f278k;
        this.f284e = zVarArr;
        this.f285f = f277j;
        this.f286g = timeZone;
    }

    /* renamed from: g */
    public static C0390z m279g(int i) {
        return C0390z.m303I(i / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new C0391a(this.f286g != null ? (byte) 100 : (byte) 1, this);
    }

    /* renamed from: c */
    public static int m283c(long j, C0390z zVar) {
        return C0350g.m397L(AbstractC0279a.m543V(j + zVar.f256a, 86400)).f173a;
    }

    /* renamed from: d */
    public final C0390z m282d(C0325e eVar) {
        C0390z[] zVarArr;
        long j;
        TimeZone timeZone = this.f286g;
        if (timeZone != null) {
            long j2 = eVar.f118a;
            if (j2 >= 0 || eVar.f119b <= 0) {
                j = AbstractC0279a.m547R(AbstractC0279a.m548Q(j2, 1000), eVar.f119b / 1000000);
            } else {
                j = AbstractC0279a.m547R(AbstractC0279a.m548Q(j2 + 1, 1000), (eVar.f119b / 1000000) - 1000);
            }
            return m279g(timeZone.getOffset(j));
        }
        long[] jArr = this.f282c;
        if (jArr.length == 0) {
            return this.f281b[0];
        }
        long j3 = eVar.f118a;
        if (this.f285f.length <= 0 || j3 <= jArr[jArr.length - 1]) {
            int binarySearch = Arrays.binarySearch(jArr, j3);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            return this.f284e[binarySearch + 1];
        }
        C0392b[] b = m284b(m283c(j3, this.f284e[zVarArr.length - 1]));
        C0392b bVar = null;
        for (int i = 0; i < b.length; i++) {
            bVar = b[i];
            if (j3 < bVar.f261a) {
                return bVar.f263c;
            }
        }
        return bVar.f264d;
    }

    /* renamed from: f */
    public final List m280f(C0352i iVar) {
        Object e = m281e(iVar);
        if (!(e instanceof C0392b)) {
            return Collections.singletonList((C0390z) e);
        }
        C0392b bVar = (C0392b) e;
        if (bVar.m288i()) {
            return Collections.EMPTY_LIST;
        }
        Object[] objArr = {bVar.f263c, bVar.f264d};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            arrayList.add(Objects.requireNonNull(objArr[i]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r9.m384C(r0) > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0086, code lost:
        if (r9.f180b.m358N() <= r0.f180b.m358N()) goto L41;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m281e(C0352i iVar) {
        C0352i[] iVarArr;
        Object obj = null;
        int i = 0;
        if (this.f286g != null) {
            C0392b[] b = m284b(iVar.f179a.f173a);
            if (b.length == 0) {
                return m279g(this.f286g.getOffset(AbstractC0279a.m510y(iVar, this.f281b[0]) * 1000));
            }
            int length = b.length;
            while (i < length) {
                C0392b bVar = b[i];
                Object a = m285a(iVar, bVar);
                if ((a instanceof C0392b) || a.equals(bVar.f263c)) {
                    return a;
                }
                i++;
                obj = a;
            }
            return obj;
        } else if (this.f282c.length == 0) {
            return this.f281b[0];
        } else {
            if (this.f285f.length > 0) {
                C0352i iVar2 = this.f283d[iVarArr.length - 1];
                if (iVar2 != null) {
                    iVar.getClass();
                } else {
                    int i2 = (iVar.f179a.mo386x() > iVar2.f179a.mo386x() ? 1 : (iVar.f179a.mo386x() == iVar2.f179a.mo386x() ? 0 : -1));
                    if (i2 <= 0) {
                        if (i2 == 0) {
                        }
                    }
                    C0392b[] b2 = m284b(iVar.f179a.f173a);
                    int length2 = b2.length;
                    while (i < length2) {
                        C0392b bVar2 = b2[i];
                        Object a2 = m285a(iVar, bVar2);
                        if ((a2 instanceof C0392b) || a2.equals(bVar2.f263c)) {
                            return a2;
                        }
                        i++;
                        obj = a2;
                    }
                    return obj;
                }
            }
            int binarySearch = Arrays.binarySearch(this.f283d, iVar);
            if (binarySearch == -1) {
                return this.f284e[0];
            }
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            } else {
                C0352i[] iVarArr2 = this.f283d;
                if (binarySearch < iVarArr2.length - 1) {
                    int i3 = binarySearch + 1;
                    if (iVarArr2[binarySearch].equals(iVarArr2[i3])) {
                        binarySearch = i3;
                    }
                }
            }
            if ((binarySearch & 1) != 0) {
                return this.f284e[(binarySearch / 2) + 1];
            }
            C0352i[] iVarArr3 = this.f283d;
            C0352i iVar3 = iVarArr3[binarySearch];
            C0352i iVar4 = iVarArr3[binarySearch + 1];
            C0390z[] zVarArr = this.f284e;
            int i4 = binarySearch / 2;
            C0390z zVar = zVarArr[i4];
            C0390z zVar2 = zVarArr[i4 + 1];
            if (zVar2.f256a > zVar.f256a) {
                return new C0392b(iVar3, zVar, zVar2);
            }
            return new C0392b(iVar4, zVar, zVar2);
        }
    }

    /* renamed from: b */
    public final C0392b[] m284b(int i) {
        C0350g gVar;
        C0392b[] bVarArr = f279l;
        Integer valueOf = Integer.valueOf(i);
        C0392b[] bVarArr2 = (C0392b[]) this.f287h.get(valueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j = 1;
        final int i2 = 0;
        if (this.f286g == null) {
            C0395e[] eVarArr = this.f285f;
            C0392b[] bVarArr3 = new C0392b[eVarArr.length];
            int i3 = 0;
            while (i3 < eVarArr.length) {
                C0395e eVar = eVarArr[i3];
                byte b = eVar.f268b;
                if (b < 0) {
                    EnumC0356m mVar = eVar.f267a;
                    long j2 = i;
                    C0317t.f100c.getClass();
                    int D = mVar.m352D(C0317t.m451j(j2)) + 1 + eVar.f268b;
                    C0350g gVar2 = C0350g.f171d;
                    EnumC0364a.YEAR.m344s(j2);
                    Objects.requireNonNull(mVar, "month");
                    EnumC0364a.DAY_OF_MONTH.m344s(D);
                    gVar = C0350g.m405D(i, mVar.getValue(), D);
                    EnumC0285c cVar = eVar.f269c;
                    if (cVar != null) {
                        final int value = cVar.getValue();
                        gVar = gVar.mo311j(new AbstractC0378o() { // from class: j$.time.temporal.p
                            @Override // p004j$.time.temporal.AbstractC0378o
                            /* renamed from: o */
                            public final AbstractC0376m mo294o(AbstractC0376m mVar2) {
                                switch (r2) {
                                    case 0:
                                        int i4 = mVar2.mo297i(EnumC0364a.DAY_OF_WEEK);
                                        int i5 = value;
                                        if (i4 == i5) {
                                            return mVar2;
                                        }
                                        int i6 = i4 - i5;
                                        return mVar2.mo886d(i6 >= 0 ? 7 - i6 : -i6, EnumC0365b.DAYS);
                                    default:
                                        int i7 = mVar2.mo297i(EnumC0364a.DAY_OF_WEEK);
                                        int i8 = value;
                                        if (i7 == i8) {
                                            return mVar2;
                                        }
                                        int i9 = i8 - i7;
                                        return mVar2.mo310s(i9 >= 0 ? 7 - i9 : -i9, EnumC0365b.DAYS);
                                }
                            }
                        });
                    }
                } else {
                    EnumC0356m mVar2 = eVar.f267a;
                    C0350g gVar3 = C0350g.f171d;
                    EnumC0364a.YEAR.m344s(i);
                    Objects.requireNonNull(mVar2, "month");
                    EnumC0364a.DAY_OF_MONTH.m344s(b);
                    gVar = C0350g.m405D(i, mVar2.getValue(), b);
                    EnumC0285c cVar2 = eVar.f269c;
                    if (cVar2 != null) {
                        final int value2 = cVar2.getValue();
                        gVar = gVar.mo311j(new AbstractC0378o() { // from class: j$.time.temporal.p
                            @Override // p004j$.time.temporal.AbstractC0378o
                            /* renamed from: o */
                            public final AbstractC0376m mo294o(AbstractC0376m mVar22) {
                                switch (i2) {
                                    case 0:
                                        int i4 = mVar22.mo297i(EnumC0364a.DAY_OF_WEEK);
                                        int i5 = value2;
                                        if (i4 == i5) {
                                            return mVar22;
                                        }
                                        int i6 = i4 - i5;
                                        return mVar22.mo886d(i6 >= 0 ? 7 - i6 : -i6, EnumC0365b.DAYS);
                                    default:
                                        int i7 = mVar22.mo297i(EnumC0364a.DAY_OF_WEEK);
                                        int i8 = value2;
                                        if (i7 == i8) {
                                            return mVar22;
                                        }
                                        int i9 = i8 - i7;
                                        return mVar22.mo310s(i9 >= 0 ? 7 - i9 : -i9, EnumC0365b.DAYS);
                                }
                            }
                        });
                    }
                }
                if (eVar.f271e) {
                    gVar = gVar.m395N(1L);
                }
                C0352i F = C0352i.m381F(gVar, eVar.f270d);
                EnumC0394d dVar = eVar.f272f;
                C0390z zVar = eVar.f273g;
                C0390z zVar2 = eVar.f274h;
                dVar.getClass();
                int i4 = AbstractC0393c.f265a[dVar.ordinal()];
                if (i4 == 1) {
                    F = F.m378I(zVar2.f256a - C0390z.f253e.f256a);
                } else if (i4 == 2) {
                    F = F.m378I(zVar2.f256a - zVar.f256a);
                }
                bVarArr3[i3] = new C0392b(F, eVar.f274h, eVar.f275i);
                i3++;
                i2 = 0;
            }
            if (i < 2100) {
                this.f287h.putIfAbsent(valueOf, bVarArr3);
            }
            return bVarArr3;
        } else if (i < 1800) {
            return bVarArr;
        } else {
            C0352i iVar = C0352i.f177c;
            C0350g K = C0350g.m398K(i - 1, 12, 31);
            EnumC0364a.HOUR_OF_DAY.m344s(0);
            long y = AbstractC0279a.m510y(new C0352i(K, C0354k.f186h[0]), this.f281b[0]);
            long j3 = 1000;
            int offset = this.f286g.getOffset(y * 1000);
            long j4 = 31968000 + y;
            while (y < j4) {
                long j5 = y + 7776000;
                long j6 = j3;
                if (offset != this.f286g.getOffset(j5 * j6)) {
                    while (j5 - y > j) {
                        long V = AbstractC0279a.m543V(j5 + y, 2L);
                        if (this.f286g.getOffset(V * j6) == offset) {
                            y = V;
                        } else {
                            j5 = V;
                        }
                        j = 1;
                    }
                    if (this.f286g.getOffset(y * j6) == offset) {
                        y = j5;
                    }
                    C0390z g = m279g(offset);
                    int offset2 = this.f286g.getOffset(y * j6);
                    C0390z g2 = m279g(offset2);
                    if (m283c(y, g2) == i) {
                        bVarArr = (C0392b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new C0392b(y, g, g2);
                    }
                    offset = offset2;
                } else {
                    y = j5;
                }
                j3 = j6;
                j = 1;
            }
            if (1916 <= i && i < 2100) {
                this.f287h.putIfAbsent(valueOf, bVarArr);
            }
            return bVarArr;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0396f) {
            C0396f fVar = (C0396f) obj;
            if (Objects.equals(this.f286g, fVar.f286g) && Arrays.equals(this.f280a, fVar.f280a) && Arrays.equals(this.f281b, fVar.f281b) && Arrays.equals(this.f282c, fVar.f282c) && Arrays.equals(this.f284e, fVar.f284e) && Arrays.equals(this.f285f, fVar.f285f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        TimeZone timeZone = this.f286g;
        return (((((timeZone != null ? timeZone.hashCode() : 0) ^ Arrays.hashCode(this.f280a)) ^ Arrays.hashCode(this.f281b)) ^ Arrays.hashCode(this.f282c)) ^ Arrays.hashCode(this.f284e)) ^ Arrays.hashCode(this.f285f);
    }

    public final String toString() {
        TimeZone timeZone = this.f286g;
        if (timeZone != null) {
            String id = timeZone.getID();
            return "ZoneRules[timeZone=" + id + "]";
        }
        C0390z[] zVarArr = this.f281b;
        C0390z zVar = zVarArr[zVarArr.length - 1];
        return "ZoneRules[currentStandardOffset=" + zVar + "]";
    }
}
