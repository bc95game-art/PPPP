.class public final synthetic Lcom/emanuelef/remote_capture/fragments/StatusFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/Observer;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/StatusFragment;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/StatusFragment;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/StatusFragment$$ExternalSyntheticLambda2;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/StatusFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/StatusFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onChanged(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/StatusFragment$$ExternalSyntheticLambda2;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/StatusFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/StatusFragment;

    check-cast p1, Lcom/emanuelef/remote_capture/model/CaptureStats;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/StatusFragment;->$r8$lambda$atiNvOk8ZYmW5MSDDmZetvhdgNc(Lcom/emanuelef/remote_capture/fragments/StatusFragment;Lcom/emanuelef/remote_capture/model/CaptureStats;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/StatusFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/StatusFragment;

    check-cast p1, Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/StatusFragment;->$r8$lambda$T9zMgbY-j9DE8Ai7yhEGMRqX-w8(Lcom/emanuelef/remote_capture/fragments/StatusFragment;Lcom/emanuelef/remote_capture/MitmReceiver$Status;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
