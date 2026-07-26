package p004j$.time;

import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import p004j$.time.zone.C0396f;
import p004j$.time.zone.C0397g;
import p004j$.time.zone.C0399i;
import p004j$.util.Objects;
/* renamed from: j$.time.a0 */
/* loaded from: classes2.dex */
public final class C0282a0 extends AbstractC0389y {

    /* renamed from: c */
    public static final /* synthetic */ int f44c = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: a */
    public final String f45a;

    /* renamed from: b */
    public final transient C0396f f46b;

    /* renamed from: G */
    public static C0282a0 m496G(String str) {
        C0396f fVar;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i == 0) && ((charAt < '0' || charAt > '9' || i == 0) && ((charAt != '~' || i == 0) && ((charAt != '.' || i == 0) && ((charAt != '_' || i == 0) && ((charAt != '+' || i == 0) && (charAt != '-' || i == 0))))))))) {
                    throw new RuntimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVar = C0399i.m278a(str);
            } catch (C0397g unused) {
                fVar = null;
            }
            return new C0282a0(str, fVar);
        }
        throw new RuntimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    public C0282a0(String str, C0396f fVar) {
        this.f45a = str;
        this.f46b = fVar;
    }

    @Override // p004j$.time.AbstractC0389y
    /* renamed from: h */
    public final String mo298h() {
        return this.f45a;
    }

    @Override // p004j$.time.AbstractC0389y
    /* renamed from: C */
    public final C0396f mo307C() {
        C0396f fVar = this.f46b;
        return fVar != null ? fVar : C0399i.m278a(this.f45a);
    }

    private Object writeReplace() {
        return new C0363t((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // p004j$.time.AbstractC0389y
    /* renamed from: F */
    public final void mo306F(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f45a);
    }
}
