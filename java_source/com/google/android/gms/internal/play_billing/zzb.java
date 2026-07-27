package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
/* loaded from: classes.dex */
public enum zzb {
    zza("RESPONSE_CODE_UNSPECIFIED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF18("SERVICE_TIMEOUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF27("FEATURE_NOT_SUPPORTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF36("SERVICE_DISCONNECTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF44("OK"),
    /* JADX INFO: Fake field, exist only in values array */
    EF52("USER_CANCELED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF60("SERVICE_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF70("BILLING_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF83("ITEM_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF96("DEVELOPER_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF109("ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF122("ITEM_ALREADY_OWNED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF133("ITEM_NOT_OWNED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF148("EXPIRED_OFFER_TOKEN"),
    /* JADX INFO: Fake field, exist only in values array */
    EF163("NETWORK_ERROR");
    
    public static final zzcf zzp;
    public final int zzr;

    /* JADX WARN: Type inference failed for: r0v3, types: [org.brotli.dec.HuffmanTreeGroup, java.lang.Object] */
    static {
        zzb[] values;
        ?? obj = new Object();
        obj.codes = new Object[8];
        obj.alphabetSize = 0;
        for (zzb zzbVar : values()) {
            Integer valueOf = Integer.valueOf(zzbVar.zzr);
            int i = obj.alphabetSize + 1;
            Object[] objArr = (Object[]) obj.codes;
            int length = objArr.length;
            int i2 = i + i;
            if (i2 > length) {
                if (i2 > length) {
                    length = length + (length >> 1) + 1;
                    if (length < i2) {
                        int highestOneBit = Integer.highestOneBit(i2 - 1);
                        length = highestOneBit + highestOneBit;
                    }
                    if (length < 0) {
                        length = Integer.MAX_VALUE;
                    }
                }
                obj.codes = Arrays.copyOf(objArr, length);
            }
            Object[] objArr2 = (Object[]) obj.codes;
            int i3 = obj.alphabetSize;
            int i4 = i3 + i3;
            objArr2[i4] = valueOf;
            objArr2[i4 + 1] = zzbVar;
            obj.alphabetSize = i3 + 1;
        }
        zzbu zzbuVar = (zzbu) obj.trees;
        if (zzbuVar == null) {
            zzcf zzg = zzcf.zzg(obj.alphabetSize, (Object[]) obj.codes, obj);
            zzbu zzbuVar2 = (zzbu) obj.trees;
            if (zzbuVar2 == null) {
                zzp = zzg;
                return;
            }
            throw zzbuVar2.zza();
        }
        throw zzbuVar.zza();
    }

    zzb(String str) {
        this.zzr = r2;
    }
}
