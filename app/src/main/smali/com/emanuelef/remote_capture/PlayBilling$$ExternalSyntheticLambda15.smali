.class public final synthetic Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda15;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/CaptureStartListener;
.implements Lcom/android/billingclient/api/ConsumeResponseListener;
.implements Landroidx/core/view/OnApplyWindowInsetsListener;


# instance fields
.field public final synthetic $r8$classId:I


# direct methods
.method public synthetic constructor <init>(I)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda15;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onApplyWindowInsets(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda15;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/Utils;->$r8$lambda$W2zUG-v87-vcL9xj1bXAm2ZM9vY(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    :pswitch_0
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/Utils;->$r8$lambda$FVSRJeeOe56QenUyhjCkWSsNi7o(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    nop

    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_0
    .end packed-switch
.end method

.method public onCaptureStartResult(Z)V
    .locals 0

    .line 1
    invoke-static {p1}, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->$r8$lambda$KUkk0H1guUoyPp6m5gbjqgiRTco(Z)V

    return-void
.end method

.method public onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/PlayBilling;->$r8$lambda$eHp7YoLODZi-6mc0IVQwp-_YYB0(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    return-void
.end method
