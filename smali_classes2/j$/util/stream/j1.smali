.class public final synthetic Lj$/util/stream/j1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/stream/LongStream;


# instance fields
.field public final synthetic a:Lj$/util/stream/k1;


# direct methods
.method public synthetic constructor <init>(Lj$/util/stream/k1;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    return-void
.end method

.method public static synthetic f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;
    .locals 1

    if-nez p0, :cond_0

    const/4 p0, 0x0

    return-object p0

    :cond_0
    instance-of v0, p0, Lj$/util/stream/i1;

    if-eqz v0, :cond_1

    check-cast p0, Lj$/util/stream/i1;

    iget-object p0, p0, Lj$/util/stream/i1;->a:Ljava/util/stream/LongStream;

    return-object p0

    :cond_1
    new-instance v0, Lj$/util/stream/j1;

    invoke-direct {v0, p0}, Lj$/util/stream/j1;-><init>(Lj$/util/stream/k1;)V

    return-object v0
.end method


# virtual methods
.method public final synthetic allMatch(Ljava/util/function/LongPredicate;)Z
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->x()Z

    move-result p1

    return p1
.end method

.method public final synthetic anyMatch(Ljava/util/function/LongPredicate;)Z
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->r()Z

    move-result p1

    return p1
.end method

.method public final synthetic asDoubleStream()Ljava/util/stream/DoubleStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->asDoubleStream()Lj$/util/stream/b0;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/a0;->f(Lj$/util/stream/b0;)Ljava/util/stream/DoubleStream;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic average()Ljava/util/OptionalDouble;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->average()Lj$/util/z;

    move-result-object v0

    invoke-static {v0}, Lj$/com/android/tools/r8/a;->I(Lj$/util/z;)Ljava/util/OptionalDouble;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic boxed()Ljava/util/stream/Stream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->boxed()Lj$/util/stream/Stream;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/Stream$Wrapper;->convert(Lj$/util/stream/Stream;)Ljava/util/stream/Stream;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic close()V
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Ljava/lang/AutoCloseable;->close()V

    return-void
.end method

.method public final synthetic collect(Ljava/util/function/Supplier;Ljava/util/function/ObjLongConsumer;Ljava/util/function/BiConsumer;)Ljava/lang/Object;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1, p2, p3}, Lj$/util/stream/k1;->collect(Ljava/util/function/Supplier;Ljava/util/function/ObjLongConsumer;Ljava/util/function/BiConsumer;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic count()J
    .locals 2

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->count()J

    move-result-wide v0

    return-wide v0
.end method

.method public final synthetic distinct()Ljava/util/stream/LongStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->distinct()Lj$/util/stream/k1;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic dropWhile(Ljava/util/function/LongPredicate;)Ljava/util/stream/LongStream;
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->c()Lj$/util/stream/k1;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic equals(Ljava/lang/Object;)Z
    .locals 2

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    instance-of v1, p1, Lj$/util/stream/j1;

    if-eqz v1, :cond_0

    check-cast p1, Lj$/util/stream/j1;

    iget-object p1, p1, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    :cond_0
    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public final synthetic filter(Ljava/util/function/LongPredicate;)Ljava/util/stream/LongStream;
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->b()Lj$/util/stream/k1;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic findAny()Ljava/util/OptionalLong;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->findAny()Lj$/util/b0;

    move-result-object v0

    invoke-static {v0}, Lj$/com/android/tools/r8/a;->K(Lj$/util/b0;)Ljava/util/OptionalLong;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic findFirst()Ljava/util/OptionalLong;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->findFirst()Lj$/util/b0;

    move-result-object v0

    invoke-static {v0}, Lj$/com/android/tools/r8/a;->K(Lj$/util/b0;)Ljava/util/OptionalLong;

    move-result-object v0

    return-object v0
.end method

.method public final flatMap(Ljava/util/function/LongFunction;)Ljava/util/stream/LongStream;
    .locals 3

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    .line 29
    new-instance v1, Lj$/util/n;

    const/4 v2, 0x6

    .line 145
    invoke-direct {v1, v2}, Lj$/util/n;-><init>(I)V

    .line 146
    iput-object p1, v1, Lj$/util/n;->b:Ljava/lang/Object;

    .line 0
    invoke-interface {v0, v1}, Lj$/util/stream/k1;->d(Lj$/util/n;)Lj$/util/stream/k1;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic forEach(Ljava/util/function/LongConsumer;)V
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1}, Lj$/util/stream/k1;->forEach(Ljava/util/function/LongConsumer;)V

    return-void
.end method

.method public final synthetic forEachOrdered(Ljava/util/function/LongConsumer;)V
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1}, Lj$/util/stream/k1;->forEachOrdered(Ljava/util/function/LongConsumer;)V

    return-void
.end method

.method public final synthetic hashCode()I
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public final synthetic isParallel()Z
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/g;->isParallel()Z

    move-result v0

    return v0
.end method

.method public final synthetic iterator()Ljava/util/Iterator;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/g;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic iterator()Ljava/util/PrimitiveIterator$OfLong;
    .locals 2

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->iterator()Lj$/util/n0;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    return-object v0

    .line 0
    :cond_0
    instance-of v1, v0, Lj$/util/l0;

    if-eqz v1, :cond_1

    check-cast v0, Lj$/util/l0;

    iget-object v0, v0, Lj$/util/l0;->a:Ljava/util/PrimitiveIterator$OfLong;

    return-object v0

    :cond_1
    new-instance v1, Lj$/util/m0;

    invoke-direct {v1, v0}, Lj$/util/m0;-><init>(Lj$/util/n0;)V

    return-object v1
.end method

