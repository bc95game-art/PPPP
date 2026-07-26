package androidx.core.provider;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
public final class RequestExecutor$DefaultThreadFactory implements ThreadFactory {

    /* loaded from: classes.dex */
    public final class ProcessPriorityThread extends Thread {
        public final int mPriority = 10;

        public ProcessPriorityThread(Runnable runnable) {
            super(runnable, "fonts-androidx");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(this.mPriority);
            super.run();
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new ProcessPriorityThread(runnable);
    }
}
