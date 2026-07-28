.class public final Landroidx/core/view/ViewKt$allViews$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lkotlin/jvm/internal/FunctionBase;
.implements Lkotlin/Function;
.implements Lkotlin/coroutines/Continuation;
.implements Ljava/io/Serializable;


# instance fields
.field public final synthetic $this_allViews:Landroid/view/View;

.field public synthetic L$0:Lkotlin/sequences/SequenceBuilderIterator;

.field public final arity:I

.field public final completion:Lkotlin/coroutines/Continuation;

.field public label:I


# direct methods
.method public constructor <init>(Landroid/view/View;Lkotlin/sequences/SequenceBuilderIterator;)V
    .locals 0

    .line 1
    iput-object p1, p0, Landroidx/core/view/ViewKt$allViews$1;->$this_allViews:Landroid/view/View;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object p2, p0, Landroidx/core/view/ViewKt$allViews$1;->completion:Lkotlin/coroutines/Continuation;

    .line 7
    .line 8
    const/4 p1, 0x2

    .line 9
    iput p1, p0, Landroidx/core/view/ViewKt$allViews$1;->arity:I

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


# virtual methods
.method public final getArity()I
    .locals 1

    .line 1
    iget v0, p0, Landroidx/core/view/ViewKt$allViews$1;->arity:I

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

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 7

    .line 1
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    .line 2
    .line 3
    iget v1, p0, Landroidx/core/view/ViewKt$allViews$1;->label:I

    .line 4
    .line 5
    iget-object v2, p0, Landroidx/core/view/ViewKt$allViews$1;->$this_allViews:Landroid/view/View;

    .line 6
    .line 7
    const/4 v3, 0x1

    .line 8
    sget-object v4, Lkotlin/coroutines/intrinsics/CoroutineSingletons;->COROUTINE_SUSPENDED:Lkotlin/coroutines/intrinsics/CoroutineSingletons;

    .line 9
    .line 10
    if-eqz v1, :cond_7

    .line 11
    .line 12
    const/4 v5, 0x2

    .line 13
    if-eq v1, v3, :cond_2

    .line 14
    .line 15
    if-ne v1, v5, :cond_1

    .line 16
    .line 17
    instance-of v1, p1, Lkotlin/Result$Failure;

    .line 18
    .line 19
    if-nez v1, :cond_0

    .line 20
    .line 21
    goto :goto_2

    .line 22
    :cond_0
    check-cast p1, Lkotlin/Result$Failure;

    .line 23
    .line 24
    iget-object p1, p1, Lkotlin/Result$Failure;->exception:Ljava/lang/Throwable;

    .line 25
    .line 26
    throw p1

    .line 27
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 28
    .line 29
    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    .line 30
    .line 31
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
    throw p1

    .line 35
    :cond_2
    iget-object v1, p0, Landroidx/core/view/ViewKt$allViews$1;->L$0:Lkotlin/sequences/SequenceBuilderIterator;

    .line 36
    .line 37
    instance-of v3, p1, Lkotlin/Result$Failure;

    .line 38
    .line 39
    if-nez v3, :cond_6

    .line 40
    .line 41
    instance-of p1, v2, Landroid/view/ViewGroup;

    .line 42
    .line 43
    if-eqz p1, :cond_5

    .line 44
    .line 45
    check-cast v2, Landroid/view/ViewGroup;

    .line 46
    .line 47
    const/4 p1, 0x0

    .line 48
    iput-object p1, p0, Landroidx/core/view/ViewKt$allViews$1;->L$0:Lkotlin/sequences/SequenceBuilderIterator;

    .line 49
    .line 50
    iput v5, p0, Landroidx/core/view/ViewKt$allViews$1;->label:I

    .line 51
    .line 52
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 53
    .line 54
    .line 55
    new-instance p1, Landroidx/core/view/TreeIterator;

    .line 56
    .line 57
    new-instance v3, Lkotlin/jvm/internal/ArrayIterator;

    .line 58
    .line 59
    const/4 v6, 0x2

    .line 60
    invoke-direct {v3, v6, v2}, Lkotlin/jvm/internal/ArrayIterator;-><init>(ILjava/lang/Object;)V

    .line 61
    .line 62
    .line 63
    invoke-direct {p1, v3}, Landroidx/core/view/TreeIterator;-><init>(Lkotlin/jvm/internal/ArrayIterator;)V

    .line 64
    .line 65
    .line 66
    iget-object v2, p1, Landroidx/core/view/TreeIterator;->iterator:Ljava/util/Iterator;

    .line 67
    .line 68
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 69
    .line 70
    .line 71
    move-result v2

    .line 72
    if-nez v2, :cond_3

    .line 73
    .line 74
    move-object p1, v0

    .line 75
    goto :goto_0

    .line 76
    :cond_3
    iput-object p1, v1, Lkotlin/sequences/SequenceBuilderIterator;->nextIterator:Ljava/util/Iterator;

    .line 77
    .line 78
    iput v5, v1, Lkotlin/sequences/SequenceBuilderIterator;->state:I

    .line 79
    .line 80
    iput-object p0, v1, Lkotlin/sequences/SequenceBuilderIterator;->nextStep:Landroidx/core/view/ViewKt$allViews$1;

    .line 81
    .line 82
    move-object p1, v4

    .line 83
    :goto_0
    if-ne p1, v4, :cond_4

    .line 84
    .line 85
    goto :goto_1

    .line 86
    :cond_4
    move-object p1, v0

    .line 87
    :goto_1
    if-ne p1, v4, :cond_5

    .line 88
    .line 89
    return-object v4

    .line 90
    :cond_5
    :goto_2
    return-object v0

    .line 91
    :cond_6
    check-cast p1, Lkotlin/Result$Failure;

    .line 92
    .line 93
    iget-object p1, p1, Lkotlin/Result$Failure;->exception:Ljava/lang/Throwable;

    .line 94
    .line 95
    throw p1

    .line 96
    :cond_7
    instance-of v0, p1, Lkotlin/Result$Failure;

    .line 97
    .line 98
    if-nez v0, :cond_8

    .line 99
    .line 100
    iget-object p1, p0, Landroidx/core/view/ViewKt$allViews$1;->L$0:Lkotlin/sequences/SequenceBuilderIterator;

    .line 101
    .line 102
    iput-object p1, p0, Landroidx/core/view/ViewKt$allViews$1;->L$0:Lkotlin/sequences/SequenceBuilderIterator;

    .line 103
    .line 104
    iput v3, p0, Landroidx/core/view/ViewKt$allViews$1;->label:I

    .line 105
    .line 106
    iput-object v2, p1, Lkotlin/sequences/SequenceBuilderIterator;->nextValue:Ljava/lang/Object;

    .line 107
    .line 108
    const/4 v0, 0x3

    .line 109
    iput v0, p1, Lkotlin/sequences/SequenceBuilderIterator;->state:I

    .line 110
    .line 111
    iput-object p0, p1, Lkotlin/sequences/SequenceBuilderIterator;->nextStep:Landroidx/core/view/ViewKt$allViews$1;

    .line 112
    .line 113
    return-object v4

    .line 114
    :cond_8
    check-cast p1, Lkotlin/Result$Failure;

    .line 115
    .line 116
    iget-object p1, p1, Lkotlin/Result$Failure;->exception:Ljava/lang/Throwable;

    .line 117
    .line 118
    throw p1
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

