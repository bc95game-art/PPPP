.class public final synthetic Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onDismiss(Landroid/content/DialogInterface;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$q9B2p1nMh6PW4HZilJxjRvhpKsY(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$yP2XG3phEFx-Usnvj9zt2U4nIe8(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/content/DialogInterface;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
