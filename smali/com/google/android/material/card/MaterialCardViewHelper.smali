.class public final Lcom/google/android/material/card/MaterialCardViewHelper;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final CHECKED_ICON_NONE:Landroid/graphics/drawable/ColorDrawable;

.field public static final COS_45:D


# instance fields
.field public final bgDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field public checkable:Z

.field public checkedAnimationProgress:F

.field public checkedIcon:Landroid/graphics/drawable/Drawable;

.field public checkedIconGravity:I

.field public checkedIconMargin:I

.field public checkedIconSize:I

.field public checkedIconTint:Landroid/content/res/ColorStateList;

.field public clickableForegroundDrawable:Landroid/graphics/drawable/LayerDrawable;

.field public fgDrawable:Landroid/graphics/drawable/Drawable;

.field public final foregroundContentDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field public foregroundShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

.field public iconAnimator:Landroid/animation/ValueAnimator;

.field public final iconFadeAnimInterpolator:Landroid/animation/TimeInterpolator;

.field public final iconFadeInAnimDuration:I

.field public final iconFadeOutAnimDuration:I

.field public isBackgroundOverwritten:Z

.field public final materialCardView:Lcom/google/android/material/card/MaterialCardView;

.field public rippleColor:Landroid/content/res/ColorStateList;

.field public rippleDrawable:Landroid/graphics/drawable/RippleDrawable;

.field public shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

.field public strokeColor:Landroid/content/res/ColorStateList;

.field public strokeWidth:I

.field public final userContentPadding:Landroid/graphics/Rect;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    const-wide v0, 0x4046800000000000L    # 45.0

    .line 2
    .line 3
    .line 4
    .line 5
    .line 6
    invoke-static {v0, v1}, Ljava/lang/Math;->toRadians(D)D

    .line 7
    .line 8
    .line 9
    move-result-wide v0

    .line 10
    invoke-static {v0, v1}, Ljava/lang/Math;->cos(D)D

    .line 11
    .line 12
    .line 13
    move-result-wide v0

    .line 14
    sput-wide v0, Lcom/google/android/material/card/MaterialCardViewHelper;->COS_45:D

    .line 15
    .line 16
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 17
    .line 18
    const/16 v1, 0x1c

    .line 19
    .line 20
    if-gt v0, v1, :cond_0

    .line 21
    .line 22
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    .line 23
    .line 24
    invoke-direct {v0}, Landroid/graphics/drawable/ColorDrawable;-><init>()V

    .line 25
    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_0
    const/4 v0, 0x0

    .line 29
    :goto_0
    sput-object v0, Lcom/google/android/material/card/MaterialCardViewHelper;->CHECKED_ICON_NONE:Landroid/graphics/drawable/ColorDrawable;

    .line 30
    .line 31
    return-void
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

