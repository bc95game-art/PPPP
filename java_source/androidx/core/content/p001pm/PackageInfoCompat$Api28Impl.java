package androidx.core.content.p001pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
/* renamed from: androidx.core.content.pm.PackageInfoCompat$Api28Impl */
/* loaded from: classes.dex */
public abstract class PackageInfoCompat$Api28Impl {
    public static Signature[] getApkContentsSigners(SigningInfo signingInfo) {
        return signingInfo.getApkContentsSigners();
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        return packageInfo.getLongVersionCode();
    }

    public static Signature[] getSigningCertificateHistory(SigningInfo signingInfo) {
        return signingInfo.getSigningCertificateHistory();
    }

    public static boolean hasMultipleSigners(SigningInfo signingInfo) {
        return signingInfo.hasMultipleSigners();
    }

    public static boolean hasSigningCertificate(PackageManager packageManager, String str, byte[] bArr, int i) {
        return packageManager.hasSigningCertificate(str, bArr, i);
    }
}
