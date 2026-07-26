package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.viewpager2.widget.FakeDrag;
import java.io.File;
/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    /* JADX WARN: Type inference failed for: r7v16, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        File file;
        if (intent != null) {
            String action = intent.getAction();
            if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
                Encoding.writeProfile(context, new Object(), new FakeDrag(19, this), true);
            } else if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                    if ("WRITE_SKIP_FILE".equals(string)) {
                        FakeDrag fakeDrag = new FakeDrag(19, this);
                        try {
                            Encoding.noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                            fakeDrag.onResultReceived(10, null);
                        } catch (PackageManager.NameNotFoundException e) {
                            fakeDrag.onResultReceived(7, e);
                        }
                    } else if ("DELETE_SKIP_FILE".equals(string)) {
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        Log.d("ProfileInstaller", "RESULT_DELETE_SKIP_FILE_SUCCESS");
                        setResultCode(11);
                    }
                }
            } else if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
                FakeDrag fakeDrag2 = new FakeDrag(19, this);
                if (Build.VERSION.SDK_INT >= 24) {
                    Process.sendSignal(Process.myPid(), 10);
                    fakeDrag2.onResultReceived(12, null);
                    return;
                }
                fakeDrag2.onResultReceived(13, null);
            } else if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) && (extras = intent.getExtras()) != null) {
                String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
                FakeDrag fakeDrag3 = new FakeDrag(19, this);
                if ("DROP_SHADER_CACHE".equals(string2)) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 34) {
                        file = BenchmarkOperation$Api24ContextHelper.createDeviceProtectedStorageContext(context).getCacheDir();
                    } else if (i >= 24) {
                        file = BenchmarkOperation$Api24ContextHelper.createDeviceProtectedStorageContext(context).getCodeCacheDir();
                    } else if (i == 23) {
                        file = context.getCodeCacheDir();
                    } else {
                        file = context.getCacheDir();
                    }
                    if (Encoding.deleteFilesRecursively(file)) {
                        fakeDrag3.onResultReceived(14, null);
                    } else {
                        fakeDrag3.onResultReceived(15, null);
                    }
                } else {
                    fakeDrag3.onResultReceived(16, null);
                }
            }
        }
    }
}
