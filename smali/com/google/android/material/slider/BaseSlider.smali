.class public abstract Lcom/google/android/material/slider/BaseSlider;
.super Landroid/view/View;
.source "SourceFile"


# static fields
.field public static final synthetic $r8$clinit:I


# instance fields
.field public accessibilityEventSender:Landroidx/core/provider/CallbackWithHandler$2;

.field public final accessibilityHelper:Lcom/google/android/material/slider/BaseSlider$AccessibilityHelper;

.field public final accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

.field public activeThumbIdx:I

.field public final activeTicksPaint:Landroid/graphics/Paint;

.field public final activeTrackPaint:Landroid/graphics/Paint;

.field public final activeTrackRect:Landroid/graphics/RectF;

.field public centered:Z

.field public final changeListeners:Ljava/util/ArrayList;

.field public final cornerRect:Landroid/graphics/RectF;

.field public customThumbDrawable:Landroid/graphics/drawable/Drawable;

.field public customThumbDrawablesForValues:Ljava/util/List;

.field public final defaultThumbDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field public final defaultThumbRadius:I

.field public defaultThumbTrackGapSize:I

.field public defaultThumbWidth:I

.field public final defaultTickActiveRadius:I

.field public final defaultTickInactiveRadius:I

.field public final defaultTrackThickness:I

.field public dirtyConfig:Z

.field public focusedThumbIdx:I

.field public formatter:Lcom/google/android/material/slider/LabelFormatter;

.field public haloColor:Landroid/content/res/ColorStateList;

.field public final haloPaint:Landroid/graphics/Paint;

.field public haloRadius:I

.field public final iconRect:Landroid/graphics/Rect;

.field public final iconRectF:Landroid/graphics/RectF;

.field public final inactiveTicksPaint:Landroid/graphics/Paint;

.field public final inactiveTrackLeftRect:Landroid/graphics/RectF;

.field public final inactiveTrackPaint:Landroid/graphics/Paint;

.field public final inactiveTrackRightRect:Landroid/graphics/RectF;

.field public isLongPress:Z

.field public labelBehavior:I

.field public final labelPadding:I

.field public final labelRect:Landroid/graphics/Rect;

.field public final labelStyle:I

.field public final labels:Ljava/util/ArrayList;

.field public labelsAreAnimatedIn:Z

.field public labelsInAnimator:Landroid/animation/ValueAnimator;

.field public labelsOutAnimator:Landroid/animation/ValueAnimator;

.field public lastEvent:Landroid/view/MotionEvent;

.field public final minTickSpacing:I

.field public final minTouchTargetSize:I

.field public final minTrackSidePadding:I

.field public final minWidgetThickness:I

.field public final onGlobalLayoutListener:Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda2;

.field public final onScrollChangedListener:Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;

.field public final resetActiveThumbIndex:Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;

.field public final rotationMatrix:Landroid/graphics/Matrix;

.field public final scaledTouchSlop:I

.field public separationUnit:I

.field public stepSize:F

.field public final stopIndicatorPaint:Landroid/graphics/Paint;

.field public thisAndAncestorsVisible:Z

.field public thumbHeight:I

.field public thumbIsPressed:Z

.field public final thumbPaint:Landroid/graphics/Paint;

.field public thumbTrackGapSize:I

.field public thumbWidth:I

.field public tickActiveRadius:I

.field public tickColorActive:Landroid/content/res/ColorStateList;

.field public tickColorInactive:Landroid/content/res/ColorStateList;

.field public tickInactiveRadius:I

.field public tickVisibilityMode:I

