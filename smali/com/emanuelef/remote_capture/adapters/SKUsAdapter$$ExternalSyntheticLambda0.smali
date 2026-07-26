.class public final synthetic Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;

.field public final synthetic f$1:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->f$1:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->f$1:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;->$r8$lambda$XgAqTIdnBOoSS6-_AerBheZT_WE(Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;Landroid/view/View;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->f$1:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;->$r8$lambda$m5UTgIM-DIVBbibbyB__R1U3iPs(Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;Landroid/view/View;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$$ExternalSyntheticLambda0;->f$1:Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;->$r8$lambda$29WQIXT73gWLdKW0t9elDCf9n84(Lcom/emanuelef/remote_capture/adapters/SKUsAdapter;Lcom/emanuelef/remote_capture/adapters/SKUsAdapter$SKUItem;Landroid/view/View;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
