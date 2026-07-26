.class public Lcom/emanuelef/remote_capture/MitmReceiver;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;
.implements Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;
.implements Lcom/emanuelef/remote_capture/interfaces/MitmListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/MitmReceiver$Status;,
        Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;,
        Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "MitmReceiver"

.field public static final TLS_DECRYPTION_PROXY_PORT:I = 0x1e64

.field private static final proxyStatus:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData;"
        }
    .end annotation
.end field


# instance fields
.field private final mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

.field private final mConfig:Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;

.field private final mContext:Landroid/content/Context;

.field private mKeylog:Ljava/io/BufferedOutputStream;

.field private final mPcapngFormat:Z

.field private final mPendingMessages:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mPortToConnId:Landroid/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/LruCache<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final mReg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

.field private final mRootCapture:Z

.field private mSocketFd:Landroid/os/ParcelFileDescriptor;

.field private mThread:Ljava/lang/Thread;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    .line 2
    .line 3
    sget-object v1, Lcom/emanuelef/remote_capture/MitmReceiver$Status;->NOT_STARTED:Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 4
    .line 5
    invoke-direct {v0, v1}, Landroidx/lifecycle/LiveData;-><init>(Lcom/emanuelef/remote_capture/MitmReceiver$Status;)V

    .line 6
    .line 7
    .line 8
    sput-object v0, Lcom/emanuelef/remote_capture/MitmReceiver;->proxyStatus:Landroidx/lifecycle/MutableLiveData;

    .line 9
    .line 10
    return-void
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
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/CaptureSettings;Ljava/lang/String;)V
    .locals 3

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Landroid/util/LruCache;

    .line 5
    .line 6
    const/16 v1, 0x40

    .line 7
    .line 8
    invoke-direct {v0, v1}, Landroid/util/LruCache;-><init>(I)V

    .line 9
    .line 10
    .line 11
    iput-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPortToConnId:Landroid/util/LruCache;

    .line 12
    .line 13
    new-instance v0, Landroid/util/SparseArray;

    .line 14
    .line 15
    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    .line 16
    .line 17
    .line 18
    iput-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 19
    .line 20
    iput-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 21
    .line 22
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->requireConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    iput-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mReg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 27
    .line 28
    new-instance v0, Lcom/emanuelef/remote_capture/MitmAddon;

    .line 29
    .line 30
    invoke-direct {v0, p1, p0}, Lcom/emanuelef/remote_capture/MitmAddon;-><init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/interfaces/MitmListener;)V

    .line 31
    .line 32
    .line 33
    iput-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 34
    .line 35
    iget-boolean v0, p2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcapng_format:Z

    .line 36
    .line 37
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPcapngFormat:Z

    .line 38
    .line 39
    iget-boolean v0, p2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 40
    .line 41
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mRootCapture:Z

    .line 42
    .line 43
    new-instance v0, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;

    .line 44
    .line 45
    invoke-direct {v0}, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;-><init>()V

    .line 46
    .line 47
    .line 48
    iput-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mConfig:Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;

    .line 49
    .line 50
    const/16 v1, 0x1e64

    .line 51
    .line 52
    iput v1, v0, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;->proxyPort:I

    .line 53
    .line 54
    iput-object p3, v0, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;->proxyAuth:Ljava/lang/String;

    .line 55
    .line 56
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getDumpMode()Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 57
    .line 58
    .line 59
    move-result-object p3

    .line 60
    sget-object v1, Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;->NONE:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 61
    .line 62
    const/4 v2, 0x1

    .line 63
    if-eq p3, v1, :cond_0

    .line 64
    .line 65
    const/4 p3, 0x1

    .line 66
    goto :goto_0

    .line 67
    :cond_0
    const/4 p3, 0x0

    .line 68
    :goto_0
    iput-boolean p3, v0, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;->dumpMasterSecrets:Z

    .line 69
    .line 70
    iget-object p3, p2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->mitmproxy_opts:Ljava/lang/String;

    .line 71
    .line 72
    iput-object p3, v0, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;->additionalOptions:Ljava/lang/String;

    .line 73
    .line 74
    iget-boolean p3, p2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->full_payload:Z

    .line 75
    .line 76
    xor-int/2addr p3, v2

    .line 77
    iput-boolean p3, v0, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;->shortPayload:Z

    .line 78
    .line 79
    iput-boolean v2, v0, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;->sslInsecure:Z

    .line 80
    .line 81
    iget-boolean p2, p2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 82
    .line 83
    iput-boolean p2, v0, Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;->transparentMode:Z

    .line 84
    .line 85
    invoke-static {p1}, Lcom/emanuelef/remote_capture/MitmReceiver;->getKeylogFilePath(Landroid/content/Context;)Ljava/io/File;

    .line 86
    .line 87
    .line 88
    move-result-object p1

    .line 89
    invoke-virtual {p1}, Ljava/io/File;->delete()Z

    .line 90
    .line 91
    .line 92
    return-void
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

