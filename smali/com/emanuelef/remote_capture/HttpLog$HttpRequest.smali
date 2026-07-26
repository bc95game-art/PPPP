.class public Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/HttpLog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HttpRequest"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable<",
        "Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;",
        ">;"
    }
.end annotation


# instance fields
.field public bodyLength:I

.field public final conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

.field public decryptionError:Ljava/lang/String;

.field public final firstChunkPos:I

.field public host:Ljava/lang/String;

.field public httpRst:Z

.field private idx:I

.field public method:Ljava/lang/String;

.field public path:Ljava/lang/String;

.field public query:Ljava/lang/String;

.field public reply:Lcom/emanuelef/remote_capture/HttpLog$HttpReply;

.field public streamId:I

.field public timestamp:J


# direct methods
.method public static bridge synthetic -$$Nest$fgetidx(Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;)I
    .locals 0

    .line 1
    iget p0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->idx:I

    return p0
.end method

.method public static bridge synthetic -$$Nest$fputidx(Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;I)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->idx:I

    return-void
.end method

.method public constructor <init>(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;I)V
    .locals 3

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const-string v0, ""

    .line 5
    .line 6
    iput-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->method:Ljava/lang/String;

    .line 7
    .line 8
    iput-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->host:Ljava/lang/String;

    .line 9
    .line 10
    iput-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->path:Ljava/lang/String;

    .line 11
    .line 12
    iput-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->query:Ljava/lang/String;

    .line 13
    .line 14
    iput-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->decryptionError:Ljava/lang/String;

    .line 15
    .line 16
    const/4 v0, 0x0

    .line 17
    iput v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->bodyLength:I

    .line 18
    .line 19
    iput v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->streamId:I

    .line 20
    .line 21
    const-wide/16 v1, 0x0

    .line 22
    .line 23
    iput-wide v1, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->timestamp:J

    .line 24
    .line 25
    iput-boolean v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->httpRst:Z

    .line 26
    .line 27
    const/4 v0, -0x1

    .line 28
    iput v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->idx:I

    .line 29
    .line 30
    iput-object p1, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 31
    .line 32
    iput p2, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->firstChunkPos:I

    .line 33
    .line 34
    return-void
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
.method public compareTo(Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;)I
    .locals 4

    .line 2
    iget-wide v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->timestamp:J

    iget-wide v2, p1, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->timestamp:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Long;->compare(JJ)I

    move-result p1

    return p1
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p1, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;

    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->compareTo(Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;)I

    move-result p1

    return p1
.end method

.method public getPosition()I
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->idx:I

    .line 2
    .line 3
    return v0
    .line 4
    .line 5
    .line 6
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

.method public getProtoAndHost()Ljava/lang/String;
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->host:Ljava/lang/String;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const-string v1, ""

    .line 8
    .line 9
    if-nez v0, :cond_0

    .line 10
    .line 11
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->host:Ljava/lang/String;

    .line 12
    .line 13
    goto :goto_0

    .line 14
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 15
    .line 16
    iget-object v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 17
    .line 18
    invoke-static {v0, v1}, Lj$/util/Objects;->requireNonNullElse(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    check-cast v0, Ljava/lang/String;

    .line 23
    .line 24
    :goto_0
    iget-object v2, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 25
    .line 26
    iget-object v2, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->l7proto:Ljava/lang/String;

    .line 27
    .line 28
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    .line 29
    .line 30
    .line 31
    move-result-object v2

    .line 32
    const-string v3, "http"

    .line 33
    .line 34
    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 35
    .line 36
    .line 37
    move-result v2

    .line 38
    if-eqz v2, :cond_2

    .line 39
    .line 40
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 41
    .line 42
    invoke-virtual {v1}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isCleartext()Z

    .line 43
    .line 44
    .line 45
    move-result v1

    .line 46
    if-eqz v1, :cond_1

    .line 47
    .line 48
    const-string v1, "http://"

    .line 49
    .line 50
    goto :goto_1

    .line 51
    :cond_1
    const-string v1, "https://"

    .line 52
    .line 53
    :cond_2
    :goto_1
    invoke-static {v1, v0}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 54
    .line 55
    .line 56
    move-result-object v0

    .line 57
    return-object v0
    .line 58
.end method

.method public getUrl()Ljava/lang/String;
    .locals 4

    .line 1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->getProtoAndHost()Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->path:Ljava/lang/String;

    .line 6
    .line 7
    iget-object v2, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->query:Ljava/lang/String;

    .line 8
    .line 9
    new-instance v3, Ljava/lang/StringBuilder;

    .line 10
    .line 11
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 12
    .line 13
    .line 14
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 15
    .line 16
    .line 17
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 18
    .line 19
    .line 20
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 21
    .line 22
    .line 23
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    return-object v0
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

.method public hasWebsocketData()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->conn:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 2
    .line 3
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->hasWebsocketData()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
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

.method public matches(Ljava/lang/String;)Z
    .locals 1

    .line 1
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->getUrl()Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    invoke-virtual {v0, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    .line 14
    .line 15
    .line 16
    move-result v0

    .line 17
    if-nez v0, :cond_1

    .line 18
    .line 19
    iget-object v0, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->reply:Lcom/emanuelef/remote_capture/HttpLog$HttpReply;

    .line 20
    .line 21
    if-eqz v0, :cond_0

    .line 22
    .line 23
    iget-object v0, v0, Lcom/emanuelef/remote_capture/HttpLog$HttpReply;->contentType:Ljava/lang/String;

    .line 24
    .line 25
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    invoke-virtual {v0, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    .line 30
    .line 31
    .line 32
    move-result p1

    .line 33
    if-eqz p1, :cond_0

    .line 34
    .line 35
    goto :goto_0

    .line 36
    :cond_0
    const/4 p1, 0x0

    .line 37
    return p1

    .line 38
    :cond_1
    :goto_0
    const/4 p1, 0x1

    .line 39
    return p1
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

.method public toString()Ljava/lang/String;
    .locals 2

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    const-string v1, "HTTP request: "

    .line 4
    .line 5
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    iget-object v1, p0, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->method:Ljava/lang/String;

    .line 9
    .line 10
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 11
    .line 12
    .line 13
    const-string v1, " "

    .line 14
    .line 15
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 16
    .line 17
    .line 18
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/HttpLog$HttpRequest;->getUrl()Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 23
    .line 24
    .line 25
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    return-object v0
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
