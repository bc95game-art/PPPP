package p004j$.time;

import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.w */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0387w {

    /* renamed from: a */
    public static final /* synthetic */ int[] f246a;

    /* renamed from: b */
    public static final /* synthetic */ int[] f247b;

    static {
        int[] iArr = new int[EnumC0365b.values().length];
        f247b = iArr;
        try {
            iArr[EnumC0365b.MONTHS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f247b[EnumC0365b.YEARS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f247b[EnumC0365b.DECADES.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f247b[EnumC0365b.CENTURIES.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f247b[EnumC0365b.MILLENNIA.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f247b[EnumC0365b.ERAS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr2 = new int[EnumC0364a.values().length];
        f246a = iArr2;
        try {
            iArr2[EnumC0364a.MONTH_OF_YEAR.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f246a[EnumC0364a.PROLEPTIC_MONTH.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f246a[EnumC0364a.YEAR_OF_ERA.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f246a[EnumC0364a.YEAR.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f246a[EnumC0364a.ERA.ordinal()] = 5;
        } catch (NoSuchFieldError unused11) {
        }
    }
}
