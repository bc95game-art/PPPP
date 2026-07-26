package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.reflect.Method;
import java.util.Map;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class DifferentialMotionFlingController {
    public final Context mContext;
    public float mLastFlingVelocity;
    public final DifferentialMotionFlingTarget mTarget;
    public VelocityTracker mVelocityTracker;
    public int mLastProcessedAxis = -1;
    public int mLastProcessedSource = -1;
    public int mLastProcessedDeviceId = -1;
    public final int[] mFlingVelocityThresholds = {Integer.MAX_VALUE, 0};

    public DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this.mContext = context;
        this.mTarget = differentialMotionFlingTarget;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r14 >= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bc, code lost:
        if (r5 >= 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMotionEvent(MotionEvent motionEvent, int i) {
        char c;
        boolean z;
        float f;
        float f2;
        int i2;
        float f3;
        float f4;
        float f5;
        float f6;
        long j;
        float f7;
        int i3;
        int i4;
        int i5;
        int i6;
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        int i7 = this.mLastProcessedSource;
        int[] iArr = this.mFlingVelocityThresholds;
        if (i7 == source && this.mLastProcessedDeviceId == deviceId && this.mLastProcessedAxis == i) {
            z = false;
            c = 0;
        } else {
            Context context = this.mContext;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int deviceId2 = motionEvent.getDeviceId();
            int source2 = motionEvent.getSource();
            int i8 = Build.VERSION.SDK_INT;
            c = 0;
            if (i8 >= 34) {
                Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
                i3 = ViewConfigurationCompat.Api34Impl.getScaledMinimumFlingVelocity(viewConfiguration, deviceId2, i, source2);
            } else {
                Method method2 = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
                InputDevice device = InputDevice.getDevice(deviceId2);
                if (!(device == null || device.getMotionRange(i, source2) == null)) {
                    Resources resources = context.getResources();
                    if (source2 == 4194304 && i == 26) {
                        i6 = resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android");
                    } else {
                        i6 = -1;
                    }
                    Objects.requireNonNull(viewConfiguration);
                    if (i6 == -1) {
                        i3 = viewConfiguration.getScaledMinimumFlingVelocity();
                    } else if (i6 != 0) {
                        i3 = resources.getDimensionPixelSize(i6);
                    }
                }
                i3 = Integer.MAX_VALUE;
            }
            iArr[0] = i3;
            int deviceId3 = motionEvent.getDeviceId();
            int source3 = motionEvent.getSource();
            if (i8 >= 34) {
                i4 = ViewConfigurationCompat.Api34Impl.getScaledMaximumFlingVelocity(viewConfiguration, deviceId3, i, source3);
            } else {
                InputDevice device2 = InputDevice.getDevice(deviceId3);
                if (!(device2 == null || device2.getMotionRange(i, source3) == null)) {
                    Resources resources2 = context.getResources();
                    if (source3 == 4194304 && i == 26) {
                        i5 = resources2.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android");
                    } else {
                        i5 = -1;
                    }
                    Objects.requireNonNull(viewConfiguration);
                    if (i5 == -1) {
                        i4 = viewConfiguration.getScaledMaximumFlingVelocity();
                    } else if (i5 != 0) {
                        i4 = resources2.getDimensionPixelSize(i5);
                    }
                }
                i4 = Integer.MIN_VALUE;
            }
            iArr[1] = i4;
            this.mLastProcessedSource = source;
            this.mLastProcessedDeviceId = deviceId;
            this.mLastProcessedAxis = i;
            z = true;
        }
        if (iArr[c] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
                return;
            }
            return;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        Map map = VelocityTrackerCompat.sFallbackTrackers;
        velocityTracker2.addMovement(motionEvent);
        float f8 = 0.0f;
        int i9 = 20;
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            Map map2 = VelocityTrackerCompat.sFallbackTrackers;
            if (!map2.containsKey(velocityTracker2)) {
                map2.put(velocityTracker2, new VelocityTrackerFallback());
            }
            VelocityTrackerFallback velocityTrackerFallback = (VelocityTrackerFallback) map2.get(velocityTracker2);
            long[] jArr = velocityTrackerFallback.mEventTimes;
            long eventTime = motionEvent.getEventTime();
            if (velocityTrackerFallback.mDataPointsBufferSize != 0 && eventTime - jArr[velocityTrackerFallback.mDataPointsBufferLastUsedIndex] > 40) {
                velocityTrackerFallback.mDataPointsBufferSize = 0;
                velocityTrackerFallback.mLastComputedVelocity = 0.0f;
            }
            int i10 = (velocityTrackerFallback.mDataPointsBufferLastUsedIndex + 1) % 20;
            velocityTrackerFallback.mDataPointsBufferLastUsedIndex = i10;
            int i11 = velocityTrackerFallback.mDataPointsBufferSize;
            if (i11 != 20) {
                velocityTrackerFallback.mDataPointsBufferSize = i11 + 1;
            }
            velocityTrackerFallback.mMovements[i10] = motionEvent.getAxisValue(26);
            jArr[velocityTrackerFallback.mDataPointsBufferLastUsedIndex] = eventTime;
        }
        velocityTracker2.computeCurrentVelocity(1000, Float.MAX_VALUE);
        VelocityTrackerFallback velocityTrackerFallback2 = (VelocityTrackerFallback) VelocityTrackerCompat.sFallbackTrackers.get(velocityTracker2);
        if (velocityTrackerFallback2 != null) {
            float[] fArr = velocityTrackerFallback2.mMovements;
            long[] jArr2 = velocityTrackerFallback2.mEventTimes;
            int i12 = velocityTrackerFallback2.mDataPointsBufferSize;
            if (i12 >= 2) {
                int i13 = velocityTrackerFallback2.mDataPointsBufferLastUsedIndex;
                int i14 = ((i13 + 20) - (i12 - 1)) % 20;
                long j2 = jArr2[i13];
                while (true) {
                    j = jArr2[i14];
                    if (j2 - j <= 100) {
                        break;
                    }
                    velocityTrackerFallback2.mDataPointsBufferSize--;
                    i14 = (i14 + 1) % 20;
                }
                int i15 = velocityTrackerFallback2.mDataPointsBufferSize;
                if (i15 >= 2) {
                    if (i15 == 2) {
                        int i16 = (i14 + 1) % 20;
                        long j3 = jArr2[i16];
                        if (j != j3) {
                            f5 = fArr[i16] / ((float) (j3 - j));
                            f4 = Float.MAX_VALUE;
                            f = 0.0f;
                            f6 = f5 * 1000;
                            velocityTrackerFallback2.mLastComputedVelocity = f6;
                            if (f6 < (-Math.abs(f4))) {
                                velocityTrackerFallback2.mLastComputedVelocity = -Math.abs(f4);
                            } else if (velocityTrackerFallback2.mLastComputedVelocity > Math.abs(f4)) {
                                velocityTrackerFallback2.mLastComputedVelocity = Math.abs(f4);
                            }
                        }
                    } else {
                        f4 = Float.MAX_VALUE;
                        int i17 = 0;
                        int i18 = 0;
                        float f9 = 0.0f;
                        while (true) {
                            f7 = 1.0f;
                            if (i17 >= velocityTrackerFallback2.mDataPointsBufferSize - 1) {
                                break;
                            }
                            int i19 = i17 + i14;
                            long j4 = jArr2[i19 % 20];
                            int i20 = (i19 + 1) % i9;
                            if (jArr2[i20] != j4) {
                                i18++;
                                if (f9 < f8) {
                                    f7 = -1.0f;
                                }
                                float sqrt = f7 * ((float) Math.sqrt(Math.abs(f9) * 2.0f));
                                float f10 = fArr[i20] / ((float) (jArr2[i20] - j4));
                                f9 += Math.abs(f10) * (f10 - sqrt);
                                if (i18 == 1) {
                                    f9 *= 0.5f;
                                }
                            }
                            i17++;
                            f8 = 0.0f;
                            i9 = 20;
                        }
                        f = 0.0f;
                        if (f9 < 0.0f) {
                            f7 = -1.0f;
                        }
                        f5 = f7 * ((float) Math.sqrt(Math.abs(f9) * 2.0f));
                        f6 = f5 * 1000;
                        velocityTrackerFallback2.mLastComputedVelocity = f6;
                        if (f6 < (-Math.abs(f4))) {
                        }
                    }
                }
            }
            f4 = Float.MAX_VALUE;
            f5 = 0.0f;
            f = 0.0f;
            f6 = f5 * 1000;
            velocityTrackerFallback2.mLastComputedVelocity = f6;
            if (f6 < (-Math.abs(f4))) {
            }
        } else {
            f = 0.0f;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            f2 = VelocityTrackerCompat.Api34Impl.getAxisVelocity(velocityTracker2, i);
        } else if (i == 0) {
            f2 = velocityTracker2.getXVelocity();
        } else if (i == 1) {
            f2 = velocityTracker2.getYVelocity();
        } else {
            VelocityTrackerFallback velocityTrackerFallback3 = (VelocityTrackerFallback) VelocityTrackerCompat.sFallbackTrackers.get(velocityTracker2);
            if (velocityTrackerFallback3 == null || i != 26) {
                f2 = 0.0f;
            } else {
                f2 = velocityTrackerFallback3.mLastComputedVelocity;
            }
        }
        DifferentialMotionFlingTarget differentialMotionFlingTarget = this.mTarget;
        float scaledScrollFactor = differentialMotionFlingTarget.getScaledScrollFactor() * f2;
        float signum = Math.signum(scaledScrollFactor);
        if (z || !(signum == Math.signum(this.mLastFlingVelocity) || signum == f)) {
            differentialMotionFlingTarget.stopDifferentialMotionFling();
        }
        if (Math.abs(scaledScrollFactor) >= iArr[0]) {
            float max = Math.max(-i2, Math.min(scaledScrollFactor, iArr[1]));
            if (differentialMotionFlingTarget.startDifferentialMotionFling(max)) {
                f3 = max;
            } else {
                f3 = 0.0f;
            }
            this.mLastFlingVelocity = f3;
        }
    }
}
