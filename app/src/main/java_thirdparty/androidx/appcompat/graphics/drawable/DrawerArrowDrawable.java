package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$styleable;
import androidx.core.os.BundleKt;
import com.emanuelef.remote_capture.R;
/* loaded from: classes.dex */
public final class DrawerArrowDrawable extends Drawable {
    public static final float ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    public final float mArrowHeadLength;
    public final float mArrowShaftLength;
    public final float mBarGap;
    public final float mBarLength;
    public final float mMaxCutForBarSize;
    public final Paint mPaint;
    public float mProgress;
    public final int mSize;
    public final boolean mSpin;
    public final Path mPath = new Path();
    public boolean mVerticalMirror = false;
    public final int mDirection = 2;

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, 2132082915);
        int color = obtainStyledAttributes.getColor(3, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(7, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.mMaxCutForBarSize = (float) (Math.cos(ARROW_HEAD_ANGLE) * (dimension / 2.0f));
            invalidateSelf();
        }
        boolean z = obtainStyledAttributes.getBoolean(6, true);
        if (this.mSpin != z) {
            this.mSpin = z;
            invalidateSelf();
        }
        float round = Math.round(obtainStyledAttributes.getDimension(5, 0.0f));
        if (round != this.mBarGap) {
            this.mBarGap = round;
            invalidateSelf();
        }
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.mBarLength = Math.round(obtainStyledAttributes.getDimension(2, 0.0f));
        this.mArrowHeadLength = Math.round(obtainStyledAttributes.getDimension(0, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float lerp(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f;
        float f2;
        int i;
        Rect bounds = getBounds();
        boolean z = false;
        int i2 = this.mDirection;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? BundleKt.getLayoutDirection(this) == 0 : BundleKt.getLayoutDirection(this) == 1))) {
            z = true;
        }
        float f3 = this.mArrowHeadLength;
        float sqrt = (float) Math.sqrt(f3 * f3 * 2.0f);
        float f4 = this.mProgress;
        float f5 = this.mBarLength;
        float lerp = lerp(f5, sqrt, f4);
        float lerp2 = lerp(f5, this.mArrowShaftLength, this.mProgress);
        float round = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float lerp3 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (z) {
            f = 0.0f;
        } else {
            f = -180.0f;
        }
        if (z) {
            f2 = 180.0f;
        } else {
            f2 = 0.0f;
        }
        float lerp4 = lerp(f, f2, this.mProgress);
        double d = lerp;
        double d2 = lerp3;
        float round2 = (float) Math.round(Math.cos(d2) * d);
        float round3 = (float) Math.round(Math.sin(d2) * d);
        Path path = this.mPath;
        path.rewind();
        float f6 = this.mBarGap;
        Paint paint = this.mPaint;
        float lerp5 = lerp(f6 + paint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float f7 = (-lerp2) / 2.0f;
        path.moveTo(f7 + round, 0.0f);
        path.rLineTo(lerp2 - (round * 2.0f), 0.0f);
        path.moveTo(f7, lerp5);
        path.rLineTo(round2, round3);
        path.moveTo(f7, -lerp5);
        path.rLineTo(round2, -round3);
        path.close();
        canvas.save();
        float strokeWidth = paint.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        float f8 = this.mBarGap;
        canvas.translate(bounds.centerX(), (strokeWidth * 1.5f) + f8 + ((((int) (height - (f8 * 2.0f))) / 4) * 2));
        if (this.mSpin) {
            if (this.mVerticalMirror ^ z) {
                i = -1;
            } else {
                i = 1;
            }
            canvas.rotate(lerp4 * i);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Paint paint = this.mPaint;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f) {
        if (this.mProgress != f) {
            this.mProgress = f;
            invalidateSelf();
        }
    }
}
