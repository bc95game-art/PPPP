package androidx.navigation.internal;

import androidx.navigation.NavBackStackEntry;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
/* loaded from: classes.dex */
public final /* synthetic */ class NavControllerImpl$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ Ref$BooleanRef f$0;
    public final /* synthetic */ Ref$BooleanRef f$1;
    public final /* synthetic */ NavControllerImpl f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ ArrayDeque f$4;

    public /* synthetic */ NavControllerImpl$$ExternalSyntheticLambda2(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, NavControllerImpl navControllerImpl, boolean z, ArrayDeque arrayDeque) {
        this.f$0 = ref$BooleanRef;
        this.f$1 = ref$BooleanRef2;
        this.f$2 = navControllerImpl;
        this.f$3 = z;
        this.f$4 = arrayDeque;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NavBackStackEntry entry = (NavBackStackEntry) obj;
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.f$0.element = true;
        this.f$1.element = true;
        this.f$2.popEntryFromBackStack$navigation_runtime_release(entry, this.f$3, this.f$4);
        return Unit.INSTANCE;
    }
}
