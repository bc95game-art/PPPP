.class Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/appcompat/view/ActionMode$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

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
.method public onActionItemClicked(Landroidx/appcompat/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 2

    .line 1
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    .line 2
    .line 3
    .line 4
    move-result p2

    .line 5
    const v0, 0x7f0a02db

    .line 6
    .line 7
    .line 8
    const/4 v1, 0x1

    .line 9
    if-ne p2, v0, :cond_1

    .line 10
    .line 11
    iget-object p2, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    .line 12
    .line 13
    invoke-static {p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->-$$Nest$fgetmAdapter(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 14
    .line 15
    .line 16
    move-result-object p2

    .line 17
    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getSelectedCount()I

    .line 18
    .line 19
    .line 20
    move-result p2

    .line 21
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    .line 22
    .line 23
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->-$$Nest$fgetmAdapter(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->getItemCount()I

    .line 28
    .line 29
    .line 30
    move-result v0

    .line 31
    if-ne p2, v0, :cond_0

    .line 32
    .line 33
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 34
    .line 35
    .line 36
    return v1

    .line 37
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    .line 38
    .line 39
    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->-$$Nest$fgetmAdapter(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 40
    .line 41
    .line 42
    move-result-object p1

    .line 43
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->selectAll()V

    .line 44
    .line 45
    .line 46
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    .line 47
    .line 48
    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->-$$Nest$mupdateActionModeTitle(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V

    .line 49
    .line 50
    .line 51
    return v1

    .line 52
    :cond_1
    const p1, 0x7f0a02be

    .line 53
    .line 54
    .line 55
    if-ne p2, p1, :cond_2

    .line 56
    .line 57
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    .line 58
    .line 59
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->openFileSelector()V

    .line 60
    .line 61
    .line 62
    return v1

    .line 63
    :cond_2
    const p1, 0x7f0a02bf

    .line 64
    .line 65
    .line 66
    if-ne p2, p1, :cond_3

    .line 67
    .line 68
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    .line 69
    .line 70
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->openHarFileSelector()V

    .line 71
    .line 72
    .line 73
    return v1

    .line 74
    :cond_3
    const/4 p1, 0x0

    .line 75
    return p1
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method

.method public onCreateActionMode(Landroidx/appcompat/view/ActionMode;Landroid/view/Menu;)Z
    .locals 1

    .line 1
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->getMenuInflater()Landroid/view/MenuInflater;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    const v0, 0x7f0f0010

    .line 6
    .line 7
    .line 8
    invoke-virtual {p1, v0, p2}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 9
    .line 10
    .line 11
    const/4 p1, 0x1

    .line 12
    return p1
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
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method

.method public onDestroyActionMode(Landroidx/appcompat/view/ActionMode;)V
    .locals 0

    .line 1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    .line 2
    .line 3
    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->-$$Nest$fgetmAdapter(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/adapters/HttpLogAdapter;->clearSelection()V

    .line 8
    .line 9
    .line 10
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment$3;->this$0:Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;

    .line 11
    .line 12
    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->-$$Nest$fputmActionMode(Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;)V

    .line 13
    .line 14
    .line 15
    return-void
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

.method public onPrepareActionMode(Landroidx/appcompat/view/ActionMode;Landroid/view/Menu;)Z
    .locals 0

    const/4 p1, 0x0

    return p1
.end method
