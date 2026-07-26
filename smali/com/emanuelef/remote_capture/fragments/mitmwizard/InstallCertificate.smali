.class public Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;
.super Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/MitmListener;


# static fields
.field private static final TAG:Ljava/lang/String; = "InstallCertificate"


# instance fields
.field private final certExportLauncher:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher;"
        }
    .end annotation
.end field

.field private final certInstallLauncher:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher;"
        }
    .end annotation
.end field

.field private mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

.field private mCaCert:Ljava/security/cert/X509Certificate;

.field private mCaPem:Ljava/lang/String;

.field private mFallbackExport:Z


# direct methods
.method public static synthetic $r8$lambda$AN70Ln7VzbgMMY6uPfhU15nWnik(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->lambda$onMitmGetCaCertificateResult$5(Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$J0_v63RYfuwe-LV6gne93_v5OtI(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->lambda$onViewCreated$2(Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$KMNV5BsRjsLEE4yr-2iEy_pPgDc(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->lambda$onResume$3(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$LmGu7GD74NypJL03LUHjR3bng6g(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroidx/activity/result/ActivityResult;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certExportResult(Landroidx/activity/result/ActivityResult;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Trj0OpxY0CG4p7gFoEm-PxVt0Mo(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroidx/activity/result/ActivityResult;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certInstallResult(Landroidx/activity/result/ActivityResult;)V

    return-void
.end method

.method public static synthetic $r8$lambda$VQZ6hmMLzNtnSIOZDY76nNsLxTQ(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->lambda$onResume$4(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$no_wSkkisVv2Bkwu1bLCRt8ZmFs(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->lambda$onViewCreated$1(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$uNtUolFzwKACyZxcf426TjGuDCE(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->lambda$onViewCreated$0(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;

    .line 5
    .line 6
    const/4 v1, 0x3

    .line 7
    invoke-direct {v0, v1}, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;-><init>(I)V

    .line 8
    .line 9
    .line 10
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;

    .line 11
    .line 12
    const/4 v2, 0x0

    .line 13
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;-><init>(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;I)V

    .line 14
    .line 15
    .line 16
    invoke-virtual {p0, v0, v1}, Landroidx/fragment/app/Fragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certExportLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 21
    .line 22
    new-instance v0, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;

    .line 23
    .line 24
    const/4 v1, 0x3

    .line 25
    invoke-direct {v0, v1}, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;-><init>(I)V

    .line 26
    .line 27
    .line 28
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;

    .line 29
    .line 30
    const/4 v2, 0x1

    .line 31
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda0;-><init>(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;I)V

    .line 32
    .line 33
    .line 34
    invoke-virtual {p0, v0, v1}, Landroidx/fragment/app/Fragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    .line 35
    .line 36
    .line 37
    move-result-object v0

    .line 38
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certInstallLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 39
    .line 40
    return-void
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

.method private canInstallCertViaIntent()Z
    .locals 2

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 2
    .line 3
    const/16 v1, 0x1e

    .line 4
    .line 5
    if-ge v0, v1, :cond_0

    .line 6
    .line 7
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mFallbackExport:Z

    .line 8
    .line 9
    if-nez v0, :cond_0

    .line 10
    .line 11
    const/4 v0, 0x1

    .line 12
    return v0

    .line 13
    :cond_0
    const/4 v0, 0x0

    .line 14
    return v0
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

.method private certExportResult(Landroidx/activity/result/ActivityResult;)V
    .locals 5

    .line 1
    iget v0, p1, Landroidx/activity/result/ActivityResult;->mResultCode:I

    .line 2
    .line 3
    iget-object p1, p1, Landroidx/activity/result/ActivityResult;->mData:Landroid/content/Intent;

    .line 4
    .line 5
    const/4 v1, -0x1

    .line 6
    if-ne v0, v1, :cond_0

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    .line 15
    .line 16
    .line 17
    move-result-object p1

    .line 18
    const/4 v1, 0x0

    .line 19
    :try_start_0
    new-instance v2, Ljava/io/PrintWriter;

    .line 20
    .line 21
    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    .line 22
    .line 23
    .line 24
    move-result-object v3

    .line 25
    const-string v4, "rwt"

    .line 26
    .line 27
    invoke-virtual {v3, p1, v4}, Landroid/content/ContentResolver;->openOutputStream(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/OutputStream;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    invoke-direct {v2, p1}, Ljava/io/PrintWriter;-><init>(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 32
    .line 33
    .line 34
    :try_start_1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaPem:Ljava/lang/String;

    .line 35
    .line 36
    invoke-virtual {v2, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 37
    .line 38
    .line 39
    const/4 p1, 0x1

    .line 40
    :try_start_2
    invoke-virtual {v2}, Ljava/io/PrintWriter;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 41
    .line 42
    .line 43
    goto :goto_2

    .line 44
    :catch_0
    move-exception v2

    .line 45
    goto :goto_1

    .line 46
    :catchall_0
    move-exception p1

    .line 47
    :try_start_3
    invoke-virtual {v2}, Ljava/io/PrintWriter;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 48
    .line 49
    .line 50
    goto :goto_0

    .line 51
    :catchall_1
    move-exception v2

    .line 52
    :try_start_4
    invoke-virtual {p1, v2}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .line 53
    .line 54
    .line 55
    :goto_0
    throw p1
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    .line 56
    :catch_1
    move-exception v2

    .line 57
    const/4 p1, 0x0

    .line 58
    :goto_1
    invoke-virtual {v2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 59
    .line 60
    .line 61
    :goto_2
    if-eqz p1, :cond_0

    .line 62
    .line 63
    const p1, 0x7f140077

    .line 64
    .line 65
    .line 66
    new-array v1, v1, [Ljava/lang/Object;

    .line 67
    .line 68
    invoke-static {v0, p1, v1}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 69
    .line 70
    .line 71
    :cond_0
    return-void
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

.method private certFail()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepLabel:Landroid/widget/TextView;

    .line 2
    .line 3
    const v1, 0x7f140064

    .line 4
    .line 5
    .line 6
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 7
    .line 8
    .line 9
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepLabel:Landroid/widget/TextView;

    .line 10
    .line 11
    const-string v2, "https://dontkillmyapp.com/xiaomi#app-battery-saver"

    .line 12
    .line 13
    filled-new-array {v2}, [Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    invoke-static {v0, v1, v2}, Lcom/emanuelef/remote_capture/Utils;->setTextUrls(Landroid/widget/TextView;I[Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepIcon:Landroid/widget/ImageView;

    .line 21
    .line 22
    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mDangerColor:I

    .line 23
    .line 24
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setColorFilter(I)V

    .line 25
    .line 26
    .line 27
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    const/4 v1, 0x0

    .line 32
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/MitmAddon;->setDecryptionSetupDone(Landroid/content/Context;Z)V

    .line 33
    .line 34
    .line 35
    return-void
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

.method private certInstallResult(Landroidx/activity/result/ActivityResult;)V
    .locals 1

    .line 1
    iget p1, p1, Landroidx/activity/result/ActivityResult;->mResultCode:I

    .line 2
    .line 3
    const/4 v0, -0x1

    .line 4
    if-ne p1, v0, :cond_0

    .line 5
    .line 6
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaCert:Ljava/security/cert/X509Certificate;

    .line 7
    .line 8
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->isCAInstalled(Ljava/security/cert/X509Certificate;)Z

    .line 9
    .line 10
    .line 11
    move-result p1

    .line 12
    if-eqz p1, :cond_0

    .line 13
    .line 14
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certOk()V

    .line 15
    .line 16
    .line 17
    return-void

    .line 18
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->fallbackToCertExport()V

    .line 19
    .line 20
    .line 21
    return-void
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

.method private certOk()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepLabel:Landroid/widget/TextView;

    .line 2
    .line 3
    const v1, 0x7f140078

    .line 4
    .line 5
    .line 6
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 7
    .line 8
    .line 9
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    const/4 v1, 0x0

    .line 14
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/MitmAddon;->setCAInstallationSkipped(Landroid/content/Context;Z)V

    .line 15
    .line 16
    .line 17
    const v0, 0x7f0a0236

    .line 18
    .line 19
    .line 20
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->nextStep(I)V

    .line 21
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
    .line 58
.end method

.method private exportCaCertificate()V
    .locals 3

    .line 1
    new-instance v0, Landroid/content/Intent;

    .line 2
    .line 3
    const-string v1, "android.intent.action.CREATE_DOCUMENT"

    .line 4
    .line 5
    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const-string v1, "android.intent.category.OPENABLE"

    .line 9
    .line 10
    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 11
    .line 12
    .line 13
    const-string v1, "application/x-x509-ca-cert"

    .line 14
    .line 15
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 16
    .line 17
    .line 18
    const-string v1, "android.intent.extra.TITLE"

    .line 19
    .line 20
    const-string v2, "PCAPdroid_CA.crt"

    .line 21
    .line 22
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 23
    .line 24
    .line 25
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certExportLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 30
    .line 31
    invoke-static {v1, v0, v2}, Lcom/emanuelef/remote_capture/Utils;->launchFileDialog(Landroid/content/Context;Landroid/content/Intent;Landroidx/activity/result/ActivityResultLauncher;)Z

    .line 32
    .line 33
    .line 34
    move-result v0

    .line 35
    if-nez v0, :cond_0

    .line 36
    .line 37
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certFail()V

    .line 38
    .line 39
    .line 40
    :cond_0
    return-void
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

.method private fallbackToCertExport()V
    .locals 1

    .line 1
    const/4 v0, 0x1

    .line 2
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mFallbackExport:Z

    .line 3
    .line 4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaPem:Ljava/lang/String;

    .line 5
    .line 6
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->onMitmGetCaCertificateResult(Ljava/lang/String;)V

    .line 7
    .line 8
    .line 9
    return-void
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

.method private installCaCertificate()V
    .locals 3

    .line 1
    invoke-static {}, Landroid/security/KeyChain;->createInstallIntent()Landroid/content/Intent;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "name"

    .line 6
    .line 7
    const-string v2, "PCAPdroid CA"

    .line 8
    .line 9
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 10
    .line 11
    .line 12
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaPem:Ljava/lang/String;

    .line 13
    .line 14
    sget-object v2, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    .line 15
    .line 16
    invoke-virtual {v1, v2}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    const-string v2, "CERT"

    .line 21
    .line 22
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    .line 23
    .line 24
    .line 25
    :try_start_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certInstallLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 26
    .line 27
    invoke-virtual {v1, v0}, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 28
    .line 29
    .line 30
    return-void

    .line 31
    :catch_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    const/4 v1, 0x0

    .line 36
    new-array v1, v1, [Ljava/lang/Object;

    .line 37
    .line 38
    const v2, 0x7f14020e

    .line 39
    .line 40
    .line 41
    invoke-static {v0, v2, v1}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 42
    .line 43
    .line 44
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->fallbackToCertExport()V

    .line 45
    .line 46
    .line 47
    return-void
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

.method private synthetic lambda$onMitmGetCaCertificateResult$5(Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->canInstallCertViaIntent()Z

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    if-eqz p1, :cond_0

    .line 6
    .line 7
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->installCaCertificate()V

    .line 8
    .line 9
    .line 10
    return-void

    .line 11
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->exportCaCertificate()V

    .line 12
    .line 13
    .line 14
    return-void
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

.method private synthetic lambda$onResume$3(Landroid/content/DialogInterface;I)V
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    const-string p2, "addon connect failed"

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    invoke-static {p1, p2, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 13
    .line 14
    .line 15
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certFail()V

    .line 16
    .line 17
    .line 18
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

.method private synthetic lambda$onResume$4(Landroid/content/DialogInterface;I)V
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 6
    .line 7
    .line 8
    move-result-object p2

    .line 9
    const-string v0, "com.pcapdroid.mitm"

    .line 10
    .line 11
    invoke-virtual {p2, v0}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 12
    .line 13
    .line 14
    move-result-object p2

    .line 15
    if-eqz p2, :cond_0

    .line 16
    .line 17
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/Utils;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V

    .line 18
    .line 19
    .line 20
    return-void

    .line 21
    :cond_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 22
    .line 23
    .line 24
    move-result-object p1

    .line 25
    const-string p2, "addon connect failed"

    .line 26
    .line 27
    const/4 v0, 0x1

    .line 28
    invoke-static {p1, p2, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 29
    .line 30
    .line 31
    move-result-object p1

    .line 32
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 33
    .line 34
    .line 35
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certFail()V

    .line 36
    .line 37
    .line 38
    return-void
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

.method private static synthetic lambda$onViewCreated$0(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private synthetic lambda$onViewCreated$1(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    const/4 p2, 0x1

    .line 6
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/MitmAddon;->setCAInstallationSkipped(Landroid/content/Context;Z)V

    .line 7
    .line 8
    .line 9
    const p1, 0x7f0a0236

    .line 10
    .line 11
    .line 12
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->gotoStep(I)V

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
.end method

.method private synthetic lambda$onViewCreated$2(Landroid/view/View;)V
    .locals 2

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzbv;

    .line 2
    .line 3
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    invoke-direct {v0, p1}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 8
    .line 9
    .line 10
    const p1, 0x7f1402f3

    .line 11
    .line 12
    .line 13
    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 14
    .line 15
    .line 16
    const p1, 0x7f1401b3

    .line 17
    .line 18
    .line 19
    invoke-virtual {v0, p1}, Lcom/android/billingclient/api/zzbv;->setMessage(I)V

    .line 20
    .line 21
    .line 22
    new-instance p1, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 23
    .line 24
    const/16 v1, 0x14

    .line 25
    .line 26
    invoke-direct {p1, v1}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 27
    .line 28
    .line 29
    const v1, 0x7f14006d

    .line 30
    .line 31
    .line 32
    invoke-virtual {v0, v1, p1}, Lcom/android/billingclient/api/zzbv;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 33
    .line 34
    .line 35
    new-instance p1, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda2;

    .line 36
    .line 37
    const/4 v1, 0x2

    .line 38
    invoke-direct {p1, p0, v1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda2;-><init>(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;I)V

    .line 39
    .line 40
    .line 41
    const v1, 0x7f14003b

    .line 42
    .line 43
    .line 44
    invoke-virtual {v0, v1, p1}, Lcom/android/billingclient/api/zzbv;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 45
    .line 46
    .line 47
    invoke-virtual {v0}, Lcom/android/billingclient/api/zzbv;->show()Landroidx/appcompat/app/AlertDialog;

    .line 48
    .line 49
    .line 50
    return-void
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method


# virtual methods
.method public onDestroyView()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->disconnect()V

    .line 4
    .line 5
    .line 6
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onDestroyView()V

    .line 7
    .line 8
    .line 9
    return-void
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

.method public onMitmGetCaCertificateResult(Ljava/lang/String;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->disconnect()V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getContext()Landroid/content/Context;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    const-string v1, "InstallCertificate"

    .line 11
    .line 12
    if-nez v0, :cond_0

    .line 13
    .line 14
    const-string p1, "null context"

    .line 15
    .line 16
    invoke-static {v1, p1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :cond_0
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaPem:Ljava/lang/String;

    .line 21
    .line 22
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 23
    .line 24
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->canInstallCertViaIntent()Z

    .line 25
    .line 26
    .line 27
    move-result v2

    .line 28
    if-eqz v2, :cond_1

    .line 29
    .line 30
    const v2, 0x7f14013f

    .line 31
    .line 32
    .line 33
    goto :goto_0

    .line 34
    :cond_1
    const v2, 0x7f140103

    .line 35
    .line 36
    .line 37
    :goto_0
    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 38
    .line 39
    .line 40
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaPem:Ljava/lang/String;

    .line 41
    .line 42
    if-eqz p1, :cond_5

    .line 43
    .line 44
    const-string p1, "Got certificate"

    .line 45
    .line 46
    invoke-static {v1, p1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    .line 48
    .line 49
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaPem:Ljava/lang/String;

    .line 50
    .line 51
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->x509FromPem(Ljava/lang/String;)Ljava/security/cert/X509Certificate;

    .line 52
    .line 53
    .line 54
    move-result-object p1

    .line 55
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaCert:Ljava/security/cert/X509Certificate;

    .line 56
    .line 57
    const/4 v1, 0x1

    .line 58
    if-eqz p1, :cond_4

    .line 59
    .line 60
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->isCAInstalled(Ljava/security/cert/X509Certificate;)Z

    .line 61
    .line 62
    .line 63
    move-result p1

    .line 64
    if-eqz p1, :cond_2

    .line 65
    .line 66
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certOk()V

    .line 67
    .line 68
    .line 69
    return-void

    .line 70
    :cond_2
    const/4 p1, 0x0

    .line 71
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/MitmAddon;->setDecryptionSetupDone(Landroid/content/Context;Z)V

    .line 72
    .line 73
    .line 74
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepIcon:Landroid/widget/ImageView;

    .line 75
    .line 76
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mWarnColor:I

    .line 77
    .line 78
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setColorFilter(I)V

    .line 79
    .line 80
    .line 81
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 82
    .line 83
    invoke-virtual {p1, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 84
    .line 85
    .line 86
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->canInstallCertViaIntent()Z

    .line 87
    .line 88
    .line 89
    move-result p1

    .line 90
    if-eqz p1, :cond_3

    .line 91
    .line 92
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepLabel:Landroid/widget/TextView;

    .line 93
    .line 94
    const v0, 0x7f140140

    .line 95
    .line 96
    .line 97
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 98
    .line 99
    .line 100
    goto :goto_1

    .line 101
    :cond_3
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepLabel:Landroid/widget/TextView;

    .line 102
    .line 103
    const v0, 0x7f140104

    .line 104
    .line 105
    .line 106
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 107
    .line 108
    .line 109
    :goto_1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 110
    .line 111
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda6;

    .line 112
    .line 113
    const/4 v1, 0x0

    .line 114
    invoke-direct {v0, p0, v1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda6;-><init>(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;I)V

    .line 115
    .line 116
    .line 117
    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 118
    .line 119
    .line 120
    return-void

    .line 121
    :cond_4
    const-string p1, "addon did not return certificate"

    .line 122
    .line 123
    invoke-static {v0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 124
    .line 125
    .line 126
    move-result-object p1

    .line 127
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 128
    .line 129
    .line 130
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certFail()V

    .line 131
    .line 132
    .line 133
    :cond_5
    return-void
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

.method public onMitmServiceConnect()V
    .locals 3

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    goto :goto_0

    .line 8
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 9
    .line 10
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/MitmAddon;->requestCaCertificate()Z

    .line 11
    .line 12
    .line 13
    move-result v1

    .line 14
    if-nez v1, :cond_1

    .line 15
    .line 16
    const-string v1, "requestCaCertificate failed"

    .line 17
    .line 18
    const/4 v2, 0x1

    .line 19
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 24
    .line 25
    .line 26
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certFail()V

    .line 27
    .line 28
    .line 29
    :cond_1
    :goto_0
    return-void
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

.method public onMitmServiceDisconnect()V
    .locals 3

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    goto :goto_0

    .line 8
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaPem:Ljava/lang/String;

    .line 9
    .line 10
    if-nez v1, :cond_1

    .line 11
    .line 12
    const-string v1, "addon disconnected"

    .line 13
    .line 14
    const/4 v2, 0x1

    .line 15
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 20
    .line 21
    .line 22
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certFail()V

    .line 23
    .line 24
    .line 25
    :cond_1
    :goto_0
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
    .line 58
.end method

.method public onResume()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mCaCert:Ljava/security/cert/X509Certificate;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->isCAInstalled(Ljava/security/cert/X509Certificate;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 10
    .line 11
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->isConnected()Z

    .line 12
    .line 13
    .line 14
    move-result v0

    .line 15
    if-nez v0, :cond_1

    .line 16
    .line 17
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 18
    .line 19
    const/4 v1, 0x0

    .line 20
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/MitmAddon;->connect(I)Z

    .line 21
    .line 22
    .line 23
    move-result v0

    .line 24
    if-nez v0, :cond_1

    .line 25
    .line 26
    new-instance v0, Lcom/android/billingclient/api/zzbv;

    .line 27
    .line 28
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 29
    .line 30
    .line 31
    move-result-object v1

    .line 32
    invoke-direct {v0, v1}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 33
    .line 34
    .line 35
    const v1, 0x7f1400fe

    .line 36
    .line 37
    .line 38
    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 39
    .line 40
    .line 41
    const v1, 0x7f1401a8

    .line 42
    .line 43
    .line 44
    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/zzbv;->setMessage(I)V

    .line 45
    .line 46
    .line 47
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda2;

    .line 48
    .line 49
    const/4 v2, 0x0

    .line 50
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda2;-><init>(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;I)V

    .line 51
    .line 52
    .line 53
    const v2, 0x7f140207

    .line 54
    .line 55
    .line 56
    invoke-virtual {v0, v2, v1}, Lcom/android/billingclient/api/zzbv;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 57
    .line 58
    .line 59
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda2;

    .line 60
    .line 61
    const/4 v2, 0x1

    .line 62
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda2;-><init>(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;I)V

    .line 63
    .line 64
    .line 65
    const v2, 0x7f1402fc

    .line 66
    .line 67
    .line 68
    invoke-virtual {v0, v2, v1}, Lcom/android/billingclient/api/zzbv;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 69
    .line 70
    .line 71
    invoke-virtual {v0}, Lcom/android/billingclient/api/zzbv;->show()Landroidx/appcompat/app/AlertDialog;

    .line 72
    .line 73
    .line 74
    goto :goto_0

    .line 75
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->certOk()V

    .line 76
    .line 77
    .line 78
    :cond_1
    :goto_0
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 79
    .line 80
    .line 81
    return-void
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

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0

    .line 1
    invoke-super {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepLabel:Landroid/widget/TextView;

    .line 5
    .line 6
    const p2, 0x7f14007d

    .line 7
    .line 8
    .line 9
    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(I)V

    .line 10
    .line 11
    .line 12
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 13
    .line 14
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->canInstallCertViaIntent()Z

    .line 15
    .line 16
    .line 17
    move-result p2

    .line 18
    if-eqz p2, :cond_0

    .line 19
    .line 20
    const p2, 0x7f14013f

    .line 21
    .line 22
    .line 23
    goto :goto_0

    .line 24
    :cond_0
    const p2, 0x7f140103

    .line 25
    .line 26
    .line 27
    :goto_0
    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(I)V

    .line 28
    .line 29
    .line 30
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->mStepButton:Landroid/widget/Button;

    .line 31
    .line 32
    const/4 p2, 0x0

    .line 33
    invoke-virtual {p1, p2}, Landroid/view/View;->setEnabled(Z)V

    .line 34
    .line 35
    .line 36
    new-instance p1, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda6;

    .line 37
    .line 38
    const/4 p2, 0x1

    .line 39
    invoke-direct {p1, p0, p2}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate$$ExternalSyntheticLambda6;-><init>(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;I)V

    .line 40
    .line 41
    .line 42
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/StepFragment;->showSkipButton(Landroid/view/View$OnClickListener;)V

    .line 43
    .line 44
    .line 45
    new-instance p1, Lcom/emanuelef/remote_capture/MitmAddon;

    .line 46
    .line 47
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 48
    .line 49
    .line 50
    move-result-object p2

    .line 51
    invoke-direct {p1, p2, p0}, Lcom/emanuelef/remote_capture/MitmAddon;-><init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/interfaces/MitmListener;)V

    .line 52
    .line 53
    .line 54
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallCertificate;->mAddon:Lcom/emanuelef/remote_capture/MitmAddon;

    .line 55
    .line 56
    return-void
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
