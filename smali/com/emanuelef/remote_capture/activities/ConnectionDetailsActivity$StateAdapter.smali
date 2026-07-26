.class Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;
.super Landroidx/viewpager2/adapter/FragmentStateAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "StateAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;Landroidx/fragment/app/FragmentActivity;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 2
    .line 3
    invoke-direct {p0, p2}, Landroidx/viewpager2/adapter/FragmentStateAdapter;-><init>(Landroidx/fragment/app/FragmentActivity;)V

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


# virtual methods
.method public createFragment(I)Landroidx/fragment/app/Fragment;
    .locals 2

    .line 1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->getVisibleTabsPositions()[I

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    aget p1, v0, p1

    .line 6
    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 8
    .line 9
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->-$$Nest$fgetmConn(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    iget v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 14
    .line 15
    const/4 v1, 0x1

    .line 16
    if-eq p1, v1, :cond_2

    .line 17
    .line 18
    const/4 v1, 0x2

    .line 19
    if-eq p1, v1, :cond_1

    .line 20
    .line 21
    const/4 v1, 0x3

    .line 22
    if-eq p1, v1, :cond_0

    .line 23
    .line 24
    invoke-static {v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;->newInstance(I)Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;

    .line 25
    .line 26
    .line 27
    move-result-object p1

    .line 28
    return-object p1

    .line 29
    :cond_0
    sget-object p1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->RAW:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 30
    .line 31
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->newInstance(Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;I)Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    .line 32
    .line 33
    .line 34
    move-result-object p1

    .line 35
    return-object p1

    .line 36
    :cond_1
    sget-object p1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->HTTP:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 37
    .line 38
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->newInstance(Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;I)Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    .line 39
    .line 40
    .line 41
    move-result-object p1

    .line 42
    return-object p1

    .line 43
    :cond_2
    sget-object p1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->WEBSOCKET:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 44
    .line 45
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->newInstance(Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;I)Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    .line 46
    .line 47
    .line 48
    move-result-object p1

    .line 49
    return-object p1
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public getItemCount()I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->-$$Nest$fgetmHasPayload(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    add-int/lit8 v0, v0, 0x1

    .line 8
    .line 9
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 10
    .line 11
    invoke-static {v1}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->-$$Nest$fgetmHasHttpTab(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    add-int/2addr v1, v0

    .line 16
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 17
    .line 18
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->-$$Nest$fgetmHasWsTab(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    add-int/2addr v0, v1

    .line 23
    return v0
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

.method public getPageTitle(I)I
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->getVisibleTabsPositions()[I

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    aget p1, v0, p1

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    if-eq p1, v0, :cond_2

    .line 9
    .line 10
    const/4 v0, 0x2

    .line 11
    if-eq p1, v0, :cond_1

    .line 12
    .line 13
    const/4 v0, 0x3

    .line 14
    if-eq p1, v0, :cond_0

    .line 15
    .line 16
    const p1, 0x7f140226

    .line 17
    .line 18
    .line 19
    return p1

    .line 20
    :cond_0
    const p1, 0x7f140235

    .line 21
    .line 22
    .line 23
    return p1

    .line 24
    :cond_1
    const p1, 0x7f140133

    .line 25
    .line 26
    .line 27
    return p1

    .line 28
    :cond_2
    const p1, 0x7f1402f4

    .line 29
    .line 30
    .line 31
    return p1
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

.method public getVisibleTabsPositions()[I
    .locals 4

    .line 1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->getItemCount()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    new-array v0, v0, [I

    .line 6
    .line 7
    const/4 v1, 0x0

    .line 8
    aput v1, v0, v1

    .line 9
    .line 10
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 11
    .line 12
    invoke-static {v1}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->-$$Nest$fgetmHasWsTab(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z

    .line 13
    .line 14
    .line 15
    move-result v1

    .line 16
    const/4 v2, 0x2

    .line 17
    const/4 v3, 0x1

    .line 18
    if-eqz v1, :cond_0

    .line 19
    .line 20
    aput v3, v0, v3

    .line 21
    .line 22
    const/4 v3, 0x2

    .line 23
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 24
    .line 25
    invoke-static {v1}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->-$$Nest$fgetmHasHttpTab(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z

    .line 26
    .line 27
    .line 28
    move-result v1

    .line 29
    if-eqz v1, :cond_1

    .line 30
    .line 31
    add-int/lit8 v1, v3, 0x1

    .line 32
    .line 33
    aput v2, v0, v3

    .line 34
    .line 35
    move v3, v1

    .line 36
    :cond_1
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;

    .line 37
    .line 38
    invoke-static {v1}, Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;->-$$Nest$fgetmHasPayload(Lcom/emanuelef/remote_capture/activities/ConnectionDetailsActivity;)Z

    .line 39
    .line 40
    .line 41
    move-result v1

    .line 42
    if-eqz v1, :cond_2

    .line 43
    .line 44
    const/4 v1, 0x3

    .line 45
    aput v1, v0, v3

    .line 46
    .line 47
    :cond_2
    return-object v0
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
