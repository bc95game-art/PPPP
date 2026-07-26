package com.emanuelef.remote_capture;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.loader.app.LoaderManager;
import androidx.loader.app.LoaderManagerImpl;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import com.emanuelef.remote_capture.interfaces.AppsLoadListener;
import com.emanuelef.remote_capture.model.AppDescriptor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AppsLoader implements LoaderManager.LoaderCallbacks {
    private static final int OPERATION_LOAD_APPS_INFO = 23;
    private static final String TAG = "AppsLoader";
    private static final String TERMUX_PACKAGE = "com.termux";
    private final AppCompatActivity mContext;
    private AppsLoadListener mListener;

    public AppsLoader(AppCompatActivity appCompatActivity) {
        this.mContext = appCompatActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"QueryPermissionsNeeded"})
    public ArrayList<AppDescriptor> asyncLoadAppsInfo() {
        Integer num;
        PackageManager packageManager = this.mContext.getPackageManager();
        ArrayList<AppDescriptor> arrayList = new ArrayList<>();
        ArrayMap arrayMap = new ArrayMap();
        Log.d(TAG, "Loading APPs...");
        List<PackageInfo> installedPackages = Utils.getInstalledPackages(packageManager, 0);
        String packageName = this.mContext.getApplicationContext().getPackageName();
        Log.d(TAG, "num apps (system+user): " + installedPackages.size());
        long now = Utils.now();
        PackageInfo packageInfo = null;
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo2 = installedPackages.get(i);
            String str = packageInfo2.applicationInfo.packageName;
            if (str.equals(TERMUX_PACKAGE)) {
                packageInfo = packageInfo2;
            }
            if (!arrayMap.containsKey(Integer.valueOf(packageInfo2.applicationInfo.uid)) && !str.equals(packageName)) {
                int i2 = packageInfo2.applicationInfo.uid;
                AppDescriptor appDescriptor = new AppDescriptor(packageManager, packageInfo2);
                arrayMap.put(Integer.valueOf(i2), Integer.valueOf(arrayList.size()));
                arrayList.add(appDescriptor);
            }
        }
        if (!(packageInfo == null || (num = (Integer) arrayMap.get(Integer.valueOf(packageInfo.applicationInfo.uid))) == null)) {
            arrayList.remove(num.intValue());
            arrayList.add(new AppDescriptor(packageManager, packageInfo));
        }
        Collections.sort(arrayList);
        Log.d(TAG, installedPackages.size() + " apps loaded in " + (Utils.now() - now) + " seconds");
        return arrayList;
    }

    private void finishLoader() {
        LoaderManagerImpl.LoaderViewModel loaderViewModel = LoaderManager.getInstance(this.mContext).mLoaderViewModel;
        boolean z = loaderViewModel.mCreatingLoader;
        SparseArrayCompat sparseArrayCompat = loaderViewModel.mLoaders;
        if (z) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderManagerImpl.LoaderInfo loaderInfo = (LoaderManagerImpl.LoaderInfo) sparseArrayCompat.get(23);
            if (loaderInfo != null) {
                loaderInfo.destroy();
                int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.size, 23, sparseArrayCompat.keys);
                if (binarySearch >= 0) {
                    Object[] objArr = sparseArrayCompat.values;
                    Object obj = objArr[binarySearch];
                    Object obj2 = ArraySetKt.DELETED$1;
                    if (obj != obj2) {
                        objArr[binarySearch] = obj2;
                        sparseArrayCompat.garbage = true;
                    }
                }
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    private void runLoader(int i, ArrayList<AppDescriptor> arrayList) {
        Loader loader;
        boolean z;
        Loader loader2;
        LoaderManagerImpl loaderManager = LoaderManager.getInstance(this.mContext);
        LoaderManagerImpl.LoaderViewModel loaderViewModel = loaderManager.mLoaderViewModel;
        boolean z2 = loaderViewModel.mCreatingLoader;
        SparseArrayCompat sparseArrayCompat = loaderViewModel.mLoaders;
        if (!z2) {
            LoaderManagerImpl.LoaderInfo loaderInfo = (LoaderManagerImpl.LoaderInfo) sparseArrayCompat.get(i);
            if (loaderInfo != null) {
                loader = loaderInfo.mLoader;
            } else {
                loader = null;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("apps", arrayList);
            StringBuilder m = ViewModelProvider.Factory.CC.m("Existing loader ", i, "? ");
            if (loader != null) {
                z = true;
            } else {
                z = false;
            }
            m.append(z);
            Log.d(TAG, m.toString());
            LifecycleOwner lifecycleOwner = loaderManager.mLifecycleOwner;
            if (loaderViewModel.mCreatingLoader) {
                throw new IllegalStateException("Called while creating a loader");
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                LoaderManagerImpl.LoaderInfo loaderInfo2 = (LoaderManagerImpl.LoaderInfo) sparseArrayCompat.get(i);
                if (loaderInfo2 == null) {
                    try {
                        loaderViewModel.mCreatingLoader = true;
                        Loader onCreateLoader = onCreateLoader(i, bundle);
                        if (onCreateLoader != null) {
                            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                            }
                            LoaderManagerImpl.LoaderInfo loaderInfo3 = new LoaderManagerImpl.LoaderInfo(i, bundle, onCreateLoader);
                            sparseArrayCompat.put(i, loaderInfo3);
                            loaderViewModel.mCreatingLoader = false;
                            loader2 = loaderInfo3.mLoader;
                            LoaderManagerImpl.LoaderObserver loaderObserver = new LoaderManagerImpl.LoaderObserver(loader2, this);
                            loaderInfo3.observe(lifecycleOwner, loaderObserver);
                            LoaderManagerImpl.LoaderObserver loaderObserver2 = loaderInfo3.mObserver;
                            if (loaderObserver2 != null) {
                                loaderInfo3.removeObserver(loaderObserver2);
                            }
                            loaderInfo3.mLifecycleOwner = lifecycleOwner;
                            loaderInfo3.mObserver = loaderObserver;
                        } else {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
                        }
                    } catch (Throwable th) {
                        loaderViewModel.mCreatingLoader = false;
                        throw th;
                    }
                } else {
                    loader2 = loaderInfo2.mLoader;
                    LoaderManagerImpl.LoaderObserver loaderObserver3 = new LoaderManagerImpl.LoaderObserver(loader2, this);
                    loaderInfo2.observe(lifecycleOwner, loaderObserver3);
                    LoaderManagerImpl.LoaderObserver loaderObserver4 = loaderInfo2.mObserver;
                    if (loaderObserver4 != null) {
                        loaderInfo2.removeObserver(loaderObserver4);
                    }
                    loaderInfo2.mLifecycleOwner = lifecycleOwner;
                    loaderInfo2.mObserver = loaderObserver3;
                }
                loader2.forceLoad();
            } else {
                throw new IllegalStateException("initLoader must be called on the main thread");
            }
        } else {
            throw new IllegalStateException("Called while creating a loader");
        }
    }

    public void abort() {
        finishLoader();
    }

    public AppsLoader loadAllApps() {
        runLoader(23, null);
        return this;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader onCreateLoader(final int i, Bundle bundle) {
        return new AsyncTaskLoader(this.mContext) { // from class: com.emanuelef.remote_capture.AppsLoader.1
            @Override // androidx.loader.content.AsyncTaskLoader
            public ArrayList<AppDescriptor> loadInBackground() {
                ArrayList<AppDescriptor> arrayList = new ArrayList<>();
                if (i == 23) {
                    return AppsLoader.this.asyncLoadAppsInfo();
                }
                Log.e(AppsLoader.TAG, "unknown loader op: " + i);
                return arrayList;
            }
        };
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader loader) {
        Log.d(TAG, "onLoaderReset");
    }

    public AppsLoader setAppsLoadListener(AppsLoadListener appsLoadListener) {
        this.mListener = appsLoadListener;
        return this;
    }

    public void onLoadFinished(Loader loader, ArrayList<AppDescriptor> arrayList) {
        AppsLoadListener appsLoadListener = this.mListener;
        if (appsLoadListener != null) {
            appsLoadListener.onAppsInfoLoaded(arrayList);
        }
        finishLoader();
    }
}
