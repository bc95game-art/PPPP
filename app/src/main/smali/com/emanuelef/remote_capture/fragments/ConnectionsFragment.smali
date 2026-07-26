.class public Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;
.super Landroidx/fragment/app/Fragment;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;
.implements Landroidx/core/view/MenuProvider;
.implements Landroidx/appcompat/widget/SearchView$OnQueryTextListener;


# static fields
.field static final synthetic $assertionsDisabled:Z = false

.field public static final FILTER_EXTRA:Ljava/lang/String; = "filter"

.field public static final QUERY_EXTRA:Ljava/lang/String; = "query"

.field private static final TAG:Ljava/lang/String; = "ConnectionsFragment"

.field private static maliciousWarningShown:Z = false


# instance fields
.field private autoScroll:Z

.field private final csvFileLauncher:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher;"
        }
    .end annotation
.end field

.field private final filterLauncher:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher;"
        }
    .end annotation
.end field

.field private listenerSet:Z

.field private mActionMode:Landroidx/appcompat/view/ActionMode;

.field private final mActionModeCallback:Landroidx/appcompat/view/ActionMode$Callback;

.field private mActiveFilter:Lcom/google/android/material/chip/ChipGroup;

.field private mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

.field private mAlertDialog:Landroidx/appcompat/app/AlertDialog;

.field private mApps:Lcom/emanuelef/remote_capture/AppsResolver;

.field private mCsvFname:Landroid/net/Uri;

.field private mDecRemoveCidr:Ljava/lang/String;

.field private mEmptyText:Landroid/widget/TextView;

.field private mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

.field private mFabDownMargin:I

.field private mHandler:Landroid/os/Handler;

.field private mMenuFilter:Landroid/view/MenuItem;

.field private mMenuItemSearch:Landroid/view/MenuItem;

.field private mOldConnectionsText:Landroid/widget/TextView;

.field private mQueryToApply:Ljava/lang/String;

.field private mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

.field private mSave:Landroid/view/MenuItem;

.field private mSearchView:Landroidx/appcompat/widget/SearchView;

.field private mSizeSlider:Lcom/google/android/material/slider/Slider;

.field private mSizeSliderActive:Z

.field private mUnblockCidr:Ljava/lang/String;


