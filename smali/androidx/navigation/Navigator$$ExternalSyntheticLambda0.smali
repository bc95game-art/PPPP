.class public final synthetic Landroidx/navigation/Navigator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;

.field public final synthetic f$1:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p2, p0, Landroidx/navigation/Navigator$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Landroidx/navigation/Navigator$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    iput-object p3, p0, Landroidx/navigation/Navigator$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6

    .line 1
    iget v0, p0, Landroidx/navigation/Navigator$$ExternalSyntheticLambda0;->$r8$classId:I

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    iget-object v2, p0, Landroidx/navigation/Navigator$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    .line 5
    .line 6
    iget-object v3, p0, Landroidx/navigation/Navigator$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 7
    .line 8
    packed-switch v0, :pswitch_data_0

    .line 9
    .line 10
    .line 11
    check-cast v3, Landroidx/navigation/NavDestination;

    .line 12
    .line 13
    check-cast v2, Landroidx/navigation/NavController;

    .line 14
    .line 15
    iget-object v0, v2, Landroidx/navigation/NavController;->impl:Landroidx/navigation/internal/NavControllerImpl;

    .line 16
    .line 17
    check-cast p1, Landroidx/navigation/NavOptionsBuilder;

    .line 18
    .line 19
    const-string v2, "$this$navOptions"

    .line 20
    .line 21
    invoke-static {p1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 22
    .line 23
    .line 24
    iget-object v2, p1, Landroidx/navigation/NavOptionsBuilder;->builder:Landroidx/navigation/NavOptions$Builder;

    .line 25
    .line 26
    const/4 v4, 0x0

    .line 27
    iput v4, v2, Landroidx/navigation/NavOptions$Builder;->enterAnim:I

    .line 28
    .line 29
    iput v4, v2, Landroidx/navigation/NavOptions$Builder;->exitAnim:I

    .line 30
    .line 31
    instance-of v2, v3, Landroidx/navigation/NavGraph;

    .line 32
    .line 33
    if-eqz v2, :cond_5

    .line 34
    .line 35
    sget v2, Landroidx/navigation/NavDestination;->$r8$clinit:I

    .line 36
    .line 37
    new-instance v2, Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;

    .line 38
    .line 39
    const/4 v4, 0x4

    .line 40
    invoke-direct {v2, v4}, Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;-><init>(I)V

    .line 41
    .line 42
    .line 43
    invoke-static {v3, v2}, Lkotlin/sequences/SequencesKt;->generateSequence(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;

    .line 44
    .line 45
    .line 46
    move-result-object v2

    .line 47
    invoke-interface {v2}, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;

    .line 48
    .line 49
    .line 50
    move-result-object v2

    .line 51
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 52
    .line 53
    .line 54
    move-result v3

    .line 55
    if-eqz v3, :cond_2

    .line 56
    .line 57
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 58
    .line 59
    .line 60
    move-result-object v3

    .line 61
    check-cast v3, Landroidx/navigation/NavDestination;

    .line 62
    .line 63
    invoke-virtual {v0}, Landroidx/navigation/internal/NavControllerImpl;->getCurrentDestination$navigation_runtime_release()Landroidx/navigation/NavDestination;

    .line 64
    .line 65
    .line 66
    move-result-object v4

    .line 67
    if-eqz v4, :cond_1

    .line 68
    .line 69
    iget-object v4, v4, Landroidx/navigation/NavDestination;->parent:Landroidx/navigation/NavGraph;

    .line 70
    .line 71
    goto :goto_0

    .line 72
    :cond_1
    move-object v4, v1

    .line 73
    :goto_0
    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 74
    .line 75
    .line 76
    move-result v3

    .line 77
    if-eqz v3, :cond_0

    .line 78
    .line 79
    goto :goto_2

    .line 80
    :cond_2
    sget v1, Landroidx/navigation/NavGraph;->$r8$clinit:I

    .line 81
    .line 82
    invoke-virtual {v0}, Landroidx/navigation/internal/NavControllerImpl;->getGraph$navigation_runtime_release()Landroidx/navigation/NavGraph;

    .line 83
    .line 84
    .line 85
    move-result-object v0

    .line 86
    new-instance v1, Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;

    .line 87
    .line 88
    const/4 v2, 0x5

    .line 89
    invoke-direct {v1, v2}, Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;-><init>(I)V

    .line 90
    .line 91
    .line 92
    invoke-static {v0, v1}, Lkotlin/sequences/SequencesKt;->generateSequence(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;

    .line 93
    .line 94
    .line 95
    move-result-object v0

    .line 96
    invoke-interface {v0}, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;

    .line 97
    .line 98
    .line 99
    move-result-object v0

    .line 100
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 101
    .line 102
    .line 103
    move-result v1

    .line 104
    if-eqz v1, :cond_4

    .line 105
    .line 106
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 107
    .line 108
    .line 109
    move-result-object v1

    .line 110
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 111
    .line 112
    .line 113
    move-result v2

    .line 114
    if-eqz v2, :cond_3

    .line 115
    .line 116
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 117
    .line 118
    .line 119
    move-result-object v1

    .line 120
    goto :goto_1

    .line 121
    :cond_3
    check-cast v1, Landroidx/navigation/NavDestination;

    .line 122
    .line 123
    iget-object v0, v1, Landroidx/navigation/NavDestination;->impl:Landroidx/navigation/internal/NavDestinationImpl;

    .line 124
    .line 125
    iget v0, v0, Landroidx/navigation/internal/NavDestinationImpl;->id:I

    .line 126
    .line 127
    iput v0, p1, Landroidx/navigation/NavOptionsBuilder;->popUpToId:I

    .line 128
    .line 129
    const/4 v0, 0x1

    .line 130
    iput-boolean v0, p1, Landroidx/navigation/NavOptionsBuilder;->saveState:Z

    .line 131
    .line 132
    goto :goto_2

    .line 133
    :cond_4
    new-instance p1, Ljava/util/NoSuchElementException;

    .line 134
    .line 135
    const-string v0, "Sequence is empty."

    .line 136
    .line 137
    invoke-direct {p1, v0}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    .line 138
    .line 139
    .line 140
    throw p1

    .line 141
    :cond_5
    :goto_2
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    .line 142
    .line 143
    return-object p1

    .line 144
    :pswitch_0
    check-cast v3, Landroidx/navigation/Navigator;

    .line 145
    .line 146
    check-cast v2, Landroidx/navigation/NavOptions;

    .line 147
    .line 148
    check-cast p1, Landroidx/navigation/NavBackStackEntry;

    .line 149
    .line 150
    const-string v0, "backStackEntry"

    .line 151
    .line 152
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 153
    .line 154
    .line 155
    iget-object v0, p1, Landroidx/navigation/NavBackStackEntry;->impl:Landroidx/navigation/internal/NavBackStackEntryImpl;

    .line 156
    .line 157
    iget-object v4, p1, Landroidx/navigation/NavBackStackEntry;->destination:Landroidx/navigation/NavDestination;

    .line 158
    .line 159
    if-eqz v4, :cond_6

    .line 160
    .line 161
    goto :goto_3

    .line 162
    :cond_6
    move-object v4, v1

    .line 163
    :goto_3
    if-nez v4, :cond_7

    .line 164
    .line 165
    goto :goto_4

    .line 166
    :cond_7
    invoke-virtual {v0}, Landroidx/navigation/internal/NavBackStackEntryImpl;->getArguments$navigation_common_release()Landroid/os/Bundle;

    .line 167
    .line 168
    .line 169
    move-result-object v5

    .line 170
    invoke-virtual {v3, v4, v5, v2}, Landroidx/navigation/Navigator;->navigate(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;)Landroidx/navigation/NavDestination;

    .line 171
    .line 172
    .line 173
    move-result-object v2

    .line 174
    if-nez v2, :cond_8

    .line 175
    .line 176
    goto :goto_4

    .line 177
    :cond_8
    invoke-virtual {v2, v4}, Landroidx/navigation/NavDestination;->equals(Ljava/lang/Object;)Z

    .line 178
    .line 179
    .line 180
    move-result v1

    .line 181
    if-eqz v1, :cond_9

    .line 182
    .line 183
    move-object v1, p1

    .line 184
    goto :goto_4

    .line 185
    :cond_9
    invoke-virtual {v3}, Landroidx/navigation/Navigator;->getState()Landroidx/navigation/NavController$NavControllerNavigatorState;

    .line 186
    .line 187
    .line 188
    move-result-object p1

    .line 189
    invoke-virtual {v0}, Landroidx/navigation/internal/NavBackStackEntryImpl;->getArguments$navigation_common_release()Landroid/os/Bundle;

    .line 190
    .line 191
    .line 192
    move-result-object v0

    .line 193
    invoke-virtual {v2, v0}, Landroidx/navigation/NavDestination;->addInDefaultArgs(Landroid/os/Bundle;)Landroid/os/Bundle;

    .line 194
    .line 195
    .line 196
    move-result-object v0

    .line 197
    invoke-virtual {p1, v2, v0}, Landroidx/navigation/NavController$NavControllerNavigatorState;->createBackStackEntry(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;

    .line 198
    .line 199
    .line 200
    move-result-object v1

    .line 201
    :goto_4
    return-object v1

    .line 202
    nop

    .line 203
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
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
