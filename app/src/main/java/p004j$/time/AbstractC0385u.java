package p004j$.time;

import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
/* renamed from: j$.time.u */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0385u {

    /* renamed from: a */
    public static final /* synthetic */ int[] f242a;

    /* renamed from: b */
    public static final /* synthetic */ int[] f243b;

    static {
        int[] iArr = new int[EnumC0365b.values().length];
        f243b = iArr;
        try {
            iArr[EnumC0365b.YEARS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f243b[EnumC0365b.DECADES.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f243b[EnumC0365b.CENTURIES.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f243b[EnumC0365b.MILLENNIA.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f243b[EnumC0365b.ERAS.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        int[] iArr2 = new int[EnumC0364a.values().length];
        f242a = iArr2;
        try {
            iArr2[EnumC0364a.YEAR_OF_ERA.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f242a[EnumC0364a.YEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f242a[EnumC0364a.ERA.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
