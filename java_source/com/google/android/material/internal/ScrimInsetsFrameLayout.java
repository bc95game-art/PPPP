package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public abstract class ScrimInsetsFrameLayout extends FrameLayout {
    public boolean drawBottomInsetForeground;
    public boolean drawLeftInsetForeground;
    public boolean drawRightInsetForeground;
    public boolean drawTopInsetForeground;
    public Drawable insetForeground;
    public Rect insets;
    public Rect tempRect;

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect = this.tempRect;
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.insets != null && this.insetForeground != null) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.drawTopInsetForeground) {
                rect.set(0, 0, width, this.insets.top);
                this.insetForeground.setBounds(rect);
                this.insetForeground.draw(canvas);
            }
            if (this.drawBottomInsetForeground) {
                rect.set(0, height - this.insets.bottom, width, height);
                this.insetForeground.setBounds(rect);
                this.insetForeground.draw(canvas);
            }
            if (this.drawLeftInsetForeground) {
                Rect rect2 = this.insets;
                rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
                this.insetForeground.setBounds(rect);
                this.insetForeground.draw(canvas);
            }
            if (this.drawRightInsetForeground) {
                Rect rect3 = this.insets;
                rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
                this.insetForeground.setBounds(rect);
                this.insetForeground.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.insetForeground;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.drawBottomInsetForeground = z;
    }

    public void setDrawLeftInsetForeground(boolean z) {
        this.drawLeftInsetForeground = z;
    }

    public void setDrawRightInsetForeground(boolean z) {
        this.drawRightInsetForeground = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.drawTopInsetForeground = z;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.insetForeground = drawable;
    }
}
