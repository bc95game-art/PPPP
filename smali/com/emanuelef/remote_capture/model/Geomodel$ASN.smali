.class public Lcom/emanuelef/remote_capture/model/Geomodel$ASN;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/model/Geomodel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ASN"
.end annotation


# instance fields
.field public final asname:Ljava/lang/String;

.field public final number:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x0

    .line 2
    iput-wide v0, p0, Lcom/emanuelef/remote_capture/model/Geomodel$ASN;->number:J

    .line 3
    const-string v0, ""

    iput-object v0, p0, Lcom/emanuelef/remote_capture/model/Geomodel$ASN;->asname:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1    # J
        .annotation runtime Lcom/maxmind/db/MaxMindDbParameter;
            name = "autonomous_system_number"
        .end annotation
    .end param
    .param p3    # Ljava/lang/String;
        .annotation runtime Lcom/maxmind/db/MaxMindDbParameter;
            name = "autonomous_system_organization"
        .end annotation
    .end param
    .annotation runtime Lcom/maxmind/db/MaxMindDbConstructor;
    .end annotation

    .line 4
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 5
    iput-wide p1, p0, Lcom/emanuelef/remote_capture/model/Geomodel$ASN;->number:J

    .line 6
    iput-object p3, p0, Lcom/emanuelef/remote_capture/model/Geomodel$ASN;->asname:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public isKnown()Z
    .locals 5

    .line 1
    iget-wide v0, p0, Lcom/emanuelef/remote_capture/model/Geomodel$ASN;->number:J

    .line 2
    .line 3
    const-wide/16 v2, 0x0

    .line 4
    .line 5
    cmp-long v4, v0, v2

    .line 6
    .line 7
    if-eqz v4, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    return v0

    .line 11
    :cond_0
    const/4 v0, 0x0

    .line 12
    return v0
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

.method public toString()Ljava/lang/String;
    .locals 5

    .line 1
    iget-wide v0, p0, Lcom/emanuelef/remote_capture/model/Geomodel$ASN;->number:J

    .line 2
    .line 3
    const-wide/16 v2, 0x0

    .line 4
    .line 5
    cmp-long v4, v0, v2

    .line 6
    .line 7
    if-nez v4, :cond_0

    .line 8
    .line 9
    const-string v0, "Unknown ASN"

    .line 10
    .line 11
    return-object v0

    .line 12
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    .line 13
    .line 14
    const-string v1, "AS"

    .line 15
    .line 16
    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 17
    .line 18
    .line 19
    iget-wide v1, p0, Lcom/emanuelef/remote_capture/model/Geomodel$ASN;->number:J

    .line 20
    .line 21
    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 22
    .line 23
    .line 24
    const-string v1, " - "

    .line 25
    .line 26
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 27
    .line 28
    .line 29
    iget-object v1, p0, Lcom/emanuelef/remote_capture/model/Geomodel$ASN;->asname:Ljava/lang/String;

    .line 30
    .line 31
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 32
    .line 33
    .line 34
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 35
    .line 36
    .line 37
    move-result-object v0

    .line 38
    return-object v0
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
