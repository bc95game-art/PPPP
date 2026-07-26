package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.transition.ViewUtilsApi21;
import com.google.android.material.R$styleable;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class ShapeAppearanceModel {
    public static final RelativeCornerSize PILL = new RelativeCornerSize(0.5f);
    public LazyKt__LazyJVMKt topLeftCorner = new Object();
    public LazyKt__LazyJVMKt topRightCorner = new Object();
    public LazyKt__LazyJVMKt bottomRightCorner = new Object();
    public LazyKt__LazyJVMKt bottomLeftCorner = new Object();
    public CornerSize topLeftCornerSize = new AbsoluteCornerSize(0.0f);
    public CornerSize topRightCornerSize = new AbsoluteCornerSize(0.0f);
    public CornerSize bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
    public CornerSize bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
    public ViewUtilsApi21 topEdge = new Object();
    public ViewUtilsApi21 rightEdge = new Object();
    public ViewUtilsApi21 bottomEdge = new Object();
    public ViewUtilsApi21 leftEdge = new Object();

    /* loaded from: classes.dex */
    public final class Builder {
        public LazyKt__LazyJVMKt topLeftCorner = new Object();
        public LazyKt__LazyJVMKt topRightCorner = new Object();
        public LazyKt__LazyJVMKt bottomRightCorner = new Object();
        public LazyKt__LazyJVMKt bottomLeftCorner = new Object();
        public CornerSize topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        public CornerSize topRightCornerSize = new AbsoluteCornerSize(0.0f);
        public CornerSize bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        public CornerSize bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        public ViewUtilsApi21 topEdge = new Object();
        public ViewUtilsApi21 rightEdge = new Object();
        public ViewUtilsApi21 bottomEdge = new Object();
        public ViewUtilsApi21 leftEdge = new Object();

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.material.shape.ShapeAppearanceModel] */
        public final ShapeAppearanceModel build() {
            ?? obj = new Object();
            obj.topLeftCorner = this.topLeftCorner;
            obj.topRightCorner = this.topRightCorner;
            obj.bottomRightCorner = this.bottomRightCorner;
            obj.bottomLeftCorner = this.bottomLeftCorner;
            obj.topLeftCornerSize = this.topLeftCornerSize;
            obj.topRightCornerSize = this.topRightCornerSize;
            obj.bottomRightCornerSize = this.bottomRightCornerSize;
            obj.bottomLeftCornerSize = this.bottomLeftCornerSize;
            obj.topEdge = this.topEdge;
            obj.rightEdge = this.rightEdge;
            obj.bottomEdge = this.bottomEdge;
            obj.leftEdge = this.leftEdge;
            return obj;
        }

        public final void setAllCornerSizes(float f) {
            this.topLeftCornerSize = new AbsoluteCornerSize(f);
            this.topRightCornerSize = new AbsoluteCornerSize(f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(f);
        }
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2) {
        AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, absoluteCornerSize);
    }

    public static CornerSize getCornerSize(TypedArray typedArray, int i, CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue != null) {
            int i2 = peekValue.type;
            if (i2 == 5) {
                return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cornerSize;
    }

    public final boolean hasRoundedCorners() {
        if (!(this.topRightCorner instanceof RoundedCornerTreatment) || !(this.topLeftCorner instanceof RoundedCornerTreatment) || !(this.bottomRightCorner instanceof RoundedCornerTreatment) || !(this.bottomLeftCorner instanceof RoundedCornerTreatment)) {
            return false;
        }
        return true;
    }

    public final boolean isRoundRect(RectF rectF) {
        boolean z;
        boolean z2;
        if (!this.leftEdge.getClass().equals(ViewUtilsApi21.class) || !this.rightEdge.getClass().equals(ViewUtilsApi21.class) || !this.topEdge.getClass().equals(ViewUtilsApi21.class) || !this.bottomEdge.getClass().equals(ViewUtilsApi21.class)) {
            z = false;
        } else {
            z = true;
        }
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        if (this.topRightCornerSize.getCornerSize(rectF) == cornerSize && this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize && this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2 || !hasRoundedCorners()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.material.shape.ShapeAppearanceModel$Builder] */
    public final Builder toBuilder() {
        ?? obj = new Object();
        obj.topLeftCorner = this.topLeftCorner;
        obj.topRightCorner = this.topRightCorner;
        obj.bottomRightCorner = this.bottomRightCorner;
        obj.bottomLeftCorner = this.bottomLeftCorner;
        obj.topLeftCornerSize = this.topLeftCornerSize;
        obj.topRightCornerSize = this.topRightCornerSize;
        obj.bottomRightCornerSize = this.bottomRightCornerSize;
        obj.bottomLeftCornerSize = this.bottomLeftCornerSize;
        obj.topEdge = this.topEdge;
        obj.rightEdge = this.rightEdge;
        obj.bottomEdge = this.bottomEdge;
        obj.leftEdge = this.leftEdge;
        return obj;
    }

    public final String toString() {
        return "[" + this.topLeftCornerSize + ", " + this.topRightCornerSize + ", " + this.bottomRightCornerSize + ", " + this.bottomLeftCornerSize + "]";
    }

    public static Builder builder(Context context, int i, int i2) {
        return builder(context, i, i2, new AbsoluteCornerSize(0));
    }

    public static Builder builder(Context context, int i, int i2, CornerSize cornerSize) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i2, true);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(0, 0);
            int i4 = obtainStyledAttributes.getInt(3, i3);
            int i5 = obtainStyledAttributes.getInt(4, i3);
            int i6 = obtainStyledAttributes.getInt(2, i3);
            int i7 = obtainStyledAttributes.getInt(1, i3);
            CornerSize cornerSize2 = getCornerSize(obtainStyledAttributes, 5, cornerSize);
            CornerSize cornerSize3 = getCornerSize(obtainStyledAttributes, 8, cornerSize2);
            CornerSize cornerSize4 = getCornerSize(obtainStyledAttributes, 9, cornerSize2);
            CornerSize cornerSize5 = getCornerSize(obtainStyledAttributes, 7, cornerSize2);
            CornerSize cornerSize6 = getCornerSize(obtainStyledAttributes, 6, cornerSize2);
            Builder builder = new Builder();
            builder.topLeftCorner = LazyKt__LazyJVMKt.createCornerTreatment(i4);
            builder.topLeftCornerSize = cornerSize3;
            builder.topRightCorner = LazyKt__LazyJVMKt.createCornerTreatment(i5);
            builder.topRightCornerSize = cornerSize4;
            builder.bottomRightCorner = LazyKt__LazyJVMKt.createCornerTreatment(i6);
            builder.bottomRightCornerSize = cornerSize5;
            builder.bottomLeftCorner = LazyKt__LazyJVMKt.createCornerTreatment(i7);
            builder.bottomLeftCornerSize = cornerSize6;
            return builder;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
