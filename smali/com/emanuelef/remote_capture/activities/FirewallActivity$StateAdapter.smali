.class Lcom/emanuelef/remote_capture/activities/FirewallActivity$StateAdapter;
.super Landroidx/viewpager2/adapter/FragmentStateAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/activities/FirewallActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "StateAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/activities/FirewallActivity;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/activities/FirewallActivity;Landroidx/fragment/app/FragmentActivity;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/FirewallActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/FirewallActivity;

    .line 2
    .line 3
    invoke-direct {p0, p2}, Landroidx/viewpager2/adapter/FragmentStateAdapter;-><init>(Landroidx/fragment/app/FragmentActivity;)V

    .line 4
    .line 5
    .line 6
    return-void
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
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method


# virtual methods
.method public createFragment(I)Landroidx/fragment/app/Fragment;
    .locals 2

    .line 1
    const-string v0, "Firewall"

    .line 2
    .line 3
    const-string v1, "createFragment"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x1

    .line 9
    if-eq p1, v0, :cond_1

    .line 10
    .line 11
    const/4 v0, 0x2

    .line 12
    if-eq p1, v0, :cond_0

    .line 13
    .line 14
    new-instance p1, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;

    .line 15
    .line 16
    invoke-direct {p1}, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;-><init>()V

    .line 17
    .line 18
    .line 19
    return-object p1

    .line 20
    :cond_0
    sget-object p1, Lcom/emanuelef/remote_capture/model/ListInfo$Type;->FIREWALL_WHITELIST:Lcom/emanuelef/remote_capture/model/ListInfo$Type;

    .line 21
    .line 22
    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->newInstance(Lcom/emanuelef/remote_capture/model/ListInfo$Type;)Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    .line 23
    .line 24
    .line 25
    move-result-object p1

    .line 26
    return-object p1

    .line 27
    :cond_1
    sget-object p1, Lcom/emanuelef/remote_capture/model/ListInfo$Type;->BLOCKLIST:Lcom/emanuelef/remote_capture/model/ListInfo$Type;

    .line 28
    .line 29
    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->newInstance(Lcom/emanuelef/remote_capture/model/ListInfo$Type;)Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    .line 30
    .line 31
    .line 32
    move-result-object p1

    .line 33
    return-object p1
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

.method public getItemCount()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/FirewallActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/FirewallActivity;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/FirewallActivity;->-$$Nest$fgetmHasWhitelist(Lcom/emanuelef/remote_capture/activities/FirewallActivity;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x3

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x2

    .line 12
    return v0
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

.method public getPageTitle(I)I
    .locals 1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_1

    const/4 v0, 0x2

    if-eq p1, v0, :cond_0

    const p1, 0x7f1402a8

    return p1

    :cond_0
    const p1, 0x7f1402f7

    return p1

    :cond_1
    const p1, 0x7f140056

    return p1
.end method
