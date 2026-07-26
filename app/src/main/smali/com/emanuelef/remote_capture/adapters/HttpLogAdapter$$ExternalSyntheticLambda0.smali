.class public final synthetic Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onLongClick(Landroid/view/View;)Z
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$C0Z4Wx4jCPQjjfsZOstGdnm7AAM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/view/View;)Z

    move-result p1

    return p1

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$LINS4buikrlfN6QRYhH11RmDTnY(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/view/View;)Z

    move-result p1

    return p1

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->$r8$lambda$6vs4mG4A046uy7479GTJJ9mhxOM(Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;Landroid/view/View;)Z

    move-result p1

    return p1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
