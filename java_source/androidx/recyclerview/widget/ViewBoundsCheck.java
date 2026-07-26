package androidx.recyclerview.widget;

import android.view.View;
/* loaded from: classes.dex */
public final class ViewBoundsCheck {
    public final BoundFlags mBoundFlags;
    public final Callback mCallback;

    /* loaded from: classes.dex */
    public final class BoundFlags {
        public int mBoundFlags;
        public int mChildEnd;
        public int mChildStart;
        public int mRvEnd;
        public int mRvStart;

        public final boolean boundsMatch() {
            int i;
            int i2;
            int i3;
            int i4 = this.mBoundFlags;
            int i5 = 2;
            if ((i4 & 7) != 0) {
                int i6 = this.mChildStart;
                int i7 = this.mRvStart;
                if (i6 > i7) {
                    i3 = 1;
                } else if (i6 == i7) {
                    i3 = 2;
                } else {
                    i3 = 4;
                }
                if ((i3 & i4) == 0) {
                    return false;
                }
            }
            if ((i4 & 112) != 0) {
                int i8 = this.mChildStart;
                int i9 = this.mRvEnd;
                if (i8 > i9) {
                    i2 = 1;
                } else if (i8 == i9) {
                    i2 = 2;
                } else {
                    i2 = 4;
                }
                if (((i2 << 4) & i4) == 0) {
                    return false;
                }
            }
            if ((i4 & 1792) != 0) {
                int i10 = this.mChildEnd;
                int i11 = this.mRvStart;
                if (i10 > i11) {
                    i = 1;
                } else if (i10 == i11) {
                    i = 2;
                } else {
                    i = 4;
                }
                if (((i << 8) & i4) == 0) {
                    return false;
                }
            }
            if ((i4 & 28672) != 0) {
                int i12 = this.mChildEnd;
                int i13 = this.mRvEnd;
                if (i12 > i13) {
                    i5 = 1;
                } else if (i12 != i13) {
                    i5 = 4;
                }
                if ((i4 & (i5 << 12)) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface Callback {
        View getChildAt(int i);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, androidx.recyclerview.widget.ViewBoundsCheck$BoundFlags] */
    public ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
        ?? obj = new Object();
        obj.mBoundFlags = 0;
        this.mBoundFlags = obj;
    }

    public final View findOneViewWithinBoundFlags(int i, int i2, int i3, int i4) {
        int i5;
        Callback callback = this.mCallback;
        int parentStart = callback.getParentStart();
        int parentEnd = callback.getParentEnd();
        if (i2 > i) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        View view = null;
        while (i != i2) {
            View childAt = callback.getChildAt(i);
            int childStart = callback.getChildStart(childAt);
            int childEnd = callback.getChildEnd(childAt);
            BoundFlags boundFlags = this.mBoundFlags;
            boundFlags.mRvStart = parentStart;
            boundFlags.mRvEnd = parentEnd;
            boundFlags.mChildStart = childStart;
            boundFlags.mChildEnd = childEnd;
            if (i3 != 0) {
                boundFlags.mBoundFlags = i3;
                if (boundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                boundFlags.mBoundFlags = i4;
                if (boundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            i += i5;
        }
        return view;
    }

    public final boolean isViewWithinBoundFlags(View view) {
        Callback callback = this.mCallback;
        int parentStart = callback.getParentStart();
        int parentEnd = callback.getParentEnd();
        int childStart = callback.getChildStart(view);
        int childEnd = callback.getChildEnd(view);
        BoundFlags boundFlags = this.mBoundFlags;
        boundFlags.mRvStart = parentStart;
        boundFlags.mRvEnd = parentEnd;
        boundFlags.mChildStart = childStart;
        boundFlags.mChildEnd = childEnd;
        boundFlags.mBoundFlags = 24579;
        return boundFlags.boundsMatch();
    }
}
