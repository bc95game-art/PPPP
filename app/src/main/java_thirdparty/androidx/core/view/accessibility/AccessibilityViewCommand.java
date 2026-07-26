package androidx.core.view.accessibility;

import android.view.View;
import androidx.core.os.BundleKt;
/* loaded from: classes.dex */
public interface AccessibilityViewCommand {

    /* loaded from: classes.dex */
    public abstract class MoveAtGranularityArguments extends BundleKt {
    }

    /* loaded from: classes.dex */
    public abstract class MoveHtmlArguments extends BundleKt {
    }

    /* loaded from: classes.dex */
    public abstract class MoveWindowArguments extends BundleKt {
    }

    /* loaded from: classes.dex */
    public abstract class ScrollToPositionArguments extends BundleKt {
    }

    /* loaded from: classes.dex */
    public abstract class SetProgressArguments extends BundleKt {
    }

    /* loaded from: classes.dex */
    public abstract class SetSelectionArguments extends BundleKt {
    }

    /* loaded from: classes.dex */
    public abstract class SetTextArguments extends BundleKt {
    }

    boolean perform(View view);
}
