package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.CamUtils;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.brotli.dec.HuffmanTreeGroup;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class VectorDrawableCompat extends VectorDrawableCommon {
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    public boolean mAllowCaching;
    public ColorFilter mColorFilter;
    public boolean mMutated;
    public PorterDuffColorFilter mTintFilter;
    public final Rect mTmpBounds;
    public final float[] mTmpFloats;
    public final Matrix mTmpMatrix;
    public VectorDrawableCompatState mVectorState;

    /* loaded from: classes.dex */
    public final class VClipPath extends VPath {
    }

    /* loaded from: classes.dex */
    public final class VFullPath extends VPath {
        public float mFillAlpha;
        public HuffmanTreeGroup mFillColor;
        public float mStrokeAlpha;
        public HuffmanTreeGroup mStrokeColor;
        public Paint.Cap mStrokeLineCap;
        public Paint.Join mStrokeLineJoin;
        public float mStrokeMiterlimit;
        public float mStrokeWidth;
        public float mTrimPathEnd;
        public float mTrimPathOffset;
        public float mTrimPathStart;

        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        public int getFillColor() {
            return this.mFillColor.alphabetSize;
        }

        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        public int getStrokeColor() {
            return this.mStrokeColor.alphabetSize;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean isStateful() {
            if (this.mFillColor.isStateful() || this.mStrokeColor.isStateful()) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean onStateChanged(int[] iArr) {
            boolean z;
            HuffmanTreeGroup huffmanTreeGroup;
            HuffmanTreeGroup huffmanTreeGroup2 = this.mFillColor;
            boolean z2 = true;
            if (huffmanTreeGroup2.isStateful()) {
                ColorStateList colorStateList = (ColorStateList) huffmanTreeGroup2.trees;
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (colorForState != huffmanTreeGroup2.alphabetSize) {
                    huffmanTreeGroup2.alphabetSize = colorForState;
                    z = true;
                    huffmanTreeGroup = this.mStrokeColor;
                    if (huffmanTreeGroup.isStateful()) {
                        ColorStateList colorStateList2 = (ColorStateList) huffmanTreeGroup.trees;
                        int colorForState2 = colorStateList2.getColorForState(iArr, colorStateList2.getDefaultColor());
                        if (colorForState2 != huffmanTreeGroup.alphabetSize) {
                            huffmanTreeGroup.alphabetSize = colorForState2;
                            return z | z2;
                        }
                    }
                    z2 = false;
                    return z | z2;
                }
            }
            z = false;
            huffmanTreeGroup = this.mStrokeColor;
            if (huffmanTreeGroup.isStateful()) {
            }
            z2 = false;
            return z | z2;
        }

        public void setFillAlpha(float f) {
            this.mFillAlpha = f;
        }

        public void setFillColor(int i) {
            this.mFillColor.alphabetSize = i;
        }

        public void setStrokeAlpha(float f) {
            this.mStrokeAlpha = f;
        }

        public void setStrokeColor(int i) {
            this.mStrokeColor.alphabetSize = i;
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
        }

        public void setTrimPathEnd(float f) {
            this.mTrimPathEnd = f;
        }

        public void setTrimPathOffset(float f) {
            this.mTrimPathOffset = f;
        }

        public void setTrimPathStart(float f) {
            this.mTrimPathStart = f;
        }
    }

    /* loaded from: classes.dex */
    public abstract class VObject {
        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public final class VectorDrawableCompatState extends Drawable.ConstantState {
        public boolean mAutoMirrored;
        public boolean mCacheDirty;
        public boolean mCachedAutoMirrored;
        public Bitmap mCachedBitmap;
        public int mCachedRootAlpha;
        public ColorStateList mCachedTint;
        public PorterDuff.Mode mCachedTintMode;
        public int mChangingConfigurations;
        public Paint mTempPaint;
        public ColorStateList mTint;
        public PorterDuff.Mode mTintMode;
        public VPathRenderer mVPathRenderer;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.drawable.Drawable$ConstantState, androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState] */
    public VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        ?? constantState = new Drawable.ConstantState();
        constantState.mTint = null;
        constantState.mTintMode = DEFAULT_TINT_MODE;
        constantState.mVPathRenderer = new VPathRenderer();
        this.mVectorState = constantState;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable == null) {
            return false;
        }
        DrawableCompat$Api21Impl.canApplyTheme(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.mTmpBounds;
        copyBounds(rect);
        if (rect.width() > 0 && rect.height() > 0) {
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter == null) {
                colorFilter = this.mTintFilter;
            }
            Matrix matrix = this.mTmpMatrix;
            canvas.getMatrix(matrix);
            float[] fArr = this.mTmpFloats;
            matrix.getValues(fArr);
            float abs = Math.abs(fArr[0]);
            float abs2 = Math.abs(fArr[4]);
            float abs3 = Math.abs(fArr[1]);
            float abs4 = Math.abs(fArr[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (rect.width() * abs));
            int min2 = Math.min(2048, (int) (rect.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate(rect.left, rect.top);
                if (isAutoMirrored() && BundleKt.getLayoutDirection(this) == 1) {
                    canvas.translate(rect.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                rect.offsetTo(0, 0);
                VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
                Bitmap bitmap = vectorDrawableCompatState.mCachedBitmap;
                if (!(bitmap != null && min == bitmap.getWidth() && min2 == vectorDrawableCompatState.mCachedBitmap.getHeight())) {
                    vectorDrawableCompatState.mCachedBitmap = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                    vectorDrawableCompatState.mCacheDirty = true;
                }
                if (!this.mAllowCaching) {
                    VectorDrawableCompatState vectorDrawableCompatState2 = this.mVectorState;
                    vectorDrawableCompatState2.mCachedBitmap.eraseColor(0);
                    Canvas canvas2 = new Canvas(vectorDrawableCompatState2.mCachedBitmap);
                    VPathRenderer vPathRenderer = vectorDrawableCompatState2.mVPathRenderer;
                    vPathRenderer.drawGroupTree(vPathRenderer.mRootGroup, VPathRenderer.IDENTITY_MATRIX, canvas2, min, min2);
                } else {
                    VectorDrawableCompatState vectorDrawableCompatState3 = this.mVectorState;
                    if (!(!vectorDrawableCompatState3.mCacheDirty && vectorDrawableCompatState3.mCachedTint == vectorDrawableCompatState3.mTint && vectorDrawableCompatState3.mCachedTintMode == vectorDrawableCompatState3.mTintMode && vectorDrawableCompatState3.mCachedAutoMirrored == vectorDrawableCompatState3.mAutoMirrored && vectorDrawableCompatState3.mCachedRootAlpha == vectorDrawableCompatState3.mVPathRenderer.getRootAlpha())) {
                        VectorDrawableCompatState vectorDrawableCompatState4 = this.mVectorState;
                        vectorDrawableCompatState4.mCachedBitmap.eraseColor(0);
                        Canvas canvas3 = new Canvas(vectorDrawableCompatState4.mCachedBitmap);
                        VPathRenderer vPathRenderer2 = vectorDrawableCompatState4.mVPathRenderer;
                        vPathRenderer2.drawGroupTree(vPathRenderer2.mRootGroup, VPathRenderer.IDENTITY_MATRIX, canvas3, min, min2);
                        VectorDrawableCompatState vectorDrawableCompatState5 = this.mVectorState;
                        vectorDrawableCompatState5.mCachedTint = vectorDrawableCompatState5.mTint;
                        vectorDrawableCompatState5.mCachedTintMode = vectorDrawableCompatState5.mTintMode;
                        vectorDrawableCompatState5.mCachedRootAlpha = vectorDrawableCompatState5.mVPathRenderer.getRootAlpha();
                        vectorDrawableCompatState5.mCachedAutoMirrored = vectorDrawableCompatState5.mAutoMirrored;
                        vectorDrawableCompatState5.mCacheDirty = false;
                    }
                }
                VectorDrawableCompatState vectorDrawableCompatState6 = this.mVectorState;
                if (vectorDrawableCompatState6.mVPathRenderer.getRootAlpha() >= 255 && colorFilter == null) {
                    paint = null;
                } else {
                    if (vectorDrawableCompatState6.mTempPaint == null) {
                        Paint paint2 = new Paint();
                        vectorDrawableCompatState6.mTempPaint = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    vectorDrawableCompatState6.mTempPaint.setAlpha(vectorDrawableCompatState6.mVPathRenderer.getRootAlpha());
                    vectorDrawableCompatState6.mTempPaint.setColorFilter(colorFilter);
                    paint = vectorDrawableCompatState6.mTempPaint;
                }
                canvas.drawBitmap(vectorDrawableCompatState6.mCachedBitmap, (Rect) null, rect, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return DrawableCompat$Api21Impl.getColorFilter(drawable);
        }
        return this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState == null) {
            return false;
        }
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        if (vPathRenderer.mIsStateful == null) {
            vPathRenderer.mIsStateful = Boolean.valueOf(vPathRenderer.mRootGroup.isStateful());
        }
        if (vPathRenderer.mIsStateful.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.mVectorState.mTint;
        if (colorStateList == null || !colorStateList.isStateful()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.Drawable$ConstantState, androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState] */
    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            ?? constantState = new Drawable.ConstantState();
            constantState.mTint = null;
            constantState.mTintMode = DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                constantState.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                constantState.mVPathRenderer = vPathRenderer;
                if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                    vPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                    constantState.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
                }
                constantState.mTint = vectorDrawableCompatState.mTint;
                constantState.mTintMode = vectorDrawableCompatState.mTintMode;
                constantState.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
            this.mVectorState = constantState;
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompatState.mTint;
        if (colorStateList == null || (mode = vectorDrawableCompatState.mTintMode) == null) {
            z = false;
        } else {
            this.mTintFilter = updateTintFilter(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
        if (vPathRenderer.mIsStateful == null) {
            vPathRenderer.mIsStateful = Boolean.valueOf(vPathRenderer.mRootGroup.isStateful());
        }
        if (vPathRenderer.mIsStateful.booleanValue()) {
            boolean onStateChanged = vectorDrawableCompatState.mVPathRenderer.mRootGroup.onStateChanged(iArr);
            vectorDrawableCompatState.mCacheDirty |= onStateChanged;
            if (onStateChanged) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.mVectorState.mAutoMirrored = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            BundleKt.setTint(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setTintList(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint != colorStateList) {
            vectorDrawableCompatState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(colorStateList, vectorDrawableCompatState.mTintMode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.setTintMode(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode != mode) {
            vectorDrawableCompatState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public final PorterDuffColorFilter updateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* loaded from: classes.dex */
    public final class VectorDrawableDelegateState extends Drawable.ConstantState {
        public final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    /* loaded from: classes.dex */
    public abstract class VPath extends VObject {
        public int mFillRule;
        public PathParser$PathDataNode[] mNodes;
        public String mPathName;

        public VPath() {
            this.mNodes = null;
            this.mFillRule = 0;
        }

        public PathParser$PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public void setPathData(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
            if (!BundleKt.canMorph(this.mNodes, pathParser$PathDataNodeArr)) {
                this.mNodes = BundleKt.deepCopyNodes(pathParser$PathDataNodeArr);
                return;
            }
            PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = this.mNodes;
            for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
                pathParser$PathDataNodeArr2[i].mType = pathParser$PathDataNodeArr[i].mType;
                int i2 = 0;
                while (true) {
                    float[] fArr = pathParser$PathDataNodeArr[i].mParams;
                    if (i2 < fArr.length) {
                        pathParser$PathDataNodeArr2[i].mParams[i2] = fArr[i2];
                        i2++;
                    }
                }
            }
        }

        public VPath(VPath vPath) {
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = vPath.mPathName;
            this.mNodes = BundleKt.deepCopyNodes(vPath.mNodes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Object, androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath, androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath] */
    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            DrawableCompat$Api21Impl.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
        TypedArray obtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        VectorDrawableCompatState vectorDrawableCompatState2 = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState2.mVPathRenderer;
        int i2 = !CamUtils.hasAttribute(xmlPullParser, "tintMode") ? -1 : obtainAttributes.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i2 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i2 != 5) {
            if (i2 != 9) {
                switch (i2) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        vectorDrawableCompatState2.mTintMode = mode;
        ColorStateList colorStateList = null;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            obtainAttributes.getValue(1, typedValue);
            int i3 = typedValue.type;
            if (i3 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            } else if (i3 < 28 || i3 > 31) {
                Resources resources2 = obtainAttributes.getResources();
                int resourceId = obtainAttributes.getResourceId(1, 0);
                ThreadLocal threadLocal = ColorStateListInflaterCompat.sTempTypedValue;
                try {
                    colorStateList = ColorStateListInflaterCompat.createFromXml(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
                }
            } else {
                colorStateList = ColorStateList.valueOf(typedValue.data);
            }
        }
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList2 != null) {
            vectorDrawableCompatState2.mTint = colorStateList2;
        }
        boolean z = vectorDrawableCompatState2.mAutoMirrored;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z = obtainAttributes.getBoolean(5, z);
        }
        vectorDrawableCompatState2.mAutoMirrored = z;
        float f = vPathRenderer.mViewportWidth;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f = obtainAttributes.getFloat(7, f);
        }
        vPathRenderer.mViewportWidth = f;
        float f2 = vPathRenderer.mViewportHeight;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f2 = obtainAttributes.getFloat(8, f2);
        }
        vPathRenderer.mViewportHeight = f2;
        if (vPathRenderer.mViewportWidth <= 0.0f) {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f2 > 0.0f) {
            vPathRenderer.mBaseWidth = obtainAttributes.getDimension(3, vPathRenderer.mBaseWidth);
            float dimension = obtainAttributes.getDimension(2, vPathRenderer.mBaseHeight);
            vPathRenderer.mBaseHeight = dimension;
            if (vPathRenderer.mBaseWidth <= 0.0f) {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                float alpha = vPathRenderer.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
                    alpha = obtainAttributes.getFloat(4, alpha);
                }
                vPathRenderer.setAlpha(alpha);
                String string = obtainAttributes.getString(0);
                if (string != null) {
                    vPathRenderer.mRootName = string;
                    vPathRenderer.mVGTargetsMap.put(string, vPathRenderer);
                }
                obtainAttributes.recycle();
                vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
                vectorDrawableCompatState.mCacheDirty = true;
                VectorDrawableCompatState vectorDrawableCompatState3 = this.mVectorState;
                VPathRenderer vPathRenderer2 = vectorDrawableCompatState3.mVPathRenderer;
                ArrayDeque arrayDeque = new ArrayDeque();
                VGroup vGroup = vPathRenderer2.mRootGroup;
                ArrayMap arrayMap = vPathRenderer2.mVGTargetsMap;
                arrayDeque.push(vGroup);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z2 = true;
                for (int i4 = 1; eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != 3); i4 = 1) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        VGroup vGroup2 = (VGroup) arrayDeque.peek();
                        i = depth;
                        if ("path".equals(name)) {
                            ?? vPath = new VPath();
                            vPath.mStrokeWidth = 0.0f;
                            vPath.mStrokeAlpha = 1.0f;
                            vPath.mFillAlpha = 1.0f;
                            vPath.mTrimPathStart = 0.0f;
                            vPath.mTrimPathEnd = 1.0f;
                            vPath.mTrimPathOffset = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            vPath.mStrokeLineCap = cap2;
                            Paint.Join join2 = Paint.Join.MITER;
                            vPath.mStrokeLineJoin = join2;
                            vPath.mStrokeMiterlimit = 4.0f;
                            TypedArray obtainAttributes2 = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                String string2 = obtainAttributes2.getString(0);
                                if (string2 != null) {
                                    vPath.mPathName = string2;
                                }
                                String string3 = obtainAttributes2.getString(2);
                                if (string3 != null) {
                                    vPath.mNodes = BundleKt.createNodesFromPathData(string3);
                                }
                                vPath.mFillColor = CamUtils.getNamedComplexColor(obtainAttributes2, xmlPullParser, theme, "fillColor", 1);
                                float f3 = vPath.mFillAlpha;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                    f3 = obtainAttributes2.getFloat(12, f3);
                                }
                                vPath.mFillAlpha = f3;
                                int i5 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? obtainAttributes2.getInt(8, -1) : -1;
                                Paint.Cap cap3 = vPath.mStrokeLineCap;
                                if (i5 == 0) {
                                    cap = cap2;
                                } else if (i5 != 1) {
                                    cap = i5 != 2 ? cap3 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                vPath.mStrokeLineCap = cap;
                                int i6 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? obtainAttributes2.getInt(9, -1) : -1;
                                Paint.Join join3 = vPath.mStrokeLineJoin;
                                if (i6 == 0) {
                                    join = join2;
                                } else if (i6 != 1) {
                                    join = i6 != 2 ? join3 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                vPath.mStrokeLineJoin = join;
                                float f4 = vPath.mStrokeMiterlimit;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                    f4 = obtainAttributes2.getFloat(10, f4);
                                }
                                vPath.mStrokeMiterlimit = f4;
                                vPath.mStrokeColor = CamUtils.getNamedComplexColor(obtainAttributes2, xmlPullParser, theme, "strokeColor", 3);
                                float f5 = vPath.mStrokeAlpha;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                    f5 = obtainAttributes2.getFloat(11, f5);
                                }
                                vPath.mStrokeAlpha = f5;
                                float f6 = vPath.mStrokeWidth;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                    f6 = obtainAttributes2.getFloat(4, f6);
                                }
                                vPath.mStrokeWidth = f6;
                                float f7 = vPath.mTrimPathEnd;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                    f7 = obtainAttributes2.getFloat(6, f7);
                                }
                                vPath.mTrimPathEnd = f7;
                                float f8 = vPath.mTrimPathOffset;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                    f8 = obtainAttributes2.getFloat(7, f8);
                                }
                                vPath.mTrimPathOffset = f8;
                                float f9 = vPath.mTrimPathStart;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                    f9 = obtainAttributes2.getFloat(5, f9);
                                }
                                vPath.mTrimPathStart = f9;
                                int i7 = vPath.mFillRule;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                    i7 = obtainAttributes2.getInt(13, i7);
                                }
                                vPath.mFillRule = i7;
                            }
                            obtainAttributes2.recycle();
                            vGroup2.mChildren.add(vPath);
                            if (vPath.getPathName() != null) {
                                arrayMap.put(vPath.getPathName(), vPath);
                            }
                            vectorDrawableCompatState3.mChangingConfigurations = vectorDrawableCompatState3.mChangingConfigurations;
                            z2 = false;
                        } else if ("clip-path".equals(name)) {
                            VPath vPath2 = new VPath();
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                TypedArray obtainAttributes3 = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                                String string4 = obtainAttributes3.getString(0);
                                if (string4 != null) {
                                    vPath2.mPathName = string4;
                                }
                                String string5 = obtainAttributes3.getString(1);
                                if (string5 != null) {
                                    vPath2.mNodes = BundleKt.createNodesFromPathData(string5);
                                }
                                vPath2.mFillRule = !CamUtils.hasAttribute(xmlPullParser, "fillType") ? 0 : obtainAttributes3.getInt(2, 0);
                                obtainAttributes3.recycle();
                            }
                            vGroup2.mChildren.add(vPath2);
                            if (vPath2.getPathName() != null) {
                                arrayMap.put(vPath2.getPathName(), vPath2);
                            }
                            vectorDrawableCompatState3.mChangingConfigurations = vectorDrawableCompatState3.mChangingConfigurations;
                        } else if ("group".equals(name)) {
                            VGroup vGroup3 = new VGroup();
                            TypedArray obtainAttributes4 = CamUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
                            float f10 = vGroup3.mRotate;
                            if (CamUtils.hasAttribute(xmlPullParser, "rotation")) {
                                f10 = obtainAttributes4.getFloat(5, f10);
                            }
                            vGroup3.mRotate = f10;
                            vGroup3.mPivotX = obtainAttributes4.getFloat(1, vGroup3.mPivotX);
                            vGroup3.mPivotY = obtainAttributes4.getFloat(2, vGroup3.mPivotY);
                            float f11 = vGroup3.mScaleX;
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                                f11 = obtainAttributes4.getFloat(3, f11);
                            }
                            vGroup3.mScaleX = f11;
                            float f12 = vGroup3.mScaleY;
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                                f12 = obtainAttributes4.getFloat(4, f12);
                            }
                            vGroup3.mScaleY = f12;
                            float f13 = vGroup3.mTranslateX;
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                f13 = obtainAttributes4.getFloat(6, f13);
                            }
                            vGroup3.mTranslateX = f13;
                            float f14 = vGroup3.mTranslateY;
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                f14 = obtainAttributes4.getFloat(7, f14);
                            }
                            vGroup3.mTranslateY = f14;
                            String string6 = obtainAttributes4.getString(0);
                            if (string6 != null) {
                                vGroup3.mGroupName = string6;
                            }
                            vGroup3.updateLocalMatrix();
                            obtainAttributes4.recycle();
                            vGroup2.mChildren.add(vGroup3);
                            arrayDeque.push(vGroup3);
                            if (vGroup3.getGroupName() != null) {
                                arrayMap.put(vGroup3.getGroupName(), vGroup3);
                            }
                            vectorDrawableCompatState3.mChangingConfigurations = vectorDrawableCompatState3.mChangingConfigurations;
                        }
                    } else {
                        i = depth;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    depth = i;
                }
                if (!z2) {
                    this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            } else {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    /* loaded from: classes.dex */
    public final class VGroup extends VObject {
        public final ArrayList mChildren;
        public String mGroupName;
        public final Matrix mLocalMatrix;
        public float mPivotX;
        public float mPivotY;
        public float mRotate;
        public float mScaleX;
        public float mScaleY;
        public final Matrix mStackedMatrix;
        public float mTranslateX;
        public float mTranslateY;

        public VGroup() {
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean isStateful() {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.mChildren;
                if (i >= arrayList.size()) {
                    return false;
                }
                if (((VObject) arrayList.get(i)).isStateful()) {
                    return true;
                }
                i++;
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public final boolean onStateChanged(int[] iArr) {
            int i = 0;
            boolean z = false;
            while (true) {
                ArrayList arrayList = this.mChildren;
                if (i >= arrayList.size()) {
                    return z;
                }
                z |= ((VObject) arrayList.get(i)).onStateChanged(iArr);
                i++;
            }
        }

        public void setPivotX(float f) {
            if (f != this.mPivotX) {
                this.mPivotX = f;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f) {
            if (f != this.mPivotY) {
                this.mPivotY = f;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f) {
            if (f != this.mRotate) {
                this.mRotate = f;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f) {
            if (f != this.mScaleX) {
                this.mScaleX = f;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f) {
            if (f != this.mScaleY) {
                this.mScaleY = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.mTranslateX) {
                this.mTranslateX = f;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.mTranslateY) {
                this.mTranslateY = f;
                updateLocalMatrix();
            }
        }

        public final void updateLocalMatrix() {
            Matrix matrix = this.mLocalMatrix;
            matrix.reset();
            matrix.postTranslate(-this.mPivotX, -this.mPivotY);
            matrix.postScale(this.mScaleX, this.mScaleY);
            matrix.postRotate(this.mRotate, 0.0f, 0.0f);
            matrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        /* JADX WARN: Type inference failed for: r4v5, types: [androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath, androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath] */
        public VGroup(VGroup vGroup, ArrayMap arrayMap) {
            VPath vPath;
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            Matrix matrix = new Matrix();
            this.mLocalMatrix = matrix;
            this.mGroupName = null;
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            String str = vGroup.mGroupName;
            this.mGroupName = str;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.mLocalMatrix);
            ArrayList arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    if (obj instanceof VFullPath) {
                        VFullPath vFullPath = (VFullPath) obj;
                        ?? vPath2 = new VPath(vFullPath);
                        vPath2.mStrokeWidth = 0.0f;
                        vPath2.mStrokeAlpha = 1.0f;
                        vPath2.mFillAlpha = 1.0f;
                        vPath2.mTrimPathStart = 0.0f;
                        vPath2.mTrimPathEnd = 1.0f;
                        vPath2.mTrimPathOffset = 0.0f;
                        vPath2.mStrokeLineCap = Paint.Cap.BUTT;
                        vPath2.mStrokeLineJoin = Paint.Join.MITER;
                        vPath2.mStrokeMiterlimit = 4.0f;
                        vPath2.mStrokeColor = vFullPath.mStrokeColor;
                        vPath2.mStrokeWidth = vFullPath.mStrokeWidth;
                        vPath2.mStrokeAlpha = vFullPath.mStrokeAlpha;
                        vPath2.mFillColor = vFullPath.mFillColor;
                        vPath2.mFillRule = vFullPath.mFillRule;
                        vPath2.mFillAlpha = vFullPath.mFillAlpha;
                        vPath2.mTrimPathStart = vFullPath.mTrimPathStart;
                        vPath2.mTrimPathEnd = vFullPath.mTrimPathEnd;
                        vPath2.mTrimPathOffset = vFullPath.mTrimPathOffset;
                        vPath2.mStrokeLineCap = vFullPath.mStrokeLineCap;
                        vPath2.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
                        vPath2.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
                        vPath = vPath2;
                    } else if (obj instanceof VClipPath) {
                        vPath = new VPath((VClipPath) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vPath);
                    Object obj2 = vPath.mPathName;
                    if (obj2 != null) {
                        arrayMap.put(obj2, vPath);
                    }
                }
            }
        }
    }

    public VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    /* loaded from: classes.dex */
    public final class VPathRenderer {
        public static final Matrix IDENTITY_MATRIX = new Matrix();
        public float mBaseHeight;
        public float mBaseWidth;
        public Paint mFillPaint;
        public final Matrix mFinalPathMatrix;
        public Boolean mIsStateful;
        public final Path mPath;
        public PathMeasure mPathMeasure;
        public final Path mRenderPath;
        public int mRootAlpha;
        public final VGroup mRootGroup;
        public String mRootName;
        public Paint mStrokePaint;
        public final ArrayMap mVGTargetsMap;
        public float mViewportHeight;
        public float mViewportWidth;

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.collection.SimpleArrayMap, androidx.collection.ArrayMap] */
        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new SimpleArrayMap(0);
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public final void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2) {
            int i3;
            float f;
            float f2;
            int i4;
            Path.FillType fillType;
            float f3;
            Path.FillType fillType2;
            Matrix matrix2 = vGroup.mStackedMatrix;
            ArrayList arrayList = vGroup.mChildren;
            matrix2.set(matrix);
            Matrix matrix3 = vGroup.mStackedMatrix;
            matrix3.preConcat(vGroup.mLocalMatrix);
            canvas.save();
            char c = 0;
            int i5 = 0;
            while (i5 < arrayList.size()) {
                VObject vObject = (VObject) arrayList.get(i5);
                if (vObject instanceof VGroup) {
                    drawGroupTree((VGroup) vObject, matrix3, canvas, i, i2);
                } else if (vObject instanceof VPath) {
                    VPath vPath = (VPath) vObject;
                    float f4 = i / this.mViewportWidth;
                    float f5 = i2 / this.mViewportHeight;
                    float min = Math.min(f4, f5);
                    Matrix matrix4 = this.mFinalPathMatrix;
                    matrix4.set(matrix3);
                    matrix4.postScale(f4, f5);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix3.mapVectors(fArr);
                    i3 = i5;
                    float f6 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot(fArr[c], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
                    if (max > 0.0f) {
                        f = Math.abs(f6) / max;
                    } else {
                        f = 0.0f;
                    }
                    if (f != 0.0f) {
                        Path path = this.mPath;
                        path.reset();
                        PathParser$PathDataNode[] pathParser$PathDataNodeArr = vPath.mNodes;
                        if (pathParser$PathDataNodeArr != null) {
                            PathParser$PathDataNode.nodesToPath(pathParser$PathDataNodeArr, path);
                        }
                        Path path2 = this.mRenderPath;
                        path2.reset();
                        if (vPath instanceof VClipPath) {
                            if (vPath.mFillRule == 0) {
                                fillType2 = Path.FillType.WINDING;
                            } else {
                                fillType2 = Path.FillType.EVEN_ODD;
                            }
                            path2.setFillType(fillType2);
                            path2.addPath(path, matrix4);
                            canvas.clipPath(path2);
                        } else {
                            VFullPath vFullPath = (VFullPath) vPath;
                            float f7 = vFullPath.mTrimPathStart;
                            if (!(f7 == 0.0f && vFullPath.mTrimPathEnd == 1.0f)) {
                                float f8 = vFullPath.mTrimPathOffset;
                                float f9 = (f7 + f8) % 1.0f;
                                float f10 = (vFullPath.mTrimPathEnd + f8) % 1.0f;
                                if (this.mPathMeasure == null) {
                                    this.mPathMeasure = new PathMeasure();
                                }
                                this.mPathMeasure.setPath(path, false);
                                float length = this.mPathMeasure.getLength();
                                float f11 = f9 * length;
                                float f12 = f10 * length;
                                path.reset();
                                if (f11 > f12) {
                                    this.mPathMeasure.getSegment(f11, length, path, true);
                                    f3 = 0.0f;
                                    this.mPathMeasure.getSegment(0.0f, f12, path, true);
                                } else {
                                    f3 = 0.0f;
                                    this.mPathMeasure.getSegment(f11, f12, path, true);
                                }
                                path.rLineTo(f3, f3);
                            }
                            path2.addPath(path, matrix4);
                            HuffmanTreeGroup huffmanTreeGroup = vFullPath.mFillColor;
                            if (((Shader) huffmanTreeGroup.codes) == null && huffmanTreeGroup.alphabetSize == 0) {
                                i4 = 16777215;
                                f2 = 255.0f;
                            } else {
                                if (this.mFillPaint == null) {
                                    i4 = 16777215;
                                    Paint paint = new Paint(1);
                                    this.mFillPaint = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                } else {
                                    i4 = 16777215;
                                }
                                Paint paint2 = this.mFillPaint;
                                Shader shader = (Shader) huffmanTreeGroup.codes;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix4);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(vFullPath.mFillAlpha * 255.0f));
                                    f2 = 255.0f;
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i6 = huffmanTreeGroup.alphabetSize;
                                    float f13 = vFullPath.mFillAlpha;
                                    PorterDuff.Mode mode = VectorDrawableCompat.DEFAULT_TINT_MODE;
                                    f2 = 255.0f;
                                    paint2.setColor((i6 & i4) | (((int) (Color.alpha(i6) * f13)) << 24));
                                }
                                paint2.setColorFilter(null);
                                if (vFullPath.mFillRule == 0) {
                                    fillType = Path.FillType.WINDING;
                                } else {
                                    fillType = Path.FillType.EVEN_ODD;
                                }
                                path2.setFillType(fillType);
                                canvas.drawPath(path2, paint2);
                            }
                            HuffmanTreeGroup huffmanTreeGroup2 = vFullPath.mStrokeColor;
                            if (((Shader) huffmanTreeGroup2.codes) != null || huffmanTreeGroup2.alphabetSize != 0) {
                                if (this.mStrokePaint == null) {
                                    Paint paint3 = new Paint(1);
                                    this.mStrokePaint = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = this.mStrokePaint;
                                Paint.Join join = vFullPath.mStrokeLineJoin;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = vFullPath.mStrokeLineCap;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                                Shader shader2 = (Shader) huffmanTreeGroup2.codes;
                                if (shader2 != null) {
                                    shader2.setLocalMatrix(matrix4);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(vFullPath.mStrokeAlpha * f2));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i7 = huffmanTreeGroup2.alphabetSize;
                                    float f14 = vFullPath.mStrokeAlpha;
                                    PorterDuff.Mode mode2 = VectorDrawableCompat.DEFAULT_TINT_MODE;
                                    paint4.setColor((i7 & i4) | (((int) (Color.alpha(i7) * f14)) << 24));
                                }
                                paint4.setColorFilter(null);
                                paint4.setStrokeWidth(vFullPath.mStrokeWidth * min * f);
                                canvas.drawPath(path2, paint4);
                            }
                        }
                    }
                    i5 = i3 + 1;
                    c = 0;
                }
                i3 = i5;
                i5 = i3 + 1;
                c = 0;
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.collection.SimpleArrayMap, androidx.collection.ArrayMap] */
        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            ?? simpleArrayMap = new SimpleArrayMap(0);
            this.mVGTargetsMap = simpleArrayMap;
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, simpleArrayMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            String str = vPathRenderer.mRootName;
            if (str != null) {
                simpleArrayMap.put(str, this);
            }
            this.mIsStateful = vPathRenderer.mIsStateful;
        }
    }
}
