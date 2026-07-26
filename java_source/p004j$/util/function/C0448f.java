package p004j$.util.function;

import java.util.function.Predicate;
import p004j$.util.C0471n;
/* renamed from: j$.util.function.f */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0448f implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ int f413a;

    /* renamed from: b */
    public final /* synthetic */ Predicate f414b;

    /* renamed from: c */
    public final /* synthetic */ Predicate f415c;

    public /* synthetic */ C0448f(Predicate predicate, Predicate predicate2, int i) {
        this.f413a = i;
        this.f414b = predicate;
        this.f415c = predicate2;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f413a) {
            case 0:
                return AbstractC0449g.m233a(this, predicate);
            default:
                return AbstractC0449g.m233a(this, predicate);
        }
    }

    /* renamed from: or */
    public final /* synthetic */ Predicate m234or(Predicate predicate) {
        switch (this.f413a) {
            case 0:
                return AbstractC0449g.m231c(this, predicate);
            default:
                return AbstractC0449g.m231c(this, predicate);
        }
    }

    public final Predicate negate() {
        switch (this.f413a) {
            case 0:
                return new C0471n(1, this);
            default:
                return new C0471n(1, this);
        }
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f413a) {
            case 0:
                return this.f414b.test(obj) && this.f415c.test(obj);
            default:
                return this.f414b.test(obj) || this.f415c.test(obj);
        }
    }
}
