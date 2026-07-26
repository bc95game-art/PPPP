package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
/* loaded from: classes.dex */
public final class NotificationCompat$Action {
    public final PendingIntent actionIntent;
    public final int icon;
    public final boolean mAllowGeneratedReplies;
    public final Bundle mExtras;
    public IconCompat mIcon;
    public final boolean mShowsUserInterface;
    public final CharSequence title;

    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NotificationCompat$Action(int r10, java.lang.CharSequence r11, android.app.PendingIntent r12) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L5
            r10 = r0
            goto L9
        L5:
            androidx.core.graphics.drawable.IconCompat r10 = androidx.core.graphics.drawable.IconCompat.createWithResource(r10)
        L9:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r9.<init>()
            r2 = 1
            r9.mShowsUserInterface = r2
            r9.mIcon = r10
            if (r10 == 0) goto L86
            int r3 = r10.mType
            r4 = -1
            if (r3 != r4) goto L7d
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r5 < r6) goto L7d
            java.lang.Object r3 = r10.mObj1
            java.lang.String r6 = "Unable to get icon type "
            java.lang.String r7 = "IconCompat"
            r8 = 28
            if (r5 < r8) goto L32
            int r3 = androidx.core.graphics.drawable.IconCompat.Api28Impl.getType(r3)
            goto L7d
        L32:
            java.lang.Class r5 = r3.getClass()     // Catch: java.lang.NoSuchMethodException -> L47 java.lang.reflect.InvocationTargetException -> L49 java.lang.IllegalAccessException -> L4b
            java.lang.String r8 = "getType"
            java.lang.reflect.Method r5 = r5.getMethod(r8, r0)     // Catch: java.lang.NoSuchMethodException -> L47 java.lang.reflect.InvocationTargetException -> L49 java.lang.IllegalAccessException -> L4b
            java.lang.Object r0 = r5.invoke(r3, r0)     // Catch: java.lang.NoSuchMethodException -> L47 java.lang.reflect.InvocationTargetException -> L49 java.lang.IllegalAccessException -> L4b
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.NoSuchMethodException -> L47 java.lang.reflect.InvocationTargetException -> L49 java.lang.IllegalAccessException -> L4b
            int r3 = r0.intValue()     // Catch: java.lang.NoSuchMethodException -> L47 java.lang.reflect.InvocationTargetException -> L49 java.lang.IllegalAccessException -> L4b
            goto L7d
        L47:
            r0 = move-exception
            goto L4d
        L49:
            r0 = move-exception
            goto L5d
        L4b:
            r0 = move-exception
            goto L6d
        L4d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.util.Log.e(r7, r3, r0)
            goto L7c
        L5d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.util.Log.e(r7, r3, r0)
            goto L7c
        L6d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.util.Log.e(r7, r3, r0)
        L7c:
            r3 = -1
        L7d:
            r0 = 2
            if (r3 != r0) goto L86
            int r10 = r10.getResId()
            r9.icon = r10
        L86:
            java.lang.CharSequence r10 = androidx.core.app.NotificationCompat$Builder.limitCharSequenceLength(r11)
            r9.title = r10
            r9.actionIntent = r12
            r9.mExtras = r1
            r9.mAllowGeneratedReplies = r2
            r9.mShowsUserInterface = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat$Action.<init>(int, java.lang.CharSequence, android.app.PendingIntent):void");
    }
}
