package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;
/* loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public int mActivePointerId;
    public TriggerLongPress mDisallowIntercept;
    public boolean mForwarding;
    public final int mLongPressTimeout;
    public final float mScaledTouchSlop;
    public final View mSrc;
    public final int mTapTimeout;
    public final int[] mTmpLocation = new int[2];
    public TriggerLongPress mTriggerLongPress;

    /* loaded from: classes.dex */
    public final class TriggerLongPress implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ ForwardingListener this$0;

        public /* synthetic */ TriggerLongPress(ForwardingListener forwardingListener, int i) {
            this.$r8$classId = i;
            this.this$0 = forwardingListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    ForwardingListener forwardingListener = this.this$0;
                    forwardingListener.clearCallbacks();
                    View view = forwardingListener.mSrc;
                    if (view.isEnabled() && !view.isLongClickable() && forwardingListener.onForwardingStarted()) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        view.onTouchEvent(obtain);
                        obtain.recycle();
                        forwardingListener.mForwarding = true;
                        return;
                    }
                    return;
                default:
                    ViewParent parent = this.this$0.mSrc.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                        return;
                    }
                    return;
            }
        }
    }

    public ForwardingListener(View view) {
        this.mSrc = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.mTapTimeout = tapTimeout;
        this.mLongPressTimeout = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void clearCallbacks() {
        TriggerLongPress triggerLongPress = this.mTriggerLongPress;
        View view = this.mSrc;
        if (triggerLongPress != null) {
            view.removeCallbacks(triggerLongPress);
        }
        TriggerLongPress triggerLongPress2 = this.mDisallowIntercept;
        if (triggerLongPress2 != null) {
            view.removeCallbacks(triggerLongPress2);
        }
    }

    public abstract ShowableListMenu getPopup();

    public abstract boolean onForwardingStarted();

    public boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r14 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
        if (r4 != 3) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        DropDownListView listView;
        boolean z2;
        boolean z3 = this.mForwarding;
        View view2 = this.mSrc;
        if (z3) {
            ShowableListMenu popup = getPopup();
            if (popup != null && popup.isShowing() && (listView = popup.getListView()) != null && listView.isShown()) {
                MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.mTmpLocation;
                view2.getLocationOnScreen(iArr);
                obtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                listView.getLocationOnScreen(iArr);
                obtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean onForwardedEvent = listView.onForwardedEvent(obtainNoHistory, this.mActivePointerId);
                obtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 1 || actionMasked == 3) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (onForwardedEvent) {
                }
            }
            if (onForwardingStopped()) {
                z = false;
            }
            z = true;
        } else {
            if (view2.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 != 0) {
                    if (actionMasked2 != 1) {
                        if (actionMasked2 == 2) {
                            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (findPointerIndex >= 0) {
                                float x = motionEvent.getX(findPointerIndex);
                                float y = motionEvent.getY(findPointerIndex);
                                float f = this.mScaledTouchSlop;
                                float f2 = -f;
                                if (x < f2 || y < f2 || x >= (view2.getRight() - view2.getLeft()) + f || y >= (view2.getBottom() - view2.getTop()) + f) {
                                    clearCallbacks();
                                    view2.getParent().requestDisallowInterceptTouchEvent(true);
                                    if (onForwardingStarted()) {
                                        z = true;
                                        if (z) {
                                            long uptimeMillis = SystemClock.uptimeMillis();
                                            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                                            view2.onTouchEvent(obtain);
                                            obtain.recycle();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    clearCallbacks();
                } else {
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    if (this.mDisallowIntercept == null) {
                        this.mDisallowIntercept = new TriggerLongPress(this, 1);
                    }
                    view2.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
                    if (this.mTriggerLongPress == null) {
                        this.mTriggerLongPress = new TriggerLongPress(this, 0);
                    }
                    view2.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
                }
            }
            z = false;
            if (z) {
            }
        }
        this.mForwarding = z;
        if (z || z3) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.mForwarding = false;
        this.mActivePointerId = -1;
        TriggerLongPress triggerLongPress = this.mDisallowIntercept;
        if (triggerLongPress != null) {
            this.mSrc.removeCallbacks(triggerLongPress);
        }
    }
}
