.class public final Lj$/util/stream/t0;
.super Lj$/util/stream/y0;
.source "SourceFile"


# instance fields
.field public final synthetic s:I

.field public final synthetic t:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Lj$/util/stream/a;ILjava/lang/Object;I)V
    .locals 0

    iput p4, p0, Lj$/util/stream/t0;->s:I

    iput-object p3, p0, Lj$/util/stream/t0;->t:Ljava/lang/Object;

    invoke-direct {p0, p1, p2}, Lj$/util/stream/a;-><init>(Lj$/util/stream/a;I)V

    return-void
.end method

.method public constructor <init>(Lj$/util/stream/z0;Ljava/util/function/IntConsumer;)V
    .locals 1

    const/4 v0, 0x0

    iput v0, p0, Lj$/util/stream/t0;->s:I

    .line 380
    iput-object p2, p0, Lj$/util/stream/t0;->t:Ljava/lang/Object;

    const/4 p2, 0x0

    .line 91
    invoke-direct {p0, p1, p2}, Lj$/util/stream/a;-><init>(Lj$/util/stream/a;I)V

    return-void
.end method


# virtual methods
.method public final P0(ILj$/util/stream/k5;)Lj$/util/stream/k5;
    .locals 1

    iget p1, p0, Lj$/util/stream/t0;->s:I

    packed-switch p1, :pswitch_data_0

    .line 305
    new-instance p1, Lj$/util/stream/x4;

    invoke-direct {p1, p0, p2}, Lj$/util/stream/x4;-><init>(Lj$/util/stream/t0;Lj$/util/stream/k5;)V

    return-object p1

    .line 209
    :pswitch_0
    new-instance p1, Lj$/util/stream/l;

    const/4 v0, 0x4

    invoke-direct {p1, p0, p2, v0}, Lj$/util/stream/l;-><init>(Lj$/util/stream/a;Lj$/util/stream/k5;I)V

    return-object p1

    .line 300
    :pswitch_1
    new-instance p1, Lj$/util/stream/v0;

    invoke-direct {p1, p0, p2}, Lj$/util/stream/v0;-><init>(Lj$/util/stream/t0;Lj$/util/stream/k5;)V

    return-object p1

    .line 383
    :pswitch_2
    new-instance p1, Lj$/util/stream/s0;

    const/4 v0, 0x1

    invoke-direct {p1, p0, p2, v0}, Lj$/util/stream/s0;-><init>(Lj$/util/stream/a;Lj$/util/stream/k5;I)V

    return-object p1

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
