.class public final Landroidx/savedstate/Recreator;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/lifecycle/LifecycleEventObserver;


# instance fields
.field public final synthetic $r8$classId:I

.field public final owner:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Landroidx/savedstate/Recreator;->$r8$classId:I

    iput-object p2, p0, Landroidx/savedstate/Recreator;->owner:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onStateChanged(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V
    .locals 8

    .line 1
    iget v0, p0, Landroidx/savedstate/Recreator;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/savedstate/Recreator;->owner:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Landroidx/navigation/fragment/DialogFragmentNavigator;

    .line 9
    .line 10
    sget-object v1, Landroidx/navigation/fragment/DialogFragmentNavigator$observer$1$WhenMappings;->$EnumSwitchMapping$0:[I

    .line 11
    .line 12
    invoke-virtual {p2}, Ljava/lang/Enum;->ordinal()I

    .line 13
    .line 14
    .line 15
    move-result p2

    .line 16
    aget p2, v1, p2

    .line 17
    .line 18
    const/4 v1, 0x1

    .line 19
    const/4 v2, 0x0

    .line 20
    if-eq p2, v1, :cond_b

    .line 21
    .line 22
    const/4 v1, 0x2

    .line 23
    const/4 v3, 0x0

    .line 24
    if-eq p2, v1, :cond_8

    .line 25
    .line 26
    const/4 v1, 0x3

    .line 27
    if-eq p2, v1, :cond_4

    .line 28
    .line 29
    const/4 v1, 0x4

    .line 30
    if-eq p2, v1, :cond_0

    .line 31
    .line 32
    goto/16 :goto_4

    .line 33
    .line 34
    :cond_0
    check-cast p1, Landroidx/fragment/app/DialogFragment;

    .line 35
    .line 36
    invoke-virtual {v0}, Landroidx/navigation/Navigator;->getState()Landroidx/navigation/NavController$NavControllerNavigatorState;

    .line 37
    .line 38
    .line 39
    move-result-object p2

    .line 40
    iget-object p2, p2, Landroidx/navigation/NavController$NavControllerNavigatorState;->transitionsInProgress:Lkotlinx/coroutines/flow/ReadonlyStateFlow;

    .line 41
    .line 42
    iget-object p2, p2, Lkotlinx/coroutines/flow/ReadonlyStateFlow;->$$delegate_0:Ljava/lang/Object;

    .line 43
    .line 44
    check-cast p2, Lkotlinx/coroutines/flow/StateFlowImpl;

    .line 45
    .line 46
    invoke-virtual {p2}, Lkotlinx/coroutines/flow/StateFlowImpl;->getValue()Ljava/lang/Object;

    .line 47
    .line 48
    .line 49
    move-result-object p2

    .line 50
    check-cast p2, Ljava/lang/Iterable;

    .line 51
    .line 52
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 53
    .line 54
    .line 55
    move-result-object p2

    .line 56
    :cond_1
    :goto_0
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    .line 57
    .line 58
    .line 59
    move-result v1

    .line 60
    if-eqz v1, :cond_2

    .line 61
    .line 62
    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 63
    .line 64
    .line 65
    move-result-object v1

    .line 66
    move-object v2, v1

    .line 67
    check-cast v2, Landroidx/navigation/NavBackStackEntry;

    .line 68
    .line 69
    iget-object v2, v2, Landroidx/navigation/NavBackStackEntry;->id:Ljava/lang/String;

    .line 70
    .line 71
    invoke-virtual {p1}, Landroidx/fragment/app/Fragment;->getTag()Ljava/lang/String;

    .line 72
    .line 73
    .line 74
    move-result-object v4

    .line 75
    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 76
    .line 77
    .line 78
    move-result v2

    .line 79
    if-eqz v2, :cond_1

    .line 80
    .line 81
    move-object v3, v1

    .line 82
    goto :goto_0

    .line 83
    :cond_2
    check-cast v3, Landroidx/navigation/NavBackStackEntry;

    .line 84
    .line 85
    if-eqz v3, :cond_3

    .line 86
    .line 87
    invoke-virtual {v0}, Landroidx/navigation/Navigator;->getState()Landroidx/navigation/NavController$NavControllerNavigatorState;

    .line 88
    .line 89
    .line 90
    move-result-object p2

    .line 91
    invoke-virtual {p2, v3}, Landroidx/navigation/NavController$NavControllerNavigatorState;->markTransitionComplete(Landroidx/navigation/NavBackStackEntry;)V

    .line 92
    .line 93
    .line 94
    :cond_3
    invoke-virtual {p1}, Landroidx/fragment/app/Fragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    .line 95
    .line 96
    .line 97
    move-result-object p1

    .line 98
    invoke-virtual {p1, p0}, Landroidx/lifecycle/Lifecycle;->removeObserver(Landroidx/lifecycle/LifecycleObserver;)V

    .line 99
    .line 100
    .line 101
    goto/16 :goto_4

    .line 102
    .line 103
    :cond_4
    check-cast p1, Landroidx/fragment/app/DialogFragment;

    .line 104
    .line 105
    invoke-virtual {p1}, Landroidx/fragment/app/DialogFragment;->requireDialog()Landroid/app/Dialog;

    .line 106
    .line 107
    .line 108
    move-result-object p2

    .line 109
    invoke-virtual {p2}, Landroid/app/Dialog;->isShowing()Z

    .line 110
    .line 111
    .line 112
    move-result p2

    .line 113
    if-nez p2, :cond_f

    .line 114
    .line 115
    invoke-virtual {v0}, Landroidx/navigation/Navigator;->getState()Landroidx/navigation/NavController$NavControllerNavigatorState;

    .line 116
    .line 117
    .line 118
    move-result-object p2

    .line 119
    iget-object p2, p2, Landroidx/navigation/NavController$NavControllerNavigatorState;->backStack:Lkotlinx/coroutines/flow/ReadonlyStateFlow;

    .line 120
    .line 121
    iget-object p2, p2, Lkotlinx/coroutines/flow/ReadonlyStateFlow;->$$delegate_0:Ljava/lang/Object;

    .line 122
    .line 123
    check-cast p2, Lkotlinx/coroutines/flow/StateFlowImpl;

    .line 124
    .line 125
    invoke-virtual {p2}, Lkotlinx/coroutines/flow/StateFlowImpl;->getValue()Ljava/lang/Object;

    .line 126
    .line 127
    .line 128
    move-result-object p2

    .line 129
    check-cast p2, Ljava/util/List;

    .line 130
    .line 131
    invoke-interface {p2}, Ljava/util/List;->size()I

    .line 132
    .line 133
    .line 134
    move-result v1

    .line 135
    invoke-interface {p2, v1}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    .line 136
    .line 137
    .line 138
    move-result-object v1

    .line 139
    :cond_5
    invoke-interface {v1}, Ljava/util/ListIterator;->hasPrevious()Z

    .line 140
    .line 141
    .line 142
    move-result v3

    .line 143
    if-eqz v3, :cond_6

    .line 144
    .line 145
    invoke-interface {v1}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    .line 146
    .line 147
    .line 148
    move-result-object v3

    .line 149
    check-cast v3, Landroidx/navigation/NavBackStackEntry;

    .line 150
    .line 151
    iget-object v3, v3, Landroidx/navigation/NavBackStackEntry;->id:Ljava/lang/String;

    .line 152
    .line 153
    invoke-virtual {p1}, Landroidx/fragment/app/Fragment;->getTag()Ljava/lang/String;

    .line 154
    .line 155
    .line 156
    move-result-object v4

    .line 157
    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 158
    .line 159
    .line 160
    move-result v3

    .line 161
    if-eqz v3, :cond_5

    .line 162
    .line 163
    invoke-interface {v1}, Ljava/util/ListIterator;->nextIndex()I

    .line 164
    .line 165
    .line 166
    move-result v1

    .line 167
    goto :goto_1

    .line 168
    :cond_6
    const/4 v1, -0x1

    .line 169
    :goto_1
    invoke-static {v1, p2}, Lkotlin/collections/CollectionsKt;->getOrNull(ILjava/util/List;)Ljava/lang/Object;

    .line 170
    .line 171
    .line 172
    move-result-object v3

    .line 173
    check-cast v3, Landroidx/navigation/NavBackStackEntry;

    .line 174
    .line 175
    invoke-static {p2}, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;

    .line 176
    .line 177
    .line 178
    move-result-object p2

    .line 179
    invoke-static {p2, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 180
    .line 181
    .line 182
    move-result p2

    .line 183
    if-nez p2, :cond_7

    .line 184
    .line 185
    new-instance p2, Ljava/lang/StringBuilder;

    .line 186
    .line 187
    const-string v4, "Dialog "

    .line 188
    .line 189
    invoke-direct {p2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 190
    .line 191
    .line 192
    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 193
    .line 194
    .line 195
    const-string p1, " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog"

    .line 196
    .line 197
    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 198
    .line 199
    .line 200
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 201
    .line 202
    .line 203
    move-result-object p1

    .line 204
    const-string p2, "DialogFragmentNavigator"

    .line 205
    .line 206
    invoke-static {p2, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 207
    .line 208
    .line 209
    :cond_7
    if-eqz v3, :cond_f

    .line 210
    .line 211
    invoke-virtual {v0, v1, v3, v2}, Landroidx/navigation/fragment/DialogFragmentNavigator;->popWithTransition(ILandroidx/navigation/NavBackStackEntry;Z)V

    .line 212
    .line 213
    .line 214
    goto/16 :goto_4

    .line 215
    .line 216
    :cond_8
    check-cast p1, Landroidx/fragment/app/DialogFragment;

    .line 217
    .line 218
    invoke-virtual {v0}, Landroidx/navigation/Navigator;->getState()Landroidx/navigation/NavController$NavControllerNavigatorState;

    .line 219
    .line 220
    .line 221
    move-result-object p2

    .line 222
    iget-object p2, p2, Landroidx/navigation/NavController$NavControllerNavigatorState;->transitionsInProgress:Lkotlinx/coroutines/flow/ReadonlyStateFlow;

    .line 223
    .line 224
    iget-object p2, p2, Lkotlinx/coroutines/flow/ReadonlyStateFlow;->$$delegate_0:Ljava/lang/Object;

    .line 225
    .line 226
    check-cast p2, Lkotlinx/coroutines/flow/StateFlowImpl;

    .line 227
    .line 228
    invoke-virtual {p2}, Lkotlinx/coroutines/flow/StateFlowImpl;->getValue()Ljava/lang/Object;

    .line 229
    .line 230
    .line 231
    move-result-object p2

    .line 232
    check-cast p2, Ljava/lang/Iterable;

    .line 233
    .line 234
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 235
    .line 236
    .line 237
    move-result-object p2

    .line 238
    :cond_9
    :goto_2
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    .line 239
    .line 240
    .line 241
    move-result v1

    .line 242
    if-eqz v1, :cond_a

    .line 243
    .line 244
    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 245
    .line 246
    .line 247
    move-result-object v1

    .line 248
    move-object v2, v1

    .line 249
    check-cast v2, Landroidx/navigation/NavBackStackEntry;

    .line 250
    .line 251
    iget-object v2, v2, Landroidx/navigation/NavBackStackEntry;->id:Ljava/lang/String;

    .line 252
    .line 253
    invoke-virtual {p1}, Landroidx/fragment/app/Fragment;->getTag()Ljava/lang/String;

    .line 254
    .line 255
    .line 256
    move-result-object v4

    .line 257
    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 258
    .line 259
    .line 260
    move-result v2

    .line 261
    if-eqz v2, :cond_9

    .line 262
    .line 263
    move-object v3, v1

    .line 264
    goto :goto_2

    .line 265
    :cond_a
    check-cast v3, Landroidx/navigation/NavBackStackEntry;

    .line 266
    .line 267
    if-eqz v3, :cond_f

    .line 268
    .line 269
    invoke-virtual {v0}, Landroidx/navigation/Navigator;->getState()Landroidx/navigation/NavController$NavControllerNavigatorState;

    .line 270
    .line 271
    .line 272
    move-result-object p1

    .line 273
    invoke-virtual {p1, v3}, Landroidx/navigation/NavController$NavControllerNavigatorState;->markTransitionComplete(Landroidx/navigation/NavBackStackEntry;)V

    .line 274
    .line 275
    .line 276
    goto :goto_4

    .line 277
    :cond_b
    check-cast p1, Landroidx/fragment/app/DialogFragment;

    .line 278
    .line 279
    invoke-virtual {v0}, Landroidx/navigation/Navigator;->getState()Landroidx/navigation/NavController$NavControllerNavigatorState;

    .line 280
    .line 281
    .line 282
    move-result-object p2

    .line 283
    iget-object p2, p2, Landroidx/navigation/NavController$NavControllerNavigatorState;->backStack:Lkotlinx/coroutines/flow/ReadonlyStateFlow;

    .line 284
    .line 285
    iget-object p2, p2, Lkotlinx/coroutines/flow/ReadonlyStateFlow;->$$delegate_0:Ljava/lang/Object;

    .line 286
    .line 287
    check-cast p2, Lkotlinx/coroutines/flow/StateFlowImpl;

    .line 288
    .line 289
    invoke-virtual {p2}, Lkotlinx/coroutines/flow/StateFlowImpl;->getValue()Ljava/lang/Object;

    .line 290
    .line 291
    .line 292
    move-result-object p2

    .line 293
    check-cast p2, Ljava/lang/Iterable;

    .line 294
    .line 295
    instance-of v0, p2, Ljava/util/Collection;

    .line 296
    .line 297
    if-eqz v0, :cond_c

    .line 298
    .line 299
    move-object v0, p2

    .line 300
    check-cast v0, Ljava/util/Collection;

    .line 301
    .line 302
    invoke-interface {v0}, Ljava/util/Collection;->isEmpty()Z

    .line 303
    .line 304
    .line 305
    move-result v0

    .line 306
    if-eqz v0, :cond_c

    .line 307
    .line 308
    goto :goto_3

    .line 309
    :cond_c
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 310
    .line 311
    .line 312
    move-result-object p2

    .line 313
    :cond_d
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    .line 314
    .line 315
    .line 316
    move-result v0

    .line 317
    if-eqz v0, :cond_e

    .line 318
    .line 319
    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 320
    .line 321
    .line 322
    move-result-object v0

    .line 323
    check-cast v0, Landroidx/navigation/NavBackStackEntry;

    .line 324
    .line 325
    iget-object v0, v0, Landroidx/navigation/NavBackStackEntry;->id:Ljava/lang/String;

    .line 326
    .line 327
    invoke-virtual {p1}, Landroidx/fragment/app/Fragment;->getTag()Ljava/lang/String;

    .line 328
    .line 329
    .line 330
    move-result-object v1

    .line 331
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 332
    .line 333
    .line 334
    move-result v0

    .line 335
    if-eqz v0, :cond_d

    .line 336
    .line 337
    goto :goto_4

    .line 338
    :cond_e
    :goto_3
    invoke-virtual {p1, v2, v2}, Landroidx/fragment/app/DialogFragment;->dismissInternal(ZZ)V

    .line 339
    .line 340
    .line 341
    :cond_f
    :goto_4
    return-void

    .line 342
    :pswitch_0
    iget-object v0, p0, Landroidx/savedstate/Recreator;->owner:Ljava/lang/Object;

    .line 343
    .line 344
    check-cast v0, Landroidx/savedstate/SavedStateRegistryOwner;

    .line 345
    .line 346
    sget-object v1, Landroidx/lifecycle/Lifecycle$Event;->ON_CREATE:Landroidx/lifecycle/Lifecycle$Event;

    .line 347
    .line 348
    if-ne p2, v1, :cond_17

    .line 349
    .line 350
    invoke-interface {p1}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    .line 351
    .line 352
    .line 353
    move-result-object p1

    .line 354
    invoke-virtual {p1, p0}, Landroidx/lifecycle/Lifecycle;->removeObserver(Landroidx/lifecycle/LifecycleObserver;)V

    .line 355
    .line 356
    .line 357
    invoke-interface {v0}, Landroidx/savedstate/SavedStateRegistryOwner;->getSavedStateRegistry()Landroidx/savedstate/SavedStateRegistry;

    .line 358
    .line 359
    .line 360
    move-result-object p1

    .line 361
    const-string p2, "androidx.savedstate.Restarter"

    .line 362
    .line 363
    invoke-virtual {p1, p2}, Landroidx/savedstate/SavedStateRegistry;->consumeRestoredStateForKey(Ljava/lang/String;)Landroid/os/Bundle;

    .line 364
    .line 365
    .line 366
    move-result-object p1

    .line 367
    if-nez p1, :cond_10

    .line 368
    .line 369
    goto/16 :goto_7

    .line 370
    .line 371
    :cond_10
    const-string p2, "classes_to_restore"

    .line 372
    .line 373
    invoke-virtual {p1, p2}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    .line 374
    .line 375
    .line 376
    move-result-object p1

    .line 377
    if-eqz p1, :cond_16

    .line 378
    .line 379
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 380
    .line 381
    .line 382
    move-result p2

    .line 383
    const/4 v1, 0x0

    .line 384
    const/4 v2, 0x0

    .line 385
    :cond_11
    :goto_5
    if-ge v2, p2, :cond_15

    .line 386
    .line 387
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 388
    .line 389
    .line 390
    move-result-object v3

    .line 391
    add-int/lit8 v2, v2, 0x1

    .line 392
    .line 393
    check-cast v3, Ljava/lang/String;

    .line 394
    .line 395
    const-string v4, "Class "

    .line 396
    .line 397
    :try_start_0
    const-class v5, Landroidx/savedstate/Recreator;

    .line 398
    .line 399
    invoke-virtual {v5}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    .line 400
    .line 401
    .line 402
    move-result-object v5

    .line 403
    invoke-static {v3, v1, v5}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    .line 404
    .line 405
    .line 406
    move-result-object v5

    .line 407
    const-class v6, Landroidx/savedstate/SavedStateRegistry$AutoRecreated;

    .line 408
    .line 409
    invoke-virtual {v5, v6}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    .line 410
    .line 411
    .line 412
    move-result-object v5

    .line 413
    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_2

    .line 414
    .line 415
    .line 416
    const/4 v6, 0x0

    .line 417
    :try_start_1
    invoke-virtual {v5, v6}, Ljava/lang/Class;->getDeclaredConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    .line 418
    .line 419
    .line 420
    move-result-object v4
    :try_end_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_1

    .line 421
    const/4 v5, 0x1

    .line 422
    invoke-virtual {v4, v5}, Ljava/lang/reflect/AccessibleObject;->setAccessible(Z)V

    .line 423
    .line 424
    .line 425
    :try_start_2
    invoke-virtual {v4, v6}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    .line 426
    .line 427
    .line 428
    move-result-object v4

    .line 429
    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 430
    .line 431
    .line 432
    check-cast v4, Landroidx/savedstate/SavedStateRegistry$AutoRecreated;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 433
    .line 434
    instance-of v3, v0, Landroidx/lifecycle/ViewModelStoreOwner;

    .line 435
    .line 436
    if-eqz v3, :cond_14

    .line 437
    .line 438
    move-object v3, v0

    .line 439
    check-cast v3, Landroidx/lifecycle/ViewModelStoreOwner;

    .line 440
    .line 441
    invoke-interface {v3}, Landroidx/lifecycle/ViewModelStoreOwner;->getViewModelStore()Landroidx/lifecycle/ViewModelStore;

    .line 442
    .line 443
    .line 444
    move-result-object v3

    .line 445
    invoke-interface {v0}, Landroidx/savedstate/SavedStateRegistryOwner;->getSavedStateRegistry()Landroidx/savedstate/SavedStateRegistry;

    .line 446
    .line 447
    .line 448
    move-result-object v4

    .line 449
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 450
    .line 451
    .line 452
    iget-object v3, v3, Landroidx/lifecycle/ViewModelStore;->map:Ljava/util/LinkedHashMap;

    .line 453
    .line 454
    new-instance v5, Ljava/util/HashSet;

    .line 455
    .line 456
    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;

    .line 457
    .line 458
    .line 459
    move-result-object v6

    .line 460
    invoke-direct {v5, v6}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 461
    .line 462
    .line 463
    invoke-virtual {v5}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 464
    .line 465
    .line 466
    move-result-object v5

    .line 467
    :goto_6
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    .line 468
    .line 469
    .line 470
    move-result v6

    .line 471
    if-eqz v6, :cond_13

    .line 472
    .line 473
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 474
    .line 475
    .line 476
    move-result-object v6

    .line 477
    check-cast v6, Ljava/lang/String;

    .line 478
    .line 479
    const-string v7, "key"

    .line 480
    .line 481
    invoke-static {v6, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 482
    .line 483
    .line 484
    invoke-virtual {v3, v6}, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 485
    .line 486
    .line 487
    move-result-object v6

    .line 488
    check-cast v6, Landroidx/lifecycle/ViewModel;

    .line 489
    .line 490
    if-nez v6, :cond_12

    .line 491
    .line 492
    goto :goto_6

    .line 493
    :cond_12
    invoke-interface {v0}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    .line 494
    .line 495
    .line 496
    move-result-object v7

    .line 497
    invoke-static {v6, v4, v7}, Landroidx/lifecycle/SavedStateHandleSupport;->attachHandleIfNeeded(Landroidx/lifecycle/ViewModel;Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/Lifecycle;)V

    .line 498
    .line 499
    .line 500
    goto :goto_6

    .line 501
    :cond_13
    new-instance v5, Ljava/util/HashSet;

    .line 502
    .line 503
    invoke-virtual {v3}, Ljava/util/LinkedHashMap;->keySet()Ljava/util/Set;

    .line 504
    .line 505
    .line 506
    move-result-object v3

    .line 507
    invoke-direct {v5, v3}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 508
    .line 509
    .line 510
    invoke-virtual {v5}, Ljava/util/HashSet;->isEmpty()Z

    .line 511
    .line 512
    .line 513
    move-result v3

    .line 514
    if-nez v3, :cond_11

    .line 515
    .line 516
    invoke-virtual {v4}, Landroidx/savedstate/SavedStateRegistry;->runOnNextRecreation()V

    .line 517
    .line 518
    .line 519
    goto/16 :goto_5

    .line 520
    .line 521
    :cond_14
    new-instance p1, Ljava/lang/StringBuilder;

    .line 522
    .line 523
    const-string p2, "Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: "

    .line 524
    .line 525
    invoke-direct {p1, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 526
    .line 527
    .line 528
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 529
    .line 530
    .line 531
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 532
    .line 533
    .line 534
    move-result-object p1

    .line 535
    new-instance p2, Ljava/lang/IllegalStateException;

    .line 536
    .line 537
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 538
    .line 539
    .line 540
    move-result-object p1

    .line 541
    invoke-direct {p2, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 542
    .line 543
    .line 544
    throw p2

    .line 545
    :catch_0
    move-exception p1

    .line 546
    new-instance p2, Ljava/lang/RuntimeException;

    .line 547
    .line 548
    new-instance v0, Ljava/lang/StringBuilder;

    .line 549
    .line 550
    const-string v1, "Failed to instantiate "

    .line 551
    .line 552
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 553
    .line 554
    .line 555
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 556
    .line 557
    .line 558
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 559
    .line 560
    .line 561
    move-result-object v0

    .line 562
    invoke-direct {p2, v0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 563
    .line 564
    .line 565
    throw p2

    .line 566
    :catch_1
    move-exception p1

    .line 567
    new-instance p2, Ljava/lang/IllegalStateException;

    .line 568
    .line 569
    new-instance v0, Ljava/lang/StringBuilder;

    .line 570
    .line 571
    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 572
    .line 573
    .line 574
    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    .line 575
    .line 576
    .line 577
    move-result-object v1

    .line 578
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 579
    .line 580
    .line 581
    const-string v1, " must have default constructor in order to be automatically recreated"

    .line 582
    .line 583
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 584
    .line 585
    .line 586
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 587
    .line 588
    .line 589
    move-result-object v0

    .line 590
    invoke-direct {p2, v0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 591
    .line 592
    .line 593
    throw p2

    .line 594
    :catch_2
    move-exception p1

    .line 595
    new-instance p2, Ljava/lang/RuntimeException;

    .line 596
    .line 597
    const-string v0, " wasn\'t found"

    .line 598
    .line 599
    invoke-static {v4, v3, v0}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 600
    .line 601
    .line 602
    move-result-object v0

    .line 603
    invoke-direct {p2, v0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 604
    .line 605
    .line 606
    throw p2

    .line 607
    :cond_15
    :goto_7
    return-void

    .line 608
    :cond_16
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 609
    .line 610
    const-string p2, "SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\""

    .line 611
    .line 612
    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 613
    .line 614
    .line 615
    throw p1

    .line 616
    :cond_17
    new-instance p1, Ljava/lang/AssertionError;

    .line 617
    .line 618
    const-string p2, "Next event must be ON_CREATE"

    .line 619
    .line 620
    invoke-direct {p1, p2}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    .line 621
    .line 622
    .line 623
    throw p1

    .line 624
    nop

    .line 625
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
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
