package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.internal.play_billing.zzck;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.LazyKt__LazyJVMKt;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class zzde extends zzck implements zzcj$zze {
    public zzcz zzd;
    public ScheduledFuture zze;

    public static Object zzc(Object obj) {
        if (obj instanceof zzcj$zza) {
            Throwable th = ((zzcj$zza) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzcj$zzc) {
            Throwable th2 = ((zzcj$zzc) obj).zzc;
            if (th2 == null) {
                zzck.zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "getDoneValue", "Failure.exception is unexpectedly null.");
                throw new ExecutionException(zzcj$zzc.zzb.zzc);
            }
            throw new ExecutionException(th2);
        } else if (obj == zzck.zza) {
            return null;
        } else {
            return obj;
        }
    }

    public static boolean zzh(Object obj) {
        if (!(obj instanceof zzcj$zzb)) {
            return true;
        }
        return false;
    }

    public static Object zzr(zzcz zzczVar) {
        Throwable e;
        Object obj;
        Throwable zze;
        if (zzczVar instanceof zzcj$zze) {
            Object obj2 = ((zzde) zzczVar).valueField;
            if (obj2 instanceof zzcj$zza) {
                zzcj$zza zzcj_zza = (zzcj$zza) obj2;
                if (zzcj_zza.zzc) {
                    Throwable th = zzcj_zza.zzd;
                    obj2 = th != null ? new zzcj$zza(false, th) : zzcj$zza.zzb;
                }
            }
            Objects.requireNonNull(obj2);
            return obj2;
        } else if ((zzczVar instanceof zzdf) && (zze = ((zzdf) zzczVar).zze()) != null) {
            return new zzcj$zzc(zze);
        } else {
            boolean isCancelled = zzczVar.isCancelled();
            if ((!zzck.zzc) && isCancelled) {
                zzcj$zza zzcj_zza2 = zzcj$zza.zzb;
                Objects.requireNonNull(zzcj_zza2);
                return zzcj_zza2;
            }
            boolean z = false;
            while (true) {
                try {
                    try {
                        try {
                            obj = zzczVar.get();
                            break;
                        } catch (Error e2) {
                            e = e2;
                            return new zzcj$zzc(e);
                        }
                    } catch (InterruptedException unused) {
                        z = true;
                    } catch (Throwable th2) {
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                        throw th2;
                    }
                } catch (Error | Exception e3) {
                    e = e3;
                    return new zzcj$zzc(e);
                } catch (CancellationException e4) {
                    if (!isCancelled) {
                        return new zzcj$zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(zzczVar)), e4));
                    }
                    return new zzcj$zza(false, e4);
                } catch (ExecutionException e5) {
                    if (isCancelled) {
                        return new zzcj$zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zzczVar)), e5));
                    }
                    return new zzcj$zzc(e5.getCause());
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            if (isCancelled) {
                return new zzcj$zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zzczVar))));
            }
            if (obj == null) {
                return zzck.zza;
            }
            return obj;
        }
    }

    public static void zzu(zzde zzdeVar) {
        boolean z;
        zzcj$zzd zzcj_zzd;
        zzcj$zzd zzcj_zzd2 = null;
        while (true) {
            zzdeVar.getClass();
            for (zzck.zze zzb = zzck.zzd.zzb(zzdeVar); zzb != null; zzb = zzb.next) {
                Thread thread = zzb.thread;
                if (thread != null) {
                    zzb.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            zzcz zzczVar = zzdeVar.zzd;
            boolean z2 = zzdeVar.valueField instanceof zzcj$zza;
            boolean z3 = true;
            if (zzczVar != null) {
                z = true;
            } else {
                z = false;
            }
            if (z2 && z) {
                Object obj = zzdeVar.valueField;
                if (!(obj instanceof zzcj$zza) || !((zzcj$zza) obj).zzc) {
                    z3 = false;
                }
                zzczVar.cancel(z3);
            }
            ScheduledFuture scheduledFuture = zzdeVar.zze;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            zzdeVar.zzd = null;
            zzdeVar.zze = null;
            zzcj$zzd zzcj_zzd3 = zzcj_zzd2;
            zzcj$zzd zza = zzck.zzd.zza(zzdeVar);
            zzcj$zzd zzcj_zzd4 = zzcj_zzd3;
            while (zza != null) {
                zzcj$zzd zzcj_zzd5 = zza.next;
                zza.next = zzcj_zzd4;
                zzcj_zzd4 = zza;
                zza = zzcj_zzd5;
            }
            while (zzcj_zzd4 != null) {
                Runnable runnable = zzcj_zzd4.zzb;
                zzcj_zzd = zzcj_zzd4.next;
                Objects.requireNonNull(runnable);
                if (runnable instanceof zzcj$zzb) {
                    zzcj$zzb zzcj_zzb = (zzcj$zzb) runnable;
                    zzdeVar = zzcj_zzb.zza;
                    if (zzdeVar.valueField == zzcj_zzb) {
                        if (zzck.zzd.zzf(zzdeVar, zzcj_zzb, zzr(zzcj_zzb.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzcj_zzd4.zzc;
                    Objects.requireNonNull(executor);
                    zzv(runnable, executor);
                }
                zzcj_zzd4 = zzcj_zzd;
            }
            return;
            zzcj_zzd2 = zzcj_zzd;
        }
    }

    public static void zzv(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            Logger zza = zzck.zzb.zza();
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            zza.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + valueOf + " with executor " + valueOf2, (Throwable) e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean cancel(boolean z) {
        boolean z2;
        zzcj$zza zzcj_zza;
        boolean z3;
        Object obj = this.valueField;
        boolean z4 = obj instanceof zzcj$zzb;
        if (obj == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z4 && !z2) {
            return false;
        }
        if (zzck.zzc) {
            zzcj_zza = new zzcj$zza(z, new CancellationException("Future.cancel() was called."));
        } else {
            if (z) {
                zzcj_zza = zzcj$zza.zza;
            } else {
                zzcj_zza = zzcj$zza.zzb;
            }
            Objects.requireNonNull(zzcj_zza);
        }
        boolean z5 = false;
        zzde zzdeVar = this;
        while (true) {
            if (zzck.zzd.zzf(zzdeVar, obj, zzcj_zza)) {
                zzu(zzdeVar);
                if (!(obj instanceof zzcj$zzb)) {
                    break;
                }
                zzcz zzczVar = ((zzcj$zzb) obj).zzb;
                if (!(zzczVar instanceof zzcj$zze)) {
                    zzczVar.cancel(z);
                    break;
                }
                zzdeVar = (zzde) zzczVar;
                obj = zzdeVar.valueField;
                if (obj == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3 && !(obj instanceof zzcj$zzb)) {
                    break;
                }
                z5 = true;
            } else {
                obj = zzdeVar.valueField;
                if (zzh(obj)) {
                    return z5;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
        java.util.concurrent.locks.LockSupport.park(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (java.lang.Thread.interrupted() != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        r0 = r6.valueField;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        if ((r1 & zzh(r0)) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        return zzc(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
        zza(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get() {
        zzck.zze zzeVar = zzck.zze.zza;
        if (!Thread.interrupted()) {
            Object obj = this.valueField;
            if ((obj != null) && zzh(obj)) {
                return zzc(obj);
            }
            zzck.zze zzeVar2 = this.waitersField;
            if (zzeVar2 != zzeVar) {
                zzck.zze zzeVar3 = new zzck.zze();
                do {
                    LazyKt__LazyJVMKt lazyKt__LazyJVMKt = zzck.zzd;
                    lazyKt__LazyJVMKt.zzc(zzeVar3, zzeVar2);
                    if (lazyKt__LazyJVMKt.zzg(this, zzeVar2, zzeVar3)) {
                        break;
                    }
                    zzeVar2 = this.waitersField;
                } while (zzeVar2 != zzeVar);
                Object obj2 = this.valueField;
                Objects.requireNonNull(obj2);
                return zzc(obj2);
            }
            Object obj22 = this.valueField;
            Objects.requireNonNull(obj22);
            return zzc(obj22);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.valueField instanceof zzcj$zza;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z;
        Object obj = this.valueField;
        boolean zzh = zzh(obj);
        if (obj != null) {
            z = true;
        } else {
            z = false;
        }
        return z & zzh;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
        if (r3.isEmpty() != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.valueField instanceof zzcj$zza) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzt(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof zzcj$zzb) {
                sb.append(", setFuture=[");
                zzcz zzczVar = ((zzcj$zzb) obj).zzb;
                try {
                    if (zzczVar == this) {
                        sb.append("this future");
                    } else {
                        sb.append(zzczVar);
                    }
                } catch (Throwable th) {
                    if (!(th instanceof Error) || (th instanceof StackOverflowError)) {
                        sb.append("Exception thrown from implementation: ");
                        sb.append(th.getClass());
                    } else {
                        throw th;
                    }
                }
                sb.append("]");
            } else {
                try {
                    str = zzd();
                    if (str != null) {
                    }
                    str = null;
                } catch (Throwable th2) {
                    if (!(th2 instanceof Error) || (th2 instanceof StackOverflowError)) {
                        str = "Exception thrown from implementation: ".concat(String.valueOf(th2.getClass()));
                    } else {
                        throw th2;
                    }
                }
                if (str != null) {
                    sb.append(", info=[");
                    sb.append(str);
                    sb.append("]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzt(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcz
    public final void zzb(Runnable runnable, Executor executor) {
        zzcj$zzd zzcj_zzd;
        zzcj$zzd zzcj_zzd2 = zzcj$zzd.zza;
        if (executor == null) {
            throw new NullPointerException("Executor was null.");
        } else if (isDone() || (zzcj_zzd = this.listenersField) == zzcj_zzd2) {
            zzv(runnable, executor);
        } else {
            zzcj$zzd zzcj_zzd3 = new zzcj$zzd(runnable, executor);
            do {
                zzcj_zzd3.next = zzcj_zzd;
                if (!zzck.zzd.zze(this, zzcj_zzd, zzcj_zzd3)) {
                    zzcj_zzd = this.listenersField;
                } else {
                    return;
                }
            } while (zzcj_zzd != zzcj_zzd2);
            zzv(runnable, executor);
        }
    }

    public final String zzd() {
        zzcz zzczVar = this.zzd;
        ScheduledFuture scheduledFuture = this.zze;
        if (zzczVar == null) {
            return null;
        }
        String m = ViewModelProvider.Factory.CC.m595m("inputFuture=[", zzczVar.toString(), "]");
        if (scheduledFuture == null) {
            return m;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return m;
        }
        return m + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    public final Throwable zze() {
        if (!(this instanceof zzcj$zze)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof zzcj$zzc) {
            return ((zzcj$zzc) obj).zzc;
        }
        return null;
    }

    public final void zzt(StringBuilder sb) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (ExecutionException e) {
                sb.append("FAILURE, cause=[");
                sb.append(e.getCause());
                sb.append("]");
                return;
            } catch (Exception e2) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e2.getClass());
                sb.append(" thrown from get()]");
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        if (obj == null) {
            sb.append("null");
        } else if (obj == this) {
            sb.append("this future");
        } else {
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
        sb.append("]");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00c0 -> B:37:0x0080). Please submit an issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(long j, TimeUnit timeUnit) {
        long j2;
        long nanoTime;
        zzck.zze zzeVar = zzck.zze.zza;
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.valueField;
            if ((obj != null) && zzh(obj)) {
                return zzc(obj);
            }
            long j3 = 0;
            long nanoTime2 = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzck.zze zzeVar2 = this.waitersField;
                if (zzeVar2 != zzeVar) {
                    zzck.zze zzeVar3 = new zzck.zze();
                    while (true) {
                        LazyKt__LazyJVMKt lazyKt__LazyJVMKt = zzck.zzd;
                        lazyKt__LazyJVMKt.zzc(zzeVar3, zzeVar2);
                        if (lazyKt__LazyJVMKt.zzg(this, zzeVar2, zzeVar3)) {
                            j2 = j3;
                            while (true) {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.valueField;
                                    if ((obj2 != null) && zzh(obj2)) {
                                        return zzc(obj2);
                                    }
                                    nanoTime = nanoTime2 - System.nanoTime();
                                    if (nanoTime < 1000) {
                                        zza(zzeVar3);
                                        break;
                                    }
                                    nanos = nanoTime;
                                } else {
                                    zza(zzeVar3);
                                    throw new InterruptedException();
                                }
                            }
                        } else {
                            j3 = j3;
                            zzeVar2 = this.waitersField;
                            if (zzeVar2 == zzeVar) {
                                break;
                            }
                        }
                    }
                    nanos = nanoTime;
                    if (nanos <= j2) {
                        String zzdeVar = toString();
                        String obj3 = timeUnit.toString();
                        Locale locale = Locale.ROOT;
                        String lowerCase = obj3.toLowerCase(locale);
                        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
                        if (nanos + 1000 < j2) {
                            String concat = str.concat(" (plus ");
                            long j4 = -nanos;
                            long convert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
                            long nanos2 = j4 - timeUnit.toNanos(convert);
                            int i = (convert > j2 ? 1 : (convert == j2 ? 0 : -1));
                            boolean z = i == 0 || nanos2 > 1000;
                            if (i > 0) {
                                String str2 = concat + convert + " " + lowerCase;
                                if (z) {
                                    str2 = str2.concat(",");
                                }
                                concat = str2.concat(" ");
                            }
                            if (z) {
                                concat = concat + nanos2 + " nanoseconds ";
                            }
                            str = concat.concat("delay)");
                        }
                        if (isDone()) {
                            throw new TimeoutException(str.concat(" but future completed as timeout expired"));
                        }
                        throw new TimeoutException(str + " for " + zzdeVar);
                    }
                    Object obj4 = this.valueField;
                    if ((obj4 != null) && zzh(obj4)) {
                        return zzc(obj4);
                    }
                    if (!Thread.interrupted()) {
                        nanoTime = nanoTime2 - System.nanoTime();
                        nanos = nanoTime;
                        if (nanos <= j2) {
                        }
                    } else {
                        throw new InterruptedException();
                    }
                }
                Object obj5 = this.valueField;
                Objects.requireNonNull(obj5);
                return zzc(obj5);
            }
            j2 = 0;
            if (nanos <= j2) {
            }
        } else {
            throw new InterruptedException();
        }
    }
}
