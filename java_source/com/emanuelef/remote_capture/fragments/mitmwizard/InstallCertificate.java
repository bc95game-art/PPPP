package com.emanuelef.remote_capture.fragments.mitmwizard;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.security.KeyChain;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.MitmAddon;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.interfaces.MitmListener;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.pcapdroid.mitm.MitmAPI;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
/* loaded from: classes.dex */
public class InstallCertificate extends StepFragment implements MitmListener {
    private static final String TAG = "InstallCertificate";
    private final ActivityResultLauncher certExportLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new ActivityResultCallback(this) { // from class: com.emanuelef.remote_capture.fragments.mitmwizard.InstallCertificate$$ExternalSyntheticLambda0
        public final /* synthetic */ InstallCertificate f$0;

        {
            this.f$0 = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            switch (r2) {
                case 0:
                    this.f$0.certExportResult((ActivityResult) obj);
                    return;
                default:
                    this.f$0.certInstallResult((ActivityResult) obj);
                    return;
            }
        }
    });
    private final ActivityResultLauncher certInstallLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new ActivityResultCallback(this) { // from class: com.emanuelef.remote_capture.fragments.mitmwizard.InstallCertificate$$ExternalSyntheticLambda0
        public final /* synthetic */ InstallCertificate f$0;

        {
            this.f$0 = this;
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            switch (r2) {
                case 0:
                    this.f$0.certExportResult((ActivityResult) obj);
                    return;
                default:
                    this.f$0.certInstallResult((ActivityResult) obj);
                    return;
            }
        }
    });
    private MitmAddon mAddon;
    private X509Certificate mCaCert;
    private String mCaPem;
    private boolean mFallbackExport;

    private boolean canInstallCertViaIntent() {
        if (Build.VERSION.SDK_INT >= 30 || this.mFallbackExport) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void certExportResult(ActivityResult activityResult) {
        boolean z;
        IOException e;
        int i = activityResult.mResultCode;
        Intent intent = activityResult.mData;
        if (i == -1 && intent != null) {
            Context requireContext = requireContext();
            try {
                PrintWriter printWriter = new PrintWriter(requireContext.getContentResolver().openOutputStream(intent.getData(), "rwt"));
                printWriter.print(this.mCaPem);
                z = true;
                try {
                    printWriter.close();
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (!z) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
            }
            if (!z) {
                Utils.showToastLong(requireContext, C0130R.string.cert_exported_now_installed, new Object[0]);
            }
        }
    }

    private void certFail() {
        this.mStepLabel.setText(C0130R.string.ca_cert_export_failed);
        Utils.setTextUrls(this.mStepLabel, C0130R.string.ca_cert_export_failed, "https://dontkillmyapp.com/xiaomi#app-battery-saver");
        this.mStepIcon.setColorFilter(this.mDangerColor);
        MitmAddon.setDecryptionSetupDone(requireContext(), false);
    }

    public void certInstallResult(ActivityResult activityResult) {
        if (activityResult.mResultCode != -1 || !Utils.isCAInstalled(this.mCaCert)) {
            fallbackToCertExport();
        } else {
            certOk();
        }
    }

    private void certOk() {
        this.mStepLabel.setText(C0130R.string.cert_installed_correctly);
        MitmAddon.setCAInstallationSkipped(requireContext(), false);
        nextStep(C0130R.C0132id.navto_done);
    }

    private void exportCaCertificate() {
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("application/x-x509-ca-cert");
        intent.putExtra("android.intent.extra.TITLE", "PCAPdroid_CA.crt");
        if (!Utils.launchFileDialog(requireContext(), intent, this.certExportLauncher)) {
            certFail();
        }
    }

    private void fallbackToCertExport() {
        this.mFallbackExport = true;
        onMitmGetCaCertificateResult(this.mCaPem);
    }

    private void installCaCertificate() {
        Intent createInstallIntent = KeyChain.createInstallIntent();
        createInstallIntent.putExtra("name", "PCAPdroid CA");
        createInstallIntent.putExtra("CERT", this.mCaPem.getBytes(StandardCharsets.UTF_8));
        try {
            this.certInstallLauncher.launch(createInstallIntent);
        } catch (ActivityNotFoundException unused) {
            Utils.showToastLong(requireContext(), C0130R.string.no_intent_handler_found, new Object[0]);
            fallbackToCertExport();
        }
    }

    public /* synthetic */ void lambda$onMitmGetCaCertificateResult$5(View view) {
        if (canInstallCertViaIntent()) {
            installCaCertificate();
        } else {
            exportCaCertificate();
        }
    }

    public /* synthetic */ void lambda$onResume$3(DialogInterface dialogInterface, int i) {
        Toast.makeText(requireContext(), "addon connect failed", 1).show();
        certFail();
    }

    public /* synthetic */ void lambda$onResume$4(DialogInterface dialogInterface, int i) {
        Context requireContext = requireContext();
        Intent launchIntentForPackage = requireContext.getPackageManager().getLaunchIntentForPackage(MitmAPI.PACKAGE_NAME);
        if (launchIntentForPackage != null) {
            Utils.startActivity(requireContext, launchIntentForPackage);
            return;
        }
        Toast.makeText(requireContext(), "addon connect failed", 1).show();
        certFail();
    }

    public static /* synthetic */ void lambda$onViewCreated$0(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$onViewCreated$1(DialogInterface dialogInterface, int i) {
        MitmAddon.setCAInstallationSkipped(requireContext(), true);
        gotoStep(C0130R.C0132id.navto_done);
    }

    public /* synthetic */ void lambda$onViewCreated$2(View view) {
        zzbv zzbvVar = new zzbv(view.getContext());
        zzbvVar.setTitle(C0130R.string.warning);
        zzbvVar.setMessage(C0130R.string.mitm_skip_notice);
        zzbvVar.setNegativeButton(C0130R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(20));
        zzbvVar.setPositiveButton(C0130R.string.app_intro_skip_button, new InstallCertificate$$ExternalSyntheticLambda2(this, 2));
        zzbvVar.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mAddon.disconnect();
        super.onDestroyView();
    }

    @Override // com.emanuelef.remote_capture.interfaces.MitmListener
    public void onMitmGetCaCertificateResult(String str) {
        int i;
        this.mAddon.disconnect();
        Context context = getContext();
        if (context == null) {
            Log.m587d(TAG, "null context");
            return;
        }
        this.mCaPem = str;
        Button button = this.mStepButton;
        if (canInstallCertViaIntent()) {
            i = C0130R.string.install_action;
        } else {
            i = C0130R.string.export_action;
        }
        button.setText(i);
        if (this.mCaPem != null) {
            Log.m587d(TAG, "Got certificate");
            X509Certificate x509FromPem = Utils.x509FromPem(this.mCaPem);
            this.mCaCert = x509FromPem;
            if (x509FromPem == null) {
                Toast.makeText(context, "addon did not return certificate", 1).show();
                certFail();
            } else if (Utils.isCAInstalled(x509FromPem)) {
                certOk();
            } else {
                MitmAddon.setDecryptionSetupDone(context, false);
                this.mStepIcon.setColorFilter(this.mWarnColor);
                this.mStepButton.setEnabled(true);
                if (canInstallCertViaIntent()) {
                    this.mStepLabel.setText(C0130R.string.install_ca_certificate);
                } else {
                    this.mStepLabel.setText(C0130R.string.export_ca_certificate);
                }
                this.mStepButton.setOnClickListener(new InstallCertificate$$ExternalSyntheticLambda6(this, 0));
            }
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.MitmListener
    public void onMitmServiceConnect() {
        Context context = getContext();
        if (context != null && !this.mAddon.requestCaCertificate()) {
            Toast.makeText(context, "requestCaCertificate failed", 1).show();
            certFail();
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.MitmListener
    public void onMitmServiceDisconnect() {
        Context context = getContext();
        if (context != null && this.mCaPem == null) {
            Toast.makeText(context, "addon disconnected", 1).show();
            certFail();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        if (Utils.isCAInstalled(this.mCaCert)) {
            certOk();
        } else if (!this.mAddon.isConnected() && !this.mAddon.connect(0)) {
            zzbv zzbvVar = new zzbv(requireContext());
            zzbvVar.setTitle(C0130R.string.error);
            zzbvVar.setMessage(C0130R.string.mitm_addon_autostart_workaround);
            zzbvVar.setNegativeButton(C0130R.string.no, new InstallCertificate$$ExternalSyntheticLambda2(this, 0));
            zzbvVar.setPositiveButton(C0130R.string.yes, new InstallCertificate$$ExternalSyntheticLambda2(this, 1));
            zzbvVar.show();
        }
        super.onResume();
    }

    @Override // com.emanuelef.remote_capture.fragments.mitmwizard.StepFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i;
        super.onViewCreated(view, bundle);
        this.mStepLabel.setText(C0130R.string.checking_the_certificate);
        Button button = this.mStepButton;
        if (canInstallCertViaIntent()) {
            i = C0130R.string.install_action;
        } else {
            i = C0130R.string.export_action;
        }
        button.setText(i);
        this.mStepButton.setEnabled(false);
        showSkipButton(new InstallCertificate$$ExternalSyntheticLambda6(this, 1));
        this.mAddon = new MitmAddon(requireContext(), this);
    }
}
