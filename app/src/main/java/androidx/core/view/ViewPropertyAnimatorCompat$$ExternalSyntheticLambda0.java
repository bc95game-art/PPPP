package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.FakeDrag;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.card.MaterialCardViewHelper;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import com.google.android.material.tooltip.TooltipDrawable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final /* synthetic */ class ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.$r8$classId) {
            case 0:
                ((View) ((WindowDecorActionBar) ((FakeDrag) this.f$0).mScrollEventAdapter).mContainerView.getParent()).invalidate();
                return;
            case 1:
                MaterialCardViewHelper materialCardViewHelper = (MaterialCardViewHelper) this.f$0;
                materialCardViewHelper.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                materialCardViewHelper.checkedIcon.setAlpha((int) (255.0f * floatValue));
                materialCardViewHelper.checkedAnimationProgress = floatValue;
                return;
            case 2:
                ((DrawerLayout) this.f$0).setScrimColor(ColorUtils.setAlphaComponent(-1728053248, AnimationUtils.lerp(DrawerLayoutUtils.DEFAULT_SCRIM_ALPHA, valueAnimator.getAnimatedFraction(), 0)));
                return;
            case 3:
                BaseSlider baseSlider = (BaseSlider) this.f$0;
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ArrayList arrayList = baseSlider.labels;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    TooltipDrawable tooltipDrawable = (TooltipDrawable) obj;
                    tooltipDrawable.tooltipScaleX = floatValue2;
                    tooltipDrawable.tooltipScaleY = floatValue2;
                    tooltipDrawable.labelOpacity = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, floatValue2);
                    tooltipDrawable.invalidateSelf();
                }
                baseSlider.postInvalidateOnAnimation();
                return;
            default:
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.f$0;
                dropdownMenuEndIconDelegate.getClass();
                dropdownMenuEndIconDelegate.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                return;
        }
    }

    public /* synthetic */ ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(FakeDrag fakeDrag, View view) {
        this.$r8$classId = 0;
        this.f$0 = fakeDrag;
    }
}
