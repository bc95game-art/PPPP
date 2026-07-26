package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.transition.ViewUtilsApi21;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public abstract class ProfileVerifier {
    public static final ResolvableFuture sFuture = new Object();
    public static final Object SYNC_OBJ = new Object();
    public static ViewUtilsApi21 sCompilationStatus = null;

    /* loaded from: classes.dex */
    public abstract class Api33Impl {
        public static PackageInfo getPackageInfo(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* loaded from: classes.dex */
    public final class Cache {
        public final long mInstalledCurrentProfileSize;
        public final long mPackageLastUpdateTime;
        public final int mResultCode;
        public final int mSchema;

        public Cache(int i, int i2, long j, long j2) {
            this.mSchema = i;
            this.mResultCode = i2;
            this.mPackageLastUpdateTime = j;
            this.mInstalledCurrentProfileSize = j2;
        }

        public static Cache readFromFile(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Cache)) {
                Cache cache = (Cache) obj;
                if (this.mResultCode == cache.mResultCode && this.mPackageLastUpdateTime == cache.mPackageLastUpdateTime && this.mSchema == cache.mSchema && this.mInstalledCurrentProfileSize == cache.mInstalledCurrentProfileSize) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize));
        }

        public final void writeOnFile(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.mSchema);
                dataOutputStream.writeInt(this.mResultCode);
                dataOutputStream.writeLong(this.mPackageLastUpdateTime);
                dataOutputStream.writeLong(this.mInstalledCurrentProfileSize);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static long getPackageLastUpdateTime(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getPackageInfo(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    public static ViewUtilsApi21 setCompilationStatus() {
        ?? obj = new Object();
        sCompilationStatus = obj;
        ResolvableFuture resolvableFuture = sFuture;
        resolvableFuture.getClass();
        if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(resolvableFuture, null, obj)) {
            AbstractResolvableFuture.complete(resolvableFuture);
        }
        return sCompilationStatus;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:107|46|47|(2:105|49)(1:53)|54|(9:61|(1:71)|(1:79)(1:78)|80|(2:97|84)|85|86|87|110)|(1:65)(1:(1:67))|(1:71)|(1:73)|79|80|(1:82)|97|84|85|86|87|110) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c5, code lost:
        r5 = 327680;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void writeProfileVerification(Context context, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        Cache readFromFile;
        int i;
        Cache cache;
        int i2;
        if (z || sCompilationStatus == null) {
            synchronized (SYNC_OBJ) {
                if (!z) {
                    if (sCompilationStatus != null) {
                        return;
                    }
                }
                int i3 = 0;
                try {
                    AssetFileDescriptor openFd = context.getAssets().openFd("dexopt/baseline.prof");
                    try {
                        if (openFd.getLength() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        openFd.close();
                    } catch (Throwable th) {
                        if (openFd != null) {
                            try {
                                openFd.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused) {
                    z2 = false;
                }
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 28 && i4 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    if (!file.exists() || length <= 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    if (!file2.exists() || length2 <= 0) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    try {
                        long packageLastUpdateTime = getPackageLastUpdateTime(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        if (file3.exists()) {
                            try {
                                readFromFile = Cache.readFromFile(file3);
                            } catch (IOException unused2) {
                                setCompilationStatus();
                                return;
                            }
                        } else {
                            readFromFile = null;
                        }
                        if (!(readFromFile == null || readFromFile.mPackageLastUpdateTime != packageLastUpdateTime || (i2 = readFromFile.mResultCode) == 2)) {
                            i3 = i2;
                            if (z && z4 && i3 != 1) {
                                i3 = 2;
                            }
                            if (readFromFile == null && readFromFile.mResultCode == 2 && i3 == 1 && length < readFromFile.mInstalledCurrentProfileSize) {
                                i = 3;
                            } else {
                                i = i3;
                            }
                            cache = new Cache(1, i, packageLastUpdateTime, length2);
                            if (readFromFile != null || !readFromFile.equals(cache)) {
                                cache.writeOnFile(file3);
                            }
                            setCompilationStatus();
                            return;
                        }
                        if (z3) {
                            i3 = 1;
                        } else if (z4) {
                            i3 = 2;
                        }
                        if (z) {
                            i3 = 2;
                        }
                        if (readFromFile == null) {
                        }
                        i = i3;
                        cache = new Cache(1, i, packageLastUpdateTime, length2);
                        if (readFromFile != null) {
                        }
                        cache.writeOnFile(file3);
                        setCompilationStatus();
                        return;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        setCompilationStatus();
                        return;
                    }
                }
                setCompilationStatus();
            }
        }
    }
}
