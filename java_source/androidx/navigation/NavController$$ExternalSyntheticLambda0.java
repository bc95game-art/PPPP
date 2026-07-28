package androidx.navigation;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public final /* synthetic */ class NavController$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ NavController f$0;

    public /* synthetic */ NavController$$ExternalSyntheticLambda0(NavController navController, int i) {
        this.$r8$classId = i;
        this.f$0 = navController;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i;
        switch (this.$r8$classId) {
            case 0:
                NavController navController = this.f$0;
                NavController$onBackPressedCallback$1 navController$onBackPressedCallback$1 = navController.onBackPressedCallback;
                boolean z = false;
                if (navController.enableOnBackPressedCallback) {
                    ArrayDeque arrayDeque = navController.impl.backQueue;
                    if (arrayDeque == null || !arrayDeque.isEmpty()) {
                        Iterator it = arrayDeque.iterator();
                        i = 0;
                        while (it.hasNext()) {
                            if (!(((NavBackStackEntry) it.next()).destination instanceof NavGraph) && (i = i + 1) < 0) {
                                throw new ArithmeticException("Count overflow has happened.");
                            }
                        }
                    } else {
                        i = 0;
                    }
                    if (i > 1) {
                        z = true;
                    }
                }
                navController$onBackPressedCallback$1.setEnabled(z);
                return Unit.INSTANCE;
            default:
                NavController navController2 = this.f$0;
                return new NavInflater(navController2.context, navController2.impl._navigatorProvider);
        }
    }
}
