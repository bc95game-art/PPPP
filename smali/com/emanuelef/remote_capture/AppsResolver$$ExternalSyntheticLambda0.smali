.class public final synthetic Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/DrawableLoader;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcom/emanuelef/remote_capture/AppsResolver;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/AppsResolver;I)V
    .locals 0

    .line 1
    iput p2, p0, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p1, p0, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/AppsResolver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final getDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/AppsResolver;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/AppsResolver;->$r8$lambda$wvcGQXlQZqcw5SBXWgieCW-pTkM(Lcom/emanuelef/remote_capture/AppsResolver;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0

    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/AppsResolver$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/AppsResolver;

    invoke-static {v0}, Lcom/emanuelef/remote_capture/AppsResolver;->$r8$lambda$fTOEB5gGAPptG0aAPiR_g7M1s6s(Lcom/emanuelef/remote_capture/AppsResolver;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method
