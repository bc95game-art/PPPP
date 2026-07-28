package p004j$.time.chrono;

import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.x */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0321x {

    /* renamed from: a */
    public static final /* synthetic */ int[] f105a;

    static {
        int[] iArr = new int[EnumC0364a.values().length];
        f105a = iArr;
        try {
            iArr[EnumC0364a.DAY_OF_MONTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f105a[EnumC0364a.DAY_OF_YEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f105a[EnumC0364a.YEAR_OF_ERA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f105a[EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f105a[EnumC0364a.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f105a[EnumC0364a.ALIGNED_WEEK_OF_MONTH.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f105a[EnumC0364a.ALIGNED_WEEK_OF_YEAR.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f105a[EnumC0364a.ERA.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f105a[EnumC0364a.YEAR.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
