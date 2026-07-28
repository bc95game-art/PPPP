.class public final Landroidx/navigation/NavInflater;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final sTmpValue:Ljava/lang/ThreadLocal;


# instance fields
.field public final context:Landroid/content/Context;

.field public final navigatorProvider:Landroidx/navigation/NavigatorProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Ljava/lang/ThreadLocal;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/ThreadLocal;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Landroidx/navigation/NavInflater;->sTmpValue:Ljava/lang/ThreadLocal;

    .line 7
    .line 8
    return-void
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

.method public constructor <init>(Landroid/content/Context;Landroidx/navigation/NavigatorProvider;)V
    .locals 1

    .line 1
    const-string v0, "navigatorProvider"

    .line 2
    .line 3
    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object p1, p0, Landroidx/navigation/NavInflater;->context:Landroid/content/Context;

    .line 10
    .line 11
    iput-object p2, p0, Landroidx/navigation/NavInflater;->navigatorProvider:Landroidx/navigation/NavigatorProvider;

    .line 12
    .line 13
    return-void
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

.method public static inflateArgument(Landroid/content/res/TypedArray;Landroid/content/res/Resources;I)Landroidx/navigation/NavArgument;
    .locals 17

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    const/4 v2, 0x3

    .line 4
    const/4 v3, 0x0

    .line 5
    invoke-virtual {v1, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    .line 6
    .line 7
    .line 8
    move-result v4

    .line 9
    sget-object v0, Landroidx/navigation/NavInflater;->sTmpValue:Ljava/lang/ThreadLocal;

    .line 10
    .line 11
    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    .line 12
    .line 13
    .line 14
    move-result-object v5

    .line 15
    check-cast v5, Landroid/util/TypedValue;

    .line 16
    .line 17
    if-nez v5, :cond_0

    .line 18
    .line 19
    new-instance v5, Landroid/util/TypedValue;

    .line 20
    .line 21
    invoke-direct {v5}, Landroid/util/TypedValue;-><init>()V

    .line 22
    .line 23
    .line 24
    invoke-virtual {v0, v5}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    .line 25
    .line 26
    .line 27
    :cond_0
    const/4 v0, 0x2

    .line 28
    invoke-virtual {v1, v0}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    .line 29
    .line 30
    .line 31
    move-result-object v6

    .line 32
    const/4 v7, 0x4

    .line 33
    if-eqz v6, :cond_3

    .line 34
    .line 35
    invoke-virtual/range {p1 .. p2}, Landroid/content/res/Resources;->getResourcePackageName(I)Ljava/lang/String;

    .line 36
    .line 37
    .line 38
    move-result-object v9

    .line 39
    const-string v0, "j$"

    .line 40
    .line 41
    const-string v10, "java"

    .line 42
    .line 43
    invoke-virtual {v6, v10}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 44
    .line 45
    .line 46
    move-result v10

    .line 47
    if-nez v10, :cond_1

    .line 48
    .line 49
    :goto_0
    invoke-static {v6, v9}, Landroidx/navigation/Navigation;->fromArgType(Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;

    .line 50
    .line 51
    .line 52
    move-result-object v0

    .line 53
    goto :goto_1

    .line 54
    :cond_1
    :try_start_0
    new-instance v10, Ljava/lang/StringBuilder;

    .line 55
    .line 56
    invoke-direct {v10, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 57
    .line 58
    .line 59
    invoke-virtual {v6, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 60
    .line 61
    .line 62
    move-result-object v0

    .line 63
    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 64
    .line 65
    .line 66
    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 67
    .line 68
    .line 69
    move-result-object v0

    .line 70
    invoke-static {v0, v9}, Landroidx/navigation/Navigation;->fromArgType(Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;

    .line 71
    .line 72
    .line 73
    move-result-object v0
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    goto :goto_1

    .line 75
    :catch_0
    move-exception v0

    .line 76
    invoke-virtual {v0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    .line 77
    .line 78
    .line 79
    move-result-object v10

    .line 80
    instance-of v10, v10, Ljava/lang/ClassNotFoundException;

    .line 81
    .line 82
    if-eqz v10, :cond_2

    .line 83
    .line 84
    goto :goto_0

    .line 85
    :cond_2
    throw v0

    .line 86
    :cond_3
    const/4 v0, 0x0

    .line 87
    :goto_1
    const/4 v9, 0x1

    .line 88
    invoke-virtual {v1, v9, v5}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 89
    .line 90
    .line 91
    move-result v10

    .line 92
    sget-object v11, Landroidx/navigation/NavType;->LongType:Landroidx/navigation/IntNavType;

    .line 93
    .line 94
    sget-object v12, Landroidx/navigation/NavType;->BoolType:Landroidx/navigation/IntNavType;

    .line 95
    .line 96
    sget-object v13, Landroidx/navigation/NavType;->StringType:Landroidx/navigation/IntNavType;

    .line 97
    .line 98
    sget-object v14, Landroidx/navigation/NavType;->IntType:Landroidx/navigation/IntNavType;

    .line 99
    .line 100
    sget-object v15, Landroidx/navigation/NavType;->FloatType:Landroidx/navigation/IntNavType;

    .line 101
    .line 102
    if-eqz v10, :cond_12

    .line 103
    .line 104
    const-string v10, "\' for "

    .line 105
    .line 106
    const/16 v16, 0x0

    .line 107
    .line 108
    const-string v3, "unsupported value \'"

    .line 109
    .line 110
    const/16 v8, 0x10

    .line 111
    .line 112
    sget-object v7, Landroidx/navigation/NavType;->ReferenceType:Landroidx/navigation/IntNavType;

    .line 113
    .line 114
    if-ne v0, v7, :cond_6

    .line 115
    .line 116
    iget v1, v5, Landroid/util/TypedValue;->resourceId:I

    .line 117
    .line 118
    if-eqz v1, :cond_4

    .line 119
    .line 120
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 121
    .line 122
    .line 123
    move-result-object v1

    .line 124
    goto/16 :goto_4

    .line 125
    .line 126
    :cond_4
    iget v1, v5, Landroid/util/TypedValue;->type:I

    .line 127
    .line 128
    if-ne v1, v8, :cond_5

    .line 129
    .line 130
    iget v1, v5, Landroid/util/TypedValue;->data:I

    .line 131
    .line 132
    if-nez v1, :cond_5

    .line 133
    .line 134
    invoke-static/range {v16 .. v16}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 135
    .line 136
    .line 137
    move-result-object v1

    .line 138
    goto/16 :goto_4

    .line 139
    .line 140
    :cond_5
    new-instance v1, Lorg/xmlpull/v1/XmlPullParserException;

    .line 141
    .line 142
    new-instance v2, Ljava/lang/StringBuilder;

    .line 143
    .line 144
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 145
    .line 146
    .line 147
    iget-object v3, v5, Landroid/util/TypedValue;->string:Ljava/lang/CharSequence;

    .line 148
    .line 149
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 150
    .line 151
    .line 152
    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 153
    .line 154
    .line 155
    invoke-virtual {v0}, Landroidx/navigation/NavType;->getName()Ljava/lang/String;

    .line 156
    .line 157
    .line 158
    move-result-object v0

    .line 159
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 160
    .line 161
    .line 162
    const-string v0, ". Must be a reference to a resource."

    .line 163
    .line 164
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 165
    .line 166
    .line 167
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 168
    .line 169
    .line 170
    move-result-object v0

    .line 171
    invoke-direct {v1, v0}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    .line 172
    .line 173
    .line 174
    throw v1

    .line 175
    :cond_6
    iget v8, v5, Landroid/util/TypedValue;->resourceId:I

    .line 176
    .line 177
    if-eqz v8, :cond_8

    .line 178
    .line 179
    if-nez v0, :cond_7

    .line 180
    .line 181
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 182
    .line 183
    .line 184
    move-result-object v1

    .line 185
    move-object v0, v7

    .line 186
    goto/16 :goto_4

    .line 187
    .line 188
    :cond_7
    new-instance v1, Lorg/xmlpull/v1/XmlPullParserException;

    .line 189
    .line 190
    new-instance v2, Ljava/lang/StringBuilder;

    .line 191
    .line 192
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 193
    .line 194
    .line 195
    iget-object v3, v5, Landroid/util/TypedValue;->string:Ljava/lang/CharSequence;

    .line 196
    .line 197
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 198
    .line 199
    .line 200
    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 201
    .line 202
    .line 203
    invoke-virtual {v0}, Landroidx/navigation/NavType;->getName()Ljava/lang/String;

    .line 204
    .line 205
    .line 206
    move-result-object v0

    .line 207
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 208
    .line 209
    .line 210
    const-string v0, ". You must use a \"reference\" type to reference other resources."

    .line 211
    .line 212
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 213
    .line 214
    .line 215
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 216
    .line 217
    .line 218
    move-result-object v0

    .line 219
    invoke-direct {v1, v0}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    .line 220
    .line 221
    .line 222
    throw v1

    .line 223
    :cond_8
    if-ne v0, v13, :cond_9

    .line 224
    .line 225
    invoke-virtual {v1, v9}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    .line 226
    .line 227
    .line 228
    move-result-object v1

    .line 229
    goto/16 :goto_4

    .line 230
    .line 231
    :cond_9
    iget v1, v5, Landroid/util/TypedValue;->type:I

    .line 232
    .line 233
    if-eq v1, v2, :cond_10

    .line 234
    .line 235
    const-string v2, "float"

    .line 236
    .line 237
    const/4 v3, 0x4

    .line 238
    if-eq v1, v3, :cond_f

    .line 239
    .line 240
    const/4 v3, 0x5

    .line 241
    if-eq v1, v3, :cond_e

    .line 242
    .line 243
    const/16 v3, 0x12

    .line 244
    .line 245
    if-eq v1, v3, :cond_c

    .line 246
    .line 247
    const/16 v3, 0x10

    .line 248
    .line 249
    if-lt v1, v3, :cond_b

    .line 250
    .line 251
    const/16 v3, 0x1f

    .line 252
    .line 253
    if-gt v1, v3, :cond_b

    .line 254
    .line 255
    if-ne v0, v15, :cond_a

    .line 256
    .line 257
    invoke-static {v5, v0, v15, v6, v2}, Landroidx/navigation/Navigation;->checkNavType$navigation_runtime_release(Landroid/util/TypedValue;Landroidx/navigation/NavType;Landroidx/navigation/NavType;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;

    .line 258
    .line 259
    .line 260
    move-result-object v0

    .line 261
    iget v1, v5, Landroid/util/TypedValue;->data:I

    .line 262
    .line 263
    int-to-float v1, v1

    .line 264
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 265
    .line 266
    .line 267
    move-result-object v1

    .line 268
    goto/16 :goto_4

    .line 269
    .line 270
    :cond_a
    const-string v1, "integer"

    .line 271
    .line 272
    invoke-static {v5, v0, v14, v6, v1}, Landroidx/navigation/Navigation;->checkNavType$navigation_runtime_release(Landroid/util/TypedValue;Landroidx/navigation/NavType;Landroidx/navigation/NavType;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;

    .line 273
    .line 274
    .line 275
    move-result-object v0

    .line 276
    iget v1, v5, Landroid/util/TypedValue;->data:I

    .line 277
    .line 278
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 279
    .line 280
    .line 281
    move-result-object v1

    .line 282
    goto/16 :goto_4

    .line 283
    .line 284
    :cond_b
    new-instance v0, Lorg/xmlpull/v1/XmlPullParserException;

    .line 285
    .line 286
    new-instance v1, Ljava/lang/StringBuilder;

    .line 287
    .line 288
    const-string v2, "unsupported argument type "

    .line 289
    .line 290
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 291
    .line 292
    .line 293
    iget v2, v5, Landroid/util/TypedValue;->type:I

    .line 294
    .line 295
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 296
    .line 297
    .line 298
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 299
    .line 300
    .line 301
    move-result-object v1

    .line 302
    invoke-direct {v0, v1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    .line 303
    .line 304
    .line 305
    throw v0

    .line 306
    :cond_c
    const-string v1, "boolean"

    .line 307
    .line 308
    invoke-static {v5, v0, v12, v6, v1}, Landroidx/navigation/Navigation;->checkNavType$navigation_runtime_release(Landroid/util/TypedValue;Landroidx/navigation/NavType;Landroidx/navigation/NavType;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;

    .line 309
    .line 310
    .line 311
    move-result-object v0

    .line 312
    iget v1, v5, Landroid/util/TypedValue;->data:I

    .line 313
    .line 314
    if-eqz v1, :cond_d

    .line 315
    .line 316
    const/4 v1, 0x1

    .line 317
    goto :goto_2

    .line 318
    :cond_d
    const/4 v1, 0x0

    .line 319
    :goto_2
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 320
    .line 321
    .line 322
    move-result-object v1

    .line 323
    goto :goto_4

    .line 324
    :cond_e
    const-string v1, "dimension"

    .line 325
    .line 326
    invoke-static {v5, v0, v14, v6, v1}, Landroidx/navigation/Navigation;->checkNavType$navigation_runtime_release(Landroid/util/TypedValue;Landroidx/navigation/NavType;Landroidx/navigation/NavType;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;

    .line 327
    .line 328
    .line 329
    move-result-object v0

    .line 330
    invoke-virtual/range {p1 .. p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    .line 331
    .line 332
    .line 333
    move-result-object v1

    .line 334
    invoke-virtual {v5, v1}, Landroid/util/TypedValue;->getDimension(Landroid/util/DisplayMetrics;)F

    .line 335
    .line 336
    .line 337
    move-result v1

    .line 338
    float-to-int v1, v1

    .line 339
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 340
    .line 341
    .line 342
    move-result-object v1

    .line 343
    goto :goto_4

    .line 344
    :cond_f
    invoke-static {v5, v0, v15, v6, v2}, Landroidx/navigation/Navigation;->checkNavType$navigation_runtime_release(Landroid/util/TypedValue;Landroidx/navigation/NavType;Landroidx/navigation/NavType;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;

    .line 345
    .line 346
    .line 347
    move-result-object v0

    .line 348
    invoke-virtual {v5}, Landroid/util/TypedValue;->getFloat()F

    .line 349
    .line 350
    .line 351
    move-result v1

    .line 352
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 353
    .line 354
    .line 355
    move-result-object v1

    .line 356
    goto :goto_4

    .line 357
    :cond_10
    iget-object v1, v5, Landroid/util/TypedValue;->string:Ljava/lang/CharSequence;

    .line 358
    .line 359
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 360
    .line 361
    .line 362
    move-result-object v1

    .line 363
    if-nez v0, :cond_11

    .line 364
    .line 365
    const-string v0, "value"

    .line 366
    .line 367
    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 368
    .line 369
    .line 370
    :try_start_1
    invoke-virtual {v14, v1}, Landroidx/navigation/IntNavType;->parseValue(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    .line 371
    .line 372
    .line 373
    move-object v0, v14

    .line 374
    goto :goto_3

    .line 375
    :catch_1
    :try_start_2
    invoke-virtual {v11, v1}, Landroidx/navigation/IntNavType;->parseValue(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_2

    .line 376
    .line 377
    .line 378
    move-object v0, v11

    .line 379
    goto :goto_3

    .line 380
    :catch_2
    :try_start_3
    invoke-virtual {v15, v1}, Landroidx/navigation/IntNavType;->parseValue(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_3
    .catch Ljava/lang/IllegalArgumentException; {:try_start_3 .. :try_end_3} :catch_3

    .line 381
    .line 382
    .line 383
    move-object v0, v15

    .line 384
    goto :goto_3

    .line 385
    :catch_3
    :try_start_4
    invoke-virtual {v12, v1}, Landroidx/navigation/IntNavType;->parseValue(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_4
    .catch Ljava/lang/IllegalArgumentException; {:try_start_4 .. :try_end_4} :catch_4

    .line 386
    .line 387
    .line 388
    move-object v0, v12

    .line 389
    goto :goto_3

    .line 390
    :catch_4
    move-object v0, v13

    .line 391
    :cond_11
    :goto_3
    invoke-virtual {v0, v1}, Landroidx/navigation/NavType;->parseValue(Ljava/lang/String;)Ljava/lang/Object;

    .line 392
    .line 393
    .line 394
    move-result-object v1

    .line 395
    goto :goto_4

    .line 396
    :cond_12
    const/16 v16, 0x0

    .line 397
    .line 398
    const/4 v1, 0x0

    .line 399
    :goto_4
    if-eqz v1, :cond_13

    .line 400
    .line 401
    const/4 v3, 0x1

    .line 402
    goto :goto_5

    .line 403
    :cond_13
    const/4 v1, 0x0

    .line 404
    const/4 v3, 0x0

    .line 405
    :goto_5
    if-eqz v0, :cond_14

    .line 406
    .line 407
    goto :goto_6

    .line 408
    :cond_14
    const/4 v0, 0x0

    .line 409
    :goto_6
    if-nez v0, :cond_26

    .line 410
    .line 411
    instance-of v0, v1, Ljava/lang/Integer;

    .line 412
    .line 413
    if-eqz v0, :cond_15

    .line 414
    .line 415
    move-object v8, v14

    .line 416
    goto :goto_8

    .line 417
    :cond_15
    instance-of v0, v1, [I

    .line 418
    .line 419
    if-eqz v0, :cond_16

    .line 420
    .line 421
    sget-object v8, Landroidx/navigation/NavType;->IntArrayType:Landroidx/navigation/IntListNavType;

    .line 422
    .line 423
    goto :goto_8

    .line 424
    :cond_16
    instance-of v0, v1, Ljava/lang/Long;

    .line 425
    .line 426
    if-eqz v0, :cond_17

    .line 427
    .line 428
    move-object v8, v11

    .line 429
    goto :goto_8

    .line 430
    :cond_17
    instance-of v0, v1, [J

    .line 431
    .line 432
    if-eqz v0, :cond_18

    .line 433
    .line 434
    sget-object v8, Landroidx/navigation/NavType;->LongArrayType:Landroidx/navigation/IntListNavType;

    .line 435
    .line 436
    goto :goto_8

    .line 437
    :cond_18
    instance-of v0, v1, Ljava/lang/Float;

    .line 438
    .line 439
    if-eqz v0, :cond_19

    .line 440
    .line 441
    move-object v8, v15

    .line 442
    goto :goto_8

    .line 443
    :cond_19
    instance-of v0, v1, [F

    .line 444
    .line 445
    if-eqz v0, :cond_1a

    .line 446
    .line 447
    sget-object v8, Landroidx/navigation/NavType;->FloatArrayType:Landroidx/navigation/IntListNavType;

    .line 448
    .line 449
    goto :goto_8

    .line 450
    :cond_1a
    instance-of v0, v1, Ljava/lang/Boolean;

    .line 451
    .line 452
    if-eqz v0, :cond_1b

    .line 453
    .line 454
    move-object v8, v12

    .line 455
    goto :goto_8

    .line 456
    :cond_1b
    instance-of v0, v1, [Z

    .line 457
    .line 458
    if-eqz v0, :cond_1c

    .line 459
    .line 460
    sget-object v8, Landroidx/navigation/NavType;->BoolArrayType:Landroidx/navigation/IntListNavType;

    .line 461
    .line 462
    goto :goto_8

    .line 463
    :cond_1c
    instance-of v0, v1, Ljava/lang/String;

    .line 464
    .line 465
    if-nez v0, :cond_1e

    .line 466
    .line 467
    if-nez v1, :cond_1d

    .line 468
    .line 469
    goto :goto_7

    .line 470
    :cond_1d
    const/4 v8, 0x0

    .line 471
    goto :goto_8

    .line 472
    :cond_1e
    :goto_7
    move-object v8, v13

    .line 473
    :goto_8
    if-nez v8, :cond_25

    .line 474
    .line 475
    instance-of v0, v1, [Ljava/lang/Object;

    .line 476
    .line 477
    if-eqz v0, :cond_1f

    .line 478
    .line 479
    move-object v0, v1

    .line 480
    check-cast v0, [Ljava/lang/Object;

    .line 481
    .line 482
    instance-of v0, v0, [Ljava/lang/String;

    .line 483
    .line 484
    if-eqz v0, :cond_1f

    .line 485
    .line 486
    sget-object v0, Landroidx/navigation/NavType;->StringArrayType:Landroidx/navigation/IntListNavType;

    .line 487
    .line 488
    goto/16 :goto_9

    .line 489
    .line 490
    :cond_1f
    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 491
    .line 492
    .line 493
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 494
    .line 495
    .line 496
    move-result-object v0

    .line 497
    invoke-virtual {v0}, Ljava/lang/Class;->isArray()Z

    .line 498
    .line 499
    .line 500
    move-result v0

    .line 501
    if-eqz v0, :cond_20

    .line 502
    .line 503
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 504
    .line 505
    .line 506
    move-result-object v0

    .line 507
    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    .line 508
    .line 509
    .line 510
    move-result-object v0

    .line 511
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 512
    .line 513
    .line 514
    const-class v2, Landroid/os/Parcelable;

    .line 515
    .line 516
    invoke-virtual {v2, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    .line 517
    .line 518
    .line 519
    move-result v0

    .line 520
    if-eqz v0, :cond_20

    .line 521
    .line 522
    new-instance v0, Landroidx/navigation/NavType$ParcelableArrayType;

    .line 523
    .line 524
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 525
    .line 526
    .line 527
    move-result-object v2

    .line 528
    invoke-virtual {v2}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    .line 529
    .line 530
    .line 531
    move-result-object v2

    .line 532
    const-string v5, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>"

    .line 533
    .line 534
    invoke-static {v2, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 535
    .line 536
    .line 537
    invoke-direct {v0, v2}, Landroidx/navigation/NavType$ParcelableArrayType;-><init>(Ljava/lang/Class;)V

    .line 538
    .line 539
    .line 540
    goto/16 :goto_9

    .line 541
    .line 542
    :cond_20
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 543
    .line 544
    .line 545
    move-result-object v0

    .line 546
    invoke-virtual {v0}, Ljava/lang/Class;->isArray()Z

    .line 547
    .line 548
    .line 549
    move-result v0

    .line 550
    if-eqz v0, :cond_21

    .line 551
    .line 552
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 553
    .line 554
    .line 555
    move-result-object v0

    .line 556
    invoke-virtual {v0}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    .line 557
    .line 558
    .line 559
    move-result-object v0

    .line 560
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 561
    .line 562
    .line 563
    const-class v2, Ljava/io/Serializable;

    .line 564
    .line 565
    invoke-virtual {v2, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    .line 566
    .line 567
    .line 568
    move-result v0

    .line 569
    if-eqz v0, :cond_21

    .line 570
    .line 571
    new-instance v0, Landroidx/navigation/NavType$SerializableArrayType;

    .line 572
    .line 573
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 574
    .line 575
    .line 576
    move-result-object v2

    .line 577
    invoke-virtual {v2}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    .line 578
    .line 579
    .line 580
    move-result-object v2

    .line 581
    const-string v5, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>"

    .line 582
    .line 583
    invoke-static {v2, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 584
    .line 585
    .line 586
    invoke-direct {v0, v2}, Landroidx/navigation/NavType$SerializableArrayType;-><init>(Ljava/lang/Class;)V

    .line 587
    .line 588
    .line 589
    goto :goto_9

    .line 590
    :cond_21
    instance-of v0, v1, Landroid/os/Parcelable;

    .line 591
    .line 592
    if-eqz v0, :cond_22

    .line 593
    .line 594
    new-instance v0, Landroidx/navigation/NavType$ParcelableType;

    .line 595
    .line 596
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 597
    .line 598
    .line 599
    move-result-object v2

    .line 600
    invoke-direct {v0, v2}, Landroidx/navigation/NavType$ParcelableType;-><init>(Ljava/lang/Class;)V

    .line 601
    .line 602
    .line 603
    goto :goto_9

    .line 604
    :cond_22
    instance-of v0, v1, Ljava/lang/Enum;

    .line 605
    .line 606
    if-eqz v0, :cond_23

    .line 607
    .line 608
    new-instance v0, Landroidx/navigation/NavType$EnumType;

    .line 609
    .line 610
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 611
    .line 612
    .line 613
    move-result-object v2

    .line 614
    invoke-direct {v0, v2}, Landroidx/navigation/NavType$EnumType;-><init>(Ljava/lang/Class;)V

    .line 615
    .line 616
    .line 617
    goto :goto_9

    .line 618
    :cond_23
    instance-of v0, v1, Ljava/io/Serializable;

    .line 619
    .line 620
    if-eqz v0, :cond_24

    .line 621
    .line 622
    new-instance v0, Landroidx/navigation/NavType$SerializableType;

    .line 623
    .line 624
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 625
    .line 626
    .line 627
    move-result-object v2

    .line 628
    invoke-direct {v0, v2}, Landroidx/navigation/NavType$SerializableType;-><init>(Ljava/lang/Class;)V

    .line 629
    .line 630
    .line 631
    goto :goto_9

    .line 632
    :cond_24
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 633
    .line 634
    new-instance v2, Ljava/lang/StringBuilder;

    .line 635
    .line 636
    const-string v3, "Object of type "

    .line 637
    .line 638
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 639
    .line 640
    .line 641
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 642
    .line 643
    .line 644
    move-result-object v1

    .line 645
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    .line 646
    .line 647
    .line 648
    move-result-object v1

    .line 649
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 650
    .line 651
    .line 652
    const-string v1, " is not supported for navigation arguments."

    .line 653
    .line 654
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 655
    .line 656
    .line 657
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 658
    .line 659
    .line 660
    move-result-object v1

    .line 661
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 662
    .line 663
    .line 664
    throw v0

    .line 665
    :cond_25
    move-object v0, v8

    .line 666
    :cond_26
    :goto_9
    new-instance v2, Landroidx/navigation/NavArgument;

    .line 667
    .line 668
    invoke-direct {v2, v0, v4, v1, v3}, Landroidx/navigation/NavArgument;-><init>(Landroidx/navigation/NavType;ZLjava/lang/Object;Z)V

    .line 669
    .line 670
    .line 671
    return-object v2
    .line 672
    .line 673
    .line 674
    .line 675
    .line 676
    .line 677
    .line 678
    .line 679
    .line 680
    .line 681
    .line 682
    .line 683
    .line 684
    .line 685
    .line 686
    .line 687
    .line 688
    .line 689
    .line 690
    .line 691
    .line 692
    .line 693
    .line 694
    .line 695
    .line 696
    .line 697
    .line 698
    .line 699
    .line 700
    .line 701
    .line 702
    .line 703
    .line 704
    .line 705
    .line 706
    .line 707
    .line 708
    .line 709
    .line 710
    .line 711
    .line 712
    .line 713
    .line 714
    .line 715
    .line 716
    .line 717
    .line 718
    .line 719
    .line 720
    .line 721
    .line 722
    .line 723
    .line 724
    .line 725
    .line 726
    .line 727
    .line 728
    .line 729
    .line 730
    .line 731
    .line 732
    .line 733
    .line 734
    .line 735
    .line 736
    .line 737
    .line 738
    .line 739
    .line 740
    .line 741
    .line 742
    .line 743
    .line 744
    .line 745
    .line 746
    .line 747
    .line 748
    .line 749
    .line 750
    .line 751
    .line 752
    .line 753
    .line 754
    .line 755
    .line 756
    .line 757
    .line 758
    .line 759
    .line 760
    .line 761
    .line 762
    .line 763
    .line 764
    .line 765
    .line 766
    .line 767
    .line 768
    .line 769
    .line 770
    .line 771
    .line 772
    .line 773
    .line 774
    .line 775
    .line 776
    .line 777
    .line 778
    .line 779
    .line 780
    .line 781
    .line 782
    .line 783
    .line 784
    .line 785
    .line 786
    .line 787
    .line 788
    .line 789
    .line 790
    .line 791
    .line 792
    .line 793
    .line 794
    .line 795
    .line 796
    .line 797
    .line 798
    .line 799
    .line 800
    .line 801
    .line 802
    .line 803
    .line 804
    .line 805
    .line 806
    .line 807
    .line 808
    .line 809
    .line 810
    .line 811
    .line 812
    .line 813
    .line 814
    .line 815
    .line 816
    .line 817
    .line 818
    .line 819
    .line 820
    .line 821
    .line 822
    .line 823
    .line 824
    .line 825
    .line 826
    .line 827
    .line 828
    .line 829
    .line 830
    .line 831
    .line 832
    .line 833
    .line 834
    .line 835
    .line 836
    .line 837
    .line 838
    .line 839
    .line 840
    .line 841
    .line 842
    .line 843
    .line 844
    .line 845
    .line 846
    .line 847
    .line 848
    .line 849
    .line 850
    .line 851
    .line 852
    .line 853
    .line 854
    .line 855
    .line 856
    .line 857
    .line 858
    .line 859
    .line 860
    .line 861
    .line 862
    .line 863
    .line 864
    .line 865
    .line 866
    .line 867
    .line 868
    .line 869
    .line 870
    .line 871
    .line 872
    .line 873
    .line 874
    .line 875
    .line 876
    .line 877
    .line 878
    .line 879
    .line 880
    .line 881
    .line 882
    .line 883
    .line 884
    .line 885
    .line 886
    .line 887
    .line 888
    .line 889
    .line 890
    .line 891
    .line 892
    .line 893
    .line 894
    .line 895
    .line 896
    .line 897
    .line 898
    .line 899
    .line 900
    .line 901
    .line 902
    .line 903
    .line 904
    .line 905
    .line 906
    .line 907
    .line 908
    .line 909
    .line 910
    .line 911
    .line 912
    .line 913
    .line 914
    .line 915
    .line 916
    .line 917
    .line 918
    .line 919
    .line 920
    .line 921
    .line 922
    .line 923
    .line 924
    .line 925
    .line 926
    .line 927
    .line 928
    .line 929
    .line 930
    .line 931
    .line 932
    .line 933
    .line 934
    .line 935
    .line 936
    .line 937
    .line 938
    .line 939
    .line 940
    .line 941
    .line 942
    .line 943
    .line 944
    .line 945
    .line 946
    .line 947
    .line 948
    .line 949
    .line 950
    .line 951
    .line 952
    .line 953
    .line 954
    .line 955
    .line 956
    .line 957
    .line 958
    .line 959
    .line 960
    .line 961
    .line 962
    .line 963
    .line 964
    .line 965
    .line 966
    .line 967
    .line 968
    .line 969
    .line 970
    .line 971
    .line 972
    .line 973
    .line 974
    .line 975
    .line 976
    .line 977
    .line 978
    .line 979
    .line 980
    .line 981
    .line 982
    .line 983
    .line 984
    .line 985
    .line 986
    .line 987
    .line 988
    .line 989
    .line 990
    .line 991
    .line 992
    .line 993
    .line 994
    .line 995
    .line 996
    .line 997
    .line 998
    .line 999
    .line 1000
    .line 1001
    .line 1002
    .line 1003
    .line 1004
    .line 1005
    .line 1006
    .line 1007
    .line 1008
    .line 1009
    .line 1010
    .line 1011
    .line 1012
    .line 1013
    .line 1014
    .line 1015
    .line 1016
    .line 1017
    .line 1018
    .line 1019
    .line 1020
    .line 1021
    .line 1022
    .line 1023
    .line 1024
    .line 1025
    .line 1026
    .line 1027
    .line 1028
    .line 1029
    .line 1030
    .line 1031
    .line 1032
    .line 1033
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
    .line 2143
    .line 2144
    .line 2145
    .line 2146
    .line 2147
    .line 2148
    .line 2149
    .line 2150
    .line 2151
    .line 2152
    .line 2153
    .line 2154
    .line 2155
    .line 2156
    .line 2157
    .line 2158
    .line 2159
    .line 2160
    .line 2161
    .line 2162
    .line 2163
    .line 2164
    .line 2165
    .line 2166
    .line 2167
    .line 2168
    .line 2169
    .line 2170
    .line 2171
    .line 2172
    .line 2173
    .line 2174
    .line 2175
    .line 2176
    .line 2177
    .line 2178
    .line 2179
    .line 2180
    .line 2181
    .line 2182
    .line 2183
    .line 2184
    .line 2185
    .line 2186
    .line 2187
    .line 2188
    .line 2189
    .line 2190
    .line 2191
    .line 2192
    .line 2193
    .line 2194
    .line 2195
    .line 2196
    .line 2197
    .line 2198
    .line 2199
    .line 2200
    .line 2201
    .line 2202
    .line 2203
    .line 2204
    .line 2205
    .line 2206
    .line 2207
    .line 2208
    .line 2209
    .line 2210
    .line 2211
    .line 2212
    .line 2213
    .line 2214
    .line 2215
    .line 2216
    .line 2217
    .line 2218
    .line 2219
    .line 2220
    .line 2221
    .line 2222
    .line 2223
    .line 2224
    .line 2225
    .line 2226
    .line 2227
    .line 2228
    .line 2229
    .line 2230
    .line 2231
    .line 2232
    .line 2233
    .line 2234
    .line 2235
    .line 2236
    .line 2237
    .line 2238
    .line 2239
    .line 2240
    .line 2241
    .line 2242
    .line 2243
    .line 2244
    .line 2245
    .line 2246
    .line 2247
    .line 2248
    .line 2249
    .line 2250
    .line 2251
    .line 2252
    .line 2253
    .line 2254
    .line 2255
    .line 2256
    .line 2257
    .line 2258
    .line 2259
    .line 2260
    .line 2261
    .line 2262
    .line 2263
    .line 2264
    .line 2265
    .line 2266
    .line 2267
    .line 2268
    .line 2269
    .line 2270
    .line 2271
    .line 2272
    .line 2273
    .line 2274
    .line 2275
    .line 2276
    .line 2277
    .line 2278
    .line 2279
    .line 2280
    .line 2281
    .line 2282
    .line 2283
    .line 2284
    .line 2285
    .line 2286
    .line 2287
    .line 2288
    .line 2289
    .line 2290
    .line 2291
    .line 2292
    .line 2293
    .line 2294
    .line 2295
    .line 2296
    .line 2297
    .line 2298
    .line 2299
    .line 2300
    .line 2301
    .line 2302
    .line 2303
    .line 2304
    .line 2305
    .line 2306
    .line 2307
    .line 2308
    .line 2309
    .line 2310
    .line 2311
    .line 2312
    .line 2313
    .line 2314
    .line 2315
    .line 2316
    .line 2317
    .line 2318
    .line 2319
    .line 2320
    .line 2321
    .line 2322
    .line 2323
    .line 2324
    .line 2325
    .line 2326
    .line 2327
    .line 2328
    .line 2329
    .line 2330
    .line 2331
    .line 2332
    .line 2333
    .line 2334
    .line 2335
    .line 2336
    .line 2337
    .line 2338
    .line 2339
    .line 2340
    .line 2341
    .line 2342
    .line 2343
    .line 2344
    .line 2345
    .line 2346
    .line 2347
    .line 2348
    .line 2349
    .line 2350
    .line 2351
    .line 2352
    .line 2353
    .line 2354
    .line 2355
    .line 2356
    .line 2357
    .line 2358
    .line 2359
    .line 2360
    .line 2361
    .line 2362
    .line 2363
    .line 2364
    .line 2365
    .line 2366
    .line 2367
    .line 2368
    .line 2369
    .line 2370
    .line 2371
    .line 2372
    .line 2373
    .line 2374
    .line 2375
    .line 2376
    .line 2377
    .line 2378
    .line 2379
    .line 2380
    .line 2381
    .line 2382
    .line 2383
    .line 2384
    .line 2385
    .line 2386
    .line 2387
    .line 2388
    .line 2389
    .line 2390
    .line 2391
    .line 2392
    .line 2393
    .line 2394
    .line 2395
    .line 2396
    .line 2397
    .line 2398
    .line 2399
    .line 2400
    .line 2401
    .line 2402
    .line 2403
    .line 2404
    .line 2405
    .line 2406
    .line 2407
    .line 2408
    .line 2409
    .line 2410
    .line 2411
    .line 2412
    .line 2413
    .line 2414
    .line 2415
    .line 2416
    .line 2417
    .line 2418
    .line 2419
    .line 2420
    .line 2421
    .line 2422
    .line 2423
    .line 2424
    .line 2425
    .line 2426
    .line 2427
    .line 2428
    .line 2429
    .line 2430
    .line 2431
    .line 2432
    .line 2433
    .line 2434
    .line 2435
    .line 2436
    .line 2437
    .line 2438
    .line 2439
    .line 2440
    .line 2441
    .line 2442
    .line 2443
    .line 2444
    .line 2445
    .line 2446
    .line 2447
    .line 2448
    .line 2449
    .line 2450
    .line 2451
    .line 2452
    .line 2453
    .line 2454
    .line 2455
    .line 2456
    .line 2457
    .line 2458
    .line 2459
    .line 2460
    .line 2461
    .line 2462
    .line 2463
    .line 2464
    .line 2465
    .line 2466
    .line 2467
    .line 2468
    .line 2469
    .line 2470
    .line 2471
    .line 2472
    .line 2473
    .line 2474
    .line 2475
    .line 2476
    .line 2477
    .line 2478
    .line 2479
    .line 2480
    .line 2481
    .line 2482
    .line 2483
    .line 2484
    .line 2485
    .line 2486
    .line 2487
    .line 2488
    .line 2489
    .line 2490
    .line 2491
    .line 2492
    .line 2493
    .line 2494
    .line 2495
    .line 2496
    .line 2497
    .line 2498
    .line 2499
    .line 2500
    .line 2501
    .line 2502
    .line 2503
    .line 2504
    .line 2505
    .line 2506
    .line 2507
    .line 2508
    .line 2509
    .line 2510
    .line 2511
    .line 2512
    .line 2513
    .line 2514
    .line 2515
    .line 2516
    .line 2517
    .line 2518
    .line 2519
    .line 2520
    .line 2521
    .line 2522
    .line 2523
    .line 2524
    .line 2525
    .line 2526
    .line 2527
    .line 2528
    .line 2529
    .line 2530
    .line 2531
    .line 2532
    .line 2533
    .line 2534
    .line 2535
    .line 2536
    .line 2537
    .line 2538
    .line 2539
    .line 2540
    .line 2541
    .line 2542
    .line 2543
    .line 2544
    .line 2545
    .line 2546
    .line 2547
    .line 2548
    .line 2549
    .line 2550
    .line 2551
    .line 2552
    .line 2553
    .line 2554
    .line 2555
    .line 2556
    .line 2557
    .line 2558
    .line 2559
    .line 2560
    .line 2561
    .line 2562
    .line 2563
    .line 2564
    .line 2565
    .line 2566
    .line 2567
    .line 2568
    .line 2569
    .line 2570
    .line 2571
    .line 2572
    .line 2573
    .line 2574
    .line 2575
    .line 2576
    .line 2577
    .line 2578
    .line 2579
    .line 2580
    .line 2581
    .line 2582
    .line 2583
    .line 2584
    .line 2585
    .line 2586
    .line 2587
    .line 2588
    .line 2589
    .line 2590
    .line 2591
    .line 2592
    .line 2593
    .line 2594
    .line 2595
    .line 2596
    .line 2597
    .line 2598
    .line 2599
    .line 2600
    .line 2601
    .line 2602
    .line 2603
    .line 2604
    .line 2605
    .line 2606
    .line 2607
    .line 2608
    .line 2609
    .line 2610
    .line 2611
    .line 2612
    .line 2613
    .line 2614
    .line 2615
    .line 2616
    .line 2617
    .line 2618
    .line 2619
    .line 2620
    .line 2621
    .line 2622
    .line 2623
    .line 2624
    .line 2625
    .line 2626
    .line 2627
    .line 2628
    .line 2629
    .line 2630
    .line 2631
    .line 2632
    .line 2633
    .line 2634
    .line 2635
    .line 2636
    .line 2637
    .line 2638
    .line 2639
    .line 2640
    .line 2641
    .line 2642
    .line 2643
    .line 2644
    .line 2645
    .line 2646
    .line 2647
    .line 2648
    .line 2649
    .line 2650
    .line 2651
    .line 2652
    .line 2653
    .line 2654
    .line 2655
    .line 2656
    .line 2657
    .line 2658
    .line 2659
    .line 2660
    .line 2661
    .line 2662
    .line 2663
    .line 2664
    .line 2665
    .line 2666
    .line 2667
    .line 2668
    .line 2669
    .line 2670
    .line 2671
    .line 2672
    .line 2673
    .line 2674
    .line 2675
    .line 2676
    .line 2677
    .line 2678
    .line 2679
    .line 2680
    .line 2681
    .line 2682
    .line 2683
    .line 2684
    .line 2685
    .line 2686
    .line 2687
    .line 2688
    .line 2689
    .line 2690
    .line 2691
    .line 2692
    .line 2693
    .line 2694
    .line 2695
    .line 2696
    .line 2697
    .line 2698
    .line 2699
    .line 2700
    .line 2701
    .line 2702
    .line 2703
    .line 2704
    .line 2705
    .line 2706
    .line 2707
    .line 2708
    .line 2709
    .line 2710
    .line 2711
    .line 2712
    .line 2713
    .line 2714
    .line 2715
    .line 2716
    .line 2717
    .line 2718
    .line 2719
    .line 2720
    .line 2721
    .line 2722
    .line 2723
    .line 2724
    .line 2725
    .line 2726
    .line 2727
    .line 2728
    .line 2729
    .line 2730
    .line 2731
    .line 2732
    .line 2733
    .line 2734
    .line 2735
    .line 2736
    .line 2737
    .line 2738
    .line 2739
    .line 2740
    .line 2741
    .line 2742
    .line 2743
    .line 2744
    .line 2745
    .line 2746
    .line 2747
    .line 2748
    .line 2749
    .line 2750
    .line 2751
    .line 2752
    .line 2753
    .line 2754
    .line 2755
    .line 2756
    .line 2757
    .line 2758
    .line 2759
    .line 2760
    .line 2761
    .line 2762
    .line 2763
    .line 2764
    .line 2765
    .line 2766
    .line 2767
    .line 2768
    .line 2769
    .line 2770
    .line 2771
    .line 2772
    .line 2773
    .line 2774
    .line 2775
    .line 2776
    .line 2777
    .line 2778
    .line 2779
    .line 2780
    .line 2781
    .line 2782
    .line 2783
    .line 2784
    .line 2785
    .line 2786
    .line 2787
    .line 2788
    .line 2789
    .line 2790
    .line 2791
    .line 2792
    .line 2793
    .line 2794
    .line 2795
    .line 2796
    .line 2797
    .line 2798
    .line 2799
    .line 2800
    .line 2801
    .line 2802
    .line 2803
    .line 2804
    .line 2805
    .line 2806
    .line 2807
    .line 2808
    .line 2809
    .line 2810
    .line 2811
    .line 2812
    .line 2813
    .line 2814
    .line 2815
    .line 2816
    .line 2817
    .line 2818
    .line 2819
    .line 2820
    .line 2821
    .line 2822
    .line 2823
    .line 2824
    .line 2825
    .line 2826
    .line 2827
    .line 2828
    .line 2829
    .line 2830
    .line 2831
    .line 2832
    .line 2833
    .line 2834
    .line 2835
    .line 2836
    .line 2837
    .line 2838
    .line 2839
    .line 2840
    .line 2841
    .line 2842
    .line 2843
    .line 2844
    .line 2845
    .line 2846
    .line 2847
    .line 2848
    .line 2849
    .line 2850
    .line 2851
    .line 2852
.end method


# virtual methods
.method public final inflate(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/util/AttributeSet;I)Landroidx/navigation/NavDestination;
    .locals 28

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p3

    move/from16 v3, p4

    .line 17
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "getName(...)"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object v5, v0, Landroidx/navigation/NavInflater;->navigatorProvider:Landroidx/navigation/NavigatorProvider;

    invoke-virtual {v5, v4}, Landroidx/navigation/NavigatorProvider;->getNavigator(Ljava/lang/String;)Landroidx/navigation/Navigator;

    move-result-object v4

    .line 18
    invoke-virtual {v4}, Landroidx/navigation/Navigator;->createDestination()Landroidx/navigation/NavDestination;

    move-result-object v4

    .line 19
    iget-object v5, v0, Landroidx/navigation/NavInflater;->context:Landroid/content/Context;

    invoke-virtual {v4, v5, v2}, Landroidx/navigation/NavDestination;->onInflate(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iget-object v6, v4, Landroidx/navigation/NavDestination;->impl:Landroidx/navigation/internal/NavDestinationImpl;

    .line 20
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v7

    const/4 v8, 0x1

    add-int/2addr v7, v8

    .line 21
    :goto_0
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v9

    if-eq v9, v8, :cond_1e

    .line 22
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v10

    const/4 v11, 0x3

    if-ge v10, v7, :cond_0

    if-eq v9, v11, :cond_1e

    :cond_0
    const/4 v12, 0x2

    if-eq v9, v12, :cond_1

    goto :goto_0

    :cond_1
    if-le v10, v7, :cond_2

    goto :goto_0

    .line 23
    :cond_2
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v9

    .line 24
    const-string v10, "argument"

    invoke-virtual {v10, v9}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v13

    .line 25
    const-string v14, "Arguments must have a name"

    sget-object v15, Landroidx/navigation/common/R$styleable;->NavArgument:[I

    const/4 v12, 0x0

    const-string v8, "obtainAttributes(...)"

    if-eqz v13, :cond_4

    .line 26
    invoke-virtual {v1, v2, v15}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v9

    invoke-static {v9, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    invoke-virtual {v9, v12}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_3

    .line 28
    invoke-static {v9, v1, v3}, Landroidx/navigation/NavInflater;->inflateArgument(Landroid/content/res/TypedArray;Landroid/content/res/Resources;I)Landroidx/navigation/NavArgument;

    move-result-object v10

    .line 29
    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 30
    iget-object v11, v6, Landroidx/navigation/internal/NavDestinationImpl;->arguments:Ljava/lang/Object;

    check-cast v11, Ljava/util/LinkedHashMap;

    invoke-interface {v11, v8, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    invoke-virtual {v9}, Landroid/content/res/TypedArray;->recycle()V

    :goto_1
    const/4 v8, 0x1

    goto :goto_0

    .line 32
    :cond_3
    new-instance v1, Lorg/xmlpull/v1/XmlPullParserException;

    invoke-direct {v1, v14}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 33
    :cond_4
    const-string v13, "deepLink"

    .line 34
    invoke-virtual {v13, v9}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_f

    .line 35
    sget-object v9, Landroidx/navigation/common/R$styleable;->NavDeepLink:[I

    invoke-virtual {v1, v2, v9}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v9

    invoke-static {v9, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 36
    invoke-virtual {v9, v11}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x1

    .line 37
    invoke-virtual {v9, v10}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v11

    const/4 v10, 0x2

    .line 38
    invoke-virtual {v9, v10}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v10

    if-eqz v8, :cond_5

    .line 39
    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v12

    if-nez v12, :cond_7

    :cond_5
    if-eqz v11, :cond_6

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v12

    if-nez v12, :cond_7

    :cond_6
    if-eqz v10, :cond_e

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v12

    if-eqz v12, :cond_e

    .line 40
    :cond_7
    const-string v12, "${applicationId}"

    const-string v13, "getPackageName(...)"

    const/4 v14, 0x0

    if-eqz v8, :cond_8

    .line 41
    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15, v13}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v8, v12, v15}, Lkotlin/text/StringsKt__StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    goto :goto_2

    :cond_8
    move-object v8, v14

    :goto_2
    if-eqz v11, :cond_b

    .line 42
    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v15

    if-nez v15, :cond_9

    goto :goto_3

    .line 43
    :cond_9
    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15, v13}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v11, v12, v15}, Lkotlin/text/StringsKt__StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 44
    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v15

    if-lez v15, :cond_a

    goto :goto_4

    :cond_a
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "The NavDeepLink cannot have an empty action."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_b
    :goto_3
    move-object v11, v14

    :goto_4
    if-eqz v10, :cond_c

    .line 45
    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14, v13}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v10, v12, v14}, Lkotlin/text/StringsKt__StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 46
    :cond_c
    new-instance v10, Landroidx/navigation/NavDeepLink;

    invoke-direct {v10, v8, v11, v14}, Landroidx/navigation/NavDeepLink;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 48
    iget-object v11, v6, Landroidx/navigation/internal/NavDestinationImpl;->arguments:Ljava/lang/Object;

    check-cast v11, Ljava/util/LinkedHashMap;

    new-instance v12, Landroidx/navigation/internal/NavDestinationImpl$$ExternalSyntheticLambda0;

    const/4 v13, 0x0

    invoke-direct {v12, v10, v13}, Landroidx/navigation/internal/NavDestinationImpl$$ExternalSyntheticLambda0;-><init>(Landroidx/navigation/NavDeepLink;I)V

    invoke-static {v11, v12}, Landroidx/navigation/Navigation;->missingRequiredArguments(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/ArrayList;

    move-result-object v11

    .line 49
    invoke-virtual {v11}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v12

    if-eqz v12, :cond_d

    .line 50
    iget-object v8, v6, Landroidx/navigation/internal/NavDestinationImpl;->deepLinks:Ljava/lang/Object;

    check-cast v8, Ljava/util/ArrayList;

    invoke-virtual {v8, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 51
    invoke-virtual {v9}, Landroid/content/res/TypedArray;->recycle()V

    goto/16 :goto_1

    .line 52
    :cond_d
    const-string v1, "Deep link "

    const-string v2, " can\'t be used to open destination "

    .line 53
    invoke-static {v1, v8, v2}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 54
    iget-object v2, v6, Landroidx/navigation/internal/NavDestinationImpl;->destination:Ljava/lang/Object;

    check-cast v2, Landroidx/navigation/NavDestination;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, ".\nFollowing required arguments are missing: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 55
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 56
    :cond_e
    new-instance v1, Lorg/xmlpull/v1/XmlPullParserException;

    .line 57
    const-string v2, "Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType"

    .line 58
    invoke-direct {v1, v2}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 59
    :cond_f
    const-string v13, "action"

    .line 60
    invoke-virtual {v13, v9}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_1c

    .line 61
    sget-object v9, Landroidx/navigation/common/R$styleable;->NavAction:[I

    .line 62
    invoke-virtual {v5, v2, v9, v12, v12}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v9

    .line 63
    invoke-virtual {v9, v12, v12}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v13

    move-object/from16 v17, v5

    const/4 v11, 0x1

    .line 64
    invoke-virtual {v9, v11, v12}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v5

    .line 65
    new-instance v11, Landroidx/navigation/NavAction;

    invoke-direct {v11, v5}, Landroidx/navigation/NavAction;-><init>(I)V

    const/4 v5, 0x4

    .line 66
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v19

    const/16 v5, 0xa

    .line 67
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v20

    const/4 v5, 0x7

    const/4 v12, -0x1

    .line 68
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v21

    const/16 v5, 0x8

    const/4 v12, 0x0

    .line 69
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v22

    const/16 v5, 0x9

    .line 70
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v23

    const/4 v5, 0x2

    const/4 v12, -0x1

    .line 71
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v24

    const/4 v5, 0x3

    .line 72
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v25

    const/4 v5, 0x5

    .line 73
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v26

    const/4 v5, 0x6

    .line 74
    invoke-virtual {v9, v5, v12}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v27

    .line 75
    new-instance v18, Landroidx/navigation/NavOptions;

    invoke-direct/range {v18 .. v27}, Landroidx/navigation/NavOptions;-><init>(ZZIZZIIII)V

    move-object/from16 v5, v18

    .line 76
    iput-object v5, v11, Landroidx/navigation/NavAction;->navOptions:Landroidx/navigation/NavOptions;

    const/4 v12, 0x0

    .line 77
    new-array v5, v12, [Lkotlin/Pair;

    .line 78
    invoke-static {v5, v12}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Lkotlin/Pair;

    invoke-static {v5}, Landroidx/core/os/BundleKt;->bundleOf([Lkotlin/Pair;)Landroid/os/Bundle;

    move-result-object v5

    .line 79
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v12

    move-object/from16 v18, v6

    const/4 v6, 0x1

    add-int/2addr v12, v6

    move/from16 v16, v7

    .line 80
    :goto_5
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v7

    if-eq v7, v6, :cond_16

    .line 81
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v6

    move-object/from16 v20, v9

    if-ge v6, v12, :cond_10

    const/4 v9, 0x3

    if-eq v7, v9, :cond_17

    :cond_10
    const/4 v9, 0x2

    if-eq v7, v9, :cond_11

    :goto_6
    move-object/from16 v9, v20

    const/4 v6, 0x1

    goto :goto_5

    :cond_11
    if-le v6, v12, :cond_12

    goto :goto_6

    .line 82
    :cond_12
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    .line 83
    invoke-virtual {v10, v6}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_14

    .line 84
    invoke-virtual {v1, v2, v15}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v6

    invoke-static {v6, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v7, 0x0

    .line 85
    invoke-virtual {v6, v7}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v9

    if-eqz v9, :cond_15

    .line 86
    invoke-static {v6, v1, v3}, Landroidx/navigation/NavInflater;->inflateArgument(Landroid/content/res/TypedArray;Landroid/content/res/Resources;I)Landroidx/navigation/NavArgument;

    move-result-object v7

    iget-boolean v3, v7, Landroidx/navigation/NavArgument;->isDefaultValuePresent:Z

    if-eqz v3, :cond_13

    if-eqz v3, :cond_13

    .line 87
    iget-object v3, v7, Landroidx/navigation/NavArgument;->defaultValue:Ljava/lang/Object;

    if-eqz v3, :cond_13

    .line 88
    iget-object v7, v7, Landroidx/navigation/NavArgument;->type:Landroidx/navigation/NavType;

    invoke-virtual {v7, v5, v9, v3}, Landroidx/navigation/NavType;->put(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V

    .line 89
    :cond_13
    invoke-virtual {v6}, Landroid/content/res/TypedArray;->recycle()V

    :cond_14
    move/from16 v3, p4

    goto :goto_6

    .line 90
    :cond_15
    new-instance v1, Lorg/xmlpull/v1/XmlPullParserException;

    invoke-direct {v1, v14}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_16
    move-object/from16 v20, v9

    .line 91
    :cond_17
    invoke-virtual {v5}, Landroid/os/BaseBundle;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_18

    .line 92
    iput-object v5, v11, Landroidx/navigation/NavAction;->defaultArguments:Landroid/os/Bundle;

    .line 93
    :cond_18
    instance-of v3, v4, Landroidx/navigation/ActivityNavigator$Destination;

    if-nez v3, :cond_1b

    if-eqz v13, :cond_1a

    .line 94
    iget-object v3, v4, Landroidx/navigation/NavDestination;->actions:Landroidx/collection/SparseArrayCompat;

    invoke-virtual {v3, v13, v11}, Landroidx/collection/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 95
    invoke-virtual/range {v20 .. v20}, Landroid/content/res/TypedArray;->recycle()V

    :cond_19
    :goto_7
    move/from16 v3, p4

    move/from16 v7, v16

    move-object/from16 v5, v17

    move-object/from16 v6, v18

    goto/16 :goto_1

    .line 96
    :cond_1a
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Cannot have an action with actionId 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 97
    :cond_1b
    new-instance v1, Ljava/lang/UnsupportedOperationException;

    .line 98
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Cannot add action "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, " to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v3, " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 99
    invoke-direct {v1, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1c
    move-object/from16 v17, v5

    move-object/from16 v18, v6

    move/from16 v16, v7

    .line 100
    const-string v3, "include"

    .line 101
    invoke-virtual {v3, v9}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1d

    .line 102
    instance-of v3, v4, Landroidx/navigation/NavGraph;

    if-eqz v3, :cond_1d

    .line 103
    sget-object v3, Landroidx/navigation/R$styleable;->NavInclude:[I

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v3

    invoke-static {v3, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v12, 0x0

    .line 104
    invoke-virtual {v3, v12, v12}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v5

    .line 105
    move-object v6, v4

    check-cast v6, Landroidx/navigation/NavGraph;

    invoke-virtual {v0, v5}, Landroidx/navigation/NavInflater;->inflate(I)Landroidx/navigation/NavGraph;

    move-result-object v5

    invoke-virtual {v6, v5}, Landroidx/navigation/NavGraph;->addDestination(Landroidx/navigation/NavDestination;)V

    .line 106
    invoke-virtual {v3}, Landroid/content/res/TypedArray;->recycle()V

    goto :goto_7

    .line 107
    :cond_1d
    instance-of v3, v4, Landroidx/navigation/NavGraph;

    if-eqz v3, :cond_19

    .line 108
    move-object v3, v4

    check-cast v3, Landroidx/navigation/NavGraph;

    invoke-virtual/range {p0 .. p4}, Landroidx/navigation/NavInflater;->inflate(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/util/AttributeSet;I)Landroidx/navigation/NavDestination;

    move-result-object v5

    invoke-virtual {v3, v5}, Landroidx/navigation/NavGraph;->addDestination(Landroidx/navigation/NavDestination;)V

    goto :goto_7

    :cond_1e
    return-object v4
.end method

.method public final inflate(I)Landroidx/navigation/NavGraph;
    .locals 6

    .line 1
    iget-object v0, p0, Landroidx/navigation/NavInflater;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 2
    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v1

    const-string v2, "getXml(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 3
    invoke-static {v1}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    move-result-object v2

    .line 4
    :cond_0
    :try_start_0
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v3

    const/4 v4, 0x2

    if-eq v3, v4, :cond_1

    const/4 v5, 0x1

    if-ne v3, v5, :cond_0

    :cond_1
    if-ne v3, v4, :cond_3

    .line 5
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 6
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {p0, v0, v1, v2, p1}, Landroidx/navigation/NavInflater;->inflate(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/util/AttributeSet;I)Landroidx/navigation/NavDestination;

    move-result-object v2

    .line 7
    instance-of v4, v2, Landroidx/navigation/NavGraph;

    if-eqz v4, :cond_2

    .line 8
    check-cast v2, Landroidx/navigation/NavGraph;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 9
    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->close()V

    return-object v2

    :catchall_0
    move-exception p1

    goto :goto_1

    :catch_0
    move-exception v2

    goto :goto_0

    .line 10
    :cond_2
    :try_start_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Root element <"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "> did not inflate into a NavGraph"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 11
    new-instance v3, Ljava/lang/IllegalArgumentException;

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v3, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 12
    :cond_3
    new-instance v2, Lorg/xmlpull/v1/XmlPullParserException;

    const-string v3, "No start tag found"

    invoke-direct {v2, v3}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 13
    :goto_0
    :try_start_2
    new-instance v3, Ljava/lang/RuntimeException;

    .line 14
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception inflating "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " line "

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->getLineNumber()I

    move-result p1

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 15
    invoke-direct {v3, p1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 16
    :goto_1
    invoke-interface {v1}, Landroid/content/res/XmlResourceParser;->close()V

    throw p1
.end method
