package p004j$.util.stream;

import p004j$.util.C0471n;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.k */
/* loaded from: classes2.dex */
public final class C0588k extends AbstractC0554g5 {

    /* renamed from: b */
    public final /* synthetic */ int f622b;

    /* renamed from: c */
    public boolean f623c;

    /* renamed from: d */
    public Object f624d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0588k(AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f622b = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0588k(C0557g8 g8Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f622b = 2;
        this.f624d = g8Var;
        this.f623c = true;
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        switch (this.f622b) {
            case 0:
                this.f623c = false;
                this.f624d = null;
                this.f566a.mo23c(-1L);
                return;
            case 1:
                this.f566a.mo23c(-1L);
                return;
            default:
                this.f566a.mo23c(-1L);
                return;
        }
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f622b) {
            case 0:
                AbstractC0594k5 k5Var = this.f566a;
                if (obj != null) {
                    Object obj2 = this.f624d;
                    if (obj2 == null || !obj.equals(obj2)) {
                        this.f624d = obj;
                        k5Var.accept((AbstractC0594k5) obj);
                        return;
                    }
                    return;
                } else if (!this.f623c) {
                    this.f623c = true;
                    this.f624d = null;
                    k5Var.accept((AbstractC0594k5) null);
                    return;
                } else {
                    return;
                }
            case 1:
                Stream stream = (Stream) ((C0471n) ((C0638p) this.f624d).f686t).apply((C0471n) obj);
                if (stream != null) {
                    try {
                        boolean z = this.f623c;
                        AbstractC0594k5 k5Var2 = this.f566a;
                        if (!z) {
                            ((Stream) stream.sequential()).forEach(k5Var2);
                        } else {
                            Spliterator spliterator = ((Stream) stream.sequential()).spliterator();
                            while (!k5Var2.mo27e() && spliterator.tryAdvance(k5Var2)) {
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (stream != null) {
                    stream.close();
                    return;
                }
                return;
            default:
                if (this.f623c) {
                    boolean test = ((C0557g8) this.f624d).f573t.test(obj);
                    this.f623c = test;
                    if (test) {
                        this.f566a.accept((AbstractC0594k5) obj);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public boolean mo27e() {
        switch (this.f622b) {
            case 1:
                this.f623c = true;
                return this.f566a.mo27e();
            case 2:
                return !this.f623c || this.f566a.mo27e();
            default:
                return super.mo27e();
        }
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    public void end() {
        switch (this.f622b) {
            case 0:
                this.f623c = false;
                this.f624d = null;
                this.f566a.end();
                return;
            default:
                super.end();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0588k(C0638p pVar, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f622b = 1;
        this.f624d = pVar;
    }
}
