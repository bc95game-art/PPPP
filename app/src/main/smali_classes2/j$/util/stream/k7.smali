.class public final Lj$/util/stream/k7;
.super Lj$/util/stream/z6;
.source "SourceFile"

# interfaces
.implements Lj$/util/v0;


# virtual methods
.method public final d()V
    .locals 3

    .line 344
    new-instance v0, Lj$/util/stream/p6;

    .line 752
    invoke-direct {v0}, Lj$/util/stream/t6;-><init>()V

    .line 345
    iput-object v0, p0, Lj$/util/stream/z6;->h:Lj$/util/stream/c;

    .line 346
    invoke-static {v0}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lj$/util/stream/j7;

    const/4 v2, 0x1

    invoke-direct {v1, v0, v2}, Lj$/util/stream/j7;-><init>(Ljava/util/function/IntConsumer;I)V

    iget-object v0, p0, Lj$/util/stream/z6;->b:Lj$/util/stream/a;

    invoke-virtual {v0, v1}, Lj$/util/stream/a;->F0(Lj$/util/stream/k5;)Lj$/util/stream/k5;

    move-result-object v0

    iput-object v0, p0, Lj$/util/stream/z6;->e:Lj$/util/stream/k5;

    .line 347
    new-instance v0, Lj$/util/n;

    const/16 v1, 0xa

    invoke-direct {v0, v1, p0}, Lj$/util/n;-><init>(ILjava/lang/Object;)V

    iput-object v0, p0, Lj$/util/stream/z6;->f:Ljava/util/function/BooleanSupplier;

    return-void
.end method

.method public final e(Lj$/util/Spliterator;)Lj$/util/stream/z6;
    .locals 3

    .line 339
    new-instance v0, Lj$/util/stream/k7;

    iget-object v1, p0, Lj$/util/stream/z6;->b:Lj$/util/stream/a;

    iget-boolean v2, p0, Lj$/util/stream/z6;->a:Z

    .line 334
    invoke-direct {v0, v1, p1, v2}, Lj$/util/stream/z6;-><init>(Lj$/util/stream/a;Lj$/util/Spliterator;Z)V

    return-object v0
.end method

.method public final bridge synthetic forEachRemaining(Ljava/lang/Object;)V
    .locals 0

    .line 321
    check-cast p1, Ljava/util/function/IntConsumer;

    invoke-virtual {p0, p1}, Lj$/util/stream/k7;->forEachRemaining(Ljava/util/function/IntConsumer;)V

    return-void
.end method

.method public final synthetic forEachRemaining(Ljava/util/function/Consumer;)V
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->l(Lj$/util/v0;Ljava/util/function/Consumer;)V

    return-void
.end method

.method public final forEachRemaining(Ljava/util/function/IntConsumer;)V
    .locals 2

    .line 366
    iget-object v0, p0, Lj$/util/stream/z6;->h:Lj$/util/stream/c;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lj$/util/stream/z6;->i:Z

    if-nez v0, :cond_0

    .line 367
    invoke-static {p1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 368
    invoke-virtual {p0}, Lj$/util/stream/z6;->c()V

    .line 370
    invoke-static {p1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lj$/util/stream/j7;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lj$/util/stream/j7;-><init>(Ljava/util/function/IntConsumer;I)V

    iget-object p1, p0, Lj$/util/stream/z6;->d:Lj$/util/Spliterator;

    iget-object v1, p0, Lj$/util/stream/z6;->b:Lj$/util/stream/a;

    invoke-virtual {v1, p1, v0}, Lj$/util/stream/a;->E0(Lj$/util/Spliterator;Lj$/util/stream/k5;)Lj$/util/stream/k5;

    const/4 p1, 0x1

    .line 371
    iput-boolean p1, p0, Lj$/util/stream/z6;->i:Z

    return-void

    .line 374
    :cond_0
    invoke-virtual {p0, p1}, Lj$/util/stream/k7;->tryAdvance(Ljava/util/function/IntConsumer;)Z

    move-result v0

    if-nez v0, :cond_0

    return-void
.end method

.method public final bridge synthetic tryAdvance(Ljava/lang/Object;)Z
    .locals 0

    .line 321
    check-cast p1, Ljava/util/function/IntConsumer;

    invoke-virtual {p0, p1}, Lj$/util/stream/k7;->tryAdvance(Ljava/util/function/IntConsumer;)Z

    move-result p1

    return p1
.end method

.method public final synthetic tryAdvance(Ljava/util/function/Consumer;)Z
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->B(Lj$/util/v0;Ljava/util/function/Consumer;)Z

    move-result p1

    return p1
.end method

.method public final tryAdvance(Ljava/util/function/IntConsumer;)Z
    .locals 8

    .line 357
    invoke-static {p1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 358
    invoke-virtual {p0}, Lj$/util/stream/z6;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 360
    iget-object v1, p0, Lj$/util/stream/z6;->h:Lj$/util/stream/c;

    check-cast v1, Lj$/util/stream/p6;

    iget-wide v2, p0, Lj$/util/stream/z6;->g:J

    .line 802
    invoke-virtual {v1, v2, v3}, Lj$/util/stream/t6;->r(J)I

    move-result v4

    .line 803
    iget v5, v1, Lj$/util/stream/c;->c:I

    if-nez v5, :cond_0

    if-nez v4, :cond_0

    .line 804
    iget-object v1, v1, Lj$/util/stream/t6;->e:Ljava/lang/Object;

    check-cast v1, [I

    long-to-int v3, v2

    aget v1, v1, v3

    goto :goto_0

    .line 806
    :cond_0
    iget-object v5, v1, Lj$/util/stream/t6;->f:[Ljava/lang/Object;

    check-cast v5, [[I

    aget-object v5, v5, v4

    iget-object v1, v1, Lj$/util/stream/c;->d:[J

    aget-wide v6, v1, v4

    sub-long/2addr v2, v6

    long-to-int v1, v2

    aget v1, v5, v1

    .line 360
    :goto_0
    invoke-interface {p1, v1}, Ljava/util/function/IntConsumer;->accept(I)V

    :cond_1
    return v0
.end method

.method public final trySplit()Lj$/util/Spliterator;
    .locals 1

    .line 352
    invoke-super {p0}, Lj$/util/stream/z6;->trySplit()Lj$/util/Spliterator;

    move-result-object v0

    check-cast v0, Lj$/util/v0;

    return-object v0
.end method

.method public final trySplit()Lj$/util/b1;
    .locals 1

    .line 352
    invoke-super {p0}, Lj$/util/stream/z6;->trySplit()Lj$/util/Spliterator;

    move-result-object v0

    check-cast v0, Lj$/util/v0;

    return-object v0
.end method

.method public final trySplit()Lj$/util/v0;
    .locals 1

    .line 352
    invoke-super {p0}, Lj$/util/stream/z6;->trySplit()Lj$/util/Spliterator;

    move-result-object v0

    check-cast v0, Lj$/util/v0;

    return-object v0
.end method
