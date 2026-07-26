package p004j$.time.chrono;

import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.chrono.f */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0297f {

    /* renamed from: a */
    public static final /* synthetic */ int[] f61a;

    static {
        int[] iArr = new int[EnumC0365b.values().length];
        f61a = iArr;
        try {
            iArr[EnumC0365b.NANOS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f61a[EnumC0365b.MICROS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f61a[EnumC0365b.MILLIS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f61a[EnumC0365b.SECONDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f61a[EnumC0365b.MINUTES.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f61a[EnumC0365b.HOURS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f61a[EnumC0365b.HALF_DAYS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
