package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class zzfi extends zzds {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzhi zzc = zzhi.zza;

    public zzfi() {
        this.zza = 0;
    }

    public static final boolean zzA(zzfi zzfiVar, boolean z) {
        byte byteValue = ((Byte) zzfiVar.zzb(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgs.zzb.zzb(zzfiVar.getClass()).zzk(zzfiVar);
        if (z) {
            zzfiVar.zzb(2);
        }
        return zzk;
    }

    public static zzfi zzn(Class cls) {
        Map map = zzb;
        zzfi zzfiVar = (zzfi) map.get(cls);
        if (zzfiVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfiVar = (zzfi) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfiVar != null) {
            return zzfiVar;
        }
        zzfi zzfiVar2 = (zzfi) ((zzfi) zzho.zze(cls)).zzb(6);
        if (zzfiVar2 != null) {
            map.put(cls, zzfiVar2);
            return zzfiVar2;
        }
        throw new IllegalStateException();
    }

    public static Object zzs(Method method, zzfi zzfiVar, Object... objArr) {
        try {
            return method.invoke(zzfiVar, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static void zzw(Class cls, zzfi zzfiVar) {
        zzfiVar.zzv();
        zzb.put(cls, zzfiVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgs.zzb.zzb(getClass()).zzj(this, (zzfi) obj);
    }

    public final int hashCode() {
        if (zzz()) {
            return zzgs.zzb.zzb(getClass()).zzb(this);
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzb2 = zzgs.zzb.zzb(getClass()).zzb(this);
        this.zza = zzb2;
        return zzb2;
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = zzgn.zza;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        zzgn.zzd(this, sb, 0);
        return sb.toString();
    }

    public abstract Object zzb(int i);

    @Override // com.google.android.gms.internal.play_billing.zzds
    public final int zze(zzgv zzgvVar) {
        if (zzz()) {
            int zza = zzgvVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException(ViewModelProvider.Factory.CC.m(zza, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzgvVar.zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException(ViewModelProvider.Factory.CC.m(zza2, "serialized size must be non-negative, was "));
    }

    public final int zzj() {
        if (zzz()) {
            int zza = zzgs.zzb.zzb(getClass()).zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException(ViewModelProvider.Factory.CC.m(zza, "serialized size must be non-negative, was "));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zza2 = zzgs.zzb.zzb(getClass()).zza(this);
        if (zza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
            return zza2;
        }
        throw new IllegalStateException(ViewModelProvider.Factory.CC.m(zza2, "serialized size must be non-negative, was "));
    }

    public final zzfe zzl() {
        return (zzfe) zzb(5);
    }

    public final zzfe zzm() {
        zzfe zzfeVar = (zzfe) zzb(5);
        if (!zzfeVar.zzb.equals(this)) {
            if (!zzfeVar.zza.zzz()) {
                zzfi zzfiVar = (zzfi) zzfeVar.zzb.zzb(4);
                zzgs.zzb.zzb(zzfiVar.getClass()).zzg(zzfiVar, zzfeVar.zza);
                zzfeVar.zza = zzfiVar;
            }
            zzfi zzfiVar2 = zzfeVar.zza;
            zzgs.zzb.zzb(zzfiVar2.getClass()).zzg(zzfiVar2, this);
        }
        return zzfeVar;
    }

    public final void zzv() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzx() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzz() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
