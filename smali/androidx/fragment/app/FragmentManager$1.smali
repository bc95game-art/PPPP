.class public final Landroidx/fragment/app/FragmentManager$1;
.super Landroidx/activity/OnBackPressedCallback;
.source "SourceFile"


# instance fields
.field public final synthetic this$0:Landroidx/fragment/app/FragmentManager;


# direct methods
.method public constructor <init>(Landroidx/fragment/app/FragmentManager;)V
    .locals 0

    .line 1
    iput-object p1, p0, Landroidx/fragment/app/FragmentManager$1;->this$0:Landroidx/fragment/app/FragmentManager;

    .line 2
    .line 3
    invoke-direct {p0}, Landroidx/activity/OnBackPressedCallback;-><init>()V

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
.end method


# virtual methods
.method public final handleOnBackCancelled()V
    .locals 5

    .line 1
    const/4 v0, 0x3

    .line 2
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 3
    .line 4
    .line 5
    move-result v1

    .line 6
    iget-object v2, p0, Landroidx/fragment/app/FragmentManager$1;->this$0:Landroidx/fragment/app/FragmentManager;

    .line 7
    .line 8
    const-string v3, "FragmentManager"

    .line 9
    .line 10
    if-eqz v1, :cond_0

    .line 11
    .line 12
    new-instance v1, Ljava/lang/StringBuilder;

    .line 13
    .line 14
    const-string v4, "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager "

    .line 15
    .line 16
    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 17
    .line 18
    .line 19
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 20
    .line 21
    .line 22
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v1

    .line 26
    invoke-static {v3, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    .line 28
    .line 29
    :cond_0
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 30
    .line 31
    .line 32
    move-result v0

    .line 33
    if-eqz v0, :cond_1

    .line 34
    .line 35
    new-instance v0, Ljava/lang/StringBuilder;

    .line 36
    .line 37
    const-string v1, "cancelBackStackTransition for transition "

    .line 38
    .line 39
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 40
    .line 41
    .line 42
    iget-object v1, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 43
    .line 44
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 45
    .line 46
    .line 47
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 48
    .line 49
    .line 50
    move-result-object v0

    .line 51
    invoke-static {v3, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 52
    .line 53
    .line 54
    :cond_1
    iget-object v0, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 55
    .line 56
    if-eqz v0, :cond_3

    .line 57
    .line 58
    const/4 v1, 0x0

    .line 59
    iput-boolean v1, v0, Landroidx/fragment/app/BackStackRecord;->mCommitted:Z

    .line 60
    .line 61
    invoke-virtual {v0}, Landroidx/fragment/app/BackStackRecord;->collapseOps()V

    .line 62
    .line 63
    .line 64
    iget-object v0, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 65
    .line 66
    new-instance v3, Landroidx/fragment/app/Fragment$$ExternalSyntheticLambda1;

    .line 67
    .line 68
    const/4 v4, 0x4

    .line 69
    invoke-direct {v3, v4, v2}, Landroidx/fragment/app/Fragment$$ExternalSyntheticLambda1;-><init>(ILjava/lang/Object;)V

    .line 70
    .line 71
    .line 72
    iget-object v4, v0, Landroidx/fragment/app/FragmentTransaction;->mCommitRunnables:Ljava/util/ArrayList;

    .line 73
    .line 74
    if-nez v4, :cond_2

    .line 75
    .line 76
    new-instance v4, Ljava/util/ArrayList;

    .line 77
    .line 78
    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 79
    .line 80
    .line 81
    iput-object v4, v0, Landroidx/fragment/app/FragmentTransaction;->mCommitRunnables:Ljava/util/ArrayList;

    .line 82
    .line 83
    :cond_2
    iget-object v0, v0, Landroidx/fragment/app/FragmentTransaction;->mCommitRunnables:Ljava/util/ArrayList;

    .line 84
    .line 85
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 86
    .line 87
    .line 88
    iget-object v0, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 89
    .line 90
    invoke-virtual {v0}, Landroidx/fragment/app/BackStackRecord;->commit()I

    .line 91
    .line 92
    .line 93
    const/4 v0, 0x1

    .line 94
    iput-boolean v0, v2, Landroidx/fragment/app/FragmentManager;->mHandlingTransitioningOp:Z

    .line 95
    .line 96
    invoke-virtual {v2, v0}, Landroidx/fragment/app/FragmentManager;->execPendingActions(Z)Z

    .line 97
    .line 98
    .line 99
    invoke-virtual {v2}, Landroidx/fragment/app/FragmentManager;->forcePostponedTransactions()V

    .line 100
    .line 101
    .line 102
    iput-boolean v1, v2, Landroidx/fragment/app/FragmentManager;->mHandlingTransitioningOp:Z

    .line 103
    .line 104
    const/4 v0, 0x0

    .line 105
    iput-object v0, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 106
    .line 107
    :cond_3
    return-void
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

.method public final handleOnBackPressed()V
    .locals 13

    .line 1
    const/4 v0, 0x3

    .line 2
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 3
    .line 4
    .line 5
    move-result v1

    .line 6
    iget-object v2, p0, Landroidx/fragment/app/FragmentManager$1;->this$0:Landroidx/fragment/app/FragmentManager;

    .line 7
    .line 8
    const-string v3, "FragmentManager"

    .line 9
    .line 10
    if-eqz v1, :cond_0

    .line 11
    .line 12
    new-instance v1, Ljava/lang/StringBuilder;

    .line 13
    .line 14
    const-string v4, "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager "

    .line 15
    .line 16
    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 17
    .line 18
    .line 19
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 20
    .line 21
    .line 22
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v1

    .line 26
    invoke-static {v3, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    .line 28
    .line 29
    :cond_0
    iget-object v1, v2, Landroidx/fragment/app/FragmentManager;->mOnBackPressedCallback:Landroidx/fragment/app/FragmentManager$1;

    .line 30
    .line 31
    iget-object v4, v2, Landroidx/fragment/app/FragmentManager;->mBackStackChangeListeners:Ljava/util/ArrayList;

    .line 32
    .line 33
    const/4 v5, 0x1

    .line 34
    iput-boolean v5, v2, Landroidx/fragment/app/FragmentManager;->mHandlingTransitioningOp:Z

    .line 35
    .line 36
    invoke-virtual {v2, v5}, Landroidx/fragment/app/FragmentManager;->execPendingActions(Z)Z

    .line 37
    .line 38
    .line 39
    const/4 v6, 0x0

    .line 40
    iput-boolean v6, v2, Landroidx/fragment/app/FragmentManager;->mHandlingTransitioningOp:Z

    .line 41
    .line 42
    iget-object v7, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 43
    .line 44
    if-eqz v7, :cond_a

    .line 45
    .line 46
    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    .line 47
    .line 48
    .line 49
    move-result v7

    .line 50
    if-nez v7, :cond_2

    .line 51
    .line 52
    new-instance v7, Ljava/util/LinkedHashSet;

    .line 53
    .line 54
    iget-object v8, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 55
    .line 56
    invoke-static {v8}, Landroidx/fragment/app/FragmentManager;->fragmentsFromRecord(Landroidx/fragment/app/BackStackRecord;)Ljava/util/HashSet;

    .line 57
    .line 58
    .line 59
    move-result-object v8

    .line 60
    invoke-direct {v7, v8}, Ljava/util/LinkedHashSet;-><init>(Ljava/util/Collection;)V

    .line 61
    .line 62
    .line 63
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    .line 64
    .line 65
    .line 66
    move-result v8

    .line 67
    const/4 v9, 0x0

    .line 68
    :cond_1
    if-ge v9, v8, :cond_2

    .line 69
    .line 70
    invoke-virtual {v4, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 71
    .line 72
    .line 73
    move-result-object v10

    .line 74
    add-int/lit8 v9, v9, 0x1

    .line 75
    .line 76
    check-cast v10, Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;

    .line 77
    .line 78
    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 79
    .line 80
    .line 81
    move-result-object v11

    .line 82
    :goto_0
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    .line 83
    .line 84
    .line 85
    move-result v12

    .line 86
    if-eqz v12, :cond_1

    .line 87
    .line 88
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 89
    .line 90
    .line 91
    move-result-object v12

    .line 92
    check-cast v12, Landroidx/fragment/app/Fragment;

    .line 93
    .line 94
    invoke-interface {v10, v12, v5}, Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;->onBackStackChangeCommitted(Landroidx/fragment/app/Fragment;Z)V

    .line 95
    .line 96
    .line 97
    goto :goto_0

    .line 98
    :cond_2
    iget-object v4, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 99
    .line 100
    iget-object v4, v4, Landroidx/fragment/app/FragmentTransaction;->mOps:Ljava/util/ArrayList;

    .line 101
    .line 102
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    .line 103
    .line 104
    .line 105
    move-result v7

    .line 106
    const/4 v8, 0x0

    .line 107
    :cond_3
    :goto_1
    if-ge v8, v7, :cond_4

    .line 108
    .line 109
    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 110
    .line 111
    .line 112
    move-result-object v9

    .line 113
    add-int/lit8 v8, v8, 0x1

    .line 114
    .line 115
    check-cast v9, Landroidx/fragment/app/FragmentTransaction$Op;

    .line 116
    .line 117
    iget-object v9, v9, Landroidx/fragment/app/FragmentTransaction$Op;->mFragment:Landroidx/fragment/app/Fragment;

    .line 118
    .line 119
    if-eqz v9, :cond_3

    .line 120
    .line 121
    iput-boolean v6, v9, Landroidx/fragment/app/Fragment;->mTransitioning:Z

    .line 122
    .line 123
    goto :goto_1

    .line 124
    :cond_4
    new-instance v4, Ljava/util/ArrayList;

    .line 125
    .line 126
    iget-object v7, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 127
    .line 128
    invoke-static {v7}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    .line 129
    .line 130
    .line 131
    move-result-object v7

    .line 132
    invoke-direct {v4, v7}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 133
    .line 134
    .line 135
    invoke-virtual {v2, v4, v6, v5}, Landroidx/fragment/app/FragmentManager;->collectChangedControllers(Ljava/util/ArrayList;II)Ljava/util/HashSet;

    .line 136
    .line 137
    .line 138
    move-result-object v4

    .line 139
    invoke-virtual {v4}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 140
    .line 141
    .line 142
    move-result-object v4

    .line 143
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    .line 144
    .line 145
    .line 146
    move-result v5

    .line 147
    if-eqz v5, :cond_6

    .line 148
    .line 149
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 150
    .line 151
    .line 152
    move-result-object v5

    .line 153
    check-cast v5, Landroidx/fragment/app/DefaultSpecialEffectsController;

    .line 154
    .line 155
    iget-object v7, v5, Landroidx/fragment/app/DefaultSpecialEffectsController;->runningOperations:Ljava/util/ArrayList;

    .line 156
    .line 157
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 158
    .line 159
    .line 160
    move-result v8

    .line 161
    if-eqz v8, :cond_5

    .line 162
    .line 163
    const-string v8, "SpecialEffectsController: Completing Back "

    .line 164
    .line 165
    invoke-static {v3, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    .line 167
    .line 168
    :cond_5
    invoke-virtual {v5, v7}, Landroidx/fragment/app/DefaultSpecialEffectsController;->processStart(Ljava/util/List;)V

    .line 169
    .line 170
    .line 171
    invoke-virtual {v5, v7}, Landroidx/fragment/app/DefaultSpecialEffectsController;->commitEffects$fragment_release(Ljava/util/List;)V

    .line 172
    .line 173
    .line 174
    goto :goto_2

    .line 175
    :cond_6
    iget-object v4, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 176
    .line 177
    iget-object v4, v4, Landroidx/fragment/app/FragmentTransaction;->mOps:Ljava/util/ArrayList;

    .line 178
    .line 179
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    .line 180
    .line 181
    .line 182
    move-result v5

    .line 183
    :cond_7
    :goto_3
    if-ge v6, v5, :cond_8

    .line 184
    .line 185
    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 186
    .line 187
    .line 188
    move-result-object v7

    .line 189
    add-int/lit8 v6, v6, 0x1

    .line 190
    .line 191
    check-cast v7, Landroidx/fragment/app/FragmentTransaction$Op;

    .line 192
    .line 193
    iget-object v7, v7, Landroidx/fragment/app/FragmentTransaction$Op;->mFragment:Landroidx/fragment/app/Fragment;

    .line 194
    .line 195
    if-eqz v7, :cond_7

    .line 196
    .line 197
    iget-object v8, v7, Landroidx/fragment/app/Fragment;->mContainer:Landroid/view/ViewGroup;

    .line 198
    .line 199
    if-nez v8, :cond_7

    .line 200
    .line 201
    invoke-virtual {v2, v7}, Landroidx/fragment/app/FragmentManager;->createOrGetFragmentStateManager(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/FragmentStateManager;

    .line 202
    .line 203
    .line 204
    move-result-object v7

    .line 205
    invoke-virtual {v7}, Landroidx/fragment/app/FragmentStateManager;->moveToExpectedState()V

    .line 206
    .line 207
    .line 208
    goto :goto_3

    .line 209
    :cond_8
    const/4 v4, 0x0

    .line 210
    iput-object v4, v2, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 211
    .line 212
    invoke-virtual {v2}, Landroidx/fragment/app/FragmentManager;->updateOnBackPressedCallbackEnabled()V

    .line 213
    .line 214
    .line 215
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 216
    .line 217
    .line 218
    move-result v0

    .line 219
    if-eqz v0, :cond_9

    .line 220
    .line 221
    const-string v0, "Op is being set to null"

    .line 222
    .line 223
    invoke-static {v3, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 224
    .line 225
    .line 226
    new-instance v0, Ljava/lang/StringBuilder;

    .line 227
    .line 228
    const-string v4, "OnBackPressedCallback enabled="

    .line 229
    .line 230
    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 231
    .line 232
    .line 233
    iget-boolean v1, v1, Landroidx/activity/OnBackPressedCallback;->isEnabled:Z

    .line 234
    .line 235
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 236
    .line 237
    .line 238
    const-string v1, " for  FragmentManager "

    .line 239
    .line 240
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 241
    .line 242
    .line 243
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 244
    .line 245
    .line 246
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 247
    .line 248
    .line 249
    move-result-object v0

    .line 250
    invoke-static {v3, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 251
    .line 252
    .line 253
    :cond_9
    return-void

    .line 254
    :cond_a
    iget-boolean v1, v1, Landroidx/activity/OnBackPressedCallback;->isEnabled:Z

    .line 255
    .line 256
    if-eqz v1, :cond_c

    .line 257
    .line 258
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 259
    .line 260
    .line 261
    move-result v0

    .line 262
    if-eqz v0, :cond_b

    .line 263
    .line 264
    const-string v0, "Calling popBackStackImmediate via onBackPressed callback"

    .line 265
    .line 266
    invoke-static {v3, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 267
    .line 268
    .line 269
    :cond_b
    invoke-virtual {v2}, Landroidx/fragment/app/FragmentManager;->popBackStackImmediate()Z

    .line 270
    .line 271
    .line 272
    return-void

    .line 273
    :cond_c
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 274
    .line 275
    .line 276
    move-result v0

    .line 277
    if-eqz v0, :cond_d

    .line 278
    .line 279
    const-string v0, "Calling onBackPressed via onBackPressed callback"

    .line 280
    .line 281
    invoke-static {v3, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 282
    .line 283
    .line 284
    :cond_d
    iget-object v0, v2, Landroidx/fragment/app/FragmentManager;->mOnBackPressedDispatcher:Landroidx/activity/OnBackPressedDispatcher;

    .line 285
    .line 286
    invoke-virtual {v0}, Landroidx/activity/OnBackPressedDispatcher;->onBackPressed()V

    .line 287
    .line 288
    .line 289
    return-void
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

.method public final handleOnBackProgressed(Landroidx/activity/BackEventCompat;)V
    .locals 11

    .line 1
    const/4 v0, 0x2

    .line 2
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 3
    .line 4
    .line 5
    move-result v1

    .line 6
    const-string v2, "FragmentManager"

    .line 7
    .line 8
    iget-object v3, p0, Landroidx/fragment/app/FragmentManager$1;->this$0:Landroidx/fragment/app/FragmentManager;

    .line 9
    .line 10
    if-eqz v1, :cond_0

    .line 11
    .line 12
    new-instance v1, Ljava/lang/StringBuilder;

    .line 13
    .line 14
    const-string v4, "handleOnBackProgressed. PREDICTIVE_BACK = true fragment manager "

    .line 15
    .line 16
    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 17
    .line 18
    .line 19
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 20
    .line 21
    .line 22
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v1

    .line 26
    invoke-static {v2, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    .line 28
    .line 29
    :cond_0
    iget-object v1, v3, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 30
    .line 31
    if-eqz v1, :cond_5

    .line 32
    .line 33
    new-instance v1, Ljava/util/ArrayList;

    .line 34
    .line 35
    iget-object v4, v3, Landroidx/fragment/app/FragmentManager;->mTransitioningOp:Landroidx/fragment/app/BackStackRecord;

    .line 36
    .line 37
    invoke-static {v4}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    .line 38
    .line 39
    .line 40
    move-result-object v4

    .line 41
    invoke-direct {v1, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 42
    .line 43
    .line 44
    const/4 v4, 0x0

    .line 45
    const/4 v5, 0x1

    .line 46
    invoke-virtual {v3, v1, v4, v5}, Landroidx/fragment/app/FragmentManager;->collectChangedControllers(Ljava/util/ArrayList;II)Ljava/util/HashSet;

    .line 47
    .line 48
    .line 49
    move-result-object v1

    .line 50
    invoke-virtual {v1}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 51
    .line 52
    .line 53
    move-result-object v1

    .line 54
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    .line 55
    .line 56
    .line 57
    move-result v5

    .line 58
    if-eqz v5, :cond_4

    .line 59
    .line 60
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 61
    .line 62
    .line 63
    move-result-object v5

    .line 64
    check-cast v5, Landroidx/fragment/app/DefaultSpecialEffectsController;

    .line 65
    .line 66
    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 67
    .line 68
    .line 69
    const-string v6, "backEvent"

    .line 70
    .line 71
    invoke-static {p1, v6}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 72
    .line 73
    .line 74
    invoke-static {v0}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 75
    .line 76
    .line 77
    move-result v6

    .line 78
    if-eqz v6, :cond_2

    .line 79
    .line 80
    new-instance v6, Ljava/lang/StringBuilder;

    .line 81
    .line 82
    const-string v7, "SpecialEffectsController: Processing Progress "

    .line 83
    .line 84
    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 85
    .line 86
    .line 87
    iget v7, p1, Landroidx/activity/BackEventCompat;->progress:F

    .line 88
    .line 89
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 90
    .line 91
    .line 92
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 93
    .line 94
    .line 95
    move-result-object v6

    .line 96
    invoke-static {v2, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    .line 98
    .line 99
    :cond_2
    iget-object v6, v5, Landroidx/fragment/app/DefaultSpecialEffectsController;->runningOperations:Ljava/util/ArrayList;

    .line 100
    .line 101
    new-instance v7, Ljava/util/ArrayList;

    .line 102
    .line 103
    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 104
    .line 105
    .line 106
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    .line 107
    .line 108
    .line 109
    move-result v8

    .line 110
    const/4 v9, 0x0

    .line 111
    :goto_0
    if-ge v9, v8, :cond_3

    .line 112
    .line 113
    invoke-virtual {v6, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 114
    .line 115
    .line 116
    move-result-object v10

    .line 117
    add-int/lit8 v9, v9, 0x1

    .line 118
    .line 119
    check-cast v10, Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;

    .line 120
    .line 121
    iget-object v10, v10, Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;->effects:Ljava/util/ArrayList;

    .line 122
    .line 123
    invoke-static {v10, v7}, Lkotlin/collections/CollectionsKt__MutableCollectionsKt;->addAll(Ljava/lang/Iterable;Ljava/util/AbstractCollection;)V

    .line 124
    .line 125
    .line 126
    goto :goto_0

    .line 127
    :cond_3
    invoke-static {v7}, Lkotlin/collections/CollectionsKt;->toSet(Ljava/util/ArrayList;)Ljava/util/Set;

    .line 128
    .line 129
    .line 130
    move-result-object v6

    .line 131
    invoke-static {v6}, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;

    .line 132
    .line 133
    .line 134
    move-result-object v6

    .line 135
    invoke-interface {v6}, Ljava/util/List;->size()I

    .line 136
    .line 137
    .line 138
    move-result v7

    .line 139
    const/4 v8, 0x0

    .line 140
    :goto_1
    if-ge v8, v7, :cond_1

    .line 141
    .line 142
    invoke-interface {v6, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 143
    .line 144
    .line 145
    move-result-object v9

    .line 146
    check-cast v9, Landroidx/fragment/app/SpecialEffectsController$Effect;

    .line 147
    .line 148
    iget-object v10, v5, Landroidx/fragment/app/DefaultSpecialEffectsController;->container:Landroid/view/ViewGroup;

    .line 149
    .line 150
    invoke-virtual {v9, p1, v10}, Landroidx/fragment/app/SpecialEffectsController$Effect;->onProgress(Landroidx/activity/BackEventCompat;Landroid/view/ViewGroup;)V

    .line 151
    .line 152
    .line 153
    add-int/lit8 v8, v8, 0x1

    .line 154
    .line 155
    goto :goto_1

    .line 156
    :cond_4
    iget-object v0, v3, Landroidx/fragment/app/FragmentManager;->mBackStackChangeListeners:Ljava/util/ArrayList;

    .line 157
    .line 158
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 159
    .line 160
    .line 161
    move-result v1

    .line 162
    :goto_2
    if-ge v4, v1, :cond_5

    .line 163
    .line 164
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 165
    .line 166
    .line 167
    move-result-object v2

    .line 168
    add-int/lit8 v4, v4, 0x1

    .line 169
    .line 170
    check-cast v2, Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;

    .line 171
    .line 172
    invoke-interface {v2, p1}, Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;->onBackStackChangeProgressed(Landroidx/activity/BackEventCompat;)V

    .line 173
    .line 174
    .line 175
    goto :goto_2

    .line 176
    :cond_5
    return-void
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

.method public final handleOnBackStarted(Landroidx/activity/BackEventCompat;)V
    .locals 2

    .line 1
    const/4 p1, 0x3

    .line 2
    invoke-static {p1}, Landroidx/fragment/app/FragmentManager;->isLoggingEnabled(I)Z

    .line 3
    .line 4
    .line 5
    move-result p1

    .line 6
    iget-object v0, p0, Landroidx/fragment/app/FragmentManager$1;->this$0:Landroidx/fragment/app/FragmentManager;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    new-instance p1, Ljava/lang/StringBuilder;

    .line 11
    .line 12
    const-string v1, "handleOnBackStarted. PREDICTIVE_BACK = true fragment manager "

    .line 13
    .line 14
    invoke-direct {p1, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 15
    .line 16
    .line 17
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 18
    .line 19
    .line 20
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 21
    .line 22
    .line 23
    move-result-object p1

    .line 24
    const-string v1, "FragmentManager"

    .line 25
    .line 26
    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 27
    .line 28
    .line 29
    :cond_0
    invoke-virtual {v0}, Landroidx/fragment/app/FragmentManager;->endAnimatingAwayFragments()V

    .line 30
    .line 31
    .line 32
    new-instance p1, Landroidx/fragment/app/FragmentManager$PrepareBackStackTransitionState;

    .line 33
    .line 34
    invoke-direct {p1, v0}, Landroidx/fragment/app/FragmentManager$PrepareBackStackTransitionState;-><init>(Landroidx/fragment/app/FragmentManager;)V

    .line 35
    .line 36
    .line 37
    const/4 v1, 0x0

    .line 38
    invoke-virtual {v0, p1, v1}, Landroidx/fragment/app/FragmentManager;->enqueueAction(Landroidx/fragment/app/FragmentManager$OpGenerator;Z)V

    .line 39
    .line 40
    .line 41
    return-void
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
