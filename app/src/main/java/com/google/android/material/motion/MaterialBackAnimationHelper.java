package com.google.android.material.motion;

import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.activity.BackEventCompat;
import com.emanuelef.remote_capture.C0130R;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public abstract class MaterialBackAnimationHelper {
    public BackEventCompat backEvent;
    public final int cancelDuration;
    public final int hideDurationMax;
    public final int hideDurationMin;
    public final PathInterpolator progressInterpolator = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
    public final View view;

    public MaterialBackAnimationHelper(View view) {
        this.view = view;
        Context context = view.getContext();
        this.hideDurationMax = LazyKt__LazyJVMKt.resolveThemeDuration(context, C0130R.attr.motionDurationMedium2, 300);
        this.hideDurationMin = LazyKt__LazyJVMKt.resolveThemeDuration(context, C0130R.attr.motionDurationShort3, 150);
        this.cancelDuration = LazyKt__LazyJVMKt.resolveThemeDuration(context, C0130R.attr.motionDurationShort2, 100);
    }
}
