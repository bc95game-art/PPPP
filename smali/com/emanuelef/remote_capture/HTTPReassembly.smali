.class public Lcom/emanuelef/remote_capture/HTTPReassembly;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;,
        Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;
    }
.end annotation


# static fields
.field private static final MAX_HEADERS_SIZE:I = 0x400

.field private static final TAG:Ljava/lang/String; = "HTTPReassembly"


# instance fields
.field private final mBody:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/model/PayloadChunk;",
            ">;"
        }
    .end annotation
.end field

.field private mBodySize:I

.field private mChunkedEncoding:Z

.field private mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

.field private mContentLength:I

.field private final mDumpPayload:Z

.field private mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

.field private final mHeaders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/model/PayloadChunk;",
            ">;"
        }
    .end annotation
.end field

.field private mHeadersSize:I

.field private mInvalidHttp:Z

.field private final mListener:Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;

.field private mReadingHeaders:Z

.field private mReassembleChunks:Z

.field private mSwitchingProtocols:Z

.field private mWebSocketDecoder:Lcom/emanuelef/remote_capture/WebSocketDecoder;

.field private mWebsocketUpgrade:Z


# direct methods
.method public static synthetic $r8$lambda$k2089ofX84AEKQeLy8_vH6FBrXk(Lcom/emanuelef/remote_capture/HTTPReassembly;Lcom/emanuelef/remote_capture/model/PayloadChunk;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/HTTPReassembly;->lambda$handleChunk$0(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    return-void
.end method

.method public constructor <init>(ZLcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;)V
    .locals 1

    const/4 v0, 0x1

    .line 10
    invoke-direct {p0, p1, p2, v0}, Lcom/emanuelef/remote_capture/HTTPReassembly;-><init>(ZLcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;Z)V

    return-void
.end method

.method public constructor <init>(ZLcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;Z)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeaders:Ljava/util/ArrayList;

    .line 3
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBody:Ljava/util/ArrayList;

    const/4 v0, 0x0

    .line 4
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mSwitchingProtocols:Z

    .line 5
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mWebsocketUpgrade:Z

    .line 6
    iput-object p2, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mListener:Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;

    .line 7
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReassembleChunks:Z

    .line 8
    iput-boolean p3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mDumpPayload:Z

    .line 9
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/HTTPReassembly;->reset()V

    return-void
.end method

.method private decodeBody(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V
    .locals 6

    .line 1
    const/4 v0, 0x0

    .line 2
    :try_start_0
    new-instance v1, Ljava/io/ByteArrayInputStream;

    .line 3
    .line 4
    iget-object v2, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 5
    .line 6
    invoke-direct {v1, v2}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_3

    .line 7
    .line 8
    .line 9
    :try_start_1
    iget-object v2, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 10
    .line 11
    invoke-virtual {v2}, Ljava/lang/Enum;->ordinal()I

    .line 12
    .line 13
    .line 14
    move-result v2

    .line 15
    const/4 v3, 0x1

    .line 16
    if-eq v2, v3, :cond_3

    .line 17
    .line 18
    const/4 v4, 0x2

    .line 19
    if-eq v2, v4, :cond_2

    .line 20
    .line 21
    const/4 v3, 0x3

    .line 22
    if-eq v2, v3, :cond_1

    .line 23
    .line 24
    const/4 v3, 0x4

    .line 25
    if-eq v2, v3, :cond_0

    .line 26
    .line 27
    goto :goto_1

    .line 28
    :cond_0
    iget-object v2, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 29
    .line 30
    invoke-static {v2}, Lcom/emanuelef/remote_capture/ZstdDecoder;->decompress([B)[B

    .line 31
    .line 32
    .line 33
    move-result-object v2

    .line 34
    iput-object v2, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 35
    .line 36
    goto :goto_1

    .line 37
    :catchall_0
    move-exception p1

    .line 38
    goto :goto_6

    .line 39
    :cond_1
    new-instance v2, Lorg/brotli/dec/BrotliInputStream;

    .line 40
    .line 41
    invoke-direct {v2, v1}, Lorg/brotli/dec/BrotliInputStream;-><init>(Ljava/io/ByteArrayInputStream;)V

    .line 42
    .line 43
    .line 44
    :goto_0
    move-object v0, v2

    .line 45
    goto :goto_1

    .line 46
    :cond_2
    new-instance v2, Ljava/util/zip/InflaterInputStream;

    .line 47
    .line 48
    new-instance v4, Ljava/util/zip/Inflater;

    .line 49
    .line 50
    invoke-direct {v4, v3}, Ljava/util/zip/Inflater;-><init>(Z)V

    .line 51
    .line 52
    .line 53
    invoke-direct {v2, v1, v4}, Ljava/util/zip/InflaterInputStream;-><init>(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V

    .line 54
    .line 55
    .line 56
    goto :goto_0

    .line 57
    :cond_3
    new-instance v2, Ljava/util/zip/GZIPInputStream;

    .line 58
    .line 59
    invoke-direct {v2, v1}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    .line 60
    .line 61
    .line 62
    goto :goto_0

    .line 63
    :goto_1
    if-eqz v0, :cond_5

    .line 64
    .line 65
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    .line 66
    .line 67
    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 68
    .line 69
    .line 70
    const/16 v3, 0x400

    .line 71
    .line 72
    :try_start_2
    new-array v3, v3, [B

    .line 73
    .line 74
    :goto_2
    invoke-virtual {v0, v3}, Ljava/io/InputStream;->read([B)I

    .line 75
    .line 76
    .line 77
    move-result v4

    .line 78
    const/4 v5, -0x1

    .line 79
    if-eq v4, v5, :cond_4

    .line 80
    .line 81
    const/4 v5, 0x0

    .line 82
    invoke-virtual {v2, v3, v5, v4}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 83
    .line 84
    .line 85
    goto :goto_2

    .line 86
    :catchall_1
    move-exception p1

    .line 87
    goto :goto_3

    .line 88
    :cond_4
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    .line 89
    .line 90
    .line 91
    move-result-object v3

    .line 92
    iput-object v3, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 93
    .line 94
    :try_start_3
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 95
    .line 96
    .line 97
    goto :goto_5

    .line 98
    :goto_3
    :try_start_4
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 99
    .line 100
    .line 101
    goto :goto_4

    .line 102
    :catchall_2
    move-exception v2

    .line 103
    :try_start_5
    invoke-virtual {p1, v2}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .line 104
    .line 105
    .line 106
    :goto_4
    throw p1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 107
    :cond_5
    :goto_5
    :try_start_6
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    .line 108
    .line 109
    .line 110
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 111
    .line 112
    .line 113
    return-void

    .line 114
    :catchall_3
    move-exception p1

    .line 115
    goto :goto_8

    .line 116
    :goto_6
    :try_start_7
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->close()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_4

    .line 117
    .line 118
    .line 119
    goto :goto_7

    .line 120
    :catchall_4
    move-exception v1

    .line 121
    :try_start_8
    invoke-virtual {p1, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .line 122
    .line 123
    .line 124
    :goto_7
    throw p1
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_0
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    .line 125
    :catch_0
    :try_start_9
    new-instance p1, Ljava/lang/StringBuilder;

    .line 126
    .line 127
    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 128
    .line 129
    .line 130
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 131
    .line 132
    invoke-virtual {v1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 133
    .line 134
    .line 135
    move-result-object v1

    .line 136
    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    .line 137
    .line 138
    .line 139
    move-result-object v1

    .line 140
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 141
    .line 142
    .line 143
    const-string v1, " decoding failed"

    .line 144
    .line 145
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 146
    .line 147
    .line 148
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 149
    .line 150
    .line 151
    move-result-object p1

    .line 152
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    .line 153
    .line 154
    .line 155
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 156
    .line 157
    .line 158
    return-void

    .line 159
    :goto_8
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 160
    .line 161
    .line 162
    throw p1
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

.method private isTx()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

    .line 12
    return v0
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

.method private synthetic lambda$handleChunk$0(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V
    .locals 1

    .line 1
    iget v0, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->wsOpcode:I

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/WebSocketDecoder;->isControlOpcode(I)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mListener:Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;

    .line 10
    .line 11
    invoke-interface {v0, p1}, Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;->onChunkReassembled(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    .line 12
    .line 13
    .line 14
    :cond_0
    return-void
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

.method private log_d(Ljava/lang/String;)V
    .locals 2

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "HTTPReassembly("

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/HTTPReassembly;->isTx()Z

    .line 9
    .line 10
    .line 11
    move-result v1

    .line 12
    if-eqz v1, :cond_0

    .line 13
    .line 14
    const-string v1, "TX"

    .line 15
    .line 16
    goto :goto_0

    .line 17
    :cond_0
    const-string v1, "RX"

    .line 18
    .line 19
    :goto_0
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 20
    .line 21
    .line 22
    const-string v1, ")"

    .line 23
    .line 24
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 25
    .line 26
    .line 27
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
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
.end method

.method private reassembleChunks(Ljava/util/ArrayList;)Lcom/emanuelef/remote_capture/model/PayloadChunk;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/model/PayloadChunk;",
            ">;)",
            "Lcom/emanuelef/remote_capture/model/PayloadChunk;"
        }
    .end annotation

    .line 1
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    const/4 v1, 0x1

    .line 6
    const/4 v2, 0x0

    .line 7
    if-ne v0, v1, :cond_0

    .line 8
    .line 9
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    check-cast p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 14
    .line 15
    return-object p1

    .line 16
    :cond_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    const/4 v1, 0x0

    .line 21
    const/4 v3, 0x0

    .line 22
    :goto_0
    if-ge v3, v0, :cond_1

    .line 23
    .line 24
    invoke-virtual {p1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 25
    .line 26
    .line 27
    move-result-object v4

    .line 28
    add-int/lit8 v3, v3, 0x1

    .line 29
    .line 30
    check-cast v4, Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 31
    .line 32
    iget-object v4, v4, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 33
    .line 34
    array-length v4, v4

    .line 35
    add-int/2addr v1, v4

    .line 36
    goto :goto_0

    .line 37
    :cond_1
    new-array v0, v1, [B

    .line 38
    .line 39
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 40
    .line 41
    .line 42
    move-result v1

    .line 43
    const/4 v3, 0x0

    .line 44
    const/4 v4, 0x0

    .line 45
    :goto_1
    if-ge v4, v1, :cond_2

    .line 46
    .line 47
    invoke-virtual {p1, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 48
    .line 49
    .line 50
    move-result-object v5

    .line 51
    add-int/lit8 v4, v4, 0x1

    .line 52
    .line 53
    check-cast v5, Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 54
    .line 55
    iget-object v6, v5, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 56
    .line 57
    array-length v7, v6

    .line 58
    invoke-static {v6, v2, v0, v3, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 59
    .line 60
    .line 61
    iget-object v5, v5, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 62
    .line 63
    array-length v5, v5

    .line 64
    add-int/2addr v3, v5

    .line 65
    goto :goto_1

    .line 66
    :cond_2
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 67
    .line 68
    .line 69
    move-result-object p1

    .line 70
    check-cast p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 71
    .line 72
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->withPayload([B)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 73
    .line 74
    .line 75
    move-result-object p1

    .line 76
    return-object p1
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

.method private reset()V
    .locals 2

    .line 1
    const/4 v0, 0x1

    .line 2
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReadingHeaders:Z

    .line 3
    .line 4
    sget-object v0, Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;->UNKNOWN:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 5
    .line 6
    iput-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 7
    .line 8
    const/4 v0, 0x0

    .line 9
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mChunkedEncoding:Z

    .line 10
    .line 11
    const/4 v1, -0x1

    .line 12
    iput v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 13
    .line 14
    const/4 v1, 0x0

    .line 15
    iput-object v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 16
    .line 17
    iput v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeadersSize:I

    .line 18
    .line 19
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeaders:Ljava/util/ArrayList;

    .line 20
    .line 21
    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 22
    .line 23
    .line 24
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBody:Ljava/util/ArrayList;

    .line 25
    .line 26
    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 27
    .line 28
    .line 29
    return-void
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


# virtual methods
.method public handleChunk(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V
    .locals 12

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mSwitchingProtocols:Z

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mWebsocketUpgrade:Z

    .line 6
    .line 7
    if-eqz v0, :cond_33

    .line 8
    .line 9
    sget-object v0, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->WEBSOCKET:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 10
    .line 11
    iput-object v0, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->type:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 12
    .line 13
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mDumpPayload:Z

    .line 14
    .line 15
    if-eqz v0, :cond_33

    .line 16
    .line 17
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mWebSocketDecoder:Lcom/emanuelef/remote_capture/WebSocketDecoder;

    .line 18
    .line 19
    if-nez v0, :cond_0

    .line 20
    .line 21
    new-instance v0, Lcom/emanuelef/remote_capture/WebSocketDecoder;

    .line 22
    .line 23
    new-instance v1, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;

    .line 24
    .line 25
    const/4 v2, 0x2

    .line 26
    invoke-direct {v1, v2, p0}, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda4;-><init>(ILjava/lang/Object;)V

    .line 27
    .line 28
    .line 29
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/WebSocketDecoder;-><init>(Lcom/emanuelef/remote_capture/WebSocketDecoder$DecodedFrameListener;)V

    .line 30
    .line 31
    .line 32
    iput-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mWebSocketDecoder:Lcom/emanuelef/remote_capture/WebSocketDecoder;

    .line 33
    .line 34
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mWebSocketDecoder:Lcom/emanuelef/remote_capture/WebSocketDecoder;

    .line 35
    .line 36
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/WebSocketDecoder;->handleChunk(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    .line 37
    .line 38
    .line 39
    return-void

    .line 40
    :cond_1
    iget-object v0, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 41
    .line 42
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 43
    .line 44
    const/4 v2, 0x0

    .line 45
    if-nez v1, :cond_2

    .line 46
    .line 47
    invoke-virtual {p1, v2}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->withPayload([B)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 48
    .line 49
    .line 50
    move-result-object v1

    .line 51
    iput-object v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 52
    .line 53
    :cond_2
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReadingHeaders:Z

    .line 54
    .line 55
    const/16 v3, 0x10

    .line 56
    .line 57
    const/4 v4, 0x1

    .line 58
    const/4 v5, 0x0

    .line 59
    if-eqz v1, :cond_1a

    .line 60
    .line 61
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->getEndOfHTTPHeaders([B)I

    .line 62
    .line 63
    .line 64
    move-result v1

    .line 65
    if-nez v1, :cond_3

    .line 66
    .line 67
    array-length v6, v0

    .line 68
    goto :goto_0

    .line 69
    :cond_3
    move v6, v1

    .line 70
    :goto_0
    iget v7, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeadersSize:I

    .line 71
    .line 72
    if-nez v7, :cond_4

    .line 73
    .line 74
    const/4 v8, 0x1

    .line 75
    goto :goto_1

    .line 76
    :cond_4
    const/4 v8, 0x0

    .line 77
    :goto_1
    add-int/2addr v7, v6

    .line 78
    iput v7, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeadersSize:I

    .line 79
    .line 80
    :try_start_0
    new-instance v7, Ljava/io/BufferedReader;

    .line 81
    .line 82
    new-instance v9, Ljava/io/InputStreamReader;

    .line 83
    .line 84
    new-instance v10, Ljava/io/ByteArrayInputStream;

    .line 85
    .line 86
    invoke-direct {v10, v0, v5, v6}, Ljava/io/ByteArrayInputStream;-><init>([BII)V

    .line 87
    .line 88
    .line 89
    invoke-direct {v9, v10}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 90
    .line 91
    .line 92
    invoke-direct {v7, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    .line 93
    .line 94
    .line 95
    :try_start_1
    invoke-virtual {v7}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    .line 96
    .line 97
    .line 98
    move-result-object v6

    .line 99
    if-eqz v8, :cond_a

    .line 100
    .line 101
    if-eqz v6, :cond_a

    .line 102
    .line 103
    iget-boolean v8, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 104
    .line 105
    const/16 v9, 0x20

    .line 106
    .line 107
    if-eqz v8, :cond_8

    .line 108
    .line 109
    invoke-virtual {v6, v9}, Ljava/lang/String;->indexOf(I)I

    .line 110
    .line 111
    .line 112
    move-result v8

    .line 113
    add-int/lit8 v10, v8, 0x1

    .line 114
    .line 115
    invoke-virtual {v6, v9, v10}, Ljava/lang/String;->indexOf(II)I

    .line 116
    .line 117
    .line 118
    move-result v9

    .line 119
    if-lez v8, :cond_a

    .line 120
    .line 121
    if-lez v9, :cond_a

    .line 122
    .line 123
    iget-object v11, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 124
    .line 125
    invoke-virtual {v6, v5, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 126
    .line 127
    .line 128
    move-result-object v8

    .line 129
    invoke-virtual {v8}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    .line 130
    .line 131
    .line 132
    move-result-object v8

    .line 133
    iput-object v8, v11, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpMethod:Ljava/lang/String;

    .line 134
    .line 135
    iget-object v8, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 136
    .line 137
    add-int/lit8 v11, v9, 0x1

    .line 138
    .line 139
    invoke-virtual {v6, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 140
    .line 141
    .line 142
    move-result-object v11

    .line 143
    iput-object v11, v8, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpVersion:Ljava/lang/String;

    .line 144
    .line 145
    invoke-virtual {v6, v10, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 146
    .line 147
    .line 148
    move-result-object v8

    .line 149
    const-string v9, "/"

    .line 150
    .line 151
    invoke-virtual {v8, v9}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 152
    .line 153
    .line 154
    move-result v9

    .line 155
    if-nez v9, :cond_6

    .line 156
    .line 157
    const-string v9, "://"

    .line 158
    .line 159
    invoke-virtual {v8, v9}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    .line 160
    .line 161
    .line 162
    move-result v9

    .line 163
    if-lez v9, :cond_5

    .line 164
    .line 165
    add-int/lit8 v9, v9, 0x3

    .line 166
    .line 167
    invoke-virtual {v8, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 168
    .line 169
    .line 170
    move-result-object v8

    .line 171
    goto :goto_2

    .line 172
    :catchall_0
    move-exception v6

    .line 173
    goto/16 :goto_7

    .line 174
    .line 175
    :cond_5
    :goto_2
    const/16 v9, 0x2f

    .line 176
    .line 177
    invoke-virtual {v8, v9}, Ljava/lang/String;->indexOf(I)I

    .line 178
    .line 179
    .line 180
    move-result v9

    .line 181
    if-lez v9, :cond_6

    .line 182
    .line 183
    iget-object v10, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 184
    .line 185
    invoke-virtual {v8, v5, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 186
    .line 187
    .line 188
    move-result-object v11

    .line 189
    iput-object v11, v10, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpHost:Ljava/lang/String;

    .line 190
    .line 191
    invoke-virtual {v8, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 192
    .line 193
    .line 194
    move-result-object v8

    .line 195
    :cond_6
    const/16 v9, 0x3f

    .line 196
    .line 197
    invoke-virtual {v8, v9}, Ljava/lang/String;->indexOf(I)I

    .line 198
    .line 199
    .line 200
    move-result v9

    .line 201
    if-ltz v9, :cond_7

    .line 202
    .line 203
    iget-object v10, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 204
    .line 205
    invoke-virtual {v8, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 206
    .line 207
    .line 208
    move-result-object v11

    .line 209
    iput-object v11, v10, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpQuery:Ljava/lang/String;

    .line 210
    .line 211
    invoke-virtual {v8, v5, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 212
    .line 213
    .line 214
    move-result-object v8

    .line 215
    :cond_7
    iget-object v9, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 216
    .line 217
    iput-object v8, v9, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpPath:Ljava/lang/String;

    .line 218
    .line 219
    goto :goto_4

    .line 220
    :cond_8
    const-string v8, "HTTP/"

    .line 221
    .line 222
    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 223
    .line 224
    .line 225
    move-result v8

    .line 226
    if-eqz v8, :cond_a

    .line 227
    .line 228
    invoke-virtual {v6, v9}, Ljava/lang/String;->indexOf(I)I

    .line 229
    .line 230
    .line 231
    move-result v8

    .line 232
    if-lez v8, :cond_a

    .line 233
    .line 234
    iget-object v10, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 235
    .line 236
    invoke-virtual {v6, v5, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 237
    .line 238
    .line 239
    move-result-object v11

    .line 240
    iput-object v11, v10, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpVersion:Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 241
    .line 242
    add-int/2addr v8, v4

    .line 243
    :try_start_2
    invoke-virtual {v6, v9, v8}, Ljava/lang/String;->indexOf(II)I

    .line 244
    .line 245
    .line 246
    move-result v9

    .line 247
    iget-object v10, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 248
    .line 249
    if-lez v9, :cond_9

    .line 250
    .line 251
    move v11, v9

    .line 252
    goto :goto_3

    .line 253
    :cond_9
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    .line 254
    .line 255
    .line 256
    move-result v11

    .line 257
    :goto_3
    invoke-virtual {v6, v8, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 258
    .line 259
    .line 260
    move-result-object v8

    .line 261
    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    .line 262
    .line 263
    .line 264
    move-result v8

    .line 265
    iput v8, v10, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpResponseCode:I

    .line 266
    .line 267
    if-lez v9, :cond_a

    .line 268
    .line 269
    iget-object v8, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 270
    .line 271
    add-int/2addr v9, v4

    .line 272
    invoke-virtual {v6, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 273
    .line 274
    .line 275
    move-result-object v9

    .line 276
    iput-object v9, v8, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpResponseStatus:Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 277
    .line 278
    goto :goto_4

    .line 279
    :catch_0
    nop

    .line 280
    :cond_a
    :goto_4
    if-eqz v6, :cond_16

    .line 281
    .line 282
    :try_start_3
    invoke-virtual {v6}, Ljava/lang/String;->isEmpty()Z

    .line 283
    .line 284
    .line 285
    move-result v8

    .line 286
    if-nez v8, :cond_16

    .line 287
    .line 288
    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    .line 289
    .line 290
    .line 291
    move-result-object v6

    .line 292
    const-string v8, "content-encoding: "

    .line 293
    .line 294
    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 295
    .line 296
    .line 297
    move-result v8

    .line 298
    if-eqz v8, :cond_f

    .line 299
    .line 300
    const/16 v8, 0x12

    .line 301
    .line 302
    invoke-virtual {v6, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 303
    .line 304
    .line 305
    move-result-object v6

    .line 306
    new-instance v8, Ljava/lang/StringBuilder;

    .line 307
    .line 308
    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 309
    .line 310
    .line 311
    const-string v9, "Content-Encoding: "

    .line 312
    .line 313
    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 314
    .line 315
    .line 316
    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 317
    .line 318
    .line 319
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 320
    .line 321
    .line 322
    move-result-object v8

    .line 323
    invoke-direct {p0, v8}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V

    .line 324
    .line 325
    .line 326
    invoke-virtual {v6}, Ljava/lang/String;->hashCode()I

    .line 327
    .line 328
    .line 329
    move-result v8

    .line 330
    const/16 v9, 0xc50

    .line 331
    .line 332
    if-eq v8, v9, :cond_e

    .line 333
    .line 334
    const v9, 0x30a95a

    .line 335
    .line 336
    .line 337
    if-eq v8, v9, :cond_d

    .line 338
    .line 339
    const v9, 0x393369

    .line 340
    .line 341
    .line 342
    if-eq v8, v9, :cond_c

    .line 343
    .line 344
    const v9, 0x5c188c2b

    .line 345
    .line 346
    .line 347
    if-eq v8, v9, :cond_b

    .line 348
    .line 349
    goto/16 :goto_6

    .line 350
    .line 351
    :cond_b
    const-string v8, "deflate"

    .line 352
    .line 353
    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 354
    .line 355
    .line 356
    move-result v6

    .line 357
    if-eqz v6, :cond_15

    .line 358
    .line 359
    sget-object v6, Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;->DEFLATE:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 360
    .line 361
    iput-object v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 362
    .line 363
    goto/16 :goto_6

    .line 364
    .line 365
    :cond_c
    const-string v8, "zstd"

    .line 366
    .line 367
    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 368
    .line 369
    .line 370
    move-result v6

    .line 371
    if-eqz v6, :cond_15

    .line 372
    .line 373
    sget-object v6, Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;->ZSTD:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 374
    .line 375
    iput-object v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 376
    .line 377
    goto/16 :goto_6

    .line 378
    .line 379
    :cond_d
    const-string v8, "gzip"

    .line 380
    .line 381
    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 382
    .line 383
    .line 384
    move-result v6

    .line 385
    if-eqz v6, :cond_15

    .line 386
    .line 387
    sget-object v6, Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;->GZIP:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 388
    .line 389
    iput-object v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 390
    .line 391
    goto/16 :goto_6

    .line 392
    .line 393
    :cond_e
    const-string v8, "br"

    .line 394
    .line 395
    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 396
    .line 397
    .line 398
    move-result v6

    .line 399
    if-eqz v6, :cond_15

    .line 400
    .line 401
    sget-object v6, Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;->BROTLI:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 402
    .line 403
    iput-object v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 404
    .line 405
    goto/16 :goto_6

    .line 406
    .line 407
    :cond_f
    const-string v8, "content-type: "

    .line 408
    .line 409
    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 410
    .line 411
    .line 412
    move-result v8

    .line 413
    if-eqz v8, :cond_11

    .line 414
    .line 415
    const-string v8, ";"

    .line 416
    .line 417
    invoke-virtual {v6, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    .line 418
    .line 419
    .line 420
    move-result v8

    .line 421
    iget-object v9, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 422
    .line 423
    if-lez v8, :cond_10

    .line 424
    .line 425
    goto :goto_5

    .line 426
    :cond_10
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    .line 427
    .line 428
    .line 429
    move-result v8

    .line 430
    :goto_5
    const/16 v10, 0xe

    .line 431
    .line 432
    invoke-virtual {v6, v10, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 433
    .line 434
    .line 435
    move-result-object v6

    .line 436
    iput-object v6, v9, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpContentType:Ljava/lang/String;

    .line 437
    .line 438
    new-instance v6, Ljava/lang/StringBuilder;

    .line 439
    .line 440
    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 441
    .line 442
    .line 443
    const-string v8, "Content-Type: "

    .line 444
    .line 445
    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 446
    .line 447
    .line 448
    iget-object v8, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 449
    .line 450
    iget-object v8, v8, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpContentType:Ljava/lang/String;

    .line 451
    .line 452
    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 453
    .line 454
    .line 455
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 456
    .line 457
    .line 458
    move-result-object v6

    .line 459
    invoke-direct {p0, v6}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V

    .line 460
    .line 461
    .line 462
    goto :goto_6

    .line 463
    :cond_11
    const-string v8, "content-length: "

    .line 464
    .line 465
    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 466
    .line 467
    .line 468
    move-result v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 469
    if-eqz v8, :cond_12

    .line 470
    .line 471
    :try_start_4
    invoke-virtual {v6, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 472
    .line 473
    .line 474
    move-result-object v6

    .line 475
    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    .line 476
    .line 477
    .line 478
    move-result v6

    .line 479
    iput v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 480
    .line 481
    new-instance v6, Ljava/lang/StringBuilder;

    .line 482
    .line 483
    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 484
    .line 485
    .line 486
    const-string v8, "Content-Length: "

    .line 487
    .line 488
    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 489
    .line 490
    .line 491
    iget v8, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 492
    .line 493
    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 494
    .line 495
    .line 496
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 497
    .line 498
    .line 499
    move-result-object v6

    .line 500
    invoke-direct {p0, v6}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 501
    .line 502
    .line 503
    goto :goto_6

    .line 504
    :cond_12
    :try_start_5
    const-string v8, "upgrade: "

    .line 505
    .line 506
    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 507
    .line 508
    .line 509
    move-result v8

    .line 510
    if-eqz v8, :cond_13

    .line 511
    .line 512
    const-string v8, "Upgrade found, stop parsing"

    .line 513
    .line 514
    invoke-direct {p0, v8}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V

    .line 515
    .line 516
    .line 517
    iput-boolean v4, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mSwitchingProtocols:Z

    .line 518
    .line 519
    iput-boolean v5, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReassembleChunks:Z

    .line 520
    .line 521
    const-string v8, "upgrade: websocket"

    .line 522
    .line 523
    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 524
    .line 525
    .line 526
    move-result v6

    .line 527
    if-eqz v6, :cond_15

    .line 528
    .line 529
    const-string v6, "websocket upgrade"

    .line 530
    .line 531
    invoke-direct {p0, v6}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V

    .line 532
    .line 533
    .line 534
    iput-boolean v4, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mWebsocketUpgrade:Z

    .line 535
    .line 536
    goto :goto_6

    .line 537
    :cond_13
    const-string v8, "transfer-encoding: chunked"

    .line 538
    .line 539
    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 540
    .line 541
    .line 542
    move-result v8

    .line 543
    if-eqz v8, :cond_14

    .line 544
    .line 545
    const-string v6, "Detected chunked encoding"

    .line 546
    .line 547
    invoke-direct {p0, v6}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V

    .line 548
    .line 549
    .line 550
    iput-boolean v4, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mChunkedEncoding:Z

    .line 551
    .line 552
    goto :goto_6

    .line 553
    :cond_14
    const-string v8, "host: "

    .line 554
    .line 555
    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 556
    .line 557
    .line 558
    move-result v8

    .line 559
    if-eqz v8, :cond_15

    .line 560
    .line 561
    const-string v8, "Detected HTTP host"

    .line 562
    .line 563
    invoke-direct {p0, v8}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V

    .line 564
    .line 565
    .line 566
    iget-object v8, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 567
    .line 568
    const/4 v9, 0x6

    .line 569
    invoke-virtual {v6, v9}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 570
    .line 571
    .line 572
    move-result-object v6

    .line 573
    iput-object v6, v8, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpHost:Ljava/lang/String;

    .line 574
    .line 575
    :catch_1
    :cond_15
    :goto_6
    invoke-virtual {v7}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    .line 576
    .line 577
    .line 578
    move-result-object v6
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 579
    goto/16 :goto_4

    .line 580
    .line 581
    :cond_16
    :try_start_6
    invoke-virtual {v7}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    .line 582
    .line 583
    .line 584
    goto :goto_9

    .line 585
    :catch_2
    nop

    .line 586
    goto :goto_9

    .line 587
    :goto_7
    :try_start_7
    invoke-virtual {v7}, Ljava/io/BufferedReader;->close()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 588
    .line 589
    .line 590
    goto :goto_8

    .line 591
    :catchall_1
    move-exception v7

    .line 592
    :try_start_8
    invoke-virtual {v6, v7}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .line 593
    .line 594
    .line 595
    :goto_8
    throw v6
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_2

    .line 596
    :goto_9
    if-lez v1, :cond_17

    .line 597
    .line 598
    iput-boolean v5, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReadingHeaders:Z

    .line 599
    .line 600
    iget-boolean v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mDumpPayload:Z

    .line 601
    .line 602
    if-eqz v6, :cond_1b

    .line 603
    .line 604
    iget-object v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeaders:Ljava/util/ArrayList;

    .line 605
    .line 606
    invoke-virtual {p1, v5, v1}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->subchunk(II)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 607
    .line 608
    .line 609
    move-result-object v7

    .line 610
    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 611
    .line 612
    .line 613
    goto :goto_a

    .line 614
    :cond_17
    iget v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeadersSize:I

    .line 615
    .line 616
    const/16 v6, 0x400

    .line 617
    .line 618
    if-le v1, v6, :cond_18

    .line 619
    .line 620
    const-string v1, "Assuming not HTTP"

    .line 621
    .line 622
    invoke-direct {p0, v1}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V

    .line 623
    .line 624
    .line 625
    iput-boolean v5, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReadingHeaders:Z

    .line 626
    .line 627
    iput-boolean v5, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReassembleChunks:Z

    .line 628
    .line 629
    iput-boolean v4, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mInvalidHttp:Z

    .line 630
    .line 631
    :cond_18
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mDumpPayload:Z

    .line 632
    .line 633
    if-eqz v1, :cond_19

    .line 634
    .line 635
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeaders:Ljava/util/ArrayList;

    .line 636
    .line 637
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 638
    .line 639
    .line 640
    :cond_19
    array-length v1, v0

    .line 641
    goto :goto_a

    .line 642
    :cond_1a
    const/4 v1, 0x0

    .line 643
    :cond_1b
    :goto_a
    iget-boolean v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReassembleChunks:Z

    .line 644
    .line 645
    if-nez v6, :cond_1c

    .line 646
    .line 647
    iput-boolean v5, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReadingHeaders:Z

    .line 648
    .line 649
    :cond_1c
    iget-boolean v6, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReadingHeaders:Z

    .line 650
    .line 651
    if-eqz v6, :cond_1d

    .line 652
    .line 653
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->isHttp2Rst()Z

    .line 654
    .line 655
    .line 656
    move-result v6

    .line 657
    if-eqz v6, :cond_1d

    .line 658
    .line 659
    iput-boolean v5, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReadingHeaders:Z

    .line 660
    .line 661
    const/4 v6, 0x1

    .line 662
    goto :goto_b

    .line 663
    :cond_1d
    const/4 v6, 0x0

    .line 664
    :goto_b
    iget-boolean v7, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReadingHeaders:Z

    .line 665
    .line 666
    if-nez v7, :cond_33

    .line 667
    .line 668
    array-length v7, v0

    .line 669
    sub-int/2addr v7, v1

    .line 670
    iget-boolean v8, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mChunkedEncoding:Z

    .line 671
    .line 672
    if-eqz v8, :cond_1f

    .line 673
    .line 674
    iget v8, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 675
    .line 676
    if-gez v8, :cond_1f

    .line 677
    .line 678
    if-lez v7, :cond_1f

    .line 679
    .line 680
    :try_start_9
    new-instance v8, Ljava/io/BufferedReader;

    .line 681
    .line 682
    new-instance v9, Ljava/io/InputStreamReader;

    .line 683
    .line 684
    new-instance v10, Ljava/io/ByteArrayInputStream;

    .line 685
    .line 686
    invoke-direct {v10, v0, v1, v7}, Ljava/io/ByteArrayInputStream;-><init>([BII)V

    .line 687
    .line 688
    .line 689
    invoke-direct {v9, v10}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 690
    .line 691
    .line 692
    invoke-direct {v8, v9}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_5

    .line 693
    .line 694
    .line 695
    :try_start_a
    invoke-virtual {v8}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    .line 696
    .line 697
    .line 698
    move-result-object v0
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    .line 699
    if-eqz v0, :cond_1e

    .line 700
    .line 701
    :try_start_b
    invoke-static {v0, v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    .line 702
    .line 703
    .line 704
    move-result v3

    .line 705
    iput v3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 706
    .line 707
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    .line 708
    .line 709
    .line 710
    move-result v3

    .line 711
    add-int/lit8 v3, v3, 0x2

    .line 712
    .line 713
    add-int/2addr v1, v3

    .line 714
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    .line 715
    .line 716
    .line 717
    move-result v0

    .line 718
    add-int/lit8 v0, v0, 0x2

    .line 719
    .line 720
    sub-int/2addr v7, v0

    .line 721
    new-instance v0, Ljava/lang/StringBuilder;

    .line 722
    .line 723
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 724
    .line 725
    .line 726
    const-string v3, "Chunk length: "

    .line 727
    .line 728
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 729
    .line 730
    .line 731
    iget v3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 732
    .line 733
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 734
    .line 735
    .line 736
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 737
    .line 738
    .line 739
    move-result-object v0

    .line 740
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/HTTPReassembly;->log_d(Ljava/lang/String;)V

    .line 741
    .line 742
    .line 743
    iget v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I
    :try_end_b
    .catch Ljava/lang/NumberFormatException; {:try_start_b .. :try_end_b} :catch_3
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    .line 744
    .line 745
    if-nez v0, :cond_1e

    .line 746
    .line 747
    goto :goto_c

    .line 748
    :catchall_2
    move-exception v0

    .line 749
    goto :goto_d

    .line 750
    :catch_3
    :cond_1e
    const/4 v4, 0x0

    .line 751
    :goto_c
    :try_start_c
    invoke-virtual {v8}, Ljava/io/BufferedReader;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_4

    .line 752
    .line 753
    .line 754
    goto :goto_f

    .line 755
    :catch_4
    nop

    .line 756
    goto :goto_f

    .line 757
    :goto_d
    :try_start_d
    invoke-virtual {v8}, Ljava/io/BufferedReader;->close()V
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_3

    .line 758
    .line 759
    .line 760
    goto :goto_e

    .line 761
    :catchall_3
    move-exception v3

    .line 762
    :try_start_e
    invoke-virtual {v0, v3}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .line 763
    .line 764
    .line 765
    :goto_e
    throw v0
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_5

    .line 766
    :catch_5
    nop

    .line 767
    :cond_1f
    const/4 v4, 0x0

    .line 768
    :goto_f
    const/4 v0, -0x1

    .line 769
    if-lez v7, :cond_25

    .line 770
    .line 771
    iget v3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 772
    .line 773
    if-lez v3, :cond_22

    .line 774
    .line 775
    if-ge v7, v3, :cond_20

    .line 776
    .line 777
    sub-int/2addr v3, v7

    .line 778
    iput v3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 779
    .line 780
    goto :goto_11

    .line 781
    :cond_20
    add-int v7, v1, v3

    .line 782
    .line 783
    iput v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 784
    .line 785
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mChunkedEncoding:Z

    .line 786
    .line 787
    if-eqz v0, :cond_21

    .line 788
    .line 789
    add-int/lit8 v0, v7, 0x2

    .line 790
    .line 791
    :goto_10
    move v7, v3

    .line 792
    goto :goto_11

    .line 793
    :cond_21
    move v0, v7

    .line 794
    goto :goto_10

    .line 795
    :cond_22
    :goto_11
    iget-boolean v3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mDumpPayload:Z

    .line 796
    .line 797
    if-eqz v3, :cond_24

    .line 798
    .line 799
    if-nez v1, :cond_23

    .line 800
    .line 801
    iget-object v3, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 802
    .line 803
    array-length v3, v3

    .line 804
    if-ne v7, v3, :cond_23

    .line 805
    .line 806
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBody:Ljava/util/ArrayList;

    .line 807
    .line 808
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 809
    .line 810
    .line 811
    goto :goto_12

    .line 812
    :cond_23
    iget-object v3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBody:Ljava/util/ArrayList;

    .line 813
    .line 814
    invoke-virtual {p1, v1, v7}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->subchunk(II)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 815
    .line 816
    .line 817
    move-result-object v1

    .line 818
    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 819
    .line 820
    .line 821
    :cond_24
    :goto_12
    iget v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBodySize:I

    .line 822
    .line 823
    add-int/2addr v1, v7

    .line 824
    iput v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBodySize:I

    .line 825
    .line 826
    :cond_25
    if-nez v4, :cond_26

    .line 827
    .line 828
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReassembleChunks:Z

    .line 829
    .line 830
    if-nez v1, :cond_27

    .line 831
    .line 832
    :cond_26
    iput-boolean v5, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mChunkedEncoding:Z

    .line 833
    .line 834
    :cond_27
    iget v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentLength:I

    .line 835
    .line 836
    if-lez v1, :cond_28

    .line 837
    .line 838
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mReassembleChunks:Z

    .line 839
    .line 840
    if-nez v1, :cond_32

    .line 841
    .line 842
    :cond_28
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mChunkedEncoding:Z

    .line 843
    .line 844
    if-nez v1, :cond_32

    .line 845
    .line 846
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mDumpPayload:Z

    .line 847
    .line 848
    if-eqz v1, :cond_2b

    .line 849
    .line 850
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mHeaders:Ljava/util/ArrayList;

    .line 851
    .line 852
    invoke-direct {p0, v1}, Lcom/emanuelef/remote_capture/HTTPReassembly;->reassembleChunks(Ljava/util/ArrayList;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 853
    .line 854
    .line 855
    move-result-object v1

    .line 856
    iget-object v3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBody:Ljava/util/ArrayList;

    .line 857
    .line 858
    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    .line 859
    .line 860
    .line 861
    move-result v3

    .line 862
    if-nez v3, :cond_29

    .line 863
    .line 864
    iget-object v2, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBody:Ljava/util/ArrayList;

    .line 865
    .line 866
    invoke-direct {p0, v2}, Lcom/emanuelef/remote_capture/HTTPReassembly;->reassembleChunks(Ljava/util/ArrayList;)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 867
    .line 868
    .line 869
    move-result-object v2

    .line 870
    :cond_29
    if-eqz v2, :cond_2a

    .line 871
    .line 872
    iget-object v3, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mContentEncoding:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 873
    .line 874
    sget-object v4, Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;->UNKNOWN:Lcom/emanuelef/remote_capture/HTTPReassembly$ContentEncoding;

    .line 875
    .line 876
    if-eq v3, v4, :cond_2a

    .line 877
    .line 878
    invoke-direct {p0, v2}, Lcom/emanuelef/remote_capture/HTTPReassembly;->decodeBody(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    .line 879
    .line 880
    .line 881
    :cond_2a
    if-eqz v2, :cond_2c

    .line 882
    .line 883
    iget-object v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 884
    .line 885
    array-length v4, v3

    .line 886
    iget-object v7, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 887
    .line 888
    array-length v7, v7

    .line 889
    add-int/2addr v4, v7

    .line 890
    new-array v4, v4, [B

    .line 891
    .line 892
    array-length v7, v3

    .line 893
    invoke-static {v3, v5, v4, v5, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 894
    .line 895
    .line 896
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 897
    .line 898
    iget-object v1, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 899
    .line 900
    array-length v1, v1

    .line 901
    array-length v7, v3

    .line 902
    invoke-static {v3, v5, v4, v1, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 903
    .line 904
    .line 905
    invoke-virtual {v2, v4}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->withPayload([B)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 906
    .line 907
    .line 908
    move-result-object v1

    .line 909
    goto :goto_13

    .line 910
    :cond_2b
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 911
    .line 912
    :cond_2c
    :goto_13
    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mInvalidHttp:Z

    .line 913
    .line 914
    if-eqz v2, :cond_2d

    .line 915
    .line 916
    sget-object v2, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->RAW:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 917
    .line 918
    iput-object v2, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->type:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 919
    .line 920
    goto :goto_14

    .line 921
    :cond_2d
    iget-object v2, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mFirstChunk:Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 922
    .line 923
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpContentType:Ljava/lang/String;

    .line 924
    .line 925
    iput-object v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpContentType:Ljava/lang/String;

    .line 926
    .line 927
    iget v3, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpResponseCode:I

    .line 928
    .line 929
    iput v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpResponseCode:I

    .line 930
    .line 931
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpResponseStatus:Ljava/lang/String;

    .line 932
    .line 933
    iput-object v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpResponseStatus:Ljava/lang/String;

    .line 934
    .line 935
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpMethod:Ljava/lang/String;

    .line 936
    .line 937
    iput-object v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpMethod:Ljava/lang/String;

    .line 938
    .line 939
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpHost:Ljava/lang/String;

    .line 940
    .line 941
    iput-object v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpHost:Ljava/lang/String;

    .line 942
    .line 943
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpPath:Ljava/lang/String;

    .line 944
    .line 945
    iput-object v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpPath:Ljava/lang/String;

    .line 946
    .line 947
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpQuery:Ljava/lang/String;

    .line 948
    .line 949
    iput-object v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpQuery:Ljava/lang/String;

    .line 950
    .line 951
    iget-object v2, v2, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpVersion:Ljava/lang/String;

    .line 952
    .line 953
    iput-object v2, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpVersion:Ljava/lang/String;

    .line 954
    .line 955
    iget v2, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBodySize:I

    .line 956
    .line 957
    iput v2, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->httpBodyLength:I

    .line 958
    .line 959
    if-eqz v6, :cond_2e

    .line 960
    .line 961
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->setHttpRst()V

    .line 962
    .line 963
    .line 964
    :cond_2e
    :goto_14
    iput v5, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mBodySize:I

    .line 965
    .line 966
    iget-object v2, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->type:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 967
    .line 968
    sget-object v3, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 969
    .line 970
    if-ne v2, v3, :cond_31

    .line 971
    .line 972
    new-instance v2, Ljava/lang/StringBuilder;

    .line 973
    .line 974
    const-string v3, "Reassembled HTTP "

    .line 975
    .line 976
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 977
    .line 978
    .line 979
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->isHttp2Rst()Z

    .line 980
    .line 981
    .line 982
    move-result v3

    .line 983
    if-eqz v3, :cond_2f

    .line 984
    .line 985
    const-string v3, "RST"

    .line 986
    .line 987
    goto :goto_15

    .line 988
    :cond_2f
    iget-boolean v3, v1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->is_sent:Z

    .line 989
    .line 990
    if-eqz v3, :cond_30

    .line 991
    .line 992
    const-string v3, "request"

    .line 993
    .line 994
    goto :goto_15

    .line 995
    :cond_30
    const-string v3, "response"

    .line 996
    .line 997
    :goto_15
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 998
    .line 999
    .line 1000
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 1001
    .line 1002
    .line 1003
    move-result-object v2

    .line 1004
    const-string v3, "HTTPReassembly"

    .line 1005
    .line 1006
    invoke-static {v3, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1007
    .line 1008
    .line 1009
    :cond_31
    iget-object v2, p0, Lcom/emanuelef/remote_capture/HTTPReassembly;->mListener:Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;

    .line 1010
    .line 1011
    invoke-interface {v2, v1}, Lcom/emanuelef/remote_capture/HTTPReassembly$ReassemblyListener;->onChunkReassembled(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    .line 1012
    .line 1013
    .line 1014
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/HTTPReassembly;->reset()V

    .line 1015
    .line 1016
    .line 1017
    :cond_32
    if-lez v0, :cond_33

    .line 1018
    .line 1019
    iget-object v1, p1, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 1020
    .line 1021
    array-length v2, v1

    .line 1022
    if-le v2, v0, :cond_33

    .line 1023
    .line 1024
    array-length v1, v1

    .line 1025
    sub-int/2addr v1, v0

    .line 1026
    invoke-virtual {p1, v0, v1}, Lcom/emanuelef/remote_capture/model/PayloadChunk;->subchunk(II)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 1027
    .line 1028
    .line 1029
    move-result-object p1

    .line 1030
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/HTTPReassembly;->handleChunk(Lcom/emanuelef/remote_capture/model/PayloadChunk;)V

    .line 1031
    .line 1032
    .line 1033
    :cond_33
    return-void
    .line 1034
    .line 1035
    .line 1036
    .line 1037
    .line 1038
    .line 1039
    .line 1040
    .line 1041
    .line 1042
    .line 1043
    .line 1044
    .line 1045
    .line 1046
    .line 1047
    .line 1048
    .line 1049
    .line 1050
    .line 1051
    .line 1052
    .line 1053
    .line 1054
    .line 1055
    .line 1056
    .line 1057
    .line 1058
    .line 1059
    .line 1060
    .line 1061
    .line 1062
    .line 1063
    .line 1064
    .line 1065
    .line 1066
    .line 1067
    .line 1068
    .line 1069
    .line 1070
    .line 1071
    .line 1072
    .line 1073
    .line 1074
    .line 1075
    .line 1076
    .line 1077
    .line 1078
    .line 1079
    .line 1080
    .line 1081
    .line 1082
    .line 1083
    .line 1084
    .line 1085
    .line 1086
    .line 1087
    .line 1088
    .line 1089
    .line 1090
    .line 1091
    .line 1092
    .line 1093
    .line 1094
    .line 1095
    .line 1096
    .line 1097
    .line 1098
    .line 1099
    .line 1100
    .line 1101
    .line 1102
    .line 1103
    .line 1104
    .line 1105
    .line 1106
    .line 1107
    .line 1108
    .line 1109
    .line 1110
    .line 1111
    .line 1112
    .line 1113
    .line 1114
    .line 1115
    .line 1116
    .line 1117
    .line 1118
    .line 1119
    .line 1120
    .line 1121
    .line 1122
    .line 1123
    .line 1124
    .line 1125
    .line 1126
    .line 1127
    .line 1128
    .line 1129
    .line 1130
    .line 1131
    .line 1132
    .line 1133
    .line 1134
    .line 1135
    .line 1136
    .line 1137
    .line 1138
    .line 1139
    .line 1140
    .line 1141
    .line 1142
    .line 1143
    .line 1144
    .line 1145
    .line 1146
    .line 1147
    .line 1148
    .line 1149
    .line 1150
    .line 1151
    .line 1152
    .line 1153
    .line 1154
    .line 1155
    .line 1156
    .line 1157
    .line 1158
    .line 1159
    .line 1160
    .line 1161
    .line 1162
    .line 1163
    .line 1164
    .line 1165
    .line 1166
    .line 1167
    .line 1168
    .line 1169
    .line 1170
    .line 1171
    .line 1172
    .line 1173
    .line 1174
    .line 1175
    .line 1176
    .line 1177
    .line 1178
    .line 1179
    .line 1180
    .line 1181
    .line 1182
    .line 1183
    .line 1184
    .line 1185
    .line 1186
    .line 1187
    .line 1188
    .line 1189
    .line 1190
    .line 1191
    .line 1192
    .line 1193
    .line 1194
    .line 1195
    .line 1196
    .line 1197
    .line 1198
    .line 1199
    .line 1200
    .line 1201
    .line 1202
    .line 1203
    .line 1204
    .line 1205
    .line 1206
    .line 1207
    .line 1208
    .line 1209
    .line 1210
    .line 1211
    .line 1212
    .line 1213
    .line 1214
    .line 1215
    .line 1216
    .line 1217
    .line 1218
    .line 1219
    .line 1220
    .line 1221
    .line 1222
    .line 1223
    .line 1224
    .line 1225
    .line 1226
    .line 1227
    .line 1228
    .line 1229
    .line 1230
    .line 1231
    .line 1232
    .line 1233
    .line 1234
    .line 1235
    .line 1236
    .line 1237
    .line 1238
    .line 1239
    .line 1240
    .line 1241
    .line 1242
    .line 1243
    .line 1244
    .line 1245
    .line 1246
    .line 1247
    .line 1248
    .line 1249
    .line 1250
    .line 1251
    .line 1252
    .line 1253
    .line 1254
    .line 1255
    .line 1256
    .line 1257
    .line 1258
    .line 1259
    .line 1260
    .line 1261
    .line 1262
    .line 1263
    .line 1264
    .line 1265
    .line 1266
    .line 1267
    .line 1268
    .line 1269
    .line 1270
    .line 1271
    .line 1272
    .line 1273
    .line 1274
    .line 1275
    .line 1276
    .line 1277
    .line 1278
    .line 1279
    .line 1280
    .line 1281
    .line 1282
    .line 1283
    .line 1284
    .line 1285
    .line 1286
    .line 1287
    .line 1288
    .line 1289
    .line 1290
    .line 1291
    .line 1292
    .line 1293
    .line 1294
    .line 1295
    .line 1296
    .line 1297
    .line 1298
    .line 1299
    .line 1300
    .line 1301
    .line 1302
    .line 1303
    .line 1304
    .line 1305
    .line 1306
    .line 1307
    .line 1308
    .line 1309
    .line 1310
    .line 1311
    .line 1312
    .line 1313
    .line 1314
    .line 1315
    .line 1316
    .line 1317
    .line 1318
    .line 1319
    .line 1320
    .line 1321
    .line 1322
    .line 1323
    .line 1324
    .line 1325
    .line 1326
    .line 1327
    .line 1328
    .line 1329
    .line 1330
    .line 1331
    .line 1332
    .line 1333
    .line 1334
    .line 1335
    .line 1336
    .line 1337
    .line 1338
    .line 1339
    .line 1340
    .line 1341
    .line 1342
    .line 1343
    .line 1344
    .line 1345
    .line 1346
    .line 1347
    .line 1348
    .line 1349
    .line 1350
    .line 1351
    .line 1352
    .line 1353
    .line 1354
    .line 1355
    .line 1356
    .line 1357
    .line 1358
    .line 1359
    .line 1360
    .line 1361
    .line 1362
    .line 1363
    .line 1364
    .line 1365
    .line 1366
    .line 1367
    .line 1368
    .line 1369
    .line 1370
    .line 1371
    .line 1372
    .line 1373
    .line 1374
    .line 1375
    .line 1376
    .line 1377
    .line 1378
    .line 1379
    .line 1380
    .line 1381
    .line 1382
    .line 1383
    .line 1384
    .line 1385
    .line 1386
    .line 1387
    .line 1388
    .line 1389
    .line 1390
    .line 1391
    .line 1392
    .line 1393
    .line 1394
    .line 1395
    .line 1396
    .line 1397
    .line 1398
    .line 1399
    .line 1400
    .line 1401
    .line 1402
    .line 1403
    .line 1404
    .line 1405
    .line 1406
    .line 1407
    .line 1408
    .line 1409
    .line 1410
    .line 1411
    .line 1412
    .line 1413
    .line 1414
    .line 1415
    .line 1416
    .line 1417
    .line 1418
    .line 1419
    .line 1420
    .line 1421
    .line 1422
    .line 1423
    .line 1424
    .line 1425
    .line 1426
    .line 1427
    .line 1428
    .line 1429
    .line 1430
    .line 1431
    .line 1432
    .line 1433
    .line 1434
    .line 1435
    .line 1436
    .line 1437
    .line 1438
    .line 1439
    .line 1440
    .line 1441
    .line 1442
    .line 1443
    .line 1444
    .line 1445
    .line 1446
    .line 1447
    .line 1448
    .line 1449
    .line 1450
    .line 1451
    .line 1452
    .line 1453
    .line 1454
    .line 1455
    .line 1456
    .line 1457
    .line 1458
    .line 1459
    .line 1460
    .line 1461
    .line 1462
    .line 1463
    .line 1464
    .line 1465
    .line 1466
    .line 1467
    .line 1468
    .line 1469
    .line 1470
    .line 1471
    .line 1472
    .line 1473
    .line 1474
    .line 1475
    .line 1476
    .line 1477
    .line 1478
    .line 1479
    .line 1480
    .line 1481
    .line 1482
    .line 1483
    .line 1484
    .line 1485
    .line 1486
    .line 1487
    .line 1488
    .line 1489
    .line 1490
    .line 1491
    .line 1492
    .line 1493
    .line 1494
    .line 1495
    .line 1496
    .line 1497
    .line 1498
    .line 1499
    .line 1500
    .line 1501
    .line 1502
    .line 1503
    .line 1504
    .line 1505
    .line 1506
    .line 1507
    .line 1508
    .line 1509
    .line 1510
    .line 1511
    .line 1512
    .line 1513
    .line 1514
    .line 1515
    .line 1516
    .line 1517
    .line 1518
    .line 1519
    .line 1520
    .line 1521
    .line 1522
    .line 1523
    .line 1524
    .line 1525
    .line 1526
    .line 1527
    .line 1528
    .line 1529
    .line 1530
    .line 1531
    .line 1532
    .line 1533
    .line 1534
    .line 1535
    .line 1536
    .line 1537
    .line 1538
    .line 1539
    .line 1540
    .line 1541
    .line 1542
    .line 1543
    .line 1544
    .line 1545
    .line 1546
    .line 1547
    .line 1548
    .line 1549
    .line 1550
    .line 1551
    .line 1552
    .line 1553
    .line 1554
    .line 1555
    .line 1556
    .line 1557
    .line 1558
    .line 1559
    .line 1560
    .line 1561
    .line 1562
    .line 1563
    .line 1564
    .line 1565
    .line 1566
    .line 1567
    .line 1568
    .line 1569
    .line 1570
    .line 1571
    .line 1572
    .line 1573
    .line 1574
    .line 1575
    .line 1576
    .line 1577
    .line 1578
    .line 1579
    .line 1580
    .line 1581
    .line 1582
    .line 1583
    .line 1584
    .line 1585
    .line 1586
    .line 1587
    .line 1588
    .line 1589
    .line 1590
    .line 1591
    .line 1592
    .line 1593
    .line 1594
    .line 1595
    .line 1596
    .line 1597
    .line 1598
    .line 1599
    .line 1600
    .line 1601
    .line 1602
    .line 1603
    .line 1604
    .line 1605
    .line 1606
    .line 1607
    .line 1608
    .line 1609
    .line 1610
    .line 1611
    .line 1612
    .line 1613
    .line 1614
    .line 1615
    .line 1616
    .line 1617
    .line 1618
    .line 1619
    .line 1620
    .line 1621
    .line 1622
    .line 1623
    .line 1624
    .line 1625
    .line 1626
    .line 1627
    .line 1628
    .line 1629
    .line 1630
    .line 1631
    .line 1632
    .line 1633
    .line 1634
    .line 1635
    .line 1636
    .line 1637
    .line 1638
    .line 1639
    .line 1640
    .line 1641
    .line 1642
    .line 1643
    .line 1644
    .line 1645
    .line 1646
    .line 1647
    .line 1648
    .line 1649
    .line 1650
    .line 1651
    .line 1652
    .line 1653
    .line 1654
    .line 1655
    .line 1656
    .line 1657
    .line 1658
    .line 1659
    .line 1660
    .line 1661
    .line 1662
    .line 1663
    .line 1664
    .line 1665
    .line 1666
    .line 1667
    .line 1668
    .line 1669
    .line 1670
    .line 1671
    .line 1672
    .line 1673
    .line 1674
    .line 1675
    .line 1676
    .line 1677
    .line 1678
    .line 1679
    .line 1680
    .line 1681
    .line 1682
    .line 1683
    .line 1684
    .line 1685
    .line 1686
    .line 1687
    .line 1688
    .line 1689
    .line 1690
    .line 1691
    .line 1692
    .line 1693
    .line 1694
    .line 1695
    .line 1696
    .line 1697
    .line 1698
    .line 1699
    .line 1700
    .line 1701
    .line 1702
    .line 1703
    .line 1704
    .line 1705
    .line 1706
    .line 1707
    .line 1708
    .line 1709
    .line 1710
    .line 1711
    .line 1712
    .line 1713
    .line 1714
    .line 1715
    .line 1716
    .line 1717
    .line 1718
    .line 1719
    .line 1720
    .line 1721
    .line 1722
    .line 1723
    .line 1724
    .line 1725
    .line 1726
    .line 1727
    .line 1728
    .line 1729
    .line 1730
    .line 1731
    .line 1732
    .line 1733
    .line 1734
    .line 1735
    .line 1736
    .line 1737
    .line 1738
    .line 1739
    .line 1740
    .line 1741
    .line 1742
    .line 1743
    .line 1744
    .line 1745
    .line 1746
    .line 1747
    .line 1748
    .line 1749
    .line 1750
    .line 1751
    .line 1752
    .line 1753
    .line 1754
    .line 1755
    .line 1756
    .line 1757
    .line 1758
    .line 1759
    .line 1760
    .line 1761
    .line 1762
    .line 1763
    .line 1764
    .line 1765
    .line 1766
    .line 1767
    .line 1768
    .line 1769
    .line 1770
    .line 1771
    .line 1772
    .line 1773
    .line 1774
    .line 1775
    .line 1776
    .line 1777
    .line 1778
    .line 1779
    .line 1780
    .line 1781
    .line 1782
    .line 1783
    .line 1784
    .line 1785
    .line 1786
    .line 1787
    .line 1788
    .line 1789
    .line 1790
    .line 1791
    .line 1792
    .line 1793
    .line 1794
    .line 1795
    .line 1796
    .line 1797
    .line 1798
    .line 1799
    .line 1800
    .line 1801
    .line 1802
    .line 1803
    .line 1804
    .line 1805
    .line 1806
    .line 1807
    .line 1808
    .line 1809
    .line 1810
    .line 1811
    .line 1812
    .line 1813
    .line 1814
    .line 1815
    .line 1816
    .line 1817
    .line 1818
    .line 1819
    .line 1820
    .line 1821
    .line 1822
    .line 1823
    .line 1824
    .line 1825
    .line 1826
    .line 1827
    .line 1828
    .line 1829
    .line 1830
    .line 1831
    .line 1832
    .line 1833
    .line 1834
    .line 1835
    .line 1836
    .line 1837
    .line 1838
    .line 1839
    .line 1840
    .line 1841
    .line 1842
    .line 1843
    .line 1844
    .line 1845
    .line 1846
    .line 1847
    .line 1848
    .line 1849
    .line 1850
    .line 1851
    .line 1852
    .line 1853
    .line 1854
    .line 1855
    .line 1856
    .line 1857
    .line 1858
    .line 1859
    .line 1860
    .line 1861
    .line 1862
    .line 1863
    .line 1864
    .line 1865
    .line 1866
    .line 1867
    .line 1868
    .line 1869
    .line 1870
    .line 1871
    .line 1872
    .line 1873
    .line 1874
    .line 1875
    .line 1876
    .line 1877
    .line 1878
    .line 1879
    .line 1880
    .line 1881
    .line 1882
    .line 1883
    .line 1884
    .line 1885
    .line 1886
    .line 1887
    .line 1888
    .line 1889
    .line 1890
    .line 1891
    .line 1892
    .line 1893
    .line 1894
    .line 1895
    .line 1896
    .line 1897
    .line 1898
    .line 1899
    .line 1900
    .line 1901
    .line 1902
    .line 1903
    .line 1904
    .line 1905
    .line 1906
    .line 1907
    .line 1908
    .line 1909
    .line 1910
    .line 1911
    .line 1912
    .line 1913
    .line 1914
    .line 1915
    .line 1916
    .line 1917
    .line 1918
    .line 1919
    .line 1920
    .line 1921
    .line 1922
    .line 1923
    .line 1924
    .line 1925
    .line 1926
    .line 1927
    .line 1928
    .line 1929
    .line 1930
    .line 1931
    .line 1932
    .line 1933
    .line 1934
    .line 1935
    .line 1936
    .line 1937
    .line 1938
    .line 1939
    .line 1940
    .line 1941
    .line 1942
    .line 1943
    .line 1944
    .line 1945
    .line 1946
    .line 1947
    .line 1948
    .line 1949
    .line 1950
    .line 1951
    .line 1952
    .line 1953
    .line 1954
    .line 1955
    .line 1956
    .line 1957
    .line 1958
    .line 1959
    .line 1960
    .line 1961
    .line 1962
    .line 1963
    .line 1964
    .line 1965
    .line 1966
    .line 1967
    .line 1968
    .line 1969
    .line 1970
    .line 1971
    .line 1972
    .line 1973
    .line 1974
    .line 1975
    .line 1976
    .line 1977
    .line 1978
    .line 1979
    .line 1980
    .line 1981
    .line 1982
    .line 1983
    .line 1984
    .line 1985
    .line 1986
    .line 1987
    .line 1988
    .line 1989
    .line 1990
    .line 1991
    .line 1992
    .line 1993
    .line 1994
    .line 1995
    .line 1996
    .line 1997
    .line 1998
    .line 1999
    .line 2000
    .line 2001
    .line 2002
    .line 2003
    .line 2004
    .line 2005
    .line 2006
    .line 2007
    .line 2008
    .line 2009
    .line 2010
    .line 2011
    .line 2012
    .line 2013
    .line 2014
    .line 2015
    .line 2016
    .line 2017
    .line 2018
    .line 2019
    .line 2020
    .line 2021
    .line 2022
    .line 2023
    .line 2024
    .line 2025
    .line 2026
    .line 2027
    .line 2028
    .line 2029
    .line 2030
    .line 2031
    .line 2032
    .line 2033
    .line 2034
    .line 2035
    .line 2036
    .line 2037
    .line 2038
    .line 2039
    .line 2040
    .line 2041
    .line 2042
    .line 2043
    .line 2044
    .line 2045
    .line 2046
    .line 2047
    .line 2048
    .line 2049
    .line 2050
    .line 2051
    .line 2052
    .line 2053
    .line 2054
    .line 2055
    .line 2056
    .line 2057
    .line 2058
    .line 2059
    .line 2060
    .line 2061
    .line 2062
    .line 2063
    .line 2064
    .line 2065
    .line 2066
    .line 2067
    .line 2068
    .line 2069
    .line 2070
    .line 2071
    .line 2072
    .line 2073
    .line 2074
    .line 2075
    .line 2076
    .line 2077
    .line 2078
    .line 2079
    .line 2080
    .line 2081
    .line 2082
    .line 2083
    .line 2084
    .line 2085
    .line 2086
    .line 2087
    .line 2088
    .line 2089
    .line 2090
    .line 2091
    .line 2092
    .line 2093
    .line 2094
    .line 2095
    .line 2096
    .line 2097
    .line 2098
    .line 2099
    .line 2100
    .line 2101
    .line 2102
    .line 2103
    .line 2104
    .line 2105
    .line 2106
    .line 2107
    .line 2108
    .line 2109
    .line 2110
    .line 2111
    .line 2112
    .line 2113
    .line 2114
    .line 2115
    .line 2116
    .line 2117
    .line 2118
    .line 2119
    .line 2120
    .line 2121
    .line 2122
    .line 2123
    .line 2124
    .line 2125
    .line 2126
    .line 2127
    .line 2128
    .line 2129
    .line 2130
    .line 2131
    .line 2132
    .line 2133
    .line 2134
    .line 2135
    .line 2136
    .line 2137
    .line 2138
    .line 2139
    .line 2140
    .line 2141
    .line 2142
.end method
