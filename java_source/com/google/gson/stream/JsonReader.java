package com.google.gson.stream;

import androidx.lifecycle.ViewModelProvider;
import androidx.transition.ViewUtilsApi21;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
/* loaded from: classes.dex */
public class JsonReader implements Closeable {

    /* renamed from: in */
    public final StringReader f38in;
    public long peekedLong;
    public int peekedNumberLength;
    public String peekedString;
    public int[] stack;
    public int strictness = 2;
    public final char[] buffer = new char[1024];
    public int pos = 0;
    public int limit = 0;
    public int lineNumber = 0;
    public int lineStart = 0;
    public int peeked = 0;
    public int stackSize = 1;
    public String[] pathNames = new String[32];
    public int[] pathIndices = new int[32];

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    static {
        ViewUtilsApi21.INSTANCE = new Object();
    }

    public JsonReader(StringReader stringReader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.f38in = stringReader;
    }

    public final void beginArray() {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw unexpectedTokenError("BEGIN_ARRAY");
    }

    public final void beginObject() {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw unexpectedTokenError("BEGIN_OBJECT");
    }

    public final void checkLenient() {
        if (this.strictness != 1) {
            syntaxError("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
            throw null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f38in.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x01a8, code lost:
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0217, code lost:
        if (isLiteral(r12) != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x021a, code lost:
        if (r5 != 2) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x021c, code lost:
        if (r10 == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0222, code lost:
        if (r1 != Long.MIN_VALUE) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0224, code lost:
        if (r17 == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0227, code lost:
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x022b, code lost:
        if (r1 != 0) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x022d, code lost:
        if (r17 != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x022f, code lost:
        if (r17 == false) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0232, code lost:
        r1 = -r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0233, code lost:
        r25.peekedLong = r1;
        r25.pos += r7;
        r9 = 15;
        r25.peeked = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x023f, code lost:
        if (r5 == r13) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0242, code lost:
        if (r5 == 4) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0245, code lost:
        if (r5 != 7) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0247, code lost:
        r25.peekedNumberLength = r7;
        r9 = 16;
        r25.peeked = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x026f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int doPeek() {
        int nextNonWhitespace;
        int i;
        int i2;
        boolean z;
        String str;
        String str2;
        boolean z2;
        char c;
        int nextNonWhitespace2;
        int[] iArr = this.stack;
        int i3 = this.stackSize - 1;
        int i4 = iArr[i3];
        char[] cArr = this.buffer;
        if (i4 == 1) {
            iArr[i3] = 2;
        } else if (i4 == 2) {
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 != 44) {
                if (nextNonWhitespace3 == 59) {
                    checkLenient();
                } else if (nextNonWhitespace3 == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    syntaxError("Unterminated array");
                    throw null;
                }
            }
        } else if (i4 == 3 || i4 == 5) {
            iArr[i3] = 4;
            if (i4 == 5 && (nextNonWhitespace2 = nextNonWhitespace(true)) != 44) {
                if (nextNonWhitespace2 == 59) {
                    checkLenient();
                } else if (nextNonWhitespace2 == 125) {
                    this.peeked = 2;
                    return 2;
                } else {
                    syntaxError("Unterminated object");
                    throw null;
                }
            }
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 == 34) {
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace4 == 39) {
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace4 != 125) {
                checkLenient();
                this.pos--;
                if (isLiteral((char) nextNonWhitespace4)) {
                    this.peeked = 14;
                    return 14;
                }
                syntaxError("Expected name");
                throw null;
            } else if (i4 != 5) {
                this.peeked = 2;
                return 2;
            } else {
                syntaxError("Expected name");
                throw null;
            }
        } else if (i4 == 4) {
            iArr[i3] = 5;
            int nextNonWhitespace5 = nextNonWhitespace(true);
            if (nextNonWhitespace5 != 58) {
                if (nextNonWhitespace5 == 61) {
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        int i5 = this.pos;
                        if (cArr[i5] == '>') {
                            this.pos = i5 + 1;
                        }
                    }
                } else {
                    syntaxError("Expected ':'");
                    throw null;
                }
            }
        } else if (i4 == 6) {
            if (this.strictness == 1) {
                nextNonWhitespace(true);
                int i6 = this.pos;
                this.pos = i6 - 1;
                if (i6 + 4 <= this.limit || fillBuffer(5)) {
                    int i7 = this.pos;
                    if (cArr[i7] == ')' && cArr[i7 + 1] == ']' && cArr[i7 + 2] == '}' && cArr[i7 + 3] == '\'' && cArr[i7 + 4] == '\n') {
                        this.pos = i7 + 5;
                    }
                }
            }
            this.stack[this.stackSize - 1] = 7;
        } else {
            if (i4 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 17;
                    return 17;
                }
                checkLenient();
                this.pos--;
            } else if (i4 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            nextNonWhitespace = nextNonWhitespace(true);
            if (nextNonWhitespace != 34) {
                this.peeked = 9;
                return 9;
            } else if (nextNonWhitespace != 39) {
                if (!(nextNonWhitespace == 44 || nextNonWhitespace == 59)) {
                    if (nextNonWhitespace == 91) {
                        this.peeked = 3;
                        return 3;
                    } else if (nextNonWhitespace != 93) {
                        if (nextNonWhitespace != 123) {
                            int i8 = this.pos - 1;
                            this.pos = i8;
                            char c2 = cArr[i8];
                            if (c2 == 't' || c2 == 'T') {
                                str2 = "true";
                                str = "TRUE";
                                i = 5;
                            } else if (c2 == 'f' || c2 == 'F') {
                                str2 = "false";
                                str = "FALSE";
                                i = 6;
                            } else {
                                if (c2 == 'n' || c2 == 'N') {
                                    str2 = "null";
                                    str = "NULL";
                                    i = 7;
                                }
                                i = 0;
                                if (i == 0) {
                                    return i;
                                }
                                int i9 = this.pos;
                                int i10 = this.limit;
                                int i11 = i9;
                                long j = 0;
                                char c3 = 0;
                                int i12 = 0;
                                boolean z3 = true;
                                boolean z4 = false;
                                while (true) {
                                    if (i11 + i12 == i10) {
                                        if (i12 == cArr.length) {
                                            break;
                                        } else if (!fillBuffer(i12 + 1)) {
                                            break;
                                        } else {
                                            i11 = this.pos;
                                            i10 = this.limit;
                                        }
                                    }
                                    char c4 = cArr[i11 + i12];
                                    if (c4 != '+') {
                                        if (c4 == 'E' || c4 == 'e') {
                                            if (c3 != 2 && c3 != 4) {
                                                break;
                                            }
                                            c3 = 5;
                                            i12++;
                                        } else if (c4 != '-') {
                                            if (c4 == '.') {
                                                if (c3 != 2) {
                                                    break;
                                                }
                                                c3 = 3;
                                                i12++;
                                            } else if (c4 < '0' || c4 > '9') {
                                                break;
                                            } else {
                                                if (c3 == 1 || c3 == 0) {
                                                    j = -(c4 - '0');
                                                    c3 = 2;
                                                } else if (c3 == 2) {
                                                    if (j == 0) {
                                                        break;
                                                    }
                                                    long j2 = (10 * j) - (c4 - '0');
                                                    int i13 = (j > (-922337203685477580L) ? 1 : (j == (-922337203685477580L) ? 0 : -1));
                                                    if (i13 > 0 || (i13 == 0 && j2 < j)) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    z3 &= z;
                                                    j = j2;
                                                } else if (c3 == 3) {
                                                    c3 = 4;
                                                } else if (c3 == 5 || c3 == 6) {
                                                    c3 = 7;
                                                }
                                                i12++;
                                            }
                                        } else if (c3 == 0) {
                                            c3 = 1;
                                            z4 = true;
                                            i12++;
                                        } else {
                                            if (c3 != 5) {
                                                break;
                                            }
                                            c3 = 6;
                                            i12++;
                                        }
                                        if (i2 == 0) {
                                            return i2;
                                        }
                                        if (isLiteral(cArr[this.pos])) {
                                            checkLenient();
                                            this.peeked = 10;
                                            return 10;
                                        }
                                        syntaxError("Expected value");
                                        throw null;
                                    }
                                    if (c3 != 5) {
                                        break;
                                    }
                                    c3 = 6;
                                    i12++;
                                }
                                i2 = 0;
                                if (i2 == 0) {
                                }
                            }
                            if (this.strictness != 3) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            int length = str2.length();
                            int i14 = 0;
                            while (true) {
                                if (i14 < length) {
                                    if ((this.pos + i14 >= this.limit && !fillBuffer(i14 + 1)) || ((c = cArr[this.pos + i14]) != str2.charAt(i14) && (!z2 || c != str.charAt(i14)))) {
                                        break;
                                    }
                                    i14++;
                                } else if ((this.pos + length >= this.limit && !fillBuffer(length + 1)) || !isLiteral(cArr[this.pos + length])) {
                                    this.pos += length;
                                    this.peeked = i;
                                }
                            }
                            i = 0;
                            if (i == 0) {
                            }
                        } else {
                            this.peeked = 1;
                            return 1;
                        }
                    } else if (i4 == 1) {
                        this.peeked = 4;
                        return 4;
                    }
                }
                if (i4 == 1 || i4 == 2) {
                    checkLenient();
                    this.pos--;
                    this.peeked = 7;
                    return 7;
                }
                syntaxError("Unexpected value");
                throw null;
            } else {
                checkLenient();
                this.peeked = 8;
                return 8;
            }
        }
        nextNonWhitespace = nextNonWhitespace(true);
        if (nextNonWhitespace != 34) {
        }
    }

    public final void endArray() {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 4) {
            int i2 = this.stackSize;
            this.stackSize = i2 - 1;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 2;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        throw unexpectedTokenError("END_ARRAY");
    }

    public final void endObject() {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2) {
            int i2 = this.stackSize;
            int i3 = i2 - 1;
            this.stackSize = i3;
            this.pathNames[i3] = null;
            int[] iArr = this.pathIndices;
            int i4 = i2 - 2;
            iArr[i4] = iArr[i4] + 1;
            this.peeked = 0;
            return;
        }
        throw unexpectedTokenError("END_OBJECT");
    }

    public final boolean fillBuffer(int i) {
        int i2;
        int i3;
        int i4 = this.lineStart;
        int i5 = this.pos;
        this.lineStart = i4 - i5;
        int i6 = this.limit;
        char[] cArr = this.buffer;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.limit = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int i8 = this.limit;
            int read = this.f38in.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.limit + read;
            this.limit = i2;
            if (this.lineNumber == 0 && (i3 = this.lineStart) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i3 + 1;
                i++;
                continue;
            }
        } while (i2 < i);
        return true;
    }

    public final String getPath(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i2 = this.stackSize;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.stack[i];
            switch (i3) {
                case 1:
                case 2:
                    int i4 = this.pathIndices[i];
                    if (z && i4 > 0 && i == i2 - 1) {
                        i4--;
                    }
                    sb.append('[');
                    sb.append(i4);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.pathNames[i];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(ViewModelProvider.Factory.CC.m604m(i3, "Unknown scope value: "));
            }
            i++;
        }
    }

    public final boolean hasNext() {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2 || i == 4 || i == 17) {
            return false;
        }
        return true;
    }

