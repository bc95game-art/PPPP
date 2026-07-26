.class public final synthetic Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

.field public final synthetic f$1:I


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;II)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;->f$1:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;->f$1:I

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$cMY6wzR6Pz0c4w4_iqXsgkUWzvk(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;->f$1:I

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$c-mEyVjwZ0tpGPOlmFpNBzPBKOM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
