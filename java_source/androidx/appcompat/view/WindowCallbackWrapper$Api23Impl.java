package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.SearchEvent;
import android.view.Window;
/* loaded from: classes.dex */
public abstract class WindowCallbackWrapper$Api23Impl {
    public static boolean onSearchRequested(Window.Callback callback, SearchEvent searchEvent) {
        return callback.onSearchRequested(searchEvent);
    }

    public static ActionMode onWindowStartingActionMode(Window.Callback callback, ActionMode.Callback callback2, int i) {
        return callback.onWindowStartingActionMode(callback2, i);
    }
}
