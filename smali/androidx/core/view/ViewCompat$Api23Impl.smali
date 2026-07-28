.class public abstract Landroidx/core/view/ViewCompat$Api23Impl;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static getRootWindowInsets(Landroid/view/View;)Landroidx/core/view/WindowInsetsCompat;
    .locals 2

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->getRootWindowInsets()Landroid/view/WindowInsets;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const/4 v1, 0x0

    .line 6
    if-nez v0, :cond_0

    .line 7
    .line 8
    return-object v1

    .line 9
    :cond_0
    invoke-static {v1, v0}, Landroidx/core/view/WindowInsetsCompat;->toWindowInsetsCompat(Landroid/view/View;Landroid/view/WindowInsets;)Landroidx/core/view/WindowInsetsCompat;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    iget-object v1, v0, Landroidx/core/view/WindowInsetsCompat;->mImpl:Landroidx/core/view/WindowInsetsCompat$Impl;

    .line 14
    .line 15
    invoke-virtual {v1, v0}, Landroidx/core/view/WindowInsetsCompat$Impl;->setRootWindowInsets(Landroidx/core/view/WindowInsetsCompat;)V

    .line 16
    .line 17
    .line 18
    invoke-virtual {p0}, Landroid/view/View;->getRootView()Landroid/view/View;

    .line 19
    .line 20
    .line 21
    move-result-object p0

    .line 22
    invoke-virtual {v1, p0}, Landroidx/core/view/WindowInsetsCompat$Impl;->copyRootViewBounds(Landroid/view/View;)V

    .line 23
    .line 24
    .line 25
    return-object v0
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public static getScrollIndicators(Landroid/view/View;)I
    .locals 0

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->getScrollIndicators()I

    .line 2
    .line 3
    .line 4
    move-result p0

    .line 5
    return p0
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public static setScrollIndicators(Landroid/view/View;I)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Landroid/view/View;->setScrollIndicators(I)V

    return-void
.end method

.method public static setScrollIndicators(Landroid/view/View;II)V
    .locals 0

    .line 2
    invoke-virtual {p0, p1, p2}, Landroid/view/View;->setScrollIndicators(II)V

    return-void
.end method
