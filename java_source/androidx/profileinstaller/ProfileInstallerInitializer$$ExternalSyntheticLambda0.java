package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.appcompat.app.AppCompatDelegate$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Random;
/* loaded from: classes.dex */
public final /* synthetic */ class ProfileInstallerInitializer$$ExternalSyntheticLambda0 implements Choreographer.FrameCallback {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$1;

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        Handler handler;
        switch (this.$r8$classId) {
            case 0:
                Context context = (Context) this.f$1;
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = ProfileInstallerInitializer.Handler28Impl.createAsync(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new AppCompatDelegate$$ExternalSyntheticLambda0(context, 1), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
            default:
                ((Runnable) this.f$1).run();
                return;
        }
    }
}
