.class public final synthetic Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

.field public final synthetic f$1:Ljava/lang/String;

.field public final synthetic f$2:I

.field public final synthetic f$3:Z

.field public final synthetic f$4:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

.field public final synthetic f$5:Ljava/lang/String;

.field public final synthetic f$6:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Ljava/lang/String;IZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$1:Ljava/lang/String;

    iput p3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$2:I

    iput-boolean p4, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$3:Z

    iput-object p5, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$4:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    iput-object p6, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$5:Ljava/lang/String;

    iput-object p7, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$6:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 9

    .line 1
    iget-object v5, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$5:Ljava/lang/String;

    iget-object v6, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$6:Ljava/lang/String;

    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$0:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$1:Ljava/lang/String;

    iget v2, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$2:I

    iget-boolean v3, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$3:Z

    iget-object v4, p0, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$$ExternalSyntheticLambda2;->f$4:Lcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;

    move-object v7, p1

    move v8, p2

    invoke-static/range {v0 .. v8}, Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;->$r8$lambda$WvbKXV3jB4b-NU-60nWJ8tGf3uE(Lcom/emanuelef/remote_capture/adapters/PayloadAdapter;Ljava/lang/String;IZLcom/emanuelef/remote_capture/adapters/PayloadAdapter$AdapterChunk;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface;I)V

    return-void
.end method
