package com.github.appintro.indicator;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public interface IndicatorController {
    int getSelectedIndicatorColor();

    int getUnselectedIndicatorColor();

    void initialize(int i);

    View newInstance(Context context);

    void selectPosition(int i);

    void setSelectedIndicatorColor(int i);

    void setUnselectedIndicatorColor(int i);
}