    public final boolean isLiteral(char c) {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (!(c == '/' || c == '=')) {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    public final String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath(false);
    }

    public final boolean nextBoolean() {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw unexpectedTokenError("a boolean");
        }
    }

    public final double nextDouble() {
        char c;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9) {
            if (i == 8) {
                c = '\'';
            } else {
                c = '\"';
            }
            this.peekedString = nextQuotedValue(c);
        } else if (i == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i != 11) {
            throw unexpectedTokenError("a double");
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.strictness == 1 || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        syntaxError("JSON forbids NaN and infinities: " + parseDouble);
        throw null;
    }

    public final int nextInt() {
        char c;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            long j = this.peekedLong;
            int i2 = (int) j;
            if (j == i2) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (i == 8) {
                    c = '\'';
                } else {
                    c = '\"';
                }
                this.peekedString = nextQuotedValue(c);
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw unexpectedTokenError("an int");
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i5 = (int) parseDouble;
        if (i5 == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public final long nextLong() {
        char c;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                if (i == 8) {
                    c = '\'';
                } else {
                    c = '\"';
                }
                this.peekedString = nextQuotedValue(c);
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw unexpectedTokenError("a long");
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public final String nextName() {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            str = nextUnquotedValue();
        } else if (i == 12) {
            str = nextQuotedValue('\'');
        } else if (i == 13) {
            str = nextQuotedValue('\"');
        } else {
            throw unexpectedTokenError("a name");
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public final int nextNonWhitespace(boolean z) {
        char c;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (fillBuffer(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + locationString());
                }
            }
            int i3 = i + 1;
            char[] cArr = this.buffer;
            c = cArr[i];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i3;
            } else if (!(c == ' ' || c == '\r' || c == '\t')) {
                if (c == '/') {
                    this.pos = i3;
                    if (i3 == i2) {
                        this.pos = i;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            break;
                        }
                    }
                    checkLenient();
                    int i4 = this.pos;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.pos = i4 + 1;
                        while (true) {
                            if (this.pos + 2 <= this.limit || fillBuffer(2)) {
                                int i5 = this.pos;
                                if (cArr[i5] != '\n') {
                                    for (int i6 = 0; i6 < 2; i6++) {
                                        if (cArr[this.pos + i6] != "*/".charAt(i6)) {
                                            break;
                                        }
                                    }
                                    i = this.pos + 2;
                                    i2 = this.limit;
                                    break;
                                }
                                this.lineNumber++;
                                this.lineStart = i5 + 1;
                                this.pos++;
                            } else {
                                syntaxError("Unterminated comment");
                                throw null;
                            }
                        }
                    } else if (c2 != '/') {
                        break;
                    } else {
                        this.pos = i4 + 1;
                        skipToEndOfLine();
                        i = this.pos;
                        i2 = this.limit;
                    }
                } else if (c == '#') {
                    this.pos = i3;
                    checkLenient();
                    skipToEndOfLine();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    this.pos = i3;
                    return c;
                }
            }
            i = i3;
        }
        return c;
    }

    public final void nextNull() {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw unexpectedTokenError("null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
        r11.pos = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r1 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
        if (r1 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
        r1.append(r7, r3, r2 - r3);
        r11.pos = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String nextQuotedValue(char c) {
        char[] cArr;
        int i;
        StringBuilder sb = null;
        do {
            int i2 = this.pos;
            int i3 = this.limit;
            while (true) {
                int i4 = i3;
                int i5 = i2;
                while (true) {
                    cArr = this.buffer;
                    if (i2 >= i4) {
                        break;
                    }
                    int i6 = i2 + 1;
                    char c2 = cArr[i2];
                    if (this.strictness == 3 && c2 < ' ') {
                        syntaxError("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                        throw null;
                    } else if (c2 == c) {
                        this.pos = i6;
                        int i7 = (i6 - i5) - 1;
                        if (sb == null) {
                            return new String(cArr, i5, i7);
                        }
                        sb.append(cArr, i5, i7);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i6;
                        }
                        i2 = i6;
                    }
                }
                sb.append(cArr, i5, i);
                sb.append(readEscapeCharacter());
                i2 = this.pos;
                i3 = this.limit;
            }
        } while (fillBuffer(1));
        syntaxError("Unterminated string");
        throw null;
    }

    public final String nextString() {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            str = nextUnquotedValue();
        } else if (i == 8) {
            str = nextQuotedValue('\'');
        } else if (i == 9) {
            str = nextQuotedValue('\"');
        } else if (i == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            throw unexpectedTokenError("a string");
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        checkLenient();
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String nextUnquotedValue() {
        char[] cArr;
        String str;
        StringBuilder sb = null;
        int i = 0;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.pos;
                int i4 = i3 + i2;
                int i5 = this.limit;
                cArr = this.buffer;
                if (i4 < i5) {
                    char c = cArr[i3 + i2];
                    if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ')) {
                        if (c != '#') {
                            if (c != ',') {
                                if (!(c == '/' || c == '=')) {
                                    if (!(c == '{' || c == '}' || c == ':')) {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= cArr.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(cArr, this.pos, i2);
                    this.pos += i2;
                } else if (fillBuffer(i2 + 1)) {
                }
            }
            i = i2;
            if (sb != null) {
                str = new String(cArr, this.pos, i);
            } else {
                sb.append(cArr, this.pos, i);
                str = sb.toString();
            }
            this.pos += i;
            return str;
        } while (fillBuffer(1));
        if (sb != null) {
        }
        this.pos += i;
        return str;
    }

    public final int peek() {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void push(int i) {
        int i2 = this.stackSize;
        if (i2 - 1 < 255) {
            int[] iArr = this.stack;
            if (i2 == iArr.length) {
                int i3 = i2 * 2;
                this.stack = Arrays.copyOf(iArr, i3);
                this.pathIndices = Arrays.copyOf(this.pathIndices, i3);
                this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i3);
            }
            int[] iArr2 = this.stack;
            int i4 = this.stackSize;
            this.stackSize = i4 + 1;
            iArr2[i4] = i;
            return;
        }
        throw new IOException("Nesting limit 255 reached" + locationString());
    }

    public final char readEscapeCharacter() {
        int i;
        if (this.pos != this.limit || fillBuffer(1)) {
            int i2 = this.pos;
            int i3 = i2 + 1;
            this.pos = i3;
            char[] cArr = this.buffer;
            char c = cArr[i2];
            if (c != '\n') {
                if (c != '\"') {
                    if (c != '\'') {
                        if (!(c == '/' || c == '\\')) {
                            if (c == 'b') {
                                return '\b';
                            }
                            if (c == 'f') {
                                return '\f';
                            }
                            if (c == 'n') {
                                return '\n';
                            }
                            if (c == 'r') {
                                return '\r';
                            }
                            if (c == 't') {
                                return '\t';
                            }
                            if (c != 'u') {
                                syntaxError("Invalid escape sequence");
                                throw null;
                            } else if (i2 + 5 <= this.limit || fillBuffer(4)) {
                                int i4 = this.pos;
                                int i5 = i4 + 4;
                                int i6 = 0;
                                while (i4 < i5) {
                                    char c2 = cArr[i4];
                                    int i7 = i6 << 4;
                                    if (c2 >= '0' && c2 <= '9') {
                                        i = c2 - '0';
                                    } else if (c2 >= 'a' && c2 <= 'f') {
                                        i = c2 - 'W';
                                    } else if (c2 < 'A' || c2 > 'F') {
                                        syntaxError("Malformed Unicode escape \\u".concat(new String(cArr, this.pos, 4)));
                                        throw null;
                                    } else {
                                        i = c2 - '7';
                                    }
                                    i6 = i + i7;
                                    i4++;
                                }
                                this.pos += 4;
                                return (char) i6;
                            } else {
                                syntaxError("Unterminated escape sequence");
                                throw null;
                            }
                        }
                    }
                }
                return c;
            } else if (this.strictness != 3) {
                this.lineNumber++;
                this.lineStart = i3;
            } else {
                syntaxError("Cannot escape a newline character in strict mode");
                throw null;
            }
            if (this.strictness == 3) {
                syntaxError("Invalid escaped character \"'\" in strict mode");
                throw null;
            }
            return c;
        }
        syntaxError("Unterminated escape sequence");
        throw null;
    }

    public final void setStrictness(int i) {
        if (i != 0) {
            this.strictness = i;
            return;
        }
        throw null;
    }

    public final void skipQuotedValue(char c) {
        do {
            int i = this.pos;
            int i2 = this.limit;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = this.buffer[i];
                if (c2 == c) {
                    this.pos = i3;
                    return;
                } else if (c2 == '\\') {
                    this.pos = i3;
                    readEscapeCharacter();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    if (c2 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i3;
                    }
                    i = i3;
                }
            }
            this.pos = i;
        } while (fillBuffer(1));
        syntaxError("Unterminated string");
        throw null;
    }

    public final void skipToEndOfLine() {
        char c;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                int i = this.pos;
                int i2 = i + 1;
                this.pos = i2;
                c = this.buffer[i];
                if (c == '\n') {
                    this.lineNumber++;
                    this.lineStart = i2;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        checkLenient();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void skipUnquotedValue() {
        do {
            int i = 0;
            while (true) {
                int i2 = this.pos;
                if (i2 + i < this.limit) {
                    char c = this.buffer[i2 + i];
                    if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ')) {
                        if (c != '#') {
                            if (c != ',') {
                                if (!(c == '/' || c == '=')) {
                                    if (!(c == '{' || c == '}' || c == ':')) {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.pos = i2 + i;
                }
            }
            this.pos += i;
            return;
        } while (fillBuffer(1));
    }

    public final void skipValue() {
        int i = 0;
        do {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            switch (i2) {
                case 1:
                    push(3);
                    i++;
                    break;
                case 2:
                    if (i == 0) {
                        this.pathNames[this.stackSize - 1] = null;
                    }
                    this.stackSize--;
                    i--;
                    break;
                case 3:
                    push(1);
                    i++;
                    break;
                case 4:
                    this.stackSize--;
                    i--;
                    break;
                case 8:
                    skipQuotedValue('\'');
                    break;
                case 9:
                    skipQuotedValue('\"');
                    break;
                case 10:
                    skipUnquotedValue();
                    break;
                case 12:
                    skipQuotedValue('\'');
                    if (i == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                        break;
                    }
                    break;
                case 13:
                    skipQuotedValue('\"');
                    if (i == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                        break;
                    }
                    break;
                case 14:
                    skipUnquotedValue();
                    if (i == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                        break;
                    }
                    break;
                case 16:
                    this.pos += this.peekedNumberLength;
                    break;
                case 17:
                    return;
            }
            this.peeked = 0;
        } while (i > 0);
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public final void syntaxError(String str) {
        throw new IOException(str + locationString() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
    }

    public final String toString() {
        return "JsonReader" + locationString();
    }

    public final IllegalStateException unexpectedTokenError(String str) {
        String str2;
        if (peek() == 9) {
            str2 = "adapter-not-null-safe";
        } else {
            str2 = "unexpected-json-structure";
        }
        StringBuilder m = ViewModelProvider.Factory.CC.m594m("Expected ", str, " but was ");
        m.append(ViewModelProvider.Factory.CC.stringValueOf$4(peek()));
        m.append(locationString());
        m.append("\nSee ");
        m.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(m.toString());
    }
}
