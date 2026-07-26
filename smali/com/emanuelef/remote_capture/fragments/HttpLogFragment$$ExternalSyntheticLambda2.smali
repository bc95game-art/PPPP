.class public final synthetic Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$R1B-Oz73OZKxklavFJPP3-U7zYg(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$czbk9UyB3jhV5U-UwD9QO46YiQU(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
