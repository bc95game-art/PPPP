package com.emanuelef.remote_capture.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.adapters.SKUsAdapter;
/* loaded from: classes.dex */
public class IABActivity extends BaseActivity implements PlayBilling.PurchaseReadyListener, SKUsAdapter.SKUClickListener {
    private static final String TAG = "IABActivity";
    private SKUsAdapter mAdapter;
    private PlayBilling mIab;
    private TextView mListEmpty;

    private void checkQrActivationRequest(Intent intent) {
        Uri data = intent.getData();
        if (data != null && data.getHost().equals("get_license")) {
            if (!this.mIab.isAvailable(Billing.UNLOCK_TOKEN_SKU)) {
                Utils.showToast(this, R.string.feature_not_available, new Object[0]);
                return;
            }
            PlayBilling.QrActivationRequest qrActivationRequest = new PlayBilling.QrActivationRequest();
            qrActivationRequest.installation_id = data.getQueryParameter("installation_id");
            qrActivationRequest.qr_request_id = data.getQueryParameter("qr_request_id");
            qrActivationRequest.device_name = data.getQueryParameter("device");
            intent.setData(null);
            this.mIab.performQrActivation(this, qrActivationRequest);
        }
    }

    private void reloadAvailableSkus() {
        if (!this.mIab.isAvailable("malware_detection")) {
            Log.i(TAG, "No SKUs available");
            this.mListEmpty.setVisibility(0);
            this.mAdapter.clear();
            return;
        }
        this.mListEmpty.setVisibility(8);
        this.mAdapter.loadSKUs();
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.paid_features);
        displayBackAction();
        setContentView(R.layout.simple_list_activity);
        findViewById(R.id.simple_list).setFitsSystemWindows(true);
        this.mIab = new PlayBilling(this);
        TextView textView = (TextView) findViewById(R.id.list_empty);
        this.mListEmpty = textView;
        textView.setText(R.string.loading);
        this.mAdapter = new SKUsAdapter(this, this.mIab, this);
        ((ListView) findViewById(R.id.listview)).setAdapter((ListAdapter) this.mAdapter);
        this.mIab.setPurchaseReadyListener(this);
    }

    @Override // com.emanuelef.remote_capture.adapters.SKUsAdapter.SKUClickListener
    public void onLearnMoreClick(SKUsAdapter.SKUItem sKUItem) {
        Utils.startActivity(this, new Intent("android.intent.action.VIEW", Uri.parse(sKUItem.docs_url)));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIab.disconnectBilling();
    }

    @Override // com.emanuelef.remote_capture.adapters.SKUsAdapter.SKUClickListener
    public void onPurchaseClick(SKUsAdapter.SKUItem sKUItem) {
        this.mIab.purchase(this, sKUItem.sku);
    }

    @Override // com.emanuelef.remote_capture.PlayBilling.PurchaseReadyListener
    public void onPurchasesError() {
        Log.d(TAG, "Purchases Error");
        this.mListEmpty.setText(R.string.billing_failure);
        reloadAvailableSkus();
    }

    @Override // com.emanuelef.remote_capture.PlayBilling.PurchaseReadyListener
    public void onPurchasesReady() {
        Log.d(TAG, "Purchases Ready");
        this.mListEmpty.setText(R.string.no_items_for_purchase);
        reloadAvailableSkus();
        Intent intent = getIntent();
        if (intent != null) {
            checkQrActivationRequest(intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIab.connectBilling();
    }

    @Override // com.emanuelef.remote_capture.PlayBilling.PurchaseReadyListener
    public void onSKUStateUpdate(String str, int i) {
        StringBuilder m = ViewModelProvider.Factory.CC.m15m("SKU ", str, " state update: ");
        m.append(PlayBilling.purchstate2Str(i));
        Log.d(TAG, m.toString());
        reloadAvailableSkus();
    }

    @Override // com.emanuelef.remote_capture.adapters.SKUsAdapter.SKUClickListener
    public void onShowClick(SKUsAdapter.SKUItem sKUItem) {
        if (sKUItem.sku.equals(Billing.UNLOCK_TOKEN_SKU)) {
            this.mIab.showUnlockToken();
        }
    }
}
