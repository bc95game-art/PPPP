package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class Result$Failure implements Serializable {
    public final Throwable exception;

    public Result$Failure(Throwable th) {
        this.exception = th;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Result$Failure)) {
            return false;
        }
        if (Intrinsics.areEqual(this.exception, ((Result$Failure) obj).exception)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.exception.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.exception + ')';
    }
}
