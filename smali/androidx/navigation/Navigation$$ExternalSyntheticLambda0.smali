.class public final synthetic Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# instance fields
.field public final synthetic $r8$classId:I


# direct methods
.method public synthetic constructor <init>(I)V
    .locals 0

    .line 1
    iput p1, p0, Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    .line 1
    iget v0, p0, Landroidx/navigation/Navigation$$ExternalSyntheticLambda0;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    check-cast p1, Landroidx/navigation/NavDestination;

    .line 7
    .line 8
    const-string v0, "it"

    .line 9
    .line 10
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    iget-object p1, p1, Landroidx/navigation/NavDestination;->impl:Landroidx/navigation/internal/NavDestinationImpl;

    .line 14
    .line 15
    iget p1, p1, Landroidx/navigation/internal/NavDestinationImpl;->id:I

    .line 16
    .line 17
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    return-object p1

    .line 22
    :pswitch_0
    check-cast p1, Landroidx/navigation/NavDestination;

    .line 23
    .line 24
    const-string v0, "destination"

    .line 25
    .line 26
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    .line 28
    .line 29
    iget-object v0, p1, Landroidx/navigation/NavDestination;->parent:Landroidx/navigation/NavGraph;

    .line 30
    .line 31
    if-eqz v0, :cond_0

    .line 32
    .line 33
    iget-object v1, v0, Landroidx/navigation/NavGraph;->impl:Lcom/android/billingclient/api/zzca;

    .line 34
    .line 35
    iget v1, v1, Lcom/android/billingclient/api/zzca;->zzd:I

    .line 36
    .line 37
    iget-object p1, p1, Landroidx/navigation/NavDestination;->impl:Landroidx/navigation/internal/NavDestinationImpl;

    .line 38
    .line 39
    iget p1, p1, Landroidx/navigation/internal/NavDestinationImpl;->id:I

    .line 40
    .line 41
    if-ne v1, p1, :cond_0

    .line 42
    .line 43
    goto :goto_0

    .line 44
    :cond_0
    const/4 v0, 0x0

    .line 45
    :goto_0
    return-object v0

    .line 46
    :pswitch_1
    check-cast p1, Landroidx/navigation/NavDestination;

    .line 47
    .line 48
    const-string v0, "destination"

    .line 49
    .line 50
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 51
    .line 52
    .line 53
    iget-object v0, p1, Landroidx/navigation/NavDestination;->parent:Landroidx/navigation/NavGraph;

    .line 54
    .line 55
    if-eqz v0, :cond_1

    .line 56
    .line 57
    iget-object v1, v0, Landroidx/navigation/NavGraph;->impl:Lcom/android/billingclient/api/zzca;

    .line 58
    .line 59
    iget v1, v1, Lcom/android/billingclient/api/zzca;->zzd:I

    .line 60
    .line 61
    iget-object p1, p1, Landroidx/navigation/NavDestination;->impl:Landroidx/navigation/internal/NavDestinationImpl;

    .line 62
    .line 63
    iget p1, p1, Landroidx/navigation/internal/NavDestinationImpl;->id:I

    .line 64
    .line 65
    if-ne v1, p1, :cond_1

    .line 66
    .line 67
    goto :goto_1

    .line 68
    :cond_1
    const/4 v0, 0x0

    .line 69
    :goto_1
    return-object v0

    .line 70
    :pswitch_2
    check-cast p1, Landroidx/lifecycle/viewmodel/CreationExtras;

    .line 71
    .line 72
    const-string v0, "$this$initializer"

    .line 73
    .line 74
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 75
    .line 76
    .line 77
    new-instance v0, Landroidx/navigation/internal/NavBackStackEntryImpl$SavedStateViewModel;

    .line 78
    .line 79
    invoke-static {p1}, Landroidx/lifecycle/SavedStateHandleSupport;->createSavedStateHandle(Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/SavedStateHandle;

    .line 80
    .line 81
    .line 82
    move-result-object p1

    .line 83
    invoke-direct {v0, p1}, Landroidx/navigation/internal/NavBackStackEntryImpl$SavedStateViewModel;-><init>(Landroidx/lifecycle/SavedStateHandle;)V

    .line 84
    .line 85
    .line 86
    return-object v0

    .line 87
    :pswitch_3
    check-cast p1, Landroidx/lifecycle/viewmodel/CreationExtras;

    .line 88
    .line 89
    const-string v0, "$this$initializer"

    .line 90
    .line 91
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 92
    .line 93
    .line 94
    new-instance p1, Landroidx/navigation/fragment/FragmentNavigator$ClearEntryStateViewModel;

    .line 95
    .line 96
    invoke-direct {p1}, Landroidx/navigation/fragment/FragmentNavigator$ClearEntryStateViewModel;-><init>()V

    .line 97
    .line 98
    .line 99
    return-object p1

    .line 100
    :pswitch_4
    check-cast p1, Landroid/view/View;

    .line 101
    .line 102
    const-string v0, "it"

    .line 103
    .line 104
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 105
    .line 106
    .line 107
    const v0, 0x7f0a0226

    .line 108
    .line 109
    .line 110
    invoke-virtual {p1, v0}, Landroid/view/View;->getTag(I)Ljava/lang/Object;

    .line 111
    .line 112
    .line 113
    move-result-object p1

    .line 114
    instance-of v0, p1, Ljava/lang/ref/WeakReference;

    .line 115
    .line 116
    if-eqz v0, :cond_2

    .line 117
    .line 118
    check-cast p1, Ljava/lang/ref/WeakReference;

    .line 119
    .line 120
    invoke-virtual {p1}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 121
    .line 122
    .line 123
    move-result-object p1

    .line 124
    check-cast p1, Landroidx/navigation/NavController;

    .line 125
    .line 126
    goto :goto_2

    .line 127
    :cond_2
    instance-of v0, p1, Landroidx/navigation/NavController;

    .line 128
    .line 129
    if-eqz v0, :cond_3

    .line 130
    .line 131
    check-cast p1, Landroidx/navigation/NavController;

    .line 132
    .line 133
    goto :goto_2

    .line 134
    :cond_3
    const/4 p1, 0x0

    .line 135
    :goto_2
    return-object p1

    .line 136
    :pswitch_5
    check-cast p1, Landroidx/navigation/NavDestination;

    .line 137
    .line 138
    const-string v0, "it"

    .line 139
    .line 140
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 141
    .line 142
    .line 143
    instance-of v0, p1, Landroidx/navigation/NavGraph;

    .line 144
    .line 145
    if-eqz v0, :cond_4

    .line 146
    .line 147
    check-cast p1, Landroidx/navigation/NavGraph;

    .line 148
    .line 149
    iget-object v0, p1, Landroidx/navigation/NavGraph;->impl:Lcom/android/billingclient/api/zzca;

    .line 150
    .line 151
    iget v0, v0, Lcom/android/billingclient/api/zzca;->zzd:I

    .line 152
    .line 153
    invoke-virtual {p1, v0}, Landroidx/navigation/NavGraph;->findNode(I)Landroidx/navigation/NavDestination;

    .line 154
    .line 155
    .line 156
    move-result-object p1

    .line 157
    goto :goto_3

    .line 158
    :cond_4
    const/4 p1, 0x0

    .line 159
    :goto_3
    return-object p1

    .line 160
    :pswitch_6
    check-cast p1, Landroidx/navigation/NavDestination;

    .line 161
    .line 162
    const-string v0, "it"

    .line 163
    .line 164
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 165
    .line 166
    .line 167
    iget-object p1, p1, Landroidx/navigation/NavDestination;->parent:Landroidx/navigation/NavGraph;

    .line 168
    .line 169
    return-object p1

    .line 170
    :pswitch_7
    check-cast p1, Landroidx/lifecycle/viewmodel/CreationExtras;

    .line 171
    .line 172
    const-string v0, "$this$initializer"

    .line 173
    .line 174
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 175
    .line 176
    .line 177
    new-instance p1, Landroidx/navigation/NavControllerViewModel;

    .line 178
    .line 179
    invoke-direct {p1}, Landroidx/navigation/NavControllerViewModel;-><init>()V

    .line 180
    .line 181
    .line 182
    return-object p1

    .line 183
    :pswitch_8
    check-cast p1, Landroid/content/Context;

    .line 184
    .line 185
    const-string v0, "it"

    .line 186
    .line 187
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 188
    .line 189
    .line 190
    instance-of v0, p1, Landroid/content/ContextWrapper;

    .line 191
    .line 192
    if-eqz v0, :cond_5

    .line 193
    .line 194
    check-cast p1, Landroid/content/ContextWrapper;

    .line 195
    .line 196
    invoke-virtual {p1}, Landroid/content/ContextWrapper;->getBaseContext()Landroid/content/Context;

    .line 197
    .line 198
    .line 199
    move-result-object p1

    .line 200
    goto :goto_4

    .line 201
    :cond_5
    const/4 p1, 0x0

    .line 202
    :goto_4
    return-object p1

    .line 203
    :pswitch_9
    check-cast p1, Landroid/content/Context;

    .line 204
    .line 205
    const-string v0, "it"

    .line 206
    .line 207
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 208
    .line 209
    .line 210
    instance-of v0, p1, Landroid/content/ContextWrapper;

    .line 211
    .line 212
    if-eqz v0, :cond_6

    .line 213
    .line 214
    check-cast p1, Landroid/content/ContextWrapper;

    .line 215
    .line 216
    invoke-virtual {p1}, Landroid/content/ContextWrapper;->getBaseContext()Landroid/content/Context;

    .line 217
    .line 218
    .line 219
    move-result-object p1

    .line 220
    goto :goto_5

    .line 221
    :cond_6
    const/4 p1, 0x0

    .line 222
    :goto_5
    return-object p1

    .line 223
    :pswitch_a
    check-cast p1, Landroid/view/View;

    .line 224
    .line 225
    const-string v0, "it"

    .line 226
    .line 227
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 228
    .line 229
    .line 230
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    .line 231
    .line 232
    .line 233
    move-result-object p1

    .line 234
    instance-of v0, p1, Landroid/view/View;

    .line 235
    .line 236
    if-eqz v0, :cond_7

    .line 237
    .line 238
    check-cast p1, Landroid/view/View;

    .line 239
    .line 240
    goto :goto_6

    .line 241
    :cond_7
    const/4 p1, 0x0

    .line 242
    :goto_6
    return-object p1

    .line 243
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
