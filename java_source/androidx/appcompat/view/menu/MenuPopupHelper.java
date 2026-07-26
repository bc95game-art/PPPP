package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPresenter;
import com.emanuelef.remote_capture.C0130R;
/* loaded from: classes.dex */
public class MenuPopupHelper {
    public View mAnchorView;
    public final Context mContext;
    public boolean mForceShowIcon;
    public final MenuBuilder mMenu;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public MenuPopup mPopup;
    public final int mPopupStyleAttr;
    public MenuPresenter.Callback mPresenterCallback;
    public int mDropDownGravity = 8388611;
    public final C00191 mInternalOnDismissListener = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            MenuPopupHelper.this.onDismiss();
        }
    };

    /* JADX WARN: Type inference failed for: r6v2, types: [androidx.appcompat.view.menu.MenuPopupHelper$1] */
    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
    }

    public final MenuPopup getPopup() {
        MenuPopup menuPopup;
        if (this.mPopup == null) {
            Context context = this.mContext;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(C0130R.dimen.abc_cascading_menus_min_smallest_width)) {
                menuPopup = new CascadingMenuPopup(context, this.mAnchorView, this.mPopupStyleAttr, this.mOverflowOnly);
            } else {
                menuPopup = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mOverflowOnly);
            }
            menuPopup.addMenu(this.mMenu);
            menuPopup.setOnDismissListener(this.mInternalOnDismissListener);
            menuPopup.setAnchorView(this.mAnchorView);
            menuPopup.setCallback(this.mPresenterCallback);
            menuPopup.setForceShowIcon(this.mForceShowIcon);
            menuPopup.setGravity(this.mDropDownGravity);
            this.mPopup = menuPopup;
        }
        return this.mPopup;
    }

    public final boolean isShowing() {
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup == null || !menuPopup.isShowing()) {
            return false;
        }
        return true;
    }

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void showPopup(int i, int i2, boolean z, boolean z2) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, this.mAnchorView.getLayoutDirection()) & 7) == 5) {
                i -= this.mAnchorView.getWidth();
            }
            popup.setHorizontalOffset(i);
            popup.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.mEpicenterBounds = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        popup.show();
    }
}
