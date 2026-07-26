.class public final synthetic Lcat/ereza/customactivityoncrash/CustomActivityOnCrash$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# instance fields
.field public final synthetic f$0:Ljava/lang/Thread$UncaughtExceptionHandler;


# direct methods
.method public synthetic constructor <init>(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Thread$UncaughtExceptionHandler;

    return-void
.end method


# virtual methods
.method public final uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 13

    .line 1
    sget-object v0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->config:Lcat/ereza/customactivityoncrash/config/CaocConfig;

    .line 2
    .line 3
    iget-boolean v0, v0, Lcat/ereza/customactivityoncrash/config/CaocConfig;->enabled:Z

    .line 4
    .line 5
    iget-object v1, p0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 6
    .line 7
    if-eqz v0, :cond_e

    .line 8
    .line 9
    const-string v0, "App has crashed, executing CustomActivityOnCrash\'s UncaughtExceptionHandler"

    .line 10
    .line 11
    const-string v2, "CustomActivityOnCrash"

    .line 12
    .line 13
    invoke-static {v2, v0, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 14
    .line 15
    .line 16
    sget-object v0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 17
    .line 18
    const-string v3, "custom_activity_on_crash"

    .line 19
    .line 20
    const/4 v4, 0x0

    .line 21
    invoke-virtual {v0, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    const-wide/16 v5, -0x1

    .line 26
    .line 27
    const-string v7, "last_crash_timestamp"

    .line 28
    .line 29
    invoke-interface {v0, v7, v5, v6}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    .line 30
    .line 31
    .line 32
    move-result-wide v5

    .line 33
    new-instance v0, Ljava/util/Date;

    .line 34
    .line 35
    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 36
    .line 37
    .line 38
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    .line 39
    .line 40
    .line 41
    move-result-wide v8

    .line 42
    cmp-long v0, v5, v8

    .line 43
    .line 44
    if-gtz v0, :cond_0

    .line 45
    .line 46
    sub-long/2addr v8, v5

    .line 47
    sget-object v0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 48
    .line 49
    const/16 v0, 0xbb8

    .line 50
    .line 51
    int-to-long v5, v0

    .line 52
    cmp-long v0, v8, v5

    .line 53
    .line 54
    if-gez v0, :cond_0

    .line 55
    .line 56
    const-string v0, "App already crashed recently, not starting custom error activity because we could enter a restart loop. Are you sure that your app does not crash directly on init?"

    .line 57
    .line 58
    invoke-static {v2, v0, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 59
    .line 60
    .line 61
    if-eqz v1, :cond_c

    .line 62
    .line 63
    invoke-interface {v1, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 64
    .line 65
    .line 66
    return-void

    .line 67
    :cond_0
    sget-object v0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 68
    .line 69
    new-instance v5, Ljava/util/Date;

    .line 70
    .line 71
    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    .line 72
    .line 73
    .line 74
    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    .line 75
    .line 76
    .line 77
    move-result-wide v5

    .line 78
    invoke-virtual {v0, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    .line 79
    .line 80
    .line 81
    move-result-object v0

    .line 82
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    .line 83
    .line 84
    .line 85
    move-result-object v0

    .line 86
    invoke-interface {v0, v7, v5, v6}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 87
    .line 88
    .line 89
    move-result-object v0

    .line 90
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 91
    .line 92
    .line 93
    sget-object v0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->config:Lcat/ereza/customactivityoncrash/config/CaocConfig;

    .line 94
    .line 95
    iget-object v0, v0, Lcat/ereza/customactivityoncrash/config/CaocConfig;->errorActivityClass:Ljava/lang/Class;

    .line 96
    .line 97
    const/16 v3, 0x40

    .line 98
    .line 99
    const/4 v5, 0x0

    .line 100
    if-nez v0, :cond_2

    .line 101
    .line 102
    sget-object v0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 103
    .line 104
    new-instance v6, Landroid/content/Intent;

    .line 105
    .line 106
    invoke-direct {v6}, Landroid/content/Intent;-><init>()V

    .line 107
    .line 108
    .line 109
    const-string v7, "cat.ereza.customactivityoncrash.ERROR"

    .line 110
    .line 111
    invoke-virtual {v6, v7}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 112
    .line 113
    .line 114
    move-result-object v6

    .line 115
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 116
    .line 117
    .line 118
    move-result-object v7

    .line 119
    invoke-virtual {v6, v7}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 120
    .line 121
    .line 122
    move-result-object v6

    .line 123
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 124
    .line 125
    .line 126
    move-result-object v0

    .line 127
    invoke-virtual {v0, v6, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    .line 128
    .line 129
    .line 130
    move-result-object v0

    .line 131
    invoke-interface {v0}, Ljava/util/List;->size()I

    .line 132
    .line 133
    .line 134
    move-result v6

    .line 135
    if-lez v6, :cond_1

    .line 136
    .line 137
    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 138
    .line 139
    .line 140
    move-result-object v0

    .line 141
    check-cast v0, Landroid/content/pm/ResolveInfo;

    .line 142
    .line 143
    :try_start_0
    iget-object v0, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 144
    .line 145
    iget-object v0, v0, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    .line 146
    .line 147
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 148
    .line 149
    .line 150
    move-result-object v0
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 151
    goto :goto_0

    .line 152
    :catch_0
    move-exception v0

    .line 153
    const-string v6, "Failed when resolving the error activity class via intent filter, stack trace follows!"

    .line 154
    .line 155
    invoke-static {v2, v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 156
    .line 157
    .line 158
    :cond_1
    move-object v0, v5

    .line 159
    :goto_0
    if-nez v0, :cond_2

    .line 160
    .line 161
    const-class v0, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;

    .line 162
    .line 163
    :cond_2
    :try_start_1
    new-instance v6, Ljava/io/BufferedReader;

    .line 164
    .line 165
    new-instance v7, Ljava/io/FileReader;

    .line 166
    .line 167
    const-string v8, "/proc/self/cmdline"

    .line 168
    .line 169
    invoke-direct {v7, v8}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    .line 170
    .line 171
    .line 172
    invoke-direct {v6, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 173
    .line 174
    .line 175
    invoke-virtual {v6}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    .line 176
    .line 177
    .line 178
    move-result-object v7

    .line 179
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    .line 180
    .line 181
    .line 182
    move-result-object v7

    .line 183
    invoke-virtual {v6}, Ljava/io/BufferedReader;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 184
    .line 185
    .line 186
    goto :goto_1

    .line 187
    :catch_1
    nop

    .line 188
    move-object v7, v5

    .line 189
    :goto_1
    if-eqz v7, :cond_3

    .line 190
    .line 191
    const-string v6, ":error_activity"

    .line 192
    .line 193
    invoke-virtual {v7, v6}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    .line 194
    .line 195
    .line 196
    move-result v6

    .line 197
    if-eqz v6, :cond_3

    .line 198
    .line 199
    goto :goto_3

    .line 200
    :cond_3
    move-object v6, p2

    .line 201
    :cond_4
    invoke-virtual {v6}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    .line 202
    .line 203
    .line 204
    move-result-object v7

    .line 205
    array-length v8, v7

    .line 206
    const/4 v9, 0x0

    .line 207
    :goto_2
    if-ge v9, v8, :cond_6

    .line 208
    .line 209
    aget-object v10, v7, v9

    .line 210
    .line 211
    invoke-virtual {v10}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    .line 212
    .line 213
    .line 214
    move-result-object v11

    .line 215
    const-string v12, "android.app.ActivityThread"

    .line 216
    .line 217
    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 218
    .line 219
    .line 220
    move-result v11

    .line 221
    if-eqz v11, :cond_5

    .line 222
    .line 223
    invoke-virtual {v10}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    .line 224
    .line 225
    .line 226
    move-result-object v10

    .line 227
    const-string v11, "handleBindApplication"

    .line 228
    .line 229
    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 230
    .line 231
    .line 232
    move-result v10

    .line 233
    if-eqz v10, :cond_5

    .line 234
    .line 235
    :goto_3
    const-string v0, "Your application class or your error activity have crashed, the custom activity will not be launched!"

    .line 236
    .line 237
    invoke-static {v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 238
    .line 239
    .line 240
    if-eqz v1, :cond_c

    .line 241
    .line 242
    invoke-interface {v1, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 243
    .line 244
    .line 245
    goto/16 :goto_6

    .line 246
    .line 247
    :cond_5
    add-int/lit8 v9, v9, 0x1

    .line 248
    .line 249
    goto :goto_2

    .line 250
    :cond_6
    invoke-virtual {v6}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    .line 251
    .line 252
    .line 253
    move-result-object v6

    .line 254
    if-nez v6, :cond_4

    .line 255
    .line 256
    sget-object p1, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 257
    .line 258
    new-instance p1, Landroid/content/Intent;

    .line 259
    .line 260
    sget-object v1, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 261
    .line 262
    invoke-direct {p1, v1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 263
    .line 264
    .line 265
    new-instance v0, Ljava/io/StringWriter;

    .line 266
    .line 267
    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 268
    .line 269
    .line 270
    new-instance v1, Ljava/io/PrintWriter;

    .line 271
    .line 272
    invoke-direct {v1, v0}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;)V

    .line 273
    .line 274
    .line 275
    invoke-virtual {p2, v1}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 276
    .line 277
    .line 278
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    .line 279
    .line 280
    .line 281
    move-result-object p2

    .line 282
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    .line 283
    .line 284
    .line 285
    move-result v0

    .line 286
    const v1, 0x1ffff

    .line 287
    .line 288
    .line 289
    if-le v0, v1, :cond_7

    .line 290
    .line 291
    new-instance v0, Ljava/lang/StringBuilder;

    .line 292
    .line 293
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 294
    .line 295
    .line 296
    const v1, 0x1ffe7

    .line 297
    .line 298
    .line 299
    invoke-virtual {p2, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 300
    .line 301
    .line 302
    move-result-object p2

    .line 303
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 304
    .line 305
    .line 306
    const-string p2, " [stack trace too large]"

    .line 307
    .line 308
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 309
    .line 310
    .line 311
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 312
    .line 313
    .line 314
    move-result-object p2

    .line 315
    :cond_7
    const-string v0, "cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE"

    .line 316
    .line 317
    invoke-virtual {p1, v0, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 318
    .line 319
    .line 320
    sget-object p2, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->config:Lcat/ereza/customactivityoncrash/config/CaocConfig;

    .line 321
    .line 322
    iget-object v0, p2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->restartActivityClass:Ljava/lang/Class;

    .line 323
    .line 324
    if-nez v0, :cond_b

    .line 325
    .line 326
    sget-object v0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 327
    .line 328
    new-instance v1, Landroid/content/Intent;

    .line 329
    .line 330
    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 331
    .line 332
    .line 333
    const-string v6, "cat.ereza.customactivityoncrash.RESTART"

    .line 334
    .line 335
    invoke-virtual {v1, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 336
    .line 337
    .line 338
    move-result-object v1

    .line 339
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 340
    .line 341
    .line 342
    move-result-object v6

    .line 343
    invoke-virtual {v1, v6}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 344
    .line 345
    .line 346
    move-result-object v1

    .line 347
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 348
    .line 349
    .line 350
    move-result-object v6

    .line 351
    invoke-virtual {v6, v1, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    .line 352
    .line 353
    .line 354
    move-result-object v1

    .line 355
    invoke-interface {v1}, Ljava/util/List;->size()I

    .line 356
    .line 357
    .line 358
    move-result v3

    .line 359
    if-lez v3, :cond_8

    .line 360
    .line 361
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 362
    .line 363
    .line 364
    move-result-object v1

    .line 365
    check-cast v1, Landroid/content/pm/ResolveInfo;

    .line 366
    .line 367
    :try_start_2
    iget-object v1, v1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 368
    .line 369
    iget-object v1, v1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    .line 370
    .line 371
    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 372
    .line 373
    .line 374
    move-result-object v1
    :try_end_2
    .catch Ljava/lang/ClassNotFoundException; {:try_start_2 .. :try_end_2} :catch_2

    .line 375
    goto :goto_4

    .line 376
    :catch_2
    move-exception v1

    .line 377
    const-string v3, "Failed when resolving the restart activity class via intent filter, stack trace follows!"

    .line 378
    .line 379
    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 380
    .line 381
    .line 382
    :cond_8
    move-object v1, v5

    .line 383
    :goto_4
    if-nez v1, :cond_a

    .line 384
    .line 385
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 386
    .line 387
    .line 388
    move-result-object v1

    .line 389
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 390
    .line 391
    .line 392
    move-result-object v0

    .line 393
    invoke-virtual {v1, v0}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 394
    .line 395
    .line 396
    move-result-object v0

    .line 397
    if-eqz v0, :cond_9

    .line 398
    .line 399
    invoke-virtual {v0}, Landroid/content/Intent;->getComponent()Landroid/content/ComponentName;

    .line 400
    .line 401
    .line 402
    move-result-object v1

    .line 403
    if-eqz v1, :cond_9

    .line 404
    .line 405
    :try_start_3
    invoke-virtual {v0}, Landroid/content/Intent;->getComponent()Landroid/content/ComponentName;

    .line 406
    .line 407
    .line 408
    move-result-object v0

    .line 409
    invoke-virtual {v0}, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;

    .line 410
    .line 411
    .line 412
    move-result-object v0

    .line 413
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 414
    .line 415
    .line 416
    move-result-object v5
    :try_end_3
    .catch Ljava/lang/ClassNotFoundException; {:try_start_3 .. :try_end_3} :catch_3

    .line 417
    goto :goto_5

    .line 418
    :catch_3
    move-exception v0

    .line 419
    const-string v1, "Failed when resolving the restart activity class via getLaunchIntentForPackage, stack trace follows!"

    .line 420
    .line 421
    invoke-static {v2, v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 422
    .line 423
    .line 424
    :cond_9
    :goto_5
    move-object v1, v5

    .line 425
    :cond_a
    iput-object v1, p2, Lcat/ereza/customactivityoncrash/config/CaocConfig;->restartActivityClass:Ljava/lang/Class;

    .line 426
    .line 427
    :cond_b
    const-string p2, "cat.ereza.customactivityoncrash.EXTRA_CONFIG"

    .line 428
    .line 429
    sget-object v0, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->config:Lcat/ereza/customactivityoncrash/config/CaocConfig;

    .line 430
    .line 431
    invoke-virtual {p1, p2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 432
    .line 433
    .line 434
    const p2, 0x10008000

    .line 435
    .line 436
    .line 437
    invoke-virtual {p1, p2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 438
    .line 439
    .line 440
    sget-object p2, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 441
    .line 442
    sget-object p2, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 443
    .line 444
    invoke-virtual {p2, p1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 445
    .line 446
    .line 447
    :cond_c
    sget-object p1, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->lastActivityCreated:Ljava/lang/ref/WeakReference;

    .line 448
    .line 449
    invoke-virtual {p1}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    .line 450
    .line 451
    .line 452
    move-result-object p1

    .line 453
    check-cast p1, Landroid/app/Activity;

    .line 454
    .line 455
    if-eqz p1, :cond_d

    .line 456
    .line 457
    invoke-virtual {p1}, Landroid/app/Activity;->finish()V

    .line 458
    .line 459
    .line 460
    sget-object p1, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->lastActivityCreated:Ljava/lang/ref/WeakReference;

    .line 461
    .line 462
    invoke-virtual {p1}, Ljava/lang/ref/Reference;->clear()V

    .line 463
    .line 464
    .line 465
    :cond_d
    invoke-static {}, Landroid/os/Process;->myPid()I

    .line 466
    .line 467
    .line 468
    move-result p1

    .line 469
    invoke-static {p1}, Landroid/os/Process;->killProcess(I)V

    .line 470
    .line 471
    .line 472
    const/16 p1, 0xa

    .line 473
    .line 474
    invoke-static {p1}, Ljava/lang/System;->exit(I)V

    .line 475
    .line 476
    .line 477
    goto :goto_6

    .line 478
    :cond_e
    if-eqz v1, :cond_f

    .line 479
    .line 480
    invoke-interface {v1, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 481
    .line 482
    .line 483
    :cond_f
    :goto_6
    return-void
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
