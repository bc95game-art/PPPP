package com.github.appintro;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class AppIntro2 extends AppIntroBase {
    private Drawable backgroundDrawable;
    private ConstraintLayout backgroundFrame;
    private Integer backgroundResource;
    private View bottomBar;
    private final int layoutId = C0161R.layout.appintro_intro_layout2;
    private ImageButton skipImageButton;

    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final Integer getBackgroundResource() {
        return this.backgroundResource;
    }

    @Override // com.github.appintro.AppIntroBase
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View findViewById = findViewById(C0161R.C0163id.background);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.background)");
        this.backgroundFrame = (ConstraintLayout) findViewById;
        View findViewById2 = findViewById(C0161R.C0163id.bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.bottom)");
        this.bottomBar = findViewById2;
        View findViewById3 = findViewById(C0161R.C0163id.skip);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.skip)");
        this.skipImageButton = (ImageButton) findViewById3;
        if (isRtl$appintro_release()) {
            ImageButton imageButton = this.skipImageButton;
            if (imageButton != null) {
                imageButton.setScaleX(-1.0f);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("skipImageButton");
                throw null;
            }
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.backgroundDrawable = drawable;
        if (drawable != null) {
            ConstraintLayout constraintLayout = this.backgroundFrame;
            if (constraintLayout != null) {
                constraintLayout.setBackground(drawable);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundFrame");
                throw null;
            }
        }
    }

    public final void setBackgroundResource(Integer num) {
        this.backgroundResource = num;
        if (num != null && num != null) {
            int intValue = num.intValue();
            ConstraintLayout constraintLayout = this.backgroundFrame;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(intValue);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundFrame");
                throw null;
            }
        }
    }

    public final void setBarColor(int i) {
        View view = this.bottomBar;
        if (view != null) {
            view.setBackgroundColor(i);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBar");
            throw null;
        }
    }

    public final void setImageSkipButton(Drawable imageSkipButton) {
        Intrinsics.checkNotNullParameter(imageSkipButton, "imageSkipButton");
        ImageButton imageButton = this.skipImageButton;
        if (imageButton != null) {
            imageButton.setImageDrawable(imageSkipButton);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("skipImageButton");
            throw null;
        }
    }

    public final void setNextArrowColor(int i) {
        ((ImageButton) findViewById(C0161R.C0163id.next)).setColorFilter(i);
    }

    public final void setSkipArrowColor(int i) {
        ((ImageButton) findViewById(C0161R.C0163id.skip)).setColorFilter(i);
    }
}
