.class public Lcom/emanuelef/remote_capture/AppsResolver;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final TAG:Ljava/lang/String; = "AppsResolver"

.field private static final mMappedPackages:Landroid/util/ArrayMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/ArrayMap<",
            "Ljava/lang/String;",
            "Lcom/emanuelef/remote_capture/model/AppDescriptor;",
            ">;"
        }
    .end annotation
.end field

.field private static final mMappedUids:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Lcom/emanuelef/remote_capture/model/AppDescriptor;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private getPackageInfoAsUser:Ljava/lang/reflect/Method;

.field private final mApps:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Lcom/emanuelef/remote_capture/model/AppDescriptor;",
            ">;"
        }
    .end annotation
.end field

.field private final mContext:Landroid/content/Context;

.field private mFallbackToGlobalResolution:Z

.field private final mPm:Landroid/content/pm/PackageManager;

.field private mVirtualAppIcon:Landroid/graphics/drawable/Drawable;


# direct methods
.method public static synthetic $r8$lambda$fTOEB5gGAPptG0aAPiR_g7M1s6s(Lcom/emanuelef/remote_capture/AppsResolver;)Landroid/graphics/drawable/Drawable;
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/AppsResolver;->lambda$initVirtualApps$0()Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$wvcGQXlQZqcw5SBXWgieCW-pTkM(Lcom/emanuelef/remote_capture/AppsResolver;)Landroid/graphics/drawable/Drawable;
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/AppsResolver;->lambda$initVirtualApps$1()Landroid/graphics/drawable/Drawable;

    move-result-object p0

    return-object p0
.end method

.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Landroid/util/SparseArray;

    .line 2
    .line 3
    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcom/emanuelef/remote_capture/AppsResolver;->mMappedUids:Landroid/util/SparseArray;

    .line 7
    .line 8
    new-instance v0, Landroid/util/ArrayMap;

    .line 9
    .line 10
    invoke-direct {v0}, Landroid/util/ArrayMap;-><init>()V

    .line 11
    .line 12
    .line 13
    sput-object v0, Lcom/emanuelef/remote_capture/AppsResolver;->mMappedPackages:Landroid/util/ArrayMap;

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
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Landroid/util/SparseArray;

    .line 5
    .line 6
    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 10
    .line 11
    iput-object p1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 12
    .line 13
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    iput-object p1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mPm:Landroid/content/pm/PackageManager;

    .line 18
    .line 19
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/AppsResolver;->initVirtualApps()V

    .line 20
    .line 21
    .line 22
    return-void
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

.method public static declared-synchronized addMappedApp(ILjava/lang/String;Ljava/lang/String;)V
    .locals 8

    .line 1
    const-class v1, Lcom/emanuelef/remote_capture/AppsResolver;

    .line 2
    .line 3
    monitor-enter v1

    .line 4
    :try_start_0
    new-instance v2, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 5
    .line 6
    const/4 v4, 0x0

    .line 7
    const/4 v7, 0x0

    .line 8
    move v6, p0

    .line 9
    move-object v5, p1

    .line 10
    move-object v3, p2

    .line 11
    invoke-direct/range {v2 .. v7}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 12
    .line 13
    .line 14
    sget-object p0, Lcom/emanuelef/remote_capture/AppsResolver;->mMappedUids:Landroid/util/SparseArray;

    .line 15
    .line 16
    invoke-virtual {p0, v6, v2}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 17
    .line 18
    .line 19
    sget-object p0, Lcom/emanuelef/remote_capture/AppsResolver;->mMappedPackages:Landroid/util/ArrayMap;

    .line 20
    .line 21
    invoke-virtual {p0, v5, v2}, Landroid/util/ArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 22
    .line 23
    .line 24
    monitor-exit v1

    .line 25
    return-void

    .line 26
    :catchall_0
    move-exception v0

    .line 27
    move-object p0, v0

    .line 28
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 29
    throw p0
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

