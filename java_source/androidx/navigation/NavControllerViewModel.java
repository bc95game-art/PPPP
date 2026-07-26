package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class NavControllerViewModel extends ViewModel {
    public final LinkedHashMap viewModelStores = new LinkedHashMap();

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        LinkedHashMap linkedHashMap = this.viewModelStores;
        for (ViewModelStore viewModelStore : linkedHashMap.values()) {
            viewModelStore.clear();
        }
        linkedHashMap.clear();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        long identityHashCode = System.identityHashCode(this) & 4294967295L;
        if (identityHashCode >= 0) {
            str = Long.toString(identityHashCode, 16);
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        } else {
            long j = 16;
            long j2 = ((identityHashCode >>> 1) / j) << 1;
            long j3 = identityHashCode - (j2 * j);
            if (j3 >= j) {
                j3 -= j;
                j2++;
            }
            String l = Long.toString(j2, 16);
            Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
            String l2 = Long.toString(j3, 16);
            Intrinsics.checkNotNullExpressionValue(l2, "toString(...)");
            str = l.concat(l2);
        }
        sb.append(str);
        sb.append("} ViewModelStores (");
        Iterator it = this.viewModelStores.keySet().iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
