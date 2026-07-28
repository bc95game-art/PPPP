.class public final synthetic Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Landroidx/appcompat/app/AppCompatActivity;

.field public final synthetic f$1:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Object;I)V
    .locals 0

    .line 1
    iput p3, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;->f$1:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/ErrorActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;->f$1:Ljava/lang/Object;

    check-cast v1, Landroid/content/Intent;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/activities/ErrorActivity;->$r8$lambda$nNwUsVWiKCacab_KmRonihc71g0(Lcom/emanuelef/remote_capture/activities/ErrorActivity;Landroid/content/Intent;Landroid/view/View;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    check-cast v0, Lcom/emanuelef/remote_capture/activities/MainActivity;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/MainActivity$$ExternalSyntheticLambda5;->f$1:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$LpnW1bPv_XpwUtjL2CMwa84PCNs(Lcom/emanuelef/remote_capture/activities/MainActivity;Ljava/lang/String;Landroid/view/View;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
