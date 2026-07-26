.class public final Lj$/util/stream/m;
.super Lj$/util/stream/a5;
.source "SourceFile"


# direct methods
.method public static T0(Lj$/util/stream/u3;Lj$/util/Spliterator;)Lj$/util/stream/j2;
    .locals 6

    .line 62
    new-instance v4, Lj$/time/format/b;

    const/16 v0, 0xc

    .line 0
    invoke-direct {v4, v0}, Lj$/time/format/b;-><init>(I)V

    .line 62
    new-instance v3, Lj$/time/format/b;

    const/16 v0, 0xd

    .line 0
    invoke-direct {v3, v0}, Lj$/time/format/b;-><init>(I)V

    .line 62
    new-instance v2, Lj$/time/format/b;

    const/16 v0, 0xe

    .line 0
    invoke-direct {v2, v0}, Lj$/time/format/b;-><init>(I)V

    .line 208
    invoke-static {v4}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 209
    invoke-static {v3}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 210
    invoke-static {v2}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 228
    new-instance v0, Lj$/util/stream/z3;

    sget-object v1, Lj$/util/stream/y6;->REFERENCE:Lj$/util/stream/y6;

    const/4 v5, 0x3

    invoke-direct/range {v0 .. v5}, Lj$/util/stream/z3;-><init>(Lj$/util/stream/y6;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;I)V

    .line 65
    invoke-virtual {v0, p0, p1}, Lj$/util/stream/u3;->j(Lj$/util/stream/u3;Lj$/util/Spliterator;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/util/Collection;

    .line 161
    new-instance p1, Lj$/util/stream/j2;

    invoke-direct {p1, p0}, Lj$/util/stream/j2;-><init>(Ljava/util/Collection;)V

    return-object p1
.end method


# virtual methods
.method public final M0(Lj$/util/stream/u3;Lj$/util/Spliterator;Ljava/util/function/IntFunction;)Lj$/util/stream/e2;
    .locals 4

    .line 72
    sget-object v0, Lj$/util/stream/x6;->DISTINCT:Lj$/util/stream/x6;

    move-object v1, p1

    check-cast v1, Lj$/util/stream/a;

    .line 509
    iget v2, v1, Lj$/util/stream/a;->m:I

    .line 72
    invoke-virtual {v0, v2}, Lj$/util/stream/x6;->l(I)Z

    move-result v0

    const/4 v2, 0x0

    if-eqz v0, :cond_0

    .line 74
    invoke-virtual {p1, p2, v2, p3}, Lj$/util/stream/u3;->k0(Lj$/util/Spliterator;ZLjava/util/function/IntFunction;)Lj$/util/stream/e2;

    move-result-object p1

    return-object p1

    .line 76
    :cond_0
    sget-object p3, Lj$/util/stream/x6;->ORDERED:Lj$/util/stream/x6;

    .line 509
    iget v0, v1, Lj$/util/stream/a;->m:I

    .line 76
    invoke-virtual {p3, v0}, Lj$/util/stream/x6;->l(I)Z

    move-result p3

    if-eqz p3, :cond_1

    .line 77
    invoke-static {p1, p2}, Lj$/util/stream/m;->T0(Lj$/util/stream/u3;Lj$/util/Spliterator;)Lj$/util/stream/j2;

    move-result-object p1

    return-object p1

    .line 81
    :cond_1
    new-instance p3, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p3, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    .line 82
    new-instance v0, Lj$/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Lj$/util/concurrent/ConcurrentHashMap;-><init>()V

    .line 83
    new-instance v1, Lj$/util/concurrent/t;

    const/4 v3, 0x4

    invoke-direct {v1, v3, p3, v0}, Lj$/util/concurrent/t;-><init>(ILjava/lang/Object;Ljava/lang/Object;)V

    .line 71
    invoke-static {v1}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    new-instance v3, Lj$/util/stream/o0;

    invoke-direct {v3, v1, v2}, Lj$/util/stream/o0;-><init>(Ljava/util/function/Consumer;Z)V

    .line 173
    invoke-virtual {v3, p1, p2}, Lj$/util/stream/p0;->a(Lj$/util/stream/u3;Lj$/util/Spliterator;)V

    .line 94
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object p1

    .line 95
    invoke-virtual {p3}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result p2

    if-eqz p2, :cond_2

    .line 97
    new-instance p2, Ljava/util/HashSet;

    invoke-direct {p2, p1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    const/4 p1, 0x0

    .line 98
    invoke-virtual {p2, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    move-object p1, p2

    .line 161
    :cond_2
    new-instance p2, Lj$/util/stream/j2;

    invoke-direct {p2, p1}, Lj$/util/stream/j2;-><init>(Ljava/util/Collection;)V

    return-object p2
.end method

.method public final N0(Lj$/util/stream/a;Lj$/util/Spliterator;)Lj$/util/Spliterator;
    .locals 2

    .line 106
    sget-object v0, Lj$/util/stream/x6;->DISTINCT:Lj$/util/stream/x6;

    .line 509
    iget v1, p1, Lj$/util/stream/a;->m:I

    .line 106
    invoke-virtual {v0, v1}, Lj$/util/stream/x6;->l(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 108
    invoke-virtual {p1, p2}, Lj$/util/stream/a;->G0(Lj$/util/Spliterator;)Lj$/util/Spliterator;

    move-result-object p1

    return-object p1

    .line 110
    :cond_0
    sget-object v0, Lj$/util/stream/x6;->ORDERED:Lj$/util/stream/x6;

    .line 509
    iget v1, p1, Lj$/util/stream/a;->m:I

    .line 110
    invoke-virtual {v0, v1}, Lj$/util/stream/x6;->l(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 112
    invoke-static {p1, p2}, Lj$/util/stream/m;->T0(Lj$/util/stream/u3;Lj$/util/Spliterator;)Lj$/util/stream/j2;

    move-result-object p1

    invoke-virtual {p1}, Lj$/util/stream/j2;->spliterator()Lj$/util/Spliterator;

    move-result-object p1

    return-object p1

    .line 116
    :cond_1
    new-instance v0, Lj$/util/stream/g7;

    invoke-virtual {p1, p2}, Lj$/util/stream/a;->G0(Lj$/util/Spliterator;)Lj$/util/Spliterator;

    move-result-object p1

    .line 1260
    new-instance p2, Lj$/util/concurrent/ConcurrentHashMap;

    invoke-direct {p2}, Lj$/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-direct {v0, p1, p2}, Lj$/util/stream/g7;-><init>(Lj$/util/Spliterator;Lj$/util/concurrent/ConcurrentHashMap;)V

    return-object v0
.end method

.method public final P0(ILj$/util/stream/k5;)Lj$/util/stream/k5;
    .locals 1

    .line 122
    invoke-static {p2}, Lj$/util/Objects;->requireNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    sget-object v0, Lj$/util/stream/x6;->DISTINCT:Lj$/util/stream/x6;

    invoke-virtual {v0, p1}, Lj$/util/stream/x6;->l(I)Z

    move-result v0

    if-eqz v0, :cond_0

    return-object p2

    .line 126
    :cond_0
    sget-object v0, Lj$/util/stream/x6;->SORTED:Lj$/util/stream/x6;

    invoke-virtual {v0, p1}, Lj$/util/stream/x6;->l(I)Z

    move-result p1

    if-eqz p1, :cond_1

    .line 127
    new-instance p1, Lj$/util/stream/k;

    .line 127
    invoke-direct {p1, p2}, Lj$/util/stream/k;-><init>(Lj$/util/stream/k5;)V

    return-object p1

    .line 158
    :cond_1
    new-instance p1, Lj$/util/stream/l;

    .line 158
    invoke-direct {p1, p2}, Lj$/util/stream/l;-><init>(Lj$/util/stream/k5;)V

    return-object p1
.end method
