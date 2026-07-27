package p004j$.time.chrono;

import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.c0 */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0292c0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f58a;

    static {
        int[] iArr = new int[EnumC0364a.values().length];
        f58a = iArr;
        try {
            iArr[EnumC0364a.DAY_OF_MONTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f58a[EnumC0364a.DAY_OF_YEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f58a[EnumC0364a.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f58a[EnumC0364a.YEAR_OF_ERA.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f58a[EnumC0364a.PROLEPTIC_MONTH.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f58a[EnumC0364a.YEAR.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f58a[EnumC0364a.ERA.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
