package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import com.google.android.material.checkbox.MaterialCheckBox;
/* loaded from: classes.dex */
public final class Animatable2Compat$AnimationCallback$1 extends Animatable2.AnimationCallback {
    public final /* synthetic */ MaterialCheckBox.C01731 this$0;

    public Animatable2Compat$AnimationCallback$1(MaterialCheckBox.C01731 r1) {
        this.this$0 = r1;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = MaterialCheckBox.this.buttonTintList;
        if (colorStateList != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
        ColorStateList colorStateList = materialCheckBox.buttonTintList;
        if (colorStateList != null) {
            drawable.setTint(colorStateList.getColorForState(materialCheckBox.currentStateChecked, colorStateList.getDefaultColor()));
        }
    }
}
