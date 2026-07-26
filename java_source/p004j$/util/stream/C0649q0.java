package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import p004j$.util.Spliterator;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: j$.util.stream.q0 */
/* loaded from: classes2.dex */
public final class C0649q0 extends CountedCompleter {

    /* renamed from: a */
    public final AbstractC0692u3 f693a;

    /* renamed from: b */
    public Spliterator f694b;

    /* renamed from: c */
    public final long f695c;

    /* renamed from: d */
    public final ConcurrentHashMap f696d;

    /* renamed from: e */
    public final AbstractC0639p0 f697e;

    /* renamed from: f */
    public final C0649q0 f698f;

    /* renamed from: g */
    public AbstractC0531e2 f699g;

    public C0649q0(AbstractC0692u3 u3Var, Spliterator spliterator, AbstractC0639p0 p0Var) {
        super(null);
        this.f693a = u3Var;
        this.f694b = spliterator;
        this.f695c = AbstractC0518d.m212e(spliterator.estimateSize());
        this.f696d = new ConcurrentHashMap(Math.max(16, AbstractC0518d.f523g << 1));
        this.f697e = p0Var;
        this.f698f = null;
    }

    public C0649q0(C0649q0 q0Var, Spliterator spliterator, C0649q0 q0Var2) {
        super(q0Var);
        this.f693a = q0Var.f693a;
        this.f694b = spliterator;
        this.f695c = q0Var.f695c;
        this.f696d = q0Var.f696d;
        this.f697e = q0Var.f697e;
        this.f698f = q0Var2;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f694b;
        long j = this.f695c;
        boolean z = false;
        C0649q0 q0Var = this;
        while (spliterator.estimateSize() > j && (trySplit = spliterator.mo899trySplit()) != null) {
            C0649q0 q0Var2 = new C0649q0(q0Var, trySplit, q0Var.f698f);
            C0649q0 q0Var3 = new C0649q0(q0Var, spliterator, q0Var2);
            q0Var.addToPendingCount(1);
            q0Var3.addToPendingCount(1);
            q0Var.f696d.put(q0Var2, q0Var3);
            if (q0Var.f698f != null) {
                q0Var2.addToPendingCount(1);
                if (q0Var.f696d.replace(q0Var.f698f, q0Var, q0Var2)) {
                    q0Var.addToPendingCount(-1);
                } else {
                    q0Var2.addToPendingCount(-1);
                }
            }
            if (z) {
                spliterator = trySplit;
                q0Var = q0Var2;
                q0Var2 = q0Var3;
            } else {
                q0Var = q0Var3;
            }
            z = !z;
            q0Var2.fork();
        }
        if (q0Var.getPendingCount() > 0) {
            C0529e0 e0Var = new C0529e0(6);
            AbstractC0692u3 u3Var = q0Var.f693a;
            AbstractC0710w1 A0 = u3Var.mo44A0(u3Var.mo105l0(spliterator), e0Var);
            q0Var.f693a.mo142E0(spliterator, A0);
            q0Var.f699g = A0.mo903build();
            q0Var.f694b = null;
        }
        q0Var.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractC0531e2 e2Var = this.f699g;
        if (e2Var != null) {
            e2Var.forEach(this.f697e);
            this.f699g = null;
        } else {
            Spliterator spliterator = this.f694b;
            if (spliterator != null) {
                this.f693a.mo142E0(spliterator, this.f697e);
                this.f694b = null;
            }
        }
        C0649q0 q0Var = (C0649q0) this.f696d.remove(this);
        if (q0Var != null) {
            q0Var.tryComplete();
        }
    }
}
