package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;
/* loaded from: classes.dex */
public abstract /* synthetic */ class zzcm {
    public static /* synthetic */ boolean zza(Unsafe unsafe, zzck zzckVar, long j, Object obj, Object obj2) {
        while (!zzcm$$ExternalSyntheticBackportWithForwarding0.m(unsafe, zzckVar, j, obj, obj2)) {
            if (unsafe.getObject(zzckVar, j) != obj) {
                return false;
            }
        }
        return true;
    }
}
