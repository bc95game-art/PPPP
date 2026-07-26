.class Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ClientHandler"
.end annotation


# static fields
.field static final INPUT_BUFSIZE:I = 0x400


# instance fields
.field mChunkedOutputStream:Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;

.field final mFname:Ljava/lang/String;

.field mHasError:Z

.field mHeaderSent:Z

.field final mInputStream:Ljava/io/InputStream;

.field mIsClosed:Z

.field final mMimeType:Ljava/lang/String;

.field final mOutputStream:Ljava/io/OutputStream;

.field mReadyForData:Z

.field mSocket:Ljava/net/Socket;


# direct methods
.method public static bridge synthetic -$$Nest$mclose(Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;)V
    .locals 1

    .line 1
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->close(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/net/Socket;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mSocket:Ljava/net/Socket;

    .line 5
    .line 6
    iput-object p3, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mFname:Ljava/lang/String;

    .line 7
    .line 8
    invoke-virtual {p1}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    iput-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mInputStream:Ljava/io/InputStream;

    .line 13
    .line 14
    iget-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mSocket:Ljava/net/Socket;

    .line 15
    .line 16
    invoke-virtual {p1}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    iput-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mOutputStream:Ljava/io/OutputStream;

    .line 21
    .line 22
    iput-object p2, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mMimeType:Ljava/lang/String;

    .line 23
    .line 24
    return-void
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

.method private close(Ljava/lang/String;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->isClosed()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    return-void

    .line 8
    :cond_0
    const/4 v0, 0x1

    .line 9
    if-eqz p1, :cond_1

    .line 10
    .line 11
    const-string v1, "Client error: "

    .line 12
    .line 13
    invoke-virtual {v1, p1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    const-string v1, "HTTPServer"

    .line 18
    .line 19
    invoke-static {v1, p1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 20
    .line 21
    .line 22
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mHasError:Z

    .line 23
    .line 24
    goto :goto_0

    .line 25
    :cond_1
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mReadyForData:Z

    .line 26
    .line 27
    if-eqz p1, :cond_2

    .line 28
    .line 29
    :try_start_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mChunkedOutputStream:Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;

    .line 30
    .line 31
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;->finish()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 32
    .line 33
    .line 34
    :catch_0
    :cond_2
    :goto_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mChunkedOutputStream:Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;

    .line 35
    .line 36
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 37
    .line 38
    .line 39
    iget-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mOutputStream:Ljava/io/OutputStream;

    .line 40
    .line 41
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 42
    .line 43
    .line 44
    iget-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mInputStream:Ljava/io/InputStream;

    .line 45
    .line 46
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 47
    .line 48
    .line 49
    iget-object p1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mSocket:Ljava/net/Socket;

    .line 50
    .line 51
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

    .line 52
    .line 53
    .line 54
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mIsClosed:Z

    .line 55
    .line 56
    return-void
    .line 57
.end method

.method private redirectToPcap()V
    .locals 3

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "Redirecting to PCAP: "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mFname:Ljava/lang/String;

    .line 9
    .line 10
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 11
    .line 12
    .line 13
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    const-string v1, "HTTPServer"

    .line 18
    .line 19
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 20
    .line 21
    .line 22
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mOutputStream:Ljava/io/OutputStream;

    .line 23
    .line 24
    new-instance v1, Ljava/lang/StringBuilder;

    .line 25
    .line 26
    const-string v2, "HTTP/1.1 302 Found\r\nLocation: /"

    .line 27
    .line 28
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 29
    .line 30
    .line 31
    iget-object v2, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mFname:Ljava/lang/String;

    .line 32
    .line 33
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 34
    .line 35
    .line 36
    const-string v2, "\r\n\r\n"

    .line 37
    .line 38
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 39
    .line 40
    .line 41
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 42
    .line 43
    .line 44
    move-result-object v1

    .line 45
    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    .line 46
    .line 47
    .line 48
    move-result-object v1

    .line 49
    invoke-virtual {v0, v1}, Ljava/io/OutputStream;->write([B)V

    .line 50
    .line 51
    .line 52
    return-void
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method


# virtual methods
.method public isClosed()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mIsClosed:Z

    .line 2
    .line 3
    return v0
    .line 4
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

.method public isReadyForData()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mReadyForData:Z

    .line 2
    .line 3
    return v0
    .line 4
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
    .locals 7

    .line 1
    const-string v0, "HTTPServer"

    .line 2
    .line 3
    const/16 v1, 0x400

    .line 4
    .line 5
    new-array v1, v1, [B

    .line 6
    .line 7
    const/4 v2, 0x0

    .line 8
    const/4 v3, 0x0

    .line 9
    const/4 v4, 0x0

    .line 10
    :goto_0
    if-gtz v3, :cond_0

    .line 11
    .line 12
    :try_start_0
    iget-object v3, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mInputStream:Ljava/io/InputStream;

    .line 13
    .line 14
    rsub-int v5, v4, 0x400

    .line 15
    .line 16
    invoke-virtual {v3, v1, v4, v5}, Ljava/io/InputStream;->read([BII)I

    .line 17
    .line 18
    .line 19
    move-result v3

    .line 20
    add-int/2addr v4, v3

    .line 21
    invoke-static {v1}, Lcom/emanuelef/remote_capture/Utils;->getEndOfHTTPHeaders([B)I

    .line 22
    .line 23
    .line 24
    move-result v3

    .line 25
    goto :goto_0

    .line 26
    :catch_0
    move-exception v0

    .line 27
    goto/16 :goto_4

    .line 28
    .line 29
    :catch_1
    move-exception v0

    .line 30
    goto/16 :goto_4

    .line 31
    .line 32
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    .line 33
    .line 34
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 35
    .line 36
    .line 37
    const-string v5, "Request headers end at "

    .line 38
    .line 39
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 40
    .line 41
    .line 42
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 43
    .line 44
    .line 45
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 46
    .line 47
    .line 48
    move-result-object v4

    .line 49
    invoke-static {v0, v4}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    .line 51
    .line 52
    new-instance v4, Ljava/io/BufferedReader;

    .line 53
    .line 54
    new-instance v5, Ljava/io/InputStreamReader;

    .line 55
    .line 56
    new-instance v6, Ljava/io/ByteArrayInputStream;

    .line 57
    .line 58
    invoke-direct {v6, v1, v2, v3}, Ljava/io/ByteArrayInputStream;-><init>([BII)V

    .line 59
    .line 60
    .line 61
    invoke-direct {v5, v6}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 62
    .line 63
    .line 64
    invoke-direct {v4, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/NoSuchElementException; {:try_start_0 .. :try_end_0} :catch_0

    .line 65
    .line 66
    .line 67
    :try_start_1
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    .line 68
    .line 69
    .line 70
    move-result-object v1

    .line 71
    if-nez v1, :cond_1

    .line 72
    .line 73
    const-string v0, "Bad request"

    .line 74
    .line 75
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->close(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 76
    .line 77
    .line 78
    :goto_1
    :try_start_2
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/util/NoSuchElementException; {:try_start_2 .. :try_end_2} :catch_0

    .line 79
    .line 80
    .line 81
    return-void

    .line 82
    :catchall_0
    move-exception v0

    .line 83
    goto/16 :goto_2

    .line 84
    .line 85
    :cond_1
    :try_start_3
    new-instance v2, Ljava/util/StringTokenizer;

    .line 86
    .line 87
    invoke-direct {v2, v1}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;)V

    .line 88
    .line 89
    .line 90
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    .line 91
    .line 92
    .line 93
    move-result-object v1

    .line 94
    invoke-virtual {v2}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    .line 95
    .line 96
    .line 97
    move-result-object v2

    .line 98
    const-string v3, "GET"

    .line 99
    .line 100
    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 101
    .line 102
    .line 103
    move-result v1

    .line 104
    if-nez v1, :cond_2

    .line 105
    .line 106
    const-string v0, "Bad request method"

    .line 107
    .line 108
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->close(Ljava/lang/String;)V

    .line 109
    .line 110
    .line 111
    goto :goto_1

    .line 112
    :cond_2
    const-string v1, "/"

    .line 113
    .line 114
    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 115
    .line 116
    .line 117
    move-result v1

    .line 118
    if-eqz v1, :cond_3

    .line 119
    .line 120
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->redirectToPcap()V

    .line 121
    .line 122
    .line 123
    const/4 v0, 0x0

    .line 124
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->close(Ljava/lang/String;)V

    .line 125
    .line 126
    .line 127
    goto :goto_1

    .line 128
    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    .line 129
    .line 130
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 131
    .line 132
    .line 133
    const-string v3, "URL: "

    .line 134
    .line 135
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 136
    .line 137
    .line 138
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 139
    .line 140
    .line 141
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 142
    .line 143
    .line 144
    move-result-object v1

    .line 145
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    .line 147
    .line 148
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mOutputStream:Ljava/io/OutputStream;

    .line 149
    .line 150
    new-instance v2, Ljava/lang/StringBuilder;

    .line 151
    .line 152
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 153
    .line 154
    .line 155
    const-string v3, "HTTP/1.1 200 OK\r\nContent-Type: "

    .line 156
    .line 157
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 158
    .line 159
    .line 160
    iget-object v3, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mMimeType:Ljava/lang/String;

    .line 161
    .line 162
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 163
    .line 164
    .line 165
    const-string v3, "\r\nConnection: close\r\nTransfer-Encoding: chunked\r\n\r\n"

    .line 166
    .line 167
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 168
    .line 169
    .line 170
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 171
    .line 172
    .line 173
    move-result-object v2

    .line 174
    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    .line 175
    .line 176
    .line 177
    move-result-object v2

    .line 178
    invoke-virtual {v1, v2}, Ljava/io/OutputStream;->write([B)V

    .line 179
    .line 180
    .line 181
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mOutputStream:Ljava/io/OutputStream;

    .line 182
    .line 183
    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V

    .line 184
    .line 185
    .line 186
    const-string v1, "Ready for data"

    .line 187
    .line 188
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    .line 190
    .line 191
    new-instance v0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;

    .line 192
    .line 193
    iget-object v1, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mOutputStream:Ljava/io/OutputStream;

    .line 194
    .line 195
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 196
    .line 197
    .line 198
    iput-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mChunkedOutputStream:Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;

    .line 199
    .line 200
    const/4 v0, 0x1

    .line 201
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mReadyForData:Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 202
    .line 203
    goto :goto_1

    .line 204
    :goto_2
    :try_start_4
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 205
    .line 206
    .line 207
    goto :goto_3

    .line 208
    :catchall_1
    move-exception v1

    .line 209
    :try_start_5
    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .line 210
    .line 211
    .line 212
    :goto_3
    throw v0
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/util/NoSuchElementException; {:try_start_5 .. :try_end_5} :catch_0

    .line 213
    :goto_4
    invoke-virtual {v0}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    .line 214
    .line 215
    .line 216
    move-result-object v0

    .line 217
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->close(Ljava/lang/String;)V

    .line 218
    .line 219
    .line 220
    return-void
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

.method public sendChunk([B)V
    .locals 2

    .line 1
    :try_start_0
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mHeaderSent:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mChunkedOutputStream:Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;

    .line 6
    .line 7
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getPcapHeader()[B

    .line 8
    .line 9
    .line 10
    move-result-object v1

    .line 11
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;->write([B)V

    .line 12
    .line 13
    .line 14
    const/4 v0, 0x1

    .line 15
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mHeaderSent:Z

    .line 16
    .line 17
    goto :goto_0

    .line 18
    :catch_0
    move-exception p1

    .line 19
    goto :goto_1

    .line 20
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mChunkedOutputStream:Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;

    .line 21
    .line 22
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ChunkedOutputStream;->write([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 23
    .line 24
    .line 25
    return-void

    .line 26
    :goto_1
    invoke-virtual {p1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object p1

    .line 30
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->close(Ljava/lang/String;)V

    .line 31
    .line 32
    .line 33
    return-void
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

.method public stop()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer$ClientHandler;->mSocket:Ljava/net/Socket;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->safeClose(Ljava/io/Closeable;)V

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
.end method
