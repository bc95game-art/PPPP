package p004j$.time.chrono;

import p004j$.time.C0354k;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0378o;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0382s;
/* renamed from: j$.time.chrono.b */
/* loaded from: classes2.dex */
public interface AbstractC0289b extends AbstractC0376m, AbstractC0378o, Comparable {
    /* renamed from: A */
    int mo407A(AbstractC0289b bVar);

    /* renamed from: a */
    AbstractC0310m mo387a();

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: c */
    AbstractC0289b mo313c(long j, AbstractC0380q qVar);

    @Override // p004j$.time.temporal.AbstractC0376m
    /* renamed from: d */
    AbstractC0289b mo886d(long j, AbstractC0382s sVar);

    @Override // p004j$.time.temporal.AbstractC0377n
    /* renamed from: e */
    boolean mo299e(AbstractC0380q qVar);

    int hashCode();

    String toString();

    /* renamed from: x */
    long mo386x();

    /* renamed from: y */
    AbstractC0295e mo385y(C0354k kVar);
}
