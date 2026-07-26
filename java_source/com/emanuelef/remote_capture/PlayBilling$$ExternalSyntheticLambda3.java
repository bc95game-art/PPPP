package com.emanuelef.remote_capture;
/* loaded from: classes.dex */
public final /* synthetic */ class PlayBilling$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ PlayBilling f$0;

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda3(PlayBilling playBilling, int i) {
        this.$r8$classId = i;
        this.f$0 = playBilling;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$onBillingServiceDisconnected$11();
                return;
            case 1:
                this.f$0.lambda$processPurchases$3();
                return;
            case 2:
                this.f$0.lambda$processPurchases$4();
                return;
            case 3:
                this.f$0.lambda$processPurchases$8();
                return;
            case 4:
                this.f$0.lambda$disconnectBilling$12();
                return;
            case 5:
                this.f$0.lambda$requestQrLicenseCode$26();
                return;
            case 6:
                this.f$0.lambda$purchase$15();
                return;
            case 7:
                this.f$0.lambda$purchase$16();
                return;
            case 8:
                this.f$0.lambda$consumePurchase$13();
                return;
            case 9:
                this.f$0.lambda$startQrActivation$27();
                return;
            case 10:
                this.f$0.lambda$onPurchasesError$9();
                return;
            case 11:
                this.f$0.lambda$requestUnlockToken$22();
                return;
            default:
                this.f$0.lambda$processPurchases$0();
                return;
        }
    }
}
