package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class MenuAdapter extends BaseAdapter {
    public final MenuBuilder mAdapterMenu;
    public int mExpandedIndex = -1;
    public boolean mForceShowIcon;
    public final LayoutInflater mInflater;
    public final int mItemLayoutRes;
    public final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.mOverflowOnly = z;
        this.mInflater = layoutInflater;
        this.mAdapterMenu = menuBuilder;
        this.mItemLayoutRes = i;
        findExpandedIndex();
    }

    public final void findExpandedIndex() {
        MenuBuilder menuBuilder = this.mAdapterMenu;
        MenuItemImpl menuItemImpl = menuBuilder.mExpandedItem;
        if (menuItemImpl != null) {
            menuBuilder.flagActionItems();
            ArrayList arrayList = menuBuilder.mNonActionItems;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((MenuItemImpl) arrayList.get(i)) == menuItemImpl) {
                    this.mExpandedIndex = i;
                    return;
                }
            }
        }
        this.mExpandedIndex = -1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayList;
        boolean z = this.mOverflowOnly;
        MenuBuilder menuBuilder = this.mAdapterMenu;
        if (z) {
            menuBuilder.flagActionItems();
            arrayList = menuBuilder.mNonActionItems;
        } else {
            arrayList = menuBuilder.getVisibleItems();
        }
        if (this.mExpandedIndex < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        boolean z = false;
        if (view == null) {
            view = this.mInflater.inflate(this.mItemLayoutRes, viewGroup, false);
        }
        int i3 = getItem(i).mGroup;
        int i4 = i - 1;
        if (i4 >= 0) {
            i2 = getItem(i4).mGroup;
        } else {
            i2 = i3;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.mAdapterMenu.isGroupDividerEnabled() && i3 != i2) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.mForceShowIcon) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final MenuItemImpl getItem(int i) {
        ArrayList arrayList;
        boolean z = this.mOverflowOnly;
        MenuBuilder menuBuilder = this.mAdapterMenu;
        if (z) {
            menuBuilder.flagActionItems();
            arrayList = menuBuilder.mNonActionItems;
        } else {
            arrayList = menuBuilder.getVisibleItems();
        }
        int i2 = this.mExpandedIndex;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (MenuItemImpl) arrayList.get(i);
    }
}
