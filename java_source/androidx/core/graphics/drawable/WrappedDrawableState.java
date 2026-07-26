package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public final class WrappedDrawableState extends Drawable.ConstantState {
    public int mChangingConfigurations;
    public Drawable.ConstantState mDrawableState;
    public ColorStateList mTint;
    public PorterDuff.Mode mTintMode;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        int i;
        int i2 = this.mChangingConfigurations;
        Drawable.ConstantState constantState = this.mDrawableState;
        if (constantState != null) {
            i = constantState.getChangingConfigurations();
        } else {
            i = 0;
        }
        return i2 | i;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return newDrawable(null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.core.graphics.drawable.WrappedDrawableApi21, android.graphics.drawable.Drawable] */
    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        ?? drawable = new Drawable();
        drawable.mState = this;
        Drawable.ConstantState constantState = this.mDrawableState;
        if (constantState != null) {
            drawable.setWrappedDrawable(constantState.newDrawable(resources));
        }
        WrappedDrawableApi21.findAndCacheIsProjectedDrawableMethod();
        return drawable;
    }
}
