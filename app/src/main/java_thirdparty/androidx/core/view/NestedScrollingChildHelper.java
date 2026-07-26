package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
/* loaded from: classes.dex */
public final class NestedScrollingChildHelper {
    public boolean mIsNestedScrollingEnabled;
    public ViewParent mNestedScrollingParentNonTouch;
    public ViewParent mNestedScrollingParentTouch;
    public int[] mTempNestedScrollConsumed;
    public final ViewGroup mView;

    public NestedScrollingChildHelper(ViewGroup viewGroup) {
        this.mView = viewGroup;
    }

    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent nestedScrollingParentForType;
        if (this.mIsNestedScrollingEnabled && (nestedScrollingParentForType = getNestedScrollingParentForType(0)) != null) {
            try {
                return ViewParentCompat$Api21Impl.onNestedFling(nestedScrollingParentForType, this.mView, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedFling", e);
            }
        }
        return false;
    }

    public final boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent nestedScrollingParentForType;
        if (this.mIsNestedScrollingEnabled && (nestedScrollingParentForType = getNestedScrollingParentForType(0)) != null) {
            try {
                return ViewParentCompat$Api21Impl.onNestedPreFling(nestedScrollingParentForType, this.mView, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedPreFling", e);
            }
        }
        return false;
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent nestedScrollingParentForType;
        int i4;
        int i5;
        if (!this.mIsNestedScrollingEnabled || (nestedScrollingParentForType = getNestedScrollingParentForType(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            ViewGroup viewGroup = this.mView;
            if (iArr2 != null) {
                viewGroup.getLocationInWindow(iArr2);
                i5 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i5 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                if (this.mTempNestedScrollConsumed == null) {
                    this.mTempNestedScrollConsumed = new int[2];
                }
                iArr = this.mTempNestedScrollConsumed;
            }
            int[] iArr3 = iArr;
            iArr3[0] = 0;
            iArr3[1] = 0;
            if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) nestedScrollingParentForType).onNestedPreScroll(viewGroup, i, i2, iArr3, i3);
            } else if (i3 == 0) {
                try {
                    ViewParentCompat$Api21Impl.onNestedPreScroll(nestedScrollingParentForType, viewGroup, i, i2, iArr3);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedPreScroll", e);
                }
            }
            if (iArr2 != null) {
                viewGroup.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i5;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr3[0] == 0 && iArr3[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public final boolean dispatchNestedScrollInternal(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i6;
        int i7;
        int[] iArr3;
        if (this.mIsNestedScrollingEnabled && (nestedScrollingParentForType = getNestedScrollingParentForType(i5)) != null) {
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                ViewGroup viewGroup = this.mView;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i7 = iArr[0];
                    i6 = iArr[1];
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                if (iArr2 == null) {
                    if (this.mTempNestedScrollConsumed == null) {
                        this.mTempNestedScrollConsumed = new int[2];
                    }
                    int[] iArr4 = this.mTempNestedScrollConsumed;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (nestedScrollingParentForType instanceof NestedScrollingParent3) {
                    ((NestedScrollingParent3) nestedScrollingParentForType).onNestedScroll(viewGroup, i, i2, i3, i4, i5, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i3;
                    iArr3[1] = iArr3[1] + i4;
                    if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
                        ((NestedScrollingParent2) nestedScrollingParentForType).onNestedScroll(viewGroup, i, i2, i3, i4, i5);
                    } else if (i5 == 0) {
                        try {
                            ViewParentCompat$Api21Impl.onNestedScroll(nestedScrollingParentForType, viewGroup, i, i2, i3, i4);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedScroll", e);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i7;
                    iArr[1] = iArr[1] - i6;
                }
                return true;
            } else if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent getNestedScrollingParentForType(int i) {
        if (i == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    public final boolean hasNestedScrollingParent(int i) {
        if (getNestedScrollingParentForType(i) != null) {
            return true;
        }
        return false;
    }

    public final boolean startNestedScroll(int i, int i2) {
        boolean z;
        if (!hasNestedScrollingParent(i2)) {
            if (this.mIsNestedScrollingEnabled) {
                View view = this.mView;
                ViewParent parent = view.getParent();
                View view2 = view;
                while (parent != null) {
                    boolean z2 = parent instanceof NestedScrollingParent2;
                    if (z2) {
                        z = ((NestedScrollingParent2) parent).onStartNestedScroll(view2, view, i, i2);
                    } else {
                        if (i2 == 0) {
                            try {
                                z = ViewParentCompat$Api21Impl.onStartNestedScroll(parent, view2, view, i);
                            } catch (AbstractMethodError e) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                            }
                        }
                        z = false;
                    }
                    if (z) {
                        if (i2 == 0) {
                            this.mNestedScrollingParentTouch = parent;
                        } else if (i2 == 1) {
                            this.mNestedScrollingParentNonTouch = parent;
                        }
                        if (z2) {
                            ((NestedScrollingParent2) parent).onNestedScrollAccepted(view2, view, i, i2);
                        } else if (i2 == 0) {
                            try {
                                ViewParentCompat$Api21Impl.onNestedScrollAccepted(parent, view2, view, i);
                            } catch (AbstractMethodError e2) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = (View) parent;
                        }
                        parent = parent.getParent();
                        view2 = view2;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void stopNestedScroll(int i) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType != null) {
            boolean z = nestedScrollingParentForType instanceof NestedScrollingParent2;
            ViewGroup viewGroup = this.mView;
            if (z) {
                ((NestedScrollingParent2) nestedScrollingParentForType).onStopNestedScroll(i, viewGroup);
            } else if (i == 0) {
                try {
                    ViewParentCompat$Api21Impl.onStopNestedScroll(nestedScrollingParentForType, viewGroup);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                this.mNestedScrollingParentTouch = null;
            } else if (i == 1) {
                this.mNestedScrollingParentNonTouch = null;
            }
        }
    }
}
