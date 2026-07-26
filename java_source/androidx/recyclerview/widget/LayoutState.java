package androidx.recyclerview.widget;
/* loaded from: classes.dex */
public final class LayoutState {
    public int mAvailable;
    public int mCurrentPosition;
    public int mEndLine;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mRecycle;
    public int mStartLine;
    public boolean mStopInFocusable;

    public final String toString() {
        return "LayoutState{mAvailable=" + this.mAvailable + ", mCurrentPosition=" + this.mCurrentPosition + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + ", mStartLine=" + this.mStartLine + ", mEndLine=" + this.mEndLine + '}';
    }
}
