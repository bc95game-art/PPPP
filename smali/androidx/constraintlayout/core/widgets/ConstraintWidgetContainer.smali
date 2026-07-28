.class public final Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;
.super Landroidx/constraintlayout/core/widgets/ConstraintWidget;
.source "SourceFile"


# instance fields
.field public final mBasicMeasureSolver:Lkotlin/text/MatcherMatchResult;

.field public mChildren:Ljava/util/ArrayList;

.field public final mDependencyGraph:Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;

.field public mHeightMeasuredTooSmall:Z

.field public mHorizontalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

.field public mHorizontalChainsSize:I

.field public mHorizontalWrapMax:Ljava/lang/ref/WeakReference;

.field public mHorizontalWrapMin:Ljava/lang/ref/WeakReference;

.field public mIsRtl:Z

.field public final mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

.field public mMeasurer:Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;

.field public mOptimizationLevel:I

.field public mPaddingLeft:I

.field public mPaddingTop:I

.field public mPass:I

.field public final mSystem:Landroidx/constraintlayout/core/LinearSystem;

.field public mVerticalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

.field public mVerticalChainsSize:I

.field public mVerticalWrapMax:Ljava/lang/ref/WeakReference;

.field public mVerticalWrapMin:Ljava/lang/ref/WeakReference;

.field public final mWidgetsToAdd:Ljava/util/HashSet;

.field public mWidthMeasuredTooSmall:Z


