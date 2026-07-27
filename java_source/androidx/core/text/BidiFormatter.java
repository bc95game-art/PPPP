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
    */
    public static int getEntryDir(CharSequence charSequence) {
        byte b;
        DirectionalityEstimator directionalityEstimator = new DirectionalityEstimator(charSequence);
        directionalityEstimator.charIndex = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = directionalityEstimator.charIndex;
            if (i4 < directionalityEstimator.length && i == 0) {
                CharSequence charSequence2 = directionalityEstimator.text;
                char charAt = charSequence2.charAt(i4);
                directionalityEstimator.lastChar = charAt;
                if (Character.isHighSurrogate(charAt)) {
                    int codePointAt = Character.codePointAt(charSequence2, directionalityEstimator.charIndex);
                    directionalityEstimator.charIndex = Character.charCount(codePointAt) + directionalityEstimator.charIndex;
                    b = Character.getDirectionality(codePointAt);
                } else {
                    directionalityEstimator.charIndex++;
                    char c = directionalityEstimator.lastChar;
                    if (c < 1792) {
                        b = DirectionalityEstimator.DIR_TYPE_CACHE[c];
                    } else {
                        b = Character.getDirectionality(c);
                    }
                }
                if (b != 0) {
                    if (b == 1 || b == 2) {
                        if (i3 == 0) {
                        }
                    } else if (b != 9) {
                        switch (b) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                break;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                break;
                            case 18:
                                i3--;
                                i2 = 0;
                                break;
                        }
                    }
                } else if (i3 == 0) {
                }
                i = i3;
            }
        }
        return -1;
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
