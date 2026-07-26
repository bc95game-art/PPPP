.class public final Lj$/time/o;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lj$/time/temporal/n;
.implements Lj$/time/temporal/o;
.implements Ljava/lang/Comparable;
.implements Ljava/io/Serializable;


# static fields
.field public static final synthetic c:I = 0x0

.field private static final serialVersionUID:J = -0xd0888991b3ac078L


# instance fields
.field public final a:I

.field public final b:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 137
    new-instance v0, Lj$/time/format/o;

    invoke-direct {v0}, Lj$/time/format/o;-><init>()V

    const-string v1, "--"

    .line 138
    invoke-virtual {v0, v1}, Lj$/time/format/o;->d(Ljava/lang/String;)V

    sget-object v1, Lj$/time/temporal/a;->MONTH_OF_YEAR:Lj$/time/temporal/a;

    const/4 v2, 0x2

    .line 139
    invoke-virtual {v0, v1, v2}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    const/16 v1, 0x2d

    .line 140
    invoke-virtual {v0, v1}, Lj$/time/format/o;->c(C)V

    sget-object v1, Lj$/time/temporal/a;->DAY_OF_MONTH:Lj$/time/temporal/a;

    .line 141
    invoke-virtual {v0, v1, v2}, Lj$/time/format/o;->g(Lj$/time/temporal/q;I)V

    .line 2203
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    .line 2224
    sget-object v2, Lj$/time/format/u;->SMART:Lj$/time/format/u;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lj$/time/format/o;->l(Ljava/util/Locale;Lj$/time/format/u;Lj$/time/chrono/m;)Lj$/time/format/a;

    return-void
.end method

.method public constructor <init>(II)V
    .locals 0

    .line 319
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 320
    iput p1, p0, Lj$/time/o;->a:I

    .line 321
    iput p2, p0, Lj$/time/o;->b:I

    return-void
.end method

.method private readObject(Ljava/io/ObjectInputStream;)V
    .locals 1

    .line 778
    new-instance p1, Ljava/io/InvalidObjectException;

    const-string v0, "Deserialization via serialization delegate"

    invoke-direct {p1, v0}, Ljava/io/InvalidObjectException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private writeReplace()Ljava/lang/Object;
    .locals 2

    .line 768
    new-instance v0, Lj$/time/t;

    const/16 v1, 0xd

    invoke-direct {v0, v1, p0}, Lj$/time/t;-><init>(BLjava/lang/Object;)V

    return-object v0
.end method


# virtual methods
.method public final compareTo(Ljava/lang/Object;)I
    .locals 2

    .line 127
    check-cast p1, Lj$/time/o;

    .line 680
    iget v0, p0, Lj$/time/o;->a:I

    iget v1, p1, Lj$/time/o;->a:I

    sub-int/2addr v0, v1

    if-nez v0, :cond_0

    .line 682
    iget v0, p0, Lj$/time/o;->b:I

    iget p1, p1, Lj$/time/o;->b:I

    sub-int/2addr v0, p1

    :cond_0
    return v0
.end method

.method public final e(Lj$/time/temporal/q;)Z
    .locals 1

    .line 350
    instance-of v0, p1, Lj$/time/temporal/a;

    if-eqz v0, :cond_0

    .line 351
    sget-object v0, Lj$/time/temporal/a;->MONTH_OF_YEAR:Lj$/time/temporal/a;

    if-eq p1, v0, :cond_1

    sget-object v0, Lj$/time/temporal/a;->DAY_OF_MONTH:Lj$/time/temporal/a;

    if-ne p1, v0, :cond_2

    goto :goto_0

    :cond_0
    if-eqz p1, :cond_2

    .line 353
    invoke-interface {p1, p0}, Lj$/time/temporal/q;->i(Lj$/time/temporal/n;)Z

    move-result p1

    if-eqz p1, :cond_2

    :cond_1
    :goto_0
    const/4 p1, 0x1

    return p1

    :cond_2
    const/4 p1, 0x0

    return p1
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    return v0

    .line 721
    :cond_0
    instance-of v1, p1, Lj$/time/o;

    const/4 v2, 0x0

    if-eqz v1, :cond_1

    .line 722
    check-cast p1, Lj$/time/o;

    .line 723
    iget v1, p0, Lj$/time/o;->a:I

    iget v3, p1, Lj$/time/o;->a:I

    if-ne v1, v3, :cond_1

    iget v1, p0, Lj$/time/o;->b:I

    iget p1, p1, Lj$/time/o;->b:I

    if-ne v1, p1, :cond_1

    return v0

    :cond_1
    return v2
