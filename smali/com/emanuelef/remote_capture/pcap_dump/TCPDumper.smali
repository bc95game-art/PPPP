.class public Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/PcapDumper;


# static fields
.field private static final TAG:Ljava/lang/String; = "TCPDumper"


# instance fields
.field private mDataOut:Ljava/io/DataOutputStream;

.field private final mPcapngFormat:Z

.field private mSendHeader:Z

.field private final mServer:Ljava/net/InetSocketAddress;

.field private mSocket:Ljava/net/Socket;


# direct methods
.method public constructor <init>(Ljava/net/InetSocketAddress;Z)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mServer:Ljava/net/InetSocketAddress;

    .line 5
    .line 6
    const/4 p1, 0x1

    .line 7
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSendHeader:Z

    .line 8
    .line 9
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mPcapngFormat:Z

    .line 10
    .line 11
    return-void
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


# virtual methods
.method public dumpData([B)V
    .locals 4

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSendHeader:Z

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    iput-boolean v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSendHeader:Z

    .line 7
    .line 8
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getPcapHeader()[B

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    iget-object v2, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mDataOut:Ljava/io/DataOutputStream;

    .line 13
    .line 14
    invoke-virtual {v2, v0}, Ljava/io/OutputStream;->write([B)V

    .line 15
    .line 16
    .line 17
    :cond_0
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mPcapngFormat:Z

    .line 18
    .line 19
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/Utils;->iterPcapRecords([BZ)Ljava/util/Iterator;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 24
    .line 25
    .line 26
    move-result v2

    .line 27
    if-eqz v2, :cond_1

    .line 28
    .line 29
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 30
    .line 31
    .line 32
    move-result-object v2

    .line 33
    check-cast v2, Ljava/lang/Integer;

    .line 34
    .line 35
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    .line 36
    .line 37
    .line 38
    move-result v2

    .line 39
    iget-object v3, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mDataOut:Ljava/io/DataOutputStream;

    .line 40
    .line 41
    invoke-virtual {v3, p1, v1, v2}, Ljava/io/DataOutputStream;->write([BII)V

    .line 42
    .line 43
    .line 44
    add-int/2addr v1, v2

    .line 45
    goto :goto_0

    .line 46
    :cond_1
    return-void
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

.method public getBpf()Ljava/lang/String;
    .locals 2

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "not (host "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mServer:Ljava/net/InetSocketAddress;

    .line 9
    .line 10
    invoke-virtual {v1}, Ljava/net/InetSocketAddress;->getAddress()Ljava/net/InetAddress;

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    invoke-virtual {v1}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 19
    .line 20
    .line 21
    const-string v1, " and tcp port "

    .line 22
    .line 23
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 24
    .line 25
    .line 26
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mServer:Ljava/net/InetSocketAddress;

    .line 27
    .line 28
    invoke-virtual {v1}, Ljava/net/InetSocketAddress;->getPort()I

    .line 29
    .line 30
    .line 31
    move-result v1

    .line 32
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 33
    .line 34
    .line 35
    const-string v1, ")"

    .line 36
    .line 37
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 38
    .line 39
    .line 40
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 41
    .line 42
    .line 43
    move-result-object v0

    .line 44
    return-object v0
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

.method public startDumper()V
    .locals 3

    .line 1
    new-instance v0, Ljava/net/Socket;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/net/Socket;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSocket:Ljava/net/Socket;

    .line 7
    .line 8
    :try_start_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mServer:Ljava/net/InetSocketAddress;

    .line 9
    .line 10
    const/16 v2, 0x3e8

    .line 11
    .line 12
    invoke-virtual {v0, v1, v2}, Ljava/net/Socket;->connect(Ljava/net/SocketAddress;I)V

    .line 13
    .line 14
    .line 15
    new-instance v0, Ljava/io/DataOutputStream;

    .line 16
    .line 17
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSocket:Ljava/net/Socket;

    .line 18
    .line 19
    invoke-virtual {v1}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    .line 20
    .line 21
    .line 22
    move-result-object v1

    .line 23
    invoke-direct {v0, v1}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 24
    .line 25
    .line 26
    iput-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mDataOut:Ljava/io/DataOutputStream;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 27
    .line 28
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->requireInstance()Lcom/emanuelef/remote_capture/CaptureService;

    .line 29
    .line 30
    .line 31
    move-result-object v0

    .line 32
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSocket:Ljava/net/Socket;

    .line 33
    .line 34
    invoke-virtual {v0, v1}, Landroid/net/VpnService;->protect(Ljava/net/Socket;)Z

    .line 35
    .line 36
    .line 37
    return-void

    .line 38
    :catchall_0
    move-exception v0

    .line 39
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSocket:Ljava/net/Socket;

    .line 40
    .line 41
    invoke-virtual {v1}, Ljava/net/Socket;->close()V

    .line 42
    .line 43
    .line 44
    throw v0
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

.method public stopDumper()V
    .locals 2

    .line 1
    :try_start_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mDataOut:Ljava/io/DataOutputStream;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSocket:Ljava/net/Socket;

    .line 7
    .line 8
    invoke-virtual {v0}, Ljava/net/Socket;->close()V

    .line 9
    .line 10
    .line 11
    return-void

    .line 12
    :catchall_0
    move-exception v0

    .line 13
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;->mSocket:Ljava/net/Socket;

    .line 14
    .line 15
    invoke-virtual {v1}, Ljava/net/Socket;->close()V

    .line 16
    .line 17
    .line 18
    throw v0
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
.end method
