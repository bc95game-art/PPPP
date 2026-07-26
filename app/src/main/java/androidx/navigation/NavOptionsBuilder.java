package androidx.navigation;

import androidx.navigation.NavOptions;
/* loaded from: classes.dex */
public final class NavOptionsBuilder {
    public final NavOptions.Builder builder;
    public boolean launchSingleTop;
    public int popUpToId = -1;
    public boolean restoreState;
    public boolean saveState;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.navigation.NavOptions$Builder, java.lang.Object] */
    public NavOptionsBuilder() {
        ?? obj = new Object();
        obj.enterAnim = -1;
        obj.exitAnim = -1;
        this.builder = obj;
    }
}
