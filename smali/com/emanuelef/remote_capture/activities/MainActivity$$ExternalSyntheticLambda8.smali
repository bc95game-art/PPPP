.class public final synthetic Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;

.field public final synthetic f$1:Landroid/net/Uri;

.field public final synthetic f$2:Ljava/lang/Object;

.field public final synthetic f$3:Ljava/lang/Object;

.field public final synthetic f$4:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;Landroid/net/Uri;Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;[ZLandroid/os/Handler;)V
    .locals 1

    .line 1
    const/4 v0, 0x1

    iput v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$1:Landroid/net/Uri;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$4:Ljava/lang/Object;

    iput-object p4, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    iput-object p5, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$3:Ljava/lang/Object;

    return-void
.end method

.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroid/net/Uri;Ljava/io/File;Ljava/lang/String;Landroid/net/Uri;)V
    .locals 1

    .line 2
    const/4 v0, 0x0

    iput v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$1:Landroid/net/Uri;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    iput-object p4, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$3:Ljava/lang/Object;

    iput-object p5, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$4:Ljava/lang/Object;

    return-void
.end method

.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/net/Uri;Ljava/lang/String;[ZLandroid/os/Handler;)V
    .locals 1

    .line 3
    const/4 v0, 0x2

    iput v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$1:Landroid/net/Uri;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$3:Ljava/lang/Object;

    iput-object p4, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$4:Ljava/lang/Object;

    iput-object p5, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 5

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$3:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$4:Ljava/lang/Object;

    check-cast v2, [Z

    iget-object v3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    check-cast v3, Landroid/os/Handler;

    iget-object v4, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$1:Landroid/net/Uri;

    invoke-static {v0, v4, v1, v2, v3}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$JdiiNLz_eSFgp4uRbtsMk5ttKK0(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Landroid/net/Uri;Ljava/lang/String;[ZLandroid/os/Handler;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$4:Ljava/lang/Object;

    check-cast v1, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    check-cast v2, [Z

    iget-object v3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$3:Ljava/lang/Object;

    check-cast v3, Landroid/os/Handler;

    iget-object v4, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$1:Landroid/net/Uri;

    invoke-static {v0, v4, v1, v2, v3}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->$r8$lambda$GK4n_-Nh8QrtCjKXpHHm2jywjvc(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;Landroid/net/Uri;Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;[ZLandroid/os/Handler;)V

    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$0:Ljava/lang/Object;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/MainActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$2:Ljava/lang/Object;

    check-cast v1, Ljava/io/File;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$3:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    iget-object v3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$4:Ljava/lang/Object;

    check-cast v3, Landroid/net/Uri;

    iget-object v4, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda8;->f$1:Landroid/net/Uri;

    invoke-static {v0, v4, v1, v2, v3}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$bU5CAYFnzBUCk35wKTuppImgQFg(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroid/net/Uri;Ljava/io/File;Ljava/lang/String;Landroid/net/Uri;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
