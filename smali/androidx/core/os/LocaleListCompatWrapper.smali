.class public final Landroidx/core/os/LocaleListCompatWrapper;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/core/os/LocaleListInterface;


# static fields
.field public static final sEmptyList:[Ljava/util/Locale;


# instance fields
.field public final mList:[Ljava/util/Locale;

.field public final mStringRepresentation:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .line 1
    const/4 v0, 0x0

    .line 2
    new-array v1, v0, [Ljava/util/Locale;

    .line 3
    .line 4
    sput-object v1, Landroidx/core/os/LocaleListCompatWrapper;->sEmptyList:[Ljava/util/Locale;

    .line 5
    .line 6
    new-instance v1, Ljava/util/Locale;

    .line 7
    .line 8
    const-string v2, "en"

    .line 9
    .line 10
    const-string v3, "XA"

    .line 11
    .line 12
    invoke-direct {v1, v2, v3}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 13
    .line 14
    .line 15
    new-instance v1, Ljava/util/Locale;

    .line 16
    .line 17
    const-string v2, "ar"

    .line 18
    .line 19
    const-string v3, "XB"

    .line 20
    .line 21
    invoke-direct {v1, v2, v3}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    .line 23
    .line 24
    const-string v1, "-"

    .line 25
    .line 26
    const-string v2, "en-Latn"

    .line 27
    .line 28
    const/4 v3, -0x1

    .line 29
    invoke-virtual {v2, v1, v3}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    .line 30
    .line 31
    .line 32
    move-result-object v1

    .line 33
    array-length v2, v1

    .line 34
    const/4 v3, 0x2

    .line 35
    const/4 v4, 0x1

    .line 36
    if-le v2, v3, :cond_0

    .line 37
    .line 38
    new-instance v2, Ljava/util/Locale;

    .line 39
    .line 40
    aget-object v0, v1, v0

    .line 41
    .line 42
    aget-object v4, v1, v4

    .line 43
    .line 44
    aget-object v1, v1, v3

    .line 45
    .line 46
    invoke-direct {v2, v0, v4, v1}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    .line 48
    .line 49
    return-void

    .line 50
    :cond_0
    array-length v2, v1

    .line 51
    if-le v2, v4, :cond_1

    .line 52
    .line 53
    new-instance v2, Ljava/util/Locale;

    .line 54
    .line 55
    aget-object v0, v1, v0

    .line 56
    .line 57
    aget-object v1, v1, v4

    .line 58
    .line 59
    invoke-direct {v2, v0, v1}, Ljava/util/Locale;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    .line 61
    .line 62
    return-void

    .line 63
    :cond_1
    array-length v2, v1

    .line 64
    if-ne v2, v4, :cond_2

    .line 65
    .line 66
    new-instance v2, Ljava/util/Locale;

    .line 67
    .line 68
    aget-object v0, v1, v0

    .line 69
    .line 70
    invoke-direct {v2, v0}, Ljava/util/Locale;-><init>(Ljava/lang/String;)V

    .line 71
    .line 72
    .line 73
    return-void

    .line 74
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 75
    .line 76
    const-string v1, "Can not parse language tag: [en-Latn]"

    .line 77
    .line 78
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 79
    .line 80
    .line 81
    throw v0
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

.method public varargs constructor <init>([Ljava/util/Locale;)V
    .locals 7

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    array-length v0, p1

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    sget-object p1, Landroidx/core/os/LocaleListCompatWrapper;->sEmptyList:[Ljava/util/Locale;

    .line 8
    .line 9
    iput-object p1, p0, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 10
    .line 11
    const-string p1, ""

    .line 12
    .line 13
    iput-object p1, p0, Landroidx/core/os/LocaleListCompatWrapper;->mStringRepresentation:Ljava/lang/String;

    .line 14
    .line 15
    return-void

    .line 16
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    .line 17
    .line 18
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 19
    .line 20
    .line 21
    new-instance v1, Ljava/util/HashSet;

    .line 22
    .line 23
    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 24
    .line 25
    .line 26
    new-instance v2, Ljava/lang/StringBuilder;

    .line 27
    .line 28
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 29
    .line 30
    .line 31
    const/4 v3, 0x0

    .line 32
    const/4 v4, 0x0

    .line 33
    :goto_0
    array-length v5, p1

    .line 34
    if-ge v4, v5, :cond_5

    .line 35
    .line 36
    aget-object v5, p1, v4

    .line 37
    .line 38
    if-eqz v5, :cond_4

    .line 39
    .line 40
    invoke-virtual {v1, v5}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    .line 41
    .line 42
    .line 43
    move-result v6

    .line 44
    if-nez v6, :cond_3

    .line 45
    .line 46
    invoke-virtual {v5}, Ljava/util/Locale;->clone()Ljava/lang/Object;

    .line 47
    .line 48
    .line 49
    move-result-object v5

    .line 50
    check-cast v5, Ljava/util/Locale;

    .line 51
    .line 52
    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 53
    .line 54
    .line 55
    invoke-virtual {v5}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    .line 56
    .line 57
    .line 58
    move-result-object v6

    .line 59
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 60
    .line 61
    .line 62
    invoke-virtual {v5}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    .line 63
    .line 64
    .line 65
    move-result-object v6

    .line 66
    if-eqz v6, :cond_1

    .line 67
    .line 68
    invoke-virtual {v6}, Ljava/lang/String;->isEmpty()Z

    .line 69
    .line 70
    .line 71
    move-result v6

    .line 72
    if-nez v6, :cond_1

    .line 73
    .line 74
    const/16 v6, 0x2d

    .line 75
    .line 76
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 77
    .line 78
    .line 79
    invoke-virtual {v5}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    .line 80
    .line 81
    .line 82
    move-result-object v6

    .line 83
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    .line 85
    .line 86
    :cond_1
    array-length v6, p1

    .line 87
    add-int/lit8 v6, v6, -0x1

    .line 88
    .line 89
    if-ge v4, v6, :cond_2

    .line 90
    .line 91
    const/16 v6, 0x2c

    .line 92
    .line 93
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 94
    .line 95
    .line 96
    :cond_2
    invoke-virtual {v1, v5}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 97
    .line 98
    .line 99
    :cond_3
    add-int/lit8 v4, v4, 0x1

    .line 100
    .line 101
    goto :goto_0

    .line 102
    :cond_4
    new-instance p1, Ljava/lang/NullPointerException;

    .line 103
    .line 104
    new-instance v0, Ljava/lang/StringBuilder;

    .line 105
    .line 106
    const-string v1, "list["

    .line 107
    .line 108
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 109
    .line 110
    .line 111
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 112
    .line 113
    .line 114
    const-string v1, "] is null"

    .line 115
    .line 116
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 117
    .line 118
    .line 119
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 120
    .line 121
    .line 122
    move-result-object v0

    .line 123
    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 124
    .line 125
    .line 126
    throw p1

    .line 127
    :cond_5
    new-array p1, v3, [Ljava/util/Locale;

    .line 128
    .line 129
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 130
    .line 131
    .line 132
    move-result-object p1

    .line 133
    check-cast p1, [Ljava/util/Locale;

    .line 134
    .line 135
    iput-object p1, p0, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 136
    .line 137
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 138
    .line 139
    .line 140
    move-result-object p1

    .line 141
    iput-object p1, p0, Landroidx/core/os/LocaleListCompatWrapper;->mStringRepresentation:Ljava/lang/String;

    .line 142
    .line 143
    return-void
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


# virtual methods
.method public final equals(Ljava/lang/Object;)Z
    .locals 6

    .line 1
    const/4 v0, 0x1

    .line 2
    if-ne p1, p0, :cond_0

    .line 3
    .line 4
    return v0

    .line 5
    :cond_0
    instance-of v1, p1, Landroidx/core/os/LocaleListCompatWrapper;

    .line 6
    .line 7
    const/4 v2, 0x0

    .line 8
    if-nez v1, :cond_1

    .line 9
    .line 10
    return v2

    .line 11
    :cond_1
    check-cast p1, Landroidx/core/os/LocaleListCompatWrapper;

    .line 12
    .line 13
    iget-object p1, p1, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 14
    .line 15
    iget-object v1, p0, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 16
    .line 17
    array-length v3, v1

    .line 18
    array-length v4, p1

    .line 19
    if-eq v3, v4, :cond_2

    .line 20
    .line 21
    return v2

    .line 22
    :cond_2
    const/4 v3, 0x0

    .line 23
    :goto_0
    array-length v4, v1

    .line 24
    if-ge v3, v4, :cond_4

    .line 25
    .line 26
    aget-object v4, v1, v3

    .line 27
    .line 28
    aget-object v5, p1, v3

    .line 29
    .line 30
    invoke-virtual {v4, v5}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    .line 31
    .line 32
    .line 33
    move-result v4

    .line 34
    if-nez v4, :cond_3

    .line 35
    .line 36
    return v2

    .line 37
    :cond_3
    add-int/lit8 v3, v3, 0x1

    .line 38
    .line 39
    goto :goto_0

    .line 40
    :cond_4
    return v0
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

.method public final get(I)Ljava/util/Locale;
    .locals 2

    .line 1
    if-ltz p1, :cond_0

    .line 2
    .line 3
    iget-object v0, p0, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 4
    .line 5
    array-length v1, v0

    .line 6
    if-ge p1, v1, :cond_0

    .line 7
    .line 8
    aget-object p1, v0, p1

    .line 9
    .line 10
    return-object p1

    .line 11
    :cond_0
    const/4 p1, 0x0

    .line 12
    return-object p1
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

.method public final getLocaleList()Ljava/lang/Object;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public final hashCode()I
    .locals 5

    .line 1
    iget-object v0, p0, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 2
    .line 3
    array-length v1, v0

    .line 4
    const/4 v2, 0x1

    .line 5
    const/4 v3, 0x0

    .line 6
    :goto_0
    if-ge v3, v1, :cond_0

    .line 7
    .line 8
    aget-object v4, v0, v3

    .line 9
    .line 10
    mul-int/lit8 v2, v2, 0x1f

    .line 11
    .line 12
    invoke-virtual {v4}, Ljava/util/Locale;->hashCode()I

    .line 13
    .line 14
    .line 15
    move-result v4

    .line 16
    add-int/2addr v2, v4

    .line 17
    add-int/lit8 v3, v3, 0x1

    .line 18
    .line 19
    goto :goto_0

    .line 20
    :cond_0
    return v2
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

.method public final isEmpty()Z
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 2
    .line 3
    array-length v0, v0

    .line 4
    if-nez v0, :cond_0

    .line 5
    .line 6
    const/4 v0, 0x1

    .line 7
    return v0

    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    return v0
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

.method public final size()I
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 2
    .line 3
    array-length v0, v0

    .line 4
    return v0
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

.method public final toLanguageTags()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/core/os/LocaleListCompatWrapper;->mStringRepresentation:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
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

.method public final toString()Ljava/lang/String;
    .locals 4

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "["

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 v1, 0x0

    .line 9
    :goto_0
    iget-object v2, p0, Landroidx/core/os/LocaleListCompatWrapper;->mList:[Ljava/util/Locale;

    .line 10
    .line 11
    array-length v3, v2

    .line 12
    if-ge v1, v3, :cond_1

    .line 13
    .line 14
    aget-object v3, v2, v1

    .line 15
    .line 16
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 17
    .line 18
    .line 19
    array-length v2, v2

    .line 20
    add-int/lit8 v2, v2, -0x1

    .line 21
    .line 22
    if-ge v1, v2, :cond_0

    .line 23
    .line 24
    const/16 v2, 0x2c

    .line 25
    .line 26
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 27
    .line 28
    .line 29
    :cond_0
    add-int/lit8 v1, v1, 0x1

    .line 30
    .line 31
    goto :goto_0

    .line 32
    :cond_1
    const-string v1, "]"

    .line 33
    .line 34
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 35
    .line 36
    .line 37
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object v0

    .line 41
    return-object v0
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
