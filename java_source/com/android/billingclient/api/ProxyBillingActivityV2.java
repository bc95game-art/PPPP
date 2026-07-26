package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.FragmentManager;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzc;
import kotlin.jvm.internal.Intrinsics;
@UsedByReflection("PlatformActivityProxy")
/* loaded from: classes.dex */
public class ProxyBillingActivityV2 extends ComponentActivity {
    public ActivityResultLauncher zza;
    public ActivityResultLauncher zzb;
    public ActivityResultLauncher zzc;
    public ResultReceiver zzd;
    public ResultReceiver zze;
    public ResultReceiver zzf;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zza = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(4), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.zzct
            public final /* synthetic */ ProxyBillingActivityV2 zza;

            {
                this.zza = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle bundle2;
                Bundle bundle3;
                Bundle bundle4;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (r2) {
                    case 0:
                        ProxyBillingActivityV2 proxyBillingActivityV2 = this.zza;
                        proxyBillingActivityV2.getClass();
                        Intent intent = activityResult.mData;
                        int i = zzc.zzh(intent, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.zzd;
                        if (resultReceiver != null) {
                            if (intent == null) {
                                bundle2 = null;
                            } else {
                                bundle2 = intent.getExtras();
                            }
                            resultReceiver.send(i, bundle2);
                        }
                        int i2 = activityResult.mResultCode;
                        if (!(i2 == -1 && i == 0)) {
                            zzc.zzn("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i2 + " and billing's responseCode: " + i);
                        }
                        proxyBillingActivityV2.finish();
                        return;
                    case 1:
                        ProxyBillingActivityV2 proxyBillingActivityV22 = this.zza;
                        proxyBillingActivityV22.getClass();
                        Intent intent2 = activityResult.mData;
                        int i3 = zzc.zzh(intent2, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV22.zze;
                        if (resultReceiver2 != null) {
                            if (intent2 == null) {
                                bundle3 = null;
                            } else {
                                bundle3 = intent2.getExtras();
                            }
                            resultReceiver2.send(i3, bundle3);
                        }
                        int i4 = activityResult.mResultCode;
                        if (!(i4 == -1 && i3 == 0)) {
                            zzc.zzn("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + i4 + " and billing's responseCode: " + i3);
                        }
                        proxyBillingActivityV22.finish();
                        return;
                    default:
                        ProxyBillingActivityV2 proxyBillingActivityV23 = this.zza;
                        proxyBillingActivityV23.getClass();
                        Intent intent3 = activityResult.mData;
                        int i5 = activityResult.mResultCode;
                        if (intent3 == null) {
                            bundle4 = null;
                        } else {
                            bundle4 = intent3.getExtras();
                        }
                        if (i5 != -1) {
                            if (bundle4 == null) {
                                bundle4 = new Bundle();
                            }
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow finished with resultCode: " + i5);
                            bundle4.putInt("INTERNAL_LOG_ERROR_REASON", 134);
                            bundle4.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", "External offer flow finished with error resultCode: " + i5);
                        }
                        int i6 = zzc.zzh(intent3, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver3 = proxyBillingActivityV23.zzf;
                        if (resultReceiver3 != null) {
                            resultReceiver3.send(i6, bundle4);
                        } else {
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow result receiver is null");
                        }
                        if (i6 != 0) {
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow finished with billing responseCode: " + i6);
                        }
                        proxyBillingActivityV23.finish();
                        return;
                }
            }
        });
        this.zzb = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(4), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.zzct
            public final /* synthetic */ ProxyBillingActivityV2 zza;

            {
                this.zza = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle bundle2;
                Bundle bundle3;
                Bundle bundle4;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (r2) {
                    case 0:
                        ProxyBillingActivityV2 proxyBillingActivityV2 = this.zza;
                        proxyBillingActivityV2.getClass();
                        Intent intent = activityResult.mData;
                        int i = zzc.zzh(intent, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.zzd;
                        if (resultReceiver != null) {
                            if (intent == null) {
                                bundle2 = null;
                            } else {
                                bundle2 = intent.getExtras();
                            }
                            resultReceiver.send(i, bundle2);
                        }
                        int i2 = activityResult.mResultCode;
                        if (!(i2 == -1 && i == 0)) {
                            zzc.zzn("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i2 + " and billing's responseCode: " + i);
                        }
                        proxyBillingActivityV2.finish();
                        return;
                    case 1:
                        ProxyBillingActivityV2 proxyBillingActivityV22 = this.zza;
                        proxyBillingActivityV22.getClass();
                        Intent intent2 = activityResult.mData;
                        int i3 = zzc.zzh(intent2, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV22.zze;
                        if (resultReceiver2 != null) {
                            if (intent2 == null) {
                                bundle3 = null;
                            } else {
                                bundle3 = intent2.getExtras();
                            }
                            resultReceiver2.send(i3, bundle3);
                        }
                        int i4 = activityResult.mResultCode;
                        if (!(i4 == -1 && i3 == 0)) {
                            zzc.zzn("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + i4 + " and billing's responseCode: " + i3);
                        }
                        proxyBillingActivityV22.finish();
                        return;
                    default:
                        ProxyBillingActivityV2 proxyBillingActivityV23 = this.zza;
                        proxyBillingActivityV23.getClass();
                        Intent intent3 = activityResult.mData;
                        int i5 = activityResult.mResultCode;
                        if (intent3 == null) {
                            bundle4 = null;
                        } else {
                            bundle4 = intent3.getExtras();
                        }
                        if (i5 != -1) {
                            if (bundle4 == null) {
                                bundle4 = new Bundle();
                            }
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow finished with resultCode: " + i5);
                            bundle4.putInt("INTERNAL_LOG_ERROR_REASON", 134);
                            bundle4.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", "External offer flow finished with error resultCode: " + i5);
                        }
                        int i6 = zzc.zzh(intent3, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver3 = proxyBillingActivityV23.zzf;
                        if (resultReceiver3 != null) {
                            resultReceiver3.send(i6, bundle4);
                        } else {
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow result receiver is null");
                        }
                        if (i6 != 0) {
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow finished with billing responseCode: " + i6);
                        }
                        proxyBillingActivityV23.finish();
                        return;
                }
            }
        });
        this.zzc = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(4), new ActivityResultCallback(this) { // from class: com.android.billingclient.api.zzct
            public final /* synthetic */ ProxyBillingActivityV2 zza;

            {
                this.zza = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle bundle2;
                Bundle bundle3;
                Bundle bundle4;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (r2) {
                    case 0:
                        ProxyBillingActivityV2 proxyBillingActivityV2 = this.zza;
                        proxyBillingActivityV2.getClass();
                        Intent intent = activityResult.mData;
                        int i = zzc.zzh(intent, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver = proxyBillingActivityV2.zzd;
                        if (resultReceiver != null) {
                            if (intent == null) {
                                bundle2 = null;
                            } else {
                                bundle2 = intent.getExtras();
                            }
                            resultReceiver.send(i, bundle2);
                        }
                        int i2 = activityResult.mResultCode;
                        if (!(i2 == -1 && i == 0)) {
                            zzc.zzn("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + i2 + " and billing's responseCode: " + i);
                        }
                        proxyBillingActivityV2.finish();
                        return;
                    case 1:
                        ProxyBillingActivityV2 proxyBillingActivityV22 = this.zza;
                        proxyBillingActivityV22.getClass();
                        Intent intent2 = activityResult.mData;
                        int i3 = zzc.zzh(intent2, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver2 = proxyBillingActivityV22.zze;
                        if (resultReceiver2 != null) {
                            if (intent2 == null) {
                                bundle3 = null;
                            } else {
                                bundle3 = intent2.getExtras();
                            }
                            resultReceiver2.send(i3, bundle3);
                        }
                        int i4 = activityResult.mResultCode;
                        if (!(i4 == -1 && i3 == 0)) {
                            zzc.zzn("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + i4 + " and billing's responseCode: " + i3);
                        }
                        proxyBillingActivityV22.finish();
                        return;
                    default:
                        ProxyBillingActivityV2 proxyBillingActivityV23 = this.zza;
                        proxyBillingActivityV23.getClass();
                        Intent intent3 = activityResult.mData;
                        int i5 = activityResult.mResultCode;
                        if (intent3 == null) {
                            bundle4 = null;
                        } else {
                            bundle4 = intent3.getExtras();
                        }
                        if (i5 != -1) {
                            if (bundle4 == null) {
                                bundle4 = new Bundle();
                            }
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow finished with resultCode: " + i5);
                            bundle4.putInt("INTERNAL_LOG_ERROR_REASON", 134);
                            bundle4.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", "External offer flow finished with error resultCode: " + i5);
                        }
                        int i6 = zzc.zzh(intent3, "ProxyBillingActivityV2").zza;
                        ResultReceiver resultReceiver3 = proxyBillingActivityV23.zzf;
                        if (resultReceiver3 != null) {
                            resultReceiver3.send(i6, bundle4);
                        } else {
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow result receiver is null");
                        }
                        if (i6 != 0) {
                            zzc.zzn("ProxyBillingActivityV2", "External offer flow finished with billing responseCode: " + i6);
                        }
                        proxyBillingActivityV23.finish();
                        return;
                }
            }
        });
        if (bundle == null) {
            zzc.zzm("ProxyBillingActivityV2", "Launching Play Store billing dialog");
            if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
                PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
                this.zzd = (ResultReceiver) getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
                ActivityResultLauncher activityResultLauncher = this.zza;
                Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
                IntentSender intentSender = pendingIntent.getIntentSender();
                Intrinsics.checkNotNullExpressionValue(intentSender, "pendingIntent.intentSender");
                activityResultLauncher.launch(new IntentSenderRequest(intentSender, null, 0, 0));
            } else if (getIntent().hasExtra("external_payment_dialog_pending_intent")) {
                PendingIntent pendingIntent2 = (PendingIntent) getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
                this.zze = (ResultReceiver) getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
                ActivityResultLauncher activityResultLauncher2 = this.zzb;
                Intrinsics.checkNotNullParameter(pendingIntent2, "pendingIntent");
                IntentSender intentSender2 = pendingIntent2.getIntentSender();
                Intrinsics.checkNotNullExpressionValue(intentSender2, "pendingIntent.intentSender");
                activityResultLauncher2.launch(new IntentSenderRequest(intentSender2, null, 0, 0));
            } else if (getIntent().hasExtra("external_offer_flow_pending_intent")) {
                PendingIntent pendingIntent3 = (PendingIntent) getIntent().getParcelableExtra("external_offer_flow_pending_intent");
                this.zzf = (ResultReceiver) getIntent().getParcelableExtra("external_offer_flow_result_receiver");
                ActivityResultLauncher activityResultLauncher3 = this.zzc;
                Intrinsics.checkNotNullParameter(pendingIntent3, "pendingIntent");
                IntentSender intentSender3 = pendingIntent3.getIntentSender();
                Intrinsics.checkNotNullExpressionValue(intentSender3, "pendingIntent.intentSender");
                activityResultLauncher3.launch(new IntentSenderRequest(intentSender3, null, 0, 0));
            }
        } else {
            if (bundle.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.zzd = (ResultReceiver) bundle.getParcelable("alternative_billing_only_dialog_result_receiver");
            }
            if (bundle.containsKey("external_payment_dialog_result_receiver")) {
                this.zze = (ResultReceiver) bundle.getParcelable("external_payment_dialog_result_receiver");
            }
            if (bundle.containsKey("external_offer_flow_result_receiver")) {
                this.zzf = (ResultReceiver) bundle.getParcelable("external_offer_flow_result_receiver");
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.zzd;
        if (resultReceiver != null) {
            bundle.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.zze;
        if (resultReceiver2 != null) {
            bundle.putParcelable("external_payment_dialog_result_receiver", resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.zzf;
        if (resultReceiver3 != null) {
            bundle.putParcelable("external_offer_flow_result_receiver", resultReceiver3);
        }
    }
}
