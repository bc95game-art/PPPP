.class public abstract Landroidx/fragment/app/SpecialEffectsController$Effect;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public isCancelled:Z

.field public isStarted:Z


# virtual methods
.method public isSeekingSupported()Z
    .locals 1

    instance-of v0, p0, Landroidx/fragment/app/DefaultSpecialEffectsController$AnimatorEffect;

    return v0
.end method

.method public abstract onCancel(Landroid/view/ViewGroup;)V
.end method

.method public abstract onCommit(Landroid/view/ViewGroup;)V
.end method

.method public onProgress(Landroidx/activity/BackEventCompat;Landroid/view/ViewGroup;)V
    .locals 1

    const-string v0, "backEvent"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "container"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    return-void
.end method

.method public onStart(Landroid/view/ViewGroup;)V
    .locals 1

    const-string v0, "container"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    return-void
.end method
