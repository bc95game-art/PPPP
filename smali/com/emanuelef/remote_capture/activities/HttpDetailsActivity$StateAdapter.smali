.class Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;
.super Landroidx/viewpager2/adapter/FragmentStateAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "StateAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;Landroidx/fragment/app/FragmentActivity;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

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
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->-$$Nest$fgetmHttpReq(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;)Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->getPosition()I

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->getVisibleTabsPositions()[I

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    aget p1, v1, p1

    .line 16
    .line 17
    const/4 v1, 0x1

    .line 18
    if-eq p1, v1, :cond_1

    .line 19
    .line 20
    const/4 v1, 0x2

    .line 21
    if-eq p1, v1, :cond_0

    .line 22
    .line 23
    const/4 p1, 0x0

    .line 24
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;->newInstance(IZ)Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;

    .line 25
    .line 26
    .line 27
    move-result-object p1

    .line 28
    return-object p1

    .line 29
    :cond_0
    sget-object p1, Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;->WEBSOCKET:Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;

    .line 30
    .line 31
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    .line 32
    .line 33
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->-$$Nest$fgetmHttpReq(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;)Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 34
    .line 35
    .line 36
    move-result-object v0

    .line 37
    iget-object v0, v0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 38
    .line 39
    iget v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 40
    .line 41
    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->newInstance(Lcom/emanuelef/remote_capture/model/PayloadChunk$ChunkType;I)Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;

    .line 42
    .line 43
    .line 44
    move-result-object p1

    .line 45
    return-object p1

    .line 46
    :cond_1
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;->newInstance(IZ)Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;

    .line 47
    .line 48
    .line 49
    move-result-object p1

    .line 50
    return-object p1
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method

.method public getItemCount()I
    .locals 3

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->-$$Nest$fgetmHttpReq(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;)Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v0, v0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->reply:Lcom/emanuelef/remote_capture/HttpLog$HttpReply;

    .line 8
    .line 9
    const/4 v1, 0x1

    .line 10
    if-eqz v0, :cond_0

    .line 11
    .line 12
    const/4 v0, 0x2

    .line 13
    goto :goto_0

    .line 14
    :cond_0
    const/4 v0, 0x1

    .line 15
    :goto_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    .line 16
    .line 17
    invoke-static {v2}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->-$$Nest$fgetmHasWebsocket(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;)Z

    .line 18
    .line 19
    .line 20
    move-result v2

    .line 21
    if-eqz v2, :cond_1

    .line 22
    .line 23
    add-int/2addr v0, v1

    .line 24
    :cond_1
    return v0
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
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->getVisibleTabsPositions()[I

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
    if-eq p1, v0, :cond_1

    .line 9
    .line 10
    const/4 v0, 0x2

    .line 11
    if-eq p1, v0, :cond_0

    .line 12
    .line 13
    const p1, 0x7f140268

    .line 14
    .line 15
    .line 16
    return p1

    .line 17
    :cond_0
    const p1, 0x7f1402f4

    .line 18
    .line 19
    .line 20
    return p1

    .line 21
    :cond_1
    const p1, 0x7f14026f

    .line 22
    .line 23
    .line 24
    return p1
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

.method public getVisibleTabsPositions()[I
    .locals 4

    .line 1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->getItemCount()I

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
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    .line 11
    .line 12
    invoke-static {v1}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->-$$Nest$fgetmHttpReq(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;)Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    .line 13
    .line 14
    .line 15
    move-result-object v1

    .line 16
    iget-object v1, v1, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->reply:Lcom/emanuelef/remote_capture/HttpLog$HttpReply;

    .line 17
    .line 18
    const/4 v2, 0x2

    .line 19
    const/4 v3, 0x1

    .line 20
    if-eqz v1, :cond_0

    .line 21
    .line 22
    aput v3, v0, v3

    .line 23
    .line 24
    const/4 v3, 0x2

    .line 25
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity$StateAdapter;->this$0:Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;

    .line 26
    .line 27
    invoke-static {v1}, Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;->-$$Nest$fgetmHasWebsocket(Lcom/emanuelef/remote_capture/activities/HttpDetailsActivity;)Z

    .line 28
    .line 29
    .line 30
    move-result v1

    .line 31
    if-eqz v1, :cond_1

    .line 32
    .line 33
    aput v2, v0, v3

    .line 34
    .line 35
    :cond_1
    return-object v0
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
