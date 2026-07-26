package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda6;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        MatcherMatchResult builder = AutoValue_TransportContext.builder();
        builder.setBackendName(string);
        builder.groups = PriorityMapping.valueOf(i);
        if (string2 != null) {
            builder.input = Base64.decode(string2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        uploader.executor.execute(new PlayBilling$$ExternalSyntheticLambda6(uploader, builder.build(), i2, new ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(this, 3, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
