.class public Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;
.super Landroidx/fragment/app/Fragment;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/HttpLog$Listener;
.implements Landroidx/core/view/MenuProvider;
.implements Landroidx/appcompat/widget/SearchView$OnQueryTextListener;


# static fields
.field static final synthetic $assertionsDisabled:Z = false

.field private static final TAG:Ljava/lang/String; = "HttpLogFragment"


# instance fields
.field private autoScroll:Z

.field private final filterLauncher:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher;"
        }
    .end annotation
.end field

.field private final harFileLauncher:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher;"
        }
    .end annotation
.end field

.field private listenerSet:Z

.field private mActionMode:Landroidx/appcompat/view/ActionMode;

.field private final mActionModeCallback:Landroidx/appcompat/view/ActionMode$Callback;

.field private mActiveFilter:Lcom/google/android/material/chip/ChipGroup;

.field private mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

.field private mAlertDialog:Landroidx/appcompat/app/AlertDialog;

.field private mApps:Lcom/emanuelef/remote_capture/AppsResolver;

.field private mEmptyText:Landroid/widget/TextView;

.field private mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

.field private mFabDownMargin:I

.field private mHandler:Landroid/os/Handler;

.field private mHarFname:Landroid/net/Uri;

.field private mMenuItemSearch:Landroid/view/MenuItem;

.field private mQueryToApply:Ljava/lang/String;

.field private mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

.field private mSave:Landroid/view/MenuItem;

.field private mSaveAsHar:Landroid/view/MenuItem;

.field private mSearchView:Landroidx/appcompat/widget/SearchView;

.field private mSizeSlider:Lcom/google/android/material/slider/Slider;

.field private mSizeSliderActive:Z

.field private mTxtFname:Landroid/net/Uri;

.field private final txtFileLauncher:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher;"
        }
    .end annotation
.end field


