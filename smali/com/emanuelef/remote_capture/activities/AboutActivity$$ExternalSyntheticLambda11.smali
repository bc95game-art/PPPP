.class public final synthetic Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

.field public final synthetic f$1:Ljava/lang/String;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/activities/AboutActivity;Ljava/lang/String;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;->f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;->f$1:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;->f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;->f$1:Ljava/lang/String;

    invoke-static {p1, v0, v1}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$eYyU0B6Es5UbzlH0K2uG5jBH5kM(Landroid/view/View;Lcom/emanuelef/remote_capture/activities/AboutActivity;Ljava/lang/String;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;->f$0:Lcom/emanuelef/remote_capture/activities/AboutActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/AboutActivity$$ExternalSyntheticLambda11;->f$1:Ljava/lang/String;

    invoke-static {p1, v0, v1}, Lcom/emanuelef/remote_capture/activities/AboutActivity;->$r8$lambda$xMAltApXJmWI7-Ci1iJp_cyDVcE(Landroid/view/View;Lcom/emanuelef/remote_capture/activities/AboutActivity;Ljava/lang/String;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
