package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public final class zzdp implements zzfl {
    public static final zzdp zza = new zzdp(0);
    public static final zzdp zza$1 = new zzdp(1);
    public static final zzdp zza$2 = new zzdp(2);
    public static final zzdp zza$3 = new zzdp(3);
    public static final zzdp zza$4 = new zzdp(4);
    public static final zzdp zza$5 = new zzdp(5);
    public static final zzdp zza$6 = new zzdp(6);
    public static final zzdp zza$7 = new zzdp(7);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzdp(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfl
    public final boolean zza(int i) {
        zzil zzilVar;
        switch (this.$r8$classId) {
            case 0:
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        return true;
                    default:
                        return false;
                }
            case 1:
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    default:
                        switch (i) {
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                                break;
                            default:
                                return false;
                        }
                }
                return true;
            case 2:
                if (ViewModelProvider.Factory.CC._zzb(i) != 0) {
                    return true;
                }
                return false;
            case 3:
                if (i == 0) {
                    zzilVar = zzil.zza;
                } else if (i == 1) {
                    zzilVar = zzil.zzb;
                } else if (i == 2) {
                    zzilVar = zzil.zzc;
                } else if (i != 3) {
                    zzilVar = null;
                } else {
                    zzilVar = zzil.zzd;
                }
                if (zzilVar != null) {
                    return true;
                }
                return false;
            case 4:
                if (i == 0 || i == 1 || i == 2 || i == 3) {
                    return true;
                }
                return false;
            case 5:
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        return true;
                    case 14:
                    case 15:
                    case 16:
                    default:
                        return false;
                }
            case 6:
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        return true;
                    default:
                        return false;
                }
            default:
                if (i == 0 || i == 1) {
                    return true;
                }
                return false;
        }
    }
}
