package com.haipq.android.flagkit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.util.Locale;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class FlagImageView extends ImageView {
    public String countryCode;

    public FlagImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setScaleType(ImageView.ScaleType.CENTER_CROP);
        super.setAdjustViewBounds(true);
        if (!isInEditMode() && attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.FlagImageView, 0, 0);
            try {
                String string = obtainStyledAttributes.getString(0);
                if (string == null || string.isEmpty()) {
                    setCountryCode(Locale.getDefault().getCountry());
                    Log.d("com.haipq.android.flagkit.FlagImageView", " defaultLocal " + Locale.getDefault().getCountry());
                } else {
                    setCountryCode(string);
                }
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setAdjustViewBounds(boolean z) {
    }

    public void setCountryCode(String str) {
        String lowerCase = (str == null || str.isEmpty()) ? "" : str.toLowerCase();
        if (!lowerCase.equals(this.countryCode)) {
            this.countryCode = lowerCase;
            if (lowerCase.isEmpty()) {
                setImageResource(0);
                return;
            }
            Resources resources = getResources();
            int identifier = resources.getIdentifier("flag_" + this.countryCode, AppIntroBaseFragmentKt.ARG_DRAWABLE, getContext().getPackageName());
            if (identifier == 0) {
                Log.w("com.haipq.android.flagkit.FlagImageView", " CountryCode is Wrong ");
            }
            setImageResource(identifier);
        }
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    public void setCountryCode(Locale locale) {
        setCountryCode(locale.getCountry());
    }
}
