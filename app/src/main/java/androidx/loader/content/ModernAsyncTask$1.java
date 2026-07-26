package androidx.loader.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class ModernAsyncTask$1 implements ThreadFactory {
    public final /* synthetic */ int $r8$classId;
    public final AtomicInteger mCount;

    public ModernAsyncTask$1(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.mCount = new AtomicInteger(0);
                return;
            default:
                this.mCount = new AtomicInteger(1);
                return;
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                return new Thread(runnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
            default:
                Thread thread = new Thread(runnable);
                thread.setName("arch_disk_io_" + this.mCount.getAndIncrement());
                return thread;
        }
    }
}
