.class public final synthetic Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I


# direct methods
.method public synthetic constructor <init>(I)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->$r8$lambda$f9fKmzI4JxapiF2h0Nv2wbEaUkI()V

    return-void

    :pswitch_0
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$izuw-LD2dmrxMcoSkejqztmTfDA()V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
