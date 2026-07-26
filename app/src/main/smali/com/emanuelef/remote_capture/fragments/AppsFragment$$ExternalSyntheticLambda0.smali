.class public final synthetic Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;->$r8$classId:I

    .line 2
    .line 3
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 4
    .line 5
    packed-switch v0, :pswitch_data_0

    .line 6
    .line 7
    .line 8
    check-cast v1, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;

    .line 9
    .line 10
    invoke-static {v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;->$r8$lambda$TIkd5UfSccKOJrcdXN64unDzGSQ(Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;Landroid/content/DialogInterface;I)V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :pswitch_0
    check-cast v1, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    .line 15
    .line 16
    invoke-static {v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$No4-RiTH4DVP9vnRpl7aSA13XDA(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/content/DialogInterface;I)V

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :pswitch_1
    check-cast v1, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    .line 21
    .line 22
    invoke-static {v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->$r8$lambda$SEAnMG5Xtg_OATMhX7hypBfsYBo(Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;Landroid/content/DialogInterface;I)V

    .line 23
    .line 24
    .line 25
    return-void

    .line 26
    :pswitch_2
    check-cast v1, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;

    .line 27
    .line 28
    invoke-static {v1, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->$r8$lambda$daIM-x0IjHV5anNtHtgkl9SRH0k(Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;Landroid/content/DialogInterface;I)V

    .line 29
    .line 30
    .line 31
    return-void

    .line 32
    :pswitch_3
    check-cast v1, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;

    .line 33
    .line 34
    invoke-static {v1, p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;->$r8$lambda$LZXyVT7503AjkRjF2pOTweAmvFk(Lcom/emanuelef/remote_capture/activities/prefs/EditCtrlPermissions;Landroid/content/DialogInterface;I)V

    .line 35
    .line 36
    .line 37
    return-void

    .line 38
    :pswitch_4
    check-cast v1, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;

    .line 39
    .line 40
    sget p1, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;->$r8$clinit:I

    .line 41
    .line 42
    invoke-virtual {v1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    .line 43
    .line 44
    .line 45
    move-result-object p1

    .line 46
    invoke-static {v1, p1}, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->getAllErrorDetailsFromIntent(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;

    .line 47
    .line 48
    .line 49
    move-result-object p1

    .line 50
    const-string p2, "clipboard"

    .line 51
    .line 52
    invoke-virtual {v1, p2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 53
    .line 54
    .line 55
    move-result-object p2

    .line 56
    check-cast p2, Landroid/content/ClipboardManager;

    .line 57
    .line 58
    if-eqz p2, :cond_0

    .line 59
    .line 60
    const v0, 0x7f1400b7

    .line 61
    .line 62
    .line 63
    invoke-virtual {v1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 64
    .line 65
    .line 66
    move-result-object v0

    .line 67
    invoke-static {v0, p1}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    .line 68
    .line 69
    .line 70
    move-result-object p1

    .line 71
    invoke-virtual {p2, p1}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 72
    .line 73
    .line 74
    const p1, 0x7f1400b9

    .line 75
    .line 76
    .line 77
    const/4 p2, 0x0

    .line 78
    invoke-static {v1, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    .line 79
    .line 80
    .line 81
    move-result-object p1

    .line 82
    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    .line 83
    .line 84
    .line 85
    :cond_0
    return-void

    .line 86
    :pswitch_5
    check-cast v1, Lcom/emanuelef/remote_capture/fragments/AppsFragment;

    .line 87
    .line 88
    invoke-static {v1, p1, p2}, Lcom/emanuelef/remote_capture/fragments/AppsFragment;->$r8$lambda$hH4jMxHU964XofBMt9zYLuEK-9g(Lcom/emanuelef/remote_capture/fragments/AppsFragment;Landroid/content/DialogInterface;I)V

    .line 89
    .line 90
    .line 91
    return-void

    .line 92
    nop

    .line 93
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
