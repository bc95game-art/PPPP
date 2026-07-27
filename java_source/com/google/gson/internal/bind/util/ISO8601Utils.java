package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import p004j$.util.DesugarTimeZone;
/* loaded from: classes.dex */
public abstract class ISO8601Utils {
    public static final TimeZone TIMEZONE_UTC = DesugarTimeZone.getTimeZone("UTC");

    public static boolean checkOffset(String str, int i, char c) {
        if (i >= str.length() || str.charAt(i) != c) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00f7 A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TRY_LEAVE, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:21:0x005b, B:23:0x006b, B:24:0x006d, B:26:0x0079, B:27:0x007c, B:29:0x0082, B:33:0x008c, B:38:0x009c, B:40:0x00a4, B:41:0x00a8, B:43:0x00ae, B:48:0x00bb, B:50:0x00c2, B:51:0x00c6, B:55:0x00d6, B:56:0x00d9, B:62:0x00f1, B:64:0x00f7, B:71:0x0109, B:72:0x0124, B:73:0x0125, B:76:0x0131, B:77:0x0142, B:79:0x014f, B:82:0x0158, B:84:0x0177, B:87:0x0186, B:88:0x01a8, B:89:0x01a9, B:91:0x01da, B:92:0x01e1), top: B:103:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01da A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:21:0x005b, B:23:0x006b, B:24:0x006d, B:26:0x0079, B:27:0x007c, B:29:0x0082, B:33:0x008c, B:38:0x009c, B:40:0x00a4, B:41:0x00a8, B:43:0x00ae, B:48:0x00bb, B:50:0x00c2, B:51:0x00c6, B:55:0x00d6, B:56:0x00d9, B:62:0x00f1, B:64:0x00f7, B:71:0x0109, B:72:0x0124, B:73:0x0125, B:76:0x0131, B:77:0x0142, B:79:0x014f, B:82:0x0158, B:84:0x0177, B:87:0x0186, B:88:0x01a8, B:89:0x01a9, B:91:0x01da, B:92:0x01e1), top: B:103:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date parse(String str, ParsePosition parsePosition) {
        Throwable e;
        String str2;
        String message;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char charAt;
        int length;
        try {
            int index = parsePosition.getIndex();
            int i6 = index + 4;
            int parseInt = parseInt(index, i6, str);
            if (checkOffset(str, i6, '-')) {
                i6 = index + 5;
            }
            int i7 = i6 + 2;
            int parseInt2 = parseInt(i6, i7, str);
            if (checkOffset(str, i7, '-')) {
                i7 = i6 + 3;
            }
            int i8 = i7 + 2;
            int parseInt3 = parseInt(i7, i8, str);
            boolean checkOffset = checkOffset(str, i8, 'T');
            if (checkOffset || str.length() > i8) {
                if (checkOffset) {
                    int i9 = i7 + 5;
                    int parseInt4 = parseInt(i7 + 3, i9, str);
                    if (checkOffset(str, i9, ':')) {
                        i9 = i7 + 6;
                    }
                    int i10 = i9 + 2;
                    int parseInt5 = parseInt(i9, i10, str);
                    if (checkOffset(str, i10, ':')) {
                        i10 = i9 + 3;
                    }
                    if (str.length() <= i10 || (charAt = str.charAt(i10)) == 'Z' || charAt == '+' || charAt == '-') {
                        i8 = i10;
                        i4 = parseInt4;
                        i3 = parseInt5;
                    } else {
                        int i11 = i10 + 2;
                        i = parseInt(i10, i11, str);
                        if (i > 59 && i < 63) {
                            i = 59;
                        }
                        if (checkOffset(str, i11, '.')) {
                            int i12 = i10 + 3;
                            for (int i13 = i10 + 4; i13 < str.length(); i13++) {
                                char charAt2 = str.charAt(i13);
                                if (charAt2 >= '0' && charAt2 <= '9') {
                                }
                                length = i13;
                            }
                            length = str.length();
                            int min = Math.min(length, i10 + 6);
                            i2 = parseInt(i12, min, str);
                            int i14 = min - i12;
                            if (i14 == 1) {
                                i2 *= 100;
                            } else if (i14 == 2) {
                                i2 *= 10;
                            }
                            i4 = parseInt4;
                            i8 = length;
                            i3 = parseInt5;
                        } else {
                            i4 = parseInt4;
                            i8 = i11;
                            i3 = parseInt5;
                            i2 = 0;
                        }
                        if (str.length() <= i8) {
                            char charAt3 = str.charAt(i8);
                            TimeZone timeZone = TIMEZONE_UTC;
                            if (charAt3 == 'Z') {
                                i5 = i8 + 1;
                            } else if (charAt3 == '+' || charAt3 == '-') {
                                String substring = str.substring(i8);
                                if (substring.length() < 5) {
                                    substring = substring + "00";
                                }
                                i5 = i8 + substring.length();
                                if (!substring.equals("+0000") && !substring.equals("+00:00")) {
                                    String str3 = "GMT" + substring;
                                    timeZone = DesugarTimeZone.getTimeZone(str3);
                                    String id = timeZone.getID();
                                    if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone.getID());
                                    }
                                }
                            } else {
                                throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt3 + "'");
                            }
                            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                            gregorianCalendar.setLenient(false);
                            gregorianCalendar.set(1, parseInt);
                            gregorianCalendar.set(2, parseInt2 - 1);
                            gregorianCalendar.set(5, parseInt3);
                            gregorianCalendar.set(11, i4);
                            gregorianCalendar.set(12, i3);
                            gregorianCalendar.set(13, i);
                            gregorianCalendar.set(14, i2);
                            parsePosition.setIndex(i5);
                            return gregorianCalendar.getTime();
                        }
                        throw new IllegalArgumentException("No time zone indicator");
                    }
                } else {
                    i4 = 0;
                    i3 = 0;
                }
                i2 = 0;
                i = 0;
                if (str.length() <= i8) {
                }
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
                gregorianCalendar2.setLenient(false);
                parsePosition.setIndex(i8);
                return gregorianCalendar2.getTime();
            }
        } catch (IllegalArgumentException e2) {
            e = e2;
            if (str != null) {
                str2 = null;
            } else {
                str2 = "\"" + str + '\"';
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
            if (str != null) {
            }
            message = e.getMessage();
            if (message != null) {
            }
            message = "(" + e.getClass().getName() + ")";
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        }
    }

    public static int parseInt(int i, int i2, String str) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }
}
