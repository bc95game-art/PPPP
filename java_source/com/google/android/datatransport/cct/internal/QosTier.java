package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public final class QosTier extends Enum {
    public static final /* synthetic */ QosTier[] $VALUES;
    public static final QosTier DEFAULT;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, java.lang.Object, com.google.android.datatransport.cct.internal.QosTier] */
    static {
        ?? r0 = new Enum("DEFAULT", 0);
        DEFAULT = r0;
        Enum r1 = new Enum("UNMETERED_ONLY", 1);
        Enum r3 = new Enum("UNMETERED_OR_DAILY", 2);
        Enum r5 = new Enum("FAST_IF_RADIO_AWAKE", 3);
        Enum r7 = new Enum("NEVER", 4);
        Enum r9 = new Enum("UNRECOGNIZED", 5);
        $VALUES = new QosTier[]{r0, r1, r3, r5, r7, r9};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, r0);
        sparseArray.put(1, r1);
        sparseArray.put(2, r3);
        sparseArray.put(3, r5);
        sparseArray.put(4, r7);
        sparseArray.put(-1, r9);
    }

    public static QosTier valueOf(String str) {
        return (QosTier) Enum.valueOf(QosTier.class, str);
    }

    public static QosTier[] values() {
        return (QosTier[]) $VALUES.clone();
    }
}
