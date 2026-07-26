package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class LeftSheetDelegate extends LazyKt__LazyJVMKt {
    public final /* synthetic */ int $r8$classId;
    public final SideSheetBehavior sheetBehavior;

    public /* synthetic */ LeftSheetDelegate(SideSheetBehavior sideSheetBehavior, int i) {
        this.$r8$classId = i;
        this.sheetBehavior = sideSheetBehavior;
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.$r8$classId) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final float calculateSlideOffset(int i) {
        switch (this.$r8$classId) {
            case 0:
                float hiddenOffset = getHiddenOffset();
                return (i - hiddenOffset) / (getExpandedOffset() - hiddenOffset);
            default:
                float f = this.sheetBehavior.parentWidth;
                return (f - i) / (f - getExpandedOffset());
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.$r8$classId) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getExpandedOffset() {
        switch (this.$r8$classId) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.sheetBehavior;
                return Math.max(0, sideSheetBehavior.parentInnerEdge + sideSheetBehavior.innerMargin);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.sheetBehavior;
                return Math.max(0, (sideSheetBehavior2.parentWidth - sideSheetBehavior2.childWidth) - sideSheetBehavior2.innerMargin);
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getHiddenOffset() {
        switch (this.$r8$classId) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.sheetBehavior;
                return (-sideSheetBehavior.childWidth) - sideSheetBehavior.innerMargin;
            default:
                return this.sheetBehavior.parentWidth;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getMaxViewPositionHorizontal() {
        switch (this.$r8$classId) {
            case 0:
                return this.sheetBehavior.innerMargin;
            default:
                return this.sheetBehavior.parentWidth;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getMinViewPositionHorizontal() {
        switch (this.$r8$classId) {
            case 0:
                return -this.sheetBehavior.childWidth;
            default:
                return getExpandedOffset();
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getOuterEdge(View view) {
        switch (this.$r8$classId) {
            case 0:
                return view.getRight() + this.sheetBehavior.innerMargin;
            default:
                return view.getLeft() - this.sheetBehavior.innerMargin;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getParentInnerEdge(CoordinatorLayout coordinatorLayout) {
        switch (this.$r8$classId) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getSheetEdge() {
        switch (this.$r8$classId) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean isExpandingOutwards(float f) {
        switch (this.$r8$classId) {
            case 0:
                return f > 0.0f;
            default:
                return f < 0.0f;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean isReleasedCloseToInnerEdge(View view) {
        switch (this.$r8$classId) {
            case 0:
                if (view.getRight() < (getExpandedOffset() - getHiddenOffset()) / 2) {
                    return true;
                }
                return false;
            default:
                if (view.getLeft() > (getExpandedOffset() + this.sheetBehavior.parentWidth) / 2) {
                    return true;
                }
                return false;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean isSwipeSignificant(float f, float f2) {
        switch (this.$r8$classId) {
            case 0:
                if (Math.abs(f) <= Math.abs(f2) || Math.abs(f) <= 500) {
                    return false;
                }
                return true;
            default:
                if (Math.abs(f) <= Math.abs(f2) || Math.abs(f) <= 500) {
                    return false;
                }
                return true;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean shouldHide(View view, float f) {
        switch (this.$r8$classId) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.sheetBehavior;
                float abs = Math.abs((f * sideSheetBehavior.hideFriction) + view.getLeft());
                sideSheetBehavior.getClass();
                if (abs > 0.5f) {
                    return true;
                }
                return false;
            default:
                SideSheetBehavior sideSheetBehavior2 = this.sheetBehavior;
                float abs2 = Math.abs((f * sideSheetBehavior2.hideFriction) + view.getRight());
                sideSheetBehavior2.getClass();
                if (abs2 > 0.5f) {
                    return true;
                }
                return false;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final void updateCoplanarSiblingAdjacentMargin(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        switch (this.$r8$classId) {
            case 0:
                marginLayoutParams.leftMargin = i;
                return;
            default:
                marginLayoutParams.rightMargin = i;
                return;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        switch (this.$r8$classId) {
            case 0:
                if (i <= this.sheetBehavior.parentWidth) {
                    marginLayoutParams.leftMargin = i2;
                    return;
                }
                return;
            default:
                int i3 = this.sheetBehavior.parentWidth;
                if (i <= i3) {
                    marginLayoutParams.rightMargin = i3 - i;
                    return;
                }
                return;
        }
    }
}
