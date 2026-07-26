package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.ModernAsyncTask$AsyncTaskResult;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes.dex */
public class zau extends Handler {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zau(Looper looper, int i, boolean z) {
        super(looper);
        this.$r8$classId = i;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        CountDownLatch countDownLatch;
        switch (this.$r8$classId) {
            case 1:
                ModernAsyncTask$AsyncTaskResult modernAsyncTask$AsyncTaskResult = (ModernAsyncTask$AsyncTaskResult) message.obj;
                int i = message.what;
                if (i == 1) {
                    AsyncTaskLoader.LoadTask loadTask = modernAsyncTask$AsyncTaskResult.mTask;
                    Object obj = modernAsyncTask$AsyncTaskResult.mData[0];
                    if (loadTask.mCancelled.get()) {
                        countDownLatch = loadTask.mDone;
                        try {
                            AsyncTaskLoader.this.dispatchOnCancelled(loadTask, obj);
                            countDownLatch.countDown();
                        } finally {
                        }
                    } else {
                        countDownLatch = loadTask.mDone;
                        try {
                            AsyncTaskLoader.this.dispatchOnLoadComplete(loadTask, obj);
                        } finally {
                        }
                    }
                    loadTask.mStatus = 3;
                    return;
                } else if (i == 2) {
                    AsyncTaskLoader.LoadTask loadTask2 = modernAsyncTask$AsyncTaskResult.mTask;
                    return;
                } else {
                    return;
                }
            default:
                super.handleMessage(message);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zau(Looper looper, Handler.Callback callback, int i) {
        super(looper, callback);
        this.$r8$classId = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zau(Looper looper, int i) {
        super(looper);
        this.$r8$classId = i;
        switch (i) {
            case 2:
                super(looper);
                Looper.getMainLooper();
                return;
            default:
                Looper.getMainLooper();
                return;
        }
    }
}
