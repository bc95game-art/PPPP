.class public final synthetic Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;

.field public final synthetic f$1:Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;->f$1:Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;->f$1:Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;->$r8$lambda$zTXN2JnzZeOJr6wYaLbX4E6qUwU(Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;Landroid/view/View;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$$ExternalSyntheticLambda1;->f$1:Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;->$r8$lambda$ITmU4ZEUBjZAKleLJa0Qhd3rpwU(Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;Landroid/view/View;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
