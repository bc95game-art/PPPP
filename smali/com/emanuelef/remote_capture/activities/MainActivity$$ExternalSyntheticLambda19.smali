.class public final synthetic Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

.field public final synthetic f$1:Z

.field public final synthetic f$2:Ljava/io/File;

.field public final synthetic f$3:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/MainActivity;ZLjava/io/File;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    iput-boolean p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;->f$1:Z

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;->f$2:Ljava/io/File;

    iput-object p4, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;->f$3:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;->f$2:Ljava/io/File;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;->f$3:Ljava/lang/String;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;->f$0:Lcom/emanuelef/remote_capture/activities/MainActivity;

    iget-boolean v3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda19;->f$1:Z

    invoke-static {v2, v3, v0, v1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$46d66vQwX5t0nhikWZWxZpta5Tw(Lcom/emanuelef/remote_capture/activities/MainActivity;ZLjava/io/File;Ljava/lang/String;)V

    return-void
.end method
