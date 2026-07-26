package p004j$.util.stream;
/* renamed from: j$.util.stream.c8 */
/* loaded from: classes2.dex */
public final class RunnableC0517c8 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Runnable f521a;

    /* renamed from: b */
    public final /* synthetic */ Runnable f522b;

    public RunnableC0517c8(Runnable runnable, Runnable runnable2) {
        this.f521a = runnable;
        this.f522b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f521a.run();
            this.f522b.run();
        } catch (Throwable th) {
            try {
                this.f522b.run();
            } catch (Throwable th2) {
                try {
                    th.addSuppressed(th2);
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
