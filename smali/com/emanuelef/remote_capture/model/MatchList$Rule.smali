.class public Lcom/emanuelef/remote_capture/model/MatchList$Rule;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/model/MatchList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Rule"
.end annotation


# instance fields
.field private final mLabel:Ljava/lang/String;

.field private final mType:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

.field private final mValue:Ljava/lang/Object;

.field final synthetic this$0:Lcom/emanuelef/remote_capture/model/MatchList;


# direct methods
.method private constructor <init>(Lcom/emanuelef/remote_capture/model/MatchList;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/Object;)V
    .locals 1

    .line 2
    iput-object p1, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->this$0:Lcom/emanuelef/remote_capture/model/MatchList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    invoke-static {p1}, Lcom/emanuelef/remote_capture/model/MatchList;->-$$Nest$fgetmContext(Lcom/emanuelef/remote_capture/model/MatchList;)Landroid/content/Context;

    move-result-object p1

    invoke-virtual {p3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, p2, v0}, Lcom/emanuelef/remote_capture/model/MatchList;->getRuleLabel(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mLabel:Ljava/lang/String;

    .line 4
    iput-object p2, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mType:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 5
    iput-object p3, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mValue:Ljava/lang/Object;

    return-void
.end method

.method public synthetic constructor <init>(Lcom/emanuelef/remote_capture/model/MatchList;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/model/MatchList$Rule;-><init>(Lcom/emanuelef/remote_capture/model/MatchList;Lcom/emanuelef/remote_capture/model/MatchList$RuleType;Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 2

    .line 1
    instance-of v0, p1, Lcom/emanuelef/remote_capture/model/MatchList$Rule;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    invoke-super {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 6
    .line 7
    .line 8
    move-result p1

    .line 9
    return p1

    .line 10
    :cond_0
    check-cast p1, Lcom/emanuelef/remote_capture/model/MatchList$Rule;

    .line 11
    .line 12
    iget-object v0, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mType:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 13
    .line 14
    iget-object v1, p1, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mType:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 15
    .line 16
    if-ne v0, v1, :cond_1

    .line 17
    .line 18
    iget-object v0, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mValue:Ljava/lang/Object;

    .line 19
    .line 20
    iget-object p1, p1, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mValue:Ljava/lang/Object;

    .line 21
    .line 22
    invoke-virtual {v0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 23
    .line 24
    .line 25
    move-result p1

    .line 26
    if-eqz p1, :cond_1

    .line 27
    .line 28
    const/4 p1, 0x1

    .line 29
    return p1

    .line 30
    :cond_1
    const/4 p1, 0x0

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

.method public getLabel()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mLabel:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
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

.method public getType()Lcom/emanuelef/remote_capture/model/MatchList$RuleType;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mType:Lcom/emanuelef/remote_capture/model/MatchList$RuleType;

    .line 2
    .line 3
    return-object v0
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

.method public getValue()Ljava/lang/Object;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/model/MatchList$Rule;->mValue:Ljava/lang/Object;

    .line 2
    .line 3
    return-object v0
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
