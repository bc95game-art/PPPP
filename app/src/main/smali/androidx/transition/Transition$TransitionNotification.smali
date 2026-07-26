.class public interface abstract Landroidx/transition/Transition$TransitionNotification;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final ON_CANCEL:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

.field public static final ON_END:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

.field public static final ON_PAUSE:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

.field public static final ON_RESUME:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

.field public static final ON_START:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 2
    .line 3
    const/16 v1, 0xf

    .line 4
    .line 5
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;-><init>(I)V

    .line 6
    .line 7
    .line 8
    sput-object v0, Landroidx/transition/Transition$TransitionNotification;->ON_START:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 9
    .line 10
    new-instance v0, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 11
    .line 12
    const/16 v1, 0x10

    .line 13
    .line 14
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;-><init>(I)V

    .line 15
    .line 16
    .line 17
    sput-object v0, Landroidx/transition/Transition$TransitionNotification;->ON_END:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 18
    .line 19
    new-instance v0, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 20
    .line 21
    const/16 v1, 0x11

    .line 22
    .line 23
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;-><init>(I)V

    .line 24
    .line 25
    .line 26
    sput-object v0, Landroidx/transition/Transition$TransitionNotification;->ON_CANCEL:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 27
    .line 28
    new-instance v0, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 29
    .line 30
    const/16 v1, 0x12

    .line 31
    .line 32
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;-><init>(I)V

    .line 33
    .line 34
    .line 35
    sput-object v0, Landroidx/transition/Transition$TransitionNotification;->ON_PAUSE:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 36
    .line 37
    new-instance v0, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 38
    .line 39
    const/16 v1, 0x13

    .line 40
    .line 41
    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;-><init>(I)V

    .line 42
    .line 43
    .line 44
    sput-object v0, Landroidx/transition/Transition$TransitionNotification;->ON_RESUME:Lcom/emanuelef/remote_capture/activities/BaseActivity$$ExternalSyntheticLambda0;

    .line 45
    .line 46
    return-void
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
.method public abstract notifyListener(Landroidx/transition/Transition$TransitionListener;Landroidx/transition/Transition;Z)V
.end method
