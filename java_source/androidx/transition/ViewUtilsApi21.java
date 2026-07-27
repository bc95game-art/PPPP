package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.cardview.widget.RoundRectDrawable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import com.android.billingclient.api.zzcl;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.ShapePath;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ViewUtilsApi21 implements CreationExtras.Key, ProfileInstaller$DiagnosticsCallback, Clock {
    public static ViewUtilsApi21 DEFAULT = null;
    public static volatile ViewUtilsApi21 INSTANCE = null;
    public static boolean sSetFrameFetched = false;
    public static Method sSetFrameMethod = null;
    public static boolean sTryHiddenTransformMatrixToGlobal = true;
    public static boolean sTryHiddenTransformMatrixToLocal = true;
    public static boolean sTryHiddenTransitionAlpha = true;
    public static Field sViewFlagsField;
    public static boolean sViewFlagsFieldFetched;

    /* loaded from: classes.dex */
    public abstract class Api29Impl {
        public static void setAnimationMatrix(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        public static void transformMatrixToGlobal(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        public static void transformMatrixToLocal(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    public ViewUtilsApi21(JSONObject jSONObject) {
        jSONObject.optString("billingPeriod");
        jSONObject.optString("priceCurrencyCode");
        jSONObject.optString("formattedPrice");
        jSONObject.optLong("priceAmountMicros");
        jSONObject.optInt("recurrenceMode");
        jSONObject.optInt("billingCycleCount");
    }

    public boolean forceIntersection() {
        return this instanceof MarkerEdgeTreatment;
    }

    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }

    public float getTransitionAlpha(View view) {
        if (sTryHiddenTransitionAlpha) {
            try {
                return ViewUtilsApi19$Api29Impl.getTransitionAlpha(view);
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }

    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        if (!sSetFrameFetched) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                sSetFrameMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setFrame method", e);
            }
            sSetFrameFetched = true;
        }
        Method method = sSetFrameMethod;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void setMaxElevation(zzcl zzclVar, float f) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) ((Drawable) zzclVar.zzb);
        CardView cardView = (CardView) zzclVar.zzc;
        boolean useCompatPadding = cardView.getUseCompatPadding();
        boolean preventCornerOverlap = cardView.getPreventCornerOverlap();
        if (!(f == roundRectDrawable.mPadding && roundRectDrawable.mInsetForPadding == useCompatPadding && roundRectDrawable.mInsetForRadius == preventCornerOverlap)) {
            roundRectDrawable.mPadding = f;
            roundRectDrawable.mInsetForPadding = useCompatPadding;
            roundRectDrawable.mInsetForRadius = preventCornerOverlap;
            roundRectDrawable.updateBounds(null);
            roundRectDrawable.invalidateSelf();
        }
        if (!cardView.getUseCompatPadding()) {
            zzclVar.setShadowPadding(0, 0, 0, 0);
            return;
        }
        RoundRectDrawable roundRectDrawable2 = (RoundRectDrawable) ((Drawable) zzclVar.zzb);
        float f2 = roundRectDrawable2.mPadding;
        float f3 = roundRectDrawable2.mRadius;
        int ceil = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(f2, f3, cardView.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(f2, f3, cardView.getPreventCornerOverlap()));
        zzclVar.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    public void setTransitionAlpha(View view, float f) {
        if (sTryHiddenTransitionAlpha) {
            try {
                ViewUtilsApi19$Api29Impl.setTransitionAlpha(view, f);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f);
    }

    public void setTransitionVisibility(View view, int i) {
        if (!sViewFlagsFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
        Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        if (sTryHiddenTransformMatrixToGlobal) {
            try {
                Api29Impl.transformMatrixToGlobal(view, matrix);
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransformMatrixToGlobal = false;
            }
        }
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        if (sTryHiddenTransformMatrixToLocal) {
            try {
                Api29Impl.transformMatrixToLocal(view, matrix);
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransformMatrixToLocal = false;
            }
        }
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onDiagnosticReceived() {
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
    }
}
