.class public final Lj$/util/stream/m7;
.super Lj$/util/stream/z6;
.source "SourceFile"

# interfaces
.implements Lj$/util/y0;


# virtual methods
.method public final d()V
    .locals 3

    .line 402
    new-instance v0, Lj$/util/stream/r6;

    .line 865
    invoke-direct {v0}, Lj$/util/stream/t6;-><init>()V

    .line 403
    iput-object v0, p0, Lj$/util/stream/z6;->h:Lj$/util/stream/c;

    .line 404
    invoke-static {v0}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lj$/util/stream/l7;

    const/4 v2, 0x1

    invoke-direct {v1, v0, v2}, Lj$/util/stream/l7;-><init>(Ljava/util/function/LongConsumer;I)V

    iget-object v0, p0, Lj$/util/stream/z6;->b:Lj$/util/stream/a;

    invoke-virtual {v0, v1}, Lj$/util/stream/a;->F0(Lj$/util/stream/k5;)Lj$/util/stream/k5;

    move-result-object v0

    iput-object v0, p0, Lj$/util/stream/z6;->e:Lj$/util/stream/k5;

    .line 405
    new-instance v0, Lj$/util/n;

    const/16 v1, 0xb

    invoke-direct {v0, v1, p0}, Lj$/util/n;-><init>(ILjava/lang/Object;)V

    iput-object v0, p0, Lj$/util/stream/z6;->f:Ljava/util/function/BooleanSupplier;

    return-void
.end method

.method public final e(Lj$/util/Spliterator;)Lj$/util/stream/z6;
    .locals 3

    .line 397
    new-instance v0, Lj$/util/stream/m7;

    iget-object v1, p0, Lj$/util/stream/z6;->b:Lj$/util/stream/a;

    iget-boolean v2, p0, Lj$/util/stream/z6;->a:Z

    .line 392
    invoke-direct {v0, v1, p1, v2}, Lj$/util/stream/z6;-><init>(Lj$/util/stream/a;Lj$/util/Spliterator;Z)V

    return-object v0
.end method

.method public final bridge synthetic forEachRemaining(Ljava/lang/Object;)V
    .locals 0

    .line 379
    check-cast p1, Ljava/util/function/LongConsumer;

    invoke-virtual {p0, p1}, Lj$/util/stream/m7;->forEachRemaining(Ljava/util/function/LongConsumer;)V

    return-void
.end method

.method public final synthetic forEachRemaining(Ljava/util/function/Consumer;)V
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->m(Lj$/util/y0;Ljava/util/function/Consumer;)V

    return-void
.end method

.method public final forEachRemaining(Ljava/util/function/LongConsumer;)V
    .locals 2

    .line 424
    iget-object v0, p0, Lj$/util/stream/z6;->h:Lj$/util/stream/c;

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lj$/util/stream/z6;->i:Z

    if-nez v0, :cond_0

    .line 425
    invoke-static {p1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 426
    invoke-virtual {p0}, Lj$/util/stream/z6;->c()V

    .line 428
    invoke-static {p1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lj$/util/stream/l7;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lj$/util/stream/l7;-><init>(Ljava/util/function/LongConsumer;I)V

    iget-object p1, p0, Lj$/util/stream/z6;->d:Lj$/util/Spliterator;

    iget-object v1, p0, Lj$/util/stream/z6;->b:Lj$/util/stream/a;

    invoke-virtual {v1, p1, v0}, Lj$/util/stream/a;->E0(Lj$/util/Spliterator;Lj$/util/stream/k5;)Lj$/util/stream/k5;

    const/4 p1, 0x1

    .line 429
    iput-boolean p1, p0, Lj$/util/stream/z6;->i:Z

    return-void

    .line 432
    :cond_0
    invoke-virtual {p0, p1}, Lj$/util/stream/m7;->tryAdvance(Ljava/util/function/LongConsumer;)Z

    move-result v0

    if-nez v0, :cond_0

    return-void
.end method

.method public final bridge synthetic tryAdvance(Ljava/lang/Object;)Z
    .locals 0

    .line 379
    check-cast p1, Ljava/util/function/LongConsumer;

    invoke-virtual {p0, p1}, Lj$/util/stream/m7;->tryAdvance(Ljava/util/function/LongConsumer;)Z

    move-result p1

    return p1
.end method

.method public final synthetic tryAdvance(Ljava/util/function/Consumer;)Z
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->C(Lj$/util/y0;Ljava/util/function/Consumer;)Z

    move-result p1

    return p1
.end method

.method public final tryAdvance(Ljava/util/function/LongConsumer;)Z
    .locals 8

    .line 415
    invoke-static {p1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 416
    invoke-virtual {p0}, Lj$/util/stream/z6;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 418
    iget-object v1, p0, Lj$/util/stream/z6;->h:Lj$/util/stream/c;

    check-cast v1, Lj$/util/stream/r6;

    iget-wide v2, p0, Lj$/util/stream/z6;->g:J

    .line 915
    invoke-virtual {v1, v2, v3}, Lj$/util/stream/t6;->r(J)I

    move-result v4

    .line 916
    iget v5, v1, Lj$/util/stream/c;->c:I

    if-nez v5, :cond_0

    if-nez v4, :cond_0

    .line 917
    iget-object v1, v1, Lj$/util/stream/t6;->e:Ljava/lang/Object;

    check-cast v1, [J

    long-to-int v3, v2

    aget-wide v2, v1, v3

    goto :goto_0

    .line 919
    :cond_0
    iget-object v5, v1, Lj$/util/stream/t6;->f:[Ljava/lang/Object;

    check-cast v5, [[J

    aget-object v5, v5, v4

    iget-object v1, v1, Lj$/util/stream/c;->d:[J

    aget-wide v6, v1, v4

    sub-long/2addr v2, v6

    long-to-int v1, v2

    aget-wide v2, v5, v1

    .line 418
    :goto_0
    invoke-interface {p1, v2, v3}, Ljava/util/function/LongConsumer;->accept(J)V

    :cond_1
    return v0
.end method

.method public final trySplit()Lj$/util/Spliterator;
    .locals 1

    .line 410
    invoke-super {p0}, Lj$/util/stream/z6;->trySplit()Lj$/util/Spliterator;

    move-result-object v0

    check-cast v0, Lj$/util/y0;

    return-object v0
.end method

.method public final trySplit()Lj$/util/b1;
    .locals 1

    .line 410
    invoke-super {p0}, Lj$/util/stream/z6;->trySplit()Lj$/util/Spliterator;

    move-result-object v0

    check-cast v0, Lj$/util/y0;

    return-object v0
.end method

.method public final trySplit()Lj$/util/y0;
    .locals 1

    .line 410
    invoke-super {p0}, Lj$/util/stream/z6;->trySplit()Lj$/util/Spliterator;

    move-result-object v0

    check-cast v0, Lj$/util/y0;

    return-object v0
.end method
