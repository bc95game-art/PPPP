.class public Lcom/emanuelef/remote_capture/CaptureService;
.super Landroid/net/VpnService;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z = false

.field public static final CONNECTIONS_LOG_SIZE:I = 0x2000

.field private static HAS_ERROR:Z = false

.field private static INSTANCE:Lcom/emanuelef/remote_capture/CaptureService; = null

.field private static final NOTIFY_CHAN_MALWARE_DETECTION:Ljava/lang/String; = "Malware detection"

.field private static final NOTIFY_CHAN_OTHER:Ljava/lang/String; = "Other"

.field private static final NOTIFY_CHAN_VPNSERVICE:Ljava/lang/String; = "VPNService"

.field public static final NOTIFY_ID_APP_BLOCKED:I = 0x3

.field public static final NOTIFY_ID_LOW_MEMORY:I = 0x2

.field public static final NOTIFY_ID_VPNSERVICE:I = 0x1

.field private static final TAG:Ljava/lang/String; = "CaptureService"

.field public static final VPN_IP6_ADDRESS:Ljava/lang/String; = "fd00:2:fd00:1:fd00:1:fd00:1"

.field public static final VPN_IP_ADDRESS:Ljava/lang/String; = "10.215.173.1"

.field private static final VPN_MTU:I = 0x2710

.field public static final VPN_VIRTUAL_DNS_SERVER:Ljava/lang/String; = "10.215.173.2"

.field private static final VpnSessionName:Ljava/lang/String; = "PCAPdroid VPN"

.field private static alwaysOnVpnErrorLogged:Z

.field private static final lastStats:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData;"
        }
    .end annotation
.end field

.field private static final serviceStatus:Landroidx/lifecycle/MutableLiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/MutableLiveData;"
        }
    .end annotation
.end field


# instance fields
.field private conn_reg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

.field private dns_server:Ljava/lang/String;

.field private last_bytes:J

.field private last_connections:I

.field private mAppFilterUids:[I

.field private mBilling:Lcom/emanuelef/remote_capture/Billing;

.field private mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

.field private mBlacklistsUpdateRequested:Z

.field private mBlacklistsUpdateThread:Ljava/lang/Thread;

.field private mBlockPrivateDns:Z

.field private mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

.field final mCaptureStopped:Ljava/util/concurrent/locks/Condition;

.field private mCaptureThread:Ljava/lang/Thread;

.field private mConnUpdateThread:Ljava/lang/Thread;

.field private mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

.field private mDnsEncrypted:Z

.field private mDumpQueue:Ljava/util/concurrent/LinkedBlockingDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/LinkedBlockingDeque<",
            "[B>;"
        }
    .end annotation
.end field

.field private mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

.field private mDumperThread:Ljava/lang/Thread;

.field private mFirewallEnabled:Z

.field private mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

.field private mHandler:Landroid/os/Handler;

.field private mHttpLog:Lcom/emanuelef/remote_capture/HttpLog;

.field private mIfIndexToName:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mIsAlwaysOnVPN:Z

.field final mLock:Ljava/util/concurrent/locks/ReentrantLock;

.field private mLowMemory:Z

.field private mMalwareBuilder:Landroidx/core/app/NotificationCompat$Builder;

.field private mMalwareDetectionEnabled:Z

.field private mMalwareWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

.field private mMitmReceiver:Lcom/emanuelef/remote_capture/MitmReceiver;

.field private mMonitoredNetwork:J

.field private mNativeAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

.field private mNativeGeolocation:Lcom/emanuelef/remote_capture/Geolocation;

.field private mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

.field private mNewAppsInstallReceiver:Landroid/content/BroadcastReceiver;

.field private mNumUpdatesInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

.field private mParcelFileDescriptor:Landroid/os/ParcelFileDescriptor;

.field private mPcapFname:Ljava/lang/String;

.field private mPcapUri:Landroid/net/Uri;

.field private final mPendingUpdates:Ljava/util/concurrent/LinkedBlockingDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/LinkedBlockingDeque<",
            "Landroid/util/Pair<",
            "[",
            "Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;",
            "[",
            "Lcom/emanuelef/remote_capture/model/ConnectionUpdate;",
            ">;>;"
        }
    .end annotation
.end field

.field private mPrefs:Landroid/content/SharedPreferences;

.field private mPrivateDnsMode:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

.field private mQueueFull:Z

.field private mRevoked:Z

.field private mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

.field private mSocks5Address:Ljava/lang/String;

.field private mSocks5Auth:Ljava/lang/String;

.field private mSocks5Enabled:Z

.field private mSocks5Port:I

.field private mStatusBuilder:Landroidx/core/app/NotificationCompat$Builder;

.field private mStopping:Z

.field private mStrictDnsNoticeShown:Z

.field private mUnderlyingNetwork:Landroid/net/Network;

.field private vpn_dns:Ljava/lang/String;

.field private vpn_ipv4:Ljava/lang/String;


