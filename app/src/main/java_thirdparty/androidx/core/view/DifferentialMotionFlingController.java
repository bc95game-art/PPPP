package androidx.core.view;

import android.content.Context;
import android.view.VelocityTracker;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMotionEvent(android.view.MotionEvent r28, int r29) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.DifferentialMotionFlingController.onMotionEvent(android.view.MotionEvent, int):void");
    }
}
