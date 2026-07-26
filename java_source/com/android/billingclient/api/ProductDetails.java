package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.transition.ViewUtilsApi21;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ProductDetails {
    public final String zza;
    public final JSONObject zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final String zzh;
    public final String zzi;
    public final ArrayList zzj;
    public final ArrayList zzk;

    /* loaded from: classes.dex */
    public final class OneTimePurchaseOfferDetails {
        public final String zza;
        public final String zzd;
        public final ArrayList zzg;
        public final String zzl;
        public final ViewUtilsApi21 zzn;

        /* JADX WARN: Multi-variable type inference failed */
        public OneTimePurchaseOfferDetails(JSONObject jSONObject) {
            this.zza = jSONObject.optString("formattedPrice");
            jSONObject.optLong("priceAmountMicros");
            jSONObject.optString("priceCurrencyCode");
            String optString = jSONObject.optString("offerIdToken");
            ViewUtilsApi21 viewUtilsApi21 = null;
            this.zzd = true == optString.isEmpty() ? null : optString;
            jSONObject.optString("offerId").getClass();
            jSONObject.optString("purchaseOptionId").getClass();
            jSONObject.optInt("offerType");
            JSONArray optJSONArray = jSONObject.optJSONArray("offerTags");
            this.zzg = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.zzg.add(optJSONArray.getString(i));
                }
            }
            if (jSONObject.has("fullPriceMicros")) {
                jSONObject.optLong("fullPriceMicros");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
            if (optJSONObject != null) {
                if (optJSONObject.has("percentageDiscount")) {
                    optJSONObject.optInt("percentageDiscount");
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("discountAmount");
                if (optJSONObject2 != null) {
                    optJSONObject2.optString("formattedDiscountAmount");
                    optJSONObject2.optLong("discountAmountMicros");
                    optJSONObject2.optString("discountAmountCurrencyCode");
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("validTimeWindow");
            if (optJSONObject3 != null) {
                if (optJSONObject3.has("startTimeMillis")) {
                    optJSONObject3.optLong("startTimeMillis");
                }
                if (optJSONObject3.has("endTimeMillis")) {
                    optJSONObject3.optLong("endTimeMillis");
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("limitedQuantityInfo");
            if (optJSONObject4 != null) {
                optJSONObject4.getInt("maximumQuantity");
                optJSONObject4.getInt("remainingQuantity");
            }
            this.zzl = jSONObject.optString("serializedDocid");
            JSONObject optJSONObject5 = jSONObject.optJSONObject("preorderDetails");
            if (optJSONObject5 != null) {
                optJSONObject5.getLong("preorderReleaseTimeMillis");
                optJSONObject5.getLong("preorderPresaleEndTimeMillis");
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("rentalDetails");
            if (optJSONObject6 != null) {
                optJSONObject6.getString("rentalPeriod");
                optJSONObject6.optString("rentalExpirationPeriod").getClass();
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("autoPayDetails");
            if (optJSONObject7 != null) {
                Object obj = new Object();
                optJSONObject7.getString("type");
                viewUtilsApi21 = obj;
            }
            this.zzn = viewUtilsApi21;
            JSONArray optJSONArray2 = jSONObject.optJSONArray("pricingPhases");
            if (optJSONArray2 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject8 = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject8 != null) {
                        arrayList.add(new ViewUtilsApi21(optJSONObject8));
                    }
                }
            }
        }
    }

    public ProductDetails(String str) {
        ArrayList arrayList;
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        String optString = jSONObject.optString("productId");
        this.zzc = optString;
        String optString2 = jSONObject.optString("type");
        this.zzd = optString2;
        if (TextUtils.isEmpty(optString)) {
            throw new IllegalArgumentException("Product id cannot be empty.");
        } else if (!TextUtils.isEmpty(optString2)) {
            this.zze = jSONObject.optString(AppIntroBaseFragmentKt.ARG_TITLE);
            jSONObject.optString("name");
            jSONObject.optString("description");
            jSONObject.optString("packageDisplayName");
            jSONObject.optString("iconUrl");
            this.zzh = jSONObject.optString("skuDetailsToken");
            this.zzi = jSONObject.optString("serializedDocid");
            JSONArray optJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
            if (optJSONArray != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Object obj = new Object();
                    jSONObject2.optString("basePlanId");
                    jSONObject2.optString("offerId").getClass();
                    jSONObject2.getString("offerIdToken");
                    JSONArray jSONArray = jSONObject2.getJSONArray("pricingPhases");
                    ArrayList arrayList3 = new ArrayList();
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                arrayList3.add(new ViewUtilsApi21(optJSONObject));
                            }
                        }
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("installmentPlanDetails");
                    if (optJSONObject2 != null) {
                        optJSONObject2.getInt("commitmentPaymentsCount");
                        optJSONObject2.optInt("subsequentCommitmentPaymentsCount");
                    }
                    JSONObject optJSONObject3 = jSONObject2.optJSONObject("transitionPlanDetails");
                    if (optJSONObject3 != null) {
                        optJSONObject3.getString("productId");
                        optJSONObject3.optString(AppIntroBaseFragmentKt.ARG_TITLE);
                        optJSONObject3.optString("name");
                        optJSONObject3.optString("description");
                        optJSONObject3.optString("basePlanId");
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("pricingPhase");
                        if (optJSONObject4 != null) {
                            optJSONObject4.optString("billingPeriod");
                            optJSONObject4.optString("priceCurrencyCode");
                            optJSONObject4.optString("formattedPrice");
                            optJSONObject4.optLong("priceAmountMicros");
                            optJSONObject4.optInt("recurrenceMode");
                            optJSONObject4.optInt("billingCycleCount");
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("offerTags");
                    if (optJSONArray2 != null) {
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            arrayList4.add(optJSONArray2.getString(i3));
                        }
                    }
                    arrayList2.add(obj);
                }
                this.zzj = arrayList2;
            } else {
                if (optString2.equals("subs") || optString2.equals("play_pass_subs")) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                this.zzj = arrayList;
            }
            JSONObject optJSONObject5 = this.zzb.optJSONObject("oneTimePurchaseOfferDetails");
            JSONArray optJSONArray3 = this.zzb.optJSONArray("oneTimePurchaseOfferDetailsList");
            ArrayList arrayList5 = new ArrayList();
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    arrayList5.add(new OneTimePurchaseOfferDetails(optJSONArray3.getJSONObject(i4)));
                }
                this.zzk = arrayList5;
            } else if (optJSONObject5 != null) {
                arrayList5.add(new OneTimePurchaseOfferDetails(optJSONObject5));
                this.zzk = arrayList5;
            } else {
                this.zzk = null;
            }
        } else {
            throw new IllegalArgumentException("Product type cannot be empty.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetails)) {
            return false;
        }
        return TextUtils.equals(this.zza, ((ProductDetails) obj).zza);
    }

    public final OneTimePurchaseOfferDetails getOneTimePurchaseOfferDetails() {
        ArrayList arrayList = this.zzk;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (OneTimePurchaseOfferDetails) arrayList.get(0);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        String obj = this.zzb.toString();
        String valueOf = String.valueOf(this.zzj);
        return "ProductDetails{jsonString='" + this.zza + "', parsedJson=" + obj + ", productId='" + this.zzc + "', productType='" + this.zzd + "', title='" + this.zze + "', productDetailsToken='" + this.zzh + "', subscriptionOfferDetails=" + valueOf + "}";
    }
}
