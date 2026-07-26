package p004j$.util.stream;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import p004j$.util.Spliterator;
import p004j$.util.concurrent.C0428t;
/* renamed from: j$.util.stream.s1 */
/* loaded from: classes2.dex */
public final class C0670s1 extends AbstractC0498b {

    /* renamed from: j */
    public final C0428t f740j;

    public C0670s1(C0428t tVar, AbstractC0488a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.f740j = tVar;
    }

    public C0670s1(C0670s1 s1Var, Spliterator spliterator) {
        super(s1Var, spliterator);
        this.f740j = s1Var.f740j;
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: c */
    public final AbstractC0518d mo76c(Spliterator spliterator) {
        return new C0670s1(this, spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: a */
    public final Object mo77a() {
        AbstractC0692u3 u3Var = this.f524a;
        AbstractC0650q1 q1Var = (AbstractC0650q1) ((Supplier) this.f740j.f374c).get();
        u3Var.mo142E0(this.f525b, q1Var);
        boolean z = q1Var.f701b;
        if (z == ((EnumC0660r1) this.f740j.f373b).f725b) {
            Boolean valueOf = Boolean.valueOf(z);
            AtomicReference atomicReference = this.f499h;
            while (!atomicReference.compareAndSet(null, valueOf) && atomicReference.get() == null) {
            }
        }
        return null;
    }

    @Override // p004j$.util.stream.AbstractC0498b
    /* renamed from: h */
    public final Object mo88h() {
        return Boolean.valueOf(!((EnumC0660r1) this.f740j.f373b).f725b);
    }
}
