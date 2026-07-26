.class public Lcom/emanuelef/remote_capture/model/AppStats;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Cloneable;


# instance fields
.field public numBlockedConnections:I

.field public numConnections:I

.field public rcvdBytes:J

.field public sentBytes:J

.field private final uid:I


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput p1, p0, Lcom/emanuelef/remote_capture/model/AppStats;->uid:I

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
.method public clone()Lcom/emanuelef/remote_capture/model/AppStats;
    .locals 3

    .line 2
    new-instance v0, Lcom/emanuelef/remote_capture/model/AppStats;

    iget v1, p0, Lcom/emanuelef/remote_capture/model/AppStats;->uid:I

    invoke-direct {v0, v1}, Lcom/emanuelef/remote_capture/model/AppStats;-><init>(I)V

    .line 3
    iget-wide v1, p0, Lcom/emanuelef/remote_capture/model/AppStats;->sentBytes:J

    iput-wide v1, v0, Lcom/emanuelef/remote_capture/model/AppStats;->sentBytes:J

    .line 4
    iget-wide v1, p0, Lcom/emanuelef/remote_capture/model/AppStats;->rcvdBytes:J

    iput-wide v1, v0, Lcom/emanuelef/remote_capture/model/AppStats;->rcvdBytes:J

    .line 5
    iget v1, p0, Lcom/emanuelef/remote_capture/model/AppStats;->numConnections:I

    iput v1, v0, Lcom/emanuelef/remote_capture/model/AppStats;->numConnections:I

    .line 6
    iget v1, p0, Lcom/emanuelef/remote_capture/model/AppStats;->numBlockedConnections:I

    iput v1, v0, Lcom/emanuelef/remote_capture/model/AppStats;->numBlockedConnections:I

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/model/AppStats;->clone()Lcom/emanuelef/remote_capture/model/AppStats;

    move-result-object v0

    return-object v0
.end method

.method public getUid()I
    .locals 1

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/model/AppStats;->uid:I

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
