package androidx.core.content.res;

import android.app.job.JobParameters;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.res.ResourcesCompat;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
/* loaded from: classes.dex */
public final /* synthetic */ class ResourcesCompat$FontCallback$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                ((ResourcesCompat.FontCallback) obj2).onFontRetrieved((Typeface) obj);
                return;
            case 1:
                AppCompatDelegate.SerialExecutor serialExecutor = (AppCompatDelegate.SerialExecutor) obj2;
                Runnable runnable = (Runnable) obj;
                serialExecutor.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    serialExecutor.scheduleNext();
                }
            case 2:
                ConnectionsFragment.$r8$lambda$daLjhKZgCTiO8fnkCHA5vCWvRXo((ConnectionsFragment) obj2, (int[]) obj);
                return;
            default:
                int i2 = JobInfoSchedulerService.$r8$clinit;
                ((JobInfoSchedulerService) obj2).jobFinished((JobParameters) obj, false);
                return;
        }
    }
}
