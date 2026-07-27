.class public final Landroidx/navigation/internal/NavGraphImpl$iterator$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Iterator;
.implements Lkotlin/jvm/internal/markers/KMappedMarker;


# instance fields
.field public index:I

.field public final synthetic this$0:Lcom/android/billingclient/api/zzca;

.field public wentToNext:Z


# direct methods
.method public constructor <init>(Lcom/android/billingclient/api/zzca;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->this$0:Lcom/android/billingclient/api/zzca;

    .line 5
    .line 6
    const/4 p1, -0x1

    .line 7
    iput p1, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->index:I

    .line 8
    .line 9
    return-void
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


# virtual methods
.method public final hasNext()Z
    .locals 3

    .line 1
    iget v0, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->index:I

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    add-int/2addr v0, v1

    .line 5
    iget-object v2, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->this$0:Lcom/android/billingclient/api/zzca;

    .line 6
    .line 7
    iget-object v2, v2, Lcom/android/billingclient/api/zzca;->zzb:Ljava/lang/Object;

    .line 8
    .line 9
    check-cast v2, Landroidx/collection/SparseArrayCompat;

    .line 10
    .line 11
    invoke-virtual {v2}, Landroidx/collection/SparseArrayCompat;->size()I

    .line 12
    .line 13
    .line 14
    move-result v2

    .line 15
    if-ge v0, v2, :cond_0

    .line 16
    .line 17
    return v1

    .line 18
    :cond_0
    const/4 v0, 0x0

    .line 19
    return v0
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
    .line 58
.end method

.method public final next()Ljava/lang/Object;
    .locals 3

    .line 1
    invoke-virtual {p0}, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->hasNext()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    iput-boolean v0, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->wentToNext:Z

    .line 9
    .line 10
    iget-object v1, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->this$0:Lcom/android/billingclient/api/zzca;

    .line 11
    .line 12
    iget-object v1, v1, Lcom/android/billingclient/api/zzca;->zzb:Ljava/lang/Object;

    .line 13
    .line 14
    check-cast v1, Landroidx/collection/SparseArrayCompat;

    .line 15
    .line 16
    iget v2, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->index:I

    .line 17
    .line 18
    add-int/2addr v2, v0

    .line 19
    iput v2, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->index:I

    .line 20
    .line 21
    invoke-virtual {v1, v2}, Landroidx/collection/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    check-cast v0, Landroidx/navigation/NavDestination;

    .line 26
    .line 27
    return-object v0

    .line 28
    :cond_0
    new-instance v0, Ljava/util/NoSuchElementException;

    .line 29
    .line 30
    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    .line 31
    .line 32
    .line 33
    throw v0
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
    .line 58
.end method

.method public final remove()V
    .locals 5

    .line 1
    iget-boolean v0, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->wentToNext:Z

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    iget-object v0, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->this$0:Lcom/android/billingclient/api/zzca;

    .line 6
    .line 7
    iget-object v0, v0, Lcom/android/billingclient/api/zzca;->zzb:Ljava/lang/Object;

    .line 8
    .line 9
    check-cast v0, Landroidx/collection/SparseArrayCompat;

    .line 10
    .line 11
    iget v1, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->index:I

    .line 12
    .line 13
    invoke-virtual {v0, v1}, Landroidx/collection/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    check-cast v1, Landroidx/navigation/NavDestination;

    .line 18
    .line 19
    const/4 v2, 0x0

    .line 20
    iput-object v2, v1, Landroidx/navigation/NavDestination;->parent:Landroidx/navigation/NavGraph;

    .line 21
    .line 22
    iget v1, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->index:I

    .line 23
    .line 24
    iget-object v2, v0, Landroidx/collection/SparseArrayCompat;->values:[Ljava/lang/Object;

    .line 25
    .line 26
    aget-object v3, v2, v1

    .line 27
    .line 28
    sget-object v4, Landroidx/collection/ArraySetKt;->DELETED$1:Ljava/lang/Object;

    .line 29
    .line 30
    if-eq v3, v4, :cond_0

    .line 31
    .line 32
    aput-object v4, v2, v1

    .line 33
    .line 34
    const/4 v2, 0x1

    .line 35
    iput-boolean v2, v0, Landroidx/collection/SparseArrayCompat;->garbage:Z

    .line 36
    .line 37
    :cond_0
    add-int/lit8 v1, v1, -0x1

    .line 38
    .line 39
    iput v1, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->index:I

    .line 40
    .line 41
    const/4 v0, 0x0

    .line 42
    iput-boolean v0, p0, Landroidx/navigation/internal/NavGraphImpl$iterator$1;->wentToNext:Z

    .line 43
    .line 44
    return-void

    .line 45
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 46
    .line 47
    const-string v1, "You must call next() before you can remove an element"

    .line 48
    .line 49
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 50
    .line 51
    .line 52
    throw v0
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method
