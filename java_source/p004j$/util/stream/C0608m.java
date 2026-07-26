package p004j$.util.stream;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntFunction;
import p004j$.time.format.C0328b;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.concurrent.C0428t;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: j$.util.stream.m */
/* loaded from: classes2.dex */
public final class C0608m extends AbstractC0494a5 {
    /* renamed from: T0 */
    public static C0581j2 m171T0(AbstractC0692u3 u3Var, Spliterator spliterator) {
        C0328b bVar = new C0328b(12);
        C0328b bVar2 = new C0328b(13);
        C0328b bVar3 = new C0328b(14);
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(bVar2);
        Objects.requireNonNull(bVar3);
        return new C0581j2((Collection) new C0741z3(EnumC0735y6.REFERENCE, bVar3, bVar2, bVar, 3).mo108j(u3Var, spliterator));
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: M0 */
    public final AbstractC0531e2 mo161M0(AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        AbstractC0488a aVar = (AbstractC0488a) u3Var;
        if (EnumC0725x6.DISTINCT.m66l(aVar.f481m)) {
            return u3Var.mo106k0(spliterator, false, intFunction);
        }
        if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
            return m171T0(u3Var, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        C0428t tVar = new C0428t(4, atomicBoolean, concurrentHashMap);
        Objects.requireNonNull(tVar);
        new C0629o0(tVar, false).m168a(u3Var, spliterator);
        Collection keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(keySet);
            hashSet.add(null);
            keySet = hashSet;
        }
        return new C0581j2(keySet);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: N0 */
    public final Spliterator mo160N0(AbstractC0488a aVar, Spliterator spliterator) {
        if (EnumC0725x6.DISTINCT.m66l(aVar.f481m)) {
            return aVar.mo138G0(spliterator);
        }
        if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
            return m171T0(aVar, spliterator).mo904spliterator();
        }
        return new C0556g7(aVar.mo138G0(spliterator), new ConcurrentHashMap());
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        Objects.requireNonNull(k5Var);
        if (EnumC0725x6.DISTINCT.m66l(i)) {
            return k5Var;
        }
        if (EnumC0725x6.SORTED.m66l(i)) {
            return new C0588k(k5Var);
        }
        return new C0598l(k5Var);
    }
}
