.class public final synthetic Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/views/AppsListView$OnSelectedAppListener;


# instance fields
.field public final synthetic f$0:Lcom/emanuelef/remote_capture/views/AppSelectDialog;

.field public final synthetic f$1:Landroidx/appcompat/app/AlertDialog;


# direct methods
.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/views/AppSelectDialog;Landroidx/appcompat/app/AlertDialog;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/views/AppSelectDialog;

    iput-object p2, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda1;->f$1:Landroidx/appcompat/app/AlertDialog;

    return-void
.end method


# virtual methods
.method public final onSelectedApp(Lcom/emanuelef/remote_capture/model/AppDescriptor;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda1;->f$0:Lcom/emanuelef/remote_capture/views/AppSelectDialog;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/views/AppSelectDialog$$ExternalSyntheticLambda1;->f$1:Landroidx/appcompat/app/AlertDialog;

    invoke-static {v0, v1, p1}, Lcom/emanuelef/remote_capture/views/AppSelectDialog;->$r8$lambda$lsfcD1PAIejPUSUCtfav96BIYy0(Lcom/emanuelef/remote_capture/views/AppSelectDialog;Landroidx/appcompat/app/AlertDialog;Lcom/emanuelef/remote_capture/model/AppDescriptor;)V

    return-void
.end method
