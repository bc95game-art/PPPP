.class Lcom/emanuelef/remote_capture/VpnReconnectService$1;
.super Landroid/net/ConnectivityManager$NetworkCallback;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/emanuelef/remote_capture/VpnReconnectService;->registerNetworkCallbacks()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/VpnReconnectService;

.field final synthetic val$cm:Landroid/net/ConnectivityManager;


# direct methods
.method public static synthetic $r8$lambda$KUkk0H1guUoyPp6m5gbjqgiRTco(Z)V
    .locals 0

    .line 1
    invoke-static {p0}, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->lambda$onLost$0(Z)V

    return-void
.end method

.method public static synthetic $r8$lambda$j-d6ycCmYTEy9zwO1Zb5m4aNPnU(Lcom/emanuelef/remote_capture/VpnReconnectService$1;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->lambda$onLost$1()V

    return-void
.end method

.method public constructor <init>(Lcom/emanuelef/remote_capture/VpnReconnectService;Landroid/net/ConnectivityManager;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->this$0:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 2
    .line 3
    iput-object p2, p0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->val$cm:Landroid/net/ConnectivityManager;

    .line 4
    .line 5
    invoke-direct {p0}, Landroid/net/ConnectivityManager$NetworkCallback;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method

.method private static synthetic lambda$onLost$0(Z)V
    .locals 0

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->stopService()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method private synthetic lambda$onLost$1()V
    .locals 4

    .line 1
    const-string v0, "VpnReconnectService"

    .line 2
    .line 3
    const-string v1, "Active VPN disconnected, starting the capture"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->this$0:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 9
    .line 10
    invoke-static {v0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->-$$Nest$munregisterNetworkCallback(Lcom/emanuelef/remote_capture/VpnReconnectService;)V

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->this$0:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 14
    .line 15
    new-instance v1, Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 16
    .line 17
    invoke-static {v0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    .line 18
    .line 19
    .line 20
    move-result-object v2

    .line 21
    invoke-direct {v1, v0, v2}, Lcom/emanuelef/remote_capture/model/CaptureSettings;-><init>(Landroid/content/Context;Landroid/content/SharedPreferences;)V

    .line 22
    .line 23
    .line 24
    new-instance v2, Lcom/emanuelef/remote_capture/CaptureHelper;

    .line 25
    .line 26
    invoke-direct {v2, v0}, Lcom/emanuelef/remote_capture/CaptureHelper;-><init>(Landroid/content/Context;)V

    .line 27
    .line 28
    .line 29
    new-instance v0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda15;

    .line 30
    .line 31
    const/4 v3, 0x1

    .line 32
    invoke-direct {v0, v3}, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda15;-><init>(I)V

    .line 33
    .line 34
    .line 35
    invoke-virtual {v2, v0}, Lcom/emanuelef/remote_capture/CaptureHelper;->setListener(Lcom/emanuelef/remote_capture/interfaces/CaptureStartListener;)V

    .line 36
    .line 37
    .line 38
    invoke-virtual {v2, v1}, Lcom/emanuelef/remote_capture/CaptureHelper;->startCapture(Lcom/emanuelef/remote_capture/model/CaptureSettings;)V

    .line 39
    .line 40
    .line 41
    return-void
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
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


# virtual methods
.method public onAvailable(Landroid/net/Network;)V
    .locals 2

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "onAvailable: "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 9
    .line 10
    .line 11
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    const-string v1, "VpnReconnectService"

    .line 16
    .line 17
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    iget-object v0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->this$0:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 21
    .line 22
    iget-object v1, p0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->val$cm:Landroid/net/ConnectivityManager;

    .line 23
    .line 24
    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/VpnReconnectService;->-$$Nest$mcheckAvailableNetwork(Lcom/emanuelef/remote_capture/VpnReconnectService;Landroid/net/ConnectivityManager;Landroid/net/Network;)V

    .line 25
    .line 26
    .line 27
    return-void
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public onLost(Landroid/net/Network;)V
    .locals 3

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "onLost: "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 9
    .line 10
    .line 11
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    const-string v1, "VpnReconnectService"

    .line 16
    .line 17
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    iget-object v0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->this$0:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 21
    .line 22
    invoke-static {v0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->-$$Nest$fgetmActiveVpnNetwork(Lcom/emanuelef/remote_capture/VpnReconnectService;)Landroid/net/Network;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    invoke-virtual {p1, v0}, Landroid/net/Network;->equals(Ljava/lang/Object;)Z

    .line 27
    .line 28
    .line 29
    move-result p1

    .line 30
    if-eqz p1, :cond_0

    .line 31
    .line 32
    iget-object p1, p0, Lcom/emanuelef/remote_capture/VpnReconnectService$1;->this$0:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 33
    .line 34
    invoke-static {p1}, Lcom/emanuelef/remote_capture/VpnReconnectService;->-$$Nest$fgetmHandler(Lcom/emanuelef/remote_capture/VpnReconnectService;)Landroid/os/Handler;

    .line 35
    .line 36
    .line 37
    move-result-object p1

    .line 38
    new-instance v0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;

    .line 39
    .line 40
    const/4 v1, 0x7

    .line 41
    invoke-direct {v0, v1, p0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 42
    .line 43
    .line 44
    const-wide/16 v1, 0xbb8

    .line 45
    .line 46
    invoke-virtual {p1, v0, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 47
    .line 48
    .line 49
    :cond_0
    return-void
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method
