.class public final Lcom/google/android/gms/common/wrappers/Wrappers;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final zza:Lcom/google/android/gms/common/wrappers/Wrappers;


# instance fields
.field public zzb:Landroidx/navigation/internal/NavContext;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/google/android/gms/common/wrappers/Wrappers;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    const/4 v1, 0x0

    .line 7
    iput-object v1, v0, Lcom/google/android/gms/common/wrappers/Wrappers;->zzb:Landroidx/navigation/internal/NavContext;

    .line 8
    .line 9
    sput-object v0, Lcom/google/android/gms/common/wrappers/Wrappers;->zza:Lcom/google/android/gms/common/wrappers/Wrappers;

    .line 10
    .line 11
    return-void
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
    .line 58
.end method

.method public static packageManager(Landroid/content/Context;)Landroidx/navigation/internal/NavContext;
    .locals 3

    .line 1
    sget-object v0, Lcom/google/android/gms/common/wrappers/Wrappers;->zza:Lcom/google/android/gms/common/wrappers/Wrappers;

    .line 2
    .line 3
    monitor-enter v0

    .line 4
    :try_start_0
    iget-object v1, v0, Lcom/google/android/gms/common/wrappers/Wrappers;->zzb:Landroidx/navigation/internal/NavContext;

    .line 5
    .line 6
    if-nez v1, :cond_1

    .line 7
    .line 8
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    .line 9
    .line 10
    .line 11
    move-result-object v1

    .line 12
    if-eqz v1, :cond_0

    .line 13
    .line 14
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    .line 15
    .line 16
    .line 17
    move-result-object p0

    .line 18
    goto :goto_0

    .line 19
    :catchall_0
    move-exception p0

    .line 20
    goto :goto_1

    .line 21
    :cond_0
    :goto_0
    new-instance v1, Landroidx/navigation/internal/NavContext;

    .line 22
    .line 23
    const/4 v2, 0x0

    .line 24
    invoke-direct {v1, p0, v2}, Landroidx/navigation/internal/NavContext;-><init>(Landroid/content/Context;Z)V

    .line 25
    .line 26
    .line 27
    iput-object v1, v0, Lcom/google/android/gms/common/wrappers/Wrappers;->zzb:Landroidx/navigation/internal/NavContext;

    .line 28
    .line 29
    :cond_1
    iget-object p0, v0, Lcom/google/android/gms/common/wrappers/Wrappers;->zzb:Landroidx/navigation/internal/NavContext;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 30
    .line 31
    monitor-exit v0

    .line 32
    return-object p0

    .line 33
    :goto_1
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 34
    throw p0
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
