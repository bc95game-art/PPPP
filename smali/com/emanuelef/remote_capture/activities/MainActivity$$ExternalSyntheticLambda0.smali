.class public final synthetic Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/MainActivity;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$DB4W6vVT6EIF4T2p4IAMa8raDjA(Lcom/emanuelef/remote_capture/activities/MainActivity;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$DqVjVMBMDHzAHw7QbjTRzHc8VxE(Lcom/emanuelef/remote_capture/activities/MainActivity;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$oLbkHUvP7jErHqgt58kINU0CNfA(Lcom/emanuelef/remote_capture/activities/MainActivity;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
