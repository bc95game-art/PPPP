package androidx.emoji2.text;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.transition.Transition;
/* loaded from: classes.dex */
public final class DefaultEmojiCompatConfig$DefaultEmojiCompatConfigHelper_API28 extends Transition.C01101 {
    @Override // androidx.transition.Transition.C01101
    public final Signature[] getSigningSignatures(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
