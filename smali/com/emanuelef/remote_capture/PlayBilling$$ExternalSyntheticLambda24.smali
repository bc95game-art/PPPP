.class public final synthetic Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/PlayBilling;

.field public final synthetic f$1:Ljava/lang/Object;

.field public final synthetic f$2:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/PlayBilling;Lcom/emanuelef/remote_capture/PlayBilling$QrActivationRequest;Ljava/lang/Object;I)V
    .locals 0

    .line 1
    iput p4, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$0:Lcom/emanuelef/remote_capture/PlayBilling;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$1:Ljava/lang/Object;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$2:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/AboutActivity;Lcom/emanuelef/remote_capture/PlayBilling;Landroid/widget/EditText;)V
    .locals 1

    .line 2
    const/4 v0, 0x2

    iput v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$1:Ljava/lang/Object;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$0:Lcom/emanuelef/remote_capture/PlayBilling;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$2:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$1:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/AboutActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$2:Ljava/lang/Object;

    check-cast v1, Landroid/widget/EditText;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$0:Lcom/emanuelef/remote_capture/PlayBilling;

    invoke-static {v0, v2, v1, p1, p2}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$f21u9Ah6RxqJy-ya9mLvjPPKrOA(Lcom/emanuelef/remote_capture/activities/AboutActivity;Lcom/emanuelef/remote_capture/PlayBilling;Landroid/widget/EditText;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$1:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/PlayBilling$QrActivationRequest;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$2:Ljava/lang/Object;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$0:Lcom/emanuelef/remote_capture/PlayBilling;

    invoke-static {v2, v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/PlayBilling;->$r8$lambda$24baRNrQS7qiVK8VlF3NYsrIfdM(Lcom/emanuelef/remote_capture/PlayBilling;Lcom/emanuelef/remote_capture/PlayBilling$QrActivationRequest;Landroid/app/Activity;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$1:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/PlayBilling$QrActivationRequest;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$2:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda24;->f$0:Lcom/emanuelef/remote_capture/PlayBilling;

    invoke-static {v2, v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/PlayBilling;->$r8$lambda$0tjP5MTaKfoGCX4Muh66RT04hio(Lcom/emanuelef/remote_capture/PlayBilling;Lcom/emanuelef/remote_capture/PlayBilling$QrActivationRequest;Ljava/lang/String;Landroid/content/DialogInterface;I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
