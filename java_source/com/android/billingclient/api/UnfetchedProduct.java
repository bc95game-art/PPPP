package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class UnfetchedProduct {
    public final String jsonString;
    public final String productId;
    public final String productType;
    public final int statusCode;

    public UnfetchedProduct(String str) {
        int i;
        this.jsonString = str;
        JSONObject jSONObject = new JSONObject(str);
        this.productId = jSONObject.optString("productId");
        String optString = jSONObject.optString("type");
        this.productType = optString;
        if (jSONObject.has("statusCode")) {
            i = jSONObject.optInt("statusCode");
        } else {
            i = 0;
        }
        this.statusCode = i;
        if (!TextUtils.isEmpty(optString)) {
            jSONObject.optString("serializedDocid");
            return;
        }
        throw new IllegalArgumentException("Product type cannot be empty.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnfetchedProduct)) {
            return false;
        }
        return TextUtils.equals(this.jsonString, ((UnfetchedProduct) obj).jsonString);
    }

    public final int hashCode() {
        return this.jsonString.hashCode();
    }

    public final String toString() {
        return "UnfetchedProduct{productId='" + this.productId + "', productType='" + this.productType + "', statusCode=" + this.statusCode + "}";
    }
}
