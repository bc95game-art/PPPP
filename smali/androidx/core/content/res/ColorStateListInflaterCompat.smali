.class public abstract Landroidx/core/content/res/ColorStateListInflaterCompat;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final sTempTypedValue:Ljava/lang/ThreadLocal;


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
    sput-object v0, Landroidx/core/content/res/ColorStateListInflaterCompat;->sTempTypedValue:Ljava/lang/ThreadLocal;

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

.method public static createFromXml(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;
    .locals 4

    .line 1
    invoke-static {p1}, Landroid/util/Xml;->asAttributeSet(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    :goto_0
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    const/4 v2, 0x2

    .line 10
    if-eq v1, v2, :cond_0

    .line 11
    .line 12
    const/4 v3, 0x1

    .line 13
    if-eq v1, v3, :cond_0

    .line 14
    .line 15
    goto :goto_0

    .line 16
    :cond_0
    if-ne v1, v2, :cond_1

    .line 17
    .line 18
    invoke-static {p0, p1, v0, p2}, Landroidx/core/content/res/ColorStateListInflaterCompat;->createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;

    .line 19
    .line 20
    .line 21
    move-result-object p0

    .line 22
    return-object p0

    .line 23
    :cond_1
    new-instance p0, Lorg/xmlpull/v1/XmlPullParserException;

    .line 24
    .line 25
    const-string p1, "No start tag found"

    .line 26
    .line 27
    invoke-direct {p0, p1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    .line 28
    .line 29
    .line 30
    throw p0
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

.method public static createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;
    .locals 36

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    .line 1
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 2
    const-string v4, "selector"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_23

    .line 3
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v3

    const/4 v4, 0x1

    add-int/2addr v3, v4

    const/16 v5, 0x14

    .line 4
    new-array v6, v5, [[I

    .line 5
    new-array v5, v5, [I

    const/4 v7, 0x0

    const/4 v8, 0x0

    .line 6
    :goto_0
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v9

    if-eq v9, v4, :cond_22

    .line 7
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v10

    const/4 v11, 0x3

    if-ge v10, v3, :cond_0

    if-eq v9, v11, :cond_22

    :cond_0
    const/4 v12, 0x2

    if-ne v9, v12, :cond_1

    if-gt v10, v3, :cond_1

    .line 8
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v9

    const-string v10, "item"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_2

    :cond_1
    move/from16 v34, v3

    const/16 v16, 0x1

    goto/16 :goto_19

    .line 9
    :cond_2
    sget-object v9, Landroidx/core/R$styleable;->ColorStateListItem:[I

    if-nez v2, :cond_3

    invoke-virtual {v0, v1, v9}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v9

    goto :goto_1

    .line 10
    :cond_3
    invoke-virtual {v2, v1, v9, v7, v7}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v9

    :goto_1
    const/4 v10, -0x1

    .line 11
    invoke-virtual {v9, v7, v10}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v13

    const v14, -0xff01

    const/16 v15, 0x1f

    if-eq v13, v10, :cond_6

    .line 12
    sget-object v10, Landroidx/core/content/res/ColorStateListInflaterCompat;->sTempTypedValue:Ljava/lang/ThreadLocal;

    invoke-virtual {v10}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Landroid/util/TypedValue;

    if-nez v16, :cond_4

    .line 13
    new-instance v12, Landroid/util/TypedValue;

    invoke-direct {v12}, Landroid/util/TypedValue;-><init>()V

    .line 14
    invoke-virtual {v10, v12}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    goto :goto_2

    :cond_4
    move-object/from16 v12, v16

    .line 15
    :goto_2
    invoke-virtual {v0, v13, v12, v4}, Landroid/content/res/Resources;->getValue(ILandroid/util/TypedValue;Z)V

    .line 16
    iget v10, v12, Landroid/util/TypedValue;->type:I

    const/16 v12, 0x1c

    if-lt v10, v12, :cond_5

    if-gt v10, v15, :cond_5

    goto :goto_3

    .line 17
    :cond_5
    :try_start_0
    invoke-virtual {v0, v13}, Landroid/content/res/Resources;->getXml(I)Landroid/content/res/XmlResourceParser;

    move-result-object v10

    invoke-static {v0, v10, v2}, Landroidx/core/content/res/ColorStateListInflaterCompat;->createFromXml(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/content/res/Resources$Theme;)Landroid/content/res/ColorStateList;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v10
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_4

    .line 18
    :catch_0
    invoke-virtual {v9, v7, v14}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v10

    goto :goto_4

    .line 19
    :cond_6
    :goto_3
    invoke-virtual {v9, v7, v14}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v10

    .line 20
    :goto_4
    invoke-virtual {v9, v4}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v12

    const/high16 v13, 0x3f800000    # 1.0f

    if-eqz v12, :cond_7

    .line 21
    invoke-virtual {v9, v4, v13}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v11

    goto :goto_5

    .line 22
    :cond_7
    invoke-virtual {v9, v11}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v12

    if-eqz v12, :cond_8

    .line 23
    invoke-virtual {v9, v11, v13}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v11

    goto :goto_5

    :cond_8
    const/high16 v11, 0x3f800000    # 1.0f

    .line 24
    :goto_5
    sget v12, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v14, 0x4

    const/16 v16, 0x1

    const/high16 v4, -0x40800000    # -1.0f

    if-lt v12, v15, :cond_9

    const/4 v12, 0x2

    .line 25
    invoke-virtual {v9, v12}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v15

    if-eqz v15, :cond_9

    .line 26
    invoke-virtual {v9, v12, v4}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v4

    goto :goto_6

    .line 27
    :cond_9
    invoke-virtual {v9, v14, v4}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v4

    .line 28
    :goto_6
    invoke-virtual {v9}, Landroid/content/res/TypedArray;->recycle()V

    .line 29
    invoke-interface {v1}, Landroid/util/AttributeSet;->getAttributeCount()I

    move-result v9

    .line 30
    new-array v12, v9, [I

    const/4 v13, 0x0

    const/4 v15, 0x0

    const/high16 v18, 0x3f800000    # 1.0f

    :goto_7
    if-ge v15, v9, :cond_c

    .line 31
    invoke-interface {v1, v15}, Landroid/util/AttributeSet;->getAttributeNameResource(I)I

    move-result v14

    const v7, 0x10101a5

    if-eq v14, v7, :cond_b

    const v7, 0x101031f

    if-eq v14, v7, :cond_b

    const v7, 0x7f040035

    if-eq v14, v7, :cond_b

    const v7, 0x7f0402dc

    if-eq v14, v7, :cond_b

    add-int/lit8 v7, v13, 0x1

    const/4 v0, 0x0

    .line 32
    invoke-interface {v1, v15, v0}, Landroid/util/AttributeSet;->getAttributeBooleanValue(IZ)Z

    move-result v20

    if-eqz v20, :cond_a

    goto :goto_8

    :cond_a
    neg-int v14, v14

    .line 33
    :goto_8
    aput v14, v12, v13

    move v13, v7

    :cond_b
    add-int/lit8 v15, v15, 0x1

    move-object/from16 v0, p0

    const/4 v7, 0x0

    const/4 v14, 0x4

    goto :goto_7

    .line 34
    :cond_c
    invoke-static {v12, v13}, Landroid/util/StateSet;->trimStateSet([II)[I

    move-result-object v0

    const/high16 v7, 0x42c80000    # 100.0f

    const/4 v9, 0x0

    cmpl-float v12, v4, v9

    if-ltz v12, :cond_d

    cmpg-float v12, v4, v7

    if-gtz v12, :cond_d

    const/4 v12, 0x1

    goto :goto_9

    :cond_d
    const/4 v12, 0x0

    :goto_9
    cmpl-float v13, v11, v18

    if-nez v13, :cond_e

    if-nez v12, :cond_e

    move-object/from16 v31, v0

    move/from16 v34, v3

    goto/16 :goto_16

    .line 35
    :cond_e
    invoke-static {v10}, Landroid/graphics/Color;->alpha(I)I

    move-result v13

    int-to-float v13, v13

    mul-float v13, v13, v11

    const/high16 v11, 0x3f000000    # 0.5f

    add-float/2addr v13, v11

    float-to-int v11, v13

    const/16 v13, 0xff

    const/4 v14, 0x0

    .line 36
    invoke-static {v11, v14, v13}, Landroidx/core/os/BundleKt;->clamp(III)I

    move-result v11

    if-eqz v12, :cond_1d

    .line 37
    invoke-static {v10}, Landroidx/core/content/res/CamColor;->fromColor(I)Landroidx/core/content/res/CamColor;

    move-result-object v10

    .line 38
    iget v12, v10, Landroidx/core/content/res/CamColor;->mHue:F

    .line 39
    iget v10, v10, Landroidx/core/content/res/CamColor;->mChroma:F

    .line 40
    sget-object v13, Landroidx/core/content/res/ViewingConditions;->DEFAULT:Landroidx/core/content/res/ViewingConditions;

    float-to-double v14, v10

    const-wide/high16 v20, 0x3ff0000000000000L    # 1.0

    cmpg-double v22, v14, v20

    if-ltz v22, :cond_f

    .line 41
    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v14

    int-to-double v14, v14

    const-wide/16 v20, 0x0

    cmpg-double v22, v14, v20

    if-lez v22, :cond_f

    invoke-static {v4}, Ljava/lang/Math;->round(F)I

    move-result v14

    int-to-double v14, v14

    const-wide/high16 v20, 0x4059000000000000L    # 100.0

    cmpl-double v22, v14, v20

    if-ltz v22, :cond_10

    :cond_f
    move-object/from16 v31, v0

    move/from16 v34, v3

    goto/16 :goto_14

    :cond_10
    cmpg-float v14, v12, v9

    if-gez v14, :cond_11

    const/4 v12, 0x0

    goto :goto_a

    :cond_11
    const/high16 v14, 0x43b40000    # 360.0f

    .line 42
    invoke-static {v14, v12}, Ljava/lang/Math;->min(FF)F

    move-result v12

    :goto_a
    move v15, v10

    const/4 v7, 0x0

    const/16 v20, 0x1

    const/16 v21, 0x0

    const/high16 v22, 0x42c80000    # 100.0f

    :goto_b
    sub-float v23, v21, v10

    .line 43
    invoke-static/range {v23 .. v23}, Ljava/lang/Math;->abs(F)F

    move-result v23

    const v24, 0x3ecccccd    # 0.4f

    cmpl-float v23, v23, v24

    if-ltz v23, :cond_1b

    const/high16 v23, 0x447a0000    # 1000.0f

    const/high16 v24, 0x447a0000    # 1000.0f

    const/16 v25, 0x0

    const/high16 v26, 0x42c80000    # 100.0f

    const/16 v27, 0x0

    :goto_c
    sub-float v28, v25, v26

    .line 44
    invoke-static/range {v28 .. v28}, Ljava/lang/Math;->abs(F)F

    move-result v28

    const v29, 0x3c23d70a    # 0.01f

    const/high16 v30, 0x40000000    # 2.0f

    cmpl-float v28, v28, v29

    if-lez v28, :cond_17

    sub-float v28, v26, v25

    div-float v28, v28, v30

    const/16 v29, 0x0

    add-float v9, v28, v25

    .line 45
    invoke-static {v9, v15, v12}, Landroidx/core/content/res/CamColor;->fromJch(FFF)Landroidx/core/content/res/CamColor;

    move-result-object v14

    move-object/from16 v31, v0

    .line 46
    sget-object v0, Landroidx/core/content/res/ViewingConditions;->DEFAULT:Landroidx/core/content/res/ViewingConditions;

    invoke-virtual {v14, v0}, Landroidx/core/content/res/CamColor;->viewed(Landroidx/core/content/res/ViewingConditions;)I

    move-result v0

    .line 47
    invoke-static {v0}, Landroid/graphics/Color;->red(I)I

    move-result v14

    invoke-static {v14}, Landroidx/core/content/res/CamUtils;->linearized(I)F

    move-result v14

    .line 48
    invoke-static {v0}, Landroid/graphics/Color;->green(I)I

    move-result v32

    invoke-static/range {v32 .. v32}, Landroidx/core/content/res/CamUtils;->linearized(I)F

    move-result v32

    .line 49
    invoke-static {v0}, Landroid/graphics/Color;->blue(I)I

    move-result v33

    invoke-static/range {v33 .. v33}, Landroidx/core/content/res/CamUtils;->linearized(I)F

    move-result v33

    .line 50
    sget-object v34, Landroidx/core/content/res/CamUtils;->SRGB_TO_XYZ:[[F

    .line 51
    aget-object v34, v34, v16

    const/16 v19, 0x0

    aget v35, v34, v19

    mul-float v14, v14, v35

    aget v35, v34, v16

    mul-float v32, v32, v35

    add-float v32, v32, v14

    const/16 v17, 0x2

    aget v14, v34, v17

    mul-float v33, v33, v14

    add-float v33, v33, v32

    div-float v14, v33, v22

    const v32, 0x3c111aa7

    cmpg-float v32, v14, v32

    if-gtz v32, :cond_12

    const v32, 0x4461d2f7

    mul-float v14, v14, v32

    move/from16 v32, v0

    goto :goto_d

    :cond_12
    move/from16 v32, v0

    float-to-double v0, v14

    .line 52
    invoke-static {v0, v1}, Ljava/lang/Math;->cbrt(D)D

    move-result-wide v0

    double-to-float v0, v0

    const/high16 v1, 0x42e80000    # 116.0f

    mul-float v0, v0, v1

    const/high16 v1, 0x41800000    # 16.0f

    sub-float v14, v0, v1

    :goto_d
    sub-float v0, v4, v14

    .line 53
    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    const v1, 0x3e4ccccd    # 0.2f

    cmpg-float v1, v0, v1

    if-gez v1, :cond_13

    .line 54
    invoke-static/range {v32 .. v32}, Landroidx/core/content/res/CamColor;->fromColor(I)Landroidx/core/content/res/CamColor;

    move-result-object v1

    move/from16 v32, v0

    .line 55
    iget v0, v1, Landroidx/core/content/res/CamColor;->mJ:F

    .line 56
    iget v2, v1, Landroidx/core/content/res/CamColor;->mChroma:F

    .line 57
    invoke-static {v0, v2, v12}, Landroidx/core/content/res/CamColor;->fromJch(FFF)Landroidx/core/content/res/CamColor;

    move-result-object v0

    .line 58
    iget v2, v1, Landroidx/core/content/res/CamColor;->mJstar:F

    move/from16 v33, v2

    .line 59
    iget v2, v0, Landroidx/core/content/res/CamColor;->mJstar:F

    sub-float v2, v33, v2

    move/from16 v33, v2

    .line 60
    iget v2, v1, Landroidx/core/content/res/CamColor;->mAstar:F

    move/from16 v34, v2

    iget v2, v0, Landroidx/core/content/res/CamColor;->mAstar:F

    sub-float v2, v34, v2

    move/from16 v34, v2

    .line 61
    iget v2, v1, Landroidx/core/content/res/CamColor;->mBstar:F

    iget v0, v0, Landroidx/core/content/res/CamColor;->mBstar:F

    sub-float/2addr v2, v0

    mul-float v0, v33, v33

    mul-float v33, v34, v34

    add-float v33, v33, v0

    mul-float v2, v2, v2

    add-float v2, v2, v33

    move-object/from16 v33, v1

    float-to-double v0, v2

    .line 62
    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    move/from16 v34, v3

    const-wide v2, 0x3fe428f5c28f5c29L    # 0.63

    .line 63
    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    const-wide v2, 0x3ff68f5c28f5c28fL    # 1.41

    mul-double v0, v0, v2

    double-to-float v0, v0

    cmpg-float v1, v0, v18

    if-gtz v1, :cond_14

    move/from16 v24, v0

    move/from16 v23, v32

    move-object/from16 v27, v33

    goto :goto_e

    :cond_13
    move/from16 v34, v3

    :cond_14
    :goto_e
    cmpl-float v0, v23, v29

    if-nez v0, :cond_15

    cmpl-float v0, v24, v29

    if-nez v0, :cond_15

    :goto_f
    move-object/from16 v0, v27

    goto :goto_11

    :cond_15
    cmpg-float v0, v14, v4

    if-gez v0, :cond_16

    move/from16 v25, v9

    goto :goto_10

    :cond_16
    move/from16 v26, v9

    :goto_10
    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v0, v31

    move/from16 v3, v34

    const/4 v9, 0x0

    goto/16 :goto_c

    :cond_17
    move-object/from16 v31, v0

    move/from16 v34, v3

    const/16 v17, 0x2

    const/16 v29, 0x0

    goto :goto_f

    :goto_11
    if-eqz v20, :cond_19

    if-eqz v0, :cond_18

    .line 64
    invoke-virtual {v0, v13}, Landroidx/core/content/res/CamColor;->viewed(Landroidx/core/content/res/ViewingConditions;)I

    move-result v0

    :goto_12
    move v10, v0

    goto :goto_15

    :cond_18
    sub-float v0, v10, v21

    div-float v0, v0, v30

    add-float v15, v0, v21

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v0, v31

    move/from16 v3, v34

    const/4 v9, 0x0

    const/16 v20, 0x0

    goto/16 :goto_b

    :cond_19
    if-nez v0, :cond_1a

    move v10, v15

    goto :goto_13

    :cond_1a
    move-object v7, v0

    move/from16 v21, v15

    :goto_13
    sub-float v0, v10, v21

    div-float v0, v0, v30

    add-float v15, v0, v21

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v0, v31

    move/from16 v3, v34

    const/4 v9, 0x0

    goto/16 :goto_b

    :cond_1b
    move-object/from16 v31, v0

    move/from16 v34, v3

    if-nez v7, :cond_1c

    .line 65
    invoke-static {v4}, Landroidx/core/content/res/CamUtils;->intFromLStar(F)I

    move-result v0

    goto :goto_12

    .line 66
    :cond_1c
    invoke-virtual {v7, v13}, Landroidx/core/content/res/CamColor;->viewed(Landroidx/core/content/res/ViewingConditions;)I

    move-result v0

    goto :goto_12

    .line 67
    :goto_14
    invoke-static {v4}, Landroidx/core/content/res/CamUtils;->intFromLStar(F)I

    move-result v0

    goto :goto_12

    :cond_1d
    move-object/from16 v31, v0

    move/from16 v34, v3

    :goto_15
    const v0, 0xffffff

    and-int/2addr v0, v10

    shl-int/lit8 v1, v11, 0x18

    or-int v10, v0, v1

    :goto_16
    add-int/lit8 v0, v8, 0x1

    .line 68
    array-length v1, v5

    const/16 v2, 0x8

    if-le v0, v1, :cond_1f

    const/4 v1, 0x4

    if-gt v8, v1, :cond_1e

    const/16 v1, 0x8

    goto :goto_17

    :cond_1e
    mul-int/lit8 v1, v8, 0x2

    .line 69
    :goto_17
    new-array v1, v1, [I

    const/4 v14, 0x0

    .line 70
    invoke-static {v5, v14, v1, v14, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v5, v1

    .line 71
    :cond_1f
    aput v10, v5, v8

    .line 72
    array-length v1, v6

    if-le v0, v1, :cond_21

    .line 73
    invoke-virtual {v6}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v1

    const/4 v3, 0x4

    if-gt v8, v3, :cond_20

    goto :goto_18

    :cond_20
    mul-int/lit8 v2, v8, 0x2

    :goto_18
    invoke-static {v1, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/Object;

    const/4 v14, 0x0

    .line 74
    invoke-static {v6, v14, v1, v14, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v6, v1

    .line 75
    :cond_21
    aput-object v31, v6, v8

    .line 76
    check-cast v6, [[I

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move v8, v0

    move/from16 v3, v34

    const/4 v4, 0x1

    const/4 v7, 0x0

    move-object/from16 v0, p0

    goto/16 :goto_0

    :goto_19
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move/from16 v3, v34

    const/4 v4, 0x1

    const/4 v7, 0x0

    goto/16 :goto_0

    .line 77
    :cond_22
    new-array v0, v8, [I

    .line 78
    new-array v1, v8, [[I

    const/4 v14, 0x0

    .line 79
    invoke-static {v5, v14, v0, v14, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 80
    invoke-static {v6, v14, v1, v14, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 81
    new-instance v2, Landroid/content/res/ColorStateList;

    invoke-direct {v2, v1, v0}, Landroid/content/res/ColorStateList;-><init>([[I[I)V

    return-object v2

    .line 82
    :cond_23
    new-instance v0, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 83
    invoke-interface/range {p1 .. p1}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ": invalid color state list tag "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
