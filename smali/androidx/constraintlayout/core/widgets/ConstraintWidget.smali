.class public Landroidx/constraintlayout/core/widgets/ConstraintWidget;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public horizontalChainRun:Landroidx/constraintlayout/core/widgets/analyzer/ChainRun;

.field public horizontalGroup:I

.field public final isTerminalWidget:[Z

.field public final mAnchors:Ljava/util/ArrayList;

.field public final mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public mBaselineDistance:I

.field public final mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public final mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public final mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public final mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public mCircleConstraintAngle:F

.field public mCompanionWidget:Landroid/view/View;

.field public mDebugName:Ljava/lang/String;

.field public mDimensionRatio:F

.field public mDimensionRatioSide:I

.field public mHasBaseline:Z

.field public mHeight:I

.field public mHeightOverride:I

.field public mHorizontalBiasPercent:F

.field public mHorizontalChainStyle:I

.field public mHorizontalResolution:I

.field public mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

.field public mHorizontalSolvingPass:Z

.field public mInVirtualLayout:Z

.field public final mIsInBarrier:[Z

.field public mLastHorizontalMeasureSpec:I

.field public mLastVerticalMeasureSpec:I

.field public final mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public final mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public final mListDimensionBehaviors:[I

.field public final mListNextMatchConstraintsWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field public mMatchConstraintDefaultHeight:I

.field public mMatchConstraintDefaultWidth:I

.field public mMatchConstraintMaxHeight:I

.field public mMatchConstraintMaxWidth:I

.field public mMatchConstraintMinHeight:I

.field public mMatchConstraintMinWidth:I

.field public mMatchConstraintPercentHeight:F

.field public mMatchConstraintPercentWidth:F

.field public final mMaxDimension:[I

.field public mMeasureRequested:Z

.field public mMinHeight:I

.field public mMinWidth:I

.field public final mNextChainWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field public mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

.field public mResolvedDimensionRatio:F

.field public mResolvedDimensionRatioSide:I

.field public mResolvedHorizontal:Z

.field public final mResolvedMatchConstraintDefault:[I

.field public mResolvedVertical:Z

.field public final mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public final mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

.field public mVerticalBiasPercent:F

.field public mVerticalChainStyle:I

.field public mVerticalResolution:I

.field public mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

.field public mVerticalSolvingPass:Z

.field public mVisibility:I

.field public final mWeight:[F

.field public mWidth:I

.field public mWidthOverride:I

.field public mWrapBehaviorInParent:I

.field public mX:I

.field public mY:I

.field public measured:Z

.field public stringId:Ljava/lang/String;

.field public verticalChainRun:Landroidx/constraintlayout/core/widgets/analyzer/ChainRun;

.field public verticalGroup:I


# direct methods
.method public constructor <init>()V
    .locals 19

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    const/4 v1, 0x0

    .line 7
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->measured:Z

    .line 8
    .line 9
    const/4 v2, 0x0

    .line 10
    iput-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 11
    .line 12
    iput-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 13
    .line 14
    const/4 v3, 0x2

    .line 15
    new-array v4, v3, [Z

    .line 16
    .line 17
    fill-array-data v4, :array_0

    .line 18
    .line 19
    .line 20
    iput-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    .line 21
    .line 22
    const/4 v4, 0x1

    .line 23
    iput-boolean v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    .line 24
    .line 25
    const/4 v5, -0x1

    .line 26
    iput v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    .line 27
    .line 28
    iput v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    .line 29
    .line 30
    new-instance v6, Ljava/util/HashMap;

    .line 31
    .line 32
    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 33
    .line 34
    .line 35
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 36
    .line 37
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 38
    .line 39
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalSolvingPass:Z

    .line 40
    .line 41
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalSolvingPass:Z

    .line 42
    .line 43
    iput v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    .line 44
    .line 45
    iput v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    .line 46
    .line 47
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWrapBehaviorInParent:I

    .line 48
    .line 49
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    .line 50
    .line 51
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    .line 52
    .line 53
    new-array v6, v3, [I

    .line 54
    .line 55
    iput-object v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    .line 56
    .line 57
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    .line 58
    .line 59
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    .line 60
    .line 61
    const/high16 v6, 0x3f800000    # 1.0f

    .line 62
    .line 63
    iput v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    .line 64
    .line 65
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    .line 66
    .line 67
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    .line 68
    .line 69
    iput v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    .line 70
    .line 71
    iput v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 72
    .line 73
    iput v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 74
    .line 75
    const v6, 0x7fffffff

    .line 76
    .line 77
    .line 78
    filled-new-array {v6, v6}, [I

    .line 79
    .line 80
    .line 81
    move-result-object v6

    .line 82
    iput-object v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    .line 83
    .line 84
    const/high16 v6, 0x7fc00000    # Float.NaN

    .line 85
    .line 86
    iput v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    .line 87
    .line 88
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHasBaseline:Z

    .line 89
    .line 90
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    .line 91
    .line 92
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastHorizontalMeasureSpec:I

    .line 93
    .line 94
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLastVerticalMeasureSpec:I

    .line 95
    .line 96
    new-instance v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 97
    .line 98
    invoke-direct {v6, v0, v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 99
    .line 100
    .line 101
    iput-object v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 102
    .line 103
    new-instance v7, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 104
    .line 105
    const/4 v8, 0x3

    .line 106
    invoke-direct {v7, v0, v8}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 107
    .line 108
    .line 109
    iput-object v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 110
    .line 111
    new-instance v9, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 112
    .line 113
    const/4 v10, 0x4

    .line 114
    invoke-direct {v9, v0, v10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 115
    .line 116
    .line 117
    iput-object v9, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 118
    .line 119
    new-instance v11, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 120
    .line 121
    const/4 v12, 0x5

    .line 122
    invoke-direct {v11, v0, v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 123
    .line 124
    .line 125
    iput-object v11, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 126
    .line 127
    new-instance v13, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 128
    .line 129
    const/4 v14, 0x6

    .line 130
    invoke-direct {v13, v0, v14}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 131
    .line 132
    .line 133
    iput-object v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 134
    .line 135
    new-instance v15, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 136
    .line 137
    const/16 v16, 0x3

    .line 138
    .line 139
    const/16 v8, 0x8

    .line 140
    .line 141
    invoke-direct {v15, v0, v8}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 142
    .line 143
    .line 144
    iput-object v15, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 145
    .line 146
    new-instance v8, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 147
    .line 148
    const/16 v17, 0x4

    .line 149
    .line 150
    const/16 v10, 0x9

    .line 151
    .line 152
    invoke-direct {v8, v0, v10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 153
    .line 154
    .line 155
    iput-object v8, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 156
    .line 157
    new-instance v10, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 158
    .line 159
    const/16 v18, 0x5

    .line 160
    .line 161
    const/4 v12, 0x7

    .line 162
    invoke-direct {v10, v0, v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 163
    .line 164
    .line 165
    iput-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 166
    .line 167
    new-array v12, v14, [Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 168
    .line 169
    aput-object v6, v12, v1

    .line 170
    .line 171
    aput-object v9, v12, v4

    .line 172
    .line 173
    aput-object v7, v12, v3

    .line 174
    .line 175
    aput-object v11, v12, v16

    .line 176
    .line 177
    aput-object v13, v12, v17

    .line 178
    .line 179
    aput-object v10, v12, v18

    .line 180
    .line 181
    iput-object v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 182
    .line 183
    new-instance v12, Ljava/util/ArrayList;

    .line 184
    .line 185
    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    .line 186
    .line 187
    .line 188
    iput-object v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    .line 189
    .line 190
    new-array v14, v3, [Z

    .line 191
    .line 192
    iput-object v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    .line 193
    .line 194
    filled-new-array {v4, v4}, [I

    .line 195
    .line 196
    .line 197
    move-result-object v14

    .line 198
    iput-object v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 199
    .line 200
    iput-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 201
    .line 202
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 203
    .line 204
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 205
    .line 206
    const/4 v14, 0x0

    .line 207
    iput v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    .line 208
    .line 209
    iput v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    .line 210
    .line 211
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 212
    .line 213
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 214
    .line 215
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    .line 216
    .line 217
    const/high16 v14, 0x3f000000    # 0.5f

    .line 218
    .line 219
    iput v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    .line 220
    .line 221
    iput v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    .line 222
    .line 223
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 224
    .line 225
    iput-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    .line 226
    .line 227
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    .line 228
    .line 229
    iput v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    .line 230
    .line 231
    new-array v14, v3, [F

    .line 232
    .line 233
    fill-array-data v14, :array_1

    .line 234
    .line 235
    .line 236
    iput-object v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    .line 237
    .line 238
    new-array v14, v3, [Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 239
    .line 240
    aput-object v2, v14, v1

    .line 241
    .line 242
    aput-object v2, v14, v4

    .line 243
    .line 244
    iput-object v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListNextMatchConstraintsWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 245
    .line 246
    new-array v3, v3, [Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 247
    .line 248
    aput-object v2, v3, v1

    .line 249
    .line 250
    aput-object v2, v3, v4

    .line 251
    .line 252
    iput-object v3, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mNextChainWidget:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 253
    .line 254
    iput v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalGroup:I

    .line 255
    .line 256
    iput v5, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalGroup:I

    .line 257
    .line 258
    invoke-virtual {v12, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 259
    .line 260
    .line 261
    invoke-virtual {v12, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 262
    .line 263
    .line 264
    invoke-virtual {v12, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 265
    .line 266
    .line 267
    invoke-virtual {v12, v11}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 268
    .line 269
    .line 270
    invoke-virtual {v12, v15}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 271
    .line 272
    .line 273
    invoke-virtual {v12, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 274
    .line 275
    .line 276
    invoke-virtual {v12, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 277
    .line 278
    .line 279
    invoke-virtual {v12, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 280
    .line 281
    .line 282
    return-void

    .line 283
    :array_0
    .array-data 1
        0x1t
        0x1t
    .end array-data

    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    nop

    .line 289
    :array_1
    .array-data 4
        -0x40800000    # -1.0f
        -0x40800000    # -1.0f
    .end array-data
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

.method public static getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIFI)V
    .locals 0

    .line 32
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 33
    const-string p1, " :  {\n"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 p1, 0x1

    if-eq p8, p1, :cond_3

    const/4 p1, 0x2

    if-eq p8, p1, :cond_2

    const/4 p1, 0x3

    if-eq p8, p1, :cond_1

    const/4 p1, 0x4

    if-ne p8, p1, :cond_0

    .line 34
    const-string p1, "MATCH_PARENT"

    goto :goto_0

    :cond_0
    const/4 p0, 0x0

    throw p0

    :cond_1
    const-string p1, "MATCH_CONSTRAINT"

    goto :goto_0

    :cond_2
    const-string p1, "WRAP_CONTENT"

    goto :goto_0

    :cond_3
    const-string p1, "FIXED"

    .line 35
    :goto_0
    const-string p8, "FIXED"

    .line 36
    invoke-virtual {p8, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p8

    if-eqz p8, :cond_4

    goto :goto_1

    .line 37
    :cond_4
    const-string p8, "      behavior"

    invoke-virtual {p0, p8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 38
    const-string p8, " :   "

    invoke-virtual {p0, p8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 39
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 40
    const-string p1, ",\n"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 41
    :goto_1
    const-string p1, "      size"

    const/4 p8, 0x0

    invoke-static {p2, p8, p1, p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(IILjava/lang/String;Ljava/lang/StringBuilder;)V

    .line 42
    const-string p1, "      min"

    invoke-static {p3, p8, p1, p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(IILjava/lang/String;Ljava/lang/StringBuilder;)V

    .line 43
    const-string p1, "      max"

    const p2, 0x7fffffff

    invoke-static {p4, p2, p1, p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(IILjava/lang/String;Ljava/lang/StringBuilder;)V

    .line 44
    const-string p1, "      matchMin"

    invoke-static {p5, p8, p1, p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(IILjava/lang/String;Ljava/lang/StringBuilder;)V

    .line 45
    const-string p1, "      matchDef"

    invoke-static {p6, p8, p1, p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(IILjava/lang/String;Ljava/lang/StringBuilder;)V

    .line 46
    const-string p1, "      matchPercent"

    const/high16 p2, 0x3f800000    # 1.0f

    invoke-static {p0, p1, p7, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V

    .line 47
    const-string p1, "    },\n"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method public static getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V
    .locals 2

    .line 48
    iget-object v0, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v0, :cond_0

    return-void

    .line 49
    :cond_0
    const-string v0, "    "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 50
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 51
    const-string p1, " : [ \'"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 52
    iget-object p1, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 53
    const-string p1, "\'"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 54
    iget p1, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    const/high16 v0, -0x80000000

    if-ne p1, v0, :cond_1

    iget p1, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    if-eqz p1, :cond_2

    .line 55
    :cond_1
    const-string p1, ","

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    iget v1, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mMargin:I

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 57
    iget v1, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    if-eq v1, v0, :cond_2

    .line 58
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 59
    iget p2, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mGoneMargin:I

    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 60
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 61
    :cond_2
    const-string p1, " ] ,\n"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method public static serializeAttribute(IILjava/lang/String;Ljava/lang/StringBuilder;)V
    .locals 0

    if-ne p0, p1, :cond_0

    return-void

    .line 5
    :cond_0
    invoke-virtual {p3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 6
    const-string p1, " :   "

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 7
    invoke-virtual {p3, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 8
    const-string p0, ",\n"

    invoke-virtual {p3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method public static serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V
    .locals 0

    cmpl-float p3, p2, p3

    if-nez p3, :cond_0

    return-void

    .line 1
    :cond_0
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2
    const-string p1, " :   "

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3
    invoke-virtual {p0, p2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 4
    const-string p1, ",\n"

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method


# virtual methods
.method public final addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V
    .locals 7

    .line 1
    if-eqz p5, :cond_1

    .line 2
    .line 3
    invoke-virtual {p3, p0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    goto/16 :goto_5

    .line 10
    .line 11
    :cond_0
    invoke-static {p1, p2, p0}, Landroidx/constraintlayout/core/widgets/Chain;->checkMatchParent(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    .line 12
    .line 13
    .line 14
    invoke-virtual {p3, p0}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 15
    .line 16
    .line 17
    const/16 v0, 0x40

    .line 18
    .line 19
    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    .line 20
    .line 21
    .line 22
    move-result v0

    .line 23
    invoke-virtual {p0, p2, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 24
    .line 25
    .line 26
    :cond_1
    if-nez p4, :cond_3

    .line 27
    .line 28
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 29
    .line 30
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 31
    .line 32
    if-eqz v0, :cond_2

    .line 33
    .line 34
    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 35
    .line 36
    .line 37
    move-result-object v0

    .line 38
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 39
    .line 40
    .line 41
    move-result v1

    .line 42
    if-eqz v1, :cond_2

    .line 43
    .line 44
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 45
    .line 46
    .line 47
    move-result-object v1

    .line 48
    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 49
    .line 50
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 51
    .line 52
    const/4 v6, 0x1

    .line 53
    move-object v2, p1

    .line 54
    move-object v3, p2

    .line 55
    move-object v4, p3

    .line 56
    move v5, p4

    .line 57
    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    .line 58
    .line 59
    .line 60
    goto :goto_0

    .line 61
    :cond_2
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 62
    .line 63
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 64
    .line 65
    if-eqz v0, :cond_6

    .line 66
    .line 67
    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 68
    .line 69
    .line 70
    move-result-object v0

    .line 71
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 72
    .line 73
    .line 74
    move-result v1

    .line 75
    if-eqz v1, :cond_6

    .line 76
    .line 77
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 78
    .line 79
    .line 80
    move-result-object v1

    .line 81
    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 82
    .line 83
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 84
    .line 85
    const/4 v6, 0x1

    .line 86
    move-object v2, p1

    .line 87
    move-object v3, p2

    .line 88
    move-object v4, p3

    .line 89
    move v5, p4

    .line 90
    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    .line 91
    .line 92
    .line 93
    goto :goto_1

    .line 94
    :cond_3
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 95
    .line 96
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 97
    .line 98
    if-eqz v0, :cond_4

    .line 99
    .line 100
    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 101
    .line 102
    .line 103
    move-result-object v0

    .line 104
    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 105
    .line 106
    .line 107
    move-result v1

    .line 108
    if-eqz v1, :cond_4

    .line 109
    .line 110
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 111
    .line 112
    .line 113
    move-result-object v1

    .line 114
    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 115
    .line 116
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 117
    .line 118
    const/4 v6, 0x1

    .line 119
    move-object v2, p1

    .line 120
    move-object v3, p2

    .line 121
    move-object v4, p3

    .line 122
    move v5, p4

    .line 123
    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    .line 124
    .line 125
    .line 126
    goto :goto_2

    .line 127
    :cond_4
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 128
    .line 129
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 130
    .line 131
    if-eqz v0, :cond_5

    .line 132
    .line 133
    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 134
    .line 135
    .line 136
    move-result-object v0

    .line 137
    :goto_3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 138
    .line 139
    .line 140
    move-result v1

    .line 141
    if-eqz v1, :cond_5

    .line 142
    .line 143
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 144
    .line 145
    .line 146
    move-result-object v1

    .line 147
    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 148
    .line 149
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 150
    .line 151
    const/4 v6, 0x1

    .line 152
    move-object v2, p1

    .line 153
    move-object v3, p2

    .line 154
    move-object v4, p3

    .line 155
    move v5, p4

    .line 156
    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    .line 157
    .line 158
    .line 159
    goto :goto_3

    .line 160
    :cond_5
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 161
    .line 162
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 163
    .line 164
    if-eqz v0, :cond_6

    .line 165
    .line 166
    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 167
    .line 168
    .line 169
    move-result-object v0

    .line 170
    :goto_4
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 171
    .line 172
    .line 173
    move-result v1

    .line 174
    if-eqz v1, :cond_6

    .line 175
    .line 176
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 177
    .line 178
    .line 179
    move-result-object v1

    .line 180
    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 181
    .line 182
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 183
    .line 184
    const/4 v6, 0x1

    .line 185
    move-object v2, p1

    .line 186
    move-object v3, p2

    .line 187
    move-object v4, p3

    .line 188
    move v5, p4

    .line 189
    :try_start_0
    invoke-virtual/range {v1 .. v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 190
    .line 191
    .line 192
    goto :goto_4

    .line 193
    :catchall_0
    move-exception v0

    .line 194
    throw v0

    .line 195
    :cond_6
    :goto_5
    return-void
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
    .line 632
    .line 633
    .line 634
    .line 635
    .line 636
    .line 637
    .line 638
    .line 639
    .line 640
    .line 641
    .line 642
    .line 643
    .line 644
    .line 645
    .line 646
    .line 647
    .line 648
    .line 649
    .line 650
    .line 651
    .line 652
    .line 653
    .line 654
    .line 655
    .line 656
    .line 657
    .line 658
    .line 659
    .line 660
    .line 661
    .line 662
    .line 663
    .line 664
    .line 665
    .line 666
    .line 667
    .line 668
    .line 669
    .line 670
    .line 671
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
.end method

.method public addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V
    .locals 58

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 6
    .line 7
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 8
    .line 9
    .line 10
    move-result-object v3

    .line 11
    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    invoke-virtual {v1, v4}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 14
    .line 15
    .line 16
    move-result-object v5

    .line 17
    iget-object v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 18
    .line 19
    invoke-virtual {v1, v6}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 20
    .line 21
    .line 22
    move-result-object v7

    .line 23
    iget-object v8, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 24
    .line 25
    invoke-virtual {v1, v8}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 26
    .line 27
    .line 28
    move-result-object v9

    .line 29
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 30
    .line 31
    invoke-virtual {v1, v10}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 32
    .line 33
    .line 34
    move-result-object v11

    .line 35
    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 36
    .line 37
    const/4 v13, 0x2

    .line 38
    const/4 v15, 0x1

    .line 39
    if-eqz v12, :cond_5

    .line 40
    .line 41
    iget-object v12, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 42
    .line 43
    const/16 v17, 0x0

    .line 44
    .line 45
    aget v14, v12, v17

    .line 46
    .line 47
    if-ne v14, v13, :cond_0

    .line 48
    .line 49
    const/4 v14, 0x1

    .line 50
    goto :goto_0

    .line 51
    :cond_0
    const/4 v14, 0x0

    .line 52
    :goto_0
    aget v12, v12, v15

    .line 53
    .line 54
    if-ne v12, v13, :cond_1

    .line 55
    .line 56
    const/16 v18, 0x1

    .line 57
    .line 58
    goto :goto_1

    .line 59
    :cond_1
    const/16 v18, 0x0

    .line 60
    .line 61
    :goto_1
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWrapBehaviorInParent:I

    .line 62
    .line 63
    if-eq v12, v15, :cond_4

    .line 64
    .line 65
    if-eq v12, v13, :cond_3

    .line 66
    .line 67
    const/4 v13, 0x3

    .line 68
    if-eq v12, v13, :cond_2

    .line 69
    .line 70
    move/from16 v12, v18

    .line 71
    .line 72
    goto :goto_4

    .line 73
    :cond_2
    :goto_2
    const/4 v12, 0x0

    .line 74
    :goto_3
    const/4 v14, 0x0

    .line 75
    goto :goto_4

    .line 76
    :cond_3
    move/from16 v12, v18

    .line 77
    .line 78
    goto :goto_3

    .line 79
    :cond_4
    const/4 v12, 0x0

    .line 80
    goto :goto_4

    .line 81
    :cond_5
    const/16 v17, 0x0

    .line 82
    .line 83
    goto :goto_2

    .line 84
    :goto_4
    iget v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 85
    .line 86
    const/16 v18, 0x1

    .line 87
    .line 88
    iget-object v15, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    .line 89
    .line 90
    move/from16 v20, v12

    .line 91
    .line 92
    const/16 v12, 0x8

    .line 93
    .line 94
    if-ne v13, v12, :cond_9

    .line 95
    .line 96
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    .line 97
    .line 98
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    .line 99
    .line 100
    .line 101
    move-result v12

    .line 102
    move/from16 v22, v14

    .line 103
    .line 104
    const/4 v14, 0x0

    .line 105
    :goto_5
    if-ge v14, v12, :cond_8

    .line 106
    .line 107
    invoke-virtual {v13, v14}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 108
    .line 109
    .line 110
    move-result-object v23

    .line 111
    move/from16 v24, v12

    .line 112
    .line 113
    move-object/from16 v12, v23

    .line 114
    .line 115
    check-cast v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 116
    .line 117
    iget-object v12, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 118
    .line 119
    if-nez v12, :cond_6

    .line 120
    .line 121
    goto :goto_6

    .line 122
    :cond_6
    invoke-virtual {v12}, Ljava/util/HashSet;->size()I

    .line 123
    .line 124
    .line 125
    move-result v12

    .line 126
    if-lez v12, :cond_7

    .line 127
    .line 128
    goto :goto_7

    .line 129
    :cond_7
    :goto_6
    add-int/lit8 v14, v14, 0x1

    .line 130
    .line 131
    move/from16 v12, v24

    .line 132
    .line 133
    goto :goto_5

    .line 134
    :cond_8
    aget-boolean v12, v15, v17

    .line 135
    .line 136
    if-nez v12, :cond_a

    .line 137
    .line 138
    aget-boolean v12, v15, v18

    .line 139
    .line 140
    if-nez v12, :cond_a

    .line 141
    .line 142
    return-void

    .line 143
    :cond_9
    move/from16 v22, v14

    .line 144
    .line 145
    :cond_a
    :goto_7
    iget-boolean v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 146
    .line 147
    if-nez v12, :cond_b

    .line 148
    .line 149
    iget-boolean v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 150
    .line 151
    if-eqz v13, :cond_16

    .line 152
    .line 153
    :cond_b
    if-eqz v12, :cond_f

    .line 154
    .line 155
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 156
    .line 157
    invoke-virtual {v1, v3, v12}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 158
    .line 159
    .line 160
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 161
    .line 162
    iget v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 163
    .line 164
    add-int/2addr v12, v13

    .line 165
    invoke-virtual {v1, v5, v12}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 166
    .line 167
    .line 168
    if-eqz v22, :cond_f

    .line 169
    .line 170
    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 171
    .line 172
    if-eqz v12, :cond_f

    .line 173
    .line 174
    check-cast v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 175
    .line 176
    iget-object v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMin:Ljava/lang/ref/WeakReference;

    .line 177
    .line 178
    if-eqz v13, :cond_c

    .line 179
    .line 180
    invoke-virtual {v13}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 181
    .line 182
    .line 183
    move-result-object v13

    .line 184
    if-eqz v13, :cond_c

    .line 185
    .line 186
    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 187
    .line 188
    .line 189
    move-result v13

    .line 190
    iget-object v14, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMin:Ljava/lang/ref/WeakReference;

    .line 191
    .line 192
    invoke-virtual {v14}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 193
    .line 194
    .line 195
    move-result-object v14

    .line 196
    check-cast v14, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 197
    .line 198
    invoke-virtual {v14}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 199
    .line 200
    .line 201
    move-result v14

    .line 202
    if-le v13, v14, :cond_d

    .line 203
    .line 204
    :cond_c
    new-instance v13, Ljava/lang/ref/WeakReference;

    .line 205
    .line 206
    invoke-direct {v13, v2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 207
    .line 208
    .line 209
    iput-object v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMin:Ljava/lang/ref/WeakReference;

    .line 210
    .line 211
    :cond_d
    iget-object v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMax:Ljava/lang/ref/WeakReference;

    .line 212
    .line 213
    if-eqz v13, :cond_e

    .line 214
    .line 215
    invoke-virtual {v13}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 216
    .line 217
    .line 218
    move-result-object v13

    .line 219
    if-eqz v13, :cond_e

    .line 220
    .line 221
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 222
    .line 223
    .line 224
    move-result v13

    .line 225
    iget-object v14, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMax:Ljava/lang/ref/WeakReference;

    .line 226
    .line 227
    invoke-virtual {v14}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 228
    .line 229
    .line 230
    move-result-object v14

    .line 231
    check-cast v14, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 232
    .line 233
    invoke-virtual {v14}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 234
    .line 235
    .line 236
    move-result v14

    .line 237
    if-le v13, v14, :cond_f

    .line 238
    .line 239
    :cond_e
    new-instance v13, Ljava/lang/ref/WeakReference;

    .line 240
    .line 241
    invoke-direct {v13, v4}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 242
    .line 243
    .line 244
    iput-object v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMax:Ljava/lang/ref/WeakReference;

    .line 245
    .line 246
    :cond_f
    iget-boolean v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 247
    .line 248
    if-eqz v12, :cond_15

    .line 249
    .line 250
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 251
    .line 252
    invoke-virtual {v1, v7, v12}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 253
    .line 254
    .line 255
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 256
    .line 257
    iget v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 258
    .line 259
    add-int/2addr v12, v13

    .line 260
    invoke-virtual {v1, v9, v12}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 261
    .line 262
    .line 263
    iget-object v12, v10, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 264
    .line 265
    if-nez v12, :cond_10

    .line 266
    .line 267
    goto :goto_8

    .line 268
    :cond_10
    invoke-virtual {v12}, Ljava/util/HashSet;->size()I

    .line 269
    .line 270
    .line 271
    move-result v12

    .line 272
    if-lez v12, :cond_11

    .line 273
    .line 274
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 275
    .line 276
    iget v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    .line 277
    .line 278
    add-int/2addr v12, v13

    .line 279
    invoke-virtual {v1, v11, v12}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 280
    .line 281
    .line 282
    :cond_11
    :goto_8
    if-eqz v20, :cond_15

    .line 283
    .line 284
    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 285
    .line 286
    if-eqz v12, :cond_15

    .line 287
    .line 288
    check-cast v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 289
    .line 290
    iget-object v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMin:Ljava/lang/ref/WeakReference;

    .line 291
    .line 292
    if-eqz v13, :cond_12

    .line 293
    .line 294
    invoke-virtual {v13}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 295
    .line 296
    .line 297
    move-result-object v13

    .line 298
    if-eqz v13, :cond_12

    .line 299
    .line 300
    invoke-virtual {v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 301
    .line 302
    .line 303
    move-result v13

    .line 304
    iget-object v14, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMin:Ljava/lang/ref/WeakReference;

    .line 305
    .line 306
    invoke-virtual {v14}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 307
    .line 308
    .line 309
    move-result-object v14

    .line 310
    check-cast v14, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 311
    .line 312
    invoke-virtual {v14}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 313
    .line 314
    .line 315
    move-result v14

    .line 316
    if-le v13, v14, :cond_13

    .line 317
    .line 318
    :cond_12
    new-instance v13, Ljava/lang/ref/WeakReference;

    .line 319
    .line 320
    invoke-direct {v13, v6}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 321
    .line 322
    .line 323
    iput-object v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMin:Ljava/lang/ref/WeakReference;

    .line 324
    .line 325
    :cond_13
    iget-object v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMax:Ljava/lang/ref/WeakReference;

    .line 326
    .line 327
    if-eqz v13, :cond_14

    .line 328
    .line 329
    invoke-virtual {v13}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 330
    .line 331
    .line 332
    move-result-object v13

    .line 333
    if-eqz v13, :cond_14

    .line 334
    .line 335
    invoke-virtual {v8}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 336
    .line 337
    .line 338
    move-result v13

    .line 339
    iget-object v14, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMax:Ljava/lang/ref/WeakReference;

    .line 340
    .line 341
    invoke-virtual {v14}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 342
    .line 343
    .line 344
    move-result-object v14

    .line 345
    check-cast v14, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 346
    .line 347
    invoke-virtual {v14}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 348
    .line 349
    .line 350
    move-result v14

    .line 351
    if-le v13, v14, :cond_15

    .line 352
    .line 353
    :cond_14
    new-instance v13, Ljava/lang/ref/WeakReference;

    .line 354
    .line 355
    invoke-direct {v13, v8}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 356
    .line 357
    .line 358
    iput-object v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMax:Ljava/lang/ref/WeakReference;

    .line 359
    .line 360
    :cond_15
    iget-boolean v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 361
    .line 362
    if-eqz v12, :cond_16

    .line 363
    .line 364
    iget-boolean v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 365
    .line 366
    if-eqz v12, :cond_16

    .line 367
    .line 368
    const/4 v12, 0x0

    .line 369
    iput-boolean v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 370
    .line 371
    iput-boolean v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 372
    .line 373
    return-void

    .line 374
    :cond_16
    iget-object v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    .line 375
    .line 376
    if-eqz p2, :cond_1a

    .line 377
    .line 378
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 379
    .line 380
    if-eqz v13, :cond_1a

    .line 381
    .line 382
    iget-object v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 383
    .line 384
    if-eqz v14, :cond_1a

    .line 385
    .line 386
    move-object/from16 v23, v10

    .line 387
    .line 388
    iget-object v10, v13, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 389
    .line 390
    move-object/from16 v24, v12

    .line 391
    .line 392
    iget-boolean v12, v10, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 393
    .line 394
    if-eqz v12, :cond_19

    .line 395
    .line 396
    iget-object v12, v13, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 397
    .line 398
    iget-boolean v12, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 399
    .line 400
    if-eqz v12, :cond_19

    .line 401
    .line 402
    iget-object v12, v14, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 403
    .line 404
    iget-boolean v12, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 405
    .line 406
    if-eqz v12, :cond_19

    .line 407
    .line 408
    iget-object v12, v14, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 409
    .line 410
    iget-boolean v12, v12, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 411
    .line 412
    if-eqz v12, :cond_19

    .line 413
    .line 414
    iget v2, v10, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 415
    .line 416
    invoke-virtual {v1, v3, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 417
    .line 418
    .line 419
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 420
    .line 421
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 422
    .line 423
    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 424
    .line 425
    invoke-virtual {v1, v5, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 426
    .line 427
    .line 428
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 429
    .line 430
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 431
    .line 432
    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 433
    .line 434
    invoke-virtual {v1, v7, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 435
    .line 436
    .line 437
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 438
    .line 439
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 440
    .line 441
    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 442
    .line 443
    invoke-virtual {v1, v9, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 444
    .line 445
    .line 446
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 447
    .line 448
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->baseline:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 449
    .line 450
    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 451
    .line 452
    invoke-virtual {v1, v11, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 453
    .line 454
    .line 455
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 456
    .line 457
    if-eqz v2, :cond_18

    .line 458
    .line 459
    if-eqz v22, :cond_17

    .line 460
    .line 461
    const/4 v12, 0x0

    .line 462
    aget-boolean v2, v24, v12

    .line 463
    .line 464
    if-eqz v2, :cond_17

    .line 465
    .line 466
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    .line 467
    .line 468
    .line 469
    move-result v2

    .line 470
    if-nez v2, :cond_17

    .line 471
    .line 472
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 473
    .line 474
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 475
    .line 476
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 477
    .line 478
    .line 479
    move-result-object v2

    .line 480
    const/16 v3, 0x8

    .line 481
    .line 482
    invoke-virtual {v1, v2, v5, v12, v3}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 483
    .line 484
    .line 485
    :cond_17
    if-eqz v20, :cond_18

    .line 486
    .line 487
    aget-boolean v2, v24, v18

    .line 488
    .line 489
    if-eqz v2, :cond_18

    .line 490
    .line 491
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVerticalChain()Z

    .line 492
    .line 493
    .line 494
    move-result v2

    .line 495
    if-nez v2, :cond_18

    .line 496
    .line 497
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 498
    .line 499
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 500
    .line 501
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 502
    .line 503
    .line 504
    move-result-object v2

    .line 505
    const/16 v3, 0x8

    .line 506
    .line 507
    const/4 v12, 0x0

    .line 508
    invoke-virtual {v1, v2, v9, v12, v3}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 509
    .line 510
    .line 511
    goto :goto_9

    .line 512
    :cond_18
    const/4 v12, 0x0

    .line 513
    :goto_9
    iput-boolean v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 514
    .line 515
    iput-boolean v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 516
    .line 517
    return-void

    .line 518
    :cond_19
    :goto_a
    const/4 v12, 0x0

    .line 519
    goto :goto_b

    .line 520
    :cond_1a
    move-object/from16 v23, v10

    .line 521
    .line 522
    move-object/from16 v24, v12

    .line 523
    .line 524
    goto :goto_a

    .line 525
    :goto_b
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 526
    .line 527
    if-eqz v10, :cond_1f

    .line 528
    .line 529
    invoke-virtual {v0, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isChainHead(I)Z

    .line 530
    .line 531
    .line 532
    move-result v10

    .line 533
    if-eqz v10, :cond_1b

    .line 534
    .line 535
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 536
    .line 537
    check-cast v10, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 538
    .line 539
    invoke-virtual {v10, v0, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addChain(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 540
    .line 541
    .line 542
    const/4 v10, 0x1

    .line 543
    :goto_c
    const/4 v12, 0x1

    .line 544
    goto :goto_d

    .line 545
    :cond_1b
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    .line 546
    .line 547
    .line 548
    move-result v10

    .line 549
    goto :goto_c

    .line 550
    :goto_d
    invoke-virtual {v0, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isChainHead(I)Z

    .line 551
    .line 552
    .line 553
    move-result v13

    .line 554
    if-eqz v13, :cond_1c

    .line 555
    .line 556
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 557
    .line 558
    check-cast v13, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 559
    .line 560
    invoke-virtual {v13, v0, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addChain(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V

    .line 561
    .line 562
    .line 563
    const/4 v12, 0x1

    .line 564
    goto :goto_e

    .line 565
    :cond_1c
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInVerticalChain()Z

    .line 566
    .line 567
    .line 568
    move-result v12

    .line 569
    :goto_e
    if-nez v10, :cond_1d

    .line 570
    .line 571
    if-eqz v22, :cond_1d

    .line 572
    .line 573
    iget v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 574
    .line 575
    const/16 v14, 0x8

    .line 576
    .line 577
    if-eq v13, v14, :cond_1d

    .line 578
    .line 579
    iget-object v13, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 580
    .line 581
    if-nez v13, :cond_1d

    .line 582
    .line 583
    iget-object v13, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 584
    .line 585
    if-nez v13, :cond_1d

    .line 586
    .line 587
    iget-object v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 588
    .line 589
    iget-object v13, v13, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 590
    .line 591
    invoke-virtual {v1, v13}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 592
    .line 593
    .line 594
    move-result-object v13

    .line 595
    move-object/from16 v25, v2

    .line 596
    .line 597
    const/4 v2, 0x0

    .line 598
    const/4 v14, 0x1

    .line 599
    invoke-virtual {v1, v13, v5, v2, v14}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 600
    .line 601
    .line 602
    goto :goto_f

    .line 603
    :cond_1d
    move-object/from16 v25, v2

    .line 604
    .line 605
    :goto_f
    if-nez v12, :cond_1e

    .line 606
    .line 607
    if-eqz v20, :cond_1e

    .line 608
    .line 609
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 610
    .line 611
    const/16 v14, 0x8

    .line 612
    .line 613
    if-eq v2, v14, :cond_1e

    .line 614
    .line 615
    iget-object v2, v6, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 616
    .line 617
    if-nez v2, :cond_1e

    .line 618
    .line 619
    iget-object v2, v8, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 620
    .line 621
    if-nez v2, :cond_1e

    .line 622
    .line 623
    if-nez v23, :cond_1e

    .line 624
    .line 625
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 626
    .line 627
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 628
    .line 629
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 630
    .line 631
    .line 632
    move-result-object v2

    .line 633
    const/4 v13, 0x0

    .line 634
    const/4 v14, 0x1

    .line 635
    invoke-virtual {v1, v2, v9, v13, v14}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 636
    .line 637
    .line 638
    :cond_1e
    move-object v2, v4

    .line 639
    move/from16 v4, v20

    .line 640
    .line 641
    move/from16 v20, v12

    .line 642
    .line 643
    move v12, v10

    .line 644
    goto :goto_10

    .line 645
    :cond_1f
    move-object/from16 v25, v2

    .line 646
    .line 647
    move-object v2, v4

    .line 648
    move/from16 v4, v20

    .line 649
    .line 650
    const/4 v12, 0x0

    .line 651
    const/16 v20, 0x0

    .line 652
    .line 653
    :goto_10
    iget v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 654
    .line 655
    iget v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    .line 656
    .line 657
    if-ge v10, v13, :cond_20

    .line 658
    .line 659
    goto :goto_11

    .line 660
    :cond_20
    move v13, v10

    .line 661
    :goto_11
    iget v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 662
    .line 663
    move-object/from16 v26, v2

    .line 664
    .line 665
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    .line 666
    .line 667
    if-ge v14, v2, :cond_21

    .line 668
    .line 669
    move/from16 v27, v2

    .line 670
    .line 671
    goto :goto_12

    .line 672
    :cond_21
    move/from16 v27, v14

    .line 673
    .line 674
    :goto_12
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 675
    .line 676
    move-object/from16 v28, v2

    .line 677
    .line 678
    const/16 v17, 0x0

    .line 679
    .line 680
    aget v2, v28, v17

    .line 681
    .line 682
    move/from16 v29, v4

    .line 683
    .line 684
    const/4 v4, 0x3

    .line 685
    if-eq v2, v4, :cond_22

    .line 686
    .line 687
    const/16 v30, 0x1

    .line 688
    .line 689
    :goto_13
    move-object/from16 v31, v6

    .line 690
    .line 691
    const/16 v18, 0x1

    .line 692
    .line 693
    goto :goto_14

    .line 694
    :cond_22
    const/16 v30, 0x0

    .line 695
    .line 696
    goto :goto_13

    .line 697
    :goto_14
    aget v6, v28, v18

    .line 698
    .line 699
    if-eq v6, v4, :cond_23

    .line 700
    .line 701
    const/16 v32, 0x1

    .line 702
    .line 703
    goto :goto_15

    .line 704
    :cond_23
    const/16 v32, 0x0

    .line 705
    .line 706
    :goto_15
    iget v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    .line 707
    .line 708
    iput v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 709
    .line 710
    move-object/from16 v33, v7

    .line 711
    .line 712
    iget v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    .line 713
    .line 714
    iput v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 715
    .line 716
    move/from16 v34, v7

    .line 717
    .line 718
    iget v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    .line 719
    .line 720
    move/from16 v35, v7

    .line 721
    .line 722
    iget v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    .line 723
    .line 724
    const/16 v36, 0x0

    .line 725
    .line 726
    move/from16 v37, v7

    .line 727
    .line 728
    const/high16 v38, 0x3f800000    # 1.0f

    .line 729
    .line 730
    cmpl-float v36, v34, v36

    .line 731
    .line 732
    if-lez v36, :cond_36

    .line 733
    .line 734
    iget v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 735
    .line 736
    move-object/from16 v39, v8

    .line 737
    .line 738
    const/16 v8, 0x8

    .line 739
    .line 740
    if-eq v7, v8, :cond_35

    .line 741
    .line 742
    const/4 v7, 0x3

    .line 743
    if-ne v2, v7, :cond_24

    .line 744
    .line 745
    if-nez v35, :cond_24

    .line 746
    .line 747
    const/4 v8, 0x3

    .line 748
    goto :goto_16

    .line 749
    :cond_24
    move/from16 v8, v35

    .line 750
    .line 751
    :goto_16
    if-ne v6, v7, :cond_25

    .line 752
    .line 753
    if-nez v37, :cond_25

    .line 754
    .line 755
    move-object/from16 v40, v9

    .line 756
    .line 757
    const/4 v9, 0x3

    .line 758
    goto :goto_17

    .line 759
    :cond_25
    move-object/from16 v40, v9

    .line 760
    .line 761
    move/from16 v9, v37

    .line 762
    .line 763
    :goto_17
    if-ne v2, v7, :cond_30

    .line 764
    .line 765
    if-ne v6, v7, :cond_30

    .line 766
    .line 767
    if-ne v8, v7, :cond_30

    .line 768
    .line 769
    if-ne v9, v7, :cond_30

    .line 770
    .line 771
    const/4 v7, -0x1

    .line 772
    if-ne v4, v7, :cond_27

    .line 773
    .line 774
    if-eqz v30, :cond_26

    .line 775
    .line 776
    if-nez v32, :cond_26

    .line 777
    .line 778
    const/4 v2, 0x0

    .line 779
    iput v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 780
    .line 781
    goto :goto_18

    .line 782
    :cond_26
    if-nez v30, :cond_27

    .line 783
    .line 784
    if-eqz v32, :cond_27

    .line 785
    .line 786
    const/4 v14, 0x1

    .line 787
    iput v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 788
    .line 789
    if-ne v4, v7, :cond_27

    .line 790
    .line 791
    div-float v7, v38, v34

    .line 792
    .line 793
    iput v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 794
    .line 795
    :cond_27
    :goto_18
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 796
    .line 797
    if-nez v2, :cond_29

    .line 798
    .line 799
    invoke-virtual/range {v31 .. v31}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 800
    .line 801
    .line 802
    move-result v2

    .line 803
    if-eqz v2, :cond_28

    .line 804
    .line 805
    invoke-virtual/range {v39 .. v39}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 806
    .line 807
    .line 808
    move-result v2

    .line 809
    if-nez v2, :cond_29

    .line 810
    .line 811
    :cond_28
    const/4 v14, 0x1

    .line 812
    goto :goto_19

    .line 813
    :cond_29
    const/4 v14, 0x1

    .line 814
    goto :goto_1a

    .line 815
    :goto_19
    iput v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 816
    .line 817
    goto :goto_1b

    .line 818
    :goto_1a
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 819
    .line 820
    if-ne v2, v14, :cond_2b

    .line 821
    .line 822
    invoke-virtual/range {v25 .. v25}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 823
    .line 824
    .line 825
    move-result v2

    .line 826
    if-eqz v2, :cond_2a

    .line 827
    .line 828
    invoke-virtual/range {v26 .. v26}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 829
    .line 830
    .line 831
    move-result v2

    .line 832
    if-nez v2, :cond_2b

    .line 833
    .line 834
    :cond_2a
    const/4 v2, 0x0

    .line 835
    iput v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 836
    .line 837
    :cond_2b
    :goto_1b
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 838
    .line 839
    const/4 v7, -0x1

    .line 840
    if-ne v2, v7, :cond_2e

    .line 841
    .line 842
    invoke-virtual/range {v31 .. v31}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 843
    .line 844
    .line 845
    move-result v2

    .line 846
    if-eqz v2, :cond_2c

    .line 847
    .line 848
    invoke-virtual/range {v39 .. v39}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 849
    .line 850
    .line 851
    move-result v2

    .line 852
    if-eqz v2, :cond_2c

    .line 853
    .line 854
    invoke-virtual/range {v25 .. v25}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 855
    .line 856
    .line 857
    move-result v2

    .line 858
    if-eqz v2, :cond_2c

    .line 859
    .line 860
    invoke-virtual/range {v26 .. v26}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 861
    .line 862
    .line 863
    move-result v2

    .line 864
    if-nez v2, :cond_2e

    .line 865
    .line 866
    :cond_2c
    invoke-virtual/range {v31 .. v31}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 867
    .line 868
    .line 869
    move-result v2

    .line 870
    if-eqz v2, :cond_2d

    .line 871
    .line 872
    invoke-virtual/range {v39 .. v39}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 873
    .line 874
    .line 875
    move-result v2

    .line 876
    if-eqz v2, :cond_2d

    .line 877
    .line 878
    const/4 v2, 0x0

    .line 879
    iput v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 880
    .line 881
    goto :goto_1c

    .line 882
    :cond_2d
    invoke-virtual/range {v25 .. v25}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 883
    .line 884
    .line 885
    move-result v2

    .line 886
    if-eqz v2, :cond_2e

    .line 887
    .line 888
    invoke-virtual/range {v26 .. v26}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 889
    .line 890
    .line 891
    move-result v2

    .line 892
    if-eqz v2, :cond_2e

    .line 893
    .line 894
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 895
    .line 896
    div-float v7, v38, v2

    .line 897
    .line 898
    iput v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 899
    .line 900
    const/4 v14, 0x1

    .line 901
    iput v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 902
    .line 903
    :cond_2e
    :goto_1c
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 904
    .line 905
    const/4 v7, -0x1

    .line 906
    if-ne v2, v7, :cond_31

    .line 907
    .line 908
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    .line 909
    .line 910
    if-lez v2, :cond_2f

    .line 911
    .line 912
    iget v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    .line 913
    .line 914
    if-nez v4, :cond_2f

    .line 915
    .line 916
    const/4 v4, 0x0

    .line 917
    iput v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 918
    .line 919
    goto :goto_1e

    .line 920
    :cond_2f
    if-nez v2, :cond_31

    .line 921
    .line 922
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    .line 923
    .line 924
    if-lez v2, :cond_31

    .line 925
    .line 926
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 927
    .line 928
    div-float v7, v38, v2

    .line 929
    .line 930
    iput v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 931
    .line 932
    const/4 v14, 0x1

    .line 933
    iput v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 934
    .line 935
    goto :goto_1e

    .line 936
    :cond_30
    if-ne v2, v7, :cond_32

    .line 937
    .line 938
    if-ne v8, v7, :cond_32

    .line 939
    .line 940
    const/4 v7, 0x0

    .line 941
    iput v7, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 942
    .line 943
    int-to-float v2, v14

    .line 944
    mul-float v7, v34, v2

    .line 945
    .line 946
    float-to-int v2, v7

    .line 947
    const/4 v7, 0x3

    .line 948
    move v13, v2

    .line 949
    if-eq v6, v7, :cond_31

    .line 950
    .line 951
    move-object/from16 v2, v23

    .line 952
    .line 953
    move/from16 v30, v27

    .line 954
    .line 955
    const/4 v7, 0x4

    .line 956
    const/16 v31, 0x0

    .line 957
    .line 958
    :goto_1d
    move/from16 v23, v9

    .line 959
    .line 960
    goto :goto_23

    .line 961
    :cond_31
    :goto_1e
    move v7, v8

    .line 962
    move-object/from16 v2, v23

    .line 963
    .line 964
    move/from16 v30, v27

    .line 965
    .line 966
    :goto_1f
    const/16 v31, 0x1

    .line 967
    .line 968
    goto :goto_1d

    .line 969
    :cond_32
    if-ne v6, v7, :cond_31

    .line 970
    .line 971
    if-ne v9, v7, :cond_31

    .line 972
    .line 973
    const/4 v14, 0x1

    .line 974
    iput v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 975
    .line 976
    const/4 v6, -0x1

    .line 977
    if-ne v4, v6, :cond_33

    .line 978
    .line 979
    div-float v4, v38, v34

    .line 980
    .line 981
    iput v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 982
    .line 983
    :cond_33
    iget v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 984
    .line 985
    int-to-float v6, v10

    .line 986
    mul-float v4, v4, v6

    .line 987
    .line 988
    float-to-int v4, v4

    .line 989
    move/from16 v30, v4

    .line 990
    .line 991
    if-eq v2, v7, :cond_34

    .line 992
    .line 993
    move v7, v8

    .line 994
    move-object/from16 v2, v23

    .line 995
    .line 996
    const/16 v23, 0x4

    .line 997
    .line 998
    :goto_20
    const/16 v31, 0x0

    .line 999
    .line 1000
    goto :goto_23

    .line 1001
    :cond_34
    move v7, v8

    .line 1002
    move-object/from16 v2, v23

    .line 1003
    .line 1004
    goto :goto_1f

    .line 1005
    :cond_35
    :goto_21
    move-object/from16 v40, v9

    .line 1006
    .line 1007
    goto :goto_22

    .line 1008
    :cond_36
    move-object/from16 v39, v8

    .line 1009
    .line 1010
    goto :goto_21

    .line 1011
    :goto_22
    move-object/from16 v2, v23

    .line 1012
    .line 1013
    move/from16 v30, v27

    .line 1014
    .line 1015
    move/from16 v7, v35

    .line 1016
    .line 1017
    move/from16 v23, v37

    .line 1018
    .line 1019
    goto :goto_20

    .line 1020
    :goto_23
    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    .line 1021
    .line 1022
    const/16 v17, 0x0

    .line 1023
    .line 1024
    aput v7, v4, v17

    .line 1025
    .line 1026
    const/16 v18, 0x1

    .line 1027
    .line 1028
    aput v23, v4, v18

    .line 1029
    .line 1030
    if-eqz v31, :cond_38

    .line 1031
    .line 1032
    iget v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 1033
    .line 1034
    const/4 v6, -0x1

    .line 1035
    if-eqz v4, :cond_37

    .line 1036
    .line 1037
    if-ne v4, v6, :cond_39

    .line 1038
    .line 1039
    :cond_37
    const/4 v4, 0x1

    .line 1040
    goto :goto_24

    .line 1041
    :cond_38
    const/4 v6, -0x1

    .line 1042
    :cond_39
    const/4 v4, 0x0

    .line 1043
    :goto_24
    if-eqz v31, :cond_3b

    .line 1044
    .line 1045
    iget v8, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 1046
    .line 1047
    const/4 v14, 0x1

    .line 1048
    if-eq v8, v14, :cond_3a

    .line 1049
    .line 1050
    if-ne v8, v6, :cond_3b

    .line 1051
    .line 1052
    :cond_3a
    const/16 v32, 0x1

    .line 1053
    .line 1054
    :goto_25
    const/16 v17, 0x0

    .line 1055
    .line 1056
    goto :goto_26

    .line 1057
    :cond_3b
    const/16 v32, 0x0

    .line 1058
    .line 1059
    goto :goto_25

    .line 1060
    :goto_26
    aget v6, v28, v17

    .line 1061
    .line 1062
    const/4 v8, 0x2

    .line 1063
    if-ne v6, v8, :cond_3c

    .line 1064
    .line 1065
    instance-of v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 1066
    .line 1067
    if-eqz v6, :cond_3c

    .line 1068
    .line 1069
    const/4 v9, 0x1

    .line 1070
    goto :goto_27

    .line 1071
    :cond_3c
    const/4 v9, 0x0

    .line 1072
    :goto_27
    if-eqz v9, :cond_3d

    .line 1073
    .line 1074
    const/4 v13, 0x0

    .line 1075
    :cond_3d
    iget-object v6, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1076
    .line 1077
    invoke-virtual {v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 1078
    .line 1079
    .line 1080
    move-result v8

    .line 1081
    const/16 v18, 0x1

    .line 1082
    .line 1083
    xor-int/lit8 v27, v8, 0x1

    .line 1084
    .line 1085
    const/16 v14, 0x8

    .line 1086
    .line 1087
    const/16 v17, 0x0

    .line 1088
    .line 1089
    aget-boolean v21, v15, v17

    .line 1090
    .line 1091
    aget-boolean v34, v15, v18

    .line 1092
    .line 1093
    iget v8, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    .line 1094
    .line 1095
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    .line 1096
    .line 1097
    const/16 v35, 0x0

    .line 1098
    .line 1099
    const/4 v15, 0x2

    .line 1100
    if-eq v8, v15, :cond_40

    .line 1101
    .line 1102
    iget-boolean v8, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 1103
    .line 1104
    if-nez v8, :cond_40

    .line 1105
    .line 1106
    if-eqz p2, :cond_41

    .line 1107
    .line 1108
    iget-object v8, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 1109
    .line 1110
    if-eqz v8, :cond_41

    .line 1111
    .line 1112
    iget-object v14, v8, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 1113
    .line 1114
    iget-boolean v15, v14, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 1115
    .line 1116
    if-eqz v15, :cond_3e

    .line 1117
    .line 1118
    iget-object v8, v8, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 1119
    .line 1120
    iget-boolean v8, v8, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 1121
    .line 1122
    if-nez v8, :cond_3f

    .line 1123
    .line 1124
    :cond_3e
    const/16 v14, 0x8

    .line 1125
    .line 1126
    goto :goto_28

    .line 1127
    :cond_3f
    if-eqz p2, :cond_40

    .line 1128
    .line 1129
    iget v4, v14, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 1130
    .line 1131
    invoke-virtual {v1, v3, v4}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 1132
    .line 1133
    .line 1134
    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 1135
    .line 1136
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 1137
    .line 1138
    iget v4, v4, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 1139
    .line 1140
    invoke-virtual {v1, v5, v4}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 1141
    .line 1142
    .line 1143
    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1144
    .line 1145
    if-eqz v4, :cond_40

    .line 1146
    .line 1147
    if-eqz v22, :cond_40

    .line 1148
    .line 1149
    const/4 v13, 0x0

    .line 1150
    aget-boolean v4, v24, v13

    .line 1151
    .line 1152
    if-eqz v4, :cond_40

    .line 1153
    .line 1154
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isInHorizontalChain()Z

    .line 1155
    .line 1156
    .line 1157
    move-result v4

    .line 1158
    if-nez v4, :cond_40

    .line 1159
    .line 1160
    iget-object v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1161
    .line 1162
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1163
    .line 1164
    invoke-virtual {v1, v4}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1165
    .line 1166
    .line 1167
    move-result-object v4

    .line 1168
    const/16 v14, 0x8

    .line 1169
    .line 1170
    invoke-virtual {v1, v4, v5, v13, v14}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1171
    .line 1172
    .line 1173
    :cond_40
    move-object/from16 v55, v2

    .line 1174
    .line 1175
    move-object/from16 v49, v3

    .line 1176
    .line 1177
    move-object/from16 v50, v5

    .line 1178
    .line 1179
    move-object/from16 v41, v6

    .line 1180
    .line 1181
    move-object/from16 v46, v10

    .line 1182
    .line 1183
    move-object/from16 v53, v11

    .line 1184
    .line 1185
    move/from16 v19, v12

    .line 1186
    .line 1187
    move/from16 v3, v22

    .line 1188
    .line 1189
    move/from16 v4, v29

    .line 1190
    .line 1191
    move-object/from16 v51, v33

    .line 1192
    .line 1193
    move-object/from16 v54, v39

    .line 1194
    .line 1195
    move-object/from16 v52, v40

    .line 1196
    .line 1197
    move/from16 v22, v7

    .line 1198
    .line 1199
    move-object/from16 v29, v24

    .line 1200
    .line 1201
    goto/16 :goto_2d

    .line 1202
    .line 1203
    :cond_41
    :goto_28
    iget-object v8, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1204
    .line 1205
    if-eqz v8, :cond_42

    .line 1206
    .line 1207
    iget-object v8, v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1208
    .line 1209
    invoke-virtual {v1, v8}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1210
    .line 1211
    .line 1212
    move-result-object v8

    .line 1213
    goto :goto_29

    .line 1214
    :cond_42
    move-object/from16 v8, v35

    .line 1215
    .line 1216
    :goto_29
    iget-object v15, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1217
    .line 1218
    if-eqz v15, :cond_43

    .line 1219
    .line 1220
    iget-object v15, v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1221
    .line 1222
    invoke-virtual {v1, v15}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1223
    .line 1224
    .line 1225
    move-result-object v15

    .line 1226
    :goto_2a
    move-object/from16 v19, v5

    .line 1227
    .line 1228
    const/16 v17, 0x0

    .line 1229
    .line 1230
    goto :goto_2b

    .line 1231
    :cond_43
    move-object/from16 v15, v35

    .line 1232
    .line 1233
    goto :goto_2a

    .line 1234
    :goto_2b
    aget-boolean v5, v24, v17

    .line 1235
    .line 1236
    move-object/from16 v26, v3

    .line 1237
    .line 1238
    move/from16 v3, v22

    .line 1239
    .line 1240
    move/from16 v22, v7

    .line 1241
    .line 1242
    move-object v7, v8

    .line 1243
    aget v8, v28, v17

    .line 1244
    .line 1245
    move-object/from16 v36, v19

    .line 1246
    .line 1247
    move/from16 v19, v12

    .line 1248
    .line 1249
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 1250
    .line 1251
    const/16 v37, 0x8

    .line 1252
    .line 1253
    iget v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    .line 1254
    .line 1255
    move-object/from16 v41, v6

    .line 1256
    .line 1257
    move-object v6, v15

    .line 1258
    aget v15, v10, v17

    .line 1259
    .line 1260
    iget v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    .line 1261
    .line 1262
    move/from16 v42, v1

    .line 1263
    .line 1264
    const/16 v18, 0x1

    .line 1265
    .line 1266
    aget v1, v28, v18

    .line 1267
    .line 1268
    move-object/from16 v43, v2

    .line 1269
    .line 1270
    const/4 v2, 0x3

    .line 1271
    if-ne v1, v2, :cond_44

    .line 1272
    .line 1273
    goto :goto_2c

    .line 1274
    :cond_44
    const/16 v18, 0x0

    .line 1275
    .line 1276
    :goto_2c
    iget v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    .line 1277
    .line 1278
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    .line 1279
    .line 1280
    move/from16 v44, v1

    .line 1281
    .line 1282
    iget v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    .line 1283
    .line 1284
    move/from16 v25, v2

    .line 1285
    .line 1286
    const/16 v45, 0x2

    .line 1287
    .line 1288
    const/4 v2, 0x1

    .line 1289
    move-object/from16 v46, v10

    .line 1290
    .line 1291
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1292
    .line 1293
    move-object/from16 v47, v11

    .line 1294
    .line 1295
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1296
    .line 1297
    move/from16 v17, v4

    .line 1298
    .line 1299
    move-object/from16 v49, v26

    .line 1300
    .line 1301
    move/from16 v4, v29

    .line 1302
    .line 1303
    move-object/from16 v51, v33

    .line 1304
    .line 1305
    move-object/from16 v50, v36

    .line 1306
    .line 1307
    move-object/from16 v54, v39

    .line 1308
    .line 1309
    move-object/from16 v52, v40

    .line 1310
    .line 1311
    move/from16 v16, v42

    .line 1312
    .line 1313
    move-object/from16 v55, v43

    .line 1314
    .line 1315
    move-object/from16 v53, v47

    .line 1316
    .line 1317
    move/from16 v26, v1

    .line 1318
    .line 1319
    move-object/from16 v29, v24

    .line 1320
    .line 1321
    move/from16 v24, v44

    .line 1322
    .line 1323
    move-object/from16 v1, p1

    .line 1324
    .line 1325
    invoke-virtual/range {v0 .. v27}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->applyConstraints(Landroidx/constraintlayout/core/LinearSystem;ZZZZLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;IZLandroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIIIFZZZZZIIIIFZ)V

    .line 1326
    .line 1327
    .line 1328
    :goto_2d
    if-eqz p2, :cond_47

    .line 1329
    .line 1330
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 1331
    .line 1332
    if-eqz v2, :cond_47

    .line 1333
    .line 1334
    iget-object v5, v2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 1335
    .line 1336
    iget-boolean v6, v5, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 1337
    .line 1338
    if-eqz v6, :cond_47

    .line 1339
    .line 1340
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 1341
    .line 1342
    iget-boolean v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 1343
    .line 1344
    if-eqz v2, :cond_47

    .line 1345
    .line 1346
    iget v2, v5, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 1347
    .line 1348
    move-object/from16 v5, v51

    .line 1349
    .line 1350
    invoke-virtual {v1, v5, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 1351
    .line 1352
    .line 1353
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 1354
    .line 1355
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 1356
    .line 1357
    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 1358
    .line 1359
    move-object/from16 v6, v52

    .line 1360
    .line 1361
    invoke-virtual {v1, v6, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 1362
    .line 1363
    .line 1364
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 1365
    .line 1366
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->baseline:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 1367
    .line 1368
    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 1369
    .line 1370
    move-object/from16 v7, v53

    .line 1371
    .line 1372
    invoke-virtual {v1, v7, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    .line 1373
    .line 1374
    .line 1375
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1376
    .line 1377
    if-eqz v2, :cond_46

    .line 1378
    .line 1379
    if-nez v20, :cond_46

    .line 1380
    .line 1381
    if-eqz v4, :cond_46

    .line 1382
    .line 1383
    const/16 v18, 0x1

    .line 1384
    .line 1385
    aget-boolean v8, v29, v18

    .line 1386
    .line 1387
    if-eqz v8, :cond_45

    .line 1388
    .line 1389
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1390
    .line 1391
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1392
    .line 1393
    .line 1394
    move-result-object v2

    .line 1395
    const/4 v8, 0x0

    .line 1396
    const/16 v14, 0x8

    .line 1397
    .line 1398
    invoke-virtual {v1, v2, v6, v8, v14}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1399
    .line 1400
    .line 1401
    goto :goto_2e

    .line 1402
    :cond_45
    const/4 v8, 0x0

    .line 1403
    const/16 v14, 0x8

    .line 1404
    .line 1405
    goto :goto_2e

    .line 1406
    :cond_46
    const/4 v8, 0x0

    .line 1407
    const/16 v14, 0x8

    .line 1408
    .line 1409
    const/16 v18, 0x1

    .line 1410
    .line 1411
    :goto_2e
    const/4 v15, 0x0

    .line 1412
    goto :goto_2f

    .line 1413
    :cond_47
    move-object/from16 v5, v51

    .line 1414
    .line 1415
    move-object/from16 v6, v52

    .line 1416
    .line 1417
    move-object/from16 v7, v53

    .line 1418
    .line 1419
    const/4 v8, 0x0

    .line 1420
    const/16 v14, 0x8

    .line 1421
    .line 1422
    const/16 v18, 0x1

    .line 1423
    .line 1424
    const/4 v15, 0x1

    .line 1425
    :goto_2f
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    .line 1426
    .line 1427
    const/4 v9, 0x2

    .line 1428
    if-ne v2, v9, :cond_48

    .line 1429
    .line 1430
    const/4 v15, 0x0

    .line 1431
    :cond_48
    const/4 v2, 0x5

    .line 1432
    if-eqz v15, :cond_53

    .line 1433
    .line 1434
    iget-boolean v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 1435
    .line 1436
    if-nez v10, :cond_53

    .line 1437
    .line 1438
    aget v10, v28, v18

    .line 1439
    .line 1440
    if-ne v10, v9, :cond_49

    .line 1441
    .line 1442
    instance-of v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 1443
    .line 1444
    if-eqz v10, :cond_49

    .line 1445
    .line 1446
    const/4 v15, 0x1

    .line 1447
    goto :goto_30

    .line 1448
    :cond_49
    const/4 v15, 0x0

    .line 1449
    :goto_30
    if-eqz v15, :cond_4a

    .line 1450
    .line 1451
    const/4 v13, 0x0

    .line 1452
    goto :goto_31

    .line 1453
    :cond_4a
    move/from16 v13, v30

    .line 1454
    .line 1455
    :goto_31
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1456
    .line 1457
    if-eqz v10, :cond_4b

    .line 1458
    .line 1459
    iget-object v10, v10, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1460
    .line 1461
    invoke-virtual {v1, v10}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1462
    .line 1463
    .line 1464
    move-result-object v10

    .line 1465
    goto :goto_32

    .line 1466
    :cond_4b
    move-object/from16 v10, v35

    .line 1467
    .line 1468
    :goto_32
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1469
    .line 1470
    if-eqz v11, :cond_4c

    .line 1471
    .line 1472
    iget-object v11, v11, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1473
    .line 1474
    invoke-virtual {v1, v11}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1475
    .line 1476
    .line 1477
    move-result-object v35

    .line 1478
    :cond_4c
    iget v11, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    .line 1479
    .line 1480
    if-gtz v11, :cond_4d

    .line 1481
    .line 1482
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 1483
    .line 1484
    if-ne v12, v14, :cond_51

    .line 1485
    .line 1486
    :cond_4d
    move-object/from16 v12, v55

    .line 1487
    .line 1488
    iget-object v9, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1489
    .line 1490
    if-eqz v9, :cond_4f

    .line 1491
    .line 1492
    invoke-virtual {v1, v7, v5, v11, v14}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1493
    .line 1494
    .line 1495
    iget-object v9, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1496
    .line 1497
    invoke-virtual {v1, v9}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1498
    .line 1499
    .line 1500
    move-result-object v9

    .line 1501
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    .line 1502
    .line 1503
    .line 1504
    move-result v11

    .line 1505
    invoke-virtual {v1, v7, v9, v11, v14}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1506
    .line 1507
    .line 1508
    if-eqz v4, :cond_4e

    .line 1509
    .line 1510
    move-object/from16 v7, v54

    .line 1511
    .line 1512
    invoke-virtual {v1, v7}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1513
    .line 1514
    .line 1515
    move-result-object v7

    .line 1516
    invoke-virtual {v1, v10, v7, v8, v2}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1517
    .line 1518
    .line 1519
    :cond_4e
    const/16 v27, 0x0

    .line 1520
    .line 1521
    goto :goto_33

    .line 1522
    :cond_4f
    iget v9, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 1523
    .line 1524
    if-ne v9, v14, :cond_50

    .line 1525
    .line 1526
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    .line 1527
    .line 1528
    .line 1529
    move-result v9

    .line 1530
    invoke-virtual {v1, v7, v5, v9, v14}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1531
    .line 1532
    .line 1533
    goto :goto_33

    .line 1534
    :cond_50
    invoke-virtual {v1, v7, v5, v11, v14}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1535
    .line 1536
    .line 1537
    :cond_51
    :goto_33
    aget-boolean v7, v29, v18

    .line 1538
    .line 1539
    const/16 v17, 0x0

    .line 1540
    .line 1541
    aget v8, v28, v18

    .line 1542
    .line 1543
    iget v12, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 1544
    .line 1545
    iget v14, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    .line 1546
    .line 1547
    aget v9, v46, v18

    .line 1548
    .line 1549
    iget v11, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    .line 1550
    .line 1551
    aget v2, v28, v17

    .line 1552
    .line 1553
    const/4 v1, 0x3

    .line 1554
    if-ne v2, v1, :cond_52

    .line 1555
    .line 1556
    :goto_34
    const/16 v16, 0x1

    .line 1557
    .line 1558
    goto :goto_35

    .line 1559
    :cond_52
    const/16 v18, 0x0

    .line 1560
    .line 1561
    goto :goto_34

    .line 1562
    :goto_35
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    .line 1563
    .line 1564
    iget v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    .line 1565
    .line 1566
    move/from16 v21, v1

    .line 1567
    .line 1568
    iget v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    .line 1569
    .line 1570
    move/from16 v24, v2

    .line 1571
    .line 1572
    const/4 v2, 0x0

    .line 1573
    move-object/from16 v33, v5

    .line 1574
    .line 1575
    move v5, v7

    .line 1576
    move-object v7, v10

    .line 1577
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1578
    .line 1579
    move/from16 v16, v11

    .line 1580
    .line 1581
    const/16 v48, 0x1

    .line 1582
    .line 1583
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1584
    .line 1585
    move/from16 v17, v4

    .line 1586
    .line 1587
    move v4, v3

    .line 1588
    move/from16 v3, v17

    .line 1589
    .line 1590
    move/from16 v17, v15

    .line 1591
    .line 1592
    move v15, v9

    .line 1593
    move/from16 v9, v17

    .line 1594
    .line 1595
    move/from16 v17, v20

    .line 1596
    .line 1597
    move/from16 v20, v19

    .line 1598
    .line 1599
    move/from16 v19, v17

    .line 1600
    .line 1601
    move/from16 v17, v23

    .line 1602
    .line 1603
    move/from16 v23, v22

    .line 1604
    .line 1605
    move/from16 v22, v17

    .line 1606
    .line 1607
    move/from16 v26, v1

    .line 1608
    .line 1609
    move-object/from16 v57, v6

    .line 1610
    .line 1611
    move/from16 v25, v21

    .line 1612
    .line 1613
    move/from16 v17, v32

    .line 1614
    .line 1615
    move-object/from16 v56, v33

    .line 1616
    .line 1617
    move/from16 v21, v34

    .line 1618
    .line 1619
    move-object/from16 v6, v35

    .line 1620
    .line 1621
    move-object/from16 v1, p1

    .line 1622
    .line 1623
    invoke-virtual/range {v0 .. v27}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->applyConstraints(Landroidx/constraintlayout/core/LinearSystem;ZZZZLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;IZLandroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIIIFZZZZZIIIIFZ)V

    .line 1624
    .line 1625
    .line 1626
    goto :goto_36

    .line 1627
    :cond_53
    move-object/from16 v56, v5

    .line 1628
    .line 1629
    move-object/from16 v57, v6

    .line 1630
    .line 1631
    :goto_36
    if-eqz v31, :cond_55

    .line 1632
    .line 1633
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 1634
    .line 1635
    const/high16 v3, -0x40800000    # -1.0f

    .line 1636
    .line 1637
    const/4 v14, 0x1

    .line 1638
    if-ne v2, v14, :cond_54

    .line 1639
    .line 1640
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 1641
    .line 1642
    invoke-virtual {v1}, Landroidx/constraintlayout/core/LinearSystem;->createRow()Landroidx/constraintlayout/core/ArrayRow;

    .line 1643
    .line 1644
    .line 1645
    move-result-object v4

    .line 1646
    iget-object v5, v4, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1647
    .line 1648
    move-object/from16 v6, v57

    .line 1649
    .line 1650
    invoke-virtual {v5, v6, v3}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1651
    .line 1652
    .line 1653
    iget-object v3, v4, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1654
    .line 1655
    move-object/from16 v5, v56

    .line 1656
    .line 1657
    const/high16 v7, 0x3f800000    # 1.0f

    .line 1658
    .line 1659
    invoke-virtual {v3, v5, v7}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1660
    .line 1661
    .line 1662
    iget-object v3, v4, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1663
    .line 1664
    move-object/from16 v8, v50

    .line 1665
    .line 1666
    invoke-virtual {v3, v8, v2}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1667
    .line 1668
    .line 1669
    iget-object v3, v4, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1670
    .line 1671
    neg-float v2, v2

    .line 1672
    move-object/from16 v9, v49

    .line 1673
    .line 1674
    invoke-virtual {v3, v9, v2}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1675
    .line 1676
    .line 1677
    invoke-virtual {v1, v4}, Landroidx/constraintlayout/core/LinearSystem;->addConstraint(Landroidx/constraintlayout/core/ArrayRow;)V

    .line 1678
    .line 1679
    .line 1680
    goto :goto_37

    .line 1681
    :cond_54
    move-object/from16 v9, v49

    .line 1682
    .line 1683
    move-object/from16 v8, v50

    .line 1684
    .line 1685
    move-object/from16 v5, v56

    .line 1686
    .line 1687
    move-object/from16 v6, v57

    .line 1688
    .line 1689
    const/high16 v7, 0x3f800000    # 1.0f

    .line 1690
    .line 1691
    iget v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 1692
    .line 1693
    invoke-virtual {v1}, Landroidx/constraintlayout/core/LinearSystem;->createRow()Landroidx/constraintlayout/core/ArrayRow;

    .line 1694
    .line 1695
    .line 1696
    move-result-object v4

    .line 1697
    iget-object v10, v4, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1698
    .line 1699
    invoke-virtual {v10, v8, v3}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1700
    .line 1701
    .line 1702
    iget-object v3, v4, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1703
    .line 1704
    invoke-virtual {v3, v9, v7}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1705
    .line 1706
    .line 1707
    iget-object v3, v4, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1708
    .line 1709
    invoke-virtual {v3, v6, v2}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1710
    .line 1711
    .line 1712
    iget-object v3, v4, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1713
    .line 1714
    neg-float v2, v2

    .line 1715
    invoke-virtual {v3, v5, v2}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1716
    .line 1717
    .line 1718
    invoke-virtual {v1, v4}, Landroidx/constraintlayout/core/LinearSystem;->addConstraint(Landroidx/constraintlayout/core/ArrayRow;)V

    .line 1719
    .line 1720
    .line 1721
    :cond_55
    :goto_37
    invoke-virtual/range {v41 .. v41}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    .line 1722
    .line 1723
    .line 1724
    move-result v2

    .line 1725
    if-eqz v2, :cond_56

    .line 1726
    .line 1727
    move-object/from16 v2, v41

    .line 1728
    .line 1729
    iget-object v3, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1730
    .line 1731
    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1732
    .line 1733
    iget v4, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    .line 1734
    .line 1735
    const/high16 v5, 0x42b40000    # 90.0f

    .line 1736
    .line 1737
    add-float/2addr v4, v5

    .line 1738
    float-to-double v4, v4

    .line 1739
    invoke-static {v4, v5}, Ljava/lang/Math;->toRadians(D)D

    .line 1740
    .line 1741
    .line 1742
    move-result-wide v4

    .line 1743
    double-to-float v4, v4

    .line 1744
    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    .line 1745
    .line 1746
    .line 1747
    move-result v2

    .line 1748
    const/4 v15, 0x2

    .line 1749
    invoke-virtual {v0, v15}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1750
    .line 1751
    .line 1752
    move-result-object v5

    .line 1753
    invoke-virtual {v1, v5}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1754
    .line 1755
    .line 1756
    move-result-object v5

    .line 1757
    const/4 v7, 0x3

    .line 1758
    invoke-virtual {v0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1759
    .line 1760
    .line 1761
    move-result-object v6

    .line 1762
    invoke-virtual {v1, v6}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1763
    .line 1764
    .line 1765
    move-result-object v6

    .line 1766
    const/4 v8, 0x4

    .line 1767
    invoke-virtual {v0, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1768
    .line 1769
    .line 1770
    move-result-object v9

    .line 1771
    invoke-virtual {v1, v9}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1772
    .line 1773
    .line 1774
    move-result-object v9

    .line 1775
    const/4 v10, 0x5

    .line 1776
    invoke-virtual {v0, v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1777
    .line 1778
    .line 1779
    move-result-object v11

    .line 1780
    invoke-virtual {v1, v11}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1781
    .line 1782
    .line 1783
    move-result-object v11

    .line 1784
    invoke-virtual {v3, v15}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1785
    .line 1786
    .line 1787
    move-result-object v12

    .line 1788
    invoke-virtual {v1, v12}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1789
    .line 1790
    .line 1791
    move-result-object v12

    .line 1792
    invoke-virtual {v3, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1793
    .line 1794
    .line 1795
    move-result-object v7

    .line 1796
    invoke-virtual {v1, v7}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1797
    .line 1798
    .line 1799
    move-result-object v7

    .line 1800
    invoke-virtual {v3, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1801
    .line 1802
    .line 1803
    move-result-object v8

    .line 1804
    invoke-virtual {v1, v8}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1805
    .line 1806
    .line 1807
    move-result-object v8

    .line 1808
    invoke-virtual {v3, v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1809
    .line 1810
    .line 1811
    move-result-object v3

    .line 1812
    invoke-virtual {v1, v3}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1813
    .line 1814
    .line 1815
    move-result-object v3

    .line 1816
    invoke-virtual {v1}, Landroidx/constraintlayout/core/LinearSystem;->createRow()Landroidx/constraintlayout/core/ArrayRow;

    .line 1817
    .line 1818
    .line 1819
    move-result-object v10

    .line 1820
    float-to-double v13, v4

    .line 1821
    invoke-static {v13, v14}, Ljava/lang/Math;->sin(D)D

    .line 1822
    .line 1823
    .line 1824
    move-result-wide v15

    .line 1825
    move-wide/from16 v17, v13

    .line 1826
    .line 1827
    int-to-double v13, v2

    .line 1828
    move-wide/from16 v19, v13

    .line 1829
    .line 1830
    mul-double v13, v15, v19

    .line 1831
    .line 1832
    double-to-float v2, v13

    .line 1833
    iget-object v4, v10, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1834
    .line 1835
    const/high16 v13, 0x3f000000    # 0.5f

    .line 1836
    .line 1837
    invoke-virtual {v4, v7, v13}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1838
    .line 1839
    .line 1840
    iget-object v4, v10, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1841
    .line 1842
    invoke-virtual {v4, v3, v13}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1843
    .line 1844
    .line 1845
    iget-object v3, v10, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1846
    .line 1847
    const/high16 v4, -0x41000000    # -0.5f

    .line 1848
    .line 1849
    invoke-virtual {v3, v6, v4}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1850
    .line 1851
    .line 1852
    iget-object v3, v10, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1853
    .line 1854
    invoke-virtual {v3, v11, v4}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1855
    .line 1856
    .line 1857
    neg-float v2, v2

    .line 1858
    iput v2, v10, Landroidx/constraintlayout/core/ArrayRow;->mConstantValue:F

    .line 1859
    .line 1860
    invoke-virtual {v1, v10}, Landroidx/constraintlayout/core/LinearSystem;->addConstraint(Landroidx/constraintlayout/core/ArrayRow;)V

    .line 1861
    .line 1862
    .line 1863
    invoke-virtual {v1}, Landroidx/constraintlayout/core/LinearSystem;->createRow()Landroidx/constraintlayout/core/ArrayRow;

    .line 1864
    .line 1865
    .line 1866
    move-result-object v2

    .line 1867
    invoke-static/range {v17 .. v18}, Ljava/lang/Math;->cos(D)D

    .line 1868
    .line 1869
    .line 1870
    move-result-wide v6

    .line 1871
    mul-double v6, v6, v19

    .line 1872
    .line 1873
    double-to-float v3, v6

    .line 1874
    iget-object v6, v2, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1875
    .line 1876
    invoke-virtual {v6, v12, v13}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1877
    .line 1878
    .line 1879
    iget-object v6, v2, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1880
    .line 1881
    invoke-virtual {v6, v8, v13}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1882
    .line 1883
    .line 1884
    iget-object v6, v2, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1885
    .line 1886
    invoke-virtual {v6, v5, v4}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1887
    .line 1888
    .line 1889
    iget-object v5, v2, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    .line 1890
    .line 1891
    invoke-virtual {v5, v9, v4}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 1892
    .line 1893
    .line 1894
    neg-float v3, v3

    .line 1895
    iput v3, v2, Landroidx/constraintlayout/core/ArrayRow;->mConstantValue:F

    .line 1896
    .line 1897
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->addConstraint(Landroidx/constraintlayout/core/ArrayRow;)V

    .line 1898
    .line 1899
    .line 1900
    :cond_56
    const/4 v2, 0x0

    .line 1901
    iput-boolean v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 1902
    .line 1903
    iput-boolean v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 1904
    .line 1905
    return-void
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

.method public allowedInBarrier()Z
    .locals 2

    .line 1
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 2
    .line 3
    const/16 v1, 0x8

    .line 4
    .line 5
    if-eq v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    return v0

    .line 9
    :cond_0
    const/4 v0, 0x0

    .line 10
    return v0
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

.method public final applyConstraints(Landroidx/constraintlayout/core/LinearSystem;ZZZZLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;IZLandroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIIIFZZZZZIIIIFZ)V
    .locals 29

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v12, p10

    move-object/from16 v13, p11

    move/from16 v14, p14

    move/from16 v2, p15

    move/from16 v4, p24

    move/from16 v5, p25

    move/from16 v6, p26

    .line 1
    invoke-virtual {v1, v12}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v7

    .line 2
    invoke-virtual {v1, v13}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v8

    .line 3
    iget-object v9, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 4
    invoke-virtual {v1, v9}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v9

    .line 5
    iget-object v15, v13, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 6
    invoke-virtual {v1, v15}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v15

    .line 7
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v16

    .line 8
    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v17

    .line 9
    iget-object v11, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-virtual {v11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v11

    if-eqz v17, :cond_0

    add-int/lit8 v18, v16, 0x1

    goto :goto_0

    :cond_0
    move/from16 v18, v16

    :goto_0
    if-eqz v11, :cond_1

    add-int/lit8 v18, v18, 0x1

    :cond_1
    move/from16 v19, v11

    move/from16 v11, v18

    if-eqz p17, :cond_2

    const/4 v3, 0x3

    goto :goto_1

    :cond_2
    move/from16 v3, p22

    .line 10
    :goto_1
    invoke-static/range {p8 .. p8}, Landroidx/constraintlayout/core/SolverVariable$Type$EnumUnboxingSharedUtility;->ordinal(I)I

    move-result v13

    const/4 v10, 0x1

    move-object/from16 v20, v15

    if-eqz v13, :cond_3

    if-eq v13, v10, :cond_3

    const/4 v10, 0x2

    if-eq v13, v10, :cond_4

    :cond_3
    const/4 v10, 0x0

    goto :goto_2

    :cond_4
    const/4 v10, 0x4

    if-eq v3, v10, :cond_3

    const/4 v10, 0x1

    .line 11
    :goto_2
    iget v13, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    const/4 v15, -0x1

    if-eq v13, v15, :cond_5

    if-eqz p2, :cond_5

    .line 12
    iput v15, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    const/16 p13, 0x0

    goto :goto_3

    :cond_5
    move/from16 v13, p13

    move/from16 p13, v10

    .line 13
    :goto_3
    iget v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    if-eq v10, v15, :cond_6

    if-nez p2, :cond_6

    .line 14
    iput v15, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    move v13, v10

    const/4 v10, 0x0

    goto :goto_4

    :cond_6
    move/from16 v10, p13

    .line 15
    :goto_4
    iget v15, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    move/from16 p13, v10

    const/16 v10, 0x8

    if-ne v15, v10, :cond_7

    const/4 v13, 0x0

    const/4 v15, 0x0

    goto :goto_5

    :cond_7
    move v15, v13

    move/from16 v13, p13

    :goto_5
    if-eqz p27, :cond_8

    if-nez v16, :cond_9

    if-nez v17, :cond_9

    if-nez v19, :cond_9

    move/from16 v10, p12

    .line 16
    invoke-virtual {v1, v7, v10}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;I)V

    :cond_8
    move/from16 v24, v13

    const/16 v13, 0x8

    goto :goto_6

    :cond_9
    if-eqz v16, :cond_8

    if-nez v17, :cond_8

    .line 17
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v10

    move/from16 v24, v13

    const/16 v13, 0x8

    .line 18
    invoke-virtual {v1, v7, v9, v10, v13}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :goto_6
    if-nez v24, :cond_d

    if-eqz p9, :cond_b

    const/4 v6, 0x3

    const/4 v10, 0x0

    .line 19
    invoke-virtual {v1, v8, v7, v10, v6}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    if-lez v14, :cond_a

    .line 20
    invoke-virtual {v1, v8, v7, v14, v13}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_a
    const v6, 0x7fffffff

    if-ge v2, v6, :cond_c

    .line 21
    invoke-virtual {v1, v8, v7, v2, v13}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_7

    .line 22
    :cond_b
    invoke-virtual {v1, v8, v7, v15, v13}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_c
    :goto_7
    move/from16 v10, p5

    move v13, v4

    goto/16 :goto_b

    :cond_d
    const/4 v10, 0x2

    if-eq v11, v10, :cond_10

    if-nez p17, :cond_10

    const/4 v2, 0x1

    if-eq v3, v2, :cond_e

    if-nez v3, :cond_10

    .line 23
    :cond_e
    invoke-static {v4, v15}, Ljava/lang/Math;->max(II)I

    move-result v2

    if-lez v5, :cond_f

    .line 24
    invoke-static {v5, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    :cond_f
    const/16 v13, 0x8

    .line 25
    invoke-virtual {v1, v8, v7, v2, v13}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    move/from16 v10, p5

    move v13, v4

    const/16 v24, 0x0

    goto/16 :goto_b

    :cond_10
    const/4 v2, -0x2

    if-ne v4, v2, :cond_11

    move v4, v15

    :cond_11
    if-ne v5, v2, :cond_12

    move v5, v15

    :cond_12
    if-lez v15, :cond_13

    const/4 v2, 0x1

    if-eq v3, v2, :cond_13

    const/4 v15, 0x0

    :cond_13
    const/16 v13, 0x8

    if-lez v4, :cond_14

    .line 26
    invoke-virtual {v1, v8, v7, v4, v13}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 27
    invoke-static {v15, v4}, Ljava/lang/Math;->max(II)I

    move-result v15

    :cond_14
    const/4 v2, 0x1

    if-lez v5, :cond_16

    if-eqz p3, :cond_15

    if-ne v3, v2, :cond_15

    goto :goto_8

    .line 28
    :cond_15
    invoke-virtual {v1, v8, v7, v5, v13}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 29
    :goto_8
    invoke-static {v15, v5}, Ljava/lang/Math;->min(II)I

    move-result v15

    :cond_16
    if-ne v3, v2, :cond_19

    if-eqz p3, :cond_17

    .line 30
    invoke-virtual {v1, v8, v7, v15, v13}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    const/4 v2, 0x5

    goto :goto_7

    :cond_17
    if-eqz p19, :cond_18

    const/4 v2, 0x5

    .line 31
    invoke-virtual {v1, v8, v7, v15, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 32
    invoke-virtual {v1, v8, v7, v15, v13}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_7

    :cond_18
    const/4 v2, 0x5

    .line 33
    invoke-virtual {v1, v8, v7, v15, v2}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 34
    invoke-virtual {v1, v8, v7, v15, v13}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    goto :goto_7

    :cond_19
    const/4 v2, 0x5

    const/4 v10, 0x2

    if-ne v3, v10, :cond_1d

    .line 35
    iget v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mType:I

    const/4 v15, 0x3

    if-eq v13, v15, :cond_1a

    if-ne v13, v2, :cond_1b

    :cond_1a
    const/4 v13, 0x4

    goto :goto_9

    .line 36
    :cond_1b
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 37
    invoke-virtual {v2, v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v2

    .line 38
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v2

    .line 39
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v13, 0x4

    .line 40
    invoke-virtual {v10, v13}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v10

    .line 41
    invoke-virtual {v1, v10}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v10

    goto :goto_a

    .line 42
    :goto_9
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v15, 0x3

    .line 43
    invoke-virtual {v2, v15}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v2

    .line 44
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v2

    .line 45
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/4 v15, 0x5

    .line 46
    invoke-virtual {v10, v15}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v10

    .line 47
    invoke-virtual {v1, v10}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    move-result-object v10

    .line 48
    :goto_a
    invoke-virtual {v1}, Landroidx/constraintlayout/core/LinearSystem;->createRow()Landroidx/constraintlayout/core/ArrayRow;

    move-result-object v15

    .line 49
    iget-object v13, v15, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    move/from16 p9, v4

    const/high16 v4, -0x40800000    # -1.0f

    invoke-virtual {v13, v8, v4}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 50
    iget-object v4, v15, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    const/high16 v13, 0x3f800000    # 1.0f

    invoke-virtual {v4, v7, v13}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 51
    iget-object v4, v15, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    invoke-virtual {v4, v10, v6}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 52
    iget-object v4, v15, Landroidx/constraintlayout/core/ArrayRow;->variables:Landroidx/constraintlayout/core/ArrayLinkedVariables;

    neg-float v6, v6

    invoke-virtual {v4, v2, v6}, Landroidx/constraintlayout/core/ArrayLinkedVariables;->put(Landroidx/constraintlayout/core/SolverVariable;F)V

    .line 53
    invoke-virtual {v1, v15}, Landroidx/constraintlayout/core/LinearSystem;->addConstraint(Landroidx/constraintlayout/core/ArrayRow;)V

    if-eqz p3, :cond_1c

    const/16 v24, 0x0

    :cond_1c
    move/from16 v10, p5

    move/from16 v13, p9

    goto :goto_b

    :cond_1d
    move/from16 p9, v4

    move/from16 v13, p9

    const/4 v10, 0x1

    :goto_b
    if-eqz p27, :cond_1e

    if-eqz p19, :cond_1f

    :cond_1e
    move-object/from16 v15, p6

    move-object/from16 v4, p7

    move-object v2, v7

    move-object v7, v8

    move/from16 p5, v10

    const/4 v3, 0x3

    const/4 v10, 0x2

    goto/16 :goto_2c

    :cond_1f
    if-nez v16, :cond_20

    if-nez v17, :cond_20

    if-nez v19, :cond_20

    move-object/from16 v13, p11

    move-object v7, v8

    move/from16 p5, v10

    move-object/from16 v6, v20

    :goto_c
    const/4 v4, 0x5

    goto/16 :goto_28

    :cond_20
    if-eqz v16, :cond_22

    if-nez v17, :cond_22

    .line 54
    iget-object v2, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-eqz p3, :cond_21

    .line 55
    instance-of v2, v2, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v2, :cond_21

    const/16 v2, 0x8

    goto :goto_d

    :cond_21
    const/4 v2, 0x5

    :goto_d
    move-object/from16 v13, p11

    move-object v7, v8

    move/from16 p5, v10

    move-object/from16 v6, v20

    move/from16 v20, p3

    move v10, v2

    goto/16 :goto_29

    :cond_22
    if-nez v16, :cond_24

    if-eqz v17, :cond_24

    .line 56
    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    neg-int v2, v2

    move-object/from16 v6, v20

    const/16 v13, 0x8

    .line 57
    invoke-virtual {v1, v8, v6, v2, v13}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    if-eqz p3, :cond_23

    move-object/from16 v15, p6

    const/4 v2, 0x5

    const/4 v3, 0x0

    .line 58
    invoke-virtual {v1, v7, v15, v3, v2}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_23
    move-object/from16 v13, p11

    move-object v7, v8

    move/from16 p5, v10

    goto :goto_c

    :cond_24
    move-object/from16 v15, p6

    move-object/from16 v6, v20

    if-eqz v16, :cond_23

    if-eqz v17, :cond_23

    .line 59
    iget-object v2, v12, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v11, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move-object/from16 v2, p11

    .line 60
    iget-object v4, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    move/from16 p5, v10

    .line 61
    iget-object v10, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    const/16 v16, 0x6

    if-eqz v24, :cond_39

    if-nez v3, :cond_29

    if-nez v5, :cond_26

    if-nez v13, :cond_26

    .line 62
    iget-boolean v5, v9, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v5, :cond_25

    iget-boolean v5, v6, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v5, :cond_25

    .line 63
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    const/16 v13, 0x8

    .line 64
    invoke-virtual {v1, v7, v9, v3, v13}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 65
    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v2

    neg-int v2, v2

    .line 66
    invoke-virtual {v1, v8, v6, v2, v13}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    return-void

    :cond_25
    const/16 v5, 0x8

    const/16 v17, 0x8

    const/16 v19, 0x0

    const/16 v20, 0x1

    const/16 v23, 0x0

    goto :goto_e

    :cond_26
    const/4 v5, 0x5

    const/16 v17, 0x5

    const/16 v19, 0x1

    const/16 v20, 0x0

    const/16 v23, 0x1

    .line 67
    :goto_e
    instance-of v1, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v1, :cond_28

    instance-of v1, v4, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v1, :cond_27

    goto :goto_10

    :cond_27
    move-object/from16 v1, p1

    move-object v2, v7

    move-object v7, v8

    move/from16 v25, v20

    move v8, v5

    move-object v5, v9

    move/from16 v20, v19

    const/4 v9, 0x6

    move/from16 v19, v17

    move/from16 v17, v3

    :goto_f
    move-object/from16 v3, p7

    goto/16 :goto_1d

    :cond_28
    :goto_10
    move-object/from16 v1, p1

    move/from16 v17, v3

    move-object v2, v7

    move-object v7, v8

    move/from16 v25, v20

    move-object/from16 v3, p7

    move v8, v5

    move-object v5, v9

    move/from16 v20, v19

    const/4 v9, 0x6

    const/16 v19, 0x4

    goto/16 :goto_1d

    :cond_29
    const/4 v1, 0x2

    if-ne v3, v1, :cond_2c

    .line 68
    instance-of v1, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v1, :cond_2b

    instance-of v1, v4, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v1, :cond_2a

    goto :goto_12

    :cond_2a
    move-object/from16 v1, p1

    move/from16 v17, v3

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v8, 0x5

    const/4 v9, 0x6

    const/16 v19, 0x5

    :goto_11
    const/16 v20, 0x1

    const/16 v23, 0x1

    const/16 v25, 0x0

    goto :goto_f

    :cond_2b
    :goto_12
    move-object/from16 v1, p1

    move/from16 v17, v3

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v8, 0x5

    :goto_13
    const/4 v9, 0x6

    const/16 v19, 0x4

    goto :goto_11

    :cond_2c
    const/4 v1, 0x1

    if-ne v3, v1, :cond_2d

    move-object/from16 v1, p1

    move/from16 v17, v3

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/16 v8, 0x8

    goto :goto_13

    :cond_2d
    const/4 v1, 0x3

    if-ne v3, v1, :cond_38

    .line 69
    iget v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    move/from16 v17, v3

    const/4 v3, -0x1

    if-ne v1, v3, :cond_30

    if-eqz p20, :cond_2f

    move-object/from16 v1, p1

    move-object/from16 v3, p7

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/16 v8, 0x8

    if-eqz p3, :cond_2e

    const/4 v9, 0x5

    :goto_14
    const/16 v19, 0x5

    :goto_15
    const/16 v20, 0x1

    const/16 v23, 0x1

    const/16 v25, 0x1

    goto/16 :goto_1d

    :cond_2e
    const/4 v9, 0x4

    goto :goto_14

    :cond_2f
    move-object/from16 v1, p1

    move-object/from16 v3, p7

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/16 v8, 0x8

    const/16 v9, 0x8

    goto :goto_14

    :cond_30
    if-eqz p17, :cond_33

    move/from16 v3, p23

    const/4 v1, 0x2

    if-eq v3, v1, :cond_32

    const/4 v1, 0x1

    if-ne v3, v1, :cond_31

    goto :goto_16

    :cond_31
    const/16 v1, 0x8

    const/4 v3, 0x5

    goto :goto_17

    :cond_32
    :goto_16
    const/4 v1, 0x5

    const/4 v3, 0x4

    :goto_17
    move/from16 v19, v3

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v9, 0x6

    const/16 v20, 0x1

    const/16 v23, 0x1

    const/16 v25, 0x1

    move-object/from16 v3, p7

    :goto_18
    move v8, v1

    move-object/from16 v1, p1

    goto/16 :goto_1d

    :cond_33
    if-lez v5, :cond_34

    move-object/from16 v1, p1

    move-object/from16 v3, p7

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v8, 0x5

    const/4 v9, 0x6

    goto :goto_14

    :cond_34
    if-nez v5, :cond_37

    if-nez v13, :cond_37

    if-nez p20, :cond_35

    move-object/from16 v1, p1

    move-object/from16 v3, p7

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v8, 0x5

    const/4 v9, 0x6

    const/16 v19, 0x8

    goto :goto_15

    :cond_35
    if-eq v11, v10, :cond_36

    if-eq v4, v10, :cond_36

    const/4 v1, 0x4

    goto :goto_19

    :cond_36
    const/4 v1, 0x5

    :goto_19
    move-object/from16 v3, p7

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v9, 0x6

    const/16 v19, 0x4

    const/16 v20, 0x1

    const/16 v23, 0x1

    const/16 v25, 0x1

    goto :goto_18

    :cond_37
    move-object/from16 v1, p1

    move-object/from16 v3, p7

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v8, 0x5

    const/4 v9, 0x6

    const/16 v19, 0x4

    goto :goto_15

    :cond_38
    move/from16 v17, v3

    move-object/from16 v1, p1

    move-object/from16 v3, p7

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v8, 0x5

    const/4 v9, 0x6

    const/16 v19, 0x4

    const/16 v20, 0x0

    const/16 v23, 0x0

    :goto_1a
    const/16 v25, 0x0

    goto :goto_1d

    :cond_39
    move/from16 v17, v3

    .line 70
    iget-boolean v1, v9, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v1, :cond_3b

    iget-boolean v1, v6, Landroidx/constraintlayout/core/SolverVariable;->isFinalValue:Z

    if-eqz v1, :cond_3b

    .line 71
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v1

    .line 72
    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    const/16 v4, 0x8

    move-object/from16 p17, p1

    move/from16 p21, p16

    move/from16 p20, v1

    move/from16 p24, v3

    move-object/from16 p22, v6

    move-object/from16 p18, v7

    move-object/from16 p23, v8

    move-object/from16 p19, v9

    const/16 p25, 0x8

    .line 73
    invoke-virtual/range {p17 .. p25}, Landroidx/constraintlayout/core/LinearSystem;->addCentering(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;IFLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    move-object/from16 v1, p17

    move-object/from16 v7, p23

    if-eqz p3, :cond_5a

    if-eqz p5, :cond_5a

    .line 74
    iget-object v3, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v3, :cond_3a

    .line 75
    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v15

    :goto_1b
    move-object/from16 v3, p7

    goto :goto_1c

    :cond_3a
    const/4 v15, 0x0

    goto :goto_1b

    :goto_1c
    if-eq v6, v3, :cond_5a

    const/4 v2, 0x5

    .line 76
    invoke-virtual {v1, v3, v7, v15, v2}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    return-void

    :cond_3b
    move-object/from16 v1, p1

    move-object/from16 v3, p7

    move-object v2, v7

    move-object v7, v8

    move-object v5, v9

    const/4 v8, 0x5

    const/4 v9, 0x6

    const/16 v19, 0x4

    const/16 v20, 0x1

    const/16 v23, 0x1

    goto :goto_1a

    :goto_1d
    if-eqz v23, :cond_3c

    if-ne v5, v6, :cond_3c

    if-eq v11, v10, :cond_3c

    const/16 v23, 0x0

    const/16 v26, 0x0

    goto :goto_1e

    :cond_3c
    const/16 v26, 0x1

    :goto_1e
    if-eqz v20, :cond_3e

    if-nez v24, :cond_3d

    if-nez p18, :cond_3d

    if-nez p20, :cond_3d

    if-ne v5, v15, :cond_3d

    if-ne v6, v3, :cond_3d

    const/16 v9, 0x8

    const/16 v20, 0x0

    const/16 v26, 0x8

    const/16 v27, 0x0

    :goto_1f
    move-object v8, v4

    goto :goto_20

    :cond_3d
    move/from16 v20, p3

    move/from16 v27, v26

    move/from16 v26, v8

    goto :goto_1f

    .line 77
    :goto_20
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v4

    move-object/from16 v28, v8

    .line 78
    invoke-virtual/range {p11 .. p11}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v8

    move-object v3, v5

    move/from16 p8, v13

    move/from16 v14, v17

    move-object/from16 v12, v28

    move-object/from16 v13, p11

    move/from16 v5, p16

    .line 79
    invoke-virtual/range {v1 .. v9}, Landroidx/constraintlayout/core/LinearSystem;->addCentering(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;IFLandroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    move-object v5, v3

    move/from16 v8, v26

    move/from16 v26, v27

    goto :goto_21

    :cond_3e
    move-object v12, v4

    move/from16 p8, v13

    move/from16 v14, v17

    move-object/from16 v13, p11

    move/from16 v20, p3

    .line 80
    :goto_21
    iget v3, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    const/16 v4, 0x8

    if-ne v3, v4, :cond_40

    .line 81
    iget-object v3, v13, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    if-nez v3, :cond_3f

    goto/16 :goto_30

    .line 82
    :cond_3f
    invoke-virtual {v3}, Ljava/util/HashSet;->size()I

    move-result v3

    if-lez v3, :cond_5a

    :cond_40
    if-eqz v23, :cond_43

    if-eqz v20, :cond_42

    if-eq v5, v6, :cond_42

    if-nez v24, :cond_42

    .line 83
    instance-of v3, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v3, :cond_41

    instance-of v3, v12, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v3, :cond_42

    :cond_41
    const/4 v8, 0x6

    .line 84
    :cond_42
    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    .line 85
    invoke-virtual {v1, v2, v5, v3, v8}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 86
    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    neg-int v3, v3

    invoke-virtual {v1, v7, v6, v3, v8}, Landroidx/constraintlayout/core/LinearSystem;->addLowerThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_43
    if-eqz v20, :cond_44

    if-eqz p21, :cond_44

    .line 87
    instance-of v3, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v3, :cond_44

    instance-of v3, v12, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v3, :cond_44

    if-eq v12, v10, :cond_44

    const/4 v3, 0x6

    const/4 v8, 0x6

    const/16 v21, 0x1

    goto :goto_22

    :cond_44
    move/from16 v3, v19

    move/from16 v21, v26

    :goto_22
    if-eqz v21, :cond_50

    if-eqz v25, :cond_4d

    if-eqz p20, :cond_45

    if-eqz p4, :cond_4d

    :cond_45
    if-eq v11, v10, :cond_47

    if-ne v12, v10, :cond_46

    goto :goto_23

    :cond_46
    move/from16 v16, v3

    .line 88
    :cond_47
    :goto_23
    instance-of v4, v11, Landroidx/constraintlayout/core/widgets/Guideline;

    if-nez v4, :cond_48

    instance-of v4, v12, Landroidx/constraintlayout/core/widgets/Guideline;

    if-eqz v4, :cond_49

    :cond_48
    const/16 v16, 0x5

    .line 89
    :cond_49
    instance-of v4, v11, Landroidx/constraintlayout/core/widgets/Barrier;

    if-nez v4, :cond_4a

    instance-of v4, v12, Landroidx/constraintlayout/core/widgets/Barrier;

    if-eqz v4, :cond_4b

    :cond_4a
    const/16 v16, 0x5

    :cond_4b
    if-eqz p20, :cond_4c

    const/4 v4, 0x5

    goto :goto_24

    :cond_4c
    move/from16 v4, v16

    .line 90
    :goto_24
    invoke-static {v4, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    :cond_4d
    if-eqz v20, :cond_4f

    .line 91
    invoke-static {v8, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    if-eqz p17, :cond_4f

    if-nez p20, :cond_4f

    if-eq v11, v10, :cond_4e

    if-ne v12, v10, :cond_4f

    :cond_4e
    const/4 v10, 0x4

    goto :goto_25

    :cond_4f
    move v10, v3

    .line 92
    :goto_25
    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    .line 93
    invoke-virtual {v1, v2, v5, v3, v10}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 94
    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    neg-int v3, v3

    invoke-virtual {v1, v7, v6, v3, v10}, Landroidx/constraintlayout/core/LinearSystem;->addEquality(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_50
    if-eqz v20, :cond_52

    if-ne v15, v5, :cond_51

    .line 95
    invoke-virtual/range {p10 .. p10}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v3

    goto :goto_26

    :cond_51
    const/4 v3, 0x0

    :goto_26
    if-eq v5, v15, :cond_52

    const/4 v4, 0x5

    .line 96
    invoke-virtual {v1, v2, v15, v3, v4}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_52
    if-eqz v20, :cond_53

    if-eqz v24, :cond_53

    if-nez p14, :cond_53

    if-nez p8, :cond_53

    if-eqz v24, :cond_54

    const/4 v3, 0x3

    if-ne v14, v3, :cond_54

    const/16 v4, 0x8

    const/4 v10, 0x0

    .line 97
    invoke-virtual {v1, v7, v2, v10, v4}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_53
    const/4 v4, 0x5

    goto :goto_27

    :cond_54
    const/4 v10, 0x0

    const/4 v4, 0x5

    .line 98
    invoke-virtual {v1, v7, v2, v10, v4}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :goto_27
    const/4 v10, 0x5

    goto :goto_29

    :goto_28
    move/from16 v20, p3

    goto :goto_27

    :goto_29
    if-eqz v20, :cond_5a

    if-eqz p5, :cond_5a

    .line 99
    iget-object v2, v13, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v2, :cond_55

    .line 100
    invoke-virtual {v13}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    move-result v15

    :goto_2a
    move-object/from16 v4, p7

    goto :goto_2b

    :cond_55
    const/4 v15, 0x0

    goto :goto_2a

    :goto_2b
    if-eq v6, v4, :cond_5a

    .line 101
    invoke-virtual {v1, v4, v7, v15, v10}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    return-void

    :goto_2c
    if-ge v11, v10, :cond_5a

    if-eqz p3, :cond_5a

    if-eqz p5, :cond_5a

    const/4 v10, 0x0

    const/16 v13, 0x8

    .line 102
    invoke-virtual {v1, v2, v15, v10, v13}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 103
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez p2, :cond_57

    iget-object v5, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-nez v5, :cond_56

    goto :goto_2d

    :cond_56
    const/4 v10, 0x0

    goto :goto_2e

    :cond_57
    :goto_2d
    const/4 v10, 0x1

    :goto_2e
    if-nez p2, :cond_59

    .line 104
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eqz v2, :cond_59

    .line 105
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 106
    iget v5, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    const/4 v6, 0x0

    cmpl-float v5, v5, v6

    if-eqz v5, :cond_58

    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    const/16 v22, 0x0

    aget v5, v2, v22

    if-ne v5, v3, :cond_58

    const/16 v21, 0x1

    aget v2, v2, v21

    if-ne v2, v3, :cond_58

    const/4 v10, 0x1

    goto :goto_2f

    :cond_58
    const/4 v10, 0x0

    :cond_59
    :goto_2f
    if-eqz v10, :cond_5a

    const/4 v10, 0x0

    const/16 v13, 0x8

    .line 107
    invoke-virtual {v1, v4, v7, v10, v13}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    :cond_5a
    :goto_30
    return-void
.end method

.method public final connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V
    .locals 10

    const/16 v0, 0x9

    const/16 v1, 0x8

    const/4 v2, 0x2

    const/4 v3, 0x3

    const/4 v4, 0x4

    const/4 v5, 0x5

    const/4 v6, 0x0

    const/4 v7, 0x7

    if-ne p1, v7, :cond_c

    if-ne p3, v7, :cond_8

    .line 6
    invoke-virtual {p0, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 7
    invoke-virtual {p0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    .line 8
    invoke-virtual {p0, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    .line 9
    invoke-virtual {p0, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v8

    const/4 v9, 0x1

    if-eqz p1, :cond_0

    .line 10
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-nez p1, :cond_1

    :cond_0
    if-eqz p3, :cond_2

    .line 11
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_2

    :cond_1
    const/4 p1, 0x0

    goto :goto_0

    .line 12
    :cond_2
    invoke-virtual {p0, v2, p2, v2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V

    .line 13
    invoke-virtual {p0, v4, p2, v4, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V

    const/4 p1, 0x1

    :goto_0
    if-eqz p4, :cond_3

    .line 14
    invoke-virtual {p4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p3

    if-nez p3, :cond_4

    :cond_3
    if-eqz v8, :cond_5

    .line 15
    invoke-virtual {v8}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result p3

    if-eqz p3, :cond_5

    :cond_4
    const/4 v9, 0x0

    goto :goto_1

    .line 16
    :cond_5
    invoke-virtual {p0, v3, p2, v3, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V

    .line 17
    invoke-virtual {p0, v5, p2, v5, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V

    :goto_1
    if-eqz p1, :cond_6

    if-eqz v9, :cond_6

    .line 18
    invoke-virtual {p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 19
    invoke-virtual {p2, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    :cond_6
    if-eqz p1, :cond_7

    .line 20
    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 21
    invoke-virtual {p2, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    :cond_7
    if-eqz v9, :cond_1c

    .line 22
    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 23
    invoke-virtual {p2, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    :cond_8
    if-eq p3, v2, :cond_b

    if-ne p3, v4, :cond_9

    goto :goto_2

    :cond_9
    if-eq p3, v3, :cond_a

    if-ne p3, v5, :cond_1c

    .line 24
    :cond_a
    invoke-virtual {p0, v3, p2, p3, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V

    .line 25
    invoke-virtual {p0, v5, p2, p3, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V

    .line 26
    invoke-virtual {p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 27
    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    .line 28
    :cond_b
    :goto_2
    invoke-virtual {p0, v2, p2, p3, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V

    .line 29
    :try_start_0
    invoke-virtual {p0, v4, p2, p3, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 30
    invoke-virtual {p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 31
    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    :catchall_0
    move-exception p1

    .line 32
    throw p1

    :cond_c
    if-ne p1, v1, :cond_e

    if-eq p3, v2, :cond_d

    if-ne p3, v4, :cond_e

    .line 33
    :cond_d
    invoke-virtual {p0, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 34
    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    .line 35
    invoke-virtual {p0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    .line 36
    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 37
    invoke-virtual {p3, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 38
    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 39
    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    :cond_e
    if-ne p1, v0, :cond_10

    if-eq p3, v3, :cond_f

    if-ne p3, v5, :cond_10

    .line 40
    :cond_f
    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 41
    invoke-virtual {p0, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    .line 42
    invoke-virtual {p2, p1, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 43
    invoke-virtual {p0, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    .line 44
    invoke-virtual {p2, p1, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 45
    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    .line 46
    invoke-virtual {p2, p1, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    :cond_10
    if-ne p1, v1, :cond_11

    if-ne p3, v1, :cond_11

    .line 47
    invoke-virtual {p0, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 48
    invoke-virtual {p2, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    .line 49
    invoke-virtual {p1, p4, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 50
    invoke-virtual {p0, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 51
    invoke-virtual {p2, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    .line 52
    invoke-virtual {p1, p4, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 53
    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 54
    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    :cond_11
    if-ne p1, v0, :cond_12

    if-ne p3, v0, :cond_12

    .line 55
    invoke-virtual {p0, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 56
    invoke-virtual {p2, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    .line 57
    invoke-virtual {p1, p4, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 58
    invoke-virtual {p0, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 59
    invoke-virtual {p2, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p4

    .line 60
    invoke-virtual {p1, p4, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    .line 61
    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 62
    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    invoke-virtual {p1, p2, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    return-void

    .line 63
    :cond_12
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object v6

    .line 64
    invoke-virtual {p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p2

    .line 65
    invoke-virtual {v6, p2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isValidConnection(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)Z

    move-result p3

    if-eqz p3, :cond_1c

    const/4 p3, 0x6

    if-ne p1, p3, :cond_14

    .line 66
    invoke-virtual {p0, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 67
    invoke-virtual {p0, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    if-eqz p1, :cond_13

    .line 68
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    :cond_13
    if-eqz p3, :cond_1b

    .line 69
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    goto :goto_4

    :cond_14
    if-eq p1, v3, :cond_18

    if-ne p1, v5, :cond_15

    goto :goto_3

    :cond_15
    if-eq p1, v2, :cond_16

    if-ne p1, v4, :cond_1b

    .line 70
    :cond_16
    invoke-virtual {p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    .line 71
    iget-object v0, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eq v0, p2, :cond_17

    .line 72
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 73
    :cond_17
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOpposite()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 74
    invoke-virtual {p0, v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    .line 75
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_1b

    .line 76
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 77
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    goto :goto_4

    .line 78
    :cond_18
    :goto_3
    invoke-virtual {p0, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    if-eqz p3, :cond_19

    .line 79
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 80
    :cond_19
    invoke-virtual {p0, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    .line 81
    iget-object v1, p3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    if-eq v1, p2, :cond_1a

    .line 82
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 83
    :cond_1a
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getOpposite()Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p1

    .line 84
    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    move-result-object p3

    .line 85
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_1b

    .line 86
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 87
    invoke-virtual {p3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 88
    :cond_1b
    :goto_4
    invoke-virtual {v6, p2, p4}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V

    :cond_1c
    return-void
.end method

.method public final connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;I)V
    .locals 1

    .line 1
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    if-ne v0, p0, :cond_0

    .line 2
    iget p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mType:I

    .line 3
    iget-object v0, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 4
    iget p2, p2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mType:I

    .line 5
    invoke-virtual {p0, p1, v0, p2, p3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->connect(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;II)V

    :cond_0
    return-void
.end method

.method public final createObjectVariables(Landroidx/constraintlayout/core/LinearSystem;)V
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 2
    .line 3
    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 7
    .line 8
    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 14
    .line 15
    .line 16
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 17
    .line 18
    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 19
    .line 20
    .line 21
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    .line 22
    .line 23
    if-lez v0, :cond_0

    .line 24
    .line 25
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 26
    .line 27
    invoke-virtual {p1, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 28
    .line 29
    .line 30
    :cond_0
    return-void
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

.method public final ensureWidgetRuns()V
    .locals 4

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 6
    .line 7
    invoke-direct {v0, p0}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    .line 8
    .line 9
    .line 10
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 11
    .line 12
    const/4 v2, 0x4

    .line 13
    iput v2, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->mType:I

    .line 14
    .line 15
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 16
    .line 17
    const/4 v2, 0x5

    .line 18
    iput v2, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->mType:I

    .line 19
    .line 20
    const/4 v1, 0x0

    .line 21
    iput v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->orientation:I

    .line 22
    .line 23
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 24
    .line 25
    :cond_0
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 26
    .line 27
    if-nez v0, :cond_1

    .line 28
    .line 29
    new-instance v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 30
    .line 31
    invoke-direct {v0, p0}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    .line 32
    .line 33
    .line 34
    new-instance v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 35
    .line 36
    invoke-direct {v1, v0}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;-><init>(Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;)V

    .line 37
    .line 38
    .line 39
    iput-object v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->baseline:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 40
    .line 41
    const/4 v2, 0x0

    .line 42
    iput-object v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;->mBaselineDimension:Landroidx/constraintlayout/core/widgets/analyzer/BaselineDimensionDependency;

    .line 43
    .line 44
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 45
    .line 46
    const/4 v3, 0x6

    .line 47
    iput v3, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->mType:I

    .line 48
    .line 49
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 50
    .line 51
    const/4 v3, 0x7

    .line 52
    iput v3, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->mType:I

    .line 53
    .line 54
    const/16 v2, 0x8

    .line 55
    .line 56
    iput v2, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->mType:I

    .line 57
    .line 58
    const/4 v1, 0x1

    .line 59
    iput v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->orientation:I

    .line 60
    .line 61
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 62
    .line 63
    :cond_1
    return-void
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

.method public getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;
    .locals 1

    .line 1
    invoke-static {p1}, Landroidx/constraintlayout/core/SolverVariable$Type$EnumUnboxingSharedUtility;->ordinal(I)I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    packed-switch v0, :pswitch_data_0

    .line 6
    .line 7
    .line 8
    new-instance v0, Ljava/lang/AssertionError;

    .line 9
    .line 10
    invoke-static {p1}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->name(I)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    invoke-direct {v0, p1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    .line 15
    .line 16
    .line 17
    throw v0

    .line 18
    :pswitch_0
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 19
    .line 20
    return-object p1

    .line 21
    :pswitch_1
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 22
    .line 23
    return-object p1

    .line 24
    :pswitch_2
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 25
    .line 26
    return-object p1

    .line 27
    :pswitch_3
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 28
    .line 29
    return-object p1

    .line 30
    :pswitch_4
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 31
    .line 32
    return-object p1

    .line 33
    :pswitch_5
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 34
    .line 35
    return-object p1

    .line 36
    :pswitch_6
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 37
    .line 38
    return-object p1

    .line 39
    :pswitch_7
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 40
    .line 41
    return-object p1

    .line 42
    :pswitch_8
    const/4 p1, 0x0

    .line 43
    return-object p1

    .line 44
    nop

    .line 45
    :pswitch_data_0
    .packed-switch 0x0
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

.method public final getDimensionBehaviour(I)I
    .locals 3

    .line 1
    const/4 v0, 0x0

    .line 2
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 3
    .line 4
    if-nez p1, :cond_0

    .line 5
    .line 6
    aget p1, v1, v0

    .line 7
    .line 8
    return p1

    .line 9
    :cond_0
    const/4 v2, 0x1

    .line 10
    if-ne p1, v2, :cond_1

    .line 11
    .line 12
    aget p1, v1, v2

    .line 13
    .line 14
    return p1

    .line 15
    :cond_1
    return v0
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

.method public final getHeight()I
    .locals 2

    .line 1
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 2
    .line 3
    const/16 v1, 0x8

    .line 4
    .line 5
    if-ne v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x0

    .line 8
    return v0

    .line 9
    :cond_0
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 10
    .line 11
    return v0
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

.method public final getNextChainMember(I)Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    .locals 2

    .line 1
    if-nez p1, :cond_0

    .line 2
    .line 3
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 4
    .line 5
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 6
    .line 7
    if-eqz v0, :cond_1

    .line 8
    .line 9
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 10
    .line 11
    if-ne v1, p1, :cond_1

    .line 12
    .line 13
    iget-object p1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 14
    .line 15
    return-object p1

    .line 16
    :cond_0
    const/4 v0, 0x1

    .line 17
    if-ne p1, v0, :cond_1

    .line 18
    .line 19
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 20
    .line 21
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 22
    .line 23
    if-eqz v0, :cond_1

    .line 24
    .line 25
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 26
    .line 27
    if-ne v1, p1, :cond_1

    .line 28
    .line 29
    iget-object p1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 30
    .line 31
    return-object p1

    .line 32
    :cond_1
    const/4 p1, 0x0

    .line 33
    return-object p1
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

.method public final getPreviousChainMember(I)Landroidx/constraintlayout/core/widgets/ConstraintWidget;
    .locals 2

    .line 1
    if-nez p1, :cond_0

    .line 2
    .line 3
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 4
    .line 5
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 6
    .line 7
    if-eqz v0, :cond_1

    .line 8
    .line 9
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 10
    .line 11
    if-ne v1, p1, :cond_1

    .line 12
    .line 13
    iget-object p1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 14
    .line 15
    return-object p1

    .line 16
    :cond_0
    const/4 v0, 0x1

    .line 17
    if-ne p1, v0, :cond_1

    .line 18
    .line 19
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 20
    .line 21
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 22
    .line 23
    if-eqz v0, :cond_1

    .line 24
    .line 25
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 26
    .line 27
    if-ne v1, p1, :cond_1

    .line 28
    .line 29
    iget-object p1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 30
    .line 31
    return-object p1

    .line 32
    :cond_1
    const/4 p1, 0x0

    .line 33
    return-object p1
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

.method public getSceneString(Ljava/lang/StringBuilder;)V
    .locals 13

    .line 1
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "  "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->stringId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ":{\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 2
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "    actualWidth:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 3
    const-string v1, "\n"

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 4
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "    actualHeight:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 5
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 6
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "    actualLeft:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 7
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 8
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "    actualTop:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 9
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 10
    const-string v1, "left"

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-static {p1, v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    .line 11
    const-string v1, "top"

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-static {p1, v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    .line 12
    const-string v1, "right"

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-static {p1, v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    .line 13
    const-string v1, "bottom"

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-static {p1, v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    .line 14
    const-string v1, "baseline"

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-static {p1, v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    .line 15
    const-string v1, "centerX"

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-static {p1, v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    .line 16
    const-string v1, "centerY"

    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    invoke-static {p1, v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;Landroidx/constraintlayout/core/widgets/ConstraintAnchor;)V

    .line 17
    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    iget-object v9, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    const/4 v10, 0x0

    aget v4, v9, v10

    iget v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    iget v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    iget v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    iget-object v11, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    aget v8, v11, v10

    iget-object v12, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    aget v1, v12, v10

    const-string v1, "    width"

    move-object v0, p1

    invoke-static/range {v0 .. v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIFI)V

    .line 18
    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    const/4 v0, 0x1

    aget v4, v9, v0

    iget v5, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    iget v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    iget v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    aget v8, v11, v0

    aget v0, v12, v0

    const-string v1, "    height"

    move-object v0, p1

    invoke-static/range {v0 .. v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;Ljava/lang/String;IIIIIFI)V

    .line 19
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    const/4 v3, 0x0

    cmpl-float v3, v1, v3

    if-nez v3, :cond_0

    goto :goto_0

    .line 20
    :cond_0
    const-string v3, "    dimensionRatio"

    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 21
    const-string v3, " :  ["

    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 22
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 23
    const-string v1, ","

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 24
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 25
    const-string v1, ""

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 26
    const-string v1, "],\n"

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 27
    :goto_0
    const-string v1, "    horizontalBias"

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    const/high16 v3, 0x3f000000    # 0.5f

    invoke-static {p1, v1, v2, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V

    .line 28
    const-string v1, "    verticalBias"

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    invoke-static {p1, v1, v2, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(Ljava/lang/StringBuilder;Ljava/lang/String;FF)V

    .line 29
    const-string v1, "    horizontalChainStyle"

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    invoke-static {v2, v10, v1, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(IILjava/lang/String;Ljava/lang/StringBuilder;)V

    .line 30
    const-string v1, "    verticalChainStyle"

    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    invoke-static {v2, v10, v1, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->serializeAttribute(IILjava/lang/String;Ljava/lang/StringBuilder;)V

    .line 31
    const-string v1, "  }"

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-void
.end method

.method public final getWidth()I
    .locals 2

    .line 1
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 2
    .line 3
    const/16 v1, 0x8

    .line 4
    .line 5
    if-ne v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x0

    .line 8
    return v0

    .line 9
    :cond_0
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 10
    .line 11
    return v0
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

.method public final getX()I
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    instance-of v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 6
    .line 7
    if-eqz v1, :cond_0

    .line 8
    .line 9
    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 10
    .line 11
    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mPaddingLeft:I

    .line 12
    .line 13
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 14
    .line 15
    add-int/2addr v0, v1

    .line 16
    return v0

    .line 17
    :cond_0
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

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
.end method

.method public final getY()I
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    instance-of v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 6
    .line 7
    if-eqz v1, :cond_0

    .line 8
    .line 9
    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 10
    .line 11
    iget v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mPaddingTop:I

    .line 12
    .line 13
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 14
    .line 15
    add-int/2addr v0, v1

    .line 16
    return v0

    .line 17
    :cond_0
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

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
.end method

.method public final hasDanglingDimension(I)Z
    .locals 4

    .line 1
    const/4 v0, 0x2

    .line 2
    const/4 v1, 0x0

    .line 3
    const/4 v2, 0x1

    .line 4
    if-nez p1, :cond_2

    .line 5
    .line 6
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 7
    .line 8
    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 9
    .line 10
    if-eqz p1, :cond_0

    .line 11
    .line 12
    const/4 p1, 0x1

    .line 13
    goto :goto_0

    .line 14
    :cond_0
    const/4 p1, 0x0

    .line 15
    :goto_0
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 16
    .line 17
    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 18
    .line 19
    if-eqz v3, :cond_1

    .line 20
    .line 21
    const/4 v3, 0x1

    .line 22
    goto :goto_1

    .line 23
    :cond_1
    const/4 v3, 0x0

    .line 24
    :goto_1
    add-int/2addr p1, v3

    .line 25
    if-ge p1, v0, :cond_6

    .line 26
    .line 27
    goto :goto_5

    .line 28
    :cond_2
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 29
    .line 30
    iget-object p1, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 31
    .line 32
    if-eqz p1, :cond_3

    .line 33
    .line 34
    const/4 p1, 0x1

    .line 35
    goto :goto_2

    .line 36
    :cond_3
    const/4 p1, 0x0

    .line 37
    :goto_2
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 38
    .line 39
    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 40
    .line 41
    if-eqz v3, :cond_4

    .line 42
    .line 43
    const/4 v3, 0x1

    .line 44
    goto :goto_3

    .line 45
    :cond_4
    const/4 v3, 0x0

    .line 46
    :goto_3
    add-int/2addr p1, v3

    .line 47
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 48
    .line 49
    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 50
    .line 51
    if-eqz v3, :cond_5

    .line 52
    .line 53
    const/4 v3, 0x1

    .line 54
    goto :goto_4

    .line 55
    :cond_5
    const/4 v3, 0x0

    .line 56
    :goto_4
    add-int/2addr p1, v3

    .line 57
    if-ge p1, v0, :cond_6

    .line 58
    .line 59
    :goto_5
    return v2

    .line 60
    :cond_6
    return v1
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

.method public final hasResolvedTargets(II)Z
    .locals 3

    .line 1
    if-nez p1, :cond_0

    .line 2
    .line 3
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 4
    .line 5
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 6
    .line 7
    if-eqz v0, :cond_1

    .line 8
    .line 9
    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 10
    .line 11
    if-eqz v0, :cond_1

    .line 12
    .line 13
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 14
    .line 15
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 16
    .line 17
    if-eqz v1, :cond_1

    .line 18
    .line 19
    iget-boolean v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 20
    .line 21
    if-eqz v2, :cond_1

    .line 22
    .line 23
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 24
    .line 25
    .line 26
    move-result v1

    .line 27
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    .line 28
    .line 29
    .line 30
    move-result v0

    .line 31
    sub-int/2addr v1, v0

    .line 32
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 33
    .line 34
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 35
    .line 36
    .line 37
    move-result v0

    .line 38
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    .line 39
    .line 40
    .line 41
    move-result p1

    .line 42
    add-int/2addr p1, v0

    .line 43
    sub-int/2addr v1, p1

    .line 44
    if-lt v1, p2, :cond_1

    .line 45
    .line 46
    goto :goto_0

    .line 47
    :cond_0
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 48
    .line 49
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 50
    .line 51
    if-eqz v0, :cond_1

    .line 52
    .line 53
    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 54
    .line 55
    if-eqz v0, :cond_1

    .line 56
    .line 57
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 58
    .line 59
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 60
    .line 61
    if-eqz v1, :cond_1

    .line 62
    .line 63
    iget-boolean v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 64
    .line 65
    if-eqz v2, :cond_1

    .line 66
    .line 67
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 68
    .line 69
    .line 70
    move-result v1

    .line 71
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    .line 72
    .line 73
    .line 74
    move-result v0

    .line 75
    sub-int/2addr v1, v0

    .line 76
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 77
    .line 78
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getFinalValue()I

    .line 79
    .line 80
    .line 81
    move-result v0

    .line 82
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->getMargin()I

    .line 83
    .line 84
    .line 85
    move-result p1

    .line 86
    add-int/2addr p1, v0

    .line 87
    sub-int/2addr v1, p1

    .line 88
    if-lt v1, p2, :cond_1

    .line 89
    .line 90
    :goto_0
    const/4 p1, 0x1

    .line 91
    return p1

    .line 92
    :cond_1
    const/4 p1, 0x0

    .line 93
    return p1
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

.method public final immediateConnect(IIIILandroidx/constraintlayout/core/widgets/ConstraintWidget;)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    invoke-virtual {p5, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 6
    .line 7
    .line 8
    move-result-object p2

    .line 9
    const/4 p5, 0x1

    .line 10
    invoke-virtual {p1, p2, p3, p4, p5}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->connect(Landroidx/constraintlayout/core/widgets/ConstraintAnchor;IIZ)Z

    .line 11
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
    .line 632
    .line 633
    .line 634
    .line 635
    .line 636
    .line 637
    .line 638
    .line 639
    .line 640
    .line 641
    .line 642
    .line 643
    .line 644
    .line 645
    .line 646
    .line 647
    .line 648
    .line 649
    .line 650
    .line 651
    .line 652
    .line 653
    .line 654
    .line 655
    .line 656
    .line 657
    .line 658
    .line 659
    .line 660
    .line 661
    .line 662
    .line 663
    .line 664
    .line 665
    .line 666
    .line 667
    .line 668
    .line 669
    .line 670
    .line 671
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
.end method

.method public final isChainHead(I)Z
    .locals 3

    .line 1
    mul-int/lit8 p1, p1, 0x2

    .line 2
    .line 3
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListAnchors:[Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 4
    .line 5
    aget-object v1, v0, p1

    .line 6
    .line 7
    iget-object v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 8
    .line 9
    if-eqz v2, :cond_0

    .line 10
    .line 11
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    if-eq v2, v1, :cond_0

    .line 14
    .line 15
    const/4 v1, 0x1

    .line 16
    add-int/2addr p1, v1

    .line 17
    aget-object p1, v0, p1

    .line 18
    .line 19
    iget-object v0, p1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 20
    .line 21
    if-eqz v0, :cond_0

    .line 22
    .line 23
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 24
    .line 25
    if-ne v0, p1, :cond_0

    .line 26
    .line 27
    return v1

    .line 28
    :cond_0
    const/4 p1, 0x0

    .line 29
    return p1
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

.method public final isInHorizontalChain()Z
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 2
    .line 3
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 8
    .line 9
    if-eq v1, v0, :cond_1

    .line 10
    .line 11
    :cond_0
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 14
    .line 15
    if-eqz v1, :cond_2

    .line 16
    .line 17
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 18
    .line 19
    if-ne v1, v0, :cond_2

    .line 20
    .line 21
    :cond_1
    const/4 v0, 0x1

    .line 22
    return v0

    .line 23
    :cond_2
    const/4 v0, 0x0

    .line 24
    return v0
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

.method public final isInVerticalChain()Z
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 2
    .line 3
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 8
    .line 9
    if-eq v1, v0, :cond_1

    .line 10
    .line 11
    :cond_0
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    iget-object v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 14
    .line 15
    if-eqz v1, :cond_2

    .line 16
    .line 17
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 18
    .line 19
    if-ne v1, v0, :cond_2

    .line 20
    .line 21
    :cond_1
    const/4 v0, 0x1

    .line 22
    return v0

    .line 23
    :cond_2
    const/4 v0, 0x0

    .line 24
    return v0
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

.method public final isMeasureRequested()Z
    .locals 2

    .line 1
    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 6
    .line 7
    const/16 v1, 0x8

    .line 8
    .line 9
    if-eq v0, v1, :cond_0

    .line 10
    .line 11
    const/4 v0, 0x1

    .line 12
    return v0

    .line 13
    :cond_0
    const/4 v0, 0x0

    .line 14
    return v0
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

.method public isResolvedHorizontally()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 2
    .line 3
    if-nez v0, :cond_1

    .line 4
    .line 5
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 6
    .line 7
    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 8
    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 14
    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    goto :goto_0

    .line 18
    :cond_0
    const/4 v0, 0x0

    .line 19
    return v0

    .line 20
    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 21
    return v0
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

.method public isResolvedVertically()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 2
    .line 3
    if-nez v0, :cond_1

    .line 4
    .line 5
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 6
    .line 7
    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 8
    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    iget-boolean v0, v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 14
    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    goto :goto_0

    .line 18
    :cond_0
    const/4 v0, 0x0

    .line 19
    return v0

    .line 20
    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 21
    return v0
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

.method public reset()V
    .locals 5

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 7
    .line 8
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 14
    .line 15
    .line 16
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 17
    .line 18
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 19
    .line 20
    .line 21
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 22
    .line 23
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 24
    .line 25
    .line 26
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 27
    .line 28
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 29
    .line 30
    .line 31
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 32
    .line 33
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 34
    .line 35
    .line 36
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 37
    .line 38
    invoke-virtual {v0}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 39
    .line 40
    .line 41
    const/4 v0, 0x0

    .line 42
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 43
    .line 44
    const/high16 v1, 0x7fc00000    # Float.NaN

    .line 45
    .line 46
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCircleConstraintAngle:F

    .line 47
    .line 48
    const/4 v1, 0x0

    .line 49
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 50
    .line 51
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 52
    .line 53
    const/4 v2, 0x0

    .line 54
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    .line 55
    .line 56
    const/4 v2, -0x1

    .line 57
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    .line 58
    .line 59
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 60
    .line 61
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 62
    .line 63
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    .line 64
    .line 65
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    .line 66
    .line 67
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    .line 68
    .line 69
    const/high16 v3, 0x3f000000    # 0.5f

    .line 70
    .line 71
    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalBiasPercent:F

    .line 72
    .line 73
    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalBiasPercent:F

    .line 74
    .line 75
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 76
    .line 77
    const/4 v4, 0x1

    .line 78
    aput v4, v3, v1

    .line 79
    .line 80
    aput v4, v3, v4

    .line 81
    .line 82
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCompanionWidget:Landroid/view/View;

    .line 83
    .line 84
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 85
    .line 86
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalChainStyle:I

    .line 87
    .line 88
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalChainStyle:I

    .line 89
    .line 90
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWeight:[F

    .line 91
    .line 92
    const/high16 v3, -0x40800000    # -1.0f

    .line 93
    .line 94
    aput v3, v0, v1

    .line 95
    .line 96
    aput v3, v0, v4

    .line 97
    .line 98
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalResolution:I

    .line 99
    .line 100
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalResolution:I

    .line 101
    .line 102
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMaxDimension:[I

    .line 103
    .line 104
    const v3, 0x7fffffff

    .line 105
    .line 106
    .line 107
    aput v3, v0, v1

    .line 108
    .line 109
    aput v3, v0, v4

    .line 110
    .line 111
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    .line 112
    .line 113
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    .line 114
    .line 115
    const/high16 v0, 0x3f800000    # 1.0f

    .line 116
    .line 117
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentWidth:F

    .line 118
    .line 119
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintPercentHeight:F

    .line 120
    .line 121
    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    .line 122
    .line 123
    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    .line 124
    .line 125
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinWidth:I

    .line 126
    .line 127
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMinHeight:I

    .line 128
    .line 129
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatioSide:I

    .line 130
    .line 131
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedDimensionRatio:F

    .line 132
    .line 133
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isTerminalWidget:[Z

    .line 134
    .line 135
    aput-boolean v4, v0, v1

    .line 136
    .line 137
    aput-boolean v4, v0, v4

    .line 138
    .line 139
    iput-boolean v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    .line 140
    .line 141
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    .line 142
    .line 143
    aput-boolean v1, v0, v1

    .line 144
    .line 145
    aput-boolean v1, v0, v4

    .line 146
    .line 147
    iput-boolean v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMeasureRequested:Z

    .line 148
    .line 149
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    .line 150
    .line 151
    aput v1, v0, v1

    .line 152
    .line 153
    aput v1, v0, v4

    .line 154
    .line 155
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    .line 156
    .line 157
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    .line 158
    .line 159
    return-void
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

.method public final resetAnchors()V
    .locals 4

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mParent:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    instance-of v1, v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 6
    .line 7
    if-eqz v1, :cond_0

    .line 8
    .line 9
    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 10
    .line 11
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 12
    .line 13
    .line 14
    :cond_0
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    .line 15
    .line 16
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 17
    .line 18
    .line 19
    move-result v1

    .line 20
    const/4 v2, 0x0

    .line 21
    :goto_0
    if-ge v2, v1, :cond_1

    .line 22
    .line 23
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 24
    .line 25
    .line 26
    move-result-object v3

    .line 27
    check-cast v3, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 28
    .line 29
    invoke-virtual {v3}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->reset()V

    .line 30
    .line 31
    .line 32
    add-int/lit8 v2, v2, 0x1

    .line 33
    .line 34
    goto :goto_0

    .line 35
    :cond_1
    return-void
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

.method public final resetFinalResolution()V
    .locals 5

    .line 1
    const/4 v0, 0x0

    .line 2
    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 3
    .line 4
    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 5
    .line 6
    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalSolvingPass:Z

    .line 7
    .line 8
    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalSolvingPass:Z

    .line 9
    .line 10
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mAnchors:Ljava/util/ArrayList;

    .line 11
    .line 12
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 13
    .line 14
    .line 15
    move-result v2

    .line 16
    const/4 v3, 0x0

    .line 17
    :goto_0
    if-ge v3, v2, :cond_0

    .line 18
    .line 19
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 20
    .line 21
    .line 22
    move-result-object v4

    .line 23
    check-cast v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 24
    .line 25
    iput-boolean v0, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mHasFinalValue:Z

    .line 26
    .line 27
    iput v0, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mFinalValue:I

    .line 28
    .line 29
    add-int/lit8 v3, v3, 0x1

    .line 30
    .line 31
    goto :goto_0

    .line 32
    :cond_0
    return-void
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

.method public resetSolverVariables(Lkotlin/text/MatcherMatchResult;)V
    .locals 0

    .line 1
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 2
    .line 3
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable()V

    .line 4
    .line 5
    .line 6
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 7
    .line 8
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable()V

    .line 9
    .line 10
    .line 11
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable()V

    .line 14
    .line 15
    .line 16
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 17
    .line 18
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable()V

    .line 19
    .line 20
    .line 21
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 22
    .line 23
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable()V

    .line 24
    .line 25
    .line 26
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenter:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 27
    .line 28
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable()V

    .line 29
    .line 30
    .line 31
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterX:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 32
    .line 33
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable()V

    .line 34
    .line 35
    .line 36
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mCenterY:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 37
    .line 38
    invoke-virtual {p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->resetSolverVariable()V

    .line 39
    .line 40
    .line 41
    return-void
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

.method public final setBaselineDistance(I)V
    .locals 0

    .line 1
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    .line 2
    .line 3
    if-lez p1, :cond_0

    .line 4
    .line 5
    const/4 p1, 0x1

    .line 6
    goto :goto_0

    .line 7
    :cond_0
    const/4 p1, 0x0

    .line 8
    :goto_0
    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHasBaseline:Z

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
.end method

.method public final setFinalHorizontal(II)V
    .locals 1

    .line 1
    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 7
    .line 8
    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    invoke-virtual {v0, p2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    .line 14
    .line 15
    .line 16
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 17
    .line 18
    sub-int/2addr p2, p1

    .line 19
    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 20
    .line 21
    const/4 p1, 0x1

    .line 22
    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedHorizontal:Z

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
.end method

.method public final setFinalVertical(II)V
    .locals 1

    .line 1
    iget-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 7
    .line 8
    invoke-virtual {v0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 12
    .line 13
    invoke-virtual {v0, p2}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    .line 14
    .line 15
    .line 16
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 17
    .line 18
    sub-int/2addr p2, p1

    .line 19
    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 20
    .line 21
    iget-boolean p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHasBaseline:Z

    .line 22
    .line 23
    if-eqz p2, :cond_1

    .line 24
    .line 25
    iget p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaselineDistance:I

    .line 26
    .line 27
    add-int/2addr p1, p2

    .line 28
    iget-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 29
    .line 30
    invoke-virtual {p2, p1}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    .line 31
    .line 32
    .line 33
    :cond_1
    const/4 p1, 0x1

    .line 34
    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedVertical:Z

    .line 35
    .line 36
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

.method public final setHeight(I)V
    .locals 1

    .line 1
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 2
    .line 3
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    .line 4
    .line 5
    if-ge p1, v0, :cond_0

    .line 6
    .line 7
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 8
    .line 9
    :cond_0
    return-void
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

.method public final setHorizontalDimensionBehaviour(I)V
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    aput p1, v0, v1

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

.method public final setVerticalDimensionBehaviour(I)V
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    aput p1, v0, v1

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

.method public final setWidth(I)V
    .locals 1

    .line 1
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 2
    .line 3
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    .line 4
    .line 5
    if-ge p1, v0, :cond_0

    .line 6
    .line 7
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 8
    .line 9
    :cond_0
    return-void
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

.method public toString()Ljava/lang/String;
    .locals 4

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 4
    .line 5
    .line 6
    const-string v1, ""

    .line 7
    .line 8
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 9
    .line 10
    .line 11
    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    .line 12
    .line 13
    if-eqz v2, :cond_0

    .line 14
    .line 15
    new-instance v1, Ljava/lang/StringBuilder;

    .line 16
    .line 17
    const-string v2, "id: "

    .line 18
    .line 19
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 20
    .line 21
    .line 22
    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDebugName:Ljava/lang/String;

    .line 23
    .line 24
    const-string v3, " "

    .line 25
    .line 26
    invoke-static {v1, v2, v3}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v1

    .line 30
    :cond_0
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 31
    .line 32
    .line 33
    const-string v1, "("

    .line 34
    .line 35
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 36
    .line 37
    .line 38
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 39
    .line 40
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 41
    .line 42
    .line 43
    const-string v1, ", "

    .line 44
    .line 45
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 46
    .line 47
    .line 48
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 49
    .line 50
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    const-string v1, ") - ("

    .line 54
    .line 55
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    .line 57
    .line 58
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 59
    .line 60
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 61
    .line 62
    .line 63
    const-string v1, " x "

    .line 64
    .line 65
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 66
    .line 67
    .line 68
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 69
    .line 70
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 71
    .line 72
    .line 73
    const-string v1, ")"

    .line 74
    .line 75
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 76
    .line 77
    .line 78
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 79
    .line 80
    .line 81
    move-result-object v0

    .line 82
    return-object v0
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

.method public updateFromRuns(ZZ)V
    .locals 7

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 2
    .line 3
    iget-boolean v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mResolved:Z

    .line 4
    .line 5
    and-int/2addr p1, v1

    .line 6
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 7
    .line 8
    iget-boolean v2, v1, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mResolved:Z

    .line 9
    .line 10
    and-int/2addr p2, v2

    .line 11
    iget-object v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 12
    .line 13
    iget v2, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 14
    .line 15
    iget-object v3, v1, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 16
    .line 17
    iget v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 18
    .line 19
    iget-object v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 20
    .line 21
    iget v0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 22
    .line 23
    iget-object v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 24
    .line 25
    iget v1, v1, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 26
    .line 27
    sub-int v4, v0, v2

    .line 28
    .line 29
    sub-int v5, v1, v3

    .line 30
    .line 31
    const/4 v6, 0x0

    .line 32
    if-ltz v4, :cond_0

    .line 33
    .line 34
    if-ltz v5, :cond_0

    .line 35
    .line 36
    const/high16 v4, -0x80000000

    .line 37
    .line 38
    if-eq v2, v4, :cond_0

    .line 39
    .line 40
    const v5, 0x7fffffff

    .line 41
    .line 42
    .line 43
    if-eq v2, v5, :cond_0

    .line 44
    .line 45
    if-eq v3, v4, :cond_0

    .line 46
    .line 47
    if-eq v3, v5, :cond_0

    .line 48
    .line 49
    if-eq v0, v4, :cond_0

    .line 50
    .line 51
    if-eq v0, v5, :cond_0

    .line 52
    .line 53
    if-eq v1, v4, :cond_0

    .line 54
    .line 55
    if-ne v1, v5, :cond_1

    .line 56
    .line 57
    :cond_0
    const/4 v0, 0x0

    .line 58
    const/4 v1, 0x0

    .line 59
    const/4 v2, 0x0

    .line 60
    const/4 v3, 0x0

    .line 61
    :cond_1
    sub-int/2addr v0, v2

    .line 62
    sub-int/2addr v1, v3

    .line 63
    if-eqz p1, :cond_2

    .line 64
    .line 65
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 66
    .line 67
    :cond_2
    if-eqz p2, :cond_3

    .line 68
    .line 69
    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 70
    .line 71
    :cond_3
    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 72
    .line 73
    const/16 v3, 0x8

    .line 74
    .line 75
    if-ne v2, v3, :cond_4

    .line 76
    .line 77
    iput v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 78
    .line 79
    iput v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 80
    .line 81
    return-void

    .line 82
    :cond_4
    const/4 v2, 0x1

    .line 83
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 84
    .line 85
    if-eqz p1, :cond_6

    .line 86
    .line 87
    aget p1, v3, v6

    .line 88
    .line 89
    if-ne p1, v2, :cond_5

    .line 90
    .line 91
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 92
    .line 93
    if-ge v0, p1, :cond_5

    .line 94
    .line 95
    move v0, p1

    .line 96
    :cond_5
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 97
    .line 98
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    .line 99
    .line 100
    if-ge v0, p1, :cond_6

    .line 101
    .line 102
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 103
    .line 104
    :cond_6
    if-eqz p2, :cond_8

    .line 105
    .line 106
    aget p1, v3, v2

    .line 107
    .line 108
    if-ne p1, v2, :cond_7

    .line 109
    .line 110
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 111
    .line 112
    if-ge v1, p1, :cond_7

    .line 113
    .line 114
    move v1, p1

    .line 115
    :cond_7
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 116
    .line 117
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    .line 118
    .line 119
    if-ge v1, p1, :cond_8

    .line 120
    .line 121
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 122
    .line 123
    :cond_8
    return-void
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
    .line 632
    .line 633
    .line 634
    .line 635
    .line 636
    .line 637
    .line 638
    .line 639
    .line 640
    .line 641
    .line 642
    .line 643
    .line 644
    .line 645
    .line 646
    .line 647
    .line 648
    .line 649
    .line 650
    .line 651
    .line 652
    .line 653
    .line 654
    .line 655
    .line 656
    .line 657
    .line 658
    .line 659
    .line 660
    .line 661
    .line 662
    .line 663
    .line 664
    .line 665
    .line 666
    .line 667
    .line 668
    .line 669
    .line 670
    .line 671
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
.end method

.method public updateFromSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V
    .locals 6

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 2
    .line 3
    .line 4
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 5
    .line 6
    invoke-static {p1}, Landroidx/constraintlayout/core/LinearSystem;->getObjectVariableValue(Ljava/lang/Object;)I

    .line 7
    .line 8
    .line 9
    move-result p1

    .line 10
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 11
    .line 12
    invoke-static {v0}, Landroidx/constraintlayout/core/LinearSystem;->getObjectVariableValue(Ljava/lang/Object;)I

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 17
    .line 18
    invoke-static {v1}, Landroidx/constraintlayout/core/LinearSystem;->getObjectVariableValue(Ljava/lang/Object;)I

    .line 19
    .line 20
    .line 21
    move-result v1

    .line 22
    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 23
    .line 24
    invoke-static {v2}, Landroidx/constraintlayout/core/LinearSystem;->getObjectVariableValue(Ljava/lang/Object;)I

    .line 25
    .line 26
    .line 27
    move-result v2

    .line 28
    if-eqz p2, :cond_0

    .line 29
    .line 30
    iget-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 31
    .line 32
    if-eqz v3, :cond_0

    .line 33
    .line 34
    iget-object v4, v3, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 35
    .line 36
    iget-boolean v5, v4, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 37
    .line 38
    if-eqz v5, :cond_0

    .line 39
    .line 40
    iget-object v3, v3, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 41
    .line 42
    iget-boolean v5, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 43
    .line 44
    if-eqz v5, :cond_0

    .line 45
    .line 46
    iget p1, v4, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 47
    .line 48
    iget v1, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 49
    .line 50
    :cond_0
    if-eqz p2, :cond_1

    .line 51
    .line 52
    iget-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 53
    .line 54
    if-eqz p2, :cond_1

    .line 55
    .line 56
    iget-object v3, p2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 57
    .line 58
    iget-boolean v4, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 59
    .line 60
    if-eqz v4, :cond_1

    .line 61
    .line 62
    iget-object p2, p2, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 63
    .line 64
    iget-boolean v4, p2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 65
    .line 66
    if-eqz v4, :cond_1

    .line 67
    .line 68
    iget v0, v3, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 69
    .line 70
    iget v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->value:I

    .line 71
    .line 72
    :cond_1
    sub-int p2, v1, p1

    .line 73
    .line 74
    sub-int v3, v2, v0

    .line 75
    .line 76
    const/4 v4, 0x0

    .line 77
    if-ltz p2, :cond_2

    .line 78
    .line 79
    if-ltz v3, :cond_2

    .line 80
    .line 81
    const/high16 p2, -0x80000000

    .line 82
    .line 83
    if-eq p1, p2, :cond_2

    .line 84
    .line 85
    const v3, 0x7fffffff

    .line 86
    .line 87
    .line 88
    if-eq p1, v3, :cond_2

    .line 89
    .line 90
    if-eq v0, p2, :cond_2

    .line 91
    .line 92
    if-eq v0, v3, :cond_2

    .line 93
    .line 94
    if-eq v1, p2, :cond_2

    .line 95
    .line 96
    if-eq v1, v3, :cond_2

    .line 97
    .line 98
    if-eq v2, p2, :cond_2

    .line 99
    .line 100
    if-ne v2, v3, :cond_3

    .line 101
    .line 102
    :cond_2
    const/4 p1, 0x0

    .line 103
    const/4 v0, 0x0

    .line 104
    const/4 v1, 0x0

    .line 105
    const/4 v2, 0x0

    .line 106
    :cond_3
    sub-int/2addr v1, p1

    .line 107
    sub-int/2addr v2, v0

    .line 108
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 109
    .line 110
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 111
    .line 112
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 113
    .line 114
    const/16 p2, 0x8

    .line 115
    .line 116
    if-ne p1, p2, :cond_4

    .line 117
    .line 118
    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 119
    .line 120
    iput v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 121
    .line 122
    return-void

    .line 123
    :cond_4
    iget-object p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 124
    .line 125
    aget p2, p1, v4

    .line 126
    .line 127
    const/4 v0, 0x1

    .line 128
    if-ne p2, v0, :cond_5

    .line 129
    .line 130
    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 131
    .line 132
    if-ge v1, v3, :cond_5

    .line 133
    .line 134
    move v1, v3

    .line 135
    :cond_5
    aget v3, p1, v0

    .line 136
    .line 137
    if-ne v3, v0, :cond_6

    .line 138
    .line 139
    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 140
    .line 141
    if-ge v2, v3, :cond_6

    .line 142
    .line 143
    move v2, v3

    .line 144
    :cond_6
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 145
    .line 146
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 147
    .line 148
    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    .line 149
    .line 150
    if-ge v2, v3, :cond_7

    .line 151
    .line 152
    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 153
    .line 154
    :cond_7
    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    .line 155
    .line 156
    if-ge v1, v3, :cond_8

    .line 157
    .line 158
    iput v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 159
    .line 160
    :cond_8
    iget v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxWidth:I

    .line 161
    .line 162
    const/4 v4, 0x3

    .line 163
    if-lez v3, :cond_9

    .line 164
    .line 165
    if-ne p2, v4, :cond_9

    .line 166
    .line 167
    iget p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 168
    .line 169
    invoke-static {p2, v3}, Ljava/lang/Math;->min(II)I

    .line 170
    .line 171
    .line 172
    move-result p2

    .line 173
    iput p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 174
    .line 175
    :cond_9
    iget p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintMaxHeight:I

    .line 176
    .line 177
    if-lez p2, :cond_a

    .line 178
    .line 179
    aget p1, p1, v0

    .line 180
    .line 181
    if-ne p1, v4, :cond_a

    .line 182
    .line 183
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 184
    .line 185
    invoke-static {p1, p2}, Ljava/lang/Math;->min(II)I

    .line 186
    .line 187
    .line 188
    move-result p1

    .line 189
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 190
    .line 191
    :cond_a
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 192
    .line 193
    if-eq v1, p1, :cond_b

    .line 194
    .line 195
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    .line 196
    .line 197
    :cond_b
    iget p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 198
    .line 199
    if-eq v2, p1, :cond_c

    .line 200
    .line 201
    iput p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    .line 202
    .line 203
    :cond_c
    return-void
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
    .line 632
    .line 633
    .line 634
    .line 635
    .line 636
    .line 637
    .line 638
    .line 639
    .line 640
    .line 641
    .line 642
    .line 643
    .line 644
    .line 645
    .line 646
    .line 647
    .line 648
    .line 649
    .line 650
    .line 651
    .line 652
    .line 653
    .line 654
    .line 655
    .line 656
    .line 657
    .line 658
    .line 659
    .line 660
    .line 661
    .line 662
    .line 663
    .line 664
    .line 665
    .line 666
    .line 667
    .line 668
    .line 669
    .line 670
    .line 671
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
.end method
