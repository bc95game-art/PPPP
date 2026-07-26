package com.google.gson.internal;
/* loaded from: classes.dex */
public final class Streams$AppendableWriter$CurrentWrite implements CharSequence {
    public String cachedString;
    public char[] chars;

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.chars[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.chars.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new String(this.chars, i, i2 - i);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.cachedString == null) {
            this.cachedString = new String(this.chars);
        }
        return this.cachedString;
    }
}
