package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.navigation.internal.NavDestinationImpl;
import com.android.billingclient.api.zzca;
/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView {
    public final NavDestinationImpl mBackgroundTintHelper;
    public boolean mHasLevel = false;
    public final zzca mImageHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintContextWrapper.wrap(context);
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        NavDestinationImpl navDestinationImpl = new NavDestinationImpl(this);
        this.mBackgroundTintHelper = navDestinationImpl;
        navDestinationImpl.loadFromAttributes(attributeSet, i);
        zzca zzcaVar = new zzca(this);
        this.mImageHelper = zzcaVar;
        zzcaVar.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.applySupportBackgroundTint();
        }
        zzca zzcaVar = this.mImageHelper;
        if (zzcaVar != null) {
            zzcaVar.applySupportImageTint();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            return navDestinationImpl.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            return navDestinationImpl.getSupportBackgroundTintMode();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        TintInfo tintInfo;
        zzca zzcaVar = this.mImageHelper;
        if (zzcaVar == null || (tintInfo = (TintInfo) zzcaVar.zzb) == null) {
            return null;
        }
        return tintInfo.mTintList;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo tintInfo;
        zzca zzcaVar = this.mImageHelper;
        if (zzcaVar == null || (tintInfo = (TintInfo) zzcaVar.zzb) == null) {
            return null;
        }
        return tintInfo.mTintMode;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        if ((((ImageView) this.mImageHelper.zza).getBackground() instanceof RippleDrawable) || !super.hasOverlappingRendering()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        zzca zzcaVar = this.mImageHelper;
        if (zzcaVar != null) {
            zzcaVar.applySupportImageTint();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        zzca zzcaVar = this.mImageHelper;
        if (!(zzcaVar == null || drawable == null || this.mHasLevel)) {
            zzcaVar.zzd = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (zzcaVar != null) {
            zzcaVar.applySupportImageTint();
            if (!this.mHasLevel) {
                ImageView imageView = (ImageView) zzcaVar.zza;
                if (imageView.getDrawable() != null) {
                    imageView.getDrawable().setLevel(zzcaVar.zzd);
                }
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        zzca zzcaVar = this.mImageHelper;
        if (zzcaVar != null) {
            zzcaVar.setImageResource(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        zzca zzcaVar = this.mImageHelper;
        if (zzcaVar != null) {
            zzcaVar.applySupportImageTint();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        NavDestinationImpl navDestinationImpl = this.mBackgroundTintHelper;
        if (navDestinationImpl != null) {
            navDestinationImpl.setSupportBackgroundTintMode(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        zzca zzcaVar = this.mImageHelper;
        if (zzcaVar != null) {
            if (((TintInfo) zzcaVar.zzb) == null) {
                zzcaVar.zzb = new Object();
            }
            TintInfo tintInfo = (TintInfo) zzcaVar.zzb;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
            zzcaVar.applySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        zzca zzcaVar = this.mImageHelper;
        if (zzcaVar != null) {
            if (((TintInfo) zzcaVar.zzb) == null) {
                zzcaVar.zzb = new Object();
            }
            TintInfo tintInfo = (TintInfo) zzcaVar.zzb;
            tintInfo.mTintMode = mode;
            tintInfo.mHasTintMode = true;
            zzcaVar.applySupportImageTint();
        }
    }
}
