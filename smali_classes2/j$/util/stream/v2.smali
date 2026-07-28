.class public final Lj$/util/stream/v2;
.super Lj$/util/stream/y2;
.source "SourceFile"

# interfaces
.implements Lj$/util/stream/a2;


# virtual methods
.method public final a(I)Lj$/util/stream/d2;
    .locals 0

    .line 253
    new-instance p1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {p1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw p1
.end method

.method public final bridge synthetic a(I)Lj$/util/stream/e2;
    .locals 0

    .line 227
    invoke-virtual {p0, p1}, Lj$/util/stream/v2;->a(I)Lj$/util/stream/d2;

    const/4 p1, 0x0

    throw p1
.end method

.method public final bridge synthetic b()Ljava/lang/Object;
    .locals 1

    .line 593
    sget-object v0, Lj$/util/stream/u3;->e:[I

    return-object v0
.end method

.method public final synthetic forEach(Ljava/util/function/Consumer;)V
    .locals 0

    invoke-static {p0, p1}, Lj$/util/stream/u3;->R(Lj$/util/stream/a2;Ljava/util/function/Consumer;)V

    return-void
.end method

.method public final synthetic j(JJLjava/util/function/IntFunction;)Lj$/util/stream/e2;
    .locals 0

    .line 0
    invoke-static {p0, p1, p2, p3, p4}, Lj$/util/stream/u3;->U(Lj$/util/stream/a2;JJ)Lj$/util/stream/a2;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic k([Ljava/lang/Object;I)V
    .locals 0

    .line 317
    check-cast p1, [Ljava/lang/Integer;

    .line 0
    invoke-static {p0, p1, p2}, Lj$/util/stream/u3;->O(Lj$/util/stream/a2;[Ljava/lang/Integer;I)V

    return-void
.end method

.method public final bridge synthetic spliterator()Lj$/util/Spliterator;
    .locals 1

    .line 593
    sget-object v0, Lj$/util/Spliterators;->b:Lj$/util/k1;

    return-object v0
.end method

.method public final bridge synthetic spliterator()Lj$/util/b1;
    .locals 1

    .line 593
    sget-object v0, Lj$/util/Spliterators;->b:Lj$/util/k1;

    return-object v0
.end method
