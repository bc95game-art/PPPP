package com.android.billingclient.api;

import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.text.TextDirectionHeuristicsCompat;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzji;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class zzcn implements MenuPresenter.Callback {
    public boolean zza;
    public Object zzb;

    public /* synthetic */ zzcn(Object obj) {
        this.zzb = obj;
    }

    public boolean defaultIsRtl() {
        return this.zza;
    }

    public boolean isRtl(CharSequence charSequence, int i) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        }
        TextDirectionHeuristicsCompat.FirstStrong firstStrong = (TextDirectionHeuristicsCompat.FirstStrong) this.zzb;
        if (firstStrong == null) {
            return defaultIsRtl();
        }
        firstStrong.getClass();
        char c = 2;
        for (int i2 = 0; i2 < i && c == 2; i2++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i2));
            zzcn zzcnVar = TextDirectionHeuristicsCompat.LTR;
            if (directionality != 0) {
                if (!(directionality == 1 || directionality == 2)) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case 16:
                        case 17:
                            break;
                        default:
                            c = 2;
                            break;
                    }
                }
                c = 0;
            }
            c = 1;
        }
        if (c == 0) {
            return true;
        }
        if (c != 1) {
            return defaultIsRtl();
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        ActionMenuPresenter actionMenuPresenter;
        ToolbarActionBar toolbarActionBar = (ToolbarActionBar) this.zzb;
        if (!this.zza) {
            this.zza = true;
            ActionMenuView actionMenuView = toolbarActionBar.mDecorToolbar.mToolbar.mMenuView;
            if (!(actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null)) {
                actionMenuPresenter.hideOverflowMenu();
                ActionMenuPresenter.OverflowPopup overflowPopup = actionMenuPresenter.mActionButtonPopup;
                if (overflowPopup != null && overflowPopup.isShowing()) {
                    overflowPopup.mPopup.dismiss();
                }
            }
            toolbarActionBar.mWindowCallback.onPanelClosed(108, menuBuilder);
            this.zza = false;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        ((ToolbarActionBar) this.zzb).mWindowCallback.onMenuOpened(108, menuBuilder);
        return true;
    }

    public void zza(zzji zzjiVar) {
        if (this.zza) {
            zzc.zzn("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            ((MatcherMatchResult) this.zzb).send(new AutoValue_Event(zzjiVar));
        } catch (Throwable unused) {
            zzc.zzn("BillingLogger", "logging failed.");
        }
    }

    public /* synthetic */ zzcn(Object obj, boolean z) {
        this.zzb = obj;
        this.zza = z;
    }

    public zzcn(TextDirectionHeuristicsCompat.FirstStrong firstStrong, boolean z) {
        this(firstStrong);
        this.zza = z;
    }
}
