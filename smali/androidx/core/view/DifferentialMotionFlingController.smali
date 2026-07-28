.class public final Landroidx/core/view/DifferentialMotionFlingController;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final mContext:Landroid/content/Context;

.field public final mFlingVelocityThresholds:[I

.field public mLastFlingVelocity:F

.field public mLastProcessedAxis:I

.field public mLastProcessedDeviceId:I

.field public mLastProcessedSource:I

.field public final mTarget:Landroidx/core/view/DifferentialMotionFlingTarget;

.field public mVelocityTracker:Landroid/view/VelocityTracker;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroidx/core/view/DifferentialMotionFlingTarget;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, -0x1

    .line 5
    iput v0, p0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedAxis:I

    .line 6
    .line 7
    iput v0, p0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedSource:I

    .line 8
    .line 9
    iput v0, p0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedDeviceId:I

    .line 10
    .line 11
    const v0, 0x7fffffff

    .line 12
    .line 13
    .line 14
    const/4 v1, 0x0

    .line 15
    filled-new-array {v0, v1}, [I

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    iput-object v0, p0, Landroidx/core/view/DifferentialMotionFlingController;->mFlingVelocityThresholds:[I

    .line 20
    .line 21
    iput-object p1, p0, Landroidx/core/view/DifferentialMotionFlingController;->mContext:Landroid/content/Context;

    .line 22
    .line 23
    iput-object p2, p0, Landroidx/core/view/DifferentialMotionFlingController;->mTarget:Landroidx/core/view/DifferentialMotionFlingTarget;

    .line 24
    .line 25
    return-void
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


# virtual methods
.method public final onMotionEvent(Landroid/view/MotionEvent;I)V
    .locals 27

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    move/from16 v2, p2

    .line 6
    .line 7
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getSource()I

    .line 8
    .line 9
    .line 10
    move-result v3

    .line 11
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getDeviceId()I

    .line 12
    .line 13
    .line 14
    move-result v4

    .line 15
    iget v5, v0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedSource:I

    .line 16
    .line 17
    const/16 v6, 0x22

    .line 18
    .line 19
    const/high16 v8, 0x400000

    .line 20
    .line 21
    iget-object v10, v0, Landroidx/core/view/DifferentialMotionFlingController;->mFlingVelocityThresholds:[I

    .line 22
    .line 23
    if-ne v5, v3, :cond_1

    .line 24
    .line 25
    iget v5, v0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedDeviceId:I

    .line 26
    .line 27
    if-ne v5, v4, :cond_1

    .line 28
    .line 29
    iget v5, v0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedAxis:I

    .line 30
    .line 31
    if-eq v5, v2, :cond_0

    .line 32
    .line 33
    goto :goto_0

    .line 34
    :cond_0
    const/4 v12, 0x0

    .line 35
    const/16 v16, 0x1

    .line 36
    .line 37
    const/16 v17, 0x0

    .line 38
    .line 39
    goto/16 :goto_7

    .line 40
    .line 41
    :cond_1
    :goto_0
    iget-object v5, v0, Landroidx/core/view/DifferentialMotionFlingController;->mContext:Landroid/content/Context;

    .line 42
    .line 43
    invoke-static {v5}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    .line 44
    .line 45
    .line 46
    move-result-object v13

    .line 47
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getDeviceId()I

    .line 48
    .line 49
    .line 50
    move-result v14

    .line 51
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getSource()I

    .line 52
    .line 53
    .line 54
    move-result v15

    .line 55
    const/16 v16, 0x1

    .line 56
    .line 57
    sget v11, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 58
    .line 59
    const/16 v17, 0x0

    .line 60
    .line 61
    const-string v12, "android"

    .line 62
    .line 63
    const-string v7, "dimen"

    .line 64
    .line 65
    const/4 v9, -0x1

    .line 66
    if-lt v11, v6, :cond_2

    .line 67
    .line 68
    sget-object v19, Landroidx/core/view/ViewConfigurationCompat;->sGetScaledScrollFactorMethod:Ljava/lang/reflect/Method;

    .line 69
    .line 70
    invoke-static {v13, v14, v2, v15}, Landroidx/core/view/ViewConfigurationCompat$Api34Impl;->getScaledMinimumFlingVelocity(Landroid/view/ViewConfiguration;III)I

    .line 71
    .line 72
    .line 73
    move-result v14

    .line 74
    goto :goto_3

    .line 75
    :cond_2
    sget-object v19, Landroidx/core/view/ViewConfigurationCompat;->sGetScaledScrollFactorMethod:Ljava/lang/reflect/Method;

    .line 76
    .line 77
    invoke-static {v14}, Landroid/view/InputDevice;->getDevice(I)Landroid/view/InputDevice;

    .line 78
    .line 79
    .line 80
    move-result-object v14

    .line 81
    if-eqz v14, :cond_5

    .line 82
    .line 83
    invoke-virtual {v14, v2, v15}, Landroid/view/InputDevice;->getMotionRange(II)Landroid/view/InputDevice$MotionRange;

    .line 84
    .line 85
    .line 86
    move-result-object v14

    .line 87
    if-eqz v14, :cond_5

    .line 88
    .line 89
    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 90
    .line 91
    .line 92
    move-result-object v14

    .line 93
    if-ne v15, v8, :cond_3

    .line 94
    .line 95
    const/16 v15, 0x1a

    .line 96
    .line 97
    if-ne v2, v15, :cond_3

    .line 98
    .line 99
    const-string v15, "config_viewMinRotaryEncoderFlingVelocity"

    .line 100
    .line 101
    invoke-virtual {v14, v15, v7, v12}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    .line 102
    .line 103
    .line 104
    move-result v15

    .line 105
    goto :goto_1

    .line 106
    :cond_3
    const/4 v15, -0x1

    .line 107
    :goto_1
    invoke-static {v13}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 108
    .line 109
    .line 110
    if-eq v15, v9, :cond_4

    .line 111
    .line 112
    if-eqz v15, :cond_5

    .line 113
    .line 114
    invoke-virtual {v14, v15}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 115
    .line 116
    .line 117
    move-result v14

    .line 118
    if-gez v14, :cond_6

    .line 119
    .line 120
    goto :goto_2

    .line 121
    :cond_4
    invoke-virtual {v13}, Landroid/view/ViewConfiguration;->getScaledMinimumFlingVelocity()I

    .line 122
    .line 123
    .line 124
    move-result v14

    .line 125
    goto :goto_3

    .line 126
    :cond_5
    :goto_2
    const v14, 0x7fffffff

    .line 127
    .line 128
    .line 129
    :cond_6
    :goto_3
    aput v14, v10, v17

    .line 130
    .line 131
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getDeviceId()I

    .line 132
    .line 133
    .line 134
    move-result v14

    .line 135
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getSource()I

    .line 136
    .line 137
    .line 138
    move-result v15

    .line 139
    if-lt v11, v6, :cond_7

    .line 140
    .line 141
    invoke-static {v13, v14, v2, v15}, Landroidx/core/view/ViewConfigurationCompat$Api34Impl;->getScaledMaximumFlingVelocity(Landroid/view/ViewConfiguration;III)I

    .line 142
    .line 143
    .line 144
    move-result v5

    .line 145
    goto :goto_6

    .line 146
    :cond_7
    invoke-static {v14}, Landroid/view/InputDevice;->getDevice(I)Landroid/view/InputDevice;

    .line 147
    .line 148
    .line 149
    move-result-object v11

    .line 150
    const/high16 v14, -0x80000000

    .line 151
    .line 152
    if-eqz v11, :cond_a

    .line 153
    .line 154
    invoke-virtual {v11, v2, v15}, Landroid/view/InputDevice;->getMotionRange(II)Landroid/view/InputDevice$MotionRange;

    .line 155
    .line 156
    .line 157
    move-result-object v11

    .line 158
    if-eqz v11, :cond_a

    .line 159
    .line 160
    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 161
    .line 162
    .line 163
    move-result-object v5

    .line 164
    if-ne v15, v8, :cond_8

    .line 165
    .line 166
    const/16 v15, 0x1a

    .line 167
    .line 168
    if-ne v2, v15, :cond_8

    .line 169
    .line 170
    const-string v11, "config_viewMaxRotaryEncoderFlingVelocity"

    .line 171
    .line 172
    invoke-virtual {v5, v11, v7, v12}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    .line 173
    .line 174
    .line 175
    move-result v7

    .line 176
    goto :goto_4

    .line 177
    :cond_8
    const/4 v7, -0x1

    .line 178
    :goto_4
    invoke-static {v13}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    .line 180
    .line 181
    if-eq v7, v9, :cond_9

    .line 182
    .line 183
    if-eqz v7, :cond_a

    .line 184
    .line 185
    invoke-virtual {v5, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 186
    .line 187
    .line 188
    move-result v5

    .line 189
    if-gez v5, :cond_b

    .line 190
    .line 191
    goto :goto_5

    .line 192
    :cond_9
    invoke-virtual {v13}, Landroid/view/ViewConfiguration;->getScaledMaximumFlingVelocity()I

    .line 193
    .line 194
    .line 195
    move-result v5

    .line 196
    goto :goto_6

    .line 197
    :cond_a
    :goto_5
    const/high16 v5, -0x80000000

    .line 198
    .line 199
    :cond_b
    :goto_6
    aput v5, v10, v16

    .line 200
    .line 201
    iput v3, v0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedSource:I

    .line 202
    .line 203
    iput v4, v0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedDeviceId:I

    .line 204
    .line 205
    iput v2, v0, Landroidx/core/view/DifferentialMotionFlingController;->mLastProcessedAxis:I

    .line 206
    .line 207
    const/4 v12, 0x1

    .line 208
    :goto_7
    aget v3, v10, v17

    .line 209
    .line 210
    const v4, 0x7fffffff

    .line 211
    .line 212
    .line 213
    if-ne v3, v4, :cond_c

    .line 214
    .line 215
    iget-object v1, v0, Landroidx/core/view/DifferentialMotionFlingController;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 216
    .line 217
    if-eqz v1, :cond_27

    .line 218
    .line 219
    invoke-virtual {v1}, Landroid/view/VelocityTracker;->recycle()V

    .line 220
    .line 221
    .line 222
    const/4 v1, 0x0

    .line 223
    iput-object v1, v0, Landroidx/core/view/DifferentialMotionFlingController;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 224
    .line 225
    return-void

    .line 226
    :cond_c
    iget-object v3, v0, Landroidx/core/view/DifferentialMotionFlingController;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 227
    .line 228
    if-nez v3, :cond_d

    .line 229
    .line 230
    invoke-static {}, Landroid/view/VelocityTracker;->obtain()Landroid/view/VelocityTracker;

    .line 231
    .line 232
    .line 233
    move-result-object v3

    .line 234
    iput-object v3, v0, Landroidx/core/view/DifferentialMotionFlingController;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 235
    .line 236
    :cond_d
    iget-object v3, v0, Landroidx/core/view/DifferentialMotionFlingController;->mVelocityTracker:Landroid/view/VelocityTracker;

    .line 237
    .line 238
    sget-object v4, Landroidx/core/view/VelocityTrackerCompat;->sFallbackTrackers:Ljava/util/Map;

    .line 239
    .line 240
    invoke-virtual {v3, v1}, Landroid/view/VelocityTracker;->addMovement(Landroid/view/MotionEvent;)V

    .line 241
    .line 242
    .line 243
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 244
    .line 245
    const/4 v5, 0x0

    .line 246
    const/16 v7, 0x14

    .line 247
    .line 248
    if-lt v4, v6, :cond_e

    .line 249
    .line 250
    goto :goto_8

    .line 251
    :cond_e
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getSource()I

    .line 252
    .line 253
    .line 254
    move-result v4

    .line 255
    if-ne v4, v8, :cond_12

    .line 256
    .line 257
    sget-object v4, Landroidx/core/view/VelocityTrackerCompat;->sFallbackTrackers:Ljava/util/Map;

    .line 258
    .line 259
    invoke-interface {v4, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    .line 260
    .line 261
    .line 262
    move-result v8

    .line 263
    if-nez v8, :cond_f

    .line 264
    .line 265
    new-instance v8, Landroidx/core/view/VelocityTrackerFallback;

    .line 266
    .line 267
    invoke-direct {v8}, Landroidx/core/view/VelocityTrackerFallback;-><init>()V

    .line 268
    .line 269
    .line 270
    invoke-interface {v4, v3, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 271
    .line 272
    .line 273
    :cond_f
    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 274
    .line 275
    .line 276
    move-result-object v4

    .line 277
    check-cast v4, Landroidx/core/view/VelocityTrackerFallback;

    .line 278
    .line 279
    iget-object v8, v4, Landroidx/core/view/VelocityTrackerFallback;->mEventTimes:[J

    .line 280
    .line 281
    invoke-virtual {v1}, Landroid/view/MotionEvent;->getEventTime()J

    .line 282
    .line 283
    .line 284
    move-result-wide v13

    .line 285
    iget v9, v4, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 286
    .line 287
    if-eqz v9, :cond_10

    .line 288
    .line 289
    iget v9, v4, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferLastUsedIndex:I

    .line 290
    .line 291
    aget-wide v19, v8, v9

    .line 292
    .line 293
    sub-long v19, v13, v19

    .line 294
    .line 295
    const-wide/16 v21, 0x28

    .line 296
    .line 297
    cmp-long v9, v19, v21

    .line 298
    .line 299
    if-lez v9, :cond_10

    .line 300
    .line 301
    const/4 v9, 0x0

    .line 302
    iput v9, v4, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 303
    .line 304
    iput v5, v4, Landroidx/core/view/VelocityTrackerFallback;->mLastComputedVelocity:F

    .line 305
    .line 306
    :cond_10
    iget v9, v4, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferLastUsedIndex:I

    .line 307
    .line 308
    add-int/lit8 v9, v9, 0x1

    .line 309
    .line 310
    rem-int/2addr v9, v7

    .line 311
    iput v9, v4, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferLastUsedIndex:I

    .line 312
    .line 313
    iget v11, v4, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 314
    .line 315
    if-eq v11, v7, :cond_11

    .line 316
    .line 317
    add-int/lit8 v11, v11, 0x1

    .line 318
    .line 319
    iput v11, v4, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 320
    .line 321
    :cond_11
    iget-object v11, v4, Landroidx/core/view/VelocityTrackerFallback;->mMovements:[F

    .line 322
    .line 323
    const/16 v15, 0x1a

    .line 324
    .line 325
    invoke-virtual {v1, v15}, Landroid/view/MotionEvent;->getAxisValue(I)F

    .line 326
    .line 327
    .line 328
    move-result v1

    .line 329
    aput v1, v11, v9

    .line 330
    .line 331
    iget v1, v4, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferLastUsedIndex:I

    .line 332
    .line 333
    aput-wide v13, v8, v1

    .line 334
    .line 335
    :cond_12
    :goto_8
    const/16 v1, 0x3e8

    .line 336
    .line 337
    const v4, 0x7f7fffff    # Float.MAX_VALUE

    .line 338
    .line 339
    .line 340
    invoke-virtual {v3, v1, v4}, Landroid/view/VelocityTracker;->computeCurrentVelocity(IF)V

    .line 341
    .line 342
    .line 343
    sget-object v8, Landroidx/core/view/VelocityTrackerCompat;->sFallbackTrackers:Ljava/util/Map;

    .line 344
    .line 345
    invoke-interface {v8, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 346
    .line 347
    .line 348
    move-result-object v8

    .line 349
    check-cast v8, Landroidx/core/view/VelocityTrackerFallback;

    .line 350
    .line 351
    if-eqz v8, :cond_1e

    .line 352
    .line 353
    iget-object v9, v8, Landroidx/core/view/VelocityTrackerFallback;->mMovements:[F

    .line 354
    .line 355
    iget-object v11, v8, Landroidx/core/view/VelocityTrackerFallback;->mEventTimes:[J

    .line 356
    .line 357
    iget v13, v8, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 358
    .line 359
    const/4 v14, 0x2

    .line 360
    if-ge v13, v14, :cond_13

    .line 361
    .line 362
    :goto_9
    const p1, 0x7f7fffff    # Float.MAX_VALUE

    .line 363
    .line 364
    .line 365
    const/4 v7, 0x0

    .line 366
    :goto_a
    const/16 v24, 0x0

    .line 367
    .line 368
    goto/16 :goto_e

    .line 369
    .line 370
    :cond_13
    iget v15, v8, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferLastUsedIndex:I

    .line 371
    .line 372
    add-int/lit8 v18, v15, 0x14

    .line 373
    .line 374
    add-int/lit8 v13, v13, -0x1

    .line 375
    .line 376
    sub-int v18, v18, v13

    .line 377
    .line 378
    rem-int/lit8 v18, v18, 0x14

    .line 379
    .line 380
    aget-wide v19, v11, v15

    .line 381
    .line 382
    :goto_b
    aget-wide v21, v11, v18

    .line 383
    .line 384
    sub-long v23, v19, v21

    .line 385
    .line 386
    const-wide/16 v25, 0x64

    .line 387
    .line 388
    cmp-long v13, v23, v25

    .line 389
    .line 390
    if-lez v13, :cond_14

    .line 391
    .line 392
    iget v13, v8, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 393
    .line 394
    add-int/lit8 v13, v13, -0x1

    .line 395
    .line 396
    iput v13, v8, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 397
    .line 398
    add-int/lit8 v18, v18, 0x1

    .line 399
    .line 400
    rem-int/lit8 v18, v18, 0x14

    .line 401
    .line 402
    goto :goto_b

    .line 403
    :cond_14
    iget v13, v8, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 404
    .line 405
    if-ge v13, v14, :cond_15

    .line 406
    .line 407
    goto :goto_9

    .line 408
    :cond_15
    if-ne v13, v14, :cond_17

    .line 409
    .line 410
    add-int/lit8 v18, v18, 0x1

    .line 411
    .line 412
    rem-int/lit8 v18, v18, 0x14

    .line 413
    .line 414
    aget-wide v13, v11, v18

    .line 415
    .line 416
    cmp-long v7, v21, v13

    .line 417
    .line 418
    if-nez v7, :cond_16

    .line 419
    .line 420
    goto :goto_9

    .line 421
    :cond_16
    aget v7, v9, v18

    .line 422
    .line 423
    sub-long v13, v13, v21

    .line 424
    .line 425
    long-to-float v9, v13

    .line 426
    div-float/2addr v7, v9

    .line 427
    const p1, 0x7f7fffff    # Float.MAX_VALUE

    .line 428
    .line 429
    .line 430
    goto :goto_a

    .line 431
    :cond_17
    const p1, 0x7f7fffff    # Float.MAX_VALUE

    .line 432
    .line 433
    .line 434
    const/4 v13, 0x0

    .line 435
    const/4 v14, 0x0

    .line 436
    const/4 v15, 0x0

    .line 437
    :goto_c
    iget v4, v8, Landroidx/core/view/VelocityTrackerFallback;->mDataPointsBufferSize:I

    .line 438
    .line 439
    add-int/lit8 v4, v4, -0x1

    .line 440
    .line 441
    const/high16 v19, 0x40000000    # 2.0f

    .line 442
    .line 443
    const/high16 v20, 0x3f800000    # 1.0f

    .line 444
    .line 445
    const/high16 v21, -0x40800000    # -1.0f

    .line 446
    .line 447
    if-ge v13, v4, :cond_1b

    .line 448
    .line 449
    add-int v4, v13, v18

    .line 450
    .line 451
    rem-int/lit8 v22, v4, 0x14

    .line 452
    .line 453
    aget-wide v22, v11, v22

    .line 454
    .line 455
    add-int/lit8 v4, v4, 0x1

    .line 456
    .line 457
    rem-int/2addr v4, v7

    .line 458
    aget-wide v24, v11, v4

    .line 459
    .line 460
    cmp-long v26, v24, v22

    .line 461
    .line 462
    if-nez v26, :cond_18

    .line 463
    .line 464
    const/16 v24, 0x0

    .line 465
    .line 466
    goto :goto_d

    .line 467
    :cond_18
    add-int/lit8 v14, v14, 0x1

    .line 468
    .line 469
    cmpg-float v24, v15, v5

    .line 470
    .line 471
    if-gez v24, :cond_19

    .line 472
    .line 473
    const/high16 v20, -0x40800000    # -1.0f

    .line 474
    .line 475
    :cond_19
    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    .line 476
    .line 477
    .line 478
    move-result v21

    .line 479
    const/16 v24, 0x0

    .line 480
    .line 481
    mul-float v5, v21, v19

    .line 482
    .line 483
    float-to-double v6, v5

    .line 484
    invoke-static {v6, v7}, Ljava/lang/Math;->sqrt(D)D

    .line 485
    .line 486
    .line 487
    move-result-wide v5

    .line 488
    double-to-float v5, v5

    .line 489
    mul-float v20, v20, v5

    .line 490
    .line 491
    aget v5, v9, v4

    .line 492
    .line 493
    aget-wide v6, v11, v4

    .line 494
    .line 495
    sub-long v6, v6, v22

    .line 496
    .line 497
    long-to-float v4, v6

    .line 498
    div-float/2addr v5, v4

    .line 499
    sub-float v4, v5, v20

    .line 500
    .line 501
    invoke-static {v5}, Ljava/lang/Math;->abs(F)F

    .line 502
    .line 503
    .line 504
    move-result v5

    .line 505
    mul-float v5, v5, v4

    .line 506
    .line 507
    add-float/2addr v15, v5

    .line 508
    const/4 v4, 0x1

    .line 509
    if-ne v14, v4, :cond_1a

    .line 510
    .line 511
    const/high16 v4, 0x3f000000    # 0.5f

    .line 512
    .line 513
    mul-float v15, v15, v4

    .line 514
    .line 515
    :cond_1a
    :goto_d
    add-int/lit8 v13, v13, 0x1

    .line 516
    .line 517
    const/4 v5, 0x0

    .line 518
    const/16 v6, 0x22

    .line 519
    .line 520
    const/16 v7, 0x14

    .line 521
    .line 522
    const/16 v16, 0x1

    .line 523
    .line 524
    goto :goto_c

    .line 525
    :cond_1b
    const/16 v24, 0x0

    .line 526
    .line 527
    cmpg-float v4, v15, v24

    .line 528
    .line 529
    if-gez v4, :cond_1c

    .line 530
    .line 531
    const/high16 v20, -0x40800000    # -1.0f

    .line 532
    .line 533
    :cond_1c
    invoke-static {v15}, Ljava/lang/Math;->abs(F)F

    .line 534
    .line 535
    .line 536
    move-result v4

    .line 537
    mul-float v4, v4, v19

    .line 538
    .line 539
    float-to-double v4, v4

    .line 540
    invoke-static {v4, v5}, Ljava/lang/Math;->sqrt(D)D

    .line 541
    .line 542
    .line 543
    move-result-wide v4

    .line 544
    double-to-float v4, v4

    .line 545
    mul-float v7, v20, v4

    .line 546
    .line 547
    :goto_e
    int-to-float v1, v1

    .line 548
    mul-float v7, v7, v1

    .line 549
    .line 550
    iput v7, v8, Landroidx/core/view/VelocityTrackerFallback;->mLastComputedVelocity:F

    .line 551
    .line 552
    invoke-static/range {p1 .. p1}, Ljava/lang/Math;->abs(F)F

    .line 553
    .line 554
    .line 555
    move-result v1

    .line 556
    neg-float v1, v1

    .line 557
    cmpg-float v1, v7, v1

    .line 558
    .line 559
    if-gez v1, :cond_1d

    .line 560
    .line 561
    invoke-static/range {p1 .. p1}, Ljava/lang/Math;->abs(F)F

    .line 562
    .line 563
    .line 564
    move-result v1

    .line 565
    neg-float v1, v1

    .line 566
    iput v1, v8, Landroidx/core/view/VelocityTrackerFallback;->mLastComputedVelocity:F

    .line 567
    .line 568
    goto :goto_f

    .line 569
    :cond_1d
    iget v1, v8, Landroidx/core/view/VelocityTrackerFallback;->mLastComputedVelocity:F

    .line 570
    .line 571
    invoke-static/range {p1 .. p1}, Ljava/lang/Math;->abs(F)F

    .line 572
    .line 573
    .line 574
    move-result v4

    .line 575
    cmpl-float v1, v1, v4

    .line 576
    .line 577
    if-lez v1, :cond_1f

    .line 578
    .line 579
    invoke-static/range {p1 .. p1}, Ljava/lang/Math;->abs(F)F

    .line 580
    .line 581
    .line 582
    move-result v1

    .line 583
    iput v1, v8, Landroidx/core/view/VelocityTrackerFallback;->mLastComputedVelocity:F

    .line 584
    .line 585
    goto :goto_f

    .line 586
    :cond_1e
    const/16 v24, 0x0

    .line 587
    .line 588
    :cond_1f
    :goto_f
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 589
    .line 590
    const/16 v4, 0x22

    .line 591
    .line 592
    if-lt v1, v4, :cond_20

    .line 593
    .line 594
    invoke-static {v3, v2}, Landroidx/core/view/VelocityTrackerCompat$Api34Impl;->getAxisVelocity(Landroid/view/VelocityTracker;I)F

    .line 595
    .line 596
    .line 597
    move-result v1

    .line 598
    goto :goto_11

    .line 599
    :cond_20
    if-nez v2, :cond_21

    .line 600
    .line 601
    invoke-virtual {v3}, Landroid/view/VelocityTracker;->getXVelocity()F

    .line 602
    .line 603
    .line 604
    move-result v1

    .line 605
    goto :goto_11

    .line 606
    :cond_21
    const/4 v4, 0x1

    .line 607
    if-ne v2, v4, :cond_22

    .line 608
    .line 609
    invoke-virtual {v3}, Landroid/view/VelocityTracker;->getYVelocity()F

    .line 610
    .line 611
    .line 612
    move-result v1

    .line 613
    goto :goto_11

    .line 614
    :cond_22
    sget-object v1, Landroidx/core/view/VelocityTrackerCompat;->sFallbackTrackers:Ljava/util/Map;

    .line 615
    .line 616
    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 617
    .line 618
    .line 619
    move-result-object v1

    .line 620
    check-cast v1, Landroidx/core/view/VelocityTrackerFallback;

    .line 621
    .line 622
    if-eqz v1, :cond_24

    .line 623
    .line 624
    const/16 v15, 0x1a

    .line 625
    .line 626
    if-eq v2, v15, :cond_23

    .line 627
    .line 628
    goto :goto_10

    .line 629
    :cond_23
    iget v1, v1, Landroidx/core/view/VelocityTrackerFallback;->mLastComputedVelocity:F

    .line 630
    .line 631
    goto :goto_11

    .line 632
    :cond_24
    :goto_10
    const/4 v1, 0x0

    .line 633
    :goto_11
    iget-object v2, v0, Landroidx/core/view/DifferentialMotionFlingController;->mTarget:Landroidx/core/view/DifferentialMotionFlingTarget;

    .line 634
    .line 635
    invoke-interface {v2}, Landroidx/core/view/DifferentialMotionFlingTarget;->getScaledScrollFactor()F

    .line 636
    .line 637
    .line 638
    move-result v3

    .line 639
    mul-float v3, v3, v1

    .line 640
    .line 641
    invoke-static {v3}, Ljava/lang/Math;->signum(F)F

    .line 642
    .line 643
    .line 644
    move-result v1

    .line 645
    if-nez v12, :cond_25

    .line 646
    .line 647
    iget v4, v0, Landroidx/core/view/DifferentialMotionFlingController;->mLastFlingVelocity:F

    .line 648
    .line 649
    invoke-static {v4}, Ljava/lang/Math;->signum(F)F

    .line 650
    .line 651
    .line 652
    move-result v4

    .line 653
    cmpl-float v4, v1, v4

    .line 654
    .line 655
    if-eqz v4, :cond_26

    .line 656
    .line 657
    cmpl-float v1, v1, v24

    .line 658
    .line 659
    if-eqz v1, :cond_26

    .line 660
    .line 661
    :cond_25
    invoke-interface {v2}, Landroidx/core/view/DifferentialMotionFlingTarget;->stopDifferentialMotionFling()V

    .line 662
    .line 663
    .line 664
    :cond_26
    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    .line 665
    .line 666
    .line 667
    move-result v1

    .line 668
    const/16 v17, 0x0

    .line 669
    .line 670
    aget v4, v10, v17

    .line 671
    .line 672
    int-to-float v4, v4

    .line 673
    cmpg-float v1, v1, v4

    .line 674
    .line 675
    if-gez v1, :cond_28

    .line 676
    .line 677
    :cond_27
    return-void

    .line 678
    :cond_28
    const/16 v16, 0x1

    .line 679
    .line 680
    aget v1, v10, v16

    .line 681
    .line 682
    neg-int v4, v1

    .line 683
    int-to-float v4, v4

    .line 684
    int-to-float v1, v1

    .line 685
    invoke-static {v3, v1}, Ljava/lang/Math;->min(FF)F

    .line 686
    .line 687
    .line 688
    move-result v1

    .line 689
    invoke-static {v4, v1}, Ljava/lang/Math;->max(FF)F

    .line 690
    .line 691
    .line 692
    move-result v1

    .line 693
    invoke-interface {v2, v1}, Landroidx/core/view/DifferentialMotionFlingTarget;->startDifferentialMotionFling(F)Z

    .line 694
    .line 695
    .line 696
    move-result v2

    .line 697
    if-eqz v2, :cond_29

    .line 698
    .line 699
    move v5, v1

    .line 700
    goto :goto_12

    .line 701
    :cond_29
    const/4 v5, 0x0

    .line 702
    :goto_12
    iput v5, v0, Landroidx/core/view/DifferentialMotionFlingController;->mLastFlingVelocity:F

    .line 703
    .line 704
    return-void
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
.end method
