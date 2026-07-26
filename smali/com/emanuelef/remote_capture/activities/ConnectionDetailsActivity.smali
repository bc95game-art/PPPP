.class public Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;
.super Lcom/emanuelef/remote_capture/activities/PayloadExportActivity;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;
.implements Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;
    }
.end annotation


# static fields
.field public static final CONN_ID_KEY:Ljava/lang/String; = "conn_id"

.field public static final FILTERED_IDS_KEY:Ljava/lang/String; = "filtered_ids"

.field private static final MAX_CHUNKS_TO_CHECK:I = 0xa

.field private static final POS_HTTP:I = 0x2

.field private static final POS_OVERVIEW:I = 0x0

.field private static final POS_RAW_PAYLOAD:I = 0x3

.field private static final POS_WEBSOCKET:I = 0x1

.field private static final TAG:Ljava/lang/String; = "ConnectionDetails"


# instance fields
.field private mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

.field private mConnId:I

.field private mCurChunks:I

.field private mDisplayMode:Ljava/lang/Boolean;

.field private mFilteredIds:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mFilteredIndex:I

.field private mHandler:Landroid/os/Handler;

.field private mHasHttpTab:Z

.field private mHasPayload:Z

.field private mHasWsTab:Z

.field private mListenerSet:Z

.field private final mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity$ConnUpdateListener;",
            ">;"
        }
    .end annotation
.end field

.field private mMenuCopy:Landroid/view/MenuItem;

.field private mMenuDisplayAs:Landroid/view/MenuItem;

.field private mMenuNext:Landroid/view/MenuItem;

.field private mMenuPrev:Landroid/view/MenuItem;

.field private mMenuShare:Landroid/view/MenuItem;

.field private mPager:Landroidx/viewpager2/widget/ViewPager2;

.field private mPagerAdapter:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;


