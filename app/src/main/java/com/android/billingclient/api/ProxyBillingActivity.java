package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzil;
@UsedByReflection("PlatformActivityProxy")
/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {
    public int activityCode;
    public long billingClientTransactionId;
    public ResultReceiver inAppMessageResultReceiver;
    public boolean isFlowFromFirstPartyClient;
    public boolean sendCancelledBroadcastIfFinished;
    public boolean wasServiceAutoReconnected;

    public final Intent makePurchaseUpdatedIntentWithInternalErrorReason(int i, long j) {
        Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
        makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
        makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.zza = 6;
        newBuilder.zzc = "An internal error occurred.";
        BillingResult build = newBuilder.build();
        int i2 = zzcg.$r8$clinit;
        makePurchasesUpdatedIntent.putExtra("FAILURE_LOGGING_PAYLOAD", zzcg.zzb(i, 2, build, null, zzil.zza).zzM());
        makePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
        makePurchasesUpdatedIntent.putExtra("billingClientTransactionId", j);
        makePurchasesUpdatedIntent.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
        return makePurchasesUpdatedIntent;
    }

    public final Intent makePurchasesUpdatedIntent() {
        Intent intent = new Intent("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2;
        int i3;
        int i4;
        ResultReceiver resultReceiver;
        Bundle bundle;
        super.onActivityResult(i, i2, intent);
        if (i == 100 || i == 110) {
            int i5 = zzc.zzh(intent, "ProxyBillingActivity").zza;
            if (i2 == -1) {
                if (i5 != 0) {
                    i2 = -1;
                } else {
                    i2 = -1;
                    if (intent != null) {
                        zzc.zzn("ProxyBillingActivity", "Got null data with resultCode " + i2 + "!");
                        if (i2 == -1) {
                            i3 = 113;
                        } else if (i2 == 0) {
                            i3 = 114;
                        } else if (i2 == 3) {
                            i3 = 115;
                        } else if (i2 == 4) {
                            i3 = 116;
                        } else if (i2 != 5) {
                            i3 = 117;
                        } else {
                            i3 = 118;
                        }
                        intent2 = makePurchaseUpdatedIntentWithInternalErrorReason(i3, this.billingClientTransactionId);
                    } else if (intent.getExtras() != null) {
                        String string = intent.getExtras().getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                        if (string != null) {
                            intent2 = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
                            intent2.setPackage(getApplicationContext().getPackageName());
                            intent2.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", string);
                            intent2.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                        } else {
                            Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                            makePurchasesUpdatedIntent.putExtras(intent.getExtras());
                            makePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                            intent2 = makePurchasesUpdatedIntent;
                        }
                        intent2.putExtra("billingClientTransactionId", this.billingClientTransactionId);
                        intent2.putExtra("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
                    } else {
                        zzc.zzn("ProxyBillingActivity", "Got null bundle!");
                        intent2 = makePurchaseUpdatedIntentWithInternalErrorReason(22, this.billingClientTransactionId);
                    }
                    if (i == 110) {
                        intent2.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    sendBroadcast(intent2);
                }
            }
            zzc.zzn("ProxyBillingActivity", "Activity finished with resultCode " + i2 + " and billing's responseCode: " + i5);
            if (intent != null) {
            }
            if (i == 110) {
            }
            sendBroadcast(intent2);
        } else if (i == 101) {
            if (intent == null) {
                zzc.zzn("ProxyBillingActivity", "Got null intent!");
            } else {
                int i6 = zzc.zza;
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    zzc.zzn("ProxyBillingActivity", "Unexpected null bundle received!");
                } else {
                    i4 = extras.getInt("IN_APP_MESSAGE_RESPONSE_CODE", 0);
                    resultReceiver = this.inAppMessageResultReceiver;
                    if (resultReceiver != null) {
                        if (intent == null) {
                            bundle = null;
                        } else {
                            bundle = intent.getExtras();
                        }
                        resultReceiver.send(i4, bundle);
                    }
                }
            }
            i4 = 0;
            resultReceiver = this.inAppMessageResultReceiver;
            if (resultReceiver != null) {
            }
        } else {
            zzc.zzn("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + i + "; skipping...");
        }
        this.sendCancelledBroadcastIfFinished = false;
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle == null) {
            zzc.zzm("ProxyBillingActivity", "Launching Play Store billing flow");
            this.activityCode = 100;
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
                if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                    this.isFlowFromFirstPartyClient = true;
                    this.activityCode = 110;
                }
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
                this.activityCode = 101;
            } else {
                pendingIntent = null;
            }
            if (getIntent().hasExtra("billingClientTransactionId")) {
                this.billingClientTransactionId = getIntent().getLongExtra("billingClientTransactionId", 0L);
            }
            if (getIntent().hasExtra("wasServiceAutoReconnected")) {
                this.wasServiceAutoReconnected = getIntent().getBooleanExtra("wasServiceAutoReconnected", false);
            }
            try {
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), this.activityCode, new Intent(), 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                zzc.zzo("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e);
                ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                } else {
                    Intent makePurchaseUpdatedIntentWithInternalErrorReason = makePurchaseUpdatedIntentWithInternalErrorReason(137, this.billingClientTransactionId);
                    if (this.isFlowFromFirstPartyClient) {
                        makePurchaseUpdatedIntentWithInternalErrorReason.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                    }
                    sendBroadcast(makePurchaseUpdatedIntentWithInternalErrorReason);
                }
                this.sendCancelledBroadcastIfFinished = false;
                finish();
            }
        } else {
            zzc.zzm("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("in_app_message_result_receiver")) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
            this.activityCode = bundle.getInt("activity_code", 100);
            if (bundle.containsKey("billingClientTransactionId")) {
                this.billingClientTransactionId = bundle.getLong("billingClientTransactionId");
            }
            if (bundle.containsKey("wasServiceAutoReconnected")) {
                this.wasServiceAutoReconnected = bundle.getBoolean("wasServiceAutoReconnected");
            }
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
            makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            if (this.isFlowFromFirstPartyClient) {
                makePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
            }
            int i = this.activityCode;
            if (i == 110 || i == 100) {
                makePurchasesUpdatedIntent.putExtra("INTENT_SOURCE", "LAUNCH_BILLING_FLOW");
                makePurchasesUpdatedIntent.putExtra("billingClientTransactionId", this.billingClientTransactionId);
            }
            sendBroadcast(makePurchasesUpdatedIntent);
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.inAppMessageResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
        bundle.putInt("activity_code", this.activityCode);
        bundle.putLong("billingClientTransactionId", this.billingClientTransactionId);
        bundle.putBoolean("wasServiceAutoReconnected", this.wasServiceAutoReconnected);
    }
}
