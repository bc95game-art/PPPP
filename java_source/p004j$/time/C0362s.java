package p004j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import p004j$.time.temporal.EnumC0365b;
import p004j$.util.Objects;
/* renamed from: j$.time.s */
/* loaded from: classes2.dex */
public final class C0362s implements Serializable {

    /* renamed from: d */
    public static final C0362s f205d = new C0362s(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a */
    public final int f206a;

    /* renamed from: b */
    public final int f207b;

    /* renamed from: c */
    public final int f208c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Object[] objArr = {EnumC0365b.YEARS, EnumC0365b.MONTHS, EnumC0365b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            arrayList.add(Objects.requireNonNull(objArr[i]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public C0362s(int i, int i2, int i3) {
        this.f206a = i;
        this.f207b = i2;
        this.f208c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0362s) {
            C0362s sVar = (C0362s) obj;
            if (this.f206a == sVar.f206a && this.f207b == sVar.f207b && this.f208c == sVar.f208c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f208c, 16) + Integer.rotateLeft(this.f207b, 8) + this.f206a;
    }

    public final String toString() {
        if (this == f205d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i = this.f206a;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.f207b;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.f208c;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new C0363t((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