.method public final synthetic limit(J)Ljava/util/stream/LongStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1, p2}, Lj$/util/stream/k1;->limit(J)Lj$/util/stream/k1;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic map(Ljava/util/function/LongUnaryOperator;)Ljava/util/stream/LongStream;
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->e()Lj$/util/stream/k1;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic mapToDouble(Ljava/util/function/LongToDoubleFunction;)Ljava/util/stream/DoubleStream;
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->k()Lj$/util/stream/b0;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/a0;->f(Lj$/util/stream/b0;)Ljava/util/stream/DoubleStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic mapToInt(Ljava/util/function/LongToIntFunction;)Ljava/util/stream/IntStream;
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->B()Lj$/util/stream/IntStream;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/IntStream$Wrapper;->convert(Lj$/util/stream/IntStream;)Ljava/util/stream/IntStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic mapToObj(Ljava/util/function/LongFunction;)Ljava/util/stream/Stream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1}, Lj$/util/stream/k1;->mapToObj(Ljava/util/function/LongFunction;)Lj$/util/stream/Stream;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/Stream$Wrapper;->convert(Lj$/util/stream/Stream;)Ljava/util/stream/Stream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic max()Ljava/util/OptionalLong;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->max()Lj$/util/b0;

    move-result-object v0

    invoke-static {v0}, Lj$/com/android/tools/r8/a;->K(Lj$/util/b0;)Ljava/util/OptionalLong;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic min()Ljava/util/OptionalLong;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->min()Lj$/util/b0;

    move-result-object v0

    invoke-static {v0}, Lj$/com/android/tools/r8/a;->K(Lj$/util/b0;)Ljava/util/OptionalLong;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic noneMatch(Ljava/util/function/LongPredicate;)Z
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->n()Z

    move-result p1

    return p1
.end method

.method public final synthetic onClose(Ljava/lang/Runnable;)Ljava/util/stream/BaseStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1}, Lj$/util/stream/g;->onClose(Ljava/lang/Runnable;)Lj$/util/stream/g;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/f;->f(Lj$/util/stream/g;)Ljava/util/stream/BaseStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic parallel()Ljava/util/stream/BaseStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/g;->parallel()Lj$/util/stream/g;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/f;->f(Lj$/util/stream/g;)Ljava/util/stream/BaseStream;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic parallel()Ljava/util/stream/LongStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->parallel()Lj$/util/stream/k1;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic peek(Ljava/util/function/LongConsumer;)Ljava/util/stream/LongStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1}, Lj$/util/stream/k1;->peek(Ljava/util/function/LongConsumer;)Lj$/util/stream/k1;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic reduce(JLjava/util/function/LongBinaryOperator;)J
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1, p2, p3}, Lj$/util/stream/k1;->reduce(JLjava/util/function/LongBinaryOperator;)J

    move-result-wide p1

    return-wide p1
.end method

.method public final synthetic reduce(Ljava/util/function/LongBinaryOperator;)Ljava/util/OptionalLong;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1}, Lj$/util/stream/k1;->reduce(Ljava/util/function/LongBinaryOperator;)Lj$/util/b0;

    move-result-object p1

    invoke-static {p1}, Lj$/com/android/tools/r8/a;->K(Lj$/util/b0;)Ljava/util/OptionalLong;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic sequential()Ljava/util/stream/BaseStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/g;->sequential()Lj$/util/stream/g;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/f;->f(Lj$/util/stream/g;)Ljava/util/stream/BaseStream;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic sequential()Ljava/util/stream/LongStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->sequential()Lj$/util/stream/k1;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic skip(J)Ljava/util/stream/LongStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0, p1, p2}, Lj$/util/stream/k1;->skip(J)Lj$/util/stream/k1;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic sorted()Ljava/util/stream/LongStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->sorted()Lj$/util/stream/k1;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic spliterator()Ljava/util/Spliterator$OfLong;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->spliterator()Lj$/util/y0;

    move-result-object v0

    invoke-static {v0}, Lj$/util/x0;->a(Lj$/util/y0;)Ljava/util/Spliterator$OfLong;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic spliterator()Ljava/util/Spliterator;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/g;->spliterator()Lj$/util/Spliterator;

    move-result-object v0

    invoke-static {v0}, Lj$/util/Spliterator$Wrapper;->convert(Lj$/util/Spliterator;)Ljava/util/Spliterator;

    move-result-object v0

    return-object v0
.end method

.method public final synthetic sum()J
    .locals 2

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->sum()J

    move-result-wide v0

    return-wide v0
.end method

.method public final summaryStatistics()Ljava/util/LongSummaryStatistics;
    .locals 2

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->summaryStatistics()Lj$/util/x;

    .line 12
    new-instance v0, Ljava/lang/Error;

    const-string v1, "Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics"

    invoke-direct {v0, v1}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final synthetic takeWhile(Ljava/util/function/LongPredicate;)Ljava/util/stream/LongStream;
    .locals 0

    iget-object p1, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {p1}, Lj$/util/stream/k1;->a()Lj$/util/stream/k1;

    move-result-object p1

    invoke-static {p1}, Lj$/util/stream/j1;->f(Lj$/util/stream/k1;)Ljava/util/stream/LongStream;

    move-result-object p1

    return-object p1
.end method

.method public final synthetic toArray()[J
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/k1;->toArray()[J

    move-result-object v0

    return-object v0
.end method

.method public final synthetic unordered()Ljava/util/stream/BaseStream;
    .locals 1

    iget-object v0, p0, Lj$/util/stream/j1;->a:Lj$/util/stream/k1;

    invoke-interface {v0}, Lj$/util/stream/g;->unordered()Lj$/util/stream/g;

    move-result-object v0

    invoke-static {v0}, Lj$/util/stream/f;->f(Lj$/util/stream/g;)Ljava/util/stream/BaseStream;

    move-result-object v0

    return-object v0
.end method
