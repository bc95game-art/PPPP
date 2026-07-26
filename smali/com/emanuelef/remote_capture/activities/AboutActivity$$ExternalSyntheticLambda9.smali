.class public final synthetic Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

.field public final synthetic f$1:Ljava/lang/String;

.field public final synthetic f$2:Landroid/os/Handler;

.field public final synthetic f$3:Landroid/view/View;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/AboutActivity;Ljava/lang/String;Landroid/os/Handler;Landroid/view/View;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;->f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;->f$1:Ljava/lang/String;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;->f$2:Landroid/os/Handler;

    iput-object p4, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;->f$3:Landroid/view/View;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;->f$2:Landroid/os/Handler;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;->f$3:Landroid/view/View;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;->f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

    iget-object v3, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda9;->f$1:Ljava/lang/String;

    invoke-static {v2, v3, v0, v1}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$L0BKmcsE_EfeOhWXqPaDq_tfrEs(Lcom/emanuelef/remote_capture/activities/AboutActivity;Ljava/lang/String;Landroid/os/Handler;Landroid/view/View;)V

    return-void
.end method
