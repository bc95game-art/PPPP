package p004j$.time.zone;

import com.emanuelef.remote_capture.fragments.LogviewFragment;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import p004j$.util.Objects;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: j$.time.zone.i */
/* loaded from: classes2.dex */
public final class C0399i {

    /* renamed from: b */
    public static final CopyOnWriteArrayList f289b;

    /* renamed from: c */
    public static final ConcurrentHashMap f290c = new ConcurrentHashMap(LogviewFragment.MAX_LINES, 0.75f, 2);

    /* renamed from: a */
    public final Set f291a;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f289b = copyOnWriteArrayList;
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new C0398h(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    /* renamed from: a */
    public static C0396f m278a(String str) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = f290c;
        C0399i iVar = (C0399i) concurrentHashMap.get(str);
        if (iVar == null) {
            if (concurrentHashMap.isEmpty()) {
                throw new RuntimeException("No time-zone data files registered");
            }
            throw new RuntimeException("Unknown time-zone ID: " + str);
        } else if (iVar.f291a.contains(str)) {
            return new C0396f(TimeZone.getTimeZone(str));
        } else {
            throw new RuntimeException("Not a built-in time zone: " + str);
        }
    }

    /* renamed from: b */
    public static void m277b(C0399i iVar) {
        Objects.requireNonNull(iVar, "provider");
        synchronized (C0399i.class) {
            try {
                for (String str : iVar.f291a) {
                    Objects.requireNonNull(str, "zoneId");
                    if (((C0399i) f290c.putIfAbsent(str, iVar)) != null) {
                        throw new RuntimeException("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + iVar);
                    }
                }
                Collections.unmodifiableSet(new HashSet(f290c.keySet()));
            } catch (Throwable th) {
                throw th;
            }
        }
        f289b.add(iVar);
    }

    public C0399i() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(str);
        }
        this.f291a = Collections.unmodifiableSet(linkedHashSet);
    }
}
