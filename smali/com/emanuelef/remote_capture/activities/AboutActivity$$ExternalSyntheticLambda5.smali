.class public final synthetic Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

.field public final synthetic f$1:Landroid/view/View;

.field public final synthetic f$2:Landroid/graphics/Bitmap;

.field public final synthetic f$3:J


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/AboutActivity;Landroid/view/View;Landroid/graphics/Bitmap;J)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;->f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;->f$1:Landroid/view/View;

    iput-object p3, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;->f$2:Landroid/graphics/Bitmap;

    iput-wide p4, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;->f$3:J

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 5

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;->f$2:Landroid/graphics/Bitmap;

    iget-wide v1, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;->f$3:J

    iget-object v3, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;->f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

    iget-object v4, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda5;->f$1:Landroid/view/View;

    invoke-static {v3, v4, v0, v1, v2}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$0bGR5VcpMMAsjF6mBQDbvEGN6Ig(Lcom/emanuelef/remote_capture/activities/AboutActivity;Landroid/view/View;Landroid/graphics/Bitmap;J)V

    return-void
.end method
