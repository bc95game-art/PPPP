.class public final synthetic Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/CaptureStartListener;
.implements Landroidx/activity/result/ActivityResultCallback;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/MainActivity;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActivityResult(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$mTKMOcdI_6GWXHS2T14wumIQb_Q(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$8NNnmRxHTxfOM4IpYxo4r0-LYWo(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$xMCi4gnSxavTY1m7KNvxc1PJODY(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$Sh7KhC-ZCKxRdJgUdTVuS7k5SwE(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroidx/activity/result/ActivityResult;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onCaptureStartResult(Z)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$hzIce9bx7P5mqtrTtkuu6W1_snQ(Lcom/emanuelef/remote_capture/activities/MainActivity;Z)V

    return-void
.end method
