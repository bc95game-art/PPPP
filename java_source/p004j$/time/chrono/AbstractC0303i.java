package p004j$.time.chrono;

import p004j$.time.temporal.EnumC0364a;
/* renamed from: j$.time.chrono.i */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0303i {

    /* renamed from: a */
    public static final /* synthetic */ int[] f73a;

    static {
        int[] iArr = new int[EnumC0364a.values().length];
        f73a = iArr;
        try {
            iArr[EnumC0364a.INSTANT_SECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f73a[EnumC0364a.OFFSET_SECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
