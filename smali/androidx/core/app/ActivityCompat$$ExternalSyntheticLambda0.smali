.class public final synthetic Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p2, p0, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 36

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    iget v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->$r8$classId:I

    .line 4
    .line 5
    const/4 v2, 0x2

    .line 6
    const/4 v4, 0x0

    .line 7
    const/4 v5, 0x1

    .line 8
    packed-switch v0, :pswitch_data_0

    .line 9
    .line 10
    .line 11
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 12
    .line 13
    check-cast v0, Lcom/google/android/material/textfield/TextInputLayout;

    .line 14
    .line 15
    iget-object v0, v0, Lcom/google/android/material/textfield/TextInputLayout;->editText:Landroid/widget/EditText;

    .line 16
    .line 17
    invoke-virtual {v0}, Landroid/view/View;->requestLayout()V

    .line 18
    .line 19
    .line 20
    return-void

    .line 21
    :pswitch_0
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 22
    .line 23
    check-cast v0, Lcom/google/android/material/textfield/DropdownMenuEndIconDelegate;

    .line 24
    .line 25
    iget-object v2, v0, Lcom/google/android/material/textfield/DropdownMenuEndIconDelegate;->autoCompleteTextView:Landroid/widget/AutoCompleteTextView;

    .line 26
    .line 27
    invoke-virtual {v2}, Landroid/widget/AutoCompleteTextView;->isPopupShowing()Z

    .line 28
    .line 29
    .line 30
    move-result v2

    .line 31
    invoke-virtual {v0, v2}, Lcom/google/android/material/textfield/DropdownMenuEndIconDelegate;->setEndIconChecked(Z)V

    .line 32
    .line 33
    .line 34
    iput-boolean v2, v0, Lcom/google/android/material/textfield/DropdownMenuEndIconDelegate;->dropdownPopupDirty:Z

    .line 35
    .line 36
    return-void

    .line 37
    :pswitch_1
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 38
    .line 39
    check-cast v0, Lcom/google/android/material/textfield/ClearTextEndIconDelegate;

    .line 40
    .line 41
    invoke-virtual {v0, v5}, Lcom/google/android/material/textfield/ClearTextEndIconDelegate;->animateIcon(Z)V

    .line 42
    .line 43
    .line 44
    return-void

    .line 45
    :pswitch_2
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 46
    .line 47
    check-cast v0, Lcom/google/android/material/slider/Slider;

    .line 48
    .line 49
    const/4 v2, -0x1

    .line 50
    invoke-virtual {v0, v2}, Lcom/google/android/material/slider/BaseSlider;->setActiveThumbIndex(I)V

    .line 51
    .line 52
    .line 53
    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    .line 54
    .line 55
    .line 56
    return-void

    .line 57
    :pswitch_3
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 58
    .line 59
    check-cast v0, Lcom/google/android/material/sidesheet/SideSheetBehavior$StateSettlingTracker;

    .line 60
    .line 61
    iput-boolean v4, v0, Lcom/google/android/material/sidesheet/SideSheetBehavior$StateSettlingTracker;->isContinueSettlingRunnablePosted:Z

    .line 62
    .line 63
    iget-object v3, v0, Lcom/google/android/material/sidesheet/SideSheetBehavior$StateSettlingTracker;->this$0:Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;

    .line 64
    .line 65
    check-cast v3, Lcom/google/android/material/sidesheet/SideSheetBehavior;

    .line 66
    .line 67
    iget-object v4, v3, Lcom/google/android/material/sidesheet/SideSheetBehavior;->viewDragHelper:Landroidx/customview/widget/ViewDragHelper;

    .line 68
    .line 69
    if-eqz v4, :cond_0

    .line 70
    .line 71
    invoke-virtual {v4}, Landroidx/customview/widget/ViewDragHelper;->continueSettling()Z

    .line 72
    .line 73
    .line 74
    move-result v4

    .line 75
    if-eqz v4, :cond_0

    .line 76
    .line 77
    iget v2, v0, Lcom/google/android/material/sidesheet/SideSheetBehavior$StateSettlingTracker;->targetState:I

    .line 78
    .line 79
    invoke-virtual {v0, v2}, Lcom/google/android/material/sidesheet/SideSheetBehavior$StateSettlingTracker;->continueSettlingToState(I)V

    .line 80
    .line 81
    .line 82
    goto :goto_0

    .line 83
    :cond_0
    iget v4, v3, Lcom/google/android/material/sidesheet/SideSheetBehavior;->state:I

    .line 84
    .line 85
    if-ne v4, v2, :cond_1

    .line 86
    .line 87
    iget v0, v0, Lcom/google/android/material/sidesheet/SideSheetBehavior$StateSettlingTracker;->targetState:I

    .line 88
    .line 89
    invoke-virtual {v3, v0}, Lcom/google/android/material/sidesheet/SideSheetBehavior;->setStateInternal(I)V

    .line 90
    .line 91
    .line 92
    :cond_1
    :goto_0
    return-void

    .line 93
    :pswitch_4
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 94
    .line 95
    check-cast v0, Lkotlin/text/MatcherMatchResult;

    .line 96
    .line 97
    iget-object v2, v0, Lkotlin/text/MatcherMatchResult;->matcher:Ljava/lang/Object;

    .line 98
    .line 99
    check-cast v2, Lcom/google/android/material/motion/MaterialBackOrchestrator$Api33BackCallbackDelegate;

    .line 100
    .line 101
    if-eqz v2, :cond_2

    .line 102
    .line 103
    iget-object v3, v0, Lkotlin/text/MatcherMatchResult;->input:Ljava/lang/Object;

    .line 104
    .line 105
    check-cast v3, Lcom/google/android/material/navigation/NavigationView;

    .line 106
    .line 107
    iget-object v0, v0, Lkotlin/text/MatcherMatchResult;->groups:Ljava/lang/Object;

    .line 108
    .line 109
    check-cast v0, Lcom/google/android/material/navigation/NavigationView;

    .line 110
    .line 111
    invoke-virtual {v2, v3, v0, v5}, Lcom/google/android/material/motion/MaterialBackOrchestrator$Api33BackCallbackDelegate;->startListeningForBackCallbacks(Lcom/google/android/material/motion/MaterialBackHandler;Landroid/view/View;Z)V

    .line 112
    .line 113
    .line 114
    :cond_2
    return-void

    .line 115
    :pswitch_5
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 116
    .line 117
    check-cast v0, Landroid/view/View;

    .line 118
    .line 119
    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 120
    .line 121
    .line 122
    move-result-object v2

    .line 123
    const-class v3, Landroid/view/inputmethod/InputMethodManager;

    .line 124
    .line 125
    invoke-static {v2, v3}, Landroidx/core/os/BundleKt;->getSystemService(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;

    .line 126
    .line 127
    .line 128
    move-result-object v2

    .line 129
    check-cast v2, Landroid/view/inputmethod/InputMethodManager;

    .line 130
    .line 131
    invoke-virtual {v2, v0, v5}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 132
    .line 133
    .line 134
    return-void

    .line 135
    :pswitch_6
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 136
    .line 137
    check-cast v0, Lcom/google/android/material/carousel/CarouselLayoutManager;

    .line 138
    .line 139
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;->requestLayout()V

    .line 140
    .line 141
    .line 142
    return-void

    .line 143
    :pswitch_7
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 144
    .line 145
    check-cast v0, Lcom/google/android/material/button/MaterialButton;

    .line 146
    .line 147
    invoke-static {v0}, Lcom/google/android/material/button/MaterialButton;->$r8$lambda$sTDU5mTMH-dVAgylGXPenYNnUDs(Lcom/google/android/material/button/MaterialButton;)V

    .line 148
    .line 149
    .line 150
    return-void

    .line 151
    :pswitch_8
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 152
    .line 153
    check-cast v0, Landroidx/emoji2/text/MetadataRepo;

    .line 154
    .line 155
    iget-object v2, v0, Landroidx/emoji2/text/MetadataRepo;->mTypeface:Ljava/lang/Object;

    .line 156
    .line 157
    check-cast v2, Lcom/google/android/datatransport/runtime/synchronization/SynchronizationGuard;

    .line 158
    .line 159
    new-instance v3, Landroidx/core/view/inputmethod/InputConnectionCompat$$ExternalSyntheticLambda0;

    .line 160
    .line 161
    const/16 v4, 0xf

    .line 162
    .line 163
    invoke-direct {v3, v4, v0}, Landroidx/core/view/inputmethod/InputConnectionCompat$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 164
    .line 165
    .line 166
    check-cast v2, Lcom/google/android/datatransport/runtime/scheduling/persistence/SQLiteEventStore;

    .line 167
    .line 168
    invoke-virtual {v2, v3}, Lcom/google/android/datatransport/runtime/scheduling/persistence/SQLiteEventStore;->runCriticalSection(Lcom/google/android/datatransport/runtime/synchronization/SynchronizationGuard$CriticalSection;)Ljava/lang/Object;

    .line 169
    .line 170
    .line 171
    return-void

    .line 172
    :pswitch_9
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 173
    .line 174
    check-cast v0, Lcom/github/appintro/AppIntroBase;

    .line 175
    .line 176
    invoke-static {v0}, Lcom/github/appintro/AppIntroBase;->$r8$lambda$NWNhR1g9TmE6D3q_-J_pOxL4MlU(Lcom/github/appintro/AppIntroBase;)V

    .line 177
    .line 178
    .line 179
    return-void

    .line 180
    :pswitch_a
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 181
    .line 182
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/MalwareStatusFragment;

    .line 183
    .line 184
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/MalwareStatusFragment;->$r8$lambda$7gGeFZq6cJwijrJZnKCgSddH5Q8(Lcom/emanuelef/remote_capture/fragments/MalwareStatusFragment;)V

    .line 185
    .line 186
    .line 187
    return-void

    .line 188
    :pswitch_b
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 189
    .line 190
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;

    .line 191
    .line 192
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;->$r8$lambda$yp6MuCIRkiUvEhpiZf65LMCUS8c(Lcom/emanuelef/remote_capture/fragments/FirewallStatus;)V

    .line 193
    .line 194
    .line 195
    return-void

    .line 196
    :pswitch_c
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 197
    .line 198
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/BlacklistsFragment;

    .line 199
    .line 200
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/BlacklistsFragment;->$r8$lambda$HNhlldnUBTxEBZuMVq0Wg3tzuQs(Lcom/emanuelef/remote_capture/fragments/BlacklistsFragment;)V

    .line 201
    .line 202
    .line 203
    return-void

    .line 204
    :pswitch_d
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 205
    .line 206
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/AppsFragment;

    .line 207
    .line 208
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/AppsFragment;->$r8$lambda$URHt_hrLyy7Fj5tRVtN7aWTRdoQ(Lcom/emanuelef/remote_capture/fragments/AppsFragment;)V

    .line 209
    .line 210
    .line 211
    return-void

    .line 212
    :pswitch_e
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 213
    .line 214
    check-cast v0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    .line 215
    .line 216
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->$r8$lambda$mRqgtK1pRSZ3DJ4j3nQT3WfHzkg(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;)V

    .line 217
    .line 218
    .line 219
    return-void

    .line 220
    :pswitch_f
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 221
    .line 222
    check-cast v0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 223
    .line 224
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->$r8$lambda$XGrxTP5-yO4dgE73kd8jV2eXI3c(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)V

    .line 225
    .line 226
    .line 227
    return-void

    .line 228
    :pswitch_10
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 229
    .line 230
    check-cast v0, Lcom/emanuelef/remote_capture/activities/CaptureCtrl;

    .line 231
    .line 232
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/CaptureCtrl;->$r8$lambda$Hp4QKps-lLPieWupMSGtnwdUsIQ(Lcom/emanuelef/remote_capture/activities/CaptureCtrl;)V

    .line 233
    .line 234
    .line 235
    return-void

    .line 236
    :pswitch_11
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 237
    .line 238
    check-cast v0, Landroidx/lifecycle/ProcessLifecycleOwner;

    .line 239
    .line 240
    iget-object v2, v0, Landroidx/lifecycle/ProcessLifecycleOwner;->registry:Landroidx/lifecycle/LifecycleRegistry;

    .line 241
    .line 242
    iget v3, v0, Landroidx/lifecycle/ProcessLifecycleOwner;->resumedCounter:I

    .line 243
    .line 244
    if-nez v3, :cond_3

    .line 245
    .line 246
    iput-boolean v5, v0, Landroidx/lifecycle/ProcessLifecycleOwner;->pauseSent:Z

    .line 247
    .line 248
    sget-object v3, Landroidx/lifecycle/Lifecycle$Event;->ON_PAUSE:Landroidx/lifecycle/Lifecycle$Event;

    .line 249
    .line 250
    invoke-virtual {v2, v3}, Landroidx/lifecycle/LifecycleRegistry;->handleLifecycleEvent(Landroidx/lifecycle/Lifecycle$Event;)V

    .line 251
    .line 252
    .line 253
    :cond_3
    iget v3, v0, Landroidx/lifecycle/ProcessLifecycleOwner;->startedCounter:I

    .line 254
    .line 255
    if-nez v3, :cond_4

    .line 256
    .line 257
    iget-boolean v3, v0, Landroidx/lifecycle/ProcessLifecycleOwner;->pauseSent:Z

    .line 258
    .line 259
    if-eqz v3, :cond_4

    .line 260
    .line 261
    sget-object v3, Landroidx/lifecycle/Lifecycle$Event;->ON_STOP:Landroidx/lifecycle/Lifecycle$Event;

    .line 262
    .line 263
    invoke-virtual {v2, v3}, Landroidx/lifecycle/LifecycleRegistry;->handleLifecycleEvent(Landroidx/lifecycle/Lifecycle$Event;)V

    .line 264
    .line 265
    .line 266
    iput-boolean v5, v0, Landroidx/lifecycle/ProcessLifecycleOwner;->stopSent:Z

    .line 267
    .line 268
    :cond_4
    return-void

    .line 269
    :pswitch_12
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 270
    .line 271
    move-object v3, v0

    .line 272
    check-cast v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;

    .line 273
    .line 274
    const-string v0, "fetchFonts result is not OK. ("

    .line 275
    .line 276
    iget-object v6, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mLock:Ljava/lang/Object;

    .line 277
    .line 278
    monitor-enter v6

    .line 279
    :try_start_0
    iget-object v7, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mCallback:Landroidx/navigation/Navigation;

    .line 280
    .line 281
    if-nez v7, :cond_5

    .line 282
    .line 283
    monitor-exit v6

    .line 284
    goto/16 :goto_6

    .line 285
    .line 286
    :catchall_0
    move-exception v0

    .line 287
    goto/16 :goto_8

    .line 288
    .line 289
    :cond_5
    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 290
    :try_start_1
    invoke-virtual {v3}, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->retrieveFontInfo()Landroidx/core/provider/FontsContractCompat$FontInfo;

    .line 291
    .line 292
    .line 293
    move-result-object v6

    .line 294
    iget v7, v6, Landroidx/core/provider/FontsContractCompat$FontInfo;->mResultCode:I

    .line 295
    .line 296
    if-ne v7, v2, :cond_6

    .line 297
    .line 298
    iget-object v2, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mLock:Ljava/lang/Object;

    .line 299
    .line 300
    monitor-enter v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 301
    :try_start_2
    monitor-exit v2

    .line 302
    goto :goto_1

    .line 303
    :catchall_1
    move-exception v0

    .line 304
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 305
    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 306
    :catchall_2
    move-exception v0

    .line 307
    goto/16 :goto_4

    .line 308
    .line 309
    :cond_6
    :goto_1
    if-nez v7, :cond_9

    .line 310
    .line 311
    :try_start_4
    const-string v0, "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"

    .line 312
    .line 313
    sget-object v2, Landroidx/core/os/TraceCompat;->sIsTagEnabledMethod:Ljava/lang/reflect/Method;

    .line 314
    .line 315
    invoke-static {v0}, Landroid/os/Trace;->beginSection(Ljava/lang/String;)V

    .line 316
    .line 317
    .line 318
    iget-object v0, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mFontProviderHelper:Landroidx/collection/internal/Lock;

    .line 319
    .line 320
    iget-object v2, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mContext:Landroid/content/Context;

    .line 321
    .line 322
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 323
    .line 324
    .line 325
    new-array v0, v5, [Landroidx/core/provider/FontsContractCompat$FontInfo;

    .line 326
    .line 327
    aput-object v6, v0, v4

    .line 328
    .line 329
    sget-object v5, Landroidx/core/graphics/TypefaceCompat;->sTypefaceCompatImpl:Landroidx/core/os/BundleKt;

    .line 330
    .line 331
    invoke-virtual {v5, v2, v0, v4}, Landroidx/core/os/BundleKt;->createFromFontInfo(Landroid/content/Context;[Landroidx/core/provider/FontsContractCompat$FontInfo;I)Landroid/graphics/Typeface;

    .line 332
    .line 333
    .line 334
    move-result-object v0

    .line 335
    iget-object v2, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mContext:Landroid/content/Context;

    .line 336
    .line 337
    iget-object v4, v6, Landroidx/core/provider/FontsContractCompat$FontInfo;->mUri:Landroid/net/Uri;

    .line 338
    .line 339
    invoke-static {v2, v4}, Landroidx/core/os/BundleKt;->mmap(Landroid/content/Context;Landroid/net/Uri;)Ljava/nio/MappedByteBuffer;

    .line 340
    .line 341
    .line 342
    move-result-object v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_5

    .line 343
    if-eqz v2, :cond_8

    .line 344
    .line 345
    if-eqz v0, :cond_8

    .line 346
    .line 347
    :try_start_5
    const-string v4, "EmojiCompat.MetadataRepo.create"

    .line 348
    .line 349
    invoke-static {v4}, Landroid/os/Trace;->beginSection(Ljava/lang/String;)V

    .line 350
    .line 351
    .line 352
    new-instance v4, Landroidx/emoji2/text/MetadataRepo;

    .line 353
    .line 354
    invoke-static {v2}, Landroidx/navigation/Navigation;->read(Ljava/nio/MappedByteBuffer;)Landroidx/emoji2/text/flatbuffer/MetadataList;

    .line 355
    .line 356
    .line 357
    move-result-object v2

    .line 358
    invoke-direct {v4, v0, v2}, Landroidx/emoji2/text/MetadataRepo;-><init>(Landroid/graphics/Typeface;Landroidx/emoji2/text/flatbuffer/MetadataList;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_4

    .line 359
    .line 360
    .line 361
    :try_start_6
    invoke-static {}, Landroid/os/Trace;->endSection()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_5

    .line 362
    .line 363
    .line 364
    :try_start_7
    invoke-static {}, Landroid/os/Trace;->endSection()V

    .line 365
    .line 366
    .line 367
    iget-object v2, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mLock:Ljava/lang/Object;

    .line 368
    .line 369
    monitor-enter v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    .line 370
    :try_start_8
    iget-object v0, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mCallback:Landroidx/navigation/Navigation;

    .line 371
    .line 372
    if-eqz v0, :cond_7

    .line 373
    .line 374
    invoke-virtual {v0, v4}, Landroidx/navigation/Navigation;->onLoaded(Landroidx/emoji2/text/MetadataRepo;)V

    .line 375
    .line 376
    .line 377
    goto :goto_2

    .line 378
    :catchall_3
    move-exception v0

    .line 379
    goto :goto_3

    .line 380
    :cond_7
    :goto_2
    monitor-exit v2
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    .line 381
    :try_start_9
    invoke-virtual {v3}, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->cleanUp()V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    .line 382
    .line 383
    .line 384
    goto :goto_6

    .line 385
    :goto_3
    :try_start_a
    monitor-exit v2
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_3

    .line 386
    :try_start_b
    throw v0
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    .line 387
    :catchall_4
    move-exception v0

    .line 388
    :try_start_c
    sget-object v2, Landroidx/core/os/TraceCompat;->sIsTagEnabledMethod:Ljava/lang/reflect/Method;

    .line 389
    .line 390
    invoke-static {}, Landroid/os/Trace;->endSection()V

    .line 391
    .line 392
    .line 393
    throw v0

    .line 394
    :cond_8
    new-instance v0, Ljava/lang/RuntimeException;

    .line 395
    .line 396
    const-string v2, "Unable to open file."

    .line 397
    .line 398
    invoke-direct {v0, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 399
    .line 400
    .line 401
    throw v0
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_5

    .line 402
    :catchall_5
    move-exception v0

    .line 403
    :try_start_d
    sget-object v2, Landroidx/core/os/TraceCompat;->sIsTagEnabledMethod:Ljava/lang/reflect/Method;

    .line 404
    .line 405
    invoke-static {}, Landroid/os/Trace;->endSection()V

    .line 406
    .line 407
    .line 408
    throw v0

    .line 409
    :cond_9
    new-instance v2, Ljava/lang/RuntimeException;

    .line 410
    .line 411
    new-instance v4, Ljava/lang/StringBuilder;

    .line 412
    .line 413
    invoke-direct {v4, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 414
    .line 415
    .line 416
    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 417
    .line 418
    .line 419
    const-string v0, ")"

    .line 420
    .line 421
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 422
    .line 423
    .line 424
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 425
    .line 426
    .line 427
    move-result-object v0

    .line 428
    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 429
    .line 430
    .line 431
    throw v2
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_2

    .line 432
    :goto_4
    iget-object v2, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mLock:Ljava/lang/Object;

    .line 433
    .line 434
    monitor-enter v2

    .line 435
    :try_start_e
    iget-object v4, v3, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->mCallback:Landroidx/navigation/Navigation;

    .line 436
    .line 437
    if-eqz v4, :cond_a

    .line 438
    .line 439
    invoke-virtual {v4, v0}, Landroidx/navigation/Navigation;->onFailed(Ljava/lang/Throwable;)V

    .line 440
    .line 441
    .line 442
    goto :goto_5

    .line 443
    :catchall_6
    move-exception v0

    .line 444
    goto :goto_7

    .line 445
    :cond_a
    :goto_5
    monitor-exit v2
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_6

    .line 446
    invoke-virtual {v3}, Landroidx/emoji2/text/FontRequestEmojiCompatConfig$FontRequestMetadataLoader;->cleanUp()V

    .line 447
    .line 448
    .line 449
    :goto_6
    return-void

    .line 450
    :goto_7
    :try_start_f
    monitor-exit v2
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_6

    .line 451
    throw v0

    .line 452
    :goto_8
    :try_start_10
    monitor-exit v6
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    .line 453
    throw v0

    .line 454
    :pswitch_13
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 455
    .line 456
    check-cast v0, Landroidx/dynamicanimation/animation/AnimationHandler;

    .line 457
    .line 458
    iget-object v0, v0, Landroidx/dynamicanimation/animation/AnimationHandler;->mCallbackDispatcher:Landroidx/viewpager2/widget/FakeDrag;

    .line 459
    .line 460
    iget-object v0, v0, Landroidx/viewpager2/widget/FakeDrag;->mScrollEventAdapter:Ljava/lang/Object;

    .line 461
    .line 462
    check-cast v0, Landroidx/dynamicanimation/animation/AnimationHandler;

    .line 463
    .line 464
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    .line 465
    .line 466
    .line 467
    move-result-wide v6

    .line 468
    iget-object v2, v0, Landroidx/dynamicanimation/animation/AnimationHandler;->mAnimationCallbacks:Ljava/util/ArrayList;

    .line 469
    .line 470
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    .line 471
    .line 472
    .line 473
    move-result-wide v8

    .line 474
    const/4 v10, 0x0

    .line 475
    :goto_9
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 476
    .line 477
    .line 478
    move-result v11

    .line 479
    if-ge v10, v11, :cond_1d

    .line 480
    .line 481
    invoke-virtual {v2, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 482
    .line 483
    .line 484
    move-result-object v11

    .line 485
    check-cast v11, Landroidx/dynamicanimation/animation/SpringAnimation;

    .line 486
    .line 487
    if-nez v11, :cond_d

    .line 488
    .line 489
    :cond_b
    :goto_a
    move-wide/from16 v26, v6

    .line 490
    .line 491
    :cond_c
    move-wide/from16 v18, v8

    .line 492
    .line 493
    move v4, v10

    .line 494
    goto/16 :goto_15

    .line 495
    .line 496
    :cond_d
    iget-object v12, v0, Landroidx/dynamicanimation/animation/AnimationHandler;->mDelayedCallbackStartTime:Landroidx/collection/SimpleArrayMap;

    .line 497
    .line 498
    invoke-virtual {v12, v11}, Landroidx/collection/SimpleArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 499
    .line 500
    .line 501
    move-result-object v13

    .line 502
    check-cast v13, Ljava/lang/Long;

    .line 503
    .line 504
    if-nez v13, :cond_e

    .line 505
    .line 506
    goto :goto_b

    .line 507
    :cond_e
    invoke-virtual {v13}, Ljava/lang/Long;->longValue()J

    .line 508
    .line 509
    .line 510
    move-result-wide v13

    .line 511
    cmp-long v15, v13, v8

    .line 512
    .line 513
    if-gez v15, :cond_b

    .line 514
    .line 515
    invoke-virtual {v12, v11}, Landroidx/collection/SimpleArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 516
    .line 517
    .line 518
    :goto_b
    iget-wide v12, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mLastFrameTime:J

    .line 519
    .line 520
    const-wide/16 v14, 0x0

    .line 521
    .line 522
    cmp-long v16, v12, v14

    .line 523
    .line 524
    if-nez v16, :cond_f

    .line 525
    .line 526
    iput-wide v6, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mLastFrameTime:J

    .line 527
    .line 528
    iget v12, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 529
    .line 530
    invoke-virtual {v11, v12}, Landroidx/dynamicanimation/animation/SpringAnimation;->setPropertyValue(F)V

    .line 531
    .line 532
    .line 533
    goto :goto_a

    .line 534
    :cond_f
    sub-long v12, v6, v12

    .line 535
    .line 536
    iput-wide v6, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mLastFrameTime:J

    .line 537
    .line 538
    invoke-static {}, Landroidx/dynamicanimation/animation/SpringAnimation;->getAnimationHandler()Landroidx/dynamicanimation/animation/AnimationHandler;

    .line 539
    .line 540
    .line 541
    move-result-object v14

    .line 542
    iget v14, v14, Landroidx/dynamicanimation/animation/AnimationHandler;->mDurationScale:F

    .line 543
    .line 544
    const/4 v15, 0x0

    .line 545
    cmpl-float v18, v14, v15

    .line 546
    .line 547
    if-nez v18, :cond_10

    .line 548
    .line 549
    const-wide/32 v12, 0x7fffffff

    .line 550
    .line 551
    .line 552
    :goto_c
    move-wide/from16 v23, v12

    .line 553
    .line 554
    goto :goto_d

    .line 555
    :cond_10
    long-to-float v12, v12

    .line 556
    div-float/2addr v12, v14

    .line 557
    float-to-long v12, v12

    .line 558
    goto :goto_c

    .line 559
    :goto_d
    iget-boolean v12, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mEndRequested:Z

    .line 560
    .line 561
    const v13, 0x7f7fffff    # Float.MAX_VALUE

    .line 562
    .line 563
    .line 564
    if-eqz v12, :cond_12

    .line 565
    .line 566
    iget v12, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mPendingPosition:F

    .line 567
    .line 568
    cmpl-float v14, v12, v13

    .line 569
    .line 570
    if-eqz v14, :cond_11

    .line 571
    .line 572
    iget-object v14, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mSpring:Landroidx/dynamicanimation/animation/SpringForce;

    .line 573
    .line 574
    move-wide/from16 v26, v6

    .line 575
    .line 576
    float-to-double v5, v12

    .line 577
    iput-wide v5, v14, Landroidx/dynamicanimation/animation/SpringForce;->mFinalPosition:D

    .line 578
    .line 579
    iput v13, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mPendingPosition:F

    .line 580
    .line 581
    goto :goto_e

    .line 582
    :cond_11
    move-wide/from16 v26, v6

    .line 583
    .line 584
    :goto_e
    iget-object v5, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mSpring:Landroidx/dynamicanimation/animation/SpringForce;

    .line 585
    .line 586
    iget-wide v5, v5, Landroidx/dynamicanimation/animation/SpringForce;->mFinalPosition:D

    .line 587
    .line 588
    double-to-float v5, v5

    .line 589
    iput v5, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 590
    .line 591
    iput v15, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mVelocity:F

    .line 592
    .line 593
    iput-boolean v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mEndRequested:Z

    .line 594
    .line 595
    :goto_f
    const/4 v3, 0x1

    .line 596
    goto/16 :goto_11

    .line 597
    .line 598
    :cond_12
    move-wide/from16 v26, v6

    .line 599
    .line 600
    iget v5, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mPendingPosition:F

    .line 601
    .line 602
    cmpl-float v5, v5, v13

    .line 603
    .line 604
    if-eqz v5, :cond_13

    .line 605
    .line 606
    iget-object v5, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mSpring:Landroidx/dynamicanimation/animation/SpringForce;

    .line 607
    .line 608
    iget v6, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 609
    .line 610
    float-to-double v6, v6

    .line 611
    iget v12, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mVelocity:F

    .line 612
    .line 613
    float-to-double v3, v12

    .line 614
    const-wide/16 v18, 0x2

    .line 615
    .line 616
    div-long v33, v23, v18

    .line 617
    .line 618
    move-wide/from16 v31, v3

    .line 619
    .line 620
    move-object/from16 v28, v5

    .line 621
    .line 622
    move-wide/from16 v29, v6

    .line 623
    .line 624
    invoke-virtual/range {v28 .. v34}, Landroidx/dynamicanimation/animation/SpringForce;->updateValues(DDJ)Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;

    .line 625
    .line 626
    .line 627
    move-result-object v3

    .line 628
    iget-object v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mSpring:Landroidx/dynamicanimation/animation/SpringForce;

    .line 629
    .line 630
    iget v5, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mPendingPosition:F

    .line 631
    .line 632
    float-to-double v5, v5

    .line 633
    iput-wide v5, v4, Landroidx/dynamicanimation/animation/SpringForce;->mFinalPosition:D

    .line 634
    .line 635
    iput v13, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mPendingPosition:F

    .line 636
    .line 637
    iget v5, v3, Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;->mValue:F

    .line 638
    .line 639
    float-to-double v5, v5

    .line 640
    iget v3, v3, Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;->mVelocity:F

    .line 641
    .line 642
    float-to-double v12, v3

    .line 643
    move-object/from16 v28, v4

    .line 644
    .line 645
    move-wide/from16 v29, v5

    .line 646
    .line 647
    move-wide/from16 v31, v12

    .line 648
    .line 649
    invoke-virtual/range {v28 .. v34}, Landroidx/dynamicanimation/animation/SpringForce;->updateValues(DDJ)Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;

    .line 650
    .line 651
    .line 652
    move-result-object v3

    .line 653
    iget v4, v3, Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;->mValue:F

    .line 654
    .line 655
    iput v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 656
    .line 657
    iget v3, v3, Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;->mVelocity:F

    .line 658
    .line 659
    iput v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mVelocity:F

    .line 660
    .line 661
    goto :goto_10

    .line 662
    :cond_13
    iget-object v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mSpring:Landroidx/dynamicanimation/animation/SpringForce;

    .line 663
    .line 664
    iget v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 665
    .line 666
    float-to-double v4, v4

    .line 667
    iget v6, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mVelocity:F

    .line 668
    .line 669
    float-to-double v6, v6

    .line 670
    move-object/from16 v18, v3

    .line 671
    .line 672
    move-wide/from16 v19, v4

    .line 673
    .line 674
    move-wide/from16 v21, v6

    .line 675
    .line 676
    invoke-virtual/range {v18 .. v24}, Landroidx/dynamicanimation/animation/SpringForce;->updateValues(DDJ)Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;

    .line 677
    .line 678
    .line 679
    move-result-object v3

    .line 680
    iget v4, v3, Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;->mValue:F

    .line 681
    .line 682
    iput v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 683
    .line 684
    iget v3, v3, Landroidx/dynamicanimation/animation/DynamicAnimation$MassState;->mVelocity:F

    .line 685
    .line 686
    iput v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mVelocity:F

    .line 687
    .line 688
    :goto_10
    iget v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 689
    .line 690
    iget v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mMinValue:F

    .line 691
    .line 692
    invoke-static {v3, v4}, Ljava/lang/Math;->max(FF)F

    .line 693
    .line 694
    .line 695
    move-result v3

    .line 696
    iput v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 697
    .line 698
    iget v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mMaxValue:F

    .line 699
    .line 700
    invoke-static {v3, v4}, Ljava/lang/Math;->min(FF)F

    .line 701
    .line 702
    .line 703
    move-result v3

    .line 704
    iput v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 705
    .line 706
    iget v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mVelocity:F

    .line 707
    .line 708
    iget-object v5, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mSpring:Landroidx/dynamicanimation/animation/SpringForce;

    .line 709
    .line 710
    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 711
    .line 712
    .line 713
    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    .line 714
    .line 715
    .line 716
    move-result v4

    .line 717
    float-to-double v6, v4

    .line 718
    iget-wide v12, v5, Landroidx/dynamicanimation/animation/SpringForce;->mVelocityThreshold:D

    .line 719
    .line 720
    cmpg-double v4, v6, v12

    .line 721
    .line 722
    if-gez v4, :cond_14

    .line 723
    .line 724
    iget-wide v6, v5, Landroidx/dynamicanimation/animation/SpringForce;->mFinalPosition:D

    .line 725
    .line 726
    double-to-float v4, v6

    .line 727
    sub-float/2addr v3, v4

    .line 728
    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    .line 729
    .line 730
    .line 731
    move-result v3

    .line 732
    float-to-double v3, v3

    .line 733
    iget-wide v5, v5, Landroidx/dynamicanimation/animation/SpringForce;->mValueThreshold:D

    .line 734
    .line 735
    cmpg-double v7, v3, v5

    .line 736
    .line 737
    if-gez v7, :cond_14

    .line 738
    .line 739
    iget-object v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mSpring:Landroidx/dynamicanimation/animation/SpringForce;

    .line 740
    .line 741
    iget-wide v3, v3, Landroidx/dynamicanimation/animation/SpringForce;->mFinalPosition:D

    .line 742
    .line 743
    double-to-float v3, v3

    .line 744
    iput v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 745
    .line 746
    iput v15, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mVelocity:F

    .line 747
    .line 748
    goto/16 :goto_f

    .line 749
    .line 750
    :cond_14
    const/4 v3, 0x0

    .line 751
    :goto_11
    iget v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 752
    .line 753
    iget v5, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mMaxValue:F

    .line 754
    .line 755
    invoke-static {v4, v5}, Ljava/lang/Math;->min(FF)F

    .line 756
    .line 757
    .line 758
    move-result v4

    .line 759
    iput v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 760
    .line 761
    iget v5, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mMinValue:F

    .line 762
    .line 763
    invoke-static {v4, v5}, Ljava/lang/Math;->max(FF)F

    .line 764
    .line 765
    .line 766
    move-result v4

    .line 767
    iput v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 768
    .line 769
    invoke-virtual {v11, v4}, Landroidx/dynamicanimation/animation/SpringAnimation;->setPropertyValue(F)V

    .line 770
    .line 771
    .line 772
    if-eqz v3, :cond_c

    .line 773
    .line 774
    iget-object v3, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mEndListeners:Ljava/util/ArrayList;

    .line 775
    .line 776
    const/4 v4, 0x0

    .line 777
    iput-boolean v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mRunning:Z

    .line 778
    .line 779
    invoke-static {}, Landroidx/dynamicanimation/animation/SpringAnimation;->getAnimationHandler()Landroidx/dynamicanimation/animation/AnimationHandler;

    .line 780
    .line 781
    .line 782
    move-result-object v4

    .line 783
    iget-object v5, v4, Landroidx/dynamicanimation/animation/AnimationHandler;->mDelayedCallbackStartTime:Landroidx/collection/SimpleArrayMap;

    .line 784
    .line 785
    invoke-virtual {v5, v11}, Landroidx/collection/SimpleArrayMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 786
    .line 787
    .line 788
    iget-object v5, v4, Landroidx/dynamicanimation/animation/AnimationHandler;->mAnimationCallbacks:Ljava/util/ArrayList;

    .line 789
    .line 790
    invoke-virtual {v5, v11}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    .line 791
    .line 792
    .line 793
    move-result v6

    .line 794
    if-ltz v6, :cond_15

    .line 795
    .line 796
    const/4 v14, 0x0

    .line 797
    invoke-virtual {v5, v6, v14}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 798
    .line 799
    .line 800
    const/4 v5, 0x1

    .line 801
    iput-boolean v5, v4, Landroidx/dynamicanimation/animation/AnimationHandler;->mListDirty:Z

    .line 802
    .line 803
    :cond_15
    const-wide/16 v4, 0x0

    .line 804
    .line 805
    iput-wide v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mLastFrameTime:J

    .line 806
    .line 807
    const/4 v4, 0x0

    .line 808
    iput-boolean v4, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mStartValueIsSet:Z

    .line 809
    .line 810
    const/4 v4, 0x0

    .line 811
    :goto_12
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 812
    .line 813
    .line 814
    move-result v5

    .line 815
    if-ge v4, v5, :cond_1a

    .line 816
    .line 817
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 818
    .line 819
    .line 820
    move-result-object v5

    .line 821
    if-eqz v5, :cond_18

    .line 822
    .line 823
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 824
    .line 825
    .line 826
    move-result-object v5

    .line 827
    check-cast v5, Landroidx/transition/Transition$SeekController$$ExternalSyntheticLambda0;

    .line 828
    .line 829
    iget v6, v11, Landroidx/dynamicanimation/animation/SpringAnimation;->mValue:F

    .line 830
    .line 831
    iget-object v5, v5, Landroidx/transition/Transition$SeekController$$ExternalSyntheticLambda0;->f$0:Landroidx/transition/Transition$SeekController;

    .line 832
    .line 833
    sget-object v7, Landroidx/transition/Transition$TransitionNotification;->ON_END:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 834
    .line 835
    iget-object v12, v5, Landroidx/transition/Transition$SeekController;->this$0:Landroidx/transition/TransitionSet;

    .line 836
    .line 837
    const/high16 v13, 0x3f800000    # 1.0f

    .line 838
    .line 839
    cmpg-float v6, v6, v13

    .line 840
    .line 841
    if-gez v6, :cond_17

    .line 842
    .line 843
    iget-wide v14, v12, Landroidx/transition/Transition;->mTotalDuration:J

    .line 844
    .line 845
    const/4 v13, 0x0

    .line 846
    invoke-virtual {v12, v13}, Landroidx/transition/TransitionSet;->getTransitionAt(I)Landroidx/transition/Transition;

    .line 847
    .line 848
    .line 849
    move-result-object v6

    .line 850
    iget-object v13, v6, Landroidx/transition/Transition;->mCloneParent:Landroidx/transition/Transition;

    .line 851
    .line 852
    move/from16 v17, v4

    .line 853
    .line 854
    const/4 v4, 0x0

    .line 855
    iput-object v4, v6, Landroidx/transition/Transition;->mCloneParent:Landroidx/transition/Transition;

    .line 856
    .line 857
    move-wide/from16 v18, v8

    .line 858
    .line 859
    iget-wide v8, v5, Landroidx/transition/Transition$SeekController;->mCurrentPlayTime:J

    .line 860
    .line 861
    move v4, v10

    .line 862
    move-object v6, v11

    .line 863
    const-wide/16 v10, -0x1

    .line 864
    .line 865
    invoke-virtual {v12, v10, v11, v8, v9}, Landroidx/transition/TransitionSet;->setCurrentPlayTimeMillis(JJ)V

    .line 866
    .line 867
    .line 868
    invoke-virtual {v12, v14, v15, v10, v11}, Landroidx/transition/TransitionSet;->setCurrentPlayTimeMillis(JJ)V

    .line 869
    .line 870
    .line 871
    iput-wide v14, v5, Landroidx/transition/Transition$SeekController;->mCurrentPlayTime:J

    .line 872
    .line 873
    iget-object v5, v5, Landroidx/transition/Transition$SeekController;->mResetToStartState:Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4;

    .line 874
    .line 875
    if-eqz v5, :cond_16

    .line 876
    .line 877
    invoke-virtual {v5}, Landroidx/fragment/app/DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4;->run()V

    .line 878
    .line 879
    .line 880
    :cond_16
    iget-object v5, v12, Landroidx/transition/Transition;->mAnimators:Ljava/util/ArrayList;

    .line 881
    .line 882
    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    .line 883
    .line 884
    .line 885
    if-eqz v13, :cond_19

    .line 886
    .line 887
    const/4 v5, 0x1

    .line 888
    invoke-virtual {v13, v13, v7, v5}, Landroidx/transition/Transition;->notifyFromTransition(Landroidx/transition/Transition;Landroidx/transition/Transition$TransitionNotification;Z)V

    .line 889
    .line 890
    .line 891
    goto :goto_13

    .line 892
    :cond_17
    move/from16 v17, v4

    .line 893
    .line 894
    move-wide/from16 v18, v8

    .line 895
    .line 896
    move v4, v10

    .line 897
    move-object v6, v11

    .line 898
    const/4 v5, 0x1

    .line 899
    const/4 v13, 0x0

    .line 900
    invoke-virtual {v12, v12, v7, v13}, Landroidx/transition/Transition;->notifyFromTransition(Landroidx/transition/Transition;Landroidx/transition/Transition$TransitionNotification;Z)V

    .line 901
    .line 902
    .line 903
    goto :goto_13

    .line 904
    :cond_18
    move/from16 v17, v4

    .line 905
    .line 906
    move-wide/from16 v18, v8

    .line 907
    .line 908
    move v4, v10

    .line 909
    move-object v6, v11

    .line 910
    :cond_19
    const/4 v5, 0x1

    .line 911
    :goto_13
    add-int/lit8 v7, v17, 0x1

    .line 912
    .line 913
    move v10, v4

    .line 914
    move-object v11, v6

    .line 915
    move v4, v7

    .line 916
    move-wide/from16 v8, v18

    .line 917
    .line 918
    goto :goto_12

    .line 919
    :cond_1a
    move-wide/from16 v18, v8

    .line 920
    .line 921
    move v4, v10

    .line 922
    const/4 v5, 0x1

    .line 923
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 924
    .line 925
    .line 926
    move-result v6

    .line 927
    sub-int/2addr v6, v5

    .line 928
    :goto_14
    if-ltz v6, :cond_1c

    .line 929
    .line 930
    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 931
    .line 932
    .line 933
    move-result-object v5

    .line 934
    if-nez v5, :cond_1b

    .line 935
    .line 936
    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 937
    .line 938
    .line 939
    :cond_1b
    add-int/lit8 v6, v6, -0x1

    .line 940
    .line 941
    goto :goto_14

    .line 942
    :cond_1c
    :goto_15
    add-int/lit8 v10, v4, 0x1

    .line 943
    .line 944
    move-wide/from16 v8, v18

    .line 945
    .line 946
    move-wide/from16 v6, v26

    .line 947
    .line 948
    const/4 v4, 0x0

    .line 949
    const/4 v5, 0x1

    .line 950
    goto/16 :goto_9

    .line 951
    .line 952
    :cond_1d
    iget-boolean v3, v0, Landroidx/dynamicanimation/animation/AnimationHandler;->mListDirty:Z

    .line 953
    .line 954
    if-eqz v3, :cond_21

    .line 955
    .line 956
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 957
    .line 958
    .line 959
    move-result v3

    .line 960
    const/16 v25, 0x1

    .line 961
    .line 962
    add-int/lit8 v3, v3, -0x1

    .line 963
    .line 964
    :goto_16
    if-ltz v3, :cond_1f

    .line 965
    .line 966
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 967
    .line 968
    .line 969
    move-result-object v4

    .line 970
    if-nez v4, :cond_1e

    .line 971
    .line 972
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 973
    .line 974
    .line 975
    :cond_1e
    add-int/lit8 v3, v3, -0x1

    .line 976
    .line 977
    goto :goto_16

    .line 978
    :cond_1f
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 979
    .line 980
    .line 981
    move-result v3

    .line 982
    if-nez v3, :cond_20

    .line 983
    .line 984
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 985
    .line 986
    const/16 v4, 0x21

    .line 987
    .line 988
    if-lt v3, v4, :cond_20

    .line 989
    .line 990
    iget-object v3, v0, Landroidx/dynamicanimation/animation/AnimationHandler;->mDurationScaleChangeListener:Landroidx/dynamicanimation/animation/AnimationHandler$DurationScaleChangeListener33;

    .line 991
    .line 992
    invoke-virtual {v3}, Landroidx/dynamicanimation/animation/AnimationHandler$DurationScaleChangeListener33;->unregister()Z

    .line 993
    .line 994
    .line 995
    :cond_20
    const/4 v4, 0x0

    .line 996
    iput-boolean v4, v0, Landroidx/dynamicanimation/animation/AnimationHandler;->mListDirty:Z

    .line 997
    .line 998
    :cond_21
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 999
    .line 1000
    .line 1001
    move-result v2

    .line 1002
    if-lez v2, :cond_22

    .line 1003
    .line 1004
    iget-object v2, v0, Landroidx/dynamicanimation/animation/AnimationHandler;->mScheduler:Lcom/android/billingclient/api/zzcl;

    .line 1005
    .line 1006
    iget-object v0, v0, Landroidx/dynamicanimation/animation/AnimationHandler;->mRunnable:Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;

    .line 1007
    .line 1008
    iget-object v2, v2, Lcom/android/billingclient/api/zzcl;->zzb:Ljava/lang/Object;

    .line 1009
    .line 1010
    check-cast v2, Landroid/view/Choreographer;

    .line 1011
    .line 1012
    new-instance v3, Landroidx/profileinstaller/ProfileInstallerInitializer$$ExternalSyntheticLambda0;

    .line 1013
    .line 1014
    invoke-direct {v3, v0}, Landroidx/profileinstaller/ProfileInstallerInitializer$$ExternalSyntheticLambda0;-><init>(Ljava/lang/Runnable;)V

    .line 1015
    .line 1016
    .line 1017
    invoke-virtual {v2, v3}, Landroid/view/Choreographer;->postFrameCallback(Landroid/view/Choreographer$FrameCallback;)V

    .line 1018
    .line 1019
    .line 1020
    :cond_22
    return-void

    .line 1021
    :pswitch_14
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 1022
    .line 1023
    check-cast v0, Landroidx/activity/ComponentDialog;

    .line 1024
    .line 1025
    invoke-static {v0}, Landroidx/activity/ComponentDialog;->$r8$lambda$qrzmfDOyDuplJFtpJLozn3P9EZI(Landroidx/activity/ComponentDialog;)V

    .line 1026
    .line 1027
    .line 1028
    return-void

    .line 1029
    :pswitch_15
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 1030
    .line 1031
    check-cast v0, Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorApi16Impl;

    .line 1032
    .line 1033
    iget-object v2, v0, Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorApi16Impl;->mRunnable:Ljava/lang/Runnable;

    .line 1034
    .line 1035
    if-eqz v2, :cond_23

    .line 1036
    .line 1037
    invoke-interface {v2}, Ljava/lang/Runnable;->run()V

    .line 1038
    .line 1039
    .line 1040
    const/4 v14, 0x0

    .line 1041
    iput-object v14, v0, Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorApi16Impl;->mRunnable:Ljava/lang/Runnable;

    .line 1042
    .line 1043
    :cond_23
    return-void

    .line 1044
    :pswitch_16
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 1045
    .line 1046
    check-cast v0, Landroidx/activity/ComponentActivity;

    .line 1047
    .line 1048
    invoke-virtual {v0}, Landroidx/activity/ComponentActivity;->invalidateMenu()V

    .line 1049
    .line 1050
    .line 1051
    return-void

    .line 1052
    :pswitch_17
    iget-object v0, v1, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 1053
    .line 1054
    move-object v3, v0

    .line 1055
    check-cast v3, Landroid/app/Activity;

    .line 1056
    .line 1057
    invoke-virtual {v3}, Landroid/app/Activity;->isFinishing()Z

    .line 1058
    .line 1059
    .line 1060
    move-result v0

    .line 1061
    if-nez v0, :cond_2d

    .line 1062
    .line 1063
    sget-object v4, Landroidx/core/app/ActivityRecreator;->mainHandler:Landroid/os/Handler;

    .line 1064
    .line 1065
    sget-object v0, Landroidx/core/app/ActivityRecreator;->requestRelaunchActivityMethod:Ljava/lang/reflect/Method;

    .line 1066
    .line 1067
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 1068
    .line 1069
    const/16 v6, 0x1c

    .line 1070
    .line 1071
    if-lt v5, v6, :cond_24

    .line 1072
    .line 1073
    invoke-virtual {v3}, Landroid/app/Activity;->recreate()V

    .line 1074
    .line 1075
    .line 1076
    goto/16 :goto_1c

    .line 1077
    .line 1078
    :cond_24
    const/16 v6, 0x1b

    .line 1079
    .line 1080
    const/16 v7, 0x1a

    .line 1081
    .line 1082
    if-eq v5, v7, :cond_25

    .line 1083
    .line 1084
    if-ne v5, v6, :cond_26

    .line 1085
    .line 1086
    :cond_25
    if-nez v0, :cond_26

    .line 1087
    .line 1088
    goto/16 :goto_1b

    .line 1089
    .line 1090
    :cond_26
    sget-object v8, Landroidx/core/app/ActivityRecreator;->performStopActivity2ParamsMethod:Ljava/lang/reflect/Method;

    .line 1091
    .line 1092
    if-nez v8, :cond_27

    .line 1093
    .line 1094
    sget-object v8, Landroidx/core/app/ActivityRecreator;->performStopActivity3ParamsMethod:Ljava/lang/reflect/Method;

    .line 1095
    .line 1096
    if-nez v8, :cond_27

    .line 1097
    .line 1098
    goto/16 :goto_1b

    .line 1099
    .line 1100
    :cond_27
    :try_start_11
    sget-object v8, Landroidx/core/app/ActivityRecreator;->tokenField:Ljava/lang/reflect/Field;

    .line 1101
    .line 1102
    invoke-virtual {v8, v3}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1103
    .line 1104
    .line 1105
    move-result-object v8

    .line 1106
    if-nez v8, :cond_28

    .line 1107
    .line 1108
    goto :goto_1b

    .line 1109
    :cond_28
    sget-object v9, Landroidx/core/app/ActivityRecreator;->mainThreadField:Ljava/lang/reflect/Field;

    .line 1110
    .line 1111
    invoke-virtual {v9, v3}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1112
    .line 1113
    .line 1114
    move-result-object v9

    .line 1115
    if-nez v9, :cond_29

    .line 1116
    .line 1117
    goto :goto_1b

    .line 1118
    :cond_29
    invoke-virtual {v3}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    .line 1119
    .line 1120
    .line 1121
    move-result-object v10

    .line 1122
    new-instance v11, Landroidx/core/app/ActivityRecreator$LifecycleCheckCallbacks;

    .line 1123
    .line 1124
    invoke-direct {v11, v3}, Landroidx/core/app/ActivityRecreator$LifecycleCheckCallbacks;-><init>(Landroid/app/Activity;)V

    .line 1125
    .line 1126
    .line 1127
    invoke-virtual {v10, v11}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    .line 1128
    .line 1129
    .line 1130
    new-instance v12, Lcom/google/android/gms/tasks/zzi;

    .line 1131
    .line 1132
    const/4 v13, 0x1

    .line 1133
    invoke-direct {v12, v11, v13, v8}, Lcom/google/android/gms/tasks/zzi;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 1134
    .line 1135
    .line 1136
    invoke-virtual {v4, v12}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_8

    .line 1137
    .line 1138
    .line 1139
    if-eq v5, v7, :cond_2b

    .line 1140
    .line 1141
    if-ne v5, v6, :cond_2a

    .line 1142
    .line 1143
    goto :goto_17

    .line 1144
    :cond_2a
    const/4 v5, 0x0

    .line 1145
    goto :goto_18

    .line 1146
    :cond_2b
    :goto_17
    const/4 v5, 0x1

    .line 1147
    :goto_18
    if-eqz v5, :cond_2c

    .line 1148
    .line 1149
    const/16 v35, 0x0

    .line 1150
    .line 1151
    :try_start_12
    invoke-static/range {v35 .. v35}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 1152
    .line 1153
    .line 1154
    move-result-object v5

    .line 1155
    const/16 v6, 0x9

    .line 1156
    .line 1157
    new-array v6, v6, [Ljava/lang/Object;

    .line 1158
    .line 1159
    aput-object v8, v6, v35

    .line 1160
    .line 1161
    const/4 v14, 0x0

    .line 1162
    const/16 v25, 0x1

    .line 1163
    .line 1164
    aput-object v14, v6, v25

    .line 1165
    .line 1166
    aput-object v14, v6, v2

    .line 1167
    .line 1168
    const/4 v7, 0x3

    .line 1169
    aput-object v5, v6, v7

    .line 1170
    .line 1171
    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .line 1172
    .line 1173
    const/4 v7, 0x4

    .line 1174
    aput-object v5, v6, v7

    .line 1175
    .line 1176
    const/4 v7, 0x5

    .line 1177
    aput-object v14, v6, v7

    .line 1178
    .line 1179
    const/4 v7, 0x6

    .line 1180
    aput-object v14, v6, v7

    .line 1181
    .line 1182
    const/4 v7, 0x7

    .line 1183
    aput-object v5, v6, v7

    .line 1184
    .line 1185
    const/16 v7, 0x8

    .line 1186
    .line 1187
    aput-object v5, v6, v7

    .line 1188
    .line 1189
    invoke-virtual {v0, v9, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 1190
    .line 1191
    .line 1192
    goto :goto_19

    .line 1193
    :catchall_7
    move-exception v0

    .line 1194
    goto :goto_1a

    .line 1195
    :cond_2c
    invoke-virtual {v3}, Landroid/app/Activity;->recreate()V
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_7

    .line 1196
    .line 1197
    .line 1198
    :goto_19
    :try_start_13
    new-instance v0, Lcom/google/android/gms/tasks/zzi;

    .line 1199
    .line 1200
    invoke-direct {v0, v10, v2, v11}, Lcom/google/android/gms/tasks/zzi;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 1201
    .line 1202
    .line 1203
    invoke-virtual {v4, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1204
    .line 1205
    .line 1206
    goto :goto_1c

    .line 1207
    :goto_1a
    new-instance v5, Lcom/google/android/gms/tasks/zzi;

    .line 1208
    .line 1209
    invoke-direct {v5, v10, v2, v11}, Lcom/google/android/gms/tasks/zzi;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 1210
    .line 1211
    .line 1212
    invoke-virtual {v4, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1213
    .line 1214
    .line 1215
    throw v0
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_8

    .line 1216
    :catchall_8
    :goto_1b
    invoke-virtual {v3}, Landroid/app/Activity;->recreate()V

    .line 1217
    .line 1218
    .line 1219
    :cond_2d
    :goto_1c
    return-void

    .line 1220
    nop

    .line 1221
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_17
        :pswitch_16
        :pswitch_15
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
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
    .line 1222
    .line 1223
    .line 1224
    .line 1225
    .line 1226
    .line 1227
    .line 1228
    .line 1229
    .line 1230
    .line 1231
    .line 1232
    .line 1233
    .line 1234
    .line 1235
    .line 1236
    .line 1237
    .line 1238
    .line 1239
    .line 1240
    .line 1241
    .line 1242
    .line 1243
    .line 1244
    .line 1245
    .line 1246
    .line 1247
    .line 1248
    .line 1249
    .line 1250
    .line 1251
    .line 1252
    .line 1253
    .line 1254
    .line 1255
    .line 1256
    .line 1257
    .line 1258
    .line 1259
    .line 1260
    .line 1261
    .line 1262
    .line 1263
    .line 1264
    .line 1265
    .line 1266
    .line 1267
    .line 1268
    .line 1269
    .line 1270
    .line 1271
    .line 1272
    .line 1273
    .line 1274
    .line 1275
    .line 1276
    .line 1277
    .line 1278
    .line 1279
    .line 1280
    .line 1281
    .line 1282
    .line 1283
    .line 1284
    .line 1285
    .line 1286
    .line 1287
    .line 1288
    .line 1289
    .line 1290
    .line 1291
    .line 1292
    .line 1293
    .line 1294
    .line 1295
    .line 1296
    .line 1297
    .line 1298
    .line 1299
    .line 1300
    .line 1301
    .line 1302
    .line 1303
    .line 1304
    .line 1305
    .line 1306
    .line 1307
    .line 1308
    .line 1309
    .line 1310
    .line 1311
    .line 1312
    .line 1313
    .line 1314
    .line 1315
    .line 1316
    .line 1317
    .line 1318
    .line 1319
    .line 1320
    .line 1321
    .line 1322
    .line 1323
    .line 1324
    .line 1325
    .line 1326
    .line 1327
    .line 1328
    .line 1329
    .line 1330
    .line 1331
    .line 1332
    .line 1333
    .line 1334
    .line 1335
    .line 1336
    .line 1337
    .line 1338
    .line 1339
    .line 1340
    .line 1341
    .line 1342
    .line 1343
    .line 1344
    .line 1345
    .line 1346
    .line 1347
    .line 1348
    .line 1349
    .line 1350
    .line 1351
    .line 1352
    .line 1353
    .line 1354
    .line 1355
    .line 1356
    .line 1357
    .line 1358
    .line 1359
    .line 1360
    .line 1361
    .line 1362
    .line 1363
    .line 1364
    .line 1365
    .line 1366
    .line 1367
    .line 1368
    .line 1369
    .line 1370
    .line 1371
    .line 1372
    .line 1373
    .line 1374
    .line 1375
    .line 1376
    .line 1377
    .line 1378
    .line 1379
    .line 1380
    .line 1381
    .line 1382
    .line 1383
    .line 1384
    .line 1385
    .line 1386
    .line 1387
    .line 1388
    .line 1389
    .line 1390
    .line 1391
    .line 1392
    .line 1393
    .line 1394
    .line 1395
    .line 1396
    .line 1397
    .line 1398
    .line 1399
    .line 1400
    .line 1401
    .line 1402
    .line 1403
    .line 1404
    .line 1405
    .line 1406
    .line 1407
    .line 1408
    .line 1409
    .line 1410
    .line 1411
    .line 1412
    .line 1413
    .line 1414
    .line 1415
    .line 1416
    .line 1417
    .line 1418
    .line 1419
    .line 1420
    .line 1421
    .line 1422
    .line 1423
    .line 1424
    .line 1425
    .line 1426
    .line 1427
    .line 1428
    .line 1429
    .line 1430
    .line 1431
    .line 1432
    .line 1433
    .line 1434
    .line 1435
    .line 1436
    .line 1437
    .line 1438
    .line 1439
    .line 1440
    .line 1441
    .line 1442
    .line 1443
    .line 1444
    .line 1445
    .line 1446
    .line 1447
    .line 1448
    .line 1449
    .line 1450
    .line 1451
    .line 1452
    .line 1453
    .line 1454
    .line 1455
    .line 1456
    .line 1457
    .line 1458
    .line 1459
    .line 1460
    .line 1461
    .line 1462
    .line 1463
    .line 1464
    .line 1465
    .line 1466
    .line 1467
    .line 1468
    .line 1469
    .line 1470
    .line 1471
    .line 1472
    .line 1473
    .line 1474
    .line 1475
    .line 1476
    .line 1477
    .line 1478
    .line 1479
    .line 1480
    .line 1481
    .line 1482
    .line 1483
    .line 1484
    .line 1485
    .line 1486
    .line 1487
    .line 1488
    .line 1489
    .line 1490
    .line 1491
    .line 1492
    .line 1493
    .line 1494
    .line 1495
    .line 1496
    .line 1497
    .line 1498
    .line 1499
    .line 1500
    .line 1501
    .line 1502
    .line 1503
    .line 1504
    .line 1505
    .line 1506
    .line 1507
    .line 1508
    .line 1509
    .line 1510
    .line 1511
    .line 1512
    .line 1513
    .line 1514
    .line 1515
    .line 1516
    .line 1517
    .line 1518
    .line 1519
    .line 1520
    .line 1521
    .line 1522
    .line 1523
    .line 1524
    .line 1525
    .line 1526
    .line 1527
    .line 1528
    .line 1529
    .line 1530
    .line 1531
    .line 1532
    .line 1533
    .line 1534
    .line 1535
    .line 1536
    .line 1537
    .line 1538
    .line 1539
    .line 1540
    .line 1541
    .line 1542
    .line 1543
    .line 1544
    .line 1545
    .line 1546
    .line 1547
    .line 1548
    .line 1549
    .line 1550
    .line 1551
    .line 1552
    .line 1553
    .line 1554
    .line 1555
    .line 1556
    .line 1557
    .line 1558
    .line 1559
    .line 1560
    .line 1561
    .line 1562
    .line 1563
    .line 1564
    .line 1565
    .line 1566
    .line 1567
    .line 1568
    .line 1569
    .line 1570
    .line 1571
    .line 1572
    .line 1573
    .line 1574
    .line 1575
    .line 1576
    .line 1577
    .line 1578
    .line 1579
    .line 1580
    .line 1581
    .line 1582
    .line 1583
    .line 1584
    .line 1585
    .line 1586
    .line 1587
    .line 1588
    .line 1589
    .line 1590
    .line 1591
    .line 1592
    .line 1593
    .line 1594
    .line 1595
    .line 1596
    .line 1597
    .line 1598
    .line 1599
    .line 1600
    .line 1601
    .line 1602
    .line 1603
    .line 1604
    .line 1605
    .line 1606
    .line 1607
    .line 1608
    .line 1609
    .line 1610
    .line 1611
    .line 1612
    .line 1613
    .line 1614
    .line 1615
    .line 1616
    .line 1617
    .line 1618
    .line 1619
    .line 1620
    .line 1621
    .line 1622
    .line 1623
    .line 1624
    .line 1625
    .line 1626
    .line 1627
    .line 1628
    .line 1629
    .line 1630
    .line 1631
    .line 1632
    .line 1633
    .line 1634
    .line 1635
    .line 1636
    .line 1637
    .line 1638
    .line 1639
    .line 1640
    .line 1641
    .line 1642
    .line 1643
    .line 1644
    .line 1645
    .line 1646
    .line 1647
    .line 1648
    .line 1649
    .line 1650
    .line 1651
    .line 1652
    .line 1653
    .line 1654
    .line 1655
    .line 1656
    .line 1657
    .line 1658
    .line 1659
    .line 1660
    .line 1661
    .line 1662
    .line 1663
    .line 1664
    .line 1665
    .line 1666
    .line 1667
    .line 1668
    .line 1669
    .line 1670
    .line 1671
    .line 1672
    .line 1673
    .line 1674
    .line 1675
    .line 1676
    .line 1677
    .line 1678
    .line 1679
    .line 1680
    .line 1681
    .line 1682
    .line 1683
    .line 1684
    .line 1685
    .line 1686
    .line 1687
    .line 1688
    .line 1689
    .line 1690
    .line 1691
    .line 1692
    .line 1693
    .line 1694
    .line 1695
    .line 1696
    .line 1697
    .line 1698
    .line 1699
    .line 1700
    .line 1701
    .line 1702
    .line 1703
    .line 1704
    .line 1705
    .line 1706
    .line 1707
    .line 1708
    .line 1709
    .line 1710
    .line 1711
    .line 1712
    .line 1713
    .line 1714
    .line 1715
    .line 1716
    .line 1717
    .line 1718
    .line 1719
    .line 1720
    .line 1721
    .line 1722
    .line 1723
    .line 1724
    .line 1725
    .line 1726
    .line 1727
    .line 1728
    .line 1729
    .line 1730
    .line 1731
    .line 1732
    .line 1733
    .line 1734
    .line 1735
    .line 1736
    .line 1737
    .line 1738
    .line 1739
    .line 1740
    .line 1741
    .line 1742
    .line 1743
    .line 1744
    .line 1745
    .line 1746
    .line 1747
    .line 1748
    .line 1749
    .line 1750
    .line 1751
    .line 1752
    .line 1753
    .line 1754
    .line 1755
    .line 1756
    .line 1757
    .line 1758
    .line 1759
    .line 1760
    .line 1761
    .line 1762
    .line 1763
    .line 1764
    .line 1765
    .line 1766
    .line 1767
    .line 1768
    .line 1769
    .line 1770
    .line 1771
    .line 1772
    .line 1773
    .line 1774
    .line 1775
    .line 1776
    .line 1777
    .line 1778
    .line 1779
    .line 1780
    .line 1781
    .line 1782
    .line 1783
    .line 1784
    .line 1785
    .line 1786
    .line 1787
    .line 1788
    .line 1789
    .line 1790
    .line 1791
    .line 1792
    .line 1793
    .line 1794
    .line 1795
    .line 1796
    .line 1797
    .line 1798
    .line 1799
    .line 1800
    .line 1801
    .line 1802
    .line 1803
    .line 1804
    .line 1805
    .line 1806
    .line 1807
    .line 1808
    .line 1809
    .line 1810
    .line 1811
    .line 1812
    .line 1813
    .line 1814
    .line 1815
    .line 1816
    .line 1817
    .line 1818
    .line 1819
    .line 1820
    .line 1821
    .line 1822
    .line 1823
    .line 1824
    .line 1825
    .line 1826
    .line 1827
    .line 1828
    .line 1829
    .line 1830
    .line 1831
    .line 1832
    .line 1833
    .line 1834
    .line 1835
    .line 1836
    .line 1837
    .line 1838
    .line 1839
    .line 1840
    .line 1841
    .line 1842
    .line 1843
    .line 1844
    .line 1845
    .line 1846
    .line 1847
    .line 1848
    .line 1849
    .line 1850
    .line 1851
    .line 1852
    .line 1853
    .line 1854
    .line 1855
    .line 1856
    .line 1857
    .line 1858
    .line 1859
    .line 1860
    .line 1861
    .line 1862
    .line 1863
    .line 1864
    .line 1865
    .line 1866
    .line 1867
    .line 1868
    .line 1869
    .line 1870
    .line 1871
    .line 1872
    .line 1873
    .line 1874
    .line 1875
    .line 1876
    .line 1877
    .line 1878
    .line 1879
    .line 1880
    .line 1881
    .line 1882
    .line 1883
    .line 1884
    .line 1885
    .line 1886
    .line 1887
    .line 1888
    .line 1889
    .line 1890
    .line 1891
    .line 1892
    .line 1893
    .line 1894
    .line 1895
    .line 1896
    .line 1897
    .line 1898
    .line 1899
    .line 1900
    .line 1901
    .line 1902
    .line 1903
    .line 1904
    .line 1905
    .line 1906
    .line 1907
    .line 1908
    .line 1909
    .line 1910
    .line 1911
    .line 1912
    .line 1913
    .line 1914
    .line 1915
    .line 1916
    .line 1917
    .line 1918
    .line 1919
    .line 1920
    .line 1921
    .line 1922
    .line 1923
    .line 1924
    .line 1925
    .line 1926
    .line 1927
    .line 1928
    .line 1929
    .line 1930
    .line 1931
    .line 1932
    .line 1933
    .line 1934
    .line 1935
    .line 1936
    .line 1937
    .line 1938
    .line 1939
    .line 1940
    .line 1941
    .line 1942
    .line 1943
    .line 1944
    .line 1945
    .line 1946
    .line 1947
    .line 1948
    .line 1949
    .line 1950
    .line 1951
    .line 1952
    .line 1953
    .line 1954
    .line 1955
    .line 1956
    .line 1957
    .line 1958
    .line 1959
    .line 1960
    .line 1961
    .line 1962
    .line 1963
    .line 1964
    .line 1965
    .line 1966
    .line 1967
    .line 1968
    .line 1969
    .line 1970
    .line 1971
    .line 1972
    .line 1973
    .line 1974
    .line 1975
    .line 1976
    .line 1977
    .line 1978
    .line 1979
    .line 1980
    .line 1981
    .line 1982
    .line 1983
    .line 1984
    .line 1985
    .line 1986
    .line 1987
    .line 1988
    .line 1989
    .line 1990
    .line 1991
    .line 1992
    .line 1993
    .line 1994
    .line 1995
    .line 1996
    .line 1997
    .line 1998
    .line 1999
    .line 2000
    .line 2001
    .line 2002
    .line 2003
    .line 2004
    .line 2005
    .line 2006
    .line 2007
    .line 2008
    .line 2009
    .line 2010
    .line 2011
    .line 2012
    .line 2013
    .line 2014
    .line 2015
    .line 2016
    .line 2017
    .line 2018
    .line 2019
    .line 2020
    .line 2021
    .line 2022
    .line 2023
    .line 2024
    .line 2025
    .line 2026
    .line 2027
    .line 2028
    .line 2029
    .line 2030
    .line 2031
    .line 2032
    .line 2033
    .line 2034
    .line 2035
    .line 2036
    .line 2037
    .line 2038
    .line 2039
    .line 2040
    .line 2041
    .line 2042
    .line 2043
    .line 2044
    .line 2045
    .line 2046
    .line 2047
    .line 2048
    .line 2049
    .line 2050
    .line 2051
    .line 2052
    .line 2053
    .line 2054
    .line 2055
    .line 2056
    .line 2057
    .line 2058
    .line 2059
    .line 2060
    .line 2061
    .line 2062
    .line 2063
    .line 2064
    .line 2065
    .line 2066
    .line 2067
    .line 2068
    .line 2069
    .line 2070
    .line 2071
    .line 2072
    .line 2073
    .line 2074
    .line 2075
    .line 2076
    .line 2077
    .line 2078
    .line 2079
    .line 2080
    .line 2081
    .line 2082
    .line 2083
    .line 2084
    .line 2085
    .line 2086
    .line 2087
    .line 2088
    .line 2089
    .line 2090
    .line 2091
    .line 2092
    .line 2093
    .line 2094
    .line 2095
    .line 2096
    .line 2097
    .line 2098
    .line 2099
    .line 2100
    .line 2101
    .line 2102
    .line 2103
    .line 2104
    .line 2105
    .line 2106
    .line 2107
    .line 2108
    .line 2109
    .line 2110
    .line 2111
    .line 2112
    .line 2113
    .line 2114
    .line 2115
    .line 2116
    .line 2117
    .line 2118
    .line 2119
    .line 2120
    .line 2121
    .line 2122
    .line 2123
    .line 2124
    .line 2125
    .line 2126
    .line 2127
    .line 2128
    .line 2129
    .line 2130
    .line 2131
    .line 2132
    .line 2133
    .line 2134
    .line 2135
    .line 2136
    .line 2137
    .line 2138
    .line 2139
    .line 2140
    .line 2141
    .line 2142
    .line 2143
    .line 2144
    .line 2145
    .line 2146
    .line 2147
    .line 2148
    .line 2149
    .line 2150
    .line 2151
    .line 2152
    .line 2153
    .line 2154
    .line 2155
    .line 2156
    .line 2157
    .line 2158
    .line 2159
    .line 2160
    .line 2161
    .line 2162
    .line 2163
    .line 2164
    .line 2165
    .line 2166
    .line 2167
    .line 2168
    .line 2169
    .line 2170
    .line 2171
    .line 2172
    .line 2173
    .line 2174
    .line 2175
    .line 2176
    .line 2177
    .line 2178
    .line 2179
    .line 2180
    .line 2181
    .line 2182
    .line 2183
    .line 2184
    .line 2185
    .line 2186
    .line 2187
    .line 2188
    .line 2189
    .line 2190
    .line 2191
    .line 2192
    .line 2193
    .line 2194
    .line 2195
    .line 2196
    .line 2197
    .line 2198
    .line 2199
    .line 2200
    .line 2201
    .line 2202
    .line 2203
    .line 2204
    .line 2205
    .line 2206
    .line 2207
    .line 2208
    .line 2209
    .line 2210
    .line 2211
    .line 2212
    .line 2213
    .line 2214
    .line 2215
    .line 2216
    .line 2217
    .line 2218
    .line 2219
    .line 2220
    .line 2221
    .line 2222
    .line 2223
    .line 2224
    .line 2225
    .line 2226
    .line 2227
    .line 2228
    .line 2229
    .line 2230
    .line 2231
    .line 2232
    .line 2233
    .line 2234
    .line 2235
    .line 2236
    .line 2237
    .line 2238
    .line 2239
    .line 2240
    .line 2241
    .line 2242
    .line 2243
    .line 2244
    .line 2245
    .line 2246
    .line 2247
    .line 2248
    .line 2249
    .line 2250
    .line 2251
    .line 2252
    .line 2253
    .line 2254
    .line 2255
    .line 2256
    .line 2257
    .line 2258
    .line 2259
    .line 2260
    .line 2261
    .line 2262
    .line 2263
    .line 2264
    .line 2265
    .line 2266
    .line 2267
    .line 2268
    .line 2269
    .line 2270
    .line 2271
    .line 2272
    .line 2273
    .line 2274
    .line 2275
    .line 2276
    .line 2277
    .line 2278
    .line 2279
    .line 2280
    .line 2281
    .line 2282
    .line 2283
    .line 2284
    .line 2285
    .line 2286
    .line 2287
    .line 2288
    .line 2289
    .line 2290
    .line 2291
    .line 2292
    .line 2293
    .line 2294
    .line 2295
    .line 2296
    .line 2297
    .line 2298
    .line 2299
    .line 2300
    .line 2301
    .line 2302
    .line 2303
    .line 2304
    .line 2305
    .line 2306
    .line 2307
    .line 2308
    .line 2309
    .line 2310
    .line 2311
    .line 2312
    .line 2313
    .line 2314
    .line 2315
    .line 2316
    .line 2317
    .line 2318
    .line 2319
    .line 2320
    .line 2321
    .line 2322
    .line 2323
    .line 2324
    .line 2325
    .line 2326
    .line 2327
    .line 2328
    .line 2329
    .line 2330
    .line 2331
.end method
