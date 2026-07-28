.class public final synthetic Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/Observer;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onChanged(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    check-cast p1, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$uMc_xODVJEZw0i8kYC1ixTTkz-8(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    check-cast p1, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$OZ9GlrhRgpoWUTixc-ciKULZaoE(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/BlacklistsFragment;

    check-cast p1, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/BlacklistsFragment;->$r8$lambda$4KgpzBqpIW5uiMPVk3Ozylc-TuU(Lcom/emanuelef/remote_capture/fragments/BlacklistsFragment;Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    return-void

    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/StatsActivity;

    check-cast p1, Lcom/emanuelef/remote_capture/model/CaptureStats;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/StatsActivity;->$r8$lambda$W9tVy6EFwTdZiRhj17vTe7-Y8Z8(Lcom/emanuelef/remote_capture/activities/StatsActivity;Lcom/emanuelef/remote_capture/model/CaptureStats;)V

    return-void

    :pswitch_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/MainActivity;

    check-cast p1, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$efdqY3nECjT1TrZ9w7dXWhh2n48(Lcom/emanuelef/remote_capture/activities/MainActivity;Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    return-void

    :pswitch_4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/AppsFragment;

    check-cast p1, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/AppsFragment;->$r8$lambda$4yRQppUl0mQyP1smK9BsS5P5x9M(Lcom/emanuelef/remote_capture/fragments/AppsFragment;Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
