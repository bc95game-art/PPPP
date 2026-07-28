package com.google.gson.internal;
/* loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {
    public final String value;

    public LazilyParsedNumber(String str) {
        this.value = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazilyParsedNumber) {
            return this.value.equals(((LazilyParsedNumber) obj).value);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.value);
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.value;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return Streams.parseBigDecimal(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.value;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return Streams.parseBigDecimal(str).longValue();
        }
    }

    public final String toString() {
        return this.value;
    }
}
