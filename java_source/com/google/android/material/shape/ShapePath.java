package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ShapePath {
    public float currentShadowAngle;
    public float endShadowAngle;
    public float endX;
    public float endY;
    public final ArrayList operations = new ArrayList();
    public final ArrayList shadowCompatOperations = new ArrayList();
    public float startX;
    public float startY;

    /* loaded from: classes.dex */
    public final class ArcShadowOperation extends ShadowCompatOperation {
        public final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public final void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            boolean z;
            char c;
            PathArcOperation pathArcOperation = this.operation;
            float f = pathArcOperation.startAngle;
            float f2 = pathArcOperation.sweepAngle;
            RectF rectF = new RectF(pathArcOperation.left, pathArcOperation.top, pathArcOperation.right, pathArcOperation.bottom);
            Paint paint = shadowRenderer.cornerShadowPaint;
            if (f2 < 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Path path = shadowRenderer.scratch;
            int[] iArr = ShadowRenderer.cornerColors;
            if (z) {
                iArr[0] = 0;
                iArr[1] = shadowRenderer.shadowEndColor;
                iArr[2] = shadowRenderer.shadowMiddleColor;
                iArr[3] = shadowRenderer.shadowStartColor;
                c = 1;
            } else {
                path.rewind();
                c = 1;
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = -i;
                rectF.inset(f3, f3);
                iArr[0] = 0;
                iArr[1] = shadowRenderer.shadowStartColor;
                iArr[2] = shadowRenderer.shadowMiddleColor;
                iArr[3] = shadowRenderer.shadowEndColor;
            }
            float width = rectF.width() / 2.0f;
            if (width > 0.0f) {
                float f4 = 1.0f - (i / width);
                float[] fArr = ShadowRenderer.cornerPositions;
                fArr[c] = f4;
                fArr[2] = ((1.0f - f4) / 2.0f) + f4;
                paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP));
                canvas.save();
                canvas.concat(matrix);
                canvas.scale(1.0f, rectF.height() / rectF.width());
                if (!z) {
                    canvas.clipPath(path, Region.Op.DIFFERENCE);
                    canvas.drawPath(path, shadowRenderer.transparentPaint);
                }
                canvas.drawArc(rectF, f, f2, true, paint);
                canvas.restore();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class LineShadowOperation extends ShadowCompatOperation {
        public final PathLineOperation operation;
        public final float startX;
        public final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f, float f2) {
            this.operation = pathLineOperation;
            this.startX = f;
            this.startY = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public final void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            PathLineOperation pathLineOperation = this.operation;
            float f = pathLineOperation.f37y;
            float f2 = this.startY;
            float f3 = pathLineOperation.f36x;
            float f4 = this.startX;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f2, f3 - f4), 0.0f);
            Matrix matrix2 = this.renderMatrix;
            matrix2.set(matrix);
            matrix2.preTranslate(f4, f2);
            matrix2.preRotate(getAngle());
            shadowRenderer.getClass();
            rectF.bottom += i;
            rectF.offset(0.0f, -i);
            int i2 = shadowRenderer.shadowEndColor;
            int[] iArr = ShadowRenderer.edgeColors;
            iArr[0] = i2;
            iArr[1] = shadowRenderer.shadowMiddleColor;
            iArr[2] = shadowRenderer.shadowStartColor;
            Paint paint = shadowRenderer.edgeShadowPaint;
            float f5 = rectF.left;
            paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, ShadowRenderer.edgePositions, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, paint);
            canvas.restore();
        }

        public final float getAngle() {
            PathLineOperation pathLineOperation = this.operation;
            return (float) Math.toDegrees(Math.atan((pathLineOperation.f37y - this.startY) / (pathLineOperation.f36x - this.startX)));
        }
    }

    /* loaded from: classes.dex */
    public final class PathArcOperation extends PathOperation {
        public static final RectF rectF = new RectF();
        public final float bottom;
        public final float left;
        public final float right;
        public float startAngle;
        public float sweepAngle;
        public final float top;

        public PathArcOperation(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public final void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            float f = this.right;
            float f2 = this.bottom;
            RectF rectF2 = rectF;
            rectF2.set(this.left, this.top, f, f2);
            path.arcTo(rectF2, this.startAngle, this.sweepAngle, false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public final class PathLineOperation extends PathOperation {

        /* renamed from: x */
        public float f36x;

        /* renamed from: y */
        public float f37y;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public final void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f36x, this.f37y);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public abstract class PathOperation {
        public final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* loaded from: classes.dex */
    public abstract class ShadowCompatOperation {
        public static final Matrix IDENTITY_MATRIX = new Matrix();
        public final Matrix renderMatrix = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas);
    }

    public ShapePath() {
        reset(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void addConnectingShadowIfNecessary(float f) {
        float f2 = this.currentShadowAngle;
        if (f2 != f) {
            float f3 = ((f - f2) + 360.0f) % 360.0f;
            if (f3 <= 180.0f) {
                float f4 = this.endX;
                float f5 = this.endY;
                PathArcOperation pathArcOperation = new PathArcOperation(f4, f5, f4, f5);
                pathArcOperation.startAngle = this.currentShadowAngle;
                pathArcOperation.sweepAngle = f3;
                this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
                this.currentShadowAngle = f;
            }
        }
    }

    public final void applyToPath(Matrix matrix, Path path) {
        ArrayList arrayList = this.operations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((PathOperation) arrayList.get(i)).applyToPath(matrix, path);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.material.shape.ShapePath$PathOperation, com.google.android.material.shape.ShapePath$PathLineOperation, java.lang.Object] */
    public final void lineTo(float f, float f2) {
        ?? pathOperation = new PathOperation();
        pathOperation.f36x = f;
        pathOperation.f37y = f2;
        this.operations.add(pathOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathOperation, this.endX, this.endY);
        addConnectingShadowIfNecessary(lineShadowOperation.getAngle() + 270.0f);
        this.shadowCompatOperations.add(lineShadowOperation);
        this.currentShadowAngle = lineShadowOperation.getAngle() + 270.0f;
        this.endX = f;
        this.endY = f2;
    }

    public final void reset(float f, float f2, float f3, float f4) {
        this.startX = f;
        this.startY = f2;
        this.endX = f;
        this.endY = f2;
        this.currentShadowAngle = f3;
        this.endShadowAngle = (f3 + f4) % 360.0f;
        this.operations.clear();
        this.shadowCompatOperations.clear();
    }
}
