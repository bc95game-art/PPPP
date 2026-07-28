.class public final synthetic Lcom/maxmind/db/Decoder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/maxmind/db/NodeCache$Loader;


# instance fields
.field public final synthetic f$0:Lcom/maxmind/db/Decoder;


# direct methods
.method public synthetic constructor <init>(Lcom/maxmind/db/Decoder;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/maxmind/db/Decoder$$ExternalSyntheticLambda0;->f$0:Lcom/maxmind/db/Decoder;

    return-void
.end method


# virtual methods
.method public final load(Lcom/maxmind/db/CacheKey;)Lcom/maxmind/db/DecodedValue;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/maxmind/db/Decoder$$ExternalSyntheticLambda0;->f$0:Lcom/maxmind/db/Decoder;

    invoke-static {v0, p1}, Lcom/maxmind/db/Decoder;->$r8$lambda$dCT3gMSKQvQKVZTdio70HgBT03g(Lcom/maxmind/db/Decoder;Lcom/maxmind/db/CacheKey;)Lcom/maxmind/db/DecodedValue;

    move-result-object p1

    return-object p1
.end method
