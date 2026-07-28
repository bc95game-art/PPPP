.class public final Lcom/google/android/gms/internal/play_billing/zzcj$zza;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final zza:Lcom/google/android/gms/internal/play_billing/zzcj$zza;

.field public static final zzb:Lcom/google/android/gms/internal/play_billing/zzcj$zza;


# instance fields
.field public final zzc:Z

.field public final zzd:Ljava/lang/Throwable;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    sget-boolean v0, Lcom/google/android/gms/internal/play_billing/zzck;->zzc:Z

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    sput-object v1, Lcom/google/android/gms/internal/play_billing/zzcj$zza;->zzb:Lcom/google/android/gms/internal/play_billing/zzcj$zza;

    .line 7
    .line 8
    sput-object v1, Lcom/google/android/gms/internal/play_billing/zzcj$zza;->zza:Lcom/google/android/gms/internal/play_billing/zzcj$zza;

    .line 9
    .line 10
    return-void

    .line 11
    :cond_0
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzcj$zza;

    .line 12
    .line 13
    const/4 v2, 0x0

    .line 14
    invoke-direct {v0, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzcj$zza;-><init>(ZLjava/lang/Throwable;)V

    .line 15
    .line 16
    .line 17
    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzcj$zza;->zzb:Lcom/google/android/gms/internal/play_billing/zzcj$zza;

    .line 18
    .line 19
    new-instance v0, Lcom/google/android/gms/internal/play_billing/zzcj$zza;

    .line 20
    .line 21
    const/4 v2, 0x1

    .line 22
    invoke-direct {v0, v2, v1}, Lcom/google/android/gms/internal/play_billing/zzcj$zza;-><init>(ZLjava/lang/Throwable;)V

    .line 23
    .line 24
    .line 25
    sput-object v0, Lcom/google/android/gms/internal/play_billing/zzcj$zza;->zza:Lcom/google/android/gms/internal/play_billing/zzcj$zza;

    .line 26
    .line 27
    return-void
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

.method public constructor <init>(ZLjava/lang/Throwable;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean p1, p0, Lcom/google/android/gms/internal/play_billing/zzcj$zza;->zzc:Z

    iput-object p2, p0, Lcom/google/android/gms/internal/play_billing/zzcj$zza;->zzd:Ljava/lang/Throwable;

    return-void
.end method
