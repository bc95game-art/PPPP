package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzdk extends zzfi {
    private static final zzdk zzb;
    private zzfn zzd = zzgt.zzb;

    static {
        zzdk zzdkVar = new zzdk();
        zzb = zzdkVar;
        zzfi.zzw(zzdk.class, zzdkVar);
    }

    public static zzdj zza$1() {
        return (zzdj) zzb.zzl();
    }

    public static void zzd(zzdk zzdkVar, ArrayList arrayList) {
        zzfn zzfnVar = zzdkVar.zzd;
        if (!((zzdu) zzfnVar).zza) {
            int size = zzfnVar.size();
            zzdkVar.zzd = zzfnVar.zzd(size + size);
        }
        zzfn zzfnVar2 = zzdkVar.zzd;
        Charset charset = zzfo.zza;
        int size2 = arrayList.size();
        if (zzfnVar2 instanceof ArrayList) {
            ((ArrayList) zzfnVar2).ensureCapacity(zzfnVar2.size() + size2);
        } else if (zzfnVar2 instanceof zzgt) {
            zzgt zzgtVar = (zzgt) zzfnVar2;
            int i = zzgtVar.zzd + size2;
            int length = zzgtVar.zzc.length;
            if (i > length) {
                if (length != 0) {
                    while (length < i) {
                        length = Math.max(((length * 3) / 2) + 1, 10);
                    }
                    zzgtVar.zzc = Arrays.copyOf(zzgtVar.zzc, length);
                } else {
                    zzgtVar.zzc = new Object[Math.max(i, 10)];
                }
            }
        }
        int size3 = zzfnVar2.size();
        int size4 = arrayList.size();
        for (int i2 = 0; i2 < size4; i2++) {
            Object obj = arrayList.get(i2);
            if (obj == null) {
                String str = "Element at index " + (zzfnVar2.size() - size3) + " is null.";
                int size5 = zzfnVar2.size();
                while (true) {
                    size5--;
                    if (size5 < size3) {
                        break;
                    }
                    zzfnVar2.remove(size5);
                }
                throw new NullPointerException(str);
            }
            zzfnVar2.add(obj);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgu(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzdi.class});
        }
        if (i2 == 3) {
            return new zzdk();
        }
        if (i2 == 4) {
            return new zzfe(zzb);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
