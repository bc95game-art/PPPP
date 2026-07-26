package androidx.loader.app;

import android.os.Bundle;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.TimeUtils;
import androidx.emoji2.text.MetadataRepo;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.content.Loader;
import androidx.navigation.Navigation;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.AppsLoader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public final class LoaderManagerImpl extends LoaderManager {
    public final LifecycleOwner mLifecycleOwner;
    public final LoaderViewModel mLoaderViewModel;

    /* loaded from: classes.dex */
    public final class LoaderInfo extends MutableLiveData implements Loader.OnLoadCompleteListener {
        public final Bundle mArgs;
        public final int mId;
        public LifecycleOwner mLifecycleOwner;
        public final Loader mLoader;
        public LoaderObserver mObserver;

        public LoaderInfo(int i, Bundle bundle, Loader loader) {
            this.mId = i;
            this.mArgs = bundle;
            this.mLoader = loader;
            loader.registerListener(i, this);
        }

        public final void destroy() {
            Loader loader = this.mLoader;
            loader.cancelLoad();
            loader.abandon();
            LoaderObserver loaderObserver = this.mObserver;
            if (loaderObserver != null) {
                removeObserver(loaderObserver);
                if (loaderObserver.mDeliveredData) {
                    loaderObserver.mCallback.onLoaderReset(loaderObserver.mLoader);
                }
            }
            loader.unregisterListener(this);
            if (loaderObserver != null) {
                boolean z = loaderObserver.mDeliveredData;
            }
            loader.reset();
        }

        public final void markForRedelivery() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            LoaderObserver loaderObserver = this.mObserver;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.removeObserver(loaderObserver);
                observe(lifecycleOwner, loaderObserver);
            }
        }

        @Override // androidx.lifecycle.LiveData
        public final void onActive() {
            this.mLoader.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public final void onInactive() {
            this.mLoader.stopLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public final void removeObserver(Observer observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            TimeUtils.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public final class LoaderObserver implements Observer {
        public final AppsLoader mCallback;
        public boolean mDeliveredData = false;
        public final Loader mLoader;

        public LoaderObserver(Loader loader, AppsLoader appsLoader) {
            this.mLoader = loader;
            this.mCallback = appsLoader;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.mCallback.onLoadFinished(this.mLoader, obj);
            this.mDeliveredData = true;
        }

        public final String toString() {
            return this.mCallback.toString();
        }
    }

    /* loaded from: classes.dex */
    public class LoaderViewModel extends ViewModel {
        public static final Transition.C01101 FACTORY = new Transition.C01101(11);
        public final SparseArrayCompat mLoaders = new SparseArrayCompat(0);
        public boolean mCreatingLoader = false;

        @Override // androidx.lifecycle.ViewModel
        public final void onCleared() {
            SparseArrayCompat sparseArrayCompat = this.mLoaders;
            int size = sparseArrayCompat.size();
            for (int i = 0; i < size; i++) {
                ((LoaderInfo) sparseArrayCompat.valueAt(i)).destroy();
            }
            int i2 = sparseArrayCompat.size;
            Object[] objArr = sparseArrayCompat.values;
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = null;
            }
            sparseArrayCompat.size = 0;
            sparseArrayCompat.garbage = false;
        }
    }

    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore store) {
        this.mLifecycleOwner = lifecycleOwner;
        Intrinsics.checkNotNullParameter(store, "store");
        CreationExtras.Empty defaultCreationExtras = CreationExtras.Empty.INSTANCE;
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        MetadataRepo metadataRepo = new MetadataRepo(store, LoaderViewModel.FACTORY, defaultCreationExtras);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LoaderViewModel.class);
        String canonicalName = Navigation.getCanonicalName(orCreateKotlinClass);
        if (canonicalName != null) {
            this.mLoaderViewModel = (LoaderViewModel) metadataRepo.getViewModel$lifecycle_viewmodel_release(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        boolean z;
        SparseArrayCompat sparseArrayCompat = this.mLoaderViewModel.mLoaders;
        if (sparseArrayCompat.size() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int i = 0; i < sparseArrayCompat.size(); i++) {
                LoaderInfo loaderInfo = (LoaderInfo) sparseArrayCompat.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(sparseArrayCompat.keyAt(i));
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(loaderInfo.mId);
                printWriter.print(" mArgs=");
                printWriter.println(loaderInfo.mArgs);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                Loader loader = loaderInfo.mLoader;
                printWriter.println(loader);
                loader.dump(str2 + "  ", fileDescriptor, printWriter, strArr);
                if (loaderInfo.mObserver != null) {
                    printWriter.print(str2);
                    printWriter.print("mCallbacks=");
                    printWriter.println(loaderInfo.mObserver);
                    LoaderObserver loaderObserver = loaderInfo.mObserver;
                    loaderObserver.getClass();
                    printWriter.print(str2 + "  ");
                    printWriter.print("mDeliveredData=");
                    printWriter.println(loaderObserver.mDeliveredData);
                }
                printWriter.print(str2);
                printWriter.print("mData=");
                Object obj = loaderInfo.mData;
                if (obj == LiveData.NOT_SET) {
                    obj = null;
                }
                printWriter.println(loader.dataToString(obj));
                printWriter.print(str2);
                printWriter.print("mStarted=");
                if (loaderInfo.mActiveCount > 0) {
                    z = true;
                } else {
                    z = false;
                }
                printWriter.println(z);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        TimeUtils.buildShortClassTag(this.mLifecycleOwner, sb);
        sb.append("}}");
        return sb.toString();
    }
}
