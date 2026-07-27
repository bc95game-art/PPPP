.class public final synthetic Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;

.field public final synthetic f$1:I

.field public final synthetic f$2:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(IILjava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->$r8$classId:I

    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    iput p1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$1:I

    iput-object p4, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/AboutActivity;Landroid/view/View;I)V
    .locals 1

    .line 2
    const/4 v0, 0x2

    iput v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    iput p3, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$1:I

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lcom/emanuelef/remote_capture/activities/AboutActivity;

    .line 9
    .line 10
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast v1, Landroid/view/View;

    .line 13
    .line 14
    iget v2, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$1:I

    .line 15
    .line 16
    invoke-static {v0, v1, v2}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$Q73iX_b_aIifFnz5uXxsK3lgNKQ(Lcom/emanuelef/remote_capture/activities/AboutActivity;Landroid/view/View;I)V

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    .line 21
    .line 22
    check-cast v0, Landroidx/profileinstaller/DeviceProfileWriter;

    .line 23
    .line 24
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    .line 25
    .line 26
    iget-object v0, v0, Landroidx/profileinstaller/DeviceProfileWriter;->mDiagnostics:Landroidx/profileinstaller/ProfileInstaller$DiagnosticsCallback;

    .line 27
    .line 28
    iget v2, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$1:I

    .line 29
    .line 30
    invoke-interface {v0, v2, v1}, Landroidx/profileinstaller/ProfileInstaller$DiagnosticsCallback;->onResultReceived(ILjava/lang/Object;)V

    .line 31
    .line 32
    .line 33
    return-void

    .line 34
    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    .line 35
    .line 36
    check-cast v0, Lcom/emanuelef/remote_capture/CaptureService;

    .line 37
    .line 38
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    .line 39
    .line 40
    check-cast v1, Landroid/app/Notification;

    .line 41
    .line 42
    iget v2, p0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;->f$1:I

    .line 43
    .line 44
    invoke-static {v0, v2, v1}, Lcom/emanuelef/remote_capture/CaptureService;->$r8$lambda$cxNAERnw-DvDvYvWW3S5QgZpiSw(Lcom/emanuelef/remote_capture/CaptureService;ILandroid/app/Notification;)V

    .line 45
    .line 46
    .line 47
    return-void

    .line 48
    nop

    .line 49
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method
