package com.android.billingclient.api;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.provider.FontRequestWorker;
import androidx.core.view.WindowInsetsAnimationCompat;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda15;
import com.google.android.gms.tasks.zzi;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.HeaderBehavior;
/* loaded from: classes.dex */
public final /* synthetic */ class zzam implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public Object zza;
    public Object zzb;
    public Object zzc;

    public /* synthetic */ zzam() {
        this.$r8$classId = 1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OverScroller overScroller;
        switch (this.$r8$classId) {
            case 0:
                BillingResult billingResult = zzcj.zzk;
                ((BillingClientImpl) this.zza).zzbd(24, 4, billingResult);
                ((ConsumeResponseListener) this.zzb).onConsumeResponse(billingResult, ((ConsumeParams) this.zzc).zza);
                return;
            case 1:
                try {
                    obj = ((FontRequestWorker.AnonymousClass1) this.zza).call();
                } catch (Exception unused) {
                    obj = null;
                }
                ((Handler) this.zzc).post(new zzi((zzbr) this.zzb, 5, obj));
                return;
            case 2:
                WindowInsetsAnimationCompat.Impl21.dispatchOnStart((View) this.zza, (zzcl) this.zzb);
                ((ValueAnimator) this.zzc).start();
                return;
            case 3:
                zzam.super.queryProductDetailsAsync((QueryProductDetailsParams) this.zzb, (PlayBilling) this.zzc);
                return;
            case 4:
                zzam.super.consumeAsync((ConsumeParams) this.zzc, (ConsumeResponseListener) this.zzb);
                return;
            case 5:
                zzam.super.acknowledgePurchase((ConsumeParams) this.zzb, (PlayBilling$$ExternalSyntheticLambda15) this.zzc);
                return;
            default:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.zza;
                HeaderBehavior headerBehavior = (HeaderBehavior) this.zzc;
                View view = (View) this.zzb;
                if (view != null && (overScroller = headerBehavior.scroller) != null) {
                    if (overScroller.computeScrollOffset()) {
                        headerBehavior.setHeaderTopBottomOffset(coordinatorLayout, view, headerBehavior.scroller.getCurrY());
                        view.postOnAnimation(this);
                        return;
                    }
                    AppBarLayout appBarLayout = (AppBarLayout) view;
                    ((AppBarLayout.BaseBehavior) headerBehavior).snapToChildIfNeeded(coordinatorLayout, appBarLayout);
                    if (appBarLayout.liftOnScroll) {
                        appBarLayout.setLiftedState(appBarLayout.shouldLift(AppBarLayout.BaseBehavior.findFirstScrollingChild(coordinatorLayout)));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public /* synthetic */ zzam(BillingClientImpl billingClientImpl, Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.zza = billingClientImpl;
        this.zzb = obj;
        this.zzc = obj2;
    }

    public /* synthetic */ zzam(zzce zzceVar, ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        this.$r8$classId = 4;
        this.zza = zzceVar;
        this.zzc = consumeParams;
        this.zzb = consumeResponseListener;
    }

    public zzam(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, View view) {
        this.$r8$classId = 6;
        this.zzc = headerBehavior;
        this.zza = coordinatorLayout;
        this.zzb = view;
    }

    public zzam(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, zzcl zzclVar, ValueAnimator valueAnimator) {
        this.$r8$classId = 2;
        this.zza = view;
        this.zzb = zzclVar;
        this.zzc = valueAnimator;
    }
}
