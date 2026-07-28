.class public final Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/viewpager/widget/ViewPager$PageTransformer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/github/appintro/internal/viewpager/ViewPagerTransformer$Companion;
    }
.end annotation


# static fields
.field public static final Companion:Lcom/github/appintro/internal/viewpager/ViewPagerTransformer$Companion;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private descriptionPF:D

.field private imagePF:D

.field private titlePF:D

.field private final transformType:Lcom/github/appintro/AppIntroPageTransformerType;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer$Companion;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, v1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 5
    .line 6
    .line 7
    sput-object v0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->Companion:Lcom/github/appintro/internal/viewpager/ViewPagerTransformer$Companion;

    .line 8
    .line 9
    sget-object v0, Lcom/github/appintro/internal/LogHelper;->INSTANCE:Lcom/github/appintro/internal/LogHelper;

    .line 10
    .line 11
    const-class v1, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;

    .line 12
    .line 13
    invoke-static {v1}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/jvm/internal/ClassReference;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    invoke-virtual {v0, v1}, Lcom/github/appintro/internal/LogHelper;->makeLogTag(Lkotlin/reflect/KClass;)Ljava/lang/String;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    sput-object v0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->TAG:Ljava/lang/String;

    .line 22
    .line 23
    return-void
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

.method public constructor <init>(Lcom/github/appintro/AppIntroPageTransformerType;)V
    .locals 1

    .line 1
    const-string v0, "transformType"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object p1, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformType:Lcom/github/appintro/AppIntroPageTransformerType;

    .line 10
    .line 11
    return-void
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

