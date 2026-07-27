.class Lcom/emanuelef/remote_capture/fragments/EditListFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/views/AppSelectDialog$AppSelectListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/emanuelef/remote_capture/fragments/EditListFragment;->showAddAppRule()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/fragments/EditListFragment;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$2;->this$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method


# virtual methods
.method public onAppSelectionAborted()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$2;->this$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->-$$Nest$mabortAppSelection(Lcom/emanuelef/remote_capture/fragments/EditListFragment;)V

    .line 4
    .line 5
    .line 6
    return-void
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
.end method

.method public onSelectedApp(Lcom/emanuelef/remote_capture/model/AppDescriptor;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$2;->this$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->-$$Nest$mabortAppSelection(Lcom/emanuelef/remote_capture/fragments/EditListFragment;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$2;->this$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    .line 7
    .line 8
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->-$$Nest$fgetmList(Lcom/emanuelef/remote_capture/fragments/EditListFragment;)Lcom/emanuelef/remote_capture/model/MatchList;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object p1

    .line 16
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/model/MatchList;->addApp(Ljava/lang/String;)Z

    .line 17
    .line 18
    .line 19
    move-result p1

    .line 20
    if-nez p1, :cond_0

    .line 21
    .line 22
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$2;->this$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    .line 23
    .line 24
    invoke-virtual {p1}, Landroidx/fragment/app/Fragment;->requireContext()Landroid/content/Context;

    .line 25
    .line 26
    .line 27
    move-result-object p1

    .line 28
    const/4 v0, 0x0

    .line 29
    new-array v0, v0, [Ljava/lang/Object;

    .line 30
    .line 31
    const v1, 0x7f140278

    .line 32
    .line 33
    .line 34
    invoke-static {p1, v1, v0}, Lcom/emanuelef/remote_capture/Utils;->showToastLong(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 35
    .line 36
    .line 37
    return-void

    .line 38
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/EditListFragment$2;->this$0:Lcom/emanuelef/remote_capture/fragments/EditListFragment;

    .line 39
    .line 40
    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/EditListFragment;->-$$Nest$msaveAndReload(Lcom/emanuelef/remote_capture/fragments/EditListFragment;)V

    .line 41
    .line 42
    .line 43
    return-void
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method
