.class public final synthetic Landroidx/navigation/fragment/FragmentNavigator$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# instance fields
.field public final synthetic f$0:Landroidx/navigation/fragment/FragmentNavigator;

.field public final synthetic f$1:Landroidx/fragment/app/Fragment;

.field public final synthetic f$2:Landroidx/navigation/NavBackStackEntry;


# direct methods
.method public synthetic constructor <init>(Landroidx/navigation/fragment/FragmentNavigator;Landroidx/fragment/app/Fragment;Landroidx/navigation/NavBackStackEntry;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/navigation/fragment/FragmentNavigator$$ExternalSyntheticLambda4;->f$0:Landroidx/navigation/fragment/FragmentNavigator;

    iput-object p2, p0, Landroidx/navigation/fragment/FragmentNavigator$$ExternalSyntheticLambda4;->f$1:Landroidx/fragment/app/Fragment;

    iput-object p3, p0, Landroidx/navigation/fragment/FragmentNavigator$$ExternalSyntheticLambda4;->f$2:Landroidx/navigation/NavBackStackEntry;

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 8

    .line 1
    check-cast p1, Landroidx/lifecycle/LifecycleOwner;

    .line 2
    .line 3
    iget-object v0, p0, Landroidx/navigation/fragment/FragmentNavigator$$ExternalSyntheticLambda4;->f$0:Landroidx/navigation/fragment/FragmentNavigator;

    .line 4
    .line 5
    iget-object v1, v0, Landroidx/navigation/fragment/FragmentNavigator;->pendingOps:Ljava/util/ArrayList;

    .line 6
    .line 7
    iget-object v2, p0, Landroidx/navigation/fragment/FragmentNavigator$$ExternalSyntheticLambda4;->f$1:Landroidx/fragment/app/Fragment;

    .line 8
    .line 9
    const/4 v3, 0x0

    .line 10
    if-eqz v1, :cond_0

    .line 11
    .line 12
    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    .line 13
    .line 14
    .line 15
    move-result v4

    .line 16
    if-eqz v4, :cond_0

    .line 17
    .line 18
    goto :goto_0

    .line 19
    :cond_0
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 20
    .line 21
    .line 22
    move-result v4

    .line 23
    const/4 v5, 0x0

    .line 24
    :cond_1
    if-ge v5, v4, :cond_2

    .line 25
    .line 26
    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 27
    .line 28
    .line 29
    move-result-object v6

    .line 30
    add-int/lit8 v5, v5, 0x1

    .line 31
    .line 32
    check-cast v6, Lkotlin/Pair;

    .line 33
    .line 34
    iget-object v6, v6, Lkotlin/Pair;->first:Ljava/lang/Object;

    .line 35
    .line 36
    invoke-virtual {v2}, Landroidx/fragment/app/Fragment;->getTag()Ljava/lang/String;

    .line 37
    .line 38
    .line 39
    move-result-object v7

    .line 40
    invoke-static {v6, v7}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 41
    .line 42
    .line 43
    move-result v6

    .line 44
    if-eqz v6, :cond_1

    .line 45
    .line 46
    const/4 v3, 0x1

    .line 47
    :cond_2
    :goto_0
    if-eqz p1, :cond_3

    .line 48
    .line 49
    if-nez v3, :cond_3

    .line 50
    .line 51
    invoke-virtual {v2}, Landroidx/fragment/app/Fragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    .line 52
    .line 53
    .line 54
    move-result-object p1

    .line 55
    invoke-interface {p1}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    move-object v1, p1

    .line 60
    check-cast v1, Landroidx/lifecycle/LifecycleRegistry;

    .line 61
    .line 62
    iget-object v1, v1, Landroidx/lifecycle/LifecycleRegistry;->state:Landroidx/lifecycle/Lifecycle$State;

    .line 63
    .line 64
    sget-object v2, Landroidx/lifecycle/Lifecycle$State;->CREATED:Landroidx/lifecycle/Lifecycle$State;

    .line 65
    .line 66
    invoke-virtual {v1, v2}, Ljava/lang/Enum;->compareTo(Ljava/lang/Enum;)I

    .line 67
    .line 68
    .line 69
    move-result v1

    .line 70
    if-ltz v1, :cond_3

    .line 71
    .line 72
    iget-object v0, v0, Landroidx/navigation/fragment/FragmentNavigator;->fragmentViewObserver:Landroidx/navigation/NavDeepLink$$ExternalSyntheticLambda8;

    .line 73
    .line 74
    iget-object v1, p0, Landroidx/navigation/fragment/FragmentNavigator$$ExternalSyntheticLambda4;->f$2:Landroidx/navigation/NavBackStackEntry;

    .line 75
    .line 76
    invoke-virtual {v0, v1}, Landroidx/navigation/NavDeepLink$$ExternalSyntheticLambda8;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    .line 78
    .line 79
    move-result-object v0

    .line 80
    check-cast v0, Landroidx/lifecycle/LifecycleObserver;

    .line 81
    .line 82
    invoke-virtual {p1, v0}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    .line 83
    .line 84
    .line 85
    :cond_3
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    .line 86
    .line 87
    return-object p1
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
