.class public Lcom/emanuelef/remote_capture/PCAPdroid;
.super Landroid/app/Application;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String; = "PCAPdroid"

.field protected static isUnderTest:Z = false

.field private static mInstance:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Lcom/emanuelef/remote_capture/PCAPdroid;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

.field private mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

.field private mCtrlPermissions:Lcom/emanuelef/remote_capture/model/CtrlPermissions;

.field private mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

.field private mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

.field private mIsDecryptingPcap:Z

.field private mIsUsharkAvailable:Z

.field private mLoadedPcapBasename:Ljava/lang/String;

.field private mLocalizedContext:Landroid/content/Context;

.field private mMalwareWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

.field private mVisMask:Lcom/emanuelef/remote_capture/model/MatchList;


# direct methods
.method public static bridge synthetic -$$Nest$mcheckUidMapping(Lcom/emanuelef/remote_capture/PCAPdroid;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->checkUidMapping(Ljava/lang/String;)V

    return-void
.end method

.method public static bridge synthetic -$$Nest$mremoveUninstalledAppsFromAppFilter(Lcom/emanuelef/remote_capture/PCAPdroid;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/PCAPdroid;->removeUninstalledAppsFromAppFilter()V

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mIsDecryptingPcap:Z

    .line 6
    .line 7
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mIsUsharkAvailable:Z

    .line 8
    .line 9
    const/4 v0, 0x0

    .line 10
    iput-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLoadedPcapBasename:Ljava/lang/String;

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

.method private checkUidMapping(Ljava/lang/String;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mVisMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->uidMappingChanged(Ljava/lang/String;)Z

    .line 6
    .line 7
    .line 8
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mMalwareWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 9
    .line 10
    if-eqz v0, :cond_1

    .line 11
    .line 12
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->uidMappingChanged(Ljava/lang/String;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    if-eqz v0, :cond_1

    .line 17
    .line 18
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->reloadMalwareWhitelist()V

    .line 19
    .line 20
    .line 21
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 22
    .line 23
    if-eqz v0, :cond_2

    .line 24
    .line 25
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->uidMappingChanged(Ljava/lang/String;)Z

    .line 26
    .line 27
    .line 28
    move-result v0

    .line 29
    if-eqz v0, :cond_2

    .line 30
    .line 31
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isServiceActive()Z

    .line 32
    .line 33
    .line 34
    move-result v0

    .line 35
    if-eqz v0, :cond_2

    .line 36
    .line 37
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->requireInstance()Lcom/emanuelef/remote_capture/CaptureService;

    .line 38
    .line 39
    .line 40
    move-result-object v0

    .line 41
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/CaptureService;->reloadFirewallWhitelist()V

    .line 42
    .line 43
    .line 44
    :cond_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 45
    .line 46
    if-eqz v0, :cond_3

    .line 47
    .line 48
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->uidMappingChanged(Ljava/lang/String;)Z

    .line 49
    .line 50
    .line 51
    move-result v0

    .line 52
    if-eqz v0, :cond_3

    .line 53
    .line 54
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->reloadDecryptionList()V

    .line 55
    .line 56
    .line 57
    :cond_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 58
    .line 59
    if-eqz v0, :cond_4

    .line 60
    .line 61
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->uidMappingChanged(Ljava/lang/String;)Z

    .line 62
    .line 63
    .line 64
    move-result p1

    .line 65
    if-eqz p1, :cond_4

    .line 66
    .line 67
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isServiceActive()Z

    .line 68
    .line 69
    .line 70
    move-result p1

    .line 71
    if-eqz p1, :cond_4

    .line 72
    .line 73
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->requireInstance()Lcom/emanuelef/remote_capture/CaptureService;

    .line 74
    .line 75
    .line 76
    move-result-object p1

    .line 77
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/CaptureService;->reloadBlocklist()V

    .line 78
    .line 79
    .line 80
    :cond_4
    return-void
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

.method public static getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/PCAPdroid;->mInstance:Ljava/lang/ref/WeakReference;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 8
    .line 9
    return-object v0
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

.method private initFirewallWhitelist()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(I)Z

    .line 5
    .line 6
    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 8
    .line 9
    const/16 v1, 0x3e8

    .line 10
    .line 11
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(I)Z

    .line 12
    .line 13
    .line 14
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 15
    .line 16
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(Ljava/lang/String;)Z

    .line 21
    .line 22
    .line 23
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 24
    .line 25
    const-string v1, "com.google.android.gms"

    .line 26
    .line 27
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(Ljava/lang/String;)Z

    .line 28
    .line 29
    .line 30
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 31
    .line 32
    const-string v1, "com.google.android.gsf"

    .line 33
    .line 34
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(Ljava/lang/String;)Z

    .line 35
    .line 36
    .line 37
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 38
    .line 39
    const-string v1, "com.google.android.ims"

    .line 40
    .line 41
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(Ljava/lang/String;)Z

    .line 42
    .line 43
    .line 44
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 45
    .line 46
    const-string v1, "com.sec.spp.push"

    .line 47
    .line 48
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(Ljava/lang/String;)Z

    .line 49
    .line 50
    .line 51
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 52
    .line 53
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/MatchList;->save()V

    .line 54
    .line 55
    .line 56
    return-void
    .line 57
    .line 58
.end method

.method public static isUnderTest()Z
    .locals 1

    .line 1
    sget-boolean v0, Lcom/emanuelef/remote_capture/PCAPdroid;->isUnderTest:Z

    .line 2
    .line 3
    return v0
    .line 4
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

.method private removeUninstalledAppsFromAppFilter()V
    .locals 9

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
    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->getAppFilter(Landroid/content/SharedPreferences;)Ljava/util/Set;

    .line 11
    .line 12
    .line 13
    move-result-object v2

    .line 14
    new-instance v3, Ljava/util/ArrayList;

    .line 15
    .line 16
    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 17
    .line 18
    .line 19
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 20
    .line 21
    .line 22
    move-result-object v4

    .line 23
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 24
    .line 25
    .line 26
    move-result-object v5

    .line 27
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    .line 28
    .line 29
    .line 30
    move-result v6

    .line 31
    if-eqz v6, :cond_0

    .line 32
    .line 33
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 34
    .line 35
    .line 36
    move-result-object v6

    .line 37
    check-cast v6, Ljava/lang/String;

    .line 38
    .line 39
    :try_start_0
    invoke-static {v4, v6, v1}, Lcom/emanuelef/remote_capture/Utils;->getPackageInfo(Landroid/content/pm/PackageManager;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 40
    .line 41
    .line 42
    goto :goto_0

    .line 43
    :catch_0
    new-instance v7, Ljava/lang/StringBuilder;

    .line 44
    .line 45
    const-string v8, "Package "

    .line 46
    .line 47
    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 48
    .line 49
    .line 50
    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    const-string v8, " uninstalled, removing from app filter"

    .line 54
    .line 55
    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    .line 57
    .line 58
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 59
    .line 60
    .line 61
    move-result-object v7

    .line 62
    const-string v8, "PCAPdroid"

    .line 63
    .line 64
    invoke-static {v8, v7}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    .line 66
    .line 67
    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 68
    .line 69
    .line 70
    goto :goto_0

    .line 71
    :cond_0
    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    .line 72
    .line 73
    .line 74
    move-result v1

    .line 75
    if-nez v1, :cond_1

    .line 76
    .line 77
    invoke-interface {v2, v3}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 78
    .line 79
    .line 80
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    .line 81
    .line 82
    .line 83
    move-result-object v0

    .line 84
    const-string v1, "app_filter"

    .line 85
    .line 86
    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putStringSet(Ljava/lang/String;Ljava/util/Set;)Landroid/content/SharedPreferences$Editor;

    .line 87
    .line 88
    .line 89
    move-result-object v0

    .line 90
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 91
    .line 92
    .line 93
    :cond_1
    return-void
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


# virtual methods
.method public getBlacklists()Lcom/emanuelef/remote_capture/Blacklists;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lcom/emanuelef/remote_capture/Blacklists;

    .line 6
    .line 7
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLocalizedContext:Landroid/content/Context;

    .line 8
    .line 9
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/Blacklists;-><init>(Landroid/content/Context;)V

    .line 10
    .line 11
    .line 12
    iput-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 13
    .line 14
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 15
    .line 16
    return-object v0
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

.method public getBlocklist()Lcom/emanuelef/remote_capture/model/Blocklist;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 6
    .line 7
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLocalizedContext:Landroid/content/Context;

    .line 8
    .line 9
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/model/Blocklist;-><init>(Landroid/content/Context;)V

    .line 10
    .line 11
    .line 12
    iput-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 13
    .line 14
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 15
    .line 16
    return-object v0
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

.method public getCtrlPermissions()Lcom/emanuelef/remote_capture/model/CtrlPermissions;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mCtrlPermissions:Lcom/emanuelef/remote_capture/model/CtrlPermissions;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lcom/emanuelef/remote_capture/model/CtrlPermissions;

    .line 6
    .line 7
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/model/CtrlPermissions;-><init>(Landroid/content/Context;)V

    .line 8
    .line 9
    .line 10
    iput-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mCtrlPermissions:Lcom/emanuelef/remote_capture/model/CtrlPermissions;

    .line 11
    .line 12
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mCtrlPermissions:Lcom/emanuelef/remote_capture/model/CtrlPermissions;

    .line 13
    .line 14
    return-object v0
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

.method public getDecryptionList()Lcom/emanuelef/remote_capture/model/MatchList;
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lcom/emanuelef/remote_capture/model/MatchList;

    .line 6
    .line 7
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLocalizedContext:Landroid/content/Context;

    .line 8
    .line 9
    const-string v2, "decryption_list"

    .line 10
    .line 11
    invoke-direct {v0, v1, v2}, Lcom/emanuelef/remote_capture/model/MatchList;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 12
    .line 13
    .line 14
    iput-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 15
    .line 16
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 17
    .line 18
    return-object v0
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

.method public getFirewallWhitelist()Lcom/emanuelef/remote_capture/model/MatchList;
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferencesName(Landroid/content/Context;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    const/4 v1, 0x0

    .line 10
    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    new-instance v1, Lcom/emanuelef/remote_capture/model/MatchList;

    .line 15
    .line 16
    iget-object v2, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLocalizedContext:Landroid/content/Context;

    .line 17
    .line 18
    const-string v3, "firewall_whitelist"

    .line 19
    .line 20
    invoke-direct {v1, v2, v3}, Lcom/emanuelef/remote_capture/model/MatchList;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 21
    .line 22
    .line 23
    iput-object v1, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 24
    .line 25
    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->isFirewallWhitelistInitialized(Landroid/content/SharedPreferences;)Z

    .line 26
    .line 27
    .line 28
    move-result v1

    .line 29
    if-nez v1, :cond_0

    .line 30
    .line 31
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/PCAPdroid;->initFirewallWhitelist()V

    .line 32
    .line 33
    .line 34
    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->setFirewallWhitelistInitialized(Landroid/content/SharedPreferences;)V

    .line 35
    .line 36
    .line 37
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 38
    .line 39
    return-object v0
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

.method public getLoadedPcapBasename()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLoadedPcapBasename:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
    .line 4
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

.method public getMalwareWhitelist()Lcom/emanuelef/remote_capture/model/MatchList;
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mMalwareWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lcom/emanuelef/remote_capture/model/MatchList;

    .line 6
    .line 7
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLocalizedContext:Landroid/content/Context;

    .line 8
    .line 9
    const-string v2, "malware_whitelist"

    .line 10
    .line 11
    invoke-direct {v0, v1, v2}, Lcom/emanuelef/remote_capture/model/MatchList;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 12
    .line 13
    .line 14
    iput-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mMalwareWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 15
    .line 16
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mMalwareWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 17
    .line 18
    return-object v0
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

.method public getVisualizationMask()Lcom/emanuelef/remote_capture/model/MatchList;
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mVisMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lcom/emanuelef/remote_capture/model/MatchList;

    .line 6
    .line 7
    iget-object v1, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLocalizedContext:Landroid/content/Context;

    .line 8
    .line 9
    const-string v2, "vis_mask"

    .line 10
    .line 11
    invoke-direct {v0, v1, v2}, Lcom/emanuelef/remote_capture/model/MatchList;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 12
    .line 13
    .line 14
    iput-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mVisMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 15
    .line 16
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mVisMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 17
    .line 18
    return-object v0
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

.method public isDecryptingPcap()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mIsDecryptingPcap:Z

    .line 2
    .line 3
    return v0
    .line 4
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

.method public isUsharkAvailable()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mIsUsharkAvailable:Z

    .line 2
    .line 3
    return v0
    .line 4
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

.method public onCreate()V
    .locals 5

    .line 1
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    # PCAPdroid-mod: init Chaquopy Python before any Service uses Python.getInstance()
    invoke-static {}, Lcom/chaquo/python/Python;->isStarted()Z
    move-result v4
    if-nez v4, :cond_py_init
    new-instance v4, Lcom/chaquo/python/android/AndroidPlatform;
    invoke-direct {v4, p0}, Lcom/chaquo/python/android/AndroidPlatform;-><init>(Landroid/content/Context;)V
    invoke-static {v4}, Lcom/chaquo/python/Python;->start(Lcom/chaquo/python/Python$Platform;)V
    :cond_py_init

    .line 2
    .line 3
    .line 4
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->isUnderTest()Z

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    if-nez v0, :cond_0

    .line 9
    .line 10
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v0

    .line 18
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Log;->init(Ljava/lang/String;)V

    .line 19
    .line 20
    .line 21
    :cond_0
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Utils;->getVerifiedBuild(Landroid/content/Context;)Lcom/emanuelef/remote_capture/Utils$BuildType;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    new-instance v1, Ljava/lang/StringBuilder;

    .line 26
    .line 27
    const-string v2, "Build type: "

    .line 28
    .line 29
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 30
    .line 31
    .line 32
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 33
    .line 34
    .line 35
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 36
    .line 37
    .line 38
    move-result-object v1

    .line 39
    const-string v2, "PCAPdroid"

    .line 40
    .line 41
    invoke-static {v2, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    .line 43
    .line 44
    sget-object v1, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->config:Lcat/ereza/customactivityoncrash/config/CaocConfig;

    .line 45
    .line 46
    new-instance v2, Lcat/ereza/customactivityoncrash/config/CaocConfig;

    .line 47
    .line 48
    invoke-direct {v2}, Lcat/ereza/customactivityoncrash/config/CaocConfig;-><init>()V

    .line 49
    .line 50
    .line 51
    iget-boolean v3, v1, Lcat/ereza/customactivityoncrash/config/CaocConfig;->enabled:Z

    .line 52
    .line 53
    iput-boolean v3, v2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->enabled:Z

    .line 54
    .line 55
    iget-object v3, v1, Lcat/ereza/customactivityoncrash/config/CaocConfig;->errorDrawable:Ljava/lang/Integer;

    .line 56
    .line 57
    iput-object v3, v2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->errorDrawable:Ljava/lang/Integer;

    .line 58
    .line 59
    iget-object v3, v1, Lcat/ereza/customactivityoncrash/config/CaocConfig;->errorActivityClass:Ljava/lang/Class;

    .line 60
    .line 61
    iput-object v3, v2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->errorActivityClass:Ljava/lang/Class;

    .line 62
    .line 63
    iget-object v1, v1, Lcat/ereza/customactivityoncrash/config/CaocConfig;->restartActivityClass:Ljava/lang/Class;

    .line 64
    .line 65
    iput-object v1, v2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->restartActivityClass:Ljava/lang/Class;

    .line 66
    .line 67
    sget-object v1, Lcom/emanuelef/remote_capture/Utils$BuildType;->PLAYSTORE:Lcom/emanuelef/remote_capture/Utils$BuildType;

    .line 68
    .line 69
    if-eq v0, v1, :cond_2

    .line 70
    .line 71
    sget-object v1, Lcom/emanuelef/remote_capture/Utils$BuildType;->UNKNOWN:Lcom/emanuelef/remote_capture/Utils$BuildType;

    .line 72
    .line 73
    if-ne v0, v1, :cond_1

    .line 74
    .line 75
    goto :goto_0

    .line 76
    :cond_1
    const v0, 0x7f08017a

    .line 77
    .line 78
    .line 79
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 80
    .line 81
    .line 82
    move-result-object v0

    .line 83
    iput-object v0, v2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->errorDrawable:Ljava/lang/Integer;

    .line 84
    .line 85
    const-class v0, Lcom/emanuelef/remote_capture/activities/ErrorActivity;

    .line 86
    .line 87
    iput-object v0, v2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->errorActivityClass:Ljava/lang/Class;

    .line 88
    .line 89
    goto :goto_1

    .line 90
    :cond_2
    :goto_0
    const/4 v0, 0x0

    .line 91
    iput-boolean v0, v2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->enabled:Z

    .line 92
    .line 93
    :goto_1
    sput-object v2, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->config:Lcat/ereza/customactivityoncrash/config/CaocConfig;

    .line 94
    .line 95
    new-instance v0, Ljava/lang/ref/WeakReference;

    .line 96
    .line 97
    invoke-direct {v0, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 98
    .line 99
    .line 100
    sput-object v0, Lcom/emanuelef/remote_capture/PCAPdroid;->mInstance:Ljava/lang/ref/WeakReference;

    .line 101
    .line 102
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Utils;->getLocalizedConfig(Landroid/content/Context;)Landroid/content/res/Configuration;

    .line 103
    .line 104
    .line 105
    move-result-object v0

    .line 106
    invoke-virtual {p0, v0}, Landroid/content/Context;->createConfigurationContext(Landroid/content/res/Configuration;)Landroid/content/Context;

    .line 107
    .line 108
    .line 109
    move-result-object v0

    .line 110
    iput-object v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLocalizedContext:Landroid/content/Context;

    .line 111
    .line 112
    invoke-static {p0}, Lcom/emanuelef/remote_capture/CaptureService;->isUsharkAvailable(Landroid/content/Context;)Z

    .line 113
    .line 114
    .line 115
    move-result v0

    .line 116
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mIsUsharkAvailable:Z

    .line 117
    .line 118
    new-instance v0, Landroid/content/IntentFilter;

    .line 119
    .line 120
    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 121
    .line 122
    .line 123
    const-string v1, "android.intent.action.PACKAGE_ADDED"

    .line 124
    .line 125
    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 126
    .line 127
    .line 128
    const-string v1, "android.intent.action.PACKAGE_REMOVED"

    .line 129
    .line 130
    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 131
    .line 132
    .line 133
    const-string v1, "package"

    .line 134
    .line 135
    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    .line 136
    .line 137
    .line 138
    new-instance v1, Lcom/emanuelef/remote_capture/PCAPdroid$1;

    .line 139
    .line 140
    invoke-direct {v1, p0}, Lcom/emanuelef/remote_capture/PCAPdroid$1;-><init>(Lcom/emanuelef/remote_capture/PCAPdroid;)V

    .line 141
    .line 142
    .line 143
    invoke-virtual {p0, v1, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 144
    .line 145
    .line 146
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/PCAPdroid;->removeUninstalledAppsFromAppFilter()V

    .line 147
    .line 148
    .line 149
    return-void
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

.method public setIsDecryptingPcap(Z)V
    .locals 0

    .line 1
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mIsDecryptingPcap:Z

    .line 2
    .line 3
    return-void
    .line 4
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

.method public setLoadedPcapBasename(Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/PCAPdroid;->mLoadedPcapBasename:Ljava/lang/String;

    .line 2
    .line 3
    return-void
    .line 4
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
