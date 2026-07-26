package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.b */
/* loaded from: classes2.dex */
public abstract class AbstractC0498b extends AbstractC0518d {

    /* renamed from: h */
    public final AtomicReference f499h;

    /* renamed from: i */
    public volatile boolean f500i;

    /* renamed from: h */
    public abstract Object mo88h();

    public AbstractC0498b(AbstractC0692u3 u3Var, Spliterator spliterator) {
        super(u3Var, spliterator);
        this.f499h = new AtomicReference(null);
    }

    public AbstractC0498b(AbstractC0498b bVar, Spliterator spliterator) {
        super(bVar, spliterator);
        this.f499h = bVar.f499h;
    }

    @Override // p004j$.util.stream.AbstractC0518d, java.util.concurrent.CountedCompleter
    public final void compute() {
        Object obj;
        Spliterator trySplit;
        Spliterator spliterator = this.f525b;
        long estimateSize = spliterator.estimateSize();
        long j = this.f526c;
        if (j == 0) {
            j = AbstractC0518d.m212e(estimateSize);
            this.f526c = j;
        }
        AtomicReference atomicReference = this.f499h;
        boolean z = false;
        AbstractC0498b bVar = this;
        while (true) {
            obj = atomicReference.get();
            if (obj != null) {
                break;
            }
            boolean z2 = bVar.f500i;
            if (!z2) {
                CountedCompleter<?> completer = bVar.getCompleter();
                while (true) {
                    AbstractC0498b bVar2 = (AbstractC0498b) ((AbstractC0518d) completer);
                    if (z2 || bVar2 == null) {
                        break;
                    }
                    z2 = bVar2.f500i;
                    completer = bVar2.getCompleter();
                }
            }
            if (z2) {
                obj = bVar.mo88h();
                break;
            } else if (estimateSize <= j || (trySplit = spliterator.mo899trySplit()) == null) {
                break;
            } else {
                AbstractC0498b bVar3 = (AbstractC0498b) bVar.mo76c(trySplit);
                bVar.f527d = bVar3;
                AbstractC0498b bVar4 = (AbstractC0498b) bVar.mo76c(spliterator);
                bVar.f528e = bVar4;
                bVar.setPendingCount(1);
                if (z) {
                    spliterator = trySplit;
                    bVar = bVar3;
                    bVar3 = bVar4;
                } else {
                    bVar = bVar4;
                }
                z = !z;
                bVar3.fork();
                estimateSize = spliterator.estimateSize();
            }
        }
        obj = bVar.mo77a();
        bVar.mo213d(obj);
        bVar.tryComplete();
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: d */
    public final void mo213d(Object obj) {
        if (!m214b()) {
            this.f529f = obj;
        } else if (obj != null) {
            AtomicReference atomicReference = this.f499h;
            while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
            }
        }
    }

    @Override // p004j$.util.stream.AbstractC0518d, java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public final Object getRawResult() {
        return m216i();
    }

    /* renamed from: i */
    public final Object m216i() {
        if (!m214b()) {
            return this.f529f;
        }
        Object obj = this.f499h.get();
        return obj == null ? mo88h() : obj;
    }

    /* renamed from: f */
    public void mo89f() {
        this.f500i = true;
    }

    /* renamed from: g */
    public final void m217g() {
        AbstractC0498b bVar = this;
        for (AbstractC0498b bVar2 = (AbstractC0498b) ((AbstractC0518d) getCompleter()); bVar2 != null; bVar2 = (AbstractC0498b) ((AbstractC0518d) bVar2.getCompleter())) {
            if (bVar2.f527d == bVar) {
                AbstractC0498b bVar3 = (AbstractC0498b) bVar2.f528e;
                if (!bVar3.f500i) {
                    bVar3.mo89f();
                }
            }
            bVar = bVar2;
        }
    }
}
