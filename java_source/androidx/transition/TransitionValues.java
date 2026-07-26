package androidx.transition;

import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class TransitionValues {
    public final View view;
    public final HashMap values = new HashMap();
    public final ArrayList mTargetedTransitions = new ArrayList();

    public TransitionValues(View view) {
        this.view = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        if (this.view != transitionValues.view || !this.values.equals(transitionValues.values)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public final String toString() {
        HashMap hashMap;
        String m = ViewModelProvider.Factory.CC.m596m(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n", "    values:");
        for (String str : this.values.keySet()) {
            m = m + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return m;
    }
}
