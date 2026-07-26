package p004j$.time.zone;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.C0352i;
import p004j$.time.C0390z;
/* renamed from: j$.time.zone.b */
/* loaded from: classes2.dex */
public final class C0392b implements Comparable, Serializable {

    /* renamed from: e */
    public static final /* synthetic */ int f260e = 0;
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a */
    public final long f261a;

    /* renamed from: b */
    public final C0352i f262b;

    /* renamed from: c */
    public final C0390z f263c;

    /* renamed from: d */
    public final C0390z f264d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f261a, ((C0392b) obj).f261a);
    }

    public C0392b(C0352i iVar, C0390z zVar, C0390z zVar2) {
        iVar.getClass();
        this.f261a = AbstractC0279a.m510y(iVar, zVar);
        this.f262b = iVar;
        this.f263c = zVar;
        this.f264d = zVar2;
    }

    public C0392b(long j, C0390z zVar, C0390z zVar2) {
        this.f261a = j;
        this.f262b = C0352i.m380G(j, 0, zVar);
        this.f263c = zVar;
        this.f264d = zVar2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new C0391a((byte) 2, this);
    }

    /* renamed from: i */
    public final boolean m288i() {
        return this.f264d.f256a > this.f263c.f256a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0392b) {
            C0392b bVar = (C0392b) obj;
            if (this.f261a == bVar.f261a && this.f263c.equals(bVar.f263c) && this.f264d.equals(bVar.f264d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f262b.hashCode() ^ this.f263c.f256a) ^ Integer.rotateLeft(this.f264d.f256a, 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(m288i() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f262b);
        sb.append(this.f263c);
        sb.append(" to ");
        sb.append(this.f264d);
        sb.append(']');
        return sb.toString();
    }
}
