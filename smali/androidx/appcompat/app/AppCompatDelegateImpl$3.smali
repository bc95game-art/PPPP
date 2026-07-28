.class public final Landroidx/appcompat/app/AppCompatDelegateImpl$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/core/view/OnApplyWindowInsetsListener;
.implements Landroidx/appcompat/widget/ContentFrameLayout$OnAttachListener;
.implements Landroidx/appcompat/app/ActionBarDrawerToggle$Delegate;
.implements Landroidx/appcompat/view/menu/MenuPresenter$Callback;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;


# direct methods
.method public synthetic constructor <init>(Landroidx/appcompat/app/AppCompatDelegateImpl;I)V
    .locals 0

    .line 1
    iput p2, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->$r8$classId:I

    iput-object p1, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getActionBarThemedContext()Landroid/content/Context;
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/appcompat/app/AppCompatDelegateImpl;->getActionBarThemedContext()Landroid/content/Context;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public getThemeUpIndicator()Landroid/graphics/drawable/Drawable;
    .locals 3

    .line 1
    iget-object v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/appcompat/app/AppCompatDelegateImpl;->getActionBarThemedContext()Landroid/content/Context;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const v1, 0x7f040288

    .line 8
    .line 9
    .line 10
    filled-new-array {v1}, [I

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    const/4 v2, 0x0

    .line 15
    invoke-static {v0, v2, v1}, Lkotlin/text/MatcherMatchResult;->obtainStyledAttributes(Landroid/content/Context;Landroid/util/AttributeSet;[I)Lkotlin/text/MatcherMatchResult;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    const/4 v1, 0x0

    .line 20
    invoke-virtual {v0, v1}, Lkotlin/text/MatcherMatchResult;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    .line 21
    .line 22
    .line 23
    move-result-object v1

    .line 24
    invoke-virtual {v0}, Lkotlin/text/MatcherMatchResult;->recycle()V

    .line 25
    .line 26
    .line 27
    return-object v1
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

.method public isNavigationVisible()Z
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/appcompat/app/AppCompatDelegateImpl;->initWindowDecorActionBar()V

    .line 4
    .line 5
    .line 6
    iget-object v0, v0, Landroidx/appcompat/app/AppCompatDelegateImpl;->mActionBar:Landroidx/appcompat/app/ActionBar;

    .line 7
    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    invoke-virtual {v0}, Landroidx/appcompat/app/ActionBar;->getDisplayOptions()I

    .line 11
    .line 12
    .line 13
    move-result v0

    .line 14
    and-int/lit8 v0, v0, 0x4

    .line 15
    .line 16
    if-eqz v0, :cond_0

    .line 17
    .line 18
    const/4 v0, 0x1

    .line 19
    return v0

    .line 20
    :cond_0
    const/4 v0, 0x0

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

.method public onApplyWindowInsets(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 18

    .line 1
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetTop()I

    .line 2
    .line 3
    .line 4
    move-result v1

    .line 5
    move-object/from16 v2, p0

    .line 6
    .line 7
    iget-object v3, v2, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 8
    .line 9
    iget-object v4, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mContext:Landroid/content/Context;

    .line 10
    .line 11
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetTop()I

    .line 12
    .line 13
    .line 14
    move-result v5

    .line 15
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mActionModeView:Landroidx/appcompat/widget/ActionBarContextView;

    .line 16
    .line 17
    const/16 v6, 0x8

    .line 18
    .line 19
    if-eqz v0, :cond_12

    .line 20
    .line 21
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    instance-of v0, v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 26
    .line 27
    if-eqz v0, :cond_12

    .line 28
    .line 29
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mActionModeView:Landroidx/appcompat/widget/ActionBarContextView;

    .line 30
    .line 31
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    move-object v8, v0

    .line 36
    check-cast v8, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 37
    .line 38
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mActionModeView:Landroidx/appcompat/widget/ActionBarContextView;

    .line 39
    .line 40
    invoke-virtual {v0}, Landroid/view/View;->isShown()Z

    .line 41
    .line 42
    .line 43
    move-result v0

    .line 44
    const/4 v9, 0x1

    .line 45
    if-eqz v0, :cond_10

    .line 46
    .line 47
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mTempRect1:Landroid/graphics/Rect;

    .line 48
    .line 49
    if-nez v0, :cond_0

    .line 50
    .line 51
    new-instance v0, Landroid/graphics/Rect;

    .line 52
    .line 53
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 54
    .line 55
    .line 56
    iput-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mTempRect1:Landroid/graphics/Rect;

    .line 57
    .line 58
    new-instance v0, Landroid/graphics/Rect;

    .line 59
    .line 60
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 61
    .line 62
    .line 63
    iput-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mTempRect2:Landroid/graphics/Rect;

    .line 64
    .line 65
    :cond_0
    iget-object v10, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mTempRect1:Landroid/graphics/Rect;

    .line 66
    .line 67
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mTempRect2:Landroid/graphics/Rect;

    .line 68
    .line 69
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetLeft()I

    .line 70
    .line 71
    .line 72
    move-result v11

    .line 73
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetTop()I

    .line 74
    .line 75
    .line 76
    move-result v12

    .line 77
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetRight()I

    .line 78
    .line 79
    .line 80
    move-result v13

    .line 81
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetBottom()I

    .line 82
    .line 83
    .line 84
    move-result v14

    .line 85
    invoke-virtual {v10, v11, v12, v13, v14}, Landroid/graphics/Rect;->set(IIII)V

    .line 86
    .line 87
    .line 88
    iget-object v11, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mSubDecor:Landroid/view/ViewGroup;

    .line 89
    .line 90
    sget v12, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 91
    .line 92
    const/16 v13, 0x1d

    .line 93
    .line 94
    if-lt v12, v13, :cond_1

    .line 95
    .line 96
    sget-boolean v12, Landroidx/appcompat/widget/ViewUtils;->sInitComputeFitSystemWindowsMethod:Z

    .line 97
    .line 98
    invoke-static {v11, v10, v0}, Landroidx/appcompat/widget/ViewUtils$Api29Impl;->computeFitSystemWindows(Landroid/view/View;Landroid/graphics/Rect;Landroid/graphics/Rect;)V

    .line 99
    .line 100
    .line 101
    const/16 v16, 0x0

    .line 102
    .line 103
    goto :goto_1

    .line 104
    :cond_1
    sget-boolean v12, Landroidx/appcompat/widget/ViewUtils;->sInitComputeFitSystemWindowsMethod:Z

    .line 105
    .line 106
    const/4 v13, 0x2

    .line 107
    const-string v14, "ViewUtils"

    .line 108
    .line 109
    if-nez v12, :cond_2

    .line 110
    .line 111
    sput-boolean v9, Landroidx/appcompat/widget/ViewUtils;->sInitComputeFitSystemWindowsMethod:Z

    .line 112
    .line 113
    :try_start_0
    const-class v12, Landroid/view/View;

    .line 114
    .line 115
    const-string v15, "computeFitSystemWindows"
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    .line 116
    .line 117
    const/16 v16, 0x0

    .line 118
    .line 119
    :try_start_1
    new-array v7, v13, [Ljava/lang/Class;

    .line 120
    .line 121
    const-class v17, Landroid/graphics/Rect;

    .line 122
    .line 123
    aput-object v17, v7, v16

    .line 124
    .line 125
    aput-object v17, v7, v9

    .line 126
    .line 127
    invoke-virtual {v12, v15, v7}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    .line 128
    .line 129
    .line 130
    move-result-object v7

    .line 131
    sput-object v7, Landroidx/appcompat/widget/ViewUtils;->sComputeFitSystemWindowsMethod:Ljava/lang/reflect/Method;

    .line 132
    .line 133
    invoke-virtual {v7}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 134
    .line 135
    .line 136
    move-result v7

    .line 137
    if-nez v7, :cond_3

    .line 138
    .line 139
    sget-object v7, Landroidx/appcompat/widget/ViewUtils;->sComputeFitSystemWindowsMethod:Ljava/lang/reflect/Method;

    .line 140
    .line 141
    invoke-virtual {v7, v9}, Ljava/lang/reflect/AccessibleObject;->setAccessible(Z)V
    :try_end_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_1

    .line 142
    .line 143
    .line 144
    goto :goto_0

    .line 145
    :catch_0
    const/16 v16, 0x0

    .line 146
    .line 147
    :catch_1
    const-string v7, "Could not find method computeFitSystemWindows. Oh well."

    .line 148
    .line 149
    invoke-static {v14, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 150
    .line 151
    .line 152
    goto :goto_0

    .line 153
    :cond_2
    const/16 v16, 0x0

    .line 154
    .line 155
    :cond_3
    :goto_0
    sget-object v7, Landroidx/appcompat/widget/ViewUtils;->sComputeFitSystemWindowsMethod:Ljava/lang/reflect/Method;

    .line 156
    .line 157
    if-eqz v7, :cond_4

    .line 158
    .line 159
    :try_start_2
    new-array v12, v13, [Ljava/lang/Object;

    .line 160
    .line 161
    aput-object v10, v12, v16

    .line 162
    .line 163
    aput-object v0, v12, v9

    .line 164
    .line 165
    invoke-virtual {v7, v11, v12}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 166
    .line 167
    .line 168
    goto :goto_1

    .line 169
    :catch_2
    move-exception v0

    .line 170
    const-string v7, "Could not invoke computeFitSystemWindows"

    .line 171
    .line 172
    invoke-static {v14, v7, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 173
    .line 174
    .line 175
    :cond_4
    :goto_1
    iget v0, v10, Landroid/graphics/Rect;->top:I

    .line 176
    .line 177
    iget v7, v10, Landroid/graphics/Rect;->left:I

    .line 178
    .line 179
    iget v10, v10, Landroid/graphics/Rect;->right:I

    .line 180
    .line 181
    iget-object v11, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mSubDecor:Landroid/view/ViewGroup;

    .line 182
    .line 183
    invoke-static {v11}, Landroidx/core/view/ViewCompat;->getRootWindowInsets(Landroid/view/View;)Landroidx/core/view/WindowInsetsCompat;

    .line 184
    .line 185
    .line 186
    move-result-object v11

    .line 187
    if-nez v11, :cond_5

    .line 188
    .line 189
    const/4 v12, 0x0

    .line 190
    goto :goto_2

    .line 191
    :cond_5
    invoke-virtual {v11}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetLeft()I

    .line 192
    .line 193
    .line 194
    move-result v12

    .line 195
    :goto_2
    if-nez v11, :cond_6

    .line 196
    .line 197
    const/4 v11, 0x0

    .line 198
    goto :goto_3

    .line 199
    :cond_6
    invoke-virtual {v11}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetRight()I

    .line 200
    .line 201
    .line 202
    move-result v11

    .line 203
    :goto_3
    iget v13, v8, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 204
    .line 205
    if-ne v13, v0, :cond_8

    .line 206
    .line 207
    iget v13, v8, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    .line 208
    .line 209
    if-ne v13, v7, :cond_8

    .line 210
    .line 211
    iget v13, v8, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    .line 212
    .line 213
    if-eq v13, v10, :cond_7

    .line 214
    .line 215
    goto :goto_4

    .line 216
    :cond_7
    const/4 v7, 0x0

    .line 217
    goto :goto_5

    .line 218
    :cond_8
    :goto_4
    iput v0, v8, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 219
    .line 220
    iput v7, v8, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    .line 221
    .line 222
    iput v10, v8, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    .line 223
    .line 224
    const/4 v7, 0x1

    .line 225
    :goto_5
    if-lez v0, :cond_9

    .line 226
    .line 227
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mStatusGuard:Landroid/view/View;

    .line 228
    .line 229
    if-nez v0, :cond_9

    .line 230
    .line 231
    new-instance v0, Landroid/view/View;

    .line 232
    .line 233
    invoke-direct {v0, v4}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 234
    .line 235
    .line 236
    iput-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mStatusGuard:Landroid/view/View;

    .line 237
    .line 238
    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 239
    .line 240
    .line 241
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    .line 242
    .line 243
    iget v10, v8, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 244
    .line 245
    const/16 v13, 0x33

    .line 246
    .line 247
    const/4 v14, -0x1

    .line 248
    invoke-direct {v0, v14, v10, v13}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    .line 249
    .line 250
    .line 251
    iput v12, v0, Landroid/widget/FrameLayout$LayoutParams;->leftMargin:I

    .line 252
    .line 253
    iput v11, v0, Landroid/widget/FrameLayout$LayoutParams;->rightMargin:I

    .line 254
    .line 255
    iget-object v10, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mSubDecor:Landroid/view/ViewGroup;

    .line 256
    .line 257
    iget-object v11, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mStatusGuard:Landroid/view/View;

    .line 258
    .line 259
    invoke-virtual {v10, v11, v14, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 260
    .line 261
    .line 262
    goto :goto_6

    .line 263
    :cond_9
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mStatusGuard:Landroid/view/View;

    .line 264
    .line 265
    if-eqz v0, :cond_b

    .line 266
    .line 267
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 268
    .line 269
    .line 270
    move-result-object v0

    .line 271
    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 272
    .line 273
    iget v10, v0, Landroid/view/ViewGroup$MarginLayoutParams;->height:I

    .line 274
    .line 275
    iget v13, v8, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 276
    .line 277
    if-ne v10, v13, :cond_a

    .line 278
    .line 279
    iget v10, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    .line 280
    .line 281
    if-ne v10, v12, :cond_a

    .line 282
    .line 283
    iget v10, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    .line 284
    .line 285
    if-eq v10, v11, :cond_b

    .line 286
    .line 287
    :cond_a
    iput v13, v0, Landroid/view/ViewGroup$MarginLayoutParams;->height:I

    .line 288
    .line 289
    iput v12, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    .line 290
    .line 291
    iput v11, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    .line 292
    .line 293
    iget-object v10, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mStatusGuard:Landroid/view/View;

    .line 294
    .line 295
    invoke-virtual {v10, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 296
    .line 297
    .line 298
    :cond_b
    :goto_6
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mStatusGuard:Landroid/view/View;

    .line 299
    .line 300
    if-eqz v0, :cond_c

    .line 301
    .line 302
    goto :goto_7

    .line 303
    :cond_c
    const/4 v9, 0x0

    .line 304
    :goto_7
    if-eqz v9, :cond_e

    .line 305
    .line 306
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 307
    .line 308
    .line 309
    move-result v0

    .line 310
    if-eqz v0, :cond_e

    .line 311
    .line 312
    iget-object v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mStatusGuard:Landroid/view/View;

    .line 313
    .line 314
    invoke-virtual {v0}, Landroid/view/View;->getWindowSystemUiVisibility()I

    .line 315
    .line 316
    .line 317
    move-result v10

    .line 318
    and-int/lit16 v10, v10, 0x2000

    .line 319
    .line 320
    if-eqz v10, :cond_d

    .line 321
    .line 322
    const v10, 0x7f060006

    .line 323
    .line 324
    .line 325
    invoke-static {v4, v10}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 326
    .line 327
    .line 328
    move-result v4

    .line 329
    goto :goto_8

    .line 330
    :cond_d
    const v10, 0x7f060005

    .line 331
    .line 332
    .line 333
    invoke-static {v4, v10}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 334
    .line 335
    .line 336
    move-result v4

    .line 337
    :goto_8
    invoke-virtual {v0, v4}, Landroid/view/View;->setBackgroundColor(I)V

    .line 338
    .line 339
    .line 340
    :cond_e
    iget-boolean v0, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mOverlayActionMode:Z

    .line 341
    .line 342
    if-nez v0, :cond_f

    .line 343
    .line 344
    if-eqz v9, :cond_f

    .line 345
    .line 346
    const/4 v5, 0x0

    .line 347
    :cond_f
    move v0, v9

    .line 348
    const/4 v4, 0x0

    .line 349
    move v9, v7

    .line 350
    goto :goto_9

    .line 351
    :cond_10
    const/16 v16, 0x0

    .line 352
    .line 353
    iget v0, v8, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 354
    .line 355
    const/4 v4, 0x0

    .line 356
    if-eqz v0, :cond_11

    .line 357
    .line 358
    iput v4, v8, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 359
    .line 360
    const/4 v0, 0x0

    .line 361
    goto :goto_9

    .line 362
    :cond_11
    const/4 v0, 0x0

    .line 363
    const/4 v9, 0x0

    .line 364
    :goto_9
    if-eqz v9, :cond_13

    .line 365
    .line 366
    iget-object v7, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mActionModeView:Landroidx/appcompat/widget/ActionBarContextView;

    .line 367
    .line 368
    invoke-virtual {v7, v8}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 369
    .line 370
    .line 371
    goto :goto_a

    .line 372
    :cond_12
    const/4 v4, 0x0

    .line 373
    const/4 v0, 0x0

    .line 374
    :cond_13
    :goto_a
    iget-object v3, v3, Landroidx/appcompat/app/AppCompatDelegateImpl;->mStatusGuard:Landroid/view/View;

    .line 375
    .line 376
    if-eqz v3, :cond_15

    .line 377
    .line 378
    if-eqz v0, :cond_14

    .line 379
    .line 380
    const/4 v6, 0x0

    .line 381
    :cond_14
    invoke-virtual {v3, v6}, Landroid/view/View;->setVisibility(I)V

    .line 382
    .line 383
    .line 384
    :cond_15
    if-eq v1, v5, :cond_16

    .line 385
    .line 386
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetLeft()I

    .line 387
    .line 388
    .line 389
    move-result v0

    .line 390
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetRight()I

    .line 391
    .line 392
    .line 393
    move-result v1

    .line 394
    invoke-virtual/range {p2 .. p2}, Landroidx/core/view/WindowInsetsCompat;->getSystemWindowInsetBottom()I

    .line 395
    .line 396
    .line 397
    move-result v3

    .line 398
    move-object/from16 v4, p2

    .line 399
    .line 400
    invoke-virtual {v4, v0, v5, v1, v3}, Landroidx/core/view/WindowInsetsCompat;->replaceSystemWindowInsets(IIII)Landroidx/core/view/WindowInsetsCompat;

    .line 401
    .line 402
    .line 403
    move-result-object v0

    .line 404
    :goto_b
    move-object/from16 v1, p1

    .line 405
    .line 406
    goto :goto_c

    .line 407
    :cond_16
    move-object/from16 v4, p2

    .line 408
    .line 409
    move-object v0, v4

    .line 410
    goto :goto_b

    .line 411
    :goto_c
    invoke-static {v1, v0}, Landroidx/core/view/ViewCompat;->onApplyWindowInsets(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    .line 412
    .line 413
    .line 414
    move-result-object v0

    .line 415
    return-object v0
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

.method public onCloseMenu(Landroidx/appcompat/view/menu/MenuBuilder;Z)V
    .locals 9

    .line 1
    iget v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    invoke-virtual {p1}, Landroidx/appcompat/view/menu/MenuBuilder;->getRootMenu()Landroidx/appcompat/view/menu/MenuBuilder;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    const/4 v1, 0x0

    .line 11
    const/4 v2, 0x1

    .line 12
    if-eq v0, p1, :cond_0

    .line 13
    .line 14
    const/4 v3, 0x1

    .line 15
    goto :goto_0

    .line 16
    :cond_0
    const/4 v3, 0x0

    .line 17
    :goto_0
    if-eqz v3, :cond_1

    .line 18
    .line 19
    move-object p1, v0

    .line 20
    :cond_1
    iget-object v4, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 21
    .line 22
    iget-object v5, v4, Landroidx/appcompat/app/AppCompatDelegateImpl;->mPanels:[Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;

    .line 23
    .line 24
    if-eqz v5, :cond_2

    .line 25
    .line 26
    array-length v6, v5

    .line 27
    goto :goto_1

    .line 28
    :cond_2
    const/4 v6, 0x0

    .line 29
    :goto_1
    if-ge v1, v6, :cond_4

    .line 30
    .line 31
    aget-object v7, v5, v1

    .line 32
    .line 33
    if-eqz v7, :cond_3

    .line 34
    .line 35
    iget-object v8, v7, Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;->menu:Landroidx/appcompat/view/menu/MenuBuilder;

    .line 36
    .line 37
    if-ne v8, p1, :cond_3

    .line 38
    .line 39
    goto :goto_2

    .line 40
    :cond_3
    add-int/lit8 v1, v1, 0x1

    .line 41
    .line 42
    goto :goto_1

    .line 43
    :cond_4
    const/4 v7, 0x0

    .line 44
    :goto_2
    if-eqz v7, :cond_6

    .line 45
    .line 46
    if-eqz v3, :cond_5

    .line 47
    .line 48
    iget p1, v7, Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;->featureId:I

    .line 49
    .line 50
    invoke-virtual {v4, p1, v7, v0}, Landroidx/appcompat/app/AppCompatDelegateImpl;->callOnPanelClosed(ILandroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Landroidx/appcompat/view/menu/MenuBuilder;)V

    .line 51
    .line 52
    .line 53
    invoke-virtual {v4, v7, v2}, Landroidx/appcompat/app/AppCompatDelegateImpl;->closePanel(Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Z)V

    .line 54
    .line 55
    .line 56
    goto :goto_3

    .line 57
    :cond_5
    invoke-virtual {v4, v7, p2}, Landroidx/appcompat/app/AppCompatDelegateImpl;->closePanel(Landroidx/appcompat/app/AppCompatDelegateImpl$PanelFeatureState;Z)V

    .line 58
    .line 59
    .line 60
    :cond_6
    :goto_3
    return-void

    .line 61
    :pswitch_0
    iget-object p2, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 62
    .line 63
    invoke-virtual {p2, p1}, Landroidx/appcompat/app/AppCompatDelegateImpl;->checkCloseActionMenu(Landroidx/appcompat/view/menu/MenuBuilder;)V

    .line 64
    .line 65
    .line 66
    return-void

    .line 67
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
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

.method public onOpenSubMenu(Landroidx/appcompat/view/menu/MenuBuilder;)Z
    .locals 2

    .line 1
    iget v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    invoke-virtual {p1}, Landroidx/appcompat/view/menu/MenuBuilder;->getRootMenu()Landroidx/appcompat/view/menu/MenuBuilder;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    if-ne p1, v0, :cond_0

    .line 11
    .line 12
    iget-object v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 13
    .line 14
    iget-boolean v1, v0, Landroidx/appcompat/app/AppCompatDelegateImpl;->mHasActionBar:Z

    .line 15
    .line 16
    if-eqz v1, :cond_0

    .line 17
    .line 18
    iget-object v1, v0, Landroidx/appcompat/app/AppCompatDelegateImpl;->mWindow:Landroid/view/Window;

    .line 19
    .line 20
    invoke-virtual {v1}, Landroid/view/Window;->getCallback()Landroid/view/Window$Callback;

    .line 21
    .line 22
    .line 23
    move-result-object v1

    .line 24
    if-eqz v1, :cond_0

    .line 25
    .line 26
    iget-boolean v0, v0, Landroidx/appcompat/app/AppCompatDelegateImpl;->mDestroyed:Z

    .line 27
    .line 28
    if-nez v0, :cond_0

    .line 29
    .line 30
    const/16 v0, 0x6c

    .line 31
    .line 32
    invoke-interface {v1, v0, p1}, Landroid/view/Window$Callback;->onMenuOpened(ILandroid/view/Menu;)Z

    .line 33
    .line 34
    .line 35
    :cond_0
    const/4 p1, 0x1

    .line 36
    return p1

    .line 37
    :pswitch_0
    iget-object v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 38
    .line 39
    iget-object v0, v0, Landroidx/appcompat/app/AppCompatDelegateImpl;->mWindow:Landroid/view/Window;

    .line 40
    .line 41
    invoke-virtual {v0}, Landroid/view/Window;->getCallback()Landroid/view/Window$Callback;

    .line 42
    .line 43
    .line 44
    move-result-object v0

    .line 45
    if-eqz v0, :cond_1

    .line 46
    .line 47
    const/16 v1, 0x6c

    .line 48
    .line 49
    invoke-interface {v0, v1, p1}, Landroid/view/Window$Callback;->onMenuOpened(ILandroid/view/Menu;)Z

    .line 50
    .line 51
    .line 52
    :cond_1
    const/4 p1, 0x1

    .line 53
    return p1

    .line 54
    nop

    .line 55
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
    .line 56
    .line 57
.end method

.method public setActionBarDescription(I)V
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/appcompat/app/AppCompatDelegateImpl;->initWindowDecorActionBar()V

    .line 4
    .line 5
    .line 6
    iget-object v0, v0, Landroidx/appcompat/app/AppCompatDelegateImpl;->mActionBar:Landroidx/appcompat/app/ActionBar;

    .line 7
    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    invoke-virtual {v0, p1}, Landroidx/appcompat/app/ActionBar;->setHomeActionContentDescription(I)V

    .line 11
    .line 12
    .line 13
    :cond_0
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

.method public setActionBarUpIndicator(Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;I)V
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/appcompat/app/AppCompatDelegateImpl$3;->this$0:Landroidx/appcompat/app/AppCompatDelegateImpl;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/appcompat/app/AppCompatDelegateImpl;->initWindowDecorActionBar()V

    .line 4
    .line 5
    .line 6
    iget-object v0, v0, Landroidx/appcompat/app/AppCompatDelegateImpl;->mActionBar:Landroidx/appcompat/app/ActionBar;

    .line 7
    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    invoke-virtual {v0, p1}, Landroidx/appcompat/app/ActionBar;->setHomeAsUpIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 11
    .line 12
    .line 13
    invoke-virtual {v0, p2}, Landroidx/appcompat/app/ActionBar;->setHomeActionContentDescription(I)V

    .line 14
    .line 15
    .line 16
    :cond_0
    return-void
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
