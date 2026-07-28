.class Lcom/google/android/material/timepicker/ClockFaceView;
.super Lcom/google/android/material/timepicker/RadialViewGroup;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/material/timepicker/ClockHandView$OnRotateListener;


# instance fields
.field public final clockHandPadding:I

.field public final clockHandView:Lcom/google/android/material/timepicker/ClockHandView;

.field public final clockSize:I

.field public currentHandRotation:F

.field public final gradientColors:[I

.field public final gradientPositions:[F

.field public final minimumHeight:I

.field public final minimumWidth:I

.field public final scratch:Landroid/graphics/RectF;

.field public final scratchLineBounds:Landroid/graphics/Rect;

.field public final textColor:Landroid/content/res/ColorStateList;

.field public final textViewPool:Landroid/util/SparseArray;

.field public final textViewRect:Landroid/graphics/Rect;

.field public final valueAccessibilityDelegate:Lcom/google/android/material/timepicker/ClockFaceView$2;

.field public final values:[Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 10

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/google/android/material/timepicker/RadialViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 2
    .line 3
    .line 4
    new-instance v0, Landroid/graphics/Rect;

    .line 5
    .line 6
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lcom/google/android/material/timepicker/ClockFaceView;->textViewRect:Landroid/graphics/Rect;

    .line 10
    .line 11
    new-instance v0, Landroid/graphics/RectF;

    .line 12
    .line 13
    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    .line 14
    .line 15
    .line 16
    iput-object v0, p0, Lcom/google/android/material/timepicker/ClockFaceView;->scratch:Landroid/graphics/RectF;

    .line 17
    .line 18
    new-instance v0, Landroid/graphics/Rect;

    .line 19
    .line 20
    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 21
    .line 22
    .line 23
    iput-object v0, p0, Lcom/google/android/material/timepicker/ClockFaceView;->scratchLineBounds:Landroid/graphics/Rect;

    .line 24
    .line 25
    new-instance v0, Landroid/util/SparseArray;

    .line 26
    .line 27
    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    .line 28
    .line 29
    .line 30
    iput-object v0, p0, Lcom/google/android/material/timepicker/ClockFaceView;->textViewPool:Landroid/util/SparseArray;

    .line 31
    .line 32
    const/4 v1, 0x3

    .line 33
    new-array v1, v1, [F

    .line 34
    .line 35
    fill-array-data v1, :array_0

    .line 36
    .line 37
    .line 38
    iput-object v1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->gradientPositions:[F

    .line 39
    .line 40
    sget-object v1, Lcom/google/android/material/R$styleable;->ClockFaceView:[I

    .line 41
    .line 42
    const v2, 0x7f1504f3

    .line 43
    .line 44
    .line 45
    const v3, 0x7f040370

    .line 46
    .line 47
    .line 48
    invoke-virtual {p1, p2, v1, v3, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    .line 49
    .line 50
    .line 51
    move-result-object p2

    .line 52
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    .line 53
    .line 54
    .line 55
    move-result-object v1

    .line 56
    const/4 v2, 0x1

    .line 57
    invoke-static {p1, p2, v2}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 58
    .line 59
    .line 60
    move-result-object v3

    .line 61
    iput-object v3, p0, Lcom/google/android/material/timepicker/ClockFaceView;->textColor:Landroid/content/res/ColorStateList;

    .line 62
    .line 63
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    .line 64
    .line 65
    .line 66
    move-result-object v4

    .line 67
    const v5, 0x7f0d0061

    .line 68
    .line 69
    .line 70
    invoke-virtual {v4, v5, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 71
    .line 72
    .line 73
    const v4, 0x7f0a01e7

    .line 74
    .line 75
    .line 76
    invoke-virtual {p0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 77
    .line 78
    .line 79
    move-result-object v4

    .line 80
    check-cast v4, Lcom/google/android/material/timepicker/ClockHandView;

    .line 81
    .line 82
    iput-object v4, p0, Lcom/google/android/material/timepicker/ClockFaceView;->clockHandView:Lcom/google/android/material/timepicker/ClockHandView;

    .line 83
    .line 84
    const v5, 0x7f070325

    .line 85
    .line 86
    .line 87
    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 88
    .line 89
    .line 90
    move-result v5

    .line 91
    iput v5, p0, Lcom/google/android/material/timepicker/ClockFaceView;->clockHandPadding:I

    .line 92
    .line 93
    const v5, 0x10100a1

    .line 94
    .line 95
    .line 96
    filled-new-array {v5}, [I

    .line 97
    .line 98
    .line 99
    move-result-object v5

    .line 100
    invoke-virtual {v3}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    .line 101
    .line 102
    .line 103
    move-result v6

    .line 104
    invoke-virtual {v3, v5, v6}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    .line 105
    .line 106
    .line 107
    move-result v5

    .line 108
    invoke-virtual {v3}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    .line 109
    .line 110
    .line 111
    move-result v3

    .line 112
    filled-new-array {v5, v5, v3}, [I

    .line 113
    .line 114
    .line 115
    move-result-object v3

    .line 116
    iput-object v3, p0, Lcom/google/android/material/timepicker/ClockFaceView;->gradientColors:[I

    .line 117
    .line 118
    iget-object v3, v4, Lcom/google/android/material/timepicker/ClockHandView;->listeners:Ljava/util/ArrayList;

    .line 119
    .line 120
    invoke-virtual {v3, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 121
    .line 122
    .line 123
    const v3, 0x7f060385

    .line 124
    .line 125
    .line 126
    invoke-static {p1, v3}, Landroidx/core/os/BundleKt;->getColorStateList(Landroid/content/Context;I)Landroid/content/res/ColorStateList;

    .line 127
    .line 128
    .line 129
    move-result-object v3

    .line 130
    invoke-virtual {v3}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    .line 131
    .line 132
    .line 133
    move-result v3

    .line 134
    const/4 v4, 0x0

    .line 135
    invoke-static {p1, p2, v4}, Lkotlin/LazyKt__LazyJVMKt;->getColorStateList(Landroid/content/Context;Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;

    .line 136
    .line 137
    .line 138
    move-result-object p1

    .line 139
    if-nez p1, :cond_0

    .line 140
    .line 141
    goto :goto_0

    .line 142
    :cond_0
    invoke-virtual {p1}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    .line 143
    .line 144
    .line 145
    move-result v3

    .line 146
    :goto_0
    invoke-virtual {p0, v3}, Lcom/google/android/material/timepicker/RadialViewGroup;->setBackgroundColor(I)V

    .line 147
    .line 148
    .line 149
    invoke-virtual {p0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    .line 150
    .line 151
    .line 152
    move-result-object p1

    .line 153
    new-instance v3, Lcom/google/android/material/timepicker/ClockFaceView$1;

    .line 154
    .line 155
    invoke-direct {v3, p0}, Lcom/google/android/material/timepicker/ClockFaceView$1;-><init>(Lcom/google/android/material/timepicker/ClockFaceView;)V

    .line 156
    .line 157
    .line 158
    invoke-virtual {p1, v3}, Landroid/view/ViewTreeObserver;->addOnPreDrawListener(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V

    .line 159
    .line 160
    .line 161
    invoke-virtual {p0, v4}, Landroid/view/View;->setFocusable(Z)V

    .line 162
    .line 163
    .line 164
    invoke-virtual {p2}, Landroid/content/res/TypedArray;->recycle()V

    .line 165
    .line 166
    .line 167
    new-instance p1, Lcom/google/android/material/timepicker/ClockFaceView$2;

    .line 168
    .line 169
    invoke-direct {p1, p0}, Lcom/google/android/material/timepicker/ClockFaceView$2;-><init>(Lcom/google/android/material/timepicker/ClockFaceView;)V

    .line 170
    .line 171
    .line 172
    iput-object p1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->valueAccessibilityDelegate:Lcom/google/android/material/timepicker/ClockFaceView$2;

    .line 173
    .line 174
    const/16 p1, 0xc

    .line 175
    .line 176
    new-array p1, p1, [Ljava/lang/String;

    .line 177
    .line 178
    const-string p2, ""

    .line 179
    .line 180
    invoke-static {p1, p2}, Ljava/util/Arrays;->fill([Ljava/lang/Object;Ljava/lang/Object;)V

    .line 181
    .line 182
    .line 183
    iput-object p1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->values:[Ljava/lang/String;

    .line 184
    .line 185
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 186
    .line 187
    .line 188
    move-result-object p1

    .line 189
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    .line 190
    .line 191
    .line 192
    move-result-object p1

    .line 193
    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    .line 194
    .line 195
    .line 196
    move-result p2

    .line 197
    const/4 v3, 0x0

    .line 198
    const/4 v5, 0x0

    .line 199
    :goto_1
    iget-object v6, p0, Lcom/google/android/material/timepicker/ClockFaceView;->values:[Ljava/lang/String;

    .line 200
    .line 201
    array-length v6, v6

    .line 202
    invoke-static {v6, p2}, Ljava/lang/Math;->max(II)I

    .line 203
    .line 204
    .line 205
    move-result v6

    .line 206
    if-ge v3, v6, :cond_4

    .line 207
    .line 208
    invoke-virtual {v0, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    .line 209
    .line 210
    .line 211
    move-result-object v6

    .line 212
    check-cast v6, Landroid/widget/TextView;

    .line 213
    .line 214
    iget-object v7, p0, Lcom/google/android/material/timepicker/ClockFaceView;->values:[Ljava/lang/String;

    .line 215
    .line 216
    array-length v7, v7

    .line 217
    if-lt v3, v7, :cond_1

    .line 218
    .line 219
    invoke-virtual {p0, v6}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 220
    .line 221
    .line 222
    invoke-virtual {v0, v3}, Landroid/util/SparseArray;->remove(I)V

    .line 223
    .line 224
    .line 225
    goto :goto_2

    .line 226
    :cond_1
    if-nez v6, :cond_2

    .line 227
    .line 228
    const v6, 0x7f0d0060

    .line 229
    .line 230
    .line 231
    invoke-virtual {p1, v6, p0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 232
    .line 233
    .line 234
    move-result-object v6

    .line 235
    check-cast v6, Landroid/widget/TextView;

    .line 236
    .line 237
    invoke-virtual {v0, v3, v6}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 238
    .line 239
    .line 240
    invoke-virtual {p0, v6}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 241
    .line 242
    .line 243
    :cond_2
    iget-object v7, p0, Lcom/google/android/material/timepicker/ClockFaceView;->values:[Ljava/lang/String;

    .line 244
    .line 245
    aget-object v7, v7, v3

    .line 246
    .line 247
    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 248
    .line 249
    .line 250
    const v7, 0x7f0a01f7

    .line 251
    .line 252
    .line 253
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 254
    .line 255
    .line 256
    move-result-object v8

    .line 257
    invoke-virtual {v6, v7, v8}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 258
    .line 259
    .line 260
    div-int/lit8 v7, v3, 0xc

    .line 261
    .line 262
    add-int/2addr v7, v2

    .line 263
    const v8, 0x7f0a01e8

    .line 264
    .line 265
    .line 266
    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 267
    .line 268
    .line 269
    move-result-object v9

    .line 270
    invoke-virtual {v6, v8, v9}, Landroid/view/View;->setTag(ILjava/lang/Object;)V

    .line 271
    .line 272
    .line 273
    if-le v7, v2, :cond_3

    .line 274
    .line 275
    const/4 v5, 0x1

    .line 276
    :cond_3
    iget-object v7, p0, Lcom/google/android/material/timepicker/ClockFaceView;->valueAccessibilityDelegate:Lcom/google/android/material/timepicker/ClockFaceView$2;

    .line 277
    .line 278
    invoke-static {v6, v7}, Landroidx/core/view/ViewCompat;->setAccessibilityDelegate(Landroid/view/View;Landroidx/core/view/AccessibilityDelegateCompat;)V

    .line 279
    .line 280
    .line 281
    iget-object v7, p0, Lcom/google/android/material/timepicker/ClockFaceView;->textColor:Landroid/content/res/ColorStateList;

    .line 282
    .line 283
    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 284
    .line 285
    .line 286
    :goto_2
    add-int/lit8 v3, v3, 0x1

    .line 287
    .line 288
    goto :goto_1

    .line 289
    :cond_4
    iget-object p1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->clockHandView:Lcom/google/android/material/timepicker/ClockHandView;

    .line 290
    .line 291
    iget-boolean p2, p1, Lcom/google/android/material/timepicker/ClockHandView;->isMultiLevel:Z

    .line 292
    .line 293
    if-eqz p2, :cond_5

    .line 294
    .line 295
    if-nez v5, :cond_5

    .line 296
    .line 297
    iput v2, p1, Lcom/google/android/material/timepicker/ClockHandView;->currentLevel:I

    .line 298
    .line 299
    :cond_5
    iput-boolean v5, p1, Lcom/google/android/material/timepicker/ClockHandView;->isMultiLevel:Z

    .line 300
    .line 301
    invoke-virtual {p1}, Landroid/view/View;->invalidate()V

    .line 302
    .line 303
    .line 304
    const p1, 0x7f070342

    .line 305
    .line 306
    .line 307
    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 308
    .line 309
    .line 310
    move-result p1

    .line 311
    iput p1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->minimumHeight:I

    .line 312
    .line 313
    const p1, 0x7f070343

    .line 314
    .line 315
    .line 316
    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 317
    .line 318
    .line 319
    move-result p1

    .line 320
    iput p1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->minimumWidth:I

    .line 321
    .line 322
    const p1, 0x7f07032c

    .line 323
    .line 324
    .line 325
    invoke-virtual {v1, p1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    .line 326
    .line 327
    .line 328
    move-result p1

    .line 329
    iput p1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->clockSize:I

    .line 330
    .line 331
    return-void

    .line 332
    nop

    .line 333
    :array_0
    .array-data 4
        0x0
        0x3f666666    # 0.9f
        0x3f800000    # 1.0f
    .end array-data
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


# virtual methods
.method public final findIntersectingTextView()V
    .locals 18

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    iget-object v1, v0, Lcom/google/android/material/timepicker/ClockFaceView;->clockHandView:Lcom/google/android/material/timepicker/ClockHandView;

    .line 4
    .line 5
    iget-object v1, v1, Lcom/google/android/material/timepicker/ClockHandView;->selectorBox:Landroid/graphics/RectF;

    .line 6
    .line 7
    const v2, 0x7f7fffff    # Float.MAX_VALUE

    .line 8
    .line 9
    .line 10
    const/4 v3, 0x0

    .line 11
    const/4 v4, 0x0

    .line 12
    move-object v6, v3

    .line 13
    const/4 v5, 0x0

    .line 14
    :goto_0
    iget-object v7, v0, Lcom/google/android/material/timepicker/ClockFaceView;->textViewPool:Landroid/util/SparseArray;

    .line 15
    .line 16
    invoke-virtual {v7}, Landroid/util/SparseArray;->size()I

    .line 17
    .line 18
    .line 19
    move-result v8

    .line 20
    iget-object v9, v0, Lcom/google/android/material/timepicker/ClockFaceView;->textViewRect:Landroid/graphics/Rect;

    .line 21
    .line 22
    iget-object v10, v0, Lcom/google/android/material/timepicker/ClockFaceView;->scratch:Landroid/graphics/RectF;

    .line 23
    .line 24
    if-ge v5, v8, :cond_2

    .line 25
    .line 26
    invoke-virtual {v7, v5}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    .line 27
    .line 28
    .line 29
    move-result-object v7

    .line 30
    check-cast v7, Landroid/widget/TextView;

    .line 31
    .line 32
    if-nez v7, :cond_0

    .line 33
    .line 34
    goto :goto_1

    .line 35
    :cond_0
    invoke-virtual {v7, v9}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 36
    .line 37
    .line 38
    invoke-virtual {v10, v9}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    .line 39
    .line 40
    .line 41
    invoke-virtual {v10, v1}, Landroid/graphics/RectF;->union(Landroid/graphics/RectF;)V

    .line 42
    .line 43
    .line 44
    invoke-virtual {v10}, Landroid/graphics/RectF;->width()F

    .line 45
    .line 46
    .line 47
    move-result v8

    .line 48
    invoke-virtual {v10}, Landroid/graphics/RectF;->height()F

    .line 49
    .line 50
    .line 51
    move-result v9

    .line 52
    mul-float v9, v9, v8

    .line 53
    .line 54
    cmpg-float v8, v9, v2

    .line 55
    .line 56
    if-gez v8, :cond_1

    .line 57
    .line 58
    move-object v6, v7

    .line 59
    move v2, v9

    .line 60
    :cond_1
    :goto_1
    add-int/lit8 v5, v5, 0x1

    .line 61
    .line 62
    goto :goto_0

    .line 63
    :cond_2
    const/4 v2, 0x0

    .line 64
    :goto_2
    invoke-virtual {v7}, Landroid/util/SparseArray;->size()I

    .line 65
    .line 66
    .line 67
    move-result v5

    .line 68
    if-ge v2, v5, :cond_6

    .line 69
    .line 70
    invoke-virtual {v7, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    .line 71
    .line 72
    .line 73
    move-result-object v5

    .line 74
    check-cast v5, Landroid/widget/TextView;

    .line 75
    .line 76
    if-nez v5, :cond_3

    .line 77
    .line 78
    goto :goto_5

    .line 79
    :cond_3
    if-ne v5, v6, :cond_4

    .line 80
    .line 81
    const/4 v8, 0x1

    .line 82
    goto :goto_3

    .line 83
    :cond_4
    const/4 v8, 0x0

    .line 84
    :goto_3
    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setSelected(Z)V

    .line 85
    .line 86
    .line 87
    invoke-virtual {v5, v9}, Landroid/view/View;->getHitRect(Landroid/graphics/Rect;)V

    .line 88
    .line 89
    .line 90
    invoke-virtual {v10, v9}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    .line 91
    .line 92
    .line 93
    iget-object v8, v0, Lcom/google/android/material/timepicker/ClockFaceView;->scratchLineBounds:Landroid/graphics/Rect;

    .line 94
    .line 95
    invoke-virtual {v5, v4, v8}, Landroid/widget/TextView;->getLineBounds(ILandroid/graphics/Rect;)I

    .line 96
    .line 97
    .line 98
    iget v11, v8, Landroid/graphics/Rect;->left:I

    .line 99
    .line 100
    int-to-float v11, v11

    .line 101
    iget v8, v8, Landroid/graphics/Rect;->top:I

    .line 102
    .line 103
    int-to-float v8, v8

    .line 104
    invoke-virtual {v10, v11, v8}, Landroid/graphics/RectF;->inset(FF)V

    .line 105
    .line 106
    .line 107
    invoke-static {v1, v10}, Landroid/graphics/RectF;->intersects(Landroid/graphics/RectF;Landroid/graphics/RectF;)Z

    .line 108
    .line 109
    .line 110
    move-result v8

    .line 111
    if-nez v8, :cond_5

    .line 112
    .line 113
    move-object v11, v3

    .line 114
    goto :goto_4

    .line 115
    :cond_5
    new-instance v11, Landroid/graphics/RadialGradient;

    .line 116
    .line 117
    invoke-virtual {v1}, Landroid/graphics/RectF;->centerX()F

    .line 118
    .line 119
    .line 120
    move-result v8

    .line 121
    iget v12, v10, Landroid/graphics/RectF;->left:F

    .line 122
    .line 123
    sub-float v12, v8, v12

    .line 124
    .line 125
    invoke-virtual {v1}, Landroid/graphics/RectF;->centerY()F

    .line 126
    .line 127
    .line 128
    move-result v8

    .line 129
    iget v13, v10, Landroid/graphics/RectF;->top:F

    .line 130
    .line 131
    sub-float v13, v8, v13

    .line 132
    .line 133
    invoke-virtual {v1}, Landroid/graphics/RectF;->width()F

    .line 134
    .line 135
    .line 136
    move-result v8

    .line 137
    const/high16 v14, 0x3f000000    # 0.5f

    .line 138
    .line 139
    mul-float v14, v14, v8

    .line 140
    .line 141
    iget-object v8, v0, Lcom/google/android/material/timepicker/ClockFaceView;->gradientPositions:[F

    .line 142
    .line 143
    sget-object v17, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    .line 144
    .line 145
    iget-object v15, v0, Lcom/google/android/material/timepicker/ClockFaceView;->gradientColors:[I

    .line 146
    .line 147
    move-object/from16 v16, v8

    .line 148
    .line 149
    invoke-direct/range {v11 .. v17}, Landroid/graphics/RadialGradient;-><init>(FFF[I[FLandroid/graphics/Shader$TileMode;)V

    .line 150
    .line 151
    .line 152
    :goto_4
    invoke-virtual {v5}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    .line 153
    .line 154
    .line 155
    move-result-object v8

    .line 156
    invoke-virtual {v8, v11}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 157
    .line 158
    .line 159
    invoke-virtual {v5}, Landroid/view/View;->invalidate()V

    .line 160
    .line 161
    .line 162
    :goto_5
    add-int/lit8 v2, v2, 0x1

    .line 163
    .line 164
    goto :goto_2

    .line 165
    :cond_6
    return-void
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

.method public final onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 3

    .line 1
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lcom/google/android/material/timepicker/ClockFaceView;->values:[Ljava/lang/String;

    .line 5
    .line 6
    array-length v0, v0

    .line 7
    const/4 v1, 0x0

    .line 8
    const/4 v2, 0x1

    .line 9
    invoke-static {v2, v0, v2, v1}, Lcom/google/android/material/snackbar/SnackbarManager;->obtain(IIIZ)Lcom/google/android/material/snackbar/SnackbarManager;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    iget-object v0, v0, Lcom/google/android/material/snackbar/SnackbarManager;->lock:Ljava/lang/Object;

    .line 14
    .line 15
    check-cast v0, Landroid/view/accessibility/AccessibilityNodeInfo$CollectionInfo;

    .line 16
    .line 17
    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setCollectionInfo(Landroid/view/accessibility/AccessibilityNodeInfo$CollectionInfo;)V

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
.end method

.method public final onLayout(ZIIII)V
    .locals 0

    .line 1
    invoke-super/range {p0 .. p5}, Landroidx/constraintlayout/widget/ConstraintLayout;->onLayout(ZIIII)V

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0}, Lcom/google/android/material/timepicker/ClockFaceView;->findIntersectingTextView()V

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

.method public final onMeasure(II)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    iget p2, p1, Landroid/util/DisplayMetrics;->heightPixels:I

    .line 10
    .line 11
    int-to-float p2, p2

    .line 12
    iget p1, p1, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 13
    .line 14
    int-to-float p1, p1

    .line 15
    iget v0, p0, Lcom/google/android/material/timepicker/ClockFaceView;->clockSize:I

    .line 16
    .line 17
    int-to-float v0, v0

    .line 18
    iget v1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->minimumHeight:I

    .line 19
    .line 20
    int-to-float v1, v1

    .line 21
    div-float/2addr v1, p2

    .line 22
    iget p2, p0, Lcom/google/android/material/timepicker/ClockFaceView;->minimumWidth:I

    .line 23
    .line 24
    int-to-float p2, p2

    .line 25
    div-float/2addr p2, p1

    .line 26
    const/high16 p1, 0x3f800000    # 1.0f

    .line 27
    .line 28
    invoke-static {v1, p2}, Ljava/lang/Math;->max(FF)F

    .line 29
    .line 30
    .line 31
    move-result p2

    .line 32
    invoke-static {p2, p1}, Ljava/lang/Math;->max(FF)F

    .line 33
    .line 34
    .line 35
    move-result p1

    .line 36
    div-float/2addr v0, p1

    .line 37
    float-to-int p1, v0

    .line 38
    const/high16 p2, 0x40000000    # 2.0f

    .line 39
    .line 40
    invoke-static {p1, p2}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    .line 41
    .line 42
    .line 43
    move-result p2

    .line 44
    invoke-virtual {p0, p1, p1}, Landroid/view/View;->setMeasuredDimension(II)V

    .line 45
    .line 46
    .line 47
    invoke-super {p0, p2, p2}, Landroidx/constraintlayout/widget/ConstraintLayout;->onMeasure(II)V

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

.method public final updateLayoutParams()V
    .locals 12

    .line 1
    new-instance v0, Landroidx/constraintlayout/widget/ConstraintSet;

    .line 2
    .line 3
    invoke-direct {v0}, Landroidx/constraintlayout/widget/ConstraintSet;-><init>()V

    .line 4
    .line 5
    .line 6
    invoke-virtual {v0, p0}, Landroidx/constraintlayout/widget/ConstraintSet;->clone(Landroidx/constraintlayout/widget/ConstraintLayout;)V

    .line 7
    .line 8
    .line 9
    new-instance v1, Ljava/util/HashMap;

    .line 10
    .line 11
    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 12
    .line 13
    .line 14
    const/4 v2, 0x0

    .line 15
    const/4 v3, 0x0

    .line 16
    :goto_0
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    .line 17
    .line 18
    .line 19
    move-result v4

    .line 20
    const v5, 0x7f0a00bf

    .line 21
    .line 22
    .line 23
    if-ge v3, v4, :cond_4

    .line 24
    .line 25
    invoke-virtual {p0, v3}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    .line 26
    .line 27
    .line 28
    move-result-object v4

    .line 29
    invoke-virtual {v4}, Landroid/view/View;->getId()I

    .line 30
    .line 31
    .line 32
    move-result v6

    .line 33
    if-eq v6, v5, :cond_3

    .line 34
    .line 35
    const-string v5, "skip"

    .line 36
    .line 37
    invoke-virtual {v4}, Landroid/view/View;->getTag()Ljava/lang/Object;

    .line 38
    .line 39
    .line 40
    move-result-object v6

    .line 41
    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 42
    .line 43
    .line 44
    move-result v5

    .line 45
    if-eqz v5, :cond_0

    .line 46
    .line 47
    goto :goto_1

    .line 48
    :cond_0
    const v5, 0x7f0a01e8

    .line 49
    .line 50
    .line 51
    invoke-virtual {v4, v5}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    .line 52
    .line 53
    .line 54
    move-result-object v5

    .line 55
    check-cast v5, Ljava/lang/Integer;

    .line 56
    .line 57
    if-nez v5, :cond_1

    .line 58
    .line 59
    const/4 v5, 0x1

    .line 60
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 61
    .line 62
    .line 63
    move-result-object v5

    .line 64
    :cond_1
    invoke-virtual {v1, v5}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    .line 65
    .line 66
    .line 67
    move-result v6

    .line 68
    if-nez v6, :cond_2

    .line 69
    .line 70
    new-instance v6, Ljava/util/ArrayList;

    .line 71
    .line 72
    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 73
    .line 74
    .line 75
    invoke-virtual {v1, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    .line 77
    .line 78
    :cond_2
    invoke-virtual {v1, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    .line 80
    .line 81
    move-result-object v5

    .line 82
    check-cast v5, Ljava/util/List;

    .line 83
    .line 84
    invoke-interface {v5, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 85
    .line 86
    .line 87
    :cond_3
    :goto_1
    add-int/lit8 v3, v3, 0x1

    .line 88
    .line 89
    goto :goto_0

    .line 90
    :cond_4
    invoke-virtual {v1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    .line 91
    .line 92
    .line 93
    move-result-object v1

    .line 94
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 95
    .line 96
    .line 97
    move-result-object v1

    .line 98
    :cond_5
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    .line 99
    .line 100
    .line 101
    move-result v3

    .line 102
    if-eqz v3, :cond_8

    .line 103
    .line 104
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 105
    .line 106
    .line 107
    move-result-object v3

    .line 108
    check-cast v3, Ljava/util/Map$Entry;

    .line 109
    .line 110
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    .line 111
    .line 112
    .line 113
    move-result-object v4

    .line 114
    check-cast v4, Ljava/util/List;

    .line 115
    .line 116
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    .line 117
    .line 118
    .line 119
    move-result-object v3

    .line 120
    check-cast v3, Ljava/lang/Integer;

    .line 121
    .line 122
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    .line 123
    .line 124
    .line 125
    move-result v3

    .line 126
    const/4 v6, 0x2

    .line 127
    if-ne v3, v6, :cond_6

    .line 128
    .line 129
    iget v3, p0, Lcom/google/android/material/timepicker/RadialViewGroup;->radius:I

    .line 130
    .line 131
    int-to-float v3, v3

    .line 132
    const v6, 0x3f28f5c3    # 0.66f

    .line 133
    .line 134
    .line 135
    mul-float v3, v3, v6

    .line 136
    .line 137
    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    .line 138
    .line 139
    .line 140
    move-result v3

    .line 141
    goto :goto_2

    .line 142
    :cond_6
    iget v3, p0, Lcom/google/android/material/timepicker/RadialViewGroup;->radius:I

    .line 143
    .line 144
    :goto_2
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 145
    .line 146
    .line 147
    move-result-object v6

    .line 148
    const/4 v7, 0x0

    .line 149
    :goto_3
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    .line 150
    .line 151
    .line 152
    move-result v8

    .line 153
    if-eqz v8, :cond_5

    .line 154
    .line 155
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 156
    .line 157
    .line 158
    move-result-object v8

    .line 159
    check-cast v8, Landroid/view/View;

    .line 160
    .line 161
    invoke-virtual {v8}, Landroid/view/View;->getId()I

    .line 162
    .line 163
    .line 164
    move-result v8

    .line 165
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 166
    .line 167
    .line 168
    move-result-object v9

    .line 169
    iget-object v10, v0, Landroidx/constraintlayout/widget/ConstraintSet;->mConstraints:Ljava/util/HashMap;

    .line 170
    .line 171
    invoke-virtual {v10, v9}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    .line 172
    .line 173
    .line 174
    move-result v9

    .line 175
    if-nez v9, :cond_7

    .line 176
    .line 177
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 178
    .line 179
    .line 180
    move-result-object v9

    .line 181
    new-instance v11, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;

    .line 182
    .line 183
    invoke-direct {v11}, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;-><init>()V

    .line 184
    .line 185
    .line 186
    invoke-virtual {v10, v9, v11}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 187
    .line 188
    .line 189
    :cond_7
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 190
    .line 191
    .line 192
    move-result-object v8

    .line 193
    invoke-virtual {v10, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 194
    .line 195
    .line 196
    move-result-object v8

    .line 197
    check-cast v8, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;

    .line 198
    .line 199
    iget-object v8, v8, Landroidx/constraintlayout/widget/ConstraintSet$Constraint;->layout:Landroidx/constraintlayout/widget/ConstraintSet$Layout;

    .line 200
    .line 201
    iput v5, v8, Landroidx/constraintlayout/widget/ConstraintSet$Layout;->circleConstraint:I

    .line 202
    .line 203
    iput v3, v8, Landroidx/constraintlayout/widget/ConstraintSet$Layout;->circleRadius:I

    .line 204
    .line 205
    iput v7, v8, Landroidx/constraintlayout/widget/ConstraintSet$Layout;->circleAngle:F

    .line 206
    .line 207
    invoke-interface {v4}, Ljava/util/List;->size()I

    .line 208
    .line 209
    .line 210
    move-result v8

    .line 211
    int-to-float v8, v8

    .line 212
    const/high16 v9, 0x43b40000    # 360.0f

    .line 213
    .line 214
    div-float/2addr v9, v8

    .line 215
    add-float/2addr v7, v9

    .line 216
    goto :goto_3

    .line 217
    :cond_8
    invoke-virtual {v0, p0}, Landroidx/constraintlayout/widget/ConstraintSet;->applyToInternal(Landroidx/constraintlayout/widget/ConstraintLayout;)V

    .line 218
    .line 219
    .line 220
    const/4 v0, 0x0

    .line 221
    invoke-virtual {p0, v0}, Landroidx/constraintlayout/widget/ConstraintLayout;->setConstraintSet(Landroidx/constraintlayout/widget/ConstraintSet;)V

    .line 222
    .line 223
    .line 224
    invoke-virtual {p0}, Landroidx/constraintlayout/widget/ConstraintLayout;->requestLayout()V

    .line 225
    .line 226
    .line 227
    const/4 v0, 0x0

    .line 228
    :goto_4
    iget-object v1, p0, Lcom/google/android/material/timepicker/ClockFaceView;->textViewPool:Landroid/util/SparseArray;

    .line 229
    .line 230
    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    .line 231
    .line 232
    .line 233
    move-result v3

    .line 234
    if-ge v0, v3, :cond_9

    .line 235
    .line 236
    invoke-virtual {v1, v0}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    .line 237
    .line 238
    .line 239
    move-result-object v1

    .line 240
    check-cast v1, Landroid/widget/TextView;

    .line 241
    .line 242
    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 243
    .line 244
    .line 245
    add-int/lit8 v0, v0, 0x1

    .line 246
    .line 247
    goto :goto_4

    .line 248
    :cond_9
    return-void
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
