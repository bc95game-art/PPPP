.class public final synthetic Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# instance fields
.field public final synthetic f$0:[Z

.field public final synthetic f$1:Ljava/util/concurrent/ExecutorService;


# direct methods
.method public synthetic constructor <init>([ZLjava/util/concurrent/ExecutorService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$$ExternalSyntheticLambda5;->f$0:[Z

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$$ExternalSyntheticLambda5;->f$1:Ljava/util/concurrent/ExecutorService;

    return-void
.end method


# virtual methods
.method public final onCancel(Landroid/content/DialogInterface;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$$ExternalSyntheticLambda5;->f$0:[Z

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$$ExternalSyntheticLambda5;->f$1:Ljava/util/concurrent/ExecutorService;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->$r8$lambda$U86RnpnMu7sSuWVmZgQmcecjt-g([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V

    return-void
.end method