.field public ticksCoordinates:[F

.field public final tooltipTimeoutMillis:I

.field public touchDownAxis1:F

.field public touchDownAxis2:F

.field public final touchListeners:Ljava/util/ArrayList;

.field public touchPosition:F

.field public trackColorActive:Landroid/content/res/ColorStateList;

.field public trackColorInactive:Landroid/content/res/ColorStateList;

.field public trackCornerSize:I

.field public trackIconActiveColor:Landroid/content/res/ColorStateList;

.field public trackIconActiveEnd:Landroid/graphics/drawable/Drawable;

.field public trackIconActiveEndMutated:Z

.field public trackIconActiveStart:Landroid/graphics/drawable/Drawable;

.field public trackIconActiveStartMutated:Z

.field public trackIconInactiveColor:Landroid/content/res/ColorStateList;

.field public trackIconInactiveEnd:Landroid/graphics/drawable/Drawable;

.field public trackIconInactiveEndMutated:Z

.field public trackIconInactiveStart:Landroid/graphics/drawable/Drawable;

.field public trackIconInactiveStartMutated:Z

.field public final trackIconPadding:I

.field public trackIconSize:I

.field public trackInsideCornerSize:I

.field public final trackPath:Landroid/graphics/Path;

.field public trackSidePadding:I

.field public trackStopIndicatorSize:I

.field public trackThickness:I

.field public trackWidth:I

.field public valueFrom:F

.field public valueTo:F

.field public values:Ljava/util/ArrayList;

.field public widgetOrientation:I

.field public widgetThickness:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 13

    .line 1
    const v0, 0x7f1504dd

    .line 2
    .line 3
    .line 4
    const v4, 0x7f040492

    .line 5
    .line 6
    .line 7
    invoke-static {p1, p2, v4, v0}, Lcom/google/android/material/theme/overlay/MaterialThemeOverlay;->wrap(Landroid/content/Context;Landroid/util/AttributeSet;II)Landroid/content/Context;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    invoke-direct {p0, p1, p2, v4}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 12
    .line 13
    .line 14
    new-instance p1, Ljava/util/ArrayList;

    .line 15
    .line 16
    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    .line 17
    .line 18
    .line 19
    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 20
    .line 21
    new-instance p1, Ljava/util/ArrayList;

    .line 22
    .line 23
    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    .line 24
    .line 25
    .line 26
    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->changeListeners:Ljava/util/ArrayList;

    .line 27
    .line 28
    new-instance p1, Ljava/util/ArrayList;

    .line 29
    .line 30
    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    .line 31
    .line 32
    .line 33
    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->touchListeners:Ljava/util/ArrayList;

    .line 34
    .line 35
    const/4 p1, 0x0

    .line 36
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->labelsAreAnimatedIn:Z

    .line 37
    .line 38
    const/4 v0, -0x1

    .line 39
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbWidth:I

    .line 40
    .line 41
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbTrackGapSize:I

    .line 42
    .line 43
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->centered:Z

    .line 44
    .line 45
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStartMutated:Z

    .line 46
    .line 47
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEndMutated:Z

    .line 48
    .line 49
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStartMutated:Z

    .line 50
    .line 51
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEndMutated:Z

    .line 52
    .line 53
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbIsPressed:Z

    .line 54
    .line 55
    new-instance v1, Ljava/util/ArrayList;

    .line 56
    .line 57
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 58
    .line 59
    .line 60
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 61
    .line 62
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 63
    .line 64
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 65
    .line 66
    const/4 v7, 0x0

    .line 67
    iput v7, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 68
    .line 69
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->isLongPress:Z

    .line 70
    .line 71
    new-instance v1, Landroid/graphics/Path;

    .line 72
    .line 73
    invoke-direct {v1}, Landroid/graphics/Path;-><init>()V

    .line 74
    .line 75
    .line 76
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackPath:Landroid/graphics/Path;

    .line 77
    .line 78
    new-instance v1, Landroid/graphics/RectF;

    .line 79
    .line 80
    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    .line 81
    .line 82
    .line 83
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->activeTrackRect:Landroid/graphics/RectF;

    .line 84
    .line 85
    new-instance v1, Landroid/graphics/RectF;

    .line 86
    .line 87
    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    .line 88
    .line 89
    .line 90
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->inactiveTrackLeftRect:Landroid/graphics/RectF;

    .line 91
    .line 92
    new-instance v1, Landroid/graphics/RectF;

    .line 93
    .line 94
    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    .line 95
    .line 96
    .line 97
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->inactiveTrackRightRect:Landroid/graphics/RectF;

    .line 98
    .line 99
    new-instance v1, Landroid/graphics/RectF;

    .line 100
    .line 101
    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    .line 102
    .line 103
    .line 104
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->cornerRect:Landroid/graphics/RectF;

    .line 105
    .line 106
    new-instance v1, Landroid/graphics/Rect;

    .line 107
    .line 108
    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 109
    .line 110
    .line 111
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->labelRect:Landroid/graphics/Rect;

    .line 112
    .line 113
    new-instance v1, Landroid/graphics/RectF;

    .line 114
    .line 115
    invoke-direct {v1}, Landroid/graphics/RectF;-><init>()V

    .line 116
    .line 117
    .line 118
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->iconRectF:Landroid/graphics/RectF;

    .line 119
    .line 120
    new-instance v1, Landroid/graphics/Rect;

    .line 121
    .line 122
    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    .line 123
    .line 124
    .line 125
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->iconRect:Landroid/graphics/Rect;

    .line 126
    .line 127
    new-instance v1, Landroid/graphics/Matrix;

    .line 128
    .line 129
    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    .line 130
    .line 131
    .line 132
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 133
    .line 134
    new-instance v8, Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 135
    .line 136
    invoke-direct {v8}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>()V

    .line 137
    .line 138
    .line 139
    iput-object v8, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 140
    .line 141
    sget-object v1, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 142
    .line 143
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->customThumbDrawablesForValues:Ljava/util/List;

    .line 144
    .line 145
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->separationUnit:I

    .line 146
    .line 147
    new-instance v1, Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;

    .line 148
    .line 149
    move-object v9, p0

    .line 150
    check-cast v9, Lcom/google/android/material/slider/Slider;

    .line 151
    .line 152
    invoke-direct {v1, v9}, Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;-><init>(Lcom/google/android/material/slider/Slider;)V

    .line 153
    .line 154
    .line 155
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->onScrollChangedListener:Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;

    .line 156
    .line 157
    new-instance v1, Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda2;

    .line 158
    .line 159
    invoke-direct {v1, v9}, Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda2;-><init>(Lcom/google/android/material/slider/Slider;)V

    .line 160
    .line 161
    .line 162
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->onGlobalLayoutListener:Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda2;

    .line 163
    .line 164
    new-instance v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;

    .line 165
    .line 166
    const/16 v10, 0x15

    .line 167
    .line 168
    invoke-direct {v1, v10, v9}, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 169
    .line 170
    .line 171
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->resetActiveThumbIndex:Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;

    .line 172
    .line 173
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 174
    .line 175
    .line 176
    move-result-object v1

    .line 177
    invoke-virtual {p0}, Landroid/view/View;->isShown()Z

    .line 178
    .line 179
    .line 180
    move-result v2

    .line 181
    iput-boolean v2, p0, Lcom/google/android/material/slider/BaseSlider;->thisAndAncestorsVisible:Z

    .line 182
    .line 183
    new-instance v2, Landroid/graphics/Paint;

    .line 184
    .line 185
    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 186
    .line 187
    .line 188
    iput-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->inactiveTrackPaint:Landroid/graphics/Paint;

    .line 189
    .line 190
    new-instance v2, Landroid/graphics/Paint;

    .line 191
    .line 192
    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 193
    .line 194
    .line 195
    iput-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->activeTrackPaint:Landroid/graphics/Paint;

    .line 196
    .line 197
    new-instance v2, Landroid/graphics/Paint;

    .line 198
    .line 199
    const/4 v11, 0x1

    .line 200
    invoke-direct {v2, v11}, Landroid/graphics/Paint;-><init>(I)V

    .line 201
    .line 202
    .line 203
    iput-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbPaint:Landroid/graphics/Paint;

    .line 204
    .line 205
    sget-object v3, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    .line 206
    .line 207
    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 208
    .line 209
    .line 210
    new-instance v5, Landroid/graphics/PorterDuffXfermode;

    .line 211
    .line 212
    sget-object v6, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    .line 213
    .line 214
    invoke-direct {v5, v6}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    .line 215
    .line 216
    .line 217
    invoke-virtual {v2, v5}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 218
    .line 219
    .line 220
    new-instance v2, Landroid/graphics/Paint;

    .line 221
    .line 222
    invoke-direct {v2, v11}, Landroid/graphics/Paint;-><init>(I)V

    .line 223
    .line 224
    .line 225
    iput-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->haloPaint:Landroid/graphics/Paint;

    .line 226
    .line 227
    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 228
    .line 229
    .line 230
    new-instance v2, Landroid/graphics/Paint;

    .line 231
    .line 232
    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 233
    .line 234
    .line 235
    iput-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->inactiveTicksPaint:Landroid/graphics/Paint;

    .line 236
    .line 237
    sget-object v5, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    .line 238
    .line 239
    invoke-virtual {v2, v5}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 240
    .line 241
    .line 242
    sget-object v6, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    .line 243
    .line 244
    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 245
    .line 246
    .line 247
    new-instance v2, Landroid/graphics/Paint;

    .line 248
    .line 249
    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 250
    .line 251
    .line 252
    iput-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->activeTicksPaint:Landroid/graphics/Paint;

    .line 253
    .line 254
    invoke-virtual {v2, v5}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 255
    .line 256
    .line 257
    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 258
    .line 259
    .line 260
    new-instance v2, Landroid/graphics/Paint;

    .line 261
    .line 262
    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    .line 263
    .line 264
    .line 265
    iput-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->stopIndicatorPaint:Landroid/graphics/Paint;

    .line 266
    .line 267
    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 268
    .line 269
    .line 270
    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 271
    .line 272
    .line 273
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 274
    .line 275
    .line 276
    move-result-object v2

    .line 277
    const v3, 0x7f0703ec

    .line 278
    .line 279
    .line 280
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 281
    .line 282
    .line 283
    move-result v3

    .line 284
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->minWidgetThickness:I

    .line 285
    .line 286
    const v3, 0x7f0703eb

    .line 287
    .line 288
    .line 289
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    .line 290
    .line 291
    .line 292
    move-result v3

    .line 293
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->minTrackSidePadding:I

    .line 294
    .line 295
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 296
    .line 297
    const v3, 0x7f0703e7

    .line 298
    .line 299
    .line 300
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 301
    .line 302
    .line 303
    move-result v3

    .line 304
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbRadius:I

    .line 305
    .line 306
    const v3, 0x7f0703ea

    .line 307
    .line 308
    .line 309
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 310
    .line 311
    .line 312
    move-result v3

    .line 313
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->defaultTrackThickness:I

    .line 314
    .line 315
    const v3, 0x7f0703e9

    .line 316
    .line 317
    .line 318
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 319
    .line 320
    .line 321
    move-result v5

    .line 322
    iput v5, p0, Lcom/google/android/material/slider/BaseSlider;->defaultTickActiveRadius:I

    .line 323
    .line 324
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 325
    .line 326
    .line 327
    move-result v3

    .line 328
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->defaultTickInactiveRadius:I

    .line 329
    .line 330
    const v3, 0x7f0703e8

    .line 331
    .line 332
    .line 333
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 334
    .line 335
    .line 336
    move-result v3

    .line 337
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->minTickSpacing:I

    .line 338
    .line 339
    const v3, 0x7f0703e3

    .line 340
    .line 341
    .line 342
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 343
    .line 344
    .line 345
    move-result v3

    .line 346
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->labelPadding:I

    .line 347
    .line 348
    const v3, 0x7f0702d3

    .line 349
    .line 350
    .line 351
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    .line 352
    .line 353
    .line 354
    move-result v2

    .line 355
    iput v2, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconPadding:I

    .line 356
    .line 357
    new-array v6, p1, [I

    .line 358
    .line 359
    const v5, 0x7f1504dd

    .line 360
    .line 361
    .line 362
    invoke-static {v1, p2, v4, v5}, Lcom/google/android/material/internal/ViewUtils;->checkCompatibleTheme(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 363
    .line 364
    .line 365
    sget-object v3, Lcom/google/android/material/R$styleable;->Slider:[I

    .line 366
    .line 367
    move-object v2, p2

    .line 368
    invoke-static/range {v1 .. v6}, Lcom/google/android/material/internal/ViewUtils;->checkTextAppearance(Landroid/content/Context;Landroid/util/AttributeSet;[III[I)V

    .line 369
    .line 370
    .line 371
    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    .line 372
    .line 373
    .line 374
    move-result-object p2

    .line 375
    const/4 v2, 0x2

    .line 376
    invoke-virtual {p2, v2, p1}, Landroid/content/res/TypedArray;->getInt(II)I

    .line 377
    .line 378
    .line 379
    move-result v3

    .line 380
    invoke-virtual {p0, v3}, Lcom/google/android/material/slider/BaseSlider;->setOrientation(I)V

    .line 381
    .line 382
    .line 383
    const/16 v3, 0xa

    .line 384
    .line 385
    const v4, 0x7f1504ff

    .line 386
    .line 387
    .line 388
    invoke-virtual {p2, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    .line 389
    .line 390
    .line 391
    move-result v3

    .line 392
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->labelStyle:I

    .line 393
    .line 394
    const/4 v3, 0x4

    .line 395
    invoke-virtual {p2, v3, v7}, Landroid/content/res/TypedArray;->getFloat(IF)F

    .line 396
    .line 397
    .line 398
    move-result v3

    .line 399
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 400
    .line 401
    const/4 v3, 0x5

    .line 402
    const/high16 v4, 0x3f800000    # 1.0f

    .line 403
    .line 404
    invoke-virtual {p2, v3, v4}, Landroid/content/res/TypedArray;->getFloat(IF)F

    .line 405
    .line 406
    .line 407
    move-result v3

    .line 408
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 409
    .line 410
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 411
    .line 412
    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 413
    .line 414
    .line 415
    move-result-object v3

    .line 416
    new-array v4, v11, [Ljava/lang/Float;

    .line 417
    .line 418
    aput-object v3, v4, p1

    .line 419
    .line 420
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setValues([Ljava/lang/Float;)V

    .line 421
    .line 422
    .line 423
    const/4 v3, 0x6

    .line 424
    invoke-virtual {p2, v3, p1}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    .line 425
    .line 426
    .line 427
    move-result v4

    .line 428
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setCentered(Z)V

    .line 429
    .line 430
    .line 431
    const/4 v4, 0x3

    .line 432
    invoke-virtual {p2, v4, v7}, Landroid/content/res/TypedArray;->getFloat(IF)F

    .line 433
    .line 434
    .line 435
    move-result v4

    .line 436
    iput v4, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 437
    .line 438
    invoke-static {v1}, Lkotlin/LazyKt__LazyJVMKt;->resolveMinimumAccessibleTouchTarget(Landroid/content/Context;)I

    .line 439
    .line 440
    .line 441
    move-result v4

    .line 442
    int-to-float v4, v4

    .line 443
    const/16 v5, 0xb

    .line 444
    .line 445
    invoke-virtual {p2, v5, v4}, Landroid/content/res/TypedArray;->getDimension(IF)F

    .line 446
    .line 447
    .line 448
    move-result v4

    .line 449
    float-to-double v4, v4

    .line 450
    invoke-static {v4, v5}, Ljava/lang/Math;->ceil(D)D

    .line 451
    .line 452
    .line 453
    move-result-wide v4

    .line 454
    double-to-int v4, v4

    .line 455
    iput v4, p0, Lcom/google/android/material/slider/BaseSlider;->minTouchTargetSize:I

    .line 456
    .line 457
    const/16 v4, 0x1b

    .line 458
    .line 459
    invoke-virtual {p2, v4}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 460
    .line 461
    .line 462
    move-result v5

    .line 463
    const/16 v6, 0x1d

    .line 464
    .line 465
    if-eqz v5, :cond_0

    .line 466
    .line 467
    const/16 v12, 0x1b

    .line 468
    .line 469
    goto :goto_0

    .line 470
    :cond_0
    const/16 v12, 0x1d

    .line 471
    .line 472
    :goto_0
    if-eqz v5, :cond_1

    .line 473
    .line 474
    goto :goto_1

    .line 475
    :cond_1
    const/16 v4, 0x1c

    .line 476
    .line 477
    :goto_1
    invoke-static {v1, p2, v12}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 478
    .line 479
    .line 480
    move-result-object v5

    .line 481
    if-eqz v5, :cond_2

    .line 482
    .line 483
    goto :goto_2

    .line 484
    :cond_2
    const v5, 0x7f060380

    .line 485
    .line 486
    .line 487
    invoke-static {v1, v5}, Landroidx/core/os/BundleKt;->getColorStateList(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    .line 488
    .line 489
    .line 490
    move-result-object v5

    .line 491
    :goto_2
    invoke-virtual {p0, v5}, Lcom/google/android/material/slider/BaseSlider;->setTrackInactiveTintList(Landroid/content/res/ColorStateList;)V

    .line 492
    .line 493
    .line 494
    invoke-static {v1, p2, v4}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 495
    .line 496
    .line 497
    move-result-object v4

    .line 498
    if-eqz v4, :cond_3

    .line 499
    .line 500
    goto :goto_3

    .line 501
    :cond_3
    const v4, 0x7f06037d

    .line 502
    .line 503
    .line 504
    invoke-static {v1, v4}, Landroidx/core/os/BundleKt;->getColorStateList(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    .line 505
    .line 506
    .line 507
    move-result-object v4

    .line 508
    :goto_3
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setTrackActiveTintList(Landroid/content/res/ColorStateList;)V

    .line 509
    .line 510
    .line 511
    const/16 v4, 0xc

    .line 512
    .line 513
    invoke-static {v1, p2, v4}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 514
    .line 515
    .line 516
    move-result-object v4

    .line 517
    invoke-virtual {v8, v4}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setFillColor(Landroid/content/res/ColorStateList;)V

    .line 518
    .line 519
    .line 520
    const/16 v4, 0x10

    .line 521
    .line 522
    invoke-virtual {p2, v4}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 523
    .line 524
    .line 525
    move-result v5

    .line 526
    if-eqz v5, :cond_4

    .line 527
    .line 528
    invoke-static {v1, p2, v4}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 529
    .line 530
    .line 531
    move-result-object v4

    .line 532
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setThumbStrokeColor(Landroid/content/res/ColorStateList;)V

    .line 533
    .line 534
    .line 535
    :cond_4
    const/16 v4, 0x11

    .line 536
    .line 537
    invoke-virtual {p2, v4, v7}, Landroid/content/res/TypedArray;->getDimension(IF)F

    .line 538
    .line 539
    .line 540
    move-result v4

    .line 541
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setThumbStrokeWidth(F)V

    .line 542
    .line 543
    .line 544
    const/4 v4, 0x7

    .line 545
    invoke-static {v1, p2, v4}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 546
    .line 547
    .line 548
    move-result-object v4

    .line 549
    if-eqz v4, :cond_5

    .line 550
    .line 551
    goto :goto_4

    .line 552
    :cond_5
    const v4, 0x7f06037e

    .line 553
    .line 554
    .line 555
    invoke-static {v1, v4}, Landroidx/core/os/BundleKt;->getColorStateList(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    .line 556
    .line 557
    .line 558
    move-result-object v4

    .line 559
    :goto_4
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setHaloTintList(Landroid/content/res/ColorStateList;)V

    .line 560
    .line 561
    .line 562
    const/16 v4, 0x19

    .line 563
    .line 564
    invoke-virtual {p2, v4}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 565
    .line 566
    .line 567
    move-result v5

    .line 568
    if-eqz v5, :cond_6

    .line 569
    .line 570
    invoke-virtual {p2, v4, v0}, Landroid/content/res/TypedArray;->getInt(II)I

    .line 571
    .line 572
    .line 573
    move-result v4

    .line 574
    goto :goto_5

    .line 575
    :cond_6
    const/16 v4, 0x1a

    .line 576
    .line 577
    invoke-virtual {p2, v4, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    .line 578
    .line 579
    .line 580
    move-result v4

    .line 581
    if-eqz v4, :cond_7

    .line 582
    .line 583
    const/4 v4, 0x0

    .line 584
    goto :goto_5

    .line 585
    :cond_7
    const/4 v4, 0x2

    .line 586
    :goto_5
    iput v4, p0, Lcom/google/android/material/slider/BaseSlider;->tickVisibilityMode:I

    .line 587
    .line 588
    const/16 v4, 0x14

    .line 589
    .line 590
    invoke-virtual {p2, v4}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 591
    .line 592
    .line 593
    move-result v5

    .line 594
    if-eqz v5, :cond_8

    .line 595
    .line 596
    const/16 v12, 0x14

    .line 597
    .line 598
    goto :goto_6

    .line 599
    :cond_8
    const/16 v12, 0x16

    .line 600
    .line 601
    :goto_6
    if-eqz v5, :cond_9

    .line 602
    .line 603
    const/16 v10, 0x14

    .line 604
    .line 605
    :cond_9
    invoke-static {v1, p2, v12}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 606
    .line 607
    .line 608
    move-result-object v4

    .line 609
    if-eqz v4, :cond_a

    .line 610
    .line 611
    goto :goto_7

    .line 612
    :cond_a
    const v4, 0x7f06037f

    .line 613
    .line 614
    .line 615
    invoke-static {v1, v4}, Landroidx/core/os/BundleKt;->getColorStateList(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    .line 616
    .line 617
    .line 618
    move-result-object v4

    .line 619
    :goto_7
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setTickInactiveTintList(Landroid/content/res/ColorStateList;)V

    .line 620
    .line 621
    .line 622
    invoke-static {v1, p2, v10}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 623
    .line 624
    .line 625
    move-result-object v4

    .line 626
    if-eqz v4, :cond_b

    .line 627
    .line 628
    goto :goto_8

    .line 629
    :cond_b
    const v4, 0x7f06037c

    .line 630
    .line 631
    .line 632
    invoke-static {v1, v4}, Landroidx/core/os/BundleKt;->getColorStateList(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    .line 633
    .line 634
    .line 635
    move-result-object v4

    .line 636
    :goto_8
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setTickActiveTintList(Landroid/content/res/ColorStateList;)V

    .line 637
    .line 638
    .line 639
    const/16 v4, 0x12

    .line 640
    .line 641
    invoke-virtual {p2, v4, p1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 642
    .line 643
    .line 644
    move-result v4

    .line 645
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setThumbTrackGapSize(I)V

    .line 646
    .line 647
    .line 648
    const/16 v4, 0x28

    .line 649
    .line 650
    invoke-virtual {p2, v4, p1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 651
    .line 652
    .line 653
    move-result v4

    .line 654
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setTrackStopIndicatorSize(I)V

    .line 655
    .line 656
    .line 657
    const/16 v4, 0x1e

    .line 658
    .line 659
    invoke-virtual {p2, v4, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 660
    .line 661
    .line 662
    move-result v0

    .line 663
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackCornerSize(I)V

    .line 664
    .line 665
    .line 666
    const/16 v0, 0x27

    .line 667
    .line 668
    invoke-virtual {p2, v0, p1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 669
    .line 670
    .line 671
    move-result v0

    .line 672
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackInsideCornerSize(I)V

    .line 673
    .line 674
    .line 675
    const/16 v0, 0x22

    .line 676
    .line 677
    invoke-static {v1, p2, v0}, Lkotlin/LazyKt__LazyJVMKt;->getDrawable(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;

    .line 678
    .line 679
    .line 680
    move-result-object v0

    .line 681
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackIconActiveStart(Landroid/graphics/drawable/Drawable;)V

    .line 682
    .line 683
    .line 684
    const/16 v0, 0x21

    .line 685
    .line 686
    invoke-static {v1, p2, v0}, Lkotlin/LazyKt__LazyJVMKt;->getDrawable(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;

    .line 687
    .line 688
    .line 689
    move-result-object v0

    .line 690
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackIconActiveEnd(Landroid/graphics/drawable/Drawable;)V

    .line 691
    .line 692
    .line 693
    const/16 v0, 0x20

    .line 694
    .line 695
    invoke-static {v1, p2, v0}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 696
    .line 697
    .line 698
    move-result-object v0

    .line 699
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackIconActiveColor(Landroid/content/res/ColorStateList;)V

    .line 700
    .line 701
    .line 702
    const/16 v0, 0x25

    .line 703
    .line 704
    invoke-static {v1, p2, v0}, Lkotlin/LazyKt__LazyJVMKt;->getDrawable(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;

    .line 705
    .line 706
    .line 707
    move-result-object v0

    .line 708
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackIconInactiveStart(Landroid/graphics/drawable/Drawable;)V

    .line 709
    .line 710
    .line 711
    const/16 v0, 0x24

    .line 712
    .line 713
    invoke-static {v1, p2, v0}, Lkotlin/LazyKt__LazyJVMKt;->getDrawable(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;

    .line 714
    .line 715
    .line 716
    move-result-object v0

    .line 717
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackIconInactiveEnd(Landroid/graphics/drawable/Drawable;)V

    .line 718
    .line 719
    .line 720
    const/16 v0, 0x23

    .line 721
    .line 722
    invoke-static {v1, p2, v0}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 723
    .line 724
    .line 725
    move-result-object v0

    .line 726
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackIconInactiveColor(Landroid/content/res/ColorStateList;)V

    .line 727
    .line 728
    .line 729
    const/16 v0, 0x26

    .line 730
    .line 731
    invoke-virtual {p2, v0, p1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 732
    .line 733
    .line 734
    move-result v0

    .line 735
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackIconSize(I)V

    .line 736
    .line 737
    .line 738
    const/16 v0, 0xf

    .line 739
    .line 740
    invoke-virtual {p2, v0, p1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 741
    .line 742
    .line 743
    move-result v0

    .line 744
    mul-int/lit8 v0, v0, 0x2

    .line 745
    .line 746
    const/16 v4, 0x13

    .line 747
    .line 748
    invoke-virtual {p2, v4, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 749
    .line 750
    .line 751
    move-result v4

    .line 752
    const/16 v5, 0xe

    .line 753
    .line 754
    invoke-virtual {p2, v5, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 755
    .line 756
    .line 757
    move-result v0

    .line 758
    invoke-virtual {p0, v4}, Lcom/google/android/material/slider/BaseSlider;->setThumbWidth(I)V

    .line 759
    .line 760
    .line 761
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setThumbHeight(I)V

    .line 762
    .line 763
    .line 764
    const/16 v0, 0x8

    .line 765
    .line 766
    invoke-virtual {p2, v0, p1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 767
    .line 768
    .line 769
    move-result v0

    .line 770
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setHaloRadius(I)V

    .line 771
    .line 772
    .line 773
    const/16 v0, 0xd

    .line 774
    .line 775
    invoke-virtual {p2, v0, v7}, Landroid/content/res/TypedArray;->getDimension(IF)F

    .line 776
    .line 777
    .line 778
    move-result v0

    .line 779
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setThumbElevation(F)V

    .line 780
    .line 781
    .line 782
    const/16 v0, 0x1f

    .line 783
    .line 784
    invoke-virtual {p2, v0, p1}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 785
    .line 786
    .line 787
    move-result v0

    .line 788
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTrackHeight(I)V

    .line 789
    .line 790
    .line 791
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackStopIndicatorSize:I

    .line 792
    .line 793
    div-int/2addr v0, v2

    .line 794
    const/16 v4, 0x17

    .line 795
    .line 796
    invoke-virtual {p2, v4, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 797
    .line 798
    .line 799
    move-result v0

    .line 800
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTickActiveRadius(I)V

    .line 801
    .line 802
    .line 803
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackStopIndicatorSize:I

    .line 804
    .line 805
    div-int/2addr v0, v2

    .line 806
    const/16 v2, 0x18

    .line 807
    .line 808
    invoke-virtual {p2, v2, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 809
    .line 810
    .line 811
    move-result v0

    .line 812
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setTickInactiveRadius(I)V

    .line 813
    .line 814
    .line 815
    const/16 v0, 0x9

    .line 816
    .line 817
    invoke-virtual {p2, v0, p1}, Landroid/content/res/TypedArray;->getInt(II)I

    .line 818
    .line 819
    .line 820
    move-result v0

    .line 821
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setLabelBehavior(I)V

    .line 822
    .line 823
    .line 824
    invoke-virtual {p2, p1, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    .line 825
    .line 826
    .line 827
    move-result v0

    .line 828
    if-nez v0, :cond_c

    .line 829
    .line 830
    invoke-virtual {p0, p1}, Lcom/google/android/material/slider/BaseSlider;->setEnabled(Z)V

    .line 831
    .line 832
    .line 833
    :cond_c
    invoke-virtual {p2}, Landroid/content/res/TypedArray;->recycle()V

    .line 834
    .line 835
    .line 836
    invoke-virtual {p0, v11}, Landroid/view/View;->setFocusable(Z)V

    .line 837
    .line 838
    .line 839
    invoke-virtual {p0, v11}, Landroid/view/View;->setClickable(Z)V

    .line 840
    .line 841
    .line 842
    invoke-virtual {v8}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShadowCompatibilityMode()V

    .line 843
    .line 844
    .line 845
    invoke-static {v1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    .line 846
    .line 847
    .line 848
    move-result-object p1

    .line 849
    invoke-virtual {p1}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    .line 850
    .line 851
    .line 852
    move-result p1

    .line 853
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->scaledTouchSlop:I

    .line 854
    .line 855
    new-instance p1, Lcom/google/android/material/slider/BaseSlider$AccessibilityHelper;

    .line 856
    .line 857
    invoke-direct {p1, v9}, Lcom/google/android/material/slider/BaseSlider$AccessibilityHelper;-><init>(Lcom/google/android/material/slider/Slider;)V

    .line 858
    .line 859
    .line 860
    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityHelper:Lcom/google/android/material/slider/BaseSlider$AccessibilityHelper;

    .line 861
    .line 862
    invoke-static {p0, p1}, Landroidx/core/view/ViewCompat;->setAccessibilityDelegate(Landroid/view/View;Landroidx/core/view/AccessibilityDelegateCompat;)V

    .line 863
    .line 864
    .line 865
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 866
    .line 867
    .line 868
    move-result-object p1

    .line 869
    const-string p2, "accessibility"

    .line 870
    .line 871
    invoke-virtual {p1, p2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 872
    .line 873
    .line 874
    move-result-object p1

    .line 875
    check-cast p1, Landroid/view/accessibility/AccessibilityManager;

    .line 876
    .line 877
    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    .line 878
    .line 879
    sget p2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 880
    .line 881
    if-lt p2, v6, :cond_d

    .line 882
    .line 883
    const/16 p2, 0x2710

    .line 884
    .line 885
    invoke-virtual {p1, p2, v3}, Landroid/view/accessibility/AccessibilityManager;->getRecommendedTimeoutMillis(II)I

    .line 886
    .line 887
    .line 888
    move-result p1

    .line 889
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->tooltipTimeoutMillis:I

    .line 890
    .line 891
    return-void

    .line 892
    :cond_d
    const p1, 0x1d4c0

    .line 893
    .line 894
    .line 895
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->tooltipTimeoutMillis:I

    .line 896
    .line 897
    return-void
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


# virtual methods
.method public final adjustCustomThumbDrawableBounds(Landroid/graphics/drawable/Drawable;)V
    .locals 5

    .line 1
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    const/4 v2, 0x0

    .line 10
    const/4 v3, -0x1

    .line 11
    if-ne v0, v3, :cond_0

    .line 12
    .line 13
    if-ne v1, v3, :cond_0

    .line 14
    .line 15
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 16
    .line 17
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbHeight:I

    .line 18
    .line 19
    invoke-virtual {p1, v2, v2, v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 20
    .line 21
    .line 22
    return-void

    .line 23
    :cond_0
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 24
    .line 25
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->thumbHeight:I

    .line 26
    .line 27
    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    .line 28
    .line 29
    .line 30
    move-result v3

    .line 31
    int-to-float v3, v3

    .line 32
    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    .line 33
    .line 34
    .line 35
    move-result v4

    .line 36
    int-to-float v4, v4

    .line 37
    div-float/2addr v3, v4

    .line 38
    int-to-float v0, v0

    .line 39
    mul-float v0, v0, v3

    .line 40
    .line 41
    float-to-int v0, v0

    .line 42
    int-to-float v1, v1

    .line 43
    mul-float v1, v1, v3

    .line 44
    .line 45
    float-to-int v1, v1

    .line 46
    invoke-virtual {p1, v2, v2, v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 47
    .line 48
    .line 49
    return-void
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public final calculateBoundsAndDrawTrackIcon(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/drawable/Drawable;Z)V
    .locals 5

    .line 1
    if-eqz p3, :cond_5

    .line 2
    .line 3
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconSize:I

    .line 4
    .line 5
    iget v1, p2, Landroid/graphics/RectF;->right:F

    .line 6
    .line 7
    iget v2, p2, Landroid/graphics/RectF;->left:F

    .line 8
    .line 9
    sub-float/2addr v1, v2

    .line 10
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconPadding:I

    .line 11
    .line 12
    mul-int/lit8 v3, v2, 0x2

    .line 13
    .line 14
    add-int/2addr v3, v0

    .line 15
    int-to-float v3, v3

    .line 16
    iget-object v4, p0, Lcom/google/android/material/slider/BaseSlider;->iconRectF:Landroid/graphics/RectF;

    .line 17
    .line 18
    cmpl-float v1, v1, v3

    .line 19
    .line 20
    if-ltz v1, :cond_3

    .line 21
    .line 22
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 23
    .line 24
    .line 25
    move-result v1

    .line 26
    if-nez v1, :cond_1

    .line 27
    .line 28
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 29
    .line 30
    .line 31
    move-result v1

    .line 32
    if-eqz v1, :cond_0

    .line 33
    .line 34
    goto :goto_0

    .line 35
    :cond_0
    const/4 v1, 0x0

    .line 36
    goto :goto_1

    .line 37
    :cond_1
    :goto_0
    const/4 v1, 0x1

    .line 38
    :goto_1
    xor-int/2addr p4, v1

    .line 39
    if-eqz p4, :cond_2

    .line 40
    .line 41
    iget p2, p2, Landroid/graphics/RectF;->left:F

    .line 42
    .line 43
    int-to-float p4, v2

    .line 44
    add-float/2addr p2, p4

    .line 45
    goto :goto_2

    .line 46
    :cond_2
    iget p2, p2, Landroid/graphics/RectF;->right:F

    .line 47
    .line 48
    int-to-float p4, v2

    .line 49
    sub-float/2addr p2, p4

    .line 50
    int-to-float p4, v0

    .line 51
    sub-float/2addr p2, p4

    .line 52
    :goto_2
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    .line 53
    .line 54
    .line 55
    move-result p4

    .line 56
    int-to-float p4, p4

    .line 57
    int-to-float v0, v0

    .line 58
    const/high16 v1, 0x40000000    # 2.0f

    .line 59
    .line 60
    div-float v1, v0, v1

    .line 61
    .line 62
    sub-float/2addr p4, v1

    .line 63
    add-float v1, p2, v0

    .line 64
    .line 65
    add-float/2addr v0, p4

    .line 66
    invoke-virtual {v4, p2, p4, v1, v0}, Landroid/graphics/RectF;->set(FFFF)V

    .line 67
    .line 68
    .line 69
    goto :goto_3

    .line 70
    :cond_3
    invoke-virtual {v4}, Landroid/graphics/RectF;->setEmpty()V

    .line 71
    .line 72
    .line 73
    :goto_3
    invoke-virtual {v4}, Landroid/graphics/RectF;->isEmpty()Z

    .line 74
    .line 75
    .line 76
    move-result p2

    .line 77
    if-nez p2, :cond_5

    .line 78
    .line 79
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 80
    .line 81
    .line 82
    move-result p2

    .line 83
    if-eqz p2, :cond_4

    .line 84
    .line 85
    iget-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 86
    .line 87
    invoke-virtual {p2, v4}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 88
    .line 89
    .line 90
    :cond_4
    iget-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->iconRect:Landroid/graphics/Rect;

    .line 91
    .line 92
    invoke-virtual {v4, p2}, Landroid/graphics/RectF;->round(Landroid/graphics/Rect;)V

    .line 93
    .line 94
    .line 95
    invoke-virtual {p3, p2}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 96
    .line 97
    .line 98
    invoke-virtual {p3, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 99
    .line 100
    .line 101
    :cond_5
    return-void
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
.end method

.method public final calculateTrackCenter()I
    .locals 4

    .line 1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->widgetThickness:I

    .line 2
    .line 3
    div-int/lit8 v0, v0, 0x2

    .line 4
    .line 5
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->labelBehavior:I

    .line 6
    .line 7
    const/4 v2, 0x1

    .line 8
    const/4 v3, 0x0

    .line 9
    if-eq v1, v2, :cond_0

    .line 10
    .line 11
    const/4 v2, 0x3

    .line 12
    if-ne v1, v2, :cond_1

    .line 13
    .line 14
    :cond_0
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 15
    .line 16
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    check-cast v1, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 21
    .line 22
    invoke-virtual {v1}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicHeight()I

    .line 23
    .line 24
    .line 25
    move-result v3

    .line 26
    :cond_1
    add-int/2addr v0, v3

    .line 27
    return v0
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

.method public final createLabelAnimator(Z)Landroid/animation/ValueAnimator;
    .locals 5

    .line 1
    const/high16 v0, 0x3f800000    # 1.0f

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz p1, :cond_0

    .line 5
    .line 6
    const/4 v2, 0x0

    .line 7
    goto :goto_0

    .line 8
    :cond_0
    const/high16 v2, 0x3f800000    # 1.0f

    .line 9
    .line 10
    :goto_0
    if-eqz p1, :cond_1

    .line 11
    .line 12
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->labelsOutAnimator:Landroid/animation/ValueAnimator;

    .line 13
    .line 14
    goto :goto_1

    .line 15
    :cond_1
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->labelsInAnimator:Landroid/animation/ValueAnimator;

    .line 16
    .line 17
    :goto_1
    if-eqz v3, :cond_2

    .line 18
    .line 19
    invoke-virtual {v3}, Landroid/animation/ValueAnimator;->isRunning()Z

    .line 20
    .line 21
    .line 22
    move-result v4

    .line 23
    if-eqz v4, :cond_2

    .line 24
    .line 25
    invoke-virtual {v3}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    .line 26
    .line 27
    .line 28
    move-result-object v2

    .line 29
    check-cast v2, Ljava/lang/Float;

    .line 30
    .line 31
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    .line 32
    .line 33
    .line 34
    move-result v2

    .line 35
    invoke-virtual {v3}, Landroid/animation/ValueAnimator;->cancel()V

    .line 36
    .line 37
    .line 38
    :cond_2
    if-eqz p1, :cond_3

    .line 39
    .line 40
    goto :goto_2

    .line 41
    :cond_3
    const/4 v0, 0x0

    .line 42
    :goto_2
    const/4 v1, 0x2

    .line 43
    new-array v1, v1, [F

    .line 44
    .line 45
    const/4 v3, 0x0

    .line 46
    aput v2, v1, v3

    .line 47
    .line 48
    const/4 v2, 0x1

    .line 49
    aput v0, v1, v2

    .line 50
    .line 51
    invoke-static {v1}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    if-eqz p1, :cond_4

    .line 56
    .line 57
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 58
    .line 59
    .line 60
    move-result-object p1

    .line 61
    const v1, 0x7f0403b1

    .line 62
    .line 63
    .line 64
    const/16 v2, 0x53

    .line 65
    .line 66
    invoke-static {p1, v1, v2}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeDuration(Landroid/content/Context;II)I

    .line 67
    .line 68
    .line 69
    move-result p1

    .line 70
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 71
    .line 72
    .line 73
    move-result-object v1

    .line 74
    const v2, 0x7f0403bb

    .line 75
    .line 76
    .line 77
    sget-object v3, Lcom/google/android/material/animation/AnimationUtils;->DECELERATE_INTERPOLATOR:Landroid/view/animation/DecelerateInterpolator;

    .line 78
    .line 79
    invoke-static {v1, v2, v3}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeInterpolator(Landroid/content/Context;ILandroid/animation/TimeInterpolator;)Landroid/animation/TimeInterpolator;

    .line 80
    .line 81
    .line 82
    move-result-object v1

    .line 83
    goto :goto_3

    .line 84
    :cond_4
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 85
    .line 86
    .line 87
    move-result-object p1

    .line 88
    const v1, 0x7f0403b4

    .line 89
    .line 90
    .line 91
    const/16 v2, 0x75

    .line 92
    .line 93
    invoke-static {p1, v1, v2}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeDuration(Landroid/content/Context;II)I

    .line 94
    .line 95
    .line 96
    move-result p1

    .line 97
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 98
    .line 99
    .line 100
    move-result-object v1

    .line 101
    const v2, 0x7f0403b9

    .line 102
    .line 103
    .line 104
    sget-object v3, Lcom/google/android/material/animation/AnimationUtils;->FAST_OUT_LINEAR_IN_INTERPOLATOR:Landroidx/interpolator/view/animation/FastOutSlowInInterpolator;

    .line 105
    .line 106
    invoke-static {v1, v2, v3}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeInterpolator(Landroid/content/Context;ILandroid/animation/TimeInterpolator;)Landroid/animation/TimeInterpolator;

    .line 107
    .line 108
    .line 109
    move-result-object v1

    .line 110
    :goto_3
    int-to-long v2, p1

    .line 111
    invoke-virtual {v0, v2, v3}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 112
    .line 113
    .line 114
    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 115
    .line 116
    .line 117
    new-instance p1, Landroidx/core/view/ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;

    .line 118
    .line 119
    const/4 v1, 0x3

    .line 120
    invoke-direct {p1, v1, p0}, Landroidx/core/view/ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 121
    .line 122
    .line 123
    invoke-virtual {v0, p1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 124
    .line 125
    .line 126
    return-object v0
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

.method public final dispatchHoverEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityHelper:Lcom/google/android/material/slider/BaseSlider$AccessibilityHelper;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Landroidx/customview/widget/ExploreByTouchHelper;->dispatchHoverEvent(Landroid/view/MotionEvent;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_1

    .line 8
    .line 9
    invoke-super {p0, p1}, Landroid/view/View;->dispatchHoverEvent(Landroid/view/MotionEvent;)Z

    .line 10
    .line 11
    .line 12
    move-result p1

    .line 13
    if-eqz p1, :cond_0

    .line 14
    .line 15
    goto :goto_0

    .line 16
    :cond_0
    const/4 p1, 0x0

    .line 17
    return p1

    .line 18
    :cond_1
    :goto_0
    const/4 p1, 0x1

    .line 19
    return p1
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

.method public final drawInactiveTrackSection(FFFFLandroid/graphics/Canvas;Landroid/graphics/RectF;I)V
    .locals 3

    .line 1
    sub-float v0, p2, p1

    .line 2
    .line 3
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->getTrackCornerSize()I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 8
    .line 9
    sub-int/2addr v1, v2

    .line 10
    int-to-float v1, v1

    .line 11
    cmpl-float v0, v0, v1

    .line 12
    .line 13
    if-lez v0, :cond_0

    .line 14
    .line 15
    invoke-virtual {p6, p1, p3, p2, p4}, Landroid/graphics/RectF;->set(FFFF)V

    .line 16
    .line 17
    .line 18
    goto :goto_0

    .line 19
    :cond_0
    invoke-virtual {p6}, Landroid/graphics/RectF;->setEmpty()V

    .line 20
    .line 21
    .line 22
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->getTrackCornerSize()I

    .line 23
    .line 24
    .line 25
    move-result p1

    .line 26
    int-to-float p1, p1

    .line 27
    iget-object p4, p0, Lcom/google/android/material/slider/BaseSlider;->inactiveTrackPaint:Landroid/graphics/Paint;

    .line 28
    .line 29
    move-object p2, p0

    .line 30
    move-object p3, p5

    .line 31
    move-object p5, p6

    .line 32
    move p6, p1

    .line 33
    invoke-virtual/range {p2 .. p7}, Lcom/google/android/material/slider/BaseSlider;->updateTrack(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/RectF;FI)V

    .line 34
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
.end method

.method public final drawStopIndicator(Landroid/graphics/Canvas;FF)V
    .locals 7

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    const/4 v2, 0x0

    .line 8
    :cond_0
    if-ge v2, v1, :cond_1

    .line 9
    .line 10
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 11
    .line 12
    .line 13
    move-result-object v3

    .line 14
    add-int/lit8 v2, v2, 0x1

    .line 15
    .line 16
    check-cast v3, Ljava/lang/Float;

    .line 17
    .line 18
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    .line 19
    .line 20
    .line 21
    move-result v3

    .line 22
    invoke-virtual {p0, v3}, Lcom/google/android/material/slider/BaseSlider;->valueToX(F)F

    .line 23
    .line 24
    .line 25
    move-result v3

    .line 26
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 27
    .line 28
    int-to-float v4, v4

    .line 29
    iget v5, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 30
    .line 31
    int-to-float v5, v5

    .line 32
    const/high16 v6, 0x40000000    # 2.0f

    .line 33
    .line 34
    div-float/2addr v5, v6

    .line 35
    add-float/2addr v5, v4

    .line 36
    sub-float v4, v3, v5

    .line 37
    .line 38
    cmpl-float v4, p2, v4

    .line 39
    .line 40
    if-ltz v4, :cond_0

    .line 41
    .line 42
    add-float/2addr v3, v5

    .line 43
    cmpg-float v3, p2, v3

    .line 44
    .line 45
    if-gtz v3, :cond_0

    .line 46
    .line 47
    return-void

    .line 48
    :cond_1
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 49
    .line 50
    .line 51
    move-result v0

    .line 52
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->stopIndicatorPaint:Landroid/graphics/Paint;

    .line 53
    .line 54
    if-eqz v0, :cond_2

    .line 55
    .line 56
    invoke-virtual {p1, p3, p2, v1}, Landroid/graphics/Canvas;->drawPoint(FFLandroid/graphics/Paint;)V

    .line 57
    .line 58
    .line 59
    return-void

    .line 60
    :cond_2
    invoke-virtual {p1, p2, p3, v1}, Landroid/graphics/Canvas;->drawPoint(FFLandroid/graphics/Paint;)V

    .line 61
    .line 62
    .line 63
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
.end method

.method public final drawThumbDrawable(Landroid/graphics/Canvas;IIFLandroid/graphics/drawable/Drawable;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 11
    .line 12
    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->concat(Landroid/graphics/Matrix;)V

    .line 13
    .line 14
    .line 15
    :cond_0
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 16
    .line 17
    invoke-virtual {p0, p4}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 18
    .line 19
    .line 20
    move-result p4

    .line 21
    int-to-float p2, p2

    .line 22
    mul-float p4, p4, p2

    .line 23
    .line 24
    float-to-int p2, p4

    .line 25
    add-int/2addr v0, p2

    .line 26
    int-to-float p2, v0

    .line 27
    invoke-virtual {p5}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    .line 28
    .line 29
    .line 30
    move-result-object p4

    .line 31
    invoke-virtual {p4}, Landroid/graphics/Rect;->width()I

    .line 32
    .line 33
    .line 34
    move-result p4

    .line 35
    int-to-float p4, p4

    .line 36
    const/high16 v0, 0x40000000    # 2.0f

    .line 37
    .line 38
    div-float/2addr p4, v0

    .line 39
    sub-float/2addr p2, p4

    .line 40
    int-to-float p3, p3

    .line 41
    invoke-virtual {p5}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    .line 42
    .line 43
    .line 44
    move-result-object p4

    .line 45
    invoke-virtual {p4}, Landroid/graphics/Rect;->height()I

    .line 46
    .line 47
    .line 48
    move-result p4

    .line 49
    int-to-float p4, p4

    .line 50
    div-float/2addr p4, v0

    .line 51
    sub-float/2addr p3, p4

    .line 52
    invoke-virtual {p1, p2, p3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 53
    .line 54
    .line 55
    invoke-virtual {p5, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 56
    .line 57
    .line 58
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 59
    .line 60
    .line 61
    return-void
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

.method public final drawTicks(IILandroid/graphics/Canvas;Landroid/graphics/Paint;)V
    .locals 5

    .line 1
    :goto_0
    if-ge p1, p2, :cond_3

    .line 2
    .line 3
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    .line 10
    .line 11
    add-int/lit8 v1, p1, 0x1

    .line 12
    .line 13
    aget v0, v0, v1

    .line 14
    .line 15
    goto :goto_1

    .line 16
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    .line 17
    .line 18
    aget v0, v0, p1

    .line 19
    .line 20
    :goto_1
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 21
    .line 22
    int-to-float v1, v1

    .line 23
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 24
    .line 25
    int-to-float v2, v2

    .line 26
    const/high16 v3, 0x40000000    # 2.0f

    .line 27
    .line 28
    div-float/2addr v2, v3

    .line 29
    add-float/2addr v2, v1

    .line 30
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 31
    .line 32
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 33
    .line 34
    .line 35
    move-result-object v1

    .line 36
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    .line 37
    .line 38
    .line 39
    move-result v4

    .line 40
    if-eqz v4, :cond_1

    .line 41
    .line 42
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 43
    .line 44
    .line 45
    move-result-object v1

    .line 46
    check-cast v1, Ljava/lang/Float;

    .line 47
    .line 48
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    .line 49
    .line 50
    .line 51
    move-result v1

    .line 52
    invoke-virtual {p0, v1}, Lcom/google/android/material/slider/BaseSlider;->valueToX(F)F

    .line 53
    .line 54
    .line 55
    move-result v1

    .line 56
    sub-float v4, v1, v2

    .line 57
    .line 58
    cmpl-float v4, v0, v4

    .line 59
    .line 60
    if-ltz v4, :cond_1

    .line 61
    .line 62
    add-float/2addr v1, v2

    .line 63
    cmpg-float v1, v0, v1

    .line 64
    .line 65
    if-gtz v1, :cond_1

    .line 66
    .line 67
    goto :goto_2

    .line 68
    :cond_1
    iget-boolean v1, p0, Lcom/google/android/material/slider/BaseSlider;->centered:Z

    .line 69
    .line 70
    if-eqz v1, :cond_2

    .line 71
    .line 72
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 73
    .line 74
    int-to-float v1, v1

    .line 75
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 76
    .line 77
    int-to-float v2, v2

    .line 78
    div-float/2addr v2, v3

    .line 79
    add-float/2addr v2, v1

    .line 80
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 81
    .line 82
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 83
    .line 84
    mul-int/lit8 v4, v4, 0x2

    .line 85
    .line 86
    add-int/2addr v4, v1

    .line 87
    int-to-float v1, v4

    .line 88
    div-float/2addr v1, v3

    .line 89
    sub-float v3, v1, v2

    .line 90
    .line 91
    cmpl-float v3, v0, v3

    .line 92
    .line 93
    if-ltz v3, :cond_2

    .line 94
    .line 95
    add-float/2addr v1, v2

    .line 96
    cmpg-float v0, v0, v1

    .line 97
    .line 98
    if-gtz v0, :cond_2

    .line 99
    .line 100
    goto :goto_2

    .line 101
    :cond_2
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    .line 102
    .line 103
    aget v1, v0, p1

    .line 104
    .line 105
    add-int/lit8 v2, p1, 0x1

    .line 106
    .line 107
    aget v0, v0, v2

    .line 108
    .line 109
    invoke-virtual {p3, v1, v0, p4}, Landroid/graphics/Canvas;->drawPoint(FFLandroid/graphics/Paint;)V

    .line 110
    .line 111
    .line 112
    :goto_2
    add-int/lit8 p1, p1, 0x2

    .line 113
    .line 114
    goto :goto_0

    .line 115
    :cond_3
    return-void
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
.end method

.method public final drawTrackIcons(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/RectF;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStart:Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    if-nez v0, :cond_1

    .line 4
    .line 5
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEnd:Landroid/graphics/drawable/Drawable;

    .line 6
    .line 7
    if-nez v0, :cond_1

    .line 8
    .line 9
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStart:Landroid/graphics/drawable/Drawable;

    .line 10
    .line 11
    if-nez v0, :cond_1

    .line 12
    .line 13
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEnd:Landroid/graphics/drawable/Drawable;

    .line 14
    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    goto :goto_0

    .line 18
    :cond_0
    return-void

    .line 19
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 20
    .line 21
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 22
    .line 23
    .line 24
    move-result v0

    .line 25
    const/4 v1, 0x1

    .line 26
    if-le v0, v1, :cond_2

    .line 27
    .line 28
    const-string v0, "BaseSlider"

    .line 29
    .line 30
    const-string v2, "Track icons can only be used when only 1 thumb is present."

    .line 31
    .line 32
    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 33
    .line 34
    .line 35
    :cond_2
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStart:Landroid/graphics/drawable/Drawable;

    .line 36
    .line 37
    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/google/android/material/slider/BaseSlider;->calculateBoundsAndDrawTrackIcon(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/drawable/Drawable;Z)V

    .line 38
    .line 39
    .line 40
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStart:Landroid/graphics/drawable/Drawable;

    .line 41
    .line 42
    invoke-virtual {p0, p1, p3, v0, v1}, Lcom/google/android/material/slider/BaseSlider;->calculateBoundsAndDrawTrackIcon(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/drawable/Drawable;Z)V

    .line 43
    .line 44
    .line 45
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEnd:Landroid/graphics/drawable/Drawable;

    .line 46
    .line 47
    const/4 v1, 0x0

    .line 48
    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/google/android/material/slider/BaseSlider;->calculateBoundsAndDrawTrackIcon(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/drawable/Drawable;Z)V

    .line 49
    .line 50
    .line 51
    iget-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEnd:Landroid/graphics/drawable/Drawable;

    .line 52
    .line 53
    invoke-virtual {p0, p1, p3, p2, v1}, Lcom/google/android/material/slider/BaseSlider;->calculateBoundsAndDrawTrackIcon(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/drawable/Drawable;Z)V

    .line 54
    .line 55
    .line 56
    return-void
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

.method public final drawableStateChanged()V
    .locals 5

    .line 1
    invoke-super {p0}, Landroid/view/View;->drawableStateChanged()V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackColorInactive:Landroid/content/res/ColorStateList;

    .line 5
    .line 6
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->getColorForState(Landroid/content/res/ColorStateList;)I

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->inactiveTrackPaint:Landroid/graphics/Paint;

    .line 11
    .line 12
    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 13
    .line 14
    .line 15
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackColorActive:Landroid/content/res/ColorStateList;

    .line 16
    .line 17
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->getColorForState(Landroid/content/res/ColorStateList;)I

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->activeTrackPaint:Landroid/graphics/Paint;

    .line 22
    .line 23
    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 24
    .line 25
    .line 26
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->tickColorInactive:Landroid/content/res/ColorStateList;

    .line 27
    .line 28
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->getColorForState(Landroid/content/res/ColorStateList;)I

    .line 29
    .line 30
    .line 31
    move-result v0

    .line 32
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->inactiveTicksPaint:Landroid/graphics/Paint;

    .line 33
    .line 34
    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 35
    .line 36
    .line 37
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->tickColorActive:Landroid/content/res/ColorStateList;

    .line 38
    .line 39
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->getColorForState(Landroid/content/res/ColorStateList;)I

    .line 40
    .line 41
    .line 42
    move-result v0

    .line 43
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->activeTicksPaint:Landroid/graphics/Paint;

    .line 44
    .line 45
    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 46
    .line 47
    .line 48
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->tickColorInactive:Landroid/content/res/ColorStateList;

    .line 49
    .line 50
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->getColorForState(Landroid/content/res/ColorStateList;)I

    .line 51
    .line 52
    .line 53
    move-result v0

    .line 54
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->stopIndicatorPaint:Landroid/graphics/Paint;

    .line 55
    .line 56
    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 57
    .line 58
    .line 59
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 60
    .line 61
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 62
    .line 63
    .line 64
    move-result v1

    .line 65
    const/4 v2, 0x0

    .line 66
    :cond_0
    :goto_0
    if-ge v2, v1, :cond_1

    .line 67
    .line 68
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 69
    .line 70
    .line 71
    move-result-object v3

    .line 72
    add-int/lit8 v2, v2, 0x1

    .line 73
    .line 74
    check-cast v3, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 75
    .line 76
    invoke-virtual {v3}, Lcom/google/android/material/shape/MaterialShapeDrawable;->isStateful()Z

    .line 77
    .line 78
    .line 79
    move-result v4

    .line 80
    if-eqz v4, :cond_0

    .line 81
    .line 82
    invoke-virtual {p0}, Landroid/view/View;->getDrawableState()[I

    .line 83
    .line 84
    .line 85
    move-result-object v4

    .line 86
    invoke-virtual {v3, v4}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 87
    .line 88
    .line 89
    goto :goto_0

    .line 90
    :cond_1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 91
    .line 92
    invoke-virtual {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->isStateful()Z

    .line 93
    .line 94
    .line 95
    move-result v1

    .line 96
    if-eqz v1, :cond_2

    .line 97
    .line 98
    invoke-virtual {p0}, Landroid/view/View;->getDrawableState()[I

    .line 99
    .line 100
    .line 101
    move-result-object v1

    .line 102
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 103
    .line 104
    .line 105
    :cond_2
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->haloColor:Landroid/content/res/ColorStateList;

    .line 106
    .line 107
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->getColorForState(Landroid/content/res/ColorStateList;)I

    .line 108
    .line 109
    .line 110
    move-result v0

    .line 111
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->haloPaint:Landroid/graphics/Paint;

    .line 112
    .line 113
    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 114
    .line 115
    .line 116
    const/16 v0, 0x3f

    .line 117
    .line 118
    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setAlpha(I)V

    .line 119
    .line 120
    .line 121
    return-void
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

.method public final ensureLabelsAdded()V
    .locals 7

    .line 1
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelsAreAnimatedIn:Z

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    if-nez v0, :cond_0

    .line 5
    .line 6
    iput-boolean v1, p0, Lcom/google/android/material/slider/BaseSlider;->labelsAreAnimatedIn:Z

    .line 7
    .line 8
    invoke-virtual {p0, v1}, Lcom/google/android/material/slider/BaseSlider;->createLabelAnimator(Z)Landroid/animation/ValueAnimator;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelsInAnimator:Landroid/animation/ValueAnimator;

    .line 13
    .line 14
    const/4 v2, 0x0

    .line 15
    iput-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->labelsOutAnimator:Landroid/animation/ValueAnimator;

    .line 16
    .line 17
    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 18
    .line 19
    .line 20
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 21
    .line 22
    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 23
    .line 24
    .line 25
    move-result-object v2

    .line 26
    const/4 v3, 0x0

    .line 27
    const/4 v4, 0x0

    .line 28
    :goto_0
    iget-object v5, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 29
    .line 30
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    .line 31
    .line 32
    .line 33
    move-result v5

    .line 34
    if-ge v4, v5, :cond_2

    .line 35
    .line 36
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 37
    .line 38
    .line 39
    move-result v5

    .line 40
    if-eqz v5, :cond_2

    .line 41
    .line 42
    iget v5, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 43
    .line 44
    if-ne v4, v5, :cond_1

    .line 45
    .line 46
    goto :goto_1

    .line 47
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 48
    .line 49
    .line 50
    move-result-object v5

    .line 51
    check-cast v5, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 52
    .line 53
    iget-object v6, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 54
    .line 55
    invoke-virtual {v6, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 56
    .line 57
    .line 58
    move-result-object v6

    .line 59
    check-cast v6, Ljava/lang/Float;

    .line 60
    .line 61
    invoke-virtual {v6}, Ljava/lang/Float;->floatValue()F

    .line 62
    .line 63
    .line 64
    move-result v6

    .line 65
    invoke-virtual {p0, v5, v6}, Lcom/google/android/material/slider/BaseSlider;->setValueForLabel(Lcom/google/android/material/tooltip/TooltipDrawable;F)V

    .line 66
    .line 67
    .line 68
    :goto_1
    add-int/lit8 v4, v4, 0x1

    .line 69
    .line 70
    goto :goto_0

    .line 71
    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 72
    .line 73
    .line 74
    move-result v4

    .line 75
    if-eqz v4, :cond_3

    .line 76
    .line 77
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 78
    .line 79
    .line 80
    move-result-object v0

    .line 81
    check-cast v0, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 82
    .line 83
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 84
    .line 85
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 86
    .line 87
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 88
    .line 89
    .line 90
    move-result-object v1

    .line 91
    check-cast v1, Ljava/lang/Float;

    .line 92
    .line 93
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    .line 94
    .line 95
    .line 96
    move-result v1

    .line 97
    invoke-virtual {p0, v0, v1}, Lcom/google/android/material/slider/BaseSlider;->setValueForLabel(Lcom/google/android/material/tooltip/TooltipDrawable;F)V

    .line 98
    .line 99
    .line 100
    return-void

    .line 101
    :cond_3
    new-instance v2, Ljava/lang/IllegalStateException;

    .line 102
    .line 103
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 104
    .line 105
    .line 106
    move-result v0

    .line 107
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 108
    .line 109
    .line 110
    move-result-object v0

    .line 111
    iget-object v4, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 112
    .line 113
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    .line 114
    .line 115
    .line 116
    move-result v4

    .line 117
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 118
    .line 119
    .line 120
    move-result-object v4

    .line 121
    const/4 v5, 0x2

    .line 122
    new-array v5, v5, [Ljava/lang/Object;

    .line 123
    .line 124
    aput-object v0, v5, v3

    .line 125
    .line 126
    aput-object v4, v5, v1

    .line 127
    .line 128
    const-string v0, "Not enough labels(%d) to display all the values(%d)"

    .line 129
    .line 130
    invoke-static {v0, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 131
    .line 132
    .line 133
    move-result-object v0

    .line 134
    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 135
    .line 136
    .line 137
    throw v2
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

.method public final ensureLabelsRemoved()V
    .locals 3

    .line 1
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelsAreAnimatedIn:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x0

    .line 6
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelsAreAnimatedIn:Z

    .line 7
    .line 8
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->createLabelAnimator(Z)Landroid/animation/ValueAnimator;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelsOutAnimator:Landroid/animation/ValueAnimator;

    .line 13
    .line 14
    const/4 v1, 0x0

    .line 15
    iput-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->labelsInAnimator:Landroid/animation/ValueAnimator;

    .line 16
    .line 17
    new-instance v1, Landroidx/transition/Transition$3;

    .line 18
    .line 19
    const/16 v2, 0x9

    .line 20
    .line 21
    invoke-direct {v1, v2, p0}, Landroidx/transition/Transition$3;-><init>(ILjava/lang/Object;)V

    .line 22
    .line 23
    .line 24
    invoke-virtual {v0, v1}, Landroid/animation/Animator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 25
    .line 26
    .line 27
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelsOutAnimator:Landroid/animation/ValueAnimator;

    .line 28
    .line 29
    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 30
    .line 31
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

.method public final formatValue(F)Ljava/lang/String;
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->formatter:Lcom/google/android/material/slider/LabelFormatter;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-interface {v0, p1}, Lcom/google/android/material/slider/LabelFormatter;->getFormattedValue(F)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    return-object p1

    .line 10
    :cond_0
    float-to-int v0, p1

    .line 11
    int-to-float v0, v0

    .line 12
    cmpl-float v0, v0, p1

    .line 13
    .line 14
    if-nez v0, :cond_1

    .line 15
    .line 16
    const-string v0, "%.0f"

    .line 17
    .line 18
    goto :goto_0

    .line 19
    :cond_1
    const-string v0, "%.2f"

    .line 20
    .line 21
    :goto_0
    invoke-static {p1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 22
    .line 23
    .line 24
    move-result-object p1

    .line 25
    const/4 v1, 0x1

    .line 26
    new-array v1, v1, [Ljava/lang/Object;

    .line 27
    .line 28
    const/4 v2, 0x0

    .line 29
    aput-object p1, v1, v2

    .line 30
    .line 31
    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 32
    .line 33
    .line 34
    move-result-object p1

    .line 35
    return-object p1
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

.method public final getAccessibilityFocusedVirtualViewId()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityHelper:Lcom/google/android/material/slider/BaseSlider$AccessibilityHelper;

    .line 2
    .line 3
    iget v0, v0, Landroidx/customview/widget/ExploreByTouchHelper;->mAccessibilityFocusedVirtualViewId:I

    .line 4
    .line 5
    return v0
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

.method public final getActiveRange()[F
    .locals 6

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    check-cast v0, Ljava/lang/Float;

    .line 9
    .line 10
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    .line 11
    .line 12
    .line 13
    move-result v0

    .line 14
    iget-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 15
    .line 16
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 17
    .line 18
    .line 19
    move-result v3

    .line 20
    const/4 v4, 0x1

    .line 21
    sub-int/2addr v3, v4

    .line 22
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 23
    .line 24
    .line 25
    move-result-object v2

    .line 26
    check-cast v2, Ljava/lang/Float;

    .line 27
    .line 28
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    .line 29
    .line 30
    .line 31
    move-result v2

    .line 32
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 33
    .line 34
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 35
    .line 36
    .line 37
    move-result v3

    .line 38
    if-ne v3, v4, :cond_0

    .line 39
    .line 40
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 41
    .line 42
    :cond_0
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 43
    .line 44
    .line 45
    move-result v0

    .line 46
    invoke-virtual {p0, v2}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 47
    .line 48
    .line 49
    move-result v2

    .line 50
    iget-boolean v3, p0, Lcom/google/android/material/slider/BaseSlider;->centered:Z

    .line 51
    .line 52
    if-eqz v3, :cond_1

    .line 53
    .line 54
    const/high16 v0, 0x3f000000    # 0.5f

    .line 55
    .line 56
    invoke-static {v0, v2}, Ljava/lang/Math;->min(FF)F

    .line 57
    .line 58
    .line 59
    move-result v3

    .line 60
    invoke-static {v0, v2}, Ljava/lang/Math;->max(FF)F

    .line 61
    .line 62
    .line 63
    move-result v2

    .line 64
    move v0, v3

    .line 65
    :cond_1
    iget-boolean v3, p0, Lcom/google/android/material/slider/BaseSlider;->centered:Z

    .line 66
    .line 67
    const/4 v5, 0x2

    .line 68
    if-nez v3, :cond_3

    .line 69
    .line 70
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 71
    .line 72
    .line 73
    move-result v3

    .line 74
    if-nez v3, :cond_2

    .line 75
    .line 76
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 77
    .line 78
    .line 79
    move-result v3

    .line 80
    if-eqz v3, :cond_3

    .line 81
    .line 82
    :cond_2
    new-array v3, v5, [F

    .line 83
    .line 84
    aput v2, v3, v1

    .line 85
    .line 86
    aput v0, v3, v4

    .line 87
    .line 88
    return-object v3

    .line 89
    :cond_3
    new-array v3, v5, [F

    .line 90
    .line 91
    aput v0, v3, v1

    .line 92
    .line 93
    aput v2, v3, v4

    .line 94
    .line 95
    return-object v3
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

.method public final getColorForState(Landroid/content/res/ColorStateList;)I
    .locals 2

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->getDrawableState()[I

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {p1}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    invoke-virtual {p1, v0, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    .line 10
    .line 11
    .line 12
    move-result p1

    .line 13
    return p1
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

.method public getMinSeparation()F
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public abstract getThumbRadius()I
.end method

.method public abstract getTrackCornerSize()I
.end method

.method public getValues()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation

    .line 1
    new-instance v0, Ljava/util/ArrayList;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 6
    .line 7
    .line 8
    return-object v0
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

.method public final isMultipleOfStepSize(D)Z
    .locals 3

    .line 1
    new-instance v0, Ljava/math/BigDecimal;

    .line 2
    .line 3
    invoke-static {p1, p2}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    invoke-direct {v0, p1}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 8
    .line 9
    .line 10
    new-instance p1, Ljava/math/BigDecimal;

    .line 11
    .line 12
    iget p2, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 13
    .line 14
    invoke-static {p2}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object p2

    .line 18
    invoke-direct {p1, p2}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 19
    .line 20
    .line 21
    sget-object p2, Ljava/math/MathContext;->DECIMAL64:Ljava/math/MathContext;

    .line 22
    .line 23
    invoke-virtual {v0, p1, p2}, Ljava/math/BigDecimal;->divide(Ljava/math/BigDecimal;Ljava/math/MathContext;)Ljava/math/BigDecimal;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    invoke-virtual {p1}, Ljava/math/BigDecimal;->doubleValue()D

    .line 28
    .line 29
    .line 30
    move-result-wide p1

    .line 31
    invoke-static {p1, p2}, Ljava/lang/Math;->round(D)J

    .line 32
    .line 33
    .line 34
    move-result-wide v0

    .line 35
    long-to-double v0, v0

    .line 36
    sub-double/2addr v0, p1

    .line 37
    invoke-static {v0, v1}, Ljava/lang/Math;->abs(D)D

    .line 38
    .line 39
    .line 40
    move-result-wide p1

    .line 41
    const-wide v0, 0x3f1a36e2eb1c432dL    # 1.0E-4

    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    cmpg-double v2, p1, v0

    .line 47
    .line 48
    if-gez v2, :cond_0

    .line 49
    .line 50
    const/4 p1, 0x1

    .line 51
    return p1

    .line 52
    :cond_0
    const/4 p1, 0x0

    .line 53
    return p1
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public final isPotentialHorizontalScroll(Landroid/view/MotionEvent;)Z
    .locals 4

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getToolType(I)I

    .line 3
    .line 4
    .line 5
    move-result p1

    .line 6
    const/4 v1, 0x3

    .line 7
    if-ne p1, v1, :cond_0

    .line 8
    .line 9
    goto :goto_1

    .line 10
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    :goto_0
    instance-of v1, p1, Landroid/view/ViewGroup;

    .line 15
    .line 16
    if-eqz v1, :cond_3

    .line 17
    .line 18
    move-object v1, p1

    .line 19
    check-cast v1, Landroid/view/ViewGroup;

    .line 20
    .line 21
    const/4 v2, 0x1

    .line 22
    invoke-virtual {v1, v2}, Landroid/view/View;->canScrollHorizontally(I)Z

    .line 23
    .line 24
    .line 25
    move-result v3

    .line 26
    if-nez v3, :cond_1

    .line 27
    .line 28
    const/4 v3, -0x1

    .line 29
    invoke-virtual {v1, v3}, Landroid/view/View;->canScrollHorizontally(I)Z

    .line 30
    .line 31
    .line 32
    move-result v3

    .line 33
    if-eqz v3, :cond_2

    .line 34
    .line 35
    :cond_1
    invoke-virtual {v1}, Landroid/view/ViewGroup;->shouldDelayChildPressedState()Z

    .line 36
    .line 37
    .line 38
    move-result v1

    .line 39
    if-eqz v1, :cond_2

    .line 40
    .line 41
    return v2

    .line 42
    :cond_2
    invoke-interface {p1}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    .line 43
    .line 44
    .line 45
    move-result-object p1

    .line 46
    goto :goto_0

    .line 47
    :cond_3
    :goto_1
    return v0
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

.method public final isPotentialVerticalScroll(Landroid/view/MotionEvent;)Z
    .locals 4

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-virtual {p1, v0}, Landroid/view/MotionEvent;->getToolType(I)I

    .line 3
    .line 4
    .line 5
    move-result p1

    .line 6
    const/4 v1, 0x3

    .line 7
    if-ne p1, v1, :cond_0

    .line 8
    .line 9
    goto :goto_1

    .line 10
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    :goto_0
    instance-of v1, p1, Landroid/view/ViewGroup;

    .line 15
    .line 16
    if-eqz v1, :cond_3

    .line 17
    .line 18
    move-object v1, p1

    .line 19
    check-cast v1, Landroid/view/ViewGroup;

    .line 20
    .line 21
    const/4 v2, 0x1

    .line 22
    invoke-virtual {v1, v2}, Landroid/view/View;->canScrollVertically(I)Z

    .line 23
    .line 24
    .line 25
    move-result v3

    .line 26
    if-nez v3, :cond_1

    .line 27
    .line 28
    const/4 v3, -0x1

    .line 29
    invoke-virtual {v1, v3}, Landroid/view/View;->canScrollVertically(I)Z

    .line 30
    .line 31
    .line 32
    move-result v3

    .line 33
    if-eqz v3, :cond_2

    .line 34
    .line 35
    :cond_1
    invoke-virtual {v1}, Landroid/view/ViewGroup;->shouldDelayChildPressedState()Z

    .line 36
    .line 37
    .line 38
    move-result v1

    .line 39
    if-eqz v1, :cond_2

    .line 40
    .line 41
    return v2

    .line 42
    :cond_2
    invoke-interface {p1}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    .line 43
    .line 44
    .line 45
    move-result-object p1

    .line 46
    goto :goto_0

    .line 47
    :cond_3
    :goto_1
    return v0
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

.method public final isRtl()Z
    .locals 2

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->getLayoutDirection()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    const/4 v1, 0x1

    .line 6
    if-ne v0, v1, :cond_0

    .line 7
    .line 8
    return v1

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

.method public final isVertical()Z
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->widgetOrientation:I

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    if-ne v0, v1, :cond_0

    .line 5
    .line 6
    return v1

    .line 7
    :cond_0
    const/4 v0, 0x0

    .line 8
    return v0
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

.method public final moveFocus(I)Z
    .locals 8

    .line 1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 2
    .line 3
    int-to-long v1, v0

    .line 4
    int-to-long v3, p1

    .line 5
    add-long/2addr v1, v3

    .line 6
    iget-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 7
    .line 8
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 9
    .line 10
    .line 11
    move-result p1

    .line 12
    const/4 v3, 0x1

    .line 13
    sub-int/2addr p1, v3

    .line 14
    int-to-long v4, p1

    .line 15
    const-wide/16 v6, 0x0

    .line 16
    .line 17
    cmp-long p1, v1, v6

    .line 18
    .line 19
    if-gez p1, :cond_0

    .line 20
    .line 21
    move-wide v1, v6

    .line 22
    goto :goto_0

    .line 23
    :cond_0
    cmp-long p1, v1, v4

    .line 24
    .line 25
    if-lez p1, :cond_1

    .line 26
    .line 27
    move-wide v1, v4

    .line 28
    :cond_1
    :goto_0
    long-to-int p1, v1

    .line 29
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 30
    .line 31
    if-ne p1, v0, :cond_2

    .line 32
    .line 33
    const/4 p1, 0x0

    .line 34
    return p1

    .line 35
    :cond_2
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 36
    .line 37
    const/4 v1, -0x1

    .line 38
    if-eq v0, v1, :cond_3

    .line 39
    .line 40
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 41
    .line 42
    :cond_3
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateHaloHotspot()V

    .line 43
    .line 44
    .line 45
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    .line 46
    .line 47
    .line 48
    return v3
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

.method public final moveFocusInAbsoluteDirection(I)V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_2

    .line 12
    .line 13
    :cond_0
    const/high16 v0, -0x80000000

    .line 14
    .line 15
    if-ne p1, v0, :cond_1

    .line 16
    .line 17
    const p1, 0x7fffffff

    .line 18
    .line 19
    .line 20
    goto :goto_0

    .line 21
    :cond_1
    neg-int p1, p1

    .line 22
    :cond_2
    :goto_0
    invoke-virtual {p0, p1}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 23
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
.end method

.method public final normalizeValue(F)F
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 2
    .line 3
    sub-float/2addr p1, v0

    .line 4
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 5
    .line 6
    sub-float/2addr v1, v0

    .line 7
    div-float/2addr p1, v1

    .line 8
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 9
    .line 10
    .line 11
    move-result v0

    .line 12
    if-nez v0, :cond_1

    .line 13
    .line 14
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 15
    .line 16
    .line 17
    move-result v0

    .line 18
    if-eqz v0, :cond_0

    .line 19
    .line 20
    goto :goto_0

    .line 21
    :cond_0
    return p1

    .line 22
    :cond_1
    :goto_0
    const/high16 v0, 0x3f800000    # 1.0f

    .line 23
    .line 24
    sub-float/2addr v0, p1

    .line 25
    return v0
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

.method public final onAttachedToWindow()V
    .locals 7

    .line 1
    invoke-super {p0}, Landroid/view/View;->onAttachedToWindow()V

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0}, Landroid/view/View;->isShown()Z

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->thisAndAncestorsVisible:Z

    .line 9
    .line 10
    invoke-virtual {p0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->onScrollChangedListener:Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;

    .line 15
    .line 16
    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnScrollChangedListener(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V

    .line 17
    .line 18
    .line 19
    invoke-virtual {p0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->onGlobalLayoutListener:Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda2;

    .line 24
    .line 25
    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 26
    .line 27
    .line 28
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 29
    .line 30
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 31
    .line 32
    .line 33
    move-result v1

    .line 34
    const/4 v2, 0x0

    .line 35
    const/4 v3, 0x0

    .line 36
    :goto_0
    if-ge v3, v1, :cond_1

    .line 37
    .line 38
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 39
    .line 40
    .line 41
    move-result-object v4

    .line 42
    add-int/lit8 v3, v3, 0x1

    .line 43
    .line 44
    check-cast v4, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 45
    .line 46
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Lcom/google/android/material/slider/BaseSlider;)Landroid/view/ViewGroup;

    .line 47
    .line 48
    .line 49
    move-result-object v5

    .line 50
    if-nez v5, :cond_0

    .line 51
    .line 52
    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 53
    .line 54
    .line 55
    goto :goto_0

    .line 56
    :cond_0
    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 57
    .line 58
    .line 59
    const/4 v6, 0x2

    .line 60
    new-array v6, v6, [I

    .line 61
    .line 62
    invoke-virtual {v5, v6}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 63
    .line 64
    .line 65
    aget v6, v6, v2

    .line 66
    .line 67
    iput v6, v4, Lcom/google/android/material/tooltip/TooltipDrawable;->locationOnScreenX:I

    .line 68
    .line 69
    iget-object v6, v4, Lcom/google/android/material/tooltip/TooltipDrawable;->displayFrame:Landroid/graphics/Rect;

    .line 70
    .line 71
    invoke-virtual {v5, v6}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 72
    .line 73
    .line 74
    iget-object v4, v4, Lcom/google/android/material/tooltip/TooltipDrawable;->attachedViewLayoutChangeListener:Landroidx/appcompat/widget/SearchView$4;

    .line 75
    .line 76
    invoke-virtual {v5, v4}, Landroid/view/View;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 77
    .line 78
    .line 79
    goto :goto_0

    .line 80
    :cond_1
    return-void
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

.method public final onDetachedFromWindow()V
    .locals 6

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityEventSender:Landroidx/core/provider/CallbackWithHandler$2;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {p0, v0}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 6
    .line 7
    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelsAreAnimatedIn:Z

    .line 10
    .line 11
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 12
    .line 13
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 14
    .line 15
    .line 16
    move-result v2

    .line 17
    :goto_0
    if-ge v0, v2, :cond_2

    .line 18
    .line 19
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 20
    .line 21
    .line 22
    move-result-object v3

    .line 23
    add-int/lit8 v0, v0, 0x1

    .line 24
    .line 25
    check-cast v3, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 26
    .line 27
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Lcom/google/android/material/slider/BaseSlider;)Landroid/view/ViewGroup;

    .line 28
    .line 29
    .line 30
    move-result-object v4

    .line 31
    if-nez v4, :cond_1

    .line 32
    .line 33
    goto :goto_0

    .line 34
    :cond_1
    invoke-virtual {v4}, Landroid/view/View;->getOverlay()Landroid/view/ViewOverlay;

    .line 35
    .line 36
    .line 37
    move-result-object v5

    .line 38
    invoke-virtual {v5, v3}, Landroid/view/ViewOverlay;->remove(Landroid/graphics/drawable/Drawable;)V

    .line 39
    .line 40
    .line 41
    iget-object v3, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->attachedViewLayoutChangeListener:Landroidx/appcompat/widget/SearchView$4;

    .line 42
    .line 43
    invoke-virtual {v4, v3}, Landroid/view/View;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 44
    .line 45
    .line 46
    goto :goto_0

    .line 47
    :cond_2
    invoke-virtual {p0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    .line 48
    .line 49
    .line 50
    move-result-object v0

    .line 51
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->onScrollChangedListener:Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;

    .line 52
    .line 53
    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->removeOnScrollChangedListener(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V

    .line 54
    .line 55
    .line 56
    invoke-virtual {p0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    .line 57
    .line 58
    .line 59
    move-result-object v0

    .line 60
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->onGlobalLayoutListener:Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda2;

    .line 61
    .line 62
    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 63
    .line 64
    .line 65
    invoke-super {p0}, Landroid/view/View;->onDetachedFromWindow()V

    .line 66
    .line 67
    .line 68
    return-void
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

.method public final onDraw(Landroid/graphics/Canvas;)V
    .locals 19

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    iget-boolean v1, v0, Lcom/google/android/material/slider/BaseSlider;->dirtyConfig:Z

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->validateConfigurationIfDirty()V

    .line 8
    .line 9
    .line 10
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->updateTicksCoordinates()V

    .line 11
    .line 12
    .line 13
    :cond_0
    invoke-super/range {p0 .. p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 14
    .line 15
    .line 16
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    .line 17
    .line 18
    .line 19
    move-result v8

    .line 20
    iget v9, v0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 21
    .line 22
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->getActiveRange()[F

    .line 23
    .line 24
    .line 25
    move-result-object v10

    .line 26
    int-to-float v11, v8

    .line 27
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->trackThickness:I

    .line 28
    .line 29
    int-to-float v1, v1

    .line 30
    const/high16 v12, 0x40000000    # 2.0f

    .line 31
    .line 32
    div-float/2addr v1, v12

    .line 33
    sub-float v3, v11, v1

    .line 34
    .line 35
    add-float v4, v1, v11

    .line 36
    .line 37
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 38
    .line 39
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->getTrackCornerSize()I

    .line 40
    .line 41
    .line 42
    move-result v2

    .line 43
    sub-int/2addr v1, v2

    .line 44
    int-to-float v1, v1

    .line 45
    iget v2, v0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 46
    .line 47
    int-to-float v2, v2

    .line 48
    const/4 v13, 0x0

    .line 49
    aget v5, v10, v13

    .line 50
    .line 51
    int-to-float v14, v9

    .line 52
    mul-float v5, v5, v14

    .line 53
    .line 54
    add-float/2addr v5, v2

    .line 55
    iget v2, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 56
    .line 57
    int-to-float v2, v2

    .line 58
    sub-float v2, v5, v2

    .line 59
    .line 60
    iget-object v6, v0, Lcom/google/android/material/slider/BaseSlider;->inactiveTrackLeftRect:Landroid/graphics/RectF;

    .line 61
    .line 62
    const/4 v7, 0x2

    .line 63
    move-object/from16 v5, p1

    .line 64
    .line 65
    invoke-virtual/range {v0 .. v7}, Lcom/google/android/material/slider/BaseSlider;->drawInactiveTrackSection(FFFFLandroid/graphics/Canvas;Landroid/graphics/RectF;I)V

    .line 66
    .line 67
    .line 68
    const/4 v15, 0x2

    .line 69
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 70
    .line 71
    int-to-float v2, v1

    .line 72
    const/4 v5, 0x1

    .line 73
    aget v7, v10, v5

    .line 74
    .line 75
    mul-float v7, v7, v14

    .line 76
    .line 77
    add-float/2addr v7, v2

    .line 78
    iget v2, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 79
    .line 80
    int-to-float v2, v2

    .line 81
    add-float/2addr v7, v2

    .line 82
    add-int/2addr v1, v9

    .line 83
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->getTrackCornerSize()I

    .line 84
    .line 85
    .line 86
    move-result v2

    .line 87
    add-int/2addr v2, v1

    .line 88
    int-to-float v2, v2

    .line 89
    move-object v1, v6

    .line 90
    iget-object v6, v0, Lcom/google/android/material/slider/BaseSlider;->inactiveTrackRightRect:Landroid/graphics/RectF;

    .line 91
    .line 92
    move-object v9, v1

    .line 93
    move v1, v7

    .line 94
    const/4 v7, 0x3

    .line 95
    move-object/from16 v5, p1

    .line 96
    .line 97
    const/4 v10, 0x1

    .line 98
    invoke-virtual/range {v0 .. v7}, Lcom/google/android/material/slider/BaseSlider;->drawInactiveTrackSection(FFFFLandroid/graphics/Canvas;Landroid/graphics/RectF;I)V

    .line 99
    .line 100
    .line 101
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 102
    .line 103
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->getActiveRange()[F

    .line 104
    .line 105
    .line 106
    move-result-object v14

    .line 107
    iget v2, v0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 108
    .line 109
    int-to-float v2, v2

    .line 110
    aget v3, v14, v10

    .line 111
    .line 112
    int-to-float v1, v1

    .line 113
    mul-float v3, v3, v1

    .line 114
    .line 115
    add-float/2addr v3, v2

    .line 116
    aget v4, v14, v13

    .line 117
    .line 118
    mul-float v4, v4, v1

    .line 119
    .line 120
    add-float/2addr v4, v2

    .line 121
    const/4 v1, 0x2

    .line 122
    move v2, v3

    .line 123
    iget-object v3, v0, Lcom/google/android/material/slider/BaseSlider;->activeTrackRect:Landroid/graphics/RectF;

    .line 124
    .line 125
    cmpl-float v5, v4, v2

    .line 126
    .line 127
    if-ltz v5, :cond_2

    .line 128
    .line 129
    invoke-virtual {v3}, Landroid/graphics/RectF;->setEmpty()V

    .line 130
    .line 131
    .line 132
    :cond_1
    move-object/from16 v1, p1

    .line 133
    .line 134
    const/4 v10, 0x2

    .line 135
    const/high16 v16, 0x40000000    # 2.0f

    .line 136
    .line 137
    const/16 v17, 0x1

    .line 138
    .line 139
    goto/16 :goto_a

    .line 140
    .line 141
    :cond_2
    iget-object v5, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 142
    .line 143
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    .line 144
    .line 145
    .line 146
    move-result v5

    .line 147
    if-ne v5, v10, :cond_5

    .line 148
    .line 149
    iget-boolean v5, v0, Lcom/google/android/material/slider/BaseSlider;->centered:Z

    .line 150
    .line 151
    if-nez v5, :cond_5

    .line 152
    .line 153
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 154
    .line 155
    .line 156
    move-result v5

    .line 157
    if-nez v5, :cond_4

    .line 158
    .line 159
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 160
    .line 161
    .line 162
    move-result v5

    .line 163
    if-eqz v5, :cond_3

    .line 164
    .line 165
    goto :goto_0

    .line 166
    :cond_3
    const/4 v7, 0x2

    .line 167
    :cond_4
    :goto_0
    move v5, v7

    .line 168
    goto :goto_1

    .line 169
    :cond_5
    const/4 v7, 0x4

    .line 170
    const/4 v5, 0x4

    .line 171
    :goto_1
    const/4 v7, 0x0

    .line 172
    :goto_2
    iget-object v15, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 173
    .line 174
    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    .line 175
    .line 176
    .line 177
    move-result v15

    .line 178
    if-ge v7, v15, :cond_1

    .line 179
    .line 180
    iget-object v15, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 181
    .line 182
    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    .line 183
    .line 184
    .line 185
    move-result v15

    .line 186
    if-le v15, v10, :cond_8

    .line 187
    .line 188
    if-lez v7, :cond_6

    .line 189
    .line 190
    iget-object v2, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 191
    .line 192
    add-int/lit8 v4, v7, -0x1

    .line 193
    .line 194
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 195
    .line 196
    .line 197
    move-result-object v2

    .line 198
    check-cast v2, Ljava/lang/Float;

    .line 199
    .line 200
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    .line 201
    .line 202
    .line 203
    move-result v2

    .line 204
    invoke-virtual {v0, v2}, Lcom/google/android/material/slider/BaseSlider;->valueToX(F)F

    .line 205
    .line 206
    .line 207
    move-result v2

    .line 208
    goto :goto_3

    .line 209
    :cond_6
    move v2, v4

    .line 210
    :goto_3
    iget-object v4, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 211
    .line 212
    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 213
    .line 214
    .line 215
    move-result-object v4

    .line 216
    check-cast v4, Ljava/lang/Float;

    .line 217
    .line 218
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    .line 219
    .line 220
    .line 221
    move-result v4

    .line 222
    invoke-virtual {v0, v4}, Lcom/google/android/material/slider/BaseSlider;->valueToX(F)F

    .line 223
    .line 224
    .line 225
    move-result v4

    .line 226
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 227
    .line 228
    .line 229
    move-result v15

    .line 230
    if-nez v15, :cond_8

    .line 231
    .line 232
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 233
    .line 234
    .line 235
    move-result v15

    .line 236
    if-eqz v15, :cond_7

    .line 237
    .line 238
    goto :goto_4

    .line 239
    :cond_7
    move/from16 v18, v4

    .line 240
    .line 241
    move v4, v2

    .line 242
    move/from16 v2, v18

    .line 243
    .line 244
    :cond_8
    :goto_4
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->getTrackCornerSize()I

    .line 245
    .line 246
    .line 247
    move-result v15

    .line 248
    const/high16 v16, 0x40000000    # 2.0f

    .line 249
    .line 250
    invoke-static {v5}, Landroidx/constraintlayout/core/SolverVariable$Type$EnumUnboxingSharedUtility;->ordinal(I)I

    .line 251
    .line 252
    .line 253
    move-result v12

    .line 254
    if-eq v12, v10, :cond_e

    .line 255
    .line 256
    if-eq v12, v1, :cond_d

    .line 257
    .line 258
    const/4 v1, 0x3

    .line 259
    if-eq v12, v1, :cond_9

    .line 260
    .line 261
    goto :goto_6

    .line 262
    :cond_9
    iget-boolean v1, v0, Lcom/google/android/material/slider/BaseSlider;->centered:Z

    .line 263
    .line 264
    if-nez v1, :cond_b

    .line 265
    .line 266
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 267
    .line 268
    int-to-float v1, v1

    .line 269
    add-float/2addr v4, v1

    .line 270
    :goto_5
    sub-float/2addr v2, v1

    .line 271
    :cond_a
    :goto_6
    move v12, v2

    .line 272
    move v1, v4

    .line 273
    goto :goto_8

    .line 274
    :cond_b
    aget v1, v14, v10

    .line 275
    .line 276
    const/high16 v12, 0x3f000000    # 0.5f

    .line 277
    .line 278
    cmpl-float v1, v1, v12

    .line 279
    .line 280
    if-nez v1, :cond_c

    .line 281
    .line 282
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 283
    .line 284
    int-to-float v1, v1

    .line 285
    add-float/2addr v4, v1

    .line 286
    goto :goto_6

    .line 287
    :cond_c
    aget v1, v14, v13

    .line 288
    .line 289
    cmpl-float v1, v1, v12

    .line 290
    .line 291
    if-nez v1, :cond_a

    .line 292
    .line 293
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 294
    .line 295
    :goto_7
    int-to-float v1, v1

    .line 296
    goto :goto_5

    .line 297
    :cond_d
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 298
    .line 299
    int-to-float v1, v1

    .line 300
    add-float/2addr v4, v1

    .line 301
    int-to-float v1, v15

    .line 302
    add-float/2addr v2, v1

    .line 303
    goto :goto_6

    .line 304
    :cond_e
    int-to-float v1, v15

    .line 305
    sub-float/2addr v4, v1

    .line 306
    iget v1, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 307
    .line 308
    goto :goto_7

    .line 309
    :goto_8
    cmpl-float v2, v1, v12

    .line 310
    .line 311
    if-ltz v2, :cond_f

    .line 312
    .line 313
    invoke-virtual {v3}, Landroid/graphics/RectF;->setEmpty()V

    .line 314
    .line 315
    .line 316
    move v15, v1

    .line 317
    const/4 v10, 0x2

    .line 318
    const/16 v17, 0x1

    .line 319
    .line 320
    move-object/from16 v1, p1

    .line 321
    .line 322
    goto :goto_9

    .line 323
    :cond_f
    iget v2, v0, Lcom/google/android/material/slider/BaseSlider;->trackThickness:I

    .line 324
    .line 325
    int-to-float v2, v2

    .line 326
    div-float v2, v2, v16

    .line 327
    .line 328
    sub-float v4, v11, v2

    .line 329
    .line 330
    add-float/2addr v2, v11

    .line 331
    invoke-virtual {v3, v1, v4, v12, v2}, Landroid/graphics/RectF;->set(FFFF)V

    .line 332
    .line 333
    .line 334
    iget-object v2, v0, Lcom/google/android/material/slider/BaseSlider;->activeTrackPaint:Landroid/graphics/Paint;

    .line 335
    .line 336
    int-to-float v4, v15

    .line 337
    move v15, v1

    .line 338
    const/4 v10, 0x2

    .line 339
    const/16 v17, 0x1

    .line 340
    .line 341
    move-object/from16 v1, p1

    .line 342
    .line 343
    invoke-virtual/range {v0 .. v5}, Lcom/google/android/material/slider/BaseSlider;->updateTrack(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/RectF;FI)V

    .line 344
    .line 345
    .line 346
    :goto_9
    add-int/lit8 v7, v7, 0x1

    .line 347
    .line 348
    move v2, v12

    .line 349
    move v4, v15

    .line 350
    const/4 v1, 0x2

    .line 351
    const/4 v10, 0x1

    .line 352
    const/high16 v12, 0x40000000    # 2.0f

    .line 353
    .line 354
    goto/16 :goto_2

    .line 355
    .line 356
    :goto_a
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 357
    .line 358
    .line 359
    move-result v2

    .line 360
    if-nez v2, :cond_11

    .line 361
    .line 362
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 363
    .line 364
    .line 365
    move-result v2

    .line 366
    if-eqz v2, :cond_10

    .line 367
    .line 368
    goto :goto_b

    .line 369
    :cond_10
    invoke-virtual {v0, v1, v3, v6}, Lcom/google/android/material/slider/BaseSlider;->drawTrackIcons(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/RectF;)V

    .line 370
    .line 371
    .line 372
    goto :goto_c

    .line 373
    :cond_11
    :goto_b
    invoke-virtual {v0, v1, v3, v9}, Lcom/google/android/material/slider/BaseSlider;->drawTrackIcons(Landroid/graphics/Canvas;Landroid/graphics/RectF;Landroid/graphics/RectF;)V

    .line 374
    .line 375
    .line 376
    :goto_c
    iget-object v2, v0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    .line 377
    .line 378
    if-eqz v2, :cond_15

    .line 379
    .line 380
    array-length v2, v2

    .line 381
    if-nez v2, :cond_12

    .line 382
    .line 383
    goto :goto_d

    .line 384
    :cond_12
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->getActiveRange()[F

    .line 385
    .line 386
    .line 387
    move-result-object v2

    .line 388
    aget v3, v2, v13

    .line 389
    .line 390
    iget-object v4, v0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    .line 391
    .line 392
    array-length v4, v4

    .line 393
    int-to-float v4, v4

    .line 394
    div-float v4, v4, v16

    .line 395
    .line 396
    const/high16 v5, 0x3f800000    # 1.0f

    .line 397
    .line 398
    sub-float/2addr v4, v5

    .line 399
    mul-float v4, v4, v3

    .line 400
    .line 401
    float-to-double v3, v4

    .line 402
    invoke-static {v3, v4}, Ljava/lang/Math;->ceil(D)D

    .line 403
    .line 404
    .line 405
    move-result-wide v3

    .line 406
    double-to-int v3, v3

    .line 407
    aget v2, v2, v17

    .line 408
    .line 409
    iget-object v4, v0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    .line 410
    .line 411
    array-length v4, v4

    .line 412
    int-to-float v4, v4

    .line 413
    div-float v4, v4, v16

    .line 414
    .line 415
    sub-float/2addr v4, v5

    .line 416
    mul-float v4, v4, v2

    .line 417
    .line 418
    float-to-double v4, v4

    .line 419
    invoke-static {v4, v5}, Ljava/lang/Math;->floor(D)D

    .line 420
    .line 421
    .line 422
    move-result-wide v4

    .line 423
    double-to-int v2, v4

    .line 424
    iget-object v4, v0, Lcom/google/android/material/slider/BaseSlider;->inactiveTicksPaint:Landroid/graphics/Paint;

    .line 425
    .line 426
    if-lez v3, :cond_13

    .line 427
    .line 428
    mul-int/lit8 v5, v3, 0x2

    .line 429
    .line 430
    invoke-virtual {v0, v13, v5, v1, v4}, Lcom/google/android/material/slider/BaseSlider;->drawTicks(IILandroid/graphics/Canvas;Landroid/graphics/Paint;)V

    .line 431
    .line 432
    .line 433
    :cond_13
    if-gt v3, v2, :cond_14

    .line 434
    .line 435
    mul-int/lit8 v3, v3, 0x2

    .line 436
    .line 437
    add-int/lit8 v5, v2, 0x1

    .line 438
    .line 439
    mul-int/lit8 v5, v5, 0x2

    .line 440
    .line 441
    iget-object v6, v0, Lcom/google/android/material/slider/BaseSlider;->activeTicksPaint:Landroid/graphics/Paint;

    .line 442
    .line 443
    invoke-virtual {v0, v3, v5, v1, v6}, Lcom/google/android/material/slider/BaseSlider;->drawTicks(IILandroid/graphics/Canvas;Landroid/graphics/Paint;)V

    .line 444
    .line 445
    .line 446
    :cond_14
    add-int/lit8 v2, v2, 0x1

    .line 447
    .line 448
    mul-int/lit8 v2, v2, 0x2

    .line 449
    .line 450
    iget-object v3, v0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    .line 451
    .line 452
    array-length v5, v3

    .line 453
    if-ge v2, v5, :cond_15

    .line 454
    .line 455
    array-length v3, v3

    .line 456
    invoke-virtual {v0, v2, v3, v1, v4}, Lcom/google/android/material/slider/BaseSlider;->drawTicks(IILandroid/graphics/Canvas;Landroid/graphics/Paint;)V

    .line 457
    .line 458
    .line 459
    :cond_15
    :goto_d
    iget v2, v0, Lcom/google/android/material/slider/BaseSlider;->trackStopIndicatorSize:I

    .line 460
    .line 461
    if-lez v2, :cond_19

    .line 462
    .line 463
    iget-object v2, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 464
    .line 465
    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    .line 466
    .line 467
    .line 468
    move-result v2

    .line 469
    if-eqz v2, :cond_16

    .line 470
    .line 471
    goto :goto_e

    .line 472
    :cond_16
    iget-object v2, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 473
    .line 474
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 475
    .line 476
    .line 477
    move-result v3

    .line 478
    add-int/lit8 v3, v3, -0x1

    .line 479
    .line 480
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 481
    .line 482
    .line 483
    move-result-object v2

    .line 484
    check-cast v2, Ljava/lang/Float;

    .line 485
    .line 486
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    .line 487
    .line 488
    .line 489
    move-result v2

    .line 490
    iget v3, v0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 491
    .line 492
    cmpg-float v2, v2, v3

    .line 493
    .line 494
    if-gez v2, :cond_17

    .line 495
    .line 496
    invoke-virtual {v0, v3}, Lcom/google/android/material/slider/BaseSlider;->valueToX(F)F

    .line 497
    .line 498
    .line 499
    move-result v2

    .line 500
    invoke-virtual {v0, v1, v2, v11}, Lcom/google/android/material/slider/BaseSlider;->drawStopIndicator(Landroid/graphics/Canvas;FF)V

    .line 501
    .line 502
    .line 503
    :cond_17
    iget-boolean v2, v0, Lcom/google/android/material/slider/BaseSlider;->centered:Z

    .line 504
    .line 505
    if-nez v2, :cond_18

    .line 506
    .line 507
    iget-object v2, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 508
    .line 509
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 510
    .line 511
    .line 512
    move-result v2

    .line 513
    const/4 v3, 0x1

    .line 514
    if-le v2, v3, :cond_19

    .line 515
    .line 516
    iget-object v2, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 517
    .line 518
    invoke-virtual {v2, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 519
    .line 520
    .line 521
    move-result-object v2

    .line 522
    check-cast v2, Ljava/lang/Float;

    .line 523
    .line 524
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    .line 525
    .line 526
    .line 527
    move-result v2

    .line 528
    iget v3, v0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 529
    .line 530
    cmpl-float v2, v2, v3

    .line 531
    .line 532
    if-lez v2, :cond_19

    .line 533
    .line 534
    :cond_18
    iget v2, v0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 535
    .line 536
    invoke-virtual {v0, v2}, Lcom/google/android/material/slider/BaseSlider;->valueToX(F)F

    .line 537
    .line 538
    .line 539
    move-result v2

    .line 540
    invoke-virtual {v0, v1, v2, v11}, Lcom/google/android/material/slider/BaseSlider;->drawStopIndicator(Landroid/graphics/Canvas;FF)V

    .line 541
    .line 542
    .line 543
    :cond_19
    :goto_e
    iget-boolean v2, v0, Lcom/google/android/material/slider/BaseSlider;->thumbIsPressed:Z

    .line 544
    .line 545
    if-nez v2, :cond_1b

    .line 546
    .line 547
    invoke-virtual {v0}, Landroid/view/View;->isFocused()Z

    .line 548
    .line 549
    .line 550
    move-result v2

    .line 551
    if-eqz v2, :cond_1a

    .line 552
    .line 553
    goto :goto_f

    .line 554
    :cond_1a
    move-object v7, v0

    .line 555
    goto/16 :goto_11

    .line 556
    .line 557
    :cond_1b
    :goto_f
    invoke-virtual {v0}, Landroid/view/View;->isEnabled()Z

    .line 558
    .line 559
    .line 560
    move-result v2

    .line 561
    if-eqz v2, :cond_1a

    .line 562
    .line 563
    iget v2, v0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 564
    .line 565
    invoke-virtual {v0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    .line 566
    .line 567
    .line 568
    move-result-object v3

    .line 569
    instance-of v3, v3, Landroid/graphics/drawable/RippleDrawable;

    .line 570
    .line 571
    if-nez v3, :cond_1a

    .line 572
    .line 573
    iget v3, v0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 574
    .line 575
    int-to-float v3, v3

    .line 576
    iget-object v4, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 577
    .line 578
    iget v5, v0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 579
    .line 580
    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 581
    .line 582
    .line 583
    move-result-object v4

    .line 584
    check-cast v4, Ljava/lang/Float;

    .line 585
    .line 586
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    .line 587
    .line 588
    .line 589
    move-result v4

    .line 590
    invoke-virtual {v0, v4}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 591
    .line 592
    .line 593
    move-result v4

    .line 594
    int-to-float v2, v2

    .line 595
    mul-float v4, v4, v2

    .line 596
    .line 597
    add-float/2addr v4, v3

    .line 598
    new-array v6, v10, [F

    .line 599
    .line 600
    aput v4, v6, v13

    .line 601
    .line 602
    const/16 v17, 0x1

    .line 603
    .line 604
    aput v11, v6, v17

    .line 605
    .line 606
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 607
    .line 608
    .line 609
    move-result v2

    .line 610
    if-eqz v2, :cond_1c

    .line 611
    .line 612
    iget-object v2, v0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 613
    .line 614
    invoke-virtual {v2, v6}, Landroid/graphics/Matrix;->mapPoints([F)V

    .line 615
    .line 616
    .line 617
    :cond_1c
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 618
    .line 619
    const/16 v3, 0x1c

    .line 620
    .line 621
    if-ge v2, v3, :cond_1d

    .line 622
    .line 623
    aget v2, v6, v13

    .line 624
    .line 625
    iget v3, v0, Lcom/google/android/material/slider/BaseSlider;->haloRadius:I

    .line 626
    .line 627
    int-to-float v3, v3

    .line 628
    sub-float v1, v2, v3

    .line 629
    .line 630
    const/16 v17, 0x1

    .line 631
    .line 632
    aget v4, v6, v17

    .line 633
    .line 634
    move v5, v2

    .line 635
    sub-float v2, v4, v3

    .line 636
    .line 637
    add-float/2addr v5, v3

    .line 638
    add-float/2addr v4, v3

    .line 639
    move v3, v5

    .line 640
    sget-object v5, Landroid/graphics/Region$Op;->UNION:Landroid/graphics/Region$Op;

    .line 641
    .line 642
    move-object v7, v0

    .line 643
    move-object/from16 v0, p1

    .line 644
    .line 645
    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    .line 646
    .line 647
    .line 648
    move-object v1, v0

    .line 649
    goto :goto_10

    .line 650
    :cond_1d
    move-object v7, v0

    .line 651
    const/16 v17, 0x1

    .line 652
    .line 653
    :goto_10
    aget v0, v6, v13

    .line 654
    .line 655
    aget v2, v6, v17

    .line 656
    .line 657
    iget v3, v7, Lcom/google/android/material/slider/BaseSlider;->haloRadius:I

    .line 658
    .line 659
    int-to-float v3, v3

    .line 660
    iget-object v4, v7, Lcom/google/android/material/slider/BaseSlider;->haloPaint:Landroid/graphics/Paint;

    .line 661
    .line 662
    invoke-virtual {v1, v0, v2, v3, v4}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 663
    .line 664
    .line 665
    :goto_11
    invoke-virtual {v7}, Lcom/google/android/material/slider/BaseSlider;->updateLabels()V

    .line 666
    .line 667
    .line 668
    iget v2, v7, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 669
    .line 670
    :goto_12
    iget-object v0, v7, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 671
    .line 672
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 673
    .line 674
    .line 675
    move-result v0

    .line 676
    if-ge v13, v0, :cond_21

    .line 677
    .line 678
    iget-object v0, v7, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 679
    .line 680
    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 681
    .line 682
    .line 683
    move-result-object v0

    .line 684
    check-cast v0, Ljava/lang/Float;

    .line 685
    .line 686
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    .line 687
    .line 688
    .line 689
    move-result v4

    .line 690
    iget-object v5, v7, Lcom/google/android/material/slider/BaseSlider;->customThumbDrawable:Landroid/graphics/drawable/Drawable;

    .line 691
    .line 692
    if-eqz v5, :cond_1e

    .line 693
    .line 694
    move-object v0, v7

    .line 695
    move v3, v8

    .line 696
    invoke-virtual/range {v0 .. v5}, Lcom/google/android/material/slider/BaseSlider;->drawThumbDrawable(Landroid/graphics/Canvas;IIFLandroid/graphics/drawable/Drawable;)V

    .line 697
    .line 698
    .line 699
    goto :goto_13

    .line 700
    :cond_1e
    move-object v0, v7

    .line 701
    move v3, v8

    .line 702
    iget-object v1, v0, Lcom/google/android/material/slider/BaseSlider;->customThumbDrawablesForValues:Ljava/util/List;

    .line 703
    .line 704
    invoke-interface {v1}, Ljava/util/List;->size()I

    .line 705
    .line 706
    .line 707
    move-result v1

    .line 708
    if-ge v13, v1, :cond_1f

    .line 709
    .line 710
    iget-object v1, v0, Lcom/google/android/material/slider/BaseSlider;->customThumbDrawablesForValues:Ljava/util/List;

    .line 711
    .line 712
    invoke-interface {v1, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 713
    .line 714
    .line 715
    move-result-object v1

    .line 716
    move-object v5, v1

    .line 717
    check-cast v5, Landroid/graphics/drawable/Drawable;

    .line 718
    .line 719
    move-object/from16 v1, p1

    .line 720
    .line 721
    invoke-virtual/range {v0 .. v5}, Lcom/google/android/material/slider/BaseSlider;->drawThumbDrawable(Landroid/graphics/Canvas;IIFLandroid/graphics/drawable/Drawable;)V

    .line 722
    .line 723
    .line 724
    goto :goto_13

    .line 725
    :cond_1f
    move-object/from16 v1, p1

    .line 726
    .line 727
    invoke-virtual {v0}, Landroid/view/View;->isEnabled()Z

    .line 728
    .line 729
    .line 730
    move-result v5

    .line 731
    if-nez v5, :cond_20

    .line 732
    .line 733
    iget v5, v0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 734
    .line 735
    int-to-float v5, v5

    .line 736
    invoke-virtual {v0, v4}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 737
    .line 738
    .line 739
    move-result v6

    .line 740
    int-to-float v7, v2

    .line 741
    mul-float v6, v6, v7

    .line 742
    .line 743
    add-float/2addr v6, v5

    .line 744
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->getThumbRadius()I

    .line 745
    .line 746
    .line 747
    move-result v5

    .line 748
    int-to-float v5, v5

    .line 749
    iget-object v7, v0, Lcom/google/android/material/slider/BaseSlider;->thumbPaint:Landroid/graphics/Paint;

    .line 750
    .line 751
    invoke-virtual {v1, v6, v11, v5, v7}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 752
    .line 753
    .line 754
    :cond_20
    iget-object v5, v0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 755
    .line 756
    invoke-virtual/range {v0 .. v5}, Lcom/google/android/material/slider/BaseSlider;->drawThumbDrawable(Landroid/graphics/Canvas;IIFLandroid/graphics/drawable/Drawable;)V

    .line 757
    .line 758
    .line 759
    :goto_13
    add-int/lit8 v13, v13, 0x1

    .line 760
    .line 761
    move-object/from16 v7, p0

    .line 762
    .line 763
    move-object/from16 v1, p1

    .line 764
    .line 765
    move v8, v3

    .line 766
    goto :goto_12

    .line 767
    :cond_21
    return-void
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

.method public final onFocusChanged(ZILandroid/graphics/Rect;)V
    .locals 2

    .line 1
    invoke-super {p0, p1, p2, p3}, Landroid/view/View;->onFocusChanged(ZILandroid/graphics/Rect;)V

    .line 2
    .line 3
    .line 4
    iget-object p3, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityHelper:Lcom/google/android/material/slider/BaseSlider$AccessibilityHelper;

    .line 5
    .line 6
    if-nez p1, :cond_0

    .line 7
    .line 8
    const/4 p1, -0x1

    .line 9
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 10
    .line 11
    iget p1, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 12
    .line 13
    invoke-virtual {p3, p1}, Landroidx/customview/widget/ExploreByTouchHelper;->clearKeyboardFocusForVirtualView(I)Z

    .line 14
    .line 15
    .line 16
    return-void

    .line 17
    :cond_0
    const/4 p1, 0x1

    .line 18
    const v0, 0x7fffffff

    .line 19
    .line 20
    .line 21
    if-eq p2, p1, :cond_4

    .line 22
    .line 23
    const/4 p1, 0x2

    .line 24
    const/high16 v1, -0x80000000

    .line 25
    .line 26
    if-eq p2, p1, :cond_3

    .line 27
    .line 28
    const/16 p1, 0x11

    .line 29
    .line 30
    if-eq p2, p1, :cond_2

    .line 31
    .line 32
    const/16 p1, 0x42

    .line 33
    .line 34
    if-eq p2, p1, :cond_1

    .line 35
    .line 36
    goto :goto_0

    .line 37
    :cond_1
    invoke-virtual {p0, v1}, Lcom/google/android/material/slider/BaseSlider;->moveFocusInAbsoluteDirection(I)V

    .line 38
    .line 39
    .line 40
    goto :goto_0

    .line 41
    :cond_2
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->moveFocusInAbsoluteDirection(I)V

    .line 42
    .line 43
    .line 44
    goto :goto_0

    .line 45
    :cond_3
    invoke-virtual {p0, v1}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 46
    .line 47
    .line 48
    goto :goto_0

    .line 49
    :cond_4
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 50
    .line 51
    .line 52
    :goto_0
    iget p1, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 53
    .line 54
    invoke-virtual {p3, p1}, Landroidx/customview/widget/ExploreByTouchHelper;->requestKeyboardFocusForVirtualView(I)Z

    .line 55
    .line 56
    .line 57
    return-void
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

.method public final onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 1

    .line 1
    invoke-super {p0, p1}, Landroid/view/View;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setVisibleToUser(Z)V

    .line 6
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
.end method

.method public final onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 13

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->isEnabled()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    invoke-super {p0, p1, p2}, Landroid/view/View;->onKeyDown(ILandroid/view/KeyEvent;)Z

    .line 8
    .line 9
    .line 10
    move-result p1

    .line 11
    return p1

    .line 12
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 13
    .line 14
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 15
    .line 16
    .line 17
    move-result v0

    .line 18
    const/4 v1, 0x0

    .line 19
    const/4 v2, 0x1

    .line 20
    if-ne v0, v2, :cond_1

    .line 21
    .line 22
    iput v1, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 23
    .line 24
    :cond_1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 25
    .line 26
    const/4 v3, 0x0

    .line 27
    const/16 v4, 0x46

    .line 28
    .line 29
    const/16 v5, 0x45

    .line 30
    .line 31
    const/16 v6, 0x51

    .line 32
    .line 33
    const/16 v7, 0x42

    .line 34
    .line 35
    const/16 v8, 0x3d

    .line 36
    .line 37
    const/4 v9, -0x1

    .line 38
    if-ne v0, v9, :cond_9

    .line 39
    .line 40
    if-eq p1, v8, :cond_5

    .line 41
    .line 42
    if-eq p1, v7, :cond_4

    .line 43
    .line 44
    if-eq p1, v6, :cond_3

    .line 45
    .line 46
    if-eq p1, v5, :cond_2

    .line 47
    .line 48
    if-eq p1, v4, :cond_3

    .line 49
    .line 50
    packed-switch p1, :pswitch_data_0

    .line 51
    .line 52
    .line 53
    goto :goto_0

    .line 54
    :pswitch_0
    invoke-virtual {p0, v2}, Lcom/google/android/material/slider/BaseSlider;->moveFocusInAbsoluteDirection(I)V

    .line 55
    .line 56
    .line 57
    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 58
    .line 59
    goto :goto_0

    .line 60
    :pswitch_1
    invoke-virtual {p0, v9}, Lcom/google/android/material/slider/BaseSlider;->moveFocusInAbsoluteDirection(I)V

    .line 61
    .line 62
    .line 63
    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 64
    .line 65
    goto :goto_0

    .line 66
    :cond_2
    invoke-virtual {p0, v9}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 67
    .line 68
    .line 69
    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 70
    .line 71
    goto :goto_0

    .line 72
    :cond_3
    invoke-virtual {p0, v2}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 73
    .line 74
    .line 75
    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 76
    .line 77
    goto :goto_0

    .line 78
    :cond_4
    :pswitch_2
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 79
    .line 80
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 81
    .line 82
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    .line 83
    .line 84
    .line 85
    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 86
    .line 87
    goto :goto_0

    .line 88
    :cond_5
    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    .line 89
    .line 90
    .line 91
    move-result v0

    .line 92
    if-eqz v0, :cond_6

    .line 93
    .line 94
    invoke-virtual {p0, v2}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 95
    .line 96
    .line 97
    move-result v0

    .line 98
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 99
    .line 100
    .line 101
    move-result-object v3

    .line 102
    goto :goto_0

    .line 103
    :cond_6
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isShiftPressed()Z

    .line 104
    .line 105
    .line 106
    move-result v0

    .line 107
    if-eqz v0, :cond_7

    .line 108
    .line 109
    invoke-virtual {p0, v9}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 110
    .line 111
    .line 112
    move-result v0

    .line 113
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 114
    .line 115
    .line 116
    move-result-object v3

    .line 117
    goto :goto_0

    .line 118
    :cond_7
    sget-object v3, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .line 119
    .line 120
    :goto_0
    if-eqz v3, :cond_8

    .line 121
    .line 122
    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    .line 123
    .line 124
    .line 125
    move-result p1

    .line 126
    return p1

    .line 127
    :cond_8
    invoke-super {p0, p1, p2}, Landroid/view/View;->onKeyDown(ILandroid/view/KeyEvent;)Z

    .line 128
    .line 129
    .line 130
    move-result p1

    .line 131
    return p1

    .line 132
    :cond_9
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->isLongPress:Z

    .line 133
    .line 134
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isLongPress()Z

    .line 135
    .line 136
    .line 137
    move-result v10

    .line 138
    or-int/2addr v0, v10

    .line 139
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->isLongPress:Z

    .line 140
    .line 141
    const/high16 v10, 0x3f800000    # 1.0f

    .line 142
    .line 143
    const/4 v11, 0x0

    .line 144
    if-eqz v0, :cond_c

    .line 145
    .line 146
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 147
    .line 148
    cmpl-float v11, v0, v11

    .line 149
    .line 150
    if-nez v11, :cond_a

    .line 151
    .line 152
    goto :goto_1

    .line 153
    :cond_a
    move v10, v0

    .line 154
    :goto_1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 155
    .line 156
    iget v11, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 157
    .line 158
    sub-float/2addr v0, v11

    .line 159
    div-float/2addr v0, v10

    .line 160
    const/16 v11, 0x14

    .line 161
    .line 162
    int-to-float v11, v11

    .line 163
    cmpg-float v12, v0, v11

    .line 164
    .line 165
    if-gtz v12, :cond_b

    .line 166
    .line 167
    goto :goto_2

    .line 168
    :cond_b
    div-float/2addr v0, v11

    .line 169
    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    .line 170
    .line 171
    .line 172
    move-result v0

    .line 173
    int-to-float v0, v0

    .line 174
    mul-float v10, v10, v0

    .line 175
    .line 176
    goto :goto_2

    .line 177
    :cond_c
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 178
    .line 179
    cmpl-float v11, v0, v11

    .line 180
    .line 181
    if-nez v11, :cond_d

    .line 182
    .line 183
    goto :goto_2

    .line 184
    :cond_d
    move v10, v0

    .line 185
    :goto_2
    if-eq p1, v5, :cond_11

    .line 186
    .line 187
    if-eq p1, v4, :cond_10

    .line 188
    .line 189
    if-eq p1, v6, :cond_10

    .line 190
    .line 191
    packed-switch p1, :pswitch_data_1

    .line 192
    .line 193
    .line 194
    goto :goto_4

    .line 195
    :pswitch_3
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 196
    .line 197
    .line 198
    move-result v0

    .line 199
    if-eqz v0, :cond_e

    .line 200
    .line 201
    neg-float v10, v10

    .line 202
    :cond_e
    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 203
    .line 204
    .line 205
    move-result-object v3

    .line 206
    goto :goto_4

    .line 207
    :pswitch_4
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 208
    .line 209
    .line 210
    move-result v0

    .line 211
    if-eqz v0, :cond_f

    .line 212
    .line 213
    goto :goto_3

    .line 214
    :cond_f
    neg-float v10, v10

    .line 215
    :goto_3
    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 216
    .line 217
    .line 218
    move-result-object v3

    .line 219
    goto :goto_4

    .line 220
    :pswitch_5
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 221
    .line 222
    .line 223
    move-result v0

    .line 224
    if-eqz v0, :cond_12

    .line 225
    .line 226
    neg-float v0, v10

    .line 227
    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 228
    .line 229
    .line 230
    move-result-object v3

    .line 231
    goto :goto_4

    .line 232
    :pswitch_6
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 233
    .line 234
    .line 235
    move-result v0

    .line 236
    if-eqz v0, :cond_12

    .line 237
    .line 238
    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 239
    .line 240
    .line 241
    move-result-object v3

    .line 242
    goto :goto_4

    .line 243
    :cond_10
    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 244
    .line 245
    .line 246
    move-result-object v3

    .line 247
    goto :goto_4

    .line 248
    :cond_11
    neg-float v0, v10

    .line 249
    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 250
    .line 251
    .line 252
    move-result-object v3

    .line 253
    :cond_12
    :goto_4
    if-eqz v3, :cond_14

    .line 254
    .line 255
    iget-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 256
    .line 257
    iget p2, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 258
    .line 259
    invoke-virtual {p1, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 260
    .line 261
    .line 262
    move-result-object p1

    .line 263
    check-cast p1, Ljava/lang/Float;

    .line 264
    .line 265
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    .line 266
    .line 267
    .line 268
    move-result p1

    .line 269
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    .line 270
    .line 271
    .line 272
    move-result p2

    .line 273
    add-float/2addr p2, p1

    .line 274
    iget p1, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 275
    .line 276
    invoke-virtual {p0, p1, p2}, Lcom/google/android/material/slider/BaseSlider;->snapThumbToValue(IF)Z

    .line 277
    .line 278
    .line 279
    move-result p1

    .line 280
    if-eqz p1, :cond_13

    .line 281
    .line 282
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateHaloHotspot()V

    .line 283
    .line 284
    .line 285
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    .line 286
    .line 287
    .line 288
    :cond_13
    return v2

    .line 289
    :cond_14
    const/16 v0, 0x17

    .line 290
    .line 291
    if-eq p1, v0, :cond_18

    .line 292
    .line 293
    if-eq p1, v8, :cond_15

    .line 294
    .line 295
    if-eq p1, v7, :cond_18

    .line 296
    .line 297
    invoke-super {p0, p1, p2}, Landroid/view/View;->onKeyDown(ILandroid/view/KeyEvent;)Z

    .line 298
    .line 299
    .line 300
    move-result p1

    .line 301
    return p1

    .line 302
    :cond_15
    invoke-virtual {p2}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    .line 303
    .line 304
    .line 305
    move-result p1

    .line 306
    if-eqz p1, :cond_16

    .line 307
    .line 308
    invoke-virtual {p0, v2}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 309
    .line 310
    .line 311
    move-result p1

    .line 312
    return p1

    .line 313
    :cond_16
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isShiftPressed()Z

    .line 314
    .line 315
    .line 316
    move-result p1

    .line 317
    if-eqz p1, :cond_17

    .line 318
    .line 319
    invoke-virtual {p0, v9}, Lcom/google/android/material/slider/BaseSlider;->moveFocus(I)Z

    .line 320
    .line 321
    .line 322
    move-result p1

    .line 323
    return p1

    .line 324
    :cond_17
    return v1

    .line 325
    :cond_18
    iput v9, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 326
    .line 327
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    .line 328
    .line 329
    .line 330
    return v2

    .line 331
    :pswitch_data_0
    .packed-switch 0x15
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch

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
    :pswitch_data_1
    .packed-switch 0x13
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
    .end packed-switch
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

.method public final onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->isLongPress:Z

    .line 3
    .line 4
    invoke-super {p0, p1, p2}, Landroid/view/View;->onKeyUp(ILandroid/view/KeyEvent;)Z

    .line 5
    .line 6
    .line 7
    move-result p1

    .line 8
    return p1
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

.method public final onMeasure(II)V
    .locals 3

    .line 1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelBehavior:I

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    const/4 v2, 0x0

    .line 5
    if-eq v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v1, 0x3

    .line 8
    if-ne v0, v1, :cond_1

    .line 9
    .line 10
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 11
    .line 12
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    check-cast v0, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 17
    .line 18
    invoke-virtual {v0}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicHeight()I

    .line 19
    .line 20
    .line 21
    move-result v2

    .line 22
    :cond_1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->widgetThickness:I

    .line 23
    .line 24
    add-int/2addr v0, v2

    .line 25
    const/high16 v1, 0x40000000    # 2.0f

    .line 26
    .line 27
    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    .line 28
    .line 29
    .line 30
    move-result v0

    .line 31
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 32
    .line 33
    .line 34
    move-result v1

    .line 35
    if-eqz v1, :cond_2

    .line 36
    .line 37
    invoke-super {p0, v0, p2}, Landroid/view/View;->onMeasure(II)V

    .line 38
    .line 39
    .line 40
    return-void

    .line 41
    :cond_2
    invoke-super {p0, p1, v0}, Landroid/view/View;->onMeasure(II)V

    .line 42
    .line 43
    .line 44
    return-void
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

.method public final onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 1

    .line 1
    check-cast p1, Lcom/google/android/material/slider/BaseSlider$SliderState;

    .line 2
    .line 3
    invoke-virtual {p1}, Landroid/view/AbsSavedState;->getSuperState()Landroid/os/Parcelable;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-super {p0, v0}, Landroid/view/View;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 8
    .line 9
    .line 10
    iget v0, p1, Lcom/google/android/material/slider/BaseSlider$SliderState;->valueFrom:F

    .line 11
    .line 12
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 13
    .line 14
    iget v0, p1, Lcom/google/android/material/slider/BaseSlider$SliderState;->valueTo:F

    .line 15
    .line 16
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 17
    .line 18
    iget-object v0, p1, Lcom/google/android/material/slider/BaseSlider$SliderState;->values:Ljava/util/ArrayList;

    .line 19
    .line 20
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setValuesInternal(Ljava/util/ArrayList;)V

    .line 21
    .line 22
    .line 23
    iget v0, p1, Lcom/google/android/material/slider/BaseSlider$SliderState;->stepSize:F

    .line 24
    .line 25
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 26
    .line 27
    iget-boolean p1, p1, Lcom/google/android/material/slider/BaseSlider$SliderState;->hasFocus:Z

    .line 28
    .line 29
    if-eqz p1, :cond_0

    .line 30
    .line 31
    invoke-virtual {p0}, Landroid/view/View;->requestFocus()Z

    .line 32
    .line 33
    .line 34
    :cond_0
    return-void
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

.method public final onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .line 1
    invoke-super {p0}, Landroid/view/View;->onSaveInstanceState()Landroid/os/Parcelable;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    new-instance v1, Lcom/google/android/material/slider/BaseSlider$SliderState;

    .line 6
    .line 7
    invoke-direct {v1, v0}, Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V

    .line 8
    .line 9
    .line 10
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 11
    .line 12
    iput v0, v1, Lcom/google/android/material/slider/BaseSlider$SliderState;->valueFrom:F

    .line 13
    .line 14
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 15
    .line 16
    iput v0, v1, Lcom/google/android/material/slider/BaseSlider$SliderState;->valueTo:F

    .line 17
    .line 18
    new-instance v0, Ljava/util/ArrayList;

    .line 19
    .line 20
    iget-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 21
    .line 22
    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 23
    .line 24
    .line 25
    iput-object v0, v1, Lcom/google/android/material/slider/BaseSlider$SliderState;->values:Ljava/util/ArrayList;

    .line 26
    .line 27
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 28
    .line 29
    iput v0, v1, Lcom/google/android/material/slider/BaseSlider$SliderState;->stepSize:F

    .line 30
    .line 31
    invoke-virtual {p0}, Landroid/view/View;->hasFocus()Z

    .line 32
    .line 33
    .line 34
    move-result v0

    .line 35
    iput-boolean v0, v1, Lcom/google/android/material/slider/BaseSlider$SliderState;->hasFocus:Z

    .line 36
    .line 37
    return-object v1
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

.method public final onSizeChanged(IIII)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 2
    .line 3
    .line 4
    move-result p3

    .line 5
    if-eqz p3, :cond_0

    .line 6
    .line 7
    move p1, p2

    .line 8
    :cond_0
    iget p2, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 9
    .line 10
    mul-int/lit8 p2, p2, 0x2

    .line 11
    .line 12
    sub-int/2addr p1, p2

    .line 13
    const/4 p2, 0x0

    .line 14
    invoke-static {p1, p2}, Ljava/lang/Math;->max(II)I

    .line 15
    .line 16
    .line 17
    move-result p1

    .line 18
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 19
    .line 20
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateTicksCoordinates()V

    .line 21
    .line 22
    .line 23
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateHaloHotspot()V

    .line 24
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
.end method

.method public final onStartTrackingTouch()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->touchListeners:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    const/4 v2, 0x0

    .line 8
    :goto_0
    if-ge v2, v1, :cond_0

    .line 9
    .line 10
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 11
    .line 12
    .line 13
    move-result-object v3

    .line 14
    add-int/lit8 v2, v2, 0x1

    .line 15
    .line 16
    check-cast v3, Lcom/google/android/material/slider/BaseOnSliderTouchListener;

    .line 17
    .line 18
    invoke-interface {v3, p0}, Lcom/google/android/material/slider/BaseOnSliderTouchListener;->onStartTrackingTouch(Ljava/lang/Object;)V

    .line 19
    .line 20
    .line 21
    goto :goto_0

    .line 22
    :cond_0
    return-void
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

.method public final onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 8

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->isEnabled()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    const/4 v1, 0x0

    .line 6
    if-nez v0, :cond_0

    .line 7
    .line 8
    goto/16 :goto_2

    .line 9
    .line 10
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 11
    .line 12
    .line 13
    move-result v0

    .line 14
    if-eqz v0, :cond_1

    .line 15
    .line 16
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    goto :goto_0

    .line 21
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    .line 22
    .line 23
    .line 24
    move-result v0

    .line 25
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 26
    .line 27
    .line 28
    move-result v2

    .line 29
    if-eqz v2, :cond_2

    .line 30
    .line 31
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    .line 32
    .line 33
    .line 34
    move-result v2

    .line 35
    goto :goto_1

    .line 36
    :cond_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    .line 37
    .line 38
    .line 39
    move-result v2

    .line 40
    :goto_1
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 41
    .line 42
    int-to-float v3, v3

    .line 43
    sub-float v3, v0, v3

    .line 44
    .line 45
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 46
    .line 47
    int-to-float v4, v4

    .line 48
    div-float/2addr v3, v4

    .line 49
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->touchPosition:F

    .line 50
    .line 51
    const/4 v4, 0x0

    .line 52
    invoke-static {v4, v3}, Ljava/lang/Math;->max(FF)F

    .line 53
    .line 54
    .line 55
    move-result v3

    .line 56
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->touchPosition:F

    .line 57
    .line 58
    const/high16 v4, 0x3f800000    # 1.0f

    .line 59
    .line 60
    invoke-static {v4, v3}, Ljava/lang/Math;->min(FF)F

    .line 61
    .line 62
    .line 63
    move-result v3

    .line 64
    iput v3, p0, Lcom/google/android/material/slider/BaseSlider;->touchPosition:F

    .line 65
    .line 66
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    .line 67
    .line 68
    .line 69
    move-result v3

    .line 70
    const/4 v4, -0x1

    .line 71
    const/4 v5, 0x1

    .line 72
    if-eqz v3, :cond_d

    .line 73
    .line 74
    iget v6, p0, Lcom/google/android/material/slider/BaseSlider;->scaledTouchSlop:I

    .line 75
    .line 76
    if-eq v3, v5, :cond_8

    .line 77
    .line 78
    const/4 v7, 0x2

    .line 79
    if-eq v3, v7, :cond_3

    .line 80
    .line 81
    const/4 v0, 0x3

    .line 82
    if-eq v3, v0, :cond_8

    .line 83
    .line 84
    goto/16 :goto_7

    .line 85
    .line 86
    :cond_3
    iget-boolean v3, p0, Lcom/google/android/material/slider/BaseSlider;->thumbIsPressed:Z

    .line 87
    .line 88
    if-nez v3, :cond_7

    .line 89
    .line 90
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 91
    .line 92
    .line 93
    move-result v3

    .line 94
    if-nez v3, :cond_4

    .line 95
    .line 96
    invoke-virtual {p0, p1}, Lcom/google/android/material/slider/BaseSlider;->isPotentialVerticalScroll(Landroid/view/MotionEvent;)Z

    .line 97
    .line 98
    .line 99
    move-result v3

    .line 100
    if-eqz v3, :cond_4

    .line 101
    .line 102
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->touchDownAxis1:F

    .line 103
    .line 104
    sub-float/2addr v0, v3

    .line 105
    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    .line 106
    .line 107
    .line 108
    move-result v0

    .line 109
    int-to-float v3, v6

    .line 110
    cmpg-float v0, v0, v3

    .line 111
    .line 112
    if-gez v0, :cond_4

    .line 113
    .line 114
    goto :goto_2

    .line 115
    :cond_4
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 116
    .line 117
    .line 118
    move-result v0

    .line 119
    if-eqz v0, :cond_5

    .line 120
    .line 121
    invoke-virtual {p0, p1}, Lcom/google/android/material/slider/BaseSlider;->isPotentialHorizontalScroll(Landroid/view/MotionEvent;)Z

    .line 122
    .line 123
    .line 124
    move-result v0

    .line 125
    if-eqz v0, :cond_5

    .line 126
    .line 127
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->touchDownAxis2:F

    .line 128
    .line 129
    sub-float/2addr v2, v0

    .line 130
    invoke-static {v2}, Ljava/lang/Math;->abs(F)F

    .line 131
    .line 132
    .line 133
    move-result v0

    .line 134
    int-to-float v2, v6

    .line 135
    const v3, 0x3f4ccccd    # 0.8f

    .line 136
    .line 137
    .line 138
    mul-float v2, v2, v3

    .line 139
    .line 140
    cmpg-float v0, v0, v2

    .line 141
    .line 142
    if-gez v0, :cond_5

    .line 143
    .line 144
    :goto_2
    return v1

    .line 145
    :cond_5
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 146
    .line 147
    .line 148
    move-result-object v0

    .line 149
    invoke-interface {v0, v5}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 150
    .line 151
    .line 152
    move-object v0, p0

    .line 153
    check-cast v0, Lcom/google/android/material/slider/Slider;

    .line 154
    .line 155
    invoke-virtual {v0}, Lcom/google/android/material/slider/Slider;->getActiveThumbIndex()I

    .line 156
    .line 157
    .line 158
    move-result v2

    .line 159
    if-eq v2, v4, :cond_6

    .line 160
    .line 161
    goto :goto_3

    .line 162
    :cond_6
    invoke-virtual {v0, v1}, Lcom/google/android/material/slider/BaseSlider;->setActiveThumbIndex(I)V

    .line 163
    .line 164
    .line 165
    :goto_3
    iput-boolean v5, p0, Lcom/google/android/material/slider/BaseSlider;->thumbIsPressed:Z

    .line 166
    .line 167
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateThumbWidthWhenPressed()V

    .line 168
    .line 169
    .line 170
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->onStartTrackingTouch()V

    .line 171
    .line 172
    .line 173
    :cond_7
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->snapTouchPosition()V

    .line 174
    .line 175
    .line 176
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateHaloHotspot()V

    .line 177
    .line 178
    .line 179
    invoke-virtual {p0}, Landroid/view/View;->invalidate()V

    .line 180
    .line 181
    .line 182
    goto/16 :goto_7

    .line 183
    .line 184
    :cond_8
    iput-boolean v1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbIsPressed:Z

    .line 185
    .line 186
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->lastEvent:Landroid/view/MotionEvent;

    .line 187
    .line 188
    if-eqz v0, :cond_a

    .line 189
    .line 190
    invoke-virtual {v0}, Landroid/view/MotionEvent;->getActionMasked()I

    .line 191
    .line 192
    .line 193
    move-result v0

    .line 194
    if-nez v0, :cond_a

    .line 195
    .line 196
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->lastEvent:Landroid/view/MotionEvent;

    .line 197
    .line 198
    invoke-virtual {v0}, Landroid/view/MotionEvent;->getX()F

    .line 199
    .line 200
    .line 201
    move-result v0

    .line 202
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    .line 203
    .line 204
    .line 205
    move-result v2

    .line 206
    sub-float/2addr v0, v2

    .line 207
    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    .line 208
    .line 209
    .line 210
    move-result v0

    .line 211
    int-to-float v2, v6

    .line 212
    cmpg-float v0, v0, v2

    .line 213
    .line 214
    if-gtz v0, :cond_a

    .line 215
    .line 216
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->lastEvent:Landroid/view/MotionEvent;

    .line 217
    .line 218
    invoke-virtual {v0}, Landroid/view/MotionEvent;->getY()F

    .line 219
    .line 220
    .line 221
    move-result v0

    .line 222
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    .line 223
    .line 224
    .line 225
    move-result v3

    .line 226
    sub-float/2addr v0, v3

    .line 227
    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    .line 228
    .line 229
    .line 230
    move-result v0

    .line 231
    cmpg-float v0, v0, v2

    .line 232
    .line 233
    if-gtz v0, :cond_a

    .line 234
    .line 235
    move-object v0, p0

    .line 236
    check-cast v0, Lcom/google/android/material/slider/Slider;

    .line 237
    .line 238
    invoke-virtual {v0}, Lcom/google/android/material/slider/Slider;->getActiveThumbIndex()I

    .line 239
    .line 240
    .line 241
    move-result v2

    .line 242
    if-eq v2, v4, :cond_9

    .line 243
    .line 244
    goto :goto_4

    .line 245
    :cond_9
    invoke-virtual {v0, v1}, Lcom/google/android/material/slider/BaseSlider;->setActiveThumbIndex(I)V

    .line 246
    .line 247
    .line 248
    :goto_4
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->onStartTrackingTouch()V

    .line 249
    .line 250
    .line 251
    :cond_a
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 252
    .line 253
    if-eq v0, v4, :cond_c

    .line 254
    .line 255
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->snapTouchPosition()V

    .line 256
    .line 257
    .line 258
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateHaloHotspot()V

    .line 259
    .line 260
    .line 261
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 262
    .line 263
    if-lez v0, :cond_b

    .line 264
    .line 265
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbWidth:I

    .line 266
    .line 267
    if-eq v0, v4, :cond_b

    .line 268
    .line 269
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbTrackGapSize:I

    .line 270
    .line 271
    if-eq v2, v4, :cond_b

    .line 272
    .line 273
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setThumbWidth(I)V

    .line 274
    .line 275
    .line 276
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbTrackGapSize:I

    .line 277
    .line 278
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setThumbTrackGapSize(I)V

    .line 279
    .line 280
    .line 281
    :cond_b
    iput v4, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 282
    .line 283
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->touchListeners:Ljava/util/ArrayList;

    .line 284
    .line 285
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 286
    .line 287
    .line 288
    move-result v2

    .line 289
    :goto_5
    if-ge v1, v2, :cond_c

    .line 290
    .line 291
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 292
    .line 293
    .line 294
    move-result-object v3

    .line 295
    add-int/lit8 v1, v1, 0x1

    .line 296
    .line 297
    check-cast v3, Lcom/google/android/material/slider/BaseOnSliderTouchListener;

    .line 298
    .line 299
    invoke-interface {v3, p0}, Lcom/google/android/material/slider/BaseOnSliderTouchListener;->onStopTrackingTouch(Ljava/lang/Object;)V

    .line 300
    .line 301
    .line 302
    goto :goto_5

    .line 303
    :cond_c
    invoke-virtual {p0}, Landroid/view/View;->invalidate()V

    .line 304
    .line 305
    .line 306
    goto :goto_7

    .line 307
    :cond_d
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->touchDownAxis1:F

    .line 308
    .line 309
    iput v2, p0, Lcom/google/android/material/slider/BaseSlider;->touchDownAxis2:F

    .line 310
    .line 311
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 312
    .line 313
    .line 314
    move-result v0

    .line 315
    if-nez v0, :cond_e

    .line 316
    .line 317
    invoke-virtual {p0, p1}, Lcom/google/android/material/slider/BaseSlider;->isPotentialVerticalScroll(Landroid/view/MotionEvent;)Z

    .line 318
    .line 319
    .line 320
    move-result v0

    .line 321
    if-eqz v0, :cond_e

    .line 322
    .line 323
    goto :goto_7

    .line 324
    :cond_e
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 325
    .line 326
    .line 327
    move-result v0

    .line 328
    if-eqz v0, :cond_f

    .line 329
    .line 330
    invoke-virtual {p0, p1}, Lcom/google/android/material/slider/BaseSlider;->isPotentialHorizontalScroll(Landroid/view/MotionEvent;)Z

    .line 331
    .line 332
    .line 333
    move-result v0

    .line 334
    if-eqz v0, :cond_f

    .line 335
    .line 336
    goto :goto_7

    .line 337
    :cond_f
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 338
    .line 339
    .line 340
    move-result-object v0

    .line 341
    invoke-interface {v0, v5}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 342
    .line 343
    .line 344
    move-object v0, p0

    .line 345
    check-cast v0, Lcom/google/android/material/slider/Slider;

    .line 346
    .line 347
    invoke-virtual {v0}, Lcom/google/android/material/slider/Slider;->getActiveThumbIndex()I

    .line 348
    .line 349
    .line 350
    move-result v2

    .line 351
    if-eq v2, v4, :cond_10

    .line 352
    .line 353
    goto :goto_6

    .line 354
    :cond_10
    invoke-virtual {v0, v1}, Lcom/google/android/material/slider/BaseSlider;->setActiveThumbIndex(I)V

    .line 355
    .line 356
    .line 357
    :goto_6
    invoke-virtual {p0}, Landroid/view/View;->requestFocus()Z

    .line 358
    .line 359
    .line 360
    iput-boolean v5, p0, Lcom/google/android/material/slider/BaseSlider;->thumbIsPressed:Z

    .line 361
    .line 362
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateThumbWidthWhenPressed()V

    .line 363
    .line 364
    .line 365
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->onStartTrackingTouch()V

    .line 366
    .line 367
    .line 368
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->snapTouchPosition()V

    .line 369
    .line 370
    .line 371
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateHaloHotspot()V

    .line 372
    .line 373
    .line 374
    invoke-virtual {p0}, Landroid/view/View;->invalidate()V

    .line 375
    .line 376
    .line 377
    :goto_7
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->thumbIsPressed:Z

    .line 378
    .line 379
    invoke-virtual {p0, v0}, Landroid/view/View;->setPressed(Z)V

    .line 380
    .line 381
    .line 382
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    .line 383
    .line 384
    .line 385
    move-result-object p1

    .line 386
    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->lastEvent:Landroid/view/MotionEvent;

    .line 387
    .line 388
    return v5
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

.method public final onVisibilityAggregated(Z)V
    .locals 0

    .line 1
    invoke-super {p0, p1}, Landroid/view/View;->onVisibilityAggregated(Z)V

    .line 2
    .line 3
    .line 4
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->thisAndAncestorsVisible:Z

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

.method public final onVisibilityChanged(Landroid/view/View;I)V
    .locals 3

    .line 1
    invoke-super {p0, p1, p2}, Landroid/view/View;->onVisibilityChanged(Landroid/view/View;I)V

    .line 2
    .line 3
    .line 4
    if-eqz p2, :cond_2

    .line 5
    .line 6
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Lcom/google/android/material/slider/BaseSlider;)Landroid/view/ViewGroup;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    if-nez p1, :cond_0

    .line 11
    .line 12
    const/4 p1, 0x0

    .line 13
    goto :goto_0

    .line 14
    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->getOverlay()Landroid/view/ViewOverlay;

    .line 15
    .line 16
    .line 17
    move-result-object p1

    .line 18
    :goto_0
    if-nez p1, :cond_1

    .line 19
    .line 20
    goto :goto_2

    .line 21
    :cond_1
    iget-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 22
    .line 23
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    .line 24
    .line 25
    .line 26
    move-result v0

    .line 27
    const/4 v1, 0x0

    .line 28
    :goto_1
    if-ge v1, v0, :cond_2

    .line 29
    .line 30
    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 31
    .line 32
    .line 33
    move-result-object v2

    .line 34
    add-int/lit8 v1, v1, 0x1

    .line 35
    .line 36
    check-cast v2, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 37
    .line 38
    invoke-virtual {p1, v2}, Landroid/view/ViewOverlay;->remove(Landroid/graphics/drawable/Drawable;)V

    .line 39
    .line 40
    .line 41
    goto :goto_1

    .line 42
    :cond_2
    :goto_2
    return-void
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

.method public setActiveThumbIndex(I)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 2
    .line 3
    return-void
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
.end method

.method public abstract setCentered(Z)V
.end method

.method public varargs setCustomThumbDrawablesForValues([I)V
    .locals 4

    .line 1
    array-length v0, p1

    new-array v0, v0, [Landroid/graphics/drawable/Drawable;

    const/4 v1, 0x0

    .line 2
    :goto_0
    array-length v2, p1

    if-ge v1, v2, :cond_0

    .line 3
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    aget v3, p1, v1

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    aput-object v2, v0, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 4
    :cond_0
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setCustomThumbDrawablesForValues([Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public varargs setCustomThumbDrawablesForValues([Landroid/graphics/drawable/Drawable;)V
    .locals 4

    const/4 v0, 0x0

    .line 5
    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->customThumbDrawable:Landroid/graphics/drawable/Drawable;

    .line 6
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->customThumbDrawablesForValues:Ljava/util/List;

    .line 7
    array-length v0, p1

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    aget-object v2, p1, v1

    .line 8
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->customThumbDrawablesForValues:Ljava/util/List;

    .line 9
    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v2

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 10
    invoke-virtual {p0, v2}, Lcom/google/android/material/slider/BaseSlider;->adjustCustomThumbDrawableBounds(Landroid/graphics/drawable/Drawable;)V

    .line 11
    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 12
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    return-void
.end method

.method public setEnabled(Z)V
    .locals 1

    .line 1
    invoke-super {p0, p1}, Landroid/view/View;->setEnabled(Z)V

    .line 2
    .line 3
    .line 4
    if-eqz p1, :cond_0

    .line 5
    .line 6
    const/4 p1, 0x0

    .line 7
    goto :goto_0

    .line 8
    :cond_0
    const/4 p1, 0x2

    .line 9
    :goto_0
    const/4 v0, 0x0

    .line 10
    invoke-virtual {p0, p1, v0}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

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
.end method

.method public abstract setHaloRadius(I)V
.end method

.method public abstract setHaloTintList(Landroid/content/res/ColorStateList;)V
.end method

.method public abstract setLabelBehavior(I)V
.end method

.method public abstract setOrientation(I)V
.end method

.method public setSeparationUnit(I)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->separationUnit:I

    .line 2
    .line 3
    const/4 p1, 0x1

    .line 4
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->dirtyConfig:Z

    .line 5
    .line 6
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    .line 7
    .line 8
    .line 9
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

.method public abstract setThumbElevation(F)V
.end method

.method public abstract setThumbHeight(I)V
.end method

.method public abstract setThumbStrokeColor(Landroid/content/res/ColorStateList;)V
.end method

.method public abstract setThumbStrokeWidth(F)V
.end method

.method public abstract setThumbTrackGapSize(I)V
.end method

.method public abstract setThumbWidth(I)V
.end method

.method public abstract setTickActiveRadius(I)V
.end method

.method public abstract setTickActiveTintList(Landroid/content/res/ColorStateList;)V
.end method

.method public abstract setTickInactiveRadius(I)V
.end method

.method public abstract setTickInactiveTintList(Landroid/content/res/ColorStateList;)V
.end method

.method public abstract setTrackActiveTintList(Landroid/content/res/ColorStateList;)V
.end method

.method public abstract setTrackCornerSize(I)V
.end method

.method public abstract setTrackHeight(I)V
.end method

.method public abstract setTrackIconActiveColor(Landroid/content/res/ColorStateList;)V
.end method

.method public abstract setTrackIconActiveEnd(Landroid/graphics/drawable/Drawable;)V
.end method

.method public abstract setTrackIconActiveStart(Landroid/graphics/drawable/Drawable;)V
.end method

.method public abstract setTrackIconInactiveColor(Landroid/content/res/ColorStateList;)V
.end method

.method public abstract setTrackIconInactiveEnd(Landroid/graphics/drawable/Drawable;)V
.end method

.method public abstract setTrackIconInactiveStart(Landroid/graphics/drawable/Drawable;)V
.end method

.method public abstract setTrackIconSize(I)V
.end method

.method public abstract setTrackInactiveTintList(Landroid/content/res/ColorStateList;)V
.end method

.method public abstract setTrackInsideCornerSize(I)V
.end method

.method public abstract setTrackStopIndicatorSize(I)V
.end method

.method public final setValueForLabel(Lcom/google/android/material/tooltip/TooltipDrawable;F)V
    .locals 4

    .line 1
    invoke-virtual {p0, p2}, Lcom/google/android/material/slider/BaseSlider;->formatValue(F)Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    iget-object v1, p1, Lcom/google/android/material/tooltip/TooltipDrawable;->text:Ljava/lang/CharSequence;

    .line 6
    .line 7
    invoke-static {v1, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    .line 8
    .line 9
    .line 10
    move-result v1

    .line 11
    if-nez v1, :cond_0

    .line 12
    .line 13
    iput-object v0, p1, Lcom/google/android/material/tooltip/TooltipDrawable;->text:Ljava/lang/CharSequence;

    .line 14
    .line 15
    iget-object v0, p1, Lcom/google/android/material/tooltip/TooltipDrawable;->textDrawableHelper:Lcom/google/android/material/internal/TextDrawableHelper;

    .line 16
    .line 17
    const/4 v1, 0x1

    .line 18
    iput-boolean v1, v0, Lcom/google/android/material/internal/TextDrawableHelper;->textSizeDirty:Z

    .line 19
    .line 20
    invoke-virtual {p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    .line 21
    .line 22
    .line 23
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 24
    .line 25
    .line 26
    move-result v0

    .line 27
    if-eqz v0, :cond_2

    .line 28
    .line 29
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 30
    .line 31
    invoke-virtual {p0, p2}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 32
    .line 33
    .line 34
    move-result p2

    .line 35
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 36
    .line 37
    int-to-float v1, v1

    .line 38
    mul-float p2, p2, v1

    .line 39
    .line 40
    float-to-int p2, p2

    .line 41
    add-int/2addr v0, p2

    .line 42
    invoke-virtual {p1}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicHeight()I

    .line 43
    .line 44
    .line 45
    move-result p2

    .line 46
    div-int/lit8 p2, p2, 0x2

    .line 47
    .line 48
    sub-int/2addr v0, p2

    .line 49
    invoke-virtual {p1}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicHeight()I

    .line 50
    .line 51
    .line 52
    move-result p2

    .line 53
    add-int/2addr p2, v0

    .line 54
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 55
    .line 56
    .line 57
    move-result v1

    .line 58
    if-eqz v1, :cond_1

    .line 59
    .line 60
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    .line 61
    .line 62
    .line 63
    move-result v1

    .line 64
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbHeight:I

    .line 65
    .line 66
    div-int/lit8 v2, v2, 0x2

    .line 67
    .line 68
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->labelPadding:I

    .line 69
    .line 70
    add-int/2addr v2, v3

    .line 71
    sub-int/2addr v1, v2

    .line 72
    invoke-virtual {p1}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicWidth()I

    .line 73
    .line 74
    .line 75
    move-result v2

    .line 76
    :goto_0
    sub-int v2, v1, v2

    .line 77
    .line 78
    goto :goto_1

    .line 79
    :cond_1
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    .line 80
    .line 81
    .line 82
    move-result v1

    .line 83
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbHeight:I

    .line 84
    .line 85
    div-int/lit8 v2, v2, 0x2

    .line 86
    .line 87
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->labelPadding:I

    .line 88
    .line 89
    add-int/2addr v2, v3

    .line 90
    add-int/2addr v2, v1

    .line 91
    invoke-virtual {p1}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicWidth()I

    .line 92
    .line 93
    .line 94
    move-result v1

    .line 95
    add-int/2addr v1, v2

    .line 96
    goto :goto_1

    .line 97
    :cond_2
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 98
    .line 99
    invoke-virtual {p0, p2}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 100
    .line 101
    .line 102
    move-result p2

    .line 103
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 104
    .line 105
    int-to-float v1, v1

    .line 106
    mul-float p2, p2, v1

    .line 107
    .line 108
    float-to-int p2, p2

    .line 109
    add-int/2addr v0, p2

    .line 110
    invoke-virtual {p1}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicWidth()I

    .line 111
    .line 112
    .line 113
    move-result p2

    .line 114
    div-int/lit8 p2, p2, 0x2

    .line 115
    .line 116
    sub-int/2addr v0, p2

    .line 117
    invoke-virtual {p1}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicWidth()I

    .line 118
    .line 119
    .line 120
    move-result p2

    .line 121
    add-int/2addr p2, v0

    .line 122
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    .line 123
    .line 124
    .line 125
    move-result v1

    .line 126
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbHeight:I

    .line 127
    .line 128
    div-int/lit8 v2, v2, 0x2

    .line 129
    .line 130
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->labelPadding:I

    .line 131
    .line 132
    add-int/2addr v2, v3

    .line 133
    sub-int/2addr v1, v2

    .line 134
    invoke-virtual {p1}, Lcom/google/android/material/tooltip/TooltipDrawable;->getIntrinsicHeight()I

    .line 135
    .line 136
    .line 137
    move-result v2

    .line 138
    goto :goto_0

    .line 139
    :goto_1
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->labelRect:Landroid/graphics/Rect;

    .line 140
    .line 141
    invoke-virtual {v3, v0, v2, p2, v1}, Landroid/graphics/Rect;->set(IIII)V

    .line 142
    .line 143
    .line 144
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 145
    .line 146
    .line 147
    move-result p2

    .line 148
    if-eqz p2, :cond_3

    .line 149
    .line 150
    new-instance p2, Landroid/graphics/RectF;

    .line 151
    .line 152
    invoke-direct {p2, v3}, Landroid/graphics/RectF;-><init>(Landroid/graphics/Rect;)V

    .line 153
    .line 154
    .line 155
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 156
    .line 157
    invoke-virtual {v0, p2}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 158
    .line 159
    .line 160
    invoke-virtual {p2, v3}, Landroid/graphics/RectF;->round(Landroid/graphics/Rect;)V

    .line 161
    .line 162
    .line 163
    :cond_3
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Lcom/google/android/material/slider/BaseSlider;)Landroid/view/ViewGroup;

    .line 164
    .line 165
    .line 166
    move-result-object p2

    .line 167
    invoke-static {p2, p0, v3}, Lcom/google/android/material/internal/DescendantOffsetUtils;->offsetDescendantRect(Landroid/view/ViewGroup;Landroid/view/View;Landroid/graphics/Rect;)V

    .line 168
    .line 169
    .line 170
    invoke-virtual {p1, v3}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 171
    .line 172
    .line 173
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Lcom/google/android/material/slider/BaseSlider;)Landroid/view/ViewGroup;

    .line 174
    .line 175
    .line 176
    move-result-object p2

    .line 177
    if-nez p2, :cond_4

    .line 178
    .line 179
    const/4 p2, 0x0

    .line 180
    goto :goto_2

    .line 181
    :cond_4
    invoke-virtual {p2}, Landroid/view/View;->getOverlay()Landroid/view/ViewOverlay;

    .line 182
    .line 183
    .line 184
    move-result-object p2

    .line 185
    :goto_2
    if-nez p2, :cond_5

    .line 186
    .line 187
    return-void

    .line 188
    :cond_5
    invoke-virtual {p2, p1}, Landroid/view/ViewOverlay;->add(Landroid/graphics/drawable/Drawable;)V

    .line 189
    .line 190
    .line 191
    return-void
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

.method public setValues(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/Float;",
            ">;)V"
        }
    .end annotation

    .line 4
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setValuesInternal(Ljava/util/ArrayList;)V

    return-void
.end method

.method public varargs setValues([Ljava/lang/Float;)V
    .locals 1

    .line 1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 2
    invoke-static {v0, p1}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 3
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setValuesInternal(Ljava/util/ArrayList;)V

    return-void
.end method

.method public final setValuesInternal(Ljava/util/ArrayList;)V
    .locals 10

    .line 1
    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-nez v0, :cond_12

    .line 6
    .line 7
    invoke-static {p1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 8
    .line 9
    .line 10
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 11
    .line 12
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 17
    .line 18
    .line 19
    move-result v1

    .line 20
    if-ne v0, v1, :cond_0

    .line 21
    .line 22
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 23
    .line 24
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->equals(Ljava/lang/Object;)Z

    .line 25
    .line 26
    .line 27
    move-result v0

    .line 28
    if-eqz v0, :cond_0

    .line 29
    .line 30
    return-void

    .line 31
    :cond_0
    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 32
    .line 33
    const/4 p1, 0x1

    .line 34
    iput-boolean p1, p0, Lcom/google/android/material/slider/BaseSlider;->dirtyConfig:Z

    .line 35
    .line 36
    const/4 v0, 0x0

    .line 37
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 38
    .line 39
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateHaloHotspot()V

    .line 40
    .line 41
    .line 42
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 43
    .line 44
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 45
    .line 46
    .line 47
    move-result v2

    .line 48
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 49
    .line 50
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 51
    .line 52
    .line 53
    move-result v3

    .line 54
    if-le v2, v3, :cond_4

    .line 55
    .line 56
    iget-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 57
    .line 58
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 59
    .line 60
    .line 61
    move-result v2

    .line 62
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 63
    .line 64
    .line 65
    move-result v3

    .line 66
    invoke-virtual {v1, v2, v3}, Ljava/util/ArrayList;->subList(II)Ljava/util/List;

    .line 67
    .line 68
    .line 69
    move-result-object v2

    .line 70
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 71
    .line 72
    .line 73
    move-result-object v3

    .line 74
    :cond_1
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    .line 75
    .line 76
    .line 77
    move-result v4

    .line 78
    if-eqz v4, :cond_3

    .line 79
    .line 80
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 81
    .line 82
    .line 83
    move-result-object v4

    .line 84
    check-cast v4, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 85
    .line 86
    invoke-virtual {p0}, Landroid/view/View;->isAttachedToWindow()Z

    .line 87
    .line 88
    .line 89
    move-result v5

    .line 90
    if-eqz v5, :cond_1

    .line 91
    .line 92
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Lcom/google/android/material/slider/BaseSlider;)Landroid/view/ViewGroup;

    .line 93
    .line 94
    .line 95
    move-result-object v5

    .line 96
    if-nez v5, :cond_2

    .line 97
    .line 98
    goto :goto_0

    .line 99
    :cond_2
    invoke-virtual {v5}, Landroid/view/View;->getOverlay()Landroid/view/ViewOverlay;

    .line 100
    .line 101
    .line 102
    move-result-object v6

    .line 103
    invoke-virtual {v6, v4}, Landroid/view/ViewOverlay;->remove(Landroid/graphics/drawable/Drawable;)V

    .line 104
    .line 105
    .line 106
    iget-object v4, v4, Lcom/google/android/material/tooltip/TooltipDrawable;->attachedViewLayoutChangeListener:Landroidx/appcompat/widget/SearchView$4;

    .line 107
    .line 108
    invoke-virtual {v5, v4}, Landroid/view/View;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 109
    .line 110
    .line 111
    goto :goto_0

    .line 112
    :cond_3
    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 113
    .line 114
    .line 115
    :cond_4
    :goto_1
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 116
    .line 117
    .line 118
    move-result v2

    .line 119
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 120
    .line 121
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 122
    .line 123
    .line 124
    move-result v3

    .line 125
    if-ge v2, v3, :cond_d

    .line 126
    .line 127
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 128
    .line 129
    .line 130
    move-result-object v2

    .line 131
    new-instance v3, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 132
    .line 133
    iget v8, p0, Lcom/google/android/material/slider/BaseSlider;->labelStyle:I

    .line 134
    .line 135
    invoke-direct {v3, v2, v8}, Lcom/google/android/material/tooltip/TooltipDrawable;-><init>(Landroid/content/Context;I)V

    .line 136
    .line 137
    .line 138
    sget-object v6, Lcom/google/android/material/R$styleable;->Tooltip:[I

    .line 139
    .line 140
    new-array v9, v0, [I

    .line 141
    .line 142
    iget-object v4, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->context:Landroid/content/Context;

    .line 143
    .line 144
    const/4 v5, 0x0

    .line 145
    const/4 v7, 0x0

    .line 146
    invoke-static/range {v4 .. v9}, Lcom/google/android/material/internal/ViewUtils;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[III[I)Landroid/content/res/TypedArray;

    .line 147
    .line 148
    .line 149
    move-result-object v2

    .line 150
    iget-object v4, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->context:Landroid/content/Context;

    .line 151
    .line 152
    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 153
    .line 154
    .line 155
    move-result-object v5

    .line 156
    const v6, 0x7f070403

    .line 157
    .line 158
    .line 159
    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 160
    .line 161
    .line 162
    move-result v5

    .line 163
    iput v5, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->arrowSize:I

    .line 164
    .line 165
    const/16 v5, 0x8

    .line 166
    .line 167
    invoke-virtual {v2, v5, p1}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    .line 168
    .line 169
    .line 170
    move-result v5

    .line 171
    iput-boolean v5, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->showMarker:Z

    .line 172
    .line 173
    if-eqz v5, :cond_5

    .line 174
    .line 175
    iget-object v5, v3, Lcom/google/android/material/shape/MaterialShapeDrawable;->drawableState:Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;

    .line 176
    .line 177
    iget-object v5, v5, Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 178
    .line 179
    invoke-virtual {v5}, Lcom/google/android/material/shape/ShapeAppearanceModel;->toBuilder()Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    .line 180
    .line 181
    .line 182
    move-result-object v5

    .line 183
    invoke-virtual {v3}, Lcom/google/android/material/tooltip/TooltipDrawable;->createMarkerEdge()Lcom/google/android/material/shape/OffsetEdgeTreatment;

    .line 184
    .line 185
    .line 186
    move-result-object v6

    .line 187
    iput-object v6, v5, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->bottomEdge:Landroidx/transition/ViewUtilsApi21;

    .line 188
    .line 189
    invoke-virtual {v5}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 190
    .line 191
    .line 192
    move-result-object v5

    .line 193
    invoke-virtual {v3, v5}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    .line 194
    .line 195
    .line 196
    goto :goto_2

    .line 197
    :cond_5
    iput v0, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->arrowSize:I

    .line 198
    .line 199
    :goto_2
    const/4 v5, 0x6

    .line 200
    invoke-virtual {v2, v5}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    .line 201
    .line 202
    .line 203
    move-result-object v5

    .line 204
    iget-object v6, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->text:Ljava/lang/CharSequence;

    .line 205
    .line 206
    invoke-static {v6, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    .line 207
    .line 208
    .line 209
    move-result v6

    .line 210
    iget-object v7, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->textDrawableHelper:Lcom/google/android/material/internal/TextDrawableHelper;

    .line 211
    .line 212
    if-nez v6, :cond_6

    .line 213
    .line 214
    iput-object v5, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->text:Ljava/lang/CharSequence;

    .line 215
    .line 216
    iput-boolean p1, v7, Lcom/google/android/material/internal/TextDrawableHelper;->textSizeDirty:Z

    .line 217
    .line 218
    invoke-virtual {v3}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    .line 219
    .line 220
    .line 221
    :cond_6
    invoke-virtual {v2, v0}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 222
    .line 223
    .line 224
    move-result v5

    .line 225
    if-eqz v5, :cond_7

    .line 226
    .line 227
    invoke-virtual {v2, v0, v0}, Landroid/content/res/TypedArray;->getResourceId(II)I

    .line 228
    .line 229
    .line 230
    move-result v5

    .line 231
    if-eqz v5, :cond_7

    .line 232
    .line 233
    new-instance v6, Lcom/google/android/material/resources/TextAppearance;

    .line 234
    .line 235
    invoke-direct {v6, v4, v5}, Lcom/google/android/material/resources/TextAppearance;-><init>(Landroid/content/Context;I)V

    .line 236
    .line 237
    .line 238
    goto :goto_3

    .line 239
    :cond_7
    const/4 v6, 0x0

    .line 240
    :goto_3
    if-eqz v6, :cond_8

    .line 241
    .line 242
    invoke-virtual {v2, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 243
    .line 244
    .line 245
    move-result v5

    .line 246
    if-eqz v5, :cond_8

    .line 247
    .line 248
    invoke-static {v4, v2, p1}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 249
    .line 250
    .line 251
    move-result-object v5

    .line 252
    iput-object v5, v6, Lcom/google/android/material/resources/TextAppearance;->textColor:Landroid/content/res/ColorStateList;

    .line 253
    .line 254
    :cond_8
    invoke-virtual {v7, v6, v4}, Lcom/google/android/material/internal/TextDrawableHelper;->setTextAppearance(Lcom/google/android/material/resources/TextAppearance;Landroid/content/Context;)V

    .line 255
    .line 256
    .line 257
    const v5, 0x7f040113

    .line 258
    .line 259
    .line 260
    const-class v6, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 261
    .line 262
    invoke-virtual {v6}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    .line 263
    .line 264
    .line 265
    move-result-object v7

    .line 266
    invoke-static {v5, v4, v7}, Lkotlin/LazyKt__LazyJVMKt;->resolveTypedValueOrThrow(ILandroid/content/Context;Ljava/lang/String;)Landroid/util/TypedValue;

    .line 267
    .line 268
    .line 269
    move-result-object v5

    .line 270
    iget v7, v5, Landroid/util/TypedValue;->resourceId:I

    .line 271
    .line 272
    if-eqz v7, :cond_9

    .line 273
    .line 274
    invoke-static {v4, v7}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 275
    .line 276
    .line 277
    move-result v5

    .line 278
    goto :goto_4

    .line 279
    :cond_9
    iget v5, v5, Landroid/util/TypedValue;->data:I

    .line 280
    .line 281
    :goto_4
    const v7, 0x1010031

    .line 282
    .line 283
    .line 284
    invoke-virtual {v6}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    .line 285
    .line 286
    .line 287
    move-result-object v8

    .line 288
    invoke-static {v7, v4, v8}, Lkotlin/LazyKt__LazyJVMKt;->resolveTypedValueOrThrow(ILandroid/content/Context;Ljava/lang/String;)Landroid/util/TypedValue;

    .line 289
    .line 290
    .line 291
    move-result-object v7

    .line 292
    iget v8, v7, Landroid/util/TypedValue;->resourceId:I

    .line 293
    .line 294
    if-eqz v8, :cond_a

    .line 295
    .line 296
    invoke-static {v4, v8}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 297
    .line 298
    .line 299
    move-result v7

    .line 300
    goto :goto_5

    .line 301
    :cond_a
    iget v7, v7, Landroid/util/TypedValue;->data:I

    .line 302
    .line 303
    :goto_5
    const/16 v8, 0xe5

    .line 304
    .line 305
    invoke-static {v7, v8}, Landroidx/core/graphics/ColorUtils;->setAlphaComponent(II)I

    .line 306
    .line 307
    .line 308
    move-result v7

    .line 309
    const/16 v8, 0x99

    .line 310
    .line 311
    invoke-static {v5, v8}, Landroidx/core/graphics/ColorUtils;->setAlphaComponent(II)I

    .line 312
    .line 313
    .line 314
    move-result v5

    .line 315
    invoke-static {v5, v7}, Landroidx/core/graphics/ColorUtils;->compositeColors(II)I

    .line 316
    .line 317
    .line 318
    move-result v5

    .line 319
    const/4 v7, 0x7

    .line 320
    invoke-virtual {v2, v7, v5}, Landroid/content/res/TypedArray;->getColor(II)I

    .line 321
    .line 322
    .line 323
    move-result v5

    .line 324
    invoke-static {v5}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    .line 325
    .line 326
    .line 327
    move-result-object v5

    .line 328
    invoke-virtual {v3, v5}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setFillColor(Landroid/content/res/ColorStateList;)V

    .line 329
    .line 330
    .line 331
    const v5, 0x7f040139

    .line 332
    .line 333
    .line 334
    invoke-virtual {v6}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    .line 335
    .line 336
    .line 337
    move-result-object v6

    .line 338
    invoke-static {v5, v4, v6}, Lkotlin/LazyKt__LazyJVMKt;->resolveTypedValueOrThrow(ILandroid/content/Context;Ljava/lang/String;)Landroid/util/TypedValue;

    .line 339
    .line 340
    .line 341
    move-result-object v5

    .line 342
    iget v6, v5, Landroid/util/TypedValue;->resourceId:I

    .line 343
    .line 344
    if-eqz v6, :cond_b

    .line 345
    .line 346
    invoke-static {v4, v6}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 347
    .line 348
    .line 349
    move-result v4

    .line 350
    goto :goto_6

    .line 351
    :cond_b
    iget v4, v5, Landroid/util/TypedValue;->data:I

    .line 352
    .line 353
    :goto_6
    invoke-static {v4}, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;

    .line 354
    .line 355
    .line 356
    move-result-object v4

    .line 357
    invoke-virtual {v3, v4}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setStrokeColor(Landroid/content/res/ColorStateList;)V

    .line 358
    .line 359
    .line 360
    const/4 v4, 0x2

    .line 361
    invoke-virtual {v2, v4, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 362
    .line 363
    .line 364
    move-result v5

    .line 365
    iput v5, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->padding:I

    .line 366
    .line 367
    const/4 v5, 0x4

    .line 368
    invoke-virtual {v2, v5, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 369
    .line 370
    .line 371
    move-result v5

    .line 372
    iput v5, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->minWidth:I

    .line 373
    .line 374
    const/4 v5, 0x5

    .line 375
    invoke-virtual {v2, v5, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 376
    .line 377
    .line 378
    move-result v5

    .line 379
    iput v5, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->minHeight:I

    .line 380
    .line 381
    const/4 v5, 0x3

    .line 382
    invoke-virtual {v2, v5, v0}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 383
    .line 384
    .line 385
    move-result v5

    .line 386
    iput v5, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->layoutMargin:I

    .line 387
    .line 388
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 389
    .line 390
    .line 391
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 392
    .line 393
    .line 394
    invoke-virtual {p0}, Landroid/view/View;->isAttachedToWindow()Z

    .line 395
    .line 396
    .line 397
    move-result v2

    .line 398
    if-eqz v2, :cond_4

    .line 399
    .line 400
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Lcom/google/android/material/slider/BaseSlider;)Landroid/view/ViewGroup;

    .line 401
    .line 402
    .line 403
    move-result-object v2

    .line 404
    if-nez v2, :cond_c

    .line 405
    .line 406
    goto/16 :goto_1

    .line 407
    .line 408
    :cond_c
    new-array v4, v4, [I

    .line 409
    .line 410
    invoke-virtual {v2, v4}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 411
    .line 412
    .line 413
    aget v4, v4, v0

    .line 414
    .line 415
    iput v4, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->locationOnScreenX:I

    .line 416
    .line 417
    iget-object v4, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->displayFrame:Landroid/graphics/Rect;

    .line 418
    .line 419
    invoke-virtual {v2, v4}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 420
    .line 421
    .line 422
    iget-object v3, v3, Lcom/google/android/material/tooltip/TooltipDrawable;->attachedViewLayoutChangeListener:Landroidx/appcompat/widget/SearchView$4;

    .line 423
    .line 424
    invoke-virtual {v2, v3}, Landroid/view/View;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 425
    .line 426
    .line 427
    goto/16 :goto_1

    .line 428
    .line 429
    :cond_d
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 430
    .line 431
    .line 432
    move-result v2

    .line 433
    if-ne v2, p1, :cond_e

    .line 434
    .line 435
    const/4 p1, 0x0

    .line 436
    :cond_e
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 437
    .line 438
    .line 439
    move-result v2

    .line 440
    const/4 v3, 0x0

    .line 441
    :goto_7
    if-ge v3, v2, :cond_f

    .line 442
    .line 443
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 444
    .line 445
    .line 446
    move-result-object v4

    .line 447
    add-int/lit8 v3, v3, 0x1

    .line 448
    .line 449
    check-cast v4, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 450
    .line 451
    int-to-float v5, p1

    .line 452
    iget-object v6, v4, Lcom/google/android/material/shape/MaterialShapeDrawable;->drawableState:Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;

    .line 453
    .line 454
    iput v5, v6, Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;->strokeWidth:F

    .line 455
    .line 456
    invoke-virtual {v4}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    .line 457
    .line 458
    .line 459
    goto :goto_7

    .line 460
    :cond_f
    iget-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->changeListeners:Ljava/util/ArrayList;

    .line 461
    .line 462
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 463
    .line 464
    .line 465
    move-result v1

    .line 466
    const/4 v2, 0x0

    .line 467
    :cond_10
    if-ge v2, v1, :cond_11

    .line 468
    .line 469
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 470
    .line 471
    .line 472
    move-result-object v3

    .line 473
    add-int/lit8 v2, v2, 0x1

    .line 474
    .line 475
    check-cast v3, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;

    .line 476
    .line 477
    iget-object v4, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 478
    .line 479
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    .line 480
    .line 481
    .line 482
    move-result v5

    .line 483
    const/4 v6, 0x0

    .line 484
    :goto_8
    if-ge v6, v5, :cond_10

    .line 485
    .line 486
    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 487
    .line 488
    .line 489
    move-result-object v7

    .line 490
    add-int/lit8 v6, v6, 0x1

    .line 491
    .line 492
    check-cast v7, Ljava/lang/Float;

    .line 493
    .line 494
    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    .line 495
    .line 496
    .line 497
    move-result v7

    .line 498
    invoke-virtual {v3, p0, v7, v0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->onValueChange(Lcom/google/android/material/slider/BaseSlider;FZ)V

    .line 499
    .line 500
    .line 501
    goto :goto_8

    .line 502
    :cond_11
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    .line 503
    .line 504
    .line 505
    return-void

    .line 506
    :cond_12
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 507
    .line 508
    const-string v0, "At least one value must be set"

    .line 509
    .line 510
    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 511
    .line 512
    .line 513
    throw p1
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

.method public final snapThumbToValue(IF)Z
    .locals 6

    .line 1
    iput p1, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 2
    .line 3
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 4
    .line 5
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    check-cast v0, Ljava/lang/Float;

    .line 10
    .line 11
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    sub-float v0, p2, v0

    .line 16
    .line 17
    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    float-to-double v0, v0

    .line 22
    const-wide v2, 0x3f1a36e2eb1c432dL    # 1.0E-4

    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    const/4 v4, 0x0

    .line 28
    cmpg-double v5, v0, v2

    .line 29
    .line 30
    if-gez v5, :cond_0

    .line 31
    .line 32
    return v4

    .line 33
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->getMinSeparation()F

    .line 34
    .line 35
    .line 36
    move-result v0

    .line 37
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->separationUnit:I

    .line 38
    .line 39
    if-nez v1, :cond_2

    .line 40
    .line 41
    const/4 v1, 0x0

    .line 42
    cmpl-float v2, v0, v1

    .line 43
    .line 44
    if-nez v2, :cond_1

    .line 45
    .line 46
    const/4 v0, 0x0

    .line 47
    goto :goto_0

    .line 48
    :cond_1
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 49
    .line 50
    int-to-float v1, v1

    .line 51
    sub-float/2addr v0, v1

    .line 52
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 53
    .line 54
    int-to-float v1, v1

    .line 55
    div-float/2addr v0, v1

    .line 56
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 57
    .line 58
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 59
    .line 60
    sub-float v2, v1, v2

    .line 61
    .line 62
    mul-float v2, v2, v0

    .line 63
    .line 64
    add-float/2addr v2, v1

    .line 65
    move v0, v2

    .line 66
    :cond_2
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 67
    .line 68
    .line 69
    move-result v1

    .line 70
    if-nez v1, :cond_3

    .line 71
    .line 72
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 73
    .line 74
    .line 75
    move-result v1

    .line 76
    if-eqz v1, :cond_4

    .line 77
    .line 78
    :cond_3
    neg-float v0, v0

    .line 79
    :cond_4
    add-int/lit8 v1, p1, 0x1

    .line 80
    .line 81
    iget-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 82
    .line 83
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 84
    .line 85
    .line 86
    move-result v2

    .line 87
    if-lt v1, v2, :cond_5

    .line 88
    .line 89
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 90
    .line 91
    goto :goto_1

    .line 92
    :cond_5
    iget-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 93
    .line 94
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 95
    .line 96
    .line 97
    move-result-object v1

    .line 98
    check-cast v1, Ljava/lang/Float;

    .line 99
    .line 100
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    .line 101
    .line 102
    .line 103
    move-result v1

    .line 104
    sub-float/2addr v1, v0

    .line 105
    :goto_1
    add-int/lit8 v2, p1, -0x1

    .line 106
    .line 107
    if-gez v2, :cond_6

    .line 108
    .line 109
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 110
    .line 111
    goto :goto_2

    .line 112
    :cond_6
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 113
    .line 114
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 115
    .line 116
    .line 117
    move-result-object v2

    .line 118
    check-cast v2, Ljava/lang/Float;

    .line 119
    .line 120
    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    .line 121
    .line 122
    .line 123
    move-result v2

    .line 124
    add-float/2addr v0, v2

    .line 125
    :goto_2
    invoke-static {p2, v0, v1}, Landroidx/core/os/BundleKt;->clamp(FFF)F

    .line 126
    .line 127
    .line 128
    move-result p2

    .line 129
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 130
    .line 131
    invoke-static {p2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    .line 132
    .line 133
    .line 134
    move-result-object p2

    .line 135
    invoke-virtual {v0, p1, p2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 136
    .line 137
    .line 138
    iget-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->changeListeners:Ljava/util/ArrayList;

    .line 139
    .line 140
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    .line 141
    .line 142
    .line 143
    move-result v0

    .line 144
    :goto_3
    const/4 v1, 0x1

    .line 145
    if-ge v4, v0, :cond_7

    .line 146
    .line 147
    invoke-virtual {p2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 148
    .line 149
    .line 150
    move-result-object v2

    .line 151
    add-int/lit8 v4, v4, 0x1

    .line 152
    .line 153
    check-cast v2, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;

    .line 154
    .line 155
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 156
    .line 157
    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 158
    .line 159
    .line 160
    move-result-object v3

    .line 161
    check-cast v3, Ljava/lang/Float;

    .line 162
    .line 163
    invoke-virtual {v3}, Ljava/lang/Float;->floatValue()F

    .line 164
    .line 165
    .line 166
    move-result v3

    .line 167
    invoke-virtual {v2, p0, v3, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;->onValueChange(Lcom/google/android/material/slider/BaseSlider;FZ)V

    .line 168
    .line 169
    .line 170
    goto :goto_3

    .line 171
    :cond_7
    iget-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    .line 172
    .line 173
    if-eqz p2, :cond_9

    .line 174
    .line 175
    invoke-virtual {p2}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    .line 176
    .line 177
    .line 178
    move-result p2

    .line 179
    if-eqz p2, :cond_9

    .line 180
    .line 181
    iget-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityEventSender:Landroidx/core/provider/CallbackWithHandler$2;

    .line 182
    .line 183
    if-nez p2, :cond_8

    .line 184
    .line 185
    new-instance p2, Landroidx/core/provider/CallbackWithHandler$2;

    .line 186
    .line 187
    invoke-direct {p2, p0}, Landroidx/core/provider/CallbackWithHandler$2;-><init>(Lcom/google/android/material/slider/BaseSlider;)V

    .line 188
    .line 189
    .line 190
    iput-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityEventSender:Landroidx/core/provider/CallbackWithHandler$2;

    .line 191
    .line 192
    goto :goto_4

    .line 193
    :cond_8
    invoke-virtual {p0, p2}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 194
    .line 195
    .line 196
    :goto_4
    iget-object p2, p0, Lcom/google/android/material/slider/BaseSlider;->accessibilityEventSender:Landroidx/core/provider/CallbackWithHandler$2;

    .line 197
    .line 198
    iput p1, p2, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    .line 199
    .line 200
    const-wide/16 v2, 0xc8

    .line 201
    .line 202
    invoke-virtual {p0, p2, v2, v3}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 203
    .line 204
    .line 205
    :cond_9
    return v1
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

.method public final snapTouchPosition()V
    .locals 6

    .line 1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->touchPosition:F

    .line 2
    .line 3
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    cmpl-float v2, v1, v2

    .line 7
    .line 8
    if-lez v2, :cond_0

    .line 9
    .line 10
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 11
    .line 12
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 13
    .line 14
    sub-float/2addr v2, v3

    .line 15
    div-float/2addr v2, v1

    .line 16
    float-to-int v1, v2

    .line 17
    int-to-float v2, v1

    .line 18
    mul-float v0, v0, v2

    .line 19
    .line 20
    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    .line 21
    .line 22
    .line 23
    move-result v0

    .line 24
    int-to-double v2, v0

    .line 25
    int-to-double v0, v1

    .line 26
    div-double/2addr v2, v0

    .line 27
    goto :goto_0

    .line 28
    :cond_0
    float-to-double v2, v0

    .line 29
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 30
    .line 31
    .line 32
    move-result v0

    .line 33
    if-nez v0, :cond_1

    .line 34
    .line 35
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 36
    .line 37
    .line 38
    move-result v0

    .line 39
    if-eqz v0, :cond_2

    .line 40
    .line 41
    :cond_1
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    .line 42
    .line 43
    sub-double v2, v0, v2

    .line 44
    .line 45
    :cond_2
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 46
    .line 47
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 48
    .line 49
    sub-float/2addr v0, v1

    .line 50
    float-to-double v4, v0

    .line 51
    mul-double v2, v2, v4

    .line 52
    .line 53
    float-to-double v0, v1

    .line 54
    add-double/2addr v2, v0

    .line 55
    double-to-float v0, v2

    .line 56
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 57
    .line 58
    invoke-virtual {p0, v1, v0}, Lcom/google/android/material/slider/BaseSlider;->snapThumbToValue(IF)Z

    .line 59
    .line 60
    .line 61
    return-void
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
.end method

.method public final updateBoundsForVirtualViewId(ILandroid/graphics/Rect;)V
    .locals 6

    .line 1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 2
    .line 3
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->getValues()Ljava/util/List;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    check-cast p1, Ljava/lang/Float;

    .line 12
    .line 13
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    .line 14
    .line 15
    .line 16
    move-result p1

    .line 17
    invoke-virtual {p0, p1}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 18
    .line 19
    .line 20
    move-result p1

    .line 21
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 22
    .line 23
    int-to-float v1, v1

    .line 24
    mul-float p1, p1, v1

    .line 25
    .line 26
    float-to-int p1, p1

    .line 27
    add-int/2addr v0, p1

    .line 28
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    .line 29
    .line 30
    .line 31
    move-result p1

    .line 32
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 33
    .line 34
    div-int/lit8 v1, v1, 0x2

    .line 35
    .line 36
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->minTouchTargetSize:I

    .line 37
    .line 38
    div-int/lit8 v2, v2, 0x2

    .line 39
    .line 40
    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    .line 41
    .line 42
    .line 43
    move-result v1

    .line 44
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbHeight:I

    .line 45
    .line 46
    div-int/lit8 v2, v2, 0x2

    .line 47
    .line 48
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->minTouchTargetSize:I

    .line 49
    .line 50
    div-int/lit8 v3, v3, 0x2

    .line 51
    .line 52
    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    .line 53
    .line 54
    .line 55
    move-result v2

    .line 56
    new-instance v3, Landroid/graphics/RectF;

    .line 57
    .line 58
    sub-int v4, v0, v1

    .line 59
    .line 60
    int-to-float v4, v4

    .line 61
    sub-int v5, p1, v2

    .line 62
    .line 63
    int-to-float v5, v5

    .line 64
    add-int/2addr v0, v1

    .line 65
    int-to-float v0, v0

    .line 66
    add-int/2addr p1, v2

    .line 67
    int-to-float p1, p1

    .line 68
    invoke-direct {v3, v4, v5, v0, p1}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 69
    .line 70
    .line 71
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 72
    .line 73
    .line 74
    move-result p1

    .line 75
    if-eqz p1, :cond_0

    .line 76
    .line 77
    iget-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 78
    .line 79
    invoke-virtual {p1, v3}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 80
    .line 81
    .line 82
    :cond_0
    iget p1, v3, Landroid/graphics/RectF;->left:F

    .line 83
    .line 84
    float-to-int p1, p1

    .line 85
    iget v0, v3, Landroid/graphics/RectF;->top:F

    .line 86
    .line 87
    float-to-int v0, v0

    .line 88
    iget v1, v3, Landroid/graphics/RectF;->right:F

    .line 89
    .line 90
    float-to-int v1, v1

    .line 91
    iget v2, v3, Landroid/graphics/RectF;->bottom:F

    .line 92
    .line 93
    float-to-int v2, v2

    .line 94
    invoke-virtual {p2, p1, v0, v1, v2}, Landroid/graphics/Rect;->set(IIII)V

    .line 95
    .line 96
    .line 97
    return-void
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

.method public final updateHaloHotspot()V
    .locals 7

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    instance-of v0, v0, Landroid/graphics/drawable/RippleDrawable;

    .line 6
    .line 7
    if-eqz v0, :cond_1

    .line 8
    .line 9
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredWidth()I

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    if-lez v0, :cond_1

    .line 14
    .line 15
    invoke-virtual {p0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    instance-of v1, v0, Landroid/graphics/drawable/RippleDrawable;

    .line 20
    .line 21
    if-eqz v1, :cond_1

    .line 22
    .line 23
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 24
    .line 25
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->focusedThumbIdx:I

    .line 26
    .line 27
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    check-cast v1, Ljava/lang/Float;

    .line 32
    .line 33
    invoke-virtual {v1}, Ljava/lang/Float;->floatValue()F

    .line 34
    .line 35
    .line 36
    move-result v1

    .line 37
    invoke-virtual {p0, v1}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 38
    .line 39
    .line 40
    move-result v1

    .line 41
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 42
    .line 43
    int-to-float v2, v2

    .line 44
    mul-float v1, v1, v2

    .line 45
    .line 46
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 47
    .line 48
    int-to-float v2, v2

    .line 49
    add-float/2addr v1, v2

    .line 50
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    .line 51
    .line 52
    .line 53
    move-result v2

    .line 54
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->haloRadius:I

    .line 55
    .line 56
    int-to-float v4, v3

    .line 57
    sub-float v5, v1, v4

    .line 58
    .line 59
    sub-int v6, v2, v3

    .line 60
    .line 61
    int-to-float v6, v6

    .line 62
    add-float/2addr v1, v4

    .line 63
    add-int/2addr v2, v3

    .line 64
    int-to-float v2, v2

    .line 65
    const/4 v3, 0x4

    .line 66
    new-array v3, v3, [F

    .line 67
    .line 68
    const/4 v4, 0x0

    .line 69
    aput v5, v3, v4

    .line 70
    .line 71
    const/4 v5, 0x1

    .line 72
    aput v6, v3, v5

    .line 73
    .line 74
    const/4 v6, 0x2

    .line 75
    aput v1, v3, v6

    .line 76
    .line 77
    const/4 v1, 0x3

    .line 78
    aput v2, v3, v1

    .line 79
    .line 80
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 81
    .line 82
    .line 83
    move-result v2

    .line 84
    if-eqz v2, :cond_0

    .line 85
    .line 86
    iget-object v2, p0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 87
    .line 88
    invoke-virtual {v2, v3}, Landroid/graphics/Matrix;->mapPoints([F)V

    .line 89
    .line 90
    .line 91
    :cond_0
    aget v2, v3, v4

    .line 92
    .line 93
    float-to-int v2, v2

    .line 94
    aget v4, v3, v5

    .line 95
    .line 96
    float-to-int v4, v4

    .line 97
    aget v5, v3, v6

    .line 98
    .line 99
    float-to-int v5, v5

    .line 100
    aget v1, v3, v1

    .line 101
    .line 102
    float-to-int v1, v1

    .line 103
    invoke-virtual {v0, v2, v4, v5, v1}, Landroid/graphics/drawable/Drawable;->setHotspotBounds(IIII)V

    .line 104
    .line 105
    .line 106
    :cond_1
    return-void
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

.method public final updateLabels()V
    .locals 7

    .line 1
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    const/high16 v2, 0x3f000000    # 0.5f

    .line 10
    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    if-eqz v1, :cond_0

    .line 14
    .line 15
    const v0, -0x41b33333    # -0.2f

    .line 16
    .line 17
    .line 18
    const/high16 v1, 0x3f000000    # 0.5f

    .line 19
    .line 20
    const v2, -0x41b33333    # -0.2f

    .line 21
    .line 22
    .line 23
    goto :goto_0

    .line 24
    :cond_0
    const v1, 0x3f99999a    # 1.2f

    .line 25
    .line 26
    .line 27
    if-eqz v0, :cond_1

    .line 28
    .line 29
    const/high16 v1, 0x3f000000    # 0.5f

    .line 30
    .line 31
    const v2, 0x3f99999a    # 1.2f

    .line 32
    .line 33
    .line 34
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->labels:Ljava/util/ArrayList;

    .line 35
    .line 36
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 37
    .line 38
    .line 39
    move-result v3

    .line 40
    const/4 v4, 0x0

    .line 41
    const/4 v5, 0x0

    .line 42
    :goto_1
    if-ge v5, v3, :cond_2

    .line 43
    .line 44
    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 45
    .line 46
    .line 47
    move-result-object v6

    .line 48
    add-int/lit8 v5, v5, 0x1

    .line 49
    .line 50
    check-cast v6, Lcom/google/android/material/tooltip/TooltipDrawable;

    .line 51
    .line 52
    iput v2, v6, Lcom/google/android/material/tooltip/TooltipDrawable;->tooltipPivotX:F

    .line 53
    .line 54
    iput v1, v6, Lcom/google/android/material/tooltip/TooltipDrawable;->tooltipPivotY:F

    .line 55
    .line 56
    invoke-virtual {v6}, Lcom/google/android/material/shape/MaterialShapeDrawable;->invalidateSelf()V

    .line 57
    .line 58
    .line 59
    goto :goto_1

    .line 60
    :cond_2
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->labelBehavior:I

    .line 61
    .line 62
    if-eqz v0, :cond_8

    .line 63
    .line 64
    const/4 v1, 0x1

    .line 65
    if-eq v0, v1, :cond_8

    .line 66
    .line 67
    const/4 v2, 0x2

    .line 68
    if-eq v0, v2, :cond_7

    .line 69
    .line 70
    const/4 v2, 0x3

    .line 71
    if-ne v0, v2, :cond_6

    .line 72
    .line 73
    invoke-virtual {p0}, Landroid/view/View;->isEnabled()Z

    .line 74
    .line 75
    .line 76
    move-result v0

    .line 77
    if-eqz v0, :cond_5

    .line 78
    .line 79
    new-instance v0, Landroid/graphics/Rect;

    .line 80
    .line 81
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 82
    .line 83
    .line 84
    invoke-static {p0}, Lcom/google/android/material/internal/ViewUtils;->getContentView(Lcom/google/android/material/slider/BaseSlider;)Landroid/view/ViewGroup;

    .line 85
    .line 86
    .line 87
    move-result-object v2

    .line 88
    invoke-virtual {v2, v0}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 89
    .line 90
    .line 91
    invoke-virtual {p0, v0}, Landroid/view/View;->getLocalVisibleRect(Landroid/graphics/Rect;)Z

    .line 92
    .line 93
    .line 94
    move-result v0

    .line 95
    if-eqz v0, :cond_4

    .line 96
    .line 97
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 98
    .line 99
    const/16 v2, 0x18

    .line 100
    .line 101
    if-lt v0, v2, :cond_3

    .line 102
    .line 103
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->thisAndAncestorsVisible:Z

    .line 104
    .line 105
    goto :goto_2

    .line 106
    :cond_3
    invoke-virtual {p0}, Landroid/view/View;->isShown()Z

    .line 107
    .line 108
    .line 109
    move-result v0

    .line 110
    :goto_2
    if-eqz v0, :cond_4

    .line 111
    .line 112
    const/4 v4, 0x1

    .line 113
    :cond_4
    if-eqz v4, :cond_5

    .line 114
    .line 115
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->ensureLabelsAdded()V

    .line 116
    .line 117
    .line 118
    return-void

    .line 119
    :cond_5
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->ensureLabelsRemoved()V

    .line 120
    .line 121
    .line 122
    return-void

    .line 123
    :cond_6
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 124
    .line 125
    new-instance v1, Ljava/lang/StringBuilder;

    .line 126
    .line 127
    const-string v2, "Unexpected labelBehavior: "

    .line 128
    .line 129
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 130
    .line 131
    .line 132
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->labelBehavior:I

    .line 133
    .line 134
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 135
    .line 136
    .line 137
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 138
    .line 139
    .line 140
    move-result-object v1

    .line 141
    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 142
    .line 143
    .line 144
    throw v0

    .line 145
    :cond_7
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->ensureLabelsRemoved()V

    .line 146
    .line 147
    .line 148
    return-void

    .line 149
    :cond_8
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->activeThumbIdx:I

    .line 150
    .line 151
    const/4 v1, -0x1

    .line 152
    if-eq v0, v1, :cond_9

    .line 153
    .line 154
    invoke-virtual {p0}, Landroid/view/View;->isEnabled()Z

    .line 155
    .line 156
    .line 157
    move-result v0

    .line 158
    if-eqz v0, :cond_9

    .line 159
    .line 160
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->ensureLabelsAdded()V

    .line 161
    .line 162
    .line 163
    return-void

    .line 164
    :cond_9
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->ensureLabelsRemoved()V

    .line 165
    .line 166
    .line 167
    return-void
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

.method public final updateThumbWidthWhenPressed()V
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 2
    .line 3
    if-lez v0, :cond_0

    .line 4
    .line 5
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 6
    .line 7
    iput v1, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbWidth:I

    .line 8
    .line 9
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbTrackGapSize:I

    .line 10
    .line 11
    int-to-float v0, v1

    .line 12
    const/high16 v1, 0x3f000000    # 0.5f

    .line 13
    .line 14
    mul-float v0, v0, v1

    .line 15
    .line 16
    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 21
    .line 22
    sub-int/2addr v1, v0

    .line 23
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setThumbWidth(I)V

    .line 24
    .line 25
    .line 26
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 27
    .line 28
    div-int/lit8 v1, v1, 0x2

    .line 29
    .line 30
    sub-int/2addr v0, v1

    .line 31
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->setThumbTrackGapSize(I)V

    .line 32
    .line 33
    .line 34
    :cond_0
    return-void
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

.method public final updateTicksCoordinates()V
    .locals 6

    .line 1
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->validateConfigurationIfDirty()V

    .line 2
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    const/4 v1, 0x0

    const/4 v2, 0x0

    cmpg-float v1, v0, v1

    if-gtz v1, :cond_0

    .line 3
    invoke-virtual {p0, v2}, Lcom/google/android/material/slider/BaseSlider;->updateTicksCoordinates(I)V

    return-void

    .line 4
    :cond_0
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->tickVisibilityMode:I

    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v4, 0x1

    if-eqz v1, :cond_3

    if-eq v1, v4, :cond_2

    const/4 v0, 0x2

    if-ne v1, v0, :cond_1

    goto :goto_0

    .line 5
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unexpected tickVisibilityMode: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->tickVisibilityMode:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 6
    :cond_2
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    iget v5, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    sub-float/2addr v1, v5

    div-float/2addr v1, v0

    add-float/2addr v1, v3

    float-to-int v0, v1

    .line 7
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->minTickSpacing:I

    div-int/2addr v1, v3

    add-int/2addr v1, v4

    if-gt v0, v1, :cond_4

    move v2, v0

    goto :goto_0

    .line 8
    :cond_3
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    sub-float/2addr v1, v2

    div-float/2addr v1, v0

    add-float/2addr v1, v3

    float-to-int v0, v1

    .line 9
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->minTickSpacing:I

    div-int/2addr v1, v2

    add-int/2addr v1, v4

    .line 10
    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 11
    :cond_4
    :goto_0
    invoke-virtual {p0, v2}, Lcom/google/android/material/slider/BaseSlider;->updateTicksCoordinates(I)V

    return-void
.end method

.method public final updateTicksCoordinates(I)V
    .locals 7

    if-nez p1, :cond_0

    const/4 p1, 0x0

    .line 12
    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    return-void

    .line 13
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    if-eqz v0, :cond_1

    array-length v0, v0

    mul-int/lit8 v1, p1, 0x2

    if-eq v0, v1, :cond_2

    :cond_1
    mul-int/lit8 v0, p1, 0x2

    .line 14
    new-array v0, v0, [F

    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    .line 15
    :cond_2
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    int-to-float v0, v0

    add-int/lit8 v1, p1, -0x1

    int-to-float v1, v1

    div-float/2addr v0, v1

    .line 16
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    move-result v1

    int-to-float v1, v1

    const/4 v2, 0x0

    :goto_0
    mul-int/lit8 v3, p1, 0x2

    if-ge v2, v3, :cond_3

    .line 17
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    int-to-float v4, v4

    int-to-float v5, v2

    const/high16 v6, 0x40000000    # 2.0f

    div-float/2addr v5, v6

    mul-float v5, v5, v0

    add-float/2addr v5, v4

    aput v5, v3, v2

    add-int/lit8 v4, v2, 0x1

    .line 18
    aput v1, v3, v4

    add-int/lit8 v2, v2, 0x2

    goto :goto_0

    .line 19
    :cond_3
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    move-result p1

    if-eqz p1, :cond_4

    .line 20
    iget-object p1, p0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->ticksCoordinates:[F

    invoke-virtual {p1, v0}, Landroid/graphics/Matrix;->mapPoints([F)V

    :cond_4
    return-void
.end method

.method public final updateTrack(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/RectF;FI)V
    .locals 17

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    move-object/from16 v2, p2

    .line 6
    .line 7
    move-object/from16 v3, p3

    .line 8
    .line 9
    invoke-virtual {v3}, Landroid/graphics/RectF;->isEmpty()Z

    .line 10
    .line 11
    .line 12
    move-result v4

    .line 13
    if-eqz v4, :cond_0

    .line 14
    .line 15
    return-void

    .line 16
    :cond_0
    iget-object v4, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 17
    .line 18
    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    .line 19
    .line 20
    .line 21
    move-result v4

    .line 22
    const/4 v6, 0x1

    .line 23
    if-nez v4, :cond_3

    .line 24
    .line 25
    iget v4, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 26
    .line 27
    if-lez v4, :cond_3

    .line 28
    .line 29
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 30
    .line 31
    .line 32
    move-result v4

    .line 33
    if-nez v4, :cond_2

    .line 34
    .line 35
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 36
    .line 37
    .line 38
    move-result v4

    .line 39
    if-eqz v4, :cond_1

    .line 40
    .line 41
    goto :goto_0

    .line 42
    :cond_1
    const/4 v4, 0x0

    .line 43
    goto :goto_1

    .line 44
    :cond_2
    :goto_0
    iget-object v4, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 45
    .line 46
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    .line 47
    .line 48
    .line 49
    move-result v4

    .line 50
    sub-int/2addr v4, v6

    .line 51
    :goto_1
    iget-object v7, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 52
    .line 53
    invoke-virtual {v7, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 54
    .line 55
    .line 56
    move-result-object v4

    .line 57
    check-cast v4, Ljava/lang/Float;

    .line 58
    .line 59
    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    .line 60
    .line 61
    .line 62
    move-result v4

    .line 63
    invoke-virtual {v0, v4}, Lcom/google/android/material/slider/BaseSlider;->valueToX(F)F

    .line 64
    .line 65
    .line 66
    move-result v4

    .line 67
    iget v7, v0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 68
    .line 69
    int-to-float v7, v7

    .line 70
    sub-float/2addr v4, v7

    .line 71
    cmpg-float v7, v4, p4

    .line 72
    .line 73
    if-gez v7, :cond_3

    .line 74
    .line 75
    iget v7, v0, Lcom/google/android/material/slider/BaseSlider;->trackInsideCornerSize:I

    .line 76
    .line 77
    int-to-float v7, v7

    .line 78
    invoke-static {v4, v7}, Ljava/lang/Math;->max(FF)F

    .line 79
    .line 80
    .line 81
    move-result v4

    .line 82
    goto :goto_2

    .line 83
    :cond_3
    move/from16 v4, p4

    .line 84
    .line 85
    :goto_2
    iget-object v7, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 86
    .line 87
    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    .line 88
    .line 89
    .line 90
    move-result v7

    .line 91
    if-nez v7, :cond_6

    .line 92
    .line 93
    iget v7, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 94
    .line 95
    if-lez v7, :cond_6

    .line 96
    .line 97
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isRtl()Z

    .line 98
    .line 99
    .line 100
    move-result v7

    .line 101
    if-nez v7, :cond_5

    .line 102
    .line 103
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 104
    .line 105
    .line 106
    move-result v7

    .line 107
    if-eqz v7, :cond_4

    .line 108
    .line 109
    goto :goto_3

    .line 110
    :cond_4
    iget-object v7, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 111
    .line 112
    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    .line 113
    .line 114
    .line 115
    move-result v7

    .line 116
    sub-int/2addr v7, v6

    .line 117
    goto :goto_4

    .line 118
    :cond_5
    :goto_3
    const/4 v7, 0x0

    .line 119
    :goto_4
    iget-object v8, v0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 120
    .line 121
    invoke-virtual {v8, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 122
    .line 123
    .line 124
    move-result-object v7

    .line 125
    check-cast v7, Ljava/lang/Float;

    .line 126
    .line 127
    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    .line 128
    .line 129
    .line 130
    move-result v7

    .line 131
    invoke-virtual {v0, v7}, Lcom/google/android/material/slider/BaseSlider;->valueToX(F)F

    .line 132
    .line 133
    .line 134
    move-result v7

    .line 135
    iget v8, v0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 136
    .line 137
    int-to-float v8, v8

    .line 138
    sub-float/2addr v7, v8

    .line 139
    iget v8, v0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 140
    .line 141
    int-to-float v8, v8

    .line 142
    sub-float v9, v8, p4

    .line 143
    .line 144
    cmpl-float v9, v7, v9

    .line 145
    .line 146
    if-lez v9, :cond_6

    .line 147
    .line 148
    sub-float/2addr v8, v7

    .line 149
    iget v7, v0, Lcom/google/android/material/slider/BaseSlider;->trackInsideCornerSize:I

    .line 150
    .line 151
    int-to-float v7, v7

    .line 152
    invoke-static {v8, v7}, Ljava/lang/Math;->max(FF)F

    .line 153
    .line 154
    .line 155
    move-result v7

    .line 156
    goto :goto_5

    .line 157
    :cond_6
    move/from16 v7, p4

    .line 158
    .line 159
    :goto_5
    invoke-static/range {p5 .. p5}, Landroidx/constraintlayout/core/SolverVariable$Type$EnumUnboxingSharedUtility;->ordinal(I)I

    .line 160
    .line 161
    .line 162
    move-result v8

    .line 163
    const/4 v9, 0x3

    .line 164
    const/4 v10, 0x2

    .line 165
    if-eq v8, v6, :cond_9

    .line 166
    .line 167
    if-eq v8, v10, :cond_8

    .line 168
    .line 169
    if-eq v8, v9, :cond_7

    .line 170
    .line 171
    goto :goto_6

    .line 172
    :cond_7
    iget v4, v0, Lcom/google/android/material/slider/BaseSlider;->trackInsideCornerSize:I

    .line 173
    .line 174
    int-to-float v4, v4

    .line 175
    move v7, v4

    .line 176
    goto :goto_6

    .line 177
    :cond_8
    iget v4, v0, Lcom/google/android/material/slider/BaseSlider;->trackInsideCornerSize:I

    .line 178
    .line 179
    int-to-float v4, v4

    .line 180
    goto :goto_6

    .line 181
    :cond_9
    iget v7, v0, Lcom/google/android/material/slider/BaseSlider;->trackInsideCornerSize:I

    .line 182
    .line 183
    int-to-float v7, v7

    .line 184
    :goto_6
    sget-object v8, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    .line 185
    .line 186
    invoke-virtual {v2, v8}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 187
    .line 188
    .line 189
    sget-object v8, Landroid/graphics/Paint$Cap;->BUTT:Landroid/graphics/Paint$Cap;

    .line 190
    .line 191
    invoke-virtual {v2, v8}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 192
    .line 193
    .line 194
    iget v8, v0, Lcom/google/android/material/slider/BaseSlider;->thumbTrackGapSize:I

    .line 195
    .line 196
    if-lez v8, :cond_a

    .line 197
    .line 198
    invoke-virtual {v2, v6}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 199
    .line 200
    .line 201
    :cond_a
    new-instance v8, Landroid/graphics/RectF;

    .line 202
    .line 203
    invoke-direct {v8, v3}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    .line 204
    .line 205
    .line 206
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 207
    .line 208
    .line 209
    move-result v11

    .line 210
    iget-object v12, v0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 211
    .line 212
    if-eqz v11, :cond_b

    .line 213
    .line 214
    invoke-virtual {v12, v8}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 215
    .line 216
    .line 217
    :cond_b
    iget-object v11, v0, Lcom/google/android/material/slider/BaseSlider;->trackPath:Landroid/graphics/Path;

    .line 218
    .line 219
    invoke-virtual {v11}, Landroid/graphics/Path;->reset()V

    .line 220
    .line 221
    .line 222
    invoke-virtual {v3}, Landroid/graphics/RectF;->width()F

    .line 223
    .line 224
    .line 225
    move-result v13

    .line 226
    add-float v14, v4, v7

    .line 227
    .line 228
    cmpl-float v13, v13, v14

    .line 229
    .line 230
    if-ltz v13, :cond_d

    .line 231
    .line 232
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 233
    .line 234
    .line 235
    move-result v3

    .line 236
    const/4 v12, 0x7

    .line 237
    const/4 v13, 0x6

    .line 238
    const/4 v14, 0x5

    .line 239
    const/4 v15, 0x4

    .line 240
    const/16 v16, 0x0

    .line 241
    .line 242
    const/16 v5, 0x8

    .line 243
    .line 244
    if-eqz v3, :cond_c

    .line 245
    .line 246
    new-array v3, v5, [F

    .line 247
    .line 248
    aput v4, v3, v16

    .line 249
    .line 250
    aput v4, v3, v6

    .line 251
    .line 252
    aput v4, v3, v10

    .line 253
    .line 254
    aput v4, v3, v9

    .line 255
    .line 256
    aput v7, v3, v15

    .line 257
    .line 258
    aput v7, v3, v14

    .line 259
    .line 260
    aput v7, v3, v13

    .line 261
    .line 262
    aput v7, v3, v12

    .line 263
    .line 264
    goto :goto_7

    .line 265
    :cond_c
    new-array v3, v5, [F

    .line 266
    .line 267
    aput v4, v3, v16

    .line 268
    .line 269
    aput v4, v3, v6

    .line 270
    .line 271
    aput v7, v3, v10

    .line 272
    .line 273
    aput v7, v3, v9

    .line 274
    .line 275
    aput v7, v3, v15

    .line 276
    .line 277
    aput v7, v3, v14

    .line 278
    .line 279
    aput v4, v3, v13

    .line 280
    .line 281
    aput v4, v3, v12

    .line 282
    .line 283
    :goto_7
    sget-object v4, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    .line 284
    .line 285
    invoke-virtual {v11, v8, v3, v4}, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF;[FLandroid/graphics/Path$Direction;)V

    .line 286
    .line 287
    .line 288
    invoke-virtual {v1, v11, v2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 289
    .line 290
    .line 291
    return-void

    .line 292
    :cond_d
    invoke-static {v4, v7}, Ljava/lang/Math;->min(FF)F

    .line 293
    .line 294
    .line 295
    move-result v5

    .line 296
    invoke-static {v4, v7}, Ljava/lang/Math;->max(FF)F

    .line 297
    .line 298
    .line 299
    move-result v4

    .line 300
    invoke-virtual {v1}, Landroid/graphics/Canvas;->save()I

    .line 301
    .line 302
    .line 303
    sget-object v7, Landroid/graphics/Path$Direction;->CW:Landroid/graphics/Path$Direction;

    .line 304
    .line 305
    invoke-virtual {v11, v8, v5, v5, v7}, Landroid/graphics/Path;->addRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Path$Direction;)V

    .line 306
    .line 307
    .line 308
    invoke-virtual {v1, v11}, Landroid/graphics/Canvas;->clipPath(Landroid/graphics/Path;)Z

    .line 309
    .line 310
    .line 311
    invoke-static/range {p5 .. p5}, Landroidx/constraintlayout/core/SolverVariable$Type$EnumUnboxingSharedUtility;->ordinal(I)I

    .line 312
    .line 313
    .line 314
    move-result v5

    .line 315
    const/high16 v7, 0x40000000    # 2.0f

    .line 316
    .line 317
    iget-object v8, v0, Lcom/google/android/material/slider/BaseSlider;->cornerRect:Landroid/graphics/RectF;

    .line 318
    .line 319
    if-eq v5, v6, :cond_f

    .line 320
    .line 321
    if-eq v5, v10, :cond_e

    .line 322
    .line 323
    invoke-virtual {v3}, Landroid/graphics/RectF;->centerX()F

    .line 324
    .line 325
    .line 326
    move-result v5

    .line 327
    sub-float/2addr v5, v4

    .line 328
    iget v6, v3, Landroid/graphics/RectF;->top:F

    .line 329
    .line 330
    invoke-virtual {v3}, Landroid/graphics/RectF;->centerX()F

    .line 331
    .line 332
    .line 333
    move-result v7

    .line 334
    add-float/2addr v7, v4

    .line 335
    iget v3, v3, Landroid/graphics/RectF;->bottom:F

    .line 336
    .line 337
    invoke-virtual {v8, v5, v6, v7, v3}, Landroid/graphics/RectF;->set(FFFF)V

    .line 338
    .line 339
    .line 340
    goto :goto_8

    .line 341
    :cond_e
    iget v5, v3, Landroid/graphics/RectF;->right:F

    .line 342
    .line 343
    mul-float v7, v7, v4

    .line 344
    .line 345
    sub-float v6, v5, v7

    .line 346
    .line 347
    iget v7, v3, Landroid/graphics/RectF;->top:F

    .line 348
    .line 349
    iget v3, v3, Landroid/graphics/RectF;->bottom:F

    .line 350
    .line 351
    invoke-virtual {v8, v6, v7, v5, v3}, Landroid/graphics/RectF;->set(FFFF)V

    .line 352
    .line 353
    .line 354
    goto :goto_8

    .line 355
    :cond_f
    iget v5, v3, Landroid/graphics/RectF;->left:F

    .line 356
    .line 357
    iget v6, v3, Landroid/graphics/RectF;->top:F

    .line 358
    .line 359
    mul-float v7, v7, v4

    .line 360
    .line 361
    add-float/2addr v7, v5

    .line 362
    iget v3, v3, Landroid/graphics/RectF;->bottom:F

    .line 363
    .line 364
    invoke-virtual {v8, v5, v6, v7, v3}, Landroid/graphics/RectF;->set(FFFF)V

    .line 365
    .line 366
    .line 367
    :goto_8
    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 368
    .line 369
    .line 370
    move-result v3

    .line 371
    if-eqz v3, :cond_10

    .line 372
    .line 373
    invoke-virtual {v12, v8}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 374
    .line 375
    .line 376
    :cond_10
    invoke-virtual {v1, v8, v4, v4, v2}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 377
    .line 378
    .line 379
    invoke-virtual {v1}, Landroid/graphics/Canvas;->restore()V

    .line 380
    .line 381
    .line 382
    return-void
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

.method public final updateTrackIconActiveEnd()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEnd:Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    iget-boolean v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEndMutated:Z

    .line 6
    .line 7
    if-nez v1, :cond_0

    .line 8
    .line 9
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveColor:Landroid/content/res/ColorStateList;

    .line 10
    .line 11
    if-eqz v1, :cond_0

    .line 12
    .line 13
    invoke-static {v0}, Landroidx/core/os/BundleKt;->wrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEnd:Landroid/graphics/drawable/Drawable;

    .line 22
    .line 23
    const/4 v0, 0x1

    .line 24
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEndMutated:Z

    .line 25
    .line 26
    :cond_0
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEndMutated:Z

    .line 27
    .line 28
    if-eqz v0, :cond_1

    .line 29
    .line 30
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveEnd:Landroid/graphics/drawable/Drawable;

    .line 31
    .line 32
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveColor:Landroid/content/res/ColorStateList;

    .line 33
    .line 34
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setTintList(Landroid/content/res/ColorStateList;)V

    .line 35
    .line 36
    .line 37
    :cond_1
    return-void
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

.method public final updateTrackIconActiveStart()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStart:Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    iget-boolean v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStartMutated:Z

    .line 6
    .line 7
    if-nez v1, :cond_0

    .line 8
    .line 9
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveColor:Landroid/content/res/ColorStateList;

    .line 10
    .line 11
    if-eqz v1, :cond_0

    .line 12
    .line 13
    invoke-static {v0}, Landroidx/core/os/BundleKt;->wrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStart:Landroid/graphics/drawable/Drawable;

    .line 22
    .line 23
    const/4 v0, 0x1

    .line 24
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStartMutated:Z

    .line 25
    .line 26
    :cond_0
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStartMutated:Z

    .line 27
    .line 28
    if-eqz v0, :cond_1

    .line 29
    .line 30
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveStart:Landroid/graphics/drawable/Drawable;

    .line 31
    .line 32
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconActiveColor:Landroid/content/res/ColorStateList;

    .line 33
    .line 34
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setTintList(Landroid/content/res/ColorStateList;)V

    .line 35
    .line 36
    .line 37
    :cond_1
    return-void
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

.method public final updateTrackIconInactiveEnd()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEnd:Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    iget-boolean v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEndMutated:Z

    .line 6
    .line 7
    if-nez v1, :cond_0

    .line 8
    .line 9
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveColor:Landroid/content/res/ColorStateList;

    .line 10
    .line 11
    if-eqz v1, :cond_0

    .line 12
    .line 13
    invoke-static {v0}, Landroidx/core/os/BundleKt;->wrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEnd:Landroid/graphics/drawable/Drawable;

    .line 22
    .line 23
    const/4 v0, 0x1

    .line 24
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEndMutated:Z

    .line 25
    .line 26
    :cond_0
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEndMutated:Z

    .line 27
    .line 28
    if-eqz v0, :cond_1

    .line 29
    .line 30
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveEnd:Landroid/graphics/drawable/Drawable;

    .line 31
    .line 32
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveColor:Landroid/content/res/ColorStateList;

    .line 33
    .line 34
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setTintList(Landroid/content/res/ColorStateList;)V

    .line 35
    .line 36
    .line 37
    :cond_1
    return-void
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

.method public final updateTrackIconInactiveStart()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStart:Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    iget-boolean v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStartMutated:Z

    .line 6
    .line 7
    if-nez v1, :cond_0

    .line 8
    .line 9
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveColor:Landroid/content/res/ColorStateList;

    .line 10
    .line 11
    if-eqz v1, :cond_0

    .line 12
    .line 13
    invoke-static {v0}, Landroidx/core/os/BundleKt;->wrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    iput-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStart:Landroid/graphics/drawable/Drawable;

    .line 22
    .line 23
    const/4 v0, 0x1

    .line 24
    iput-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStartMutated:Z

    .line 25
    .line 26
    :cond_0
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStartMutated:Z

    .line 27
    .line 28
    if-eqz v0, :cond_1

    .line 29
    .line 30
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveStart:Landroid/graphics/drawable/Drawable;

    .line 31
    .line 32
    iget-object v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackIconInactiveColor:Landroid/content/res/ColorStateList;

    .line 33
    .line 34
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setTintList(Landroid/content/res/ColorStateList;)V

    .line 35
    .line 36
    .line 37
    :cond_1
    return-void
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

.method public final updateWidgetLayout(Z)V
    .locals 8

    .line 1
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    invoke-virtual {p0}, Landroid/view/View;->getPaddingLeft()I

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    invoke-virtual {p0}, Landroid/view/View;->getPaddingRight()I

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    :goto_0
    add-int/2addr v1, v0

    .line 16
    goto :goto_1

    .line 17
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    .line 22
    .line 23
    .line 24
    move-result v1

    .line 25
    goto :goto_0

    .line 26
    :goto_1
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackThickness:I

    .line 27
    .line 28
    add-int/2addr v0, v1

    .line 29
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->thumbHeight:I

    .line 30
    .line 31
    add-int/2addr v2, v1

    .line 32
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->minWidgetThickness:I

    .line 33
    .line 34
    invoke-static {v0, v2}, Ljava/lang/Math;->max(II)I

    .line 35
    .line 36
    .line 37
    move-result v0

    .line 38
    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    .line 39
    .line 40
    .line 41
    move-result v0

    .line 42
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->widgetThickness:I

    .line 43
    .line 44
    const/4 v2, 0x1

    .line 45
    const/4 v3, 0x0

    .line 46
    if-ne v0, v1, :cond_1

    .line 47
    .line 48
    const/4 v0, 0x0

    .line 49
    goto :goto_2

    .line 50
    :cond_1
    iput v0, p0, Lcom/google/android/material/slider/BaseSlider;->widgetThickness:I

    .line 51
    .line 52
    const/4 v0, 0x1

    .line 53
    :goto_2
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->thumbWidth:I

    .line 54
    .line 55
    div-int/lit8 v1, v1, 0x2

    .line 56
    .line 57
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->defaultThumbRadius:I

    .line 58
    .line 59
    sub-int/2addr v1, v4

    .line 60
    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    .line 61
    .line 62
    .line 63
    move-result v1

    .line 64
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->trackThickness:I

    .line 65
    .line 66
    iget v5, p0, Lcom/google/android/material/slider/BaseSlider;->defaultTrackThickness:I

    .line 67
    .line 68
    sub-int/2addr v4, v5

    .line 69
    div-int/lit8 v4, v4, 0x2

    .line 70
    .line 71
    invoke-static {v4, v3}, Ljava/lang/Math;->max(II)I

    .line 72
    .line 73
    .line 74
    move-result v4

    .line 75
    iget v5, p0, Lcom/google/android/material/slider/BaseSlider;->tickActiveRadius:I

    .line 76
    .line 77
    iget v6, p0, Lcom/google/android/material/slider/BaseSlider;->defaultTickActiveRadius:I

    .line 78
    .line 79
    sub-int/2addr v5, v6

    .line 80
    invoke-static {v5, v3}, Ljava/lang/Math;->max(II)I

    .line 81
    .line 82
    .line 83
    move-result v5

    .line 84
    iget v6, p0, Lcom/google/android/material/slider/BaseSlider;->tickInactiveRadius:I

    .line 85
    .line 86
    iget v7, p0, Lcom/google/android/material/slider/BaseSlider;->defaultTickInactiveRadius:I

    .line 87
    .line 88
    sub-int/2addr v6, v7

    .line 89
    invoke-static {v6, v3}, Ljava/lang/Math;->max(II)I

    .line 90
    .line 91
    .line 92
    move-result v6

    .line 93
    invoke-static {v1, v4}, Ljava/lang/Math;->max(II)I

    .line 94
    .line 95
    .line 96
    move-result v1

    .line 97
    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    .line 98
    .line 99
    .line 100
    move-result v4

    .line 101
    invoke-static {v1, v4}, Ljava/lang/Math;->max(II)I

    .line 102
    .line 103
    .line 104
    move-result v1

    .line 105
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->minTrackSidePadding:I

    .line 106
    .line 107
    add-int/2addr v1, v4

    .line 108
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 109
    .line 110
    if-ne v4, v1, :cond_2

    .line 111
    .line 112
    const/4 v2, 0x0

    .line 113
    goto :goto_4

    .line 114
    :cond_2
    iput v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 115
    .line 116
    invoke-virtual {p0}, Landroid/view/View;->isLaidOut()Z

    .line 117
    .line 118
    .line 119
    move-result v1

    .line 120
    if-eqz v1, :cond_4

    .line 121
    .line 122
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 123
    .line 124
    .line 125
    move-result v1

    .line 126
    if-eqz v1, :cond_3

    .line 127
    .line 128
    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    .line 129
    .line 130
    .line 131
    move-result v1

    .line 132
    goto :goto_3

    .line 133
    :cond_3
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    .line 134
    .line 135
    .line 136
    move-result v1

    .line 137
    :goto_3
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 138
    .line 139
    mul-int/lit8 v4, v4, 0x2

    .line 140
    .line 141
    sub-int/2addr v1, v4

    .line 142
    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    .line 143
    .line 144
    .line 145
    move-result v1

    .line 146
    iput v1, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 147
    .line 148
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->updateTicksCoordinates()V

    .line 149
    .line 150
    .line 151
    :cond_4
    :goto_4
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->isVertical()Z

    .line 152
    .line 153
    .line 154
    move-result v1

    .line 155
    if-eqz v1, :cond_5

    .line 156
    .line 157
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->calculateTrackCenter()I

    .line 158
    .line 159
    .line 160
    move-result v1

    .line 161
    int-to-float v1, v1

    .line 162
    iget-object v3, p0, Lcom/google/android/material/slider/BaseSlider;->rotationMatrix:Landroid/graphics/Matrix;

    .line 163
    .line 164
    invoke-virtual {v3}, Landroid/graphics/Matrix;->reset()V

    .line 165
    .line 166
    .line 167
    const/high16 v4, 0x42b40000    # 90.0f

    .line 168
    .line 169
    invoke-virtual {v3, v4, v1, v1}, Landroid/graphics/Matrix;->setRotate(FFF)V

    .line 170
    .line 171
    .line 172
    :cond_5
    if-nez v0, :cond_8

    .line 173
    .line 174
    if-eqz p1, :cond_6

    .line 175
    .line 176
    goto :goto_5

    .line 177
    :cond_6
    if-eqz v2, :cond_7

    .line 178
    .line 179
    invoke-virtual {p0}, Landroid/view/View;->postInvalidate()V

    .line 180
    .line 181
    .line 182
    :cond_7
    return-void

    .line 183
    :cond_8
    :goto_5
    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    .line 184
    .line 185
    .line 186
    return-void
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

.method public final validateConfigurationIfDirty()V
    .locals 10

    .line 1
    iget-boolean v0, p0, Lcom/google/android/material/slider/BaseSlider;->dirtyConfig:Z

    .line 2
    .line 3
    if-eqz v0, :cond_f

    .line 4
    .line 5
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 6
    .line 7
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 8
    .line 9
    const-string v2, ")"

    .line 10
    .line 11
    cmpl-float v0, v0, v1

    .line 12
    .line 13
    if-gez v0, :cond_e

    .line 14
    .line 15
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider;->values:Ljava/util/ArrayList;

    .line 16
    .line 17
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 18
    .line 19
    .line 20
    move-result v1

    .line 21
    const/4 v3, 0x0

    .line 22
    const/4 v4, 0x0

    .line 23
    :cond_0
    :goto_0
    const-string v5, ") when using stepSize("

    .line 24
    .line 25
    const/4 v6, 0x0

    .line 26
    if-ge v4, v1, :cond_3

    .line 27
    .line 28
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 29
    .line 30
    .line 31
    move-result-object v7

    .line 32
    add-int/lit8 v4, v4, 0x1

    .line 33
    .line 34
    check-cast v7, Ljava/lang/Float;

    .line 35
    .line 36
    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    .line 37
    .line 38
    .line 39
    move-result v8

    .line 40
    iget v9, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 41
    .line 42
    cmpg-float v8, v8, v9

    .line 43
    .line 44
    if-ltz v8, :cond_2

    .line 45
    .line 46
    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    .line 47
    .line 48
    .line 49
    move-result v8

    .line 50
    iget v9, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 51
    .line 52
    cmpl-float v8, v8, v9

    .line 53
    .line 54
    if-gtz v8, :cond_2

    .line 55
    .line 56
    iget v8, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 57
    .line 58
    cmpl-float v6, v8, v6

    .line 59
    .line 60
    if-lez v6, :cond_0

    .line 61
    .line 62
    invoke-virtual {v7}, Ljava/lang/Float;->floatValue()F

    .line 63
    .line 64
    .line 65
    move-result v6

    .line 66
    invoke-virtual {p0, v6}, Lcom/google/android/material/slider/BaseSlider;->valueLandsOnTick(F)Z

    .line 67
    .line 68
    .line 69
    move-result v6

    .line 70
    if-eqz v6, :cond_1

    .line 71
    .line 72
    goto :goto_0

    .line 73
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 74
    .line 75
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 76
    .line 77
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 78
    .line 79
    new-instance v4, Ljava/lang/StringBuilder;

    .line 80
    .line 81
    const-string v6, "Value("

    .line 82
    .line 83
    invoke-direct {v4, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 84
    .line 85
    .line 86
    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 87
    .line 88
    .line 89
    const-string v6, ") must be equal to valueFrom("

    .line 90
    .line 91
    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 92
    .line 93
    .line 94
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 95
    .line 96
    .line 97
    const-string v1, ") plus a multiple of stepSize("

    .line 98
    .line 99
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 100
    .line 101
    .line 102
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 103
    .line 104
    .line 105
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 106
    .line 107
    .line 108
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 109
    .line 110
    .line 111
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 112
    .line 113
    .line 114
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 115
    .line 116
    .line 117
    move-result-object v1

    .line 118
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 119
    .line 120
    .line 121
    throw v0

    .line 122
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 123
    .line 124
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 125
    .line 126
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 127
    .line 128
    new-instance v4, Ljava/lang/StringBuilder;

    .line 129
    .line 130
    const-string v5, "Slider value("

    .line 131
    .line 132
    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 133
    .line 134
    .line 135
    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 136
    .line 137
    .line 138
    const-string v5, ") must be greater or equal to valueFrom("

    .line 139
    .line 140
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 141
    .line 142
    .line 143
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 144
    .line 145
    .line 146
    const-string v1, "), and lower or equal to valueTo("

    .line 147
    .line 148
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 149
    .line 150
    .line 151
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 152
    .line 153
    .line 154
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 155
    .line 156
    .line 157
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 158
    .line 159
    .line 160
    move-result-object v1

    .line 161
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 162
    .line 163
    .line 164
    throw v0

    .line 165
    :cond_3
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 166
    .line 167
    cmpl-float v0, v0, v6

    .line 168
    .line 169
    if-lez v0, :cond_5

    .line 170
    .line 171
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 172
    .line 173
    invoke-virtual {p0, v0}, Lcom/google/android/material/slider/BaseSlider;->valueLandsOnTick(F)Z

    .line 174
    .line 175
    .line 176
    move-result v0

    .line 177
    if-eqz v0, :cond_4

    .line 178
    .line 179
    goto :goto_1

    .line 180
    :cond_4
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 181
    .line 182
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 183
    .line 184
    iget v2, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 185
    .line 186
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 187
    .line 188
    new-instance v4, Ljava/lang/StringBuilder;

    .line 189
    .line 190
    const-string v5, "The stepSize("

    .line 191
    .line 192
    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 193
    .line 194
    .line 195
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 196
    .line 197
    .line 198
    const-string v1, ") must be 0, or a factor of the valueFrom("

    .line 199
    .line 200
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 201
    .line 202
    .line 203
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 204
    .line 205
    .line 206
    const-string v1, ")-valueTo("

    .line 207
    .line 208
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 209
    .line 210
    .line 211
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 212
    .line 213
    .line 214
    const-string v1, ") range"

    .line 215
    .line 216
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 217
    .line 218
    .line 219
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 220
    .line 221
    .line 222
    move-result-object v1

    .line 223
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 224
    .line 225
    .line 226
    throw v0

    .line 227
    :cond_5
    :goto_1
    invoke-virtual {p0}, Lcom/google/android/material/slider/BaseSlider;->getMinSeparation()F

    .line 228
    .line 229
    .line 230
    move-result v0

    .line 231
    const-string v1, "minSeparation("

    .line 232
    .line 233
    cmpg-float v4, v0, v6

    .line 234
    .line 235
    if-ltz v4, :cond_d

    .line 236
    .line 237
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 238
    .line 239
    cmpl-float v7, v4, v6

    .line 240
    .line 241
    if-lez v7, :cond_8

    .line 242
    .line 243
    cmpl-float v7, v0, v6

    .line 244
    .line 245
    if-lez v7, :cond_8

    .line 246
    .line 247
    iget v7, p0, Lcom/google/android/material/slider/BaseSlider;->separationUnit:I

    .line 248
    .line 249
    const/4 v8, 0x1

    .line 250
    if-ne v7, v8, :cond_7

    .line 251
    .line 252
    cmpg-float v4, v0, v4

    .line 253
    .line 254
    if-ltz v4, :cond_6

    .line 255
    .line 256
    float-to-double v7, v0

    .line 257
    invoke-virtual {p0, v7, v8}, Lcom/google/android/material/slider/BaseSlider;->isMultipleOfStepSize(D)Z

    .line 258
    .line 259
    .line 260
    move-result v4

    .line 261
    if-eqz v4, :cond_6

    .line 262
    .line 263
    goto :goto_2

    .line 264
    :cond_6
    new-instance v3, Ljava/lang/IllegalStateException;

    .line 265
    .line 266
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 267
    .line 268
    new-instance v6, Ljava/lang/StringBuilder;

    .line 269
    .line 270
    invoke-direct {v6, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 271
    .line 272
    .line 273
    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 274
    .line 275
    .line 276
    const-string v0, ") must be greater or equal and a multiple of stepSize("

    .line 277
    .line 278
    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 279
    .line 280
    .line 281
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 282
    .line 283
    .line 284
    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 285
    .line 286
    .line 287
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 288
    .line 289
    .line 290
    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 291
    .line 292
    .line 293
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 294
    .line 295
    .line 296
    move-result-object v0

    .line 297
    invoke-direct {v3, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 298
    .line 299
    .line 300
    throw v3

    .line 301
    :cond_7
    new-instance v3, Ljava/lang/IllegalStateException;

    .line 302
    .line 303
    iget v4, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 304
    .line 305
    new-instance v5, Ljava/lang/StringBuilder;

    .line 306
    .line 307
    invoke-direct {v5, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 308
    .line 309
    .line 310
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 311
    .line 312
    .line 313
    const-string v0, ") cannot be set as a dimension when using stepSize("

    .line 314
    .line 315
    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 316
    .line 317
    .line 318
    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 319
    .line 320
    .line 321
    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 322
    .line 323
    .line 324
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 325
    .line 326
    .line 327
    move-result-object v0

    .line 328
    invoke-direct {v3, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 329
    .line 330
    .line 331
    throw v3

    .line 332
    :cond_8
    :goto_2
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->stepSize:F

    .line 333
    .line 334
    cmpl-float v1, v0, v6

    .line 335
    .line 336
    if-nez v1, :cond_9

    .line 337
    .line 338
    goto :goto_3

    .line 339
    :cond_9
    float-to-int v1, v0

    .line 340
    int-to-float v1, v1

    .line 341
    const-string v2, "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly."

    .line 342
    .line 343
    const-string v4, "BaseSlider"

    .line 344
    .line 345
    cmpl-float v1, v1, v0

    .line 346
    .line 347
    if-eqz v1, :cond_a

    .line 348
    .line 349
    new-instance v1, Ljava/lang/StringBuilder;

    .line 350
    .line 351
    const-string v5, "Floating point value used for stepSize("

    .line 352
    .line 353
    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 354
    .line 355
    .line 356
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 357
    .line 358
    .line 359
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 360
    .line 361
    .line 362
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 363
    .line 364
    .line 365
    move-result-object v0

    .line 366
    invoke-static {v4, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 367
    .line 368
    .line 369
    :cond_a
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 370
    .line 371
    float-to-int v1, v0

    .line 372
    int-to-float v1, v1

    .line 373
    cmpl-float v1, v1, v0

    .line 374
    .line 375
    if-eqz v1, :cond_b

    .line 376
    .line 377
    new-instance v1, Ljava/lang/StringBuilder;

    .line 378
    .line 379
    const-string v5, "Floating point value used for valueFrom("

    .line 380
    .line 381
    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 382
    .line 383
    .line 384
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 385
    .line 386
    .line 387
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 388
    .line 389
    .line 390
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 391
    .line 392
    .line 393
    move-result-object v0

    .line 394
    invoke-static {v4, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 395
    .line 396
    .line 397
    :cond_b
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 398
    .line 399
    float-to-int v1, v0

    .line 400
    int-to-float v1, v1

    .line 401
    cmpl-float v1, v1, v0

    .line 402
    .line 403
    if-eqz v1, :cond_c

    .line 404
    .line 405
    new-instance v1, Ljava/lang/StringBuilder;

    .line 406
    .line 407
    const-string v5, "Floating point value used for valueTo("

    .line 408
    .line 409
    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 410
    .line 411
    .line 412
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 413
    .line 414
    .line 415
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 416
    .line 417
    .line 418
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 419
    .line 420
    .line 421
    move-result-object v0

    .line 422
    invoke-static {v4, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 423
    .line 424
    .line 425
    :cond_c
    :goto_3
    iput-boolean v3, p0, Lcom/google/android/material/slider/BaseSlider;->dirtyConfig:Z

    .line 426
    .line 427
    return-void

    .line 428
    :cond_d
    new-instance v2, Ljava/lang/IllegalStateException;

    .line 429
    .line 430
    new-instance v3, Ljava/lang/StringBuilder;

    .line 431
    .line 432
    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 433
    .line 434
    .line 435
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 436
    .line 437
    .line 438
    const-string v0, ") must be greater or equal to 0"

    .line 439
    .line 440
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 441
    .line 442
    .line 443
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 444
    .line 445
    .line 446
    move-result-object v0

    .line 447
    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 448
    .line 449
    .line 450
    throw v2

    .line 451
    :cond_e
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 452
    .line 453
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 454
    .line 455
    iget v3, p0, Lcom/google/android/material/slider/BaseSlider;->valueTo:F

    .line 456
    .line 457
    new-instance v4, Ljava/lang/StringBuilder;

    .line 458
    .line 459
    const-string v5, "valueFrom("

    .line 460
    .line 461
    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 462
    .line 463
    .line 464
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 465
    .line 466
    .line 467
    const-string v1, ") must be smaller than valueTo("

    .line 468
    .line 469
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 470
    .line 471
    .line 472
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 473
    .line 474
    .line 475
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 476
    .line 477
    .line 478
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 479
    .line 480
    .line 481
    move-result-object v1

    .line 482
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 483
    .line 484
    .line 485
    throw v0

    .line 486
    :cond_f
    return-void
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
.end method

.method public final valueLandsOnTick(F)Z
    .locals 2

    .line 1
    new-instance v0, Ljava/math/BigDecimal;

    .line 2
    .line 3
    invoke-static {p1}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    invoke-direct {v0, p1}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 8
    .line 9
    .line 10
    new-instance p1, Ljava/math/BigDecimal;

    .line 11
    .line 12
    iget v1, p0, Lcom/google/android/material/slider/BaseSlider;->valueFrom:F

    .line 13
    .line 14
    invoke-static {v1}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    invoke-direct {p1, v1}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 19
    .line 20
    .line 21
    sget-object v1, Ljava/math/MathContext;->DECIMAL64:Ljava/math/MathContext;

    .line 22
    .line 23
    invoke-virtual {v0, p1, v1}, Ljava/math/BigDecimal;->subtract(Ljava/math/BigDecimal;Ljava/math/MathContext;)Ljava/math/BigDecimal;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    invoke-virtual {p1}, Ljava/math/BigDecimal;->doubleValue()D

    .line 28
    .line 29
    .line 30
    move-result-wide v0

    .line 31
    invoke-virtual {p0, v0, v1}, Lcom/google/android/material/slider/BaseSlider;->isMultipleOfStepSize(D)Z

    .line 32
    .line 33
    .line 34
    move-result p1

    .line 35
    return p1
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

.method public final valueToX(F)F
    .locals 1

    .line 1
    invoke-virtual {p0, p1}, Lcom/google/android/material/slider/BaseSlider;->normalizeValue(F)F

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackWidth:I

    .line 6
    .line 7
    int-to-float v0, v0

    .line 8
    mul-float p1, p1, v0

    .line 9
    .line 10
    iget v0, p0, Lcom/google/android/material/slider/BaseSlider;->trackSidePadding:I

    .line 11
    .line 12
    int-to-float v0, v0

    .line 13
    add-float/2addr p1, v0

    .line 14
    return p1
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
