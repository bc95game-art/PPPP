.class Lcom/emanuelef/remote_capture/activities/MainActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/PlayBilling$PurchaseReadyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/emanuelef/remote_capture/activities/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/activities/MainActivity;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/activities/MainActivity;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$1;->this$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method


# virtual methods
.method public final synthetic onPurchasesError()V
    .locals 0

    .line 1
    invoke-static {p0}, Lcom/emanuelef/remote_capture/PlayBilling$PurchaseReadyListener$-CC;->$default$onPurchasesError(Lcom/emanuelef/remote_capture/PlayBilling$PurchaseReadyListener;)V

    return-void
.end method

.method public onPurchasesReady()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$1;->this$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/MainActivity;->-$$Nest$mcheckPurchasesAvailable(Lcom/emanuelef/remote_capture/activities/MainActivity;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$1;->this$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    .line 7
    .line 8
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/MainActivity;->-$$Nest$mcheckPaidDrawerEntries(Lcom/emanuelef/remote_capture/activities/MainActivity;)V

    .line 9
    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method public final synthetic onSKUStateUpdate(Ljava/lang/String;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1, p2}, Lcom/emanuelef/remote_capture/PlayBilling$PurchaseReadyListener$-CC;->$default$onSKUStateUpdate(Lcom/emanuelef/remote_capture/PlayBilling$PurchaseReadyListener;Ljava/lang/String;I)V

    return-void
.end method
