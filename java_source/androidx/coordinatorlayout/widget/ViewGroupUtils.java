package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
/* loaded from: classes.dex */
public abstract class ViewGroupUtils {
    public static final ThreadLocal sMatrix = new ThreadLocal();
    public static final ThreadLocal sRectF = new ThreadLocal();

    public static void offsetDescendantMatrix(CoordinatorLayout coordinatorLayout, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != coordinatorLayout) {
            View view2 = (View) parent;
            offsetDescendantMatrix(coordinatorLayout, view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
