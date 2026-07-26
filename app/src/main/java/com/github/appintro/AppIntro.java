package com.github.appintro;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.github.appintro.internal.TypefaceContainer;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class AppIntro extends AppIntroBase {
    private final int layoutId = R.layout.appintro_intro_layout;

    @Override // com.github.appintro.AppIntroBase
    public int getLayoutId() {
        return this.layoutId;
    }

    public final void setBackArrowColor(int i) {
        ((ImageButton) findViewById(R.id.back)).setColorFilter(i);
    }

    public final void setBarColor(int i) {
        findViewById(R.id.bottom).setBackgroundColor(i);
    }

    public final void setColorDoneText(int i) {
        ((TextView) findViewById(R.id.done)).setTextColor(i);
    }

    public final void setColorSkipButton(int i) {
        ((TextView) findViewById(R.id.skip)).setTextColor(i);
    }

    public final void setDoneText(CharSequence charSequence) {
        ((TextView) findViewById(R.id.done)).setText(charSequence);
    }

    public final void setDoneTextAppearance(int i) {
        TextViewCompat.setTextAppearance((TextView) findViewById(R.id.done), i);
    }

    public final void setDoneTextTypeface(String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(R.id.done));
    }

    public final void setImageNextButton(Drawable imageNextButton) {
        Intrinsics.checkNotNullParameter(imageNextButton, "imageNextButton");
        ((ImageView) findViewById(R.id.next)).setImageDrawable(imageNextButton);
    }

    public final void setNextArrowColor(int i) {
        ((ImageButton) findViewById(R.id.next)).setColorFilter(i);
    }

    public final void setSeparatorColor(int i) {
        findViewById(R.id.bottom_separator).setBackgroundColor(i);
    }

    public final void setSkipText(CharSequence charSequence) {
        ((TextView) findViewById(R.id.skip)).setText(charSequence);
    }

    public final void setSkipTextAppearance(int i) {
        TextViewCompat.setTextAppearance((TextView) findViewById(R.id.skip), i);
    }

    public final void setSkipTextTypeface(int i) {
        new TypefaceContainer(null, i).applyTo((TextView) findViewById(R.id.skip));
    }

    public final void showSeparator(boolean z) {
        View findViewById = findViewById(R.id.bottom_separator);
        if (z) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
    }

    public final void setDoneText(int i) {
        ((TextView) findViewById(R.id.done)).setText(i);
    }

    public final void setDoneTextTypeface(int i) {
        new TypefaceContainer(null, i).applyTo((TextView) findViewById(R.id.done));
    }

    public final void setSkipText(int i) {
        ((TextView) findViewById(R.id.skip)).setText(i);
    }

    public final void setSkipTextTypeface(String str) {
        new TypefaceContainer(str, 0).applyTo((TextView) findViewById(R.id.skip));
    }
}
