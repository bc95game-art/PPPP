.class public final synthetic Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Landroidx/recyclerview/widget/RecyclerView$Adapter;

.field public final synthetic f$1:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;


# direct methods
.method public synthetic constructor <init>(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;->f$0:Landroidx/recyclerview/widget/RecyclerView$Adapter;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;->f$1:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onLongClick(Landroid/view/View;)Z
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;->f$0:Landroidx/recyclerview/widget/RecyclerView$Adapter;

    check-cast v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;->f$1:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    check-cast v1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->$r8$lambda$VoKIAct4Di7fxOUwuaV3IN8bZs0(Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;Landroid/view/View;)Z

    move-result p1

    return p1

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;->f$0:Landroidx/recyclerview/widget/RecyclerView$Adapter;

    check-cast v0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;->f$1:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    check-cast v1, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->$r8$lambda$wL2yDVtlT3NpOhgUsopxYHaAeD4(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;Landroid/view/View;)Z

    move-result p1

    return p1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
