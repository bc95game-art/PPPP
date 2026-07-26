package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.Predicate;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.v8 */
/* loaded from: classes2.dex */
public final class C0707v8 extends AbstractC0717w8 implements Consumer {

    /* renamed from: e */
    public final Predicate f801e;

    /* renamed from: f */
    public Object f802f;

    /* renamed from: g */
    public final /* synthetic */ int f803g;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0707v8(Spliterator spliterator, Predicate predicate, int i) {
        super(spliterator);
        this.f803g = i;
        this.f801e = predicate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0707v8(Spliterator spliterator, C0707v8 v8Var, int i) {
        super(spliterator, v8Var);
        this.f803g = i;
        this.f801e = v8Var.f801e;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f814d = (this.f814d + 1) & 63;
        this.f802f = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        if (r0 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        r6.f812b.set(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
        r7.accept(r6.f802f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
        return r2;
     */
    @Override // p004j$.util.Spliterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean tryAdvance(Consumer consumer) {
        boolean tryAdvance;
        boolean z;
        switch (this.f803g) {
            case 0:
                boolean z2 = this.f813c;
                Spliterator spliterator = this.f811a;
                if (!z2) {
                    return spliterator.tryAdvance(consumer);
                }
                boolean z3 = false;
                this.f813c = false;
                while (true) {
                    tryAdvance = spliterator.tryAdvance(this);
                    if (tryAdvance && m73a() && this.f801e.test(this.f802f)) {
                        z3 = true;
                    }
                }
                return tryAdvance;
            default:
                if (!this.f813c || !m73a() || !this.f811a.tryAdvance(this)) {
                    z = true;
                } else {
                    z = this.f801e.test(this.f802f);
                    if (z) {
                        consumer.accept(this.f802f);
                        return true;
                    }
                }
                this.f813c = false;
                if (!z) {
                    this.f812b.set(true);
                }
                return false;
        }
    }

    @Override // p004j$.util.stream.AbstractC0717w8, p004j$.util.Spliterator
    /* renamed from: trySplit */
    public Spliterator mo899trySplit() {
        switch (this.f803g) {
            case 1:
                if (this.f812b.get()) {
                    return null;
                }
                return super.mo899trySplit();
            default:
                return super.mo899trySplit();
        }
    }

    @Override // p004j$.util.stream.AbstractC0717w8
    /* renamed from: b */
    public final Spliterator mo72b(Spliterator spliterator) {
        switch (this.f803g) {
            case 0:
                return new C0707v8(spliterator, this, 0);
            default:
                return new C0707v8(spliterator, this, 1);
        }
    }
}
