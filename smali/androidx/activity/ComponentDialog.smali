.class public Landroidx/activity/ComponentDialog;
.super Landroid/app/Dialog;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/LifecycleOwner;
.implements Landroidx/activity/OnBackPressedDispatcherOwner;
.implements Landroidx/savedstate/SavedStateRegistryOwner;


# instance fields
.field public _lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

.field public final onBackPressedDispatcher:Landroidx/activity/OnBackPressedDispatcher;

.field public final savedStateRegistryController:Landroidx/savedstate/SavedStateRegistryController;


# direct methods
.method public static $r8$lambda$qrzmfDOyDuplJFtpJLozn3P9EZI(Landroidx/activity/ComponentDialog;)V
    .locals 0

    .line 1
    invoke-super {p0}, Landroid/app/Dialog;->onBackPressed()V

    .line 2
    .line 3
    .line 4
    return-void
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

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 1

    .line 1
    const-string v0, "context"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 7
    .line 8
    .line 9
    new-instance p1, Landroidx/savedstate/internal/SavedStateRegistryImpl;

    .line 10
    .line 11
    new-instance p2, Landroidx/activity/ComponentActivity$$ExternalSyntheticLambda1;

    .line 12
    .line 13
    const/4 v0, 0x4

    .line 14
    invoke-direct {p2, v0, p0}, Landroidx/activity/ComponentActivity$$ExternalSyntheticLambda1;-><init>(ILjava/lang/Object;)V

    .line 15
    .line 16
    .line 17
    invoke-direct {p1, p0, p2}, Landroidx/savedstate/internal/SavedStateRegistryImpl;-><init>(Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/activity/ComponentActivity$$ExternalSyntheticLambda1;)V

    .line 18
    .line 19
    .line 20
    new-instance p2, Landroidx/savedstate/SavedStateRegistryController;

    .line 21
    .line 22
    invoke-direct {p2, p1}, Landroidx/savedstate/SavedStateRegistryController;-><init>(Landroidx/savedstate/internal/SavedStateRegistryImpl;)V

    .line 23
    .line 24
    .line 25
    iput-object p2, p0, Landroidx/activity/ComponentDialog;->savedStateRegistryController:Landroidx/savedstate/SavedStateRegistryController;

    .line 26
    .line 27
    new-instance p1, Landroidx/activity/OnBackPressedDispatcher;

    .line 28
    .line 29
    new-instance p2, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;

    .line 30
    .line 31
    const/4 v0, 0x3

    .line 32
    invoke-direct {p2, v0, p0}, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 33
    .line 34
    .line 35
    invoke-direct {p1, p2}, Landroidx/activity/OnBackPressedDispatcher;-><init>(Ljava/lang/Runnable;)V

    .line 36
    .line 37
    .line 38
    iput-object p1, p0, Landroidx/activity/ComponentDialog;->onBackPressedDispatcher:Landroidx/activity/OnBackPressedDispatcher;

    .line 39
    .line 40
    return-void
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
.method public addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1

    .line 1
    const-string v0, "view"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0}, Landroidx/activity/ComponentDialog;->initializeViewTreeOwners()V

    .line 7
    .line 8
    .line 9
    invoke-super {p0, p1, p2}, Landroid/app/Dialog;->addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 10
    .line 11
    .line 12
    return-void
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

.method public final getLifecycle()Landroidx/lifecycle/Lifecycle;
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Landroidx/lifecycle/LifecycleRegistry;

    .line 6
    .line 7
    invoke-direct {v0, p0}, Landroidx/lifecycle/LifecycleRegistry;-><init>(Landroidx/lifecycle/LifecycleOwner;)V

    .line 8
    .line 9
    .line 10
    iput-object v0, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 11
    .line 12
    :cond_0
    return-object v0
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

.method public final getOnBackPressedDispatcher()Landroidx/activity/OnBackPressedDispatcher;
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/activity/ComponentDialog;->onBackPressedDispatcher:Landroidx/activity/OnBackPressedDispatcher;

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

