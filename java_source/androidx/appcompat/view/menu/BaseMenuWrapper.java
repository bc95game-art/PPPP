package androidx.appcompat.view.menu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager$1;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
/* loaded from: classes.dex */
public abstract class BaseMenuWrapper {
    public Object mContext;
    public Object mMenuItems;

    public BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    public void cleanup() {
        AppCompatDelegateImpl$AutoNightModeManager$1 appCompatDelegateImpl$AutoNightModeManager$1 = (AppCompatDelegateImpl$AutoNightModeManager$1) this.mContext;
        if (appCompatDelegateImpl$AutoNightModeManager$1 != null) {
            try {
                ((AppCompatDelegateImpl) this.mMenuItems).mContext.unregisterReceiver(appCompatDelegateImpl$AutoNightModeManager$1);
            } catch (IllegalArgumentException unused) {
            }
            this.mContext = null;
        }
    }

    public abstract IntentFilter createIntentFilterForBroadcastReceiver();

    public abstract int getApplyableNightMode();

    public MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (((SimpleArrayMap) this.mMenuItems) == null) {
            this.mMenuItems = new SimpleArrayMap(0);
        }
        MenuItem menuItem2 = (MenuItem) ((SimpleArrayMap) this.mMenuItems).get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS((Context) this.mContext, supportMenuItem);
        ((SimpleArrayMap) this.mMenuItems).put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public abstract void onChange();

    public void setup() {
        cleanup();
        IntentFilter createIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
        if (createIntentFilterForBroadcastReceiver.countActions() != 0) {
            if (((AppCompatDelegateImpl$AutoNightModeManager$1) this.mContext) == null) {
                this.mContext = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager$1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        BaseMenuWrapper.this.onChange();
                    }
                };
            }
            ((AppCompatDelegateImpl) this.mMenuItems).mContext.registerReceiver((AppCompatDelegateImpl$AutoNightModeManager$1) this.mContext, createIntentFilterForBroadcastReceiver);
        }
    }

    public BaseMenuWrapper(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.mMenuItems = appCompatDelegateImpl;
    }
}
