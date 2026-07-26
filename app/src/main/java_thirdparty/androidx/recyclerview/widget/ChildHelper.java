package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ChildHelper {
    public final RecyclerView.AnonymousClass5 mCallback;
    public View mViewInRemoveView;
    public int mRemoveStatus = 0;
    public final Bucket mBucket = new Bucket();
    public final ArrayList mHiddenViews = new ArrayList();

    /* loaded from: classes.dex */
    public final class Bucket {
        public long mData = 0;
        public Bucket mNext;

        public final void clear(int i) {
            if (i >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i);
        }

        public final int countOnesBefore(int i) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.mData & ((1 << i) - 1));
            } else {
                return Long.bitCount(this.mData) + bucket.countOnesBefore(i - 64);
            }
        }

        public final void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public final boolean get(int i) {
            if (i >= 64) {
                ensureNext();
                return this.mNext.get(i - 64);
            } else if ((this.mData & (1 << i)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public final void insert(int i, boolean z) {
            boolean z2;
            if (i >= 64) {
                ensureNext();
                this.mNext.insert(i - 64, z);
                return;
            }
            long j = this.mData;
            if ((Long.MIN_VALUE & j) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j2 = (1 << i) - 1;
            this.mData = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z2);
            }
        }

        public final boolean remove(int i) {
            boolean z;
            if (i >= 64) {
                ensureNext();
                return this.mNext.remove(i - 64);
            }
            long j = 1 << i;
            long j2 = this.mData;
            if ((j2 & j) != 0) {
                z = true;
            } else {
                z = false;
            }
            long j3 = j2 & (~j);
            this.mData = j3;
            long j4 = j - 1;
            this.mData = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z;
        }

        public final void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public final void set(int i) {
            if (i >= 64) {
                ensureNext();
                this.mNext.set(i - 64);
                return;
            }
            this.mData |= 1 << i;
        }

        public final String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    public ChildHelper(RecyclerView.AnonymousClass5 r2) {
        this.mCallback = r2;
    }

    public final void addView(View view, int i, boolean z) {
        int i2;
        RecyclerView recyclerView = RecyclerView.this;
        if (i < 0) {
            i2 = recyclerView.getChildCount();
        } else {
            i2 = getOffset(i);
        }
        this.mBucket.insert(i2, z);
        if (z) {
            hideViewInternal(view);
        }
        recyclerView.addView(view, i2);
        recyclerView.dispatchChildAttached(view);
    }

    public final void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        RecyclerView recyclerView = RecyclerView.this;
        if (i < 0) {
            i2 = recyclerView.getChildCount();
        } else {
            i2 = getOffset(i);
        }
        this.mBucket.insert(i2, z);
        if (z) {
            hideViewInternal(view);
        }
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d("RecyclerView", "reAttach " + childViewHolderInt);
                }
                childViewHolderInt.clearTmpDetachFlag();
            } else {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(recyclerView, sb));
            }
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(i2);
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, i2, layoutParams);
    }

    public final void detachViewFromParent(int i) {
        int offset = getOffset(i);
        this.mBucket.remove(offset);
        RecyclerView recyclerView = RecyclerView.this;
        View childAt = recyclerView.getChildAt(offset);
        if (childAt != null) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d("RecyclerView", "tmpDetach " + childViewHolderInt);
                    }
                    childViewHolderInt.addFlags(256);
                } else {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(recyclerView, sb));
                }
            }
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(offset);
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(offset);
    }

    public final View getChildAt(int i) {
        return RecyclerView.this.getChildAt(getOffset(i));
    }

    public final int getChildCount() {
        return RecyclerView.this.getChildCount() - this.mHiddenViews.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r3.get(r2) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int getOffset(int r6) {
        /*
            r5 = this;
            r0 = -1
            if (r6 >= 0) goto L4
            return r0
        L4:
            androidx.recyclerview.widget.RecyclerView$5 r1 = r5.mCallback
            androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
            int r1 = r1.getChildCount()
            r2 = r6
        Ld:
            if (r2 >= r1) goto L27
            androidx.recyclerview.widget.ChildHelper$Bucket r3 = r5.mBucket
            int r4 = r3.countOnesBefore(r2)
            int r4 = r2 - r4
            int r4 = r6 - r4
            if (r4 != 0) goto L25
        L1b:
            boolean r6 = r3.get(r2)
            if (r6 == 0) goto L24
            int r2 = r2 + 1
            goto L1b
        L24:
            return r2
        L25:
            int r2 = r2 + r4
            goto Ld
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ChildHelper.getOffset(int):int");
    }

    public final View getUnfilteredChildAt(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    public final int getUnfilteredChildCount() {
        return RecyclerView.this.getChildCount();
    }

    public final void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
        }
    }

    public final int indexOfChild(View view) {
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild == -1) {
            return -1;
        }
        Bucket bucket = this.mBucket;
        if (bucket.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - bucket.countOnesBefore(indexOfChild);
    }

    public final void removeViewAt(int i) {
        RecyclerView.AnonymousClass5 r0 = this.mCallback;
        int i2 = this.mRemoveStatus;
        if (i2 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        } else if (i2 != 2) {
            try {
                int offset = getOffset(i);
                View childAt = RecyclerView.this.getChildAt(offset);
                if (childAt != null) {
                    this.mRemoveStatus = 1;
                    this.mViewInRemoveView = childAt;
                    if (this.mBucket.remove(offset)) {
                        unhideViewInternal(childAt);
                    }
                    r0.removeViewAt(offset);
                }
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
            } catch (Throwable th) {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
    }

    public final String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public final void unhideViewInternal(View view) {
        RecyclerView.ViewHolder childViewHolderInt;
        if (this.mHiddenViews.remove(view) && (childViewHolderInt = RecyclerView.getChildViewHolderInt(view)) != null) {
            childViewHolderInt.onLeftHiddenState(RecyclerView.this);
        }
    }
}
