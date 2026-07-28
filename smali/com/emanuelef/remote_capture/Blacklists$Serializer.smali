.class Lcom/emanuelef/remote_capture/Blacklists$Serializer;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/gson/JsonSerializer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/Blacklists;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Serializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/gson/JsonSerializer;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/emanuelef/remote_capture/Blacklists$Serializer;-><init>()V

    return-void
.end method


# virtual methods
.method public serialize(Lcom/emanuelef/remote_capture/Blacklists;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;
    .locals 9

    .line 2
    new-instance p2, Lcom/google/gson/JsonObject;

    invoke-direct {p2}, Lcom/google/gson/JsonObject;-><init>()V

    .line 3
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Blacklists;->-$$Nest$fgetmLists(Lcom/emanuelef/remote_capture/Blacklists;)Ljava/util/ArrayList;

    move-result-object p3

    invoke-virtual {p3}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    const-string v2, "last_update"

    if-ge v1, v0, :cond_0

    invoke-virtual {p3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    add-int/lit8 v1, v1, 0x1

    check-cast v3, Lcom/emanuelef/remote_capture/model/BlacklistDescriptor;

    .line 4
    new-instance v4, Lcom/google/gson/JsonObject;

    invoke-direct {v4}, Lcom/google/gson/JsonObject;-><init>()V

    .line 5
    new-instance v5, Lcom/google/gson/JsonPrimitive;

    iget v6, v3, Lcom/emanuelef/remote_capture/model/BlacklistDescriptor;->num_rules:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-direct {v5, v6}, Lcom/google/gson/JsonPrimitive;-><init>(Ljava/lang/Number;)V

    .line 6
    iget-object v6, v4, Lcom/google/gson/JsonObject;->members:Lcom/google/gson/internal/LinkedTreeMap;

    const-string v7, "num_rules"

    invoke-virtual {v6, v7, v5}, Lcom/google/gson/internal/LinkedTreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 7
    new-instance v5, Lcom/google/gson/JsonPrimitive;

    invoke-virtual {v3}, Lcom/emanuelef/remote_capture/model/BlacklistDescriptor;->getLastUpdate()J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-direct {v5, v7}, Lcom/google/gson/JsonPrimitive;-><init>(Ljava/lang/Number;)V

    .line 8
    invoke-virtual {v6, v2, v5}, Lcom/google/gson/internal/LinkedTreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    iget-object v2, v3, Lcom/emanuelef/remote_capture/model/BlacklistDescriptor;->fname:Ljava/lang/String;

    invoke-virtual {p2, v2, v4}, Lcom/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/google/gson/JsonElement;)V

    goto :goto_0

    .line 10
    :cond_0
    new-instance p3, Lcom/google/gson/JsonObject;

    invoke-direct {p3}, Lcom/google/gson/JsonObject;-><init>()V

    .line 11
    new-instance v0, Lcom/google/gson/JsonPrimitive;

    invoke-static {p1}, Lcom/emanuelef/remote_capture/Blacklists;->-$$Nest$fgetmLastUpdate(Lcom/emanuelef/remote_capture/Blacklists;)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/google/gson/JsonPrimitive;-><init>(Ljava/lang/Number;)V

    .line 12
    iget-object v1, p3, Lcom/google/gson/JsonObject;->members:Lcom/google/gson/internal/LinkedTreeMap;

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/internal/LinkedTreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 13
    new-instance v0, Lcom/google/gson/JsonPrimitive;

    invoke-static {p1}, Lcom/emanuelef/remote_capture/Blacklists;->-$$Nest$fgetmNumDomainRules(Lcom/emanuelef/remote_capture/Blacklists;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/google/gson/JsonPrimitive;-><init>(Ljava/lang/Number;)V

    .line 14
    const-string v2, "num_domain_rules"

    invoke-virtual {v1, v2, v0}, Lcom/google/gson/internal/LinkedTreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 15
    new-instance v0, Lcom/google/gson/JsonPrimitive;

    invoke-static {p1}, Lcom/emanuelef/remote_capture/Blacklists;->-$$Nest$fgetmNumIPRules(Lcom/emanuelef/remote_capture/Blacklists;)I

    move-result p1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-direct {v0, p1}, Lcom/google/gson/JsonPrimitive;-><init>(Ljava/lang/Number;)V

    .line 16
    const-string p1, "num_ip_rules"

    invoke-virtual {v1, p1, v0}, Lcom/google/gson/internal/LinkedTreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    const-string p1, "blacklists"

    .line 18
    invoke-virtual {v1, p1, p2}, Lcom/google/gson/internal/LinkedTreeMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-object p3
.end method

.method public bridge synthetic serialize(Ljava/lang/Object;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;
    .locals 0

    .line 1
    check-cast p1, Lcom/emanuelef/remote_capture/Blacklists;

    invoke-virtual {p0, p1, p2, p3}, Lcom/emanuelef/remote_capture/Blacklists$Serializer;->serialize(Lcom/emanuelef/remote_capture/Blacklists;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;

    move-result-object p1

    return-object p1
.end method