# direct methods
.method public static synthetic $r8$lambda$EqwfYLJ6HPqz3YCybVj1akR4MPw(Lcom/emanuelef/remote_capture/CaptureService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->lambda$run$5()V

    return-void
.end method

.method public static synthetic $r8$lambda$JYqwrVd1pyrGDTxgAK86Qqqf0WQ(Lcom/emanuelef/remote_capture/CaptureService;Landroid/app/Notification;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->lambda$notifyLowMemory$1(Landroid/app/Notification;)V

    return-void
.end method

.method public static synthetic $r8$lambda$OpuoSjshhRR79oizsM9OSGox59E(Lcom/emanuelef/remote_capture/CaptureService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->lambda$resolveHosts$2()V

    return-void
.end method

.method public static synthetic $r8$lambda$QOPxv9l4TAjDZSQ6g-wZdKhumdw(Lcom/emanuelef/remote_capture/CaptureService;[Lcom/emanuelef/remote_capture/Blacklists$NativeBlacklistStatus;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->lambda$notifyBlacklistsLoaded$7([Lcom/emanuelef/remote_capture/Blacklists$NativeBlacklistStatus;)V

    return-void
.end method

.method public static synthetic $r8$lambda$S61qE7nEsRBU72J2dlY3o9c-nWQ(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->lambda$reportError$6(Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic $r8$lambda$TgVAKJnL_N9D6jcUnIOo9Eu2ku4(Lcom/emanuelef/remote_capture/CaptureService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->updateBlacklistsWork()V

    return-void
.end method

.method public static synthetic $r8$lambda$Wn0Xt9R9g-u2fOxGH_YGVKXhtKA(Lcom/emanuelef/remote_capture/CaptureService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->updateNotification()V

    return-void
.end method

.method public static synthetic $r8$lambda$_Alazbw3pezXDoxDChLwJvt3eRA(Lcom/emanuelef/remote_capture/CaptureService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->dumpWork()V

    return-void
.end method

.method public static synthetic $r8$lambda$cxNAERnw-DvDvYvWW3S5QgZpiSw(Lcom/emanuelef/remote_capture/CaptureService;ILandroid/app/Notification;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/CaptureService;->lambda$notifyBlacklistedConnection$0(ILandroid/app/Notification;)V

    return-void
.end method

.method public static synthetic $r8$lambda$gsYl3MwmKbrXbZZKkFzkVc1yS7o(Lcom/emanuelef/remote_capture/CaptureService;Z)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->lambda$run$4(Z)V

    return-void
.end method

.method public static synthetic $r8$lambda$gwgq1c0Ow12pyc2_Mpr37yqdR5M(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->lambda$resolveHosts$3(Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic $r8$lambda$iIi-IbTmrBznc8fIm7NLuEv8-5A(Lcom/emanuelef/remote_capture/CaptureService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->connUpdateWork()V

    return-void
.end method

.method public static synthetic $r8$lambda$izuw-LD2dmrxMcoSkejqztmTfDA()V
    .locals 0

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopPacketLoop()V

    return-void
.end method

.method public static bridge synthetic -$$Nest$fgetdns_server(Lcom/emanuelef/remote_capture/CaptureService;)Ljava/lang/String;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmBlocklist(Lcom/emanuelef/remote_capture/CaptureService;)Lcom/emanuelef/remote_capture/model/Blocklist;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmMonitoredNetwork(Lcom/emanuelef/remote_capture/CaptureService;)J
    .locals 2

    .line 1
    iget-wide v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMonitoredNetwork:J

    return-wide v0
.end method

.method public static bridge synthetic -$$Nest$fgetmPrefs(Lcom/emanuelef/remote_capture/CaptureService;)Landroid/content/SharedPreferences;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fputdns_server(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    return-void
.end method

.method public static bridge synthetic -$$Nest$fputmMonitoredNetwork(Lcom/emanuelef/remote_capture/CaptureService;)V
    .locals 2

    .line 1
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMonitoredNetwork:J

    return-void
.end method

.method public static bridge synthetic -$$Nest$mhandleLinkProperties(Lcom/emanuelef/remote_capture/CaptureService;Landroid/net/LinkProperties;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->handleLinkProperties(Landroid/net/LinkProperties;)V

    return-void
.end method

.method public static bridge synthetic -$$Nest$munregisterNetworkCallbacks(Lcom/emanuelef/remote_capture/CaptureService;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->unregisterNetworkCallbacks()V

    return-void
.end method

.method public static bridge synthetic -$$Nest$smsetDnsServer(Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-static {p0}, Lcom/emanuelef/remote_capture/CaptureService;->setDnsServer(Ljava/lang/String;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    .line 2
    .line 3
    invoke-direct {v0}, Landroidx/lifecycle/LiveData;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcom/emanuelef/remote_capture/CaptureService;->lastStats:Landroidx/lifecycle/MutableLiveData;

    .line 7
    .line 8
    new-instance v0, Landroidx/lifecycle/MutableLiveData;

    .line 9
    .line 10
    invoke-direct {v0}, Landroidx/lifecycle/LiveData;-><init>()V

    .line 11
    .line 12
    .line 13
    sput-object v0, Lcom/emanuelef/remote_capture/CaptureService;->serviceStatus:Landroidx/lifecycle/MutableLiveData;

    .line 14
    .line 15
    :try_start_0
    const-string v0, "capture"

    .line 16
    .line 17
    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->getAppVersionString()Ljava/lang/String;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->getDeviceModel()Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v1

    .line 28
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->getOsVersion()Ljava/lang/String;

    .line 29
    .line 30
    .line 31
    move-result-object v2

    .line 32
    invoke-static {v0, v1, v2}, Lcom/emanuelef/remote_capture/CaptureService;->initPlatformInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_0} :catch_0

    .line 33
    .line 34
    .line 35
    :catch_0
    const/4 v0, 0x0

    .line 36
    sput-boolean v0, Lcom/emanuelef/remote_capture/CaptureService;->alwaysOnVpnErrorLogged:Z

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
    .line 58
.end method

.method public constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Landroid/net/VpnService;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 10
    .line 11
    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->newCondition()Ljava/util/concurrent/locks/Condition;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureStopped:Ljava/util/concurrent/locks/Condition;

    .line 16
    .line 17
    new-instance v0, Ljava/util/concurrent/LinkedBlockingDeque;

    .line 18
    .line 19
    const/16 v1, 0x20

    .line 20
    .line 21
    invoke-direct {v0, v1}, Ljava/util/concurrent/LinkedBlockingDeque;-><init>(I)V

    .line 22
    .line 23
    .line 24
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPendingUpdates:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 25
    .line 26
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    .line 27
    .line 28
    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    .line 29
    .line 30
    .line 31
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNumUpdatesInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 32
    .line 33
    return-void
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

.method private abortStart()I
    .locals 1

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopService()V

    .line 2
    .line 3
    .line 4
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;->STOPPED:Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    .line 5
    .line 6
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/CaptureService;->updateServiceStatus(Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    .line 7
    .line 8
    .line 9
    const/4 v0, 0x2

    .line 10
    return v0
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

.method private static native addPortMapping(IIILjava/lang/String;)V
.end method

.method public static native askStatsDump()V
.end method

.method public static checkAlwaysOnVpnActivated()Z
    .locals 3

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-nez v0, :cond_0

    .line 5
    .line 6
    return v1

    .line 7
    :cond_0
    iget-boolean v2, v0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 8
    .line 9
    if-nez v2, :cond_1

    .line 10
    .line 11
    invoke-direct {v0}, Lcom/emanuelef/remote_capture/CaptureService;->isAlwaysOnVpnDetected()Z

    .line 12
    .line 13
    .line 14
    move-result v2

    .line 15
    if-eqz v2, :cond_1

    .line 16
    .line 17
    const-string v1, "CaptureService"

    .line 18
    .line 19
    const-string v2, "Always-on VPN was activated"

    .line 20
    .line 21
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    .line 23
    .line 24
    const/4 v1, 0x1

    .line 25
    iput-boolean v1, v0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 26
    .line 27
    :cond_1
    return v1
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

.method private checkAvailableHeap()V
    .locals 5

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->getAvailableHeap()J

    .line 2
    .line 3
    .line 4
    move-result-wide v0

    .line 5
    const-wide/32 v2, 0xa00000

    .line 6
    .line 7
    .line 8
    cmp-long v4, v0, v2

    .line 9
    .line 10
    if-gtz v4, :cond_0

    .line 11
    .line 12
    new-instance v2, Ljava/lang/StringBuilder;

    .line 13
    .line 14
    const-string v3, "Detected low HEAP memory: "

    .line 15
    .line 16
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 17
    .line 18
    .line 19
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 24
    .line 25
    .line 26
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    const-string v1, "CaptureService"

    .line 31
    .line 32
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    .line 34
    .line 35
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->handleLowMemory()V

    .line 36
    .line 37
    .line 38
    :cond_0
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
    .line 58
.end method

.method private checkBlacklistsUpdates(Z)V
    .locals 2

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareDetectionEnabled:Z

    .line 2
    .line 3
    if-eqz v0, :cond_2

    .line 4
    .line 5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklistsUpdateThread:Ljava/lang/Thread;

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    goto :goto_0

    .line 10
    :cond_0
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklistsUpdateRequested:Z

    .line 11
    .line 12
    if-nez v0, :cond_1

    .line 13
    .line 14
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 15
    .line 16
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/Blacklists;->needsUpdate(Z)Z

    .line 17
    .line 18
    .line 19
    move-result p1

    .line 20
    if-eqz p1, :cond_2

    .line 21
    .line 22
    :cond_1
    new-instance p1, Ljava/lang/Thread;

    .line 23
    .line 24
    new-instance v0, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;

    .line 25
    .line 26
    const/4 v1, 0x0

    .line 27
    invoke-direct {v0, v1, p0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 28
    .line 29
    .line 30
    const-string v1, "Blacklists Update"

    .line 31
    .line 32
    invoke-direct {p1, v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 33
    .line 34
    .line 35
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklistsUpdateThread:Ljava/lang/Thread;

    .line 36
    .line 37
    invoke-virtual {p1}, Ljava/lang/Thread;->start()V

    .line 38
    .line 39
    .line 40
    :cond_2
    :goto_0
    return-void
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

.method private connUpdateWork()V
    .locals 5

    .line 1
    :catch_0
    :cond_0
    :goto_0
    :try_start_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPendingUpdates:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/concurrent/LinkedBlockingDeque;->take()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroid/util/Pair;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 8
    .line 9
    iget-object v1, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    .line 10
    .line 11
    if-nez v1, :cond_1

    .line 12
    .line 13
    const-string v0, "CaptureService"

    .line 14
    .line 15
    const-string v1, "Connection update thread exit requested"

    .line 16
    .line 17
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    return-void

    .line 21
    :cond_1
    check-cast v1, [Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 22
    .line 23
    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    .line 24
    .line 25
    check-cast v0, [Lcom/emanuelef/remote_capture/model/ConnectionUpdate;

    .line 26
    .line 27
    const/4 v2, 0x0

    .line 28
    invoke-direct {p0, v2}, Lcom/emanuelef/remote_capture/CaptureService;->checkBlacklistsUpdates(Z)V

    .line 29
    .line 30
    .line 31
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 32
    .line 33
    invoke-virtual {v2}, Lcom/emanuelef/remote_capture/model/Blocklist;->checkGracePeriods()Z

    .line 34
    .line 35
    .line 36
    move-result v2

    .line 37
    if-eqz v2, :cond_2

    .line 38
    .line 39
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 40
    .line 41
    new-instance v3, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;

    .line 42
    .line 43
    const/4 v4, 0x3

    .line 44
    invoke-direct {v3, v4, p0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 45
    .line 46
    .line 47
    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 48
    .line 49
    .line 50
    :cond_2
    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mLowMemory:Z

    .line 51
    .line 52
    if-nez v2, :cond_3

    .line 53
    .line 54
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->checkAvailableHeap()V

    .line 55
    .line 56
    .line 57
    :cond_3
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->conn_reg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 58
    .line 59
    monitor-enter v2

    .line 60
    :try_start_1
    array-length v3, v1

    .line 61
    if-lez v3, :cond_4

    .line 62
    .line 63
    iget-object v3, p0, Lcom/emanuelef/remote_capture/CaptureService;->conn_reg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 64
    .line 65
    invoke-virtual {v3, v1}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->newConnections([Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V

    .line 66
    .line 67
    .line 68
    goto :goto_1

    .line 69
    :catchall_0
    move-exception v0

    .line 70
    goto :goto_2

    .line 71
    :cond_4
    :goto_1
    array-length v1, v0

    .line 72
    if-lez v1, :cond_5

    .line 73
    .line 74
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->conn_reg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 75
    .line 76
    invoke-virtual {v1, v0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->connectionsUpdates([Lcom/emanuelef/remote_capture/model/ConnectionUpdate;)V

    .line 77
    .line 78
    .line 79
    :cond_5
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 80
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNumUpdatesInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 81
    .line 82
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 83
    .line 84
    .line 85
    move-result v0

    .line 86
    if-nez v0, :cond_0

    .line 87
    .line 88
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHttpLog:Lcom/emanuelef/remote_capture/HttpLog;

    .line 89
    .line 90
    if-eqz v0, :cond_0

    .line 91
    .line 92
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/HttpLog;->stopConnectionsUpdates()V

    .line 93
    .line 94
    .line 95
    goto :goto_0

    .line 96
    :goto_2
    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 97
    throw v0
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

.method public static native dumpMasterSecret([B)V
.end method

.method private dumpWork()V
    .locals 3

    .line 1
    const-string v0, "Starting the dumper"

    .line 2
    .line 3
    const-string v1, "CaptureService"

    .line 4
    .line 5
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    :try_start_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 9
    .line 10
    invoke-interface {v0}, Lcom/emanuelef/remote_capture/interfaces/PcapDumper;->startDumper()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_3

    .line 11
    .line 12
    .line 13
    const-string v0, "Dumper running"

    .line 14
    .line 15
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 16
    .line 17
    .line 18
    :catch_0
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumpQueue:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 19
    .line 20
    invoke-virtual {v0}, Ljava/util/concurrent/LinkedBlockingDeque;->take()Ljava/lang/Object;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    check-cast v0, [B
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0

    .line 25
    .line 26
    array-length v1, v0

    .line 27
    if-nez v1, :cond_0

    .line 28
    .line 29
    goto :goto_1

    .line 30
    :cond_0
    :try_start_2
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 31
    .line 32
    invoke-interface {v1, v0}, Lcom/emanuelef/remote_capture/interfaces/PcapDumper;->dumpData([B)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 33
    .line 34
    .line 35
    goto :goto_0

    .line 36
    :catch_1
    move-exception v0

    .line 37
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 38
    .line 39
    .line 40
    invoke-virtual {v0}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    .line 41
    .line 42
    .line 43
    move-result-object v0

    .line 44
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/CaptureService;->reportError(Ljava/lang/String;)V

    .line 45
    .line 46
    .line 47
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 48
    .line 49
    new-instance v1, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;

    .line 50
    .line 51
    const/4 v2, 0x0

    .line 52
    invoke-direct {v1, v2}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;-><init>(I)V

    .line 53
    .line 54
    .line 55
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 56
    .line 57
    .line 58
    :goto_1
    :try_start_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 59
    .line 60
    invoke-interface {v0}, Lcom/emanuelef/remote_capture/interfaces/PcapDumper;->stopDumper()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    .line 61
    .line 62
    .line 63
    goto :goto_2

    .line 64
    :catch_2
    move-exception v0

    .line 65
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 66
    .line 67
    .line 68
    :goto_2
    return-void

    .line 69
    :catch_3
    move-exception v0

    .line 70
    goto :goto_3

    .line 71
    :catch_4
    move-exception v0

    .line 72
    :goto_3
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 73
    .line 74
    .line 75
    invoke-virtual {v0}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object v0

    .line 79
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/CaptureService;->reportError(Ljava/lang/String;)V

    .line 80
    .line 81
    .line 82
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 83
    .line 84
    new-instance v1, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;

    .line 85
    .line 86
    const/4 v2, 0x0

    .line 87
    invoke-direct {v1, v2}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;-><init>(I)V

    .line 88
    .line 89
    .line 90
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 91
    .line 92
    .line 93
    return-void
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

.method public static native extractKeylogFromPcapng(Ljava/lang/String;Ljava/lang/String;)Z
.end method

.method public static getAppFilter()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 6
    .line 7
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 8
    .line 9
    return-object v0

    .line 10
    :cond_0
    const/4 v0, 0x0

    .line 11
    return-object v0
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

.method public static getBytes()J
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-wide v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->last_bytes:J

    .line 6
    .line 7
    return-wide v0

    .line 8
    :cond_0
    const-wide/16 v0, 0x0

    .line 9
    .line 10
    return-wide v0
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

.method public static getCaptureSettings()Lcom/emanuelef/remote_capture/model/CaptureSettings;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 6
    .line 7
    return-object v0

    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    return-object v0
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

.method public static getCollectorAddress()Ljava/lang/String;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 6
    .line 7
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_address:Ljava/lang/String;

    .line 8
    .line 9
    return-object v0

    .line 10
    :cond_0
    const-string v0, ""

    .line 11
    .line 12
    return-object v0
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

.method public static getCollectorPort()I
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 6
    .line 7
    iget v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_port:I

    .line 8
    .line 9
    return v0

    .line 10
    :cond_0
    const/4 v0, 0x0

    .line 11
    return v0
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

.method public static getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->conn_reg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 6
    .line 7
    return-object v0

    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    return-object v0
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

.method public static getCurPayloadMode()Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    sget-object v0, Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;->MINIMAL:Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    .line 6
    .line 7
    return-object v0

    .line 8
    :cond_0
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 9
    .line 10
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->full_payload:Z

    .line 11
    .line 12
    if-eqz v0, :cond_1

    .line 13
    .line 14
    sget-object v0, Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;->FULL:Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    .line 15
    .line 16
    return-object v0

    .line 17
    :cond_1
    sget-object v0, Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;->MINIMAL:Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    .line 18
    .line 19
    return-object v0
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

.method public static getDNSServer()Ljava/lang/String;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/CaptureService;->getDnsServer()Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    return-object v0

    .line 10
    :cond_0
    const-string v0, ""

    .line 11
    .line 12
    return-object v0
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

.method public static getDumpMode()Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 6
    .line 7
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_mode:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 8
    .line 9
    return-object v0

    .line 10
    :cond_0
    sget-object v0, Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;->NONE:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 11
    .line 12
    return-object v0
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

.method private static native getFdSetSize()I
.end method

.method public static getHTTPServerPort()I
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 6
    .line 7
    iget v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->http_server_port:I

    .line 8
    .line 9
    return v0

    .line 10
    :cond_0
    const/4 v0, 0x0

    .line 11
    return v0
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

.method public static getHttpLog()Lcom/emanuelef/remote_capture/HttpLog;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mHttpLog:Lcom/emanuelef/remote_capture/HttpLog;

    .line 6
    .line 7
    return-object v0

    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    return-object v0
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

.method private getIfname(I)Ljava/lang/String;
    .locals 2

    .line 1
    const-string v0, ""

    .line 2
    .line 3
    if-gtz p1, :cond_0

    .line 4
    .line 5
    return-object v0

    .line 6
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIfIndexToName:Landroid/util/SparseArray;

    .line 7
    .line 8
    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v1

    .line 12
    check-cast v1, Ljava/lang/String;

    .line 13
    .line 14
    if-eqz v1, :cond_1

    .line 15
    .line 16
    return-object v1

    .line 17
    :cond_1
    :try_start_0
    invoke-static {p1}, Ljava/net/NetworkInterface;->getByIndex(I)Ljava/net/NetworkInterface;

    .line 18
    .line 19
    .line 20
    move-result-object v1
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    .line 21
    goto :goto_0

    .line 22
    :catch_0
    const/4 v1, 0x0

    .line 23
    :goto_0
    if-eqz v1, :cond_2

    .line 24
    .line 25
    invoke-virtual {v1}, Ljava/net/NetworkInterface;->getName()Ljava/lang/String;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    :cond_2
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIfIndexToName:Landroid/util/SparseArray;

    .line 30
    .line 31
    invoke-virtual {v1, p1, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 32
    .line 33
    .line 34
    return-object v0
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

.method public static getInterfaceName(I)Ljava/lang/String;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/CaptureService;->getIfname(I)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object p0

    .line 9
    goto :goto_0

    .line 10
    :cond_0
    const/4 p0, 0x0

    .line 11
    :goto_0
    if-eqz p0, :cond_1

    .line 12
    .line 13
    return-object p0

    .line 14
    :cond_1
    const-string p0, ""

    .line 15
    .line 16
    return-object p0
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

.method public static native getL7Protocols()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public static getLibprogPath(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .line 2
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object p0

    iget-object p0, p0, Landroid/content/pm/ApplicationInfo;->nativeLibraryDir:Ljava/lang/String;

    .line 3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, "/lib"

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, ".so"

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getMitmProxyStatus()Lcom/emanuelef/remote_capture/MitmReceiver$Status;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mMitmReceiver:Lcom/emanuelef/remote_capture/MitmReceiver;

    .line 6
    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    goto :goto_0

    .line 10
    :cond_0
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmReceiver;->getProxyStatus()Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    return-object v0

    .line 15
    :cond_1
    :goto_0
    sget-object v0, Lcom/emanuelef/remote_capture/MitmReceiver$Status;->NOT_STARTED:Lcom/emanuelef/remote_capture/MitmReceiver$Status;

    .line 16
    .line 17
    return-object v0
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

.method public static native getNumCheckedFirewallConnections()I
.end method

.method public static native getNumCheckedMalwareConnections()I
.end method

.method public static getPcapFname()Ljava/lang/String;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mPcapFname:Ljava/lang/String;

    .line 6
    .line 7
    return-object v0

    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    return-object v0
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

.method public static native getPcapHeader()[B
.end method

.method public static getPcapUri()Landroid/net/Uri;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mPcapUri:Landroid/net/Uri;

    .line 6
    .line 7
    return-object v0

    .line 8
    :cond_0
    const/4 v0, 0x0

    .line 9
    return-object v0
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

.method public static getPrivateDnsMode()Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;
    .locals 1

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isServiceActive()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 8
    .line 9
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mPrivateDnsMode:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 10
    .line 11
    return-object v0

    .line 12
    :cond_0
    const/4 v0, 0x0

    .line 13
    return-object v0
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

.method public static getStats()Lcom/emanuelef/remote_capture/model/CaptureStats;
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->lastStats:Landroidx/lifecycle/MutableLiveData;

    .line 2
    .line 3
    iget-object v0, v0, Landroidx/lifecycle/LiveData;->mData:Ljava/lang/Object;

    .line 4
    .line 5
    sget-object v1, Landroidx/lifecycle/LiveData;->NOT_SET:Ljava/lang/Object;

    .line 6
    .line 7
    if-eq v0, v1, :cond_0

    .line 8
    .line 9
    goto :goto_0

    .line 10
    :cond_0
    const/4 v0, 0x0

    .line 11
    :goto_0
    check-cast v0, Lcom/emanuelef/remote_capture/model/CaptureStats;

    .line 12
    .line 13
    if-eqz v0, :cond_1

    .line 14
    .line 15
    return-object v0

    .line 16
    :cond_1
    new-instance v0, Lcom/emanuelef/remote_capture/model/CaptureStats;

    .line 17
    .line 18
    invoke-direct {v0}, Lcom/emanuelef/remote_capture/model/CaptureStats;-><init>()V

    .line 19
    .line 20
    .line 21
    return-object v0
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

.method private getStatusNotification()Landroid/app/Notification;
    .locals 5

    .line 1
    const v0, 0x7f140219

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    iget-wide v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->last_bytes:J

    .line 9
    .line 10
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    iget v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->last_connections:I

    .line 15
    .line 16
    int-to-long v2, v2

    .line 17
    invoke-static {p0, v2, v3}, Lcom/emanuelef/remote_capture/Utils;->formatNumber(Landroid/content/Context;J)Ljava/lang/String;

    .line 18
    .line 19
    .line 20
    move-result-object v2

    .line 21
    const/4 v3, 0x2

    .line 22
    new-array v3, v3, [Ljava/lang/Object;

    .line 23
    .line 24
    const/4 v4, 0x0

    .line 25
    aput-object v1, v3, v4

    .line 26
    .line 27
    const/4 v1, 0x1

    .line 28
    aput-object v2, v3, v1

    .line 29
    .line 30
    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 31
    .line 32
    .line 33
    move-result-object v0

    .line 34
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mStatusBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 35
    .line 36
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 37
    .line 38
    .line 39
    invoke-static {v0}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    iput-object v0, v1, Landroidx/core/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    .line 44
    .line 45
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mStatusBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 46
    .line 47
    invoke-virtual {v0}, Landroidx/core/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    .line 48
    .line 49
    .line 50
    move-result-object v0

    .line 51
    return-object v0
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method private handleLinkProperties(Landroid/net/LinkProperties;)V
    .locals 3

    .line 1
    if-nez p1, :cond_0

    .line 2
    .line 3
    goto/16 :goto_1

    .line 4
    .line 5
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 6
    .line 7
    const/16 v1, 0x1c

    .line 8
    .line 9
    if-lt v0, v1, :cond_4

    .line 10
    .line 11
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->getPrivateDnsMode(Landroid/net/LinkProperties;)Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 12
    .line 13
    .line 14
    move-result-object p1

    .line 15
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrivateDnsMode:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 16
    .line 17
    new-instance p1, Ljava/lang/StringBuilder;

    .line 18
    .line 19
    const-string v0, "Private DNS: "

    .line 20
    .line 21
    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 22
    .line 23
    .line 24
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrivateDnsMode:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 25
    .line 26
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 27
    .line 28
    .line 29
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 30
    .line 31
    .line 32
    move-result-object p1

    .line 33
    const-string v0, "CaptureService"

    .line 34
    .line 35
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    .line 37
    .line 38
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 39
    .line 40
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->readFromPcap()Z

    .line 41
    .line 42
    .line 43
    move-result p1

    .line 44
    const/4 v0, 0x1

    .line 45
    const/4 v1, 0x0

    .line 46
    if-eqz p1, :cond_1

    .line 47
    .line 48
    iput-boolean v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDnsEncrypted:Z

    .line 49
    .line 50
    invoke-static {v1}, Lcom/emanuelef/remote_capture/CaptureService;->setPrivateDnsBlocked(Z)V

    .line 51
    .line 52
    .line 53
    goto :goto_0

    .line 54
    :cond_1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 55
    .line 56
    iget-boolean v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 57
    .line 58
    if-nez v2, :cond_2

    .line 59
    .line 60
    iget-boolean p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->auto_block_private_dns:Z

    .line 61
    .line 62
    if-eqz p1, :cond_2

    .line 63
    .line 64
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrivateDnsMode:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 65
    .line 66
    sget-object v2, Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;->STRICT:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 67
    .line 68
    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 69
    .line 70
    .line 71
    move-result p1

    .line 72
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDnsEncrypted:Z

    .line 73
    .line 74
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrivateDnsMode:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 75
    .line 76
    sget-object v2, Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;->OPPORTUNISTIC:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 77
    .line 78
    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 79
    .line 80
    .line 81
    move-result p1

    .line 82
    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlockPrivateDns:Z

    .line 83
    .line 84
    if-eq v2, p1, :cond_3

    .line 85
    .line 86
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlockPrivateDns:Z

    .line 87
    .line 88
    invoke-static {p1}, Lcom/emanuelef/remote_capture/CaptureService;->setPrivateDnsBlocked(Z)V

    .line 89
    .line 90
    .line 91
    goto :goto_0

    .line 92
    :cond_2
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrivateDnsMode:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 93
    .line 94
    sget-object v2, Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;->DISABLED:Lcom/emanuelef/remote_capture/Utils$PrivateDnsMode;

    .line 95
    .line 96
    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 97
    .line 98
    .line 99
    move-result p1

    .line 100
    xor-int/2addr p1, v0

    .line 101
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDnsEncrypted:Z

    .line 102
    .line 103
    invoke-static {v1}, Lcom/emanuelef/remote_capture/CaptureService;->setPrivateDnsBlocked(Z)V

    .line 104
    .line 105
    .line 106
    :cond_3
    :goto_0
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDnsEncrypted:Z

    .line 107
    .line 108
    if-eqz p1, :cond_4

    .line 109
    .line 110
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mStrictDnsNoticeShown:Z

    .line 111
    .line 112
    if-nez p1, :cond_4

    .line 113
    .line 114
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mStrictDnsNoticeShown:Z

    .line 115
    .line 116
    const p1, 0x7f140252

    .line 117
    .line 118
    .line 119
    new-array v0, v1, [Ljava/lang/Object;

    .line 120
    .line 121
    invoke-static {p0, p1, v0}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 122
    .line 123
    .line 124
    :cond_4
    :goto_1
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
.end method

.method private handleLowMemory()V
    .locals 3

    .line 1
    const-string v0, "handleLowMemory called"

    .line 2
    .line 3
    const-string v1, "CaptureService"

    .line 4
    .line 5
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x1

    .line 9
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mLowMemory:Z

    .line 10
    .line 11
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getCurPayloadMode()Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    sget-object v2, Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;->FULL:Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    .line 16
    .line 17
    if-ne v0, v2, :cond_2

    .line 18
    .line 19
    const-string v0, "Disabling full payload"

    .line 20
    .line 21
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 22
    .line 23
    .line 24
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 25
    .line 26
    const/4 v2, 0x0

    .line 27
    iput-boolean v2, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->full_payload:Z

    .line 28
    .line 29
    sget-object v0, Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;->NONE:Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    .line 30
    .line 31
    invoke-virtual {v0}, Ljava/lang/Enum;->ordinal()I

    .line 32
    .line 33
    .line 34
    move-result v0

    .line 35
    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->setPayloadMode(I)V

    .line 36
    .line 37
    .line 38
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 39
    .line 40
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 41
    .line 42
    if-eqz v0, :cond_0

    .line 43
    .line 44
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopService()V

    .line 45
    .line 46
    .line 47
    const v0, 0x7f140075

    .line 48
    .line 49
    .line 50
    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 51
    .line 52
    .line 53
    move-result-object v0

    .line 54
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/CaptureService;->notifyLowMemory(Ljava/lang/CharSequence;)V

    .line 55
    .line 56
    .line 57
    return-void

    .line 58
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->conn_reg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 59
    .line 60
    if-eqz v0, :cond_1

    .line 61
    .line 62
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->releasePayloadMemory()V

    .line 63
    .line 64
    .line 65
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 66
    .line 67
    .line 68
    new-instance v0, Ljava/lang/StringBuilder;

    .line 69
    .line 70
    const-string v2, "Memory stats full payload release:\n"

    .line 71
    .line 72
    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 73
    .line 74
    .line 75
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Utils;->getMemoryStats(Landroid/content/Context;)Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object v2

    .line 79
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 80
    .line 81
    .line 82
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 83
    .line 84
    .line 85
    move-result-object v0

    .line 86
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    .line 88
    .line 89
    :cond_1
    const v0, 0x7f14011e

    .line 90
    .line 91
    .line 92
    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 93
    .line 94
    .line 95
    move-result-object v0

    .line 96
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/CaptureService;->notifyLowMemory(Ljava/lang/CharSequence;)V

    .line 97
    .line 98
    .line 99
    return-void

    .line 100
    :cond_2
    const-string v0, "low memory detected, expect crashes"

    .line 101
    .line 102
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    .line 104
    .line 105
    const v0, 0x7f14016d

    .line 106
    .line 107
    .line 108
    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 109
    .line 110
    .line 111
    move-result-object v0

    .line 112
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/CaptureService;->notifyLowMemory(Ljava/lang/CharSequence;)V

    .line 113
    .line 114
    .line 115
    return-void
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

.method public static hasError()Z
    .locals 1

    .line 1
    sget-boolean v0, Lcom/emanuelef/remote_capture/CaptureService;->HAS_ERROR:Z

    .line 2
    .line 3
    return v0
    .line 4
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
    .line 58
.end method

.method public static native hasSeenDumpExtensions()Z
.end method

.method public static native initLogger(Ljava/lang/String;I)I
.end method

.method private static native initPlatformInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public static isAlwaysOnVPN()Z
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

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

.method private isAlwaysOnVpnDetected()Z
    .locals 3

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 2
    .line 3
    const/16 v1, 0x1d

    .line 4
    .line 5
    if-lt v0, v1, :cond_0

    .line 6
    .line 7
    invoke-virtual {p0}, Landroid/net/VpnService;->isAlwaysOn()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    return v0

    .line 12
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    const-string v1, "always_on_vpn_app"

    .line 17
    .line 18
    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v1

    .line 26
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 27
    .line 28
    .line 29
    move-result v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 30
    return v0

    .line 31
    :catch_0
    move-exception v0

    .line 32
    sget-boolean v1, Lcom/emanuelef/remote_capture/CaptureService;->alwaysOnVpnErrorLogged:Z

    .line 33
    .line 34
    if-nez v1, :cond_1

    .line 35
    .line 36
    new-instance v1, Ljava/lang/StringBuilder;

    .line 37
    .line 38
    const-string v2, "Querying the always-on VPN state failed: "

    .line 39
    .line 40
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 41
    .line 42
    .line 43
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 44
    .line 45
    .line 46
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 47
    .line 48
    .line 49
    move-result-object v0

    .line 50
    const-string v1, "CaptureService"

    .line 51
    .line 52
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    .line 54
    .line 55
    const/4 v0, 0x1

    .line 56
    sput-boolean v0, Lcom/emanuelef/remote_capture/CaptureService;->alwaysOnVpnErrorLogged:Z

    .line 57
    .line 58
    :cond_1
    const/4 v0, 0x0

    .line 59
    return v0
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
.end method

.method public static isCapturingAsRoot()Z
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/CaptureService;->isRootCapture()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    const/4 v1, 0x1

    .line 10
    if-ne v0, v1, :cond_0

    .line 11
    .line 12
    return v1

    .line 13
    :cond_0
    const/4 v0, 0x0

    .line 14
    return v0
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

.method public static isDNSEncrypted()Z
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mDnsEncrypted:Z

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

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

.method public static isDecryptingTLS()Z
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/CaptureService;->isTlsDecryptionEnabled()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    const/4 v1, 0x1

    .line 10
    if-ne v0, v1, :cond_0

    .line 11
    .line 12
    return v1

    .line 13
    :cond_0
    const/4 v0, 0x0

    .line 14
    return v0
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

.method public static isDecryptionListEnabled()Z
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

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

.method public static isIPv6Enabled()Z
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/CaptureService;->getIPv6Enabled()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    const/4 v1, 0x1

    .line 10
    if-ne v0, v1, :cond_0

    .line 11
    .line 12
    return v1

    .line 13
    :cond_0
    const/4 v0, 0x0

    .line 14
    return v0
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

.method public static isLockdownVPN()Z
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Landroid/net/VpnService;->isLockdownEnabled()Z

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    const/4 v0, 0x1

    .line 12
    return v0

    .line 13
    :cond_0
    const/4 v0, 0x0

    .line 14
    return v0
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

.method public static isLowMemory()Z
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mLowMemory:Z

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

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

.method public static isReadingFromPcapFile()Z
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/CaptureService;->isPcapFileCapture()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    const/4 v1, 0x1

    .line 10
    if-ne v0, v1, :cond_0

    .line 11
    .line 12
    return v1

    .line 13
    :cond_0
    const/4 v0, 0x0

    .line 14
    return v0
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

.method public static isServiceActive()Z
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureThread:Ljava/lang/Thread;

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

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

.method public static isUserDefinedPcapUri()Z
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_1

    .line 4
    .line 5
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 6
    .line 7
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_uri:Ljava/lang/String;

    .line 8
    .line 9
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    if-nez v0, :cond_0

    .line 14
    .line 15
    goto :goto_0

    .line 16
    :cond_0
    const/4 v0, 0x0

    .line 17
    return v0

    .line 18
    :cond_1
    :goto_0
    const/4 v0, 0x1

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

.method public static isUsharkAvailable(Landroid/content/Context;)Z
    .locals 2

    .line 1
    new-instance v0, Ljava/io/File;

    .line 2
    .line 3
    const-string v1, "ushark"

    .line 4
    .line 5
    invoke-static {p0, v1}, Lcom/emanuelef/remote_capture/CaptureService;->getLibprogPath(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object p0

    .line 9
    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 10
    .line 11
    .line 12
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    .line 13
    .line 14
    .line 15
    move-result p0

    .line 16
    return p0
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

.method private synthetic lambda$notifyBlacklistedConnection$0(ILandroid/app/Notification;)V
    .locals 0

    .line 1
    invoke-static {p0, p1, p2}, Lcom/emanuelef/remote_capture/Utils;->sendImportantNotification(Landroid/content/Context;ILandroid/app/Notification;)V

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

.method private synthetic lambda$notifyBlacklistsLoaded$7([Lcom/emanuelef/remote_capture/Blacklists$NativeBlacklistStatus;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/Blacklists;->onNativeLoaded([Lcom/emanuelef/remote_capture/Blacklists$NativeBlacklistStatus;)V

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

.method private synthetic lambda$notifyLowMemory$1(Landroid/app/Notification;)V
    .locals 1

    .line 1
    const/4 v0, 0x2

    .line 2
    invoke-static {p0, v0, p1}, Lcom/emanuelef/remote_capture/Utils;->sendImportantNotification(Landroid/content/Context;ILandroid/app/Notification;)V

    .line 3
    .line 4
    .line 5
    return-void
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

.method private synthetic lambda$reportError$6(Ljava/lang/String;)V
    .locals 3

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 2
    .line 3
    .line 4
    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    const/4 v1, 0x1

    .line 9
    const/4 v2, -0x1

    .line 10
    sparse-switch v0, :sswitch_data_0

    .line 11
    .line 12
    .line 13
    goto/16 :goto_0

    .line 14
    .line 15
    :sswitch_0
    const-string v0, "Unsupported datalink"

    .line 16
    .line 17
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    if-nez v0, :cond_0

    .line 22
    .line 23
    goto :goto_0

    .line 24
    :cond_0
    const/4 v2, 0x7

    .line 25
    goto :goto_0

    .line 26
    :sswitch_1
    const-string v0, "pcapd daemon did not spawn"

    .line 27
    .line 28
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 29
    .line 30
    .line 31
    move-result v0

    .line 32
    if-nez v0, :cond_1

    .line 33
    .line 34
    goto :goto_0

    .line 35
    :cond_1
    const/4 v2, 0x6

    .line 36
    goto :goto_0

    .line 37
    :sswitch_2
    const-string v0, "Invalid PCAP/Pcapng file"

    .line 38
    .line 39
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 40
    .line 41
    .line 42
    move-result v0

    .line 43
    if-nez v0, :cond_2

    .line 44
    .line 45
    goto :goto_0

    .line 46
    :cond_2
    const/4 v2, 0x5

    .line 47
    goto :goto_0

    .line 48
    :sswitch_3
    const-string v0, "Unsupported PCAP/Pcapng file"

    .line 49
    .line 50
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 51
    .line 52
    .line 53
    move-result v0

    .line 54
    if-nez v0, :cond_3

    .line 55
    .line 56
    goto :goto_0

    .line 57
    :cond_3
    const/4 v2, 0x4

    .line 58
    goto :goto_0

    .line 59
    :sswitch_4
    const-string v0, "Could not open the capture interface"

    .line 60
    .line 61
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 62
    .line 63
    .line 64
    move-result v0

    .line 65
    if-nez v0, :cond_4

    .line 66
    .line 67
    goto :goto_0

    .line 68
    :cond_4
    const/4 v2, 0x3

    .line 69
    goto :goto_0

    .line 70
    :sswitch_5
    const-string v0, "The specified PCAP/Pcapng file does not exist"

    .line 71
    .line 72
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 73
    .line 74
    .line 75
    move-result v0

    .line 76
    if-nez v0, :cond_5

    .line 77
    .line 78
    goto :goto_0

    .line 79
    :cond_5
    const/4 v2, 0x2

    .line 80
    goto :goto_0

    .line 81
    :sswitch_6
    const-string v0, "pcapd daemon start failure"

    .line 82
    .line 83
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 84
    .line 85
    .line 86
    move-result v0

    .line 87
    if-nez v0, :cond_6

    .line 88
    .line 89
    goto :goto_0

    .line 90
    :cond_6
    const/4 v2, 0x1

    .line 91
    goto :goto_0

    .line 92
    :sswitch_7
    const-string v0, "PCAP/Pcapng read error"

    .line 93
    .line 94
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 95
    .line 96
    .line 97
    move-result v0

    .line 98
    if-nez v0, :cond_7

    .line 99
    .line 100
    goto :goto_0

    .line 101
    :cond_7
    const/4 v2, 0x0

    .line 102
    :goto_0
    packed-switch v2, :pswitch_data_0

    .line 103
    .line 104
    .line 105
    goto :goto_1

    .line 106
    :pswitch_0
    const p1, 0x7f1402d8

    .line 107
    .line 108
    .line 109
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 110
    .line 111
    .line 112
    move-result-object p1

    .line 113
    goto :goto_1

    .line 114
    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 115
    .line 116
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 117
    .line 118
    if-eqz v0, :cond_8

    .line 119
    .line 120
    const p1, 0x7f140276

    .line 121
    .line 122
    .line 123
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 124
    .line 125
    .line 126
    move-result-object p1

    .line 127
    goto :goto_1

    .line 128
    :pswitch_2
    const p1, 0x7f140149

    .line 129
    .line 130
    .line 131
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 132
    .line 133
    .line 134
    move-result-object p1

    .line 135
    goto :goto_1

    .line 136
    :pswitch_3
    const p1, 0x7f1402d9

    .line 137
    .line 138
    .line 139
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 140
    .line 141
    .line 142
    move-result-object p1

    .line 143
    goto :goto_1

    .line 144
    :pswitch_4
    const p1, 0x7f140071

    .line 145
    .line 146
    .line 147
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 148
    .line 149
    .line 150
    move-result-object p1

    .line 151
    goto :goto_1

    .line 152
    :pswitch_5
    const p1, 0x7f14023d

    .line 153
    .line 154
    .line 155
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 156
    .line 157
    .line 158
    move-result-object p1

    .line 159
    goto :goto_1

    .line 160
    :pswitch_6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 161
    .line 162
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 163
    .line 164
    if-eqz v0, :cond_8

    .line 165
    .line 166
    const p1, 0x7f140275

    .line 167
    .line 168
    .line 169
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 170
    .line 171
    .line 172
    move-result-object p1

    .line 173
    goto :goto_1

    .line 174
    :pswitch_7
    const p1, 0x7f140240

    .line 175
    .line 176
    .line 177
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 178
    .line 179
    .line 180
    move-result-object p1

    .line 181
    :cond_8
    :goto_1
    invoke-static {p0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 182
    .line 183
    .line 184
    move-result-object p1

    .line 185
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 186
    .line 187
    .line 188
    return-void

    .line 189
    :sswitch_data_0
    .sparse-switch
        -0x74b365ea -> :sswitch_7
        -0x4c9472b2 -> :sswitch_6
        -0x498109f0 -> :sswitch_5
        -0x3afc019a -> :sswitch_4
        -0x31f9b2c1 -> :sswitch_3
        -0x2e6f3643 -> :sswitch_2
        -0x109f24f1 -> :sswitch_1
        0x3315584f -> :sswitch_0
    .end sparse-switch

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
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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

.method private synthetic lambda$resolveHosts$2()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const/4 v2, 0x0

    .line 7
    aput-object v0, v1, v2

    .line 8
    .line 9
    const v0, 0x7f140131

    .line 10
    .line 11
    .line 12
    invoke-static {p0, v0, v1}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

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

.method private synthetic lambda$resolveHosts$3(Ljava/lang/String;)V
    .locals 2

    .line 1
    const/4 v0, 0x1

    .line 2
    new-array v0, v0, [Ljava/lang/Object;

    .line 3
    .line 4
    const/4 v1, 0x0

    .line 5
    aput-object p1, v0, v1

    .line 6
    .line 7
    const p1, 0x7f140131

    .line 8
    .line 9
    .line 10
    invoke-static {p0, p1, v0}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

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

.method private synthetic lambda$run$4(Z)V
    .locals 3

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    const p1, 0x7f140247

    .line 4
    .line 5
    .line 6
    goto :goto_0

    .line 7
    :cond_0
    const p1, 0x7f140246

    .line 8
    .line 9
    .line 10
    :goto_0
    const/4 v0, 0x1

    .line 11
    new-array v0, v0, [Ljava/lang/Object;

    .line 12
    .line 13
    const-string v1, "INTERACT_ACROSS_USERS"

    .line 14
    .line 15
    const/4 v2, 0x0

    .line 16
    aput-object v1, v0, v2

    .line 17
    .line 18
    invoke-static {p0, p1, v0}, Lcom/emanuelef/remote_capture/Utils;->showToast(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 19
    .line 20
    .line 21
    return-void
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

.method private synthetic lambda$run$5()V
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;->STOPPED:Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    .line 2
    .line 3
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/CaptureService;->updateServiceStatus(Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    .line 4
    .line 5
    .line 6
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getStats()Lcom/emanuelef/remote_capture/model/CaptureStats;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    invoke-static {p0, v0}, Lcom/emanuelef/remote_capture/activities/CaptureCtrl;->notifyCaptureStopped(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/CaptureStats;)V

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
    .line 58
.end method

.method public static native nativeSetFirewallEnabled(Z)V
.end method

.method public static observeStats(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/lifecycle/LifecycleOwner;",
            "Landroidx/lifecycle/Observer;",
            ")V"
        }
    .end annotation

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->lastStats:Landroidx/lifecycle/MutableLiveData;

    .line 2
    .line 3
    invoke-virtual {v0, p0, p1}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

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

.method public static observeStatus(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/lifecycle/LifecycleOwner;",
            "Landroidx/lifecycle/Observer;",
            ")V"
        }
    .end annotation

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->serviceStatus:Landroidx/lifecycle/MutableLiveData;

    .line 2
    .line 3
    invoke-virtual {v0, p0, p1}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

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

.method private registerNetworkCallbacks()V
    .locals 5

    .line 1
    const-string v0, "CaptureService"

    .line 2
    .line 3
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    return-void

    .line 8
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 9
    .line 10
    invoke-static {v1}, Lcom/emanuelef/remote_capture/model/Prefs;->getDnsServerV4(Landroid/content/SharedPreferences;)Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    const-string v2, "connectivity"

    .line 15
    .line 16
    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    move-result-object v2

    .line 20
    check-cast v2, Landroid/net/ConnectivityManager;

    .line 21
    .line 22
    new-instance v3, Lcom/emanuelef/remote_capture/CaptureService$2;

    .line 23
    .line 24
    invoke-direct {v3, p0, v1}, Lcom/emanuelef/remote_capture/CaptureService$2;-><init>(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    iput-object v3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 28
    .line 29
    :try_start_0
    const-string v3, "registerNetworkCallback"

    .line 30
    .line 31
    invoke-static {v0, v3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
    new-instance v3, Landroid/net/NetworkRequest$Builder;

    .line 35
    .line 36
    invoke-direct {v3}, Landroid/net/NetworkRequest$Builder;-><init>()V

    .line 37
    .line 38
    .line 39
    const/16 v4, 0xc

    .line 40
    .line 41
    invoke-virtual {v3, v4}, Landroid/net/NetworkRequest$Builder;->addCapability(I)Landroid/net/NetworkRequest$Builder;

    .line 42
    .line 43
    .line 44
    move-result-object v3

    .line 45
    invoke-virtual {v3}, Landroid/net/NetworkRequest$Builder;->build()Landroid/net/NetworkRequest;

    .line 46
    .line 47
    .line 48
    move-result-object v3

    .line 49
    iget-object v4, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 50
    .line 51
    invoke-virtual {v2, v3, v4}, Landroid/net/ConnectivityManager;->registerNetworkCallback(Landroid/net/NetworkRequest;Landroid/net/ConnectivityManager$NetworkCallback;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 52
    .line 53
    .line 54
    return-void

    .line 55
    :catch_0
    move-exception v2

    .line 56
    invoke-virtual {v2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 57
    .line 58
    .line 59
    const-string v2, "registerNetworkCallback failed, DNS server detection disabled"

    .line 60
    .line 61
    invoke-static {v0, v2}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    .line 63
    .line 64
    iput-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    .line 65
    .line 66
    const/4 v0, 0x0

    .line 67
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 68
    .line 69
    return-void
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

.method private static native reloadBlacklists()V
.end method

.method private static native reloadBlocklist(Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;)Z
.end method

.method public static reloadDecryptionList()V
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    if-eqz v0, :cond_1

    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    if-nez v0, :cond_0

    goto :goto_0

    .line 2
    :cond_0
    const-string v0, "CaptureService"

    const-string v1, "reloading TLS decryption whitelist"

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 3
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/MatchList;->toListDescriptor()Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;

    move-result-object v0

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->reloadDecryptionList(Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;)Z

    :cond_1
    :goto_0
    return-void
.end method

.method private static native reloadDecryptionList(Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;)Z
.end method

.method private static native reloadFirewallWhitelist(Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;)Z
.end method

.method public static reloadMalwareWhitelist()V
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    if-eqz v0, :cond_1

    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareDetectionEnabled:Z

    if-nez v0, :cond_0

    goto :goto_0

    .line 2
    :cond_0
    const-string v0, "CaptureService"

    const-string v1, "reloading malware whitelist"

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 3
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/MatchList;->toListDescriptor()Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;

    move-result-object v0

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->reloadMalwareWhitelist(Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;)Z

    :cond_1
    :goto_0
    return-void
.end method

.method private static native reloadMalwareWhitelist(Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;)Z
.end method

.method public static requestBlacklistsUpdate()V
    .locals 4

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    const/4 v1, 0x1

    .line 6
    iput-boolean v1, v0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklistsUpdateRequested:Z

    .line 7
    .line 8
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mPendingUpdates:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 9
    .line 10
    new-instance v1, Landroid/util/Pair;

    .line 11
    .line 12
    const/4 v2, 0x0

    .line 13
    new-array v3, v2, [Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 14
    .line 15
    new-array v2, v2, [Lcom/emanuelef/remote_capture/model/ConnectionUpdate;

    .line 16
    .line 17
    invoke-direct {v1, v3, v2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 18
    .line 19
    .line 20
    invoke-virtual {v0, v1}, Ljava/util/concurrent/LinkedBlockingDeque;->offer(Ljava/lang/Object;)Z

    .line 21
    .line 22
    .line 23
    :cond_0
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
    .line 58
.end method

.method public static requireConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;
    .locals 1

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
    .line 58
.end method

.method public static requireInstance()Lcom/emanuelef/remote_capture/CaptureService;
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    return-object v0
    .line 4
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
    .line 58
.end method

.method private resolveHost(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 2
    .line 3
    const/16 v1, 0x17

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    if-lt v0, v1, :cond_1

    .line 7
    .line 8
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mUnderlyingNetwork:Landroid/net/Network;

    .line 9
    .line 10
    if-nez v0, :cond_0

    .line 11
    .line 12
    goto :goto_0

    .line 13
    :cond_0
    :try_start_0
    invoke-virtual {v0, p1}, Landroid/net/Network;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    invoke-virtual {p1}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    .line 18
    .line 19
    .line 20
    move-result-object p1
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0

    .line 21
    return-object p1

    .line 22
    :catch_0
    :cond_1
    :goto_0
    return-object v2
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

.method private resolveHosts()Z
    .locals 9

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Enabled:Z

    .line 2
    .line 3
    const-string v1, " -> "

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    const-string v3, "CaptureService"

    .line 7
    .line 8
    if-eqz v0, :cond_1

    .line 9
    .line 10
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 11
    .line 12
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 13
    .line 14
    if-nez v0, :cond_1

    .line 15
    .line 16
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 17
    .line 18
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    if-nez v0, :cond_1

    .line 23
    .line 24
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 25
    .line 26
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Utils;->validateIpAddress(Ljava/lang/String;)Z

    .line 27
    .line 28
    .line 29
    move-result v0

    .line 30
    if-nez v0, :cond_1

    .line 31
    .line 32
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 33
    .line 34
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/CaptureService;->resolveHost(Ljava/lang/String;)Ljava/lang/String;

    .line 35
    .line 36
    .line 37
    move-result-object v0

    .line 38
    if-nez v0, :cond_0

    .line 39
    .line 40
    new-instance v0, Ljava/lang/StringBuilder;

    .line 41
    .line 42
    const-string v1, "Could not resolve SOCKS5 proxy: "

    .line 43
    .line 44
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 45
    .line 46
    .line 47
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 48
    .line 49
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 50
    .line 51
    .line 52
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 53
    .line 54
    .line 55
    move-result-object v0

    .line 56
    invoke-static {v3, v0}, Lcom/emanuelef/remote_capture/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    .line 58
    .line 59
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 60
    .line 61
    new-instance v1, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;

    .line 62
    .line 63
    const/4 v3, 0x2

    .line 64
    invoke-direct {v1, v3, p0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 65
    .line 66
    .line 67
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 68
    .line 69
    .line 70
    return v2

    .line 71
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    .line 72
    .line 73
    const-string v5, "Resolved SOCKS5 proxy: "

    .line 74
    .line 75
    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 76
    .line 77
    .line 78
    iget-object v5, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 79
    .line 80
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    .line 82
    .line 83
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    .line 85
    .line 86
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 87
    .line 88
    .line 89
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 90
    .line 91
    .line 92
    move-result-object v4

    .line 93
    invoke-static {v3, v4}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    .line 95
    .line 96
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 97
    .line 98
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 99
    .line 100
    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->isPortMappingEnabled(Landroid/content/SharedPreferences;)Z

    .line 101
    .line 102
    .line 103
    move-result v0

    .line 104
    if-eqz v0, :cond_4

    .line 105
    .line 106
    new-instance v0, Lcom/emanuelef/remote_capture/model/PortMapping;

    .line 107
    .line 108
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/model/PortMapping;-><init>(Landroid/content/Context;)V

    .line 109
    .line 110
    .line 111
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/PortMapping;->iter()Ljava/util/Iterator;

    .line 112
    .line 113
    .line 114
    move-result-object v0

    .line 115
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 116
    .line 117
    .line 118
    move-result v4

    .line 119
    if-eqz v4, :cond_4

    .line 120
    .line 121
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 122
    .line 123
    .line 124
    move-result-object v4

    .line 125
    check-cast v4, Lcom/emanuelef/remote_capture/model/PortMapping$PortMap;

    .line 126
    .line 127
    iget-object v5, v4, Lcom/emanuelef/remote_capture/model/PortMapping$PortMap;->redirect_host:Ljava/lang/String;

    .line 128
    .line 129
    invoke-static {v5}, Lcom/emanuelef/remote_capture/Utils;->validateIpAddress(Ljava/lang/String;)Z

    .line 130
    .line 131
    .line 132
    move-result v6

    .line 133
    if-nez v6, :cond_3

    .line 134
    .line 135
    invoke-direct {p0, v5}, Lcom/emanuelef/remote_capture/CaptureService;->resolveHost(Ljava/lang/String;)Ljava/lang/String;

    .line 136
    .line 137
    .line 138
    move-result-object v6

    .line 139
    if-nez v6, :cond_2

    .line 140
    .line 141
    new-instance v0, Ljava/lang/StringBuilder;

    .line 142
    .line 143
    const-string v1, "Could not resolve port mapping host: "

    .line 144
    .line 145
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 146
    .line 147
    .line 148
    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 149
    .line 150
    .line 151
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 152
    .line 153
    .line 154
    move-result-object v0

    .line 155
    invoke-static {v3, v0}, Lcom/emanuelef/remote_capture/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    .line 157
    .line 158
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 159
    .line 160
    new-instance v1, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;

    .line 161
    .line 162
    const/4 v3, 0x1

    .line 163
    invoke-direct {v1, p0, v5, v3}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;-><init>(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;I)V

    .line 164
    .line 165
    .line 166
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 167
    .line 168
    .line 169
    return v2

    .line 170
    :cond_2
    new-instance v7, Ljava/lang/StringBuilder;

    .line 171
    .line 172
    const-string v8, "Resolved port mapping host: "

    .line 173
    .line 174
    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 175
    .line 176
    .line 177
    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 178
    .line 179
    .line 180
    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 181
    .line 182
    .line 183
    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 184
    .line 185
    .line 186
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 187
    .line 188
    .line 189
    move-result-object v5

    .line 190
    invoke-static {v3, v5}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    .line 192
    .line 193
    move-object v5, v6

    .line 194
    :cond_3
    iget v6, v4, Lcom/emanuelef/remote_capture/model/PortMapping$PortMap;->ipproto:I

    .line 195
    .line 196
    iget v7, v4, Lcom/emanuelef/remote_capture/model/PortMapping$PortMap;->orig_port:I

    .line 197
    .line 198
    iget v4, v4, Lcom/emanuelef/remote_capture/model/PortMapping$PortMap;->redirect_port:I

    .line 199
    .line 200
    invoke-static {v6, v7, v4, v5}, Lcom/emanuelef/remote_capture/CaptureService;->addPortMapping(IIILjava/lang/String;)V

    .line 201
    .line 202
    .line 203
    goto :goto_0

    .line 204
    :cond_4
    const/4 v0, 0x1

    .line 205
    return v0
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

.method public static native rootCmd(Ljava/lang/String;Ljava/lang/String;)I
.end method

.method private static native runPacketLoop(ILcom/emanuelef/remote_capture/CaptureService;I)V
.end method

.method private sendServiceStatus(Ljava/lang/String;)V
    .locals 1

    .line 1
    const-string v0, "started"

    .line 2
    .line 3
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    if-eqz p1, :cond_0

    .line 8
    .line 9
    sget-object p1, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;->STARTED:Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    .line 10
    .line 11
    goto :goto_0

    .line 12
    :cond_0
    sget-object p1, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;->STOPPED:Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    .line 13
    .line 14
    :goto_0
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->updateServiceStatus(Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V

    .line 15
    .line 16
    .line 17
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
.end method

.method private static native setDnsServer(Ljava/lang/String;)V
.end method

.method public static setFirewallEnabled(Z)V
    .locals 1

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    iput-boolean p0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mFirewallEnabled:Z

    .line 7
    .line 8
    invoke-static {p0}, Lcom/emanuelef/remote_capture/CaptureService;->nativeSetFirewallEnabled(Z)V

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
.end method

.method public static native setPayloadMode(I)V
.end method

.method private static native setPrivateDnsBlocked(Z)V
.end method

.method private setupNotifications()V
    .locals 9

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 2
    .line 3
    const/16 v1, 0x1a

    .line 4
    .line 5
    const-string v2, "Malware detection"

    .line 6
    .line 7
    const/4 v3, 0x2

    .line 8
    const/4 v4, 0x0

    .line 9
    const-string v5, "VPNService"

    .line 10
    .line 11
    if-lt v0, v1, :cond_0

    .line 12
    .line 13
    const-string v0, "notification"

    .line 14
    .line 15
    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    check-cast v0, Landroid/app/NotificationManager;

    .line 20
    .line 21
    new-instance v1, Landroid/app/NotificationChannel;

    .line 22
    .line 23
    invoke-direct {v1, v5, v5, v3}, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    .line 24
    .line 25
    .line 26
    invoke-virtual {v1, v4}, Landroid/app/NotificationChannel;->setShowBadge(Z)V

    .line 27
    .line 28
    .line 29
    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    .line 30
    .line 31
    .line 32
    new-instance v1, Landroid/app/NotificationChannel;

    .line 33
    .line 34
    const v1, 0x7f140183

    .line 35
    .line 36
    .line 37
    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object v1

    .line 41
    new-instance v6, Landroid/app/NotificationChannel;

    .line 42
    .line 43
    const/4 v7, 0x4

    .line 44
    invoke-direct {v6, v2, v1, v7}, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    .line 45
    .line 46
    .line 47
    invoke-virtual {v0, v6}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    .line 48
    .line 49
    .line 50
    new-instance v1, Landroid/app/NotificationChannel;

    .line 51
    .line 52
    const v1, 0x7f140225

    .line 53
    .line 54
    .line 55
    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 56
    .line 57
    .line 58
    move-result-object v1

    .line 59
    new-instance v6, Landroid/app/NotificationChannel;

    .line 60
    .line 61
    const-string v7, "Other"

    .line 62
    .line 63
    const/4 v8, 0x3

    .line 64
    invoke-direct {v6, v7, v1, v8}, Landroid/app/NotificationChannel;-><init>(Ljava/lang/String;Ljava/lang/CharSequence;I)V

    .line 65
    .line 66
    .line 67
    invoke-virtual {v0, v6}, Landroid/app/NotificationManager;->createNotificationChannel(Landroid/app/NotificationChannel;)V

    .line 68
    .line 69
    .line 70
    :cond_0
    new-instance v0, Landroid/content/Intent;

    .line 71
    .line 72
    const-class v1, Lcom/emanuelef/remote_capture/activities/MainActivity;

    .line 73
    .line 74
    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 75
    .line 76
    .line 77
    const/high16 v1, 0x8000000

    .line 78
    .line 79
    invoke-static {v1}, Lcom/emanuelef/remote_capture/Utils;->getIntentFlags(I)I

    .line 80
    .line 81
    .line 82
    move-result v1

    .line 83
    invoke-static {p0, v4, v0, v1}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    .line 84
    .line 85
    .line 86
    move-result-object v0

    .line 87
    new-instance v1, Landroidx/core/app/NotificationCompat$Builder;

    .line 88
    .line 89
    invoke-direct {v1, p0, v5}, Landroidx/core/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 90
    .line 91
    .line 92
    const v5, 0x7f0801ae

    .line 93
    .line 94
    .line 95
    iget-object v6, v1, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 96
    .line 97
    iput v5, v6, Landroid/app/Notification;->icon:I

    .line 98
    .line 99
    const v5, 0x7f060040

    .line 100
    .line 101
    .line 102
    invoke-static {p0, v5}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 103
    .line 104
    .line 105
    move-result v5

    .line 106
    iput v5, v1, Landroidx/core/app/NotificationCompat$Builder;->mColor:I

    .line 107
    .line 108
    iput-object v0, v1, Landroidx/core/app/NotificationCompat$Builder;->mContentIntent:Landroid/app/PendingIntent;

    .line 109
    .line 110
    const/4 v0, 0x1

    .line 111
    invoke-virtual {v1, v3, v0}, Landroidx/core/app/NotificationCompat$Builder;->setFlag(IZ)V

    .line 112
    .line 113
    .line 114
    const/16 v3, 0x10

    .line 115
    .line 116
    invoke-virtual {v1, v3, v4}, Landroidx/core/app/NotificationCompat$Builder;->setFlag(IZ)V

    .line 117
    .line 118
    .line 119
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 120
    .line 121
    .line 122
    move-result-object v4

    .line 123
    const v5, 0x7f140074

    .line 124
    .line 125
    .line 126
    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 127
    .line 128
    .line 129
    move-result-object v4

    .line 130
    invoke-static {v4}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 131
    .line 132
    .line 133
    move-result-object v4

    .line 134
    iput-object v4, v1, Landroidx/core/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    .line 135
    .line 136
    iput v0, v1, Landroidx/core/app/NotificationCompat$Builder;->mVisibility:I

    .line 137
    .line 138
    const-string v4, "status"

    .line 139
    .line 140
    iput-object v4, v1, Landroidx/core/app/NotificationCompat$Builder;->mCategory:Ljava/lang/String;

    .line 141
    .line 142
    const/4 v5, -0x1

    .line 143
    iput v5, v1, Landroidx/core/app/NotificationCompat$Builder;->mPriority:I

    .line 144
    .line 145
    iput-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mStatusBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 146
    .line 147
    new-instance v1, Landroidx/core/app/NotificationCompat$Builder;

    .line 148
    .line 149
    invoke-direct {v1, p0, v2}, Landroidx/core/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 150
    .line 151
    .line 152
    const v2, 0x7f0801c8

    .line 153
    .line 154
    .line 155
    iget-object v5, v1, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 156
    .line 157
    iput v2, v5, Landroid/app/Notification;->icon:I

    .line 158
    .line 159
    invoke-virtual {v1, v3, v0}, Landroidx/core/app/NotificationCompat$Builder;->setFlag(IZ)V

    .line 160
    .line 161
    .line 162
    iput v0, v1, Landroidx/core/app/NotificationCompat$Builder;->mVisibility:I

    .line 163
    .line 164
    iput-object v4, v1, Landroidx/core/app/NotificationCompat$Builder;->mCategory:Ljava/lang/String;

    .line 165
    .line 166
    iput v0, v1, Landroidx/core/app/NotificationCompat$Builder;->mPriority:I

    .line 167
    .line 168
    iput-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 169
    .line 170
    return-void
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

.method private signalServicesTermination()V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPendingUpdates:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 2
    .line 3
    new-instance v1, Landroid/util/Pair;

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v1, v2, v2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 7
    .line 8
    .line 9
    invoke-virtual {v0, v1}, Ljava/util/concurrent/LinkedBlockingDeque;->offer(Ljava/lang/Object;)Z

    .line 10
    .line 11
    .line 12
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->stopPcapDump()V

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

.method private stopAndJoinThreads()V
    .locals 4

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->signalServicesTermination()V

    .line 2
    .line 3
    .line 4
    const-string v0, "Joining threads..."

    .line 5
    .line 6
    const-string v1, "CaptureService"

    .line 7
    .line 8
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 9
    .line 10
    .line 11
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mConnUpdateThread:Ljava/lang/Thread;

    .line 12
    .line 13
    const/4 v2, 0x0

    .line 14
    if-eqz v0, :cond_0

    .line 15
    .line 16
    invoke-virtual {v0}, Ljava/lang/Thread;->isAlive()Z

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    if-eqz v0, :cond_0

    .line 21
    .line 22
    :try_start_0
    const-string v0, "Joining conn update thread..."

    .line 23
    .line 24
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mConnUpdateThread:Ljava/lang/Thread;

    .line 28
    .line 29
    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 30
    .line 31
    .line 32
    goto :goto_0

    .line 33
    :catch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPendingUpdates:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 34
    .line 35
    new-instance v3, Landroid/util/Pair;

    .line 36
    .line 37
    invoke-direct {v3, v2, v2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 38
    .line 39
    .line 40
    invoke-virtual {v0, v3}, Ljava/util/concurrent/LinkedBlockingDeque;->offer(Ljava/lang/Object;)Z

    .line 41
    .line 42
    .line 43
    goto :goto_0

    .line 44
    :cond_0
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mConnUpdateThread:Ljava/lang/Thread;

    .line 45
    .line 46
    :goto_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumperThread:Ljava/lang/Thread;

    .line 47
    .line 48
    if-eqz v0, :cond_1

    .line 49
    .line 50
    invoke-virtual {v0}, Ljava/lang/Thread;->isAlive()Z

    .line 51
    .line 52
    .line 53
    move-result v0

    .line 54
    if-eqz v0, :cond_1

    .line 55
    .line 56
    :try_start_1
    const-string v0, "Joining dumper thread..."

    .line 57
    .line 58
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    .line 60
    .line 61
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumperThread:Ljava/lang/Thread;

    .line 62
    .line 63
    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    .line 64
    .line 65
    .line 66
    goto :goto_1

    .line 67
    :catch_1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->stopPcapDump()V

    .line 68
    .line 69
    .line 70
    goto :goto_1

    .line 71
    :cond_1
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumperThread:Ljava/lang/Thread;

    .line 72
    .line 73
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 74
    .line 75
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMitmReceiver:Lcom/emanuelef/remote_capture/MitmReceiver;

    .line 76
    .line 77
    if-eqz v0, :cond_2

    .line 78
    .line 79
    :try_start_2
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/MitmReceiver;->stop()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    .line 80
    .line 81
    .line 82
    goto :goto_2

    .line 83
    :catch_2
    move-exception v0

    .line 84
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 85
    .line 86
    .line 87
    :goto_2
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMitmReceiver:Lcom/emanuelef/remote_capture/MitmReceiver;

    .line 88
    .line 89
    :cond_2
    return-void
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

.method private static native stopPacketLoop()V
.end method

.method public static stopService()V
    .locals 4

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 2
    .line 3
    new-instance v1, Ljava/lang/StringBuilder;

    .line 4
    .line 5
    const-string v2, "stopService called (instance? "

    .line 6
    .line 7
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 8
    .line 9
    .line 10
    const/4 v2, 0x1

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    const/4 v3, 0x1

    .line 14
    goto :goto_0

    .line 15
    :cond_0
    const/4 v3, 0x0

    .line 16
    :goto_0
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 17
    .line 18
    .line 19
    const-string v3, ")"

    .line 20
    .line 21
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 22
    .line 23
    .line 24
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v1

    .line 28
    const-string v3, "CaptureService"

    .line 29
    .line 30
    invoke-static {v3, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    .line 32
    .line 33
    if-nez v0, :cond_1

    .line 34
    .line 35
    return-void

    .line 36
    :cond_1
    iput-boolean v2, v0, Lcom/emanuelef/remote_capture/CaptureService;->mStopping:Z

    .line 37
    .line 38
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopPacketLoop()V

    .line 39
    .line 40
    .line 41
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 42
    .line 43
    const/16 v3, 0x18

    .line 44
    .line 45
    if-lt v1, v3, :cond_2

    .line 46
    .line 47
    invoke-virtual {v0, v2}, Landroid/net/VpnService;->stopForeground(I)V

    .line 48
    .line 49
    .line 50
    goto :goto_1

    .line 51
    :cond_2
    invoke-virtual {v0, v2}, Landroid/app/Service;->stopForeground(Z)V

    .line 52
    .line 53
    .line 54
    :goto_1
    invoke-virtual {v0}, Landroid/app/Service;->stopSelf()V

    .line 55
    .line 56
    .line 57
    return-void
    .line 58
.end method

.method private unregisterNetworkCallbacks()V
    .locals 4

    .line 1
    const-string v0, "CaptureService"

    .line 2
    .line 3
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    const-string v1, "connectivity"

    .line 8
    .line 9
    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    check-cast v1, Landroid/net/ConnectivityManager;

    .line 14
    .line 15
    :try_start_0
    const-string v2, "unregisterNetworkCallback"

    .line 16
    .line 17
    invoke-static {v0, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 21
    .line 22
    invoke-virtual {v1, v2}, Landroid/net/ConnectivityManager;->unregisterNetworkCallback(Landroid/net/ConnectivityManager$NetworkCallback;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 23
    .line 24
    .line 25
    goto :goto_0

    .line 26
    :catch_0
    move-exception v1

    .line 27
    new-instance v2, Ljava/lang/StringBuilder;

    .line 28
    .line 29
    const-string v3, "unregisterNetworkCallback failed: "

    .line 30
    .line 31
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 35
    .line 36
    .line 37
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object v1

    .line 41
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    .line 43
    .line 44
    :goto_0
    const/4 v0, 0x0

    .line 45
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNetworkCallback:Landroid/net/ConnectivityManager$NetworkCallback;

    .line 46
    .line 47
    :cond_0
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
.end method

.method private updateBlacklistsWork()V
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklistsUpdateRequested:Z

    .line 3
    .line 4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 5
    .line 6
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Blacklists;->update()V

    .line 7
    .line 8
    .line 9
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->reloadBlacklists()V

    .line 10
    .line 11
    .line 12
    const/4 v0, 0x0

    .line 13
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklistsUpdateThread:Ljava/lang/Thread;

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

.method private updateNotification()V
    .locals 3

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mStopping:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->getStatusNotification()Landroid/app/Notification;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    new-instance v1, Landroidx/core/app/NotificationManagerCompat;

    .line 11
    .line 12
    invoke-direct {v1, p0}, Landroidx/core/app/NotificationManagerCompat;-><init>(Landroid/content/Context;)V

    .line 13
    .line 14
    .line 15
    const/4 v2, 0x1

    .line 16
    invoke-virtual {v1, v2, v0}, Landroidx/core/app/NotificationManagerCompat;->notify(ILandroid/app/Notification;)V

    .line 17
    .line 18
    .line 19
    return-void
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

.method private updateServiceStatus(Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;)V
    .locals 2

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->serviceStatus:Landroidx/lifecycle/MutableLiveData;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 4
    .line 5
    .line 6
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;->STARTED:Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    .line 7
    .line 8
    if-ne p1, v0, :cond_2

    .line 9
    .line 10
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareDetectionEnabled:Z

    .line 11
    .line 12
    if-eqz p1, :cond_0

    .line 13
    .line 14
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->reloadMalwareWhitelist()V

    .line 15
    .line 16
    .line 17
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 18
    .line 19
    if-eqz p1, :cond_1

    .line 20
    .line 21
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->reloadDecryptionList()V

    .line 22
    .line 23
    .line 24
    :cond_1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->reloadBlocklist()V

    .line 25
    .line 26
    .line 27
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->reloadFirewallWhitelist()V

    .line 28
    .line 29
    .line 30
    return-void

    .line 31
    :cond_2
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;->STOPPED:Lcom/emanuelef/remote_capture/CaptureService$ServiceStatus;

    .line 32
    .line 33
    if-ne p1, v0, :cond_4

    .line 34
    .line 35
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mRevoked:Z

    .line 36
    .line 37
    if-eqz p1, :cond_4

    .line 38
    .line 39
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 40
    .line 41
    invoke-static {p1}, Lcom/emanuelef/remote_capture/model/Prefs;->restartOnDisconnect(Landroid/content/SharedPreferences;)Z

    .line 42
    .line 43
    .line 44
    move-result p1

    .line 45
    if-eqz p1, :cond_4

    .line 46
    .line 47
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 48
    .line 49
    if-nez p1, :cond_4

    .line 50
    .line 51
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->isVpnCapture()I

    .line 52
    .line 53
    .line 54
    move-result p1

    .line 55
    const/4 v0, 0x1

    .line 56
    if-ne p1, v0, :cond_4

    .line 57
    .line 58
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 59
    .line 60
    const/16 v0, 0x17

    .line 61
    .line 62
    if-lt p1, v0, :cond_4

    .line 63
    .line 64
    const-string v0, "CaptureService"

    .line 65
    .line 66
    const-string v1, "VPN disconnected, starting reconnect service"

    .line 67
    .line 68
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    .line 70
    .line 71
    new-instance v0, Landroid/content/Intent;

    .line 72
    .line 73
    const-class v1, Lcom/emanuelef/remote_capture/VpnReconnectService;

    .line 74
    .line 75
    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 76
    .line 77
    .line 78
    const/16 v1, 0x1a

    .line 79
    .line 80
    if-lt p1, v1, :cond_3

    .line 81
    .line 82
    invoke-static {p0, v0}, Landroidx/core/content/ContextCompat$Api26Impl;->startForegroundService(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 83
    .line 84
    .line 85
    return-void

    .line 86
    :cond_3
    invoke-virtual {p0, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 87
    .line 88
    .line 89
    :cond_4
    return-void
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

.method public static waitForCaptureStop()V
    .locals 3

    .line 1
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

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
    const-string v1, "waitForCaptureStop "

    .line 9
    .line 10
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    invoke-virtual {v1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 22
    .line 23
    .line 24
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v0

    .line 28
    const-string v1, "CaptureService"

    .line 29
    .line 30
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    .line 32
    .line 33
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 34
    .line 35
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 36
    .line 37
    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 38
    .line 39
    .line 40
    :catch_0
    :goto_0
    :try_start_0
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 41
    .line 42
    iget-object v2, v0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureThread:Ljava/lang/Thread;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 43
    .line 44
    if-eqz v2, :cond_1

    .line 45
    .line 46
    :try_start_1
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureStopped:Ljava/util/concurrent/locks/Condition;

    .line 47
    .line 48
    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->await()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 49
    .line 50
    .line 51
    goto :goto_0

    .line 52
    :cond_1
    iget-object v0, v0, Lcom/emanuelef/remote_capture/CaptureService;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 53
    .line 54
    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 55
    .line 56
    .line 57
    new-instance v0, Ljava/lang/StringBuilder;

    .line 58
    .line 59
    const-string v2, "waitForCaptureStop done "

    .line 60
    .line 61
    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 62
    .line 63
    .line 64
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    .line 65
    .line 66
    .line 67
    move-result-object v2

    .line 68
    invoke-virtual {v2}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    .line 69
    .line 70
    .line 71
    move-result-object v2

    .line 72
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 73
    .line 74
    .line 75
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object v0

    .line 79
    invoke-static {v1, v0}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    .line 81
    .line 82
    return-void

    .line 83
    :catchall_0
    move-exception v0

    .line 84
    sget-object v1, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 85
    .line 86
    iget-object v1, v1, Lcom/emanuelef/remote_capture/CaptureService;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 87
    .line 88
    invoke-virtual {v1}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 89
    .line 90
    .line 91
    throw v0
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

.method public static native writeLog(IILjava/lang/String;)I
.end method


# virtual methods
.method public attachBaseContext(Landroid/content/Context;)V
    .locals 1

    .line 1
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->getLocalizedConfig(Landroid/content/Context;)Landroid/content/res/Configuration;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {p1, v0}, Landroid/content/Context;->createConfigurationContext(Landroid/content/res/Configuration;)Landroid/content/Context;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-super {p0, p1}, Landroid/net/VpnService;->attachBaseContext(Landroid/content/Context;)V

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

.method public dumpExtensionsEnabled()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_extensions:Z

    .line 4
    .line 5
    return v0
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
    .line 58
.end method

.method public dumpPcapData([B)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    array-length v0, p1

    .line 6
    if-lez v0, :cond_0

    .line 7
    .line 8
    :catch_0
    :try_start_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumpQueue:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 9
    .line 10
    invoke-virtual {v0, p1}, Ljava/util/concurrent/LinkedBlockingDeque;->put(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 11
    .line 12
    .line 13
    :cond_0
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

.method public firewallEnabled()I
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mFirewallEnabled:Z

    .line 2
    .line 3
    return v0
    .line 4
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
    .line 58
.end method

.method public getAppFilterUids()[I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mAppFilterUids:[I

    .line 2
    .line 3
    return-object v0
    .line 4
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
    .line 58
.end method

.method public getApplicationByUid(I)Ljava/lang/String;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNativeAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-virtual {v0, p1, v1}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 5
    .line 6
    .line 7
    move-result-object p1

    .line 8
    if-nez p1, :cond_0

    .line 9
    .line 10
    const-string p1, ""

    .line 11
    .line 12
    return-object p1

    .line 13
    :cond_0
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getName()Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    return-object p1
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

.method public getBlacklistsInfo()[Lcom/emanuelef/remote_capture/model/BlacklistDescriptor;
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Blacklists;->getNumBlacklists()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    new-array v0, v0, [Lcom/emanuelef/remote_capture/model/BlacklistDescriptor;

    .line 8
    .line 9
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 10
    .line 11
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/Blacklists;->iter()Ljava/util/Iterator;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    const/4 v2, 0x0

    .line 16
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    .line 17
    .line 18
    .line 19
    move-result v3

    .line 20
    if-eqz v3, :cond_0

    .line 21
    .line 22
    add-int/lit8 v3, v2, 0x1

    .line 23
    .line 24
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 25
    .line 26
    .line 27
    move-result-object v4

    .line 28
    check-cast v4, Lcom/emanuelef/remote_capture/model/BlacklistDescriptor;

    .line 29
    .line 30
    aput-object v4, v0, v2

    .line 31
    .line 32
    move v2, v3

    .line 33
    goto :goto_0

    .line 34
    :cond_0
    return-object v0
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

.method public getBlockQuickMode()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->block_quic_mode:Lcom/emanuelef/remote_capture/model/Prefs$BlockQuicMode;

    .line 4
    .line 5
    invoke-virtual {v0}, Ljava/lang/Enum;->ordinal()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    return v0
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

.method public getCaptureInterface()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->capture_interface:Ljava/lang/String;

    .line 4
    .line 5
    return-object v0
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
    .line 58
.end method

.method public getCountryCode(Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNativeGeolocation:Lcom/emanuelef/remote_capture/Geolocation;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Geolocation;->isAvailable()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    :try_start_0
    invoke-static {p1}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNativeGeolocation:Lcom/emanuelef/remote_capture/Geolocation;

    .line 14
    .line 15
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/Geolocation;->getCountryCode(Ljava/net/InetAddress;)Ljava/lang/String;

    .line 16
    .line 17
    .line 18
    move-result-object p1
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0

    .line 19
    return-object p1

    .line 20
    :catch_0
    :cond_0
    const-string p1, ""

    .line 21
    .line 22
    return-object p1
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

.method public getDnsServer()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
    .line 4
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
    .line 58
.end method

.method public getIPv4Enabled()I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->ip_mode:Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

    .line 4
    .line 5
    sget-object v1, Lcom/emanuelef/remote_capture/model/Prefs$IpMode;->IPV6_ONLY:Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

    .line 6
    .line 7
    if-eq v0, v1, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

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

.method public getIPv6Enabled()I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->ip_mode:Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

    .line 4
    .line 5
    sget-object v1, Lcom/emanuelef/remote_capture/model/Prefs$IpMode;->IPV4_ONLY:Lcom/emanuelef/remote_capture/model/Prefs$IpMode;

    .line 6
    .line 7
    if-eq v0, v1, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

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

.method public getIpv6DnsServer()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->getDnsServerV6(Landroid/content/SharedPreferences;)Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public getLibprogPath(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/CaptureService;->getLibprogPath(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public getMaxDumpSize()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->max_dump_size:I

    .line 4
    .line 5
    return v0
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
    .line 58
.end method

.method public getMaxPktsPerFlow()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->max_pkts_per_flow:I

    .line 4
    .line 5
    return v0
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
    .line 58
.end method

.method public getMitmAddonUid()I
    .locals 1

    .line 1
    invoke-static {p0}, Lcom/emanuelef/remote_capture/MitmAddon;->getUid(Landroid/content/Context;)I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    return v0
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
    .line 58
.end method

.method public getPackageNameByUid(I)Ljava/lang/String;
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNativeAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-virtual {v0, p1, v1}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 5
    .line 6
    .line 7
    move-result-object p1

    .line 8
    if-nez p1, :cond_0

    .line 9
    .line 10
    const-string p1, ""

    .line 11
    .line 12
    return-object p1

    .line 13
    :cond_0
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    return-object p1
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

.method public getPayloadMode()I
    .locals 1

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getCurPayloadMode()Lcom/emanuelef/remote_capture/model/Prefs$PayloadMode;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Ljava/lang/Enum;->ordinal()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    return v0
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

.method public getPcapDumperBpf()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-interface {v0}, Lcom/emanuelef/remote_capture/interfaces/PcapDumper;->getBpf()Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    return-object v0

    .line 10
    :cond_0
    const-string v0, ""

    .line 11
    .line 12
    return-object v0
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

.method public getPersistentDir()Ljava/lang/String;
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    return-object v0
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

.method public getSnaplen()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->snaplen:I

    .line 4
    .line 5
    return v0
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
    .line 58
.end method

.method public getSocks5Enabled()I
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Enabled:Z

    .line 2
    .line 3
    return v0
    .line 4
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
    .line 58
.end method

.method public getSocks5ProxyAddress()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
    .line 4
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
    .line 58
.end method

.method public getSocks5ProxyAuth()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Auth:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
    .line 4
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
    .line 58
.end method

.method public getSocks5ProxyPort()I
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Port:I

    .line 2
    .line 3
    return v0
    .line 4
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
    .line 58
.end method

.method public getUidQ(ILjava/lang/String;ILjava/lang/String;I)I
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0x1d
    .end annotation

    .line 1
    const/4 v0, 0x6

    .line 2
    const/4 v1, -0x1

    .line 3
    if-eq p1, v0, :cond_0

    .line 4
    .line 5
    const/16 v0, 0x11

    .line 6
    .line 7
    if-eq p1, v0, :cond_0

    .line 8
    .line 9
    return v1

    .line 10
    :cond_0
    const-string v0, "connectivity"

    .line 11
    .line 12
    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    check-cast v0, Landroid/net/ConnectivityManager;

    .line 17
    .line 18
    if-nez v0, :cond_1

    .line 19
    .line 20
    return v1

    .line 21
    :cond_1
    new-instance v1, Ljava/net/InetSocketAddress;

    .line 22
    .line 23
    invoke-direct {v1, p2, p3}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V

    .line 24
    .line 25
    .line 26
    new-instance p2, Ljava/net/InetSocketAddress;

    .line 27
    .line 28
    invoke-direct {p2, p4, p5}, Ljava/net/InetSocketAddress;-><init>(Ljava/lang/String;I)V

    .line 29
    .line 30
    .line 31
    new-instance p3, Ljava/lang/StringBuilder;

    .line 32
    .line 33
    const-string p4, "Get uid local="

    .line 34
    .line 35
    invoke-direct {p3, p4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 36
    .line 37
    .line 38
    invoke-virtual {p3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 39
    .line 40
    .line 41
    const-string p4, " remote="

    .line 42
    .line 43
    invoke-virtual {p3, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 44
    .line 45
    .line 46
    invoke-virtual {p3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 47
    .line 48
    .line 49
    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 50
    .line 51
    .line 52
    move-result-object p3

    .line 53
    const-string p4, "CaptureService"

    .line 54
    .line 55
    invoke-static {p4, p3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    .line 57
    .line 58
    invoke-virtual {v0, p1, v1, p2}, Landroid/net/ConnectivityManager;->getConnectionOwnerUid(ILjava/net/InetSocketAddress;Ljava/net/InetSocketAddress;)I

    .line 59
    .line 60
    .line 61
    move-result p1

    .line 62
    return p1
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
.end method

.method public getVpnDns()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->vpn_dns:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
    .line 4
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
    .line 58
.end method

.method public getVpnIPv4()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->vpn_ipv4:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
    .line 4
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
    .line 58
.end method

.method public getVpnMTU()I
    .locals 1

    const/16 v0, 0x2710

    return v0
.end method

.method public getWorkingDir()Ljava/lang/String;
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    return-object v0
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

.method public isPcapFileCapture()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->readFromPcap()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
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

.method public isPcapngEnabled()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcapng_format:Z

    .line 4
    .line 5
    return v0
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
    .line 58
.end method

.method public isRootCapture()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 4
    .line 5
    return v0
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
    .line 58
.end method

.method public isTlsDecryptionEnabled()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 4
    .line 5
    return v0
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
    .line 58
.end method

.method public isVpnCapture()I
    .locals 2

    .line 1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->isRootCapture()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->isPcapFileCapture()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    or-int/2addr v0, v1

    .line 10
    const/4 v1, 0x1

    .line 11
    if-ne v0, v1, :cond_0

    .line 12
    .line 13
    const/4 v0, 0x0

    .line 14
    return v0

    .line 15
    :cond_0
    return v1
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

.method public loadUidMapping(ILjava/lang/String;Ljava/lang/String;)V
    .locals 2

    .line 1
    if-gez p1, :cond_0

    .line 2
    .line 3
    goto :goto_0

    .line 4
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNativeAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 5
    .line 6
    const/4 v1, 0x0

    .line 7
    invoke-virtual {v0, p1, v1}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    if-eqz v0, :cond_2

    .line 12
    .line 13
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    if-nez v0, :cond_1

    .line 22
    .line 23
    goto :goto_1

    .line 24
    :cond_1
    :goto_0
    return-void

    .line 25
    :cond_2
    :goto_1
    invoke-static {p1, p2, p3}, Lcom/emanuelef/remote_capture/AppsResolver;->addMappedApp(ILjava/lang/String;Ljava/lang/String;)V

    .line 26
    .line 27
    .line 28
    return-void
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

.method public malwareDetectionEnabled()I
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareDetectionEnabled:Z

    .line 2
    .line 3
    return v0
    .line 4
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
    .line 58
.end method

.method public notifyBlacklistedConnection(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 7

    .line 1
    iget v0, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 2
    .line 3
    new-instance v1, Lcom/emanuelef/remote_capture/AppsResolver;

    .line 4
    .line 5
    invoke-direct {v1, p0}, Lcom/emanuelef/remote_capture/AppsResolver;-><init>(Landroid/content/Context;)V

    .line 6
    .line 7
    .line 8
    iget v2, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 9
    .line 10
    const/4 v3, 0x0

    .line 11
    invoke-virtual {v1, v2, v3}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    if-nez v1, :cond_0

    .line 16
    .line 17
    return-void

    .line 18
    :cond_0
    new-instance v2, Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 19
    .line 20
    invoke-direct {v2}, Lcom/emanuelef/remote_capture/model/FilterDescriptor;-><init>()V

    .line 21
    .line 22
    .line 23
    const/4 v4, 0x1

    .line 24
    iput-boolean v4, v2, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->onlyBlacklisted:Z

    .line 25
    .line 26
    new-instance v5, Landroid/content/Intent;

    .line 27
    .line 28
    const-class v6, Lcom/emanuelef/remote_capture/activities/ConnectionsActivity;

    .line 29
    .line 30
    invoke-direct {v5, p0, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 31
    .line 32
    .line 33
    const-string v6, "filter"

    .line 34
    .line 35
    invoke-virtual {v5, v6, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 36
    .line 37
    .line 38
    move-result-object v2

    .line 39
    const-string v5, "query"

    .line 40
    .line 41
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 42
    .line 43
    .line 44
    move-result-object v6

    .line 45
    invoke-virtual {v2, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 46
    .line 47
    .line 48
    move-result-object v2

    .line 49
    const/high16 v5, 0x8000000

    .line 50
    .line 51
    invoke-static {v5}, Lcom/emanuelef/remote_capture/Utils;->getIntentFlags(I)I

    .line 52
    .line 53
    .line 54
    move-result v5

    .line 55
    invoke-static {p0, v3, v2, v5}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    .line 56
    .line 57
    .line 58
    move-result-object v2

    .line 59
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isBlacklistedHost()Z

    .line 60
    .line 61
    .line 62
    move-result v5

    .line 63
    if-eqz v5, :cond_1

    .line 64
    .line 65
    sget-object v5, Lcom/emanuelef/remote_capture/model/MatchList$RuleType;->HOST:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 66
    .line 67
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 68
    .line 69
    invoke-static {p0, v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->getRuleLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)Ljava/lang/String;

    .line 70
    .line 71
    .line 72
    move-result-object p1

    .line 73
    goto :goto_0

    .line 74
    :cond_1
    sget-object v5, Lcom/emanuelef/remote_capture/model/MatchList$RuleType;->IP:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 75
    .line 76
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 77
    .line 78
    invoke-static {p0, v5, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->getRuleLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)Ljava/lang/String;

    .line 79
    .line 80
    .line 81
    move-result-object p1

    .line 82
    :goto_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 83
    .line 84
    .line 85
    move-result-object v5

    .line 86
    const v6, 0x7f14017f

    .line 87
    .line 88
    .line 89
    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 90
    .line 91
    .line 92
    move-result-object v5

    .line 93
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getName()Ljava/lang/String;

    .line 94
    .line 95
    .line 96
    move-result-object v1

    .line 97
    const/4 v6, 0x2

    .line 98
    new-array v6, v6, [Ljava/lang/Object;

    .line 99
    .line 100
    aput-object v1, v6, v3

    .line 101
    .line 102
    aput-object p1, v6, v4

    .line 103
    .line 104
    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 105
    .line 106
    .line 107
    move-result-object p1

    .line 108
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 109
    .line 110
    iput-object v2, v1, Landroidx/core/app/NotificationCompat$Builder;->mContentIntent:Landroid/app/PendingIntent;

    .line 111
    .line 112
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 113
    .line 114
    .line 115
    move-result-wide v4

    .line 116
    iget-object v2, v1, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 117
    .line 118
    iput-wide v4, v2, Landroid/app/Notification;->when:J

    .line 119
    .line 120
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 121
    .line 122
    .line 123
    move-result-object v2

    .line 124
    const v4, 0x7f140183

    .line 125
    .line 126
    .line 127
    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 128
    .line 129
    .line 130
    move-result-object v2

    .line 131
    invoke-static {v2}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 132
    .line 133
    .line 134
    move-result-object v2

    .line 135
    iput-object v2, v1, Landroidx/core/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    .line 136
    .line 137
    new-instance v2, Lcom/android/billingclient/api/zzcl;

    .line 138
    .line 139
    const/4 v4, 0x6

    .line 140
    invoke-direct {v2, v4, v3}, Lcom/android/billingclient/api/zzcl;-><init>(IZ)V

    .line 141
    .line 142
    .line 143
    invoke-static {p1}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 144
    .line 145
    .line 146
    move-result-object v4

    .line 147
    iput-object v4, v2, Lcom/android/billingclient/api/zzcl;->zzc:Ljava/lang/Object;

    .line 148
    .line 149
    invoke-virtual {v1, v2}, Landroidx/core/app/NotificationCompat$Builder;->setStyle(Lcom/android/billingclient/api/zzcl;)V

    .line 150
    .line 151
    .line 152
    invoke-static {p1}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 153
    .line 154
    .line 155
    move-result-object p1

    .line 156
    iput-object p1, v1, Landroidx/core/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    .line 157
    .line 158
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 159
    .line 160
    invoke-virtual {p1}, Landroidx/core/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    .line 161
    .line 162
    .line 163
    move-result-object p1

    .line 164
    iget-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 165
    .line 166
    new-instance v2, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;

    .line 167
    .line 168
    invoke-direct {v2, v0, v3, p0, p1}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda8;-><init>(IILjava/lang/Object;Ljava/lang/Object;)V

    .line 169
    .line 170
    .line 171
    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 172
    .line 173
    .line 174
    return-void
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

.method public notifyBlacklistsLoaded([Lcom/emanuelef/remote_capture/Blacklists$NativeBlacklistStatus;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 2
    .line 3
    new-instance v1, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;

    .line 4
    .line 5
    const/4 v2, 0x3

    .line 6
    invoke-direct {v1, p0, v2, p1}, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

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

.method public notifyLowMemory(Ljava/lang/CharSequence;)V
    .locals 4

    .line 1
    new-instance v0, Landroidx/core/app/NotificationCompat$Builder;

    .line 2
    .line 3
    const-string v1, "Other"

    .line 4
    .line 5
    invoke-direct {v0, p0, v1}, Landroidx/core/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/16 v1, 0x10

    .line 9
    .line 10
    const/4 v2, 0x1

    .line 11
    invoke-virtual {v0, v1, v2}, Landroidx/core/app/NotificationCompat$Builder;->setFlag(IZ)V

    .line 12
    .line 13
    .line 14
    const v1, 0x7f0801ae

    .line 15
    .line 16
    .line 17
    iget-object v3, v0, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 18
    .line 19
    iput v1, v3, Landroid/app/Notification;->icon:I

    .line 20
    .line 21
    const v1, 0x7f060040

    .line 22
    .line 23
    .line 24
    invoke-static {p0, v1}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 25
    .line 26
    .line 27
    move-result v1

    .line 28
    iput v1, v0, Landroidx/core/app/NotificationCompat$Builder;->mColor:I

    .line 29
    .line 30
    iput v2, v0, Landroidx/core/app/NotificationCompat$Builder;->mVisibility:I

    .line 31
    .line 32
    const-string v1, "status"

    .line 33
    .line 34
    iput-object v1, v0, Landroidx/core/app/NotificationCompat$Builder;->mCategory:Ljava/lang/String;

    .line 35
    .line 36
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 37
    .line 38
    .line 39
    move-result-wide v1

    .line 40
    iget-object v3, v0, Landroidx/core/app/NotificationCompat$Builder;->mNotification:Landroid/app/Notification;

    .line 41
    .line 42
    iput-wide v1, v3, Landroid/app/Notification;->when:J

    .line 43
    .line 44
    const v1, 0x7f14016c

    .line 45
    .line 46
    .line 47
    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 48
    .line 49
    .line 50
    move-result-object v1

    .line 51
    invoke-static {v1}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 52
    .line 53
    .line 54
    move-result-object v1

    .line 55
    iput-object v1, v0, Landroidx/core/app/NotificationCompat$Builder;->mContentTitle:Ljava/lang/CharSequence;

    .line 56
    .line 57
    invoke-static {p1}, Landroidx/core/app/NotificationCompat$Builder;->limitCharSequenceLength(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 58
    .line 59
    .line 60
    move-result-object p1

    .line 61
    iput-object p1, v0, Landroidx/core/app/NotificationCompat$Builder;->mContentText:Ljava/lang/CharSequence;

    .line 62
    .line 63
    invoke-virtual {v0}, Landroidx/core/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    .line 64
    .line 65
    .line 66
    move-result-object p1

    .line 67
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 68
    .line 69
    new-instance v1, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;

    .line 70
    .line 71
    const/4 v2, 0x2

    .line 72
    invoke-direct {v1, p0, v2, p1}, Lcom/emanuelef/remote_capture/Utils$$ExternalSyntheticLambda3;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 73
    .line 74
    .line 75
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 76
    .line 77
    .line 78
    return-void
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

.method public onCreate()V
    .locals 2

    .line 1
    const-string v0, "CaptureService"

    .line 2
    .line 3
    const-string v1, "onCreate"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-static {}, Lcom/emanuelef/remote_capture/AppsResolver;->clearMappedApps()V

    .line 9
    .line 10
    .line 11
    new-instance v0, Lcom/emanuelef/remote_capture/AppsResolver;

    .line 12
    .line 13
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/AppsResolver;-><init>(Landroid/content/Context;)V

    .line 14
    .line 15
    .line 16
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNativeAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 17
    .line 18
    new-instance v0, Lcom/emanuelef/remote_capture/Geolocation;

    .line 19
    .line 20
    invoke-direct {v0, p0}, Lcom/emanuelef/remote_capture/Geolocation;-><init>(Landroid/content/Context;)V

    .line 21
    .line 22
    .line 23
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNativeGeolocation:Lcom/emanuelef/remote_capture/Geolocation;

    .line 24
    .line 25
    invoke-static {p0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferencesName(Landroid/content/Context;)Ljava/lang/String;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    const/4 v1, 0x0

    .line 30
    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    .line 31
    .line 32
    .line 33
    move-result-object v0

    .line 34
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 35
    .line 36
    new-instance v1, Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 37
    .line 38
    invoke-direct {v1, p0, v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;-><init>(Landroid/content/Context;Landroid/content/SharedPreferences;)V

    .line 39
    .line 40
    .line 41
    iput-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 42
    .line 43
    sput-object p0, Lcom/emanuelef/remote_capture/CaptureService;->INSTANCE:Lcom/emanuelef/remote_capture/CaptureService;

    .line 44
    .line 45
    invoke-super {p0}, Landroid/net/VpnService;->onCreate()V

    .line 46
    .line 47
    .line 48
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

.method public onDestroy()V
    .locals 2

    .line 1
    const-string v0, "CaptureService"

    .line 2
    .line 3
    const-string v1, "onDestroy"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->unregisterNetworkCallbacks()V

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 12
    .line 13
    if-eqz v0, :cond_0

    .line 14
    .line 15
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Blacklists;->abortUpdate()V

    .line 16
    .line 17
    .line 18
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureThread:Ljava/lang/Thread;

    .line 19
    .line 20
    if-eqz v0, :cond_1

    .line 21
    .line 22
    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 23
    .line 24
    .line 25
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklistsUpdateThread:Ljava/lang/Thread;

    .line 26
    .line 27
    if-eqz v0, :cond_2

    .line 28
    .line 29
    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 30
    .line 31
    .line 32
    :cond_2
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNewAppsInstallReceiver:Landroid/content/BroadcastReceiver;

    .line 33
    .line 34
    if-eqz v0, :cond_3

    .line 35
    .line 36
    invoke-virtual {p0, v0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 37
    .line 38
    .line 39
    const/4 v0, 0x0

    .line 40
    iput-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNewAppsInstallReceiver:Landroid/content/BroadcastReceiver;

    .line 41
    .line 42
    :cond_3
    invoke-super {p0}, Landroid/net/VpnService;->onDestroy()V

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
    .line 58
.end method

.method public onRevoke()V
    .locals 2

    .line 1
    const-string v0, "CaptureService"

    .line 2
    .line 3
    const-string v1, "onRevoke"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x1

    .line 9
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mRevoked:Z

    .line 10
    .line 11
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopService()V

    .line 12
    .line 13
    .line 14
    invoke-super {p0}, Landroid/net/VpnService;->onRevoke()V

    .line 15
    .line 16
    .line 17
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

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 7

    .line 1
    const/4 p2, 0x0

    .line 2
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mStopping:Z

    .line 3
    .line 4
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->setupNotifications()V

    .line 5
    .line 6
    .line 7
    sget p3, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 8
    .line 9
    const/16 v0, 0x22

    .line 10
    .line 11
    const/4 v1, 0x1

    .line 12
    if-lt p3, v0, :cond_0

    .line 13
    .line 14
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->getStatusNotification()Landroid/app/Notification;

    .line 15
    .line 16
    .line 17
    move-result-object p3

    .line 18
    const/high16 v0, 0x40000000    # 2.0f

    .line 19
    .line 20
    invoke-virtual {p0, v1, p3, v0}, Landroid/net/VpnService;->startForeground(ILandroid/app/Notification;I)V

    .line 21
    .line 22
    .line 23
    goto :goto_0

    .line 24
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->getStatusNotification()Landroid/app/Notification;

    .line 25
    .line 26
    .line 27
    move-result-object p3

    .line 28
    invoke-virtual {p0, v1, p3}, Landroid/app/Service;->startForeground(ILandroid/app/Notification;)V

    .line 29
    .line 30
    .line 31
    :goto_0
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureThread:Ljava/lang/Thread;

    .line 32
    .line 33
    const-string v0, "CaptureService"

    .line 34
    .line 35
    if-eqz p3, :cond_1

    .line 36
    .line 37
    const-string p1, "Restarting the capture is not supported"

    .line 38
    .line 39
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    .line 41
    .line 42
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->abortStart()I

    .line 43
    .line 44
    .line 45
    move-result p1

    .line 46
    return p1

    .line 47
    :cond_1
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->isAvailable()Z

    .line 48
    .line 49
    .line 50
    move-result p3

    .line 51
    if-eqz p3, :cond_2

    .line 52
    .line 53
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->stopService()V

    .line 54
    .line 55
    .line 56
    :cond_2
    new-instance p3, Landroid/os/Handler;

    .line 57
    .line 58
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    .line 59
    .line 60
    .line 61
    move-result-object v2

    .line 62
    invoke-direct {p3, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 63
    .line 64
    .line 65
    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 66
    .line 67
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Billing;->newInstance(Landroid/content/Context;)Lcom/emanuelef/remote_capture/PlayBilling;

    .line 68
    .line 69
    .line 70
    move-result-object p3

    .line 71
    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBilling:Lcom/emanuelef/remote_capture/Billing;

    .line 72
    .line 73
    const-string p3, "onStartCommand"

    .line 74
    .line 75
    invoke-static {v0, p3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    .line 77
    .line 78
    const/4 p3, 0x0

    .line 79
    if-nez p1, :cond_3

    .line 80
    .line 81
    move-object v2, p3

    .line 82
    goto :goto_1

    .line 83
    :cond_3
    const-string v2, "settings"

    .line 84
    .line 85
    const-class v3, Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 86
    .line 87
    invoke-static {p1, v2, v3}, Lcom/emanuelef/remote_capture/Utils;->getSerializableExtra(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Class;)Ljava/io/Serializable;

    .line 88
    .line 89
    .line 90
    move-result-object v2

    .line 91
    check-cast v2, Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 92
    .line 93
    :goto_1
    if-nez v2, :cond_5

    .line 94
    .line 95
    if-eqz p1, :cond_4

    .line 96
    .line 97
    const/4 p1, 0x1

    .line 98
    goto :goto_2

    .line 99
    :cond_4
    const/4 p1, 0x0

    .line 100
    :goto_2
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 101
    .line 102
    const-string p1, "Missing capture settings, using SharedPrefs"

    .line 103
    .line 104
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    .line 106
    .line 107
    goto :goto_4

    .line 108
    :cond_5
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 109
    .line 110
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 111
    .line 112
    iget-object p1, v2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->decryption_rules_json:Ljava/lang/String;

    .line 113
    .line 114
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    .line 115
    .line 116
    .line 117
    move-result v3

    .line 118
    const/4 v4, 0x0

    .line 119
    :goto_3
    if-ge v4, v3, :cond_7

    .line 120
    .line 121
    invoke-virtual {p1, v4}, Ljava/lang/String;->codePointAt(I)I

    .line 122
    .line 123
    .line 124
    move-result v5

    .line 125
    invoke-static {v5}, Ljava/lang/Character;->isWhitespace(I)Z

    .line 126
    .line 127
    .line 128
    move-result v6

    .line 129
    if-nez v6, :cond_6

    .line 130
    .line 131
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 132
    .line 133
    .line 134
    move-result-object p1

    .line 135
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->getDecryptionList()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 136
    .line 137
    .line 138
    move-result-object p1

    .line 139
    iget-object v2, v2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->decryption_rules_json:Ljava/lang/String;

    .line 140
    .line 141
    invoke-virtual {p1, v2}, Lcom/emanuelef/remote_capture/model/MatchList;->fromJson(Ljava/lang/String;)I

    .line 142
    .line 143
    .line 144
    goto :goto_4

    .line 145
    :cond_6
    invoke-static {v5}, Ljava/lang/Character;->charCount(I)I

    .line 146
    .line 147
    .line 148
    move-result v5

    .line 149
    add-int/2addr v4, v5

    .line 150
    goto :goto_3

    .line 151
    :cond_7
    :goto_4
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 152
    .line 153
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->isAlwaysOnVpnDetected()Z

    .line 154
    .line 155
    .line 156
    move-result v2

    .line 157
    or-int/2addr p1, v2

    .line 158
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 159
    .line 160
    new-instance p1, Ljava/lang/StringBuilder;

    .line 161
    .line 162
    const-string v2, "alwaysOn? "

    .line 163
    .line 164
    invoke-direct {p1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 165
    .line 166
    .line 167
    iget-boolean v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 168
    .line 169
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 170
    .line 171
    .line 172
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 173
    .line 174
    .line 175
    move-result-object p1

    .line 176
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    .line 178
    .line 179
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 180
    .line 181
    if-eqz p1, :cond_8

    .line 182
    .line 183
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 184
    .line 185
    iput-boolean p2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 186
    .line 187
    iput-object p3, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->input_pcap_path:Ljava/lang/String;

    .line 188
    .line 189
    :cond_8
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 190
    .line 191
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->readFromPcap()Z

    .line 192
    .line 193
    .line 194
    move-result p1

    .line 195
    if-eqz p1, :cond_9

    .line 196
    .line 197
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 198
    .line 199
    sget-object v2, Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;->NONE:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 200
    .line 201
    iput-object v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_mode:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 202
    .line 203
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 204
    .line 205
    invoke-virtual {p1}, Ljava/util/HashSet;->clear()V

    .line 206
    .line 207
    .line 208
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 209
    .line 210
    iput-boolean p2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_enabled:Z

    .line 211
    .line 212
    iput-boolean p2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 213
    .line 214
    iput-boolean p2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 215
    .line 216
    iput-boolean p2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->auto_block_private_dns:Z

    .line 217
    .line 218
    iget-object v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->input_pcap_path:Ljava/lang/String;

    .line 219
    .line 220
    iput-object v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->capture_interface:Ljava/lang/String;

    .line 221
    .line 222
    :cond_9
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 223
    .line 224
    invoke-static {p1}, Lcom/emanuelef/remote_capture/model/Prefs;->getDnsServerV4(Landroid/content/SharedPreferences;)Ljava/lang/String;

    .line 225
    .line 226
    .line 227
    move-result-object p1

    .line 228
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    .line 229
    .line 230
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlockPrivateDns:Z

    .line 231
    .line 232
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mStrictDnsNoticeShown:Z

    .line 233
    .line 234
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDnsEncrypted:Z

    .line 235
    .line 236
    invoke-static {p2}, Lcom/emanuelef/remote_capture/CaptureService;->setPrivateDnsBlocked(Z)V

    .line 237
    .line 238
    .line 239
    new-instance v2, Landroid/util/SparseArray;

    .line 240
    .line 241
    invoke-direct {v2}, Landroid/util/SparseArray;-><init>()V

    .line 242
    .line 243
    .line 244
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIfIndexToName:Landroid/util/SparseArray;

    .line 245
    .line 246
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->getNetworkInterfaces()Ljava/util/Enumeration;

    .line 247
    .line 248
    .line 249
    move-result-object v2

    .line 250
    :goto_5
    invoke-interface {v2}, Ljava/util/Enumeration;->hasMoreElements()Z

    .line 251
    .line 252
    .line 253
    move-result v3

    .line 254
    if-eqz v3, :cond_a

    .line 255
    .line 256
    invoke-interface {v2}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    .line 257
    .line 258
    .line 259
    move-result-object v3

    .line 260
    check-cast v3, Ljava/net/NetworkInterface;

    .line 261
    .line 262
    new-instance v4, Ljava/lang/StringBuilder;

    .line 263
    .line 264
    const-string v5, "ifidx "

    .line 265
    .line 266
    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 267
    .line 268
    .line 269
    invoke-virtual {v3}, Ljava/net/NetworkInterface;->getIndex()I

    .line 270
    .line 271
    .line 272
    move-result v5

    .line 273
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 274
    .line 275
    .line 276
    const-string v5, " -> "

    .line 277
    .line 278
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 279
    .line 280
    .line 281
    invoke-virtual {v3}, Ljava/net/NetworkInterface;->getName()Ljava/lang/String;

    .line 282
    .line 283
    .line 284
    move-result-object v5

    .line 285
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 286
    .line 287
    .line 288
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 289
    .line 290
    .line 291
    move-result-object v4

    .line 292
    invoke-static {v0, v4}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 293
    .line 294
    .line 295
    iget-object v4, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIfIndexToName:Landroid/util/SparseArray;

    .line 296
    .line 297
    invoke-virtual {v3}, Ljava/net/NetworkInterface;->getIndex()I

    .line 298
    .line 299
    .line 300
    move-result v5

    .line 301
    invoke-virtual {v3}, Ljava/net/NetworkInterface;->getName()Ljava/lang/String;

    .line 302
    .line 303
    .line 304
    move-result-object v3

    .line 305
    invoke-virtual {v4, v5, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 306
    .line 307
    .line 308
    goto :goto_5

    .line 309
    :cond_a
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 310
    .line 311
    const/16 v3, 0x17

    .line 312
    .line 313
    if-lt v2, v3, :cond_e

    .line 314
    .line 315
    const-string v2, "connectivity"

    .line 316
    .line 317
    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 318
    .line 319
    .line 320
    move-result-object v2

    .line 321
    check-cast v2, Landroid/net/ConnectivityManager;

    .line 322
    .line 323
    invoke-virtual {v2}, Landroid/net/ConnectivityManager;->getActiveNetwork()Landroid/net/Network;

    .line 324
    .line 325
    .line 326
    move-result-object v3

    .line 327
    iput-object v3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mUnderlyingNetwork:Landroid/net/Network;

    .line 328
    .line 329
    if-eqz v3, :cond_e

    .line 330
    .line 331
    invoke-virtual {v2, v3}, Landroid/net/ConnectivityManager;->getLinkProperties(Landroid/net/Network;)Landroid/net/LinkProperties;

    .line 332
    .line 333
    .line 334
    move-result-object v4

    .line 335
    invoke-direct {p0, v4}, Lcom/emanuelef/remote_capture/CaptureService;->handleLinkProperties(Landroid/net/LinkProperties;)V

    .line 336
    .line 337
    .line 338
    iget-object v4, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 339
    .line 340
    invoke-static {v4}, Lcom/emanuelef/remote_capture/model/Prefs;->useSystemDns(Landroid/content/SharedPreferences;)Z

    .line 341
    .line 342
    .line 343
    move-result v4

    .line 344
    if-nez v4, :cond_c

    .line 345
    .line 346
    iget-object v4, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 347
    .line 348
    iget-boolean v4, v4, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 349
    .line 350
    if-eqz v4, :cond_b

    .line 351
    .line 352
    goto :goto_6

    .line 353
    :cond_b
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    .line 354
    .line 355
    goto :goto_7

    .line 356
    :cond_c
    :goto_6
    invoke-static {v2, v3}, Lcom/emanuelef/remote_capture/Utils;->getDnsServer(Landroid/net/ConnectivityManager;Landroid/net/Network;)Ljava/lang/String;

    .line 357
    .line 358
    .line 359
    move-result-object v2

    .line 360
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    .line 361
    .line 362
    if-nez v2, :cond_d

    .line 363
    .line 364
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    .line 365
    .line 366
    goto :goto_7

    .line 367
    :cond_d
    invoke-virtual {v3}, Landroid/net/Network;->getNetworkHandle()J

    .line 368
    .line 369
    .line 370
    move-result-wide v2

    .line 371
    iput-wide v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMonitoredNetwork:J

    .line 372
    .line 373
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->registerNetworkCallbacks()V

    .line 374
    .line 375
    .line 376
    :cond_e
    :goto_7
    const-string p1, "10.215.173.2"

    .line 377
    .line 378
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->vpn_dns:Ljava/lang/String;

    .line 379
    .line 380
    const-string p1, "10.215.173.1"

    .line 381
    .line 382
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->vpn_ipv4:Ljava/lang/String;

    .line 383
    .line 384
    const-wide/16 v2, 0x0

    .line 385
    .line 386
    iput-wide v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->last_bytes:J

    .line 387
    .line 388
    iput p2, p0, Lcom/emanuelef/remote_capture/CaptureService;->last_connections:I

    .line 389
    .line 390
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mLowMemory:Z

    .line 391
    .line 392
    new-instance p1, Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 393
    .line 394
    const/16 v2, 0x2000

    .line 395
    .line 396
    invoke-direct {p1, p0, v2}, Lcom/emanuelef/remote_capture/ConnectionsRegister;-><init>(Landroid/content/Context;I)V

    .line 397
    .line 398
    .line 399
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->conn_reg:Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 400
    .line 401
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 402
    .line 403
    iget-boolean p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->full_payload:Z

    .line 404
    .line 405
    if-eqz p1, :cond_f

    .line 406
    .line 407
    new-instance p1, Lcom/emanuelef/remote_capture/HttpLog;

    .line 408
    .line 409
    invoke-direct {p1}, Lcom/emanuelef/remote_capture/HttpLog;-><init>()V

    .line 410
    .line 411
    .line 412
    goto :goto_8

    .line 413
    :cond_f
    move-object p1, p3

    .line 414
    :goto_8
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHttpLog:Lcom/emanuelef/remote_capture/HttpLog;

    .line 415
    .line 416
    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 417
    .line 418
    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumpQueue:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 419
    .line 420
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPendingUpdates:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 421
    .line 422
    invoke-virtual {p1}, Ljava/util/concurrent/LinkedBlockingDeque;->clear()V

    .line 423
    .line 424
    .line 425
    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPcapFname:Ljava/lang/String;

    .line 426
    .line 427
    sput-boolean p2, Lcom/emanuelef/remote_capture/CaptureService;->HAS_ERROR:Z

    .line 428
    .line 429
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 430
    .line 431
    iget-object v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_mode:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 432
    .line 433
    sget-object v3, Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;->HTTP_SERVER:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 434
    .line 435
    if-ne v2, v3, :cond_10

    .line 436
    .line 437
    new-instance v2, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;

    .line 438
    .line 439
    iget v3, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->http_server_port:I

    .line 440
    .line 441
    iget-boolean p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcapng_format:Z

    .line 442
    .line 443
    invoke-direct {v2, p0, v3, p1}, Lcom/emanuelef/remote_capture/pcap_dump/HTTPServer;-><init>(Landroid/content/Context;IZ)V

    .line 444
    .line 445
    .line 446
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 447
    .line 448
    goto/16 :goto_b

    .line 449
    .line 450
    :cond_10
    sget-object v3, Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;->PCAP_FILE:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 451
    .line 452
    if-ne v2, v3, :cond_14

    .line 453
    .line 454
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_name:Ljava/lang/String;

    .line 455
    .line 456
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 457
    .line 458
    .line 459
    move-result p1

    .line 460
    if-nez p1, :cond_11

    .line 461
    .line 462
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 463
    .line 464
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_name:Ljava/lang/String;

    .line 465
    .line 466
    goto :goto_9

    .line 467
    :cond_11
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 468
    .line 469
    iget-boolean p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcapng_format:Z

    .line 470
    .line 471
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/Utils;->getUniquePcapFileName(Landroid/content/Context;Z)Ljava/lang/String;

    .line 472
    .line 473
    .line 474
    move-result-object p1

    .line 475
    :goto_9
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPcapFname:Ljava/lang/String;

    .line 476
    .line 477
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 478
    .line 479
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_uri:Ljava/lang/String;

    .line 480
    .line 481
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 482
    .line 483
    .line 484
    move-result p1

    .line 485
    if-nez p1, :cond_12

    .line 486
    .line 487
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 488
    .line 489
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcap_uri:Ljava/lang/String;

    .line 490
    .line 491
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    .line 492
    .line 493
    .line 494
    move-result-object p1

    .line 495
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPcapUri:Landroid/net/Uri;

    .line 496
    .line 497
    goto :goto_a

    .line 498
    :cond_12
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPcapFname:Ljava/lang/String;

    .line 499
    .line 500
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/Utils;->getDownloadsUri(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;

    .line 501
    .line 502
    .line 503
    move-result-object p1

    .line 504
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPcapUri:Landroid/net/Uri;

    .line 505
    .line 506
    :goto_a
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPcapUri:Landroid/net/Uri;

    .line 507
    .line 508
    if-nez p1, :cond_13

    .line 509
    .line 510
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->abortStart()I

    .line 511
    .line 512
    .line 513
    move-result p1

    .line 514
    return p1

    .line 515
    :cond_13
    new-instance v2, Lcom/emanuelef/remote_capture/pcap_dump/FileDumper;

    .line 516
    .line 517
    invoke-direct {v2, p0, p1}, Lcom/emanuelef/remote_capture/pcap_dump/FileDumper;-><init>(Landroid/content/Context;Landroid/net/Uri;)V

    .line 518
    .line 519
    .line 520
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 521
    .line 522
    goto :goto_b

    .line 523
    :cond_14
    sget-object v3, Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;->UDP_EXPORTER:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 524
    .line 525
    if-ne v2, v3, :cond_15

    .line 526
    .line 527
    :try_start_0
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_address:Ljava/lang/String;

    .line 528
    .line 529
    invoke-static {p1}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    .line 530
    .line 531
    .line 532
    move-result-object p1
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0

    .line 533
    new-instance v2, Lcom/emanuelef/remote_capture/pcap_dump/UDPDumper;

    .line 534
    .line 535
    new-instance v3, Ljava/net/InetSocketAddress;

    .line 536
    .line 537
    iget-object v4, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 538
    .line 539
    iget v4, v4, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_port:I

    .line 540
    .line 541
    invoke-direct {v3, p1, v4}, Ljava/net/InetSocketAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 542
    .line 543
    .line 544
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 545
    .line 546
    iget-boolean p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcapng_format:Z

    .line 547
    .line 548
    invoke-direct {v2, v3, p1}, Lcom/emanuelef/remote_capture/pcap_dump/UDPDumper;-><init>(Ljava/net/InetSocketAddress;Z)V

    .line 549
    .line 550
    .line 551
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 552
    .line 553
    goto :goto_b

    .line 554
    :catch_0
    move-exception p1

    .line 555
    invoke-virtual {p1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    .line 556
    .line 557
    .line 558
    move-result-object p2

    .line 559
    invoke-virtual {p0, p2}, Lcom/emanuelef/remote_capture/CaptureService;->reportError(Ljava/lang/String;)V

    .line 560
    .line 561
    .line 562
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 563
    .line 564
    .line 565
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->abortStart()I

    .line 566
    .line 567
    .line 568
    move-result p1

    .line 569
    return p1

    .line 570
    :cond_15
    sget-object v3, Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;->TCP_EXPORTER:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 571
    .line 572
    if-ne v2, v3, :cond_16

    .line 573
    .line 574
    :try_start_1
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_address:Ljava/lang/String;

    .line 575
    .line 576
    invoke-static {p1}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    .line 577
    .line 578
    .line 579
    move-result-object p1
    :try_end_1
    .catch Ljava/net/UnknownHostException; {:try_start_1 .. :try_end_1} :catch_1

    .line 580
    new-instance v2, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;

    .line 581
    .line 582
    new-instance v3, Ljava/net/InetSocketAddress;

    .line 583
    .line 584
    iget-object v4, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 585
    .line 586
    iget v4, v4, Lcom/emanuelef/remote_capture/model/CaptureSettings;->collector_port:I

    .line 587
    .line 588
    invoke-direct {v3, p1, v4}, Ljava/net/InetSocketAddress;-><init>(Ljava/net/InetAddress;I)V

    .line 589
    .line 590
    .line 591
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 592
    .line 593
    iget-boolean p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->pcapng_format:Z

    .line 594
    .line 595
    invoke-direct {v2, v3, p1}, Lcom/emanuelef/remote_capture/pcap_dump/TCPDumper;-><init>(Ljava/net/InetSocketAddress;Z)V

    .line 596
    .line 597
    .line 598
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 599
    .line 600
    goto :goto_b

    .line 601
    :catch_1
    move-exception p1

    .line 602
    invoke-virtual {p1}, Ljava/lang/Throwable;->getLocalizedMessage()Ljava/lang/String;

    .line 603
    .line 604
    .line 605
    move-result-object p2

    .line 606
    invoke-virtual {p0, p2}, Lcom/emanuelef/remote_capture/CaptureService;->reportError(Ljava/lang/String;)V

    .line 607
    .line 608
    .line 609
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 610
    .line 611
    .line 612
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->abortStart()I

    .line 613
    .line 614
    .line 615
    move-result p1

    .line 616
    return p1

    .line 617
    :cond_16
    :goto_b
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 618
    .line 619
    if-eqz p1, :cond_17

    .line 620
    .line 621
    new-instance p1, Ljava/util/concurrent/LinkedBlockingDeque;

    .line 622
    .line 623
    const/16 v2, 0x40

    .line 624
    .line 625
    invoke-direct {p1, v2}, Ljava/util/concurrent/LinkedBlockingDeque;-><init>(I)V

    .line 626
    .line 627
    .line 628
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumpQueue:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 629
    .line 630
    :cond_17
    const-string p1, ""

    .line 631
    .line 632
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 633
    .line 634
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 635
    .line 636
    iget-boolean v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_enabled:Z

    .line 637
    .line 638
    if-nez v2, :cond_19

    .line 639
    .line 640
    iget-boolean v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 641
    .line 642
    if-eqz v2, :cond_18

    .line 643
    .line 644
    goto :goto_c

    .line 645
    :cond_18
    const/4 v2, 0x0

    .line 646
    goto :goto_d

    .line 647
    :cond_19
    :goto_c
    const/4 v2, 0x1

    .line 648
    :goto_d
    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Enabled:Z

    .line 649
    .line 650
    if-eqz v2, :cond_1c

    .line 651
    .line 652
    iget-boolean v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 653
    .line 654
    const-string v3, ":"

    .line 655
    .line 656
    if-eqz v2, :cond_1a

    .line 657
    .line 658
    const-string p1, "127.0.0.1"

    .line 659
    .line 660
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 661
    .line 662
    const/16 p1, 0x1e64

    .line 663
    .line 664
    iput p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Port:I

    .line 665
    .line 666
    new-instance p1, Ljava/lang/StringBuilder;

    .line 667
    .line 668
    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 669
    .line 670
    .line 671
    const/16 v2, 0x8

    .line 672
    .line 673
    invoke-static {v2}, Lcom/emanuelef/remote_capture/Utils;->genRandomString(I)Ljava/lang/String;

    .line 674
    .line 675
    .line 676
    move-result-object v4

    .line 677
    invoke-virtual {p1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 678
    .line 679
    .line 680
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 681
    .line 682
    .line 683
    invoke-static {v2}, Lcom/emanuelef/remote_capture/Utils;->genRandomString(I)Ljava/lang/String;

    .line 684
    .line 685
    .line 686
    move-result-object v2

    .line 687
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 688
    .line 689
    .line 690
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 691
    .line 692
    .line 693
    move-result-object p1

    .line 694
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Auth:Ljava/lang/String;

    .line 695
    .line 696
    new-instance p1, Lcom/emanuelef/remote_capture/MitmReceiver;

    .line 697
    .line 698
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 699
    .line 700
    iget-object v3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Auth:Ljava/lang/String;

    .line 701
    .line 702
    invoke-direct {p1, p0, v2, v3}, Lcom/emanuelef/remote_capture/MitmReceiver;-><init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/CaptureSettings;Ljava/lang/String;)V

    .line 703
    .line 704
    .line 705
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMitmReceiver:Lcom/emanuelef/remote_capture/MitmReceiver;

    .line 706
    .line 707
    :try_start_2
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/MitmReceiver;->start()Z

    .line 708
    .line 709
    .line 710
    move-result p1

    .line 711
    if-nez p1, :cond_1c

    .line 712
    .line 713
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->abortStart()I

    .line 714
    .line 715
    .line 716
    move-result p1
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    .line 717
    return p1

    .line 718
    :catch_2
    move-exception p1

    .line 719
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 720
    .line 721
    .line 722
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->abortStart()I

    .line 723
    .line 724
    .line 725
    move-result p1

    .line 726
    return p1

    .line 727
    :cond_1a
    iget-object v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_proxy_address:Ljava/lang/String;

    .line 728
    .line 729
    iput-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Address:Ljava/lang/String;

    .line 730
    .line 731
    iget v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_proxy_port:I

    .line 732
    .line 733
    iput v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Port:I

    .line 734
    .line 735
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_username:Ljava/lang/String;

    .line 736
    .line 737
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 738
    .line 739
    .line 740
    move-result p1

    .line 741
    if-nez p1, :cond_1b

    .line 742
    .line 743
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 744
    .line 745
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_password:Ljava/lang/String;

    .line 746
    .line 747
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 748
    .line 749
    .line 750
    move-result p1

    .line 751
    if-nez p1, :cond_1b

    .line 752
    .line 753
    new-instance p1, Ljava/lang/StringBuilder;

    .line 754
    .line 755
    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 756
    .line 757
    .line 758
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 759
    .line 760
    iget-object v2, v2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_username:Ljava/lang/String;

    .line 761
    .line 762
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 763
    .line 764
    .line 765
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 766
    .line 767
    .line 768
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 769
    .line 770
    iget-object v2, v2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->socks5_password:Ljava/lang/String;

    .line 771
    .line 772
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 773
    .line 774
    .line 775
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 776
    .line 777
    .line 778
    move-result-object p1

    .line 779
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Auth:Ljava/lang/String;

    .line 780
    .line 781
    goto :goto_e

    .line 782
    :cond_1b
    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSocks5Auth:Ljava/lang/String;

    .line 783
    .line 784
    :cond_1c
    :goto_e
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 785
    .line 786
    iget-boolean v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 787
    .line 788
    if-eqz v2, :cond_1d

    .line 789
    .line 790
    iget-boolean v2, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 791
    .line 792
    if-nez v2, :cond_1d

    .line 793
    .line 794
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->readFromPcap()Z

    .line 795
    .line 796
    .line 797
    move-result p1

    .line 798
    if-nez p1, :cond_1d

    .line 799
    .line 800
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 801
    .line 802
    .line 803
    move-result-object p1

    .line 804
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->getDecryptionList()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 805
    .line 806
    .line 807
    move-result-object p1

    .line 808
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 809
    .line 810
    goto :goto_f

    .line 811
    :cond_1d
    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDecryptionList:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 812
    .line 813
    :goto_f
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 814
    .line 815
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 816
    .line 817
    if-eqz p1, :cond_1f

    .line 818
    .line 819
    invoke-virtual {p1}, Ljava/util/HashSet;->isEmpty()Z

    .line 820
    .line 821
    .line 822
    move-result p1

    .line 823
    if-nez p1, :cond_1f

    .line 824
    .line 825
    new-instance p1, Ljava/util/ArrayList;

    .line 826
    .line 827
    invoke-direct {p1}, Ljava/util/ArrayList;-><init>()V

    .line 828
    .line 829
    .line 830
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 831
    .line 832
    iget-object p3, p3, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 833
    .line 834
    invoke-virtual {p3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 835
    .line 836
    .line 837
    move-result-object p3

    .line 838
    :goto_10
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    .line 839
    .line 840
    .line 841
    move-result v2

    .line 842
    if-eqz v2, :cond_1e

    .line 843
    .line 844
    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 845
    .line 846
    .line 847
    move-result-object v2

    .line 848
    check-cast v2, Ljava/lang/String;

    .line 849
    .line 850
    :try_start_3
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 851
    .line 852
    .line 853
    move-result-object v3

    .line 854
    invoke-static {v3, v2, p2}, Lcom/emanuelef/remote_capture/Utils;->getPackageUid(Landroid/content/pm/PackageManager;Ljava/lang/String;I)I

    .line 855
    .line 856
    .line 857
    move-result v2
    :try_end_3
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3 .. :try_end_3} :catch_3

    .line 858
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 859
    .line 860
    .line 861
    move-result-object v2

    .line 862
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 863
    .line 864
    .line 865
    goto :goto_10

    .line 866
    :catch_3
    move-exception v2

    .line 867
    invoke-virtual {v2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 868
    .line 869
    .line 870
    goto :goto_10

    .line 871
    :cond_1e
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 872
    .line 873
    .line 874
    move-result p3

    .line 875
    new-array p3, p3, [I

    .line 876
    .line 877
    iput-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mAppFilterUids:[I

    .line 878
    .line 879
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 880
    .line 881
    .line 882
    move-result p3

    .line 883
    const/4 v2, 0x0

    .line 884
    const/4 v3, 0x0

    .line 885
    :goto_11
    if-ge v3, p3, :cond_20

    .line 886
    .line 887
    invoke-virtual {p1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 888
    .line 889
    .line 890
    move-result-object v4

    .line 891
    add-int/lit8 v3, v3, 0x1

    .line 892
    .line 893
    check-cast v4, Ljava/lang/Integer;

    .line 894
    .line 895
    iget-object v5, p0, Lcom/emanuelef/remote_capture/CaptureService;->mAppFilterUids:[I

    .line 896
    .line 897
    add-int/lit8 v6, v2, 0x1

    .line 898
    .line 899
    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    .line 900
    .line 901
    .line 902
    move-result v4

    .line 903
    aput v4, v5, v2

    .line 904
    .line 905
    move v2, v6

    .line 906
    goto :goto_11

    .line 907
    :cond_1f
    new-array p1, p2, [I

    .line 908
    .line 909
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mAppFilterUids:[I

    .line 910
    .line 911
    :cond_20
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 912
    .line 913
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->readFromPcap()Z

    .line 914
    .line 915
    .line 916
    move-result p1

    .line 917
    if-nez p1, :cond_21

    .line 918
    .line 919
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 920
    .line 921
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/model/Prefs;->isMalwareDetectionEnabled(Landroid/content/Context;Landroid/content/SharedPreferences;)Z

    .line 922
    .line 923
    .line 924
    move-result p1

    .line 925
    if-eqz p1, :cond_21

    .line 926
    .line 927
    const/4 p1, 0x1

    .line 928
    goto :goto_12

    .line 929
    :cond_21
    const/4 p1, 0x0

    .line 930
    :goto_12
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareDetectionEnabled:Z

    .line 931
    .line 932
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 933
    .line 934
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->readFromPcap()Z

    .line 935
    .line 936
    .line 937
    move-result p1

    .line 938
    if-nez p1, :cond_22

    .line 939
    .line 940
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 941
    .line 942
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/model/Prefs;->isFirewallEnabled(Landroid/content/Context;Landroid/content/SharedPreferences;)Z

    .line 943
    .line 944
    .line 945
    move-result p1

    .line 946
    if-eqz p1, :cond_22

    .line 947
    .line 948
    const/4 p1, 0x1

    .line 949
    goto :goto_13

    .line 950
    :cond_22
    const/4 p1, 0x0

    .line 951
    :goto_13
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mFirewallEnabled:Z

    .line 952
    .line 953
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 954
    .line 955
    iget-boolean p3, p1, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 956
    .line 957
    if-nez p3, :cond_29

    .line 958
    .line 959
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->readFromPcap()Z

    .line 960
    .line 961
    .line 962
    move-result p1

    .line 963
    if-nez p1, :cond_29

    .line 964
    .line 965
    new-instance p1, Ljava/lang/StringBuilder;

    .line 966
    .line 967
    const-string p3, "Using DNS server "

    .line 968
    .line 969
    invoke-direct {p1, p3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 970
    .line 971
    .line 972
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->dns_server:Ljava/lang/String;

    .line 973
    .line 974
    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 975
    .line 976
    .line 977
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 978
    .line 979
    .line 980
    move-result-object p1

    .line 981
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 982
    .line 983
    .line 984
    new-instance p1, Landroid/net/VpnService$Builder;

    .line 985
    .line 986
    invoke-direct {p1, p0}, Landroid/net/VpnService$Builder;-><init>(Landroid/net/VpnService;)V

    .line 987
    .line 988
    .line 989
    const/16 p3, 0x2710

    .line 990
    .line 991
    invoke-virtual {p1, p3}, Landroid/net/VpnService$Builder;->setMtu(I)Landroid/net/VpnService$Builder;

    .line 992
    .line 993
    .line 994
    move-result-object p1

    .line 995
    sget p3, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 996
    .line 997
    const/16 v2, 0x1d

    .line 998
    .line 999
    if-lt p3, v2, :cond_23

    .line 1000
    .line 1001
    invoke-virtual {p1, p2}, Landroid/net/VpnService$Builder;->setMetered(Z)Landroid/net/VpnService$Builder;

    .line 1002
    .line 1003
    .line 1004
    :cond_23
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->getIPv4Enabled()I

    .line 1005
    .line 1006
    .line 1007
    move-result p3

    .line 1008
    if-ne p3, v1, :cond_24

    .line 1009
    .line 1010
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->vpn_ipv4:Ljava/lang/String;

    .line 1011
    .line 1012
    const/16 v2, 0x1e

    .line 1013
    .line 1014
    invoke-virtual {p1, p3, v2}, Landroid/net/VpnService$Builder;->addAddress(Ljava/lang/String;I)Landroid/net/VpnService$Builder;

    .line 1015
    .line 1016
    .line 1017
    move-result-object p3

    .line 1018
    const-string v2, "0.0.0.0"

    .line 1019
    .line 1020
    invoke-virtual {p3, v2, v1}, Landroid/net/VpnService$Builder;->addRoute(Ljava/lang/String;I)Landroid/net/VpnService$Builder;

    .line 1021
    .line 1022
    .line 1023
    move-result-object p3

    .line 1024
    const-string v2, "128.0.0.0"

    .line 1025
    .line 1026
    invoke-virtual {p3, v2, v1}, Landroid/net/VpnService$Builder;->addRoute(Ljava/lang/String;I)Landroid/net/VpnService$Builder;

    .line 1027
    .line 1028
    .line 1029
    move-result-object p3

    .line 1030
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->vpn_dns:Ljava/lang/String;

    .line 1031
    .line 1032
    invoke-virtual {p3, v2}, Landroid/net/VpnService$Builder;->addDnsServer(Ljava/lang/String;)Landroid/net/VpnService$Builder;

    .line 1033
    .line 1034
    .line 1035
    :cond_24
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/CaptureService;->getIPv6Enabled()I

    .line 1036
    .line 1037
    .line 1038
    move-result p3

    .line 1039
    if-ne p3, v1, :cond_25

    .line 1040
    .line 1041
    const-string p3, "fd00:2:fd00:1:fd00:1:fd00:1"

    .line 1042
    .line 1043
    const/16 v2, 0x80

    .line 1044
    .line 1045
    invoke-virtual {p1, p3, v2}, Landroid/net/VpnService$Builder;->addAddress(Ljava/lang/String;I)Landroid/net/VpnService$Builder;

    .line 1046
    .line 1047
    .line 1048
    const-string p3, "2000::"

    .line 1049
    .line 1050
    const/4 v2, 0x3

    .line 1051
    invoke-virtual {p1, p3, v2}, Landroid/net/VpnService$Builder;->addRoute(Ljava/lang/String;I)Landroid/net/VpnService$Builder;

    .line 1052
    .line 1053
    .line 1054
    const-string p3, "fc00::"

    .line 1055
    .line 1056
    const/4 v2, 0x7

    .line 1057
    invoke-virtual {p1, p3, v2}, Landroid/net/VpnService$Builder;->addRoute(Ljava/lang/String;I)Landroid/net/VpnService$Builder;

    .line 1058
    .line 1059
    .line 1060
    :try_start_4
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 1061
    .line 1062
    invoke-static {p3}, Lcom/emanuelef/remote_capture/model/Prefs;->getDnsServerV6(Landroid/content/SharedPreferences;)Ljava/lang/String;

    .line 1063
    .line 1064
    .line 1065
    move-result-object p3

    .line 1066
    invoke-static {p3}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    .line 1067
    .line 1068
    .line 1069
    move-result-object p3

    .line 1070
    invoke-virtual {p1, p3}, Landroid/net/VpnService$Builder;->addDnsServer(Ljava/net/InetAddress;)Landroid/net/VpnService$Builder;
    :try_end_4
    .catch Ljava/net/UnknownHostException; {:try_start_4 .. :try_end_4} :catch_4
    .catch Ljava/lang/IllegalArgumentException; {:try_start_4 .. :try_end_4} :catch_4

    .line 1071
    .line 1072
    .line 1073
    goto :goto_14

    .line 1074
    :catch_4
    const-string p3, "Could not set IPv6 DNS server"

    .line 1075
    .line 1076
    invoke-static {v0, p3}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1077
    .line 1078
    .line 1079
    :cond_25
    :goto_14
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 1080
    .line 1081
    iget-object p3, p3, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 1082
    .line 1083
    if-eqz p3, :cond_26

    .line 1084
    .line 1085
    invoke-virtual {p3}, Ljava/util/HashSet;->isEmpty()Z

    .line 1086
    .line 1087
    .line 1088
    move-result p3

    .line 1089
    if-nez p3, :cond_26

    .line 1090
    .line 1091
    new-instance p3, Ljava/lang/StringBuilder;

    .line 1092
    .line 1093
    const-string v2, "Setting app filter: "

    .line 1094
    .line 1095
    invoke-direct {p3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1096
    .line 1097
    .line 1098
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 1099
    .line 1100
    iget-object v2, v2, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 1101
    .line 1102
    invoke-virtual {p3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 1103
    .line 1104
    .line 1105
    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 1106
    .line 1107
    .line 1108
    move-result-object p3

    .line 1109
    invoke-static {v0, p3}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1110
    .line 1111
    .line 1112
    :try_start_5
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 1113
    .line 1114
    iget-object p3, p3, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 1115
    .line 1116
    invoke-virtual {p3}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    .line 1117
    .line 1118
    .line 1119
    move-result-object p3

    .line 1120
    :goto_15
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    .line 1121
    .line 1122
    .line 1123
    move-result v0

    .line 1124
    if-eqz v0, :cond_28

    .line 1125
    .line 1126
    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1127
    .line 1128
    .line 1129
    move-result-object v0

    .line 1130
    check-cast v0, Ljava/lang/String;

    .line 1131
    .line 1132
    invoke-virtual {p1, v0}, Landroid/net/VpnService$Builder;->addAllowedApplication(Ljava/lang/String;)Landroid/net/VpnService$Builder;
    :try_end_5
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_5 .. :try_end_5} :catch_5

    .line 1133
    .line 1134
    .line 1135
    goto :goto_15

    .line 1136
    :catch_5
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 1137
    .line 1138
    .line 1139
    move-result-object p1

    .line 1140
    const p3, 0x7f140043

    .line 1141
    .line 1142
    .line 1143
    invoke-virtual {p1, p3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    .line 1144
    .line 1145
    .line 1146
    move-result-object p1

    .line 1147
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 1148
    .line 1149
    iget-object p3, p3, Lcom/emanuelef/remote_capture/model/CaptureSettings;->app_filter:Ljava/util/HashSet;

    .line 1150
    .line 1151
    new-array v0, v1, [Ljava/lang/Object;

    .line 1152
    .line 1153
    aput-object p3, v0, p2

    .line 1154
    .line 1155
    invoke-static {p1, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 1156
    .line 1157
    .line 1158
    move-result-object p1

    .line 1159
    invoke-static {p0, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    .line 1160
    .line 1161
    .line 1162
    move-result-object p1

    .line 1163
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 1164
    .line 1165
    .line 1166
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->abortStart()I

    .line 1167
    .line 1168
    .line 1169
    move-result p1

    .line 1170
    return p1

    .line 1171
    :cond_26
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    .line 1172
    .line 1173
    new-instance v0, Ljava/util/HashSet;

    .line 1174
    .line 1175
    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 1176
    .line 1177
    .line 1178
    const-string v2, "vpn_exceptions"

    .line 1179
    .line 1180
    invoke-interface {p3, v2, v0}, Landroid/content/SharedPreferences;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    .line 1181
    .line 1182
    .line 1183
    move-result-object p3

    .line 1184
    invoke-interface {p3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 1185
    .line 1186
    .line 1187
    move-result-object p3

    .line 1188
    :goto_16
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    .line 1189
    .line 1190
    .line 1191
    move-result v0

    .line 1192
    if-eqz v0, :cond_27

    .line 1193
    .line 1194
    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 1195
    .line 1196
    .line 1197
    move-result-object v0

    .line 1198
    check-cast v0, Ljava/lang/String;

    .line 1199
    .line 1200
    :try_start_6
    invoke-virtual {p1, v0}, Landroid/net/VpnService$Builder;->addDisallowedApplication(Ljava/lang/String;)Landroid/net/VpnService$Builder;
    :try_end_6
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_6 .. :try_end_6} :catch_6

    .line 1201
    .line 1202
    .line 1203
    goto :goto_16

    .line 1204
    :catch_6
    move-exception v0

    .line 1205
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 1206
    .line 1207
    .line 1208
    goto :goto_16

    .line 1209
    :cond_27
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 1210
    .line 1211
    iget-boolean p3, p3, Lcom/emanuelef/remote_capture/model/CaptureSettings;->tls_decryption:Z

    .line 1212
    .line 1213
    if-eqz p3, :cond_28

    .line 1214
    .line 1215
    :try_start_7
    const-string p3, "com.pcapdroid.mitm"

    .line 1216
    .line 1217
    invoke-virtual {p1, p3}, Landroid/net/VpnService$Builder;->addDisallowedApplication(Ljava/lang/String;)Landroid/net/VpnService$Builder;
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_7

    .line 1218
    .line 1219
    .line 1220
    goto :goto_17

    .line 1221
    :catch_7
    move-exception p3

    .line 1222
    invoke-virtual {p3}, Ljava/lang/Throwable;->printStackTrace()V

    .line 1223
    .line 1224
    .line 1225
    :cond_28
    :goto_17
    :try_start_8
    const-string p3, "PCAPdroid VPN"

    .line 1226
    .line 1227
    invoke-virtual {p1, p3}, Landroid/net/VpnService$Builder;->setSession(Ljava/lang/String;)Landroid/net/VpnService$Builder;

    .line 1228
    .line 1229
    .line 1230
    move-result-object p1

    .line 1231
    invoke-virtual {p1}, Landroid/net/VpnService$Builder;->establish()Landroid/os/ParcelFileDescriptor;

    .line 1232
    .line 1233
    .line 1234
    move-result-object p1

    .line 1235
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mParcelFileDescriptor:Landroid/os/ParcelFileDescriptor;
    :try_end_8
    .catch Ljava/lang/IllegalArgumentException; {:try_start_8 .. :try_end_8} :catch_a
    .catch Ljava/lang/IllegalStateException; {:try_start_8 .. :try_end_8} :catch_9
    .catch Ljava/lang/SecurityException; {:try_start_8 .. :try_end_8} :catch_8

    .line 1236
    .line 1237
    goto :goto_19

    .line 1238
    :catch_8
    move-exception p1

    .line 1239
    goto :goto_18

    .line 1240
    :catch_9
    move-exception p1

    .line 1241
    goto :goto_18

    .line 1242
    :catch_a
    move-exception p1

    .line 1243
    :goto_18
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 1244
    .line 1245
    .line 1246
    const p1, 0x7f1402ee

    .line 1247
    .line 1248
    .line 1249
    new-array p2, p2, [Ljava/lang/Object;

    .line 1250
    .line 1251
    invoke-static {p0, p1, p2}, Lcom/emanuelef/remote_capture/Utils;->showToast(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 1252
    .line 1253
    .line 1254
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->abortStart()I

    .line 1255
    .line 1256
    .line 1257
    move-result p1

    .line 1258
    return p1

    .line 1259
    :cond_29
    :goto_19
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 1260
    .line 1261
    .line 1262
    move-result-object p1

    .line 1263
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->getMalwareWhitelist()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 1264
    .line 1265
    .line 1266
    move-result-object p1

    .line 1267
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 1268
    .line 1269
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 1270
    .line 1271
    .line 1272
    move-result-object p1

    .line 1273
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->getBlacklists()Lcom/emanuelef/remote_capture/Blacklists;

    .line 1274
    .line 1275
    .line 1276
    move-result-object p1

    .line 1277
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 1278
    .line 1279
    iget-boolean p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareDetectionEnabled:Z

    .line 1280
    .line 1281
    if-eqz p3, :cond_2a

    .line 1282
    .line 1283
    invoke-virtual {p1, v1}, Lcom/emanuelef/remote_capture/Blacklists;->needsUpdate(Z)Z

    .line 1284
    .line 1285
    .line 1286
    move-result p1

    .line 1287
    if-nez p1, :cond_2a

    .line 1288
    .line 1289
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->reloadBlacklists()V

    .line 1290
    .line 1291
    .line 1292
    :cond_2a
    invoke-direct {p0, v1}, Lcom/emanuelef/remote_capture/CaptureService;->checkBlacklistsUpdates(Z)V

    .line 1293
    .line 1294
    .line 1295
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 1296
    .line 1297
    .line 1298
    move-result-object p1

    .line 1299
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->getBlocklist()Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 1300
    .line 1301
    .line 1302
    move-result-object p1

    .line 1303
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 1304
    .line 1305
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 1306
    .line 1307
    .line 1308
    move-result-object p1

    .line 1309
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->getFirewallWhitelist()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 1310
    .line 1311
    .line 1312
    move-result-object p1

    .line 1313
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 1314
    .line 1315
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNumUpdatesInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 1316
    .line 1317
    invoke-virtual {p1, p2}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 1318
    .line 1319
    .line 1320
    new-instance p1, Ljava/lang/Thread;

    .line 1321
    .line 1322
    new-instance p3, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;

    .line 1323
    .line 1324
    const/4 v0, 0x5

    .line 1325
    invoke-direct {p3, v0, p0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 1326
    .line 1327
    .line 1328
    const-string v0, "UpdateListener"

    .line 1329
    .line 1330
    invoke-direct {p1, p3, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 1331
    .line 1332
    .line 1333
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mConnUpdateThread:Ljava/lang/Thread;

    .line 1334
    .line 1335
    invoke-virtual {p1}, Ljava/lang/Thread;->start()V

    .line 1336
    .line 1337
    .line 1338
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumper:Lcom/emanuelef/remote_capture/interfaces/PcapDumper;

    .line 1339
    .line 1340
    if-eqz p1, :cond_2b

    .line 1341
    .line 1342
    new-instance p1, Ljava/lang/Thread;

    .line 1343
    .line 1344
    new-instance p3, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;

    .line 1345
    .line 1346
    const/4 v0, 0x6

    .line 1347
    invoke-direct {p3, v0, p0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 1348
    .line 1349
    .line 1350
    const-string v0, "DumperThread"

    .line 1351
    .line 1352
    invoke-direct {p1, p3, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 1353
    .line 1354
    .line 1355
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumperThread:Ljava/lang/Thread;

    .line 1356
    .line 1357
    invoke-virtual {p1}, Ljava/lang/Thread;->start()V

    .line 1358
    .line 1359
    .line 1360
    :cond_2b
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mFirewallEnabled:Z

    .line 1361
    .line 1362
    if-eqz p1, :cond_2c

    .line 1363
    .line 1364
    new-instance p1, Lcom/emanuelef/remote_capture/CaptureService$1;

    .line 1365
    .line 1366
    invoke-direct {p1, p0}, Lcom/emanuelef/remote_capture/CaptureService$1;-><init>(Lcom/emanuelef/remote_capture/CaptureService;)V

    .line 1367
    .line 1368
    .line 1369
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNewAppsInstallReceiver:Landroid/content/BroadcastReceiver;

    .line 1370
    .line 1371
    new-instance p1, Landroid/content/IntentFilter;

    .line 1372
    .line 1373
    invoke-direct {p1}, Landroid/content/IntentFilter;-><init>()V

    .line 1374
    .line 1375
    .line 1376
    const-string p3, "android.intent.action.PACKAGE_ADDED"

    .line 1377
    .line 1378
    invoke-virtual {p1, p3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 1379
    .line 1380
    .line 1381
    const-string p3, "package"

    .line 1382
    .line 1383
    invoke-virtual {p1, p3}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    .line 1384
    .line 1385
    .line 1386
    iget-object p3, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNewAppsInstallReceiver:Landroid/content/BroadcastReceiver;

    .line 1387
    .line 1388
    invoke-virtual {p0, p3, p1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 1389
    .line 1390
    .line 1391
    :cond_2c
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mQueueFull:Z

    .line 1392
    .line 1393
    new-instance p1, Ljava/lang/Thread;

    .line 1394
    .line 1395
    const-string p2, "PacketCapture"

    .line 1396
    .line 1397
    invoke-direct {p1, p0, p2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    .line 1398
    .line 1399
    .line 1400
    iput-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureThread:Ljava/lang/Thread;

    .line 1401
    .line 1402
    invoke-virtual {p1}, Ljava/lang/Thread;->start()V

    .line 1403
    .line 1404
    .line 1405
    return v1
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

.method public onTrimMemory(I)V
    .locals 5

    .line 1
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Utils;->trimlvl2str(I)Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const/16 v1, 0x14

    .line 6
    .line 7
    const/4 v2, 0x0

    .line 8
    const/4 v3, 0x1

    .line 9
    if-eq p1, v1, :cond_0

    .line 10
    .line 11
    const/16 v1, 0xa

    .line 12
    .line 13
    if-lt p1, v1, :cond_0

    .line 14
    .line 15
    const/4 v1, 0x1

    .line 16
    goto :goto_0

    .line 17
    :cond_0
    const/4 v1, 0x0

    .line 18
    :goto_0
    if-eqz v1, :cond_1

    .line 19
    .line 20
    const/16 v4, 0x50

    .line 21
    .line 22
    if-lt p1, v4, :cond_1

    .line 23
    .line 24
    const/4 v2, 0x1

    .line 25
    :cond_1
    new-instance p1, Ljava/lang/StringBuilder;

    .line 26
    .line 27
    const-string v3, "onTrimMemory: "

    .line 28
    .line 29
    invoke-direct {p1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 30
    .line 31
    .line 32
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 33
    .line 34
    .line 35
    const-string v0, " - low="

    .line 36
    .line 37
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 38
    .line 39
    .line 40
    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 41
    .line 42
    .line 43
    const-string v0, ", critical="

    .line 44
    .line 45
    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 46
    .line 47
    .line 48
    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 49
    .line 50
    .line 51
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 52
    .line 53
    .line 54
    move-result-object p1

    .line 55
    const-string v0, "CaptureService"

    .line 56
    .line 57
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    .line 59
    .line 60
    if-eqz v2, :cond_2

    .line 61
    .line 62
    iget-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mLowMemory:Z

    .line 63
    .line 64
    if-nez p1, :cond_2

    .line 65
    .line 66
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->handleLowMemory()V

    .line 67
    .line 68
    .line 69
    :cond_2
    return-void
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

.method public pcapDumpEnabled()I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->dump_mode:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 4
    .line 5
    sget-object v1, Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;->NONE:Lcom/emanuelef/remote_capture/model/Prefs$DumpMode;

    .line 6
    .line 7
    if-eq v0, v1, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

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

.method public protect(I)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 2
    .line 3
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 4
    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    const/4 p1, 0x1

    .line 8
    return p1

    .line 9
    :cond_0
    invoke-super {p0, p1}, Landroid/net/VpnService;->protect(I)Z

    .line 10
    .line 11
    .line 12
    move-result p1

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

.method public reloadBlocklist()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBilling:Lcom/emanuelef/remote_capture/Billing;

    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Billing;->isFirewallVisible()Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    .line 2
    :cond_0
    const-string v0, "CaptureService"

    const-string v1, "reloading firewall blocklist"

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/MatchList;->toListDescriptor()Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;

    move-result-object v0

    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->reloadBlocklist(Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;)Z

    return-void
.end method

.method public reloadFirewallWhitelist()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBilling:Lcom/emanuelef/remote_capture/Billing;

    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Billing;->isFirewallVisible()Z

    move-result v0

    if-nez v0, :cond_0

    return-void

    .line 2
    :cond_0
    const-string v0, "CaptureService"

    const-string v1, "reloading firewall whitelist"

    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPrefs:Landroid/content/SharedPreferences;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/model/Prefs;->isFirewallWhitelistMode(Landroid/content/SharedPreferences;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mFirewallWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/MatchList;->toListDescriptor()Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;

    move-result-object v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Lcom/emanuelef/remote_capture/CaptureService;->reloadFirewallWhitelist(Lcom/emanuelef/remote_capture/model/MatchList$ListDescriptor;)Z

    return-void
.end method

.method public reportError(Ljava/lang/String;)V
    .locals 3

    .line 1
    const/4 v0, 0x1

    .line 2
    sput-boolean v0, Lcom/emanuelef/remote_capture/CaptureService;->HAS_ERROR:Z

    .line 3
    .line 4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 5
    .line 6
    new-instance v1, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;

    .line 7
    .line 8
    const/4 v2, 0x0

    .line 9
    invoke-direct {v1, p0, p1, v2}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda5;-><init>(Lcom/emanuelef/remote_capture/CaptureService;Ljava/lang/String;I)V

    .line 10
    .line 11
    .line 12
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

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

.method public run()V
    .locals 6

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->resolveHosts()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    const/4 v1, 0x0

    .line 6
    iput-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mUnderlyingNetwork:Landroid/net/Network;

    .line 7
    .line 8
    if-nez v0, :cond_0

    .line 9
    .line 10
    goto/16 :goto_1

    .line 11
    .line 12
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 13
    .line 14
    iget-boolean v2, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 15
    .line 16
    if-nez v2, :cond_3

    .line 17
    .line 18
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/CaptureSettings;->readFromPcap()Z

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    if-eqz v0, :cond_1

    .line 23
    .line 24
    goto :goto_0

    .line 25
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mParcelFileDescriptor:Landroid/os/ParcelFileDescriptor;

    .line 26
    .line 27
    if-eqz v0, :cond_5

    .line 28
    .line 29
    invoke-virtual {v0}, Landroid/os/ParcelFileDescriptor;->getFd()I

    .line 30
    .line 31
    .line 32
    move-result v0

    .line 33
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getFdSetSize()I

    .line 34
    .line 35
    .line 36
    move-result v2

    .line 37
    const-string v3, "CaptureService"

    .line 38
    .line 39
    if-lez v0, :cond_2

    .line 40
    .line 41
    if-ge v0, v2, :cond_2

    .line 42
    .line 43
    new-instance v4, Ljava/lang/StringBuilder;

    .line 44
    .line 45
    const-string v5, "VPN fd: "

    .line 46
    .line 47
    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 48
    .line 49
    .line 50
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    const-string v5, " - FD_SETSIZE: "

    .line 54
    .line 55
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    .line 57
    .line 58
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 59
    .line 60
    .line 61
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 62
    .line 63
    .line 64
    move-result-object v2

    .line 65
    invoke-static {v3, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    .line 67
    .line 68
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 69
    .line 70
    invoke-static {v0, p0, v2}, Lcom/emanuelef/remote_capture/CaptureService;->runPacketLoop(ILcom/emanuelef/remote_capture/CaptureService;I)V

    .line 71
    .line 72
    .line 73
    const/4 v0, 0x0

    .line 74
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mIsAlwaysOnVPN:Z

    .line 75
    .line 76
    goto :goto_1

    .line 77
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    .line 78
    .line 79
    const-string v4, "Invalid VPN fd: "

    .line 80
    .line 81
    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 82
    .line 83
    .line 84
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 85
    .line 86
    .line 87
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 88
    .line 89
    .line 90
    move-result-object v0

    .line 91
    invoke-static {v3, v0}, Lcom/emanuelef/remote_capture/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    .line 93
    .line 94
    goto :goto_1

    .line 95
    :cond_3
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mSettings:Lcom/emanuelef/remote_capture/model/CaptureSettings;

    .line 96
    .line 97
    iget-boolean v0, v0, Lcom/emanuelef/remote_capture/model/CaptureSettings;->root_capture:Z

    .line 98
    .line 99
    if-eqz v0, :cond_4

    .line 100
    .line 101
    const-string v0, "android.permission.INTERACT_ACROSS_USERS"

    .line 102
    .line 103
    invoke-virtual {p0, v0}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    .line 104
    .line 105
    .line 106
    move-result v2

    .line 107
    if-eqz v2, :cond_4

    .line 108
    .line 109
    invoke-static {p0, v0}, Lcom/emanuelef/remote_capture/Utils;->rootGrantPermission(Landroid/content/Context;Ljava/lang/String;)Z

    .line 110
    .line 111
    .line 112
    move-result v0

    .line 113
    iget-object v2, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 114
    .line 115
    new-instance v3, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda3;

    .line 116
    .line 117
    invoke-direct {v3, p0, v0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/CaptureService;Z)V

    .line 118
    .line 119
    .line 120
    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 121
    .line 122
    .line 123
    :cond_4
    const/4 v0, -0x1

    .line 124
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 125
    .line 126
    invoke-static {v0, p0, v2}, Lcom/emanuelef/remote_capture/CaptureService;->runPacketLoop(ILcom/emanuelef/remote_capture/CaptureService;I)V

    .line 127
    .line 128
    .line 129
    :cond_5
    :goto_1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mMalwareDetectionEnabled:Z

    .line 130
    .line 131
    if-eqz v0, :cond_6

    .line 132
    .line 133
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mBlacklists:Lcom/emanuelef/remote_capture/Blacklists;

    .line 134
    .line 135
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Blacklists;->save()V

    .line 136
    .line 137
    .line 138
    :cond_6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mParcelFileDescriptor:Landroid/os/ParcelFileDescriptor;

    .line 139
    .line 140
    if-eqz v0, :cond_7

    .line 141
    .line 142
    :try_start_0
    invoke-virtual {v0}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 143
    .line 144
    .line 145
    goto :goto_2

    .line 146
    :catch_0
    move-exception v0

    .line 147
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 148
    .line 149
    .line 150
    :goto_2
    iput-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mParcelFileDescriptor:Landroid/os/ParcelFileDescriptor;

    .line 151
    .line 152
    :cond_7
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/CaptureService;->stopAndJoinThreads()V

    .line 153
    .line 154
    .line 155
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->stopService()V

    .line 156
    .line 157
    .line 158
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 159
    .line 160
    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->lock()V

    .line 161
    .line 162
    .line 163
    iput-object v1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureThread:Ljava/lang/Thread;

    .line 164
    .line 165
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mCaptureStopped:Ljava/util/concurrent/locks/Condition;

    .line 166
    .line 167
    invoke-interface {v0}, Ljava/util/concurrent/locks/Condition;->signalAll()V

    .line 168
    .line 169
    .line 170
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mLock:Ljava/util/concurrent/locks/ReentrantLock;

    .line 171
    .line 172
    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantLock;->unlock()V

    .line 173
    .line 174
    .line 175
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 176
    .line 177
    new-instance v1, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;

    .line 178
    .line 179
    const/4 v2, 0x4

    .line 180
    invoke-direct {v1, v2, p0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 181
    .line 182
    .line 183
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 184
    .line 185
    .line 186
    return-void
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

.method public sendStatsDump(Lcom/emanuelef/remote_capture/model/CaptureStats;)V
    .locals 4

    .line 1
    iget-wide v0, p1, Lcom/emanuelef/remote_capture/model/CaptureStats;->bytes_sent:J

    .line 2
    .line 3
    iget-wide v2, p1, Lcom/emanuelef/remote_capture/model/CaptureStats;->bytes_rcvd:J

    .line 4
    .line 5
    add-long/2addr v0, v2

    .line 6
    iput-wide v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->last_bytes:J

    .line 7
    .line 8
    iget v0, p1, Lcom/emanuelef/remote_capture/model/CaptureStats;->tot_conns:I

    .line 9
    .line 10
    iput v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->last_connections:I

    .line 11
    .line 12
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 13
    .line 14
    new-instance v1, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;

    .line 15
    .line 16
    const/4 v2, 0x1

    .line 17
    invoke-direct {v1, v2, p0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 18
    .line 19
    .line 20
    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 21
    .line 22
    .line 23
    sget-object v0, Lcom/emanuelef/remote_capture/CaptureService;->lastStats:Landroidx/lifecycle/MutableLiveData;

    .line 24
    .line 25
    invoke-virtual {v0, p1}, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V

    .line 26
    .line 27
    .line 28
    return-void
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

.method public startConnectionsUpdate()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mNumUpdatesInProgress:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/4 v1, 0x1

    .line 8
    if-ne v0, v1, :cond_0

    .line 9
    .line 10
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHttpLog:Lcom/emanuelef/remote_capture/HttpLog;

    .line 11
    .line 12
    if-eqz v0, :cond_0

    .line 13
    .line 14
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/HttpLog;->startConnectionsUpdates()V

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
.end method

.method public stopPcapDump()V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumpQueue:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumperThread:Ljava/lang/Thread;

    .line 6
    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    invoke-virtual {v0}, Ljava/lang/Thread;->isAlive()Z

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    if-eqz v0, :cond_0

    .line 14
    .line 15
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mDumpQueue:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 16
    .line 17
    const/4 v1, 0x0

    .line 18
    new-array v1, v1, [B

    .line 19
    .line 20
    invoke-virtual {v0, v1}, Ljava/util/concurrent/LinkedBlockingDeque;->offer(Ljava/lang/Object;)Z

    .line 21
    .line 22
    .line 23
    :cond_0
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
    .line 58
.end method

.method public updateConnections([Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;[Lcom/emanuelef/remote_capture/model/ConnectionUpdate;)V
    .locals 2

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mQueueFull:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    goto :goto_0

    .line 6
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/CaptureService;->mPendingUpdates:Ljava/util/concurrent/LinkedBlockingDeque;

    .line 7
    .line 8
    new-instance v1, Landroid/util/Pair;

    .line 9
    .line 10
    invoke-direct {v1, p1, p2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 11
    .line 12
    .line 13
    invoke-virtual {v0, v1}, Ljava/util/concurrent/LinkedBlockingDeque;->offer(Ljava/lang/Object;)Z

    .line 14
    .line 15
    .line 16
    move-result p1

    .line 17
    if-nez p1, :cond_1

    .line 18
    .line 19
    const-string p1, "CaptureService"

    .line 20
    .line 21
    const-string p2, "The updates queue is full, this should never happen!"

    .line 22
    .line 23
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    .line 25
    .line 26
    const/4 p1, 0x1

    .line 27
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mQueueFull:Z

    .line 28
    .line 29
    iget-object p1, p0, Lcom/emanuelef/remote_capture/CaptureService;->mHandler:Landroid/os/Handler;

    .line 30
    .line 31
    new-instance p2, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;

    .line 32
    .line 33
    const/4 v0, 0x0

    .line 34
    invoke-direct {p2, v0}, Lcom/emanuelef/remote_capture/CaptureService$$ExternalSyntheticLambda1;-><init>(I)V

    .line 35
    .line 36
    .line 37
    invoke-virtual {p1, p2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 38
    .line 39
    .line 40
    :cond_1
    :goto_0
    return-void
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
