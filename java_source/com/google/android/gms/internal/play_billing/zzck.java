package com.google.android.gms.internal.play_billing;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.LazyKt__LazyJVMKt;
import sun.misc.Unsafe;
/* loaded from: classes.dex */
public abstract class zzck extends zzdf implements zzcz {
    public static final Object zza = new Object();
    public static final zzcy zzb = new zzcy(zzde.class);
    public static final boolean zzc;
    public static final LazyKt__LazyJVMKt zzd;
    public volatile zzcj$zzd listenersField;
    public volatile Object valueField;
    public volatile zze waitersField;

    /* loaded from: classes.dex */
    public final class zzb extends LazyKt__LazyJVMKt {
        public static final AtomicReferenceFieldUpdater zza = AtomicReferenceFieldUpdater.newUpdater(zze.class, Thread.class, "thread");
        public static final AtomicReferenceFieldUpdater zzb = AtomicReferenceFieldUpdater.newUpdater(zze.class, zze.class, "next");
        public static final AtomicReferenceFieldUpdater zzc = AtomicReferenceFieldUpdater.newUpdater(zzck.class, zze.class, "waitersField");
        public static final AtomicReferenceFieldUpdater zzd = AtomicReferenceFieldUpdater.newUpdater(zzck.class, zzcj$zzd.class, "listenersField");
        public static final AtomicReferenceFieldUpdater zze = AtomicReferenceFieldUpdater.newUpdater(zzck.class, Object.class, "valueField");

