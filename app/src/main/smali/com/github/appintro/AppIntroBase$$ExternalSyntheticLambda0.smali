.class public final synthetic Lcom/github/appintro/AppIntroBase$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/github/appintro/AppIntroBase;


# direct methods
.method public synthetic constructor <init>(Lcom/github/appintro/AppIntroBase;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/github/appintro/AppIntroBase$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/github/appintro/AppIntroBase$$ExternalSyntheticLambda0;->f$0:Lcom/github/appintro/AppIntroBase;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/github/appintro/AppIntroBase$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/github/appintro/AppIntroBase$$ExternalSyntheticLambda0;->f$0:Lcom/github/appintro/AppIntroBase;

    invoke-static {v0, p1}, Lcom/github/appintro/AppIntroBase;->$r8$lambda$3YLOr4MyV7lE2Ud0OSKUSvWoe6Q(Lcom/github/appintro/AppIntroBase;Landroid/view/View;)V

    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/github/appintro/AppIntroBase$$ExternalSyntheticLambda0;->f$0:Lcom/github/appintro/AppIntroBase;

    invoke-static {v0, p1}, Lcom/github/appintro/AppIntroBase;->$r8$lambda$ujq7cZKlOy9AUTzE4yoT-67kPQ0(Lcom/github/appintro/AppIntroBase;Landroid/view/View;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
