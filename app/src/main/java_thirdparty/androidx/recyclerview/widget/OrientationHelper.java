package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class OrientationHelper {
    public final RecyclerView.LayoutManager mLayoutManager;
    public int mLastTotalSpace = Integer.MIN_VALUE;
    public final Rect mTmpRect = new Rect();

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends OrientationHelper {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(RecyclerView.LayoutManager layoutManager, int i) {
            super(layoutManager);
            this.$r8$classId = i;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedEnd(View view) {
            int decoratedRight;
            int i;
            switch (this.$r8$classId) {
                case 0:
                    decoratedRight = this.mLayoutManager.getDecoratedRight(view);
                    i = ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
                    break;
                default:
                    decoratedRight = this.mLayoutManager.getDecoratedBottom(view);
                    i = ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
                    break;
            }
            return decoratedRight + i;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedMeasurement(View view) {
            int decoratedMeasuredWidth;
            int i;
            switch (this.$r8$classId) {
                case 0:
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    decoratedMeasuredWidth = this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    break;
                default:
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
                    decoratedMeasuredWidth = this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                    i = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                    break;
            }
            return decoratedMeasuredWidth + i;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedMeasurementInOther(View view) {
            int decoratedMeasuredHeight;
            int i;
            switch (this.$r8$classId) {
                case 0:
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    decoratedMeasuredHeight = this.mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    break;
                default:
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
                    decoratedMeasuredHeight = this.mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    i = ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                    break;
            }
            return decoratedMeasuredHeight + i;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getDecoratedStart(View view) {
            int decoratedLeft;
            int i;
            switch (this.$r8$classId) {
                case 0:
                    decoratedLeft = this.mLayoutManager.getDecoratedLeft(view);
                    i = ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
                    break;
                default:
                    decoratedLeft = this.mLayoutManager.getDecoratedTop(view);
                    i = ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
                    break;
            }
            return decoratedLeft - i;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEnd() {
            switch (this.$r8$classId) {
                case 0:
                    return this.mLayoutManager.getWidth();
                default:
                    return this.mLayoutManager.getHeight();
            }
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEndAfterPadding() {
            int width;
            int paddingRight;
            switch (this.$r8$classId) {
                case 0:
                    RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
                    width = layoutManager.getWidth();
                    paddingRight = layoutManager.getPaddingRight();
                    break;
                default:
                    RecyclerView.LayoutManager layoutManager2 = this.mLayoutManager;
                    width = layoutManager2.getHeight();
                    paddingRight = layoutManager2.getPaddingBottom();
                    break;
            }
            return width - paddingRight;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getEndPadding() {
            switch (this.$r8$classId) {
                case 0:
                    return this.mLayoutManager.getPaddingRight();
                default:
                    return this.mLayoutManager.getPaddingBottom();
            }
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getMode() {
            switch (this.$r8$classId) {
                case 0:
                    return this.mLayoutManager.getWidthMode();
                default:
                    return this.mLayoutManager.getHeightMode();
            }
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getModeInOther() {
            switch (this.$r8$classId) {
                case 0:
                    return this.mLayoutManager.getHeightMode();
                default:
                    return this.mLayoutManager.getWidthMode();
            }
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getStartAfterPadding() {
            switch (this.$r8$classId) {
                case 0:
                    return this.mLayoutManager.getPaddingLeft();
                default:
                    return this.mLayoutManager.getPaddingTop();
            }
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTotalSpace() {
            int width;
            int paddingRight;
            switch (this.$r8$classId) {
                case 0:
                    RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
                    width = layoutManager.getWidth() - layoutManager.getPaddingLeft();
                    paddingRight = layoutManager.getPaddingRight();
                    break;
                default:
                    RecyclerView.LayoutManager layoutManager2 = this.mLayoutManager;
                    width = layoutManager2.getHeight() - layoutManager2.getPaddingTop();
                    paddingRight = layoutManager2.getPaddingBottom();
                    break;
            }
            return width - paddingRight;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTransformedEndWithDecoration(View view) {
            switch (this.$r8$classId) {
                case 0:
                    RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
                    Rect rect = this.mTmpRect;
                    layoutManager.getTransformedBoundingBox(view, true, rect);
                    return rect.right;
                default:
                    RecyclerView.LayoutManager layoutManager2 = this.mLayoutManager;
                    Rect rect2 = this.mTmpRect;
                    layoutManager2.getTransformedBoundingBox(view, true, rect2);
                    return rect2.bottom;
            }
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final int getTransformedStartWithDecoration(View view) {
            switch (this.$r8$classId) {
                case 0:
                    RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
                    Rect rect = this.mTmpRect;
                    layoutManager.getTransformedBoundingBox(view, true, rect);
                    return rect.left;
                default:
                    RecyclerView.LayoutManager layoutManager2 = this.mLayoutManager;
                    Rect rect2 = this.mTmpRect;
                    layoutManager2.getTransformedBoundingBox(view, true, rect2);
                    return rect2.top;
            }
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public final void offsetChildren(int i) {
            switch (this.$r8$classId) {
                case 0:
                    this.mLayoutManager.offsetChildrenHorizontal(i);
                    return;
                default:
                    this.mLayoutManager.offsetChildrenVertical(i);
                    return;
            }
        }
    }

    public OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager layoutManager, int i) {
        if (i == 0) {
            return new AnonymousClass1(layoutManager, 0);
        }
        if (i == 1) {
            return new AnonymousClass1(layoutManager, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public abstract int getTransformedEndWithDecoration(View view);

    public abstract int getTransformedStartWithDecoration(View view);

    public abstract void offsetChildren(int i);
}
