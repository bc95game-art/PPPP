package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
/* loaded from: classes.dex */
public class MutableLiveData extends LiveData {
    public final void postValue(Object obj) {
        boolean z;
        synchronized (this.mDataLock) {
            if (this.mPendingData == LiveData.NOT_SET) {
                z = true;
            } else {
                z = false;
            }
            this.mPendingData = obj;
        }
        if (z) {
            ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void setValue(Object obj) {
        LiveData.assertMainThread("setValue");
        this.mVersion++;
        this.mData = obj;
        dispatchingValue(null);
    }
}
