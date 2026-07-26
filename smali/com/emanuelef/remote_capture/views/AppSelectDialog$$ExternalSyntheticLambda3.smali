.class public final synthetic Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onDismiss(Landroid/content/DialogInterface;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;->$r8$lambda$fLTC7637_ecCY0AyKuRESksDGSs(Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$jcnRAsddpCgukZD-sO6_1YxR3_s(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->$r8$lambda$DqErMFasLx102wAF5Ev_3QA_A2o(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/AboutActivity;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$aRWOOHqi8YJs88-uBNheZggcS7o(Lcom/emanuelef/remote_capture/activities/AboutActivity;Landroid/content/DialogInterface;)V

    return-void

    :pswitch_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/views/AppSelectDialog;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/views/AppSelectDialog;->$r8$lambda$i6f6pw5M-zA2m5eKBYNjEVvcUPM(Lcom/emanuelef/remote_capture/views/AppSelectDialog;Landroid/content/DialogInterface;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
