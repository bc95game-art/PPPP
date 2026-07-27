.class public final synthetic Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/activity/result/ActivityResultCallback;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onActivityResult(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->$r8$lambda$Trj0OpxY0CG4p7gFoEm-PxVt0Mo(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->$r8$lambda$LmGu7GD74NypJL03LUHjR3bng6g(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroidx/activity/result/ActivityResult;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
