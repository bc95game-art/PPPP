package com.emanuelef.remote_capture;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.collection.ArraySet;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.Transition;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientImpl;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryProductDetailsResult;
import com.android.billingclient.api.zzaw;
import com.android.billingclient.api.zzbv;
import com.android.billingclient.api.zzce;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.SkusAvailability;
import com.google.android.gms.internal.play_billing.zzbr;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.gms.tasks.zzi;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PlayBilling extends Billing implements BillingClientStateListener, PurchasesUpdatedListener, ProductDetailsResponseListener {
    private static final String LICENSE_GEN_URL = "https://pcapdroid.org/getlicense";
    private static final String PREF_LAST_UNLOCK_TOKEN = "unlock_token";
    public static final String TAG = "PlayBilling";
    private static boolean mPendingNoticeShown = false;
    private static Utils.BuildType mVerifiedBuildType;
    private BillingClient mBillingClient;
    private PurchaseReadyListener mListener;
    private QrActivationRequest mPendingQrRequest;
    private ExecutorService mQrActivationExecutor;
    private Thread mRequestTokenThread = null;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ArrayMap<String, ProductDetails> mDetails = new ArrayMap<>();
    private final ArrayMap<String, String> mSkuToPurchToken = new ArrayMap<>();
    private final SkusAvailability mAvailability = SkusAvailability.load(this.mPrefs);
    private boolean mWaitingStart = false;

    /* loaded from: classes.dex */
    public static class QrActivationRequest {
        public String device_name;
        public String installation_id;
        public String qr_request_id;

        public boolean isValid() {
            if (this.installation_id == null || this.qr_request_id == null || this.device_name == null) {
                return false;
            }
            return true;
        }
    }

    public PlayBilling(Context context) {
        super(context);
    }

    private static String billingResult2Str(BillingResult billingResult) {
        return billingResult.zza + "/" + billingResult.zzb + " " + billingResult.zzc;
    }

    public /* synthetic */ void lambda$consumePurchase$13() {
        Toast.makeText(this.mContext, "Purchase token not found", 0).show();
    }

    public static /* synthetic */ void lambda$consumePurchase$14(BillingResult billingResult, String str) {
        Log.d(TAG, "consumeAsync response: " + billingResult2Str(billingResult));
    }

    public /* synthetic */ void lambda$disconnectBilling$12() {
        BillingClient billingClient = this.mBillingClient;
        if (billingClient != null) {
            billingClient.endConnection();
            this.mBillingClient = null;
        }
        ExecutorService executorService = this.mQrActivationExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mQrActivationExecutor = null;
        }
    }

    public /* synthetic */ void lambda$onBillingServiceDisconnected$11() {
        BillingClient billingClient = this.mBillingClient;
        if (billingClient != null) {
            billingClient.startConnection(this);
        }
    }

    public /* synthetic */ void lambda$onProductDetailsResponse$10(BillingResult billingResult, List list) {
        Log.d(TAG, "queryPurchasesAsync: " + billingResult2Str(billingResult));
        processPurchases(billingResult, list, true);
    }

    public /* synthetic */ void lambda$onPurchasesError$9() {
        PurchaseReadyListener purchaseReadyListener = this.mListener;
        if (purchaseReadyListener != null) {
            purchaseReadyListener.onPurchasesError();
        }
    }

    public /* synthetic */ void lambda$performQrActivation$29(QrActivationRequest qrActivationRequest, String str, DialogInterface dialogInterface, int i) {
        startQrActivation(qrActivationRequest, str);
    }

    public static /* synthetic */ void lambda$performQrActivation$30(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$performQrActivation$31(QrActivationRequest qrActivationRequest, Activity activity, DialogInterface dialogInterface, int i) {
        this.mPendingQrRequest = qrActivationRequest;
        purchase(activity, Billing.UNLOCK_TOKEN_SKU);
    }

    public static /* synthetic */ void lambda$performQrActivation$32(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$processPurchases$0() {
        Utils.showToastLong(this.mContext, C0130R.string.pending_transaction, new Object[0]);
    }

    public /* synthetic */ void lambda$processPurchases$1(String str) {
        PurchaseReadyListener purchaseReadyListener = this.mListener;
        if (purchaseReadyListener != null) {
            purchaseReadyListener.onSKUStateUpdate(str, 2);
        }
    }

    public /* synthetic */ void lambda$processPurchases$2(Purchase purchase) {
        requestUnlockToken(purchase.getPurchaseToken());
    }

    public /* synthetic */ void lambda$processPurchases$3() {
        Utils.showToast(this.mContext, C0130R.string.requesting_unlock_token, new Object[0]);
    }

    public /* synthetic */ void lambda$processPurchases$4() {
        Utils.showToastLong(this.mContext, C0130R.string.can_use_purchased_feature, new Object[0]);
    }

    public /* synthetic */ void lambda$processPurchases$5(String str) {
        PurchaseReadyListener purchaseReadyListener = this.mListener;
        if (purchaseReadyListener != null) {
            purchaseReadyListener.onSKUStateUpdate(str, 1);
        }
    }

    public static /* synthetic */ void lambda$processPurchases$6(BillingResult billingResult) {
        Log.d(TAG, "acknowledgePurchase: " + billingResult2Str(billingResult));
    }

    public /* synthetic */ void lambda$processPurchases$7(String str) {
        PurchaseReadyListener purchaseReadyListener = this.mListener;
        if (purchaseReadyListener != null) {
            purchaseReadyListener.onSKUStateUpdate(str, 0);
        }
    }

    public /* synthetic */ void lambda$processPurchases$8() {
        PurchaseReadyListener purchaseReadyListener = this.mListener;
        if (purchaseReadyListener != null) {
            purchaseReadyListener.onPurchasesReady();
        }
    }

    public /* synthetic */ void lambda$purchase$15() {
        Utils.showToast(this.mContext, C0130R.string.billing_connecting, new Object[0]);
    }

    public /* synthetic */ void lambda$purchase$16() {
        Utils.showToast(this.mContext, C0130R.string.feature_not_available, new Object[0]);
    }

    public /* synthetic */ void lambda$requestQrLicenseCode$23(String str, DialogInterface dialogInterface, int i) {
        Utils.copyToClipboard(this.mContext, str);
    }

    public static /* synthetic */ void lambda$requestQrLicenseCode$24(DialogInterface dialogInterface, int i) {
    }

    public void lambda$requestQrLicenseCode$25(String str) {
        zzbv zzbvVar = new zzbv(this.mContext);
        zzbvVar.setTitle(C0130R.string.error);
        AlertController.AlertParams alertParams = (AlertController.AlertParams) zzbvVar.zza;
        alertParams.mMessage = str;
        alertParams.mCancelable = true;
        zzbvVar.setNeutralButton(C0130R.string.copy_to_clipboard, new PlayBilling$$ExternalSyntheticLambda0(this, 0, str));
        zzbvVar.setPositiveButton(C0130R.string.ok, new Utils$$ExternalSyntheticLambda1(2));
        AlertDialog create = zzbvVar.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    public /* synthetic */ void lambda$requestQrLicenseCode$26() {
        Utils.showToastLong(this.mContext, C0130R.string.license_service_unavailable, new Object[0]);
    }

    public /* synthetic */ void lambda$requestUnlockToken$17(String str, DialogInterface dialogInterface, int i) {
        Utils.copyToClipboard(this.mContext, str);
    }

    public static /* synthetic */ void lambda$requestUnlockToken$18(DialogInterface dialogInterface, int i) {
    }

    public void lambda$requestUnlockToken$19(int i, String str, String str2) {
        String str3 = this.mContext.getString(C0130R.string.unlock_token_error, Integer.valueOf(i), str) + "\n\nPurchase Token:" + str2;
        zzbv zzbvVar = new zzbv(this.mContext);
        zzbvVar.setTitle(C0130R.string.error);
        AlertController.AlertParams alertParams = (AlertController.AlertParams) zzbvVar.zza;
        alertParams.mMessage = str3;
        alertParams.mCancelable = true;
        zzbvVar.setNeutralButton(C0130R.string.copy_to_clipboard, new PlayBilling$$ExternalSyntheticLambda0(this, 2, str3));
        zzbvVar.setPositiveButton(C0130R.string.ok, new Utils$$ExternalSyntheticLambda1(5));
        AlertDialog create = zzbvVar.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    public /* synthetic */ void lambda$requestUnlockToken$20(String str) {
        PurchaseReadyListener purchaseReadyListener = this.mListener;
        if (purchaseReadyListener != null) {
            purchaseReadyListener.onSKUStateUpdate(Billing.UNLOCK_TOKEN_SKU, 0);
        }
        this.mPrefs.edit().putString(PREF_LAST_UNLOCK_TOKEN, str).apply();
        QrActivationRequest qrActivationRequest = this.mPendingQrRequest;
        if (qrActivationRequest != null) {
            startQrActivation(qrActivationRequest, str);
        } else {
            showUnlockToken();
        }
    }

    public void lambda$requestUnlockToken$21(String str, BillingResult billingResult, String str2) {
        Log.d(TAG, "consumeAsync[unlockToken] response: " + billingResult2Str(billingResult));
        if (billingResult.zza == 0) {
            this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda2(this, str, 0));
        }
    }

    public /* synthetic */ void lambda$requestUnlockToken$22() {
        Utils.showToastLong(this.mContext, C0130R.string.license_service_unavailable, new Object[0]);
    }

    public static /* synthetic */ void lambda$showUnlockToken$33(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$showUnlockToken$34(String str, DialogInterface dialogInterface, int i) {
        Utils.copyToClipboard(this.mContext, str);
    }

    public /* synthetic */ void lambda$startQrActivation$27() {
        Utils.showToast(this.mContext, C0130R.string.license_activation_ok, new Object[0]);
        if (this.mPendingQrRequest != null) {
            showUnlockToken();
        }
    }

    public /* synthetic */ void lambda$startQrActivation$28(String str, QrActivationRequest qrActivationRequest) {
        if (requestQrLicenseCode(str, qrActivationRequest.installation_id, qrActivationRequest.qr_request_id)) {
            this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 9));
        }
    }

    private void onPurchasesError(BillingResult billingResult) {
        Log.e(TAG, "Billing returned error " + billingResult + ", disconnecting");
        this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 10));
        disconnectBilling();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [com.android.billingclient.api.ConsumeParams, java.lang.Object] */
    private void processPurchases(BillingResult billingResult, List<Purchase> list, boolean z) {
        String str;
        int i;
        char c;
        if (billingResult.zza == 0 && list != null) {
            ArraySet arraySet = new ArraySet(0);
            this.mSkuToPurchToken.clear();
            Iterator<Purchase> it = list.iterator();
            boolean z2 = true;
            while (it.hasNext()) {
                Purchase next = it.next();
                next.getClass();
                JSONObject jSONObject = next.zzc;
                ArrayList arrayList = new ArrayList();
                if (jSONObject.has("productIds")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("productIds");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.optString(i2));
                        }
                    }
                } else if (jSONObject.has("productId")) {
                    arrayList.add(jSONObject.optString("productId"));
                }
                int size = arrayList.size();
                boolean z3 = false;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    String str2 = (String) obj;
                    StringBuilder m = ViewModelProvider.Factory.CC.m594m("\tPurchase: ", str2, " -> ");
                    Iterator<Purchase> it2 = it;
                    boolean z4 = z2;
                    ArrayList arrayList2 = arrayList;
                    if (jSONObject.optInt("purchaseState", 1) != 4) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    m.append(purchstate2Str(i));
                    Log.d(TAG, m.toString());
                    if (jSONObject.optInt("purchaseState", 1) != 4) {
                        c = 1;
                    } else {
                        c = 2;
                    }
                    if (c != 1) {
                        if (c == 2) {
                            if (!mPendingNoticeShown) {
                                this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 12));
                                mPendingNoticeShown = true;
                            }
                            if (!this.mWaitingStart) {
                                this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda2(this, str2, 1));
                            }
                        }
                        z2 = z4;
                    } else {
                        if (str2.equals(Billing.UNLOCK_TOKEN_SKU)) {
                            StringBuilder sb = new StringBuilder("Purchased unlock token: ");
                            sb.append(next.getPurchaseToken());
                            sb.append(" - ");
                            String optString = jSONObject.optString("orderId");
                            if (TextUtils.isEmpty(optString)) {
                                optString = null;
                            }
                            sb.append(optString);
                            Log.d(TAG, sb.toString());
                            if (this.mRequestTokenThread == null) {
                                Thread thread = new Thread(new Utils$$ExternalSyntheticLambda3(this, 4, next), "RequestUnlockToken");
                                this.mRequestTokenThread = thread;
                                thread.start();
                                this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 1));
                            }
                        } else if (!isPurchased(str2) && setPurchased(str2, true)) {
                            Log.d(TAG, "New purchase: ".concat(str2));
                            if (z4) {
                                this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 2));
                                z2 = false;
                            } else {
                                z2 = z4;
                            }
                            if (!this.mWaitingStart) {
                                this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda2(this, str2, 2));
                            }
                            z3 = true;
                            this.mSkuToPurchToken.put(str2, next.getPurchaseToken());
                            arraySet.add(str2);
                        }
                        z2 = z4;
                        this.mSkuToPurchToken.put(str2, next.getPurchaseToken());
                        arraySet.add(str2);
                    }
                    it = it2;
                    arrayList = arrayList2;
                }
                Iterator<Purchase> it3 = it;
                boolean z5 = z2;
                if (z3 && !jSONObject.optBoolean("acknowledged", true)) {
                    StringBuilder sb2 = new StringBuilder("Calling acknowledgePurchase on order ");
                    String optString2 = jSONObject.optString("orderId");
                    if (TextUtils.isEmpty(optString2)) {
                        str = null;
                    } else {
                        str = optString2;
                    }
                    sb2.append(str);
                    Log.d(TAG, sb2.toString());
                    String purchaseToken = next.getPurchaseToken();
                    if (purchaseToken != null) {
                        ?? obj2 = new Object();
                        obj2.zza = purchaseToken;
                        BillingClient billingClient = this.mBillingClient;
                        if (billingClient != 0) {
                            billingClient.acknowledgePurchase(obj2, new PlayBilling$$ExternalSyntheticLambda15(0));
                        }
                    } else {
                        throw new IllegalArgumentException("Purchase token must be set");
                    }
                }
                it = it3;
                z2 = z5;
            }
            if (z) {
                for (String str3 : Billing.ALL_SKUS) {
                    if (!arraySet.contains(str3) && isPurchased(str3)) {
                        Log.w(TAG, "Previously purchased SKU " + str3 + " was voided");
                        if (setPurchased(str3, false) && !this.mWaitingStart) {
                            this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda2(this, str3, 3));
                        }
                    }
                }
            }
        }
        if (this.mWaitingStart) {
            if (billingResult.zza == 0) {
                this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 3));
            } else {
                onPurchasesError(billingResult);
            }
            this.mWaitingStart = false;
        }
    }

    public static String purchstate2Str(int i) {
        if (i == 0) {
            return "UNSPECIFIED";
        }
        if (i == 1) {
            return "PURCHASED";
        }
        if (i != 2) {
            return "UNKNOWN";
        }
        return "PENDING";
    }

    private boolean requestQrLicenseCode(String str, String str2, String str3) {
        String str4;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://pcapdroid.org/getlicense/").openConnection();
            httpURLConnection.setRequestProperty("Connection", "Close");
            httpURLConnection.setRequestProperty("User-Agent", Utils.getAppVersionString());
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(5000);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(("unlock_token=" + str + "&installation_id=" + str2 + "&qr_request_id=" + str3).getBytes());
            bufferedOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            Log.d(TAG, "requestQrLicenseCode: " + responseCode);
            if (!(responseCode == 302 || responseCode == 200)) {
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), StandardCharsets.UTF_8));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                Log.i(TAG, "requestQrLicenseCode failure: " + sb2);
                if (responseCode == 402) {
                    str4 = this.mContext.getString(C0130R.string.license_limit_reached);
                } else if (responseCode == 410) {
                    str4 = this.mContext.getString(C0130R.string.qr_code_expired);
                } else {
                    str4 = this.mContext.getString(C0130R.string.license_error, Integer.valueOf(responseCode), sb2);
                }
                this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda2(this, str4, 4));
                httpURLConnection.disconnect();
                return false;
            }
            httpURLConnection.disconnect();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 5));
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.android.billingclient.api.ConsumeParams, java.lang.Object] */
    private void requestUnlockToken(String str) {
        InputStream inputStream;
        if (this.mBillingClient == null) {
            Log.e(TAG, "Billing disconnected, requesting an unlock token cannot proceed");
            return;
        }
        Log.i(TAG, "Requesting an unlock token...");
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://pcapdroid.org/getlicense/token?purchase_token=" + URLEncoder.encode(str, StandardCharsets.US_ASCII.toString())).openConnection();
            try {
                httpURLConnection.setRequestProperty("Connection", "Close");
                httpURLConnection.setRequestProperty("User-Agent", Utils.getAppVersionString());
                httpURLConnection.setRequestMethod("POST");
                int responseCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "requestUnlockToken: " + responseCode);
                StringBuilder sb = new StringBuilder();
                if (responseCode >= 400) {
                    inputStream = httpURLConnection.getErrorStream();
                } else {
                    inputStream = httpURLConnection.getInputStream();
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                bufferedReader.close();
                final String sb2 = sb.toString();
                if (responseCode == 200 && !sb2.isEmpty()) {
                    Log.i(TAG, "requestUnlockToken: " + sb2);
                    BillingClient billingClient = this.mBillingClient;
                    if (str != null) {
                        ?? obj = new Object();
                        obj.zza = str;
                        billingClient.consumeAsync(obj, new ConsumeResponseListener() { // from class: com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda7
                            @Override // com.android.billingclient.api.ConsumeResponseListener
                            public final void onConsumeResponse(BillingResult billingResult, String str2) {
                                PlayBilling.this.lambda$requestUnlockToken$21(sb2, billingResult, str2);
                            }
                        });
                        httpURLConnection.disconnect();
                        return;
                    }
                    throw new IllegalArgumentException("Purchase token must be set");
                }
                Log.i(TAG, "requestUnlockToken error [" + responseCode + "]: " + sb2);
                this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda6(this, responseCode, sb2, str));
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 11));
        } finally {
            this.mRequestTokenThread = null;
        }
    }

    private String sku2pref(String str) {
        return "SKU:" + str;
    }

    private void startQrActivation(QrActivationRequest qrActivationRequest, String str) {
        Utils.showToast(this.mContext, C0130R.string.requesting_license, new Object[0]);
        ExecutorService executorService = this.mQrActivationExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        this.mQrActivationExecutor = Executors.newSingleThreadExecutor();
        Log.d(TAG, "QR code activation: installation_id=" + qrActivationRequest.installation_id + ", req_id=" + qrActivationRequest.qr_request_id + ", device=" + qrActivationRequest.device_name);
        this.mQrActivationExecutor.execute(new PlayBilling$$ExternalSyntheticLambda23(this, str, qrActivationRequest, 0));
    }

    private boolean verifiedBuild() {
        if (mVerifiedBuildType == null) {
            mVerifiedBuildType = Utils.getVerifiedBuild(this.mContext);
        }
        return mVerifiedBuildType.equals(Utils.BuildType.PLAYSTORE);
    }

    @Override // com.emanuelef.remote_capture.Billing
    public void connectBilling() {
        BillingClient billingClient;
        if (verifiedBuild()) {
            this.mWaitingStart = true;
            if (this.mBillingClient == null) {
                Context context = this.mContext;
                EmojiCompat.CompatInternal19 compatInternal19 = new EmojiCompat.CompatInternal19(context);
                compatInternal19.mMetadataRepo = this;
                compatInternal19.mProcessor = new Transition.C01101(14);
                if (context == null) {
                    throw new IllegalArgumentException("Please provide a valid Context.");
                } else if (((PlayBilling) compatInternal19.mMetadataRepo) == null) {
                    throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                } else if (((Transition.C01101) compatInternal19.mProcessor) != null) {
                    ((Transition.C01101) compatInternal19.mProcessor).getClass();
                    if (((PlayBilling) compatInternal19.mMetadataRepo) != null) {
                        Transition.C01101 r2 = (Transition.C01101) compatInternal19.mProcessor;
                        PlayBilling playBilling = (PlayBilling) compatInternal19.mMetadataRepo;
                        if (compatInternal19.zza()) {
                            billingClient = new zzce(r2, context, playBilling, compatInternal19);
                        } else {
                            billingClient = new BillingClientImpl(r2, context, playBilling, compatInternal19);
                        }
                    } else {
                        Transition.C01101 r22 = (Transition.C01101) compatInternal19.mProcessor;
                        if (compatInternal19.zza()) {
                            billingClient = new zzce(r22, context, compatInternal19);
                        } else {
                            billingClient = new BillingClientImpl(r22, context, compatInternal19);
                        }
                    }
                    this.mBillingClient = billingClient;
                    billingClient.startConnection(this);
                } else {
                    throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.android.billingclient.api.ConsumeParams, java.lang.Object] */
    public void consumePurchase(String str) {
        String str2 = this.mSkuToPurchToken.get(str);
        if (str2 == null) {
            this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 8));
            return;
        }
        BillingClient billingClient = this.mBillingClient;
        ?? obj = new Object();
        obj.zza = str2;
        billingClient.consumeAsync(obj, new PlayBilling$$ExternalSyntheticLambda15(2));
    }

    @Override // com.emanuelef.remote_capture.Billing
    public void disconnectBilling() {
        this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 4));
    }

    public String getLastUnlockToken() {
        return this.mPrefs.getString(PREF_LAST_UNLOCK_TOKEN, "");
    }

    public ProductDetails getProductDetails(String str) {
        return this.mDetails.get(str);
    }

    @Override // com.emanuelef.remote_capture.Billing
    public boolean isAvailable(String str) {
        if (!verifiedBuild()) {
            return false;
        }
        return this.mAvailability.isAvailable(str);
    }

    @Override // com.emanuelef.remote_capture.Billing
    public boolean isPlayStore() {
        return true;
    }

    @Override // com.emanuelef.remote_capture.Billing
    public boolean isPurchased(String str) {
        if (str.equals(Billing.UNLOCK_TOKEN_SKU)) {
            return false;
        }
        if ((str.equals(Billing.SUPPORTER_SKU) || !isPurchased(Billing.SUPPORTER_SKU)) && this.mPrefs.getLong(sku2pref(str), 0L) == 0) {
            return false;
        }
        return true;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        Log.w(TAG, "onBillingServiceDisconnected");
        this.mHandler.postDelayed(new PlayBilling$$ExternalSyntheticLambda3(this, 0), 5000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.android.billingclient.api.QueryProductDetailsParams, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.android.billingclient.api.ConsumeParams, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6, types: [com.android.billingclient.api.QueryProductDetailsParams, java.lang.Object] */
    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(BillingResult billingResult) {
        Log.d(TAG, "onBillingSetupFinished: " + billingResult2Str(billingResult));
        if (billingResult.zza == 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : Billing.ALL_SKUS) {
                ?? obj = new Object();
                obj.zza = str;
                if (str != null) {
                    arrayList.add(new QueryProductDetailsParams.Product(obj));
                } else {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
            }
            ?? obj2 = new Object();
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj3 = arrayList.get(i);
                    i++;
                    ((QueryProductDetailsParams.Product) obj3).getClass();
                    hashSet.add("inapp");
                }
                if (hashSet.size() <= 1) {
                    zzbt zzj = zzbt.zzj(arrayList);
                    obj2.zza = zzj;
                    if (zzj != null) {
                        ?? obj4 = new Object();
                        obj4.zza = obj2.zza;
                        this.mBillingClient.queryProductDetailsAsync(obj4, this);
                        return;
                    }
                    throw new IllegalArgumentException("Product list must be set to a non empty list.");
                }
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            throw new IllegalArgumentException("Product list cannot be empty.");
        }
        onPurchasesError(billingResult);
    }

    @Override // com.android.billingclient.api.ProductDetailsResponseListener
    public void onProductDetailsResponse(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
        Log.d(TAG, "onProductDetailsResponse: " + billingResult2Str(billingResult));
        if (billingResult.zza == 0) {
            List<ProductDetails> list = queryProductDetailsResult.productDetailsList;
            this.mAvailability.update(list, this.mPrefs);
            Log.d(TAG, "Num available SKUs: " + list.size());
            this.mDetails.clear();
            for (ProductDetails productDetails : list) {
                this.mDetails.put(productDetails.zzc, productDetails);
            }
            BillingClient billingClient = this.mBillingClient;
            PlayBilling$$ExternalSyntheticLambda4 playBilling$$ExternalSyntheticLambda4 = new PlayBilling$$ExternalSyntheticLambda4(0, this);
            BillingClientImpl billingClientImpl = (BillingClientImpl) billingClient;
            billingClientImpl.getClass();
            if (BillingClientImpl.zzG(new zzaw(billingClientImpl, playBilling$$ExternalSyntheticLambda4), 30000L, new zzi(billingClientImpl, 9, playBilling$$ExternalSyntheticLambda4), billingClientImpl.zzan(), billingClientImpl.zzF()) == null) {
                BillingResult zzaq = billingClientImpl.zzaq();
                billingClientImpl.zzbd(25, 9, zzaq);
                zzbr zzbrVar = zzbt.zza;
                playBilling$$ExternalSyntheticLambda4.onQueryPurchasesResponse(zzaq, zzca.zza);
                return;
            }
            return;
        }
        onPurchasesError(billingResult);
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        Log.d(TAG, "onPurchasesUpdated: " + billingResult2Str(billingResult));
        processPurchases(billingResult, list, false);
    }

    public void performQrActivation(Activity activity, QrActivationRequest qrActivationRequest) {
        if (!qrActivationRequest.isValid()) {
            Log.e(TAG, "Invalid QR activation request");
            return;
        }
        String lastUnlockToken = getLastUnlockToken();
        if (!lastUnlockToken.isEmpty()) {
            zzbv zzbvVar = new zzbv(this.mContext);
            zzbvVar.setTitle(C0130R.string.license_code);
            ((AlertController.AlertParams) zzbvVar.zza).mMessage = this.mContext.getString(C0130R.string.qr_license_confirm, qrActivationRequest.device_name) + "\n\n" + lastUnlockToken;
            zzbvVar.setPositiveButton(C0130R.string.yes, new PlayBilling$$ExternalSyntheticLambda24(this, qrActivationRequest, lastUnlockToken, 0));
            zzbvVar.setNegativeButton(C0130R.string.no, new Utils$$ExternalSyntheticLambda1(3));
            zzbvVar.show();
            return;
        }
        zzbv zzbvVar2 = new zzbv(this.mContext);
        zzbvVar2.setTitle(C0130R.string.unlock_token);
        ((AlertController.AlertParams) zzbvVar2.zza).mMessage = this.mContext.getString(C0130R.string.qr_purchase_required);
        zzbvVar2.setPositiveButton(C0130R.string.ok, new PlayBilling$$ExternalSyntheticLambda24(this, qrActivationRequest, activity, 1));
        zzbvVar2.setNegativeButton(C0130R.string.cancel_action, new Utils$$ExternalSyntheticLambda1(4));
        zzbvVar2.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, com.android.billingclient.api.BillingFlowParams] */
    /* JADX WARN: Type inference failed for: r8v9, types: [androidx.collection.internal.Lock, java.lang.Object] */
    public boolean purchase(Activity activity, String str) {
        boolean z;
        boolean z2;
        BillingClient billingClient = this.mBillingClient;
        if (billingClient == null || !((BillingClientImpl) billingClient).zzaY()) {
            this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 6));
            return false;
        }
        ProductDetails productDetails = this.mDetails.get(str);
        if (productDetails == null) {
            this.mHandler.post(new PlayBilling$$ExternalSyntheticLambda3(this, 7));
            return false;
        }
        Log.d(TAG, "Starting purchasing SKU " + str);
        ArrayList arrayList = new ArrayList();
        zzcl zzclVar = new zzcl(17, false);
        zzclVar.zzb = productDetails;
        if (productDetails.getOneTimePurchaseOfferDetails() != null) {
            productDetails.getOneTimePurchaseOfferDetails().getClass();
            String str2 = productDetails.getOneTimePurchaseOfferDetails().zzd;
            if (str2 != null) {
                zzclVar.zzc = str2;
            }
        }
        arrayList.add(new BillingFlowParams.ProductDetailsParams(zzclVar));
        ArrayList arrayList2 = new ArrayList(arrayList);
        boolean isEmpty = arrayList2.isEmpty();
        if (!isEmpty) {
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                if (((BillingFlowParams.ProductDetailsParams) obj) == null) {
                    throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                }
            }
            ?? obj2 = new Object();
            if (isEmpty || ((BillingFlowParams.ProductDetailsParams) arrayList2.get(0)).zza.zzb.optString("packageName").isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            obj2.zza = z;
            if (!TextUtils.isEmpty(null) || !TextUtils.isEmpty(null)) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean isEmpty2 = TextUtils.isEmpty(null);
            if (!z2 || isEmpty2) {
                obj2.zzd = new Object();
                obj2.zzf = new ArrayList();
                obj2.zze = zzbt.zzj(arrayList2);
                mPendingNoticeShown = false;
                BillingResult launchBillingFlow = this.mBillingClient.launchBillingFlow(activity, obj2);
                Log.d(TAG, "BillingFlow result: " + billingResult2Str(launchBillingFlow));
                if (launchBillingFlow.zza == 0) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
        }
        throw new IllegalArgumentException("Details of the products must be provided.");
    }

    @Override // com.emanuelef.remote_capture.Billing
    public boolean setLicense(String str) {
        return false;
    }

    public void setPurchaseReadyListener(PurchaseReadyListener purchaseReadyListener) {
        this.mListener = purchaseReadyListener;
    }

    public boolean setPurchased(String str, boolean z) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        String sku2pref = sku2pref(str);
        if (z) {
            edit.putLong(sku2pref, System.currentTimeMillis());
        } else {
            edit.remove(sku2pref);
        }
        edit.apply();
        return true;
    }

    public void showUnlockToken() {
        String lastUnlockToken = getLastUnlockToken();
        if (!lastUnlockToken.isEmpty()) {
            View inflate = LayoutInflater.from(this.mContext).inflate(C0130R.layout.unlock_token_dialog, (ViewGroup) null);
            ((TextView) inflate.findViewById(C0130R.C0132id.unlock_token)).setText(lastUnlockToken);
            Utils.setTextUrls((TextView) inflate.findViewById(C0130R.C0132id.unlock_token_msg), C0130R.string.unlock_token_msg1, "https://pcapdroid.org/getlicense/?unlock_token=".concat(lastUnlockToken));
            zzbv zzbvVar = new zzbv(this.mContext);
            zzbvVar.setTitle(C0130R.string.unlock_token);
            ((AlertController.AlertParams) zzbvVar.zza).mView = inflate;
            zzbvVar.setPositiveButton(C0130R.string.ok, new Utils$$ExternalSyntheticLambda1(1));
            zzbvVar.setNeutralButton(C0130R.string.copy_to_clipboard, new PlayBilling$$ExternalSyntheticLambda0(this, 1, lastUnlockToken));
            zzbvVar.show();
        }
    }

    /* loaded from: classes.dex */
    public interface PurchaseReadyListener {
        void onPurchasesError();

        void onPurchasesReady();

        void onSKUStateUpdate(String str, int i);

        /* renamed from: com.emanuelef.remote_capture.PlayBilling$PurchaseReadyListener$-CC */
        /* loaded from: classes.dex */
        public abstract /* synthetic */ class CC {
            public static void $default$onPurchasesError(PurchaseReadyListener purchaseReadyListener) {
            }

            public static void $default$onPurchasesReady(PurchaseReadyListener purchaseReadyListener) {
            }

            public static void $default$onSKUStateUpdate(PurchaseReadyListener purchaseReadyListener, String str, int i) {
            }
        }
    }
}
