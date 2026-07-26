package p004j$.time;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.temporal.EnumC0364a;
import p004j$.util.Objects;
/* renamed from: j$.time.t */
/* loaded from: classes2.dex */
public final class C0363t implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a */
    public byte f209a;

    /* renamed from: b */
    public Object f210b;

    public C0363t() {
    }

    public C0363t(byte b, Object obj) {
        this.f209a = b;
        this.f210b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b = this.f209a;
        Object obj = this.f210b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.f42a);
                objectOutput.writeInt(duration.f43b);
                return;
            case 2:
                C0325e eVar = (C0325e) obj;
                objectOutput.writeLong(eVar.f118a);
                objectOutput.writeInt(eVar.f119b);
                return;
            case 3:
                C0350g gVar = (C0350g) obj;
                objectOutput.writeInt(gVar.f173a);
                objectOutput.writeByte(gVar.f174b);
                objectOutput.writeByte(gVar.f175c);
                return;
            case 4:
                ((C0354k) obj).m354R(objectOutput);
                return;
            case 5:
                C0352i iVar = (C0352i) obj;
                C0350g gVar2 = iVar.f179a;
                objectOutput.writeInt(gVar2.f173a);
                objectOutput.writeByte(gVar2.f174b);
                objectOutput.writeByte(gVar2.f175c);
                iVar.f180b.m354R(objectOutput);
                return;
            case 6:
                C0286c0 c0Var = (C0286c0) obj;
                C0352i iVar2 = c0Var.f50a;
                C0350g gVar3 = iVar2.f179a;
                objectOutput.writeInt(gVar3.f173a);
                objectOutput.writeByte(gVar3.f174b);
                objectOutput.writeByte(gVar3.f175c);
                iVar2.f180b.m354R(objectOutput);
                c0Var.f51b.m300L(objectOutput);
                c0Var.f52c.mo306F(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((C0282a0) obj).f45a);
                return;
            case 8:
                ((C0390z) obj).m300L(objectOutput);
                return;
            case 9:
                C0361r rVar = (C0361r) obj;
                rVar.f203a.m354R(objectOutput);
                rVar.f204b.m300L(objectOutput);
                return;
            case 10:
                C0360q qVar = (C0360q) obj;
                C0352i iVar3 = qVar.f200a;
                C0350g gVar4 = iVar3.f179a;
                objectOutput.writeInt(gVar4.f173a);
                objectOutput.writeByte(gVar4.f174b);
                objectOutput.writeByte(gVar4.f175c);
                iVar3.f180b.m354R(objectOutput);
                qVar.f201b.m300L(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((C0386v) obj).f245a);
                return;
            case 12:
                C0388x xVar = (C0388x) obj;
                objectOutput.writeInt(xVar.f249a);
                objectOutput.writeByte(xVar.f250b);
                return;
            case 13:
                C0358o oVar = (C0358o) obj;
                objectOutput.writeByte(oVar.f196a);
                objectOutput.writeByte(oVar.f197b);
                return;
            case 14:
                C0362s sVar = (C0362s) obj;
                objectOutput.writeInt(sVar.f206a);
                objectOutput.writeInt(sVar.f207b);
                objectOutput.writeInt(sVar.f208c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f209a = readByte;
        this.f210b = m345a(readByte, objectInput);
    }

    /* renamed from: a */
    public static Object m345a(byte b, ObjectInput objectInput) {
        switch (b) {
            case 1:
                Duration duration = Duration.f41c;
                long readLong = objectInput.readLong();
                long readInt = objectInput.readInt();
                return Duration.m498i(AbstractC0279a.m547R(readLong, AbstractC0279a.m543V(readInt, 1000000000L)), (int) AbstractC0279a.m544U(readInt, 1000000000L));
            case 2:
                C0325e eVar = C0325e.f117c;
                return C0325e.m431D(objectInput.readLong(), objectInput.readInt());
            case 3:
                C0350g gVar = C0350g.f171d;
                return C0350g.m398K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return C0354k.m359M(objectInput);
            case 5:
                C0352i iVar = C0352i.f177c;
                C0350g gVar2 = C0350g.f171d;
                return C0352i.m381F(C0350g.m398K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), C0354k.m359M(objectInput));
            case 6:
                C0352i iVar2 = C0352i.f177c;
                C0350g gVar3 = C0350g.f171d;
                C0352i F = C0352i.m381F(C0350g.m398K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), C0354k.m359M(objectInput));
                C0390z K = C0390z.m301K(objectInput);
                AbstractC0389y yVar = (AbstractC0389y) m345a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(F, "localDateTime");
                Objects.requireNonNull(K, "offset");
                Objects.requireNonNull(yVar, "zone");
                if (!(yVar instanceof C0390z) || K.equals(yVar)) {
                    return new C0286c0(F, yVar, K);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                int i = C0282a0.f44c;
                String readUTF = objectInput.readUTF();
                Objects.requireNonNull(readUTF, "zoneId");
                if (readUTF.length() <= 1 || readUTF.startsWith("+") || readUTF.startsWith("-")) {
                    return C0390z.m305G(readUTF);
                }
                if (readUTF.startsWith("UTC") || readUTF.startsWith("GMT")) {
                    return AbstractC0389y.m308E(readUTF, 3);
                }
                if (readUTF.startsWith("UT")) {
                    return AbstractC0389y.m308E(readUTF, 2);
                }
                return C0282a0.m496G(readUTF);
            case 8:
                return C0390z.m301K(objectInput);
            case 9:
                int i2 = C0361r.f202c;
                return new C0361r(C0354k.m359M(objectInput), C0390z.m301K(objectInput));
            case 10:
                int i3 = C0360q.f199c;
                C0350g gVar4 = C0350g.f171d;
                return new C0360q(C0352i.m381F(C0350g.m398K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), C0354k.m359M(objectInput)), C0390z.m301K(objectInput));
            case 11:
                int i4 = C0386v.f244b;
                return C0386v.m323C(objectInput.readInt());
            case 12:
                int i5 = C0388x.f248c;
                int readInt2 = objectInput.readInt();
                byte readByte = objectInput.readByte();
                EnumC0364a.YEAR.m344s(readInt2);
                EnumC0364a.MONTH_OF_YEAR.m344s(readByte);
                return new C0388x(readInt2, readByte);
            case 13:
                int i6 = C0358o.f195c;
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                EnumC0356m F2 = EnumC0356m.m350F(readByte2);
                Objects.requireNonNull(F2, "month");
                EnumC0364a.DAY_OF_MONTH.m344s(readByte3);
                if (readByte3 <= F2.m351E()) {
                    return new C0358o(F2.getValue(), readByte3);
                }
                throw new RuntimeException("Illegal value for DayOfMonth field, value " + ((int) readByte3) + " is not valid for month " + F2.name());
            case 14:
                C0362s sVar = C0362s.f205d;
                int readInt3 = objectInput.readInt();
                int readInt4 = objectInput.readInt();
                int readInt5 = objectInput.readInt();
                if ((readInt3 | readInt4 | readInt5) == 0) {
                    return C0362s.f205d;
                }
                return new C0362s(readInt3, readInt4, readInt5);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f210b;
    }
}
