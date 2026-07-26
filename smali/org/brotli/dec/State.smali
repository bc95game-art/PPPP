.class public final Lorg/brotli/dec/State;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final blockLenTrees:[I

.field public final blockLength:[I

.field public final blockTypeRb:[I

.field public final blockTypeTrees:[I

.field public final br:Lorg/brotli/dec/BitReader;

.field public bytesToIgnore:I

.field public bytesToWrite:I

.field public bytesWritten:I

.field public contextLookupOffset1:I

.field public contextLookupOffset2:I

.field public contextMap:[B

.field public contextMapSlice:I

.field public contextModes:[B

.field public copyDst:I

.field public copyLength:I

.field public final customDictionary:[B

.field public distContextMap:[B

.field public distContextMapSlice:I

.field public final distRb:[I

.field public distRbIdx:I

.field public distance:I

.field public distanceCode:I

.field public distancePostfixBits:I

.field public distancePostfixMask:I

.field public expectedTotalSize:J

.field public final hGroup0:Lorg/brotli/dec/HuffmanTreeGroup;

.field public final hGroup1:Lorg/brotli/dec/HuffmanTreeGroup;

.field public final hGroup2:Lorg/brotli/dec/HuffmanTreeGroup;

.field public inputEnd:Z

.field public insertLength:I

.field public isMetadata:Z

.field public isUncompressed:Z

.field public j:I

.field public literalTree:I

.field public maxBackwardDistance:I

.field public maxDistance:I

.field public maxRingBufferSize:I

.field public metaBlockLength:I

.field public nextRunningState:I

.field public final numBlockTypes:[I

.field public numDirectDistanceCodes:I

.field public output:[B

.field public outputLength:I

.field public outputOffset:I

.field public outputUsed:I

.field public pos:I

.field public ringBuffer:[B

.field public ringBufferSize:I

.field public runningState:I

.field public treeCommandOffset:I

.field public trivialLiteralContext:Z


# direct methods
.method public constructor <init>()V
    .locals 5

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput v0, p0, Lorg/brotli/dec/State;->runningState:I

    .line 6
    .line 7
    new-instance v1, Lorg/brotli/dec/BitReader;

    .line 8
    .line 9
    invoke-direct {v1}, Lorg/brotli/dec/BitReader;-><init>()V

    .line 10
    .line 11
    .line 12
    iput-object v1, p0, Lorg/brotli/dec/State;->br:Lorg/brotli/dec/BitReader;

    .line 13
    .line 14
    const/16 v1, 0xca8

    .line 15
    .line 16
    new-array v2, v1, [I

    .line 17
    .line 18
    iput-object v2, p0, Lorg/brotli/dec/State;->blockTypeTrees:[I

    .line 19
    .line 20
    new-array v1, v1, [I

    .line 21
    .line 22
    iput-object v1, p0, Lorg/brotli/dec/State;->blockLenTrees:[I

    .line 23
    .line 24
    new-instance v1, Lorg/brotli/dec/HuffmanTreeGroup;

    .line 25
    .line 26
    invoke-direct {v1}, Ljava/lang/Object;-><init>()V

    .line 27
    .line 28
    .line 29
    iput-object v1, p0, Lorg/brotli/dec/State;->hGroup0:Lorg/brotli/dec/HuffmanTreeGroup;

    .line 30
    .line 31
    new-instance v1, Lorg/brotli/dec/HuffmanTreeGroup;

    .line 32
    .line 33
    invoke-direct {v1}, Ljava/lang/Object;-><init>()V

    .line 34
    .line 35
    .line 36
    iput-object v1, p0, Lorg/brotli/dec/State;->hGroup1:Lorg/brotli/dec/HuffmanTreeGroup;

    .line 37
    .line 38
    new-instance v1, Lorg/brotli/dec/HuffmanTreeGroup;

    .line 39
    .line 40
    invoke-direct {v1}, Ljava/lang/Object;-><init>()V

    .line 41
    .line 42
    .line 43
    iput-object v1, p0, Lorg/brotli/dec/State;->hGroup2:Lorg/brotli/dec/HuffmanTreeGroup;

    .line 44
    .line 45
    const/4 v1, 0x3

    .line 46
    new-array v2, v1, [I

    .line 47
    .line 48
    iput-object v2, p0, Lorg/brotli/dec/State;->blockLength:[I

    .line 49
    .line 50
    new-array v1, v1, [I

    .line 51
    .line 52
    iput-object v1, p0, Lorg/brotli/dec/State;->numBlockTypes:[I

    .line 53
    .line 54
    const/4 v1, 0x6

    .line 55
    new-array v1, v1, [I

    .line 56
    .line 57
    iput-object v1, p0, Lorg/brotli/dec/State;->blockTypeRb:[I

    .line 58
    .line 59
    const/16 v1, 0xb

    .line 60
    .line 61
    const/4 v2, 0x4

    .line 62
    const/16 v3, 0x10

    .line 63
    .line 64
    const/16 v4, 0xf

    .line 65
    .line 66
    filled-new-array {v3, v4, v1, v2}, [I

    .line 67
    .line 68
    .line 69
    move-result-object v1

    .line 70
    iput-object v1, p0, Lorg/brotli/dec/State;->distRb:[I

    .line 71
    .line 72
    iput v0, p0, Lorg/brotli/dec/State;->pos:I

    .line 73
    .line 74
    iput v0, p0, Lorg/brotli/dec/State;->maxDistance:I

    .line 75
    .line 76
    iput v0, p0, Lorg/brotli/dec/State;->distRbIdx:I

    .line 77
    .line 78
    iput-boolean v0, p0, Lorg/brotli/dec/State;->trivialLiteralContext:Z

    .line 79
    .line 80
    iput v0, p0, Lorg/brotli/dec/State;->ringBufferSize:I

    .line 81
    .line 82
    const-wide/16 v1, 0x0

    .line 83
    .line 84
    iput-wide v1, p0, Lorg/brotli/dec/State;->expectedTotalSize:J

    .line 85
    .line 86
    new-array v1, v0, [B

    .line 87
    .line 88
    iput-object v1, p0, Lorg/brotli/dec/State;->customDictionary:[B

    .line 89
    .line 90
    iput v0, p0, Lorg/brotli/dec/State;->bytesToIgnore:I

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

.method public static setInput(Lorg/brotli/dec/State;Ljava/io/ByteArrayInputStream;)V
    .locals 5

    .line 1
    iget v0, p0, Lorg/brotli/dec/State;->runningState:I

    .line 2
    .line 3
    iget-object v1, p0, Lorg/brotli/dec/State;->br:Lorg/brotli/dec/BitReader;

    .line 4
    .line 5
    if-nez v0, :cond_5

    .line 6
    .line 7
    iget-object v0, v1, Lorg/brotli/dec/BitReader;->input:Ljava/io/ByteArrayInputStream;

    .line 8
    .line 9
    if-nez v0, :cond_4

    .line 10
    .line 11
    iget-object v0, v1, Lorg/brotli/dec/BitReader;->intReader:Lorg/brotli/dec/IntReader;

    .line 12
    .line 13
    iget-object v2, v1, Lorg/brotli/dec/BitReader;->byteBuffer:[B

    .line 14
    .line 15
    iget-object v3, v1, Lorg/brotli/dec/BitReader;->intBuffer:[I

    .line 16
    .line 17
    iput-object v2, v0, Lorg/brotli/dec/IntReader;->byteBuffer:Ljava/lang/Object;

    .line 18
    .line 19
    iput-object v3, v0, Lorg/brotli/dec/IntReader;->intBuffer:Ljava/lang/Object;

    .line 20
    .line 21
    iput-object p1, v1, Lorg/brotli/dec/BitReader;->input:Ljava/io/ByteArrayInputStream;

    .line 22
    .line 23
    const-wide/16 v2, 0x0

    .line 24
    .line 25
    iput-wide v2, v1, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 26
    .line 27
    const/16 p1, 0x40

    .line 28
    .line 29
    iput p1, v1, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 30
    .line 31
    const/16 p1, 0x400

    .line 32
    .line 33
    iput p1, v1, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 34
    .line 35
    const/4 p1, 0x0

    .line 36
    iput-boolean p1, v1, Lorg/brotli/dec/BitReader;->endOfStreamReached:Z

    .line 37
    .line 38
    invoke-static {v1}, Lorg/brotli/dec/BitReader;->readMoreInput(Lorg/brotli/dec/BitReader;)V

    .line 39
    .line 40
    .line 41
    invoke-static {v1, p1}, Lorg/brotli/dec/BitReader;->checkHealth(Lorg/brotli/dec/BitReader;Z)V

    .line 42
    .line 43
    .line 44
    invoke-static {v1}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 45
    .line 46
    .line 47
    invoke-static {v1}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 48
    .line 49
    .line 50
    const/4 p1, 0x1

    .line 51
    invoke-static {v1, p1}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 52
    .line 53
    .line 54
    move-result v0

    .line 55
    const/16 v2, 0x10

    .line 56
    .line 57
    if-nez v0, :cond_0

    .line 58
    .line 59
    const/16 v4, 0x10

    .line 60
    .line 61
    goto :goto_0

    .line 62
    :cond_0
    const/4 v0, 0x3

    .line 63
    invoke-static {v1, v0}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 64
    .line 65
    .line 66
    move-result v3

    .line 67
    const/16 v4, 0x11

    .line 68
    .line 69
    if-eqz v3, :cond_1

    .line 70
    .line 71
    add-int/2addr v4, v3

    .line 72
    goto :goto_0

    .line 73
    :cond_1
    invoke-static {v1, v0}, Lorg/brotli/dec/BitReader;->readBits(Lorg/brotli/dec/BitReader;I)I

    .line 74
    .line 75
    .line 76
    move-result v0

    .line 77
    if-eqz v0, :cond_2

    .line 78
    .line 79
    add-int/lit8 v4, v0, 0x8

    .line 80
    .line 81
    :cond_2
    :goto_0
    const/16 v0, 0x9

    .line 82
    .line 83
    if-eq v4, v0, :cond_3

    .line 84
    .line 85
    shl-int v0, p1, v4

    .line 86
    .line 87
    iput v0, p0, Lorg/brotli/dec/State;->maxRingBufferSize:I

    .line 88
    .line 89
    sub-int/2addr v0, v2

    .line 90
    iput v0, p0, Lorg/brotli/dec/State;->maxBackwardDistance:I

    .line 91
    .line 92
    iput p1, p0, Lorg/brotli/dec/State;->runningState:I

    .line 93
    .line 94
    return-void

    .line 95
    :cond_3
    new-instance p0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 96
    .line 97
    const-string p1, "Invalid \'windowBits\' code"

    .line 98
    .line 99
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 100
    .line 101
    .line 102
    throw p0

    .line 103
    :cond_4
    new-instance p0, Ljava/lang/IllegalStateException;

    .line 104
    .line 105
    const-string p1, "Bit reader already has associated input stream"

    .line 106
    .line 107
    invoke-direct {p0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 108
    .line 109
    .line 110
    throw p0

    .line 111
    :cond_5
    new-instance p0, Ljava/lang/IllegalStateException;

    .line 112
    .line 113
    const-string p1, "State MUST be uninitialized"

    .line 114
    .line 115
    invoke-direct {p0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 116
    .line 117
    .line 118
    throw p0
    .line 119
.end method
