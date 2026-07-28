.class public Lcom/emanuelef/remote_capture/VpnReconnectService;
.super Landroid/app/Service;
.source "SourceFile"


# static fields
.field private static INSTANCE:Lcom/emanuelef/remote_capture/VpnReconnectService; = null

.field private static final NOTIFY_CHAN_VPNRECONNECT:Ljava/lang/String; = "VPN Reconnection"

.field public static final NOTIFY_ID_VPNRECONNECT:I = 0xa

.field private static final STOP_ACTION:Ljava/lang/String; = "stop"

.field private static final TAG:Ljava/lang/String; = "VpnReconnectService"


# instance fields
.field private mActiveVpnNetwork:Landroid/net/Network;

.field private mHandler:Landroid/os/Handler;

.field private mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;


# direct methods
.method public static synthetic $r8$lambda$f9fKmzI4JxapiF2h0Nv2wbEaUkI()V
    .locals 0

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->lambda$onStartCommand$0()V

    return-void
.end method

.method public static bridge synthetic -$$Nest$fgetmActiveVpnNetwork(Lcom/emanuelef/remote_capture/VpnReconnectService;)Landroid/net/Network;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mActiveVpnNetwork:Landroid/net/Network;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmHandler(Lcom/emanuelef/remote_capture/VpnReconnectService;)Landroid/os/Handler;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mHandler:Landroid/os/Handler;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$mcheckAvailableNetwork(Lcom/emanuelef/remote_capture/VpnReconnectService;Landroid/net/ConnectivityManager;Landroid/net/Network;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/VpnReconnectService;->checkAvailableNetwork(Landroid/net/ConnectivityManager;Landroid/net/Network;)V

    return-void
.end method

.method public static bridge synthetic -$$Nest$munregisterNetworkCallback(Lcom/emanuelef/remote_capture/VpnReconnectService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->unregisterNetworkCallback()V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

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

.method private buildNotification()Landroid/app/Notification;
    .locals 7

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 2
    .line 3
    const/16 v1, 0x1a

    .line 4
    .line 5
    const/4 v2, 0x2

    .line 6
    const-string v3, "VPN Reconnection"

    .line 7
    .line 8
    const/4 v4, 0x0

    .line 9
    if-lt v0, v1, :cond_0

    .line 10
    .line 11
    const-string v0, "notification"

    .line 12
    .line 13
    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    check-cast v0, Landroid/app/NotificationManager;

    .line 18
    .line 19
    new-instance v1, Landroid/app/NotificationChannel;

    .line 20
    .line 21
    invoke-direct {v1, v3, v3, v2}, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    .line 22
    .line 23
    .line 24
    invoke-virtual {v1, v4}, Landroid/app/NotificationChannel;->setShowBadge(Z)V

    .line 25
    .line 26
    .line 27
    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    .line 28
    .line 29
    .line 30
    :cond_0
    new-instance v0, Landroid/content/Intent;

    .line 31
    .line 32
    const-class v1, Lcom/emanuelef/remote_capture/activities/MainActivity;

    .line 33
    .line 34
    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 35
    .line 36
    .line 37
    const/high16 v1, 0x8000000

    .line 38
    .line 39
    invoke-static {v1}, Lcom/emanuelef/remote_capture/Utils;->getIntentFlags(I)I

    .line 40
    .line 41
    .line 42
    move-result v1

    .line 43
    invoke-static {p0, v4, v0, v1}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    new-instance v1, Landroid/content/Intent;

    .line 48
    .line 49
    const-class v5, Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 50
    .line 51
    invoke-direct {v1, p0, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 52
    .line 53
    .line 54
    const-string v5, "stop"

    .line 55
    .line 56
    invoke-virtual {v1, v5}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 57
    .line 58
    .line 59
    invoke-static {v4}, Lcom/emanuelef/remote_capture/Utils;->getIntentFlags(I)I

    .line 60
    .line 61
    .line 62
    move-result v5

    .line 63
    invoke-static {p0, v4, v1, v5}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    .line 64
    .line 65
    .line 66
    move-result-object v1

    .line 67
    new-instance v5, Landroidx/core/app/NotificationCompat$Builder;

    .line 68
    .line 69
    invoke-direct {v5, p0, v3}, Landroidx/core/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 70
    .line 71
    .line 72
    const v3, 0x7f0801ae

    .line 73
    .line 74
    .line 75
    iget-object v6, v5, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 76
    .line 77
    iput v3, v6, Landroid/app/Notification;->icon:I

    .line 78
    .line 79
    const v3, 0x7f060040

    .line 80
    .line 81
    .line 82
    invoke-static {p0, v3}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 83
    .line 84
    .line 85
    move-result v3

    .line 86
    iput v3, v5, Landroidx/core/app/NotificationCompat$Builder;->mColor:I

    .line 87
    .line 88
    iput-object v0, v5, Landroidx/core/app/NotificationCompat$Builder;->mContentIntent:Landroid/app/PendingIntent;

    .line 89
    .line 90
    iget-object v0, v5, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 91
    .line 92
    iput-object v1, v0, Landroid/app/Notification;->deleteIntent:Landroid/app/PendingIntent;

    .line 93
    .line 94
    const/4 v0, 0x1

    .line 95
    invoke-virtual {v5, v2, v0}, Landroidx/core/app/NotificationCompat$Builder;->setFlag(IZ)V

    .line 96
    .line 97
    .line 98
    const/16 v1, 0x10

    .line 99
    .line 100
    invoke-virtual {v5, v1, v4}, Landroidx/core/app/NotificationCompat$Builder;->setFlag(IZ)V

    .line 101
    .line 102
    .line 103
    const v1, 0x7f1402ec

    .line 104
    .line 105
    .line 106
    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 107
    .line 108
    .line 109
    move-result-object v1

    .line 110
    invoke-static {v1}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 111
    .line 112
    .line 113
    move-result-object v1

    .line 114
    iput-object v1, v5, Landroidx/core/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    .line 115
    .line 116
    const v1, 0x7f1402f1

    .line 117
    .line 118
    .line 119
    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 120
    .line 121
    .line 122
    move-result-object v1

    .line 123
    invoke-static {v1}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 124
    .line 125
    .line 126
    move-result-object v1

    .line 127
    iput-object v1, v5, Landroidx/core/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    .line 128
    .line 129
    iput v0, v5, Landroidx/core/app/NotificationCompat$Builder;->mVisibility:I

    .line 130
    .line 131
    const-string v0, "status"

    .line 132
    .line 133
    iput-object v0, v5, Landroidx/core/app/NotificationCompat$Builder;->mCategory:Ljava/lang/String;

    .line 134
    .line 135
    const/4 v0, -0x1

    .line 136
    iput v0, v5, Landroidx/core/app/NotificationCompat$Builder;->mPriority:I

    .line 137
    .line 138
    const-string v0, "VpnReconnectService"

    .line 139
    .line 140
    const-string v1, "running"

    .line 141
    .line 142
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    .line 144
    .line 145
    invoke-virtual {v5}, Landroidx/core/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    .line 146
    .line 147
    .line 148
    move-result-object v0

    .line 149
    return-object v0
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

.method private checkAvailableNetwork(Landroid/net/ConnectivityManager;Landroid/net/Network;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mActiveVpnNetwork:Landroid/net/Network;

    .line 2
    .line 3
    invoke-virtual {p2, v0}, Landroid/net/Network;->equals(Ljava/lang/Object;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    goto :goto_0

    .line 10
    :cond_0
    invoke-virtual {p1, p2}, Landroid/net/ConnectivityManager;->getNetworkCapabilities(Landroid/net/Network;)Landroid/net/NetworkCapabilities;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    if-eqz p1, :cond_1

    .line 15
    .line 16
    const/4 v0, 0x4

    .line 17
    invoke-virtual {p1, v0}, Landroid/net/NetworkCapabilities;->hasTransport(I)Z

    .line 18
    .line 19
    .line 20
    move-result p1

    .line 21
    if-eqz p1, :cond_1

    .line 22
    .line 23
    iput-object p2, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mActiveVpnNetwork:Landroid/net/Network;

    .line 24
    .line 25
    new-instance p1, Ljava/lang/StringBuilder;

    .line 26
    .line 27
    const-string p2, "Detected active VPN network: "

    .line 28
    .line 29
    invoke-direct {p1, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 30
    .line 31
    .line 32
    iget-object p2, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mActiveVpnNetwork:Landroid/net/Network;

    .line 33
    .line 34
    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 35
    .line 36
    .line 37
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object p1

    .line 41
    const-string p2, "VpnReconnectService"

    .line 42
    .line 43
    invoke-static {p2, p1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    .line 45
    .line 46
    iget-object p1, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mHandler:Landroid/os/Handler;

    .line 47
    .line 48
    const/4 p2, 0x0

    .line 49
    invoke-virtual {p1, p2}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 50
    .line 51
    .line 52
    :cond_1
    :goto_0
    return-void
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

.method public static isAvailable()Z
    .locals 2
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ObsoleteSdkInt"
        }
    .end annotation

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 2
    .line 3
    const/16 v1, 0x17

    .line 4
    .line 5
    if-lt v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    return v0

    .line 9
    :cond_0
    const/4 v0, 0x0

    .line 10
    return v0
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

.method private static synthetic lambda$onStartCommand$0()V
    .locals 2

    .line 1
    const-string v0, "VpnReconnectService"

    .line 2
    .line 3
    const-string v1, "Could not detect a VPN within the timeout, automatic reconnection aborted"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->stopService()V

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

.method private registerNetworkCallbacks()Z
    .locals 6

    .line 1
    const-string v0, "VpnReconnectService"

    .line 2
    .line 3
    const-string v1, "connectivity"

    .line 4
    .line 5
    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    check-cast v1, Landroid/net/ConnectivityManager;

    .line 10
    .line 11
    new-instance v2, Lcom/emanuelef/remote_capture/VpnReconnectService$1;

    .line 12
    .line 13
    invoke-direct {v2, p0, v1}, Lcom/emanuelef/remote_capture/VpnReconnectService$1;-><init>(Lcom/emanuelef/remote_capture/VpnReconnectService;Landroid/net/ConnectivityManager;)V

    .line 14
    .line 15
    .line 16
    iput-object v2, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 17
    .line 18
    :try_start_0
    const-string v2, "registerNetworkCallback"

    .line 19
    .line 20
    invoke-static {v0, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 21
    .line 22
    .line 23
    new-instance v2, Landroid/net/NetworkRequest$Builder;

    .line 24
    .line 25
    invoke-direct {v2}, Landroid/net/NetworkRequest$Builder;-><init>()V

    .line 26
    .line 27
    .line 28
    const/16 v3, 0xf

    .line 29
    .line 30
    invoke-virtual {v2, v3}, Landroid/net/NetworkRequest$Builder;->removeCapability(I)Landroid/net/NetworkRequest$Builder;

    .line 31
    .line 32
    .line 33
    move-result-object v2

    .line 34
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 35
    .line 36
    const/16 v4, 0x1f

    .line 37
    .line 38
    const/4 v5, 0x1

    .line 39
    if-lt v3, v4, :cond_0

    .line 40
    .line 41
    invoke-virtual {v2, v5}, Landroid/net/NetworkRequest$Builder;->setIncludeOtherUidNetworks(Z)Landroid/net/NetworkRequest$Builder;

    .line 42
    .line 43
    .line 44
    goto :goto_0

    .line 45
    :catch_0
    move-exception v1

    .line 46
    goto :goto_1

    .line 47
    :cond_0
    :goto_0
    invoke-virtual {v2}, Landroid/net/NetworkRequest$Builder;->build()Landroid/net/NetworkRequest;

    .line 48
    .line 49
    .line 50
    move-result-object v2

    .line 51
    iget-object v3, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 52
    .line 53
    invoke-virtual {v1, v2, v3}, Landroid/net/ConnectivityManager;->registerNetworkCallback(Landroid/net/NetworkRequest;Landroid/net/ConnectivityManager$NetworkCallback;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 54
    .line 55
    .line 56
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Utils;->getRunningVpn(Landroid/content/Context;)Landroid/net/Network;

    .line 57
    .line 58
    .line 59
    move-result-object v0

    .line 60
    if-eqz v0, :cond_1

    .line 61
    .line 62
    invoke-direct {p0, v1, v0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->checkAvailableNetwork(Landroid/net/ConnectivityManager;Landroid/net/Network;)V

    .line 63
    .line 64
    .line 65
    :cond_1
    return v5

    .line 66
    :goto_1
    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 67
    .line 68
    .line 69
    const-string v1, "registerNetworkCallback failed"

    .line 70
    .line 71
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    .line 73
    .line 74
    const/4 v0, 0x0

    .line 75
    iput-object v0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 76
    .line 77
    const/4 v0, 0x0

    .line 78
    return v0
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

.method public static stopService()V
    .locals 4

    .line 1
    const-string v0, "VpnReconnectService"

    .line 2
    .line 3
    const-string v1, "stopService called"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    sget-object v0, Lcom/emanuelef/remote_capture/VpnReconnectService;->INSTANCE:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 9
    .line 10
    if-nez v0, :cond_0

    .line 11
    .line 12
    return-void

    .line 13
    :cond_0
    invoke-direct {v0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->unregisterNetworkCallback()V

    .line 14
    .line 15
    .line 16
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 17
    .line 18
    const/16 v2, 0x18

    .line 19
    .line 20
    const/4 v3, 0x1

    .line 21
    if-lt v1, v2, :cond_1

    .line 22
    .line 23
    invoke-virtual {v0, v3}, Landroid/app/Service;->stopForeground(I)V

    .line 24
    .line 25
    .line 26
    goto :goto_0

    .line 27
    :cond_1
    invoke-virtual {v0, v3}, Landroid/app/Service;->stopForeground(Z)V

    .line 28
    .line 29
    .line 30
    :goto_0
    invoke-virtual {v0}, Landroid/app/Service;->stopSelf()V

    .line 31
    .line 32
    .line 33
    return-void
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

.method private unregisterNetworkCallback()V
    .locals 4

    .line 1
    const-string v0, "VpnReconnectService"

    .line 2
    .line 3
    iget-object v1, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    const-string v1, "connectivity"

    .line 8
    .line 9
    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    check-cast v1, Landroid/net/ConnectivityManager;

    .line 14
    .line 15
    :try_start_0
    const-string v2, "unregisterNetworkCallback"

    .line 16
    .line 17
    invoke-static {v0, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    iget-object v2, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 21
    .line 22
    invoke-virtual {v1, v2}, Landroid/net/ConnectivityManager;->unregisterNetworkCallback(Landroid/net/ConnectivityManager$NetworkCallback;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 23
    .line 24
    .line 25
    goto :goto_0

    .line 26
    :catch_0
    move-exception v1

    .line 27
    new-instance v2, Ljava/lang/StringBuilder;

    .line 28
    .line 29
    const-string v3, "unregisterNetworkCallback failed: "

    .line 30
    .line 31
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 35
    .line 36
    .line 37
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object v1

    .line 41
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    .line 43
    .line 44
    :goto_0
    const/4 v0, 0x0

    .line 45
    iput-object v0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 46
    .line 47
    :cond_0
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


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 0

    const/4 p1, 0x0

    return-object p1
.end method

.method public onCreate()V
    .locals 2

    .line 1
    const-string v0, "VpnReconnectService"

    .line 2
    .line 3
    const-string v1, "onCreate"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    new-instance v0, Landroid/os/Handler;

    .line 9
    .line 10
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 15
    .line 16
    .line 17
    iput-object v0, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mHandler:Landroid/os/Handler;

    .line 18
    .line 19
    sput-object p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->INSTANCE:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 20
    .line 21
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 22
    .line 23
    .line 24
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

.method public onDestroy()V
    .locals 2

    .line 1
    const-string v0, "VpnReconnectService"

    .line 2
    .line 3
    const-string v1, "onDestroy"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->unregisterNetworkCallback()V

    .line 9
    .line 10
    .line 11
    const/4 v0, 0x0

    .line 12
    sput-object v0, Lcom/emanuelef/remote_capture/VpnReconnectService;->INSTANCE:Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 13
    .line 14
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 15
    .line 16
    .line 17
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
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 2

    .line 1
    const-string p2, "VpnReconnectService"

    .line 2
    .line 3
    const-string p3, "onStartCommand"

    .line 4
    .line 5
    invoke-static {p2, p3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 p2, 0x2

    .line 9
    if-eqz p1, :cond_0

    .line 10
    .line 11
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    .line 12
    .line 13
    .line 14
    move-result-object p3

    .line 15
    if-eqz p3, :cond_0

    .line 16
    .line 17
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    const-string p3, "stop"

    .line 22
    .line 23
    invoke-virtual {p1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 24
    .line 25
    .line 26
    move-result p1

    .line 27
    if-eqz p1, :cond_0

    .line 28
    .line 29
    const/4 p1, 0x0

    .line 30
    new-array p1, p1, [Ljava/lang/Object;

    .line 31
    .line 32
    const p3, 0x7f1402ed

    .line 33
    .line 34
    .line 35
    invoke-static {p0, p3, p1}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 36
    .line 37
    .line 38
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->stopService()V

    .line 39
    .line 40
    .line 41
    return p2

    .line 42
    :cond_0
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 43
    .line 44
    const/16 p3, 0x22

    .line 45
    .line 46
    const/16 v0, 0xa

    .line 47
    .line 48
    if-lt p1, p3, :cond_1

    .line 49
    .line 50
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->buildNotification()Landroid/app/Notification;

    .line 51
    .line 52
    .line 53
    move-result-object p1

    .line 54
    const/high16 p3, 0x40000000    # 2.0f

    .line 55
    .line 56
    invoke-virtual {p0, v0, p1, p3}, Landroid/app/Service;->startForeground(ILandroid/app/Notification;I)V

    .line 57
    .line 58
    .line 59
    goto :goto_0

    .line 60
    :cond_1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->buildNotification()Landroid/app/Notification;

    .line 61
    .line 62
    .line 63
    move-result-object p1

    .line 64
    invoke-virtual {p0, v0, p1}, Landroid/app/Service;->startForeground(ILandroid/app/Notification;)V

    .line 65
    .line 66
    .line 67
    :goto_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/VpnReconnectService;->mHandler:Landroid/os/Handler;

    .line 68
    .line 69
    new-instance p3, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;

    .line 70
    .line 71
    const/4 v0, 0x1

    .line 72
    invoke-direct {p3, v0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;-><init>(I)V

    .line 73
    .line 74
    .line 75
    const-wide/16 v0, 0x2710

    .line 76
    .line 77
    invoke-virtual {p1, p3, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 78
    .line 79
    .line 80
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/VpnReconnectService;->registerNetworkCallbacks()Z

    .line 81
    .line 82
    .line 83
    move-result p1

    .line 84
    if-nez p1, :cond_2

    .line 85
    .line 86
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->stopService()V

    .line 87
    .line 88
    .line 89
    return p2

    .line 90
    :cond_2
    const/4 p1, 0x1

    .line 91
    return p1
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
