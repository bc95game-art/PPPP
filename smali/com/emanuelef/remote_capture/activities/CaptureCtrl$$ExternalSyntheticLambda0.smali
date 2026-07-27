.class public final synthetic Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/material/tabs/TabLayoutMediator$TabConfigurationStrategy;
.implements Lcom/emanuelef/remote_capture/PersistableUriPermission$PupListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Landroidx/appcompat/app/AppCompatActivity;

.field public final synthetic f$1:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Object;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConfigureTab(Lcom/google/android/material/tabs/TabLayout$Tab;I)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/MalwareDetection;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    check-cast v1, Lcom/emanuelef/remote_capture/activities/MalwareDetection$StateAdapter;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/activities/MalwareDetection;->$r8$lambda$Lrm2amkgIMBz63lBejkUz7itAjg(Lcom/emanuelef/remote_capture/activities/MalwareDetection;Lcom/emanuelef/remote_capture/activities/MalwareDetection$StateAdapter;Lcom/google/android/material/tabs/TabLayout$Tab;I)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/MainActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    check-cast v1, Lcom/emanuelef/remote_capture/activities/MainActivity$MainStateAdapter;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$Plj-nCmV7LZFlLcsqHkUVFgDAW8(Lcom/emanuelef/remote_capture/activities/MainActivity;Lcom/emanuelef/remote_capture/activities/MainActivity$MainStateAdapter;Lcom/google/android/material/tabs/TabLayout$Tab;I)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/AppDetailsActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    check-cast v1, Lcom/emanuelef/remote_capture/activities/AppDetailsActivity$StateAdapter;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/activities/AppDetailsActivity;->$r8$lambda$CGX3VITiN4i297VroONm6WEAySE(Lcom/emanuelef/remote_capture/activities/AppDetailsActivity;Lcom/emanuelef/remote_capture/activities/AppDetailsActivity$StateAdapter;Lcom/google/android/material/tabs/TabLayout$Tab;I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onUriChecked(Landroid/net/Uri;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    check-cast v1, Lcom/emanuelef/remote_capture/model/CaptureSettings;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/activities/CaptureCtrl;->$r8$lambda$VRITSg3HY7_vggZbFDz6uVL2qzM(Lcom/emanuelef/remote_capture/activities/CaptureCtrl;Lcom/emanuelef/remote_capture/model/CaptureSettings;Landroid/net/Uri;)V

    return-void
.end method
