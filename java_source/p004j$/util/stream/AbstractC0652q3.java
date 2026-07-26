package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.q3 */
/* loaded from: classes2.dex */
public abstract class AbstractC0652q3 extends CountedCompleter implements AbstractC0594k5 {

    /* renamed from: a */
    public final Spliterator f702a;

    /* renamed from: b */
    public final AbstractC0692u3 f703b;

    /* renamed from: c */
    public final long f704c;

    /* renamed from: d */
    public final long f705d;

    /* renamed from: e */
    public final long f706e;

    /* renamed from: f */
    public int f707f;

    /* renamed from: g */
    public int f708g;

    /* renamed from: a */
    public abstract AbstractC0652q3 mo165a(Spliterator spliterator, long j, long j2);

    public /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    public AbstractC0652q3(Spliterator spliterator, AbstractC0692u3 u3Var, int i) {
        this.f702a = spliterator;
        this.f703b = u3Var;
        this.f704c = AbstractC0518d.m212e(spliterator.estimateSize());
        this.f705d = 0L;
        this.f706e = i;
    }

    public AbstractC0652q3(AbstractC0652q3 q3Var, Spliterator spliterator, long j, long j2, int i) {
        super(q3Var);
        this.f702a = spliterator;
        this.f703b = q3Var.f703b;
        this.f704c = q3Var.f704c;
        this.f705d = j;
        this.f706e = j2;
        if (j < 0 || j2 < 0 || (j + j2) - 1 >= i) {
            throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)));
        }
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f702a;
        AbstractC0652q3 q3Var = this;
        while (spliterator.estimateSize() > q3Var.f704c && (trySplit = spliterator.mo899trySplit()) != null) {
            q3Var.setPendingCount(1);
            long estimateSize = trySplit.estimateSize();
            AbstractC0652q3 q3Var2 = q3Var;
            q3Var2.mo165a(trySplit, q3Var.f705d, estimateSize).fork();
            q3Var = q3Var2.mo165a(spliterator, q3Var2.f705d + estimateSize, q3Var2.f706e - estimateSize);
        }
        AbstractC0652q3 q3Var3 = q3Var;
        q3Var3.f703b.mo142E0(spliterator, q3Var3);
        q3Var3.propagateCompletion();
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        long j2 = this.f706e;
        if (j <= j2) {
            int i = (int) this.f705d;
            this.f707f = i;
            this.f708g = i + ((int) j2);
            return;
        }
        throw new IllegalStateException("size passed to Sink.begin exceeds array length");
    }
}
