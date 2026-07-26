package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck;
/* loaded from: classes.dex */
public final class OpReorderer implements ViewBoundsCheck.Callback {
    public final /* synthetic */ int $r8$classId;
    public final Object mCallback;

    public /* synthetic */ OpReorderer(int i, Object obj) {
        this.$r8$classId = i;
        this.mCallback = obj;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public View getChildAt(int i) {
        switch (this.$r8$classId) {
            case 1:
                return ((RecyclerView.LayoutManager) this.mCallback).getChildAt(i);
            default:
                return ((RecyclerView.LayoutManager) this.mCallback).getChildAt(i);
        }
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getChildEnd(View view) {
        int decoratedRight;
        int i;
        switch (this.$r8$classId) {
            case 1:
                decoratedRight = ((RecyclerView.LayoutManager) this.mCallback).getDecoratedRight(view);
                i = ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
                break;
            default:
                decoratedRight = ((RecyclerView.LayoutManager) this.mCallback).getDecoratedBottom(view);
                i = ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
                break;
        }
        return decoratedRight + i;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getChildStart(View view) {
        int decoratedLeft;
        int i;
        switch (this.$r8$classId) {
            case 1:
                decoratedLeft = ((RecyclerView.LayoutManager) this.mCallback).getDecoratedLeft(view);
                i = ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
                break;
            default:
                decoratedLeft = ((RecyclerView.LayoutManager) this.mCallback).getDecoratedTop(view);
                i = ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
                break;
        }
        return decoratedLeft - i;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getParentEnd() {
        int width;
        int paddingRight;
        switch (this.$r8$classId) {
            case 1:
                RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.mCallback;
                width = layoutManager.getWidth();
                paddingRight = layoutManager.getPaddingRight();
                break;
            default:
                RecyclerView.LayoutManager layoutManager2 = (RecyclerView.LayoutManager) this.mCallback;
                width = layoutManager2.getHeight();
                paddingRight = layoutManager2.getPaddingBottom();
                break;
        }
        return width - paddingRight;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getParentStart() {
        switch (this.$r8$classId) {
            case 1:
                return ((RecyclerView.LayoutManager) this.mCallback).getPaddingLeft();
            default:
                return ((RecyclerView.LayoutManager) this.mCallback).getPaddingTop();
        }
    }
}
