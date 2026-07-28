.class public abstract Lcom/google/android/material/motion/MaterialBackAnimationHelper;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public backEvent:Landroidx/activity/BackEventCompat;

.field public final cancelDuration:I

.field public final hideDurationMax:I

.field public final hideDurationMin:I

.field public final progressInterpolator:Landroid/view/animation/PathInterpolator;

.field public final view:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 4

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Landroid/view/animation/PathInterpolator;

    .line 5
    .line 6
    const/4 v1, 0x0

    .line 7
    const/high16 v2, 0x3f800000    # 1.0f

    .line 8
    .line 9
    const v3, 0x3dcccccd    # 0.1f

    .line 10
    .line 11
    .line 12
    invoke-direct {v0, v3, v3, v1, v2}, Landroid/view/animation/PathInterpolator;-><init>(FFFF)V

    .line 13
    .line 14
    .line 15
    iput-object v0, p0, Lcom/google/android/material/motion/MaterialBackAnimationHelper;->progressInterpolator:Landroid/view/animation/PathInterpolator;

    .line 16
    .line 17
    iput-object p1, p0, Lcom/google/android/material/motion/MaterialBackAnimationHelper;->view:Landroid/view/View;

    .line 18
    .line 19
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 20
    .line 21
    .line 22
    move-result-object p1

    .line 23
    const v0, 0x7f0403af

    .line 24
    .line 25
    .line 26
    const/16 v1, 0x12c

    .line 27
    .line 28
    invoke-static {p1, v0, v1}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeDuration(Landroid/content/Context;II)I

    .line 29
    .line 30
    .line 31
    move-result v0

    .line 32
    iput v0, p0, Lcom/google/android/material/motion/MaterialBackAnimationHelper;->hideDurationMax:I

    .line 33
    .line 34
    const v0, 0x7f0403b4

    .line 35
    .line 36
    .line 37
    const/16 v1, 0x96

    .line 38
    .line 39
    invoke-static {p1, v0, v1}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeDuration(Landroid/content/Context;II)I

    .line 40
    .line 41
    .line 42
    move-result v0

    .line 43
    iput v0, p0, Lcom/google/android/material/motion/MaterialBackAnimationHelper;->hideDurationMin:I

    .line 44
    .line 45
    const v0, 0x7f0403b3

    .line 46
    .line 47
    .line 48
    const/16 v1, 0x64

    .line 49
    .line 50
    invoke-static {p1, v0, v1}, Lkotlin/LazyKt__LazyJVMKt;->resolveThemeDuration(Landroid/content/Context;II)I

    .line 51
    .line 52
    .line 53
    move-result p1

    .line 54
    iput p1, p0, Lcom/google/android/material/motion/MaterialBackAnimationHelper;->cancelDuration:I

    .line 55
    .line 56
    return-void
    .line 57
.end method
