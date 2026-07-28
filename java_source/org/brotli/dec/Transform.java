package org.brotli.dec;
/* loaded from: classes.dex */
public final class Transform {
    public static final Transform[] TRANSFORMS = {new Transform("", 0, ""), new Transform("", 0, " "), new Transform(" ", 0, " "), new Transform("", 12, ""), new Transform("", 10, " "), new Transform("", 0, " the "), new Transform(" ", 0, ""), new Transform("s ", 0, " "), new Transform("", 0, " of "), new Transform("", 10, ""), new Transform("", 0, " and "), new Transform("", 13, ""), new Transform("", 1, ""), new Transform(", ", 0, " "), new Transform("", 0, ", "), new Transform(" ", 10, " "), new Transform("", 0, " in "), new Transform("", 0, " to "), new Transform("e ", 0, " "), new Transform("", 0, "\""), new Transform("", 0, "."), new Transform("", 0, "\">"), new Transform("", 0, "\n"), new Transform("", 3, ""), new Transform("", 0, "]"), new Transform("", 0, " for "), new Transform("", 14, ""), new Transform("", 2, ""), new Transform("", 0, " a "), new Transform("", 0, " that "), new Transform(" ", 10, ""), new Transform("", 0, ". "), new Transform(".", 0, ""), new Transform(" ", 0, ", "), new Transform("", 15, ""), new Transform("", 0, " with "), new Transform("", 0, "'"), new Transform("", 0, " from "), new Transform("", 0, " by "), new Transform("", 16, ""), new Transform("", 17, ""), new Transform(" the ", 0, ""), new Transform("", 4, ""), new Transform("", 0, ". The "), new Transform("", 11, ""), new Transform("", 0, " on "), new Transform("", 0, " as "), new Transform("", 0, " is "), new Transform("", 7, ""), new Transform("", 1, "ing "), new Transform("", 0, "\n\t"), new Transform("", 0, ":"), new Transform(" ", 0, ". "), new Transform("", 0, "ed "), new Transform("", 20, ""), new Transform("", 18, ""), new Transform("", 6, ""), new Transform("", 0, "("), new Transform("", 10, ", "), new Transform("", 8, ""), new Transform("", 0, " at "), new Transform("", 0, "ly "), new Transform(" the ", 0, " of "), new Transform("", 5, ""), new Transform("", 9, ""), new Transform(" ", 10, ", "), new Transform("", 10, "\""), new Transform(".", 0, "("), new Transform("", 11, " "), new Transform("", 10, "\">"), new Transform("", 0, "=\""), new Transform(" ", 0, "."), new Transform(".com/", 0, ""), new Transform(" the ", 0, " of the "), new Transform("", 10, "'"), new Transform("", 0, ". This "), new Transform("", 0, ","), new Transform(".", 0, " "), new Transform("", 10, "("), new Transform("", 10, "."), new Transform("", 0, " not "), new Transform(" ", 0, "=\""), new Transform("", 0, "er "), new Transform(" ", 11, " "), new Transform("", 0, "al "), new Transform(" ", 11, ""), new Transform("", 0, "='"), new Transform("", 11, "\""), new Transform("", 10, ". "), new Transform(" ", 0, "("), new Transform("", 0, "ful "), new Transform(" ", 10, ". "), new Transform("", 0, "ive "), new Transform("", 0, "less "), new Transform("", 11, "'"), new Transform("", 0, "est "), new Transform(" ", 10, "."), new Transform("", 11, "\">"), new Transform(" ", 0, "='"), new Transform("", 10, ","), new Transform("", 0, "ize "), new Transform("", 11, "."), new Transform("Â ", 0, ""), new Transform(" ", 0, ","), new Transform("", 10, "=\""), new Transform("", 11, "=\""), new Transform("", 0, "ous "), new Transform("", 11, ", "), new Transform("", 10, "='"), new Transform(" ", 10, ","), new Transform(" ", 11, "=\""), new Transform(" ", 11, ", "), new Transform("", 11, ","), new Transform("", 11, "("), new Transform("", 11, ". "), new Transform(" ", 11, "."), new Transform("", 11, "='"), new Transform(" ", 11, ". "), new Transform(" ", 10, "=\""), new Transform(" ", 11, "='"), new Transform(" ", 10, "='")};
    public final byte[] prefix;
    public final byte[] suffix;
    public final int type;

    public Transform(String str, int i, String str2) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) str.charAt(i2);
        }
        this.prefix = bArr;
        this.type = i;
        int length2 = str2.length();
        byte[] bArr2 = new byte[length2];
        for (int i3 = 0; i3 < length2; i3++) {
            bArr2[i3] = (byte) str2.charAt(i3);
        }
        this.suffix = bArr2;
    }
}
