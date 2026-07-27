package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.emanuelef.remote_capture.C0130R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static TooltipCompatHandler sActiveHandler;
    public static TooltipCompatHandler sPendingHandler;
    public final View mAnchor;
    public int mAnchorX;
    public int mAnchorY;
    public boolean mForceNextChangeSignificant;
    public boolean mFromTouch;
    public final int mHoverSlop;
    public TooltipPopup mPopup;
    public final CharSequence mTooltipText;
    public final TooltipCompatHandler$$ExternalSyntheticLambda0 mShowRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0
        public final /* synthetic */ TooltipCompatHandler f$0;

        {
            this.f$0 = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (r2) {
                case 0:
                    this.f$0.show(false);
                    return;
                default:
                    this.f$0.hide();
                    return;
            }
        }
    };
    public final TooltipCompatHandler$$ExternalSyntheticLambda0 mHideRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0
        public final /* synthetic */ TooltipCompatHandler f$0;

        {
            this.f$0 = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (r2) {
                case 0:
                    this.f$0.show(false);
                    return;
                default:
                    this.f$0.hide();
                    return;
            }
        }
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.TooltipCompatHandler$$ExternalSyntheticLambda0] */
    public TooltipCompatHandler(View view, CharSequence charSequence) {
        int i;
        this.mAnchor = view;
        this.mTooltipText = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
        if (Build.VERSION.SDK_INT >= 28) {
            i = ViewConfigurationCompat.Api28Impl.getScaledHoverSlop(viewConfiguration);
        } else {
            i = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.mHoverSlop = i;
        this.mForceNextChangeSignificant = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void setPendingHandler(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = sPendingHandler;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.mAnchor.removeCallbacks(tooltipCompatHandler2.mShowRunnable);
        }
        sPendingHandler = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.mAnchor.postDelayed(tooltipCompatHandler.mShowRunnable, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void hide() {
        TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
        View view = this.mAnchor;
        if (tooltipCompatHandler == this) {
            sActiveHandler = null;
            TooltipPopup tooltipPopup = this.mPopup;
            if (tooltipPopup != null) {
                View view2 = (View) tooltipPopup.mContentView;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) tooltipPopup.mContext).getSystemService("window")).removeView(view2);
                }
                this.mPopup = null;
                this.mForceNextChangeSignificant = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (sPendingHandler == this) {
            setPendingHandler(null);
        }
        view.removeCallbacks(this.mHideRunnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (java.lang.Math.abs(r5 - r3.mAnchorY) <= r2) goto L27;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.mPopup == null || !this.mFromTouch) {
            View view2 = this.mAnchor;
            AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action != 7) {
                    if (action == 10) {
                        this.mForceNextChangeSignificant = true;
                        hide();
                        return false;
                    }
                } else if (view2.isEnabled() && this.mPopup == null) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (!this.mForceNextChangeSignificant) {
                        int abs = Math.abs(x - this.mAnchorX);
                        int i = this.mHoverSlop;
                        if (abs <= i) {
                        }
                    }
                    this.mAnchorX = x;
                    this.mAnchorY = y;
                    this.mForceNextChangeSignificant = false;
                    setPendingHandler(this);
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.mAnchorX = view.getWidth() / 2;
        this.mAnchorY = view.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        hide();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.appcompat.widget.TooltipPopup, java.lang.Object] */
    public final void show(boolean z) {
        int i;
        int i2;
        int i3;
        long j;
        long longPressTimeout;
        long j2;
        int i4;
        char c;
        int i5;
        int i6;
        View view = this.mAnchor;
        if (view.isAttachedToWindow()) {
            setPendingHandler(null);
            TooltipCompatHandler tooltipCompatHandler = sActiveHandler;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.hide();
            }
            sActiveHandler = this;
            this.mFromTouch = z;
            Context context = view.getContext();
            ?? obj = new Object();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            obj.mLayoutParams = layoutParams;
            obj.mTmpDisplayFrame = new Rect();
            obj.mTmpAnchorPos = new int[2];
            obj.mTmpAppPos = new int[2];
            obj.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(C0130R.layout.abc_tooltip, (ViewGroup) null);
            obj.mContentView = inflate;
            obj.mMessageView = (TextView) inflate.findViewById(C0130R.C0132id.message);
            layoutParams.setTitle("TooltipPopup");
            layoutParams.packageName = context.getPackageName();
            layoutParams.type = 1002;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 2132082692;
            layoutParams.flags = 24;
            View view2 = (View) obj.mContentView;
            Context context2 = (Context) obj.mContext;
            this.mPopup = obj;
            int i7 = this.mAnchorX;
            int i8 = this.mAnchorY;
            boolean z2 = this.mFromTouch;
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) obj.mLayoutParams;
            if (!(view2.getParent() == null || view2.getParent() == null)) {
                ((WindowManager) context2.getSystemService("window")).removeView(view2);
            }
            ((TextView) obj.mMessageView).setText(this.mTooltipText);
            int[] iArr = (int[]) obj.mTmpAppPos;
            int[] iArr2 = (int[]) obj.mTmpAnchorPos;
            Rect rect = (Rect) obj.mTmpDisplayFrame;
            layoutParams2.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(C0130R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                i7 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(C0130R.dimen.tooltip_precise_anchor_extra_offset);
                i = i8 + dimensionPixelOffset2;
                i2 = i8 - dimensionPixelOffset2;
            } else {
                i = view.getHeight();
                i2 = 0;
            }
            layoutParams2.gravity = 49;
            Resources resources = context2.getResources();
            if (z2) {
                i3 = C0130R.dimen.tooltip_y_offset_touch;
            } else {
                i3 = C0130R.dimen.tooltip_y_offset_non_touch;
            }
            int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i3);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
            int i9 = i7;
            if (!(layoutParams3 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams3).type != 2) {
                Context context3 = view.getContext();
                while (true) {
                    if (!(context3 instanceof ContextWrapper)) {
                        break;
                    } else if (context3 instanceof Activity) {
                        rootView = ((Activity) context3).getWindow().getDecorView();
                        break;
                    } else {
                        context3 = ((ContextWrapper) context3).getBaseContext();
                    }
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i4 = i2;
                    i5 = 0;
                    c = 1;
                } else {
                    Resources resources2 = context2.getResources();
                    c = 1;
                    i4 = i2;
                    int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                    if (identifier != 0) {
                        i6 = resources2.getDimensionPixelSize(identifier);
                    } else {
                        i6 = 0;
                    }
                    DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                    i5 = 0;
                    rect.set(0, i6, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(iArr);
                view.getLocationOnScreen(iArr2);
                int i10 = iArr2[i5] - iArr[i5];
                iArr2[i5] = i10;
                iArr2[c] = iArr2[c] - iArr[c];
                layoutParams2.x = (i10 + i9) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, i5);
                view2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i11 = iArr2[c];
                int i12 = ((i11 + i4) - dimensionPixelOffset3) - measuredHeight;
                int i13 = i11 + i + dimensionPixelOffset3;
                if (z2) {
                    if (i12 >= 0) {
                        layoutParams2.y = i12;
                    } else {
                        layoutParams2.y = i13;
                    }
                } else if (measuredHeight + i13 <= rect.height()) {
                    layoutParams2.y = i13;
                } else {
                    layoutParams2.y = i12;
                }
            }
            ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
            view.addOnAttachStateChangeListener(this);
            if (this.mFromTouch) {
                j = 2500;
            } else {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if ((view.getWindowSystemUiVisibility() & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 15000;
                }
                j = j2 - longPressTimeout;
            }
            TooltipCompatHandler$$ExternalSyntheticLambda0 tooltipCompatHandler$$ExternalSyntheticLambda0 = this.mHideRunnable;
            view.removeCallbacks(tooltipCompatHandler$$ExternalSyntheticLambda0);
            view.postDelayed(tooltipCompatHandler$$ExternalSyntheticLambda0, j);
        }
    }
}
