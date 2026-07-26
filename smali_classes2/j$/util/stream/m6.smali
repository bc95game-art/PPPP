.class public final Lj$/util/stream/m6;
.super Lj$/util/stream/s6;
.source "SourceFile"

# interfaces
.implements Lj$/util/s0;


# instance fields
.field public final synthetic g:Lj$/util/stream/n6;


# direct methods
.method public constructor <init>(Lj$/util/stream/n6;IIII)V
    .locals 0

    .line 1046
    iput-object p1, p0, Lj$/util/stream/m6;->g:Lj$/util/stream/n6;

    .line 1047
    invoke-direct/range {p0 .. p5}, Lj$/util/stream/s6;-><init>(Lj$/util/stream/t6;IIII)V

    return-void
.end method


# virtual methods
.method public final a(ILjava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .line 1043
    check-cast p2, [D

    check-cast p3, Ljava/util/function/DoubleConsumer;

    .line 1060
    aget-wide p1, p2, p1

    invoke-interface {p3, p1, p2}, Ljava/util/function/DoubleConsumer;->accept(D)V

    return-void
.end method

.method public final b(Ljava/lang/Object;II)Lj$/util/b1;
    .locals 2

    .line 1043
    check-cast p1, [D

    add-int/2addr p3, p2

    .line 371
    invoke-static {p1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [D

    array-length v0, v0

    invoke-static {v0, p2, p3}, Lj$/util/Spliterators;->a(III)V

    .line 372
    new-instance v0, Lj$/util/i1;

    const/16 v1, 0x410

    invoke-direct {v0, p1, p2, p3, v1}, Lj$/util/i1;-><init>([DIII)V

    return-object v0
.end method

.method public final c(IIII)Lj$/util/b1;
    .locals 6

    .line 1054
    new-instance v0, Lj$/util/stream/m6;

    iget-object v1, p0, Lj$/util/stream/m6;->g:Lj$/util/stream/n6;

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lj$/util/stream/m6;-><init>(Lj$/util/stream/n6;IIII)V

    return-object v0
.end method

.method public final synthetic forEachRemaining(Ljava/util/function/Consumer;)V
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->k(Lj$/util/s0;Ljava/util/function/Consumer;)V

    return-void
.end method

.method public final synthetic tryAdvance(Ljava/util/function/Consumer;)Z
    .locals 0

    invoke-static {p0, p1}, Lj$/com/android/tools/r8/a;->A(Lj$/util/s0;Ljava/util/function/Consumer;)Z

    move-result p1

    return p1
.end method
