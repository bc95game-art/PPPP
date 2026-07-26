package com.emanuelef.remote_capture.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleKt;
import androidx.core.text.HtmlCompat$Api24Impl;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.CaptureService$$ExternalSyntheticLambda8;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.MitmAddon;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda23;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda24;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda3;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity implements MenuProvider {
    private static final String TAG = "AboutActivity";
    private Handler mHandler;
    private AlertDialog mLicenseDialog;
    private HttpsURLConnection mQrCon;
    private ExecutorService mQrReqExecutor;
    private boolean mDialogClosing = false;
    private long mQrStartTime = 0;
    private long mQrDeadline = 0;

    private Bitmap genQrCode(String str, String str2) {
        Math.min(Utils.getSmallerDisplayDimension(this) / 2, (int) TypedValue.applyDimension(1, 180.0f, getResources().getDisplayMetrics()));
        String deviceName = Utils.getDeviceName(this);
        if (deviceName == null) {
            deviceName = Utils.getDeviceModel();
        }
        Log.d(TAG, "QR activation URI: " + ("pcapdroid://get_license?installation_id=" + str + "&qr_request_id=" + str2 + "&device=" + Uri.encode(deviceName)));
        return null;
    }

    private void hideQrCode(View view, String str) {
        View findViewById = view.findViewById(R.id.show_qr_code);
        View findViewById2 = view.findViewById(R.id.qr_code_loading);
        View findViewById3 = view.findViewById(R.id.qr_box);
        View findViewById4 = view.findViewById(R.id.qr_info_text);
        findViewById3.setVisibility(8);
        findViewById4.setVisibility(8);
        findViewById2.setVisibility(8);
        findViewById.setVisibility(0);
        if (str != null && !this.mDialogClosing) {
            Toast.makeText(this, str, 1).show();
        }
        stopQrExecutor();
    }

    public static WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(135);
        view.setPadding(insets.left, insets.top, insets.right, 0);
        return WindowInsetsCompat.CONSUMED;
    }

    public static /* synthetic */ void lambda$onMenuItemSelected$1(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$onMenuItemSelected$2(String str, DialogInterface dialogInterface, int i) {
        Utils.copyToClipboard(this, str);
    }

    public /* synthetic */ void lambda$showLicenseDialog$3(View view, String str, View view2) {
        showQrCode(view, str);
    }

    public /* synthetic */ void lambda$showLicenseDialog$4(String str, View view) {
        Utils.shareText(this, getString(R.string.installation_id), str);
    }

    public /* synthetic */ void lambda$showLicenseDialog$5(String str, View view) {
        Utils.copyToClipboard(this, str);
    }

    public /* synthetic */ void lambda$showLicenseDialog$6(Billing billing, EditText editText, DialogInterface dialogInterface, int i) {
        boolean isPurchased = billing.isPurchased(Billing.SUPPORTER_SKU);
        billing.setLicense(editText.getText().toString());
        if (!isPurchased && billing.isPurchased(Billing.SUPPORTER_SKU)) {
            Utils.showToastLong(this, R.string.paid_features_unlocked, new Object[0]);
        }
    }

    public /* synthetic */ void lambda$showLicenseDialog$7(DialogInterface dialogInterface) {
        this.mDialogClosing = true;
        this.mLicenseDialog = null;
        stopQrExecutor();
    }

    public static /* synthetic */ void lambda$showLicenseDialog$8(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$showLicenseDialog$9(Billing billing, EditText editText, TextView textView, View view) {
        int i;
        int i2;
        boolean isValidLicense = billing.isValidLicense(editText.getText().toString());
        if (isValidLicense) {
            i = R.string.valid;
        } else {
            i = R.string.invalid;
        }
        textView.setText(i);
        if (isValidLicense) {
            i2 = R.color.ok;
        } else {
            i2 = R.color.danger;
        }
        textView.setTextColor(BundleKt.getColor(this, i2));
    }

    public /* synthetic */ void lambda$showQrCode$10(View view, int i) {
        hideQrCode(view, ViewModelProvider.Factory.CC.m(i, "QR request failed with code "));
    }

    public /* synthetic */ void lambda$showQrCode$11(View view) {
        hideQrCode(view, "Invalid QR request ID");
    }

    public /* synthetic */ void lambda$showQrCode$13(View view) {
        hideQrCode(view, getString(R.string.qr_code_expired));
    }

    public /* synthetic */ void lambda$showQrCode$15(Exception exc, View view) {
        if (exc instanceof EOFException) {
            hideQrCode(view, getString(R.string.qr_code_expired));
        } else {
            hideQrCode(view, getString(R.string.connection_error, exc.getMessage()));
        }
    }

    public /* synthetic */ void lambda$showQrCode$16(String str, Handler handler, final View view) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://pcapdroid.org/getlicense/qr_activation").openConnection();
            this.mQrCon = httpsURLConnection;
            try {
                httpsURLConnection.setRequestProperty("User-Agent", Utils.getAppVersionString());
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setAllowUserInteraction(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setConnectTimeout(5000);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpsURLConnection.getOutputStream());
                bufferedOutputStream.write(("installation_id=" + str).getBytes());
                bufferedOutputStream.close();
                int responseCode = httpsURLConnection.getResponseCode();
                Log.d(TAG, "QR HTTP response: " + responseCode);
                if (responseCode != 200) {
                    handler.post(new CaptureService$$ExternalSyntheticLambda8(this, view, responseCode));
                } else {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                    String parseSseLine = parseSseLine(bufferedReader.readLine());
                    String parseSseLine2 = parseSseLine(bufferedReader.readLine());
                    if (!(parseSseLine2 == null || parseSseLine == null)) {
                        int parseInt = Integer.parseInt(parseSseLine) * 1000;
                        final long elapsedRealtime = SystemClock.elapsedRealtime() + parseInt;
                        Log.d(TAG, "QR request_id=" + parseSseLine2 + ", timeout=" + parseInt + " ms");
                        final Bitmap genQrCode = genQrCode(str, parseSseLine2);
                        handler.post(new Runnable() { // from class: com.emanuelef.remote_capture.activities.AboutActivity$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                AboutActivity.this.lambda$showQrCode$12(view, genQrCode, elapsedRealtime);
                            }
                        });
                        String parseSseLine3 = parseSseLine(bufferedReader.readLine());
                        if (parseSseLine3 == null) {
                            handler.post(new AboutActivity$$ExternalSyntheticLambda0(this, view, 2));
                        } else {
                            handler.post(new PlayBilling$$ExternalSyntheticLambda23(view, this, parseSseLine3));
                        }
                        bufferedReader.close();
                    }
                    handler.post(new AboutActivity$$ExternalSyntheticLambda0(this, view, 1));
                    bufferedReader.close();
                }
                httpsURLConnection.disconnect();
            } catch (Throwable th) {
                httpsURLConnection.disconnect();
                throw th;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            handler.post(new PlayBilling$$ExternalSyntheticLambda23(this, e, view, 5));
        }
    }

    /* renamed from: onQrLicenseReceived */
    public void lambda$showQrCode$14(View view, String str) {
        EditText editText = (EditText) view.findViewById(R.id.license_code);
        PlayBilling newInstance = Billing.newInstance(this);
        boolean isPurchased = newInstance.isPurchased(Billing.SUPPORTER_SKU);
        if (newInstance.setLicense(str)) {
            editText.setText(str);
            Utils.showToast(this, R.string.license_activation_ok, new Object[0]);
            if (!isPurchased) {
                Utils.showToastLong(this, R.string.paid_features_unlocked, new Object[0]);
            }
            hideQrCode(view, null);
            AlertDialog alertDialog = this.mLicenseDialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
                return;
            }
            return;
        }
        hideQrCode(view, getString(R.string.invalid_license));
    }

    /* renamed from: onQrRequestReady */
    public void lambda$showQrCode$12(View view, Bitmap bitmap, long j) {
        View findViewById = view.findViewById(R.id.qr_box);
        View findViewById2 = view.findViewById(R.id.qr_code_loading);
        View findViewById3 = view.findViewById(R.id.qr_info_text);
        this.mQrStartTime = SystemClock.elapsedRealtime();
        this.mQrDeadline = j;
        lambda$updateQrProgress$17(view);
        ((ImageView) view.findViewById(R.id.qr_code)).setImageBitmap(bitmap);
        findViewById.setVisibility(0);
        findViewById3.setVisibility(0);
        findViewById2.setVisibility(8);
    }

    private String parseSseLine(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("data: ")) {
            return str.substring(6);
        }
        return str;
    }

    private void showLicenseDialog() {
        final PlayBilling newInstance = Billing.newInstance(this);
        View inflate = getLayoutInflater().inflate(R.layout.license_dialog, (ViewGroup) null);
        final String installationId = newInstance.getInstallationId();
        TextView textView = (TextView) inflate.findViewById(R.id.installation_id);
        textView.setText(installationId);
        this.mDialogClosing = false;
        inflate.findViewById(R.id.show_qr_code).setOnClickListener(new AboutActivity$$ExternalSyntheticLambda10(this, inflate, installationId, 0));
        if (Utils.isTv(this) && !newInstance.isPurchased(Billing.SUPPORTER_SKU)) {
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.activities.AboutActivity$$ExternalSyntheticLambda11
                public final /* synthetic */ AboutActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (r3) {
                        case 0:
                            this.f$0.lambda$showLicenseDialog$4(installationId, view);
                            return;
                        default:
                            this.f$0.lambda$showLicenseDialog$5(installationId, view);
                            return;
                    }
                }
            });
            showQrCode(inflate, installationId);
        }
        final TextView textView2 = (TextView) inflate.findViewById(R.id.validation_rc);
        final EditText editText = (EditText) inflate.findViewById(R.id.license_code);
        editText.setText(newInstance.getLicense());
        Utils.setTextUrls((TextView) inflate.findViewById(R.id.paid_features_msg), R.string.access_paid_features_msg, MainActivity.PAID_FEATURES_URL);
        inflate.findViewById(R.id.copy_id).setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.activities.AboutActivity$$ExternalSyntheticLambda11
            public final /* synthetic */ AboutActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$showLicenseDialog$4(installationId, view);
                        return;
                    default:
                        this.f$0.lambda$showLicenseDialog$5(installationId, view);
                        return;
                }
            }
        });
        zzbv zzbvVar = new zzbv(this);
        AlertController.AlertParams alertParams = (AlertController.AlertParams) zzbvVar.zza;
        alertParams.mView = inflate;
        zzbvVar.setPositiveButton(R.string.ok, new PlayBilling$$ExternalSyntheticLambda24(this, newInstance, editText));
        alertParams.mOnDismissListener = new AppSelectDialog$$ExternalSyntheticLambda3(1, this);
        zzbvVar.setNeutralButton(R.string.validate, new Blocklist$$ExternalSyntheticLambda0(1));
        AlertDialog create = zzbvVar.create();
        this.mLicenseDialog = create;
        create.show();
        this.mLicenseDialog.getButton(-3).setOnClickListener(new View.OnClickListener() { // from class: com.emanuelef.remote_capture.activities.AboutActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutActivity.this.lambda$showLicenseDialog$9(newInstance, editText, textView2, view);
            }
        });
        this.mLicenseDialog.getWindow().setLayout(-1, -2);
    }

    private void showQrCode(final View view, final String str) {
        View findViewById = view.findViewById(R.id.qr_box);
        View findViewById2 = view.findViewById(R.id.qr_code_loading);
        View findViewById3 = view.findViewById(R.id.show_qr_code);
        View findViewById4 = view.findViewById(R.id.qr_info_text);
        findViewById3.setVisibility(8);
        findViewById2.setVisibility(0);
        findViewById.setVisibility(8);
        findViewById4.setVisibility(8);
        this.mQrReqExecutor = Executors.newSingleThreadExecutor();
        final Handler handler = new Handler(Looper.getMainLooper());
        this.mQrReqExecutor.execute(new Runnable() { // from class: com.emanuelef.remote_capture.activities.AboutActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                AboutActivity.this.lambda$showQrCode$16(str, handler, view);
            }
        });
    }

    private void stopQrExecutor() {
        HttpsURLConnection httpsURLConnection = this.mQrCon;
        if (httpsURLConnection != null) {
            httpsURLConnection.disconnect();
        }
        this.mQrCon = null;
        ExecutorService executorService = this.mQrReqExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        this.mQrReqExecutor = null;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* renamed from: updateQrProgress */
    public void lambda$updateQrProgress$17(View view) {
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.qr_remaining_time);
        if (progressBar != null) {
            progressBar.setProgress(100 - Math.min((int) (((SystemClock.elapsedRealtime() - this.mQrStartTime) * 100) / (this.mQrDeadline - this.mQrStartTime)), 100));
            this.mHandler.postDelayed(new AboutActivity$$ExternalSyntheticLambda0(this, view, 0), 1000L);
        }
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        Spanned spanned;
        super.onCreate(bundle);
        setTitle(R.string.about);
        setContentView(R.layout.about_activity);
        addMenuProvider(this);
        View findViewById = findViewById(R.id.scrollView);
        BaseActivity$$ExternalSyntheticLambda0 baseActivity$$ExternalSyntheticLambda0 = new BaseActivity$$ExternalSyntheticLambda0(20);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(findViewById, baseActivity$$ExternalSyntheticLambda0);
        this.mHandler = new Handler(Looper.getMainLooper());
        ((TextView) findViewById(R.id.app_version)).setText("PCAPdroid " + Utils.getAppVersion(this));
        ((TextView) findViewById(R.id.app_license)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) findViewById(R.id.opensource_licenses)).setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView = (TextView) findViewById(R.id.wireshark_licenses);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        if (PCAPdroid.getInstance().isUsharkAvailable()) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = (TextView) findViewById(R.id.app_source_link);
        String m = ViewModelProvider.Factory.CC.m("<a href='https://github.com/emanuele-f/PCAPdroid'>", textView2.getText().toString(), "</a>");
        if (Build.VERSION.SDK_INT >= 24) {
            spanned = HtmlCompat$Api24Impl.fromHtml(m, 0);
        } else {
            spanned = Html.fromHtml(m);
        }
        textView2.setText(spanned);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.about_menu, menu);
        if (Billing.newInstance(this).isPlayStore()) {
            menu.findItem(R.id.paid_features).setVisible(false);
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        String str;
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        LinkProperties linkProperties;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.paid_features) {
            showLicenseDialog();
            return true;
        } else if (itemId == R.id.on_boarding) {
            Intent intent = new Intent(this, OnBoardingActivity.class);
            intent.putExtra(OnBoardingActivity.ENABLE_BACK_BUTTON, true);
            startActivity(intent);
            return true;
        } else if (itemId != R.id.build_info) {
            return false;
        } else {
            String str2 = Utils.getBuildInfo(this) + "\n\n" + Prefs.asString(this);
            Utils.PrivateDnsMode privateDnsMode = CaptureService.getPrivateDnsMode();
            if (privateDnsMode == null && Build.VERSION.SDK_INT >= 28 && (activeNetwork = (connectivityManager = (ConnectivityManager) getSystemService("connectivity")).getActiveNetwork()) != null && (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) != null) {
                privateDnsMode = Utils.getPrivateDnsMode(linkProperties);
            }
            if (privateDnsMode != null) {
                str2 = str2 + "\nPrivateDnsMode: " + privateDnsMode;
            }
            String installedVersionName = MitmAddon.getInstalledVersionName(this);
            if (!installedVersionName.isEmpty()) {
                String str3 = str2 + "\nMitmAddonVersion: " + installedVersionName;
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append("\nMitmBatteryOptimized: ");
                if (MitmAddon.isDozeEnabled(this)) {
                    str = "true";
                } else {
                    str = "false";
                }
                sb.append(str);
                str2 = sb.toString();
            }
            View inflate = LayoutInflater.from(this).inflate(R.layout.scrollable_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.text)).setText(str2);
            zzbv zzbvVar = new zzbv(this);
            zzbvVar.setTitle(R.string.build_info);
            ((AlertController.AlertParams) zzbvVar.zza).mView = inflate;
            zzbvVar.setPositiveButton(R.string.ok, new Blocklist$$ExternalSyntheticLambda0(2));
            zzbvVar.setNeutralButton(R.string.copy_to_clipboard, new AboutActivity$$ExternalSyntheticLambda2(this, 0, str2));
            zzbvVar.show();
            return true;
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        stopQrExecutor();
        super.onStop();
    }
}