.method private declared-synchronized addPendingMessage(Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;)V
    .locals 9

    .line 1
    monitor-enter p0

    .line 2
    :try_start_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 3
    .line 4
    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    const/16 v1, 0x20

    .line 9
    .line 10
    if-le v0, v1, :cond_1

    .line 11
    .line 12
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    .line 13
    .line 14
    .line 15
    move-result-wide v0

    .line 16
    iget-object v2, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 17
    .line 18
    invoke-virtual {v2}, Landroid/util/SparseArray;->size()I

    .line 19
    .line 20
    .line 21
    move-result v2

    .line 22
    add-int/lit8 v2, v2, -0x1

    .line 23
    .line 24
    :goto_0
    if-ltz v2, :cond_1

    .line 25
    .line 26
    iget-object v3, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 27
    .line 28
    invoke-virtual {v3, v2}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    .line 29
    .line 30
    .line 31
    move-result-object v3

    .line 32
    check-cast v3, Ljava/util/ArrayList;

    .line 33
    .line 34
    const/4 v4, 0x0

    .line 35
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 36
    .line 37
    .line 38
    move-result-object v4

    .line 39
    check-cast v4, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;

    .line 40
    .line 41
    iget-wide v4, v4, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;->pendingSince:J

    .line 42
    .line 43
    sub-long v4, v0, v4

    .line 44
    .line 45
    const-wide/16 v6, 0x1388

    .line 46
    .line 47
    cmp-long v8, v4, v6

    .line 48
    .line 49
    if-lez v8, :cond_0

    .line 50
    .line 51
    const-string v4, "MitmReceiver"

    .line 52
    .line 53
    new-instance v5, Ljava/lang/StringBuilder;

    .line 54
    .line 55
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 56
    .line 57
    .line 58
    const-string v6, "Dropping "

    .line 59
    .line 60
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 61
    .line 62
    .line 63
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 64
    .line 65
    .line 66
    move-result v3

    .line 67
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 68
    .line 69
    .line 70
    const-string v3, " old messages"

    .line 71
    .line 72
    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 73
    .line 74
    .line 75
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object v3

    .line 79
    invoke-static {v4, v3}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    .line 81
    .line 82
    iget-object v3, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 83
    .line 84
    invoke-virtual {v3, v2}, Landroid/util/SparseArray;->keyAt(I)I

    .line 85
    .line 86
    .line 87
    move-result v4

    .line 88
    invoke-virtual {v3, v4}, Landroid/util/SparseArray;->remove(I)V

    .line 89
    .line 90
    .line 91
    goto :goto_1

    .line 92
    :catchall_0
    move-exception p1

    .line 93
    goto :goto_3

    .line 94
    :cond_0
    :goto_1
    add-int/lit8 v2, v2, -0x1

    .line 95
    .line 96
    goto :goto_0

    .line 97
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 98
    .line 99
    iget v1, p1, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;->port:I

    .line 100
    .line 101
    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->indexOfKey(I)I

    .line 102
    .line 103
    .line 104
    move-result v0

    .line 105
    if-gez v0, :cond_2

    .line 106
    .line 107
    new-instance v0, Ljava/util/ArrayList;

    .line 108
    .line 109
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 110
    .line 111
    .line 112
    iget-object v1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 113
    .line 114
    iget v2, p1, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;->port:I

    .line 115
    .line 116
    invoke-virtual {v1, v2, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 117
    .line 118
    .line 119
    goto :goto_2

    .line 120
    :cond_2
    iget-object v1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 121
    .line 122
    invoke-virtual {v1, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    .line 123
    .line 124
    .line 125
    move-result-object v0

    .line 126
    check-cast v0, Ljava/util/ArrayList;

    .line 127
    .line 128
    :goto_2
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 129
    .line 130
    .line 131
    monitor-exit p0

    .line 132
    return-void

    .line 133
    :goto_3
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 134
    throw p1
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

.method private getChunkType(Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;)Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    const/4 v0, 0x4

    .line 6
    if-eq p1, v0, :cond_1

    .line 7
    .line 8
    const/4 v0, 0x5

    .line 9
    if-eq p1, v0, :cond_1

    .line 10
    .line 11
    const/16 v0, 0x9

    .line 12
    .line 13
    if-eq p1, v0, :cond_0

    .line 14
    .line 15
    const/16 v0, 0xa

    .line 16
    .line 17
    if-eq p1, v0, :cond_0

    .line 18
    .line 19
    sget-object p1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->RAW:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 20
    .line 21
    return-object p1

    .line 22
    :cond_0
    sget-object p1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->WEBSOCKET:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 23
    .line 24
    return-object p1

    .line 25
    :cond_1
    sget-object p1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 26
    .line 27
    return-object p1
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

.method public static getKeylogFilePath(Landroid/content/Context;)Ljava/io/File;
    .locals 2

    .line 1
    new-instance v0, Ljava/io/File;

    .line 2
    .line 3
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    const-string v1, "SSLKEYLOG.txt"

    .line 8
    .line 9
    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 10
    .line 11
    .line 12
    return-object v0
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

.method private handleLog([B)V
    .locals 3

    .line 1
    :try_start_0
    new-instance v0, Ljava/lang/String;

    .line 2
    .line 3
    sget-object v1, Ljava/nio/charset/StandardCharsets;->US_ASCII:Ljava/nio/charset/Charset;

    .line 4
    .line 5
    invoke-direct {v0, p1, v1}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    .line 9
    .line 10
    .line 11
    move-result p1

    .line 12
    const/4 v1, 0x3

    .line 13
    if-ge p1, v1, :cond_0

    .line 14
    .line 15
    goto :goto_0

    .line 16
    :cond_0
    const/4 p1, 0x0

    .line 17
    const/4 v1, 0x1

    .line 18
    invoke-virtual {v0, p1, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object p1

    .line 22
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    .line 23
    .line 24
    .line 25
    move-result p1

    .line 26
    sget v1, Lcom/emanuelef/remote_capture/Log;->MITMADDON_LOGGER:I

    .line 27
    .line 28
    const/4 v2, 0x2

    .line 29
    invoke-virtual {v0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    invoke-static {v1, p1, v0}, Lcom/emanuelef/remote_capture/Log;->level(IILjava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 34
    .line 35
    .line 36
    :catch_0
    :goto_0
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
.end method

.method private handleMessage(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;[BJ)V
    .locals 7

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->TLS_ERROR:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 2
    .line 3
    if-eq p2, v0, :cond_0

    .line 4
    .line 5
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->HTTP_ERROR:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 6
    .line 7
    if-eq p2, v0, :cond_0

    .line 8
    .line 9
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->TCP_ERROR:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 10
    .line 11
    if-ne p2, v0, :cond_1

    .line 12
    .line 13
    :cond_0
    move-object v1, p3

    .line 14
    move-wide v4, p4

    .line 15
    goto :goto_0

    .line 16
    :cond_1
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->DATA_TRUNCATED:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 17
    .line 18
    if-ne p2, v0, :cond_2

    .line 19
    .line 20
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->setPayloadTruncatedByAddon()V

    .line 21
    .line 22
    .line 23
    return-void

    .line 24
    :cond_2
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->JS_INJECTED:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 25
    .line 26
    if-ne p2, v0, :cond_3

    .line 27
    .line 28
    new-instance p2, Ljava/lang/String;

    .line 29
    .line 30
    sget-object p4, Ljava/nio/charset/StandardCharsets;->US_ASCII:Ljava/nio/charset/Charset;

    .line 31
    .line 32
    invoke-direct {p2, p3, p4}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 33
    .line 34
    .line 35
    iput-object p2, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->js_injected_scripts:Ljava/lang/String;

    .line 36
    .line 37
    return-void

    .line 38
    :cond_3
    new-instance v0, Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 39
    .line 40
    invoke-direct {p0, p2}, Lcom/emanuelef/remote_capture/MitmReceiver;->getChunkType(Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;)Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 41
    .line 42
    .line 43
    move-result-object v2

    .line 44
    invoke-direct {p0, p2}, Lcom/emanuelef/remote_capture/MitmReceiver;->isSent(Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;)Z

    .line 45
    .line 46
    .line 47
    move-result v3

    .line 48
    const/4 v6, 0x0

    .line 49
    move-object v1, p3

    .line 50
    move-wide v4, p4

    .line 51
    invoke-direct/range {v0 .. v6}, Lcom/emanuelef/remote_capture/model/PayloadChunk;-><init>([BLcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;ZJI)V

    .line 52
    .line 53
    .line 54
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->addPayloadChunkMitm(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    .line 55
    .line 56
    .line 57
    return-void

    .line 58
    :goto_0
    new-instance p2, Ljava/lang/String;

    .line 59
    .line 60
    sget-object p3, Ljava/nio/charset/StandardCharsets;->US_ASCII:Ljava/nio/charset/Charset;

    .line 61
    .line 62
    invoke-direct {p2, v1, p3}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 63
    .line 64
    .line 65
    iput-object p2, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->decryption_error:Ljava/lang/String;

    .line 66
    .line 67
    iget p2, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->status:I

    .line 68
    .line 69
    const/4 p3, 0x3

    .line 70
    if-ne p2, p3, :cond_4

    .line 71
    .line 72
    const/4 p2, 0x6

    .line 73
    iput p2, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->status:I

    .line 74
    .line 75
    :cond_4
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getHttpLog()Lcom/emanuelef/remote_capture/HttpLog;

    .line 76
    .line 77
    .line 78
    move-result-object p2

    .line 79
    if-eqz p2, :cond_5

    .line 80
    .line 81
    iget-object p3, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->decryption_error:Ljava/lang/String;

    .line 82
    .line 83
    invoke-virtual {p2, p1, v4, v5, p3}, Lcom/emanuelef/remote_capture/HttpLog;->addDecryptionError(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;JLjava/lang/String;)V

    .line 84
    .line 85
    .line 86
    :cond_5
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method

.method private isSent(Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;)Z
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    const/4 v0, 0x4

    .line 6
    if-eq p1, v0, :cond_0

    .line 7
    .line 8
    const/4 v0, 0x6

    .line 9
    if-eq p1, v0, :cond_0

    .line 10
    .line 11
    const/16 v0, 0x9

    .line 12
    .line 13
    if-eq p1, v0, :cond_0

    .line 14
    .line 15
    const/4 p1, 0x0

    .line 16
    return p1

    .line 17
    :cond_0
    const/4 p1, 0x1

    .line 18
    return p1
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

.method private logMasterSecret([B)V
    .locals 4

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mRootCapture:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPcapngFormat:Z

    .line 7
    .line 8
    if-eqz v0, :cond_1

    .line 9
    .line 10
    invoke-static {p1}, Lcom/emanuelef/remote_capture/CaptureService;->dumpMasterSecret([B)V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mKeylog:Ljava/io/BufferedOutputStream;

    .line 15
    .line 16
    if-nez v0, :cond_2

    .line 17
    .line 18
    new-instance v0, Ljava/io/BufferedOutputStream;

    .line 19
    .line 20
    iget-object v1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 21
    .line 22
    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    .line 23
    .line 24
    .line 25
    move-result-object v1

    .line 26
    iget-object v2, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 27
    .line 28
    invoke-static {v2}, Lcom/emanuelef/remote_capture/MitmReceiver;->getKeylogFilePath(Landroid/content/Context;)Ljava/io/File;

    .line 29
    .line 30
    .line 31
    move-result-object v2

    .line 32
    invoke-static {v2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    .line 33
    .line 34
    .line 35
    move-result-object v2

    .line 36
    const-string v3, "rwt"

    .line 37
    .line 38
    invoke-virtual {v1, v2, v3}, Landroid/content/ContentResolver;->openOutputStream(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/OutputStream;

    .line 39
    .line 40
    .line 41
    move-result-object v1

    .line 42
    invoke-direct {v0, v1}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 43
    .line 44
    .line 45
    iput-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mKeylog:Ljava/io/BufferedOutputStream;

    .line 46
    .line 47
    :cond_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mKeylog:Ljava/io/BufferedOutputStream;

    .line 48
    .line 49
    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write([B)V

    .line 50
    .line 51
    .line 52
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mKeylog:Ljava/io/BufferedOutputStream;

    .line 53
    .line 54
    const/16 v0, 0xa

    .line 55
    .line 56
    invoke-virtual {p1, v0}, Ljava/io/BufferedOutputStream;->write(I)V

    .line 57
    .line 58
    .line 59
    return-void
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
.end method

.method public static observeStatus(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/lifecycle/LifecycleOwner;",
            "Landroidx/lifecycle/Observer;",
            ")V"
        }
    .end annotation

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver;->proxyStatus:Landroidx/lifecycle/MutableLiveData;

    .line 2
    .line 3
    invoke-virtual {v0, p0, p1}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

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

.method private static parseMsgType(Ljava/lang/String;)Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;
    .locals 2

    .line 1
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    const/4 v1, -0x1

    .line 9
    sparse-switch v0, :sswitch_data_0

    .line 10
    .line 11
    .line 12
    goto/16 :goto_0

    .line 13
    .line 14
    :sswitch_0
    const-string v0, "js_inject"

    .line 15
    .line 16
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 17
    .line 18
    .line 19
    move-result p0

    .line 20
    if-nez p0, :cond_0

    .line 21
    .line 22
    goto/16 :goto_0

    .line 23
    .line 24
    :cond_0
    const/16 v1, 0xd

    .line 25
    .line 26
    goto/16 :goto_0

    .line 27
    .line 28
    :sswitch_1
    const-string v0, "running"

    .line 29
    .line 30
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 31
    .line 32
    .line 33
    move-result p0

    .line 34
    if-nez p0, :cond_1

    .line 35
    .line 36
    goto/16 :goto_0

    .line 37
    .line 38
    :cond_1
    const/16 v1, 0xc

    .line 39
    .line 40
    goto/16 :goto_0

    .line 41
    .line 42
    :sswitch_2
    const-string v0, "trunc"

    .line 43
    .line 44
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 45
    .line 46
    .line 47
    move-result p0

    .line 48
    if-nez p0, :cond_2

    .line 49
    .line 50
    goto/16 :goto_0

    .line 51
    .line 52
    :cond_2
    const/16 v1, 0xb

    .line 53
    .line 54
    goto/16 :goto_0

    .line 55
    .line 56
    :sswitch_3
    const-string v0, "ws_srvmsg"

    .line 57
    .line 58
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 59
    .line 60
    .line 61
    move-result p0

    .line 62
    if-nez p0, :cond_3

    .line 63
    .line 64
    goto/16 :goto_0

    .line 65
    .line 66
    :cond_3
    const/16 v1, 0xa

    .line 67
    .line 68
    goto/16 :goto_0

    .line 69
    .line 70
    :sswitch_4
    const-string v0, "log"

    .line 71
    .line 72
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 73
    .line 74
    .line 75
    move-result p0

    .line 76
    if-nez p0, :cond_4

    .line 77
    .line 78
    goto/16 :goto_0

    .line 79
    .line 80
    :cond_4
    const/16 v1, 0x9

    .line 81
    .line 82
    goto/16 :goto_0

    .line 83
    .line 84
    :sswitch_5
    const-string v0, "http_req"

    .line 85
    .line 86
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 87
    .line 88
    .line 89
    move-result p0

    .line 90
    if-nez p0, :cond_5

    .line 91
    .line 92
    goto/16 :goto_0

    .line 93
    .line 94
    :cond_5
    const/16 v1, 0x8

    .line 95
    .line 96
    goto/16 :goto_0

    .line 97
    .line 98
    :sswitch_6
    const-string v0, "http_rep"

    .line 99
    .line 100
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 101
    .line 102
    .line 103
    move-result p0

    .line 104
    if-nez p0, :cond_6

    .line 105
    .line 106
    goto :goto_0

    .line 107
    :cond_6
    const/4 v1, 0x7

    .line 108
    goto :goto_0

    .line 109
    :sswitch_7
    const-string v0, "http_err"

    .line 110
    .line 111
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 112
    .line 113
    .line 114
    move-result p0

    .line 115
    if-nez p0, :cond_7

    .line 116
    .line 117
    goto :goto_0

    .line 118
    :cond_7
    const/4 v1, 0x6

    .line 119
    goto :goto_0

    .line 120
    :sswitch_8
    const-string v0, "ws_climsg"

    .line 121
    .line 122
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 123
    .line 124
    .line 125
    move-result p0

    .line 126
    if-nez p0, :cond_8

    .line 127
    .line 128
    goto :goto_0

    .line 129
    :cond_8
    const/4 v1, 0x5

    .line 130
    goto :goto_0

    .line 131
    :sswitch_9
    const-string v0, "tcp_srvmsg"

    .line 132
    .line 133
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 134
    .line 135
    .line 136
    move-result p0

    .line 137
    if-nez p0, :cond_9

    .line 138
    .line 139
    goto :goto_0

    .line 140
    :cond_9
    const/4 v1, 0x4

    .line 141
    goto :goto_0

    .line 142
    :sswitch_a
    const-string v0, "tcp_climsg"

    .line 143
    .line 144
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 145
    .line 146
    .line 147
    move-result p0

    .line 148
    if-nez p0, :cond_a

    .line 149
    .line 150
    goto :goto_0

    .line 151
    :cond_a
    const/4 v1, 0x3

    .line 152
    goto :goto_0

    .line 153
    :sswitch_b
    const-string v0, "secret"

    .line 154
    .line 155
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 156
    .line 157
    .line 158
    move-result p0

    .line 159
    if-nez p0, :cond_b

    .line 160
    .line 161
    goto :goto_0

    .line 162
    :cond_b
    const/4 v1, 0x2

    .line 163
    goto :goto_0

    .line 164
    :sswitch_c
    const-string v0, "tls_err"

    .line 165
    .line 166
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 167
    .line 168
    .line 169
    move-result p0

    .line 170
    if-nez p0, :cond_c

    .line 171
    .line 172
    goto :goto_0

    .line 173
    :cond_c
    const/4 v1, 0x1

    .line 174
    goto :goto_0

    .line 175
    :sswitch_d
    const-string v0, "tcp_err"

    .line 176
    .line 177
    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 178
    .line 179
    .line 180
    move-result p0

    .line 181
    if-nez p0, :cond_d

    .line 182
    .line 183
    goto :goto_0

    .line 184
    :cond_d
    const/4 v1, 0x0

    .line 185
    :goto_0
    packed-switch v1, :pswitch_data_0

    .line 186
    .line 187
    .line 188
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->UNKNOWN:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 189
    .line 190
    return-object p0

    .line 191
    :pswitch_0
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->JS_INJECTED:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 192
    .line 193
    return-object p0

    .line 194
    :pswitch_1
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->RUNNING:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 195
    .line 196
    return-object p0

    .line 197
    :pswitch_2
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->DATA_TRUNCATED:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 198
    .line 199
    return-object p0

    .line 200
    :pswitch_3
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->WEBSOCKET_SERVER_MSG:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 201
    .line 202
    return-object p0

    .line 203
    :pswitch_4
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->LOG:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 204
    .line 205
    return-object p0

    .line 206
    :pswitch_5
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->HTTP_REQUEST:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 207
    .line 208
    return-object p0

    .line 209
    :pswitch_6
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->HTTP_REPLY:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 210
    .line 211
    return-object p0

    .line 212
    :pswitch_7
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->HTTP_ERROR:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 213
    .line 214
    return-object p0

    .line 215
    :pswitch_8
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->WEBSOCKET_CLIENT_MSG:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 216
    .line 217
    return-object p0

    .line 218
    :pswitch_9
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->TCP_SERVER_MSG:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 219
    .line 220
    return-object p0

    .line 221
    :pswitch_a
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->TCP_CLIENT_MSG:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 222
    .line 223
    return-object p0

    .line 224
    :pswitch_b
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->MASTER_SECRET:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 225
    .line 226
    return-object p0

    .line 227
    :pswitch_c
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->TLS_ERROR:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 228
    .line 229
    return-object p0

    .line 230
    :pswitch_d
    sget-object p0, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->TCP_ERROR:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 231
    .line 232
    return-object p0

    .line 233
    :sswitch_data_0
    .sparse-switch
        -0x58665ff9 -> :sswitch_d
        -0x48e07bdf -> :sswitch_c
        -0x3604b150 -> :sswitch_b
        -0x353b1f81 -> :sswitch_a
        -0x19931fb8 -> :sswitch_9
        -0x19862edc -> :sswitch_8
        -0x7e9c2d2 -> :sswitch_7
        -0x7e9939a -> :sswitch_6
        -0x7e99399 -> :sswitch_5
        0x1a344 -> :sswitch_4
        0x221d0ed -> :sswitch_3
        0x6983dac -> :sswitch_2
        0x5c6f15bf -> :sswitch_1
        0x6959c547 -> :sswitch_0
    .end sparse-switch

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
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public connectionsAdded(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 11

    .line 1
    monitor-enter p0

    .line 2
    :try_start_0
    array-length p1, p2

    .line 3
    const/4 v0, 0x0

    .line 4
    const/4 v1, 0x0

    .line 5
    :goto_0
    if-ge v1, p1, :cond_1

    .line 6
    .line 7
    aget-object v3, p2, v1

    .line 8
    .line 9
    iget-object v2, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPortToConnId:Landroid/util/LruCache;

    .line 10
    .line 11
    iget v4, v3, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->local_port:I

    .line 12
    .line 13
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 14
    .line 15
    .line 16
    move-result-object v4

    .line 17
    iget v5, v3, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 18
    .line 19
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 20
    .line 21
    .line 22
    move-result-object v5

    .line 23
    invoke-virtual {v2, v4, v5}, Landroid/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    .line 25
    .line 26
    iget-object v2, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 27
    .line 28
    iget v4, v3, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->local_port:I

    .line 29
    .line 30
    invoke-virtual {v2, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    .line 31
    .line 32
    .line 33
    move-result v2

    .line 34
    if-ltz v2, :cond_0

    .line 35
    .line 36
    iget-object v4, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 37
    .line 38
    invoke-virtual {v4, v2}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    .line 39
    .line 40
    .line 41
    move-result-object v4

    .line 42
    move-object v8, v4

    .line 43
    check-cast v8, Ljava/util/ArrayList;

    .line 44
    .line 45
    iget-object v4, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPendingMessages:Landroid/util/SparseArray;

    .line 46
    .line 47
    invoke-virtual {v4, v2}, Landroid/util/SparseArray;->removeAt(I)V

    .line 48
    .line 49
    .line 50
    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    .line 51
    .line 52
    .line 53
    move-result v9

    .line 54
    const/4 v2, 0x0

    .line 55
    :goto_1
    if-ge v2, v9, :cond_0

    .line 56
    .line 57
    invoke-virtual {v8, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 58
    .line 59
    .line 60
    move-result-object v4

    .line 61
    add-int/lit8 v10, v2, 0x1

    .line 62
    .line 63
    check-cast v4, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;

    .line 64
    .line 65
    move-object v2, v4

    .line 66
    iget-object v4, v2, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;->type:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 67
    .line 68
    iget-object v5, v2, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;->msg:[B

    .line 69
    .line 70
    iget-wide v6, v2, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;->when:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 71
    .line 72
    move-object v2, p0

    .line 73
    :try_start_1
    invoke-direct/range {v2 .. v7}, Lcom/emanuelef/remote_capture/MitmReceiver;->handleMessage(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;[BJ)V

    .line 74
    .line 75
    .line 76
    move v2, v10

    .line 77
    goto :goto_1

    .line 78
    :catchall_0
    move-exception v0

    .line 79
    :goto_2
    move-object p1, v0

    .line 80
    goto :goto_3

    .line 81
    :catchall_1
    move-exception v0

    .line 82
    move-object v2, p0

    .line 83
    goto :goto_2

    .line 84
    :cond_0
    move-object v2, p0

    .line 85
    add-int/lit8 v1, v1, 0x1

    .line 86
    .line 87
    goto :goto_0

    .line 88
    :cond_1
    move-object v2, p0

    .line 89
    monitor-exit p0

    .line 90
    return-void

    .line 91
    :goto_3
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 92
    throw p1
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

.method public connectionsChanges(I)V
    .locals 0

    return-void
.end method

.method public connectionsRemoved(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 0

    return-void
.end method

.method public connectionsUpdated([I)V
    .locals 0

    return-void
.end method

.method public getConnByLocalPort(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;
    .locals 3

    .line 1
    monitor-enter p0

    .line 2
    :try_start_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mPortToConnId:Landroid/util/LruCache;

    .line 3
    .line 4
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 5
    .line 6
    .line 7
    move-result-object v1

    .line 8
    invoke-virtual {v0, v1}, Landroid/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Ljava/lang/Integer;

    .line 13
    .line 14
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 15
    const/4 v1, 0x0

    .line 16
    if-nez v0, :cond_0

    .line 17
    .line 18
    return-object v1

    .line 19
    :cond_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mReg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 20
    .line 21
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    .line 22
    .line 23
    .line 24
    move-result v0

    .line 25
    invoke-virtual {v2, v0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConnById(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    if-eqz v0, :cond_2

    .line 30
    .line 31
    iget v2, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->local_port:I

    .line 32
    .line 33
    if-eq v2, p1, :cond_1

    .line 34
    .line 35
    goto :goto_0

    .line 36
    :cond_1
    return-object v0

    .line 37
    :cond_2
    :goto_0
    return-object v1

    .line 38
    :catchall_0
    move-exception p1

    .line 39
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 40
    throw p1
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

.method public getProxyStatus()Lcom/emanuelef/remote_capture/MitmReceiver$Status;
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver;->proxyStatus:Landroidx/lifecycle/MutableLiveData;

    .line 2
    .line 3
    iget-object v0, v0, Landroidx/lifecycle/LiveData;->mData:Ljava/lang/Object;

    .line 4
    .line 5
    sget-object v1, Landroidx/lifecycle/LiveData;->NOT_SET:Ljava/lang/Object;

    .line 6
    .line 7
    if-eq v0, v1, :cond_0

    .line 8
    .line 9
    goto :goto_0

    .line 10
    :cond_0
    const/4 v0, 0x0

    .line 11
    :goto_0
    check-cast v0, Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 12
    .line 13
    return-object v0
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
.end method

.method public onMitmGetCaCertificateResult(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->isCAInstallationSkipped(Landroid/content/Context;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/4 v1, 0x0

    .line 8
    if-nez v0, :cond_0

    .line 9
    .line 10
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->isCAInstalled(Ljava/lang/String;)Z

    .line 11
    .line 12
    .line 13
    move-result p1

    .line 14
    if-nez p1, :cond_0

    .line 15
    .line 16
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 17
    .line 18
    const v0, 0x7f140079

    .line 19
    .line 20
    .line 21
    new-array v2, v1, [Ljava/lang/Object;

    .line 22
    .line 23
    invoke-static {p1, v0, v2}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 24
    .line 25
    .line 26
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 27
    .line 28
    invoke-static {p1, v1}, Lcom/emanuelef/remote_capture/MitmAddon;->setDecryptionSetupDone(Landroid/content/Context;Z)V

    .line 29
    .line 30
    .line 31
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopService()V

    .line 32
    .line 33
    .line 34
    return-void

    .line 35
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 36
    .line 37
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mConfig:Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;

    .line 38
    .line 39
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/MitmAddon;->startProxy(Lcom/pcapdroid/mitm/MitmAPI$MitmConfig;)Landroid/os/ParcelFileDescriptor;

    .line 40
    .line 41
    .line 42
    move-result-object p1

    .line 43
    iput-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mSocketFd:Landroid/os/ParcelFileDescriptor;

    .line 44
    .line 45
    if-nez p1, :cond_1

    .line 46
    .line 47
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 48
    .line 49
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->disconnect()V

    .line 50
    .line 51
    .line 52
    return-void

    .line 53
    :cond_1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 54
    .line 55
    invoke-static {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->isDozeEnabled(Landroid/content/Context;)Z

    .line 56
    .line 57
    .line 58
    move-result p1

    .line 59
    if-eqz p1, :cond_2

    .line 60
    .line 61
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 62
    .line 63
    const v0, 0x7f1401af

    .line 64
    .line 65
    .line 66
    new-array v1, v1, [Ljava/lang/Object;

    .line 67
    .line 68
    invoke-static {p1, v0, v1}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 69
    .line 70
    .line 71
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 72
    .line 73
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/MitmAddon;->disableDoze()Z

    .line 74
    .line 75
    .line 76
    :cond_2
    iget-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mThread:Ljava/lang/Thread;

    .line 77
    .line 78
    if-eqz p1, :cond_3

    .line 79
    .line 80
    invoke-virtual {p1}, Ljava/lang/Thread;->interrupt()V

    .line 81
    .line 82
    .line 83
    :cond_3
    new-instance p1, Ljava/lang/Thread;

    .line 84
    .line 85
    invoke-direct {p1, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 86
    .line 87
    .line 88
    iput-object p1, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mThread:Ljava/lang/Thread;

    .line 89
    .line 90
    invoke-virtual {p1}, Ljava/lang/Thread;->start()V

    .line 91
    .line 92
    .line 93
    return-void
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

.method public onMitmServiceConnect()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->stopProxy()Z

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 7
    .line 8
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->requestCaCertificate()Z

    .line 9
    .line 10
    .line 11
    move-result v0

    .line 12
    if-nez v0, :cond_0

    .line 13
    .line 14
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 15
    .line 16
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->disconnect()V

    .line 17
    .line 18
    .line 19
    :cond_0
    return-void
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

.method public onMitmServiceDisconnect()V
    .locals 0

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopService()V

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
    .line 58
.end method

.method public run()V
    .locals 13

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mSocketFd:Landroid/os/ParcelFileDescriptor;

    .line 2
    .line 3
    const-string v1, "MitmReceiver"

    .line 4
    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    const-string v0, "Null socket, abort"

    .line 8
    .line 9
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 10
    .line 11
    .line 12
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver;->proxyStatus:Landroidx/lifecycle/MutableLiveData;

    .line 13
    .line 14
    sget-object v1, Lcom/emanuelef/remote_capture/MitmReceiver$Status;->NOT_STARTED:Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 15
    .line 16
    invoke-virtual {v0, v1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :cond_0
    const-string v0, "Receiving data..."

    .line 21
    .line 22
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 23
    .line 24
    .line 25
    const/4 v2, 0x0

    .line 26
    :try_start_0
    new-instance v3, Ljava/io/DataInputStream;

    .line 27
    .line 28
    new-instance v0, Landroid/os/ParcelFileDescriptor$AutoCloseInputStream;

    .line 29
    .line 30
    iget-object v4, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mSocketFd:Landroid/os/ParcelFileDescriptor;

    .line 31
    .line 32
    invoke-direct {v0, v4}, Landroid/os/ParcelFileDescriptor$AutoCloseInputStream;-><init>(Landroid/os/ParcelFileDescriptor;)V

    .line 33
    .line 34
    .line 35
    invoke-direct {v3, v0}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_5

    .line 36
    .line 37
    .line 38
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 39
    .line 40
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->isConnected()Z

    .line 41
    .line 42
    .line 43
    move-result v0

    .line 44
    if-eqz v0, :cond_1

    .line 45
    .line 46
    invoke-virtual {v3}, Ljava/io/DataInputStream;->readLine()Ljava/lang/String;

    .line 47
    .line 48
    .line 49
    move-result-object v0

    .line 50
    if-nez v0, :cond_2

    .line 51
    .line 52
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopService()V

    .line 53
    .line 54
    .line 55
    :cond_1
    move-object v5, p0

    .line 56
    goto/16 :goto_4

    .line 57
    .line 58
    :catchall_0
    move-exception v0

    .line 59
    move-object v5, p0

    .line 60
    :goto_1
    move-object v4, v0

    .line 61
    goto/16 :goto_6

    .line 62
    .line 63
    :cond_2
    new-instance v4, Ljava/util/StringTokenizer;

    .line 64
    .line 65
    invoke-direct {v4, v0}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 66
    .line 67
    .line 68
    :try_start_2
    const-string v0, ":"

    .line 69
    .line 70
    invoke-virtual {v4, v0}, Ljava/util/StringTokenizer;->nextToken(Ljava/lang/String;)Ljava/lang/String;

    .line 71
    .line 72
    .line 73
    move-result-object v0

    .line 74
    invoke-virtual {v4}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    .line 75
    .line 76
    .line 77
    move-result-object v5

    .line 78
    invoke-virtual {v4}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    .line 79
    .line 80
    .line 81
    move-result-object v6

    .line 82
    invoke-virtual {v4}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    .line 83
    .line 84
    .line 85
    move-result-object v4

    .line 86
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    .line 87
    .line 88
    .line 89
    move-result-wide v11

    .line 90
    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    .line 91
    .line 92
    .line 93
    move-result v0

    .line 94
    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    .line 95
    .line 96
    .line 97
    move-result v4
    :try_end_2
    .catch Ljava/util/NoSuchElementException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 98
    if-ltz v4, :cond_3

    .line 99
    .line 100
    const/high16 v5, 0x4000000

    .line 101
    .line 102
    if-le v4, v5, :cond_4

    .line 103
    .line 104
    :cond_3
    move-object v5, p0

    .line 105
    goto/16 :goto_3

    .line 106
    .line 107
    :cond_4
    :try_start_3
    invoke-static {v6}, Lcom/emanuelef/remote_capture/MitmReceiver;->parseMsgType(Ljava/lang/String;)Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 108
    .line 109
    .line 110
    move-result-object v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 111
    :try_start_4
    new-array v9, v4, [B
    :try_end_4
    .catch Ljava/lang/OutOfMemoryError; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 112
    .line 113
    :try_start_5
    invoke-virtual {v3, v9}, Ljava/io/DataInputStream;->readFully([B)V

    .line 114
    .line 115
    .line 116
    sget-object v4, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->MASTER_SECRET:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 117
    .line 118
    if-ne v8, v4, :cond_5

    .line 119
    .line 120
    invoke-direct {p0, v9}, Lcom/emanuelef/remote_capture/MitmReceiver;->logMasterSecret([B)V

    .line 121
    .line 122
    .line 123
    :goto_2
    move-object v5, p0

    .line 124
    goto :goto_0

    .line 125
    :cond_5
    sget-object v4, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->LOG:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 126
    .line 127
    if-ne v8, v4, :cond_6

    .line 128
    .line 129
    invoke-direct {p0, v9}, Lcom/emanuelef/remote_capture/MitmReceiver;->handleLog([B)V

    .line 130
    .line 131
    .line 132
    goto :goto_2

    .line 133
    :cond_6
    sget-object v4, Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;->RUNNING:Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;

    .line 134
    .line 135
    if-ne v8, v4, :cond_7

    .line 136
    .line 137
    const-string v0, "MITM proxy is running"

    .line 138
    .line 139
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    .line 141
    .line 142
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver;->proxyStatus:Landroidx/lifecycle/MutableLiveData;

    .line 143
    .line 144
    sget-object v4, Lcom/emanuelef/remote_capture/MitmReceiver$Status;->RUNNING:Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 145
    .line 146
    invoke-virtual {v0, v4}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 147
    .line 148
    .line 149
    goto :goto_2

    .line 150
    :cond_7
    move-object v10, v9

    .line 151
    move-object v9, v8

    .line 152
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/MitmReceiver;->getConnByLocalPort(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 153
    .line 154
    .line 155
    move-result-object v8
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 156
    if-eqz v8, :cond_8

    .line 157
    .line 158
    move-object v7, p0

    .line 159
    :try_start_6
    invoke-direct/range {v7 .. v12}, Lcom/emanuelef/remote_capture/MitmReceiver;->handleMessage(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;[BJ)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 160
    .line 161
    .line 162
    move-object v5, v7

    .line 163
    goto :goto_0

    .line 164
    :catchall_1
    move-exception v0

    .line 165
    move-object v5, v7

    .line 166
    goto :goto_1

    .line 167
    :cond_8
    move-object v5, p0

    .line 168
    :try_start_7
    new-instance v7, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;

    .line 169
    .line 170
    move-object v8, v9

    .line 171
    move-object v9, v10

    .line 172
    move v10, v0

    .line 173
    invoke-direct/range {v7 .. v12}, Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;-><init>(Lcom/emanuelef/remote_capture/MitmReceiver$MsgType;[BIJ)V

    .line 174
    .line 175
    .line 176
    invoke-direct {p0, v7}, Lcom/emanuelef/remote_capture/MitmReceiver;->addPendingMessage(Lcom/emanuelef/remote_capture/MitmReceiver$PendingMessage;)V

    .line 177
    .line 178
    .line 179
    goto/16 :goto_0

    .line 180
    .line 181
    :catchall_2
    move-exception v0

    .line 182
    goto :goto_1

    .line 183
    :catch_0
    move-object v5, p0

    .line 184
    new-instance v0, Ljava/lang/StringBuilder;

    .line 185
    .line 186
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 187
    .line 188
    .line 189
    const-string v6, "Ignoring message causing OOM (length: "

    .line 190
    .line 191
    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 192
    .line 193
    .line 194
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 195
    .line 196
    .line 197
    const-string v6, ")"

    .line 198
    .line 199
    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 200
    .line 201
    .line 202
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 203
    .line 204
    .line 205
    move-result-object v0

    .line 206
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    .line 208
    .line 209
    invoke-virtual {v3, v4}, Ljava/io/DataInputStream;->skipBytes(I)I

    .line 210
    .line 211
    .line 212
    goto/16 :goto_0

    .line 213
    .line 214
    :goto_3
    new-instance v0, Ljava/lang/StringBuilder;

    .line 215
    .line 216
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 217
    .line 218
    .line 219
    const-string v6, "Ignoring bad message length: "

    .line 220
    .line 221
    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 222
    .line 223
    .line 224
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 225
    .line 226
    .line 227
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 228
    .line 229
    .line 230
    move-result-object v0

    .line 231
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    .line 233
    .line 234
    invoke-virtual {v3, v4}, Ljava/io/DataInputStream;->skipBytes(I)I

    .line 235
    .line 236
    .line 237
    goto/16 :goto_0

    .line 238
    .line 239
    :catch_1
    move-object v5, p0

    .line 240
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->requireInstance()Lcom/emanuelef/remote_capture/CaptureService;

    .line 241
    .line 242
    .line 243
    move-result-object v0

    .line 244
    const-string v4, "[BUG] Invalid header received from the mitm plugin"

    .line 245
    .line 246
    invoke-virtual {v0, v4}, Lcom/emanuelef/remote_capture/CaptureService;->reportError(Ljava/lang/String;)V

    .line 247
    .line 248
    .line 249
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopService()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    .line 250
    .line 251
    .line 252
    :goto_4
    :try_start_8
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_2
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    .line 253
    .line 254
    .line 255
    :cond_9
    :goto_5
    iget-object v0, v5, Lcom/emanuelef/remote_capture/MitmReceiver;->mKeylog:Ljava/io/BufferedOutputStream;

    .line 256
    .line 257
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 258
    .line 259
    .line 260
    iput-object v2, v5, Lcom/emanuelef/remote_capture/MitmReceiver;->mKeylog:Ljava/io/BufferedOutputStream;

    .line 261
    .line 262
    goto :goto_9

    .line 263
    :catchall_3
    move-exception v0

    .line 264
    goto :goto_b

    .line 265
    :catch_2
    move-exception v0

    .line 266
    goto :goto_8

    .line 267
    :goto_6
    :try_start_9
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_4

    .line 268
    .line 269
    .line 270
    goto :goto_7

    .line 271
    :catchall_4
    move-exception v0

    .line 272
    :try_start_a
    invoke-virtual {v4, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .line 273
    .line 274
    .line 275
    :goto_7
    throw v4
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_2
    .catchall {:try_start_a .. :try_end_a} :catchall_3

    .line 276
    :catchall_5
    move-exception v0

    .line 277
    move-object v5, p0

    .line 278
    goto :goto_b

    .line 279
    :catch_3
    move-exception v0

    .line 280
    move-object v5, p0

    .line 281
    :goto_8
    :try_start_b
    iget-object v3, v5, Lcom/emanuelef/remote_capture/MitmReceiver;->mSocketFd:Landroid/os/ParcelFileDescriptor;

    .line 282
    .line 283
    if-eqz v3, :cond_9

    .line 284
    .line 285
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_3

    .line 286
    .line 287
    .line 288
    goto :goto_5

    .line 289
    :goto_9
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver;->proxyStatus:Landroidx/lifecycle/MutableLiveData;

    .line 290
    .line 291
    iget-object v3, v0, Landroidx/lifecycle/LiveData;->mData:Ljava/lang/Object;

    .line 292
    .line 293
    sget-object v4, Landroidx/lifecycle/LiveData;->NOT_SET:Ljava/lang/Object;

    .line 294
    .line 295
    if-eq v3, v4, :cond_a

    .line 296
    .line 297
    move-object v2, v3

    .line 298
    :cond_a
    sget-object v3, Lcom/emanuelef/remote_capture/MitmReceiver$Status;->STARTING:Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 299
    .line 300
    if-ne v2, v3, :cond_b

    .line 301
    .line 302
    sget-object v2, Lcom/emanuelef/remote_capture/MitmReceiver$Status;->START_ERROR:Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 303
    .line 304
    invoke-virtual {v0, v2}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 305
    .line 306
    .line 307
    goto :goto_a

    .line 308
    :cond_b
    sget-object v2, Lcom/emanuelef/remote_capture/MitmReceiver$Status;->NOT_STARTED:Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 309
    .line 310
    invoke-virtual {v0, v2}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 311
    .line 312
    .line 313
    :goto_a
    const-string v0, "End receiving data"

    .line 314
    .line 315
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    .line 317
    .line 318
    return-void

    .line 319
    :goto_b
    iget-object v1, v5, Lcom/emanuelef/remote_capture/MitmReceiver;->mKeylog:Ljava/io/BufferedOutputStream;

    .line 320
    .line 321
    invoke-static {v1}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 322
    .line 323
    .line 324
    iput-object v2, v5, Lcom/emanuelef/remote_capture/MitmReceiver;->mKeylog:Ljava/io/BufferedOutputStream;

    .line 325
    .line 326
    throw v0
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

.method public start()Z
    .locals 4

    .line 1
    const-string v0, "MitmReceiver"

    .line 2
    .line 3
    const-string v1, "starting"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver;->proxyStatus:Landroidx/lifecycle/MutableLiveData;

    .line 9
    .line 10
    sget-object v1, Lcom/emanuelef/remote_capture/MitmReceiver$Status;->STARTING:Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 11
    .line 12
    invoke-virtual {v0, v1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 13
    .line 14
    .line 15
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 16
    .line 17
    const/16 v1, 0x40

    .line 18
    .line 19
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/MitmAddon;->connect(I)Z

    .line 20
    .line 21
    .line 22
    move-result v0

    .line 23
    if-nez v0, :cond_0

    .line 24
    .line 25
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mContext:Landroid/content/Context;

    .line 26
    .line 27
    const v1, 0x7f1401b4

    .line 28
    .line 29
    .line 30
    const/4 v2, 0x0

    .line 31
    new-array v3, v2, [Ljava/lang/Object;

    .line 32
    .line 33
    invoke-static {v0, v1, v3}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 34
    .line 35
    .line 36
    return v2

    .line 37
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mReg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 38
    .line 39
    invoke-virtual {v0, p0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->addListener(Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;)V

    .line 40
    .line 41
    .line 42
    const/4 v0, 0x1

    .line 43
    return v0
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

.method public stop()V
    .locals 3

    .line 1
    const-string v0, "stopping"

    .line 2
    .line 3
    const-string v1, "MitmReceiver"

    .line 4
    .line 5
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mReg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 9
    .line 10
    invoke-virtual {v0, p0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->removeListener(Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;)V

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mSocketFd:Landroid/os/ParcelFileDescriptor;

    .line 14
    .line 15
    const/4 v2, 0x0

    .line 16
    iput-object v2, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mSocketFd:Landroid/os/ParcelFileDescriptor;

    .line 17
    .line 18
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 19
    .line 20
    .line 21
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 22
    .line 23
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->stopProxy()Z

    .line 24
    .line 25
    .line 26
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 27
    .line 28
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->disconnect()V

    .line 29
    .line 30
    .line 31
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mThread:Ljava/lang/Thread;

    .line 32
    .line 33
    if-eqz v0, :cond_0

    .line 34
    .line 35
    invoke-virtual {v0}, Ljava/lang/Thread;->isAlive()Z

    .line 36
    .line 37
    .line 38
    move-result v0

    .line 39
    if-eqz v0, :cond_0

    .line 40
    .line 41
    :try_start_0
    const-string v0, "Joining receiver thread..."

    .line 42
    .line 43
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    .line 45
    .line 46
    iget-object v0, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mThread:Ljava/lang/Thread;

    .line 47
    .line 48
    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 49
    .line 50
    .line 51
    goto :goto_0

    .line 52
    :catch_0
    nop

    .line 53
    goto :goto_0

    .line 54
    :cond_0
    iput-object v2, p0, Lcom/emanuelef/remote_capture/MitmReceiver;->mThread:Ljava/lang/Thread;

    .line 55
    .line 56
    const-string v0, "stop done"

    .line 57
    .line 58
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    .line 60
    .line 61
    return-void
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
