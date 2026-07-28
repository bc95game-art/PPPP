.class public final synthetic Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Landroidx/fragment/app/Fragment;

.field public final synthetic f$1:I


# direct methods
.method public synthetic constructor <init>(IILandroidx/fragment/app/Fragment;)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p3, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;->f$0:Landroidx/fragment/app/Fragment;

    iput p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;->f$1:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;->f$0:Landroidx/fragment/app/Fragment;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;

    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;->f$1:I

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->$r8$lambda$BH6aI_544mlIrPbj7ctUS9kbNzU(Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;ILandroid/view/View;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;->f$0:Landroidx/fragment/app/Fragment;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;

    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;->f$1:I

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;->$r8$lambda$6o6j_1vSpORFsGr3el__uDDXG-Q(Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;ILandroid/view/View;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
