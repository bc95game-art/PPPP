package com.emanuelef.remote_capture;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertController;
import androidx.core.content.ContextCompat$Api26Impl;
import androidx.fragment.app.FragmentManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.interfaces.CaptureStartListener;
import com.emanuelef.remote_capture.model.CaptureSettings;
/* loaded from: classes.dex */
public class CaptureHelper {
    private static final String TAG = "CaptureHelper";
    private final Context mContext;
    private final ActivityResultLauncher mLauncher;
    private CaptureStartListener mListener;
    private CaptureSettings mSettings;

    public CaptureHelper(ComponentActivity componentActivity) {
        this.mContext = componentActivity;
        this.mLauncher = componentActivity.registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new PlayBilling$$ExternalSyntheticLambda4(1, this));
    }

    public void captureServiceResult(ActivityResult activityResult) {
        if (activityResult.mResultCode == -1) {
            startCaptureOk();
        } else if (this.mListener != null) {
            Utils.showToastLong(this.mContext, R.string.vpn_setup_failed, new Object[0]);
            this.mListener.onCaptureStartResult(false);
        }
    }

    public void lambda$startCapture$0(Intent intent, DialogInterface dialogInterface, int i) {
        try {
            this.mLauncher.launch(intent);
        } catch (ActivityNotFoundException unused) {
            Utils.showToastLong(this.mContext, R.string.no_intent_handler_found, new Object[0]);
            this.mListener.onCaptureStartResult(false);
        }
    }

    public /* synthetic */ void lambda$startCapture$1(DialogInterface dialogInterface) {
        Utils.showToastLong(this.mContext, R.string.vpn_setup_failed, new Object[0]);
        this.mListener.onCaptureStartResult(false);
    }

    private void startCaptureOk() {
        Intent intent = new Intent(this.mContext, CaptureService.class);
        intent.putExtra("settings", this.mSettings);
        Context context = this.mContext;
        if (Build.VERSION.SDK_INT >= 26) {
            ContextCompat$Api26Impl.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
        CaptureStartListener captureStartListener = this.mListener;
        if (captureStartListener != null) {
            captureStartListener.onCaptureStartResult(true);
        }
    }

    public void setListener(CaptureStartListener captureStartListener) {
        this.mListener = captureStartListener;
    }

    public void startCapture(CaptureSettings captureSettings) {
        Intent intent;
        if (CaptureService.isServiceActive()) {
            CaptureService.stopService();
        }
        this.mSettings = captureSettings;
        if (captureSettings.root_capture || captureSettings.readFromPcap()) {
            startCaptureOk();
            return;
        }
        try {
            intent = VpnService.prepare(this.mContext);
        } catch (RuntimeException e) {
            e.printStackTrace();
            intent = null;
        }
        if (intent == null) {
            startCaptureOk();
        } else if (this.mLauncher != null) {
            zzbv zzbvVar = new zzbv(this.mContext);
            zzbvVar.setMessage(R.string.vpn_setup_msg);
            zzbvVar.setPositiveButton(R.string.ok, new PlayBilling$$ExternalSyntheticLambda0(this, 3, intent));
            ((AlertController.AlertParams) zzbvVar.zza).mOnCancelListener = new DialogInterface.OnCancelListener() { // from class: com.emanuelef.remote_capture.CaptureHelper$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    CaptureHelper.this.lambda$startCapture$1(dialogInterface);
                }
            };
            zzbvVar.show();
        } else {
            CaptureStartListener captureStartListener = this.mListener;
            if (captureStartListener != null) {
                captureStartListener.onCaptureStartResult(false);
            }
        }
    }

    public CaptureHelper(Context context) {
        this.mContext = context;
        this.mLauncher = null;
    }
}
