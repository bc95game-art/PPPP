package androidx.concurrent.futures;

import androidx.core.p002os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture implements Future {
    public static final BundleKt ATOMIC_HELPER;
    public static final Object NULL;
    public volatile Listener listeners;
    public volatile Object value;
    public volatile Waiter waiters;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger log = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* loaded from: classes.dex */
    public final class Cancellation {
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public final Throwable cause;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
                return;
            }
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        public Cancellation(boolean z, Throwable th) {
            this.cause = th;
        }
    }

    /* loaded from: classes.dex */
    public abstract class Failure {
    }

    /* loaded from: classes.dex */
    public final class Listener {
        public static final Listener TOMBSTONE = new Object();
        public Listener next;
    }

    /* loaded from: classes.dex */
    public final class SafeAtomicHelper extends BundleKt {
        public final AtomicReferenceFieldUpdater listenersUpdater;
        public final AtomicReferenceFieldUpdater valueUpdater;
        public final AtomicReferenceFieldUpdater waiterNextUpdater;
        public final AtomicReferenceFieldUpdater waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.core.p002os.BundleKt
        public final boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, Listener listener) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.listenersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, listener, Listener.TOMBSTONE)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == listener);
            return false;
        }

        @Override // androidx.core.p002os.BundleKt
        public final boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.valueUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == obj);
            return false;
        }

        @Override // androidx.core.p002os.BundleKt
        public final boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.waitersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, waiter, waiter2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == waiter);
            return false;
        }

        @Override // androidx.core.p002os.BundleKt
        public final void putNext(Waiter waiter, Waiter waiter2) {
            this.waiterNextUpdater.lazySet(waiter, waiter2);
        }

        @Override // androidx.core.p002os.BundleKt
        public final void putThread(Waiter waiter, Thread thread) {
            this.waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    /* loaded from: classes.dex */
    public final class SynchronizedHelper extends BundleKt {
        @Override // androidx.core.p002os.BundleKt
        public final boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, Listener listener) {
            Listener listener2 = Listener.TOMBSTONE;
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.listeners != listener) {
                        return false;
                    }
                    abstractResolvableFuture.listeners = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.value != obj) {
                        return false;
                    }
                    abstractResolvableFuture.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.waiters != waiter) {
                        return false;
                    }
                    abstractResolvableFuture.waiters = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void putNext(Waiter waiter, Waiter waiter2) {
            waiter.next = waiter2;
        }

        @Override // androidx.core.p002os.BundleKt
        public final void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }
    }

    /* loaded from: classes.dex */
    public final class Waiter {
        public static final Waiter TOMBSTONE = new Object();
        public volatile Waiter next;
        public volatile Thread thread;

        public Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        SafeAtomicHelper safeAtomicHelper;
        Throwable th;
        try {
            th = null;
            safeAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "value"));
        } catch (Throwable th2) {
            th = th2;
            safeAtomicHelper = new Object();
        }
        ATOMIC_HELPER = safeAtomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    public static void complete(AbstractResolvableFuture abstractResolvableFuture) {
        Waiter waiter;
        Listener listener;
        do {
            waiter = abstractResolvableFuture.waiters;
        } while (!ATOMIC_HELPER.casWaiters(abstractResolvableFuture, waiter, Waiter.TOMBSTONE));
        while (waiter != null) {
            Thread thread = waiter.thread;
            if (thread != null) {
                waiter.thread = null;
                LockSupport.unpark(thread);
            }
            waiter = waiter.next;
        }
        do {
            listener = abstractResolvableFuture.listeners;
        } while (!ATOMIC_HELPER.casListeners(abstractResolvableFuture, listener));
        Listener listener2 = null;
        while (listener != null) {
            Listener listener3 = listener.next;
            listener.next = listener2;
            listener2 = listener;
            listener = listener3;
        }
        while (listener2 != null) {
            listener2 = listener2.next;
            try {
                throw null;
                break;
            } catch (RuntimeException e) {
                log.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e);
            }
        }
    }

    public static Object getDoneValue(Object obj) {
        if (obj instanceof Cancellation) {
            Throwable th = ((Cancellation) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof Failure) {
            throw new ExecutionException((Throwable) null);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public static Object getUninterruptibly(AbstractResolvableFuture abstractResolvableFuture) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = abstractResolvableFuture.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void addDoneString(StringBuilder sb) {
        String str;
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            if (uninterruptibly == this) {
                str = "this future";
            } else {
                str = String.valueOf(uninterruptibly);
            }
            sb.append(str);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Cancellation cancellation;
        Object obj = this.value;
        if (obj != null) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cancellation = new Cancellation(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            cancellation = Cancellation.CAUSELESS_INTERRUPTED;
        } else {
            cancellation = Cancellation.CAUSELESS_CANCELLED;
        }
        if (!ATOMIC_HELPER.casValue(this, obj, cancellation)) {
            return false;
        }
        complete(this);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r17, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (java.lang.Thread.interrupted() != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        r4 = r17.value;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r4 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        return getDoneValue(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
        r4 = r9 - java.lang.System.nanoTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        if (r4 >= 1000) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
        removeWaiter(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0063, code lost:
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
        removeWaiter(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(long j, TimeUnit timeUnit) {
        Locale locale;
        Waiter waiter = Waiter.TOMBSTONE;
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if (obj != null) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                Waiter waiter2 = this.waiters;
                if (waiter2 == waiter) {
                    return getDoneValue(this.value);
                }
                Waiter waiter3 = new Waiter();
                do {
                    BundleKt bundleKt = ATOMIC_HELPER;
                    bundleKt.putNext(waiter3, waiter2);
                    if (bundleKt.casWaiters(this, waiter2, waiter3)) {
                        break;
                    }
                    waiter2 = this.waiters;
                } while (waiter2 != waiter);
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj2 = this.value;
                if (obj2 != null) {
                    return getDoneValue(obj2);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String m = ViewModelProvider.Factory.CC.m596m(str, " (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String str2 = m + convert + " " + lowerCase;
                    if (z) {
                        str2 = ViewModelProvider.Factory.CC.m596m(str2, ",");
                    }
                    m = ViewModelProvider.Factory.CC.m596m(str2, " ");
                }
                if (z) {
                    m = m + nanos2 + " nanoseconds ";
                }
                str = ViewModelProvider.Factory.CC.m596m(m, "delay)");
            }
            if (isDone()) {
                throw new TimeoutException(ViewModelProvider.Factory.CC.m596m(str, " but future completed as timeout expired"));
            }
            throw new TimeoutException(str + " for " + abstractResolvableFuture);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        if (this.value != null) {
            return true;
        }
        return false;
    }

    public final void removeWaiter(Waiter waiter) {
        waiter.thread = null;
        while (true) {
            Waiter waiter2 = this.waiters;
            if (waiter2 != Waiter.TOMBSTONE) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.next;
                    if (waiter2.thread != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.next = waiter4;
                        if (waiter3.thread == null) {
                            break;
                        }
                    } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                        break;
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.value instanceof Cancellation) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        java.util.concurrent.locks.LockSupport.park(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (java.lang.Thread.interrupted() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        r0 = r4.value;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
        return getDoneValue(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
        removeWaiter(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get() {
        Waiter waiter = Waiter.TOMBSTONE;
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if (obj != null) {
                return getDoneValue(obj);
            }
            Waiter waiter2 = this.waiters;
            if (waiter2 == waiter) {
                return getDoneValue(this.value);
            }
            Waiter waiter3 = new Waiter();
            do {
                BundleKt bundleKt = ATOMIC_HELPER;
                bundleKt.putNext(waiter3, waiter2);
                if (bundleKt.casWaiters(this, waiter2, waiter3)) {
                    break;
                }
                waiter2 = this.waiters;
            } while (waiter2 != waiter);
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
