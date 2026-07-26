package androidx.navigation;

import android.os.Bundle;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final /* synthetic */ class NavDeepLink$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ NavDeepLink$$ExternalSyntheticLambda8(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean containsKey;
        switch (this.$r8$classId) {
            case 0:
                Bundle source = (Bundle) this.f$0;
                String argName = (String) obj;
                Intrinsics.checkNotNullParameter(argName, "argName");
                Intrinsics.checkNotNullParameter(source, "source");
                containsKey = source.containsKey(argName);
                break;
            case 1:
                Bundle source2 = (Bundle) this.f$0;
                String key = (String) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(source2, "source");
                containsKey = source2.containsKey(key);
                break;
            default:
                NavBackStackEntry entry = (NavBackStackEntry) obj;
                Intrinsics.checkNotNullParameter(entry, "entry");
                return new MenuHostHelper$$ExternalSyntheticLambda1((FragmentNavigator) this.f$0, 1, entry);
        }
        return Boolean.valueOf(!containsKey);
    }
}