.method public static declared-synchronized clearMappedApps()V
    .locals 2

    .line 1
    const-class v0, Lcom/emanuelef/remote_capture/AppsResolver;

    .line 2
    .line 3
    monitor-enter v0

    .line 4
    :try_start_0
    sget-object v1, Lcom/emanuelef/remote_capture/AppsResolver;->mMappedUids:Landroid/util/SparseArray;

    .line 5
    .line 6
    invoke-virtual {v1}, Landroid/util/SparseArray;->clear()V

    .line 7
    .line 8
    .line 9
    sget-object v1, Lcom/emanuelef/remote_capture/AppsResolver;->mMappedPackages:Landroid/util/ArrayMap;

    .line 10
    .line 11
    invoke-virtual {v1}, Landroid/util/ArrayMap;->clear()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 12
    .line 13
    .line 14
    monitor-exit v0

    .line 15
    return-void

    .line 16
    :catchall_0
    move-exception v1

    .line 17
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 18
    throw v1
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

.method private static declared-synchronized getMappedApp(I)Lcom/emanuelef/remote_capture/model/AppDescriptor;
    .locals 2

    const-class v0, Lcom/emanuelef/remote_capture/AppsResolver;

    monitor-enter v0

    .line 1
    :try_start_0
    sget-object v1, Lcom/emanuelef/remote_capture/AppsResolver;->mMappedUids:Landroid/util/SparseArray;

    invoke-virtual {v1, p0}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/emanuelef/remote_capture/model/AppDescriptor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object p0

    :catchall_0
    move-exception p0

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p0
.end method

