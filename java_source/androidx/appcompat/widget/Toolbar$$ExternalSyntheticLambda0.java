package androidx.appcompat.widget;

import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.Toolbar;
/* loaded from: classes.dex */
public final /* synthetic */ class Toolbar$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Toolbar f$0;

    public /* synthetic */ Toolbar$$ExternalSyntheticLambda0(Toolbar toolbar, int i) {
        this.$r8$classId = i;
        this.f$0 = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MenuItemImpl menuItemImpl;
        switch (this.$r8$classId) {
            case 0:
                Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.f$0.mExpandedMenuPresenter;
                if (expandedActionViewMenuPresenter == null) {
                    menuItemImpl = null;
                } else {
                    menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
                }
                if (menuItemImpl != null) {
                    menuItemImpl.collapseActionView();
                    return;
                }
                return;
            default:
                this.f$0.invalidateMenu();
                return;
        }
    }
}
