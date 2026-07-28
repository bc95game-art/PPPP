.class public final synthetic Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/CaptureService;

.field public final synthetic f$1:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;->f$0:Lcom/emanuelef/remote_capture/CaptureService;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;->f$1:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;->f$0:Lcom/emanuelef/remote_capture/CaptureService;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;->f$1:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$gwgq1c0Ow12pyc2_Mpr37yqdR5M(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;->f$0:Lcom/emanuelef/remote_capture/CaptureService;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;->f$1:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$S61qE7nEsRBU72J2dlY3o9c-nWQ(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