.method private final applyParallax(Landroid/view/View;F)V
    .locals 3

    .line 1
    sget v0, Lcom/github/appintro/R$id;->title:I

    .line 2
    .line 3
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroid/widget/TextView;

    .line 8
    .line 9
    iget-wide v1, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->titlePF:D

    .line 10
    .line 11
    invoke-direct {p0, p1, p2, v1, v2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->computeParallax(Landroid/view/View;FD)F

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationX(F)V

    .line 16
    .line 17
    .line 18
    sget v0, Lcom/github/appintro/R$id;->image:I

    .line 19
    .line 20
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    check-cast v0, Landroid/widget/ImageView;

    .line 25
    .line 26
    iget-wide v1, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->imagePF:D

    .line 27
    .line 28
    invoke-direct {p0, p1, p2, v1, v2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->computeParallax(Landroid/view/View;FD)F

    .line 29
    .line 30
    .line 31
    move-result v1

    .line 32
    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationX(F)V

    .line 33
    .line 34
    .line 35
    sget v0, Lcom/github/appintro/R$id;->description:I

    .line 36
    .line 37
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 38
    .line 39
    .line 40
    move-result-object v0

    .line 41
    check-cast v0, Landroid/widget/TextView;

    .line 42
    .line 43
    iget-wide v1, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->descriptionPF:D

    .line 44
    .line 45
    invoke-direct {p0, p1, p2, v1, v2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->computeParallax(Landroid/view/View;FD)F

    .line 46
    .line 47
    .line 48
    move-result p1

    .line 49
    invoke-virtual {v0, p1}, Landroid/view/View;->setTranslationX(F)V

    .line 50
    .line 51
    .line 52
    return-void
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

.method private final computeParallax(Landroid/view/View;FD)F
    .locals 2

    .line 1
    neg-float p2, p2

    .line 2
    float-to-double v0, p2

    .line 3
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    int-to-double p1, p1

    .line 8
    div-double/2addr p1, p3

    .line 9
    mul-double p1, p1, v0

    .line 10
    .line 11
    double-to-float p1, p1

    .line 12
    return p1
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

.method private final transformDepth(FLandroid/view/View;)V
    .locals 2

    .line 1
    const/4 v0, 0x0

    .line 2
    cmpl-float v0, p1, v0

    .line 3
    .line 4
    if-lez v0, :cond_0

    .line 5
    .line 6
    const/high16 v0, 0x3f800000    # 1.0f

    .line 7
    .line 8
    cmpg-float v0, p1, v0

    .line 9
    .line 10
    if-gez v0, :cond_0

    .line 11
    .line 12
    const/4 v0, 0x1

    .line 13
    int-to-float v0, v0

    .line 14
    sub-float v1, v0, p1

    .line 15
    .line 16
    invoke-virtual {p2, v1}, Landroid/view/View;->setAlpha(F)V

    .line 17
    .line 18
    .line 19
    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    sub-float/2addr v0, v1

    .line 24
    const/high16 v1, 0x3e800000    # 0.25f

    .line 25
    .line 26
    mul-float v0, v0, v1

    .line 27
    .line 28
    const/high16 v1, 0x3f400000    # 0.75f

    .line 29
    .line 30
    add-float/2addr v0, v1

    .line 31
    invoke-static {p2, v0}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$setScaleXY(Landroid/view/View;F)V

    .line 32
    .line 33
    .line 34
    invoke-virtual {p2}, Landroid/view/View;->getWidth()I

    .line 35
    .line 36
    .line 37
    move-result v0

    .line 38
    int-to-float v0, v0

    .line 39
    neg-float p1, p1

    .line 40
    mul-float v0, v0, p1

    .line 41
    .line 42
    invoke-virtual {p2, v0}, Landroid/view/View;->setTranslationX(F)V

    .line 43
    .line 44
    .line 45
    return-void

    .line 46
    :cond_0
    invoke-static {p2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$transformDefaults(Landroid/view/View;)V

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

.method private final transformFade(FLandroid/view/View;)V
    .locals 3

    .line 1
    const/high16 v0, -0x40800000    # -1.0f

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    cmpg-float v0, p1, v0

    .line 5
    .line 6
    if-lez v0, :cond_2

    .line 7
    .line 8
    const/high16 v0, 0x3f800000    # 1.0f

    .line 9
    .line 10
    cmpl-float v2, p1, v0

    .line 11
    .line 12
    if-ltz v2, :cond_0

    .line 13
    .line 14
    goto :goto_0

    .line 15
    :cond_0
    cmpg-float v2, p1, v1

    .line 16
    .line 17
    if-nez v2, :cond_1

    .line 18
    .line 19
    invoke-virtual {p2, v1}, Landroid/view/View;->setTranslationX(F)V

    .line 20
    .line 21
    .line 22
    invoke-virtual {p2, v0}, Landroid/view/View;->setAlpha(F)V

    .line 23
    .line 24
    .line 25
    const/4 p1, 0x1

    .line 26
    invoke-virtual {p2, p1}, Landroid/view/View;->setClickable(Z)V

    .line 27
    .line 28
    .line 29
    return-void

    .line 30
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getWidth()I

    .line 31
    .line 32
    .line 33
    move-result v1

    .line 34
    int-to-float v1, v1

    .line 35
    neg-float v2, p1

    .line 36
    mul-float v1, v1, v2

    .line 37
    .line 38
    invoke-virtual {p2, v1}, Landroid/view/View;->setTranslationX(F)V

    .line 39
    .line 40
    .line 41
    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    .line 42
    .line 43
    .line 44
    move-result p1

    .line 45
    sub-float/2addr v0, p1

    .line 46
    invoke-virtual {p2, v0}, Landroid/view/View;->setAlpha(F)V

    .line 47
    .line 48
    .line 49
    return-void

    .line 50
    :cond_2
    :goto_0
    invoke-virtual {p2}, Landroid/view/View;->getWidth()I

    .line 51
    .line 52
    .line 53
    move-result p1

    .line 54
    int-to-float p1, p1

    .line 55
    invoke-virtual {p2, p1}, Landroid/view/View;->setTranslationX(F)V

    .line 56
    .line 57
    .line 58
    invoke-virtual {p2, v1}, Landroid/view/View;->setAlpha(F)V

    .line 59
    .line 60
    .line 61
    const/4 p1, 0x0

    .line 62
    invoke-virtual {p2, p1}, Landroid/view/View;->setClickable(Z)V

    .line 63
    .line 64
    .line 65
    return-void
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

.method private final transformParallax(FLandroid/view/View;)V
    .locals 1

    .line 1
    const/high16 v0, -0x40800000    # -1.0f

    .line 2
    .line 3
    cmpl-float v0, p1, v0

    .line 4
    .line 5
    if-lez v0, :cond_0

    .line 6
    .line 7
    const/high16 v0, 0x3f800000    # 1.0f

    .line 8
    .line 9
    cmpg-float v0, p1, v0

    .line 10
    .line 11
    if-gez v0, :cond_0

    .line 12
    .line 13
    :try_start_0
    invoke-direct {p0, p2, p1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->applyParallax(Landroid/view/View;F)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 14
    .line 15
    .line 16
    return-void

    .line 17
    :catch_0
    move-exception p1

    .line 18
    sget-object p2, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->TAG:Ljava/lang/String;

    .line 19
    .line 20
    const-string v0, "Failed to apply parallax effect"

    .line 21
    .line 22
    invoke-static {p2, v0, p1}, Lcom/github/appintro/internal/LogHelper;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 23
    .line 24
    .line 25
    :cond_0
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

.method private final transformSlideOver(FLandroid/view/View;)V
    .locals 4

    .line 1
    const/4 v0, 0x0

    .line 2
    cmpg-float v1, p1, v0

    .line 3
    .line 4
    if-gez v1, :cond_1

    .line 5
    .line 6
    const/high16 v1, -0x40800000    # -1.0f

    .line 7
    .line 8
    cmpl-float v1, p1, v1

    .line 9
    .line 10
    if-lez v1, :cond_1

    .line 11
    .line 12
    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    .line 13
    .line 14
    .line 15
    move-result v1

    .line 16
    const/4 v2, 0x1

    .line 17
    int-to-float v2, v2

    .line 18
    sub-float/2addr v1, v2

    .line 19
    invoke-static {v1}, Ljava/lang/Math;->abs(F)F

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    const v3, 0x3e199998    # 0.14999998f

    .line 24
    .line 25
    .line 26
    mul-float v1, v1, v3

    .line 27
    .line 28
    const v3, 0x3f59999a    # 0.85f

    .line 29
    .line 30
    .line 31
    add-float/2addr v1, v3

    .line 32
    invoke-static {p2, v1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$setScaleXY(Landroid/view/View;F)V

    .line 33
    .line 34
    .line 35
    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    .line 36
    .line 37
    .line 38
    move-result v1

    .line 39
    sub-float/2addr v2, v1

    .line 40
    const v1, 0x3eb33333    # 0.35f

    .line 41
    .line 42
    .line 43
    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    .line 44
    .line 45
    .line 46
    move-result v1

    .line 47
    invoke-virtual {p2, v1}, Landroid/view/View;->setAlpha(F)V

    .line 48
    .line 49
    .line 50
    invoke-virtual {p2}, Landroid/view/View;->getWidth()I

    .line 51
    .line 52
    .line 53
    move-result v1

    .line 54
    neg-int v1, v1

    .line 55
    int-to-float v1, v1

    .line 56
    mul-float p1, p1, v1

    .line 57
    .line 58
    cmpl-float v1, p1, v1

    .line 59
    .line 60
    if-lez v1, :cond_0

    .line 61
    .line 62
    invoke-virtual {p2, p1}, Landroid/view/View;->setTranslationX(F)V

    .line 63
    .line 64
    .line 65
    return-void

    .line 66
    :cond_0
    invoke-virtual {p2, v0}, Landroid/view/View;->setTranslationX(F)V

    .line 67
    .line 68
    .line 69
    return-void

    .line 70
    :cond_1
    invoke-static {p2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$transformDefaults(Landroid/view/View;)V

    .line 71
    .line 72
    .line 73
    return-void
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

.method private final transformZoom(FLandroid/view/View;)V
    .locals 5

    .line 1
    const/high16 v0, -0x40800000    # -1.0f

    .line 2
    .line 3
    cmpl-float v0, p1, v0

    .line 4
    .line 5
    if-ltz v0, :cond_1

    .line 6
    .line 7
    const/high16 v0, 0x3f800000    # 1.0f

    .line 8
    .line 9
    cmpg-float v0, p1, v0

    .line 10
    .line 11
    if-gtz v0, :cond_1

    .line 12
    .line 13
    const/4 v0, 0x1

    .line 14
    int-to-float v0, v0

    .line 15
    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    .line 16
    .line 17
    .line 18
    move-result v1

    .line 19
    sub-float v1, v0, v1

    .line 20
    .line 21
    const v2, 0x3f59999a    # 0.85f

    .line 22
    .line 23
    .line 24
    invoke-static {v2, v1}, Ljava/lang/Math;->max(FF)F

    .line 25
    .line 26
    .line 27
    move-result v1

    .line 28
    invoke-static {p2, v1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$setScaleXY(Landroid/view/View;F)V

    .line 29
    .line 30
    .line 31
    invoke-static {p2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$getScaleXY(Landroid/view/View;)F

    .line 32
    .line 33
    .line 34
    move-result v1

    .line 35
    sub-float/2addr v1, v2

    .line 36
    const v2, 0x3e199998    # 0.14999998f

    .line 37
    .line 38
    .line 39
    div-float/2addr v1, v2

    .line 40
    const/high16 v2, 0x3f000000    # 0.5f

    .line 41
    .line 42
    mul-float v1, v1, v2

    .line 43
    .line 44
    add-float/2addr v1, v2

    .line 45
    invoke-virtual {p2, v1}, Landroid/view/View;->setAlpha(F)V

    .line 46
    .line 47
    .line 48
    invoke-virtual {p2}, Landroid/view/View;->getHeight()I

    .line 49
    .line 50
    .line 51
    move-result v1

    .line 52
    int-to-float v1, v1

    .line 53
    invoke-static {p2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$getScaleXY(Landroid/view/View;)F

    .line 54
    .line 55
    .line 56
    move-result v2

    .line 57
    sub-float v2, v0, v2

    .line 58
    .line 59
    mul-float v2, v2, v1

    .line 60
    .line 61
    const/4 v1, 0x2

    .line 62
    int-to-float v1, v1

    .line 63
    div-float/2addr v2, v1

    .line 64
    invoke-virtual {p2}, Landroid/view/View;->getWidth()I

    .line 65
    .line 66
    .line 67
    move-result v3

    .line 68
    int-to-float v3, v3

    .line 69
    invoke-static {p2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$getScaleXY(Landroid/view/View;)F

    .line 70
    .line 71
    .line 72
    move-result v4

    .line 73
    sub-float/2addr v0, v4

    .line 74
    mul-float v0, v0, v3

    .line 75
    .line 76
    div-float/2addr v0, v1

    .line 77
    const/4 v3, 0x0

    .line 78
    cmpg-float p1, p1, v3

    .line 79
    .line 80
    if-gez p1, :cond_0

    .line 81
    .line 82
    div-float/2addr v2, v1

    .line 83
    sub-float/2addr v0, v2

    .line 84
    invoke-virtual {p2, v0}, Landroid/view/View;->setTranslationX(F)V

    .line 85
    .line 86
    .line 87
    return-void

    .line 88
    :cond_0
    neg-float p1, v0

    .line 89
    div-float/2addr v2, v1

    .line 90
    add-float/2addr v2, p1

    .line 91
    invoke-virtual {p2, v2}, Landroid/view/View;->setTranslationX(F)V

    .line 92
    .line 93
    .line 94
    return-void

    .line 95
    :cond_1
    invoke-static {p2}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformerKt;->access$transformDefaults(Landroid/view/View;)V

    .line 96
    .line 97
    .line 98
    return-void
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
.method public transformPage(Landroid/view/View;F)V
    .locals 2

    .line 1
    const-string v0, "page"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformType:Lcom/github/appintro/AppIntroPageTransformerType;

    .line 7
    .line 8
    sget-object v1, Lcom/github/appintro/AppIntroPageTransformerType$Flow;->INSTANCE:Lcom/github/appintro/AppIntroPageTransformerType$Flow;

    .line 9
    .line 10
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 11
    .line 12
    .line 13
    move-result v1

    .line 14
    if-eqz v1, :cond_0

    .line 15
    .line 16
    const/high16 v0, -0x3e100000    # -30.0f

    .line 17
    .line 18
    mul-float p2, p2, v0

    .line 19
    .line 20
    invoke-virtual {p1, p2}, Landroid/view/View;->setRotationY(F)V

    .line 21
    .line 22
    .line 23
    return-void

    .line 24
    :cond_0
    sget-object v1, Lcom/github/appintro/AppIntroPageTransformerType$SlideOver;->INSTANCE:Lcom/github/appintro/AppIntroPageTransformerType$SlideOver;

    .line 25
    .line 26
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    if-eqz v1, :cond_1

    .line 31
    .line 32
    invoke-direct {p0, p2, p1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformSlideOver(FLandroid/view/View;)V

    .line 33
    .line 34
    .line 35
    return-void

    .line 36
    :cond_1
    sget-object v1, Lcom/github/appintro/AppIntroPageTransformerType$Depth;->INSTANCE:Lcom/github/appintro/AppIntroPageTransformerType$Depth;

    .line 37
    .line 38
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 39
    .line 40
    .line 41
    move-result v1

    .line 42
    if-eqz v1, :cond_2

    .line 43
    .line 44
    invoke-direct {p0, p2, p1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformDepth(FLandroid/view/View;)V

    .line 45
    .line 46
    .line 47
    return-void

    .line 48
    :cond_2
    sget-object v1, Lcom/github/appintro/AppIntroPageTransformerType$Zoom;->INSTANCE:Lcom/github/appintro/AppIntroPageTransformerType$Zoom;

    .line 49
    .line 50
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 51
    .line 52
    .line 53
    move-result v1

    .line 54
    if-eqz v1, :cond_3

    .line 55
    .line 56
    invoke-direct {p0, p2, p1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformZoom(FLandroid/view/View;)V

    .line 57
    .line 58
    .line 59
    return-void

    .line 60
    :cond_3
    sget-object v1, Lcom/github/appintro/AppIntroPageTransformerType$Fade;->INSTANCE:Lcom/github/appintro/AppIntroPageTransformerType$Fade;

    .line 61
    .line 62
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 63
    .line 64
    .line 65
    move-result v1

    .line 66
    if-eqz v1, :cond_4

    .line 67
    .line 68
    invoke-direct {p0, p2, p1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformFade(FLandroid/view/View;)V

    .line 69
    .line 70
    .line 71
    return-void

    .line 72
    :cond_4
    instance-of v0, v0, Lcom/github/appintro/AppIntroPageTransformerType$Parallax;

    .line 73
    .line 74
    if-eqz v0, :cond_5

    .line 75
    .line 76
    iget-object v0, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformType:Lcom/github/appintro/AppIntroPageTransformerType;

    .line 77
    .line 78
    check-cast v0, Lcom/github/appintro/AppIntroPageTransformerType$Parallax;

    .line 79
    .line 80
    invoke-virtual {v0}, Lcom/github/appintro/AppIntroPageTransformerType$Parallax;->getTitleParallaxFactor()D

    .line 81
    .line 82
    .line 83
    move-result-wide v0

    .line 84
    iput-wide v0, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->titlePF:D

    .line 85
    .line 86
    iget-object v0, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformType:Lcom/github/appintro/AppIntroPageTransformerType;

    .line 87
    .line 88
    check-cast v0, Lcom/github/appintro/AppIntroPageTransformerType$Parallax;

    .line 89
    .line 90
    invoke-virtual {v0}, Lcom/github/appintro/AppIntroPageTransformerType$Parallax;->getImageParallaxFactor()D

    .line 91
    .line 92
    .line 93
    move-result-wide v0

    .line 94
    iput-wide v0, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->imagePF:D

    .line 95
    .line 96
    iget-object v0, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformType:Lcom/github/appintro/AppIntroPageTransformerType;

    .line 97
    .line 98
    check-cast v0, Lcom/github/appintro/AppIntroPageTransformerType$Parallax;

    .line 99
    .line 100
    invoke-virtual {v0}, Lcom/github/appintro/AppIntroPageTransformerType$Parallax;->getDescriptionParallaxFactor()D

    .line 101
    .line 102
    .line 103
    move-result-wide v0

    .line 104
    iput-wide v0, p0, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->descriptionPF:D

    .line 105
    .line 106
    invoke-direct {p0, p2, p1}, Lcom/github/appintro/internal/viewpager/ViewPagerTransformer;->transformParallax(FLandroid/view/View;)V

    .line 107
    .line 108
    .line 109
    :cond_5
    return-void
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
