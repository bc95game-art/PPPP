.class Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/ReversedLinesFileReader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FilePart"
.end annotation


# instance fields
.field private currentLastBytePos:I

.field private final data:[B

.field private leftOver:[B

.field private final no:J

.field final synthetic this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;


# direct methods
.method public static bridge synthetic -$$Nest$mreadLine(Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;)Ljava/lang/String;
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->readLine()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$mrollOver(Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;)Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->rollOver()Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

    move-result-object p0

    return-object p0
.end method

.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;JI)V
    .locals 6

    .line 1
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move v4, p4

    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;-><init>(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;JI[B)V

    return-void
.end method

.method private constructor <init>(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;JI[B)V
    .locals 8

    .line 2
    iput-object p1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-wide p2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->no:J

    const/4 v0, 0x0

    if-eqz p5, :cond_0

    .line 4
    array-length v1, p5

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    add-int/2addr v1, p4

    .line 5
    new-array v2, v1, [B

    iput-object v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->data:[B

    const-wide/16 v3, 0x1

    sub-long v3, p2, v3

    .line 6
    invoke-static {p1}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetblockSize(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)I

    move-result v5

    int-to-long v5, v5

    mul-long v3, v3, v5

    const-wide/16 v5, 0x0

    cmp-long v7, p2, v5

    if-lez v7, :cond_2

    .line 7
    invoke-static {p1}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetrandomAccessFile(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)Ljava/io/RandomAccessFile;

    move-result-object p2

    invoke-virtual {p2, v3, v4}, Ljava/io/RandomAccessFile;->seek(J)V

    .line 8
    invoke-static {p1}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetrandomAccessFile(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)Ljava/io/RandomAccessFile;

    move-result-object p1

    invoke-virtual {p1, v2, v0, p4}, Ljava/io/RandomAccessFile;->read([BII)I

    move-result p1

    if-ne p1, p4, :cond_1

    goto :goto_1

    .line 9
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "Count of requested bytes and actually read bytes don\'t match"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_2
    :goto_1
    if-eqz p5, :cond_3

    .line 10
    array-length p1, p5

    invoke-static {p5, v0, v2, p4, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_3
    add-int/lit8 v1, v1, -0x1

    .line 11
    iput v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->currentLastBytePos:I

    const/4 p1, 0x0

    .line 12
    iput-object p1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->leftOver:[B

    return-void
.end method

.method private createLeftOver()V
    .locals 4

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->currentLastBytePos:I

    .line 2
    .line 3
    add-int/lit8 v0, v0, 0x1

    .line 4
    .line 5
    if-lez v0, :cond_0

    .line 6
    .line 7
    new-array v1, v0, [B

    .line 8
    .line 9
    iput-object v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->leftOver:[B

    .line 10
    .line 11
    iget-object v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->data:[B

    .line 12
    .line 13
    const/4 v3, 0x0

    .line 14
    invoke-static {v2, v3, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 15
    .line 16
    .line 17
    goto :goto_0

    .line 18
    :cond_0
    const/4 v0, 0x0

    .line 19
    iput-object v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->leftOver:[B

    .line 20
    .line 21
    :goto_0
    const/4 v0, -0x1

    .line 22
    iput v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->currentLastBytePos:I

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
.end method

.method private getNewLineMatchByteCount([BI)I
    .locals 10

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetnewLineSequences(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)[[B

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    array-length v1, v0

    .line 8
    const/4 v2, 0x0

    .line 9
    const/4 v3, 0x0

    .line 10
    :goto_0
    if-ge v3, v1, :cond_3

    .line 11
    .line 12
    aget-object v4, v0, v3

    .line 13
    .line 14
    array-length v5, v4

    .line 15
    const/4 v6, 0x1

    .line 16
    sub-int/2addr v5, v6

    .line 17
    const/4 v7, 0x1

    .line 18
    :goto_1
    if-ltz v5, :cond_1

    .line 19
    .line 20
    add-int v8, p2, v5

    .line 21
    .line 22
    array-length v9, v4

    .line 23
    sub-int/2addr v9, v6

    .line 24
    sub-int/2addr v8, v9

    .line 25
    if-ltz v8, :cond_0

    .line 26
    .line 27
    aget-byte v8, p1, v8

    .line 28
    .line 29
    aget-byte v9, v4, v5

    .line 30
    .line 31
    if-ne v8, v9, :cond_0

    .line 32
    .line 33
    const/4 v8, 0x1

    .line 34
    goto :goto_2

    .line 35
    :cond_0
    const/4 v8, 0x0

    .line 36
    :goto_2
    and-int/2addr v7, v8

    .line 37
    add-int/lit8 v5, v5, -0x1

    .line 38
    .line 39
    goto :goto_1

    .line 40
    :cond_1
    if-eqz v7, :cond_2

    .line 41
    .line 42
    array-length p1, v4

    .line 43
    return p1

    .line 44
    :cond_2
    add-int/lit8 v3, v3, 0x1

    .line 45
    .line 46
    goto :goto_0

    .line 47
    :cond_3
    return v2
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

.method private readLine()Ljava/lang/String;
    .locals 9

    .line 1
    iget-wide v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->no:J

    .line 2
    .line 3
    const-wide/16 v2, 0x1

    .line 4
    .line 5
    const/4 v4, 0x0

    .line 6
    const/4 v5, 0x1

    .line 7
    cmp-long v6, v0, v2

    .line 8
    .line 9
    if-nez v6, :cond_0

    .line 10
    .line 11
    const/4 v0, 0x1

    .line 12
    goto :goto_0

    .line 13
    :cond_0
    const/4 v0, 0x0

    .line 14
    :goto_0
    iget v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->currentLastBytePos:I

    .line 15
    .line 16
    :cond_1
    const/4 v2, -0x1

    .line 17
    const/4 v3, 0x0

    .line 18
    if-le v1, v2, :cond_5

    .line 19
    .line 20
    if-nez v0, :cond_2

    .line 21
    .line 22
    iget-object v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;

    .line 23
    .line 24
    invoke-static {v2}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetavoidNewlineSplitBufferSize(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)I

    .line 25
    .line 26
    .line 27
    move-result v2

    .line 28
    if-ge v1, v2, :cond_2

    .line 29
    .line 30
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->createLeftOver()V

    .line 31
    .line 32
    .line 33
    goto :goto_1

    .line 34
    :cond_2
    iget-object v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->data:[B

    .line 35
    .line 36
    invoke-direct {p0, v2, v1}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->getNewLineMatchByteCount([BI)I

    .line 37
    .line 38
    .line 39
    move-result v2

    .line 40
    if-lez v2, :cond_4

    .line 41
    .line 42
    add-int/lit8 v6, v1, 0x1

    .line 43
    .line 44
    iget v7, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->currentLastBytePos:I

    .line 45
    .line 46
    sub-int/2addr v7, v6

    .line 47
    add-int/2addr v7, v5

    .line 48
    if-ltz v7, :cond_3

    .line 49
    .line 50
    new-array v5, v7, [B

    .line 51
    .line 52
    iget-object v8, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->data:[B

    .line 53
    .line 54
    invoke-static {v8, v6, v5, v4, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 55
    .line 56
    .line 57
    new-instance v4, Ljava/lang/String;

    .line 58
    .line 59
    iget-object v6, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;

    .line 60
    .line 61
    invoke-static {v6}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetencoding(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)Ljava/nio/charset/Charset;

    .line 62
    .line 63
    .line 64
    move-result-object v6

    .line 65
    invoke-direct {v4, v5, v6}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 66
    .line 67
    .line 68
    sub-int/2addr v1, v2

    .line 69
    iput v1, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->currentLastBytePos:I

    .line 70
    .line 71
    goto :goto_2

    .line 72
    :cond_3
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 73
    .line 74
    const-string v1, "Unexpected negative line length="

    .line 75
    .line 76
    invoke-static {v7, v1}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(ILjava/lang/String;)Ljava/lang/String;

    .line 77
    .line 78
    .line 79
    move-result-object v1

    .line 80
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 81
    .line 82
    .line 83
    throw v0

    .line 84
    :cond_4
    iget-object v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;

    .line 85
    .line 86
    invoke-static {v2}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetbyteDecrement(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)I

    .line 87
    .line 88
    .line 89
    move-result v2

    .line 90
    sub-int/2addr v1, v2

    .line 91
    if-gez v1, :cond_1

    .line 92
    .line 93
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->createLeftOver()V

    .line 94
    .line 95
    .line 96
    :cond_5
    :goto_1
    move-object v4, v3

    .line 97
    :goto_2
    if-eqz v0, :cond_6

    .line 98
    .line 99
    iget-object v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->leftOver:[B

    .line 100
    .line 101
    if-eqz v0, :cond_6

    .line 102
    .line 103
    new-instance v1, Ljava/lang/String;

    .line 104
    .line 105
    iget-object v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;

    .line 106
    .line 107
    invoke-static {v2}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetencoding(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)Ljava/nio/charset/Charset;

    .line 108
    .line 109
    .line 110
    move-result-object v2

    .line 111
    invoke-direct {v1, v0, v2}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 112
    .line 113
    .line 114
    iput-object v3, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->leftOver:[B

    .line 115
    .line 116
    return-object v1

    .line 117
    :cond_6
    return-object v4
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

.method private rollOver()Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;
    .locals 11

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->currentLastBytePos:I

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    if-gt v0, v1, :cond_2

    .line 5
    .line 6
    iget-wide v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->no:J

    .line 7
    .line 8
    const-wide/16 v2, 0x1

    .line 9
    .line 10
    cmp-long v4, v0, v2

    .line 11
    .line 12
    if-lez v4, :cond_0

    .line 13
    .line 14
    new-instance v5, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;

    .line 15
    .line 16
    iget-object v6, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;

    .line 17
    .line 18
    sub-long v7, v0, v2

    .line 19
    .line 20
    invoke-static {v6}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetblockSize(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)I

    .line 21
    .line 22
    .line 23
    move-result v9

    .line 24
    iget-object v10, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->leftOver:[B

    .line 25
    .line 26
    invoke-direct/range {v5 .. v10}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;-><init>(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;JI[B)V

    .line 27
    .line 28
    .line 29
    return-object v5

    .line 30
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->leftOver:[B

    .line 31
    .line 32
    if-nez v0, :cond_1

    .line 33
    .line 34
    const/4 v0, 0x0

    .line 35
    return-object v0

    .line 36
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 37
    .line 38
    new-instance v1, Ljava/lang/String;

    .line 39
    .line 40
    iget-object v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->leftOver:[B

    .line 41
    .line 42
    iget-object v3, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->this$0:Lcom/emanuelef/remote_capture/ReversedLinesFileReader;

    .line 43
    .line 44
    invoke-static {v3}, Lcom/emanuelef/remote_capture/ReversedLinesFileReader;->-$$Nest$fgetencoding(Lcom/emanuelef/remote_capture/ReversedLinesFileReader;)Ljava/nio/charset/Charset;

    .line 45
    .line 46
    .line 47
    move-result-object v3

    .line 48
    invoke-direct {v1, v2, v3}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 49
    .line 50
    .line 51
    const-string v2, "Unexpected leftover of the last block: leftOverOfThisFilePart="

    .line 52
    .line 53
    invoke-virtual {v2, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 54
    .line 55
    .line 56
    move-result-object v1

    .line 57
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    throw v0

    .line 61
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 62
    .line 63
    new-instance v1, Ljava/lang/StringBuilder;

    .line 64
    .line 65
    const-string v2, "Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos="

    .line 66
    .line 67
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 68
    .line 69
    .line 70
    iget v2, p0, Lcom/emanuelef/remote_capture/ReversedLinesFileReader$FilePart;->currentLastBytePos:I

    .line 71
    .line 72
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 73
    .line 74
    .line 75
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object v1

    .line 79
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 80
    .line 81
    .line 82
    throw v0
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
