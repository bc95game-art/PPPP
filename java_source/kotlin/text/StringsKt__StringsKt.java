package kotlin.text;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
/* loaded from: classes.dex */
public abstract class StringsKt__StringsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static boolean contains$default(String str, String str2) {
        if (indexOf(str, str2, 0, false) >= 0) {
            return true;
        }
        return false;
    }

    public static final int indexOf(String other, String string, int i, boolean z) {
        char upperCase;
        char upperCase2;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        Intrinsics.checkNotNullParameter(other, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z) {
            return other.indexOf(string, i);
        }
        int length = other.length();
        if (i < 0) {
            i = 0;
        }
        int length2 = other.length();
        if (length > length2) {
            length = length2;
        }
        IntProgression intProgression = new IntProgression(i, length, 1);
        boolean z4 = other instanceof String;
        int i2 = intProgression.last;
        if (!z4 || !ViewModelProvider.Factory.CC.m599m((Object) string)) {
            if (i <= i2) {
                while (true) {
                    int length3 = string.length();
                    Intrinsics.checkNotNullParameter(other, "other");
                    if (i >= 0 && string.length() - length3 >= 0 && i <= other.length() - length3) {
                        for (int i3 = 0; i3 < length3; i3++) {
                            char charAt = string.charAt(i3);
                            char charAt2 = other.charAt(i + i3);
                            if (charAt == charAt2 || (z && ((upperCase = Character.toUpperCase(charAt)) == (upperCase2 = Character.toUpperCase(charAt2)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)))) {
                            }
                        }
                        return i;
                    }
                    if (i == i2) {
                        break;
                    }
                    i++;
                }
            }
        } else if (i <= i2) {
            int i4 = i;
            while (true) {
                int length4 = string.length();
                Intrinsics.checkNotNullParameter(string, "<this>");
                Intrinsics.checkNotNullParameter(other, "other");
                if (!z) {
                    z2 = string.regionMatches(0, other, i4, length4);
                    str = other;
                    str2 = string;
                    z3 = z;
                } else {
                    str = other;
                    str2 = string;
                    z3 = z;
                    z2 = str2.regionMatches(z3, 0, str, i4, length4);
                }
                if (z2) {
                    return i4;
                }
                if (i4 == i2) {
                    break;
                }
                i4++;
                string = str2;
                z = z3;
                other = str;
            }
        }
        return -1;
    }

    public static boolean isBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!(Character.isWhitespace(charAt) || Character.isSpaceChar(charAt))) {
                return false;
            }
        }
        return true;
    }

    public static String replace$default(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int indexOf = indexOf(str, str2, 0, false);
        if (indexOf < 0) {
            return str;
        }
        int length = str2.length();
        int i = 1;
        if (length >= 1) {
            i = length;
        }
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            int i2 = 0;
            do {
                sb.append((CharSequence) str, i2, indexOf);
                sb.append(str3);
                i2 = indexOf + length;
                if (indexOf >= str.length()) {
                    break;
                }
                indexOf = indexOf(str, str2, indexOf + i, false);
            } while (indexOf > 0);
            sb.append((CharSequence) str, i2, str.length());
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static String substringAfter$default(String str, String delimiter) {
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        int indexOf = indexOf(str, delimiter, 0, false);
        if (indexOf == -1) {
            return str;
        }
        String substring = str.substring(delimiter.length() + indexOf, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String substringAfterLast$default(String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf = missingDelimiterValue.lastIndexOf(46, missingDelimiterValue.length() - 1);
        if (lastIndexOf == -1) {
            return missingDelimiterValue;
        }
        String substring = missingDelimiterValue.substring(lastIndexOf + 1, missingDelimiterValue.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}
