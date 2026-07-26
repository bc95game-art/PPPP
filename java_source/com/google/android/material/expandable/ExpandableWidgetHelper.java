package com.google.android.material.expandable;

import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
/* loaded from: classes.dex */
public final class ExpandableWidgetHelper implements ViewPropertyAnimatorListener {
    public boolean expanded;
    public int expandedComponentIdHint;
    public final View widget;

    public ExpandableWidgetHelper(FloatingActionButton floatingActionButton) {
        this.expanded = false;
        this.expandedComponentIdHint = 0;
        this.widget = floatingActionButton;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel() {
        this.expanded = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd() {
        if (!this.expanded) {
            ActionBarContextView actionBarContextView = (ActionBarContextView) this.widget;
            actionBarContextView.mVisibilityAnim = null;
            ExpandableWidgetHelper.super.setVisibility(this.expandedComponentIdHint);
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart() {
        ExpandableWidgetHelper.super.setVisibility(0);
        this.expanded = false;
    }

    public ExpandableWidgetHelper(ActionBarContextView actionBarContextView) {
        this.widget = actionBarContextView;
        this.expanded = false;
    }
}
