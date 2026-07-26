package androidx.core.util;

import android.graphics.Rect;
/* loaded from: classes.dex */
public final class Pair {
    public final Rect first;
    public final Rect second;

    public Pair(Rect rect, Rect rect2) {
        this.first = rect;
        this.second = rect2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!pair.first.equals(this.first) || !pair.second.equals(this.second)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.first.hashCode() ^ this.second.hashCode();
    }

    public final String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
