.class public final synthetic Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Landroidx/fragment/app/Fragment;


# direct methods
.method public synthetic constructor <init>(Landroidx/fragment/app/Fragment;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->f$0:Landroidx/fragment/app/Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final bridge onValueChange(Lcom/google/android/material/slider/BaseSlider;FZ)V
    .locals 1

    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    .line 2
    :pswitch_0
    check-cast p1, Lcom/google/android/material/slider/Slider;

    invoke-virtual {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->onValueChange(Lcom/google/android/material/slider/Slider;FZ)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public final onValueChange(Lcom/google/android/material/slider/Slider;FZ)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->f$0:Landroidx/fragment/app/Fragment;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v0, p1, p2, p3}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$k7JlOw7fIvBc9VLimWzzhusaq7o(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Lcom/google/android/material/slider/Slider;FZ)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->f$0:Landroidx/fragment/app/Fragment;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v0, p1, p2, p3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$mNhDnIW6nIrUMfA3Q0_3Aqxh_Nw(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Lcom/google/android/material/slider/Slider;FZ)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