.method public final getSavedStateRegistry()Landroidx/savedstate/SavedStateRegistry;
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/activity/ComponentDialog;->savedStateRegistryController:Landroidx/savedstate/SavedStateRegistryController;

    .line 2
    .line 3
    iget-object v0, v0, Landroidx/savedstate/SavedStateRegistryController;->savedStateRegistry:Landroidx/savedstate/SavedStateRegistry;

    .line 4
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

.method public final initializeViewTreeOwners()V
    .locals 3

    .line 1
    invoke-virtual {p0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    const-string v1, "window!!.decorView"

    .line 13
    .line 14
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 15
    .line 16
    .line 17
    const v2, 0x7f0a0390

    .line 18
    .line 19
    .line 20
    invoke-virtual {v0, v2, p0}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 21
    .line 22
    .line 23
    invoke-virtual {p0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 28
    .line 29
    .line 30
    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    .line 31
    .line 32
    .line 33
    move-result-object v0

    .line 34
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 35
    .line 36
    .line 37
    const v2, 0x7f0a0391

    .line 38
    .line 39
    .line 40
    invoke-virtual {v0, v2, p0}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 41
    .line 42
    .line 43
    invoke-virtual {p0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 48
    .line 49
    .line 50
    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    .line 51
    .line 52
    .line 53
    move-result-object v0

    .line 54
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 55
    .line 56
    .line 57
    const v1, 0x7f0a0392

    .line 58
    .line 59
    .line 60
    invoke-virtual {v0, v1, p0}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

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

.method public final onBackPressed()V
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/activity/ComponentDialog;->onBackPressedDispatcher:Landroidx/activity/OnBackPressedDispatcher;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V

    .line 4
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
    .line 58
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4

    .line 1
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 5
    .line 6
    const/16 v1, 0x21

    .line 7
    .line 8
    if-lt v0, v1, :cond_0

    .line 9
    .line 10
    invoke-virtual {p0}, Landroid/app/Dialog;->getOnBackInvokedDispatcher()Landroid/window/OnBackInvokedDispatcher;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    const-string v1, "onBackInvokedDispatcher"

    .line 15
    .line 16
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 17
    .line 18
    .line 19
    iget-object v1, p0, Landroidx/activity/ComponentDialog;->onBackPressedDispatcher:Landroidx/activity/OnBackPressedDispatcher;

    .line 20
    .line 21
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 22
    .line 23
    .line 24
    iput-object v0, v1, Landroidx/activity/OnBackPressedDispatcher;->invokedDispatcher:Landroid/window/OnBackInvokedDispatcher;

    .line 25
    .line 26
    iget-boolean v0, v1, Landroidx/activity/OnBackPressedDispatcher;->hasEnabledCallbacks:Z

    .line 27
    .line 28
    invoke-virtual {v1, v0}, Landroidx/activity/OnBackPressedDispatcher;->updateBackInvokedCallbackState(Z)V

    .line 29
    .line 30
    .line 31
    :cond_0
    iget-object v0, p0, Landroidx/activity/ComponentDialog;->savedStateRegistryController:Landroidx/savedstate/SavedStateRegistryController;

    .line 32
    .line 33
    iget-object v0, v0, Landroidx/savedstate/SavedStateRegistryController;->impl:Landroidx/savedstate/internal/SavedStateRegistryImpl;

    .line 34
    .line 35
    iget-object v1, v0, Landroidx/savedstate/internal/SavedStateRegistryImpl;->owner:Landroidx/savedstate/SavedStateRegistryOwner;

    .line 36
    .line 37
    iget-boolean v2, v0, Landroidx/savedstate/internal/SavedStateRegistryImpl;->attached:Z

    .line 38
    .line 39
    if-nez v2, :cond_1

    .line 40
    .line 41
    invoke-virtual {v0}, Landroidx/savedstate/internal/SavedStateRegistryImpl;->performAttach()V

    .line 42
    .line 43
    .line 44
    :cond_1
    invoke-interface {v1}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    .line 45
    .line 46
    .line 47
    move-result-object v2

    .line 48
    check-cast v2, Landroidx/lifecycle/LifecycleRegistry;

    .line 49
    .line 50
    iget-object v2, v2, Landroidx/lifecycle/LifecycleRegistry;->state:Landroidx/lifecycle/Lifecycle$State;

    .line 51
    .line 52
    sget-object v3, Landroidx/lifecycle/Lifecycle$State;->STARTED:Landroidx/lifecycle/Lifecycle$State;

    .line 53
    .line 54
    invoke-virtual {v2, v3}, Ljava/lang/Enum;->compareTo(Ljava/lang/Enum;)I

    .line 55
    .line 56
    .line 57
    move-result v2

    .line 58
    if-gez v2, :cond_6

    .line 59
    .line 60
    iget-boolean v1, v0, Landroidx/savedstate/internal/SavedStateRegistryImpl;->isRestored:Z

    .line 61
    .line 62
    if-nez v1, :cond_5

    .line 63
    .line 64
    const/4 v1, 0x0

    .line 65
    if-eqz p1, :cond_3

    .line 66
    .line 67
    const-string v2, "androidx.lifecycle.BundlableSavedStateRegistry.key"

    .line 68
    .line 69
    invoke-virtual {p1, v2}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    .line 70
    .line 71
    .line 72
    move-result v3

    .line 73
    if-eqz v3, :cond_3

    .line 74
    .line 75
    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    .line 76
    .line 77
    .line 78
    move-result-object p1

    .line 79
    if-eqz p1, :cond_2

    .line 80
    .line 81
    move-object v1, p1

    .line 82
    goto :goto_0

    .line 83
    :cond_2
    invoke-static {v2}, Landroidx/navigation/Navigation;->keyOrValueNotFoundError(Ljava/lang/String;)V

    .line 84
    .line 85
    .line 86
    throw v1

    .line 87
    :cond_3
    :goto_0
    iput-object v1, v0, Landroidx/savedstate/internal/SavedStateRegistryImpl;->restoredState:Landroid/os/Bundle;

    .line 88
    .line 89
    const/4 p1, 0x1

    .line 90
    iput-boolean p1, v0, Landroidx/savedstate/internal/SavedStateRegistryImpl;->isRestored:Z

    .line 91
    .line 92
    iget-object p1, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 93
    .line 94
    if-nez p1, :cond_4

    .line 95
    .line 96
    new-instance p1, Landroidx/lifecycle/LifecycleRegistry;

    .line 97
    .line 98
    invoke-direct {p1, p0}, Landroidx/lifecycle/LifecycleRegistry;-><init>(Landroidx/lifecycle/LifecycleOwner;)V

    .line 99
    .line 100
    .line 101
    iput-object p1, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 102
    .line 103
    :cond_4
    sget-object v0, Landroidx/lifecycle/Lifecycle$Event;->ON_CREATE:Landroidx/lifecycle/Lifecycle$Event;

    .line 104
    .line 105
    invoke-virtual {p1, v0}, Landroidx/lifecycle/LifecycleRegistry;->handleLifecycleEvent(Landroidx/lifecycle/Lifecycle$Event;)V

    .line 106
    .line 107
    .line 108
    return-void

    .line 109
    :cond_5
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 110
    .line 111
    const-string v0, "SavedStateRegistry was already restored."

    .line 112
    .line 113
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 114
    .line 115
    .line 116
    throw p1

    .line 117
    :cond_6
    new-instance p1, Ljava/lang/StringBuilder;

    .line 118
    .line 119
    const-string v0, "performRestore cannot be called when owner is "

    .line 120
    .line 121
    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 122
    .line 123
    .line 124
    invoke-interface {v1}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    .line 125
    .line 126
    .line 127
    move-result-object v0

    .line 128
    check-cast v0, Landroidx/lifecycle/LifecycleRegistry;

    .line 129
    .line 130
    iget-object v0, v0, Landroidx/lifecycle/LifecycleRegistry;->state:Landroidx/lifecycle/Lifecycle$State;

    .line 131
    .line 132
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 133
    .line 134
    .line 135
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 136
    .line 137
    .line 138
    move-result-object p1

    .line 139
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 140
    .line 141
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 142
    .line 143
    .line 144
    move-result-object p1

    .line 145
    invoke-direct {v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 146
    .line 147
    .line 148
    throw v0
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

.method public final onSaveInstanceState()Landroid/os/Bundle;
    .locals 2

    .line 1
    invoke-super {p0}, Landroid/app/Dialog;->onSaveInstanceState()Landroid/os/Bundle;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "super.onSaveInstanceState()"

    .line 6
    .line 7
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 8
    .line 9
    .line 10
    iget-object v1, p0, Landroidx/activity/ComponentDialog;->savedStateRegistryController:Landroidx/savedstate/SavedStateRegistryController;

    .line 11
    .line 12
    invoke-virtual {v1, v0}, Landroidx/savedstate/SavedStateRegistryController;->performSave(Landroid/os/Bundle;)V

    .line 13
    .line 14
    .line 15
    return-object v0
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

.method public final onStart()V
    .locals 2

    .line 1
    invoke-super {p0}, Landroid/app/Dialog;->onStart()V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 5
    .line 6
    if-nez v0, :cond_0

    .line 7
    .line 8
    new-instance v0, Landroidx/lifecycle/LifecycleRegistry;

    .line 9
    .line 10
    invoke-direct {v0, p0}, Landroidx/lifecycle/LifecycleRegistry;-><init>(Landroidx/lifecycle/LifecycleOwner;)V

    .line 11
    .line 12
    .line 13
    iput-object v0, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 14
    .line 15
    :cond_0
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_RESUME:Landroidx/lifecycle/Lifecycle$Event;

    .line 16
    .line 17
    invoke-virtual {v0, v1}, Landroidx/lifecycle/LifecycleRegistry;->handleLifecycleEvent(Landroidx/lifecycle/Lifecycle$Event;)V

    .line 18
    .line 19
    .line 20
    return-void
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

.method public onStop()V
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Landroidx/lifecycle/LifecycleRegistry;

    .line 6
    .line 7
    invoke-direct {v0, p0}, Landroidx/lifecycle/LifecycleRegistry;-><init>(Landroidx/lifecycle/LifecycleOwner;)V

    .line 8
    .line 9
    .line 10
    iput-object v0, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 11
    .line 12
    :cond_0
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_DESTROY:Landroidx/lifecycle/Lifecycle$Event;

    .line 13
    .line 14
    invoke-virtual {v0, v1}, Landroidx/lifecycle/LifecycleRegistry;->handleLifecycleEvent(Landroidx/lifecycle/Lifecycle$Event;)V

    .line 15
    .line 16
    .line 17
    const/4 v0, 0x0

    .line 18
    iput-object v0, p0, Landroidx/activity/ComponentDialog;->_lifecycleRegistry:Landroidx/lifecycle/LifecycleRegistry;

    .line 19
    .line 20
    invoke-super {p0}, Landroid/app/Dialog;->onStop()V

    .line 21
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

.method public setContentView(I)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Landroidx/activity/ComponentDialog;->initializeViewTreeOwners()V

    .line 2
    invoke-super {p0, p1}, Landroid/app/Dialog;->setContentView(I)V

    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .locals 1

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 3
    invoke-virtual {p0}, Landroidx/activity/ComponentDialog;->initializeViewTreeOwners()V

    .line 4
    invoke-super {p0, p1}, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V

    return-void
.end method

.method public setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1

    const-string v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 5
    invoke-virtual {p0}, Landroidx/activity/ComponentDialog;->initializeViewTreeOwners()V

    .line 6
    invoke-super {p0, p1, p2}, Landroid/app/Dialog;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    return-void
.end method
