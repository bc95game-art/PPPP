.class public Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;
.super Landroidx/preference/PreferenceFragmentCompat;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SettingsFragment"
.end annotation


# instance fields
.field private mAutoBlockPrivateDNS:Landroidx/preference/SwitchPreference;

.field private mBlockQuic:Landroidx/preference/DropDownPreference;

.field private mCapInterface:Landroidx/preference/DropDownPreference;

.field private mDnsSettings:Landroidx/preference/Preference;

.field private mFullPayloadEnabled:Landroidx/preference/SwitchPreference;

.field private mHasStartedMitmWizard:Z

.field private mIab:Lcom/emanuelef/remote_capture/Billing;

.field private mIpMode:Landroidx/preference/DropDownPreference;

.field private mMalwareDetectionEnabled:Landroidx/preference/SwitchPreference;

.field private mMitmWizard:Landroidx/preference/Preference;

.field private mMitmproxyOpts:Landroidx/preference/EditTextPreference;

.field private mPcapngEnabled:Landroidx/preference/SwitchPreference;

.field private mPortMapping:Landroidx/preference/Preference;

.field private mRestartOnDisconnect:Landroidx/preference/SwitchPreference;

.field private mRootCaptureEnabled:Landroidx/preference/SwitchPreference;

.field private mRootDecryptionNoticeShown:Z

.field private mSocks5Settings:Landroidx/preference/Preference;

.field private mTlsDecryption:Landroidx/preference/SwitchPreference;

.field private mVpnExceptions:Landroidx/preference/Preference;


