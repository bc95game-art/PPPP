package com.google.android.material.internal;

import androidx.appcompat.view.menu.SubMenuBuilder;
/* loaded from: classes.dex */
public final class NavigationSubMenu extends SubMenuBuilder {
    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        this.mParentMenu.onItemsChanged(z);
    }
}
