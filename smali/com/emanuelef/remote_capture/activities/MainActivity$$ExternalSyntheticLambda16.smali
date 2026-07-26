.class public final synthetic Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

.field public final synthetic f$1:Ljava/lang/String;

.field public final synthetic f$2:Landroid/net/Uri;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroid/net/Uri;Ljava/lang/String;)V
    .locals 1

    .line 1
    const/4 v0, 0x1

    iput v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$2:Landroid/net/Uri;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$1:Ljava/lang/String;

    return-void
.end method

.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/MainActivity;Ljava/lang/String;Landroid/net/Uri;)V
    .locals 1

    .line 2
    const/4 v0, 0x0

    iput v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$1:Ljava/lang/String;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$2:Landroid/net/Uri;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$2:Landroid/net/Uri;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$1:Ljava/lang/String;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-static {v2, v0, v1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$k_HijFVD4FIn8W0BzfWzXelSxiA(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroid/net/Uri;Ljava/lang/String;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$1:Ljava/lang/String;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$2:Landroid/net/Uri;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda16;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    invoke-static {v2, v1, v0}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$kF51DacxpGTklbE_LtJoFBZRa0c(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroid/net/Uri;Ljava/lang/String;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
