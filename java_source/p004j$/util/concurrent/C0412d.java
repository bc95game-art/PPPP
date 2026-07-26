package p004j$.util.concurrent;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* renamed from: j$.util.concurrent.d */
/* loaded from: classes2.dex */
public final class C0412d extends AbstractC0409a implements Iterator {
    @Override // java.util.Iterator
    public final Object next() {
        C0420l lVar = this.f355b;
        if (lVar != null) {
            Object obj = lVar.f347b;
            Object obj2 = lVar.f348c;
            this.f335j = lVar;
            m249a();
            return new C0419k(obj, obj2, this.f334i);
        }
        throw new NoSuchElementException();
    }
}
