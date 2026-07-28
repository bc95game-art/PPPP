.class public final synthetic Lj$/util/i0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/PrimitiveIterator$OfInt;


# instance fields
.field public final synthetic a:Lj$/util/j0;


# direct methods
.method public synthetic constructor <init>(Lj$/util/j0;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lj$/util/i0;->a:Lj$/util/j0;

    return-void
.end method


# virtual methods
.method public final synthetic equals(Ljava/lang/Object;)Z
    .locals 2

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    instance-of v1, p1, Lj$/util/i0;

    if-eqz v1, :cond_0

    check-cast p1, Lj$/util/i0;

    iget-object p1, p1, Lj$/util/i0;->a:Lj$/util/j0;

    :cond_0
    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final synthetic forEachRemaining(Ljava/lang/Object;)V
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-interface {v0, p1}, Lj$/util/o0;->forEachRemaining(Ljava/lang/Object;)V

    return-void
.end method

.method public final synthetic forEachRemaining(Ljava/util/function/Consumer;)V
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-interface {v0, p1}, Lj$/util/j0;->forEachRemaining(Ljava/util/function/Consumer;)V

    return-void
.end method

.method public final synthetic forEachRemaining(Ljava/util/function/IntConsumer;)V
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-interface {v0, p1}, Lj$/util/j0;->forEachRemaining(Ljava/util/function/IntConsumer;)V

    return-void
.end method

.method public final synthetic hasNext()Z
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    return v0
.end method

.method public final synthetic hashCode()I
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public final synthetic next()Ljava/lang/Integer;
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-interface {v0}, Lj$/util/j0;->next()Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic next()Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic nextInt()I
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-interface {v0}, Lj$/util/j0;->nextInt()I

    move-result v0

    return v0
.end method

.method public final synthetic remove()V
    .locals 1

    iget-object v0, p0, Lj$/util/i0;->a:Lj$/util/j0;

    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    return-void
.end method
