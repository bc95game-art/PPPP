.class public final synthetic Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/activity/result/ActivityResultCallback;
.implements Lcom/google/android/material/chip/ChipGroup$OnCheckedStateChangeListener;
.implements Landroidx/core/view/OnApplyWindowInsetsListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActivityResult(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$YxJNokvswaNnQy5dRH-Z1BRyMtM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$OaacA1e8BQ9jF_7aXYdpvryhUh4(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$fcSYt1hA1qBou_VgjfnZlCxeTCE(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroidx/activity/result/ActivityResult;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onApplyWindowInsets(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$rYz5Kl0S2e49r0QN0dZs4RobTbE(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1
.end method

.method public onCheckedChanged(Lcom/google/android/material/chip/ChipGroup;Ljava/util/ArrayList;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;->f$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$wrZV6vDcytJyDcMeN3-D_L-3cSM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/util/ArrayList;)V

    return-void
.end method
