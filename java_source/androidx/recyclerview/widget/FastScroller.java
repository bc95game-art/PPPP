package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.adapters.PayloadAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
/* loaded from: classes.dex */
public final class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public final RunnableC00991 mHideRunnable;
    public float mHorizontalDragX;
    public int mHorizontalThumbCenterX;
    public final StateListDrawable mHorizontalThumbDrawable;
    public final int mHorizontalThumbHeight;
    public int mHorizontalThumbWidth;
    public final Drawable mHorizontalTrackDrawable;
    public final int mHorizontalTrackHeight;
    public final int mMargin;
    public final RecyclerView mRecyclerView;
    public final int mScrollbarMinimumRange;
    public final ValueAnimator mShowHideAnimator;
    public float mVerticalDragY;
    public int mVerticalThumbCenterY;
    public final StateListDrawable mVerticalThumbDrawable;
    public int mVerticalThumbHeight;
    public final int mVerticalThumbWidth;
    public final Drawable mVerticalTrackDrawable;
    public final int mVerticalTrackWidth;
    public static final int[] PRESSED_STATE_SET = {16842919};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public int mRecyclerViewWidth = 0;
    public int mRecyclerViewHeight = 0;
    public boolean mNeedVerticalScrollbar = false;
    public boolean mNeedHorizontalScrollbar = false;
    public int mState = 0;
    public int mDragState = 0;
    public final int[] mVerticalRange = new int[2];
    public final int[] mHorizontalRange = new int[2];
    public int mAnimationState = 0;

    /* renamed from: androidx.recyclerview.widget.FastScroller$1 */
    /* loaded from: classes.dex */
    public final class RunnableC00991 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ RunnableC00991(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.$r8$classId;
            Object obj = this.this$0;
            switch (i) {
                case 0:
                    FastScroller fastScroller = (FastScroller) obj;
                    ValueAnimator valueAnimator = fastScroller.mShowHideAnimator;
                    int i2 = fastScroller.mAnimationState;
                    if (i2 == 1) {
                        valueAnimator.cancel();
                    } else if (i2 != 2) {
                        return;
                    }
                    fastScroller.mAnimationState = 3;
                    valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                    valueAnimator.setDuration(500);
                    valueAnimator.start();
                    return;
                default:
                    ((StaggeredGridLayoutManager) obj).checkForGaps();
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class AnimatorListener extends AnimatorListenerAdapter {
        public final /* synthetic */ int $r8$classId;
        public boolean mCanceled;
        public final /* synthetic */ Object this$0;

        public AnimatorListener(View view, boolean z) {
            this.$r8$classId = 2;
            this.mCanceled = z;
            this.this$0 = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            switch (this.$r8$classId) {
                case 0:
                    this.mCanceled = true;
                    return;
                default:
                    super.onAnimationCancel(animator);
                    return;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            switch (this.$r8$classId) {
                case 0:
                    FastScroller fastScroller = (FastScroller) this.this$0;
                    if (this.mCanceled) {
                        this.mCanceled = false;
                        return;
                    } else if (((Float) fastScroller.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                        fastScroller.mAnimationState = 0;
                        fastScroller.setState(0);
                        return;
                    } else {
                        fastScroller.mAnimationState = 2;
                        fastScroller.mRecyclerView.invalidate();
                        return;
                    }
                case 1:
                    FloatingActionButtonImpl floatingActionButtonImpl = (FloatingActionButtonImpl) this.this$0;
                    floatingActionButtonImpl.animState = 0;
                    floatingActionButtonImpl.currentAnimator = null;
                    return;
                default:
                    if (!this.mCanceled) {
                        ((View) this.this$0).setVisibility(4);
                        return;
                    }
                    return;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            switch (this.$r8$classId) {
                case 1:
                    FloatingActionButtonImpl floatingActionButtonImpl = (FloatingActionButtonImpl) this.this$0;
                    floatingActionButtonImpl.view.internalSetVisibility(0, this.mCanceled);
                    floatingActionButtonImpl.animState = 2;
                    floatingActionButtonImpl.currentAnimator = animator;
                    return;
                case 2:
                    if (this.mCanceled) {
                        ((View) this.this$0).setVisibility(0);
                        return;
                    }
                    return;
                default:
                    super.onAnimationStart(animator);
                    return;
            }
        }

        public AnimatorListener(FastScroller fastScroller) {
            this.$r8$classId = 0;
            this.this$0 = fastScroller;
            this.mCanceled = false;
        }

        public AnimatorListener(FloatingActionButtonImpl floatingActionButtonImpl, boolean z) {
            this.$r8$classId = 1;
            this.this$0 = floatingActionButtonImpl;
            this.mCanceled = z;
        }
    }

    /* loaded from: classes.dex */
    public final class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        public AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller fastScroller = FastScroller.this;
            fastScroller.mVerticalThumbDrawable.setAlpha(floatValue);
            fastScroller.mVerticalTrackDrawable.setAlpha(floatValue);
            fastScroller.mRecyclerView.invalidate();
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mShowHideAnimator = ofFloat;
        RunnableC00991 r2 = new RunnableC00991(0, this);
        this.mHideRunnable = r2;
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView2, int i4, int i5) {
                boolean z;
                boolean z2;
                int computeHorizontalScrollOffset = recyclerView2.computeHorizontalScrollOffset();
                int computeVerticalScrollOffset = recyclerView2.computeVerticalScrollOffset();
                FastScroller fastScroller = FastScroller.this;
                int i6 = fastScroller.mScrollbarMinimumRange;
                int computeVerticalScrollRange = fastScroller.mRecyclerView.computeVerticalScrollRange();
                int i7 = fastScroller.mRecyclerViewHeight;
                if (computeVerticalScrollRange - i7 <= 0 || i7 < i6) {
                    z = false;
                } else {
                    z = true;
                }
                fastScroller.mNeedVerticalScrollbar = z;
                int computeHorizontalScrollRange = fastScroller.mRecyclerView.computeHorizontalScrollRange();
                int i8 = fastScroller.mRecyclerViewWidth;
                if (computeHorizontalScrollRange - i8 <= 0 || i8 < i6) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                fastScroller.mNeedHorizontalScrollbar = z2;
                boolean z3 = fastScroller.mNeedVerticalScrollbar;
                if (z3 || z2) {
                    if (z3) {
                        float f = i7;
                        fastScroller.mVerticalThumbCenterY = (int) ((((f / 2.0f) + computeVerticalScrollOffset) * f) / computeVerticalScrollRange);
                        fastScroller.mVerticalThumbHeight = Math.min(i7, (i7 * i7) / computeVerticalScrollRange);
                    }
                    if (fastScroller.mNeedHorizontalScrollbar) {
                        float f2 = computeHorizontalScrollOffset;
                        float f3 = i8;
                        fastScroller.mHorizontalThumbCenterX = (int) ((((f3 / 2.0f) + f2) * f3) / computeHorizontalScrollRange);
                        fastScroller.mHorizontalThumbWidth = Math.min(i8, (i8 * i8) / computeHorizontalScrollRange);
                    }
                    int i9 = fastScroller.mState;
                    if (i9 == 0 || i9 == 1) {
                        fastScroller.setState(1);
                    }
                } else if (fastScroller.mState != 0) {
                    fastScroller.setState(0);
                }
            }
        };
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i2;
        this.mMargin = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener(this));
        ofFloat.addUpdateListener(new AnimatorUpdater());
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.mRecyclerView.removeOnItemTouchListener(this);
                this.mRecyclerView.removeOnScrollListener(onScrollListener);
                this.mRecyclerView.removeCallbacks(r2);
            }
            this.mRecyclerView = recyclerView;
            recyclerView.addItemDecoration(this);
            this.mRecyclerView.addOnItemTouchListener(this);
            this.mRecyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public static int scrollTo(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 != 0) {
            int i5 = i - i3;
            int i6 = (int) (((f2 - f) / i4) * i5);
            int i7 = i2 + i6;
            if (i7 < i5 && i7 >= 0) {
                return i6;
            }
        }
        return 0;
    }

    public final boolean isPointInsideHorizontalThumb(float f, float f2) {
        if (f2 < this.mRecyclerViewHeight - this.mHorizontalThumbHeight) {
            return false;
        }
        int i = this.mHorizontalThumbCenterX;
        int i2 = this.mHorizontalThumbWidth;
        if (f < i - (i2 / 2) || f > (i2 / 2) + i) {
            return false;
        }
        return true;
    }

    public final boolean isPointInsideVerticalThumb(float f, float f2) {
        int layoutDirection = this.mRecyclerView.getLayoutDirection();
        int i = this.mVerticalThumbWidth;
        if (layoutDirection == 1) {
            if (f > i) {
                return false;
            }
        } else if (f < this.mRecyclerViewWidth - i) {
            return false;
        }
        int i2 = this.mVerticalThumbCenterY;
        int i3 = this.mVerticalThumbHeight / 2;
        if (f2 < i2 - i3 || f2 > i3 + i2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        if (this.mRecyclerViewWidth != this.mRecyclerView.getWidth() || this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) {
            this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
            this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
            setState(0);
        } else if (this.mAnimationState != 0) {
            if (this.mNeedVerticalScrollbar) {
                int i = this.mRecyclerViewWidth;
                int i2 = this.mVerticalThumbWidth;
                int i3 = i - i2;
                int i4 = this.mVerticalThumbCenterY;
                int i5 = this.mVerticalThumbHeight;
                int i6 = i4 - (i5 / 2);
                StateListDrawable stateListDrawable = this.mVerticalThumbDrawable;
                stateListDrawable.setBounds(0, 0, i2, i5);
                int i7 = this.mVerticalTrackWidth;
                int i8 = this.mRecyclerViewHeight;
                Drawable drawable = this.mVerticalTrackDrawable;
                drawable.setBounds(0, 0, i7, i8);
                if (this.mRecyclerView.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i2, i6);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i2, -i6);
                } else {
                    canvas.translate(i3, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i6);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i3, -i6);
                }
            }
            if (this.mNeedHorizontalScrollbar) {
                int i9 = this.mRecyclerViewHeight;
                int i10 = this.mHorizontalThumbHeight;
                int i11 = i9 - i10;
                int i12 = this.mHorizontalThumbCenterX;
                int i13 = this.mHorizontalThumbWidth;
                int i14 = i12 - (i13 / 2);
                StateListDrawable stateListDrawable2 = this.mHorizontalThumbDrawable;
                stateListDrawable2.setBounds(0, 0, i13, i10);
                int i15 = this.mRecyclerViewWidth;
                int i16 = this.mHorizontalTrackHeight;
                Drawable drawable2 = this.mHorizontalTrackDrawable;
                drawable2.setBounds(0, 0, i15, i16);
                canvas.translate(0.0f, i11);
                drawable2.draw(canvas);
                canvas.translate(i14, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i14, -i11);
            }
        }
    }

    public final void setState(int i) {
        RunnableC00991 r0 = this.mHideRunnable;
        StateListDrawable stateListDrawable = this.mVerticalThumbDrawable;
        if (i == 2 && this.mState != 2) {
            stateListDrawable.setState(PRESSED_STATE_SET);
            this.mRecyclerView.removeCallbacks(r0);
        }
        if (i == 0) {
            this.mRecyclerView.invalidate();
        } else {
            show();
        }
        if (this.mState == 2 && i != 2) {
            stateListDrawable.setState(EMPTY_STATE_SET);
            this.mRecyclerView.removeCallbacks(r0);
            this.mRecyclerView.postDelayed(r0, 1200);
        } else if (i == 1) {
            this.mRecyclerView.removeCallbacks(r0);
            this.mRecyclerView.postDelayed(r0, (long) PayloadAdapter.COLLAPSE_CHUNK_SIZE);
        }
        this.mState = i;
    }

    public final void show() {
        int i = this.mAnimationState;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        if (i != 0) {
            if (i == 3) {
                valueAnimator.cancel();
            } else {
                return;
            }
        }
        this.mAnimationState = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
