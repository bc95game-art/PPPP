.class public final synthetic Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

.field public final synthetic f$1:Z

.field public final synthetic f$2:Lcom/emanuelef/remote_capture/Utils$UriStat;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;I)V
    .locals 0

    .line 1
    iput p4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$1:Z

    iput-object p3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$2:Lcom/emanuelef/remote_capture/Utils$UriStat;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$1:Z

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$2:Lcom/emanuelef/remote_capture/Utils$UriStat;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v2, v0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$DmndOOANggw6wvoUf_sbBcT99w4(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;)V

    return-void

    :pswitch_0
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$1:Z

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$2:Lcom/emanuelef/remote_capture/Utils$UriStat;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v2, v0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$7-zKANubPaE77mBV98mOCuEESrw(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
