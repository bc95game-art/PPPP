package p004j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
/* renamed from: j$.time.zone.h */
/* loaded from: classes2.dex */
public final class C0398h implements PrivilegedAction {

    /* renamed from: a */
    public final /* synthetic */ List f288a;

    public C0398h(List list) {
        this.f288a = list;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property != null) {
            try {
                C0399i iVar = (C0399i) C0399i.class.cast(Class.forName(property, true, C0399i.class.getClassLoader()).newInstance());
                C0399i.m277b(iVar);
                ((ArrayList) this.f288a).add(iVar);
                return null;
            } catch (Exception e) {
                throw new Error(e);
            }
        } else {
            C0399i.m277b(new C0399i());
            return null;
        }
    }
}
