package com.android.billingclient.api;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcf;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BillingResult {
    public int zza;
    public int zzb;
    public String zzc;

    /* loaded from: classes.dex */
    public final class Builder {
        public int zza;
        public int zzb;
        public Serializable zzc = new ArrayList();

        public Builder(Context context, XmlResourceParser xmlResourceParser) {
            this.zzb = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.zza = obtainStyledAttributes.getResourceId(index, this.zza);
                } else if (index == 1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.zzb);
                    this.zzb = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        new ConstraintSet().clone((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.android.billingclient.api.BillingResult, java.lang.Object] */
        public BillingResult build() {
            ?? obj = new Object();
            obj.zza = this.zza;
            obj.zzb = this.zzb;
            obj.zzc = (String) this.zzc;
            return obj;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.android.billingclient.api.BillingResult$Builder] */
    public static Builder newBuilder() {
        ?? obj = new Object();
        obj.zzb = 0;
        obj.zzc = "";
        return obj;
    }

    public final String toString() {
        zzb zzbVar;
        int i = this.zza;
        int i2 = zzc.zza;
        zzcf zzcfVar = zzb.zzp;
        Integer valueOf = Integer.valueOf(i);
        if (!zzcfVar.containsKey(valueOf)) {
            zzbVar = zzb.zza;
        } else {
            zzbVar = (zzb) zzcfVar.get(valueOf);
        }
        String obj = zzbVar.toString();
        String str = this.zzc;
        return "Response Code: " + obj + ", Debug Message: " + str;
    }
}
