package com.github.appintro.internal.viewpager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.github.appintro.AppIntroPageTransformerType;
import com.github.appintro.C0161R;
import com.github.appintro.internal.LogHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public final class ViewPagerTransformer implements ViewPager.PageTransformer {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = LogHelper.INSTANCE.makeLogTag(Reflection.getOrCreateKotlinClass(ViewPagerTransformer.class));
    private double descriptionPF;
    private double imagePF;
    private double titlePF;
    private final AppIntroPageTransformerType transformType;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ViewPagerTransformer(AppIntroPageTransformerType transformType) {
        Intrinsics.checkNotNullParameter(transformType, "transformType");
        this.transformType = transformType;
    }

    private final void applyParallax(View view, float f) {
        ((TextView) view.findViewById(C0161R.C0163id.title)).setTranslationX(computeParallax(view, f, this.titlePF));
        ((ImageView) view.findViewById(C0161R.C0163id.image)).setTranslationX(computeParallax(view, f, this.imagePF));
        ((TextView) view.findViewById(C0161R.C0163id.description)).setTranslationX(computeParallax(view, f, this.descriptionPF));
    }

    private final float computeParallax(View view, float f, double d) {
        return (float) ((view.getWidth() / d) * (-f));
    }

    private final void transformDepth(float f, View view) {
        if (f <= 0.0f || f >= 1.0f) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f2 = 1;
        view.setAlpha(f2 - f);
        ViewPagerTransformerKt.setScaleXY(view, ((f2 - Math.abs(f)) * 0.25f) + 0.75f);
        view.setTranslationX(view.getWidth() * (-f));
    }

    private final void transformFade(float f, View view) {
        if (f <= -1.0f || f >= 1.0f) {
            view.setTranslationX(view.getWidth());
            view.setAlpha(0.0f);
            view.setClickable(false);
        } else if (f == 0.0f) {
            view.setTranslationX(0.0f);
            view.setAlpha(1.0f);
            view.setClickable(true);
        } else {
            view.setTranslationX(view.getWidth() * (-f));
            view.setAlpha(1.0f - Math.abs(f));
        }
    }

    private final void transformParallax(float f, View view) {
        if (f > -1.0f && f < 1.0f) {
            try {
                applyParallax(view, f);
            } catch (IllegalStateException e) {
                LogHelper.m575e(TAG, "Failed to apply parallax effect", e);
            }
        }
    }

    private final void transformSlideOver(float f, View view) {
        if (f >= 0.0f || f <= -1.0f) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f2 = 1;
        ViewPagerTransformerKt.setScaleXY(view, (Math.abs(Math.abs(f) - f2) * 0.14999998f) + 0.85f);
        view.setAlpha(Math.max(0.35f, f2 - Math.abs(f)));
        float f3 = -view.getWidth();
        float f4 = f * f3;
        if (f4 > f3) {
            view.setTranslationX(f4);
        } else {
            view.setTranslationX(0.0f);
        }
    }

    private final void transformZoom(float f, View view) {
        float scaleXY;
        float scaleXY2;
        float scaleXY3;
        if (f < -1.0f || f > 1.0f) {
            ViewPagerTransformerKt.transformDefaults(view);
            return;
        }
        float f2 = 1;
        ViewPagerTransformerKt.setScaleXY(view, Math.max(0.85f, f2 - Math.abs(f)));
        scaleXY = ViewPagerTransformerKt.getScaleXY(view);
        view.setAlpha((((scaleXY - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
        scaleXY2 = ViewPagerTransformerKt.getScaleXY(view);
        float f3 = 2;
        float height = ((f2 - scaleXY2) * view.getHeight()) / f3;
        scaleXY3 = ViewPagerTransformerKt.getScaleXY(view);
        float width = ((f2 - scaleXY3) * view.getWidth()) / f3;
        if (f < 0.0f) {
            view.setTranslationX(width - (height / f3));
            return;
        }
        view.setTranslationX((height / f3) + (-width));
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View page, float f) {
        Intrinsics.checkNotNullParameter(page, "page");
        AppIntroPageTransformerType appIntroPageTransformerType = this.transformType;
        if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.Flow.INSTANCE)) {
            page.setRotationY(f * (-30.0f));
        } else if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.SlideOver.INSTANCE)) {
            transformSlideOver(f, page);
        } else if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.Depth.INSTANCE)) {
            transformDepth(f, page);
        } else if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.Zoom.INSTANCE)) {
            transformZoom(f, page);
        } else if (Intrinsics.areEqual(appIntroPageTransformerType, AppIntroPageTransformerType.Fade.INSTANCE)) {
            transformFade(f, page);
        } else if (appIntroPageTransformerType instanceof AppIntroPageTransformerType.Parallax) {
            this.titlePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getTitleParallaxFactor();
            this.imagePF = ((AppIntroPageTransformerType.Parallax) this.transformType).getImageParallaxFactor();
            this.descriptionPF = ((AppIntroPageTransformerType.Parallax) this.transformType).getDescriptionParallaxFactor();
            transformParallax(f, page);
        }
    }
}
