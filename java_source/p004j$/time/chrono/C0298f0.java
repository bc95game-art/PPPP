package p004j$.time.chrono;

import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.AbstractC0389y;
import p004j$.time.C0350g;
import p004j$.time.C0354k;
import p004j$.time.C0390z;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.EnumC0364a;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: j$.time.chrono.f0 */
/* loaded from: classes2.dex */
public final class C0298f0 implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* renamed from: a */
    public byte f62a;

    /* renamed from: b */
    public Object f63b;

    public C0298f0() {
    }

    public C0298f0(byte b, Object obj) {
        this.f62a = b;
        this.f63b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) {
        byte b = this.f62a;
        Object obj = this.f63b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                objectOutput.writeUTF(((AbstractC0287a) obj).mo449h());
                return;
            case 2:
                C0299g gVar = (C0299g) obj;
                objectOutput.writeObject(gVar.f64a);
                objectOutput.writeObject(gVar.f65b);
                return;
            case 3:
                C0309l lVar = (C0309l) obj;
                objectOutput.writeObject(lVar.f79a);
                objectOutput.writeObject(lVar.f80b);
                objectOutput.writeObject(lVar.f81c);
                return;
            case 4:
                C0322y yVar = (C0322y) obj;
                yVar.getClass();
                objectOutput.writeInt(AbstractC0381r.m334a(yVar, EnumC0364a.YEAR));
                objectOutput.writeByte(AbstractC0381r.m334a(yVar, EnumC0364a.MONTH_OF_YEAR));
                objectOutput.writeByte(AbstractC0381r.m334a(yVar, EnumC0364a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((C0323z) obj).f112a);
                return;
            case 6:
                C0315r rVar = (C0315r) obj;
                objectOutput.writeObject(rVar.f94a);
                objectOutput.writeInt(AbstractC0381r.m334a(rVar, EnumC0364a.YEAR));
                objectOutput.writeByte(AbstractC0381r.m334a(rVar, EnumC0364a.MONTH_OF_YEAR));
                objectOutput.writeByte(AbstractC0381r.m334a(rVar, EnumC0364a.DAY_OF_MONTH));
                return;
            case 7:
                C0294d0 d0Var = (C0294d0) obj;
                d0Var.getClass();
                objectOutput.writeInt(AbstractC0381r.m334a(d0Var, EnumC0364a.YEAR));
                objectOutput.writeByte(AbstractC0381r.m334a(d0Var, EnumC0364a.MONTH_OF_YEAR));
                objectOutput.writeByte(AbstractC0381r.m334a(d0Var, EnumC0364a.DAY_OF_MONTH));
                return;
            case 8:
                C0306j0 j0Var = (C0306j0) obj;
                j0Var.getClass();
                objectOutput.writeInt(AbstractC0381r.m334a(j0Var, EnumC0364a.YEAR));
                objectOutput.writeByte(AbstractC0381r.m334a(j0Var, EnumC0364a.MONTH_OF_YEAR));
                objectOutput.writeByte(AbstractC0381r.m334a(j0Var, EnumC0364a.DAY_OF_MONTH));
                return;
            case 9:
                C0301h hVar = (C0301h) obj;
                objectOutput.writeUTF(hVar.f68a.mo449h());
                objectOutput.writeInt(hVar.f69b);
                objectOutput.writeInt(hVar.f70c);
                objectOutput.writeInt(hVar.f71d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        Object obj;
        byte readByte = objectInput.readByte();
        this.f62a = readByte;
        switch (readByte) {
            case 1:
                ConcurrentHashMap concurrentHashMap = AbstractC0287a.f53a;
                obj = AbstractC0279a.m540Y(objectInput.readUTF());
                break;
            case 2:
                obj = ((AbstractC0289b) objectInput.readObject()).mo385y((C0354k) objectInput.readObject());
                break;
            case 3:
                obj = ((AbstractC0295e) objectInput.readObject()).mo371m((C0390z) objectInput.readObject()).mo465r((AbstractC0389y) objectInput.readObject());
                break;
            case 4:
                C0350g gVar = C0322y.f106d;
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                C0320w.f104c.getClass();
                obj = new C0322y(C0350g.m398K(readInt, readByte2, readByte3));
                break;
            case 5:
                C0323z zVar = C0323z.f110d;
                obj = C0323z.m433q(objectInput.readByte());
                break;
            case 6:
                C0313p pVar = (C0313p) objectInput.readObject();
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                pVar.getClass();
                obj = new C0315r(pVar, readInt2, readByte4, readByte5);
                break;
            case 7:
                int readInt3 = objectInput.readInt();
                byte readByte6 = objectInput.readByte();
                byte readByte7 = objectInput.readByte();
                C0290b0.f56c.getClass();
                obj = new C0294d0(C0350g.m398K(readInt3 + 1911, readByte6, readByte7));
                break;
            case 8:
                int readInt4 = objectInput.readInt();
                byte readByte8 = objectInput.readByte();
                byte readByte9 = objectInput.readByte();
                C0302h0.f72c.getClass();
                obj = new C0306j0(C0350g.m398K(readInt4 - 543, readByte8, readByte9));
                break;
            case 9:
                int i = C0301h.f67e;
                obj = new C0301h(AbstractC0279a.m540Y(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f63b = obj;
    }

    private Object readResolve() {
        return this.f63b;
    }
}
