package com.android.billingclient.api;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.collection.SparseArrayCompat;
import androidx.core.p002os.BundleKt;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat$Api21Impl;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavGraphImpl$iterator$1;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class zzca {
    public final Object zza;
    public Object zzb;
    public Object zzc;
    public int zzd;

    public zzca(zzce zzceVar, int i, Consumer consumer, Runnable runnable) {
        this.zzd = i;
        this.zza = consumer;
        this.zzb = runnable;
        this.zzc = zzceVar;
    }

    public void applySupportImageTint() {
        ImageView imageView = (ImageView) this.zza;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        if (drawable != null) {
            int i = Build.VERSION.SDK_INT;
            if (i <= 21 && i == 21) {
                if (((TintInfo) this.zzc) == null) {
                    this.zzc = new Object();
                }
                TintInfo tintInfo = (TintInfo) this.zzc;
                tintInfo.mTintList = null;
                tintInfo.mHasTintList = false;
                tintInfo.mTintMode = null;
                tintInfo.mHasTintMode = false;
                ColorStateList imageTintList = ImageViewCompat$Api21Impl.getImageTintList(imageView);
                if (imageTintList != null) {
                    tintInfo.mHasTintList = true;
                    tintInfo.mTintList = imageTintList;
                }
                PorterDuff.Mode imageTintMode = ImageViewCompat$Api21Impl.getImageTintMode(imageView);
                if (imageTintMode != null) {
                    tintInfo.mHasTintMode = true;
                    tintInfo.mTintMode = imageTintMode;
                }
                if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                    AppCompatDrawableManager.tintDrawable(drawable, tintInfo, imageView.getDrawableState());
                    return;
                }
            }
            TintInfo tintInfo2 = (TintInfo) this.zzb;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.tintDrawable(drawable, tintInfo2, imageView.getDrawableState());
            }
        }
    }

    public NavDestination findNodeComprehensive$navigation_common_release(int i, NavDestination navDestination, NavDestination navDestination2, boolean z) {
        NavGraph navGraph = (NavGraph) this.zza;
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.zzb;
        NavDestination navDestination3 = (NavDestination) sparseArrayCompat.get(i);
        if (navDestination2 != null) {
            if (Intrinsics.areEqual(navDestination3, navDestination2) && Intrinsics.areEqual(navDestination3.parent, navDestination2.parent)) {
                return navDestination3;
            }
            navDestination3 = null;
        } else if (navDestination3 != null) {
            return navDestination3;
        }
        if (z) {
            Iterator it = SequencesKt.asSequence(new ArrayIterator(1, sparseArrayCompat)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    navDestination3 = null;
                    break;
                }
                NavDestination navDestination4 = (NavDestination) it.next();
                if (!(navDestination4 instanceof NavGraph) || navDestination4.equals(navDestination)) {
                    navDestination3 = null;
                    continue;
                } else {
                    navDestination3 = ((NavGraph) navDestination4).impl.findNodeComprehensive$navigation_common_release(i, navGraph, navDestination2, true);
                    continue;
                }
                if (navDestination3 != null) {
                    break;
                }
            }
        }
        if (navDestination3 != null) {
            return navDestination3;
        }
        NavGraph navGraph2 = navGraph.parent;
        if (navGraph2 == null || navGraph2.equals(navDestination)) {
            return null;
        }
        NavGraph navGraph3 = navGraph.parent;
        Intrinsics.checkNotNull(navGraph3);
        return navGraph3.impl.findNodeComprehensive$navigation_common_release(i, navGraph, navDestination2, z);
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        Drawable drawable;
        Drawable drawable2;
        int resourceId;
        ImageView imageView = (ImageView) this.zza;
        Context context = imageView.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes.input;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) obtainStyledAttributes.input, i);
        try {
            Drawable drawable3 = imageView.getDrawable();
            if (!(drawable3 != null || (resourceId = typedArray.getResourceId(1, -1)) == -1 || (drawable3 = BundleKt.getDrawable(imageView.getContext(), resourceId)) == null)) {
                imageView.setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                DrawableUtils.fixDrawable(drawable3);
            }
            if (typedArray.hasValue(2)) {
                ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(2);
                int i2 = Build.VERSION.SDK_INT;
                ImageViewCompat$Api21Impl.setImageTintList(imageView, colorStateList);
                if (!(i2 != 21 || (drawable2 = imageView.getDrawable()) == null || ImageViewCompat$Api21Impl.getImageTintList(imageView) == null)) {
                    if (drawable2.isStateful()) {
                        drawable2.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable2);
                }
            }
            if (typedArray.hasValue(3)) {
                PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(typedArray.getInt(3, -1), null);
                int i3 = Build.VERSION.SDK_INT;
                ImageViewCompat$Api21Impl.setImageTintMode(imageView, parseTintMode);
                if (!(i3 != 21 || (drawable = imageView.getDrawable()) == null || ImageViewCompat$Api21Impl.getImageTintList(imageView) == null)) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public NavDestination.DeepLinkMatch matchDeepLinkComprehensive$navigation_common_release(NavDestination.DeepLinkMatch deepLinkMatch, MatcherMatchResult matcherMatchResult, boolean z, NavDestination navDestination) {
        NavDestination.DeepLinkMatch deepLinkMatch2;
        NavGraph navGraph = (NavGraph) this.zza;
        ArrayList arrayList = new ArrayList();
        Iterator it = navGraph.iterator();
        while (true) {
            NavGraphImpl$iterator$1 navGraphImpl$iterator$1 = (NavGraphImpl$iterator$1) it;
            deepLinkMatch2 = null;
            if (!navGraphImpl$iterator$1.hasNext()) {
                break;
            }
            NavDestination navDestination2 = (NavDestination) navGraphImpl$iterator$1.next();
            if (!Intrinsics.areEqual(navDestination2, navDestination)) {
                deepLinkMatch2 = navDestination2.matchDeepLink(matcherMatchResult);
            }
            if (deepLinkMatch2 != null) {
                arrayList.add(deepLinkMatch2);
            }
        }
        NavDestination.DeepLinkMatch deepLinkMatch3 = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(arrayList);
        NavGraph navGraph2 = navGraph.parent;
        if (navGraph2 != null && z && !navGraph2.equals(navDestination)) {
            deepLinkMatch2 = navGraph2.matchDeepLinkComprehensive(matcherMatchResult, navGraph);
        }
        NavDestination.DeepLinkMatch[] deepLinkMatchArr = {deepLinkMatch, deepLinkMatch3, deepLinkMatch2};
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 3; i++) {
            NavDestination.DeepLinkMatch deepLinkMatch4 = deepLinkMatchArr[i];
            if (deepLinkMatch4 != null) {
                arrayList2.add(deepLinkMatch4);
            }
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(arrayList2);
    }

    public void setImageResource(int i) {
        ImageView imageView = (ImageView) this.zza;
        if (i != 0) {
            Drawable drawable = BundleKt.getDrawable(imageView.getContext(), i);
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageDrawable(null);
        }
        applySupportImageTint();
    }

    public void zza(Throwable th) {
        zzce zzceVar = (zzce) this.zzc;
        if (th instanceof TimeoutException) {
            zzceVar.zzaF(102, 28, zzcj.zzF);
            zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            zzceVar.zzaF(95, 28, zzcj.zzF);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        ((Runnable) this.zzb).run();
    }

    public zzca(NavBackStackEntry navBackStackEntry, int i) {
        this.zza = navBackStackEntry.f10id;
        this.zzd = i;
        NavBackStackEntryImpl navBackStackEntryImpl = navBackStackEntry.impl;
        this.zzb = navBackStackEntryImpl.getArguments$navigation_common_release();
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        this.zzc = bundleOf;
        navBackStackEntryImpl.savedStateRegistryController.performSave(bundleOf);
    }

    public zzca(NavGraph navGraph) {
        this.zza = navGraph;
        this.zzb = new SparseArrayCompat(0);
    }

    public zzca(Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        String string = state.getString("nav-entry-state:id");
        if (string != null) {
            this.zza = string;
            this.zzd = Navigation.m650getIntimpl(state, "nav-entry-state:destination-id");
            Bundle bundle = state.getBundle("nav-entry-state:args");
            if (bundle != null) {
                this.zzb = bundle;
                Bundle bundle2 = state.getBundle("nav-entry-state:saved-state");
                if (bundle2 != null) {
                    this.zzc = bundle2;
                } else {
                    Navigation.keyOrValueNotFoundError("nav-entry-state:saved-state");
                    throw null;
                }
            } else {
                Navigation.keyOrValueNotFoundError("nav-entry-state:args");
                throw null;
            }
        } else {
            Navigation.keyOrValueNotFoundError("nav-entry-state:id");
            throw null;
        }
    }

    public zzca(ImageView imageView) {
        this.zzd = 0;
        this.zza = imageView;
    }
}
