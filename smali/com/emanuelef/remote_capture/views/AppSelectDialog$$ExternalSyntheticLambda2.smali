.class public final synthetic Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onCancel(Landroid/content/DialogInterface;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Ljava/util/concurrent/ExecutorService;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;->$r8$lambda$aCWhBk-C6hLpHGRwZYSCCJYhLGQ(Ljava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;->$r8$lambda$sQNx8IwdmpPPmqG5UuC5IFfOV74(Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->$r8$lambda$1ZLcx4IEoeyn_rxYoEFW1BBedrc(Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$_HRP_w5eNgKa7_R3fqSRpev_qZ0(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/views/AppSelectDialog;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/views/AppSelectDialog;->$r8$lambda$7RWGHfD_JVOYvz6VfehKxvofHIM(Lcom/emanuelef/remote_capture/views/AppSelectDialog;Landroid/content/DialogInterface;)V

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
