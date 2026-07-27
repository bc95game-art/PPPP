package com.google.android.gms.internal.play_billing;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class zzo implements zzcz {
    public static final LazyKt__LazyJVMKt zzb;
    public static final Object zzh;
    public volatile Object zzc;
    public volatile zzh zzd;
    public volatile zzm zze;
    public static final boolean zza = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger zzg = Logger.getLogger(zzo.class.getName());

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.LazyKt__LazyJVMKt] */
    /* JADX WARN: Type inference failed for: r4v3 */
    static {
        zzj zzjVar;
        try {
            th = null;
            zzjVar = new zzj(AtomicReferenceFieldUpdater.newUpdater(zzm.class, Thread.class, "zzb"), AtomicReferenceFieldUpdater.newUpdater(zzm.class, zzm.class, "zzc"), AtomicReferenceFieldUpdater.newUpdater(zzo.class, zzm.class, "zze"), AtomicReferenceFieldUpdater.newUpdater(zzo.class, zzh.class, "zzd"), AtomicReferenceFieldUpdater.newUpdater(zzo.class, Object.class, "zzc"));
        } catch (Throwable th) {
            th = th;
            zzjVar = new Object();
        }
        Throwable th2 = th;
        zzb = zzjVar;
        if (th2 != null) {
            zzg.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        zzh = new Object();
    }

    public static void zzc(zzo zzoVar) {
        zzm zzmVar;
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt;
        zzh zzhVar;
        zzh zzhVar2;
        zzh zzhVar3;
        do {
            zzmVar = zzoVar.zze;
            lazyKt__LazyJVMKt = zzb;
        } while (!lazyKt__LazyJVMKt.zze(zzoVar, zzmVar, zzm.zza));
        while (true) {
            zzhVar = null;
            if (zzmVar == null) {
                break;
            }
            Thread thread = zzmVar.zzb;
            if (thread != null) {
                zzmVar.zzb = null;
                LockSupport.unpark(thread);
            }
            zzmVar = zzmVar.zzc;
        }
        do {
            zzhVar2 = zzoVar.zzd;
        } while (!lazyKt__LazyJVMKt.zzc(zzoVar, zzhVar2, zzh.zza));
        while (true) {
            zzhVar3 = zzhVar;
            zzhVar = zzhVar2;
            if (zzhVar != null) {
                zzhVar2 = zzhVar.zzd;
                zzhVar.zzd = zzhVar3;
            }
        }
        while (zzhVar3 != null) {
            Runnable runnable = zzhVar3.zzb;
            zzh zzhVar4 = zzhVar3.zzd;
            zzf(runnable, zzhVar3.zzc);
            zzhVar3 = zzhVar4;
        }
    }

    public static void zzf(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            zzg.logp(level, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "executeListener", "RuntimeException while executing runnable " + valueOf + " with executor " + valueOf2, (Throwable) e);
        }
    }

    public static final Object zzh(Object obj) {
        if (obj instanceof zze) {
            Throwable th = ((zze) obj).zzc;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzg) {
            throw new ExecutionException(((zzg) obj).zza);
        } else if (obj == zzh) {
            return null;
        } else {
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zze zzeVar;
        Object obj = this.zzc;
        if (obj != null) {
            return false;
        }
        if (zza) {
            zzeVar = new zze(new CancellationException("Future.cancel() was called."));
        } else if (z) {
            zzeVar = zze.zza;
        } else {
            zzeVar = zze.zzb;
        }
        if (!zzb.zzd(this, obj, zzeVar)) {
            return false;
        }
        zzc(this);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        java.util.concurrent.locks.LockSupport.park(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (java.lang.Thread.interrupted() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        r0 = r4.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
        return zzh(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
        zzg(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get() {
        if (!Thread.interrupted()) {
            Object obj = this.zzc;
            if (obj != null) {
                return zzh(obj);
            }
            zzm zzmVar = this.zze;
            zzm zzmVar2 = zzm.zza;
            if (zzmVar == zzmVar2) {
                return zzh(this.zzc);
            }
            zzm zzmVar3 = new zzm();
            do {
                LazyKt__LazyJVMKt lazyKt__LazyJVMKt = zzb;
                lazyKt__LazyJVMKt.zza(zzmVar3, zzmVar);
                if (lazyKt__LazyJVMKt.zze(this, zzmVar, zzmVar3)) {
                    break;
                }
                zzmVar = this.zze;
            } while (zzmVar != zzmVar2);
            return zzh(this.zzc);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzc instanceof zze;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzc != null;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.zzc instanceof zze) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zze(sb);
        } else {
            try {
                str = zza();
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: ".concat(String.valueOf(e.getClass()));
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                zze(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        return "remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzcz
    public final void zzb(Runnable runnable, Executor executor) {
        executor.getClass();
        zzh zzhVar = this.zzd;
        zzh zzhVar2 = zzh.zza;
        if (zzhVar != zzhVar2) {
            zzh zzhVar3 = new zzh(runnable, executor);
            do {
                zzhVar3.zzd = zzhVar;
                if (!zzb.zzc(this, zzhVar, zzhVar3)) {
                    zzhVar = this.zzd;
                } else {
                    return;
                }
            } while (zzhVar != zzhVar2);
            zzf(runnable, executor);
        }
        zzf(runnable, executor);
    }

    public final void zze(StringBuilder sb) {
        Object obj;
        String str;
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
            } catch (RuntimeException e) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e2) {
                sb.append("FAILURE, cause=[");
                sb.append(e2.getCause());
                sb.append("]");
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        if (obj == this) {
            str = "this future";
        } else {
            str = String.valueOf(obj);
        }
        sb.append(str);
        sb.append("]");
    }

    public final void zzg(zzm zzmVar) {
        zzmVar.zzb = null;
        while (true) {
            zzm zzmVar2 = this.zze;
            if (zzmVar2 != zzm.zza) {
                zzm zzmVar3 = null;
                while (zzmVar2 != null) {
                    zzm zzmVar4 = zzmVar2.zzc;
                    if (zzmVar2.zzb != null) {
                        zzmVar3 = zzmVar2;
                    } else if (zzmVar3 != null) {
                        zzmVar3.zzc = zzmVar4;
                        if (zzmVar3.zzb == null) {
                            break;
                        }
                    } else if (!zzb.zze(this, zzmVar2, zzmVar4)) {
                        break;
                    }
                    zzmVar2 = zzmVar4;
                }
                return;
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r12, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (java.lang.Thread.interrupted() != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        r0 = r12.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        return zzh(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        r0 = r4 - java.lang.System.nanoTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
        if (r0 >= 1000) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        zzg(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
        zzg(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.zzc;
            if (obj != null) {
                return zzh(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzm zzmVar = this.zze;
                zzm zzmVar2 = zzm.zza;
                if (zzmVar == zzmVar2) {
                    return zzh(this.zzc);
                }
                zzm zzmVar3 = new zzm();
                do {
                    LazyKt__LazyJVMKt lazyKt__LazyJVMKt = zzb;
                    lazyKt__LazyJVMKt.zza(zzmVar3, zzmVar);
                    if (lazyKt__LazyJVMKt.zze(this, zzmVar, zzmVar3)) {
                        break;
                    }
                    zzmVar = this.zze;
                } while (zzmVar != zzmVar2);
                return zzh(this.zzc);
            }
            while (nanos > 0) {
                Object obj2 = this.zzc;
                if (obj2 != null) {
                    return zzh(obj2);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzoVar = toString();
            String obj3 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj3.toLowerCase(locale);
            String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String concat = str.concat(" (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                boolean z = true;
                int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                if (i != 0 && nanos2 <= 1000) {
                    z = false;
                }
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
            throw new TimeoutException(str + " for " + zzoVar);
        }
        throw new InterruptedException();
    }
}