# direct methods
.method public static synthetic $r8$lambda$7-zKANubPaE77mBV98mOCuEESrw(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$exportHttpLogHar$20(ZLcom/emanuelef/remote_capture/Utils$UriStat;)V

    return-void
.end method

.method public static synthetic $r8$lambda$C0Z4Wx4jCPQjjfsZOstGdnm7AAM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/view/View;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$4(Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$CDk2PIljtaBpyPQm-8gz2JUzkdA(F)Ljava/lang/String;
    .locals 0

    .line 1
    invoke-static {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$0(F)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$CJasgA0nCTi8MLylO-LqIFWkizY(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$6(Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$DmndOOANggw6wvoUf_sbBcT99w4(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$dumpHttpLog$15(ZLcom/emanuelef/remote_capture/Utils$UriStat;)V

    return-void
.end method

.method public static synthetic $r8$lambda$JBNhCeYDZgzUoB2E7v1d776FAfM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$dumpHttpLog$16(Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;)V

    return-void
.end method

.method public static synthetic $r8$lambda$N-NNphsC23P4KvNi3zUfOCOUJhQ(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$exportHttpLogHar$21(Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;)V

    return-void
.end method

.method public static synthetic $r8$lambda$OaacA1e8BQ9jF_7aXYdpvryhUh4(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroidx/activity/result/ActivityResult;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->txtFileResult(Landroidx/activity/result/ActivityResult;)V

    return-void
.end method

.method public static synthetic $r8$lambda$R1B-Oz73OZKxklavFJPP3-U7zYg(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->recheckScroll()V

    return-void
.end method

.method public static synthetic $r8$lambda$UG4qS9IM8G1-7-L6LmHLn5I3-Bo([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$dumpHttpLog$12([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$YqfMasf0rWzyZfwBTVyjCHOzCBc([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    invoke-static {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$dumpHttpLog$13([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$YxJNokvswaNnQy5dRH-Z1BRyMtM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroidx/activity/result/ActivityResult;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->harFileResult(Landroidx/activity/result/ActivityResult;)V

    return-void
.end method

.method public static synthetic $r8$lambda$bScUgZQuxxcWQxZukoQB6ykL5x4(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$5(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$c-mEyVjwZ0tpGPOlmFpNBzPBKOM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onHttpRequestUpdated$10(I)V

    return-void
.end method

.method public static synthetic $r8$lambda$cMY6wzR6Pz0c4w4_iqXsgkUWzvk(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onHttpRequestAdded$9(I)V

    return-void
.end method

.method public static synthetic $r8$lambda$czbk9UyB3jhV5U-UwD9QO46YiQU(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onHttpRequestsClear$11()V

    return-void
.end method

.method public static synthetic $r8$lambda$fcSYt1hA1qBou_VgjfnZlCxeTCE(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroidx/activity/result/ActivityResult;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->filterResult(Landroidx/activity/result/ActivityResult;)V

    return-void
.end method

.method public static synthetic $r8$lambda$mNhDnIW6nIrUMfA3Q0_3Aqxh_Nw(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Lcom/google/android/material/slider/Slider;FZ)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$1(Lcom/google/android/material/slider/Slider;FZ)V

    return-void
.end method

.method public static synthetic $r8$lambda$nNzUEAO4yRkaAtY9AKpzxFEyIwA([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    invoke-static {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$exportHttpLogHar$18([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$olnnR4LyEkL6T2S6xDPxD6llHSY([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$exportHttpLogHar$17([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$q9B2p1nMh6PW4HZilJxjRvhpKsY(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$dumpHttpLog$14(Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$rYz5Kl0S2e49r0QN0dZs4RobTbE(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$7(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$uMc_xODVJEZw0i8kYC1ixTTkz-8(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$8(Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    return-void
.end method

.method public static synthetic $r8$lambda$vbN73uWBtB-jR3BfdUFQsBGjCPo(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$3(Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$wrZV6vDcytJyDcMeN3-D_L-3cSM(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/util/ArrayList;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$onViewCreated$2(Lcom/google/android/material/chip/ChipGroup;Ljava/util/List;)V

    return-void
.end method

.method public static synthetic $r8$lambda$yP2XG3phEFx-Usnvj9zt2U4nIe8(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->lambda$exportHttpLogHar$19(Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static bridge synthetic -$$Nest$fgetmAdapter(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fputmActionMode(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V
    .locals 1

    .line 1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    return-void
.end method

.method public static bridge synthetic -$$Nest$fputmSizeSliderActive(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Z)V
    .locals 0

    .line 1
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSliderActive:Z

    return-void
.end method

.method public static bridge synthetic -$$Nest$mrecheckMaxPayloadSize(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->recheckMaxPayloadSize()V

    return-void
.end method

.method public static bridge synthetic -$$Nest$mrecheckScroll(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->recheckScroll()V

    return-void
.end method

.method public static bridge synthetic -$$Nest$mupdateActionModeTitle(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->updateActionModeTitle()V

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .line 1
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDownMargin:I

    .line 6
    .line 7
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSliderActive:Z

    .line 8
    .line 9
    new-instance v0, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;

    .line 10
    .line 11
    const/4 v1, 0x3

    .line 12
    invoke-direct {v0, v1}, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;-><init>(I)V

    .line 13
    .line 14
    .line 15
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;

    .line 16
    .line 17
    const/4 v2, 0x0

    .line 18
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 19
    .line 20
    .line 21
    invoke-virtual {p0, v0, v1}, Landroidx/fragment/app/Fragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->filterLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 26
    .line 27
    new-instance v0, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;

    .line 28
    .line 29
    const/4 v1, 0x3

    .line 30
    invoke-direct {v0, v1}, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;-><init>(I)V

    .line 31
    .line 32
    .line 33
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;

    .line 34
    .line 35
    const/4 v2, 0x1

    .line 36
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 37
    .line 38
    .line 39
    invoke-virtual {p0, v0, v1}, Landroidx/fragment/app/Fragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->txtFileLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 44
    .line 45
    new-instance v0, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;

    .line 46
    .line 47
    const/4 v1, 0x3

    .line 48
    invoke-direct {v0, v1}, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;-><init>(I)V

    .line 49
    .line 50
    .line 51
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;

    .line 52
    .line 53
    const/4 v2, 0x2

    .line 54
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 55
    .line 56
    .line 57
    invoke-virtual {p0, v0, v1}, Landroidx/fragment/app/Fragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    .line 58
    .line 59
    .line 60
    move-result-object v0

    .line 61
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->harFileLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 62
    .line 63
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;

    .line 64
    .line 65
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V

    .line 66
    .line 67
    .line 68
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionModeCallback:Landroidx/appcompat/view/ActionMode$Callback;

    .line 69
    .line 70
    return-void
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

.method private dumpHttpLog()V
    .locals 12

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mTxtFname:Landroid/net/Uri;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 7
    .line 8
    const/4 v1, 0x1

    .line 9
    const/4 v2, 0x0

    .line 10
    if-eqz v0, :cond_1

    .line 11
    .line 12
    const/4 v0, 0x1

    .line 13
    goto :goto_0

    .line 14
    :cond_1
    const/4 v0, 0x0

    .line 15
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    .line 16
    .line 17
    const-string v4, "Writing HTTP log file: "

    .line 18
    .line 19
    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 20
    .line 21
    .line 22
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mTxtFname:Landroid/net/Uri;

    .line 23
    .line 24
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 25
    .line 26
    .line 27
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object v3

    .line 31
    const-string v4, "HttpLogFragment"

    .line 32
    .line 33
    invoke-static {v4, v3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    .line 35
    .line 36
    new-instance v8, Ljava/util/ArrayList;

    .line 37
    .line 38
    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 39
    .line 40
    .line 41
    const/4 v3, 0x0

    .line 42
    :goto_1
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 43
    .line 44
    invoke-virtual {v4}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getItemCount()I

    .line 45
    .line 46
    .line 47
    move-result v4

    .line 48
    if-ge v3, v4, :cond_4

    .line 49
    .line 50
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 51
    .line 52
    invoke-virtual {v4, v3}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getItem(I)Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 53
    .line 54
    .line 55
    move-result-object v4

    .line 56
    if-eqz v4, :cond_3

    .line 57
    .line 58
    if-eqz v0, :cond_2

    .line 59
    .line 60
    iget-object v5, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 61
    .line 62
    invoke-virtual {v5, v4}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->isSelected(Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;)Z

    .line 63
    .line 64
    .line 65
    move-result v5

    .line 66
    if-eqz v5, :cond_3

    .line 67
    .line 68
    :cond_2
    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 69
    .line 70
    .line 71
    :cond_3
    add-int/lit8 v3, v3, 0x1

    .line 72
    .line 73
    goto :goto_1

    .line 74
    :cond_4
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    new-instance v10, Landroid/os/Handler;

    .line 79
    .line 80
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 81
    .line 82
    .line 83
    move-result-object v3

    .line 84
    invoke-direct {v10, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 85
    .line 86
    .line 87
    new-array v9, v1, [Z

    .line 88
    .line 89
    aput-boolean v2, v9, v2

    .line 90
    .line 91
    new-instance v3, Lcom/android/billingclient/api/zzbv;

    .line 92
    .line 93
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 94
    .line 95
    .line 96
    move-result-object v4

    .line 97
    invoke-direct {v3, v4}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 98
    .line 99
    .line 100
    const v4, 0x7f140108

    .line 101
    .line 102
    .line 103
    invoke-virtual {v3, v4}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 104
    .line 105
    .line 106
    const v4, 0x7f140107

    .line 107
    .line 108
    .line 109
    invoke-virtual {v3, v4}, Lcom/android/billingclient/api/zzbv;->setMessage(I)V

    .line 110
    .line 111
    .line 112
    new-instance v4, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;

    .line 113
    .line 114
    const/4 v5, 0x2

    .line 115
    invoke-direct {v4, v9, v0, v5}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;-><init>([ZLjava/util/concurrent/ExecutorService;I)V

    .line 116
    .line 117
    .line 118
    const/high16 v6, 0x1040000

    .line 119
    .line 120
    invoke-virtual {v3, v6, v4}, Lcom/android/billingclient/api/zzbv;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 121
    .line 122
    .line 123
    invoke-virtual {v3}, Lcom/android/billingclient/api/zzbv;->create()Landroidx/appcompat/app/AlertDialog;

    .line 124
    .line 125
    .line 126
    move-result-object v3

    .line 127
    iput-object v3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 128
    .line 129
    invoke-virtual {v3, v2}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 130
    .line 131
    .line 132
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 133
    .line 134
    invoke-virtual {v2}, Landroid/app/Dialog;->show()V

    .line 135
    .line 136
    .line 137
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 138
    .line 139
    new-instance v3, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda5;

    .line 140
    .line 141
    invoke-direct {v3, v9, v0, v5}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda5;-><init>([ZLjava/util/concurrent/ExecutorService;I)V

    .line 142
    .line 143
    .line 144
    invoke-virtual {v2, v3}, Landroid/app/Dialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 145
    .line 146
    .line 147
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 148
    .line 149
    new-instance v3, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;

    .line 150
    .line 151
    invoke-direct {v3, p0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 152
    .line 153
    .line 154
    invoke-virtual {v2, v3}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 155
    .line 156
    .line 157
    iget-object v7, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mTxtFname:Landroid/net/Uri;

    .line 158
    .line 159
    const/4 v1, 0x0

    .line 160
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mTxtFname:Landroid/net/Uri;

    .line 161
    .line 162
    new-instance v5, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;

    .line 163
    .line 164
    const/4 v11, 0x1

    .line 165
    move-object v6, p0

    .line 166
    invoke-direct/range {v5 .. v11}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;I)V

    .line 167
    .line 168
    .line 169
    invoke-interface {v0, v5}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 170
    .line 171
    .line 172
    return-void
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

.method private exportHttpLogHar()V
    .locals 12

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHarFname:Landroid/net/Uri;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 7
    .line 8
    const/4 v1, 0x1

    .line 9
    const/4 v2, 0x0

    .line 10
    if-eqz v0, :cond_1

    .line 11
    .line 12
    const/4 v0, 0x1

    .line 13
    goto :goto_0

    .line 14
    :cond_1
    const/4 v0, 0x0

    .line 15
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    .line 16
    .line 17
    const-string v4, "Writing HAR file: "

    .line 18
    .line 19
    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 20
    .line 21
    .line 22
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHarFname:Landroid/net/Uri;

    .line 23
    .line 24
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 25
    .line 26
    .line 27
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object v3

    .line 31
    const-string v4, "HttpLogFragment"

    .line 32
    .line 33
    invoke-static {v4, v3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    .line 35
    .line 36
    new-instance v8, Ljava/util/ArrayList;

    .line 37
    .line 38
    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 39
    .line 40
    .line 41
    const/4 v3, 0x0

    .line 42
    :goto_1
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 43
    .line 44
    invoke-virtual {v4}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getItemCount()I

    .line 45
    .line 46
    .line 47
    move-result v4

    .line 48
    if-ge v3, v4, :cond_4

    .line 49
    .line 50
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 51
    .line 52
    invoke-virtual {v4, v3}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getItem(I)Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 53
    .line 54
    .line 55
    move-result-object v4

    .line 56
    if-eqz v4, :cond_3

    .line 57
    .line 58
    if-eqz v0, :cond_2

    .line 59
    .line 60
    iget-object v5, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 61
    .line 62
    invoke-virtual {v5, v4}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->isSelected(Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;)Z

    .line 63
    .line 64
    .line 65
    move-result v5

    .line 66
    if-eqz v5, :cond_3

    .line 67
    .line 68
    :cond_2
    invoke-virtual {v8, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 69
    .line 70
    .line 71
    :cond_3
    add-int/lit8 v3, v3, 0x1

    .line 72
    .line 73
    goto :goto_1

    .line 74
    :cond_4
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    new-instance v10, Landroid/os/Handler;

    .line 79
    .line 80
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 81
    .line 82
    .line 83
    move-result-object v3

    .line 84
    invoke-direct {v10, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 85
    .line 86
    .line 87
    new-array v9, v1, [Z

    .line 88
    .line 89
    aput-boolean v2, v9, v2

    .line 90
    .line 91
    new-instance v1, Lcom/android/billingclient/api/zzbv;

    .line 92
    .line 93
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 94
    .line 95
    .line 96
    move-result-object v3

    .line 97
    invoke-direct {v1, v3}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 98
    .line 99
    .line 100
    const v3, 0x7f140108

    .line 101
    .line 102
    .line 103
    invoke-virtual {v1, v3}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 104
    .line 105
    .line 106
    const v3, 0x7f140107

    .line 107
    .line 108
    .line 109
    invoke-virtual {v1, v3}, Lcom/android/billingclient/api/zzbv;->setMessage(I)V

    .line 110
    .line 111
    .line 112
    new-instance v3, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;

    .line 113
    .line 114
    invoke-direct {v3, v9, v0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;-><init>([ZLjava/util/concurrent/ExecutorService;I)V

    .line 115
    .line 116
    .line 117
    const/high16 v4, 0x1040000

    .line 118
    .line 119
    invoke-virtual {v1, v4, v3}, Lcom/android/billingclient/api/zzbv;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 120
    .line 121
    .line 122
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzbv;->create()Landroidx/appcompat/app/AlertDialog;

    .line 123
    .line 124
    .line 125
    move-result-object v1

    .line 126
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 127
    .line 128
    invoke-virtual {v1, v2}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 129
    .line 130
    .line 131
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 132
    .line 133
    invoke-virtual {v1}, Landroid/app/Dialog;->show()V

    .line 134
    .line 135
    .line 136
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 137
    .line 138
    new-instance v3, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda5;

    .line 139
    .line 140
    invoke-direct {v3, v9, v0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda5;-><init>([ZLjava/util/concurrent/ExecutorService;I)V

    .line 141
    .line 142
    .line 143
    invoke-virtual {v1, v3}, Landroid/app/Dialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 144
    .line 145
    .line 146
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 147
    .line 148
    new-instance v3, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;

    .line 149
    .line 150
    invoke-direct {v3, p0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda6;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 151
    .line 152
    .line 153
    invoke-virtual {v1, v3}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 154
    .line 155
    .line 156
    iget-object v7, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHarFname:Landroid/net/Uri;

    .line 157
    .line 158
    const/4 v1, 0x0

    .line 159
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHarFname:Landroid/net/Uri;

    .line 160
    .line 161
    new-instance v5, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;

    .line 162
    .line 163
    const/4 v11, 0x0

    .line 164
    move-object v6, p0

    .line 165
    invoke-direct/range {v5 .. v11}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda7;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;I)V

    .line 166
    .line 167
    .line 168
    invoke-interface {v0, v5}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 169
    .line 170
    .line 171
    return-void
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

.method private filterResult(Landroidx/activity/result/ActivityResult;)V
    .locals 2

    .line 1
    iget v0, p1, Landroidx/activity/result/ActivityResult;->mResultCode:I

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    if-ne v0, v1, :cond_0

    .line 5
    .line 6
    iget-object p1, p1, Landroidx/activity/result/ActivityResult;->mData:Landroid/content/Intent;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    const-string v0, "http_log_filter"

    .line 11
    .line 12
    const-class v1, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 13
    .line 14
    invoke-static {p1, v0, v1}, Lcom/emanuelef/remote_capture/Utils;->getSerializableExtra(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Class;)Ljava/io/Serializable;

    .line 15
    .line 16
    .line 17
    move-result-object p1

    .line 18
    check-cast p1, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 19
    .line 20
    if-eqz p1, :cond_0

    .line 21
    .line 22
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 23
    .line 24
    iput-object p1, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 25
    .line 26
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->refreshFilteredItems()V

    .line 27
    .line 28
    .line 29
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshActiveFilter()V

    .line 30
    .line 31
    .line 32
    :cond_0
    return-void
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

.method private getMaxPayloadSize()J
    .locals 7

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getHttpLog()Lcom/emanuelef/remote_capture/HttpLog;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-wide/16 v1, 0x0

    .line 6
    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    return-wide v1

    .line 10
    :cond_0
    monitor-enter v0

    .line 11
    const/4 v3, 0x0

    .line 12
    :goto_0
    :try_start_0
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/HttpLog;->getSize()I

    .line 13
    .line 14
    .line 15
    move-result v4

    .line 16
    if-ge v3, v4, :cond_3

    .line 17
    .line 18
    invoke-virtual {v0, v3}, Lcom/emanuelef/remote_capture/HttpLog;->getRequest(I)Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 19
    .line 20
    .line 21
    move-result-object v4

    .line 22
    if-eqz v4, :cond_2

    .line 23
    .line 24
    iget-object v5, v4, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->reply:Lcom/emanuelef/remote_capture/HttpLog$HttpReply;

    .line 25
    .line 26
    if-eqz v5, :cond_1

    .line 27
    .line 28
    iget v4, v4, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->bodyLength:I

    .line 29
    .line 30
    iget v5, v5, Lcom/emanuelef/remote_capture/HttpLog$HttpReply;->bodyLength:I

    .line 31
    .line 32
    add-int/2addr v4, v5

    .line 33
    goto :goto_1

    .line 34
    :catchall_0
    move-exception v1

    .line 35
    goto :goto_2

    .line 36
    :cond_1
    iget v4, v4, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->bodyLength:I

    .line 37
    .line 38
    :goto_1
    int-to-long v4, v4

    .line 39
    cmp-long v6, v4, v1

    .line 40
    .line 41
    if-lez v6, :cond_2

    .line 42
    .line 43
    move-wide v1, v4

    .line 44
    :cond_2
    add-int/lit8 v3, v3, 0x1

    .line 45
    .line 46
    goto :goto_0

    .line 47
    :cond_3
    monitor-exit v0

    .line 48
    return-wide v1

    .line 49
    :goto_2
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 50
    throw v1
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method private harFileResult(Landroidx/activity/result/ActivityResult;)V
    .locals 2

    .line 1
    iget v0, p1, Landroidx/activity/result/ActivityResult;->mResultCode:I

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    if-ne v0, v1, :cond_0

    .line 5
    .line 6
    iget-object p1, p1, Landroidx/activity/result/ActivityResult;->mData:Landroid/content/Intent;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHarFname:Landroid/net/Uri;

    .line 15
    .line 16
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->exportHttpLogHar()V

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :cond_0
    const/4 p1, 0x0

    .line 21
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHarFname:Landroid/net/Uri;

    .line 22
    .line 23
    return-void
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

.method private static synthetic lambda$dumpHttpLog$12([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    const-string p2, "HttpLogFragment"

    .line 2
    .line 3
    const-string p3, "Abort TXT export"

    .line 4
    .line 5
    invoke-static {p2, p3}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 p2, 0x0

    .line 9
    const/4 p3, 0x1

    .line 10
    aput-boolean p3, p0, p2

    .line 11
    .line 12
    invoke-interface {p1}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    .line 13
    .line 14
    .line 15
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method

.method private static synthetic lambda$dumpHttpLog$13([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V
    .locals 1

    .line 1
    const-string p2, "HttpLogFragment"

    .line 2
    .line 3
    const-string v0, "Abort TXT export (back button)"

    .line 4
    .line 5
    invoke-static {p2, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 p2, 0x0

    .line 9
    const/4 v0, 0x1

    .line 10
    aput-boolean v0, p0, p2

    .line 11
    .line 12
    invoke-interface {p1}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    .line 13
    .line 14
    .line 15
    return-void
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

.method private synthetic lambda$dumpHttpLog$14(Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    const/4 p1, 0x0

    .line 2
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

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
.end method

.method private synthetic lambda$dumpHttpLog$15(ZLcom/emanuelef/remote_capture/Utils$UriStat;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroidx/appcompat/app/AlertDialog;->dismiss()V

    .line 6
    .line 7
    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    if-eqz p1, :cond_2

    .line 10
    .line 11
    if-eqz p2, :cond_1

    .line 12
    .line 13
    const p1, 0x7f14010e

    .line 14
    .line 15
    .line 16
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    iget-object p2, p2, Lcom/emanuelef/remote_capture/Utils$UriStat;->name:Ljava/lang/String;

    .line 21
    .line 22
    const/4 v1, 0x1

    .line 23
    new-array v1, v1, [Ljava/lang/Object;

    .line 24
    .line 25
    aput-object p2, v1, v0

    .line 26
    .line 27
    invoke-static {p1, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 32
    .line 33
    .line 34
    move-result-object p2

    .line 35
    invoke-static {p2, p1, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 36
    .line 37
    .line 38
    move-result-object p1

    .line 39
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 40
    .line 41
    .line 42
    goto :goto_0

    .line 43
    :cond_1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 44
    .line 45
    .line 46
    move-result-object p1

    .line 47
    const p2, 0x7f14027f

    .line 48
    .line 49
    .line 50
    new-array v0, v0, [Ljava/lang/Object;

    .line 51
    .line 52
    invoke-static {p1, p2, v0}, Lcom/emanuelef/remote_capture/Utils;->showToast(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 53
    .line 54
    .line 55
    goto :goto_0

    .line 56
    :cond_2
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 57
    .line 58
    .line 59
    move-result-object p1

    .line 60
    const p2, 0x7f14006e

    .line 61
    .line 62
    .line 63
    new-array v0, v0, [Ljava/lang/Object;

    .line 64
    .line 65
    invoke-static {p1, p2, v0}, Lcom/emanuelef/remote_capture/Utils;->showToast(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 66
    .line 67
    .line 68
    :goto_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 69
    .line 70
    if-eqz p1, :cond_3

    .line 71
    .line 72
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 73
    .line 74
    .line 75
    :cond_3
    return-void
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

.method private synthetic lambda$dumpHttpLog$16(Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;)V
    .locals 15

    .line 1
    move-object/from16 v1, p1

    .line 2
    .line 3
    const-string v0, "]\n"

    .line 4
    .line 5
    const-string v2, "["

    .line 6
    .line 7
    const/4 v3, 0x0

    .line 8
    :try_start_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 9
    .line 10
    .line 11
    move-result-object v4

    .line 12
    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    .line 13
    .line 14
    .line 15
    move-result-object v4

    .line 16
    const-string v5, "rwt"

    .line 17
    .line 18
    invoke-virtual {v4, v1, v5}, Landroid/content/ContentResolver;->openOutputStream(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/OutputStream;

    .line 19
    .line 20
    .line 21
    move-result-object v4

    .line 22
    if-eqz v4, :cond_6

    .line 23
    .line 24
    invoke-virtual/range {p2 .. p2}, Ljava/util/ArrayList;->size()I

    .line 25
    .line 26
    .line 27
    move-result v5

    .line 28
    const/4 v6, 0x0

    .line 29
    :goto_0
    if-ge v6, v5, :cond_5

    .line 30
    .line 31
    move-object/from16 v7, p2

    .line 32
    .line 33
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 34
    .line 35
    .line 36
    move-result-object v8

    .line 37
    add-int/lit8 v6, v6, 0x1

    .line 38
    .line 39
    check-cast v8, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 40
    .line 41
    invoke-static {}, Ljava/lang/Thread;->interrupted()Z

    .line 42
    .line 43
    .line 44
    move-result v9

    .line 45
    if-eqz v9, :cond_0

    .line 46
    .line 47
    goto/16 :goto_2

    .line 48
    .line 49
    :cond_0
    new-instance v9, Ljava/lang/StringBuilder;

    .line 50
    .line 51
    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    .line 52
    .line 53
    .line 54
    iget-object v10, v8, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 55
    .line 56
    iget v11, v8, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->firstChunkPos:I

    .line 57
    .line 58
    invoke-virtual {v10, v11}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getHttpRequestChunk(I)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 59
    .line 60
    .line 61
    move-result-object v10

    .line 62
    if-eqz v10, :cond_1

    .line 63
    .line 64
    new-instance v11, Ljava/lang/String;

    .line 65
    .line 66
    iget-object v10, v10, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 67
    .line 68
    sget-object v12, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    .line 69
    .line 70
    invoke-direct {v11, v10, v12}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 71
    .line 72
    .line 73
    goto :goto_1

    .line 74
    :catch_0
    move-exception v0

    .line 75
    goto :goto_3

    .line 76
    :cond_1
    const-string v11, ""

    .line 77
    .line 78
    :goto_1
    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 79
    .line 80
    .line 81
    iget-wide v12, v8, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->timestamp:J

    .line 82
    .line 83
    invoke-virtual {v9, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 84
    .line 85
    .line 86
    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 87
    .line 88
    .line 89
    invoke-virtual {v11}, Ljava/lang/String;->isEmpty()Z

    .line 90
    .line 91
    .line 92
    move-result v10
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 93
    const-string v12, "\n"

    .line 94
    .line 95
    if-nez v10, :cond_2

    .line 96
    .line 97
    :try_start_1
    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 98
    .line 99
    .line 100
    invoke-virtual {v11, v12}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    .line 101
    .line 102
    .line 103
    move-result v10

    .line 104
    if-nez v10, :cond_2

    .line 105
    .line 106
    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 107
    .line 108
    .line 109
    :cond_2
    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 110
    .line 111
    .line 112
    iget-object v10, v8, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->reply:Lcom/emanuelef/remote_capture/HttpLog$HttpReply;

    .line 113
    .line 114
    if-eqz v10, :cond_4

    .line 115
    .line 116
    iget-object v8, v8, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 117
    .line 118
    iget v10, v10, Lcom/emanuelef/remote_capture/HttpLog$HttpReply;->firstChunkPos:I

    .line 119
    .line 120
    invoke-virtual {v8, v10}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getHttpResponseChunk(I)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 121
    .line 122
    .line 123
    move-result-object v8

    .line 124
    if-eqz v8, :cond_4

    .line 125
    .line 126
    new-instance v10, Ljava/lang/String;

    .line 127
    .line 128
    iget-object v11, v8, Lcom/emanuelef/remote_capture/model/PayloadChunk;->payload:[B

    .line 129
    .line 130
    sget-object v13, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    .line 131
    .line 132
    invoke-direct {v10, v11, v13}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 133
    .line 134
    .line 135
    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 136
    .line 137
    .line 138
    iget-wide v13, v8, Lcom/emanuelef/remote_capture/model/PayloadChunk;->timestamp:J

    .line 139
    .line 140
    invoke-virtual {v9, v13, v14}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 141
    .line 142
    .line 143
    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 144
    .line 145
    .line 146
    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 147
    .line 148
    .line 149
    invoke-virtual {v10, v12}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    .line 150
    .line 151
    .line 152
    move-result v8

    .line 153
    if-nez v8, :cond_3

    .line 154
    .line 155
    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 156
    .line 157
    .line 158
    :cond_3
    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 159
    .line 160
    .line 161
    :cond_4
    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 162
    .line 163
    .line 164
    move-result-object v8

    .line 165
    sget-object v9, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    .line 166
    .line 167
    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    .line 168
    .line 169
    .line 170
    move-result-object v8

    .line 171
    invoke-virtual {v4, v8}, Ljava/io/OutputStream;->write([B)V

    .line 172
    .line 173
    .line 174
    goto/16 :goto_0

    .line 175
    .line 176
    :cond_5
    :goto_2
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 177
    .line 178
    .line 179
    const/4 v0, 0x1

    .line 180
    goto :goto_4

    .line 181
    :goto_3
    aget-boolean v2, p3, v3

    .line 182
    .line 183
    if-nez v2, :cond_6

    .line 184
    .line 185
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 186
    .line 187
    .line 188
    :cond_6
    const/4 v0, 0x0

    .line 189
    :goto_4
    aget-boolean v2, p3, v3

    .line 190
    .line 191
    if-eqz v2, :cond_7

    .line 192
    .line 193
    return-void

    .line 194
    :cond_7
    if-eqz v0, :cond_8

    .line 195
    .line 196
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 197
    .line 198
    .line 199
    move-result-object v2

    .line 200
    invoke-static {v2, v1}, Lcom/emanuelef/remote_capture/Utils;->getUriStat(Landroid/content/Context;Landroid/net/Uri;)Lcom/emanuelef/remote_capture/Utils$UriStat;

    .line 201
    .line 202
    .line 203
    move-result-object v1

    .line 204
    goto :goto_5

    .line 205
    :cond_8
    const/4 v1, 0x0

    .line 206
    :goto_5
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;

    .line 207
    .line 208
    const/4 v3, 0x1

    .line 209
    invoke-direct {v2, p0, v0, v1, v3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;I)V

    .line 210
    .line 211
    .line 212
    move-object/from16 v1, p4

    .line 213
    .line 214
    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 215
    .line 216
    .line 217
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method

.method private static synthetic lambda$exportHttpLogHar$17([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    const-string p2, "HttpLogFragment"

    .line 2
    .line 3
    const-string p3, "Abort HAR export"

    .line 4
    .line 5
    invoke-static {p2, p3}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 p2, 0x0

    .line 9
    const/4 p3, 0x1

    .line 10
    aput-boolean p3, p0, p2

    .line 11
    .line 12
    invoke-interface {p1}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    .line 13
    .line 14
    .line 15
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method

.method private static synthetic lambda$exportHttpLogHar$18([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V
    .locals 1

    .line 1
    const-string p2, "HttpLogFragment"

    .line 2
    .line 3
    const-string v0, "Abort HAR export (back button)"

    .line 4
    .line 5
    invoke-static {p2, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 p2, 0x0

    .line 9
    const/4 v0, 0x1

    .line 10
    aput-boolean v0, p0, p2

    .line 11
    .line 12
    invoke-interface {p1}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    .line 13
    .line 14
    .line 15
    return-void
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

.method private synthetic lambda$exportHttpLogHar$19(Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    const/4 p1, 0x0

    .line 2
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

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
.end method

.method private synthetic lambda$exportHttpLogHar$20(ZLcom/emanuelef/remote_capture/Utils$UriStat;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroidx/appcompat/app/AlertDialog;->dismiss()V

    .line 6
    .line 7
    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    if-eqz p1, :cond_2

    .line 10
    .line 11
    if-eqz p2, :cond_1

    .line 12
    .line 13
    const p1, 0x7f14010e

    .line 14
    .line 15
    .line 16
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    iget-object p2, p2, Lcom/emanuelef/remote_capture/Utils$UriStat;->name:Ljava/lang/String;

    .line 21
    .line 22
    const/4 v1, 0x1

    .line 23
    new-array v1, v1, [Ljava/lang/Object;

    .line 24
    .line 25
    aput-object p2, v1, v0

    .line 26
    .line 27
    invoke-static {p1, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 32
    .line 33
    .line 34
    move-result-object p2

    .line 35
    invoke-static {p2, p1, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 36
    .line 37
    .line 38
    move-result-object p1

    .line 39
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 40
    .line 41
    .line 42
    goto :goto_0

    .line 43
    :cond_1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 44
    .line 45
    .line 46
    move-result-object p1

    .line 47
    const p2, 0x7f14027f

    .line 48
    .line 49
    .line 50
    new-array v0, v0, [Ljava/lang/Object;

    .line 51
    .line 52
    invoke-static {p1, p2, v0}, Lcom/emanuelef/remote_capture/Utils;->showToast(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 53
    .line 54
    .line 55
    goto :goto_0

    .line 56
    :cond_2
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 57
    .line 58
    .line 59
    move-result-object p1

    .line 60
    const p2, 0x7f14006e

    .line 61
    .line 62
    .line 63
    new-array v0, v0, [Ljava/lang/Object;

    .line 64
    .line 65
    invoke-static {p1, p2, v0}, Lcom/emanuelef/remote_capture/Utils;->showToast(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 66
    .line 67
    .line 68
    :goto_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 69
    .line 70
    if-eqz p1, :cond_3

    .line 71
    .line 72
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 73
    .line 74
    .line 75
    :cond_3
    return-void
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

.method private synthetic lambda$exportHttpLogHar$21(Landroid/net/Uri;Ljava/util/ArrayList;[ZLandroid/os/Handler;)V
    .locals 4

    .line 1
    const/4 v0, 0x0

    .line 2
    :try_start_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 3
    .line 4
    .line 5
    move-result-object v1

    .line 6
    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    .line 7
    .line 8
    .line 9
    move-result-object v1

    .line 10
    const-string v2, "rwt"

    .line 11
    .line 12
    invoke-virtual {v1, p1, v2}, Landroid/content/ContentResolver;->openOutputStream(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/OutputStream;

    .line 13
    .line 14
    .line 15
    move-result-object v1

    .line 16
    if-eqz v1, :cond_0

    .line 17
    .line 18
    new-instance v2, Lcom/emanuelef/remote_capture/HarWriter;

    .line 19
    .line 20
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 21
    .line 22
    .line 23
    move-result-object v3

    .line 24
    invoke-direct {v2, v3, p2}, Lcom/emanuelef/remote_capture/HarWriter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    .line 25
    .line 26
    .line 27
    invoke-virtual {v2, v1}, Lcom/emanuelef/remote_capture/HarWriter;->write(Ljava/io/OutputStream;)V

    .line 28
    .line 29
    .line 30
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 31
    .line 32
    .line 33
    const/4 p2, 0x1

    .line 34
    goto :goto_0

    .line 35
    :catch_0
    move-exception p2

    .line 36
    aget-boolean v1, p3, v0

    .line 37
    .line 38
    if-nez v1, :cond_0

    .line 39
    .line 40
    invoke-virtual {p2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 41
    .line 42
    .line 43
    :cond_0
    const/4 p2, 0x0

    .line 44
    :goto_0
    aget-boolean p3, p3, v0

    .line 45
    .line 46
    if-eqz p3, :cond_1

    .line 47
    .line 48
    return-void

    .line 49
    :cond_1
    if-eqz p2, :cond_2

    .line 50
    .line 51
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 52
    .line 53
    .line 54
    move-result-object p3

    .line 55
    invoke-static {p3, p1}, Lcom/emanuelef/remote_capture/Utils;->getUriStat(Landroid/content/Context;Landroid/net/Uri;)Lcom/emanuelef/remote_capture/Utils$UriStat;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    goto :goto_1

    .line 60
    :cond_2
    const/4 p1, 0x0

    .line 61
    :goto_1
    new-instance p3, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;

    .line 62
    .line 63
    const/4 v0, 0x0

    .line 64
    invoke-direct {p3, p0, p2, p1, v0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda1;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;I)V

    .line 65
    .line 66
    .line 67
    invoke-virtual {p4, p3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 68
    .line 69
    .line 70
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method

.method private synthetic lambda$onHttpRequestAdded$9(I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->onHttpRequestAdded(I)V

    .line 6
    .line 7
    .line 8
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->autoScroll:Z

    .line 9
    .line 10
    if-eqz p1, :cond_0

    .line 11
    .line 12
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->scrollToBottom()V

    .line 13
    .line 14
    .line 15
    :cond_0
    return-void
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

.method private synthetic lambda$onHttpRequestUpdated$10(I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->onHttpRequestUpdated(I)V

    .line 6
    .line 7
    .line 8
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->autoScroll:Z

    .line 9
    .line 10
    if-eqz p1, :cond_0

    .line 11
    .line 12
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->scrollToBottom()V

    .line 13
    .line 14
    .line 15
    :cond_0
    return-void
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

.method private synthetic lambda$onHttpRequestsClear$11()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->onHttpRequestsClear()V

    .line 6
    .line 7
    .line 8
    :cond_0
    return-void
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

.method private static synthetic lambda$onViewCreated$0(F)Ljava/lang/String;
    .locals 4

    .line 1
    float-to-long v0, p0

    .line 2
    const-wide/16 v2, 0x400

    .line 3
    .line 4
    mul-long v0, v0, v2

    .line 5
    .line 6
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    .line 7
    .line 8
    .line 9
    move-result-object p0

    .line 10
    return-object p0
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

.method private synthetic lambda$onViewCreated$1(Lcom/google/android/material/slider/Slider;FZ)V
    .locals 2

    .line 1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 6
    .line 7
    float-to-long p2, p2

    .line 8
    const-wide/16 v0, 0x400

    .line 9
    .line 10
    mul-long p2, p2, v0

    .line 11
    .line 12
    iput-wide p2, p1, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;->minPayloadSize:J

    .line 13
    .line 14
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshFilteredRequests()V

    .line 15
    .line 16
    .line 17
    :cond_0
    return-void
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

.method private synthetic lambda$onViewCreated$2(Lcom/google/android/material/chip/ChipGroup;Ljava/util/List;)V
    .locals 1

    .line 1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    if-eqz p1, :cond_1

    .line 4
    .line 5
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 10
    .line 11
    .line 12
    move-result p2

    .line 13
    if-eqz p2, :cond_0

    .line 14
    .line 15
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object p2

    .line 19
    check-cast p2, Ljava/lang/Integer;

    .line 20
    .line 21
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    .line 22
    .line 23
    .line 24
    move-result p2

    .line 25
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 26
    .line 27
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 28
    .line 29
    invoke-virtual {v0, p2}, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;->clear(I)V

    .line 30
    .line 31
    .line 32
    goto :goto_0

    .line 33
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshFilteredRequests()V

    .line 34
    .line 35
    .line 36
    :cond_1
    return-void
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

.method private synthetic lambda$onViewCreated$3(Landroid/view/View;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 8
    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->toggleSelection(I)V

    .line 12
    .line 13
    .line 14
    return-void

    .line 15
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 16
    .line 17
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getItem(I)Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    if-eqz p1, :cond_2

    .line 22
    .line 23
    new-instance v0, Landroid/content/Intent;

    .line 24
    .line 25
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    const-class v2, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    .line 30
    .line 31
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 32
    .line 33
    .line 34
    const-string v1, "req_pos"

    .line 35
    .line 36
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->getPosition()I

    .line 37
    .line 38
    .line 39
    move-result p1

    .line 40
    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 41
    .line 42
    .line 43
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 44
    .line 45
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->hasFilter()Z

    .line 46
    .line 47
    .line 48
    move-result p1

    .line 49
    if-eqz p1, :cond_1

    .line 50
    .line 51
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 52
    .line 53
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getFilteredPositions()Ljava/util/ArrayList;

    .line 54
    .line 55
    .line 56
    move-result-object p1

    .line 57
    if-eqz p1, :cond_1

    .line 58
    .line 59
    const-string v1, "filtered_positions"

    .line 60
    .line 61
    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putIntegerArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 62
    .line 63
    .line 64
    :cond_1
    invoke-virtual {p0, v0}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 65
    .line 66
    .line 67
    :cond_2
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

.method private synthetic lambda$onViewCreated$4(Landroid/view/View;)Z
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 8
    .line 9
    const/4 v1, 0x1

    .line 10
    if-eqz v0, :cond_0

    .line 11
    .line 12
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->toggleSelection(I)V

    .line 13
    .line 14
    .line 15
    return v1

    .line 16
    :cond_0
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->startSelectionMode(I)V

    .line 17
    .line 18
    .line 19
    return v1
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

.method private static lambda$onViewCreated$5(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 5

    .line 1
    const/16 v0, 0x87

    .line 2
    .line 3
    iget-object v1, p1, Landroidx/core/view/WindowInsetsCompat;->mImpl:Landroidx/core/view/WindowInsetsCompat$Impl;

    .line 4
    .line 5
    invoke-virtual {v1, v0}, Landroidx/core/view/WindowInsetsCompat$Impl;->getInsets(I)Landroidx/core/graphics/Insets;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    iget v1, v0, Landroidx/core/graphics/Insets;->left:I

    .line 10
    .line 11
    iget v2, v0, Landroidx/core/graphics/Insets;->top:I

    .line 12
    .line 13
    iget v3, v0, Landroidx/core/graphics/Insets;->right:I

    .line 14
    .line 15
    const/4 v4, 0x0

    .line 16
    invoke-virtual {p0, v1, v2, v3, v4}, Landroid/view/View;->setPadding(IIII)V

    .line 17
    .line 18
    .line 19
    iget p0, v0, Landroidx/core/graphics/Insets;->left:I

    .line 20
    .line 21
    iget-object p1, p1, Landroidx/core/view/WindowInsetsCompat;->mImpl:Landroidx/core/view/WindowInsetsCompat$Impl;

    .line 22
    .line 23
    invoke-virtual {p1, p0, v2, v3, v4}, Landroidx/core/view/WindowInsetsCompat$Impl;->inset(IIII)Landroidx/core/view/WindowInsetsCompat;

    .line 24
    .line 25
    .line 26
    move-result-object p0

    .line 27
    return-object p0
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

.method private synthetic lambda$onViewCreated$6(Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->scrollToBottom()V

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
.end method

.method private lambda$onViewCreated$7(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 2

    .line 1
    const/16 v0, 0x8f

    .line 2
    .line 3
    iget-object p2, p2, Landroidx/core/view/WindowInsetsCompat;->mImpl:Landroidx/core/view/WindowInsetsCompat$Impl;

    .line 4
    .line 5
    invoke-virtual {p2, v0}, Landroidx/core/view/WindowInsetsCompat$Impl;->getInsets(I)Landroidx/core/graphics/Insets;

    .line 6
    .line 7
    .line 8
    move-result-object p2

    .line 9
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 14
    .line 15
    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDownMargin:I

    .line 16
    .line 17
    if-nez v1, :cond_0

    .line 18
    .line 19
    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 20
    .line 21
    iput v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDownMargin:I

    .line 22
    .line 23
    :cond_0
    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDownMargin:I

    .line 24
    .line 25
    iget p2, p2, Landroidx/core/graphics/Insets;->bottom:I

    .line 26
    .line 27
    add-int/2addr v1, p2

    .line 28
    iput v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 29
    .line 30
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 31
    .line 32
    .line 33
    sget-object p1, Landroidx/core/view/WindowInsetsCompat;->CONSUMED:Landroidx/core/view/WindowInsetsCompat;

    .line 34
    .line 35
    return-object p1
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

.method private synthetic lambda$onViewCreated$8(Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;->STARTED:Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    .line 2
    .line 3
    if-ne p1, v0, :cond_0

    .line 4
    .line 5
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->unregisterHttpListener()V

    .line 6
    .line 7
    .line 8
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->registerHttpListener()V

    .line 9
    .line 10
    .line 11
    const/4 p1, 0x1

    .line 12
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->autoScroll:Z

    .line 13
    .line 14
    const/4 p1, 0x0

    .line 15
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->showFabDown(Z)V

    .line 16
    .line 17
    .line 18
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mEmptyText:Landroid/widget/TextView;

    .line 19
    .line 20
    const v0, 0x7f140212

    .line 21
    .line 22
    .line 23
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 24
    .line 25
    .line 26
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 27
    .line 28
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/AppsResolver;->clear()V

    .line 29
    .line 30
    .line 31
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshMenuIcons()V

    .line 32
    .line 33
    .line 34
    return-void
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

.method private recheckMaxPayloadSize()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSliderActive:Z

    .line 10
    .line 11
    if-nez v0, :cond_0

    .line 12
    .line 13
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->getMaxPayloadSize()J

    .line 14
    .line 15
    .line 16
    move-result-wide v0

    .line 17
    const-wide/16 v2, 0x400

    .line 18
    .line 19
    div-long/2addr v0, v2

    .line 20
    long-to-float v0, v0

    .line 21
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 22
    .line 23
    invoke-virtual {v1}, Lcom/google/android/material/slider/Slider;->getValueTo()F

    .line 24
    .line 25
    .line 26
    move-result v1

    .line 27
    cmpl-float v1, v0, v1

    .line 28
    .line 29
    if-lez v1, :cond_0

    .line 30
    .line 31
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 32
    .line 33
    invoke-virtual {v1, v0}, Lcom/google/android/material/slider/Slider;->setValueTo(F)V

    .line 34
    .line 35
    .line 36
    :cond_0
    return-void
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

.method private recheckScroll()V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->getLayoutManager()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView$MyLinearLayoutManager;

    .line 8
    .line 9
    invoke-virtual {v0}, Landroidx/recyclerview/widget/LinearLayoutManager;->findFirstCompletelyVisibleItemPosition()I

    .line 10
    .line 11
    .line 12
    move-result v1

    .line 13
    invoke-virtual {v0}, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastCompletelyVisibleItemPosition()I

    .line 14
    .line 15
    .line 16
    move-result v0

    .line 17
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 18
    .line 19
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getItemCount()I

    .line 20
    .line 21
    .line 22
    move-result v2

    .line 23
    const/4 v3, 0x1

    .line 24
    sub-int/2addr v2, v3

    .line 25
    const/4 v4, 0x0

    .line 26
    if-lt v0, v2, :cond_0

    .line 27
    .line 28
    const/4 v0, 0x1

    .line 29
    goto :goto_0

    .line 30
    :cond_0
    const/4 v0, 0x0

    .line 31
    :goto_0
    if-nez v1, :cond_2

    .line 32
    .line 33
    if-nez v0, :cond_1

    .line 34
    .line 35
    goto :goto_1

    .line 36
    :cond_1
    invoke-direct {p0, v4}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->showFabDown(Z)V

    .line 37
    .line 38
    .line 39
    return-void

    .line 40
    :cond_2
    :goto_1
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 41
    .line 42
    invoke-virtual {v1}, Landroidx/recyclerview/widget/RecyclerView;->getScrollState()I

    .line 43
    .line 44
    .line 45
    move-result v1

    .line 46
    if-ne v1, v3, :cond_3

    .line 47
    .line 48
    const/4 v1, 0x1

    .line 49
    goto :goto_2

    .line 50
    :cond_3
    const/4 v1, 0x0

    .line 51
    :goto_2
    if-eqz v0, :cond_5

    .line 52
    .line 53
    if-eqz v1, :cond_4

    .line 54
    .line 55
    iput-boolean v3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->autoScroll:Z

    .line 56
    .line 57
    :cond_4
    invoke-direct {p0, v4}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->showFabDown(Z)V

    .line 58
    .line 59
    .line 60
    return-void

    .line 61
    :cond_5
    if-eqz v1, :cond_6

    .line 62
    .line 63
    iput-boolean v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->autoScroll:Z

    .line 64
    .line 65
    :cond_6
    invoke-direct {p0, v3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->showFabDown(Z)V

    .line 66
    .line 67
    .line 68
    return-void
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

.method private refreshActiveFilter()V
    .locals 7

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    goto :goto_0

    .line 6
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActiveFilter:Lcom/google/android/material/chip/ChipGroup;

    .line 7
    .line 8
    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 12
    .line 13
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 14
    .line 15
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getLayoutInflater()Landroid/view/LayoutInflater;

    .line 16
    .line 17
    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActiveFilter:Lcom/google/android/material/chip/ChipGroup;

    .line 20
    .line 21
    invoke-virtual {v0, v1, v2}, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;->toChips(Landroid/view/LayoutInflater;Lcom/google/android/material/chip/ChipGroup;)V

    .line 22
    .line 23
    .line 24
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 25
    .line 26
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 27
    .line 28
    iget-wide v0, v0, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;->minPayloadSize:J

    .line 29
    .line 30
    const-wide/16 v2, 0x400

    .line 31
    .line 32
    div-long/2addr v0, v2

    .line 33
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getHttpLog()Lcom/emanuelef/remote_capture/HttpLog;

    .line 34
    .line 35
    .line 36
    move-result-object v4

    .line 37
    if-eqz v4, :cond_1

    .line 38
    .line 39
    const-wide/16 v4, 0x0

    .line 40
    .line 41
    cmp-long v6, v0, v4

    .line 42
    .line 43
    if-lez v6, :cond_1

    .line 44
    .line 45
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->getMaxPayloadSize()J

    .line 46
    .line 47
    .line 48
    move-result-wide v4

    .line 49
    div-long/2addr v4, v2

    .line 50
    invoke-static {v4, v5, v0, v1}, Ljava/lang/Math;->max(JJ)J

    .line 51
    .line 52
    .line 53
    move-result-wide v2

    .line 54
    const-wide/16 v4, 0x2

    .line 55
    .line 56
    cmp-long v6, v2, v4

    .line 57
    .line 58
    if-ltz v6, :cond_1

    .line 59
    .line 60
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 61
    .line 62
    long-to-float v2, v2

    .line 63
    invoke-virtual {v4, v2}, Lcom/google/android/material/slider/Slider;->setValueTo(F)V

    .line 64
    .line 65
    .line 66
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 67
    .line 68
    long-to-float v0, v0

    .line 69
    invoke-virtual {v2, v0}, Lcom/google/android/material/slider/Slider;->setValue(F)V

    .line 70
    .line 71
    .line 72
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 73
    .line 74
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 75
    .line 76
    .line 77
    move-result v0

    .line 78
    if-eqz v0, :cond_1

    .line 79
    .line 80
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 81
    .line 82
    const/4 v1, 0x0

    .line 83
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 84
    .line 85
    .line 86
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 87
    .line 88
    const/4 v1, 0x3

    .line 89
    invoke-virtual {v0, v1}, Lcom/google/android/material/slider/Slider;->setLabelBehavior(I)V

    .line 90
    .line 91
    .line 92
    :cond_1
    :goto_0
    return-void
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

.method private refreshEmptyText()V
    .locals 2

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getHttpLog()Lcom/emanuelef/remote_capture/HttpLog;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_1

    .line 6
    .line 7
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isServiceActive()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    goto :goto_0

    .line 14
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mEmptyText:Landroid/widget/TextView;

    .line 15
    .line 16
    const v1, 0x7f140072

    .line 17
    .line 18
    .line 19
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 20
    .line 21
    .line 22
    return-void

    .line 23
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mEmptyText:Landroid/widget/TextView;

    .line 24
    .line 25
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 26
    .line 27
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->hasFilter()Z

    .line 28
    .line 29
    .line 30
    move-result v1

    .line 31
    if-eqz v1, :cond_2

    .line 32
    .line 33
    const v1, 0x7f140210

    .line 34
    .line 35
    .line 36
    goto :goto_1

    .line 37
    :cond_2
    const v1, 0x7f140212

    .line 38
    .line 39
    .line 40
    :goto_1
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 41
    .line 42
    .line 43
    return-void
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

.method private refreshFilteredRequests()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->refreshFilteredItems()V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshActiveFilter()V

    .line 7
    .line 8
    .line 9
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->recheckScroll()V

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
    .line 58
.end method

.method private refreshMenuIcons()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSave:Landroid/view/MenuItem;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    goto :goto_1

    .line 6
    :cond_0
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getHttpLog()Lcom/emanuelef/remote_capture/HttpLog;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    if-eqz v0, :cond_1

    .line 11
    .line 12
    const/4 v0, 0x1

    .line 13
    goto :goto_0

    .line 14
    :cond_1
    const/4 v0, 0x0

    .line 15
    :goto_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mMenuItemSearch:Landroid/view/MenuItem;

    .line 16
    .line 17
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 18
    .line 19
    .line 20
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSave:Landroid/view/MenuItem;

    .line 21
    .line 22
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 23
    .line 24
    .line 25
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSaveAsHar:Landroid/view/MenuItem;

    .line 26
    .line 27
    if-eqz v1, :cond_2

    .line 28
    .line 29
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 30
    .line 31
    .line 32
    :cond_2
    :goto_1
    return-void
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

.method private registerHttpListener()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->listenerSet:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getHttpLog()Lcom/emanuelef/remote_capture/HttpLog;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    invoke-virtual {v0, p0}, Lcom/emanuelef/remote_capture/HttpLog;->setListener(Lcom/emanuelef/remote_capture/HttpLog$Listener;)V

    .line 12
    .line 13
    .line 14
    const/4 v0, 0x1

    .line 15
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->listenerSet:Z

    .line 16
    .line 17
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 18
    .line 19
    if-eqz v0, :cond_0

    .line 20
    .line 21
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 22
    .line 23
    .line 24
    :cond_0
    return-void
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

.method private scrollToBottom()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getItemCount()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/4 v1, 0x1

    .line 8
    sub-int/2addr v0, v1

    .line 9
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 10
    .line 11
    invoke-virtual {v2, v0}, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V

    .line 12
    .line 13
    .line 14
    iput-boolean v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->autoScroll:Z

    .line 15
    .line 16
    const/4 v0, 0x0

    .line 17
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->showFabDown(Z)V

    .line 18
    .line 19
    .line 20
    return-void
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

.method private setQuery(Ljava/lang/String;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mMenuItemSearch:Landroid/view/MenuItem;

    .line 4
    .line 5
    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/Utils;->setSearchQuery(Landroidx/appcompat/widget/SearchView;Landroid/view/MenuItem;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    return-void
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

.method private showFabDown(Z)V
    .locals 1

    .line 1
    const/4 v0, 0x1

    .line 2
    if-eqz p1, :cond_0

    .line 3
    .line 4
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 5
    .line 6
    invoke-virtual {p1, v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->show(Z)V

    .line 7
    .line 8
    .line 9
    return-void

    .line 10
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 11
    .line 12
    invoke-virtual {p1, v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->hide(Z)V

    .line 13
    .line 14
    .line 15
    return-void
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

.method private startSelectionMode(I)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    check-cast v0, Landroidx/appcompat/app/AppCompatActivity;

    .line 11
    .line 12
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionModeCallback:Landroidx/appcompat/view/ActionMode$Callback;

    .line 13
    .line 14
    invoke-virtual {v0, v1}, Landroidx/appcompat/app/AppCompatActivity;->startSupportActionMode(Landroidx/appcompat/view/ActionMode$Callback;)Landroidx/appcompat/view/ActionMode;

    .line 15
    .line 16
    .line 17
    move-result-object v0

    .line 18
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 19
    .line 20
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 21
    .line 22
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->selectItem(I)V

    .line 23
    .line 24
    .line 25
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->updateActionModeTitle()V

    .line 26
    .line 27
    .line 28
    return-void
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

.method private toggleSelection(I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->toggleSelection(I)V

    .line 4
    .line 5
    .line 6
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 7
    .line 8
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getSelectedCount()I

    .line 9
    .line 10
    .line 11
    move-result p1

    .line 12
    if-nez p1, :cond_1

    .line 13
    .line 14
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 15
    .line 16
    if-eqz p1, :cond_0

    .line 17
    .line 18
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 19
    .line 20
    .line 21
    :cond_0
    return-void

    .line 22
    :cond_1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->updateActionModeTitle()V

    .line 23
    .line 24
    .line 25
    return-void
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

.method private txtFileResult(Landroidx/activity/result/ActivityResult;)V
    .locals 2

    .line 1
    iget v0, p1, Landroidx/activity/result/ActivityResult;->mResultCode:I

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    if-ne v0, v1, :cond_0

    .line 5
    .line 6
    iget-object p1, p1, Landroidx/activity/result/ActivityResult;->mData:Landroid/content/Intent;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mTxtFname:Landroid/net/Uri;

    .line 15
    .line 16
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->dumpHttpLog()V

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :cond_0
    const/4 p1, 0x0

    .line 21
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mTxtFname:Landroid/net/Uri;

    .line 22
    .line 23
    return-void
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

.method private unregisterHttpListener()V
    .locals 2

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->listenerSet:Z

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getHttpLog()Lcom/emanuelef/remote_capture/HttpLog;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    const/4 v1, 0x0

    .line 12
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/HttpLog;->setListener(Lcom/emanuelef/remote_capture/HttpLog$Listener;)V

    .line 13
    .line 14
    .line 15
    :cond_0
    const/4 v0, 0x0

    .line 16
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->listenerSet:Z

    .line 17
    .line 18
    :cond_1
    return-void
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

.method private updateActionModeTitle()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 6
    .line 7
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getSelectedCount()I

    .line 8
    .line 9
    .line 10
    move-result v1

    .line 11
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    const/4 v2, 0x1

    .line 16
    new-array v2, v2, [Ljava/lang/Object;

    .line 17
    .line 18
    const/4 v3, 0x0

    .line 19
    aput-object v1, v2, v3

    .line 20
    .line 21
    const v1, 0x7f1401fc

    .line 22
    .line 23
    .line 24
    invoke-virtual {p0, v1, v2}, Landroidx/fragment/app/Fragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v1

    .line 28
    invoke-virtual {v0, v1}, Landroidx/appcompat/view/ActionMode;->setTitle(Ljava/lang/CharSequence;)V

    .line 29
    .line 30
    .line 31
    :cond_0
    return-void
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


# virtual methods
.method public clearFilters()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    new-instance v1, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 6
    .line 7
    invoke-direct {v1}, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;-><init>()V

    .line 8
    .line 9
    .line 10
    iput-object v1, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 11
    .line 12
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 13
    .line 14
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->refreshFilteredItems()V

    .line 15
    .line 16
    .line 17
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshActiveFilter()V

    .line 18
    .line 19
    .line 20
    :cond_0
    return-void
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

.method public onBackPressed()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x1

    .line 9
    return v0

    .line 10
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 11
    .line 12
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->backHandleSearchview(Landroidx/appcompat/widget/SearchView;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    return v0
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

.method public onCreateMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .line 1
    const v0, 0x7f0f0011

    .line 2
    .line 3
    .line 4
    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 5
    .line 6
    .line 7
    const p2, 0x7f0a02be

    .line 8
    .line 9
    .line 10
    invoke-interface {p1, p2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 11
    .line 12
    .line 13
    move-result-object p2

    .line 14
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSave:Landroid/view/MenuItem;

    .line 15
    .line 16
    const p2, 0x7f0a02bf

    .line 17
    .line 18
    .line 19
    invoke-interface {p1, p2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 20
    .line 21
    .line 22
    move-result-object p2

    .line 23
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSaveAsHar:Landroid/view/MenuItem;

    .line 24
    .line 25
    const p2, 0x7f0a02ca

    .line 26
    .line 27
    .line 28
    invoke-interface {p1, p2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 29
    .line 30
    .line 31
    move-result-object p1

    .line 32
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mMenuItemSearch:Landroid/view/MenuItem;

    .line 33
    .line 34
    invoke-interface {p1}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    .line 35
    .line 36
    .line 37
    move-result-object p1

    .line 38
    check-cast p1, Landroidx/appcompat/widget/SearchView;

    .line 39
    .line 40
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 41
    .line 42
    invoke-virtual {p1, p0}, Landroidx/appcompat/widget/SearchView;->setOnQueryTextListener(Landroidx/appcompat/widget/SearchView$OnQueryTextListener;)V

    .line 43
    .line 44
    .line 45
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mQueryToApply:Ljava/lang/String;

    .line 46
    .line 47
    if-eqz p1, :cond_0

    .line 48
    .line 49
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 50
    .line 51
    .line 52
    move-result p1

    .line 53
    if-nez p1, :cond_0

    .line 54
    .line 55
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mQueryToApply:Ljava/lang/String;

    .line 56
    .line 57
    const/4 p2, 0x0

    .line 58
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mQueryToApply:Ljava/lang/String;

    .line 59
    .line 60
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->setQuery(Ljava/lang/String;)V

    .line 61
    .line 62
    .line 63
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshMenuIcons()V

    .line 64
    .line 65
    .line 66
    return-void
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

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    .line 2
    .line 3
    .line 4
    move-result-object p3

    .line 5
    instance-of p3, p3, Lcom/emanuelef/remote_capture/fragments/DataViewContainerFragment;

    .line 6
    .line 7
    if-nez p3, :cond_0

    .line 8
    .line 9
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 10
    .line 11
    .line 12
    move-result-object p3

    .line 13
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->RESUMED:Landroidx/lifecycle/Lifecycle$State;

    .line 18
    .line 19
    invoke-virtual {p3, p0, v0, v1}, Landroidx/activity/ComponentActivity;->addMenuProvider(Landroidx/core/view/MenuProvider;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;)V

    .line 20
    .line 21
    .line 22
    :cond_0
    const p3, 0x7f0d002f

    .line 23
    .line 24
    .line 25
    const/4 v0, 0x0

    .line 26
    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 27
    .line 28
    .line 29
    move-result-object p1

    .line 30
    return-object p1
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

.method public onDestroyView()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroidx/appcompat/app/AlertDialog;->dismiss()V

    .line 6
    .line 7
    .line 8
    :cond_0
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onDestroyView()V

    .line 9
    .line 10
    .line 11
    return-void
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

.method public onHiddenChanged(Z)V
    .locals 1

    .line 1
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onHiddenChanged(Z)V

    .line 2
    .line 3
    .line 4
    if-eqz p1, :cond_1

    .line 5
    .line 6
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 11
    .line 12
    .line 13
    :cond_0
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->clearFilters()V

    .line 14
    .line 15
    .line 16
    return-void

    .line 17
    :cond_1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 18
    .line 19
    if-eqz p1, :cond_2

    .line 20
    .line 21
    const/4 v0, 0x0

    .line 22
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V

    .line 23
    .line 24
    .line 25
    :cond_2
    return-void
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

.method public onHttpRequestAdded(I)V
    .locals 2

    .line 1
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    invoke-direct {v0, p0, p1, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;II)V

    .line 5
    .line 6
    .line 7
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHandler:Landroid/os/Handler;

    .line 8
    .line 9
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Utils;->runOnUi(Ljava/lang/Runnable;Landroid/os/Handler;)V

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

.method public onHttpRequestUpdated(I)V
    .locals 2

    .line 1
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, p0, p1, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda0;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;II)V

    .line 5
    .line 6
    .line 7
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHandler:Landroid/os/Handler;

    .line 8
    .line 9
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Utils;->runOnUi(Ljava/lang/Runnable;Landroid/os/Handler;)V

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

.method public onHttpRequestsClear()V
    .locals 2

    .line 1
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, p0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 5
    .line 6
    .line 7
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHandler:Landroid/os/Handler;

    .line 8
    .line 9
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils;->runOnUi(Ljava/lang/Runnable;Landroid/os/Handler;)V

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
    .line 58
.end method

.method public bridge synthetic onMenuClosed(Landroid/view/Menu;)V
    .locals 0

    .line 1
    return-void
.end method

.method public onMenuItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .line 1
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    const v0, 0x7f0a02be

    .line 6
    .line 7
    .line 8
    const/4 v1, 0x1

    .line 9
    if-ne p1, v0, :cond_0

    .line 10
    .line 11
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->openFileSelector()V

    .line 12
    .line 13
    .line 14
    return v1

    .line 15
    :cond_0
    const v0, 0x7f0a02bf

    .line 16
    .line 17
    .line 18
    if-ne p1, v0, :cond_1

    .line 19
    .line 20
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->openHarFileSelector()V

    .line 21
    .line 22
    .line 23
    return v1

    .line 24
    :cond_1
    const v0, 0x7f0a014a

    .line 25
    .line 26
    .line 27
    if-ne p1, v0, :cond_2

    .line 28
    .line 29
    new-instance p1, Landroid/content/Intent;

    .line 30
    .line 31
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    const-class v2, Lcom/emanuelef/remote_capture/activities/HttpLogFilterActivity;

    .line 36
    .line 37
    invoke-direct {p1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 38
    .line 39
    .line 40
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 41
    .line 42
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 43
    .line 44
    const-string v2, "http_log_filter"

    .line 45
    .line 46
    invoke-virtual {p1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 47
    .line 48
    .line 49
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->filterLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 50
    .line 51
    invoke-virtual {v0, p1}, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V

    .line 52
    .line 53
    .line 54
    return v1

    .line 55
    :cond_2
    const/4 p1, 0x0

    .line 56
    return p1
    .line 57
.end method

.method public onPause()V
    .locals 2

    .line 1
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onPause()V

    .line 2
    .line 3
    .line 4
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->unregisterHttpListener()V

    .line 5
    .line 6
    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 8
    .line 9
    const/4 v1, 0x0

    .line 10
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;->setEmptyView(Landroid/view/View;)V

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 14
    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    invoke-virtual {v0}, Landroidx/appcompat/widget/SearchView;->getQuery()Ljava/lang/CharSequence;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mQueryToApply:Ljava/lang/String;

    .line 26
    .line 27
    :cond_0
    return-void
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

.method public bridge synthetic onPrepareMenu(Landroid/view/Menu;)V
    .locals 0

    .line 1
    return-void
.end method

.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->setSearch(Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->recheckScroll()V

    .line 7
    .line 8
    .line 9
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshEmptyText()V

    .line 10
    .line 11
    .line 12
    const/4 p1, 0x1

    .line 13
    return p1
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

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 0

    const/4 p1, 0x1

    return p1
.end method

.method public onResume()V
    .locals 6

    .line 1
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 2
    .line 3
    .line 4
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshEmptyText()V

    .line 5
    .line 6
    .line 7
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->registerHttpListener()V

    .line 8
    .line 9
    .line 10
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 11
    .line 12
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mEmptyText:Landroid/widget/TextView;

    .line 13
    .line 14
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;->setEmptyView(Landroid/view/View;)V

    .line 15
    .line 16
    .line 17
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 18
    .line 19
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;

    .line 20
    .line 21
    const/4 v2, 0x1

    .line 22
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda2;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 23
    .line 24
    .line 25
    invoke-virtual {v0, v1}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    .line 26
    .line 27
    .line 28
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshMenuIcons()V

    .line 29
    .line 30
    .line 31
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 32
    .line 33
    if-eqz v0, :cond_3

    .line 34
    .line 35
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 36
    .line 37
    iget-wide v0, v0, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;->minPayloadSize:J

    .line 38
    .line 39
    const-wide/16 v2, 0x400

    .line 40
    .line 41
    const/4 v4, 0x0

    .line 42
    cmp-long v5, v0, v2

    .line 43
    .line 44
    if-ltz v5, :cond_0

    .line 45
    .line 46
    const/4 v0, 0x1

    .line 47
    goto :goto_0

    .line 48
    :cond_0
    const/4 v0, 0x0

    .line 49
    :goto_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 50
    .line 51
    if-eqz v0, :cond_1

    .line 52
    .line 53
    goto :goto_1

    .line 54
    :cond_1
    const/16 v4, 0x8

    .line 55
    .line 56
    :goto_1
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 57
    .line 58
    .line 59
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 60
    .line 61
    if-eqz v0, :cond_2

    .line 62
    .line 63
    const/4 v0, 0x3

    .line 64
    goto :goto_2

    .line 65
    :cond_2
    const/4 v0, 0x2

    .line 66
    :goto_2
    invoke-virtual {v1, v0}, Lcom/google/android/material/slider/Slider;->setLabelBehavior(I)V

    .line 67
    .line 68
    .line 69
    :cond_3
    return-void
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

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .line 1
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 5
    .line 6
    if-eqz v0, :cond_0

    .line 7
    .line 8
    invoke-virtual {v0}, Landroidx/appcompat/widget/SearchView;->getQuery()Ljava/lang/CharSequence;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    const-string v1, "search"

    .line 17
    .line 18
    invoke-virtual {p1, v1, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    .line 20
    .line 21
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 22
    .line 23
    if-eqz v0, :cond_1

    .line 24
    .line 25
    const-string v1, "http_log_filter_desc"

    .line 26
    .line 27
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 28
    .line 29
    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 30
    .line 31
    .line 32
    :cond_1
    return-void
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

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .line 1
    new-instance v0, Landroid/os/Handler;

    .line 2
    .line 3
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 8
    .line 9
    .line 10
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHandler:Landroid/os/Handler;

    .line 11
    .line 12
    const v0, 0x7f0a015e

    .line 13
    .line 14
    .line 15
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    check-cast v0, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 20
    .line 21
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 22
    .line 23
    const v0, 0x7f0a00d0

    .line 24
    .line 25
    .line 26
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    check-cast v0, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 31
    .line 32
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 33
    .line 34
    new-instance v0, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView$MyLinearLayoutManager;

    .line 35
    .line 36
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 37
    .line 38
    .line 39
    move-result-object v1

    .line 40
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView$MyLinearLayoutManager;-><init>(Landroid/content/Context;)V

    .line 41
    .line 42
    .line 43
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 44
    .line 45
    invoke-virtual {v1, v0}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 46
    .line 47
    .line 48
    new-instance v1, Lcom/emanuelef/remote_capture/AppsResolver;

    .line 49
    .line 50
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 51
    .line 52
    .line 53
    move-result-object v2

    .line 54
    invoke-direct {v1, v2}, Lcom/emanuelef/remote_capture/AppsResolver;-><init>(Landroid/content/Context;)V

    .line 55
    .line 56
    .line 57
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 58
    .line 59
    const v1, 0x7f0a0240

    .line 60
    .line 61
    .line 62
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 63
    .line 64
    .line 65
    move-result-object v1

    .line 66
    check-cast v1, Landroid/widget/TextView;

    .line 67
    .line 68
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mEmptyText:Landroid/widget/TextView;

    .line 69
    .line 70
    const v1, 0x7f0a02f1

    .line 71
    .line 72
    .line 73
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 74
    .line 75
    .line 76
    move-result-object v1

    .line 77
    check-cast v1, Lcom/google/android/material/slider/Slider;

    .line 78
    .line 79
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 80
    .line 81
    new-instance v2, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;

    .line 82
    .line 83
    const/16 v3, 0x8

    .line 84
    .line 85
    invoke-direct {v2, v3}, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;-><init>(I)V

    .line 86
    .line 87
    .line 88
    invoke-virtual {v1, v2}, Lcom/google/android/material/slider/Slider;->setLabelFormatter(Lcom/google/android/material/slider/LabelFormatter;)V

    .line 89
    .line 90
    .line 91
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 92
    .line 93
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;

    .line 94
    .line 95
    const/4 v3, 0x0

    .line 96
    invoke-direct {v2, p0, v3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;-><init>(Landroidx/fragment/app/Fragment;I)V

    .line 97
    .line 98
    .line 99
    iget-object v1, v1, Lcom/google/android/material/slider/BaseSlider;->changeListeners:Ljava/util/ArrayList;

    .line 100
    .line 101
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 102
    .line 103
    .line 104
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 105
    .line 106
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$1;

    .line 107
    .line 108
    invoke-direct {v2, p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$1;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V

    .line 109
    .line 110
    .line 111
    iget-object v1, v1, Lcom/google/android/material/slider/BaseSlider;->touchListeners:Ljava/util/ArrayList;

    .line 112
    .line 113
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 114
    .line 115
    .line 116
    const v1, 0x7f0a0054

    .line 117
    .line 118
    .line 119
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 120
    .line 121
    .line 122
    move-result-object v1

    .line 123
    check-cast v1, Lcom/google/android/material/chip/ChipGroup;

    .line 124
    .line 125
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mActiveFilter:Lcom/google/android/material/chip/ChipGroup;

    .line 126
    .line 127
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;

    .line 128
    .line 129
    const/4 v4, 0x3

    .line 130
    invoke-direct {v2, p0, v4}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 131
    .line 132
    .line 133
    invoke-virtual {v1, v2}, Lcom/google/android/material/chip/ChipGroup;->setOnCheckedStateChangeListener(Lcom/google/android/material/chip/ChipGroup$OnCheckedStateChangeListener;)V

    .line 134
    .line 135
    .line 136
    new-instance v1, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 137
    .line 138
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 139
    .line 140
    .line 141
    move-result-object v2

    .line 142
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 143
    .line 144
    invoke-direct {v1, v2, v4}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;-><init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/AppsResolver;)V

    .line 145
    .line 146
    .line 147
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 148
    .line 149
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 150
    .line 151
    invoke-virtual {v2, v1}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 152
    .line 153
    .line 154
    new-instance v1, Landroidx/recyclerview/widget/DividerItemDecoration;

    .line 155
    .line 156
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 157
    .line 158
    invoke-virtual {v2}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 159
    .line 160
    .line 161
    move-result-object v2

    .line 162
    invoke-virtual {v0}, Landroidx/recyclerview/widget/LinearLayoutManager;->getOrientation()I

    .line 163
    .line 164
    .line 165
    move-result v0

    .line 166
    invoke-direct {v1, v2, v0}, Landroidx/recyclerview/widget/DividerItemDecoration;-><init>(Landroid/content/Context;I)V

    .line 167
    .line 168
    .line 169
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 170
    .line 171
    invoke-virtual {v0, v1}, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V

    .line 172
    .line 173
    .line 174
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 175
    .line 176
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda16;

    .line 177
    .line 178
    invoke-direct {v1, p0, v3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda16;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 179
    .line 180
    .line 181
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->setClickListener(Landroid/view/View$OnClickListener;)V

    .line 182
    .line 183
    .line 184
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 185
    .line 186
    new-instance v1, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;

    .line 187
    .line 188
    const/4 v2, 0x2

    .line 189
    invoke-direct {v1, v2, p0}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 190
    .line 191
    .line 192
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->setLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 193
    .line 194
    .line 195
    const/4 v0, 0x1

    .line 196
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->autoScroll:Z

    .line 197
    .line 198
    iput-boolean v3, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->listenerSet:Z

    .line 199
    .line 200
    invoke-direct {p0, v3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->showFabDown(Z)V

    .line 201
    .line 202
    .line 203
    const v1, 0x7f0a01d2

    .line 204
    .line 205
    .line 206
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 207
    .line 208
    .line 209
    move-result-object p1

    .line 210
    new-instance v1, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;

    .line 211
    .line 212
    const/16 v2, 0x9

    .line 213
    .line 214
    invoke-direct {v1, v2}, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;-><init>(I)V

    .line 215
    .line 216
    .line 217
    sget-object v2, Landroidx/core/view/ViewCompat;->sViewPropertyAnimatorMap:Ljava/util/WeakHashMap;

    .line 218
    .line 219
    invoke-static {p1, v1}, Landroidx/core/view/ViewCompat$Api21Impl;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    .line 220
    .line 221
    .line 222
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 223
    .line 224
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda16;

    .line 225
    .line 226
    invoke-direct {v1, p0, v0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda16;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 227
    .line 228
    .line 229
    invoke-virtual {p1, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 230
    .line 231
    .line 232
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 233
    .line 234
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;

    .line 235
    .line 236
    const/4 v1, 0x4

    .line 237
    invoke-direct {v0, p0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda9;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;I)V

    .line 238
    .line 239
    .line 240
    invoke-static {p1, v0}, Landroidx/core/view/ViewCompat$Api21Impl;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    .line 241
    .line 242
    .line 243
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 244
    .line 245
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$2;

    .line 246
    .line 247
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$2;-><init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V

    .line 248
    .line 249
    .line 250
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V

    .line 251
    .line 252
    .line 253
    if-eqz p2, :cond_1

    .line 254
    .line 255
    const-string p1, "search"

    .line 256
    .line 257
    invoke-virtual {p2, p1}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    .line 258
    .line 259
    .line 260
    move-result-object p1

    .line 261
    if-eqz p1, :cond_0

    .line 262
    .line 263
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 264
    .line 265
    .line 266
    move-result v0

    .line 267
    if-nez v0, :cond_0

    .line 268
    .line 269
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mQueryToApply:Ljava/lang/String;

    .line 270
    .line 271
    :cond_0
    const-string p1, "http_log_filter_desc"

    .line 272
    .line 273
    invoke-virtual {p2, p1}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    .line 274
    .line 275
    .line 276
    move-result v0

    .line 277
    if-eqz v0, :cond_1

    .line 278
    .line 279
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 280
    .line 281
    const-class v1, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 282
    .line 283
    invoke-static {p2, p1, v1}, Lcom/emanuelef/remote_capture/Utils;->getSerializable(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Class;)Ljava/io/Serializable;

    .line 284
    .line 285
    .line 286
    move-result-object p1

    .line 287
    check-cast p1, Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 288
    .line 289
    iput-object p1, v0, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/HttpLogFilterDescriptor;

    .line 290
    .line 291
    :cond_1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->refreshActiveFilter()V

    .line 292
    .line 293
    .line 294
    new-instance p1, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;

    .line 295
    .line 296
    const/4 p2, 0x5

    .line 297
    invoke-direct {p1, p2, p0}, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;-><init>(ILjava/lang/Object;)V

    .line 298
    .line 299
    .line 300
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->observeStatus(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 301
    .line 302
    .line 303
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
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

.method public openFileSelector()V
    .locals 3

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "txt"

    .line 6
    .line 7
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils;->getExportFileName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    new-instance v1, Landroid/content/Intent;

    .line 12
    .line 13
    const-string v2, "android.intent.action.CREATE_DOCUMENT"

    .line 14
    .line 15
    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 16
    .line 17
    .line 18
    const-string v2, "android.intent.category.OPENABLE"

    .line 19
    .line 20
    invoke-virtual {v1, v2}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 21
    .line 22
    .line 23
    const-string v2, "*/*"

    .line 24
    .line 25
    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 26
    .line 27
    .line 28
    const-string v2, "android.intent.extra.TITLE"

    .line 29
    .line 30
    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 31
    .line 32
    .line 33
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 34
    .line 35
    .line 36
    move-result-object v2

    .line 37
    invoke-static {v2, v1}, Lcom/emanuelef/remote_capture/Utils;->supportsFileDialog(Landroid/content/Context;Landroid/content/Intent;)Z

    .line 38
    .line 39
    .line 40
    move-result v2

    .line 41
    if-eqz v2, :cond_0

    .line 42
    .line 43
    :try_start_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->txtFileLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 44
    .line 45
    invoke-virtual {v2, v1}, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    .line 47
    .line 48
    return-void

    .line 49
    :catch_0
    nop

    .line 50
    :cond_0
    const-string v1, "HttpLogFragment"

    .line 51
    .line 52
    const-string v2, "No app found to handle file selection"

    .line 53
    .line 54
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    .line 56
    .line 57
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 58
    .line 59
    .line 60
    move-result-object v1

    .line 61
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Utils;->getDownloadsUri(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    .line 62
    .line 63
    .line 64
    move-result-object v0

    .line 65
    if-eqz v0, :cond_1

    .line 66
    .line 67
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mTxtFname:Landroid/net/Uri;

    .line 68
    .line 69
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->dumpHttpLog()V

    .line 70
    .line 71
    .line 72
    goto :goto_0

    .line 73
    :cond_1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 74
    .line 75
    .line 76
    move-result-object v0

    .line 77
    const/4 v1, 0x0

    .line 78
    new-array v1, v1, [Ljava/lang/Object;

    .line 79
    .line 80
    const v2, 0x7f140208

    .line 81
    .line 82
    .line 83
    invoke-static {v0, v2, v1}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 84
    .line 85
    .line 86
    :goto_0
    return-void
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

.method public openHarFileSelector()V
    .locals 3

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "har"

    .line 6
    .line 7
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils;->getExportFileName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    new-instance v1, Landroid/content/Intent;

    .line 12
    .line 13
    const-string v2, "android.intent.action.CREATE_DOCUMENT"

    .line 14
    .line 15
    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 16
    .line 17
    .line 18
    const-string v2, "android.intent.category.OPENABLE"

    .line 19
    .line 20
    invoke-virtual {v1, v2}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 21
    .line 22
    .line 23
    const-string v2, "*/*"

    .line 24
    .line 25
    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 26
    .line 27
    .line 28
    const-string v2, "android.intent.extra.TITLE"

    .line 29
    .line 30
    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 31
    .line 32
    .line 33
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 34
    .line 35
    .line 36
    move-result-object v2

    .line 37
    invoke-static {v2, v1}, Lcom/emanuelef/remote_capture/Utils;->supportsFileDialog(Landroid/content/Context;Landroid/content/Intent;)Z

    .line 38
    .line 39
    .line 40
    move-result v2

    .line 41
    if-eqz v2, :cond_0

    .line 42
    .line 43
    :try_start_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->harFileLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 44
    .line 45
    invoke-virtual {v2, v1}, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    .line 47
    .line 48
    return-void

    .line 49
    :catch_0
    nop

    .line 50
    :cond_0
    const-string v1, "HttpLogFragment"

    .line 51
    .line 52
    const-string v2, "No app found to handle file selection"

    .line 53
    .line 54
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    .line 56
    .line 57
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 58
    .line 59
    .line 60
    move-result-object v1

    .line 61
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Utils;->getDownloadsUri(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    .line 62
    .line 63
    .line 64
    move-result-object v0

    .line 65
    if-eqz v0, :cond_1

    .line 66
    .line 67
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->mHarFname:Landroid/net/Uri;

    .line 68
    .line 69
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->exportHttpLogHar()V

    .line 70
    .line 71
    .line 72
    goto :goto_0

    .line 73
    :cond_1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 74
    .line 75
    .line 76
    move-result-object v0

    .line 77
    const/4 v1, 0x0

    .line 78
    new-array v1, v1, [Ljava/lang/Object;

    .line 79
    .line 80
    const v2, 0x7f140208

    .line 81
    .line 82
    .line 83
    invoke-static {v0, v2, v1}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 84
    .line 85
    .line 86
    :goto_0
    return-void
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
