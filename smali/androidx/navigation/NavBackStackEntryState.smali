.class public final Landroidx/navigation/NavBackStackEntryState;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final impl:Lcom/android/billingclient/api/zzca;


# direct methods
.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 1

    const-string v0, "state"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    const-class v0, Landroidx/navigation/NavBackStackEntryState;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 9
    new-instance v0, Lcom/android/billingclient/api/zzca;

    invoke-direct {v0, p1}, Lcom/android/billingclient/api/zzca;-><init>(Landroid/os/Bundle;)V

    iput-object v0, p0, Landroidx/navigation/NavBackStackEntryState;->impl:Lcom/android/billingclient/api/zzca;

    return-void
.end method

.method public constructor <init>(Landroidx/navigation/NavBackStackEntry;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    new-instance v0, Lcom/android/billingclient/api/zzca;

    .line 3
    iget-object v1, p1, Landroidx/navigation/NavBackStackEntry;->destination:Landroidx/navigation/NavDestination;

    .line 4
    iget-object v1, v1, Landroidx/navigation/NavDestination;->impl:Landroidx/navigation/internal/NavDestinationImpl;

    .line 5
    iget v1, v1, Landroidx/navigation/internal/NavDestinationImpl;->id:I

    .line 6
    invoke-direct {v0, p1, v1}, Lcom/android/billingclient/api/zzca;-><init>(Landroidx/navigation/NavBackStackEntry;I)V

    iput-object v0, p0, Landroidx/navigation/NavBackStackEntryState;->impl:Lcom/android/billingclient/api/zzca;

    return-void
.end method
