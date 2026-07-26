package p004j$.time.chrono;

import java.util.Locale;
import p004j$.time.C0281a;
import p004j$.time.C0352i;
import p004j$.time.C0354k;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: j$.time.chrono.a */
/* loaded from: classes2.dex */
public abstract class AbstractC0287a implements AbstractC0310m {

    /* renamed from: a */
    public static final ConcurrentHashMap f53a = new ConcurrentHashMap();

    /* renamed from: b */
    public static final ConcurrentHashMap f54b = new ConcurrentHashMap();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return mo449h().compareTo(((AbstractC0310m) obj).mo449h());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    /* renamed from: i */
    public static AbstractC0310m m489i(AbstractC0310m mVar, String str) {
        String n;
        AbstractC0310m mVar2 = (AbstractC0310m) f53a.putIfAbsent(str, mVar);
        if (mVar2 == null && (n = mVar.mo447n()) != null) {
            f54b.putIfAbsent(n, mVar);
        }
        return mVar2;
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    /* renamed from: u */
    public AbstractC0295e mo450u(C0352i iVar) {
        try {
            return mo445t(iVar).mo385y(C0354k.m367E(iVar));
        } catch (C0281a e) {
            throw new RuntimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + C0352i.class, e);
        }
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC0287a) && mo449h().compareTo(((AbstractC0287a) obj).mo449h()) == 0;
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    public final int hashCode() {
        return getClass().hashCode() ^ mo449h().hashCode();
    }

    @Override // p004j$.time.chrono.AbstractC0310m
    public final String toString() {
        return mo449h();
    }
}
