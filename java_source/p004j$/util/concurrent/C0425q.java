package p004j$.util.concurrent;

import java.util.concurrent.locks.LockSupport;
import p004j$.sun.misc.C0280a;
/* renamed from: j$.util.concurrent.q */
/* loaded from: classes2.dex */
public final class C0425q extends C0420l {

    /* renamed from: h */
    public static final C0280a f362h;

    /* renamed from: i */
    public static final long f363i;

    /* renamed from: e */
    public C0426r f364e;

    /* renamed from: f */
    public volatile C0426r f365f;

    /* renamed from: g */
    public volatile Thread f366g;
    volatile int lockState;

    static {
        C0280a aVar = C0280a.f39b;
        f362h = aVar;
        f363i = aVar.m501h(C0425q.class, "lockState");
    }

    /* renamed from: i */
    public static int m241i(Object obj, Object obj2) {
        int compareTo;
        return (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : compareTo;
    }

    public C0425q(C0426r rVar) {
        super(-2, null, null);
        int i;
        this.f365f = rVar;
        C0426r rVar2 = null;
        while (rVar != null) {
            rVar = (C0426r) rVar.f349d;
            rVar.f369g = null;
            rVar.f368f = null;
            if (rVar2 == null) {
                rVar.f367e = null;
                rVar.f371i = false;
            } else {
                Object obj = rVar.f347b;
                int i2 = rVar.f346a;
                C0426r rVar3 = rVar2;
                Class<?> cls = null;
                while (true) {
                    Object obj2 = rVar3.f347b;
                    int i3 = rVar3.f346a;
                    if (i3 > i2) {
                        i = -1;
                    } else if (i3 < i2) {
                        i = 1;
                    } else {
                        if (!(cls == null && (cls = ConcurrentHashMap.m270c(obj)) == null)) {
                            int i4 = ConcurrentHashMap.f312g;
                            int compareTo = (obj2 == null || obj2.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj2);
                            if (compareTo != 0) {
                                i = compareTo;
                            }
                        }
                        i = m241i(obj, obj2);
                    }
                    C0426r rVar4 = i <= 0 ? rVar3.f368f : rVar3.f369g;
                    if (rVar4 == null) {
                        break;
                    }
                    rVar3 = rVar4;
                }
                rVar.f367e = rVar3;
                if (i <= 0) {
                    rVar3.f368f = rVar;
                } else {
                    rVar3.f369g = rVar;
                }
                rVar = m247c(rVar2, rVar);
            }
            rVar2 = rVar;
        }
        this.f364e = rVar2;
    }

    /* renamed from: d */
    public final void m246d() {
        if (!f362h.m506c(this, f363i, 0, 1)) {
            boolean z = false;
            while (true) {
                int i = this.lockState;
                if ((i & (-3)) == 0) {
                    if (f362h.m506c(this, f363i, i, 1)) {
                        break;
                    }
                } else if ((i & 2) == 0) {
                    if (f362h.m506c(this, f363i, i, i | 2)) {
                        this.f366g = Thread.currentThread();
                        z = true;
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.f366g = null;
            }
        }
    }

    @Override // p004j$.util.concurrent.C0420l
    /* renamed from: a */
    public final C0420l mo240a(int i, Object obj) {
        Object obj2;
        Thread thread;
        Thread thread2;
        C0420l lVar = this.f365f;
        while (true) {
            C0426r rVar = null;
            if (lVar == null) {
                return null;
            }
            int i2 = this.lockState;
            if ((i2 & 3) == 0) {
                C0280a aVar = f362h;
                long j = f363i;
                if (aVar.m506c(this, j, i2, i2 + 4)) {
                    try {
                        C0426r rVar2 = this.f364e;
                        if (rVar2 != null) {
                            rVar = rVar2.m239b(i, obj, null);
                        }
                        if (aVar.m504e(this, j) == 6 && (thread2 = this.f366g) != null) {
                            LockSupport.unpark(thread2);
                        }
                        return rVar;
                    } catch (Throwable th) {
                        if (f362h.m504e(this, f363i) == 6 && (thread = this.f366g) != null) {
                            LockSupport.unpark(thread);
                        }
                        throw th;
                    }
                }
            } else if (lVar.f346a != i || ((obj2 = lVar.f347b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                lVar = lVar.f349d;
            }
        }
        return lVar;
    }

    /* renamed from: e */
    public final C0426r m245e(int i, Object obj, Object obj2) {
        int i2;
        C0426r b;
        C0426r b2;
        C0426r rVar = this.f364e;
        Class<?> cls = null;
        boolean z = false;
        while (rVar != null) {
            int i3 = rVar.f346a;
            if (i3 > i) {
                i2 = -1;
            } else if (i3 < i) {
                i2 = 1;
            } else {
                Object obj3 = rVar.f347b;
                if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                    return rVar;
                }
                if (!(cls == null && (cls = ConcurrentHashMap.m270c(obj)) == null)) {
                    int i4 = ConcurrentHashMap.f312g;
                    int compareTo = (obj3 == null || obj3.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj3);
                    if (compareTo != 0) {
                        i2 = compareTo;
                    }
                }
                if (!z) {
                    C0426r rVar2 = rVar.f368f;
                    if (rVar2 != null && (b2 = rVar2.m239b(i, obj, cls)) != null) {
                        return b2;
                    }
                    C0426r rVar3 = rVar.f369g;
                    if (rVar3 != null && (b = rVar3.m239b(i, obj, cls)) != null) {
                        return b;
                    }
                    z = true;
                }
                i2 = m241i(obj, obj3);
            }
            C0426r rVar4 = i2 <= 0 ? rVar.f368f : rVar.f369g;
            if (rVar4 == null) {
                C0426r rVar5 = this.f365f;
                C0426r rVar6 = new C0426r(i, obj, obj2, rVar5, rVar);
                this.f365f = rVar6;
                if (rVar5 != null) {
                    rVar5.f370h = rVar6;
                }
                if (i2 <= 0) {
                    rVar.f368f = rVar6;
                } else {
                    rVar.f369g = rVar6;
                }
                if (!rVar.f371i) {
                    rVar6.f371i = true;
                    return null;
                }
                m246d();
                try {
                    this.f364e = m247c(this.f364e, rVar6);
                    return null;
                } finally {
                    this.lockState = 0;
                }
            } else {
                rVar = rVar4;
            }
        }
        C0426r rVar7 = new C0426r(i, obj, obj2, null, null);
        this.f364e = rVar7;
        this.f365f = rVar7;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0091 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x0030, B:25:0x0039, B:28:0x003f, B:30:0x004d, B:33:0x0055, B:35:0x005b, B:37:0x005f, B:38:0x0062, B:39:0x0064, B:40:0x0068, B:42:0x006e, B:43:0x0070, B:46:0x007a, B:48:0x007e, B:49:0x0081, B:58:0x0091, B:61:0x0099, B:63:0x009d, B:64:0x00a0, B:65:0x00a2, B:66:0x00a8, B:69:0x00ad, B:70:0x00b1, B:72:0x00b5, B:74:0x00b9, B:76:0x00bd, B:77:0x00c0, B:79:0x00c4, B:80:0x00c6), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ad A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x0030, B:25:0x0039, B:28:0x003f, B:30:0x004d, B:33:0x0055, B:35:0x005b, B:37:0x005f, B:38:0x0062, B:39:0x0064, B:40:0x0068, B:42:0x006e, B:43:0x0070, B:46:0x007a, B:48:0x007e, B:49:0x0081, B:58:0x0091, B:61:0x0099, B:63:0x009d, B:64:0x00a0, B:65:0x00a2, B:66:0x00a8, B:69:0x00ad, B:70:0x00b1, B:72:0x00b5, B:74:0x00b9, B:76:0x00bd, B:77:0x00c0, B:79:0x00c4, B:80:0x00c6), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b5 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x0030, B:25:0x0039, B:28:0x003f, B:30:0x004d, B:33:0x0055, B:35:0x005b, B:37:0x005f, B:38:0x0062, B:39:0x0064, B:40:0x0068, B:42:0x006e, B:43:0x0070, B:46:0x007a, B:48:0x007e, B:49:0x0081, B:58:0x0091, B:61:0x0099, B:63:0x009d, B:64:0x00a0, B:65:0x00a2, B:66:0x00a8, B:69:0x00ad, B:70:0x00b1, B:72:0x00b5, B:74:0x00b9, B:76:0x00bd, B:77:0x00c0, B:79:0x00c4, B:80:0x00c6), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00bd A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x0030, B:25:0x0039, B:28:0x003f, B:30:0x004d, B:33:0x0055, B:35:0x005b, B:37:0x005f, B:38:0x0062, B:39:0x0064, B:40:0x0068, B:42:0x006e, B:43:0x0070, B:46:0x007a, B:48:0x007e, B:49:0x0081, B:58:0x0091, B:61:0x0099, B:63:0x009d, B:64:0x00a0, B:65:0x00a2, B:66:0x00a8, B:69:0x00ad, B:70:0x00b1, B:72:0x00b5, B:74:0x00b9, B:76:0x00bd, B:77:0x00c0, B:79:0x00c4, B:80:0x00c6), top: B:86:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c0 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x0030, B:25:0x0039, B:28:0x003f, B:30:0x004d, B:33:0x0055, B:35:0x005b, B:37:0x005f, B:38:0x0062, B:39:0x0064, B:40:0x0068, B:42:0x006e, B:43:0x0070, B:46:0x007a, B:48:0x007e, B:49:0x0081, B:58:0x0091, B:61:0x0099, B:63:0x009d, B:64:0x00a0, B:65:0x00a2, B:66:0x00a8, B:69:0x00ad, B:70:0x00b1, B:72:0x00b5, B:74:0x00b9, B:76:0x00bd, B:77:0x00c0, B:79:0x00c4, B:80:0x00c6), top: B:86:0x0030 }] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m244f(C0426r rVar) {
        C0426r rVar2;
        C0426r rVar3;
        C0426r rVar4 = (C0426r) rVar.f349d;
        C0426r rVar5 = rVar.f370h;
        if (rVar5 == null) {
            this.f365f = rVar4;
        } else {
            rVar5.f349d = rVar4;
        }
        if (rVar4 != null) {
            rVar4.f370h = rVar5;
        }
        if (this.f365f == null) {
            this.f364e = null;
            return true;
        }
        C0426r rVar6 = this.f364e;
        if (rVar6 == null || rVar6.f369g == null || (rVar2 = rVar6.f368f) == null || rVar2.f368f == null) {
            return true;
        }
        m246d();
        try {
            C0426r rVar7 = rVar.f368f;
            C0426r rVar8 = rVar.f369g;
            if (rVar7 == null || rVar8 == null) {
                if (rVar7 == null) {
                    if (rVar8 != null) {
                        rVar7 = rVar8;
                    }
                    rVar7 = rVar;
                }
                if (rVar7 != rVar) {
                    C0426r rVar9 = rVar.f367e;
                    rVar7.f367e = rVar9;
                    if (rVar9 == null) {
                        rVar6 = rVar7;
                    } else if (rVar == rVar9.f368f) {
                        rVar9.f368f = rVar7;
                    } else {
                        rVar9.f369g = rVar7;
                    }
                    rVar.f367e = null;
                    rVar.f369g = null;
                    rVar.f368f = null;
                }
                if (!rVar.f371i) {
                    rVar6 = m248b(rVar6, rVar7);
                }
                this.f364e = rVar6;
                if (rVar == rVar7 && (rVar3 = rVar.f367e) != null) {
                    if (rVar != rVar3.f368f) {
                        rVar3.f368f = null;
                    } else if (rVar == rVar3.f369g) {
                        rVar3.f369g = null;
                    }
                    rVar.f367e = null;
                }
                this.lockState = 0;
                return false;
            }
            C0426r rVar10 = rVar8;
            while (true) {
                C0426r rVar11 = rVar10.f368f;
                if (rVar11 == null) {
                    break;
                }
                rVar10 = rVar11;
            }
            boolean z = rVar10.f371i;
            rVar10.f371i = rVar.f371i;
            rVar.f371i = z;
            C0426r rVar12 = rVar10.f369g;
            C0426r rVar13 = rVar.f367e;
            if (rVar10 == rVar8) {
                rVar.f367e = rVar10;
                rVar10.f369g = rVar;
            } else {
                C0426r rVar14 = rVar10.f367e;
                rVar.f367e = rVar14;
                if (rVar14 != null) {
                    if (rVar10 == rVar14.f368f) {
                        rVar14.f368f = rVar;
                    } else {
                        rVar14.f369g = rVar;
                    }
                }
                rVar10.f369g = rVar8;
                rVar8.f367e = rVar10;
            }
            rVar.f368f = null;
            rVar.f369g = rVar12;
            if (rVar12 != null) {
                rVar12.f367e = rVar;
            }
            rVar10.f368f = rVar7;
            rVar7.f367e = rVar10;
            rVar10.f367e = rVar13;
            if (rVar13 == null) {
                rVar6 = rVar10;
            } else if (rVar == rVar13.f368f) {
                rVar13.f368f = rVar10;
            } else {
                rVar13.f369g = rVar10;
            }
            if (rVar12 != null) {
                rVar7 = rVar12;
                if (rVar7 != rVar) {
                }
                if (!rVar.f371i) {
                }
                this.f364e = rVar6;
                if (rVar == rVar7) {
                    if (rVar != rVar3.f368f) {
                    }
                    rVar.f367e = null;
                }
                this.lockState = 0;
                return false;
            }
            rVar7 = rVar;
            if (rVar7 != rVar) {
            }
            if (!rVar.f371i) {
            }
            this.f364e = rVar6;
            if (rVar == rVar7) {
            }
            this.lockState = 0;
            return false;
        } catch (Throwable th) {
            this.lockState = 0;
            throw th;
        }
        this.lockState = 0;
        throw th;
    }

    /* renamed from: g */
    public static C0426r m243g(C0426r rVar, C0426r rVar2) {
        C0426r rVar3;
        if (!(rVar2 == null || (rVar3 = rVar2.f369g) == null)) {
            C0426r rVar4 = rVar3.f368f;
            rVar2.f369g = rVar4;
            if (rVar4 != null) {
                rVar4.f367e = rVar2;
            }
            C0426r rVar5 = rVar2.f367e;
            rVar3.f367e = rVar5;
            if (rVar5 == null) {
                rVar3.f371i = false;
                rVar = rVar3;
            } else if (rVar5.f368f == rVar2) {
                rVar5.f368f = rVar3;
            } else {
                rVar5.f369g = rVar3;
            }
            rVar3.f368f = rVar2;
            rVar2.f367e = rVar3;
        }
        return rVar;
    }

    /* renamed from: h */
    public static C0426r m242h(C0426r rVar, C0426r rVar2) {
        C0426r rVar3;
        if (!(rVar2 == null || (rVar3 = rVar2.f368f) == null)) {
            C0426r rVar4 = rVar3.f369g;
            rVar2.f368f = rVar4;
            if (rVar4 != null) {
                rVar4.f367e = rVar2;
            }
            C0426r rVar5 = rVar2.f367e;
            rVar3.f367e = rVar5;
            if (rVar5 == null) {
                rVar3.f371i = false;
                rVar = rVar3;
            } else if (rVar5.f369g == rVar2) {
                rVar5.f369g = rVar3;
            } else {
                rVar5.f368f = rVar3;
            }
            rVar3.f369g = rVar2;
            rVar2.f367e = rVar3;
        }
        return rVar;
    }

    /* renamed from: c */
    public static C0426r m247c(C0426r rVar, C0426r rVar2) {
        C0426r rVar3;
        rVar2.f371i = true;
        while (true) {
            C0426r rVar4 = rVar2.f367e;
            if (rVar4 == null) {
                rVar2.f371i = false;
                return rVar2;
            } else if (!rVar4.f371i || (rVar3 = rVar4.f367e) == null) {
                break;
            } else {
                C0426r rVar5 = rVar3.f368f;
                if (rVar4 == rVar5) {
                    C0426r rVar6 = rVar3.f369g;
                    if (rVar6 == null || !rVar6.f371i) {
                        if (rVar2 == rVar4.f369g) {
                            rVar = m243g(rVar, rVar4);
                            C0426r rVar7 = rVar4.f367e;
                            rVar3 = rVar7 == null ? null : rVar7.f367e;
                            rVar4 = rVar7;
                            rVar2 = rVar4;
                        }
                        if (rVar4 != null) {
                            rVar4.f371i = false;
                            if (rVar3 != null) {
                                rVar3.f371i = true;
                                rVar = m242h(rVar, rVar3);
                            }
                        }
                    } else {
                        rVar6.f371i = false;
                        rVar4.f371i = false;
                        rVar3.f371i = true;
                        rVar2 = rVar3;
                    }
                } else if (rVar5 == null || !rVar5.f371i) {
                    if (rVar2 == rVar4.f368f) {
                        rVar = m242h(rVar, rVar4);
                        C0426r rVar8 = rVar4.f367e;
                        rVar3 = rVar8 == null ? null : rVar8.f367e;
                        rVar4 = rVar8;
                        rVar2 = rVar4;
                    }
                    if (rVar4 != null) {
                        rVar4.f371i = false;
                        if (rVar3 != null) {
                            rVar3.f371i = true;
                            rVar = m243g(rVar, rVar3);
                        }
                    }
                } else {
                    rVar5.f371i = false;
                    rVar4.f371i = false;
                    rVar3.f371i = true;
                    rVar2 = rVar3;
                }
            }
        }
        return rVar;
    }

    /* renamed from: b */
    public static C0426r m248b(C0426r rVar, C0426r rVar2) {
        while (rVar2 != null && rVar2 != rVar) {
            C0426r rVar3 = rVar2.f367e;
            if (rVar3 == null) {
                rVar2.f371i = false;
                return rVar2;
            } else if (rVar2.f371i) {
                rVar2.f371i = false;
                return rVar;
            } else {
                C0426r rVar4 = rVar3.f368f;
                C0426r rVar5 = null;
                if (rVar4 == rVar2) {
                    C0426r rVar6 = rVar3.f369g;
                    if (rVar6 != null && rVar6.f371i) {
                        rVar6.f371i = false;
                        rVar3.f371i = true;
                        rVar = m243g(rVar, rVar3);
                        rVar3 = rVar2.f367e;
                        rVar6 = rVar3 == null ? null : rVar3.f369g;
                    }
                    if (rVar6 != null) {
                        C0426r rVar7 = rVar6.f368f;
                        C0426r rVar8 = rVar6.f369g;
                        if ((rVar8 == null || !rVar8.f371i) && (rVar7 == null || !rVar7.f371i)) {
                            rVar6.f371i = true;
                        } else {
                            if (rVar8 == null || !rVar8.f371i) {
                                if (rVar7 != null) {
                                    rVar7.f371i = false;
                                }
                                rVar6.f371i = true;
                                rVar = m242h(rVar, rVar6);
                                rVar3 = rVar2.f367e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f369g;
                                }
                                rVar6 = rVar5;
                            }
                            if (rVar6 != null) {
                                rVar6.f371i = rVar3 == null ? false : rVar3.f371i;
                                C0426r rVar9 = rVar6.f369g;
                                if (rVar9 != null) {
                                    rVar9.f371i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f371i = false;
                                rVar = m243g(rVar, rVar3);
                            }
                            rVar2 = rVar;
                        }
                    }
                    rVar2 = rVar3;
                } else {
                    if (rVar4 != null && rVar4.f371i) {
                        rVar4.f371i = false;
                        rVar3.f371i = true;
                        rVar = m242h(rVar, rVar3);
                        rVar3 = rVar2.f367e;
                        rVar4 = rVar3 == null ? null : rVar3.f368f;
                    }
                    if (rVar4 != null) {
                        C0426r rVar10 = rVar4.f368f;
                        C0426r rVar11 = rVar4.f369g;
                        if ((rVar10 == null || !rVar10.f371i) && (rVar11 == null || !rVar11.f371i)) {
                            rVar4.f371i = true;
                        } else {
                            if (rVar10 == null || !rVar10.f371i) {
                                if (rVar11 != null) {
                                    rVar11.f371i = false;
                                }
                                rVar4.f371i = true;
                                rVar = m243g(rVar, rVar4);
                                rVar3 = rVar2.f367e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f368f;
                                }
                                rVar4 = rVar5;
                            }
                            if (rVar4 != null) {
                                rVar4.f371i = rVar3 == null ? false : rVar3.f371i;
                                C0426r rVar12 = rVar4.f368f;
                                if (rVar12 != null) {
                                    rVar12.f371i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f371i = false;
                                rVar = m242h(rVar, rVar3);
                            }
                            rVar2 = rVar;
                        }
                    }
                    rVar2 = rVar3;
                }
            }
        }
        return rVar;
    }
}
