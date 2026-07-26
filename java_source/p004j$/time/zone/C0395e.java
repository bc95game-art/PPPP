package p004j$.time.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.time.C0354k;
import p004j$.time.C0390z;
import p004j$.time.EnumC0285c;
import p004j$.time.EnumC0356m;
import p004j$.time.temporal.EnumC0364a;
import p004j$.util.Objects;
/* renamed from: j$.time.zone.e */
/* loaded from: classes2.dex */
public final class C0395e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* renamed from: a */
    public final EnumC0356m f267a;

    /* renamed from: b */
    public final byte f268b;

    /* renamed from: c */
    public final EnumC0285c f269c;

    /* renamed from: d */
    public final C0354k f270d;

    /* renamed from: e */
    public final boolean f271e;

    /* renamed from: f */
    public final EnumC0394d f272f;

    /* renamed from: g */
    public final C0390z f273g;

    /* renamed from: h */
    public final C0390z f274h;

    /* renamed from: i */
    public final C0390z f275i;

    public C0395e(EnumC0356m mVar, int i, EnumC0285c cVar, C0354k kVar, boolean z, EnumC0394d dVar, C0390z zVar, C0390z zVar2, C0390z zVar3) {
        this.f267a = mVar;
        this.f268b = (byte) i;
        this.f269c = cVar;
        this.f270d = kVar;
        this.f271e = z;
        this.f272f = dVar;
        this.f273g = zVar;
        this.f274h = zVar2;
        this.f275i = zVar3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new C0391a((byte) 3, this);
    }

    /* renamed from: b */
    public final void m286b(DataOutput dataOutput) {
        byte b;
        int O = this.f271e ? 86400 : this.f270d.m357O();
        int i = this.f273g.f256a;
        int i2 = this.f274h.f256a - i;
        int i3 = this.f275i.f256a - i;
        if (O % 3600 == 0) {
            b = this.f271e ? (byte) 24 : this.f270d.f187a;
        } else {
            b = 31;
        }
        int i4 = i % 900 == 0 ? (i / 900) + 128 : 255;
        int i5 = (i2 == 0 || i2 == 1800 || i2 == 3600) ? i2 / 1800 : 3;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        EnumC0285c cVar = this.f269c;
        dataOutput.writeInt((this.f267a.getValue() << 28) + ((this.f268b + 32) << 22) + ((cVar == null ? 0 : cVar.getValue()) << 19) + (b << 14) + (this.f272f.ordinal() << 12) + (i4 << 4) + (i5 << 2) + i6);
        if (b == 31) {
            dataOutput.writeInt(O);
        }
        if (i4 == 255) {
            dataOutput.writeInt(i);
        }
        if (i5 == 3) {
            dataOutput.writeInt(this.f274h.f256a);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.f275i.f256a);
        }
    }

    /* renamed from: a */
    public static C0395e m287a(DataInput dataInput) {
        EnumC0394d dVar;
        C0354k kVar;
        int i;
        int i2;
        int i3;
        int readInt = dataInput.readInt();
        EnumC0356m F = EnumC0356m.m350F(readInt >>> 28);
        int i4 = ((264241152 & readInt) >>> 22) - 32;
        int i5 = (3670016 & readInt) >>> 19;
        EnumC0285c C = i5 == 0 ? null : EnumC0285c.m493C(i5);
        int i6 = (507904 & readInt) >>> 14;
        EnumC0394d dVar2 = EnumC0394d.values()[(readInt & 12288) >>> 12];
        int i7 = (readInt & 4080) >>> 4;
        int i8 = (readInt & 12) >>> 2;
        int i9 = readInt & 3;
        if (i6 == 31) {
            long readInt2 = dataInput.readInt();
            C0354k kVar2 = C0354k.f183e;
            EnumC0364a.SECOND_OF_DAY.m344s(readInt2);
            int i10 = (int) (readInt2 / 3600);
            dVar = dVar2;
            long j = readInt2 - (i10 * 3600);
            kVar = C0354k.m368D(i10, (int) (j / 60), (int) (j - (i3 * 60)), 0);
        } else {
            dVar = dVar2;
            int i11 = i6 % 24;
            C0354k kVar3 = C0354k.f183e;
            EnumC0364a.HOUR_OF_DAY.m344s(i11);
            kVar = C0354k.f186h[i11];
        }
        C0390z I = C0390z.m303I(i7 == 255 ? dataInput.readInt() : (i7 - 128) * 900);
        if (i8 == 3) {
            i = dataInput.readInt();
        } else {
            i = (i8 * 1800) + I.f256a;
        }
        C0390z I2 = C0390z.m303I(i);
        if (i9 == 3) {
            i2 = dataInput.readInt();
        } else {
            i2 = (i9 * 1800) + I.f256a;
        }
        C0390z I3 = C0390z.m303I(i2);
        boolean z = i6 == 24;
        Objects.requireNonNull(F, "month");
        Objects.requireNonNull(kVar, "time");
        Objects.requireNonNull(dVar, "timeDefnition");
        Objects.requireNonNull(I, "standardOffset");
        Objects.requireNonNull(I2, "offsetBefore");
        Objects.requireNonNull(I3, "offsetAfter");
        if (i4 < -28 || i4 > 31 || i4 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (z && !kVar.equals(C0354k.f185g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        } else if (kVar.f190d == 0) {
            return new C0395e(F, i4, C, kVar, z, dVar, I, I2, I3);
        } else {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0395e) {
            C0395e eVar = (C0395e) obj;
            if (this.f267a == eVar.f267a && this.f268b == eVar.f268b && this.f269c == eVar.f269c && this.f272f == eVar.f272f && this.f270d.equals(eVar.f270d) && this.f271e == eVar.f271e && this.f273g.equals(eVar.f273g) && this.f274h.equals(eVar.f274h) && this.f275i.equals(eVar.f275i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int O = ((this.f270d.m357O() + (this.f271e ? 1 : 0)) << 15) + (this.f267a.ordinal() << 11) + ((this.f268b + 32) << 5);
        EnumC0285c cVar = this.f269c;
        return ((this.f273g.f256a ^ (this.f272f.ordinal() + (O + ((cVar == null ? 7 : cVar.ordinal()) << 2)))) ^ this.f274h.f256a) ^ this.f275i.f256a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.f275i.f256a - this.f274h.f256a > 0 ? "Gap " : "Overlap ");
        sb.append(this.f274h);
        sb.append(" to ");
        sb.append(this.f275i);
        sb.append(", ");
        EnumC0285c cVar = this.f269c;
        if (cVar != null) {
            byte b = this.f268b;
            if (b == -1) {
                sb.append(cVar.name());
                sb.append(" on or before last day of ");
                sb.append(this.f267a.name());
            } else if (b < 0) {
                sb.append(cVar.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.f268b) - 1);
                sb.append(" of ");
                sb.append(this.f267a.name());
            } else {
                sb.append(cVar.name());
                sb.append(" on or after ");
                sb.append(this.f267a.name());
                sb.append(' ');
                sb.append((int) this.f268b);
            }
        } else {
            sb.append(this.f267a.name());
            sb.append(' ');
            sb.append((int) this.f268b);
        }
        sb.append(" at ");
        sb.append(this.f271e ? "24:00" : this.f270d.toString());
        sb.append(" ");
        sb.append(this.f272f);
        sb.append(", standard offset ");
        sb.append(this.f273g);
        sb.append(']');
        return sb.toString();
    }
}
