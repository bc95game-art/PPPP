.class public abstract Landroidx/fragment/app/FragmentHostCallback;
.super Landroidx/fragment/app/FragmentContainer;
.source "SourceFile"


# instance fields
.field public final activity:Landroidx/appcompat/app/AppCompatActivity;

.field public final context:Landroidx/appcompat/app/AppCompatActivity;

.field public final fragmentManager:Landroidx/fragment/app/FragmentManagerImpl;

.field public final handler:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroidx/appcompat/app/AppCompatActivity;)V
    .locals 1

    .line 1
    new-instance v0, Landroid/os/Handler;

    .line 2
    .line 3
    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object p1, p0, Landroidx/fragment/app/FragmentHostCallback;->activity:Landroidx/appcompat/app/AppCompatActivity;

    .line 10
    .line 11
    iput-object p1, p0, Landroidx/fragment/app/FragmentHostCallback;->context:Landroidx/appcompat/app/AppCompatActivity;

    .line 12
    .line 13
    iput-object v0, p0, Landroidx/fragment/app/FragmentHostCallback;->handler:Landroid/os/Handler;

    .line 14
    .line 15
    new-instance p1, Landroidx/fragment/app/FragmentManagerImpl;

    .line 16
    .line 17
    invoke-direct {p1}, Landroidx/fragment/app/FragmentManager;-><init>()V

    .line 18
    .line 19
    .line 20
    iput-object p1, p0, Landroidx/fragment/app/FragmentHostCallback;->fragmentManager:Landroidx/fragment/app/FragmentManagerImpl;

    .line 21
    .line 22
    return-void
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
