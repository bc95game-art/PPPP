.class Lcom/emanuelef/remote_capture/MitmAddon$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/MitmAddon;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/MitmAddon;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/MitmAddon;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
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


# virtual methods
.method public onBindingDied(Landroid/content/ComponentName;)V
    .locals 1

    .line 1
    const-string p1, "MitmAddon"

    .line 2
    .line 3
    const-string v0, "onBindingDied"

    .line 4
    .line 5
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 9
    .line 10
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->disconnect()V

    .line 11
    .line 12
    .line 13
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 14
    .line 15
    invoke-static {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->-$$Nest$fgetmReceiver(Lcom/emanuelef/remote_capture/MitmAddon;)Lcom/emanuelef/remote_capture/interfaces/MitmListener;

    .line 16
    .line 17
    .line 18
    move-result-object p1

    .line 19
    invoke-interface {p1}, Lcom/emanuelef/remote_capture/interfaces/MitmListener;->onMitmServiceDisconnect()V

    .line 20
    .line 21
    .line 22
    return-void
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

.method public onNullBinding(Landroid/content/ComponentName;)V
    .locals 1

    .line 1
    const-string p1, "MitmAddon"

    .line 2
    .line 3
    const-string v0, "onNullBinding"

    .line 4
    .line 5
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 9
    .line 10
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->disconnect()V

    .line 11
    .line 12
    .line 13
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 14
    .line 15
    invoke-static {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->-$$Nest$fgetmReceiver(Lcom/emanuelef/remote_capture/MitmAddon;)Lcom/emanuelef/remote_capture/interfaces/MitmListener;

    .line 16
    .line 17
    .line 18
    move-result-object p1

    .line 19
    invoke-interface {p1}, Lcom/emanuelef/remote_capture/interfaces/MitmListener;->onMitmServiceDisconnect()V

    .line 20
    .line 21
    .line 22
    return-void
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

.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 1

    .line 1
    const-string p1, "MitmAddon"

    .line 2
    .line 3
    const-string v0, "Service connected"

    .line 4
    .line 5
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 9
    .line 10
    new-instance v0, Landroid/os/Messenger;

    .line 11
    .line 12
    invoke-direct {v0, p2}, Landroid/os/Messenger;-><init>(Landroid/os/IBinder;)V

    .line 13
    .line 14
    .line 15
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/MitmAddon;->-$$Nest$fputmService(Lcom/emanuelef/remote_capture/MitmAddon;Landroid/os/Messenger;)V

    .line 16
    .line 17
    .line 18
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 19
    .line 20
    invoke-static {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->-$$Nest$fgetmStopRequested(Lcom/emanuelef/remote_capture/MitmAddon;)Z

    .line 21
    .line 22
    .line 23
    move-result p1

    .line 24
    if-eqz p1, :cond_0

    .line 25
    .line 26
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 27
    .line 28
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->stopProxy()Z

    .line 29
    .line 30
    .line 31
    return-void

    .line 32
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 33
    .line 34
    invoke-static {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->-$$Nest$fgetmReceiver(Lcom/emanuelef/remote_capture/MitmAddon;)Lcom/emanuelef/remote_capture/interfaces/MitmListener;

    .line 35
    .line 36
    .line 37
    move-result-object p1

    .line 38
    invoke-interface {p1}, Lcom/emanuelef/remote_capture/interfaces/MitmListener;->onMitmServiceConnect()V

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

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 1

    .line 1
    const-string p1, "MitmAddon"

    .line 2
    .line 3
    const-string v0, "Service disconnected"

    .line 4
    .line 5
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 9
    .line 10
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->disconnect()V

    .line 11
    .line 12
    .line 13
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmAddon$1;->this$0:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 14
    .line 15
    invoke-static {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->-$$Nest$fgetmReceiver(Lcom/emanuelef/remote_capture/MitmAddon;)Lcom/emanuelef/remote_capture/interfaces/MitmListener;

    .line 16
    .line 17
    .line 18
    move-result-object p1

    .line 19
    invoke-interface {p1}, Lcom/emanuelef/remote_capture/interfaces/MitmListener;->onMitmServiceDisconnect()V

    .line 20
    .line 21
    .line 22
    return-void
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
