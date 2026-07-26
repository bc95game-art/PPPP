.class public final synthetic Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->$r8$lambda$j-d6ycCmYTEy9zwO1Zb5m4aNPnU(Lcom/emanuelef/remote_capture/VpnReconnectService$1;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$_Alazbw3pezXDoxDChLwJvt3eRA(Lcom/emanuelef/remote_capture/CaptureService;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$iIi-IbTmrBznc8fIm7NLuEv8-5A(Lcom/emanuelef/remote_capture/CaptureService;)V

    return-void

    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$EqwfYLJ6HPqz3YCybVj1akR4MPw(Lcom/emanuelef/remote_capture/CaptureService;)V

    return-void

    :pswitch_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/CaptureService;->reloadBlocklist()V

    return-void

    :pswitch_4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$OpuoSjshhRR79oizsM9OSGox59E(Lcom/emanuelef/remote_capture/CaptureService;)V

    return-void

    :pswitch_5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$Wn0Xt9R9g-u2fOxGH_YGVKXhtKA(Lcom/emanuelef/remote_capture/CaptureService;)V

    return-void

    :pswitch_6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$TgVAKJnL_N9D6jcUnIOo9Eu2ku4(Lcom/emanuelef/remote_capture/CaptureService;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
