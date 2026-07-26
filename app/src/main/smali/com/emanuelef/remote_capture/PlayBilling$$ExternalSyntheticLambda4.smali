.class public final synthetic Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/activity/result/ActivityResultCallback;
.implements Lcom/emanuelef/remote_capture/WebSocketDecoder$DecodedFrameListener;
.implements Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;
.implements Landroidx/core/view/OnApplyWindowInsetsListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActivityResult(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/PersistableUriPermission;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/PersistableUriPermission;->$r8$lambda$CF-SqVagE681JiZhc8dLTW5sLoI(Lcom/emanuelef/remote_capture/PersistableUriPermission;Landroidx/activity/result/ActivityResult;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureHelper;

    check-cast p1, Landroidx/activity/result/ActivityResult;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/CaptureHelper;->$r8$lambda$u5trzy3g_3XlQ8_N3x0ASxn69y0(Lcom/emanuelef/remote_capture/CaptureHelper;Landroidx/activity/result/ActivityResult;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onApplyWindowInsets(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->f$0:Ljava/lang/Object;

    check-cast v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/Utils;->$r8$lambda$Cg09NPZDSiysDr7NIqowYs-wxLI(Ljava/util/concurrent/atomic/AtomicReference;Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1
.end method

.method public onChunkReassembled(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->f$0:Ljava/lang/Object;

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/HarWriter;->$r8$lambda$ALZOPtD8RuCNncgkHgYxObdhrpw(Ljava/util/ArrayList;Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    return-void
.end method

.method public onQueryPurchasesResponse(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/PlayBilling;

    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/PlayBilling;->$r8$lambda$OPRPgfPXaK_mh8Xb4_9-L5E9oY8(Lcom/emanuelef/remote_capture/PlayBilling;Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V

    return-void
.end method

.method public onWebSocketFrame(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/HTTPReassembly;

    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/HTTPReassembly;->$r8$lambda$k2089ofX84AEKQeLy8_vH6FBrXk(Lcom/emanuelef/remote_capture/HTTPReassembly;Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    return-void
.end method
