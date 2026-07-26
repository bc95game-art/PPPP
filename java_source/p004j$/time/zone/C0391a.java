package p004j$.time.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.TimeZone;
import p004j$.time.C0390z;
/* renamed from: j$.time.zone.a */
/* loaded from: classes2.dex */
public final class C0391a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* renamed from: a */
    public byte f258a;

    /* renamed from: b */
    public Object f259b;

    public C0391a() {
    }

    public C0391a(byte b, Object obj) {
        this.f258a = b;
        this.f259b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b = this.f258a;
        Object obj = this.f259b;
        objectOutput.writeByte(b);
        if (b == 1) {
            C0396f fVar = (C0396f) obj;
            objectOutput.writeInt(fVar.f280a.length);
            for (long j : fVar.f280a) {
                m290c(j, objectOutput);
            }
            for (C0390z zVar : fVar.f281b) {
                m289d(zVar, objectOutput);
            }
            objectOutput.writeInt(fVar.f282c.length);
            for (long j2 : fVar.f282c) {
                m290c(j2, objectOutput);
            }
            for (C0390z zVar2 : fVar.f284e) {
                m289d(zVar2, objectOutput);
            }
            objectOutput.writeByte(fVar.f285f.length);
            for (C0395e eVar : fVar.f285f) {
                eVar.m286b(objectOutput);
            }
        } else if (b == 2) {
            C0392b bVar = (C0392b) obj;
            m290c(bVar.f261a, objectOutput);
            m289d(bVar.f263c, objectOutput);
            m289d(bVar.f264d, objectOutput);
        } else if (b == 3) {
            ((C0395e) obj).m286b(objectOutput);
        } else if (b == 100) {
            objectOutput.writeUTF(((C0396f) obj).f286g.getID());
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object obj;
        byte readByte = objectInput.readByte();
        this.f258a = readByte;
        if (readByte == 1) {
            long[] jArr = C0396f.f276i;
            int readInt = objectInput.readInt();
            long[] jArr2 = readInt == 0 ? jArr : new long[readInt];
            for (int i = 0; i < readInt; i++) {
                jArr2[i] = m292a(objectInput);
            }
            int i2 = readInt + 1;
            C0390z[] zVarArr = new C0390z[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                zVarArr[i3] = m291b(objectInput);
            }
            int readInt2 = objectInput.readInt();
            if (readInt2 != 0) {
                jArr = new long[readInt2];
            }
            long[] jArr3 = jArr;
            for (int i4 = 0; i4 < readInt2; i4++) {
                jArr3[i4] = m292a(objectInput);
            }
            int i5 = readInt2 + 1;
            C0390z[] zVarArr2 = new C0390z[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                zVarArr2[i6] = m291b(objectInput);
            }
            int readByte2 = objectInput.readByte();
            C0395e[] eVarArr = readByte2 == 0 ? C0396f.f277j : new C0395e[readByte2];
            for (int i7 = 0; i7 < readByte2; i7++) {
                eVarArr[i7] = C0395e.m287a(objectInput);
            }
            obj = new C0396f(jArr2, zVarArr, jArr3, zVarArr2, eVarArr);
        } else if (readByte == 2) {
            int i8 = C0392b.f260e;
            long a = m292a(objectInput);
            C0390z b = m291b(objectInput);
            C0390z b2 = m291b(objectInput);
            if (!b.equals(b2)) {
                obj = new C0392b(a, b, b2);
            } else {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
        } else if (readByte == 3) {
            obj = C0395e.m287a(objectInput);
        } else if (readByte == 100) {
            obj = new C0396f(TimeZone.getTimeZone(objectInput.readUTF()));
        } else {
            throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f259b = obj;
    }

    private Object readResolve() {
        return this.f259b;
    }

    /* renamed from: b */
    public static C0390z m291b(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? C0390z.m303I(dataInput.readInt()) : C0390z.m303I(readByte * 900);
    }

    /* renamed from: c */
    public static void m290c(long j, DataOutput dataOutput) {
        if (j < -4575744000L || j >= 10413792000L || j % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j);
            return;
        }
        int i = (int) ((j + 4575744000L) / 900);
        dataOutput.writeByte((i >>> 16) & 255);
        dataOutput.writeByte((i >>> 8) & 255);
        dataOutput.writeByte(i & 255);
    }

    /* renamed from: a */
    public static long m292a(DataInput dataInput) {
        int readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return ((((readByte << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255)) * 900) - 4575744000L;
    }

    /* renamed from: d */
    public static void m289d(C0390z zVar, DataOutput dataOutput) {
        int i = zVar.f256a;
        int i2 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(i);
        }
    }
}
