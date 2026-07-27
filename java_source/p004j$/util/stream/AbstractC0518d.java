package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.d */
/* loaded from: classes2.dex */
public abstract class AbstractC0518d extends CountedCompleter {

    /* renamed from: g */
    public static final int f523g = ForkJoinPool.getCommonPoolParallelism() << 2;

    /* renamed from: a */
    public final AbstractC0692u3 f524a;

    /* renamed from: b */
    public Spliterator f525b;

    /* renamed from: c */
    public long f526c;

    /* renamed from: d */
    public AbstractC0518d f527d;

    /* renamed from: e */
    public AbstractC0518d f528e;

    /* renamed from: f */
    public Object f529f;

    /* renamed from: a */
    public abstract Object mo77a();

    /* renamed from: c */
    public abstract AbstractC0518d mo76c(Spliterator spliterator);

    public AbstractC0518d(AbstractC0692u3 u3Var, Spliterator spliterator) {
        super(null);
        this.f524a = u3Var;
        this.f525b = spliterator;
        this.f526c = 0L;
    }

    public AbstractC0518d(AbstractC0518d dVar, Spliterator spliterator) {
        super(dVar);
        this.f525b = spliterator;
        this.f524a = dVar.f524a;
        this.f526c = dVar.f526c;
    }

    /* renamed from: e */
    public static long m212e(long j) {
        long j2 = j / f523g;
        if (j2 > 0) {
            return j2;
        }
        return 1L;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.f529f;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: d */
    public void mo213d(Object obj) {
        this.f529f = obj;
    }

    /* renamed from: b */
    public final boolean m214b() {
        return ((AbstractC0518d) getCompleter()) == null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f525b;
        long estimateSize = spliterator.estimateSize();
        long j = this.f526c;
        if (j == 0) {
            j = m212e(estimateSize);
            this.f526c = j;
        }
        boolean z = false;
        AbstractC0518d dVar = this;
        while (estimateSize > j && (trySplit = spliterator.mo899trySplit()) != null) {
            AbstractC0518d c = dVar.mo76c(trySplit);
            dVar.f527d = c;
            AbstractC0518d c2 = dVar.mo76c(spliterator);
            dVar.f528e = c2;
            dVar.setPendingCount(1);
            if (z) {
                spliterator = trySplit;
                dVar = c;
                c = c2;
            } else {
                dVar = c2;
            }
            z = !z;
            c.fork();
            estimateSize = spliterator.estimateSize();
        }
        dVar.mo213d(dVar.mo77a());
        dVar.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.f525b = null;
        this.f528e = null;
        this.f527d = null;
    }
}
