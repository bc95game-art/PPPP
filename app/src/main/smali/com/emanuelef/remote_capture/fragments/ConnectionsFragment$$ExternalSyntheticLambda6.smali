.class public final synthetic Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;

.field public final synthetic f$1:Z

.field public final synthetic f$2:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;Ljava/lang/Object;Z)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$0:Ljava/lang/Object;

    iput-boolean p4, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$1:Z

    iput-object p3, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$2:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$2:Ljava/lang/Object;

    check-cast v1, Landroid/content/Context;

    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$1:Z

    invoke-static {v0, v2, v1}, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;->$r8$lambda$RvsDHlVDqx7tuQ_xiVYIifq0F3s(Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;ZLandroid/content/Context;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$2:Ljava/lang/Object;

    check-cast v1, Lcom/emanuelef/remote_capture/Utils$UriStat;

    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$1:Z

    invoke-static {v0, v2, v1}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->$r8$lambda$LyEMvkOVMCjAuAYWh1se-Vk8HFw(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;ZLcom/emanuelef/remote_capture/Utils$UriStat;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$2:Ljava/lang/Object;

    check-cast v1, Lcom/emanuelef/remote_capture/Utils$UriStat;

    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;->f$1:Z

    invoke-static {v0, v2, v1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$YXVcoZuaPC38GYR64MVBNihF3tc(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
