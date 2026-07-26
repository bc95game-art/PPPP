package com.google.android.gms.internal.play_billing;

import java.io.IOException;
/* loaded from: classes.dex */
public final class zzhx extends zzfi {
    private static final zzhx zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private zzig zzh;
    private int zzi;

    static {
        zzhx zzhxVar = new zzhx();
        zzb = zzhxVar;
        zzfi.zzw(zzhx.class, zzhxVar);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.internal.play_billing.zzdw, java.lang.Object] */
    public static zzhx zzA(byte[] bArr, zzeu zzeuVar) {
        zzhx zzhxVar = zzb;
        int length = bArr.length;
        if (length != 0) {
            Object obj = (zzfi) zzhxVar.zzb(4);
            try {
                zzgv zzb2 = zzgs.zzb.zzb(obj.getClass());
                ?? obj2 = new Object();
                zzeuVar.getClass();
                zzb2.zzh(obj, bArr, 0, length, obj2);
                zzb2.zzf(obj);
                zzhxVar = obj;
            } catch (zzfq e) {
                throw e;
            } catch (zzhg e2) {
                throw new IOException(e2.getMessage());
            } catch (IOException e3) {
                if (e3.getCause() instanceof zzfq) {
                    throw ((zzfq) e3.getCause());
                }
                throw new IOException(e3.getMessage(), e3);
            } catch (IndexOutOfBoundsException unused) {
                throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
        }
        if (zzhxVar == null || zzfi.zzA(zzhxVar, true)) {
            return zzhxVar;
        }
        throw new IOException(new zzhg().getMessage());
    }

    public static void zzC(zzhx zzhxVar, zzil zzilVar) {
        zzhxVar.zzi = zzilVar.zzf;
        zzhxVar.zzd |= 4;
    }

    public static /* synthetic */ void zzD(zzhx zzhxVar, zzig zzigVar) {
        zzhxVar.zzh = zzigVar;
        zzhxVar.zzd |= 2;
    }

    public static /* synthetic */ void zzF(zzhx zzhxVar, zzjf zzjfVar) {
        zzhxVar.zzf = zzjfVar;
        zzhxVar.zze = 7;
    }

    public static /* synthetic */ void zzG(zzhx zzhxVar, zzjv zzjvVar) {
        zzhxVar.zzf = zzjvVar;
        zzhxVar.zze = 6;
    }

    public static /* synthetic */ void zzH(zzhx zzhxVar, int i) {
        zzhxVar.zzg = i - 1;
        zzhxVar.zzd |= 1;
    }

    public static zzhv zzc() {
        return (zzhv) zzb.zzl();
    }

    public final zzjf zzB() {
        if (this.zze == 7) {
            return (zzjf) this.zzf;
        }
        return zzjf.zzd();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgu(zzb, "\u0004\u0006\u0001\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000\u0005᠌\u0002\u0006<\u0000\u0007<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzdp.zza$1, "zzh", zziz.class, "zzi", zzdp.zza$3, zzjv.class, zzjf.class});
        }
        if (i2 == 3) {
            return new zzhx();
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
