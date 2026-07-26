package p004j$.time.format;

import p004j$.time.temporal.EnumC0364a;
import p004j$.util.Objects;
/* renamed from: j$.time.format.k */
/* loaded from: classes2.dex */
public final class C0337k implements AbstractC0333g {

    /* renamed from: d */
    public static final String[] f142d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* renamed from: e */
    public static final C0337k f143e = new C0337k("+HH:MM:ss", "Z");

    /* renamed from: a */
    public final String f144a;

    /* renamed from: b */
    public final int f145b;

    /* renamed from: c */
    public final int f146c;

    static {
        new C0337k("+HH:MM:ss", "0");
    }

    public C0337k(String str, String str2) {
        Objects.requireNonNull(str, "pattern");
        Objects.requireNonNull(str2, "noOffsetText");
        for (int i = 0; i < 22; i++) {
            if (f142d[i].equals(str)) {
                this.f145b = i;
                this.f146c = i % 11;
                this.f144a = str2;
                return;
            }
        }
        throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
    }

    @Override // p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    public final boolean mo423i(C0343q qVar, StringBuilder sb) {
        Long a = qVar.m410a(EnumC0364a.OFFSET_SECONDS);
        boolean z = false;
        if (a == null) {
            return false;
        }
        long longValue = a.longValue();
        int i = (int) longValue;
        if (longValue == i) {
            String str = this.f144a;
            if (i == 0) {
                sb.append(str);
                return true;
            }
            int abs = Math.abs((i / 3600) % 100);
            int abs2 = Math.abs((i / 60) % 60);
            int abs3 = Math.abs(i % 60);
            int length = sb.length();
            sb.append(i < 0 ? "-" : "+");
            if (this.f145b >= 11 && abs < 10) {
                sb.append((char) (abs + 48));
            } else {
                m424a(false, abs, sb);
            }
            int i2 = this.f146c;
            if ((i2 >= 3 && i2 <= 8) || ((i2 >= 9 && abs3 > 0) || (i2 >= 1 && abs2 > 0))) {
                m424a(i2 > 0 && i2 % 2 == 0, abs2, sb);
                abs += abs2;
                if (i2 == 7 || i2 == 8 || (i2 >= 5 && abs3 > 0)) {
                    if (i2 > 0 && i2 % 2 == 0) {
                        z = true;
                    }
                    m424a(z, abs3, sb);
                    abs += abs3;
                }
            }
            if (abs == 0) {
                sb.setLength(length);
                sb.append(str);
            }
            return true;
        }
        throw new ArithmeticException();
    }

    /* renamed from: a */
    public static void m424a(boolean z, int i, StringBuilder sb) {
        sb.append(z ? ":" : "");
        sb.append((char) ((i / 10) + 48));
        sb.append((char) ((i % 10) + 48));
    }

    public final String toString() {
        String replace = this.f144a.replace("'", "''");
        String str = f142d[this.f145b];
        return "Offset(" + str + ",'" + replace + "')";
    }
}
