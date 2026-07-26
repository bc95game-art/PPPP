package androidx.lifecycle;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class ViewModelStore {
    public final LinkedHashMap map = new LinkedHashMap();

    public final void clear() {
        LinkedHashMap linkedHashMap = this.map;
        for (ViewModel viewModel : linkedHashMap.values()) {
            viewModel.clear$lifecycle_viewmodel_release();
        }
        linkedHashMap.clear();
    }
}
