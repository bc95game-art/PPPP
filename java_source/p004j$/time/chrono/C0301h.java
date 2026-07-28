package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import p004j$.time.temporal.EnumC0365b;
import p004j$.util.Objects;
/* renamed from: j$.time.chrono.h */
/* loaded from: classes2.dex */
public final class C0301h implements Serializable {

    /* renamed from: e */
    public static final /* synthetic */ int f67e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a */
    public final AbstractC0310m f68a;

    /* renamed from: b */
    public final int f69b;

    /* renamed from: c */
    public final int f70c;

    /* renamed from: d */
    public final int f71d;

    static {
        Object[] objArr = {EnumC0365b.YEARS, EnumC0365b.MONTHS, EnumC0365b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            arrayList.add(Objects.requireNonNull(objArr[i]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public C0301h(AbstractC0310m mVar, int i, int i2, int i3) {
        Objects.requireNonNull(mVar, "chrono");
        this.f68a = mVar;
        this.f69b = i;
        this.f70c = i2;
        this.f71d = i3;
    }

    public final String toString() {
        if (this.f69b == 0 && this.f70c == 0 && this.f71d == 0) {
            String mVar = this.f68a.toString();
            return mVar + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f68a.toString());
        sb.append(" P");
        int i = this.f69b;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.f70c;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.f71d;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0301h) {
            C0301h hVar = (C0301h) obj;
            if (this.f69b == hVar.f69b && this.f70c == hVar.f70c && this.f71d == hVar.f71d && this.f68a.equals(hVar.f68a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.f71d, 16) + (Integer.rotateLeft(this.f70c, 8) + this.f69b)) ^ this.f68a.hashCode();
    }

    public Object writeReplace() {
        return new C0298f0((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
