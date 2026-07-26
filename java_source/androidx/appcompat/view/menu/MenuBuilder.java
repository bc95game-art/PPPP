package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class MenuBuilder implements Menu {
    public static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    public Callback mCallback;
    public final Context mContext;
    public MenuItemImpl mExpandedItem;
    public Drawable mHeaderIcon;
    public CharSequence mHeaderTitle;
    public View mHeaderView;
    public boolean mOverrideVisibleItems;
    public boolean mQwertyMode;
    public final Resources mResources;
    public final boolean mShortcutsVisible;
    public int mDefaultShowAsAction = 0;
    public boolean mPreventDispatchingItemsChanged = false;
    public boolean mItemsChangedWhileDispatchPrevented = false;
    public boolean mStructureChangedWhileDispatchPrevented = false;
    public boolean mIsClosing = false;
    public final ArrayList mTempShortcutItemList = new ArrayList();
    public final CopyOnWriteArrayList mPresenters = new CopyOnWriteArrayList();
    public boolean mGroupDividerEnabled = false;
    public final ArrayList mItems = new ArrayList();
    public final ArrayList mVisibleItems = new ArrayList();
    public boolean mIsVisibleItemsStale = true;
    public final ArrayList mActionItems = new ArrayList();
    public final ArrayList mNonActionItems = new ArrayList();
    public boolean mIsActionItemsStale = true;

    /* loaded from: classes.dex */
    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    /* loaded from: classes.dex */
    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        boolean z;
        boolean z2 = false;
        this.mContext = context;
        Resources resources = context.getResources();
        this.mResources = resources;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
            if (Build.VERSION.SDK_INT >= 28) {
                z = ViewConfigurationCompat.Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                if (identifier == 0 || !resources2.getBoolean(identifier)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                z2 = true;
            }
        }
        this.mShortcutsVisible = z2;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        Intent intent2;
        int i6;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i5 = queryIntentActivityOptions.size();
        } else {
            i5 = 0;
        }
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i7 = 0; i7 < i5; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            if (i8 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i8];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItemImpl addInternal = addInternal(i, i2, i3, resolveInfo.loadLabel(packageManager));
            addInternal.setIcon(resolveInfo.loadIcon(packageManager));
            addInternal.mIntent = intent3;
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = addInternal;
            }
        }
        return i5;
    }

    public final MenuItemImpl addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = ((-65536) & i3) >> 16;
        if (i5 < 0 || i5 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i6 = (sCategoryToOrder[i5] << 16) | (65535 & i3);
        MenuItemImpl menuItemImpl = new MenuItemImpl(this, i, i2, i3, i6, charSequence, this.mDefaultShowAsAction);
        ArrayList arrayList = this.mItems;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i4 = 0;
                break;
            } else if (((MenuItemImpl) arrayList.get(size)).mOrdering <= i6) {
                i4 = size + 1;
                break;
            } else {
                size--;
            }
        }
        arrayList.add(i4, menuItemImpl);
        onItemsChanged(true);
        return menuItemImpl;
    }

    public final void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.mPresenters.add(new WeakReference(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        MenuItemImpl menuItemImpl = this.mExpandedItem;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public final void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z) {
        if (!this.mIsClosing) {
            this.mIsClosing = true;
            CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    menuPresenter.onCloseMenu(this, z);
                }
            }
            this.mIsClosing = false;
        }
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
        boolean z = false;
        if (!copyOnWriteArrayList.isEmpty() && this.mExpandedItem == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z = menuPresenter.collapseItemActionView(menuItemImpl);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.mExpandedItem = null;
            }
        }
        return z;
    }

    public boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        Callback callback = this.mCallback;
        if (callback == null || !callback.onMenuItemSelected(menuBuilder, menuItem)) {
            return false;
        }
        return true;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
        boolean z = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z = menuPresenter.expandItemActionView(menuItemImpl);
                if (z) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z) {
            this.mExpandedItem = menuItemImpl;
        }
        return z;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem findItem;
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i2);
            if (menuItemImpl.mId == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.mSubMenu.findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final MenuItemImpl findItemWithShortcutForKey(int i, KeyEvent keyEvent) {
        char c;
        ArrayList arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (MenuItemImpl) arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i2);
            if (isQwertyMode) {
                c = menuItemImpl.mShortcutAlphabeticChar;
            } else {
                c = menuItemImpl.mShortcutNumericChar;
            }
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c == '\b' && i == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public final void findItemsWithShortcutForKey(List list, int i, KeyEvent keyEvent) {
        char c;
        int i2;
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList = this.mItems;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i3);
                if (menuItemImpl.hasSubMenu()) {
                    menuItemImpl.mSubMenu.findItemsWithShortcutForKey(list, i, keyEvent);
                }
                if (isQwertyMode) {
                    c = menuItemImpl.mShortcutAlphabeticChar;
                } else {
                    c = menuItemImpl.mShortcutNumericChar;
                }
                if (isQwertyMode) {
                    i2 = menuItemImpl.mShortcutAlphabeticModifiers;
                } else {
                    i2 = menuItemImpl.mShortcutNumericModifiers;
                }
                if ((modifiers & 69647) == (i2 & 69647) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (isQwertyMode && c == '\b' && i == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    public final void flagActionItems() {
        ArrayList visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z |= menuPresenter.flagActionItems();
                }
            }
            ArrayList arrayList = this.mActionItems;
            ArrayList arrayList2 = this.mNonActionItems;
            if (z) {
                arrayList.clear();
                arrayList2.clear();
                int size = visibleItems.size();
                for (int i = 0; i < size; i++) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) visibleItems.get(i);
                    if ((menuItemImpl.mFlags & 32) == 32) {
                        arrayList.add(menuItemImpl);
                    } else {
                        arrayList2.add(menuItemImpl);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public String getActionViewStatesKey() {
        return "android:menu:actionviewstates";
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.mItems.get(i);
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public final ArrayList getVisibleItems() {
        boolean z = this.mIsVisibleItemsStale;
        ArrayList arrayList = this.mVisibleItems;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.mItems;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList2.get(i);
            if (menuItemImpl.isVisible()) {
                arrayList.add(menuItemImpl);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return arrayList;
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((MenuItemImpl) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        if (findItemWithShortcutForKey(i, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public void onItemsChanged(boolean z) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
            if (!copyOnWriteArrayList.isEmpty()) {
                stopDispatchingItemsChanged();
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                    if (menuPresenter == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        menuPresenter.updateMenuView();
                    }
                }
                startDispatchingItemsChanged();
                return;
            }
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), null, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i) {
        boolean z;
        MenuItemWrapperICS.ActionProviderWrapper actionProviderWrapper;
        boolean z2;
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        boolean z3 = false;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        MenuBuilder menuBuilder = menuItemImpl.mMenu;
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = menuItemImpl.mClickListener;
        if ((onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(menuItemImpl)) && !menuBuilder.dispatchMenuItemSelected(menuBuilder, menuItemImpl)) {
            Intent intent = menuItemImpl.mIntent;
            if (intent != null) {
                try {
                    menuBuilder.mContext.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                }
            }
            MenuItemWrapperICS.ActionProviderWrapper actionProviderWrapper2 = menuItemImpl.mActionProvider;
            if (actionProviderWrapper2 == null || !actionProviderWrapper2.mInner.onPerformDefaultAction()) {
                z = false;
                actionProviderWrapper = menuItemImpl.mActionProvider;
                if (actionProviderWrapper != null || !actionProviderWrapper.mInner.hasSubMenu()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!menuItemImpl.hasCollapsibleActionView()) {
                    z |= menuItemImpl.expandActionView();
                    if (z) {
                        close(true);
                    }
                } else if (menuItemImpl.hasSubMenu() || z2) {
                    if ((i & 4) == 0) {
                        close(false);
                    }
                    if (!menuItemImpl.hasSubMenu()) {
                        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, menuItemImpl);
                        menuItemImpl.mSubMenu = subMenuBuilder;
                        subMenuBuilder.setHeaderTitle(menuItemImpl.mTitle);
                    }
                    SubMenuBuilder subMenuBuilder2 = menuItemImpl.mSubMenu;
                    if (z2) {
                        actionProviderWrapper.mInner.onPrepareSubMenu(subMenuBuilder2);
                    }
                    CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
                    if (!copyOnWriteArrayList.isEmpty()) {
                        if (menuPresenter != null) {
                            z3 = menuPresenter.onSubMenuSelected(subMenuBuilder2);
                        }
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
                            if (menuPresenter2 == null) {
                                copyOnWriteArrayList.remove(weakReference);
                            } else if (!z3) {
                                z3 = menuPresenter2.onSubMenuSelected(subMenuBuilder2);
                            }
                        }
                    }
                    z |= z3;
                    if (!z) {
                        close(true);
                    }
                } else if ((i & 1) == 0) {
                    close(true);
                }
                return z;
            }
        }
        z = true;
        actionProviderWrapper = menuItemImpl.mActionProvider;
        if (actionProviderWrapper != null) {
        }
        z2 = false;
        if (!menuItemImpl.hasCollapsibleActionView()) {
        }
        return z;
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        boolean z;
        MenuItemImpl findItemWithShortcutForKey = findItemWithShortcutForKey(i, keyEvent);
        if (findItemWithShortcutForKey != null) {
            z = performItemAction(findItemWithShortcutForKey, null, i2);
        } else {
            z = false;
        }
        if ((i2 & 2) != 0) {
            close(true);
        }
        return z;
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((MenuItemImpl) arrayList.get(i3)).mGroup == i) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = arrayList.size() - i3;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= size2 || ((MenuItemImpl) arrayList.get(i3)).mGroup != i) {
                    break;
                }
                if (i3 >= 0 && i3 < arrayList.size()) {
                    arrayList.remove(i3);
                }
                i2 = i4;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (((MenuItemImpl) arrayList.get(i2)).mId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0 && i2 < arrayList.size()) {
            arrayList.remove(i2);
            onItemsChanged(true);
        }
    }

    public final void removeMenuPresenter(MenuPresenter menuPresenter) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    public final void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = this.mItems.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public final void saveActionViewStates(Bundle bundle) {
        int size = this.mItems.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i2);
            if (menuItemImpl.mGroup == i) {
                menuItemImpl.setExclusiveCheckable(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.mGroupDividerEnabled = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i2);
            if (menuItemImpl.mGroup == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        int i2;
        ArrayList arrayList = this.mItems;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i3);
            if (menuItemImpl.mGroup == i) {
                int i4 = menuItemImpl.mFlags;
                int i5 = i4 & (-9);
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                int i6 = i5 | i2;
                menuItemImpl.mFlags = i6;
                if (i4 != i6) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    public final void setHeaderInternal(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i > 0) {
                this.mHeaderTitle = this.mResources.getText(i);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i2 > 0) {
                this.mHeaderIcon = ContextCompat$Api21Impl.getDrawable(this.mContext, i2);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.mQwertyMode = z;
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.mItems.size();
    }

    public final void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public final void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return addInternal(0, 0, 0, this.mResources.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl addInternal = addInternal(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, addInternal);
        addInternal.mSubMenu = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(addInternal.mTitle);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(i, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public final void close() {
        close(true);
    }
}