.method private static declared-synchronized getMappedApp(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/AppDescriptor;
    .locals 2

    const-class v0, Lcom/emanuelef/remote_capture/AppsResolver;

    monitor-enter v0

    .line 2
    :try_start_0
    sget-object v1, Lcom/emanuelef/remote_capture/AppsResolver;->mMappedPackages:Landroid/util/ArrayMap;

    invoke-virtual {v1, p0}, Landroid/util/ArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Lcom/emanuelef/remote_capture/model/AppDescriptor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object p0

    :catchall_0
    move-exception p0

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p0
.end method

.method private initVirtualApps()V
    .locals 9

    .line 1
    new-instance v2, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;

    .line 2
    .line 3
    const/4 v0, 0x0

    .line 4
    invoke-direct {v2, p0, v0}, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;-><init>(Lcom/emanuelef/remote_capture/AppsResolver;I)V

    .line 5
    .line 6
    .line 7
    new-instance v5, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    invoke-direct {v5, p0, v0}, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;-><init>(Lcom/emanuelef/remote_capture/AppsResolver;I)V

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 14
    .line 15
    new-instance v3, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 16
    .line 17
    iget-object v1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 18
    .line 19
    const v4, 0x7f1402d2

    .line 20
    .line 21
    .line 22
    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v4

    .line 26
    const/4 v7, -0x1

    .line 27
    const/4 v8, 0x1

    .line 28
    const-string v6, "unknown"

    .line 29
    .line 30
    invoke-direct/range {v3 .. v8}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 31
    .line 32
    .line 33
    iget-object v1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 34
    .line 35
    const v4, 0x7f1402d3

    .line 36
    .line 37
    .line 38
    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 39
    .line 40
    .line 41
    move-result-object v1

    .line 42
    invoke-virtual {v3, v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->setDescription(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 43
    .line 44
    .line 45
    move-result-object v1

    .line 46
    const/4 v3, -0x1

    .line 47
    invoke-virtual {v0, v3, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 48
    .line 49
    .line 50
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 51
    .line 52
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 53
    .line 54
    const/4 v4, 0x0

    .line 55
    const/4 v5, 0x1

    .line 56
    const-string v1, "Root"

    .line 57
    .line 58
    const-string v3, "root"

    .line 59
    .line 60
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 61
    .line 62
    .line 63
    iget-object v1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 64
    .line 65
    const v3, 0x7f140273

    .line 66
    .line 67
    .line 68
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 69
    .line 70
    .line 71
    move-result-object v1

    .line 72
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->setDescription(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 73
    .line 74
    .line 75
    move-result-object v0

    .line 76
    const/4 v1, 0x0

    .line 77
    invoke-virtual {v6, v1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 78
    .line 79
    .line 80
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 81
    .line 82
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 83
    .line 84
    const/16 v4, 0x3e8

    .line 85
    .line 86
    const-string v1, "Android"

    .line 87
    .line 88
    const-string v3, "android"

    .line 89
    .line 90
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 91
    .line 92
    .line 93
    iget-object v1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 94
    .line 95
    const v3, 0x7f140029

    .line 96
    .line 97
    .line 98
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 99
    .line 100
    .line 101
    move-result-object v1

    .line 102
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->setDescription(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 103
    .line 104
    .line 105
    move-result-object v0

    .line 106
    const/16 v1, 0x3e8

    .line 107
    .line 108
    invoke-virtual {v6, v1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 109
    .line 110
    .line 111
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 112
    .line 113
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 114
    .line 115
    iget-object v1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 116
    .line 117
    const v3, 0x7f140249

    .line 118
    .line 119
    .line 120
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 121
    .line 122
    .line 123
    move-result-object v1

    .line 124
    const/16 v4, 0x3e9

    .line 125
    .line 126
    const-string v3, "phone"

    .line 127
    .line 128
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 129
    .line 130
    .line 131
    iget-object v1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 132
    .line 133
    const v3, 0x7f14024a

    .line 134
    .line 135
    .line 136
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 137
    .line 138
    .line 139
    move-result-object v1

    .line 140
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->setDescription(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 141
    .line 142
    .line 143
    move-result-object v0

    .line 144
    const/16 v1, 0x3e9

    .line 145
    .line 146
    invoke-virtual {v6, v1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 147
    .line 148
    .line 149
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 150
    .line 151
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 152
    .line 153
    const/16 v4, 0x3f5

    .line 154
    .line 155
    const-string v1, "MediaServer"

    .line 156
    .line 157
    const-string v3, "mediaserver"

    .line 158
    .line 159
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 160
    .line 161
    .line 162
    const/16 v1, 0x3f5

    .line 163
    .line 164
    invoke-virtual {v6, v1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 165
    .line 166
    .line 167
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 168
    .line 169
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 170
    .line 171
    const/16 v4, 0x3fc

    .line 172
    .line 173
    const-string v1, "MulticastDNSResponder"

    .line 174
    .line 175
    const-string v3, "multicastdnsresponder"

    .line 176
    .line 177
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 178
    .line 179
    .line 180
    const/16 v1, 0x3fc

    .line 181
    .line 182
    invoke-virtual {v6, v1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 183
    .line 184
    .line 185
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 186
    .line 187
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 188
    .line 189
    const/16 v4, 0x3fd

    .line 190
    .line 191
    const-string v1, "GPS"

    .line 192
    .line 193
    const-string v3, "gps"

    .line 194
    .line 195
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 196
    .line 197
    .line 198
    const/16 v1, 0x3fd

    .line 199
    .line 200
    invoke-virtual {v6, v1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 201
    .line 202
    .line 203
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 204
    .line 205
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 206
    .line 207
    const/16 v4, 0x41b

    .line 208
    .line 209
    const-string v1, "netd"

    .line 210
    .line 211
    const-string v3, "netd"

    .line 212
    .line 213
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 214
    .line 215
    .line 216
    iget-object v1, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 217
    .line 218
    const v3, 0x7f140201

    .line 219
    .line 220
    .line 221
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 222
    .line 223
    .line 224
    move-result-object v1

    .line 225
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->setDescription(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 226
    .line 227
    .line 228
    move-result-object v0

    .line 229
    const/16 v1, 0x41b

    .line 230
    .line 231
    invoke-virtual {v6, v1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 232
    .line 233
    .line 234
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 235
    .line 236
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 237
    .line 238
    const/16 v4, 0x270f

    .line 239
    .line 240
    const-string v1, "Nobody"

    .line 241
    .line 242
    const-string v3, "nobody"

    .line 243
    .line 244
    invoke-direct/range {v0 .. v5}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Ljava/lang/String;Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;Ljava/lang/String;IZ)V

    .line 245
    .line 246
    .line 247
    const/16 v1, 0x270f

    .line 248
    .line 249
    invoke-virtual {v6, v1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 250
    .line 251
    .line 252
    return-void
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

.method private lambda$initVirtualApps$0()Landroid/graphics/drawable/Drawable;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mVirtualAppIcon:Landroid/graphics/drawable/Drawable;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 6
    .line 7
    const v1, 0x1080093

    .line 8
    .line 9
    .line 10
    invoke-static {v0, v1}, Landroidx/core/content/ContextCompat$Api21Impl;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    iput-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mVirtualAppIcon:Landroid/graphics/drawable/Drawable;

    .line 15
    .line 16
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mVirtualAppIcon:Landroid/graphics/drawable/Drawable;

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

.method private lambda$initVirtualApps$1()Landroid/graphics/drawable/Drawable;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mContext:Landroid/content/Context;

    .line 2
    .line 3
    const v1, 0x1080040

    .line 4
    .line 5
    .line 6
    invoke-static {v0, v1}, Landroidx/core/content/ContextCompat$Api21Impl;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    return-object v0
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

.method public static resolveInstalledApp(Landroid/content/pm/PackageManager;Ljava/lang/String;I)Lcom/emanuelef/remote_capture/model/AppDescriptor;
    .locals 1

    const/4 v0, 0x1

    .line 5
    invoke-static {p0, p1, p2, v0}, Lcom/emanuelef/remote_capture/AppsResolver;->resolveInstalledApp(Landroid/content/pm/PackageManager;Ljava/lang/String;IZ)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    move-result-object p0

    return-object p0
.end method

.method public static resolveInstalledApp(Landroid/content/pm/PackageManager;Ljava/lang/String;IZ)Lcom/emanuelef/remote_capture/model/AppDescriptor;
    .locals 1

    .line 1
    invoke-static {p1}, Lcom/emanuelef/remote_capture/AppsResolver;->getMappedApp(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    move-result-object v0

    if-eqz v0, :cond_0

    return-object v0

    .line 2
    :cond_0
    :try_start_0
    invoke-static {p0, p1, p2}, Lcom/emanuelef/remote_capture/Utils;->getPackageInfo(Landroid/content/pm/PackageManager;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object p1
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 3
    new-instance p2, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    invoke-direct {p2, p0, p1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Landroid/content/pm/PackageManager;Landroid/content/pm/PackageInfo;)V

    return-object p2

    :catch_0
    if-eqz p3, :cond_1

    .line 4
    new-instance p0, Ljava/lang/StringBuilder;

    const-string p2, "could not retrieve package: "

    invoke-direct {p0, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const-string p1, "AppsResolver"

    invoke-static {p1, p0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    const/4 p0, 0x0

    return-object p0
.end method


# virtual methods
.method public clear()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/AppsResolver;->initVirtualApps()V

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

.method public getAppByPackage(Ljava/lang/String;I)Lcom/emanuelef/remote_capture/model/AppDescriptor;
    .locals 1

    .line 1
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/AppsResolver;->getUid(Ljava/lang/String;)I

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    const/4 v0, -0x2

    .line 6
    if-ne p1, v0, :cond_0

    .line 7
    .line 8
    const/4 p1, 0x0

    .line 9
    return-object p1

    .line 10
    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    return-object p1
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

.method public getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;
    .locals 11
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "DiscouragedPrivateApi"
        }
    .end annotation

    .line 1
    invoke-static {p1}, Lcom/emanuelef/remote_capture/AppsResolver;->getMappedApp(I)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    return-object v0

    .line 8
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 9
    .line 10
    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    check-cast v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 15
    .line 16
    if-eqz v0, :cond_1

    .line 17
    .line 18
    return-object v0

    .line 19
    :cond_1
    const/4 v1, 0x0

    .line 20
    :try_start_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mPm:Landroid/content/pm/PackageManager;

    .line 21
    .line 22
    invoke-virtual {v2, p1}, Landroid/content/pm/PackageManager;->getPackagesForUid(I)[Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v2
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 26
    goto :goto_0

    .line 27
    :catch_0
    move-exception v2

    .line 28
    invoke-virtual {v2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 29
    .line 30
    .line 31
    move-object v2, v1

    .line 32
    :goto_0
    const-string v3, "AppsResolver"

    .line 33
    .line 34
    if-eqz v2, :cond_9

    .line 35
    .line 36
    array-length v4, v2

    .line 37
    const/4 v5, 0x1

    .line 38
    if-ge v4, v5, :cond_2

    .line 39
    .line 40
    goto/16 :goto_5

    .line 41
    .line 42
    :cond_2
    const/4 v1, 0x0

    .line 43
    aget-object v4, v2, v1

    .line 44
    .line 45
    array-length v6, v2

    .line 46
    const/4 v7, 0x0

    .line 47
    :goto_1
    if-ge v7, v6, :cond_4

    .line 48
    .line 49
    aget-object v8, v2, v7

    .line 50
    .line 51
    invoke-virtual {v8, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    .line 52
    .line 53
    .line 54
    move-result v9

    .line 55
    if-gez v9, :cond_3

    .line 56
    .line 57
    move-object v4, v8

    .line 58
    :cond_3
    add-int/lit8 v7, v7, 0x1

    .line 59
    .line 60
    goto :goto_1

    .line 61
    :cond_4
    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mFallbackToGlobalResolution:Z

    .line 62
    .line 63
    if-nez v2, :cond_6

    .line 64
    .line 65
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isCapturingAsRoot()Z

    .line 66
    .line 67
    .line 68
    move-result v2

    .line 69
    if-eqz v2, :cond_6

    .line 70
    .line 71
    :try_start_1
    iget-object v2, p0, Lcom/emanuelef/remote_capture/AppsResolver;->getPackageInfoAsUser:Ljava/lang/reflect/Method;

    .line 72
    .line 73
    const/4 v6, 0x2

    .line 74
    const/4 v7, 0x3

    .line 75
    if-nez v2, :cond_5

    .line 76
    .line 77
    const-class v2, Landroid/content/pm/PackageManager;

    .line 78
    .line 79
    const-string v8, "getPackageInfoAsUser"

    .line 80
    .line 81
    new-array v9, v7, [Ljava/lang/Class;

    .line 82
    .line 83
    const-class v10, Ljava/lang/String;

    .line 84
    .line 85
    aput-object v10, v9, v1

    .line 86
    .line 87
    sget-object v10, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    .line 88
    .line 89
    aput-object v10, v9, v5

    .line 90
    .line 91
    aput-object v10, v9, v6

    .line 92
    .line 93
    invoke-virtual {v2, v8, v9}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    .line 94
    .line 95
    .line 96
    move-result-object v2

    .line 97
    iput-object v2, p0, Lcom/emanuelef/remote_capture/AppsResolver;->getPackageInfoAsUser:Ljava/lang/reflect/Method;

    .line 98
    .line 99
    goto :goto_2

    .line 100
    :catch_1
    move-exception v1

    .line 101
    goto :goto_3

    .line 102
    :catch_2
    move-exception v1

    .line 103
    goto :goto_3

    .line 104
    :catch_3
    move-exception v1

    .line 105
    goto :goto_3

    .line 106
    :cond_5
    :goto_2
    iget-object v2, p0, Lcom/emanuelef/remote_capture/AppsResolver;->getPackageInfoAsUser:Ljava/lang/reflect/Method;

    .line 107
    .line 108
    iget-object v8, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mPm:Landroid/content/pm/PackageManager;

    .line 109
    .line 110
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 111
    .line 112
    .line 113
    move-result-object v9

    .line 114
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->getUserId(I)I

    .line 115
    .line 116
    .line 117
    move-result v10

    .line 118
    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 119
    .line 120
    .line 121
    move-result-object v10

    .line 122
    new-array v7, v7, [Ljava/lang/Object;

    .line 123
    .line 124
    aput-object v4, v7, v1

    .line 125
    .line 126
    aput-object v9, v7, v5

    .line 127
    .line 128
    aput-object v10, v7, v6

    .line 129
    .line 130
    invoke-virtual {v2, v8, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    .line 132
    .line 133
    move-result-object v1

    .line 134
    check-cast v1, Landroid/content/pm/PackageInfo;

    .line 135
    .line 136
    if-eqz v1, :cond_6

    .line 137
    .line 138
    new-instance v2, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 139
    .line 140
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mPm:Landroid/content/pm/PackageManager;

    .line 141
    .line 142
    invoke-direct {v2, v6, v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Landroid/content/pm/PackageManager;Landroid/content/pm/PackageInfo;)V
    :try_end_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_1} :catch_1

    .line 143
    .line 144
    .line 145
    move-object v0, v2

    .line 146
    goto :goto_4

    .line 147
    :goto_3
    const-string v2, "getPackageInfoAsUser call fails, falling back to standard resolution"

    .line 148
    .line 149
    invoke-static {v3, v2}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    .line 151
    .line 152
    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 153
    .line 154
    .line 155
    iput-boolean v5, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mFallbackToGlobalResolution:Z

    .line 156
    .line 157
    :cond_6
    :goto_4
    if-nez v0, :cond_7

    .line 158
    .line 159
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mPm:Landroid/content/pm/PackageManager;

    .line 160
    .line 161
    invoke-static {v0, v4, p2}, Lcom/emanuelef/remote_capture/AppsResolver;->resolveInstalledApp(Landroid/content/pm/PackageManager;Ljava/lang/String;I)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 162
    .line 163
    .line 164
    move-result-object v0

    .line 165
    :cond_7
    if-eqz v0, :cond_8

    .line 166
    .line 167
    iget-object p2, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 168
    .line 169
    invoke-virtual {p2, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 170
    .line 171
    .line 172
    :cond_8
    return-object v0

    .line 173
    :cond_9
    :goto_5
    new-instance p2, Ljava/lang/StringBuilder;

    .line 174
    .line 175
    const-string v0, "could not retrieve package: uid="

    .line 176
    .line 177
    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 178
    .line 179
    .line 180
    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 181
    .line 182
    .line 183
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 184
    .line 185
    .line 186
    move-result-object p1

    .line 187
    invoke-static {v3, p1}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    .line 189
    .line 190
    return-object v1
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

.method public getUid(Ljava/lang/String;)I
    .locals 3

    .line 1
    invoke-static {p1}, Lcom/emanuelef/remote_capture/AppsResolver;->getMappedApp(Ljava/lang/String;)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getUid()I

    .line 8
    .line 9
    .line 10
    move-result p1

    .line 11
    return p1

    .line 12
    :cond_0
    const-string v0, "."

    .line 13
    .line 14
    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    .line 15
    .line 16
    .line 17
    move-result v0

    .line 18
    const/4 v1, 0x0

    .line 19
    if-nez v0, :cond_2

    .line 20
    .line 21
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 22
    .line 23
    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    .line 24
    .line 25
    .line 26
    move-result v0

    .line 27
    if-ge v1, v0, :cond_3

    .line 28
    .line 29
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mApps:Landroid/util/SparseArray;

    .line 30
    .line 31
    invoke-virtual {v0, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    check-cast v0, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 36
    .line 37
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object v2

    .line 41
    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 42
    .line 43
    .line 44
    move-result v2

    .line 45
    if-eqz v2, :cond_1

    .line 46
    .line 47
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getUid()I

    .line 48
    .line 49
    .line 50
    move-result p1

    .line 51
    return p1

    .line 52
    :cond_1
    add-int/lit8 v1, v1, 0x1

    .line 53
    .line 54
    goto :goto_0

    .line 55
    :cond_2
    :try_start_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver;->mPm:Landroid/content/pm/PackageManager;

    .line 56
    .line 57
    invoke-static {v0, p1, v1}, Lcom/emanuelef/remote_capture/Utils;->getPackageUid(Landroid/content/pm/PackageManager;Ljava/lang/String;I)I

    .line 58
    .line 59
    .line 60
    move-result p1
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 61
    return p1

    .line 62
    :catch_0
    const-string v0, "Could not retrieve package "

    .line 63
    .line 64
    invoke-virtual {v0, p1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 65
    .line 66
    .line 67
    move-result-object p1

    .line 68
    const-string v0, "AppsResolver"

    .line 69
    .line 70
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    .line 72
    .line 73
    :cond_3
    const/4 p1, -0x2

    .line 74
    return p1
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
