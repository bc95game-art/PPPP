package com.google.gson.stream;

import com.google.gson.FormattingStyle;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {
    public static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    public String deferredName;
    public String formattedColon;
    public String formattedComma;
    public FormattingStyle formattingStyle;
    public boolean htmlSafe;
    public final Writer out;
    public boolean serializeNulls;
    public int[] stack;
    public int stackSize;
    public int strictness;
    public boolean usesEmptyNewlineAndIndent;
    public static final Pattern VALID_JSON_NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    public static final String[] REPLACEMENT_CHARS = new String[128];

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        if (iArr.length == 0) {
            this.stack = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.stack;
        int i = this.stackSize;
        this.stackSize = i + 1;
        iArr2[i] = 6;
        this.strictness = 2;
        this.serializeNulls = true;
        Objects.requireNonNull(writer, "out == null");
        this.out = writer;
        setFormattingStyle(FormattingStyle.COMPACT);
    }

    public final void beforeValue() {
        int peek = peek();
        if (peek != 1) {
            Writer writer = this.out;
            if (peek == 2) {
                writer.append((CharSequence) this.formattedComma);
                newline();
            } else if (peek != 4) {
                if (peek != 6) {
                    if (peek != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    } else if (this.strictness != 1) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                this.stack[this.stackSize - 1] = 7;
            } else {
                writer.append((CharSequence) this.formattedColon);
                this.stack[this.stackSize - 1] = 5;
            }
        } else {
            this.stack[this.stackSize - 1] = 2;
            newline();
        }
    }

    public void beginArray() {
        writeDeferredName();
        beforeValue();
        int i = this.stackSize;
        int[] iArr = this.stack;
        if (i == iArr.length) {
            this.stack = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        iArr2[i2] = 1;
        this.out.write(91);
    }

    public void beginObject() {
        writeDeferredName();
        beforeValue();
        int i = this.stackSize;
        int[] iArr = this.stack;
        if (i == iArr.length) {
            this.stack = Arrays.copyOf(iArr, i * 2);
        }
        int[] iArr2 = this.stack;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        iArr2[i2] = 3;
        this.out.write(123);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
        int i = this.stackSize;
        if (i > 1 || (i == 1 && this.stack[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public final void closeScope(int i, int i2, char c) {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.deferredName == null) {
            this.stackSize--;
            if (peek == i2) {
                newline();
            }
            this.out.write(c);
        } else {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
    }

    public void endArray() {
        closeScope(1, 2, ']');
    }

    public void endObject() {
        closeScope(3, 5, '}');
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.stackSize != 0) {
            this.out.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public JsonWriter name(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.deferredName == null) {
            int peek = peek();
            if (peek == 3 || peek == 5) {
                this.deferredName = str;
                return this;
            }
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        throw new IllegalStateException("Already wrote a name, expecting a value.");
    }

    public final void newline() {
        if (!this.usesEmptyNewlineAndIndent) {
            String str = this.formattingStyle.newline;
            Writer writer = this.out;
            writer.write(str);
            int i = this.stackSize;
            for (int i2 = 1; i2 < i; i2++) {
                writer.write(this.formattingStyle.indent);
            }
        }
    }

    public JsonWriter nullValue() {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public final int peek() {
        int i = this.stackSize;
        if (i != 0) {
            return this.stack[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void setFormattingStyle(FormattingStyle formattingStyle) {
        boolean z;
        Objects.requireNonNull(formattingStyle);
        this.formattingStyle = formattingStyle;
        this.formattedComma = ",";
        if (formattingStyle.spaceAfterSeparators) {
            this.formattedColon = ": ";
            if (formattingStyle.newline.isEmpty()) {
                this.formattedComma = ", ";
            }
        } else {
            this.formattedColon = ":";
        }
        if (!this.formattingStyle.newline.isEmpty() || !this.formattingStyle.indent.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        this.usesEmptyNewlineAndIndent = z;
    }

    public final void setStrictness(int i) {
        if (i != 0) {
            this.strictness = i;
            return;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void string(String str) {
        String[] strArr;
        String str2;
        if (this.htmlSafe) {
            strArr = HTML_SAFE_REPLACEMENT_CHARS;
        } else {
            strArr = REPLACEMENT_CHARS;
        }
        Writer writer = this.out;
        writer.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    writer.write(str, i, i2 - i);
                }
                writer.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                }
                writer.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            writer.write(str, i, length - i);
        }
        writer.write(34);
    }

    public void value(String str) {
        if (str == null) {
            nullValue();
            return;
        }
        writeDeferredName();
        beforeValue();
        string(str);
    }

    public final void writeDeferredName() {
        if (this.deferredName != null) {
            int peek = peek();
            if (peek == 5) {
                this.out.write(this.formattedComma);
            } else if (peek != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            newline();
            this.stack[this.stackSize - 1] = 4;
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public void value(boolean z) {
        writeDeferredName();
        beforeValue();
        this.out.write(z ? "true" : "false");
    }

    public void value(double d) {
        writeDeferredName();
        if (this.strictness == 1 || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            beforeValue();
            this.out.append((CharSequence) Double.toString(d));
            return;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public void value(long j) {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j));
    }

    public void value(Number number) {
        if (number == null) {
            nullValue();
            return;
        }
        writeDeferredName();
        String obj = number.toString();
        Class<?> cls = number.getClass();
        if (!(cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class)) {
            if (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN")) {
                if (this.strictness != 1) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(obj));
                }
            } else if (!(cls == Float.class || cls == Double.class || VALID_JSON_NUMBER_PATTERN.matcher(obj).matches())) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        }
        beforeValue();
        this.out.append((CharSequence) obj);
    }
}