# direct methods
.method public static synthetic $r8$lambda$-jPZzyYkl4_haGqIqyD4qt0rzqA(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$5(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$-y0qPkFKolPIQLo1syBv22cRf6o(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$6(Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$0yCjVqMmk0sRHT_pL5GofaHBph8(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroidx/activity/result/ActivityResult;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->csvFileResult(Landroidx/activity/result/ActivityResult;)V

    return-void
.end method

.method public static synthetic $r8$lambda$4NgwRhx9Ime1O-7o4_osPjOTrRM([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$dumpCsv$16([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$5cF8ia8PXqnqRV0KtTRoodE4DLQ(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$connectionsAdded$13([Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$AkGpVN0JfqBffPOlDMcfyaZTTeQ(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$7(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$IwENEU-wpsLdtefu3p5ZnNp1mHM([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    invoke-static {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$dumpCsv$17([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$J5V83fUG3ZNsHra7Hq9WpCdpD0U(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$8(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$JBbpJOAQZYP70gdFbh4gBtga98s(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$connectionsRemoved$14([Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$JDoKEj9jBdmY5gyKNMrepMwQmA0(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$showFirewallPurchaseDialog$11(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$JdiiNLz_eSFgp4uRbtsMk5ttKK0(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/net/Uri;Ljava/lang/String;[ZLandroid/os/Handler;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$dumpCsv$20(Landroid/net/Uri;Ljava/lang/String;[ZLandroid/os/Handler;)V

    return-void
.end method

.method public static synthetic $r8$lambda$LINS4buikrlfN6QRYhH11RmDTnY(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/view/View;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$4(Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$No4-RiTH4DVP9vnRpl7aSA13XDA(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$showFirewallPurchaseDialog$10(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$OZ9GlrhRgpoWUTixc-ciKULZaoE(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$9(Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Oo3FeU_lbLwIJhdberAbQ7alkQw(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$connectionsChanges$12(I)V

    return-void
.end method

.method public static synthetic $r8$lambda$PChHljCW0VDxUGxi1vus8RAjMU4(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$3(Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$YXVcoZuaPC38GYR64MVBNihF3tc(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;ZLcom/emanuelef/remote_capture/Utils$UriStat;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$dumpCsv$19(ZLcom/emanuelef/remote_capture/Utils$UriStat;)V

    return-void
.end method

.method public static synthetic $r8$lambda$daLjhKZgCTiO8fnkCHA5vCWvRXo(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;[I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$connectionsUpdated$15([I)V

    return-void
.end method

.method public static synthetic $r8$lambda$fKYnJ451oMZJyWojKShO-4j93LM(F)Ljava/lang/String;
    .locals 0

    .line 1
    invoke-static {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$0(F)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$jI7Wc-bOuJv-rKNjRIMIbbHbN88(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroidx/activity/result/ActivityResult;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->filterResult(Landroidx/activity/result/ActivityResult;)V

    return-void
.end method

.method public static synthetic $r8$lambda$jcnRAsddpCgukZD-sO6_1YxR3_s(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$dumpCsv$18(Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$k7JlOw7fIvBc9VLimWzzhusaq7o(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Lcom/google/android/material/slider/Slider;FZ)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$1(Lcom/google/android/material/slider/Slider;FZ)V

    return-void
.end method

.method public static synthetic $r8$lambda$tcaOO4xMux9zrJF7xG4n410WfYA(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/util/ArrayList;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->lambda$onViewCreated$2(Lcom/google/android/material/chip/ChipGroup;Ljava/util/List;)V

    return-void
.end method

.method public static bridge synthetic -$$Nest$fgetmAdapter(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fputmActionMode(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V
    .locals 1

    .line 1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    return-void
.end method

.method public static bridge synthetic -$$Nest$fputmSizeSliderActive(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Z)V
    .locals 0

    .line 1
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSliderActive:Z

    return-void
.end method

.method public static bridge synthetic -$$Nest$mrecheckMaxConnectionSize(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckMaxConnectionSize()V

    return-void
.end method

.method public static bridge synthetic -$$Nest$mrecheckScroll(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckScroll()V

    return-void
.end method

.method public static bridge synthetic -$$Nest$mupdateActionModeTitle(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->updateActionModeTitle()V

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .line 1
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDownMargin:I

    .line 6
    .line 7
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSliderActive:Z

    .line 8
    .line 9
    new-instance v0, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;

    .line 10
    .line 11
    const/4 v1, 0x3

    .line 12
    invoke-direct {v0, v1}, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;-><init>(I)V

    .line 13
    .line 14
    .line 15
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;

    .line 16
    .line 17
    const/4 v2, 0x0

    .line 18
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V

    .line 19
    .line 20
    .line 21
    invoke-virtual {p0, v0, v1}, Landroidx/fragment/app/Fragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->csvFileLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 26
    .line 27
    new-instance v0, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;

    .line 28
    .line 29
    const/4 v1, 0x3

    .line 30
    invoke-direct {v0, v1}, Landroidx/fragment/app/FragmentManager$FragmentIntentSenderContract;-><init>(I)V

    .line 31
    .line 32
    .line 33
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;

    .line 34
    .line 35
    const/4 v2, 0x3

    .line 36
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V

    .line 37
    .line 38
    .line 39
    invoke-virtual {p0, v0, v1}, Landroidx/fragment/app/Fragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->filterLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 44
    .line 45
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$3;

    .line 46
    .line 47
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$3;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V

    .line 48
    .line 49
    .line 50
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionModeCallback:Landroidx/appcompat/view/ActionMode$Callback;

    .line 51
    .line 52
    return-void
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method private csvFileResult(Landroidx/activity/result/ActivityResult;)V
    .locals 2

    .line 1
    iget v0, p1, Landroidx/activity/result/ActivityResult;->mResultCode:I

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    if-ne v0, v1, :cond_0

    .line 5
    .line 6
    iget-object p1, p1, Landroidx/activity/result/ActivityResult;->mData:Landroid/content/Intent;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mCsvFname:Landroid/net/Uri;

    .line 15
    .line 16
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->dumpCsv()V

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :cond_0
    const/4 p1, 0x0

    .line 21
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mCsvFname:Landroid/net/Uri;

    .line 22
    .line 23
    return-void
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

.method private dumpCsv()V
    .locals 10

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mCsvFname:Landroid/net/Uri;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    .line 7
    .line 8
    const-string v1, "Writing CSV file: "

    .line 9
    .line 10
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mCsvFname:Landroid/net/Uri;

    .line 14
    .line 15
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 16
    .line 17
    .line 18
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    const-string v1, "ConnectionsFragment"

    .line 23
    .line 24
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 28
    .line 29
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 30
    .line 31
    const/4 v2, 0x1

    .line 32
    const/4 v3, 0x0

    .line 33
    if-eqz v1, :cond_1

    .line 34
    .line 35
    const/4 v1, 0x1

    .line 36
    goto :goto_0

    .line 37
    :cond_1
    const/4 v1, 0x0

    .line 38
    :goto_0
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->dumpConnectionsCsv(Z)Ljava/lang/String;

    .line 39
    .line 40
    .line 41
    move-result-object v7

    .line 42
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    .line 43
    .line 44
    .line 45
    move-result-object v0

    .line 46
    new-instance v9, Landroid/os/Handler;

    .line 47
    .line 48
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 49
    .line 50
    .line 51
    move-result-object v1

    .line 52
    invoke-direct {v9, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 53
    .line 54
    .line 55
    new-array v8, v2, [Z

    .line 56
    .line 57
    aput-boolean v3, v8, v3

    .line 58
    .line 59
    new-instance v1, Lcom/android/billingclient/api/zzbv;

    .line 60
    .line 61
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 62
    .line 63
    .line 64
    move-result-object v4

    .line 65
    invoke-direct {v1, v4}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 66
    .line 67
    .line 68
    const v4, 0x7f140108

    .line 69
    .line 70
    .line 71
    invoke-virtual {v1, v4}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 72
    .line 73
    .line 74
    const v4, 0x7f140107

    .line 75
    .line 76
    .line 77
    invoke-virtual {v1, v4}, Lcom/android/billingclient/api/zzbv;->setMessage(I)V

    .line 78
    .line 79
    .line 80
    new-instance v4, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;

    .line 81
    .line 82
    invoke-direct {v4, v8, v0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda4;-><init>([ZLjava/util/concurrent/ExecutorService;I)V

    .line 83
    .line 84
    .line 85
    const/high16 v5, 0x1040000

    .line 86
    .line 87
    invoke-virtual {v1, v5, v4}, Lcom/android/billingclient/api/zzbv;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 88
    .line 89
    .line 90
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzbv;->create()Landroidx/appcompat/app/AlertDialog;

    .line 91
    .line 92
    .line 93
    move-result-object v1

    .line 94
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 95
    .line 96
    invoke-virtual {v1, v3}, Landroid/app/Dialog;->setCanceledOnTouchOutside(Z)V

    .line 97
    .line 98
    .line 99
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 100
    .line 101
    invoke-virtual {v1}, Landroid/app/Dialog;->show()V

    .line 102
    .line 103
    .line 104
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 105
    .line 106
    new-instance v3, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda5;

    .line 107
    .line 108
    invoke-direct {v3, v8, v0, v2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda5;-><init>([ZLjava/util/concurrent/ExecutorService;I)V

    .line 109
    .line 110
    .line 111
    invoke-virtual {v1, v3}, Landroid/app/Dialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 112
    .line 113
    .line 114
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 115
    .line 116
    new-instance v2, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;

    .line 117
    .line 118
    const/4 v3, 0x3

    .line 119
    invoke-direct {v2, v3, p0}, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda3;-><init>(ILjava/lang/Object;)V

    .line 120
    .line 121
    .line 122
    invoke-virtual {v1, v2}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 123
    .line 124
    .line 125
    iget-object v6, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mCsvFname:Landroid/net/Uri;

    .line 126
    .line 127
    const/4 v1, 0x0

    .line 128
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mCsvFname:Landroid/net/Uri;

    .line 129
    .line 130
    new-instance v4, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;

    .line 131
    .line 132
    move-object v5, p0

    .line 133
    invoke-direct/range {v4 .. v9}, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/net/Uri;Ljava/lang/String;[ZLandroid/os/Handler;)V

    .line 134
    .line 135
    .line 136
    invoke-interface {v0, v4}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 137
    .line 138
    .line 139
    return-void
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

.method private filterResult(Landroidx/activity/result/ActivityResult;)V
    .locals 2

    .line 1
    iget v0, p1, Landroidx/activity/result/ActivityResult;->mResultCode:I

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    if-ne v0, v1, :cond_0

    .line 5
    .line 6
    iget-object p1, p1, Landroidx/activity/result/ActivityResult;->mData:Landroid/content/Intent;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    const-string v0, "filter"

    .line 11
    .line 12
    const-class v1, Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 13
    .line 14
    invoke-static {p1, v0, v1}, Lcom/emanuelef/remote_capture/Utils;->getSerializableExtra(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Class;)Ljava/io/Serializable;

    .line 15
    .line 16
    .line 17
    move-result-object p1

    .line 18
    check-cast p1, Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 19
    .line 20
    if-eqz p1, :cond_0

    .line 21
    .line 22
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 23
    .line 24
    iput-object p1, v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 25
    .line 26
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->refreshFilteredConnections()V

    .line 27
    .line 28
    .line 29
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshActiveFilter()V

    .line 30
    .line 31
    .line 32
    :cond_0
    return-void
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

.method private synthetic lambda$connectionsAdded$13([Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V
    .locals 2

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "Add "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    array-length v1, p1

    .line 9
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 10
    .line 11
    .line 12
    const-string v1, " connections at "

    .line 13
    .line 14
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 15
    .line 16
    .line 17
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 18
    .line 19
    .line 20
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    const-string v1, "ConnectionsFragment"

    .line 25
    .line 26
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    .line 28
    .line 29
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 30
    .line 31
    invoke-virtual {v0, p2, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->connectionsAdded(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V

    .line 32
    .line 33
    .line 34
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->autoScroll:Z

    .line 35
    .line 36
    if-eqz p1, :cond_0

    .line 37
    .line 38
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->scrollToBottom()V

    .line 39
    .line 40
    .line 41
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckUntrackedConnections()V

    .line 42
    .line 43
    .line 44
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckMaxConnectionSize()V

    .line 45
    .line 46
    .line 47
    return-void
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

.method private synthetic lambda$connectionsChanges$12(I)V
    .locals 2

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "New connections size: "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 9
    .line 10
    .line 11
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    const-string v1, "ConnectionsFragment"

    .line 16
    .line 17
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 21
    .line 22
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->connectionsChanges(I)V

    .line 23
    .line 24
    .line 25
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckScroll()V

    .line 26
    .line 27
    .line 28
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->autoScroll:Z

    .line 29
    .line 30
    if-eqz p1, :cond_0

    .line 31
    .line 32
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->scrollToBottom()V

    .line 33
    .line 34
    .line 35
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckUntrackedConnections()V

    .line 36
    .line 37
    .line 38
    return-void
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

.method private synthetic lambda$connectionsRemoved$14([Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V
    .locals 2

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "Remove "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    array-length v1, p1

    .line 9
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 10
    .line 11
    .line 12
    const-string v1, " connections at "

    .line 13
    .line 14
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 15
    .line 16
    .line 17
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 18
    .line 19
    .line 20
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    const-string v1, "ConnectionsFragment"

    .line 25
    .line 26
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    .line 28
    .line 29
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 30
    .line 31
    invoke-virtual {v0, p2, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->connectionsRemoved(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V

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

.method private synthetic lambda$connectionsUpdated$15([I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->connectionsUpdated([I)V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckMaxConnectionSize()V

    .line 7
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

.method private static synthetic lambda$dumpCsv$16([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    const-string p2, "ConnectionsFragment"

    .line 2
    .line 3
    const-string p3, "Abort CSV export"

    .line 4
    .line 5
    invoke-static {p2, p3}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 p2, 0x0

    .line 9
    const/4 p3, 0x1

    .line 10
    aput-boolean p3, p0, p2

    .line 11
    .line 12
    invoke-interface {p1}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    .line 13
    .line 14
    .line 15
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method

.method private static synthetic lambda$dumpCsv$17([ZLjava/util/concurrent/ExecutorService;Landroid/content/DialogInterface;)V
    .locals 1

    .line 1
    const-string p2, "ConnectionsFragment"

    .line 2
    .line 3
    const-string v0, "Abort CSV export (back button)"

    .line 4
    .line 5
    invoke-static {p2, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 p2, 0x0

    .line 9
    const/4 v0, 0x1

    .line 10
    aput-boolean v0, p0, p2

    .line 11
    .line 12
    invoke-interface {p1}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    .line 13
    .line 14
    .line 15
    return-void
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
.end method

.method private synthetic lambda$dumpCsv$18(Landroid/content/DialogInterface;)V
    .locals 0

    .line 1
    const/4 p1, 0x0

    .line 2
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 3
    .line 4
    return-void
    .line 5
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

.method private synthetic lambda$dumpCsv$19(ZLcom/emanuelef/remote_capture/Utils$UriStat;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroidx/appcompat/app/AlertDialog;->dismiss()V

    .line 6
    .line 7
    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    if-eqz p1, :cond_2

    .line 10
    .line 11
    if-eqz p2, :cond_1

    .line 12
    .line 13
    const p1, 0x7f14010e

    .line 14
    .line 15
    .line 16
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    iget-object p2, p2, Lcom/emanuelef/remote_capture/Utils$UriStat;->name:Ljava/lang/String;

    .line 21
    .line 22
    const/4 v1, 0x1

    .line 23
    new-array v1, v1, [Ljava/lang/Object;

    .line 24
    .line 25
    aput-object p2, v1, v0

    .line 26
    .line 27
    invoke-static {p1, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 32
    .line 33
    .line 34
    move-result-object p2

    .line 35
    invoke-static {p2, p1, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 36
    .line 37
    .line 38
    move-result-object p1

    .line 39
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 40
    .line 41
    .line 42
    goto :goto_0

    .line 43
    :cond_1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 44
    .line 45
    .line 46
    move-result-object p1

    .line 47
    const p2, 0x7f14027f

    .line 48
    .line 49
    .line 50
    new-array v0, v0, [Ljava/lang/Object;

    .line 51
    .line 52
    invoke-static {p1, p2, v0}, Lcom/emanuelef/remote_capture/Utils;->showToast(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 53
    .line 54
    .line 55
    goto :goto_0

    .line 56
    :cond_2
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 57
    .line 58
    .line 59
    move-result-object p1

    .line 60
    const p2, 0x7f14006e

    .line 61
    .line 62
    .line 63
    new-array v0, v0, [Ljava/lang/Object;

    .line 64
    .line 65
    invoke-static {p1, p2, v0}, Lcom/emanuelef/remote_capture/Utils;->showToast(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 66
    .line 67
    .line 68
    :goto_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 69
    .line 70
    if-eqz p1, :cond_3

    .line 71
    .line 72
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 73
    .line 74
    .line 75
    :cond_3
    return-void
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

.method private synthetic lambda$dumpCsv$20(Landroid/net/Uri;Ljava/lang/String;[ZLandroid/os/Handler;)V
    .locals 3

    .line 1
    const/4 v0, 0x0

    .line 2
    :try_start_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 3
    .line 4
    .line 5
    move-result-object v1

    .line 6
    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    .line 7
    .line 8
    .line 9
    move-result-object v1

    .line 10
    const-string v2, "rwt"

    .line 11
    .line 12
    invoke-virtual {v1, p1, v2}, Landroid/content/ContentResolver;->openOutputStream(Landroid/net/Uri;Ljava/lang/String;)Ljava/io/OutputStream;

    .line 13
    .line 14
    .line 15
    move-result-object v1

    .line 16
    if-eqz v1, :cond_0

    .line 17
    .line 18
    sget-object v2, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    .line 19
    .line 20
    invoke-virtual {p2, v2}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    .line 21
    .line 22
    .line 23
    move-result-object p2

    .line 24
    invoke-virtual {v1, p2}, Ljava/io/OutputStream;->write([B)V

    .line 25
    .line 26
    .line 27
    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 28
    .line 29
    .line 30
    const/4 p2, 0x1

    .line 31
    goto :goto_0

    .line 32
    :catch_0
    move-exception p2

    .line 33
    aget-boolean v1, p3, v0

    .line 34
    .line 35
    if-nez v1, :cond_0

    .line 36
    .line 37
    invoke-virtual {p2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 38
    .line 39
    .line 40
    :cond_0
    const/4 p2, 0x0

    .line 41
    :goto_0
    aget-boolean p3, p3, v0

    .line 42
    .line 43
    if-eqz p3, :cond_1

    .line 44
    .line 45
    return-void

    .line 46
    :cond_1
    if-eqz p2, :cond_2

    .line 47
    .line 48
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 49
    .line 50
    .line 51
    move-result-object p3

    .line 52
    invoke-static {p3, p1}, Lcom/emanuelef/remote_capture/Utils;->getUriStat(Landroid/content/Context;Landroid/net/Uri;)Lcom/emanuelef/remote_capture/Utils$UriStat;

    .line 53
    .line 54
    .line 55
    move-result-object p1

    .line 56
    goto :goto_1

    .line 57
    :cond_2
    const/4 p1, 0x0

    .line 58
    :goto_1
    new-instance p3, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;

    .line 59
    .line 60
    const/4 v0, 0x0

    .line 61
    invoke-direct {p3, v0, p0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda6;-><init>(ILjava/lang/Object;Ljava/lang/Object;Z)V

    .line 62
    .line 63
    .line 64
    invoke-virtual {p4, p3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 65
    .line 66
    .line 67
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method

.method private static synthetic lambda$onViewCreated$0(F)Ljava/lang/String;
    .locals 4

    .line 1
    float-to-long v0, p0

    .line 2
    const-wide/16 v2, 0x400

    .line 3
    .line 4
    mul-long v0, v0, v2

    .line 5
    .line 6
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    .line 7
    .line 8
    .line 9
    move-result-object p0

    .line 10
    return-object p0
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

.method private synthetic lambda$onViewCreated$1(Lcom/google/android/material/slider/Slider;FZ)V
    .locals 2

    .line 1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 6
    .line 7
    float-to-long p2, p2

    .line 8
    const-wide/16 v0, 0x400

    .line 9
    .line 10
    mul-long p2, p2, v0

    .line 11
    .line 12
    iput-wide p2, p1, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->minSize:J

    .line 13
    .line 14
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshFilteredConnections()V

    .line 15
    .line 16
    .line 17
    :cond_0
    return-void
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
.end method

.method private synthetic lambda$onViewCreated$2(Lcom/google/android/material/chip/ChipGroup;Ljava/util/List;)V
    .locals 1

    .line 1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    if-eqz p1, :cond_1

    .line 4
    .line 5
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 10
    .line 11
    .line 12
    move-result p2

    .line 13
    if-eqz p2, :cond_0

    .line 14
    .line 15
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object p2

    .line 19
    check-cast p2, Ljava/lang/Integer;

    .line 20
    .line 21
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    .line 22
    .line 23
    .line 24
    move-result p2

    .line 25
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 26
    .line 27
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 28
    .line 29
    invoke-virtual {v0, p2}, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->clear(I)V

    .line 30
    .line 31
    .line 32
    goto :goto_0

    .line 33
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshFilteredConnections()V

    .line 34
    .line 35
    .line 36
    :cond_1
    return-void
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

.method private synthetic lambda$onViewCreated$3(Landroid/view/View;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 8
    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->toggleSelection(I)V

    .line 12
    .line 13
    .line 14
    return-void

    .line 15
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 16
    .line 17
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    if-eqz p1, :cond_2

    .line 22
    .line 23
    new-instance v0, Landroid/content/Intent;

    .line 24
    .line 25
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    const-class v2, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 30
    .line 31
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 32
    .line 33
    .line 34
    const-string v1, "conn_id"

    .line 35
    .line 36
    iget p1, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 37
    .line 38
    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 39
    .line 40
    .line 41
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 42
    .line 43
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->hasFilter()Z

    .line 44
    .line 45
    .line 46
    move-result p1

    .line 47
    if-eqz p1, :cond_1

    .line 48
    .line 49
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 50
    .line 51
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getFilteredConnectionIds()Ljava/util/ArrayList;

    .line 52
    .line 53
    .line 54
    move-result-object p1

    .line 55
    if-eqz p1, :cond_1

    .line 56
    .line 57
    const-string v1, "filtered_ids"

    .line 58
    .line 59
    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putIntegerArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 60
    .line 61
    .line 62
    :cond_1
    invoke-virtual {p0, v0}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 63
    .line 64
    .line 65
    :cond_2
    return-void
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

.method private synthetic lambda$onViewCreated$4(Landroid/view/View;)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 6
    .line 7
    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->getChildLayoutPosition(Landroid/view/View;)I

    .line 8
    .line 9
    .line 10
    move-result p1

    .line 11
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->toggleSelection(I)V

    .line 12
    .line 13
    .line 14
    const/4 p1, 0x1

    .line 15
    return p1

    .line 16
    :cond_0
    const/4 p1, 0x0

    .line 17
    return p1
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

.method private static lambda$onViewCreated$5(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 5

    .line 1
    const/16 v0, 0x87

    .line 2
    .line 3
    iget-object v1, p1, Landroidx/core/view/WindowInsetsCompat;->mImpl:Landroidx/core/view/WindowInsetsCompat$Impl;

    .line 4
    .line 5
    invoke-virtual {v1, v0}, Landroidx/core/view/WindowInsetsCompat$Impl;->getInsets(I)Landroidx/core/graphics/Insets;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    iget v1, v0, Landroidx/core/graphics/Insets;->left:I

    .line 10
    .line 11
    iget v2, v0, Landroidx/core/graphics/Insets;->top:I

    .line 12
    .line 13
    iget v3, v0, Landroidx/core/graphics/Insets;->right:I

    .line 14
    .line 15
    const/4 v4, 0x0

    .line 16
    invoke-virtual {p0, v1, v2, v3, v4}, Landroid/view/View;->setPadding(IIII)V

    .line 17
    .line 18
    .line 19
    iget p0, v0, Landroidx/core/graphics/Insets;->left:I

    .line 20
    .line 21
    iget-object p1, p1, Landroidx/core/view/WindowInsetsCompat;->mImpl:Landroidx/core/view/WindowInsetsCompat$Impl;

    .line 22
    .line 23
    invoke-virtual {p1, p0, v2, v3, v4}, Landroidx/core/view/WindowInsetsCompat$Impl;->inset(IIII)Landroidx/core/view/WindowInsetsCompat;

    .line 24
    .line 25
    .line 26
    move-result-object p0

    .line 27
    return-object p0
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

.method private synthetic lambda$onViewCreated$6(Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->scrollToBottom()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
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

.method private lambda$onViewCreated$7(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 2

    .line 1
    const/16 v0, 0x8f

    .line 2
    .line 3
    iget-object p2, p2, Landroidx/core/view/WindowInsetsCompat;->mImpl:Landroidx/core/view/WindowInsetsCompat$Impl;

    .line 4
    .line 5
    invoke-virtual {p2, v0}, Landroidx/core/view/WindowInsetsCompat$Impl;->getInsets(I)Landroidx/core/graphics/Insets;

    .line 6
    .line 7
    .line 8
    move-result-object p2

    .line 9
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 14
    .line 15
    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDownMargin:I

    .line 16
    .line 17
    if-nez v1, :cond_0

    .line 18
    .line 19
    iget v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 20
    .line 21
    iput v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDownMargin:I

    .line 22
    .line 23
    :cond_0
    iget v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDownMargin:I

    .line 24
    .line 25
    iget p2, p2, Landroidx/core/graphics/Insets;->bottom:I

    .line 26
    .line 27
    add-int/2addr v1, p2

    .line 28
    iput v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 29
    .line 30
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 31
    .line 32
    .line 33
    sget-object p1, Landroidx/core/view/WindowInsetsCompat;->CONSUMED:Landroidx/core/view/WindowInsetsCompat;

    .line 34
    .line 35
    return-object p1
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

.method private static synthetic lambda$onViewCreated$8(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private synthetic lambda$onViewCreated$9(Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;->STARTED:Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    .line 2
    .line 3
    if-ne p1, v0, :cond_1

    .line 4
    .line 5
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->listenerSet:Z

    .line 6
    .line 7
    if-eqz p1, :cond_0

    .line 8
    .line 9
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->unregisterConnsListener()V

    .line 10
    .line 11
    .line 12
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->registerConnsListener()V

    .line 13
    .line 14
    .line 15
    :cond_0
    const/4 p1, 0x1

    .line 16
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->autoScroll:Z

    .line 17
    .line 18
    const/4 p1, 0x0

    .line 19
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFabDown(Z)V

    .line 20
    .line 21
    .line 22
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mOldConnectionsText:Landroid/widget/TextView;

    .line 23
    .line 24
    const/16 v0, 0x8

    .line 25
    .line 26
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 27
    .line 28
    .line 29
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mEmptyText:Landroid/widget/TextView;

    .line 30
    .line 31
    const v0, 0x7f14020a

    .line 32
    .line 33
    .line 34
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 35
    .line 36
    .line 37
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 38
    .line 39
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/AppsResolver;->clear()V

    .line 40
    .line 41
    .line 42
    :cond_1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshMenuIcons()V

    .line 43
    .line 44
    .line 45
    return-void
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

.method private synthetic lambda$showFirewallPurchaseDialog$10(Landroid/content/DialogInterface;I)V
    .locals 1

    .line 1
    new-instance p1, Landroid/content/Intent;

    .line 2
    .line 3
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 4
    .line 5
    .line 6
    move-result-object p2

    .line 7
    const-class v0, Lcom/emanuelef/remote_capture/activities/IABActivity;

    .line 8
    .line 9
    invoke-direct {p1, p2, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 10
    .line 11
    .line 12
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 13
    .line 14
    .line 15
    return-void
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

.method private static synthetic lambda$showFirewallPurchaseDialog$11(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private recheckMaxConnectionSize()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSliderActive:Z

    .line 10
    .line 11
    if-nez v0, :cond_0

    .line 12
    .line 13
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    if-eqz v0, :cond_0

    .line 18
    .line 19
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getMaxBytes()J

    .line 20
    .line 21
    .line 22
    move-result-wide v0

    .line 23
    const-wide/16 v2, 0x400

    .line 24
    .line 25
    div-long/2addr v0, v2

    .line 26
    long-to-float v0, v0

    .line 27
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 28
    .line 29
    invoke-virtual {v1}, Lcom/google/android/material/slider/Slider;->getValueTo()F

    .line 30
    .line 31
    .line 32
    move-result v1

    .line 33
    cmpl-float v1, v0, v1

    .line 34
    .line 35
    if-lez v1, :cond_0

    .line 36
    .line 37
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 38
    .line 39
    invoke-virtual {v1, v0}, Lcom/google/android/material/slider/Slider;->setValueTo(F)V

    .line 40
    .line 41
    .line 42
    :cond_0
    return-void
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

.method private recheckScroll()V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->getLayoutManager()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView$MyLinearLayoutManager;

    .line 8
    .line 9
    invoke-virtual {v0}, Landroidx/recyclerview/widget/LinearLayoutManager;->findFirstCompletelyVisibleItemPosition()I

    .line 10
    .line 11
    .line 12
    move-result v1

    .line 13
    invoke-virtual {v0}, Landroidx/recyclerview/widget/LinearLayoutManager;->findLastCompletelyVisibleItemPosition()I

    .line 14
    .line 15
    .line 16
    move-result v0

    .line 17
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 18
    .line 19
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItemCount()I

    .line 20
    .line 21
    .line 22
    move-result v2

    .line 23
    const/4 v3, 0x1

    .line 24
    sub-int/2addr v2, v3

    .line 25
    const/4 v4, 0x0

    .line 26
    if-lt v0, v2, :cond_0

    .line 27
    .line 28
    const/4 v0, 0x1

    .line 29
    goto :goto_0

    .line 30
    :cond_0
    const/4 v0, 0x0

    .line 31
    :goto_0
    if-nez v1, :cond_2

    .line 32
    .line 33
    if-nez v0, :cond_1

    .line 34
    .line 35
    goto :goto_1

    .line 36
    :cond_1
    invoke-direct {p0, v4}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFabDown(Z)V

    .line 37
    .line 38
    .line 39
    return-void

    .line 40
    :cond_2
    :goto_1
    if-eqz v0, :cond_3

    .line 41
    .line 42
    iput-boolean v3, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->autoScroll:Z

    .line 43
    .line 44
    invoke-direct {p0, v4}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFabDown(Z)V

    .line 45
    .line 46
    .line 47
    return-void

    .line 48
    :cond_3
    iput-boolean v4, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->autoScroll:Z

    .line 49
    .line 50
    invoke-direct {p0, v3}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFabDown(Z)V

    .line 51
    .line 52
    .line 53
    return-void
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method private recheckUntrackedConnections()V
    .locals 4

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->requireConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getUntrackedConnCount()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    if-lez v1, :cond_0

    .line 10
    .line 11
    const v1, 0x7f14021d

    .line 12
    .line 13
    .line 14
    invoke-virtual {p0, v1}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getUntrackedConnCount()I

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    const/4 v2, 0x1

    .line 27
    new-array v2, v2, [Ljava/lang/Object;

    .line 28
    .line 29
    const/4 v3, 0x0

    .line 30
    aput-object v0, v2, v3

    .line 31
    .line 32
    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 33
    .line 34
    .line 35
    move-result-object v0

    .line 36
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mOldConnectionsText:Landroid/widget/TextView;

    .line 37
    .line 38
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 39
    .line 40
    .line 41
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mOldConnectionsText:Landroid/widget/TextView;

    .line 42
    .line 43
    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 44
    .line 45
    .line 46
    return-void

    .line 47
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mOldConnectionsText:Landroid/widget/TextView;

    .line 48
    .line 49
    const/16 v1, 0x8

    .line 50
    .line 51
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 52
    .line 53
    .line 54
    return-void
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method private refreshActiveFilter()V
    .locals 8

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    goto :goto_0

    .line 6
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActiveFilter:Lcom/google/android/material/chip/ChipGroup;

    .line 7
    .line 8
    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 12
    .line 13
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 14
    .line 15
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getLayoutInflater()Landroid/view/LayoutInflater;

    .line 16
    .line 17
    .line 18
    move-result-object v1

    .line 19
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActiveFilter:Lcom/google/android/material/chip/ChipGroup;

    .line 20
    .line 21
    invoke-virtual {v0, v1, v2}, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->toChips(Landroid/view/LayoutInflater;Lcom/google/android/material/chip/ChipGroup;)V

    .line 22
    .line 23
    .line 24
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 25
    .line 26
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 27
    .line 28
    iget-wide v0, v0, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->minSize:J

    .line 29
    .line 30
    const-wide/16 v2, 0x400

    .line 31
    .line 32
    div-long/2addr v0, v2

    .line 33
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 34
    .line 35
    .line 36
    move-result-object v4

    .line 37
    if-eqz v4, :cond_1

    .line 38
    .line 39
    const-wide/16 v5, 0x0

    .line 40
    .line 41
    cmp-long v7, v0, v5

    .line 42
    .line 43
    if-lez v7, :cond_1

    .line 44
    .line 45
    invoke-virtual {v4}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getMaxBytes()J

    .line 46
    .line 47
    .line 48
    move-result-wide v4

    .line 49
    div-long/2addr v4, v2

    .line 50
    invoke-static {v4, v5, v0, v1}, Ljava/lang/Math;->max(JJ)J

    .line 51
    .line 52
    .line 53
    move-result-wide v2

    .line 54
    const-wide/16 v4, 0x2

    .line 55
    .line 56
    cmp-long v6, v2, v4

    .line 57
    .line 58
    if-ltz v6, :cond_1

    .line 59
    .line 60
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 61
    .line 62
    long-to-float v2, v2

    .line 63
    invoke-virtual {v4, v2}, Lcom/google/android/material/slider/Slider;->setValueTo(F)V

    .line 64
    .line 65
    .line 66
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 67
    .line 68
    long-to-float v0, v0

    .line 69
    invoke-virtual {v2, v0}, Lcom/google/android/material/slider/Slider;->setValue(F)V

    .line 70
    .line 71
    .line 72
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 73
    .line 74
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    .line 75
    .line 76
    .line 77
    move-result v0

    .line 78
    if-eqz v0, :cond_1

    .line 79
    .line 80
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 81
    .line 82
    const/4 v1, 0x0

    .line 83
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 84
    .line 85
    .line 86
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 87
    .line 88
    const/4 v1, 0x3

    .line 89
    invoke-virtual {v0, v1}, Lcom/google/android/material/slider/Slider;->setLabelBehavior(I)V

    .line 90
    .line 91
    .line 92
    :cond_1
    :goto_0
    return-void
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

.method private refreshEmptyText()V
    .locals 2

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_1

    .line 6
    .line 7
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isServiceActive()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    goto :goto_0

    .line 14
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mEmptyText:Landroid/widget/TextView;

    .line 15
    .line 16
    const v1, 0x7f140072

    .line 17
    .line 18
    .line 19
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 20
    .line 21
    .line 22
    return-void

    .line 23
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mEmptyText:Landroid/widget/TextView;

    .line 24
    .line 25
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 26
    .line 27
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->hasFilter()Z

    .line 28
    .line 29
    .line 30
    move-result v1

    .line 31
    if-eqz v1, :cond_2

    .line 32
    .line 33
    const v1, 0x7f140210

    .line 34
    .line 35
    .line 36
    goto :goto_1

    .line 37
    :cond_2
    const v1, 0x7f14020a

    .line 38
    .line 39
    .line 40
    :goto_1
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 41
    .line 42
    .line 43
    return-void
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

.method private refreshFilteredConnections()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->refreshFilteredConnections()V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshMenuIcons()V

    .line 7
    .line 8
    .line 9
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshActiveFilter()V

    .line 10
    .line 11
    .line 12
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckScroll()V

    .line 13
    .line 14
    .line 15
    return-void
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

.method private refreshMenuIcons()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSave:Landroid/view/MenuItem;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    if-eqz v0, :cond_1

    .line 11
    .line 12
    const/4 v0, 0x1

    .line 13
    goto :goto_0

    .line 14
    :cond_1
    const/4 v0, 0x0

    .line 15
    :goto_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mMenuItemSearch:Landroid/view/MenuItem;

    .line 16
    .line 17
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 18
    .line 19
    .line 20
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSave:Landroid/view/MenuItem;

    .line 21
    .line 22
    invoke-interface {v1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 23
    .line 24
    .line 25
    return-void
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

.method private registerConnsListener()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->listenerSet:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

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
    invoke-virtual {v0, p0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->addListener(Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;)V

    .line 12
    .line 13
    .line 14
    const/4 v0, 0x1

    .line 15
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->listenerSet:Z

    .line 16
    .line 17
    :cond_0
    return-void
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

.method private scrollToBottom()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItemCount()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    add-int/lit8 v0, v0, -0x1

    .line 8
    .line 9
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 10
    .line 11
    invoke-virtual {v1, v0}, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V

    .line 12
    .line 13
    .line 14
    const/4 v0, 0x0

    .line 15
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFabDown(Z)V

    .line 16
    .line 17
    .line 18
    return-void
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

.method private setQuery(Ljava/lang/String;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 2
    .line 3
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mMenuItemSearch:Landroid/view/MenuItem;

    .line 4
    .line 5
    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/Utils;->setSearchQuery(Landroidx/appcompat/widget/SearchView;Landroid/view/MenuItem;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    return-void
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

.method private showFabDown(Z)V
    .locals 1

    .line 1
    const/4 v0, 0x1

    .line 2
    if-eqz p1, :cond_0

    .line 3
    .line 4
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 5
    .line 6
    invoke-virtual {p1, v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->show(Z)V

    .line 7
    .line 8
    .line 9
    return-void

    .line 10
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 11
    .line 12
    invoke-virtual {p1, v0}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->hide(Z)V

    .line 13
    .line 14
    .line 15
    return-void
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

.method private showFirewallPurchaseDialog()V
    .locals 4

    .line 1
    new-instance v0, Lcom/android/billingclient/api/zzbv;

    .line 2
    .line 3
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-direct {v0, v1}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 8
    .line 9
    .line 10
    const v1, 0x7f14022c

    .line 11
    .line 12
    .line 13
    invoke-virtual {v0, v1}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 14
    .line 15
    .line 16
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    const v2, 0x7f140213

    .line 21
    .line 22
    .line 23
    invoke-virtual {p0, v2}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 24
    .line 25
    .line 26
    move-result-object v2

    .line 27
    filled-new-array {v2}, [Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object v2

    .line 31
    const v3, 0x7f140115

    .line 32
    .line 33
    .line 34
    invoke-static {v1, v3, v2}, Lcom/emanuelef/remote_capture/Utils;->getText(Landroid/content/Context;I[Ljava/lang/String;)Ljava/lang/CharSequence;

    .line 35
    .line 36
    .line 37
    move-result-object v1

    .line 38
    iget-object v2, v0, Lcom/android/billingclient/api/zzbv;->zza:Ljava/lang/Object;

    .line 39
    .line 40
    check-cast v2, Landroidx/appcompat/app/AlertController$AlertParams;

    .line 41
    .line 42
    iput-object v1, v2, Landroidx/appcompat/app/AlertController$AlertParams;->mMessage:Ljava/lang/CharSequence;

    .line 43
    .line 44
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;

    .line 45
    .line 46
    const/4 v2, 0x5

    .line 47
    invoke-direct {v1, v2, p0}, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 48
    .line 49
    .line 50
    const v2, 0x7f140292

    .line 51
    .line 52
    .line 53
    invoke-virtual {v0, v2, v1}, Lcom/android/billingclient/api/zzbv;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 54
    .line 55
    .line 56
    new-instance v1, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 57
    .line 58
    const/16 v2, 0xf

    .line 59
    .line 60
    invoke-direct {v1, v2}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 61
    .line 62
    .line 63
    const v2, 0x7f14006d

    .line 64
    .line 65
    .line 66
    invoke-virtual {v0, v2, v1}, Lcom/android/billingclient/api/zzbv;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 67
    .line 68
    .line 69
    invoke-virtual {v0}, Lcom/android/billingclient/api/zzbv;->show()Landroidx/appcompat/app/AlertDialog;

    .line 70
    .line 71
    .line 72
    return-void
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

.method private startSelectionMode(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    check-cast v0, Landroidx/appcompat/app/AppCompatActivity;

    .line 11
    .line 12
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionModeCallback:Landroidx/appcompat/view/ActionMode$Callback;

    .line 13
    .line 14
    invoke-virtual {v0, v1}, Landroidx/appcompat/app/AppCompatActivity;->startSupportActionMode(Landroidx/appcompat/view/ActionMode$Callback;)Landroidx/appcompat/view/ActionMode;

    .line 15
    .line 16
    .line 17
    move-result-object v0

    .line 18
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 19
    .line 20
    const/4 v0, 0x0

    .line 21
    :goto_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 22
    .line 23
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItemCount()I

    .line 24
    .line 25
    .line 26
    move-result v1

    .line 27
    if-ge v0, v1, :cond_2

    .line 28
    .line 29
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 30
    .line 31
    invoke-virtual {v1, v0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 32
    .line 33
    .line 34
    move-result-object v1

    .line 35
    if-eqz v1, :cond_1

    .line 36
    .line 37
    iget v1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 38
    .line 39
    iget v2, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 40
    .line 41
    if-ne v1, v2, :cond_1

    .line 42
    .line 43
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 44
    .line 45
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->selectItem(I)V

    .line 46
    .line 47
    .line 48
    goto :goto_1

    .line 49
    :cond_1
    add-int/lit8 v0, v0, 0x1

    .line 50
    .line 51
    goto :goto_0

    .line 52
    :cond_2
    :goto_1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->updateActionModeTitle()V

    .line 53
    .line 54
    .line 55
    return-void
    .line 56
    .line 57
.end method

.method private toggleSelection(I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->toggleSelection(I)V

    .line 4
    .line 5
    .line 6
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 7
    .line 8
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getSelectedCount()I

    .line 9
    .line 10
    .line 11
    move-result p1

    .line 12
    if-nez p1, :cond_1

    .line 13
    .line 14
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 15
    .line 16
    if-eqz p1, :cond_0

    .line 17
    .line 18
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 19
    .line 20
    .line 21
    :cond_0
    return-void

    .line 22
    :cond_1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->updateActionModeTitle()V

    .line 23
    .line 24
    .line 25
    return-void
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

.method private unregisterConnsListener()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->listenerSet:Z

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
    invoke-virtual {v0, p0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->removeListener(Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;)V

    .line 12
    .line 13
    .line 14
    :cond_0
    const/4 v0, 0x0

    .line 15
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->listenerSet:Z

    .line 16
    .line 17
    :cond_1
    return-void
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

.method private updateActionModeTitle()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 6
    .line 7
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getSelectedCount()I

    .line 8
    .line 9
    .line 10
    move-result v1

    .line 11
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    const/4 v2, 0x1

    .line 16
    new-array v2, v2, [Ljava/lang/Object;

    .line 17
    .line 18
    const/4 v3, 0x0

    .line 19
    aput-object v1, v2, v3

    .line 20
    .line 21
    const v1, 0x7f1401fc

    .line 22
    .line 23
    .line 24
    invoke-virtual {p0, v1, v2}, Landroidx/fragment/app/Fragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v1

    .line 28
    invoke-virtual {v0, v1}, Landroidx/appcompat/view/ActionMode;->setTitle(Ljava/lang/CharSequence;)V

    .line 29
    .line 30
    .line 31
    :cond_0
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
    .line 58
.end method


# virtual methods
.method public clearFilters()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    new-instance v1, Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 6
    .line 7
    invoke-direct {v1}, Lcom/emanuelef/remote_capture/model/FilterDescriptor;-><init>()V

    .line 8
    .line 9
    .line 10
    iput-object v1, v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 11
    .line 12
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 13
    .line 14
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->refreshFilteredConnections()V

    .line 15
    .line 16
    .line 17
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshActiveFilter()V

    .line 18
    .line 19
    .line 20
    :cond_0
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
    .line 58
.end method

.method public connectionsAdded(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mHandler:Landroid/os/Handler;

    .line 2
    .line 3
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;

    .line 4
    .line 5
    const/4 v2, 0x1

    .line 6
    invoke-direct {v1, p0, p2, p1, v2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;II)V

    .line 7
    .line 8
    .line 9
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 10
    .line 11
    .line 12
    return-void
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

.method public connectionsChanges(I)V
    .locals 2

    .line 1
    new-instance v0, Landroidx/core/content/res/ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    invoke-direct {v0, p1, v1, p0}, Landroidx/core/content/res/ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;-><init>(IILjava/lang/Object;)V

    .line 5
    .line 6
    .line 7
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mHandler:Landroid/os/Handler;

    .line 8
    .line 9
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Utils;->runOnUi(Ljava/lang/Runnable;Landroid/os/Handler;)V

    .line 10
    .line 11
    .line 12
    return-void
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

.method public connectionsRemoved(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mHandler:Landroid/os/Handler;

    .line 2
    .line 3
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v1, p0, p2, p1, v2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda2;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;II)V

    .line 7
    .line 8
    .line 9
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 10
    .line 11
    .line 12
    return-void
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

.method public connectionsUpdated([I)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mHandler:Landroid/os/Handler;

    .line 2
    .line 3
    new-instance v1, Landroidx/core/content/res/ResourcesCompat$FontCallback$$ExternalSyntheticLambda0;

    .line 4
    .line 5
    const/4 v2, 0x2

    .line 6
    invoke-direct {v1, p0, v2, p1}, Landroidx/core/content/res/ResourcesCompat$FontCallback$$ExternalSyntheticLambda0;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 7
    .line 8
    .line 9
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 10
    .line 11
    .line 12
    return-void
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

.method public onBackPressed()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x1

    .line 9
    return v0

    .line 10
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 11
    .line 12
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->backHandleSearchview(Landroidx/appcompat/widget/SearchView;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    return v0
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

.method public onContextItemSelected(Landroid/view/MenuItem;)Z
    .locals 11

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 6
    .line 7
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getSelectedItem()Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 8
    .line 9
    .line 10
    move-result-object v1

    .line 11
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 12
    .line 13
    .line 14
    move-result-object v2

    .line 15
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/PCAPdroid;->getMalwareWhitelist()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 16
    .line 17
    .line 18
    move-result-object v2

    .line 19
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 20
    .line 21
    .line 22
    move-result-object v3

    .line 23
    invoke-virtual {v3}, Lcom/emanuelef/remote_capture/PCAPdroid;->getFirewallWhitelist()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 24
    .line 25
    .line 26
    move-result-object v3

    .line 27
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 28
    .line 29
    .line 30
    move-result-object v4

    .line 31
    invoke-virtual {v4}, Lcom/emanuelef/remote_capture/PCAPdroid;->getDecryptionList()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 32
    .line 33
    .line 34
    move-result-object v4

    .line 35
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 36
    .line 37
    .line 38
    move-result-object v5

    .line 39
    invoke-virtual {v5}, Lcom/emanuelef/remote_capture/PCAPdroid;->getBlocklist()Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 40
    .line 41
    .line 42
    move-result-object v5

    .line 43
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Billing;->newInstance(Landroid/content/Context;)Lcom/emanuelef/remote_capture/PlayBilling;

    .line 44
    .line 45
    .line 46
    move-result-object v6

    .line 47
    const-string v7, "no_root_firewall"

    .line 48
    .line 49
    invoke-virtual {v6, v7}, Lcom/emanuelef/remote_capture/PlayBilling;->isPurchased(Ljava/lang/String;)Z

    .line 50
    .line 51
    .line 52
    move-result v6

    .line 53
    if-nez v1, :cond_0

    .line 54
    .line 55
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onContextItemSelected(Landroid/view/MenuItem;)Z

    .line 56
    .line 57
    .line 58
    move-result p1

    .line 59
    return p1

    .line 60
    :cond_0
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    .line 61
    .line 62
    .line 63
    move-result v7

    .line 64
    const v8, 0x7f0a02dc

    .line 65
    .line 66
    .line 67
    const/4 v9, 0x1

    .line 68
    if-ne v7, v8, :cond_1

    .line 69
    .line 70
    invoke-direct {p0, v1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->startSelectionMode(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V

    .line 71
    .line 72
    .line 73
    return v9

    .line 74
    :cond_1
    const v8, 0x7f0a0186

    .line 75
    .line 76
    .line 77
    const/4 v10, 0x0

    .line 78
    if-ne v7, v8, :cond_2

    .line 79
    .line 80
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 81
    .line 82
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 83
    .line 84
    iget v0, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 85
    .line 86
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(I)Z

    .line 87
    .line 88
    .line 89
    :goto_0
    const/4 p1, 0x0

    .line 90
    const/4 v0, 0x1

    .line 91
    :goto_1
    const/4 v1, 0x0

    .line 92
    :goto_2
    const/4 v6, 0x0

    .line 93
    :goto_3
    const/4 v7, 0x0

    .line 94
    goto/16 :goto_c

    .line 95
    .line 96
    :cond_2
    const v8, 0x7f0a0189

    .line 97
    .line 98
    .line 99
    if-ne v7, v8, :cond_3

    .line 100
    .line 101
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 102
    .line 103
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 104
    .line 105
    iget-object v0, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 106
    .line 107
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/model/MatchList;->addHost(Ljava/lang/String;)Z

    .line 108
    .line 109
    .line 110
    goto :goto_0

    .line 111
    :cond_3
    const v8, 0x7f0a018b

    .line 112
    .line 113
    .line 114
    if-ne v7, v8, :cond_4

    .line 115
    .line 116
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 117
    .line 118
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 119
    .line 120
    iget-object v0, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 121
    .line 122
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/model/MatchList;->addIp(Ljava/lang/String;)Z

    .line 123
    .line 124
    .line 125
    goto :goto_0

    .line 126
    :cond_4
    const v8, 0x7f0a018c

    .line 127
    .line 128
    .line 129
    if-ne v7, v8, :cond_5

    .line 130
    .line 131
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 132
    .line 133
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 134
    .line 135
    iget-object v0, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->l7proto:Ljava/lang/String;

    .line 136
    .line 137
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/model/MatchList;->addProto(Ljava/lang/String;)Z

    .line 138
    .line 139
    .line 140
    goto :goto_0

    .line 141
    :cond_5
    const v8, 0x7f0a0188

    .line 142
    .line 143
    .line 144
    if-ne v7, v8, :cond_6

    .line 145
    .line 146
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 147
    .line 148
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 149
    .line 150
    iget-object v0, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 151
    .line 152
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->getSecondLevelDomain(Ljava/lang/String;)Ljava/lang/String;

    .line 153
    .line 154
    .line 155
    move-result-object v0

    .line 156
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/model/MatchList;->addHost(Ljava/lang/String;)Z

    .line 157
    .line 158
    .line 159
    goto :goto_0

    .line 160
    :cond_6
    const v8, 0x7f0a0187

    .line 161
    .line 162
    .line 163
    if-ne v7, v8, :cond_7

    .line 164
    .line 165
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 166
    .line 167
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 168
    .line 169
    iget-object v0, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->country:Ljava/lang/String;

    .line 170
    .line 171
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/model/MatchList;->addCountry(Ljava/lang/String;)Z

    .line 172
    .line 173
    .line 174
    goto :goto_0

    .line 175
    :cond_7
    const v8, 0x7f0a02cb

    .line 176
    .line 177
    .line 178
    if-ne v7, v8, :cond_9

    .line 179
    .line 180
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 181
    .line 182
    iget v1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 183
    .line 184
    invoke-virtual {v0, v1, v10}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 185
    .line 186
    .line 187
    move-result-object v0

    .line 188
    if-eqz v0, :cond_8

    .line 189
    .line 190
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 191
    .line 192
    .line 193
    move-result-object p1

    .line 194
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->setQuery(Ljava/lang/String;)V

    .line 195
    .line 196
    .line 197
    goto/16 :goto_b

    .line 198
    .line 199
    :cond_8
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onContextItemSelected(Landroid/view/MenuItem;)Z

    .line 200
    .line 201
    .line 202
    move-result p1

    .line 203
    return p1

    .line 204
    :cond_9
    const v8, 0x7f0a02d2

    .line 205
    .line 206
    .line 207
    if-ne v7, v8, :cond_a

    .line 208
    .line 209
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 210
    .line 211
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->setQuery(Ljava/lang/String;)V

    .line 212
    .line 213
    .line 214
    goto/16 :goto_b

    .line 215
    .line 216
    :cond_a
    const v8, 0x7f0a02d3

    .line 217
    .line 218
    .line 219
    if-ne v7, v8, :cond_b

    .line 220
    .line 221
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 222
    .line 223
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->setQuery(Ljava/lang/String;)V

    .line 224
    .line 225
    .line 226
    goto/16 :goto_b

    .line 227
    .line 228
    :cond_b
    const v8, 0x7f0a02d6

    .line 229
    .line 230
    .line 231
    if-ne v7, v8, :cond_c

    .line 232
    .line 233
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->l7proto:Ljava/lang/String;

    .line 234
    .line 235
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->setQuery(Ljava/lang/String;)V

    .line 236
    .line 237
    .line 238
    goto/16 :goto_b

    .line 239
    .line 240
    :cond_c
    const v8, 0x7f0a0221

    .line 241
    .line 242
    .line 243
    if-ne v7, v8, :cond_d

    .line 244
    .line 245
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 246
    .line 247
    invoke-virtual {v2, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(I)Z

    .line 248
    .line 249
    .line 250
    :goto_4
    const/4 p1, 0x0

    .line 251
    const/4 v0, 0x0

    .line 252
    const/4 v1, 0x1

    .line 253
    goto/16 :goto_2

    .line 254
    .line 255
    :cond_d
    const v8, 0x7f0a0223

    .line 256
    .line 257
    .line 258
    if-ne v7, v8, :cond_e

    .line 259
    .line 260
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 261
    .line 262
    invoke-virtual {v2, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addIp(Ljava/lang/String;)Z

    .line 263
    .line 264
    .line 265
    goto :goto_4

    .line 266
    :cond_e
    const v8, 0x7f0a0222

    .line 267
    .line 268
    .line 269
    if-ne v7, v8, :cond_f

    .line 270
    .line 271
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 272
    .line 273
    invoke-virtual {v2, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addHost(Ljava/lang/String;)Z

    .line 274
    .line 275
    .line 276
    goto :goto_4

    .line 277
    :cond_f
    const v8, 0x7f0a00f5

    .line 278
    .line 279
    .line 280
    if-ne v7, v8, :cond_10

    .line 281
    .line 282
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 283
    .line 284
    invoke-virtual {v4, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(I)Z

    .line 285
    .line 286
    .line 287
    :goto_5
    const/4 p1, 0x0

    .line 288
    const/4 v0, 0x0

    .line 289
    const/4 v1, 0x0

    .line 290
    const/4 v6, 0x0

    .line 291
    const/4 v7, 0x1

    .line 292
    goto/16 :goto_c

    .line 293
    .line 294
    :cond_10
    const v8, 0x7f0a00f7

    .line 295
    .line 296
    .line 297
    if-ne v7, v8, :cond_11

    .line 298
    .line 299
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 300
    .line 301
    invoke-virtual {v4, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addIp(Ljava/lang/String;)Z

    .line 302
    .line 303
    .line 304
    goto :goto_5

    .line 305
    :cond_11
    const v8, 0x7f0a00f6

    .line 306
    .line 307
    .line 308
    if-ne v7, v8, :cond_12

    .line 309
    .line 310
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 311
    .line 312
    invoke-virtual {v4, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addHost(Ljava/lang/String;)Z

    .line 313
    .line 314
    .line 315
    goto :goto_5

    .line 316
    :cond_12
    const v8, 0x7f0a00f8

    .line 317
    .line 318
    .line 319
    if-ne v7, v8, :cond_13

    .line 320
    .line 321
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 322
    .line 323
    invoke-virtual {v4, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->removeApp(I)V

    .line 324
    .line 325
    .line 326
    goto :goto_5

    .line 327
    :cond_13
    const v8, 0x7f0a00fa

    .line 328
    .line 329
    .line 330
    if-ne v7, v8, :cond_15

    .line 331
    .line 332
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mDecRemoveCidr:Ljava/lang/String;

    .line 333
    .line 334
    if-eqz p1, :cond_14

    .line 335
    .line 336
    goto :goto_6

    .line 337
    :cond_14
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 338
    .line 339
    :goto_6
    invoke-virtual {v4, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->removeIp(Ljava/lang/String;)V

    .line 340
    .line 341
    .line 342
    goto :goto_5

    .line 343
    :cond_15
    const v8, 0x7f0a00f9

    .line 344
    .line 345
    .line 346
    if-ne v7, v8, :cond_16

    .line 347
    .line 348
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 349
    .line 350
    invoke-virtual {v4, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->removeHost(Ljava/lang/String;)V

    .line 351
    .line 352
    .line 353
    goto :goto_5

    .line 354
    :cond_16
    const v8, 0x7f0a0096

    .line 355
    .line 356
    .line 357
    if-ne v7, v8, :cond_18

    .line 358
    .line 359
    if-eqz v6, :cond_17

    .line 360
    .line 361
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 362
    .line 363
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/Blocklist;->addApp(I)Z

    .line 364
    .line 365
    .line 366
    :goto_7
    const/4 p1, 0x1

    .line 367
    :goto_8
    const/4 v0, 0x0

    .line 368
    goto/16 :goto_1

    .line 369
    .line 370
    :cond_17
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFirewallPurchaseDialog()V

    .line 371
    .line 372
    .line 373
    goto/16 :goto_b

    .line 374
    .line 375
    :cond_18
    const v8, 0x7f0a009a

    .line 376
    .line 377
    .line 378
    if-ne v7, v8, :cond_1a

    .line 379
    .line 380
    if-eqz v6, :cond_19

    .line 381
    .line 382
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 383
    .line 384
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addIp(Ljava/lang/String;)Z

    .line 385
    .line 386
    .line 387
    goto :goto_7

    .line 388
    :cond_19
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFirewallPurchaseDialog()V

    .line 389
    .line 390
    .line 391
    goto/16 :goto_b

    .line 392
    .line 393
    :cond_1a
    const v8, 0x7f0a0099

    .line 394
    .line 395
    .line 396
    if-ne v7, v8, :cond_1c

    .line 397
    .line 398
    if-eqz v6, :cond_1b

    .line 399
    .line 400
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 401
    .line 402
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addHost(Ljava/lang/String;)Z

    .line 403
    .line 404
    .line 405
    goto :goto_7

    .line 406
    :cond_1b
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFirewallPurchaseDialog()V

    .line 407
    .line 408
    .line 409
    goto/16 :goto_b

    .line 410
    .line 411
    :cond_1c
    const v8, 0x7f0a0098

    .line 412
    .line 413
    .line 414
    if-ne v7, v8, :cond_1e

    .line 415
    .line 416
    if-eqz v6, :cond_1d

    .line 417
    .line 418
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 419
    .line 420
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->getSecondLevelDomain(Ljava/lang/String;)Ljava/lang/String;

    .line 421
    .line 422
    .line 423
    move-result-object p1

    .line 424
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addHost(Ljava/lang/String;)Z

    .line 425
    .line 426
    .line 427
    goto :goto_7

    .line 428
    :cond_1d
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFirewallPurchaseDialog()V

    .line 429
    .line 430
    .line 431
    goto/16 :goto_b

    .line 432
    .line 433
    :cond_1e
    const v8, 0x7f0a0097

    .line 434
    .line 435
    .line 436
    if-ne v7, v8, :cond_20

    .line 437
    .line 438
    if-eqz v6, :cond_1f

    .line 439
    .line 440
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->country:Ljava/lang/String;

    .line 441
    .line 442
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addCountry(Ljava/lang/String;)Z

    .line 443
    .line 444
    .line 445
    goto :goto_7

    .line 446
    :cond_1f
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFirewallPurchaseDialog()V

    .line 447
    .line 448
    .line 449
    goto/16 :goto_b

    .line 450
    .line 451
    :cond_20
    const v6, 0x7f0a0377

    .line 452
    .line 453
    .line 454
    if-ne v7, v6, :cond_21

    .line 455
    .line 456
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 457
    .line 458
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/Blocklist;->removeApp(I)V

    .line 459
    .line 460
    .line 461
    goto :goto_7

    .line 462
    :cond_21
    const v6, 0x7f0a0374

    .line 463
    .line 464
    .line 465
    if-ne v7, v6, :cond_22

    .line 466
    .line 467
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 468
    .line 469
    const/16 v0, 0xa

    .line 470
    .line 471
    invoke-virtual {v5, p1, v0}, Lcom/emanuelef/remote_capture/model/Blocklist;->unblockAppForMinutes(II)Z

    .line 472
    .line 473
    .line 474
    move-result p1

    .line 475
    goto :goto_8

    .line 476
    :cond_22
    const v6, 0x7f0a0375

    .line 477
    .line 478
    .line 479
    if-ne v7, v6, :cond_23

    .line 480
    .line 481
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 482
    .line 483
    const/16 v0, 0x3c

    .line 484
    .line 485
    invoke-virtual {v5, p1, v0}, Lcom/emanuelef/remote_capture/model/Blocklist;->unblockAppForMinutes(II)Z

    .line 486
    .line 487
    .line 488
    move-result p1

    .line 489
    goto :goto_8

    .line 490
    :cond_23
    const v6, 0x7f0a0376

    .line 491
    .line 492
    .line 493
    if-ne v7, v6, :cond_24

    .line 494
    .line 495
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 496
    .line 497
    const/16 v0, 0x1e0

    .line 498
    .line 499
    invoke-virtual {v5, p1, v0}, Lcom/emanuelef/remote_capture/model/Blocklist;->unblockAppForMinutes(II)Z

    .line 500
    .line 501
    .line 502
    move-result p1

    .line 503
    goto/16 :goto_8

    .line 504
    .line 505
    :cond_24
    const v6, 0x7f0a037b

    .line 506
    .line 507
    .line 508
    if-ne v7, v6, :cond_26

    .line 509
    .line 510
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mUnblockCidr:Ljava/lang/String;

    .line 511
    .line 512
    if-eqz p1, :cond_25

    .line 513
    .line 514
    goto :goto_9

    .line 515
    :cond_25
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 516
    .line 517
    :goto_9
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->removeIp(Ljava/lang/String;)V

    .line 518
    .line 519
    .line 520
    goto/16 :goto_7

    .line 521
    .line 522
    :cond_26
    const v6, 0x7f0a037a

    .line 523
    .line 524
    .line 525
    if-ne v7, v6, :cond_27

    .line 526
    .line 527
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 528
    .line 529
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->removeHost(Ljava/lang/String;)V

    .line 530
    .line 531
    .line 532
    goto/16 :goto_7

    .line 533
    .line 534
    :cond_27
    const v6, 0x7f0a0379

    .line 535
    .line 536
    .line 537
    if-ne v7, v6, :cond_28

    .line 538
    .line 539
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 540
    .line 541
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->getSecondLevelDomain(Ljava/lang/String;)Ljava/lang/String;

    .line 542
    .line 543
    .line 544
    move-result-object p1

    .line 545
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->removeHost(Ljava/lang/String;)V

    .line 546
    .line 547
    .line 548
    goto/16 :goto_7

    .line 549
    .line 550
    :cond_28
    const v6, 0x7f0a0378

    .line 551
    .line 552
    .line 553
    if-ne v7, v6, :cond_29

    .line 554
    .line 555
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->country:Ljava/lang/String;

    .line 556
    .line 557
    invoke-virtual {v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->removeCountry(Ljava/lang/String;)V

    .line 558
    .line 559
    .line 560
    goto/16 :goto_7

    .line 561
    .line 562
    :cond_29
    const v6, 0x7f0a005d

    .line 563
    .line 564
    .line 565
    if-ne v7, v6, :cond_2a

    .line 566
    .line 567
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 568
    .line 569
    invoke-virtual {v3, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(I)Z

    .line 570
    .line 571
    .line 572
    :goto_a
    const/4 p1, 0x0

    .line 573
    const/4 v0, 0x0

    .line 574
    const/4 v1, 0x0

    .line 575
    const/4 v6, 0x1

    .line 576
    goto/16 :goto_3

    .line 577
    .line 578
    :cond_2a
    const v6, 0x7f0a02ab

    .line 579
    .line 580
    .line 581
    if-ne v7, v6, :cond_2b

    .line 582
    .line 583
    iget p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 584
    .line 585
    invoke-virtual {v3, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->removeApp(I)V

    .line 586
    .line 587
    .line 588
    goto :goto_a

    .line 589
    :cond_2b
    const v6, 0x7f0a0256

    .line 590
    .line 591
    .line 592
    if-ne v7, v6, :cond_2c

    .line 593
    .line 594
    new-instance p1, Landroid/content/Intent;

    .line 595
    .line 596
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 597
    .line 598
    .line 599
    move-result-object v0

    .line 600
    const-class v6, Lcom/emanuelef/remote_capture/activities/AppDetailsActivity;

    .line 601
    .line 602
    invoke-direct {p1, v0, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 603
    .line 604
    .line 605
    const-string v0, "app_uid"

    .line 606
    .line 607
    iget v1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 608
    .line 609
    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 610
    .line 611
    .line 612
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 613
    .line 614
    .line 615
    goto :goto_b

    .line 616
    :cond_2c
    const v6, 0x7f0a00e2

    .line 617
    .line 618
    .line 619
    if-ne v7, v6, :cond_2d

    .line 620
    .line 621
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 622
    .line 623
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

    .line 624
    .line 625
    .line 626
    goto :goto_b

    .line 627
    :cond_2d
    const v6, 0x7f0a00de

    .line 628
    .line 629
    .line 630
    if-ne v7, v6, :cond_2e

    .line 631
    .line 632
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 633
    .line 634
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

    .line 635
    .line 636
    .line 637
    goto :goto_b

    .line 638
    :cond_2e
    const v6, 0x7f0a00e4

    .line 639
    .line 640
    .line 641
    if-ne v7, v6, :cond_2f

    .line 642
    .line 643
    iget-object p1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->url:Ljava/lang/String;

    .line 644
    .line 645
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

    .line 646
    .line 647
    .line 648
    goto :goto_b

    .line 649
    :cond_2f
    const v6, 0x7f0a00df

    .line 650
    .line 651
    .line 652
    if-ne v7, v6, :cond_30

    .line 653
    .line 654
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getHttpRequest()Ljava/lang/String;

    .line 655
    .line 656
    .line 657
    move-result-object p1

    .line 658
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

    .line 659
    .line 660
    .line 661
    goto :goto_b

    .line 662
    :cond_30
    const v6, 0x7f0a00e0

    .line 663
    .line 664
    .line 665
    if-ne v7, v6, :cond_36

    .line 666
    .line 667
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getHttpResponse()Ljava/lang/String;

    .line 668
    .line 669
    .line 670
    move-result-object p1

    .line 671
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Utils;->copyToClipboard(Landroid/content/Context;Ljava/lang/String;)V

    .line 672
    .line 673
    .line 674
    :goto_b
    const/4 p1, 0x0

    .line 675
    goto/16 :goto_8

    .line 676
    .line 677
    :goto_c
    if-eqz v0, :cond_31

    .line 678
    .line 679
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 680
    .line 681
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 682
    .line 683
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/MatchList;->save()V

    .line 684
    .line 685
    .line 686
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 687
    .line 688
    iget-object p1, p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 689
    .line 690
    iput-boolean v10, p1, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->showMasked:Z

    .line 691
    .line 692
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshFilteredConnections()V

    .line 693
    .line 694
    .line 695
    goto :goto_d

    .line 696
    :cond_31
    if-eqz v1, :cond_32

    .line 697
    .line 698
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/MatchList;->save()V

    .line 699
    .line 700
    .line 701
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->reloadMalwareWhitelist()V

    .line 702
    .line 703
    .line 704
    goto :goto_d

    .line 705
    :cond_32
    if-eqz v6, :cond_33

    .line 706
    .line 707
    invoke-virtual {v3}, Lcom/emanuelef/remote_capture/model/MatchList;->save()V

    .line 708
    .line 709
    .line 710
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isServiceActive()Z

    .line 711
    .line 712
    .line 713
    move-result p1

    .line 714
    if-eqz p1, :cond_35

    .line 715
    .line 716
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->requireInstance()Lcom/emanuelef/remote_capture/CaptureService;

    .line 717
    .line 718
    .line 719
    move-result-object p1

    .line 720
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/CaptureService;->reloadFirewallWhitelist()V

    .line 721
    .line 722
    .line 723
    goto :goto_d

    .line 724
    :cond_33
    if-eqz v7, :cond_34

    .line 725
    .line 726
    invoke-virtual {v4}, Lcom/emanuelef/remote_capture/model/MatchList;->save()V

    .line 727
    .line 728
    .line 729
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->reloadDecryptionList()V

    .line 730
    .line 731
    .line 732
    goto :goto_d

    .line 733
    :cond_34
    if-eqz p1, :cond_35

    .line 734
    .line 735
    invoke-virtual {v5}, Lcom/emanuelef/remote_capture/model/Blocklist;->saveAndReload()V

    .line 736
    .line 737
    .line 738
    :cond_35
    :goto_d
    return v9

    .line 739
    :cond_36
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onContextItemSelected(Landroid/view/MenuItem;)Z

    .line 740
    .line 741
    .line 742
    move-result p1

    .line 743
    return p1
    .line 744
    .line 745
    .line 746
    .line 747
    .line 748
    .line 749
    .line 750
    .line 751
    .line 752
    .line 753
    .line 754
    .line 755
    .line 756
    .line 757
    .line 758
    .line 759
    .line 760
    .line 761
    .line 762
    .line 763
    .line 764
    .line 765
    .line 766
    .line 767
    .line 768
    .line 769
    .line 770
    .line 771
    .line 772
    .line 773
    .line 774
    .line 775
    .line 776
    .line 777
    .line 778
    .line 779
    .line 780
    .line 781
    .line 782
    .line 783
    .line 784
    .line 785
    .line 786
    .line 787
    .line 788
    .line 789
    .line 790
    .line 791
    .line 792
    .line 793
    .line 794
    .line 795
    .line 796
    .line 797
    .line 798
    .line 799
    .line 800
    .line 801
    .line 802
    .line 803
    .line 804
    .line 805
    .line 806
    .line 807
    .line 808
    .line 809
    .line 810
    .line 811
    .line 812
    .line 813
    .line 814
    .line 815
    .line 816
    .line 817
    .line 818
    .line 819
    .line 820
    .line 821
    .line 822
    .line 823
    .line 824
    .line 825
    .line 826
    .line 827
    .line 828
    .line 829
    .line 830
    .line 831
    .line 832
    .line 833
    .line 834
    .line 835
    .line 836
    .line 837
    .line 838
    .line 839
    .line 840
    .line 841
    .line 842
    .line 843
    .line 844
    .line 845
    .line 846
    .line 847
    .line 848
    .line 849
    .line 850
    .line 851
    .line 852
    .line 853
    .line 854
    .line 855
    .line 856
    .line 857
    .line 858
    .line 859
    .line 860
    .line 861
    .line 862
    .line 863
    .line 864
    .line 865
    .line 866
    .line 867
    .line 868
    .line 869
    .line 870
    .line 871
    .line 872
    .line 873
    .line 874
    .line 875
    .line 876
    .line 877
    .line 878
    .line 879
    .line 880
    .line 881
    .line 882
    .line 883
    .line 884
    .line 885
    .line 886
    .line 887
    .line 888
    .line 889
    .line 890
    .line 891
    .line 892
    .line 893
    .line 894
    .line 895
    .line 896
    .line 897
    .line 898
    .line 899
    .line 900
    .line 901
    .line 902
    .line 903
    .line 904
    .line 905
    .line 906
    .line 907
    .line 908
    .line 909
    .line 910
    .line 911
    .line 912
    .line 913
    .line 914
    .line 915
    .line 916
    .line 917
    .line 918
    .line 919
    .line 920
    .line 921
    .line 922
    .line 923
    .line 924
    .line 925
    .line 926
    .line 927
    .line 928
    .line 929
    .line 930
    .line 931
    .line 932
    .line 933
    .line 934
    .line 935
    .line 936
    .line 937
    .line 938
    .line 939
    .line 940
    .line 941
    .line 942
    .line 943
    .line 944
    .line 945
    .line 946
    .line 947
    .line 948
    .line 949
    .line 950
    .line 951
    .line 952
    .line 953
    .line 954
    .line 955
    .line 956
    .line 957
    .line 958
    .line 959
    .line 960
    .line 961
    .line 962
    .line 963
    .line 964
    .line 965
    .line 966
    .line 967
    .line 968
    .line 969
    .line 970
    .line 971
    .line 972
    .line 973
    .line 974
    .line 975
    .line 976
    .line 977
    .line 978
    .line 979
    .line 980
    .line 981
    .line 982
    .line 983
    .line 984
    .line 985
    .line 986
    .line 987
    .line 988
    .line 989
    .line 990
    .line 991
    .line 992
    .line 993
    .line 994
    .line 995
    .line 996
    .line 997
    .line 998
    .line 999
    .line 1000
    .line 1001
    .line 1002
    .line 1003
    .line 1004
    .line 1005
    .line 1006
    .line 1007
    .line 1008
    .line 1009
    .line 1010
    .line 1011
    .line 1012
    .line 1013
    .line 1014
    .line 1015
    .line 1016
    .line 1017
    .line 1018
    .line 1019
    .line 1020
    .line 1021
    .line 1022
    .line 1023
    .line 1024
    .line 1025
    .line 1026
    .line 1027
    .line 1028
    .line 1029
    .line 1030
    .line 1031
    .line 1032
    .line 1033
    .line 1034
    .line 1035
    .line 1036
    .line 1037
    .line 1038
    .line 1039
    .line 1040
    .line 1041
    .line 1042
    .line 1043
    .line 1044
    .line 1045
    .line 1046
    .line 1047
    .line 1048
    .line 1049
    .line 1050
    .line 1051
    .line 1052
    .line 1053
    .line 1054
    .line 1055
    .line 1056
    .line 1057
    .line 1058
    .line 1059
    .line 1060
    .line 1061
    .line 1062
    .line 1063
    .line 1064
    .line 1065
    .line 1066
    .line 1067
    .line 1068
    .line 1069
    .line 1070
    .line 1071
    .line 1072
    .line 1073
    .line 1074
    .line 1075
    .line 1076
    .line 1077
    .line 1078
    .line 1079
    .line 1080
    .line 1081
    .line 1082
    .line 1083
    .line 1084
    .line 1085
    .line 1086
    .line 1087
    .line 1088
    .line 1089
    .line 1090
    .line 1091
    .line 1092
    .line 1093
    .line 1094
    .line 1095
    .line 1096
    .line 1097
    .line 1098
    .line 1099
    .line 1100
    .line 1101
    .line 1102
    .line 1103
    .line 1104
    .line 1105
    .line 1106
    .line 1107
    .line 1108
    .line 1109
    .line 1110
    .line 1111
    .line 1112
    .line 1113
    .line 1114
    .line 1115
    .line 1116
    .line 1117
    .line 1118
    .line 1119
    .line 1120
    .line 1121
    .line 1122
    .line 1123
    .line 1124
    .line 1125
    .line 1126
    .line 1127
    .line 1128
    .line 1129
    .line 1130
    .line 1131
    .line 1132
    .line 1133
    .line 1134
    .line 1135
    .line 1136
    .line 1137
    .line 1138
    .line 1139
    .line 1140
    .line 1141
    .line 1142
    .line 1143
    .line 1144
    .line 1145
    .line 1146
    .line 1147
    .line 1148
    .line 1149
    .line 1150
    .line 1151
    .line 1152
    .line 1153
    .line 1154
    .line 1155
    .line 1156
    .line 1157
    .line 1158
    .line 1159
    .line 1160
    .line 1161
    .line 1162
    .line 1163
    .line 1164
    .line 1165
    .line 1166
    .line 1167
    .line 1168
    .line 1169
    .line 1170
    .line 1171
    .line 1172
    .line 1173
    .line 1174
    .line 1175
    .line 1176
    .line 1177
    .line 1178
    .line 1179
    .line 1180
    .line 1181
    .line 1182
    .line 1183
    .line 1184
    .line 1185
    .line 1186
    .line 1187
    .line 1188
    .line 1189
    .line 1190
    .line 1191
    .line 1192
    .line 1193
    .line 1194
    .line 1195
    .line 1196
    .line 1197
    .line 1198
    .line 1199
    .line 1200
    .line 1201
    .line 1202
    .line 1203
    .line 1204
    .line 1205
    .line 1206
    .line 1207
    .line 1208
    .line 1209
    .line 1210
    .line 1211
    .line 1212
    .line 1213
    .line 1214
    .line 1215
    .line 1216
    .line 1217
    .line 1218
    .line 1219
    .line 1220
    .line 1221
    .line 1222
    .line 1223
    .line 1224
    .line 1225
    .line 1226
    .line 1227
    .line 1228
    .line 1229
    .line 1230
    .line 1231
    .line 1232
    .line 1233
    .line 1234
    .line 1235
    .line 1236
    .line 1237
    .line 1238
    .line 1239
    .line 1240
    .line 1241
    .line 1242
    .line 1243
    .line 1244
    .line 1245
    .line 1246
    .line 1247
    .line 1248
    .line 1249
    .line 1250
    .line 1251
    .line 1252
    .line 1253
    .line 1254
    .line 1255
    .line 1256
    .line 1257
    .line 1258
    .line 1259
    .line 1260
    .line 1261
    .line 1262
    .line 1263
    .line 1264
    .line 1265
    .line 1266
    .line 1267
    .line 1268
    .line 1269
    .line 1270
    .line 1271
    .line 1272
    .line 1273
    .line 1274
    .line 1275
    .line 1276
    .line 1277
    .line 1278
    .line 1279
    .line 1280
    .line 1281
    .line 1282
    .line 1283
    .line 1284
    .line 1285
    .line 1286
    .line 1287
    .line 1288
    .line 1289
    .line 1290
    .line 1291
    .line 1292
    .line 1293
    .line 1294
    .line 1295
    .line 1296
    .line 1297
    .line 1298
    .line 1299
    .line 1300
    .line 1301
    .line 1302
    .line 1303
    .line 1304
    .line 1305
    .line 1306
    .line 1307
    .line 1308
    .line 1309
    .line 1310
    .line 1311
    .line 1312
    .line 1313
    .line 1314
    .line 1315
    .line 1316
    .line 1317
    .line 1318
    .line 1319
    .line 1320
    .line 1321
    .line 1322
    .line 1323
    .line 1324
    .line 1325
    .line 1326
    .line 1327
    .line 1328
    .line 1329
    .line 1330
    .line 1331
    .line 1332
    .line 1333
    .line 1334
    .line 1335
    .line 1336
    .line 1337
    .line 1338
    .line 1339
    .line 1340
    .line 1341
    .line 1342
    .line 1343
    .line 1344
    .line 1345
    .line 1346
    .line 1347
    .line 1348
    .line 1349
    .line 1350
    .line 1351
    .line 1352
    .line 1353
    .line 1354
    .line 1355
    .line 1356
    .line 1357
    .line 1358
    .line 1359
    .line 1360
    .line 1361
    .line 1362
    .line 1363
    .line 1364
    .line 1365
    .line 1366
    .line 1367
    .line 1368
    .line 1369
    .line 1370
    .line 1371
    .line 1372
    .line 1373
    .line 1374
    .line 1375
    .line 1376
    .line 1377
    .line 1378
    .line 1379
    .line 1380
    .line 1381
    .line 1382
    .line 1383
    .line 1384
    .line 1385
    .line 1386
    .line 1387
    .line 1388
    .line 1389
    .line 1390
    .line 1391
    .line 1392
    .line 1393
    .line 1394
    .line 1395
    .line 1396
    .line 1397
    .line 1398
    .line 1399
    .line 1400
    .line 1401
    .line 1402
    .line 1403
    .line 1404
    .line 1405
    .line 1406
    .line 1407
    .line 1408
    .line 1409
    .line 1410
    .line 1411
    .line 1412
    .line 1413
    .line 1414
    .line 1415
    .line 1416
    .line 1417
    .line 1418
    .line 1419
    .line 1420
    .line 1421
    .line 1422
    .line 1423
    .line 1424
    .line 1425
    .line 1426
    .line 1427
    .line 1428
    .line 1429
    .line 1430
    .line 1431
    .line 1432
    .line 1433
    .line 1434
    .line 1435
    .line 1436
    .line 1437
    .line 1438
    .line 1439
    .line 1440
    .line 1441
    .line 1442
    .line 1443
    .line 1444
    .line 1445
    .line 1446
    .line 1447
    .line 1448
    .line 1449
    .line 1450
    .line 1451
    .line 1452
    .line 1453
    .line 1454
    .line 1455
    .line 1456
    .line 1457
    .line 1458
    .line 1459
    .line 1460
    .line 1461
    .line 1462
    .line 1463
    .line 1464
    .line 1465
    .line 1466
    .line 1467
    .line 1468
    .line 1469
    .line 1470
    .line 1471
    .line 1472
    .line 1473
    .line 1474
    .line 1475
    .line 1476
    .line 1477
    .line 1478
    .line 1479
    .line 1480
    .line 1481
    .line 1482
    .line 1483
    .line 1484
    .line 1485
    .line 1486
    .line 1487
    .line 1488
    .line 1489
    .line 1490
    .line 1491
    .line 1492
    .line 1493
    .line 1494
    .line 1495
    .line 1496
    .line 1497
    .line 1498
    .line 1499
    .line 1500
    .line 1501
    .line 1502
    .line 1503
    .line 1504
    .line 1505
    .line 1506
    .line 1507
    .line 1508
    .line 1509
    .line 1510
    .line 1511
    .line 1512
    .line 1513
    .line 1514
    .line 1515
    .line 1516
    .line 1517
    .line 1518
    .line 1519
    .line 1520
    .line 1521
    .line 1522
    .line 1523
    .line 1524
    .line 1525
    .line 1526
    .line 1527
    .line 1528
    .line 1529
    .line 1530
    .line 1531
    .line 1532
    .line 1533
    .line 1534
    .line 1535
    .line 1536
    .line 1537
    .line 1538
    .line 1539
    .line 1540
    .line 1541
    .line 1542
    .line 1543
    .line 1544
    .line 1545
    .line 1546
    .line 1547
    .line 1548
    .line 1549
    .line 1550
    .line 1551
    .line 1552
    .line 1553
    .line 1554
    .line 1555
    .line 1556
    .line 1557
    .line 1558
    .line 1559
    .line 1560
    .line 1561
    .line 1562
    .line 1563
    .line 1564
    .line 1565
    .line 1566
    .line 1567
    .line 1568
    .line 1569
    .line 1570
    .line 1571
    .line 1572
    .line 1573
    .line 1574
    .line 1575
    .line 1576
    .line 1577
    .line 1578
    .line 1579
    .line 1580
    .line 1581
    .line 1582
    .line 1583
    .line 1584
    .line 1585
    .line 1586
    .line 1587
    .line 1588
    .line 1589
    .line 1590
    .line 1591
    .line 1592
    .line 1593
    .line 1594
    .line 1595
    .line 1596
    .line 1597
    .line 1598
    .line 1599
    .line 1600
    .line 1601
    .line 1602
    .line 1603
    .line 1604
    .line 1605
    .line 1606
    .line 1607
    .line 1608
    .line 1609
    .line 1610
    .line 1611
    .line 1612
    .line 1613
    .line 1614
    .line 1615
    .line 1616
    .line 1617
    .line 1618
    .line 1619
    .line 1620
    .line 1621
    .line 1622
    .line 1623
    .line 1624
    .line 1625
    .line 1626
    .line 1627
    .line 1628
    .line 1629
    .line 1630
    .line 1631
    .line 1632
    .line 1633
    .line 1634
    .line 1635
    .line 1636
    .line 1637
    .line 1638
    .line 1639
    .line 1640
    .line 1641
    .line 1642
    .line 1643
    .line 1644
    .line 1645
    .line 1646
    .line 1647
    .line 1648
    .line 1649
    .line 1650
    .line 1651
    .line 1652
    .line 1653
    .line 1654
    .line 1655
    .line 1656
    .line 1657
    .line 1658
    .line 1659
    .line 1660
    .line 1661
    .line 1662
    .line 1663
    .line 1664
    .line 1665
    .line 1666
    .line 1667
    .line 1668
    .line 1669
    .line 1670
    .line 1671
    .line 1672
    .line 1673
    .line 1674
    .line 1675
    .line 1676
    .line 1677
    .line 1678
    .line 1679
    .line 1680
    .line 1681
    .line 1682
    .line 1683
    .line 1684
    .line 1685
    .line 1686
    .line 1687
    .line 1688
    .line 1689
    .line 1690
    .line 1691
    .line 1692
    .line 1693
    .line 1694
    .line 1695
    .line 1696
    .line 1697
    .line 1698
    .line 1699
    .line 1700
    .line 1701
    .line 1702
    .line 1703
    .line 1704
    .line 1705
    .line 1706
    .line 1707
    .line 1708
    .line 1709
    .line 1710
    .line 1711
    .line 1712
    .line 1713
    .line 1714
    .line 1715
    .line 1716
    .line 1717
    .line 1718
    .line 1719
    .line 1720
    .line 1721
    .line 1722
    .line 1723
    .line 1724
    .line 1725
    .line 1726
    .line 1727
    .line 1728
    .line 1729
    .line 1730
    .line 1731
    .line 1732
    .line 1733
    .line 1734
    .line 1735
    .line 1736
    .line 1737
    .line 1738
    .line 1739
    .line 1740
    .line 1741
    .line 1742
    .line 1743
    .line 1744
    .line 1745
    .line 1746
    .line 1747
    .line 1748
    .line 1749
    .line 1750
    .line 1751
    .line 1752
    .line 1753
    .line 1754
    .line 1755
    .line 1756
    .line 1757
    .line 1758
    .line 1759
    .line 1760
    .line 1761
    .line 1762
    .line 1763
    .line 1764
    .line 1765
    .line 1766
    .line 1767
    .line 1768
    .line 1769
    .line 1770
    .line 1771
    .line 1772
    .line 1773
    .line 1774
    .line 1775
    .line 1776
    .line 1777
    .line 1778
    .line 1779
    .line 1780
    .line 1781
    .line 1782
    .line 1783
    .line 1784
    .line 1785
    .line 1786
    .line 1787
    .line 1788
    .line 1789
    .line 1790
    .line 1791
    .line 1792
    .line 1793
    .line 1794
    .line 1795
    .line 1796
    .line 1797
    .line 1798
    .line 1799
    .line 1800
    .line 1801
    .line 1802
    .line 1803
    .line 1804
    .line 1805
    .line 1806
    .line 1807
    .line 1808
    .line 1809
    .line 1810
    .line 1811
    .line 1812
    .line 1813
    .line 1814
    .line 1815
    .line 1816
    .line 1817
    .line 1818
    .line 1819
    .line 1820
    .line 1821
    .line 1822
    .line 1823
    .line 1824
    .line 1825
    .line 1826
    .line 1827
    .line 1828
    .line 1829
    .line 1830
    .line 1831
    .line 1832
    .line 1833
    .line 1834
    .line 1835
    .line 1836
    .line 1837
    .line 1838
    .line 1839
    .line 1840
    .line 1841
    .line 1842
    .line 1843
    .line 1844
    .line 1845
    .line 1846
    .line 1847
    .line 1848
    .line 1849
    .line 1850
    .line 1851
    .line 1852
    .line 1853
    .line 1854
    .line 1855
    .line 1856
    .line 1857
    .line 1858
    .line 1859
    .line 1860
    .line 1861
    .line 1862
    .line 1863
    .line 1864
    .line 1865
    .line 1866
    .line 1867
    .line 1868
    .line 1869
    .line 1870
    .line 1871
    .line 1872
    .line 1873
    .line 1874
    .line 1875
    .line 1876
    .line 1877
    .line 1878
    .line 1879
    .line 1880
    .line 1881
    .line 1882
    .line 1883
    .line 1884
    .line 1885
    .line 1886
    .line 1887
    .line 1888
    .line 1889
    .line 1890
    .line 1891
    .line 1892
    .line 1893
    .line 1894
    .line 1895
    .line 1896
    .line 1897
    .line 1898
    .line 1899
    .line 1900
    .line 1901
    .line 1902
    .line 1903
    .line 1904
    .line 1905
    .line 1906
    .line 1907
    .line 1908
    .line 1909
    .line 1910
    .line 1911
    .line 1912
    .line 1913
    .line 1914
    .line 1915
    .line 1916
    .line 1917
    .line 1918
    .line 1919
    .line 1920
    .line 1921
    .line 1922
    .line 1923
    .line 1924
    .line 1925
    .line 1926
    .line 1927
    .line 1928
    .line 1929
    .line 1930
    .line 1931
    .line 1932
    .line 1933
    .line 1934
    .line 1935
    .line 1936
    .line 1937
    .line 1938
    .line 1939
    .line 1940
    .line 1941
    .line 1942
    .line 1943
    .line 1944
    .line 1945
    .line 1946
    .line 1947
    .line 1948
    .line 1949
    .line 1950
    .line 1951
    .line 1952
    .line 1953
    .line 1954
    .line 1955
    .line 1956
    .line 1957
    .line 1958
    .line 1959
    .line 1960
    .line 1961
    .line 1962
    .line 1963
    .line 1964
    .line 1965
    .line 1966
    .line 1967
    .line 1968
    .line 1969
    .line 1970
    .line 1971
    .line 1972
    .line 1973
    .line 1974
    .line 1975
    .line 1976
    .line 1977
    .line 1978
    .line 1979
    .line 1980
    .line 1981
    .line 1982
    .line 1983
    .line 1984
    .line 1985
    .line 1986
    .line 1987
    .line 1988
    .line 1989
    .line 1990
    .line 1991
    .line 1992
    .line 1993
    .line 1994
    .line 1995
    .line 1996
    .line 1997
    .line 1998
    .line 1999
    .line 2000
    .line 2001
    .line 2002
    .line 2003
    .line 2004
    .line 2005
    .line 2006
    .line 2007
    .line 2008
    .line 2009
    .line 2010
    .line 2011
    .line 2012
    .line 2013
    .line 2014
    .line 2015
    .line 2016
    .line 2017
    .line 2018
    .line 2019
    .line 2020
    .line 2021
    .line 2022
    .line 2023
    .line 2024
    .line 2025
    .line 2026
    .line 2027
    .line 2028
    .line 2029
    .line 2030
    .line 2031
    .line 2032
    .line 2033
    .line 2034
    .line 2035
    .line 2036
    .line 2037
    .line 2038
    .line 2039
    .line 2040
    .line 2041
    .line 2042
    .line 2043
    .line 2044
    .line 2045
    .line 2046
    .line 2047
    .line 2048
    .line 2049
    .line 2050
    .line 2051
    .line 2052
    .line 2053
    .line 2054
    .line 2055
    .line 2056
    .line 2057
    .line 2058
    .line 2059
    .line 2060
    .line 2061
    .line 2062
    .line 2063
    .line 2064
    .line 2065
    .line 2066
    .line 2067
    .line 2068
    .line 2069
    .line 2070
    .line 2071
    .line 2072
    .line 2073
    .line 2074
    .line 2075
    .line 2076
    .line 2077
    .line 2078
    .line 2079
    .line 2080
    .line 2081
    .line 2082
    .line 2083
    .line 2084
    .line 2085
    .line 2086
    .line 2087
    .line 2088
    .line 2089
    .line 2090
    .line 2091
    .line 2092
    .line 2093
    .line 2094
    .line 2095
    .line 2096
    .line 2097
    .line 2098
    .line 2099
    .line 2100
    .line 2101
    .line 2102
    .line 2103
    .line 2104
    .line 2105
    .line 2106
    .line 2107
    .line 2108
    .line 2109
    .line 2110
    .line 2111
    .line 2112
    .line 2113
    .line 2114
    .line 2115
    .line 2116
    .line 2117
    .line 2118
    .line 2119
    .line 2120
    .line 2121
    .line 2122
    .line 2123
    .line 2124
    .line 2125
    .line 2126
    .line 2127
    .line 2128
    .line 2129
    .line 2130
    .line 2131
    .line 2132
    .line 2133
    .line 2134
    .line 2135
    .line 2136
    .line 2137
    .line 2138
    .line 2139
    .line 2140
    .line 2141
    .line 2142
.end method

.method public onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V
    .locals 21

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    invoke-super/range {p0 .. p3}, Landroidx/fragment/app/Fragment;->onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 9
    .line 10
    .line 11
    move-result-object v2

    .line 12
    invoke-virtual {v2}, Landroid/app/Activity;->getMenuInflater()Landroid/view/MenuInflater;

    .line 13
    .line 14
    .line 15
    move-result-object v2

    .line 16
    const v3, 0x7f0f0005

    .line 17
    .line 18
    .line 19
    invoke-virtual {v2, v3, v1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 20
    .line 21
    .line 22
    iget-object v2, v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 23
    .line 24
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getSelectedItem()Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 25
    .line 26
    .line 27
    move-result-object v2

    .line 28
    if-nez v2, :cond_0

    .line 29
    .line 30
    return-void

    .line 31
    :cond_0
    iget-object v3, v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 32
    .line 33
    iget v4, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 34
    .line 35
    const/4 v5, 0x0

    .line 36
    invoke-virtual {v3, v4, v5}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 37
    .line 38
    .line 39
    move-result-object v3

    .line 40
    invoke-virtual {v0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 41
    .line 42
    .line 43
    move-result-object v4

    .line 44
    invoke-static {v4}, Lcom/emanuelef/remote_capture/Billing;->newInstance(Landroid/content/Context;)Lcom/emanuelef/remote_capture/PlayBilling;

    .line 45
    .line 46
    .line 47
    move-result-object v6

    .line 48
    invoke-static {v4}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    .line 49
    .line 50
    .line 51
    move-result-object v7

    .line 52
    invoke-virtual {v6}, Lcom/emanuelef/remote_capture/Billing;->isFirewallVisible()Z

    .line 53
    .line 54
    .line 55
    move-result v8

    .line 56
    invoke-static {v7}, Lcom/emanuelef/remote_capture/model/Prefs;->isFirewallWhitelistMode(Landroid/content/SharedPreferences;)Z

    .line 57
    .line 58
    .line 59
    move-result v7

    .line 60
    const-string v9, "no_root_firewall"

    .line 61
    .line 62
    invoke-virtual {v6, v9}, Lcom/emanuelef/remote_capture/PlayBilling;->isPurchased(Ljava/lang/String;)Z

    .line 63
    .line 64
    .line 65
    move-result v10

    .line 66
    if-nez v10, :cond_1

    .line 67
    .line 68
    invoke-virtual {v6, v9}, Lcom/emanuelef/remote_capture/PlayBilling;->isAvailable(Ljava/lang/String;)Z

    .line 69
    .line 70
    .line 71
    move-result v6

    .line 72
    if-eqz v6, :cond_1

    .line 73
    .line 74
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isCapturingAsRoot()Z

    .line 75
    .line 76
    .line 77
    move-result v6

    .line 78
    if-nez v6, :cond_1

    .line 79
    .line 80
    const/4 v6, 0x1

    .line 81
    goto :goto_0

    .line 82
    :cond_1
    const/4 v6, 0x0

    .line 83
    :goto_0
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 84
    .line 85
    .line 86
    move-result-object v9

    .line 87
    invoke-virtual {v9}, Lcom/emanuelef/remote_capture/PCAPdroid;->getBlocklist()Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 88
    .line 89
    .line 90
    move-result-object v9

    .line 91
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 92
    .line 93
    .line 94
    move-result-object v10

    .line 95
    invoke-virtual {v10}, Lcom/emanuelef/remote_capture/PCAPdroid;->getFirewallWhitelist()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 96
    .line 97
    .line 98
    move-result-object v10

    .line 99
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 100
    .line 101
    .line 102
    move-result-object v12

    .line 103
    invoke-virtual {v12}, Lcom/emanuelef/remote_capture/PCAPdroid;->getDecryptionList()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 104
    .line 105
    .line 106
    move-result-object v12

    .line 107
    if-eqz v3, :cond_4

    .line 108
    .line 109
    invoke-virtual {v3}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getUid()I

    .line 110
    .line 111
    .line 112
    move-result v14

    .line 113
    invoke-virtual {v9, v14}, Lcom/emanuelef/remote_capture/model/Blocklist;->matchesApp(I)Z

    .line 114
    .line 115
    .line 116
    move-result v14

    .line 117
    xor-int/lit8 v15, v14, 0x1

    .line 118
    .line 119
    const/16 p2, 0x0

    .line 120
    .line 121
    invoke-virtual {v3}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getUid()I

    .line 122
    .line 123
    .line 124
    move-result v5

    .line 125
    invoke-virtual {v12, v5}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesApp(I)Z

    .line 126
    .line 127
    .line 128
    move-result v5

    .line 129
    xor-int/lit8 v16, v5, 0x1

    .line 130
    .line 131
    const v11, 0x7f0a0186

    .line 132
    .line 133
    .line 134
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 135
    .line 136
    .line 137
    move-result-object v11

    .line 138
    sget-object v13, Lcom/emanuelef/remote_capture/model/MatchList$RuleType;->APP:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 139
    .line 140
    move-object/from16 v17, v3

    .line 141
    .line 142
    invoke-virtual/range {v17 .. v17}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 143
    .line 144
    .line 145
    move-result-object v3

    .line 146
    invoke-static {v4, v13, v3}, Lcom/emanuelef/remote_capture/model/MatchList;->getRuleLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)Ljava/lang/String;

    .line 147
    .line 148
    .line 149
    move-result-object v3

    .line 150
    const/16 v13, 0x20

    .line 151
    .line 152
    invoke-static {v3, v13}, Lcom/emanuelef/remote_capture/Utils;->shorten(Ljava/lang/String;I)Ljava/lang/String;

    .line 153
    .line 154
    .line 155
    move-result-object v3

    .line 156
    invoke-interface {v11, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 157
    .line 158
    .line 159
    const/4 v13, 0x1

    .line 160
    invoke-interface {v11, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 161
    .line 162
    .line 163
    const v11, 0x7f0a02cb

    .line 164
    .line 165
    .line 166
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 167
    .line 168
    .line 169
    move-result-object v11

    .line 170
    invoke-interface {v11, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 171
    .line 172
    .line 173
    invoke-interface {v11, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 174
    .line 175
    .line 176
    const v11, 0x7f0a0096

    .line 177
    .line 178
    .line 179
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 180
    .line 181
    .line 182
    move-result-object v11

    .line 183
    invoke-interface {v11, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 184
    .line 185
    .line 186
    xor-int/lit8 v13, v14, 0x1

    .line 187
    .line 188
    invoke-interface {v11, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 189
    .line 190
    .line 191
    const v11, 0x7f0a0373

    .line 192
    .line 193
    .line 194
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 195
    .line 196
    .line 197
    move-result-object v11

    .line 198
    invoke-interface {v11, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 199
    .line 200
    .line 201
    invoke-interface {v11, v14}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 202
    .line 203
    .line 204
    const v11, 0x7f0a00f5

    .line 205
    .line 206
    .line 207
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 208
    .line 209
    .line 210
    move-result-object v11

    .line 211
    invoke-interface {v11, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 212
    .line 213
    .line 214
    xor-int/lit8 v13, v5, 0x1

    .line 215
    .line 216
    invoke-interface {v11, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 217
    .line 218
    .line 219
    const v11, 0x7f0a00f8

    .line 220
    .line 221
    .line 222
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 223
    .line 224
    .line 225
    move-result-object v11

    .line 226
    invoke-interface {v11, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 227
    .line 228
    .line 229
    invoke-interface {v11, v5}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 230
    .line 231
    .line 232
    const v11, 0x7f0a0374

    .line 233
    .line 234
    .line 235
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 236
    .line 237
    .line 238
    move-result-object v11

    .line 239
    const/16 v13, 0xa

    .line 240
    .line 241
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 242
    .line 243
    .line 244
    move-result-object v13

    .line 245
    move/from16 v18, v5

    .line 246
    .line 247
    move/from16 v19, v6

    .line 248
    .line 249
    const/4 v5, 0x1

    .line 250
    new-array v6, v5, [Ljava/lang/Object;

    .line 251
    .line 252
    aput-object v13, v6, p2

    .line 253
    .line 254
    const v13, 0x7f1402d0

    .line 255
    .line 256
    .line 257
    invoke-virtual {v0, v13, v6}, Landroidx/fragment/app/Fragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    .line 258
    .line 259
    .line 260
    move-result-object v6

    .line 261
    invoke-interface {v11, v6}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 262
    .line 263
    .line 264
    const v6, 0x7f0a0375

    .line 265
    .line 266
    .line 267
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 268
    .line 269
    .line 270
    move-result-object v6

    .line 271
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 272
    .line 273
    .line 274
    move-result-object v11

    .line 275
    new-array v13, v5, [Ljava/lang/Object;

    .line 276
    .line 277
    aput-object v11, v13, p2

    .line 278
    .line 279
    const v11, 0x7f1402cf

    .line 280
    .line 281
    .line 282
    invoke-virtual {v0, v11, v13}, Landroidx/fragment/app/Fragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    .line 283
    .line 284
    .line 285
    move-result-object v13

    .line 286
    invoke-interface {v6, v13}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 287
    .line 288
    .line 289
    const v6, 0x7f0a0376

    .line 290
    .line 291
    .line 292
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 293
    .line 294
    .line 295
    move-result-object v6

    .line 296
    const/16 v13, 0x8

    .line 297
    .line 298
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 299
    .line 300
    .line 301
    move-result-object v13

    .line 302
    move/from16 v20, v7

    .line 303
    .line 304
    new-array v7, v5, [Ljava/lang/Object;

    .line 305
    .line 306
    aput-object v13, v7, p2

    .line 307
    .line 308
    invoke-virtual {v0, v11, v7}, Landroidx/fragment/app/Fragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    .line 309
    .line 310
    .line 311
    move-result-object v7

    .line 312
    invoke-interface {v6, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 313
    .line 314
    .line 315
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isBlacklisted()Z

    .line 316
    .line 317
    .line 318
    move-result v6

    .line 319
    if-eqz v6, :cond_2

    .line 320
    .line 321
    const v6, 0x7f0a0221

    .line 322
    .line 323
    .line 324
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 325
    .line 326
    .line 327
    move-result-object v6

    .line 328
    invoke-interface {v6, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 329
    .line 330
    .line 331
    invoke-interface {v6, v5}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 332
    .line 333
    .line 334
    :cond_2
    if-eqz v8, :cond_3

    .line 335
    .line 336
    if-eqz v20, :cond_3

    .line 337
    .line 338
    invoke-virtual/range {v17 .. v17}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getUid()I

    .line 339
    .line 340
    .line 341
    move-result v3

    .line 342
    invoke-virtual {v10, v3}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesApp(I)Z

    .line 343
    .line 344
    .line 345
    move-result v3

    .line 346
    const v5, 0x7f0a005d

    .line 347
    .line 348
    .line 349
    invoke-interface {v1, v5}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 350
    .line 351
    .line 352
    move-result-object v5

    .line 353
    xor-int/lit8 v6, v3, 0x1

    .line 354
    .line 355
    invoke-interface {v5, v6}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 356
    .line 357
    .line 358
    const v5, 0x7f0a02ab

    .line 359
    .line 360
    .line 361
    invoke-interface {v1, v5}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 362
    .line 363
    .line 364
    move-result-object v5

    .line 365
    invoke-interface {v5, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 366
    .line 367
    .line 368
    :cond_3
    move/from16 v5, v18

    .line 369
    .line 370
    goto :goto_1

    .line 371
    :cond_4
    move/from16 v19, v6

    .line 372
    .line 373
    const/16 p2, 0x0

    .line 374
    .line 375
    const/4 v5, 0x0

    .line 376
    const/4 v14, 0x0

    .line 377
    const/4 v15, 0x0

    .line 378
    const/16 v16, 0x0

    .line 379
    .line 380
    :goto_1
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 381
    .line 382
    if-eqz v3, :cond_6

    .line 383
    .line 384
    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    .line 385
    .line 386
    .line 387
    move-result v3

    .line 388
    if-nez v3, :cond_6

    .line 389
    .line 390
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 391
    .line 392
    invoke-virtual {v9, v3}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesExactHost(Ljava/lang/String;)Z

    .line 393
    .line 394
    .line 395
    move-result v3

    .line 396
    sget-object v6, Lcom/emanuelef/remote_capture/model/MatchList$RuleType;->HOST:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 397
    .line 398
    iget-object v7, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 399
    .line 400
    invoke-static {v4, v6, v7}, Lcom/emanuelef/remote_capture/model/MatchList;->getRuleLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)Ljava/lang/String;

    .line 401
    .line 402
    .line 403
    move-result-object v7

    .line 404
    const/16 v13, 0x20

    .line 405
    .line 406
    invoke-static {v7, v13}, Lcom/emanuelef/remote_capture/Utils;->shorten(Ljava/lang/String;I)Ljava/lang/String;

    .line 407
    .line 408
    .line 409
    move-result-object v7

    .line 410
    xor-int/lit8 v10, v3, 0x1

    .line 411
    .line 412
    or-int/2addr v10, v15

    .line 413
    or-int v11, v14, v3

    .line 414
    .line 415
    iget-object v13, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 416
    .line 417
    invoke-virtual {v12, v13}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesExactHost(Ljava/lang/String;)Z

    .line 418
    .line 419
    .line 420
    move-result v13

    .line 421
    xor-int/lit8 v14, v13, 0x1

    .line 422
    .line 423
    or-int v16, v16, v14

    .line 424
    .line 425
    or-int/2addr v5, v13

    .line 426
    const v14, 0x7f0a0189

    .line 427
    .line 428
    .line 429
    invoke-interface {v1, v14}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 430
    .line 431
    .line 432
    move-result-object v14

    .line 433
    invoke-interface {v14, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 434
    .line 435
    .line 436
    const/4 v15, 0x1

    .line 437
    invoke-interface {v14, v15}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 438
    .line 439
    .line 440
    const v14, 0x7f0a0099

    .line 441
    .line 442
    .line 443
    invoke-interface {v1, v14}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 444
    .line 445
    .line 446
    move-result-object v14

    .line 447
    invoke-interface {v14, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 448
    .line 449
    .line 450
    xor-int/lit8 v15, v3, 0x1

    .line 451
    .line 452
    invoke-interface {v14, v15}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 453
    .line 454
    .line 455
    const v14, 0x7f0a037a

    .line 456
    .line 457
    .line 458
    invoke-interface {v1, v14}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 459
    .line 460
    .line 461
    move-result-object v14

    .line 462
    invoke-interface {v14, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 463
    .line 464
    .line 465
    invoke-interface {v14, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 466
    .line 467
    .line 468
    const v3, 0x7f0a02d2

    .line 469
    .line 470
    .line 471
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 472
    .line 473
    .line 474
    move-result-object v3

    .line 475
    invoke-interface {v3, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 476
    .line 477
    .line 478
    const/4 v15, 0x1

    .line 479
    invoke-interface {v3, v15}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 480
    .line 481
    .line 482
    const v3, 0x7f0a00de

    .line 483
    .line 484
    .line 485
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 486
    .line 487
    .line 488
    move-result-object v3

    .line 489
    invoke-interface {v3, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 490
    .line 491
    .line 492
    invoke-interface {v3, v15}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 493
    .line 494
    .line 495
    const v3, 0x7f0a00f6

    .line 496
    .line 497
    .line 498
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 499
    .line 500
    .line 501
    move-result-object v3

    .line 502
    invoke-interface {v3, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 503
    .line 504
    .line 505
    xor-int/lit8 v14, v13, 0x1

    .line 506
    .line 507
    invoke-interface {v3, v14}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 508
    .line 509
    .line 510
    const v3, 0x7f0a00f9

    .line 511
    .line 512
    .line 513
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 514
    .line 515
    .line 516
    move-result-object v3

    .line 517
    invoke-interface {v3, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 518
    .line 519
    .line 520
    invoke-interface {v3, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 521
    .line 522
    .line 523
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 524
    .line 525
    invoke-static {v3}, Lcom/emanuelef/remote_capture/Utils;->cleanDomain(Ljava/lang/String;)Ljava/lang/String;

    .line 526
    .line 527
    .line 528
    move-result-object v3

    .line 529
    invoke-static {v3}, Lcom/emanuelef/remote_capture/Utils;->getSecondLevelDomain(Ljava/lang/String;)Ljava/lang/String;

    .line 530
    .line 531
    .line 532
    move-result-object v13

    .line 533
    invoke-virtual {v13, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 534
    .line 535
    .line 536
    move-result v3

    .line 537
    if-nez v3, :cond_5

    .line 538
    .line 539
    invoke-virtual {v9, v13}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesExactHost(Ljava/lang/String;)Z

    .line 540
    .line 541
    .line 542
    move-result v3

    .line 543
    invoke-static {v4, v6, v13}, Lcom/emanuelef/remote_capture/model/MatchList;->getRuleLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)Ljava/lang/String;

    .line 544
    .line 545
    .line 546
    move-result-object v6

    .line 547
    const/16 v13, 0x20

    .line 548
    .line 549
    invoke-static {v6, v13}, Lcom/emanuelef/remote_capture/Utils;->shorten(Ljava/lang/String;I)Ljava/lang/String;

    .line 550
    .line 551
    .line 552
    move-result-object v7

    .line 553
    xor-int/lit8 v6, v3, 0x1

    .line 554
    .line 555
    or-int/2addr v6, v10

    .line 556
    or-int v10, v11, v3

    .line 557
    .line 558
    const v11, 0x7f0a0188

    .line 559
    .line 560
    .line 561
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 562
    .line 563
    .line 564
    move-result-object v11

    .line 565
    invoke-interface {v11, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 566
    .line 567
    .line 568
    const/4 v15, 0x1

    .line 569
    invoke-interface {v11, v15}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 570
    .line 571
    .line 572
    const v11, 0x7f0a0098

    .line 573
    .line 574
    .line 575
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 576
    .line 577
    .line 578
    move-result-object v11

    .line 579
    invoke-interface {v11, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 580
    .line 581
    .line 582
    xor-int/lit8 v13, v3, 0x1

    .line 583
    .line 584
    invoke-interface {v11, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 585
    .line 586
    .line 587
    const v11, 0x7f0a0379

    .line 588
    .line 589
    .line 590
    invoke-interface {v1, v11}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 591
    .line 592
    .line 593
    move-result-object v11

    .line 594
    invoke-interface {v11, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 595
    .line 596
    .line 597
    invoke-interface {v11, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 598
    .line 599
    .line 600
    move v15, v6

    .line 601
    move v14, v10

    .line 602
    goto :goto_2

    .line 603
    :cond_5
    move v15, v10

    .line 604
    move v14, v11

    .line 605
    :goto_2
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isBlacklistedHost()Z

    .line 606
    .line 607
    .line 608
    move-result v3

    .line 609
    if-eqz v3, :cond_6

    .line 610
    .line 611
    const v3, 0x7f0a0222

    .line 612
    .line 613
    .line 614
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 615
    .line 616
    .line 617
    move-result-object v3

    .line 618
    invoke-interface {v3, v7}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 619
    .line 620
    .line 621
    const/4 v13, 0x1

    .line 622
    invoke-interface {v3, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 623
    .line 624
    .line 625
    :cond_6
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->url:Ljava/lang/String;

    .line 626
    .line 627
    if-eqz v3, :cond_7

    .line 628
    .line 629
    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    .line 630
    .line 631
    .line 632
    move-result v3

    .line 633
    if-nez v3, :cond_7

    .line 634
    .line 635
    const v3, 0x7f0a00e4

    .line 636
    .line 637
    .line 638
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 639
    .line 640
    .line 641
    move-result-object v3

    .line 642
    const v6, 0x7f1402df

    .line 643
    .line 644
    .line 645
    invoke-virtual {v0, v6}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 646
    .line 647
    .line 648
    move-result-object v6

    .line 649
    iget-object v7, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->url:Ljava/lang/String;

    .line 650
    .line 651
    const/4 v13, 0x1

    .line 652
    new-array v10, v13, [Ljava/lang/Object;

    .line 653
    .line 654
    aput-object v7, v10, p2

    .line 655
    .line 656
    invoke-static {v6, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 657
    .line 658
    .line 659
    move-result-object v6

    .line 660
    const/16 v7, 0x20

    .line 661
    .line 662
    invoke-static {v6, v7}, Lcom/emanuelef/remote_capture/Utils;->shorten(Ljava/lang/String;I)Ljava/lang/String;

    .line 663
    .line 664
    .line 665
    move-result-object v6

    .line 666
    invoke-interface {v3, v6}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 667
    .line 668
    .line 669
    invoke-interface {v3, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 670
    .line 671
    .line 672
    :cond_7
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->country:Ljava/lang/String;

    .line 673
    .line 674
    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    .line 675
    .line 676
    .line 677
    move-result v3

    .line 678
    if-nez v3, :cond_8

    .line 679
    .line 680
    iget-object v3, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->country:Ljava/lang/String;

    .line 681
    .line 682
    invoke-virtual {v9, v3}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesCountry(Ljava/lang/String;)Z

    .line 683
    .line 684
    .line 685
    move-result v3

    .line 686
    const v6, 0x7f1400b0

    .line 687
    .line 688
    .line 689
    invoke-virtual {v0, v6}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 690
    .line 691
    .line 692
    move-result-object v6

    .line 693
    iget-object v7, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->country:Ljava/lang/String;

    .line 694
    .line 695
    invoke-static {v4, v7}, Lcom/emanuelef/remote_capture/Utils;->getCountryName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    .line 696
    .line 697
    .line 698
    move-result-object v7

    .line 699
    const/4 v13, 0x1

    .line 700
    new-array v10, v13, [Ljava/lang/Object;

    .line 701
    .line 702
    aput-object v7, v10, p2

    .line 703
    .line 704
    invoke-static {v6, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 705
    .line 706
    .line 707
    move-result-object v6

    .line 708
    const/16 v13, 0x20

    .line 709
    .line 710
    invoke-static {v6, v13}, Lcom/emanuelef/remote_capture/Utils;->shorten(Ljava/lang/String;I)Ljava/lang/String;

    .line 711
    .line 712
    .line 713
    move-result-object v6

    .line 714
    xor-int/lit8 v7, v3, 0x1

    .line 715
    .line 716
    or-int/2addr v15, v7

    .line 717
    or-int/2addr v14, v3

    .line 718
    const v7, 0x7f0a0097

    .line 719
    .line 720
    .line 721
    invoke-interface {v1, v7}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 722
    .line 723
    .line 724
    move-result-object v7

    .line 725
    invoke-interface {v7, v6}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 726
    .line 727
    .line 728
    xor-int/lit8 v10, v3, 0x1

    .line 729
    .line 730
    invoke-interface {v7, v10}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 731
    .line 732
    .line 733
    const v7, 0x7f0a0378

    .line 734
    .line 735
    .line 736
    invoke-interface {v1, v7}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 737
    .line 738
    .line 739
    move-result-object v7

    .line 740
    invoke-interface {v7, v6}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 741
    .line 742
    .line 743
    invoke-interface {v7, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 744
    .line 745
    .line 746
    const v3, 0x7f0a0187

    .line 747
    .line 748
    .line 749
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 750
    .line 751
    .line 752
    move-result-object v3

    .line 753
    invoke-interface {v3, v6}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 754
    .line 755
    .line 756
    const/4 v13, 0x1

    .line 757
    invoke-interface {v3, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 758
    .line 759
    .line 760
    :cond_8
    sget-object v3, Lcom/emanuelef/remote_capture/model/MatchList$RuleType;->IP:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 761
    .line 762
    iget-object v6, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 763
    .line 764
    invoke-static {v4, v3, v6}, Lcom/emanuelef/remote_capture/model/MatchList;->getRuleLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)Ljava/lang/String;

    .line 765
    .line 766
    .line 767
    move-result-object v3

    .line 768
    const v6, 0x7f0a018b

    .line 769
    .line 770
    .line 771
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 772
    .line 773
    .line 774
    move-result-object v6

    .line 775
    invoke-interface {v6, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 776
    .line 777
    .line 778
    const v6, 0x7f0a00e2

    .line 779
    .line 780
    .line 781
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 782
    .line 783
    .line 784
    move-result-object v6

    .line 785
    invoke-interface {v6, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 786
    .line 787
    .line 788
    const v6, 0x7f0a02d3

    .line 789
    .line 790
    .line 791
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 792
    .line 793
    .line 794
    move-result-object v6

    .line 795
    invoke-interface {v6, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 796
    .line 797
    .line 798
    const/4 v6, 0x0

    .line 799
    iput-object v6, v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mUnblockCidr:Ljava/lang/String;

    .line 800
    .line 801
    iput-object v6, v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mDecRemoveCidr:Ljava/lang/String;

    .line 802
    .line 803
    iget-object v6, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 804
    .line 805
    invoke-virtual {v9, v6}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesExactIP(Ljava/lang/String;)Z

    .line 806
    .line 807
    .line 808
    move-result v13

    .line 809
    if-nez v13, :cond_9

    .line 810
    .line 811
    iget-object v6, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 812
    .line 813
    invoke-virtual {v9, v6}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesCidr(Ljava/lang/String;)Lcom/emanuelef/remote_capture/Cidr;

    .line 814
    .line 815
    .line 816
    move-result-object v6

    .line 817
    if-eqz v6, :cond_9

    .line 818
    .line 819
    invoke-virtual {v6}, Lcom/emanuelef/remote_capture/Cidr;->toString()Ljava/lang/String;

    .line 820
    .line 821
    .line 822
    move-result-object v7

    .line 823
    iput-object v7, v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mUnblockCidr:Ljava/lang/String;

    .line 824
    .line 825
    invoke-static {v4, v6}, Lcom/emanuelef/remote_capture/model/MatchList;->getCidrLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/Cidr;)Ljava/lang/String;

    .line 826
    .line 827
    .line 828
    move-result-object v6

    .line 829
    const/4 v13, 0x1

    .line 830
    goto :goto_3

    .line 831
    :cond_9
    move-object v6, v3

    .line 832
    :goto_3
    xor-int/lit8 v7, v13, 0x1

    .line 833
    .line 834
    or-int/2addr v7, v15

    .line 835
    or-int v9, v14, v13

    .line 836
    .line 837
    iget-object v10, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 838
    .line 839
    invoke-virtual {v12, v10}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesExactIP(Ljava/lang/String;)Z

    .line 840
    .line 841
    .line 842
    move-result v10

    .line 843
    if-nez v10, :cond_a

    .line 844
    .line 845
    iget-object v11, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 846
    .line 847
    invoke-virtual {v12, v11}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesCidr(Ljava/lang/String;)Lcom/emanuelef/remote_capture/Cidr;

    .line 848
    .line 849
    .line 850
    move-result-object v11

    .line 851
    if-eqz v11, :cond_a

    .line 852
    .line 853
    invoke-virtual {v11}, Lcom/emanuelef/remote_capture/Cidr;->toString()Ljava/lang/String;

    .line 854
    .line 855
    .line 856
    move-result-object v10

    .line 857
    iput-object v10, v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mDecRemoveCidr:Ljava/lang/String;

    .line 858
    .line 859
    invoke-static {v4, v11}, Lcom/emanuelef/remote_capture/model/MatchList;->getCidrLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/Cidr;)Ljava/lang/String;

    .line 860
    .line 861
    .line 862
    move-result-object v10

    .line 863
    const/4 v11, 0x1

    .line 864
    goto :goto_4

    .line 865
    :cond_a
    move v11, v10

    .line 866
    move-object v10, v3

    .line 867
    :goto_4
    xor-int/lit8 v12, v11, 0x1

    .line 868
    .line 869
    or-int v12, v16, v12

    .line 870
    .line 871
    or-int/2addr v5, v11

    .line 872
    const v14, 0x7f0a009a

    .line 873
    .line 874
    .line 875
    invoke-interface {v1, v14}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 876
    .line 877
    .line 878
    move-result-object v14

    .line 879
    invoke-interface {v14, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 880
    .line 881
    .line 882
    move-result-object v14

    .line 883
    xor-int/lit8 v15, v13, 0x1

    .line 884
    .line 885
    invoke-interface {v14, v15}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 886
    .line 887
    .line 888
    const v14, 0x7f0a037b

    .line 889
    .line 890
    .line 891
    invoke-interface {v1, v14}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 892
    .line 893
    .line 894
    move-result-object v14

    .line 895
    invoke-interface {v14, v6}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 896
    .line 897
    .line 898
    move-result-object v6

    .line 899
    invoke-interface {v6, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 900
    .line 901
    .line 902
    const v6, 0x7f0a00f7

    .line 903
    .line 904
    .line 905
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 906
    .line 907
    .line 908
    move-result-object v6

    .line 909
    invoke-interface {v6, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 910
    .line 911
    .line 912
    move-result-object v6

    .line 913
    xor-int/lit8 v13, v11, 0x1

    .line 914
    .line 915
    invoke-interface {v6, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 916
    .line 917
    .line 918
    const v6, 0x7f0a00fa

    .line 919
    .line 920
    .line 921
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 922
    .line 923
    .line 924
    move-result-object v6

    .line 925
    invoke-interface {v6, v10}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 926
    .line 927
    .line 928
    move-result-object v6

    .line 929
    invoke-interface {v6, v11}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 930
    .line 931
    .line 932
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isBlacklistedIp()Z

    .line 933
    .line 934
    .line 935
    move-result v6

    .line 936
    if-eqz v6, :cond_b

    .line 937
    .line 938
    const v6, 0x7f0a0223

    .line 939
    .line 940
    .line 941
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 942
    .line 943
    .line 944
    move-result-object v6

    .line 945
    invoke-interface {v6, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 946
    .line 947
    .line 948
    move-result-object v3

    .line 949
    const/4 v13, 0x1

    .line 950
    invoke-interface {v3, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 951
    .line 952
    .line 953
    goto :goto_5

    .line 954
    :cond_b
    const/4 v13, 0x1

    .line 955
    :goto_5
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->hasHttpRequest()Z

    .line 956
    .line 957
    .line 958
    move-result v3

    .line 959
    if-eqz v3, :cond_c

    .line 960
    .line 961
    const v3, 0x7f0a00df

    .line 962
    .line 963
    .line 964
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 965
    .line 966
    .line 967
    move-result-object v3

    .line 968
    invoke-interface {v3, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 969
    .line 970
    .line 971
    :cond_c
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->hasHttpResponse()Z

    .line 972
    .line 973
    .line 974
    move-result v3

    .line 975
    if-eqz v3, :cond_d

    .line 976
    .line 977
    const v3, 0x7f0a00e0

    .line 978
    .line 979
    .line 980
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 981
    .line 982
    .line 983
    move-result-object v3

    .line 984
    invoke-interface {v3, v13}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 985
    .line 986
    .line 987
    :cond_d
    sget-object v3, Lcom/emanuelef/remote_capture/model/MatchList$RuleType;->PROTOCOL:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 988
    .line 989
    iget-object v6, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->l7proto:Ljava/lang/String;

    .line 990
    .line 991
    invoke-static {v4, v3, v6}, Lcom/emanuelef/remote_capture/model/MatchList;->getRuleLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)Ljava/lang/String;

    .line 992
    .line 993
    .line 994
    move-result-object v3

    .line 995
    const v4, 0x7f0a018c

    .line 996
    .line 997
    .line 998
    invoke-interface {v1, v4}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 999
    .line 1000
    .line 1001
    move-result-object v4

    .line 1002
    invoke-interface {v4, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 1003
    .line 1004
    .line 1005
    const v4, 0x7f0a02d6

    .line 1006
    .line 1007
    .line 1008
    invoke-interface {v1, v4}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 1009
    .line 1010
    .line 1011
    move-result-object v4

    .line 1012
    invoke-interface {v4, v3}, Landroid/view/MenuItem;->setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 1013
    .line 1014
    .line 1015
    const v3, 0x7f0a009b

    .line 1016
    .line 1017
    .line 1018
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 1019
    .line 1020
    .line 1021
    move-result-object v3

    .line 1022
    if-nez v8, :cond_e

    .line 1023
    .line 1024
    if-eqz v19, :cond_f

    .line 1025
    .line 1026
    :cond_e
    if-eqz v7, :cond_f

    .line 1027
    .line 1028
    const/4 v4, 0x1

    .line 1029
    goto :goto_6

    .line 1030
    :cond_f
    const/4 v4, 0x0

    .line 1031
    :goto_6
    invoke-interface {v3, v4}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1032
    .line 1033
    .line 1034
    const v3, 0x7f0a037c

    .line 1035
    .line 1036
    .line 1037
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 1038
    .line 1039
    .line 1040
    move-result-object v3

    .line 1041
    if-eqz v8, :cond_10

    .line 1042
    .line 1043
    if-eqz v9, :cond_10

    .line 1044
    .line 1045
    const/4 v4, 0x1

    .line 1046
    goto :goto_7

    .line 1047
    :cond_10
    const/4 v4, 0x0

    .line 1048
    :goto_7
    invoke-interface {v3, v4}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1049
    .line 1050
    .line 1051
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isBlacklisted()Z

    .line 1052
    .line 1053
    .line 1054
    move-result v3

    .line 1055
    if-nez v3, :cond_11

    .line 1056
    .line 1057
    const v3, 0x7f0a0224

    .line 1058
    .line 1059
    .line 1060
    invoke-interface {v1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 1061
    .line 1062
    .line 1063
    move-result-object v3

    .line 1064
    const/4 v4, 0x0

    .line 1065
    invoke-interface {v3, v4}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1066
    .line 1067
    .line 1068
    goto :goto_8

    .line 1069
    :cond_11
    const/4 v4, 0x0

    .line 1070
    :goto_8
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isDecryptionListEnabled()Z

    .line 1071
    .line 1072
    .line 1073
    move-result v3

    .line 1074
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isNotDecryptable()Z

    .line 1075
    .line 1076
    .line 1077
    move-result v6

    .line 1078
    if-nez v6, :cond_12

    .line 1079
    .line 1080
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isCleartext()Z

    .line 1081
    .line 1082
    .line 1083
    move-result v2

    .line 1084
    if-nez v2, :cond_12

    .line 1085
    .line 1086
    const/4 v2, 0x1

    .line 1087
    goto :goto_9

    .line 1088
    :cond_12
    const/4 v2, 0x0

    .line 1089
    :goto_9
    const v6, 0x7f0a0101

    .line 1090
    .line 1091
    .line 1092
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 1093
    .line 1094
    .line 1095
    move-result-object v6

    .line 1096
    if-eqz v3, :cond_13

    .line 1097
    .line 1098
    if-eqz v2, :cond_13

    .line 1099
    .line 1100
    if-eqz v12, :cond_13

    .line 1101
    .line 1102
    const/4 v7, 0x1

    .line 1103
    goto :goto_a

    .line 1104
    :cond_13
    const/4 v7, 0x0

    .line 1105
    :goto_a
    invoke-interface {v6, v7}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1106
    .line 1107
    .line 1108
    const v6, 0x7f0a0136

    .line 1109
    .line 1110
    .line 1111
    invoke-interface {v1, v6}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 1112
    .line 1113
    .line 1114
    move-result-object v1

    .line 1115
    if-eqz v3, :cond_14

    .line 1116
    .line 1117
    if-eqz v2, :cond_14

    .line 1118
    .line 1119
    if-eqz v5, :cond_14

    .line 1120
    .line 1121
    const/4 v5, 0x1

    .line 1122
    goto :goto_b

    .line 1123
    :cond_14
    const/4 v5, 0x0

    .line 1124
    :goto_b
    invoke-interface {v1, v5}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 1125
    .line 1126
    .line 1127
    return-void
    .line 1128
    .line 1129
    .line 1130
    .line 1131
    .line 1132
    .line 1133
    .line 1134
    .line 1135
    .line 1136
    .line 1137
    .line 1138
    .line 1139
    .line 1140
    .line 1141
    .line 1142
    .line 1143
    .line 1144
    .line 1145
    .line 1146
    .line 1147
    .line 1148
    .line 1149
    .line 1150
    .line 1151
    .line 1152
    .line 1153
    .line 1154
    .line 1155
    .line 1156
    .line 1157
    .line 1158
    .line 1159
    .line 1160
    .line 1161
    .line 1162
    .line 1163
    .line 1164
    .line 1165
    .line 1166
    .line 1167
    .line 1168
    .line 1169
    .line 1170
    .line 1171
    .line 1172
    .line 1173
    .line 1174
    .line 1175
    .line 1176
    .line 1177
    .line 1178
    .line 1179
    .line 1180
    .line 1181
    .line 1182
    .line 1183
    .line 1184
    .line 1185
    .line 1186
    .line 1187
    .line 1188
    .line 1189
    .line 1190
    .line 1191
    .line 1192
    .line 1193
    .line 1194
    .line 1195
    .line 1196
    .line 1197
    .line 1198
    .line 1199
    .line 1200
    .line 1201
    .line 1202
    .line 1203
    .line 1204
    .line 1205
    .line 1206
    .line 1207
    .line 1208
    .line 1209
    .line 1210
    .line 1211
    .line 1212
    .line 1213
    .line 1214
    .line 1215
    .line 1216
    .line 1217
    .line 1218
    .line 1219
    .line 1220
    .line 1221
    .line 1222
    .line 1223
    .line 1224
    .line 1225
    .line 1226
    .line 1227
    .line 1228
    .line 1229
    .line 1230
    .line 1231
    .line 1232
    .line 1233
    .line 1234
    .line 1235
    .line 1236
    .line 1237
    .line 1238
    .line 1239
    .line 1240
    .line 1241
    .line 1242
    .line 1243
    .line 1244
    .line 1245
    .line 1246
    .line 1247
    .line 1248
    .line 1249
    .line 1250
    .line 1251
    .line 1252
    .line 1253
    .line 1254
    .line 1255
    .line 1256
    .line 1257
    .line 1258
    .line 1259
    .line 1260
    .line 1261
    .line 1262
    .line 1263
    .line 1264
    .line 1265
    .line 1266
    .line 1267
    .line 1268
    .line 1269
    .line 1270
    .line 1271
    .line 1272
    .line 1273
    .line 1274
    .line 1275
    .line 1276
    .line 1277
    .line 1278
    .line 1279
    .line 1280
    .line 1281
    .line 1282
    .line 1283
    .line 1284
    .line 1285
    .line 1286
    .line 1287
    .line 1288
    .line 1289
    .line 1290
    .line 1291
    .line 1292
    .line 1293
    .line 1294
    .line 1295
    .line 1296
    .line 1297
    .line 1298
    .line 1299
    .line 1300
    .line 1301
    .line 1302
    .line 1303
    .line 1304
    .line 1305
    .line 1306
    .line 1307
    .line 1308
    .line 1309
    .line 1310
    .line 1311
    .line 1312
    .line 1313
    .line 1314
    .line 1315
    .line 1316
    .line 1317
    .line 1318
    .line 1319
    .line 1320
    .line 1321
    .line 1322
    .line 1323
    .line 1324
    .line 1325
    .line 1326
    .line 1327
    .line 1328
    .line 1329
    .line 1330
    .line 1331
    .line 1332
    .line 1333
    .line 1334
    .line 1335
    .line 1336
    .line 1337
    .line 1338
    .line 1339
    .line 1340
    .line 1341
    .line 1342
    .line 1343
    .line 1344
    .line 1345
    .line 1346
    .line 1347
    .line 1348
    .line 1349
    .line 1350
    .line 1351
    .line 1352
    .line 1353
    .line 1354
    .line 1355
    .line 1356
    .line 1357
    .line 1358
    .line 1359
    .line 1360
    .line 1361
    .line 1362
    .line 1363
    .line 1364
    .line 1365
    .line 1366
    .line 1367
    .line 1368
    .line 1369
    .line 1370
    .line 1371
    .line 1372
    .line 1373
    .line 1374
    .line 1375
    .line 1376
    .line 1377
    .line 1378
    .line 1379
    .line 1380
    .line 1381
    .line 1382
    .line 1383
    .line 1384
    .line 1385
    .line 1386
    .line 1387
    .line 1388
    .line 1389
    .line 1390
    .line 1391
    .line 1392
    .line 1393
    .line 1394
    .line 1395
    .line 1396
    .line 1397
    .line 1398
    .line 1399
    .line 1400
    .line 1401
    .line 1402
    .line 1403
    .line 1404
    .line 1405
    .line 1406
    .line 1407
    .line 1408
    .line 1409
    .line 1410
    .line 1411
    .line 1412
    .line 1413
    .line 1414
    .line 1415
    .line 1416
    .line 1417
    .line 1418
    .line 1419
    .line 1420
    .line 1421
    .line 1422
    .line 1423
    .line 1424
    .line 1425
    .line 1426
    .line 1427
    .line 1428
    .line 1429
    .line 1430
    .line 1431
    .line 1432
    .line 1433
    .line 1434
    .line 1435
    .line 1436
    .line 1437
    .line 1438
    .line 1439
    .line 1440
    .line 1441
    .line 1442
    .line 1443
    .line 1444
    .line 1445
    .line 1446
    .line 1447
    .line 1448
    .line 1449
    .line 1450
    .line 1451
    .line 1452
    .line 1453
    .line 1454
    .line 1455
    .line 1456
    .line 1457
    .line 1458
    .line 1459
    .line 1460
    .line 1461
    .line 1462
    .line 1463
    .line 1464
    .line 1465
    .line 1466
    .line 1467
    .line 1468
    .line 1469
    .line 1470
    .line 1471
    .line 1472
    .line 1473
    .line 1474
    .line 1475
    .line 1476
    .line 1477
    .line 1478
    .line 1479
    .line 1480
    .line 1481
    .line 1482
    .line 1483
    .line 1484
    .line 1485
    .line 1486
    .line 1487
    .line 1488
    .line 1489
    .line 1490
    .line 1491
    .line 1492
    .line 1493
    .line 1494
    .line 1495
    .line 1496
    .line 1497
    .line 1498
    .line 1499
    .line 1500
    .line 1501
    .line 1502
    .line 1503
    .line 1504
    .line 1505
    .line 1506
    .line 1507
    .line 1508
    .line 1509
    .line 1510
    .line 1511
    .line 1512
    .line 1513
    .line 1514
    .line 1515
    .line 1516
    .line 1517
    .line 1518
    .line 1519
    .line 1520
    .line 1521
    .line 1522
    .line 1523
    .line 1524
    .line 1525
    .line 1526
    .line 1527
    .line 1528
    .line 1529
    .line 1530
    .line 1531
    .line 1532
    .line 1533
    .line 1534
    .line 1535
    .line 1536
    .line 1537
    .line 1538
    .line 1539
    .line 1540
    .line 1541
    .line 1542
    .line 1543
    .line 1544
    .line 1545
    .line 1546
    .line 1547
    .line 1548
    .line 1549
    .line 1550
    .line 1551
    .line 1552
    .line 1553
    .line 1554
    .line 1555
    .line 1556
    .line 1557
    .line 1558
    .line 1559
    .line 1560
    .line 1561
    .line 1562
    .line 1563
    .line 1564
    .line 1565
    .line 1566
    .line 1567
    .line 1568
    .line 1569
    .line 1570
    .line 1571
    .line 1572
    .line 1573
    .line 1574
    .line 1575
    .line 1576
    .line 1577
    .line 1578
    .line 1579
    .line 1580
    .line 1581
    .line 1582
    .line 1583
    .line 1584
    .line 1585
    .line 1586
    .line 1587
    .line 1588
    .line 1589
    .line 1590
    .line 1591
    .line 1592
    .line 1593
    .line 1594
    .line 1595
    .line 1596
    .line 1597
    .line 1598
    .line 1599
    .line 1600
    .line 1601
    .line 1602
    .line 1603
    .line 1604
    .line 1605
    .line 1606
    .line 1607
    .line 1608
    .line 1609
    .line 1610
    .line 1611
    .line 1612
    .line 1613
    .line 1614
    .line 1615
    .line 1616
    .line 1617
    .line 1618
    .line 1619
    .line 1620
    .line 1621
    .line 1622
    .line 1623
    .line 1624
    .line 1625
    .line 1626
    .line 1627
    .line 1628
    .line 1629
    .line 1630
    .line 1631
    .line 1632
    .line 1633
    .line 1634
    .line 1635
    .line 1636
    .line 1637
    .line 1638
    .line 1639
    .line 1640
    .line 1641
    .line 1642
    .line 1643
    .line 1644
    .line 1645
    .line 1646
    .line 1647
    .line 1648
    .line 1649
    .line 1650
    .line 1651
    .line 1652
    .line 1653
    .line 1654
    .line 1655
    .line 1656
    .line 1657
    .line 1658
    .line 1659
    .line 1660
    .line 1661
    .line 1662
    .line 1663
    .line 1664
    .line 1665
    .line 1666
    .line 1667
    .line 1668
    .line 1669
    .line 1670
    .line 1671
    .line 1672
    .line 1673
    .line 1674
    .line 1675
    .line 1676
    .line 1677
    .line 1678
    .line 1679
    .line 1680
    .line 1681
    .line 1682
    .line 1683
    .line 1684
    .line 1685
    .line 1686
    .line 1687
    .line 1688
    .line 1689
    .line 1690
    .line 1691
    .line 1692
    .line 1693
    .line 1694
    .line 1695
    .line 1696
    .line 1697
    .line 1698
    .line 1699
    .line 1700
    .line 1701
    .line 1702
    .line 1703
    .line 1704
    .line 1705
    .line 1706
    .line 1707
    .line 1708
    .line 1709
    .line 1710
    .line 1711
    .line 1712
    .line 1713
    .line 1714
    .line 1715
    .line 1716
    .line 1717
    .line 1718
    .line 1719
    .line 1720
    .line 1721
    .line 1722
    .line 1723
    .line 1724
    .line 1725
    .line 1726
    .line 1727
    .line 1728
    .line 1729
    .line 1730
    .line 1731
    .line 1732
    .line 1733
    .line 1734
    .line 1735
    .line 1736
    .line 1737
    .line 1738
    .line 1739
    .line 1740
    .line 1741
    .line 1742
    .line 1743
    .line 1744
    .line 1745
    .line 1746
    .line 1747
    .line 1748
    .line 1749
    .line 1750
    .line 1751
    .line 1752
    .line 1753
    .line 1754
    .line 1755
    .line 1756
    .line 1757
    .line 1758
    .line 1759
    .line 1760
    .line 1761
    .line 1762
    .line 1763
    .line 1764
    .line 1765
    .line 1766
    .line 1767
    .line 1768
    .line 1769
    .line 1770
    .line 1771
    .line 1772
    .line 1773
    .line 1774
    .line 1775
    .line 1776
    .line 1777
    .line 1778
    .line 1779
    .line 1780
    .line 1781
    .line 1782
    .line 1783
    .line 1784
    .line 1785
    .line 1786
    .line 1787
    .line 1788
    .line 1789
    .line 1790
    .line 1791
    .line 1792
    .line 1793
    .line 1794
    .line 1795
    .line 1796
    .line 1797
    .line 1798
    .line 1799
    .line 1800
    .line 1801
    .line 1802
    .line 1803
    .line 1804
    .line 1805
    .line 1806
    .line 1807
    .line 1808
    .line 1809
    .line 1810
    .line 1811
    .line 1812
    .line 1813
    .line 1814
    .line 1815
    .line 1816
    .line 1817
    .line 1818
    .line 1819
    .line 1820
    .line 1821
    .line 1822
    .line 1823
    .line 1824
    .line 1825
    .line 1826
    .line 1827
    .line 1828
    .line 1829
    .line 1830
    .line 1831
    .line 1832
    .line 1833
    .line 1834
    .line 1835
    .line 1836
    .line 1837
    .line 1838
    .line 1839
    .line 1840
    .line 1841
    .line 1842
    .line 1843
    .line 1844
    .line 1845
    .line 1846
    .line 1847
    .line 1848
    .line 1849
    .line 1850
    .line 1851
    .line 1852
    .line 1853
    .line 1854
    .line 1855
    .line 1856
    .line 1857
    .line 1858
    .line 1859
    .line 1860
    .line 1861
    .line 1862
    .line 1863
    .line 1864
    .line 1865
    .line 1866
    .line 1867
    .line 1868
    .line 1869
    .line 1870
    .line 1871
    .line 1872
    .line 1873
    .line 1874
    .line 1875
    .line 1876
    .line 1877
    .line 1878
    .line 1879
    .line 1880
    .line 1881
    .line 1882
    .line 1883
    .line 1884
    .line 1885
    .line 1886
    .line 1887
    .line 1888
    .line 1889
    .line 1890
    .line 1891
    .line 1892
    .line 1893
    .line 1894
    .line 1895
    .line 1896
    .line 1897
    .line 1898
    .line 1899
    .line 1900
    .line 1901
    .line 1902
    .line 1903
    .line 1904
    .line 1905
    .line 1906
    .line 1907
    .line 1908
    .line 1909
    .line 1910
    .line 1911
    .line 1912
    .line 1913
    .line 1914
    .line 1915
    .line 1916
    .line 1917
    .line 1918
    .line 1919
    .line 1920
    .line 1921
    .line 1922
    .line 1923
    .line 1924
    .line 1925
    .line 1926
    .line 1927
    .line 1928
    .line 1929
    .line 1930
    .line 1931
    .line 1932
    .line 1933
    .line 1934
    .line 1935
    .line 1936
    .line 1937
    .line 1938
    .line 1939
    .line 1940
    .line 1941
    .line 1942
    .line 1943
    .line 1944
    .line 1945
    .line 1946
    .line 1947
    .line 1948
    .line 1949
    .line 1950
    .line 1951
    .line 1952
    .line 1953
    .line 1954
    .line 1955
    .line 1956
    .line 1957
    .line 1958
    .line 1959
    .line 1960
    .line 1961
    .line 1962
    .line 1963
    .line 1964
    .line 1965
    .line 1966
    .line 1967
    .line 1968
    .line 1969
    .line 1970
    .line 1971
    .line 1972
    .line 1973
    .line 1974
    .line 1975
    .line 1976
    .line 1977
    .line 1978
    .line 1979
    .line 1980
    .line 1981
    .line 1982
    .line 1983
    .line 1984
    .line 1985
    .line 1986
    .line 1987
    .line 1988
    .line 1989
    .line 1990
    .line 1991
    .line 1992
    .line 1993
    .line 1994
    .line 1995
    .line 1996
    .line 1997
    .line 1998
    .line 1999
    .line 2000
    .line 2001
    .line 2002
    .line 2003
    .line 2004
    .line 2005
    .line 2006
    .line 2007
    .line 2008
    .line 2009
    .line 2010
    .line 2011
    .line 2012
    .line 2013
    .line 2014
    .line 2015
    .line 2016
    .line 2017
    .line 2018
    .line 2019
    .line 2020
    .line 2021
    .line 2022
    .line 2023
    .line 2024
    .line 2025
    .line 2026
    .line 2027
    .line 2028
    .line 2029
    .line 2030
    .line 2031
    .line 2032
    .line 2033
    .line 2034
    .line 2035
    .line 2036
    .line 2037
    .line 2038
    .line 2039
    .line 2040
    .line 2041
    .line 2042
    .line 2043
    .line 2044
    .line 2045
    .line 2046
    .line 2047
    .line 2048
    .line 2049
    .line 2050
    .line 2051
    .line 2052
    .line 2053
    .line 2054
    .line 2055
    .line 2056
    .line 2057
    .line 2058
    .line 2059
    .line 2060
    .line 2061
    .line 2062
    .line 2063
    .line 2064
    .line 2065
    .line 2066
    .line 2067
    .line 2068
    .line 2069
    .line 2070
    .line 2071
    .line 2072
    .line 2073
    .line 2074
    .line 2075
    .line 2076
    .line 2077
    .line 2078
    .line 2079
    .line 2080
    .line 2081
    .line 2082
    .line 2083
    .line 2084
    .line 2085
    .line 2086
    .line 2087
    .line 2088
    .line 2089
    .line 2090
    .line 2091
    .line 2092
    .line 2093
    .line 2094
    .line 2095
    .line 2096
    .line 2097
    .line 2098
    .line 2099
    .line 2100
    .line 2101
    .line 2102
    .line 2103
    .line 2104
    .line 2105
    .line 2106
    .line 2107
    .line 2108
    .line 2109
    .line 2110
    .line 2111
    .line 2112
    .line 2113
    .line 2114
    .line 2115
    .line 2116
    .line 2117
    .line 2118
    .line 2119
    .line 2120
    .line 2121
    .line 2122
    .line 2123
    .line 2124
    .line 2125
    .line 2126
    .line 2127
    .line 2128
    .line 2129
    .line 2130
    .line 2131
    .line 2132
    .line 2133
    .line 2134
    .line 2135
    .line 2136
    .line 2137
    .line 2138
    .line 2139
    .line 2140
    .line 2141
    .line 2142
    .line 2143
    .line 2144
    .line 2145
    .line 2146
    .line 2147
    .line 2148
    .line 2149
    .line 2150
    .line 2151
    .line 2152
    .line 2153
    .line 2154
    .line 2155
    .line 2156
    .line 2157
    .line 2158
    .line 2159
    .line 2160
    .line 2161
    .line 2162
    .line 2163
    .line 2164
    .line 2165
    .line 2166
    .line 2167
    .line 2168
    .line 2169
    .line 2170
    .line 2171
    .line 2172
    .line 2173
    .line 2174
    .line 2175
    .line 2176
    .line 2177
    .line 2178
    .line 2179
    .line 2180
    .line 2181
    .line 2182
    .line 2183
    .line 2184
    .line 2185
    .line 2186
    .line 2187
    .line 2188
    .line 2189
    .line 2190
    .line 2191
    .line 2192
    .line 2193
    .line 2194
    .line 2195
    .line 2196
    .line 2197
    .line 2198
    .line 2199
    .line 2200
    .line 2201
    .line 2202
    .line 2203
    .line 2204
    .line 2205
    .line 2206
    .line 2207
    .line 2208
    .line 2209
    .line 2210
    .line 2211
    .line 2212
    .line 2213
    .line 2214
    .line 2215
    .line 2216
    .line 2217
    .line 2218
    .line 2219
    .line 2220
    .line 2221
    .line 2222
    .line 2223
    .line 2224
    .line 2225
    .line 2226
    .line 2227
    .line 2228
    .line 2229
    .line 2230
    .line 2231
    .line 2232
    .line 2233
    .line 2234
    .line 2235
    .line 2236
    .line 2237
    .line 2238
    .line 2239
    .line 2240
    .line 2241
    .line 2242
    .line 2243
    .line 2244
    .line 2245
    .line 2246
    .line 2247
    .line 2248
    .line 2249
    .line 2250
    .line 2251
    .line 2252
    .line 2253
    .line 2254
    .line 2255
    .line 2256
    .line 2257
    .line 2258
    .line 2259
    .line 2260
    .line 2261
    .line 2262
    .line 2263
    .line 2264
    .line 2265
    .line 2266
    .line 2267
    .line 2268
    .line 2269
    .line 2270
    .line 2271
    .line 2272
    .line 2273
    .line 2274
    .line 2275
    .line 2276
    .line 2277
    .line 2278
    .line 2279
    .line 2280
    .line 2281
    .line 2282
    .line 2283
    .line 2284
    .line 2285
    .line 2286
    .line 2287
    .line 2288
    .line 2289
    .line 2290
    .line 2291
    .line 2292
    .line 2293
    .line 2294
    .line 2295
    .line 2296
    .line 2297
    .line 2298
    .line 2299
    .line 2300
    .line 2301
    .line 2302
    .line 2303
    .line 2304
    .line 2305
    .line 2306
    .line 2307
    .line 2308
    .line 2309
    .line 2310
    .line 2311
    .line 2312
    .line 2313
    .line 2314
    .line 2315
    .line 2316
    .line 2317
    .line 2318
    .line 2319
    .line 2320
    .line 2321
    .line 2322
    .line 2323
    .line 2324
    .line 2325
    .line 2326
    .line 2327
    .line 2328
    .line 2329
    .line 2330
    .line 2331
    .line 2332
    .line 2333
    .line 2334
    .line 2335
    .line 2336
    .line 2337
    .line 2338
    .line 2339
    .line 2340
    .line 2341
    .line 2342
    .line 2343
    .line 2344
    .line 2345
    .line 2346
    .line 2347
    .line 2348
    .line 2349
    .line 2350
    .line 2351
    .line 2352
    .line 2353
    .line 2354
    .line 2355
    .line 2356
    .line 2357
    .line 2358
    .line 2359
    .line 2360
    .line 2361
    .line 2362
    .line 2363
    .line 2364
    .line 2365
    .line 2366
    .line 2367
    .line 2368
    .line 2369
    .line 2370
    .line 2371
    .line 2372
    .line 2373
    .line 2374
    .line 2375
    .line 2376
    .line 2377
    .line 2378
    .line 2379
    .line 2380
    .line 2381
    .line 2382
    .line 2383
    .line 2384
    .line 2385
    .line 2386
    .line 2387
    .line 2388
    .line 2389
    .line 2390
    .line 2391
    .line 2392
    .line 2393
    .line 2394
    .line 2395
    .line 2396
    .line 2397
    .line 2398
    .line 2399
    .line 2400
    .line 2401
    .line 2402
    .line 2403
    .line 2404
    .line 2405
    .line 2406
    .line 2407
    .line 2408
    .line 2409
    .line 2410
    .line 2411
    .line 2412
    .line 2413
    .line 2414
    .line 2415
    .line 2416
    .line 2417
    .line 2418
    .line 2419
    .line 2420
    .line 2421
    .line 2422
    .line 2423
    .line 2424
    .line 2425
    .line 2426
    .line 2427
    .line 2428
    .line 2429
    .line 2430
    .line 2431
    .line 2432
    .line 2433
    .line 2434
    .line 2435
    .line 2436
    .line 2437
    .line 2438
    .line 2439
    .line 2440
    .line 2441
    .line 2442
    .line 2443
    .line 2444
    .line 2445
    .line 2446
    .line 2447
    .line 2448
    .line 2449
    .line 2450
    .line 2451
    .line 2452
    .line 2453
    .line 2454
    .line 2455
    .line 2456
    .line 2457
    .line 2458
    .line 2459
    .line 2460
    .line 2461
    .line 2462
    .line 2463
    .line 2464
    .line 2465
    .line 2466
    .line 2467
    .line 2468
    .line 2469
    .line 2470
    .line 2471
    .line 2472
    .line 2473
    .line 2474
    .line 2475
    .line 2476
    .line 2477
    .line 2478
    .line 2479
    .line 2480
    .line 2481
    .line 2482
    .line 2483
    .line 2484
    .line 2485
    .line 2486
    .line 2487
    .line 2488
    .line 2489
    .line 2490
    .line 2491
    .line 2492
    .line 2493
    .line 2494
    .line 2495
    .line 2496
    .line 2497
    .line 2498
    .line 2499
    .line 2500
    .line 2501
    .line 2502
    .line 2503
    .line 2504
    .line 2505
    .line 2506
    .line 2507
    .line 2508
    .line 2509
    .line 2510
    .line 2511
    .line 2512
    .line 2513
    .line 2514
    .line 2515
    .line 2516
    .line 2517
    .line 2518
    .line 2519
    .line 2520
    .line 2521
    .line 2522
    .line 2523
    .line 2524
    .line 2525
    .line 2526
    .line 2527
    .line 2528
    .line 2529
    .line 2530
    .line 2531
    .line 2532
    .line 2533
    .line 2534
    .line 2535
    .line 2536
    .line 2537
    .line 2538
    .line 2539
    .line 2540
    .line 2541
    .line 2542
    .line 2543
    .line 2544
    .line 2545
    .line 2546
    .line 2547
    .line 2548
    .line 2549
    .line 2550
    .line 2551
    .line 2552
    .line 2553
    .line 2554
    .line 2555
    .line 2556
    .line 2557
    .line 2558
    .line 2559
    .line 2560
    .line 2561
    .line 2562
    .line 2563
    .line 2564
    .line 2565
    .line 2566
    .line 2567
    .line 2568
    .line 2569
    .line 2570
    .line 2571
    .line 2572
    .line 2573
    .line 2574
    .line 2575
    .line 2576
    .line 2577
    .line 2578
    .line 2579
    .line 2580
    .line 2581
    .line 2582
    .line 2583
    .line 2584
    .line 2585
    .line 2586
    .line 2587
    .line 2588
    .line 2589
    .line 2590
    .line 2591
    .line 2592
    .line 2593
    .line 2594
    .line 2595
    .line 2596
    .line 2597
    .line 2598
    .line 2599
    .line 2600
    .line 2601
    .line 2602
    .line 2603
    .line 2604
    .line 2605
    .line 2606
    .line 2607
    .line 2608
    .line 2609
    .line 2610
    .line 2611
    .line 2612
    .line 2613
    .line 2614
    .line 2615
    .line 2616
    .line 2617
    .line 2618
    .line 2619
    .line 2620
    .line 2621
    .line 2622
    .line 2623
    .line 2624
    .line 2625
    .line 2626
    .line 2627
    .line 2628
    .line 2629
    .line 2630
    .line 2631
    .line 2632
    .line 2633
    .line 2634
    .line 2635
    .line 2636
    .line 2637
    .line 2638
    .line 2639
    .line 2640
    .line 2641
    .line 2642
    .line 2643
    .line 2644
    .line 2645
    .line 2646
    .line 2647
    .line 2648
    .line 2649
    .line 2650
    .line 2651
    .line 2652
    .line 2653
    .line 2654
    .line 2655
    .line 2656
    .line 2657
    .line 2658
    .line 2659
    .line 2660
    .line 2661
    .line 2662
    .line 2663
    .line 2664
    .line 2665
    .line 2666
    .line 2667
    .line 2668
    .line 2669
    .line 2670
    .line 2671
    .line 2672
    .line 2673
    .line 2674
    .line 2675
    .line 2676
    .line 2677
    .line 2678
    .line 2679
    .line 2680
    .line 2681
    .line 2682
    .line 2683
    .line 2684
    .line 2685
    .line 2686
    .line 2687
    .line 2688
    .line 2689
    .line 2690
    .line 2691
    .line 2692
    .line 2693
    .line 2694
    .line 2695
    .line 2696
    .line 2697
    .line 2698
    .line 2699
    .line 2700
    .line 2701
    .line 2702
    .line 2703
    .line 2704
    .line 2705
    .line 2706
    .line 2707
    .line 2708
    .line 2709
    .line 2710
    .line 2711
    .line 2712
    .line 2713
    .line 2714
    .line 2715
    .line 2716
    .line 2717
    .line 2718
    .line 2719
    .line 2720
    .line 2721
    .line 2722
    .line 2723
    .line 2724
    .line 2725
    .line 2726
    .line 2727
    .line 2728
    .line 2729
    .line 2730
    .line 2731
    .line 2732
    .line 2733
    .line 2734
    .line 2735
    .line 2736
    .line 2737
    .line 2738
    .line 2739
    .line 2740
    .line 2741
    .line 2742
    .line 2743
    .line 2744
    .line 2745
    .line 2746
    .line 2747
    .line 2748
    .line 2749
    .line 2750
    .line 2751
    .line 2752
    .line 2753
    .line 2754
    .line 2755
    .line 2756
    .line 2757
    .line 2758
    .line 2759
    .line 2760
    .line 2761
    .line 2762
    .line 2763
    .line 2764
    .line 2765
    .line 2766
    .line 2767
    .line 2768
    .line 2769
    .line 2770
    .line 2771
    .line 2772
    .line 2773
    .line 2774
    .line 2775
    .line 2776
    .line 2777
    .line 2778
    .line 2779
    .line 2780
    .line 2781
    .line 2782
    .line 2783
    .line 2784
    .line 2785
    .line 2786
    .line 2787
    .line 2788
    .line 2789
    .line 2790
    .line 2791
    .line 2792
    .line 2793
    .line 2794
    .line 2795
    .line 2796
    .line 2797
    .line 2798
    .line 2799
    .line 2800
    .line 2801
    .line 2802
    .line 2803
    .line 2804
    .line 2805
    .line 2806
    .line 2807
    .line 2808
    .line 2809
    .line 2810
    .line 2811
    .line 2812
    .line 2813
    .line 2814
    .line 2815
    .line 2816
    .line 2817
    .line 2818
    .line 2819
    .line 2820
    .line 2821
    .line 2822
    .line 2823
    .line 2824
    .line 2825
    .line 2826
    .line 2827
    .line 2828
    .line 2829
    .line 2830
    .line 2831
    .line 2832
    .line 2833
    .line 2834
    .line 2835
    .line 2836
    .line 2837
    .line 2838
    .line 2839
    .line 2840
    .line 2841
    .line 2842
    .line 2843
    .line 2844
    .line 2845
    .line 2846
    .line 2847
    .line 2848
    .line 2849
    .line 2850
    .line 2851
    .line 2852
.end method

.method public onCreateMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1

    .line 1
    const v0, 0x7f0f0008

    .line 2
    .line 3
    .line 4
    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 5
    .line 6
    .line 7
    const p2, 0x7f0a02be

    .line 8
    .line 9
    .line 10
    invoke-interface {p1, p2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 11
    .line 12
    .line 13
    move-result-object p2

    .line 14
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSave:Landroid/view/MenuItem;

    .line 15
    .line 16
    const p2, 0x7f0a014a

    .line 17
    .line 18
    .line 19
    invoke-interface {p1, p2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 20
    .line 21
    .line 22
    move-result-object p2

    .line 23
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mMenuFilter:Landroid/view/MenuItem;

    .line 24
    .line 25
    const p2, 0x7f0a02ca

    .line 26
    .line 27
    .line 28
    invoke-interface {p1, p2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    .line 29
    .line 30
    .line 31
    move-result-object p1

    .line 32
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mMenuItemSearch:Landroid/view/MenuItem;

    .line 33
    .line 34
    invoke-interface {p1}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    .line 35
    .line 36
    .line 37
    move-result-object p1

    .line 38
    check-cast p1, Landroidx/appcompat/widget/SearchView;

    .line 39
    .line 40
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 41
    .line 42
    invoke-virtual {p1, p0}, Landroidx/appcompat/widget/SearchView;->setOnQueryTextListener(Landroidx/appcompat/widget/SearchView$OnQueryTextListener;)V

    .line 43
    .line 44
    .line 45
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mQueryToApply:Ljava/lang/String;

    .line 46
    .line 47
    if-eqz p1, :cond_0

    .line 48
    .line 49
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 50
    .line 51
    .line 52
    move-result p1

    .line 53
    if-nez p1, :cond_0

    .line 54
    .line 55
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mQueryToApply:Ljava/lang/String;

    .line 56
    .line 57
    const/4 p2, 0x0

    .line 58
    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mQueryToApply:Ljava/lang/String;

    .line 59
    .line 60
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->setQuery(Ljava/lang/String;)V

    .line 61
    .line 62
    .line 63
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshMenuIcons()V

    .line 64
    .line 65
    .line 66
    return-void
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

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getParentFragment()Landroidx/fragment/app/Fragment;

    .line 2
    .line 3
    .line 4
    move-result-object p3

    .line 5
    instance-of p3, p3, Lcom/emanuelef/remote_capture/fragments/DataViewContainerFragment;

    .line 6
    .line 7
    if-nez p3, :cond_0

    .line 8
    .line 9
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 10
    .line 11
    .line 12
    move-result-object p3

    .line 13
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    sget-object v1, Landroidx/lifecycle/Lifecycle$State;->RESUMED:Landroidx/lifecycle/Lifecycle$State;

    .line 18
    .line 19
    invoke-virtual {p3, p0, v0, v1}, Landroidx/activity/ComponentActivity;->addMenuProvider(Landroidx/core/view/MenuProvider;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;)V

    .line 20
    .line 21
    .line 22
    :cond_0
    const p3, 0x7f0d002f

    .line 23
    .line 24
    .line 25
    const/4 v0, 0x0

    .line 26
    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 27
    .line 28
    .line 29
    move-result-object p1

    .line 30
    return-object p1
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
.end method

.method public onDestroyView()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAlertDialog:Landroidx/appcompat/app/AlertDialog;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroidx/appcompat/app/AlertDialog;->dismiss()V

    .line 6
    .line 7
    .line 8
    :cond_0
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onDestroyView()V

    .line 9
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

.method public onHiddenChanged(Z)V
    .locals 1

    .line 1
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onHiddenChanged(Z)V

    .line 2
    .line 3
    .line 4
    if-eqz p1, :cond_1

    .line 5
    .line 6
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActionMode:Landroidx/appcompat/view/ActionMode;

    .line 7
    .line 8
    if-eqz p1, :cond_0

    .line 9
    .line 10
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 11
    .line 12
    .line 13
    :cond_0
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->clearFilters()V

    .line 14
    .line 15
    .line 16
    return-void

    .line 17
    :cond_1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 18
    .line 19
    if-eqz p1, :cond_2

    .line 20
    .line 21
    const/4 v0, 0x0

    .line 22
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V

    .line 23
    .line 24
    .line 25
    :cond_2
    return-void
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

.method public bridge synthetic onMenuClosed(Landroid/view/Menu;)V
    .locals 0

    .line 1
    return-void
.end method

.method public onMenuItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .line 1
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    const v0, 0x7f0a02be

    .line 6
    .line 7
    .line 8
    const/4 v1, 0x1

    .line 9
    if-ne p1, v0, :cond_0

    .line 10
    .line 11
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->openFileSelector()V

    .line 12
    .line 13
    .line 14
    return v1

    .line 15
    :cond_0
    const v0, 0x7f0a014a

    .line 16
    .line 17
    .line 18
    if-ne p1, v0, :cond_1

    .line 19
    .line 20
    new-instance p1, Landroid/content/Intent;

    .line 21
    .line 22
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    const-class v2, Lcom/emanuelef/remote_capture/activities/EditFilterActivity;

    .line 27
    .line 28
    invoke-direct {p1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 29
    .line 30
    .line 31
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 32
    .line 33
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 34
    .line 35
    const-string v2, "filter"

    .line 36
    .line 37
    invoke-virtual {p1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 38
    .line 39
    .line 40
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->filterLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 41
    .line 42
    invoke-virtual {v0, p1}, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V

    .line 43
    .line 44
    .line 45
    return v1

    .line 46
    :cond_1
    const/4 p1, 0x0

    .line 47
    return p1
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

.method public onPause()V
    .locals 2

    .line 1
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onPause()V

    .line 2
    .line 3
    .line 4
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->unregisterConnsListener()V

    .line 5
    .line 6
    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 8
    .line 9
    const/4 v1, 0x0

    .line 10
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;->setEmptyView(Landroid/view/View;)V

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 14
    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    invoke-virtual {v0}, Landroidx/appcompat/widget/SearchView;->getQuery()Ljava/lang/CharSequence;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mQueryToApply:Ljava/lang/String;

    .line 26
    .line 27
    :cond_0
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

.method public bridge synthetic onPrepareMenu(Landroid/view/Menu;)V
    .locals 0

    .line 1
    return-void
.end method

.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->setSearch(Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->recheckScroll()V

    .line 7
    .line 8
    .line 9
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshEmptyText()V

    .line 10
    .line 11
    .line 12
    const/4 p1, 0x1

    .line 13
    return p1
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

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 0

    const/4 p1, 0x1

    return p1
.end method

.method public onResume()V
    .locals 6

    .line 1
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 2
    .line 3
    .line 4
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshEmptyText()V

    .line 5
    .line 6
    .line 7
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->registerConnsListener()V

    .line 8
    .line 9
    .line 10
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 11
    .line 12
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mEmptyText:Landroid/widget/TextView;

    .line 13
    .line 14
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;->setEmptyView(Landroid/view/View;)V

    .line 15
    .line 16
    .line 17
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshMenuIcons()V

    .line 18
    .line 19
    .line 20
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 21
    .line 22
    if-eqz v0, :cond_3

    .line 23
    .line 24
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 25
    .line 26
    iget-wide v0, v0, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->minSize:J

    .line 27
    .line 28
    const-wide/16 v2, 0x400

    .line 29
    .line 30
    const/4 v4, 0x0

    .line 31
    cmp-long v5, v0, v2

    .line 32
    .line 33
    if-ltz v5, :cond_0

    .line 34
    .line 35
    const/4 v0, 0x1

    .line 36
    goto :goto_0

    .line 37
    :cond_0
    const/4 v0, 0x0

    .line 38
    :goto_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 39
    .line 40
    if-eqz v0, :cond_1

    .line 41
    .line 42
    goto :goto_1

    .line 43
    :cond_1
    const/16 v4, 0x8

    .line 44
    .line 45
    :goto_1
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 46
    .line 47
    .line 48
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 49
    .line 50
    if-eqz v0, :cond_2

    .line 51
    .line 52
    const/4 v0, 0x3

    .line 53
    goto :goto_2

    .line 54
    :cond_2
    const/4 v0, 0x2

    .line 55
    :goto_2
    invoke-virtual {v1, v0}, Lcom/google/android/material/slider/Slider;->setLabelBehavior(I)V

    .line 56
    .line 57
    .line 58
    :cond_3
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .line 1
    invoke-super {p0, p1}, Landroidx/fragment/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSearchView:Landroidx/appcompat/widget/SearchView;

    .line 5
    .line 6
    if-eqz v0, :cond_0

    .line 7
    .line 8
    invoke-virtual {v0}, Landroidx/appcompat/widget/SearchView;->getQuery()Ljava/lang/CharSequence;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    const-string v1, "search"

    .line 17
    .line 18
    invoke-virtual {p1, v1, v0}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    .line 20
    .line 21
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 22
    .line 23
    if-eqz v0, :cond_1

    .line 24
    .line 25
    const-string v1, "filter_desc"

    .line 26
    .line 27
    iget-object v0, v0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 28
    .line 29
    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 30
    .line 31
    .line 32
    :cond_1
    return-void
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

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 5

    .line 1
    new-instance v0, Landroid/os/Handler;

    .line 2
    .line 3
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 8
    .line 9
    .line 10
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mHandler:Landroid/os/Handler;

    .line 11
    .line 12
    const v0, 0x7f0a015e

    .line 13
    .line 14
    .line 15
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    check-cast v0, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 20
    .line 21
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 22
    .line 23
    const v0, 0x7f0a00d0

    .line 24
    .line 25
    .line 26
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    check-cast v0, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 31
    .line 32
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 33
    .line 34
    const v0, 0x7f0a0250

    .line 35
    .line 36
    .line 37
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 38
    .line 39
    .line 40
    move-result-object v0

    .line 41
    check-cast v0, Landroid/widget/TextView;

    .line 42
    .line 43
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mOldConnectionsText:Landroid/widget/TextView;

    .line 44
    .line 45
    new-instance v0, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView$MyLinearLayoutManager;

    .line 46
    .line 47
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 48
    .line 49
    .line 50
    move-result-object v1

    .line 51
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView$MyLinearLayoutManager;-><init>(Landroid/content/Context;)V

    .line 52
    .line 53
    .line 54
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 55
    .line 56
    invoke-virtual {v1, v0}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 57
    .line 58
    .line 59
    new-instance v1, Lcom/emanuelef/remote_capture/AppsResolver;

    .line 60
    .line 61
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 62
    .line 63
    .line 64
    move-result-object v2

    .line 65
    invoke-direct {v1, v2}, Lcom/emanuelef/remote_capture/AppsResolver;-><init>(Landroid/content/Context;)V

    .line 66
    .line 67
    .line 68
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 69
    .line 70
    const v1, 0x7f0a0240

    .line 71
    .line 72
    .line 73
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 74
    .line 75
    .line 76
    move-result-object v1

    .line 77
    check-cast v1, Landroid/widget/TextView;

    .line 78
    .line 79
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mEmptyText:Landroid/widget/TextView;

    .line 80
    .line 81
    const v1, 0x7f0a02f1

    .line 82
    .line 83
    .line 84
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 85
    .line 86
    .line 87
    move-result-object v1

    .line 88
    check-cast v1, Lcom/google/android/material/slider/Slider;

    .line 89
    .line 90
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 91
    .line 92
    new-instance v2, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;

    .line 93
    .line 94
    const/4 v3, 0x6

    .line 95
    invoke-direct {v2, v3}, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;-><init>(I)V

    .line 96
    .line 97
    .line 98
    invoke-virtual {v1, v2}, Lcom/google/android/material/slider/Slider;->setLabelFormatter(Lcom/google/android/material/slider/LabelFormatter;)V

    .line 99
    .line 100
    .line 101
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 102
    .line 103
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;

    .line 104
    .line 105
    const/4 v3, 0x1

    .line 106
    invoke-direct {v2, p0, v3}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$$ExternalSyntheticLambda14;-><init>(Landroidx/fragment/app/Fragment;I)V

    .line 107
    .line 108
    .line 109
    iget-object v1, v1, Lcom/google/android/material/slider/BaseSlider;->changeListeners:Ljava/util/ArrayList;

    .line 110
    .line 111
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 112
    .line 113
    .line 114
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mSizeSlider:Lcom/google/android/material/slider/Slider;

    .line 115
    .line 116
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;

    .line 117
    .line 118
    invoke-direct {v2, p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V

    .line 119
    .line 120
    .line 121
    iget-object v1, v1, Lcom/google/android/material/slider/BaseSlider;->touchListeners:Ljava/util/ArrayList;

    .line 122
    .line 123
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 124
    .line 125
    .line 126
    const v1, 0x7f0a0054

    .line 127
    .line 128
    .line 129
    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 130
    .line 131
    .line 132
    move-result-object v1

    .line 133
    check-cast v1, Lcom/google/android/material/chip/ChipGroup;

    .line 134
    .line 135
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mActiveFilter:Lcom/google/android/material/chip/ChipGroup;

    .line 136
    .line 137
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;

    .line 138
    .line 139
    invoke-direct {v2, p0, v3}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V

    .line 140
    .line 141
    .line 142
    invoke-virtual {v1, v2}, Lcom/google/android/material/chip/ChipGroup;->setOnCheckedStateChangeListener(Lcom/google/android/material/chip/ChipGroup$OnCheckedStateChangeListener;)V

    .line 143
    .line 144
    .line 145
    new-instance v1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 146
    .line 147
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 148
    .line 149
    .line 150
    move-result-object v2

    .line 151
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 152
    .line 153
    invoke-direct {v1, v2, v4}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;-><init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/AppsResolver;)V

    .line 154
    .line 155
    .line 156
    iput-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 157
    .line 158
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 159
    .line 160
    invoke-virtual {v2, v1}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 161
    .line 162
    .line 163
    const/4 v1, 0x0

    .line 164
    iput-boolean v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->listenerSet:Z

    .line 165
    .line 166
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 167
    .line 168
    invoke-virtual {p0, v2}, Landroidx/fragment/app/Fragment;->registerForContextMenu(Landroid/view/View;)V

    .line 169
    .line 170
    .line 171
    new-instance v2, Landroidx/recyclerview/widget/DividerItemDecoration;

    .line 172
    .line 173
    iget-object v4, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 174
    .line 175
    invoke-virtual {v4}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 176
    .line 177
    .line 178
    move-result-object v4

    .line 179
    invoke-virtual {v0}, Landroidx/recyclerview/widget/LinearLayoutManager;->getOrientation()I

    .line 180
    .line 181
    .line 182
    move-result v0

    .line 183
    invoke-direct {v2, v4, v0}, Landroidx/recyclerview/widget/DividerItemDecoration;-><init>(Landroid/content/Context;I)V

    .line 184
    .line 185
    .line 186
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 187
    .line 188
    invoke-virtual {v0, v2}, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V

    .line 189
    .line 190
    .line 191
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 192
    .line 193
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;

    .line 194
    .line 195
    invoke-direct {v2, p0, v1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V

    .line 196
    .line 197
    .line 198
    invoke-virtual {v0, v2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->setClickListener(Landroid/view/View$OnClickListener;)V

    .line 199
    .line 200
    .line 201
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 202
    .line 203
    new-instance v2, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;

    .line 204
    .line 205
    invoke-direct {v2, v3, p0}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 206
    .line 207
    .line 208
    invoke-virtual {v0, v2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->setSelectionLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 209
    .line 210
    .line 211
    iput-boolean v3, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->autoScroll:Z

    .line 212
    .line 213
    invoke-direct {p0, v1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->showFabDown(Z)V

    .line 214
    .line 215
    .line 216
    const v0, 0x7f0a01d2

    .line 217
    .line 218
    .line 219
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 220
    .line 221
    .line 222
    move-result-object p1

    .line 223
    new-instance v0, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;

    .line 224
    .line 225
    const/4 v2, 0x7

    .line 226
    invoke-direct {v0, v2}, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;-><init>(I)V

    .line 227
    .line 228
    .line 229
    sget-object v2, Landroidx/core/view/ViewCompat;->sViewPropertyAnimatorMap:Ljava/util/WeakHashMap;

    .line 230
    .line 231
    invoke-static {p1, v0}, Landroidx/core/view/ViewCompat$Api21Impl;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    .line 232
    .line 233
    .line 234
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 235
    .line 236
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;

    .line 237
    .line 238
    invoke-direct {v0, p0, v3}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda16;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V

    .line 239
    .line 240
    .line 241
    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 242
    .line 243
    .line 244
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mFabDown:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 245
    .line 246
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;

    .line 247
    .line 248
    const/4 v2, 0x2

    .line 249
    invoke-direct {v0, p0, v2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;I)V

    .line 250
    .line 251
    .line 252
    invoke-static {p1, v0}, Landroidx/core/view/ViewCompat$Api21Impl;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    .line 253
    .line 254
    .line 255
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mRecyclerView:Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;

    .line 256
    .line 257
    new-instance v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$2;

    .line 258
    .line 259
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$2;-><init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V

    .line 260
    .line 261
    .line 262
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V

    .line 263
    .line 264
    .line 265
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshMenuIcons()V

    .line 266
    .line 267
    .line 268
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 269
    .line 270
    .line 271
    move-result-object p1

    .line 272
    invoke-virtual {p1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    .line 273
    .line 274
    .line 275
    move-result-object p1

    .line 276
    const-class v0, Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 277
    .line 278
    if-eqz p1, :cond_3

    .line 279
    .line 280
    const-string v2, "filter"

    .line 281
    .line 282
    invoke-static {p1, v2, v0}, Lcom/emanuelef/remote_capture/Utils;->getSerializableExtra(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Class;)Ljava/io/Serializable;

    .line 283
    .line 284
    .line 285
    move-result-object v2

    .line 286
    check-cast v2, Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 287
    .line 288
    if-eqz v2, :cond_1

    .line 289
    .line 290
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 291
    .line 292
    iput-object v2, v1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 293
    .line 294
    iget-boolean v1, v2, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->onlyBlacklisted:Z

    .line 295
    .line 296
    if-eqz v1, :cond_0

    .line 297
    .line 298
    sget-boolean v1, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->maliciousWarningShown:Z

    .line 299
    .line 300
    if-nez v1, :cond_0

    .line 301
    .line 302
    new-instance v1, Lcom/android/billingclient/api/zzbv;

    .line 303
    .line 304
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 305
    .line 306
    .line 307
    move-result-object v2

    .line 308
    invoke-direct {v1, v2}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 309
    .line 310
    .line 311
    const v2, 0x7f140181

    .line 312
    .line 313
    .line 314
    invoke-virtual {v1, v2}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 315
    .line 316
    .line 317
    const v2, 0x7f140182

    .line 318
    .line 319
    .line 320
    invoke-virtual {v1, v2}, Lcom/android/billingclient/api/zzbv;->setMessage(I)V

    .line 321
    .line 322
    .line 323
    new-instance v2, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;

    .line 324
    .line 325
    const/16 v4, 0x10

    .line 326
    .line 327
    invoke-direct {v2, v4}, Lcom/emanuelef/remote_capture/model/Blocklist$$ExternalSyntheticLambda0;-><init>(I)V

    .line 328
    .line 329
    .line 330
    const v4, 0x7f14021c

    .line 331
    .line 332
    .line 333
    invoke-virtual {v1, v4, v2}, Lcom/android/billingclient/api/zzbv;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 334
    .line 335
    .line 336
    invoke-virtual {v1}, Lcom/android/billingclient/api/zzbv;->show()Landroidx/appcompat/app/AlertDialog;

    .line 337
    .line 338
    .line 339
    sput-boolean v3, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->maliciousWarningShown:Z

    .line 340
    .line 341
    :cond_0
    const/4 v1, 0x1

    .line 342
    :cond_1
    const-string v2, "query"

    .line 343
    .line 344
    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 345
    .line 346
    .line 347
    move-result-object p1

    .line 348
    if-eqz p1, :cond_2

    .line 349
    .line 350
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 351
    .line 352
    .line 353
    move-result v2

    .line 354
    if-nez v2, :cond_2

    .line 355
    .line 356
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 357
    .line 358
    iget-object v1, v1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 359
    .line 360
    iput-boolean v3, v1, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->showMasked:Z

    .line 361
    .line 362
    goto :goto_0

    .line 363
    :cond_2
    move v3, v1

    .line 364
    goto :goto_0

    .line 365
    :cond_3
    const-string p1, ""

    .line 366
    .line 367
    const/4 v3, 0x0

    .line 368
    :goto_0
    if-eqz p2, :cond_6

    .line 369
    .line 370
    if-eqz p1, :cond_4

    .line 371
    .line 372
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 373
    .line 374
    .line 375
    move-result v1

    .line 376
    if-eqz v1, :cond_5

    .line 377
    .line 378
    :cond_4
    const-string p1, "search"

    .line 379
    .line 380
    invoke-virtual {p2, p1}, Landroid/os/BaseBundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    .line 381
    .line 382
    .line 383
    move-result-object p1

    .line 384
    :cond_5
    if-nez v3, :cond_6

    .line 385
    .line 386
    const-string v1, "filter_desc"

    .line 387
    .line 388
    invoke-virtual {p2, v1}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    .line 389
    .line 390
    .line 391
    move-result v2

    .line 392
    if-eqz v2, :cond_6

    .line 393
    .line 394
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mAdapter:Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;

    .line 395
    .line 396
    invoke-static {p2, v1, v0}, Lcom/emanuelef/remote_capture/Utils;->getSerializable(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Class;)Ljava/io/Serializable;

    .line 397
    .line 398
    .line 399
    move-result-object p2

    .line 400
    check-cast p2, Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 401
    .line 402
    iput-object p2, v2, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 403
    .line 404
    :cond_6
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->refreshActiveFilter()V

    .line 405
    .line 406
    .line 407
    if-eqz p1, :cond_7

    .line 408
    .line 409
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 410
    .line 411
    .line 412
    move-result p2

    .line 413
    if-nez p2, :cond_7

    .line 414
    .line 415
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mQueryToApply:Ljava/lang/String;

    .line 416
    .line 417
    :cond_7
    new-instance p1, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;

    .line 418
    .line 419
    const/4 p2, 0x4

    .line 420
    invoke-direct {p1, p2, p0}, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda3;-><init>(ILjava/lang/Object;)V

    .line 421
    .line 422
    .line 423
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->observeStatus(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 424
    .line 425
    .line 426
    return-void
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
    .line 632
    .line 633
    .line 634
    .line 635
    .line 636
    .line 637
    .line 638
    .line 639
    .line 640
    .line 641
    .line 642
    .line 643
    .line 644
    .line 645
    .line 646
    .line 647
    .line 648
    .line 649
    .line 650
    .line 651
    .line 652
    .line 653
    .line 654
    .line 655
    .line 656
    .line 657
    .line 658
    .line 659
    .line 660
    .line 661
    .line 662
    .line 663
    .line 664
    .line 665
    .line 666
    .line 667
    .line 668
    .line 669
    .line 670
    .line 671
    .line 672
    .line 673
    .line 674
    .line 675
    .line 676
    .line 677
    .line 678
    .line 679
    .line 680
    .line 681
    .line 682
    .line 683
    .line 684
    .line 685
    .line 686
    .line 687
    .line 688
    .line 689
    .line 690
    .line 691
    .line 692
    .line 693
    .line 694
    .line 695
    .line 696
    .line 697
    .line 698
    .line 699
    .line 700
    .line 701
    .line 702
    .line 703
    .line 704
    .line 705
    .line 706
    .line 707
    .line 708
    .line 709
    .line 710
    .line 711
    .line 712
    .line 713
    .line 714
    .line 715
    .line 716
    .line 717
    .line 718
    .line 719
    .line 720
    .line 721
    .line 722
    .line 723
    .line 724
    .line 725
    .line 726
    .line 727
    .line 728
    .line 729
    .line 730
    .line 731
    .line 732
    .line 733
    .line 734
    .line 735
    .line 736
    .line 737
    .line 738
    .line 739
    .line 740
    .line 741
    .line 742
    .line 743
    .line 744
    .line 745
    .line 746
    .line 747
    .line 748
.end method

.method public openFileSelector()V
    .locals 3

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "csv"

    .line 6
    .line 7
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils;->getExportFileName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    new-instance v1, Landroid/content/Intent;

    .line 12
    .line 13
    const-string v2, "android.intent.action.CREATE_DOCUMENT"

    .line 14
    .line 15
    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 16
    .line 17
    .line 18
    const-string v2, "android.intent.category.OPENABLE"

    .line 19
    .line 20
    invoke-virtual {v1, v2}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 21
    .line 22
    .line 23
    const-string v2, "*/*"

    .line 24
    .line 25
    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 26
    .line 27
    .line 28
    const-string v2, "android.intent.extra.TITLE"

    .line 29
    .line 30
    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 31
    .line 32
    .line 33
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 34
    .line 35
    .line 36
    move-result-object v2

    .line 37
    invoke-static {v2, v1}, Lcom/emanuelef/remote_capture/Utils;->supportsFileDialog(Landroid/content/Context;Landroid/content/Intent;)Z

    .line 38
    .line 39
    .line 40
    move-result v2

    .line 41
    if-eqz v2, :cond_0

    .line 42
    .line 43
    :try_start_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->csvFileLauncher:Landroidx/activity/result/ActivityResultLauncher;

    .line 44
    .line 45
    invoke-virtual {v2, v1}, Landroidx/activity/result/ActivityResultLauncher;->launch(Ljava/lang/Object;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 46
    .line 47
    .line 48
    return-void

    .line 49
    :catch_0
    nop

    .line 50
    :cond_0
    const-string v1, "ConnectionsFragment"

    .line 51
    .line 52
    const-string v2, "No app found to handle file selection"

    .line 53
    .line 54
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    .line 56
    .line 57
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 58
    .line 59
    .line 60
    move-result-object v1

    .line 61
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Utils;->getDownloadsUri(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    .line 62
    .line 63
    .line 64
    move-result-object v0

    .line 65
    if-eqz v0, :cond_1

    .line 66
    .line 67
    iput-object v0, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->mCsvFname:Landroid/net/Uri;

    .line 68
    .line 69
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->dumpCsv()V

    .line 70
    .line 71
    .line 72
    goto :goto_0

    .line 73
    :cond_1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 74
    .line 75
    .line 76
    move-result-object v0

    .line 77
    const/4 v1, 0x0

    .line 78
    new-array v1, v1, [Ljava/lang/Object;

    .line 79
    .line 80
    const v2, 0x7f140208

    .line 81
    .line 82
    .line 83
    invoke-static {v0, v2, v1}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 84
    .line 85
    .line 86
    :goto_0
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
