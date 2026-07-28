package p004j$.util.stream;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import p004j$.util.C0440f;
/* renamed from: j$.util.stream.g4 */
/* loaded from: classes2.dex */
public final class C0553g4 extends AbstractC0692u3 {

    /* renamed from: h */
    public final /* synthetic */ BinaryOperator f562h;

    /* renamed from: i */
    public final /* synthetic */ BiConsumer f563i;

    /* renamed from: j */
    public final /* synthetic */ Supplier f564j;

    /* renamed from: k */
    public final /* synthetic */ C0568i f565k;

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: D0 */
    public final AbstractC0643p4 mo26D0() {
        return new C0563h4(this.f564j, this.f563i, this.f562h);
    }

    @Override // p004j$.util.stream.AbstractC0692u3, p004j$.util.stream.AbstractC0527d8
    /* renamed from: w */
    public final int mo94w() {
        Set<Collector.Characteristics> characteristics = this.f565k.f591a.characteristics();
        if (characteristics != null && !characteristics.isEmpty()) {
            HashSet hashSet = new HashSet();
            Collector.Characteristics next = characteristics.iterator().next();
            if (next instanceof EnumC0558h) {
                Iterator<Collector.Characteristics> it = characteristics.iterator();
                while (it.hasNext()) {
                    try {
                        EnumC0558h hVar = (EnumC0558h) it.next();
                        hashSet.add(hVar == null ? null : hVar == EnumC0558h.CONCURRENT ? Collector.Characteristics.CONCURRENT : hVar == EnumC0558h.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                    } catch (ClassCastException e) {
                        C0440f.m235a(e, "java.util.stream.Collector.Characteristics");
                        throw null;
                    }
                }
            } else if (next instanceof Collector.Characteristics) {
                Iterator<Collector.Characteristics> it2 = characteristics.iterator();
                while (it2.hasNext()) {
                    try {
                        Collector.Characteristics next2 = it2.next();
                        hashSet.add(next2 == null ? null : next2 == Collector.Characteristics.CONCURRENT ? EnumC0558h.CONCURRENT : next2 == Collector.Characteristics.UNORDERED ? EnumC0558h.UNORDERED : EnumC0558h.IDENTITY_FINISH);
                    } catch (ClassCastException e2) {
                        C0440f.m235a(e2, "java.util.stream.Collector.Characteristics");
                        throw null;
                    }
                }
            } else {
                C0440f.m235a(next.getClass(), "java.util.stream.Collector.Characteristics");
                throw null;
            }
            characteristics = hashSet;
        }
        if (characteristics.contains(EnumC0558h.UNORDERED)) {
            return EnumC0725x6.f835r;
        }
        return 0;
    }

    public C0553g4(EnumC0735y6 y6Var, BinaryOperator binaryOperator, BiConsumer biConsumer, Supplier supplier, C0568i iVar) {
        this.f562h = binaryOperator;
        this.f563i = biConsumer;
        this.f564j = supplier;
        this.f565k = iVar;
    }
}
