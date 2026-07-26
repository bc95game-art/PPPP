package com.emanuelef.remote_capture.model;

import android.content.SharedPreferences;
import com.android.billingclient.api.ProductDetails;
import com.emanuelef.remote_capture.Log;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class SkusAvailability implements Serializable {
    private static final String PREF_KEY = "available_skus";
    private static final String TAG = "SkusAvailability";
    private final HashSet<String> mSkus = new HashSet<>();

    private SkusAvailability() {
    }

    public static SkusAvailability load(SharedPreferences sharedPreferences) {
        SkusAvailability skusAvailability;
        String string = sharedPreferences.getString(PREF_KEY, "");
        try {
            skusAvailability = (SkusAvailability) new Gson().fromJson(string, TypeToken.get(SkusAvailability.class));
        } catch (JsonSyntaxException | IllegalArgumentException e) {
            Log.e(TAG, "SkusAvailability JSON load error: " + e);
            skusAvailability = null;
        }
        if (skusAvailability == null) {
            return new SkusAvailability();
        }
        return skusAvailability;
    }

    private void save(SharedPreferences sharedPreferences) {
        String json = new Gson().toJson(this);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(PREF_KEY, json);
        edit.apply();
    }

    public boolean isAvailable(String str) {
        return this.mSkus.contains(str);
    }

    public boolean update(List<ProductDetails> list, SharedPreferences sharedPreferences) {
        HashSet hashSet = new HashSet();
        boolean z = false;
        for (ProductDetails productDetails : list) {
            String str = productDetails.zzc;
            hashSet.add(str);
            if (!this.mSkus.contains(str)) {
                this.mSkus.add(str);
                z = true;
            }
        }
        Iterator<String> it = this.mSkus.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        if (z) {
            save(sharedPreferences);
        }
        return z;
    }
}
