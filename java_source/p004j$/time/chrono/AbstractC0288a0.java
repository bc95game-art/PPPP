package p004j$.time.chrono;

import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.a0 */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0288a0 {

    /* renamed from: a */
    public static final /* synthetic */ int[] f55a;

    static {
        int[] iArr = new int[EnumC0364a.values().length];
        f55a = iArr;
        try {
            iArr[EnumC0364a.PROLEPTIC_MONTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f55a[EnumC0364a.YEAR_OF_ERA.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f55a[EnumC0364a.YEAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
