package p004j$.util;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.j */
/* loaded from: classes2.dex */
public final class C0459j implements Iterator, AbstractC0752w {

    /* renamed from: a */
    public final /* synthetic */ int f438a = 0;

    /* renamed from: b */
    public final Iterator f439b;

    public C0459j(C0462k kVar) {
        this.f439b = kVar.f440a.iterator();
    }

    public C0459j(C0480q qVar) {
        this.f439b = qVar.f440a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f438a) {
            case 0:
                return this.f439b.hasNext();
            default:
                return this.f439b.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f438a) {
            case 0:
                return this.f439b.next();
            default:
                return new C0474o((Map.Entry) this.f439b.next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f438a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Iterator, p004j$.util.AbstractC0752w
    public final void forEachRemaining(Consumer consumer) {
        switch (this.f438a) {
            case 0:
                AbstractC0279a.m551N(this.f439b, consumer);
                return;
            default:
                AbstractC0279a.m551N(this.f439b, new C0471n(0, consumer));
                return;
        }
    }
}