        @Override // kotlin.LazyKt__LazyJVMKt
        public final zzcj$zzd zza(zzde zzdeVar) {
            return (zzcj$zzd) zzd.getAndSet(zzdeVar, zzcj$zzd.zza);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final zze zzb(zzde zzdeVar) {
            return (zze) zzc.getAndSet(zzdeVar, zze.zza);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final void zzc(zze zzeVar, zze zzeVar2) {
            zzb.lazySet(zzeVar, zzeVar2);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final void zzd(zze zzeVar, Thread thread) {
            zza.lazySet(zzeVar, thread);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zze(zzde zzdeVar, zzcj$zzd zzcj_zzd, zzcj$zzd zzcj_zzd2) {
            return LazyKt__LazyJVMKt.zza(zzd, zzdeVar, zzcj_zzd, zzcj_zzd2);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zzf(zzck zzckVar, Object obj, Object obj2) {
            return LazyKt__LazyJVMKt.zza(zze, zzckVar, obj, obj2);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zzg(zzck zzckVar, zze zzeVar, zze zzeVar2) {
            return LazyKt__LazyJVMKt.zza(zzc, zzckVar, zzeVar, zzeVar2);
        }
    }

    /* loaded from: classes.dex */
    public final class zzc extends LazyKt__LazyJVMKt {
        @Override // kotlin.LazyKt__LazyJVMKt
        public final zzcj$zzd zza(zzde zzdeVar) {
            zzcj$zzd zzcj_zzd;
            zzcj$zzd zzcj_zzd2 = zzcj$zzd.zza;
            synchronized (zzdeVar) {
                try {
                    zzcj_zzd = zzdeVar.listenersField;
                    if (zzcj_zzd != zzcj_zzd2) {
                        zzdeVar.listenersField = zzcj_zzd2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzcj_zzd;
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final zze zzb(zzde zzdeVar) {
            zze zzeVar;
            zze zzeVar2 = zze.zza;
            synchronized (zzdeVar) {
                try {
                    zzeVar = zzdeVar.waitersField;
                    if (zzeVar != zzeVar2) {
                        zzdeVar.waitersField = zzeVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzeVar;
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final void zzc(zze zzeVar, zze zzeVar2) {
            zzeVar.next = zzeVar2;
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final void zzd(zze zzeVar, Thread thread) {
            zzeVar.thread = thread;
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zze(zzde zzdeVar, zzcj$zzd zzcj_zzd, zzcj$zzd zzcj_zzd2) {
            synchronized (zzdeVar) {
                try {
                    if (zzdeVar.listenersField != zzcj_zzd) {
                        return false;
                    }
                    zzdeVar.listenersField = zzcj_zzd2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zzf(zzck zzckVar, Object obj, Object obj2) {
            synchronized (zzckVar) {
                try {
                    if (zzckVar.valueField != obj) {
                        return false;
                    }
                    zzckVar.valueField = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zzg(zzck zzckVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzckVar) {
                try {
                    if (zzckVar.waitersField != zzeVar) {
                        return false;
                    }
                    zzckVar.waitersField = zzeVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class zzd extends LazyKt__LazyJVMKt {
        public static final Unsafe zza;
        public static final long zzb;
        public static final long zzc;
        public static final long zzd;
        public static final long zze;
        public static final long zzf;

        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.security.PrivilegedExceptionAction] */
        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e) {
                    throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged((PrivilegedExceptionAction<Object>) new Object());
            }
            try {
                zzc = unsafe.objectFieldOffset(zzck.class.getDeclaredField("waitersField"));
                zzb = unsafe.objectFieldOffset(zzck.class.getDeclaredField("listenersField"));
                zzd = unsafe.objectFieldOffset(zzck.class.getDeclaredField("valueField"));
                zze = unsafe.objectFieldOffset(zze.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zze.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final zzcj$zzd zza(zzde zzdeVar) {
            zzcj$zzd zzcj_zzd;
            zzcj$zzd zzcj_zzd2 = zzcj$zzd.zza;
            do {
                zzcj_zzd = zzdeVar.listenersField;
                if (zzcj_zzd2 == zzcj_zzd) {
                    break;
                }
            } while (!zze(zzdeVar, zzcj_zzd, zzcj_zzd2));
            return zzcj_zzd;
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final zze zzb(zzde zzdeVar) {
            zze zzeVar;
            zze zzeVar2 = zze.zza;
            do {
                zzeVar = zzdeVar.waitersField;
                if (zzeVar2 == zzeVar) {
                    break;
                }
            } while (!zzg(zzdeVar, zzeVar, zzeVar2));
            return zzeVar;
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final void zzc(zze zzeVar, zze zzeVar2) {
            zza.putObject(zzeVar, zzf, zzeVar2);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final void zzd(zze zzeVar, Thread thread) {
            zza.putObject(zzeVar, zze, thread);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zze(zzde zzdeVar, zzcj$zzd zzcj_zzd, zzcj$zzd zzcj_zzd2) {
            return zzcm.zza(zza, zzdeVar, zzb, zzcj_zzd, zzcj_zzd2);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zzf(zzck zzckVar, Object obj, Object obj2) {
            return zzcm.zza(zza, zzckVar, zzd, obj, obj2);
        }

        @Override // kotlin.LazyKt__LazyJVMKt
        public final boolean zzg(zzck zzckVar, zze zzeVar, zze zzeVar2) {
            return zzcm.zza(zza, zzckVar, zzc, zzeVar, zzeVar2);
        }
    }

    /* loaded from: classes.dex */
    public final class zze {
        public static final zze zza = new Object();
        public volatile zze next;
        public volatile Thread thread;

        public zze() {
            zzck.zzd.zzd(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [kotlin.LazyKt__LazyJVMKt] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    static {
        boolean z;
        Object obj;
        Throwable th;
        Throwable th2;
        ?? r0;
        Object obj2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zzc = z;
        String property = System.getProperty("java.runtime.name", "");
        Throwable th3 = null;
        if (property == null || property.contains("Android")) {
            try {
                obj2 = new Object();
            } catch (Error | Exception e) {
                try {
                    obj = new Object();
                } catch (Error | Exception e2) {
                    th3 = e2;
                    obj = new Object();
                }
                th = th3;
                th2 = e;
                r0 = obj;
            }
        } else {
            try {
                obj2 = new Object();
            } catch (NoClassDefFoundError unused2) {
                obj2 = new Object();
            }
        }
        th = null;
        th2 = null;
        r0 = obj2;
        zzd = r0;
        if (th != null) {
            zzcy zzcyVar = zzb;
            Logger zza2 = zzcyVar.zza();
            Level level = Level.SEVERE;
            zza2.logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzcyVar.zza().logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th);
        }
    }

    public final void zza(zze zzeVar) {
        zzeVar.thread = null;
        while (true) {
            zze zzeVar2 = this.waitersField;
            if (zzeVar2 != zze.zza) {
                zze zzeVar3 = null;
                while (zzeVar2 != null) {
                    zze zzeVar4 = zzeVar2.next;
                    if (zzeVar2.thread != null) {
                        zzeVar3 = zzeVar2;
                    } else if (zzeVar3 != null) {
                        zzeVar3.next = zzeVar4;
                        if (zzeVar3.thread == null) {
                            break;
                        }
                    } else if (!zzd.zzg(this, zzeVar2, zzeVar4)) {
                        break;
                    }
                    zzeVar2 = zzeVar4;
                }
                return;
            }
            return;
        }
    }
}
