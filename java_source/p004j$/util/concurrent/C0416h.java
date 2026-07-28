package p004j$.util.concurrent;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* renamed from: j$.util.concurrent.h */
/* loaded from: classes2.dex */
public final class C0416h extends AbstractC0409a implements Iterator, Enumeration {

    /* renamed from: k */
    public final /* synthetic */ int f340k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0416h(C0420l[] lVarArr, int i, int i2, ConcurrentHashMap concurrentHashMap, int i3) {
        super(lVarArr, i, i2, concurrentHashMap);
        this.f340k = i3;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f340k) {
            case 0:
                C0420l lVar = this.f355b;
                if (lVar != null) {
                    Object obj = lVar.f347b;
                    this.f335j = lVar;
                    m249a();
                    return obj;
                }
                throw new NoSuchElementException();
            default:
                C0420l lVar2 = this.f355b;
                if (lVar2 != null) {
                    Object obj2 = lVar2.f348c;
                    this.f335j = lVar2;
                    m249a();
                    return obj2;
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        switch (this.f340k) {
            case 0:
                return next();
            default:
                return next();
        }
    }
}