.method public final resumeWith(Ljava/lang/Object;)V
    .locals 2

    .line 1
    move-object v0, p0

    .line 2
    :goto_0
    check-cast v0, Landroidx/core/view/ViewKt$allViews$1;

    .line 3
    .line 4
    iget-object v1, v0, Landroidx/core/view/ViewKt$allViews$1;->completion:Lkotlin/coroutines/Continuation;

    .line 5
    .line 6
    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 7
    .line 8
    .line 9
    :try_start_0
    invoke-virtual {v0, p1}, Landroidx/core/view/ViewKt$allViews$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    sget-object v0, Lkotlin/coroutines/intrinsics/CoroutineSingletons;->COROUTINE_SUSPENDED:Lkotlin/coroutines/intrinsics/CoroutineSingletons;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 14
    .line 15
    if-ne p1, v0, :cond_0

    .line 16
    .line 17
    return-void

    .line 18
    :catchall_0
    move-exception p1

    .line 19
    new-instance v0, Lkotlin/Result$Failure;

    .line 20
    .line 21
    invoke-direct {v0, p1}, Lkotlin/Result$Failure;-><init>(Ljava/lang/Throwable;)V

    .line 22
    .line 23
    .line 24
    move-object p1, v0

    .line 25
    :cond_0
    instance-of v0, v1, Landroidx/core/view/ViewKt$allViews$1;

    .line 26
    .line 27
    if-eqz v0, :cond_1

    .line 28
    .line 29
    move-object v0, v1

    .line 30
    goto :goto_0

    .line 31
    :cond_1
    invoke-interface {v1, p1}, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V

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

