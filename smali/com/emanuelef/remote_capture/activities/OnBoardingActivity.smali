.class public Lcom/emanuelef/remote_capture/activities/OnBoardingActivity;
.super Lcom/github/appintro/AppIntro;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;
    }
.end annotation


# static fields
.field public static final ENABLE_BACK_BUTTON:Ljava/lang/String; = "back_enabled"

.field private static final TAG:Ljava/lang/String; = "OnBoardingActivity"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/github/appintro/AppIntro;-><init>()V

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

.method private runMainActivity()V
    .locals 2

    .line 1
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferencesName(Landroid/content/Context;)Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const/4 v1, 0x0

    .line 6
    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->refreshAppVersion(Landroid/content/SharedPreferences;)V

    .line 11
    .line 12
    .line 13
    new-instance v0, Landroid/content/Intent;

    .line 14
    .line 15
    const-class v1, Lcom/emanuelef/remote_capture/activities/MainActivity;

    .line 16
    .line 17
    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 18
    .line 19
    .line 20
    const v1, 0x10008000

    .line 21
    .line 22
    .line 23
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 24
    .line 25
    .line 26
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 27
    .line 28
    .line 29
    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    .line 30
    .line 31
    .line 32
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


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 7

    .line 1
    invoke-super {p0, p1}, Lcom/github/appintro/AppIntroBase;->onCreate(Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Billing;->newInstance(Landroid/content/Context;)Lcom/emanuelef/remote_capture/PlayBilling;

    .line 5
    .line 6
    .line 7
    move-result-object p1

    .line 8
    invoke-virtual {p0}, Lcom/github/appintro/AppIntroBase;->setImmersiveMode()V

    .line 9
    .line 10
    .line 11
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    const/4 v1, 0x0

    .line 16
    if-eqz v0, :cond_0

    .line 17
    .line 18
    const-string v2, "back_enabled"

    .line 19
    .line 20
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    .line 21
    .line 22
    .line 23
    move-result v0

    .line 24
    goto :goto_0

    .line 25
    :cond_0
    const/4 v0, 0x0

    .line 26
    :goto_0
    const v2, 0x7f1402f5

    .line 27
    .line 28
    .line 29
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 30
    .line 31
    .line 32
    move-result-object v2

    .line 33
    const v3, 0x7f14003e

    .line 34
    .line 35
    .line 36
    invoke-virtual {p0, v3}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    .line 37
    .line 38
    .line 39
    move-result-object v3

    .line 40
    const v4, 0x7f0801ae

    .line 41
    .line 42
    .line 43
    const v5, 0x7f06003c

    .line 44
    .line 45
    .line 46
    const/4 v6, 0x1

    .line 47
    invoke-static {v2, v3, v4, v5, v6}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZ)Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;

    .line 48
    .line 49
    .line 50
    move-result-object v2

    .line 51
    invoke-virtual {p0, v2}, Lcom/github/appintro/AppIntroBase;->addSlide(Landroidx/fragment/app/Fragment;)V

    .line 52
    .line 53
    .line 54
    const v2, 0x7f140250

    .line 55
    .line 56
    .line 57
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 58
    .line 59
    .line 60
    move-result-object v2

    .line 61
    const-string v3, "https://emanuele-f.github.io/PCAPdroid/privacy"

    .line 62
    .line 63
    const-string v4, "https://github.com/emanuele-f/PCAPdroid"

    .line 64
    .line 65
    filled-new-array {v3, v4}, [Ljava/lang/String;

    .line 66
    .line 67
    .line 68
    move-result-object v3

    .line 69
    const v4, 0x7f14003a

    .line 70
    .line 71
    .line 72
    invoke-static {p0, v4, v3}, Lcom/emanuelef/remote_capture/Utils;->getText(Landroid/content/Context;I[Ljava/lang/String;)Ljava/lang/CharSequence;

    .line 73
    .line 74
    .line 75
    move-result-object v3

    .line 76
    const v4, 0x7f0801c5

    .line 77
    .line 78
    .line 79
    invoke-static {v2, v3, v4, v5, v6}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZ)Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;

    .line 80
    .line 81
    .line 82
    move-result-object v2

    .line 83
    invoke-virtual {p0, v2}, Lcom/github/appintro/AppIntroBase;->addSlide(Landroidx/fragment/app/Fragment;)V

    .line 84
    .line 85
    .line 86
    const v2, 0x7f1402c9

    .line 87
    .line 88
    .line 89
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 90
    .line 91
    .line 92
    move-result-object v2

    .line 93
    const-string v3, "https://emanuele-f.github.io/PCAPdroid/tls_decryption"

    .line 94
    .line 95
    filled-new-array {v3}, [Ljava/lang/String;

    .line 96
    .line 97
    .line 98
    move-result-object v3

    .line 99
    const v4, 0x7f14003d

    .line 100
    .line 101
    .line 102
    invoke-static {p0, v4, v3}, Lcom/emanuelef/remote_capture/Utils;->getText(Landroid/content/Context;I[Ljava/lang/String;)Ljava/lang/CharSequence;

    .line 103
    .line 104
    .line 105
    move-result-object v3

    .line 106
    const v4, 0x7f080178

    .line 107
    .line 108
    .line 109
    invoke-static {v2, v3, v4, v1, v1}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZ)Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;

    .line 110
    .line 111
    .line 112
    move-result-object v2

    .line 113
    invoke-virtual {p0, v2}, Lcom/github/appintro/AppIntroBase;->addSlide(Landroidx/fragment/app/Fragment;)V

    .line 114
    .line 115
    .line 116
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PlayBilling;->isPlayStore()Z

    .line 117
    .line 118
    .line 119
    move-result p1

    .line 120
    if-eqz p1, :cond_1

    .line 121
    .line 122
    const p1, 0x7f140111

    .line 123
    .line 124
    .line 125
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 126
    .line 127
    .line 128
    move-result-object p1

    .line 129
    const-string v2, "https://emanuele-f.github.io/PCAPdroid/paid_features#51-firewall"

    .line 130
    .line 131
    filled-new-array {v2}, [Ljava/lang/String;

    .line 132
    .line 133
    .line 134
    move-result-object v2

    .line 135
    const v3, 0x7f140035

    .line 136
    .line 137
    .line 138
    invoke-static {p0, v3, v2}, Lcom/emanuelef/remote_capture/Utils;->getText(Landroid/content/Context;I[Ljava/lang/String;)Ljava/lang/CharSequence;

    .line 139
    .line 140
    .line 141
    move-result-object v2

    .line 142
    const v3, 0x7f08009d

    .line 143
    .line 144
    .line 145
    invoke-static {p1, v2, v3, v1, v1}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZ)Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;

    .line 146
    .line 147
    .line 148
    move-result-object p1

    .line 149
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntroBase;->addSlide(Landroidx/fragment/app/Fragment;)V

    .line 150
    .line 151
    .line 152
    const p1, 0x7f140183

    .line 153
    .line 154
    .line 155
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 156
    .line 157
    .line 158
    move-result-object p1

    .line 159
    const-string v2, "https://emanuele-f.github.io/PCAPdroid/paid_features#52-malware-detection"

    .line 160
    .line 161
    filled-new-array {v2}, [Ljava/lang/String;

    .line 162
    .line 163
    .line 164
    move-result-object v2

    .line 165
    const v3, 0x7f140038

    .line 166
    .line 167
    .line 168
    invoke-static {p0, v3, v2}, Lcom/emanuelef/remote_capture/Utils;->getText(Landroid/content/Context;I[Ljava/lang/String;)Ljava/lang/CharSequence;

    .line 169
    .line 170
    .line 171
    move-result-object v2

    .line 172
    const v3, 0x7f0801da

    .line 173
    .line 174
    .line 175
    invoke-static {p1, v2, v3, v1, v1}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZ)Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;

    .line 176
    .line 177
    .line 178
    move-result-object p1

    .line 179
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntroBase;->addSlide(Landroidx/fragment/app/Fragment;)V

    .line 180
    .line 181
    .line 182
    :cond_1
    const p1, 0x7f1402c8

    .line 183
    .line 184
    .line 185
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 186
    .line 187
    .line 188
    move-result-object p1

    .line 189
    const-string v2, "https://emanuele-f.github.io/PCAPdroid/dump_modes"

    .line 190
    .line 191
    const-string v3, "https://emanuele-f.github.io/PCAPdroid/advanced_features#45-pcapdroid-extensions"

    .line 192
    .line 193
    filled-new-array {v2, v3}, [Ljava/lang/String;

    .line 194
    .line 195
    .line 196
    move-result-object v2

    .line 197
    const v3, 0x7f14003c

    .line 198
    .line 199
    .line 200
    invoke-static {p0, v3, v2}, Lcom/emanuelef/remote_capture/Utils;->getText(Landroid/content/Context;I[Ljava/lang/String;)Ljava/lang/CharSequence;

    .line 201
    .line 202
    .line 203
    move-result-object v2

    .line 204
    const v3, 0x7f08009c

    .line 205
    .line 206
    .line 207
    invoke-static {p1, v2, v3, v1, v1}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZ)Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;

    .line 208
    .line 209
    .line 210
    move-result-object p1

    .line 211
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntroBase;->addSlide(Landroidx/fragment/app/Fragment;)V

    .line 212
    .line 213
    .line 214
    const p1, 0x7f1400ae

    .line 215
    .line 216
    .line 217
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 218
    .line 219
    .line 220
    move-result-object p1

    .line 221
    const v1, 0x7f140036

    .line 222
    .line 223
    .line 224
    invoke-virtual {p0, v1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    .line 225
    .line 226
    .line 227
    move-result-object v1

    .line 228
    const v2, 0x7f0801aa

    .line 229
    .line 230
    .line 231
    invoke-static {p1, v1, v2, v5, v6}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;->createInstance(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZ)Lcom/emanuelef/remote_capture/activities/OnBoardingActivity$OnBoardingFragment;

    .line 232
    .line 233
    .line 234
    move-result-object p1

    .line 235
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntroBase;->addSlide(Landroidx/fragment/app/Fragment;)V

    .line 236
    .line 237
    .line 238
    invoke-virtual {p0, v6}, Lcom/github/appintro/AppIntroBase;->showStatusBar(Z)V

    .line 239
    .line 240
    .line 241
    invoke-virtual {p0, v6}, Lcom/github/appintro/AppIntroBase;->setSkipButtonEnabled(Z)V

    .line 242
    .line 243
    .line 244
    invoke-virtual {p0, v6}, Lcom/github/appintro/AppIntroBase;->setIndicatorEnabled(Z)V

    .line 245
    .line 246
    .line 247
    xor-int/lit8 p1, v0, 0x1

    .line 248
    .line 249
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntroBase;->setSystemBackButtonLocked(Z)V

    .line 250
    .line 251
    .line 252
    invoke-static {p0, v5}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 253
    .line 254
    .line 255
    move-result p1

    .line 256
    const v0, 0x7f06003d

    .line 257
    .line 258
    .line 259
    invoke-static {p0, v0}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 260
    .line 261
    .line 262
    move-result v0

    .line 263
    invoke-virtual {p0, p1, v0}, Lcom/github/appintro/AppIntroBase;->setIndicatorColor(II)V

    .line 264
    .line 265
    .line 266
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntro;->setBackArrowColor(I)V

    .line 267
    .line 268
    .line 269
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntro;->setColorSkipButton(I)V

    .line 270
    .line 271
    .line 272
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntro;->setNextArrowColor(I)V

    .line 273
    .line 274
    .line 275
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntro;->setBackArrowColor(I)V

    .line 276
    .line 277
    .line 278
    invoke-virtual {p0, p1}, Lcom/github/appintro/AppIntro;->setColorDoneText(I)V

    .line 279
    .line 280
    .line 281
    return-void
.end method

.method public onDonePressed(Landroidx/fragment/app/Fragment;)V
    .locals 2

    .line 1
    const-string v0, "OnBoardingActivity"

    .line 2
    .line 3
    const-string v1, "onDonePressed"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-super {p0, p1}, Lcom/github/appintro/AppIntroBase;->onDonePressed(Landroidx/fragment/app/Fragment;)V

    .line 9
    .line 10
    .line 11
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity;->runMainActivity()V

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

.method public onSkipPressed(Landroidx/fragment/app/Fragment;)V
    .locals 2

    .line 1
    const-string v0, "OnBoardingActivity"

    .line 2
    .line 3
    const-string v1, "onSkipPressed"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-super {p0, p1}, Lcom/github/appintro/AppIntroBase;->onSkipPressed(Landroidx/fragment/app/Fragment;)V

    .line 9
    .line 10
    .line 11
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/OnBoardingActivity;->runMainActivity()V

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
