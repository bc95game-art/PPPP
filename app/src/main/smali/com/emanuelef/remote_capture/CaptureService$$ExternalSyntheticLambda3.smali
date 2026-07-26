.class public final synthetic Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/CaptureService;

.field public final synthetic f$1:Z


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/CaptureService;Z)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda3;->f$0:Lcom/emanuelef/remote_capture/CaptureService;

    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda3;->f$1:Z

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda3;->f$0:Lcom/emanuelef/remote_capture/CaptureService;

    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda3;->f$1:Z

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$gsYl3MwmKbrXbZZKkFzkVc1yS7o(Lcom/emanuelef/remote_capture/CaptureService;Z)V

    return-void
.end method
