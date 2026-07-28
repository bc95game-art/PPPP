.class public Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/PcapDumper;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;,
        Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;
    }
.end annotation


# static fields
.field public static final MAX_CLIENTS:I = 0x8

.field private static final PCAPNG_MIME:Ljava/lang/String; = "application/x-pcapng"

.field private static final PCAP_MIME:Ljava/lang/String; = "application/vnd.tcpdump.pcap"

.field private static final TAG:Ljava/lang/String; = "HTTPServer"


# instance fields
.field private final mClients:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;",
            ">;"
        }
    .end annotation
.end field

.field private final mContext:Landroid/content/Context;

.field private final mMimeType:Ljava/lang/String;

.field private final mPcapngFormat:Z

.field private final mPort:I

.field private mRunning:Z

.field private mSocket:Ljava/net/ServerSocket;

.field private mThread:Ljava/lang/Thread;


# direct methods
.method public constructor <init>(Landroid/content/Context;IZ)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mClients:Ljava/util/ArrayList;

    .line 10
    .line 11
    iput p2, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mPort:I

    .line 12
    .line 13
    iput-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mContext:Landroid/content/Context;

    .line 14
    .line 15
    iput-boolean p3, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mPcapngFormat:Z

    .line 16
    .line 17
    if-eqz p3, :cond_0

    .line 18
    .line 19
    const-string p1, "application/x-pcapng"

    .line 20
    .line 21
    goto :goto_0

    .line 22
    :cond_0
    const-string p1, "application/vnd.tcpdump.pcap"

    .line 23
    .line 24
    :goto_0
    iput-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mMimeType:Ljava/lang/String;

    .line 25
    .line 26
    return-void
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
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
.end method


