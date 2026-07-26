.class public final synthetic Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/views/RuleAddDialog$RuleAddListener;
.implements Landroidx/activity/result/ActivityResultCallback;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/EditListFragment;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addRule(Ljava/lang/String;Landroid/widget/TextView;)Z
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$qA3StDjJJ29E6MkAXxqke2TXB90(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Ljava/lang/String;Landroid/widget/TextView;)Z

    move-result p1

    return p1

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$rJQtHLvyCPBrWGs7ovumDX4H4MQ(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Ljava/lang/String;Landroid/widget/TextView;)Z

    move-result p1

    return p1

    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$q9NrLOOuH0_Sork5VLXyiHTGEkA(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Ljava/lang/String;Landroid/widget/TextView;)Z

    move-result p1

    return p1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onActivityResult(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$rVPdFCPysLtP053BFYSk62Xza8g(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$KWIssY1dUvKinzQYsrvhlpwAlh8(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Landroidx/activity/result/ActivityResult;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
