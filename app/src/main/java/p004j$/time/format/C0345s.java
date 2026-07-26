package p004j$.time.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import p004j$.util.stream.EnumC0715w6;
/* renamed from: j$.time.format.s */
/* loaded from: classes2.dex */
public final class C0345s {

    /* renamed from: a */
    public final Map f166a;

    /* renamed from: b */
    public void m408b(EnumC0715w6 w6Var) {
        ((EnumMap) this.f166a).put((EnumMap) w6Var, (EnumC0715w6) 1);
    }

    public C0345s(int i, Map map) {
        switch (i) {
            case 1:
                this.f166a = map;
                return;
            default:
                this.f166a = map;
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        C0344r rVar = C0329c.f128b;
                        hashMap2.put((String) entry2.getValue(), new AbstractMap.SimpleImmutableEntry((String) entry2.getValue(), (Long) entry2.getKey()));
                    }
                    ArrayList arrayList2 = new ArrayList(hashMap2.values());
                    Collections.sort(arrayList2, C0329c.f128b);
                    hashMap.put((EnumC0349w) entry.getKey(), arrayList2);
                    arrayList.addAll(arrayList2);
                    hashMap.put(null, arrayList);
                }
                Collections.sort(arrayList, C0329c.f128b);
                return;
        }
    }

    /* renamed from: a */
    public String m409a(long j, EnumC0349w wVar) {
        Map map = (Map) this.f166a.get(wVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j));
        }
        return null;
    }
}
