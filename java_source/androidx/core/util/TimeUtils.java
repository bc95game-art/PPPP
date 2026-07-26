package androidx.core.util;

import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class TimeUtils {
    public static final Object sFormatSync = new Object();
    public static char[] sFormatStr = new char[24];

    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void checkArgument(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkArgumentNonnegative(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void formatDuration(long j, PrintWriter printWriter) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j)));
        }
    }

    public static int formatDurationLocked(long j) {
        char c;
        int i;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        if (sFormatStr.length < 0) {
            sFormatStr = new char[0];
        }
        char[] cArr = sFormatStr;
        int i4 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i4 == 0) {
            cArr[0] = '0';
            return 1;
        }
        if (i4 > 0) {
            c = '+';
        } else {
            j = -j;
            c = '-';
        }
        int i5 = (int) (j % 1000);
        int floor = (int) Math.floor(j / 1000);
        if (floor > 86400) {
            i = floor / 86400;
            floor -= 86400 * i;
        } else {
            i = 0;
        }
        if (floor > 3600) {
            i2 = floor / 3600;
            floor -= i2 * 3600;
        } else {
            i2 = 0;
        }
        if (floor > 60) {
            int i6 = floor / 60;
            floor -= i6 * 60;
            i3 = i6;
        } else {
            i3 = 0;
        }
        cArr[0] = c;
        int printField = printField(cArr, i, 'd', 1, false, 0);
        if (printField != 1) {
            z = true;
        } else {
            z = false;
        }
        int printField2 = printField(cArr, i2, 'h', printField, z, 0);
        if (printField2 != 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int printField3 = printField(cArr, i3, 'm', printField2, z2, 0);
        if (printField3 != 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        int printField4 = printField(cArr, i5, 'm', printField(cArr, floor, 's', printField3, z3, 0), true, 0);
        cArr[printField4] = 's';
        return printField4 + 1;
    }

    public static int printField(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (!z && i <= 0) {
            return i2;
        }
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
        } else {
            int i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i -= i5 * 100;
        }
        if ((z && i3 >= 2) || i > 9 || i2 != i4) {
            int i6 = i / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i -= i6 * 10;
        }
        cArr[i4] = (char) (i + 48);
        cArr[i4 + 1] = c;
        return i4 + 2;
    }
}
