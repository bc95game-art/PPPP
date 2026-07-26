.class public final Lj$/util/stream/d4;
.super Lj$/util/stream/u3;
.source "SourceFile"


# instance fields
.field public final synthetic h:Ljava/util/function/DoubleBinaryOperator;

.field public final synthetic i:D


# direct methods
.method public constructor <init>(Lj$/util/stream/y6;Ljava/util/function/DoubleBinaryOperator;D)V
    .locals 0

    .line 899
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 658
    iput-object p2, p0, Lj$/util/stream/d4;->h:Ljava/util/function/DoubleBinaryOperator;

    iput-wide p3, p0, Lj$/util/stream/d4;->i:D

    return-void
.end method


# virtual methods
.method public final D0()Lj$/util/stream/p4;
    .locals 4

    .line 661
    new-instance v0, Lj$/util/stream/y3;

    iget-wide v1, p0, Lj$/util/stream/d4;->i:D

    iget-object v3, p0, Lj$/util/stream/d4;->h:Ljava/util/function/DoubleBinaryOperator;

    invoke-direct {v0, v1, v2, v3}, Lj$/util/stream/y3;-><init>(DLjava/util/function/DoubleBinaryOperator;)V

    return-object v0
.end method
