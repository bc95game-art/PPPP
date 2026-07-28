.class public final Landroidx/core/app/NotificationCompat$Builder;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final mActions:Ljava/util/ArrayList;

.field public final mAllowSystemGeneratedContextualActions:Z

.field public mCategory:Ljava/lang/String;

.field public mChannelId:Ljava/lang/String;

.field public mColor:I

.field public mContentIntent:Landroid/app/PendingIntent;

.field public mContentText:Ljava/lang/CharSequence;

.field public mContentTitle:Ljava/lang/CharSequence;

.field public final mContext:Landroid/content/Context;

.field public mExtras:Landroid/os/Bundle;

.field public final mInvisibleActions:Ljava/util/ArrayList;

.field public mLocalOnly:Z

.field public final mNotification:Landroid/app/Notification;

.field public final mPeople:Ljava/util/ArrayList;

.field public final mPersonList:Ljava/util/ArrayList;

.field public mPriority:I

.field public final mShowWhen:Z

.field public mStyle:Lcom/android/billingclient/api/zzcl;

.field public mVisibility:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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
    iput-object v0, p0, Landroidx/core/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    .line 10
    .line 11
    new-instance v0, Ljava/util/ArrayList;

    .line 12
    .line 13
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 14
    .line 15
    .line 16
    iput-object v0, p0, Landroidx/core/app/NotificationCompat$Builder;->mPersonList:Ljava/util/ArrayList;

    .line 17
    .line 18
    new-instance v0, Ljava/util/ArrayList;

    .line 19
    .line 20
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 21
    .line 22
    .line 23
    iput-object v0, p0, Landroidx/core/app/NotificationCompat$Builder;->mInvisibleActions:Ljava/util/ArrayList;

    .line 24
    .line 25
    const/4 v0, 0x1

    .line 26
    iput-boolean v0, p0, Landroidx/core/app/NotificationCompat$Builder;->mShowWhen:Z

    .line 27
    .line 28
    const/4 v1, 0x0

    .line 29
    iput-boolean v1, p0, Landroidx/core/app/NotificationCompat$Builder;->mLocalOnly:Z

    .line 30
    .line 31
    iput v1, p0, Landroidx/core/app/NotificationCompat$Builder;->mColor:I

    .line 32
    .line 33
    iput v1, p0, Landroidx/core/app/NotificationCompat$Builder;->mVisibility:I

    .line 34
    .line 35
    new-instance v2, Landroid/app/Notification;

    .line 36
    .line 37
    invoke-direct {v2}, Landroid/app/Notification;-><init>()V

    .line 38
    .line 39
    .line 40
    iput-object v2, p0, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 41
    .line 42
    iput-object p1, p0, Landroidx/core/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    .line 43
    .line 44
    iput-object p2, p0, Landroidx/core/app/NotificationCompat$Builder;->mChannelId:Ljava/lang/String;

    .line 45
    .line 46
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 47
    .line 48
    .line 49
    move-result-wide p1

    .line 50
    iput-wide p1, v2, Landroid/app/Notification;->when:J

    .line 51
    .line 52
    const/4 p1, -0x1

    .line 53
    iput p1, v2, Landroid/app/Notification;->audioStreamType:I

    .line 54
    .line 55
    iput v1, p0, Landroidx/core/app/NotificationCompat$Builder;->mPriority:I

    .line 56
    .line 57
    new-instance p1, Ljava/util/ArrayList;

    .line 58
    .line 59
    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    .line 60
    .line 61
    .line 62
    iput-object p1, p0, Landroidx/core/app/NotificationCompat$Builder;->mPeople:Ljava/util/ArrayList;

    .line 63
    .line 64
    iput-boolean v0, p0, Landroidx/core/app/NotificationCompat$Builder;->mAllowSystemGeneratedContextualActions:Z

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

.method public static limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .locals 2

    .line 1
    if-nez p0, :cond_0

    .line 2
    .line 3
    return-object p0

    .line 4
    :cond_0
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    const/16 v1, 0x1400

    .line 9
    .line 10
    if-le v0, v1, :cond_1

    .line 11
    .line 12
    const/4 v0, 0x0

    .line 13
    invoke-interface {p0, v0, v1}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    .line 14
    .line 15
    .line 16
    move-result-object p0

    .line 17
    :cond_1
    return-object p0
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


