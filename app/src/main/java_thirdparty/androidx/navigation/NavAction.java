package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class NavAction {
    public final int destinationId;
    public NavOptions navOptions = null;
    public Bundle defaultArguments = null;

    public NavAction(int i) {
        this.destinationId = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NavAction)) {
            return false;
        }
        NavAction navAction = (NavAction) obj;
        if (this.destinationId != navAction.destinationId || !Intrinsics.areEqual(this.navOptions, navAction.navOptions)) {
            return false;
        }
        Bundle bundle = this.defaultArguments;
        Bundle bundle2 = navAction.defaultArguments;
        if (Intrinsics.areEqual(bundle, bundle2)) {
            return true;
        }
        if (bundle == null || bundle2 == null || !Navigation.contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(bundle, bundle2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2 = this.destinationId * 31;
        NavOptions navOptions = this.navOptions;
        if (navOptions != null) {
            i = navOptions.hashCode();
        } else {
            i = 0;
        }
        int i3 = i2 + i;
        Bundle bundle = this.defaultArguments;
        if (bundle == null) {
            return i3;
        }
        return Navigation.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(bundle) + (i3 * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavAction(0x");
        sb.append(Integer.toHexString(this.destinationId));
        sb.append(")");
        if (this.navOptions != null) {
            sb.append(" navOptions=");
            sb.append(this.navOptions);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
