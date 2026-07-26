package p004j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p004j$.time.C0350g;
import p004j$.time.C0352i;
import p004j$.time.temporal.AbstractC0377n;
/* renamed from: j$.time.chrono.t */
/* loaded from: classes2.dex */
public final class C0317t extends AbstractC0287a implements Serializable {

    /* renamed from: c */
    public static final C0317t f100c = new C0317t();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: q */
    public final AbstractC0311n mo446q(int i) {
        if (i == 0) {
            return EnumC0318u.BCE;
        }
        if (i == 1) {
            return EnumC0318u.f101CE;
        }
        throw new RuntimeException("Invalid era: " + i);
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: h */
    public final String mo449h() {
        return "ISO";
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: n */
    public final String mo447n() {
        return "iso8601";
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: t */
    public final AbstractC0289b mo445t(AbstractC0377n nVar) {
        return C0350g.m404E(nVar);
    }

    private C0317t() {
    }

    @Override // p004j$.time.chrono.AbstractC0287a, p004j$.time.chrono.AbstractC0310m
    /* renamed from: u */
    public final AbstractC0295e mo450u(C0352i iVar) {
        return C0352i.m383D(iVar);
    }

    /* renamed from: j */
    public static boolean m451j(long j) {
        if ((3 & j) == 0) {
            return j % 100 != 0 || j % 400 == 0;
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new C0298f0((byte) 1, this);
    }
}
