.class public final synthetic Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

.field public final synthetic f$1:Z

.field public final synthetic f$2:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

.field public final synthetic f$3:I


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;ZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;->f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;->f$1:Z

    iput-object p3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;->f$2:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    iput p4, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;->f$3:I

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 6

    .line 1
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;->f$2:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    iget v3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;->f$3:I

    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;->f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda5;->f$1:Z

    move-object v4, p1

    move v5, p2

    invoke-static/range {v0 .. v5}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->$r8$lambda$ZhEvm2neRYXjbP5NcNZUC6OnbLw(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;ZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;ILandroid/content/DialogInterface;I)V

    return-void
.end method
