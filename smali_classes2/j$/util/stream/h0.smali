.class public final Lj$/util/stream/h0;
.super Lj$/util/stream/i0;
.source "SourceFile"


# static fields
.field public static final c:Lj$/util/stream/c0;

.field public static final d:Lj$/util/stream/c0;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .line 197
    new-instance v0, Lj$/util/stream/c0;

    sget-object v2, Lj$/util/stream/y6;->REFERENCE:Lj$/util/stream/y6;

    .line 198
    new-instance v4, Lj$/util/stream/e0;

    const/4 v1, 0x4

    .line 0
    invoke-direct {v4, v1}, Lj$/util/stream/e0;-><init>(I)V

    .line 198
    new-instance v5, Lj$/util/stream/e0;

    const/4 v1, 0x5

    .line 0
    invoke-direct {v5, v1}, Lj$/util/stream/e0;-><init>(I)V

    const/4 v1, 0x1

    .line 198
    sget-object v3, Lj$/util/y;->b:Lj$/util/y;

    invoke-direct/range {v0 .. v5}, Lj$/util/stream/c0;-><init>(ZLj$/util/stream/y6;Ljava/lang/Object;Ljava/util/function/Predicate;Ljava/util/function/Supplier;)V

    sput-object v0, Lj$/util/stream/h0;->c:Lj$/util/stream/c0;

    .line 201
    new-instance v1, Lj$/util/stream/c0;

    .line 202
    new-instance v5, Lj$/util/stream/e0;

    const/4 v0, 0x4

    .line 0
    invoke-direct {v5, v0}, Lj$/util/stream/e0;-><init>(I)V

    .line 202
    new-instance v6, Lj$/util/stream/e0;

    const/4 v0, 0x5

    .line 0
    invoke-direct {v6, v0}, Lj$/util/stream/e0;-><init>(I)V

    move-object v4, v3

    move-object v3, v2

    const/4 v2, 0x0

    .line 202
    invoke-direct/range {v1 .. v6}, Lj$/util/stream/c0;-><init>(ZLj$/util/stream/y6;Ljava/lang/Object;Ljava/util/function/Predicate;Ljava/util/function/Supplier;)V

    sput-object v1, Lj$/util/stream/h0;->d:Lj$/util/stream/c0;

    return-void
.end method


# virtual methods
.method public final get()Ljava/lang/Object;
    .locals 2

    .line 194
    iget-boolean v0, p0, Lj$/util/stream/i0;->a:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lj$/util/stream/i0;->b:Ljava/lang/Object;

    .line 120
    new-instance v1, Lj$/util/y;

    invoke-direct {v1, v0}, Lj$/util/y;-><init>(Ljava/lang/Object;)V

    return-object v1

    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method
