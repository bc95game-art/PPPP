package p004j$.util.stream;

import java.util.stream.Collector;
/* renamed from: j$.util.stream.i */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0568i {

    /* renamed from: a */
    public final /* synthetic */ Collector f591a;

    public /* synthetic */ C0568i(Collector collector) {
        this.f591a = collector;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Collector collector = this.f591a;
        if (obj instanceof C0568i) {
            obj = ((C0568i) obj).f591a;
        }
        return collector.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f591a.hashCode();
    }
}
