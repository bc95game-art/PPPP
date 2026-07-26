.class public final synthetic Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

.field public final synthetic f$1:[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

.field public final synthetic f$2:I


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;II)V
    .locals 0

    .line 1
    iput p4, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$1:[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    iput p3, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$2:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$1:[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$2:I

    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v2, v0, v1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$5cF8ia8PXqnqRV0KtTRoodE4DLQ(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$1:[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$2:I

    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {v2, v0, v1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$JBbpJOAQZYP70gdFbh4gBtga98s(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
