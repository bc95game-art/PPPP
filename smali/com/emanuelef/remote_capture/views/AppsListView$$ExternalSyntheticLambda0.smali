.class public final synthetic Lcom/emanuelef/remote_capture/views/AppsListView$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/views/AppsListView;

.field public final synthetic f$1:Lcom/emanuelef/remote_capture/views/AppsListView$OnSelectedAppListener;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/views/AppsListView;Lcom/emanuelef/remote_capture/views/AppsListView$OnSelectedAppListener;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/views/AppsListView$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/views/AppsListView;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/views/AppsListView$$ExternalSyntheticLambda0;->f$1:Lcom/emanuelef/remote_capture/views/AppsListView$OnSelectedAppListener;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppsListView$$ExternalSyntheticLambda0;->f$0:Lcom/emanuelef/remote_capture/views/AppsListView;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/views/AppsListView$$ExternalSyntheticLambda0;->f$1:Lcom/emanuelef/remote_capture/views/AppsListView$OnSelectedAppListener;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/views/AppsListView;->$r8$lambda$Mx84QBPaJxNvHoxhmzciMS5auHo(Lcom/emanuelef/remote_capture/views/AppsListView;Lcom/emanuelef/remote_capture/views/AppsListView$OnSelectedAppListener;Landroid/view/View;)V

    return-void
.end method
