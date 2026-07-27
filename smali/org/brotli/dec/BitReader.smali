.class public final Lorg/brotli/dec/BitReader;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public accumulator:J

.field public bitOffset:I

.field public final byteBuffer:[B

.field public endOfStreamReached:Z

.field public input:Ljava/io/ByteArrayInputStream;

.field public final intBuffer:[I

.field public intOffset:I

.field public final intReader:Lorg/brotli/dec/IntReader;

.field public tailBytes:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const/16 v0, 0x1040

    .line 5
    .line 6
    new-array v0, v0, [B

    .line 7
    .line 8
    iput-object v0, p0, Lorg/brotli/dec/BitReader;->byteBuffer:[B

    .line 9
    .line 10
    const/16 v0, 0x410

    .line 11
    .line 12
    new-array v0, v0, [I

    .line 13
    .line 14
    iput-object v0, p0, Lorg/brotli/dec/BitReader;->intBuffer:[I

    .line 15
    .line 16
    new-instance v0, Lorg/brotli/dec/IntReader;

    .line 17
    .line 18
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 19
    .line 20
    .line 21
    iput-object v0, p0, Lorg/brotli/dec/BitReader;->intReader:Lorg/brotli/dec/IntReader;

    .line 22
    .line 23
    const/4 v0, 0x0

    .line 24
    iput v0, p0, Lorg/brotli/dec/BitReader;->tailBytes:I

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
.end method

.method public static checkHealth(Lorg/brotli/dec/BitReader;Z)V
    .locals 2

    .line 1
    iget-boolean v0, p0, Lorg/brotli/dec/BitReader;->endOfStreamReached:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    goto :goto_0

    .line 6
    :cond_0
    iget v0, p0, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 7
    .line 8
    shl-int/lit8 v0, v0, 0x2

    .line 9
    .line 10
    iget v1, p0, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 11
    .line 12
    add-int/lit8 v1, v1, 0x7

    .line 13
    .line 14
    shr-int/lit8 v1, v1, 0x3

    .line 15
    .line 16
    add-int/2addr v0, v1

    .line 17
    add-int/lit8 v0, v0, -0x8

    .line 18
    .line 19
    iget p0, p0, Lorg/brotli/dec/BitReader;->tailBytes:I

    .line 20
    .line 21
    if-gt v0, p0, :cond_3

    .line 22
    .line 23
    if-eqz p1, :cond_2

    .line 24
    .line 25
    if-ne v0, p0, :cond_1

    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_1
    new-instance p0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 29
    .line 30
    const-string p1, "Unused bytes after end"

    .line 31
    .line 32
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 33
    .line 34
    .line 35
    throw p0

    .line 36
    :cond_2
    :goto_0
    return-void

    .line 37
    :cond_3
    new-instance p0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 38
    .line 39
    const-string p1, "Read after end"

    .line 40
    .line 41
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 42
    .line 43
    .line 44
    throw p0
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

.method public static fillBitWindow(Lorg/brotli/dec/BitReader;)V
    .locals 6

    .line 1
    iget v0, p0, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 2
    .line 3
    const/16 v1, 0x20

    .line 4
    .line 5
    if-lt v0, v1, :cond_0

    .line 6
    .line 7
    iget-object v2, p0, Lorg/brotli/dec/BitReader;->intBuffer:[I

    .line 8
    .line 9
    iget v3, p0, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 10
    .line 11
    add-int/lit8 v4, v3, 0x1

    .line 12
    .line 13
    iput v4, p0, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 14
    .line 15
    aget v2, v2, v3

    .line 16
    .line 17
    int-to-long v2, v2

    .line 18
    shl-long/2addr v2, v1

    .line 19
    iget-wide v4, p0, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 20
    .line 21
    ushr-long/2addr v4, v1

    .line 22
    or-long/2addr v2, v4

    .line 23
    iput-wide v2, p0, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 24
    .line 25
    sub-int/2addr v0, v1

    .line 26
    iput v0, p0, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 27
    .line 28
    :cond_0
    return-void
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

.method public static intAvailable(Lorg/brotli/dec/BitReader;)I
    .locals 1

    .line 1
    iget-boolean v0, p0, Lorg/brotli/dec/BitReader;->endOfStreamReached:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget v0, p0, Lorg/brotli/dec/BitReader;->tailBytes:I

    .line 6
    .line 7
    add-int/lit8 v0, v0, 0x3

    .line 8
    .line 9
    shr-int/lit8 v0, v0, 0x2

    .line 10
    .line 11
    goto :goto_0

    .line 12
    :cond_0
    const/16 v0, 0x400

    .line 13
    .line 14
    :goto_0
    iget p0, p0, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 15
    .line 16
    sub-int/2addr v0, p0

    .line 17
    return v0
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

.method public static readBits(Lorg/brotli/dec/BitReader;I)I
    .locals 4

    .line 1
    invoke-static {p0}, Lorg/brotli/dec/BitReader;->fillBitWindow(Lorg/brotli/dec/BitReader;)V

    .line 2
    .line 3
    .line 4
    iget-wide v0, p0, Lorg/brotli/dec/BitReader;->accumulator:J

    .line 5
    .line 6
    iget v2, p0, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 7
    .line 8
    ushr-long/2addr v0, v2

    .line 9
    long-to-int v1, v0

    .line 10
    const/4 v0, 0x1

    .line 11
    shl-int v3, v0, p1

    .line 12
    .line 13
    sub-int/2addr v3, v0

    .line 14
    and-int v0, v1, v3

    .line 15
    .line 16
    add-int/2addr v2, p1

    .line 17
    iput v2, p0, Lorg/brotli/dec/BitReader;->bitOffset:I

    .line 18
    .line 19
    return v0
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

.method public static readMoreInput(Lorg/brotli/dec/BitReader;)V
    .locals 7

    .line 1
    iget v0, p0, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 2
    .line 3
    iget-object v1, p0, Lorg/brotli/dec/BitReader;->byteBuffer:[B

    .line 4
    .line 5
    const/16 v2, 0x3f7

    .line 6
    .line 7
    if-gt v0, v2, :cond_0

    .line 8
    .line 9
    goto/16 :goto_3

    .line 10
    .line 11
    :cond_0
    iget-boolean v2, p0, Lorg/brotli/dec/BitReader;->endOfStreamReached:Z

    .line 12
    .line 13
    if-eqz v2, :cond_2

    .line 14
    .line 15
    invoke-static {p0}, Lorg/brotli/dec/BitReader;->intAvailable(Lorg/brotli/dec/BitReader;)I

    .line 16
    .line 17
    .line 18
    move-result p0

    .line 19
    const/4 v0, -0x2

    .line 20
    if-lt p0, v0, :cond_1

    .line 21
    .line 22
    goto :goto_3

    .line 23
    :cond_1
    new-instance p0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 24
    .line 25
    const-string v0, "No more input"

    .line 26
    .line 27
    invoke-direct {p0, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 28
    .line 29
    .line 30
    throw p0

    .line 31
    :cond_2
    shl-int/lit8 v0, v0, 0x2

    .line 32
    .line 33
    rsub-int v2, v0, 0x1000

    .line 34
    .line 35
    const/4 v3, 0x0

    .line 36
    invoke-static {v1, v0, v1, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 37
    .line 38
    .line 39
    iput v3, p0, Lorg/brotli/dec/BitReader;->intOffset:I

    .line 40
    .line 41
    :goto_0
    const/16 v0, 0x1000

    .line 42
    .line 43
    if-ge v2, v0, :cond_4

    .line 44
    .line 45
    :try_start_0
    iget-object v0, p0, Lorg/brotli/dec/BitReader;->input:Ljava/io/ByteArrayInputStream;

    .line 46
    .line 47
    rsub-int v4, v2, 0x1000

    .line 48
    .line 49
    invoke-virtual {v0, v1, v2, v4}, Ljava/io/InputStream;->read([BII)I

    .line 50
    .line 51
    .line 52
    move-result v0

    .line 53
    if-gtz v0, :cond_3

    .line 54
    .line 55
    const/4 v0, 0x1

    .line 56
    iput-boolean v0, p0, Lorg/brotli/dec/BitReader;->endOfStreamReached:Z

    .line 57
    .line 58
    iput v2, p0, Lorg/brotli/dec/BitReader;->tailBytes:I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 59
    .line 60
    add-int/lit8 v2, v2, 0x3

    .line 61
    .line 62
    goto :goto_1

    .line 63
    :cond_3
    add-int/2addr v2, v0

    .line 64
    goto :goto_0

    .line 65
    :catch_0
    move-exception p0

    .line 66
    new-instance v0, Lorg/brotli/dec/BrotliRuntimeException;

    .line 67
    .line 68
    const-string v1, "Failed to read input"

    .line 69
    .line 70
    invoke-direct {v0, v1, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 71
    .line 72
    .line 73
    throw v0

    .line 74
    :cond_4
    :goto_1
    iget-object p0, p0, Lorg/brotli/dec/BitReader;->intReader:Lorg/brotli/dec/IntReader;

    .line 75
    .line 76
    shr-int/lit8 v0, v2, 0x2

    .line 77
    .line 78
    :goto_2
    if-ge v3, v0, :cond_5

    .line 79
    .line 80
    iget-object v1, p0, Lorg/brotli/dec/IntReader;->intBuffer:Ljava/lang/Object;

    .line 81
    .line 82
    check-cast v1, [I

    .line 83
    .line 84
    iget-object v2, p0, Lorg/brotli/dec/IntReader;->byteBuffer:Ljava/lang/Object;

    .line 85
    .line 86
    check-cast v2, [B

    .line 87
    .line 88
    mul-int/lit8 v4, v3, 0x4

    .line 89
    .line 90
    aget-byte v5, v2, v4

    .line 91
    .line 92
    and-int/lit16 v5, v5, 0xff

    .line 93
    .line 94
    add-int/lit8 v6, v4, 0x1

    .line 95
    .line 96
    aget-byte v6, v2, v6

    .line 97
    .line 98
    and-int/lit16 v6, v6, 0xff

    .line 99
    .line 100
    shl-int/lit8 v6, v6, 0x8

    .line 101
    .line 102
    or-int/2addr v5, v6

    .line 103
    add-int/lit8 v6, v4, 0x2

    .line 104
    .line 105
    aget-byte v6, v2, v6

    .line 106
    .line 107
    and-int/lit16 v6, v6, 0xff

    .line 108
    .line 109
    shl-int/lit8 v6, v6, 0x10

    .line 110
    .line 111
    or-int/2addr v5, v6

    .line 112
    add-int/lit8 v4, v4, 0x3

    .line 113
    .line 114
    aget-byte v2, v2, v4

    .line 115
    .line 116
    and-int/lit16 v2, v2, 0xff

    .line 117
    .line 118
    shl-int/lit8 v2, v2, 0x18

    .line 119
    .line 120
    or-int/2addr v2, v5

    .line 121
    aput v2, v1, v3

    .line 122
    .line 123
    add-int/lit8 v3, v3, 0x1

    .line 124
    .line 125
    goto :goto_2

    .line 126
    :cond_5
    :goto_3
    return-void
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