# direct methods
.method public static synthetic $r8$lambda$XGrxTP5-yO4dgE73kd8jV2eXI3c(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->dispatchConnUpdate()V

    return-void
.end method

.method public static synthetic $r8$lambda$__cg253NfhNGG9K0QaCP15ZC3Oc(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;Lcom/google/android/material/tabs/TabLayout$Tab;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->lambda$setupTabs$0(Lcom/google/android/material/tabs/TabLayout$Tab;I)V

    return-void
.end method

.method public static bridge synthetic -$$Nest$fgetmConn(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmHasHttpTab(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasHttpTab:Z

    return p0
.end method

.method public static bridge synthetic -$$Nest$fgetmHasPayload(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasPayload:Z

    return p0
.end method

.method public static bridge synthetic -$$Nest$fgetmHasWsTab(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasWsTab:Z

    return p0
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/PayloadExportActivity;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mListeners:Ljava/util/ArrayList;

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

.method private dispatchConnUpdate()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mListeners:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    const/4 v2, 0x0

    .line 8
    :goto_0
    if-ge v2, v1, :cond_0

    .line 9
    .line 10
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 11
    .line 12
    .line 13
    move-result-object v3

    .line 14
    add-int/lit8 v2, v2, 0x1

    .line 15
    .line 16
    check-cast v3, Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity$ConnUpdateListener;

    .line 17
    .line 18
    invoke-interface {v3}, Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity$ConnUpdateListener;->connectionUpdated()V

    .line 19
    .line 20
    .line 21
    goto :goto_0

    .line 22
    :cond_0
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mCurChunks:I

    .line 23
    .line 24
    const/16 v1, 0xa

    .line 25
    .line 26
    if-ge v0, v1, :cond_1

    .line 27
    .line 28
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 29
    .line 30
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getNumPayloadChunks()I

    .line 31
    .line 32
    .line 33
    move-result v0

    .line 34
    iget v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mCurChunks:I

    .line 35
    .line 36
    if-le v0, v1, :cond_1

    .line 37
    .line 38
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->recheckTabs()V

    .line 39
    .line 40
    .line 41
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 42
    .line 43
    iget v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->status:I

    .line 44
    .line 45
    const/4 v1, 0x3

    .line 46
    if-lt v0, v1, :cond_2

    .line 47
    .line 48
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->unregisterConnsListener()V

    .line 49
    .line 50
    .line 51
    :cond_2
    return-void
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method private getAllConnectionIds()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x0

    .line 8
    return-object v0

    .line 9
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    .line 10
    .line 11
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 12
    .line 13
    .line 14
    monitor-enter v0

    .line 15
    const/4 v2, 0x0

    .line 16
    :goto_0
    :try_start_0
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConnCount()I

    .line 17
    .line 18
    .line 19
    move-result v3

    .line 20
    if-ge v2, v3, :cond_2

    .line 21
    .line 22
    invoke-virtual {v0, v2}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConn(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 23
    .line 24
    .line 25
    move-result-object v3

    .line 26
    if-eqz v3, :cond_1

    .line 27
    .line 28
    iget v3, v3, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 29
    .line 30
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 31
    .line 32
    .line 33
    move-result-object v3

    .line 34
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 35
    .line 36
    .line 37
    goto :goto_1

    .line 38
    :catchall_0
    move-exception v1

    .line 39
    goto :goto_2

    .line 40
    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    .line 41
    .line 42
    goto :goto_0

    .line 43
    :cond_2
    monitor-exit v0

    .line 44
    return-object v1

    .line 45
    :goto_2
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 46
    throw v1
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

.method private getCurrentFragment()Landroidx/fragment/app/Fragment;
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/viewpager2/widget/ViewPager2;->getCurrentItem()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    new-instance v1, Ljava/lang/StringBuilder;

    .line 8
    .line 9
    const-string v2, "f"

    .line 10
    .line 11
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 12
    .line 13
    .line 14
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPagerAdapter:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;

    .line 15
    .line 16
    invoke-virtual {v2, v0}, Landroidx/viewpager2/adapter/FragmentStateAdapter;->getItemId(I)J

    .line 17
    .line 18
    .line 19
    move-result-wide v2

    .line 20
    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 21
    .line 22
    .line 23
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    invoke-virtual {p0}, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    invoke-virtual {v1, v0}, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    return-object v0
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

.method private synthetic lambda$setupTabs$0(Lcom/google/android/material/tabs/TabLayout$Tab;I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPagerAdapter:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;

    .line 2
    .line 3
    invoke-virtual {v0, p2}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->getPageTitle(I)I

    .line 4
    .line 5
    .line 6
    move-result p2

    .line 7
    invoke-virtual {p0, p2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 8
    .line 9
    .line 10
    move-result-object p2

    .line 11
    invoke-virtual {p1, p2}, Lcom/google/android/material/tabs/TabLayout$Tab;->setText(Ljava/lang/CharSequence;)V

    .line 12
    .line 13
    .line 14
    return-void
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

.method private loadConnection()V
    .locals 4

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-eqz v0, :cond_3

    .line 6
    .line 7
    iget v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 8
    .line 9
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConnById(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 14
    .line 15
    if-eqz v0, :cond_2

    .line 16
    .line 17
    const v0, 0x7f14009c

    .line 18
    .line 19
    .line 20
    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    iget v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 25
    .line 26
    const/4 v2, 0x1

    .line 27
    add-int/2addr v1, v2

    .line 28
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 29
    .line 30
    .line 31
    move-result-object v1

    .line 32
    new-array v2, v2, [Ljava/lang/Object;

    .line 33
    .line 34
    const/4 v3, 0x0

    .line 35
    aput-object v1, v2, v3

    .line 36
    .line 37
    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object v0

    .line 41
    invoke-virtual {p0, v0}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 42
    .line 43
    .line 44
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->unregisterConnsListener()V

    .line 45
    .line 46
    .line 47
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 48
    .line 49
    invoke-virtual {v0}, Landroidx/viewpager2/widget/ViewPager2;->getCurrentItem()I

    .line 50
    .line 51
    .line 52
    move-result v0

    .line 53
    iput-boolean v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasPayload:Z

    .line 54
    .line 55
    iput-boolean v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasHttpTab:Z

    .line 56
    .line 57
    iput-boolean v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasWsTab:Z

    .line 58
    .line 59
    iput v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mCurChunks:I

    .line 60
    .line 61
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->setupTabs()V

    .line 62
    .line 63
    .line 64
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPagerAdapter:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;

    .line 65
    .line 66
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->getItemCount()I

    .line 67
    .line 68
    .line 69
    move-result v1

    .line 70
    if-ge v0, v1, :cond_0

    .line 71
    .line 72
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 73
    .line 74
    invoke-virtual {v1, v0, v3}, Landroidx/viewpager2/widget/ViewPager2;->setCurrentItem(IZ)V

    .line 75
    .line 76
    .line 77
    goto :goto_0

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 79
    .line 80
    invoke-virtual {v0, v3, v3}, Landroidx/viewpager2/widget/ViewPager2;->setCurrentItem(IZ)V

    .line 81
    .line 82
    .line 83
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 84
    .line 85
    iget v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->status:I

    .line 86
    .line 87
    const/4 v1, 0x3

    .line 88
    if-ge v0, v1, :cond_1

    .line 89
    .line 90
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->registerConnsListener()V

    .line 91
    .line 92
    .line 93
    :cond_1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->updateNavigationButtons()V

    .line 94
    .line 95
    .line 96
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->updateMenuVisibility()V

    .line 97
    .line 98
    .line 99
    return-void

    .line 100
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    .line 101
    .line 102
    const-string v1, "Connection with ID "

    .line 103
    .line 104
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 105
    .line 106
    .line 107
    iget v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 108
    .line 109
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 110
    .line 111
    .line 112
    const-string v1, " not found"

    .line 113
    .line 114
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    .line 116
    .line 117
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 118
    .line 119
    .line 120
    move-result-object v0

    .line 121
    const-string v1, "ConnectionDetails"

    .line 122
    .line 123
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    .line 125
    .line 126
    :cond_3
    return-void
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
.end method

.method private navigateToNext()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    goto :goto_0

    .line 6
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->getAllConnectionIds()Ljava/util/ArrayList;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    :goto_0
    if-nez v0, :cond_1

    .line 11
    .line 12
    goto :goto_1

    .line 13
    :cond_1
    iget v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 14
    .line 15
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 16
    .line 17
    .line 18
    move-result-object v1

    .line 19
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    if-ltz v1, :cond_3

    .line 24
    .line 25
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 26
    .line 27
    .line 28
    move-result v2

    .line 29
    add-int/lit8 v2, v2, -0x1

    .line 30
    .line 31
    if-ge v1, v2, :cond_3

    .line 32
    .line 33
    add-int/lit8 v1, v1, 0x1

    .line 34
    .line 35
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 36
    .line 37
    .line 38
    move-result-object v0

    .line 39
    check-cast v0, Ljava/lang/Integer;

    .line 40
    .line 41
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    .line 42
    .line 43
    .line 44
    move-result v0

    .line 45
    iput v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 46
    .line 47
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 48
    .line 49
    if-eqz v0, :cond_2

    .line 50
    .line 51
    iput v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIndex:I

    .line 52
    .line 53
    :cond_2
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->loadConnection()V

    .line 54
    .line 55
    .line 56
    :cond_3
    :goto_1
    return-void
    .line 57
    .line 58
.end method

.method private navigateToPrevious()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    goto :goto_0

    .line 6
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->getAllConnectionIds()Ljava/util/ArrayList;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    :goto_0
    if-nez v0, :cond_1

    .line 11
    .line 12
    goto :goto_1

    .line 13
    :cond_1
    iget v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 14
    .line 15
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 16
    .line 17
    .line 18
    move-result-object v1

    .line 19
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    if-lez v1, :cond_3

    .line 24
    .line 25
    add-int/lit8 v1, v1, -0x1

    .line 26
    .line 27
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    check-cast v0, Ljava/lang/Integer;

    .line 32
    .line 33
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    .line 34
    .line 35
    .line 36
    move-result v0

    .line 37
    iput v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 38
    .line 39
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 40
    .line 41
    if-eqz v0, :cond_2

    .line 42
    .line 43
    iput v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIndex:I

    .line 44
    .line 45
    :cond_2
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->loadConnection()V

    .line 46
    .line 47
    .line 48
    :cond_3
    :goto_1
    return-void
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

.method private recheckTabs()V
    .locals 7
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NotifyDataSetChanged"
        }
    .end annotation

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasHttpTab:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasWsTab:Z

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    return-void

    .line 10
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 11
    .line 12
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getNumPayloadChunks()I

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    const/16 v1, 0xa

    .line 17
    .line 18
    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasPayload:Z

    .line 23
    .line 24
    const/4 v2, 0x1

    .line 25
    if-nez v1, :cond_1

    .line 26
    .line 27
    if-lez v0, :cond_1

    .line 28
    .line 29
    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasPayload:Z

    .line 30
    .line 31
    const/4 v1, 0x1

    .line 32
    goto :goto_0

    .line 33
    :cond_1
    const/4 v1, 0x0

    .line 34
    :goto_0
    iget v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mCurChunks:I

    .line 35
    .line 36
    :goto_1
    if-ge v3, v0, :cond_5

    .line 37
    .line 38
    iget-object v4, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 39
    .line 40
    invoke-virtual {v4, v3}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getPayloadChunk(I)Lcom/emanuelef/remote_capture/model/PayloadChunk;

    .line 41
    .line 42
    .line 43
    move-result-object v4

    .line 44
    if-nez v4, :cond_2

    .line 45
    .line 46
    goto :goto_3

    .line 47
    :cond_2
    iget-boolean v5, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasHttpTab:Z

    .line 48
    .line 49
    if-nez v5, :cond_3

    .line 50
    .line 51
    iget-object v5, v4, Lcom/emanuelef/remote_capture/model/PayloadChunk;->type:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 52
    .line 53
    sget-object v6, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 54
    .line 55
    if-ne v5, v6, :cond_3

    .line 56
    .line 57
    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasHttpTab:Z

    .line 58
    .line 59
    :goto_2
    const/4 v1, 0x1

    .line 60
    goto :goto_3

    .line 61
    :cond_3
    iget-boolean v5, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasWsTab:Z

    .line 62
    .line 63
    if-nez v5, :cond_4

    .line 64
    .line 65
    iget-object v4, v4, Lcom/emanuelef/remote_capture/model/PayloadChunk;->type:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 66
    .line 67
    sget-object v5, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->WEBSOCKET:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 68
    .line 69
    if-ne v4, v5, :cond_4

    .line 70
    .line 71
    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHasWsTab:Z

    .line 72
    .line 73
    goto :goto_2

    .line 74
    :cond_4
    :goto_3
    add-int/lit8 v3, v3, 0x1

    .line 75
    .line 76
    goto :goto_1

    .line 77
    :cond_5
    if-eqz v1, :cond_6

    .line 78
    .line 79
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPagerAdapter:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;

    .line 80
    .line 81
    invoke-virtual {v1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 82
    .line 83
    .line 84
    :cond_6
    iput v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mCurChunks:I

    .line 85
    .line 86
    return-void
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
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
.end method

.method private registerConnsListener()V
    .locals 3

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    iget-boolean v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mListenerSet:Z

    .line 8
    .line 9
    if-nez v1, :cond_0

    .line 10
    .line 11
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 12
    .line 13
    iget v1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->status:I

    .line 14
    .line 15
    const/4 v2, 0x3

    .line 16
    if-ge v1, v2, :cond_0

    .line 17
    .line 18
    const-string v1, "ConnectionDetails"

    .line 19
    .line 20
    const-string v2, "Adding connections listener"

    .line 21
    .line 22
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 23
    .line 24
    .line 25
    invoke-virtual {v0, p0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->addListener(Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;)V

    .line 26
    .line 27
    .line 28
    const/4 v0, 0x1

    .line 29
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mListenerSet:Z

    .line 30
    .line 31
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->dispatchConnUpdate()V

    .line 32
    .line 33
    .line 34
    return-void
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

.method private setupTabs()V
    .locals 5

    .line 1
    new-instance v0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;

    .line 2
    .line 3
    invoke-direct {v0, p0, p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;-><init>(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;Landroidx/fragment/app/FragmentActivity;)V

    .line 4
    .line 5
    .line 6
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPagerAdapter:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;

    .line 7
    .line 8
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 9
    .line 10
    invoke-virtual {v1, v0}, Landroidx/viewpager2/widget/ViewPager2;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 11
    .line 12
    .line 13
    const v0, 0x7f0a0331

    .line 14
    .line 15
    .line 16
    invoke-virtual {p0, v0}, Landroidx/appcompat/app/AppCompatActivity;->findViewById(I)Landroid/view/View;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    check-cast v0, Lcom/google/android/material/tabs/TabLayout;

    .line 21
    .line 22
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->fixScrollableTabLayoutInsets(Lcom/google/android/material/tabs/TabLayout;)V

    .line 23
    .line 24
    .line 25
    new-instance v1, Lcom/google/android/gms/tasks/zzw;

    .line 26
    .line 27
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 28
    .line 29
    new-instance v3, Landroidx/core/view/inputmethod/InputConnectionCompat$$ExternalSyntheticLambda0;

    .line 30
    .line 31
    const/4 v4, 0x2

    .line 32
    invoke-direct {v3, v4, p0}, Landroidx/core/view/inputmethod/InputConnectionCompat$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 33
    .line 34
    .line 35
    invoke-direct {v1, v0, v2, v3}, Lcom/google/android/gms/tasks/zzw;-><init>(Lcom/google/android/material/tabs/TabLayout;Landroidx/viewpager2/widget/ViewPager2;Lcom/google/android/material/tabs/TabLayoutMediator$TabConfigurationStrategy;)V

    .line 36
    .line 37
    .line 38
    invoke-virtual {v1}, Lcom/google/android/gms/tasks/zzw;->attach()V

    .line 39
    .line 40
    .line 41
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 42
    .line 43
    new-instance v1, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$1;

    .line 44
    .line 45
    invoke-direct {v1, p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$1;-><init>(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)V

    .line 46
    .line 47
    .line 48
    iget-object v0, v0, Landroidx/viewpager2/widget/ViewPager2;->mExternalPageChangeCallbacks:Landroidx/viewpager2/widget/CompositeOnPageChangeCallback;

    .line 49
    .line 50
    iget-object v0, v0, Landroidx/viewpager2/widget/CompositeOnPageChangeCallback;->mCallbacks:Ljava/lang/Object;

    .line 51
    .line 52
    check-cast v0, Ljava/util/ArrayList;

    .line 53
    .line 54
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 55
    .line 56
    .line 57
    const/4 v0, 0x0

    .line 58
    iput v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mCurChunks:I

    .line 59
    .line 60
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->recheckTabs()V

    .line 61
    .line 62
    .line 63
    return-void
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
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
.end method

.method private unregisterConnsListener()V
    .locals 3

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mListenerSet:Z

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    const-string v1, "ConnectionDetails"

    .line 12
    .line 13
    const-string v2, "Removing connections listener"

    .line 14
    .line 15
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 16
    .line 17
    .line 18
    invoke-virtual {v0, p0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->removeListener(Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;)V

    .line 19
    .line 20
    .line 21
    :cond_0
    const/4 v0, 0x0

    .line 22
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mListenerSet:Z

    .line 23
    .line 24
    :cond_1
    return-void
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

.method private updateNavigationButtons()V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuPrev:Landroid/view/MenuItem;

    .line 2
    .line 3
    if-eqz v0, :cond_8

    .line 4
    .line 5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuNext:Landroid/view/MenuItem;

    .line 6
    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    goto :goto_4

    .line 10
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 11
    .line 12
    if-eqz v0, :cond_1

    .line 13
    .line 14
    goto :goto_0

    .line 15
    :cond_1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->getAllConnectionIds()Ljava/util/ArrayList;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    :goto_0
    const/4 v1, 0x0

    .line 20
    if-eqz v0, :cond_4

    .line 21
    .line 22
    iget v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 23
    .line 24
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 25
    .line 26
    .line 27
    move-result-object v2

    .line 28
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    .line 29
    .line 30
    .line 31
    move-result v2

    .line 32
    if-ltz v2, :cond_4

    .line 33
    .line 34
    const/4 v3, 0x1

    .line 35
    if-lez v2, :cond_2

    .line 36
    .line 37
    const/4 v4, 0x1

    .line 38
    goto :goto_1

    .line 39
    :cond_2
    const/4 v4, 0x0

    .line 40
    :goto_1
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 41
    .line 42
    .line 43
    move-result v0

    .line 44
    sub-int/2addr v0, v3

    .line 45
    if-ge v2, v0, :cond_3

    .line 46
    .line 47
    const/4 v1, 0x1

    .line 48
    :cond_3
    move v0, v1

    .line 49
    move v1, v4

    .line 50
    goto :goto_2

    .line 51
    :cond_4
    const/4 v0, 0x0

    .line 52
    :goto_2
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuPrev:Landroid/view/MenuItem;

    .line 53
    .line 54
    invoke-interface {v2, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 55
    .line 56
    .line 57
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuPrev:Landroid/view/MenuItem;

    .line 58
    .line 59
    invoke-interface {v2}, Landroid/view/MenuItem;->getIcon()Landroid/graphics/drawable/Drawable;

    .line 60
    .line 61
    .line 62
    move-result-object v2

    .line 63
    const/16 v3, 0x50

    .line 64
    .line 65
    const/16 v4, 0xff

    .line 66
    .line 67
    if-eqz v2, :cond_6

    .line 68
    .line 69
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuPrev:Landroid/view/MenuItem;

    .line 70
    .line 71
    invoke-interface {v2}, Landroid/view/MenuItem;->getIcon()Landroid/graphics/drawable/Drawable;

    .line 72
    .line 73
    .line 74
    move-result-object v2

    .line 75
    if-eqz v1, :cond_5

    .line 76
    .line 77
    const/16 v1, 0xff

    .line 78
    .line 79
    goto :goto_3

    .line 80
    :cond_5
    const/16 v1, 0x50

    .line 81
    .line 82
    :goto_3
    invoke-virtual {v2, v1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 83
    .line 84
    .line 85
    :cond_6
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuNext:Landroid/view/MenuItem;

    .line 86
    .line 87
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 88
    .line 89
    .line 90
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuNext:Landroid/view/MenuItem;

    .line 91
    .line 92
    invoke-interface {v1}, Landroid/view/MenuItem;->getIcon()Landroid/graphics/drawable/Drawable;

    .line 93
    .line 94
    .line 95
    move-result-object v1

    .line 96
    if-eqz v1, :cond_8

    .line 97
    .line 98
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuNext:Landroid/view/MenuItem;

    .line 99
    .line 100
    invoke-interface {v1}, Landroid/view/MenuItem;->getIcon()Landroid/graphics/drawable/Drawable;

    .line 101
    .line 102
    .line 103
    move-result-object v1

    .line 104
    if-eqz v0, :cond_7

    .line 105
    .line 106
    const/16 v3, 0xff

    .line 107
    .line 108
    :cond_7
    invoke-virtual {v1, v3}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 109
    .line 110
    .line 111
    :cond_8
    :goto_4
    return-void
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
.end method


# virtual methods
.method public addConnUpdateListener(Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity$ConnUpdateListener;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mListeners:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

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
.end method

.method public connectionsAdded(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 0

    return-void
.end method

.method public connectionsChanges(I)V
    .locals 0

    return-void
.end method

.method public connectionsRemoved(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 0

    return-void
.end method

.method public connectionsUpdated([I)V
    .locals 5

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    goto :goto_1

    .line 8
    :cond_0
    array-length v1, p1

    .line 9
    const/4 v2, 0x0

    .line 10
    :goto_0
    if-ge v2, v1, :cond_2

    .line 11
    .line 12
    aget v3, p1, v2

    .line 13
    .line 14
    invoke-virtual {v0, v3}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConn(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 15
    .line 16
    .line 17
    move-result-object v3

    .line 18
    if-eqz v3, :cond_1

    .line 19
    .line 20
    iget v3, v3, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 21
    .line 22
    iget-object v4, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 23
    .line 24
    iget v4, v4, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 25
    .line 26
    if-ne v3, v4, :cond_1

    .line 27
    .line 28
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHandler:Landroid/os/Handler;

    .line 29
    .line 30
    new-instance v0, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;

    .line 31
    .line 32
    const/16 v1, 0x8

    .line 33
    .line 34
    invoke-direct {v0, v1, p0}, Landroidx/core/app/ActivityCompat$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 35
    .line 36
    .line 37
    invoke-virtual {p1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 38
    .line 39
    .line 40
    return-void

    .line 41
    :cond_1
    add-int/lit8 v2, v2, 0x1

    .line 42
    .line 43
    goto :goto_0

    .line 44
    :cond_2
    :goto_1
    return-void
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

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .line 1
    invoke-super {p0, p1}, Lcom/emanuelef/remote_capture/activities/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/BaseActivity;->displayBackAction()V

    .line 5
    .line 6
    .line 7
    const p1, 0x7f0d00af

    .line 8
    .line 9
    .line 10
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/activities/BaseActivity;->setContentView(I)V

    .line 11
    .line 12
    .line 13
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    const-string v0, "conn_id"

    .line 18
    .line 19
    const/4 v1, -0x1

    .line 20
    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    .line 21
    .line 22
    .line 23
    move-result p1

    .line 24
    iput p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 25
    .line 26
    invoke-virtual {p0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    .line 27
    .line 28
    .line 29
    move-result-object p1

    .line 30
    const-string v0, "filtered_ids"

    .line 31
    .line 32
    invoke-virtual {p1, v0}, Landroid/content/Intent;->getIntegerArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    .line 33
    .line 34
    .line 35
    move-result-object p1

    .line 36
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 37
    .line 38
    iput v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIndex:I

    .line 39
    .line 40
    const/4 v0, 0x0

    .line 41
    const-string v2, "ConnectionDetails"

    .line 42
    .line 43
    if-eqz p1, :cond_2

    .line 44
    .line 45
    const/4 p1, 0x0

    .line 46
    :goto_0
    iget-object v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 47
    .line 48
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 49
    .line 50
    .line 51
    move-result v3

    .line 52
    if-ge p1, v3, :cond_1

    .line 53
    .line 54
    iget-object v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 55
    .line 56
    invoke-virtual {v3, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 57
    .line 58
    .line 59
    move-result-object v3

    .line 60
    check-cast v3, Ljava/lang/Integer;

    .line 61
    .line 62
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    .line 63
    .line 64
    .line 65
    move-result v3

    .line 66
    iget v4, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 67
    .line 68
    if-ne v3, v4, :cond_0

    .line 69
    .line 70
    iput p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIndex:I

    .line 71
    .line 72
    goto :goto_1

    .line 73
    :cond_0
    add-int/lit8 p1, p1, 0x1

    .line 74
    .line 75
    goto :goto_0

    .line 76
    :cond_1
    :goto_1
    new-instance p1, Ljava/lang/StringBuilder;

    .line 77
    .line 78
    const-string v3, "Using filtered navigation: "

    .line 79
    .line 80
    invoke-direct {p1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 81
    .line 82
    .line 83
    iget-object v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIds:Ljava/util/ArrayList;

    .line 84
    .line 85
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    .line 86
    .line 87
    .line 88
    move-result v3

    .line 89
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 90
    .line 91
    .line 92
    const-string v3, " items, index="

    .line 93
    .line 94
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 95
    .line 96
    .line 97
    iget v3, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mFilteredIndex:I

    .line 98
    .line 99
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 100
    .line 101
    .line 102
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 103
    .line 104
    .line 105
    move-result-object p1

    .line 106
    invoke-static {v2, p1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    .line 108
    .line 109
    :cond_2
    iget p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 110
    .line 111
    if-eq p1, v1, :cond_3

    .line 112
    .line 113
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 114
    .line 115
    .line 116
    move-result-object p1

    .line 117
    if-eqz p1, :cond_4

    .line 118
    .line 119
    iget v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 120
    .line 121
    invoke-virtual {p1, v1}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConnById(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 122
    .line 123
    .line 124
    move-result-object p1

    .line 125
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 126
    .line 127
    const p1, 0x7f14009c

    .line 128
    .line 129
    .line 130
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 131
    .line 132
    .line 133
    move-result-object p1

    .line 134
    iget v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 135
    .line 136
    const/4 v3, 0x1

    .line 137
    add-int/2addr v1, v3

    .line 138
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 139
    .line 140
    .line 141
    move-result-object v1

    .line 142
    new-array v3, v3, [Ljava/lang/Object;

    .line 143
    .line 144
    aput-object v1, v3, v0

    .line 145
    .line 146
    invoke-static {p1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 147
    .line 148
    .line 149
    move-result-object p1

    .line 150
    invoke-virtual {p0, p1}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 151
    .line 152
    .line 153
    goto :goto_2

    .line 154
    :cond_3
    const p1, 0x7f140099

    .line 155
    .line 156
    .line 157
    invoke-virtual {p0, p1}, Landroid/app/Activity;->setTitle(I)V

    .line 158
    .line 159
    .line 160
    :cond_4
    :goto_2
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 161
    .line 162
    if-nez p1, :cond_5

    .line 163
    .line 164
    new-instance p1, Ljava/lang/StringBuilder;

    .line 165
    .line 166
    const-string v0, "Connection with ID "

    .line 167
    .line 168
    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 169
    .line 170
    .line 171
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mConnId:I

    .line 172
    .line 173
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 174
    .line 175
    .line 176
    const-string v0, " not found"

    .line 177
    .line 178
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 179
    .line 180
    .line 181
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 182
    .line 183
    .line 184
    move-result-object p1

    .line 185
    invoke-static {v2, p1}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 186
    .line 187
    .line 188
    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    .line 189
    .line 190
    .line 191
    return-void

    .line 192
    :cond_5
    new-instance p1, Landroid/os/Handler;

    .line 193
    .line 194
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 195
    .line 196
    .line 197
    move-result-object v0

    .line 198
    invoke-direct {p1, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 199
    .line 200
    .line 201
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mHandler:Landroid/os/Handler;

    .line 202
    .line 203
    const p1, 0x7f0a0276

    .line 204
    .line 205
    .line 206
    invoke-virtual {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->findViewById(I)Landroid/view/View;

    .line 207
    .line 208
    .line 209
    move-result-object p1

    .line 210
    check-cast p1, Landroidx/viewpager2/widget/ViewPager2;

    .line 211
    .line 212
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 213
    .line 214
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->fixViewPager2Insets(Landroidx/viewpager2/widget/ViewPager2;)V

    .line 215
    .line 216
    .line 217
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->setupTabs()V

    .line 218
    .line 219
    .line 220
    return-void
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2

    .line 1
    invoke-virtual {p0}, Landroidx/appcompat/app/AppCompatActivity;->getMenuInflater()Landroid/view/MenuInflater;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const v1, 0x7f0f0006

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 9
    .line 10
    .line 11
    const v0, 0x7f0a022a

    .line 12
    .line 13
    .line 14
    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 15
    .line 16
    .line 17
    move-result-object v0

    .line 18
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuPrev:Landroid/view/MenuItem;

    .line 19
    .line 20
    const v0, 0x7f0a022b

    .line 21
    .line 22
    .line 23
    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuNext:Landroid/view/MenuItem;

    .line 28
    .line 29
    const v0, 0x7f0a00e3

    .line 30
    .line 31
    .line 32
    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 33
    .line 34
    .line 35
    move-result-object v0

    .line 36
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuCopy:Landroid/view/MenuItem;

    .line 37
    .line 38
    const v0, 0x7f0a02e1

    .line 39
    .line 40
    .line 41
    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 42
    .line 43
    .line 44
    move-result-object v0

    .line 45
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuShare:Landroid/view/MenuItem;

    .line 46
    .line 47
    const v0, 0x7f0a0130

    .line 48
    .line 49
    .line 50
    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 51
    .line 52
    .line 53
    move-result-object p1

    .line 54
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuDisplayAs:Landroid/view/MenuItem;

    .line 55
    .line 56
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->updateNavigationButtons()V

    .line 57
    .line 58
    .line 59
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->updateMenuVisibility()V

    .line 60
    .line 61
    .line 62
    const/4 p1, 0x1

    .line 63
    return p1
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
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 4

    .line 1
    const/16 v0, 0x14

    .line 2
    .line 3
    if-ne p1, v0, :cond_1

    .line 4
    .line 5
    invoke-virtual {p0}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    const-string v2, "onKeyDown focus "

    .line 18
    .line 19
    invoke-virtual {v2, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v1

    .line 23
    const-string v2, "ConnectionDetails"

    .line 24
    .line 25
    invoke-static {v2, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    .line 27
    .line 28
    instance-of v0, v0, Lcom/google/android/material/tabs/TabLayout$TabView;

    .line 29
    .line 30
    if-eqz v0, :cond_1

    .line 31
    .line 32
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 33
    .line 34
    invoke-virtual {v0}, Landroidx/viewpager2/widget/ViewPager2;->getCurrentItem()I

    .line 35
    .line 36
    .line 37
    move-result v0

    .line 38
    new-instance v1, Ljava/lang/StringBuilder;

    .line 39
    .line 40
    const-string v3, "TabLayout.TabView focus pos "

    .line 41
    .line 42
    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 43
    .line 44
    .line 45
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 46
    .line 47
    .line 48
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 49
    .line 50
    .line 51
    move-result-object v1

    .line 52
    invoke-static {v2, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    .line 54
    .line 55
    if-nez v0, :cond_0

    .line 56
    .line 57
    const v0, 0x7f0a00cd

    .line 58
    .line 59
    .line 60
    invoke-virtual {p0, v0}, Landroidx/appcompat/app/AppCompatActivity;->findViewById(I)Landroid/view/View;

    .line 61
    .line 62
    .line 63
    move-result-object v0

    .line 64
    goto :goto_0

    .line 65
    :cond_0
    const v0, 0x7f0a0281

    .line 66
    .line 67
    .line 68
    invoke-virtual {p0, v0}, Landroidx/appcompat/app/AppCompatActivity;->findViewById(I)Landroid/view/View;

    .line 69
    .line 70
    .line 71
    move-result-object v0

    .line 72
    :goto_0
    if-eqz v0, :cond_1

    .line 73
    .line 74
    invoke-virtual {v0}, Landroid/view/View;->requestFocus()Z

    .line 75
    .line 76
    .line 77
    const/4 p1, 0x1

    .line 78
    return p1

    .line 79
    :cond_1
    invoke-super {p0, p1, p2}, Landroidx/appcompat/app/AppCompatActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    .line 80
    .line 81
    .line 82
    move-result p1

    .line 83
    return p1
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

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .line 1
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    const v1, 0x7f0a022a

    .line 6
    .line 7
    .line 8
    const/4 v2, 0x1

    .line 9
    if-ne v0, v1, :cond_0

    .line 10
    .line 11
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->navigateToPrevious()V

    .line 12
    .line 13
    .line 14
    return v2

    .line 15
    :cond_0
    const v1, 0x7f0a022b

    .line 16
    .line 17
    .line 18
    if-ne v0, v1, :cond_1

    .line 19
    .line 20
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->navigateToNext()V

    .line 21
    .line 22
    .line 23
    return v2

    .line 24
    :cond_1
    const v1, 0x7f0a0130

    .line 25
    .line 26
    .line 27
    if-ne v0, v1, :cond_3

    .line 28
    .line 29
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mDisplayMode:Ljava/lang/Boolean;

    .line 30
    .line 31
    if-eqz p1, :cond_2

    .line 32
    .line 33
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    .line 34
    .line 35
    .line 36
    move-result p1

    .line 37
    xor-int/2addr p1, v2

    .line 38
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 39
    .line 40
    .line 41
    move-result-object p1

    .line 42
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mDisplayMode:Ljava/lang/Boolean;

    .line 43
    .line 44
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->updateMenuVisibility()V

    .line 45
    .line 46
    .line 47
    :cond_2
    return v2

    .line 48
    :cond_3
    invoke-super {p0, p1}, Lcom/emanuelef/remote_capture/activities/BaseActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    .line 49
    .line 50
    .line 51
    move-result p1

    .line 52
    return p1
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public onPause()V
    .locals 0

    .line 1
    invoke-super {p0}, Landroidx/fragment/app/FragmentActivity;->onPause()V

    .line 2
    .line 3
    .line 4
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->unregisterConnsListener()V

    .line 5
    .line 6
    .line 7
    return-void
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
.end method

.method public onResume()V
    .locals 0

    .line 1
    invoke-super {p0}, Landroidx/fragment/app/FragmentActivity;->onResume()V

    .line 2
    .line 3
    .line 4
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->registerConnsListener()V

    .line 5
    .line 6
    .line 7
    return-void
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
.end method

.method public removeConnUpdateListener(Lcom/emanuelef/remote_capture/interfaces/PayloadHostActivity$ConnUpdateListener;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mListeners:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

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
.end method

.method public updateMenuVisibility()V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuCopy:Landroid/view/MenuItem;

    .line 2
    .line 3
    if-eqz v0, :cond_7

    .line 4
    .line 5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuShare:Landroid/view/MenuItem;

    .line 6
    .line 7
    if-eqz v0, :cond_7

    .line 8
    .line 9
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuDisplayAs:Landroid/view/MenuItem;

    .line 10
    .line 11
    if-nez v0, :cond_0

    .line 12
    .line 13
    goto :goto_2

    .line 14
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPager:Landroidx/viewpager2/widget/ViewPager2;

    .line 15
    .line 16
    invoke-virtual {v0}, Landroidx/viewpager2/widget/ViewPager2;->getCurrentItem()I

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mPagerAdapter:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;

    .line 21
    .line 22
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->getVisibleTabsPositions()[I

    .line 23
    .line 24
    .line 25
    move-result-object v1

    .line 26
    array-length v2, v1

    .line 27
    const/4 v3, 0x0

    .line 28
    if-ge v0, v2, :cond_1

    .line 29
    .line 30
    aget v0, v1, v0

    .line 31
    .line 32
    goto :goto_0

    .line 33
    :cond_1
    const/4 v0, 0x0

    .line 34
    :goto_0
    const/4 v1, 0x1

    .line 35
    if-nez v0, :cond_2

    .line 36
    .line 37
    const/4 v2, 0x1

    .line 38
    goto :goto_1

    .line 39
    :cond_2
    const/4 v2, 0x0

    .line 40
    :goto_1
    iget-object v4, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuCopy:Landroid/view/MenuItem;

    .line 41
    .line 42
    invoke-interface {v4, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 43
    .line 44
    .line 45
    iget-object v4, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuShare:Landroid/view/MenuItem;

    .line 46
    .line 47
    invoke-interface {v4, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 48
    .line 49
    .line 50
    if-eq v0, v1, :cond_3

    .line 51
    .line 52
    const/4 v2, 0x2

    .line 53
    if-eq v0, v2, :cond_3

    .line 54
    .line 55
    const/4 v2, 0x3

    .line 56
    if-ne v0, v2, :cond_4

    .line 57
    .line 58
    :cond_3
    const/4 v3, 0x1

    .line 59
    :cond_4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuDisplayAs:Landroid/view/MenuItem;

    .line 60
    .line 61
    invoke-interface {v0, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 62
    .line 63
    .line 64
    if-eqz v3, :cond_7

    .line 65
    .line 66
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->getCurrentFragment()Landroidx/fragment/app/Fragment;

    .line 67
    .line 68
    .line 69
    move-result-object v0

    .line 70
    instance-of v1, v0, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    .line 71
    .line 72
    if-eqz v1, :cond_7

    .line 73
    .line 74
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    .line 75
    .line 76
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mDisplayMode:Ljava/lang/Boolean;

    .line 77
    .line 78
    if-nez v1, :cond_5

    .line 79
    .line 80
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->guessDisplayAsPrintable()Z

    .line 81
    .line 82
    .line 83
    move-result v1

    .line 84
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 85
    .line 86
    .line 87
    move-result-object v1

    .line 88
    iput-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mDisplayMode:Ljava/lang/Boolean;

    .line 89
    .line 90
    :cond_5
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mDisplayMode:Ljava/lang/Boolean;

    .line 91
    .line 92
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    .line 93
    .line 94
    .line 95
    move-result v1

    .line 96
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->setDisplayMode(Z)V

    .line 97
    .line 98
    .line 99
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mDisplayMode:Ljava/lang/Boolean;

    .line 100
    .line 101
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    .line 102
    .line 103
    .line 104
    move-result v0

    .line 105
    if-eqz v0, :cond_6

    .line 106
    .line 107
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuDisplayAs:Landroid/view/MenuItem;

    .line 108
    .line 109
    const v1, 0x7f1400d5

    .line 110
    .line 111
    .line 112
    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 113
    .line 114
    .line 115
    return-void

    .line 116
    :cond_6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->mMenuDisplayAs:Landroid/view/MenuItem;

    .line 117
    .line 118
    const v1, 0x7f1400d6

    .line 119
    .line 120
    .line 121
    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 122
    .line 123
    .line 124
    :cond_7
    :goto_2
    return-void
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
.end method
