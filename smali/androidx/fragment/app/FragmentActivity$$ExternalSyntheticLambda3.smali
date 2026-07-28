.class public final synthetic Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/activity/contextaware/OnContextAvailableListener;


# instance fields
.field public final synthetic f$0:Landroidx/appcompat/app/AppCompatActivity;


# direct methods
.method public synthetic constructor <init>(Landroidx/appcompat/app/AppCompatActivity;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda3;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    return-void
.end method


# virtual methods
.method public final onContextAvailable(Landroidx/activity/ComponentActivity;)V
    .locals 2

    .line 1
    iget-object p1, p0, Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda3;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    .line 2
    .line 3
    iget-object p1, p1, Landroidx/fragment/app/FragmentActivity;->mFragments:Landroidx/fragment/app/FragmentController;

    .line 4
    .line 5
    iget-object p1, p1, Landroidx/fragment/app/FragmentController;->mHost:Landroidx/fragment/app/FragmentActivity$HostCallbacks;

    .line 6
    .line 7
    iget-object v0, p1, Landroidx/fragment/app/FragmentHostCallback;->fragmentManager:Landroidx/fragment/app/FragmentManagerImpl;

    .line 8
    .line 9
    const/4 v1, 0x0

    .line 10
    invoke-virtual {v0, p1, p1, v1}, Landroidx/fragment/app/FragmentManager;->attachController(Landroidx/fragment/app/FragmentHostCallback;Landroidx/fragment/app/FragmentContainer;Landroidx/fragment/app/Fragment;)V

    .line 11
    .line 12
    .line 13
    return-void
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
