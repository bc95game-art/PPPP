package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.transition.ChangeBounds;
/* loaded from: classes.dex */
public abstract class ViewUtils {
    public static final ViewUtilsApi21 IMPL;
    public static final C01151 TRANSITION_ALPHA;

    /* renamed from: androidx.transition.ViewUtils$1 */
    /* loaded from: classes.dex */
    public final class C01151 extends Property {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C01151(Class cls, String str, int i) {
            super(cls, str);
            this.$r8$classId = i;
        }

        @Override // android.util.Property
        public final Object get(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return Float.valueOf(ViewUtils.IMPL.getTransitionAlpha((View) obj));
                case 1:
                    return Float.valueOf(((SwitchCompat) obj).mThumbPosition);
                case 2:
                    ChangeBounds.ViewBounds viewBounds = (ChangeBounds.ViewBounds) obj;
                    return null;
                case 3:
                    ChangeBounds.ViewBounds viewBounds2 = (ChangeBounds.ViewBounds) obj;
                    return null;
                case 4:
                    View view = (View) obj;
                    return null;
                case 5:
                    View view2 = (View) obj;
                    return null;
                case 6:
                    View view3 = (View) obj;
                    return null;
                default:
                    return ((View) obj).getClipBounds();
            }
        }

        @Override // android.util.Property
        public final void set(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    float floatValue = ((Float) obj2).floatValue();
                    ViewUtils.IMPL.setTransitionAlpha((View) obj, floatValue);
                    return;
                case 1:
                    ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                    return;
                case 2:
                    ChangeBounds.ViewBounds viewBounds = (ChangeBounds.ViewBounds) obj;
                    PointF pointF = (PointF) obj2;
                    viewBounds.getClass();
                    viewBounds.mLeft = Math.round(pointF.x);
                    int round = Math.round(pointF.y);
                    viewBounds.mTop = round;
                    int i = viewBounds.mTopLeftCalls + 1;
                    viewBounds.mTopLeftCalls = i;
                    if (i == viewBounds.mBottomRightCalls) {
                        ViewUtils.setLeftTopRightBottom(viewBounds.mView, viewBounds.mLeft, round, viewBounds.mRight, viewBounds.mBottom);
                        viewBounds.mTopLeftCalls = 0;
                        viewBounds.mBottomRightCalls = 0;
                        return;
                    }
                    return;
                case 3:
                    ChangeBounds.ViewBounds viewBounds2 = (ChangeBounds.ViewBounds) obj;
                    PointF pointF2 = (PointF) obj2;
                    viewBounds2.getClass();
                    viewBounds2.mRight = Math.round(pointF2.x);
                    int round2 = Math.round(pointF2.y);
                    viewBounds2.mBottom = round2;
                    int i2 = viewBounds2.mBottomRightCalls + 1;
                    viewBounds2.mBottomRightCalls = i2;
                    if (viewBounds2.mTopLeftCalls == i2) {
                        ViewUtils.setLeftTopRightBottom(viewBounds2.mView, viewBounds2.mLeft, viewBounds2.mTop, viewBounds2.mRight, round2);
                        viewBounds2.mTopLeftCalls = 0;
                        viewBounds2.mBottomRightCalls = 0;
                        return;
                    }
                    return;
                case 4:
                    View view = (View) obj;
                    PointF pointF3 = (PointF) obj2;
                    ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                    return;
                case 5:
                    View view2 = (View) obj;
                    PointF pointF4 = (PointF) obj2;
                    ViewUtils.setLeftTopRightBottom(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                    return;
                case 6:
                    View view3 = (View) obj;
                    PointF pointF5 = (PointF) obj2;
                    int round3 = Math.round(pointF5.x);
                    int round4 = Math.round(pointF5.y);
                    ViewUtils.setLeftTopRightBottom(view3, round3, round4, view3.getWidth() + round3, view3.getHeight() + round4);
                    return;
                default:
                    ((View) obj).setClipBounds((Rect) obj2);
                    return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            IMPL = new Object();
        } else if (i >= 23) {
            IMPL = new Object();
        } else if (i >= 22) {
            IMPL = new Object();
        } else {
            IMPL = new Object();
        }
        TRANSITION_ALPHA = new C01151(Float.class, "translationAlpha", 0);
        new C01151(Rect.class, "clipBounds", 7);
    }

    public static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    public static void setTransitionVisibility(View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }
}