# direct methods
.method public static synthetic $r8$lambda$7Uc_AVKbNf5_ZZHvo6AXI1-VSmk(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$onViewCreated$0(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$C-VYMw2B514lvVLil-PXb0ZsWE8(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupTrafficInspectionPrefs$9(Landroidx/preference/Preference;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$Ckj973tKI8pdA6JORvOYSCm3Oa4(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupExporterPrefs$1(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$DocXGyDycJ8xLaZnf3y1DYEcSg8(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroid/content/SharedPreferences;Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupAppLanguagePref$12(Landroid/content/SharedPreferences;Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$HMs2fPIYt7TTq1ZGgu1xLXvdqt8(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupAppLanguagePref$11(Landroidx/preference/Preference;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$JheUb1ui0xT6lamrW8Gtp1A7-44(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupOtherPrefs$14(Landroidx/preference/Preference;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$PTwoZ-ZD5YZgpIxrSys1aERd5P4(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupExporterPrefs$3(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$PbMCzki4re8azfkphSYphxIcBtU(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupHttpServerPrefs$4(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$SHmf-AwtQeGRzUsOiACQmAIJz3I(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupTrafficInspectionPrefs$10(Landroidx/preference/Preference;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$UPOgkKQINneLZR2ntp-Gfq28S-A(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupOtherPrefs$13(Landroidx/preference/Preference;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$_-jmmuWMOEFM5ZZjp5p_LN3GL0Q(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupSecurityPrefs$7(Landroidx/preference/Preference;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$bu145Vtxol4mz4Hh8Q3eVUPFxME(Landroid/widget/EditText;)V
    .locals 0

    .line 1
    invoke-static {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupExporterPrefs$2(Landroid/widget/EditText;)V

    return-void
.end method

.method public static synthetic $r8$lambda$daIM-x0IjHV5anNtHtgkl9SRH0k(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$checkDecrpytionWithRoot$15(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$fZswANIjQICYDeuSlzLWtXVtu3A(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupTrafficInspectionPrefs$8(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$oyCK1qQSi_9uCyAaJ4eh8-yEHoE(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupCapturePrefs$6(Landroidx/preference/Preference;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$yY8uusJ6qI43-JdnLCIIWMZmvew(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->lambda$setupCapturePrefs$5(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Landroidx/preference/PreferenceFragmentCompat;-><init>()V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRootDecryptionNoticeShown:Z

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

.method private checkDecrpytionWithRoot(ZZ)Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRootDecryptionNoticeShown:Z

    .line 2
    .line 3
    if-nez v0, :cond_1

    .line 4
    .line 5
    if-eqz p1, :cond_1

    .line 6
    .line 7
    if-nez p2, :cond_0

    .line 8
    .line 9
    goto :goto_0

    .line 10
    :cond_0
    new-instance p1, Lcom/android/billingclient/api/zzbv;

    .line 11
    .line 12
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 13
    .line 14
    .line 15
    move-result-object p2

    .line 16
    invoke-direct {p1, p2}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 17
    .line 18
    .line 19
    const p2, 0x7f1402c5

    .line 20
    .line 21
    .line 22
    invoke-virtual {p1, p2}, Lcom/android/billingclient/api/zzbv;->setMessage(I)V

    .line 23
    .line 24
    .line 25
    new-instance p2, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;

    .line 26
    .line 27
    const/4 v0, 0x3

    .line 28
    invoke-direct {p2, v0, p0}, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 29
    .line 30
    .line 31
    const v0, 0x7f14021c

    .line 32
    .line 33
    .line 34
    invoke-virtual {p1, v0, p2}, Lcom/android/billingclient/api/zzbv;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 35
    .line 36
    .line 37
    invoke-virtual {p1}, Lcom/android/billingclient/api/zzbv;->show()Landroidx/appcompat/app/AlertDialog;

    .line 38
    .line 39
    .line 40
    const/4 p1, 0x0

    .line 41
    return p1

    .line 42
    :cond_1
    :goto_0
    const/4 p1, 0x1

    .line 43
    return p1
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

.method private isPcapngEnabled()Z
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 2
    .line 3
    const-string v1, "pcapng"

    .line 4
    .line 5
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/Billing;->isPurchased(Ljava/lang/String;)Z

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mPcapngEnabled:Landroidx/preference/SwitchPreference;

    .line 12
    .line 13
    iget-boolean v0, v0, Landroidx/preference/TwoStatePreference;->mChecked:Z

    .line 14
    .line 15
    if-eqz v0, :cond_0

    .line 16
    .line 17
    const/4 v0, 0x1

    .line 18
    return v0

    .line 19
    :cond_0
    const/4 v0, 0x0

    .line 20
    return v0
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

.method private synthetic lambda$checkDecrpytionWithRoot$15(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRootCaptureEnabled:Landroidx/preference/SwitchPreference;

    .line 2
    .line 3
    const/4 p2, 0x1

    .line 4
    invoke-virtual {p1, p2}, Landroidx/preference/TwoStatePreference;->setChecked(Z)V

    .line 5
    .line 6
    .line 7
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mTlsDecryption:Landroidx/preference/SwitchPreference;

    .line 8
    .line 9
    invoke-virtual {p1, p2}, Landroidx/preference/TwoStatePreference;->setChecked(Z)V

    .line 10
    .line 11
    .line 12
    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRootDecryptionNoticeShown:Z

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

.method private static lambda$onViewCreated$0(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 3

    .line 1
    const/16 v0, 0x87

    .line 2
    .line 3
    iget-object p1, p1, Landroidx/core/view/WindowInsetsCompat;->mImpl:Landroidx/core/view/WindowInsetsCompat$Impl;

    .line 4
    .line 5
    invoke-virtual {p1, v0}, Landroidx/core/view/WindowInsetsCompat$Impl;->getInsets(I)Landroidx/core/graphics/Insets;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    iget v0, p1, Landroidx/core/graphics/Insets;->left:I

    .line 10
    .line 11
    iget v1, p1, Landroidx/core/graphics/Insets;->top:I

    .line 12
    .line 13
    iget v2, p1, Landroidx/core/graphics/Insets;->right:I

    .line 14
    .line 15
    iget p1, p1, Landroidx/core/graphics/Insets;->bottom:I

    .line 16
    .line 17
    invoke-virtual {p0, v0, v1, v2, p1}, Landroid/view/View;->setPadding(IIII)V

    .line 18
    .line 19
    .line 20
    sget-object p0, Landroidx/core/view/WindowInsetsCompat;->CONSUMED:Landroidx/core/view/WindowInsetsCompat;

    .line 21
    .line 22
    return-object p0
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

.method private synthetic lambda$setupAppLanguagePref$11(Landroidx/preference/Preference;)Z
    .locals 3

    .line 1
    new-instance p1, Landroid/content/Intent;

    .line 2
    .line 3
    const-string v0, "android.settings.APP_LOCALE_SETTINGS"

    .line 4
    .line 5
    invoke-direct {p1, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    const/4 v1, 0x0

    .line 17
    const-string v2, "package"

    .line 18
    .line 19
    invoke-static {v2, v0, v1}, Landroid/net/Uri;->fromParts(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    invoke-virtual {p1, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 24
    .line 25
    .line 26
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 27
    .line 28
    .line 29
    const/4 p1, 0x1

    .line 30
    return p1
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

.method private synthetic lambda$setupAppLanguagePref$12(Landroid/content/SharedPreferences;Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 1

    .line 1
    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    const-string p2, "app_language"

    .line 6
    .line 7
    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 8
    .line 9
    .line 10
    move-result-object p3

    .line 11
    invoke-interface {p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 12
    .line 13
    .line 14
    move-result-object p1

    .line 15
    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 16
    .line 17
    .line 18
    move-result p1

    .line 19
    const/4 p2, 0x0

    .line 20
    if-eqz p1, :cond_0

    .line 21
    .line 22
    new-instance p1, Landroid/content/Intent;

    .line 23
    .line 24
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 25
    .line 26
    .line 27
    move-result-object p3

    .line 28
    const-class v0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity;

    .line 29
    .line 30
    invoke-direct {p1, p3, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 31
    .line 32
    .line 33
    const p3, 0x10008000

    .line 34
    .line 35
    .line 36
    invoke-virtual {p1, p3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 37
    .line 38
    .line 39
    const-string p3, "lang_restart"

    .line 40
    .line 41
    invoke-virtual {p1, p3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 42
    .line 43
    .line 44
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 45
    .line 46
    .line 47
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    .line 48
    .line 49
    .line 50
    move-result-object p1

    .line 51
    invoke-virtual {p1, p2}, Ljava/lang/Runtime;->exit(I)V

    .line 52
    .line 53
    .line 54
    :cond_0
    return p2
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

.method private lambda$setupCapturePrefs$5(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    check-cast p2, Ljava/lang/Boolean;

    .line 2
    .line 3
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->rootCaptureHideShow(Z)V

    .line 8
    .line 9
    .line 10
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    .line 11
    .line 12
    .line 13
    move-result p1

    .line 14
    iget-object p2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mTlsDecryption:Landroidx/preference/SwitchPreference;

    .line 15
    .line 16
    iget-boolean p2, p2, Landroidx/preference/TwoStatePreference;->mChecked:Z

    .line 17
    .line 18
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->checkDecrpytionWithRoot(ZZ)Z

    .line 19
    .line 20
    .line 21
    move-result p1

    .line 22
    return p1
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

.method private synthetic lambda$setupCapturePrefs$6(Landroidx/preference/Preference;)Z
    .locals 2

    .line 1
    new-instance p1, Landroid/content/Intent;

    .line 2
    .line 3
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-class v1, Lcom/emanuelef/remote_capture/activities/prefs/VpnExemptionsActivity;

    .line 8
    .line 9
    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 10
    .line 11
    .line 12
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 13
    .line 14
    .line 15
    const/4 p1, 0x1

    .line 16
    return p1
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

.method private static synthetic lambda$setupExporterPrefs$1(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Utils;->validateIpAddress(Ljava/lang/String;)Z

    .line 6
    .line 7
    .line 8
    move-result p0

    .line 9
    return p0
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

.method private static synthetic lambda$setupExporterPrefs$2(Landroid/widget/EditText;)V
    .locals 1

    .line 1
    const/16 v0, 0x1002

    .line 2
    .line 3
    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setInputType(I)V

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

.method private static synthetic lambda$setupExporterPrefs$3(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Utils;->validatePort(Ljava/lang/String;)Z

    .line 6
    .line 7
    .line 8
    move-result p0

    .line 9
    return p0
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

.method private static synthetic lambda$setupHttpServerPrefs$4(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 0

    .line 1
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    invoke-static {p0}, Lcom/emanuelef/remote_capture/Utils;->validatePort(Ljava/lang/String;)Z

    .line 6
    .line 7
    .line 8
    move-result p0

    .line 9
    return p0
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

.method private synthetic lambda$setupOtherPrefs$13(Landroidx/preference/Preference;)Z
    .locals 2

    .line 1
    new-instance p1, Landroid/content/Intent;

    .line 2
    .line 3
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-class v1, Lcom/emanuelef/remote_capture/activities/prefs/PortMapActivity;

    .line 8
    .line 9
    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 10
    .line 11
    .line 12
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 13
    .line 14
    .line 15
    const/4 p1, 0x1

    .line 16
    return p1
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

.method private synthetic lambda$setupOtherPrefs$14(Landroidx/preference/Preference;)Z
    .locals 2

    .line 1
    new-instance p1, Landroid/content/Intent;

    .line 2
    .line 3
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-class v1, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;

    .line 8
    .line 9
    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 10
    .line 11
    .line 12
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 13
    .line 14
    .line 15
    const/4 p1, 0x1

    .line 16
    return p1
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

.method private synthetic lambda$setupSecurityPrefs$7(Landroidx/preference/Preference;)Z
    .locals 2

    .line 1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 2
    .line 3
    const-string v0, "malware_detection"

    .line 4
    .line 5
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/Billing;->isPurchased(Ljava/lang/String;)Z

    .line 6
    .line 7
    .line 8
    move-result p1

    .line 9
    const/4 v0, 0x0

    .line 10
    if-nez p1, :cond_0

    .line 11
    .line 12
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMalwareDetectionEnabled:Landroidx/preference/SwitchPreference;

    .line 13
    .line 14
    invoke-virtual {p1, v0}, Landroidx/preference/TwoStatePreference;->setChecked(Z)V

    .line 15
    .line 16
    .line 17
    new-instance p1, Landroid/content/Intent;

    .line 18
    .line 19
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    const-class v1, Lcom/emanuelef/remote_capture/activities/IABActivity;

    .line 24
    .line 25
    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 26
    .line 27
    .line 28
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 29
    .line 30
    .line 31
    const/4 p1, 0x1

    .line 32
    return p1

    .line 33
    :cond_0
    return v0
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

.method private synthetic lambda$setupTrafficInspectionPrefs$10(Landroidx/preference/Preference;)Z
    .locals 3

    .line 1
    const/4 p1, 0x1

    .line 2
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mHasStartedMitmWizard:Z

    .line 3
    .line 4
    new-instance v0, Landroid/content/Intent;

    .line 5
    .line 6
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 7
    .line 8
    .line 9
    move-result-object v1

    .line 10
    const-class v2, Lcom/emanuelef/remote_capture/activities/MitmSetupWizard;

    .line 11
    .line 12
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 13
    .line 14
    .line 15
    invoke-virtual {p0, v0}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 16
    .line 17
    .line 18
    return p1
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

.method private synthetic lambda$setupTrafficInspectionPrefs$8(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 7

    .line 1
    check-cast p2, Ljava/lang/Boolean;

    .line 2
    .line 3
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    const/4 v1, 0x0

    .line 12
    if-eqz p1, :cond_0

    .line 13
    .line 14
    sget v2, Landroid/system/OsConstants;->_SC_PAGE_SIZE:I

    .line 15
    .line 16
    invoke-static {v2}, Landroid/system/Os;->sysconf(I)J

    .line 17
    .line 18
    .line 19
    move-result-wide v2

    .line 20
    const-wide/16 v4, 0x4000

    .line 21
    .line 22
    cmp-long v6, v2, v4

    .line 23
    .line 24
    if-nez v6, :cond_0

    .line 25
    .line 26
    const p1, 0x7f1402c3

    .line 27
    .line 28
    .line 29
    new-array p2, v1, [Ljava/lang/Object;

    .line 30
    .line 31
    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 32
    .line 33
    .line 34
    return v1

    .line 35
    :cond_0
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->rootCaptureEnabled()Z

    .line 36
    .line 37
    .line 38
    move-result v2

    .line 39
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    .line 40
    .line 41
    .line 42
    move-result v3

    .line 43
    invoke-direct {p0, v2, v3}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->checkDecrpytionWithRoot(ZZ)Z

    .line 44
    .line 45
    .line 46
    move-result v2

    .line 47
    if-nez v2, :cond_1

    .line 48
    .line 49
    return v1

    .line 50
    :cond_1
    const/4 v2, 0x1

    .line 51
    if-eqz p1, :cond_2

    .line 52
    .line 53
    invoke-static {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->needsSetup(Landroid/content/Context;)Z

    .line 54
    .line 55
    .line 56
    move-result p1

    .line 57
    if-eqz p1, :cond_2

    .line 58
    .line 59
    iput-boolean v2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mHasStartedMitmWizard:Z

    .line 60
    .line 61
    new-instance p1, Landroid/content/Intent;

    .line 62
    .line 63
    const-class p2, Lcom/emanuelef/remote_capture/activities/MitmSetupWizard;

    .line 64
    .line 65
    invoke-direct {p1, v0, p2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 66
    .line 67
    .line 68
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 69
    .line 70
    .line 71
    return v1

    .line 72
    :cond_2
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMitmWizard:Landroidx/preference/Preference;

    .line 73
    .line 74
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    .line 75
    .line 76
    .line 77
    move-result v0

    .line 78
    invoke-virtual {p1, v0}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 79
    .line 80
    .line 81
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMitmproxyOpts:Landroidx/preference/EditTextPreference;

    .line 82
    .line 83
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    .line 84
    .line 85
    .line 86
    move-result v0

    .line 87
    invoke-virtual {p1, v0}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 88
    .line 89
    .line 90
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    .line 91
    .line 92
    .line 93
    move-result p1

    .line 94
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->rootCaptureEnabled()Z

    .line 95
    .line 96
    .line 97
    move-result p2

    .line 98
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->socks5ProxyHideShow(ZZ)V

    .line 99
    .line 100
    .line 101
    return v2
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

.method private synthetic lambda$setupTrafficInspectionPrefs$9(Landroidx/preference/Preference;)Z
    .locals 2

    .line 1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 2
    .line 3
    const-string v0, "pcapng"

    .line 4
    .line 5
    invoke-virtual {p1, v0}, Lcom/emanuelef/remote_capture/Billing;->isPurchased(Ljava/lang/String;)Z

    .line 6
    .line 7
    .line 8
    move-result p1

    .line 9
    const/4 v0, 0x0

    .line 10
    if-nez p1, :cond_0

    .line 11
    .line 12
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mPcapngEnabled:Landroidx/preference/SwitchPreference;

    .line 13
    .line 14
    invoke-virtual {p1, v0}, Landroidx/preference/TwoStatePreference;->setChecked(Z)V

    .line 15
    .line 16
    .line 17
    new-instance p1, Landroid/content/Intent;

    .line 18
    .line 19
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    const-class v1, Lcom/emanuelef/remote_capture/activities/IABActivity;

    .line 24
    .line 25
    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 26
    .line 27
    .line 28
    invoke-virtual {p0, p1}, Landroidx/fragment/app/Fragment;->startActivity(Landroid/content/Intent;)V

    .line 29
    .line 30
    .line 31
    const/4 p1, 0x1

    .line 32
    return p1

    .line 33
    :cond_0
    return v0
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

.method private refreshInterfaces()V
    .locals 5

    .line 1
    new-instance v0, Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 4
    .line 5
    .line 6
    new-instance v1, Ljava/util/ArrayList;

    .line 7
    .line 8
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 9
    .line 10
    .line 11
    const v2, 0x7f140145

    .line 12
    .line 13
    .line 14
    invoke-virtual {p0, v2}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v2

    .line 18
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 19
    .line 20
    .line 21
    const-string v2, "@inet"

    .line 22
    .line 23
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 24
    .line 25
    .line 26
    const v2, 0x7f140025

    .line 27
    .line 28
    .line 29
    invoke-virtual {p0, v2}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 30
    .line 31
    .line 32
    move-result-object v2

    .line 33
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 34
    .line 35
    .line 36
    const-string v2, "any"

    .line 37
    .line 38
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 39
    .line 40
    .line 41
    :try_start_0
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->getNetworkInterfaces()Ljava/util/Enumeration;

    .line 42
    .line 43
    .line 44
    move-result-object v2

    .line 45
    :goto_0
    invoke-interface {v2}, Ljava/util/Enumeration;->hasMoreElements()Z

    .line 46
    .line 47
    .line 48
    move-result v3

    .line 49
    if-eqz v3, :cond_1

    .line 50
    .line 51
    invoke-interface {v2}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    .line 52
    .line 53
    .line 54
    move-result-object v3

    .line 55
    check-cast v3, Ljava/net/NetworkInterface;

    .line 56
    .line 57
    invoke-virtual {v3}, Ljava/net/NetworkInterface;->isUp()Z

    .line 58
    .line 59
    .line 60
    move-result v4

    .line 61
    if-nez v4, :cond_0

    .line 62
    .line 63
    goto :goto_0

    .line 64
    :cond_0
    invoke-virtual {v3}, Ljava/net/NetworkInterface;->getName()Ljava/lang/String;

    .line 65
    .line 66
    .line 67
    move-result-object v3

    .line 68
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 69
    .line 70
    .line 71
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    .line 73
    .line 74
    goto :goto_0

    .line 75
    :catch_0
    move-exception v2

    .line 76
    invoke-virtual {v2}, Ljava/lang/Throwable;->printStackTrace()V

    .line 77
    .line 78
    .line 79
    :cond_1
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mCapInterface:Landroidx/preference/DropDownPreference;

    .line 80
    .line 81
    const/4 v3, 0x0

    .line 82
    new-array v4, v3, [Ljava/lang/String;

    .line 83
    .line 84
    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 85
    .line 86
    .line 87
    move-result-object v1

    .line 88
    check-cast v1, [Ljava/lang/CharSequence;

    .line 89
    .line 90
    iput-object v1, v2, Landroidx/preference/ListPreference;->mEntryValues:[Ljava/lang/CharSequence;

    .line 91
    .line 92
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mCapInterface:Landroidx/preference/DropDownPreference;

    .line 93
    .line 94
    new-array v2, v3, [Ljava/lang/String;

    .line 95
    .line 96
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 97
    .line 98
    .line 99
    move-result-object v0

    .line 100
    check-cast v0, [Ljava/lang/CharSequence;

    .line 101
    .line 102
    iput-object v0, v1, Landroidx/preference/ListPreference;->mEntries:[Ljava/lang/CharSequence;

    .line 103
    .line 104
    iget-object v0, v1, Landroidx/preference/DropDownPreference;->mAdapter:Landroid/widget/ArrayAdapter;

    .line 105
    .line 106
    invoke-virtual {v0}, Landroid/widget/ArrayAdapter;->clear()V

    .line 107
    .line 108
    .line 109
    iget-object v1, v1, Landroidx/preference/ListPreference;->mEntries:[Ljava/lang/CharSequence;

    .line 110
    .line 111
    if-eqz v1, :cond_2

    .line 112
    .line 113
    array-length v2, v1

    .line 114
    :goto_1
    if-ge v3, v2, :cond_2

    .line 115
    .line 116
    aget-object v4, v1, v3

    .line 117
    .line 118
    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 119
    .line 120
    .line 121
    move-result-object v4

    .line 122
    invoke-virtual {v0, v4}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 123
    .line 124
    .line 125
    add-int/lit8 v3, v3, 0x1

    .line 126
    .line 127
    goto :goto_1

    .line 128
    :cond_2
    return-void
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

.method private requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroidx/preference/Preference;",
            ">(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .line 1
    invoke-virtual {p0, p1}, Landroidx/preference/PreferenceFragmentCompat;->findPreference(Ljava/lang/CharSequence;)Landroidx/preference/Preference;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    if-eqz p1, :cond_0

    .line 6
    .line 7
    return-object p1

    .line 8
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 9
    .line 10
    invoke-direct {p1}, Ljava/lang/IllegalStateException;-><init>()V

    .line 11
    .line 12
    .line 13
    throw p1
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

.method private rootCaptureEnabled()Z
    .locals 1

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->isRootAvailable()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRootCaptureEnabled:Landroidx/preference/SwitchPreference;

    .line 8
    .line 9
    iget-boolean v0, v0, Landroidx/preference/TwoStatePreference;->mChecked:Z

    .line 10
    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    const/4 v0, 0x1

    .line 14
    return v0

    .line 15
    :cond_0
    const/4 v0, 0x0

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

.method private rootCaptureHideShow(Z)V
    .locals 3

    .line 1
    const/4 v0, 0x0

    .line 2
    const/4 v1, 0x1

    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mAutoBlockPrivateDNS:Landroidx/preference/SwitchPreference;

    .line 6
    .line 7
    invoke-virtual {v2, v0}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 8
    .line 9
    .line 10
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mBlockQuic:Landroidx/preference/DropDownPreference;

    .line 11
    .line 12
    invoke-virtual {v2, v0}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 13
    .line 14
    .line 15
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mSocks5Settings:Landroidx/preference/Preference;

    .line 16
    .line 17
    invoke-virtual {v2, v0}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 18
    .line 19
    .line 20
    goto :goto_0

    .line 21
    :cond_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mAutoBlockPrivateDNS:Landroidx/preference/SwitchPreference;

    .line 22
    .line 23
    invoke-virtual {v2, v1}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 24
    .line 25
    .line 26
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mBlockQuic:Landroidx/preference/DropDownPreference;

    .line 27
    .line 28
    invoke-virtual {v2, v1}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 29
    .line 30
    .line 31
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mTlsDecryption:Landroidx/preference/SwitchPreference;

    .line 32
    .line 33
    iget-boolean v2, v2, Landroidx/preference/TwoStatePreference;->mChecked:Z

    .line 34
    .line 35
    invoke-direct {p0, v2, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->socks5ProxyHideShow(ZZ)V

    .line 36
    .line 37
    .line 38
    :goto_0
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->isAvailable()Z

    .line 39
    .line 40
    .line 41
    move-result v0

    .line 42
    if-eqz v0, :cond_1

    .line 43
    .line 44
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRestartOnDisconnect:Landroidx/preference/SwitchPreference;

    .line 45
    .line 46
    xor-int/lit8 v2, p1, 0x1

    .line 47
    .line 48
    invoke-virtual {v0, v2}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 49
    .line 50
    .line 51
    :cond_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIpMode:Landroidx/preference/DropDownPreference;

    .line 52
    .line 53
    xor-int/lit8 v2, p1, 0x1

    .line 54
    .line 55
    invoke-virtual {v0, v2}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 56
    .line 57
    .line 58
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mCapInterface:Landroidx/preference/DropDownPreference;

    .line 59
    .line 60
    invoke-virtual {v0, p1}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 61
    .line 62
    .line 63
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mVpnExceptions:Landroidx/preference/Preference;

    .line 64
    .line 65
    xor-int/lit8 v2, p1, 0x1

    .line 66
    .line 67
    invoke-virtual {v0, v2}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 68
    .line 69
    .line 70
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mDnsSettings:Landroidx/preference/Preference;

    .line 71
    .line 72
    xor-int/lit8 v2, p1, 0x1

    .line 73
    .line 74
    invoke-virtual {v0, v2}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 75
    .line 76
    .line 77
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mPortMapping:Landroidx/preference/Preference;

    .line 78
    .line 79
    xor-int/2addr p1, v1

    .line 80
    invoke-virtual {v0, p1}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 81
    .line 82
    .line 83
    return-void
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

.method private setupAppLanguagePref()V
    .locals 11

    .line 1
    const-string v0, "app_language"

    .line 2
    .line 3
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroidx/preference/DropDownPreference;

    .line 8
    .line 9
    const-string v1, "app_language_external"

    .line 10
    .line 11
    invoke-direct {p0, v1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 16
    .line 17
    const/16 v3, 0x21

    .line 18
    .line 19
    const v4, 0x7f1402b6

    .line 20
    .line 21
    .line 22
    const/4 v5, 0x1

    .line 23
    const/4 v6, 0x0

    .line 24
    if-lt v2, v3, :cond_2

    .line 25
    .line 26
    invoke-virtual {v0, v6}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 27
    .line 28
    .line 29
    invoke-virtual {v1, v5}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 30
    .line 31
    .line 32
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 33
    .line 34
    .line 35
    move-result-object v0

    .line 36
    const-class v2, Landroid/app/LocaleManager;

    .line 37
    .line 38
    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/Class;)Ljava/lang/Object;

    .line 39
    .line 40
    .line 41
    move-result-object v0

    .line 42
    check-cast v0, Landroid/app/LocaleManager;

    .line 43
    .line 44
    invoke-virtual {v0}, Landroid/app/LocaleManager;->getApplicationLocales()Landroid/os/LocaleList;

    .line 45
    .line 46
    .line 47
    move-result-object v0

    .line 48
    invoke-static {}, Landroid/os/LocaleList;->getEmptyLocaleList()Landroid/os/LocaleList;

    .line 49
    .line 50
    .line 51
    move-result-object v2

    .line 52
    invoke-virtual {v0, v2}, Landroid/os/LocaleList;->equals(Ljava/lang/Object;)Z

    .line 53
    .line 54
    .line 55
    move-result v2

    .line 56
    if-eqz v2, :cond_0

    .line 57
    .line 58
    invoke-virtual {p0, v4}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 59
    .line 60
    .line 61
    move-result-object v0

    .line 62
    invoke-virtual {v1, v0}, Landroidx/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 63
    .line 64
    .line 65
    goto :goto_0

    .line 66
    :cond_0
    invoke-virtual {v0}, Landroid/os/LocaleList;->isEmpty()Z

    .line 67
    .line 68
    .line 69
    move-result v2

    .line 70
    if-nez v2, :cond_1

    .line 71
    .line 72
    invoke-virtual {v0, v6}, Landroid/os/LocaleList;->get(I)Ljava/util/Locale;

    .line 73
    .line 74
    .line 75
    move-result-object v0

    .line 76
    invoke-virtual {v0}, Ljava/util/Locale;->getDisplayName()Ljava/lang/String;

    .line 77
    .line 78
    .line 79
    move-result-object v0

    .line 80
    invoke-virtual {v1, v0}, Landroidx/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 81
    .line 82
    .line 83
    :cond_1
    :goto_0
    new-instance v0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 84
    .line 85
    const/4 v2, 0x0

    .line 86
    invoke-direct {v0, p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 87
    .line 88
    .line 89
    iput-object v0, v1, Landroidx/preference/Preference;->mOnClickListener:Landroidx/preference/Preference$OnPreferenceClickListener;

    .line 90
    .line 91
    return-void

    .line 92
    :cond_2
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 93
    .line 94
    .line 95
    move-result-object v1

    .line 96
    invoke-static {v1}, Lcom/emanuelef/remote_capture/Utils;->getSupportedLocales(Landroid/content/Context;)[Ljava/lang/String;

    .line 97
    .line 98
    .line 99
    move-result-object v1

    .line 100
    array-length v2, v1

    .line 101
    add-int/2addr v2, v5

    .line 102
    new-array v2, v2, [Ljava/lang/String;

    .line 103
    .line 104
    array-length v3, v1

    .line 105
    add-int/2addr v3, v5

    .line 106
    new-array v3, v3, [Ljava/lang/CharSequence;

    .line 107
    .line 108
    const-string v7, "system"

    .line 109
    .line 110
    aput-object v7, v2, v6

    .line 111
    .line 112
    invoke-virtual {p0, v4}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 113
    .line 114
    .line 115
    move-result-object v4

    .line 116
    aput-object v4, v3, v6

    .line 117
    .line 118
    const/4 v4, 0x0

    .line 119
    :goto_1
    array-length v7, v1

    .line 120
    if-ge v4, v7, :cond_3

    .line 121
    .line 122
    aget-object v7, v1, v4

    .line 123
    .line 124
    invoke-static {v7}, Ljava/util/Locale;->forLanguageTag(Ljava/lang/String;)Ljava/util/Locale;

    .line 125
    .line 126
    .line 127
    move-result-object v7

    .line 128
    add-int/lit8 v8, v4, 0x1

    .line 129
    .line 130
    aget-object v4, v1, v4

    .line 131
    .line 132
    aput-object v4, v2, v8

    .line 133
    .line 134
    invoke-virtual {v7, v7}, Ljava/util/Locale;->getDisplayName(Ljava/util/Locale;)Ljava/lang/String;

    .line 135
    .line 136
    .line 137
    move-result-object v4

    .line 138
    new-instance v9, Ljava/lang/StringBuilder;

    .line 139
    .line 140
    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    .line 141
    .line 142
    .line 143
    invoke-virtual {v4, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 144
    .line 145
    .line 146
    move-result-object v10

    .line 147
    invoke-virtual {v10, v7}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    .line 148
    .line 149
    .line 150
    move-result-object v7

    .line 151
    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 152
    .line 153
    .line 154
    invoke-virtual {v4, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    .line 155
    .line 156
    .line 157
    move-result-object v4

    .line 158
    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 159
    .line 160
    .line 161
    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 162
    .line 163
    .line 164
    move-result-object v4

    .line 165
    aput-object v4, v3, v8

    .line 166
    .line 167
    move v4, v8

    .line 168
    goto :goto_1

    .line 169
    :cond_3
    iput-object v3, v0, Landroidx/preference/ListPreference;->mEntries:[Ljava/lang/CharSequence;

    .line 170
    .line 171
    iget-object v1, v0, Landroidx/preference/DropDownPreference;->mAdapter:Landroid/widget/ArrayAdapter;

    .line 172
    .line 173
    invoke-virtual {v1}, Landroid/widget/ArrayAdapter;->clear()V

    .line 174
    .line 175
    .line 176
    iget-object v3, v0, Landroidx/preference/ListPreference;->mEntries:[Ljava/lang/CharSequence;

    .line 177
    .line 178
    if-eqz v3, :cond_4

    .line 179
    .line 180
    array-length v4, v3

    .line 181
    :goto_2
    if-ge v6, v4, :cond_4

    .line 182
    .line 183
    aget-object v5, v3, v6

    .line 184
    .line 185
    invoke-interface {v5}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 186
    .line 187
    .line 188
    move-result-object v5

    .line 189
    invoke-virtual {v1, v5}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    .line 190
    .line 191
    .line 192
    add-int/lit8 v6, v6, 0x1

    .line 193
    .line 194
    goto :goto_2

    .line 195
    :cond_4
    iput-object v2, v0, Landroidx/preference/ListPreference;->mEntryValues:[Ljava/lang/CharSequence;

    .line 196
    .line 197
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 198
    .line 199
    .line 200
    move-result-object v1

    .line 201
    invoke-static {v1}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    .line 202
    .line 203
    .line 204
    move-result-object v1

    .line 205
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 206
    .line 207
    .line 208
    move-result-object v2

    .line 209
    invoke-virtual {v2}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    .line 210
    .line 211
    .line 212
    move-result-object v2

    .line 213
    invoke-virtual {v2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    .line 214
    .line 215
    .line 216
    move-result-object v2

    .line 217
    const-string v3, "lang_restart"

    .line 218
    .line 219
    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 220
    .line 221
    .line 222
    move-result v2

    .line 223
    if-eqz v2, :cond_5

    .line 224
    .line 225
    invoke-virtual {p0, v0}, Landroidx/preference/PreferenceFragmentCompat;->scrollToPreference(Landroidx/preference/Preference;)V

    .line 226
    .line 227
    .line 228
    :cond_5
    new-instance v2, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings$$ExternalSyntheticLambda3;

    .line 229
    .line 230
    const/4 v3, 0x1

    .line 231
    invoke-direct {v2, p0, v3, v1}, Lcom/emanuelef/remote_capture/fragments/prefs/GeoipSettings$$ExternalSyntheticLambda3;-><init>(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 232
    .line 233
    .line 234
    iput-object v2, v0, Landroidx/preference/Preference;->mOnChangeListener:Landroidx/preference/Preference$OnPreferenceChangeListener;

    .line 235
    .line 236
    return-void
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

.method private setupCapturePrefs()V
    .locals 3

    .line 1
    const-string v0, "capture_interface"

    .line 2
    .line 3
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroidx/preference/DropDownPreference;

    .line 8
    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mCapInterface:Landroidx/preference/DropDownPreference;

    .line 10
    .line 11
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->refreshInterfaces()V

    .line 12
    .line 13
    .line 14
    const-string v0, "root_capture"

    .line 15
    .line 16
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    check-cast v0, Landroidx/preference/SwitchPreference;

    .line 21
    .line 22
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRootCaptureEnabled:Landroidx/preference/SwitchPreference;

    .line 23
    .line 24
    invoke-static {}, Lcom/emanuelef/remote_capture/Utils;->isRootAvailable()Z

    .line 25
    .line 26
    .line 27
    move-result v0

    .line 28
    if-eqz v0, :cond_0

    .line 29
    .line 30
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRootCaptureEnabled:Landroidx/preference/SwitchPreference;

    .line 31
    .line 32
    new-instance v1, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 33
    .line 34
    const/4 v2, 0x1

    .line 35
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 36
    .line 37
    .line 38
    iput-object v1, v0, Landroidx/preference/Preference;->mOnChangeListener:Landroidx/preference/Preference$OnPreferenceChangeListener;

    .line 39
    .line 40
    goto :goto_0

    .line 41
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRootCaptureEnabled:Landroidx/preference/SwitchPreference;

    .line 42
    .line 43
    const/4 v1, 0x0

    .line 44
    invoke-virtual {v0, v1}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 45
    .line 46
    .line 47
    :goto_0
    const-string v0, "restart_on_disconnect"

    .line 48
    .line 49
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 50
    .line 51
    .line 52
    move-result-object v0

    .line 53
    check-cast v0, Landroidx/preference/SwitchPreference;

    .line 54
    .line 55
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mRestartOnDisconnect:Landroidx/preference/SwitchPreference;

    .line 56
    .line 57
    invoke-static {}, Lcom/emanuelef/remote_capture/VpnReconnectService;->isAvailable()Z

    .line 58
    .line 59
    .line 60
    move-result v1

    .line 61
    invoke-virtual {v0, v1}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 62
    .line 63
    .line 64
    const-string v0, "dns_settings"

    .line 65
    .line 66
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 67
    .line 68
    .line 69
    move-result-object v0

    .line 70
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mDnsSettings:Landroidx/preference/Preference;

    .line 71
    .line 72
    const-string v0, "vpn_exceptions"

    .line 73
    .line 74
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mVpnExceptions:Landroidx/preference/Preference;

    .line 79
    .line 80
    new-instance v1, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 81
    .line 82
    const/4 v2, 0x2

    .line 83
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 84
    .line 85
    .line 86
    iput-object v1, v0, Landroidx/preference/Preference;->mOnClickListener:Landroidx/preference/Preference$OnPreferenceClickListener;

    .line 87
    .line 88
    return-void
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

.method private setupExporterPrefs()V
    .locals 3

    .line 1
    const-string v0, "collector_ip_address"

    .line 2
    .line 3
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroidx/preference/EditTextPreference;

    .line 8
    .line 9
    new-instance v1, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;

    .line 10
    .line 11
    const/4 v2, 0x2

    .line 12
    invoke-direct {v1, v2}, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;-><init>(I)V

    .line 13
    .line 14
    .line 15
    iput-object v1, v0, Landroidx/preference/Preference;->mOnChangeListener:Landroidx/preference/Preference$OnPreferenceChangeListener;

    .line 16
    .line 17
    const-string v0, "collector_port"

    .line 18
    .line 19
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    check-cast v0, Landroidx/preference/EditTextPreference;

    .line 24
    .line 25
    new-instance v1, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;

    .line 26
    .line 27
    const/4 v2, 0x3

    .line 28
    invoke-direct {v1, v2}, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;-><init>(I)V

    .line 29
    .line 30
    .line 31
    iput-object v1, v0, Landroidx/preference/EditTextPreference;->mOnBindEditTextListener:Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;

    .line 32
    .line 33
    new-instance v1, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 34
    .line 35
    const/16 v2, 0x1c

    .line 36
    .line 37
    invoke-direct {v1, v2}, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;-><init>(I)V

    .line 38
    .line 39
    .line 40
    iput-object v1, v0, Landroidx/preference/Preference;->mOnChangeListener:Landroidx/preference/Preference$OnPreferenceChangeListener;

    .line 41
    .line 42
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

.method private setupHttpServerPrefs()V
    .locals 3

    .line 1
    const-string v0, "http_server_port"

    .line 2
    .line 3
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroidx/preference/EditTextPreference;

    .line 8
    .line 9
    new-instance v1, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;

    .line 10
    .line 11
    const/4 v2, 0x1

    .line 12
    invoke-direct {v1, v2}, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;-><init>(I)V

    .line 13
    .line 14
    .line 15
    iput-object v1, v0, Landroidx/preference/Preference;->mOnChangeListener:Landroidx/preference/Preference$OnPreferenceChangeListener;

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

.method private setupOtherPrefs()V
    .locals 3

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->setupAppLanguagePref()V

    .line 2
    .line 3
    .line 4
    const-string v0, "port_mapping"

    .line 5
    .line 6
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mPortMapping:Landroidx/preference/Preference;

    .line 11
    .line 12
    new-instance v1, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 13
    .line 14
    const/4 v2, 0x7

    .line 15
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 16
    .line 17
    .line 18
    iput-object v1, v0, Landroidx/preference/Preference;->mOnClickListener:Landroidx/preference/Preference$OnPreferenceClickListener;

    .line 19
    .line 20
    const-string v0, "ip_mode"

    .line 21
    .line 22
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    check-cast v0, Landroidx/preference/DropDownPreference;

    .line 27
    .line 28
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIpMode:Landroidx/preference/DropDownPreference;

    .line 29
    .line 30
    const-string v0, "control_permissions"

    .line 31
    .line 32
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 33
    .line 34
    .line 35
    move-result-object v0

    .line 36
    new-instance v1, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 37
    .line 38
    const/16 v2, 0x8

    .line 39
    .line 40
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 41
    .line 42
    .line 43
    iput-object v1, v0, Landroidx/preference/Preference;->mOnClickListener:Landroidx/preference/Preference$OnPreferenceClickListener;

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

.method private setupSecurityPrefs()V
    .locals 6

    .line 1
    const-string v0, "malware_detection"

    .line 2
    .line 3
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroidx/preference/SwitchPreference;

    .line 8
    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMalwareDetectionEnabled:Landroidx/preference/SwitchPreference;

    .line 10
    .line 11
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 12
    .line 13
    const-string v1, "malware_detection"

    .line 14
    .line 15
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/Billing;->isAvailable(Ljava/lang/String;)Z

    .line 16
    .line 17
    .line 18
    move-result v0

    .line 19
    if-nez v0, :cond_3

    .line 20
    .line 21
    invoke-virtual {p0}, Landroidx/preference/PreferenceFragmentCompat;->getPreferenceScreen()Landroidx/preference/PreferenceScreen;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    const-string v1, "security"

    .line 26
    .line 27
    invoke-direct {p0, v1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    monitor-enter v0

    .line 32
    :try_start_0
    invoke-virtual {v1}, Landroidx/preference/Preference;->unregisterDependency()V

    .line 33
    .line 34
    .line 35
    iget-object v2, v1, Landroidx/preference/Preference;->mParentGroup:Landroidx/preference/PreferenceGroup;

    .line 36
    .line 37
    if-ne v2, v0, :cond_0

    .line 38
    .line 39
    const/4 v2, 0x0

    .line 40
    iput-object v2, v1, Landroidx/preference/Preference;->mParentGroup:Landroidx/preference/PreferenceGroup;

    .line 41
    .line 42
    goto :goto_0

    .line 43
    :catchall_0
    move-exception v1

    .line 44
    goto :goto_1

    .line 45
    :cond_0
    :goto_0
    iget-object v2, v0, Landroidx/preference/PreferenceGroup;->mPreferences:Ljava/util/ArrayList;

    .line 46
    .line 47
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 48
    .line 49
    .line 50
    move-result v2

    .line 51
    if-eqz v2, :cond_2

    .line 52
    .line 53
    iget-object v2, v1, Landroidx/preference/Preference;->mKey:Ljava/lang/String;

    .line 54
    .line 55
    if-eqz v2, :cond_1

    .line 56
    .line 57
    iget-object v3, v0, Landroidx/preference/PreferenceGroup;->mIdRecycleCache:Landroidx/collection/SimpleArrayMap;

    .line 58
    .line 59
    invoke-virtual {v1}, Landroidx/preference/Preference;->getId()J

    .line 60
    .line 61
    .line 62
    move-result-wide v4

    .line 63
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 64
    .line 65
    .line 66
    move-result-object v4

    .line 67
    invoke-virtual {v3, v2, v4}, Landroidx/collection/SimpleArrayMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    .line 69
    .line 70
    iget-object v2, v0, Landroidx/preference/PreferenceGroup;->mHandler:Landroid/os/Handler;

    .line 71
    .line 72
    iget-object v3, v0, Landroidx/preference/PreferenceGroup;->mClearRecycleCacheRunnable:Landroidx/preference/PreferenceGroup$1;

    .line 73
    .line 74
    invoke-virtual {v2, v3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 75
    .line 76
    .line 77
    iget-object v2, v0, Landroidx/preference/PreferenceGroup;->mHandler:Landroid/os/Handler;

    .line 78
    .line 79
    iget-object v3, v0, Landroidx/preference/PreferenceGroup;->mClearRecycleCacheRunnable:Landroidx/preference/PreferenceGroup$1;

    .line 80
    .line 81
    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 82
    .line 83
    .line 84
    :cond_1
    iget-boolean v2, v0, Landroidx/preference/PreferenceGroup;->mAttachedToHierarchy:Z

    .line 85
    .line 86
    if-eqz v2, :cond_2

    .line 87
    .line 88
    invoke-virtual {v1}, Landroidx/preference/Preference;->onDetached()V

    .line 89
    .line 90
    .line 91
    :cond_2
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 92
    iget-object v0, v0, Landroidx/preference/Preference;->mListener:Landroidx/preference/PreferenceGroupAdapter;

    .line 93
    .line 94
    if-eqz v0, :cond_4

    .line 95
    .line 96
    iget-object v1, v0, Landroidx/preference/PreferenceGroupAdapter;->mHandler:Landroid/os/Handler;

    .line 97
    .line 98
    iget-object v0, v0, Landroidx/preference/PreferenceGroupAdapter;->mSyncRunnable:Landroidx/preference/PreferenceGroup$1;

    .line 99
    .line 100
    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 101
    .line 102
    .line 103
    invoke-virtual {v1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 104
    .line 105
    .line 106
    return-void

    .line 107
    :goto_1
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 108
    throw v1

    .line 109
    :cond_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMalwareDetectionEnabled:Landroidx/preference/SwitchPreference;

    .line 110
    .line 111
    new-instance v1, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 112
    .line 113
    const/4 v2, 0x6

    .line 114
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 115
    .line 116
    .line 117
    iput-object v1, v0, Landroidx/preference/Preference;->mOnClickListener:Landroidx/preference/Preference$OnPreferenceClickListener;

    .line 118
    .line 119
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 120
    .line 121
    const-string v1, "malware_detection"

    .line 122
    .line 123
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/Billing;->isPurchased(Ljava/lang/String;)Z

    .line 124
    .line 125
    .line 126
    move-result v0

    .line 127
    if-nez v0, :cond_4

    .line 128
    .line 129
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMalwareDetectionEnabled:Landroidx/preference/SwitchPreference;

    .line 130
    .line 131
    const/4 v1, 0x0

    .line 132
    invoke-virtual {v0, v1}, Landroidx/preference/TwoStatePreference;->setChecked(Z)V

    .line 133
    .line 134
    .line 135
    :cond_4
    return-void
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

.method private setupTrafficInspectionPrefs()V
    .locals 5

    .line 1
    const-string v0, "auto_block_private_dns"

    .line 2
    .line 3
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Landroidx/preference/SwitchPreference;

    .line 8
    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mAutoBlockPrivateDNS:Landroidx/preference/SwitchPreference;

    .line 10
    .line 11
    const-string v0, "tls_decryption"

    .line 12
    .line 13
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    check-cast v0, Landroidx/preference/SwitchPreference;

    .line 18
    .line 19
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mTlsDecryption:Landroidx/preference/SwitchPreference;

    .line 20
    .line 21
    new-instance v1, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 22
    .line 23
    const/4 v2, 0x3

    .line 24
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 25
    .line 26
    .line 27
    iput-object v1, v0, Landroidx/preference/Preference;->mOnChangeListener:Landroidx/preference/Preference$OnPreferenceChangeListener;

    .line 28
    .line 29
    const-string v0, "pcapng_format"

    .line 30
    .line 31
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    check-cast v0, Landroidx/preference/SwitchPreference;

    .line 36
    .line 37
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mPcapngEnabled:Landroidx/preference/SwitchPreference;

    .line 38
    .line 39
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 40
    .line 41
    const-string v1, "pcapng"

    .line 42
    .line 43
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/Billing;->isAvailable(Ljava/lang/String;)Z

    .line 44
    .line 45
    .line 46
    move-result v0

    .line 47
    const/4 v2, 0x0

    .line 48
    if-eqz v0, :cond_0

    .line 49
    .line 50
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mPcapngEnabled:Landroidx/preference/SwitchPreference;

    .line 51
    .line 52
    new-instance v3, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 53
    .line 54
    const/4 v4, 0x4

    .line 55
    invoke-direct {v3, p0, v4}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 56
    .line 57
    .line 58
    iput-object v3, v0, Landroidx/preference/Preference;->mOnClickListener:Landroidx/preference/Preference$OnPreferenceClickListener;

    .line 59
    .line 60
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 61
    .line 62
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/Billing;->isPurchased(Ljava/lang/String;)Z

    .line 63
    .line 64
    .line 65
    move-result v0

    .line 66
    if-nez v0, :cond_1

    .line 67
    .line 68
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mPcapngEnabled:Landroidx/preference/SwitchPreference;

    .line 69
    .line 70
    invoke-virtual {v0, v2}, Landroidx/preference/TwoStatePreference;->setChecked(Z)V

    .line 71
    .line 72
    .line 73
    goto :goto_0

    .line 74
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mPcapngEnabled:Landroidx/preference/SwitchPreference;

    .line 75
    .line 76
    invoke-virtual {v0, v2}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 77
    .line 78
    .line 79
    :cond_1
    :goto_0
    const-string v0, "full_payload"

    .line 80
    .line 81
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 82
    .line 83
    .line 84
    move-result-object v0

    .line 85
    check-cast v0, Landroidx/preference/SwitchPreference;

    .line 86
    .line 87
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mFullPayloadEnabled:Landroidx/preference/SwitchPreference;

    .line 88
    .line 89
    const-string v0, "block_quic_mode"

    .line 90
    .line 91
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 92
    .line 93
    .line 94
    move-result-object v0

    .line 95
    check-cast v0, Landroidx/preference/DropDownPreference;

    .line 96
    .line 97
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mBlockQuic:Landroidx/preference/DropDownPreference;

    .line 98
    .line 99
    const-string v0, "mitmproxy_opts"

    .line 100
    .line 101
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 102
    .line 103
    .line 104
    move-result-object v0

    .line 105
    check-cast v0, Landroidx/preference/EditTextPreference;

    .line 106
    .line 107
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMitmproxyOpts:Landroidx/preference/EditTextPreference;

    .line 108
    .line 109
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mTlsDecryption:Landroidx/preference/SwitchPreference;

    .line 110
    .line 111
    iget-boolean v1, v1, Landroidx/preference/TwoStatePreference;->mChecked:Z

    .line 112
    .line 113
    invoke-virtual {v0, v1}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 114
    .line 115
    .line 116
    const-string v0, "mitm_setup_wizard"

    .line 117
    .line 118
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 119
    .line 120
    .line 121
    move-result-object v0

    .line 122
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMitmWizard:Landroidx/preference/Preference;

    .line 123
    .line 124
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mTlsDecryption:Landroidx/preference/SwitchPreference;

    .line 125
    .line 126
    iget-boolean v1, v1, Landroidx/preference/TwoStatePreference;->mChecked:Z

    .line 127
    .line 128
    invoke-virtual {v0, v1}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 129
    .line 130
    .line 131
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mMitmWizard:Landroidx/preference/Preference;

    .line 132
    .line 133
    new-instance v1, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;

    .line 134
    .line 135
    const/4 v2, 0x5

    .line 136
    invoke-direct {v1, p0, v2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3;-><init>(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;I)V

    .line 137
    .line 138
    .line 139
    iput-object v1, v0, Landroidx/preference/Preference;->mOnClickListener:Landroidx/preference/Preference$OnPreferenceClickListener;

    .line 140
    .line 141
    const-string v0, "socks5_settings"

    .line 142
    .line 143
    invoke-direct {p0, v0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->requirePreference(Ljava/lang/String;)Landroidx/preference/Preference;

    .line 144
    .line 145
    .line 146
    move-result-object v0

    .line 147
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mSocks5Settings:Landroidx/preference/Preference;

    .line 148
    .line 149
    return-void
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

.method private socks5ProxyHideShow(ZZ)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mSocks5Settings:Landroidx/preference/Preference;

    .line 2
    .line 3
    if-nez p1, :cond_0

    .line 4
    .line 5
    if-nez p2, :cond_0

    .line 6
    .line 7
    const/4 p1, 0x1

    .line 8
    goto :goto_0

    .line 9
    :cond_0
    const/4 p1, 0x0

    .line 10
    :goto_0
    invoke-virtual {v0, p1}, Landroidx/preference/Preference;->setVisible(Z)V

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
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .line 1
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-static {v0}, Lcom/emanuelef/remote_capture/Billing;->newInstance(Landroid/content/Context;)Lcom/emanuelef/remote_capture/PlayBilling;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    iput-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 10
    .line 11
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Billing;->connectBilling()V

    .line 12
    .line 13
    .line 14
    invoke-super {p0, p1}, Landroidx/preference/PreferenceFragmentCompat;->onCreate(Landroid/os/Bundle;)V

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

.method public onCreatePreferences(Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 0

    .line 1
    const p1, 0x7f170008

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0, p1, p2}, Landroidx/preference/PreferenceFragmentCompat;->setPreferencesFromResource(ILjava/lang/String;)V

    .line 5
    .line 6
    .line 7
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->setupExporterPrefs()V

    .line 8
    .line 9
    .line 10
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->setupHttpServerPrefs()V

    .line 11
    .line 12
    .line 13
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->setupTrafficInspectionPrefs()V

    .line 14
    .line 15
    .line 16
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->setupCapturePrefs()V

    .line 17
    .line 18
    .line 19
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->setupSecurityPrefs()V

    .line 20
    .line 21
    .line 22
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->setupOtherPrefs()V

    .line 23
    .line 24
    .line 25
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mTlsDecryption:Landroidx/preference/SwitchPreference;

    .line 26
    .line 27
    iget-boolean p1, p1, Landroidx/preference/TwoStatePreference;->mChecked:Z

    .line 28
    .line 29
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->rootCaptureEnabled()Z

    .line 30
    .line 31
    .line 32
    move-result p2

    .line 33
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->socks5ProxyHideShow(ZZ)V

    .line 34
    .line 35
    .line 36
    iget-object p1, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mBlockQuic:Landroidx/preference/DropDownPreference;

    .line 37
    .line 38
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->rootCaptureEnabled()Z

    .line 39
    .line 40
    .line 41
    move-result p2

    .line 42
    xor-int/lit8 p2, p2, 0x1

    .line 43
    .line 44
    invoke-virtual {p1, p2}, Landroidx/preference/Preference;->setVisible(Z)V

    .line 45
    .line 46
    .line 47
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->rootCaptureEnabled()Z

    .line 48
    .line 49
    .line 50
    move-result p1

    .line 51
    invoke-direct {p0, p1}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->rootCaptureHideShow(Z)V

    .line 52
    .line 53
    .line 54
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    .line 55
    .line 56
    .line 57
    move-result-object p1

    .line 58
    invoke-virtual {p1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    .line 59
    .line 60
    .line 61
    move-result-object p1

    .line 62
    if-eqz p1, :cond_0

    .line 63
    .line 64
    const-string p2, "target_pref"

    .line 65
    .line 66
    invoke-virtual {p1, p2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 67
    .line 68
    .line 69
    move-result-object p1

    .line 70
    if-eqz p1, :cond_0

    .line 71
    .line 72
    invoke-virtual {p0, p1}, Landroidx/preference/PreferenceFragmentCompat;->scrollToPreference(Ljava/lang/String;)V

    .line 73
    .line 74
    .line 75
    :cond_0
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

.method public onDestroy()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mIab:Lcom/emanuelef/remote_capture/Billing;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/Billing;->disconnectBilling()V

    .line 4
    .line 5
    .line 6
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onDestroy()V

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
    .line 58
.end method

.method public onResume()V
    .locals 2

    .line 1
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 2
    .line 3
    .line 4
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mHasStartedMitmWizard:Z

    .line 5
    .line 6
    if-eqz v0, :cond_0

    .line 7
    .line 8
    invoke-virtual {p0}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-static {v0}, Lcom/emanuelef/remote_capture/MitmAddon;->needsSetup(Landroid/content/Context;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    if-nez v0, :cond_0

    .line 17
    .line 18
    const-string v0, "SettingsActivity"

    .line 19
    .line 20
    const-string v1, "mitm setup complete, enabling"

    .line 21
    .line 22
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 23
    .line 24
    .line 25
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mTlsDecryption:Landroidx/preference/SwitchPreference;

    .line 26
    .line 27
    const/4 v1, 0x1

    .line 28
    invoke-virtual {v0, v1}, Landroidx/preference/TwoStatePreference;->setChecked(Z)V

    .line 29
    .line 30
    .line 31
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mFullPayloadEnabled:Landroidx/preference/SwitchPreference;

    .line 32
    .line 33
    invoke-virtual {v0, v1}, Landroidx/preference/TwoStatePreference;->setChecked(Z)V

    .line 34
    .line 35
    .line 36
    :cond_0
    const/4 v0, 0x0

    .line 37
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->mHasStartedMitmWizard:Z

    .line 38
    .line 39
    return-void
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

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 1

    .line 1
    invoke-super {p0, p1, p2}, Landroidx/preference/PreferenceFragmentCompat;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    new-instance p2, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 5
    .line 6
    const/16 v0, 0x1d

    .line 7
    .line 8
    invoke-direct {p2, v0}, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;-><init>(I)V

    .line 9
    .line 10
    .line 11
    sget-object v0, Landroidx/core/view/ViewCompat;->sViewPropertyAnimatorMap:Ljava/util/WeakHashMap;

    .line 12
    .line 13
    invoke-static {p1, p2}, Landroidx/core/view/ViewCompat$Api21Impl;->setOnApplyWindowInsetsListener(Landroid/view/View;Landroidx/core/view/OnApplyWindowInsetsListener;)V

    .line 14
    .line 15
    .line 16
    return-void
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