# virtual methods
.method public dumpData([B)V
    .locals 4

    .line 1
    monitor-enter p0

    .line 2
    :try_start_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mClients:Ljava/util/ArrayList;

    .line 3
    .line 4
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 9
    .line 10
    .line 11
    move-result v1

    .line 12
    if-eqz v1, :cond_2

    .line 13
    .line 14
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    check-cast v1, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;

    .line 19
    .line 20
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->isReadyForData()Z

    .line 21
    .line 22
    .line 23
    move-result v2

    .line 24
    if-eqz v2, :cond_1

    .line 25
    .line 26
    invoke-virtual {v1, p1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->sendChunk([B)V

    .line 27
    .line 28
    .line 29
    goto :goto_1

    .line 30
    :catchall_0
    move-exception p1

    .line 31
    goto :goto_2

    .line 32
    :cond_1
    :goto_1
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->isClosed()Z

    .line 33
    .line 34
    .line 35
    move-result v1

    .line 36
    if-eqz v1, :cond_0

    .line 37
    .line 38
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 39
    .line 40
    .line 41
    const-string v1, "HTTPServer"

    .line 42
    .line 43
    new-instance v2, Ljava/lang/StringBuilder;

    .line 44
    .line 45
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 46
    .line 47
    .line 48
    const-string v3, "Client closed, active clients: "

    .line 49
    .line 50
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    iget-object v3, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mClients:Ljava/util/ArrayList;

    .line 54
    .line 55
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 56
    .line 57
    .line 58
    move-result v3

    .line 59
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 60
    .line 61
    .line 62
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 63
    .line 64
    .line 65
    move-result-object v2

    .line 66
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    .line 68
    .line 69
    goto :goto_0

    .line 70
    :cond_2
    monitor-exit p0

    .line 71
    return-void

    .line 72
    :goto_2
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 73
    throw p1
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
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
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
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mContext:Landroid/content/Context;

    .line 9
    .line 10
    invoke-static {v1}, Lcom/emanuelef/remote_capture/Utils;->getLocalIPAddress(Landroid/content/Context;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 15
    .line 16
    .line 17
    const-string v1, " and tcp port "

    .line 18
    .line 19
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 20
    .line 21
    .line 22
    iget v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mPort:I

    .line 23
    .line 24
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 25
    .line 26
    .line 27
    const-string v1, ")"

    .line 28
    .line 29
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 30
    .line 31
    .line 32
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 33
    .line 34
    .line 35
    move-result-object v0

    .line 36
    return-object v0
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

.method public run()V
    .locals 7

    .line 1
    const/16 v0, 0x8

    .line 2
    .line 3
    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    :goto_0
    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mRunning:Z

    .line 8
    .line 9
    if-eqz v2, :cond_2

    .line 10
    .line 11
    :try_start_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mSocket:Ljava/net/ServerSocket;

    .line 12
    .line 13
    invoke-virtual {v2}, Ljava/net/ServerSocket;->accept()Ljava/net/Socket;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    monitor-enter p0
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 18
    :try_start_1
    iget-object v3, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mClients:Ljava/util/ArrayList;

    .line 19
    .line 20
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 21
    .line 22
    .line 23
    move-result v3

    .line 24
    if-lt v3, v0, :cond_0

    .line 25
    .line 26
    const-string v3, "HTTPServer"

    .line 27
    .line 28
    const-string v4, "Clients limit reached"

    .line 29
    .line 30
    invoke-static {v3, v4}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    .line 32
    .line 33
    invoke-static {v2}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 34
    .line 35
    .line 36
    monitor-exit p0

    .line 37
    goto :goto_0

    .line 38
    :catchall_0
    move-exception v2

    .line 39
    goto :goto_1

    .line 40
    :cond_0
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 41
    :try_start_2
    const-string v3, "HTTPServer"

    .line 42
    .line 43
    new-instance v4, Ljava/lang/StringBuilder;

    .line 44
    .line 45
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 46
    .line 47
    .line 48
    const-string v5, "New client: "

    .line 49
    .line 50
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    invoke-virtual {v2}, Ljava/net/Socket;->getInetAddress()Ljava/net/InetAddress;

    .line 54
    .line 55
    .line 56
    move-result-object v5

    .line 57
    invoke-virtual {v5}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    .line 58
    .line 59
    .line 60
    move-result-object v5

    .line 61
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 62
    .line 63
    .line 64
    const-string v5, ":"

    .line 65
    .line 66
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 67
    .line 68
    .line 69
    invoke-virtual {v2}, Ljava/net/Socket;->getPort()I

    .line 70
    .line 71
    .line 72
    move-result v5

    .line 73
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 74
    .line 75
    .line 76
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 77
    .line 78
    .line 79
    move-result-object v4

    .line 80
    invoke-static {v3, v4}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    .line 82
    .line 83
    new-instance v3, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;

    .line 84
    .line 85
    iget-object v4, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mMimeType:Ljava/lang/String;

    .line 86
    .line 87
    iget-object v5, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mContext:Landroid/content/Context;

    .line 88
    .line 89
    iget-boolean v6, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mPcapngFormat:Z

    .line 90
    .line 91
    invoke-static {v5, v6}, Lcom/emanuelef/remote_capture/Utils;->getUniquePcapFileName(Landroid/content/Context;Z)Ljava/lang/String;

    .line 92
    .line 93
    .line 94
    move-result-object v5

    .line 95
    invoke-direct {v3, v2, v4, v5}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;-><init>(Ljava/net/Socket;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 96
    .line 97
    .line 98
    :try_start_3
    invoke-interface {v1, v3}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    .line 99
    .line 100
    .line 101
    monitor-enter p0
    :try_end_3
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    .line 102
    :try_start_4
    iget-object v4, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mClients:Ljava/util/ArrayList;

    .line 103
    .line 104
    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 105
    .line 106
    .line 107
    monitor-exit p0

    .line 108
    goto :goto_0

    .line 109
    :catchall_1
    move-exception v3

    .line 110
    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 111
    :try_start_5
    throw v3
    :try_end_5
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    .line 112
    :catch_0
    move-exception v2

    .line 113
    goto :goto_2

    .line 114
    :catch_1
    move-exception v3

    .line 115
    :try_start_6
    const-string v4, "HTTPServer"

    .line 116
    .line 117
    invoke-virtual {v3}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    .line 118
    .line 119
    .line 120
    move-result-object v3

    .line 121
    invoke-static {v4, v3}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    .line 123
    .line 124
    invoke-static {v2}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0

    .line 125
    .line 126
    .line 127
    goto :goto_0

    .line 128
    :goto_1
    :try_start_7
    monitor-exit p0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 129
    :try_start_8
    throw v2
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_0

    .line 130
    :goto_2
    iget-boolean v3, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mRunning:Z

    .line 131
    .line 132
    if-nez v3, :cond_1

    .line 133
    .line 134
    const-string v2, "HTTPServer"

    .line 135
    .line 136
    const-string v3, "Got termination request"

    .line 137
    .line 138
    invoke-static {v2, v3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    .line 140
    .line 141
    goto/16 :goto_0

    .line 142
    .line 143
    :cond_1
    const-string v3, "HTTPServer"

    .line 144
    .line 145
    invoke-virtual {v2}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    .line 146
    .line 147
    .line 148
    move-result-object v2

    .line 149
    invoke-static {v3, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    .line 151
    .line 152
    goto/16 :goto_0

    .line 153
    .line 154
    :cond_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mSocket:Ljava/net/ServerSocket;

    .line 155
    .line 156
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 157
    .line 158
    .line 159
    invoke-interface {v1}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    .line 160
    .line 161
    .line 162
    monitor-enter p0

    .line 163
    :try_start_9
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mClients:Ljava/util/ArrayList;

    .line 164
    .line 165
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 166
    .line 167
    .line 168
    move-result v2

    .line 169
    const/4 v3, 0x0

    .line 170
    const/4 v4, 0x0

    .line 171
    :cond_3
    :goto_3
    if-ge v4, v2, :cond_4

    .line 172
    .line 173
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 174
    .line 175
    .line 176
    move-result-object v5

    .line 177
    add-int/lit8 v4, v4, 0x1

    .line 178
    .line 179
    check-cast v5, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;

    .line 180
    .line 181
    invoke-virtual {v5}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->isReadyForData()Z

    .line 182
    .line 183
    .line 184
    move-result v6

    .line 185
    if-nez v6, :cond_3

    .line 186
    .line 187
    invoke-virtual {v5}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->stop()V

    .line 188
    .line 189
    .line 190
    goto :goto_3

    .line 191
    :catchall_2
    move-exception v0

    .line 192
    goto :goto_6

    .line 193
    :cond_4
    monitor-exit p0
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    .line 194
    :catch_2
    :cond_5
    :try_start_a
    sget-object v0, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    .line 195
    .line 196
    const-wide v4, 0x7fffffffffffffffL

    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    invoke-interface {v1, v4, v5, v0}, Ljava/util/concurrent/ExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    .line 202
    .line 203
    .line 204
    move-result v0
    :try_end_a
    .catch Ljava/lang/InterruptedException; {:try_start_a .. :try_end_a} :catch_2

    .line 205
    if-eqz v0, :cond_5

    .line 206
    .line 207
    monitor-enter p0

    .line 208
    :try_start_b
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mClients:Ljava/util/ArrayList;

    .line 209
    .line 210
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 211
    .line 212
    .line 213
    move-result v1

    .line 214
    :cond_6
    :goto_4
    if-ge v3, v1, :cond_7

    .line 215
    .line 216
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 217
    .line 218
    .line 219
    move-result-object v2

    .line 220
    add-int/lit8 v3, v3, 0x1

    .line 221
    .line 222
    check-cast v2, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;

    .line 223
    .line 224
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->isClosed()Z

    .line 225
    .line 226
    .line 227
    move-result v4

    .line 228
    if-nez v4, :cond_6

    .line 229
    .line 230
    invoke-static {v2}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->-$$Nest$mclose(Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;)V

    .line 231
    .line 232
    .line 233
    goto :goto_4

    .line 234
    :catchall_3
    move-exception v0

    .line 235
    goto :goto_5

    .line 236
    :cond_7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mClients:Ljava/util/ArrayList;

    .line 237
    .line 238
    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 239
    .line 240
    .line 241
    monitor-exit p0

    .line 242
    return-void

    .line 243
    :goto_5
    monitor-exit p0
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_3

    .line 244
    throw v0

    .line 245
    :goto_6
    :try_start_c
    monitor-exit p0
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_2

    .line 246
    throw v0
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
.end method

.method public startDumper()V
    .locals 4

    .line 1
    new-instance v0, Ljava/net/ServerSocket;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/net/ServerSocket;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mSocket:Ljava/net/ServerSocket;

    .line 7
    .line 8
    const/4 v1, 0x1

    .line 9
    invoke-virtual {v0, v1}, Ljava/net/ServerSocket;->setReuseAddress(Z)V

    .line 10
    .line 11
    .line 12
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mSocket:Ljava/net/ServerSocket;

    .line 13
    .line 14
    new-instance v2, Ljava/net/InetSocketAddress;

    .line 15
    .line 16
    iget v3, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mPort:I

    .line 17
    .line 18
    invoke-direct {v2, v3}, Ljava/net/InetSocketAddress;-><init>(I)V

    .line 19
    .line 20
    .line 21
    invoke-virtual {v0, v2}, Ljava/net/ServerSocket;->bind(Ljava/net/SocketAddress;)V

    .line 22
    .line 23
    .line 24
    iput-boolean v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mRunning:Z

    .line 25
    .line 26
    new-instance v0, Ljava/lang/Thread;

    .line 27
    .line 28
    invoke-direct {v0, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 29
    .line 30
    .line 31
    iput-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mThread:Ljava/lang/Thread;

    .line 32
    .line 33
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 34
    .line 35
    .line 36
    return-void
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

.method public stopDumper()V
    .locals 2

    .line 1
    const/4 v0, 0x0

    .line 2
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mRunning:Z

    .line 3
    .line 4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mSocket:Ljava/net/ServerSocket;

    .line 5
    .line 6
    invoke-virtual {v0}, Ljava/net/ServerSocket;->close()V

    .line 7
    .line 8
    .line 9
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mThread:Ljava/lang/Thread;

    .line 10
    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    invoke-virtual {v0}, Ljava/lang/Thread;->isAlive()Z

    .line 14
    .line 15
    .line 16
    move-result v0

    .line 17
    if-eqz v0, :cond_0

    .line 18
    .line 19
    :try_start_0
    const-string v0, "HTTPServer"

    .line 20
    .line 21
    const-string v1, "Joining HTTP thread..."

    .line 22
    .line 23
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    .line 25
    .line 26
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;->mThread:Ljava/lang/Thread;

    .line 27
    .line 28
    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 29
    .line 30
    .line 31
    goto :goto_0

    .line 32
    :catch_0
    nop

    .line 33
    goto :goto_0

    .line 34
    :cond_0
    return-void
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
