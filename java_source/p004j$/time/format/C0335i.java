package p004j$.time.format;

import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.AbstractC0389y;
import p004j$.time.C0352i;
import p004j$.time.C0390z;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.format.i */
/* loaded from: classes2.dex */
public final class C0335i implements AbstractC0333g {

    /* renamed from: a */
    public final /* synthetic */ int f135a;

    public /* synthetic */ C0335i(int i) {
        this.f135a = i;
    }

    @Override // p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    public final boolean mo423i(C0343q qVar, StringBuilder sb) {
        switch (this.f135a) {
            case 0:
                Long a = qVar.m410a(EnumC0364a.INSTANT_SECONDS);
                AbstractC0377n nVar = qVar.f163a;
                EnumC0364a aVar = EnumC0364a.NANO_OF_SECOND;
                Long valueOf = nVar.mo299e(aVar) ? Long.valueOf(nVar.mo293w(aVar)) : null;
                int i = 0;
                if (a == null) {
                    return false;
                }
                long longValue = a.longValue();
                int a2 = aVar.f213b.m329a(valueOf != null ? valueOf.longValue() : 0L, aVar);
                if (longValue >= -62167219200L) {
                    long j = longValue - 253402300800L;
                    long V = AbstractC0279a.m543V(j, 315569520000L) + 1;
                    C0352i G = C0352i.m380G(AbstractC0279a.m544U(j, 315569520000L) - 62167219200L, 0, C0390z.f253e);
                    if (V > 0) {
                        sb.append('+');
                        sb.append(V);
                    }
                    sb.append(G);
                    if (G.f180b.f189c == 0) {
                        sb.append(":00");
                    }
                } else {
                    long j2 = longValue + 62167219200L;
                    long j3 = j2 / 315569520000L;
                    long j4 = j2 % 315569520000L;
                    C0352i G2 = C0352i.m380G(j4 - 62167219200L, 0, C0390z.f253e);
                    int length = sb.length();
                    sb.append(G2);
                    if (G2.f180b.f189c == 0) {
                        sb.append(":00");
                    }
                    if (j3 < 0) {
                        if (G2.f179a.f173a == -10000) {
                            sb.replace(length, length + 2, Long.toString(j3 - 1));
                        } else if (j4 == 0) {
                            sb.insert(length, j3);
                        } else {
                            sb.insert(length + 1, Math.abs(j3));
                        }
                    }
                }
                if (a2 > 0) {
                    sb.append('.');
                    int i2 = 100000000;
                    while (true) {
                        if (a2 > 0 || i % 3 != 0 || i < -2) {
                            int i3 = a2 / i2;
                            sb.append((char) (i3 + 48));
                            a2 -= i3 * i2;
                            i2 /= 10;
                            i++;
                        }
                    }
                }
                sb.append('Z');
                return true;
            default:
                C0328b bVar = C0341o.f153f;
                AbstractC0377n nVar2 = qVar.f163a;
                Object l = nVar2.mo295l(bVar);
                if (l == null && qVar.f165c == 0) {
                    throw new RuntimeException("Unable to extract " + bVar + " from temporal " + nVar2);
                }
                AbstractC0389y yVar = (AbstractC0389y) l;
                if (yVar == null) {
                    return false;
                }
                sb.append(yVar.mo298h());
                return true;
        }
    }

    public final String toString() {
        switch (this.f135a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