.end method

.method public final hashCode()I
    .locals 2

    .line 735
    iget v0, p0, Lj$/time/o;->a:I

    shl-int/lit8 v0, v0, 0x6

    iget v1, p0, Lj$/time/o;->b:I

    add-int/2addr v0, v1

    return v0
.end method

.method public final i(Lj$/time/temporal/q;)I
    .locals 3

    .line 417
    invoke-virtual {p0, p1}, Lj$/time/o;->k(Lj$/time/temporal/q;)Lj$/time/temporal/u;

    move-result-object v0

    invoke-virtual {p0, p1}, Lj$/time/o;->w(Lj$/time/temporal/q;)J

    move-result-wide v1

    invoke-virtual {v0, v1, v2, p1}, Lj$/time/temporal/u;->a(JLj$/time/temporal/q;)I

    move-result p1

    return p1
.end method

.method public final k(Lj$/time/temporal/q;)Lj$/time/temporal/u;
    .locals 4

    .line 381
    sget-object v0, Lj$/time/temporal/a;->MONTH_OF_YEAR:Lj$/time/temporal/a;

    if-ne p1, v0, :cond_0

    .line 382
    invoke-interface {p1}, Lj$/time/temporal/q;->k()Lj$/time/temporal/u;

    move-result-object p1

    return-object p1

    .line 383
    :cond_0
    sget-object v0, Lj$/time/temporal/a;->DAY_OF_MONTH:Lj$/time/temporal/a;

    if-ne p1, v0, :cond_3

    .line 483
    iget p1, p0, Lj$/time/o;->a:I

    invoke-static {p1}, Lj$/time/m;->F(I)Lj$/time/m;

    move-result-object p1

    .line 384
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 449
    sget-object v0, Lj$/time/l;->a:[I

    invoke-virtual {p1}, Ljava/lang/Enum;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_2

    const/4 v0, 0x2

    if-eq p1, v0, :cond_1

    const/4 v0, 0x3

    if-eq p1, v0, :cond_1

    const/4 v0, 0x4

    if-eq p1, v0, :cond_1

    const/4 v0, 0x5

    if-eq p1, v0, :cond_1

    const/16 p1, 0x1f

    goto :goto_0

    :cond_1
    const/16 p1, 0x1e

    goto :goto_0

    :cond_2
    const/16 p1, 0x1c

    :goto_0
    int-to-long v0, p1

    .line 483
    iget p1, p0, Lj$/time/o;->a:I

    invoke-static {p1}, Lj$/time/m;->F(I)Lj$/time/m;

    move-result-object p1

    .line 384
    invoke-virtual {p1}, Lj$/time/m;->E()I

    move-result p1

    int-to-long v2, p1

    .line 147
    invoke-static {v0, v1, v2, v3}, Lj$/time/temporal/u;->f(JJ)Lj$/time/temporal/u;

    move-result-object p1

    return-object p1

    .line 386
    :cond_3
    invoke-static {p0, p1}, Lj$/time/temporal/r;->d(Lj$/time/temporal/n;Lj$/time/temporal/q;)Lj$/time/temporal/u;

    move-result-object p1

    return-object p1
.end method

.method public final l(Lj$/time/format/b;)Ljava/lang/Object;
    .locals 1

    .line 593
    sget-object v0, Lj$/time/temporal/r;->b:Lj$/time/format/b;

    if-ne p1, v0, :cond_0

    .line 594
    sget-object p1, Lj$/time/chrono/t;->c:Lj$/time/chrono/t;

    return-object p1

    .line 596
    :cond_0
    invoke-static {p0, p1}, Lj$/time/temporal/r;->c(Lj$/time/temporal/n;Lj$/time/format/b;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final o(Lj$/time/temporal/m;)Lj$/time/temporal/m;
    .locals 5

    .line 628
    invoke-static {p1}, Lj$/com/android/tools/r8/a;->O(Lj$/time/temporal/n;)Lj$/time/chrono/m;

    move-result-object v0

    sget-object v1, Lj$/time/chrono/t;->c:Lj$/time/chrono/t;

    invoke-interface {v0, v1}, Lj$/time/chrono/m;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 631
    sget-object v0, Lj$/time/temporal/a;->MONTH_OF_YEAR:Lj$/time/temporal/a;

    iget v1, p0, Lj$/time/o;->a:I

    int-to-long v1, v1

    invoke-interface {p1, v1, v2, v0}, Lj$/time/temporal/m;->c(JLj$/time/temporal/q;)Lj$/time/temporal/m;

    move-result-object p1

    .line 632
    sget-object v0, Lj$/time/temporal/a;->DAY_OF_MONTH:Lj$/time/temporal/a;

    invoke-interface {p1, v0}, Lj$/time/temporal/n;->k(Lj$/time/temporal/q;)Lj$/time/temporal/u;

    move-result-object v1

    .line 253
    iget-wide v1, v1, Lj$/time/temporal/u;->d:J

    .line 632
    iget v3, p0, Lj$/time/o;->b:I

    int-to-long v3, v3

    invoke-static {v1, v2, v3, v4}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v1

    invoke-interface {p1, v1, v2, v0}, Lj$/time/temporal/m;->c(JLj$/time/temporal/q;)Lj$/time/temporal/m;

    move-result-object p1

    return-object p1

    .line 629
    :cond_0
    new-instance p1, Lj$/time/a;

    const-string v0, "Adjustment only supported on ISO date-time"

    .line 88
    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 629
    throw p1
.end method

.method public final toString()Ljava/lang/String;
    .locals 3

    .line 748
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    const-string v2, "--"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 749
    iget v2, p0, Lj$/time/o;->a:I

    if-ge v2, v1, :cond_0

    const-string v2, "0"

    goto :goto_0

    :cond_0
    const-string v2, ""

    :goto_0
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v2, p0, Lj$/time/o;->a:I

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 750
    iget v2, p0, Lj$/time/o;->b:I

    if-ge v2, v1, :cond_1

    const-string v1, "-0"

    goto :goto_1

    :cond_1
    const-string v1, "-"

    :goto_1
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lj$/time/o;->b:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 751
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final w(Lj$/time/temporal/q;)J
    .locals 2

    .line 445
    instance-of v0, p1, Lj$/time/temporal/a;

    if-eqz v0, :cond_2

    .line 446
    sget-object v0, Lj$/time/n;->a:[I

    move-object v1, p1

    check-cast v1, Lj$/time/temporal/a;

    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 449
    iget p1, p0, Lj$/time/o;->a:I

    :goto_0
    int-to-long v0, p1

    return-wide v0

    .line 451
    :cond_0
    new-instance v0, Lj$/time/temporal/t;

    const-string v1, "Unsupported field: "

    .line 0
    invoke-static {v1, p1}, Lj$/time/b;->a(Ljava/lang/String;Lj$/time/temporal/q;)Ljava/lang/String;

    move-result-object p1

    .line 88
    invoke-direct {v0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 451
    throw v0

    .line 448
    :cond_1
    iget p1, p0, Lj$/time/o;->b:I

    goto :goto_0

    .line 453
    :cond_2
    invoke-interface {p1, p0}, Lj$/time/temporal/q;->l(Lj$/time/temporal/n;)J

    move-result-wide v0

    return-wide v0
.end method
