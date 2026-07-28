package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntFunction;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.e2 */
/* loaded from: classes2.dex */
public interface AbstractC0531e2 {
    /* renamed from: a */
    AbstractC0531e2 mo63a(int i);

    long count();

    void forEach(Consumer consumer);

    /* renamed from: j */
    AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction);

    /* renamed from: k */
    void mo70k(Object[] objArr, int i);

    /* renamed from: m */
    Object[] mo59m(IntFunction intFunction);

    /* renamed from: o */
    int mo58o();

    /* renamed from: spliterator */
    Spliterator mo904spliterator();
}
