package com.google.android.material.tooltip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
/* loaded from: classes.dex */
public final class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    public int arrowSize;
    public final Context context;
    public int layoutMargin;
    public int locationOnScreenX;
    public int minHeight;
    public int minWidth;
    public int padding;
    public boolean showMarker;
    public CharSequence text;
    public final TextDrawableHelper textDrawableHelper;
    public final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    public final SearchView.AnonymousClass4 attachedViewLayoutChangeListener = new SearchView.AnonymousClass4(2, this);
    public final Rect displayFrame = new Rect();
    public float tooltipScaleX = 1.0f;
    public float tooltipScaleY = 1.0f;
    public float tooltipPivotX = 0.5f;
    public float tooltipPivotY = 0.5f;
    public float labelOpacity = 1.0f;

    public TooltipDrawable(Context context, int i) {
        super(context, null, 0, i);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        this.context = context;
        float f = context.getResources().getDisplayMetrics().density;
        TextPaint textPaint = textDrawableHelper.textPaint;
        textPaint.density = f;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public final float calculatePointerOffset() {
        int i;
        Rect rect = this.displayFrame;
        if (((rect.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin < 0) {
            i = ((rect.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
        } else if (((rect.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin <= 0) {
            return 0.0f;
        } else {
            i = ((rect.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        }
        return i;
    }

    public final OffsetEdgeTreatment createMarkerEdge() {
        float width = (float) ((getBounds().width() - (Math.sqrt(2.0d) * this.arrowSize)) / 2.0d);
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.arrowSize), Math.min(Math.max(-calculatePointerOffset(), -width), width));
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        float calculatePointerOffset = calculatePointerOffset();
        double sqrt = Math.sqrt(2.0d);
        canvas.scale(this.tooltipScaleX, this.tooltipScaleY, (getBounds().width() * this.tooltipPivotX) + getBounds().left, (getBounds().height() * this.tooltipPivotY) + getBounds().top);
        canvas.translate(calculatePointerOffset, (float) (-((sqrt * this.arrowSize) - this.arrowSize)));
        super.draw(canvas);
        if (this.text == null) {
            canvas2 = canvas;
        } else {
            Rect bounds = getBounds();
            TextDrawableHelper textDrawableHelper = this.textDrawableHelper;
            TextPaint textPaint = textDrawableHelper.textPaint;
            Paint.FontMetrics fontMetrics = this.fontMetrics;
            textPaint.getFontMetrics(fontMetrics);
            int centerY = (int) (bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            if (textDrawableHelper.textAppearance != null) {
                textPaint.drawableState = getState();
                textDrawableHelper.textAppearance.updateDrawState(this.context, textDrawableHelper.textPaint, textDrawableHelper.fontCallback);
                textPaint.setAlpha((int) (this.labelOpacity * 255.0f));
            }
            CharSequence charSequence = this.text;
            canvas2 = canvas;
            canvas2.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), centerY, textPaint);
        }
        canvas2.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.textDrawableHelper.textPaint.getTextSize(), this.minHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f;
        float f2 = this.padding * 2;
        CharSequence charSequence = this.text;
        if (charSequence == null) {
            f = 0.0f;
        } else {
            f = this.textDrawableHelper.getTextWidth(charSequence.toString());
        }
        return (int) Math.max(f2 + f, this.minWidth);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.showMarker) {
            ShapeAppearanceModel.Builder builder = this.drawableState.shapeAppearanceModel.toBuilder();
            builder.bottomEdge = createMarkerEdge();
            setShapeAppearanceModel(builder.build());
        }
    }
}