# direct methods
.method public constructor <init>()V
    .locals 4

    .line 1
    invoke-direct {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 10
    .line 11
    new-instance v0, Lkotlin/text/MatcherMatchResult;

    .line 12
    .line 13
    invoke-direct {v0, p0}, Lkotlin/text/MatcherMatchResult;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;)V

    .line 14
    .line 15
    .line 16
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mBasicMeasureSolver:Lkotlin/text/MatcherMatchResult;

    .line 17
    .line 18
    new-instance v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;

    .line 19
    .line 20
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 21
    .line 22
    .line 23
    const/4 v1, 0x1

    .line 24
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mNeedBuildGraph:Z

    .line 25
    .line 26
    iput-boolean v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mNeedRedoMeasures:Z

    .line 27
    .line 28
    new-instance v1, Ljava/util/ArrayList;

    .line 29
    .line 30
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 31
    .line 32
    .line 33
    iput-object v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mRuns:Ljava/util/ArrayList;

    .line 34
    .line 35
    new-instance v1, Ljava/util/ArrayList;

    .line 36
    .line 37
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 38
    .line 39
    .line 40
    const/4 v1, 0x0

    .line 41
    iput-object v1, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mMeasurer:Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;

    .line 42
    .line 43
    new-instance v2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    .line 44
    .line 45
    invoke-direct {v2}, Ljava/lang/Object;-><init>()V

    .line 46
    .line 47
    .line 48
    iput-object v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    .line 49
    .line 50
    new-instance v2, Ljava/util/ArrayList;

    .line 51
    .line 52
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 53
    .line 54
    .line 55
    iput-object v2, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mGroups:Ljava/util/ArrayList;

    .line 56
    .line 57
    iput-object p0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mWidgetcontainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 58
    .line 59
    iput-object p0, v0, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mContainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 60
    .line 61
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mDependencyGraph:Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;

    .line 62
    .line 63
    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMeasurer:Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;

    .line 64
    .line 65
    const/4 v0, 0x0

    .line 66
    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mIsRtl:Z

    .line 67
    .line 68
    new-instance v2, Landroidx/constraintlayout/core/LinearSystem;

    .line 69
    .line 70
    invoke-direct {v2}, Landroidx/constraintlayout/core/LinearSystem;-><init>()V

    .line 71
    .line 72
    .line 73
    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mSystem:Landroidx/constraintlayout/core/LinearSystem;

    .line 74
    .line 75
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsSize:I

    .line 76
    .line 77
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsSize:I

    .line 78
    .line 79
    const/4 v2, 0x4

    .line 80
    new-array v3, v2, [Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 81
    .line 82
    iput-object v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 83
    .line 84
    new-array v2, v2, [Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 85
    .line 86
    iput-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 87
    .line 88
    const/16 v2, 0x101

    .line 89
    .line 90
    iput v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mOptimizationLevel:I

    .line 91
    .line 92
    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mWidthMeasuredTooSmall:Z

    .line 93
    .line 94
    iput-boolean v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHeightMeasuredTooSmall:Z

    .line 95
    .line 96
    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMin:Ljava/lang/ref/WeakReference;

    .line 97
    .line 98
    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMin:Ljava/lang/ref/WeakReference;

    .line 99
    .line 100
    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMax:Ljava/lang/ref/WeakReference;

    .line 101
    .line 102
    iput-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMax:Ljava/lang/ref/WeakReference;

    .line 103
    .line 104
    new-instance v0, Ljava/util/HashSet;

    .line 105
    .line 106
    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 107
    .line 108
    .line 109
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mWidgetsToAdd:Ljava/util/HashSet;

    .line 110
    .line 111
    new-instance v0, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    .line 112
    .line 113
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 114
    .line 115
    .line 116
    iput-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    .line 117
    .line 118
    return-void
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

.method public static measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V
    .locals 9

    .line 1
    if-nez p1, :cond_0

    .line 2
    .line 3
    return-void

    .line 4
    :cond_0
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVisibility:I

    .line 5
    .line 6
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mResolvedMatchConstraintDefault:[I

    .line 7
    .line 8
    const/16 v2, 0x8

    .line 9
    .line 10
    const/4 v3, 0x0

    .line 11
    if-eq v0, v2, :cond_13

    .line 12
    .line 13
    instance-of v0, p0, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 14
    .line 15
    if-nez v0, :cond_13

    .line 16
    .line 17
    instance-of v0, p0, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 18
    .line 19
    if-eqz v0, :cond_1

    .line 20
    .line 21
    goto/16 :goto_8

    .line 22
    .line 23
    :cond_1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 24
    .line 25
    aget v2, v0, v3

    .line 26
    .line 27
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 28
    .line 29
    const/4 v2, 0x1

    .line 30
    aget v0, v0, v2

    .line 31
    .line 32
    iput v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 33
    .line 34
    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 35
    .line 36
    .line 37
    move-result v0

    .line 38
    iput v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalDimension:I

    .line 39
    .line 40
    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 41
    .line 42
    .line 43
    move-result v0

    .line 44
    iput v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalDimension:I

    .line 45
    .line 46
    iput-boolean v3, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredNeedsSolverPass:Z

    .line 47
    .line 48
    iput v3, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measureStrategy:I

    .line 49
    .line 50
    iget v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 51
    .line 52
    const/4 v4, 0x3

    .line 53
    if-ne v0, v4, :cond_2

    .line 54
    .line 55
    const/4 v0, 0x1

    .line 56
    goto :goto_0

    .line 57
    :cond_2
    const/4 v0, 0x0

    .line 58
    :goto_0
    iget v5, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 59
    .line 60
    if-ne v5, v4, :cond_3

    .line 61
    .line 62
    const/4 v4, 0x1

    .line 63
    goto :goto_1

    .line 64
    :cond_3
    const/4 v4, 0x0

    .line 65
    :goto_1
    const/4 v5, 0x0

    .line 66
    if-eqz v0, :cond_4

    .line 67
    .line 68
    iget v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    .line 69
    .line 70
    cmpl-float v6, v6, v5

    .line 71
    .line 72
    if-lez v6, :cond_4

    .line 73
    .line 74
    const/4 v6, 0x1

    .line 75
    goto :goto_2

    .line 76
    :cond_4
    const/4 v6, 0x0

    .line 77
    :goto_2
    if-eqz v4, :cond_5

    .line 78
    .line 79
    iget v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    .line 80
    .line 81
    cmpl-float v5, v7, v5

    .line 82
    .line 83
    if-lez v5, :cond_5

    .line 84
    .line 85
    const/4 v5, 0x1

    .line 86
    goto :goto_3

    .line 87
    :cond_5
    const/4 v5, 0x0

    .line 88
    :goto_3
    const/4 v7, 0x2

    .line 89
    if-eqz v0, :cond_7

    .line 90
    .line 91
    invoke-virtual {p0, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasDanglingDimension(I)Z

    .line 92
    .line 93
    .line 94
    move-result v8

    .line 95
    if-eqz v8, :cond_7

    .line 96
    .line 97
    iget v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    .line 98
    .line 99
    if-nez v8, :cond_7

    .line 100
    .line 101
    if-nez v6, :cond_7

    .line 102
    .line 103
    iput v7, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 104
    .line 105
    if-eqz v4, :cond_6

    .line 106
    .line 107
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    .line 108
    .line 109
    if-nez v0, :cond_6

    .line 110
    .line 111
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 112
    .line 113
    :cond_6
    const/4 v0, 0x0

    .line 114
    :cond_7
    if-eqz v4, :cond_9

    .line 115
    .line 116
    invoke-virtual {p0, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->hasDanglingDimension(I)Z

    .line 117
    .line 118
    .line 119
    move-result v8

    .line 120
    if-eqz v8, :cond_9

    .line 121
    .line 122
    iget v8, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    .line 123
    .line 124
    if-nez v8, :cond_9

    .line 125
    .line 126
    if-nez v5, :cond_9

    .line 127
    .line 128
    iput v7, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 129
    .line 130
    if-eqz v0, :cond_8

    .line 131
    .line 132
    iget v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    .line 133
    .line 134
    if-nez v4, :cond_8

    .line 135
    .line 136
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 137
    .line 138
    :cond_8
    const/4 v4, 0x0

    .line 139
    :cond_9
    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isResolvedHorizontally()Z

    .line 140
    .line 141
    .line 142
    move-result v8

    .line 143
    if-eqz v8, :cond_a

    .line 144
    .line 145
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 146
    .line 147
    const/4 v0, 0x0

    .line 148
    :cond_a
    invoke-virtual {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isResolvedVertically()Z

    .line 149
    .line 150
    .line 151
    move-result v8

    .line 152
    if-eqz v8, :cond_b

    .line 153
    .line 154
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 155
    .line 156
    const/4 v4, 0x0

    .line 157
    :cond_b
    const/4 v8, 0x4

    .line 158
    if-eqz v6, :cond_e

    .line 159
    .line 160
    aget v6, v1, v3

    .line 161
    .line 162
    if-ne v6, v8, :cond_c

    .line 163
    .line 164
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 165
    .line 166
    goto :goto_5

    .line 167
    :cond_c
    if-nez v4, :cond_e

    .line 168
    .line 169
    iget v4, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 170
    .line 171
    if-ne v4, v2, :cond_d

    .line 172
    .line 173
    iget v4, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalDimension:I

    .line 174
    .line 175
    goto :goto_4

    .line 176
    :cond_d
    iput v7, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 177
    .line 178
    invoke-virtual {p1, p0, p2}, Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V

    .line 179
    .line 180
    .line 181
    iget v4, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredHeight:I

    .line 182
    .line 183
    :goto_4
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 184
    .line 185
    iget v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    .line 186
    .line 187
    int-to-float v4, v4

    .line 188
    mul-float v6, v6, v4

    .line 189
    .line 190
    float-to-int v4, v6

    .line 191
    iput v4, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalDimension:I

    .line 192
    .line 193
    :cond_e
    :goto_5
    if-eqz v5, :cond_12

    .line 194
    .line 195
    aget v1, v1, v2

    .line 196
    .line 197
    if-ne v1, v8, :cond_f

    .line 198
    .line 199
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 200
    .line 201
    goto :goto_7

    .line 202
    :cond_f
    if-nez v0, :cond_12

    .line 203
    .line 204
    iget v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalBehavior:I

    .line 205
    .line 206
    if-ne v0, v2, :cond_10

    .line 207
    .line 208
    iget v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->horizontalDimension:I

    .line 209
    .line 210
    goto :goto_6

    .line 211
    :cond_10
    iput v7, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 212
    .line 213
    invoke-virtual {p1, p0, p2}, Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V

    .line 214
    .line 215
    .line 216
    iget v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredWidth:I

    .line 217
    .line 218
    :goto_6
    iput v2, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalBehavior:I

    .line 219
    .line 220
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatioSide:I

    .line 221
    .line 222
    const/4 v2, -0x1

    .line 223
    if-ne v1, v2, :cond_11

    .line 224
    .line 225
    int-to-float v0, v0

    .line 226
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    .line 227
    .line 228
    div-float/2addr v0, v1

    .line 229
    float-to-int v0, v0

    .line 230
    iput v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalDimension:I

    .line 231
    .line 232
    goto :goto_7

    .line 233
    :cond_11
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mDimensionRatio:F

    .line 234
    .line 235
    int-to-float v0, v0

    .line 236
    mul-float v1, v1, v0

    .line 237
    .line 238
    float-to-int v0, v1

    .line 239
    iput v0, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->verticalDimension:I

    .line 240
    .line 241
    :cond_12
    :goto_7
    invoke-virtual {p1, p0, p2}, Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V

    .line 242
    .line 243
    .line 244
    iget p1, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredWidth:I

    .line 245
    .line 246
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    .line 247
    .line 248
    .line 249
    iget p1, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredHeight:I

    .line 250
    .line 251
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    .line 252
    .line 253
    .line 254
    iget-boolean p1, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredHasBaseline:Z

    .line 255
    .line 256
    iput-boolean p1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHasBaseline:Z

    .line 257
    .line 258
    iget p1, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredBaseline:I

    .line 259
    .line 260
    invoke-virtual {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setBaselineDistance(I)V

    .line 261
    .line 262
    .line 263
    iput v3, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measureStrategy:I

    .line 264
    .line 265
    return-void

    .line 266
    :cond_13
    :goto_8
    iput v3, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredWidth:I

    .line 267
    .line 268
    iput v3, p2, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;->measuredHeight:I

    .line 269
    .line 270
    return-void
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


# virtual methods
.method public final addChain(Landroidx/constraintlayout/core/widgets/ConstraintWidget;I)V
    .locals 5

    .line 1
    const/4 v0, 0x1

    .line 2
    if-nez p2, :cond_1

    .line 3
    .line 4
    iget p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsSize:I

    .line 5
    .line 6
    add-int/2addr p2, v0

    .line 7
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 8
    .line 9
    array-length v2, v1

    .line 10
    if-lt p2, v2, :cond_0

    .line 11
    .line 12
    array-length p2, v1

    .line 13
    mul-int/lit8 p2, p2, 0x2

    .line 14
    .line 15
    invoke-static {v1, p2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object p2

    .line 19
    check-cast p2, [Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 20
    .line 21
    iput-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 22
    .line 23
    :cond_0
    iget-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 24
    .line 25
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsSize:I

    .line 26
    .line 27
    new-instance v2, Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 28
    .line 29
    const/4 v3, 0x0

    .line 30
    iget-boolean v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mIsRtl:Z

    .line 31
    .line 32
    invoke-direct {v2, p1, v3, v4}, Landroidx/constraintlayout/core/widgets/ChainHead;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;IZ)V

    .line 33
    .line 34
    .line 35
    aput-object v2, p2, v1

    .line 36
    .line 37
    add-int/2addr v1, v0

    .line 38
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsSize:I

    .line 39
    .line 40
    return-void

    .line 41
    :cond_1
    if-ne p2, v0, :cond_3

    .line 42
    .line 43
    iget p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsSize:I

    .line 44
    .line 45
    add-int/2addr p2, v0

    .line 46
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 47
    .line 48
    array-length v2, v1

    .line 49
    if-lt p2, v2, :cond_2

    .line 50
    .line 51
    array-length p2, v1

    .line 52
    mul-int/lit8 p2, p2, 0x2

    .line 53
    .line 54
    invoke-static {v1, p2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    .line 55
    .line 56
    .line 57
    move-result-object p2

    .line 58
    check-cast p2, [Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 59
    .line 60
    iput-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 61
    .line 62
    :cond_2
    iget-object p2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsArray:[Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 63
    .line 64
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsSize:I

    .line 65
    .line 66
    new-instance v2, Landroidx/constraintlayout/core/widgets/ChainHead;

    .line 67
    .line 68
    iget-boolean v3, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mIsRtl:Z

    .line 69
    .line 70
    invoke-direct {v2, p1, v0, v3}, Landroidx/constraintlayout/core/widgets/ChainHead;-><init>(Landroidx/constraintlayout/core/widgets/ConstraintWidget;IZ)V

    .line 71
    .line 72
    .line 73
    aput-object v2, p2, v1

    .line 74
    .line 75
    add-int/2addr v1, v0

    .line 76
    iput v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsSize:I

    .line 77
    .line 78
    :cond_3
    return-void
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

.method public final addChildrenToSolver(Landroidx/constraintlayout/core/LinearSystem;)V
    .locals 12

    .line 1
    const/16 v0, 0x40

    .line 2
    .line 3
    invoke-virtual {p0, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    invoke-virtual {p0, p1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 8
    .line 9
    .line 10
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 11
    .line 12
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 13
    .line 14
    .line 15
    move-result v1

    .line 16
    const/4 v2, 0x0

    .line 17
    const/4 v3, 0x0

    .line 18
    const/4 v4, 0x0

    .line 19
    :goto_0
    const/4 v5, 0x1

    .line 20
    if-ge v3, v1, :cond_1

    .line 21
    .line 22
    iget-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 23
    .line 24
    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 25
    .line 26
    .line 27
    move-result-object v6

    .line 28
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 29
    .line 30
    iget-object v7, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    .line 31
    .line 32
    aput-boolean v2, v7, v2

    .line 33
    .line 34
    aput-boolean v2, v7, v5

    .line 35
    .line 36
    instance-of v6, v6, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 37
    .line 38
    if-eqz v6, :cond_0

    .line 39
    .line 40
    const/4 v4, 0x1

    .line 41
    :cond_0
    add-int/lit8 v3, v3, 0x1

    .line 42
    .line 43
    goto :goto_0

    .line 44
    :cond_1
    const/4 v3, 0x2

    .line 45
    if-eqz v4, :cond_8

    .line 46
    .line 47
    const/4 v4, 0x0

    .line 48
    :goto_1
    if-ge v4, v1, :cond_8

    .line 49
    .line 50
    iget-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 51
    .line 52
    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 53
    .line 54
    .line 55
    move-result-object v6

    .line 56
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 57
    .line 58
    instance-of v7, v6, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 59
    .line 60
    if-eqz v7, :cond_7

    .line 61
    .line 62
    check-cast v6, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 63
    .line 64
    const/4 v7, 0x0

    .line 65
    :goto_2
    iget v8, v6, Landroidx/constraintlayout/core/widgets/HelperWidget;->mWidgetsCount:I

    .line 66
    .line 67
    if-ge v7, v8, :cond_7

    .line 68
    .line 69
    iget-object v8, v6, Landroidx/constraintlayout/core/widgets/HelperWidget;->mWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 70
    .line 71
    aget-object v8, v8, v7

    .line 72
    .line 73
    iget-boolean v9, v6, Landroidx/constraintlayout/core/widgets/Barrier;->mAllowsGoneWidget:Z

    .line 74
    .line 75
    if-nez v9, :cond_2

    .line 76
    .line 77
    invoke-virtual {v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->allowedInBarrier()Z

    .line 78
    .line 79
    .line 80
    move-result v9

    .line 81
    if-nez v9, :cond_2

    .line 82
    .line 83
    goto :goto_4

    .line 84
    :cond_2
    iget v9, v6, Landroidx/constraintlayout/core/widgets/Barrier;->mBarrierType:I

    .line 85
    .line 86
    if-eqz v9, :cond_5

    .line 87
    .line 88
    if-ne v9, v5, :cond_3

    .line 89
    .line 90
    goto :goto_3

    .line 91
    :cond_3
    if-eq v9, v3, :cond_4

    .line 92
    .line 93
    const/4 v10, 0x3

    .line 94
    if-ne v9, v10, :cond_6

    .line 95
    .line 96
    :cond_4
    iget-object v8, v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    .line 97
    .line 98
    aput-boolean v5, v8, v5

    .line 99
    .line 100
    goto :goto_4

    .line 101
    :cond_5
    :goto_3
    iget-object v8, v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mIsInBarrier:[Z

    .line 102
    .line 103
    aput-boolean v5, v8, v2

    .line 104
    .line 105
    :cond_6
    :goto_4
    add-int/lit8 v7, v7, 0x1

    .line 106
    .line 107
    goto :goto_2

    .line 108
    :cond_7
    add-int/lit8 v4, v4, 0x1

    .line 109
    .line 110
    goto :goto_1

    .line 111
    :cond_8
    iget-object v4, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mWidgetsToAdd:Ljava/util/HashSet;

    .line 112
    .line 113
    invoke-virtual {v4}, Ljava/util/HashSet;->clear()V

    .line 114
    .line 115
    .line 116
    const/4 v6, 0x0

    .line 117
    :goto_5
    if-ge v6, v1, :cond_c

    .line 118
    .line 119
    iget-object v7, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 120
    .line 121
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 122
    .line 123
    .line 124
    move-result-object v7

    .line 125
    check-cast v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 126
    .line 127
    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 128
    .line 129
    .line 130
    instance-of v8, v7, Landroidx/constraintlayout/core/widgets/Flow;

    .line 131
    .line 132
    if-nez v8, :cond_9

    .line 133
    .line 134
    instance-of v9, v7, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 135
    .line 136
    if-eqz v9, :cond_b

    .line 137
    .line 138
    :cond_9
    if-eqz v8, :cond_a

    .line 139
    .line 140
    invoke-virtual {v4, v7}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 141
    .line 142
    .line 143
    goto :goto_6

    .line 144
    :cond_a
    invoke-virtual {v7, p1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 145
    .line 146
    .line 147
    :cond_b
    :goto_6
    add-int/lit8 v6, v6, 0x1

    .line 148
    .line 149
    goto :goto_5

    .line 150
    :cond_c
    :goto_7
    invoke-virtual {v4}, Ljava/util/HashSet;->size()I

    .line 151
    .line 152
    .line 153
    move-result v6

    .line 154
    if-lez v6, :cond_11

    .line 155
    .line 156
    invoke-virtual {v4}, Ljava/util/HashSet;->size()I

    .line 157
    .line 158
    .line 159
    move-result v6

    .line 160
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 161
    .line 162
    .line 163
    move-result-object v7

    .line 164
    :cond_d
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    .line 165
    .line 166
    .line 167
    move-result v8

    .line 168
    if-eqz v8, :cond_f

    .line 169
    .line 170
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 171
    .line 172
    .line 173
    move-result-object v8

    .line 174
    check-cast v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 175
    .line 176
    check-cast v8, Landroidx/constraintlayout/core/widgets/Flow;

    .line 177
    .line 178
    const/4 v9, 0x0

    .line 179
    :goto_8
    iget v10, v8, Landroidx/constraintlayout/core/widgets/HelperWidget;->mWidgetsCount:I

    .line 180
    .line 181
    if-ge v9, v10, :cond_d

    .line 182
    .line 183
    iget-object v10, v8, Landroidx/constraintlayout/core/widgets/HelperWidget;->mWidgets:[Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 184
    .line 185
    aget-object v10, v10, v9

    .line 186
    .line 187
    invoke-virtual {v4, v10}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    .line 188
    .line 189
    .line 190
    move-result v10

    .line 191
    if-eqz v10, :cond_e

    .line 192
    .line 193
    invoke-virtual {v8, p1, v0}, Landroidx/constraintlayout/core/widgets/Flow;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 194
    .line 195
    .line 196
    invoke-virtual {v4, v8}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 197
    .line 198
    .line 199
    goto :goto_9

    .line 200
    :cond_e
    add-int/lit8 v9, v9, 0x1

    .line 201
    .line 202
    goto :goto_8

    .line 203
    :cond_f
    :goto_9
    invoke-virtual {v4}, Ljava/util/HashSet;->size()I

    .line 204
    .line 205
    .line 206
    move-result v7

    .line 207
    if-ne v6, v7, :cond_c

    .line 208
    .line 209
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 210
    .line 211
    .line 212
    move-result-object v6

    .line 213
    :goto_a
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    .line 214
    .line 215
    .line 216
    move-result v7

    .line 217
    if-eqz v7, :cond_10

    .line 218
    .line 219
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 220
    .line 221
    .line 222
    move-result-object v7

    .line 223
    check-cast v7, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 224
    .line 225
    invoke-virtual {v7, p1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 226
    .line 227
    .line 228
    goto :goto_a

    .line 229
    :cond_10
    invoke-virtual {v4}, Ljava/util/HashSet;->clear()V

    .line 230
    .line 231
    .line 232
    goto :goto_7

    .line 233
    :cond_11
    sget-boolean v4, Landroidx/constraintlayout/core/LinearSystem;->USE_DEPENDENCY_ORDERING:Z

    .line 234
    .line 235
    if-eqz v4, :cond_16

    .line 236
    .line 237
    new-instance v9, Ljava/util/HashSet;

    .line 238
    .line 239
    invoke-direct {v9}, Ljava/util/HashSet;-><init>()V

    .line 240
    .line 241
    .line 242
    const/4 v4, 0x0

    .line 243
    :goto_b
    if-ge v4, v1, :cond_14

    .line 244
    .line 245
    iget-object v6, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 246
    .line 247
    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 248
    .line 249
    .line 250
    move-result-object v6

    .line 251
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 252
    .line 253
    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 254
    .line 255
    .line 256
    instance-of v7, v6, Landroidx/constraintlayout/core/widgets/Flow;

    .line 257
    .line 258
    if-nez v7, :cond_13

    .line 259
    .line 260
    instance-of v7, v6, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 261
    .line 262
    if-eqz v7, :cond_12

    .line 263
    .line 264
    goto :goto_c

    .line 265
    :cond_12
    invoke-virtual {v9, v6}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 266
    .line 267
    .line 268
    :cond_13
    :goto_c
    add-int/lit8 v4, v4, 0x1

    .line 269
    .line 270
    goto :goto_b

    .line 271
    :cond_14
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 272
    .line 273
    aget v1, v1, v2

    .line 274
    .line 275
    if-ne v1, v3, :cond_15

    .line 276
    .line 277
    const/4 v10, 0x0

    .line 278
    goto :goto_d

    .line 279
    :cond_15
    const/4 v10, 0x1

    .line 280
    :goto_d
    const/4 v11, 0x0

    .line 281
    move-object v7, p0

    .line 282
    move-object v6, p0

    .line 283
    move-object v8, p1

    .line 284
    invoke-virtual/range {v6 .. v11}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addChildrenToSolverByDependency(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/HashSet;IZ)V

    .line 285
    .line 286
    .line 287
    invoke-virtual {v9}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 288
    .line 289
    .line 290
    move-result-object p1

    .line 291
    :goto_e
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 292
    .line 293
    .line 294
    move-result v1

    .line 295
    if-eqz v1, :cond_1d

    .line 296
    .line 297
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 298
    .line 299
    .line 300
    move-result-object v1

    .line 301
    check-cast v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 302
    .line 303
    invoke-static {p0, v8, v1}, Landroidx/constraintlayout/core/widgets/Chain;->checkMatchParent(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    .line 304
    .line 305
    .line 306
    invoke-virtual {v1, v8, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 307
    .line 308
    .line 309
    goto :goto_e

    .line 310
    :cond_16
    move-object v6, p0

    .line 311
    move-object v8, p1

    .line 312
    const/4 p1, 0x0

    .line 313
    :goto_f
    if-ge p1, v1, :cond_1d

    .line 314
    .line 315
    iget-object v4, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 316
    .line 317
    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 318
    .line 319
    .line 320
    move-result-object v4

    .line 321
    check-cast v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 322
    .line 323
    instance-of v7, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 324
    .line 325
    if-eqz v7, :cond_1a

    .line 326
    .line 327
    iget-object v7, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 328
    .line 329
    aget v9, v7, v2

    .line 330
    .line 331
    aget v7, v7, v5

    .line 332
    .line 333
    if-ne v9, v3, :cond_17

    .line 334
    .line 335
    invoke-virtual {v4, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalDimensionBehaviour(I)V

    .line 336
    .line 337
    .line 338
    :cond_17
    if-ne v7, v3, :cond_18

    .line 339
    .line 340
    invoke-virtual {v4, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalDimensionBehaviour(I)V

    .line 341
    .line 342
    .line 343
    :cond_18
    invoke-virtual {v4, v8, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 344
    .line 345
    .line 346
    if-ne v9, v3, :cond_19

    .line 347
    .line 348
    invoke-virtual {v4, v9}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalDimensionBehaviour(I)V

    .line 349
    .line 350
    .line 351
    :cond_19
    if-ne v7, v3, :cond_1c

    .line 352
    .line 353
    invoke-virtual {v4, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalDimensionBehaviour(I)V

    .line 354
    .line 355
    .line 356
    goto :goto_10

    .line 357
    :cond_1a
    invoke-static {p0, v8, v4}, Landroidx/constraintlayout/core/widgets/Chain;->checkMatchParent(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Landroidx/constraintlayout/core/widgets/ConstraintWidget;)V

    .line 358
    .line 359
    .line 360
    instance-of v7, v4, Landroidx/constraintlayout/core/widgets/Flow;

    .line 361
    .line 362
    if-nez v7, :cond_1c

    .line 363
    .line 364
    instance-of v7, v4, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 365
    .line 366
    if-eqz v7, :cond_1b

    .line 367
    .line 368
    goto :goto_10

    .line 369
    :cond_1b
    invoke-virtual {v4, v8, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->addToSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 370
    .line 371
    .line 372
    :cond_1c
    :goto_10
    add-int/lit8 p1, p1, 0x1

    .line 373
    .line 374
    goto :goto_f

    .line 375
    :cond_1d
    iget p1, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsSize:I

    .line 376
    .line 377
    const/4 v0, 0x0

    .line 378
    if-lez p1, :cond_1e

    .line 379
    .line 380
    invoke-static {p0, v8, v0, v2}, Landroidx/constraintlayout/core/widgets/Chain;->applyChainConstraints(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/ArrayList;I)V

    .line 381
    .line 382
    .line 383
    :cond_1e
    iget p1, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsSize:I

    .line 384
    .line 385
    if-lez p1, :cond_1f

    .line 386
    .line 387
    invoke-static {p0, v8, v0, v5}, Landroidx/constraintlayout/core/widgets/Chain;->applyChainConstraints(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;Landroidx/constraintlayout/core/LinearSystem;Ljava/util/ArrayList;I)V

    .line 388
    .line 389
    .line 390
    :cond_1f
    return-void
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
.end method

.method public final directMeasureWithOrientation(IZ)Z
    .locals 17

    .line 1
    move/from16 v0, p1

    .line 2
    .line 3
    move-object/from16 v1, p0

    .line 4
    .line 5
    iget-object v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mDependencyGraph:Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;

    .line 6
    .line 7
    iget-object v3, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mRuns:Ljava/util/ArrayList;

    .line 8
    .line 9
    iget-object v4, v2, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->mWidgetcontainer:Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 10
    .line 11
    const/4 v5, 0x0

    .line 12
    invoke-virtual {v4, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionBehaviour(I)I

    .line 13
    .line 14
    .line 15
    move-result v6

    .line 16
    iget-object v7, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 17
    .line 18
    const/4 v8, 0x1

    .line 19
    invoke-virtual {v4, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionBehaviour(I)I

    .line 20
    .line 21
    .line 22
    move-result v9

    .line 23
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getX()I

    .line 24
    .line 25
    .line 26
    move-result v10

    .line 27
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getY()I

    .line 28
    .line 29
    .line 30
    move-result v11

    .line 31
    if-eqz p2, :cond_4

    .line 32
    .line 33
    const/4 v12, 0x2

    .line 34
    if-eq v6, v12, :cond_0

    .line 35
    .line 36
    if-ne v9, v12, :cond_4

    .line 37
    .line 38
    :cond_0
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 39
    .line 40
    .line 41
    move-result v13

    .line 42
    const/4 v14, 0x0

    .line 43
    :goto_0
    if-ge v14, v13, :cond_2

    .line 44
    .line 45
    invoke-virtual {v3, v14}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 46
    .line 47
    .line 48
    move-result-object v15

    .line 49
    add-int/lit8 v14, v14, 0x1

    .line 50
    .line 51
    check-cast v15, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    .line 52
    .line 53
    iget v5, v15, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->orientation:I

    .line 54
    .line 55
    if-ne v5, v0, :cond_1

    .line 56
    .line 57
    invoke-virtual {v15}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->supportsWrapComputation()Z

    .line 58
    .line 59
    .line 60
    move-result v5

    .line 61
    if-nez v5, :cond_1

    .line 62
    .line 63
    const/4 v5, 0x0

    .line 64
    goto :goto_1

    .line 65
    :cond_1
    const/4 v5, 0x0

    .line 66
    goto :goto_0

    .line 67
    :cond_2
    move/from16 v5, p2

    .line 68
    .line 69
    :goto_1
    if-nez v0, :cond_3

    .line 70
    .line 71
    if-eqz v5, :cond_4

    .line 72
    .line 73
    if-ne v6, v12, :cond_4

    .line 74
    .line 75
    invoke-virtual {v4, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalDimensionBehaviour(I)V

    .line 76
    .line 77
    .line 78
    const/4 v5, 0x0

    .line 79
    invoke-virtual {v2, v4, v5}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->computeWrap(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;I)I

    .line 80
    .line 81
    .line 82
    move-result v12

    .line 83
    invoke-virtual {v4, v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    .line 84
    .line 85
    .line 86
    iget-object v5, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 87
    .line 88
    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mDimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    .line 89
    .line 90
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 91
    .line 92
    .line 93
    move-result v12

    .line 94
    invoke-virtual {v5, v12}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    .line 95
    .line 96
    .line 97
    goto :goto_2

    .line 98
    :cond_3
    if-eqz v5, :cond_4

    .line 99
    .line 100
    if-ne v9, v12, :cond_4

    .line 101
    .line 102
    invoke-virtual {v4, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalDimensionBehaviour(I)V

    .line 103
    .line 104
    .line 105
    invoke-virtual {v2, v4, v8}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->computeWrap(Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;I)I

    .line 106
    .line 107
    .line 108
    move-result v5

    .line 109
    invoke-virtual {v4, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    .line 110
    .line 111
    .line 112
    iget-object v5, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 113
    .line 114
    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mDimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    .line 115
    .line 116
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 117
    .line 118
    .line 119
    move-result v12

    .line 120
    invoke-virtual {v5, v12}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    .line 121
    .line 122
    .line 123
    :cond_4
    :goto_2
    const/4 v5, 0x4

    .line 124
    if-nez v0, :cond_6

    .line 125
    .line 126
    const/16 v16, 0x0

    .line 127
    .line 128
    aget v7, v7, v16

    .line 129
    .line 130
    if-eq v7, v8, :cond_5

    .line 131
    .line 132
    if-ne v7, v5, :cond_7

    .line 133
    .line 134
    :cond_5
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 135
    .line 136
    .line 137
    move-result v5

    .line 138
    add-int/2addr v5, v10

    .line 139
    iget-object v7, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 140
    .line 141
    iget-object v7, v7, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 142
    .line 143
    invoke-virtual {v7, v5}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolve(I)V

    .line 144
    .line 145
    .line 146
    iget-object v7, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHorizontalRun:Landroidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun;

    .line 147
    .line 148
    iget-object v7, v7, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mDimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    .line 149
    .line 150
    sub-int/2addr v5, v10

    .line 151
    invoke-virtual {v7, v5}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    .line 152
    .line 153
    .line 154
    :goto_3
    const/4 v5, 0x1

    .line 155
    goto :goto_5

    .line 156
    :cond_6
    const/16 v16, 0x0

    .line 157
    .line 158
    aget v7, v7, v8

    .line 159
    .line 160
    if-eq v7, v8, :cond_8

    .line 161
    .line 162
    if-ne v7, v5, :cond_7

    .line 163
    .line 164
    goto :goto_4

    .line 165
    :cond_7
    const/4 v5, 0x0

    .line 166
    goto :goto_5

    .line 167
    :cond_8
    :goto_4
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 168
    .line 169
    .line 170
    move-result v5

    .line 171
    add-int/2addr v5, v11

    .line 172
    iget-object v7, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 173
    .line 174
    iget-object v7, v7, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 175
    .line 176
    invoke-virtual {v7, v5}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolve(I)V

    .line 177
    .line 178
    .line 179
    iget-object v7, v4, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mVerticalRun:Landroidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun;

    .line 180
    .line 181
    iget-object v7, v7, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mDimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    .line 182
    .line 183
    sub-int/2addr v5, v11

    .line 184
    invoke-virtual {v7, v5}, Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;->resolve(I)V

    .line 185
    .line 186
    .line 187
    goto :goto_3

    .line 188
    :goto_5
    invoke-virtual {v2}, Landroidx/constraintlayout/core/widgets/analyzer/DependencyGraph;->measureWidgets()V

    .line 189
    .line 190
    .line 191
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 192
    .line 193
    .line 194
    move-result v2

    .line 195
    const/4 v7, 0x0

    .line 196
    :goto_6
    if-ge v7, v2, :cond_b

    .line 197
    .line 198
    invoke-virtual {v3, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 199
    .line 200
    .line 201
    move-result-object v10

    .line 202
    add-int/lit8 v7, v7, 0x1

    .line 203
    .line 204
    check-cast v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    .line 205
    .line 206
    iget v11, v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->orientation:I

    .line 207
    .line 208
    if-eq v11, v0, :cond_9

    .line 209
    .line 210
    goto :goto_6

    .line 211
    :cond_9
    iget-object v11, v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 212
    .line 213
    if-ne v11, v4, :cond_a

    .line 214
    .line 215
    iget-boolean v11, v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mResolved:Z

    .line 216
    .line 217
    if-nez v11, :cond_a

    .line 218
    .line 219
    goto :goto_6

    .line 220
    :cond_a
    invoke-virtual {v10}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->applyToWidget()V

    .line 221
    .line 222
    .line 223
    goto :goto_6

    .line 224
    :cond_b
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 225
    .line 226
    .line 227
    move-result v2

    .line 228
    const/4 v7, 0x0

    .line 229
    :cond_c
    :goto_7
    if-ge v7, v2, :cond_11

    .line 230
    .line 231
    invoke-virtual {v3, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 232
    .line 233
    .line 234
    move-result-object v10

    .line 235
    add-int/lit8 v7, v7, 0x1

    .line 236
    .line 237
    check-cast v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;

    .line 238
    .line 239
    iget v11, v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->orientation:I

    .line 240
    .line 241
    if-eq v11, v0, :cond_d

    .line 242
    .line 243
    goto :goto_7

    .line 244
    :cond_d
    if-nez v5, :cond_e

    .line 245
    .line 246
    iget-object v11, v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mWidget:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 247
    .line 248
    if-ne v11, v4, :cond_e

    .line 249
    .line 250
    goto :goto_7

    .line 251
    :cond_e
    iget-object v11, v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->start:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 252
    .line 253
    iget-boolean v11, v11, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 254
    .line 255
    if-nez v11, :cond_f

    .line 256
    .line 257
    :goto_8
    const/4 v5, 0x0

    .line 258
    goto :goto_9

    .line 259
    :cond_f
    iget-object v11, v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->end:Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;

    .line 260
    .line 261
    iget-boolean v11, v11, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 262
    .line 263
    if-nez v11, :cond_10

    .line 264
    .line 265
    goto :goto_8

    .line 266
    :cond_10
    instance-of v11, v10, Landroidx/constraintlayout/core/widgets/analyzer/ChainRun;

    .line 267
    .line 268
    if-nez v11, :cond_c

    .line 269
    .line 270
    iget-object v10, v10, Landroidx/constraintlayout/core/widgets/analyzer/WidgetRun;->mDimension:Landroidx/constraintlayout/core/widgets/analyzer/DimensionDependency;

    .line 271
    .line 272
    iget-boolean v10, v10, Landroidx/constraintlayout/core/widgets/analyzer/DependencyNode;->resolved:Z

    .line 273
    .line 274
    if-nez v10, :cond_c

    .line 275
    .line 276
    goto :goto_8

    .line 277
    :cond_11
    const/4 v5, 0x1

    .line 278
    :goto_9
    invoke-virtual {v4, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalDimensionBehaviour(I)V

    .line 279
    .line 280
    .line 281
    invoke-virtual {v4, v9}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalDimensionBehaviour(I)V

    .line 282
    .line 283
    .line 284
    return v5
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

.method public final getSceneString(Ljava/lang/StringBuilder;)V
    .locals 4

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 4
    .line 5
    .line 6
    iget-object v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->stringId:Ljava/lang/String;

    .line 7
    .line 8
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 9
    .line 10
    .line 11
    const-string v1, ":{\n"

    .line 12
    .line 13
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 14
    .line 15
    .line 16
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 21
    .line 22
    .line 23
    new-instance v0, Ljava/lang/StringBuilder;

    .line 24
    .line 25
    const-string v1, "  actualWidth:"

    .line 26
    .line 27
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 28
    .line 29
    .line 30
    iget v1, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidth:I

    .line 31
    .line 32
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 33
    .line 34
    .line 35
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 36
    .line 37
    .line 38
    move-result-object v0

    .line 39
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 40
    .line 41
    .line 42
    const-string v0, "\n"

    .line 43
    .line 44
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 45
    .line 46
    .line 47
    new-instance v1, Ljava/lang/StringBuilder;

    .line 48
    .line 49
    const-string v2, "  actualHeight:"

    .line 50
    .line 51
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 52
    .line 53
    .line 54
    iget v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeight:I

    .line 55
    .line 56
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 57
    .line 58
    .line 59
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 60
    .line 61
    .line 62
    move-result-object v1

    .line 63
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 64
    .line 65
    .line 66
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 67
    .line 68
    .line 69
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 70
    .line 71
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 72
    .line 73
    .line 74
    move-result v1

    .line 75
    const/4 v2, 0x0

    .line 76
    :goto_0
    if-ge v2, v1, :cond_0

    .line 77
    .line 78
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 79
    .line 80
    .line 81
    move-result-object v3

    .line 82
    add-int/lit8 v2, v2, 0x1

    .line 83
    .line 84
    check-cast v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 85
    .line 86
    invoke-virtual {v3, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getSceneString(Ljava/lang/StringBuilder;)V

    .line 87
    .line 88
    .line 89
    const-string v3, ",\n"

    .line 90
    .line 91
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 92
    .line 93
    .line 94
    goto :goto_0

    .line 95
    :cond_0
    const-string v0, "}"

    .line 96
    .line 97
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 98
    .line 99
    .line 100
    return-void
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

.method public final layout()V
    .locals 32

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    const/4 v2, 0x0

    .line 4
    iput v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 5
    .line 6
    iput v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 7
    .line 8
    iput-boolean v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mWidthMeasuredTooSmall:Z

    .line 9
    .line 10
    iput-boolean v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHeightMeasuredTooSmall:Z

    .line 11
    .line 12
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 13
    .line 14
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 15
    .line 16
    .line 17
    move-result v3

    .line 18
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    invoke-static {v2, v0}, Ljava/lang/Math;->max(II)I

    .line 23
    .line 24
    .line 25
    move-result v0

    .line 26
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 27
    .line 28
    .line 29
    move-result v4

    .line 30
    invoke-static {v2, v4}, Ljava/lang/Math;->max(II)I

    .line 31
    .line 32
    .line 33
    move-result v4

    .line 34
    iget-object v5, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 35
    .line 36
    const/4 v6, 0x1

    .line 37
    aget v7, v5, v6

    .line 38
    .line 39
    aget v8, v5, v2

    .line 40
    .line 41
    iget v9, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mPass:I

    .line 42
    .line 43
    iget-object v11, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 44
    .line 45
    iget-object v12, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 46
    .line 47
    if-nez v9, :cond_1e

    .line 48
    .line 49
    iget v9, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mOptimizationLevel:I

    .line 50
    .line 51
    invoke-static {v9, v6}, Landroidx/constraintlayout/core/widgets/Chain;->enabled(II)Z

    .line 52
    .line 53
    .line 54
    move-result v9

    .line 55
    if-eqz v9, :cond_1e

    .line 56
    .line 57
    iget-object v9, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMeasurer:Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;

    .line 58
    .line 59
    aget v14, v5, v2

    .line 60
    .line 61
    aget v15, v5, v6

    .line 62
    .line 63
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resetFinalResolution()V

    .line 64
    .line 65
    .line 66
    iget-object v10, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 67
    .line 68
    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    .line 69
    .line 70
    .line 71
    move-result v13

    .line 72
    :goto_0
    if-ge v2, v13, :cond_0

    .line 73
    .line 74
    invoke-virtual {v10, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 75
    .line 76
    .line 77
    move-result-object v18

    .line 78
    check-cast v18, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 79
    .line 80
    invoke-virtual/range {v18 .. v18}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resetFinalResolution()V

    .line 81
    .line 82
    .line 83
    add-int/lit8 v2, v2, 0x1

    .line 84
    .line 85
    goto :goto_0

    .line 86
    :cond_0
    iget-boolean v2, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mIsRtl:Z

    .line 87
    .line 88
    if-ne v14, v6, :cond_1

    .line 89
    .line 90
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 91
    .line 92
    .line 93
    move-result v14

    .line 94
    const/4 v6, 0x0

    .line 95
    invoke-virtual {v1, v6, v14}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setFinalHorizontal(II)V

    .line 96
    .line 97
    .line 98
    goto :goto_1

    .line 99
    :cond_1
    const/4 v6, 0x0

    .line 100
    invoke-virtual {v12, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    .line 101
    .line 102
    .line 103
    iput v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 104
    .line 105
    :goto_1
    const/4 v6, 0x0

    .line 106
    const/4 v14, 0x0

    .line 107
    const/16 v19, 0x0

    .line 108
    .line 109
    :goto_2
    const/high16 v20, 0x3f000000    # 0.5f

    .line 110
    .line 111
    if-ge v6, v13, :cond_7

    .line 112
    .line 113
    invoke-virtual {v10, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 114
    .line 115
    .line 116
    move-result-object v21

    .line 117
    move-object/from16 v22, v5

    .line 118
    .line 119
    move-object/from16 v5, v21

    .line 120
    .line 121
    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 122
    .line 123
    move/from16 v21, v6

    .line 124
    .line 125
    instance-of v6, v5, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 126
    .line 127
    if-eqz v6, :cond_6

    .line 128
    .line 129
    check-cast v5, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 130
    .line 131
    iget v6, v5, Landroidx/constraintlayout/core/widgets/Guideline;->mOrientation:I

    .line 132
    .line 133
    move/from16 v23, v14

    .line 134
    .line 135
    const/4 v14, 0x1

    .line 136
    if-ne v6, v14, :cond_5

    .line 137
    .line 138
    iget v6, v5, Landroidx/constraintlayout/core/widgets/Guideline;->mRelativeBegin:I

    .line 139
    .line 140
    const/4 v14, -0x1

    .line 141
    if-eq v6, v14, :cond_2

    .line 142
    .line 143
    invoke-virtual {v5, v6}, Landroidx/constraintlayout/core/widgets/Guideline;->setFinalValue(I)V

    .line 144
    .line 145
    .line 146
    goto :goto_3

    .line 147
    :cond_2
    iget v6, v5, Landroidx/constraintlayout/core/widgets/Guideline;->mRelativeEnd:I

    .line 148
    .line 149
    if-eq v6, v14, :cond_3

    .line 150
    .line 151
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isResolvedHorizontally()Z

    .line 152
    .line 153
    .line 154
    move-result v6

    .line 155
    if-eqz v6, :cond_3

    .line 156
    .line 157
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 158
    .line 159
    .line 160
    move-result v6

    .line 161
    iget v14, v5, Landroidx/constraintlayout/core/widgets/Guideline;->mRelativeEnd:I

    .line 162
    .line 163
    sub-int/2addr v6, v14

    .line 164
    invoke-virtual {v5, v6}, Landroidx/constraintlayout/core/widgets/Guideline;->setFinalValue(I)V

    .line 165
    .line 166
    .line 167
    goto :goto_3

    .line 168
    :cond_3
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isResolvedHorizontally()Z

    .line 169
    .line 170
    .line 171
    move-result v6

    .line 172
    if-eqz v6, :cond_4

    .line 173
    .line 174
    iget v6, v5, Landroidx/constraintlayout/core/widgets/Guideline;->mRelativePercent:F

    .line 175
    .line 176
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 177
    .line 178
    .line 179
    move-result v14

    .line 180
    int-to-float v14, v14

    .line 181
    mul-float v6, v6, v14

    .line 182
    .line 183
    add-float v6, v6, v20

    .line 184
    .line 185
    float-to-int v6, v6

    .line 186
    invoke-virtual {v5, v6}, Landroidx/constraintlayout/core/widgets/Guideline;->setFinalValue(I)V

    .line 187
    .line 188
    .line 189
    :cond_4
    :goto_3
    const/16 v23, 0x1

    .line 190
    .line 191
    :cond_5
    move/from16 v14, v23

    .line 192
    .line 193
    goto :goto_4

    .line 194
    :cond_6
    move/from16 v23, v14

    .line 195
    .line 196
    instance-of v6, v5, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 197
    .line 198
    if-eqz v6, :cond_5

    .line 199
    .line 200
    check-cast v5, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 201
    .line 202
    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/Barrier;->getOrientation()I

    .line 203
    .line 204
    .line 205
    move-result v5

    .line 206
    if-nez v5, :cond_5

    .line 207
    .line 208
    move/from16 v14, v23

    .line 209
    .line 210
    const/16 v19, 0x1

    .line 211
    .line 212
    :goto_4
    add-int/lit8 v6, v21, 0x1

    .line 213
    .line 214
    move-object/from16 v5, v22

    .line 215
    .line 216
    goto :goto_2

    .line 217
    :cond_7
    move-object/from16 v22, v5

    .line 218
    .line 219
    move/from16 v23, v14

    .line 220
    .line 221
    if-eqz v23, :cond_a

    .line 222
    .line 223
    const/4 v5, 0x0

    .line 224
    :goto_5
    if-ge v5, v13, :cond_a

    .line 225
    .line 226
    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 227
    .line 228
    .line 229
    move-result-object v6

    .line 230
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 231
    .line 232
    instance-of v14, v6, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 233
    .line 234
    if-eqz v14, :cond_9

    .line 235
    .line 236
    check-cast v6, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 237
    .line 238
    iget v14, v6, Landroidx/constraintlayout/core/widgets/Guideline;->mOrientation:I

    .line 239
    .line 240
    move/from16 v21, v5

    .line 241
    .line 242
    const/4 v5, 0x1

    .line 243
    if-ne v14, v5, :cond_8

    .line 244
    .line 245
    const/4 v5, 0x0

    .line 246
    invoke-static {v5, v6, v9, v2}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->horizontalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Z)V

    .line 247
    .line 248
    .line 249
    goto :goto_7

    .line 250
    :cond_8
    :goto_6
    const/4 v5, 0x0

    .line 251
    goto :goto_7

    .line 252
    :cond_9
    move/from16 v21, v5

    .line 253
    .line 254
    goto :goto_6

    .line 255
    :goto_7
    add-int/lit8 v6, v21, 0x1

    .line 256
    .line 257
    move v5, v6

    .line 258
    goto :goto_5

    .line 259
    :cond_a
    const/4 v5, 0x0

    .line 260
    invoke-static {v5, v1, v9, v2}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->horizontalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Z)V

    .line 261
    .line 262
    .line 263
    if-eqz v19, :cond_c

    .line 264
    .line 265
    const/4 v5, 0x0

    .line 266
    :goto_8
    if-ge v5, v13, :cond_c

    .line 267
    .line 268
    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 269
    .line 270
    .line 271
    move-result-object v6

    .line 272
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 273
    .line 274
    instance-of v14, v6, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 275
    .line 276
    if-eqz v14, :cond_b

    .line 277
    .line 278
    check-cast v6, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 279
    .line 280
    invoke-virtual {v6}, Landroidx/constraintlayout/core/widgets/Barrier;->getOrientation()I

    .line 281
    .line 282
    .line 283
    move-result v14

    .line 284
    if-nez v14, :cond_b

    .line 285
    .line 286
    invoke-virtual {v6}, Landroidx/constraintlayout/core/widgets/Barrier;->allSolved()Z

    .line 287
    .line 288
    .line 289
    move-result v14

    .line 290
    if-eqz v14, :cond_b

    .line 291
    .line 292
    const/4 v14, 0x1

    .line 293
    invoke-static {v14, v6, v9, v2}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->horizontalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Z)V

    .line 294
    .line 295
    .line 296
    goto :goto_9

    .line 297
    :cond_b
    const/4 v14, 0x1

    .line 298
    :goto_9
    add-int/lit8 v5, v5, 0x1

    .line 299
    .line 300
    goto :goto_8

    .line 301
    :cond_c
    const/4 v14, 0x1

    .line 302
    if-ne v15, v14, :cond_d

    .line 303
    .line 304
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 305
    .line 306
    .line 307
    move-result v5

    .line 308
    const/4 v6, 0x0

    .line 309
    invoke-virtual {v1, v6, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setFinalVertical(II)V

    .line 310
    .line 311
    .line 312
    goto :goto_a

    .line 313
    :cond_d
    const/4 v6, 0x0

    .line 314
    invoke-virtual {v11, v6}, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->setFinalValue(I)V

    .line 315
    .line 316
    .line 317
    iput v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 318
    .line 319
    :goto_a
    const/4 v5, 0x0

    .line 320
    const/4 v6, 0x0

    .line 321
    const/4 v14, 0x0

    .line 322
    :goto_b
    if-ge v5, v13, :cond_13

    .line 323
    .line 324
    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 325
    .line 326
    .line 327
    move-result-object v15

    .line 328
    check-cast v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 329
    .line 330
    move/from16 v19, v5

    .line 331
    .line 332
    instance-of v5, v15, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 333
    .line 334
    if-eqz v5, :cond_11

    .line 335
    .line 336
    check-cast v15, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 337
    .line 338
    iget v5, v15, Landroidx/constraintlayout/core/widgets/Guideline;->mOrientation:I

    .line 339
    .line 340
    if-nez v5, :cond_12

    .line 341
    .line 342
    iget v5, v15, Landroidx/constraintlayout/core/widgets/Guideline;->mRelativeBegin:I

    .line 343
    .line 344
    const/4 v6, -0x1

    .line 345
    if-eq v5, v6, :cond_e

    .line 346
    .line 347
    invoke-virtual {v15, v5}, Landroidx/constraintlayout/core/widgets/Guideline;->setFinalValue(I)V

    .line 348
    .line 349
    .line 350
    goto :goto_c

    .line 351
    :cond_e
    iget v5, v15, Landroidx/constraintlayout/core/widgets/Guideline;->mRelativeEnd:I

    .line 352
    .line 353
    if-eq v5, v6, :cond_f

    .line 354
    .line 355
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isResolvedVertically()Z

    .line 356
    .line 357
    .line 358
    move-result v5

    .line 359
    if-eqz v5, :cond_f

    .line 360
    .line 361
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 362
    .line 363
    .line 364
    move-result v5

    .line 365
    iget v6, v15, Landroidx/constraintlayout/core/widgets/Guideline;->mRelativeEnd:I

    .line 366
    .line 367
    sub-int/2addr v5, v6

    .line 368
    invoke-virtual {v15, v5}, Landroidx/constraintlayout/core/widgets/Guideline;->setFinalValue(I)V

    .line 369
    .line 370
    .line 371
    goto :goto_c

    .line 372
    :cond_f
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isResolvedVertically()Z

    .line 373
    .line 374
    .line 375
    move-result v5

    .line 376
    if-eqz v5, :cond_10

    .line 377
    .line 378
    iget v5, v15, Landroidx/constraintlayout/core/widgets/Guideline;->mRelativePercent:F

    .line 379
    .line 380
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 381
    .line 382
    .line 383
    move-result v6

    .line 384
    int-to-float v6, v6

    .line 385
    mul-float v5, v5, v6

    .line 386
    .line 387
    add-float v5, v5, v20

    .line 388
    .line 389
    float-to-int v5, v5

    .line 390
    invoke-virtual {v15, v5}, Landroidx/constraintlayout/core/widgets/Guideline;->setFinalValue(I)V

    .line 391
    .line 392
    .line 393
    :cond_10
    :goto_c
    const/4 v6, 0x1

    .line 394
    goto :goto_d

    .line 395
    :cond_11
    instance-of v5, v15, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 396
    .line 397
    if-eqz v5, :cond_12

    .line 398
    .line 399
    check-cast v15, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 400
    .line 401
    invoke-virtual {v15}, Landroidx/constraintlayout/core/widgets/Barrier;->getOrientation()I

    .line 402
    .line 403
    .line 404
    move-result v5

    .line 405
    const/4 v15, 0x1

    .line 406
    if-ne v5, v15, :cond_12

    .line 407
    .line 408
    const/4 v14, 0x1

    .line 409
    :cond_12
    :goto_d
    add-int/lit8 v5, v19, 0x1

    .line 410
    .line 411
    goto :goto_b

    .line 412
    :cond_13
    if-eqz v6, :cond_15

    .line 413
    .line 414
    const/4 v5, 0x0

    .line 415
    :goto_e
    if-ge v5, v13, :cond_15

    .line 416
    .line 417
    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 418
    .line 419
    .line 420
    move-result-object v6

    .line 421
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 422
    .line 423
    instance-of v15, v6, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 424
    .line 425
    if-eqz v15, :cond_14

    .line 426
    .line 427
    check-cast v6, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 428
    .line 429
    iget v15, v6, Landroidx/constraintlayout/core/widgets/Guideline;->mOrientation:I

    .line 430
    .line 431
    if-nez v15, :cond_14

    .line 432
    .line 433
    const/4 v15, 0x1

    .line 434
    invoke-static {v15, v6, v9}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->verticalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;)V

    .line 435
    .line 436
    .line 437
    :cond_14
    add-int/lit8 v5, v5, 0x1

    .line 438
    .line 439
    goto :goto_e

    .line 440
    :cond_15
    const/4 v6, 0x0

    .line 441
    invoke-static {v6, v1, v9}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->verticalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;)V

    .line 442
    .line 443
    .line 444
    if-eqz v14, :cond_17

    .line 445
    .line 446
    const/4 v5, 0x0

    .line 447
    :goto_f
    if-ge v5, v13, :cond_17

    .line 448
    .line 449
    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 450
    .line 451
    .line 452
    move-result-object v6

    .line 453
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 454
    .line 455
    instance-of v14, v6, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 456
    .line 457
    if-eqz v14, :cond_16

    .line 458
    .line 459
    check-cast v6, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 460
    .line 461
    invoke-virtual {v6}, Landroidx/constraintlayout/core/widgets/Barrier;->getOrientation()I

    .line 462
    .line 463
    .line 464
    move-result v14

    .line 465
    const/4 v15, 0x1

    .line 466
    if-ne v14, v15, :cond_16

    .line 467
    .line 468
    invoke-virtual {v6}, Landroidx/constraintlayout/core/widgets/Barrier;->allSolved()Z

    .line 469
    .line 470
    .line 471
    move-result v14

    .line 472
    if-eqz v14, :cond_16

    .line 473
    .line 474
    invoke-static {v15, v6, v9}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->verticalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;)V

    .line 475
    .line 476
    .line 477
    :cond_16
    add-int/lit8 v5, v5, 0x1

    .line 478
    .line 479
    goto :goto_f

    .line 480
    :cond_17
    const/4 v5, 0x0

    .line 481
    :goto_10
    if-ge v5, v13, :cond_1b

    .line 482
    .line 483
    invoke-virtual {v10, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 484
    .line 485
    .line 486
    move-result-object v6

    .line 487
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 488
    .line 489
    invoke-virtual {v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isMeasureRequested()Z

    .line 490
    .line 491
    .line 492
    move-result v14

    .line 493
    if-eqz v14, :cond_1a

    .line 494
    .line 495
    invoke-static {v6}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->canMeasure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)Z

    .line 496
    .line 497
    .line 498
    move-result v14

    .line 499
    if-eqz v14, :cond_1a

    .line 500
    .line 501
    sget-object v14, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->sMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    .line 502
    .line 503
    invoke-static {v6, v9, v14}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V

    .line 504
    .line 505
    .line 506
    instance-of v14, v6, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 507
    .line 508
    if-eqz v14, :cond_19

    .line 509
    .line 510
    move-object v14, v6

    .line 511
    check-cast v14, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 512
    .line 513
    iget v14, v14, Landroidx/constraintlayout/core/widgets/Guideline;->mOrientation:I

    .line 514
    .line 515
    if-nez v14, :cond_18

    .line 516
    .line 517
    const/4 v14, 0x0

    .line 518
    invoke-static {v14, v6, v9}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->verticalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;)V

    .line 519
    .line 520
    .line 521
    goto :goto_11

    .line 522
    :cond_18
    const/4 v14, 0x0

    .line 523
    invoke-static {v14, v6, v9, v2}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->horizontalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Z)V

    .line 524
    .line 525
    .line 526
    goto :goto_11

    .line 527
    :cond_19
    const/4 v14, 0x0

    .line 528
    invoke-static {v14, v6, v9, v2}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->horizontalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Z)V

    .line 529
    .line 530
    .line 531
    invoke-static {v14, v6, v9}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->verticalSolvingPass(ILandroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;)V

    .line 532
    .line 533
    .line 534
    :cond_1a
    :goto_11
    add-int/lit8 v5, v5, 0x1

    .line 535
    .line 536
    goto :goto_10

    .line 537
    :cond_1b
    const/4 v2, 0x0

    .line 538
    :goto_12
    if-ge v2, v3, :cond_1f

    .line 539
    .line 540
    iget-object v5, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 541
    .line 542
    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 543
    .line 544
    .line 545
    move-result-object v5

    .line 546
    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 547
    .line 548
    invoke-virtual {v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->isMeasureRequested()Z

    .line 549
    .line 550
    .line 551
    move-result v6

    .line 552
    if-eqz v6, :cond_1d

    .line 553
    .line 554
    instance-of v6, v5, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 555
    .line 556
    if-nez v6, :cond_1d

    .line 557
    .line 558
    instance-of v6, v5, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 559
    .line 560
    if-nez v6, :cond_1d

    .line 561
    .line 562
    instance-of v6, v5, Landroidx/constraintlayout/core/widgets/Flow;

    .line 563
    .line 564
    if-nez v6, :cond_1d

    .line 565
    .line 566
    iget-boolean v6, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mInVirtualLayout:Z

    .line 567
    .line 568
    if-nez v6, :cond_1d

    .line 569
    .line 570
    const/4 v6, 0x0

    .line 571
    invoke-virtual {v5, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionBehaviour(I)I

    .line 572
    .line 573
    .line 574
    move-result v9

    .line 575
    const/4 v15, 0x1

    .line 576
    invoke-virtual {v5, v15}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getDimensionBehaviour(I)I

    .line 577
    .line 578
    .line 579
    move-result v6

    .line 580
    const/4 v10, 0x3

    .line 581
    if-ne v9, v10, :cond_1c

    .line 582
    .line 583
    iget v9, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultWidth:I

    .line 584
    .line 585
    if-eq v9, v15, :cond_1c

    .line 586
    .line 587
    if-ne v6, v10, :cond_1c

    .line 588
    .line 589
    iget v6, v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMatchConstraintDefaultHeight:I

    .line 590
    .line 591
    if-eq v6, v15, :cond_1c

    .line 592
    .line 593
    goto :goto_13

    .line 594
    :cond_1c
    new-instance v6, Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    .line 595
    .line 596
    invoke-direct {v6}, Ljava/lang/Object;-><init>()V

    .line 597
    .line 598
    .line 599
    iget-object v9, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMeasurer:Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;

    .line 600
    .line 601
    invoke-static {v5, v9, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V

    .line 602
    .line 603
    .line 604
    :cond_1d
    :goto_13
    add-int/lit8 v2, v2, 0x1

    .line 605
    .line 606
    goto :goto_12

    .line 607
    :cond_1e
    move-object/from16 v22, v5

    .line 608
    .line 609
    :cond_1f
    const/4 v5, 0x2

    .line 610
    iget-object v9, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mSystem:Landroidx/constraintlayout/core/LinearSystem;

    .line 611
    .line 612
    if-le v3, v5, :cond_20

    .line 613
    .line 614
    if-eq v8, v5, :cond_21

    .line 615
    .line 616
    if-ne v7, v5, :cond_20

    .line 617
    .line 618
    goto :goto_14

    .line 619
    :cond_20
    move/from16 v24, v3

    .line 620
    .line 621
    move v5, v4

    .line 622
    move v4, v7

    .line 623
    move v2, v8

    .line 624
    move-object/from16 v23, v11

    .line 625
    .line 626
    move-object/from16 v25, v12

    .line 627
    .line 628
    move v3, v0

    .line 629
    goto/16 :goto_36

    .line 630
    .line 631
    :cond_21
    :goto_14
    iget v10, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mOptimizationLevel:I

    .line 632
    .line 633
    const/16 v13, 0x400

    .line 634
    .line 635
    invoke-static {v10, v13}, Landroidx/constraintlayout/core/widgets/Chain;->enabled(II)Z

    .line 636
    .line 637
    .line 638
    move-result v10

    .line 639
    if-eqz v10, :cond_20

    .line 640
    .line 641
    iget-object v10, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMeasurer:Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;

    .line 642
    .line 643
    iget-object v13, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 644
    .line 645
    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    .line 646
    .line 647
    .line 648
    move-result v14

    .line 649
    const/4 v15, 0x0

    .line 650
    :goto_15
    if-ge v15, v14, :cond_24

    .line 651
    .line 652
    invoke-virtual {v13, v15}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 653
    .line 654
    .line 655
    move-result-object v19

    .line 656
    move-object/from16 v2, v19

    .line 657
    .line 658
    check-cast v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 659
    .line 660
    const/16 v17, 0x0

    .line 661
    .line 662
    aget v5, v22, v17

    .line 663
    .line 664
    const/16 v18, 0x1

    .line 665
    .line 666
    aget v6, v22, v18

    .line 667
    .line 668
    move/from16 v23, v15

    .line 669
    .line 670
    iget-object v15, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 671
    .line 672
    move-object/from16 v24, v15

    .line 673
    .line 674
    aget v15, v24, v17

    .line 675
    .line 676
    move-object/from16 v25, v12

    .line 677
    .line 678
    aget v12, v24, v18

    .line 679
    .line 680
    invoke-static {v5, v6, v15, v12}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->validInGroup(IIII)Z

    .line 681
    .line 682
    .line 683
    move-result v5

    .line 684
    if-nez v5, :cond_22

    .line 685
    .line 686
    :goto_16
    move/from16 v29, v0

    .line 687
    .line 688
    move/from16 v24, v3

    .line 689
    .line 690
    move/from16 v26, v4

    .line 691
    .line 692
    move/from16 v28, v7

    .line 693
    .line 694
    move/from16 v31, v8

    .line 695
    .line 696
    move-object/from16 v23, v11

    .line 697
    .line 698
    goto/16 :goto_2f

    .line 699
    .line 700
    :cond_22
    instance-of v2, v2, Landroidx/constraintlayout/core/widgets/Flow;

    .line 701
    .line 702
    if-eqz v2, :cond_23

    .line 703
    .line 704
    goto :goto_16

    .line 705
    :cond_23
    add-int/lit8 v15, v23, 0x1

    .line 706
    .line 707
    move-object/from16 v12, v25

    .line 708
    .line 709
    const/4 v5, 0x2

    .line 710
    goto :goto_15

    .line 711
    :cond_24
    move-object/from16 v25, v12

    .line 712
    .line 713
    move/from16 v24, v3

    .line 714
    .line 715
    move-object/from16 v23, v11

    .line 716
    .line 717
    const/4 v2, 0x0

    .line 718
    const/4 v3, 0x0

    .line 719
    const/4 v5, 0x0

    .line 720
    const/4 v6, 0x0

    .line 721
    const/4 v11, 0x0

    .line 722
    const/4 v12, 0x0

    .line 723
    const/4 v15, 0x0

    .line 724
    :goto_17
    if-ge v2, v14, :cond_35

    .line 725
    .line 726
    invoke-virtual {v13, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 727
    .line 728
    .line 729
    move-result-object v26

    .line 730
    move/from16 v27, v2

    .line 731
    .line 732
    move-object/from16 v2, v26

    .line 733
    .line 734
    check-cast v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 735
    .line 736
    move/from16 v26, v4

    .line 737
    .line 738
    const/16 v17, 0x0

    .line 739
    .line 740
    aget v4, v22, v17

    .line 741
    .line 742
    move/from16 v28, v7

    .line 743
    .line 744
    const/16 v18, 0x1

    .line 745
    .line 746
    aget v7, v22, v18

    .line 747
    .line 748
    move/from16 v29, v0

    .line 749
    .line 750
    iget-object v0, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 751
    .line 752
    move-object/from16 v30, v0

    .line 753
    .line 754
    aget v0, v30, v17

    .line 755
    .line 756
    move/from16 v31, v8

    .line 757
    .line 758
    aget v8, v30, v18

    .line 759
    .line 760
    invoke-static {v4, v7, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->validInGroup(IIII)Z

    .line 761
    .line 762
    .line 763
    move-result v0

    .line 764
    if-nez v0, :cond_25

    .line 765
    .line 766
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mMeasure:Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;

    .line 767
    .line 768
    invoke-static {v2, v10, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->measure(Landroidx/constraintlayout/core/widgets/ConstraintWidget;Landroidx/constraintlayout/widget/ConstraintLayout$Measurer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V

    .line 769
    .line 770
    .line 771
    :cond_25
    instance-of v0, v2, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 772
    .line 773
    if-eqz v0, :cond_29

    .line 774
    .line 775
    move-object v4, v2

    .line 776
    check-cast v4, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 777
    .line 778
    iget v7, v4, Landroidx/constraintlayout/core/widgets/Guideline;->mOrientation:I

    .line 779
    .line 780
    if-nez v7, :cond_27

    .line 781
    .line 782
    if-nez v12, :cond_26

    .line 783
    .line 784
    new-instance v12, Ljava/util/ArrayList;

    .line 785
    .line 786
    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    .line 787
    .line 788
    .line 789
    :cond_26
    invoke-virtual {v12, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 790
    .line 791
    .line 792
    :cond_27
    iget v7, v4, Landroidx/constraintlayout/core/widgets/Guideline;->mOrientation:I

    .line 793
    .line 794
    const/4 v8, 0x1

    .line 795
    if-ne v7, v8, :cond_29

    .line 796
    .line 797
    if-nez v5, :cond_28

    .line 798
    .line 799
    new-instance v5, Ljava/util/ArrayList;

    .line 800
    .line 801
    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 802
    .line 803
    .line 804
    :cond_28
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 805
    .line 806
    .line 807
    :cond_29
    instance-of v4, v2, Landroidx/constraintlayout/core/widgets/HelperWidget;

    .line 808
    .line 809
    if-eqz v4, :cond_30

    .line 810
    .line 811
    instance-of v4, v2, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 812
    .line 813
    if-eqz v4, :cond_2d

    .line 814
    .line 815
    move-object v4, v2

    .line 816
    check-cast v4, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 817
    .line 818
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/Barrier;->getOrientation()I

    .line 819
    .line 820
    .line 821
    move-result v7

    .line 822
    if-nez v7, :cond_2b

    .line 823
    .line 824
    if-nez v6, :cond_2a

    .line 825
    .line 826
    new-instance v6, Ljava/util/ArrayList;

    .line 827
    .line 828
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 829
    .line 830
    .line 831
    :cond_2a
    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 832
    .line 833
    .line 834
    :cond_2b
    invoke-virtual {v4}, Landroidx/constraintlayout/core/widgets/Barrier;->getOrientation()I

    .line 835
    .line 836
    .line 837
    move-result v7

    .line 838
    const/4 v8, 0x1

    .line 839
    if-ne v7, v8, :cond_30

    .line 840
    .line 841
    if-nez v15, :cond_2c

    .line 842
    .line 843
    new-instance v15, Ljava/util/ArrayList;

    .line 844
    .line 845
    invoke-direct {v15}, Ljava/util/ArrayList;-><init>()V

    .line 846
    .line 847
    .line 848
    :cond_2c
    invoke-virtual {v15, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 849
    .line 850
    .line 851
    goto :goto_18

    .line 852
    :cond_2d
    move-object v4, v2

    .line 853
    check-cast v4, Landroidx/constraintlayout/core/widgets/HelperWidget;

    .line 854
    .line 855
    if-nez v6, :cond_2e

    .line 856
    .line 857
    new-instance v6, Ljava/util/ArrayList;

    .line 858
    .line 859
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 860
    .line 861
    .line 862
    :cond_2e
    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 863
    .line 864
    .line 865
    if-nez v15, :cond_2f

    .line 866
    .line 867
    new-instance v15, Ljava/util/ArrayList;

    .line 868
    .line 869
    invoke-direct {v15}, Ljava/util/ArrayList;-><init>()V

    .line 870
    .line 871
    .line 872
    :cond_2f
    invoke-virtual {v15, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 873
    .line 874
    .line 875
    :cond_30
    :goto_18
    iget-object v4, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mLeft:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 876
    .line 877
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 878
    .line 879
    if-nez v4, :cond_32

    .line 880
    .line 881
    iget-object v4, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 882
    .line 883
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 884
    .line 885
    if-nez v4, :cond_32

    .line 886
    .line 887
    if-nez v0, :cond_32

    .line 888
    .line 889
    instance-of v4, v2, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 890
    .line 891
    if-nez v4, :cond_32

    .line 892
    .line 893
    if-nez v11, :cond_31

    .line 894
    .line 895
    new-instance v11, Ljava/util/ArrayList;

    .line 896
    .line 897
    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    .line 898
    .line 899
    .line 900
    :cond_31
    invoke-virtual {v11, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 901
    .line 902
    .line 903
    :cond_32
    iget-object v4, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mTop:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 904
    .line 905
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 906
    .line 907
    if-nez v4, :cond_34

    .line 908
    .line 909
    iget-object v4, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 910
    .line 911
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 912
    .line 913
    if-nez v4, :cond_34

    .line 914
    .line 915
    iget-object v4, v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBaseline:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 916
    .line 917
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mTarget:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 918
    .line 919
    if-nez v4, :cond_34

    .line 920
    .line 921
    if-nez v0, :cond_34

    .line 922
    .line 923
    instance-of v0, v2, Landroidx/constraintlayout/core/widgets/Barrier;

    .line 924
    .line 925
    if-nez v0, :cond_34

    .line 926
    .line 927
    if-nez v3, :cond_33

    .line 928
    .line 929
    new-instance v3, Ljava/util/ArrayList;

    .line 930
    .line 931
    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 932
    .line 933
    .line 934
    :cond_33
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 935
    .line 936
    .line 937
    :cond_34
    add-int/lit8 v2, v27, 0x1

    .line 938
    .line 939
    move/from16 v4, v26

    .line 940
    .line 941
    move/from16 v7, v28

    .line 942
    .line 943
    move/from16 v0, v29

    .line 944
    .line 945
    move/from16 v8, v31

    .line 946
    .line 947
    goto/16 :goto_17

    .line 948
    .line 949
    :cond_35
    move/from16 v29, v0

    .line 950
    .line 951
    move/from16 v26, v4

    .line 952
    .line 953
    move/from16 v28, v7

    .line 954
    .line 955
    move/from16 v31, v8

    .line 956
    .line 957
    new-instance v0, Ljava/util/ArrayList;

    .line 958
    .line 959
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 960
    .line 961
    .line 962
    if-eqz v5, :cond_36

    .line 963
    .line 964
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    .line 965
    .line 966
    .line 967
    move-result v2

    .line 968
    const/4 v4, 0x0

    .line 969
    :goto_19
    if-ge v4, v2, :cond_36

    .line 970
    .line 971
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 972
    .line 973
    .line 974
    move-result-object v7

    .line 975
    add-int/lit8 v4, v4, 0x1

    .line 976
    .line 977
    check-cast v7, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 978
    .line 979
    const/4 v8, 0x0

    .line 980
    const/4 v10, 0x0

    .line 981
    invoke-static {v7, v10, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 982
    .line 983
    .line 984
    goto :goto_19

    .line 985
    :cond_36
    if-eqz v6, :cond_37

    .line 986
    .line 987
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    .line 988
    .line 989
    .line 990
    move-result v2

    .line 991
    const/4 v4, 0x0

    .line 992
    :goto_1a
    if-ge v4, v2, :cond_37

    .line 993
    .line 994
    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 995
    .line 996
    .line 997
    move-result-object v5

    .line 998
    add-int/lit8 v4, v4, 0x1

    .line 999
    .line 1000
    check-cast v5, Landroidx/constraintlayout/core/widgets/HelperWidget;

    .line 1001
    .line 1002
    const/4 v8, 0x0

    .line 1003
    const/4 v10, 0x0

    .line 1004
    invoke-static {v5, v10, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1005
    .line 1006
    .line 1007
    move-result-object v7

    .line 1008
    invoke-virtual {v5, v10, v7, v0}, Landroidx/constraintlayout/core/widgets/HelperWidget;->addDependents(ILandroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;Ljava/util/ArrayList;)V

    .line 1009
    .line 1010
    .line 1011
    invoke-virtual {v7, v0}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->cleanup(Ljava/util/ArrayList;)V

    .line 1012
    .line 1013
    .line 1014
    goto :goto_1a

    .line 1015
    :cond_37
    const/4 v2, 0x2

    .line 1016
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1017
    .line 1018
    .line 1019
    move-result-object v4

    .line 1020
    iget-object v2, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 1021
    .line 1022
    if-eqz v2, :cond_38

    .line 1023
    .line 1024
    invoke-virtual {v2}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 1025
    .line 1026
    .line 1027
    move-result-object v2

    .line 1028
    :goto_1b
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 1029
    .line 1030
    .line 1031
    move-result v4

    .line 1032
    if-eqz v4, :cond_38

    .line 1033
    .line 1034
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1035
    .line 1036
    .line 1037
    move-result-object v4

    .line 1038
    check-cast v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1039
    .line 1040
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1041
    .line 1042
    const/4 v6, 0x0

    .line 1043
    const/4 v8, 0x0

    .line 1044
    invoke-static {v4, v6, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1045
    .line 1046
    .line 1047
    goto :goto_1b

    .line 1048
    :cond_38
    const/4 v2, 0x4

    .line 1049
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1050
    .line 1051
    .line 1052
    move-result-object v2

    .line 1053
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 1054
    .line 1055
    if-eqz v2, :cond_39

    .line 1056
    .line 1057
    invoke-virtual {v2}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 1058
    .line 1059
    .line 1060
    move-result-object v2

    .line 1061
    :goto_1c
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 1062
    .line 1063
    .line 1064
    move-result v4

    .line 1065
    if-eqz v4, :cond_39

    .line 1066
    .line 1067
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1068
    .line 1069
    .line 1070
    move-result-object v4

    .line 1071
    check-cast v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1072
    .line 1073
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1074
    .line 1075
    const/4 v6, 0x0

    .line 1076
    const/4 v8, 0x0

    .line 1077
    invoke-static {v4, v6, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1078
    .line 1079
    .line 1080
    goto :goto_1c

    .line 1081
    :cond_39
    const/4 v2, 0x7

    .line 1082
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1083
    .line 1084
    .line 1085
    move-result-object v4

    .line 1086
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 1087
    .line 1088
    if-eqz v4, :cond_3a

    .line 1089
    .line 1090
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 1091
    .line 1092
    .line 1093
    move-result-object v4

    .line 1094
    :goto_1d
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    .line 1095
    .line 1096
    .line 1097
    move-result v5

    .line 1098
    if-eqz v5, :cond_3a

    .line 1099
    .line 1100
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1101
    .line 1102
    .line 1103
    move-result-object v5

    .line 1104
    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1105
    .line 1106
    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1107
    .line 1108
    const/4 v6, 0x0

    .line 1109
    const/4 v8, 0x0

    .line 1110
    invoke-static {v5, v6, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1111
    .line 1112
    .line 1113
    goto :goto_1d

    .line 1114
    :cond_3a
    if-eqz v11, :cond_3b

    .line 1115
    .line 1116
    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    .line 1117
    .line 1118
    .line 1119
    move-result v4

    .line 1120
    const/4 v5, 0x0

    .line 1121
    :goto_1e
    if-ge v5, v4, :cond_3b

    .line 1122
    .line 1123
    invoke-virtual {v11, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1124
    .line 1125
    .line 1126
    move-result-object v6

    .line 1127
    add-int/lit8 v5, v5, 0x1

    .line 1128
    .line 1129
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1130
    .line 1131
    const/4 v8, 0x0

    .line 1132
    const/4 v10, 0x0

    .line 1133
    invoke-static {v6, v10, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1134
    .line 1135
    .line 1136
    goto :goto_1e

    .line 1137
    :cond_3b
    if-eqz v12, :cond_3c

    .line 1138
    .line 1139
    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    .line 1140
    .line 1141
    .line 1142
    move-result v4

    .line 1143
    const/4 v5, 0x0

    .line 1144
    :goto_1f
    if-ge v5, v4, :cond_3c

    .line 1145
    .line 1146
    invoke-virtual {v12, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1147
    .line 1148
    .line 1149
    move-result-object v6

    .line 1150
    add-int/lit8 v5, v5, 0x1

    .line 1151
    .line 1152
    check-cast v6, Landroidx/constraintlayout/core/widgets/Guideline;

    .line 1153
    .line 1154
    const/4 v7, 0x1

    .line 1155
    const/4 v8, 0x0

    .line 1156
    invoke-static {v6, v7, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1157
    .line 1158
    .line 1159
    goto :goto_1f

    .line 1160
    :cond_3c
    if-eqz v15, :cond_3d

    .line 1161
    .line 1162
    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    .line 1163
    .line 1164
    .line 1165
    move-result v4

    .line 1166
    const/4 v5, 0x0

    .line 1167
    :goto_20
    if-ge v5, v4, :cond_3d

    .line 1168
    .line 1169
    invoke-virtual {v15, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1170
    .line 1171
    .line 1172
    move-result-object v6

    .line 1173
    add-int/lit8 v5, v5, 0x1

    .line 1174
    .line 1175
    check-cast v6, Landroidx/constraintlayout/core/widgets/HelperWidget;

    .line 1176
    .line 1177
    const/4 v7, 0x1

    .line 1178
    const/4 v8, 0x0

    .line 1179
    invoke-static {v6, v7, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1180
    .line 1181
    .line 1182
    move-result-object v10

    .line 1183
    invoke-virtual {v6, v7, v10, v0}, Landroidx/constraintlayout/core/widgets/HelperWidget;->addDependents(ILandroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;Ljava/util/ArrayList;)V

    .line 1184
    .line 1185
    .line 1186
    invoke-virtual {v10, v0}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->cleanup(Ljava/util/ArrayList;)V

    .line 1187
    .line 1188
    .line 1189
    goto :goto_20

    .line 1190
    :cond_3d
    const/4 v10, 0x3

    .line 1191
    invoke-virtual {v1, v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1192
    .line 1193
    .line 1194
    move-result-object v4

    .line 1195
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 1196
    .line 1197
    if-eqz v4, :cond_3e

    .line 1198
    .line 1199
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 1200
    .line 1201
    .line 1202
    move-result-object v4

    .line 1203
    :goto_21
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    .line 1204
    .line 1205
    .line 1206
    move-result v5

    .line 1207
    if-eqz v5, :cond_3e

    .line 1208
    .line 1209
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1210
    .line 1211
    .line 1212
    move-result-object v5

    .line 1213
    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1214
    .line 1215
    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1216
    .line 1217
    const/4 v8, 0x0

    .line 1218
    const/4 v15, 0x1

    .line 1219
    invoke-static {v5, v15, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1220
    .line 1221
    .line 1222
    goto :goto_21

    .line 1223
    :cond_3e
    const/4 v4, 0x6

    .line 1224
    invoke-virtual {v1, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1225
    .line 1226
    .line 1227
    move-result-object v4

    .line 1228
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 1229
    .line 1230
    if-eqz v4, :cond_3f

    .line 1231
    .line 1232
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 1233
    .line 1234
    .line 1235
    move-result-object v4

    .line 1236
    :goto_22
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    .line 1237
    .line 1238
    .line 1239
    move-result v5

    .line 1240
    if-eqz v5, :cond_3f

    .line 1241
    .line 1242
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1243
    .line 1244
    .line 1245
    move-result-object v5

    .line 1246
    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1247
    .line 1248
    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1249
    .line 1250
    const/4 v8, 0x0

    .line 1251
    const/4 v15, 0x1

    .line 1252
    invoke-static {v5, v15, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1253
    .line 1254
    .line 1255
    goto :goto_22

    .line 1256
    :cond_3f
    const/4 v4, 0x5

    .line 1257
    invoke-virtual {v1, v4}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1258
    .line 1259
    .line 1260
    move-result-object v5

    .line 1261
    iget-object v4, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 1262
    .line 1263
    if-eqz v4, :cond_40

    .line 1264
    .line 1265
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 1266
    .line 1267
    .line 1268
    move-result-object v4

    .line 1269
    :goto_23
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    .line 1270
    .line 1271
    .line 1272
    move-result v5

    .line 1273
    if-eqz v5, :cond_40

    .line 1274
    .line 1275
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1276
    .line 1277
    .line 1278
    move-result-object v5

    .line 1279
    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1280
    .line 1281
    iget-object v5, v5, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1282
    .line 1283
    const/4 v8, 0x0

    .line 1284
    const/4 v15, 0x1

    .line 1285
    invoke-static {v5, v15, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1286
    .line 1287
    .line 1288
    goto :goto_23

    .line 1289
    :cond_40
    invoke-virtual {v1, v2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getAnchor(I)Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1290
    .line 1291
    .line 1292
    move-result-object v2

    .line 1293
    iget-object v2, v2, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mDependents:Ljava/util/HashSet;

    .line 1294
    .line 1295
    if-eqz v2, :cond_41

    .line 1296
    .line 1297
    invoke-virtual {v2}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 1298
    .line 1299
    .line 1300
    move-result-object v2

    .line 1301
    :goto_24
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 1302
    .line 1303
    .line 1304
    move-result v4

    .line 1305
    if-eqz v4, :cond_41

    .line 1306
    .line 1307
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1308
    .line 1309
    .line 1310
    move-result-object v4

    .line 1311
    check-cast v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1312
    .line 1313
    iget-object v4, v4, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;->mOwner:Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1314
    .line 1315
    const/4 v8, 0x0

    .line 1316
    const/4 v15, 0x1

    .line 1317
    invoke-static {v4, v15, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1318
    .line 1319
    .line 1320
    goto :goto_24

    .line 1321
    :cond_41
    if-eqz v3, :cond_42

    .line 1322
    .line 1323
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 1324
    .line 1325
    .line 1326
    move-result v2

    .line 1327
    const/4 v4, 0x0

    .line 1328
    :goto_25
    if-ge v4, v2, :cond_42

    .line 1329
    .line 1330
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1331
    .line 1332
    .line 1333
    move-result-object v5

    .line 1334
    add-int/lit8 v4, v4, 0x1

    .line 1335
    .line 1336
    check-cast v5, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1337
    .line 1338
    const/4 v8, 0x0

    .line 1339
    const/4 v15, 0x1

    .line 1340
    invoke-static {v5, v15, v0, v8}, Landroidx/constraintlayout/core/widgets/analyzer/Direct;->findDependents(Landroidx/constraintlayout/core/widgets/ConstraintWidget;ILjava/util/ArrayList;Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1341
    .line 1342
    .line 1343
    goto :goto_25

    .line 1344
    :cond_42
    const/4 v15, 0x1

    .line 1345
    const/4 v2, 0x0

    .line 1346
    :goto_26
    if-ge v2, v14, :cond_48

    .line 1347
    .line 1348
    invoke-virtual {v13, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1349
    .line 1350
    .line 1351
    move-result-object v3

    .line 1352
    check-cast v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1353
    .line 1354
    iget-object v4, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mListDimensionBehaviors:[I

    .line 1355
    .line 1356
    const/16 v17, 0x0

    .line 1357
    .line 1358
    aget v5, v4, v17

    .line 1359
    .line 1360
    const/4 v10, 0x3

    .line 1361
    if-ne v5, v10, :cond_47

    .line 1362
    .line 1363
    aget v4, v4, v15

    .line 1364
    .line 1365
    if-ne v4, v10, :cond_47

    .line 1366
    .line 1367
    iget v4, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->horizontalGroup:I

    .line 1368
    .line 1369
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 1370
    .line 1371
    .line 1372
    move-result v5

    .line 1373
    const/4 v6, 0x0

    .line 1374
    :goto_27
    if-ge v6, v5, :cond_44

    .line 1375
    .line 1376
    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1377
    .line 1378
    .line 1379
    move-result-object v7

    .line 1380
    check-cast v7, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1381
    .line 1382
    iget v8, v7, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->mId:I

    .line 1383
    .line 1384
    if-ne v4, v8, :cond_43

    .line 1385
    .line 1386
    goto :goto_28

    .line 1387
    :cond_43
    add-int/lit8 v6, v6, 0x1

    .line 1388
    .line 1389
    goto :goto_27

    .line 1390
    :cond_44
    const/4 v7, 0x0

    .line 1391
    :goto_28
    iget v3, v3, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->verticalGroup:I

    .line 1392
    .line 1393
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 1394
    .line 1395
    .line 1396
    move-result v4

    .line 1397
    const/4 v5, 0x0

    .line 1398
    :goto_29
    if-ge v5, v4, :cond_46

    .line 1399
    .line 1400
    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1401
    .line 1402
    .line 1403
    move-result-object v6

    .line 1404
    check-cast v6, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1405
    .line 1406
    iget v8, v6, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->mId:I

    .line 1407
    .line 1408
    if-ne v3, v8, :cond_45

    .line 1409
    .line 1410
    goto :goto_2a

    .line 1411
    :cond_45
    add-int/lit8 v5, v5, 0x1

    .line 1412
    .line 1413
    goto :goto_29

    .line 1414
    :cond_46
    const/4 v6, 0x0

    .line 1415
    :goto_2a
    if-eqz v7, :cond_47

    .line 1416
    .line 1417
    if-eqz v6, :cond_47

    .line 1418
    .line 1419
    const/4 v5, 0x0

    .line 1420
    invoke-virtual {v7, v5, v6}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->moveTo(ILandroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;)V

    .line 1421
    .line 1422
    .line 1423
    const/4 v3, 0x2

    .line 1424
    iput v3, v6, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->mOrientation:I

    .line 1425
    .line 1426
    invoke-virtual {v0, v7}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 1427
    .line 1428
    .line 1429
    :cond_47
    add-int/lit8 v2, v2, 0x1

    .line 1430
    .line 1431
    const/4 v15, 0x1

    .line 1432
    goto :goto_26

    .line 1433
    :cond_48
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 1434
    .line 1435
    .line 1436
    move-result v2

    .line 1437
    const/4 v15, 0x1

    .line 1438
    if-gt v2, v15, :cond_49

    .line 1439
    .line 1440
    goto/16 :goto_2f

    .line 1441
    .line 1442
    :cond_49
    const/16 v17, 0x0

    .line 1443
    .line 1444
    aget v2, v22, v17

    .line 1445
    .line 1446
    const/4 v3, 0x2

    .line 1447
    if-ne v2, v3, :cond_4d

    .line 1448
    .line 1449
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 1450
    .line 1451
    .line 1452
    move-result v2

    .line 1453
    const/4 v3, 0x0

    .line 1454
    const/4 v4, 0x0

    .line 1455
    const/4 v5, 0x0

    .line 1456
    :cond_4a
    :goto_2b
    if-ge v4, v2, :cond_4c

    .line 1457
    .line 1458
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1459
    .line 1460
    .line 1461
    move-result-object v6

    .line 1462
    add-int/lit8 v4, v4, 0x1

    .line 1463
    .line 1464
    check-cast v6, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1465
    .line 1466
    iget v7, v6, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->mOrientation:I

    .line 1467
    .line 1468
    const/4 v15, 0x1

    .line 1469
    if-ne v7, v15, :cond_4b

    .line 1470
    .line 1471
    goto :goto_2b

    .line 1472
    :cond_4b
    const/4 v10, 0x0

    .line 1473
    invoke-virtual {v6, v9, v10}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->measureWrap(Landroidx/constraintlayout/core/LinearSystem;I)I

    .line 1474
    .line 1475
    .line 1476
    move-result v7

    .line 1477
    if-le v7, v3, :cond_4a

    .line 1478
    .line 1479
    move-object v5, v6

    .line 1480
    move v3, v7

    .line 1481
    goto :goto_2b

    .line 1482
    :cond_4c
    const/4 v15, 0x1

    .line 1483
    if-eqz v5, :cond_4e

    .line 1484
    .line 1485
    invoke-virtual {v1, v15}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHorizontalDimensionBehaviour(I)V

    .line 1486
    .line 1487
    .line 1488
    invoke-virtual {v1, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    .line 1489
    .line 1490
    .line 1491
    goto :goto_2c

    .line 1492
    :cond_4d
    const/4 v15, 0x1

    .line 1493
    :cond_4e
    const/4 v5, 0x0

    .line 1494
    :goto_2c
    aget v2, v22, v15

    .line 1495
    .line 1496
    const/4 v3, 0x2

    .line 1497
    if-ne v2, v3, :cond_52

    .line 1498
    .line 1499
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 1500
    .line 1501
    .line 1502
    move-result v2

    .line 1503
    const/4 v3, 0x0

    .line 1504
    const/4 v4, 0x0

    .line 1505
    const/4 v6, 0x0

    .line 1506
    :cond_4f
    :goto_2d
    if-ge v4, v2, :cond_51

    .line 1507
    .line 1508
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1509
    .line 1510
    .line 1511
    move-result-object v7

    .line 1512
    add-int/lit8 v4, v4, 0x1

    .line 1513
    .line 1514
    check-cast v7, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;

    .line 1515
    .line 1516
    iget v8, v7, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->mOrientation:I

    .line 1517
    .line 1518
    if-nez v8, :cond_50

    .line 1519
    .line 1520
    goto :goto_2d

    .line 1521
    :cond_50
    const/4 v15, 0x1

    .line 1522
    invoke-virtual {v7, v9, v15}, Landroidx/constraintlayout/core/widgets/analyzer/WidgetGroup;->measureWrap(Landroidx/constraintlayout/core/LinearSystem;I)I

    .line 1523
    .line 1524
    .line 1525
    move-result v8

    .line 1526
    if-le v8, v3, :cond_4f

    .line 1527
    .line 1528
    move-object v6, v7

    .line 1529
    move v3, v8

    .line 1530
    goto :goto_2d

    .line 1531
    :cond_51
    const/4 v15, 0x1

    .line 1532
    if-eqz v6, :cond_52

    .line 1533
    .line 1534
    invoke-virtual {v1, v15}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setVerticalDimensionBehaviour(I)V

    .line 1535
    .line 1536
    .line 1537
    invoke-virtual {v1, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    .line 1538
    .line 1539
    .line 1540
    goto :goto_2e

    .line 1541
    :cond_52
    const/4 v6, 0x0

    .line 1542
    :goto_2e
    if-nez v5, :cond_53

    .line 1543
    .line 1544
    if-eqz v6, :cond_54

    .line 1545
    .line 1546
    :cond_53
    move/from16 v2, v31

    .line 1547
    .line 1548
    const/4 v3, 0x2

    .line 1549
    goto :goto_30

    .line 1550
    :cond_54
    :goto_2f
    move/from16 v5, v26

    .line 1551
    .line 1552
    move/from16 v4, v28

    .line 1553
    .line 1554
    move/from16 v3, v29

    .line 1555
    .line 1556
    move/from16 v2, v31

    .line 1557
    .line 1558
    goto :goto_36

    .line 1559
    :goto_30
    if-ne v2, v3, :cond_56

    .line 1560
    .line 1561
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 1562
    .line 1563
    .line 1564
    move-result v0

    .line 1565
    move/from16 v3, v29

    .line 1566
    .line 1567
    if-ge v3, v0, :cond_55

    .line 1568
    .line 1569
    if-lez v3, :cond_55

    .line 1570
    .line 1571
    invoke-virtual {v1, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    .line 1572
    .line 1573
    .line 1574
    const/4 v15, 0x1

    .line 1575
    iput-boolean v15, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mWidthMeasuredTooSmall:Z

    .line 1576
    .line 1577
    goto :goto_32

    .line 1578
    :cond_55
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 1579
    .line 1580
    .line 1581
    move-result v0

    .line 1582
    :goto_31
    move/from16 v4, v28

    .line 1583
    .line 1584
    const/4 v3, 0x2

    .line 1585
    goto :goto_33

    .line 1586
    :cond_56
    move/from16 v3, v29

    .line 1587
    .line 1588
    :goto_32
    move v0, v3

    .line 1589
    goto :goto_31

    .line 1590
    :goto_33
    if-ne v4, v3, :cond_58

    .line 1591
    .line 1592
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 1593
    .line 1594
    .line 1595
    move-result v3

    .line 1596
    move/from16 v5, v26

    .line 1597
    .line 1598
    if-ge v5, v3, :cond_57

    .line 1599
    .line 1600
    if-lez v5, :cond_57

    .line 1601
    .line 1602
    invoke-virtual {v1, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    .line 1603
    .line 1604
    .line 1605
    const/4 v15, 0x1

    .line 1606
    iput-boolean v15, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHeightMeasuredTooSmall:Z

    .line 1607
    .line 1608
    goto :goto_34

    .line 1609
    :cond_57
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 1610
    .line 1611
    .line 1612
    move-result v3

    .line 1613
    goto :goto_35

    .line 1614
    :cond_58
    move/from16 v5, v26

    .line 1615
    .line 1616
    :goto_34
    move v3, v5

    .line 1617
    :goto_35
    move v5, v3

    .line 1618
    move v3, v0

    .line 1619
    const/4 v0, 0x1

    .line 1620
    goto :goto_37

    .line 1621
    :goto_36
    const/4 v0, 0x0

    .line 1622
    :goto_37
    const/16 v6, 0x40

    .line 1623
    .line 1624
    invoke-virtual {v1, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    .line 1625
    .line 1626
    .line 1627
    move-result v7

    .line 1628
    if-nez v7, :cond_5a

    .line 1629
    .line 1630
    const/16 v7, 0x80

    .line 1631
    .line 1632
    invoke-virtual {v1, v7}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    .line 1633
    .line 1634
    .line 1635
    move-result v7

    .line 1636
    if-eqz v7, :cond_59

    .line 1637
    .line 1638
    goto :goto_38

    .line 1639
    :cond_59
    const/4 v7, 0x0

    .line 1640
    goto :goto_39

    .line 1641
    :cond_5a
    :goto_38
    const/4 v7, 0x1

    .line 1642
    :goto_39
    invoke-virtual {v9}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 1643
    .line 1644
    .line 1645
    const/4 v10, 0x0

    .line 1646
    iput-boolean v10, v9, Landroidx/constraintlayout/core/LinearSystem;->newgraphOptimizer:Z

    .line 1647
    .line 1648
    iget v8, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mOptimizationLevel:I

    .line 1649
    .line 1650
    if-eqz v8, :cond_5b

    .line 1651
    .line 1652
    if-eqz v7, :cond_5b

    .line 1653
    .line 1654
    const/4 v15, 0x1

    .line 1655
    iput-boolean v15, v9, Landroidx/constraintlayout/core/LinearSystem;->newgraphOptimizer:Z

    .line 1656
    .line 1657
    goto :goto_3a

    .line 1658
    :cond_5b
    const/4 v15, 0x1

    .line 1659
    :goto_3a
    iget-object v7, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 1660
    .line 1661
    aget v8, v22, v10

    .line 1662
    .line 1663
    const/4 v11, 0x2

    .line 1664
    if-eq v8, v11, :cond_5d

    .line 1665
    .line 1666
    aget v8, v22, v15

    .line 1667
    .line 1668
    if-ne v8, v11, :cond_5c

    .line 1669
    .line 1670
    goto :goto_3b

    .line 1671
    :cond_5c
    const/4 v8, 0x0

    .line 1672
    goto :goto_3c

    .line 1673
    :cond_5d
    :goto_3b
    const/4 v8, 0x1

    .line 1674
    :goto_3c
    iput v10, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsSize:I

    .line 1675
    .line 1676
    iput v10, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsSize:I

    .line 1677
    .line 1678
    move/from16 v11, v24

    .line 1679
    .line 1680
    const/4 v10, 0x0

    .line 1681
    :goto_3d
    if-ge v10, v11, :cond_5f

    .line 1682
    .line 1683
    iget-object v12, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 1684
    .line 1685
    invoke-virtual {v12, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1686
    .line 1687
    .line 1688
    move-result-object v12

    .line 1689
    check-cast v12, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1690
    .line 1691
    instance-of v13, v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 1692
    .line 1693
    if-eqz v13, :cond_5e

    .line 1694
    .line 1695
    check-cast v12, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;

    .line 1696
    .line 1697
    invoke-virtual {v12}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->layout()V

    .line 1698
    .line 1699
    .line 1700
    :cond_5e
    add-int/lit8 v10, v10, 0x1

    .line 1701
    .line 1702
    goto :goto_3d

    .line 1703
    :cond_5f
    invoke-virtual {v1, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    .line 1704
    .line 1705
    .line 1706
    move-result v10

    .line 1707
    move v12, v0

    .line 1708
    const/4 v0, 0x0

    .line 1709
    const/4 v13, 0x1

    .line 1710
    :goto_3e
    if-eqz v13, :cond_73

    .line 1711
    .line 1712
    const/16 v18, 0x1

    .line 1713
    .line 1714
    add-int/lit8 v14, v0, 0x1

    .line 1715
    .line 1716
    :try_start_0
    invoke-virtual {v9}, Landroidx/constraintlayout/core/LinearSystem;->reset()V

    .line 1717
    .line 1718
    .line 1719
    const/4 v15, 0x0

    .line 1720
    iput v15, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalChainsSize:I

    .line 1721
    .line 1722
    iput v15, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalChainsSize:I

    .line 1723
    .line 1724
    invoke-virtual {v1, v9}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->createObjectVariables(Landroidx/constraintlayout/core/LinearSystem;)V

    .line 1725
    .line 1726
    .line 1727
    const/4 v0, 0x0

    .line 1728
    :goto_3f
    if-ge v0, v11, :cond_60

    .line 1729
    .line 1730
    iget-object v15, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 1731
    .line 1732
    invoke-virtual {v15, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 1733
    .line 1734
    .line 1735
    move-result-object v15

    .line 1736
    check-cast v15, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 1737
    .line 1738
    invoke-virtual {v15, v9}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->createObjectVariables(Landroidx/constraintlayout/core/LinearSystem;)V

    .line 1739
    .line 1740
    .line 1741
    add-int/lit8 v0, v0, 0x1

    .line 1742
    .line 1743
    goto :goto_3f

    .line 1744
    :catch_0
    move-exception v0

    .line 1745
    move-object/from16 v15, v23

    .line 1746
    .line 1747
    const/4 v6, 0x0

    .line 1748
    move/from16 v23, v8

    .line 1749
    .line 1750
    const/4 v8, 0x5

    .line 1751
    goto/16 :goto_48

    .line 1752
    .line 1753
    :cond_60
    invoke-virtual {v1, v9}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->addChildrenToSolver(Landroidx/constraintlayout/core/LinearSystem;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1754
    .line 1755
    .line 1756
    :try_start_1
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMin:Ljava/lang/ref/WeakReference;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_9

    .line 1757
    .line 1758
    if-eqz v0, :cond_61

    .line 1759
    .line 1760
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 1761
    .line 1762
    .line 1763
    move-result-object v0

    .line 1764
    if-eqz v0, :cond_61

    .line 1765
    .line 1766
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMin:Ljava/lang/ref/WeakReference;

    .line 1767
    .line 1768
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 1769
    .line 1770
    .line 1771
    move-result-object v0

    .line 1772
    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4

    .line 1773
    .line 1774
    move-object/from16 v15, v23

    .line 1775
    .line 1776
    :try_start_3
    invoke-virtual {v9, v15}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1777
    .line 1778
    .line 1779
    move-result-object v13
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 1780
    :try_start_4
    invoke-virtual {v9, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1781
    .line 1782
    .line 1783
    move-result-object v0
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    .line 1784
    move/from16 v23, v8

    .line 1785
    .line 1786
    const/4 v6, 0x5

    .line 1787
    const/4 v8, 0x0

    .line 1788
    :try_start_5
    invoke-virtual {v9, v0, v13, v8, v6}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1789
    .line 1790
    .line 1791
    const/4 v8, 0x0

    .line 1792
    iput-object v8, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMin:Ljava/lang/ref/WeakReference;

    .line 1793
    .line 1794
    goto :goto_44

    .line 1795
    :catch_1
    move-exception v0

    .line 1796
    :goto_40
    const/4 v6, 0x0

    .line 1797
    :goto_41
    const/4 v8, 0x5

    .line 1798
    :goto_42
    const/4 v13, 0x1

    .line 1799
    goto/16 :goto_48

    .line 1800
    .line 1801
    :catch_2
    move-exception v0

    .line 1802
    goto :goto_43

    .line 1803
    :catch_3
    move-exception v0

    .line 1804
    :goto_43
    move/from16 v23, v8

    .line 1805
    .line 1806
    goto :goto_40

    .line 1807
    :catch_4
    move-exception v0

    .line 1808
    move-object/from16 v15, v23

    .line 1809
    .line 1810
    goto :goto_43

    .line 1811
    :cond_61
    move-object/from16 v15, v23

    .line 1812
    .line 1813
    move/from16 v23, v8

    .line 1814
    .line 1815
    :goto_44
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMax:Ljava/lang/ref/WeakReference;

    .line 1816
    .line 1817
    if-eqz v0, :cond_62

    .line 1818
    .line 1819
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 1820
    .line 1821
    .line 1822
    move-result-object v0

    .line 1823
    if-eqz v0, :cond_62

    .line 1824
    .line 1825
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMax:Ljava/lang/ref/WeakReference;

    .line 1826
    .line 1827
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 1828
    .line 1829
    .line 1830
    move-result-object v0

    .line 1831
    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1832
    .line 1833
    iget-object v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mBottom:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1834
    .line 1835
    invoke-virtual {v9, v6}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1836
    .line 1837
    .line 1838
    move-result-object v6

    .line 1839
    invoke-virtual {v9, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1840
    .line 1841
    .line 1842
    move-result-object v0

    .line 1843
    const/4 v8, 0x5

    .line 1844
    const/4 v13, 0x0

    .line 1845
    invoke-virtual {v9, v6, v0, v13, v8}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1846
    .line 1847
    .line 1848
    const/4 v8, 0x0

    .line 1849
    iput-object v8, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mVerticalWrapMax:Ljava/lang/ref/WeakReference;

    .line 1850
    .line 1851
    :cond_62
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMin:Ljava/lang/ref/WeakReference;

    .line 1852
    .line 1853
    if-eqz v0, :cond_63

    .line 1854
    .line 1855
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 1856
    .line 1857
    .line 1858
    move-result-object v0

    .line 1859
    if-eqz v0, :cond_63

    .line 1860
    .line 1861
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMin:Ljava/lang/ref/WeakReference;

    .line 1862
    .line 1863
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 1864
    .line 1865
    .line 1866
    move-result-object v0

    .line 1867
    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    .line 1868
    .line 1869
    move-object/from16 v6, v25

    .line 1870
    .line 1871
    :try_start_6
    invoke-virtual {v9, v6}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1872
    .line 1873
    .line 1874
    move-result-object v8

    .line 1875
    invoke-virtual {v9, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1876
    .line 1877
    .line 1878
    move-result-object v0
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5

    .line 1879
    move-object/from16 v25, v6

    .line 1880
    .line 1881
    const/4 v6, 0x0

    .line 1882
    const/4 v13, 0x5

    .line 1883
    :try_start_7
    invoke-virtual {v9, v0, v8, v6, v13}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V

    .line 1884
    .line 1885
    .line 1886
    const/4 v8, 0x0

    .line 1887
    iput-object v8, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMin:Ljava/lang/ref/WeakReference;

    .line 1888
    .line 1889
    goto :goto_45

    .line 1890
    :catch_5
    move-exception v0

    .line 1891
    move-object/from16 v25, v6

    .line 1892
    .line 1893
    goto :goto_40

    .line 1894
    :cond_63
    :goto_45
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMax:Ljava/lang/ref/WeakReference;

    .line 1895
    .line 1896
    if-eqz v0, :cond_64

    .line 1897
    .line 1898
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 1899
    .line 1900
    .line 1901
    move-result-object v0

    .line 1902
    if-eqz v0, :cond_64

    .line 1903
    .line 1904
    iget-object v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMax:Ljava/lang/ref/WeakReference;

    .line 1905
    .line 1906
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 1907
    .line 1908
    .line 1909
    move-result-object v0

    .line 1910
    check-cast v0, Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1911
    .line 1912
    iget-object v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mRight:Landroidx/constraintlayout/core/widgets/ConstraintAnchor;

    .line 1913
    .line 1914
    invoke-virtual {v9, v6}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1915
    .line 1916
    .line 1917
    move-result-object v6
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1

    .line 1918
    :try_start_8
    invoke-virtual {v9, v0}, Landroidx/constraintlayout/core/LinearSystem;->createObjectVariable(Ljava/lang/Object;)Landroidx/constraintlayout/core/SolverVariable;

    .line 1919
    .line 1920
    .line 1921
    move-result-object v0
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_8

    .line 1922
    const/4 v8, 0x5

    .line 1923
    const/4 v13, 0x0

    .line 1924
    :try_start_9
    invoke-virtual {v9, v6, v0, v13, v8}, Landroidx/constraintlayout/core/LinearSystem;->addGreaterThan(Landroidx/constraintlayout/core/SolverVariable;Landroidx/constraintlayout/core/SolverVariable;II)V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_7

    .line 1925
    .line 1926
    .line 1927
    const/4 v6, 0x0

    .line 1928
    :try_start_a
    iput-object v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHorizontalWrapMax:Ljava/lang/ref/WeakReference;

    .line 1929
    .line 1930
    goto :goto_47

    .line 1931
    :catch_6
    move-exception v0

    .line 1932
    goto/16 :goto_42

    .line 1933
    .line 1934
    :catch_7
    move-exception v0

    .line 1935
    :goto_46
    const/4 v6, 0x0

    .line 1936
    goto/16 :goto_42

    .line 1937
    .line 1938
    :catch_8
    move-exception v0

    .line 1939
    const/4 v8, 0x5

    .line 1940
    goto :goto_46

    .line 1941
    :cond_64
    const/4 v6, 0x0

    .line 1942
    const/4 v8, 0x5

    .line 1943
    :goto_47
    invoke-virtual {v9}, Landroidx/constraintlayout/core/LinearSystem;->minimize()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_6

    .line 1944
    .line 1945
    .line 1946
    move/from16 v24, v12

    .line 1947
    .line 1948
    const/4 v13, 0x1

    .line 1949
    goto :goto_49

    .line 1950
    :catch_9
    move-exception v0

    .line 1951
    move-object/from16 v15, v23

    .line 1952
    .line 1953
    const/4 v6, 0x0

    .line 1954
    move/from16 v23, v8

    .line 1955
    .line 1956
    goto/16 :goto_41

    .line 1957
    .line 1958
    :goto_48
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 1959
    .line 1960
    .line 1961
    sget-object v6, Ljava/lang/System;->out:Ljava/io/PrintStream;

    .line 1962
    .line 1963
    new-instance v8, Ljava/lang/StringBuilder;

    .line 1964
    .line 1965
    move/from16 v24, v12

    .line 1966
    .line 1967
    const-string v12, "EXCEPTION : "

    .line 1968
    .line 1969
    invoke-direct {v8, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1970
    .line 1971
    .line 1972
    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 1973
    .line 1974
    .line 1975
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 1976
    .line 1977
    .line 1978
    move-result-object v0

    .line 1979
    invoke-virtual {v6, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 1980
    .line 1981
    .line 1982
    :goto_49
    sget-object v0, Landroidx/constraintlayout/core/widgets/Chain;->sFlags:[Z

    .line 1983
    .line 1984
    if-eqz v13, :cond_68

    .line 1985
    .line 1986
    const/16 v17, 0x0

    .line 1987
    .line 1988
    const/16 v19, 0x2

    .line 1989
    .line 1990
    aput-boolean v17, v0, v19

    .line 1991
    .line 1992
    const/16 v6, 0x40

    .line 1993
    .line 1994
    invoke-virtual {v1, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->optimizeFor(I)Z

    .line 1995
    .line 1996
    .line 1997
    move-result v8

    .line 1998
    invoke-virtual {v1, v9, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->updateFromSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 1999
    .line 2000
    .line 2001
    iget-object v12, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 2002
    .line 2003
    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    .line 2004
    .line 2005
    .line 2006
    move-result v12

    .line 2007
    const/4 v13, 0x0

    .line 2008
    const/16 v16, 0x0

    .line 2009
    .line 2010
    :goto_4a
    if-ge v13, v12, :cond_67

    .line 2011
    .line 2012
    iget-object v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 2013
    .line 2014
    invoke-virtual {v6, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 2015
    .line 2016
    .line 2017
    move-result-object v6

    .line 2018
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 2019
    .line 2020
    invoke-virtual {v6, v9, v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->updateFromSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 2021
    .line 2022
    .line 2023
    move-object/from16 v27, v0

    .line 2024
    .line 2025
    iget v0, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mWidthOverride:I

    .line 2026
    .line 2027
    move/from16 v28, v8

    .line 2028
    .line 2029
    const/4 v8, -0x1

    .line 2030
    if-ne v0, v8, :cond_65

    .line 2031
    .line 2032
    iget v0, v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mHeightOverride:I

    .line 2033
    .line 2034
    if-eq v0, v8, :cond_66

    .line 2035
    .line 2036
    :cond_65
    const/16 v16, 0x1

    .line 2037
    .line 2038
    :cond_66
    add-int/lit8 v13, v13, 0x1

    .line 2039
    .line 2040
    move-object/from16 v0, v27

    .line 2041
    .line 2042
    move/from16 v8, v28

    .line 2043
    .line 2044
    const/16 v6, 0x40

    .line 2045
    .line 2046
    goto :goto_4a

    .line 2047
    :cond_67
    move-object/from16 v27, v0

    .line 2048
    .line 2049
    const/4 v8, -0x1

    .line 2050
    goto :goto_4c

    .line 2051
    :cond_68
    move-object/from16 v27, v0

    .line 2052
    .line 2053
    const/4 v8, -0x1

    .line 2054
    invoke-virtual {v1, v9, v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->updateFromSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 2055
    .line 2056
    .line 2057
    const/4 v0, 0x0

    .line 2058
    :goto_4b
    if-ge v0, v11, :cond_69

    .line 2059
    .line 2060
    iget-object v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 2061
    .line 2062
    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 2063
    .line 2064
    .line 2065
    move-result-object v6

    .line 2066
    check-cast v6, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 2067
    .line 2068
    invoke-virtual {v6, v9, v10}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->updateFromSolver(Landroidx/constraintlayout/core/LinearSystem;Z)V

    .line 2069
    .line 2070
    .line 2071
    add-int/lit8 v0, v0, 0x1

    .line 2072
    .line 2073
    goto :goto_4b

    .line 2074
    :cond_69
    const/16 v16, 0x0

    .line 2075
    .line 2076
    :goto_4c
    const/16 v0, 0x8

    .line 2077
    .line 2078
    if-eqz v23, :cond_6c

    .line 2079
    .line 2080
    if-ge v14, v0, :cond_6c

    .line 2081
    .line 2082
    const/16 v19, 0x2

    .line 2083
    .line 2084
    aget-boolean v6, v27, v19

    .line 2085
    .line 2086
    if-eqz v6, :cond_6c

    .line 2087
    .line 2088
    const/4 v6, 0x0

    .line 2089
    const/4 v12, 0x0

    .line 2090
    const/4 v13, 0x0

    .line 2091
    :goto_4d
    if-ge v6, v11, :cond_6a

    .line 2092
    .line 2093
    iget-object v8, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 2094
    .line 2095
    invoke-virtual {v8, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 2096
    .line 2097
    .line 2098
    move-result-object v8

    .line 2099
    check-cast v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 2100
    .line 2101
    iget v0, v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mX:I

    .line 2102
    .line 2103
    invoke-virtual {v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 2104
    .line 2105
    .line 2106
    move-result v28

    .line 2107
    add-int v0, v28, v0

    .line 2108
    .line 2109
    invoke-static {v12, v0}, Ljava/lang/Math;->max(II)I

    .line 2110
    .line 2111
    .line 2112
    move-result v12

    .line 2113
    iget v0, v8, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mY:I

    .line 2114
    .line 2115
    invoke-virtual {v8}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 2116
    .line 2117
    .line 2118
    move-result v8

    .line 2119
    add-int/2addr v8, v0

    .line 2120
    invoke-static {v13, v8}, Ljava/lang/Math;->max(II)I

    .line 2121
    .line 2122
    .line 2123
    move-result v13

    .line 2124
    add-int/lit8 v6, v6, 0x1

    .line 2125
    .line 2126
    const/16 v0, 0x8

    .line 2127
    .line 2128
    const/4 v8, -0x1

    .line 2129
    goto :goto_4d

    .line 2130
    :cond_6a
    iget v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    .line 2131
    .line 2132
    invoke-static {v0, v12}, Ljava/lang/Math;->max(II)I

    .line 2133
    .line 2134
    .line 2135
    move-result v0

    .line 2136
    iget v6, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    .line 2137
    .line 2138
    invoke-static {v6, v13}, Ljava/lang/Math;->max(II)I

    .line 2139
    .line 2140
    .line 2141
    move-result v6

    .line 2142
    const/4 v8, 0x2

    .line 2143
    if-ne v2, v8, :cond_6b

    .line 2144
    .line 2145
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 2146
    .line 2147
    .line 2148
    move-result v12

    .line 2149
    if-ge v12, v0, :cond_6b

    .line 2150
    .line 2151
    invoke-virtual {v1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    .line 2152
    .line 2153
    .line 2154
    const/16 v17, 0x0

    .line 2155
    .line 2156
    aput v8, v22, v17

    .line 2157
    .line 2158
    const/16 v16, 0x1

    .line 2159
    .line 2160
    const/16 v24, 0x1

    .line 2161
    .line 2162
    :cond_6b
    if-ne v4, v8, :cond_6c

    .line 2163
    .line 2164
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 2165
    .line 2166
    .line 2167
    move-result v0

    .line 2168
    if-ge v0, v6, :cond_6c

    .line 2169
    .line 2170
    invoke-virtual {v1, v6}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    .line 2171
    .line 2172
    .line 2173
    const/16 v18, 0x1

    .line 2174
    .line 2175
    aput v8, v22, v18

    .line 2176
    .line 2177
    const/16 v16, 0x1

    .line 2178
    .line 2179
    const/16 v24, 0x1

    .line 2180
    .line 2181
    :cond_6c
    iget v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinWidth:I

    .line 2182
    .line 2183
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 2184
    .line 2185
    .line 2186
    move-result v6

    .line 2187
    invoke-static {v0, v6}, Ljava/lang/Math;->max(II)I

    .line 2188
    .line 2189
    .line 2190
    move-result v0

    .line 2191
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 2192
    .line 2193
    .line 2194
    move-result v6

    .line 2195
    if-le v0, v6, :cond_6d

    .line 2196
    .line 2197
    invoke-virtual {v1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    .line 2198
    .line 2199
    .line 2200
    const/4 v8, 0x1

    .line 2201
    const/16 v17, 0x0

    .line 2202
    .line 2203
    aput v8, v22, v17

    .line 2204
    .line 2205
    const/16 v16, 0x1

    .line 2206
    .line 2207
    const/16 v18, 0x1

    .line 2208
    .line 2209
    goto :goto_4e

    .line 2210
    :cond_6d
    const/4 v8, 0x1

    .line 2211
    move/from16 v18, v24

    .line 2212
    .line 2213
    :goto_4e
    iget v0, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->mMinHeight:I

    .line 2214
    .line 2215
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 2216
    .line 2217
    .line 2218
    move-result v6

    .line 2219
    invoke-static {v0, v6}, Ljava/lang/Math;->max(II)I

    .line 2220
    .line 2221
    .line 2222
    move-result v0

    .line 2223
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 2224
    .line 2225
    .line 2226
    move-result v6

    .line 2227
    if-le v0, v6, :cond_6e

    .line 2228
    .line 2229
    invoke-virtual {v1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    .line 2230
    .line 2231
    .line 2232
    aput v8, v22, v8

    .line 2233
    .line 2234
    const/4 v0, 0x1

    .line 2235
    const/16 v16, 0x1

    .line 2236
    .line 2237
    goto :goto_4f

    .line 2238
    :cond_6e
    move/from16 v0, v18

    .line 2239
    .line 2240
    :goto_4f
    if-nez v0, :cond_71

    .line 2241
    .line 2242
    const/16 v17, 0x0

    .line 2243
    .line 2244
    aget v6, v22, v17

    .line 2245
    .line 2246
    const/4 v12, 0x2

    .line 2247
    if-ne v6, v12, :cond_6f

    .line 2248
    .line 2249
    if-lez v3, :cond_6f

    .line 2250
    .line 2251
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getWidth()I

    .line 2252
    .line 2253
    .line 2254
    move-result v6

    .line 2255
    if-le v6, v3, :cond_6f

    .line 2256
    .line 2257
    iput-boolean v8, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mWidthMeasuredTooSmall:Z

    .line 2258
    .line 2259
    aput v8, v22, v17

    .line 2260
    .line 2261
    invoke-virtual {v1, v3}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setWidth(I)V

    .line 2262
    .line 2263
    .line 2264
    const/4 v0, 0x1

    .line 2265
    const/16 v16, 0x1

    .line 2266
    .line 2267
    :cond_6f
    aget v6, v22, v8

    .line 2268
    .line 2269
    const/4 v12, 0x2

    .line 2270
    if-ne v6, v12, :cond_70

    .line 2271
    .line 2272
    if-lez v5, :cond_70

    .line 2273
    .line 2274
    invoke-virtual {v1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->getHeight()I

    .line 2275
    .line 2276
    .line 2277
    move-result v6

    .line 2278
    if-le v6, v5, :cond_70

    .line 2279
    .line 2280
    iput-boolean v8, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mHeightMeasuredTooSmall:Z

    .line 2281
    .line 2282
    aput v8, v22, v8

    .line 2283
    .line 2284
    invoke-virtual {v1, v5}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->setHeight(I)V

    .line 2285
    .line 2286
    .line 2287
    const/4 v0, 0x1

    .line 2288
    const/4 v6, 0x1

    .line 2289
    :goto_50
    const/16 v8, 0x8

    .line 2290
    .line 2291
    goto :goto_52

    .line 2292
    :cond_70
    :goto_51
    move/from16 v6, v16

    .line 2293
    .line 2294
    goto :goto_50

    .line 2295
    :cond_71
    const/4 v12, 0x2

    .line 2296
    goto :goto_51

    .line 2297
    :goto_52
    if-le v14, v8, :cond_72

    .line 2298
    .line 2299
    const/4 v13, 0x0

    .line 2300
    goto :goto_53

    .line 2301
    :cond_72
    move v13, v6

    .line 2302
    :goto_53
    move v12, v0

    .line 2303
    move v0, v14

    .line 2304
    move/from16 v8, v23

    .line 2305
    .line 2306
    const/16 v6, 0x40

    .line 2307
    .line 2308
    move-object/from16 v23, v15

    .line 2309
    .line 2310
    goto/16 :goto_3e

    .line 2311
    .line 2312
    :cond_73
    move/from16 v24, v12

    .line 2313
    .line 2314
    iput-object v7, v1, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 2315
    .line 2316
    if-eqz v24, :cond_74

    .line 2317
    .line 2318
    const/16 v17, 0x0

    .line 2319
    .line 2320
    aput v2, v22, v17

    .line 2321
    .line 2322
    const/16 v18, 0x1

    .line 2323
    .line 2324
    aput v4, v22, v18

    .line 2325
    .line 2326
    :cond_74
    iget-object v0, v9, Landroidx/constraintlayout/core/LinearSystem;->mCache:Lkotlin/text/MatcherMatchResult;

    .line 2327
    .line 2328
    invoke-virtual {v1, v0}, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->resetSolverVariables(Lkotlin/text/MatcherMatchResult;)V

    .line 2329
    .line 2330
    .line 2331
    return-void
.end method

.method public final optimizeFor(I)Z
    .locals 1

    .line 1
    iget v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mOptimizationLevel:I

    .line 2
    .line 3
    and-int/2addr v0, p1

    .line 4
    if-ne v0, p1, :cond_0

    .line 5
    .line 6
    const/4 p1, 0x1

    .line 7
    return p1

    .line 8
    :cond_0
    const/4 p1, 0x0

    .line 9
    return p1
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

.method public final reset()V
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mSystem:Landroidx/constraintlayout/core/LinearSystem;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/constraintlayout/core/LinearSystem;->reset()V

    .line 4
    .line 5
    .line 6
    const/4 v0, 0x0

    .line 7
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mPaddingLeft:I

    .line 8
    .line 9
    iput v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mPaddingTop:I

    .line 10
    .line 11
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 12
    .line 13
    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 14
    .line 15
    .line 16
    invoke-super {p0}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->reset()V

    .line 17
    .line 18
    .line 19
    return-void
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

.method public final resetSolverVariables(Lkotlin/text/MatcherMatchResult;)V
    .locals 3

    .line 1
    invoke-super {p0, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resetSolverVariables(Lkotlin/text/MatcherMatchResult;)V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    const/4 v1, 0x0

    .line 11
    :goto_0
    if-ge v1, v0, :cond_0

    .line 12
    .line 13
    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 14
    .line 15
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object v2

    .line 19
    check-cast v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 20
    .line 21
    invoke-virtual {v2, p1}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->resetSolverVariables(Lkotlin/text/MatcherMatchResult;)V

    .line 22
    .line 23
    .line 24
    add-int/lit8 v1, v1, 0x1

    .line 25
    .line 26
    goto :goto_0

    .line 27
    :cond_0
    return-void
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

.method public final updateFromRuns(ZZ)V
    .locals 3

    .line 1
    invoke-super {p0, p1, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->updateFromRuns(ZZ)V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    const/4 v1, 0x0

    .line 11
    :goto_0
    if-ge v1, v0, :cond_0

    .line 12
    .line 13
    iget-object v2, p0, Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;->mChildren:Ljava/util/ArrayList;

    .line 14
    .line 15
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object v2

    .line 19
    check-cast v2, Landroidx/constraintlayout/core/widgets/ConstraintWidget;

    .line 20
    .line 21
    invoke-virtual {v2, p1, p2}, Landroidx/constraintlayout/core/widgets/ConstraintWidget;->updateFromRuns(ZZ)V

    .line 22
    .line 23
    .line 24
    add-int/lit8 v1, v1, 0x1

    .line 25
    .line 26
    goto :goto_0

    .line 27
    :cond_0
    return-void
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
