package androidx.loader.content;

import androidx.loader.content.AsyncTaskLoader;
/* loaded from: classes.dex */
public final class ModernAsyncTask$AsyncTaskResult {
    public final Object[] mData;
    public final AsyncTaskLoader.LoadTask mTask;

    public ModernAsyncTask$AsyncTaskResult(AsyncTaskLoader.LoadTask loadTask, Object... objArr) {
        this.mTask = loadTask;
        this.mData = objArr;
    }
}
