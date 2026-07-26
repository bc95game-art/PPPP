.class public final synthetic Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$-y0qPkFKolPIQLo1syBv22cRf6o(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/view/View;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$PChHljCW0VDxUGxi1vus8RAjMU4(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/view/View;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
