.class public final synthetic Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;

.field public final synthetic f$1:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$1:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/PlayBilling;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$1:Ljava/lang/Object;

    check-cast v1, Lcom/android/billingclient/api/Purchase;

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/PlayBilling;->$r8$lambda$nockC4p3XYP2zIFkLWXCS3JDacI(Lcom/emanuelef/remote_capture/PlayBilling;Lcom/android/billingclient/api/Purchase;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$1:Ljava/lang/Object;

    check-cast v1, [Lcom/emanuelef/remote_capture/Blacklists$NativeBlacklistStatus;

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$QOPxv9l4TAjDZSQ6g-wZdKhumdw(Lcom/emanuelef/remote_capture/CaptureService;[Lcom/emanuelef/remote_capture/Blacklists$NativeBlacklistStatus;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$1:Ljava/lang/Object;

    check-cast v1, Landroid/app/Notification;

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$JYqwrVd1pyrGDTxgAK86Qqqf0WQ(Lcom/emanuelef/remote_capture/CaptureService;Landroid/app/Notification;)V

    return-void

    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Landroidx/viewpager2/widget/ViewPager2;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$1:Ljava/lang/Object;

    check-cast v1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils$3;->$r8$lambda$vgWthcD4B1KFjI_No5gUO8P4PRc(Landroidx/viewpager2/widget/ViewPager2;Ljava/util/concurrent/atomic/AtomicReference;)V

    return-void

    :pswitch_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Landroidx/appcompat/widget/SearchView;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;->f$1:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils;->$r8$lambda$KUCFxKhr2t2G5eXqosjuZAngUPg(Landroidx/appcompat/widget/SearchView;Ljava/lang/String;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
