.class public abstract Landroidx/navigation/NavType;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final BoolArrayType:Landroidx/navigation/IntListNavType;

.field public static final BoolListType:Landroidx/navigation/IntListNavType;

.field public static final BoolType:Landroidx/navigation/IntNavType;

.field public static final FloatArrayType:Landroidx/navigation/IntListNavType;

.field public static final FloatListType:Landroidx/navigation/IntListNavType;

.field public static final FloatType:Landroidx/navigation/IntNavType;

.field public static final IntArrayType:Landroidx/navigation/IntListNavType;

.field public static final IntListType:Landroidx/navigation/IntListNavType;

.field public static final IntType:Landroidx/navigation/IntNavType;

.field public static final LongArrayType:Landroidx/navigation/IntListNavType;

.field public static final LongListType:Landroidx/navigation/IntListNavType;

.field public static final LongType:Landroidx/navigation/IntNavType;

.field public static final ReferenceType:Landroidx/navigation/IntNavType;

.field public static final StringArrayType:Landroidx/navigation/IntListNavType;

.field public static final StringListType:Landroidx/navigation/IntListNavType;

.field public static final StringType:Landroidx/navigation/IntNavType;


# instance fields
.field public final isNullableAllowed:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 1
    new-instance v0, Landroidx/navigation/IntNavType;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    const/4 v2, 0x0

    .line 5
    invoke-direct {v0, v1, v2}, Landroidx/navigation/IntNavType;-><init>(IZ)V

    .line 6
    .line 7
    .line 8
    sput-object v0, Landroidx/navigation/NavType;->IntType:Landroidx/navigation/IntNavType;

    .line 9
    .line 10
    new-instance v0, Landroidx/navigation/IntNavType;

    .line 11
    .line 12
    const/4 v1, 0x4

    .line 13
    invoke-direct {v0, v1, v2}, Landroidx/navigation/IntNavType;-><init>(IZ)V

    .line 14
    .line 15
    .line 16
    sput-object v0, Landroidx/navigation/NavType;->ReferenceType:Landroidx/navigation/IntNavType;

    .line 17
    .line 18
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 19
    .line 20
    const/4 v1, 0x5

    .line 21
    const/4 v3, 0x1

    .line 22
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 23
    .line 24
    .line 25
    sput-object v0, Landroidx/navigation/NavType;->IntArrayType:Landroidx/navigation/IntListNavType;

    .line 26
    .line 27
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 28
    .line 29
    const/4 v1, 0x0

    .line 30
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 31
    .line 32
    .line 33
    sput-object v0, Landroidx/navigation/NavType;->IntListType:Landroidx/navigation/IntListNavType;

    .line 34
    .line 35
    new-instance v0, Landroidx/navigation/IntNavType;

    .line 36
    .line 37
    const/4 v1, 0x3

    .line 38
    invoke-direct {v0, v1, v2}, Landroidx/navigation/IntNavType;-><init>(IZ)V

    .line 39
    .line 40
    .line 41
    sput-object v0, Landroidx/navigation/NavType;->LongType:Landroidx/navigation/IntNavType;

    .line 42
    .line 43
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 44
    .line 45
    const/4 v1, 0x6

    .line 46
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 47
    .line 48
    .line 49
    sput-object v0, Landroidx/navigation/NavType;->LongArrayType:Landroidx/navigation/IntListNavType;

    .line 50
    .line 51
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 52
    .line 53
    const/4 v1, 0x7

    .line 54
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 55
    .line 56
    .line 57
    sput-object v0, Landroidx/navigation/NavType;->LongListType:Landroidx/navigation/IntListNavType;

    .line 58
    .line 59
    new-instance v0, Landroidx/navigation/IntNavType;

    .line 60
    .line 61
    const/4 v1, 0x2

    .line 62
    invoke-direct {v0, v1, v2}, Landroidx/navigation/IntNavType;-><init>(IZ)V

    .line 63
    .line 64
    .line 65
    sput-object v0, Landroidx/navigation/NavType;->FloatType:Landroidx/navigation/IntNavType;

    .line 66
    .line 67
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 68
    .line 69
    const/4 v1, 0x3

    .line 70
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 71
    .line 72
    .line 73
    sput-object v0, Landroidx/navigation/NavType;->FloatArrayType:Landroidx/navigation/IntListNavType;

    .line 74
    .line 75
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 76
    .line 77
    const/4 v1, 0x4

    .line 78
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 79
    .line 80
    .line 81
    sput-object v0, Landroidx/navigation/NavType;->FloatListType:Landroidx/navigation/IntListNavType;

    .line 82
    .line 83
    new-instance v0, Landroidx/navigation/IntNavType;

    .line 84
    .line 85
    const/4 v1, 0x1

    .line 86
    invoke-direct {v0, v1, v2}, Landroidx/navigation/IntNavType;-><init>(IZ)V

    .line 87
    .line 88
    .line 89
    sput-object v0, Landroidx/navigation/NavType;->BoolType:Landroidx/navigation/IntNavType;

    .line 90
    .line 91
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 92
    .line 93
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 94
    .line 95
    .line 96
    sput-object v0, Landroidx/navigation/NavType;->BoolArrayType:Landroidx/navigation/IntListNavType;

    .line 97
    .line 98
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 99
    .line 100
    const/4 v1, 0x2

    .line 101
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 102
    .line 103
    .line 104
    sput-object v0, Landroidx/navigation/NavType;->BoolListType:Landroidx/navigation/IntListNavType;

    .line 105
    .line 106
    new-instance v0, Landroidx/navigation/IntNavType;

    .line 107
    .line 108
    const/4 v1, 0x5

    .line 109
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntNavType;-><init>(IZ)V

    .line 110
    .line 111
    .line 112
    sput-object v0, Landroidx/navigation/NavType;->StringType:Landroidx/navigation/IntNavType;

    .line 113
    .line 114
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 115
    .line 116
    const/16 v1, 0x8

    .line 117
    .line 118
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 119
    .line 120
    .line 121
    sput-object v0, Landroidx/navigation/NavType;->StringArrayType:Landroidx/navigation/IntListNavType;

    .line 122
    .line 123
    new-instance v0, Landroidx/navigation/IntListNavType;

    .line 124
    .line 125
    const/16 v1, 0x9

    .line 126
    .line 127
    invoke-direct {v0, v1, v3}, Landroidx/navigation/IntListNavType;-><init>(IZ)V

    .line 128
    .line 129
    .line 130
    sput-object v0, Landroidx/navigation/NavType;->StringListType:Landroidx/navigation/IntListNavType;

    .line 131
    .line 132
    return-void
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

.method public constructor <init>(Z)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-boolean p1, p0, Landroidx/navigation/NavType;->isNullableAllowed:Z

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
.method public abstract get(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;
.end method

.method public abstract getName()Ljava/lang/String;
.end method

.method public parseValue(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    .locals 0

    .line 1
    invoke-virtual {p0, p2}, Landroidx/navigation/NavType;->parseValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public abstract parseValue(Ljava/lang/String;)Ljava/lang/Object;
.end method

.method public abstract put(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V
.end method

.method public serializeAsValue(Ljava/lang/Object;)Ljava/lang/String;
    .locals 0

    .line 1
    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    return-object p1
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
.end method

.method public final toString()Ljava/lang/String;
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroidx/navigation/NavType;->getName()Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
