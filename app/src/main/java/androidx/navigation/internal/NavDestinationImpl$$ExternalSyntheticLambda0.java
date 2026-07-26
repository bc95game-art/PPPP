package androidx.navigation.internal;

import androidx.navigation.NavDeepLink;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final /* synthetic */ class NavDestinationImpl$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NavDeepLink f$0;

    public /* synthetic */ NavDestinationImpl$$ExternalSyntheticLambda0(NavDeepLink navDeepLink, int i) {
        this.$r8$classId = i;
        this.f$0 = navDeepLink;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean contains;
        String key = (String) obj;
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(key, "key");
                contains = this.f$0.getArgumentsNames$navigation_common_release().contains(key);
                break;
            default:
                Intrinsics.checkNotNullParameter(key, "key");
                contains = this.f$0.getArgumentsNames$navigation_common_release().contains(key);
                break;
        }
        return Boolean.valueOf(!contains);
    }
}
