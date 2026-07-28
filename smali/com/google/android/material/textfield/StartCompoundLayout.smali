.class public final Lcom/google/android/material/textfield/StartCompoundLayout;
.super Landroid/widget/LinearLayout;
.source "SourceFile"


# instance fields
.field public hintExpanded:Z

.field public prefixText:Ljava/lang/CharSequence;

.field public final prefixTextView:Landroidx/appcompat/widget/AppCompatTextView;

.field public startIconMinSize:I

.field public startIconOnLongClickListener:Landroid/view/View$OnLongClickListener;

.field public startIconScaleType:Landroid/widget/ImageView$ScaleType;

.field public startIconTintList:Landroid/content/res/ColorStateList;

.field public startIconTintMode:Landroid/graphics/PorterDuff$Mode;

.field public final startIconView:Lcom/google/android/material/internal/CheckableImageButton;

.field public final textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;


# direct methods
.method public constructor <init>(Lcom/google/android/material/textfield/TextInputLayout;Lkotlin/text/MatcherMatchResult;)V
    .locals 10

    .line 1
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-direct {p0, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 6
    .line 7
    .line 8
    iput-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    .line 9
    .line 10
    const/16 p1, 0x8

    .line 11
    .line 12
    invoke-virtual {p0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 13
    .line 14
    .line 15
    const/4 v0, 0x0

    .line 16
    invoke-virtual {p0, v0}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 17
    .line 18
    .line 19
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    .line 20
    .line 21
    const v2, 0x800003

    .line 22
    .line 23
    .line 24
    const/4 v3, -0x2

    .line 25
    const/4 v4, -0x1

    .line 26
    invoke-direct {v1, v3, v4, v2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    .line 27
    .line 28
    .line 29
    invoke-virtual {p0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 30
    .line 31
    .line 32
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 33
    .line 34
    .line 35
    move-result-object v1

    .line 36
    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    .line 37
    .line 38
    .line 39
    move-result-object v1

    .line 40
    const v2, 0x7f0d0042

    .line 41
    .line 42
    .line 43
    invoke-virtual {v1, v2, p0, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 44
    .line 45
    .line 46
    move-result-object v1

    .line 47
    check-cast v1, Lcom/google/android/material/internal/CheckableImageButton;

    .line 48
    .line 49
    iput-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    .line 50
    .line 51
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 52
    .line 53
    const/16 v5, 0x17

    .line 54
    .line 55
    if-ge v2, v5, :cond_0

    .line 56
    .line 57
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 58
    .line 59
    .line 60
    move-result-object v2

    .line 61
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 62
    .line 63
    .line 64
    move-result-object v5

    .line 65
    const/4 v6, 0x4

    .line 66
    invoke-static {v5, v6}, Lcom/google/android/material/internal/ViewUtils;->dpToPx(Landroid/content/Context;I)F

    .line 67
    .line 68
    .line 69
    move-result v5

    .line 70
    float-to-int v5, v5

    .line 71
    invoke-static {v2, v5}, Lcom/google/android/material/ripple/RippleUtils$RippleUtilsLollipop;->access$000(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    .line 72
    .line 73
    .line 74
    move-result-object v2

    .line 75
    invoke-virtual {v1, v2}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 76
    .line 77
    .line 78
    :cond_0
    new-instance v2, Landroidx/appcompat/widget/AppCompatTextView;

    .line 79
    .line 80
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 81
    .line 82
    .line 83
    move-result-object v5

    .line 84
    const/4 v6, 0x0

    .line 85
    invoke-direct {v2, v5, v6}, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 86
    .line 87
    .line 88
    iput-object v2, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroidx/appcompat/widget/AppCompatTextView;

    .line 89
    .line 90
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 91
    .line 92
    .line 93
    move-result-object v5

    .line 94
    invoke-static {v5}, Lkotlin/LazyKt__LazyJVMKt;->isFontScaleAtLeast1_3(Landroid/content/Context;)Z

    .line 95
    .line 96
    .line 97
    move-result v5

    .line 98
    if-eqz v5, :cond_1

    .line 99
    .line 100
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 101
    .line 102
    .line 103
    move-result-object v5

    .line 104
    check-cast v5, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 105
    .line 106
    invoke-virtual {v5, v0}, Landroid/view/ViewGroup$MarginLayoutParams;->setMarginEnd(I)V

    .line 107
    .line 108
    .line 109
    :cond_1
    iget-object v5, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconOnLongClickListener:Landroid/view/View$OnLongClickListener;

    .line 110
    .line 111
    invoke-virtual {v1, v6}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 112
    .line 113
    .line 114
    invoke-static {v1, v5}, Lkotlin/LazyKt__LazyJVMKt;->setIconClickable(Lcom/google/android/material/internal/CheckableImageButton;Landroid/view/View$OnLongClickListener;)V

    .line 115
    .line 116
    .line 117
    iput-object v6, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconOnLongClickListener:Landroid/view/View$OnLongClickListener;

    .line 118
    .line 119
    invoke-virtual {v1, v6}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 120
    .line 121
    .line 122
    invoke-static {v1, v6}, Lkotlin/LazyKt__LazyJVMKt;->setIconClickable(Lcom/google/android/material/internal/CheckableImageButton;Landroid/view/View$OnLongClickListener;)V

    .line 123
    .line 124
    .line 125
    iget-object v5, p2, Lkotlin/text/MatcherMatchResult;->input:Ljava/lang/Object;

    .line 126
    .line 127
    check-cast v5, Landroid/content/res/TypedArray;

    .line 128
    .line 129
    const/16 v7, 0x46

    .line 130
    .line 131
    invoke-virtual {v5, v7}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 132
    .line 133
    .line 134
    move-result v8

    .line 135
    if-eqz v8, :cond_2

    .line 136
    .line 137
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 138
    .line 139
    .line 140
    move-result-object v8

    .line 141
    invoke-static {v8, p2, v7}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Lkotlin/text/MatcherMatchResult;I)Landroid/content/res/ColorStateList;

    .line 142
    .line 143
    .line 144
    move-result-object v7

    .line 145
    iput-object v7, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    .line 146
    .line 147
    :cond_2
    const/16 v7, 0x47

    .line 148
    .line 149
    invoke-virtual {v5, v7}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 150
    .line 151
    .line 152
    move-result v8

    .line 153
    if-eqz v8, :cond_3

    .line 154
    .line 155
    invoke-virtual {v5, v7, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    .line 156
    .line 157
    .line 158
    move-result v7

    .line 159
    invoke-static {v7, v6}, Lcom/google/android/material/internal/ViewUtils;->parseTintMode(ILandroid/graphics/PorterDuff$Mode;)Landroid/graphics/PorterDuff$Mode;

    .line 160
    .line 161
    .line 162
    move-result-object v7

    .line 163
    iput-object v7, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintMode:Landroid/graphics/PorterDuff$Mode;

    .line 164
    .line 165
    :cond_3
    const/16 v7, 0x43

    .line 166
    .line 167
    invoke-virtual {v5, v7}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 168
    .line 169
    .line 170
    move-result v8

    .line 171
    const/4 v9, 0x1

    .line 172
    if-eqz v8, :cond_5

    .line 173
    .line 174
    invoke-virtual {p2, v7}, Lkotlin/text/MatcherMatchResult;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    .line 175
    .line 176
    .line 177
    move-result-object v7

    .line 178
    invoke-virtual {p0, v7}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 179
    .line 180
    .line 181
    const/16 v7, 0x42

    .line 182
    .line 183
    invoke-virtual {v5, v7}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 184
    .line 185
    .line 186
    move-result v8

    .line 187
    if-eqz v8, :cond_4

    .line 188
    .line 189
    invoke-virtual {v5, v7}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    .line 190
    .line 191
    .line 192
    move-result-object v7

    .line 193
    invoke-virtual {v1}, Landroid/view/View;->getContentDescription()Ljava/lang/CharSequence;

    .line 194
    .line 195
    .line 196
    move-result-object v8

    .line 197
    if-eq v8, v7, :cond_4

    .line 198
    .line 199
    invoke-virtual {v1, v7}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 200
    .line 201
    .line 202
    :cond_4
    const/16 v7, 0x41

    .line 203
    .line 204
    invoke-virtual {v5, v7, v9}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    .line 205
    .line 206
    .line 207
    move-result v7

    .line 208
    invoke-virtual {v1, v7}, Lcom/google/android/material/internal/CheckableImageButton;->setCheckable(Z)V

    .line 209
    .line 210
    .line 211
    :cond_5
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    .line 212
    .line 213
    .line 214
    move-result-object v7

    .line 215
    const v8, 0x7f0703bf

    .line 216
    .line 217
    .line 218
    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 219
    .line 220
    .line 221
    move-result v7

    .line 222
    const/16 v8, 0x44

    .line 223
    .line 224
    invoke-virtual {v5, v8, v7}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    .line 225
    .line 226
    .line 227
    move-result v7

    .line 228
    if-ltz v7, :cond_a

    .line 229
    .line 230
    iget v8, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconMinSize:I

    .line 231
    .line 232
    if-eq v7, v8, :cond_6

    .line 233
    .line 234
    iput v7, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconMinSize:I

    .line 235
    .line 236
    invoke-virtual {v1, v7}, Landroid/view/View;->setMinimumWidth(I)V

    .line 237
    .line 238
    .line 239
    invoke-virtual {v1, v7}, Landroid/view/View;->setMinimumHeight(I)V

    .line 240
    .line 241
    .line 242
    :cond_6
    const/16 v7, 0x45

    .line 243
    .line 244
    invoke-virtual {v5, v7}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 245
    .line 246
    .line 247
    move-result v8

    .line 248
    if-eqz v8, :cond_7

    .line 249
    .line 250
    invoke-virtual {v5, v7, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    .line 251
    .line 252
    .line 253
    move-result v4

    .line 254
    invoke-static {v4}, Lkotlin/LazyKt__LazyJVMKt;->convertScaleType(I)Landroid/widget/ImageView$ScaleType;

    .line 255
    .line 256
    .line 257
    move-result-object v4

    .line 258
    iput-object v4, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconScaleType:Landroid/widget/ImageView$ScaleType;

    .line 259
    .line 260
    invoke-virtual {v1, v4}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 261
    .line 262
    .line 263
    :cond_7
    invoke-virtual {v2, p1}, Landroid/view/View;->setVisibility(I)V

    .line 264
    .line 265
    .line 266
    const p1, 0x7f0a0355

    .line 267
    .line 268
    .line 269
    invoke-virtual {v2, p1}, Landroid/view/View;->setId(I)V

    .line 270
    .line 271
    .line 272
    new-instance p1, Landroid/widget/LinearLayout$LayoutParams;

    .line 273
    .line 274
    invoke-direct {p1, v3, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 275
    .line 276
    .line 277
    invoke-virtual {v2, p1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 278
    .line 279
    .line 280
    invoke-virtual {v2, v9}, Landroid/view/View;->setAccessibilityLiveRegion(I)V

    .line 281
    .line 282
    .line 283
    const/16 p1, 0x3d

    .line 284
    .line 285
    invoke-virtual {v5, p1, v0}, Landroid/content/res/TypedArray;->getResourceId(II)I

    .line 286
    .line 287
    .line 288
    move-result p1

    .line 289
    invoke-static {v2, p1}, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView;I)V

    .line 290
    .line 291
    .line 292
    const/16 p1, 0x3e

    .line 293
    .line 294
    invoke-virtual {v5, p1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 295
    .line 296
    .line 297
    move-result v0

    .line 298
    if-eqz v0, :cond_8

    .line 299
    .line 300
    invoke-virtual {p2, p1}, Lkotlin/text/MatcherMatchResult;->getColorStateList(I)Landroid/content/res/ColorStateList;

    .line 301
    .line 302
    .line 303
    move-result-object p1

    .line 304
    invoke-virtual {v2, p1}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 305
    .line 306
    .line 307
    :cond_8
    const/16 p1, 0x3c

    .line 308
    .line 309
    invoke-virtual {v5, p1}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    .line 310
    .line 311
    .line 312
    move-result-object p1

    .line 313
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    .line 314
    .line 315
    .line 316
    move-result p2

    .line 317
    if-eqz p2, :cond_9

    .line 318
    .line 319
    goto :goto_0

    .line 320
    :cond_9
    move-object v6, p1

    .line 321
    :goto_0
    iput-object v6, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixText:Ljava/lang/CharSequence;

    .line 322
    .line 323
    invoke-virtual {v2, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 324
    .line 325
    .line 326
    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updateVisibility()V

    .line 327
    .line 328
    .line 329
    invoke-virtual {p0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 330
    .line 331
    .line 332
    invoke-virtual {p0, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 333
    .line 334
    .line 335
    return-void

    .line 336
    :cond_a
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 337
    .line 338
    const-string p2, "startIconSize cannot be less than 0"

    .line 339
    .line 340
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 341
    .line 342
    .line 343
    throw p1
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


# virtual methods
.method public final getPrefixTextStartOffset()I
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    if-nez v1, :cond_0

    .line 8
    .line 9
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    .line 10
    .line 11
    .line 12
    move-result v1

    .line 13
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 18
    .line 19
    invoke-virtual {v0}, Landroid/view/ViewGroup$MarginLayoutParams;->getMarginEnd()I

    .line 20
    .line 21
    .line 22
    move-result v0

    .line 23
    add-int/2addr v0, v1

    .line 24
    goto :goto_0

    .line 25
    :cond_0
    const/4 v0, 0x0

    .line 26
    :goto_0
    invoke-virtual {p0}, Landroid/view/View;->getPaddingStart()I

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    iget-object v2, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroidx/appcompat/widget/AppCompatTextView;

    .line 31
    .line 32
    invoke-virtual {v2}, Landroid/view/View;->getPaddingStart()I

    .line 33
    .line 34
    .line 35
    move-result v2

    .line 36
    add-int/2addr v2, v1

    .line 37
    add-int/2addr v2, v0

    .line 38
    return v2
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

.method public final onMeasure(II)V
    .locals 0

    .line 1
    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updatePrefixTextViewPadding()V

    .line 5
    .line 6
    .line 7
    return-void
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

.method public final setStartIconDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Landroidx/appcompat/widget/AppCompatImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 4
    .line 5
    .line 6
    if-eqz p1, :cond_0

    .line 7
    .line 8
    iget-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    .line 9
    .line 10
    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintMode:Landroid/graphics/PorterDuff$Mode;

    .line 11
    .line 12
    iget-object v2, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    .line 13
    .line 14
    invoke-static {v2, v0, p1, v1}, Lkotlin/LazyKt__LazyJVMKt;->applyIconTint(Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;Landroid/graphics/PorterDuff$Mode;)V

    .line 15
    .line 16
    .line 17
    const/4 p1, 0x1

    .line 18
    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconVisible(Z)V

    .line 19
    .line 20
    .line 21
    iget-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconTintList:Landroid/content/res/ColorStateList;

    .line 22
    .line 23
    invoke-static {v2, v0, p1}, Lkotlin/LazyKt__LazyJVMKt;->refreshIconDrawableState(Lcom/google/android/material/textfield/TextInputLayout;Lcom/google/android/material/internal/CheckableImageButton;Landroid/content/res/ColorStateList;)V

    .line 24
    .line 25
    .line 26
    return-void

    .line 27
    :cond_0
    const/4 p1, 0x0

    .line 28
    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/StartCompoundLayout;->setStartIconVisible(Z)V

    .line 29
    .line 30
    .line 31
    iget-object p1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconOnLongClickListener:Landroid/view/View$OnLongClickListener;

    .line 32
    .line 33
    const/4 v1, 0x0

    .line 34
    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    .line 36
    .line 37
    invoke-static {v0, p1}, Lkotlin/LazyKt__LazyJVMKt;->setIconClickable(Lcom/google/android/material/internal/CheckableImageButton;Landroid/view/View$OnLongClickListener;)V

    .line 38
    .line 39
    .line 40
    iput-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconOnLongClickListener:Landroid/view/View$OnLongClickListener;

    .line 41
    .line 42
    invoke-virtual {v0, v1}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 43
    .line 44
    .line 45
    invoke-static {v0, v1}, Lkotlin/LazyKt__LazyJVMKt;->setIconClickable(Lcom/google/android/material/internal/CheckableImageButton;Landroid/view/View$OnLongClickListener;)V

    .line 46
    .line 47
    .line 48
    invoke-virtual {v0}, Landroid/view/View;->getContentDescription()Ljava/lang/CharSequence;

    .line 49
    .line 50
    .line 51
    move-result-object p1

    .line 52
    if-eqz p1, :cond_1

    .line 53
    .line 54
    invoke-virtual {v0, v1}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 55
    .line 56
    .line 57
    :cond_1
    return-void
.end method

.method public final setStartIconVisible(Z)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    const/4 v2, 0x0

    .line 8
    if-nez v1, :cond_0

    .line 9
    .line 10
    const/4 v1, 0x1

    .line 11
    goto :goto_0

    .line 12
    :cond_0
    const/4 v1, 0x0

    .line 13
    :goto_0
    if-eq v1, p1, :cond_2

    .line 14
    .line 15
    if-eqz p1, :cond_1

    .line 16
    .line 17
    goto :goto_1

    .line 18
    :cond_1
    const/16 v2, 0x8

    .line 19
    .line 20
    :goto_1
    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 21
    .line 22
    .line 23
    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updatePrefixTextViewPadding()V

    .line 24
    .line 25
    .line 26
    invoke-virtual {p0}, Lcom/google/android/material/textfield/StartCompoundLayout;->updateVisibility()V

    .line 27
    .line 28
    .line 29
    :cond_2
    return-void
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

.method public final updatePrefixTextViewPadding()V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    .line 2
    .line 3
    iget-object v0, v0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    .line 4
    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    return-void

    .line 8
    :cond_0
    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    .line 9
    .line 10
    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    .line 11
    .line 12
    .line 13
    move-result v1

    .line 14
    if-nez v1, :cond_1

    .line 15
    .line 16
    const/4 v1, 0x0

    .line 17
    goto :goto_0

    .line 18
    :cond_1
    invoke-virtual {v0}, Landroid/view/View;->getPaddingStart()I

    .line 19
    .line 20
    .line 21
    move-result v1

    .line 22
    :goto_0
    invoke-virtual {v0}, Landroid/widget/TextView;->getCompoundPaddingTop()I

    .line 23
    .line 24
    .line 25
    move-result v2

    .line 26
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 27
    .line 28
    .line 29
    move-result-object v3

    .line 30
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 31
    .line 32
    .line 33
    move-result-object v3

    .line 34
    const v4, 0x7f07033d

    .line 35
    .line 36
    .line 37
    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 38
    .line 39
    .line 40
    move-result v3

    .line 41
    invoke-virtual {v0}, Landroid/widget/TextView;->getCompoundPaddingBottom()I

    .line 42
    .line 43
    .line 44
    move-result v0

    .line 45
    iget-object v4, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroidx/appcompat/widget/AppCompatTextView;

    .line 46
    .line 47
    invoke-virtual {v4, v1, v2, v3, v0}, Landroid/widget/TextView;->setPaddingRelative(IIII)V

    .line 48
    .line 49
    .line 50
    return-void
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method public final updateVisibility()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixText:Ljava/lang/CharSequence;

    .line 2
    .line 3
    const/16 v1, 0x8

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    if-eqz v0, :cond_0

    .line 7
    .line 8
    iget-boolean v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->hintExpanded:Z

    .line 9
    .line 10
    if-nez v0, :cond_0

    .line 11
    .line 12
    const/4 v0, 0x0

    .line 13
    goto :goto_0

    .line 14
    :cond_0
    const/16 v0, 0x8

    .line 15
    .line 16
    :goto_0
    iget-object v3, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->startIconView:Lcom/google/android/material/internal/CheckableImageButton;

    .line 17
    .line 18
    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    .line 19
    .line 20
    .line 21
    move-result v3

    .line 22
    if-eqz v3, :cond_1

    .line 23
    .line 24
    if-nez v0, :cond_2

    .line 25
    .line 26
    :cond_1
    const/4 v1, 0x0

    .line 27
    :cond_2
    invoke-virtual {p0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 28
    .line 29
    .line 30
    iget-object v1, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->prefixTextView:Landroidx/appcompat/widget/AppCompatTextView;

    .line 31
    .line 32
    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 33
    .line 34
    .line 35
    iget-object v0, p0, Lcom/google/android/material/textfield/StartCompoundLayout;->textInputLayout:Lcom/google/android/material/textfield/TextInputLayout;

    .line 36
    .line 37
    invoke-virtual {v0}, Lcom/google/android/material/textfield/TextInputLayout;->updateDummyDrawables()Z

    .line 38
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
.end method
