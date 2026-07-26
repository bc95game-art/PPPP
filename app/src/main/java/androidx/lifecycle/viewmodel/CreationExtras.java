package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class CreationExtras {
    public final LinkedHashMap extras = new LinkedHashMap();

    /* loaded from: classes.dex */
    public final class Empty extends CreationExtras {
        public static final Empty INSTANCE = new CreationExtras();

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        public final Object get(Key key) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface Key {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CreationExtras)) {
            return false;
        }
        if (Intrinsics.areEqual(this.extras, ((CreationExtras) obj).extras)) {
            return true;
        }
        return false;
    }

    public abstract Object get(Key key);

    public final int hashCode() {
        return this.extras.hashCode();
    }

    public final String toString() {
        return "CreationExtras(extras=" + this.extras + ')';
    }
}
