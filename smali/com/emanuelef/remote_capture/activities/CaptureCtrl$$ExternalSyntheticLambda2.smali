.class public final synthetic Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/activities/CaptureCtrl;

.field public final synthetic f$1:Landroid/content/Intent;

.field public final synthetic f$2:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/CaptureCtrl;Landroid/content/Intent;Ljava/lang/String;I)V
    .locals 0

    .line 1
    iput p4, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/activities/CaptureCtrl;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$1:Landroid/content/Intent;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$2:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$1:Landroid/content/Intent;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$2:Ljava/lang/String;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/activities/CaptureCtrl;

    invoke-static {v2, v0, v1, p1}, Lcom/emanuelef/remote_capture/activities/CaptureCtrl;->$r8$lambda$WD8FL6yB_uSlqsNETzZ002bYM2w(Lcom/emanuelef/remote_capture/activities/CaptureCtrl;Landroid/content/Intent;Ljava/lang/String;Landroid/view/View;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$1:Landroid/content/Intent;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$2:Ljava/lang/String;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/activities/CaptureCtrl;

    invoke-static {v2, v0, v1, p1}, Lcom/emanuelef/remote_capture/activities/CaptureCtrl;->$r8$lambda$nG9d5WdWNsQEFkwj4AxjN9GcbSs(Lcom/emanuelef/remote_capture/activities/CaptureCtrl;Landroid/content/Intent;Ljava/lang/String;Landroid/view/View;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
