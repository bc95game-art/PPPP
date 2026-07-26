package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.transition.ViewUtilsApi21;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapePath;
import java.util.ArrayList;
import java.util.BitSet;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class ShapeAppearancePathProvider {
    public final ShapePath[] cornerPaths = new ShapePath[4];
    public final Matrix[] cornerTransforms = new Matrix[4];
    public final Matrix[] edgeTransforms = new Matrix[4];
    public final PointF pointF = new PointF();
    public final Path overlappedEdgePath = new Path();
    public final Path boundsPath = new Path();
    public final ShapePath shapePath = new ShapePath();
    public final float[] scratch = new float[2];
    public final float[] scratch2 = new float[2];
    public final Path edgePath = new Path();
    public final Path cornerPath = new Path();
    public final boolean edgeIntersectionCheckEnabled = true;

    /* loaded from: classes.dex */
    public abstract class Lazy {
        public static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();
    }

    public ShapeAppearancePathProvider() {
        for (int i = 0; i < 4; i++) {
            this.cornerPaths[i] = new ShapePath();
            this.cornerTransforms[i] = new Matrix();
            this.edgeTransforms[i] = new Matrix();
        }
    }

    public final void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float[] fArr, float f, RectF rectF, MaterialShapeDrawable.C01961 r27, Path path) {
        Matrix[] matrixArr;
        float[] fArr2;
        int i;
        ShapePath[] shapePathArr;
        char c;
        Matrix[] matrixArr2;
        float f2;
        ViewUtilsApi21 viewUtilsApi21;
        CornerSize cornerSize;
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt;
        int i2;
        path.rewind();
        Path path2 = this.overlappedEdgePath;
        path2.rewind();
        Path path3 = this.boundsPath;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i3 = 0;
        while (true) {
            matrixArr = this.edgeTransforms;
            fArr2 = this.scratch;
            i = 4;
            shapePathArr = this.cornerPaths;
            c = 0;
            matrixArr2 = this.cornerTransforms;
            if (i3 >= 4) {
                break;
            }
            if (fArr != null) {
                cornerSize = new ClampedCornerSize(fArr[i3]);
            } else if (i3 == 1) {
                cornerSize = shapeAppearanceModel.bottomRightCornerSize;
            } else if (i3 == 2) {
                cornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            } else if (i3 != 3) {
                cornerSize = shapeAppearanceModel.topRightCornerSize;
            } else {
                cornerSize = shapeAppearanceModel.topLeftCornerSize;
            }
            if (i3 == 1) {
                lazyKt__LazyJVMKt = shapeAppearanceModel.bottomRightCorner;
            } else if (i3 == 2) {
                lazyKt__LazyJVMKt = shapeAppearanceModel.bottomLeftCorner;
            } else if (i3 != 3) {
                lazyKt__LazyJVMKt = shapeAppearanceModel.topRightCorner;
            } else {
                lazyKt__LazyJVMKt = shapeAppearanceModel.topLeftCorner;
            }
            ShapePath shapePath = shapePathArr[i3];
            lazyKt__LazyJVMKt.getClass();
            lazyKt__LazyJVMKt.getCornerPath(shapePath, f, cornerSize.getCornerSize(rectF));
            int i4 = i3 + 1;
            float f3 = (i4 % 4) * 90;
            matrixArr2[i3].reset();
            PointF pointF = this.pointF;
            if (i3 == 1) {
                i2 = i3;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i3 == 2) {
                i2 = i3;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i3 != 3) {
                i2 = i3;
                pointF.set(rectF.right, rectF.top);
            } else {
                i2 = i3;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i2].setTranslate(pointF.x, pointF.y);
            matrixArr2[i2].preRotate(f3);
            ShapePath shapePath2 = shapePathArr[i2];
            fArr2[0] = shapePath2.endX;
            fArr2[1] = shapePath2.endY;
            matrixArr2[i2].mapPoints(fArr2);
            matrixArr[i2].reset();
            matrixArr[i2].setTranslate(fArr2[0], fArr2[1]);
            matrixArr[i2].preRotate(f3);
            i3 = i4;
        }
        char c2 = 1;
        int i5 = 0;
        while (i5 < i) {
            ShapePath shapePath3 = shapePathArr[i5];
            fArr2[c] = shapePath3.startX;
            fArr2[c2] = shapePath3.startY;
            matrixArr2[i5].mapPoints(fArr2);
            if (i5 == 0) {
                path.moveTo(fArr2[c], fArr2[c2]);
            } else {
                path.lineTo(fArr2[c], fArr2[c2]);
            }
            shapePathArr[i5].applyToPath(matrixArr2[i5], path);
            if (r27 != null) {
                ShapePath shapePath4 = shapePathArr[i5];
                Matrix matrix = matrixArr2[i5];
                MaterialShapeDrawable materialShapeDrawable = MaterialShapeDrawable.this;
                BitSet bitSet = materialShapeDrawable.containsIncompatibleShadowOp;
                shapePath4.getClass();
                bitSet.set(i5, false);
                ShapePath.ShadowCompatOperation[] shadowCompatOperationArr = materialShapeDrawable.cornerShadowOperation;
                shapePath4.addConnectingShadowIfNecessary(shapePath4.endShadowAngle);
                final Matrix matrix2 = new Matrix(matrix);
                final ArrayList arrayList = new ArrayList(shapePath4.shadowCompatOperations);
                shadowCompatOperationArr[i5] = new ShapePath.ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
                    @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                    public final void draw(Matrix matrix3, ShadowRenderer shadowRenderer, int i6, Canvas canvas) {
                        ArrayList arrayList2 = arrayList;
                        int size = arrayList2.size();
                        int i7 = 0;
                        while (i7 < size) {
                            Object obj = arrayList2.get(i7);
                            i7++;
                            ((ShadowCompatOperation) obj).draw(matrix2, shadowRenderer, i6, canvas);
                        }
                    }
                };
            }
            int i6 = i5 + 1;
            int i7 = i6 % 4;
            ShapePath shapePath5 = shapePathArr[i5];
            fArr2[0] = shapePath5.endX;
            fArr2[1] = shapePath5.endY;
            matrixArr2[i5].mapPoints(fArr2);
            ShapePath shapePath6 = shapePathArr[i7];
            float f4 = shapePath6.startX;
            float[] fArr3 = this.scratch2;
            fArr3[0] = f4;
            fArr3[1] = shapePath6.startY;
            matrixArr2[i7].mapPoints(fArr3);
            ShapePath[] shapePathArr2 = shapePathArr;
            float max = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, 0.0f);
            ShapePath shapePath7 = shapePathArr2[i5];
            fArr2[0] = shapePath7.endX;
            fArr2[1] = shapePath7.endY;
            matrixArr2[i5].mapPoints(fArr2);
            if (i5 == 1 || i5 == 3) {
                f2 = Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                f2 = Math.abs(rectF.centerY() - fArr2[1]);
            }
            ShapePath shapePath8 = this.shapePath;
            shapePath8.reset(0.0f, 0.0f, 270.0f, 0.0f);
            if (i5 == 1) {
                viewUtilsApi21 = shapeAppearanceModel.bottomEdge;
            } else if (i5 == 2) {
                viewUtilsApi21 = shapeAppearanceModel.leftEdge;
            } else if (i5 != 3) {
                viewUtilsApi21 = shapeAppearanceModel.rightEdge;
            } else {
                viewUtilsApi21 = shapeAppearanceModel.topEdge;
            }
            viewUtilsApi21.getEdgePath(max, f2, f, shapePath8);
            Path path4 = this.edgePath;
            path4.reset();
            shapePath8.applyToPath(matrixArr[i5], path4);
            if (!this.edgeIntersectionCheckEnabled || (!viewUtilsApi21.forceIntersection() && !pathOverlapsCorner(path4, i5) && !pathOverlapsCorner(path4, i7))) {
                c2 = 1;
                shapePath8.applyToPath(matrixArr[i5], path);
            } else {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = shapePath8.startX;
                c2 = 1;
                fArr2[1] = shapePath8.startY;
                matrixArr[i5].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                shapePath8.applyToPath(matrixArr[i5], path2);
            }
            if (r27 != null) {
                Matrix matrix3 = matrixArr[i5];
                MaterialShapeDrawable materialShapeDrawable2 = MaterialShapeDrawable.this;
                materialShapeDrawable2.containsIncompatibleShadowOp.set(i5 + 4, false);
                ShapePath.ShadowCompatOperation[] shadowCompatOperationArr2 = materialShapeDrawable2.edgeShadowOperation;
                shapePath8.addConnectingShadowIfNecessary(shapePath8.endShadowAngle);
                final Matrix matrix4 = new Matrix(matrix3);
                final ArrayList arrayList2 = new ArrayList(shapePath8.shadowCompatOperations);
                shadowCompatOperationArr2[i5] = new ShapePath.ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
                    @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                    public final void draw(Matrix matrix32, ShadowRenderer shadowRenderer, int i62, Canvas canvas) {
                        ArrayList arrayList22 = arrayList2;
                        int size = arrayList22.size();
                        int i72 = 0;
                        while (i72 < size) {
                            Object obj = arrayList22.get(i72);
                            i72++;
                            ((ShadowCompatOperation) obj).draw(matrix4, shadowRenderer, i62, canvas);
                        }
                    }
                };
            }
            i5 = i6;
            shapePathArr = shapePathArr2;
            i = 4;
            c = 0;
        }
        path.close();
        path2.close();
        if (!path2.isEmpty()) {
            path.op(path2, Path.Op.UNION);
        }
    }

    public final boolean pathOverlapsCorner(Path path, int i) {
        Path path2 = this.cornerPath;
        path2.reset();
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f)) {
            return true;
        }
        return false;
    }
}
