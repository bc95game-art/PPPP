.class public abstract Lj$/util/stream/x8;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final a:I

.field public static final b:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 50
    sget v0, Lj$/util/stream/x6;->t:I

    sget v1, Lj$/util/stream/x6;->u:I

    or-int/2addr v1, v0

    sput v1, Lj$/util/stream/x8;->a:I

    .line 52
    sput v0, Lj$/util/stream/x8;->b:I

    return-void
.end method
