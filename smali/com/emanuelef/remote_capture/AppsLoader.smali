.class public Lcom/emanuelef/remote_capture/AppsLoader;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/loader/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroidx/loader/app/LoaderManager$LoaderCallbacks;"
    }
.end annotation


# static fields
.field private static final OPERATION_LOAD_APPS_INFO:I = 0x17

.field private static final TAG:Ljava/lang/String; = "AppsLoader"

.field private static final TERMUX_PACKAGE:Ljava/lang/String; = "com.termux"


# instance fields
.field private final mContext:Landroidx/appcompat/app/AppCompatActivity;

.field private mListener:Lcom/emanuelef/remote_capture/interfaces/AppsLoadListener;


# direct methods
.method public static bridge synthetic -$$Nest$masyncLoadAppsInfo(Lcom/emanuelef/remote_capture/AppsLoader;)Ljava/util/ArrayList;
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/AppsLoader;->asyncLoadAppsInfo()Ljava/util/ArrayList;

    move-result-object p0

    return-object p0
.end method

.method public constructor <init>(Landroidx/appcompat/app/AppCompatActivity;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lcom/emanuelef/remote_capture/AppsLoader;->mContext:Landroidx/appcompat/app/AppCompatActivity;

    .line 5
    .line 6
    return-void
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

.method private asyncLoadAppsInfo()Ljava/util/ArrayList;
    .locals 13
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "QueryPermissionsNeeded"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/model/AppDescriptor;",
            ">;"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsLoader;->mContext:Landroidx/appcompat/app/AppCompatActivity;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    new-instance v1, Ljava/util/ArrayList;

    .line 8
    .line 9
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 10
    .line 11
    .line 12
    new-instance v2, Landroid/util/ArrayMap;

    .line 13
    .line 14
    invoke-direct {v2}, Landroid/util/ArrayMap;-><init>()V

    .line 15
    .line 16
    .line 17
    const-string v3, "Loading APPs..."

    .line 18
    .line 19
    const-string v4, "AppsLoader"

    .line 20
    .line 21
    invoke-static {v4, v3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    .line 23
    .line 24
    const/4 v3, 0x0

    .line 25
    invoke-static {v0, v3}, Lcom/emanuelef/remote_capture/Utils;->getInstalledPackages(Landroid/content/pm/PackageManager;I)Ljava/util/List;

    .line 26
    .line 27
    .line 28
    move-result-object v5

    .line 29
    iget-object v6, p0, Lcom/emanuelef/remote_capture/AppsLoader;->mContext:Landroidx/appcompat/app/AppCompatActivity;

    .line 30
    .line 31
    invoke-virtual {v6}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    .line 32
    .line 33
    .line 34
    move-result-object v6

    .line 35
    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 36
    .line 37
    .line 38
    move-result-object v6

    .line 39
    new-instance v7, Ljava/lang/StringBuilder;

    .line 40
    .line 41
    const-string v8, "num apps (system+user): "

    .line 42
    .line 43
    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 44
    .line 45
    .line 46
    invoke-interface {v5}, Ljava/util/List;->size()I

    .line 47
    .line 48
    .line 49
    move-result v8

    .line 50
    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 54
    .line 55
    .line 56
    move-result-object v7

    .line 57
    invoke-static {v4, v7}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->now()J

    .line 61
    .line 62
    .line 63
    move-result-wide v7

    .line 64
    const/4 v9, 0x0

    .line 65
    :goto_0
    invoke-interface {v5}, Ljava/util/List;->size()I

    .line 66
    .line 67
    .line 68
    move-result v10

    .line 69
    if-ge v3, v10, :cond_2

    .line 70
    .line 71
    invoke-interface {v5, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 72
    .line 73
    .line 74
    move-result-object v10

    .line 75
    check-cast v10, Landroid/content/pm/PackageInfo;

    .line 76
    .line 77
    iget-object v11, v10, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 78
    .line 79
    iget-object v11, v11, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 80
    .line 81
    const-string v12, "com.termux"

    .line 82
    .line 83
    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 84
    .line 85
    .line 86
    move-result v12

    .line 87
    if-eqz v12, :cond_0

    .line 88
    .line 89
    move-object v9, v10

    .line 90
    :cond_0
    iget-object v12, v10, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 91
    .line 92
    iget v12, v12, Landroid/content/pm/ApplicationInfo;->uid:I

    .line 93
    .line 94
    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 95
    .line 96
    .line 97
    move-result-object v12

    .line 98
    invoke-virtual {v2, v12}, Landroid/util/ArrayMap;->containsKey(Ljava/lang/Object;)Z

    .line 99
    .line 100
    .line 101
    move-result v12

    .line 102
    if-nez v12, :cond_1

    .line 103
    .line 104
    invoke-virtual {v11, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 105
    .line 106
    .line 107
    move-result v11

    .line 108
    if-nez v11, :cond_1

    .line 109
    .line 110
    iget-object v11, v10, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 111
    .line 112
    iget v11, v11, Landroid/content/pm/ApplicationInfo;->uid:I

    .line 113
    .line 114
    new-instance v12, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 115
    .line 116
    invoke-direct {v12, v0, v10}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Landroid/content/pm/PackageManager;Landroid/content/pm/PackageInfo;)V

    .line 117
    .line 118
    .line 119
    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 120
    .line 121
    .line 122
    move-result-object v10

    .line 123
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 124
    .line 125
    .line 126
    move-result v11

    .line 127
    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 128
    .line 129
    .line 130
    move-result-object v11

    .line 131
    invoke-virtual {v2, v10, v11}, Landroid/util/ArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    .line 133
    .line 134
    invoke-virtual {v1, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 135
    .line 136
    .line 137
    :cond_1
    add-int/lit8 v3, v3, 0x1

    .line 138
    .line 139
    goto :goto_0

    .line 140
    :cond_2
    if-eqz v9, :cond_3

    .line 141
    .line 142
    iget-object v3, v9, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 143
    .line 144
    iget v3, v3, Landroid/content/pm/ApplicationInfo;->uid:I

    .line 145
    .line 146
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 147
    .line 148
    .line 149
    move-result-object v3

    .line 150
    invoke-virtual {v2, v3}, Landroid/util/ArrayMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 151
    .line 152
    .line 153
    move-result-object v2

    .line 154
    check-cast v2, Ljava/lang/Integer;

    .line 155
    .line 156
    if-eqz v2, :cond_3

    .line 157
    .line 158
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    .line 159
    .line 160
    .line 161
    move-result v2

    .line 162
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 163
    .line 164
    .line 165
    new-instance v2, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 166
    .line 167
    invoke-direct {v2, v0, v9}, Lcom/emanuelef/remote_capture/model/AppDescriptor;-><init>(Landroid/content/pm/PackageManager;Landroid/content/pm/PackageInfo;)V

    .line 168
    .line 169
    .line 170
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 171
    .line 172
    .line 173
    :cond_3
    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 174
    .line 175
    .line 176
    new-instance v0, Ljava/lang/StringBuilder;

    .line 177
    .line 178
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 179
    .line 180
    .line 181
    invoke-interface {v5}, Ljava/util/List;->size()I

    .line 182
    .line 183
    .line 184
    move-result v2

    .line 185
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 186
    .line 187
    .line 188
    const-string v2, " apps loaded in "

    .line 189
    .line 190
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 191
    .line 192
    .line 193
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->now()J

    .line 194
    .line 195
    .line 196
    move-result-wide v2

    .line 197
    sub-long/2addr v2, v7

    .line 198
    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 199
    .line 200
    .line 201
    const-string v2, " seconds"

    .line 202
    .line 203
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 204
    .line 205
    .line 206
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 207
    .line 208
    .line 209
    move-result-object v0

    .line 210
    invoke-static {v4, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    .line 212
    .line 213
    return-object v1
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

.method private finishLoader()V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsLoader;->mContext:Landroidx/appcompat/app/AppCompatActivity;

    .line 2
    .line 3
    invoke-static {v0}, Landroidx/loader/app/LoaderManager;->getInstance(Landroidx/lifecycle/LifecycleOwner;)Landroidx/loader/app/LoaderManagerImpl;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v0, v0, Landroidx/loader/app/LoaderManagerImpl;->mLoaderViewModel:Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;

    .line 8
    .line 9
    iget-boolean v1, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;->mCreatingLoader:Z

    .line 10
    .line 11
    iget-object v0, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;->mLoaders:Landroidx/collection/SparseArrayCompat;

    .line 12
    .line 13
    if-nez v1, :cond_2

    .line 14
    .line 15
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 16
    .line 17
    .line 18
    move-result-object v1

    .line 19
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    .line 20
    .line 21
    .line 22
    move-result-object v2

    .line 23
    if-ne v1, v2, :cond_1

    .line 24
    .line 25
    const/16 v1, 0x17

    .line 26
    .line 27
    invoke-virtual {v0, v1}, Landroidx/collection/SparseArrayCompat;->get(I)Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v2

    .line 31
    check-cast v2, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;

    .line 32
    .line 33
    if-eqz v2, :cond_0

    .line 34
    .line 35
    invoke-virtual {v2}, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->destroy()V

    .line 36
    .line 37
    .line 38
    iget-object v2, v0, Landroidx/collection/SparseArrayCompat;->keys:[I

    .line 39
    .line 40
    iget v3, v0, Landroidx/collection/SparseArrayCompat;->size:I

    .line 41
    .line 42
    invoke-static {v3, v1, v2}, Landroidx/collection/internal/ContainerHelpersKt;->binarySearch(II[I)I

    .line 43
    .line 44
    .line 45
    move-result v1

    .line 46
    if-ltz v1, :cond_0

    .line 47
    .line 48
    iget-object v2, v0, Landroidx/collection/SparseArrayCompat;->values:[Ljava/lang/Object;

    .line 49
    .line 50
    aget-object v3, v2, v1

    .line 51
    .line 52
    sget-object v4, Landroidx/collection/ArraySetKt;->DELETED$1:Ljava/lang/Object;

    .line 53
    .line 54
    if-eq v3, v4, :cond_0

    .line 55
    .line 56
    aput-object v4, v2, v1

    .line 57
    .line 58
    const/4 v1, 0x1

    .line 59
    iput-boolean v1, v0, Landroidx/collection/SparseArrayCompat;->garbage:Z

    .line 60
    .line 61
    :cond_0
    return-void

    .line 62
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 63
    .line 64
    const-string v1, "destroyLoader must be called on the main thread"

    .line 65
    .line 66
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 67
    .line 68
    .line 69
    throw v0

    .line 70
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 71
    .line 72
    const-string v1, "Called while creating a loader"

    .line 73
    .line 74
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 75
    .line 76
    .line 77
    throw v0
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

.method private runLoader(ILjava/util/ArrayList;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/model/AppDescriptor;",
            ">;)V"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsLoader;->mContext:Landroidx/appcompat/app/AppCompatActivity;

    .line 2
    .line 3
    invoke-static {v0}, Landroidx/loader/app/LoaderManager;->getInstance(Landroidx/lifecycle/LifecycleOwner;)Landroidx/loader/app/LoaderManagerImpl;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, v0, Landroidx/loader/app/LoaderManagerImpl;->mLoaderViewModel:Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;

    .line 8
    .line 9
    iget-boolean v2, v1, Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;->mCreatingLoader:Z

    .line 10
    .line 11
    iget-object v3, v1, Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;->mLoaders:Landroidx/collection/SparseArrayCompat;

    .line 12
    .line 13
    const-string v4, "Called while creating a loader"

    .line 14
    .line 15
    if-nez v2, :cond_a

    .line 16
    .line 17
    invoke-virtual {v3, p1}, Landroidx/collection/SparseArrayCompat;->get(I)Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object v2

    .line 21
    check-cast v2, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;

    .line 22
    .line 23
    if-eqz v2, :cond_0

    .line 24
    .line 25
    iget-object v2, v2, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mLoader:Landroidx/loader/content/Loader;

    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_0
    const/4 v2, 0x0

    .line 29
    :goto_0
    new-instance v5, Landroid/os/Bundle;

    .line 30
    .line 31
    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 32
    .line 33
    .line 34
    const-string v6, "apps"

    .line 35
    .line 36
    invoke-virtual {v5, v6, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 37
    .line 38
    .line 39
    const-string p2, "Existing loader "

    .line 40
    .line 41
    const-string v6, "? "

    .line 42
    .line 43
    invoke-static {p2, p1, v6}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 44
    .line 45
    .line 46
    move-result-object p2

    .line 47
    const/4 v6, 0x0

    .line 48
    const/4 v7, 0x1

    .line 49
    if-eqz v2, :cond_1

    .line 50
    .line 51
    const/4 v2, 0x1

    .line 52
    goto :goto_1

    .line 53
    :cond_1
    const/4 v2, 0x0

    .line 54
    :goto_1
    invoke-virtual {p2, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 55
    .line 56
    .line 57
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 58
    .line 59
    .line 60
    move-result-object p2

    .line 61
    const-string v2, "AppsLoader"

    .line 62
    .line 63
    invoke-static {v2, p2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    .line 65
    .line 66
    iget-object p2, v0, Landroidx/loader/app/LoaderManagerImpl;->mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

    .line 67
    .line 68
    iget-boolean v0, v1, Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;->mCreatingLoader:Z

    .line 69
    .line 70
    if-nez v0, :cond_9

    .line 71
    .line 72
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 73
    .line 74
    .line 75
    move-result-object v0

    .line 76
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    .line 77
    .line 78
    .line 79
    move-result-object v2

    .line 80
    if-ne v0, v2, :cond_8

    .line 81
    .line 82
    invoke-virtual {v3, p1}, Landroidx/collection/SparseArrayCompat;->get(I)Ljava/lang/Object;

    .line 83
    .line 84
    .line 85
    move-result-object v0

    .line 86
    check-cast v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;

    .line 87
    .line 88
    if-nez v0, :cond_6

    .line 89
    .line 90
    const-string v0, "Object returned from onCreateLoader must not be a non-static inner member class: "

    .line 91
    .line 92
    :try_start_0
    iput-boolean v7, v1, Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;->mCreatingLoader:Z

    .line 93
    .line 94
    invoke-interface {p0, p1, v5}, Landroidx/loader/app/LoaderManager$LoaderCallbacks;->onCreateLoader(ILandroid/os/Bundle;)Landroidx/loader/content/Loader;

    .line 95
    .line 96
    .line 97
    move-result-object v2

    .line 98
    if-eqz v2, :cond_5

    .line 99
    .line 100
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 101
    .line 102
    .line 103
    move-result-object v4

    .line 104
    invoke-virtual {v4}, Ljava/lang/Class;->isMemberClass()Z

    .line 105
    .line 106
    .line 107
    move-result v4

    .line 108
    if-eqz v4, :cond_3

    .line 109
    .line 110
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 111
    .line 112
    .line 113
    move-result-object v4

    .line 114
    invoke-virtual {v4}, Ljava/lang/Class;->getModifiers()I

    .line 115
    .line 116
    .line 117
    move-result v4

    .line 118
    invoke-static {v4}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    .line 119
    .line 120
    .line 121
    move-result v4

    .line 122
    if-eqz v4, :cond_2

    .line 123
    .line 124
    goto :goto_2

    .line 125
    :cond_2
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 126
    .line 127
    new-instance p2, Ljava/lang/StringBuilder;

    .line 128
    .line 129
    invoke-direct {p2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 130
    .line 131
    .line 132
    invoke-virtual {p2, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 133
    .line 134
    .line 135
    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 136
    .line 137
    .line 138
    move-result-object p2

    .line 139
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 140
    .line 141
    .line 142
    throw p1

    .line 143
    :catchall_0
    move-exception p1

    .line 144
    goto :goto_3

    .line 145
    :cond_3
    :goto_2
    new-instance v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;

    .line 146
    .line 147
    invoke-direct {v0, p1, v5, v2}, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;-><init>(ILandroid/os/Bundle;Landroidx/loader/content/Loader;)V

    .line 148
    .line 149
    .line 150
    invoke-virtual {v3, p1, v0}, Landroidx/collection/SparseArrayCompat;->put(ILjava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 151
    .line 152
    .line 153
    iput-boolean v6, v1, Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;->mCreatingLoader:Z

    .line 154
    .line 155
    new-instance p1, Landroidx/loader/app/LoaderManagerImpl$LoaderObserver;

    .line 156
    .line 157
    iget-object v1, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mLoader:Landroidx/loader/content/Loader;

    .line 158
    .line 159
    invoke-direct {p1, v1, p0}, Landroidx/loader/app/LoaderManagerImpl$LoaderObserver;-><init>(Landroidx/loader/content/Loader;Lcom/emanuelef/remote_capture/AppsLoader;)V

    .line 160
    .line 161
    .line 162
    invoke-virtual {v0, p2, p1}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 163
    .line 164
    .line 165
    iget-object v2, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mObserver:Landroidx/loader/app/LoaderManagerImpl$LoaderObserver;

    .line 166
    .line 167
    if-eqz v2, :cond_4

    .line 168
    .line 169
    invoke-virtual {v0, v2}, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->removeObserver(Landroidx/lifecycle/Observer;)V

    .line 170
    .line 171
    .line 172
    :cond_4
    iput-object p2, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

    .line 173
    .line 174
    iput-object p1, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mObserver:Landroidx/loader/app/LoaderManagerImpl$LoaderObserver;

    .line 175
    .line 176
    goto :goto_4

    .line 177
    :cond_5
    :try_start_1
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 178
    .line 179
    const-string p2, "Object returned from onCreateLoader must not be null"

    .line 180
    .line 181
    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 182
    .line 183
    .line 184
    throw p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 185
    :goto_3
    iput-boolean v6, v1, Landroidx/loader/app/LoaderManagerImpl$LoaderViewModel;->mCreatingLoader:Z

    .line 186
    .line 187
    throw p1

    .line 188
    :cond_6
    new-instance p1, Landroidx/loader/app/LoaderManagerImpl$LoaderObserver;

    .line 189
    .line 190
    iget-object v1, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mLoader:Landroidx/loader/content/Loader;

    .line 191
    .line 192
    invoke-direct {p1, v1, p0}, Landroidx/loader/app/LoaderManagerImpl$LoaderObserver;-><init>(Landroidx/loader/content/Loader;Lcom/emanuelef/remote_capture/AppsLoader;)V

    .line 193
    .line 194
    .line 195
    invoke-virtual {v0, p2, p1}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 196
    .line 197
    .line 198
    iget-object v2, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mObserver:Landroidx/loader/app/LoaderManagerImpl$LoaderObserver;

    .line 199
    .line 200
    if-eqz v2, :cond_7

    .line 201
    .line 202
    invoke-virtual {v0, v2}, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->removeObserver(Landroidx/lifecycle/Observer;)V

    .line 203
    .line 204
    .line 205
    :cond_7
    iput-object p2, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mLifecycleOwner:Landroidx/lifecycle/LifecycleOwner;

    .line 206
    .line 207
    iput-object p1, v0, Landroidx/loader/app/LoaderManagerImpl$LoaderInfo;->mObserver:Landroidx/loader/app/LoaderManagerImpl$LoaderObserver;

    .line 208
    .line 209
    :goto_4
    invoke-virtual {v1}, Landroidx/loader/content/Loader;->forceLoad()V

    .line 210
    .line 211
    .line 212
    return-void

    .line 213
    :cond_8
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 214
    .line 215
    const-string p2, "initLoader must be called on the main thread"

    .line 216
    .line 217
    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 218
    .line 219
    .line 220
    throw p1

    .line 221
    :cond_9
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 222
    .line 223
    invoke-direct {p1, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 224
    .line 225
    .line 226
    throw p1

    .line 227
    :cond_a
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 228
    .line 229
    invoke-direct {p1, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 230
    .line 231
    .line 232
    throw p1
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


# virtual methods
.method public abort()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/AppsLoader;->finishLoader()V

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

.method public loadAllApps()Lcom/emanuelef/remote_capture/AppsLoader;
    .locals 2

    .line 1
    const/16 v0, 0x17

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {p0, v0, v1}, Lcom/emanuelef/remote_capture/AppsLoader;->runLoader(ILjava/util/ArrayList;)V

    .line 5
    .line 6
    .line 7
    return-object p0
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

.method public onCreateLoader(ILandroid/os/Bundle;)Landroidx/loader/content/Loader;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroidx/loader/content/Loader;"
        }
    .end annotation

    .line 1
    new-instance p2, Lcom/emanuelef/remote_capture/AppsLoader$1;

    .line 2
    .line 3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsLoader;->mContext:Landroidx/appcompat/app/AppCompatActivity;

    .line 4
    .line 5
    invoke-direct {p2, p0, v0, p1}, Lcom/emanuelef/remote_capture/AppsLoader$1;-><init>(Lcom/emanuelef/remote_capture/AppsLoader;Landroid/content/Context;I)V

    .line 6
    .line 7
    .line 8
    return-object p2
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

.method public bridge synthetic onLoadFinished(Landroidx/loader/content/Loader;Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p2, Ljava/util/ArrayList;

    invoke-virtual {p0, p1, p2}, Lcom/emanuelef/remote_capture/AppsLoader;->onLoadFinished(Landroidx/loader/content/Loader;Ljava/util/ArrayList;)V

    return-void
.end method

.method public onLoadFinished(Landroidx/loader/content/Loader;Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/loader/content/Loader;",
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/model/AppDescriptor;",
            ">;)V"
        }
    .end annotation

    .line 2
    iget-object p1, p0, Lcom/emanuelef/remote_capture/AppsLoader;->mListener:Lcom/emanuelef/remote_capture/interfaces/AppsLoadListener;

    if-eqz p1, :cond_0

    .line 3
    invoke-interface {p1, p2}, Lcom/emanuelef/remote_capture/interfaces/AppsLoadListener;->onAppsInfoLoaded(Ljava/util/List;)V

    .line 4
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/AppsLoader;->finishLoader()V

    return-void
.end method

.method public onLoaderReset(Landroidx/loader/content/Loader;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/loader/content/Loader;",
            ")V"
        }
    .end annotation

    .line 1
    const-string p1, "AppsLoader"

    .line 2
    .line 3
    const-string v0, "onLoaderReset"

    .line 4
    .line 5
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

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

.method public setAppsLoadListener(Lcom/emanuelef/remote_capture/interfaces/AppsLoadListener;)Lcom/emanuelef/remote_capture/AppsLoader;
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/AppsLoader;->mListener:Lcom/emanuelef/remote_capture/interfaces/AppsLoadListener;

    .line 2
    .line 3
    return-object p0
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
