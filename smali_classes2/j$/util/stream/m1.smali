.class public final Lj$/util/stream/m1;
.super Lj$/util/stream/q1;
.source "SourceFile"


# instance fields
.field public final synthetic c:Lj$/util/stream/r1;

.field public final synthetic d:Ljava/util/function/Predicate;


# direct methods
.method public constructor <init>(Lj$/util/stream/r1;Ljava/util/function/Predicate;)V
    .locals 0

    .line 84
    iput-object p1, p0, Lj$/util/stream/m1;->c:Lj$/util/stream/r1;

    iput-object p2, p0, Lj$/util/stream/m1;->d:Ljava/util/function/Predicate;

    .line 85
    invoke-direct {p0, p1}, Lj$/util/stream/q1;-><init>(Lj$/util/stream/r1;)V

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;)V
    .locals 2

    .line 90
    iget-boolean v0, p0, Lj$/util/stream/q1;->a:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lj$/util/stream/m1;->d:Ljava/util/function/Predicate;

    invoke-interface {v0, p1}, Ljava/util/function/Predicate;->test(Ljava/lang/Object;)Z

    move-result p1

    .line 0
    iget-object v0, p0, Lj$/util/stream/m1;->c:Lj$/util/stream/r1;

    iget-boolean v1, v0, Lj$/util/stream/r1;->a:Z

    if-ne p1, v1, :cond_0

    const/4 p1, 0x1

    .line 91
    iput-boolean p1, p0, Lj$/util/stream/q1;->a:Z

    .line 0
    iget-boolean p1, v0, Lj$/util/stream/r1;->b:Z

    .line 92
    iput-boolean p1, p0, Lj$/util/stream/q1;->b:Z

    :cond_0
    return-void
.end method
