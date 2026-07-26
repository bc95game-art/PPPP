package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.android.billingclient.api.zzcn;
/* loaded from: classes.dex */
public final class BidiFormatter {
    public final boolean mIsRtlContext;
    public static final String LRM_STRING = Character.toString(8206);
    public static final String RLM_STRING = Character.toString(8207);
    public static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false);
    public static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true);

    /* loaded from: classes.dex */
    public final class DirectionalityEstimator {
        public static final byte[] DIR_TYPE_CACHE = new byte[1792];
        public int charIndex;
        public char lastChar;
        public final int length;
        public final CharSequence text;

        static {
            for (int i = 0; i < 1792; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence) {
            this.text = charSequence;
            this.length = charSequence.length();
        }

        public final byte dirTypeBackward() {
            CharSequence charSequence = this.text;
            char charAt = charSequence.charAt(this.charIndex - 1);
            this.lastChar = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(charSequence, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            char c = this.lastChar;
            if (c < 1792) {
                return DIR_TYPE_CACHE[c];
            }
            return Character.getDirectionality(c);
        }
    }

    static {
        zzcn zzcnVar = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    }

    public BidiFormatter(boolean z) {
        zzcn zzcnVar = TextDirectionHeuristicsCompat.LTR;
        this.mIsRtlContext = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
        if (r1 != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r2 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
        if (r0.charIndex <= 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        switch(r0.dirTypeBackward()) {
            case 14: goto L61;
            case 15: goto L61;
            case 16: goto L60;
            case 17: goto L60;
            case 18: goto L59;
            default: goto L65;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r1 != r3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r1 != r3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getEntryDir(java.lang.CharSequence r9) {
        /*
            androidx.core.text.BidiFormatter$DirectionalityEstimator r0 = new androidx.core.text.BidiFormatter$DirectionalityEstimator
            r0.<init>(r9)
            r9 = 0
            r0.charIndex = r9
            r1 = 0
            r2 = 0
            r3 = 0
        Lb:
            int r4 = r0.charIndex
            int r5 = r0.length
            r6 = -1
            r7 = 1
            if (r4 >= r5) goto L6e
            if (r1 != 0) goto L6e
            java.lang.CharSequence r5 = r0.text
            char r4 = r5.charAt(r4)
            r0.lastChar = r4
            boolean r4 = java.lang.Character.isHighSurrogate(r4)
            if (r4 == 0) goto L37
            int r4 = r0.charIndex
            int r4 = java.lang.Character.codePointAt(r5, r4)
            int r5 = r0.charIndex
            int r8 = java.lang.Character.charCount(r4)
            int r8 = r8 + r5
            r0.charIndex = r8
            byte r4 = java.lang.Character.getDirectionality(r4)
            goto L4b
        L37:
            int r4 = r0.charIndex
            int r4 = r4 + r7
            r0.charIndex = r4
            char r4 = r0.lastChar
            r5 = 1792(0x700, float:2.511E-42)
            if (r4 >= r5) goto L47
            byte[] r5 = androidx.core.text.BidiFormatter.DirectionalityEstimator.DIR_TYPE_CACHE
            r4 = r5[r4]
            goto L4b
        L47:
            byte r4 = java.lang.Character.getDirectionality(r4)
        L4b:
            if (r4 == 0) goto L69
            if (r4 == r7) goto L66
            r5 = 2
            if (r4 == r5) goto L66
            r5 = 9
            if (r4 == r5) goto Lb
            switch(r4) {
                case 14: goto L62;
                case 15: goto L62;
                case 16: goto L5e;
                case 17: goto L5e;
                case 18: goto L5a;
                default: goto L59;
            }
        L59:
            goto L6c
        L5a:
            int r3 = r3 + (-1)
            r2 = 0
            goto Lb
        L5e:
            int r3 = r3 + 1
            r2 = 1
            goto Lb
        L62:
            int r3 = r3 + 1
            r2 = -1
            goto Lb
        L66:
            if (r3 != 0) goto L6c
            goto L85
        L69:
            if (r3 != 0) goto L6c
            goto L8b
        L6c:
            r1 = r3
            goto Lb
        L6e:
            if (r1 != 0) goto L71
            goto L8c
        L71:
            if (r2 == 0) goto L74
            return r2
        L74:
            int r2 = r0.charIndex
            if (r2 <= 0) goto L8c
            byte r2 = r0.dirTypeBackward()
            switch(r2) {
                case 14: goto L89;
                case 15: goto L89;
                case 16: goto L83;
                case 17: goto L83;
                case 18: goto L80;
                default: goto L7f;
            }
        L7f:
            goto L74
        L80:
            int r3 = r3 + 1
            goto L74
        L83:
            if (r1 != r3) goto L86
        L85:
            return r7
        L86:
            int r3 = r3 + (-1)
            goto L74
        L89:
            if (r1 != r3) goto L86
        L8b:
            return r6
        L8c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.getEntryDir(java.lang.CharSequence):int");
    }

    public static int getExitDir(CharSequence charSequence) {
        DirectionalityEstimator directionalityEstimator = new DirectionalityEstimator(charSequence);
        directionalityEstimator.charIndex = directionalityEstimator.length;
        int i = 0;
        int i2 = 0;
        while (directionalityEstimator.charIndex > 0) {
            byte dirTypeBackward = directionalityEstimator.dirTypeBackward();
            if (dirTypeBackward != 0) {
                if (dirTypeBackward == 1 || dirTypeBackward == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (dirTypeBackward != 9) {
                    switch (dirTypeBackward) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i;
                                break;
                            }
                    }
                } else {
                    continue;
                }
            } else if (i == 0) {
                return -1;
            } else {
                if (i2 == 0) {
                    i2 = i;
                }
            }
        }
        return 0;
    }

    public final SpannableStringBuilder unicodeWrap(CharSequence charSequence) {
        zzcn zzcnVar;
        String str;
        zzcn zzcnVar2;
        char c;
        zzcn zzcnVar3 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = zzcnVar3.isRtl(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (isRtl) {
            zzcnVar = TextDirectionHeuristicsCompat.RTL;
        } else {
            zzcnVar = TextDirectionHeuristicsCompat.LTR;
        }
        boolean isRtl2 = zzcnVar.isRtl(charSequence, charSequence.length());
        String str2 = "";
        String str3 = RLM_STRING;
        String str4 = LRM_STRING;
        boolean z = this.mIsRtlContext;
        if (!z && (isRtl2 || getEntryDir(charSequence) == 1)) {
            str = str4;
        } else if (!z || (isRtl2 && getEntryDir(charSequence) != -1)) {
            str = str2;
        } else {
            str = str3;
        }
        spannableStringBuilder.append((CharSequence) str);
        if (isRtl != z) {
            if (isRtl) {
                c = 8235;
            } else {
                c = 8234;
            }
            spannableStringBuilder.append(c);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (isRtl) {
            zzcnVar2 = TextDirectionHeuristicsCompat.RTL;
        } else {
            zzcnVar2 = TextDirectionHeuristicsCompat.LTR;
        }
        boolean isRtl3 = zzcnVar2.isRtl(charSequence, charSequence.length());
        if (!z && (isRtl3 || getExitDir(charSequence) == 1)) {
            str2 = str4;
        } else if (z && (!isRtl3 || getExitDir(charSequence) == -1)) {
            str2 = str3;
        }
        spannableStringBuilder.append((CharSequence) str2);
        return spannableStringBuilder;
    }
}
