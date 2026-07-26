package kotlin.ranges;
/* loaded from: classes.dex */
public final class IntRange extends IntProgression {
    public static final IntRange EMPTY = new IntProgression(1, 0, 1);

    public final boolean equals(Object obj) {
        if (!(obj instanceof IntRange)) {
            return false;
        }
        if (isEmpty() && ((IntRange) obj).isEmpty()) {
            return true;
        }
        IntRange intRange = (IntRange) obj;
        if (this.first == intRange.first && this.last == intRange.last) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    public final boolean isEmpty() {
        if (this.first > this.last) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.first + ".." + this.last;
    }
}
