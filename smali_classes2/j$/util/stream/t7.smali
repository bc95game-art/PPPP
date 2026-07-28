.class public final Lj$/util/stream/t7;
.super Lj$/util/stream/w7;
.source "SourceFile"

# interfaces
.implements Lj$/util/s0;
.implements Ljava/util/function/DoubleConsumer;


# instance fields
.field public f:D


# virtual methods
.method public final accept(D)V
    .locals 0

    .line 1221
    iput-wide p1, p0, Lj$/util/stream/t7;->f:D

    return-void
.end method

.method public final synthetic andThen(Ljava/util/function/DoubleConsumer;)Ljava/util/function/DoubleConsumer;
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->e(Ljava/util/function/DoubleConsumer;Ljava/util/function/DoubleConsumer;)Lj$/util/function/b;

    move-result-object p1

    return-object p1
.end method

.method public final b(Lj$/util/Spliterator;)Lj$/util/Spliterator;
    .locals 1

    .line 1205
    check-cast p1, Lj$/util/s0;

    .line 1236
    new-instance v0, Lj$/util/stream/t7;

    .line 1081
    invoke-direct {v0, p1, p0}, Lj$/util/stream/z7;-><init>(Lj$/util/Spliterator;Lj$/util/stream/z7;)V

    return-object v0
.end method

.method public final synthetic forEachRemaining(Ljava/util/function/Consumer;)V
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->k(Lj$/util/s0;Ljava/util/function/Consumer;)V

    return-void
.end method

.method public final g(Ljava/lang/Object;)V
    .locals 2

    .line 1205
    check-cast p1, Ljava/util/function/DoubleConsumer;

    .line 1226
    iget-wide v0, p0, Lj$/util/stream/t7;->f:D

    invoke-interface {p1, v0, v1}, Ljava/util/function/DoubleConsumer;->accept(D)V

    return-void
.end method

.method public final j(I)Lj$/util/stream/d7;
    .locals 1

    .line 1231
    new-instance v0, Lj$/util/stream/a7;

    invoke-direct {v0, p1}, Lj$/util/stream/a7;-><init>(I)V

    return-object v0
.end method

.method public final synthetic tryAdvance(Ljava/util/function/Consumer;)Z
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->A(Lj$/util/s0;Ljava/util/function/Consumer;)Z

    move-result p1

    return p1
.end method
