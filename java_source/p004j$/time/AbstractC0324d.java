package p004j$.time;

import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.d */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0324d {

    /* renamed from: a */
    public static final /* synthetic */ int[] f115a;

    /* renamed from: b */
    public static final /* synthetic */ int[] f116b;

    static {
        int[] iArr = new int[EnumC0365b.values().length];
        f116b = iArr;
        try {
            iArr[EnumC0365b.NANOS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f116b[EnumC0365b.MICROS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f116b[EnumC0365b.MILLIS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f116b[EnumC0365b.SECONDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f116b[EnumC0365b.MINUTES.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f116b[EnumC0365b.HOURS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f116b[EnumC0365b.HALF_DAYS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f116b[EnumC0365b.DAYS.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        int[] iArr2 = new int[EnumC0364a.values().length];
        f115a = iArr2;
        try {
            iArr2[EnumC0364a.NANO_OF_SECOND.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f115a[EnumC0364a.MICRO_OF_SECOND.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f115a[EnumC0364a.MILLI_OF_SECOND.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f115a[EnumC0364a.INSTANT_SECONDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
