.class public final Lj$/util/stream/n0;
.super Lj$/util/stream/p0;
.source "SourceFile"

# interfaces
.implements Lj$/util/stream/j5;


# instance fields
.field public final b:Ljava/util/function/LongConsumer;


# direct methods
.method public constructor <init>(Ljava/util/function/LongConsumer;Z)V
    .locals 0

    .line 214
    invoke-direct {p0, p2}, Lj$/util/stream/p0;-><init>(Z)V

    .line 215
    iput-object p1, p0, Lj$/util/stream/n0;->b:Ljava/util/function/LongConsumer;

    return-void
.end method


# virtual methods
.method public final accept(J)V
    .locals 1

    .line 225
    iget-object v0, p0, Lj$/util/stream/n0;->b:Ljava/util/function/LongConsumer;

    invoke-interface {v0, p1, p2}, Ljava/util/function/LongConsumer;->accept(J)V

    return-void
.end method

.method public final bridge synthetic accept(Ljava/lang/Object;)V
    .locals 0

    invoke-static {p0, p1}, Lj$/util/stream/u3;->J(Lj$/util/stream/j5;Ljava/lang/Object;)V

    return-void
.end method

.method public final synthetic andThen(Ljava/util/function/LongConsumer;)Ljava/util/function/LongConsumer;
    .locals 0

    invoke-static {p0, p1}, Lj$/util/function/g;->b(Ljava/util/function/LongConsumer;Ljava/util/function/LongConsumer;)Lj$/util/function/e;

    move-result-object p1

    return-object p1
.end method

.method public final f(Lj$/util/stream/a;Lj$/util/Spliterator;)Ljava/lang/Object;
    .locals 0

    .line 150
    invoke-virtual {p1, p2, p0}, Lj$/util/stream/a;->E0(Lj$/util/Spliterator;Lj$/util/stream/k5;)Lj$/util/stream/k5;

    const/4 p1, 0x0

    return-object p1
.end method

.method public final bridge synthetic get()Ljava/lang/Object;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public final bridge synthetic j(Lj$/util/stream/u3;Lj$/util/Spliterator;)Ljava/lang/Object;
    .locals 0

    .line 209
    invoke-virtual {p0, p1, p2}, Lj$/util/stream/p0;->a(Lj$/util/stream/u3;Lj$/util/Spliterator;)V

    const/4 p1, 0x0

    return-object p1
.end method

.method public final synthetic l(Ljava/lang/Long;)V
    .locals 0

    invoke-static {p0, p1}, Lj$/util/stream/u3;->I(Lj$/util/stream/j5;Ljava/lang/Long;)V

    return-void
.end method
