package cat.ereza.customactivityoncrash.activity;

import android.app.Application;
import android.os.Process;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda0;
/* loaded from: classes.dex */
public final /* synthetic */ class DefaultErrorActivity$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ DefaultErrorActivity f$0;

    public /* synthetic */ DefaultErrorActivity$$ExternalSyntheticLambda1(DefaultErrorActivity defaultErrorActivity) {
        this.f$0 = defaultErrorActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        DefaultErrorActivity defaultErrorActivity = this.f$0;
        switch (i) {
            case 0:
                int i2 = DefaultErrorActivity.$r8$clinit;
                Application application = CustomActivityOnCrash.application;
                defaultErrorActivity.finish();
                Process.killProcess(Process.myPid());
                System.exit(10);
                return;
            default:
                int i3 = DefaultErrorActivity.$r8$clinit;
                zzbv zzbvVar = new zzbv(defaultErrorActivity);
                zzbvVar.setTitle(R.string.customactivityoncrash_error_activity_error_details_title);
                ((AlertController.AlertParams) zzbvVar.zza).mMessage = CustomActivityOnCrash.getAllErrorDetailsFromIntent(defaultErrorActivity, defaultErrorActivity.getIntent());
                zzbvVar.setPositiveButton(R.string.customactivityoncrash_error_activity_error_details_close, null);
                zzbvVar.setNeutralButton(R.string.customactivityoncrash_error_activity_error_details_copy, new AppsFragment$$ExternalSyntheticLambda0(1, defaultErrorActivity));
                TextView textView = (TextView) zzbvVar.show().findViewById(16908299);
                if (textView != null) {
                    textView.setTextSize(0, defaultErrorActivity.getResources().getDimension(R.dimen.customactivityoncrash_error_activity_error_details_text_size));
                    return;
                }
                return;
        }
    }

    public /* synthetic */ DefaultErrorActivity$$ExternalSyntheticLambda1(DefaultErrorActivity defaultErrorActivity, CaocConfig caocConfig) {
        this.f$0 = defaultErrorActivity;
    }
}
