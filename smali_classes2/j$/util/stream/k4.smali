.class public final Lj$/util/stream/k4;
.super Lj$/util/stream/u3;
.source "SourceFile"


# instance fields
.field public final synthetic h:Ljava/util/function/IntBinaryOperator;

.field public final synthetic i:I


# direct methods
.method public constructor <init>(Lj$/util/stream/y6;Ljava/util/function/IntBinaryOperator;I)V
    .locals 0

    .line 899
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 310
    iput-object p2, p0, Lj$/util/stream/k4;->h:Ljava/util/function/IntBinaryOperator;

    iput p3, p0, Lj$/util/stream/k4;->i:I

    return-void
.end method


# virtual methods
.method public final D0()Lj$/util/stream/p4;
    .locals 3

    .line 313
    new-instance v0, Lj$/util/stream/j4;

    iget v1, p0, Lj$/util/stream/k4;->i:I

    iget-object v2, p0, Lj$/util/stream/k4;->h:Ljava/util/function/IntBinaryOperator;

    invoke-direct {v0, v1, v2}, Lj$/util/stream/j4;-><init>(ILjava/util/function/IntBinaryOperator;)V

    return-object v0
.end method
