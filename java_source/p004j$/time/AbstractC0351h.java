package p004j$.time;

import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.h */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0351h {

    /* renamed from: a */
    public static final /* synthetic */ int[] f176a;

    static {
        int[] iArr = new int[EnumC0365b.values().length];
        f176a = iArr;
        try {
            iArr[EnumC0365b.NANOS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f176a[EnumC0365b.MICROS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f176a[EnumC0365b.MILLIS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f176a[EnumC0365b.SECONDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f176a[EnumC0365b.MINUTES.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f176a[EnumC0365b.HOURS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f176a[EnumC0365b.HALF_DAYS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
