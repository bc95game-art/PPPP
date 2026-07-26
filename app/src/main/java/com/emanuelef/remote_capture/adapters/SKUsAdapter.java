package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.android.billingclient.api.ProductDetails;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.google.android.material.button.MaterialButton;
/* loaded from: classes.dex */
public class SKUsAdapter extends ArrayAdapter<SKUItem> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "SKUsAdapter";
    private static final boolean TEST_MODE = false;
    private final Context mCtx;
    private final PlayBilling mIab;
    private final LayoutInflater mLayoutInflater;
    private final SKUClickListener mListener;

    /* loaded from: classes.dex */
    public interface SKUClickListener {
        void onLearnMoreClick(SKUItem sKUItem);

        void onPurchaseClick(SKUItem sKUItem);

        void onShowClick(SKUItem sKUItem);
    }

    /* loaded from: classes.dex */
    public static class SKUItem {
        public final String description;
        public final String docs_url;
        public final String label;
        public final String price;
        public final String sku;

        public SKUItem(String str, String str2, String str3, String str4, String str5) {
            this.sku = str;
            this.label = str2;
            this.description = str3;
            this.price = str4;
            this.docs_url = str5;
        }
    }

    public SKUsAdapter(Context context, PlayBilling playBilling, SKUClickListener sKUClickListener) {
        super(context, 0);
        this.mCtx = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mIab = playBilling;
        this.mListener = sKUClickListener;
    }

    private void addIfAvailable(String str, int i, int i2, String str2) {
        ProductDetails productDetails;
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
        String str3;
        if (this.mIab.isAvailable(str) && (productDetails = this.mIab.getProductDetails(str)) != null && (oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails()) != null) {
            Log.d(TAG, "SKU [" + productDetails.zzc + "]: " + productDetails.zze + " -> " + oneTimePurchaseOfferDetails.zza);
            String string = this.mCtx.getString(i);
            if (i2 > 0) {
                str3 = this.mCtx.getString(i2);
            } else {
                str3 = "";
            }
            add(new SKUItem(str, string, str3, oneTimePurchaseOfferDetails.zza, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getView$0(SKUItem sKUItem, View view) {
        this.mListener.onShowClick(sKUItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getView$1(SKUItem sKUItem, View view) {
        this.mListener.onPurchaseClick(sKUItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getView$2(SKUItem sKUItem, View view) {
        this.mListener.onLearnMoreClick(sKUItem);
    }

    private /* synthetic */ void lambda$getView$3(SKUItem sKUItem, MaterialButton materialButton, View view) {
        this.mIab.consumePurchase(sKUItem.sku);
        materialButton.setEnabled(false);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        int i2;
        int i3 = 0;
        if (view == null) {
            view = this.mLayoutInflater.inflate(C0130R.layout.sku_item, viewGroup, false);
        }
        final SKUItem sKUItem = (SKUItem) getItem(i);
        boolean isPurchased = this.mIab.isPurchased(sKUItem.sku);
        ((TextView) view.findViewById(C0130R.C0132id.label)).setText(sKUItem.label);
        ((TextView) view.findViewById(C0130R.C0132id.description)).setText(sKUItem.description);
        if (isPurchased) {
            str = this.mCtx.getString(C0130R.string.purchased);
        } else {
            str = sKUItem.price;
        }
        ((TextView) view.findViewById(C0130R.C0132id.price)).setText(str);
        MaterialButton materialButton = (MaterialButton) view.findViewById(C0130R.C0132id.show);
        if (!sKUItem.sku.equals(Billing.UNLOCK_TOKEN_SKU) || this.mIab.getLastUnlockToken().isEmpty()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        materialButton.setVisibility(i2);
        materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.adapters.SKUsAdapter$$ExternalSyntheticLambda0
            public final /* synthetic */ SKUsAdapter f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$getView$0(sKUItem, view2);
                        return;
                    case 1:
                        this.f$0.lambda$getView$1(sKUItem, view2);
                        return;
                    default:
                        this.f$0.lambda$getView$2(sKUItem, view2);
                        return;
                }
            }
        });
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C0130R.C0132id.purchase);
        materialButton2.setEnabled(!isPurchased);
        materialButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.adapters.SKUsAdapter$$ExternalSyntheticLambda0
            public final /* synthetic */ SKUsAdapter f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$getView$0(sKUItem, view2);
                        return;
                    case 1:
                        this.f$0.lambda$getView$1(sKUItem, view2);
                        return;
                    default:
                        this.f$0.lambda$getView$2(sKUItem, view2);
                        return;
                }
            }
        });
        View findViewById = view.findViewById(C0130R.C0132id.learn_more);
        if (sKUItem.docs_url == null) {
            i3 = 4;
        }
        findViewById.setVisibility(i3);
        findViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.adapters.SKUsAdapter$$ExternalSyntheticLambda0
            public final /* synthetic */ SKUsAdapter f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$getView$0(sKUItem, view2);
                        return;
                    case 1:
                        this.f$0.lambda$getView$1(sKUItem, view2);
                        return;
                    default:
                        this.f$0.lambda$getView$2(sKUItem, view2);
                        return;
                }
            }
        });
        return view;
    }

    public void loadSKUs() {
        Log.d(TAG, "Populating SKUs...");
        clear();
        addIfAvailable(Billing.FIREWALL_SKU, C0130R.string.no_root_firewall, C0130R.string.firewall_summary, MainActivity.FIREWALL_DOCS_URL);
        addIfAvailable("malware_detection", C0130R.string.malware_detection, C0130R.string.malware_detection_summary, MainActivity.MALWARE_DETECTION_DOCS_URL);
        addIfAvailable(Billing.PCAPNG_SKU, C0130R.string.pcapng_format, C0130R.string.pcapng_format_summary, MainActivity.PCAPNG_DOCS_URL);
        addIfAvailable(Billing.UNLOCK_TOKEN_SKU, C0130R.string.unlock_token, C0130R.string.unlock_token_summary, MainActivity.PAID_FEATURES_URL);
        notifyDataSetChanged();
    }
}