.method public constructor <init>(Lcom/google/android/material/card/MaterialCardView;Landroid/util/AttributeSet;)V
    .locals 6

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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
    iput-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->userContentPadding:Landroid/graphics/Rect;

    .line 10
    .line 11
    const/4 v0, 0x0

    .line 12
    iput-boolean v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->isBackgroundOverwritten:Z

    .line 13
    .line 14
    const/4 v0, 0x0

    .line 15
    iput v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedAnimationProgress:F

    .line 16
    .line 17
    iput-object p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 18
    .line 19
    new-instance v1, Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 20
    .line 21
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 22
    .line 23
    .line 24
    move-result-object v2

    .line 25
    const v3, 0x7f04036e

    .line 26
    .line 27
    .line 28
    const v4, 0x7f1504a3

    .line 29
    .line 30
    .line 31
    invoke-direct {v1, v2, p2, v3, v4}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 32
    .line 33
    .line 34
    iput-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->bgDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 35
    .line 36
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 37
    .line 38
    .line 39
    move-result-object v2

    .line 40
    invoke-virtual {v1, v2}, Lcom/google/android/material/shape/MaterialShapeDrawable;->initializeElevationOverlay(Landroid/content/Context;)V

    .line 41
    .line 42
    .line 43
    invoke-virtual {v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShadowColor()V

    .line 44
    .line 45
    .line 46
    iget-object v1, v1, Lcom/google/android/material/shape/MaterialShapeDrawable;->drawableState:Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;

    .line 47
    .line 48
    iget-object v1, v1, Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 49
    .line 50
    invoke-virtual {v1}, Lcom/google/android/material/shape/ShapeAppearanceModel;->toBuilder()Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;

    .line 51
    .line 52
    .line 53
    move-result-object v1

    .line 54
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 55
    .line 56
    .line 57
    move-result-object v2

    .line 58
    sget-object v4, Landroidx/cardview/R$styleable;->CardView:[I

    .line 59
    .line 60
    const v5, 0x7f150131

    .line 61
    .line 62
    .line 63
    invoke-virtual {v2, p2, v4, v3, v5}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    .line 64
    .line 65
    .line 66
    move-result-object p2

    .line 67
    const/4 v2, 0x3

    .line 68
    invoke-virtual {p2, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    .line 69
    .line 70
    .line 71
    move-result v3

    .line 72
    if-eqz v3, :cond_0

    .line 73
    .line 74
    invoke-virtual {p2, v2, v0}, Landroid/content/res/TypedArray;->getDimension(IF)F

    .line 75
    .line 76
    .line 77
    move-result v0

    .line 78
    invoke-virtual {v1, v0}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->setAllCornerSizes(F)V

    .line 79
    .line 80
    .line 81
    :cond_0
    new-instance v0, Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 82
    .line 83
    invoke-direct {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>()V

    .line 84
    .line 85
    .line 86
    iput-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->foregroundContentDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 87
    .line 88
    invoke-virtual {v1}, Lcom/google/android/material/shape/ShapeAppearanceModel$Builder;->build()Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 89
    .line 90
    .line 91
    move-result-object v0

    .line 92
    invoke-virtual {p0, v0}, Lcom/google/android/material/card/MaterialCardViewHelper;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    .line 93
    .line 94
    .line 95
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 96
    .line 97
    .line 98
    move-result-object v0

    .line 99
    const v1, 0x7f0403bd

    .line 100
    .line 101
    .line 102
    sget-object v2, Lcom/google/android/material/animation/AnimationUtils;->LINEAR_INTERPOLATOR:Landroid/view/animation/LinearInterpolator;

    .line 103
    .line 104
    invoke-static {v0, v1, v2}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeInterpolator(Landroid/content/Context;ILandroid/animation/TimeInterpolator;)Landroid/animation/TimeInterpolator;

    .line 105
    .line 106
    .line 107
    move-result-object v0

    .line 108
    iput-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconFadeAnimInterpolator:Landroid/animation/TimeInterpolator;

    .line 109
    .line 110
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 111
    .line 112
    .line 113
    move-result-object v0

    .line 114
    const v1, 0x7f0403b3

    .line 115
    .line 116
    .line 117
    const/16 v2, 0x12c

    .line 118
    .line 119
    invoke-static {v0, v1, v2}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeDuration(Landroid/content/Context;II)I

    .line 120
    .line 121
    .line 122
    move-result v0

    .line 123
    iput v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconFadeInAnimDuration:I

    .line 124
    .line 125
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 126
    .line 127
    .line 128
    move-result-object p1

    .line 129
    const v0, 0x7f0403b2

    .line 130
    .line 131
    .line 132
    invoke-static {p1, v0, v2}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeDuration(Landroid/content/Context;II)I

    .line 133
    .line 134
    .line 135
    move-result p1

    .line 136
    iput p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconFadeOutAnimDuration:I

    .line 137
    .line 138
    invoke-virtual {p2}, Landroid/content/res/TypedArray;->recycle()V

    .line 139
    .line 140
    .line 141
    return-void
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

.method public static calculateCornerPaddingForCornerTreatment(Lkotlin/LazyKt__LazyJVMKt;F)F
    .locals 4

    .line 1
    instance-of v0, p0, Lcom/google/android/material/shape/RoundedCornerTreatment;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    .line 6
    .line 7
    sget-wide v2, Lcom/google/android/material/card/MaterialCardViewHelper;->COS_45:D

    .line 8
    .line 9
    sub-double/2addr v0, v2

    .line 10
    float-to-double p0, p1

    .line 11
    mul-double v0, v0, p0

    .line 12
    .line 13
    double-to-float p0, v0

    .line 14
    return p0

    .line 15
    :cond_0
    instance-of p0, p0, Lcom/google/android/material/shape/CutCornerTreatment;

    .line 16
    .line 17
    if-eqz p0, :cond_1

    .line 18
    .line 19
    const/high16 p0, 0x40000000    # 2.0f

    .line 20
    .line 21
    div-float/2addr p1, p0

    .line 22
    return p1

    .line 23
    :cond_1
    const/4 p0, 0x0

    .line 24
    return p0
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


# virtual methods
.method public final calculateActualCornerPadding()F
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 2
    .line 3
    iget-object v0, v0, Lcom/google/android/material/shape/ShapeAppearanceModel;->topLeftCorner:Lkotlin/LazyKt__LazyJVMKt;

    .line 4
    .line 5
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->bgDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 6
    .line 7
    invoke-virtual {v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getTopLeftCornerResolvedSize()F

    .line 8
    .line 9
    .line 10
    move-result v2

    .line 11
    invoke-static {v0, v2}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateCornerPaddingForCornerTreatment(Lkotlin/LazyKt__LazyJVMKt;F)F

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    iget-object v2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 16
    .line 17
    iget-object v2, v2, Lcom/google/android/material/shape/ShapeAppearanceModel;->topRightCorner:Lkotlin/LazyKt__LazyJVMKt;

    .line 18
    .line 19
    iget-object v3, v1, Lcom/google/android/material/shape/MaterialShapeDrawable;->springAnimatedCornerSizes:[F

    .line 20
    .line 21
    if-eqz v3, :cond_0

    .line 22
    .line 23
    const/4 v4, 0x0

    .line 24
    aget v3, v3, v4

    .line 25
    .line 26
    goto :goto_0

    .line 27
    :cond_0
    iget-object v3, v1, Lcom/google/android/material/shape/MaterialShapeDrawable;->drawableState:Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;

    .line 28
    .line 29
    iget-object v3, v3, Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 30
    .line 31
    iget-object v3, v3, Lcom/google/android/material/shape/ShapeAppearanceModel;->topRightCornerSize:Lcom/google/android/material/shape/CornerSize;

    .line 32
    .line 33
    invoke-virtual {v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getBoundsAsRectF()Landroid/graphics/RectF;

    .line 34
    .line 35
    .line 36
    move-result-object v4

    .line 37
    invoke-interface {v3, v4}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    .line 38
    .line 39
    .line 40
    move-result v3

    .line 41
    :goto_0
    invoke-static {v2, v3}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateCornerPaddingForCornerTreatment(Lkotlin/LazyKt__LazyJVMKt;F)F

    .line 42
    .line 43
    .line 44
    move-result v2

    .line 45
    invoke-static {v0, v2}, Ljava/lang/Math;->max(FF)F

    .line 46
    .line 47
    .line 48
    move-result v0

    .line 49
    iget-object v2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 50
    .line 51
    iget-object v2, v2, Lcom/google/android/material/shape/ShapeAppearanceModel;->bottomRightCorner:Lkotlin/LazyKt__LazyJVMKt;

    .line 52
    .line 53
    iget-object v3, v1, Lcom/google/android/material/shape/MaterialShapeDrawable;->springAnimatedCornerSizes:[F

    .line 54
    .line 55
    if-eqz v3, :cond_1

    .line 56
    .line 57
    const/4 v4, 0x1

    .line 58
    aget v3, v3, v4

    .line 59
    .line 60
    goto :goto_1

    .line 61
    :cond_1
    iget-object v3, v1, Lcom/google/android/material/shape/MaterialShapeDrawable;->drawableState:Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;

    .line 62
    .line 63
    iget-object v3, v3, Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 64
    .line 65
    iget-object v3, v3, Lcom/google/android/material/shape/ShapeAppearanceModel;->bottomRightCornerSize:Lcom/google/android/material/shape/CornerSize;

    .line 66
    .line 67
    invoke-virtual {v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getBoundsAsRectF()Landroid/graphics/RectF;

    .line 68
    .line 69
    .line 70
    move-result-object v4

    .line 71
    invoke-interface {v3, v4}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    .line 72
    .line 73
    .line 74
    move-result v3

    .line 75
    :goto_1
    invoke-static {v2, v3}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateCornerPaddingForCornerTreatment(Lkotlin/LazyKt__LazyJVMKt;F)F

    .line 76
    .line 77
    .line 78
    move-result v2

    .line 79
    iget-object v3, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 80
    .line 81
    iget-object v3, v3, Lcom/google/android/material/shape/ShapeAppearanceModel;->bottomLeftCorner:Lkotlin/LazyKt__LazyJVMKt;

    .line 82
    .line 83
    iget-object v4, v1, Lcom/google/android/material/shape/MaterialShapeDrawable;->springAnimatedCornerSizes:[F

    .line 84
    .line 85
    if-eqz v4, :cond_2

    .line 86
    .line 87
    const/4 v1, 0x2

    .line 88
    aget v1, v4, v1

    .line 89
    .line 90
    goto :goto_2

    .line 91
    :cond_2
    iget-object v4, v1, Lcom/google/android/material/shape/MaterialShapeDrawable;->drawableState:Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;

    .line 92
    .line 93
    iget-object v4, v4, Lcom/google/android/material/shape/MaterialShapeDrawable$MaterialShapeDrawableState;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 94
    .line 95
    iget-object v4, v4, Lcom/google/android/material/shape/ShapeAppearanceModel;->bottomLeftCornerSize:Lcom/google/android/material/shape/CornerSize;

    .line 96
    .line 97
    invoke-virtual {v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->getBoundsAsRectF()Landroid/graphics/RectF;

    .line 98
    .line 99
    .line 100
    move-result-object v1

    .line 101
    invoke-interface {v4, v1}, Lcom/google/android/material/shape/CornerSize;->getCornerSize(Landroid/graphics/RectF;)F

    .line 102
    .line 103
    .line 104
    move-result v1

    .line 105
    :goto_2
    invoke-static {v3, v1}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateCornerPaddingForCornerTreatment(Lkotlin/LazyKt__LazyJVMKt;F)F

    .line 106
    .line 107
    .line 108
    move-result v1

    .line 109
    invoke-static {v2, v1}, Ljava/lang/Math;->max(FF)F

    .line 110
    .line 111
    .line 112
    move-result v1

    .line 113
    invoke-static {v0, v1}, Ljava/lang/Math;->max(FF)F

    .line 114
    .line 115
    .line 116
    move-result v0

    .line 117
    return v0
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

.method public final getClickableForeground()Landroid/graphics/drawable/LayerDrawable;
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->rippleDrawable:Landroid/graphics/drawable/RippleDrawable;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 6
    .line 7
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 8
    .line 9
    invoke-direct {v0, v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;-><init>(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    .line 10
    .line 11
    .line 12
    iput-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->foregroundShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 13
    .line 14
    new-instance v0, Landroid/graphics/drawable/RippleDrawable;

    .line 15
    .line 16
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->rippleColor:Landroid/content/res/ColorStateList;

    .line 17
    .line 18
    const/4 v2, 0x0

    .line 19
    iget-object v3, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->foregroundShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 20
    .line 21
    invoke-direct {v0, v1, v2, v3}, Landroid/graphics/drawable/RippleDrawable;-><init>(Landroid/content/res/ColorStateList;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 22
    .line 23
    .line 24
    iput-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->rippleDrawable:Landroid/graphics/drawable/RippleDrawable;

    .line 25
    .line 26
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->clickableForegroundDrawable:Landroid/graphics/drawable/LayerDrawable;

    .line 27
    .line 28
    if-nez v0, :cond_1

    .line 29
    .line 30
    new-instance v0, Landroid/graphics/drawable/LayerDrawable;

    .line 31
    .line 32
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->rippleDrawable:Landroid/graphics/drawable/RippleDrawable;

    .line 33
    .line 34
    iget-object v2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIcon:Landroid/graphics/drawable/Drawable;

    .line 35
    .line 36
    const/4 v3, 0x3

    .line 37
    new-array v3, v3, [Landroid/graphics/drawable/Drawable;

    .line 38
    .line 39
    const/4 v4, 0x0

    .line 40
    aput-object v1, v3, v4

    .line 41
    .line 42
    const/4 v1, 0x1

    .line 43
    iget-object v4, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->foregroundContentDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 44
    .line 45
    aput-object v4, v3, v1

    .line 46
    .line 47
    const/4 v1, 0x2

    .line 48
    aput-object v2, v3, v1

    .line 49
    .line 50
    invoke-direct {v0, v3}, Landroid/graphics/drawable/LayerDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    .line 51
    .line 52
    .line 53
    iput-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->clickableForegroundDrawable:Landroid/graphics/drawable/LayerDrawable;

    .line 54
    .line 55
    const v2, 0x7f0a0211

    .line 56
    .line 57
    .line 58
    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/LayerDrawable;->setId(II)V

    .line 59
    .line 60
    .line 61
    :cond_1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->clickableForegroundDrawable:Landroid/graphics/drawable/LayerDrawable;

    .line 62
    .line 63
    return-object v0
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

.method public final insetDrawable(Landroid/graphics/drawable/Drawable;)Lcom/google/android/material/card/MaterialCardViewHelper$1;
    .locals 8

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getUseCompatPadding()Z

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    if-eqz v1, :cond_2

    .line 8
    .line 9
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getMaxCardElevation()F

    .line 10
    .line 11
    .line 12
    move-result v1

    .line 13
    const/high16 v2, 0x3fc00000    # 1.5f

    .line 14
    .line 15
    mul-float v1, v1, v2

    .line 16
    .line 17
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->shouldAddCornerPaddingOutsideCardBackground()Z

    .line 18
    .line 19
    .line 20
    move-result v2

    .line 21
    const/4 v3, 0x0

    .line 22
    if-eqz v2, :cond_0

    .line 23
    .line 24
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateActualCornerPadding()F

    .line 25
    .line 26
    .line 27
    move-result v2

    .line 28
    goto :goto_0

    .line 29
    :cond_0
    const/4 v2, 0x0

    .line 30
    :goto_0
    add-float/2addr v1, v2

    .line 31
    float-to-double v1, v1

    .line 32
    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    .line 33
    .line 34
    .line 35
    move-result-wide v1

    .line 36
    double-to-int v1, v1

    .line 37
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getMaxCardElevation()F

    .line 38
    .line 39
    .line 40
    move-result v0

    .line 41
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->shouldAddCornerPaddingOutsideCardBackground()Z

    .line 42
    .line 43
    .line 44
    move-result v2

    .line 45
    if-eqz v2, :cond_1

    .line 46
    .line 47
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateActualCornerPadding()F

    .line 48
    .line 49
    .line 50
    move-result v3

    .line 51
    :cond_1
    add-float/2addr v0, v3

    .line 52
    float-to-double v2, v0

    .line 53
    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    .line 54
    .line 55
    .line 56
    move-result-wide v2

    .line 57
    double-to-int v0, v2

    .line 58
    move v4, v0

    .line 59
    move v5, v1

    .line 60
    goto :goto_1

    .line 61
    :cond_2
    const/4 v1, 0x0

    .line 62
    const/4 v4, 0x0

    .line 63
    const/4 v5, 0x0

    .line 64
    :goto_1
    new-instance v2, Lcom/google/android/material/card/MaterialCardViewHelper$1;

    .line 65
    .line 66
    move v6, v4

    .line 67
    move v7, v5

    .line 68
    move-object v3, p1

    .line 69
    invoke-direct/range {v2 .. v7}, Landroid/graphics/drawable/InsetDrawable;-><init>(Landroid/graphics/drawable/Drawable;IIII)V

    .line 70
    .line 71
    .line 72
    return-object v2
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

.method public final recalculateCheckedIconPosition(II)V
    .locals 14

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->clickableForegroundDrawable:Landroid/graphics/drawable/LayerDrawable;

    .line 2
    .line 3
    if-eqz v0, :cond_8

    .line 4
    .line 5
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 6
    .line 7
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getUseCompatPadding()Z

    .line 8
    .line 9
    .line 10
    move-result v1

    .line 11
    if-eqz v1, :cond_2

    .line 12
    .line 13
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getMaxCardElevation()F

    .line 14
    .line 15
    .line 16
    move-result v1

    .line 17
    const/high16 v2, 0x3fc00000    # 1.5f

    .line 18
    .line 19
    mul-float v1, v1, v2

    .line 20
    .line 21
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->shouldAddCornerPaddingOutsideCardBackground()Z

    .line 22
    .line 23
    .line 24
    move-result v2

    .line 25
    const/4 v3, 0x0

    .line 26
    if-eqz v2, :cond_0

    .line 27
    .line 28
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateActualCornerPadding()F

    .line 29
    .line 30
    .line 31
    move-result v2

    .line 32
    goto :goto_0

    .line 33
    :cond_0
    const/4 v2, 0x0

    .line 34
    :goto_0
    add-float/2addr v1, v2

    .line 35
    const/high16 v2, 0x40000000    # 2.0f

    .line 36
    .line 37
    mul-float v1, v1, v2

    .line 38
    .line 39
    float-to-double v4, v1

    .line 40
    invoke-static {v4, v5}, Ljava/lang/Math;->ceil(D)D

    .line 41
    .line 42
    .line 43
    move-result-wide v4

    .line 44
    double-to-int v1, v4

    .line 45
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getMaxCardElevation()F

    .line 46
    .line 47
    .line 48
    move-result v4

    .line 49
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->shouldAddCornerPaddingOutsideCardBackground()Z

    .line 50
    .line 51
    .line 52
    move-result v5

    .line 53
    if-eqz v5, :cond_1

    .line 54
    .line 55
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateActualCornerPadding()F

    .line 56
    .line 57
    .line 58
    move-result v3

    .line 59
    :cond_1
    add-float/2addr v4, v3

    .line 60
    mul-float v4, v4, v2

    .line 61
    .line 62
    float-to-double v2, v4

    .line 63
    invoke-static {v2, v3}, Ljava/lang/Math;->ceil(D)D

    .line 64
    .line 65
    .line 66
    move-result-wide v2

    .line 67
    double-to-int v2, v2

    .line 68
    goto :goto_1

    .line 69
    :cond_2
    const/4 v1, 0x0

    .line 70
    const/4 v2, 0x0

    .line 71
    :goto_1
    iget v3, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconGravity:I

    .line 72
    .line 73
    const v4, 0x800005

    .line 74
    .line 75
    .line 76
    and-int v5, v3, v4

    .line 77
    .line 78
    if-ne v5, v4, :cond_3

    .line 79
    .line 80
    iget v5, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconMargin:I

    .line 81
    .line 82
    sub-int v5, p1, v5

    .line 83
    .line 84
    iget v6, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconSize:I

    .line 85
    .line 86
    sub-int/2addr v5, v6

    .line 87
    sub-int/2addr v5, v2

    .line 88
    goto :goto_2

    .line 89
    :cond_3
    iget v5, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconMargin:I

    .line 90
    .line 91
    :goto_2
    and-int/lit8 v6, v3, 0x50

    .line 92
    .line 93
    const/16 v7, 0x50

    .line 94
    .line 95
    if-ne v6, v7, :cond_4

    .line 96
    .line 97
    iget v6, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconMargin:I

    .line 98
    .line 99
    :goto_3
    move v13, v6

    .line 100
    goto :goto_4

    .line 101
    :cond_4
    iget v6, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconMargin:I

    .line 102
    .line 103
    sub-int v6, p2, v6

    .line 104
    .line 105
    iget v8, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconSize:I

    .line 106
    .line 107
    sub-int/2addr v6, v8

    .line 108
    sub-int/2addr v6, v1

    .line 109
    goto :goto_3

    .line 110
    :goto_4
    and-int v6, v3, v4

    .line 111
    .line 112
    if-ne v6, v4, :cond_5

    .line 113
    .line 114
    iget p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconMargin:I

    .line 115
    .line 116
    goto :goto_5

    .line 117
    :cond_5
    iget v4, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconMargin:I

    .line 118
    .line 119
    sub-int/2addr p1, v4

    .line 120
    iget v4, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconSize:I

    .line 121
    .line 122
    sub-int/2addr p1, v4

    .line 123
    sub-int/2addr p1, v2

    .line 124
    :goto_5
    and-int/lit8 v2, v3, 0x50

    .line 125
    .line 126
    if-ne v2, v7, :cond_6

    .line 127
    .line 128
    iget v2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconMargin:I

    .line 129
    .line 130
    sub-int v2, p2, v2

    .line 131
    .line 132
    iget v3, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconSize:I

    .line 133
    .line 134
    sub-int/2addr v2, v3

    .line 135
    sub-int/2addr v2, v1

    .line 136
    :goto_6
    move v11, v2

    .line 137
    goto :goto_7

    .line 138
    :cond_6
    iget v2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconMargin:I

    .line 139
    .line 140
    goto :goto_6

    .line 141
    :goto_7
    invoke-virtual {v0}, Landroid/view/View;->getLayoutDirection()I

    .line 142
    .line 143
    .line 144
    move-result v0

    .line 145
    const/4 v1, 0x1

    .line 146
    if-ne v0, v1, :cond_7

    .line 147
    .line 148
    move v10, p1

    .line 149
    move v12, v5

    .line 150
    goto :goto_8

    .line 151
    :cond_7
    move v12, p1

    .line 152
    move v10, v5

    .line 153
    :goto_8
    iget-object v8, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->clickableForegroundDrawable:Landroid/graphics/drawable/LayerDrawable;

    .line 154
    .line 155
    const/4 v9, 0x2

    .line 156
    invoke-virtual/range {v8 .. v13}, Landroid/graphics/drawable/LayerDrawable;->setLayerInset(IIIII)V

    .line 157
    .line 158
    .line 159
    :cond_8
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

.method public final setChecked(ZZ)V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIcon:Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    if-eqz v0, :cond_7

    .line 4
    .line 5
    const/4 v1, 0x0

    .line 6
    const/4 v2, 0x0

    .line 7
    const/high16 v3, 0x3f800000    # 1.0f

    .line 8
    .line 9
    if-eqz p2, :cond_4

    .line 10
    .line 11
    if-eqz p1, :cond_0

    .line 12
    .line 13
    const/high16 v2, 0x3f800000    # 1.0f

    .line 14
    .line 15
    :cond_0
    if-eqz p1, :cond_1

    .line 16
    .line 17
    iget p2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedAnimationProgress:F

    .line 18
    .line 19
    sub-float/2addr v3, p2

    .line 20
    goto :goto_0

    .line 21
    :cond_1
    iget v3, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedAnimationProgress:F

    .line 22
    .line 23
    :goto_0
    iget-object p2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconAnimator:Landroid/animation/ValueAnimator;

    .line 24
    .line 25
    if-eqz p2, :cond_2

    .line 26
    .line 27
    invoke-virtual {p2}, Landroid/animation/ValueAnimator;->cancel()V

    .line 28
    .line 29
    .line 30
    const/4 p2, 0x0

    .line 31
    iput-object p2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconAnimator:Landroid/animation/ValueAnimator;

    .line 32
    .line 33
    :cond_2
    iget p2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedAnimationProgress:F

    .line 34
    .line 35
    const/4 v0, 0x2

    .line 36
    new-array v0, v0, [F

    .line 37
    .line 38
    aput p2, v0, v1

    .line 39
    .line 40
    const/4 p2, 0x1

    .line 41
    aput v2, v0, p2

    .line 42
    .line 43
    invoke-static {v0}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    iput-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconAnimator:Landroid/animation/ValueAnimator;

    .line 48
    .line 49
    new-instance v1, Landroidx/core/view/ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;

    .line 50
    .line 51
    invoke-direct {v1, p2, p0}, Landroidx/core/view/ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 52
    .line 53
    .line 54
    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    .line 55
    .line 56
    .line 57
    iget-object p2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconAnimator:Landroid/animation/ValueAnimator;

    .line 58
    .line 59
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconFadeAnimInterpolator:Landroid/animation/TimeInterpolator;

    .line 60
    .line 61
    invoke-virtual {p2, v0}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 62
    .line 63
    .line 64
    iget-object p2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconAnimator:Landroid/animation/ValueAnimator;

    .line 65
    .line 66
    if-eqz p1, :cond_3

    .line 67
    .line 68
    iget p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconFadeInAnimDuration:I

    .line 69
    .line 70
    :goto_1
    int-to-float p1, p1

    .line 71
    mul-float p1, p1, v3

    .line 72
    .line 73
    float-to-long v0, p1

    .line 74
    goto :goto_2

    .line 75
    :cond_3
    iget p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconFadeOutAnimDuration:I

    .line 76
    .line 77
    goto :goto_1

    .line 78
    :goto_2
    invoke-virtual {p2, v0, v1}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    .line 79
    .line 80
    .line 81
    iget-object p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->iconAnimator:Landroid/animation/ValueAnimator;

    .line 82
    .line 83
    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->start()V

    .line 84
    .line 85
    .line 86
    return-void

    .line 87
    :cond_4
    if-eqz p1, :cond_5

    .line 88
    .line 89
    const/16 v1, 0xff

    .line 90
    .line 91
    :cond_5
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 92
    .line 93
    .line 94
    if-eqz p1, :cond_6

    .line 95
    .line 96
    const/high16 v2, 0x3f800000    # 1.0f

    .line 97
    .line 98
    :cond_6
    iput v2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedAnimationProgress:F

    .line 99
    .line 100
    :cond_7
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
.end method

.method public final setCheckedIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 2

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    invoke-static {p1}, Landroidx/core/os/BundleKt;->wrap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    iput-object p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIcon:Landroid/graphics/drawable/Drawable;

    .line 12
    .line 13
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIconTint:Landroid/content/res/ColorStateList;

    .line 14
    .line 15
    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->setTintList(Landroid/content/res/ColorStateList;)V

    .line 16
    .line 17
    .line 18
    iget-object p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 19
    .line 20
    iget-boolean p1, p1, Lcom/google/android/material/card/MaterialCardView;->checked:Z

    .line 21
    .line 22
    const/4 v0, 0x0

    .line 23
    invoke-virtual {p0, p1, v0}, Lcom/google/android/material/card/MaterialCardViewHelper;->setChecked(ZZ)V

    .line 24
    .line 25
    .line 26
    goto :goto_0

    .line 27
    :cond_0
    sget-object p1, Lcom/google/android/material/card/MaterialCardViewHelper;->CHECKED_ICON_NONE:Landroid/graphics/drawable/ColorDrawable;

    .line 28
    .line 29
    iput-object p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIcon:Landroid/graphics/drawable/Drawable;

    .line 30
    .line 31
    :goto_0
    iget-object p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->clickableForegroundDrawable:Landroid/graphics/drawable/LayerDrawable;

    .line 32
    .line 33
    if-eqz p1, :cond_1

    .line 34
    .line 35
    const v0, 0x7f0a0211

    .line 36
    .line 37
    .line 38
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->checkedIcon:Landroid/graphics/drawable/Drawable;

    .line 39
    .line 40
    invoke-virtual {p1, v0, v1}, Landroid/graphics/drawable/LayerDrawable;->setDrawableByLayerId(ILandroid/graphics/drawable/Drawable;)Z

    .line 41
    .line 42
    .line 43
    :cond_1
    return-void
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

.method public final setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V
    .locals 2

    .line 1
    iput-object p1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->shapeAppearanceModel:Lcom/google/android/material/shape/ShapeAppearanceModel;

    .line 2
    .line 3
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->bgDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 4
    .line 5
    invoke-virtual {v0, p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0}, Lcom/google/android/material/shape/MaterialShapeDrawable;->isRoundRect()Z

    .line 9
    .line 10
    .line 11
    move-result v1

    .line 12
    xor-int/lit8 v1, v1, 0x1

    .line 13
    .line 14
    iput-boolean v1, v0, Lcom/google/android/material/shape/MaterialShapeDrawable;->shadowBitmapDrawingEnable:Z

    .line 15
    .line 16
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->foregroundContentDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 17
    .line 18
    if-eqz v0, :cond_0

    .line 19
    .line 20
    invoke-virtual {v0, p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    .line 21
    .line 22
    .line 23
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->foregroundShapeDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 24
    .line 25
    if-eqz v0, :cond_1

    .line 26
    .line 27
    invoke-virtual {v0, p1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->setShapeAppearanceModel(Lcom/google/android/material/shape/ShapeAppearanceModel;)V

    .line 28
    .line 29
    .line 30
    :cond_1
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

.method public final shouldAddCornerPaddingOutsideCardBackground()Z
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getPreventCornerOverlap()Z

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    if-eqz v1, :cond_0

    .line 8
    .line 9
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->bgDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 10
    .line 11
    invoke-virtual {v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->isRoundRect()Z

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    if-eqz v1, :cond_0

    .line 16
    .line 17
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getUseCompatPadding()Z

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    if-eqz v0, :cond_0

    .line 22
    .line 23
    const/4 v0, 0x1

    .line 24
    return v0

    .line 25
    :cond_0
    const/4 v0, 0x0

    .line 26
    return v0
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

.method public final shouldUseClickableForeground()Z
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/view/View;->isClickable()Z

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    if-eqz v1, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    :goto_0
    invoke-virtual {v0}, Landroid/view/View;->isDuplicateParentStateEnabled()Z

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    if-eqz v1, :cond_1

    .line 16
    .line 17
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    instance-of v1, v1, Landroid/view/View;

    .line 22
    .line 23
    if-eqz v1, :cond_1

    .line 24
    .line 25
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    check-cast v0, Landroid/view/View;

    .line 30
    .line 31
    goto :goto_0

    .line 32
    :cond_1
    invoke-virtual {v0}, Landroid/view/View;->isClickable()Z

    .line 33
    .line 34
    .line 35
    move-result v0

    .line 36
    return v0
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

.method public final updateClickable()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->fgDrawable:Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->shouldUseClickableForeground()Z

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    if-eqz v1, :cond_0

    .line 8
    .line 9
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->getClickableForeground()Landroid/graphics/drawable/LayerDrawable;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    goto :goto_0

    .line 14
    :cond_0
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->foregroundContentDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 15
    .line 16
    :goto_0
    iput-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->fgDrawable:Landroid/graphics/drawable/Drawable;

    .line 17
    .line 18
    if-eq v0, v1, :cond_2

    .line 19
    .line 20
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 21
    .line 22
    const/16 v2, 0x17

    .line 23
    .line 24
    iget-object v3, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 25
    .line 26
    if-lt v0, v2, :cond_1

    .line 27
    .line 28
    invoke-virtual {v3}, Landroid/widget/FrameLayout;->getForeground()Landroid/graphics/drawable/Drawable;

    .line 29
    .line 30
    .line 31
    move-result-object v0

    .line 32
    instance-of v0, v0, Landroid/graphics/drawable/InsetDrawable;

    .line 33
    .line 34
    if-eqz v0, :cond_1

    .line 35
    .line 36
    invoke-virtual {v3}, Landroid/widget/FrameLayout;->getForeground()Landroid/graphics/drawable/Drawable;

    .line 37
    .line 38
    .line 39
    move-result-object v0

    .line 40
    check-cast v0, Landroid/graphics/drawable/InsetDrawable;

    .line 41
    .line 42
    invoke-virtual {v0, v1}, Landroid/graphics/drawable/InsetDrawable;->setDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 43
    .line 44
    .line 45
    return-void

    .line 46
    :cond_1
    invoke-virtual {p0, v1}, Lcom/google/android/material/card/MaterialCardViewHelper;->insetDrawable(Landroid/graphics/drawable/Drawable;)Lcom/google/android/material/card/MaterialCardViewHelper$1;

    .line 47
    .line 48
    .line 49
    move-result-object v0

    .line 50
    invoke-virtual {v3, v0}, Landroid/widget/FrameLayout;->setForeground(Landroid/graphics/drawable/Drawable;)V

    .line 51
    .line 52
    .line 53
    :cond_2
    return-void
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method public final updateContentPadding()V
    .locals 6

    .line 1
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getPreventCornerOverlap()Z

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    const/4 v2, 0x0

    .line 8
    if-eqz v1, :cond_0

    .line 9
    .line 10
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->bgDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 11
    .line 12
    invoke-virtual {v1}, Lcom/google/android/material/shape/MaterialShapeDrawable;->isRoundRect()Z

    .line 13
    .line 14
    .line 15
    move-result v1

    .line 16
    if-nez v1, :cond_0

    .line 17
    .line 18
    goto :goto_0

    .line 19
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->shouldAddCornerPaddingOutsideCardBackground()Z

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    if-eqz v1, :cond_1

    .line 24
    .line 25
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/material/card/MaterialCardViewHelper;->calculateActualCornerPadding()F

    .line 26
    .line 27
    .line 28
    move-result v1

    .line 29
    goto :goto_1

    .line 30
    :cond_1
    const/4 v1, 0x0

    .line 31
    :goto_1
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getPreventCornerOverlap()Z

    .line 32
    .line 33
    .line 34
    move-result v3

    .line 35
    if-eqz v3, :cond_2

    .line 36
    .line 37
    invoke-virtual {v0}, Landroidx/cardview/widget/CardView;->getUseCompatPadding()Z

    .line 38
    .line 39
    .line 40
    move-result v3

    .line 41
    if-eqz v3, :cond_2

    .line 42
    .line 43
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    .line 44
    .line 45
    sget-wide v4, Lcom/google/android/material/card/MaterialCardViewHelper;->COS_45:D

    .line 46
    .line 47
    sub-double/2addr v2, v4

    .line 48
    invoke-virtual {v0}, Lcom/google/android/material/card/MaterialCardView;->getCardViewRadius()F

    .line 49
    .line 50
    .line 51
    move-result v4

    .line 52
    float-to-double v4, v4

    .line 53
    mul-double v2, v2, v4

    .line 54
    .line 55
    double-to-float v2, v2

    .line 56
    :cond_2
    sub-float/2addr v1, v2

    .line 57
    float-to-int v1, v1

    .line 58
    iget-object v2, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->userContentPadding:Landroid/graphics/Rect;

    .line 59
    .line 60
    iget v3, v2, Landroid/graphics/Rect;->left:I

    .line 61
    .line 62
    add-int/2addr v3, v1

    .line 63
    iget v4, v2, Landroid/graphics/Rect;->top:I

    .line 64
    .line 65
    add-int/2addr v4, v1

    .line 66
    iget v5, v2, Landroid/graphics/Rect;->right:I

    .line 67
    .line 68
    add-int/2addr v5, v1

    .line 69
    iget v2, v2, Landroid/graphics/Rect;->bottom:I

    .line 70
    .line 71
    add-int/2addr v2, v1

    .line 72
    iget-object v1, v0, Landroidx/cardview/widget/CardView;->mContentPadding:Landroid/graphics/Rect;

    .line 73
    .line 74
    invoke-virtual {v1, v3, v4, v5, v2}, Landroid/graphics/Rect;->set(IIII)V

    .line 75
    .line 76
    .line 77
    iget-object v0, v0, Landroidx/cardview/widget/CardView;->mCardViewDelegate:Lcom/android/billingclient/api/zzcl;

    .line 78
    .line 79
    iget-object v1, v0, Lcom/android/billingclient/api/zzcl;->zzc:Ljava/lang/Object;

    .line 80
    .line 81
    check-cast v1, Landroidx/cardview/widget/CardView;

    .line 82
    .line 83
    invoke-virtual {v1}, Landroidx/cardview/widget/CardView;->getUseCompatPadding()Z

    .line 84
    .line 85
    .line 86
    move-result v2

    .line 87
    if-nez v2, :cond_3

    .line 88
    .line 89
    const/4 v1, 0x0

    .line 90
    invoke-virtual {v0, v1, v1, v1, v1}, Lcom/android/billingclient/api/zzcl;->setShadowPadding(IIII)V

    .line 91
    .line 92
    .line 93
    return-void

    .line 94
    :cond_3
    iget-object v2, v0, Lcom/android/billingclient/api/zzcl;->zzb:Ljava/lang/Object;

    .line 95
    .line 96
    check-cast v2, Landroid/graphics/drawable/Drawable;

    .line 97
    .line 98
    check-cast v2, Landroidx/cardview/widget/RoundRectDrawable;

    .line 99
    .line 100
    iget v3, v2, Landroidx/cardview/widget/RoundRectDrawable;->mPadding:F

    .line 101
    .line 102
    iget v2, v2, Landroidx/cardview/widget/RoundRectDrawable;->mRadius:F

    .line 103
    .line 104
    invoke-virtual {v1}, Landroidx/cardview/widget/CardView;->getPreventCornerOverlap()Z

    .line 105
    .line 106
    .line 107
    move-result v4

    .line 108
    invoke-static {v3, v2, v4}, Landroidx/cardview/widget/RoundRectDrawableWithShadow;->calculateHorizontalPadding(FFZ)F

    .line 109
    .line 110
    .line 111
    move-result v4

    .line 112
    float-to-double v4, v4

    .line 113
    invoke-static {v4, v5}, Ljava/lang/Math;->ceil(D)D

    .line 114
    .line 115
    .line 116
    move-result-wide v4

    .line 117
    double-to-int v4, v4

    .line 118
    invoke-virtual {v1}, Landroidx/cardview/widget/CardView;->getPreventCornerOverlap()Z

    .line 119
    .line 120
    .line 121
    move-result v1

    .line 122
    invoke-static {v3, v2, v1}, Landroidx/cardview/widget/RoundRectDrawableWithShadow;->calculateVerticalPadding(FFZ)F

    .line 123
    .line 124
    .line 125
    move-result v1

    .line 126
    float-to-double v1, v1

    .line 127
    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    .line 128
    .line 129
    .line 130
    move-result-wide v1

    .line 131
    double-to-int v1, v1

    .line 132
    invoke-virtual {v0, v4, v1, v4, v1}, Lcom/android/billingclient/api/zzcl;->setShadowPadding(IIII)V

    .line 133
    .line 134
    .line 135
    return-void
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

.method public final updateInsets()V
    .locals 2

    .line 1
    iget-boolean v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->isBackgroundOverwritten:Z

    .line 2
    .line 3
    iget-object v1, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->materialCardView:Lcom/google/android/material/card/MaterialCardView;

    .line 4
    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->bgDrawable:Lcom/google/android/material/shape/MaterialShapeDrawable;

    .line 8
    .line 9
    invoke-virtual {p0, v0}, Lcom/google/android/material/card/MaterialCardViewHelper;->insetDrawable(Landroid/graphics/drawable/Drawable;)Lcom/google/android/material/card/MaterialCardViewHelper$1;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    invoke-virtual {v1, v0}, Lcom/google/android/material/card/MaterialCardView;->setBackgroundInternal(Landroid/graphics/drawable/Drawable;)V

    .line 14
    .line 15
    .line 16
    :cond_0
    iget-object v0, p0, Lcom/google/android/material/card/MaterialCardViewHelper;->fgDrawable:Landroid/graphics/drawable/Drawable;

    .line 17
    .line 18
    invoke-virtual {p0, v0}, Lcom/google/android/material/card/MaterialCardViewHelper;->insetDrawable(Landroid/graphics/drawable/Drawable;)Lcom/google/android/material/card/MaterialCardViewHelper$1;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    invoke-virtual {v1, v0}, Landroid/widget/FrameLayout;->setForeground(Landroid/graphics/drawable/Drawable;)V

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
    .line 58
.end method
