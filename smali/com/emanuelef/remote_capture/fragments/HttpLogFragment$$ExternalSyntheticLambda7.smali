.class public final synthetic Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

.field public final synthetic f$1:Landroid/net/Uri;

.field public final synthetic f$2:Ljava/util/ArrayList;

.field public final synthetic f$3:[Z

.field public final synthetic f$4:Landroid/os/Handler;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;I)V
    .locals 0

    .line 1
    iput p6, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$1:Landroid/net/Uri;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$2:Ljava/util/ArrayList;

    iput-object p4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$3:[Z

    iput-object p5, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$4:Landroid/os/Handler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 5

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$3:[Z

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$4:Landroid/os/Handler;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    iget-object v3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$1:Landroid/net/Uri;

    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$2:Ljava/util/ArrayList;

    invoke-static {v2, v3, v4, v0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$JBNhCeYDZgzUoB2E7v1d776FAfM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$3:[Z

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$4:Landroid/os/Handler;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    iget-object v3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$1:Landroid/net/Uri;

    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;->f$2:Ljava/util/ArrayList;

    invoke-static {v2, v3, v4, v0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$N-NNphsC23P4KvNi3zUfOCOUJhQ(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
