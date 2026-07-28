package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.transition.Transition;
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    public AnimatorSet currentAnimation;

    public ExpandableTransformationBehavior() {
    }

    public abstract AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z, boolean z2);

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public void onExpandedStateChange(View view, View view2, boolean z, boolean z2) {
        boolean z3;
        AnimatorSet animatorSet = this.currentAnimation;
        if (animatorSet != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            animatorSet.cancel();
        }
        AnimatorSet onCreateExpandedStateChangeAnimation = onCreateExpandedStateChangeAnimation(view, view2, z, z3);
        this.currentAnimation = onCreateExpandedStateChangeAnimation;
        onCreateExpandedStateChangeAnimation.addListener(new Transition.C01123(11, this));
        this.currentAnimation.start();
        if (!z2) {
            this.currentAnimation.end();
        }
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
