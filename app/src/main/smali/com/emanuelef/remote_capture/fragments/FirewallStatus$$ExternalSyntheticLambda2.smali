.class public final synthetic Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;

.field public final synthetic f$1:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$1:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/prefs/PortMapFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$1:Ljava/lang/Object;

    check-cast v1, Landroid/view/ActionMode;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/prefs/PortMapFragment;->$r8$lambda$zX4SySF-Kr0E1Y1OS_i0IpquZ38(Lcom/emanuelef/remote_capture/fragments/prefs/PortMapFragment;Landroid/view/ActionMode;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$1:Ljava/lang/Object;

    check-cast v1, Landroid/content/SharedPreferences;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;->$r8$lambda$nidoN_jkwUUZFCT5zeVDqNNoaKY(Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;Landroid/content/SharedPreferences;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$1:Ljava/lang/Object;

    check-cast v1, Landroid/view/ActionMode;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$7_dlqGjgobWvYYPGh5gabHMf0UM(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Landroid/view/ActionMode;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$1:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$wMFTPY4qbVWVwNbC1A05Hcu61RM(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Ljava/lang/String;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$1:Ljava/lang/Object;

    check-cast v1, Landroid/content/SharedPreferences;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->$r8$lambda$QHvExettGGJNvFI9t6fS0VcsXhg(Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;Landroid/content/SharedPreferences;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$1:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->$r8$lambda$HrYrgNtxbzyo-9Sv_KNxSBy7INs(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;Ljava/lang/String;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;->f$1:Ljava/lang/Object;

    check-cast v1, Landroid/view/MenuItem;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;->$r8$lambda$2DYPzqRsLZXWDwgb1FR-TrNJqlw(Lcom/emanuelef/remote_capture/fragments/FirewallStatus;Landroid/view/MenuItem;Landroid/content/DialogInterface;I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
