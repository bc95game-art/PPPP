.class public final synthetic Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

.field public final synthetic f$1:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->f$1:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->f$1:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->$r8$lambda$3LAchvlv16H4C-rtT0Mv5ACf5PA(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->f$1:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->$r8$lambda$rLeba1UdqIl53ryKIcaaTWQZWik(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda6;->f$1:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->$r8$lambda$z3m5JbBdj0B8YAod2Zu7a5FEqQc(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$PayloadViewHolder;Landroid/view/View;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
