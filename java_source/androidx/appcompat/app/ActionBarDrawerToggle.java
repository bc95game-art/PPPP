package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.activities.MainActivity;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    public final Delegate mActivityImpl;
    public final int mCloseDrawerContentDescRes;
    public final DrawerLayout mDrawerLayout;
    public final int mOpenDrawerContentDescRes;
    public final DrawerArrowDrawable mSlider;
    public boolean mWarnedForDisplayHomeAsUp = false;

    /* loaded from: classes.dex */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(int i);

        void setActionBarUpIndicator(DrawerArrowDrawable drawerArrowDrawable, int i);
    }

    /* loaded from: classes.dex */
    public interface DelegateProvider {
        Delegate getDrawerToggleDelegate();
    }

    public ActionBarDrawerToggle(MainActivity mainActivity, DrawerLayout drawerLayout, Toolbar toolbar) {
        if (toolbar != null) {
            this.mActivityImpl = new MatcherMatchResult(toolbar);
            toolbar.setNavigationOnClickListener(new Toolbar.View$OnClickListenerC00394(1, this));
        } else {
            this.mActivityImpl = mainActivity.getDrawerToggleDelegate();
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = C0130R.string.open_nav_drawer;
        this.mCloseDrawerContentDescRes = C0130R.string.close_nav_drawer;
        this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
        this.mActivityImpl.getThemeUpIndicator();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void onDrawerClosed(View view) {
        setPosition(0.0f);
        this.mActivityImpl.setActionBarDescription(this.mOpenDrawerContentDescRes);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void onDrawerOpened(View view) {
        setPosition(1.0f);
        this.mActivityImpl.setActionBarDescription(this.mCloseDrawerContentDescRes);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public final void onDrawerSlide(float f) {
        setPosition(Math.min(1.0f, Math.max(0.0f, f)));
    }

    public final void setPosition(float f) {
        DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
        if (f == 1.0f) {
            if (!drawerArrowDrawable.mVerticalMirror) {
                drawerArrowDrawable.mVerticalMirror = true;
                drawerArrowDrawable.invalidateSelf();
            }
        } else if (f == 0.0f && drawerArrowDrawable.mVerticalMirror) {
            drawerArrowDrawable.mVerticalMirror = false;
            drawerArrowDrawable.invalidateSelf();
        }
        drawerArrowDrawable.setProgress(f);
    }
}
