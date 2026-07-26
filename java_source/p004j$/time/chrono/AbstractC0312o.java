package p004j$.time.chrono;

import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.o */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0312o {

    /* renamed from: a */
    public static final /* synthetic */ int[] f82a;

    static {
        int[] iArr = new int[EnumC0364a.values().length];
        f82a = iArr;
        try {
            iArr[EnumC0364a.DAY_OF_MONTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f82a[EnumC0364a.DAY_OF_YEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f82a[EnumC0364a.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f82a[EnumC0364a.YEAR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f82a[EnumC0364a.YEAR_OF_ERA.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f82a[EnumC0364a.ERA.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
