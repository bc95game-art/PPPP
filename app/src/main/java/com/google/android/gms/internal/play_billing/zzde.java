package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.internal.play_billing.zzck;
import j$.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.valueField
            boolean r1 = r0 instanceof com.google.android.gms.internal.play_billing.zzcj$zzb
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = 1
            goto Lb
        La:
            r4 = 0
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L60
            boolean r1 = com.google.android.gms.internal.play_billing.zzck.zzc
            if (r1 == 0) goto L1f
            com.google.android.gms.internal.play_billing.zzcj$zza r1 = new com.google.android.gms.internal.play_billing.zzcj$zza
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L29
        L1f:
            if (r8 == 0) goto L24
            com.google.android.gms.internal.play_billing.zzcj$zza r1 = com.google.android.gms.internal.play_billing.zzcj$zza.zza
            goto L26
        L24:
            com.google.android.gms.internal.play_billing.zzcj$zza r1 = com.google.android.gms.internal.play_billing.zzcj$zza.zzb
        L26:
            j$.util.Objects.requireNonNull(r1)
        L29:
            r5 = 0
            r4 = r7
        L2b:
            kotlin.LazyKt__LazyJVMKt r6 = com.google.android.gms.internal.play_billing.zzck.zzd
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L57
            zzu(r4)
            boolean r4 = r0 instanceof com.google.android.gms.internal.play_billing.zzcj$zzb
            if (r4 == 0) goto L56
            com.google.android.gms.internal.play_billing.zzcj$zzb r0 = (com.google.android.gms.internal.play_billing.zzcj$zzb) r0
            com.google.android.gms.internal.play_billing.zzcz r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.play_billing.zzcj$zze
            if (r4 == 0) goto L53
            r4 = r0
            com.google.android.gms.internal.play_billing.zzde r4 = (com.google.android.gms.internal.play_billing.zzde) r4
            java.lang.Object r0 = r4.valueField
            if (r0 != 0) goto L4b
            r5 = 1
            goto L4c
        L4b:
            r5 = 0
        L4c:
            boolean r6 = r0 instanceof com.google.android.gms.internal.play_billing.zzcj$zzb
            r5 = r5 | r6
            if (r5 == 0) goto L56
            r5 = 1
            goto L2b
        L53:
            r0.cancel(r8)
        L56:
            return r3
        L57:
            java.lang.Object r0 = r4.valueField
            boolean r6 = zzh(r0)
            if (r6 == 0) goto L2b
            return r5
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzde.cancel(boolean):boolean");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get() {
        /*
            r6 = this;
            com.google.android.gms.internal.play_billing.zzck$zze r0 = com.google.android.gms.internal.play_billing.zzck.zze.zza
            boolean r1 = java.lang.Thread.interrupted()
            if (r1 != 0) goto L64
            java.lang.Object r1 = r6.valueField
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L10
            r4 = 1
            goto L11
        L10:
            r4 = 0
        L11:
            boolean r5 = zzh(r1)
            r4 = r4 & r5
            if (r4 == 0) goto L1d
            java.lang.Object r0 = zzc(r1)
            return r0
        L1d:
            com.google.android.gms.internal.play_billing.zzck$zze r1 = r6.waitersField
            if (r1 == r0) goto L5a
            com.google.android.gms.internal.play_billing.zzck$zze r4 = new com.google.android.gms.internal.play_billing.zzck$zze
            r4.<init>()
        L26:
            kotlin.LazyKt__LazyJVMKt r5 = com.google.android.gms.internal.play_billing.zzck.zzd
            r5.zzc(r4, r1)
            boolean r1 = r5.zzg(r6, r1, r4)
            if (r1 == 0) goto L56
        L31:
            java.util.concurrent.locks.LockSupport.park(r6)
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L4d
            java.lang.Object r0 = r6.valueField
            if (r0 == 0) goto L40
            r1 = 1
            goto L41
        L40:
            r1 = 0
        L41:
            boolean r5 = zzh(r0)
            r1 = r1 & r5
            if (r1 == 0) goto L31
            java.lang.Object r0 = zzc(r0)
            return r0
        L4d:
            r6.zza(r4)
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        L56:
            com.google.android.gms.internal.play_billing.zzck$zze r1 = r6.waitersField
            if (r1 != r0) goto L26
        L5a:
            java.lang.Object r0 = r6.valueField
            j$.util.Objects.requireNonNull(r0)
            java.lang.Object r0 = zzc(r0)
            return r0
        L64:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzde.get():java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r1 = r6.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "com.google.common.util.concurrent."
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L21
            java.lang.Class r1 = r6.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            goto L2c
        L21:
            java.lang.Class r1 = r6.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
        L2c:
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r6)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r1 = "[status="
            r0.append(r1)
            java.lang.Object r1 = r6.valueField
            boolean r1 = r1 instanceof com.google.android.gms.internal.play_billing.zzcj$zza
            java.lang.String r2 = "]"
            if (r1 == 0) goto L50
            java.lang.String r1 = "CANCELLED"
            r0.append(r1)
            goto Le2
        L50:
            boolean r1 = r6.isDone()
            if (r1 == 0) goto L5b
            r6.zzt(r0)
            goto Le2
        L5b:
            int r1 = r0.length()
            java.lang.String r3 = "PENDING"
            r0.append(r3)
            java.lang.Object r3 = r6.valueField
            boolean r4 = r3 instanceof com.google.android.gms.internal.play_billing.zzcj$zzb
            java.lang.String r5 = "Exception thrown from implementation: "
            if (r4 == 0) goto L9d
            java.lang.String r4 = ", setFuture=["
            r0.append(r4)
            com.google.android.gms.internal.play_billing.zzcj$zzb r3 = (com.google.android.gms.internal.play_billing.zzcj$zzb) r3
            com.google.android.gms.internal.play_billing.zzcz r3 = r3.zzb
            if (r3 != r6) goto L7f
            java.lang.String r3 = "this future"
            r0.append(r3)     // Catch: java.lang.Throwable -> L7d
            goto L99
        L7d:
            r3 = move-exception
            goto L83
        L7f:
            r0.append(r3)     // Catch: java.lang.Throwable -> L7d
            goto L99
        L83:
            boolean r4 = r3 instanceof java.lang.Error
            if (r4 == 0) goto L8f
            boolean r4 = r3 instanceof java.lang.StackOverflowError
            if (r4 == 0) goto L8c
            goto L8f
        L8c:
            java.lang.Error r3 = (java.lang.Error) r3
            throw r3
        L8f:
            r0.append(r5)
            java.lang.Class r3 = r3.getClass()
            r0.append(r3)
        L99:
            r0.append(r2)
            goto Ld2
        L9d:
            java.lang.String r3 = r6.zzd()     // Catch: java.lang.Throwable -> Lac
            r4 = 0
            if (r3 == 0) goto Laa
            boolean r5 = r3.isEmpty()     // Catch: java.lang.Throwable -> Lac
            if (r5 == 0) goto Lc5
        Laa:
            r3 = r4
            goto Lc5
        Lac:
            r3 = move-exception
            boolean r4 = r3 instanceof java.lang.Error
            if (r4 == 0) goto Lb9
            boolean r4 = r3 instanceof java.lang.StackOverflowError
            if (r4 == 0) goto Lb6
            goto Lb9
        Lb6:
            java.lang.Error r3 = (java.lang.Error) r3
            throw r3
        Lb9:
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r5.concat(r3)
        Lc5:
            if (r3 == 0) goto Ld2
            java.lang.String r4 = ", info=["
            r0.append(r4)
            r0.append(r3)
            r0.append(r2)
        Ld2:
            boolean r3 = r6.isDone()
            if (r3 == 0) goto Le2
            int r3 = r0.length()
            r0.delete(r1, r3)
            r6.zzt(r0)
        Le2:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzde.toString():java.lang.String");
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
        String m = ViewModelProvider.Factory.CC.m("inputFuture=[", zzczVar.toString(), "]");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(long r20, java.util.concurrent.TimeUnit r22) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzde.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }
}
