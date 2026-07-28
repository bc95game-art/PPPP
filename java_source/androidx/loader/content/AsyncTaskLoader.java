package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.core.util.TimeUtils;
import androidx.loader.content.AsyncTaskLoader;
import com.android.billingclient.api.zzbd;
import com.google.android.gms.internal.base.zau;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class AsyncTaskLoader extends Loader {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime = -10000;
    volatile LoadTask mTask;
    long mUpdateThrottle;

    /* loaded from: classes.dex */
    public final class LoadTask implements Runnable {
        public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;
        public static zau sHandler;
        public final ModernAsyncTask$3 mFuture;
        public final zzbd mWorker;
        public boolean waiting;
        public volatile int mStatus = 1;
        public final AtomicBoolean mCancelled = new AtomicBoolean();
        public final AtomicBoolean mTaskInvoked = new AtomicBoolean();
        public final CountDownLatch mDone = new CountDownLatch(1);

        static {
            ModernAsyncTask$1 modernAsyncTask$1 = new ModernAsyncTask$1(0);
            THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), modernAsyncTask$1);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.loader.content.ModernAsyncTask$3] */
        public LoadTask() {
            final zzbd zzbdVar = new zzbd(1, this);
            this.mWorker = zzbdVar;
            this.mFuture = new FutureTask(zzbdVar) { // from class: androidx.loader.content.ModernAsyncTask$3
                @Override // java.util.concurrent.FutureTask
                public final void done() {
                    AsyncTaskLoader.LoadTask loadTask = AsyncTaskLoader.LoadTask.this;
                    AtomicBoolean atomicBoolean = loadTask.mTaskInvoked;
                    try {
                        Object obj = get();
                        if (!atomicBoolean.get()) {
                            loadTask.postResult(obj);
                        }
                    } catch (InterruptedException e) {
                        Log.w("AsyncTask", e);
                    } catch (CancellationException unused) {
                        if (!atomicBoolean.get()) {
                            loadTask.postResult(null);
                        }
                    } catch (ExecutionException e2) {
                        throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
                    } catch (Throwable th) {
                        throw new RuntimeException("An error occurred while executing doInBackground()", th);
                    }
                }
            };
        }

        public final void postResult(Object obj) {
            zau zauVar;
            synchronized (LoadTask.class) {
                try {
                    if (sHandler == null) {
                        sHandler = new zau(Looper.getMainLooper(), 1, false);
                    }
                    zauVar = sHandler;
                } catch (Throwable th) {
                    throw th;
                }
            }
            zauVar.obtainMessage(1, new ModernAsyncTask$AsyncTaskResult(this, obj)).sendToTarget();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.waiting = false;
            AsyncTaskLoader.this.executePendingTask();
        }
    }

    public AsyncTaskLoader(Context context) {
        ThreadPoolExecutor threadPoolExecutor = LoadTask.THREAD_POOL_EXECUTOR;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mReset = true;
        this.mContentChanged = false;
        this.mProcessingChange = false;
        this.mContext = context.getApplicationContext();
        this.mExecutor = threadPoolExecutor;
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(LoadTask loadTask, Object obj) {
        onCanceled(obj);
        if (this.mCancellingTask == loadTask) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    public void dispatchOnLoadComplete(LoadTask loadTask, Object obj) {
        if (this.mTask != loadTask) {
            dispatchOnCancelled(loadTask, obj);
        } else if (isAbandoned()) {
            onCanceled(obj);
        } else {
            commitContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(obj);
        }
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.waiting);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.waiting);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            long j = this.mLastLoadCompleteTime;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (j == 0) {
                printWriter.print("--");
            } else {
                TimeUtils.formatDuration(j - uptimeMillis, printWriter);
            }
            printWriter.println();
        }
    }

    public void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                LoadTask loadTask = this.mTask;
                Executor executor = this.mExecutor;
                if (loadTask.mStatus != 1) {
                    int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(loadTask.mStatus);
                    if (ordinal == 1) {
                        throw new IllegalStateException("Cannot execute task: the task is already running.");
                    } else if (ordinal != 2) {
                        throw new IllegalStateException("We should never reach this state");
                    } else {
                        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                    }
                } else {
                    loadTask.mStatus = 2;
                    loadTask.mWorker.getClass();
                    executor.execute(loadTask.mFuture);
                }
            } else {
                this.mTask.waiting = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            }
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        if (this.mCancellingTask != null) {
            return true;
        }
        return false;
    }

    public abstract Object loadInBackground();

    @Override // androidx.loader.content.Loader
    public boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        } else if (this.mTask.waiting) {
            this.mTask.waiting = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        } else {
            LoadTask loadTask = this.mTask;
            loadTask.mCancelled.set(true);
            boolean cancel = loadTask.mFuture.cancel(false);
            if (cancel) {
                this.mCancellingTask = this.mTask;
                cancelLoadInBackground();
            }
            this.mTask = null;
            return cancel;
        }
    }

    public void onCanceled(Object obj) {
    }

    @Override // androidx.loader.content.Loader
    public void onForceLoad() {
        cancelLoad();
        this.mTask = new LoadTask();
        executePendingTask();
    }

    public Object onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        LoadTask loadTask = this.mTask;
        if (loadTask != null) {
            try {
                loadTask.mDone.await();
            } catch (InterruptedException unused) {
            }
        }
    }
}
