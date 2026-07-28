.class public final Landroidx/core/view/MenuHostHelper;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final mMenuProviders:Ljava/util/concurrent/CopyOnWriteArrayList;

.field public final mOnInvalidateMenuCallback:Ljava/lang/Runnable;

.field public final mProviderToLifecycleContainers:Ljava/util/HashMap;


# direct methods
.method public constructor <init>(Ljava/lang/Runnable;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Landroidx/core/view/MenuHostHelper;->mMenuProviders:Ljava/util/concurrent/CopyOnWriteArrayList;

    .line 10
    .line 11
    new-instance v0, Ljava/util/HashMap;

    .line 12
    .line 13
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 14
    .line 15
    .line 16
    iput-object v0, p0, Landroidx/core/view/MenuHostHelper;->mProviderToLifecycleContainers:Ljava/util/HashMap;

    .line 17
    .line 18
    iput-object p1, p0, Landroidx/core/view/MenuHostHelper;->mOnInvalidateMenuCallback:Ljava/lang/Runnable;

    .line 19
    .line 20
    return-void
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


# virtual methods
.method public final removeMenuProvider(Landroidx/core/view/MenuProvider;)V
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/core/view/MenuHostHelper;->mMenuProviders:Ljava/util/concurrent/CopyOnWriteArrayList;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/core/view/MenuHostHelper;->mProviderToLifecycleContainers:Ljava/util/HashMap;

    .line 7
    .line 8
    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    check-cast p1, Landroidx/core/view/MenuHostHelper$LifecycleContainer;

    .line 13
    .line 14
    if-eqz p1, :cond_0

    .line 15
    .line 16
    iget-object v0, p1, Landroidx/core/view/MenuHostHelper$LifecycleContainer;->mLifecycle:Landroidx/lifecycle/Lifecycle;

    .line 17
    .line 18
    iget-object v1, p1, Landroidx/core/view/MenuHostHelper$LifecycleContainer;->mObserver:Landroidx/lifecycle/LifecycleEventObserver;

    .line 19
    .line 20
    invoke-virtual {v0, v1}, Landroidx/lifecycle/Lifecycle;->removeObserver(Landroidx/lifecycle/LifecycleObserver;)V

    .line 21
    .line 22
    .line 23
    const/4 v0, 0x0

    .line 24
    iput-object v0, p1, Landroidx/core/view/MenuHostHelper$LifecycleContainer;->mObserver:Landroidx/lifecycle/LifecycleEventObserver;

    .line 25
    .line 26
    :cond_0
    iget-object p1, p0, Landroidx/core/view/MenuHostHelper;->mOnInvalidateMenuCallback:Ljava/lang/Runnable;

    .line 27
    .line 28
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 29
    .line 30
    .line 31
    return-void
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
