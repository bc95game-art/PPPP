package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import com.emanuelef.remote_capture.C0130R;
/* loaded from: classes.dex */
public abstract class ViewUtilsLollipop {
    public static final int[] STATE_LIST_ANIM_ATTRS = {16843848};

    public static void setDefaultAppBarLayoutStateListAnimator(AppBarLayout appBarLayout, float f) {
        int integer = appBarLayout.getResources().getInteger(C0130R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{16842910, C0130R.attr.state_liftable, -2130969784}, ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{16842910}, ObjectAnimator.ofFloat(appBarLayout, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(0L));
        appBarLayout.setStateListAnimator(stateListAnimator);
    }
}