# virtual methods
.method public final build()Landroid/app/Notification;
    .locals 17

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    new-instance v1, Ljava/util/ArrayList;

    .line 4
    .line 5
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 6
    .line 7
    .line 8
    new-instance v1, Landroid/os/Bundle;

    .line 9
    .line 10
    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 11
    .line 12
    .line 13
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 14
    .line 15
    iget-object v3, v0, Landroidx/core/app/NotificationCompat$Builder;->mContext:Landroid/content/Context;

    .line 16
    .line 17
    const/16 v4, 0x1a

    .line 18
    .line 19
    if-lt v2, v4, :cond_0

    .line 20
    .line 21
    iget-object v5, v0, Landroidx/core/app/NotificationCompat$Builder;->mChannelId:Ljava/lang/String;

    .line 22
    .line 23
    invoke-static {v3, v5}, Landroidx/core/app/NotificationCompatBuilder$Api26Impl;->createBuilder(Landroid/content/Context;Ljava/lang/String;)Landroid/app/Notification$Builder;

    .line 24
    .line 25
    .line 26
    move-result-object v3

    .line 27
    goto :goto_0

    .line 28
    :cond_0
    new-instance v5, Landroid/app/Notification$Builder;

    .line 29
    .line 30
    invoke-direct {v5, v3}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    .line 31
    .line 32
    .line 33
    move-object v3, v5

    .line 34
    :goto_0
    iget-object v5, v0, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 35
    .line 36
    iget-wide v6, v5, Landroid/app/Notification;->when:J

    .line 37
    .line 38
    invoke-virtual {v3, v6, v7}, Landroid/app/Notification$Builder;->setWhen(J)Landroid/app/Notification$Builder;

    .line 39
    .line 40
    .line 41
    move-result-object v6

    .line 42
    iget v7, v5, Landroid/app/Notification;->icon:I

    .line 43
    .line 44
    iget v8, v5, Landroid/app/Notification;->iconLevel:I

    .line 45
    .line 46
    invoke-virtual {v6, v7, v8}, Landroid/app/Notification$Builder;->setSmallIcon(II)Landroid/app/Notification$Builder;

    .line 47
    .line 48
    .line 49
    move-result-object v6

    .line 50
    iget-object v7, v5, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 51
    .line 52
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setContent(Landroid/widget/RemoteViews;)Landroid/app/Notification$Builder;

    .line 53
    .line 54
    .line 55
    move-result-object v6

    .line 56
    iget-object v7, v5, Landroid/app/Notification;->tickerText:Ljava/lang/CharSequence;

    .line 57
    .line 58
    const/4 v8, 0x0

    .line 59
    invoke-virtual {v6, v7, v8}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;Landroid/widget/RemoteViews;)Landroid/app/Notification$Builder;

    .line 60
    .line 61
    .line 62
    move-result-object v6

    .line 63
    iget-object v7, v5, Landroid/app/Notification;->vibrate:[J

    .line 64
    .line 65
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setVibrate([J)Landroid/app/Notification$Builder;

    .line 66
    .line 67
    .line 68
    move-result-object v6

    .line 69
    iget v7, v5, Landroid/app/Notification;->ledARGB:I

    .line 70
    .line 71
    iget v9, v5, Landroid/app/Notification;->ledOnMS:I

    .line 72
    .line 73
    iget v10, v5, Landroid/app/Notification;->ledOffMS:I

    .line 74
    .line 75
    invoke-virtual {v6, v7, v9, v10}, Landroid/app/Notification$Builder;->setLights(III)Landroid/app/Notification$Builder;

    .line 76
    .line 77
    .line 78
    move-result-object v6

    .line 79
    iget v7, v5, Landroid/app/Notification;->flags:I

    .line 80
    .line 81
    and-int/lit8 v7, v7, 0x2

    .line 82
    .line 83
    const/4 v9, 0x1

    .line 84
    const/4 v10, 0x0

    .line 85
    if-eqz v7, :cond_1

    .line 86
    .line 87
    const/4 v7, 0x1

    .line 88
    goto :goto_1

    .line 89
    :cond_1
    const/4 v7, 0x0

    .line 90
    :goto_1
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setOngoing(Z)Landroid/app/Notification$Builder;

    .line 91
    .line 92
    .line 93
    move-result-object v6

    .line 94
    iget v7, v5, Landroid/app/Notification;->flags:I

    .line 95
    .line 96
    and-int/lit8 v7, v7, 0x8

    .line 97
    .line 98
    if-eqz v7, :cond_2

    .line 99
    .line 100
    const/4 v7, 0x1

    .line 101
    goto :goto_2

    .line 102
    :cond_2
    const/4 v7, 0x0

    .line 103
    :goto_2
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setOnlyAlertOnce(Z)Landroid/app/Notification$Builder;

    .line 104
    .line 105
    .line 106
    move-result-object v6

    .line 107
    iget v7, v5, Landroid/app/Notification;->flags:I

    .line 108
    .line 109
    and-int/lit8 v7, v7, 0x10

    .line 110
    .line 111
    if-eqz v7, :cond_3

    .line 112
    .line 113
    const/4 v7, 0x1

    .line 114
    goto :goto_3

    .line 115
    :cond_3
    const/4 v7, 0x0

    .line 116
    :goto_3
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setAutoCancel(Z)Landroid/app/Notification$Builder;

    .line 117
    .line 118
    .line 119
    move-result-object v6

    .line 120
    iget v7, v5, Landroid/app/Notification;->defaults:I

    .line 121
    .line 122
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setDefaults(I)Landroid/app/Notification$Builder;

    .line 123
    .line 124
    .line 125
    move-result-object v6

    .line 126
    iget-object v7, v0, Landroidx/core/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    .line 127
    .line 128
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 129
    .line 130
    .line 131
    move-result-object v6

    .line 132
    iget-object v7, v0, Landroidx/core/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    .line 133
    .line 134
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 135
    .line 136
    .line 137
    move-result-object v6

    .line 138
    invoke-virtual {v6, v8}, Landroid/app/Notification$Builder;->setContentInfo(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 139
    .line 140
    .line 141
    move-result-object v6

    .line 142
    iget-object v7, v0, Landroidx/core/app/NotificationCompat$Builder;->mContentIntent:Landroid/app/PendingIntent;

    .line 143
    .line 144
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    .line 145
    .line 146
    .line 147
    move-result-object v6

    .line 148
    iget-object v7, v5, Landroid/app/Notification;->deleteIntent:Landroid/app/PendingIntent;

    .line 149
    .line 150
    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setDeleteIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    .line 151
    .line 152
    .line 153
    move-result-object v6

    .line 154
    iget v7, v5, Landroid/app/Notification;->flags:I

    .line 155
    .line 156
    and-int/lit16 v7, v7, 0x80

    .line 157
    .line 158
    if-eqz v7, :cond_4

    .line 159
    .line 160
    goto :goto_4

    .line 161
    :cond_4
    const/4 v9, 0x0

    .line 162
    :goto_4
    invoke-virtual {v6, v8, v9}, Landroid/app/Notification$Builder;->setFullScreenIntent(Landroid/app/PendingIntent;Z)Landroid/app/Notification$Builder;

    .line 163
    .line 164
    .line 165
    move-result-object v6

    .line 166
    invoke-virtual {v6, v10}, Landroid/app/Notification$Builder;->setNumber(I)Landroid/app/Notification$Builder;

    .line 167
    .line 168
    .line 169
    move-result-object v6

    .line 170
    invoke-virtual {v6, v10, v10, v10}, Landroid/app/Notification$Builder;->setProgress(IIZ)Landroid/app/Notification$Builder;

    .line 171
    .line 172
    .line 173
    const/16 v6, 0x17

    .line 174
    .line 175
    if-ge v2, v6, :cond_5

    .line 176
    .line 177
    invoke-virtual {v3, v8}, Landroid/app/Notification$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;

    .line 178
    .line 179
    .line 180
    goto :goto_5

    .line 181
    :cond_5
    invoke-static {v3, v8}, Landroidx/core/app/NotificationCompatBuilder$Api23Impl;->setLargeIcon(Landroid/app/Notification$Builder;Landroid/graphics/drawable/Icon;)Landroid/app/Notification$Builder;

    .line 182
    .line 183
    .line 184
    :goto_5
    invoke-virtual {v3, v8}, Landroid/app/Notification$Builder;->setSubText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 185
    .line 186
    .line 187
    move-result-object v2

    .line 188
    invoke-virtual {v2, v10}, Landroid/app/Notification$Builder;->setUsesChronometer(Z)Landroid/app/Notification$Builder;

    .line 189
    .line 190
    .line 191
    move-result-object v2

    .line 192
    iget v7, v0, Landroidx/core/app/NotificationCompat$Builder;->mPriority:I

    .line 193
    .line 194
    invoke-virtual {v2, v7}, Landroid/app/Notification$Builder;->setPriority(I)Landroid/app/Notification$Builder;

    .line 195
    .line 196
    .line 197
    iget-object v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mActions:Ljava/util/ArrayList;

    .line 198
    .line 199
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 200
    .line 201
    .line 202
    move-result v7

    .line 203
    const/4 v9, 0x0

    .line 204
    :goto_6
    const-string v13, "android.support.allowGeneratedReplies"

    .line 205
    .line 206
    if-ge v9, v7, :cond_10

    .line 207
    .line 208
    invoke-virtual {v2, v9}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 209
    .line 210
    .line 211
    move-result-object v15

    .line 212
    add-int/lit8 v9, v9, 0x1

    .line 213
    .line 214
    check-cast v15, Landroidx/core/app/NotificationCompat$Action;

    .line 215
    .line 216
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 217
    .line 218
    iget-object v11, v15, Landroidx/core/app/NotificationCompat$Action;->mIcon:Landroidx/core/graphics/drawable/IconCompat;

    .line 219
    .line 220
    if-nez v11, :cond_6

    .line 221
    .line 222
    iget v11, v15, Landroidx/core/app/NotificationCompat$Action;->icon:I

    .line 223
    .line 224
    if-eqz v11, :cond_6

    .line 225
    .line 226
    invoke-static {v11}, Landroidx/core/graphics/drawable/IconCompat;->createWithResource(I)Landroidx/core/graphics/drawable/IconCompat;

    .line 227
    .line 228
    .line 229
    move-result-object v11

    .line 230
    iput-object v11, v15, Landroidx/core/app/NotificationCompat$Action;->mIcon:Landroidx/core/graphics/drawable/IconCompat;

    .line 231
    .line 232
    :cond_6
    iget-object v11, v15, Landroidx/core/app/NotificationCompat$Action;->mIcon:Landroidx/core/graphics/drawable/IconCompat;

    .line 233
    .line 234
    iget-boolean v14, v15, Landroidx/core/app/NotificationCompat$Action;->mAllowGeneratedReplies:Z

    .line 235
    .line 236
    iget-object v10, v15, Landroidx/core/app/NotificationCompat$Action;->mExtras:Landroid/os/Bundle;

    .line 237
    .line 238
    iget-object v12, v15, Landroidx/core/app/NotificationCompat$Action;->actionIntent:Landroid/app/PendingIntent;

    .line 239
    .line 240
    iget-object v8, v15, Landroidx/core/app/NotificationCompat$Action;->title:Ljava/lang/CharSequence;

    .line 241
    .line 242
    if-lt v4, v6, :cond_9

    .line 243
    .line 244
    if-eqz v11, :cond_8

    .line 245
    .line 246
    if-lt v4, v6, :cond_7

    .line 247
    .line 248
    const/4 v6, 0x0

    .line 249
    invoke-static {v11, v6}, Landroidx/core/graphics/drawable/IconCompat$Api23Impl;->toIcon(Landroidx/core/graphics/drawable/IconCompat;Landroid/content/Context;)Landroid/graphics/drawable/Icon;

    .line 250
    .line 251
    .line 252
    move-result-object v11

    .line 253
    goto :goto_7

    .line 254
    :cond_7
    new-instance v1, Ljava/lang/UnsupportedOperationException;

    .line 255
    .line 256
    const-string v2, "This method is only supported on API level 23+"

    .line 257
    .line 258
    invoke-direct {v1, v2}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    .line 259
    .line 260
    .line 261
    throw v1

    .line 262
    :cond_8
    const/4 v11, 0x0

    .line 263
    :goto_7
    invoke-static {v11, v8, v12}, Landroidx/core/app/NotificationCompatBuilder$Api23Impl;->createBuilder(Landroid/graphics/drawable/Icon;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Action$Builder;

    .line 264
    .line 265
    .line 266
    move-result-object v6

    .line 267
    goto :goto_9

    .line 268
    :cond_9
    if-eqz v11, :cond_a

    .line 269
    .line 270
    invoke-virtual {v11}, Landroidx/core/graphics/drawable/IconCompat;->getResId()I

    .line 271
    .line 272
    .line 273
    move-result v6

    .line 274
    goto :goto_8

    .line 275
    :cond_a
    const/4 v6, 0x0

    .line 276
    :goto_8
    invoke-static {v6, v8, v12}, Landroidx/core/app/NotificationCompatBuilder$Api20Impl;->createBuilder(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)Landroid/app/Notification$Action$Builder;

    .line 277
    .line 278
    .line 279
    move-result-object v6

    .line 280
    :goto_9
    if-eqz v10, :cond_b

    .line 281
    .line 282
    new-instance v8, Landroid/os/Bundle;

    .line 283
    .line 284
    invoke-direct {v8, v10}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 285
    .line 286
    .line 287
    goto :goto_a

    .line 288
    :cond_b
    new-instance v8, Landroid/os/Bundle;

    .line 289
    .line 290
    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    .line 291
    .line 292
    .line 293
    :goto_a
    invoke-virtual {v8, v13, v14}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 294
    .line 295
    .line 296
    const/16 v10, 0x18

    .line 297
    .line 298
    if-lt v4, v10, :cond_c

    .line 299
    .line 300
    invoke-static {v6, v14}, Landroidx/core/app/NotificationCompatBuilder$Api24Impl;->setAllowGeneratedReplies(Landroid/app/Notification$Action$Builder;Z)Landroid/app/Notification$Action$Builder;

    .line 301
    .line 302
    .line 303
    :cond_c
    const-string v10, "android.support.action.semanticAction"

    .line 304
    .line 305
    const/4 v11, 0x0

    .line 306
    invoke-virtual {v8, v10, v11}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    .line 307
    .line 308
    .line 309
    const/16 v10, 0x1c

    .line 310
    .line 311
    if-lt v4, v10, :cond_d

    .line 312
    .line 313
    invoke-static {v6, v11}, Landroidx/core/app/NotificationCompatBuilder$Api28Impl;->setSemanticAction(Landroid/app/Notification$Action$Builder;I)Landroid/app/Notification$Action$Builder;

    .line 314
    .line 315
    .line 316
    :cond_d
    const/16 v10, 0x1d

    .line 317
    .line 318
    if-lt v4, v10, :cond_e

    .line 319
    .line 320
    invoke-static {v6, v11}, Landroidx/core/app/NotificationCompatBuilder$Api29Impl;->setContextual(Landroid/app/Notification$Action$Builder;Z)Landroid/app/Notification$Action$Builder;

    .line 321
    .line 322
    .line 323
    :cond_e
    const/16 v10, 0x1f

    .line 324
    .line 325
    if-lt v4, v10, :cond_f

    .line 326
    .line 327
    invoke-static {v6, v11}, Landroidx/core/app/NotificationCompatBuilder$Api31Impl;->setAuthenticationRequired(Landroid/app/Notification$Action$Builder;Z)Landroid/app/Notification$Action$Builder;

    .line 328
    .line 329
    .line 330
    :cond_f
    const-string v4, "android.support.action.showsUserInterface"

    .line 331
    .line 332
    iget-boolean v10, v15, Landroidx/core/app/NotificationCompat$Action;->mShowsUserInterface:Z

    .line 333
    .line 334
    invoke-virtual {v8, v4, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 335
    .line 336
    .line 337
    invoke-static {v6, v8}, Landroidx/core/app/NotificationCompatBuilder$Api20Impl;->addExtras(Landroid/app/Notification$Action$Builder;Landroid/os/Bundle;)Landroid/app/Notification$Action$Builder;

    .line 338
    .line 339
    .line 340
    invoke-static {v6}, Landroidx/core/app/NotificationCompatBuilder$Api20Impl;->build(Landroid/app/Notification$Action$Builder;)Landroid/app/Notification$Action;

    .line 341
    .line 342
    .line 343
    move-result-object v4

    .line 344
    invoke-static {v3, v4}, Landroidx/core/app/NotificationCompatBuilder$Api20Impl;->addAction(Landroid/app/Notification$Builder;Landroid/app/Notification$Action;)Landroid/app/Notification$Builder;

    .line 345
    .line 346
    .line 347
    const/16 v4, 0x1a

    .line 348
    .line 349
    const/16 v6, 0x17

    .line 350
    .line 351
    const/4 v8, 0x0

    .line 352
    const/4 v10, 0x0

    .line 353
    goto/16 :goto_6

    .line 354
    .line 355
    :cond_10
    iget-object v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mExtras:Landroid/os/Bundle;

    .line 356
    .line 357
    if-eqz v2, :cond_11

    .line 358
    .line 359
    invoke-virtual {v1, v2}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 360
    .line 361
    .line 362
    :cond_11
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 363
    .line 364
    iget-boolean v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mShowWhen:Z

    .line 365
    .line 366
    invoke-virtual {v3, v4}, Landroid/app/Notification$Builder;->setShowWhen(Z)Landroid/app/Notification$Builder;

    .line 367
    .line 368
    .line 369
    iget-boolean v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mLocalOnly:Z

    .line 370
    .line 371
    invoke-static {v3, v4}, Landroidx/core/app/NotificationCompatBuilder$Api20Impl;->setLocalOnly(Landroid/app/Notification$Builder;Z)Landroid/app/Notification$Builder;

    .line 372
    .line 373
    .line 374
    const/4 v6, 0x0

    .line 375
    invoke-static {v3, v6}, Landroidx/core/app/NotificationCompatBuilder$Api20Impl;->setGroup(Landroid/app/Notification$Builder;Ljava/lang/String;)Landroid/app/Notification$Builder;

    .line 376
    .line 377
    .line 378
    invoke-static {v3, v6}, Landroidx/core/app/NotificationCompatBuilder$Api20Impl;->setSortKey(Landroid/app/Notification$Builder;Ljava/lang/String;)Landroid/app/Notification$Builder;

    .line 379
    .line 380
    .line 381
    const/4 v11, 0x0

    .line 382
    invoke-static {v3, v11}, Landroidx/core/app/NotificationCompatBuilder$Api20Impl;->setGroupSummary(Landroid/app/Notification$Builder;Z)Landroid/app/Notification$Builder;

    .line 383
    .line 384
    .line 385
    iget-object v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mCategory:Ljava/lang/String;

    .line 386
    .line 387
    invoke-static {v3, v4}, Landroidx/core/app/NotificationCompatBuilder$Api21Impl;->setCategory(Landroid/app/Notification$Builder;Ljava/lang/String;)Landroid/app/Notification$Builder;

    .line 388
    .line 389
    .line 390
    iget v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mColor:I

    .line 391
    .line 392
    invoke-static {v3, v4}, Landroidx/core/app/NotificationCompatBuilder$Api21Impl;->setColor(Landroid/app/Notification$Builder;I)Landroid/app/Notification$Builder;

    .line 393
    .line 394
    .line 395
    iget v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mVisibility:I

    .line 396
    .line 397
    invoke-static {v3, v4}, Landroidx/core/app/NotificationCompatBuilder$Api21Impl;->setVisibility(Landroid/app/Notification$Builder;I)Landroid/app/Notification$Builder;

    .line 398
    .line 399
    .line 400
    invoke-static {v3, v6}, Landroidx/core/app/NotificationCompatBuilder$Api21Impl;->setPublicVersion(Landroid/app/Notification$Builder;Landroid/app/Notification;)Landroid/app/Notification$Builder;

    .line 401
    .line 402
    .line 403
    iget-object v4, v5, Landroid/app/Notification;->sound:Landroid/net/Uri;

    .line 404
    .line 405
    iget-object v5, v5, Landroid/app/Notification;->audioAttributes:Landroid/media/AudioAttributes;

    .line 406
    .line 407
    invoke-static {v3, v4, v5}, Landroidx/core/app/NotificationCompatBuilder$Api21Impl;->setSound(Landroid/app/Notification$Builder;Landroid/net/Uri;Ljava/lang/Object;)Landroid/app/Notification$Builder;

    .line 408
    .line 409
    .line 410
    iget-object v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mPeople:Ljava/util/ArrayList;

    .line 411
    .line 412
    iget-object v5, v0, Landroidx/core/app/NotificationCompat$Builder;->mPersonList:Ljava/util/ArrayList;

    .line 413
    .line 414
    const/16 v10, 0x1c

    .line 415
    .line 416
    if-ge v2, v10, :cond_16

    .line 417
    .line 418
    if-nez v5, :cond_12

    .line 419
    .line 420
    const/4 v2, 0x0

    .line 421
    goto :goto_b

    .line 422
    :cond_12
    new-instance v2, Ljava/util/ArrayList;

    .line 423
    .line 424
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    .line 425
    .line 426
    .line 427
    move-result v6

    .line 428
    invoke-direct {v2, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 429
    .line 430
    .line 431
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 432
    .line 433
    .line 434
    move-result-object v6

    .line 435
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    .line 436
    .line 437
    .line 438
    move-result v7

    .line 439
    if-nez v7, :cond_15

    .line 440
    .line 441
    :goto_b
    if-nez v2, :cond_13

    .line 442
    .line 443
    goto :goto_c

    .line 444
    :cond_13
    if-nez v4, :cond_14

    .line 445
    .line 446
    move-object v4, v2

    .line 447
    goto :goto_c

    .line 448
    :cond_14
    new-instance v6, Landroidx/collection/ArraySet;

    .line 449
    .line 450
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 451
    .line 452
    .line 453
    move-result v7

    .line 454
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    .line 455
    .line 456
    .line 457
    move-result v8

    .line 458
    add-int/2addr v8, v7

    .line 459
    invoke-direct {v6, v8}, Landroidx/collection/ArraySet;-><init>(I)V

    .line 460
    .line 461
    .line 462
    invoke-virtual {v6, v2}, Landroidx/collection/ArraySet;->addAll(Ljava/util/Collection;)Z

    .line 463
    .line 464
    .line 465
    invoke-virtual {v6, v4}, Landroidx/collection/ArraySet;->addAll(Ljava/util/Collection;)Z

    .line 466
    .line 467
    .line 468
    new-instance v4, Ljava/util/ArrayList;

    .line 469
    .line 470
    invoke-direct {v4, v6}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 471
    .line 472
    .line 473
    goto :goto_c

    .line 474
    :cond_15
    invoke-static {v6}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/util/Iterator;)Ljava/lang/ClassCastException;

    .line 475
    .line 476
    .line 477
    move-result-object v1

    .line 478
    throw v1

    .line 479
    :cond_16
    :goto_c
    if-eqz v4, :cond_17

    .line 480
    .line 481
    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    .line 482
    .line 483
    .line 484
    move-result v2

    .line 485
    if-nez v2, :cond_17

    .line 486
    .line 487
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    .line 488
    .line 489
    .line 490
    move-result v2

    .line 491
    const/4 v6, 0x0

    .line 492
    :goto_d
    if-ge v6, v2, :cond_17

    .line 493
    .line 494
    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 495
    .line 496
    .line 497
    move-result-object v7

    .line 498
    add-int/lit8 v6, v6, 0x1

    .line 499
    .line 500
    check-cast v7, Ljava/lang/String;

    .line 501
    .line 502
    invoke-static {v3, v7}, Landroidx/core/app/NotificationCompatBuilder$Api21Impl;->addPerson(Landroid/app/Notification$Builder;Ljava/lang/String;)Landroid/app/Notification$Builder;

    .line 503
    .line 504
    .line 505
    goto :goto_d

    .line 506
    :cond_17
    iget-object v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mInvisibleActions:Ljava/util/ArrayList;

    .line 507
    .line 508
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 509
    .line 510
    .line 511
    move-result v4

    .line 512
    if-lez v4, :cond_1f

    .line 513
    .line 514
    iget-object v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mExtras:Landroid/os/Bundle;

    .line 515
    .line 516
    if-nez v4, :cond_18

    .line 517
    .line 518
    new-instance v4, Landroid/os/Bundle;

    .line 519
    .line 520
    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 521
    .line 522
    .line 523
    iput-object v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mExtras:Landroid/os/Bundle;

    .line 524
    .line 525
    :cond_18
    iget-object v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mExtras:Landroid/os/Bundle;

    .line 526
    .line 527
    const-string v6, "android.car.EXTENSIONS"

    .line 528
    .line 529
    invoke-virtual {v4, v6}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    .line 530
    .line 531
    .line 532
    move-result-object v4

    .line 533
    if-nez v4, :cond_19

    .line 534
    .line 535
    new-instance v4, Landroid/os/Bundle;

    .line 536
    .line 537
    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 538
    .line 539
    .line 540
    :cond_19
    new-instance v7, Landroid/os/Bundle;

    .line 541
    .line 542
    invoke-direct {v7, v4}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 543
    .line 544
    .line 545
    new-instance v8, Landroid/os/Bundle;

    .line 546
    .line 547
    invoke-direct {v8}, Landroid/os/Bundle;-><init>()V

    .line 548
    .line 549
    .line 550
    const/4 v11, 0x0

    .line 551
    :goto_e
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 552
    .line 553
    .line 554
    move-result v9

    .line 555
    if-ge v11, v9, :cond_1d

    .line 556
    .line 557
    invoke-static {v11}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    .line 558
    .line 559
    .line 560
    move-result-object v9

    .line 561
    invoke-virtual {v2, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 562
    .line 563
    .line 564
    move-result-object v10

    .line 565
    check-cast v10, Landroidx/core/app/NotificationCompat$Action;

    .line 566
    .line 567
    new-instance v12, Landroid/os/Bundle;

    .line 568
    .line 569
    invoke-direct {v12}, Landroid/os/Bundle;-><init>()V

    .line 570
    .line 571
    .line 572
    iget-object v14, v10, Landroidx/core/app/NotificationCompat$Action;->mIcon:Landroidx/core/graphics/drawable/IconCompat;

    .line 573
    .line 574
    if-nez v14, :cond_1a

    .line 575
    .line 576
    iget v14, v10, Landroidx/core/app/NotificationCompat$Action;->icon:I

    .line 577
    .line 578
    if-eqz v14, :cond_1a

    .line 579
    .line 580
    invoke-static {v14}, Landroidx/core/graphics/drawable/IconCompat;->createWithResource(I)Landroidx/core/graphics/drawable/IconCompat;

    .line 581
    .line 582
    .line 583
    move-result-object v14

    .line 584
    iput-object v14, v10, Landroidx/core/app/NotificationCompat$Action;->mIcon:Landroidx/core/graphics/drawable/IconCompat;

    .line 585
    .line 586
    :cond_1a
    iget-object v14, v10, Landroidx/core/app/NotificationCompat$Action;->mIcon:Landroidx/core/graphics/drawable/IconCompat;

    .line 587
    .line 588
    iget-object v15, v10, Landroidx/core/app/NotificationCompat$Action;->mExtras:Landroid/os/Bundle;

    .line 589
    .line 590
    if-eqz v14, :cond_1b

    .line 591
    .line 592
    invoke-virtual {v14}, Landroidx/core/graphics/drawable/IconCompat;->getResId()I

    .line 593
    .line 594
    .line 595
    move-result v14

    .line 596
    :goto_f
    move-object/from16 v16, v2

    .line 597
    .line 598
    goto :goto_10

    .line 599
    :cond_1b
    const/4 v14, 0x0

    .line 600
    goto :goto_f

    .line 601
    :goto_10
    const-string v2, "icon"

    .line 602
    .line 603
    invoke-virtual {v12, v2, v14}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    .line 604
    .line 605
    .line 606
    const-string v2, "title"

    .line 607
    .line 608
    iget-object v14, v10, Landroidx/core/app/NotificationCompat$Action;->title:Ljava/lang/CharSequence;

    .line 609
    .line 610
    invoke-virtual {v12, v2, v14}, Landroid/os/Bundle;->putCharSequence(Ljava/lang/String;Ljava/lang/CharSequence;)V

    .line 611
    .line 612
    .line 613
    const-string v2, "actionIntent"

    .line 614
    .line 615
    iget-object v14, v10, Landroidx/core/app/NotificationCompat$Action;->actionIntent:Landroid/app/PendingIntent;

    .line 616
    .line 617
    invoke-virtual {v12, v2, v14}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 618
    .line 619
    .line 620
    if-eqz v15, :cond_1c

    .line 621
    .line 622
    new-instance v2, Landroid/os/Bundle;

    .line 623
    .line 624
    invoke-direct {v2, v15}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 625
    .line 626
    .line 627
    goto :goto_11

    .line 628
    :cond_1c
    new-instance v2, Landroid/os/Bundle;

    .line 629
    .line 630
    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 631
    .line 632
    .line 633
    :goto_11
    iget-boolean v14, v10, Landroidx/core/app/NotificationCompat$Action;->mAllowGeneratedReplies:Z

    .line 634
    .line 635
    invoke-virtual {v2, v13, v14}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 636
    .line 637
    .line 638
    const-string v14, "extras"

    .line 639
    .line 640
    invoke-virtual {v12, v14, v2}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 641
    .line 642
    .line 643
    const-string v2, "remoteInputs"

    .line 644
    .line 645
    const/4 v14, 0x0

    .line 646
    invoke-virtual {v12, v2, v14}, Landroid/os/Bundle;->putParcelableArray(Ljava/lang/String;[Landroid/os/Parcelable;)V

    .line 647
    .line 648
    .line 649
    const-string v2, "showsUserInterface"

    .line 650
    .line 651
    iget-boolean v10, v10, Landroidx/core/app/NotificationCompat$Action;->mShowsUserInterface:Z

    .line 652
    .line 653
    invoke-virtual {v12, v2, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 654
    .line 655
    .line 656
    const-string v2, "semanticAction"

    .line 657
    .line 658
    const/4 v10, 0x0

    .line 659
    invoke-virtual {v12, v2, v10}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    .line 660
    .line 661
    .line 662
    invoke-virtual {v8, v9, v12}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 663
    .line 664
    .line 665
    add-int/lit8 v11, v11, 0x1

    .line 666
    .line 667
    move-object/from16 v2, v16

    .line 668
    .line 669
    goto :goto_e

    .line 670
    :cond_1d
    const-string v2, "invisible_actions"

    .line 671
    .line 672
    invoke-virtual {v4, v2, v8}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 673
    .line 674
    .line 675
    invoke-virtual {v7, v2, v8}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 676
    .line 677
    .line 678
    iget-object v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mExtras:Landroid/os/Bundle;

    .line 679
    .line 680
    if-nez v2, :cond_1e

    .line 681
    .line 682
    new-instance v2, Landroid/os/Bundle;

    .line 683
    .line 684
    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 685
    .line 686
    .line 687
    iput-object v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mExtras:Landroid/os/Bundle;

    .line 688
    .line 689
    :cond_1e
    iget-object v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mExtras:Landroid/os/Bundle;

    .line 690
    .line 691
    invoke-virtual {v2, v6, v4}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 692
    .line 693
    .line 694
    invoke-virtual {v1, v6, v7}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 695
    .line 696
    .line 697
    :cond_1f
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 698
    .line 699
    const/16 v10, 0x18

    .line 700
    .line 701
    if-lt v2, v10, :cond_20

    .line 702
    .line 703
    iget-object v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mExtras:Landroid/os/Bundle;

    .line 704
    .line 705
    invoke-virtual {v3, v4}, Landroid/app/Notification$Builder;->setExtras(Landroid/os/Bundle;)Landroid/app/Notification$Builder;

    .line 706
    .line 707
    .line 708
    const/4 v6, 0x0

    .line 709
    invoke-static {v3, v6}, Landroidx/core/app/NotificationCompatBuilder$Api24Impl;->setRemoteInputHistory(Landroid/app/Notification$Builder;[Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 710
    .line 711
    .line 712
    :goto_12
    const/16 v4, 0x1a

    .line 713
    .line 714
    goto :goto_13

    .line 715
    :cond_20
    const/4 v6, 0x0

    .line 716
    goto :goto_12

    .line 717
    :goto_13
    if-lt v2, v4, :cond_21

    .line 718
    .line 719
    const/4 v11, 0x0

    .line 720
    invoke-static {v3, v11}, Landroidx/core/app/NotificationCompatBuilder$Api26Impl;->setBadgeIconType(Landroid/app/Notification$Builder;I)Landroid/app/Notification$Builder;

    .line 721
    .line 722
    .line 723
    invoke-static {v3, v6}, Landroidx/core/app/NotificationCompatBuilder$Api26Impl;->setSettingsText(Landroid/app/Notification$Builder;Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    .line 724
    .line 725
    .line 726
    invoke-static {v3, v6}, Landroidx/core/app/NotificationCompatBuilder$Api26Impl;->setShortcutId(Landroid/app/Notification$Builder;Ljava/lang/String;)Landroid/app/Notification$Builder;

    .line 727
    .line 728
    .line 729
    const-wide/16 v7, 0x0

    .line 730
    .line 731
    invoke-static {v3, v7, v8}, Landroidx/core/app/NotificationCompatBuilder$Api26Impl;->setTimeoutAfter(Landroid/app/Notification$Builder;J)Landroid/app/Notification$Builder;

    .line 732
    .line 733
    .line 734
    invoke-static {v3, v11}, Landroidx/core/app/NotificationCompatBuilder$Api26Impl;->setGroupAlertBehavior(Landroid/app/Notification$Builder;I)Landroid/app/Notification$Builder;

    .line 735
    .line 736
    .line 737
    iget-object v4, v0, Landroidx/core/app/NotificationCompat$Builder;->mChannelId:Ljava/lang/String;

    .line 738
    .line 739
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    .line 740
    .line 741
    .line 742
    move-result v4

    .line 743
    if-nez v4, :cond_21

    .line 744
    .line 745
    invoke-virtual {v3, v6}, Landroid/app/Notification$Builder;->setSound(Landroid/net/Uri;)Landroid/app/Notification$Builder;

    .line 746
    .line 747
    .line 748
    move-result-object v4

    .line 749
    invoke-virtual {v4, v11}, Landroid/app/Notification$Builder;->setDefaults(I)Landroid/app/Notification$Builder;

    .line 750
    .line 751
    .line 752
    move-result-object v4

    .line 753
    invoke-virtual {v4, v11, v11, v11}, Landroid/app/Notification$Builder;->setLights(III)Landroid/app/Notification$Builder;

    .line 754
    .line 755
    .line 756
    move-result-object v4

    .line 757
    invoke-virtual {v4, v6}, Landroid/app/Notification$Builder;->setVibrate([J)Landroid/app/Notification$Builder;

    .line 758
    .line 759
    .line 760
    :cond_21
    const/16 v10, 0x1c

    .line 761
    .line 762
    if-lt v2, v10, :cond_22

    .line 763
    .line 764
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    .line 765
    .line 766
    .line 767
    move-result-object v4

    .line 768
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    .line 769
    .line 770
    .line 771
    move-result v5

    .line 772
    if-nez v5, :cond_23

    .line 773
    .line 774
    :cond_22
    const/16 v10, 0x1d

    .line 775
    .line 776
    goto :goto_14

    .line 777
    :cond_23
    invoke-static {v4}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/util/Iterator;)Ljava/lang/ClassCastException;

    .line 778
    .line 779
    .line 780
    move-result-object v1

    .line 781
    throw v1

    .line 782
    :goto_14
    if-lt v2, v10, :cond_24

    .line 783
    .line 784
    iget-boolean v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mAllowSystemGeneratedContextualActions:Z

    .line 785
    .line 786
    invoke-static {v3, v2}, Landroidx/core/app/NotificationCompatBuilder$Api29Impl;->setAllowSystemGeneratedContextualActions(Landroid/app/Notification$Builder;Z)Landroid/app/Notification$Builder;

    .line 787
    .line 788
    .line 789
    const/4 v6, 0x0

    .line 790
    invoke-static {v3, v6}, Landroidx/core/app/NotificationCompatBuilder$Api29Impl;->setBubbleMetadata(Landroid/app/Notification$Builder;Landroid/app/Notification$BubbleMetadata;)Landroid/app/Notification$Builder;

    .line 791
    .line 792
    .line 793
    goto :goto_15

    .line 794
    :cond_24
    const/4 v6, 0x0

    .line 795
    :goto_15
    iget-object v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mStyle:Lcom/android/billingclient/api/zzcl;

    .line 796
    .line 797
    if-eqz v2, :cond_25

    .line 798
    .line 799
    new-instance v4, Landroid/app/Notification$BigTextStyle;

    .line 800
    .line 801
    invoke-direct {v4, v3}, Landroid/app/Notification$BigTextStyle;-><init>(Landroid/app/Notification$Builder;)V

    .line 802
    .line 803
    .line 804
    invoke-virtual {v4, v6}, Landroid/app/Notification$BigTextStyle;->setBigContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;

    .line 805
    .line 806
    .line 807
    move-result-object v4

    .line 808
    iget-object v5, v2, Lcom/android/billingclient/api/zzcl;->zzc:Ljava/lang/Object;

    .line 809
    .line 810
    check-cast v5, Ljava/lang/CharSequence;

    .line 811
    .line 812
    invoke-virtual {v4, v5}, Landroid/app/Notification$BigTextStyle;->bigText(Ljava/lang/CharSequence;)Landroid/app/Notification$BigTextStyle;

    .line 813
    .line 814
    .line 815
    :cond_25
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 816
    .line 817
    const/16 v5, 0x1a

    .line 818
    .line 819
    if-lt v4, v5, :cond_26

    .line 820
    .line 821
    invoke-virtual {v3}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    .line 822
    .line 823
    .line 824
    move-result-object v1

    .line 825
    goto :goto_16

    .line 826
    :cond_26
    const/16 v10, 0x18

    .line 827
    .line 828
    if-lt v4, v10, :cond_27

    .line 829
    .line 830
    invoke-virtual {v3}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    .line 831
    .line 832
    .line 833
    move-result-object v1

    .line 834
    goto :goto_16

    .line 835
    :cond_27
    invoke-virtual {v3, v1}, Landroid/app/Notification$Builder;->setExtras(Landroid/os/Bundle;)Landroid/app/Notification$Builder;

    .line 836
    .line 837
    .line 838
    invoke-virtual {v3}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    .line 839
    .line 840
    .line 841
    move-result-object v1

    .line 842
    :goto_16
    if-eqz v2, :cond_28

    .line 843
    .line 844
    iget-object v3, v0, Landroidx/core/app/NotificationCompat$Builder;->mStyle:Lcom/android/billingclient/api/zzcl;

    .line 845
    .line 846
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 847
    .line 848
    .line 849
    :cond_28
    if-eqz v2, :cond_29

    .line 850
    .line 851
    iget-object v2, v1, Landroid/app/Notification;->extras:Landroid/os/Bundle;

    .line 852
    .line 853
    if-eqz v2, :cond_29

    .line 854
    .line 855
    const-string v3, "androidx.core.app.NotificationCompat$BigTextStyle"

    .line 856
    .line 857
    const-string v4, "androidx.core.app.extra.COMPAT_TEMPLATE"

    .line 858
    .line 859
    invoke-virtual {v2, v4, v3}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 860
    .line 861
    .line 862
    :cond_29
    return-object v1
    .line 863
    .line 864
    .line 865
    .line 866
    .line 867
    .line 868
    .line 869
    .line 870
    .line 871
    .line 872
    .line 873
    .line 874
    .line 875
    .line 876
    .line 877
    .line 878
    .line 879
    .line 880
    .line 881
    .line 882
    .line 883
    .line 884
    .line 885
    .line 886
    .line 887
    .line 888
    .line 889
    .line 890
    .line 891
    .line 892
    .line 893
    .line 894
    .line 895
    .line 896
    .line 897
    .line 898
    .line 899
    .line 900
    .line 901
    .line 902
    .line 903
    .line 904
    .line 905
    .line 906
    .line 907
    .line 908
    .line 909
    .line 910
    .line 911
    .line 912
    .line 913
    .line 914
    .line 915
    .line 916
    .line 917
    .line 918
    .line 919
    .line 920
    .line 921
    .line 922
    .line 923
    .line 924
    .line 925
    .line 926
    .line 927
    .line 928
    .line 929
    .line 930
    .line 931
    .line 932
    .line 933
    .line 934
    .line 935
    .line 936
    .line 937
    .line 938
    .line 939
    .line 940
    .line 941
    .line 942
    .line 943
    .line 944
    .line 945
    .line 946
    .line 947
    .line 948
    .line 949
    .line 950
    .line 951
    .line 952
    .line 953
    .line 954
    .line 955
    .line 956
    .line 957
    .line 958
    .line 959
    .line 960
    .line 961
    .line 962
    .line 963
    .line 964
    .line 965
    .line 966
    .line 967
    .line 968
    .line 969
    .line 970
    .line 971
    .line 972
    .line 973
    .line 974
    .line 975
    .line 976
    .line 977
    .line 978
    .line 979
    .line 980
    .line 981
    .line 982
    .line 983
    .line 984
    .line 985
    .line 986
    .line 987
    .line 988
    .line 989
    .line 990
    .line 991
    .line 992
    .line 993
    .line 994
    .line 995
    .line 996
    .line 997
    .line 998
    .line 999
    .line 1000
    .line 1001
    .line 1002
    .line 1003
    .line 1004
    .line 1005
    .line 1006
    .line 1007
    .line 1008
    .line 1009
    .line 1010
    .line 1011
    .line 1012
    .line 1013
    .line 1014
    .line 1015
    .line 1016
    .line 1017
    .line 1018
    .line 1019
    .line 1020
    .line 1021
    .line 1022
    .line 1023
    .line 1024
    .line 1025
    .line 1026
    .line 1027
    .line 1028
    .line 1029
    .line 1030
    .line 1031
    .line 1032
    .line 1033
    .line 1034
    .line 1035
    .line 1036
    .line 1037
    .line 1038
    .line 1039
    .line 1040
    .line 1041
    .line 1042
    .line 1043
    .line 1044
    .line 1045
    .line 1046
    .line 1047
    .line 1048
    .line 1049
    .line 1050
    .line 1051
    .line 1052
    .line 1053
    .line 1054
    .line 1055
    .line 1056
    .line 1057
    .line 1058
    .line 1059
    .line 1060
    .line 1061
    .line 1062
    .line 1063
    .line 1064
    .line 1065
    .line 1066
    .line 1067
    .line 1068
    .line 1069
    .line 1070
    .line 1071
    .line 1072
    .line 1073
    .line 1074
    .line 1075
    .line 1076
    .line 1077
    .line 1078
    .line 1079
    .line 1080
    .line 1081
    .line 1082
    .line 1083
    .line 1084
    .line 1085
    .line 1086
    .line 1087
    .line 1088
    .line 1089
    .line 1090
    .line 1091
    .line 1092
    .line 1093
    .line 1094
    .line 1095
    .line 1096
    .line 1097
    .line 1098
    .line 1099
    .line 1100
    .line 1101
    .line 1102
    .line 1103
    .line 1104
    .line 1105
    .line 1106
    .line 1107
    .line 1108
    .line 1109
    .line 1110
    .line 1111
    .line 1112
    .line 1113
    .line 1114
    .line 1115
    .line 1116
    .line 1117
    .line 1118
    .line 1119
    .line 1120
    .line 1121
    .line 1122
    .line 1123
    .line 1124
    .line 1125
    .line 1126
    .line 1127
    .line 1128
    .line 1129
    .line 1130
    .line 1131
    .line 1132
    .line 1133
    .line 1134
    .line 1135
    .line 1136
    .line 1137
    .line 1138
    .line 1139
    .line 1140
    .line 1141
    .line 1142
    .line 1143
    .line 1144
    .line 1145
    .line 1146
    .line 1147
    .line 1148
    .line 1149
    .line 1150
    .line 1151
    .line 1152
    .line 1153
    .line 1154
    .line 1155
    .line 1156
    .line 1157
    .line 1158
    .line 1159
    .line 1160
    .line 1161
    .line 1162
    .line 1163
    .line 1164
    .line 1165
    .line 1166
    .line 1167
    .line 1168
    .line 1169
    .line 1170
    .line 1171
    .line 1172
    .line 1173
    .line 1174
    .line 1175
    .line 1176
    .line 1177
    .line 1178
    .line 1179
    .line 1180
    .line 1181
    .line 1182
    .line 1183
    .line 1184
    .line 1185
    .line 1186
    .line 1187
    .line 1188
    .line 1189
    .line 1190
    .line 1191
    .line 1192
    .line 1193
    .line 1194
    .line 1195
    .line 1196
    .line 1197
    .line 1198
    .line 1199
    .line 1200
    .line 1201
    .line 1202
    .line 1203
    .line 1204
    .line 1205
    .line 1206
    .line 1207
    .line 1208
    .line 1209
    .line 1210
    .line 1211
    .line 1212
    .line 1213
    .line 1214
    .line 1215
    .line 1216
    .line 1217
    .line 1218
    .line 1219
    .line 1220
    .line 1221
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

.method public final setFlag(IZ)V
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 2
    .line 3
    if-eqz p2, :cond_0

    .line 4
    .line 5
    iget p2, v0, Landroid/app/Notification;->flags:I

    .line 6
    .line 7
    or-int/2addr p1, p2

    .line 8
    iput p1, v0, Landroid/app/Notification;->flags:I

    .line 9
    .line 10
    return-void

    .line 11
    :cond_0
    iget p2, v0, Landroid/app/Notification;->flags:I

    .line 12
    .line 13
    not-int p1, p1

    .line 14
    and-int/2addr p1, p2

    .line 15
    iput p1, v0, Landroid/app/Notification;->flags:I

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

.method public final setStyle(Lcom/android/billingclient/api/zzcl;)V
    .locals 1

    .line 1
    iget-object v0, p0, Landroidx/core/app/NotificationCompat$Builder;->mStyle:Lcom/android/billingclient/api/zzcl;

    .line 2
    .line 3
    if-eq v0, p1, :cond_0

    .line 4
    .line 5
    iput-object p1, p0, Landroidx/core/app/NotificationCompat$Builder;->mStyle:Lcom/android/billingclient/api/zzcl;

    .line 6
    .line 7
    iget-object v0, p1, Lcom/android/billingclient/api/zzcl;->zzb:Ljava/lang/Object;

    .line 8
    .line 9
    check-cast v0, Landroidx/core/app/NotificationCompat$Builder;

    .line 10
    .line 11
    if-eq v0, p0, :cond_0

    .line 12
    .line 13
    iput-object p0, p1, Lcom/android/billingclient/api/zzcl;->zzb:Ljava/lang/Object;

    .line 14
    .line 15
    invoke-virtual {p0, p1}, Landroidx/core/app/NotificationCompat$Builder;->setStyle(Lcom/android/billingclient/api/zzcl;)V

    .line 16
    .line 17
    .line 18
    :cond_0
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
.end method
