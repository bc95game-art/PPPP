package com.android.billingclient.api;

import androidx.collection.SimpleArrayMap;
import androidx.core.provider.FontRequestWorker;
import androidx.core.util.Consumer;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda15;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final /* synthetic */ class zzbr implements Consumer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;

    public /* synthetic */ zzbr(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ArrayList arrayList = new ArrayList();
                new ArrayList();
                QueryProductDetailsResult queryProductDetailsResult = new QueryProductDetailsResult(arrayList);
                ((PlayBilling) this.zza).onProductDetailsResponse((BillingResult) obj, queryProductDetailsResult);
                return;
            case 1:
                FontRequestWorker.TypefaceResult typefaceResult = (FontRequestWorker.TypefaceResult) obj;
                if (typefaceResult == null) {
                    typefaceResult = new FontRequestWorker.TypefaceResult(-3);
                }
                ((zzcl) this.zza).onTypefaceResult(typefaceResult);
                return;
            case 2:
                FontRequestWorker.TypefaceResult typefaceResult2 = (FontRequestWorker.TypefaceResult) obj;
                synchronized (FontRequestWorker.LOCK) {
                    try {
                        SimpleArrayMap simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                        ArrayList arrayList2 = (ArrayList) simpleArrayMap.get((String) this.zza);
                        if (arrayList2 != null) {
                            simpleArrayMap.remove((String) this.zza);
                            for (int i = 0; i < arrayList2.size(); i++) {
                                ((Consumer) arrayList2.get(i)).accept(typefaceResult2);
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            default:
                ((PlayBilling$$ExternalSyntheticLambda15) this.zza).getClass();
                PlayBilling.lambda$processPurchases$6((BillingResult) obj);
                return;
        }
    }
}
