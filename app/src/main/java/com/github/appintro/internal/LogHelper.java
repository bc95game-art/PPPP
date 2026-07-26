package com.github.appintro.internal;

import android.util.Log;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
/* loaded from: classes.dex */
public final class LogHelper {
    public static final LogHelper INSTANCE = new LogHelper();

    private LogHelper() {
    }

    private final String cutTagLength(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        String substring = str.substring(0, i - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* renamed from: d */
    public static final int m577d(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        return Log.d(tag, message);
    }

    /* renamed from: e */
    public static final void m576e(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        e$default(tag, message, null, 4, null);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        m575e(str, str2, th);
    }

    /* renamed from: i */
    public static final int m574i(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        return Log.i(tag, message);
    }

    public static final String makeLogTag(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        return Intrinsics.stringPlus(INSTANCE.cutTagLength(cls.getSimpleName(), 18), "Log: ");
    }

    /* renamed from: v */
    public static final int m573v(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        return Log.v(tag, message);
    }

    /* renamed from: w */
    public static final void m572w(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        w$default(tag, message, null, 4, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        m571w(str, str2, th);
    }

    public static final void wtf(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        wtf$default(tag, message, null, 4, null);
    }

    public static /* synthetic */ void wtf$default(String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        wtf(str, str2, th);
    }

    /* renamed from: e */
    public static final void m575e(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.e(tag, message, th);
    }

    /* renamed from: w */
    public static final void m571w(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.w(tag, message, th);
    }

    public static final void wtf(String tag, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.wtf(tag, message, th);
    }

    public final String makeLogTag(KClass cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        String simpleName = ((ClassReference) cls).getSimpleName();
        if (simpleName == null) {
            simpleName = "";
        }
        return Intrinsics.stringPlus(cutTagLength(simpleName, 18), "Log: ");
    }
}
