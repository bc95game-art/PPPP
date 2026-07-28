package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public final class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int[] ATTRS = {16843284};
    public final Rect mBounds = new Rect();
    public final Drawable mDivider;
    public final int mOrientation;

    public DividerItemDecoration(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.mDivider = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        if (i == 0 || i == 1) {
            this.mOrientation = i;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView) {
        Drawable drawable = this.mDivider;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView) {
        Drawable drawable;
        int i;
        int i2;
        int i3;
        int i4;
        if (recyclerView.getLayoutManager() != null && (drawable = this.mDivider) != null) {
            int i5 = this.mOrientation;
            int i6 = 0;
            Rect rect = this.mBounds;
            if (i5 == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i4 = recyclerView.getPaddingLeft();
                    i3 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i4, recyclerView.getPaddingTop(), i3, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i3 = recyclerView.getWidth();
                    i4 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (i6 < childCount) {
                    View childAt = recyclerView.getChildAt(i6);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
                    int round = Math.round(childAt.getTranslationY()) + rect.bottom;
                    drawable.setBounds(i4, round - drawable.getIntrinsicHeight(), i3, round);
                    drawable.draw(canvas);
                    i6++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i2 = recyclerView.getPaddingTop();
                i = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), i);
            } else {
                i = recyclerView.getHeight();
                i2 = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (i6 < childCount2) {
                View childAt2 = recyclerView.getChildAt(i6);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, rect);
                int round2 = Math.round(childAt2.getTranslationX()) + rect.right;
                drawable.setBounds(round2 - drawable.getIntrinsicWidth(), i2, round2, i);
                drawable.draw(canvas);
                i6++;
            }
            canvas.restore();
        }
    }
}
