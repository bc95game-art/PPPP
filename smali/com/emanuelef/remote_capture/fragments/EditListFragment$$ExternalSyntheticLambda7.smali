.class public final synthetic Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

.field public final synthetic f$1:Lcom/emanuelef/remote_capture/model/MatchList;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Lcom/emanuelef/remote_capture/model/MatchList;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;->f$1:Lcom/emanuelef/remote_capture/model/MatchList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;->f$1:Lcom/emanuelef/remote_capture/model/MatchList;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$EsTTFDMNf6c6MU8KtX_JIQ4CIv0(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Lcom/emanuelef/remote_capture/model/MatchList;Landroid/content/DialogInterface;I)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;->f$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$$ExternalSyntheticLambda7;->f$1:Lcom/emanuelef/remote_capture/model/MatchList;

    invoke-static {v0, v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->$r8$lambda$XYOh6H9E_yb-I9mOlba68wgQ5rs(Lcom/emanuelef/remote_capture/fragments/EditListFragment;Lcom/emanuelef/remote_capture/model/MatchList;Landroid/content/DialogInterface;I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