.method public final toString()Ljava/lang/String;
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/core/view/ViewKt$allViews$1;->completion:Lkotlin/coroutines/Continuation;

    .line 2
    .line 3
    if-nez v0, :cond_1

    .line 4
    .line 5
    sget-object v0, Lkotlin/jvm/internal/Reflection;->factory:Lkotlin/jvm/internal/ReflectionFactory;

    .line 6
    .line 7
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 8
    .line 9
    .line 10
    const-class v0, Landroidx/core/view/ViewKt$allViews$1;

    .line 11
    .line 12
    invoke-virtual {v0}, Ljava/lang/Class;->getGenericInterfaces()[Ljava/lang/reflect/Type;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    const/4 v1, 0x0

    .line 17
    aget-object v0, v0, v1

    .line 18
    .line 19
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    const-string v1, "kotlin.jvm.functions."

    .line 24
    .line 25
    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 26
    .line 27
    .line 28
    move-result v1

    .line 29
    if-eqz v1, :cond_0

    .line 30
    .line 31
    const/16 v1, 0x15

    .line 32
    .line 33
    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 34
    .line 35
    .line 36
    move-result-object v0

    .line 37
    :cond_0
    const-string v1, "renderLambdaToString(...)"

    .line 38
    .line 39
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 40
    .line 41
    .line 42
    return-object v0

    .line 43
    :cond_1
    invoke-virtual {p0}, Landroidx/core/view/ViewKt$allViews$1;->toString$kotlin$coroutines$jvm$internal$BaseContinuationImpl()Ljava/lang/String;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    return-object v0
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

.method public final toString$kotlin$coroutines$jvm$internal$BaseContinuationImpl()Ljava/lang/String;
    .locals 9

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "Continuation at "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 9
    .line 10
    .line 11
    move-result-object v1

    .line 12
    const-class v2, Lkotlin/coroutines/jvm/internal/DebugMetadata;

    .line 13
    .line 14
    invoke-virtual {v1, v2}, Ljava/lang/Class;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    check-cast v1, Lkotlin/coroutines/jvm/internal/DebugMetadata;

    .line 19
    .line 20
    const/4 v2, 0x0

    .line 21
    if-nez v1, :cond_0

    .line 22
    .line 23
    goto/16 :goto_b

    .line 24
    .line 25
    :cond_0
    invoke-interface {v1}, Lkotlin/coroutines/jvm/internal/DebugMetadata;->v()I

    .line 26
    .line 27
    .line 28
    move-result v3

    .line 29
    const/4 v4, 0x1

    .line 30
    if-gt v3, v4, :cond_e

    .line 31
    .line 32
    const/4 v3, -0x1

    .line 33
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 34
    .line 35
    .line 36
    move-result-object v5

    .line 37
    const-string v6, "label"

    .line 38
    .line 39
    invoke-virtual {v5, v6}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    .line 40
    .line 41
    .line 42
    move-result-object v5

    .line 43
    invoke-virtual {v5, v4}, Ljava/lang/reflect/AccessibleObject;->setAccessible(Z)V

    .line 44
    .line 45
    .line 46
    invoke-virtual {v5, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    .line 48
    .line 49
    move-result-object v5

    .line 50
    instance-of v6, v5, Ljava/lang/Integer;

    .line 51
    .line 52
    if-eqz v6, :cond_1

    .line 53
    .line 54
    check-cast v5, Ljava/lang/Integer;

    .line 55
    .line 56
    goto :goto_0

    .line 57
    :catch_0
    nop

    .line 58
    goto :goto_2

    .line 59
    :cond_1
    move-object v5, v2

    .line 60
    :goto_0
    if-eqz v5, :cond_2

    .line 61
    .line 62
    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    .line 63
    .line 64
    .line 65
    move-result v5
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    goto :goto_1

    .line 67
    :cond_2
    const/4 v5, 0x0

    .line 68
    :goto_1
    sub-int/2addr v5, v4

    .line 69
    goto :goto_3

    .line 70
    :goto_2
    const/4 v5, -0x1

    .line 71
    :goto_3
    if-gez v5, :cond_3

    .line 72
    .line 73
    goto :goto_4

    .line 74
    :cond_3
    invoke-interface {v1}, Lkotlin/coroutines/jvm/internal/DebugMetadata;->l()[I

    .line 75
    .line 76
    .line 77
    move-result-object v3

    .line 78
    aget v3, v3, v5

    .line 79
    .line 80
    :goto_4
    sget-object v4, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;->cache:Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;

    .line 81
    .line 82
    sget-object v5, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;->notOnJava9:Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;

    .line 83
    .line 84
    if-nez v4, :cond_4

    .line 85
    .line 86
    :try_start_1
    const-class v4, Ljava/lang/Class;

    .line 87
    .line 88
    const-string v6, "getModule"

    .line 89
    .line 90
    invoke-virtual {v4, v6, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    .line 91
    .line 92
    .line 93
    move-result-object v4

    .line 94
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 95
    .line 96
    .line 97
    move-result-object v6

    .line 98
    invoke-virtual {v6}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    .line 99
    .line 100
    .line 101
    move-result-object v6

    .line 102
    const-string v7, "java.lang.Module"

    .line 103
    .line 104
    invoke-virtual {v6, v7}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    .line 105
    .line 106
    .line 107
    move-result-object v6

    .line 108
    const-string v7, "getDescriptor"

    .line 109
    .line 110
    invoke-virtual {v6, v7, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    .line 111
    .line 112
    .line 113
    move-result-object v6

    .line 114
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 115
    .line 116
    .line 117
    move-result-object v7

    .line 118
    invoke-virtual {v7}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    .line 119
    .line 120
    .line 121
    move-result-object v7

    .line 122
    const-string v8, "java.lang.module.ModuleDescriptor"

    .line 123
    .line 124
    invoke-virtual {v7, v8}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    .line 125
    .line 126
    .line 127
    move-result-object v7

    .line 128
    const-string v8, "name"

    .line 129
    .line 130
    invoke-virtual {v7, v8, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    .line 131
    .line 132
    .line 133
    move-result-object v7

    .line 134
    new-instance v8, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;

    .line 135
    .line 136
    invoke-direct {v8, v4, v6, v7}, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;-><init>(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V

    .line 137
    .line 138
    .line 139
    sput-object v8, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;->cache:Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 140
    .line 141
    move-object v4, v8

    .line 142
    goto :goto_5

    .line 143
    :catch_1
    sput-object v5, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;->cache:Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;

    .line 144
    .line 145
    move-object v4, v5

    .line 146
    :cond_4
    :goto_5
    if-ne v4, v5, :cond_5

    .line 147
    .line 148
    goto :goto_9

    .line 149
    :cond_5
    iget-object v5, v4, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;->getModuleMethod:Ljava/lang/reflect/Method;

    .line 150
    .line 151
    if-eqz v5, :cond_6

    .line 152
    .line 153
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 154
    .line 155
    .line 156
    move-result-object v6

    .line 157
    invoke-virtual {v5, v6, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 158
    .line 159
    .line 160
    move-result-object v5

    .line 161
    goto :goto_6

    .line 162
    :cond_6
    move-object v5, v2

    .line 163
    :goto_6
    if-nez v5, :cond_7

    .line 164
    .line 165
    goto :goto_9

    .line 166
    :cond_7
    iget-object v6, v4, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;->getDescriptorMethod:Ljava/lang/reflect/Method;

    .line 167
    .line 168
    if-eqz v6, :cond_8

    .line 169
    .line 170
    invoke-virtual {v6, v5, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 171
    .line 172
    .line 173
    move-result-object v5

    .line 174
    goto :goto_7

    .line 175
    :cond_8
    move-object v5, v2

    .line 176
    :goto_7
    if-nez v5, :cond_9

    .line 177
    .line 178
    goto :goto_9

    .line 179
    :cond_9
    iget-object v4, v4, Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;->nameMethod:Ljava/lang/reflect/Method;

    .line 180
    .line 181
    if-eqz v4, :cond_a

    .line 182
    .line 183
    invoke-virtual {v4, v5, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    .line 185
    .line 186
    move-result-object v4

    .line 187
    goto :goto_8

    .line 188
    :cond_a
    move-object v4, v2

    .line 189
    :goto_8
    instance-of v5, v4, Ljava/lang/String;

    .line 190
    .line 191
    if-eqz v5, :cond_b

    .line 192
    .line 193
    move-object v2, v4

    .line 194
    check-cast v2, Ljava/lang/String;

    .line 195
    .line 196
    :cond_b
    :goto_9
    if-nez v2, :cond_c

    .line 197
    .line 198
    invoke-interface {v1}, Lkotlin/coroutines/jvm/internal/DebugMetadata;->c()Ljava/lang/String;

    .line 199
    .line 200
    .line 201
    move-result-object v2

    .line 202
    goto :goto_a

    .line 203
    :cond_c
    new-instance v4, Ljava/lang/StringBuilder;

    .line 204
    .line 205
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 206
    .line 207
    .line 208
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 209
    .line 210
    .line 211
    const/16 v2, 0x2f

    .line 212
    .line 213
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 214
    .line 215
    .line 216
    invoke-interface {v1}, Lkotlin/coroutines/jvm/internal/DebugMetadata;->c()Ljava/lang/String;

    .line 217
    .line 218
    .line 219
    move-result-object v2

    .line 220
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 221
    .line 222
    .line 223
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 224
    .line 225
    .line 226
    move-result-object v2

    .line 227
    :goto_a
    new-instance v4, Ljava/lang/StackTraceElement;

    .line 228
    .line 229
    invoke-interface {v1}, Lkotlin/coroutines/jvm/internal/DebugMetadata;->m()Ljava/lang/String;

    .line 230
    .line 231
    .line 232
    move-result-object v5

    .line 233
    invoke-interface {v1}, Lkotlin/coroutines/jvm/internal/DebugMetadata;->f()Ljava/lang/String;

    .line 234
    .line 235
    .line 236
    move-result-object v1

    .line 237
    invoke-direct {v4, v2, v5, v1, v3}, Ljava/lang/StackTraceElement;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 238
    .line 239
    .line 240
    move-object v2, v4

    .line 241
    :goto_b
    if-eqz v2, :cond_d

    .line 242
    .line 243
    goto :goto_c

    .line 244
    :cond_d
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 245
    .line 246
    .line 247
    move-result-object v1

    .line 248
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    .line 249
    .line 250
    .line 251
    move-result-object v2

    .line 252
    :goto_c
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 253
    .line 254
    .line 255
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 256
    .line 257
    .line 258
    move-result-object v0

    .line 259
    return-object v0

    .line 260
    :cond_e
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 261
    .line 262
    new-instance v1, Ljava/lang/StringBuilder;

    .line 263
    .line 264
    const-string v2, "Debug metadata version mismatch. Expected: 1, got "

    .line 265
    .line 266
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 267
    .line 268
    .line 269
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 270
    .line 271
    .line 272
    const-string v2, ". Please update the Kotlin standard library."

    .line 273
    .line 274
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 275
    .line 276
    .line 277
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 278
    .line 279
    .line 280
    move-result-object v1

    .line 281
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 282
    .line 283
    .line 284
    move-result-object v1

    .line 285
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 286
    .line 287
    .line 288
    throw v0
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
