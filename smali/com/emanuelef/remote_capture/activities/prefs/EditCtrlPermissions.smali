.class public Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;
.super Lcom/emanuelef/remote_capture/activities/BaseActivity;
.source "SourceFile"

# interfaces
.implements Landroidx/core/view/MenuProvider;


# static fields
.field private static final TAG:Ljava/lang/String; = "EditCtrlPermissions"


# instance fields
.field private mAdapter:Lcom/emanuelef/remote_capture/adapters/CtrlPermissionsAdapter;

.field private mEmptyText:Landroid/widget/TextView;

.field private mListView:Landroid/widget/ListView;

.field private mPermissions:Lcom/emanuelef/remote_capture/model/CtrlPermissions;

.field private final mSelected:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/model/CtrlPermissions$Rule;",
            ">;"
        }
    .end annotation
.end field

.field private mShowApiKey:Landroid/view/MenuItem;


# direct methods
.method public static synthetic $r8$lambda$HrYrgNtxbzyo-9Sv_KNxSBy7INs(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;Ljava/lang/String;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->lambda$showApiKey$3(Ljava/lang/String;Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$LZXyVT7503AjkRjF2pOTweAmvFk(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->lambda$generateApiKey$0(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$dgoi2PYV6PyD84YoMEQuff115zY(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->lambda$showApiKey$2(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$w_u6ysIpSl9-yTh6R6cT0tQVdUY(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->lambda$generateApiKey$1(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static bridge synthetic -$$Nest$fgetmAdapter(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;)Lcom/emanuelef/remote_capture/adapters/CtrlPermissionsAdapter;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mAdapter:Lcom/emanuelef/remote_capture/adapters/CtrlPermissionsAdapter;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmListView(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;)Landroid/widget/ListView;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mListView:Landroid/widget/ListView;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmPermissions(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;)Lcom/emanuelef/remote_capture/model/CtrlPermissions;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mPermissions:Lcom/emanuelef/remote_capture/model/CtrlPermissions;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmSelected(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;)Ljava/util/ArrayList;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mSelected:Ljava/util/ArrayList;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$mrecheckListSize(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->recheckListSize()V

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/BaseActivity;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mSelected:Ljava/util/ArrayList;

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

.method private generateApiKey(Z)V
    .locals 6

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
    if-nez p1, :cond_0

    .line 11
    .line 12
    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->getApiKey(Landroid/content/SharedPreferences;)Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object p1

    .line 16
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 17
    .line 18
    .line 19
    move-result p1

    .line 20
    if-nez p1, :cond_0

    .line 21
    .line 22
    new-instance p1, Lcom/android/billingclient/api/zzbv;

    .line 23
    .line 24
    invoke-direct {p1, p0}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 25
    .line 26
    .line 27
    const v0, 0x7f1402f3

    .line 28
    .line 29
    .line 30
    invoke-virtual {p1, v0}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 31
    .line 32
    .line 33
    const v0, 0x7f14002c

    .line 34
    .line 35
    .line 36
    invoke-virtual {p1, v0}, Lcom/android/billingclient/api/zzbv;->setMessage(I)V

    .line 37
    .line 38
    .line 39
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;

    .line 40
    .line 41
    const/4 v1, 0x2

    .line 42
    invoke-direct {v0, v1, p0}, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 43
    .line 44
    .line 45
    const v1, 0x7f14021c

    .line 46
    .line 47
    .line 48
    invoke-virtual {p1, v1, v0}, Lcom/android/billingclient/api/zzbv;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 49
    .line 50
    .line 51
    new-instance v0, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 52
    .line 53
    const/16 v1, 0x9

    .line 54
    .line 55
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 56
    .line 57
    .line 58
    const v1, 0x7f14006d

    .line 59
    .line 60
    .line 61
    invoke-virtual {p1, v1, v0}, Lcom/android/billingclient/api/zzbv;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 62
    .line 63
    .line 64
    invoke-virtual {p1}, Lcom/android/billingclient/api/zzbv;->show()Landroidx/appcompat/app/AlertDialog;

    .line 65
    .line 66
    .line 67
    return-void

    .line 68
    :cond_0
    new-instance p1, Ljava/security/SecureRandom;

    .line 69
    .line 70
    invoke-direct {p1}, Ljava/security/SecureRandom;-><init>()V

    .line 71
    .line 72
    .line 73
    new-instance v2, Ljava/lang/StringBuilder;

    .line 74
    .line 75
    const/16 v3, 0x20

    .line 76
    .line 77
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 78
    .line 79
    .line 80
    :goto_0
    if-ge v1, v3, :cond_1

    .line 81
    .line 82
    const/16 v4, 0x3e

    .line 83
    .line 84
    invoke-virtual {p1, v4}, Ljava/util/Random;->nextInt(I)I

    .line 85
    .line 86
    .line 87
    move-result v4

    .line 88
    const-string v5, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"

    .line 89
    .line 90
    invoke-virtual {v5, v4}, Ljava/lang/String;->charAt(I)C

    .line 91
    .line 92
    .line 93
    move-result v4

    .line 94
    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 95
    .line 96
    .line 97
    add-int/lit8 v1, v1, 0x1

    .line 98
    .line 99
    goto :goto_0

    .line 100
    :cond_1
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    .line 101
    .line 102
    .line 103
    move-result-object p1

    .line 104
    const-string v0, "api_key"

    .line 105
    .line 106
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 107
    .line 108
    .line 109
    move-result-object v1

    .line 110
    invoke-interface {p1, v0, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 111
    .line 112
    .line 113
    move-result-object p1

    .line 114
    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 115
    .line 116
    .line 117
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mShowApiKey:Landroid/view/MenuItem;

    .line 118
    .line 119
    if-eqz p1, :cond_2

    .line 120
    .line 121
    const/4 v0, 0x1

    .line 122
    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 123
    .line 124
    .line 125
    :cond_2
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->showApiKey()V

    .line 126
    .line 127
    .line 128
    return-void
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

.method private synthetic lambda$generateApiKey$0(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    const/4 p1, 0x1

    .line 2
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->generateApiKey(Z)V

    .line 3
    .line 4
    .line 5
    return-void
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

.method private static synthetic lambda$generateApiKey$1(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private static synthetic lambda$showApiKey$2(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private synthetic lambda$showApiKey$3(Ljava/lang/String;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

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

.method private recheckListSize()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mEmptyText:Landroid/widget/TextView;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mAdapter:Lcom/emanuelef/remote_capture/adapters/CtrlPermissionsAdapter;

    .line 4
    .line 5
    invoke-interface {v1}, Landroid/widget/Adapter;->getCount()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    if-nez v1, :cond_0

    .line 10
    .line 11
    const/4 v1, 0x0

    .line 12
    goto :goto_0

    .line 13
    :cond_0
    const/16 v1, 0x8

    .line 14
    .line 15
    :goto_0
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

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
.end method

.method private showApiKey()V
    .locals 4

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
    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->getApiKey(Landroid/content/SharedPreferences;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    .line 15
    .line 16
    .line 17
    move-result v1

    .line 18
    if-eqz v1, :cond_0

    .line 19
    .line 20
    return-void

    .line 21
    :cond_0
    new-instance v1, Lcom/android/billingclient/api/zzbv;

    .line 22
    .line 23
    invoke-direct {v1, p0}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 24
    .line 25
    .line 26
    const v2, 0x7f14002b

    .line 27
    .line 28
    .line 29
    invoke-virtual {v1, v2}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 30
    .line 31
    .line 32
    iget-object v2, v1, Lcom/android/billingclient/api/zzbv;->zza:Ljava/lang/Object;

    .line 33
    .line 34
    check-cast v2, Landroidx/appcompat/app/AlertController$AlertParams;

    .line 35
    .line 36
    iput-object v0, v2, Landroidx/appcompat/app/AlertController$AlertParams;->mMessage:Ljava/lang/CharSequence;

    .line 37
    .line 38
    new-instance v2, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 39
    .line 40
    const/16 v3, 0x8

    .line 41
    .line 42
    invoke-direct {v2, v3}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 43
    .line 44
    .line 45
    const v3, 0x7f14021c

    .line 46
    .line 47
    .line 48
    invoke-virtual {v1, v3, v2}, Lcom/android/billingclient/api/zzbv;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 49
    .line 50
    .line 51
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;

    .line 52
    .line 53
    const/4 v3, 0x1

    .line 54
    invoke-direct {v2, p0, v3, v0}, Lcom/emanuelef/remote_capture/fragments/FirewallStatus$$ExternalSyntheticLambda2;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 55
    .line 56
    .line 57
    const v0, 0x7f1400ac

    .line 58
    .line 59
    .line 60
    invoke-virtual {v1, v0, v2}, Lcom/android/billingclient/api/zzbv;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 61
    .line 62
    .line 63
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzbv;->show()Landroidx/appcompat/app/AlertDialog;

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
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .line 1
    invoke-super {p0, p1}, Lcom/emanuelef/remote_capture/activities/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    const p1, 0x7f1400a5

    .line 5
    .line 6
    .line 7
    invoke-virtual {p0, p1}, Landroid/app/Activity;->setTitle(I)V

    .line 8
    .line 9
    .line 10
    const p1, 0x7f0d00aa

    .line 11
    .line 12
    .line 13
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/activities/BaseActivity;->setContentView(I)V

    .line 14
    .line 15
    .line 16
    invoke-virtual {p0, p0}, Landroidx/activity/ComponentActivity;->addMenuProvider(Landroidx/core/view/MenuProvider;)V

    .line 17
    .line 18
    .line 19
    const p1, 0x7f0a02ef

    .line 20
    .line 21
    .line 22
    invoke-virtual {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->findViewById(I)Landroid/view/View;

    .line 23
    .line 24
    .line 25
    move-result-object p1

    .line 26
    const/4 v0, 0x1

    .line 27
    invoke-virtual {p1, v0}, Landroid/view/View;->setFitsSystemWindows(Z)V

    .line 28
    .line 29
    .line 30
    const p1, 0x7f0a01d4

    .line 31
    .line 32
    .line 33
    invoke-virtual {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->findViewById(I)Landroid/view/View;

    .line 34
    .line 35
    .line 36
    move-result-object p1

    .line 37
    check-cast p1, Landroid/widget/TextView;

    .line 38
    .line 39
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mEmptyText:Landroid/widget/TextView;

    .line 40
    .line 41
    const v0, 0x7f140211

    .line 42
    .line 43
    .line 44
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 45
    .line 46
    .line 47
    const p1, 0x7f0a01d6

    .line 48
    .line 49
    .line 50
    invoke-virtual {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->findViewById(I)Landroid/view/View;

    .line 51
    .line 52
    .line 53
    move-result-object p1

    .line 54
    check-cast p1, Landroid/widget/ListView;

    .line 55
    .line 56
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mListView:Landroid/widget/ListView;

    .line 57
    .line 58
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 59
    .line 60
    .line 61
    move-result-object p1

    .line 62
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->getCtrlPermissions()Lcom/emanuelef/remote_capture/model/CtrlPermissions;

    .line 63
    .line 64
    .line 65
    move-result-object p1

    .line 66
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mPermissions:Lcom/emanuelef/remote_capture/model/CtrlPermissions;

    .line 67
    .line 68
    new-instance p1, Lcom/emanuelef/remote_capture/adapters/CtrlPermissionsAdapter;

    .line 69
    .line 70
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mPermissions:Lcom/emanuelef/remote_capture/model/CtrlPermissions;

    .line 71
    .line 72
    invoke-direct {p1, p0, v0}, Lcom/emanuelef/remote_capture/adapters/CtrlPermissionsAdapter;-><init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/CtrlPermissions;)V

    .line 73
    .line 74
    .line 75
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mAdapter:Lcom/emanuelef/remote_capture/adapters/CtrlPermissionsAdapter;

    .line 76
    .line 77
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mListView:Landroid/widget/ListView;

    .line 78
    .line 79
    invoke-virtual {v0, p1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 80
    .line 81
    .line 82
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mListView:Landroid/widget/ListView;

    .line 83
    .line 84
    const/4 v0, 0x3

    .line 85
    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setChoiceMode(I)V

    .line 86
    .line 87
    .line 88
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mListView:Landroid/widget/ListView;

    .line 89
    .line 90
    new-instance v0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions$1;

    .line 91
    .line 92
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions$1;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;)V

    .line 93
    .line 94
    .line 95
    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setMultiChoiceModeListener(Landroid/widget/AbsListView$MultiChoiceModeListener;)V

    .line 96
    .line 97
    .line 98
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mListView:Landroid/widget/ListView;

    .line 99
    .line 100
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->fixListviewInsetsBottom(Landroid/widget/ListView;)V

    .line 101
    .line 102
    .line 103
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->recheckListSize()V

    .line 104
    .line 105
    .line 106
    return-void
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

.method public onCreateMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2

    .line 1
    const v0, 0x7f0f000a

    .line 2
    .line 3
    .line 4
    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 5
    .line 6
    .line 7
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferencesName(Landroid/content/Context;)Ljava/lang/String;

    .line 8
    .line 9
    .line 10
    move-result-object p2

    .line 11
    const/4 v0, 0x0

    .line 12
    invoke-virtual {p0, p2, v0}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    .line 13
    .line 14
    .line 15
    move-result-object p2

    .line 16
    const v1, 0x7f0a02e9

    .line 17
    .line 18
    .line 19
    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 20
    .line 21
    .line 22
    move-result-object p1

    .line 23
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mShowApiKey:Landroid/view/MenuItem;

    .line 24
    .line 25
    invoke-static {p2}, Lcom/emanuelef/remote_capture/model/Prefs;->getApiKey(Landroid/content/SharedPreferences;)Ljava/lang/String;

    .line 26
    .line 27
    .line 28
    move-result-object p1

    .line 29
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 30
    .line 31
    .line 32
    move-result p1

    .line 33
    if-eqz p1, :cond_0

    .line 34
    .line 35
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->mShowApiKey:Landroid/view/MenuItem;

    .line 36
    .line 37
    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

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
    const v0, 0x7f0a0385

    .line 6
    .line 7
    .line 8
    const/4 v1, 0x1

    .line 9
    if-ne p1, v0, :cond_0

    .line 10
    .line 11
    new-instance p1, Landroid/content/Intent;

    .line 12
    .line 13
    const-string v0, "https://github.com/emanuele-f/PCAPdroid/blob/master/docs/app_api.md"

    .line 14
    .line 15
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    const-string v2, "android.intent.action.VIEW"

    .line 20
    .line 21
    invoke-direct {p1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 22
    .line 23
    .line 24
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/Utils;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V

    .line 25
    .line 26
    .line 27
    return v1

    .line 28
    :cond_0
    const v0, 0x7f0a0176

    .line 29
    .line 30
    .line 31
    const/4 v2, 0x0

    .line 32
    if-ne p1, v0, :cond_1

    .line 33
    .line 34
    invoke-direct {p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->generateApiKey(Z)V

    .line 35
    .line 36
    .line 37
    return v1

    .line 38
    :cond_1
    const v0, 0x7f0a02e9

    .line 39
    .line 40
    .line 41
    if-ne p1, v0, :cond_2

    .line 42
    .line 43
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->showApiKey()V

    .line 44
    .line 45
    .line 46
    return v1

    .line 47
    :cond_2
    return v2
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

.method public bridge synthetic onPrepareMenu(Landroid/view/Menu;)V
    .locals 0

    .line 1
    return-void
.end method
