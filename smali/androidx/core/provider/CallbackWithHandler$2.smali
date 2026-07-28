.class public final Landroidx/core/provider/CallbackWithHandler$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final val$callback:Ljava/lang/Object;

.field public val$reason:I


# direct methods
.method public synthetic constructor <init>(IILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p2, p0, Landroidx/core/provider/CallbackWithHandler$2;->$r8$classId:I

    iput-object p3, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    iput p1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(ILandroidx/viewpager2/widget/ViewPager2$RecyclerViewImpl;)V
    .locals 1

    const/4 v0, 0x2

    iput v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->$r8$classId:I

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput p1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    .line 4
    iput-object p2, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/material/slider/BaseSlider;)V
    .locals 1

    const/4 v0, 0x5

    iput v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->$r8$classId:I

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    const/4 p1, -0x1

    .line 10
    iput p1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    return-void
.end method

.method public constructor <init>(Ljava/util/List;ILjava/lang/Throwable;)V
    .locals 0

    const/4 p3, 0x1

    iput p3, p0, Landroidx/core/provider/CallbackWithHandler$2;->$r8$classId:I

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    const-string p3, "initCallbacks cannot be null"

    invoke-static {p1, p3}, Landroidx/core/util/TimeUtils;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 7
    new-instance p3, Ljava/util/ArrayList;

    invoke-direct {p3, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object p3, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    .line 8
    iput p2, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 5

    .line 1
    iget v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lcom/google/android/material/slider/BaseSlider;

    .line 9
    .line 10
    iget-object v0, v0, Lcom/google/android/material/slider/BaseSlider;->accessibilityHelper:Lcom/google/android/material/slider/BaseSlider$AccessibilityHelper;

    .line 11
    .line 12
    iget v1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    .line 13
    .line 14
    const/4 v2, 0x4

    .line 15
    invoke-virtual {v0, v1, v2}, Landroidx/customview/widget/ExploreByTouchHelper;->sendEventForVirtualView(II)V

    .line 16
    .line 17
    .line 18
    return-void

    .line 19
    :pswitch_0
    iget-object v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    .line 20
    .line 21
    check-cast v0, Lcom/google/android/material/datepicker/MaterialCalendar;

    .line 22
    .line 23
    iget-object v0, v0, Lcom/google/android/material/datepicker/MaterialCalendar;->recyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 24
    .line 25
    iget v1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    .line 26
    .line 27
    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->smoothScrollToPosition(I)V

    .line 28
    .line 29
    .line 30
    return-void

    .line 31
    :pswitch_1
    iget-object v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    .line 32
    .line 33
    check-cast v0, Lcom/google/android/gms/common/api/internal/zabq;

    .line 34
    .line 35
    iget v1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    .line 36
    .line 37
    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/zabq;->zaI(I)V

    .line 38
    .line 39
    .line 40
    return-void

    .line 41
    :pswitch_2
    iget-object v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    .line 42
    .line 43
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;

    .line 44
    .line 45
    iget v1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    .line 46
    .line 47
    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->smoothScrollToPosition(I)V

    .line 48
    .line 49
    .line 50
    return-void

    .line 51
    :pswitch_3
    iget-object v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    .line 52
    .line 53
    check-cast v0, Ljava/util/ArrayList;

    .line 54
    .line 55
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 56
    .line 57
    .line 58
    move-result v1

    .line 59
    iget v2, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    .line 60
    .line 61
    const/4 v3, 0x1

    .line 62
    const/4 v4, 0x0

    .line 63
    if-eq v2, v3, :cond_0

    .line 64
    .line 65
    :goto_0
    if-ge v4, v1, :cond_1

    .line 66
    .line 67
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 68
    .line 69
    .line 70
    move-result-object v2

    .line 71
    check-cast v2, Landroidx/emoji2/text/EmojiCompat$InitCallback;

    .line 72
    .line 73
    invoke-virtual {v2}, Landroidx/emoji2/text/EmojiCompat$InitCallback;->onFailed()V

    .line 74
    .line 75
    .line 76
    add-int/lit8 v4, v4, 0x1

    .line 77
    .line 78
    goto :goto_0

    .line 79
    :cond_0
    :goto_1
    if-ge v4, v1, :cond_1

    .line 80
    .line 81
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 82
    .line 83
    .line 84
    move-result-object v2

    .line 85
    check-cast v2, Landroidx/emoji2/text/EmojiCompat$InitCallback;

    .line 86
    .line 87
    invoke-virtual {v2}, Landroidx/emoji2/text/EmojiCompat$InitCallback;->onInitialized()V

    .line 88
    .line 89
    .line 90
    add-int/lit8 v4, v4, 0x1

    .line 91
    .line 92
    goto :goto_1

    .line 93
    :cond_1
    return-void

    .line 94
    :pswitch_4
    iget-object v0, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$callback:Ljava/lang/Object;

    .line 95
    .line 96
    check-cast v0, Landroidx/viewpager2/widget/FakeDrag;

    .line 97
    .line 98
    iget v1, p0, Landroidx/core/provider/CallbackWithHandler$2;->val$reason:I

    .line 99
    .line 100
    iget-object v0, v0, Landroidx/viewpager2/widget/FakeDrag;->mScrollEventAdapter:Ljava/lang/Object;

    .line 101
    .line 102
    check-cast v0, Landroidx/core/content/res/ResourcesCompat$FontCallback;

    .line 103
    .line 104
    if-eqz v0, :cond_2

    .line 105
    .line 106
    invoke-virtual {v0, v1}, Landroidx/core/content/res/ResourcesCompat$FontCallback;->onFontRetrievalFailed(I)V

    .line 107
    .line 108
    .line 109
    :cond_2
    return-void

    .line 110
    nop

    .line 111
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
