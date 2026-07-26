package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class CheckableGroup {
    public final HashMap checkables = new HashMap();
    public final HashSet checkedIds = new HashSet();
    public ChipGroup.AnonymousClass1 onCheckedStateChangeListener;
    public boolean selectionRequired;
    public boolean singleSelection;

    public final boolean checkInternal(MaterialCheckable materialCheckable) {
        int id = materialCheckable.getId();
        Integer valueOf = Integer.valueOf(id);
        HashSet hashSet = this.checkedIds;
        if (hashSet.contains(valueOf)) {
            return false;
        }
        MaterialCheckable materialCheckable2 = (MaterialCheckable) this.checkables.get(Integer.valueOf(getSingleCheckedId()));
        if (materialCheckable2 != null) {
            uncheckInternal(materialCheckable2, false);
        }
        boolean add = hashSet.add(Integer.valueOf(id));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return add;
    }

    public final ArrayList getCheckedIdsSortedByChildOrder(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet(this.checkedIds);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MaterialCheckable) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public final int getSingleCheckedId() {
        if (!this.singleSelection) {
            return -1;
        }
        HashSet hashSet = this.checkedIds;
        if (!hashSet.isEmpty()) {
            return ((Integer) hashSet.iterator().next()).intValue();
        }
        return -1;
    }

    public final void onCheckedStateChanged() {
        ChipGroup.AnonymousClass1 r0 = this.onCheckedStateChangeListener;
        if (r0 != null) {
            new HashSet(this.checkedIds);
            ChipGroup chipGroup = ChipGroup.this;
            ChipGroup.OnCheckedStateChangeListener onCheckedStateChangeListener = chipGroup.onCheckedStateChangeListener;
            if (onCheckedStateChangeListener != null) {
                onCheckedStateChangeListener.onCheckedChanged(chipGroup, chipGroup.checkableGroup.getCheckedIdsSortedByChildOrder(chipGroup));
            }
        }
    }

    public final boolean uncheckInternal(MaterialCheckable materialCheckable, boolean z) {
        int id = materialCheckable.getId();
        Integer valueOf = Integer.valueOf(id);
        HashSet hashSet = this.checkedIds;
        if (!hashSet.contains(valueOf)) {
            return false;
        }
        if (!z || hashSet.size() != 1 || !hashSet.contains(Integer.valueOf(id))) {
            boolean remove = hashSet.remove(Integer.valueOf(id));
            if (materialCheckable.isChecked()) {
                materialCheckable.setChecked(false);
            }
            return remove;
        }
        materialCheckable.setChecked(true);
        return false;
    }
}
