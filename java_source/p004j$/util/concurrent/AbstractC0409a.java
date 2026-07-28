package p004j$.util.concurrent;
/* renamed from: j$.util.concurrent.a */
/* loaded from: classes2.dex */
public abstract class AbstractC0409a extends C0424p {

    /* renamed from: i */
    public final ConcurrentHashMap f334i;

    /* renamed from: j */
    public C0420l f335j;

    public AbstractC0409a(C0420l[] lVarArr, int i, int i2, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i, 0, i2);
        this.f334i = concurrentHashMap;
        m249a();
    }

    public final boolean hasNext() {
        return this.f355b != null;
    }

    public final boolean hasMoreElements() {
        return this.f355b != null;
    }

    public final void remove() {
        C0420l lVar = this.f335j;
        if (lVar != null) {
            this.f335j = null;
            this.f334i.m266g(lVar.f347b, null, null);
            return;
        }
        throw new IllegalStateException();
    }
}
