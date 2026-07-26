.class public final synthetic Lcom/android/billingclient/api/zzam;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public zza:Ljava/lang/Object;

.field public zzb:Ljava/lang/Object;

.field public zzc:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>()V
    .locals 1

    .line 1
    const/4 v0, 0x1

    iput v0, p0, Lcom/android/billingclient/api/zzam;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/view/View;Landroidx/core/view/WindowInsetsAnimationCompat;Lcom/android/billingclient/api/zzcl;Landroid/animation/ValueAnimator;)V
    .locals 0

    const/4 p2, 0x2

    iput p2, p0, Lcom/android/billingclient/api/zzam;->$r8$classId:I

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    iput-object p3, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    iput-object p4, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    return-void
.end method

.method public synthetic constructor <init>(Lcom/android/billingclient/api/BillingClientImpl;Ljava/lang/Object;Ljava/lang/Object;I)V
    .locals 0

    .line 2
    iput p4, p0, Lcom/android/billingclient/api/zzam;->$r8$classId:I

    iput-object p1, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    iput-object p2, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    iput-object p3, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lcom/android/billingclient/api/zzce;Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V
    .locals 1

    const/4 v0, 0x4

    iput v0, p0, Lcom/android/billingclient/api/zzam;->$r8$classId:I

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    iput-object p2, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    iput-object p3, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/material/appbar/HeaderBehavior;Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;)V
    .locals 1

    const/4 v0, 0x6

    iput v0, p0, Lcom/android/billingclient/api/zzam;->$r8$classId:I

    .line 4
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    .line 5
    iput-object p2, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    .line 6
    iput-object p3, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 6

    .line 1
    iget v0, p0, Lcom/android/billingclient/api/zzam;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Landroidx/coordinatorlayout/widget/CoordinatorLayout;

    .line 9
    .line 10
    iget-object v1, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast v1, Lcom/google/android/material/appbar/HeaderBehavior;

    .line 13
    .line 14
    iget-object v2, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    .line 15
    .line 16
    check-cast v2, Landroid/view/View;

    .line 17
    .line 18
    if-eqz v2, :cond_1

    .line 19
    .line 20
    iget-object v3, v1, Lcom/google/android/material/appbar/HeaderBehavior;->scroller:Landroid/widget/OverScroller;

    .line 21
    .line 22
    if-eqz v3, :cond_1

    .line 23
    .line 24
    invoke-virtual {v3}, Landroid/widget/OverScroller;->computeScrollOffset()Z

    .line 25
    .line 26
    .line 27
    move-result v3

    .line 28
    if-eqz v3, :cond_0

    .line 29
    .line 30
    iget-object v3, v1, Lcom/google/android/material/appbar/HeaderBehavior;->scroller:Landroid/widget/OverScroller;

    .line 31
    .line 32
    invoke-virtual {v3}, Landroid/widget/OverScroller;->getCurrY()I

    .line 33
    .line 34
    .line 35
    move-result v3

    .line 36
    invoke-virtual {v1, v0, v2, v3}, Lcom/google/android/material/appbar/HeaderBehavior;->setHeaderTopBottomOffset(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)V

    .line 37
    .line 38
    .line 39
    invoke-virtual {v2, p0}, Landroid/view/View;->postOnAnimation(Ljava/lang/Runnable;)V

    .line 40
    .line 41
    .line 42
    goto :goto_0

    .line 43
    :cond_0
    check-cast v1, Lcom/google/android/material/appbar/AppBarLayout$BaseBehavior;

    .line 44
    .line 45
    check-cast v2, Lcom/google/android/material/appbar/AppBarLayout;

    .line 46
    .line 47
    invoke-virtual {v1, v0, v2}, Lcom/google/android/material/appbar/AppBarLayout$BaseBehavior;->snapToChildIfNeeded(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/appbar/AppBarLayout;)V

    .line 48
    .line 49
    .line 50
    iget-boolean v1, v2, Lcom/google/android/material/appbar/AppBarLayout;->liftOnScroll:Z

    .line 51
    .line 52
    if-eqz v1, :cond_1

    .line 53
    .line 54
    invoke-static {v0}, Lcom/google/android/material/appbar/AppBarLayout$BaseBehavior;->findFirstScrollingChild(Landroidx/coordinatorlayout/widget/CoordinatorLayout;)Landroid/view/View;

    .line 55
    .line 56
    .line 57
    move-result-object v0

    .line 58
    invoke-virtual {v2, v0}, Lcom/google/android/material/appbar/AppBarLayout;->shouldLift(Landroid/view/View;)Z

    .line 59
    .line 60
    .line 61
    move-result v0

    .line 62
    invoke-virtual {v2, v0}, Lcom/google/android/material/appbar/AppBarLayout;->setLiftedState(Z)Z

    .line 63
    .line 64
    .line 65
    :cond_1
    :goto_0
    return-void

    .line 66
    :pswitch_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    .line 67
    .line 68
    check-cast v0, Lcom/android/billingclient/api/zzce;

    .line 69
    .line 70
    iget-object v1, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    .line 71
    .line 72
    check-cast v1, Lcom/android/billingclient/api/ConsumeParams;

    .line 73
    .line 74
    iget-object v2, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    .line 75
    .line 76
    check-cast v2, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda15;

    .line 77
    .line 78
    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzce;->zzam(Lcom/android/billingclient/api/zzce;Lcom/android/billingclient/api/ConsumeParams;Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda15;)V

    .line 79
    .line 80
    .line 81
    return-void

    .line 82
    :pswitch_1
    iget-object v0, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    .line 83
    .line 84
    check-cast v0, Lcom/android/billingclient/api/zzce;

    .line 85
    .line 86
    iget-object v1, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    .line 87
    .line 88
    check-cast v1, Lcom/android/billingclient/api/ConsumeParams;

    .line 89
    .line 90
    iget-object v2, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    .line 91
    .line 92
    check-cast v2, Lcom/android/billingclient/api/ConsumeResponseListener;

    .line 93
    .line 94
    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzce;->zzan(Lcom/android/billingclient/api/zzce;Lcom/android/billingclient/api/ConsumeParams;Lcom/android/billingclient/api/ConsumeResponseListener;)V

    .line 95
    .line 96
    .line 97
    return-void

    .line 98
    :pswitch_2
    iget-object v0, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    .line 99
    .line 100
    check-cast v0, Lcom/android/billingclient/api/zzce;

    .line 101
    .line 102
    iget-object v1, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    .line 103
    .line 104
    check-cast v1, Lcom/android/billingclient/api/QueryProductDetailsParams;

    .line 105
    .line 106
    iget-object v2, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    .line 107
    .line 108
    check-cast v2, Lcom/emanuelef/remote_capture/PlayBilling;

    .line 109
    .line 110
    invoke-static {v0, v1, v2}, Lcom/android/billingclient/api/zzce;->zzao(Lcom/android/billingclient/api/zzce;Lcom/android/billingclient/api/QueryProductDetailsParams;Lcom/emanuelef/remote_capture/PlayBilling;)V

    .line 111
    .line 112
    .line 113
    return-void

    .line 114
    :pswitch_3
    iget-object v0, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    .line 115
    .line 116
    check-cast v0, Landroid/view/View;

    .line 117
    .line 118
    iget-object v1, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    .line 119
    .line 120
    check-cast v1, Lcom/android/billingclient/api/zzcl;

    .line 121
    .line 122
    invoke-static {v0, v1}, Landroidx/core/view/WindowInsetsAnimationCompat$Impl21;->dispatchOnStart(Landroid/view/View;Lcom/android/billingclient/api/zzcl;)V

    .line 123
    .line 124
    .line 125
    iget-object v0, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    .line 126
    .line 127
    check-cast v0, Landroid/animation/ValueAnimator;

    .line 128
    .line 129
    invoke-virtual {v0}, Landroid/animation/ValueAnimator;->start()V

    .line 130
    .line 131
    .line 132
    return-void

    .line 133
    :pswitch_4
    :try_start_0
    iget-object v0, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    .line 134
    .line 135
    check-cast v0, Landroidx/core/provider/FontRequestWorker$1;

    .line 136
    .line 137
    invoke-virtual {v0}, Landroidx/core/provider/FontRequestWorker$1;->call()Ljava/lang/Object;

    .line 138
    .line 139
    .line 140
    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 141
    goto :goto_1

    .line 142
    :catch_0
    const/4 v0, 0x0

    .line 143
    :goto_1
    iget-object v1, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    .line 144
    .line 145
    check-cast v1, Lcom/android/billingclient/api/zzbr;

    .line 146
    .line 147
    iget-object v2, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    .line 148
    .line 149
    check-cast v2, Landroid/os/Handler;

    .line 150
    .line 151
    new-instance v3, Lcom/google/android/gms/tasks/zzi;

    .line 152
    .line 153
    const/4 v4, 0x5

    .line 154
    invoke-direct {v3, v1, v4, v0}, Lcom/google/android/gms/tasks/zzi;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 155
    .line 156
    .line 157
    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 158
    .line 159
    .line 160
    return-void

    .line 161
    :pswitch_5
    iget-object v0, p0, Lcom/android/billingclient/api/zzam;->zza:Ljava/lang/Object;

    .line 162
    .line 163
    check-cast v0, Lcom/android/billingclient/api/BillingClientImpl;

    .line 164
    .line 165
    iget-object v1, p0, Lcom/android/billingclient/api/zzam;->zzb:Ljava/lang/Object;

    .line 166
    .line 167
    check-cast v1, Lcom/android/billingclient/api/ConsumeResponseListener;

    .line 168
    .line 169
    iget-object v2, p0, Lcom/android/billingclient/api/zzam;->zzc:Ljava/lang/Object;

    .line 170
    .line 171
    check-cast v2, Lcom/android/billingclient/api/ConsumeParams;

    .line 172
    .line 173
    sget-object v3, Lcom/android/billingclient/api/zzcj;->zzk:Lcom/android/billingclient/api/BillingResult;

    .line 174
    .line 175
    const/4 v4, 0x4

    .line 176
    const/16 v5, 0x18

    .line 177
    .line 178
    invoke-virtual {v0, v5, v4, v3}, Lcom/android/billingclient/api/BillingClientImpl;->zzbd(IILcom/android/billingclient/api/BillingResult;)V

    .line 179
    .line 180
    .line 181
    iget-object v0, v2, Lcom/android/billingclient/api/ConsumeParams;->zza:Ljava/lang/String;

    .line 182
    .line 183
    invoke-interface {v1, v3, v0}, Lcom/android/billingclient/api/ConsumeResponseListener;->onConsumeResponse(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V

    .line 184
    .line 185
    .line 186
    return-void

    .line 187
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
