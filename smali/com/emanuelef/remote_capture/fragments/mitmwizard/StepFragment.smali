.class public Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;
.super Landroidx/fragment/app/Fragment;
.source "SourceFile"


# instance fields
.field protected mDangerColor:I

.field protected mNavController:Landroidx/navigation/NavController;

.field protected mOkColor:I

.field protected mSkipButton:Landroid/widget/Button;

.field protected mStepButton:Landroid/widget/Button;

.field protected mStepIcon:Landroid/widget/ImageView;

.field protected mStepLabel:Landroid/widget/TextView;

.field protected mWarnColor:I


# direct methods
.method public static synthetic $r8$lambda$BH6aI_544mlIrPbj7ctUS9kbNzU(Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;ILandroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->lambda$nextStep$0(ILandroid/view/View;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V

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
    .line 58
.end method

.method private synthetic lambda$nextStep$0(ILandroid/view/View;)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->gotoStep(I)V

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
.method public gotoStep(I)V
    .locals 12

    .line 1
    if-gtz p1, :cond_0

    .line 2
    .line 3
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    invoke-virtual {p1}, Landroid/app/Activity;->finish()V

    .line 8
    .line 9
    .line 10
    return-void

    .line 11
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mNavController:Landroidx/navigation/NavController;

    .line 12
    .line 13
    iget-object v1, v0, Landroidx/navigation/NavController;->navContext:Landroidx/navigation/internal/NavContext;

    .line 14
    .line 15
    iget-object v2, v0, Landroidx/navigation/NavController;->impl:Landroidx/navigation/internal/NavControllerImpl;

    .line 16
    .line 17
    iget-object v3, v2, Landroidx/navigation/internal/NavControllerImpl;->backQueue:Lkotlin/collections/ArrayDeque;

    .line 18
    .line 19
    invoke-virtual {v3}, Lkotlin/collections/ArrayDeque;->isEmpty()Z

    .line 20
    .line 21
    .line 22
    move-result v3

    .line 23
    if-eqz v3, :cond_1

    .line 24
    .line 25
    iget-object v3, v2, Landroidx/navigation/internal/NavControllerImpl;->_graph:Landroidx/navigation/NavGraph;

    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_1
    iget-object v3, v2, Landroidx/navigation/internal/NavControllerImpl;->backQueue:Lkotlin/collections/ArrayDeque;

    .line 29
    .line 30
    invoke-virtual {v3}, Lkotlin/collections/ArrayDeque;->last()Ljava/lang/Object;

    .line 31
    .line 32
    .line 33
    move-result-object v3

    .line 34
    check-cast v3, Landroidx/navigation/NavBackStackEntry;

    .line 35
    .line 36
    iget-object v3, v3, Landroidx/navigation/NavBackStackEntry;->destination:Landroidx/navigation/NavDestination;

    .line 37
    .line 38
    :goto_0
    if-eqz v3, :cond_a

    .line 39
    .line 40
    invoke-virtual {v3, p1}, Landroidx/navigation/NavDestination;->getAction(I)Landroidx/navigation/NavAction;

    .line 41
    .line 42
    .line 43
    move-result-object v0

    .line 44
    const/4 v4, 0x0

    .line 45
    const/4 v5, 0x0

    .line 46
    if-eqz v0, :cond_3

    .line 47
    .line 48
    iget-object v6, v0, Landroidx/navigation/NavAction;->navOptions:Landroidx/navigation/NavOptions;

    .line 49
    .line 50
    iget v7, v0, Landroidx/navigation/NavAction;->destinationId:I

    .line 51
    .line 52
    iget-object v8, v0, Landroidx/navigation/NavAction;->defaultArguments:Landroid/os/Bundle;

    .line 53
    .line 54
    if-eqz v8, :cond_2

    .line 55
    .line 56
    new-array v9, v4, [Lkotlin/Pair;

    .line 57
    .line 58
    invoke-static {v9, v4}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    .line 59
    .line 60
    .line 61
    move-result-object v9

    .line 62
    check-cast v9, [Lkotlin/Pair;

    .line 63
    .line 64
    invoke-static {v9}, Landroidx/core/os/BundleKt;->bundleOf([Lkotlin/Pair;)Landroid/os/Bundle;

    .line 65
    .line 66
    .line 67
    move-result-object v9

    .line 68
    invoke-virtual {v9, v8}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 69
    .line 70
    .line 71
    goto :goto_1

    .line 72
    :cond_2
    move-object v9, v5

    .line 73
    goto :goto_1

    .line 74
    :cond_3
    move v7, p1

    .line 75
    move-object v6, v5

    .line 76
    move-object v9, v6

    .line 77
    :goto_1
    if-nez v7, :cond_6

    .line 78
    .line 79
    if-eqz v6, :cond_6

    .line 80
    .line 81
    iget-boolean v8, v6, Landroidx/navigation/NavOptions;->popUpToInclusive:Z

    .line 82
    .line 83
    iget v10, v6, Landroidx/navigation/NavOptions;->popUpToId:I

    .line 84
    .line 85
    const/4 v11, -0x1

    .line 86
    if-ne v10, v11, :cond_4

    .line 87
    .line 88
    goto :goto_2

    .line 89
    :cond_4
    if-eq v10, v11, :cond_5

    .line 90
    .line 91
    invoke-virtual {v2, v10, v8, v4}, Landroidx/navigation/internal/NavControllerImpl;->popBackStackInternal$navigation_runtime_release(IZZ)Z

    .line 92
    .line 93
    .line 94
    move-result p1

    .line 95
    if-eqz p1, :cond_5

    .line 96
    .line 97
    invoke-virtual {v2}, Landroidx/navigation/internal/NavControllerImpl;->dispatchOnDestinationChanged$navigation_runtime_release()Z

    .line 98
    .line 99
    .line 100
    :cond_5
    return-void

    .line 101
    :cond_6
    :goto_2
    if-eqz v7, :cond_9

    .line 102
    .line 103
    invoke-virtual {v2, v7, v5}, Landroidx/navigation/internal/NavControllerImpl;->findDestination$navigation_runtime_release(ILandroidx/navigation/NavDestination;)Landroidx/navigation/NavDestination;

    .line 104
    .line 105
    .line 106
    move-result-object v4

    .line 107
    if-nez v4, :cond_8

    .line 108
    .line 109
    sget v2, Landroidx/navigation/NavDestination;->$r8$clinit:I

    .line 110
    .line 111
    invoke-static {v1, v7}, Landroidx/navigation/Navigation;->getDisplayName(Landroidx/navigation/internal/NavContext;I)Ljava/lang/String;

    .line 112
    .line 113
    .line 114
    move-result-object v2

    .line 115
    const-string v4, " cannot be found from the current destination "

    .line 116
    .line 117
    if-nez v0, :cond_7

    .line 118
    .line 119
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 120
    .line 121
    new-instance v0, Ljava/lang/StringBuilder;

    .line 122
    .line 123
    const-string v1, "Navigation action/destination "

    .line 124
    .line 125
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 126
    .line 127
    .line 128
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 129
    .line 130
    .line 131
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 132
    .line 133
    .line 134
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 135
    .line 136
    .line 137
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 138
    .line 139
    .line 140
    move-result-object v0

    .line 141
    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 142
    .line 143
    .line 144
    throw p1

    .line 145
    :cond_7
    const-string v0, "Navigation destination "

    .line 146
    .line 147
    const-string v5, " referenced from action "

    .line 148
    .line 149
    invoke-static {v0, v2, v5}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 150
    .line 151
    .line 152
    move-result-object v0

    .line 153
    invoke-static {v1, p1}, Landroidx/navigation/Navigation;->getDisplayName(Landroidx/navigation/internal/NavContext;I)Ljava/lang/String;

    .line 154
    .line 155
    .line 156
    move-result-object p1

    .line 157
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 158
    .line 159
    .line 160
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 161
    .line 162
    .line 163
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 164
    .line 165
    .line 166
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 167
    .line 168
    .line 169
    move-result-object p1

    .line 170
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 171
    .line 172
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 173
    .line 174
    .line 175
    move-result-object p1

    .line 176
    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 177
    .line 178
    .line 179
    throw v0

    .line 180
    :cond_8
    invoke-virtual {v2, v4, v9, v6}, Landroidx/navigation/internal/NavControllerImpl;->navigate$navigation_runtime_release(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;)V

    .line 181
    .line 182
    .line 183
    return-void

    .line 184
    :cond_9
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 185
    .line 186
    const-string v0, "Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo"

    .line 187
    .line 188
    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 189
    .line 190
    .line 191
    throw p1

    .line 192
    :cond_a
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 193
    .line 194
    new-instance v1, Ljava/lang/StringBuilder;

    .line 195
    .line 196
    const-string v2, "No current destination found. Ensure a navigation graph has been set for NavController "

    .line 197
    .line 198
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 199
    .line 200
    .line 201
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 202
    .line 203
    .line 204
    const/16 v0, 0x2e

    .line 205
    .line 206
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 207
    .line 208
    .line 209
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 210
    .line 211
    .line 212
    move-result-object v0

    .line 213
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 214
    .line 215
    .line 216
    throw p1
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

.method public nextStep(I)V
    .locals 5

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const/4 v1, 0x1

    .line 6
    if-gtz p1, :cond_0

    .line 7
    .line 8
    const/4 v2, 0x1

    .line 9
    goto :goto_0

    .line 10
    :cond_0
    const/4 v2, 0x0

    .line 11
    :goto_0
    iget-object v3, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepIcon:Landroid/widget/ImageView;

    .line 12
    .line 13
    const v4, 0x7f080194

    .line 14
    .line 15
    .line 16
    invoke-static {v0, v4}, Landroidx/core/os/BundleKt;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 21
    .line 22
    .line 23
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepIcon:Landroid/widget/ImageView;

    .line 24
    .line 25
    iget v3, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mOkColor:I

    .line 26
    .line 27
    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setColorFilter(I)V

    .line 28
    .line 29
    .line 30
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mSkipButton:Landroid/widget/Button;

    .line 31
    .line 32
    const/16 v3, 0x8

    .line 33
    .line 34
    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 35
    .line 36
    .line 37
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 38
    .line 39
    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 40
    .line 41
    .line 42
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 43
    .line 44
    if-nez v2, :cond_1

    .line 45
    .line 46
    const v1, 0x7f140039

    .line 47
    .line 48
    .line 49
    goto :goto_1

    .line 50
    :cond_1
    const v1, 0x7f140034

    .line 51
    .line 52
    .line 53
    :goto_1
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 54
    .line 55
    .line 56
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 57
    .line 58
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;

    .line 59
    .line 60
    const/4 v2, 0x1

    .line 61
    invoke-direct {v1, p1, v2, p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview$$ExternalSyntheticLambda0;-><init>(IILandroidx/fragment/app/Fragment;)V

    .line 62
    .line 63
    .line 64
    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    .line 66
    .line 67
    return-void
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
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    .line 1
    const p3, 0x7f0d0049

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    return-object p1
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
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .line 1
    invoke-super {p0, p1, p2}, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    invoke-static {p1}, Landroidx/navigation/Navigation;->findNavController(Landroid/view/View;)Landroidx/navigation/NavController;

    .line 5
    .line 6
    .line 7
    move-result-object p2

    .line 8
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mNavController:Landroidx/navigation/NavController;

    .line 9
    .line 10
    const p2, 0x7f0a0325

    .line 11
    .line 12
    .line 13
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 14
    .line 15
    .line 16
    move-result-object p2

    .line 17
    check-cast p2, Landroid/widget/TextView;

    .line 18
    .line 19
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepLabel:Landroid/widget/TextView;

    .line 20
    .line 21
    const p2, 0x7f0a0326

    .line 22
    .line 23
    .line 24
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 25
    .line 26
    .line 27
    move-result-object p2

    .line 28
    check-cast p2, Landroid/widget/ImageView;

    .line 29
    .line 30
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepIcon:Landroid/widget/ImageView;

    .line 31
    .line 32
    const p2, 0x7f0a0324

    .line 33
    .line 34
    .line 35
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 36
    .line 37
    .line 38
    move-result-object p2

    .line 39
    check-cast p2, Landroid/widget/Button;

    .line 40
    .line 41
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 42
    .line 43
    const p2, 0x7f0a02f5

    .line 44
    .line 45
    .line 46
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 47
    .line 48
    .line 49
    move-result-object p1

    .line 50
    check-cast p1, Landroid/widget/Button;

    .line 51
    .line 52
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mSkipButton:Landroid/widget/Button;

    .line 53
    .line 54
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 55
    .line 56
    .line 57
    move-result-object p1

    .line 58
    const p2, 0x7f0603c1

    .line 59
    .line 60
    .line 61
    invoke-static {p1, p2}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 62
    .line 63
    .line 64
    move-result p2

    .line 65
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mOkColor:I

    .line 66
    .line 67
    const p2, 0x7f0603e0

    .line 68
    .line 69
    .line 70
    invoke-static {p1, p2}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 71
    .line 72
    .line 73
    move-result p2

    .line 74
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mWarnColor:I

    .line 75
    .line 76
    const p2, 0x7f060050

    .line 77
    .line 78
    .line 79
    invoke-static {p1, p2}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 80
    .line 81
    .line 82
    move-result p1

    .line 83
    iput p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mDangerColor:I

    .line 84
    .line 85
    return-void
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

.method public showSkipButton(Landroid/view/View$OnClickListener;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mSkipButton:Landroid/widget/Button;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 5
    .line 6
    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mSkipButton:Landroid/widget/Button;

    .line 8
    .line 9
    invoke-virtual {v0, p1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

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
.end method
