package p004j$.util;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Function;
/* renamed from: j$.util.d */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0434d implements Comparator, Serializable {

    /* renamed from: a */
    public final /* synthetic */ int f387a = 0;

    /* renamed from: b */
    public final /* synthetic */ Comparator f388b;

    /* renamed from: c */
    public final /* synthetic */ Object f389c;

    public /* synthetic */ C0434d(EnumC0437e eVar, Comparator comparator) {
        this.f389c = eVar;
        this.f388b = comparator;
    }

    public /* synthetic */ C0434d(Function function, Comparator comparator) {
        this.f388b = comparator;
        this.f389c = function;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f387a) {
            case 0:
                Comparator comparator = this.f388b;
                int compare = ((EnumC0437e) this.f389c).compare(obj, obj2);
                return compare != 0 ? compare : comparator.compare(obj, obj2);
            default:
                Comparator comparator2 = this.f388b;
                Function function = (Function) this.f389c;
                return comparator2.compare(function.apply(obj), function.apply(obj2));
        }
    }
}
