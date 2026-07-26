.class public final synthetic Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;

.field public final synthetic f$1:Ljava/lang/Object;

.field public final synthetic f$2:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Landroid/view/View;Lcom/emanuelef/remote_capture/activities/AboutActivity;Ljava/lang/String;)V
    .locals 1

    .line 1
    const/4 v0, 0x4

    iput v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    iput-object p1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    return-void
.end method

.method public synthetic constructor <init>(Lcom/google/android/datatransport/runtime/scheduling/DefaultScheduler;Lcom/google/android/datatransport/runtime/AutoValue_TransportContext;Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;Lcom/google/android/datatransport/runtime/AutoValue_EventInternal;)V
    .locals 0

    .line 2
    const/4 p3, 0x7

    iput p3, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    iput-object p4, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;I)V
    .locals 0

    .line 3
    iput p4, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 7

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lcom/google/android/datatransport/runtime/scheduling/DefaultScheduler;

    .line 9
    .line 10
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    .line 11
    .line 12
    check-cast v1, Lcom/google/android/datatransport/runtime/AutoValue_TransportContext;

    .line 13
    .line 14
    iget-object v2, v1, Lcom/google/android/datatransport/runtime/AutoValue_TransportContext;->backendName:Ljava/lang/String;

    .line 15
    .line 16
    iget-object v3, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    .line 17
    .line 18
    check-cast v3, Lcom/google/android/datatransport/runtime/AutoValue_EventInternal;

    .line 19
    .line 20
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 21
    .line 22
    .line 23
    sget-object v4, Lcom/google/android/datatransport/runtime/scheduling/DefaultScheduler;->LOGGER:Ljava/util/logging/Logger;

    .line 24
    .line 25
    const-string v5, "Transport backend \'"

    .line 26
    .line 27
    :try_start_0
    iget-object v6, v0, Lcom/google/android/datatransport/runtime/scheduling/DefaultScheduler;->backendRegistry:Lcom/google/android/datatransport/runtime/backends/MetadataBackendRegistry;

    .line 28
    .line 29
    invoke-virtual {v6, v2}, Lcom/google/android/datatransport/runtime/backends/MetadataBackendRegistry;->get(Ljava/lang/String;)Lcom/google/android/datatransport/runtime/backends/TransportBackend;

    .line 30
    .line 31
    .line 32
    move-result-object v6

    .line 33
    if-nez v6, :cond_0

    .line 34
    .line 35
    new-instance v0, Ljava/lang/StringBuilder;

    .line 36
    .line 37
    invoke-direct {v0, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 38
    .line 39
    .line 40
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 41
    .line 42
    .line 43
    const-string v1, "\' is not registered"

    .line 44
    .line 45
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 46
    .line 47
    .line 48
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 49
    .line 50
    .line 51
    move-result-object v0

    .line 52
    invoke-virtual {v4, v0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    .line 53
    .line 54
    .line 55
    new-instance v1, Ljava/lang/IllegalArgumentException;

    .line 56
    .line 57
    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    goto :goto_1

    .line 61
    :catch_0
    move-exception v0

    .line 62
    goto :goto_0

    .line 63
    :cond_0
    check-cast v6, Lcom/google/android/datatransport/cct/CctTransportBackend;

    .line 64
    .line 65
    invoke-virtual {v6, v3}, Lcom/google/android/datatransport/cct/CctTransportBackend;->decorate(Lcom/google/android/datatransport/runtime/AutoValue_EventInternal;)Lcom/google/android/datatransport/runtime/AutoValue_EventInternal;

    .line 66
    .line 67
    .line 68
    move-result-object v2

    .line 69
    iget-object v3, v0, Lcom/google/android/datatransport/runtime/scheduling/DefaultScheduler;->guard:Lcom/google/android/datatransport/runtime/synchronization/SynchronizationGuard;

    .line 70
    .line 71
    new-instance v5, Landroidx/transition/FragmentTransitionSupport$$ExternalSyntheticLambda0;

    .line 72
    .line 73
    const/4 v6, 0x1

    .line 74
    invoke-direct {v5, v0, v1, v2, v6}, Landroidx/transition/FragmentTransitionSupport$$ExternalSyntheticLambda0;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;I)V

    .line 75
    .line 76
    .line 77
    check-cast v3, Lcom/google/android/datatransport/runtime/scheduling/persistence/SQLiteEventStore;

    .line 78
    .line 79
    invoke-virtual {v3, v5}, Lcom/google/android/datatransport/runtime/scheduling/persistence/SQLiteEventStore;->runCriticalSection(Lcom/google/android/datatransport/runtime/synchronization/SynchronizationGuard$CriticalSection;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 80
    .line 81
    .line 82
    goto :goto_1

    .line 83
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    .line 84
    .line 85
    const-string v2, "Error scheduling event "

    .line 86
    .line 87
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 88
    .line 89
    .line 90
    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    .line 91
    .line 92
    .line 93
    move-result-object v0

    .line 94
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 95
    .line 96
    .line 97
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 98
    .line 99
    .line 100
    move-result-object v0

    .line 101
    invoke-virtual {v4, v0}, Ljava/util/logging/Logger;->warning(Ljava/lang/String;)V

    .line 102
    .line 103
    .line 104
    :goto_1
    return-void

    .line 105
    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    .line 106
    .line 107
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;

    .line 108
    .line 109
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    .line 110
    .line 111
    check-cast v1, Landroid/content/Context;

    .line 112
    .line 113
    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    .line 114
    .line 115
    check-cast v2, Landroid/os/Handler;

    .line 116
    .line 117
    invoke-static {v0, v1, v2}, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;->$r8$lambda$RLbyKJ5HLIZ_W4m6IlcCIHUXXdk(Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings;Landroid/content/Context;Landroid/os/Handler;)V

    .line 118
    .line 119
    .line 120
    return-void

    .line 121
    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    .line 122
    .line 123
    check-cast v0, Lcom/emanuelef/remote_capture/activities/AboutActivity;

    .line 124
    .line 125
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    .line 126
    .line 127
    check-cast v1, Ljava/lang/Exception;

    .line 128
    .line 129
    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    .line 130
    .line 131
    check-cast v2, Landroid/view/View;

    .line 132
    .line 133
    invoke-static {v0, v1, v2}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$2G9QZue6xvjM-1BaxOWpQMqYr8o(Lcom/emanuelef/remote_capture/activities/AboutActivity;Ljava/lang/Exception;Landroid/view/View;)V

    .line 134
    .line 135
    .line 136
    return-void

    .line 137
    :pswitch_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    .line 138
    .line 139
    check-cast v0, Lcom/emanuelef/remote_capture/activities/AboutActivity;

    .line 140
    .line 141
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    .line 142
    .line 143
    check-cast v1, Landroid/view/View;

    .line 144
    .line 145
    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    .line 146
    .line 147
    check-cast v2, Ljava/lang/String;

    .line 148
    .line 149
    invoke-static {v1, v0, v2}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$hxMKVWVtuaDKOqFLdNbqvNJDtkE(Landroid/view/View;Lcom/emanuelef/remote_capture/activities/AboutActivity;Ljava/lang/String;)V

    .line 150
    .line 151
    .line 152
    return-void

    .line 153
    :pswitch_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    .line 154
    .line 155
    check-cast v0, Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;

    .line 156
    .line 157
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    .line 158
    .line 159
    check-cast v1, Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;

    .line 160
    .line 161
    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    .line 162
    .line 163
    check-cast v2, Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect;

    .line 164
    .line 165
    iget-object v0, v0, Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;->fragment:Landroidx/fragment/app/Fragment;

    .line 166
    .line 167
    iget-object v1, v1, Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;->fragment:Landroidx/fragment/app/Fragment;

    .line 168
    .line 169
    iget-boolean v2, v2, Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect;->isPop:Z

    .line 170
    .line 171
    sget-object v3, Landroidx/fragment/app/FragmentTransition;->PLATFORM_IMPL:Landroidx/fragment/app/FragmentTransitionCompat21;

    .line 172
    .line 173
    const-string v3, "inFragment"

    .line 174
    .line 175
    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 176
    .line 177
    .line 178
    const-string v3, "outFragment"

    .line 179
    .line 180
    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 181
    .line 182
    .line 183
    if-eqz v2, :cond_1

    .line 184
    .line 185
    invoke-virtual {v1}, Landroidx/fragment/app/Fragment;->getEnterTransitionCallback()Landroidx/core/app/SharedElementCallback;

    .line 186
    .line 187
    .line 188
    goto :goto_2

    .line 189
    :cond_1
    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->getEnterTransitionCallback()Landroidx/core/app/SharedElementCallback;

    .line 190
    .line 191
    .line 192
    :goto_2
    return-void

    .line 193
    :pswitch_4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    .line 194
    .line 195
    check-cast v0, Landroid/view/ViewGroup;

    .line 196
    .line 197
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    .line 198
    .line 199
    check-cast v1, Landroid/view/View;

    .line 200
    .line 201
    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    .line 202
    .line 203
    check-cast v2, Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationEffect;

    .line 204
    .line 205
    const-string v3, "$container"

    .line 206
    .line 207
    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 208
    .line 209
    .line 210
    const-string v3, "this$0"

    .line 211
    .line 212
    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 213
    .line 214
    .line 215
    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->endViewTransition(Landroid/view/View;)V

    .line 216
    .line 217
    .line 218
    iget-object v0, v2, Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationEffect;->animationInfo:Landroidx/fragment/app/DefaultSpecialEffectsController$AnimationInfo;

    .line 219
    .line 220
    iget-object v0, v0, Landroidx/fragment/app/DefaultSpecialEffectsController$SpecialEffectsInfo;->operation:Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;

    .line 221
    .line 222
    invoke-virtual {v0, v2}, Landroidx/fragment/app/SpecialEffectsController$FragmentStateManagerOperation;->completeEffect(Landroidx/fragment/app/SpecialEffectsController$Effect;)V

    .line 223
    .line 224
    .line 225
    return-void

    .line 226
    :pswitch_5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    .line 227
    .line 228
    check-cast v0, Landroidx/navigation/internal/NavContext;

    .line 229
    .line 230
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    .line 231
    .line 232
    check-cast v1, Landroidx/navigation/Navigation;

    .line 233
    .line 234
    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    .line 235
    .line 236
    check-cast v2, Ljava/util/concurrent/ThreadPoolExecutor;

    .line 237
    .line 238
    :try_start_1
    iget-object v0, v0, Landroidx/navigation/internal/NavContext;->context:Landroid/content/Context;

    .line 239
    .line 240
    invoke-static {v0}, Landroidx/navigation/Navigation;->create(Landroid/content/Context;)Landroidx/emoji2/text/FontRequestEmojiCompatConfig;

    .line 241
    .line 242
    .line 243
    move-result-object v0

    .line 244
    if-eqz v0, :cond_2

    .line 245
    .line 246
    iget-object v3, v0, Landroidx/emoji2/text/FontRequestEmojiCompatConfig;->mMetadataLoader:Landroidx/emoji2/text/EmojiCompat$MetadataRepoLoader;

    .line 247
    .line 248
    check-cast v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;

    .line 249
    .line 250
    iget-object v4, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mLock:Ljava/lang/Object;

    .line 251
    .line 252
    monitor-enter v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 253
    :try_start_2
    iput-object v2, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mExecutor:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 254
    .line 255
    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 256
    :try_start_3
    iget-object v0, v0, Landroidx/emoji2/text/FontRequestEmojiCompatConfig;->mMetadataLoader:Landroidx/emoji2/text/EmojiCompat$MetadataRepoLoader;

    .line 257
    .line 258
    new-instance v3, Landroidx/emoji2/text/EmojiCompatInitializer$BackgroundDefaultLoader$1;

    .line 259
    .line 260
    invoke-direct {v3, v1, v2}, Landroidx/emoji2/text/EmojiCompatInitializer$BackgroundDefaultLoader$1;-><init>(Landroidx/navigation/Navigation;Ljava/util/concurrent/ThreadPoolExecutor;)V

    .line 261
    .line 262
    .line 263
    invoke-interface {v0, v3}, Landroidx/emoji2/text/EmojiCompat$MetadataRepoLoader;->load(Landroidx/navigation/Navigation;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 264
    .line 265
    .line 266
    goto :goto_4

    .line 267
    :catchall_0
    move-exception v0

    .line 268
    goto :goto_3

    .line 269
    :catchall_1
    move-exception v0

    .line 270
    :try_start_4
    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 271
    :try_start_5
    throw v0

    .line 272
    :cond_2
    new-instance v0, Ljava/lang/RuntimeException;

    .line 273
    .line 274
    const-string v3, "EmojiCompat font provider not available on this device."

    .line 275
    .line 276
    invoke-direct {v0, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 277
    .line 278
    .line 279
    throw v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 280
    :goto_3
    invoke-virtual {v1, v0}, Landroidx/navigation/Navigation;->onFailed(Ljava/lang/Throwable;)V

    .line 281
    .line 282
    .line 283
    invoke-virtual {v2}, Ljava/util/concurrent/ThreadPoolExecutor;->shutdown()V

    .line 284
    .line 285
    .line 286
    :goto_4
    return-void

    .line 287
    :pswitch_6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$0:Ljava/lang/Object;

    .line 288
    .line 289
    check-cast v0, Lcom/emanuelef/remote_capture/PlayBilling;

    .line 290
    .line 291
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$1:Ljava/lang/Object;

    .line 292
    .line 293
    check-cast v1, Ljava/lang/String;

    .line 294
    .line 295
    iget-object v2, p0, Lcom/emanuelef/remote_capture/PlayBilling$$ExternalSyntheticLambda23;->f$2:Ljava/lang/Object;

    .line 296
    .line 297
    check-cast v2, Lcom/emanuelef/remote_capture/PlayBilling$QrActivationRequest;

    .line 298
    .line 299
    invoke-static {v0, v1, v2}, Lcom/emanuelef/remote_capture/PlayBilling;->$r8$lambda$nVWtBMtZNIvPEitJjJRf6kv22KM(Lcom/emanuelef/remote_capture/PlayBilling;Ljava/lang/String;Lcom/emanuelef/remote_capture/PlayBilling$QrActivationRequest;)V

    .line 300
    .line 301
    .line 302
    return-void

    .line 303
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
