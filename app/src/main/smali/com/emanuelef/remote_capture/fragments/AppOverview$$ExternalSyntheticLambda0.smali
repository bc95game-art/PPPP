.class public final synthetic Lcom/emanuelef/remote_capture/fragments/AppOverview$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;

.field public final synthetic f$1:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Ljava/lang/Object;ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/fragments/AppOverview$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/AppOverview$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/fragments/AppOverview$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/AppOverview$$ExternalSyntheticLambda0;->$r8$classId:I

    .line 2
    .line 3
    iget-object v1, p0, Lcom/emanuelef/remote_capture/fragments/AppOverview$$ExternalSyntheticLambda0;->f$1:Ljava/lang/Object;

    .line 4
    .line 5
    iget-object v2, p0, Lcom/emanuelef/remote_capture/fragments/AppOverview$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 6
    .line 7
    packed-switch v0, :pswitch_data_0

    .line 8
    .line 9
    .line 10
    check-cast v2, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallAddon;

    .line 11
    .line 12
    check-cast v1, Ljava/lang/String;

    .line 13
    .line 14
    invoke-static {v2, v1, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallAddon;->$r8$lambda$ICwRMro1xkU7JLX-dXwpGXdbwlo(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallAddon;Ljava/lang/String;Landroid/view/View;)V

    .line 15
    .line 16
    .line 17
    return-void

    .line 18
    :pswitch_0
    check-cast v2, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;

    .line 19
    .line 20
    check-cast v1, Ljava/lang/CharSequence;

    .line 21
    .line 22
    invoke-static {v2, v1, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;->$r8$lambda$6FYQi1jKYtYgvlFAAIMQFNTAjQ0(Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;Ljava/lang/CharSequence;Landroid/view/View;)V

    .line 23
    .line 24
    .line 25
    return-void

    .line 26
    :pswitch_1
    check-cast v2, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;

    .line 27
    .line 28
    check-cast v1, Lcat/ereza/customactivityoncrash/config/CaocConfig;

    .line 29
    .line 30
    sget p1, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;->$r8$clinit:I

    .line 31
    .line 32
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 33
    .line 34
    .line 35
    invoke-static {v2, v1}, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->restartApplication(Landroid/app/Activity;Lcat/ereza/customactivityoncrash/config/CaocConfig;)V

    .line 36
    .line 37
    .line 38
    return-void

    .line 39
    :pswitch_2
    check-cast v2, Lcom/emanuelef/remote_capture/fragments/AppOverview;

    .line 40
    .line 41
    check-cast v1, Landroid/content/Context;

    .line 42
    .line 43
    invoke-static {v2, v1, p1}, Lcom/emanuelef/remote_capture/fragments/AppOverview;->$r8$lambda$F--zT3UFLC8p5Wvysj7yOE85lDs(Lcom/emanuelef/remote_capture/fragments/AppOverview;Landroid/content/Context;Landroid/view/View;)V

    .line 44
    .line 45
    .line 46
    return-void

    .line 47
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
