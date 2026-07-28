package com.emanuelef.remote_capture.activities;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.Prefs;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class ErrorActivity extends AppCompatActivity {
    public void copyErrorToClipboard() {
        String errorDetails = getErrorDetails();
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(getString(C0130R.string.customactivityoncrash_error_activity_error_details_clipboard_label), errorDetails));
            Toast.makeText(this, (int) C0130R.string.customactivityoncrash_error_activity_error_details_copied, 0).show();
        }
    }

    public static String getAllErrorDetailsFromIntent(Context context, Intent intent) {
        String m = ViewModelProvider.Factory.CC.m596m(Utils.getBuildInfo(context), "\nStack trace:  \n");
        StringBuilder sb = new StringBuilder();
        sb.append(m);
        Application application = CustomActivityOnCrash.application;
        sb.append(intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE"));
        String sb2 = sb.toString();
        String stringExtra = intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_ACTIVITY_LOG");
        if (stringExtra != null) {
            sb2 = ViewModelProvider.Factory.CC.m596m(ViewModelProvider.Factory.CC.m596m(sb2, "\nUser actions: \n"), stringExtra);
        }
        return sb2 + "\n" + Prefs.asString(context);
    }

    public String getErrorDetails() {
        return getAllErrorDetailsFromIntent(this, getIntent());
    }

    public static WindowInsetsCompat lambda$onCreate$0(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = windowInsetsCompat.mImpl.getInsets(135).top;
        if (i > 0) {
            view.setPadding(0, i, 0, 0);
        }
        return WindowInsetsCompat.CONSUMED;
    }

    public /* synthetic */ void lambda$onCreate$1(Intent intent, View view) {
        intent.putExtra("android.intent.extra.TEXT", getErrorDetails());
        Utils.startActivity(this, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"PrivateResource"})
    public void onCreate(Bundle bundle) {
        Utils.enableEdgeToEdge(this);
        super.onCreate(bundle);
        View findViewById = findViewById(C0130R.C0132id.toolbar);
        if (findViewById != null) {
            BaseActivity$$ExternalSyntheticLambda0 baseActivity$$ExternalSyntheticLambda0 = new BaseActivity$$ExternalSyntheticLambda0(22);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(findViewById, baseActivity$$ExternalSyntheticLambda0);
        }
        TypedArray obtainStyledAttributes = obtainStyledAttributes(C0130R.styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(117)) {
            setTheme(2132083345);
        }
        obtainStyledAttributes.recycle();
        setContentView(C0130R.layout.error_activity);
        Button button = (Button) findViewById(C0130R.C0132id.customactivityoncrash_error_activity_restart_button);
        final CaocConfig configFromIntent = CustomActivityOnCrash.getConfigFromIntent(getIntent());
        if (configFromIntent == null) {
            finish();
            return;
        }
        if (configFromIntent.restartActivityClass != null) {
            button.setText(C0130R.string.customactivityoncrash_error_activity_restart_app);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.emanuelef.remote_capture.activities.ErrorActivity.1
                {
                    ErrorActivity.this = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CustomActivityOnCrash.restartApplication(ErrorActivity.this, configFromIntent);
                }
            });
        } else {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.emanuelef.remote_capture.activities.ErrorActivity.2
                {
                    ErrorActivity.this = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ErrorActivity errorActivity = ErrorActivity.this;
                    CaocConfig caocConfig = configFromIntent;
                    Application application = CustomActivityOnCrash.application;
                    caocConfig.getClass();
                    errorActivity.finish();
                    Process.killProcess(Process.myPid());
                    System.exit(10);
                }
            });
        }
        ((Button) findViewById(C0130R.C0132id.customactivityoncrash_error_activity_more_info_button)).setOnClickListener(new View.OnClickListener() { // from class: com.emanuelef.remote_capture.activities.ErrorActivity.3
            {
                ErrorActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                zzbv zzbvVar = new zzbv(ErrorActivity.this);
                zzbvVar.setTitle(C0130R.string.customactivityoncrash_error_activity_error_details_title);
                ((AlertController.AlertParams) zzbvVar.zza).mMessage = ErrorActivity.this.getErrorDetails();
                zzbvVar.setPositiveButton(C0130R.string.customactivityoncrash_error_activity_error_details_close, null);
                zzbvVar.setNeutralButton(C0130R.string.customactivityoncrash_error_activity_error_details_copy, new DialogInterface.OnClickListener() { // from class: com.emanuelef.remote_capture.activities.ErrorActivity.3.1
                    {
                        View$OnClickListenerC01443.this = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ErrorActivity.this.copyErrorToClipboard();
                    }
                });
                TextView textView = (TextView) zzbvVar.show().findViewById(16908299);
                if (textView != null) {
                    textView.setTextSize(0, ErrorActivity.this.getResources().getDimension(C0130R.dimen.customactivityoncrash_error_activity_error_details_text_size));
                }
            }
        });
        Button button2 = (Button) findViewById(C0130R.C0132id.report_button);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"Emanuele Faranda <black.silver@hotmail.it>"});
        intent.putExtra("android.intent.extra.SUBJECT", "PCAPdroid crash");
        if (intent.resolveActivity(getPackageManager()) != null) {
            button2.setOnClickListener(new MainActivity$$ExternalSyntheticLambda5(this, intent, 1));
        } else {
            button2.setVisibility(8);
        }
        Integer num = configFromIntent.errorDrawable;
        ImageView imageView = (ImageView) findViewById(C0130R.C0132id.customactivityoncrash_error_activity_image);
        if (num != null) {
            Resources resources = getResources();
            int intValue = num.intValue();
            Resources.Theme theme = getTheme();
            ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
            imageView.setImageDrawable(ResourcesCompat.Api21Impl.getDrawable(resources, intValue, theme));
        }
    }
}
