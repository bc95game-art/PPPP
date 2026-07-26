package androidx.dynamicanimation.animation;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda0;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzcl;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AnimationHandler {
    public static final ThreadLocal sAnimatorHandler = new ThreadLocal();
    public DurationScaleChangeListener33 mDurationScaleChangeListener;
    public final zzcl mScheduler;
    public final SimpleArrayMap mDelayedCallbackStartTime = new SimpleArrayMap(0);
    public final ArrayList mAnimationCallbacks = new ArrayList();
    public final FakeDrag mCallbackDispatcher = new FakeDrag(15, this);
    public final ActivityCompat$$ExternalSyntheticLambda0 mRunnable = new ActivityCompat$$ExternalSyntheticLambda0(4, this);
    public boolean mListDirty = false;
    public float mDurationScale = 1.0f;

    /* loaded from: classes.dex */
    public final class DurationScaleChangeListener33 {
        public AnimationHandler$DurationScaleChangeListener33$$ExternalSyntheticLambda0 mListener;

        public DurationScaleChangeListener33() {
        }

        public final boolean unregister() {
            boolean unregisterDurationScaleChangeListener = ValueAnimator.unregisterDurationScaleChangeListener(this.mListener);
            this.mListener = null;
            return unregisterDurationScaleChangeListener;
        }
    }

    public AnimationHandler(zzcl zzclVar) {
        this.mScheduler = zzclVar;
    }

    public final void addAnimationFrameCallback(SpringAnimation springAnimation) {
        ArrayList arrayList = this.mAnimationCallbacks;
        if (arrayList.size() == 0) {
            ((Choreographer) this.mScheduler.zzb).postFrameCallback(new ProfileInstallerInitializer$$ExternalSyntheticLambda0(this.mRunnable));
            if (Build.VERSION.SDK_INT >= 33) {
                this.mDurationScale = ValueAnimator.getDurationScale();
                if (this.mDurationScaleChangeListener == null) {
                    this.mDurationScaleChangeListener = new DurationScaleChangeListener33();
                }
                final DurationScaleChangeListener33 durationScaleChangeListener33 = this.mDurationScaleChangeListener;
                if (durationScaleChangeListener33.mListener == null) {
                    ValueAnimator.DurationScaleChangeListener animationHandler$DurationScaleChangeListener33$$ExternalSyntheticLambda0 = new ValueAnimator.DurationScaleChangeListener() { // from class: androidx.dynamicanimation.animation.AnimationHandler$DurationScaleChangeListener33$$ExternalSyntheticLambda0
                        public final void onChanged(float f) {
                            AnimationHandler.this.mDurationScale = f;
                        }
                    };
                    durationScaleChangeListener33.mListener = animationHandler$DurationScaleChangeListener33$$ExternalSyntheticLambda0;
                    ValueAnimator.registerDurationScaleChangeListener(animationHandler$DurationScaleChangeListener33$$ExternalSyntheticLambda0);
                }
            }
        }
        if (!arrayList.contains(springAnimation)) {
            arrayList.add(springAnimation);
        }
    }
}
