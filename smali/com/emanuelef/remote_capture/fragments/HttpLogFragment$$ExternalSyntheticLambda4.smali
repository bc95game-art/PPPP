.class public final synthetic Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:[Z

.field public final synthetic f$1:Ljava/util/concurrent/ExecutorService;


# direct methods
.method public synthetic constructor <init>([ZLjava/util/concurrent/ExecutorService;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->f$0:[Z

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->f$1:Ljava/util/concurrent/ExecutorService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->f$0:[Z

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->f$1:Ljava/util/concurrent/ExecutorService;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$UG4qS9IM8G1-7-L6LmHLn5I3-Bo([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->f$0:[Z

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->f$1:Ljava/util/concurrent/ExecutorService;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$4NgwRhx9Ime1O-7o4_osPjOTrRM([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->f$0:[Z

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;->f$1:Ljava/util/concurrent/ExecutorService;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$olnnR4LyEkL6T2S6xDPxD6llHSY([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
