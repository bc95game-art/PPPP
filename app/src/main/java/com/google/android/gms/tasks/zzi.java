package com.google.android.gms.tasks;

import android.app.Application;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import androidx.core.app.ActivityRecreator;
import androidx.core.content.res.ResourcesCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.BillingClientImpl;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsResult;
import com.android.billingclient.api.zzbr;
import com.android.billingclient.api.zzcj;
import com.android.billingclient.api.zzcl;
import com.android.billingclient.api.zzs;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda4;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public final class zzi implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzi(int i, Object obj, Object obj2, boolean z) {
        this.$r8$classId = i;
        this.zzb = obj;
        this.zza = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor iAccountAccessor;
        switch (this.$r8$classId) {
            case 0:
                synchronized (((zzj) this.zzb).zzb) {
                    zzcl zzclVar = ((zzj) this.zzb).zzc;
                    ((Map) ((zzcl) zzclVar.zzc).zzc).remove((TaskCompletionSource) zzclVar.zzb);
                }
                return;
            case 1:
                ((ActivityRecreator.LifecycleCheckCallbacks) this.zza).currentlyRecreatingToken = this.zzb;
                return;
            case 2:
                ((Application) this.zza).unregisterActivityLifecycleCallbacks((ActivityRecreator.LifecycleCheckCallbacks) this.zzb);
                return;
            case 3:
                Object obj = this.zzb;
                Object obj2 = this.zza;
                try {
                    Method method = ActivityRecreator.performStopActivity3ParamsMethod;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        ActivityRecreator.performStopActivity2ParamsMethod.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e) {
                    if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                        throw e;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 4:
                Typeface typeface = (Typeface) this.zzb;
                ResourcesCompat.FontCallback fontCallback = (ResourcesCompat.FontCallback) ((FakeDrag) this.zza).mScrollEventAdapter;
                if (fontCallback != null) {
                    fontCallback.onFontRetrieved(typeface);
                    return;
                }
                return;
            case 5:
                ((zzbr) this.zza).accept(this.zzb);
                return;
            case 6:
                BillingClientImpl billingClientImpl = (BillingClientImpl) this.zza;
                BillingResult billingResult = (BillingResult) this.zzb;
                if (((PurchasesUpdatedListener) billingClientImpl.zzf.zzb) != null) {
                    ((PurchasesUpdatedListener) billingClientImpl.zzf.zzb).onPurchasesUpdated(billingResult, null);
                    return;
                } else {
                    zzc.zzn("BillingClient", "No valid listener is set in BroadcastManager");
                    return;
                }
            case 7:
                Future future = (Future) this.zza;
                if (!future.isDone() && !future.isCancelled()) {
                    Runnable runnable = (Runnable) this.zzb;
                    future.cancel(true);
                    zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    return;
                }
                return;
            case 8:
                BillingResult billingResult2 = zzcj.zzk;
                ((BillingClientImpl) this.zza).zzbd(24, 7, billingResult2);
                com.google.android.gms.internal.play_billing.zzbr zzbrVar = zzbt.zza;
                ((PlayBilling) this.zzb).onProductDetailsResponse(billingResult2, new QueryProductDetailsResult(zzca.zza));
                return;
            case 9:
                BillingResult billingResult3 = zzcj.zzk;
                ((BillingClientImpl) this.zza).zzbd(24, 9, billingResult3);
                com.google.android.gms.internal.play_billing.zzbr zzbrVar2 = zzbt.zza;
                ((PlayBilling$$ExternalSyntheticLambda4) this.zzb).onQueryPurchasesResponse(billingResult3, zzca.zza);
                return;
            case 10:
                ConnectionResult connectionResult = (ConnectionResult) this.zza;
                zzs zzsVar = (zzs) this.zzb;
                Api$Client api$Client = (Api$Client) zzsVar.zza;
                zabq zabqVar = (zabq) ((GoogleApiManager) zzsVar.zzg).zan.get((ApiKey) zzsVar.zzb);
                if (zabqVar != null) {
                    if (connectionResult.zzb == 0) {
                        zzsVar.zzh = true;
                        if (!api$Client.requiresSignIn()) {
                            try {
                                api$Client.getRemoteService(null, api$Client.getScopesForConnectionlessNonSignIn());
                                return;
                            } catch (SecurityException e2) {
                                Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                                api$Client.disconnect("Failed to get service from broker.");
                                zabqVar.zar(new ConnectionResult(10), null);
                                return;
                            }
                        } else if (zzsVar.zzh && (iAccountAccessor = (IAccountAccessor) zzsVar.zze) != null) {
                            api$Client.getRemoteService(iAccountAccessor, (Set) zzsVar.zzf);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        zabqVar.zar(connectionResult, null);
                        return;
                    }
                } else {
                    return;
                }
            default:
                ViewDragHelper viewDragHelper = ((SwipeDismissBehavior) this.zzb).viewDragHelper;
                if (viewDragHelper != null && viewDragHelper.continueSettling()) {
                    ((View) this.zza).postOnAnimation(this);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ zzi(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
    }

    public zzi(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.$r8$classId = 11;
        this.zzb = swipeDismissBehavior;
        this.zza = view;
    }
}
