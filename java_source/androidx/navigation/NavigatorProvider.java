package androidx.navigation;

import androidx.lifecycle.ViewModelProvider;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class NavigatorProvider {
    public static final LinkedHashMap annotationNames = new LinkedHashMap();
    public final LinkedHashMap _navigators = new LinkedHashMap();

    public final void addNavigator(Navigator navigator) {
        String nameForNavigator$navigation_common_release = Navigation.getNameForNavigator$navigation_common_release(navigator.getClass());
        if (nameForNavigator$navigation_common_release.length() > 0) {
            LinkedHashMap linkedHashMap = this._navigators;
            Navigator navigator2 = (Navigator) linkedHashMap.get(nameForNavigator$navigation_common_release);
            if (!Intrinsics.areEqual(navigator2, navigator)) {
                if (navigator2 != null && navigator2.isAttached) {
                    throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
                } else if (!navigator.isAttached) {
                    Navigator navigator3 = (Navigator) linkedHashMap.put(nameForNavigator$navigation_common_release, navigator);
                } else {
                    throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
                }
            }
        } else {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
    }

    public final Navigator getNavigator(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name.length() > 0) {
            Navigator navigator = (Navigator) this._navigators.get(name);
            if (navigator != null) {
                return navigator;
            }
            throw new IllegalStateException(ViewModelProvider.Factory.CC.m595m("Could not find Navigator with name \"", name, "\". You must call NavController.addNavigator() for each navigation type."));
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}
