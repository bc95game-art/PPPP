.class public final synthetic Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/material/chip/ChipGroup$OnCheckedStateChangeListener;
.implements Landroidx/core/view/OnApplyWindowInsetsListener;
.implements Landroidx/activity/result/ActivityResultCallback;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActivityResult(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$jI7Wc-bOuJv-rKNjRIMIbbHbN88(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$0yCjVqMmk0sRHT_pL5GofaHBph8(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroidx/activity/result/ActivityResult;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onApplyWindowInsets(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$AkGpVN0JfqBffPOlDMcfyaZTTeQ(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1
.end method

.method public onCheckedChanged(Lcom/google/android/material/chip/ChipGroup;Ljava/util/ArrayList;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$tcaOO4xMux9zrJF7xG4n410WfYA(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/util/ArrayList;)V

    return-void
.end method
